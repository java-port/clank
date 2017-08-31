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
import static org.clank.java.std.*;
import static org.llvm.adt.ADTAliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.ast.llvm.*;
import org.clang.ast.OMPClauseMappableExprCommon.*;
import org.clang.basic.*;
import org.clang.sema.impl.*;
import static org.clang.basic.BasicClangGlobals.*;
import static org.clang.sema.Sema.*;
import static org.clang.sema.Sema_NestedClasses.SemaDiagnosticBuilder.*;
import static org.clang.sema.SemaClangGlobals.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.AstClangGlobals.*;
import static org.clang.sema.impl.SemaOpenMPStatics.*;
import org.clang.sema.impl.DSAStackTy.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import org.clang.sema.LookupResult.Filter;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.java.AstStatementsRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type Sema_SemaOpenMP">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this -extends=Sema_SemaObjCProperty ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4Sema15EndOpenMPClauseEv;_ZN5clang4Sema17ActOnOpenMPClauseENS_16OpenMPClauseKindENS_14SourceLocationES2_;_ZN5clang4Sema17EndOpenMPDSABlockEPNS_4StmtE;_ZN5clang4Sema17StartOpenMPClauseENS_16OpenMPClauseKindE;_ZN5clang4Sema19ActOnOpenMPIfClauseENS_19OpenMPDirectiveKindEPNS_4ExprENS_14SourceLocationES4_S4_S4_S4_;_ZN5clang4Sema19ActOnOpenMPToClauseEN4llvm8ArrayRefIPNS_4ExprEEENS_14SourceLocationES6_S6_;_ZN5clang4Sema19StartOpenMPDSABlockENS_19OpenMPDirectiveKindERKNS_19DeclarationNameInfoEPNS_5ScopeENS_14SourceLocationE;_ZN5clang4Sema19isOpenMPPrivateDeclEPNS_9ValueDeclEj;_ZN5clang4Sema20ActOnOpenMPMapClauseENS_19OpenMPMapClauseKindES1_bNS_14SourceLocationES2_N4llvm8ArrayRefIPNS_4ExprEEES2_S2_S2_;_ZN5clang4Sema20ActOnOpenMPRegionEndENS_12ActionResultIPNS_4StmtELb1EEEN4llvm8ArrayRefIPNS_9OMPClauseEEE;_ZN5clang4Sema20IsOpenMPCapturedDeclEPNS_9ValueDeclE;_ZN5clang4Sema21ActOnOpenMPFromClauseEN4llvm8ArrayRefIPNS_4ExprEEENS_14SourceLocationES6_S6_;_ZN5clang4Sema21ActOnOpenMPHintClauseEPNS_4ExprENS_14SourceLocationES3_S3_;_ZN5clang4Sema21ActOnOpenMPReadClauseENS_14SourceLocationES1_;_ZN5clang4Sema21ActOnOpenMPSIMDClauseENS_14SourceLocationES1_;_ZN5clang4Sema21CheckOpenMPLinearDeclEPNS_9ValueDeclENS_14SourceLocationENS_22OpenMPLinearClauseKindENS_8QualTypeE;_ZN5clang4Sema21IsOpenMPCapturedByRefEPNS_9ValueDeclEj;_ZN5clang4Sema21getOpenMPCapturedExprEPNS_7VarDeclENS_13ExprValueKindENS_14ExprObjectKindENS_14SourceLocationE;_ZN5clang4Sema22ActOnOpenMPFinalClauseEPNS_4ExprENS_14SourceLocationES3_S3_;_ZN5clang4Sema22ActOnOpenMPFlushClauseEN4llvm8ArrayRefIPNS_4ExprEEENS_14SourceLocationES6_S6_;_ZN5clang4Sema22ActOnOpenMPRegionStartENS_19OpenMPDirectiveKindEPNS_5ScopeE;_ZN5clang4Sema22ActOnOpenMPWriteClauseENS_14SourceLocationES1_;_ZN5clang4Sema23ActOnOpenMPCopyinClauseEN4llvm8ArrayRefIPNS_4ExprEEENS_14SourceLocationES6_S6_;_ZN5clang4Sema23ActOnOpenMPDependClauseENS_22OpenMPDependClauseKindENS_14SourceLocationES2_N4llvm8ArrayRefIPNS_4ExprEEES2_S2_S2_;_ZN5clang4Sema23ActOnOpenMPDeviceClauseEPNS_4ExprENS_14SourceLocationES3_S3_;_ZN5clang4Sema23ActOnOpenMPForDirectiveEN4llvm8ArrayRefIPNS_9OMPClauseEEEPNS_4StmtENS_14SourceLocationES8_RNS1_8DenseMapIPNS_9ValueDeclEPNS_4ExprENS1_12DenseMapInfoISB_EENS1_6detail12DenseMapPairISB_SD_EEEE;_ZN5clang4Sema23ActOnOpenMPIdExpressionEPNS_5ScopeERNS_12CXXScopeSpecERKNS_19DeclarationNameInfoE;_ZN5clang4Sema23ActOnOpenMPLinearClauseEN4llvm8ArrayRefIPNS_4ExprEEES4_NS_14SourceLocationES6_NS_22OpenMPLinearClauseKindES6_S6_S6_;_ZN5clang4Sema23ActOnOpenMPNowaitClauseENS_14SourceLocationES1_;_ZN5clang4Sema23ActOnOpenMPSeqCstClauseENS_14SourceLocationES1_;_ZN5clang4Sema23ActOnOpenMPSharedClauseEN4llvm8ArrayRefIPNS_4ExprEEENS_14SourceLocationES6_S6_;_ZN5clang4Sema23ActOnOpenMPSimpleClauseENS_16OpenMPClauseKindEjNS_14SourceLocationES2_S2_S2_;_ZN5clang4Sema23ActOnOpenMPUntiedClauseENS_14SourceLocationES1_;_ZN5clang4Sema23ActOnOpenMPUpdateClauseENS_14SourceLocationES1_;_ZN5clang4Sema24ActOnOpenMPAlignedClauseEN4llvm8ArrayRefIPNS_4ExprEEES4_NS_14SourceLocationES6_S6_S6_;_ZN5clang4Sema24ActOnOpenMPCaptureClauseENS_14SourceLocationES1_;_ZN5clang4Sema24ActOnOpenMPDefaultClauseENS_23OpenMPDefaultClauseKindENS_14SourceLocationES2_S2_S2_;_ZN5clang4Sema24ActOnOpenMPNogroupClauseENS_14SourceLocationES1_;_ZN5clang4Sema24ActOnOpenMPOrderedClauseENS_14SourceLocationES1_S1_PNS_4ExprE;_ZN5clang4Sema24ActOnOpenMPPrivateClauseEN4llvm8ArrayRefIPNS_4ExprEEENS_14SourceLocationES6_S6_;_ZN5clang4Sema24ActOnOpenMPSafelenClauseEPNS_4ExprENS_14SourceLocationES3_S3_;_ZN5clang4Sema24ActOnOpenMPSimdDirectiveEN4llvm8ArrayRefIPNS_9OMPClauseEEEPNS_4StmtENS_14SourceLocationES8_RNS1_8DenseMapIPNS_9ValueDeclEPNS_4ExprENS1_12DenseMapInfoISB_EENS1_6detail12DenseMapPairISB_SD_EEEE;_ZN5clang4Sema24ActOnOpenMPSimdlenClauseEPNS_4ExprENS_14SourceLocationES3_S3_;_ZN5clang4Sema24ActOnOpenMPTaskDirectiveEN4llvm8ArrayRefIPNS_9OMPClauseEEEPNS_4StmtENS_14SourceLocationES8_;_ZN5clang4Sema24ActOnOpenMPThreadsClauseENS_14SourceLocationES1_;_ZN5clang4Sema24ActOnOpenMPVarListClauseENS_16OpenMPClauseKindEN4llvm8ArrayRefIPNS_4ExprEEES5_NS_14SourceLocationES7_S7_S7_RNS_12CXXScopeSpecERKNS_19DeclarationNameInfoENS_22OpenMPDependClauseKindENS_22OpenMPLinearClauseKindENS_19OpenMPMapClauseKindESF_bS7_;_ZN5clang4Sema25ActOnOpenMPCollapseClauseEPNS_4ExprENS_14SourceLocationES3_S3_;_ZN5clang4Sema25ActOnOpenMPFlushDirectiveEN4llvm8ArrayRefIPNS_9OMPClauseEEENS_14SourceLocationES6_;_ZN5clang4Sema25ActOnOpenMPNumTasksClauseEPNS_4ExprENS_14SourceLocationES3_S3_;_ZN5clang4Sema25ActOnOpenMPNumTeamsClauseEPNS_4ExprENS_14SourceLocationES3_S3_;_ZN5clang4Sema25ActOnOpenMPPriorityClauseEPNS_4ExprENS_14SourceLocationES3_S3_;_ZN5clang4Sema25ActOnOpenMPProcBindClauseENS_24OpenMPProcBindClauseKindENS_14SourceLocationES2_S2_S2_;_ZN5clang4Sema25ActOnOpenMPScheduleClauseENS_28OpenMPScheduleClauseModifierES1_NS_24OpenMPScheduleClauseKindEPNS_4ExprENS_14SourceLocationES5_S5_S5_S5_S5_S5_;_ZN5clang4Sema25ActOnOpenMPTeamsDirectiveEN4llvm8ArrayRefIPNS_9OMPClauseEEEPNS_4StmtENS_14SourceLocationES8_;_ZN5clang4Sema25CheckOMPThreadPrivateDeclENS_14SourceLocationEN4llvm8ArrayRefIPNS_4ExprEEE;_ZN5clang4Sema25CheckOpenMPLinearModifierENS_22OpenMPLinearClauseKindENS_14SourceLocationE;_ZN5clang4Sema26ActOnOpenMPAtomicDirectiveEN4llvm8ArrayRefIPNS_9OMPClauseEEEPNS_4StmtENS_14SourceLocationES8_;_ZN5clang4Sema26ActOnOpenMPCancelDirectiveEN4llvm8ArrayRefIPNS_9OMPClauseEEENS_14SourceLocationES6_NS_19OpenMPDirectiveKindE;_ZN5clang4Sema26ActOnOpenMPGrainsizeClauseEPNS_4ExprENS_14SourceLocationES3_S3_;_ZN5clang4Sema26ActOnOpenMPMasterDirectiveEPNS_4StmtENS_14SourceLocationES3_;_ZN5clang4Sema26ActOnOpenMPMergeableClauseENS_14SourceLocationES1_;_ZN5clang4Sema26ActOnOpenMPReductionClauseEN4llvm8ArrayRefIPNS_4ExprEEENS_14SourceLocationES6_S6_S6_RNS_12CXXScopeSpecERKNS_19DeclarationNameInfoES5_;_ZN5clang4Sema26ActOnOpenMPSingleDirectiveEN4llvm8ArrayRefIPNS_9OMPClauseEEEPNS_4StmtENS_14SourceLocationES8_;_ZN5clang4Sema26ActOnOpenMPTargetDirectiveEN4llvm8ArrayRefIPNS_9OMPClauseEEEPNS_4StmtENS_14SourceLocationES8_;_ZN5clang4Sema26isOpenMPTargetCapturedDeclEPNS_9ValueDeclEj;_ZN5clang4Sema27ActOnOpenMPBarrierDirectiveENS_14SourceLocationES1_;_ZN5clang4Sema27ActOnOpenMPDefaultmapClauseENS_30OpenMPDefaultmapClauseModifierENS_26OpenMPDefaultmapClauseKindENS_14SourceLocationES3_S3_S3_S3_;_ZN5clang4Sema27ActOnOpenMPForSimdDirectiveEN4llvm8ArrayRefIPNS_9OMPClauseEEEPNS_4StmtENS_14SourceLocationES8_RNS1_8DenseMapIPNS_9ValueDeclEPNS_4ExprENS1_12DenseMapInfoISB_EENS1_6detail12DenseMapPairISB_SD_EEEE;_ZN5clang4Sema27ActOnOpenMPNumThreadsClauseEPNS_4ExprENS_14SourceLocationES3_S3_;_ZN5clang4Sema27ActOnOpenMPOrderedDirectiveEN4llvm8ArrayRefIPNS_9OMPClauseEEEPNS_4StmtENS_14SourceLocationES8_;_ZN5clang4Sema27ActOnOpenMPSectionDirectiveEPNS_4StmtENS_14SourceLocationES3_;_ZN5clang4Sema27ActOnOpenMPSingleExprClauseENS_16OpenMPClauseKindEPNS_4ExprENS_14SourceLocationES4_S4_;_ZN5clang4Sema28ActOnOpenMPCopyprivateClauseEN4llvm8ArrayRefIPNS_4ExprEEENS_14SourceLocationES6_S6_;_ZN5clang4Sema28ActOnOpenMPCriticalDirectiveERKNS_19DeclarationNameInfoEN4llvm8ArrayRefIPNS_9OMPClauseEEEPNS_4StmtENS_14SourceLocationESB_;_ZN5clang4Sema28ActOnOpenMPDeclareTargetNameEPNS_5ScopeERNS_12CXXScopeSpecERKNS_19DeclarationNameInfoENS_24OMPDeclareTargetDeclAttr9MapTypeTyERN4llvm14SmallSetVectorIPKNS_9NamedDeclELj16EEE;_ZN5clang4Sema28ActOnOpenMPIsDevicePtrClauseEN4llvm8ArrayRefIPNS_4ExprEEENS_14SourceLocationES6_S6_;_ZN5clang4Sema28ActOnOpenMPLastprivateClauseEN4llvm8ArrayRefIPNS_4ExprEEENS_14SourceLocationES6_S6_;_ZN5clang4Sema28ActOnOpenMPParallelDirectiveEN4llvm8ArrayRefIPNS_9OMPClauseEEEPNS_4StmtENS_14SourceLocationES8_;_ZN5clang4Sema28ActOnOpenMPSectionsDirectiveEN4llvm8ArrayRefIPNS_9OMPClauseEEEPNS_4StmtENS_14SourceLocationES8_;_ZN5clang4Sema28ActOnOpenMPTaskLoopDirectiveEN4llvm8ArrayRefIPNS_9OMPClauseEEEPNS_4StmtENS_14SourceLocationES8_RNS1_8DenseMapIPNS_9ValueDeclEPNS_4ExprENS1_12DenseMapInfoISB_EENS1_6detail12DenseMapPairISB_SD_EEEE;_ZN5clang4Sema28ActOnOpenMPTaskwaitDirectiveENS_14SourceLocationES1_;_ZN5clang4Sema28ActOnOpenMPThreadLimitClauseEPNS_4ExprENS_14SourceLocationES3_S3_;_ZN5clang4Sema29ActOnOpenMPDistScheduleClauseENS_28OpenMPDistScheduleClauseKindEPNS_4ExprENS_14SourceLocationES4_S4_S4_S4_;_ZN5clang4Sema29ActOnOpenMPFirstprivateClauseEN4llvm8ArrayRefIPNS_4ExprEEENS_14SourceLocationES6_S6_;_ZN5clang4Sema29ActOnOpenMPLoopInitializationENS_14SourceLocationEPNS_4StmtE;_ZN5clang4Sema29ActOnOpenMPTaskgroupDirectiveEPNS_4StmtENS_14SourceLocationES3_;_ZN5clang4Sema29ActOnOpenMPTaskyieldDirectiveENS_14SourceLocationES1_;_ZN5clang4Sema29ActOnOpenMPUseDevicePtrClauseEN4llvm8ArrayRefIPNS_4ExprEEENS_14SourceLocationES6_S6_;_ZN5clang4Sema30ActOnOpenMPDistributeDirectiveEN4llvm8ArrayRefIPNS_9OMPClauseEEEPNS_4StmtENS_14SourceLocationES8_RNS1_8DenseMapIPNS_9ValueDeclEPNS_4ExprENS1_12DenseMapInfoISB_EENS1_6detail12DenseMapPairISB_SD_EEEE;_ZN5clang4Sema30ActOnOpenMPExecutableDirectiveENS_19OpenMPDirectiveKindERKNS_19DeclarationNameInfoES1_N4llvm8ArrayRefIPNS_9OMPClauseEEEPNS_4StmtENS_14SourceLocationESC_;_ZN5clang4Sema30ActOnOpenMPTargetDataDirectiveEN4llvm8ArrayRefIPNS_9OMPClauseEEEPNS_4StmtENS_14SourceLocationES8_;_ZN5clang4Sema30InitDataSharingAttributesStackEv;_ZN5clang4Sema31ActOnOpenMPDeclareReductionTypeENS_14SourceLocationENS_12ActionResultINS_9OpaquePtrINS_8QualTypeEEELb0EEE;_ZN5clang4Sema31ActOnOpenMPDeclareSimdDirectiveENS_9OpaquePtrINS_12DeclGroupRefEEENS_22OMPDeclareSimdDeclAttr13BranchStateTyEPNS_4ExprEN4llvm8ArrayRefIS7_EESA_SA_SA_NS9_IjEESA_NS_11SourceRangeE;_ZN5clang4Sema31ActOnOpenMPParallelForDirectiveEN4llvm8ArrayRefIPNS_9OMPClauseEEEPNS_4StmtENS_14SourceLocationES8_RNS1_8DenseMapIPNS_9ValueDeclEPNS_4ExprENS1_12DenseMapInfoISB_EENS1_6detail12DenseMapPairISB_SD_EEEE;_ZN5clang4Sema32ActOnOpenMPTargetUpdateDirectiveEN4llvm8ArrayRefIPNS_9OMPClauseEEENS_14SourceLocationES6_;_ZN5clang4Sema32ActOnOpenMPTaskLoopSimdDirectiveEN4llvm8ArrayRefIPNS_9OMPClauseEEEPNS_4StmtENS_14SourceLocationES8_RNS1_8DenseMapIPNS_9ValueDeclEPNS_4ExprENS1_12DenseMapInfoISB_EENS1_6detail12DenseMapPairISB_SD_EEEE;_ZN5clang4Sema32checkDeclIsAllowedInOpenMPTargetEPNS_4ExprEPNS_4DeclE;_ZN5clang4Sema33ActOnOpenMPThreadprivateDirectiveENS_14SourceLocationEN4llvm8ArrayRefIPNS_4ExprEEE;_ZN5clang4Sema33DestroyDataSharingAttributesStackEv;_ZN5clang4Sema34ActOnOpenMPDistributeSimdDirectiveEN4llvm8ArrayRefIPNS_9OMPClauseEEEPNS_4StmtENS_14SourceLocationES8_RNS1_8DenseMapIPNS_9ValueDeclEPNS_4ExprENS1_12DenseMapInfoISB_EENS1_6detail12DenseMapPairISB_SD_EEEE;_ZN5clang4Sema34ActOnOpenMPSingleExprWithArgClauseENS_16OpenMPClauseKindEN4llvm8ArrayRefIjEEPNS_4ExprENS_14SourceLocationES7_NS3_IS7_EES7_S7_;_ZN5clang4Sema34ActOnOpenMPTargetExitDataDirectiveEN4llvm8ArrayRefIPNS_9OMPClauseEEENS_14SourceLocationES6_;_ZN5clang4Sema34ActOnOpenMPTargetParallelDirectiveEN4llvm8ArrayRefIPNS_9OMPClauseEEEPNS_4StmtENS_14SourceLocationES8_;_ZN5clang4Sema35ActOnOpenMPParallelForSimdDirectiveEN4llvm8ArrayRefIPNS_9OMPClauseEEEPNS_4StmtENS_14SourceLocationES8_RNS1_8DenseMapIPNS_9ValueDeclEPNS_4ExprENS1_12DenseMapInfoISB_EENS1_6detail12DenseMapPairISB_SD_EEEE;_ZN5clang4Sema35ActOnOpenMPTargetEnterDataDirectiveEN4llvm8ArrayRefIPNS_9OMPClauseEEENS_14SourceLocationES6_;_ZN5clang4Sema36ActOnOpenMPParallelSectionsDirectiveEN4llvm8ArrayRefIPNS_9OMPClauseEEEPNS_4StmtENS_14SourceLocationES8_;_ZN5clang4Sema37ActOnOpenMPCancellationPointDirectiveENS_14SourceLocationES1_NS_19OpenMPDirectiveKindE;_ZN5clang4Sema37ActOnOpenMPTargetParallelForDirectiveEN4llvm8ArrayRefIPNS_9OMPClauseEEEPNS_4StmtENS_14SourceLocationES8_RNS1_8DenseMapIPNS_9ValueDeclEPNS_4ExprENS1_12DenseMapInfoISB_EENS1_6detail12DenseMapPairISB_SD_EEEE;_ZN5clang4Sema37VerifyPositiveIntegerConstantInClauseEPNS_4ExprENS_16OpenMPClauseKindEb;_ZN5clang4Sema38ActOnOpenMPDeclareReductionCombinerEndEPNS_4DeclEPNS_4ExprE;_ZN5clang4Sema38ActOnStartOpenMPDeclareTargetDirectiveENS_14SourceLocationE;_ZN5clang4Sema38PerformOpenMPImplicitIntegerConversionENS_14SourceLocationEPNS_4ExprE;_ZN5clang4Sema39ActOnFinishOpenMPDeclareTargetDirectiveEv;_ZN5clang4Sema39ActOnOpenMPDeclareReductionDirectiveEndEPNS_5ScopeENS_9OpaquePtrINS_12DeclGroupRefEEEb;_ZN5clang4Sema40ActOnOpenMPDeclareReductionCombinerStartEPNS_5ScopeEPNS_4DeclE;_ZN5clang4Sema41ActOnOpenMPDeclareReductionDirectiveStartEPNS_5ScopeEPNS_11DeclContextENS_15DeclarationNameEN4llvm8ArrayRefISt4pairINS_8QualTypeENS_14SourceLocationEEEENS_15AccessSpecifierEPNS_4DeclE;_ZN5clang4Sema41ActOnOpenMPDeclareReductionInitializerEndEPNS_4DeclEPNS_4ExprE;_ZN5clang4Sema41ActOnOpenMPDistributeParallelForDirectiveEN4llvm8ArrayRefIPNS_9OMPClauseEEEPNS_4StmtENS_14SourceLocationES8_RNS1_8DenseMapIPNS_9ValueDeclEPNS_4ExprENS1_12DenseMapInfoISB_EENS1_6detail12DenseMapPairISB_SD_EEEE;_ZN5clang4Sema41ActOnOpenMPTargetParallelForSimdDirectiveEN4llvm8ArrayRefIPNS_9OMPClauseEEEPNS_4StmtENS_14SourceLocationES8_RNS1_8DenseMapIPNS_9ValueDeclEPNS_4ExprENS1_12DenseMapInfoISB_EENS1_6detail12DenseMapPairISB_SD_EEEE;_ZN5clang4Sema43ActOnOpenMPDeclareReductionInitializerStartEPNS_5ScopeEPNS_4DeclE;_ZN5clang4Sema45ActOnOpenMPDistributeParallelForSimdDirectiveEN4llvm8ArrayRefIPNS_9OMPClauseEEEPNS_4StmtENS_14SourceLocationES8_RNS1_8DenseMapIPNS_9ValueDeclEPNS_4ExprENS1_12DenseMapInfoISB_EENS1_6detail12DenseMapPairISB_SD_EEEE;_ZNK5clang4Sema21getOpenMPNestingLevelEv; -static-type=Sema_SemaOpenMP -package=org.clang.sema")
//</editor-fold>
public class Sema_SemaOpenMP extends Sema_SemaObjCProperty {
private final /*split clang::Sema*/ Sema $this() { return (Sema)this; }

/// \brief Initialization of data-sharing attributes stack.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::InitDataSharingAttributesStack">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 836,
 FQN="clang::Sema::InitDataSharingAttributesStack", NM="_ZN5clang4Sema30InitDataSharingAttributesStackEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4Sema30InitDataSharingAttributesStackEv")
//</editor-fold>
protected/*private*/ final void InitDataSharingAttributesStack() {
  $this().VarDataSharingAttributesStack = new DSAStackTy(/*Deref*/$this());
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::DestroyDataSharingAttributesStack">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 1042,
 FQN="clang::Sema::DestroyDataSharingAttributesStack", NM="_ZN5clang4Sema33DestroyDataSharingAttributesStackEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4Sema33DestroyDataSharingAttributesStackEv")
//</editor-fold>
protected/*private*/ final void DestroyDataSharingAttributesStack() {
  if (((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)) != null) { ((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).$destroy();};
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::VerifyPositiveIntegerConstantInClause">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 7421,
 FQN="clang::Sema::VerifyPositiveIntegerConstantInClause", NM="_ZN5clang4Sema37VerifyPositiveIntegerConstantInClauseEPNS_4ExprENS_16OpenMPClauseKindEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4Sema37VerifyPositiveIntegerConstantInClauseEPNS_4ExprENS_16OpenMPClauseKindEb")
//</editor-fold>
protected/*private*/ final ActionResultTTrue<Expr /*P*/ > VerifyPositiveIntegerConstantInClause(Expr /*P*/ E, 
                                     OpenMPClauseKind CKind) {
  return VerifyPositiveIntegerConstantInClause(E, 
                                     CKind, 
                                     true);
}
protected/*private*/ final ActionResultTTrue<Expr /*P*/ > VerifyPositiveIntegerConstantInClause(Expr /*P*/ E, 
                                     OpenMPClauseKind CKind, 
                                     boolean StrictlyPositive/*= true*/) {
  if (!(E != null)) {
    return ExprError();
  }
  if (E.isValueDependent() || E.isTypeDependent()
     || E.isInstantiationDependent() || E.containsUnexpandedParameterPack()) {
    return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
  }
  APSInt Result/*J*/= new APSInt();
  ActionResultTTrue<Expr /*P*/ > ICE = $this().VerifyIntegerConstantExpression(E, $AddrOf(Result));
  if (ICE.isInvalid()) {
    return ExprError();
  }
  if ((StrictlyPositive && !Result.isStrictlyPositive())
     || (!StrictlyPositive && !Result.isNonNegative())) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(E.getExprLoc(), diag.err_omp_negative_expression_in_clause)), 
                  getOpenMPClauseName(CKind)), (StrictlyPositive ? 1 : 0)), 
          E.getSourceRange()));
      return ExprError();
    } finally {
      $c$.$destroy();
    }
  }
  if (CKind == OpenMPClauseKind.OMPC_aligned && !Result.isPowerOf2()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(E.getExprLoc(), diag.warn_omp_alignment_not_power_of_two)), 
          E.getSourceRange()));
      return ExprError();
    } finally {
      $c$.$destroy();
    }
  }
  if (CKind == OpenMPClauseKind.OMPC_collapse && ((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).getAssociatedLoops() == 1) {
    ((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).setAssociatedLoops($long2uint(Result.getExtValue()));
  } else if (CKind == OpenMPClauseKind.OMPC_ordered) {
    ((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).setAssociatedLoops($long2uint(Result.getExtValue()));
  }
  return ICE;
}

/// Returns OpenMP nesting level for current directive.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::getOpenMPNestingLevel">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 975,
 FQN="clang::Sema::getOpenMPNestingLevel", NM="_ZNK5clang4Sema21getOpenMPNestingLevelEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZNK5clang4Sema21getOpenMPNestingLevelEv")
//</editor-fold>
protected/*private*/ final /*uint*/int getOpenMPNestingLevel() /*const*/ {
  assert Native.$bool($this().getLangOpts().OpenMP);
  return ((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).getNestingLevel();
}

/// \brief Return true if the provided declaration \a VD should be captured by
/// reference.
/// \param Level Relative level of nested OpenMP construct for that the check
/// is performed.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::IsOpenMPCapturedByRef">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 842,
 FQN="clang::Sema::IsOpenMPCapturedByRef", NM="_ZN5clang4Sema21IsOpenMPCapturedByRefEPNS_9ValueDeclEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4Sema21IsOpenMPCapturedByRefEPNS_9ValueDeclEj")
//</editor-fold>
public final boolean IsOpenMPCapturedByRef(ValueDecl /*P*/ D, /*uint*/int Level) {
  assert (($this().LangOpts.OpenMP != 0)) : "OpenMP is not allowed";
  
  final ASTContext /*&*/ Ctx = $this().getASTContext();
  boolean IsByRef = true;
  
  // Find the directive that is associated with the provided scope.
  QualType Ty = D.getType();
  if (((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).hasExplicitDirective(BasicClangGlobals::/*FuncArg*/isOpenMPTargetExecutionDirective, Level)) {
    // This table summarizes how a given variable should be passed to the device
    // given its type and the clauses where it appears. This table is based on
    // the description in OpenMP 4.5 [2.10.4, target Construct] and
    // OpenMP 4.5 [2.15.5, Data-mapping Attribute Rules and Clauses].
    //
    // =========================================================================
    // | type |  defaultmap   | pvt | first | is_device_ptr |    map   | res.  |
    // |      |(tofrom:scalar)|     |  pvt  |               |          |       |
    // =========================================================================
    // | scl  |               |     |       |       -       |          | bycopy|
    // | scl  |               |  -  |   x   |       -       |     -    | bycopy|
    // | scl  |               |  x  |   -   |       -       |     -    | null  |
    // | scl  |       x       |     |       |       -       |          | byref |
    // | scl  |       x       |  -  |   x   |       -       |     -    | bycopy|
    // | scl  |       x       |  x  |   -   |       -       |     -    | null  |
    // | scl  |               |  -  |   -   |       -       |     x    | byref |
    // | scl  |       x       |  -  |   -   |       -       |     x    | byref |
    //
    // | agg  |      n.a.     |     |       |       -       |          | byref |
    // | agg  |      n.a.     |  -  |   x   |       -       |     -    | byref |
    // | agg  |      n.a.     |  x  |   -   |       -       |     -    | null  |
    // | agg  |      n.a.     |  -  |   -   |       -       |     x    | byref |
    // | agg  |      n.a.     |  -  |   -   |       -       |    x[]   | byref |
    //
    // | ptr  |      n.a.     |     |       |       -       |          | bycopy|
    // | ptr  |      n.a.     |  -  |   x   |       -       |     -    | bycopy|
    // | ptr  |      n.a.     |  x  |   -   |       -       |     -    | null  |
    // | ptr  |      n.a.     |  -  |   -   |       -       |     x    | byref |
    // | ptr  |      n.a.     |  -  |   -   |       -       |    x[]   | bycopy|
    // | ptr  |      n.a.     |  -  |   -   |       x       |          | bycopy|
    // | ptr  |      n.a.     |  -  |   -   |       x       |     x    | bycopy|
    // | ptr  |      n.a.     |  -  |   -   |       x       |    x[]   | bycopy|
    // =========================================================================
    // Legend:
    //  scl - scalar
    //  ptr - pointer
    //  agg - aggregate
    //  x - applies
    //  - - invalid in this combination
    //  [] - mapped with an array section
    //  byref - should be mapped by reference
    //  byval - should be mapped by value
    //  null - initialize a local variable to null on the device
    //
    // Observations:
    //  - All scalar declarations that show up in a map clause have to be passed
    //    by reference, because they may have been mapped in the enclosing data
    //    environment.
    //  - If the scalar value does not fit the size of uintptr, it has to be
    //    passed by reference, regardless the result in the table above.
    //  - For pointers mapped by value that have either an implicit map or an
    //    array section, the runtime library may pass the NULL value to the
    //    device instead of the value passed to it by the compiler.
    if (Ty.$arrow().isReferenceType()) {
      Ty.$assignMove(Ty.$arrow().castAs(ReferenceType.class).getPointeeType());
    }
    
    // Locate map clauses and see if the variable being captured is referred to
    // in any of those clauses. Here we only care about variables, not fields,
    // because fields are part of aggregates.
    bool$ref IsVariableUsedInMapClause = create_bool$ref(false);
    boolean IsVariableAssociatedWithSection = false;
    ((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).checkMappableExprComponentListsForDecl(D, /*CurrentRegionOnly=*/ true, 
        /*FuncArg*//*[&, &IsVariableUsedInMapClause, &D, &IsVariableAssociatedWithSection]*/ (ArrayRef<MappableComponent> MapExprComponents) -> {
              
              reverse_iterator</*const*/ MappableComponent> EI = MapExprComponents.rbegin();
              reverse_iterator</*const*/ MappableComponent> EE = MapExprComponents.rend();
              assert ($noteq_reverse_iterator$C(EI, EE)) : "Invalid map expression!";
              if (isa_DeclRefExpr(EI.$arrow().getAssociatedExpression())) {
                IsVariableUsedInMapClause.$set$orassign(EI.$arrow().getAssociatedDeclaration() == D);
              }
              
              EI.$preInc();
              if ($eq_reverse_iterator$C(EI, EE)) {
                return false;
              }
              if (isa_ArraySubscriptExpr(EI.$arrow().getAssociatedExpression())
                 || isa_OMPArraySectionExpr(EI.$arrow().getAssociatedExpression())
                 || isa_MemberExpr(EI.$arrow().getAssociatedExpression())) {
                IsVariableUsedInMapClause.$set(true);
                // There is nothing more we need to know about this variable.
                return true;
              }
              
              // Keep looking for more map info.
              return false;
            });
    if (IsVariableUsedInMapClause.$deref()) {
      // If variable is identified in a map clause it is always captured by
      // reference except if it is a pointer that is dereferenced somehow.
      IsByRef = !(Ty.$arrow().isPointerType() && IsVariableAssociatedWithSection);
    } else {
      // By default, all the data that has a scalar type is mapped by copy.
      IsByRef = !Ty.$arrow().isScalarType();
    }
  }
  if (IsByRef && Ty.getNonReferenceType().$arrow().isScalarType()) {
    IsByRef = !((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).hasExplicitDSA(D, /*FuncArg*//*[]*/ (OpenMPClauseKind K) -> {
              return K == OpenMPClauseKind.OMPC_firstprivate;
            }, 
        Level, /*NotLastprivate=*/ true);
  }
  
  // When passing data by copy, we need to make sure it fits the uintptr size
  // and alignment, because the runtime library only deals with uintptr types.
  // If it does not fit the uintptr size, we need to pass the data by reference
  // instead.
  if (!IsByRef
     && (Ctx.getTypeSizeInChars(new QualType(Ty)).$greater(
      Ctx.getTypeSizeInChars(Ctx.getUIntPtrType())
  )
     || Ctx.getDeclAlign(D).$greater(Ctx.getTypeAlignInChars(Ctx.getUIntPtrType())))) {
    IsByRef = true;
  }
  
  return IsByRef;
}


/// \brief Check if the specified variable is used in one of the private
/// clauses (private, firstprivate, lastprivate, reduction etc.) in OpenMP
/// constructs.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::IsOpenMPCapturedDecl">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 980,
 FQN="clang::Sema::IsOpenMPCapturedDecl", NM="_ZN5clang4Sema20IsOpenMPCapturedDeclEPNS_9ValueDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4Sema20IsOpenMPCapturedDeclEPNS_9ValueDeclE")
//</editor-fold>
public final VarDecl /*P*/ IsOpenMPCapturedDecl(ValueDecl /*P*/ D) {
  assert (($this().LangOpts.OpenMP != 0)) : "OpenMP is not allowed";
  D = getCanonicalDecl(D);
  
  // If we are attempting to capture a global variable in a directive with
  // 'target' we return true so that this global is also mapped to the device.
  //
  // FIXME: If the declaration is enclosed in a 'declare target' directive,
  // then it should not be captured. Therefore, an extra check has to be
  // inserted here once support for 'declare target' is added.
  //
  VarDecl /*P*/ VD = dyn_cast_VarDecl(D);
  if ((VD != null) && !VD.hasLocalStorage()) {
    if (((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).getCurrentDirective() == OpenMPDirectiveKind.OMPD_target
       && !((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).isClauseParsingMode()) {
      return VD;
    }
    if (((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).hasDirective(/*FuncArg*//*[]*/ (OpenMPDirectiveKind K, final /*const*/ DeclarationNameInfo /*&*/ $Prm1, SourceLocation $Prm2) -> {
              return isOpenMPTargetExecutionDirective(K);
            }, 
        false)) {
      return VD;
    }
  }
  if (((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).getCurrentDirective() != OpenMPDirectiveKind.OMPD_unknown
     && (!((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).isClauseParsingMode()
     || ((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).getParentDirective() != OpenMPDirectiveKind.OMPD_unknown)) {
    final std.pairUIntType<VarDecl /*P*/ > /*&*/ Info = ((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).isLoopControlVariable(D);
    if ((Info.first != 0)
       || ((VD != null) && VD.hasLocalStorage()
       && isParallelOrTaskRegion(((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).getCurrentDirective()))
       || ((VD != null) && ((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).isForceVarCapturing())) {
      return (VD != null) ? VD : Info.second;
    }
    DSAVarData DVarPrivate = ((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).getTopDSA(D, ((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).isClauseParsingMode());
    if (DVarPrivate.CKind != OpenMPClauseKind.OMPC_unknown && isOpenMPPrivate(DVarPrivate.CKind)) {
      return (VD != null) ? VD : cast_VarDecl(DVarPrivate.PrivateCopy.getDecl());
    }
    DVarPrivate.$assignMove(((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).hasDSA(D, BasicClangGlobals::/*FuncArg*/isOpenMPPrivate, /*FuncArg*//*[]*/ (OpenMPDirectiveKind $Prm0) -> {
                  return true;
                }, 
            ((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).isClauseParsingMode()));
    if (DVarPrivate.CKind != OpenMPClauseKind.OMPC_unknown) {
      return (VD != null) ? VD : cast_VarDecl(DVarPrivate.PrivateCopy.getDecl());
    }
  }
  return null;
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::getOpenMPCapturedExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 8086,
 FQN="clang::Sema::getOpenMPCapturedExpr", NM="_ZN5clang4Sema21getOpenMPCapturedExprEPNS_7VarDeclENS_13ExprValueKindENS_14ExprObjectKindENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4Sema21getOpenMPCapturedExprEPNS_7VarDeclENS_13ExprValueKindENS_14ExprObjectKindENS_14SourceLocationE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > getOpenMPCapturedExpr(VarDecl /*P*/ Capture, ExprValueKind VK, 
                     ExprObjectKind OK, SourceLocation Loc) {
  ActionResultTTrue<Expr /*P*/ > Res = $this().BuildDeclRefExpr(Capture, Capture.getType().getNonReferenceType(), ExprValueKind.VK_LValue, new SourceLocation(Loc));
  if (!Res.isUsable()) {
    return ExprError();
  }
  if (OK == ExprObjectKind.OK_Ordinary && !$this().getLangOpts().CPlusPlus) {
    Res.$assignMove($this().CreateBuiltinUnaryOp(new SourceLocation(Loc), UnaryOperatorKind.UO_Deref, Res.get()));
    if (!Res.isUsable()) {
      return ExprError();
    }
  }
  if (VK != ExprValueKind.VK_LValue && Res.get().isGLValue()) {
    Res.$assignMove($this().DefaultLvalueConversion(Res.get()));
    if (!Res.isUsable()) {
      return ExprError();
    }
  }
  return Res;
}


/// \brief Check if the specified variable is used in 'private' clause.
/// \param Level Relative level of nested OpenMP construct for that the check
/// is performed.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::isOpenMPPrivateDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 1026,
 FQN="clang::Sema::isOpenMPPrivateDecl", NM="_ZN5clang4Sema19isOpenMPPrivateDeclEPNS_9ValueDeclEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4Sema19isOpenMPPrivateDeclEPNS_9ValueDeclEj")
//</editor-fold>
public final boolean isOpenMPPrivateDecl(ValueDecl /*P*/ D, /*uint*/int Level) {
  assert (($this().LangOpts.OpenMP != 0)) : "OpenMP is not allowed";
  return ((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).hasExplicitDSA(D, /*FuncArg*//*[]*/ (OpenMPClauseKind K) -> {
            return K == OpenMPClauseKind.OMPC_private;
          }, Level);
}


/// \brief Check if the specified variable is captured  by 'target' directive.
/// \param Level Relative level of nested OpenMP construct for that the check
/// is performed.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::isOpenMPTargetCapturedDecl">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 1032,
 FQN="clang::Sema::isOpenMPTargetCapturedDecl", NM="_ZN5clang4Sema26isOpenMPTargetCapturedDeclEPNS_9ValueDeclEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4Sema26isOpenMPTargetCapturedDeclEPNS_9ValueDeclEj")
//</editor-fold>
public final boolean isOpenMPTargetCapturedDecl(ValueDecl /*P*/ D, /*uint*/int Level) {
  assert (($this().LangOpts.OpenMP != 0)) : "OpenMP is not allowed";
  // Return true if the current level is no longer enclosed in a target region.
  VarDecl /*P*/ VD = dyn_cast_VarDecl(D);
  return (VD != null) && !VD.hasLocalStorage()
     && ((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).hasExplicitDirective(BasicClangGlobals::/*FuncArg*/isOpenMPTargetExecutionDirective, 
      Level);
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::PerformOpenMPImplicitIntegerConversion">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 7334,
 FQN="clang::Sema::PerformOpenMPImplicitIntegerConversion", NM="_ZN5clang4Sema38PerformOpenMPImplicitIntegerConversionENS_14SourceLocationEPNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4Sema38PerformOpenMPImplicitIntegerConversionENS_14SourceLocationEPNS_4ExprE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > PerformOpenMPImplicitIntegerConversion(SourceLocation Loc, 
                                      Expr /*P*/ Op) {
    //<editor-fold defaultstate="collapsed" desc="IntConvertDiagnoser">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 7339,
   FQN="IntConvertDiagnoser", NM="_ZZN5clang4Sema38PerformOpenMPImplicitIntegerConversionENS_14SourceLocationEPNS_4ExprEE19IntConvertDiagnoser",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZZN5clang4Sema38PerformOpenMPImplicitIntegerConversionENS_14SourceLocationEPNS_4ExprEE19IntConvertDiagnoser")
  //</editor-fold>
   class IntConvertDiagnoser extends /*public*/ ICEConvertDiagnoser implements Destructors.ClassWithDestructor {
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="clang::Sema::PerformOpenMPImplicitIntegerConversion(SourceLocation, Expr * )::IntConvertDiagnoser::IntConvertDiagnoser">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 7341,
     FQN="clang::Sema::PerformOpenMPImplicitIntegerConversion(SourceLocation, Expr * )::IntConvertDiagnoser::IntConvertDiagnoser", NM="_ZZN5clang4Sema38PerformOpenMPImplicitIntegerConversionENS_14SourceLocationEPNS_4ExprEEN19IntConvertDiagnoserC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZZN5clang4Sema38PerformOpenMPImplicitIntegerConversionENS_14SourceLocationEPNS_4ExprEEN19IntConvertDiagnoserC1Ev")
    //</editor-fold>
    public IntConvertDiagnoser() {
      // : ICEConvertDiagnoser(/*AllowScopedEnumerations*/ false, false, true) 
      //START JInit
      super(false, false, true);
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::Sema::PerformOpenMPImplicitIntegerConversion(SourceLocation, Expr * )::IntConvertDiagnoser::diagnoseNotInt">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 7343,
     FQN="clang::Sema::PerformOpenMPImplicitIntegerConversion(SourceLocation, Expr * )::IntConvertDiagnoser::diagnoseNotInt", NM="_ZZN5clang4Sema38PerformOpenMPImplicitIntegerConversionENS_14SourceLocationEPNS_4ExprEEN19IntConvertDiagnoser14diagnoseNotIntERS0_S1_NS_8QualTypeE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZZN5clang4Sema38PerformOpenMPImplicitIntegerConversionENS_14SourceLocationEPNS_4ExprEEN19IntConvertDiagnoser14diagnoseNotIntERS0_S1_NS_8QualTypeE")
    //</editor-fold>
    @Override public SemaDiagnosticBuilder diagnoseNotInt(final Sema /*&*/ S, SourceLocation Loc, 
                  QualType T)/* override*/ {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        return $c$.clean(new SemaDiagnosticBuilder($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc), diag.err_omp_not_integral)), T)));
      } finally {
        $c$.$destroy();
      }
    }

    //<editor-fold defaultstate="collapsed" desc="clang::Sema::PerformOpenMPImplicitIntegerConversion(SourceLocation, Expr * )::IntConvertDiagnoser::diagnoseIncomplete">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 7347,
     FQN="clang::Sema::PerformOpenMPImplicitIntegerConversion(SourceLocation, Expr * )::IntConvertDiagnoser::diagnoseIncomplete", NM="_ZZN5clang4Sema38PerformOpenMPImplicitIntegerConversionENS_14SourceLocationEPNS_4ExprEEN19IntConvertDiagnoser18diagnoseIncompleteERS0_S1_NS_8QualTypeE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZZN5clang4Sema38PerformOpenMPImplicitIntegerConversionENS_14SourceLocationEPNS_4ExprEEN19IntConvertDiagnoser18diagnoseIncompleteERS0_S1_NS_8QualTypeE")
    //</editor-fold>
    @Override public SemaDiagnosticBuilder diagnoseIncomplete(final Sema /*&*/ S, SourceLocation Loc, 
                      QualType T)/* override*/ {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        return $c$.clean(new SemaDiagnosticBuilder($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc), diag.err_omp_incomplete_type)), T)));
      } finally {
        $c$.$destroy();
      }
    }

    //<editor-fold defaultstate="collapsed" desc="clang::Sema::PerformOpenMPImplicitIntegerConversion(SourceLocation, Expr * )::IntConvertDiagnoser::diagnoseExplicitConv">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 7351,
     FQN="clang::Sema::PerformOpenMPImplicitIntegerConversion(SourceLocation, Expr * )::IntConvertDiagnoser::diagnoseExplicitConv", NM="_ZZN5clang4Sema38PerformOpenMPImplicitIntegerConversionENS_14SourceLocationEPNS_4ExprEEN19IntConvertDiagnoser20diagnoseExplicitConvERS0_S1_NS_8QualTypeES6_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZZN5clang4Sema38PerformOpenMPImplicitIntegerConversionENS_14SourceLocationEPNS_4ExprEEN19IntConvertDiagnoser20diagnoseExplicitConvERS0_S1_NS_8QualTypeES6_")
    //</editor-fold>
    @Override public SemaDiagnosticBuilder diagnoseExplicitConv(final Sema /*&*/ S, SourceLocation Loc, 
                        QualType T, 
                        QualType ConvTy)/* override*/ {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        return $c$.clean(new SemaDiagnosticBuilder($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc), diag.err_omp_explicit_conversion)), T), ConvTy)));
      } finally {
        $c$.$destroy();
      }
    }

    //<editor-fold defaultstate="collapsed" desc="clang::Sema::PerformOpenMPImplicitIntegerConversion(SourceLocation, Expr * )::IntConvertDiagnoser::noteExplicitConv">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 7356,
     FQN="clang::Sema::PerformOpenMPImplicitIntegerConversion(SourceLocation, Expr * )::IntConvertDiagnoser::noteExplicitConv", NM="_ZZN5clang4Sema38PerformOpenMPImplicitIntegerConversionENS_14SourceLocationEPNS_4ExprEEN19IntConvertDiagnoser16noteExplicitConvERS0_PNS_17CXXConversionDeclENS_8QualTypeE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZZN5clang4Sema38PerformOpenMPImplicitIntegerConversionENS_14SourceLocationEPNS_4ExprEEN19IntConvertDiagnoser16noteExplicitConvERS0_PNS_17CXXConversionDeclENS_8QualTypeE")
    //</editor-fold>
    @Override public SemaDiagnosticBuilder noteExplicitConv(final Sema /*&*/ S, CXXConversionDecl /*P*/ Conv, 
                    QualType ConvTy)/* override*/ {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        return $c$.clean(new SemaDiagnosticBuilder($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Conv.getLocation(), diag.note_omp_conversion_here)), 
                    ConvTy.$arrow().isEnumeralType()), ConvTy)));
      } finally {
        $c$.$destroy();
      }
    }

    //<editor-fold defaultstate="collapsed" desc="clang::Sema::PerformOpenMPImplicitIntegerConversion(SourceLocation, Expr * )::IntConvertDiagnoser::diagnoseAmbiguous">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 7361,
     FQN="clang::Sema::PerformOpenMPImplicitIntegerConversion(SourceLocation, Expr * )::IntConvertDiagnoser::diagnoseAmbiguous", NM="_ZZN5clang4Sema38PerformOpenMPImplicitIntegerConversionENS_14SourceLocationEPNS_4ExprEEN19IntConvertDiagnoser17diagnoseAmbiguousERS0_S1_NS_8QualTypeE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZZN5clang4Sema38PerformOpenMPImplicitIntegerConversionENS_14SourceLocationEPNS_4ExprEEN19IntConvertDiagnoser17diagnoseAmbiguousERS0_S1_NS_8QualTypeE")
    //</editor-fold>
    @Override public SemaDiagnosticBuilder diagnoseAmbiguous(final Sema /*&*/ S, SourceLocation Loc, 
                     QualType T)/* override*/ {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        return $c$.clean(new SemaDiagnosticBuilder($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc), diag.err_omp_ambiguous_conversion)), T)));
      } finally {
        $c$.$destroy();
      }
    }

    //<editor-fold defaultstate="collapsed" desc="clang::Sema::PerformOpenMPImplicitIntegerConversion(SourceLocation, Expr * )::IntConvertDiagnoser::noteAmbiguous">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 7365,
     FQN="clang::Sema::PerformOpenMPImplicitIntegerConversion(SourceLocation, Expr * )::IntConvertDiagnoser::noteAmbiguous", NM="_ZZN5clang4Sema38PerformOpenMPImplicitIntegerConversionENS_14SourceLocationEPNS_4ExprEEN19IntConvertDiagnoser13noteAmbiguousERS0_PNS_17CXXConversionDeclENS_8QualTypeE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZZN5clang4Sema38PerformOpenMPImplicitIntegerConversionENS_14SourceLocationEPNS_4ExprEEN19IntConvertDiagnoser13noteAmbiguousERS0_PNS_17CXXConversionDeclENS_8QualTypeE")
    //</editor-fold>
    @Override public SemaDiagnosticBuilder noteAmbiguous(final Sema /*&*/ S, CXXConversionDecl /*P*/ Conv, 
                 QualType ConvTy)/* override*/ {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        return $c$.clean(new SemaDiagnosticBuilder($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Conv.getLocation(), diag.note_omp_conversion_here)), 
                    ConvTy.$arrow().isEnumeralType()), ConvTy)));
      } finally {
        $c$.$destroy();
      }
    }

    //<editor-fold defaultstate="collapsed" desc="clang::Sema::PerformOpenMPImplicitIntegerConversion(SourceLocation, Expr * )::IntConvertDiagnoser::diagnoseConversion">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 7370,
     FQN="clang::Sema::PerformOpenMPImplicitIntegerConversion(SourceLocation, Expr * )::IntConvertDiagnoser::diagnoseConversion", NM="_ZZN5clang4Sema38PerformOpenMPImplicitIntegerConversionENS_14SourceLocationEPNS_4ExprEEN19IntConvertDiagnoser18diagnoseConversionERS0_S1_NS_8QualTypeES6_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZZN5clang4Sema38PerformOpenMPImplicitIntegerConversionENS_14SourceLocationEPNS_4ExprEEN19IntConvertDiagnoser18diagnoseConversionERS0_S1_NS_8QualTypeES6_")
    //</editor-fold>
    @Override public SemaDiagnosticBuilder diagnoseConversion(final Sema /*&*/ $Prm0, SourceLocation $Prm1, QualType $Prm2, 
                      QualType $Prm3)/* override*/ {
      throw new llvm_unreachable("conversion functions are permitted");
    }

    //<editor-fold defaultstate="collapsed" desc="clang::Sema::PerformOpenMPImplicitIntegerConversion(SourceLocation, Expr * )::IntConvertDiagnoser::~IntConvertDiagnoser">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 7339,
     FQN="clang::Sema::PerformOpenMPImplicitIntegerConversion(SourceLocation, Expr * )::IntConvertDiagnoser::~IntConvertDiagnoser", NM="_ZZN5clang4Sema38PerformOpenMPImplicitIntegerConversionENS_14SourceLocationEPNS_4ExprEEN19IntConvertDiagnoserD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZZN5clang4Sema38PerformOpenMPImplicitIntegerConversionENS_14SourceLocationEPNS_4ExprEEN19IntConvertDiagnoserD0Ev")
    //</editor-fold>
    @Override public /*inline*/ void $destroy() {
      super.$destroy();
    }


    @Override public String toString() {
      return "" + super.toString(); // NOI18N
    }
  }
  IntConvertDiagnoser ConvertDiagnoser = null;
  try {
    if (!(Op != null)) {
      return ExprError();
    }
    
    ConvertDiagnoser/*J*/= new  IntConvertDiagnoser();
    return $this().PerformContextualImplicitConversion(new SourceLocation(Loc), Op, ConvertDiagnoser);
  } finally {
    if (ConvertDiagnoser != null) { ConvertDiagnoser.$destroy(); }
  }
}

/// \brief Called on start of new data sharing attribute block.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::StartOpenMPDSABlock">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 1044,
 FQN="clang::Sema::StartOpenMPDSABlock", NM="_ZN5clang4Sema19StartOpenMPDSABlockENS_19OpenMPDirectiveKindERKNS_19DeclarationNameInfoEPNS_5ScopeENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4Sema19StartOpenMPDSABlockENS_19OpenMPDirectiveKindERKNS_19DeclarationNameInfoEPNS_5ScopeENS_14SourceLocationE")
//</editor-fold>
public final void StartOpenMPDSABlock(OpenMPDirectiveKind DKind, 
                   final /*const*/ DeclarationNameInfo /*&*/ DirName, 
                   Scope /*P*/ CurScope, SourceLocation Loc) {
  ((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).push(DKind, DirName, CurScope, new SourceLocation(Loc));
  $this().PushExpressionEvaluationContext(ExpressionEvaluationContext.PotentiallyEvaluated);
}

/// \brief Start analysis of clauses.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::StartOpenMPClause">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 1051,
 FQN="clang::Sema::StartOpenMPClause", NM="_ZN5clang4Sema17StartOpenMPClauseENS_16OpenMPClauseKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4Sema17StartOpenMPClauseENS_16OpenMPClauseKindE")
//</editor-fold>
public final void StartOpenMPClause(OpenMPClauseKind K) {
  ((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).setClauseParsingMode(K);
}

/// \brief End analysis of clauses.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::EndOpenMPClause">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 1055,
 FQN="clang::Sema::EndOpenMPClause", NM="_ZN5clang4Sema15EndOpenMPClauseEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4Sema15EndOpenMPClauseEv")
//</editor-fold>
public final void EndOpenMPClause() {
  ((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).setClauseParsingMode(/*K=*/ OpenMPClauseKind.OMPC_unknown);
}

/// \brief Called on end of data sharing attribute block.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::EndOpenMPDSABlock">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 1059,
 FQN="clang::Sema::EndOpenMPDSABlock", NM="_ZN5clang4Sema17EndOpenMPDSABlockEPNS_4StmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4Sema17EndOpenMPDSABlockEPNS_4StmtE")
//</editor-fold>
public final void EndOpenMPDSABlock(Stmt /*P*/ CurDirective) {
  {
    // OpenMP [2.14.3.5, Restrictions, C/C++, p.1]
    //  A variable of class type (or array thereof) that appears in a lastprivate
    //  clause requires an accessible, unambiguous default constructor for the
    //  class type, unless the list item is also specified in a firstprivate
    //  clause.
    OMPExecutableDirective /*P*/ D = dyn_cast_or_null_OMPExecutableDirective(CurDirective);
    if ((D != null)) {
      for (OMPClause /*P*/ C : D.clauses()) {
        {
          OMPLastprivateClause /*P*/ Clause = dyn_cast_OMPLastprivateClause(C);
          if ((Clause != null)) {
            SmallVector<Expr /*P*/ > PrivateCopies/*J*/= new SmallVector<Expr /*P*/ >(8, (Expr /*P*/ )null);
            for (Expr /*P*/ DE : Clause.varlists()) {
              if (DE.isValueDependent() || DE.isTypeDependent()) {
                PrivateCopies.push_back((Expr /*P*/ /*const*/)null);
                continue;
              }
              DeclRefExpr /*P*/ DRE = cast_DeclRefExpr(DE.IgnoreParens());
              VarDecl /*P*/ VD = cast_VarDecl(DRE.getDecl());
              QualType Type = VD.getType().getNonReferenceType();
              DSAVarData DVar = ((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).getTopDSA(VD, false);
              if (DVar.CKind == OpenMPClauseKind.OMPC_lastprivate) {
                // Generate helper private variable and initialize it with the
                // default value. The address of the original variable is replaced
                // by the address of the new private variable in CodeGen. This new
                // variable is not added to IdResolver, so the code in the OpenMP
                // region uses original variable for proper diagnostics.
                VarDecl /*P*/ VDPrivate = buildVarDecl(/*Deref*/$this(), DE.getExprLoc(), Type.getUnqualifiedType(), 
                    VD.getName(), VD.hasAttrs() ? $AddrOf(VD.getAttrs()) : (SmallVector<Attr /*P*/>/*P*/ )null);
                $this().ActOnUninitializedDecl(VDPrivate, /*TypeMayContainAuto=*/ false);
                if (VDPrivate.isInvalidDecl()) {
                  continue;
                }
                PrivateCopies.push_back(buildDeclRefExpr(/*Deref*/$this(), VDPrivate, DE.getType(), DE.getExprLoc()));
              } else {
                // The variable is also a firstprivate, so initialization sequence
                // for private copy is generated already.
                PrivateCopies.push_back((Expr /*P*/ /*const*/)null);
              }
            }
            // Set initializers to private copies if no errors were found.
            if (PrivateCopies.size() == Clause.varlist_size()) {
              Clause.setPrivateCopies(new ArrayRef<Expr /*P*/ >(PrivateCopies, true));
            }
          }
        }
      }
    }
  }
  ((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).pop();
  $this().DiscardCleanupsInEvaluationContext();
  $this().PopExpressionEvaluationContext();
}


/// \brief Check if the current region is an OpenMP loop region and if it is,
/// mark loop control variable, used in \p Init for loop initialization, as
/// private by default.
/// \param Init First part of the for loop.
// namespace
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnOpenMPLoopInitialization">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 4581,
 FQN="clang::Sema::ActOnOpenMPLoopInitialization", NM="_ZN5clang4Sema29ActOnOpenMPLoopInitializationENS_14SourceLocationEPNS_4StmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4Sema29ActOnOpenMPLoopInitializationENS_14SourceLocationEPNS_4StmtE")
//</editor-fold>
public final void ActOnOpenMPLoopInitialization(SourceLocation ForLoc, Stmt /*P*/ Init) {
  assert (($this().getLangOpts().OpenMP != 0)) : "OpenMP is not active.";
  assert ((Init != null)) : "Expected loop in canonical form.";
  /*uint*/int AssociatedLoops = ((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).getAssociatedLoops();
  if ($greater_uint(AssociatedLoops, 0)
     && isOpenMPLoopDirective(((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).getCurrentDirective())) {
    OpenMPIterationSpaceChecker ISC/*J*/= new OpenMPIterationSpaceChecker(/*Deref*/$this(), new SourceLocation(ForLoc));
    if (!ISC.CheckInit(Init, /*EmitDiags=*/ false)) {
      {
        ValueDecl /*P*/ D = ISC.GetLoopDecl();
        if ((D != null)) {
          VarDecl /*P*/ VD = dyn_cast_VarDecl(D);
          if (!(VD != null)) {
            {
              VarDecl /*P*/ Private = $this().IsOpenMPCapturedDecl(D);
              if ((Private != null)) {
                VD = Private;
              } else {
                DeclRefExpr /*P*/ Ref = buildCapture(/*Deref*/$this(), D, ISC.GetLoopDeclRefExpr(), 
                    /*WithInit=*/ false);
                VD = cast_VarDecl(Ref.getDecl());
              }
            }
          }
          ((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).addLoopControlVariable(D, VD);
        }
      }
    }
    ((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).setAssociatedLoops(AssociatedLoops - 1);
  }
}


// OpenMP directives and clauses.
/// \brief Called on correct id-expression from the '#pragma omp
/// threadprivate'.
// namespace
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnOpenMPIdExpression">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 1151,
 FQN="clang::Sema::ActOnOpenMPIdExpression", NM="_ZN5clang4Sema23ActOnOpenMPIdExpressionEPNS_5ScopeERNS_12CXXScopeSpecERKNS_19DeclarationNameInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4Sema23ActOnOpenMPIdExpressionEPNS_5ScopeERNS_12CXXScopeSpecERKNS_19DeclarationNameInfoE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > ActOnOpenMPIdExpression(Scope /*P*/ CurScope, 
                       final CXXScopeSpec /*&*/ ScopeSpec, 
                       final /*const*/ DeclarationNameInfo /*&*/ Id) {
  LookupResult Lookup = null;
  try {
    Lookup/*J*/= new LookupResult(/*Deref*/$this(), Id, LookupNameKind.LookupOrdinaryName);
    $this().LookupParsedName(Lookup, CurScope, $AddrOf(ScopeSpec), true);
    if (Lookup.isAmbiguous()) {
      return ExprError();
    }
    
    VarDecl /*P*/ VD;
    if (!Lookup.isSingleResult()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        {
          TypoCorrection Corrected = null;
          try {
            Corrected = $c$.clean($this().CorrectTypo(Id, LookupNameKind.LookupOrdinaryName, CurScope, (CXXScopeSpec /*P*/ )null, 
                $c$.track(new std.unique_ptr<CorrectionCandidateCallback>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(llvm.make_unique(new VarDeclFilterCCC(/*Deref*/$this()))))), CorrectTypoKind.CTK_ErrorRecovery));
            if (Corrected.$bool()) {
              $this().diagnoseTypo(Corrected, 
                  $out_PartialDiagnostic$C_DeclarationName($c$.track($this().PDiag(Lookup.empty() ? diag.err_undeclared_var_use_suggest : diag.err_omp_expected_var_arg_suggest)), 
                      Id.getName())); $c$.clean();
              VD = Corrected.getCorrectionDeclAs(VarDecl.class);
            } else {
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Id.getLoc(), Lookup.empty() ? diag.err_undeclared_var_use : diag.err_omp_expected_var_arg)), 
                  Id.getName()));
              return ExprError();
            }
          } finally {
            if (Corrected != null) { Corrected.$destroy(); }
          }
        }
      } finally {
        $c$.$destroy();
      }
    } else {
      if (!((VD = Lookup.<VarDecl>getAsSingle(VarDecl.class)) != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Id.getLoc(), diag.err_omp_expected_var_arg)), Id.getName()));
          $c$.clean($c$.track($this().Diag(Lookup.getFoundDecl().getLocation(), diag.note_declared_at)));
          return ExprError();
        } finally {
          $c$.$destroy();
        }
      }
    }
    Lookup.suppressDiagnostics();
    
    // OpenMP [2.9.2, Syntax, C/C++]
    //   Variables must be file-scope, namespace-scope, or static block-scope.
    if (!VD.hasGlobalStorage()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Id.getLoc(), diag.err_omp_global_var_arg)), 
                getOpenMPDirectiveName(OpenMPDirectiveKind.OMPD_threadprivate)), !VD.isStaticLocal()));
        boolean IsDecl = VD.isThisDeclarationADefinition($this().Context) == VarDecl.DefinitionKind.DeclarationOnly;
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(VD.getLocation(), 
                IsDecl ? diag.note_previous_decl : diag.note_defined_here)), 
            VD));
        return ExprError();
      } finally {
        $c$.$destroy();
      }
    }
    
    VarDecl /*P*/ CanonicalVD = VD.getCanonicalDecl();
    NamedDecl /*P*/ ND = cast_NamedDecl(CanonicalVD);
    // OpenMP [2.9.2, Restrictions, C/C++, p.2]
    //   A threadprivate directive for file-scope variables must appear outside
    //   any definition or declaration.
    if (CanonicalVD.getDeclContext().isTranslationUnit()
       && !$this().getCurLexicalContext().isTranslationUnit()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Id.getLoc(), diag.err_omp_var_scope)), 
                getOpenMPDirectiveName(OpenMPDirectiveKind.OMPD_threadprivate)), VD));
        boolean IsDecl = VD.isThisDeclarationADefinition($this().Context) == VarDecl.DefinitionKind.DeclarationOnly;
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(VD.getLocation(), 
                IsDecl ? diag.note_previous_decl : diag.note_defined_here)), 
            VD));
        return ExprError();
      } finally {
        $c$.$destroy();
      }
    }
    // OpenMP [2.9.2, Restrictions, C/C++, p.3]
    //   A threadprivate directive for static class member variables must appear
    //   in the class definition, in the same scope in which the member
    //   variables are declared.
    if (CanonicalVD.isStaticDataMember()
       && !CanonicalVD.getDeclContext().Equals($this().getCurLexicalContext())) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Id.getLoc(), diag.err_omp_var_scope)), 
                getOpenMPDirectiveName(OpenMPDirectiveKind.OMPD_threadprivate)), VD));
        boolean IsDecl = VD.isThisDeclarationADefinition($this().Context) == VarDecl.DefinitionKind.DeclarationOnly;
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(VD.getLocation(), 
                IsDecl ? diag.note_previous_decl : diag.note_defined_here)), 
            VD));
        return ExprError();
      } finally {
        $c$.$destroy();
      }
    }
    // OpenMP [2.9.2, Restrictions, C/C++, p.4]
    //   A threadprivate directive for namespace-scope variables must appear
    //   outside any definition or declaration other than the namespace
    //   definition itself.
    if (CanonicalVD.getDeclContext().isNamespace()
       && (!$this().getCurLexicalContext().isFileContext()
       || !$this().getCurLexicalContext().Encloses(CanonicalVD.getDeclContext()))) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Id.getLoc(), diag.err_omp_var_scope)), 
                getOpenMPDirectiveName(OpenMPDirectiveKind.OMPD_threadprivate)), VD));
        boolean IsDecl = VD.isThisDeclarationADefinition($this().Context) == VarDecl.DefinitionKind.DeclarationOnly;
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(VD.getLocation(), 
                IsDecl ? diag.note_previous_decl : diag.note_defined_here)), 
            VD));
        return ExprError();
      } finally {
        $c$.$destroy();
      }
    }
    // OpenMP [2.9.2, Restrictions, C/C++, p.6]
    //   A threadprivate directive for static block-scope variables must appear
    //   in the scope of the variable and not in a nested scope.
    if (CanonicalVD.isStaticLocal() && (CurScope != null)
       && !$this().isDeclInScope(ND, $this().getCurLexicalContext(), CurScope)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Id.getLoc(), diag.err_omp_var_scope)), 
                getOpenMPDirectiveName(OpenMPDirectiveKind.OMPD_threadprivate)), VD));
        boolean IsDecl = VD.isThisDeclarationADefinition($this().Context) == VarDecl.DefinitionKind.DeclarationOnly;
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(VD.getLocation(), 
                IsDecl ? diag.note_previous_decl : diag.note_defined_here)), 
            VD));
        return ExprError();
      } finally {
        $c$.$destroy();
      }
    }
    
    // OpenMP [2.9.2, Restrictions, C/C++, p.2-6]
    //   A threadprivate directive must lexically precede all references to any
    //   of the variables in its list.
    if (VD.isUsed() && !((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).isThreadPrivate(VD)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Id.getLoc(), diag.err_omp_var_used)), 
                getOpenMPDirectiveName(OpenMPDirectiveKind.OMPD_threadprivate)), VD));
        return ExprError();
      } finally {
        $c$.$destroy();
      }
    }
    
    QualType ExprType = VD.getType().getNonReferenceType();
    return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, DeclRefExpr.Create($this().Context, new NestedNameSpecifierLoc(), 
            new SourceLocation(), VD, 
            /*RefersToEnclosingVariableOrCapture=*/ false, 
            Id.getLoc(), new QualType(ExprType), ExprValueKind.VK_LValue));
  } finally {
    if (Lookup != null) { Lookup.$destroy(); }
  }
}

/// \brief Called on well-formed '#pragma omp threadprivate'.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnOpenMPThreadprivateDirective">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 1277,
 FQN="clang::Sema::ActOnOpenMPThreadprivateDirective", NM="_ZN5clang4Sema33ActOnOpenMPThreadprivateDirectiveENS_14SourceLocationEN4llvm8ArrayRefIPNS_4ExprEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4Sema33ActOnOpenMPThreadprivateDirectiveENS_14SourceLocationEN4llvm8ArrayRefIPNS_4ExprEEE")
//</editor-fold>
public final OpaquePtr<DeclGroupRef> ActOnOpenMPThreadprivateDirective(SourceLocation Loc, 
                                 ArrayRef<Expr /*P*/ > VarList) {
  {
    OMPThreadPrivateDecl /*P*/ D = $this().CheckOMPThreadPrivateDecl(new SourceLocation(Loc), new ArrayRef<Expr /*P*/ >(VarList));
    if ((D != null)) {
      $this().CurContext.addDecl(D);
      return OpaquePtr.<DeclGroupRef>make(new DeclGroupRef(D));
    }
  }
  return new OpaquePtr<DeclGroupRef>(null);
}

/// \brief Builds a new OpenMPThreadPrivateDecl and checks its correctness.
// namespace
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckOMPThreadPrivateDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 1316,
 FQN="clang::Sema::CheckOMPThreadPrivateDecl", NM="_ZN5clang4Sema25CheckOMPThreadPrivateDeclENS_14SourceLocationEN4llvm8ArrayRefIPNS_4ExprEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4Sema25CheckOMPThreadPrivateDeclENS_14SourceLocationEN4llvm8ArrayRefIPNS_4ExprEEE")
//</editor-fold>
public final OMPThreadPrivateDecl /*P*/ CheckOMPThreadPrivateDecl(SourceLocation Loc, ArrayRef<Expr /*P*/ > VarList) {
  SmallVector<Expr /*P*/ > Vars/*J*/= new SmallVector<Expr /*P*/ >(8, (Expr /*P*/ )null);
  for (final Expr /*P*/ /*const*/ /*&*/ RefExpr : VarList) {
    DeclRefExpr /*P*/ DE = cast_DeclRefExpr(RefExpr);
    VarDecl /*P*/ VD = cast_VarDecl(DE.getDecl());
    SourceLocation ILoc = DE.getExprLoc();
    
    // Mark variable as used.
    VD.setReferenced();
    VD.markUsed($this().Context);
    
    QualType QType = VD.getType();
    if (QType.$arrow().isDependentType() || QType.$arrow().isInstantiationDependentType()) {
      // It will be analyzed later.
      Vars.push_back(DE);
      continue;
    }
    
    // OpenMP [2.9.2, Restrictions, C/C++, p.10]
    //   A threadprivate variable must not have an incomplete type.
    if ($this().RequireCompleteType(new SourceLocation(ILoc), VD.getType(), 
        diag.err_omp_threadprivate_incomplete_type)) {
      continue;
    }
    
    // OpenMP [2.9.2, Restrictions, C/C++, p.10]
    //   A threadprivate variable must not have a reference type.
    if (VD.getType().$arrow().isReferenceType()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(ILoc), diag.err_omp_ref_type_arg)), 
                getOpenMPDirectiveName(OpenMPDirectiveKind.OMPD_threadprivate)), VD.getType()));
        boolean IsDecl = VD.isThisDeclarationADefinition($this().Context) == VarDecl.DefinitionKind.DeclarationOnly;
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(VD.getLocation(), 
                IsDecl ? diag.note_previous_decl : diag.note_defined_here)), 
            VD));
        continue;
      } finally {
        $c$.$destroy();
      }
    }
    
    // Check if this is a TLS variable. If TLS is not being supported, produce
    // the corresponding diagnostic.
    if ((VD.getTLSKind() != VarDecl.TLSKind.TLS_None
       && !(VD.hasAttr(OMPThreadPrivateDeclAttr.class)
       && $this().getLangOpts().OpenMPUseTLS
       && $this().getASTContext().getTargetInfo().isTLSSupported()))
       || (VD.getStorageClass() == StorageClass.SC_Register && VD.hasAttr(AsmLabelAttr.class)
       && !VD.isLocalVarDecl())) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(ILoc), diag.err_omp_var_thread_local)), 
                VD), ((VD.getTLSKind() != VarDecl.TLSKind.TLS_None) ? 0 : 1)));
        boolean IsDecl = VD.isThisDeclarationADefinition($this().Context) == VarDecl.DefinitionKind.DeclarationOnly;
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(VD.getLocation(), 
                IsDecl ? diag.note_previous_decl : diag.note_defined_here)), 
            VD));
        continue;
      } finally {
        $c$.$destroy();
      }
    }
    {
      
      // Check if initial value of threadprivate variable reference variable with
      // local storage (it is not supported by runtime).
      /*const*/ Expr /*P*/ Init = VD.getAnyInitializer();
      if ((Init != null)) {
        LocalVarRefChecker Checker/*J*/= new LocalVarRefChecker(/*Deref*/$this());
        if (Checker.Visit(Init)) {
          continue;
        }
      }
    }
    
    Vars.push_back(RefExpr);
    ((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).addDSA(VD, DE, OpenMPClauseKind.OMPC_threadprivate);
    VD.addAttr(OMPThreadPrivateDeclAttr.CreateImplicit($this().Context, new SourceRange(/*NO_COPY*/Loc, /*NO_COPY*/Loc)));
    {
      ASTMutationListener /*P*/ ML = $this().Context.getASTMutationListener();
      if ((ML != null)) {
        ML.DeclarationMarkedOpenMPThreadPrivate(VD);
      }
    }
  }
  OMPThreadPrivateDecl /*P*/ D = null;
  if (!Vars.empty()) {
    D = OMPThreadPrivateDecl.Create($this().Context, $this().getCurLexicalContext(), new SourceLocation(Loc), 
        new ArrayRef<Expr /*P*/ >(Vars, true));
    D.setAccess(AccessSpecifier.AS_public);
  }
  return D;
}

/// \brief Check if the specified type is allowed to be used in 'omp declare
/// reduction' construct.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnOpenMPDeclareReductionType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 11021,
 FQN="clang::Sema::ActOnOpenMPDeclareReductionType", NM="_ZN5clang4Sema31ActOnOpenMPDeclareReductionTypeENS_14SourceLocationENS_12ActionResultINS_9OpaquePtrINS_8QualTypeEEELb0EEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4Sema31ActOnOpenMPDeclareReductionTypeENS_14SourceLocationENS_12ActionResultINS_9OpaquePtrINS_8QualTypeEEELb0EEE")
//</editor-fold>
public final QualType ActOnOpenMPDeclareReductionType(SourceLocation TyLoc, 
                               ActionResult<OpaquePtr<QualType> > ParsedType) {
  assert (ParsedType.isUsable());
  
  QualType ReductionType = GetTypeFromParser(ParsedType.get());
  if (ReductionType.isNull()) {
    return new QualType();
  }
  
  // [OpenMP 4.0], 2.15 declare reduction Directive, Restrictions, C\C++
  // A type name in a declare reduction directive cannot be a function type, an
  // array type, a reference type, or a type qualified with const, volatile or
  // restrict.
  if (ReductionType.hasQualifiers()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(TyLoc), diag.err_omp_reduction_wrong_type)), 0));
      return new QualType();
    } finally {
      $c$.$destroy();
    }
  }
  if (ReductionType.$arrow().isFunctionType()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(TyLoc), diag.err_omp_reduction_wrong_type)), 1));
      return new QualType();
    } finally {
      $c$.$destroy();
    }
  }
  if (ReductionType.$arrow().isReferenceType()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(TyLoc), diag.err_omp_reduction_wrong_type)), 2));
      return new QualType();
    } finally {
      $c$.$destroy();
    }
  }
  if (ReductionType.$arrow().isArrayType()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(TyLoc), diag.err_omp_reduction_wrong_type)), 3));
      return new QualType();
    } finally {
      $c$.$destroy();
    }
  }
  return ReductionType;
}

/// \brief Called on start of '#pragma omp declare reduction'.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnOpenMPDeclareReductionDirectiveStart">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 11053,
 FQN="clang::Sema::ActOnOpenMPDeclareReductionDirectiveStart", NM="_ZN5clang4Sema41ActOnOpenMPDeclareReductionDirectiveStartEPNS_5ScopeEPNS_11DeclContextENS_15DeclarationNameEN4llvm8ArrayRefISt4pairINS_8QualTypeENS_14SourceLocationEEEENS_15AccessSpecifierEPNS_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4Sema41ActOnOpenMPDeclareReductionDirectiveStartEPNS_5ScopeEPNS_11DeclContextENS_15DeclarationNameEN4llvm8ArrayRefISt4pairINS_8QualTypeENS_14SourceLocationEEEENS_15AccessSpecifierEPNS_4DeclE")
//</editor-fold>
public final OpaquePtr<DeclGroupRef> ActOnOpenMPDeclareReductionDirectiveStart(Scope /*P*/ S, DeclContext /*P*/ DC, DeclarationName Name, 
                                         ArrayRef<std.pair<QualType, SourceLocation>> ReductionTypes, 
                                         AccessSpecifier AS) {
  return ActOnOpenMPDeclareReductionDirectiveStart(S, DC, Name, 
                                         ReductionTypes, 
                                         AS, (Decl /*P*/ )null);
}
public final OpaquePtr<DeclGroupRef> ActOnOpenMPDeclareReductionDirectiveStart(Scope /*P*/ S, DeclContext /*P*/ DC, DeclarationName Name, 
                                         ArrayRef<std.pair<QualType, SourceLocation>> ReductionTypes, 
                                         AccessSpecifier AS, Decl /*P*/ PrevDeclInScope/*= null*/) {
  LookupResult Lookup = null;
  try {
    SmallVector<Decl /*P*/> Decls/*J*/= new SmallVector<Decl /*P*/>(8, null);
    Decls.reserve(ReductionTypes.size());
    
    Lookup/*J*/= new LookupResult(/*Deref*/$this(), new DeclarationName(Name), new SourceLocation(), LookupNameKind.LookupOMPReductionName, 
        RedeclarationKind.ForRedeclaration);
    // [OpenMP 4.0], 2.15 declare reduction Directive, Restrictions
    // A reduction-identifier may not be re-declared in the current scope for the
    // same type or for a type that is compatible according to the base language
    // rules.
    DenseMap<QualType, SourceLocation> PreviousRedeclTypes/*J*/= new DenseMap<QualType, SourceLocation>(DenseMapInfoQualType.$Info(), new SourceLocation());
    OMPDeclareReductionDecl /*P*/ PrevDRD = null;
    boolean InCompoundScope = true;
    if (S != null) {
      Filter $Filter = null;
      try {
        // Find previous declaration with the same name not referenced in other
        // declarations.
        FunctionScopeInfo /*P*/ ParentFn = $this().getEnclosingFunction();
        InCompoundScope
           = (ParentFn != null) && !ParentFn.CompoundScopes.empty();
        $this().LookupName(Lookup, S);
        $this().FilterLookupForScope(Lookup, DC, S, /*ConsiderLinkage=*/ false, 
            /*AllowInlineNamespace=*/ false);
        DenseMapTypeBool<OMPDeclareReductionDecl /*P*/ > UsedAsPrevious/*J*/= new DenseMapTypeBool<OMPDeclareReductionDecl /*P*/ >(DenseMapInfo$LikePtr.$Info(), false);
        $Filter = Lookup.makeFilter();
        while ($Filter.hasNext()) {
          OMPDeclareReductionDecl /*P*/ PrevDecl = cast_OMPDeclareReductionDecl($Filter.next());
          if (InCompoundScope) {
            DenseMapIteratorTypeBool<OMPDeclareReductionDecl /*P*/ /*P*/> I = UsedAsPrevious.find(PrevDecl);
            if (I.$eq(/*NO_ITER_COPY*/UsedAsPrevious.end())) {
              UsedAsPrevious.$set(PrevDecl, false);
            }
            {
              OMPDeclareReductionDecl /*P*/ D = PrevDecl.getPrevDeclInScope();
              if ((D != null)) {
                UsedAsPrevious.$set(D, true);
              }
            }
          }
          PreviousRedeclTypes.$at_T1$RR(PrevDecl.getType().getCanonicalType()).$assignMove(
              PrevDecl.getLocation()
          );
        }
        $Filter.done();
        if (InCompoundScope) {
          for (std.pairTypeBool<OMPDeclareReductionDecl> /*&*/ PrevData : UsedAsPrevious) {
            if (!PrevData.second) {
              PrevDRD = PrevData.first;
              break;
            }
          }
        }
      } finally {
        if ($Filter != null) { $Filter.$destroy(); }
      }
    } else if (PrevDeclInScope != null) {
      OMPDeclareReductionDecl /*P*/ PrevDRDInScope = PrevDRD
         = cast_OMPDeclareReductionDecl(PrevDeclInScope);
      do {
        PreviousRedeclTypes.$at_T1$RR(PrevDRDInScope.getType().getCanonicalType()).$assignMove(
            PrevDRDInScope.getLocation()
        );
        PrevDRDInScope = PrevDRDInScope.getPrevDeclInScope();
      } while (PrevDRDInScope != null);
    }
    for (final /*const*/ pair<QualType, SourceLocation> /*&*/ TyData : ReductionTypes) {
      DenseMapIterator<QualType, SourceLocation> I = PreviousRedeclTypes.find(TyData.first.getCanonicalType());
      boolean Invalid = false;
      if (I.$noteq(/*NO_ITER_COPY*/PreviousRedeclTypes.end())) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(TyData.second), diag.err_omp_declare_reduction_redefinition)), 
              TyData.first));
          $c$.clean($c$.track($this().Diag(new SourceLocation(I.$arrow().second), diag.note_previous_definition)));
          Invalid = true;
        } finally {
          $c$.$destroy();
        }
      }
      PreviousRedeclTypes.$at_T1$RR(TyData.first.getCanonicalType()).$assign(TyData.second);
      OMPDeclareReductionDecl /*P*/ DRD = OMPDeclareReductionDecl.Create($this().Context, DC, new SourceLocation(TyData.second), 
          new DeclarationName(Name), new QualType(TyData.first), PrevDRD);
      DC.addDecl(DRD);
      DRD.setAccess(AS);
      Decls.push_back(DRD);
      if (Invalid) {
        DRD.setInvalidDecl();
      } else {
        PrevDRD = DRD;
      }
    }
    
    return OpaquePtr.<DeclGroupRef>make(DeclGroupRef.Create($this().Context, Decls.begin(), Decls.size()));
  } finally {
    if (Lookup != null) { Lookup.$destroy(); }
  }
}

/// \brief Initialize declare reduction construct initializer.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnOpenMPDeclareReductionCombinerStart">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 11135,
 FQN="clang::Sema::ActOnOpenMPDeclareReductionCombinerStart", NM="_ZN5clang4Sema40ActOnOpenMPDeclareReductionCombinerStartEPNS_5ScopeEPNS_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4Sema40ActOnOpenMPDeclareReductionCombinerStartEPNS_5ScopeEPNS_4DeclE")
//</editor-fold>
public final void ActOnOpenMPDeclareReductionCombinerStart(Scope /*P*/ S, Decl /*P*/ D) {
  OMPDeclareReductionDecl /*P*/ DRD = cast_OMPDeclareReductionDecl(D);
  
  // Enter new function scope.
  $this().PushFunctionScope();
  $this().getCurFunction().setHasBranchProtectedScope();
  $this().getCurFunction().setHasOMPDeclareReductionCombiner();
  if (S != null) {
    $this().PushDeclContext(S, DRD);
  } else {
    $this().CurContext = DRD;
  }
  
  $this().PushExpressionEvaluationContext(ExpressionEvaluationContext.PotentiallyEvaluated);
  
  QualType ReductionType = DRD.getType();
  // Create 'T* omp_parm;T omp_in;'. All references to 'omp_in' will
  // be replaced by '*omp_parm' during codegen. This required because 'omp_in'
  // uses semantics of argument handles by value, but it should be passed by
  // reference. C lang does not support references, so pass all parameters as
  // pointers.
  // Create 'T omp_in;' variable.
  VarDecl /*P*/ OmpInParm = buildVarDecl(/*Deref*/$this(), D.getLocation(), new QualType(ReductionType), new StringRef(/*KEEP_STR*/"omp_in"));
  // Create 'T* omp_parm;T omp_out;'. All references to 'omp_out' will
  // be replaced by '*omp_parm' during codegen. This required because 'omp_out'
  // uses semantics of argument handles by value, but it should be passed by
  // reference. C lang does not support references, so pass all parameters as
  // pointers.
  // Create 'T omp_out;' variable.
  VarDecl /*P*/ OmpOutParm = buildVarDecl(/*Deref*/$this(), D.getLocation(), new QualType(ReductionType), new StringRef(/*KEEP_STR*/"omp_out"));
  if (S != null) {
    $this().PushOnScopeChains(OmpInParm, S);
    $this().PushOnScopeChains(OmpOutParm, S);
  } else {
    DRD.addDecl(OmpInParm);
    DRD.addDecl(OmpOutParm);
  }
}

/// \brief Finish current declare reduction construct initializer.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnOpenMPDeclareReductionCombinerEnd">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 11176,
 FQN="clang::Sema::ActOnOpenMPDeclareReductionCombinerEnd", NM="_ZN5clang4Sema38ActOnOpenMPDeclareReductionCombinerEndEPNS_4DeclEPNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4Sema38ActOnOpenMPDeclareReductionCombinerEndEPNS_4DeclEPNS_4ExprE")
//</editor-fold>
public final void ActOnOpenMPDeclareReductionCombinerEnd(Decl /*P*/ D, Expr /*P*/ Combiner) {
  OMPDeclareReductionDecl /*P*/ DRD = cast_OMPDeclareReductionDecl(D);
  $this().DiscardCleanupsInEvaluationContext();
  $this().PopExpressionEvaluationContext();
  
  $this().PopDeclContext();
  $this().PopFunctionScopeInfo();
  if (Combiner != null) {
    DRD.setCombiner(Combiner);
  } else {
    DRD.setInvalidDecl();
  }
}

/// \brief Initialize declare reduction construct initializer.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnOpenMPDeclareReductionInitializerStart">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 11190,
 FQN="clang::Sema::ActOnOpenMPDeclareReductionInitializerStart", NM="_ZN5clang4Sema43ActOnOpenMPDeclareReductionInitializerStartEPNS_5ScopeEPNS_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4Sema43ActOnOpenMPDeclareReductionInitializerStartEPNS_5ScopeEPNS_4DeclE")
//</editor-fold>
public final void ActOnOpenMPDeclareReductionInitializerStart(Scope /*P*/ S, Decl /*P*/ D) {
  OMPDeclareReductionDecl /*P*/ DRD = cast_OMPDeclareReductionDecl(D);
  
  // Enter new function scope.
  $this().PushFunctionScope();
  $this().getCurFunction().setHasBranchProtectedScope();
  if (S != null) {
    $this().PushDeclContext(S, DRD);
  } else {
    $this().CurContext = DRD;
  }
  
  $this().PushExpressionEvaluationContext(ExpressionEvaluationContext.PotentiallyEvaluated);
  
  QualType ReductionType = DRD.getType();
  // Create 'T* omp_parm;T omp_priv;'. All references to 'omp_priv' will
  // be replaced by '*omp_parm' during codegen. This required because 'omp_priv'
  // uses semantics of argument handles by value, but it should be passed by
  // reference. C lang does not support references, so pass all parameters as
  // pointers.
  // Create 'T omp_priv;' variable.
  VarDecl /*P*/ OmpPrivParm = buildVarDecl(/*Deref*/$this(), D.getLocation(), new QualType(ReductionType), new StringRef(/*KEEP_STR*/"omp_priv"));
  // Create 'T* omp_parm;T omp_orig;'. All references to 'omp_orig' will
  // be replaced by '*omp_parm' during codegen. This required because 'omp_orig'
  // uses semantics of argument handles by value, but it should be passed by
  // reference. C lang does not support references, so pass all parameters as
  // pointers.
  // Create 'T omp_orig;' variable.
  VarDecl /*P*/ OmpOrigParm = buildVarDecl(/*Deref*/$this(), D.getLocation(), new QualType(ReductionType), new StringRef(/*KEEP_STR*/"omp_orig"));
  if (S != null) {
    $this().PushOnScopeChains(OmpPrivParm, S);
    $this().PushOnScopeChains(OmpOrigParm, S);
  } else {
    DRD.addDecl(OmpPrivParm);
    DRD.addDecl(OmpOrigParm);
  }
}

/// \brief Finish current declare reduction construct initializer.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnOpenMPDeclareReductionInitializerEnd">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 11230,
 FQN="clang::Sema::ActOnOpenMPDeclareReductionInitializerEnd", NM="_ZN5clang4Sema41ActOnOpenMPDeclareReductionInitializerEndEPNS_4DeclEPNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4Sema41ActOnOpenMPDeclareReductionInitializerEndEPNS_4DeclEPNS_4ExprE")
//</editor-fold>
public final void ActOnOpenMPDeclareReductionInitializerEnd(Decl /*P*/ D, 
                                         Expr /*P*/ Initializer) {
  OMPDeclareReductionDecl /*P*/ DRD = cast_OMPDeclareReductionDecl(D);
  $this().DiscardCleanupsInEvaluationContext();
  $this().PopExpressionEvaluationContext();
  
  $this().PopDeclContext();
  $this().PopFunctionScopeInfo();
  if (Initializer != null) {
    DRD.setInitializer(Initializer);
  } else {
    DRD.setInvalidDecl();
  }
}

/// \brief Called at the end of '#pragma omp declare reduction'.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnOpenMPDeclareReductionDirectiveEnd">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 11245,
 FQN="clang::Sema::ActOnOpenMPDeclareReductionDirectiveEnd", NM="_ZN5clang4Sema39ActOnOpenMPDeclareReductionDirectiveEndEPNS_5ScopeENS_9OpaquePtrINS_12DeclGroupRefEEEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4Sema39ActOnOpenMPDeclareReductionDirectiveEndEPNS_5ScopeENS_9OpaquePtrINS_12DeclGroupRefEEEb")
//</editor-fold>
public final OpaquePtr<DeclGroupRef> ActOnOpenMPDeclareReductionDirectiveEnd(Scope /*P*/ S, OpaquePtr<DeclGroupRef> DeclReductions, boolean IsValid) {
  for (Decl /*P*/ D : DeclReductions.getDeclGroupRef()) {
    if (IsValid) {
      OMPDeclareReductionDecl /*P*/ DRD = cast_OMPDeclareReductionDecl(D);
      if (S != null) {
        $this().PushOnScopeChains(DRD, S, /*AddToContext=*/ false);
      }
    } else {
      D.setInvalidDecl();
    }
  }
  return new OpaquePtr<DeclGroupRef>(JD$Move.INSTANCE, DeclReductions);
}


/// Called on the start of target region i.e. '#pragma omp declare target'.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnStartOpenMPDeclareTargetDirective">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 11429,
 FQN="clang::Sema::ActOnStartOpenMPDeclareTargetDirective", NM="_ZN5clang4Sema38ActOnStartOpenMPDeclareTargetDirectiveENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4Sema38ActOnStartOpenMPDeclareTargetDirectiveENS_14SourceLocationE")
//</editor-fold>
public final boolean ActOnStartOpenMPDeclareTargetDirective(SourceLocation Loc) {
  DeclContext /*P*/ CurLexicalContext = $this().getCurLexicalContext();
  if (!CurLexicalContext.isFileContext()
     && !CurLexicalContext.isExternCContext()
     && !CurLexicalContext.isExternCXXContext()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track($this().Diag(new SourceLocation(Loc), diag.err_omp_region_not_file_context)));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  if ($this().IsInOpenMPDeclareTargetContext) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track($this().Diag(new SourceLocation(Loc), diag.err_omp_enclosed_declare_target)));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  
  $this().IsInOpenMPDeclareTargetContext = true;
  return true;
}

/// Called at the end of target region i.e. '#pragme omp end declare target'.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnFinishOpenMPDeclareTargetDirective">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 11446,
 FQN="clang::Sema::ActOnFinishOpenMPDeclareTargetDirective", NM="_ZN5clang4Sema39ActOnFinishOpenMPDeclareTargetDirectiveEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4Sema39ActOnFinishOpenMPDeclareTargetDirectiveEv")
//</editor-fold>
public final void ActOnFinishOpenMPDeclareTargetDirective() {
  assert ($this().IsInOpenMPDeclareTargetContext) : "Unexpected ActOnFinishOpenMPDeclareTargetDirective";
  
  $this().IsInOpenMPDeclareTargetContext = false;
}

/// Called on correct id-expression from the '#pragma omp declare target'.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnOpenMPDeclareTargetName">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 11453,
 FQN="clang::Sema::ActOnOpenMPDeclareTargetName", NM="_ZN5clang4Sema28ActOnOpenMPDeclareTargetNameEPNS_5ScopeERNS_12CXXScopeSpecERKNS_19DeclarationNameInfoENS_24OMPDeclareTargetDeclAttr9MapTypeTyERN4llvm14SmallSetVectorIPKNS_9NamedDeclELj16EEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4Sema28ActOnOpenMPDeclareTargetNameEPNS_5ScopeERNS_12CXXScopeSpecERKNS_19DeclarationNameInfoENS_24OMPDeclareTargetDeclAttr9MapTypeTyERN4llvm14SmallSetVectorIPKNS_9NamedDeclELj16EEE")
//</editor-fold>
public final void ActOnOpenMPDeclareTargetName(Scope /*P*/ CurScope, final CXXScopeSpec /*&*/ ScopeSpec, 
                            final /*const*/ DeclarationNameInfo /*&*/ Id, 
                            OMPDeclareTargetDeclAttr.MapTypeTy MT, 
                            final SmallSetVector</*const*/ NamedDecl /*P*/ > /*&*/ SameDirectiveDecls) {
  LookupResult Lookup = null;
  try {
    Lookup/*J*/= new LookupResult(/*Deref*/$this(), Id, LookupNameKind.LookupOrdinaryName);
    $this().LookupParsedName(Lookup, CurScope, $AddrOf(ScopeSpec), true);
    if (Lookup.isAmbiguous()) {
      return;
    }
    Lookup.suppressDiagnostics();
    if (!Lookup.isSingleResult()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        {
          TypoCorrection Corrected = null;
          try {
            Corrected = $c$.clean($this().CorrectTypo(Id, LookupNameKind.LookupOrdinaryName, CurScope, (CXXScopeSpec /*P*/ )null, 
                $c$.track(new std.unique_ptr<CorrectionCandidateCallback>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(llvm.make_unique(new VarOrFuncDeclFilterCCC(/*Deref*/$this()))))), 
                CorrectTypoKind.CTK_ErrorRecovery));
            if (Corrected.$bool()) {
              $this().diagnoseTypo(Corrected, $out_PartialDiagnostic$C_DeclarationName($c$.track($this().PDiag(diag.err_undeclared_var_use_suggest)), 
                      Id.getName())); $c$.clean();
              $this().checkDeclIsAllowedInOpenMPTarget((Expr /*P*/ )null, Corrected.getCorrectionDecl());
              return;
            }
          } finally {
            if (Corrected != null) { Corrected.$destroy(); }
          }
        }
        
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Id.getLoc(), diag.err_undeclared_var_use)), Id.getName()));
        return;
      } finally {
        $c$.$destroy();
      }
    }
    
    NamedDecl /*P*/ ND = Lookup.<NamedDecl>getAsSingle(NamedDecl.class);
    if (isa_VarDecl(ND) || isa_FunctionDecl(ND)) {
      if (!SameDirectiveDecls.insert(cast_NamedDecl(ND.getCanonicalDecl()))) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Id.getLoc(), diag.err_omp_declare_target_multiple)), Id.getName()));
        } finally {
          $c$.$destroy();
        }
      }
      if (!ND.hasAttr(OMPDeclareTargetDeclAttr.class)) {
        Attr /*P*/ A = OMPDeclareTargetDeclAttr.CreateImplicit($this().Context, MT);
        ND.addAttr(A);
        {
          ASTMutationListener /*P*/ ML = $this().Context.getASTMutationListener();
          if ((ML != null)) {
            ML.DeclarationMarkedOpenMPDeclareTarget(ND, A);
          }
        }
        $this().checkDeclIsAllowedInOpenMPTarget((Expr /*P*/ )null, ND);
      } else if (ND.getAttr(OMPDeclareTargetDeclAttr.class).getMapType() != MT) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Id.getLoc(), diag.err_omp_declare_target_to_and_link)), 
              Id.getName()));
        } finally {
          $c$.$destroy();
        }
      }
    } else {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Id.getLoc(), diag.err_omp_invalid_target_decl)), Id.getName()));
      } finally {
        $c$.$destroy();
      }
    }
  } finally {
    if (Lookup != null) { Lookup.$destroy(); }
  }
}

/// Check declaration inside target region.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::checkDeclIsAllowedInOpenMPTarget">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 11579,
 FQN="clang::Sema::checkDeclIsAllowedInOpenMPTarget", NM="_ZN5clang4Sema32checkDeclIsAllowedInOpenMPTargetEPNS_4ExprEPNS_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4Sema32checkDeclIsAllowedInOpenMPTargetEPNS_4ExprEPNS_4DeclE")
//</editor-fold>
public final void checkDeclIsAllowedInOpenMPTarget(Expr /*P*/ E, Decl /*P*/ D) {
  if (!(D != null) || D.isInvalidDecl()) {
    return;
  }
  SourceRange SR = (E != null) ? E.getSourceRange() : D.getSourceRange();
  SourceLocation SL = (E != null) ? E.getLocStart() : D.getLocation();
  {
    // 2.10.6: threadprivate variable cannot appear in a declare target directive.
    VarDecl /*P*/ VD = dyn_cast_VarDecl(D);
    if ((VD != null)) {
      if (((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).isThreadPrivate(VD)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag(new SourceLocation(SL), diag.err_omp_threadprivate_in_target)));
          ReportOriginalDSA(/*Deref*/$this(), ((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)), VD, ((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).getTopDSA(VD, false));
          return;
        } finally {
          $c$.$destroy();
        }
      }
    }
  }
  {
    ValueDecl /*P*/ VD = dyn_cast_ValueDecl(D);
    if ((VD != null)) {
      // Problem if any with var declared with incomplete type will be reported
      // as normal, so no need to check it here.
      if (((E != null) || !VD.getType().$arrow().isIncompleteType())
         && !checkValueDeclInTarget(new SourceLocation(SL), new SourceRange(SR), /*Deref*/$this(), ((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)), VD)) {
        // Mark decl as declared target to prevent further diagnostic.
        if (isa_VarDecl(VD) || isa_FunctionDecl(VD)) {
          Attr /*P*/ A = OMPDeclareTargetDeclAttr.CreateImplicit($this().Context, OMPDeclareTargetDeclAttr.MapTypeTy.MT_To);
          VD.addAttr(A);
          {
            ASTMutationListener /*P*/ ML = $this().Context.getASTMutationListener();
            if ((ML != null)) {
              ML.DeclarationMarkedOpenMPDeclareTarget(VD, A);
            }
          }
        }
        return;
      }
    }
  }
  if (!(E != null)) {
    // Checking declaration inside declare target region.
    if (!D.hasAttr(OMPDeclareTargetDeclAttr.class)
       && (isa_VarDecl(D) || isa_FunctionDecl(D))) {
      Attr /*P*/ A = OMPDeclareTargetDeclAttr.CreateImplicit($this().Context, OMPDeclareTargetDeclAttr.MapTypeTy.MT_To);
      D.addAttr(A);
      {
        ASTMutationListener /*P*/ ML = $this().Context.getASTMutationListener();
        if ((ML != null)) {
          ML.DeclarationMarkedOpenMPDeclareTarget(D, A);
        }
      }
    }
    return;
  }
  checkDeclInTargetContext(E.getExprLoc(), E.getSourceRange(), /*Deref*/$this(), D);
}


/// \brief Initialization of captured region for OpenMP region.
// namespace
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnOpenMPRegionStart">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 1584,
 FQN="clang::Sema::ActOnOpenMPRegionStart", NM="_ZN5clang4Sema22ActOnOpenMPRegionStartENS_19OpenMPDirectiveKindEPNS_5ScopeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4Sema22ActOnOpenMPRegionStartENS_19OpenMPDirectiveKindEPNS_5ScopeE")
//</editor-fold>
public final void ActOnOpenMPRegionStart(OpenMPDirectiveKind DKind, Scope /*P*/ CurScope) {
  switch (DKind) {
   case OMPD_parallel:
   case OMPD_parallel_for:
   case OMPD_parallel_for_simd:
   case OMPD_parallel_sections:
   case OMPD_teams:
    {
      QualType KmpInt32Ty = $this().Context.getIntTypeForBitwidth(32, 1);
      QualType KmpInt32PtrTy = $this().Context.getPointerType(new QualType(KmpInt32Ty)).withConst().withRestrict();
      std.pair<StringRef, QualType> Params[/*3*/] = new std.pair [/*3*/] {
        std.make_pair_T_T(new StringRef(".global_tid."), KmpInt32PtrTy), 
        std.make_pair_T_T(new StringRef(".bound_tid."), KmpInt32PtrTy), 
        std.make_pair_T_T(new StringRef(), new QualType()) // __context with shared vars
      };
      $this().ActOnCapturedRegionStart(((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).getConstructLoc(), CurScope, CapturedRegionKind.CR_OpenMP, 
          new ArrayRef<std.pair<StringRef, QualType>>(Params, false));
      break;
    }
   case OMPD_simd:
   case OMPD_for:
   case OMPD_for_simd:
   case OMPD_sections:
   case OMPD_section:
   case OMPD_single:
   case OMPD_master:
   case OMPD_critical:
   case OMPD_taskgroup:
   case OMPD_distribute:
   case OMPD_ordered:
   case OMPD_atomic:
   case OMPD_target_data:
   case OMPD_target:
   case OMPD_target_parallel:
   case OMPD_target_parallel_for:
   case OMPD_target_parallel_for_simd:
    {
      std.pair<StringRef, QualType> Params[/*1*/] = new std.pair [/*1*/] {
        std.make_pair_T_T(new StringRef(), new QualType()) // __context with shared vars
      };
      $this().ActOnCapturedRegionStart(((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).getConstructLoc(), CurScope, CapturedRegionKind.CR_OpenMP, 
          new ArrayRef<std.pair<StringRef, QualType>>(Params, false));
      break;
    }
   case OMPD_task:
    {
      QualType KmpInt32Ty = $this().Context.getIntTypeForBitwidth(32, 1);
      QualType Args[/*1*/] = new QualType [/*1*/] {$this().Context.VoidPtrTy.withConst().withRestrict()};
      FunctionProtoType.ExtProtoInfo EPI/*J*/= new FunctionProtoType.ExtProtoInfo();
      EPI.Variadic = true;
      QualType CopyFnType = $this().Context.getFunctionType($this().Context.VoidTy.$QualType(), new ArrayRef<QualType>(Args, false), EPI);
      std.pair<StringRef, QualType> Params[/*6*/] = new std.pair [/*6*/] {
        std.make_pair_T_T(new StringRef(".global_tid."), KmpInt32Ty), 
        std.make_pair_T_T(new StringRef(".part_id."), $this().Context.getPointerType(new QualType(KmpInt32Ty))), 
        std.make_pair_T_T(new StringRef(".privates."), $this().Context.VoidPtrTy.withConst()), 
        std.make_pair_T_T(new StringRef(".copy_fn."), 
            $this().Context.getPointerType(new QualType(CopyFnType)).withConst()), 
        std.make_pair_T_T(new StringRef(".task_t."), $this().Context.VoidPtrTy.withConst()), 
        std.make_pair_T_T(new StringRef(), new QualType()) // __context with shared vars
      };
      $this().ActOnCapturedRegionStart(((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).getConstructLoc(), CurScope, CapturedRegionKind.CR_OpenMP, 
          new ArrayRef<std.pair<StringRef, QualType>>(Params, false));
      // Mark this captured region as inlined, because we don't use outlined
      // function directly.
      $this().getCurCapturedRegion().TheCapturedDecl.addAttr(AlwaysInlineAttr.CreateImplicit($this().Context, AlwaysInlineAttr.Spelling.Keyword_forceinline, new SourceRange()));
      break;
    }
   case OMPD_taskloop:
   case OMPD_taskloop_simd:
    {
      QualType KmpInt32Ty = $this().Context.getIntTypeForBitwidth(/*DestWidth=*/ 32, /*Signed=*/ 1);
      QualType KmpUInt64Ty = $this().Context.getIntTypeForBitwidth(/*DestWidth=*/ 64, /*Signed=*/ 0);
      QualType KmpInt64Ty = $this().Context.getIntTypeForBitwidth(/*DestWidth=*/ 64, /*Signed=*/ 1);
      QualType Args[/*1*/] = new QualType [/*1*/] {$this().Context.VoidPtrTy.withConst().withRestrict()};
      FunctionProtoType.ExtProtoInfo EPI/*J*/= new FunctionProtoType.ExtProtoInfo();
      EPI.Variadic = true;
      QualType CopyFnType = $this().Context.getFunctionType($this().Context.VoidTy.$QualType(), new ArrayRef<QualType>(Args, false), EPI);
      std.pair<StringRef, QualType> Params[/*10*/] = new std.pair [/*10*/] {
        std.make_pair_T_T(new StringRef(".global_tid."), KmpInt32Ty), 
        std.make_pair_T_T(new StringRef(".part_id."), $this().Context.getPointerType(new QualType(KmpInt32Ty))), 
        std.make_pair_T_T(new StringRef(".privates."), 
            $this().Context.VoidPtrTy.withConst().withRestrict()), 
        std.make_pair_T_T(new StringRef(".copy_fn."), 
            $this().Context.getPointerType(new QualType(CopyFnType)).withConst().withRestrict()), 
        std.make_pair_T_T(new StringRef(".task_t."), $this().Context.VoidPtrTy.withConst()), 
        std.make_pair_T_T(new StringRef(".lb."), KmpUInt64Ty), 
        std.make_pair_T_T(new StringRef(".ub."), KmpUInt64Ty), std.make_pair_T_T(new StringRef(".st."), KmpInt64Ty), 
        std.make_pair_T_T(new StringRef(".liter."), KmpInt32Ty), 
        std.make_pair_T_T(new StringRef(), new QualType()) // __context with shared vars
      };
      $this().ActOnCapturedRegionStart(((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).getConstructLoc(), CurScope, CapturedRegionKind.CR_OpenMP, 
          new ArrayRef<std.pair<StringRef, QualType>>(Params, false));
      // Mark this captured region as inlined, because we don't use outlined
      // function directly.
      $this().getCurCapturedRegion().TheCapturedDecl.addAttr(AlwaysInlineAttr.CreateImplicit($this().Context, AlwaysInlineAttr.Spelling.Keyword_forceinline, new SourceRange()));
      break;
    }
   case OMPD_distribute_parallel_for_simd:
   case OMPD_distribute_simd:
   case OMPD_distribute_parallel_for:
    {
      QualType KmpInt32Ty = $this().Context.getIntTypeForBitwidth(32, 1);
      QualType KmpInt32PtrTy = $this().Context.getPointerType(new QualType(KmpInt32Ty)).withConst().withRestrict();
      std.pair<StringRef, QualType> Params[/*5*/] = new std.pair [/*5*/] {
        std.make_pair_T_T(new StringRef(".global_tid."), KmpInt32PtrTy), 
        std.make_pair_T_T(new StringRef(".bound_tid."), KmpInt32PtrTy), 
        std.make_pair_T_T(new StringRef(".previous.lb."), $this().Context.getSizeType()), 
        std.make_pair_T_T(new StringRef(".previous.ub."), $this().Context.getSizeType()), 
        std.make_pair_T_T(new StringRef(), new QualType()) // __context with shared vars
      };
      $this().ActOnCapturedRegionStart(((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).getConstructLoc(), CurScope, CapturedRegionKind.CR_OpenMP, 
          new ArrayRef<std.pair<StringRef, QualType>>(Params, false));
      break;
    }
   case OMPD_threadprivate:
   case OMPD_taskyield:
   case OMPD_barrier:
   case OMPD_taskwait:
   case OMPD_cancellation_point:
   case OMPD_cancel:
   case OMPD_flush:
   case OMPD_target_enter_data:
   case OMPD_target_exit_data:
   case OMPD_declare_reduction:
   case OMPD_declare_simd:
   case OMPD_declare_target:
   case OMPD_end_declare_target:
   case OMPD_target_update:
    throw new llvm_unreachable("OpenMP Directive is not allowed");
   case OMPD_unknown:
    throw new llvm_unreachable("Unknown OpenMP directive");
  }
}

/// \brief End of OpenMP region.
///
/// \param S Statement associated with the current OpenMP region.
/// \param Clauses List of clauses for the current OpenMP region.
///
/// \returns Statement for finished OpenMP region.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnOpenMPRegionEnd">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 1782,
 FQN="clang::Sema::ActOnOpenMPRegionEnd", NM="_ZN5clang4Sema20ActOnOpenMPRegionEndENS_12ActionResultIPNS_4StmtELb1EEEN4llvm8ArrayRefIPNS_9OMPClauseEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4Sema20ActOnOpenMPRegionEndENS_12ActionResultIPNS_4StmtELb1EEEN4llvm8ArrayRefIPNS_9OMPClauseEEE")
//</editor-fold>
public final ActionResultTTrue<Stmt /*P*/ > ActOnOpenMPRegionEnd(ActionResultTTrue<Stmt /*P*/ > S, 
                    ArrayRef<OMPClause /*P*/ > Clauses) {
  if (!S.isUsable()) {
    $this().ActOnCapturedRegionError();
    return StmtError();
  }
  
  OMPOrderedClause /*P*/ OC = null;
  OMPScheduleClause /*P*/ SC = null;
  SmallVector<OMPLinearClause /*P*/ > LCs/*J*/= new SmallVector<OMPLinearClause /*P*/ >(4, (OMPLinearClause /*P*/ )null);
  // This is required for proper codegen.
  for (OMPClause /*P*/ Clause : Clauses) {
    if (isOpenMPPrivate(Clause.getClauseKind())
       || Clause.getClauseKind() == OpenMPClauseKind.OMPC_copyprivate
       || ($this().getLangOpts().OpenMPUseTLS
       && $this().getASTContext().getTargetInfo().isTLSSupported()
       && Clause.getClauseKind() == OpenMPClauseKind.OMPC_copyin)) {
      ((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).setForceVarCapturing(Clause.getClauseKind() == OpenMPClauseKind.OMPC_copyin);
      // Mark all variables in private list clauses as used in inner region.
      for (Stmt /*P*/ VarRef : Clause.children()) {
        {
          Expr /*P*/ E = cast_or_null_Expr(VarRef);
          if ((E != null)) {
            $this().MarkDeclarationsReferencedInExpr(E);
          }
        }
      }
      ((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).setForceVarCapturing(/*V=*/ false);
    } else if (isParallelOrTaskRegion(((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).getCurrentDirective())) {
      {
        // Mark all variables in private list clauses as used in inner region.
        // Required for proper codegen of combined directives.
        // TODO: add processing for other clauses.
        OMPClauseWithPreInit /*P*/ C = OMPClauseWithPreInit.get_OMPClause$P(Clause);
        if ((C != null)) {
          {
            DeclStmt /*P*/ DS = cast_or_null_DeclStmt(C.getPreInitStmt());
            if ((DS != null)) {
              for (Decl /*P*/ D : DS.decls())  {
                $this().MarkVariableReferenced(D.getLocation(), cast_VarDecl(D));
              }
            }
          }
        }
      }
      {
        OMPClauseWithPostUpdate /*P*/ C = OMPClauseWithPostUpdate.get_OMPClause$P(Clause);
        if ((C != null)) {
          {
            Expr /*P*/ E = C.getPostUpdateExpr();
            if ((E != null)) {
              $this().MarkDeclarationsReferencedInExpr(E);
            }
          }
        }
      }
    }
    if (Clause.getClauseKind() == OpenMPClauseKind.OMPC_schedule) {
      SC = cast_OMPScheduleClause(Clause);
    } else if (Clause.getClauseKind() == OpenMPClauseKind.OMPC_ordered) {
      OC = cast_OMPOrderedClause(Clause);
    } else if (Clause.getClauseKind() == OpenMPClauseKind.OMPC_linear) {
      LCs.push_back(cast_OMPLinearClause(Clause));
    }
  }
  boolean ErrorFound = false;
  // OpenMP, 2.7.1 Loop Construct, Restrictions
  // The nonmonotonic modifier cannot be specified if an ordered clause is
  // specified.
  if ((SC != null)
     && (SC.getFirstScheduleModifier() == OpenMPScheduleClauseModifier.OMPC_SCHEDULE_MODIFIER_nonmonotonic
     || SC.getSecondScheduleModifier()
     == OpenMPScheduleClauseModifier.OMPC_SCHEDULE_MODIFIER_nonmonotonic)
     && (OC != null)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(SC.getFirstScheduleModifier() == OpenMPScheduleClauseModifier.OMPC_SCHEDULE_MODIFIER_nonmonotonic ? SC.getFirstScheduleModifierLoc() : SC.getSecondScheduleModifierLoc(), 
              diag.err_omp_schedule_nonmonotonic_ordered)), 
          new SourceRange(OC.getLocStart(), OC.getLocEnd())));
      ErrorFound = true;
    } finally {
      $c$.$destroy();
    }
  }
  if (!LCs.empty() && (OC != null) && (OC.getNumForLoops() != null)) {
    for (OMPLinearClause /*P*/ C : LCs) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(C.getLocStart(), diag.err_omp_linear_ordered)), 
            new SourceRange(OC.getLocStart(), OC.getLocEnd())));
      } finally {
        $c$.$destroy();
      }
    }
    ErrorFound = true;
  }
  if (isOpenMPWorksharingDirective(((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).getCurrentDirective())
     && isOpenMPSimdDirective(((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).getCurrentDirective()) && (OC != null)
     && (OC.getNumForLoops() != null)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(OC.getLocStart(), diag.err_omp_ordered_simd)), 
          getOpenMPDirectiveName(((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).getCurrentDirective())));
      ErrorFound = true;
    } finally {
      $c$.$destroy();
    }
  }
  if (ErrorFound) {
    $this().ActOnCapturedRegionError();
    return StmtError();
  }
  return $this().ActOnCapturedRegionEnd(S.get());
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnOpenMPExecutableDirective">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 3379,
 FQN="clang::Sema::ActOnOpenMPExecutableDirective", NM="_ZN5clang4Sema30ActOnOpenMPExecutableDirectiveENS_19OpenMPDirectiveKindERKNS_19DeclarationNameInfoES1_N4llvm8ArrayRefIPNS_9OMPClauseEEEPNS_4StmtENS_14SourceLocationESC_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4Sema30ActOnOpenMPExecutableDirectiveENS_19OpenMPDirectiveKindERKNS_19DeclarationNameInfoES1_N4llvm8ArrayRefIPNS_9OMPClauseEEEPNS_4StmtENS_14SourceLocationESC_")
//</editor-fold>
public final ActionResultTTrue<Stmt /*P*/ > ActOnOpenMPExecutableDirective(OpenMPDirectiveKind Kind, final /*const*/ DeclarationNameInfo /*&*/ DirName, 
                              OpenMPDirectiveKind CancelRegion, ArrayRef<OMPClause /*P*/ > Clauses, 
                              Stmt /*P*/ AStmt, SourceLocation StartLoc, SourceLocation EndLoc) {
  ActionResultTTrue<Stmt /*P*/ > Res = StmtError();
  if (CheckNestingOfRegions(/*Deref*/$this(), ((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)), Kind, DirName, CancelRegion, 
      new SourceLocation(StartLoc))) {
    return StmtError();
  }
  
  SmallVector<OMPClause /*P*/ > ClausesWithImplicit/*J*/= new SmallVector<OMPClause /*P*/ >(8, (OMPClause /*P*/ )null);
  DenseMap<ValueDecl /*P*/ , Expr /*P*/ > VarsWithInheritedDSA/*J*/= new DenseMap<ValueDecl /*P*/ , Expr /*P*/ >(DenseMapInfo$LikePtr.$Info(), (Expr /*P*/ )null);
  boolean ErrorFound = false;
  ClausesWithImplicit.append_T(Clauses.begin(), Clauses.end());
  if ((AStmt != null)) {
    DSAAttrChecker DSAChecker = null;
    try {
      assert (isa_CapturedStmt(AStmt)) : "Captured statement expected";
      
      // Check default data sharing attributes for referenced variables.
      DSAChecker/*J*/= new DSAAttrChecker(((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)), /*Deref*/$this(), cast_CapturedStmt(AStmt));
      DSAChecker.Visit(cast_CapturedStmt(AStmt).getCapturedStmt());
      if (DSAChecker.isErrorFound()) {
        return StmtError();
      }
      // Generate list of implicitly defined firstprivate variables.
      VarsWithInheritedDSA.$assign(DSAChecker.getVarsWithInheritedDSA());
      if (!DSAChecker.getImplicitFirstprivate().empty()) {
        {
          OMPClause /*P*/ Implicit = $this().ActOnOpenMPFirstprivateClause(DSAChecker.getImplicitFirstprivate(), new SourceLocation(), 
              new SourceLocation(), new SourceLocation());
          if ((Implicit != null)) {
            ClausesWithImplicit.push_back(Implicit);
            ErrorFound = cast_OMPFirstprivateClause(Implicit).varlist_size()
               != DSAChecker.getImplicitFirstprivate().size();
          } else {
            ErrorFound = true;
          }
        }
      }
    } finally {
      if (DSAChecker != null) { DSAChecker.$destroy(); }
    }
  }
  
  SmallVector<OpenMPDirectiveKind> AllowedNameModifiers/*J*/= new SmallVector<OpenMPDirectiveKind>(4, OpenMPDirectiveKind.valueOf(0));
  switch (Kind) {
   case OMPD_parallel:
    Res.$assignMove($this().ActOnOpenMPParallelDirective(new ArrayRef<OMPClause /*P*/ >(ClausesWithImplicit, true), AStmt, new SourceLocation(StartLoc), 
            new SourceLocation(EndLoc)));
    AllowedNameModifiers.push_back(OpenMPDirectiveKind.OMPD_parallel);
    break;
   case OMPD_simd:
    Res.$assignMove($this().ActOnOpenMPSimdDirective(new ArrayRef<OMPClause /*P*/ >(ClausesWithImplicit, true), AStmt, new SourceLocation(StartLoc), new SourceLocation(EndLoc), 
            VarsWithInheritedDSA));
    break;
   case OMPD_for:
    Res.$assignMove($this().ActOnOpenMPForDirective(new ArrayRef<OMPClause /*P*/ >(ClausesWithImplicit, true), AStmt, new SourceLocation(StartLoc), new SourceLocation(EndLoc), 
            VarsWithInheritedDSA));
    break;
   case OMPD_for_simd:
    Res.$assignMove($this().ActOnOpenMPForSimdDirective(new ArrayRef<OMPClause /*P*/ >(ClausesWithImplicit, true), AStmt, new SourceLocation(StartLoc), 
            new SourceLocation(EndLoc), VarsWithInheritedDSA));
    break;
   case OMPD_sections:
    Res.$assignMove($this().ActOnOpenMPSectionsDirective(new ArrayRef<OMPClause /*P*/ >(ClausesWithImplicit, true), AStmt, new SourceLocation(StartLoc), 
            new SourceLocation(EndLoc)));
    break;
   case OMPD_section:
    assert (ClausesWithImplicit.empty()) : "No clauses are allowed for 'omp section' directive";
    Res.$assignMove($this().ActOnOpenMPSectionDirective(AStmt, new SourceLocation(StartLoc), new SourceLocation(EndLoc)));
    break;
   case OMPD_single:
    Res.$assignMove($this().ActOnOpenMPSingleDirective(new ArrayRef<OMPClause /*P*/ >(ClausesWithImplicit, true), AStmt, new SourceLocation(StartLoc), 
            new SourceLocation(EndLoc)));
    break;
   case OMPD_master:
    assert (ClausesWithImplicit.empty()) : "No clauses are allowed for 'omp master' directive";
    Res.$assignMove($this().ActOnOpenMPMasterDirective(AStmt, new SourceLocation(StartLoc), new SourceLocation(EndLoc)));
    break;
   case OMPD_critical:
    Res.$assignMove($this().ActOnOpenMPCriticalDirective(DirName, new ArrayRef<OMPClause /*P*/ >(ClausesWithImplicit, true), AStmt, 
            new SourceLocation(StartLoc), new SourceLocation(EndLoc)));
    break;
   case OMPD_parallel_for:
    Res.$assignMove($this().ActOnOpenMPParallelForDirective(new ArrayRef<OMPClause /*P*/ >(ClausesWithImplicit, true), AStmt, new SourceLocation(StartLoc), 
            new SourceLocation(EndLoc), VarsWithInheritedDSA));
    AllowedNameModifiers.push_back(OpenMPDirectiveKind.OMPD_parallel);
    break;
   case OMPD_parallel_for_simd:
    Res.$assignMove($this().ActOnOpenMPParallelForSimdDirective(new ArrayRef<OMPClause /*P*/ >(ClausesWithImplicit, true), AStmt, new SourceLocation(StartLoc), new SourceLocation(EndLoc), VarsWithInheritedDSA));
    AllowedNameModifiers.push_back(OpenMPDirectiveKind.OMPD_parallel);
    break;
   case OMPD_parallel_sections:
    Res.$assignMove($this().ActOnOpenMPParallelSectionsDirective(new ArrayRef<OMPClause /*P*/ >(ClausesWithImplicit, true), AStmt, 
            new SourceLocation(StartLoc), new SourceLocation(EndLoc)));
    AllowedNameModifiers.push_back(OpenMPDirectiveKind.OMPD_parallel);
    break;
   case OMPD_task:
    Res.$assignMove(
        $this().ActOnOpenMPTaskDirective(new ArrayRef<OMPClause /*P*/ >(ClausesWithImplicit, true), AStmt, new SourceLocation(StartLoc), new SourceLocation(EndLoc))
    );
    AllowedNameModifiers.push_back(OpenMPDirectiveKind.OMPD_task);
    break;
   case OMPD_taskyield:
    assert (ClausesWithImplicit.empty()) : "No clauses are allowed for 'omp taskyield' directive";
    assert (AStmt == null) : "No associated statement allowed for 'omp taskyield' directive";
    Res.$assignMove($this().ActOnOpenMPTaskyieldDirective(new SourceLocation(StartLoc), new SourceLocation(EndLoc)));
    break;
   case OMPD_barrier:
    assert (ClausesWithImplicit.empty()) : "No clauses are allowed for 'omp barrier' directive";
    assert (AStmt == null) : "No associated statement allowed for 'omp barrier' directive";
    Res.$assignMove($this().ActOnOpenMPBarrierDirective(new SourceLocation(StartLoc), new SourceLocation(EndLoc)));
    break;
   case OMPD_taskwait:
    assert (ClausesWithImplicit.empty()) : "No clauses are allowed for 'omp taskwait' directive";
    assert (AStmt == null) : "No associated statement allowed for 'omp taskwait' directive";
    Res.$assignMove($this().ActOnOpenMPTaskwaitDirective(new SourceLocation(StartLoc), new SourceLocation(EndLoc)));
    break;
   case OMPD_taskgroup:
    assert (ClausesWithImplicit.empty()) : "No clauses are allowed for 'omp taskgroup' directive";
    Res.$assignMove($this().ActOnOpenMPTaskgroupDirective(AStmt, new SourceLocation(StartLoc), new SourceLocation(EndLoc)));
    break;
   case OMPD_flush:
    assert (AStmt == null) : "No associated statement allowed for 'omp flush' directive";
    Res.$assignMove($this().ActOnOpenMPFlushDirective(new ArrayRef<OMPClause /*P*/ >(ClausesWithImplicit, true), new SourceLocation(StartLoc), new SourceLocation(EndLoc)));
    break;
   case OMPD_ordered:
    Res.$assignMove($this().ActOnOpenMPOrderedDirective(new ArrayRef<OMPClause /*P*/ >(ClausesWithImplicit, true), AStmt, new SourceLocation(StartLoc), 
            new SourceLocation(EndLoc)));
    break;
   case OMPD_atomic:
    Res.$assignMove($this().ActOnOpenMPAtomicDirective(new ArrayRef<OMPClause /*P*/ >(ClausesWithImplicit, true), AStmt, new SourceLocation(StartLoc), 
            new SourceLocation(EndLoc)));
    break;
   case OMPD_teams:
    Res.$assignMove(
        $this().ActOnOpenMPTeamsDirective(new ArrayRef<OMPClause /*P*/ >(ClausesWithImplicit, true), AStmt, new SourceLocation(StartLoc), new SourceLocation(EndLoc))
    );
    break;
   case OMPD_target:
    Res.$assignMove($this().ActOnOpenMPTargetDirective(new ArrayRef<OMPClause /*P*/ >(ClausesWithImplicit, true), AStmt, new SourceLocation(StartLoc), 
            new SourceLocation(EndLoc)));
    AllowedNameModifiers.push_back(OpenMPDirectiveKind.OMPD_target);
    break;
   case OMPD_target_parallel:
    Res.$assignMove($this().ActOnOpenMPTargetParallelDirective(new ArrayRef<OMPClause /*P*/ >(ClausesWithImplicit, true), AStmt, 
            new SourceLocation(StartLoc), new SourceLocation(EndLoc)));
    AllowedNameModifiers.push_back(OpenMPDirectiveKind.OMPD_target);
    AllowedNameModifiers.push_back(OpenMPDirectiveKind.OMPD_parallel);
    break;
   case OMPD_target_parallel_for:
    Res.$assignMove($this().ActOnOpenMPTargetParallelForDirective(new ArrayRef<OMPClause /*P*/ >(ClausesWithImplicit, true), AStmt, new SourceLocation(StartLoc), new SourceLocation(EndLoc), VarsWithInheritedDSA));
    AllowedNameModifiers.push_back(OpenMPDirectiveKind.OMPD_target);
    AllowedNameModifiers.push_back(OpenMPDirectiveKind.OMPD_parallel);
    break;
   case OMPD_cancellation_point:
    assert (ClausesWithImplicit.empty()) : "No clauses are allowed for 'omp cancellation point' directive";
    assert (AStmt == null) : "No associated statement allowed for 'omp cancellation point' directive";
    Res.$assignMove($this().ActOnOpenMPCancellationPointDirective(new SourceLocation(StartLoc), new SourceLocation(EndLoc), CancelRegion));
    break;
   case OMPD_cancel:
    assert (AStmt == null) : "No associated statement allowed for 'omp cancel' directive";
    Res.$assignMove($this().ActOnOpenMPCancelDirective(new ArrayRef<OMPClause /*P*/ >(ClausesWithImplicit, true), new SourceLocation(StartLoc), new SourceLocation(EndLoc), 
            CancelRegion));
    AllowedNameModifiers.push_back(OpenMPDirectiveKind.OMPD_cancel);
    break;
   case OMPD_target_data:
    Res.$assignMove($this().ActOnOpenMPTargetDataDirective(new ArrayRef<OMPClause /*P*/ >(ClausesWithImplicit, true), AStmt, new SourceLocation(StartLoc), 
            new SourceLocation(EndLoc)));
    AllowedNameModifiers.push_back(OpenMPDirectiveKind.OMPD_target_data);
    break;
   case OMPD_target_enter_data:
    Res.$assignMove($this().ActOnOpenMPTargetEnterDataDirective(new ArrayRef<OMPClause /*P*/ >(ClausesWithImplicit, true), new SourceLocation(StartLoc), 
            new SourceLocation(EndLoc)));
    AllowedNameModifiers.push_back(OpenMPDirectiveKind.OMPD_target_enter_data);
    break;
   case OMPD_target_exit_data:
    Res.$assignMove($this().ActOnOpenMPTargetExitDataDirective(new ArrayRef<OMPClause /*P*/ >(ClausesWithImplicit, true), new SourceLocation(StartLoc), 
            new SourceLocation(EndLoc)));
    AllowedNameModifiers.push_back(OpenMPDirectiveKind.OMPD_target_exit_data);
    break;
   case OMPD_taskloop:
    Res.$assignMove($this().ActOnOpenMPTaskLoopDirective(new ArrayRef<OMPClause /*P*/ >(ClausesWithImplicit, true), AStmt, new SourceLocation(StartLoc), 
            new SourceLocation(EndLoc), VarsWithInheritedDSA));
    AllowedNameModifiers.push_back(OpenMPDirectiveKind.OMPD_taskloop);
    break;
   case OMPD_taskloop_simd:
    Res.$assignMove($this().ActOnOpenMPTaskLoopSimdDirective(new ArrayRef<OMPClause /*P*/ >(ClausesWithImplicit, true), AStmt, new SourceLocation(StartLoc), 
            new SourceLocation(EndLoc), VarsWithInheritedDSA));
    AllowedNameModifiers.push_back(OpenMPDirectiveKind.OMPD_taskloop);
    break;
   case OMPD_distribute:
    Res.$assignMove($this().ActOnOpenMPDistributeDirective(new ArrayRef<OMPClause /*P*/ >(ClausesWithImplicit, true), AStmt, new SourceLocation(StartLoc), 
            new SourceLocation(EndLoc), VarsWithInheritedDSA));
    break;
   case OMPD_target_update:
    assert (!(AStmt != null)) : "Statement is not allowed for target update";
    Res.$assignMove(
        $this().ActOnOpenMPTargetUpdateDirective(new ArrayRef<OMPClause /*P*/ >(ClausesWithImplicit, true), new SourceLocation(StartLoc), new SourceLocation(EndLoc))
    );
    AllowedNameModifiers.push_back(OpenMPDirectiveKind.OMPD_target_update);
    break;
   case OMPD_distribute_parallel_for:
    Res.$assignMove($this().ActOnOpenMPDistributeParallelForDirective(new ArrayRef<OMPClause /*P*/ >(ClausesWithImplicit, true), AStmt, new SourceLocation(StartLoc), new SourceLocation(EndLoc), VarsWithInheritedDSA));
    AllowedNameModifiers.push_back(OpenMPDirectiveKind.OMPD_parallel);
    break;
   case OMPD_distribute_parallel_for_simd:
    Res.$assignMove($this().ActOnOpenMPDistributeParallelForSimdDirective(new ArrayRef<OMPClause /*P*/ >(ClausesWithImplicit, true), AStmt, new SourceLocation(StartLoc), new SourceLocation(EndLoc), VarsWithInheritedDSA));
    AllowedNameModifiers.push_back(OpenMPDirectiveKind.OMPD_parallel);
    break;
   case OMPD_distribute_simd:
    Res.$assignMove($this().ActOnOpenMPDistributeSimdDirective(new ArrayRef<OMPClause /*P*/ >(ClausesWithImplicit, true), AStmt, new SourceLocation(StartLoc), new SourceLocation(EndLoc), VarsWithInheritedDSA));
    break;
   case OMPD_target_parallel_for_simd:
    Res.$assignMove($this().ActOnOpenMPTargetParallelForSimdDirective(new ArrayRef<OMPClause /*P*/ >(ClausesWithImplicit, true), AStmt, new SourceLocation(StartLoc), new SourceLocation(EndLoc), VarsWithInheritedDSA));
    AllowedNameModifiers.push_back(OpenMPDirectiveKind.OMPD_target);
    AllowedNameModifiers.push_back(OpenMPDirectiveKind.OMPD_parallel);
    break;
   case OMPD_declare_target:
   case OMPD_end_declare_target:
   case OMPD_threadprivate:
   case OMPD_declare_reduction:
   case OMPD_declare_simd:
    throw new llvm_unreachable("OpenMP Directive is not allowed");
   case OMPD_unknown:
    throw new llvm_unreachable("Unknown OpenMP directive");
  }
  
  for (std.pair<ValueDecl /*P*/ , Expr /*P*/ > P : VarsWithInheritedDSA) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(P.second.getExprLoc(), diag.err_omp_no_dsa_for_variable)), 
              P.first), P.second.getSourceRange()));
    } finally {
      $c$.$destroy();
    }
  }
  ErrorFound = !VarsWithInheritedDSA.empty() || ErrorFound;
  if (!AllowedNameModifiers.empty()) {
    ErrorFound = checkIfClauses(/*Deref*/$this(), Kind, new ArrayRef<OMPClause /*P*/ >(Clauses), new ArrayRef<OpenMPDirectiveKind>(AllowedNameModifiers))
       || ErrorFound;
  }
  if (ErrorFound) {
    return StmtError();
  }
  return Res;
}

/// \brief Called on well-formed '\#pragma omp parallel' after parsing
/// of the  associated statement.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnOpenMPParallelDirective">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 3876,
 FQN="clang::Sema::ActOnOpenMPParallelDirective", NM="_ZN5clang4Sema28ActOnOpenMPParallelDirectiveEN4llvm8ArrayRefIPNS_9OMPClauseEEEPNS_4StmtENS_14SourceLocationES8_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4Sema28ActOnOpenMPParallelDirectiveEN4llvm8ArrayRefIPNS_9OMPClauseEEEPNS_4StmtENS_14SourceLocationES8_")
//</editor-fold>
public final ActionResultTTrue<Stmt /*P*/ > ActOnOpenMPParallelDirective(ArrayRef<OMPClause /*P*/ > Clauses, 
                            Stmt /*P*/ AStmt, 
                            SourceLocation StartLoc, 
                            SourceLocation EndLoc) {
  if (!(AStmt != null)) {
    return StmtError();
  }
  
  CapturedStmt /*P*/ CS = cast_CapturedStmt(AStmt);
  // 1.2.2 OpenMP Language Terminology
  // Structured block - An executable statement with a single entry at the
  // top and a single exit at the bottom.
  // The point of exit cannot be a branch out of the structured block.
  // longjmp() and throw() must not violate the entry/exit criteria.
  CS.getCapturedDecl().setNothrow();
  
  $this().getCurFunction().setHasBranchProtectedScope();
  
  return new ActionResultTTrue<Stmt /*P*/ >(JD$T.INSTANCE, OMPParallelDirective.Create($this().Context, new SourceLocation(StartLoc), new SourceLocation(EndLoc), new ArrayRef<OMPClause /*P*/ >(Clauses), AStmt, 
          ((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).isCancelRegion()));
}

/// \brief Called on well-formed '\#pragma omp simd' after parsing
/// of the associated statement.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnOpenMPSimdDirective">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 5471,
 FQN="clang::Sema::ActOnOpenMPSimdDirective", NM="_ZN5clang4Sema24ActOnOpenMPSimdDirectiveEN4llvm8ArrayRefIPNS_9OMPClauseEEEPNS_4StmtENS_14SourceLocationES8_RNS1_8DenseMapIPNS_9ValueDeclEPNS_4ExprENS1_12DenseMapInfoISB_EENS1_6detail12DenseMapPairISB_SD_EEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4Sema24ActOnOpenMPSimdDirectiveEN4llvm8ArrayRefIPNS_9OMPClauseEEEPNS_4StmtENS_14SourceLocationES8_RNS1_8DenseMapIPNS_9ValueDeclEPNS_4ExprENS1_12DenseMapInfoISB_EENS1_6detail12DenseMapPairISB_SD_EEEE")
//</editor-fold>
public final ActionResultTTrue<Stmt /*P*/ > ActOnOpenMPSimdDirective(ArrayRef<OMPClause /*P*/ > Clauses, Stmt /*P*/ AStmt, SourceLocation StartLoc, 
                        SourceLocation EndLoc, 
                        final DenseMap<ValueDecl /*P*/ , Expr /*P*/ > /*&*/ VarsWithImplicitDSA) {
  OMPLoopDirective.HelperExprs B = null;
  try {
    if (!(AStmt != null)) {
      return StmtError();
    }
    assert (isa_CapturedStmt(AStmt)) : "Captured statement expected";
    B/*J*/= new OMPLoopDirective.HelperExprs();
    // In presence of clause 'collapse' or 'ordered' with number of loops, it will
    // define the nested loops number.
    /*uint*/int NestedLoopCount = CheckOpenMPLoop(OpenMPDirectiveKind.OMPD_simd, getCollapseNumberExpr(new ArrayRef<OMPClause /*P*/ >(Clauses)), getOrderedNumberExpr(new ArrayRef<OMPClause /*P*/ >(Clauses)), 
        AStmt, /*Deref*/$this(), $Deref(((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack))), VarsWithImplicitDSA, B);
    if (NestedLoopCount == 0) {
      return StmtError();
    }
    assert (($this().CurContext.isDependentContext() || B.builtAll())) : "omp simd loop exprs were not built";
    if (!$this().CurContext.isDependentContext()) {
      // Finalize the clauses that need pre-built expressions for CodeGen.
      for (OMPClause /*P*/ C : Clauses) {
        {
          OMPLinearClause /*P*/ LC = dyn_cast_OMPLinearClause(C);
          if ((LC != null)) {
            if (FinishOpenMPLinearClause($Deref(LC), cast_DeclRefExpr(B.IterationVarRef), 
                B.NumIterations, /*Deref*/$this(), $this().CurScope, 
                ((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)))) {
              return StmtError();
            }
          }
        }
      }
    }
    if (checkSimdlenSafelenSpecified(/*Deref*/$this(), new ArrayRef<OMPClause /*P*/ >(Clauses))) {
      return StmtError();
    }
    
    $this().getCurFunction().setHasBranchProtectedScope();
    return new ActionResultTTrue<Stmt /*P*/ >(JD$T.INSTANCE, OMPSimdDirective.Create($this().Context, new SourceLocation(StartLoc), new SourceLocation(EndLoc), NestedLoopCount, 
            new ArrayRef<OMPClause /*P*/ >(Clauses), AStmt, B));
  } finally {
    if (B != null) { B.$destroy(); }
  }
}

/// \brief Called on well-formed '\#pragma omp for' after parsing
/// of the associated statement.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnOpenMPForDirective">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 5510,
 FQN="clang::Sema::ActOnOpenMPForDirective", NM="_ZN5clang4Sema23ActOnOpenMPForDirectiveEN4llvm8ArrayRefIPNS_9OMPClauseEEEPNS_4StmtENS_14SourceLocationES8_RNS1_8DenseMapIPNS_9ValueDeclEPNS_4ExprENS1_12DenseMapInfoISB_EENS1_6detail12DenseMapPairISB_SD_EEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4Sema23ActOnOpenMPForDirectiveEN4llvm8ArrayRefIPNS_9OMPClauseEEEPNS_4StmtENS_14SourceLocationES8_RNS1_8DenseMapIPNS_9ValueDeclEPNS_4ExprENS1_12DenseMapInfoISB_EENS1_6detail12DenseMapPairISB_SD_EEEE")
//</editor-fold>
public final ActionResultTTrue<Stmt /*P*/ > ActOnOpenMPForDirective(ArrayRef<OMPClause /*P*/ > Clauses, Stmt /*P*/ AStmt, SourceLocation StartLoc, 
                       SourceLocation EndLoc, 
                       final DenseMap<ValueDecl /*P*/ , Expr /*P*/ > /*&*/ VarsWithImplicitDSA) {
  OMPLoopDirective.HelperExprs B = null;
  try {
    if (!(AStmt != null)) {
      return StmtError();
    }
    assert (isa_CapturedStmt(AStmt)) : "Captured statement expected";
    B/*J*/= new OMPLoopDirective.HelperExprs();
    // In presence of clause 'collapse' or 'ordered' with number of loops, it will
    // define the nested loops number.
    /*uint*/int NestedLoopCount = CheckOpenMPLoop(OpenMPDirectiveKind.OMPD_for, getCollapseNumberExpr(new ArrayRef<OMPClause /*P*/ >(Clauses)), getOrderedNumberExpr(new ArrayRef<OMPClause /*P*/ >(Clauses)), 
        AStmt, /*Deref*/$this(), $Deref(((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack))), VarsWithImplicitDSA, B);
    if (NestedLoopCount == 0) {
      return StmtError();
    }
    assert (($this().CurContext.isDependentContext() || B.builtAll())) : "omp for loop exprs were not built";
    if (!$this().CurContext.isDependentContext()) {
      // Finalize the clauses that need pre-built expressions for CodeGen.
      for (OMPClause /*P*/ C : Clauses) {
        {
          OMPLinearClause /*P*/ LC = dyn_cast_OMPLinearClause(C);
          if ((LC != null)) {
            if (FinishOpenMPLinearClause($Deref(LC), cast_DeclRefExpr(B.IterationVarRef), 
                B.NumIterations, /*Deref*/$this(), $this().CurScope, 
                ((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)))) {
              return StmtError();
            }
          }
        }
      }
    }
    
    $this().getCurFunction().setHasBranchProtectedScope();
    return new ActionResultTTrue<Stmt /*P*/ >(JD$T.INSTANCE, OMPForDirective.Create($this().Context, new SourceLocation(StartLoc), new SourceLocation(EndLoc), NestedLoopCount, 
            new ArrayRef<OMPClause /*P*/ >(Clauses), AStmt, B, ((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).isCancelRegion()));
  } finally {
    if (B != null) { B.$destroy(); }
  }
}

/// \brief Called on well-formed '\#pragma omp for simd' after parsing
/// of the associated statement.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnOpenMPForSimdDirective">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 5546,
 FQN="clang::Sema::ActOnOpenMPForSimdDirective", NM="_ZN5clang4Sema27ActOnOpenMPForSimdDirectiveEN4llvm8ArrayRefIPNS_9OMPClauseEEEPNS_4StmtENS_14SourceLocationES8_RNS1_8DenseMapIPNS_9ValueDeclEPNS_4ExprENS1_12DenseMapInfoISB_EENS1_6detail12DenseMapPairISB_SD_EEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4Sema27ActOnOpenMPForSimdDirectiveEN4llvm8ArrayRefIPNS_9OMPClauseEEEPNS_4StmtENS_14SourceLocationES8_RNS1_8DenseMapIPNS_9ValueDeclEPNS_4ExprENS1_12DenseMapInfoISB_EENS1_6detail12DenseMapPairISB_SD_EEEE")
//</editor-fold>
public final ActionResultTTrue<Stmt /*P*/ > ActOnOpenMPForSimdDirective(ArrayRef<OMPClause /*P*/ > Clauses, Stmt /*P*/ AStmt, SourceLocation StartLoc, 
                           SourceLocation EndLoc, 
                           final DenseMap<ValueDecl /*P*/ , Expr /*P*/ > /*&*/ VarsWithImplicitDSA) {
  OMPLoopDirective.HelperExprs B = null;
  try {
    if (!(AStmt != null)) {
      return StmtError();
    }
    assert (isa_CapturedStmt(AStmt)) : "Captured statement expected";
    B/*J*/= new OMPLoopDirective.HelperExprs();
    // In presence of clause 'collapse' or 'ordered' with number of loops, it will
    // define the nested loops number.
    /*uint*/int NestedLoopCount = CheckOpenMPLoop(OpenMPDirectiveKind.OMPD_for_simd, getCollapseNumberExpr(new ArrayRef<OMPClause /*P*/ >(Clauses)), 
        getOrderedNumberExpr(new ArrayRef<OMPClause /*P*/ >(Clauses)), AStmt, /*Deref*/$this(), $Deref(((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack))), 
        VarsWithImplicitDSA, B);
    if (NestedLoopCount == 0) {
      return StmtError();
    }
    assert (($this().CurContext.isDependentContext() || B.builtAll())) : "omp for simd loop exprs were not built";
    if (!$this().CurContext.isDependentContext()) {
      // Finalize the clauses that need pre-built expressions for CodeGen.
      for (OMPClause /*P*/ C : Clauses) {
        {
          OMPLinearClause /*P*/ LC = dyn_cast_OMPLinearClause(C);
          if ((LC != null)) {
            if (FinishOpenMPLinearClause($Deref(LC), cast_DeclRefExpr(B.IterationVarRef), 
                B.NumIterations, /*Deref*/$this(), $this().CurScope, 
                ((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)))) {
              return StmtError();
            }
          }
        }
      }
    }
    if (checkSimdlenSafelenSpecified(/*Deref*/$this(), new ArrayRef<OMPClause /*P*/ >(Clauses))) {
      return StmtError();
    }
    
    $this().getCurFunction().setHasBranchProtectedScope();
    return new ActionResultTTrue<Stmt /*P*/ >(JD$T.INSTANCE, OMPForSimdDirective.Create($this().Context, new SourceLocation(StartLoc), new SourceLocation(EndLoc), NestedLoopCount, 
            new ArrayRef<OMPClause /*P*/ >(Clauses), AStmt, B));
  } finally {
    if (B != null) { B.$destroy(); }
  }
}

/// \brief Called on well-formed '\#pragma omp sections' after parsing
/// of the associated statement.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnOpenMPSectionsDirective">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 5586,
 FQN="clang::Sema::ActOnOpenMPSectionsDirective", NM="_ZN5clang4Sema28ActOnOpenMPSectionsDirectiveEN4llvm8ArrayRefIPNS_9OMPClauseEEEPNS_4StmtENS_14SourceLocationES8_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4Sema28ActOnOpenMPSectionsDirectiveEN4llvm8ArrayRefIPNS_9OMPClauseEEEPNS_4StmtENS_14SourceLocationES8_")
//</editor-fold>
public final ActionResultTTrue<Stmt /*P*/ > ActOnOpenMPSectionsDirective(ArrayRef<OMPClause /*P*/ > Clauses, 
                            Stmt /*P*/ AStmt, 
                            SourceLocation StartLoc, 
                            SourceLocation EndLoc) {
  if (!(AStmt != null)) {
    return StmtError();
  }
  assert (isa_CapturedStmt(AStmt)) : "Captured statement expected";
  Stmt /*P*/ BaseStmt = AStmt;
  {
    CapturedStmt /*P*/ CS;
    while (((/*P*/ CS = dyn_cast_or_null_CapturedStmt(BaseStmt)) != null)) {
      BaseStmt = CS.getCapturedStmt();
    }
  }
  {
    CompoundStmt /*P*/ C = dyn_cast_or_null_CompoundStmt(BaseStmt);
    if ((C != null)) {
      iterator_range<Stmt/*P*/> S = C.children();
      if (((StmtIterator)S.begin()).$eq(((StmtIterator)S.end()))) {
        return StmtError();
      }
      // All associated statements must be '#pragma omp section' except for
      // the first one.
      for (Stmt /*P*/ SectionStmt : llvm.make_range(std.next(((StmtIterator)S.begin())), ((StmtIterator)S.end()))) {
        if (!(SectionStmt != null) || !isa_OMPSectionDirective(SectionStmt)) {
          if ((SectionStmt != null)) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($c$.track($this().Diag(SectionStmt.getLocStart(), 
                  diag.err_omp_sections_substmt_not_section)));
            } finally {
              $c$.$destroy();
            }
          }
          return StmtError();
        }
        cast_OMPSectionDirective(SectionStmt).
            setHasCancel(((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).isCancelRegion());
      }
    } else {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track($this().Diag(AStmt.getLocStart(), diag.err_omp_sections_not_compound_stmt)));
        return StmtError();
      } finally {
        $c$.$destroy();
      }
    }
  }
  
  $this().getCurFunction().setHasBranchProtectedScope();
  
  return new ActionResultTTrue<Stmt /*P*/ >(JD$T.INSTANCE, OMPSectionsDirective.Create($this().Context, new SourceLocation(StartLoc), new SourceLocation(EndLoc), new ArrayRef<OMPClause /*P*/ >(Clauses), AStmt, 
          ((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).isCancelRegion()));
}

/// \brief Called on well-formed '\#pragma omp section' after parsing of the
/// associated statement.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnOpenMPSectionDirective">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 5624,
 FQN="clang::Sema::ActOnOpenMPSectionDirective", NM="_ZN5clang4Sema27ActOnOpenMPSectionDirectiveEPNS_4StmtENS_14SourceLocationES3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4Sema27ActOnOpenMPSectionDirectiveEPNS_4StmtENS_14SourceLocationES3_")
//</editor-fold>
public final ActionResultTTrue<Stmt /*P*/ > ActOnOpenMPSectionDirective(Stmt /*P*/ AStmt, 
                           SourceLocation StartLoc, 
                           SourceLocation EndLoc) {
  if (!(AStmt != null)) {
    return StmtError();
  }
  assert (isa_CapturedStmt(AStmt)) : "Captured statement expected";
  
  $this().getCurFunction().setHasBranchProtectedScope();
  ((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).setParentCancelRegion(((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).isCancelRegion());
  
  return new ActionResultTTrue<Stmt /*P*/ >(JD$T.INSTANCE, OMPSectionDirective.Create($this().Context, new SourceLocation(StartLoc), new SourceLocation(EndLoc), AStmt, 
          ((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).isCancelRegion()));
}

/// \brief Called on well-formed '\#pragma omp single' after parsing of the
/// associated statement.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnOpenMPSingleDirective">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 5639,
 FQN="clang::Sema::ActOnOpenMPSingleDirective", NM="_ZN5clang4Sema26ActOnOpenMPSingleDirectiveEN4llvm8ArrayRefIPNS_9OMPClauseEEEPNS_4StmtENS_14SourceLocationES8_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4Sema26ActOnOpenMPSingleDirectiveEN4llvm8ArrayRefIPNS_9OMPClauseEEEPNS_4StmtENS_14SourceLocationES8_")
//</editor-fold>
public final ActionResultTTrue<Stmt /*P*/ > ActOnOpenMPSingleDirective(ArrayRef<OMPClause /*P*/ > Clauses, 
                          Stmt /*P*/ AStmt, 
                          SourceLocation StartLoc, 
                          SourceLocation EndLoc) {
  if (!(AStmt != null)) {
    return StmtError();
  }
  assert (isa_CapturedStmt(AStmt)) : "Captured statement expected";
  
  $this().getCurFunction().setHasBranchProtectedScope();
  
  // OpenMP [2.7.3, single Construct, Restrictions]
  // The copyprivate clause must not be used with the nowait clause.
  OMPClause /*P*/ Nowait = null;
  OMPClause /*P*/ Copyprivate = null;
  for (OMPClause /*P*/ Clause : Clauses) {
    if (Clause.getClauseKind() == OpenMPClauseKind.OMPC_nowait) {
      Nowait = Clause;
    } else if (Clause.getClauseKind() == OpenMPClauseKind.OMPC_copyprivate) {
      Copyprivate = Clause;
    }
    if ((Copyprivate != null) && (Nowait != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track($this().Diag(Copyprivate.getLocStart(), 
            diag.err_omp_single_copyprivate_with_nowait)));
        $c$.clean($c$.track($this().Diag(Nowait.getLocStart(), diag.note_omp_nowait_clause_here)));
        return StmtError();
      } finally {
        $c$.$destroy();
      }
    }
  }
  
  return new ActionResultTTrue<Stmt /*P*/ >(JD$T.INSTANCE, OMPSingleDirective.Create($this().Context, new SourceLocation(StartLoc), new SourceLocation(EndLoc), new ArrayRef<OMPClause /*P*/ >(Clauses), AStmt));
}

/// \brief Called on well-formed '\#pragma omp master' after parsing of the
/// associated statement.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnOpenMPMasterDirective">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 5670,
 FQN="clang::Sema::ActOnOpenMPMasterDirective", NM="_ZN5clang4Sema26ActOnOpenMPMasterDirectiveEPNS_4StmtENS_14SourceLocationES3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4Sema26ActOnOpenMPMasterDirectiveEPNS_4StmtENS_14SourceLocationES3_")
//</editor-fold>
public final ActionResultTTrue<Stmt /*P*/ > ActOnOpenMPMasterDirective(Stmt /*P*/ AStmt, 
                          SourceLocation StartLoc, 
                          SourceLocation EndLoc) {
  if (!(AStmt != null)) {
    return StmtError();
  }
  assert (isa_CapturedStmt(AStmt)) : "Captured statement expected";
  
  $this().getCurFunction().setHasBranchProtectedScope();
  
  return new ActionResultTTrue<Stmt /*P*/ >(JD$T.INSTANCE, OMPMasterDirective.Create($this().Context, new SourceLocation(StartLoc), new SourceLocation(EndLoc), AStmt));
}

/// \brief Called on well-formed '\#pragma omp critical' after parsing of the
/// associated statement.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnOpenMPCriticalDirective">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 5683,
 FQN="clang::Sema::ActOnOpenMPCriticalDirective", NM="_ZN5clang4Sema28ActOnOpenMPCriticalDirectiveERKNS_19DeclarationNameInfoEN4llvm8ArrayRefIPNS_9OMPClauseEEEPNS_4StmtENS_14SourceLocationESB_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4Sema28ActOnOpenMPCriticalDirectiveERKNS_19DeclarationNameInfoEN4llvm8ArrayRefIPNS_9OMPClauseEEEPNS_4StmtENS_14SourceLocationESB_")
//</editor-fold>
public final ActionResultTTrue<Stmt /*P*/ > ActOnOpenMPCriticalDirective(final /*const*/ DeclarationNameInfo /*&*/ DirName, ArrayRef<OMPClause /*P*/ > Clauses, 
                            Stmt /*P*/ AStmt, SourceLocation StartLoc, SourceLocation EndLoc) {
  if (!(AStmt != null)) {
    return StmtError();
  }
  assert (isa_CapturedStmt(AStmt)) : "Captured statement expected";
  
  boolean ErrorFound = false;
  APSInt Hint/*J*/= new APSInt();
  SourceLocation HintLoc/*J*/= new SourceLocation();
  boolean DependentHint = false;
  for (OMPClause /*P*/ C : Clauses) {
    if (C.getClauseKind() == OpenMPClauseKind.OMPC_hint) {
      if (!DirName.getName().$bool()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag(C.getLocStart(), diag.err_omp_hint_clause_no_name)));
          ErrorFound = true;
        } finally {
          $c$.$destroy();
        }
      }
      Expr /*P*/ E = cast_OMPHintClause(C).getHint();
      if (E.isTypeDependent() || E.isValueDependent()
         || E.isInstantiationDependent()) {
        DependentHint = true;
      } else {
        Hint.$assignMove(E.EvaluateKnownConstInt($this().Context));
        HintLoc.$assignMove(C.getLocStart());
      }
    }
  }
  if (ErrorFound) {
    return StmtError();
  }
  pair<OMPCriticalDirective /*P*/ , APSInt> Pair = ((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).getCriticalWithHint(DirName);
  if ((Pair.first != null) && DirName.getName().$bool() && !DependentHint) {
    if (APSInt.compareValues(Hint, Pair.second) != 0) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track($this().Diag(new SourceLocation(StartLoc), diag.err_omp_critical_with_hint)));
        if (HintLoc.isValid()) {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(HintLoc), diag.note_omp_critical_hint_here)), 
                  0), Hint.__toString(/*Radix=*/ 10, /*Signed=*/ false)));
        } else {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(StartLoc), diag.note_omp_critical_no_hint)), 0));
        }
        {
          /*const*/ OMPHintClause /*P*/ C = Pair.first.<OMPHintClause>getSingleClause(OMPHintClause.class);
          if ((C != null)) {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(C.getLocStart(), diag.note_omp_critical_hint_here)), 
                    1), 
                C.getHint().EvaluateKnownConstInt($this().Context).__toString(/*Radix=*/ 10, /*Signed=*/ false)));
          } else {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Pair.first.getLocStart(), diag.note_omp_critical_no_hint)), 1));
          }
        }
      } finally {
        $c$.$destroy();
      }
    }
  }
  
  $this().getCurFunction().setHasBranchProtectedScope();
  
  OMPCriticalDirective /*P*/ Dir = OMPCriticalDirective.Create($this().Context, DirName, new SourceLocation(StartLoc), new SourceLocation(EndLoc), 
      new ArrayRef<OMPClause /*P*/ >(Clauses), AStmt);
  if (!(Pair.first != null) && DirName.getName().$bool() && !DependentHint) {
    ((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).addCriticalWithHint(Dir, new APSInt(Hint));
  }
  return new ActionResultTTrue<Stmt /*P*/ >(JD$T.INSTANCE, Dir);
}

/// \brief Called on well-formed '\#pragma omp parallel for' after parsing
/// of the  associated statement.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnOpenMPParallelForDirective">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 5741,
 FQN="clang::Sema::ActOnOpenMPParallelForDirective", NM="_ZN5clang4Sema31ActOnOpenMPParallelForDirectiveEN4llvm8ArrayRefIPNS_9OMPClauseEEEPNS_4StmtENS_14SourceLocationES8_RNS1_8DenseMapIPNS_9ValueDeclEPNS_4ExprENS1_12DenseMapInfoISB_EENS1_6detail12DenseMapPairISB_SD_EEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4Sema31ActOnOpenMPParallelForDirectiveEN4llvm8ArrayRefIPNS_9OMPClauseEEEPNS_4StmtENS_14SourceLocationES8_RNS1_8DenseMapIPNS_9ValueDeclEPNS_4ExprENS1_12DenseMapInfoISB_EENS1_6detail12DenseMapPairISB_SD_EEEE")
//</editor-fold>
public final ActionResultTTrue<Stmt /*P*/ > ActOnOpenMPParallelForDirective(ArrayRef<OMPClause /*P*/ > Clauses, Stmt /*P*/ AStmt, SourceLocation StartLoc, 
                               SourceLocation EndLoc, 
                               final DenseMap<ValueDecl /*P*/ , Expr /*P*/ > /*&*/ VarsWithImplicitDSA) {
  OMPLoopDirective.HelperExprs B = null;
  try {
    if (!(AStmt != null)) {
      return StmtError();
    }
    
    CapturedStmt /*P*/ CS = cast_CapturedStmt(AStmt);
    // 1.2.2 OpenMP Language Terminology
    // Structured block - An executable statement with a single entry at the
    // top and a single exit at the bottom.
    // The point of exit cannot be a branch out of the structured block.
    // longjmp() and throw() must not violate the entry/exit criteria.
    CS.getCapturedDecl().setNothrow();
    
    B/*J*/= new OMPLoopDirective.HelperExprs();
    // In presence of clause 'collapse' or 'ordered' with number of loops, it will
    // define the nested loops number.
    /*uint*/int NestedLoopCount = CheckOpenMPLoop(OpenMPDirectiveKind.OMPD_parallel_for, getCollapseNumberExpr(new ArrayRef<OMPClause /*P*/ >(Clauses)), 
        getOrderedNumberExpr(new ArrayRef<OMPClause /*P*/ >(Clauses)), AStmt, /*Deref*/$this(), $Deref(((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack))), 
        VarsWithImplicitDSA, B);
    if (NestedLoopCount == 0) {
      return StmtError();
    }
    assert (($this().CurContext.isDependentContext() || B.builtAll())) : "omp parallel for loop exprs were not built";
    if (!$this().CurContext.isDependentContext()) {
      // Finalize the clauses that need pre-built expressions for CodeGen.
      for (OMPClause /*P*/ C : Clauses) {
        {
          OMPLinearClause /*P*/ LC = dyn_cast_OMPLinearClause(C);
          if ((LC != null)) {
            if (FinishOpenMPLinearClause($Deref(LC), cast_DeclRefExpr(B.IterationVarRef), 
                B.NumIterations, /*Deref*/$this(), $this().CurScope, 
                ((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)))) {
              return StmtError();
            }
          }
        }
      }
    }
    
    $this().getCurFunction().setHasBranchProtectedScope();
    return new ActionResultTTrue<Stmt /*P*/ >(JD$T.INSTANCE, OMPParallelForDirective.Create($this().Context, new SourceLocation(StartLoc), new SourceLocation(EndLoc), 
            NestedLoopCount, new ArrayRef<OMPClause /*P*/ >(Clauses), AStmt, B, 
            ((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).isCancelRegion()));
  } finally {
    if (B != null) { B.$destroy(); }
  }
}

/// \brief Called on well-formed '\#pragma omp parallel for simd' after
/// parsing of the  associated statement.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnOpenMPParallelForSimdDirective">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 5786,
 FQN="clang::Sema::ActOnOpenMPParallelForSimdDirective", NM="_ZN5clang4Sema35ActOnOpenMPParallelForSimdDirectiveEN4llvm8ArrayRefIPNS_9OMPClauseEEEPNS_4StmtENS_14SourceLocationES8_RNS1_8DenseMapIPNS_9ValueDeclEPNS_4ExprENS1_12DenseMapInfoISB_EENS1_6detail12DenseMapPairISB_SD_EEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4Sema35ActOnOpenMPParallelForSimdDirectiveEN4llvm8ArrayRefIPNS_9OMPClauseEEEPNS_4StmtENS_14SourceLocationES8_RNS1_8DenseMapIPNS_9ValueDeclEPNS_4ExprENS1_12DenseMapInfoISB_EENS1_6detail12DenseMapPairISB_SD_EEEE")
//</editor-fold>
public final ActionResultTTrue<Stmt /*P*/ > ActOnOpenMPParallelForSimdDirective(ArrayRef<OMPClause /*P*/ > Clauses, Stmt /*P*/ AStmt, SourceLocation StartLoc, 
                                   SourceLocation EndLoc, 
                                   final DenseMap<ValueDecl /*P*/ , Expr /*P*/ > /*&*/ VarsWithImplicitDSA) {
  OMPLoopDirective.HelperExprs B = null;
  try {
    if (!(AStmt != null)) {
      return StmtError();
    }
    
    CapturedStmt /*P*/ CS = cast_CapturedStmt(AStmt);
    // 1.2.2 OpenMP Language Terminology
    // Structured block - An executable statement with a single entry at the
    // top and a single exit at the bottom.
    // The point of exit cannot be a branch out of the structured block.
    // longjmp() and throw() must not violate the entry/exit criteria.
    CS.getCapturedDecl().setNothrow();
    
    B/*J*/= new OMPLoopDirective.HelperExprs();
    // In presence of clause 'collapse' or 'ordered' with number of loops, it will
    // define the nested loops number.
    /*uint*/int NestedLoopCount = CheckOpenMPLoop(OpenMPDirectiveKind.OMPD_parallel_for_simd, getCollapseNumberExpr(new ArrayRef<OMPClause /*P*/ >(Clauses)), 
        getOrderedNumberExpr(new ArrayRef<OMPClause /*P*/ >(Clauses)), AStmt, /*Deref*/$this(), $Deref(((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack))), 
        VarsWithImplicitDSA, B);
    if (NestedLoopCount == 0) {
      return StmtError();
    }
    if (!$this().CurContext.isDependentContext()) {
      // Finalize the clauses that need pre-built expressions for CodeGen.
      for (OMPClause /*P*/ C : Clauses) {
        {
          OMPLinearClause /*P*/ LC = dyn_cast_OMPLinearClause(C);
          if ((LC != null)) {
            if (FinishOpenMPLinearClause($Deref(LC), cast_DeclRefExpr(B.IterationVarRef), 
                B.NumIterations, /*Deref*/$this(), $this().CurScope, 
                ((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)))) {
              return StmtError();
            }
          }
        }
      }
    }
    if (checkSimdlenSafelenSpecified(/*Deref*/$this(), new ArrayRef<OMPClause /*P*/ >(Clauses))) {
      return StmtError();
    }
    
    $this().getCurFunction().setHasBranchProtectedScope();
    return new ActionResultTTrue<Stmt /*P*/ >(JD$T.INSTANCE, OMPParallelForSimdDirective.Create($this().Context, new SourceLocation(StartLoc), new SourceLocation(EndLoc), NestedLoopCount, new ArrayRef<OMPClause /*P*/ >(Clauses), AStmt, B));
  } finally {
    if (B != null) { B.$destroy(); }
  }
}

/// \brief Called on well-formed '\#pragma omp parallel sections' after
/// parsing of the  associated statement.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnOpenMPParallelSectionsDirective">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 5830,
 FQN="clang::Sema::ActOnOpenMPParallelSectionsDirective", NM="_ZN5clang4Sema36ActOnOpenMPParallelSectionsDirectiveEN4llvm8ArrayRefIPNS_9OMPClauseEEEPNS_4StmtENS_14SourceLocationES8_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4Sema36ActOnOpenMPParallelSectionsDirectiveEN4llvm8ArrayRefIPNS_9OMPClauseEEEPNS_4StmtENS_14SourceLocationES8_")
//</editor-fold>
public final ActionResultTTrue<Stmt /*P*/ > ActOnOpenMPParallelSectionsDirective(ArrayRef<OMPClause /*P*/ > Clauses, 
                                    Stmt /*P*/ AStmt, SourceLocation StartLoc, 
                                    SourceLocation EndLoc) {
  if (!(AStmt != null)) {
    return StmtError();
  }
  assert (isa_CapturedStmt(AStmt)) : "Captured statement expected";
  Stmt /*P*/ BaseStmt = AStmt;
  {
    CapturedStmt /*P*/ CS;
    while (((/*P*/ CS = dyn_cast_or_null_CapturedStmt(BaseStmt)) != null)) {
      BaseStmt = CS.getCapturedStmt();
    }
  }
  {
    CompoundStmt /*P*/ C = dyn_cast_or_null_CompoundStmt(BaseStmt);
    if ((C != null)) {
      iterator_range<Stmt/*P*/> S = C.children();
      if (((StmtIterator)S.begin()).$eq(((StmtIterator)S.end()))) {
        return StmtError();
      }
      // All associated statements must be '#pragma omp section' except for
      // the first one.
      for (Stmt /*P*/ SectionStmt : llvm.make_range(std.next(((StmtIterator)S.begin())), ((StmtIterator)S.end()))) {
        if (!(SectionStmt != null) || !isa_OMPSectionDirective(SectionStmt)) {
          if ((SectionStmt != null)) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($c$.track($this().Diag(SectionStmt.getLocStart(), 
                  diag.err_omp_parallel_sections_substmt_not_section)));
            } finally {
              $c$.$destroy();
            }
          }
          return StmtError();
        }
        cast_OMPSectionDirective(SectionStmt).
            setHasCancel(((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).isCancelRegion());
      }
    } else {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track($this().Diag(AStmt.getLocStart(), 
            diag.err_omp_parallel_sections_not_compound_stmt)));
        return StmtError();
      } finally {
        $c$.$destroy();
      }
    }
  }
  
  $this().getCurFunction().setHasBranchProtectedScope();
  
  return new ActionResultTTrue<Stmt /*P*/ >(JD$T.INSTANCE, OMPParallelSectionsDirective.Create($this().Context, new SourceLocation(StartLoc), new SourceLocation(EndLoc), new ArrayRef<OMPClause /*P*/ >(Clauses), AStmt, ((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).isCancelRegion()));
}

/// \brief Called on well-formed '\#pragma omp task' after parsing of the
/// associated statement.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnOpenMPTaskDirective">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 5869,
 FQN="clang::Sema::ActOnOpenMPTaskDirective", NM="_ZN5clang4Sema24ActOnOpenMPTaskDirectiveEN4llvm8ArrayRefIPNS_9OMPClauseEEEPNS_4StmtENS_14SourceLocationES8_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4Sema24ActOnOpenMPTaskDirectiveEN4llvm8ArrayRefIPNS_9OMPClauseEEEPNS_4StmtENS_14SourceLocationES8_")
//</editor-fold>
public final ActionResultTTrue<Stmt /*P*/ > ActOnOpenMPTaskDirective(ArrayRef<OMPClause /*P*/ > Clauses, 
                        Stmt /*P*/ AStmt, SourceLocation StartLoc, 
                        SourceLocation EndLoc) {
  if (!(AStmt != null)) {
    return StmtError();
  }
  
  CapturedStmt /*P*/ CS = cast_CapturedStmt(AStmt);
  // 1.2.2 OpenMP Language Terminology
  // Structured block - An executable statement with a single entry at the
  // top and a single exit at the bottom.
  // The point of exit cannot be a branch out of the structured block.
  // longjmp() and throw() must not violate the entry/exit criteria.
  CS.getCapturedDecl().setNothrow();
  
  $this().getCurFunction().setHasBranchProtectedScope();
  
  return new ActionResultTTrue<Stmt /*P*/ >(JD$T.INSTANCE, OMPTaskDirective.Create($this().Context, new SourceLocation(StartLoc), new SourceLocation(EndLoc), new ArrayRef<OMPClause /*P*/ >(Clauses), AStmt, 
          ((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).isCancelRegion()));
}

/// \brief Called on well-formed '\#pragma omp taskyield'.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnOpenMPTaskyieldDirective">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 5889,
 FQN="clang::Sema::ActOnOpenMPTaskyieldDirective", NM="_ZN5clang4Sema29ActOnOpenMPTaskyieldDirectiveENS_14SourceLocationES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4Sema29ActOnOpenMPTaskyieldDirectiveENS_14SourceLocationES1_")
//</editor-fold>
public final ActionResultTTrue<Stmt /*P*/ > ActOnOpenMPTaskyieldDirective(SourceLocation StartLoc, 
                             SourceLocation EndLoc) {
  return new ActionResultTTrue<Stmt /*P*/ >(JD$T.INSTANCE, OMPTaskyieldDirective.Create($this().Context, new SourceLocation(StartLoc), new SourceLocation(EndLoc)));
}

/// \brief Called on well-formed '\#pragma omp barrier'.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnOpenMPBarrierDirective">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 5894,
 FQN="clang::Sema::ActOnOpenMPBarrierDirective", NM="_ZN5clang4Sema27ActOnOpenMPBarrierDirectiveENS_14SourceLocationES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4Sema27ActOnOpenMPBarrierDirectiveENS_14SourceLocationES1_")
//</editor-fold>
public final ActionResultTTrue<Stmt /*P*/ > ActOnOpenMPBarrierDirective(SourceLocation StartLoc, 
                           SourceLocation EndLoc) {
  return new ActionResultTTrue<Stmt /*P*/ >(JD$T.INSTANCE, OMPBarrierDirective.Create($this().Context, new SourceLocation(StartLoc), new SourceLocation(EndLoc)));
}

/// \brief Called on well-formed '\#pragma omp taskwait'.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnOpenMPTaskwaitDirective">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 5899,
 FQN="clang::Sema::ActOnOpenMPTaskwaitDirective", NM="_ZN5clang4Sema28ActOnOpenMPTaskwaitDirectiveENS_14SourceLocationES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4Sema28ActOnOpenMPTaskwaitDirectiveENS_14SourceLocationES1_")
//</editor-fold>
public final ActionResultTTrue<Stmt /*P*/ > ActOnOpenMPTaskwaitDirective(SourceLocation StartLoc, 
                            SourceLocation EndLoc) {
  return new ActionResultTTrue<Stmt /*P*/ >(JD$T.INSTANCE, OMPTaskwaitDirective.Create($this().Context, new SourceLocation(StartLoc), new SourceLocation(EndLoc)));
}

/// \brief Called on well-formed '\#pragma omp taskgroup'.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnOpenMPTaskgroupDirective">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 5904,
 FQN="clang::Sema::ActOnOpenMPTaskgroupDirective", NM="_ZN5clang4Sema29ActOnOpenMPTaskgroupDirectiveEPNS_4StmtENS_14SourceLocationES3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4Sema29ActOnOpenMPTaskgroupDirectiveEPNS_4StmtENS_14SourceLocationES3_")
//</editor-fold>
public final ActionResultTTrue<Stmt /*P*/ > ActOnOpenMPTaskgroupDirective(Stmt /*P*/ AStmt, 
                             SourceLocation StartLoc, 
                             SourceLocation EndLoc) {
  if (!(AStmt != null)) {
    return StmtError();
  }
  assert (isa_CapturedStmt(AStmt)) : "Captured statement expected";
  
  $this().getCurFunction().setHasBranchProtectedScope();
  
  return new ActionResultTTrue<Stmt /*P*/ >(JD$T.INSTANCE, OMPTaskgroupDirective.Create($this().Context, new SourceLocation(StartLoc), new SourceLocation(EndLoc), AStmt));
}

/// \brief Called on well-formed '\#pragma omp flush'.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnOpenMPFlushDirective">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 5917,
 FQN="clang::Sema::ActOnOpenMPFlushDirective", NM="_ZN5clang4Sema25ActOnOpenMPFlushDirectiveEN4llvm8ArrayRefIPNS_9OMPClauseEEENS_14SourceLocationES6_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4Sema25ActOnOpenMPFlushDirectiveEN4llvm8ArrayRefIPNS_9OMPClauseEEENS_14SourceLocationES6_")
//</editor-fold>
public final ActionResultTTrue<Stmt /*P*/ > ActOnOpenMPFlushDirective(ArrayRef<OMPClause /*P*/ > Clauses, 
                         SourceLocation StartLoc, 
                         SourceLocation EndLoc) {
  assert ($lesseq_uint(Clauses.size(), 1)) : "Extra clauses in flush directive";
  return new ActionResultTTrue<Stmt /*P*/ >(JD$T.INSTANCE, OMPFlushDirective.Create($this().Context, new SourceLocation(StartLoc), new SourceLocation(EndLoc), new ArrayRef<OMPClause /*P*/ >(Clauses)));
}

/// \brief Called on well-formed '\#pragma omp ordered' after parsing of the
/// associated statement.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnOpenMPOrderedDirective">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 5924,
 FQN="clang::Sema::ActOnOpenMPOrderedDirective", NM="_ZN5clang4Sema27ActOnOpenMPOrderedDirectiveEN4llvm8ArrayRefIPNS_9OMPClauseEEEPNS_4StmtENS_14SourceLocationES8_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4Sema27ActOnOpenMPOrderedDirectiveEN4llvm8ArrayRefIPNS_9OMPClauseEEEPNS_4StmtENS_14SourceLocationES8_")
//</editor-fold>
public final ActionResultTTrue<Stmt /*P*/ > ActOnOpenMPOrderedDirective(ArrayRef<OMPClause /*P*/ > Clauses, 
                           Stmt /*P*/ AStmt, 
                           SourceLocation StartLoc, 
                           SourceLocation EndLoc) {
  OMPClause /*P*/ DependFound = null;
  OMPClause /*P*/ DependSourceClause = null;
  OMPClause /*P*/ DependSinkClause = null;
  boolean ErrorFound = false;
  OMPThreadsClause /*P*/ TC = null;
  OMPSIMDClause /*P*/ SC = null;
  for (OMPClause /*P*/ C : Clauses) {
    {
      OMPDependClause /*P*/ DC = dyn_cast_OMPDependClause(C);
      if ((DC != null)) {
        DependFound = C;
        if (DC.getDependencyKind() == OpenMPDependClauseKind.OMPC_DEPEND_source) {
          if ((DependSourceClause != null)) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(C.getLocStart(), diag.err_omp_more_one_clause)), 
                          getOpenMPDirectiveName(OpenMPDirectiveKind.OMPD_ordered)), 
                      getOpenMPClauseName(OpenMPClauseKind.OMPC_depend)), 2));
              ErrorFound = true;
            } finally {
              $c$.$destroy();
            }
          } else {
            DependSourceClause = C;
          }
          if ((DependSinkClause != null)) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(C.getLocStart(), diag.err_omp_depend_sink_source_not_allowed)), 
                  0));
              ErrorFound = true;
            } finally {
              $c$.$destroy();
            }
          }
        } else if (DC.getDependencyKind() == OpenMPDependClauseKind.OMPC_DEPEND_sink) {
          if ((DependSourceClause != null)) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(C.getLocStart(), diag.err_omp_depend_sink_source_not_allowed)), 
                  1));
              ErrorFound = true;
            } finally {
              $c$.$destroy();
            }
          }
          DependSinkClause = C;
        }
      } else if (C.getClauseKind() == OpenMPClauseKind.OMPC_threads) {
        TC = cast_OMPThreadsClause(C);
      } else if (C.getClauseKind() == OpenMPClauseKind.OMPC_simd) {
        SC = cast_OMPSIMDClause(C);
      }
    }
  }
  if (!ErrorFound && !(SC != null)
     && isOpenMPSimdDirective(((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).getParentDirective())) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // OpenMP [2.8.1,simd Construct, Restrictions]
      // An ordered construct with the simd clause is the only OpenMP construct
      // that can appear in the simd region.
      $c$.clean($c$.track($this().Diag(new SourceLocation(StartLoc), diag.err_omp_prohibited_region_simd)));
      ErrorFound = true;
    } finally {
      $c$.$destroy();
    }
  } else if ((DependFound != null) && ((TC != null) || (SC != null))) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(DependFound.getLocStart(), diag.err_omp_depend_clause_thread_simd)), 
          getOpenMPClauseName((TC != null) ? TC.getClauseKind() : SC.getClauseKind())));
      ErrorFound = true;
    } finally {
      $c$.$destroy();
    }
  } else if ((DependFound != null) && !(((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).getParentOrderedRegionParam() != null)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track($this().Diag(DependFound.getLocStart(), 
          diag.err_omp_ordered_directive_without_param)));
      ErrorFound = true;
    } finally {
      $c$.$destroy();
    }
  } else if ((TC != null) || Clauses.empty()) {
    {
      Expr /*P*/ Param = ((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).getParentOrderedRegionParam();
      if ((Param != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          SourceLocation ErrLoc = (TC != null) ? TC.getLocStart() : new SourceLocation(StartLoc);
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(ErrLoc), diag.err_omp_ordered_directive_with_param)), 
              (TC != (OMPThreadsClause /*P*/ )null)));
          $c$.clean($c$.track($this().Diag(Param.getLocStart(), diag.note_omp_ordered_param)));
          ErrorFound = true;
        } finally {
          $c$.$destroy();
        }
      }
    }
  }
  if ((!(AStmt != null) && !(DependFound != null)) || ErrorFound) {
    return StmtError();
  }
  if ((AStmt != null)) {
    assert (isa_CapturedStmt(AStmt)) : "Captured statement expected";
    
    $this().getCurFunction().setHasBranchProtectedScope();
  }
  
  return new ActionResultTTrue<Stmt /*P*/ >(JD$T.INSTANCE, OMPOrderedDirective.Create($this().Context, new SourceLocation(StartLoc), new SourceLocation(EndLoc), new ArrayRef<OMPClause /*P*/ >(Clauses), AStmt));
}

/// \brief Called on well-formed '\#pragma omp atomic' after parsing of the
/// associated statement.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnOpenMPAtomicDirective">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 6239,
 FQN="clang::Sema::ActOnOpenMPAtomicDirective", NM="_ZN5clang4Sema26ActOnOpenMPAtomicDirectiveEN4llvm8ArrayRefIPNS_9OMPClauseEEEPNS_4StmtENS_14SourceLocationES8_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4Sema26ActOnOpenMPAtomicDirectiveEN4llvm8ArrayRefIPNS_9OMPClauseEEEPNS_4StmtENS_14SourceLocationES8_")
//</editor-fold>
public final ActionResultTTrue<Stmt /*P*/ > ActOnOpenMPAtomicDirective(ArrayRef<OMPClause /*P*/ > Clauses, 
                          Stmt /*P*/ AStmt, 
                          SourceLocation StartLoc, 
                          SourceLocation EndLoc) {
  if (!(AStmt != null)) {
    return StmtError();
  }
  
  CapturedStmt /*P*/ CS = cast_CapturedStmt(AStmt);
  // 1.2.2 OpenMP Language Terminology
  // Structured block - An executable statement with a single entry at the
  // top and a single exit at the bottom.
  // The point of exit cannot be a branch out of the structured block.
  // longjmp() and throw() must not violate the entry/exit criteria.
  OpenMPClauseKind AtomicKind = OpenMPClauseKind.OMPC_unknown;
  SourceLocation AtomicKindLoc/*J*/= new SourceLocation();
  for (OMPClause /*P*/ C : Clauses) {
    if (C.getClauseKind() == OpenMPClauseKind.OMPC_read || C.getClauseKind() == OpenMPClauseKind.OMPC_write
       || C.getClauseKind() == OpenMPClauseKind.OMPC_update
       || C.getClauseKind() == OpenMPClauseKind.OMPC_capture) {
      if (AtomicKind != OpenMPClauseKind.OMPC_unknown) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(C.getLocStart(), diag.err_omp_atomic_several_clauses)), 
              new SourceRange(C.getLocStart(), C.getLocEnd())));
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(AtomicKindLoc), diag.note_omp_atomic_previous_clause)), 
              getOpenMPClauseName(AtomicKind)));
        } finally {
          $c$.$destroy();
        }
      } else {
        AtomicKind = C.getClauseKind();
        AtomicKindLoc.$assignMove(C.getLocStart());
      }
    }
  }
  
  Stmt /*P*/ Body = CS.getCapturedStmt();
  {
    ExprWithCleanups /*P*/ EWC = dyn_cast_ExprWithCleanups(Body);
    if ((EWC != null)) {
      Body = EWC.getSubExpr();
    }
  }
  
  Expr /*P*/ X = null;
  Expr /*P*/ V = null;
  Expr /*P*/ E = null;
  Expr /*P*/ UE = null;
  boolean IsXLHSInRHSPart = false;
  boolean IsPostfixUpdate = false;
  // OpenMP [2.12.6, atomic Construct]
  // In the next expressions:
  // * x and v (as applicable) are both l-value expressions with scalar type.
  // * During the execution of an atomic region, multiple syntactic
  // occurrences of x must designate the same storage location.
  // * Neither of v and expr (as applicable) may access the storage location
  // designated by x.
  // * Neither of x and expr (as applicable) may access the storage location
  // designated by v.
  // * expr is an expression with scalar type.
  // * binop is one of +, *, -, /, &, ^, |, <<, or >>.
  // * binop, binop=, ++, and -- are not overloaded operators.
  // * The expression x binop expr must be numerically equivalent to x binop
  // (expr). This requirement is satisfied if the operators in expr have
  // precedence greater than binop, or by using parentheses around expr or
  // subexpressions of expr.
  // * The expression expr binop x must be numerically equivalent to (expr)
  // binop x. This requirement is satisfied if the operators in expr have
  // precedence equal to or greater than binop, or by using parentheses around
  // expr or subexpressions of expr.
  // * For forms that allow multiple occurrences of x, the number of times
  // that x is evaluated is unspecified.
  if (AtomicKind == OpenMPClauseKind.OMPC_read) {
    /*enum ANONYMOUS_INT_CONSTANTS {*/
      final /*uint*/int NotAnExpression = 0;
      final /*uint*/int NotAnAssignmentOp = NotAnExpression + 1;
      final /*uint*/int NotAScalarType = NotAnAssignmentOp + 1;
      final /*uint*/int NotAnLValue = NotAScalarType + 1;
      final /*uint*/int NoError = NotAnLValue + 1;
    /*}*//*Unnamed enum*//*uint*/int ErrorFound = NoError;
    SourceLocation ErrorLoc/*J*/= new SourceLocation();
    SourceLocation NoteLoc/*J*/= new SourceLocation();
    SourceRange ErrorRange/*J*/= new SourceRange();
    SourceRange NoteRange/*J*/= new SourceRange();
    {
      // If clause is read:
      //  v = x;
      Expr /*P*/ AtomicBody = dyn_cast_Expr(Body);
      if ((AtomicBody != null)) {
        BinaryOperator /*P*/ AtomicBinOp = dyn_cast_BinaryOperator(AtomicBody.IgnoreParenImpCasts());
        if ((AtomicBinOp != null) && AtomicBinOp.getOpcode() == BinaryOperatorKind.BO_Assign) {
          X = AtomicBinOp.getRHS().IgnoreParenImpCasts();
          V = AtomicBinOp.getLHS().IgnoreParenImpCasts();
          if ((X.isInstantiationDependent() || X.getType().$arrow().isScalarType())
             && (V.isInstantiationDependent() || V.getType().$arrow().isScalarType())) {
            if (!X.isLValue() || !V.isLValue()) {
              Expr /*P*/ NotLValueExpr = X.isLValue() ? V : X;
              ErrorFound = NotAnLValue;
              ErrorLoc.$assignMove(AtomicBinOp.getExprLoc());
              ErrorRange.$assignMove(AtomicBinOp.getSourceRange());
              NoteLoc.$assignMove(NotLValueExpr.getExprLoc());
              NoteRange.$assignMove(NotLValueExpr.getSourceRange());
            }
          } else if (!X.isInstantiationDependent()
             || !V.isInstantiationDependent()) {
            Expr /*P*/ NotScalarExpr = (X.isInstantiationDependent() || X.getType().$arrow().isScalarType()) ? V : X;
            ErrorFound = NotAScalarType;
            ErrorLoc.$assignMove(AtomicBinOp.getExprLoc());
            ErrorRange.$assignMove(AtomicBinOp.getSourceRange());
            NoteLoc.$assignMove(NotScalarExpr.getExprLoc());
            NoteRange.$assignMove(NotScalarExpr.getSourceRange());
          }
        } else if (!AtomicBody.isInstantiationDependent()) {
          ErrorFound = NotAnAssignmentOp;
          ErrorLoc.$assignMove(AtomicBody.getExprLoc());
          ErrorRange.$assignMove(AtomicBody.getSourceRange());
          NoteLoc.$assignMove((AtomicBinOp != null) ? AtomicBinOp.getOperatorLoc() : AtomicBody.getExprLoc());
          NoteRange.$assignMove((AtomicBinOp != null) ? AtomicBinOp.getSourceRange() : AtomicBody.getSourceRange());
        }
      } else {
        ErrorFound = NotAnExpression;
        NoteLoc.$assign(ErrorLoc.$assignMove(Body.getLocStart()));
        NoteRange.$assign(ErrorRange.$assignMove(new SourceRange(/*NO_COPY*/NoteLoc, /*NO_COPY*/NoteLoc)));
      }
    }
    if (ErrorFound != NoError) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(ErrorLoc), diag.err_omp_atomic_read_not_expression_statement)), 
            ErrorRange));
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(NoteLoc), diag.note_omp_atomic_read_write)), ErrorFound), 
            NoteRange));
        return StmtError();
      } finally {
        $c$.$destroy();
      }
    } else if ($this().CurContext.isDependentContext()) {
      V = X = null;
    }
  } else if (AtomicKind == OpenMPClauseKind.OMPC_write) {
    /*enum ANONYMOUS_INT_CONSTANTS {*/
      final /*uint*/int NotAnExpression = 0;
      final /*uint*/int NotAnAssignmentOp = NotAnExpression + 1;
      final /*uint*/int NotAScalarType = NotAnAssignmentOp + 1;
      final /*uint*/int NotAnLValue = NotAScalarType + 1;
      final /*uint*/int NoError = NotAnLValue + 1;
    /*}*//*Unnamed enum*//*uint*/int ErrorFound = NoError;
    SourceLocation ErrorLoc/*J*/= new SourceLocation();
    SourceLocation NoteLoc/*J*/= new SourceLocation();
    SourceRange ErrorRange/*J*/= new SourceRange();
    SourceRange NoteRange/*J*/= new SourceRange();
    {
      // If clause is write:
      //  x = expr;
      Expr /*P*/ AtomicBody = dyn_cast_Expr(Body);
      if ((AtomicBody != null)) {
        BinaryOperator /*P*/ AtomicBinOp = dyn_cast_BinaryOperator(AtomicBody.IgnoreParenImpCasts());
        if ((AtomicBinOp != null) && AtomicBinOp.getOpcode() == BinaryOperatorKind.BO_Assign) {
          X = AtomicBinOp.getLHS();
          E = AtomicBinOp.getRHS();
          if ((X.isInstantiationDependent() || X.getType().$arrow().isScalarType())
             && (E.isInstantiationDependent() || E.getType().$arrow().isScalarType())) {
            if (!X.isLValue()) {
              ErrorFound = NotAnLValue;
              ErrorLoc.$assignMove(AtomicBinOp.getExprLoc());
              ErrorRange.$assignMove(AtomicBinOp.getSourceRange());
              NoteLoc.$assignMove(X.getExprLoc());
              NoteRange.$assignMove(X.getSourceRange());
            }
          } else if (!X.isInstantiationDependent()
             || !E.isInstantiationDependent()) {
            Expr /*P*/ NotScalarExpr = (X.isInstantiationDependent() || X.getType().$arrow().isScalarType()) ? E : X;
            ErrorFound = NotAScalarType;
            ErrorLoc.$assignMove(AtomicBinOp.getExprLoc());
            ErrorRange.$assignMove(AtomicBinOp.getSourceRange());
            NoteLoc.$assignMove(NotScalarExpr.getExprLoc());
            NoteRange.$assignMove(NotScalarExpr.getSourceRange());
          }
        } else if (!AtomicBody.isInstantiationDependent()) {
          ErrorFound = NotAnAssignmentOp;
          ErrorLoc.$assignMove(AtomicBody.getExprLoc());
          ErrorRange.$assignMove(AtomicBody.getSourceRange());
          NoteLoc.$assignMove((AtomicBinOp != null) ? AtomicBinOp.getOperatorLoc() : AtomicBody.getExprLoc());
          NoteRange.$assignMove((AtomicBinOp != null) ? AtomicBinOp.getSourceRange() : AtomicBody.getSourceRange());
        }
      } else {
        ErrorFound = NotAnExpression;
        NoteLoc.$assign(ErrorLoc.$assignMove(Body.getLocStart()));
        NoteRange.$assign(ErrorRange.$assignMove(new SourceRange(/*NO_COPY*/NoteLoc, /*NO_COPY*/NoteLoc)));
      }
    }
    if (ErrorFound != NoError) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(ErrorLoc), diag.err_omp_atomic_write_not_expression_statement)), 
            ErrorRange));
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(NoteLoc), diag.note_omp_atomic_read_write)), ErrorFound), 
            NoteRange));
        return StmtError();
      } finally {
        $c$.$destroy();
      }
    } else if ($this().CurContext.isDependentContext()) {
      E = X = null;
    }
  } else if (AtomicKind == OpenMPClauseKind.OMPC_update || AtomicKind == OpenMPClauseKind.OMPC_unknown) {
    // If clause is update:
    //  x++;
    //  x--;
    //  ++x;
    //  --x;
    //  x binop= expr;
    //  x = x binop expr;
    //  x = expr binop x;
    OpenMPAtomicUpdateChecker Checker/*J*/= new OpenMPAtomicUpdateChecker(/*Deref*/$this());
    if (Checker.checkStatement(Body, (AtomicKind == OpenMPClauseKind.OMPC_update) ? diag.err_omp_atomic_update_not_expression_statement : diag.err_omp_atomic_not_expression_statement, 
        diag.note_omp_atomic_update)) {
      return StmtError();
    }
    if (!$this().CurContext.isDependentContext()) {
      E = Checker.getExpr();
      X = Checker.getX();
      UE = Checker.getUpdateExpr();
      IsXLHSInRHSPart = Checker.isXLHSInRHSPart();
    }
  } else if (AtomicKind == OpenMPClauseKind.OMPC_capture) {
    /*enum ANONYMOUS_INT_CONSTANTS {*/
      final /*uint*/int NotAnAssignmentOp = 0;
      final /*uint*/int NotACompoundStatement = NotAnAssignmentOp + 1;
      final /*uint*/int NotTwoSubstatements = NotACompoundStatement + 1;
      final /*uint*/int NotASpecificExpression = NotTwoSubstatements + 1;
      final /*uint*/int NoError = NotASpecificExpression + 1;
    /*}*//*Unnamed enum*//*uint*/int ErrorFound = NoError;
    SourceLocation ErrorLoc/*J*/= new SourceLocation();
    SourceLocation NoteLoc/*J*/= new SourceLocation();
    SourceRange ErrorRange/*J*/= new SourceRange();
    SourceRange NoteRange/*J*/= new SourceRange();
    {
      Expr /*P*/ AtomicBody = dyn_cast_Expr(Body);
      if ((AtomicBody != null)) {
        // If clause is a capture:
        //  v = x++;
        //  v = x--;
        //  v = ++x;
        //  v = --x;
        //  v = x binop= expr;
        //  v = x = x binop expr;
        //  v = x = expr binop x;
        BinaryOperator /*P*/ AtomicBinOp = dyn_cast_BinaryOperator(AtomicBody.IgnoreParenImpCasts());
        if ((AtomicBinOp != null) && AtomicBinOp.getOpcode() == BinaryOperatorKind.BO_Assign) {
          V = AtomicBinOp.getLHS();
          Body = AtomicBinOp.getRHS().IgnoreParenImpCasts();
          OpenMPAtomicUpdateChecker Checker/*J*/= new OpenMPAtomicUpdateChecker(/*Deref*/$this());
          if (Checker.checkStatement(Body, diag.err_omp_atomic_capture_not_expression_statement, 
              diag.note_omp_atomic_update)) {
            return StmtError();
          }
          E = Checker.getExpr();
          X = Checker.getX();
          UE = Checker.getUpdateExpr();
          IsXLHSInRHSPart = Checker.isXLHSInRHSPart();
          IsPostfixUpdate = Checker.isPostfixUpdate();
        } else if (!AtomicBody.isInstantiationDependent()) {
          ErrorLoc.$assignMove(AtomicBody.getExprLoc());
          ErrorRange.$assignMove(AtomicBody.getSourceRange());
          NoteLoc.$assignMove((AtomicBinOp != null) ? AtomicBinOp.getOperatorLoc() : AtomicBody.getExprLoc());
          NoteRange.$assignMove((AtomicBinOp != null) ? AtomicBinOp.getSourceRange() : AtomicBody.getSourceRange());
          ErrorFound = NotAnAssignmentOp;
        }
        if (ErrorFound != NoError) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(ErrorLoc), diag.err_omp_atomic_capture_not_expression_statement)), 
                ErrorRange));
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(NoteLoc), diag.note_omp_atomic_capture)), ErrorFound), NoteRange));
            return StmtError();
          } finally {
            $c$.$destroy();
          }
        } else if ($this().CurContext.isDependentContext()) {
          UE = V = E = X = null;
        }
      } else {
        {
          // If clause is a capture:
          //  { v = x; x = expr; }
          //  { v = x; x++; }
          //  { v = x; x--; }
          //  { v = x; ++x; }
          //  { v = x; --x; }
          //  { v = x; x binop= expr; }
          //  { v = x; x = x binop expr; }
          //  { v = x; x = expr binop x; }
          //  { x++; v = x; }
          //  { x--; v = x; }
          //  { ++x; v = x; }
          //  { --x; v = x; }
          //  { x binop= expr; v = x; }
          //  { x = x binop expr; v = x; }
          //  { x = expr binop x; v = x; }
          CompoundStmt /*P*/ CS$1 = dyn_cast_CompoundStmt(Body);
          if ((CS$1 != null)) {
            // Check that this is { expr1; expr2; }
            if (CS$1.size() == 2) {
              Stmt /*P*/ First = CS$1.body_front();
              Stmt /*P*/ Second = CS$1.body_back();
              {
                ExprWithCleanups /*P*/ EWC = dyn_cast_ExprWithCleanups(First);
                if ((EWC != null)) {
                  First = EWC.getSubExpr().IgnoreParenImpCasts();
                }
              }
              {
                ExprWithCleanups /*P*/ EWC = dyn_cast_ExprWithCleanups(Second);
                if ((EWC != null)) {
                  Second = EWC.getSubExpr().IgnoreParenImpCasts();
                }
              }
              // Need to find what subexpression is 'v' and what is 'x'.
              OpenMPAtomicUpdateChecker Checker/*J*/= new OpenMPAtomicUpdateChecker(/*Deref*/$this());
              boolean IsUpdateExprFound = !Checker.checkStatement(Second);
              BinaryOperator /*P*/ BinOp = null;
              if (IsUpdateExprFound) {
                BinOp = dyn_cast_BinaryOperator(First);
                IsUpdateExprFound = (BinOp != null) && BinOp.getOpcode() == BinaryOperatorKind.BO_Assign;
              }
              if (IsUpdateExprFound && !$this().CurContext.isDependentContext()) {
                //  { v = x; x++; }
                //  { v = x; x--; }
                //  { v = x; ++x; }
                //  { v = x; --x; }
                //  { v = x; x binop= expr; }
                //  { v = x; x = x binop expr; }
                //  { v = x; x = expr binop x; }
                // Check that the first expression has form v = x.
                Expr /*P*/ PossibleX = BinOp.getRHS().IgnoreParenImpCasts();
                FoldingSetNodeID XId/*J*/= new FoldingSetNodeID();
                FoldingSetNodeID PossibleXId/*J*/= new FoldingSetNodeID();
                Checker.getX().Profile(XId, $this().Context, /*Canonical=*/ true);
                PossibleX.Profile(PossibleXId, $this().Context, /*Canonical=*/ true);
                IsUpdateExprFound = XId.$eq(PossibleXId);
                if (IsUpdateExprFound) {
                  V = BinOp.getLHS();
                  X = Checker.getX();
                  E = Checker.getExpr();
                  UE = Checker.getUpdateExpr();
                  IsXLHSInRHSPart = Checker.isXLHSInRHSPart();
                  IsPostfixUpdate = true;
                }
              }
              if (!IsUpdateExprFound) {
                IsUpdateExprFound = !Checker.checkStatement(First);
                BinOp = null;
                if (IsUpdateExprFound) {
                  BinOp = dyn_cast_BinaryOperator(Second);
                  IsUpdateExprFound = (BinOp != null) && BinOp.getOpcode() == BinaryOperatorKind.BO_Assign;
                }
                if (IsUpdateExprFound && !$this().CurContext.isDependentContext()) {
                  //  { x++; v = x; }
                  //  { x--; v = x; }
                  //  { ++x; v = x; }
                  //  { --x; v = x; }
                  //  { x binop= expr; v = x; }
                  //  { x = x binop expr; v = x; }
                  //  { x = expr binop x; v = x; }
                  // Check that the second expression has form v = x.
                  Expr /*P*/ PossibleX = BinOp.getRHS().IgnoreParenImpCasts();
                  FoldingSetNodeID XId/*J*/= new FoldingSetNodeID();
                  FoldingSetNodeID PossibleXId/*J*/= new FoldingSetNodeID();
                  Checker.getX().Profile(XId, $this().Context, /*Canonical=*/ true);
                  PossibleX.Profile(PossibleXId, $this().Context, /*Canonical=*/ true);
                  IsUpdateExprFound = XId.$eq(PossibleXId);
                  if (IsUpdateExprFound) {
                    V = BinOp.getLHS();
                    X = Checker.getX();
                    E = Checker.getExpr();
                    UE = Checker.getUpdateExpr();
                    IsXLHSInRHSPart = Checker.isXLHSInRHSPart();
                    IsPostfixUpdate = false;
                  }
                }
              }
              if (!IsUpdateExprFound) {
                //  { v = x; x = expr; }
                Expr /*P*/ FirstExpr = dyn_cast_Expr(First);
                Expr /*P*/ SecondExpr = dyn_cast_Expr(Second);
                if (!(FirstExpr != null) || !(SecondExpr != null)
                   || !(FirstExpr.isInstantiationDependent()
                   || SecondExpr.isInstantiationDependent())) {
                  BinaryOperator /*P*/ FirstBinOp = dyn_cast_BinaryOperator(First);
                  if (!(FirstBinOp != null) || FirstBinOp.getOpcode() != BinaryOperatorKind.BO_Assign) {
                    ErrorFound = NotAnAssignmentOp;
                    NoteLoc.$assign(ErrorLoc.$assignMove((FirstBinOp != null) ? FirstBinOp.getOperatorLoc() : First.getLocStart()));
                    NoteRange.$assign(ErrorRange.$assignMove((FirstBinOp != null) ? FirstBinOp.getSourceRange() : new SourceRange(/*NO_COPY*/ErrorLoc, /*NO_COPY*/ErrorLoc)));
                  } else {
                    BinaryOperator /*P*/ SecondBinOp = dyn_cast_BinaryOperator(Second);
                    if (!(SecondBinOp != null) || SecondBinOp.getOpcode() != BinaryOperatorKind.BO_Assign) {
                      ErrorFound = NotAnAssignmentOp;
                      NoteLoc.$assign(ErrorLoc.$assignMove((SecondBinOp != null) ? SecondBinOp.getOperatorLoc() : Second.getLocStart()));
                      NoteRange.$assign(ErrorRange.$assignMove(
                              (SecondBinOp != null) ? SecondBinOp.getSourceRange() : new SourceRange(/*NO_COPY*/ErrorLoc, /*NO_COPY*/ErrorLoc)
                          ));
                    } else {
                      Expr /*P*/ PossibleXRHSInFirst = FirstBinOp.getRHS().IgnoreParenImpCasts();
                      Expr /*P*/ PossibleXLHSInSecond = SecondBinOp.getLHS().IgnoreParenImpCasts();
                      FoldingSetNodeID X1Id/*J*/= new FoldingSetNodeID();
                      FoldingSetNodeID X2Id/*J*/= new FoldingSetNodeID();
                      PossibleXRHSInFirst.Profile(X1Id, $this().Context, 
                          /*Canonical=*/ true);
                      PossibleXLHSInSecond.Profile(X2Id, $this().Context, 
                          /*Canonical=*/ true);
                      IsUpdateExprFound = X1Id.$eq(X2Id);
                      if (IsUpdateExprFound) {
                        V = FirstBinOp.getLHS();
                        X = SecondBinOp.getLHS();
                        E = SecondBinOp.getRHS();
                        UE = null;
                        IsXLHSInRHSPart = false;
                        IsPostfixUpdate = true;
                      } else {
                        ErrorFound = NotASpecificExpression;
                        ErrorLoc.$assignMove(FirstBinOp.getExprLoc());
                        ErrorRange.$assignMove(FirstBinOp.getSourceRange());
                        NoteLoc.$assignMove(SecondBinOp.getLHS().getExprLoc());
                        NoteRange.$assignMove(SecondBinOp.getRHS().getSourceRange());
                      }
                    }
                  }
                }
              }
            } else {
              NoteLoc.$assign(ErrorLoc.$assignMove(Body.getLocStart()));
              NoteRange.$assign(ErrorRange.$assignMove(
                      new SourceRange(Body.getLocStart(), Body.getLocStart())
                  ));
              ErrorFound = NotTwoSubstatements;
            }
          } else {
            NoteLoc.$assign(ErrorLoc.$assignMove(Body.getLocStart()));
            NoteRange.$assign(ErrorRange.$assignMove(
                    new SourceRange(Body.getLocStart(), Body.getLocStart())
                ));
            ErrorFound = NotACompoundStatement;
          }
        }
        if (ErrorFound != NoError) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(ErrorLoc), diag.err_omp_atomic_capture_not_compound_statement)), 
                ErrorRange));
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(NoteLoc), diag.note_omp_atomic_capture)), ErrorFound), NoteRange));
            return StmtError();
          } finally {
            $c$.$destroy();
          }
        } else if ($this().CurContext.isDependentContext()) {
          UE = V = E = X = null;
        }
      }
    }
  }
  
  $this().getCurFunction().setHasBranchProtectedScope();
  
  return new ActionResultTTrue<Stmt /*P*/ >(JD$T.INSTANCE, OMPAtomicDirective.Create($this().Context, new SourceLocation(StartLoc), new SourceLocation(EndLoc), new ArrayRef<OMPClause /*P*/ >(Clauses), AStmt, 
          X, V, E, UE, IsXLHSInRHSPart, 
          IsPostfixUpdate));
}

/// \brief Called on well-formed '\#pragma omp target' after parsing of the
/// associated statement.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnOpenMPTargetDirective">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 6670,
 FQN="clang::Sema::ActOnOpenMPTargetDirective", NM="_ZN5clang4Sema26ActOnOpenMPTargetDirectiveEN4llvm8ArrayRefIPNS_9OMPClauseEEEPNS_4StmtENS_14SourceLocationES8_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4Sema26ActOnOpenMPTargetDirectiveEN4llvm8ArrayRefIPNS_9OMPClauseEEEPNS_4StmtENS_14SourceLocationES8_")
//</editor-fold>
public final ActionResultTTrue<Stmt /*P*/ > ActOnOpenMPTargetDirective(ArrayRef<OMPClause /*P*/ > Clauses, 
                          Stmt /*P*/ AStmt, 
                          SourceLocation StartLoc, 
                          SourceLocation EndLoc) {
  if (!(AStmt != null)) {
    return StmtError();
  }
  
  CapturedStmt /*P*/ CS = cast_CapturedStmt(AStmt);
  // 1.2.2 OpenMP Language Terminology
  // Structured block - An executable statement with a single entry at the
  // top and a single exit at the bottom.
  // The point of exit cannot be a branch out of the structured block.
  // longjmp() and throw() must not violate the entry/exit criteria.
  CS.getCapturedDecl().setNothrow();
  
  // OpenMP [2.16, Nesting of Regions]
  // If specified, a teams construct must be contained within a target
  // construct. That target construct must contain no statements or directives
  // outside of the teams construct.
  if (((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).hasInnerTeamsRegion()) {
    Stmt /*P*/ S = AStmt.IgnoreContainers(/*IgnoreCaptured*/ true);
    boolean OMPTeamsFound = true;
    {
      CompoundStmt /*P*/ CS$1 = dyn_cast_CompoundStmt(S);
      if ((CS$1 != null)) {
        type$ptr<Stmt /*P*/ /*P*/> I = $tryClone(CS$1.body_begin());
        while ($noteq_ptr(I, CS$1.body_end())) {
          OMPExecutableDirective /*P*/ OED = dyn_cast_OMPExecutableDirective(I.$star());
          if (!(OED != null) || !isOpenMPTeamsDirective(OED.getDirectiveKind())) {
            OMPTeamsFound = false;
            break;
          }
          I.$preInc();
        }
        assert ($noteq_ptr(I, CS$1.body_end())) : "Not found statement";
        S = I.$star();
      } else {
        OMPExecutableDirective /*P*/ OED = dyn_cast_OMPExecutableDirective(S);
        OMPTeamsFound = (OED != null) && isOpenMPTeamsDirective(OED.getDirectiveKind());
      }
    }
    if (!OMPTeamsFound) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track($this().Diag(new SourceLocation(StartLoc), diag.err_omp_target_contains_not_only_teams)));
        $c$.clean($c$.track($this().Diag(((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).getInnerTeamsRegionLoc(), 
            diag.note_omp_nested_teams_construct_here)));
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(S.getLocStart(), diag.note_omp_nested_statement_here)), 
            isa_OMPExecutableDirective(S)));
        return StmtError();
      } finally {
        $c$.$destroy();
      }
    }
  }
  
  $this().getCurFunction().setHasBranchProtectedScope();
  
  return new ActionResultTTrue<Stmt /*P*/ >(JD$T.INSTANCE, OMPTargetDirective.Create($this().Context, new SourceLocation(StartLoc), new SourceLocation(EndLoc), new ArrayRef<OMPClause /*P*/ >(Clauses), AStmt));
}

/// \brief Called on well-formed '\#pragma omp target data' after parsing of
/// the associated statement.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnOpenMPTargetDataDirective">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 6801,
 FQN="clang::Sema::ActOnOpenMPTargetDataDirective", NM="_ZN5clang4Sema30ActOnOpenMPTargetDataDirectiveEN4llvm8ArrayRefIPNS_9OMPClauseEEEPNS_4StmtENS_14SourceLocationES8_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4Sema30ActOnOpenMPTargetDataDirectiveEN4llvm8ArrayRefIPNS_9OMPClauseEEEPNS_4StmtENS_14SourceLocationES8_")
//</editor-fold>
public final ActionResultTTrue<Stmt /*P*/ > ActOnOpenMPTargetDataDirective(ArrayRef<OMPClause /*P*/ > Clauses, 
                              Stmt /*P*/ AStmt, 
                              SourceLocation StartLoc, 
                              SourceLocation EndLoc) {
  if (!(AStmt != null)) {
    return StmtError();
  }
  assert (isa_CapturedStmt(AStmt)) : "Captured statement expected";
  
  // OpenMP [2.10.1, Restrictions, p. 97]
  // At least one map clause must appear on the directive.
  if (!HasMapClause(new ArrayRef<OMPClause /*P*/ >(Clauses))) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(StartLoc), diag.err_omp_no_map_for_directive)), 
          getOpenMPDirectiveName(OpenMPDirectiveKind.OMPD_target_data)));
      return StmtError();
    } finally {
      $c$.$destroy();
    }
  }
  
  $this().getCurFunction().setHasBranchProtectedScope();
  
  return new ActionResultTTrue<Stmt /*P*/ >(JD$T.INSTANCE, OMPTargetDataDirective.Create($this().Context, new SourceLocation(StartLoc), new SourceLocation(EndLoc), new ArrayRef<OMPClause /*P*/ >(Clauses), 
          AStmt));
}

/// \brief Called on well-formed '\#pragma omp target enter data' after
/// parsing of the associated statement.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnOpenMPTargetEnterDataDirective">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 6824,
 FQN="clang::Sema::ActOnOpenMPTargetEnterDataDirective", NM="_ZN5clang4Sema35ActOnOpenMPTargetEnterDataDirectiveEN4llvm8ArrayRefIPNS_9OMPClauseEEENS_14SourceLocationES6_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4Sema35ActOnOpenMPTargetEnterDataDirectiveEN4llvm8ArrayRefIPNS_9OMPClauseEEENS_14SourceLocationES6_")
//</editor-fold>
public final ActionResultTTrue<Stmt /*P*/ > ActOnOpenMPTargetEnterDataDirective(ArrayRef<OMPClause /*P*/ > Clauses, 
                                   SourceLocation StartLoc, 
                                   SourceLocation EndLoc) {
  // OpenMP [2.10.2, Restrictions, p. 99]
  // At least one map clause must appear on the directive.
  if (!HasMapClause(new ArrayRef<OMPClause /*P*/ >(Clauses))) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(StartLoc), diag.err_omp_no_map_for_directive)), 
          getOpenMPDirectiveName(OpenMPDirectiveKind.OMPD_target_enter_data)));
      return StmtError();
    } finally {
      $c$.$destroy();
    }
  }
  
  return new ActionResultTTrue<Stmt /*P*/ >(JD$T.INSTANCE, OMPTargetEnterDataDirective.Create($this().Context, new SourceLocation(StartLoc), new SourceLocation(EndLoc), 
          new ArrayRef<OMPClause /*P*/ >(Clauses)));
}

/// \brief Called on well-formed '\#pragma omp target exit data' after
/// parsing of the associated statement.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnOpenMPTargetExitDataDirective">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 6840,
 FQN="clang::Sema::ActOnOpenMPTargetExitDataDirective", NM="_ZN5clang4Sema34ActOnOpenMPTargetExitDataDirectiveEN4llvm8ArrayRefIPNS_9OMPClauseEEENS_14SourceLocationES6_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4Sema34ActOnOpenMPTargetExitDataDirectiveEN4llvm8ArrayRefIPNS_9OMPClauseEEENS_14SourceLocationES6_")
//</editor-fold>
public final ActionResultTTrue<Stmt /*P*/ > ActOnOpenMPTargetExitDataDirective(ArrayRef<OMPClause /*P*/ > Clauses, 
                                  SourceLocation StartLoc, 
                                  SourceLocation EndLoc) {
  // OpenMP [2.10.3, Restrictions, p. 102]
  // At least one map clause must appear on the directive.
  if (!HasMapClause(new ArrayRef<OMPClause /*P*/ >(Clauses))) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(StartLoc), diag.err_omp_no_map_for_directive)), 
          getOpenMPDirectiveName(OpenMPDirectiveKind.OMPD_target_exit_data)));
      return StmtError();
    } finally {
      $c$.$destroy();
    }
  }
  
  return new ActionResultTTrue<Stmt /*P*/ >(JD$T.INSTANCE, OMPTargetExitDataDirective.Create($this().Context, new SourceLocation(StartLoc), new SourceLocation(EndLoc), new ArrayRef<OMPClause /*P*/ >(Clauses)));
}

/// \brief Called on well-formed '\#pragma omp target parallel' after
/// parsing of the associated statement.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnOpenMPTargetParallelDirective">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 6723,
 FQN="clang::Sema::ActOnOpenMPTargetParallelDirective", NM="_ZN5clang4Sema34ActOnOpenMPTargetParallelDirectiveEN4llvm8ArrayRefIPNS_9OMPClauseEEEPNS_4StmtENS_14SourceLocationES8_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4Sema34ActOnOpenMPTargetParallelDirectiveEN4llvm8ArrayRefIPNS_9OMPClauseEEEPNS_4StmtENS_14SourceLocationES8_")
//</editor-fold>
public final ActionResultTTrue<Stmt /*P*/ > ActOnOpenMPTargetParallelDirective(ArrayRef<OMPClause /*P*/ > Clauses, 
                                  Stmt /*P*/ AStmt, SourceLocation StartLoc, 
                                  SourceLocation EndLoc) {
  if (!(AStmt != null)) {
    return StmtError();
  }
  
  CapturedStmt /*P*/ CS = cast_CapturedStmt(AStmt);
  // 1.2.2 OpenMP Language Terminology
  // Structured block - An executable statement with a single entry at the
  // top and a single exit at the bottom.
  // The point of exit cannot be a branch out of the structured block.
  // longjmp() and throw() must not violate the entry/exit criteria.
  CS.getCapturedDecl().setNothrow();
  
  $this().getCurFunction().setHasBranchProtectedScope();
  
  return new ActionResultTTrue<Stmt /*P*/ >(JD$T.INSTANCE, OMPTargetParallelDirective.Create($this().Context, new SourceLocation(StartLoc), new SourceLocation(EndLoc), new ArrayRef<OMPClause /*P*/ >(Clauses), 
          AStmt));
}

/// \brief Called on well-formed '\#pragma omp target parallel for' after
/// parsing of the  associated statement.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnOpenMPTargetParallelForDirective">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 6744,
 FQN="clang::Sema::ActOnOpenMPTargetParallelForDirective", NM="_ZN5clang4Sema37ActOnOpenMPTargetParallelForDirectiveEN4llvm8ArrayRefIPNS_9OMPClauseEEEPNS_4StmtENS_14SourceLocationES8_RNS1_8DenseMapIPNS_9ValueDeclEPNS_4ExprENS1_12DenseMapInfoISB_EENS1_6detail12DenseMapPairISB_SD_EEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4Sema37ActOnOpenMPTargetParallelForDirectiveEN4llvm8ArrayRefIPNS_9OMPClauseEEEPNS_4StmtENS_14SourceLocationES8_RNS1_8DenseMapIPNS_9ValueDeclEPNS_4ExprENS1_12DenseMapInfoISB_EENS1_6detail12DenseMapPairISB_SD_EEEE")
//</editor-fold>
public final ActionResultTTrue<Stmt /*P*/ > ActOnOpenMPTargetParallelForDirective(ArrayRef<OMPClause /*P*/ > Clauses, Stmt /*P*/ AStmt, SourceLocation StartLoc, 
                                     SourceLocation EndLoc, 
                                     final DenseMap<ValueDecl /*P*/ , Expr /*P*/ > /*&*/ VarsWithImplicitDSA) {
  OMPLoopDirective.HelperExprs B = null;
  try {
    if (!(AStmt != null)) {
      return StmtError();
    }
    
    CapturedStmt /*P*/ CS = cast_CapturedStmt(AStmt);
    // 1.2.2 OpenMP Language Terminology
    // Structured block - An executable statement with a single entry at the
    // top and a single exit at the bottom.
    // The point of exit cannot be a branch out of the structured block.
    // longjmp() and throw() must not violate the entry/exit criteria.
    CS.getCapturedDecl().setNothrow();
    
    B/*J*/= new OMPLoopDirective.HelperExprs();
    // In presence of clause 'collapse' or 'ordered' with number of loops, it will
    // define the nested loops number.
    /*uint*/int NestedLoopCount = CheckOpenMPLoop(OpenMPDirectiveKind.OMPD_target_parallel_for, getCollapseNumberExpr(new ArrayRef<OMPClause /*P*/ >(Clauses)), 
        getOrderedNumberExpr(new ArrayRef<OMPClause /*P*/ >(Clauses)), AStmt, /*Deref*/$this(), $Deref(((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack))), 
        VarsWithImplicitDSA, B);
    if (NestedLoopCount == 0) {
      return StmtError();
    }
    assert (($this().CurContext.isDependentContext() || B.builtAll())) : "omp target parallel for loop exprs were not built";
    if (!$this().CurContext.isDependentContext()) {
      // Finalize the clauses that need pre-built expressions for CodeGen.
      for (OMPClause /*P*/ C : Clauses) {
        {
          OMPLinearClause /*P*/ LC = dyn_cast_OMPLinearClause(C);
          if ((LC != null)) {
            if (FinishOpenMPLinearClause($Deref(LC), cast_DeclRefExpr(B.IterationVarRef), 
                B.NumIterations, /*Deref*/$this(), $this().CurScope, 
                ((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)))) {
              return StmtError();
            }
          }
        }
      }
    }
    
    $this().getCurFunction().setHasBranchProtectedScope();
    return new ActionResultTTrue<Stmt /*P*/ >(JD$T.INSTANCE, OMPTargetParallelForDirective.Create($this().Context, new SourceLocation(StartLoc), new SourceLocation(EndLoc), 
            NestedLoopCount, new ArrayRef<OMPClause /*P*/ >(Clauses), AStmt, 
            B, ((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).isCancelRegion()));
  } finally {
    if (B != null) { B.$destroy(); }
  }
}

/// \brief Called on well-formed '\#pragma omp teams' after parsing of the
/// associated statement.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnOpenMPTeamsDirective">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 6870,
 FQN="clang::Sema::ActOnOpenMPTeamsDirective", NM="_ZN5clang4Sema25ActOnOpenMPTeamsDirectiveEN4llvm8ArrayRefIPNS_9OMPClauseEEEPNS_4StmtENS_14SourceLocationES8_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4Sema25ActOnOpenMPTeamsDirectiveEN4llvm8ArrayRefIPNS_9OMPClauseEEEPNS_4StmtENS_14SourceLocationES8_")
//</editor-fold>
public final ActionResultTTrue<Stmt /*P*/ > ActOnOpenMPTeamsDirective(ArrayRef<OMPClause /*P*/ > Clauses, 
                         Stmt /*P*/ AStmt, SourceLocation StartLoc, 
                         SourceLocation EndLoc) {
  if (!(AStmt != null)) {
    return StmtError();
  }
  
  CapturedStmt /*P*/ CS = cast_CapturedStmt(AStmt);
  // 1.2.2 OpenMP Language Terminology
  // Structured block - An executable statement with a single entry at the
  // top and a single exit at the bottom.
  // The point of exit cannot be a branch out of the structured block.
  // longjmp() and throw() must not violate the entry/exit criteria.
  CS.getCapturedDecl().setNothrow();
  
  $this().getCurFunction().setHasBranchProtectedScope();
  
  return new ActionResultTTrue<Stmt /*P*/ >(JD$T.INSTANCE, OMPTeamsDirective.Create($this().Context, new SourceLocation(StartLoc), new SourceLocation(EndLoc), new ArrayRef<OMPClause /*P*/ >(Clauses), AStmt));
}

/// \brief Called on well-formed '\#pragma omp cancellation point'.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnOpenMPCancellationPointDirective">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 6889,
 FQN="clang::Sema::ActOnOpenMPCancellationPointDirective", NM="_ZN5clang4Sema37ActOnOpenMPCancellationPointDirectiveENS_14SourceLocationES1_NS_19OpenMPDirectiveKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4Sema37ActOnOpenMPCancellationPointDirectiveENS_14SourceLocationES1_NS_19OpenMPDirectiveKindE")
//</editor-fold>
public final ActionResultTTrue<Stmt /*P*/ > ActOnOpenMPCancellationPointDirective(SourceLocation StartLoc, 
                                     SourceLocation EndLoc, 
                                     OpenMPDirectiveKind CancelRegion) {
  if (CancelRegion != OpenMPDirectiveKind.OMPD_parallel && CancelRegion != OpenMPDirectiveKind.OMPD_for
     && CancelRegion != OpenMPDirectiveKind.OMPD_sections && CancelRegion != OpenMPDirectiveKind.OMPD_taskgroup) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(StartLoc), diag.err_omp_wrong_cancel_region)), 
          getOpenMPDirectiveName(CancelRegion)));
      return StmtError();
    } finally {
      $c$.$destroy();
    }
  }
  if (((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).isParentNowaitRegion()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(StartLoc), diag.err_omp_parent_cancel_region_nowait)), 0));
      return StmtError();
    } finally {
      $c$.$destroy();
    }
  }
  if (((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).isParentOrderedRegion()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(StartLoc), diag.err_omp_parent_cancel_region_ordered)), 0));
      return StmtError();
    } finally {
      $c$.$destroy();
    }
  }
  return new ActionResultTTrue<Stmt /*P*/ >(JD$T.INSTANCE, OMPCancellationPointDirective.Create($this().Context, new SourceLocation(StartLoc), new SourceLocation(EndLoc), 
          CancelRegion));
}

/// \brief Called on well-formed '\#pragma omp cancel'.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnOpenMPCancelDirective">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 6911,
 FQN="clang::Sema::ActOnOpenMPCancelDirective", NM="_ZN5clang4Sema26ActOnOpenMPCancelDirectiveEN4llvm8ArrayRefIPNS_9OMPClauseEEENS_14SourceLocationES6_NS_19OpenMPDirectiveKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4Sema26ActOnOpenMPCancelDirectiveEN4llvm8ArrayRefIPNS_9OMPClauseEEENS_14SourceLocationES6_NS_19OpenMPDirectiveKindE")
//</editor-fold>
public final ActionResultTTrue<Stmt /*P*/ > ActOnOpenMPCancelDirective(ArrayRef<OMPClause /*P*/ > Clauses, 
                          SourceLocation StartLoc, 
                          SourceLocation EndLoc, 
                          OpenMPDirectiveKind CancelRegion) {
  if (CancelRegion != OpenMPDirectiveKind.OMPD_parallel && CancelRegion != OpenMPDirectiveKind.OMPD_for
     && CancelRegion != OpenMPDirectiveKind.OMPD_sections && CancelRegion != OpenMPDirectiveKind.OMPD_taskgroup) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(StartLoc), diag.err_omp_wrong_cancel_region)), 
          getOpenMPDirectiveName(CancelRegion)));
      return StmtError();
    } finally {
      $c$.$destroy();
    }
  }
  if (((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).isParentNowaitRegion()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(StartLoc), diag.err_omp_parent_cancel_region_nowait)), 1));
      return StmtError();
    } finally {
      $c$.$destroy();
    }
  }
  if (((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).isParentOrderedRegion()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(StartLoc), diag.err_omp_parent_cancel_region_ordered)), 1));
      return StmtError();
    } finally {
      $c$.$destroy();
    }
  }
  ((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).setParentCancelRegion(/*Cancel=*/ true);
  return new ActionResultTTrue<Stmt /*P*/ >(JD$T.INSTANCE, OMPCancelDirective.Create($this().Context, new SourceLocation(StartLoc), new SourceLocation(EndLoc), new ArrayRef<OMPClause /*P*/ >(Clauses), 
          CancelRegion));
}

/// \brief Called on well-formed '\#pragma omp taskloop' after parsing of the
/// associated statement.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnOpenMPTaskLoopDirective">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 6958,
 FQN="clang::Sema::ActOnOpenMPTaskLoopDirective", NM="_ZN5clang4Sema28ActOnOpenMPTaskLoopDirectiveEN4llvm8ArrayRefIPNS_9OMPClauseEEEPNS_4StmtENS_14SourceLocationES8_RNS1_8DenseMapIPNS_9ValueDeclEPNS_4ExprENS1_12DenseMapInfoISB_EENS1_6detail12DenseMapPairISB_SD_EEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4Sema28ActOnOpenMPTaskLoopDirectiveEN4llvm8ArrayRefIPNS_9OMPClauseEEEPNS_4StmtENS_14SourceLocationES8_RNS1_8DenseMapIPNS_9ValueDeclEPNS_4ExprENS1_12DenseMapInfoISB_EENS1_6detail12DenseMapPairISB_SD_EEEE")
//</editor-fold>
public final ActionResultTTrue<Stmt /*P*/ > ActOnOpenMPTaskLoopDirective(ArrayRef<OMPClause /*P*/ > Clauses, Stmt /*P*/ AStmt, SourceLocation StartLoc, 
                            SourceLocation EndLoc, 
                            final DenseMap<ValueDecl /*P*/ , Expr /*P*/ > /*&*/ VarsWithImplicitDSA) {
  OMPLoopDirective.HelperExprs B = null;
  try {
    if (!(AStmt != null)) {
      return StmtError();
    }
    assert (isa_CapturedStmt(AStmt)) : "Captured statement expected";
    B/*J*/= new OMPLoopDirective.HelperExprs();
    // In presence of clause 'collapse' or 'ordered' with number of loops, it will
    // define the nested loops number.
    /*uint*/int NestedLoopCount = CheckOpenMPLoop(OpenMPDirectiveKind.OMPD_taskloop, getCollapseNumberExpr(new ArrayRef<OMPClause /*P*/ >(Clauses)), 
        /*OrderedLoopCountExpr=*/ (Expr /*P*/ )null, AStmt, /*Deref*/$this(), $Deref(((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack))), 
        VarsWithImplicitDSA, B);
    if (NestedLoopCount == 0) {
      return StmtError();
    }
    assert (($this().CurContext.isDependentContext() || B.builtAll())) : "omp for loop exprs were not built";
    
    // OpenMP, [2.9.2 taskloop Construct, Restrictions]
    // The grainsize clause and num_tasks clause are mutually exclusive and may
    // not appear on the same taskloop directive.
    if (checkGrainsizeNumTasksClauses(/*Deref*/$this(), new ArrayRef<OMPClause /*P*/ >(Clauses))) {
      return StmtError();
    }
    
    $this().getCurFunction().setHasBranchProtectedScope();
    return new ActionResultTTrue<Stmt /*P*/ >(JD$T.INSTANCE, OMPTaskLoopDirective.Create($this().Context, new SourceLocation(StartLoc), new SourceLocation(EndLoc), 
            NestedLoopCount, new ArrayRef<OMPClause /*P*/ >(Clauses), AStmt, B));
  } finally {
    if (B != null) { B.$destroy(); }
  }
}

/// \brief Called on well-formed '\#pragma omp taskloop simd' after parsing of
/// the associated statement.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnOpenMPTaskLoopSimdDirective">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 6990,
 FQN="clang::Sema::ActOnOpenMPTaskLoopSimdDirective", NM="_ZN5clang4Sema32ActOnOpenMPTaskLoopSimdDirectiveEN4llvm8ArrayRefIPNS_9OMPClauseEEEPNS_4StmtENS_14SourceLocationES8_RNS1_8DenseMapIPNS_9ValueDeclEPNS_4ExprENS1_12DenseMapInfoISB_EENS1_6detail12DenseMapPairISB_SD_EEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4Sema32ActOnOpenMPTaskLoopSimdDirectiveEN4llvm8ArrayRefIPNS_9OMPClauseEEEPNS_4StmtENS_14SourceLocationES8_RNS1_8DenseMapIPNS_9ValueDeclEPNS_4ExprENS1_12DenseMapInfoISB_EENS1_6detail12DenseMapPairISB_SD_EEEE")
//</editor-fold>
public final ActionResultTTrue<Stmt /*P*/ > ActOnOpenMPTaskLoopSimdDirective(ArrayRef<OMPClause /*P*/ > Clauses, Stmt /*P*/ AStmt, SourceLocation StartLoc, 
                                SourceLocation EndLoc, 
                                final DenseMap<ValueDecl /*P*/ , Expr /*P*/ > /*&*/ VarsWithImplicitDSA) {
  OMPLoopDirective.HelperExprs B = null;
  try {
    if (!(AStmt != null)) {
      return StmtError();
    }
    assert (isa_CapturedStmt(AStmt)) : "Captured statement expected";
    B/*J*/= new OMPLoopDirective.HelperExprs();
    // In presence of clause 'collapse' or 'ordered' with number of loops, it will
    // define the nested loops number.
    /*uint*/int NestedLoopCount = CheckOpenMPLoop(OpenMPDirectiveKind.OMPD_taskloop_simd, getCollapseNumberExpr(new ArrayRef<OMPClause /*P*/ >(Clauses)), 
        /*OrderedLoopCountExpr=*/ (Expr /*P*/ )null, AStmt, /*Deref*/$this(), $Deref(((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack))), 
        VarsWithImplicitDSA, B);
    if (NestedLoopCount == 0) {
      return StmtError();
    }
    assert (($this().CurContext.isDependentContext() || B.builtAll())) : "omp for loop exprs were not built";
    if (!$this().CurContext.isDependentContext()) {
      // Finalize the clauses that need pre-built expressions for CodeGen.
      for (OMPClause /*P*/ C : Clauses) {
        {
          OMPLinearClause /*P*/ LC = dyn_cast_OMPLinearClause(C);
          if ((LC != null)) {
            if (FinishOpenMPLinearClause($Deref(LC), cast_DeclRefExpr(B.IterationVarRef), 
                B.NumIterations, /*Deref*/$this(), $this().CurScope, 
                ((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)))) {
              return StmtError();
            }
          }
        }
      }
    }
    
    // OpenMP, [2.9.2 taskloop Construct, Restrictions]
    // The grainsize clause and num_tasks clause are mutually exclusive and may
    // not appear on the same taskloop directive.
    if (checkGrainsizeNumTasksClauses(/*Deref*/$this(), new ArrayRef<OMPClause /*P*/ >(Clauses))) {
      return StmtError();
    }
    
    $this().getCurFunction().setHasBranchProtectedScope();
    return new ActionResultTTrue<Stmt /*P*/ >(JD$T.INSTANCE, OMPTaskLoopSimdDirective.Create($this().Context, new SourceLocation(StartLoc), new SourceLocation(EndLoc), 
            NestedLoopCount, new ArrayRef<OMPClause /*P*/ >(Clauses), AStmt, B));
  } finally {
    if (B != null) { B.$destroy(); }
  }
}

/// \brief Called on well-formed '\#pragma omp distribute' after parsing
/// of the associated statement.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnOpenMPDistributeDirective">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 7033,
 FQN="clang::Sema::ActOnOpenMPDistributeDirective", NM="_ZN5clang4Sema30ActOnOpenMPDistributeDirectiveEN4llvm8ArrayRefIPNS_9OMPClauseEEEPNS_4StmtENS_14SourceLocationES8_RNS1_8DenseMapIPNS_9ValueDeclEPNS_4ExprENS1_12DenseMapInfoISB_EENS1_6detail12DenseMapPairISB_SD_EEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4Sema30ActOnOpenMPDistributeDirectiveEN4llvm8ArrayRefIPNS_9OMPClauseEEEPNS_4StmtENS_14SourceLocationES8_RNS1_8DenseMapIPNS_9ValueDeclEPNS_4ExprENS1_12DenseMapInfoISB_EENS1_6detail12DenseMapPairISB_SD_EEEE")
//</editor-fold>
public final ActionResultTTrue<Stmt /*P*/ > ActOnOpenMPDistributeDirective(ArrayRef<OMPClause /*P*/ > Clauses, Stmt /*P*/ AStmt, SourceLocation StartLoc, 
                              SourceLocation EndLoc, 
                              final DenseMap<ValueDecl /*P*/ , Expr /*P*/ > /*&*/ VarsWithImplicitDSA) {
  OMPLoopDirective.HelperExprs B = null;
  try {
    if (!(AStmt != null)) {
      return StmtError();
    }
    assert (isa_CapturedStmt(AStmt)) : "Captured statement expected";
    B/*J*/= new OMPLoopDirective.HelperExprs();
    // In presence of clause 'collapse' with number of loops, it will
    // define the nested loops number.
    /*uint*/int NestedLoopCount = CheckOpenMPLoop(OpenMPDirectiveKind.OMPD_distribute, getCollapseNumberExpr(new ArrayRef<OMPClause /*P*/ >(Clauses)), 
        (Expr /*P*/ )null/*ordered not a clause on distribute*/, AStmt, 
        /*Deref*/$this(), $Deref(((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack))), VarsWithImplicitDSA, B);
    if (NestedLoopCount == 0) {
      return StmtError();
    }
    assert (($this().CurContext.isDependentContext() || B.builtAll())) : "omp for loop exprs were not built";
    
    $this().getCurFunction().setHasBranchProtectedScope();
    return new ActionResultTTrue<Stmt /*P*/ >(JD$T.INSTANCE, OMPDistributeDirective.Create($this().Context, new SourceLocation(StartLoc), new SourceLocation(EndLoc), 
            NestedLoopCount, new ArrayRef<OMPClause /*P*/ >(Clauses), AStmt, B));
  } finally {
    if (B != null) { B.$destroy(); }
  }
}

/// \brief Called on well-formed '\#pragma omp target update'.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnOpenMPTargetUpdateDirective">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 6855,
 FQN="clang::Sema::ActOnOpenMPTargetUpdateDirective", NM="_ZN5clang4Sema32ActOnOpenMPTargetUpdateDirectiveEN4llvm8ArrayRefIPNS_9OMPClauseEEENS_14SourceLocationES6_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4Sema32ActOnOpenMPTargetUpdateDirectiveEN4llvm8ArrayRefIPNS_9OMPClauseEEENS_14SourceLocationES6_")
//</editor-fold>
public final ActionResultTTrue<Stmt /*P*/ > ActOnOpenMPTargetUpdateDirective(ArrayRef<OMPClause /*P*/ > Clauses, 
                                SourceLocation StartLoc, 
                                SourceLocation EndLoc) {
  boolean seenMotionClause = false;
  for (OMPClause /*P*/ C : Clauses) {
    if (C.getClauseKind() == OpenMPClauseKind.OMPC_to || C.getClauseKind() == OpenMPClauseKind.OMPC_from) {
      seenMotionClause = true;
    }
  }
  if (!seenMotionClause) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track($this().Diag(new SourceLocation(StartLoc), diag.err_omp_at_least_one_motion_clause_required)));
      return StmtError();
    } finally {
      $c$.$destroy();
    }
  }
  return new ActionResultTTrue<Stmt /*P*/ >(JD$T.INSTANCE, OMPTargetUpdateDirective.Create($this().Context, new SourceLocation(StartLoc), new SourceLocation(EndLoc), new ArrayRef<OMPClause /*P*/ >(Clauses)));
}

/// \brief Called on well-formed '\#pragma omp distribute parallel for' after
/// parsing of the associated statement.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnOpenMPDistributeParallelForDirective">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 7059,
 FQN="clang::Sema::ActOnOpenMPDistributeParallelForDirective", NM="_ZN5clang4Sema41ActOnOpenMPDistributeParallelForDirectiveEN4llvm8ArrayRefIPNS_9OMPClauseEEEPNS_4StmtENS_14SourceLocationES8_RNS1_8DenseMapIPNS_9ValueDeclEPNS_4ExprENS1_12DenseMapInfoISB_EENS1_6detail12DenseMapPairISB_SD_EEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4Sema41ActOnOpenMPDistributeParallelForDirectiveEN4llvm8ArrayRefIPNS_9OMPClauseEEEPNS_4StmtENS_14SourceLocationES8_RNS1_8DenseMapIPNS_9ValueDeclEPNS_4ExprENS1_12DenseMapInfoISB_EENS1_6detail12DenseMapPairISB_SD_EEEE")
//</editor-fold>
public final ActionResultTTrue<Stmt /*P*/ > ActOnOpenMPDistributeParallelForDirective(ArrayRef<OMPClause /*P*/ > Clauses, Stmt /*P*/ AStmt, SourceLocation StartLoc, 
                                         SourceLocation EndLoc, 
                                         final DenseMap<ValueDecl /*P*/ , Expr /*P*/ > /*&*/ VarsWithImplicitDSA) {
  OMPLoopDirective.HelperExprs B = null;
  try {
    if (!(AStmt != null)) {
      return StmtError();
    }
    
    CapturedStmt /*P*/ CS = cast_CapturedStmt(AStmt);
    // 1.2.2 OpenMP Language Terminology
    // Structured block - An executable statement with a single entry at the
    // top and a single exit at the bottom.
    // The point of exit cannot be a branch out of the structured block.
    // longjmp() and throw() must not violate the entry/exit criteria.
    CS.getCapturedDecl().setNothrow();
    
    B/*J*/= new OMPLoopDirective.HelperExprs();
    // In presence of clause 'collapse' with number of loops, it will
    // define the nested loops number.
    /*uint*/int NestedLoopCount = CheckOpenMPLoop(OpenMPDirectiveKind.OMPD_distribute_parallel_for, getCollapseNumberExpr(new ArrayRef<OMPClause /*P*/ >(Clauses)), 
        (Expr /*P*/ )null/*ordered not a clause on distribute*/, AStmt, /*Deref*/$this(), $Deref(((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack))), 
        VarsWithImplicitDSA, B);
    if (NestedLoopCount == 0) {
      return StmtError();
    }
    assert (($this().CurContext.isDependentContext() || B.builtAll())) : "omp for loop exprs were not built";
    
    $this().getCurFunction().setHasBranchProtectedScope();
    return new ActionResultTTrue<Stmt /*P*/ >(JD$T.INSTANCE, OMPDistributeParallelForDirective.Create($this().Context, new SourceLocation(StartLoc), new SourceLocation(EndLoc), NestedLoopCount, new ArrayRef<OMPClause /*P*/ >(Clauses), AStmt, B));
  } finally {
    if (B != null) { B.$destroy(); }
  }
}

/// \brief Called on well-formed '\#pragma omp distribute parallel for simd'
/// after parsing of the associated statement.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnOpenMPDistributeParallelForSimdDirective">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 7092,
 FQN="clang::Sema::ActOnOpenMPDistributeParallelForSimdDirective", NM="_ZN5clang4Sema45ActOnOpenMPDistributeParallelForSimdDirectiveEN4llvm8ArrayRefIPNS_9OMPClauseEEEPNS_4StmtENS_14SourceLocationES8_RNS1_8DenseMapIPNS_9ValueDeclEPNS_4ExprENS1_12DenseMapInfoISB_EENS1_6detail12DenseMapPairISB_SD_EEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4Sema45ActOnOpenMPDistributeParallelForSimdDirectiveEN4llvm8ArrayRefIPNS_9OMPClauseEEEPNS_4StmtENS_14SourceLocationES8_RNS1_8DenseMapIPNS_9ValueDeclEPNS_4ExprENS1_12DenseMapInfoISB_EENS1_6detail12DenseMapPairISB_SD_EEEE")
//</editor-fold>
public final ActionResultTTrue<Stmt /*P*/ > ActOnOpenMPDistributeParallelForSimdDirective(ArrayRef<OMPClause /*P*/ > Clauses, Stmt /*P*/ AStmt, SourceLocation StartLoc, 
                                             SourceLocation EndLoc, 
                                             final DenseMap<ValueDecl /*P*/ , Expr /*P*/ > /*&*/ VarsWithImplicitDSA) {
  OMPLoopDirective.HelperExprs B = null;
  try {
    if (!(AStmt != null)) {
      return StmtError();
    }
    
    CapturedStmt /*P*/ CS = cast_CapturedStmt(AStmt);
    // 1.2.2 OpenMP Language Terminology
    // Structured block - An executable statement with a single entry at the
    // top and a single exit at the bottom.
    // The point of exit cannot be a branch out of the structured block.
    // longjmp() and throw() must not violate the entry/exit criteria.
    CS.getCapturedDecl().setNothrow();
    
    B/*J*/= new OMPLoopDirective.HelperExprs();
    // In presence of clause 'collapse' with number of loops, it will
    // define the nested loops number.
    /*uint*/int NestedLoopCount = CheckOpenMPLoop(OpenMPDirectiveKind.OMPD_distribute_parallel_for_simd, getCollapseNumberExpr(new ArrayRef<OMPClause /*P*/ >(Clauses)), 
        (Expr /*P*/ )null/*ordered not a clause on distribute*/, AStmt, /*Deref*/$this(), $Deref(((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack))), 
        VarsWithImplicitDSA, B);
    if (NestedLoopCount == 0) {
      return StmtError();
    }
    assert (($this().CurContext.isDependentContext() || B.builtAll())) : "omp for loop exprs were not built";
    if (checkSimdlenSafelenSpecified(/*Deref*/$this(), new ArrayRef<OMPClause /*P*/ >(Clauses))) {
      return StmtError();
    }
    
    $this().getCurFunction().setHasBranchProtectedScope();
    return new ActionResultTTrue<Stmt /*P*/ >(JD$T.INSTANCE, OMPDistributeParallelForSimdDirective.Create($this().Context, new SourceLocation(StartLoc), new SourceLocation(EndLoc), NestedLoopCount, new ArrayRef<OMPClause /*P*/ >(Clauses), AStmt, B));
  } finally {
    if (B != null) { B.$destroy(); }
  }
}

/// \brief Called on well-formed '\#pragma omp distribute simd' after
/// parsing of the associated statement.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnOpenMPDistributeSimdDirective">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 7128,
 FQN="clang::Sema::ActOnOpenMPDistributeSimdDirective", NM="_ZN5clang4Sema34ActOnOpenMPDistributeSimdDirectiveEN4llvm8ArrayRefIPNS_9OMPClauseEEEPNS_4StmtENS_14SourceLocationES8_RNS1_8DenseMapIPNS_9ValueDeclEPNS_4ExprENS1_12DenseMapInfoISB_EENS1_6detail12DenseMapPairISB_SD_EEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4Sema34ActOnOpenMPDistributeSimdDirectiveEN4llvm8ArrayRefIPNS_9OMPClauseEEEPNS_4StmtENS_14SourceLocationES8_RNS1_8DenseMapIPNS_9ValueDeclEPNS_4ExprENS1_12DenseMapInfoISB_EENS1_6detail12DenseMapPairISB_SD_EEEE")
//</editor-fold>
public final ActionResultTTrue<Stmt /*P*/ > ActOnOpenMPDistributeSimdDirective(ArrayRef<OMPClause /*P*/ > Clauses, Stmt /*P*/ AStmt, SourceLocation StartLoc, 
                                  SourceLocation EndLoc, 
                                  final DenseMap<ValueDecl /*P*/ , Expr /*P*/ > /*&*/ VarsWithImplicitDSA) {
  OMPLoopDirective.HelperExprs B = null;
  try {
    if (!(AStmt != null)) {
      return StmtError();
    }
    
    CapturedStmt /*P*/ CS = cast_CapturedStmt(AStmt);
    // 1.2.2 OpenMP Language Terminology
    // Structured block - An executable statement with a single entry at the
    // top and a single exit at the bottom.
    // The point of exit cannot be a branch out of the structured block.
    // longjmp() and throw() must not violate the entry/exit criteria.
    CS.getCapturedDecl().setNothrow();
    
    B/*J*/= new OMPLoopDirective.HelperExprs();
    // In presence of clause 'collapse' with number of loops, it will
    // define the nested loops number.
    /*uint*/int NestedLoopCount = CheckOpenMPLoop(OpenMPDirectiveKind.OMPD_distribute_simd, getCollapseNumberExpr(new ArrayRef<OMPClause /*P*/ >(Clauses)), 
        (Expr /*P*/ )null/*ordered not a clause on distribute*/, AStmt, 
        /*Deref*/$this(), $Deref(((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack))), VarsWithImplicitDSA, B);
    if (NestedLoopCount == 0) {
      return StmtError();
    }
    assert (($this().CurContext.isDependentContext() || B.builtAll())) : "omp for loop exprs were not built";
    if (checkSimdlenSafelenSpecified(/*Deref*/$this(), new ArrayRef<OMPClause /*P*/ >(Clauses))) {
      return StmtError();
    }
    
    $this().getCurFunction().setHasBranchProtectedScope();
    return new ActionResultTTrue<Stmt /*P*/ >(JD$T.INSTANCE, OMPDistributeSimdDirective.Create($this().Context, new SourceLocation(StartLoc), new SourceLocation(EndLoc), 
            NestedLoopCount, new ArrayRef<OMPClause /*P*/ >(Clauses), AStmt, B));
  } finally {
    if (B != null) { B.$destroy(); }
  }
}

/// \brief Called on well-formed '\#pragma omp target parallel for simd' after
/// parsing of the associated statement.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnOpenMPTargetParallelForSimdDirective">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 7164,
 FQN="clang::Sema::ActOnOpenMPTargetParallelForSimdDirective", NM="_ZN5clang4Sema41ActOnOpenMPTargetParallelForSimdDirectiveEN4llvm8ArrayRefIPNS_9OMPClauseEEEPNS_4StmtENS_14SourceLocationES8_RNS1_8DenseMapIPNS_9ValueDeclEPNS_4ExprENS1_12DenseMapInfoISB_EENS1_6detail12DenseMapPairISB_SD_EEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4Sema41ActOnOpenMPTargetParallelForSimdDirectiveEN4llvm8ArrayRefIPNS_9OMPClauseEEEPNS_4StmtENS_14SourceLocationES8_RNS1_8DenseMapIPNS_9ValueDeclEPNS_4ExprENS1_12DenseMapInfoISB_EENS1_6detail12DenseMapPairISB_SD_EEEE")
//</editor-fold>
public final ActionResultTTrue<Stmt /*P*/ > ActOnOpenMPTargetParallelForSimdDirective(ArrayRef<OMPClause /*P*/ > Clauses, Stmt /*P*/ AStmt, SourceLocation StartLoc, 
                                         SourceLocation EndLoc, 
                                         final DenseMap<ValueDecl /*P*/ , Expr /*P*/ > /*&*/ VarsWithImplicitDSA) {
  OMPLoopDirective.HelperExprs B = null;
  try {
    if (!(AStmt != null)) {
      return StmtError();
    }
    
    CapturedStmt /*P*/ CS = cast_CapturedStmt(AStmt);
    // 1.2.2 OpenMP Language Terminology
    // Structured block - An executable statement with a single entry at the
    // top and a single exit at the bottom.
    // The point of exit cannot be a branch out of the structured block.
    // longjmp() and throw() must not violate the entry/exit criteria.
    CS.getCapturedDecl().setNothrow();
    
    B/*J*/= new OMPLoopDirective.HelperExprs();
    // In presence of clause 'collapse' or 'ordered' with number of loops, it will
    // define the nested loops number.
    /*uint*/int NestedLoopCount = CheckOpenMPLoop(OpenMPDirectiveKind.OMPD_target_parallel_for_simd, getCollapseNumberExpr(new ArrayRef<OMPClause /*P*/ >(Clauses)), 
        getOrderedNumberExpr(new ArrayRef<OMPClause /*P*/ >(Clauses)), AStmt, /*Deref*/$this(), $Deref(((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack))), 
        VarsWithImplicitDSA, B);
    if (NestedLoopCount == 0) {
      return StmtError();
    }
    assert (($this().CurContext.isDependentContext() || B.builtAll())) : "omp target parallel for simd loop exprs were not built";
    if (!$this().CurContext.isDependentContext()) {
      // Finalize the clauses that need pre-built expressions for CodeGen.
      for (OMPClause /*P*/ C : Clauses) {
        {
          OMPLinearClause /*P*/ LC = dyn_cast_OMPLinearClause(C);
          if ((LC != null)) {
            if (FinishOpenMPLinearClause($Deref(LC), cast_DeclRefExpr(B.IterationVarRef), 
                B.NumIterations, /*Deref*/$this(), $this().CurScope, 
                ((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)))) {
              return StmtError();
            }
          }
        }
      }
    }
    if (checkSimdlenSafelenSpecified(/*Deref*/$this(), new ArrayRef<OMPClause /*P*/ >(Clauses))) {
      return StmtError();
    }
    
    $this().getCurFunction().setHasBranchProtectedScope();
    return new ActionResultTTrue<Stmt /*P*/ >(JD$T.INSTANCE, OMPTargetParallelForSimdDirective.Create($this().Context, new SourceLocation(StartLoc), new SourceLocation(EndLoc), NestedLoopCount, new ArrayRef<OMPClause /*P*/ >(Clauses), AStmt, B));
  } finally {
    if (B != null) { B.$destroy(); }
  }
}


/// Checks correctness of linear modifiers.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckOpenMPLinearModifier">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 9509,
 FQN="clang::Sema::CheckOpenMPLinearModifier", NM="_ZN5clang4Sema25CheckOpenMPLinearModifierENS_22OpenMPLinearClauseKindENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4Sema25CheckOpenMPLinearModifierENS_22OpenMPLinearClauseKindENS_14SourceLocationE")
//</editor-fold>
public final boolean CheckOpenMPLinearModifier(OpenMPLinearClauseKind LinKind, 
                         SourceLocation LinLoc) {
  if ((!$this().LangOpts.CPlusPlus && LinKind != OpenMPLinearClauseKind.OMPC_LINEAR_val)
     || LinKind == OpenMPLinearClauseKind.OMPC_LINEAR_unknown) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(LinLoc), diag.err_omp_wrong_linear_modifier)), $this().LangOpts.CPlusPlus));
      return true;
    } finally {
      $c$.$destroy();
    }
  }
  return false;
}

/// Checks that the specified declaration matches requirements for the linear
/// decls.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckOpenMPLinearDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 9519,
 FQN="clang::Sema::CheckOpenMPLinearDecl", NM="_ZN5clang4Sema21CheckOpenMPLinearDeclEPNS_9ValueDeclENS_14SourceLocationENS_22OpenMPLinearClauseKindENS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4Sema21CheckOpenMPLinearDeclEPNS_9ValueDeclENS_14SourceLocationENS_22OpenMPLinearClauseKindENS_8QualTypeE")
//</editor-fold>
public final boolean CheckOpenMPLinearDecl(ValueDecl /*P*/ D, SourceLocation ELoc, 
                     OpenMPLinearClauseKind LinKind, 
                     QualType Type) {
  VarDecl /*P*/ VD = dyn_cast_or_null_VarDecl(D);
  // A variable must not have an incomplete type or a reference type.
  if ($this().RequireCompleteType(new SourceLocation(ELoc), new QualType(Type), diag.err_omp_linear_incomplete_type)) {
    return true;
  }
  if ((LinKind == OpenMPLinearClauseKind.OMPC_LINEAR_uval || LinKind == OpenMPLinearClauseKind.OMPC_LINEAR_ref)
     && !Type.$arrow().isReferenceType()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(ELoc), diag.err_omp_wrong_linear_modifier_non_reference)), 
              Type), getOpenMPSimpleClauseTypeName(OpenMPClauseKind.OMPC_linear, LinKind.getValue())));
      return true;
    } finally {
      $c$.$destroy();
    }
  }
  Type.$assignMove(Type.getNonReferenceType());
  
  // A list item must not be const-qualified.
  if (Type.isConstant($this().Context)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(ELoc), diag.err_omp_const_variable)), 
          getOpenMPClauseName(OpenMPClauseKind.OMPC_linear)));
      if ((D != null)) {
        boolean IsDecl = !(VD != null)
           || VD.isThisDeclarationADefinition($this().Context) == VarDecl.DefinitionKind.DeclarationOnly;
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(D.getLocation(), 
                IsDecl ? diag.note_previous_decl : diag.note_defined_here)), 
            D));
      }
      return true;
    } finally {
      $c$.$destroy();
    }
  }
  
  // A list item must be of integral or pointer type.
  Type.$assignMove(Type.getUnqualifiedType().getCanonicalType());
  /*const*/ Type /*P*/ Ty = Type.getTypePtrOrNull();
  if (!(Ty != null) || (!Ty.isDependentType() && !Ty.isIntegralType($this().Context)
     && !Ty.isPointerType())) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(ELoc), diag.err_omp_linear_expected_int_or_ptr)), Type));
      if ((D != null)) {
        boolean IsDecl = !(VD != null)
           || VD.isThisDeclarationADefinition($this().Context) == VarDecl.DefinitionKind.DeclarationOnly;
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(D.getLocation(), 
                IsDecl ? diag.note_previous_decl : diag.note_defined_here)), 
            D));
      }
      return true;
    } finally {
      $c$.$destroy();
    }
  }
  return false;
}


/// \brief Called on well-formed '\#pragma omp declare simd' after parsing of
/// the associated method/function.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnOpenMPDeclareSimdDirective">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*make_pair*/,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 3630,
 FQN="clang::Sema::ActOnOpenMPDeclareSimdDirective", NM="_ZN5clang4Sema31ActOnOpenMPDeclareSimdDirectiveENS_9OpaquePtrINS_12DeclGroupRefEEENS_22OMPDeclareSimdDeclAttr13BranchStateTyEPNS_4ExprEN4llvm8ArrayRefIS7_EESA_SA_SA_NS9_IjEESA_NS_11SourceRangeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4Sema31ActOnOpenMPDeclareSimdDirectiveENS_9OpaquePtrINS_12DeclGroupRefEEENS_22OMPDeclareSimdDeclAttr13BranchStateTyEPNS_4ExprEN4llvm8ArrayRefIS7_EESA_SA_SA_NS9_IjEESA_NS_11SourceRangeE")
//</editor-fold>
public final OpaquePtr<DeclGroupRef> ActOnOpenMPDeclareSimdDirective(OpaquePtr<DeclGroupRef> DG, OMPDeclareSimdDeclAttr.BranchStateTy BS, Expr /*P*/ Simdlen, 
                               ArrayRef<Expr /*P*/ > Uniforms, ArrayRef<Expr /*P*/ > Aligneds, 
                               ArrayRef<Expr /*P*/ > Alignments, ArrayRef<Expr /*P*/ > Linears, 
                               ArrayRefUInt LinModifiers, ArrayRef<Expr /*P*/ > Steps, SourceRange SR) {
  assert (Aligneds.size() == Alignments.size());
  assert (Linears.size() == LinModifiers.size());
  assert (Linears.size() == Steps.size());
  if (!DG.$bool() || DG.getDeclGroupRef().isNull()) {
    return new OpaquePtr<DeclGroupRef>();
  }
  if (!DG.getDeclGroupRef().isSingleDecl()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track($this().Diag(SR.getBegin(), diag.err_omp_single_decl_in_declare_simd)));
      return new OpaquePtr<DeclGroupRef>(JD$Move.INSTANCE, DG);
    } finally {
      $c$.$destroy();
    }
  }
  Decl /*P*/ ADecl = DG.getDeclGroupRef().getSingleDecl();
  {
    FunctionTemplateDecl /*P*/ FTD = dyn_cast_FunctionTemplateDecl(ADecl);
    if ((FTD != null)) {
      ADecl = FTD.getTemplatedDecl();
    }
  }
  
  FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(ADecl);
  if (!(FD != null)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track($this().Diag(ADecl.getLocation(), diag.err_omp_function_expected)));
      return new OpaquePtr<DeclGroupRef>();
    } finally {
      $c$.$destroy();
    }
  }
  
  // OpenMP [2.8.2, declare simd construct, Description]
  // The parameter of the simdlen clause must be a constant positive integer
  // expression.
  ActionResultTTrue<Expr /*P*/ > SL/*J*/= new ActionResultTTrue<Expr /*P*/ >();
  if ((Simdlen != null)) {
    SL.$assignMove($this().VerifyPositiveIntegerConstantInClause(Simdlen, OpenMPClauseKind.OMPC_simdlen));
  }
  // OpenMP [2.8.2, declare simd construct, Description]
  // The special this pointer can be used as if was one of the arguments to the
  // function in any of the linear, aligned, or uniform clauses.
  // The uniform clause declares one or more arguments to have an invariant
  // value for all concurrent invocations of the function in the execution of a
  // single SIMD loop.
  DenseMap<Decl /*P*/ , Expr /*P*/ > UniformedArgs/*J*/= new DenseMap<Decl /*P*/ , Expr /*P*/ >(DenseMapInfo$LikePtr.$Info(), (Expr /*P*/ )null);
  Expr /*P*/ UniformedLinearThis = null;
  for (Expr /*P*/ E : Uniforms) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      E = E.IgnoreParenImpCasts();
      {
        DeclRefExpr /*P*/ DRE = dyn_cast_DeclRefExpr(E);
        if ((DRE != null)) {
          {
            ParmVarDecl /*P*/ PVD = dyn_cast_ParmVarDecl(DRE.getDecl());
            if ((PVD != null)) {
              if ($greater_uint(FD.getNumParams(), PVD.getFunctionScopeIndex())
                 && FD.getParamDecl(PVD.getFunctionScopeIndex()).
                  getCanonicalDecl() == PVD.getCanonicalDecl()) {
                UniformedArgs.insert_pair$KeyT$ValueT(std.make_pair_Ptr_Ptr((Decl /*P*/)PVD.getCanonicalDecl(), (Expr /*P*/)E));
                continue;
              }
            }
          }
        }
      }
      if (isa_CXXThisExpr(E)) {
        UniformedLinearThis = E;
        continue;
      }
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(E.getExprLoc(), diag.err_omp_param_or_this_in_clause)), 
              FD.getDeclName()), (isa_CXXMethodDecl(ADecl) ? 1 : 0)));
    } finally {
      $c$.$destroy();
    }
  }
  // OpenMP [2.8.2, declare simd construct, Description]
  // The aligned clause declares that the object to which each list item points
  // is aligned to the number of bytes expressed in the optional parameter of
  // the aligned clause.
  // The special this pointer can be used as if was one of the arguments to the
  // function in any of the linear, aligned, or uniform clauses.
  // The type of list items appearing in the aligned clause must be array,
  // pointer, reference to array, or reference to pointer.
  DenseMap<Decl /*P*/ , Expr /*P*/ > AlignedArgs/*J*/= new DenseMap<Decl /*P*/ , Expr /*P*/ >(DenseMapInfo$LikePtr.$Info(), (Expr /*P*/ )null);
  Expr /*P*/ AlignedThis = null;
  for (Expr /*P*/ E : Aligneds) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      E = E.IgnoreParenImpCasts();
      {
        DeclRefExpr /*P*/ DRE = dyn_cast_DeclRefExpr(E);
        if ((DRE != null)) {
          {
            ParmVarDecl /*P*/ PVD = dyn_cast_ParmVarDecl(DRE.getDecl());
            if ((PVD != null)) {
              VarDecl /*P*/ CanonPVD = PVD.getCanonicalDecl();
              if ($greater_uint(FD.getNumParams(), PVD.getFunctionScopeIndex())
                 && FD.getParamDecl(PVD.getFunctionScopeIndex()).
                  getCanonicalDecl() == CanonPVD) {
                // OpenMP  [2.8.1, simd construct, Restrictions]
                // A list-item cannot appear in more than one aligned clause.
                if ($greater_uint(AlignedArgs.count(CanonPVD), 0)) {
                  $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(E.getExprLoc(), diag.err_omp_aligned_twice)), 
                          1), E.getSourceRange()));
                  $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(AlignedArgs.$at_T1$RR(CanonPVD).getExprLoc(), 
                          diag.note_omp_explicit_dsa)), 
                      getOpenMPClauseName(OpenMPClauseKind.OMPC_aligned)));
                  continue;
                }
                AlignedArgs.$set(CanonPVD, E);
                QualType QTy = PVD.getType().
                    getNonReferenceType().
                    getUnqualifiedType().
                    getCanonicalType();
                /*const*/ Type /*P*/ Ty = QTy.getTypePtrOrNull();
                if (!(Ty != null) || (!Ty.isArrayType() && !Ty.isPointerType())) {
                  $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(E.getExprLoc(), diag.err_omp_aligned_expected_array_or_ptr)), 
                              QTy), $this().getLangOpts().CPlusPlus), E.getSourceRange()));
                  $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(PVD.getLocation(), diag.note_previous_decl)), PVD));
                }
                continue;
              }
            }
          }
        }
      }
      if (isa_CXXThisExpr(E)) {
        if ((AlignedThis != null)) {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(E.getExprLoc(), diag.err_omp_aligned_twice)), 
                  2), E.getSourceRange()));
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(AlignedThis.getExprLoc(), diag.note_omp_explicit_dsa)), 
              getOpenMPClauseName(OpenMPClauseKind.OMPC_aligned)));
        }
        AlignedThis = E;
        continue;
      }
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(E.getExprLoc(), diag.err_omp_param_or_this_in_clause)), 
              FD.getDeclName()), (isa_CXXMethodDecl(ADecl) ? 1 : 0)));
    } finally {
      $c$.$destroy();
    }
  }
  // The optional parameter of the aligned clause, alignment, must be a constant
  // positive integer expression. If no optional parameter is specified,
  // implementation-defined default alignments for SIMD instructions on the
  // target platforms are assumed.
  SmallVector<Expr /*P*/ > NewAligns/*J*/= new SmallVector<Expr /*P*/ >(4, (Expr /*P*/ )null);
  for (Expr /*P*/ E : Alignments) {
    ActionResultTTrue<Expr /*P*/ > Align/*J*/= new ActionResultTTrue<Expr /*P*/ >();
    if ((E != null)) {
      Align.$assignMove($this().VerifyPositiveIntegerConstantInClause(E, OpenMPClauseKind.OMPC_aligned));
    }
    NewAligns.push_back(Align.get());
  }
  // OpenMP [2.8.2, declare simd construct, Description]
  // The linear clause declares one or more list items to be private to a SIMD
  // lane and to have a linear relationship with respect to the iteration space
  // of a loop.
  // The special this pointer can be used as if was one of the arguments to the
  // function in any of the linear, aligned, or uniform clauses.
  // When a linear-step expression is specified in a linear clause it must be
  // either a constant integer expression or an integer-typed parameter that is
  // specified in a uniform clause on the directive.
  DenseMap<Decl /*P*/ , Expr /*P*/ > LinearArgs/*J*/= new DenseMap<Decl /*P*/ , Expr /*P*/ >(DenseMapInfo$LikePtr.$Info(), (Expr /*P*/ )null);
  /*const*/boolean IsUniformedThis = UniformedLinearThis != null;
  /*const*/uint$ptr/*uint P*/ MI = $tryClone(LinModifiers.begin());
  for (Expr /*P*/ E : Linears) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      OpenMPLinearClauseKind LinKind = /*static_cast*/OpenMPLinearClauseKind.valueOf(MI.$star());
      MI.$preInc();
      E = E.IgnoreParenImpCasts();
      {
        DeclRefExpr /*P*/ DRE = dyn_cast_DeclRefExpr(E);
        if ((DRE != null)) {
          {
            ParmVarDecl /*P*/ PVD = dyn_cast_ParmVarDecl(DRE.getDecl());
            if ((PVD != null)) {
              VarDecl /*P*/ CanonPVD = PVD.getCanonicalDecl();
              if ($greater_uint(FD.getNumParams(), PVD.getFunctionScopeIndex())
                 && FD.getParamDecl(PVD.getFunctionScopeIndex()).
                  getCanonicalDecl() == CanonPVD) {
                // OpenMP  [2.15.3.7, linear Clause, Restrictions]
                // A list-item cannot appear in more than one linear clause.
                if ($greater_uint(LinearArgs.count(CanonPVD), 0)) {
                  $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(E.getExprLoc(), diag.err_omp_wrong_dsa)), 
                              getOpenMPClauseName(OpenMPClauseKind.OMPC_linear)), 
                          getOpenMPClauseName(OpenMPClauseKind.OMPC_linear)), E.getSourceRange()));
                  $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(LinearArgs.$at_T1$RR(CanonPVD).getExprLoc(), 
                          diag.note_omp_explicit_dsa)), 
                      getOpenMPClauseName(OpenMPClauseKind.OMPC_linear)));
                  continue;
                }
                // Each argument can appear in at most one uniform or linear clause.
                if ($greater_uint(UniformedArgs.count(CanonPVD), 0)) {
                  $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(E.getExprLoc(), diag.err_omp_wrong_dsa)), 
                              getOpenMPClauseName(OpenMPClauseKind.OMPC_linear)), 
                          getOpenMPClauseName(OpenMPClauseKind.OMPC_uniform)), E.getSourceRange()));
                  $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(UniformedArgs.$at_T1$RR(CanonPVD).getExprLoc(), 
                          diag.note_omp_explicit_dsa)), 
                      getOpenMPClauseName(OpenMPClauseKind.OMPC_uniform)));
                  continue;
                }
                LinearArgs.$set(CanonPVD, E);
                if (E.isValueDependent() || E.isTypeDependent()
                   || E.isInstantiationDependent()
                   || E.containsUnexpandedParameterPack()) {
                  continue;
                }
                /*J:(void)*/$this().CheckOpenMPLinearDecl(CanonPVD, E.getExprLoc(), LinKind, 
                    PVD.getOriginalType());
                continue;
              }
            }
          }
        }
      }
      if (isa_CXXThisExpr(E)) {
        if ((UniformedLinearThis != null)) {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(E.getExprLoc(), diag.err_omp_wrong_dsa)), 
                      getOpenMPClauseName(OpenMPClauseKind.OMPC_linear)), 
                  getOpenMPClauseName(IsUniformedThis ? OpenMPClauseKind.OMPC_uniform : OpenMPClauseKind.OMPC_linear)), 
              E.getSourceRange()));
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(UniformedLinearThis.getExprLoc(), diag.note_omp_explicit_dsa)), 
              getOpenMPClauseName(IsUniformedThis ? OpenMPClauseKind.OMPC_uniform : OpenMPClauseKind.OMPC_linear)));
          continue;
        }
        UniformedLinearThis = E;
        if (E.isValueDependent() || E.isTypeDependent()
           || E.isInstantiationDependent() || E.containsUnexpandedParameterPack()) {
          continue;
        }
        /*J:(void)*/$this().CheckOpenMPLinearDecl(/*D=*/ (ValueDecl /*P*/ )null, E.getExprLoc(), LinKind, 
            E.getType());
        continue;
      }
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(E.getExprLoc(), diag.err_omp_param_or_this_in_clause)), 
              FD.getDeclName()), (isa_CXXMethodDecl(ADecl) ? 1 : 0)));
    } finally {
      $c$.$destroy();
    }
  }
  Expr /*P*/ Step = null;
  Expr /*P*/ NewStep = null;
  SmallVector<Expr /*P*/ > NewSteps/*J*/= new SmallVector<Expr /*P*/ >(4, (Expr /*P*/ )null);
  for (Expr /*P*/ E : Steps) {
    // Skip the same step expression, it was checked already.
    if (Step == E || !(E != null)) {
      NewSteps.push_back((E != null) ? NewStep : (Expr /*P*/ )null);
      continue;
    }
    Step = E;
    {
      DeclRefExpr /*P*/ DRE = dyn_cast_DeclRefExpr(Step);
      if ((DRE != null)) {
        {
          ParmVarDecl /*P*/ PVD = dyn_cast_ParmVarDecl(DRE.getDecl());
          if ((PVD != null)) {
            VarDecl /*P*/ CanonPVD = PVD.getCanonicalDecl();
            if (UniformedArgs.count(CanonPVD) == 0) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Step.getExprLoc(), diag.err_omp_expected_uniform_param)), 
                    Step.getSourceRange()));
              } finally {
                $c$.$destroy();
              }
            } else if (E.isValueDependent() || E.isTypeDependent()
               || E.isInstantiationDependent()
               || E.containsUnexpandedParameterPack()
               || CanonPVD.getType().$arrow().hasIntegerRepresentation()) {
              NewSteps.push_back(Step);
            } else {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Step.getExprLoc(), diag.err_omp_expected_int_param)), 
                    Step.getSourceRange()));
              } finally {
                $c$.$destroy();
              }
            }
            continue;
          }
        }
      }
    }
    NewStep = Step;
    if ((Step != null) && !Step.isValueDependent() && !Step.isTypeDependent()
       && !Step.isInstantiationDependent()
       && !Step.containsUnexpandedParameterPack()) {
      NewStep = $this().PerformOpenMPImplicitIntegerConversion(Step.getExprLoc(), Step).
          get();
      if ((NewStep != null)) {
        NewStep = $this().VerifyIntegerConstantExpression(NewStep).get();
      }
    }
    NewSteps.push_back(NewStep);
  }
  OMPDeclareSimdDeclAttr /*P*/ NewAttr = OMPDeclareSimdDeclAttr.CreateImplicit($this().Context, BS, SL.get(), ((/*const_cast*/type$ptr<Expr /*P*/ /*P*/>)(Uniforms.data())), 
      Uniforms.size(), ((/*const_cast*/type$ptr<Expr /*P*/ /*P*/>)(Aligneds.data())), Aligneds.size(), 
      ((/*const_cast*/type$ptr<Expr /*P*/ /*P*/>)(NewAligns.data())), NewAligns.size(), 
      ((/*const_cast*/type$ptr<Expr /*P*/ /*P*/>)(Linears.data())), Linears.size(), 
      ((/*const_cast*/uint$ptr/*uint P*/ )(LinModifiers.data())), LinModifiers.size(), 
      NewSteps.data(), NewSteps.size(), new SourceRange(SR));
  ADecl.addAttr(NewAttr);
  return $this().ConvertDeclToDeclGroup(ADecl);
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnOpenMPSingleExprClause">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 7210,
 FQN="clang::Sema::ActOnOpenMPSingleExprClause", NM="_ZN5clang4Sema27ActOnOpenMPSingleExprClauseENS_16OpenMPClauseKindEPNS_4ExprENS_14SourceLocationES4_S4_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4Sema27ActOnOpenMPSingleExprClauseENS_16OpenMPClauseKindEPNS_4ExprENS_14SourceLocationES4_S4_")
//</editor-fold>
public final OMPClause /*P*/ ActOnOpenMPSingleExprClause(OpenMPClauseKind Kind, Expr /*P*/ $Expr, 
                           SourceLocation StartLoc, 
                           SourceLocation LParenLoc, 
                           SourceLocation EndLoc) {
  OMPClause /*P*/ Res = null;
  switch (Kind) {
   case OMPC_final:
    Res = $this().ActOnOpenMPFinalClause($Expr, new SourceLocation(StartLoc), new SourceLocation(LParenLoc), new SourceLocation(EndLoc));
    break;
   case OMPC_num_threads:
    Res = $this().ActOnOpenMPNumThreadsClause($Expr, new SourceLocation(StartLoc), new SourceLocation(LParenLoc), new SourceLocation(EndLoc));
    break;
   case OMPC_safelen:
    Res = $this().ActOnOpenMPSafelenClause($Expr, new SourceLocation(StartLoc), new SourceLocation(LParenLoc), new SourceLocation(EndLoc));
    break;
   case OMPC_simdlen:
    Res = $this().ActOnOpenMPSimdlenClause($Expr, new SourceLocation(StartLoc), new SourceLocation(LParenLoc), new SourceLocation(EndLoc));
    break;
   case OMPC_collapse:
    Res = $this().ActOnOpenMPCollapseClause($Expr, new SourceLocation(StartLoc), new SourceLocation(LParenLoc), new SourceLocation(EndLoc));
    break;
   case OMPC_ordered:
    Res = $this().ActOnOpenMPOrderedClause(new SourceLocation(StartLoc), new SourceLocation(EndLoc), new SourceLocation(LParenLoc), $Expr);
    break;
   case OMPC_device:
    Res = $this().ActOnOpenMPDeviceClause($Expr, new SourceLocation(StartLoc), new SourceLocation(LParenLoc), new SourceLocation(EndLoc));
    break;
   case OMPC_num_teams:
    Res = $this().ActOnOpenMPNumTeamsClause($Expr, new SourceLocation(StartLoc), new SourceLocation(LParenLoc), new SourceLocation(EndLoc));
    break;
   case OMPC_thread_limit:
    Res = $this().ActOnOpenMPThreadLimitClause($Expr, new SourceLocation(StartLoc), new SourceLocation(LParenLoc), new SourceLocation(EndLoc));
    break;
   case OMPC_priority:
    Res = $this().ActOnOpenMPPriorityClause($Expr, new SourceLocation(StartLoc), new SourceLocation(LParenLoc), new SourceLocation(EndLoc));
    break;
   case OMPC_grainsize:
    Res = $this().ActOnOpenMPGrainsizeClause($Expr, new SourceLocation(StartLoc), new SourceLocation(LParenLoc), new SourceLocation(EndLoc));
    break;
   case OMPC_num_tasks:
    Res = $this().ActOnOpenMPNumTasksClause($Expr, new SourceLocation(StartLoc), new SourceLocation(LParenLoc), new SourceLocation(EndLoc));
    break;
   case OMPC_hint:
    Res = $this().ActOnOpenMPHintClause($Expr, new SourceLocation(StartLoc), new SourceLocation(LParenLoc), new SourceLocation(EndLoc));
    break;
   case OMPC_if:
   case OMPC_default:
   case OMPC_proc_bind:
   case OMPC_schedule:
   case OMPC_private:
   case OMPC_firstprivate:
   case OMPC_lastprivate:
   case OMPC_shared:
   case OMPC_reduction:
   case OMPC_linear:
   case OMPC_aligned:
   case OMPC_copyin:
   case OMPC_copyprivate:
   case OMPC_nowait:
   case OMPC_untied:
   case OMPC_mergeable:
   case OMPC_threadprivate:
   case OMPC_flush:
   case OMPC_read:
   case OMPC_write:
   case OMPC_update:
   case OMPC_capture:
   case OMPC_seq_cst:
   case OMPC_depend:
   case OMPC_threads:
   case OMPC_simd:
   case OMPC_map:
   case OMPC_nogroup:
   case OMPC_dist_schedule:
   case OMPC_defaultmap:
   case OMPC_unknown:
   case OMPC_uniform:
   case OMPC_to:
   case OMPC_from:
   case OMPC_use_device_ptr:
   case OMPC_is_device_ptr:
    throw new llvm_unreachable("Clause is not allowed.");
  }
  return Res;
}

/// \brief Called on well-formed 'if' clause.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnOpenMPIfClause">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 7296,
 FQN="clang::Sema::ActOnOpenMPIfClause", NM="_ZN5clang4Sema19ActOnOpenMPIfClauseENS_19OpenMPDirectiveKindEPNS_4ExprENS_14SourceLocationES4_S4_S4_S4_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4Sema19ActOnOpenMPIfClauseENS_19OpenMPDirectiveKindEPNS_4ExprENS_14SourceLocationES4_S4_S4_S4_")
//</editor-fold>
public final OMPClause /*P*/ ActOnOpenMPIfClause(OpenMPDirectiveKind NameModifier, 
                   Expr /*P*/ Condition, SourceLocation StartLoc, 
                   SourceLocation LParenLoc, 
                   SourceLocation NameModifierLoc, 
                   SourceLocation ColonLoc, 
                   SourceLocation EndLoc) {
  Expr /*P*/ ValExpr = Condition;
  if (!Condition.isValueDependent() && !Condition.isTypeDependent()
     && !Condition.isInstantiationDependent()
     && !Condition.containsUnexpandedParameterPack()) {
    ActionResultTTrue<Expr /*P*/ > Val = $this().CheckBooleanCondition(new SourceLocation(StartLoc), Condition);
    if (Val.isInvalid()) {
      return null;
    }
    
    ValExpr = $this().MakeFullExpr(Val.get()).get();
  }
  
  return /*FIXME:NEW_EXPR*//*new (Context)*/ new OMPIfClause(NameModifier, ValExpr, new SourceLocation(StartLoc), new SourceLocation(LParenLoc), 
      new SourceLocation(NameModifierLoc), new SourceLocation(ColonLoc), new SourceLocation(EndLoc));
}

/// \brief Called on well-formed 'final' clause.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnOpenMPFinalClause">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 7317,
 FQN="clang::Sema::ActOnOpenMPFinalClause", NM="_ZN5clang4Sema22ActOnOpenMPFinalClauseEPNS_4ExprENS_14SourceLocationES3_S3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4Sema22ActOnOpenMPFinalClauseEPNS_4ExprENS_14SourceLocationES3_S3_")
//</editor-fold>
public final OMPClause /*P*/ ActOnOpenMPFinalClause(Expr /*P*/ Condition, 
                      SourceLocation StartLoc, 
                      SourceLocation LParenLoc, 
                      SourceLocation EndLoc) {
  Expr /*P*/ ValExpr = Condition;
  if (!Condition.isValueDependent() && !Condition.isTypeDependent()
     && !Condition.isInstantiationDependent()
     && !Condition.containsUnexpandedParameterPack()) {
    ActionResultTTrue<Expr /*P*/ > Val = $this().CheckBooleanCondition(new SourceLocation(StartLoc), Condition);
    if (Val.isInvalid()) {
      return null;
    }
    
    ValExpr = $this().MakeFullExpr(Val.get()).get();
  }
  
  return /*FIXME:NEW_EXPR*//*new (Context)*/ new OMPFinalClause(ValExpr, new SourceLocation(StartLoc), new SourceLocation(LParenLoc), new SourceLocation(EndLoc));
}

/// \brief Called on well-formed 'num_threads' clause.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnOpenMPNumThreadsClause">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 7405,
 FQN="clang::Sema::ActOnOpenMPNumThreadsClause", NM="_ZN5clang4Sema27ActOnOpenMPNumThreadsClauseEPNS_4ExprENS_14SourceLocationES3_S3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4Sema27ActOnOpenMPNumThreadsClauseEPNS_4ExprENS_14SourceLocationES3_S3_")
//</editor-fold>
public final OMPClause /*P*/ ActOnOpenMPNumThreadsClause(Expr /*P*/ NumThreads, 
                           SourceLocation StartLoc, 
                           SourceLocation LParenLoc, 
                           SourceLocation EndLoc) {
  type$ref<Expr /*P*/ > ValExpr = create_type$ref(NumThreads);
  
  // OpenMP [2.5, Restrictions]
  //  The num_threads expression must evaluate to a positive integer value.
  if (!IsNonNegativeIntegerValue(ValExpr, /*Deref*/$this(), OpenMPClauseKind.OMPC_num_threads, 
      /*StrictlyPositive=*/ true)) {
    return null;
  }
  
  return /*FIXME:NEW_EXPR*//*new (Context)*/ new OMPNumThreadsClause(ValExpr.$deref(), new SourceLocation(StartLoc), new SourceLocation(LParenLoc), new SourceLocation(EndLoc));
}

/// \brief Called on well-formed 'safelen' clause.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnOpenMPSafelenClause">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 7452,
 FQN="clang::Sema::ActOnOpenMPSafelenClause", NM="_ZN5clang4Sema24ActOnOpenMPSafelenClauseEPNS_4ExprENS_14SourceLocationES3_S3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4Sema24ActOnOpenMPSafelenClauseEPNS_4ExprENS_14SourceLocationES3_S3_")
//</editor-fold>
public final OMPClause /*P*/ ActOnOpenMPSafelenClause(Expr /*P*/ Len, SourceLocation StartLoc, 
                        SourceLocation LParenLoc, 
                        SourceLocation EndLoc) {
  // OpenMP [2.8.1, simd construct, Description]
  // The parameter of the safelen clause must be a constant
  // positive integer expression.
  ActionResultTTrue<Expr /*P*/ > Safelen = $this().VerifyPositiveIntegerConstantInClause(Len, OpenMPClauseKind.OMPC_safelen);
  if (Safelen.isInvalid()) {
    return null;
  }
  return /*FIXME:NEW_EXPR*//*new (Context)*/ new OMPSafelenClause(Safelen.get(), new SourceLocation(StartLoc), new SourceLocation(LParenLoc), new SourceLocation(EndLoc));
}

/// \brief Called on well-formed 'simdlen' clause.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnOpenMPSimdlenClause">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 7465,
 FQN="clang::Sema::ActOnOpenMPSimdlenClause", NM="_ZN5clang4Sema24ActOnOpenMPSimdlenClauseEPNS_4ExprENS_14SourceLocationES3_S3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4Sema24ActOnOpenMPSimdlenClauseEPNS_4ExprENS_14SourceLocationES3_S3_")
//</editor-fold>
public final OMPClause /*P*/ ActOnOpenMPSimdlenClause(Expr /*P*/ Len, SourceLocation StartLoc, 
                        SourceLocation LParenLoc, 
                        SourceLocation EndLoc) {
  // OpenMP [2.8.1, simd construct, Description]
  // The parameter of the simdlen clause must be a constant
  // positive integer expression.
  ActionResultTTrue<Expr /*P*/ > Simdlen = $this().VerifyPositiveIntegerConstantInClause(Len, OpenMPClauseKind.OMPC_simdlen);
  if (Simdlen.isInvalid()) {
    return null;
  }
  return /*FIXME:NEW_EXPR*//*new (Context)*/ new OMPSimdlenClause(Simdlen.get(), new SourceLocation(StartLoc), new SourceLocation(LParenLoc), new SourceLocation(EndLoc));
}

/// \brief Called on well-formed 'collapse' clause.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnOpenMPCollapseClause">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 7478,
 FQN="clang::Sema::ActOnOpenMPCollapseClause", NM="_ZN5clang4Sema25ActOnOpenMPCollapseClauseEPNS_4ExprENS_14SourceLocationES3_S3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4Sema25ActOnOpenMPCollapseClauseEPNS_4ExprENS_14SourceLocationES3_S3_")
//</editor-fold>
public final OMPClause /*P*/ ActOnOpenMPCollapseClause(Expr /*P*/ NumForLoops, 
                         SourceLocation StartLoc, 
                         SourceLocation LParenLoc, 
                         SourceLocation EndLoc) {
  // OpenMP [2.7.1, loop construct, Description]
  // OpenMP [2.8.1, simd construct, Description]
  // OpenMP [2.9.6, distribute construct, Description]
  // The parameter of the collapse clause must be a constant
  // positive integer expression.
  ActionResultTTrue<Expr /*P*/ > NumForLoopsResult = $this().VerifyPositiveIntegerConstantInClause(NumForLoops, OpenMPClauseKind.OMPC_collapse);
  if (NumForLoopsResult.isInvalid()) {
    return null;
  }
  return /*FIXME:NEW_EXPR*//*new (Context)*/ new OMPCollapseClause(NumForLoopsResult.get(), new SourceLocation(StartLoc), new SourceLocation(LParenLoc), new SourceLocation(EndLoc));
}

/// \brief Called on well-formed 'ordered' clause.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnOpenMPOrderedClause">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 7495,
 FQN="clang::Sema::ActOnOpenMPOrderedClause", NM="_ZN5clang4Sema24ActOnOpenMPOrderedClauseENS_14SourceLocationES1_S1_PNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4Sema24ActOnOpenMPOrderedClauseENS_14SourceLocationES1_S1_PNS_4ExprE")
//</editor-fold>
public final OMPClause /*P*/ ActOnOpenMPOrderedClause(SourceLocation StartLoc, 
                        SourceLocation EndLoc) {
  return ActOnOpenMPOrderedClause(StartLoc, 
                        EndLoc, 
                        new SourceLocation(), 
                        (Expr /*P*/ )null);
}
public final OMPClause /*P*/ ActOnOpenMPOrderedClause(SourceLocation StartLoc, 
                        SourceLocation EndLoc, 
                        SourceLocation LParenLoc/*= SourceLocation()*/) {
  return ActOnOpenMPOrderedClause(StartLoc, 
                        EndLoc, 
                        LParenLoc, 
                        (Expr /*P*/ )null);
}
public final OMPClause /*P*/ ActOnOpenMPOrderedClause(SourceLocation StartLoc, 
                        SourceLocation EndLoc, 
                        SourceLocation LParenLoc/*= SourceLocation()*/, 
                        Expr /*P*/ NumForLoops/*= null*/) {
  // OpenMP [2.7.1, loop construct, Description]
  // OpenMP [2.8.1, simd construct, Description]
  // OpenMP [2.9.6, distribute construct, Description]
  // The parameter of the ordered clause must be a constant
  // positive integer expression if any.
  if ((NumForLoops != null) && LParenLoc.isValid()) {
    ActionResultTTrue<Expr /*P*/ > NumForLoopsResult = $this().VerifyPositiveIntegerConstantInClause(NumForLoops, OpenMPClauseKind.OMPC_ordered);
    if (NumForLoopsResult.isInvalid()) {
      return null;
    }
    NumForLoops = NumForLoopsResult.get();
  } else {
    NumForLoops = null;
  }
  ((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).setOrderedRegion(/*IsOrdered=*/ true, NumForLoops);
  return /*FIXME:NEW_EXPR*//*new (Context)*/ new OMPOrderedClause(NumForLoops, new SourceLocation(StartLoc), new SourceLocation(LParenLoc), new SourceLocation(EndLoc));
}

/// \brief Called on well-formed 'grainsize' clause.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnOpenMPGrainsizeClause">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 11304,
 FQN="clang::Sema::ActOnOpenMPGrainsizeClause", NM="_ZN5clang4Sema26ActOnOpenMPGrainsizeClauseEPNS_4ExprENS_14SourceLocationES3_S3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4Sema26ActOnOpenMPGrainsizeClauseEPNS_4ExprENS_14SourceLocationES3_S3_")
//</editor-fold>
public final OMPClause /*P*/ ActOnOpenMPGrainsizeClause(Expr /*P*/ Grainsize, 
                          SourceLocation StartLoc, 
                          SourceLocation LParenLoc, 
                          SourceLocation EndLoc) {
  type$ref<Expr /*P*/ > ValExpr = create_type$ref(Grainsize);
  
  // OpenMP [2.9.2, taskloop Constrcut]
  // The parameter of the grainsize clause must be a positive integer
  // expression.
  if (!IsNonNegativeIntegerValue(ValExpr, /*Deref*/$this(), OpenMPClauseKind.OMPC_grainsize, 
      /*StrictlyPositive=*/ true)) {
    return null;
  }
  
  return /*FIXME:NEW_EXPR*//*new (Context)*/ new OMPGrainsizeClause(ValExpr.$deref(), new SourceLocation(StartLoc), new SourceLocation(LParenLoc), new SourceLocation(EndLoc));
}

/// \brief Called on well-formed 'num_tasks' clause.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnOpenMPNumTasksClause">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 11320,
 FQN="clang::Sema::ActOnOpenMPNumTasksClause", NM="_ZN5clang4Sema25ActOnOpenMPNumTasksClauseEPNS_4ExprENS_14SourceLocationES3_S3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4Sema25ActOnOpenMPNumTasksClauseEPNS_4ExprENS_14SourceLocationES3_S3_")
//</editor-fold>
public final OMPClause /*P*/ ActOnOpenMPNumTasksClause(Expr /*P*/ NumTasks, 
                         SourceLocation StartLoc, 
                         SourceLocation LParenLoc, 
                         SourceLocation EndLoc) {
  type$ref<Expr /*P*/ > ValExpr = create_type$ref(NumTasks);
  
  // OpenMP [2.9.2, taskloop Constrcut]
  // The parameter of the num_tasks clause must be a positive integer
  // expression.
  if (!IsNonNegativeIntegerValue(ValExpr, /*Deref*/$this(), OpenMPClauseKind.OMPC_num_tasks, 
      /*StrictlyPositive=*/ true)) {
    return null;
  }
  
  return /*FIXME:NEW_EXPR*//*new (Context)*/ new OMPNumTasksClause(ValExpr.$deref(), new SourceLocation(StartLoc), new SourceLocation(LParenLoc), new SourceLocation(EndLoc));
}

/// \brief Called on well-formed 'hint' clause.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnOpenMPHintClause">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 11336,
 FQN="clang::Sema::ActOnOpenMPHintClause", NM="_ZN5clang4Sema21ActOnOpenMPHintClauseEPNS_4ExprENS_14SourceLocationES3_S3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4Sema21ActOnOpenMPHintClauseEPNS_4ExprENS_14SourceLocationES3_S3_")
//</editor-fold>
public final OMPClause /*P*/ ActOnOpenMPHintClause(Expr /*P*/ Hint, SourceLocation StartLoc, 
                     SourceLocation LParenLoc, 
                     SourceLocation EndLoc) {
  // OpenMP [2.13.2, critical construct, Description]
  // ... where hint-expression is an integer constant expression that evaluates
  // to a valid lock hint.
  ActionResultTTrue<Expr /*P*/ > HintExpr = $this().VerifyPositiveIntegerConstantInClause(Hint, OpenMPClauseKind.OMPC_hint);
  if (HintExpr.isInvalid()) {
    return null;
  }
  return /*FIXME:NEW_EXPR*//*new (Context)*/ new OMPHintClause(HintExpr.get(), new SourceLocation(StartLoc), new SourceLocation(LParenLoc), new SourceLocation(EndLoc));
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnOpenMPSimpleClause">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 7517,
 FQN="clang::Sema::ActOnOpenMPSimpleClause", NM="_ZN5clang4Sema23ActOnOpenMPSimpleClauseENS_16OpenMPClauseKindEjNS_14SourceLocationES2_S2_S2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4Sema23ActOnOpenMPSimpleClauseENS_16OpenMPClauseKindEjNS_14SourceLocationES2_S2_S2_")
//</editor-fold>
public final OMPClause /*P*/ ActOnOpenMPSimpleClause(OpenMPClauseKind Kind, /*uint*/int Argument, SourceLocation ArgumentLoc, 
                       SourceLocation StartLoc, SourceLocation LParenLoc, SourceLocation EndLoc) {
  OMPClause /*P*/ Res = null;
  switch (Kind) {
   case OMPC_default:
    Res
       = $this().ActOnOpenMPDefaultClause(/*static_cast*/OpenMPDefaultClauseKind.valueOf(Argument), 
        new SourceLocation(ArgumentLoc), new SourceLocation(StartLoc), new SourceLocation(LParenLoc), new SourceLocation(EndLoc));
    break;
   case OMPC_proc_bind:
    Res = $this().ActOnOpenMPProcBindClause(/*static_cast*/OpenMPProcBindClauseKind.valueOf(Argument), new SourceLocation(ArgumentLoc), new SourceLocation(StartLoc), 
        new SourceLocation(LParenLoc), new SourceLocation(EndLoc));
    break;
   case OMPC_if:
   case OMPC_final:
   case OMPC_num_threads:
   case OMPC_safelen:
   case OMPC_simdlen:
   case OMPC_collapse:
   case OMPC_schedule:
   case OMPC_private:
   case OMPC_firstprivate:
   case OMPC_lastprivate:
   case OMPC_shared:
   case OMPC_reduction:
   case OMPC_linear:
   case OMPC_aligned:
   case OMPC_copyin:
   case OMPC_copyprivate:
   case OMPC_ordered:
   case OMPC_nowait:
   case OMPC_untied:
   case OMPC_mergeable:
   case OMPC_threadprivate:
   case OMPC_flush:
   case OMPC_read:
   case OMPC_write:
   case OMPC_update:
   case OMPC_capture:
   case OMPC_seq_cst:
   case OMPC_depend:
   case OMPC_device:
   case OMPC_threads:
   case OMPC_simd:
   case OMPC_map:
   case OMPC_num_teams:
   case OMPC_thread_limit:
   case OMPC_priority:
   case OMPC_grainsize:
   case OMPC_nogroup:
   case OMPC_num_tasks:
   case OMPC_hint:
   case OMPC_dist_schedule:
   case OMPC_defaultmap:
   case OMPC_unknown:
   case OMPC_uniform:
   case OMPC_to:
   case OMPC_from:
   case OMPC_use_device_ptr:
   case OMPC_is_device_ptr:
    throw new llvm_unreachable("Clause is not allowed.");
  }
  return Res;
}

/// \brief Called on well-formed 'default' clause.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnOpenMPDefaultClause">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 7607,
 FQN="clang::Sema::ActOnOpenMPDefaultClause", NM="_ZN5clang4Sema24ActOnOpenMPDefaultClauseENS_23OpenMPDefaultClauseKindENS_14SourceLocationES2_S2_S2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4Sema24ActOnOpenMPDefaultClauseENS_23OpenMPDefaultClauseKindENS_14SourceLocationES2_S2_S2_")
//</editor-fold>
public final OMPClause /*P*/ ActOnOpenMPDefaultClause(OpenMPDefaultClauseKind Kind, 
                        SourceLocation KindKwLoc, 
                        SourceLocation StartLoc, 
                        SourceLocation LParenLoc, 
                        SourceLocation EndLoc) {
  if (Kind == OpenMPDefaultClauseKind.OMPC_DEFAULT_unknown) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      static_assert(OpenMPDefaultClauseKind.OMPC_DEFAULT_unknown.getValue() > 0, $("OMPC_DEFAULT_unknown not greater than 0"));
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(KindKwLoc), diag.err_omp_unexpected_clause_value)), 
              getListOfPossibleValues(OpenMPClauseKind.OMPC_default, /*First=*/ 0, 
                  /*Last=*/ OpenMPDefaultClauseKind.OMPC_DEFAULT_unknown.getValue())), 
          getOpenMPClauseName(OpenMPClauseKind.OMPC_default)));
      return null;
    } finally {
      $c$.$destroy();
    }
  }
  switch (Kind) {
   case OMPC_DEFAULT_none:
    ((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).setDefaultDSANone(new SourceLocation(KindKwLoc));
    break;
   case OMPC_DEFAULT_shared:
    ((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).setDefaultDSAShared(new SourceLocation(KindKwLoc));
    break;
   case OMPC_DEFAULT_unknown:
    throw new llvm_unreachable("Clause kind is not allowed.");
//    break;
  }
  return /*FIXME:NEW_EXPR*//*new (Context)*/ new OMPDefaultClause(Kind, new SourceLocation(KindKwLoc), new SourceLocation(StartLoc), new SourceLocation(LParenLoc), new SourceLocation(EndLoc));
}

/// \brief Called on well-formed 'proc_bind' clause.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnOpenMPProcBindClause">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 7636,
 FQN="clang::Sema::ActOnOpenMPProcBindClause", NM="_ZN5clang4Sema25ActOnOpenMPProcBindClauseENS_24OpenMPProcBindClauseKindENS_14SourceLocationES2_S2_S2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4Sema25ActOnOpenMPProcBindClauseENS_24OpenMPProcBindClauseKindENS_14SourceLocationES2_S2_S2_")
//</editor-fold>
public final OMPClause /*P*/ ActOnOpenMPProcBindClause(OpenMPProcBindClauseKind Kind, 
                         SourceLocation KindKwLoc, 
                         SourceLocation StartLoc, 
                         SourceLocation LParenLoc, 
                         SourceLocation EndLoc) {
  if (Kind == OpenMPProcBindClauseKind.OMPC_PROC_BIND_unknown) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(KindKwLoc), diag.err_omp_unexpected_clause_value)), 
              getListOfPossibleValues(OpenMPClauseKind.OMPC_proc_bind, /*First=*/ 0, 
                  /*Last=*/ OpenMPProcBindClauseKind.OMPC_PROC_BIND_unknown.getValue())), 
          getOpenMPClauseName(OpenMPClauseKind.OMPC_proc_bind)));
      return null;
    } finally {
      $c$.$destroy();
    }
  }
  return /*FIXME:NEW_EXPR*//*new (Context)*/ new OMPProcBindClause(Kind, new SourceLocation(KindKwLoc), new SourceLocation(StartLoc), new SourceLocation(LParenLoc), new SourceLocation(EndLoc));
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnOpenMPSingleExprWithArgClause">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 7652,
 FQN="clang::Sema::ActOnOpenMPSingleExprWithArgClause", NM="_ZN5clang4Sema34ActOnOpenMPSingleExprWithArgClauseENS_16OpenMPClauseKindEN4llvm8ArrayRefIjEEPNS_4ExprENS_14SourceLocationES7_NS3_IS7_EES7_S7_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4Sema34ActOnOpenMPSingleExprWithArgClauseENS_16OpenMPClauseKindEN4llvm8ArrayRefIjEEPNS_4ExprENS_14SourceLocationES7_NS3_IS7_EES7_S7_")
//</editor-fold>
public final OMPClause /*P*/ ActOnOpenMPSingleExprWithArgClause(OpenMPClauseKind Kind, ArrayRefUInt Argument, Expr /*P*/ $Expr, 
                                  SourceLocation StartLoc, SourceLocation LParenLoc, 
                                  ArrayRef<SourceLocation> ArgumentLoc, SourceLocation DelimLoc, 
                                  SourceLocation EndLoc) {
  OMPClause /*P*/ Res = null;
  switch (Kind) {
   case OMPC_schedule:
    /*enum ANONYMOUS_INT_CONSTANTS {*/
      final /*uint*/int Modifier1 = 0;
      final /*uint*/int Modifier2 = Modifier1 + 1;
      final /*uint*/int ScheduleKind = Modifier2 + 1;
      final /*uint*/int NumberOfElements = ScheduleKind + 1;
    /*}*/;
    assert (Argument.size() == NumberOfElements && ArgumentLoc.size() == NumberOfElements);
    Res = $this().ActOnOpenMPScheduleClause(((/*static_cast*//*OpenMPScheduleClauseModifier*/int)(Argument.$at(/*KEEP_ENUM*/Modifier1))), 
        ((/*static_cast*//*OpenMPScheduleClauseModifier*/int)(Argument.$at(/*KEEP_ENUM*/Modifier2))), 
        ((/*static_cast*//*OpenMPScheduleClauseKind*/int)(Argument.$at(/*KEEP_ENUM*/ScheduleKind))), $Expr, 
        new SourceLocation(StartLoc), new SourceLocation(LParenLoc), new SourceLocation(ArgumentLoc.$at(/*KEEP_ENUM*/Modifier1)), new SourceLocation(ArgumentLoc.$at(/*KEEP_ENUM*/Modifier2)), 
        new SourceLocation(ArgumentLoc.$at(/*KEEP_ENUM*/ScheduleKind)), new SourceLocation(DelimLoc), new SourceLocation(EndLoc));
    break;
   case OMPC_if:
    assert (Argument.size() == 1 && ArgumentLoc.size() == 1);
    Res = $this().ActOnOpenMPIfClause(/*static_cast*/OpenMPDirectiveKind.valueOf(Argument.back()), 
        $Expr, new SourceLocation(StartLoc), new SourceLocation(LParenLoc), new SourceLocation(ArgumentLoc.back()), 
        new SourceLocation(DelimLoc), new SourceLocation(EndLoc));
    break;
   case OMPC_dist_schedule:
    Res = $this().ActOnOpenMPDistScheduleClause(((/*static_cast*//*OpenMPDistScheduleClauseKind*/int)(Argument.back())), $Expr, 
        new SourceLocation(StartLoc), new SourceLocation(LParenLoc), new SourceLocation(ArgumentLoc.back()), new SourceLocation(DelimLoc), new SourceLocation(EndLoc));
    break;
   case OMPC_defaultmap:
    /*enum ANONYMOUS_INT_CONSTANTS {*/
      final /*uint*/int Modifier = 0;
      final /*uint*/int DefaultmapKind = Modifier + 1;
    /*}*/;
    Res = $this().ActOnOpenMPDefaultmapClause(((/*static_cast*//*OpenMPDefaultmapClauseModifier*/int)(Argument.$at(/*KEEP_ENUM*/Modifier))), 
        ((/*static_cast*//*OpenMPDefaultmapClauseKind*/int)(Argument.$at(/*KEEP_ENUM*/DefaultmapKind))), 
        new SourceLocation(StartLoc), new SourceLocation(LParenLoc), new SourceLocation(ArgumentLoc.$at(/*KEEP_ENUM*/Modifier)), 
        new SourceLocation(ArgumentLoc.$at(/*KEEP_ENUM*/DefaultmapKind)), new SourceLocation(EndLoc));
    break;
   case OMPC_final:
   case OMPC_num_threads:
   case OMPC_safelen:
   case OMPC_simdlen:
   case OMPC_collapse:
   case OMPC_default:
   case OMPC_proc_bind:
   case OMPC_private:
   case OMPC_firstprivate:
   case OMPC_lastprivate:
   case OMPC_shared:
   case OMPC_reduction:
   case OMPC_linear:
   case OMPC_aligned:
   case OMPC_copyin:
   case OMPC_copyprivate:
   case OMPC_ordered:
   case OMPC_nowait:
   case OMPC_untied:
   case OMPC_mergeable:
   case OMPC_threadprivate:
   case OMPC_flush:
   case OMPC_read:
   case OMPC_write:
   case OMPC_update:
   case OMPC_capture:
   case OMPC_seq_cst:
   case OMPC_depend:
   case OMPC_device:
   case OMPC_threads:
   case OMPC_simd:
   case OMPC_map:
   case OMPC_num_teams:
   case OMPC_thread_limit:
   case OMPC_priority:
   case OMPC_grainsize:
   case OMPC_nogroup:
   case OMPC_num_tasks:
   case OMPC_hint:
   case OMPC_unknown:
   case OMPC_uniform:
   case OMPC_to:
   case OMPC_from:
   case OMPC_use_device_ptr:
   case OMPC_is_device_ptr:
    throw new llvm_unreachable("Clause is not allowed.");
  }
  return Res;
}

/// \brief Called on well-formed 'schedule' clause.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnOpenMPScheduleClause">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 7761,
 FQN="clang::Sema::ActOnOpenMPScheduleClause", NM="_ZN5clang4Sema25ActOnOpenMPScheduleClauseENS_28OpenMPScheduleClauseModifierES1_NS_24OpenMPScheduleClauseKindEPNS_4ExprENS_14SourceLocationES5_S5_S5_S5_S5_S5_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4Sema25ActOnOpenMPScheduleClauseENS_28OpenMPScheduleClauseModifierES1_NS_24OpenMPScheduleClauseKindEPNS_4ExprENS_14SourceLocationES5_S5_S5_S5_S5_S5_")
//</editor-fold>
public final OMPClause /*P*/ ActOnOpenMPScheduleClause(/*OpenMPScheduleClauseModifier*/int M1, /*OpenMPScheduleClauseModifier*/int M2, 
                         /*OpenMPScheduleClauseKind*/int Kind, Expr /*P*/ ChunkSize, SourceLocation StartLoc, 
                         SourceLocation LParenLoc, SourceLocation M1Loc, SourceLocation M2Loc, 
                         SourceLocation KindLoc, SourceLocation CommaLoc, SourceLocation EndLoc) {
  if (checkScheduleModifiers(/*Deref*/$this(), M1, M2, new SourceLocation(M1Loc), new SourceLocation(M2Loc))
     || checkScheduleModifiers(/*Deref*/$this(), M2, M1, new SourceLocation(M2Loc), new SourceLocation(M1Loc))) {
    return null;
  }
  // OpenMP, 2.7.1, Loop Construct, Restrictions
  // Either the monotonic modifier or the nonmonotonic modifier can be specified
  // but not both.
  if ((M1 == M2 && M1 != OpenMPScheduleClauseModifier.OMPC_SCHEDULE_MODIFIER_unknown)
     || (M1 == OpenMPScheduleClauseModifier.OMPC_SCHEDULE_MODIFIER_monotonic
     && M2 == OpenMPScheduleClauseModifier.OMPC_SCHEDULE_MODIFIER_nonmonotonic)
     || (M1 == OpenMPScheduleClauseModifier.OMPC_SCHEDULE_MODIFIER_nonmonotonic
     && M2 == OpenMPScheduleClauseModifier.OMPC_SCHEDULE_MODIFIER_monotonic)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(M2Loc), diag.err_omp_unexpected_schedule_modifier)), 
              getOpenMPSimpleClauseTypeName(OpenMPClauseKind.OMPC_schedule, M2)), 
          getOpenMPSimpleClauseTypeName(OpenMPClauseKind.OMPC_schedule, M1)));
      return null;
    } finally {
      $c$.$destroy();
    }
  }
  if (Kind == OpenMPScheduleClauseKind.OMPC_SCHEDULE_unknown) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      std.string Values/*J*/= new std.string();
      if (M1Loc.isInvalid() && M2Loc.isInvalid()) {
        /*uint*/int Exclude[/*1*/] = new /*uint*/int [/*1*/] {OpenMPScheduleClauseKind.OMPC_SCHEDULE_unknown};
        Values.$assignMove(getListOfPossibleValues(OpenMPClauseKind.OMPC_schedule, /*First=*/ 0, 
                /*Last=*/ OpenMPScheduleClauseModifier.OMPC_SCHEDULE_MODIFIER_last, 
                new ArrayRefUInt(Exclude)));
      } else {
        Values.$assignMove(getListOfPossibleValues(OpenMPClauseKind.OMPC_schedule, /*First=*/ 0, 
                /*Last=*/ OpenMPScheduleClauseKind.OMPC_SCHEDULE_unknown));
      }
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(KindLoc), diag.err_omp_unexpected_clause_value)), 
              Values), getOpenMPClauseName(OpenMPClauseKind.OMPC_schedule)));
      return null;
    } finally {
      $c$.$destroy();
    }
  }
  // OpenMP, 2.7.1, Loop Construct, Restrictions
  // The nonmonotonic modifier can only be specified with schedule(dynamic) or
  // schedule(guided).
  if ((M1 == OpenMPScheduleClauseModifier.OMPC_SCHEDULE_MODIFIER_nonmonotonic
     || M2 == OpenMPScheduleClauseModifier.OMPC_SCHEDULE_MODIFIER_nonmonotonic)
     && Kind != OpenMPScheduleClauseKind.OMPC_SCHEDULE_dynamic && Kind != OpenMPScheduleClauseKind.OMPC_SCHEDULE_guided) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track($this().Diag(new SourceLocation(M1 == OpenMPScheduleClauseModifier.OMPC_SCHEDULE_MODIFIER_nonmonotonic ? M1Loc : M2Loc), 
          diag.err_omp_schedule_nonmonotonic_static)));
      return null;
    } finally {
      $c$.$destroy();
    }
  }
  Expr /*P*/ ValExpr = ChunkSize;
  Stmt /*P*/ HelperValStmt = null;
  if ((ChunkSize != null)) {
    if (!ChunkSize.isValueDependent() && !ChunkSize.isTypeDependent()
       && !ChunkSize.isInstantiationDependent()
       && !ChunkSize.containsUnexpandedParameterPack()) {
      SourceLocation ChunkSizeLoc = ChunkSize.getLocStart();
      ActionResultTTrue<Expr /*P*/ > Val = $this().PerformOpenMPImplicitIntegerConversion(new SourceLocation(ChunkSizeLoc), ChunkSize);
      if (Val.isInvalid()) {
        return null;
      }
      
      ValExpr = Val.get();
      
      // OpenMP [2.7.1, Restrictions]
      //  chunk_size must be a loop invariant integer expression with a positive
      //  value.
      APSInt Result/*J*/= new APSInt();
      if (ValExpr.isIntegerConstantExpr(Result, $this().Context)) {
        if (Result.isSigned() && !Result.isStrictlyPositive()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(ChunkSizeLoc), diag.err_omp_negative_expression_in_clause)), 
                        /*KEEP_STR*/"schedule"), 1), ChunkSize.getSourceRange()));
            return null;
          } finally {
            $c$.$destroy();
          }
        }
      } else if (isParallelOrTaskRegion(((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).getCurrentDirective())
         && !$this().CurContext.isDependentContext()) {
        MapVectorPtrPtr<Expr /*P*/ , DeclRefExpr /*P*/ > Captures = null;
        try {
          Captures/*J*/= new MapVectorPtrPtr<Expr /*P*/ , DeclRefExpr /*P*/ >(DenseMapInfo$LikePtr.$Info(), (DeclRefExpr/*P*/)null);
          ValExpr = tryBuildCapture(/*Deref*/$this(), ValExpr, Captures).get();
          HelperValStmt = buildPreInits($this().Context, Captures);
        } finally {
          if (Captures != null) { Captures.$destroy(); }
        }
      }
    }
  }
  
  return /*FIXME:NEW_EXPR*//*new (Context)*/ new OMPScheduleClause(new SourceLocation(StartLoc), new SourceLocation(LParenLoc), new SourceLocation(KindLoc), new SourceLocation(CommaLoc), new SourceLocation(EndLoc), Kind, 
      ValExpr, HelperValStmt, M1, new SourceLocation(M1Loc), M2, new SourceLocation(M2Loc));
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnOpenMPClause">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 7845,
 FQN="clang::Sema::ActOnOpenMPClause", NM="_ZN5clang4Sema17ActOnOpenMPClauseENS_16OpenMPClauseKindENS_14SourceLocationES2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4Sema17ActOnOpenMPClauseENS_16OpenMPClauseKindENS_14SourceLocationES2_")
//</editor-fold>
public final OMPClause /*P*/ ActOnOpenMPClause(OpenMPClauseKind Kind, 
                 SourceLocation StartLoc, 
                 SourceLocation EndLoc) {
  OMPClause /*P*/ Res = null;
  switch (Kind) {
   case OMPC_ordered:
    Res = $this().ActOnOpenMPOrderedClause(new SourceLocation(StartLoc), new SourceLocation(EndLoc));
    break;
   case OMPC_nowait:
    Res = $this().ActOnOpenMPNowaitClause(new SourceLocation(StartLoc), new SourceLocation(EndLoc));
    break;
   case OMPC_untied:
    Res = $this().ActOnOpenMPUntiedClause(new SourceLocation(StartLoc), new SourceLocation(EndLoc));
    break;
   case OMPC_mergeable:
    Res = $this().ActOnOpenMPMergeableClause(new SourceLocation(StartLoc), new SourceLocation(EndLoc));
    break;
   case OMPC_read:
    Res = $this().ActOnOpenMPReadClause(new SourceLocation(StartLoc), new SourceLocation(EndLoc));
    break;
   case OMPC_write:
    Res = $this().ActOnOpenMPWriteClause(new SourceLocation(StartLoc), new SourceLocation(EndLoc));
    break;
   case OMPC_update:
    Res = $this().ActOnOpenMPUpdateClause(new SourceLocation(StartLoc), new SourceLocation(EndLoc));
    break;
   case OMPC_capture:
    Res = $this().ActOnOpenMPCaptureClause(new SourceLocation(StartLoc), new SourceLocation(EndLoc));
    break;
   case OMPC_seq_cst:
    Res = $this().ActOnOpenMPSeqCstClause(new SourceLocation(StartLoc), new SourceLocation(EndLoc));
    break;
   case OMPC_threads:
    Res = $this().ActOnOpenMPThreadsClause(new SourceLocation(StartLoc), new SourceLocation(EndLoc));
    break;
   case OMPC_simd:
    Res = $this().ActOnOpenMPSIMDClause(new SourceLocation(StartLoc), new SourceLocation(EndLoc));
    break;
   case OMPC_nogroup:
    Res = $this().ActOnOpenMPNogroupClause(new SourceLocation(StartLoc), new SourceLocation(EndLoc));
    break;
   case OMPC_if:
   case OMPC_final:
   case OMPC_num_threads:
   case OMPC_safelen:
   case OMPC_simdlen:
   case OMPC_collapse:
   case OMPC_schedule:
   case OMPC_private:
   case OMPC_firstprivate:
   case OMPC_lastprivate:
   case OMPC_shared:
   case OMPC_reduction:
   case OMPC_linear:
   case OMPC_aligned:
   case OMPC_copyin:
   case OMPC_copyprivate:
   case OMPC_default:
   case OMPC_proc_bind:
   case OMPC_threadprivate:
   case OMPC_flush:
   case OMPC_depend:
   case OMPC_device:
   case OMPC_map:
   case OMPC_num_teams:
   case OMPC_thread_limit:
   case OMPC_priority:
   case OMPC_grainsize:
   case OMPC_num_tasks:
   case OMPC_hint:
   case OMPC_dist_schedule:
   case OMPC_defaultmap:
   case OMPC_unknown:
   case OMPC_uniform:
   case OMPC_to:
   case OMPC_from:
   case OMPC_use_device_ptr:
   case OMPC_is_device_ptr:
    throw new llvm_unreachable("Clause is not allowed.");
  }
  return Res;
}

/// \brief Called on well-formed 'nowait' clause.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnOpenMPNowaitClause">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 7928,
 FQN="clang::Sema::ActOnOpenMPNowaitClause", NM="_ZN5clang4Sema23ActOnOpenMPNowaitClauseENS_14SourceLocationES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4Sema23ActOnOpenMPNowaitClauseENS_14SourceLocationES1_")
//</editor-fold>
public final OMPClause /*P*/ ActOnOpenMPNowaitClause(SourceLocation StartLoc, 
                       SourceLocation EndLoc) {
  ((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).setNowaitRegion();
  return /*FIXME:NEW_EXPR*//*new (Context)*/ new OMPNowaitClause(new SourceLocation(StartLoc), new SourceLocation(EndLoc));
}

/// \brief Called on well-formed 'untied' clause.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnOpenMPUntiedClause">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 7934,
 FQN="clang::Sema::ActOnOpenMPUntiedClause", NM="_ZN5clang4Sema23ActOnOpenMPUntiedClauseENS_14SourceLocationES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4Sema23ActOnOpenMPUntiedClauseENS_14SourceLocationES1_")
//</editor-fold>
public final OMPClause /*P*/ ActOnOpenMPUntiedClause(SourceLocation StartLoc, 
                       SourceLocation EndLoc) {
  return /*FIXME:NEW_EXPR*//*new (Context)*/ new OMPUntiedClause(new SourceLocation(StartLoc), new SourceLocation(EndLoc));
}

/// \brief Called on well-formed 'mergeable' clause.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnOpenMPMergeableClause">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 7939,
 FQN="clang::Sema::ActOnOpenMPMergeableClause", NM="_ZN5clang4Sema26ActOnOpenMPMergeableClauseENS_14SourceLocationES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4Sema26ActOnOpenMPMergeableClauseENS_14SourceLocationES1_")
//</editor-fold>
public final OMPClause /*P*/ ActOnOpenMPMergeableClause(SourceLocation StartLoc, 
                          SourceLocation EndLoc) {
  return /*FIXME:NEW_EXPR*//*new (Context)*/ new OMPMergeableClause(new SourceLocation(StartLoc), new SourceLocation(EndLoc));
}

/// \brief Called on well-formed 'read' clause.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnOpenMPReadClause">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 7944,
 FQN="clang::Sema::ActOnOpenMPReadClause", NM="_ZN5clang4Sema21ActOnOpenMPReadClauseENS_14SourceLocationES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4Sema21ActOnOpenMPReadClauseENS_14SourceLocationES1_")
//</editor-fold>
public final OMPClause /*P*/ ActOnOpenMPReadClause(SourceLocation StartLoc, 
                     SourceLocation EndLoc) {
  return /*FIXME:NEW_EXPR*//*new (Context)*/ new OMPReadClause(new SourceLocation(StartLoc), new SourceLocation(EndLoc));
}

/// \brief Called on well-formed 'write' clause.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnOpenMPWriteClause">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 7949,
 FQN="clang::Sema::ActOnOpenMPWriteClause", NM="_ZN5clang4Sema22ActOnOpenMPWriteClauseENS_14SourceLocationES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4Sema22ActOnOpenMPWriteClauseENS_14SourceLocationES1_")
//</editor-fold>
public final OMPClause /*P*/ ActOnOpenMPWriteClause(SourceLocation StartLoc, 
                      SourceLocation EndLoc) {
  return /*FIXME:NEW_EXPR*//*new (Context)*/ new OMPWriteClause(new SourceLocation(StartLoc), new SourceLocation(EndLoc));
}

/// \brief Called on well-formed 'update' clause.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnOpenMPUpdateClause">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 7954,
 FQN="clang::Sema::ActOnOpenMPUpdateClause", NM="_ZN5clang4Sema23ActOnOpenMPUpdateClauseENS_14SourceLocationES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4Sema23ActOnOpenMPUpdateClauseENS_14SourceLocationES1_")
//</editor-fold>
public final OMPClause /*P*/ ActOnOpenMPUpdateClause(SourceLocation StartLoc, 
                       SourceLocation EndLoc) {
  return /*FIXME:NEW_EXPR*//*new (Context)*/ new OMPUpdateClause(new SourceLocation(StartLoc), new SourceLocation(EndLoc));
}

/// \brief Called on well-formed 'capture' clause.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnOpenMPCaptureClause">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 7959,
 FQN="clang::Sema::ActOnOpenMPCaptureClause", NM="_ZN5clang4Sema24ActOnOpenMPCaptureClauseENS_14SourceLocationES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4Sema24ActOnOpenMPCaptureClauseENS_14SourceLocationES1_")
//</editor-fold>
public final OMPClause /*P*/ ActOnOpenMPCaptureClause(SourceLocation StartLoc, 
                        SourceLocation EndLoc) {
  return /*FIXME:NEW_EXPR*//*new (Context)*/ new OMPCaptureClause(new SourceLocation(StartLoc), new SourceLocation(EndLoc));
}

/// \brief Called on well-formed 'seq_cst' clause.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnOpenMPSeqCstClause">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 7964,
 FQN="clang::Sema::ActOnOpenMPSeqCstClause", NM="_ZN5clang4Sema23ActOnOpenMPSeqCstClauseENS_14SourceLocationES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4Sema23ActOnOpenMPSeqCstClauseENS_14SourceLocationES1_")
//</editor-fold>
public final OMPClause /*P*/ ActOnOpenMPSeqCstClause(SourceLocation StartLoc, 
                       SourceLocation EndLoc) {
  return /*FIXME:NEW_EXPR*//*new (Context)*/ new OMPSeqCstClause(new SourceLocation(StartLoc), new SourceLocation(EndLoc));
}

/// \brief Called on well-formed 'threads' clause.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnOpenMPThreadsClause">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 7969,
 FQN="clang::Sema::ActOnOpenMPThreadsClause", NM="_ZN5clang4Sema24ActOnOpenMPThreadsClauseENS_14SourceLocationES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4Sema24ActOnOpenMPThreadsClauseENS_14SourceLocationES1_")
//</editor-fold>
public final OMPClause /*P*/ ActOnOpenMPThreadsClause(SourceLocation StartLoc, 
                        SourceLocation EndLoc) {
  return /*FIXME:NEW_EXPR*//*new (Context)*/ new OMPThreadsClause(new SourceLocation(StartLoc), new SourceLocation(EndLoc));
}

/// \brief Called on well-formed 'simd' clause.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnOpenMPSIMDClause">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 7974,
 FQN="clang::Sema::ActOnOpenMPSIMDClause", NM="_ZN5clang4Sema21ActOnOpenMPSIMDClauseENS_14SourceLocationES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4Sema21ActOnOpenMPSIMDClauseENS_14SourceLocationES1_")
//</editor-fold>
public final OMPClause /*P*/ ActOnOpenMPSIMDClause(SourceLocation StartLoc, 
                     SourceLocation EndLoc) {
  return /*FIXME:NEW_EXPR*//*new (Context)*/ new OMPSIMDClause(new SourceLocation(StartLoc), new SourceLocation(EndLoc));
}

/// \brief Called on well-formed 'nogroup' clause.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnOpenMPNogroupClause">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 7979,
 FQN="clang::Sema::ActOnOpenMPNogroupClause", NM="_ZN5clang4Sema24ActOnOpenMPNogroupClauseENS_14SourceLocationES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4Sema24ActOnOpenMPNogroupClauseENS_14SourceLocationES1_")
//</editor-fold>
public final OMPClause /*P*/ ActOnOpenMPNogroupClause(SourceLocation StartLoc, 
                        SourceLocation EndLoc) {
  return /*FIXME:NEW_EXPR*//*new (Context)*/ new OMPNogroupClause(new SourceLocation(StartLoc), new SourceLocation(EndLoc));
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnOpenMPVarListClause">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 7984,
 FQN="clang::Sema::ActOnOpenMPVarListClause", NM="_ZN5clang4Sema24ActOnOpenMPVarListClauseENS_16OpenMPClauseKindEN4llvm8ArrayRefIPNS_4ExprEEES5_NS_14SourceLocationES7_S7_S7_RNS_12CXXScopeSpecERKNS_19DeclarationNameInfoENS_22OpenMPDependClauseKindENS_22OpenMPLinearClauseKindENS_19OpenMPMapClauseKindESF_bS7_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4Sema24ActOnOpenMPVarListClauseENS_16OpenMPClauseKindEN4llvm8ArrayRefIPNS_4ExprEEES5_NS_14SourceLocationES7_S7_S7_RNS_12CXXScopeSpecERKNS_19DeclarationNameInfoENS_22OpenMPDependClauseKindENS_22OpenMPLinearClauseKindENS_19OpenMPMapClauseKindESF_bS7_")
//</editor-fold>
public final OMPClause /*P*/ ActOnOpenMPVarListClause(OpenMPClauseKind Kind, ArrayRef<Expr /*P*/ > VarList, Expr /*P*/ TailExpr, 
                        SourceLocation StartLoc, SourceLocation LParenLoc, SourceLocation ColonLoc, 
                        SourceLocation EndLoc, final CXXScopeSpec /*&*/ ReductionIdScopeSpec, 
                        final /*const*/ DeclarationNameInfo /*&*/ ReductionId, OpenMPDependClauseKind DepKind, 
                        OpenMPLinearClauseKind LinKind, OpenMPMapClauseKind MapTypeModifier, 
                        OpenMPMapClauseKind MapType, boolean IsMapTypeImplicit, 
                        SourceLocation DepLinMapLoc) {
  OMPClause /*P*/ Res = null;
  switch (Kind) {
   case OMPC_private:
    Res = $this().ActOnOpenMPPrivateClause(new ArrayRef<Expr /*P*/ >(VarList), new SourceLocation(StartLoc), new SourceLocation(LParenLoc), new SourceLocation(EndLoc));
    break;
   case OMPC_firstprivate:
    Res = $this().ActOnOpenMPFirstprivateClause(new ArrayRef<Expr /*P*/ >(VarList), new SourceLocation(StartLoc), new SourceLocation(LParenLoc), new SourceLocation(EndLoc));
    break;
   case OMPC_lastprivate:
    Res = $this().ActOnOpenMPLastprivateClause(new ArrayRef<Expr /*P*/ >(VarList), new SourceLocation(StartLoc), new SourceLocation(LParenLoc), new SourceLocation(EndLoc));
    break;
   case OMPC_shared:
    Res = $this().ActOnOpenMPSharedClause(new ArrayRef<Expr /*P*/ >(VarList), new SourceLocation(StartLoc), new SourceLocation(LParenLoc), new SourceLocation(EndLoc));
    break;
   case OMPC_reduction:
    Res = $this().ActOnOpenMPReductionClause(new ArrayRef<Expr /*P*/ >(VarList), new SourceLocation(StartLoc), new SourceLocation(LParenLoc), new SourceLocation(ColonLoc), 
        new SourceLocation(EndLoc), ReductionIdScopeSpec, ReductionId);
    break;
   case OMPC_linear:
    Res = $this().ActOnOpenMPLinearClause(new ArrayRef<Expr /*P*/ >(VarList), TailExpr, new SourceLocation(StartLoc), new SourceLocation(LParenLoc), 
        LinKind, new SourceLocation(DepLinMapLoc), new SourceLocation(ColonLoc), new SourceLocation(EndLoc));
    break;
   case OMPC_aligned:
    Res = $this().ActOnOpenMPAlignedClause(new ArrayRef<Expr /*P*/ >(VarList), TailExpr, new SourceLocation(StartLoc), new SourceLocation(LParenLoc), 
        new SourceLocation(ColonLoc), new SourceLocation(EndLoc));
    break;
   case OMPC_copyin:
    Res = $this().ActOnOpenMPCopyinClause(new ArrayRef<Expr /*P*/ >(VarList), new SourceLocation(StartLoc), new SourceLocation(LParenLoc), new SourceLocation(EndLoc));
    break;
   case OMPC_copyprivate:
    Res = $this().ActOnOpenMPCopyprivateClause(new ArrayRef<Expr /*P*/ >(VarList), new SourceLocation(StartLoc), new SourceLocation(LParenLoc), new SourceLocation(EndLoc));
    break;
   case OMPC_flush:
    Res = $this().ActOnOpenMPFlushClause(new ArrayRef<Expr /*P*/ >(VarList), new SourceLocation(StartLoc), new SourceLocation(LParenLoc), new SourceLocation(EndLoc));
    break;
   case OMPC_depend:
    Res = $this().ActOnOpenMPDependClause(DepKind, new SourceLocation(DepLinMapLoc), new SourceLocation(ColonLoc), new ArrayRef<Expr /*P*/ >(VarList), 
        new SourceLocation(StartLoc), new SourceLocation(LParenLoc), new SourceLocation(EndLoc));
    break;
   case OMPC_map:
    Res = $this().ActOnOpenMPMapClause(MapTypeModifier, MapType, IsMapTypeImplicit, 
        new SourceLocation(DepLinMapLoc), new SourceLocation(ColonLoc), new ArrayRef<Expr /*P*/ >(VarList), new SourceLocation(StartLoc), 
        new SourceLocation(LParenLoc), new SourceLocation(EndLoc));
    break;
   case OMPC_to:
    Res = $this().ActOnOpenMPToClause(new ArrayRef<Expr /*P*/ >(VarList), new SourceLocation(StartLoc), new SourceLocation(LParenLoc), new SourceLocation(EndLoc));
    break;
   case OMPC_from:
    Res = $this().ActOnOpenMPFromClause(new ArrayRef<Expr /*P*/ >(VarList), new SourceLocation(StartLoc), new SourceLocation(LParenLoc), new SourceLocation(EndLoc));
    break;
   case OMPC_use_device_ptr:
    Res = $this().ActOnOpenMPUseDevicePtrClause(new ArrayRef<Expr /*P*/ >(VarList), new SourceLocation(StartLoc), new SourceLocation(LParenLoc), new SourceLocation(EndLoc));
    break;
   case OMPC_is_device_ptr:
    Res = $this().ActOnOpenMPIsDevicePtrClause(new ArrayRef<Expr /*P*/ >(VarList), new SourceLocation(StartLoc), new SourceLocation(LParenLoc), new SourceLocation(EndLoc));
    break;
   case OMPC_if:
   case OMPC_final:
   case OMPC_num_threads:
   case OMPC_safelen:
   case OMPC_simdlen:
   case OMPC_collapse:
   case OMPC_default:
   case OMPC_proc_bind:
   case OMPC_schedule:
   case OMPC_ordered:
   case OMPC_nowait:
   case OMPC_untied:
   case OMPC_mergeable:
   case OMPC_threadprivate:
   case OMPC_read:
   case OMPC_write:
   case OMPC_update:
   case OMPC_capture:
   case OMPC_seq_cst:
   case OMPC_device:
   case OMPC_threads:
   case OMPC_simd:
   case OMPC_num_teams:
   case OMPC_thread_limit:
   case OMPC_priority:
   case OMPC_grainsize:
   case OMPC_nogroup:
   case OMPC_num_tasks:
   case OMPC_hint:
   case OMPC_dist_schedule:
   case OMPC_defaultmap:
   case OMPC_unknown:
   case OMPC_uniform:
    throw new llvm_unreachable("Clause is not allowed.");
  }
  return Res;
}

/// \brief Called on well-formed 'private' clause.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnOpenMPPrivateClause">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 8164,
 FQN="clang::Sema::ActOnOpenMPPrivateClause", NM="_ZN5clang4Sema24ActOnOpenMPPrivateClauseEN4llvm8ArrayRefIPNS_4ExprEEENS_14SourceLocationES6_S6_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4Sema24ActOnOpenMPPrivateClauseEN4llvm8ArrayRefIPNS_4ExprEEENS_14SourceLocationES6_S6_")
//</editor-fold>
public final OMPClause /*P*/ ActOnOpenMPPrivateClause(ArrayRef<Expr /*P*/ > VarList, 
                        SourceLocation StartLoc, 
                        SourceLocation LParenLoc, 
                        SourceLocation EndLoc) {
  SmallVector<Expr /*P*/ > Vars/*J*/= new SmallVector<Expr /*P*/ >(8, (Expr /*P*/ )null);
  SmallVector<Expr /*P*/ > PrivateCopies/*J*/= new SmallVector<Expr /*P*/ >(8, (Expr /*P*/ )null);
  for (final Expr /*P*/ /*const*/ /*&*/ RefExpr : VarList) {
    assert ((RefExpr != null)) : "NULL expr in OpenMP private clause.";
    SourceLocation ELoc/*J*/= new SourceLocation();
    SourceRange ERange/*J*/= new SourceRange();
    type$ref<Expr /*P*/ > SimpleRefExpr = create_type$ref(RefExpr);
    std.pairTypeBool<ValueDecl /*P*/ > Res = getPrivateItem(/*Deref*/$this(), SimpleRefExpr, ELoc, ERange);
    if (Res.second) {
      // It will be analyzed later.
      Vars.push_back(RefExpr);
      PrivateCopies.push_back((Expr /*P*/ /*const*/)null);
    }
    ValueDecl /*P*/ D = Res.first;
    if (!(D != null)) {
      continue;
    }
    
    QualType Type = D.getType();
    VarDecl /*P*/ VD = dyn_cast_VarDecl(D);
    
    // OpenMP [2.9.3.3, Restrictions, C/C++, p.3]
    //  A variable that appears in a private clause must not have an incomplete
    //  type or a reference type.
    if ($this().RequireCompleteType(new SourceLocation(ELoc), new QualType(Type), diag.err_omp_private_incomplete_type)) {
      continue;
    }
    Type.$assignMove(Type.getNonReferenceType());
    
    // OpenMP [2.9.1.1, Data-sharing Attribute Rules for Variables Referenced
    // in a Construct]
    //  Variables with the predetermined data-sharing attributes may not be
    //  listed in data-sharing attributes clauses, except for the cases
    //  listed below. For these exceptions only, listing a predetermined
    //  variable in a data-sharing attribute clause is allowed and overrides
    //  the variable's predetermined data-sharing attributes.
    DSAStackTy.DSAVarData DVar = ((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).getTopDSA(D, false);
    if (DVar.CKind != OpenMPClauseKind.OMPC_unknown && DVar.CKind != OpenMPClauseKind.OMPC_private) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(ELoc), diag.err_omp_wrong_dsa)), getOpenMPClauseName(DVar.CKind)), 
            getOpenMPClauseName(OpenMPClauseKind.OMPC_private)));
        ReportOriginalDSA(/*Deref*/$this(), ((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)), D, new DSAStackTy.DSAVarData(DVar));
        continue;
      } finally {
        $c$.$destroy();
      }
    }
    
    // Variably modified types are not supported for tasks.
    if (!Type.$arrow().isAnyPointerType() && Type.$arrow().isVariablyModifiedType()
       && isOpenMPTaskingDirective(((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).getCurrentDirective())) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(ELoc), diag.err_omp_variably_modified_type_not_supported)), 
                    getOpenMPClauseName(OpenMPClauseKind.OMPC_private)), Type), 
            getOpenMPDirectiveName(((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).getCurrentDirective())));
        boolean IsDecl = !(VD != null)
           || VD.isThisDeclarationADefinition($this().Context) == VarDecl.DefinitionKind.DeclarationOnly;
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(D.getLocation(), 
                IsDecl ? diag.note_previous_decl : diag.note_defined_here)), 
            D));
        continue;
      } finally {
        $c$.$destroy();
      }
    }
    
    // OpenMP 4.5 [2.15.5.1, Restrictions, p.3]
    // A list item cannot appear in both a map clause and a data-sharing
    // attribute clause on the same construct
    if (((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).getCurrentDirective() == OpenMPDirectiveKind.OMPD_target) {
      if (((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).checkMappableExprComponentListsForDecl(VD, /* CurrentRegionOnly = */ true, 
          /*FuncArg*//*[&]*/ (ArrayRef<MappableComponent> $Prm0) -> {
                return true;
              })) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(ELoc), diag.err_omp_variable_in_map_and_dsa)), 
                  getOpenMPClauseName(OpenMPClauseKind.OMPC_private)), 
              getOpenMPDirectiveName(((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).getCurrentDirective())));
          ReportOriginalDSA(/*Deref*/$this(), ((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)), D, new DSAStackTy.DSAVarData(DVar));
          continue;
        } finally {
          $c$.$destroy();
        }
      }
    }
    
    // OpenMP [2.9.3.3, Restrictions, C/C++, p.1]
    //  A variable of class type (or array thereof) that appears in a private
    //  clause requires an accessible, unambiguous default constructor for the
    //  class type.
    // Generate helper private variable and initialize it with the default
    // value. The address of the original variable is replaced by the address of
    // the new private variable in CodeGen. This new variable is not added to
    // IdResolver, so the code in the OpenMP region uses original variable for
    // proper diagnostics.
    Type.$assignMove(Type.getUnqualifiedType());
    VarDecl /*P*/ VDPrivate = buildVarDecl(/*Deref*/$this(), new SourceLocation(ELoc), new QualType(Type), D.getName(), 
        D.hasAttrs() ? $AddrOf(D.getAttrs()) : (SmallVector<Attr /*P*/>/*P*/ )null);
    $this().ActOnUninitializedDecl(VDPrivate, /*TypeMayContainAuto=*/ false);
    if (VDPrivate.isInvalidDecl()) {
      continue;
    }
    DeclRefExpr /*P*/ VDPrivateRefExpr = buildDeclRefExpr(/*Deref*/$this(), VDPrivate, RefExpr.getType().getUnqualifiedType(), new SourceLocation(ELoc));
    
    DeclRefExpr /*P*/ Ref = null;
    if (!(VD != null) && !$this().CurContext.isDependentContext()) {
      Ref = buildCapture(/*Deref*/$this(), D, SimpleRefExpr.$deref(), /*WithInit=*/ false);
    }
    ((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).addDSA(D, RefExpr.IgnoreParens(), OpenMPClauseKind.OMPC_private, Ref);
    Vars.push_back(((VD != null) || $this().CurContext.isDependentContext()) ? RefExpr.IgnoreParens() : Ref);
    PrivateCopies.push_back(VDPrivateRefExpr);
  }
  if (Vars.empty()) {
    return null;
  }
  
  return OMPPrivateClause.Create($this().Context, new SourceLocation(StartLoc), new SourceLocation(LParenLoc), new SourceLocation(EndLoc), new ArrayRef<Expr /*P*/ >(Vars, true), 
      new ArrayRef<Expr /*P*/ >(PrivateCopies, true));
}

/// \brief Called on well-formed 'firstprivate' clause.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnOpenMPFirstprivateClause">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 8299,
 FQN="clang::Sema::ActOnOpenMPFirstprivateClause", NM="_ZN5clang4Sema29ActOnOpenMPFirstprivateClauseEN4llvm8ArrayRefIPNS_4ExprEEENS_14SourceLocationES6_S6_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4Sema29ActOnOpenMPFirstprivateClauseEN4llvm8ArrayRefIPNS_4ExprEEENS_14SourceLocationES6_S6_")
//</editor-fold>
public final OMPClause /*P*/ ActOnOpenMPFirstprivateClause(ArrayRef<Expr /*P*/ > VarList, 
                             SourceLocation StartLoc, 
                             SourceLocation LParenLoc, 
                             SourceLocation EndLoc) {
  SmallVector<Expr /*P*/ > Vars/*J*/= new SmallVector<Expr /*P*/ >(8, (Expr /*P*/ )null);
  SmallVector<Expr /*P*/ > PrivateCopies/*J*/= new SmallVector<Expr /*P*/ >(8, (Expr /*P*/ )null);
  SmallVector<Expr /*P*/ > Inits/*J*/= new SmallVector<Expr /*P*/ >(8, (Expr /*P*/ )null);
  SmallVector<Decl /*P*/> ExprCaptures/*J*/= new SmallVector<Decl /*P*/>(4, null);
  boolean IsImplicitClause = StartLoc.isInvalid() && LParenLoc.isInvalid() && EndLoc.isInvalid();
  SourceLocation ImplicitClauseLoc = ((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).getConstructLoc();
  
  for (final Expr /*P*/ /*const*/ /*&*/ RefExpr : VarList) {
    assert ((RefExpr != null)) : "NULL expr in OpenMP firstprivate clause.";
    SourceLocation ELoc/*J*/= new SourceLocation();
    SourceRange ERange/*J*/= new SourceRange();
    type$ref<Expr /*P*/ > SimpleRefExpr = create_type$ref(RefExpr);
    std.pairTypeBool<ValueDecl /*P*/ > Res = getPrivateItem(/*Deref*/$this(), SimpleRefExpr, ELoc, ERange);
    if (Res.second) {
      // It will be analyzed later.
      Vars.push_back(RefExpr);
      PrivateCopies.push_back((Expr /*P*/ /*const*/)null);
      Inits.push_back((Expr /*P*/ /*const*/)null);
    }
    ValueDecl /*P*/ D = Res.first;
    if (!(D != null)) {
      continue;
    }
    
    ELoc.$assign(IsImplicitClause ? ImplicitClauseLoc : ELoc);
    QualType Type = D.getType();
    VarDecl /*P*/ VD = dyn_cast_VarDecl(D);
    
    // OpenMP [2.9.3.3, Restrictions, C/C++, p.3]
    //  A variable that appears in a private clause must not have an incomplete
    //  type or a reference type.
    if ($this().RequireCompleteType(new SourceLocation(ELoc), new QualType(Type), 
        diag.err_omp_firstprivate_incomplete_type)) {
      continue;
    }
    Type.$assignMove(Type.getNonReferenceType());
    
    // OpenMP [2.9.3.4, Restrictions, C/C++, p.1]
    //  A variable of class type (or array thereof) that appears in a private
    //  clause requires an accessible, unambiguous copy constructor for the
    //  class type.
    QualType ElemType = $this().Context.getBaseElementType(new QualType(Type)).getNonReferenceType();
    
    // If an implicit firstprivate variable found it was checked already.
    DSAStackTy.DSAVarData TopDVar/*J*/= new DSAStackTy.DSAVarData();
    if (!IsImplicitClause) {
      DSAStackTy.DSAVarData DVar = ((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).getTopDSA(D, false);
      TopDVar.$assign(DVar);
      boolean IsConstant = ElemType.isConstant($this().Context);
      // OpenMP [2.4.13, Data-sharing Attribute Clauses]
      //  A list item that specifies a given variable may not appear in more
      // than one clause on the same directive, except that a variable may be
      //  specified in both firstprivate and lastprivate clauses.
      if (DVar.CKind != OpenMPClauseKind.OMPC_unknown && DVar.CKind != OpenMPClauseKind.OMPC_firstprivate
         && DVar.CKind != OpenMPClauseKind.OMPC_lastprivate && (DVar.RefExpr != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(ELoc), diag.err_omp_wrong_dsa)), 
                  getOpenMPClauseName(DVar.CKind)), 
              getOpenMPClauseName(OpenMPClauseKind.OMPC_firstprivate)));
          ReportOriginalDSA(/*Deref*/$this(), ((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)), D, new DSAStackTy.DSAVarData(DVar));
          continue;
        } finally {
          $c$.$destroy();
        }
      }
      
      // OpenMP [2.9.1.1, Data-sharing Attribute Rules for Variables Referenced
      // in a Construct]
      //  Variables with the predetermined data-sharing attributes may not be
      //  listed in data-sharing attributes clauses, except for the cases
      //  listed below. For these exceptions only, listing a predetermined
      //  variable in a data-sharing attribute clause is allowed and overrides
      //  the variable's predetermined data-sharing attributes.
      // OpenMP [2.9.1.1, Data-sharing Attribute Rules for Variables Referenced
      // in a Construct, C/C++, p.2]
      //  Variables with const-qualified type having no mutable member may be
      //  listed in a firstprivate clause, even if they are static data members.
      if (!(IsConstant || ((VD != null) && VD.isStaticDataMember())) && !(DVar.RefExpr != null)
         && DVar.CKind != OpenMPClauseKind.OMPC_unknown && DVar.CKind != OpenMPClauseKind.OMPC_shared) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(ELoc), diag.err_omp_wrong_dsa)), 
                  getOpenMPClauseName(DVar.CKind)), 
              getOpenMPClauseName(OpenMPClauseKind.OMPC_firstprivate)));
          ReportOriginalDSA(/*Deref*/$this(), ((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)), D, new DSAStackTy.DSAVarData(DVar));
          continue;
        } finally {
          $c$.$destroy();
        }
      }
      
      OpenMPDirectiveKind CurrDir = ((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).getCurrentDirective();
      // OpenMP [2.9.3.4, Restrictions, p.2]
      //  A list item that is private within a parallel region must not appear
      //  in a firstprivate clause on a worksharing construct if any of the
      //  worksharing regions arising from the worksharing construct ever bind
      //  to any of the parallel regions arising from the parallel construct.
      if (isOpenMPWorksharingDirective(CurrDir)
         && !isOpenMPParallelDirective(CurrDir)) {
        DVar.$assignMove(((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).getImplicitDSA(D, true));
        if (DVar.CKind != OpenMPClauseKind.OMPC_shared
           && (isOpenMPParallelDirective(DVar.DKind)
           || DVar.DKind == OpenMPDirectiveKind.OMPD_unknown)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(ELoc), diag.err_omp_required_access)), 
                    getOpenMPClauseName(OpenMPClauseKind.OMPC_firstprivate)), 
                getOpenMPClauseName(OpenMPClauseKind.OMPC_shared)));
            ReportOriginalDSA(/*Deref*/$this(), ((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)), D, new DSAStackTy.DSAVarData(DVar));
            continue;
          } finally {
            $c$.$destroy();
          }
        }
      }
      // OpenMP [2.9.3.4, Restrictions, p.3]
      //  A list item that appears in a reduction clause of a parallel construct
      //  must not appear in a firstprivate clause on a worksharing or task
      //  construct if any of the worksharing or task regions arising from the
      //  worksharing or task construct ever bind to any of the parallel regions
      //  arising from the parallel construct.
      // OpenMP [2.9.3.4, Restrictions, p.4]
      //  A list item that appears in a reduction clause in worksharing
      //  construct must not appear in a firstprivate clause in a task construct
      //  encountered during execution of any of the worksharing regions arising
      //  from the worksharing construct.
      if (isOpenMPTaskingDirective(CurrDir)) {
        DVar.$assignMove(((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).hasInnermostDSA(D, /*FuncArg*//*[]*/ (OpenMPClauseKind C) -> {
                      return C == OpenMPClauseKind.OMPC_reduction;
                    }, 
                /*FuncArg*//*[]*/ (OpenMPDirectiveKind K) -> {
                      return isOpenMPParallelDirective(K)
                         || isOpenMPWorksharingDirective(K);
                    }, 
                false));
        if (DVar.CKind == OpenMPClauseKind.OMPC_reduction
           && (isOpenMPParallelDirective(DVar.DKind)
           || isOpenMPWorksharingDirective(DVar.DKind))) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(ELoc), diag.err_omp_parallel_reduction_in_task_firstprivate)), 
                getOpenMPDirectiveName(DVar.DKind)));
            ReportOriginalDSA(/*Deref*/$this(), ((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)), D, new DSAStackTy.DSAVarData(DVar));
            continue;
          } finally {
            $c$.$destroy();
          }
        }
      }
      
      // OpenMP 4.5 [2.15.3.4, Restrictions, p.3]
      // A list item that is private within a teams region must not appear in a
      // firstprivate clause on a distribute construct if any of the distribute
      // regions arising from the distribute construct ever bind to any of the
      // teams regions arising from the teams construct.
      // OpenMP 4.5 [2.15.3.4, Restrictions, p.3]
      // A list item that appears in a reduction clause of a teams construct
      // must not appear in a firstprivate clause on a distribute construct if
      // any of the distribute regions arising from the distribute construct
      // ever bind to any of the teams regions arising from the teams construct.
      // OpenMP 4.5 [2.10.8, Distribute Construct, p.3]
      // A list item may appear in a firstprivate or lastprivate clause but not
      // both.
      if (CurrDir == OpenMPDirectiveKind.OMPD_distribute) {
        DVar.$assignMove(((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).hasInnermostDSA(D, /*FuncArg*//*[]*/ (OpenMPClauseKind C) -> {
                      return C == OpenMPClauseKind.OMPC_private;
                    }, 
                /*FuncArg*//*[]*/ (OpenMPDirectiveKind K) -> {
                      return isOpenMPTeamsDirective(K);
                    }, 
                false));
        if (DVar.CKind == OpenMPClauseKind.OMPC_private && isOpenMPTeamsDirective(DVar.DKind)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track($this().Diag(new SourceLocation(ELoc), diag.err_omp_firstprivate_distribute_private_teams)));
            ReportOriginalDSA(/*Deref*/$this(), ((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)), D, new DSAStackTy.DSAVarData(DVar));
            continue;
          } finally {
            $c$.$destroy();
          }
        }
        DVar.$assignMove(((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).hasInnermostDSA(D, /*FuncArg*//*[]*/ (OpenMPClauseKind C) -> {
                      return C == OpenMPClauseKind.OMPC_reduction;
                    }, 
                /*FuncArg*//*[]*/ (OpenMPDirectiveKind K) -> {
                      return isOpenMPTeamsDirective(K);
                    }, 
                false));
        if (DVar.CKind == OpenMPClauseKind.OMPC_reduction
           && isOpenMPTeamsDirective(DVar.DKind)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track($this().Diag(new SourceLocation(ELoc), diag.err_omp_firstprivate_distribute_in_teams_reduction)));
            ReportOriginalDSA(/*Deref*/$this(), ((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)), D, new DSAStackTy.DSAVarData(DVar));
            continue;
          } finally {
            $c$.$destroy();
          }
        }
        DVar.$assignMove(((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).getTopDSA(D, false));
        if (DVar.CKind == OpenMPClauseKind.OMPC_lastprivate) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track($this().Diag(new SourceLocation(ELoc), diag.err_omp_firstprivate_and_lastprivate_in_distribute)));
            ReportOriginalDSA(/*Deref*/$this(), ((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)), D, new DSAStackTy.DSAVarData(DVar));
            continue;
          } finally {
            $c$.$destroy();
          }
        }
      }
      // OpenMP 4.5 [2.15.5.1, Restrictions, p.3]
      // A list item cannot appear in both a map clause and a data-sharing
      // attribute clause on the same construct
      if (CurrDir == OpenMPDirectiveKind.OMPD_target) {
        if (((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).checkMappableExprComponentListsForDecl(VD, /* CurrentRegionOnly = */ true, 
            /*FuncArg*//*[&]*/ (ArrayRef<MappableComponent> $Prm0) -> {
                  return true;
                })) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(ELoc), diag.err_omp_variable_in_map_and_dsa)), 
                    getOpenMPClauseName(OpenMPClauseKind.OMPC_firstprivate)), 
                getOpenMPDirectiveName(((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).getCurrentDirective())));
            ReportOriginalDSA(/*Deref*/$this(), ((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)), D, new DSAStackTy.DSAVarData(DVar));
            continue;
          } finally {
            $c$.$destroy();
          }
        }
      }
    }
    
    // Variably modified types are not supported for tasks.
    if (!Type.$arrow().isAnyPointerType() && Type.$arrow().isVariablyModifiedType()
       && isOpenMPTaskingDirective(((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).getCurrentDirective())) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(ELoc), diag.err_omp_variably_modified_type_not_supported)), 
                    getOpenMPClauseName(OpenMPClauseKind.OMPC_firstprivate)), Type), 
            getOpenMPDirectiveName(((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).getCurrentDirective())));
        boolean IsDecl = !(VD != null)
           || VD.isThisDeclarationADefinition($this().Context) == VarDecl.DefinitionKind.DeclarationOnly;
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(D.getLocation(), 
                IsDecl ? diag.note_previous_decl : diag.note_defined_here)), 
            D));
        continue;
      } finally {
        $c$.$destroy();
      }
    }
    
    Type.$assignMove(Type.getUnqualifiedType());
    VarDecl /*P*/ VDPrivate = buildVarDecl(/*Deref*/$this(), new SourceLocation(ELoc), new QualType(Type), D.getName(), 
        D.hasAttrs() ? $AddrOf(D.getAttrs()) : (SmallVector<Attr /*P*/>/*P*/ )null);
    // Generate helper private variable and initialize it with the value of the
    // original variable. The address of the original variable is replaced by
    // the address of the new private variable in the CodeGen. This new variable
    // is not added to IdResolver, so the code in the OpenMP region uses
    // original variable for proper diagnostics and variable capturing.
    Expr /*P*/ VDInitRefExpr = null;
    // For arrays generate initializer for single element and replace it by the
    // original array element in CodeGen.
    if (Type.$arrow().isArrayType()) {
      InitializationSequence InitSeq = null;
      try {
        VarDecl /*P*/ VDInit = buildVarDecl(/*Deref*/$this(), RefExpr.getExprLoc(), new QualType(ElemType), D.getName());
        VDInitRefExpr = buildDeclRefExpr(/*Deref*/$this(), VDInit, new QualType(ElemType), new SourceLocation(ELoc));
        Expr /*P*/ Init = $this().DefaultLvalueConversion(VDInitRefExpr).get();
        ElemType.$assignMove(ElemType.getUnqualifiedType());
        VarDecl /*P*/ VDInitTemp = buildVarDecl(/*Deref*/$this(), RefExpr.getExprLoc(), new QualType(ElemType), 
            new StringRef(/*KEEP_STR*/".firstprivate.temp"));
        InitializedEntity Entity = InitializedEntity.InitializeVariable(VDInitTemp);
        InitializationKind Kind = InitializationKind.CreateCopy(new SourceLocation(ELoc), new SourceLocation(ELoc));
        
        InitSeq/*J*/= new InitializationSequence(/*Deref*/$this(), Entity, Kind, new MutableArrayRef<Expr /*P*/ >(Init, true));
        ActionResultTTrue<Expr /*P*/ > Result = InitSeq.Perform(/*Deref*/$this(), Entity, Kind, new MutableArrayRef<Expr /*P*/ >(Init, true));
        if (Result.isInvalid()) {
          VDPrivate.setInvalidDecl();
        } else {
          VDPrivate.setInit(Result.getAs(Expr.class));
        }
        // Remove temp variable declaration.
        $this().Context.Deallocate(VDInitTemp);
      } finally {
        if (InitSeq != null) { InitSeq.$destroy(); }
      }
    } else {
      VarDecl /*P*/ VDInit = buildVarDecl(/*Deref*/$this(), RefExpr.getExprLoc(), new QualType(Type), 
          new StringRef(/*KEEP_STR*/".firstprivate.temp"));
      VDInitRefExpr = buildDeclRefExpr(/*Deref*/$this(), VDInit, RefExpr.getType(), 
          RefExpr.getExprLoc());
      $this().AddInitializerToDecl(VDPrivate, 
          $this().DefaultLvalueConversion(VDInitRefExpr).get(), 
          /*DirectInit=*/ false, /*TypeMayContainAuto=*/ false);
    }
    if (VDPrivate.isInvalidDecl()) {
      if (IsImplicitClause) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag(RefExpr.getExprLoc(), 
              diag.note_omp_task_predetermined_firstprivate_here)));
        } finally {
          $c$.$destroy();
        }
      }
      continue;
    }
    $this().CurContext.addDecl(VDPrivate);
    DeclRefExpr /*P*/ VDPrivateRefExpr = buildDeclRefExpr(/*Deref*/$this(), VDPrivate, RefExpr.getType().getUnqualifiedType(), 
        RefExpr.getExprLoc());
    DeclRefExpr /*P*/ Ref = null;
    if (!(VD != null) && !$this().CurContext.isDependentContext()) {
      if (TopDVar.CKind == OpenMPClauseKind.OMPC_lastprivate) {
        Ref = TopDVar.PrivateCopy;
      } else {
        Ref = buildCapture(/*Deref*/$this(), D, SimpleRefExpr.$deref(), /*WithInit=*/ true);
        if (!($this().IsOpenMPCapturedDecl(D) != null)) {
          ExprCaptures.push_back(Ref.getDecl());
        }
      }
    }
    ((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).addDSA(D, RefExpr.IgnoreParens(), OpenMPClauseKind.OMPC_firstprivate, Ref);
    Vars.push_back(((VD != null) || $this().CurContext.isDependentContext()) ? RefExpr.IgnoreParens() : Ref);
    PrivateCopies.push_back(VDPrivateRefExpr);
    Inits.push_back(VDInitRefExpr);
  }
  if (Vars.empty()) {
    return null;
  }
  
  return OMPFirstprivateClause.Create($this().Context, new SourceLocation(StartLoc), new SourceLocation(LParenLoc), new SourceLocation(EndLoc), 
      new ArrayRef<Expr /*P*/ >(Vars, true), new ArrayRef<Expr /*P*/ >(PrivateCopies, true), new ArrayRef<Expr /*P*/ >(Inits, true), 
      buildPreInits($this().Context, ExprCaptures));
}

/// \brief Called on well-formed 'lastprivate' clause.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnOpenMPLastprivateClause">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 8585,
 FQN="clang::Sema::ActOnOpenMPLastprivateClause", NM="_ZN5clang4Sema28ActOnOpenMPLastprivateClauseEN4llvm8ArrayRefIPNS_4ExprEEENS_14SourceLocationES6_S6_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4Sema28ActOnOpenMPLastprivateClauseEN4llvm8ArrayRefIPNS_4ExprEEENS_14SourceLocationES6_S6_")
//</editor-fold>
public final OMPClause /*P*/ ActOnOpenMPLastprivateClause(ArrayRef<Expr /*P*/ > VarList, 
                            SourceLocation StartLoc, 
                            SourceLocation LParenLoc, 
                            SourceLocation EndLoc) {
  SmallVector<Expr /*P*/ > Vars/*J*/= new SmallVector<Expr /*P*/ >(8, (Expr /*P*/ )null);
  SmallVector<Expr /*P*/ > SrcExprs/*J*/= new SmallVector<Expr /*P*/ >(8, (Expr /*P*/ )null);
  SmallVector<Expr /*P*/ > DstExprs/*J*/= new SmallVector<Expr /*P*/ >(8, (Expr /*P*/ )null);
  SmallVector<Expr /*P*/ > AssignmentOps/*J*/= new SmallVector<Expr /*P*/ >(8, (Expr /*P*/ )null);
  SmallVector<Decl /*P*/> ExprCaptures/*J*/= new SmallVector<Decl /*P*/>(4, null);
  SmallVector<Expr /*P*/ > ExprPostUpdates/*J*/= new SmallVector<Expr /*P*/ >(4, (Expr /*P*/ )null);
  for (final Expr /*P*/ /*const*/ /*&*/ RefExpr : VarList) {
    assert ((RefExpr != null)) : "NULL expr in OpenMP lastprivate clause.";
    SourceLocation ELoc/*J*/= new SourceLocation();
    SourceRange ERange/*J*/= new SourceRange();
    type$ref<Expr /*P*/ > SimpleRefExpr = create_type$ref(RefExpr);
    std.pairTypeBool<ValueDecl /*P*/ > Res = getPrivateItem(/*Deref*/$this(), SimpleRefExpr, ELoc, ERange);
    if (Res.second) {
      // It will be analyzed later.
      Vars.push_back(RefExpr);
      SrcExprs.push_back((Expr /*P*/ /*const*/)null);
      DstExprs.push_back((Expr /*P*/ /*const*/)null);
      AssignmentOps.push_back((Expr /*P*/ /*const*/)null);
    }
    ValueDecl /*P*/ D = Res.first;
    if (!(D != null)) {
      continue;
    }
    
    QualType Type = D.getType();
    VarDecl /*P*/ VD = dyn_cast_VarDecl(D);
    
    // OpenMP [2.14.3.5, Restrictions, C/C++, p.2]
    //  A variable that appears in a lastprivate clause must not have an
    //  incomplete type or a reference type.
    if ($this().RequireCompleteType(new SourceLocation(ELoc), new QualType(Type), 
        diag.err_omp_lastprivate_incomplete_type)) {
      continue;
    }
    Type.$assignMove(Type.getNonReferenceType());
    
    // OpenMP [2.14.1.1, Data-sharing Attribute Rules for Variables Referenced
    // in a Construct]
    //  Variables with the predetermined data-sharing attributes may not be
    //  listed in data-sharing attributes clauses, except for the cases
    //  listed below.
    DSAStackTy.DSAVarData DVar = ((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).getTopDSA(D, false);
    if (DVar.CKind != OpenMPClauseKind.OMPC_unknown && DVar.CKind != OpenMPClauseKind.OMPC_lastprivate
       && DVar.CKind != OpenMPClauseKind.OMPC_firstprivate
       && (DVar.CKind != OpenMPClauseKind.OMPC_private || DVar.RefExpr != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(ELoc), diag.err_omp_wrong_dsa)), 
                getOpenMPClauseName(DVar.CKind)), 
            getOpenMPClauseName(OpenMPClauseKind.OMPC_lastprivate)));
        ReportOriginalDSA(/*Deref*/$this(), ((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)), D, new DSAStackTy.DSAVarData(DVar));
        continue;
      } finally {
        $c$.$destroy();
      }
    }
    
    OpenMPDirectiveKind CurrDir = ((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).getCurrentDirective();
    // OpenMP [2.14.3.5, Restrictions, p.2]
    // A list item that is private within a parallel region, or that appears in
    // the reduction clause of a parallel construct, must not appear in a
    // lastprivate clause on a worksharing construct if any of the corresponding
    // worksharing regions ever binds to any of the corresponding parallel
    // regions.
    DSAStackTy.DSAVarData TopDVar = new DSAStackTy.DSAVarData(DVar);
    if (isOpenMPWorksharingDirective(CurrDir)
       && !isOpenMPParallelDirective(CurrDir)) {
      DVar.$assignMove(((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).getImplicitDSA(D, true));
      if (DVar.CKind != OpenMPClauseKind.OMPC_shared) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(ELoc), diag.err_omp_required_access)), 
                  getOpenMPClauseName(OpenMPClauseKind.OMPC_lastprivate)), 
              getOpenMPClauseName(OpenMPClauseKind.OMPC_shared)));
          ReportOriginalDSA(/*Deref*/$this(), ((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)), D, new DSAStackTy.DSAVarData(DVar));
          continue;
        } finally {
          $c$.$destroy();
        }
      }
    }
    
    // OpenMP 4.5 [2.10.8, Distribute Construct, p.3]
    // A list item may appear in a firstprivate or lastprivate clause but not
    // both.
    if (CurrDir == OpenMPDirectiveKind.OMPD_distribute) {
      DSAStackTy.DSAVarData DVar$1 = ((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).getTopDSA(D, false);
      if (DVar$1.CKind == OpenMPClauseKind.OMPC_firstprivate) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag(new SourceLocation(ELoc), diag.err_omp_firstprivate_and_lastprivate_in_distribute)));
          ReportOriginalDSA(/*Deref*/$this(), ((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)), D, new DSAStackTy.DSAVarData(DVar$1));
          continue;
        } finally {
          $c$.$destroy();
        }
      }
    }
    
    // OpenMP [2.14.3.5, Restrictions, C++, p.1,2]
    //  A variable of class type (or array thereof) that appears in a
    //  lastprivate clause requires an accessible, unambiguous default
    //  constructor for the class type, unless the list item is also specified
    //  in a firstprivate clause.
    //  A variable of class type (or array thereof) that appears in a
    //  lastprivate clause requires an accessible, unambiguous copy assignment
    //  operator for the class type.
    Type.$assignMove($this().Context.getBaseElementType(new QualType(Type)).getNonReferenceType());
    VarDecl /*P*/ SrcVD = buildVarDecl(/*Deref*/$this(), ERange.getBegin(), 
        Type.getUnqualifiedType(), new StringRef(/*KEEP_STR*/".lastprivate.src"), 
        D.hasAttrs() ? $AddrOf(D.getAttrs()) : (SmallVector<Attr /*P*/>/*P*/ )null);
    DeclRefExpr /*P*/ PseudoSrcExpr = buildDeclRefExpr(/*Deref*/$this(), SrcVD, Type.getUnqualifiedType(), new SourceLocation(ELoc));
    VarDecl /*P*/ DstVD = buildVarDecl(/*Deref*/$this(), ERange.getBegin(), new QualType(Type), new StringRef(/*KEEP_STR*/".lastprivate.dst"), 
        D.hasAttrs() ? $AddrOf(D.getAttrs()) : (SmallVector<Attr /*P*/>/*P*/ )null);
    DeclRefExpr /*P*/ PseudoDstExpr = buildDeclRefExpr(/*Deref*/$this(), DstVD, new QualType(Type), new SourceLocation(ELoc));
    // For arrays generate assignment operation for single element and replace
    // it by the original array element in CodeGen.
    ActionResultTTrue<Expr /*P*/ > AssignmentOp = $this().BuildBinOp(/*S=*/ (Scope /*P*/ )null, new SourceLocation(ELoc), BinaryOperatorKind.BO_Assign, 
        PseudoDstExpr, PseudoSrcExpr);
    if (AssignmentOp.isInvalid()) {
      continue;
    }
    AssignmentOp.$assignMove($this().ActOnFinishFullExpr(AssignmentOp.get(), new SourceLocation(ELoc), 
            /*DiscardedValue=*/ true));
    if (AssignmentOp.isInvalid()) {
      continue;
    }
    
    DeclRefExpr /*P*/ Ref = null;
    if (!(VD != null) && !$this().CurContext.isDependentContext()) {
      if (TopDVar.CKind == OpenMPClauseKind.OMPC_firstprivate) {
        Ref = TopDVar.PrivateCopy;
      } else {
        Ref = buildCapture(/*Deref*/$this(), D, SimpleRefExpr.$deref(), /*WithInit=*/ false);
        if (!($this().IsOpenMPCapturedDecl(D) != null)) {
          ExprCaptures.push_back(Ref.getDecl());
        }
      }
      if (TopDVar.CKind == OpenMPClauseKind.OMPC_firstprivate
         || (!($this().IsOpenMPCapturedDecl(D) != null)
         && Ref.getDecl().hasAttr(OMPCaptureNoInitAttr.class))) {
        ActionResultTTrue<Expr /*P*/ > RefRes = $this().DefaultLvalueConversion(Ref);
        if (!RefRes.isUsable()) {
          continue;
        }
        ActionResultTTrue<Expr /*P*/ > PostUpdateRes = $this().BuildBinOp(((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).getCurScope(), new SourceLocation(ELoc), BinaryOperatorKind.BO_Assign, SimpleRefExpr.$deref(), 
            RefRes.get());
        if (!PostUpdateRes.isUsable()) {
          continue;
        }
        ExprPostUpdates.push_back($this().IgnoredValueConversions(PostUpdateRes.get()).get());
      }
    }
    ((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).addDSA(D, RefExpr.IgnoreParens(), OpenMPClauseKind.OMPC_lastprivate, Ref);
    Vars.push_back(((VD != null) || $this().CurContext.isDependentContext()) ? RefExpr.IgnoreParens() : Ref);
    SrcExprs.push_back(PseudoSrcExpr);
    DstExprs.push_back(PseudoDstExpr);
    AssignmentOps.push_back(AssignmentOp.get());
  }
  if (Vars.empty()) {
    return null;
  }
  
  return OMPLastprivateClause.Create($this().Context, new SourceLocation(StartLoc), new SourceLocation(LParenLoc), new SourceLocation(EndLoc), 
      new ArrayRef<Expr /*P*/ >(Vars, true), new ArrayRef<Expr /*P*/ >(SrcExprs, true), new ArrayRef<Expr /*P*/ >(DstExprs, true), new ArrayRef<Expr /*P*/ >(AssignmentOps, true), 
      buildPreInits($this().Context, ExprCaptures), 
      buildPostUpdate(/*Deref*/$this(), new ArrayRef<Expr /*P*/ >(ExprPostUpdates, true)));
}

/// \brief Called on well-formed 'shared' clause.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnOpenMPSharedClause">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 8742,
 FQN="clang::Sema::ActOnOpenMPSharedClause", NM="_ZN5clang4Sema23ActOnOpenMPSharedClauseEN4llvm8ArrayRefIPNS_4ExprEEENS_14SourceLocationES6_S6_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4Sema23ActOnOpenMPSharedClauseEN4llvm8ArrayRefIPNS_4ExprEEENS_14SourceLocationES6_S6_")
//</editor-fold>
public final OMPClause /*P*/ ActOnOpenMPSharedClause(ArrayRef<Expr /*P*/ > VarList, 
                       SourceLocation StartLoc, 
                       SourceLocation LParenLoc, 
                       SourceLocation EndLoc) {
  SmallVector<Expr /*P*/ > Vars/*J*/= new SmallVector<Expr /*P*/ >(8, (Expr /*P*/ )null);
  for (final Expr /*P*/ /*const*/ /*&*/ RefExpr : VarList) {
    assert ((RefExpr != null)) : "NULL expr in OpenMP lastprivate clause.";
    SourceLocation ELoc/*J*/= new SourceLocation();
    SourceRange ERange/*J*/= new SourceRange();
    type$ref<Expr /*P*/ > SimpleRefExpr = create_type$ref(RefExpr);
    std.pairTypeBool<ValueDecl /*P*/ > Res = getPrivateItem(/*Deref*/$this(), SimpleRefExpr, ELoc, ERange);
    if (Res.second) {
      // It will be analyzed later.
      Vars.push_back(RefExpr);
    }
    ValueDecl /*P*/ D = Res.first;
    if (!(D != null)) {
      continue;
    }
    
    VarDecl /*P*/ VD = dyn_cast_VarDecl(D);
    // OpenMP [2.9.1.1, Data-sharing Attribute Rules for Variables Referenced
    // in a Construct]
    //  Variables with the predetermined data-sharing attributes may not be
    //  listed in data-sharing attributes clauses, except for the cases
    //  listed below. For these exceptions only, listing a predetermined
    //  variable in a data-sharing attribute clause is allowed and overrides
    //  the variable's predetermined data-sharing attributes.
    DSAStackTy.DSAVarData DVar = ((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).getTopDSA(D, false);
    if (DVar.CKind != OpenMPClauseKind.OMPC_unknown && DVar.CKind != OpenMPClauseKind.OMPC_shared
       && (DVar.RefExpr != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(ELoc), diag.err_omp_wrong_dsa)), getOpenMPClauseName(DVar.CKind)), 
            getOpenMPClauseName(OpenMPClauseKind.OMPC_shared)));
        ReportOriginalDSA(/*Deref*/$this(), ((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)), D, new DSAStackTy.DSAVarData(DVar));
        continue;
      } finally {
        $c$.$destroy();
      }
    }
    
    DeclRefExpr /*P*/ Ref = null;
    if (!(VD != null) && ($this().IsOpenMPCapturedDecl(D) != null) && !$this().CurContext.isDependentContext()) {
      Ref = buildCapture(/*Deref*/$this(), D, SimpleRefExpr.$deref(), /*WithInit=*/ true);
    }
    ((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).addDSA(D, RefExpr.IgnoreParens(), OpenMPClauseKind.OMPC_shared, Ref);
    Vars.push_back(((VD != null) || !(Ref != null) || $this().CurContext.isDependentContext()) ? RefExpr.IgnoreParens() : Ref);
  }
  if (Vars.empty()) {
    return null;
  }
  
  return OMPSharedClause.Create($this().Context, new SourceLocation(StartLoc), new SourceLocation(LParenLoc), new SourceLocation(EndLoc), new ArrayRef<Expr /*P*/ >(Vars, true));
}

/// \brief Called on well-formed 'reduction' clause.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnOpenMPReductionClause">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 8951,
 FQN="clang::Sema::ActOnOpenMPReductionClause", NM="_ZN5clang4Sema26ActOnOpenMPReductionClauseEN4llvm8ArrayRefIPNS_4ExprEEENS_14SourceLocationES6_S6_S6_RNS_12CXXScopeSpecERKNS_19DeclarationNameInfoES5_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4Sema26ActOnOpenMPReductionClauseEN4llvm8ArrayRefIPNS_4ExprEEENS_14SourceLocationES6_S6_S6_RNS_12CXXScopeSpecERKNS_19DeclarationNameInfoES5_")
//</editor-fold>
public final OMPClause /*P*/ ActOnOpenMPReductionClause(ArrayRef<Expr /*P*/ > VarList, SourceLocation StartLoc, SourceLocation LParenLoc, 
                          SourceLocation ColonLoc, SourceLocation EndLoc, 
                          final CXXScopeSpec /*&*/ ReductionIdScopeSpec, final /*const*/ DeclarationNameInfo /*&*/ ReductionId) {
  return ActOnOpenMPReductionClause(VarList, StartLoc, LParenLoc, 
                          ColonLoc, EndLoc, 
                          ReductionIdScopeSpec, ReductionId, 
                          new ArrayRef<Expr /*P*/ >(llvm.None, true));
}
public final OMPClause /*P*/ ActOnOpenMPReductionClause(ArrayRef<Expr /*P*/ > VarList, SourceLocation StartLoc, SourceLocation LParenLoc, 
                          SourceLocation ColonLoc, SourceLocation EndLoc, 
                          final CXXScopeSpec /*&*/ ReductionIdScopeSpec, final /*const*/ DeclarationNameInfo /*&*/ ReductionId, 
                          ArrayRef<Expr /*P*/ > UnresolvedReductions/*= llvm::None*/) {
  DeclarationName DN = ReductionId.getName();
  OverloadedOperatorKind OOK = DN.getCXXOverloadedOperator();
  BinaryOperatorKind BOK = BinaryOperatorKind.BO_Comma;
  
  // OpenMP [2.14.3.6, reduction clause]
  // C
  // reduction-identifier is either an identifier or one of the following
  // operators: +, -, *,  &, |, ^, && and ||
  // C++
  // reduction-identifier is either an id-expression or one of the following
  // operators: +, -, *, &, |, ^, && and ||
  // FIXME: Only 'min' and 'max' identifiers are supported for now.
  switch (OOK) {
   case OO_Plus:
   case OO_Minus:
    BOK = BinaryOperatorKind.BO_Add;
    break;
   case OO_Star:
    BOK = BinaryOperatorKind.BO_Mul;
    break;
   case OO_Amp:
    BOK = BinaryOperatorKind.BO_And;
    break;
   case OO_Pipe:
    BOK = BinaryOperatorKind.BO_Or;
    break;
   case OO_Caret:
    BOK = BinaryOperatorKind.BO_Xor;
    break;
   case OO_AmpAmp:
    BOK = BinaryOperatorKind.BO_LAnd;
    break;
   case OO_PipePipe:
    BOK = BinaryOperatorKind.BO_LOr;
    break;
   case OO_New:
   case OO_Delete:
   case OO_Array_New:
   case OO_Array_Delete:
   case OO_Slash:
   case OO_Percent:
   case OO_Tilde:
   case OO_Exclaim:
   case OO_Equal:
   case OO_Less:
   case OO_Greater:
   case OO_LessEqual:
   case OO_GreaterEqual:
   case OO_PlusEqual:
   case OO_MinusEqual:
   case OO_StarEqual:
   case OO_SlashEqual:
   case OO_PercentEqual:
   case OO_CaretEqual:
   case OO_AmpEqual:
   case OO_PipeEqual:
   case OO_LessLess:
   case OO_GreaterGreater:
   case OO_LessLessEqual:
   case OO_GreaterGreaterEqual:
   case OO_EqualEqual:
   case OO_ExclaimEqual:
   case OO_PlusPlus:
   case OO_MinusMinus:
   case OO_Comma:
   case OO_ArrowStar:
   case OO_Arrow:
   case OO_Call:
   case OO_Subscript:
   case OO_Conditional:
   case OO_Coawait:
   case NUM_OVERLOADED_OPERATORS:
    throw new llvm_unreachable("Unexpected reduction identifier");
   case OO_None:
    {
      IdentifierInfo /*P*/ II = DN.getAsIdentifierInfo();
      if ((II != null)) {
        if (II.isStr(/*KEEP_STR*/"max")) {
          BOK = BinaryOperatorKind.BO_GT;
        } else if (II.isStr(/*KEEP_STR*/"min")) {
          BOK = BinaryOperatorKind.BO_LT;
        }
      }
    }
    break;
  }
  SourceRange ReductionIdRange/*J*/= new SourceRange();
  if (ReductionIdScopeSpec.isValid()) {
    ReductionIdRange.setBegin(ReductionIdScopeSpec.getBeginLoc());
  }
  ReductionIdRange.setEnd(ReductionId.getEndLoc());
  
  SmallVector<Expr /*P*/ > Vars/*J*/= new SmallVector<Expr /*P*/ >(8, (Expr /*P*/ )null);
  SmallVector<Expr /*P*/ > Privates/*J*/= new SmallVector<Expr /*P*/ >(8, (Expr /*P*/ )null);
  SmallVector<Expr /*P*/ > LHSs/*J*/= new SmallVector<Expr /*P*/ >(8, (Expr /*P*/ )null);
  SmallVector<Expr /*P*/ > RHSs/*J*/= new SmallVector<Expr /*P*/ >(8, (Expr /*P*/ )null);
  SmallVector<Expr /*P*/ > ReductionOps/*J*/= new SmallVector<Expr /*P*/ >(8, (Expr /*P*/ )null);
  SmallVector<Decl /*P*/> ExprCaptures/*J*/= new SmallVector<Decl /*P*/>(4, null);
  SmallVector<Expr /*P*/ > ExprPostUpdates/*J*/= new SmallVector<Expr /*P*/ >(4, (Expr /*P*/ )null);
  type$ptr<Expr /*P*/ /*const*/ /*P*/> IR = $tryClone(UnresolvedReductions.begin());
  type$ptr<Expr /*P*/ /*const*/ /*P*/> ER = $tryClone(UnresolvedReductions.end());
  boolean FirstIter = true;
  for (Expr /*P*/ RefExpr : VarList) {
    assert ((RefExpr != null)) : "nullptr expr in OpenMP reduction clause.";
    // OpenMP [2.1, C/C++]
    //  A list item is a variable or array section, subject to the restrictions
    //  specified in Section 2.4 on page 42 and in each of the sections
    // describing clauses and directives for which a list appears.
    // OpenMP  [2.14.3.3, Restrictions, p.1]
    //  A variable that is part of another variable (as an array or
    //  structure element) cannot appear in a private clause.
    if (!FirstIter && $noteq_ptr(IR, ER)) {
      IR.$preInc();
    }
    FirstIter = false;
    SourceLocation ELoc/*J*/= new SourceLocation();
    SourceRange ERange/*J*/= new SourceRange();
    type$ref<Expr /*P*/ > SimpleRefExpr = create_type$ref(RefExpr);
    std.pairTypeBool<ValueDecl /*P*/ > Res = getPrivateItem(/*Deref*/$this(), SimpleRefExpr, ELoc, ERange, 
        /*AllowArraySection=*/ true);
    if (Res.second) {
      // It will be analyzed later.
      Vars.push_back(RefExpr);
      Privates.push_back((Expr /*P*/ /*const*/)null);
      LHSs.push_back((Expr /*P*/ /*const*/)null);
      RHSs.push_back((Expr /*P*/ /*const*/)null);
      // Try to find 'declare reduction' corresponding construct before using
      // builtin/overloaded operators.
      QualType Type = $this().Context.DependentTy.$QualType();
      SmallVector<CXXBaseSpecifier /*P*/> BasePath/*J*/= new SmallVector<CXXBaseSpecifier /*P*/>(4, null);
      ActionResultTTrue<Expr /*P*/ > DeclareReductionRef = buildDeclareReductionRef(/*Deref*/$this(), new SourceLocation(ELoc), new SourceRange(ERange), ((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).getCurScope(), ReductionIdScopeSpec, 
          ReductionId, new QualType(Type), BasePath, $eq_ptr(IR, ER) ? (Expr /*P*/ )null : IR.$star());
      if ($this().CurContext.isDependentContext()
         && (DeclareReductionRef.isUnset()
         || isa_UnresolvedLookupExpr(DeclareReductionRef.get()))) {
        ReductionOps.push_back(DeclareReductionRef.get());
      } else {
        ReductionOps.push_back((Expr /*P*/ /*const*/)null);
      }
    }
    ValueDecl /*P*/ D = Res.first;
    if (!(D != null)) {
      continue;
    }
    
    QualType Type/*J*/= new QualType();
    ArraySubscriptExpr /*P*/ ASE = dyn_cast_ArraySubscriptExpr(RefExpr.IgnoreParens());
    OMPArraySectionExpr /*P*/ OASE = dyn_cast_OMPArraySectionExpr(RefExpr.IgnoreParens());
    if ((ASE != null)) {
      Type.$assignMove(ASE.getType().getNonReferenceType());
    } else if ((OASE != null)) {
      QualType BaseType = OMPArraySectionExpr.getBaseOriginalType(OASE.getBase());
      {
        /*const*/ ArrayType /*P*/ ATy = BaseType.$arrow().getAsArrayTypeUnsafe();
        if ((ATy != null)) {
          Type.$assignMove(ATy.getElementType());
        } else {
          Type.$assignMove(BaseType.$arrow().getPointeeType());
        }
      }
      Type.$assignMove(Type.getNonReferenceType());
    } else {
      Type.$assignMove($this().Context.getBaseElementType(D.getType().getNonReferenceType()));
    }
    VarDecl /*P*/ VD = dyn_cast_VarDecl(D);
    
    // OpenMP [2.9.3.3, Restrictions, C/C++, p.3]
    //  A variable that appears in a private clause must not have an incomplete
    //  type or a reference type.
    if ($this().RequireCompleteType(new SourceLocation(ELoc), new QualType(Type), 
        diag.err_omp_reduction_incomplete_type)) {
      continue;
    }
    // OpenMP [2.14.3.6, reduction clause, Restrictions]
    // A list item that appears in a reduction clause must not be
    // const-qualified.
    if (Type.getNonReferenceType().isConstant($this().Context)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(ELoc), diag.err_omp_const_reduction_list_item)), 
                    getOpenMPClauseName(OpenMPClauseKind.OMPC_reduction)), Type), ERange));
        if (!(ASE != null) && !(OASE != null)) {
          boolean IsDecl = !(VD != null)
             || VD.isThisDeclarationADefinition($this().Context)
             == VarDecl.DefinitionKind.DeclarationOnly;
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(D.getLocation(), 
                  IsDecl ? diag.note_previous_decl : diag.note_defined_here)), 
              D));
        }
        continue;
      } finally {
        $c$.$destroy();
      }
    }
    // OpenMP [2.9.3.6, Restrictions, C/C++, p.4]
    //  If a list-item is a reference type then it must bind to the same object
    //  for all threads of the team.
    if (!(ASE != null) && !(OASE != null) && (VD != null)) {
      VarDecl /*P*/ VDDef = VD.getDefinition();
      if (VD.getType().$arrow().isReferenceType() && (VDDef != null)) {
        DSARefChecker Check/*J*/= new DSARefChecker(((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)));
        if (Check.Visit(VDDef.getInit())) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(ELoc), diag.err_omp_reduction_ref_type_arg)), ERange));
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(VDDef.getLocation(), diag.note_defined_here)), VDDef));
            continue;
          } finally {
            $c$.$destroy();
          }
        }
      }
    }
    
    // OpenMP [2.14.1.1, Data-sharing Attribute Rules for Variables Referenced
    // in a Construct]
    //  Variables with the predetermined data-sharing attributes may not be
    //  listed in data-sharing attributes clauses, except for the cases
    //  listed below. For these exceptions only, listing a predetermined
    //  variable in a data-sharing attribute clause is allowed and overrides
    //  the variable's predetermined data-sharing attributes.
    // OpenMP [2.14.3.6, Restrictions, p.3]
    //  Any number of reduction clauses can be specified on the directive,
    //  but a list item can appear only once in the reduction clauses for that
    //  directive.
    DSAStackTy.DSAVarData DVar/*J*/= new DSAStackTy.DSAVarData();
    DVar.$assignMove(((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).getTopDSA(D, false));
    if (DVar.CKind == OpenMPClauseKind.OMPC_reduction) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(ELoc), diag.err_omp_once_referenced)), 
            getOpenMPClauseName(OpenMPClauseKind.OMPC_reduction)));
        if ((DVar.RefExpr != null)) {
          $c$.clean($c$.track($this().Diag(DVar.RefExpr.getExprLoc(), diag.note_omp_referenced)));
        }
      } finally {
        $c$.$destroy();
      }
    } else if (DVar.CKind != OpenMPClauseKind.OMPC_unknown) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(ELoc), diag.err_omp_wrong_dsa)), 
                getOpenMPClauseName(DVar.CKind)), 
            getOpenMPClauseName(OpenMPClauseKind.OMPC_reduction)));
        ReportOriginalDSA(/*Deref*/$this(), ((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)), D, new DSAStackTy.DSAVarData(DVar));
        continue;
      } finally {
        $c$.$destroy();
      }
    }
    
    // OpenMP [2.14.3.6, Restrictions, p.1]
    //  A list item that appears in a reduction clause of a worksharing
    //  construct must be shared in the parallel regions to which any of the
    //  worksharing regions arising from the worksharing construct bind.
    OpenMPDirectiveKind CurrDir = ((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).getCurrentDirective();
    if (isOpenMPWorksharingDirective(CurrDir)
       && !isOpenMPParallelDirective(CurrDir)) {
      DVar.$assignMove(((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).getImplicitDSA(D, true));
      if (DVar.CKind != OpenMPClauseKind.OMPC_shared) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(ELoc), diag.err_omp_required_access)), 
                  getOpenMPClauseName(OpenMPClauseKind.OMPC_reduction)), 
              getOpenMPClauseName(OpenMPClauseKind.OMPC_shared)));
          ReportOriginalDSA(/*Deref*/$this(), ((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)), D, new DSAStackTy.DSAVarData(DVar));
          continue;
        } finally {
          $c$.$destroy();
        }
      }
    }
    
    // Try to find 'declare reduction' corresponding construct before using
    // builtin/overloaded operators.
    SmallVector<CXXBaseSpecifier /*P*/> BasePath/*J*/= new SmallVector<CXXBaseSpecifier /*P*/>(4, null);
    ActionResultTTrue<Expr /*P*/ > DeclareReductionRef = buildDeclareReductionRef(/*Deref*/$this(), new SourceLocation(ELoc), new SourceRange(ERange), ((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).getCurScope(), ReductionIdScopeSpec, 
        ReductionId, new QualType(Type), BasePath, $eq_ptr(IR, ER) ? (Expr /*P*/ )null : IR.$star());
    if (DeclareReductionRef.isInvalid()) {
      continue;
    }
    if ($this().CurContext.isDependentContext()
       && (DeclareReductionRef.isUnset()
       || isa_UnresolvedLookupExpr(DeclareReductionRef.get()))) {
      Vars.push_back(RefExpr);
      Privates.push_back((Expr /*P*/ /*const*/)null);
      LHSs.push_back((Expr /*P*/ /*const*/)null);
      RHSs.push_back((Expr /*P*/ /*const*/)null);
      ReductionOps.push_back(DeclareReductionRef.get());
      continue;
    }
    if (BOK == BinaryOperatorKind.BO_Comma && DeclareReductionRef.isUnset()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // Not allowed reduction identifier is found.
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(ReductionId.getLocStart(), 
                    diag.err_omp_unknown_reduction_identifier)), 
                Type), ReductionIdRange));
        continue;
      } finally {
        $c$.$destroy();
      }
    }
    
    // OpenMP [2.14.3.6, reduction clause, Restrictions]
    // The type of a list item that appears in a reduction clause must be valid
    // for the reduction-identifier. For a max or min reduction in C, the type
    // of the list item must be an allowed arithmetic data type: char, int,
    // float, double, or _Bool, possibly modified with long, short, signed, or
    // unsigned. For a max or min reduction in C++, the type of the list item
    // must be an allowed arithmetic data type: char, wchar_t, int, float,
    // double, or bool, possibly modified with long, short, signed, or unsigned.
    if (DeclareReductionRef.isUnset()) {
      if ((BOK == BinaryOperatorKind.BO_GT || BOK == BinaryOperatorKind.BO_LT)
         && !(Type.$arrow().isScalarType()
         || ($this().getLangOpts().CPlusPlus && Type.$arrow().isArithmeticType()))) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(ELoc), diag.err_omp_clause_not_arithmetic_type_arg)), 
              $this().getLangOpts().CPlusPlus));
          if (!(ASE != null) && !(OASE != null)) {
            boolean IsDecl = !(VD != null)
               || VD.isThisDeclarationADefinition($this().Context)
               == VarDecl.DefinitionKind.DeclarationOnly;
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(D.getLocation(), 
                    IsDecl ? diag.note_previous_decl : diag.note_defined_here)), 
                D));
          }
          continue;
        } finally {
          $c$.$destroy();
        }
      }
      if ((BOK == BinaryOperatorKind.BO_OrAssign || BOK == BinaryOperatorKind.BO_AndAssign || BOK == BinaryOperatorKind.BO_XorAssign)
         && !$this().getLangOpts().CPlusPlus && Type.$arrow().isFloatingType()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag(new SourceLocation(ELoc), diag.err_omp_clause_floating_type_arg)));
          if (!(ASE != null) && !(OASE != null)) {
            boolean IsDecl = !(VD != null)
               || VD.isThisDeclarationADefinition($this().Context)
               == VarDecl.DefinitionKind.DeclarationOnly;
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(D.getLocation(), 
                    IsDecl ? diag.note_previous_decl : diag.note_defined_here)), 
                D));
          }
          continue;
        } finally {
          $c$.$destroy();
        }
      }
    }
    
    Type.$assignMove(Type.getNonLValueExprType($this().Context).getUnqualifiedType());
    VarDecl /*P*/ LHSVD = buildVarDecl(/*Deref*/$this(), new SourceLocation(ELoc), new QualType(Type), new StringRef(/*KEEP_STR*/".reduction.lhs"), 
        D.hasAttrs() ? $AddrOf(D.getAttrs()) : (SmallVector<Attr /*P*/>/*P*/ )null);
    VarDecl /*P*/ RHSVD = buildVarDecl(/*Deref*/$this(), new SourceLocation(ELoc), new QualType(Type), D.getName(), 
        D.hasAttrs() ? $AddrOf(D.getAttrs()) : (SmallVector<Attr /*P*/>/*P*/ )null);
    QualType PrivateTy = new QualType(Type);
    if ((OASE != null)
       || (!(ASE != null)
       && D.getType().getNonReferenceType().$arrow().isVariablyModifiedType())) {
      // For arays/array sections only:
      // Create pseudo array type for private copy. The size for this array will
      // be generated during codegen.
      // For array subscripts or single variables Private Ty is the same as Type
      // (type of the variable or single array element).
      PrivateTy.$assignMove($this().Context.getVariableArrayType(new QualType(Type), /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->new OpaqueValueExpr(new SourceLocation(), 
                  $this().Context.getSizeType().$QualType(), ExprValueKind.VK_RValue)), 
              ArrayType.ArraySizeModifier.Normal, /*IndexTypeQuals=*/ 0, new SourceRange()));
    } else if (!(ASE != null) && !(OASE != null)
       && ($this().Context.getAsArrayType(D.getType().getNonReferenceType()) != null)) {
      PrivateTy.$assignMove(D.getType().getNonReferenceType());
    }
    // Private copy.
    VarDecl /*P*/ PrivateVD = buildVarDecl(/*Deref*/$this(), new SourceLocation(ELoc), new QualType(PrivateTy), D.getName(), 
        D.hasAttrs() ? $AddrOf(D.getAttrs()) : (SmallVector<Attr /*P*/>/*P*/ )null);
    // Add initializer for private variable.
    Expr /*P*/ Init = null;
    DeclRefExpr /*P*/ LHSDRE = buildDeclRefExpr(/*Deref*/$this(), LHSVD, new QualType(Type), new SourceLocation(ELoc));
    DeclRefExpr /*P*/ RHSDRE = buildDeclRefExpr(/*Deref*/$this(), RHSVD, new QualType(Type), new SourceLocation(ELoc));
    if (DeclareReductionRef.isUsable()) {
      DeclRefExpr /*P*/ DRDRef = DeclareReductionRef.getAs(DeclRefExpr.class);
      OMPDeclareReductionDecl /*P*/ DRD = cast_OMPDeclareReductionDecl(DRDRef.getDecl());
      if ((DRD.getInitializer() != null)) {
        Init = DRDRef;
        RHSVD.setInit(DRDRef);
        RHSVD.setInitStyle(VarDecl.InitializationStyle.CallInit);
      }
    } else {
      switch (BOK) {
       case BO_Add:
       case BO_Xor:
       case BO_Or:
       case BO_LOr:
        // '+', '-', '^', '|', '||' reduction ops - initializer is '0'.
        if (Type.$arrow().isScalarType() || Type.$arrow().isAnyComplexType()) {
          Init = $this().ActOnIntegerConstant(new SourceLocation(ELoc), /*Val=*/ 0).get();
        }
        break;
       case BO_Mul:
       case BO_LAnd:
        if (Type.$arrow().isScalarType() || Type.$arrow().isAnyComplexType()) {
          // '*' and '&&' reduction ops - initializer is '1'.
          Init = $this().ActOnIntegerConstant(new SourceLocation(ELoc), /*Val=*/ 1).get();
        }
        break;
       case BO_And:
        {
          // '&' reduction op - initializer is '~0'.
          QualType OrigType = new QualType(Type);
          {
            /*const*/ ComplexType /*P*/ ComplexTy = OrigType.$arrow().getAs(ComplexType.class);
            if ((ComplexTy != null)) {
              Type.$assignMove(ComplexTy.getElementType());
            }
          }
          if (Type.$arrow().isRealFloatingType()) {
            APFloat InitValue = APFloat.getAllOnesValue($ulong2uint($this().Context.getTypeSize(new QualType(Type))), 
                /*isIEEE=*/ true);
            Init = FloatingLiteral.Create($this().Context, InitValue, /*isexact=*/ true, 
                new QualType(Type), new SourceLocation(ELoc));
          } else if (Type.$arrow().isScalarType()) {
            long/*uint64_t*/ Size = $this().Context.getTypeSize(new QualType(Type));
            QualType IntTy = $this().Context.getIntTypeForBitwidth($ullong2uint(Size), /*Signed=*/ 0);
            APInt InitValue = APInt.getAllOnesValue($ullong2uint(Size));
            Init = IntegerLiteral.Create($this().Context, InitValue, new QualType(IntTy), new SourceLocation(ELoc));
          }
          if ((Init != null) && OrigType.$arrow().isAnyComplexType()) {
            // Init = 0xFFFF + 0xFFFFi;
            ImaginaryLiteral /*P*/ Im = /*FIXME:NEW_EXPR*//*new (Context)*/ new ImaginaryLiteral(Init, new QualType(OrigType));
            Init = $this().CreateBuiltinBinOp(new SourceLocation(ELoc), BinaryOperatorKind.BO_Add, Init, Im).get();
          }
          Type.$assign(OrigType);
          break;
        }
       case BO_LT:
       case BO_GT:
        {
          // 'min' reduction op - initializer is 'Largest representable number in
          // the reduction list item type'.
          // 'max' reduction op - initializer is 'Least representable number in
          // the reduction list item type'.
          if (Type.$arrow().isIntegerType() || Type.$arrow().isPointerType()) {
            boolean IsSigned = Type.$arrow().hasSignedIntegerRepresentation();
            long/*uint64_t*/ Size = $this().Context.getTypeSize(new QualType(Type));
            QualType IntTy = $this().Context.getIntTypeForBitwidth($ullong2uint(Size), /*Signed=*/ (IsSigned ? 1 : 0));
            APInt InitValue = (BOK != BinaryOperatorKind.BO_LT) ? IsSigned ? APInt.getSignedMinValue($ullong2uint(Size)) : APInt.getMinValue($ullong2uint(Size)) : IsSigned ? APInt.getSignedMaxValue($ullong2uint(Size)) : APInt.getMaxValue($ullong2uint(Size));
            Init = IntegerLiteral.Create($this().Context, InitValue, new QualType(IntTy), new SourceLocation(ELoc));
            if (Type.$arrow().isPointerType()) {
              // Cast to pointer type.
              ActionResultTTrue<Expr /*P*/ > CastExpr = $this().BuildCStyleCastExpr(new SourceLocation(), $this().Context.getTrivialTypeSourceInfo(new QualType(Type), new SourceLocation(ELoc)), 
                  new SourceLocation(), Init);
              if (CastExpr.isInvalid()) {
                continue;
              }
              Init = CastExpr.get();
            }
          } else if (Type.$arrow().isRealFloatingType()) {
            APFloat InitValue = APFloat.getLargest($this().Context.getFloatTypeSemantics(new QualType(Type)), BOK != BinaryOperatorKind.BO_LT);
            Init = FloatingLiteral.Create($this().Context, InitValue, /*isexact=*/ true, 
                new QualType(Type), new SourceLocation(ELoc));
          }
          break;
        }
       case BO_PtrMemD:
       case BO_PtrMemI:
       case BO_MulAssign:
       case BO_Div:
       case BO_Rem:
       case BO_Sub:
       case BO_Shl:
       case BO_Shr:
       case BO_LE:
       case BO_GE:
       case BO_EQ:
       case BO_NE:
       case BO_AndAssign:
       case BO_XorAssign:
       case BO_OrAssign:
       case BO_Assign:
       case BO_AddAssign:
       case BO_SubAssign:
       case BO_DivAssign:
       case BO_RemAssign:
       case BO_ShlAssign:
       case BO_ShrAssign:
       case BO_Comma:
        throw new llvm_unreachable("Unexpected reduction operation");
      }
    }
    if ((Init != null) && DeclareReductionRef.isUnset()) {
      $this().AddInitializerToDecl(RHSVD, Init, /*DirectInit=*/ false, 
          /*TypeMayContainAuto=*/ false);
    } else if (!(Init != null)) {
      $this().ActOnUninitializedDecl(RHSVD, /*TypeMayContainAuto=*/ false);
    }
    if (RHSVD.isInvalidDecl()) {
      continue;
    }
    if (!RHSVD.hasInit() && DeclareReductionRef.isUnset()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(ELoc), diag.err_omp_reduction_id_not_compatible)), Type), 
            ReductionIdRange));
        boolean IsDecl = !(VD != null)
           || VD.isThisDeclarationADefinition($this().Context) == VarDecl.DefinitionKind.DeclarationOnly;
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(D.getLocation(), 
                IsDecl ? diag.note_previous_decl : diag.note_defined_here)), 
            D));
        continue;
      } finally {
        $c$.$destroy();
      }
    }
    // Store initializer for single element in private copy. Will be used during
    // codegen.
    PrivateVD.setInit(RHSVD.getInit());
    PrivateVD.setInitStyle(RHSVD.getInitStyle());
    DeclRefExpr /*P*/ PrivateDRE = buildDeclRefExpr(/*Deref*/$this(), PrivateVD, new QualType(PrivateTy), new SourceLocation(ELoc));
    ActionResultTTrue<Expr /*P*/ > ReductionOp/*J*/= new ActionResultTTrue<Expr /*P*/ >();
    if (DeclareReductionRef.isUsable()) {
      QualType RedTy = DeclareReductionRef.get().getType();
      QualType PtrRedTy = $this().Context.getPointerType(new QualType(RedTy));
      ActionResultTTrue<Expr /*P*/ > LHS = $this().CreateBuiltinUnaryOp(new SourceLocation(ELoc), UnaryOperatorKind.UO_AddrOf, LHSDRE);
      ActionResultTTrue<Expr /*P*/ > RHS = $this().CreateBuiltinUnaryOp(new SourceLocation(ELoc), UnaryOperatorKind.UO_AddrOf, RHSDRE);
      if (!BasePath.empty()) {
        LHS.$assignMove($this().DefaultLvalueConversion(LHS.get()));
        RHS.$assignMove($this().DefaultLvalueConversion(RHS.get()));
        LHS.$assign(ImplicitCastExpr.Create($this().Context, new QualType(PtrRedTy), 
                CastKind.CK_UncheckedDerivedToBase, LHS.get(), 
                $AddrOf(BasePath), LHS.get().getValueKind()));
        RHS.$assign(ImplicitCastExpr.Create($this().Context, new QualType(PtrRedTy), 
                CastKind.CK_UncheckedDerivedToBase, RHS.get(), 
                $AddrOf(BasePath), RHS.get().getValueKind()));
      }
      FunctionProtoType.ExtProtoInfo EPI/*J*/= new FunctionProtoType.ExtProtoInfo();
      QualType Params[/*2*/] = new QualType [/*2*/] {PtrRedTy, PtrRedTy};
      QualType FnTy = $this().Context.getFunctionType($this().Context.VoidTy.$QualType(), new ArrayRef<QualType>(Params, false), EPI);
      OpaqueValueExpr /*P*/ OVE = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->new OpaqueValueExpr(new SourceLocation(ELoc), $this().Context.getPointerType(new QualType(FnTy)), ExprValueKind.VK_RValue, ExprObjectKind.OK_Ordinary, 
          $this().DefaultLvalueConversion(DeclareReductionRef.get()).get()));
      Expr /*P*/ Args[/*2*/] = new Expr /*P*/  [/*2*/] {LHS.get(), RHS.get()};
      ReductionOp.$assign(/*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->new CallExpr($this().Context, OVE, new ArrayRef<Expr /*P*/ >(Args, true), $this().Context.VoidTy.$QualType(), ExprValueKind.VK_RValue, new SourceLocation(ELoc))));
    } else {
      ReductionOp.$assignMove($this().BuildBinOp(((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).getCurScope(), 
              ReductionId.getLocStart(), BOK, LHSDRE, RHSDRE));
      if (ReductionOp.isUsable()) {
        if (BOK != BinaryOperatorKind.BO_LT && BOK != BinaryOperatorKind.BO_GT) {
          ReductionOp.$assignMove(
              $this().BuildBinOp(((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).getCurScope(), ReductionId.getLocStart(), 
                  BinaryOperatorKind.BO_Assign, LHSDRE, ReductionOp.get())
          );
        } else {
          ConditionalOperator /*P*/ ConditionalOp = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->new ConditionalOperator(ReductionOp.get(), new SourceLocation(), LHSDRE, new SourceLocation(), 
              RHSDRE, new QualType(Type), ExprValueKind.VK_LValue, ExprObjectKind.OK_Ordinary));
          ReductionOp.$assignMove(
              $this().BuildBinOp(((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).getCurScope(), ReductionId.getLocStart(), 
                  BinaryOperatorKind.BO_Assign, LHSDRE, ConditionalOp)
          );
        }
        ReductionOp.$assignMove($this().ActOnFinishFullExpr(ReductionOp.get()));
      }
      if (ReductionOp.isInvalid()) {
        continue;
      }
    }
    
    DeclRefExpr /*P*/ Ref = null;
    Expr /*P*/ VarsExpr = RefExpr.IgnoreParens();
    if (!(VD != null) && !$this().CurContext.isDependentContext()) {
      if ((ASE != null) || (OASE != null)) {
        TransformExprToCaptures RebuildToCapture = null;
        try {
          RebuildToCapture/*J*/= new TransformExprToCaptures(/*Deref*/$this(), D);
          VarsExpr
             = RebuildToCapture.TransformExpr(RefExpr.IgnoreParens()).get();
          Ref = RebuildToCapture.getCapturedExpr();
        } finally {
          if (RebuildToCapture != null) { RebuildToCapture.$destroy(); }
        }
      } else {
        VarsExpr = Ref
           = buildCapture(/*Deref*/$this(), D, SimpleRefExpr.$deref(), /*WithInit=*/ false);
      }
      if (!($this().IsOpenMPCapturedDecl(D) != null)) {
        ExprCaptures.push_back(Ref.getDecl());
        if (Ref.getDecl().hasAttr(OMPCaptureNoInitAttr.class)) {
          ActionResultTTrue<Expr /*P*/ > RefRes = $this().DefaultLvalueConversion(Ref);
          if (!RefRes.isUsable()) {
            continue;
          }
          ActionResultTTrue<Expr /*P*/ > PostUpdateRes = $this().BuildBinOp(((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).getCurScope(), new SourceLocation(ELoc), BinaryOperatorKind.BO_Assign, 
              SimpleRefExpr.$deref(), RefRes.get());
          if (!PostUpdateRes.isUsable()) {
            continue;
          }
          ExprPostUpdates.push_back($this().IgnoredValueConversions(PostUpdateRes.get()).get());
        }
      }
    }
    ((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).addDSA(D, RefExpr.IgnoreParens(), OpenMPClauseKind.OMPC_reduction, Ref);
    Vars.push_back(VarsExpr);
    Privates.push_back(PrivateDRE);
    LHSs.push_back(LHSDRE);
    RHSs.push_back(RHSDRE);
    ReductionOps.push_back(ReductionOp.get());
  }
  if (Vars.empty()) {
    return null;
  }
  
  return OMPReductionClause.Create($this().Context, new SourceLocation(StartLoc), new SourceLocation(LParenLoc), new SourceLocation(ColonLoc), new SourceLocation(EndLoc), new ArrayRef<Expr /*P*/ >(Vars, true), 
      ReductionIdScopeSpec.getWithLocInContext($this().Context), ReductionId, new ArrayRef<Expr /*P*/ >(Privates, true), 
      new ArrayRef<Expr /*P*/ >(LHSs, true), new ArrayRef<Expr /*P*/ >(RHSs, true), new ArrayRef<Expr /*P*/ >(ReductionOps, true), buildPreInits($this().Context, ExprCaptures), 
      buildPostUpdate(/*Deref*/$this(), new ArrayRef<Expr /*P*/ >(ExprPostUpdates, true)));
}

/// \brief Called on well-formed 'linear' clause.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnOpenMPLinearClause">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 9568,
 FQN="clang::Sema::ActOnOpenMPLinearClause", NM="_ZN5clang4Sema23ActOnOpenMPLinearClauseEN4llvm8ArrayRefIPNS_4ExprEEES4_NS_14SourceLocationES6_NS_22OpenMPLinearClauseKindES6_S6_S6_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4Sema23ActOnOpenMPLinearClauseEN4llvm8ArrayRefIPNS_4ExprEEES4_NS_14SourceLocationES6_NS_22OpenMPLinearClauseKindES6_S6_S6_")
//</editor-fold>
public final OMPClause /*P*/ ActOnOpenMPLinearClause(ArrayRef<Expr /*P*/ > VarList, Expr /*P*/ Step, SourceLocation StartLoc, 
                       SourceLocation LParenLoc, OpenMPLinearClauseKind LinKind, 
                       SourceLocation LinLoc, SourceLocation ColonLoc, SourceLocation EndLoc) {
  SmallVector<Expr /*P*/ > Vars/*J*/= new SmallVector<Expr /*P*/ >(8, (Expr /*P*/ )null);
  SmallVector<Expr /*P*/ > Privates/*J*/= new SmallVector<Expr /*P*/ >(8, (Expr /*P*/ )null);
  SmallVector<Expr /*P*/ > Inits/*J*/= new SmallVector<Expr /*P*/ >(8, (Expr /*P*/ )null);
  SmallVector<Decl /*P*/> ExprCaptures/*J*/= new SmallVector<Decl /*P*/>(4, null);
  SmallVector<Expr /*P*/ > ExprPostUpdates/*J*/= new SmallVector<Expr /*P*/ >(4, (Expr /*P*/ )null);
  if ($this().CheckOpenMPLinearModifier(LinKind, new SourceLocation(LinLoc))) {
    LinKind = OpenMPLinearClauseKind.OMPC_LINEAR_val;
  }
  for (final Expr /*P*/ /*const*/ /*&*/ RefExpr : VarList) {
    assert ((RefExpr != null)) : "NULL expr in OpenMP linear clause.";
    SourceLocation ELoc/*J*/= new SourceLocation();
    SourceRange ERange/*J*/= new SourceRange();
    type$ref<Expr /*P*/ > SimpleRefExpr = create_type$ref(RefExpr);
    std.pairTypeBool<ValueDecl /*P*/ > Res = getPrivateItem(/*Deref*/$this(), SimpleRefExpr, ELoc, ERange, 
        /*AllowArraySection=*/ false);
    if (Res.second) {
      // It will be analyzed later.
      Vars.push_back(RefExpr);
      Privates.push_back((Expr /*P*/ /*const*/)null);
      Inits.push_back((Expr /*P*/ /*const*/)null);
    }
    ValueDecl /*P*/ D = Res.first;
    if (!(D != null)) {
      continue;
    }
    
    QualType Type = D.getType();
    VarDecl /*P*/ VD = dyn_cast_VarDecl(D);
    
    // OpenMP [2.14.3.7, linear clause]
    //  A list-item cannot appear in more than one linear clause.
    //  A list-item that appears in a linear clause cannot appear in any
    //  other data-sharing attribute clause.
    DSAStackTy.DSAVarData DVar = ((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).getTopDSA(D, false);
    if ((DVar.RefExpr != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(ELoc), diag.err_omp_wrong_dsa)), getOpenMPClauseName(DVar.CKind)), 
            getOpenMPClauseName(OpenMPClauseKind.OMPC_linear)));
        ReportOriginalDSA(/*Deref*/$this(), ((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)), D, new DSAStackTy.DSAVarData(DVar));
        continue;
      } finally {
        $c$.$destroy();
      }
    }
    if ($this().CheckOpenMPLinearDecl(D, new SourceLocation(ELoc), LinKind, new QualType(Type))) {
      continue;
    }
    Type.$assignMove(Type.getNonReferenceType().getUnqualifiedType().getCanonicalType());
    
    // Build private copy of original var.
    VarDecl /*P*/ Private = buildVarDecl(/*Deref*/$this(), new SourceLocation(ELoc), new QualType(Type), D.getName(), 
        D.hasAttrs() ? $AddrOf(D.getAttrs()) : (SmallVector<Attr /*P*/>/*P*/ )null);
    DeclRefExpr /*P*/ PrivateRef = buildDeclRefExpr(/*Deref*/$this(), Private, new QualType(Type), new SourceLocation(ELoc));
    // Build var to save initial value.
    VarDecl /*P*/ Init = buildVarDecl(/*Deref*/$this(), new SourceLocation(ELoc), new QualType(Type), new StringRef(/*KEEP_STR*/".linear.start"));
    Expr /*P*/ InitExpr;
    DeclRefExpr /*P*/ Ref = null;
    if (!(VD != null) && !$this().CurContext.isDependentContext()) {
      Ref = buildCapture(/*Deref*/$this(), D, SimpleRefExpr.$deref(), /*WithInit=*/ false);
      if (!($this().IsOpenMPCapturedDecl(D) != null)) {
        ExprCaptures.push_back(Ref.getDecl());
        if (Ref.getDecl().hasAttr(OMPCaptureNoInitAttr.class)) {
          ActionResultTTrue<Expr /*P*/ > RefRes = $this().DefaultLvalueConversion(Ref);
          if (!RefRes.isUsable()) {
            continue;
          }
          ActionResultTTrue<Expr /*P*/ > PostUpdateRes = $this().BuildBinOp(((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).getCurScope(), new SourceLocation(ELoc), BinaryOperatorKind.BO_Assign, 
              SimpleRefExpr.$deref(), RefRes.get());
          if (!PostUpdateRes.isUsable()) {
            continue;
          }
          ExprPostUpdates.push_back($this().IgnoredValueConversions(PostUpdateRes.get()).get());
        }
      }
    }
    if (LinKind == OpenMPLinearClauseKind.OMPC_LINEAR_uval) {
      InitExpr = (VD != null) ? VD.getInit() : SimpleRefExpr.$deref();
    } else {
      InitExpr = (VD != null) ? SimpleRefExpr.$deref() : Ref;
    }
    $this().AddInitializerToDecl(Init, $this().DefaultLvalueConversion(InitExpr).get(), 
        /*DirectInit=*/ false, /*TypeMayContainAuto=*/ false);
    DeclRefExpr /*P*/ InitRef = buildDeclRefExpr(/*Deref*/$this(), Init, new QualType(Type), new SourceLocation(ELoc));
    ((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).addDSA(D, RefExpr.IgnoreParens(), OpenMPClauseKind.OMPC_linear, Ref);
    Vars.push_back(((VD != null) || $this().CurContext.isDependentContext()) ? RefExpr.IgnoreParens() : Ref);
    Privates.push_back(PrivateRef);
    Inits.push_back(InitRef);
  }
  if (Vars.empty()) {
    return null;
  }
  
  Expr /*P*/ StepExpr = Step;
  Expr /*P*/ CalcStepExpr = null;
  if ((Step != null) && !Step.isValueDependent() && !Step.isTypeDependent()
     && !Step.isInstantiationDependent()
     && !Step.containsUnexpandedParameterPack()) {
    SourceLocation StepLoc = Step.getLocStart();
    ActionResultTTrue<Expr /*P*/ > Val = $this().PerformOpenMPImplicitIntegerConversion(new SourceLocation(StepLoc), Step);
    if (Val.isInvalid()) {
      return null;
    }
    StepExpr = Val.get();
    
    // Build var to save the step value.
    VarDecl /*P*/ SaveVar = buildVarDecl(/*Deref*/$this(), new SourceLocation(StepLoc), StepExpr.getType(), new StringRef(/*KEEP_STR*/".linear.step"));
    ActionResultTTrue<Expr /*P*/ > SaveRef = new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, buildDeclRefExpr(/*Deref*/$this(), SaveVar, StepExpr.getType(), new SourceLocation(StepLoc)));
    ActionResultTTrue<Expr /*P*/ > CalcStep = $this().BuildBinOp($this().CurScope, new SourceLocation(StepLoc), BinaryOperatorKind.BO_Assign, SaveRef.get(), StepExpr);
    CalcStep.$assignMove($this().ActOnFinishFullExpr(CalcStep.get()));
    
    // Warn about zero linear step (it would be probably better specified as
    // making corresponding variables 'const').
    APSInt Result/*J*/= new APSInt();
    boolean IsConstant = StepExpr.isIntegerConstantExpr(Result, $this().Context);
    if (IsConstant && !Result.isNegative() && !Result.isStrictlyPositive()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(StepLoc), diag.warn_omp_linear_step_zero)), Vars.$at(0)), 
            ($greater_uint(Vars.size(), 1))));
      } finally {
        $c$.$destroy();
      }
    }
    if (!IsConstant && CalcStep.isUsable()) {
      // Calculate the step beforehand instead of doing this on each iteration.
      // (This is not used if the number of iterations may be kfold-ed).
      CalcStepExpr = CalcStep.get();
    }
  }
  
  return OMPLinearClause.Create($this().Context, new SourceLocation(StartLoc), new SourceLocation(LParenLoc), LinKind, new SourceLocation(LinLoc), 
      new SourceLocation(ColonLoc), new SourceLocation(EndLoc), new ArrayRef<Expr /*P*/ >(Vars, true), new ArrayRef<Expr /*P*/ >(Privates, true), new ArrayRef<Expr /*P*/ >(Inits, true), 
      StepExpr, CalcStepExpr, 
      buildPreInits($this().Context, ExprCaptures), 
      buildPostUpdate(/*Deref*/$this(), new ArrayRef<Expr /*P*/ >(ExprPostUpdates, true)));
}

/// \brief Called on well-formed 'aligned' clause.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnOpenMPAlignedClause">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 9789,
 FQN="clang::Sema::ActOnOpenMPAlignedClause", NM="_ZN5clang4Sema24ActOnOpenMPAlignedClauseEN4llvm8ArrayRefIPNS_4ExprEEES4_NS_14SourceLocationES6_S6_S6_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4Sema24ActOnOpenMPAlignedClauseEN4llvm8ArrayRefIPNS_4ExprEEES4_NS_14SourceLocationES6_S6_S6_")
//</editor-fold>
public final OMPClause /*P*/ ActOnOpenMPAlignedClause(ArrayRef<Expr /*P*/ > VarList, Expr /*P*/ Alignment, SourceLocation StartLoc, 
                        SourceLocation LParenLoc, SourceLocation ColonLoc, SourceLocation EndLoc) {
  
  SmallVector<Expr /*P*/ > Vars/*J*/= new SmallVector<Expr /*P*/ >(8, (Expr /*P*/ )null);
  for (final Expr /*P*/ /*const*/ /*&*/ RefExpr : VarList) {
    assert ((RefExpr != null)) : "NULL expr in OpenMP linear clause.";
    SourceLocation ELoc/*J*/= new SourceLocation();
    SourceRange ERange/*J*/= new SourceRange();
    type$ref<Expr /*P*/ > SimpleRefExpr = create_type$ref(RefExpr);
    std.pairTypeBool<ValueDecl /*P*/ > Res = getPrivateItem(/*Deref*/$this(), SimpleRefExpr, ELoc, ERange, 
        /*AllowArraySection=*/ false);
    if (Res.second) {
      // It will be analyzed later.
      Vars.push_back(RefExpr);
    }
    ValueDecl /*P*/ D = Res.first;
    if (!(D != null)) {
      continue;
    }
    
    QualType QType = D.getType();
    VarDecl /*P*/ VD = dyn_cast_VarDecl(D);
    
    // OpenMP  [2.8.1, simd construct, Restrictions]
    // The type of list items appearing in the aligned clause must be
    // array, pointer, reference to array, or reference to pointer.
    QType.$assignMove(QType.getNonReferenceType().getUnqualifiedType().getCanonicalType());
    /*const*/ Type /*P*/ Ty = QType.getTypePtrOrNull();
    if (!(Ty != null) || (!Ty.isArrayType() && !Ty.isPointerType())) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(ELoc), diag.err_omp_aligned_expected_array_or_ptr)), 
                    QType), $this().getLangOpts().CPlusPlus), ERange));
        boolean IsDecl = !(VD != null)
           || VD.isThisDeclarationADefinition($this().Context) == VarDecl.DefinitionKind.DeclarationOnly;
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(D.getLocation(), 
                IsDecl ? diag.note_previous_decl : diag.note_defined_here)), 
            D));
        continue;
      } finally {
        $c$.$destroy();
      }
    }
    {
      
      // OpenMP  [2.8.1, simd construct, Restrictions]
      // A list-item cannot appear in more than one aligned clause.
      Expr /*P*/ PrevRef = ((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).addUniqueAligned(D, SimpleRefExpr.$deref());
      if ((PrevRef != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(ELoc), diag.err_omp_aligned_twice)), 0), ERange));
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(PrevRef.getExprLoc(), diag.note_omp_explicit_dsa)), 
              getOpenMPClauseName(OpenMPClauseKind.OMPC_aligned)));
          continue;
        } finally {
          $c$.$destroy();
        }
      }
    }
    
    DeclRefExpr /*P*/ Ref = null;
    if (!(VD != null) && ($this().IsOpenMPCapturedDecl(D) != null)) {
      Ref = buildCapture(/*Deref*/$this(), D, SimpleRefExpr.$deref(), /*WithInit=*/ true);
    }
    Vars.push_back($this().DefaultFunctionArrayConversion(((VD != null) || !(Ref != null)) ? RefExpr.IgnoreParens() : Ref).
            get());
  }
  
  // OpenMP [2.8.1, simd construct, Description]
  // The parameter of the aligned clause, alignment, must be a constant
  // positive integer expression.
  // If no optional parameter is specified, implementation-defined default
  // alignments for SIMD instructions on the target platforms are assumed.
  if (Alignment != null) {
    ActionResultTTrue<Expr /*P*/ > AlignResult = $this().VerifyPositiveIntegerConstantInClause(Alignment, OpenMPClauseKind.OMPC_aligned);
    if (AlignResult.isInvalid()) {
      return null;
    }
    Alignment = AlignResult.get();
  }
  if (Vars.empty()) {
    return null;
  }
  
  return OMPAlignedClause.Create($this().Context, new SourceLocation(StartLoc), new SourceLocation(LParenLoc), new SourceLocation(ColonLoc), 
      new SourceLocation(EndLoc), new ArrayRef<Expr /*P*/ >(Vars, true), Alignment);
}

/// \brief Called on well-formed 'copyin' clause.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnOpenMPCopyinClause">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 9865,
 FQN="clang::Sema::ActOnOpenMPCopyinClause", NM="_ZN5clang4Sema23ActOnOpenMPCopyinClauseEN4llvm8ArrayRefIPNS_4ExprEEENS_14SourceLocationES6_S6_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4Sema23ActOnOpenMPCopyinClauseEN4llvm8ArrayRefIPNS_4ExprEEENS_14SourceLocationES6_S6_")
//</editor-fold>
public final OMPClause /*P*/ ActOnOpenMPCopyinClause(ArrayRef<Expr /*P*/ > VarList, 
                       SourceLocation StartLoc, 
                       SourceLocation LParenLoc, 
                       SourceLocation EndLoc) {
  SmallVector<Expr /*P*/ > Vars/*J*/= new SmallVector<Expr /*P*/ >(8, (Expr /*P*/ )null);
  SmallVector<Expr /*P*/ > SrcExprs/*J*/= new SmallVector<Expr /*P*/ >(8, (Expr /*P*/ )null);
  SmallVector<Expr /*P*/ > DstExprs/*J*/= new SmallVector<Expr /*P*/ >(8, (Expr /*P*/ )null);
  SmallVector<Expr /*P*/ > AssignmentOps/*J*/= new SmallVector<Expr /*P*/ >(8, (Expr /*P*/ )null);
  for (final Expr /*P*/ /*const*/ /*&*/ RefExpr : VarList) {
    assert ((RefExpr != null)) : "NULL expr in OpenMP copyin clause.";
    if (isa_DependentScopeDeclRefExpr(RefExpr)) {
      // It will be analyzed later.
      Vars.push_back(RefExpr);
      SrcExprs.push_back((Expr /*P*/ /*const*/)null);
      DstExprs.push_back((Expr /*P*/ /*const*/)null);
      AssignmentOps.push_back((Expr /*P*/ /*const*/)null);
      continue;
    }
    
    SourceLocation ELoc = RefExpr.getExprLoc();
    // OpenMP [2.1, C/C++]
    //  A list item is a variable name.
    // OpenMP  [2.14.4.1, Restrictions, p.1]
    //  A list item that appears in a copyin clause must be threadprivate.
    DeclRefExpr /*P*/ DE = dyn_cast_DeclRefExpr(RefExpr);
    if (!(DE != null) || !isa_VarDecl(DE.getDecl())) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(ELoc), diag.err_omp_expected_var_name_member_expr)), 
                0), RefExpr.getSourceRange()));
        continue;
      } finally {
        $c$.$destroy();
      }
    }
    
    Decl /*P*/ D = DE.getDecl();
    VarDecl /*P*/ VD = cast_VarDecl(D);
    
    QualType Type = VD.getType();
    if (Type.$arrow().isDependentType() || Type.$arrow().isInstantiationDependentType()) {
      // It will be analyzed later.
      Vars.push_back(DE);
      SrcExprs.push_back((Expr /*P*/ /*const*/)null);
      DstExprs.push_back((Expr /*P*/ /*const*/)null);
      AssignmentOps.push_back((Expr /*P*/ /*const*/)null);
      continue;
    }
    
    // OpenMP [2.14.4.1, Restrictions, C/C++, p.1]
    //  A list item that appears in a copyin clause must be threadprivate.
    if (!((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).isThreadPrivate(VD)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(ELoc), diag.err_omp_required_access)), 
                getOpenMPClauseName(OpenMPClauseKind.OMPC_copyin)), 
            getOpenMPDirectiveName(OpenMPDirectiveKind.OMPD_threadprivate)));
        continue;
      } finally {
        $c$.$destroy();
      }
    }
    
    // OpenMP [2.14.4.1, Restrictions, C/C++, p.2]
    //  A variable of class type (or array thereof) that appears in a
    //  copyin clause requires an accessible, unambiguous copy assignment
    //  operator for the class type.
    QualType ElemType = $this().Context.getBaseElementType(new QualType(Type)).getNonReferenceType();
    VarDecl /*P*/ SrcVD = buildVarDecl(/*Deref*/$this(), DE.getLocStart(), ElemType.getUnqualifiedType(), 
        new StringRef(/*KEEP_STR*/".copyin.src"), VD.hasAttrs() ? $AddrOf(VD.getAttrs()) : (SmallVector<Attr /*P*/>/*P*/ )null);
    DeclRefExpr /*P*/ PseudoSrcExpr = buildDeclRefExpr(/*Deref*/$this(), SrcVD, ElemType.getUnqualifiedType(), DE.getExprLoc());
    VarDecl /*P*/ DstVD = buildVarDecl(/*Deref*/$this(), DE.getLocStart(), new QualType(ElemType), new StringRef(/*KEEP_STR*/".copyin.dst"), 
        VD.hasAttrs() ? $AddrOf(VD.getAttrs()) : (SmallVector<Attr /*P*/>/*P*/ )null);
    DeclRefExpr /*P*/ PseudoDstExpr = buildDeclRefExpr(/*Deref*/$this(), DstVD, new QualType(ElemType), DE.getExprLoc());
    // For arrays generate assignment operation for single element and replace
    // it by the original array element in CodeGen.
    ActionResultTTrue<Expr /*P*/ > AssignmentOp = $this().BuildBinOp(/*S=*/ (Scope /*P*/ )null, DE.getExprLoc(), BinaryOperatorKind.BO_Assign, 
        PseudoDstExpr, PseudoSrcExpr);
    if (AssignmentOp.isInvalid()) {
      continue;
    }
    AssignmentOp.$assignMove($this().ActOnFinishFullExpr(AssignmentOp.get(), DE.getExprLoc(), 
            /*DiscardedValue=*/ true));
    if (AssignmentOp.isInvalid()) {
      continue;
    }
    ((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).addDSA(VD, DE, OpenMPClauseKind.OMPC_copyin);
    Vars.push_back(DE);
    SrcExprs.push_back(PseudoSrcExpr);
    DstExprs.push_back(PseudoDstExpr);
    AssignmentOps.push_back(AssignmentOp.get());
  }
  if (Vars.empty()) {
    return null;
  }
  
  return OMPCopyinClause.Create($this().Context, new SourceLocation(StartLoc), new SourceLocation(LParenLoc), new SourceLocation(EndLoc), new ArrayRef<Expr /*P*/ >(Vars, true), 
      new ArrayRef<Expr /*P*/ >(SrcExprs, true), new ArrayRef<Expr /*P*/ >(DstExprs, true), new ArrayRef<Expr /*P*/ >(AssignmentOps, true));
}

/// \brief Called on well-formed 'copyprivate' clause.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnOpenMPCopyprivateClause">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 9958,
 FQN="clang::Sema::ActOnOpenMPCopyprivateClause", NM="_ZN5clang4Sema28ActOnOpenMPCopyprivateClauseEN4llvm8ArrayRefIPNS_4ExprEEENS_14SourceLocationES6_S6_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4Sema28ActOnOpenMPCopyprivateClauseEN4llvm8ArrayRefIPNS_4ExprEEENS_14SourceLocationES6_S6_")
//</editor-fold>
public final OMPClause /*P*/ ActOnOpenMPCopyprivateClause(ArrayRef<Expr /*P*/ > VarList, 
                            SourceLocation StartLoc, 
                            SourceLocation LParenLoc, 
                            SourceLocation EndLoc) {
  SmallVector<Expr /*P*/ > Vars/*J*/= new SmallVector<Expr /*P*/ >(8, (Expr /*P*/ )null);
  SmallVector<Expr /*P*/ > SrcExprs/*J*/= new SmallVector<Expr /*P*/ >(8, (Expr /*P*/ )null);
  SmallVector<Expr /*P*/ > DstExprs/*J*/= new SmallVector<Expr /*P*/ >(8, (Expr /*P*/ )null);
  SmallVector<Expr /*P*/ > AssignmentOps/*J*/= new SmallVector<Expr /*P*/ >(8, (Expr /*P*/ )null);
  for (final Expr /*P*/ /*const*/ /*&*/ RefExpr : VarList) {
    assert ((RefExpr != null)) : "NULL expr in OpenMP linear clause.";
    SourceLocation ELoc/*J*/= new SourceLocation();
    SourceRange ERange/*J*/= new SourceRange();
    type$ref<Expr /*P*/ > SimpleRefExpr = create_type$ref(RefExpr);
    std.pairTypeBool<ValueDecl /*P*/ > Res = getPrivateItem(/*Deref*/$this(), SimpleRefExpr, ELoc, ERange, 
        /*AllowArraySection=*/ false);
    if (Res.second) {
      // It will be analyzed later.
      Vars.push_back(RefExpr);
      SrcExprs.push_back((Expr /*P*/ /*const*/)null);
      DstExprs.push_back((Expr /*P*/ /*const*/)null);
      AssignmentOps.push_back((Expr /*P*/ /*const*/)null);
    }
    ValueDecl /*P*/ D = Res.first;
    if (!(D != null)) {
      continue;
    }
    
    QualType Type = D.getType();
    VarDecl /*P*/ VD = dyn_cast_VarDecl(D);
    
    // OpenMP [2.14.4.2, Restrictions, p.2]
    //  A list item that appears in a copyprivate clause may not appear in a
    //  private or firstprivate clause on the single construct.
    if (!(VD != null) || !((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).isThreadPrivate(VD)) {
      DSAVarData DVar = ((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).getTopDSA(D, false);
      if (DVar.CKind != OpenMPClauseKind.OMPC_unknown && DVar.CKind != OpenMPClauseKind.OMPC_copyprivate
         && (DVar.RefExpr != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(ELoc), diag.err_omp_wrong_dsa)), 
                  getOpenMPClauseName(DVar.CKind)), 
              getOpenMPClauseName(OpenMPClauseKind.OMPC_copyprivate)));
          ReportOriginalDSA(/*Deref*/$this(), ((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)), D, new DSAStackTy.DSAVarData(DVar));
          continue;
        } finally {
          $c$.$destroy();
        }
      }
      
      // OpenMP [2.11.4.2, Restrictions, p.1]
      //  All list items that appear in a copyprivate clause must be either
      //  threadprivate or private in the enclosing context.
      if (DVar.CKind == OpenMPClauseKind.OMPC_unknown) {
        DVar.$assignMove(((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).getImplicitDSA(D, false));
        if (DVar.CKind == OpenMPClauseKind.OMPC_shared) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(ELoc), diag.err_omp_required_access)), 
                    getOpenMPClauseName(OpenMPClauseKind.OMPC_copyprivate)), 
                /*KEEP_STR*/"threadprivate or private in the enclosing context"));
            ReportOriginalDSA(/*Deref*/$this(), ((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)), D, new DSAStackTy.DSAVarData(DVar));
            continue;
          } finally {
            $c$.$destroy();
          }
        }
      }
    }
    
    // Variably modified types are not supported.
    if (!Type.$arrow().isAnyPointerType() && Type.$arrow().isVariablyModifiedType()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(ELoc), diag.err_omp_variably_modified_type_not_supported)), 
                    getOpenMPClauseName(OpenMPClauseKind.OMPC_copyprivate)), Type), 
            getOpenMPDirectiveName(((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).getCurrentDirective())));
        boolean IsDecl = !(VD != null)
           || VD.isThisDeclarationADefinition($this().Context) == VarDecl.DefinitionKind.DeclarationOnly;
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(D.getLocation(), 
                IsDecl ? diag.note_previous_decl : diag.note_defined_here)), 
            D));
        continue;
      } finally {
        $c$.$destroy();
      }
    }
    
    // OpenMP [2.14.4.1, Restrictions, C/C++, p.2]
    //  A variable of class type (or array thereof) that appears in a
    //  copyin clause requires an accessible, unambiguous copy assignment
    //  operator for the class type.
    Type.$assignMove($this().Context.getBaseElementType(Type.getNonReferenceType()).
            getUnqualifiedType());
    VarDecl /*P*/ SrcVD = buildVarDecl(/*Deref*/$this(), RefExpr.getLocStart(), new QualType(Type), new StringRef(/*KEEP_STR*/".copyprivate.src"), 
        D.hasAttrs() ? $AddrOf(D.getAttrs()) : (SmallVector<Attr /*P*/>/*P*/ )null);
    DeclRefExpr /*P*/ PseudoSrcExpr = buildDeclRefExpr(/*Deref*/$this(), SrcVD, new QualType(Type), new SourceLocation(ELoc));
    VarDecl /*P*/ DstVD = buildVarDecl(/*Deref*/$this(), RefExpr.getLocStart(), new QualType(Type), new StringRef(/*KEEP_STR*/".copyprivate.dst"), 
        D.hasAttrs() ? $AddrOf(D.getAttrs()) : (SmallVector<Attr /*P*/>/*P*/ )null);
    DeclRefExpr /*P*/ PseudoDstExpr = buildDeclRefExpr(/*Deref*/$this(), DstVD, new QualType(Type), new SourceLocation(ELoc));
    ActionResultTTrue<Expr /*P*/ > AssignmentOp = $this().BuildBinOp(((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).getCurScope(), new SourceLocation(ELoc), BinaryOperatorKind.BO_Assign, 
        PseudoDstExpr, PseudoSrcExpr);
    if (AssignmentOp.isInvalid()) {
      continue;
    }
    AssignmentOp.$assignMove($this().ActOnFinishFullExpr(AssignmentOp.get(), new SourceLocation(ELoc), 
            /*DiscardedValue=*/ true));
    if (AssignmentOp.isInvalid()) {
      continue;
    }
    
    // No need to mark vars as copyprivate, they are already threadprivate or
    // implicitly private.
    assert ((VD != null) || ($this().IsOpenMPCapturedDecl(D) != null));
    Vars.push_back((VD != null) ? RefExpr.IgnoreParens() : buildCapture(/*Deref*/$this(), D, SimpleRefExpr.$deref(), /*WithInit=*/ false));
    SrcExprs.push_back(PseudoSrcExpr);
    DstExprs.push_back(PseudoDstExpr);
    AssignmentOps.push_back(AssignmentOp.get());
  }
  if (Vars.empty()) {
    return null;
  }
  
  return OMPCopyprivateClause.Create($this().Context, new SourceLocation(StartLoc), new SourceLocation(LParenLoc), new SourceLocation(EndLoc), 
      new ArrayRef<Expr /*P*/ >(Vars, true), new ArrayRef<Expr /*P*/ >(SrcExprs, true), new ArrayRef<Expr /*P*/ >(DstExprs, true), new ArrayRef<Expr /*P*/ >(AssignmentOps, true));
}

/// \brief Called on well-formed 'flush' pseudo clause.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnOpenMPFlushClause">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 10072,
 FQN="clang::Sema::ActOnOpenMPFlushClause", NM="_ZN5clang4Sema22ActOnOpenMPFlushClauseEN4llvm8ArrayRefIPNS_4ExprEEENS_14SourceLocationES6_S6_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4Sema22ActOnOpenMPFlushClauseEN4llvm8ArrayRefIPNS_4ExprEEENS_14SourceLocationES6_S6_")
//</editor-fold>
public final OMPClause /*P*/ ActOnOpenMPFlushClause(ArrayRef<Expr /*P*/ > VarList, 
                      SourceLocation StartLoc, 
                      SourceLocation LParenLoc, 
                      SourceLocation EndLoc) {
  if (VarList.empty()) {
    return null;
  }
  
  return OMPFlushClause.Create($this().Context, new SourceLocation(StartLoc), new SourceLocation(LParenLoc), new SourceLocation(EndLoc), new ArrayRef<Expr /*P*/ >(VarList));
}

/// \brief Called on well-formed 'depend' clause.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnOpenMPDependClause">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 10082,
 FQN="clang::Sema::ActOnOpenMPDependClause", NM="_ZN5clang4Sema23ActOnOpenMPDependClauseENS_22OpenMPDependClauseKindENS_14SourceLocationES2_N4llvm8ArrayRefIPNS_4ExprEEES2_S2_S2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4Sema23ActOnOpenMPDependClauseENS_22OpenMPDependClauseKindENS_14SourceLocationES2_N4llvm8ArrayRefIPNS_4ExprEEES2_S2_S2_")
//</editor-fold>
public final OMPClause /*P*/ ActOnOpenMPDependClause(OpenMPDependClauseKind DepKind, 
                       SourceLocation DepLoc, SourceLocation ColonLoc, 
                       ArrayRef<Expr /*P*/ > VarList, SourceLocation StartLoc, 
                       SourceLocation LParenLoc, SourceLocation EndLoc) {
  if (((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).getCurrentDirective() == OpenMPDirectiveKind.OMPD_ordered
     && DepKind != OpenMPDependClauseKind.OMPC_DEPEND_source && DepKind != OpenMPDependClauseKind.OMPC_DEPEND_sink) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(DepLoc), diag.err_omp_unexpected_clause_value)), 
              /*KEEP_STR*/"'source' or 'sink'"), getOpenMPClauseName(OpenMPClauseKind.OMPC_depend)));
      return null;
    } finally {
      $c$.$destroy();
    }
  }
  if (((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).getCurrentDirective() != OpenMPDirectiveKind.OMPD_ordered
     && (DepKind == OpenMPDependClauseKind.OMPC_DEPEND_unknown || DepKind == OpenMPDependClauseKind.OMPC_DEPEND_source
     || DepKind == OpenMPDependClauseKind.OMPC_DEPEND_sink)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      /*uint*/int Except[/*2*/] = new /*uint*/int [/*2*/] {OpenMPDependClauseKind.OMPC_DEPEND_source.getValue(), OpenMPDependClauseKind.OMPC_DEPEND_sink.getValue()};
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(DepLoc), diag.err_omp_unexpected_clause_value)), 
              getListOfPossibleValues(OpenMPClauseKind.OMPC_depend, /*First=*/ 0, 
                  /*Last=*/ OpenMPDependClauseKind.OMPC_DEPEND_unknown.getValue(), new ArrayRefUInt(Except))), 
          getOpenMPClauseName(OpenMPClauseKind.OMPC_depend)));
      return null;
    } finally {
      $c$.$destroy();
    }
  }
  SmallVector<Expr /*P*/ > Vars/*J*/= new SmallVector<Expr /*P*/ >(8, (Expr /*P*/ )null);
  SmallVector<std.pair<Expr /*P*/ , OverloadedOperatorKind>> OpsOffs/*J*/= new SmallVector<std.pair<Expr /*P*/ , OverloadedOperatorKind>>(4, new std.pairPtrType<Expr /*P*/ , OverloadedOperatorKind>(null, OverloadedOperatorKind.valueOf(0)));
  APSInt DepCounter/*J*/= new APSInt(/*BitWidth=*/ 32);
  APSInt TotalDepCount/*J*/= new APSInt(/*BitWidth=*/ 32);
  if (DepKind == OpenMPDependClauseKind.OMPC_DEPEND_sink) {
    {
      Expr /*P*/ OrderedCountExpr = ((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).getParentOrderedRegionParam();
      if ((OrderedCountExpr != null)) {
        TotalDepCount.$assignMove(OrderedCountExpr.EvaluateKnownConstInt($this().Context));
        TotalDepCount.setIsUnsigned(/*Val=*/ true);
      }
    }
  }
  if ((DepKind != OpenMPDependClauseKind.OMPC_DEPEND_sink && DepKind != OpenMPDependClauseKind.OMPC_DEPEND_source)
     || (((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).getParentOrderedRegionParam() != null)) {
    for (final Expr /*P*/ /*const*/ /*&*/ RefExpr : VarList) {
      assert ((RefExpr != null)) : "NULL expr in OpenMP shared clause.";
      if (isa_DependentScopeDeclRefExpr(RefExpr)) {
        // It will be analyzed later.
        Vars.push_back(RefExpr);
        continue;
      }
      
      SourceLocation ELoc = RefExpr.getExprLoc();
      Expr /*P*/ SimpleExpr = RefExpr.IgnoreParenCasts();
      if (DepKind == OpenMPDependClauseKind.OMPC_DEPEND_sink) {
        if (DepCounter.$greatereq(TotalDepCount)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track($this().Diag(new SourceLocation(ELoc), diag.err_omp_depend_sink_unexpected_expr)));
            continue;
          } finally {
            $c$.$destroy();
          }
        }
        DepCounter.$preInc();
        // OpenMP  [2.13.9, Summary]
        // depend(dependence-type : vec), where dependence-type is:
        // 'sink' and where vec is the iteration vector, which has the form:
        //  x1 [+- d1], x2 [+- d2 ], . . . , xn [+- dn]
        // where n is the value specified by the ordered clause in the loop
        // directive, xi denotes the loop iteration variable of the i-th nested
        // loop associated with the loop directive, and di is a constant
        // non-negative integer.
        if ($this().CurContext.isDependentContext()) {
          // It will be analyzed later.
          Vars.push_back(RefExpr);
          continue;
        }
        SimpleExpr = SimpleExpr.IgnoreImplicit();
        OverloadedOperatorKind OOK = OverloadedOperatorKind.OO_None;
        SourceLocation OOLoc/*J*/= new SourceLocation();
        type$ref<Expr /*P*/ > LHS = create_type$ref(SimpleExpr);
        Expr /*P*/ RHS = null;
        {
          BinaryOperator /*P*/ BO = dyn_cast_BinaryOperator(SimpleExpr);
          if ((BO != null)) {
            OOK = BinaryOperator.getOverloadedOperator(BO.getOpcode());
            OOLoc.$assignMove(BO.getOperatorLoc());
            LHS.$set(BO.getLHS().IgnoreParenImpCasts());
            RHS = BO.getRHS().IgnoreParenImpCasts();
          } else {
            CXXOperatorCallExpr /*P*/ OCE = dyn_cast_CXXOperatorCallExpr(SimpleExpr);
            if ((OCE != null)) {
              OOK = OCE.getOperator();
              OOLoc.$assignMove(OCE.getOperatorLoc());
              LHS.$set(OCE.getArg(/*Arg=*/ 0).IgnoreParenImpCasts());
              RHS = OCE.getArg(/*Arg=*/ 1).IgnoreParenImpCasts();
            } else {
              CXXMemberCallExpr /*P*/ MCE = dyn_cast_CXXMemberCallExpr(SimpleExpr);
              if ((MCE != null)) {
                OOK = MCE.getMethodDecl().
                    getNameInfo().
                    getName().
                    getCXXOverloadedOperator();
                OOLoc.$assignMove(MCE.getCallee().getExprLoc());
                LHS.$set(MCE.getImplicitObjectArgument().IgnoreParenImpCasts());
                RHS = MCE.getArg(/*Arg=*/ 0).IgnoreParenImpCasts();
              }
            }
          }
        }
        SourceLocation ELoc$1/*J*/= new SourceLocation();
        SourceRange ERange/*J*/= new SourceRange();
        std.pairTypeBool<ValueDecl /*P*/ > Res = getPrivateItem(/*Deref*/$this(), LHS, ELoc$1, ERange, 
            /*AllowArraySection=*/ false);
        if (Res.second) {
          // It will be analyzed later.
          Vars.push_back(RefExpr);
        }
        ValueDecl /*P*/ D = Res.first;
        if (!(D != null)) {
          continue;
        }
        if (OOK != OverloadedOperatorKind.OO_Plus && OOK != OverloadedOperatorKind.OO_Minus && ((RHS != null) || OOK != OverloadedOperatorKind.OO_None)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track($this().Diag(new SourceLocation(OOLoc), diag.err_omp_depend_sink_expected_plus_minus)));
            continue;
          } finally {
            $c$.$destroy();
          }
        }
        if ((RHS != null)) {
          ActionResultTTrue<Expr /*P*/ > RHSRes = $this().VerifyPositiveIntegerConstantInClause(RHS, OpenMPClauseKind.OMPC_depend, /*StrictlyPositive=*/ false);
          if (RHSRes.isInvalid()) {
            continue;
          }
        }
        if (!$this().CurContext.isDependentContext()
           && (((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).getParentOrderedRegionParam() != null)
           && DepCounter.$noteq($uint2long(((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).isParentLoopControlVariable(D).first))) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(ELoc$1), diag.err_omp_depend_sink_expected_loop_iteration)), 
                ((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).getParentLoopControlVariable($ulong2uint(DepCounter.getZExtValue()))));
            continue;
          } finally {
            $c$.$destroy();
          }
        }
        OpsOffs.push_back(/*{ */new std.pairPtrType<Expr /*P*/ , OverloadedOperatorKind>(JD$T$RR_T1$RR.INSTANCE, RHS, OOK)/* }*/);
      } else {
        // OpenMP  [2.11.1.1, Restrictions, p.3]
        //  A variable that is part of another variable (such as a field of a
        //  structure) but is not an array element or an array section cannot
        //  appear  in a depend clause.
        DeclRefExpr /*P*/ DE = dyn_cast_DeclRefExpr(SimpleExpr);
        ArraySubscriptExpr /*P*/ ASE = dyn_cast_ArraySubscriptExpr(SimpleExpr);
        OMPArraySectionExpr /*P*/ OASE = dyn_cast_OMPArraySectionExpr(SimpleExpr);
        if (!RefExpr.IgnoreParenImpCasts().isLValue()
           || (!(ASE != null) && !(DE != null) && !(OASE != null)) || ((DE != null) && !isa_VarDecl(DE.getDecl()))
           || ((ASE != null)
           && !ASE.getBase().
            getType().
            getNonReferenceType().$arrow().
            isPointerType()
           && !ASE.getBase().getType().getNonReferenceType().$arrow().isArrayType())) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(ELoc), diag.err_omp_expected_var_name_member_expr_or_array_item)), 
                    0), RefExpr.getSourceRange()));
            continue;
          } finally {
            $c$.$destroy();
          }
        }
      }
      Vars.push_back(RefExpr.IgnoreParenImpCasts());
    }
    if (!$this().CurContext.isDependentContext() && DepKind == OpenMPDependClauseKind.OMPC_DEPEND_sink
       && TotalDepCount.$greater($uint2long(VarList.size()))
       && (((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).getParentOrderedRegionParam() != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(EndLoc), diag.err_omp_depend_sink_expected_loop_iteration)), 
            ((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).getParentLoopControlVariable(VarList.size() + 1)));
      } finally {
        $c$.$destroy();
      }
    }
    if (DepKind != OpenMPDependClauseKind.OMPC_DEPEND_source && DepKind != OpenMPDependClauseKind.OMPC_DEPEND_sink
       && Vars.empty()) {
      return null;
    }
  }
  OMPDependClause /*P*/ C = OMPDependClause.Create($this().Context, new SourceLocation(StartLoc), new SourceLocation(LParenLoc), new SourceLocation(EndLoc), 
      DepKind, new SourceLocation(DepLoc), new SourceLocation(ColonLoc), new ArrayRef<Expr /*P*/ >(Vars, true));
  if (DepKind == OpenMPDependClauseKind.OMPC_DEPEND_sink || DepKind == OpenMPDependClauseKind.OMPC_DEPEND_source) {
    ((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).addDoacrossDependClause(C, OpsOffs);
  }
  return C;
}

/// \brief Called on well-formed 'device' clause.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnOpenMPDeviceClause">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 10240,
 FQN="clang::Sema::ActOnOpenMPDeviceClause", NM="_ZN5clang4Sema23ActOnOpenMPDeviceClauseEPNS_4ExprENS_14SourceLocationES3_S3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4Sema23ActOnOpenMPDeviceClauseEPNS_4ExprENS_14SourceLocationES3_S3_")
//</editor-fold>
public final OMPClause /*P*/ ActOnOpenMPDeviceClause(Expr /*P*/ Device, SourceLocation StartLoc, 
                       SourceLocation LParenLoc, 
                       SourceLocation EndLoc) {
  type$ref<Expr /*P*/ > ValExpr = create_type$ref(Device);
  
  // OpenMP [2.9.1, Restrictions]
  // The device expression must evaluate to a non-negative integer value.
  if (!IsNonNegativeIntegerValue(ValExpr, /*Deref*/$this(), OpenMPClauseKind.OMPC_device, 
      /*StrictlyPositive=*/ false)) {
    return null;
  }
  
  return /*FIXME:NEW_EXPR*//*new (Context)*/ new OMPDeviceClause(ValExpr.$deref(), new SourceLocation(StartLoc), new SourceLocation(LParenLoc), new SourceLocation(EndLoc));
}

/// \brief Called on well-formed 'map' clause.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnOpenMPMapClause">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 11003,
 FQN="clang::Sema::ActOnOpenMPMapClause", NM="_ZN5clang4Sema20ActOnOpenMPMapClauseENS_19OpenMPMapClauseKindES1_bNS_14SourceLocationES2_N4llvm8ArrayRefIPNS_4ExprEEES2_S2_S2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4Sema20ActOnOpenMPMapClauseENS_19OpenMPMapClauseKindES1_bNS_14SourceLocationES2_N4llvm8ArrayRefIPNS_4ExprEEES2_S2_S2_")
//</editor-fold>
public final OMPClause /*P*/ ActOnOpenMPMapClause(OpenMPMapClauseKind MapTypeModifier, 
                    OpenMPMapClauseKind MapType, boolean IsMapTypeImplicit, 
                    SourceLocation MapLoc, SourceLocation ColonLoc, 
                    ArrayRef<Expr /*P*/ > VarList, SourceLocation StartLoc, 
                    SourceLocation LParenLoc, SourceLocation EndLoc) {
  MappableVarListInfo MVLI = null;
  try {
    MVLI/*J*/= new MappableVarListInfo(new ArrayRef<Expr /*P*/ >(VarList));
    checkMappableExpressionList(/*Deref*/$this(), ((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)), OpenMPClauseKind.OMPC_map, MVLI, new SourceLocation(StartLoc), 
        MapType, IsMapTypeImplicit);
    
    // We need to produce a map clause even if we don't have variables so that
    // other diagnostics related with non-existing map clauses are accurate.
    return OMPMapClause.Create($this().Context, new SourceLocation(StartLoc), new SourceLocation(LParenLoc), new SourceLocation(EndLoc), 
        new ArrayRef<Expr /*P*/ >(MVLI.ProcessedVarList, true), new ArrayRef<ValueDecl /*P*/ >(MVLI.VarBaseDeclarations, true), 
        new ArrayRef<SmallVector<MappableComponent>>(MVLI.VarComponents, false), MapTypeModifier, MapType, 
        IsMapTypeImplicit, new SourceLocation(MapLoc));
  } finally {
    if (MVLI != null) { MVLI.$destroy(); }
  }
}

/// \brief Called on well-formed 'num_teams' clause.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnOpenMPNumTeamsClause">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 11258,
 FQN="clang::Sema::ActOnOpenMPNumTeamsClause", NM="_ZN5clang4Sema25ActOnOpenMPNumTeamsClauseEPNS_4ExprENS_14SourceLocationES3_S3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4Sema25ActOnOpenMPNumTeamsClauseEPNS_4ExprENS_14SourceLocationES3_S3_")
//</editor-fold>
public final OMPClause /*P*/ ActOnOpenMPNumTeamsClause(Expr /*P*/ NumTeams, 
                         SourceLocation StartLoc, 
                         SourceLocation LParenLoc, 
                         SourceLocation EndLoc) {
  type$ref<Expr /*P*/ > ValExpr = create_type$ref(NumTeams);
  
  // OpenMP [teams Constrcut, Restrictions]
  // The num_teams expression must evaluate to a positive integer value.
  if (!IsNonNegativeIntegerValue(ValExpr, /*Deref*/$this(), OpenMPClauseKind.OMPC_num_teams, 
      /*StrictlyPositive=*/ true)) {
    return null;
  }
  
  return /*FIXME:NEW_EXPR*//*new (Context)*/ new OMPNumTeamsClause(ValExpr.$deref(), new SourceLocation(StartLoc), new SourceLocation(LParenLoc), new SourceLocation(EndLoc));
}

/// \brief Called on well-formed 'thread_limit' clause.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnOpenMPThreadLimitClause">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 11273,
 FQN="clang::Sema::ActOnOpenMPThreadLimitClause", NM="_ZN5clang4Sema28ActOnOpenMPThreadLimitClauseEPNS_4ExprENS_14SourceLocationES3_S3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4Sema28ActOnOpenMPThreadLimitClauseEPNS_4ExprENS_14SourceLocationES3_S3_")
//</editor-fold>
public final OMPClause /*P*/ ActOnOpenMPThreadLimitClause(Expr /*P*/ ThreadLimit, 
                            SourceLocation StartLoc, 
                            SourceLocation LParenLoc, 
                            SourceLocation EndLoc) {
  type$ref<Expr /*P*/ > ValExpr = create_type$ref(ThreadLimit);
  
  // OpenMP [teams Constrcut, Restrictions]
  // The thread_limit expression must evaluate to a positive integer value.
  if (!IsNonNegativeIntegerValue(ValExpr, /*Deref*/$this(), OpenMPClauseKind.OMPC_thread_limit, 
      /*StrictlyPositive=*/ true)) {
    return null;
  }
  
  return /*FIXME:NEW_EXPR*//*new (Context)*/ new OMPThreadLimitClause(ValExpr.$deref(), new SourceLocation(StartLoc), new SourceLocation(LParenLoc), 
      new SourceLocation(EndLoc));
}

/// \brief Called on well-formed 'priority' clause.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnOpenMPPriorityClause">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 11289,
 FQN="clang::Sema::ActOnOpenMPPriorityClause", NM="_ZN5clang4Sema25ActOnOpenMPPriorityClauseEPNS_4ExprENS_14SourceLocationES3_S3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4Sema25ActOnOpenMPPriorityClauseEPNS_4ExprENS_14SourceLocationES3_S3_")
//</editor-fold>
public final OMPClause /*P*/ ActOnOpenMPPriorityClause(Expr /*P*/ Priority, 
                         SourceLocation StartLoc, 
                         SourceLocation LParenLoc, 
                         SourceLocation EndLoc) {
  type$ref<Expr /*P*/ > ValExpr = create_type$ref(Priority);
  
  // OpenMP [2.9.1, task Constrcut]
  // The priority-value is a non-negative numerical scalar expression.
  if (!IsNonNegativeIntegerValue(ValExpr, /*Deref*/$this(), OpenMPClauseKind.OMPC_priority, 
      /*StrictlyPositive=*/ false)) {
    return null;
  }
  
  return /*FIXME:NEW_EXPR*//*new (Context)*/ new OMPPriorityClause(ValExpr.$deref(), new SourceLocation(StartLoc), new SourceLocation(LParenLoc), new SourceLocation(EndLoc));
}

/// \brief Called on well-formed 'dist_schedule' clause.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnOpenMPDistScheduleClause">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 11349,
 FQN="clang::Sema::ActOnOpenMPDistScheduleClause", NM="_ZN5clang4Sema29ActOnOpenMPDistScheduleClauseENS_28OpenMPDistScheduleClauseKindEPNS_4ExprENS_14SourceLocationES4_S4_S4_S4_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4Sema29ActOnOpenMPDistScheduleClauseENS_28OpenMPDistScheduleClauseKindEPNS_4ExprENS_14SourceLocationES4_S4_S4_S4_")
//</editor-fold>
public final OMPClause /*P*/ ActOnOpenMPDistScheduleClause(/*OpenMPDistScheduleClauseKind*/int Kind, Expr /*P*/ ChunkSize, SourceLocation StartLoc, 
                             SourceLocation LParenLoc, SourceLocation KindLoc, SourceLocation CommaLoc, 
                             SourceLocation EndLoc) {
  if (Kind == OpenMPDistScheduleClauseKind.OMPC_DIST_SCHEDULE_unknown) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      std.string Values/*J*/= new std.string();
      Values.$addassign_T$C$P(/*KEEP_STR*/"'");
      Values.$addassign_T$C$P(getOpenMPSimpleClauseTypeName(OpenMPClauseKind.OMPC_dist_schedule, 0));
      Values.$addassign_T$C$P(/*KEEP_STR*/"'");
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(KindLoc), diag.err_omp_unexpected_clause_value)), 
              Values), getOpenMPClauseName(OpenMPClauseKind.OMPC_dist_schedule)));
      return null;
    } finally {
      $c$.$destroy();
    }
  }
  Expr /*P*/ ValExpr = ChunkSize;
  Stmt /*P*/ HelperValStmt = null;
  if ((ChunkSize != null)) {
    if (!ChunkSize.isValueDependent() && !ChunkSize.isTypeDependent()
       && !ChunkSize.isInstantiationDependent()
       && !ChunkSize.containsUnexpandedParameterPack()) {
      SourceLocation ChunkSizeLoc = ChunkSize.getLocStart();
      ActionResultTTrue<Expr /*P*/ > Val = $this().PerformOpenMPImplicitIntegerConversion(new SourceLocation(ChunkSizeLoc), ChunkSize);
      if (Val.isInvalid()) {
        return null;
      }
      
      ValExpr = Val.get();
      
      // OpenMP [2.7.1, Restrictions]
      //  chunk_size must be a loop invariant integer expression with a positive
      //  value.
      APSInt Result/*J*/= new APSInt();
      if (ValExpr.isIntegerConstantExpr(Result, $this().Context)) {
        if (Result.isSigned() && !Result.isStrictlyPositive()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(ChunkSizeLoc), diag.err_omp_negative_expression_in_clause)), 
                    /*KEEP_STR*/"dist_schedule"), ChunkSize.getSourceRange()));
            return null;
          } finally {
            $c$.$destroy();
          }
        }
      } else if (isParallelOrTaskRegion(((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)).getCurrentDirective())
         && !$this().CurContext.isDependentContext()) {
        MapVectorPtrPtr<Expr /*P*/ , DeclRefExpr /*P*/ > Captures = null;
        try {
          Captures/*J*/= new MapVectorPtrPtr<Expr /*P*/ , DeclRefExpr /*P*/ >(DenseMapInfo$LikePtr.$Info(), (DeclRefExpr/*P*/)null);
          ValExpr = tryBuildCapture(/*Deref*/$this(), ValExpr, Captures).get();
          HelperValStmt = buildPreInits($this().Context, Captures);
        } finally {
          if (Captures != null) { Captures.$destroy(); }
        }
      }
    }
  }
  
  return /*FIXME:NEW_EXPR*//*new (Context)*/ new OMPDistScheduleClause(new SourceLocation(StartLoc), new SourceLocation(LParenLoc), new SourceLocation(KindLoc), new SourceLocation(CommaLoc), new SourceLocation(EndLoc), 
      Kind, ValExpr, HelperValStmt);
}

/// \brief Called on well-formed 'defaultmap' clause.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnOpenMPDefaultmapClause">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 11400,
 FQN="clang::Sema::ActOnOpenMPDefaultmapClause", NM="_ZN5clang4Sema27ActOnOpenMPDefaultmapClauseENS_30OpenMPDefaultmapClauseModifierENS_26OpenMPDefaultmapClauseKindENS_14SourceLocationES3_S3_S3_S3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4Sema27ActOnOpenMPDefaultmapClauseENS_30OpenMPDefaultmapClauseModifierENS_26OpenMPDefaultmapClauseKindENS_14SourceLocationES3_S3_S3_S3_")
//</editor-fold>
public final OMPClause /*P*/ ActOnOpenMPDefaultmapClause(/*OpenMPDefaultmapClauseModifier*/int M, /*OpenMPDefaultmapClauseKind*/int Kind, 
                           SourceLocation StartLoc, SourceLocation LParenLoc, SourceLocation MLoc, 
                           SourceLocation KindLoc, SourceLocation EndLoc) {
  // OpenMP 4.5 only supports 'defaultmap(tofrom: scalar)'
  if (M != OpenMPDefaultmapClauseModifier.OMPC_DEFAULTMAP_MODIFIER_tofrom
     || Kind != OpenMPDefaultmapClauseKind.OMPC_DEFAULTMAP_scalar) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      std.string Value/*J*/= new std.string();
      SourceLocation Loc/*J*/= new SourceLocation();
      Value.$addassign_T$C$P(/*KEEP_STR*/"'");
      if (M != OpenMPDefaultmapClauseModifier.OMPC_DEFAULTMAP_MODIFIER_tofrom) {
        Value.$addassign_T$C$P(getOpenMPSimpleClauseTypeName(OpenMPClauseKind.OMPC_defaultmap, 
                OpenMPDefaultmapClauseModifier.OMPC_DEFAULTMAP_MODIFIER_tofrom));
        Loc.$assign(MLoc);
      } else {
        Value.$addassign_T$C$P(getOpenMPSimpleClauseTypeName(OpenMPClauseKind.OMPC_defaultmap, 
                OpenMPDefaultmapClauseKind.OMPC_DEFAULTMAP_scalar));
        Loc.$assign(KindLoc);
      }
      Value.$addassign_T$C$P(/*KEEP_STR*/"'");
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.err_omp_unexpected_clause_value)), 
              Value), getOpenMPClauseName(OpenMPClauseKind.OMPC_defaultmap)));
      return null;
    } finally {
      $c$.$destroy();
    }
  }
  
  return /*FIXME:NEW_EXPR*//*new (Context)*/ new OMPDefaultmapClause(new SourceLocation(StartLoc), new SourceLocation(LParenLoc), new SourceLocation(MLoc), new SourceLocation(KindLoc), new SourceLocation(EndLoc), Kind, M);
}

/// \brief Called on well-formed 'to' clause.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnOpenMPToClause">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 11623,
 FQN="clang::Sema::ActOnOpenMPToClause", NM="_ZN5clang4Sema19ActOnOpenMPToClauseEN4llvm8ArrayRefIPNS_4ExprEEENS_14SourceLocationES6_S6_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4Sema19ActOnOpenMPToClauseEN4llvm8ArrayRefIPNS_4ExprEEENS_14SourceLocationES6_S6_")
//</editor-fold>
public final OMPClause /*P*/ ActOnOpenMPToClause(ArrayRef<Expr /*P*/ > VarList, 
                   SourceLocation StartLoc, 
                   SourceLocation LParenLoc, 
                   SourceLocation EndLoc) {
  MappableVarListInfo MVLI = null;
  try {
    MVLI/*J*/= new MappableVarListInfo(new ArrayRef<Expr /*P*/ >(VarList));
    checkMappableExpressionList(/*Deref*/$this(), ((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)), OpenMPClauseKind.OMPC_to, MVLI, new SourceLocation(StartLoc));
    if (MVLI.ProcessedVarList.empty()) {
      return null;
    }
    
    return OMPToClause.Create($this().Context, new SourceLocation(StartLoc), new SourceLocation(LParenLoc), new SourceLocation(EndLoc), 
        new ArrayRef<Expr /*P*/ >(MVLI.ProcessedVarList, true), new ArrayRef<ValueDecl /*P*/ >(MVLI.VarBaseDeclarations, true), 
        new ArrayRef<SmallVector<MappableComponent>>(MVLI.VarComponents, false));
  } finally {
    if (MVLI != null) { MVLI.$destroy(); }
  }
}

/// \brief Called on well-formed 'from' clause.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnOpenMPFromClause">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 11637,
 FQN="clang::Sema::ActOnOpenMPFromClause", NM="_ZN5clang4Sema21ActOnOpenMPFromClauseEN4llvm8ArrayRefIPNS_4ExprEEENS_14SourceLocationES6_S6_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4Sema21ActOnOpenMPFromClauseEN4llvm8ArrayRefIPNS_4ExprEEENS_14SourceLocationES6_S6_")
//</editor-fold>
public final OMPClause /*P*/ ActOnOpenMPFromClause(ArrayRef<Expr /*P*/ > VarList, 
                     SourceLocation StartLoc, 
                     SourceLocation LParenLoc, 
                     SourceLocation EndLoc) {
  MappableVarListInfo MVLI = null;
  try {
    MVLI/*J*/= new MappableVarListInfo(new ArrayRef<Expr /*P*/ >(VarList));
    checkMappableExpressionList(/*Deref*/$this(), ((/*static_cast*/DSAStackTy /*P*/ )($this().VarDataSharingAttributesStack)), OpenMPClauseKind.OMPC_from, MVLI, new SourceLocation(StartLoc));
    if (MVLI.ProcessedVarList.empty()) {
      return null;
    }
    
    return OMPFromClause.Create($this().Context, new SourceLocation(StartLoc), new SourceLocation(LParenLoc), new SourceLocation(EndLoc), 
        new ArrayRef<Expr /*P*/ >(MVLI.ProcessedVarList, true), new ArrayRef<ValueDecl /*P*/ >(MVLI.VarBaseDeclarations, true), 
        new ArrayRef<SmallVector<MappableComponent>>(MVLI.VarComponents, false));
  } finally {
    if (MVLI != null) { MVLI.$destroy(); }
  }
}

/// Called on well-formed 'use_device_ptr' clause.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnOpenMPUseDevicePtrClause">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 11651,
 FQN="clang::Sema::ActOnOpenMPUseDevicePtrClause", NM="_ZN5clang4Sema29ActOnOpenMPUseDevicePtrClauseEN4llvm8ArrayRefIPNS_4ExprEEENS_14SourceLocationES6_S6_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4Sema29ActOnOpenMPUseDevicePtrClauseEN4llvm8ArrayRefIPNS_4ExprEEENS_14SourceLocationES6_S6_")
//</editor-fold>
public final OMPClause /*P*/ ActOnOpenMPUseDevicePtrClause(ArrayRef<Expr /*P*/ > VarList, 
                             SourceLocation StartLoc, 
                             SourceLocation LParenLoc, 
                             SourceLocation EndLoc) {
  SmallVector<Expr /*P*/ > Vars/*J*/= new SmallVector<Expr /*P*/ >(8, (Expr /*P*/ )null);
  for (final Expr /*P*/ /*const*/ /*&*/ RefExpr : VarList) {
    assert ((RefExpr != null)) : "NULL expr in OpenMP use_device_ptr clause.";
    SourceLocation ELoc/*J*/= new SourceLocation();
    SourceRange ERange/*J*/= new SourceRange();
    type$ref<Expr /*P*/ > SimpleRefExpr = create_type$ref(RefExpr);
    std.pairTypeBool<ValueDecl /*P*/ > Res = getPrivateItem(/*Deref*/$this(), SimpleRefExpr, ELoc, ERange);
    if (Res.second) {
      // It will be analyzed later.
      Vars.push_back(RefExpr);
    }
    ValueDecl /*P*/ D = Res.first;
    if (!(D != null)) {
      continue;
    }
    
    QualType Type = D.getType();
    // item should be a pointer or reference to pointer
    if (!Type.getNonReferenceType().$arrow().isPointerType()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(ELoc), diag.err_omp_usedeviceptr_not_a_pointer)), 
                0), RefExpr.getSourceRange()));
        continue;
      } finally {
        $c$.$destroy();
      }
    }
    Vars.push_back(RefExpr.IgnoreParens());
  }
  if (Vars.empty()) {
    return null;
  }
  
  return OMPUseDevicePtrClause.Create($this().Context, new SourceLocation(StartLoc), new SourceLocation(LParenLoc), new SourceLocation(EndLoc), 
      new ArrayRef<Expr /*P*/ >(Vars, true));
}

/// Called on well-formed 'is_device_ptr' clause.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnOpenMPIsDevicePtrClause">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 11687,
 FQN="clang::Sema::ActOnOpenMPIsDevicePtrClause", NM="_ZN5clang4Sema28ActOnOpenMPIsDevicePtrClauseEN4llvm8ArrayRefIPNS_4ExprEEENS_14SourceLocationES6_S6_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN5clang4Sema28ActOnOpenMPIsDevicePtrClauseEN4llvm8ArrayRefIPNS_4ExprEEENS_14SourceLocationES6_S6_")
//</editor-fold>
public final OMPClause /*P*/ ActOnOpenMPIsDevicePtrClause(ArrayRef<Expr /*P*/ > VarList, 
                            SourceLocation StartLoc, 
                            SourceLocation LParenLoc, 
                            SourceLocation EndLoc) {
  SmallVector<Expr /*P*/ > Vars/*J*/= new SmallVector<Expr /*P*/ >(8, (Expr /*P*/ )null);
  for (final Expr /*P*/ /*const*/ /*&*/ RefExpr : VarList) {
    assert ((RefExpr != null)) : "NULL expr in OpenMP use_device_ptr clause.";
    SourceLocation ELoc/*J*/= new SourceLocation();
    SourceRange ERange/*J*/= new SourceRange();
    type$ref<Expr /*P*/ > SimpleRefExpr = create_type$ref(RefExpr);
    std.pairTypeBool<ValueDecl /*P*/ > Res = getPrivateItem(/*Deref*/$this(), SimpleRefExpr, ELoc, ERange);
    if (Res.second) {
      // It will be analyzed later.
      Vars.push_back(RefExpr);
    }
    ValueDecl /*P*/ D = Res.first;
    if (!(D != null)) {
      continue;
    }
    
    QualType Type = D.getType();
    // item should be a pointer or array or reference to pointer or array
    if (!Type.getNonReferenceType().$arrow().isPointerType()
       && !Type.getNonReferenceType().$arrow().isArrayType()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(ELoc), diag.err_omp_argument_type_isdeviceptr)), 
                0), RefExpr.getSourceRange()));
        continue;
      } finally {
        $c$.$destroy();
      }
    }
    Vars.push_back(RefExpr.IgnoreParens());
  }
  if (Vars.empty()) {
    return null;
  }
  
  return OMPIsDevicePtrClause.Create($this().Context, new SourceLocation(StartLoc), new SourceLocation(LParenLoc), new SourceLocation(EndLoc), 
      new ArrayRef<Expr /*P*/ >(Vars, true));
}

} // END OF class Sema_SemaOpenMP
