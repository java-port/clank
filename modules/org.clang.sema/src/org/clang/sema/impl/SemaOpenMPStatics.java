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

import static org.clank.support.Native.$Deref;
import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
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
import org.clang.ast.OMPClauseMappableExprCommon.*;
import org.clang.basic.*;
import org.clang.sema.*;
import org.clank.java.stdimpl.aliases.*;
import static org.clang.basic.BasicClangGlobals.*;
import static org.clang.sema.Sema_NestedClasses.SemaDiagnosticBuilder.*;
import static org.clang.sema.SemaClangGlobals.*;
import static org.clang.sema.java.SemaFunctionPointers.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.DeclarationName.*;
import org.clang.ast.OMPExecutableDirective.*;
import static org.clang.ast.specific_attr_iterator.*;
import org.clang.sema.impl.DSAStackTy.*;
import static org.clang.sema.impl.SemaOpenMPStatics.*;
import static org.clang.ast.java.AstStatementsRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.java.AstTypesRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type SemaOpenMPStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=Tpl__ZL18filterLookupForUDRRN4llvm15SmallVectorImplIN5clang13UnresolvedSetILj8EEEEERKNS_12function_refIFT_PNS1_9ValueDeclEEEE;_ZL12HasMapClauseN4llvm8ArrayRefIPN5clang9OMPClauseEEE;_ZL12buildCaptureRN5clang4SemaEPNS_4ExprERPNS_11DeclRefExprE;_ZL12buildCaptureRN5clang4SemaEPNS_9ValueDeclEPNS_4ExprEb;_ZL12buildVarDeclRN5clang4SemaENS_14SourceLocationENS_8QualTypeEN4llvm9StringRefEPKNS4_11SmallVectorIPNS_4AttrELj2EEE;_ZL13buildPreInitsRN5clang10ASTContextERN4llvm15SmallVectorImplIPNS_4DeclEEE;_ZL13buildPreInitsRN5clang10ASTContextERN4llvm9MapVectorIPNS_4ExprEPNS_11DeclRefExprENS2_8DenseMapIS5_jNS2_12DenseMapInfoIS5_EENS2_6detail12DenseMapPairIS5_jEEEESt6vectorISt4pairIS5_S7_ESaISH_EEEE;_ZL14checkIfClausesRN5clang4SemaENS_19OpenMPDirectiveKindEN4llvm8ArrayRefIPNS_9OMPClauseEEENS4_IS2_EE;_ZL14getPrivateItemRN5clang4SemaERPNS_4ExprERNS_14SourceLocationERNS_11SourceRangeEb;_ZL15CheckOpenMPLoopN5clang19OpenMPDirectiveKindEPNS_4ExprES2_PNS_4StmtERNS_4SemaERN12_GLOBAL__N_110DSAStackTyERN4llvm8DenseMapIPNS_9ValueDeclES2_NSA_12DenseMapInfoISD_EENSA_6detail12DenseMapPairISD_S2_EEEERNS_16OMPLoopDirective11HelperExprsE;_ZL15buildPostUpdateRN5clang4SemaEN4llvm8ArrayRefIPNS_4ExprEEE;_ZL16BuildCounterInitRN5clang4SemaEPNS_5ScopeENS_14SourceLocationENS_12ActionResultIPNS_4ExprELb1EEES8_RN4llvm9MapVectorIS7_PNS_11DeclRefExprENS9_8DenseMapIS7_jNS9_12DenseMapInfoIS7_EENS9_6detail12DenseMapPairIS7_jEEEESt6vectorISt4pairIS7_SC_ESaISM_EEEE;_ZL16buildCaptureDeclRN5clang4SemaEPNS_14IdentifierInfoEPNS_4ExprEbb;_ZL16buildDeclRefExprRN5clang4SemaEPNS_7VarDeclENS_8QualTypeENS_14SourceLocationEb;_ZL16getCanonicalDeclPN5clang9ValueDeclE;_ZL17CheckMapConflictsRN5clang4SemaEPN12_GLOBAL__N_110DSAStackTyEPNS_9ValueDeclEPNS_4ExprEbN4llvm8ArrayRefINS_27OMPClauseMappableExprCommon17MappableComponentEEENS_16OpenMPClauseKindE;_ZL17CheckTypeMappableN5clang14SourceLocationENS_11SourceRangeERNS_4SemaEPN12_GLOBAL__N_110DSAStackTyENS_8QualTypeE;_ZL17ReportOriginalDSARN5clang4SemaEPN12_GLOBAL__N_110DSAStackTyEPKNS_9ValueDeclENS3_10DSAVarDataEb;_ZL18BuildCounterUpdateRN5clang4SemaEPNS_5ScopeENS_14SourceLocationENS_12ActionResultIPNS_4ExprELb1EEES8_S8_S8_bPN4llvm9MapVectorIS7_PNS_11DeclRefExprENS9_8DenseMapIS7_jNS9_12DenseMapInfoIS7_EENS9_6detail12DenseMapPairIS7_jEEEESt6vectorISt4pairIS7_SC_ESaISM_EEEE;_ZL19WidenIterationCountjPN5clang4ExprERNS_4SemaE;_ZL20getOrderedNumberExprN4llvm8ArrayRefIPN5clang9OMPClauseEEE;_ZL21CheckNestingOfRegionsRN5clang4SemaEPN12_GLOBAL__N_110DSAStackTyENS_19OpenMPDirectiveKindERKNS_19DeclarationNameInfoES5_NS_14SourceLocationE;_ZL21getCollapseNumberExprN4llvm8ArrayRefIPN5clang9OMPClauseEEE;_ZL22IsCXXRecordForMappableRN5clang4SemaENS_14SourceLocationEPN12_GLOBAL__N_110DSAStackTyEPNS_13CXXRecordDeclE;_ZL22checkScheduleModifiersRN5clang4SemaENS_28OpenMPScheduleClauseModifierES2_NS_14SourceLocationES3_;_ZL22checkValueDeclInTargetN5clang14SourceLocationENS_11SourceRangeERNS_4SemaEPN12_GLOBAL__N_110DSAStackTyEPNS_9ValueDeclE;_ZL23getListOfPossibleValuesN5clang16OpenMPClauseKindEjjN4llvm8ArrayRefIjEE;_ZL24FinishOpenMPLinearClauseRN5clang15OMPLinearClauseEPNS_11DeclRefExprEPNS_4ExprERNS_4SemaEPNS_5ScopeEPN12_GLOBAL__N_110DSAStackTyE;_ZL24buildDeclareReductionRefRN5clang4SemaENS_14SourceLocationENS_11SourceRangeEPNS_5ScopeERNS_12CXXScopeSpecERKNS_19DeclarationNameInfoENS_8QualTypeERN4llvm11SmallVectorIPNS_16CXXBaseSpecifierELj4EEEPNS_4ExprE;_ZL24checkDeclInTargetContextN5clang14SourceLocationENS_11SourceRangeERNS_4SemaEPNS_4DeclE;_ZL25CheckOpenMPIterationSpaceN5clang19OpenMPDirectiveKindEPNS_4StmtERNS_4SemaERN12_GLOBAL__N_110DSAStackTyEjjPNS_4ExprES9_RN4llvm8DenseMapIPNS_9ValueDeclES9_NSA_12DenseMapInfoISD_EENSA_6detail12DenseMapPairISD_S9_EEEERNS5_18LoopIterationSpaceERNSA_9MapVectorIS9_PNS_11DeclRefExprENSB_IS9_jNSE_IS9_EENSH_IS9_jEEEESt6vectorISt4pairIS9_SP_ESaISV_EEEE;_ZL25IsNonNegativeIntegerValueRPN5clang4ExprERNS_4SemaENS_16OpenMPClauseKindEb;_ZL27checkMappableExpressionListRN5clang4SemaEPN12_GLOBAL__N_110DSAStackTyENS_16OpenMPClauseKindERNS2_19MappableVarListInfoENS_14SourceLocationENS_19OpenMPMapClauseKindEb;_ZL28CheckMapClauseExpressionBaseRN5clang4SemaEPNS_4ExprERN4llvm11SmallVectorINS_27OMPClauseMappableExprCommon17MappableComponentELj8EEENS_16OpenMPClauseKindE;_ZL28checkSimdlenSafelenSpecifiedRN5clang4SemaEN4llvm8ArrayRefIPNS_9OMPClauseEEE;_ZL29checkGrainsizeNumTasksClausesRN5clang4SemaEN4llvm8ArrayRefIPNS_9OMPClauseEEE;_ZL43CheckArrayExpressionDoesNotReferToUnitySizeRN5clang4SemaEPKNS_4ExprENS_8QualTypeE;_ZL43CheckArrayExpressionDoesNotReferToWholeSizeRN5clang4SemaEPKNS_4ExprENS_8QualTypeE;_ZL8FitsIntojbPN5clang4ExprERNS_4SemaE;_ZN12_GLOBAL__N_122isParallelOrTaskRegionEN5clang19OpenMPDirectiveKindE;_ZN12_GLOBAL__N_1L13GetInitLCDeclEPN5clang4ExprE;_ZN12_GLOBAL__N_1L15tryBuildCaptureERN5clang4SemaEPNS0_4ExprERN4llvm9MapVectorIS4_PNS0_11DeclRefExprENS5_8DenseMapIS4_jNS5_12DenseMapInfoIS4_EENS5_6detail12DenseMapPairIS4_jEEEESt6vectorISt4pairIS4_S8_ESaISI_EEEE;_ZN12_GLOBAL__N_1L16getExprAsWrittenEPN5clang4ExprE; -static-type=SemaOpenMPStatics -package=org.clang.sema.impl")
//</editor-fold>
public final class SemaOpenMPStatics {

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::isParallelOrTaskRegion">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 387,
 FQN="(anonymous namespace)::isParallelOrTaskRegion", NM="_ZN12_GLOBAL__N_122isParallelOrTaskRegionEN5clang19OpenMPDirectiveKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN12_GLOBAL__N_122isParallelOrTaskRegionEN5clang19OpenMPDirectiveKindE")
//</editor-fold>
public static boolean isParallelOrTaskRegion(OpenMPDirectiveKind DKind) {
  return isOpenMPParallelDirective(DKind) || isOpenMPTaskingDirective(DKind)
     || isOpenMPTeamsDirective(DKind) || DKind == OpenMPDirectiveKind.OMPD_unknown;
}

// namespace
//<editor-fold defaultstate="collapsed" desc="getCanonicalDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 393,
 FQN="getCanonicalDecl", NM="_ZL16getCanonicalDeclPN5clang9ValueDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZL16getCanonicalDeclPN5clang9ValueDeclE")
//</editor-fold>
public static ValueDecl /*P*/ getCanonicalDecl(ValueDecl /*P*/ D) {
  VarDecl /*P*/ VD = dyn_cast_VarDecl(D);
  FieldDecl /*P*/ FD = dyn_cast_FieldDecl(D);
  if (VD != null) {
    VD = VD.getCanonicalDecl();
    D = VD;
  } else {
    assert Native.$bool(FD);
    FD = FD.getCanonicalDecl();
    D = FD;
  }
  return D;
}


/// \brief Build a variable declaration for OpenMP loop iteration variable.
//<editor-fold defaultstate="collapsed" desc="buildVarDecl">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 618,
 FQN="buildVarDecl", NM="_ZL12buildVarDeclRN5clang4SemaENS_14SourceLocationENS_8QualTypeEN4llvm9StringRefEPKNS4_11SmallVectorIPNS_4AttrELj2EEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZL12buildVarDeclRN5clang4SemaENS_14SourceLocationENS_8QualTypeEN4llvm9StringRefEPKNS4_11SmallVectorIPNS_4AttrELj2EEE")
//</editor-fold>
public static VarDecl /*P*/ buildVarDecl(final Sema /*&*/ SemaRef, SourceLocation Loc, QualType Type, 
            StringRef Name) {
  return buildVarDecl(SemaRef, Loc, Type, 
            Name, (/*const*/SmallVector<Attr /*P*/>/*P*/ )null);
}
public static VarDecl /*P*/ buildVarDecl(final Sema /*&*/ SemaRef, SourceLocation Loc, QualType Type, 
            StringRef Name, /*const*/SmallVector<Attr /*P*/>/*P*/ Attrs/*= null*/) {
  DeclContext /*P*/ DC = SemaRef.CurContext;
  IdentifierInfo /*P*/ II = $AddrOf(SemaRef.PP.getIdentifierTable().get(/*NO_COPY*/Name));
  TypeSourceInfo /*P*/ TInfo = SemaRef.Context.getTrivialTypeSourceInfo(new QualType(Type), new SourceLocation(Loc));
  VarDecl /*P*/ Decl = VarDecl.Create(SemaRef.Context, DC, new SourceLocation(Loc), new SourceLocation(Loc), II, new QualType(Type), TInfo, StorageClass.SC_None);
  if ((Attrs != null)) {
    for (specific_attr_iterator<AlignedAttr> I/*J*/= new specific_attr_iterator<AlignedAttr>(AlignedAttr.class, Attrs.begin$Const()), E/*J*/= new specific_attr_iterator<AlignedAttr>(AlignedAttr.class, Attrs.end$Const());
         $noteq_specific_attr_iterator$SpecificAttr(/*NO_COPY*/I, /*NO_COPY*/E); I.$preInc())  {
      Decl.addAttr(I.$star());
    }
  }
  Decl.setImplicit();
  return Decl;
}

//<editor-fold defaultstate="collapsed" desc="buildDeclRefExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 634,
 FQN="buildDeclRefExpr", NM="_ZL16buildDeclRefExprRN5clang4SemaEPNS_7VarDeclENS_8QualTypeENS_14SourceLocationEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZL16buildDeclRefExprRN5clang4SemaEPNS_7VarDeclENS_8QualTypeENS_14SourceLocationEb")
//</editor-fold>
public static DeclRefExpr /*P*/ buildDeclRefExpr(final Sema /*&*/ S, VarDecl /*P*/ D, QualType Ty, 
                SourceLocation Loc) {
  return buildDeclRefExpr(S, D, Ty, 
                Loc, 
                false);
}
public static DeclRefExpr /*P*/ buildDeclRefExpr(final Sema /*&*/ S, VarDecl /*P*/ D, QualType Ty, 
                SourceLocation Loc, 
                boolean RefersToCapture/*= false*/) {
  D.setReferenced();
  D.markUsed(S.Context);
  return DeclRefExpr.Create(S.getASTContext(), new NestedNameSpecifierLoc(), 
      new SourceLocation(), D, RefersToCapture, new SourceLocation(Loc), new QualType(Ty), 
      ExprValueKind.VK_LValue);
}

//<editor-fold defaultstate="collapsed" desc="FinishOpenMPLinearClause">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 9701,
 FQN="FinishOpenMPLinearClause", NM="_ZL24FinishOpenMPLinearClauseRN5clang15OMPLinearClauseEPNS_11DeclRefExprEPNS_4ExprERNS_4SemaEPNS_5ScopeEPN12_GLOBAL__N_110DSAStackTyE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZL24FinishOpenMPLinearClauseRN5clang15OMPLinearClauseEPNS_11DeclRefExprEPNS_4ExprERNS_4SemaEPNS_5ScopeEPN12_GLOBAL__N_110DSAStackTyE")
//</editor-fold>
public static boolean FinishOpenMPLinearClause(final OMPLinearClause /*&*/ Clause, DeclRefExpr /*P*/ IV, 
                        Expr /*P*/ NumIterations, final Sema /*&*/ SemaRef, 
                        Scope /*P*/ S, DSAStackTy /*P*/ Stack) {
  // Walk the vars and build update/final expressions for the CodeGen.
  SmallVector<Expr /*P*/ > Updates/*J*/= new SmallVector<Expr /*P*/ >(8, (Expr /*P*/ )null);
  SmallVector<Expr /*P*/ > Finals/*J*/= new SmallVector<Expr /*P*/ >(8, (Expr /*P*/ )null);
  Expr /*P*/ Step = Clause.getStep();
  Expr /*P*/ CalcStep = Clause.getCalcStep();
  // OpenMP [2.14.3.7, linear clause]
  // If linear-step is not specified it is assumed to be 1.
  if (Step == null) {
    Step = SemaRef.ActOnIntegerConstant(new SourceLocation(), 1).get();
  } else if ((CalcStep != null)) {
    Step = cast_BinaryOperator(CalcStep).getLHS();
  }
  boolean HasErrors = false;
  type$ptr<Expr/*P*/> CurInit = $tryClone(((type$ptr<Expr/*P*/> )Clause.inits().begin()));
  type$ptr<Expr/*P*/> CurPrivate = $tryClone(((type$ptr<Expr/*P*/> )Clause.privates().begin()));
  OpenMPLinearClauseKind LinKind = Clause.getModifier();
  for (Expr /*P*/ /*&*/ RefExpr : Clause.varlists()) {
    SourceLocation ELoc/*J*/= new SourceLocation();
    SourceRange ERange/*J*/= new SourceRange();
    type$ref<Expr /*P*/ > SimpleRefExpr = create_type$ref(RefExpr);
    std.pairTypeBool<ValueDecl /*P*/ > Res = getPrivateItem(SemaRef, SimpleRefExpr, ELoc, ERange, 
        /*AllowArraySection=*/ false);
    ValueDecl /*P*/ D = Res.first;
    if (Res.second || !(D != null)) {
      Updates.push_back((Expr /*P*/ /*const*/)null);
      Finals.push_back((Expr /*P*/ /*const*/)null);
      HasErrors = true;
      continue;
    }
    {
      OMPCapturedExprDecl /*P*/ CED = dyn_cast_OMPCapturedExprDecl(D);
      if ((CED != null)) {
        D = cast_MemberExpr(CED.getInit().IgnoreParenImpCasts()).
            getMemberDecl();
      }
    }
    final std.pairUIntType<VarDecl /*P*/ > /*&*/ Info = Stack.isLoopControlVariable(D);
    Expr /*P*/ InitExpr = CurInit.$star();
    
    // Build privatized reference to the current linear var.
    DeclRefExpr /*P*/ DE = cast_DeclRefExpr(SimpleRefExpr.$deref());
    Expr /*P*/ CapturedRef;
    if (LinKind == OpenMPLinearClauseKind.OMPC_LINEAR_uval) {
      CapturedRef = cast_VarDecl(DE.getDecl()).getInit();
    } else {
      CapturedRef
         = buildDeclRefExpr(SemaRef, cast_VarDecl(DE.getDecl()), 
          DE.getType().getUnqualifiedType(), DE.getExprLoc(), 
          /*RefersToCapture=*/ true);
    }
    
    // Build update: Var = InitExpr + IV * Step
    ActionResultTTrue<Expr /*P*/ > Update/*J*/= new ActionResultTTrue<Expr /*P*/ >();
    if (!(Info.first != 0)) {
      Update.$assignMove(
          BuildCounterUpdate(SemaRef, S, RefExpr./*->*/getExprLoc(), new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, CurPrivate.$star()), 
              new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, InitExpr), new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, IV), new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, Step), /* Subtract */ false)
      );
    } else {
      Update.$assign(CurPrivate.$star());
    }
    Update.$assignMove(SemaRef.ActOnFinishFullExpr(Update.get(), DE.getLocStart(), 
            /*DiscardedValue=*/ true));
    
    // Build final: Var = InitExpr + NumIterations * Step
    ActionResultTTrue<Expr /*P*/ > Final/*J*/= new ActionResultTTrue<Expr /*P*/ >();
    if (!(Info.first != 0)) {
      Final.$assignMove(BuildCounterUpdate(SemaRef, S, RefExpr./*->*/getExprLoc(), new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, CapturedRef), 
              new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, InitExpr), new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, NumIterations), new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, Step), 
              /* Subtract */ false));
    } else {
      Final.$assign(CurPrivate.$star());
    }
    Final.$assignMove(SemaRef.ActOnFinishFullExpr(Final.get(), DE.getLocStart(), 
            /*DiscardedValue=*/ true));
    if (!Update.isUsable() || !Final.isUsable()) {
      Updates.push_back((Expr /*P*/ /*const*/)null);
      Finals.push_back((Expr /*P*/ /*const*/)null);
      HasErrors = true;
    } else {
      Updates.push_back(Update.get());
      Finals.push_back(Final.get());
    }
    CurInit.$preInc();
    CurPrivate.$preInc();
  }
  Clause.setUpdates(new ArrayRef<Expr /*P*/ >(Updates, true));
  Clause.setFinals(new ArrayRef<Expr /*P*/ >(Finals, true));
  return HasErrors;
}

//<editor-fold defaultstate="collapsed" desc="ReportOriginalDSA">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 1397,
 FQN="ReportOriginalDSA", NM="_ZL17ReportOriginalDSARN5clang4SemaEPN12_GLOBAL__N_110DSAStackTyEPKNS_9ValueDeclENS3_10DSAVarDataEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZL17ReportOriginalDSARN5clang4SemaEPN12_GLOBAL__N_110DSAStackTyEPKNS_9ValueDeclENS3_10DSAVarDataEb")
//</editor-fold>
public static void ReportOriginalDSA(final Sema /*&*/ SemaRef, DSAStackTy /*P*/ Stack, 
                 /*const*/ ValueDecl /*P*/ D, DSAStackTy.DSAVarData DVar) {
  ReportOriginalDSA(SemaRef, Stack, 
                 D, DVar, 
                 false);
}
public static void ReportOriginalDSA(final Sema /*&*/ SemaRef, DSAStackTy /*P*/ Stack, 
                 /*const*/ ValueDecl /*P*/ D, DSAStackTy.DSAVarData DVar, 
                 boolean IsLoopIterVar/*= false*/) {
  if ((DVar.RefExpr != null)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(DVar.RefExpr.getExprLoc(), diag.note_omp_explicit_dsa)), 
          getOpenMPClauseName(DVar.CKind)));
      return;
    } finally {
      $c$.$destroy();
    }
  }
  /*enum ANONYMOUS_INT_CONSTANTS {*/
    final /*uint*/int PDSA_StaticMemberShared = 0;
    final /*uint*/int PDSA_StaticLocalVarShared = PDSA_StaticMemberShared + 1;
    final /*uint*/int PDSA_LoopIterVarPrivate = PDSA_StaticLocalVarShared + 1;
    final /*uint*/int PDSA_LoopIterVarLinear = PDSA_LoopIterVarPrivate + 1;
    final /*uint*/int PDSA_LoopIterVarLastprivate = PDSA_LoopIterVarLinear + 1;
    final /*uint*/int PDSA_ConstVarShared = PDSA_LoopIterVarLastprivate + 1;
    final /*uint*/int PDSA_GlobalVarShared = PDSA_ConstVarShared + 1;
    final /*uint*/int PDSA_TaskVarFirstprivate = PDSA_GlobalVarShared + 1;
    final /*uint*/int PDSA_LocalVarPrivate = PDSA_TaskVarFirstprivate + 1;
    final /*uint*/int PDSA_Implicit = PDSA_LocalVarPrivate + 1;
  /*}*//*Unnamed enum*//*uint*/int Reason = PDSA_Implicit;
  boolean ReportHint = false;
  SourceLocation ReportLoc = D.getLocation();
  /*const*/ VarDecl /*P*/ VD = dyn_cast_VarDecl(D);
  if (IsLoopIterVar) {
    if (DVar.CKind == OpenMPClauseKind.OMPC_private) {
      Reason = PDSA_LoopIterVarPrivate;
    } else if (DVar.CKind == OpenMPClauseKind.OMPC_lastprivate) {
      Reason = PDSA_LoopIterVarLastprivate;
    } else {
      Reason = PDSA_LoopIterVarLinear;
    }
  } else if (isOpenMPTaskingDirective(DVar.DKind)
     && DVar.CKind == OpenMPClauseKind.OMPC_firstprivate) {
    Reason = PDSA_TaskVarFirstprivate;
    ReportLoc.$assign(DVar.ImplicitDSALoc);
  } else if ((VD != null) && VD.isStaticLocal()) {
    Reason = PDSA_StaticLocalVarShared;
  } else if ((VD != null) && VD.isStaticDataMember()) {
    Reason = PDSA_StaticMemberShared;
  } else if ((VD != null) && VD.isFileVarDecl()) {
    Reason = PDSA_GlobalVarShared;
  } else if (D.getType().isConstant(SemaRef.getASTContext())) {
    Reason = PDSA_ConstVarShared;
  } else if ((VD != null) && VD.isLocalVarDecl() && DVar.CKind == OpenMPClauseKind.OMPC_private) {
    ReportHint = true;
    Reason = PDSA_LocalVarPrivate;
  }
  if (Reason != PDSA_Implicit) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(new SourceLocation(ReportLoc), diag.note_omp_predetermined_dsa)), 
                  Reason), ReportHint), 
          getOpenMPDirectiveName(Stack.getCurrentDirective())));
    } finally {
      $c$.$destroy();
    }
  } else if (DVar.ImplicitDSALoc.isValid()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(new SourceLocation(DVar.ImplicitDSALoc), diag.note_omp_implicit_dsa)), 
          getOpenMPClauseName(DVar.CKind)));
    } finally {
      $c$.$destroy();
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="buildCaptureDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 1723,
 FQN="buildCaptureDecl", NM="_ZL16buildCaptureDeclRN5clang4SemaEPNS_14IdentifierInfoEPNS_4ExprEbb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZL16buildCaptureDeclRN5clang4SemaEPNS_14IdentifierInfoEPNS_4ExprEbb")
//</editor-fold>
public static OMPCapturedExprDecl /*P*/ buildCaptureDecl(final Sema /*&*/ S, IdentifierInfo /*P*/ Id, 
                Expr /*P*/ CaptureExpr, boolean WithInit, 
                boolean AsExpression) {
  assert Native.$bool(CaptureExpr);
  final ASTContext /*&*/ C = S.getASTContext();
  Expr /*P*/ Init = AsExpression ? CaptureExpr : CaptureExpr.IgnoreImpCasts();
  QualType Ty = Init.getType();
  if (CaptureExpr.getObjectKind() == ExprObjectKind.OK_Ordinary && CaptureExpr.isGLValue()) {
    if (S.getLangOpts().CPlusPlus) {
      Ty.$assignMove(C.getLValueReferenceType(new QualType(Ty)));
    } else {
      Ty.$assignMove(C.getPointerType(new QualType(Ty)));
      ActionResultTTrue<Expr /*P*/ > Res = S.CreateBuiltinUnaryOp(CaptureExpr.getExprLoc(), UnaryOperatorKind.UO_AddrOf, Init);
      if (!Res.isUsable()) {
        return null;
      }
      Init = Res.get();
    }
    WithInit = true;
  }
  OMPCapturedExprDecl /*P*/ CED = OMPCapturedExprDecl.Create(C, S.CurContext, Id, new QualType(Ty));
  if (!WithInit) {
    CED.addAttr(OMPCaptureNoInitAttr.CreateImplicit(C, new SourceRange()));
  }
  S.CurContext.addHiddenDecl(CED);
  S.AddInitializerToDecl(CED, Init, /*DirectInit=*/ false, 
      /*TypeMayContainAuto=*/ true);
  return CED;
}

//<editor-fold defaultstate="collapsed" desc="buildCapture">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 1752,
 FQN="buildCapture", NM="_ZL12buildCaptureRN5clang4SemaEPNS_9ValueDeclEPNS_4ExprEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZL12buildCaptureRN5clang4SemaEPNS_9ValueDeclEPNS_4ExprEb")
//</editor-fold>
public static DeclRefExpr /*P*/ buildCapture(final Sema /*&*/ S, ValueDecl /*P*/ D, Expr /*P*/ CaptureExpr, 
            boolean WithInit) {
  OMPCapturedExprDecl /*P*/ CD;
  {
    VarDecl /*P*/ VD = S.IsOpenMPCapturedDecl(D);
    if ((VD != null)) {
      CD = cast_OMPCapturedExprDecl(VD);
    } else {
      CD = buildCaptureDecl(S, D.getIdentifier(), CaptureExpr, WithInit, 
          /*AsExpression=*/ false);
    }
  }
  return buildDeclRefExpr(S, CD, CD.getType().getNonReferenceType(), 
      CaptureExpr.getExprLoc());
}

//<editor-fold defaultstate="collapsed" desc="buildCapture">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 1764,
 FQN="buildCapture", NM="_ZL12buildCaptureRN5clang4SemaEPNS_4ExprERPNS_11DeclRefExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZL12buildCaptureRN5clang4SemaEPNS_4ExprERPNS_11DeclRefExprE")
//</editor-fold>
public static ActionResultTTrue<Expr /*P*/ > buildCapture(final Sema /*&*/ S, Expr /*P*/ CaptureExpr, final type$ptr<DeclRefExpr /*P*/ /*&*/> Ref) {
  if (!(Ref != null)) {
    OMPCapturedExprDecl /*P*/ CD = buildCaptureDecl(S, $AddrOf(S.getASTContext().Idents.get(new StringRef(/*KEEP_STR*/".capture_expr."))), 
        CaptureExpr, /*WithInit=*/ true, /*AsExpression=*/ true);
    Ref.$set(buildDeclRefExpr(S, CD, CD.getType().getNonReferenceType(), 
        CaptureExpr.getExprLoc()));
  }
  ActionResultTTrue<Expr /*P*/ > Res = new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, Ref.$star());
  if (!S.getLangOpts().CPlusPlus
     && CaptureExpr.getObjectKind() == ExprObjectKind.OK_Ordinary && CaptureExpr.isGLValue()
     && Ref./*->*/$star().getType().$arrow().isPointerType()) {
    Res.$assignMove(S.CreateBuiltinUnaryOp(CaptureExpr.getExprLoc(), UnaryOperatorKind.UO_Deref, Ref.$star()));
  }
  if (!Res.isUsable()) {
    return ExprError();
  }
  return CaptureExpr.isGLValue() ? new ActionResultTTrue<Expr /*P*/ >(Res) : S.DefaultLvalueConversion(Res.get());
}

//<editor-fold defaultstate="collapsed" desc="CheckNestingOfRegions">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 1866,
 FQN="CheckNestingOfRegions", NM="_ZL21CheckNestingOfRegionsRN5clang4SemaEPN12_GLOBAL__N_110DSAStackTyENS_19OpenMPDirectiveKindERKNS_19DeclarationNameInfoES5_NS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZL21CheckNestingOfRegionsRN5clang4SemaEPN12_GLOBAL__N_110DSAStackTyENS_19OpenMPDirectiveKindERKNS_19DeclarationNameInfoES5_NS_14SourceLocationE")
//</editor-fold>
public static boolean CheckNestingOfRegions(final Sema /*&*/ SemaRef, DSAStackTy /*P*/ Stack, 
                     OpenMPDirectiveKind CurrentRegion, 
                     final /*const*/ DeclarationNameInfo /*&*/ CurrentName, 
                     OpenMPDirectiveKind CancelRegion, 
                     SourceLocation StartLoc) {
  // Allowed nesting of constructs
  // +------------------+-----------------+------------------------------------+
  // | Parent directive | Child directive | Closely (!), No-Closely(+), Both(*)|
  // +------------------+-----------------+------------------------------------+
  // | parallel         | parallel        | *                                  |
  // | parallel         | for             | *                                  |
  // | parallel         | for simd        | *                                  |
  // | parallel         | master          | *                                  |
  // | parallel         | critical        | *                                  |
  // | parallel         | simd            | *                                  |
  // | parallel         | sections        | *                                  |
  // | parallel         | section         | +                                  |
  // | parallel         | single          | *                                  |
  // | parallel         | parallel for    | *                                  |
  // | parallel         |parallel for simd| *                                  |
  // | parallel         |parallel sections| *                                  |
  // | parallel         | task            | *                                  |
  // | parallel         | taskyield       | *                                  |
  // | parallel         | barrier         | *                                  |
  // | parallel         | taskwait        | *                                  |
  // | parallel         | taskgroup       | *                                  |
  // | parallel         | flush           | *                                  |
  // | parallel         | ordered         | +                                  |
  // | parallel         | atomic          | *                                  |
  // | parallel         | target          | *                                  |
  // | parallel         | target parallel | *                                  |
  // | parallel         | target parallel | *                                  |
  // |                  | for             |                                    |
  // | parallel         | target enter    | *                                  |
  // |                  | data            |                                    |
  // | parallel         | target exit     | *                                  |
  // |                  | data            |                                    |
  // | parallel         | teams           | +                                  |
  // | parallel         | cancellation    |                                    |
  // |                  | point           | !                                  |
  // | parallel         | cancel          | !                                  |
  // | parallel         | taskloop        | *                                  |
  // | parallel         | taskloop simd   | *                                  |
  // | parallel         | distribute      | +                                  |
  // | parallel         | distribute      | +                                  |
  // |                  | parallel for    |                                    |
  // | parallel         | distribute      | +                                  |
  // |                  |parallel for simd|                                    |
  // | parallel         | distribute simd | +                                  |
  // +------------------+-----------------+------------------------------------+
  // | for              | parallel        | *                                  |
  // | for              | for             | +                                  |
  // | for              | for simd        | +                                  |
  // | for              | master          | +                                  |
  // | for              | critical        | *                                  |
  // | for              | simd            | *                                  |
  // | for              | sections        | +                                  |
  // | for              | section         | +                                  |
  // | for              | single          | +                                  |
  // | for              | parallel for    | *                                  |
  // | for              |parallel for simd| *                                  |
  // | for              |parallel sections| *                                  |
  // | for              | task            | *                                  |
  // | for              | taskyield       | *                                  |
  // | for              | barrier         | +                                  |
  // | for              | taskwait        | *                                  |
  // | for              | taskgroup       | *                                  |
  // | for              | flush           | *                                  |
  // | for              | ordered         | * (if construct is ordered)        |
  // | for              | atomic          | *                                  |
  // | for              | target          | *                                  |
  // | for              | target parallel | *                                  |
  // | for              | target parallel | *                                  |
  // |                  | for             |                                    |
  // | for              | target enter    | *                                  |
  // |                  | data            |                                    |
  // | for              | target exit     | *                                  |
  // |                  | data            |                                    |
  // | for              | teams           | +                                  |
  // | for              | cancellation    |                                    |
  // |                  | point           | !                                  |
  // | for              | cancel          | !                                  |
  // | for              | taskloop        | *                                  |
  // | for              | taskloop simd   | *                                  |
  // | for              | distribute      | +                                  |
  // | for              | distribute      | +                                  |
  // |                  | parallel for    |                                    |
  // | for              | distribute      | +                                  |
  // |                  |parallel for simd|                                    |
  // | for              | distribute simd | +                                  |
  // | for              | target parallel | +                                  |
  // |                  | for simd        |                                    |
  // +------------------+-----------------+------------------------------------+
  // | master           | parallel        | *                                  |
  // | master           | for             | +                                  |
  // | master           | for simd        | +                                  |
  // | master           | master          | *                                  |
  // | master           | critical        | *                                  |
  // | master           | simd            | *                                  |
  // | master           | sections        | +                                  |
  // | master           | section         | +                                  |
  // | master           | single          | +                                  |
  // | master           | parallel for    | *                                  |
  // | master           |parallel for simd| *                                  |
  // | master           |parallel sections| *                                  |
  // | master           | task            | *                                  |
  // | master           | taskyield       | *                                  |
  // | master           | barrier         | +                                  |
  // | master           | taskwait        | *                                  |
  // | master           | taskgroup       | *                                  |
  // | master           | flush           | *                                  |
  // | master           | ordered         | +                                  |
  // | master           | atomic          | *                                  |
  // | master           | target          | *                                  |
  // | master           | target parallel | *                                  |
  // | master           | target parallel | *                                  |
  // |                  | for             |                                    |
  // | master           | target enter    | *                                  |
  // |                  | data            |                                    |
  // | master           | target exit     | *                                  |
  // |                  | data            |                                    |
  // | master           | teams           | +                                  |
  // | master           | cancellation    |                                    |
  // |                  | point           |                                    |
  // | master           | cancel          |                                    |
  // | master           | taskloop        | *                                  |
  // | master           | taskloop simd   | *                                  |
  // | master           | distribute      | +                                  |
  // | master           | distribute      | +                                  |
  // |                  | parallel for    |                                    |
  // | master           | distribute      | +                                  |
  // |                  |parallel for simd|                                    |
  // | master           | distribute simd | +                                  |
  // | master           | target parallel | +                                  |
  // |                  | for simd        |                                    |
  // +------------------+-----------------+------------------------------------+
  // | critical         | parallel        | *                                  |
  // | critical         | for             | +                                  |
  // | critical         | for simd        | +                                  |
  // | critical         | master          | *                                  |
  // | critical         | critical        | * (should have different names)    |
  // | critical         | simd            | *                                  |
  // | critical         | sections        | +                                  |
  // | critical         | section         | +                                  |
  // | critical         | single          | +                                  |
  // | critical         | parallel for    | *                                  |
  // | critical         |parallel for simd| *                                  |
  // | critical         |parallel sections| *                                  |
  // | critical         | task            | *                                  |
  // | critical         | taskyield       | *                                  |
  // | critical         | barrier         | +                                  |
  // | critical         | taskwait        | *                                  |
  // | critical         | taskgroup       | *                                  |
  // | critical         | ordered         | +                                  |
  // | critical         | atomic          | *                                  |
  // | critical         | target          | *                                  |
  // | critical         | target parallel | *                                  |
  // | critical         | target parallel | *                                  |
  // |                  | for             |                                    |
  // | critical         | target enter    | *                                  |
  // |                  | data            |                                    |
  // | critical         | target exit     | *                                  |
  // |                  | data            |                                    |
  // | critical         | teams           | +                                  |
  // | critical         | cancellation    |                                    |
  // |                  | point           |                                    |
  // | critical         | cancel          |                                    |
  // | critical         | taskloop        | *                                  |
  // | critical         | taskloop simd   | *                                  |
  // | critical         | distribute      | +                                  |
  // | critical         | distribute      | +                                  |
  // |                  | parallel for    |                                    |
  // | critical         | distribute      | +                                  |
  // |                  |parallel for simd|                                    |
  // | critical         | distribute simd | +                                  |
  // | critical         | target parallel | +                                  |
  // |                  | for simd        |                                    |
  // +------------------+-----------------+------------------------------------+
  // | simd             | parallel        |                                    |
  // | simd             | for             |                                    |
  // | simd             | for simd        |                                    |
  // | simd             | master          |                                    |
  // | simd             | critical        |                                    |
  // | simd             | simd            | *                                  |
  // | simd             | sections        |                                    |
  // | simd             | section         |                                    |
  // | simd             | single          |                                    |
  // | simd             | parallel for    |                                    |
  // | simd             |parallel for simd|                                    |
  // | simd             |parallel sections|                                    |
  // | simd             | task            |                                    |
  // | simd             | taskyield       |                                    |
  // | simd             | barrier         |                                    |
  // | simd             | taskwait        |                                    |
  // | simd             | taskgroup       |                                    |
  // | simd             | flush           |                                    |
  // | simd             | ordered         | + (with simd clause)               |
  // | simd             | atomic          |                                    |
  // | simd             | target          |                                    |
  // | simd             | target parallel |                                    |
  // | simd             | target parallel |                                    |
  // |                  | for             |                                    |
  // | simd             | target enter    |                                    |
  // |                  | data            |                                    |
  // | simd             | target exit     |                                    |
  // |                  | data            |                                    |
  // | simd             | teams           |                                    |
  // | simd             | cancellation    |                                    |
  // |                  | point           |                                    |
  // | simd             | cancel          |                                    |
  // | simd             | taskloop        |                                    |
  // | simd             | taskloop simd   |                                    |
  // | simd             | distribute      |                                    |
  // | simd             | distribute      |                                    |
  // |                  | parallel for    |                                    |
  // | simd             | distribute      |                                    |
  // |                  |parallel for simd|                                    |
  // | simd             | distribute simd |                                    |
  // | simd             | target parallel |                                    |
  // |                  | for simd        |                                    |
  // +------------------+-----------------+------------------------------------+
  // | for simd         | parallel        |                                    |
  // | for simd         | for             |                                    |
  // | for simd         | for simd        |                                    |
  // | for simd         | master          |                                    |
  // | for simd         | critical        |                                    |
  // | for simd         | simd            | *                                  |
  // | for simd         | sections        |                                    |
  // | for simd         | section         |                                    |
  // | for simd         | single          |                                    |
  // | for simd         | parallel for    |                                    |
  // | for simd         |parallel for simd|                                    |
  // | for simd         |parallel sections|                                    |
  // | for simd         | task            |                                    |
  // | for simd         | taskyield       |                                    |
  // | for simd         | barrier         |                                    |
  // | for simd         | taskwait        |                                    |
  // | for simd         | taskgroup       |                                    |
  // | for simd         | flush           |                                    |
  // | for simd         | ordered         | + (with simd clause)               |
  // | for simd         | atomic          |                                    |
  // | for simd         | target          |                                    |
  // | for simd         | target parallel |                                    |
  // | for simd         | target parallel |                                    |
  // |                  | for             |                                    |
  // | for simd         | target enter    |                                    |
  // |                  | data            |                                    |
  // | for simd         | target exit     |                                    |
  // |                  | data            |                                    |
  // | for simd         | teams           |                                    |
  // | for simd         | cancellation    |                                    |
  // |                  | point           |                                    |
  // | for simd         | cancel          |                                    |
  // | for simd         | taskloop        |                                    |
  // | for simd         | taskloop simd   |                                    |
  // | for simd         | distribute      |                                    |
  // | for simd         | distribute      |                                    |
  // |                  | parallel for    |                                    |
  // | for simd         | distribute      |                                    |
  // |                  |parallel for simd|                                    |
  // | for simd         | distribute simd |                                    |
  // | for simd         | target parallel |                                    |
  // |                  | for simd        |                                    |
  // +------------------+-----------------+------------------------------------+
  // | parallel for simd| parallel        |                                    |
  // | parallel for simd| for             |                                    |
  // | parallel for simd| for simd        |                                    |
  // | parallel for simd| master          |                                    |
  // | parallel for simd| critical        |                                    |
  // | parallel for simd| simd            | *                                  |
  // | parallel for simd| sections        |                                    |
  // | parallel for simd| section         |                                    |
  // | parallel for simd| single          |                                    |
  // | parallel for simd| parallel for    |                                    |
  // | parallel for simd|parallel for simd|                                    |
  // | parallel for simd|parallel sections|                                    |
  // | parallel for simd| task            |                                    |
  // | parallel for simd| taskyield       |                                    |
  // | parallel for simd| barrier         |                                    |
  // | parallel for simd| taskwait        |                                    |
  // | parallel for simd| taskgroup       |                                    |
  // | parallel for simd| flush           |                                    |
  // | parallel for simd| ordered         | + (with simd clause)               |
  // | parallel for simd| atomic          |                                    |
  // | parallel for simd| target          |                                    |
  // | parallel for simd| target parallel |                                    |
  // | parallel for simd| target parallel |                                    |
  // |                  | for             |                                    |
  // | parallel for simd| target enter    |                                    |
  // |                  | data            |                                    |
  // | parallel for simd| target exit     |                                    |
  // |                  | data            |                                    |
  // | parallel for simd| teams           |                                    |
  // | parallel for simd| cancellation    |                                    |
  // |                  | point           |                                    |
  // | parallel for simd| cancel          |                                    |
  // | parallel for simd| taskloop        |                                    |
  // | parallel for simd| taskloop simd   |                                    |
  // | parallel for simd| distribute      |                                    |
  // | parallel for simd| distribute      |                                    |
  // |                  | parallel for    |                                    |
  // | parallel for simd| distribute      |                                    |
  // |                  |parallel for simd|                                    |
  // | parallel for simd| distribute simd |                                    |
  // |                  | for simd        |                                    |
  // +------------------+-----------------+------------------------------------+
  // | sections         | parallel        | *                                  |
  // | sections         | for             | +                                  |
  // | sections         | for simd        | +                                  |
  // | sections         | master          | +                                  |
  // | sections         | critical        | *                                  |
  // | sections         | simd            | *                                  |
  // | sections         | sections        | +                                  |
  // | sections         | section         | *                                  |
  // | sections         | single          | +                                  |
  // | sections         | parallel for    | *                                  |
  // | sections         |parallel for simd| *                                  |
  // | sections         |parallel sections| *                                  |
  // | sections         | task            | *                                  |
  // | sections         | taskyield       | *                                  |
  // | sections         | barrier         | +                                  |
  // | sections         | taskwait        | *                                  |
  // | sections         | taskgroup       | *                                  |
  // | sections         | flush           | *                                  |
  // | sections         | ordered         | +                                  |
  // | sections         | atomic          | *                                  |
  // | sections         | target          | *                                  |
  // | sections         | target parallel | *                                  |
  // | sections         | target parallel | *                                  |
  // |                  | for             |                                    |
  // | sections         | target enter    | *                                  |
  // |                  | data            |                                    |
  // | sections         | target exit     | *                                  |
  // |                  | data            |                                    |
  // | sections         | teams           | +                                  |
  // | sections         | cancellation    |                                    |
  // |                  | point           | !                                  |
  // | sections         | cancel          | !                                  |
  // | sections         | taskloop        | *                                  |
  // | sections         | taskloop simd   | *                                  |
  // | sections         | distribute      | +                                  |
  // | sections         | distribute      | +                                  |
  // |                  | parallel for    |                                    |
  // | sections         | distribute      | +                                  |
  // |                  |parallel for simd|                                    |
  // | sections         | distribute simd | +                                  |
  // | sections         | target parallel | +                                  |
  // |                  | for simd        |                                    |
  // +------------------+-----------------+------------------------------------+
  // | section          | parallel        | *                                  |
  // | section          | for             | +                                  |
  // | section          | for simd        | +                                  |
  // | section          | master          | +                                  |
  // | section          | critical        | *                                  |
  // | section          | simd            | *                                  |
  // | section          | sections        | +                                  |
  // | section          | section         | +                                  |
  // | section          | single          | +                                  |
  // | section          | parallel for    | *                                  |
  // | section          |parallel for simd| *                                  |
  // | section          |parallel sections| *                                  |
  // | section          | task            | *                                  |
  // | section          | taskyield       | *                                  |
  // | section          | barrier         | +                                  |
  // | section          | taskwait        | *                                  |
  // | section          | taskgroup       | *                                  |
  // | section          | flush           | *                                  |
  // | section          | ordered         | +                                  |
  // | section          | atomic          | *                                  |
  // | section          | target          | *                                  |
  // | section          | target parallel | *                                  |
  // | section          | target parallel | *                                  |
  // |                  | for             |                                    |
  // | section          | target enter    | *                                  |
  // |                  | data            |                                    |
  // | section          | target exit     | *                                  |
  // |                  | data            |                                    |
  // | section          | teams           | +                                  |
  // | section          | cancellation    |                                    |
  // |                  | point           | !                                  |
  // | section          | cancel          | !                                  |
  // | section          | taskloop        | *                                  |
  // | section          | taskloop simd   | *                                  |
  // | section          | distribute      | +                                  |
  // | section          | distribute      | +                                  |
  // |                  | parallel for    |                                    |
  // | section          | distribute      | +                                  |
  // |                  |parallel for simd|                                    |
  // | section          | distribute simd | +                                  |
  // | section          | target parallel | +                                  |
  // |                  | for simd        |                                    |
  // +------------------+-----------------+------------------------------------+
  // | single           | parallel        | *                                  |
  // | single           | for             | +                                  |
  // | single           | for simd        | +                                  |
  // | single           | master          | +                                  |
  // | single           | critical        | *                                  |
  // | single           | simd            | *                                  |
  // | single           | sections        | +                                  |
  // | single           | section         | +                                  |
  // | single           | single          | +                                  |
  // | single           | parallel for    | *                                  |
  // | single           |parallel for simd| *                                  |
  // | single           |parallel sections| *                                  |
  // | single           | task            | *                                  |
  // | single           | taskyield       | *                                  |
  // | single           | barrier         | +                                  |
  // | single           | taskwait        | *                                  |
  // | single           | taskgroup       | *                                  |
  // | single           | flush           | *                                  |
  // | single           | ordered         | +                                  |
  // | single           | atomic          | *                                  |
  // | single           | target          | *                                  |
  // | single           | target parallel | *                                  |
  // | single           | target parallel | *                                  |
  // |                  | for             |                                    |
  // | single           | target enter    | *                                  |
  // |                  | data            |                                    |
  // | single           | target exit     | *                                  |
  // |                  | data            |                                    |
  // | single           | teams           | +                                  |
  // | single           | cancellation    |                                    |
  // |                  | point           |                                    |
  // | single           | cancel          |                                    |
  // | single           | taskloop        | *                                  |
  // | single           | taskloop simd   | *                                  |
  // | single           | distribute      | +                                  |
  // | single           | distribute      | +                                  |
  // |                  | parallel for    |                                    |
  // | single           | distribute      | +                                  |
  // |                  |parallel for simd|                                    |
  // | single           | distribute simd | +                                  |
  // | single           | target parallel | +                                  |
  // |                  | for simd        |                                    |
  // +------------------+-----------------+------------------------------------+
  // | parallel for     | parallel        | *                                  |
  // | parallel for     | for             | +                                  |
  // | parallel for     | for simd        | +                                  |
  // | parallel for     | master          | +                                  |
  // | parallel for     | critical        | *                                  |
  // | parallel for     | simd            | *                                  |
  // | parallel for     | sections        | +                                  |
  // | parallel for     | section         | +                                  |
  // | parallel for     | single          | +                                  |
  // | parallel for     | parallel for    | *                                  |
  // | parallel for     |parallel for simd| *                                  |
  // | parallel for     |parallel sections| *                                  |
  // | parallel for     | task            | *                                  |
  // | parallel for     | taskyield       | *                                  |
  // | parallel for     | barrier         | +                                  |
  // | parallel for     | taskwait        | *                                  |
  // | parallel for     | taskgroup       | *                                  |
  // | parallel for     | flush           | *                                  |
  // | parallel for     | ordered         | * (if construct is ordered)        |
  // | parallel for     | atomic          | *                                  |
  // | parallel for     | target          | *                                  |
  // | parallel for     | target parallel | *                                  |
  // | parallel for     | target parallel | *                                  |
  // |                  | for             |                                    |
  // | parallel for     | target enter    | *                                  |
  // |                  | data            |                                    |
  // | parallel for     | target exit     | *                                  |
  // |                  | data            |                                    |
  // | parallel for     | teams           | +                                  |
  // | parallel for     | cancellation    |                                    |
  // |                  | point           | !                                  |
  // | parallel for     | cancel          | !                                  |
  // | parallel for     | taskloop        | *                                  |
  // | parallel for     | taskloop simd   | *                                  |
  // | parallel for     | distribute      | +                                  |
  // | parallel for     | distribute      | +                                  |
  // |                  | parallel for    |                                    |
  // | parallel for     | distribute      | +                                  |
  // |                  |parallel for simd|                                    |
  // | parallel for     | distribute simd | +                                  |
  // | parallel for     | target parallel | +                                  |
  // |                  | for simd        |                                    |
  // +------------------+-----------------+------------------------------------+
  // | parallel sections| parallel        | *                                  |
  // | parallel sections| for             | +                                  |
  // | parallel sections| for simd        | +                                  |
  // | parallel sections| master          | +                                  |
  // | parallel sections| critical        | +                                  |
  // | parallel sections| simd            | *                                  |
  // | parallel sections| sections        | +                                  |
  // | parallel sections| section         | *                                  |
  // | parallel sections| single          | +                                  |
  // | parallel sections| parallel for    | *                                  |
  // | parallel sections|parallel for simd| *                                  |
  // | parallel sections|parallel sections| *                                  |
  // | parallel sections| task            | *                                  |
  // | parallel sections| taskyield       | *                                  |
  // | parallel sections| barrier         | +                                  |
  // | parallel sections| taskwait        | *                                  |
  // | parallel sections| taskgroup       | *                                  |
  // | parallel sections| flush           | *                                  |
  // | parallel sections| ordered         | +                                  |
  // | parallel sections| atomic          | *                                  |
  // | parallel sections| target          | *                                  |
  // | parallel sections| target parallel | *                                  |
  // | parallel sections| target parallel | *                                  |
  // |                  | for             |                                    |
  // | parallel sections| target enter    | *                                  |
  // |                  | data            |                                    |
  // | parallel sections| target exit     | *                                  |
  // |                  | data            |                                    |
  // | parallel sections| teams           | +                                  |
  // | parallel sections| cancellation    |                                    |
  // |                  | point           | !                                  |
  // | parallel sections| cancel          | !                                  |
  // | parallel sections| taskloop        | *                                  |
  // | parallel sections| taskloop simd   | *                                  |
  // | parallel sections| distribute      | +                                  |
  // | parallel sections| distribute      | +                                  |
  // |                  | parallel for    |                                    |
  // | parallel sections| distribute      | +                                  |
  // |                  |parallel for simd|                                    |
  // | parallel sections| distribute simd | +                                  |
  // | parallel sections| target parallel | +                                  |
  // |                  | for simd        |                                    |
  // +------------------+-----------------+------------------------------------+
  // | task             | parallel        | *                                  |
  // | task             | for             | +                                  |
  // | task             | for simd        | +                                  |
  // | task             | master          | +                                  |
  // | task             | critical        | *                                  |
  // | task             | simd            | *                                  |
  // | task             | sections        | +                                  |
  // | task             | section         | +                                  |
  // | task             | single          | +                                  |
  // | task             | parallel for    | *                                  |
  // | task             |parallel for simd| *                                  |
  // | task             |parallel sections| *                                  |
  // | task             | task            | *                                  |
  // | task             | taskyield       | *                                  |
  // | task             | barrier         | +                                  |
  // | task             | taskwait        | *                                  |
  // | task             | taskgroup       | *                                  |
  // | task             | flush           | *                                  |
  // | task             | ordered         | +                                  |
  // | task             | atomic          | *                                  |
  // | task             | target          | *                                  |
  // | task             | target parallel | *                                  |
  // | task             | target parallel | *                                  |
  // |                  | for             |                                    |
  // | task             | target enter    | *                                  |
  // |                  | data            |                                    |
  // | task             | target exit     | *                                  |
  // |                  | data            |                                    |
  // | task             | teams           | +                                  |
  // | task             | cancellation    |                                    |
  // |                  | point           | !                                  |
  // | task             | cancel          | !                                  |
  // | task             | taskloop        | *                                  |
  // | task             | taskloop simd   | *                                  |
  // | task             | distribute      | +                                  |
  // | task             | distribute      | +                                  |
  // |                  | parallel for    |                                    |
  // | task             | distribute      | +                                  |
  // |                  |parallel for simd|                                    |
  // | task             | distribute simd | +                                  |
  // | task             | target parallel | +                                  |
  // |                  | for simd        |                                    |
  // +------------------+-----------------+------------------------------------+
  // | ordered          | parallel        | *                                  |
  // | ordered          | for             | +                                  |
  // | ordered          | for simd        | +                                  |
  // | ordered          | master          | *                                  |
  // | ordered          | critical        | *                                  |
  // | ordered          | simd            | *                                  |
  // | ordered          | sections        | +                                  |
  // | ordered          | section         | +                                  |
  // | ordered          | single          | +                                  |
  // | ordered          | parallel for    | *                                  |
  // | ordered          |parallel for simd| *                                  |
  // | ordered          |parallel sections| *                                  |
  // | ordered          | task            | *                                  |
  // | ordered          | taskyield       | *                                  |
  // | ordered          | barrier         | +                                  |
  // | ordered          | taskwait        | *                                  |
  // | ordered          | taskgroup       | *                                  |
  // | ordered          | flush           | *                                  |
  // | ordered          | ordered         | +                                  |
  // | ordered          | atomic          | *                                  |
  // | ordered          | target          | *                                  |
  // | ordered          | target parallel | *                                  |
  // | ordered          | target parallel | *                                  |
  // |                  | for             |                                    |
  // | ordered          | target enter    | *                                  |
  // |                  | data            |                                    |
  // | ordered          | target exit     | *                                  |
  // |                  | data            |                                    |
  // | ordered          | teams           | +                                  |
  // | ordered          | cancellation    |                                    |
  // |                  | point           |                                    |
  // | ordered          | cancel          |                                    |
  // | ordered          | taskloop        | *                                  |
  // | ordered          | taskloop simd   | *                                  |
  // | ordered          | distribute      | +                                  |
  // | ordered          | distribute      | +                                  |
  // |                  | parallel for    |                                    |
  // | ordered          | distribute      | +                                  |
  // |                  |parallel for simd|                                    |
  // | ordered          | distribute simd | +                                  |
  // | ordered          | target parallel | +                                  |
  // |                  | for simd        |                                    |
  // +------------------+-----------------+------------------------------------+
  // | atomic           | parallel        |                                    |
  // | atomic           | for             |                                    |
  // | atomic           | for simd        |                                    |
  // | atomic           | master          |                                    |
  // | atomic           | critical        |                                    |
  // | atomic           | simd            |                                    |
  // | atomic           | sections        |                                    |
  // | atomic           | section         |                                    |
  // | atomic           | single          |                                    |
  // | atomic           | parallel for    |                                    |
  // | atomic           |parallel for simd|                                    |
  // | atomic           |parallel sections|                                    |
  // | atomic           | task            |                                    |
  // | atomic           | taskyield       |                                    |
  // | atomic           | barrier         |                                    |
  // | atomic           | taskwait        |                                    |
  // | atomic           | taskgroup       |                                    |
  // | atomic           | flush           |                                    |
  // | atomic           | ordered         |                                    |
  // | atomic           | atomic          |                                    |
  // | atomic           | target          |                                    |
  // | atomic           | target parallel |                                    |
  // | atomic           | target parallel |                                    |
  // |                  | for             |                                    |
  // | atomic           | target enter    |                                    |
  // |                  | data            |                                    |
  // | atomic           | target exit     |                                    |
  // |                  | data            |                                    |
  // | atomic           | teams           |                                    |
  // | atomic           | cancellation    |                                    |
  // |                  | point           |                                    |
  // | atomic           | cancel          |                                    |
  // | atomic           | taskloop        |                                    |
  // | atomic           | taskloop simd   |                                    |
  // | atomic           | distribute      |                                    |
  // | atomic           | distribute      |                                    |
  // |                  | parallel for    |                                    |
  // | atomic           | distribute      |                                    |
  // |                  |parallel for simd|                                    |
  // | atomic           | distribute simd |                                    |
  // | atomic           | target parallel |                                    |
  // |                  | for simd        |                                    |
  // +------------------+-----------------+------------------------------------+
  // | target           | parallel        | *                                  |
  // | target           | for             | *                                  |
  // | target           | for simd        | *                                  |
  // | target           | master          | *                                  |
  // | target           | critical        | *                                  |
  // | target           | simd            | *                                  |
  // | target           | sections        | *                                  |
  // | target           | section         | *                                  |
  // | target           | single          | *                                  |
  // | target           | parallel for    | *                                  |
  // | target           |parallel for simd| *                                  |
  // | target           |parallel sections| *                                  |
  // | target           | task            | *                                  |
  // | target           | taskyield       | *                                  |
  // | target           | barrier         | *                                  |
  // | target           | taskwait        | *                                  |
  // | target           | taskgroup       | *                                  |
  // | target           | flush           | *                                  |
  // | target           | ordered         | *                                  |
  // | target           | atomic          | *                                  |
  // | target           | target          |                                    |
  // | target           | target parallel |                                    |
  // | target           | target parallel |                                    |
  // |                  | for             |                                    |
  // | target           | target enter    |                                    |
  // |                  | data            |                                    |
  // | target           | target exit     |                                    |
  // |                  | data            |                                    |
  // | target           | teams           | *                                  |
  // | target           | cancellation    |                                    |
  // |                  | point           |                                    |
  // | target           | cancel          |                                    |
  // | target           | taskloop        | *                                  |
  // | target           | taskloop simd   | *                                  |
  // | target           | distribute      | +                                  |
  // | target           | distribute      | +                                  |
  // |                  | parallel for    |                                    |
  // | target           | distribute      | +                                  |
  // |                  |parallel for simd|                                    |
  // | target           | distribute simd | +                                  |
  // | target           | target parallel |                                    |
  // |                  | for simd        |                                    |
  // +------------------+-----------------+------------------------------------+
  // | target parallel  | parallel        | *                                  |
  // | target parallel  | for             | *                                  |
  // | target parallel  | for simd        | *                                  |
  // | target parallel  | master          | *                                  |
  // | target parallel  | critical        | *                                  |
  // | target parallel  | simd            | *                                  |
  // | target parallel  | sections        | *                                  |
  // | target parallel  | section         | *                                  |
  // | target parallel  | single          | *                                  |
  // | target parallel  | parallel for    | *                                  |
  // | target parallel  |parallel for simd| *                                  |
  // | target parallel  |parallel sections| *                                  |
  // | target parallel  | task            | *                                  |
  // | target parallel  | taskyield       | *                                  |
  // | target parallel  | barrier         | *                                  |
  // | target parallel  | taskwait        | *                                  |
  // | target parallel  | taskgroup       | *                                  |
  // | target parallel  | flush           | *                                  |
  // | target parallel  | ordered         | *                                  |
  // | target parallel  | atomic          | *                                  |
  // | target parallel  | target          |                                    |
  // | target parallel  | target parallel |                                    |
  // | target parallel  | target parallel |                                    |
  // |                  | for             |                                    |
  // | target parallel  | target enter    |                                    |
  // |                  | data            |                                    |
  // | target parallel  | target exit     |                                    |
  // |                  | data            |                                    |
  // | target parallel  | teams           |                                    |
  // | target parallel  | cancellation    |                                    |
  // |                  | point           | !                                  |
  // | target parallel  | cancel          | !                                  |
  // | target parallel  | taskloop        | *                                  |
  // | target parallel  | taskloop simd   | *                                  |
  // | target parallel  | distribute      |                                    |
  // | target parallel  | distribute      |                                    |
  // |                  | parallel for    |                                    |
  // | target parallel  | distribute      |                                    |
  // |                  |parallel for simd|                                    |
  // | target parallel  | distribute simd |                                    |
  // | target parallel  | target parallel |                                    |
  // |                  | for simd        |                                    |
  // +------------------+-----------------+------------------------------------+
  // | target parallel  | parallel        | *                                  |
  // | for              |                 |                                    |
  // | target parallel  | for             | *                                  |
  // | for              |                 |                                    |
  // | target parallel  | for simd        | *                                  |
  // | for              |                 |                                    |
  // | target parallel  | master          | *                                  |
  // | for              |                 |                                    |
  // | target parallel  | critical        | *                                  |
  // | for              |                 |                                    |
  // | target parallel  | simd            | *                                  |
  // | for              |                 |                                    |
  // | target parallel  | sections        | *                                  |
  // | for              |                 |                                    |
  // | target parallel  | section         | *                                  |
  // | for              |                 |                                    |
  // | target parallel  | single          | *                                  |
  // | for              |                 |                                    |
  // | target parallel  | parallel for    | *                                  |
  // | for              |                 |                                    |
  // | target parallel  |parallel for simd| *                                  |
  // | for              |                 |                                    |
  // | target parallel  |parallel sections| *                                  |
  // | for              |                 |                                    |
  // | target parallel  | task            | *                                  |
  // | for              |                 |                                    |
  // | target parallel  | taskyield       | *                                  |
  // | for              |                 |                                    |
  // | target parallel  | barrier         | *                                  |
  // | for              |                 |                                    |
  // | target parallel  | taskwait        | *                                  |
  // | for              |                 |                                    |
  // | target parallel  | taskgroup       | *                                  |
  // | for              |                 |                                    |
  // | target parallel  | flush           | *                                  |
  // | for              |                 |                                    |
  // | target parallel  | ordered         | *                                  |
  // | for              |                 |                                    |
  // | target parallel  | atomic          | *                                  |
  // | for              |                 |                                    |
  // | target parallel  | target          |                                    |
  // | for              |                 |                                    |
  // | target parallel  | target parallel |                                    |
  // | for              |                 |                                    |
  // | target parallel  | target parallel |                                    |
  // | for              | for             |                                    |
  // | target parallel  | target enter    |                                    |
  // | for              | data            |                                    |
  // | target parallel  | target exit     |                                    |
  // | for              | data            |                                    |
  // | target parallel  | teams           |                                    |
  // | for              |                 |                                    |
  // | target parallel  | cancellation    |                                    |
  // | for              | point           | !                                  |
  // | target parallel  | cancel          | !                                  |
  // | for              |                 |                                    |
  // | target parallel  | taskloop        | *                                  |
  // | for              |                 |                                    |
  // | target parallel  | taskloop simd   | *                                  |
  // | for              |                 |                                    |
  // | target parallel  | distribute      |                                    |
  // | for              |                 |                                    |
  // | target parallel  | distribute      |                                    |
  // | for              | parallel for    |                                    |
  // | target parallel  | distribute      |                                    |
  // | for              |parallel for simd|                                    |
  // | target parallel  | distribute simd |                                    |
  // | for              |                 |                                    |
  // | target parallel  | target parallel |                                    |
  // | for              | for simd        |                                    |
  // +------------------+-----------------+------------------------------------+
  // | teams            | parallel        | *                                  |
  // | teams            | for             | +                                  |
  // | teams            | for simd        | +                                  |
  // | teams            | master          | +                                  |
  // | teams            | critical        | +                                  |
  // | teams            | simd            | +                                  |
  // | teams            | sections        | +                                  |
  // | teams            | section         | +                                  |
  // | teams            | single          | +                                  |
  // | teams            | parallel for    | *                                  |
  // | teams            |parallel for simd| *                                  |
  // | teams            |parallel sections| *                                  |
  // | teams            | task            | +                                  |
  // | teams            | taskyield       | +                                  |
  // | teams            | barrier         | +                                  |
  // | teams            | taskwait        | +                                  |
  // | teams            | taskgroup       | +                                  |
  // | teams            | flush           | +                                  |
  // | teams            | ordered         | +                                  |
  // | teams            | atomic          | +                                  |
  // | teams            | target          | +                                  |
  // | teams            | target parallel | +                                  |
  // | teams            | target parallel | +                                  |
  // |                  | for             |                                    |
  // | teams            | target enter    | +                                  |
  // |                  | data            |                                    |
  // | teams            | target exit     | +                                  |
  // |                  | data            |                                    |
  // | teams            | teams           | +                                  |
  // | teams            | cancellation    |                                    |
  // |                  | point           |                                    |
  // | teams            | cancel          |                                    |
  // | teams            | taskloop        | +                                  |
  // | teams            | taskloop simd   | +                                  |
  // | teams            | distribute      | !                                  |
  // | teams            | distribute      | !                                  |
  // |                  | parallel for    |                                    |
  // | teams            | distribute      | !                                  |
  // |                  |parallel for simd|                                    |
  // | teams            | distribute simd | !                                  |
  // | teams            | target parallel | +                                  |
  // |                  | for simd        |                                    |
  // +------------------+-----------------+------------------------------------+
  // | taskloop         | parallel        | *                                  |
  // | taskloop         | for             | +                                  |
  // | taskloop         | for simd        | +                                  |
  // | taskloop         | master          | +                                  |
  // | taskloop         | critical        | *                                  |
  // | taskloop         | simd            | *                                  |
  // | taskloop         | sections        | +                                  |
  // | taskloop         | section         | +                                  |
  // | taskloop         | single          | +                                  |
  // | taskloop         | parallel for    | *                                  |
  // | taskloop         |parallel for simd| *                                  |
  // | taskloop         |parallel sections| *                                  |
  // | taskloop         | task            | *                                  |
  // | taskloop         | taskyield       | *                                  |
  // | taskloop         | barrier         | +                                  |
  // | taskloop         | taskwait        | *                                  |
  // | taskloop         | taskgroup       | *                                  |
  // | taskloop         | flush           | *                                  |
  // | taskloop         | ordered         | +                                  |
  // | taskloop         | atomic          | *                                  |
  // | taskloop         | target          | *                                  |
  // | taskloop         | target parallel | *                                  |
  // | taskloop         | target parallel | *                                  |
  // |                  | for             |                                    |
  // | taskloop         | target enter    | *                                  |
  // |                  | data            |                                    |
  // | taskloop         | target exit     | *                                  |
  // |                  | data            |                                    |
  // | taskloop         | teams           | +                                  |
  // | taskloop         | cancellation    |                                    |
  // |                  | point           |                                    |
  // | taskloop         | cancel          |                                    |
  // | taskloop         | taskloop        | *                                  |
  // | taskloop         | distribute      | +                                  |
  // | taskloop         | distribute      | +                                  |
  // |                  | parallel for    |                                    |
  // | taskloop         | distribute      | +                                  |
  // |                  |parallel for simd|                                    |
  // | taskloop         | distribute simd | +                                  |
  // | taskloop         | target parallel | *                                  |
  // |                  | for simd        |                                    |
  // +------------------+-----------------+------------------------------------+
  // | taskloop simd    | parallel        |                                    |
  // | taskloop simd    | for             |                                    |
  // | taskloop simd    | for simd        |                                    |
  // | taskloop simd    | master          |                                    |
  // | taskloop simd    | critical        |                                    |
  // | taskloop simd    | simd            | *                                  |
  // | taskloop simd    | sections        |                                    |
  // | taskloop simd    | section         |                                    |
  // | taskloop simd    | single          |                                    |
  // | taskloop simd    | parallel for    |                                    |
  // | taskloop simd    |parallel for simd|                                    |
  // | taskloop simd    |parallel sections|                                    |
  // | taskloop simd    | task            |                                    |
  // | taskloop simd    | taskyield       |                                    |
  // | taskloop simd    | barrier         |                                    |
  // | taskloop simd    | taskwait        |                                    |
  // | taskloop simd    | taskgroup       |                                    |
  // | taskloop simd    | flush           |                                    |
  // | taskloop simd    | ordered         | + (with simd clause)               |
  // | taskloop simd    | atomic          |                                    |
  // | taskloop simd    | target          |                                    |
  // | taskloop simd    | target parallel |                                    |
  // | taskloop simd    | target parallel |                                    |
  // |                  | for             |                                    |
  // | taskloop simd    | target enter    |                                    |
  // |                  | data            |                                    |
  // | taskloop simd    | target exit     |                                    |
  // |                  | data            |                                    |
  // | taskloop simd    | teams           |                                    |
  // | taskloop simd    | cancellation    |                                    |
  // |                  | point           |                                    |
  // | taskloop simd    | cancel          |                                    |
  // | taskloop simd    | taskloop        |                                    |
  // | taskloop simd    | taskloop simd   |                                    |
  // | taskloop simd    | distribute      |                                    |
  // | taskloop simd    | distribute      |                                    |
  // |                  | parallel for    |                                    |
  // | taskloop simd    | distribute      |                                    |
  // |                  |parallel for simd|                                    |
  // | taskloop simd    | distribute simd |                                    |
  // | taskloop simd    | target parallel |                                    |
  // |                  | for simd        |                                    |
  // +------------------+-----------------+------------------------------------+
  // | distribute       | parallel        | *                                  |
  // | distribute       | for             | *                                  |
  // | distribute       | for simd        | *                                  |
  // | distribute       | master          | *                                  |
  // | distribute       | critical        | *                                  |
  // | distribute       | simd            | *                                  |
  // | distribute       | sections        | *                                  |
  // | distribute       | section         | *                                  |
  // | distribute       | single          | *                                  |
  // | distribute       | parallel for    | *                                  |
  // | distribute       |parallel for simd| *                                  |
  // | distribute       |parallel sections| *                                  |
  // | distribute       | task            | *                                  |
  // | distribute       | taskyield       | *                                  |
  // | distribute       | barrier         | *                                  |
  // | distribute       | taskwait        | *                                  |
  // | distribute       | taskgroup       | *                                  |
  // | distribute       | flush           | *                                  |
  // | distribute       | ordered         | +                                  |
  // | distribute       | atomic          | *                                  |
  // | distribute       | target          |                                    |
  // | distribute       | target parallel |                                    |
  // | distribute       | target parallel |                                    |
  // |                  | for             |                                    |
  // | distribute       | target enter    |                                    |
  // |                  | data            |                                    |
  // | distribute       | target exit     |                                    |
  // |                  | data            |                                    |
  // | distribute       | teams           |                                    |
  // | distribute       | cancellation    | +                                  |
  // |                  | point           |                                    |
  // | distribute       | cancel          | +                                  |
  // | distribute       | taskloop        | *                                  |
  // | distribute       | taskloop simd   | *                                  |
  // | distribute       | distribute      |                                    |
  // | distribute       | distribute      |                                    |
  // |                  | parallel for    |                                    |
  // | distribute       | distribute      |                                    |
  // |                  |parallel for simd|                                    |
  // | distribute       | distribute simd |                                    |
  // | distribute       | target parallel |                                    |
  // |                  | for simd        |                                    |
  // +------------------+-----------------+------------------------------------+
  // | distribute       | parallel        | *                                  |
  // | parallel for     |                 |                                    |
  // | distribute       | for             | *                                  |
  // | parallel for     |                 |                                    |
  // | distribute       | for simd        | *                                  |
  // | parallel for     |                 |                                    |
  // | distribute       | master          | *                                  |
  // | parallel for     |                 |                                    |
  // | distribute       | critical        | *                                  |
  // | parallel for     |                 |                                    |
  // | distribute       | simd            | *                                  |
  // | parallel for     |                 |                                    |
  // | distribute       | sections        | *                                  |
  // | parallel for     |                 |                                    |
  // | distribute       | section         | *                                  |
  // | parallel for     |                 |                                    |
  // | distribute       | single          | *                                  |
  // | parallel for     |                 |                                    |
  // | distribute       | parallel for    | *                                  |
  // | parallel for     |                 |                                    |
  // | distribute       |parallel for simd| *                                  |
  // | parallel for     |                 |                                    |
  // | distribute       |parallel sections| *                                  |
  // | parallel for     |                 |                                    |
  // | distribute       | task            | *                                  |
  // | parallel for     |                 |                                    |
  // | parallel for     |                 |                                    |
  // | distribute       | taskyield       | *                                  |
  // | parallel for     |                 |                                    |
  // | distribute       | barrier         | *                                  |
  // | parallel for     |                 |                                    |
  // | distribute       | taskwait        | *                                  |
  // | parallel for     |                 |                                    |
  // | distribute       | taskgroup       | *                                  |
  // | parallel for     |                 |                                    |
  // | distribute       | flush           | *                                  |
  // | parallel for     |                 |                                    |
  // | distribute       | ordered         | +                                  |
  // | parallel for     |                 |                                    |
  // | distribute       | atomic          | *                                  |
  // | parallel for     |                 |                                    |
  // | distribute       | target          |                                    |
  // | parallel for     |                 |                                    |
  // | distribute       | target parallel |                                    |
  // | parallel for     |                 |                                    |
  // | distribute       | target parallel |                                    |
  // | parallel for     | for             |                                    |
  // | distribute       | target enter    |                                    |
  // | parallel for     | data            |                                    |
  // | distribute       | target exit     |                                    |
  // | parallel for     | data            |                                    |
  // | distribute       | teams           |                                    |
  // | parallel for     |                 |                                    |
  // | distribute       | cancellation    | +                                  |
  // | parallel for     | point           |                                    |
  // | distribute       | cancel          | +                                  |
  // | parallel for     |                 |                                    |
  // | distribute       | taskloop        | *                                  |
  // | parallel for     |                 |                                    |
  // | distribute       | taskloop simd   | *                                  |
  // | parallel for     |                 |                                    |
  // | distribute       | distribute      |                                    |
  // | parallel for     |                 |                                    |
  // | distribute       | distribute      |                                    |
  // | parallel for     | parallel for    |                                    |
  // | distribute       | distribute      |                                    |
  // | parallel for     |parallel for simd|                                    |
  // | distribute       | distribute simd |                                    |
  // | parallel for     |                 |                                    |
  // | distribute       | target parallel |                                    |
  // | parallel for     | for simd        |                                    |
  // +------------------+-----------------+------------------------------------+
  // | distribute       | parallel        | *                                  |
  // | parallel for simd|                 |                                    |
  // | distribute       | for             | *                                  |
  // | parallel for simd|                 |                                    |
  // | distribute       | for simd        | *                                  |
  // | parallel for simd|                 |                                    |
  // | distribute       | master          | *                                  |
  // | parallel for simd|                 |                                    |
  // | distribute       | critical        | *                                  |
  // | parallel for simd|                 |                                    |
  // | distribute       | simd            | *                                  |
  // | parallel for simd|                 |                                    |
  // | distribute       | sections        | *                                  |
  // | parallel for simd|                 |                                    |
  // | distribute       | section         | *                                  |
  // | parallel for simd|                 |                                    |
  // | distribute       | single          | *                                  |
  // | parallel for simd|                 |                                    |
  // | distribute       | parallel for    | *                                  |
  // | parallel for simd|                 |                                    |
  // | distribute       |parallel for simd| *                                  |
  // | parallel for simd|                 |                                    |
  // | distribute       |parallel sections| *                                  |
  // | parallel for simd|                 |                                    |
  // | distribute       | task            | *                                  |
  // | parallel for simd|                 |                                    |
  // | distribute       | taskyield       | *                                  |
  // | parallel for simd|                 |                                    |
  // | distribute       | barrier         | *                                  |
  // | parallel for simd|                 |                                    |
  // | distribute       | taskwait        | *                                  |
  // | parallel for simd|                 |                                    |
  // | distribute       | taskgroup       | *                                  |
  // | parallel for simd|                 |                                    |
  // | distribute       | flush           | *                                  |
  // | parallel for simd|                 |                                    |
  // | distribute       | ordered         | +                                  |
  // | parallel for simd|                 |                                    |
  // | distribute       | atomic          | *                                  |
  // | parallel for simd|                 |                                    |
  // | distribute       | target          |                                    |
  // | parallel for simd|                 |                                    |
  // | distribute       | target parallel |                                    |
  // | parallel for simd|                 |                                    |
  // | distribute       | target parallel |                                    |
  // | parallel for simd| for             |                                    |
  // | distribute       | target enter    |                                    |
  // | parallel for simd| data            |                                    |
  // | distribute       | target exit     |                                    |
  // | parallel for simd| data            |                                    |
  // | distribute       | teams           |                                    |
  // | parallel for simd|                 |                                    |
  // | distribute       | cancellation    | +                                  |
  // | parallel for simd| point           |                                    |
  // | distribute       | cancel          | +                                  |
  // | parallel for simd|                 |                                    |
  // | distribute       | taskloop        | *                                  |
  // | parallel for simd|                 |                                    |
  // | distribute       | taskloop simd   | *                                  |
  // | parallel for simd|                 |                                    |
  // | distribute       | distribute      |                                    |
  // | parallel for simd|                 |                                    |
  // | distribute       | distribute      | *                                  |
  // | parallel for simd| parallel for    |                                    |
  // | distribute       | distribute      | *                                  |
  // | parallel for simd|parallel for simd|                                    |
  // | distribute       | distribute simd | *                                  |
  // | parallel for simd|                 |                                    |
  // | distribute       | target parallel |                                    |
  // | parallel for simd| for simd        |                                    |
  // +------------------+-----------------+------------------------------------+
  // | distribute simd  | parallel        | *                                  |
  // | distribute simd  | for             | *                                  |
  // | distribute simd  | for simd        | *                                  |
  // | distribute simd  | master          | *                                  |
  // | distribute simd  | critical        | *                                  |
  // | distribute simd  | simd            | *                                  |
  // | distribute simd  | sections        | *                                  |
  // | distribute simd  | section         | *                                  |
  // | distribute simd  | single          | *                                  |
  // | distribute simd  | parallel for    | *                                  |
  // | distribute simd  |parallel for simd| *                                  |
  // | distribute simd  |parallel sections| *                                  |
  // | distribute simd  | task            | *                                  |
  // | distribute simd  | taskyield       | *                                  |
  // | distribute simd  | barrier         | *                                  |
  // | distribute simd  | taskwait        | *                                  |
  // | distribute simd  | taskgroup       | *                                  |
  // | distribute simd  | flush           | *                                  |
  // | distribute simd  | ordered         | +                                  |
  // | distribute simd  | atomic          | *                                  |
  // | distribute simd  | target          | *                                  |
  // | distribute simd  | target parallel | *                                  |
  // | distribute simd  | target parallel | *                                  |
  // |                  | for             |                                    |
  // | distribute simd  | target enter    | *                                  |
  // |                  | data            |                                    |
  // | distribute simd  | target exit     | *                                  |
  // |                  | data            |                                    |
  // | distribute simd  | teams           | *                                  |
  // | distribute simd  | cancellation    | +                                  |
  // |                  | point           |                                    |
  // | distribute simd  | cancel          | +                                  |
  // | distribute simd  | taskloop        | *                                  |
  // | distribute simd  | taskloop simd   | *                                  |
  // | distribute simd  | distribute      |                                    |
  // | distribute simd  | distribute      | *                                  |
  // |                  | parallel for    |                                    |
  // | distribute simd  | distribute      | *                                  |
  // |                  |parallel for simd|                                    |
  // | distribute simd  | distribute simd | *                                  |
  // | distribute simd  | target parallel | *                                  |
  // |                  | for simd        |                                    |
  // +------------------+-----------------+------------------------------------+
  // | target parallel  | parallel        | *                                  |
  // | for simd         |                 |                                    |
  // | target parallel  | for             | *                                  |
  // | for simd         |                 |                                    |
  // | target parallel  | for simd        | *                                  |
  // | for simd         |                 |                                    |
  // | target parallel  | master          | *                                  |
  // | for simd         |                 |                                    |
  // | target parallel  | critical        | *                                  |
  // | for simd         |                 |                                    |
  // | target parallel  | simd            | !                                  |
  // | for simd         |                 |                                    |
  // | target parallel  | sections        | *                                  |
  // | for simd         |                 |                                    |
  // | target parallel  | section         | *                                  |
  // | for simd         |                 |                                    |
  // | target parallel  | single          | *                                  |
  // | for simd         |                 |                                    |
  // | target parallel  | parallel for    | *                                  |
  // | for simd         |                 |                                    |
  // | target parallel  |parallel for simd| *                                  |
  // | for simd         |                 |                                    |
  // | target parallel  |parallel sections| *                                  |
  // | for simd         |                 |                                    |
  // | target parallel  | task            | *                                  |
  // | for simd         |                 |                                    |
  // | target parallel  | taskyield       | *                                  |
  // | for simd         |                 |                                    |
  // | target parallel  | barrier         | *                                  |
  // | for simd         |                 |                                    |
  // | target parallel  | taskwait        | *                                  |
  // | for simd         |                 |                                    |
  // | target parallel  | taskgroup       | *                                  |
  // | for simd         |                 |                                    |
  // | target parallel  | flush           | *                                  |
  // | for simd         |                 |                                    |
  // | target parallel  | ordered         | + (with simd clause)               |
  // | for simd         |                 |                                    |
  // | target parallel  | atomic          | *                                  |
  // | for simd         |                 |                                    |
  // | target parallel  | target          | *                                  |
  // | for simd         |                 |                                    |
  // | target parallel  | target parallel | *                                  |
  // | for simd         |                 |                                    |
  // | target parallel  | target parallel | *                                  |
  // | for simd         | for             |                                    |
  // | target parallel  | target enter    | *                                  |
  // | for simd         | data            |                                    |
  // | target parallel  | target exit     | *                                  |
  // | for simd         | data            |                                    |
  // | target parallel  | teams           | *                                  |
  // | for simd         |                 |                                    |
  // | target parallel  | cancellation    | *                                  |
  // | for simd         | point           |                                    |
  // | target parallel  | cancel          | *                                  |
  // | for simd         |                 |                                    |
  // | target parallel  | taskloop        | *                                  |
  // | for simd         |                 |                                    |
  // | target parallel  | taskloop simd   | *                                  |
  // | for simd         |                 |                                    |
  // | target parallel  | distribute      | *                                  |
  // | for simd         |                 |                                    |
  // | target parallel  | distribute      | *                                  |
  // | for simd         | parallel for    |                                    |
  // | target parallel  | distribute      | *                                  |
  // | for simd         |parallel for simd|                                    |
  // | target parallel  | distribute simd | *                                  |
  // | for simd         |                 |                                    |
  // | target parallel  | target parallel | *                                  |
  // | for simd         | for simd        |                                    |
  // +------------------+-----------------+------------------------------------+
  if ((Stack.getCurScope() != null)) {
    OpenMPDirectiveKind ParentRegion = Stack.getParentDirective();
    final type$ref<OpenMPDirectiveKind> OffendingRegion = create_type$ref(ParentRegion);
    boolean NestingProhibited = false;
    boolean CloseNesting = true;
    /*enum ANONYMOUS_INT_CONSTANTS {*/
      final /*uint*/int NoRecommend = 0;
      final /*uint*/int ShouldBeInParallelRegion = NoRecommend + 1;
      final /*uint*/int ShouldBeInOrderedRegion = ShouldBeInParallelRegion + 1;
      final /*uint*/int ShouldBeInTargetRegion = ShouldBeInOrderedRegion + 1;
      final /*uint*/int ShouldBeInTeamsRegion = ShouldBeInTargetRegion + 1;
    /*}*//*Unnamed enum*//*uint*/int Recommend = NoRecommend;
    if (isOpenMPSimdDirective(ParentRegion) && CurrentRegion != OpenMPDirectiveKind.OMPD_ordered) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // OpenMP [2.16, Nesting of Regions]
        // OpenMP constructs may not be nested inside a simd region.
        // OpenMP [2.8.1,simd Construct, Restrictions]
        // An ordered construct with the simd clause is the only OpenMP
        // construct that can appear in the simd region.
        // Allowing a SIMD consruct nested in another SIMD construct is an
        // extension. The OpenMP 4.5 spec does not allow it. Issue a warning
        // message.
        $c$.clean($c$.track(SemaRef.Diag(new SourceLocation(StartLoc), (CurrentRegion != OpenMPDirectiveKind.OMPD_simd) ? diag.err_omp_prohibited_region_simd : diag.warn_omp_nesting_simd)));
        return CurrentRegion != OpenMPDirectiveKind.OMPD_simd;
      } finally {
        $c$.$destroy();
      }
    }
    if (ParentRegion == OpenMPDirectiveKind.OMPD_atomic) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // OpenMP [2.16, Nesting of Regions]
        // OpenMP constructs may not be nested inside an atomic region.
        $c$.clean($c$.track(SemaRef.Diag(new SourceLocation(StartLoc), diag.err_omp_prohibited_region_atomic)));
        return true;
      } finally {
        $c$.$destroy();
      }
    }
    if (CurrentRegion == OpenMPDirectiveKind.OMPD_section) {
      // OpenMP [2.7.2, sections Construct, Restrictions]
      // Orphaned section directives are prohibited. That is, the section
      // directives must appear within the sections construct and must not be
      // encountered elsewhere in the sections region.
      if (ParentRegion != OpenMPDirectiveKind.OMPD_sections
         && ParentRegion != OpenMPDirectiveKind.OMPD_parallel_sections) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(new SourceLocation(StartLoc), diag.err_omp_orphaned_section_directive)), 
                  (ParentRegion != OpenMPDirectiveKind.OMPD_unknown)), 
              getOpenMPDirectiveName(ParentRegion)));
          return true;
        } finally {
          $c$.$destroy();
        }
      }
      return false;
    }
    // Allow some constructs to be orphaned (they could be used in functions,
    // called from OpenMP regions with the required preconditions).
    if (ParentRegion == OpenMPDirectiveKind.OMPD_unknown) {
      return false;
    }
    if (CurrentRegion == OpenMPDirectiveKind.OMPD_cancellation_point
       || CurrentRegion == OpenMPDirectiveKind.OMPD_cancel) {
      // OpenMP [2.16, Nesting of Regions]
      // A cancellation point construct for which construct-type-clause is
      // taskgroup must be nested inside a task construct. A cancellation
      // point construct for which construct-type-clause is not taskgroup must
      // be closely nested inside an OpenMP construct that matches the type
      // specified in construct-type-clause.
      // A cancel construct for which construct-type-clause is taskgroup must be
      // nested inside a task construct. A cancel construct for which
      // construct-type-clause is not taskgroup must be closely nested inside an
      // OpenMP construct that matches the type specified in
      // construct-type-clause.
      NestingProhibited
         = !((CancelRegion == OpenMPDirectiveKind.OMPD_parallel
         && (ParentRegion == OpenMPDirectiveKind.OMPD_parallel
         || ParentRegion == OpenMPDirectiveKind.OMPD_target_parallel))
         || (CancelRegion == OpenMPDirectiveKind.OMPD_for
         && (ParentRegion == OpenMPDirectiveKind.OMPD_for || ParentRegion == OpenMPDirectiveKind.OMPD_parallel_for
         || ParentRegion == OpenMPDirectiveKind.OMPD_target_parallel_for))
         || (CancelRegion == OpenMPDirectiveKind.OMPD_taskgroup && ParentRegion == OpenMPDirectiveKind.OMPD_task)
         || (CancelRegion == OpenMPDirectiveKind.OMPD_sections
         && (ParentRegion == OpenMPDirectiveKind.OMPD_section || ParentRegion == OpenMPDirectiveKind.OMPD_sections
         || ParentRegion == OpenMPDirectiveKind.OMPD_parallel_sections)));
    } else if (CurrentRegion == OpenMPDirectiveKind.OMPD_master) {
      // OpenMP [2.16, Nesting of Regions]
      // A master region may not be closely nested inside a worksharing,
      // atomic, or explicit task region.
      NestingProhibited = isOpenMPWorksharingDirective(ParentRegion)
         || isOpenMPTaskingDirective(ParentRegion);
    } else if (CurrentRegion == OpenMPDirectiveKind.OMPD_critical && CurrentName.getName().$bool()) {
      // OpenMP [2.16, Nesting of Regions]
      // A critical region may not be nested (closely or otherwise) inside a
      // critical region with the same name. Note that this restriction is not
      // sufficient to prevent deadlock.
      SourceLocation PreviousCriticalLoc/*J*/= new SourceLocation();
      final DeclarationNameInfo L$CurrentName = new DeclarationNameInfo(CurrentName.getName(), CurrentName.getLoc(), CurrentName.getInfo());
      boolean DeadLock = Stack.hasDirective(/*FuncArg*//*[=L$CurrentName(CurrentName), &PreviousCriticalLoc]*/ (OpenMPDirectiveKind K, final /*const*/ DeclarationNameInfo /*&*/ DNI, SourceLocation Loc) -> {
                if (K == OpenMPDirectiveKind.OMPD_critical
                   && $eq_DeclarationName(DNI.getName(), L$CurrentName.getName())) {
                  PreviousCriticalLoc.$assign(Loc);
                  return true;
                } else {
                  return false;
                }
              }, 
          false/* skip top directive */);
      if (DeadLock) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(new SourceLocation(StartLoc), 
                  diag.err_omp_prohibited_region_critical_same_name)), 
              CurrentName.getName()));
          if (PreviousCriticalLoc.isValid()) {
            $c$.clean($c$.track(SemaRef.Diag(new SourceLocation(PreviousCriticalLoc), 
                diag.note_omp_previous_critical_region)));
          }
          return true;
        } finally {
          $c$.$destroy();
        }
      }
    } else if (CurrentRegion == OpenMPDirectiveKind.OMPD_barrier) {
      // OpenMP [2.16, Nesting of Regions]
      // A barrier region may not be closely nested inside a worksharing,
      // explicit task, critical, ordered, atomic, or master region.
      NestingProhibited = isOpenMPWorksharingDirective(ParentRegion)
         || isOpenMPTaskingDirective(ParentRegion)
         || ParentRegion == OpenMPDirectiveKind.OMPD_master
         || ParentRegion == OpenMPDirectiveKind.OMPD_critical
         || ParentRegion == OpenMPDirectiveKind.OMPD_ordered;
    } else if (isOpenMPWorksharingDirective(CurrentRegion)
       && !isOpenMPParallelDirective(CurrentRegion)) {
      // OpenMP [2.16, Nesting of Regions]
      // A worksharing region may not be closely nested inside a worksharing,
      // explicit task, critical, ordered, atomic, or master region.
      NestingProhibited = isOpenMPWorksharingDirective(ParentRegion)
         || isOpenMPTaskingDirective(ParentRegion)
         || ParentRegion == OpenMPDirectiveKind.OMPD_master
         || ParentRegion == OpenMPDirectiveKind.OMPD_critical
         || ParentRegion == OpenMPDirectiveKind.OMPD_ordered;
      Recommend = ShouldBeInParallelRegion;
    } else if (CurrentRegion == OpenMPDirectiveKind.OMPD_ordered) {
      // OpenMP [2.16, Nesting of Regions]
      // An ordered region may not be closely nested inside a critical,
      // atomic, or explicit task region.
      // An ordered region must be closely nested inside a loop region (or
      // parallel loop region) with an ordered clause.
      // OpenMP [2.8.1,simd Construct, Restrictions]
      // An ordered construct with the simd clause is the only OpenMP construct
      // that can appear in the simd region.
      NestingProhibited = ParentRegion == OpenMPDirectiveKind.OMPD_critical
         || isOpenMPTaskingDirective(ParentRegion)
         || !(isOpenMPSimdDirective(ParentRegion)
         || Stack.isParentOrderedRegion());
      Recommend = ShouldBeInOrderedRegion;
    } else if (isOpenMPTeamsDirective(CurrentRegion)) {
      // OpenMP [2.16, Nesting of Regions]
      // If specified, a teams construct must be contained within a target
      // construct.
      NestingProhibited = ParentRegion != OpenMPDirectiveKind.OMPD_target;
      Recommend = ShouldBeInTargetRegion;
      Stack.setParentTeamsRegionLoc(Stack.getConstructLoc());
    }
    if (!NestingProhibited && isOpenMPTeamsDirective(ParentRegion)) {
      // OpenMP [2.16, Nesting of Regions]
      // distribute, parallel, parallel sections, parallel workshare, and the
      // parallel loop and parallel loop SIMD constructs are the only OpenMP
      // constructs that can be closely nested in the teams region.
      NestingProhibited = !isOpenMPParallelDirective(CurrentRegion)
         && !isOpenMPDistributeDirective(CurrentRegion);
      Recommend = ShouldBeInParallelRegion;
    }
    if (!NestingProhibited && isOpenMPDistributeDirective(CurrentRegion)) {
      // OpenMP 4.5 [2.17 Nesting of Regions]
      // The region associated with the distribute construct must be strictly
      // nested inside a teams region
      NestingProhibited = !isOpenMPTeamsDirective(ParentRegion);
      Recommend = ShouldBeInTeamsRegion;
    }
    if (!NestingProhibited
       && (isOpenMPTargetExecutionDirective(CurrentRegion)
       || isOpenMPTargetDataManagementDirective(CurrentRegion))) {
      // OpenMP 4.5 [2.17 Nesting of Regions]
      // If a target, target update, target data, target enter data, or
      // target exit data construct is encountered during execution of a
      // target region, the behavior is unspecified.
      NestingProhibited = Stack.hasDirective(/*FuncArg*//*[&OffendingRegion]*/ (OpenMPDirectiveKind K, final /*const*/ DeclarationNameInfo /*&*/ $Prm1, SourceLocation $Prm2) -> {
                if (isOpenMPTargetExecutionDirective(K)) {
                  OffendingRegion.$set(K);
                  return true;
                } else {
                  return false;
                }
              }, 
          false/* don't skip top directive */);
      CloseNesting = false;
    }
    if (NestingProhibited) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(new SourceLocation(StartLoc), diag.err_omp_prohibited_region)), 
                        CloseNesting), getOpenMPDirectiveName(OffendingRegion.$deref())), 
                Recommend), getOpenMPDirectiveName(CurrentRegion)));
        return true;
      } finally {
        $c$.$destroy();
      }
    }
  }
  return false;
}

//<editor-fold defaultstate="collapsed" desc="checkIfClauses">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 3297,
 FQN="checkIfClauses", NM="_ZL14checkIfClausesRN5clang4SemaENS_19OpenMPDirectiveKindEN4llvm8ArrayRefIPNS_9OMPClauseEEENS4_IS2_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZL14checkIfClausesRN5clang4SemaENS_19OpenMPDirectiveKindEN4llvm8ArrayRefIPNS_9OMPClauseEEENS4_IS2_EE")
//</editor-fold>
public static boolean checkIfClauses(final Sema /*&*/ S, OpenMPDirectiveKind Kind, 
              ArrayRef<OMPClause /*P*/ > Clauses, 
              ArrayRef<OpenMPDirectiveKind> AllowedNameModifiers) {
  boolean ErrorFound = false;
  /*uint*/int NamedModifiersNumber = 0;
  SmallVector</*const*/ OMPIfClause /*P*/ > FoundNameModifiers/*J*/= new SmallVector</*const*/ OMPIfClause /*P*/ >(JD$UInt_T$C$R.INSTANCE, OpenMPClauseKind.OMPC_unknown.getValue() + 1, OpenMPDirectiveKind.OMPD_unknown.getValue() + 1, (/*const*/ OMPIfClause /*P*/ )null);
  SmallVector<SourceLocation> NameModifierLoc/*J*/= new SmallVector<SourceLocation>(4, new SourceLocation());
  for (/*const*/ OMPClause /*P*/ C : Clauses) {
    {
      /*const*/ OMPIfClause /*P*/ IC = dyn_cast_or_null_OMPIfClause(C);
      if ((IC != null)) {
        // At most one if clause without a directive-name-modifier can appear on
        // the directive.
        OpenMPDirectiveKind CurNM = IC.getNameModifier();
        if ((FoundNameModifiers.$at(/*KEEP_ENUM*/CurNM.getValue()) != null)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(C.getLocStart(), diag.err_omp_more_one_clause)), 
                            getOpenMPDirectiveName(Kind)), getOpenMPClauseName(OpenMPClauseKind.OMPC_if)), 
                    (CurNM != OpenMPDirectiveKind.OMPD_unknown)), getOpenMPDirectiveName(CurNM)));
            ErrorFound = true;
          } finally {
            $c$.$destroy();
          }
        } else if (CurNM != OpenMPDirectiveKind.OMPD_unknown) {
          NameModifierLoc.push_back(IC.getNameModifierLoc());
          ++NamedModifiersNumber;
        }
        FoundNameModifiers.$set(/*KEEP_ENUM*/CurNM.getValue(), IC);
        if (CurNM == OpenMPDirectiveKind.OMPD_unknown) {
          continue;
        }
        // Check if the specified name modifier is allowed for the current
        // directive.
        // At most one if clause with the particular directive-name-modifier can
        // appear on the directive.
        boolean MatchFound = false;
        for (OpenMPDirectiveKind NM : AllowedNameModifiers) {
          if (CurNM == NM) {
            MatchFound = true;
            break;
          }
        }
        if (!MatchFound) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(IC.getNameModifierLoc(), 
                        diag.err_omp_wrong_if_directive_name_modifier)), 
                    getOpenMPDirectiveName(CurNM)), getOpenMPDirectiveName(Kind)));
            ErrorFound = true;
          } finally {
            $c$.$destroy();
          }
        }
      }
    }
  }
  // If any if clause on the directive includes a directive-name-modifier then
  // all if clauses on the directive must include a directive-name-modifier.
  if ((FoundNameModifiers.$at(/*KEEP_ENUM*/OpenMPDirectiveKind.OMPD_unknown.getValue()) != null) && $greater_uint(NamedModifiersNumber, 0)) {
    if (NamedModifiersNumber == AllowedNameModifiers.size()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track(S.Diag(FoundNameModifiers.$at(/*KEEP_ENUM*/OpenMPDirectiveKind.OMPD_unknown.getValue()).getLocStart(), 
            diag.err_omp_no_more_if_clause)));
      } finally {
        $c$.$destroy();
      }
    } else {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        std.string Values/*J*/= new std.string();
        std.string Sep/*J*/= new std.string(/*KEEP_STR*/$COMMA_SPACE);
        /*uint*/int AllowedCnt = 0;
        /*uint*/int TotalAllowedNum = AllowedNameModifiers.size() - NamedModifiersNumber;
        for (/*uint*/int Cnt = 0, End = AllowedNameModifiers.size(); $less_uint(Cnt, End);
             ++Cnt) {
          OpenMPDirectiveKind NM = AllowedNameModifiers.$at(Cnt);
          if (!(FoundNameModifiers.$at(/*KEEP_ENUM*/NM.getValue()) != null)) {
            Values.$addassign_T$C$P(/*KEEP_STR*/"'");
            Values.$addassign_T$C$P(getOpenMPDirectiveName(NM));
            Values.$addassign_T$C$P(/*KEEP_STR*/"'");
            if (AllowedCnt + 2 == TotalAllowedNum) {
              Values.$addassign_T$C$P(/*KEEP_STR*/" or ");
            } else if (AllowedCnt + 1 != TotalAllowedNum) {
              Values.$addassign(Sep);
            }
            ++AllowedCnt;
          }
        }
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(FoundNameModifiers.$at(/*KEEP_ENUM*/OpenMPDirectiveKind.OMPD_unknown.getValue()).getCondition().getLocStart(), 
                    diag.err_omp_unnamed_if_clause)), 
                ($greater_uint(TotalAllowedNum, 1))), Values));
      } finally {
        $c$.$destroy();
      }
    }
    for (SourceLocation Loc : NameModifierLoc) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track(S.Diag(new SourceLocation(Loc), diag.note_omp_previous_named_if_clause)));
      } finally {
        $c$.$destroy();
      }
    }
    ErrorFound = true;
  }
  return ErrorFound;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::getExprAsWritten">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 4002,
 FQN="(anonymous namespace)::getExprAsWritten", NM="_ZN12_GLOBAL__N_1L16getExprAsWrittenEPN5clang4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN12_GLOBAL__N_1L16getExprAsWrittenEPN5clang4ExprE")
//</editor-fold>
public static Expr /*P*/ getExprAsWritten(Expr /*P*/ E) {
  {
    ExprWithCleanups /*P*/ ExprTemp = dyn_cast_ExprWithCleanups(E);
    if ((ExprTemp != null)) {
      E = ExprTemp.getSubExpr();
    }
  }
  {
    
    MaterializeTemporaryExpr /*P*/ MTE = dyn_cast_MaterializeTemporaryExpr(E);
    if ((MTE != null)) {
      E = MTE.GetTemporaryExpr();
    }
  }
  {
    
    CXXBindTemporaryExpr /*P*/ Binder;
    while (((/*P*/ Binder = dyn_cast_CXXBindTemporaryExpr(E)) != null)) {
      E = Binder.getSubExpr();
    }
  }
  {
    
    ImplicitCastExpr /*P*/ ICE = dyn_cast_ImplicitCastExpr(E);
    if ((ICE != null)) {
      E = ICE.getSubExprAsWritten();
    }
  }
  return E.IgnoreParens();
}


/// \brief Ignore parenthesizes, implicit casts, copy constructor and return the
/// variable (which may be the loop variable) if possible.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::GetInitLCDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 4186,
 FQN="(anonymous namespace)::GetInitLCDecl", NM="_ZN12_GLOBAL__N_1L13GetInitLCDeclEPN5clang4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN12_GLOBAL__N_1L13GetInitLCDeclEPN5clang4ExprE")
//</editor-fold>
public static /*const*/ ValueDecl /*P*/ GetInitLCDecl(Expr /*P*/ E) {
  if (!(E != null)) {
    return null;
  }
  E = getExprAsWritten(E);
  {
    CXXConstructExpr /*P*/ CE = dyn_cast_or_null_CXXConstructExpr(E);
    if ((CE != null)) {
      {
        /*const*/ CXXConstructorDecl /*P*/ Ctor = CE.getConstructor();
        if ((Ctor != null)) {
          if ((Ctor.isCopyOrMoveConstructor()
             || Ctor.isConvertingConstructor(/*AllowExplicit=*/ false))
             && $greater_uint(CE.getNumArgs(), 0) && CE.getArg(0) != null) {
            E = CE.getArg(0).IgnoreParenImpCasts();
          }
        }
      }
    }
  }
  {
    DeclRefExpr /*P*/ DRE = dyn_cast_or_null_DeclRefExpr(E);
    if ((DRE != null)) {
      {
        VarDecl /*P*/ VD = dyn_cast_VarDecl(DRE.getDecl());
        if ((VD != null)) {
          {
            OMPCapturedExprDecl /*P*/ CED = dyn_cast_OMPCapturedExprDecl(VD);
            if ((CED != null)) {
              {
                MemberExpr /*P*/ ME = dyn_cast_MemberExpr(getExprAsWritten(CED.getInit()));
                if ((ME != null)) {
                  return getCanonicalDecl(ME.getMemberDecl());
                }
              }
            }
          }
          return getCanonicalDecl(VD);
        }
      }
    }
  }
  {
    MemberExpr /*P*/ ME = dyn_cast_or_null_MemberExpr(E);
    if ((ME != null)) {
      if (ME.isArrow() && isa_CXXThisExpr(ME.getBase().IgnoreParenImpCasts())) {
        return getCanonicalDecl(ME.getMemberDecl());
      }
    }
  }
  return null;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::tryBuildCapture">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 4372,
 FQN="(anonymous namespace)::tryBuildCapture", NM="_ZN12_GLOBAL__N_1L15tryBuildCaptureERN5clang4SemaEPNS0_4ExprERN4llvm9MapVectorIS4_PNS0_11DeclRefExprENS5_8DenseMapIS4_jNS5_12DenseMapInfoIS4_EENS5_6detail12DenseMapPairIS4_jEEEESt6vectorISt4pairIS4_S8_ESaISI_EEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN12_GLOBAL__N_1L15tryBuildCaptureERN5clang4SemaEPNS0_4ExprERN4llvm9MapVectorIS4_PNS0_11DeclRefExprENS5_8DenseMapIS4_jNS5_12DenseMapInfoIS4_EENS5_6detail12DenseMapPairIS4_jEEEESt6vectorISt4pairIS4_S8_ESaISI_EEEE")
//</editor-fold>
public static ActionResultTTrue<Expr /*P*/ > tryBuildCapture(final Sema /*&*/ SemaRef, Expr /*P*/ Capture, 
               final MapVectorPtrPtr<Expr /*P*/ , DeclRefExpr /*P*/ > /*&*/ Captures) {
  if (SemaRef.CurContext.isDependentContext()) {
    return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, Capture);
  }
  if (Capture.isEvaluatable(SemaRef.Context, Expr.SideEffectsKind.SE_AllowSideEffects)) {
    return SemaRef.PerformImplicitConversion(Capture.IgnoreImpCasts(), Capture.getType(), Sema.AssignmentAction.AA_Converting, 
        /*AllowExplicit=*/ true);
  }
  StdVector.iterator<pairPtrPtr<Expr, DeclRefExpr>> I = Captures.find(Capture);
  if ($noteq___normal_iterator$C(I, Captures.end())) {
    return buildCapture(SemaRef, Capture, create_type$ptr(I.$arrow().second));
  }
  type$ptr<DeclRefExpr /*P*/ > Ref = create_type$null$ptr(null);
  ActionResultTTrue<Expr /*P*/ > Res = buildCapture(SemaRef, Capture, Ref);
  Captures./*$set(Capture, Ref.$star());*/ref$at(Capture).$set(Ref.$star());
  return Res;
}


/// \brief Called on a for stmt to check and extract its iteration space
/// for further processing (such as collapsing).
//<editor-fold defaultstate="collapsed" desc="CheckOpenMPIterationSpace">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 4609,
 FQN="CheckOpenMPIterationSpace", NM="_ZL25CheckOpenMPIterationSpaceN5clang19OpenMPDirectiveKindEPNS_4StmtERNS_4SemaERN12_GLOBAL__N_110DSAStackTyEjjPNS_4ExprES9_RN4llvm8DenseMapIPNS_9ValueDeclES9_NSA_12DenseMapInfoISD_EENSA_6detail12DenseMapPairISD_S9_EEEERNS5_18LoopIterationSpaceERNSA_9MapVectorIS9_PNS_11DeclRefExprENSB_IS9_jNSE_IS9_EENSH_IS9_jEEEESt6vectorISt4pairIS9_SP_ESaISV_EEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZL25CheckOpenMPIterationSpaceN5clang19OpenMPDirectiveKindEPNS_4StmtERNS_4SemaERN12_GLOBAL__N_110DSAStackTyEjjPNS_4ExprES9_RN4llvm8DenseMapIPNS_9ValueDeclES9_NSA_12DenseMapInfoISD_EENSA_6detail12DenseMapPairISD_S9_EEEERNS5_18LoopIterationSpaceERNSA_9MapVectorIS9_PNS_11DeclRefExprENSB_IS9_jNSE_IS9_EENSH_IS9_jEEEESt6vectorISt4pairIS9_SP_ESaISV_EEEE")
//</editor-fold>
public static boolean CheckOpenMPIterationSpace(OpenMPDirectiveKind DKind, Stmt /*P*/ S, final Sema /*&*/ SemaRef, final DSAStackTy /*&*/ DSA, 
                         /*uint*/int CurrentNestedLoopCount, /*uint*/int NestedLoopCount, 
                         Expr /*P*/ CollapseLoopCountExpr, Expr /*P*/ OrderedLoopCountExpr, 
                         final DenseMap<ValueDecl /*P*/ , Expr /*P*/ > /*&*/ VarsWithImplicitDSA, 
                         final LoopIterationSpace /*&*/ ResultIterSpace, 
                         final MapVectorPtrPtr<Expr /*P*/ , DeclRefExpr /*P*/ > /*&*/ Captures) {
  // OpenMP [2.6, Canonical Loop Form]
  //   for (init-expr; test-expr; incr-expr) structured-block
  ForStmt /*P*/ For = dyn_cast_or_null_ForStmt(S);
  if (!(For != null)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(S.getLocStart(), diag.err_omp_not_for)), 
                          (CollapseLoopCountExpr != (Expr /*P*/ )null || OrderedLoopCountExpr != (Expr /*P*/ )null)), 
                      getOpenMPDirectiveName(DKind)), NestedLoopCount), 
              ($greater_uint(CurrentNestedLoopCount, 0))), CurrentNestedLoopCount));
      if ($greater_uint(NestedLoopCount, 1)) {
        if ((CollapseLoopCountExpr != null) && (OrderedLoopCountExpr != null)) {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(DSA.getConstructLoc(), 
                          diag.note_omp_collapse_ordered_expr)), 
                      2), CollapseLoopCountExpr.getSourceRange()), 
              OrderedLoopCountExpr.getSourceRange()));
        } else if ((CollapseLoopCountExpr != null)) {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(CollapseLoopCountExpr.getExprLoc(), 
                      diag.note_omp_collapse_ordered_expr)), 
                  0), CollapseLoopCountExpr.getSourceRange()));
        } else {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(OrderedLoopCountExpr.getExprLoc(), 
                      diag.note_omp_collapse_ordered_expr)), 
                  1), OrderedLoopCountExpr.getSourceRange()));
        }
      }
      return true;
    } finally {
      $c$.$destroy();
    }
  }
  assert Native.$bool(For.getBody());
  
  OpenMPIterationSpaceChecker ISC/*J*/= new OpenMPIterationSpaceChecker(SemaRef, For.getForLoc());
  
  // Check init.
  Stmt /*P*/ Init = For.getInit();
  if (ISC.CheckInit(Init)) {
    return true;
  }
  
  boolean HasErrors = false;
  {
    
    // Check loop variable's type.
    ValueDecl /*P*/ LCDecl = ISC.GetLoopDecl();
    if ((LCDecl != null)) {
      Expr /*P*/ LoopDeclRefExpr = ISC.GetLoopDeclRefExpr();
      
      // OpenMP [2.6, Canonical Loop Form]
      // Var is one of the following:
      //   A variable of signed or unsigned integer type.
      //   For C++, a variable of a random access iterator type.
      //   For C, a variable of a pointer type.
      QualType VarType = LCDecl.getType().getNonReferenceType();
      if (!VarType.$arrow().isDependentType() && !VarType.$arrow().isIntegerType()
         && !VarType.$arrow().isPointerType()
         && !(SemaRef.getLangOpts().CPlusPlus && VarType.$arrow().isOverloadableType())) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(Init.getLocStart(), diag.err_omp_loop_variable_type)), 
              SemaRef.getLangOpts().CPlusPlus));
          HasErrors = true;
        } finally {
          $c$.$destroy();
        }
      }
      
      // OpenMP, 2.14.1.1 Data-sharing Attribute Rules for Variables Referenced in
      // a Construct
      // The loop iteration variable(s) in the associated for-loop(s) of a for or
      // parallel for construct is (are) private.
      // The loop iteration variable in the associated for-loop of a simd
      // construct with just one associated for-loop is linear with a
      // constant-linear-step that is the increment of the associated for-loop.
      // Exclude loop var from the list of variables with implicitly defined data
      // sharing attributes.
      VarsWithImplicitDSA.erase(LCDecl);
      
      // OpenMP [2.14.1.1, Data-sharing Attribute Rules for Variables Referenced
      // in a Construct, C/C++].
      // The loop iteration variable in the associated for-loop of a simd
      // construct with just one associated for-loop may be listed in a linear
      // clause with a constant-linear-step that is the increment of the
      // associated for-loop.
      // The loop iteration variable(s) in the associated for-loop(s) of a for or
      // parallel for construct may be listed in a private or lastprivate clause.
      DSAStackTy.DSAVarData DVar = DSA.getTopDSA(LCDecl, false);
      // If LoopVarRefExpr is nullptr it means the corresponding loop variable is
      // declared in the loop and it is predetermined as a private.
      OpenMPClauseKind PredeterminedCKind = isOpenMPSimdDirective(DKind) ? ((NestedLoopCount == 1) ? OpenMPClauseKind.OMPC_linear : OpenMPClauseKind.OMPC_lastprivate) : OpenMPClauseKind.OMPC_private;
      if (((isOpenMPSimdDirective(DKind) && DVar.CKind != OpenMPClauseKind.OMPC_unknown
         && DVar.CKind != PredeterminedCKind)
         || ((isOpenMPWorksharingDirective(DKind) || DKind == OpenMPDirectiveKind.OMPD_taskloop
         || isOpenMPDistributeDirective(DKind))
         && !isOpenMPSimdDirective(DKind) && DVar.CKind != OpenMPClauseKind.OMPC_unknown
         && DVar.CKind != OpenMPClauseKind.OMPC_private && DVar.CKind != OpenMPClauseKind.OMPC_lastprivate))
         && (DVar.CKind != OpenMPClauseKind.OMPC_private || DVar.RefExpr != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(Init.getLocStart(), diag.err_omp_loop_var_dsa)), 
                      getOpenMPClauseName(DVar.CKind)), getOpenMPDirectiveName(DKind)), 
              getOpenMPClauseName(PredeterminedCKind)));
          if (DVar.RefExpr == null) {
            DVar.CKind = PredeterminedCKind;
          }
          ReportOriginalDSA(SemaRef, $AddrOf(DSA), LCDecl, new DSAStackTy.DSAVarData(DVar), /*IsLoopIterVar=*/ true);
          HasErrors = true;
        } finally {
          $c$.$destroy();
        }
      } else if (LoopDeclRefExpr != null) {
        // Make the loop iteration variable private (for worksharing constructs),
        // linear (for simd directives with the only one associated loop) or
        // lastprivate (for simd directives with several collapsed or ordered
        // loops).
        if (DVar.CKind == OpenMPClauseKind.OMPC_unknown) {
          DVar.$assignMove(DSA.hasDSA(LCDecl, /*FuncArg*/BasicClangGlobals::isOpenMPPrivate, 
                  /*FuncArg*//*[]*/ (OpenMPDirectiveKind $Prm0) -> {
                        return true;
                      }, 
                  /*FromParent=*/ false));
        }
        DSA.addDSA(LCDecl, LoopDeclRefExpr, PredeterminedCKind);
      }
      assert (isOpenMPLoopDirective(DKind)) : "DSA for non-loop vars";
      
      // Check test-expr.
      HasErrors |= ISC.CheckCond(For.getCond());
      
      // Check incr-expr.
      HasErrors |= ISC.CheckInc(For.getInc());
    }
  }
  if (ISC.Dependent() || SemaRef.CurContext.isDependentContext() || HasErrors) {
    return HasErrors;
  }
  
  // Build the loop's iteration space representation.
  ResultIterSpace.PreCond
     = ISC.BuildPreCond(DSA.getCurScope(), For.getCond(), Captures);
  ResultIterSpace.NumIterations = ISC.BuildNumIterations(DSA.getCurScope(), 
      (isOpenMPWorksharingDirective(DKind)
         || isOpenMPTaskLoopDirective(DKind) || isOpenMPDistributeDirective(DKind)), 
      Captures);
  ResultIterSpace.CounterVar = ISC.BuildCounterVar(Captures, DSA);
  ResultIterSpace.PrivateCounterVar = ISC.BuildPrivateCounterVar();
  ResultIterSpace.CounterInit = ISC.BuildCounterInit();
  ResultIterSpace.CounterStep = ISC.BuildCounterStep();
  ResultIterSpace.InitSrcRange.$assignMove(ISC.GetInitSrcRange());
  ResultIterSpace.CondSrcRange.$assignMove(ISC.GetConditionSrcRange());
  ResultIterSpace.IncSrcRange.$assignMove(ISC.GetIncrementSrcRange());
  ResultIterSpace.Subtract = ISC.ShouldSubtractStep();
  
  HasErrors |= (ResultIterSpace.PreCond == null
     || ResultIterSpace.NumIterations == null
     || ResultIterSpace.CounterVar == null
     || ResultIterSpace.PrivateCounterVar == null
     || ResultIterSpace.CounterInit == null
     || ResultIterSpace.CounterStep == null);
  
  return HasErrors;
}


/// \brief Build 'VarRef = Start.
//<editor-fold defaultstate="collapsed" desc="BuildCounterInit">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 4762,
 FQN="BuildCounterInit", NM="_ZL16BuildCounterInitRN5clang4SemaEPNS_5ScopeENS_14SourceLocationENS_12ActionResultIPNS_4ExprELb1EEES8_RN4llvm9MapVectorIS7_PNS_11DeclRefExprENS9_8DenseMapIS7_jNS9_12DenseMapInfoIS7_EENS9_6detail12DenseMapPairIS7_jEEEESt6vectorISt4pairIS7_SC_ESaISM_EEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZL16BuildCounterInitRN5clang4SemaEPNS_5ScopeENS_14SourceLocationENS_12ActionResultIPNS_4ExprELb1EEES8_RN4llvm9MapVectorIS7_PNS_11DeclRefExprENS9_8DenseMapIS7_jNS9_12DenseMapInfoIS7_EENS9_6detail12DenseMapPairIS7_jEEEESt6vectorISt4pairIS7_SC_ESaISM_EEEE")
//</editor-fold>
public static ActionResultTTrue<Expr /*P*/ > BuildCounterInit(final Sema /*&*/ SemaRef, Scope /*P*/ S, SourceLocation Loc, ActionResultTTrue<Expr /*P*/ > VarRef, 
                ActionResultTTrue<Expr /*P*/ > Start, 
                final MapVectorPtrPtr<Expr /*P*/ , DeclRefExpr /*P*/ > /*&*/ Captures) {
  // Build 'VarRef = Start.
  ActionResultTTrue<Expr /*P*/ > NewStart = tryBuildCapture(SemaRef, Start.get(), Captures);
  if (!NewStart.isUsable()) {
    return ExprError();
  }
  if (!SemaRef.Context.hasSameType(NewStart.get().getType(), 
      VarRef.get().getType())) {
    NewStart.$assignMove(SemaRef.PerformImplicitConversion(NewStart.get(), VarRef.get().getType(), Sema.AssignmentAction.AA_Converting, 
            /*AllowExplicit=*/ true));
    if (!NewStart.isUsable()) {
      return ExprError();
    }
  }
  
  ActionResultTTrue<Expr /*P*/ > Init = SemaRef.BuildBinOp(S, new SourceLocation(Loc), BinaryOperatorKind.BO_Assign, VarRef.get(), NewStart.get());
  return Init;
}


/// \brief Build 'VarRef = Start + Iter * Step'.
//<editor-fold defaultstate="collapsed" desc="BuildCounterUpdate">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 4785,
 FQN="BuildCounterUpdate", NM="_ZL18BuildCounterUpdateRN5clang4SemaEPNS_5ScopeENS_14SourceLocationENS_12ActionResultIPNS_4ExprELb1EEES8_S8_S8_bPN4llvm9MapVectorIS7_PNS_11DeclRefExprENS9_8DenseMapIS7_jNS9_12DenseMapInfoIS7_EENS9_6detail12DenseMapPairIS7_jEEEESt6vectorISt4pairIS7_SC_ESaISM_EEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZL18BuildCounterUpdateRN5clang4SemaEPNS_5ScopeENS_14SourceLocationENS_12ActionResultIPNS_4ExprELb1EEES8_S8_S8_bPN4llvm9MapVectorIS7_PNS_11DeclRefExprENS9_8DenseMapIS7_jNS9_12DenseMapInfoIS7_EENS9_6detail12DenseMapPairIS7_jEEEESt6vectorISt4pairIS7_SC_ESaISM_EEEE")
//</editor-fold>
public static ActionResultTTrue<Expr /*P*/ > BuildCounterUpdate(final Sema /*&*/ SemaRef, Scope /*P*/ S, SourceLocation Loc, 
                  ActionResultTTrue<Expr /*P*/ > VarRef, ActionResultTTrue<Expr /*P*/ > Start, ActionResultTTrue<Expr /*P*/ > Iter, 
                  ActionResultTTrue<Expr /*P*/ > Step, boolean Subtract) {
  return BuildCounterUpdate(SemaRef, S, Loc, 
                  VarRef, Start, Iter, 
                  Step, Subtract, 
                  (MapVectorPtrPtr<Expr /*P*/ , DeclRefExpr /*P*/ > /*P*/ )null);
}
public static ActionResultTTrue<Expr /*P*/ > BuildCounterUpdate(final Sema /*&*/ SemaRef, Scope /*P*/ S, SourceLocation Loc, 
                  ActionResultTTrue<Expr /*P*/ > VarRef, ActionResultTTrue<Expr /*P*/ > Start, ActionResultTTrue<Expr /*P*/ > Iter, 
                  ActionResultTTrue<Expr /*P*/ > Step, boolean Subtract, 
                  MapVectorPtrPtr<Expr /*P*/ , DeclRefExpr /*P*/ > /*P*/ Captures/*= null*/) {
  // Add parentheses (for debugging purposes only).
  Iter.$assignMove(SemaRef.ActOnParenExpr(new SourceLocation(Loc), new SourceLocation(Loc), Iter.get()));
  if (!VarRef.isUsable() || !Start.isUsable() || !Iter.isUsable()
     || !Step.isUsable()) {
    return ExprError();
  }
  
  ActionResultTTrue<Expr /*P*/ > NewStep = new ActionResultTTrue<Expr /*P*/ >(Step);
  if ((Captures != null)) {
    NewStep.$assignMove(tryBuildCapture(SemaRef, Step.get(), $Deref(Captures)));
  }
  if (NewStep.isInvalid()) {
    return ExprError();
  }
  ActionResultTTrue<Expr /*P*/ > Update = SemaRef.BuildBinOp(S, new SourceLocation(Loc), BinaryOperatorKind.BO_Mul, Iter.get(), NewStep.get());
  if (!Update.isUsable()) {
    return ExprError();
  }
  
  // Try to build 'VarRef = Start, VarRef (+|-)= Iter * Step' or
  // 'VarRef = Start (+|-) Iter * Step'.
  ActionResultTTrue<Expr /*P*/ > NewStart = new ActionResultTTrue<Expr /*P*/ >(Start);
  if ((Captures != null)) {
    NewStart.$assignMove(tryBuildCapture(SemaRef, Start.get(), $Deref(Captures)));
  }
  if (NewStart.isInvalid()) {
    return ExprError();
  }
  
  // First attempt: try to build 'VarRef = Start, VarRef += Iter * Step'.
  ActionResultTTrue<Expr /*P*/ > SavedUpdate = new ActionResultTTrue<Expr /*P*/ >(Update);
  ActionResultTTrue<Expr /*P*/ > UpdateVal/*J*/= new ActionResultTTrue<Expr /*P*/ >();
  if (VarRef.get().getType().$arrow().isOverloadableType()
     || NewStart.get().getType().$arrow().isOverloadableType()
     || Update.get().getType().$arrow().isOverloadableType()) {
    boolean Suppress = SemaRef.getDiagnostics().getSuppressAllDiagnostics();
    SemaRef.getDiagnostics().setSuppressAllDiagnostics(/*Val=*/ true);
    Update.$assignMove(
        SemaRef.BuildBinOp(S, new SourceLocation(Loc), BinaryOperatorKind.BO_Assign, VarRef.get(), NewStart.get())
    );
    if (Update.isUsable()) {
      UpdateVal.$assignMove(
          SemaRef.BuildBinOp(S, new SourceLocation(Loc), Subtract ? BinaryOperatorKind.BO_SubAssign : BinaryOperatorKind.BO_AddAssign, 
              VarRef.get(), SavedUpdate.get())
      );
      if (UpdateVal.isUsable()) {
        Update.$assignMove(SemaRef.CreateBuiltinBinOp(new SourceLocation(Loc), BinaryOperatorKind.BO_Comma, Update.get(), 
                UpdateVal.get()));
      }
    }
    SemaRef.getDiagnostics().setSuppressAllDiagnostics(Suppress);
  }
  
  // Second attempt: try to build 'VarRef = Start (+|-) Iter * Step'.
  if (!Update.isUsable() || !UpdateVal.isUsable()) {
    Update.$assignMove(SemaRef.BuildBinOp(S, new SourceLocation(Loc), Subtract ? BinaryOperatorKind.BO_Sub : BinaryOperatorKind.BO_Add, 
            NewStart.get(), SavedUpdate.get()));
    if (!Update.isUsable()) {
      return ExprError();
    }
    if (!SemaRef.Context.hasSameType(Update.get().getType(), 
        VarRef.get().getType())) {
      Update.$assignMove(SemaRef.PerformImplicitConversion(Update.get(), VarRef.get().getType(), Sema.AssignmentAction.AA_Converting, true));
      if (!Update.isUsable()) {
        return ExprError();
      }
    }
    
    Update.$assignMove(SemaRef.BuildBinOp(S, new SourceLocation(Loc), BinaryOperatorKind.BO_Assign, VarRef.get(), Update.get()));
  }
  return Update;
}


/// \brief Convert integer expression \a E to make it have at least \a Bits
/// bits.
//<editor-fold defaultstate="collapsed" desc="WidenIterationCount">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 4858,
 FQN="WidenIterationCount", NM="_ZL19WidenIterationCountjPN5clang4ExprERNS_4SemaE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZL19WidenIterationCountjPN5clang4ExprERNS_4SemaE")
//</editor-fold>
public static ActionResultTTrue<Expr /*P*/ > WidenIterationCount(/*uint*/int Bits, Expr /*P*/ E, 
                   final Sema /*&*/ SemaRef) {
  if (E == null) {
    return ExprError();
  }
  final ASTContext /*&*/ C = SemaRef.Context;
  QualType OldType = E.getType();
  /*uint*/int HasBits = $ulong2uint(C.getTypeSize(new QualType(OldType)));
  if ($greatereq_uint(HasBits, Bits)) {
    return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
  }
  // OK to convert to signed, because new type has more bits than old.
  QualType NewType = C.getIntTypeForBitwidth(Bits, /* Signed */ /*true*/1);
  return SemaRef.PerformImplicitConversion(E, new QualType(NewType), Sema.AssignmentAction.AA_Converting, 
      true);
}


/// \brief Check if the given expression \a E is a constant integer that fits
/// into \a Bits bits.
//<editor-fold defaultstate="collapsed" desc="FitsInto">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 4875,
 FQN="FitsInto", NM="_ZL8FitsIntojbPN5clang4ExprERNS_4SemaE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZL8FitsIntojbPN5clang4ExprERNS_4SemaE")
//</editor-fold>
public static boolean FitsInto(/*uint*/int Bits, boolean Signed, Expr /*P*/ E, final Sema /*&*/ SemaRef) {
  if (E == null) {
    return false;
  }
  APSInt Result/*J*/= new APSInt();
  if (E.isIntegerConstantExpr(Result, SemaRef.Context)) {
    return Signed ? Result.isSignedIntN(Bits) : Result.isIntN(Bits);
  }
  return false;
}


/// Build preinits statement for the given declarations.
//<editor-fold defaultstate="collapsed" desc="buildPreInits">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 4885,
 FQN="buildPreInits", NM="_ZL13buildPreInitsRN5clang10ASTContextERN4llvm15SmallVectorImplIPNS_4DeclEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZL13buildPreInitsRN5clang10ASTContextERN4llvm15SmallVectorImplIPNS_4DeclEEE")
//</editor-fold>
public static Stmt /*P*/ buildPreInits(final ASTContext /*&*/ Context, 
             final SmallVectorImpl<Decl /*P*/ > /*&*/ PreInits) {
  if (!PreInits.empty()) {
    return /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint(Context, (type$ptr<?> New$Mem)->new DeclStmt(DeclGroupRef.Create(Context, PreInits.begin(), PreInits.size()), 
        new SourceLocation(), new SourceLocation()));
  }
  return null;
}


/// Build preinits statement for the given declarations.
//<editor-fold defaultstate="collapsed" desc="buildPreInits">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 4896,
 FQN="buildPreInits", NM="_ZL13buildPreInitsRN5clang10ASTContextERN4llvm9MapVectorIPNS_4ExprEPNS_11DeclRefExprENS2_8DenseMapIS5_jNS2_12DenseMapInfoIS5_EENS2_6detail12DenseMapPairIS5_jEEEESt6vectorISt4pairIS5_S7_ESaISH_EEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZL13buildPreInitsRN5clang10ASTContextERN4llvm9MapVectorIPNS_4ExprEPNS_11DeclRefExprENS2_8DenseMapIS5_jNS2_12DenseMapInfoIS5_EENS2_6detail12DenseMapPairIS5_jEEEESt6vectorISt4pairIS5_S7_ESaISH_EEEE")
//</editor-fold>
public static Stmt /*P*/ buildPreInits(final ASTContext /*&*/ Context, 
             final MapVectorPtrPtr<Expr /*P*/ , DeclRefExpr /*P*/ > /*&*/ Captures) {
  if (!Captures.empty()) {
    SmallVector<Decl /*P*/> PreInits/*J*/= new SmallVector<Decl /*P*/>(16, null);
    for (final pair<Expr /*P*/ , DeclRefExpr /*P*/ > /*&*/ Pair : Captures)  {
      PreInits.push_back(Pair.second.getDecl());
    }
    return buildPreInits(Context, PreInits);
  }
  return null;
}


/// Build postupdate expression for the given list of postupdates expressions.
//<editor-fold defaultstate="collapsed" desc="buildPostUpdate">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 4908,
 FQN="buildPostUpdate", NM="_ZL15buildPostUpdateRN5clang4SemaEN4llvm8ArrayRefIPNS_4ExprEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZL15buildPostUpdateRN5clang4SemaEN4llvm8ArrayRefIPNS_4ExprEEE")
//</editor-fold>
public static Expr /*P*/ buildPostUpdate(final Sema /*&*/ S, ArrayRef<Expr /*P*/ > PostUpdates) {
  Expr /*P*/ PostUpdate = null;
  if (!PostUpdates.empty()) {
    for (Expr /*P*/ E : PostUpdates) {
      Expr /*P*/ ConvE = S.BuildCStyleCastExpr(E.getExprLoc(), 
          S.Context.getTrivialTypeSourceInfo(S.Context.VoidTy.$QualType()), 
          E.getExprLoc(), E).
          get();
      PostUpdate = (PostUpdate != null) ? S.CreateBuiltinBinOp(ConvE.getExprLoc(), BinaryOperatorKind.BO_Comma, 
          PostUpdate, ConvE).
          get() : ConvE;
    }
  }
  return PostUpdate;
}


/// \brief Called on a for stmt to check itself and nested loops (if any).
/// \return Returns 0 if one of the collapsed stmts is not canonical for loop,
/// number of collapsed loops otherwise.
//<editor-fold defaultstate="collapsed" desc="CheckOpenMPLoop">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 4930,
 FQN="CheckOpenMPLoop", NM="_ZL15CheckOpenMPLoopN5clang19OpenMPDirectiveKindEPNS_4ExprES2_PNS_4StmtERNS_4SemaERN12_GLOBAL__N_110DSAStackTyERN4llvm8DenseMapIPNS_9ValueDeclES2_NSA_12DenseMapInfoISD_EENSA_6detail12DenseMapPairISD_S2_EEEERNS_16OMPLoopDirective11HelperExprsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZL15CheckOpenMPLoopN5clang19OpenMPDirectiveKindEPNS_4ExprES2_PNS_4StmtERNS_4SemaERN12_GLOBAL__N_110DSAStackTyERN4llvm8DenseMapIPNS_9ValueDeclES2_NSA_12DenseMapInfoISD_EENSA_6detail12DenseMapPairISD_S2_EEEERNS_16OMPLoopDirective11HelperExprsE")
//</editor-fold>
public static /*uint*/int CheckOpenMPLoop(OpenMPDirectiveKind DKind, Expr /*P*/ CollapseLoopCountExpr, 
               Expr /*P*/ OrderedLoopCountExpr, Stmt /*P*/ AStmt, final Sema /*&*/ SemaRef, 
               final DSAStackTy /*&*/ DSA, 
               final DenseMap<ValueDecl /*P*/ , Expr /*P*/ > /*&*/ VarsWithImplicitDSA, 
               final OMPLoopDirective.HelperExprs /*&*/ Built) {
  MapVectorPtrPtr<Expr /*P*/ , DeclRefExpr /*P*/ > Captures = null;
  try {
    /*uint*/int NestedLoopCount = 1;
    if ((CollapseLoopCountExpr != null)) {
      // Found 'collapse' clause - calculate collapse number.
      APSInt Result/*J*/= new APSInt();
      if (CollapseLoopCountExpr.EvaluateAsInt(Result, SemaRef.getASTContext())) {
        NestedLoopCount = $ulong2uint(Result.getLimitedValue());
      }
    }
    if ((OrderedLoopCountExpr != null)) {
      // Found 'ordered' clause - calculate collapse number.
      APSInt Result/*J*/= new APSInt();
      if (OrderedLoopCountExpr.EvaluateAsInt(Result, SemaRef.getASTContext())) {
        if ($less_ulong_uint(Result.getLimitedValue(), NestedLoopCount)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(OrderedLoopCountExpr.getExprLoc(), 
                    diag.err_omp_wrong_ordered_loop_count)), 
                OrderedLoopCountExpr.getSourceRange()));
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(CollapseLoopCountExpr.getExprLoc(), 
                    diag.note_collapse_loop_count)), 
                CollapseLoopCountExpr.getSourceRange()));
          } finally {
            $c$.$destroy();
          }
        }
        NestedLoopCount = $ulong2uint(Result.getLimitedValue());
      }
    }
    // This is helper routine for loop directives (e.g., 'for', 'simd',
    // 'for simd', etc.).
    Captures/*J*/= new MapVectorPtrPtr<Expr /*P*/ , DeclRefExpr /*P*/ >(DenseMapInfo$LikePtr.$Info(), (DeclRefExpr/*P*/)null);
    SmallVector<LoopIterationSpace> IterSpaces/*J*/= new SmallVector<LoopIterationSpace>(4, new LoopIterationSpace());
    IterSpaces.resize(NestedLoopCount);
    Stmt /*P*/ CurStmt = AStmt.IgnoreContainers(/* IgnoreCaptured */ true);
    for (/*uint*/int Cnt = 0; $less_uint(Cnt, NestedLoopCount); ++Cnt) {
      if (CheckOpenMPIterationSpace(DKind, CurStmt, SemaRef, DSA, Cnt, 
          NestedLoopCount, CollapseLoopCountExpr, 
          OrderedLoopCountExpr, VarsWithImplicitDSA, 
          IterSpaces.$at(Cnt), Captures)) {
        return 0;
      }
      // Move on to the next nested for loop, or to the loop body.
      // OpenMP [2.8.1, simd construct, Restrictions]
      // All loops associated with the construct must be perfectly nested; that
      // is, there must be no intervening code nor any OpenMP directive between
      // any two loops.
      CurStmt = cast_ForStmt(CurStmt).getBody().IgnoreContainers();
    }
    
    Built.clear(/* size */ NestedLoopCount);
    if (SemaRef.CurContext.isDependentContext()) {
      return NestedLoopCount;
    }
    
    // An example of what is generated for the following code:
    //
    //   #pragma omp simd collapse(2) ordered(2)
    //   for (i = 0; i < NI; ++i)
    //     for (k = 0; k < NK; ++k)
    //       for (j = J0; j < NJ; j+=2) {
    //         <loop body>
    //       }
    //
    // We generate the code below.
    // Note: the loop body may be outlined in CodeGen.
    // Note: some counters may be C++ classes, operator- is used to find number of
    // iterations and operator+= to calculate counter value.
    // Note: decltype(NumIterations) must be integer type (in 'omp for', only i32
    // or i64 is currently supported).
    //
    //   #define NumIterations (NI * ((NJ - J0 - 1 + 2) / 2))
    //   for (int[32|64]_t IV = 0; IV < NumIterations; ++IV ) {
    //     .local.i = IV / ((NJ - J0 - 1 + 2) / 2);
    //     .local.j = J0 + (IV % ((NJ - J0 - 1 + 2) / 2)) * 2;
    //     // similar updates for vars in clauses (e.g. 'linear')
    //     <loop body (using local i and j)>
    //   }
    //   i = NI; // assign final values of counters
    //   j = NJ;
    //
    
    // Last iteration number is (I1 * I2 * ... In) - 1, where I1, I2 ... In are
    // the iteration counts of the collapsed for loops.
    // Precondition tests if there is at least one iteration (all conditions are
    // true).
    ActionResultTTrue<Expr /*P*/ > PreCond = new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, IterSpaces.$at(0).PreCond);
    Expr /*P*/ N0 = IterSpaces.$at(0).NumIterations;
    ActionResultTTrue<Expr /*P*/ > LastIteration32 = WidenIterationCount(32/* Bits */, SemaRef.PerformImplicitConversion(N0.IgnoreImpCasts(), N0.getType(), 
            Sema.AssignmentAction.AA_Converting, /*AllowExplicit=*/ true).
            get(), 
        SemaRef);
    ActionResultTTrue<Expr /*P*/ > LastIteration64 = WidenIterationCount(64/* Bits */, SemaRef.PerformImplicitConversion(N0.IgnoreImpCasts(), N0.getType(), 
            Sema.AssignmentAction.AA_Converting, /*AllowExplicit=*/ true).
            get(), 
        SemaRef);
    if (!LastIteration32.isUsable() || !LastIteration64.isUsable()) {
      return NestedLoopCount;
    }
    
    final ASTContext /*&*/ C = SemaRef.Context;
    boolean AllCountsNeedLessThan32Bits = $less_ulong_ullong(C.getTypeSize(N0.getType()), 32);
    
    Scope /*P*/ CurScope = DSA.getCurScope();
    for (/*uint*/int Cnt = 1; $less_uint(Cnt, NestedLoopCount); ++Cnt) {
      if (PreCond.isUsable()) {
        PreCond.$assignMove(SemaRef.BuildBinOp(CurScope, new SourceLocation(), BinaryOperatorKind.BO_LAnd, 
                PreCond.get(), IterSpaces.$at(Cnt).PreCond));
      }
      Expr /*P*/ N = IterSpaces.$at(Cnt).NumIterations;
      AllCountsNeedLessThan32Bits &= $less_ulong_ullong(C.getTypeSize(N.getType()), 32);
      if (LastIteration32.isUsable()) {
        LastIteration32.$assignMove(SemaRef.BuildBinOp(CurScope, new SourceLocation(), BinaryOperatorKind.BO_Mul, LastIteration32.get(), 
                SemaRef.PerformImplicitConversion(N.IgnoreImpCasts(), N.getType(), 
                    Sema.AssignmentAction.AA_Converting, 
                    /*AllowExplicit=*/ true).
                    get()));
      }
      if (LastIteration64.isUsable()) {
        LastIteration64.$assignMove(SemaRef.BuildBinOp(CurScope, new SourceLocation(), BinaryOperatorKind.BO_Mul, LastIteration64.get(), 
                SemaRef.PerformImplicitConversion(N.IgnoreImpCasts(), N.getType(), 
                    Sema.AssignmentAction.AA_Converting, 
                    /*AllowExplicit=*/ true).
                    get()));
      }
    }
    
    // Choose either the 32-bit or 64-bit version.
    ActionResultTTrue<Expr /*P*/ > LastIteration = new ActionResultTTrue<Expr /*P*/ >(LastIteration64);
    if (LastIteration32.isUsable()
       && C.getTypeSize(LastIteration32.get().getType()) == 32
       && (AllCountsNeedLessThan32Bits || NestedLoopCount == 1
       || FitsInto(32/* Bits */, 
        LastIteration32.get().getType().$arrow().hasSignedIntegerRepresentation(), 
        LastIteration64.get(), SemaRef))) {
      LastIteration.$assign(LastIteration32);
    }
    QualType VType = LastIteration.get().getType();
    QualType RealVType = new QualType(VType);
    QualType StrideVType = new QualType(VType);
    if (isOpenMPTaskLoopDirective(DKind)) {
      VType.$assignMove(
          SemaRef.Context.getIntTypeForBitwidth(/*DestWidth=*/ 64, /*Signed=*/ 0)
      );
      StrideVType.$assignMove(
          SemaRef.Context.getIntTypeForBitwidth(/*DestWidth=*/ 64, /*Signed=*/ 1)
      );
    }
    if (!LastIteration.isUsable()) {
      return 0;
    }
    
    // Save the number of iterations.
    ActionResultTTrue<Expr /*P*/ > NumIterations = new ActionResultTTrue<Expr /*P*/ >(LastIteration);
    {
      LastIteration.$assignMove(SemaRef.BuildBinOp(CurScope, new SourceLocation(), BinaryOperatorKind.BO_Sub, LastIteration.get(), 
              SemaRef.ActOnIntegerConstant(new SourceLocation(), 1).get()));
      if (!LastIteration.isUsable()) {
        return 0;
      }
    }
    
    // Calculate the last iteration number beforehand instead of doing this on
    // each iteration. Do not do this if the number of iterations may be kfold-ed.
    APSInt Result/*J*/= new APSInt();
    boolean IsConstant = LastIteration.get().isIntegerConstantExpr(Result, SemaRef.Context);
    ActionResultTTrue<Expr /*P*/ > CalcLastIteration/*J*/= new ActionResultTTrue<Expr /*P*/ >();
    if (!IsConstant) {
      ActionResultTTrue<Expr /*P*/ > SaveRef = tryBuildCapture(SemaRef, LastIteration.get(), Captures);
      LastIteration.$assign(SaveRef);
      
      // Prepare SaveRef + 1.
      NumIterations.$assignMove(SemaRef.BuildBinOp(CurScope, new SourceLocation(), BinaryOperatorKind.BO_Add, SaveRef.get(), 
              SemaRef.ActOnIntegerConstant(new SourceLocation(), 1).get()));
      if (!NumIterations.isUsable()) {
        return 0;
      }
    }
    
    SourceLocation InitLoc = IterSpaces.$at(0).InitSrcRange.getBegin();
    
    // Build variables passed into runtime, nesessary for worksharing directives.
    ActionResultTTrue<Expr /*P*/ > LB/*J*/= new ActionResultTTrue<Expr /*P*/ >(), UB/*J*/= new ActionResultTTrue<Expr /*P*/ >(), IL/*J*/= new ActionResultTTrue<Expr /*P*/ >(), ST/*J*/= new ActionResultTTrue<Expr /*P*/ >(), EUB/*J*/= new ActionResultTTrue<Expr /*P*/ >(), PrevLB/*J*/= new ActionResultTTrue<Expr /*P*/ >(), PrevUB/*J*/= new ActionResultTTrue<Expr /*P*/ >();
    if (isOpenMPWorksharingDirective(DKind) || isOpenMPTaskLoopDirective(DKind)
       || isOpenMPDistributeDirective(DKind)) {
      // Lower bound variable, initialized with zero.
      VarDecl /*P*/ LBDecl = buildVarDecl(SemaRef, new SourceLocation(InitLoc), new QualType(VType), new StringRef(/*KEEP_STR*/".omp.lb"));
      LB.$assign(buildDeclRefExpr(SemaRef, LBDecl, new QualType(VType), new SourceLocation(InitLoc)));
      SemaRef.AddInitializerToDecl(LBDecl, SemaRef.ActOnIntegerConstant(new SourceLocation(InitLoc), 0).get(), 
          /*DirectInit*/ false, /*TypeMayContainAuto*/ false);
      
      // Upper bound variable, initialized with last iteration number.
      VarDecl /*P*/ UBDecl = buildVarDecl(SemaRef, new SourceLocation(InitLoc), new QualType(VType), new StringRef(/*KEEP_STR*/".omp.ub"));
      UB.$assign(buildDeclRefExpr(SemaRef, UBDecl, new QualType(VType), new SourceLocation(InitLoc)));
      SemaRef.AddInitializerToDecl(UBDecl, LastIteration.get(), 
          /*DirectInit*/ false, 
          /*TypeMayContainAuto*/ false);
      
      // A 32-bit variable-flag where runtime returns 1 for the last iteration.
      // This will be used to implement clause 'lastprivate'.
      QualType Int32Ty = SemaRef.Context.getIntTypeForBitwidth(32, /*true*/1);
      VarDecl /*P*/ ILDecl = buildVarDecl(SemaRef, new SourceLocation(InitLoc), new QualType(Int32Ty), new StringRef(/*KEEP_STR*/".omp.is_last"));
      IL.$assign(buildDeclRefExpr(SemaRef, ILDecl, new QualType(Int32Ty), new SourceLocation(InitLoc)));
      SemaRef.AddInitializerToDecl(ILDecl, SemaRef.ActOnIntegerConstant(new SourceLocation(InitLoc), 0).get(), 
          /*DirectInit*/ false, /*TypeMayContainAuto*/ false);
      
      // Stride variable returned by runtime (we initialize it to 1 by default).
      VarDecl /*P*/ STDecl = buildVarDecl(SemaRef, new SourceLocation(InitLoc), new QualType(StrideVType), new StringRef(/*KEEP_STR*/".omp.stride"));
      ST.$assign(buildDeclRefExpr(SemaRef, STDecl, new QualType(StrideVType), new SourceLocation(InitLoc)));
      SemaRef.AddInitializerToDecl(STDecl, SemaRef.ActOnIntegerConstant(new SourceLocation(InitLoc), 1).get(), 
          /*DirectInit*/ false, /*TypeMayContainAuto*/ false);
      
      // Build expression: UB = min(UB, LastIteration)
      // It is nesessary for CodeGen of directives with static scheduling.
      ActionResultTTrue<Expr /*P*/ > IsUBGreater = SemaRef.BuildBinOp(CurScope, new SourceLocation(InitLoc), BinaryOperatorKind.BO_GT, 
          UB.get(), LastIteration.get());
      ActionResultTTrue<Expr /*P*/ > CondOp = SemaRef.ActOnConditionalOp(new SourceLocation(InitLoc), new SourceLocation(InitLoc), IsUBGreater.get(), LastIteration.get(), UB.get());
      EUB.$assignMove(SemaRef.BuildBinOp(CurScope, new SourceLocation(InitLoc), BinaryOperatorKind.BO_Assign, UB.get(), 
              CondOp.get()));
      EUB.$assignMove(SemaRef.ActOnFinishFullExpr(EUB.get()));
      
      // If we have a combined directive that combines 'distribute', 'for' or
      // 'simd' we need to be able to access the bounds of the schedule of the
      // enclosing region. E.g. in 'distribute parallel for' the bounds obtained
      // by scheduling 'distribute' have to be passed to the schedule of 'for'.
      if (isOpenMPLoopBoundSharingDirective(DKind)) {
        CapturedDecl /*P*/ CD = cast_CapturedStmt(AStmt).getCapturedDecl();
        
        // We expect to have at least 2 more parameters than the 'parallel'
        // directive does - the lower and upper bounds of the previous schedule.
        assert ($greatereq_uint(CD.getNumParams(), 4)) : "Unexpected number of parameters in loop combined directive";
        
        // Set the proper type for the bounds given what we learned from the
        // enclosed loops.
        ImplicitParamDecl /*P*/ PrevLBDecl = CD.getParam(/*PrevLB=*/ 2);
        ImplicitParamDecl /*P*/ PrevUBDecl = CD.getParam(/*PrevUB=*/ 3);
        
        // Previous lower and upper bounds are obtained from the region
        // parameters.
        PrevLB.$assign(
            buildDeclRefExpr(SemaRef, PrevLBDecl, PrevLBDecl.getType(), new SourceLocation(InitLoc))
        );
        PrevUB.$assign(
            buildDeclRefExpr(SemaRef, PrevUBDecl, PrevUBDecl.getType(), new SourceLocation(InitLoc))
        );
      }
    }
    
    // Build the iteration variable and its initialization before loop.
    ActionResultTTrue<Expr /*P*/ > IV/*J*/= new ActionResultTTrue<Expr /*P*/ >();
    ActionResultTTrue<Expr /*P*/ > Init/*J*/= new ActionResultTTrue<Expr /*P*/ >();
    {
      VarDecl /*P*/ IVDecl = buildVarDecl(SemaRef, new SourceLocation(InitLoc), new QualType(RealVType), new StringRef(/*KEEP_STR*/".omp.iv"));
      IV.$assign(buildDeclRefExpr(SemaRef, IVDecl, new QualType(RealVType), new SourceLocation(InitLoc)));
      Expr /*P*/ RHS = (isOpenMPWorksharingDirective(DKind)
         || isOpenMPTaskLoopDirective(DKind)
         || isOpenMPDistributeDirective(DKind)) ? LB.get() : SemaRef.ActOnIntegerConstant(new SourceLocation(), 0).get();
      Init.$assignMove(SemaRef.BuildBinOp(CurScope, new SourceLocation(InitLoc), BinaryOperatorKind.BO_Assign, IV.get(), RHS));
      Init.$assignMove(SemaRef.ActOnFinishFullExpr(Init.get()));
    }
    
    // Loop condition (IV < NumIterations) or (IV <= UB) for worksharing loops.
    SourceLocation CondLoc/*J*/= new SourceLocation();
    ActionResultTTrue<Expr /*P*/ > Cond = (isOpenMPWorksharingDirective(DKind)
       || isOpenMPTaskLoopDirective(DKind) || isOpenMPDistributeDirective(DKind)) ? SemaRef.BuildBinOp(CurScope, new SourceLocation(CondLoc), BinaryOperatorKind.BO_LE, IV.get(), UB.get()) : SemaRef.BuildBinOp(CurScope, new SourceLocation(CondLoc), BinaryOperatorKind.BO_LT, IV.get(), 
        NumIterations.get());
    
    // Loop increment (IV = IV + 1)
    SourceLocation IncLoc/*J*/= new SourceLocation();
    ActionResultTTrue<Expr /*P*/ > Inc = SemaRef.BuildBinOp(CurScope, new SourceLocation(IncLoc), BinaryOperatorKind.BO_Add, IV.get(), 
        SemaRef.ActOnIntegerConstant(new SourceLocation(IncLoc), 1).get());
    if (!Inc.isUsable()) {
      return 0;
    }
    Inc.$assignMove(SemaRef.BuildBinOp(CurScope, new SourceLocation(IncLoc), BinaryOperatorKind.BO_Assign, IV.get(), Inc.get()));
    Inc.$assignMove(SemaRef.ActOnFinishFullExpr(Inc.get()));
    if (!Inc.isUsable()) {
      return 0;
    }
    
    // Increments for worksharing loops (LB = LB + ST; UB = UB + ST).
    // Used for directives with static scheduling.
    ActionResultTTrue<Expr /*P*/ > NextLB/*J*/= new ActionResultTTrue<Expr /*P*/ >(), NextUB/*J*/= new ActionResultTTrue<Expr /*P*/ >();
    if (isOpenMPWorksharingDirective(DKind) || isOpenMPTaskLoopDirective(DKind)
       || isOpenMPDistributeDirective(DKind)) {
      // LB + ST
      NextLB.$assignMove(SemaRef.BuildBinOp(CurScope, new SourceLocation(IncLoc), BinaryOperatorKind.BO_Add, LB.get(), ST.get()));
      if (!NextLB.isUsable()) {
        return 0;
      }
      // LB = LB + ST
      NextLB.$assignMove(
          SemaRef.BuildBinOp(CurScope, new SourceLocation(IncLoc), BinaryOperatorKind.BO_Assign, LB.get(), NextLB.get())
      );
      NextLB.$assignMove(SemaRef.ActOnFinishFullExpr(NextLB.get()));
      if (!NextLB.isUsable()) {
        return 0;
      }
      // UB + ST
      NextUB.$assignMove(SemaRef.BuildBinOp(CurScope, new SourceLocation(IncLoc), BinaryOperatorKind.BO_Add, UB.get(), ST.get()));
      if (!NextUB.isUsable()) {
        return 0;
      }
      // UB = UB + ST
      NextUB.$assignMove(
          SemaRef.BuildBinOp(CurScope, new SourceLocation(IncLoc), BinaryOperatorKind.BO_Assign, UB.get(), NextUB.get())
      );
      NextUB.$assignMove(SemaRef.ActOnFinishFullExpr(NextUB.get()));
      if (!NextUB.isUsable()) {
        return 0;
      }
    }
    
    // Build updates and final values of the loop counters.
    boolean HasErrors = false;
    Built.Counters.resize(NestedLoopCount);
    Built.Inits.resize(NestedLoopCount);
    Built.Updates.resize(NestedLoopCount);
    Built.Finals.resize(NestedLoopCount);
    SmallVector<Expr /*P*/ > LoopMultipliers/*J*/= new SmallVector<Expr /*P*/ >(4, (Expr /*P*/ )null);
    {
      ActionResultTTrue<Expr /*P*/ > Div/*J*/= new ActionResultTTrue<Expr /*P*/ >();
      // Go from inner nested loop to outer.
      for (int Cnt = NestedLoopCount - 1; Cnt >= 0; --Cnt) {
        final LoopIterationSpace /*&*/ IS = IterSpaces.$at(Cnt);
        SourceLocation UpdLoc = IS.IncSrcRange.getBegin();
        // Build: Iter = (IV / Div) % IS.NumIters
        // where Div is product of previous iterations' IS.NumIters.
        ActionResultTTrue<Expr /*P*/ > Iter/*J*/= new ActionResultTTrue<Expr /*P*/ >();
        if (Div.isUsable()) {
          Iter.$assignMove(
              SemaRef.BuildBinOp(CurScope, new SourceLocation(UpdLoc), BinaryOperatorKind.BO_Div, IV.get(), Div.get())
          );
        } else {
          Iter.$assign(IV);
          assert ((Cnt == (int)NestedLoopCount - 1)) : "unusable div expected on first iteration only";
        }
        if (Cnt != 0 && Iter.isUsable()) {
          Iter.$assignMove(SemaRef.BuildBinOp(CurScope, new SourceLocation(UpdLoc), BinaryOperatorKind.BO_Rem, Iter.get(), 
                  IS.NumIterations));
        }
        if (!Iter.isUsable()) {
          HasErrors = true;
          break;
        }
        
        // Build update: IS.CounterVar(Private) = IS.Start + Iter * IS.Step
        VarDecl /*P*/ VD = cast_VarDecl(cast_DeclRefExpr(IS.CounterVar).getDecl());
        DeclRefExpr /*P*/ CounterVar = buildDeclRefExpr(SemaRef, VD, IS.CounterVar.getType(), 
            IS.CounterVar.getExprLoc(), 
            /*RefersToCapture=*/ true);
        ActionResultTTrue<Expr /*P*/ > Init$1 = BuildCounterInit(SemaRef, CurScope, new SourceLocation(UpdLoc), new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, CounterVar), 
            new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, IS.CounterInit), Captures);
        if (!Init$1.isUsable()) {
          HasErrors = true;
          break;
        }
        ActionResultTTrue<Expr /*P*/ > Update = BuildCounterUpdate(SemaRef, CurScope, new SourceLocation(UpdLoc), new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, CounterVar), new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, IS.CounterInit), new ActionResultTTrue<Expr /*P*/ >(Iter), 
            new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, IS.CounterStep), IS.Subtract, $AddrOf(Captures));
        if (!Update.isUsable()) {
          HasErrors = true;
          break;
        }
        
        // Build final: IS.CounterVar = IS.Start + IS.NumIters * IS.Step
        ActionResultTTrue<Expr /*P*/ > Final = BuildCounterUpdate(SemaRef, CurScope, new SourceLocation(UpdLoc), new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, CounterVar), new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, IS.CounterInit), 
            new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, IS.NumIterations), new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, IS.CounterStep), IS.Subtract, $AddrOf(Captures));
        if (!Final.isUsable()) {
          HasErrors = true;
          break;
        }
        
        // Build Div for the next iteration: Div <- Div * IS.NumIters
        if (Cnt != 0) {
          if (Div.isUnset()) {
            Div.$assign(IS.NumIterations);
          } else {
            Div.$assignMove(SemaRef.BuildBinOp(CurScope, new SourceLocation(UpdLoc), BinaryOperatorKind.BO_Mul, Div.get(), 
                    IS.NumIterations));
          }
          
          // Add parentheses (for debugging purposes only).
          if (Div.isUsable()) {
            Div.$assignMove(tryBuildCapture(SemaRef, Div.get(), Captures));
          }
          if (!Div.isUsable()) {
            HasErrors = true;
            break;
          }
          LoopMultipliers.push_back(Div.get());
        }
        if (!Update.isUsable() || !Final.isUsable()) {
          HasErrors = true;
          break;
        }
        // Save results
        Built.Counters.$set(Cnt, IS.CounterVar);
        Built.PrivateCounters.$set(Cnt, IS.PrivateCounterVar);
        Built.Inits.$set(Cnt, Init$1.get());
        Built.Updates.$set(Cnt, Update.get());
        Built.Finals.$set(Cnt, Final.get());
      }
    }
    if (HasErrors) {
      return 0;
    }
    
    // Save results
    Built.IterationVarRef = IV.get();
    Built.LastIteration = LastIteration.get();
    Built.NumIterations = NumIterations.get();
    Built.CalcLastIteration
       = SemaRef.ActOnFinishFullExpr(CalcLastIteration.get()).get();
    Built.PreCond = PreCond.get();
    Built.PreInits = buildPreInits(C, Captures);
    Built.Cond = Cond.get();
    Built.Init = Init.get();
    Built.Inc = Inc.get();
    Built.LB = LB.get();
    Built.UB = UB.get();
    Built.IL = IL.get();
    Built.ST = ST.get();
    Built.EUB = EUB.get();
    Built.NLB = NextLB.get();
    Built.NUB = NextUB.get();
    Built.PrevLB = PrevLB.get();
    Built.PrevUB = PrevUB.get();
    
    Expr /*P*/ CounterVal = SemaRef.DefaultLvalueConversion(IV.get()).get();
    // Fill data for doacross depend clauses.
    for (std.pair<OMPDependClause /*P*/ , SmallVector<pair<Expr /*P*/ , OverloadedOperatorKind>>> Pair : DSA.getDoacrossDependClauses()) {
      if (Pair.first.getDependencyKind() == OpenMPDependClauseKind.OMPC_DEPEND_source) {
        Pair.first.setCounterValue(CounterVal);
      } else {
        if (NestedLoopCount != Pair.second.size()
           || NestedLoopCount != LoopMultipliers.size() + 1) {
          // Erroneous case - clause has some problems.
          Pair.first.setCounterValue(CounterVal);
          continue;
        }
        assert (Pair.first.getDependencyKind() == OpenMPDependClauseKind.OMPC_DEPEND_sink);
        reverse_iterator<pair<Expr /*P*/ , OverloadedOperatorKind> /*P*/ > I = Pair.second.rbegin();
        reverse_iterator<LoopIterationSpace /*P*/ > IS = IterSpaces.rbegin();
        reverse_iterator<Expr/*P*/> ILM = LoopMultipliers.rbegin();
        Expr /*P*/ UpCounterVal = CounterVal;
        Expr /*P*/ Multiplier = null;
        for (int Cnt = NestedLoopCount - 1; Cnt >= 0; --Cnt) {
          if ((I.$arrow().first != null)) {
            assert Native.$bool(IS.$arrow().CounterStep);
            Expr /*P*/ NormalizedOffset = SemaRef.
                BuildBinOp(CurScope, I.$arrow().first.getExprLoc(), BinaryOperatorKind.BO_Div, 
                I.$arrow().first, IS.$arrow().CounterStep).
                get();
            if ((Multiplier != null)) {
              NormalizedOffset
                 = SemaRef.
                  BuildBinOp(CurScope, I.$arrow().first.getExprLoc(), BinaryOperatorKind.BO_Mul, 
                  NormalizedOffset, Multiplier).
                  get();
            }
            assert (I.$arrow().second == OverloadedOperatorKind.OO_Plus || I.$arrow().second == OverloadedOperatorKind.OO_Minus);
            BinaryOperatorKind BOK = (I.$arrow().second == OverloadedOperatorKind.OO_Plus) ? BinaryOperatorKind.BO_Add : BinaryOperatorKind.BO_Sub;
            UpCounterVal
               = SemaRef.BuildBinOp(CurScope, I.$arrow().first.getExprLoc(), BOK, 
                UpCounterVal, NormalizedOffset).get();
          }
          Multiplier = ILM.$star();
          I.$preInc();
          IS.$preInc();
          ILM.$preInc();
        }
        Pair.first.setCounterValue(UpCounterVal);
      }
    }
    
    return NestedLoopCount;
  } finally {
    if (Captures != null) { Captures.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="getCollapseNumberExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 5413,
 FQN="getCollapseNumberExpr", NM="_ZL21getCollapseNumberExprN4llvm8ArrayRefIPN5clang9OMPClauseEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZL21getCollapseNumberExprN4llvm8ArrayRefIPN5clang9OMPClauseEEE")
//</editor-fold>
public static Expr /*P*/ getCollapseNumberExpr(ArrayRef<OMPClause /*P*/ > Clauses) {
  iterator_range</*const*/ OMPCollapseClause /*P*/ > CollapseClauses = OMPExecutableDirective.<OMPCollapseClause>getClausesOfKind(OMPCollapseClause.class, new ArrayRef<OMPClause /*P*/ >(Clauses));
  if (((specific_clause_iterator<OMPCollapseClause>)CollapseClauses.begin()).$noteq(((specific_clause_iterator<OMPCollapseClause>)CollapseClauses.end()))) {
    return (((specific_clause_iterator<OMPCollapseClause>)CollapseClauses.begin()).$star()).getNumForLoops();
  }
  return null;
}

//<editor-fold defaultstate="collapsed" desc="getOrderedNumberExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 5421,
 FQN="getOrderedNumberExpr", NM="_ZL20getOrderedNumberExprN4llvm8ArrayRefIPN5clang9OMPClauseEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZL20getOrderedNumberExprN4llvm8ArrayRefIPN5clang9OMPClauseEEE")
//</editor-fold>
public static Expr /*P*/ getOrderedNumberExpr(ArrayRef<OMPClause /*P*/ > Clauses) {
  iterator_range</*const*/ OMPOrderedClause /*P*/ > OrderedClauses = OMPExecutableDirective.<OMPOrderedClause>getClausesOfKind(OMPOrderedClause.class, new ArrayRef<OMPClause /*P*/ >(Clauses));
  if (((specific_clause_iterator<OMPOrderedClause>)OrderedClauses.begin()).$noteq(((specific_clause_iterator<OMPOrderedClause>)OrderedClauses.end()))) {
    return (((specific_clause_iterator<OMPOrderedClause>)OrderedClauses.begin()).$star()).getNumForLoops();
  }
  return null;
}

//<editor-fold defaultstate="collapsed" desc="checkSimdlenSafelenSpecified">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 5429,
 FQN="checkSimdlenSafelenSpecified", NM="_ZL28checkSimdlenSafelenSpecifiedRN5clang4SemaEN4llvm8ArrayRefIPNS_9OMPClauseEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZL28checkSimdlenSafelenSpecifiedRN5clang4SemaEN4llvm8ArrayRefIPNS_9OMPClauseEEE")
//</editor-fold>
public static boolean checkSimdlenSafelenSpecified(final Sema /*&*/ S, 
                            /*const*/ArrayRef<OMPClause /*P*/ > Clauses) {
  OMPSafelenClause /*P*/ Safelen = null;
  OMPSimdlenClause /*P*/ Simdlen = null;
  
  for (OMPClause /*P*/ Clause : Clauses) {
    if (Clause.getClauseKind() == OpenMPClauseKind.OMPC_safelen) {
      Safelen = cast_OMPSafelenClause(Clause);
    } else if (Clause.getClauseKind() == OpenMPClauseKind.OMPC_simdlen) {
      Simdlen = cast_OMPSimdlenClause(Clause);
    }
    if ((Safelen != null) && (Simdlen != null)) {
      break;
    }
  }
  if ((Simdlen != null) && (Safelen != null)) {
    APSInt SimdlenRes/*J*/= new APSInt(), SafelenRes/*J*/= new APSInt();
    Expr /*P*/ SimdlenLength = Simdlen.getSimdlen();
    Expr /*P*/ SafelenLength = Safelen.getSafelen();
    if (SimdlenLength.isValueDependent() || SimdlenLength.isTypeDependent()
       || SimdlenLength.isInstantiationDependent()
       || SimdlenLength.containsUnexpandedParameterPack()) {
      return false;
    }
    if (SafelenLength.isValueDependent() || SafelenLength.isTypeDependent()
       || SafelenLength.isInstantiationDependent()
       || SafelenLength.containsUnexpandedParameterPack()) {
      return false;
    }
    SimdlenLength.EvaluateAsInt(SimdlenRes, S.Context);
    SafelenLength.EvaluateAsInt(SafelenRes, S.Context);
    // OpenMP 4.5 [2.8.1, simd Construct, Restrictions]
    // If both simdlen and safelen clauses are specified, the value of the
    // simdlen parameter must be less than or equal to the value of the safelen
    // parameter.
    if (SimdlenRes.$greater(SafelenRes)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(SimdlenLength.getExprLoc(), 
                    diag.err_omp_wrong_simdlen_safelen_values)), 
                SimdlenLength.getSourceRange()), SafelenLength.getSourceRange()));
        return true;
      } finally {
        $c$.$destroy();
      }
    }
  }
  return false;
}


/// \brief Check for existence of a map clause in the list of clauses.
//<editor-fold defaultstate="collapsed" desc="HasMapClause">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 6790,
 FQN="HasMapClause", NM="_ZL12HasMapClauseN4llvm8ArrayRefIPN5clang9OMPClauseEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZL12HasMapClauseN4llvm8ArrayRefIPN5clang9OMPClauseEEE")
//</editor-fold>
public static boolean HasMapClause(ArrayRef<OMPClause /*P*/ > Clauses) {
  for (type$ptr<OMPClause /*P*/ /*P*/> I = $tryClone(Clauses.begin()), /*P*/ E = $tryClone(Clauses.end());
       $noteq_ptr(I, E); I.$preInc()) {
    if (I.$star() != null && (I.$star()).getClauseKind() == OpenMPClauseKind.OMPC_map) {
      return true;
    }
  }
  
  return false;
}

//<editor-fold defaultstate="collapsed" desc="checkGrainsizeNumTasksClauses">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 6934,
 FQN="checkGrainsizeNumTasksClauses", NM="_ZL29checkGrainsizeNumTasksClausesRN5clang4SemaEN4llvm8ArrayRefIPNS_9OMPClauseEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZL29checkGrainsizeNumTasksClausesRN5clang4SemaEN4llvm8ArrayRefIPNS_9OMPClauseEEE")
//</editor-fold>
public static boolean checkGrainsizeNumTasksClauses(final Sema /*&*/ S, 
                             ArrayRef<OMPClause /*P*/ > Clauses) {
  OMPClause /*P*/ PrevClause = null;
  boolean ErrorFound = false;
  for (OMPClause /*P*/ C : Clauses) {
    if (C.getClauseKind() == OpenMPClauseKind.OMPC_grainsize
       || C.getClauseKind() == OpenMPClauseKind.OMPC_num_tasks) {
      if (!(PrevClause != null)) {
        PrevClause = C;
      } else if (PrevClause.getClauseKind() != C.getClauseKind()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(C.getLocStart(), 
                      diag.err_omp_grainsize_num_tasks_mutually_exclusive)), 
                  getOpenMPClauseName(C.getClauseKind())), 
              getOpenMPClauseName(PrevClause.getClauseKind())));
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(PrevClause.getLocStart(), 
                  diag.note_omp_previous_grainsize_num_tasks)), 
              getOpenMPClauseName(PrevClause.getClauseKind())));
          ErrorFound = true;
        } finally {
          $c$.$destroy();
        }
      }
    }
  }
  return ErrorFound;
}

//<editor-fold defaultstate="collapsed" desc="IsNonNegativeIntegerValue">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 7378,
 FQN="IsNonNegativeIntegerValue", NM="_ZL25IsNonNegativeIntegerValueRPN5clang4ExprERNS_4SemaENS_16OpenMPClauseKindEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZL25IsNonNegativeIntegerValueRPN5clang4ExprERNS_4SemaENS_16OpenMPClauseKindEb")
//</editor-fold>
public static boolean IsNonNegativeIntegerValue(final type$ref<Expr /*P*/ /*&*/> ValExpr, final Sema /*&*/ SemaRef, 
                         OpenMPClauseKind CKind, 
                         boolean StrictlyPositive) {
  if (!ValExpr.$deref().isTypeDependent() && !ValExpr.$deref().isValueDependent()
     && !ValExpr.$deref().isInstantiationDependent()) {
    SourceLocation Loc = ValExpr.$deref().getExprLoc();
    ActionResultTTrue<Expr /*P*/ > Value = SemaRef.PerformOpenMPImplicitIntegerConversion(new SourceLocation(Loc), ValExpr.$deref());
    if (Value.isInvalid()) {
      return false;
    }
    
    ValExpr.$set(Value.get());
    // The expression must evaluate to a non-negative integer value.
    APSInt Result/*J*/= new APSInt();
    if (ValExpr.$deref().isIntegerConstantExpr(Result, SemaRef.Context)
       && Result.isSigned()
       && !((!StrictlyPositive && Result.isNonNegative())
       || (StrictlyPositive && Result.isStrictlyPositive()))) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(new SourceLocation(Loc), diag.err_omp_negative_expression_in_clause)), 
                    getOpenMPClauseName(CKind)), (StrictlyPositive ? 1 : 0)), 
            ValExpr.$deref().getSourceRange()));
        return false;
      } finally {
        $c$.$destroy();
      }
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="getListOfPossibleValues">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 7584,
 FQN="getListOfPossibleValues", NM="_ZL23getListOfPossibleValuesN5clang16OpenMPClauseKindEjjN4llvm8ArrayRefIjEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZL23getListOfPossibleValuesN5clang16OpenMPClauseKindEjjN4llvm8ArrayRefIjEE")
//</editor-fold>
public static std.string getListOfPossibleValues(OpenMPClauseKind K, /*uint*/int First, /*uint*/int Last) {
  return getListOfPossibleValues(K, First, Last, 
                       new ArrayRefUInt(llvm.None));
}
public static std.string getListOfPossibleValues(OpenMPClauseKind K, /*uint*/int First, /*uint*/int Last, 
                       ArrayRefUInt Exclude/*= llvm::None*/) {
  std.string Values/*J*/= new std.string();
  /*uint*/int Bound = $greatereq_uint(Last, 2) ? Last - 2 : 0;
  /*uint*/int Skipped = Exclude.size();
  /*const*/uint$ptr/*uint P*/ S = $tryClone(Exclude.begin()), /*P*/ E = $tryClone(Exclude.end());
  for (/*uint*/int i = First; $less_uint(i, Last); ++i) {
    if ($noteq_ptr(std.find(S, E, i), E)) {
      --Skipped;
      continue;
    }
    Values.$addassign_T$C$P(/*KEEP_STR*/"'");
    Values.$addassign_T$C$P(getOpenMPSimpleClauseTypeName(K, i));
    Values.$addassign_T$C$P(/*KEEP_STR*/"'");
    if (i == Bound - Skipped) {
      Values.$addassign_T$C$P(/*KEEP_STR*/" or ");
    } else if (i != Bound + 1 - Skipped) {
      Values.$addassign_T$C$P(/*KEEP_STR*/", ");
    }
  }
  return Values;
}

//<editor-fold defaultstate="collapsed" desc="checkScheduleModifiers">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 7739,
 FQN="checkScheduleModifiers", NM="_ZL22checkScheduleModifiersRN5clang4SemaENS_28OpenMPScheduleClauseModifierES2_NS_14SourceLocationES3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZL22checkScheduleModifiersRN5clang4SemaENS_28OpenMPScheduleClauseModifierES2_NS_14SourceLocationES3_")
//</editor-fold>
public static boolean checkScheduleModifiers(final Sema /*&*/ S, /*OpenMPScheduleClauseModifier*/int M1, 
                      /*OpenMPScheduleClauseModifier*/int M2, 
                      SourceLocation M1Loc, SourceLocation M2Loc) {
  if (M1 == OpenMPScheduleClauseModifier.OMPC_SCHEDULE_MODIFIER_unknown && M1Loc.isValid()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      SmallVectorUInt Excluded/*J*/= new SmallVectorUInt(2, 0);
      if (M2 != OpenMPScheduleClauseModifier.OMPC_SCHEDULE_MODIFIER_unknown) {
        Excluded.push_back(M2);
      }
      if (M2 == OpenMPScheduleClauseModifier.OMPC_SCHEDULE_MODIFIER_nonmonotonic) {
        Excluded.push_back(OpenMPScheduleClauseModifier.OMPC_SCHEDULE_MODIFIER_monotonic);
      }
      if (M2 == OpenMPScheduleClauseModifier.OMPC_SCHEDULE_MODIFIER_monotonic) {
        Excluded.push_back(OpenMPScheduleClauseModifier.OMPC_SCHEDULE_MODIFIER_nonmonotonic);
      }
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(M1Loc), diag.err_omp_unexpected_clause_value)), 
              getListOfPossibleValues(OpenMPClauseKind.OMPC_schedule, 
                  /*First=*/ OpenMPScheduleClauseModifier.OMPC_SCHEDULE_MODIFIER_unknown + 1, 
                  /*Last=*/ OpenMPScheduleClauseModifier.OMPC_SCHEDULE_MODIFIER_last, 
                  new ArrayRefUInt(Excluded))), 
          getOpenMPClauseName(OpenMPClauseKind.OMPC_schedule)));
      return true;
    } finally {
      $c$.$destroy();
    }
  }
  return false;
}

//<editor-fold defaultstate="collapsed" desc="getPrivateItem">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*make_pair*/,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 8105,
 FQN="getPrivateItem", NM="_ZL14getPrivateItemRN5clang4SemaERPNS_4ExprERNS_14SourceLocationERNS_11SourceRangeEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZL14getPrivateItemRN5clang4SemaERPNS_4ExprERNS_14SourceLocationERNS_11SourceRangeEb")
//</editor-fold>
public static std.pairTypeBool<ValueDecl /*P*/ > getPrivateItem(final Sema /*&*/ S, final type$ref<Expr /*P*/ /*&*/> RefExpr, final SourceLocation /*&*/ ELoc, 
              final SourceRange /*&*/ ERange) {
  return getPrivateItem(S, RefExpr, ELoc, 
              ERange, false);
}
public static std.pairTypeBool<ValueDecl /*P*/ > getPrivateItem(final Sema /*&*/ S, final type$ref<Expr /*P*/ /*&*/> RefExpr, final SourceLocation /*&*/ ELoc, 
              final SourceRange /*&*/ ERange, boolean AllowArraySection/*= false*/) {
  if (RefExpr.$deref().isTypeDependent() || RefExpr.$deref().isValueDependent()
     || RefExpr.$deref().containsUnexpandedParameterPack()) {
    return std.make_pair_nullptr_t_bool((ValueDecl /*P*/)null, true);
  }
  
  // OpenMP [3.1, C/C++]
  //  A list item is a variable name.
  // OpenMP  [2.9.3.3, Restrictions, p.1]
  //  A variable that is part of another variable (as an array or
  //  structure element) cannot appear in a private clause.
  RefExpr.$set(RefExpr.$deref().IgnoreParens());
  /*enum ANONYMOUS_INT_CONSTANTS {*/
    final int NoArrayExpr = -1;
    final int ArraySubscript = 0;
    final int OMPArraySection = 1;
  /*}*//*Unnamed enum*/int IsArrayExpr = NoArrayExpr;
  if (AllowArraySection) {
    {
      ArraySubscriptExpr /*P*/ ASE = dyn_cast_or_null_ArraySubscriptExpr(RefExpr.$deref());
      if ((ASE != null)) {
        Expr /*P*/ Base = ASE.getBase().IgnoreParenImpCasts();
        {
          ArraySubscriptExpr /*P*/ TempASE;
          while (((/*P*/ TempASE = dyn_cast_ArraySubscriptExpr(Base)) != null)) {
            Base = TempASE.getBase().IgnoreParenImpCasts();
          }
        }
        RefExpr.$set(Base);
        IsArrayExpr = ArraySubscript;
      } else {
        OMPArraySectionExpr /*P*/ OASE = dyn_cast_or_null_OMPArraySectionExpr(RefExpr.$deref());
        if ((OASE != null)) {
          Expr /*P*/ Base = OASE.getBase().IgnoreParenImpCasts();
          {
            OMPArraySectionExpr /*P*/ TempOASE;
            while (((/*P*/ TempOASE = dyn_cast_OMPArraySectionExpr(Base)) != null)) {
              Base = TempOASE.getBase().IgnoreParenImpCasts();
            }
          }
          {
            ArraySubscriptExpr /*P*/ TempASE;
            while (((/*P*/ TempASE = dyn_cast_ArraySubscriptExpr(Base)) != null)) {
              Base = TempASE.getBase().IgnoreParenImpCasts();
            }
          }
          RefExpr.$set(Base);
          IsArrayExpr = OMPArraySection;
        }
      }
    }
  }
  ELoc.$assignMove(RefExpr.$deref().getExprLoc());
  ERange.$assignMove(RefExpr.$deref().getSourceRange());
  RefExpr.$set(RefExpr.$deref().IgnoreParenImpCasts());
  DeclRefExpr /*P*/ DE = dyn_cast_or_null_DeclRefExpr(RefExpr.$deref());
  MemberExpr /*P*/ ME = dyn_cast_or_null_MemberExpr(RefExpr.$deref());
  if ((!(DE != null) || !isa_VarDecl(DE.getDecl()))
     && (S.getCurrentThisType().isNull() || !(ME != null)
     || !isa_CXXThisExpr(ME.getBase().IgnoreParenImpCasts())
     || !isa_FieldDecl(ME.getMemberDecl()))) {
    if (IsArrayExpr != NoArrayExpr) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(ELoc), diag.err_omp_expected_base_var_name)), IsArrayExpr), 
            ERange));
      } finally {
        $c$.$destroy();
      }
    } else {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(ELoc), 
                    AllowArraySection ? diag.err_omp_expected_var_name_member_expr_or_array_item : diag.err_omp_expected_var_name_member_expr)), 
                (S.getCurrentThisType().isNull() ? 0 : 1)), ERange));
      } finally {
        $c$.$destroy();
      }
    }
    return std.make_pair_nullptr_t_bool((ValueDecl /*P*/)null, false);
  }
  return std.make_pair_Ptr_bool((DE != null) ? DE.getDecl() : ME.getMemberDecl(), false);
}

// namespace
/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="filterLookupForUDR">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 8850,
 FQN="filterLookupForUDR", NM="Tpl__ZL18filterLookupForUDRRN4llvm15SmallVectorImplIN5clang13UnresolvedSetILj8EEEEERKNS_12function_refIFT_PNS1_9ValueDeclEEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=Tpl__ZL18filterLookupForUDRRN4llvm15SmallVectorImplIN5clang13UnresolvedSetILj8EEEEERKNS_12function_refIFT_PNS1_9ValueDeclEEEE")
//</editor-fold>
public static <T extends ValueDecl> type$ptr<T> filterLookupForUDR(SmallVectorImpl<UnresolvedSet> /*&*/ Lookups, 
                  /*const*/ ValueDecl2T<T> /*&*/ Gen) {
  for (final UnresolvedSet /*&*/ Set : Lookups) {
    for (NamedDecl /*P*/ D : Set) {
      {
        /*<dependent type>*/T Res = Gen.$call(cast_ValueDecl(D));
        if (Res != null) {
          return create_type$ptr(Res);
        }
      }
    }
  }
  return create_type$ptr((T)null);
}

//<editor-fold defaultstate="collapsed" desc="filterLookupForUDR">
@Converted(kind = Converted.Kind.MANUAL_DUPLICATED/*specialization for bool*/,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 8850,
 FQN="filterLookupForUDR", NM="_ZL18filterLookupForUDRIbET_RN4llvm15SmallVectorImplIN5clang13UnresolvedSetILj8EEEEERKNS1_12function_refIFS0_PNS3_9ValueDeclEEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZL18filterLookupForUDRIbET_RN4llvm15SmallVectorImplIN5clang13UnresolvedSetILj8EEEEERKNS1_12function_refIFS0_PNS3_9ValueDeclEEEE")
//</editor-fold>
public static boolean filterLookupForUDR$Bool(final SmallVectorImpl<UnresolvedSet> /*&*/ Lookups, 
                       final /*const*/BoolPredicate<ValueDecl/*P*/>/*&*/ Gen) {
  for (final UnresolvedSet /*&*/ Set : Lookups) {
    for (NamedDecl /*P*/ D : Set) {
      {
        boolean Res = Gen.$call(cast_ValueDecl(D));
        if (Res) {
          return Res;
        }
      }
    }
  }
  return ((boolean)false);
}

//<editor-fold defaultstate="collapsed" desc="buildDeclareReductionRef">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 8861,
 FQN="buildDeclareReductionRef", NM="_ZL24buildDeclareReductionRefRN5clang4SemaENS_14SourceLocationENS_11SourceRangeEPNS_5ScopeERNS_12CXXScopeSpecERKNS_19DeclarationNameInfoENS_8QualTypeERN4llvm11SmallVectorIPNS_16CXXBaseSpecifierELj4EEEPNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZL24buildDeclareReductionRefRN5clang4SemaENS_14SourceLocationENS_11SourceRangeEPNS_5ScopeERNS_12CXXScopeSpecERKNS_19DeclarationNameInfoENS_8QualTypeERN4llvm11SmallVectorIPNS_16CXXBaseSpecifierELj4EEEPNS_4ExprE")
//</editor-fold>
public static ActionResultTTrue<Expr /*P*/ > buildDeclareReductionRef(final Sema /*&*/ SemaRef, SourceLocation Loc, SourceRange Range, 
                        Scope /*P*/ S, final CXXScopeSpec /*&*/ ReductionIdScopeSpec, 
                        final /*const*/ DeclarationNameInfo /*&*/ ReductionId, QualType Ty, 
                        final SmallVector<CXXBaseSpecifier /*P*/> /*&*/ BasePath, Expr /*P*/ UnresolvedReduction) {
  if (ReductionIdScopeSpec.isInvalid()) {
    return ExprError();
  }
  SmallVector<UnresolvedSet> Lookups/*J*/= new SmallVector<UnresolvedSet>(4, new UnresolvedSet());
  if ((S != null)) {
    LookupResult Lookup = null;
    try {
      Lookup/*J*/= new LookupResult(SemaRef, ReductionId, Sema.LookupNameKind.LookupOMPReductionName);
      Lookup.suppressDiagnostics();
      while ((S != null) && SemaRef.LookupParsedName(Lookup, S, $AddrOf(ReductionIdScopeSpec))) {
        NamedDecl /*P*/ D = Lookup.getRepresentativeDecl();
        do {
          S = S.getParent();
        } while ((S != null) && !S.isDeclScope(D));
        if ((S != null)) {
          S = S.getParent();
        }
        Lookups.push_back_T$RR(new UnresolvedSet(8));
        Lookups.back().append(Lookup.begin(), Lookup.end());
        Lookup.clear();
      }
    } finally {
      if (Lookup != null) { Lookup.$destroy(); }
    }
  } else {
    UnresolvedLookupExpr /*P*/ ULE = cast_or_null_UnresolvedLookupExpr(UnresolvedReduction);
    if ((ULE != null)) {
      Lookups.push_back_T$RR(new UnresolvedSet(8));
      Decl /*P*/ PrevD = null;
      for (NamedDecl /*P*/ D : ULE.decls()) {
        if (D == PrevD) {
          Lookups.push_back_T$RR(new UnresolvedSet(8));
        } else {
          OMPDeclareReductionDecl /*P*/ DRD = cast_OMPDeclareReductionDecl(D);
          if ((DRD != null)) {
            Lookups.back().addDecl(DRD);
          }
        }
        PrevD = D;
      }
    }
  }
  if (Ty.$arrow().isDependentType() || Ty.$arrow().isInstantiationDependentType()
     || Ty.$arrow().containsUnexpandedParameterPack()
     || filterLookupForUDR$Bool(Lookups, /*FuncArg*//*[]*/ (ValueDecl /*P*/ D) -> {
            return !D.isInvalidDecl()
               && (D.getType().$arrow().isDependentType()
               || D.getType().$arrow().isInstantiationDependentType()
               || D.getType().$arrow().containsUnexpandedParameterPack());
          })) {
    UnresolvedSet ResSet/*J*/= new UnresolvedSet(8);
    for (final UnresolvedSet /*&*/ Set : Lookups) {
      ResSet.append(Set.begin(), Set.end());
      // The last item marks the end of all declarations at the specified scope.
      ResSet.addDecl(Set.$at(Set.size() - 1).$NamedDecl$P());
    }
    return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, UnresolvedLookupExpr.Create(SemaRef.Context, /*NamingClass=*/ (CXXRecordDecl /*P*/ )null, 
            ReductionIdScopeSpec.getWithLocInContext(SemaRef.Context), ReductionId, 
            /*ADL=*/ true, /*Overloaded=*/ true, ResSet.begin(), ResSet.end()));
  }
  {
    QualType L$Ty = new QualType(Ty);
    type$ptr<ValueDecl /*P*/> VD = filterLookupForUDR(Lookups, /*FuncArg*//*[&SemaRef, =L$Ty(Ty)]*/ (ValueDecl /*P*/ D) -> {
              if (!D.isInvalidDecl()
                 && SemaRef.Context.hasSameType(D.getType(), new QualType(L$Ty))) {
                return D;
              }
              return (ValueDecl /*P*/ )null;
            });
    if ((VD.$star() != null)) {
      return SemaRef.BuildDeclRefExpr(VD.$star(), new QualType(Ty), ExprValueKind.VK_LValue, new SourceLocation(Loc));
    }
  }
  {
    QualType L$Ty = new QualType(Ty);
    SourceLocation L$Loc = new SourceLocation(Loc);
    type$ptr<ValueDecl /*P*/> VD = filterLookupForUDR(Lookups, /*FuncArg*//*[&SemaRef, =L$Ty(Ty), =L$Loc(Loc)]*/ (ValueDecl /*P*/ D) -> {
              if (!D.isInvalidDecl()
                 && SemaRef.IsDerivedFrom(new SourceLocation(L$Loc), new QualType(L$Ty), D.getType())
                 && !L$Ty.isMoreQualifiedThan(D.getType())) {
                return D;
              }
              return (ValueDecl /*P*/ )null;
            });
    if ((VD.$star() != null)) {
      CXXBasePaths Paths = null;
      try {
        Paths/*J*/= new CXXBasePaths(/*FindAmbiguities=*/ true, /*RecordPaths=*/ true, 
            /*DetectVirtual=*/ false);
        if (SemaRef.IsDerivedFrom(new SourceLocation(Loc), new QualType(Ty), VD.$star().getType(), Paths)) {
          if (!Paths.isAmbiguous(SemaRef.Context.getCanonicalType(VD.$star().getType().getUnqualifiedType()))) {
            if (SemaRef.CheckBaseClassAccess(new SourceLocation(Loc), VD.$star().getType(), new QualType(Ty), Paths.front(), 
                /*DiagID=*/ 0)
               != Sema.AccessResult.AR_inaccessible) {
              SemaRef.BuildBasePathArray(Paths, BasePath);
              return SemaRef.BuildDeclRefExpr(VD.$star(), new QualType(Ty), ExprValueKind.VK_LValue, new SourceLocation(Loc));
            }
          }
        }
      } finally {
        if (Paths != null) { Paths.$destroy(); }
      }
    }
  }
  if (ReductionIdScopeSpec.isSet()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(new SourceLocation(Loc), diag.err_omp_not_resolved_reduction_identifier)), Range));
      return ExprError();
    } finally {
      $c$.$destroy();
    }
  }
  return ExprEmpty();
}

//<editor-fold defaultstate="collapsed" desc="IsCXXRecordForMappable">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 10254,
 FQN="IsCXXRecordForMappable", NM="_ZL22IsCXXRecordForMappableRN5clang4SemaENS_14SourceLocationEPN12_GLOBAL__N_110DSAStackTyEPNS_13CXXRecordDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZL22IsCXXRecordForMappableRN5clang4SemaENS_14SourceLocationEPN12_GLOBAL__N_110DSAStackTyEPNS_13CXXRecordDeclE")
//</editor-fold>
public static boolean IsCXXRecordForMappable(final Sema /*&*/ SemaRef, SourceLocation Loc, 
                      DSAStackTy /*P*/ Stack, CXXRecordDecl /*P*/ RD) {
  if (!(RD != null) || RD.isInvalidDecl()) {
    return true;
  }
  {
    
    ClassTemplateSpecializationDecl /*P*/ CTSD = dyn_cast_ClassTemplateSpecializationDecl(RD);
    if ((CTSD != null)) {
      {
        ClassTemplateDecl /*P*/ CTD = CTSD.getSpecializedTemplate();
        if ((CTD != null)) {
          RD = CTD.getTemplatedDecl();
        }
      }
    }
  }
  QualType QTy = SemaRef.Context.getRecordType(RD);
  if (RD.isDynamicClass()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(new SourceLocation(Loc), diag.err_omp_not_mappable_type)), QTy));
      $c$.clean($c$.track(SemaRef.Diag(RD.getLocation(), diag.note_omp_polymorphic_in_target)));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  CXXRecordDecl /*P*/ DC = RD;
  boolean IsCorrect = true;
  for (Decl /*P*/ I : DC.decls()) {
    if ((I != null)) {
      {
        CXXMethodDecl /*P*/ MD = dyn_cast_CXXMethodDecl(I);
        if ((MD != null)) {
          if (MD.isStatic()) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(new SourceLocation(Loc), diag.err_omp_not_mappable_type)), QTy));
              $c$.clean($c$.track(SemaRef.Diag(MD.getLocation(), 
                  diag.note_omp_static_member_in_target)));
              IsCorrect = false;
            } finally {
              $c$.$destroy();
            }
          }
        } else {
          VarDecl /*P*/ VD = dyn_cast_VarDecl(I);
          if ((VD != null)) {
            if (VD.isStaticDataMember()) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(new SourceLocation(Loc), diag.err_omp_not_mappable_type)), QTy));
                $c$.clean($c$.track(SemaRef.Diag(VD.getLocation(), 
                    diag.note_omp_static_member_in_target)));
                IsCorrect = false;
              } finally {
                $c$.$destroy();
              }
            }
          }
        }
      }
    }
  }
  
  for (final CXXBaseSpecifier /*&*/ I : RD.bases()) {
    if (!IsCXXRecordForMappable(SemaRef, I.getLocStart(), Stack, 
        I.getType().$arrow().getAsCXXRecordDecl())) {
      IsCorrect = false;
    }
  }
  return IsCorrect;
}

//<editor-fold defaultstate="collapsed" desc="CheckTypeMappable">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 10298,
 FQN="CheckTypeMappable", NM="_ZL17CheckTypeMappableN5clang14SourceLocationENS_11SourceRangeERNS_4SemaEPN12_GLOBAL__N_110DSAStackTyENS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZL17CheckTypeMappableN5clang14SourceLocationENS_11SourceRangeERNS_4SemaEPN12_GLOBAL__N_110DSAStackTyENS_8QualTypeE")
//</editor-fold>
public static boolean CheckTypeMappable(SourceLocation SL, SourceRange SR, final Sema /*&*/ SemaRef, 
                 DSAStackTy /*P*/ Stack, QualType QTy) {
  type$ptr<NamedDecl /*P*/ > ND = create_type$null$ptr();
  if (QTy.$arrow().isIncompleteType($AddrOf(ND))) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(new SourceLocation(SL), diag.err_incomplete_type)), QTy), SR));
      return false;
    } finally {
      $c$.$destroy();
    }
  } else {
    CXXRecordDecl /*P*/ RD = dyn_cast_or_null_CXXRecordDecl(ND.$star());
    if ((RD != null)) {
      if (!RD.isInvalidDecl()
         && !IsCXXRecordForMappable(SemaRef, new SourceLocation(SL), Stack, RD)) {
        return false;
      }
    }
  }
  return true;
}


/// \brief Return true if it can be proven that the provided array expression
/// (array section or array subscript) does NOT specify the whole size of the
/// array whose base type is \a BaseQTy.
//<editor-fold defaultstate="collapsed" desc="CheckArrayExpressionDoesNotReferToWholeSize">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 10315,
 FQN="CheckArrayExpressionDoesNotReferToWholeSize", NM="_ZL43CheckArrayExpressionDoesNotReferToWholeSizeRN5clang4SemaEPKNS_4ExprENS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZL43CheckArrayExpressionDoesNotReferToWholeSizeRN5clang4SemaEPKNS_4ExprENS_8QualTypeE")
//</editor-fold>
public static boolean CheckArrayExpressionDoesNotReferToWholeSize(final Sema /*&*/ SemaRef, 
                                           /*const*/ Expr /*P*/ E, 
                                           QualType BaseQTy) {
  /*const*/ OMPArraySectionExpr /*P*/ OASE = dyn_cast_OMPArraySectionExpr(E);
  
  // If this is an array subscript, it refers to the whole size if the size of
  // the dimension is constant and equals 1. Also, an array section assumes the
  // format of an array subscript if no colon is used.
  if (isa_ArraySubscriptExpr(E) || ((OASE != null) && OASE.getColonLoc().isInvalid())) {
    {
      /*const*/ ConstantArrayType /*P*/ ATy = dyn_cast_ConstantArrayType(BaseQTy.getTypePtr());
      if ((ATy != null)) {
        return ATy.getSize().getSExtValue() != 1;
      }
    }
    // Size can't be evaluated statically.
    return false;
  }
  assert ((OASE != null)) : "Expecting array section if not an array subscript.";
  /*const*/ Expr /*P*/ LowerBound = OASE.getLowerBound$Const();
  /*const*/ Expr /*P*/ Length = OASE.getLength$Const();
  
  // If there is a lower bound that does not evaluates to zero, we are not
  // convering the whole dimension.
  if ((LowerBound != null)) {
    APSInt ConstLowerBound/*J*/= new APSInt();
    if (!LowerBound.EvaluateAsInt(ConstLowerBound, SemaRef.getASTContext())) {
      return false; // Can't get the integer value as a constant.
    }
    if ((ConstLowerBound.getSExtValue() != 0)) {
      return true;
    }
  }
  
  // If we don't have a length we covering the whole dimension.
  if (!(Length != null)) {
    return false;
  }
  
  // If the base is a pointer, we don't have a way to get the size of the
  // pointee.
  if (BaseQTy.$arrow().isPointerType()) {
    return false;
  }
  
  // We can only check if the length is the same as the size of the dimension
  // if we have a constant array.
  /*const*/ ConstantArrayType /*P*/ CATy = dyn_cast_ConstantArrayType(BaseQTy.getTypePtr());
  if (!(CATy != null)) {
    return false;
  }
  
  APSInt ConstLength/*J*/= new APSInt();
  if (!Length.EvaluateAsInt(ConstLength, SemaRef.getASTContext())) {
    return false; // Can't get the integer value as a constant.
  }
  
  return CATy.getSize().getSExtValue() != ConstLength.getSExtValue();
}


// Return true if it can be proven that the provided array expression (array
// section or array subscript) does NOT specify a single element of the array
// whose base type is \a BaseQTy.
//<editor-fold defaultstate="collapsed" desc="CheckArrayExpressionDoesNotReferToUnitySize">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 10369,
 FQN="CheckArrayExpressionDoesNotReferToUnitySize", NM="_ZL43CheckArrayExpressionDoesNotReferToUnitySizeRN5clang4SemaEPKNS_4ExprENS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZL43CheckArrayExpressionDoesNotReferToUnitySizeRN5clang4SemaEPKNS_4ExprENS_8QualTypeE")
//</editor-fold>
public static boolean CheckArrayExpressionDoesNotReferToUnitySize(final Sema /*&*/ SemaRef, 
                                           /*const*/ Expr /*P*/ E, 
                                           QualType BaseQTy) {
  /*const*/ OMPArraySectionExpr /*P*/ OASE = dyn_cast_OMPArraySectionExpr(E);
  
  // An array subscript always refer to a single element. Also, an array section
  // assumes the format of an array subscript if no colon is used.
  if (isa_ArraySubscriptExpr(E) || ((OASE != null) && OASE.getColonLoc().isInvalid())) {
    return false;
  }
  assert ((OASE != null)) : "Expecting array section if not an array subscript.";
  /*const*/ Expr /*P*/ Length = OASE.getLength$Const();
  
  // If we don't have a length we have to check if the array has unitary size
  // for this dimension. Also, we should always expect a length if the base type
  // is pointer.
  if (!(Length != null)) {
    {
      /*const*/ ConstantArrayType /*P*/ ATy = dyn_cast_ConstantArrayType(BaseQTy.getTypePtr());
      if ((ATy != null)) {
        return ATy.getSize().getSExtValue() != 1;
      }
    }
    // We cannot assume anything.
    return false;
  }
  
  // Check if the length evaluates to 1.
  APSInt ConstLength/*J*/= new APSInt();
  if (!Length.EvaluateAsInt(ConstLength, SemaRef.getASTContext())) {
    return false; // Can't get the integer value as a constant.
  }
  
  return ConstLength.getSExtValue() != 1;
}


// Return the expression of the base of the mappable expression or null if it
// cannot be determined and do all the necessary checks to see if the expression
// is valid as a standalone mappable expression. In the process, record all the
// components of the expression.
//<editor-fold defaultstate="collapsed" desc="CheckMapClauseExpressionBase">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 10404,
 FQN="CheckMapClauseExpressionBase", NM="_ZL28CheckMapClauseExpressionBaseRN5clang4SemaEPNS_4ExprERN4llvm11SmallVectorINS_27OMPClauseMappableExprCommon17MappableComponentELj8EEENS_16OpenMPClauseKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZL28CheckMapClauseExpressionBaseRN5clang4SemaEPNS_4ExprERN4llvm11SmallVectorINS_27OMPClauseMappableExprCommon17MappableComponentELj8EEENS_16OpenMPClauseKindE")
//</editor-fold>
public static Expr /*P*/ CheckMapClauseExpressionBase(final Sema /*&*/ SemaRef, Expr /*P*/ E, 
                            final SmallVector<MappableComponent> /*&*/ CurComponents, 
                            OpenMPClauseKind CKind) {
  SourceLocation ELoc = E.getExprLoc();
  SourceRange ERange = E.getSourceRange();
  
  // The base of elements of list in a map clause have to be either:
  //  - a reference to variable or field.
  //  - a member expression.
  //  - an array expression.
  //
  // E.g. if we have the expression 'r.S.Arr[:12]', we want to retrieve the
  // reference to 'r'.
  //
  // If we have:
  //
  // struct SS {
  //   Bla S;
  //   foo() {
  //     #pragma omp target map (S.Arr[:12]);
  //   }
  // }
  //
  // We want to retrieve the member expression 'this->S';
  Expr /*P*/ RelevantExpr = null;
  
  // OpenMP 4.5 [2.15.5.1, map Clause, Restrictions, p.2]
  //  If a list item is an array section, it must specify contiguous storage.
  //
  // For this restriction it is sufficient that we make sure only references
  // to variables or fields and array expressions, and that no array sections
  // exist except in the rightmost expression (unless they cover the whole
  // dimension of the array). E.g. these would be invalid:
  //
  //   r.ArrS[3:5].Arr[6:7]
  //
  //   r.ArrS[3:5].x
  //
  // but these would be valid:
  //   r.ArrS[3].Arr[6:7]
  //
  //   r.ArrS[3].x
  boolean AllowUnitySizeArraySection = true;
  boolean AllowWholeSizeArraySection = true;
  while (!(RelevantExpr != null)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      E = E.IgnoreParenImpCasts();
      {
        
        DeclRefExpr /*P*/ CurE = dyn_cast_DeclRefExpr(E);
        if ((CurE != null)) {
          if (!isa_VarDecl(CurE.getDecl())) {
            break;
          }
          
          RelevantExpr = CurE;
          
          // If we got a reference to a declaration, we should not expect any array
          // section before that.
          AllowUnitySizeArraySection = false;
          AllowWholeSizeArraySection = false;
          
          // Record the component.
          CurComponents.push_back(new OMPClauseMappableExprCommon.MappableComponent(CurE, CurE.getDecl()));
          continue;
        }
      }
      {
        
        MemberExpr /*P*/ CurE = dyn_cast_MemberExpr(E);
        if ((CurE != null)) {
          Expr /*P*/ BaseE = CurE.getBase().IgnoreParenImpCasts();
          if (isa_CXXThisExpr(BaseE)) {
            // We found a base expression: this->Val.
            RelevantExpr = CurE;
          } else {
            E = BaseE;
          }
          if (!isa_FieldDecl(CurE.getMemberDecl())) {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(new SourceLocation(ELoc), diag.err_omp_expected_access_to_data_field)), 
                CurE.getSourceRange()));
            break;
          }
          
          FieldDecl /*P*/ FD = cast_FieldDecl(CurE.getMemberDecl());
          
          // OpenMP 4.5 [2.15.5.1, map Clause, Restrictions, C/C++, p.3]
          //  A bit-field cannot appear in a map clause.
          //
          if (FD.isBitField()) {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(new SourceLocation(ELoc), diag.err_omp_bit_fields_forbidden_in_clause)), 
                    CurE.getSourceRange()), getOpenMPClauseName(CKind)));
            break;
          }
          
          // OpenMP 4.5 [2.15.5.1, map Clause, Restrictions, C++, p.1]
          //  If the type of a list item is a reference to a type T then the type
          //  will be considered to be T for all purposes of this clause.
          QualType CurType = BaseE.getType().getNonReferenceType();
          {
            
            // OpenMP 4.5 [2.15.5.1, map Clause, Restrictions, C/C++, p.2]
            //  A list item cannot be a variable that is a member of a structure with
            //  a union type.
            //
            /*const*/ RecordType /*P*/ RT = CurType.$arrow().<RecordType>getAs$RecordType();
            if ((RT != null)) {
              if (RT.isUnionType()) {
                $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(new SourceLocation(ELoc), diag.err_omp_union_type_not_allowed)), 
                    CurE.getSourceRange()));
                break;
              }
            }
          }
          
          // If we got a member expression, we should not expect any array section
          // before that:
          //
          // OpenMP 4.5 [2.15.5.1, map Clause, Restrictions, p.7]
          //  If a list item is an element of a structure, only the rightmost symbol
          //  of the variable reference can be an array section.
          //
          AllowUnitySizeArraySection = false;
          AllowWholeSizeArraySection = false;
          
          // Record the component.
          CurComponents.push_back(new OMPClauseMappableExprCommon.MappableComponent(CurE, FD));
          continue;
        }
      }
      {
        
        ArraySubscriptExpr /*P*/ CurE = dyn_cast_ArraySubscriptExpr(E);
        if ((CurE != null)) {
          E = CurE.getBase().IgnoreParenImpCasts();
          if (!E.getType().$arrow().isAnyPointerType() && !E.getType().$arrow().isArrayType()) {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(new SourceLocation(ELoc), diag.err_omp_expected_base_var_name)), 
                    0), CurE.getSourceRange()));
            break;
          }
          
          // If we got an array subscript that express the whole dimension we
          // can have any array expressions before. If it only expressing part of
          // the dimension, we can only have unitary-size array expressions.
          if (CheckArrayExpressionDoesNotReferToWholeSize(SemaRef, CurE, 
              E.getType())) {
            AllowWholeSizeArraySection = false;
          }
          
          // Record the component - we don't have any declaration associated.
          CurComponents.push_back(new OMPClauseMappableExprCommon.MappableComponent(CurE, (ValueDecl /*P*/ )null));
          continue;
        }
      }
      {
        
        OMPArraySectionExpr /*P*/ CurE = dyn_cast_OMPArraySectionExpr(E);
        if ((CurE != null)) {
          E = CurE.getBase().IgnoreParenImpCasts();
          
          QualType CurType = OMPArraySectionExpr.getBaseOriginalType(E).getCanonicalType();
          
          // OpenMP 4.5 [2.15.5.1, map Clause, Restrictions, C++, p.1]
          //  If the type of a list item is a reference to a type T then the type
          //  will be considered to be T for all purposes of this clause.
          if (CurType.$arrow().isReferenceType()) {
            CurType.$assignMove(CurType.$arrow().getPointeeType());
          }
          
          boolean IsPointer = CurType.$arrow().isAnyPointerType();
          if (!IsPointer && !CurType.$arrow().isArrayType()) {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(new SourceLocation(ELoc), diag.err_omp_expected_base_var_name)), 
                    0), CurE.getSourceRange()));
            break;
          }
          
          boolean NotWhole = CheckArrayExpressionDoesNotReferToWholeSize(SemaRef, CurE, new QualType(CurType));
          boolean NotUnity = CheckArrayExpressionDoesNotReferToUnitySize(SemaRef, CurE, new QualType(CurType));
          if (AllowWholeSizeArraySection && AllowUnitySizeArraySection) {
            // Any array section is currently allowed.
            //
            // If this array section refers to the whole dimension we can still
            // accept other array sections before this one, except if the base is a
            // pointer. Otherwise, only unitary sections are accepted.
            if (NotWhole || IsPointer) {
              AllowWholeSizeArraySection = false;
            }
          } else if ((AllowUnitySizeArraySection && NotUnity)
             || (AllowWholeSizeArraySection && NotWhole)) {
            // A unity or whole array section is not allowed and that is not
            // compatible with the properties of the current array section.
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(new SourceLocation(ELoc), diag.err_array_section_does_not_specify_contiguous_storage)), 
                CurE.getSourceRange()));
            break;
          }
          
          // Record the component - we don't have any declaration associated.
          CurComponents.push_back(new OMPClauseMappableExprCommon.MappableComponent(CurE, (ValueDecl /*P*/ )null));
          continue;
        }
      }
      
      // If nothing else worked, this is not a valid map clause expression.
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(new SourceLocation(ELoc), 
              diag.err_omp_expected_named_var_member_or_array_expression)), 
          ERange));
      break;
    } finally {
      $c$.$destroy();
    }
  }
  
  return RelevantExpr;
}


// Return true if expression E associated with value VD has conflicts with other
// map information.
//<editor-fold defaultstate="collapsed" desc="CheckMapConflicts">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 10613,
 FQN="CheckMapConflicts", NM="_ZL17CheckMapConflictsRN5clang4SemaEPN12_GLOBAL__N_110DSAStackTyEPNS_9ValueDeclEPNS_4ExprEbN4llvm8ArrayRefINS_27OMPClauseMappableExprCommon17MappableComponentEEENS_16OpenMPClauseKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZL17CheckMapConflictsRN5clang4SemaEPN12_GLOBAL__N_110DSAStackTyEPNS_9ValueDeclEPNS_4ExprEbN4llvm8ArrayRefINS_27OMPClauseMappableExprCommon17MappableComponentEEENS_16OpenMPClauseKindE")
//</editor-fold>
public static boolean CheckMapConflicts(final Sema /*&*/ SemaRef, DSAStackTy /*P*/ DSAS, ValueDecl /*P*/ VD, Expr /*P*/ E, 
                 boolean CurrentRegionOnly, 
                 ArrayRef<MappableComponent> CurComponents, 
                 OpenMPClauseKind CKind) {
  assert ((VD != null) && (E != null));
  SourceLocation ELoc = E.getExprLoc();
  SourceRange ERange = E.getSourceRange();
  
  // In order to easily check the conflicts we need to match each component of
  // the expression under test with the components of the expressions that are
  // already in the stack.
  assert (!CurComponents.empty()) : "Map clause expression with no components!";
  assert (CurComponents.back().getAssociatedDeclaration() == VD) : "Map clause expression with unexpected base!";
  
  // Variables to help detecting enclosing problems in data environment nests.
  final bool$ptr IsEnclosedByDataEnvironmentExpr = create_bool$ptr(false);
  type$ptr</*const*/ Expr /*P*/> EnclosingExpr = create_type$null$ptr();
  
  boolean FoundError = DSAS.checkMappableExprComponentListsForDecl(VD, CurrentRegionOnly, 
      /*FuncArg*//*[&, &VD, &CurComponents, &CurrentRegionOnly, &SemaRef, &CKind, &ELoc, &ERange, &IsEnclosedByDataEnvironmentExpr, &EnclosingExpr]*/ (ArrayRef<MappableComponent> StackComponents) -> {
            assert (!StackComponents.empty()) : "Map clause expression with no components!";
            assert (StackComponents.back().getAssociatedDeclaration() == VD) : "Map clause expression with unexpected base!";
            
            // The whole expression in the stack.
            Expr /*P*/ RE = StackComponents.front().getAssociatedExpression();
            
            // Expressions must start from the same base. Here we detect at which
            // point both expressions diverge from each other and see if we can
            // detect if the memory referred to both expressions is contiguous and
            // do not overlap.
            reverse_iterator</*const*/ MappableComponent /*P*/ > CI = CurComponents.rbegin();
            reverse_iterator</*const*/ MappableComponent /*P*/ > CE = CurComponents.rend();
            reverse_iterator</*const*/ MappableComponent /*P*/ > SI = StackComponents.rbegin();
            reverse_iterator</*const*/ MappableComponent /*P*/ > SE = StackComponents.rend();
            for (; $noteq_reverse_iterator$C(CI, CE) && $noteq_reverse_iterator$C(SI, SE); CI.$preInc() , SI.$preInc()) {
              
              // OpenMP 4.5 [2.15.5.1, map Clause, Restrictions, p.3]
              //  At most one list item can be an array item derived from a given
              //  variable in map clauses of the same construct.
              if (CurrentRegionOnly
                 && (isa_ArraySubscriptExpr(CI.$arrow().getAssociatedExpression())
                 || isa_OMPArraySectionExpr(CI.$arrow().getAssociatedExpression()))
                 && (isa_ArraySubscriptExpr(SI.$arrow().getAssociatedExpression())
                 || isa_OMPArraySectionExpr(SI.$arrow().getAssociatedExpression()))) {
                JavaCleaner $c$ = $createJavaCleaner();
                try {
                  $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(CI.$arrow().getAssociatedExpression().getExprLoc(), 
                          diag.err_omp_multiple_array_items_in_map_clause)), 
                      CI.$arrow().getAssociatedExpression().getSourceRange()));
                  $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(SI.$arrow().getAssociatedExpression().getExprLoc(), 
                          diag.note_used_here)), 
                      SI.$arrow().getAssociatedExpression().getSourceRange()));
                  return true;
                } finally {
                  $c$.$destroy();
                }
              }
              
              // Do both expressions have the same kind?
              if (CI.$arrow().getAssociatedExpression().getStmtClass()
                 != SI.$arrow().getAssociatedExpression().getStmtClass()) {
                break;
              }
              
              // Are we dealing with different variables/fields?
              if (CI.$arrow().getAssociatedDeclaration() != SI.$arrow().getAssociatedDeclaration()) {
                break;
              }
            }
            
            // OpenMP 4.5 [2.15.5.1, map Clause, Restrictions, p.4]
            //  List items of map clauses in the same construct must not share
            //  original storage.
            //
            // If the expressions are exactly the same or one is a subset of the
            // other, it means they are sharing storage.
            if ($eq_reverse_iterator$C(CI, CE) && $eq_reverse_iterator$C(SI, SE)) {
              if (CurrentRegionOnly) {
                JavaCleaner $c$ = $createJavaCleaner();
                try {
                  if (CKind == OpenMPClauseKind.OMPC_map) {
                    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(new SourceLocation(ELoc), diag.err_omp_map_shared_storage)), ERange));
                  } else {
                    assert (CKind == OpenMPClauseKind.OMPC_to || CKind == OpenMPClauseKind.OMPC_from);
                    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(new SourceLocation(ELoc), diag.err_omp_once_referenced_in_target_update)), 
                        ERange));
                  }
                  $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(RE.getExprLoc(), diag.note_used_here)), 
                      RE.getSourceRange()));
                  return true;
                } finally {
                  $c$.$destroy();
                }
              } else {
                // If we find the same expression in the enclosing data environment,
                // that is legal.
                IsEnclosedByDataEnvironmentExpr.$set(true);
                return false;
              }
            }
            
            QualType DerivedType = std.prev(new reverse_iterator</*const*/ MappableComponent /*P*/ >(CI)).$arrow().getAssociatedDeclaration().getType();
            SourceLocation DerivedLoc = std.prev(new reverse_iterator</*const*/ MappableComponent /*P*/ >(CI)).$arrow().getAssociatedExpression().getExprLoc();
            
            // OpenMP 4.5 [2.15.5.1, map Clause, Restrictions, C++, p.1]
            //  If the type of a list item is a reference to a type T then the type
            //  will be considered to be T for all purposes of this clause.
            DerivedType.$assignMove(DerivedType.getNonReferenceType());
            
            // OpenMP 4.5 [2.15.5.1, map Clause, Restrictions, C/C++, p.1]
            //  A variable for which the type is pointer and an array section
            //  derived from that variable must not appear as list items of map
            //  clauses of the same construct.
            //
            // Also, cover one of the cases in:
            // OpenMP 4.5 [2.15.5.1, map Clause, Restrictions, p.5]
            //  If any part of the original storage of a list item has corresponding
            //  storage in the device data environment, all of the original storage
            //  must have corresponding storage in the device data environment.
            //
            if (DerivedType.$arrow().isAnyPointerType()) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                if ($eq_reverse_iterator$C(CI, CE) || $eq_reverse_iterator$C(SI, SE)) {
                  $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(new SourceLocation(DerivedLoc), 
                          diag.err_omp_pointer_mapped_along_with_derived_section)), 
                      DerivedLoc));
                } else {
                  assert ($noteq_reverse_iterator$C(CI, CE) && $noteq_reverse_iterator$C(SI, SE));
                  $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(new SourceLocation(DerivedLoc), diag.err_omp_same_pointer_derreferenced)), 
                      DerivedLoc));
                }
                $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(RE.getExprLoc(), diag.note_used_here)), 
                    RE.getSourceRange()));
                return true;
              } finally {
                $c$.$destroy();
              }
            }
            
            // OpenMP 4.5 [2.15.5.1, map Clause, Restrictions, p.4]
            //  List items of map clauses in the same construct must not share
            //  original storage.
            //
            // An expression is a subset of the other.
            if (CurrentRegionOnly && ($eq_reverse_iterator$C(CI, CE) || $eq_reverse_iterator$C(SI, SE))) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                if (CKind == OpenMPClauseKind.OMPC_map) {
                  $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(new SourceLocation(ELoc), diag.err_omp_map_shared_storage)), ERange));
                } else {
                  assert (CKind == OpenMPClauseKind.OMPC_to || CKind == OpenMPClauseKind.OMPC_from);
                  $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(new SourceLocation(ELoc), diag.err_omp_once_referenced_in_target_update)), 
                      ERange));
                }
                $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(RE.getExprLoc(), diag.note_used_here)), 
                    RE.getSourceRange()));
                return true;
              } finally {
                $c$.$destroy();
              }
            }
            
            // The current expression uses the same base as other expression in the
            // data environment but does not contain it completely.
            if (!CurrentRegionOnly && $noteq_reverse_iterator$C(SI, SE)) {
              EnclosingExpr.$set(RE);
            }
            
            // The current expression is a subset of the expression in the data
            // environment.
            IsEnclosedByDataEnvironmentExpr.$set$orassign(0, (!CurrentRegionOnly && $noteq_reverse_iterator$C(CI, CE) && $eq_reverse_iterator$C(SI, SE)));
            
            return false;
          });
  if (CurrentRegionOnly) {
    return FoundError;
  }
  
  // OpenMP 4.5 [2.15.5.1, map Clause, Restrictions, p.5]
  //  If any part of the original storage of a list item has corresponding
  //  storage in the device data environment, all of the original storage must
  //  have corresponding storage in the device data environment.
  // OpenMP 4.5 [2.15.5.1, map Clause, Restrictions, p.6]
  //  If a list item is an element of a structure, and a different element of
  //  the structure has a corresponding list item in the device data environment
  //  prior to a task encountering the construct associated with the map clause,
  //  then the list item must also have a corresponding list item in the device
  //  data environment prior to the task encountering the construct.
  //
  if ((EnclosingExpr != null) && !IsEnclosedByDataEnvironmentExpr.$star()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(new SourceLocation(ELoc), 
              diag.err_omp_original_storage_is_shared_and_does_not_contain)), 
          ERange));
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(EnclosingExpr.$star().getExprLoc(), diag.note_used_here)), 
          EnclosingExpr.$star().getSourceRange()));
      return true;
    } finally {
      $c$.$destroy();
    }
  }
  
  return FoundError;
}


// Check the validity of the provided variable list for the provided clause kind
// \a CKind. In the check process the valid expressions, and mappable expression
// components and variables are extracted and used to fill \a Vars,
// \a ClauseComponents, and \a ClauseBaseDeclarations. \a MapType and
// \a IsMapTypeImplicit are expected to be valid if the clause kind is 'map'.
//<editor-fold defaultstate="collapsed" desc="checkMappableExpressionList">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 10831,
 FQN="checkMappableExpressionList", NM="_ZL27checkMappableExpressionListRN5clang4SemaEPN12_GLOBAL__N_110DSAStackTyENS_16OpenMPClauseKindERNS2_19MappableVarListInfoENS_14SourceLocationENS_19OpenMPMapClauseKindEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZL27checkMappableExpressionListRN5clang4SemaEPN12_GLOBAL__N_110DSAStackTyENS_16OpenMPClauseKindERNS2_19MappableVarListInfoENS_14SourceLocationENS_19OpenMPMapClauseKindEb")
//</editor-fold>
public static void checkMappableExpressionList(final Sema /*&*/ SemaRef, DSAStackTy /*P*/ DSAS, 
                           OpenMPClauseKind CKind, final MappableVarListInfo /*&*/ MVLI, 
                           SourceLocation StartLoc) {
  checkMappableExpressionList(SemaRef, DSAS, 
                           CKind, MVLI, 
                           StartLoc, 
                           OpenMPMapClauseKind.OMPC_MAP_unknown, 
                           false);
}
public static void checkMappableExpressionList(final Sema /*&*/ SemaRef, DSAStackTy /*P*/ DSAS, 
                           OpenMPClauseKind CKind, final MappableVarListInfo /*&*/ MVLI, 
                           SourceLocation StartLoc, 
                           OpenMPMapClauseKind MapType/*= OMPC_MAP_unknown*/) {
  checkMappableExpressionList(SemaRef, DSAS, 
                           CKind, MVLI, 
                           StartLoc, 
                           MapType, 
                           false);
}
public static void checkMappableExpressionList(final Sema /*&*/ SemaRef, DSAStackTy /*P*/ DSAS, 
                           OpenMPClauseKind CKind, final MappableVarListInfo /*&*/ MVLI, 
                           SourceLocation StartLoc, 
                           OpenMPMapClauseKind MapType/*= OMPC_MAP_unknown*/, 
                           boolean IsMapTypeImplicit/*= false*/) {
  // We only expect mappable expressions in 'to', 'from', and 'map' clauses.
  assert ((CKind == OpenMPClauseKind.OMPC_map || CKind == OpenMPClauseKind.OMPC_to || CKind == OpenMPClauseKind.OMPC_from)) : "Unexpected clause kind with mappable expressions!";
  
  // Keep track of the mappable components and base declarations in this clause.
  // Each entry in the list is going to have a list of components associated. We
  // record each set of the components so that we can build the clause later on.
  // In the end we should have the same amount of declarations and component
  // lists.
  for (final Expr /*P*/ /*const*/ /*&*/ RE : MVLI.VarList) {
    assert ((RE != null)) : "Null expr in omp to/from/map clause";
    SourceLocation ELoc = RE.getExprLoc();
    
    Expr /*P*/ VE = RE.IgnoreParenLValueCasts();
    if (VE.isValueDependent() || VE.isTypeDependent()
       || VE.isInstantiationDependent()
       || VE.containsUnexpandedParameterPack()) {
      // We can only analyze this information once the missing information is
      // resolved.
      MVLI.ProcessedVarList.push_back(RE);
      continue;
    }
    
    Expr /*P*/ SimpleExpr = RE.IgnoreParenCasts();
    if (!RE.IgnoreParenImpCasts().isLValue()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(new SourceLocation(ELoc), 
                diag.err_omp_expected_named_var_member_or_array_expression)), 
            RE.getSourceRange()));
        continue;
      } finally {
        $c$.$destroy();
      }
    }
    
    SmallVector<MappableComponent> CurComponents/*J*/= new SmallVector<MappableComponent>(8, new MappableComponent());
    ValueDecl /*P*/ CurDeclaration = null;
    
    // Obtain the array or member expression bases if required. Also, fill the
    // components array with all the components identified in the process.
    Expr /*P*/ BE = CheckMapClauseExpressionBase(SemaRef, SimpleExpr, CurComponents, CKind);
    if (!(BE != null)) {
      continue;
    }
    assert (!CurComponents.empty()) : "Invalid mappable expression information.";
    
    // For the following checks, we rely on the base declaration which is
    // expected to be associated with the last component. The declaration is
    // expected to be a variable or a field (if 'this' is being mapped).
    CurDeclaration = CurComponents.back().getAssociatedDeclaration();
    assert ((CurDeclaration != null)) : "Null decl on map clause.";
    assert (CurDeclaration.isCanonicalDecl()) : "Expecting components to have associated only canonical declarations.";
    
    VarDecl /*P*/ VD = dyn_cast_VarDecl(CurDeclaration);
    FieldDecl /*P*/ FD = dyn_cast_FieldDecl(CurDeclaration);
    assert (((VD != null) || (FD != null))) : "Only variables or fields are expected here!";
    ///*J:(void)*/FD;
    
    // OpenMP 4.5 [2.15.5.1, map Clause, Restrictions, p.10]
    // threadprivate variables cannot appear in a map clause.
    // OpenMP 4.5 [2.10.5, target update Construct]
    // threadprivate variables cannot appear in a from clause.
    if ((VD != null) && DSAS.isThreadPrivate(VD)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        DSAVarData DVar = DSAS.getTopDSA(VD, false);
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(new SourceLocation(ELoc), diag.err_omp_threadprivate_in_clause)), 
            getOpenMPClauseName(CKind)));
        ReportOriginalDSA(SemaRef, DSAS, VD, new DSAStackTy.DSAVarData(DVar));
        continue;
      } finally {
        $c$.$destroy();
      }
    }
    
    // OpenMP 4.5 [2.15.5.1, map Clause, Restrictions, p.9]
    //  A list item cannot appear in both a map clause and a data-sharing
    //  attribute clause on the same construct.
    
    // Check conflicts with other map clause expressions. We check the conflicts
    // with the current construct separately from the enclosing data
    // environment, because the restrictions are different. We only have to
    // check conflicts across regions for the map clauses.
    if (CheckMapConflicts(SemaRef, DSAS, CurDeclaration, SimpleExpr, 
        /*CurrentRegionOnly=*/ true, new ArrayRef<MappableComponent>(CurComponents, false), CKind)) {
      break;
    }
    if (CKind == OpenMPClauseKind.OMPC_map
       && CheckMapConflicts(SemaRef, DSAS, CurDeclaration, SimpleExpr, 
        /*CurrentRegionOnly=*/ false, new ArrayRef<MappableComponent>(CurComponents, false), CKind)) {
      break;
    }
    
    // OpenMP 4.5 [2.10.5, target update Construct]
    // OpenMP 4.5 [2.15.5.1, map Clause, Restrictions, C++, p.1]
    //  If the type of a list item is a reference to a type T then the type will
    //  be considered to be T for all purposes of this clause.
    QualType Type = CurDeclaration.getType().getNonReferenceType();
    
    // OpenMP 4.5 [2.10.5, target update Construct, Restrictions, p.4]
    // A list item in a to or from clause must have a mappable type.
    // OpenMP 4.5 [2.15.5.1, map Clause, Restrictions, p.9]
    //  A list item must have a mappable type.
    if (!CheckTypeMappable(VE.getExprLoc(), VE.getSourceRange(), SemaRef, 
        DSAS, new QualType(Type))) {
      continue;
    }
    if (CKind == OpenMPClauseKind.OMPC_map) {
      // target enter data
      // OpenMP [2.10.2, Restrictions, p. 99]
      // A map-type must be specified in all map clauses and must be either
      // to or alloc.
      OpenMPDirectiveKind DKind = DSAS.getCurrentDirective();
      if (DKind == OpenMPDirectiveKind.OMPD_target_enter_data
         && !(MapType == OpenMPMapClauseKind.OMPC_MAP_to || MapType == OpenMPMapClauseKind.OMPC_MAP_alloc)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(new SourceLocation(StartLoc), diag.err_omp_invalid_map_type_for_directive)), 
                      (IsMapTypeImplicit ? 1 : 0)), 
                  getOpenMPSimpleClauseTypeName(OpenMPClauseKind.OMPC_map, MapType.getValue())), 
              getOpenMPDirectiveName(DKind)));
          continue;
        } finally {
          $c$.$destroy();
        }
      }
      
      // target exit_data
      // OpenMP [2.10.3, Restrictions, p. 102]
      // A map-type must be specified in all map clauses and must be either
      // from, release, or delete.
      if (DKind == OpenMPDirectiveKind.OMPD_target_exit_data
         && !(MapType == OpenMPMapClauseKind.OMPC_MAP_from || MapType == OpenMPMapClauseKind.OMPC_MAP_release
         || MapType == OpenMPMapClauseKind.OMPC_MAP_delete)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(new SourceLocation(StartLoc), diag.err_omp_invalid_map_type_for_directive)), 
                      (IsMapTypeImplicit ? 1 : 0)), 
                  getOpenMPSimpleClauseTypeName(OpenMPClauseKind.OMPC_map, MapType.getValue())), 
              getOpenMPDirectiveName(DKind)));
          continue;
        } finally {
          $c$.$destroy();
        }
      }
      
      // OpenMP 4.5 [2.15.5.1, Restrictions, p.3]
      // A list item cannot appear in both a map clause and a data-sharing
      // attribute clause on the same construct
      if (DKind == OpenMPDirectiveKind.OMPD_target && (VD != null)) {
        DSAVarData DVar = DSAS.getTopDSA(VD, false);
        if (isOpenMPPrivate(DVar.CKind)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(new SourceLocation(ELoc), diag.err_omp_variable_in_map_and_dsa)), 
                    getOpenMPClauseName(DVar.CKind)), 
                getOpenMPDirectiveName(DSAS.getCurrentDirective())));
            ReportOriginalDSA(SemaRef, DSAS, CurDeclaration, new DSAStackTy.DSAVarData(DVar));
            continue;
          } finally {
            $c$.$destroy();
          }
        }
      }
    }
    
    // Save the current expression.
    MVLI.ProcessedVarList.push_back(RE);
    
    // Store the components in the stack so that they can be used to check
    // against other clauses later on.
    DSAS.addMappableExpressionComponents(CurDeclaration, new ArrayRef<MappableComponent>(CurComponents, false));
    
    // Save the components and declaration to create the clause. For purposes of
    // the clause creation, any component list that has has base 'this' uses
    // null as base declaration.
    MVLI.VarComponents.resize(MVLI.VarComponents.size() + 1);
    MVLI.VarComponents.back().append_T(CurComponents.begin(), 
        CurComponents.end());
    MVLI.VarBaseDeclarations.push_back(isa_MemberExpr(BE) ? (ValueDecl /*P*/ )null : CurDeclaration);
  }
}

//<editor-fold defaultstate="collapsed" desc="checkDeclInTargetContext">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 11499,
 FQN="checkDeclInTargetContext", NM="_ZL24checkDeclInTargetContextN5clang14SourceLocationENS_11SourceRangeERNS_4SemaEPNS_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZL24checkDeclInTargetContextN5clang14SourceLocationENS_11SourceRangeERNS_4SemaEPNS_4DeclE")
//</editor-fold>
public static void checkDeclInTargetContext(SourceLocation SL, SourceRange SR, 
                        final Sema /*&*/ SemaRef, Decl /*P*/ D) {
  if (!(D != null)) {
    return;
  }
  Decl /*P*/ LD = null;
  if (isa_TagDecl(D)) {
    LD = cast_TagDecl(D).getDefinition();
  } else if (isa_VarDecl(D)) {
    LD = cast_VarDecl(D).getDefinition();
    
    // If this is an implicit variable that is legal and we do not need to do
    // anything.
    if (cast_VarDecl(D).isImplicit()) {
      Attr /*P*/ A = OMPDeclareTargetDeclAttr.CreateImplicit(SemaRef.Context, OMPDeclareTargetDeclAttr.MapTypeTy.MT_To);
      D.addAttr(A);
      {
        ASTMutationListener /*P*/ ML = SemaRef.Context.getASTMutationListener();
        if ((ML != null)) {
          ML.DeclarationMarkedOpenMPDeclareTarget(D, A);
        }
      }
      return;
    }
  } else if (isa_FunctionDecl(D)) {
    type$ref</*const*/ FunctionDecl /*P*/ > FD = create_type$ref();
    if (cast_FunctionDecl(D).hasBody(FD)) {
      LD = ((/*const_cast*/FunctionDecl /*P*/ )(FD.$deref()));
    }
    
    // If the definition is associated with the current declaration in the
    // target region (it can be e.g. a lambda) that is legal and we do not need
    // to do anything else.
    if (LD == D) {
      Attr /*P*/ A = OMPDeclareTargetDeclAttr.CreateImplicit(SemaRef.Context, OMPDeclareTargetDeclAttr.MapTypeTy.MT_To);
      D.addAttr(A);
      {
        ASTMutationListener /*P*/ ML = SemaRef.Context.getASTMutationListener();
        if ((ML != null)) {
          ML.DeclarationMarkedOpenMPDeclareTarget(D, A);
        }
      }
      return;
    }
  }
  if (!(LD != null)) {
    LD = D;
  }
  if ((LD != null) && !LD.hasAttr(OMPDeclareTargetDeclAttr.class)
     && (isa_VarDecl(LD) || isa_FunctionDecl(LD))) {
    // Outlined declaration is not declared target.
    if (LD.isOutOfLine()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track(SemaRef.Diag(LD.getLocation(), diag.warn_omp_not_in_target_context)));
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(new SourceLocation(SL), diag.note_used_here)), SR));
      } finally {
        $c$.$destroy();
      }
    } else {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        DeclContext /*P*/ DC = LD.getDeclContext();
        while ((DC != null)) {
          if (isa_FunctionDecl(DC)
             && cast_FunctionDecl(DC).hasAttr(OMPDeclareTargetDeclAttr.class)) {
            break;
          }
          DC = DC.getParent();
        }
        if ((DC != null)) {
          return;
        }
        
        // Is not declared in target context.
        $c$.clean($c$.track(SemaRef.Diag(LD.getLocation(), diag.warn_omp_not_in_target_context)));
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(new SourceLocation(SL), diag.note_used_here)), SR));
      } finally {
        $c$.$destroy();
      }
    }
    // Mark decl as declared target to prevent further diagnostic.
    Attr /*P*/ A = OMPDeclareTargetDeclAttr.CreateImplicit(SemaRef.Context, OMPDeclareTargetDeclAttr.MapTypeTy.MT_To);
    D.addAttr(A);
    {
      ASTMutationListener /*P*/ ML = SemaRef.Context.getASTMutationListener();
      if ((ML != null)) {
        ML.DeclarationMarkedOpenMPDeclareTarget(D, A);
      }
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="checkValueDeclInTarget">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 11569,
 FQN="checkValueDeclInTarget", NM="_ZL22checkValueDeclInTargetN5clang14SourceLocationENS_11SourceRangeERNS_4SemaEPN12_GLOBAL__N_110DSAStackTyEPNS_9ValueDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZL22checkValueDeclInTargetN5clang14SourceLocationENS_11SourceRangeERNS_4SemaEPN12_GLOBAL__N_110DSAStackTyEPNS_9ValueDeclE")
//</editor-fold>
public static boolean checkValueDeclInTarget(SourceLocation SL, SourceRange SR, 
                      final Sema /*&*/ SemaRef, DSAStackTy /*P*/ Stack, 
                      ValueDecl /*P*/ VD) {
  if (VD.hasAttr(OMPDeclareTargetDeclAttr.class)) {
    return true;
  }
  if (!CheckTypeMappable(new SourceLocation(SL), new SourceRange(SR), SemaRef, Stack, VD.getType())) {
    return false;
  }
  return true;
}

} // END OF class SemaOpenMPStatics
