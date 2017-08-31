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

package org.clang.ast;

import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Casts.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import org.clang.ast.impl.*;
import org.clang.ast.comments.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.java.AstStatementsRTTI.*;
import static org.clang.ast.impl.StmtStatics.*;
import org.llvm.adt.java.TrailingObjectsUtils;
import static org.llvm.support.AdtsupportLlvmGlobals.ViewGraph;


//===----------------------------------------------------------------------===//
// AST classes for statements.
//===----------------------------------------------------------------------===//

/// Stmt - This represents one statement.
///
//<editor-fold defaultstate="collapsed" desc="clang::Stmt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 59,
 FQN="clang::Stmt", NM="_ZN5clang4StmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang4StmtE")
//</editor-fold>
public class Stmt {
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  protected Stmt() {}  
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  public /*virtual*/ void $destroy() {}

  
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::Stmt::StmtClass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 61,
   FQN="clang::Stmt::StmtClass", NM="_ZN5clang4Stmt9StmtClassE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang4Stmt9StmtClassE")
  //</editor-fold>
  public enum StmtClass implements Native.ComparableLower {
    NoStmtClass(0),
    GCCAsmStmtClass(NoStmtClass.getValue() + 1),
    MSAsmStmtClass(GCCAsmStmtClass.getValue() + 1),
    firstAsmStmtConstant(StmtClass.GCCAsmStmtClass.getValue()),
    lastAsmStmtConstant(StmtClass.MSAsmStmtClass.getValue()),
    AttributedStmtClass(lastAsmStmtConstant.getValue() + 1),
    BreakStmtClass(AttributedStmtClass.getValue() + 1),
    CXXCatchStmtClass(BreakStmtClass.getValue() + 1),
    CXXForRangeStmtClass(CXXCatchStmtClass.getValue() + 1),
    CXXTryStmtClass(CXXForRangeStmtClass.getValue() + 1),
    CapturedStmtClass(CXXTryStmtClass.getValue() + 1),
    CompoundStmtClass(CapturedStmtClass.getValue() + 1),
    ContinueStmtClass(CompoundStmtClass.getValue() + 1),
    CoreturnStmtClass(ContinueStmtClass.getValue() + 1),
    CoroutineBodyStmtClass(CoreturnStmtClass.getValue() + 1),
    DeclStmtClass(CoroutineBodyStmtClass.getValue() + 1),
    DoStmtClass(DeclStmtClass.getValue() + 1),
    BinaryConditionalOperatorClass(DoStmtClass.getValue() + 1),
    ConditionalOperatorClass(BinaryConditionalOperatorClass.getValue() + 1),
    firstAbstractConditionalOperatorConstant(StmtClass.BinaryConditionalOperatorClass.getValue()),
    lastAbstractConditionalOperatorConstant(StmtClass.ConditionalOperatorClass.getValue()),
    AddrLabelExprClass(lastAbstractConditionalOperatorConstant.getValue() + 1),
    ArraySubscriptExprClass(AddrLabelExprClass.getValue() + 1),
    ArrayTypeTraitExprClass(ArraySubscriptExprClass.getValue() + 1),
    AsTypeExprClass(ArrayTypeTraitExprClass.getValue() + 1),
    AtomicExprClass(AsTypeExprClass.getValue() + 1),
    BinaryOperatorClass(AtomicExprClass.getValue() + 1),
    CompoundAssignOperatorClass(BinaryOperatorClass.getValue() + 1),
    firstBinaryOperatorConstant(StmtClass.BinaryOperatorClass.getValue()),
    lastBinaryOperatorConstant(StmtClass.CompoundAssignOperatorClass.getValue()),
    BlockExprClass(lastBinaryOperatorConstant.getValue() + 1),
    CXXBindTemporaryExprClass(BlockExprClass.getValue() + 1),
    CXXBoolLiteralExprClass(CXXBindTemporaryExprClass.getValue() + 1),
    CXXConstructExprClass(CXXBoolLiteralExprClass.getValue() + 1),
    CXXTemporaryObjectExprClass(CXXConstructExprClass.getValue() + 1),
    firstCXXConstructExprConstant(StmtClass.CXXConstructExprClass.getValue()),
    lastCXXConstructExprConstant(StmtClass.CXXTemporaryObjectExprClass.getValue()),
    CXXDefaultArgExprClass(lastCXXConstructExprConstant.getValue() + 1),
    CXXDefaultInitExprClass(CXXDefaultArgExprClass.getValue() + 1),
    CXXDeleteExprClass(CXXDefaultInitExprClass.getValue() + 1),
    CXXDependentScopeMemberExprClass(CXXDeleteExprClass.getValue() + 1),
    CXXFoldExprClass(CXXDependentScopeMemberExprClass.getValue() + 1),
    CXXInheritedCtorInitExprClass(CXXFoldExprClass.getValue() + 1),
    CXXNewExprClass(CXXInheritedCtorInitExprClass.getValue() + 1),
    CXXNoexceptExprClass(CXXNewExprClass.getValue() + 1),
    CXXNullPtrLiteralExprClass(CXXNoexceptExprClass.getValue() + 1),
    CXXPseudoDestructorExprClass(CXXNullPtrLiteralExprClass.getValue() + 1),
    CXXScalarValueInitExprClass(CXXPseudoDestructorExprClass.getValue() + 1),
    CXXStdInitializerListExprClass(CXXScalarValueInitExprClass.getValue() + 1),
    CXXThisExprClass(CXXStdInitializerListExprClass.getValue() + 1),
    CXXThrowExprClass(CXXThisExprClass.getValue() + 1),
    CXXTypeidExprClass(CXXThrowExprClass.getValue() + 1),
    CXXUnresolvedConstructExprClass(CXXTypeidExprClass.getValue() + 1),
    CXXUuidofExprClass(CXXUnresolvedConstructExprClass.getValue() + 1),
    CallExprClass(CXXUuidofExprClass.getValue() + 1),
    CUDAKernelCallExprClass(CallExprClass.getValue() + 1),
    CXXMemberCallExprClass(CUDAKernelCallExprClass.getValue() + 1),
    CXXOperatorCallExprClass(CXXMemberCallExprClass.getValue() + 1),
    UserDefinedLiteralClass(CXXOperatorCallExprClass.getValue() + 1),
    firstCallExprConstant(StmtClass.CallExprClass.getValue()),
    lastCallExprConstant(StmtClass.UserDefinedLiteralClass.getValue()),
    CStyleCastExprClass(lastCallExprConstant.getValue() + 1),
    CXXFunctionalCastExprClass(CStyleCastExprClass.getValue() + 1),
    CXXConstCastExprClass(CXXFunctionalCastExprClass.getValue() + 1),
    CXXDynamicCastExprClass(CXXConstCastExprClass.getValue() + 1),
    CXXReinterpretCastExprClass(CXXDynamicCastExprClass.getValue() + 1),
    CXXStaticCastExprClass(CXXReinterpretCastExprClass.getValue() + 1),
    firstCXXNamedCastExprConstant(StmtClass.CXXConstCastExprClass.getValue()),
    lastCXXNamedCastExprConstant(StmtClass.CXXStaticCastExprClass.getValue()),
    ObjCBridgedCastExprClass(lastCXXNamedCastExprConstant.getValue() + 1),
    firstExplicitCastExprConstant(StmtClass.CStyleCastExprClass.getValue()),
    lastExplicitCastExprConstant(StmtClass.ObjCBridgedCastExprClass.getValue()),
    ImplicitCastExprClass(lastExplicitCastExprConstant.getValue() + 1),
    firstCastExprConstant(StmtClass.CStyleCastExprClass.getValue()),
    lastCastExprConstant(StmtClass.ImplicitCastExprClass.getValue()),
    CharacterLiteralClass(lastCastExprConstant.getValue() + 1),
    ChooseExprClass(CharacterLiteralClass.getValue() + 1),
    CompoundLiteralExprClass(ChooseExprClass.getValue() + 1),
    ConvertVectorExprClass(CompoundLiteralExprClass.getValue() + 1),
    CoawaitExprClass(ConvertVectorExprClass.getValue() + 1),
    CoyieldExprClass(CoawaitExprClass.getValue() + 1),
    firstCoroutineSuspendExprConstant(StmtClass.CoawaitExprClass.getValue()),
    lastCoroutineSuspendExprConstant(StmtClass.CoyieldExprClass.getValue()),
    DeclRefExprClass(lastCoroutineSuspendExprConstant.getValue() + 1),
    DependentScopeDeclRefExprClass(DeclRefExprClass.getValue() + 1),
    DesignatedInitExprClass(DependentScopeDeclRefExprClass.getValue() + 1),
    DesignatedInitUpdateExprClass(DesignatedInitExprClass.getValue() + 1),
    ExprWithCleanupsClass(DesignatedInitUpdateExprClass.getValue() + 1),
    ExpressionTraitExprClass(ExprWithCleanupsClass.getValue() + 1),
    ExtVectorElementExprClass(ExpressionTraitExprClass.getValue() + 1),
    FloatingLiteralClass(ExtVectorElementExprClass.getValue() + 1),
    FunctionParmPackExprClass(FloatingLiteralClass.getValue() + 1),
    GNUNullExprClass(FunctionParmPackExprClass.getValue() + 1),
    GenericSelectionExprClass(GNUNullExprClass.getValue() + 1),
    ImaginaryLiteralClass(GenericSelectionExprClass.getValue() + 1),
    ImplicitValueInitExprClass(ImaginaryLiteralClass.getValue() + 1),
    InitListExprClass(ImplicitValueInitExprClass.getValue() + 1),
    IntegerLiteralClass(InitListExprClass.getValue() + 1),
    LambdaExprClass(IntegerLiteralClass.getValue() + 1),
    MSPropertyRefExprClass(LambdaExprClass.getValue() + 1),
    MSPropertySubscriptExprClass(MSPropertyRefExprClass.getValue() + 1),
    MaterializeTemporaryExprClass(MSPropertySubscriptExprClass.getValue() + 1),
    MemberExprClass(MaterializeTemporaryExprClass.getValue() + 1),
    NoInitExprClass(MemberExprClass.getValue() + 1),
    OMPArraySectionExprClass(NoInitExprClass.getValue() + 1),
    ObjCArrayLiteralClass(OMPArraySectionExprClass.getValue() + 1),
    ObjCAvailabilityCheckExprClass(ObjCArrayLiteralClass.getValue() + 1),
    ObjCBoolLiteralExprClass(ObjCAvailabilityCheckExprClass.getValue() + 1),
    ObjCBoxedExprClass(ObjCBoolLiteralExprClass.getValue() + 1),
    ObjCDictionaryLiteralClass(ObjCBoxedExprClass.getValue() + 1),
    ObjCEncodeExprClass(ObjCDictionaryLiteralClass.getValue() + 1),
    ObjCIndirectCopyRestoreExprClass(ObjCEncodeExprClass.getValue() + 1),
    ObjCIsaExprClass(ObjCIndirectCopyRestoreExprClass.getValue() + 1),
    ObjCIvarRefExprClass(ObjCIsaExprClass.getValue() + 1),
    ObjCMessageExprClass(ObjCIvarRefExprClass.getValue() + 1),
    ObjCPropertyRefExprClass(ObjCMessageExprClass.getValue() + 1),
    ObjCProtocolExprClass(ObjCPropertyRefExprClass.getValue() + 1),
    ObjCSelectorExprClass(ObjCProtocolExprClass.getValue() + 1),
    ObjCStringLiteralClass(ObjCSelectorExprClass.getValue() + 1),
    ObjCSubscriptRefExprClass(ObjCStringLiteralClass.getValue() + 1),
    OffsetOfExprClass(ObjCSubscriptRefExprClass.getValue() + 1),
    OpaqueValueExprClass(OffsetOfExprClass.getValue() + 1),
    UnresolvedLookupExprClass(OpaqueValueExprClass.getValue() + 1),
    UnresolvedMemberExprClass(UnresolvedLookupExprClass.getValue() + 1),
    firstOverloadExprConstant(StmtClass.UnresolvedLookupExprClass.getValue()),
    lastOverloadExprConstant(StmtClass.UnresolvedMemberExprClass.getValue()),
    PackExpansionExprClass(lastOverloadExprConstant.getValue() + 1),
    ParenExprClass(PackExpansionExprClass.getValue() + 1),
    ParenListExprClass(ParenExprClass.getValue() + 1),
    PredefinedExprClass(ParenListExprClass.getValue() + 1),
    PseudoObjectExprClass(PredefinedExprClass.getValue() + 1),
    ShuffleVectorExprClass(PseudoObjectExprClass.getValue() + 1),
    SizeOfPackExprClass(ShuffleVectorExprClass.getValue() + 1),
    StmtExprClass(SizeOfPackExprClass.getValue() + 1),
    StringLiteralClass(StmtExprClass.getValue() + 1),
    SubstNonTypeTemplateParmExprClass(StringLiteralClass.getValue() + 1),
    SubstNonTypeTemplateParmPackExprClass(SubstNonTypeTemplateParmExprClass.getValue() + 1),
    TypeTraitExprClass(SubstNonTypeTemplateParmPackExprClass.getValue() + 1),
    TypoExprClass(TypeTraitExprClass.getValue() + 1),
    UnaryExprOrTypeTraitExprClass(TypoExprClass.getValue() + 1),
    UnaryOperatorClass(UnaryExprOrTypeTraitExprClass.getValue() + 1),
    VAArgExprClass(UnaryOperatorClass.getValue() + 1),
    firstExprConstant(StmtClass.BinaryConditionalOperatorClass.getValue()),
    lastExprConstant(StmtClass.VAArgExprClass.getValue()),
    ForStmtClass(lastExprConstant.getValue() + 1),
    GotoStmtClass(ForStmtClass.getValue() + 1),
    IfStmtClass(GotoStmtClass.getValue() + 1),
    IndirectGotoStmtClass(IfStmtClass.getValue() + 1),
    LabelStmtClass(IndirectGotoStmtClass.getValue() + 1),
    MSDependentExistsStmtClass(LabelStmtClass.getValue() + 1),
    NullStmtClass(MSDependentExistsStmtClass.getValue() + 1),
    OMPAtomicDirectiveClass(NullStmtClass.getValue() + 1),
    OMPBarrierDirectiveClass(OMPAtomicDirectiveClass.getValue() + 1),
    OMPCancelDirectiveClass(OMPBarrierDirectiveClass.getValue() + 1),
    OMPCancellationPointDirectiveClass(OMPCancelDirectiveClass.getValue() + 1),
    OMPCriticalDirectiveClass(OMPCancellationPointDirectiveClass.getValue() + 1),
    OMPFlushDirectiveClass(OMPCriticalDirectiveClass.getValue() + 1),
    OMPDistributeDirectiveClass(OMPFlushDirectiveClass.getValue() + 1),
    OMPDistributeParallelForDirectiveClass(OMPDistributeDirectiveClass.getValue() + 1),
    OMPDistributeParallelForSimdDirectiveClass(OMPDistributeParallelForDirectiveClass.getValue() + 1),
    OMPDistributeSimdDirectiveClass(OMPDistributeParallelForSimdDirectiveClass.getValue() + 1),
    OMPForDirectiveClass(OMPDistributeSimdDirectiveClass.getValue() + 1),
    OMPForSimdDirectiveClass(OMPForDirectiveClass.getValue() + 1),
    OMPParallelForDirectiveClass(OMPForSimdDirectiveClass.getValue() + 1),
    OMPParallelForSimdDirectiveClass(OMPParallelForDirectiveClass.getValue() + 1),
    OMPSimdDirectiveClass(OMPParallelForSimdDirectiveClass.getValue() + 1),
    OMPTargetParallelForSimdDirectiveClass(OMPSimdDirectiveClass.getValue() + 1),
    OMPTaskLoopDirectiveClass(OMPTargetParallelForSimdDirectiveClass.getValue() + 1),
    OMPTaskLoopSimdDirectiveClass(OMPTaskLoopDirectiveClass.getValue() + 1),
    firstOMPLoopDirectiveConstant(StmtClass.OMPDistributeDirectiveClass.getValue()),
    lastOMPLoopDirectiveConstant(StmtClass.OMPTaskLoopSimdDirectiveClass.getValue()),
    OMPMasterDirectiveClass(lastOMPLoopDirectiveConstant.getValue() + 1),
    OMPOrderedDirectiveClass(OMPMasterDirectiveClass.getValue() + 1),
    OMPParallelDirectiveClass(OMPOrderedDirectiveClass.getValue() + 1),
    OMPParallelSectionsDirectiveClass(OMPParallelDirectiveClass.getValue() + 1),
    OMPSectionDirectiveClass(OMPParallelSectionsDirectiveClass.getValue() + 1),
    OMPSectionsDirectiveClass(OMPSectionDirectiveClass.getValue() + 1),
    OMPSingleDirectiveClass(OMPSectionsDirectiveClass.getValue() + 1),
    OMPTargetDataDirectiveClass(OMPSingleDirectiveClass.getValue() + 1),
    OMPTargetDirectiveClass(OMPTargetDataDirectiveClass.getValue() + 1),
    OMPTargetEnterDataDirectiveClass(OMPTargetDirectiveClass.getValue() + 1),
    OMPTargetExitDataDirectiveClass(OMPTargetEnterDataDirectiveClass.getValue() + 1),
    OMPTargetParallelDirectiveClass(OMPTargetExitDataDirectiveClass.getValue() + 1),
    OMPTargetParallelForDirectiveClass(OMPTargetParallelDirectiveClass.getValue() + 1),
    OMPTargetUpdateDirectiveClass(OMPTargetParallelForDirectiveClass.getValue() + 1),
    OMPTaskDirectiveClass(OMPTargetUpdateDirectiveClass.getValue() + 1),
    OMPTaskgroupDirectiveClass(OMPTaskDirectiveClass.getValue() + 1),
    OMPTaskwaitDirectiveClass(OMPTaskgroupDirectiveClass.getValue() + 1),
    OMPTaskyieldDirectiveClass(OMPTaskwaitDirectiveClass.getValue() + 1),
    OMPTeamsDirectiveClass(OMPTaskyieldDirectiveClass.getValue() + 1),
    firstOMPExecutableDirectiveConstant(StmtClass.OMPAtomicDirectiveClass.getValue()),
    lastOMPExecutableDirectiveConstant(StmtClass.OMPTeamsDirectiveClass.getValue()),
    ObjCAtCatchStmtClass(lastOMPExecutableDirectiveConstant.getValue() + 1),
    ObjCAtFinallyStmtClass(ObjCAtCatchStmtClass.getValue() + 1),
    ObjCAtSynchronizedStmtClass(ObjCAtFinallyStmtClass.getValue() + 1),
    ObjCAtThrowStmtClass(ObjCAtSynchronizedStmtClass.getValue() + 1),
    ObjCAtTryStmtClass(ObjCAtThrowStmtClass.getValue() + 1),
    ObjCAutoreleasePoolStmtClass(ObjCAtTryStmtClass.getValue() + 1),
    ObjCForCollectionStmtClass(ObjCAutoreleasePoolStmtClass.getValue() + 1),
    ReturnStmtClass(ObjCForCollectionStmtClass.getValue() + 1),
    SEHExceptStmtClass(ReturnStmtClass.getValue() + 1),
    SEHFinallyStmtClass(SEHExceptStmtClass.getValue() + 1),
    SEHLeaveStmtClass(SEHFinallyStmtClass.getValue() + 1),
    SEHTryStmtClass(SEHLeaveStmtClass.getValue() + 1),
    CaseStmtClass(SEHTryStmtClass.getValue() + 1),
    DefaultStmtClass(CaseStmtClass.getValue() + 1),
    firstSwitchCaseConstant(StmtClass.CaseStmtClass.getValue()),
    lastSwitchCaseConstant(StmtClass.DefaultStmtClass.getValue()),
    SwitchStmtClass(lastSwitchCaseConstant.getValue() + 1),
    WhileStmtClass(SwitchStmtClass.getValue() + 1),
    firstStmtConstant(StmtClass.GCCAsmStmtClass.getValue()),
    lastStmtConstant(StmtClass.WhileStmtClass.getValue());

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static StmtClass valueOf(int val) {
      StmtClass out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final StmtClass[] VALUES;
      private static final StmtClass[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (StmtClass kind : StmtClass.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new StmtClass[min < 0 ? (1-min) : 0];
        VALUES = new StmtClass[max >= 0 ? (1+max) : 0];
        for (StmtClass kind : StmtClass.values()) {
          if (kind.value < 0) {
            if (_VALUES[-kind.value] == null) {
              _VALUES[-kind.value] = kind;
            } else {
              assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          } else {
            if (VALUES[kind.value] == null) {
              VALUES[kind.value] = kind;
            } else {
              assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          }
        }
      }
    }

    private final /*uint*/int value;
    private StmtClass(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((StmtClass)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((StmtClass)obj).value);}
    //</editor-fold>
  };

  // Make vanilla 'new' and 'delete' illegal for Stmts.
  /*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::Stmt::operator new">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 74,
   FQN="clang::Stmt::operator new", NM="_ZN5clang4StmtnwEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang4StmtnwEj")
  //</editor-fold>
  protected static Object/*void P*/ $new(/*size_t*/int bytes) {
    throw new llvm_unreachable("Stmts cannot be allocated with regular 'new'.");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Stmt::operator delete">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 77,
   FQN="clang::Stmt::operator delete", NM="_ZN5clang4StmtdlEPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang4StmtdlEPv")
  //</editor-fold>
  protected static void $delete(Object/*void P*/ data) {
    throw new llvm_unreachable("Stmts cannot be released with regular 'delete'.");
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Stmt::StmtBitfields">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 81,
   FQN="clang::Stmt::StmtBitfields", NM="_ZN5clang4Stmt13StmtBitfieldsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang4Stmt13StmtBitfieldsE")
  //</editor-fold>
  protected static class StmtBitfields {
    /*friend  class Stmt*/
    
    /// \brief The statement class.
    private /*JBYTE unsigned int*/ byte sClass /*: 8*/;
    
    @Override public String toString() {
      return "" + "sClass=" + $uchar2uint(sClass); // NOI18N
    }
  };
  //<editor-fold defaultstate="collapsed" desc="clang::Stmt::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 87,
   FQN="clang::Stmt::(anonymous)", NM="_ZN5clang4StmtE_Unnamed_enum1",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang4StmtE_Unnamed_enum1")
  //</editor-fold>
  /*enum ANONYMOUS_INT_CONSTANTS {*/
    public static final /*uint*/int NumStmtBits = 8;
  /*}*/;
  
  //<editor-fold defaultstate="collapsed" desc="clang::Stmt::CompoundStmtBitfields">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 89,
   FQN="clang::Stmt::CompoundStmtBitfields", NM="_ZN5clang4Stmt21CompoundStmtBitfieldsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang4Stmt21CompoundStmtBitfieldsE")
  //</editor-fold>
  protected static class CompoundStmtBitfields {
    /*friend  class CompoundStmt*/
    private /*JBYTE unsigned int*/ byte Unnamed_field /*: NumStmtBits*/;
    
    protected/*private*/ /*uint*/int NumStmts /*: 32 - NumStmtBits*/;
    
    @Override public String toString() {
      return "" + "Unnamed_field=" + $uchar2uint(Unnamed_field) // NOI18N
                + ", NumStmts=" + NumStmts; // NOI18N
    }
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::Stmt::IfStmtBitfields">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 96,
   FQN="clang::Stmt::IfStmtBitfields", NM="_ZN5clang4Stmt15IfStmtBitfieldsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang4Stmt15IfStmtBitfieldsE")
  //</editor-fold>
  protected static class IfStmtBitfields {
    /*friend  class IfStmt*/
    private /*JBYTE unsigned int*/ byte Unnamed_field /*: NumStmtBits*/;
    
    protected/*private*/ /*JBIT unsigned int*/ boolean IsConstexpr /*: 1*/;
    
    @Override public String toString() {
      return "" + "Unnamed_field=" + $uchar2uint(Unnamed_field) // NOI18N
                + ", IsConstexpr=" + IsConstexpr; // NOI18N
    }
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::Stmt::ExprBitfields">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 103,
   FQN="clang::Stmt::ExprBitfields", NM="_ZN5clang4Stmt13ExprBitfieldsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang4Stmt13ExprBitfieldsE")
  //</editor-fold>
  /*friend*/public static class ExprBitfields {
    /*friend  class Expr*/
    /*friend  class DeclRefExpr*/ // computeDependence
    /*friend  class InitListExpr*/ // ctor
    /*friend  class DesignatedInitExpr*/ // ctor
    /*friend  class BlockDeclRefExpr*/ // ctor
    /*friend  class ASTStmtReader*/ // deserialization
    /*friend  class CXXNewExpr*/ // ctor
    /*friend  class DependentScopeDeclRefExpr*/ // ctor
    /*friend  class CXXConstructExpr*/ // ctor
    /*friend  class CallExpr*/ // ctor
    /*friend  class OffsetOfExpr*/ // ctor
    /*friend  class ObjCMessageExpr*/ // ctor
    /*friend  class ObjCArrayLiteral*/ // ctor
    /*friend  class ObjCDictionaryLiteral*/ // ctor
    /*friend  class ShuffleVectorExpr*/ // ctor
    /*friend  class ParenListExpr*/ // ctor
    /*friend  class CXXUnresolvedConstructExpr*/ // ctor
    /*friend  class CXXDependentScopeMemberExpr*/ // ctor
    /*friend  class OverloadExpr*/ // ctor
    /*friend  class PseudoObjectExpr*/ // ctor
    /*friend  class AtomicExpr*/ // ctor
    /*friend  class OpaqueValueExpr*/ // ctor
    private /*JBYTE unsigned int*/ byte Unnamed_field /*: NumStmtBits*/;
    
    protected/*private*/ /*JBYTE unsigned int*/ byte ValueKind /*: 2*/;
    protected/*private*/ /*JBYTE unsigned int*/ byte ObjectKind /*: 3*/; // JAVA FIX: must be 3 to fit
    protected/*private*/ /*JBIT unsigned int*/ boolean TypeDependent /*: 1*/;
    protected/*private*/ /*JBIT unsigned int*/ boolean ValueDependent /*: 1*/;
    protected/*private*/ /*JBIT unsigned int*/ boolean InstantiationDependent /*: 1*/;
    /*friend*/public/*private*/ /*JBIT unsigned int*/ boolean ContainsUnexpandedParameterPack /*: 1*/;
    
    @Override public String toString() {
      return "" + "Unnamed_field=" + $uchar2uint(Unnamed_field) // NOI18N
                + ", ValueKind=" + ExprValueKind.valueOf($uchar2uint(ValueKind)) // NOI18N
                + ", ObjectKind=" + ExprObjectKind.valueOf($uchar2uint(ObjectKind)) // NOI18N
                + ", TypeDependent=" + TypeDependent // NOI18N
                + ", ValueDependent=" + ValueDependent // NOI18N
                + ", InstantiationDependent=" + InstantiationDependent // NOI18N
                + ", ContainsUnexpandedParameterPack=" + ContainsUnexpandedParameterPack; // NOI18N
    }
  };
  //<editor-fold defaultstate="collapsed" desc="clang::Stmt::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 135,
   FQN="clang::Stmt::(anonymous)", NM="_ZN5clang4StmtE_Unnamed_enum2",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang4StmtE_Unnamed_enum2")
  //</editor-fold>
  /*enum ANONYMOUS_INT_CONSTANTS {*/
    public static final /*uint*/int NumExprBits = 17;
  /*}*/;
  
  //<editor-fold defaultstate="collapsed" desc="clang::Stmt::CharacterLiteralBitfields">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 137,
   FQN="clang::Stmt::CharacterLiteralBitfields", NM="_ZN5clang4Stmt25CharacterLiteralBitfieldsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang4Stmt25CharacterLiteralBitfieldsE")
  //</editor-fold>
  protected static class CharacterLiteralBitfields {
    /*friend  class CharacterLiteral*/
    private /*JCHAR unsigned int*/ char Unnamed_field /*: NumExprBits*/;
    
    protected/*friend*//*private*/ /*JBYTE unsigned int*/ byte Kind /*: 3*/;
    
    @Override public String toString() {
      return "" + "Unnamed_field=" + $ushort2uint(Unnamed_field) // NOI18N
                + ", Kind=" + CharacterLiteral.CharacterKind.valueOf($uchar2uint(Kind)); // NOI18N
    }
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::Stmt::APFloatSemantics">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 144,
   FQN="clang::Stmt::APFloatSemantics", NM="_ZN5clang4Stmt16APFloatSemanticsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang4Stmt16APFloatSemanticsE")
  //</editor-fold>
  /*friend*/public enum APFloatSemantics implements Native.ComparableLower {
    IEEEhalf(0),
    IEEEsingle(IEEEhalf.getValue() + 1),
    IEEEdouble(IEEEsingle.getValue() + 1),
    x87DoubleExtended(IEEEdouble.getValue() + 1),
    IEEEquad(x87DoubleExtended.getValue() + 1),
    PPCDoubleDouble(IEEEquad.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static APFloatSemantics valueOf(int val) {
      APFloatSemantics out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final APFloatSemantics[] VALUES;
      private static final APFloatSemantics[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (APFloatSemantics kind : APFloatSemantics.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new APFloatSemantics[min < 0 ? (1-min) : 0];
        VALUES = new APFloatSemantics[max >= 0 ? (1+max) : 0];
        for (APFloatSemantics kind : APFloatSemantics.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private APFloatSemantics(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((APFloatSemantics)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((APFloatSemantics)obj).value);}
    //</editor-fold>
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::Stmt::FloatingLiteralBitfields">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 153,
   FQN="clang::Stmt::FloatingLiteralBitfields", NM="_ZN5clang4Stmt24FloatingLiteralBitfieldsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang4Stmt24FloatingLiteralBitfieldsE")
  //</editor-fold>
  protected static class FloatingLiteralBitfields {
    /*friend  class FloatingLiteral*/
    private /*JCHAR unsigned int*/ char Unnamed_field /*: NumExprBits*/;
    
    protected/*friend*//*private*/ /*JBYTE unsigned int*/ byte Semantics /*: 3*/; // Provides semantics for APFloat construction
    protected/*friend*//*private*/ /*JBIT unsigned int*/ boolean IsExact /*: 1*/;
    
    @Override public String toString() {
      return "" + "Unnamed_field=" + $ushort2uint(Unnamed_field) // NOI18N
                + ", Semantics=" + $uchar2uint(Semantics) // NOI18N
                + ", IsExact=" + IsExact; // NOI18N
    }
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::Stmt::UnaryExprOrTypeTraitExprBitfields">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 161,
   FQN="clang::Stmt::UnaryExprOrTypeTraitExprBitfields", NM="_ZN5clang4Stmt33UnaryExprOrTypeTraitExprBitfieldsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang4Stmt33UnaryExprOrTypeTraitExprBitfieldsE")
  //</editor-fold>
  protected static class UnaryExprOrTypeTraitExprBitfields {
    /*friend  class UnaryExprOrTypeTraitExpr*/
    private /*JCHAR unsigned int*/ char Unnamed_field /*: NumExprBits*/;
    
    protected/*private*/ /*JBYTE unsigned int*/ byte Kind /*: 2*/;
    protected/*private*/ /*JBIT unsigned int*/ boolean IsType /*: 1*/; // true if operand is a type, false if an expression.
    
    @Override public String toString() {
      return "" + "Unnamed_field=" + $ushort2uint(Unnamed_field) // NOI18N
                + ", Kind=" + $uchar2uint(Kind) // NOI18N
                + ", IsType=" + IsType; // NOI18N
    }
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::Stmt::DeclRefExprBitfields">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 169,
   FQN="clang::Stmt::DeclRefExprBitfields", NM="_ZN5clang4Stmt20DeclRefExprBitfieldsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang4Stmt20DeclRefExprBitfieldsE")
  //</editor-fold>
  /*friend*/public static class DeclRefExprBitfields {
    /*friend  class DeclRefExpr*/
    /*friend  class ASTStmtReader*/ // deserialization
    private /*JCHAR unsigned int*/ char Unnamed_field /*: NumExprBits*/;
    
    /*friend*/public/*private*/ /*JBIT unsigned int*/ boolean HasQualifier /*: 1*/;
    /*friend*/public/*private*/ /*JBIT unsigned int*/ boolean HasTemplateKWAndArgsInfo /*: 1*/;
    /*friend*/public/*private*/ /*JBIT unsigned int*/ boolean HasFoundDecl /*: 1*/;
    /*friend*/public/*private*/ /*JBIT unsigned int*/ boolean HadMultipleCandidates /*: 1*/;
    /*friend*/public/*private*/ /*JBIT unsigned int*/ boolean RefersToEnclosingVariableOrCapture /*: 1*/;
    
    @Override public String toString() {
      return "" + "Unnamed_field=" + $ushort2uint(Unnamed_field) // NOI18N
                + ", HasQualifier=" + HasQualifier // NOI18N
                + ", HasTemplateKWAndArgsInfo=" + HasTemplateKWAndArgsInfo // NOI18N
                + ", HasFoundDecl=" + HasFoundDecl // NOI18N
                + ", HadMultipleCandidates=" + HadMultipleCandidates // NOI18N
                + ", RefersToEnclosingVariableOrCapture=" + RefersToEnclosingVariableOrCapture; // NOI18N
    }
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::Stmt::CastExprBitfields">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 181,
   FQN="clang::Stmt::CastExprBitfields", NM="_ZN5clang4Stmt17CastExprBitfieldsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang4Stmt17CastExprBitfieldsE")
  //</editor-fold>
  protected static class CastExprBitfields {
    /*friend  class CastExpr*/
    private /*JCHAR unsigned int*/ char Unnamed_field /*: NumExprBits*/;
    
    protected/*private*/ /*JBYTE unsigned int*/ byte Kind /*: 6*/;
    protected/*private*/ /*JCHAR unsigned int*/ char BasePathSize /*: 32 - 6 - NumExprBits*/;
    
    @Override public String toString() {
      return "" + "Unnamed_field=" + $ushort2uint(Unnamed_field) // NOI18N
                + ", Kind=" + $uchar2uint(Kind) // NOI18N
                + ", BasePathSize=" + $ushort2uint(BasePathSize); // NOI18N
    }
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::Stmt::CallExprBitfields">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 189,
   FQN="clang::Stmt::CallExprBitfields", NM="_ZN5clang4Stmt17CallExprBitfieldsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang4Stmt17CallExprBitfieldsE")
  //</editor-fold>
  protected static class CallExprBitfields {
    /*friend  class CallExpr*/
    private /*JCHAR unsigned int*/ char Unnamed_field /*: NumExprBits*/;
    
    protected/*private*/ /*JBIT unsigned int*/ boolean NumPreArgs /*: 1*/;
    
    @Override public String toString() {
      return "" + "Unnamed_field=" + $ushort2uint(Unnamed_field) // NOI18N
                + ", NumPreArgs=" + NumPreArgs; // NOI18N
    }
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::Stmt::ExprWithCleanupsBitfields">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 196,
   FQN="clang::Stmt::ExprWithCleanupsBitfields", NM="_ZN5clang4Stmt25ExprWithCleanupsBitfieldsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang4Stmt25ExprWithCleanupsBitfieldsE")
  //</editor-fold>
  /*friend*/public static class ExprWithCleanupsBitfields {
    /*friend  class ExprWithCleanups*/
    /*friend  class ASTStmtReader*/ // deserialization
    
    private /*JCHAR unsigned int*/ char Unnamed_field /*: NumExprBits*/;
    
    // When false, it must not have side effects.
    /*friend*/public/*friend*//*private*/ /*JBIT unsigned int*/ boolean CleanupsHaveSideEffects /*: 1*/;

    protected/*friend*//*private*/ /*JCHAR unsigned int*/ char NumObjects /*: 32 - 1 - NumExprBits*/;
    
    @Override public String toString() {
      return "" + "Unnamed_field=" + $ushort2uint(Unnamed_field) // NOI18N
                + ", CleanupsHaveSideEffects=" + CleanupsHaveSideEffects // NOI18N
                + ", NumObjects=" + $ushort2uint(NumObjects); // NOI18N
    }
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::Stmt::PseudoObjectExprBitfields">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 208,
   FQN="clang::Stmt::PseudoObjectExprBitfields", NM="_ZN5clang4Stmt25PseudoObjectExprBitfieldsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang4Stmt25PseudoObjectExprBitfieldsE")
  //</editor-fold>
  /*friend*/public static class PseudoObjectExprBitfields {
    /*friend  class PseudoObjectExpr*/
    /*friend  class ASTStmtReader*/ // deserialization
    
    private /*JCHAR unsigned int*/ char Unnamed_field /*: NumExprBits*/;
    
    // These don't need to be particularly wide, because they're
    // strictly limited by the forms of expressions we permit.
    /*friend*/public/*private*/ /*JBYTE unsigned int*/ byte NumSubExprs /*: 8*/;
    /*friend*/public/*private*/ /*JBYTE unsigned int*/ byte ResultIndex /*: 32 - 8 - NumExprBits*/;
    
    @Override public String toString() {
      return "" + "Unnamed_field=" + $ushort2uint(Unnamed_field) // NOI18N
                + ", NumSubExprs=" + $uchar2uint(NumSubExprs) // NOI18N
                + ", ResultIndex=" + $uchar2uint(ResultIndex); // NOI18N
    }
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::Stmt::ObjCIndirectCopyRestoreExprBitfields">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 220,
   FQN="clang::Stmt::ObjCIndirectCopyRestoreExprBitfields", NM="_ZN5clang4Stmt36ObjCIndirectCopyRestoreExprBitfieldsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang4Stmt36ObjCIndirectCopyRestoreExprBitfieldsE")
  //</editor-fold>
  protected static class ObjCIndirectCopyRestoreExprBitfields {
    /*friend  class ObjCIndirectCopyRestoreExpr*/
    private /*JCHAR unsigned int*/ char Unnamed_field /*: NumExprBits*/;
    
    protected/*private*/ /*JBIT unsigned int*/ boolean ShouldCopy /*: 1*/;
    
    @Override public String toString() {
      return "" + "Unnamed_field=" + $ushort2uint(Unnamed_field) // NOI18N
                + ", ShouldCopy=" + ShouldCopy; // NOI18N
    }
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::Stmt::InitListExprBitfields">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 227,
   FQN="clang::Stmt::InitListExprBitfields", NM="_ZN5clang4Stmt21InitListExprBitfieldsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang4Stmt21InitListExprBitfieldsE")
  //</editor-fold>
  protected static class InitListExprBitfields {
    /*friend  class InitListExpr*/
    
    private /*JCHAR unsigned int*/ char Unnamed_field /*: NumExprBits*/;
    
    /// Whether this initializer list originally had a GNU array-range
    /// designator in it. This is a temporary marker used by CodeGen.
    protected/*private*/ /*JBIT unsigned int*/ boolean HadArrayRangeDesignator /*: 1*/;
    
    @Override public String toString() {
      return "" + "Unnamed_field=" + $ushort2uint(Unnamed_field) // NOI18N
                + ", HadArrayRangeDesignator=" + HadArrayRangeDesignator; // NOI18N
    }
  };
  
  //<editor-fold defaultstate="collapsed" desc="clang::Stmt::TypeTraitExprBitfields">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 237,
   FQN="clang::Stmt::TypeTraitExprBitfields", NM="_ZN5clang4Stmt22TypeTraitExprBitfieldsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang4Stmt22TypeTraitExprBitfieldsE")
  //</editor-fold>
  /*friend*/public static class TypeTraitExprBitfields {
    /*friend  class TypeTraitExpr*/
    /*friend  class ASTStmtReader*/
    /*friend  class ASTStmtWriter*/
    
    private /*JCHAR unsigned int*/ char Unnamed_field /*: NumExprBits*/;
    
    /// \brief The kind of type trait, which is a value of a TypeTrait enumerator.
    /*friend*/public/*private*/ /*JBYTE unsigned int*/ byte Kind /*: 8*/;
    
    /// \brief If this expression is not value-dependent, this indicates whether
    /// the trait evaluated true or false.
    /*friend*/public/*private*/ /*JBIT unsigned int*/ boolean Value /*: 1*/;
    
    /// \brief The number of arguments to this type trait.
    /*friend*/public/*private*/ /*JBYTE unsigned int*/ byte NumArgs /*: 32 - 8 - 1 - NumExprBits*/;
    
    @Override public String toString() {
      return "" + "Unnamed_field=" + $ushort2uint(Unnamed_field) // NOI18N
                + ", Kind=" + $uchar2uint(Kind) // NOI18N
                + ", Value=" + Value // NOI18N
                + ", NumArgs=" + $uchar2uint(NumArgs); // NOI18N
    }
  };
  //<editor-fold defaultstate="collapsed" desc="clang::Stmt::(anonymous)">
  @Converted(kind = Converted.Kind.MANUAL/*init fields - NOT OPTIMAL*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 255,
   FQN="clang::Stmt::(anonymous)", NM="_ZN5clang4StmtE_Unnamed_union16",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang4StmtE_Unnamed_union16")
  //</editor-fold>
  /*friend*/public static class/*union*/ Unnamed_union16 {
    public final StmtBitfields StmtBits = new StmtBitfields();
    public final CompoundStmtBitfields CompoundStmtBits = new CompoundStmtBitfields();
    public final IfStmtBitfields IfStmtBits = new IfStmtBitfields();
    public final ExprBitfields ExprBits = new ExprBitfields();
    public final CharacterLiteralBitfields CharacterLiteralBits = new CharacterLiteralBitfields();
    public final FloatingLiteralBitfields FloatingLiteralBits = new FloatingLiteralBitfields();
    public final UnaryExprOrTypeTraitExprBitfields UnaryExprOrTypeTraitExprBits = new UnaryExprOrTypeTraitExprBitfields();
    public final DeclRefExprBitfields DeclRefExprBits = new DeclRefExprBitfields();
    public final CastExprBitfields CastExprBits = new CastExprBitfields();
    public final CallExprBitfields CallExprBits = new CallExprBitfields();
    public final ExprWithCleanupsBitfields ExprWithCleanupsBits = new ExprWithCleanupsBitfields();
    public final PseudoObjectExprBitfields PseudoObjectExprBits = new PseudoObjectExprBitfields();
    public final ObjCIndirectCopyRestoreExprBitfields ObjCIndirectCopyRestoreExprBits = new ObjCIndirectCopyRestoreExprBitfields();
    public final InitListExprBitfields InitListExprBits = new InitListExprBitfields();
    public final TypeTraitExprBitfields TypeTraitExprBits = new TypeTraitExprBitfields();
    
    @Override public String toString() {
      return "" + "StmtBits=" + StmtBits // NOI18N
                + ", CompoundStmtBits=" + CompoundStmtBits // NOI18N
                + ", IfStmtBits=" + IfStmtBits // NOI18N
                + ", ExprBits=" + ExprBits // NOI18N
                + ", CharacterLiteralBits=" + CharacterLiteralBits // NOI18N
                + ", FloatingLiteralBits=" + FloatingLiteralBits // NOI18N
                + ", UnaryExprOrTypeTraitExprBits=" + UnaryExprOrTypeTraitExprBits // NOI18N
                + ", DeclRefExprBits=" + DeclRefExprBits // NOI18N
                + ", CastExprBits=" + CastExprBits // NOI18N
                + ", CallExprBits=" + CallExprBits // NOI18N
                + ", ExprWithCleanupsBits=" + ExprWithCleanupsBits // NOI18N
                + ", PseudoObjectExprBits=" + PseudoObjectExprBits // NOI18N
                + ", ObjCIndirectCopyRestoreExprBits=" + ObjCIndirectCopyRestoreExprBits // NOI18N
                + ", InitListExprBits=" + InitListExprBits // NOI18N
                + ", TypeTraitExprBits=" + TypeTraitExprBits; // NOI18N
    }
  };
  /*friend*/public final Unnamed_union16 Unnamed_field = new Unnamed_union16();
  
  /*friend  class ASTStmtReader*/
  /*friend  class ASTStmtWriter*/
/*public:*/
  // Only allow allocation of Stmts using the allocator in ASTContext
  // or by doing a placement new.
  // Only allow allocation of Stmts using the allocator in ASTContext
  // or by doing a placement new.
  //<editor-fold defaultstate="collapsed" desc="clang::Stmt::operator new">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*resolve recursion*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp", line = 53,
   FQN="clang::Stmt::operator new", NM="_ZN5clang4StmtnwEjRKNS_10ASTContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang4StmtnwEjRKNS_10ASTContextEj")
  //</editor-fold>
  public static Object/*void P*/ $new_uint_ASTContext$C_uint(/*size_t*/int bytes, final /*const*/ ASTContext /*&*/ C) {
    return $new_uint_ASTContext$C_uint(bytes, C, 
                             8);
  }
  public static Object/*void P*/ $new_uint_ASTContext$C_uint(/*size_t*/int bytes, final /*const*/ ASTContext /*&*/ C, 
                             /*uint*/int alignment/*= 8*/) {
//    return ASTContextGlobals./*::*/$new_uint_ASTContext$C_uint(bytes, C, alignment);
    throw new UnsupportedOperationException("$new_uint_ASTContext$C_uint(ASTContext, constructor) must be used instead");
  }


  
  //<editor-fold defaultstate="collapsed" desc="clang::Stmt::operator new">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 282,
   FQN="clang::Stmt::operator new", NM="_ZN5clang4StmtnwEjPKNS_10ASTContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang4StmtnwEjPKNS_10ASTContextEj")
  //</editor-fold>
  public static Object/*void P*/ $new_uint_ASTContext$C$P_uint(/*size_t*/int bytes, /*const*/ ASTContext /*P*/ C) {
    return $new_uint_ASTContext$C$P_uint(bytes, C, 
                               8);
  }
  public static Object/*void P*/ $new_uint_ASTContext$C$P_uint(/*size_t*/int bytes, /*const*/ ASTContext /*P*/ C, 
                               /*uint*/int alignment/*= 8*/) {
//    return $new_uint_ASTContext$C_uint(bytes, /*Deref*/C, alignment);
    throw new UnsupportedOperationException("$new_uint_ASTContext$C$P_uint(ASTContext, constructor) must be used instead");
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Stmt::operator new">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 287,
   FQN="clang::Stmt::operator new", NM="_ZN5clang4StmtnwEjPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang4StmtnwEjPv")
  //</editor-fold>
  public static Object/*void P*/ $new(/*size_t*/int bytes, Object/*void P*/ mem) {
//    return mem;
    throw new UnsupportedOperationException("$new(mem, constructor) must be used instead");
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Stmt::operator delete">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 289,
   FQN="clang::Stmt::operator delete", NM="_ZN5clang4StmtdlEPvRKNS_10ASTContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang4StmtdlEPvRKNS_10ASTContextEj")
  //</editor-fold>
  public static void $delete_voidPtr_ASTContext$C_uint(Object/*void P*/ $Prm0, final /*const*/ ASTContext /*&*/ $Prm1, /*uint*/int $Prm2) {
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Stmt::operator delete">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 290,
   FQN="clang::Stmt::operator delete", NM="_ZN5clang4StmtdlEPvPKNS_10ASTContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang4StmtdlEPvPKNS_10ASTContextEj")
  //</editor-fold>
  public static void $delete$ASTContextPtr(Object/*void P*/ $Prm0, /*const*/ ASTContext /*P*/ $Prm1, /*uint*/int $Prm2) {
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Stmt::operator delete">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 291,
   FQN="clang::Stmt::operator delete", NM="_ZN5clang4StmtdlEPvj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang4StmtdlEPvj")
  //</editor-fold>
  public static void $delete(Object/*void P*/ $Prm0, /*size_t*/int $Prm1) {
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Stmt::operator delete">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 292,
   FQN="clang::Stmt::operator delete", NM="_ZN5clang4StmtdlEPvS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang4StmtdlEPvS1_")
  //</editor-fold>
  public static void $delete(Object/*void P*/ $Prm0, Object/*void P*/ $Prm1) {
  }

/*public:*/
  /// \brief A placeholder type used to construct an empty shell of a
  /// type, that will be filled in later (e.g., by some
  /// de-serialization).
  //<editor-fold defaultstate="collapsed" desc="clang::Stmt::EmptyShell">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 298,
   FQN="clang::Stmt::EmptyShell", NM="_ZN5clang4Stmt10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang4Stmt10EmptyShellE")
  //</editor-fold>
  public static class/*struct*/ EmptyShell {
    //<editor-fold defaultstate="collapsed" desc="clang::Stmt::EmptyShell::EmptyShell">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 298,
     FQN="clang::Stmt::EmptyShell::EmptyShell", NM="_ZN5clang4Stmt10EmptyShellC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang4Stmt10EmptyShellC1ERKS1_")
    //</editor-fold>
    public /*inline*/ EmptyShell(final /*const*/ EmptyShell /*&*/ $Prm0) {
    }

    //<editor-fold defaultstate="collapsed" desc="clang::Stmt::EmptyShell::EmptyShell">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 298,
     FQN="clang::Stmt::EmptyShell::EmptyShell", NM="_ZN5clang4Stmt10EmptyShellC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang4Stmt10EmptyShellC1EOS1_")
    //</editor-fold>
    public /*inline*/ EmptyShell(JD$Move _dparam, final EmptyShell /*&&*/$Prm0) {
    }


    //<editor-fold defaultstate="collapsed" desc="clang::Stmt::EmptyShell::EmptyShell">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 298,
     FQN="clang::Stmt::EmptyShell::EmptyShell", NM="_ZN5clang4Stmt10EmptyShellC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprCXX.cpp -nm=_ZN5clang4Stmt10EmptyShellC1Ev")
    //</editor-fold>
    public /*inline*/ EmptyShell() {
    }

    
    @Override public String toString() {
      return ""; // NOI18N
    }
  };
/*protected:*/
  /// Iterator for iterating over Stmt * arrays that contain only Expr *
  ///
  /// This is needed because AST nodes use Stmt* arrays to store
  /// references to children (to be compatible with StmtIterator).
  //<editor-fold defaultstate="collapsed" desc="clang::Stmt::ExprIterator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 305,
   FQN="clang::Stmt::ExprIterator", NM="_ZN5clang4Stmt12ExprIteratorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang4Stmt12ExprIteratorE")
  //</editor-fold>
  public/*protected*/ static class/*struct*/ ExprIterator extends /**/ iterator_adaptor_base<ExprIterator, type$ptr<Stmt /*P*/ /*P*/>, std.random_access_iterator_tag, Expr /*P*/ , Expr /*P*/ > {
    //<editor-fold defaultstate="collapsed" desc="clang::Stmt::ExprIterator::ExprIterator">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 308,
     FQN="clang::Stmt::ExprIterator::ExprIterator", NM="_ZN5clang4Stmt12ExprIteratorC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang4Stmt12ExprIteratorC1Ev")
    //</editor-fold>
    public ExprIterator() {
      // : iterator_adaptor_base<ExprIterator, Stmt * * , random_access_iterator_tag, Expr * , int, Expr * * , Expr * & , iterator_traitsT$P<Stmt * > >(null) 
      //START JInit
      super((type$ptr<Stmt /*P*/ /*P*/>)null);
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::Stmt::ExprIterator::ExprIterator">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 309,
     FQN="clang::Stmt::ExprIterator::ExprIterator", NM="_ZN5clang4Stmt12ExprIteratorC1EPPS0_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang4Stmt12ExprIteratorC1EPPS0_")
    //</editor-fold>
    public ExprIterator(type$ptr<Stmt /*P*/ /*P*/> I) {
      // : iterator_adaptor_base<ExprIterator, Stmt * * , random_access_iterator_tag, Expr * , int, Expr * * , Expr * & , iterator_traitsT$P<Stmt * > >(I) 
      //START JInit
      super(I);
      //END JInit
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::Stmt::ExprIterator::operator*">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 311,
     FQN="clang::Stmt::ExprIterator::operator*", NM="_ZNK5clang4Stmt12ExprIteratordeEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Stmt12ExprIteratordeEv")
    //</editor-fold>
    public Expr /*P*/ $star() /*const*/ {
      assert ((I.$star()).getStmtClass().getValue() >= StmtClass.firstExprConstant.getValue() && (I.$star()).getStmtClass().getValue() <= StmtClass.lastExprConstant.getValue());
      return ((type$ptr<Expr /*P*/ /*P*/>)reinterpret_cast(type$ptr.class, I)).$star();
    }

    //<editor-fold defaultstate="collapsed" desc="clang::Stmt::ExprIterator::ExprIterator">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 305,
     FQN="clang::Stmt::ExprIterator::ExprIterator", NM="_ZN5clang4Stmt12ExprIteratorC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang4Stmt12ExprIteratorC1EOS1_")
    //</editor-fold>
    public /*inline*/ ExprIterator(JD$Move _dparam, final ExprIterator /*&&*/$Prm0) {
      // : iterator_adaptor_base<ExprIterator, Stmt * * , std::random_access_iterator_tag, Expr * >(static_cast<ExprIterator &&>()) 
      //START JInit
      super(JD$Move.INSTANCE, $Prm0);
      //END JInit
    }


    //<editor-fold defaultstate="collapsed" desc="clang::Stmt::ExprIterator::ExprIterator">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 305,
     FQN="clang::Stmt::ExprIterator::ExprIterator", NM="_ZN5clang4Stmt12ExprIteratorC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN5clang4Stmt12ExprIteratorC1ERKS1_")
    //</editor-fold>
    public /*inline*/ ExprIterator(final /*const*/ ExprIterator /*&*/ $Prm0) {
      // : iterator_adaptor_base<ExprIterator, Stmt * * , std::random_access_iterator_tag, Expr * >() 
      //START JInit
      super(JD$BaseOf.INSTANCE, $Prm0);
      //END JInit
    }

    @Override public ExprIterator clone() { return new ExprIterator(this); }
    
    @Override public String toString() {
      return "" + super.toString(); // NOI18N
    }
  };
  
  /// Const iterator for iterating over Stmt * arrays that contain only Expr *
  //<editor-fold defaultstate="collapsed" desc="clang::Stmt::ConstExprIterator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 319,
   FQN="clang::Stmt::ConstExprIterator", NM="_ZN5clang4Stmt17ConstExprIteratorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang4Stmt17ConstExprIteratorE")
  //</editor-fold>
  public/*protected*/ static class/*struct*/ ConstExprIterator extends /**/ iterator_adaptor_base<ConstExprIterator, type$ptr</*const*/ Stmt /*P*/ /*const*/ /*P*/>, std.random_access_iterator_tag, /*const*/ Expr /*P*/ /*const*/, /*const*/ Expr /*P*/ /*const*/> {
    //<editor-fold defaultstate="collapsed" desc="clang::Stmt::ConstExprIterator::ConstExprIterator">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 323,
     FQN="clang::Stmt::ConstExprIterator::ConstExprIterator", NM="_ZN5clang4Stmt17ConstExprIteratorC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang4Stmt17ConstExprIteratorC1Ev")
    //</editor-fold>
    public ConstExprIterator() {
      // : iterator_adaptor_base<ConstExprIterator, const Stmt * const * , random_access_iterator_tag, const Expr * const, int, const Expr * const * , const Expr * const & , iterator_traitsT$C$P<const Stmt * > >(null) 
      //START JInit
      super((type$ptr</*const*/ Stmt /*P*/ /*const*/ /*P*/>)null);
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="clang::Stmt::ConstExprIterator::ConstExprIterator">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 324,
     FQN="clang::Stmt::ConstExprIterator::ConstExprIterator", NM="_ZN5clang4Stmt17ConstExprIteratorC1EPKPKS0_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang4Stmt17ConstExprIteratorC1EPKPKS0_")
    //</editor-fold>
    public ConstExprIterator(type$ptr</*const*/ Stmt /*P*/ /*const*/ /*P*/> I) {
      // : iterator_adaptor_base<ConstExprIterator, const Stmt * const * , random_access_iterator_tag, const Expr * const, int, const Expr * const * , const Expr * const & , iterator_traitsT$C$P<const Stmt * > >(I) 
      //START JInit
      super(I);
      //END JInit
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::Stmt::ConstExprIterator::operator*">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 326,
     FQN="clang::Stmt::ConstExprIterator::operator*", NM="_ZNK5clang4Stmt17ConstExprIteratordeEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Stmt17ConstExprIteratordeEv")
    //</editor-fold>
    public /*const*/ Expr /*P*/ /*const*/ $star() /*const*/ {
      assert ((I.$star()).getStmtClass().getValue() >= StmtClass.firstExprConstant.getValue() && (I.$star()).getStmtClass().getValue() <= StmtClass.lastExprConstant.getValue());
      return ((type$ptr</*const*/ Expr /*P*/ /*const*/ /*P*/>)reinterpret_cast(type$ptr.class, I)).$star();
    }

    //<editor-fold defaultstate="collapsed" desc="clang::Stmt::ConstExprIterator::ConstExprIterator">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 319,
     FQN="clang::Stmt::ConstExprIterator::ConstExprIterator", NM="_ZN5clang4Stmt17ConstExprIteratorC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang4Stmt17ConstExprIteratorC1EOS1_")
    //</editor-fold>
    public /*inline*/ ConstExprIterator(JD$Move _dparam, final ConstExprIterator /*&&*/$Prm0) {
      // : iterator_adaptor_base<ConstExprIterator, const Stmt * const * , std::random_access_iterator_tag, const Expr * const>(static_cast<ConstExprIterator &&>()) 
      //START JInit
      super(JD$Move.INSTANCE, $Prm0);
      //END JInit
    }


    //<editor-fold defaultstate="collapsed" desc="clang::Stmt::ConstExprIterator::ConstExprIterator">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 319,
     FQN="clang::Stmt::ConstExprIterator::ConstExprIterator", NM="_ZN5clang4Stmt17ConstExprIteratorC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN5clang4Stmt17ConstExprIteratorC1ERKS1_")
    //</editor-fold>
    public /*inline*/ ConstExprIterator(final /*const*/ ConstExprIterator /*&*/ $Prm0) {
      // : iterator_adaptor_base<ConstExprIterator, const Stmt * const * , std::random_access_iterator_tag, const Expr * const>() 
      //START JInit
      super(JD$BaseOf.INSTANCE, $Prm0);
      //END JInit
    }

    @Override public ConstExprIterator clone() { return new ConstExprIterator(this); }
    
    @Override public String toString() {
      return "" + super.toString(); // NOI18N
    }
  };
/*private:*/
  /// \brief Whether statistic collection is enabled.
  private static boolean StatisticsEnabled;
/*protected:*/
  /// \brief Construct an empty statement.
  //<editor-fold defaultstate="collapsed" desc="clang::Stmt::Stmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 339,
   FQN="clang::Stmt::Stmt", NM="_ZN5clang4StmtC1ENS0_9StmtClassENS0_10EmptyShellE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang4StmtC1ENS0_9StmtClassENS0_10EmptyShellE")
  //</editor-fold>
  protected /*explicit*/ Stmt(StmtClass SC, EmptyShell $Prm1) {
    // : Stmt(SC) 
    //START JInit
    this(SC);
    //END JInit
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::Stmt::Stmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 342,
   FQN="clang::Stmt::Stmt", NM="_ZN5clang4StmtC1ENS0_9StmtClassE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang4StmtC1ENS0_9StmtClassE")
  //</editor-fold>
  public Stmt(StmtClass SC) {
    $Stmt(SC);
  }
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  public void $Stmt(StmtClass SC) {
    static_assert($rem_uint(sizeof(/*Deref*/this), AlignOf.<Object/*void P*/ >Unnamed_enum.Alignment$Java) == 0, $("Insufficient alignment!"));
    Unnamed_field.StmtBits.sClass = $uint2uint_8bits(SC.getValue());
    if (StatisticsEnabled) {
      Stmt.addStmtClass(SC);
    }
  }
  
  
  //<editor-fold defaultstate="collapsed" desc="clang::Stmt::getStmtClass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 349,
   FQN="clang::Stmt::getStmtClass", NM="_ZNK5clang4Stmt12getStmtClassEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Stmt12getStmtClassEv")
  //</editor-fold>
  public StmtClass getStmtClass() /*const*/ {
    return /*static_cast*/StmtClass.valueOf($8bits_uint2uint(Unnamed_field.StmtBits.sClass));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Stmt::getStmtClassName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp", line = 58,
   FQN="clang::Stmt::getStmtClassName", NM="_ZNK5clang4Stmt16getStmtClassNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang4Stmt16getStmtClassNameEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ getStmtClassName() /*const*/ {
    return getStmtInfoTableEntry(StmtClass.valueOf($8bits_uint2uint(Unnamed_field.StmtBits.sClass))).Name;
  }


  
  /// SourceLocation tokens are not useful in isolation - they are low level
  /// value objects created/interpreted by SourceManager. We assume AST
  /// clients will have a pointer to the respective SourceManager.
  
  /// SourceLocation tokens are not useful in isolation - they are low level
  /// value objects created/interpreted by SourceManager. We assume AST
  /// clients will have a pointer to the respective SourceManager.
  //<editor-fold defaultstate="collapsed" desc="clang::Stmt::getSourceRange">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp", line = 245,
   FQN="clang::Stmt::getSourceRange", NM="_ZNK5clang4Stmt14getSourceRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang4Stmt14getSourceRangeEv")
  //</editor-fold>
  public SourceRange getSourceRange() /*const*//* __attribute__((pure))*/ {
    switch (getStmtClass()) {
     case NoStmtClass:
      throw new llvm_unreachable("statement without class");
     case GCCAsmStmtClass:
      return StmtStatics.<GCCAsmStmt>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/GCCAsmStmt::getSourceRange);
     case MSAsmStmtClass:
      return StmtStatics.<MSAsmStmt>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/MSAsmStmt::getSourceRange);
     case AttributedStmtClass:
      return StmtStatics.<AttributedStmt>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/AttributedStmt::getSourceRange);
     case BreakStmtClass:
      return StmtStatics.<BreakStmt>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/BreakStmt::getSourceRange);
     case CXXCatchStmtClass:
      return StmtStatics.<CXXCatchStmt>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/CXXCatchStmt::getSourceRange);
     case CXXForRangeStmtClass:
      return StmtStatics.<CXXForRangeStmt>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/CXXForRangeStmt::getSourceRange);
     case CXXTryStmtClass:
      return StmtStatics.<CXXTryStmt>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/CXXTryStmt::getSourceRange);
     case CapturedStmtClass:
      if(true)throw new ClassCastException("Cannot be here");
      return StmtStatics.<CapturedStmt>getSourceRangeImpl$getSourceRange(this, /*AddrOf*//*FPtr*/CapturedStmt::getSourceRange);
     case CompoundStmtClass:
      return StmtStatics.<CompoundStmt>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/CompoundStmt::getSourceRange);
     case ContinueStmtClass:
      return StmtStatics.<ContinueStmt>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/ContinueStmt::getSourceRange);
     case CoreturnStmtClass:
      return StmtStatics.<CoreturnStmt>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/CoreturnStmt::getSourceRange);
     case CoroutineBodyStmtClass:
      return StmtStatics.<CoroutineBodyStmt>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/CoroutineBodyStmt::getSourceRange);
     case DeclStmtClass:
      return StmtStatics.<DeclStmt>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/DeclStmt::getSourceRange);
     case DoStmtClass:
      return StmtStatics.<DoStmt>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/DoStmt::getSourceRange);
     case BinaryConditionalOperatorClass:
      return StmtStatics.<BinaryConditionalOperator>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/BinaryConditionalOperator::getSourceRange);
     case ConditionalOperatorClass:
      return StmtStatics.<ConditionalOperator>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/ConditionalOperator::getSourceRange);
     case AddrLabelExprClass:
      return StmtStatics.<AddrLabelExpr>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/AddrLabelExpr::getSourceRange);
     case ArraySubscriptExprClass:
      return StmtStatics.<ArraySubscriptExpr>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/ArraySubscriptExpr::getSourceRange);
     case ArrayTypeTraitExprClass:
      return StmtStatics.<ArrayTypeTraitExpr>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/ArrayTypeTraitExpr::getSourceRange);
     case AsTypeExprClass:
      return StmtStatics.<AsTypeExpr>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/AsTypeExpr::getSourceRange);
     case AtomicExprClass:
      return StmtStatics.<AtomicExpr>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/AtomicExpr::getSourceRange);
     case BinaryOperatorClass:
      return StmtStatics.<BinaryOperator>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/BinaryOperator::getSourceRange);
     case CompoundAssignOperatorClass:
      return StmtStatics.<CompoundAssignOperator>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/CompoundAssignOperator::getSourceRange);
     case BlockExprClass:
      return StmtStatics.<BlockExpr>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/BlockExpr::getSourceRange);
     case CXXBindTemporaryExprClass:
      return StmtStatics.<CXXBindTemporaryExpr>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/CXXBindTemporaryExpr::getSourceRange);
     case CXXBoolLiteralExprClass:
      return StmtStatics.<CXXBoolLiteralExpr>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/CXXBoolLiteralExpr::getSourceRange);
     case CXXConstructExprClass:
      return StmtStatics.<CXXConstructExpr>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/CXXConstructExpr::getSourceRange);
     case CXXTemporaryObjectExprClass:
      return StmtStatics.<CXXTemporaryObjectExpr>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/CXXTemporaryObjectExpr::getSourceRange);
     case CXXDefaultArgExprClass:
      return StmtStatics.<CXXDefaultArgExpr>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/CXXDefaultArgExpr::getSourceRange);
     case CXXDefaultInitExprClass:
      return StmtStatics.<CXXDefaultInitExpr>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/CXXDefaultInitExpr::getSourceRange);
     case CXXDeleteExprClass:
      return StmtStatics.<CXXDeleteExpr>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/CXXDeleteExpr::getSourceRange);
     case CXXDependentScopeMemberExprClass:
      return StmtStatics.<CXXDependentScopeMemberExpr>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/CXXDependentScopeMemberExpr::getSourceRange);
     case CXXFoldExprClass:
      return StmtStatics.<CXXFoldExpr>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/CXXFoldExpr::getSourceRange);
     case CXXInheritedCtorInitExprClass:
      return StmtStatics.<CXXInheritedCtorInitExpr>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/CXXInheritedCtorInitExpr::getSourceRange);
     case CXXNewExprClass:
      if(true)throw new ClassCastException("Cannot be here");
      return StmtStatics.<CXXNewExpr>getSourceRangeImpl$getSourceRange(this, /*AddrOf*//*FPtr*/CXXNewExpr::getSourceRange);
     case CXXNoexceptExprClass:
      if(true)throw new ClassCastException("Cannot be here");
      return StmtStatics.<CXXNoexceptExpr>getSourceRangeImpl$getSourceRange(this, /*AddrOf*//*FPtr*/CXXNoexceptExpr::getSourceRange);
     case CXXNullPtrLiteralExprClass:
      return StmtStatics.<CXXNullPtrLiteralExpr>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/CXXNullPtrLiteralExpr::getSourceRange);
     case CXXPseudoDestructorExprClass:
      return StmtStatics.<CXXPseudoDestructorExpr>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/CXXPseudoDestructorExpr::getSourceRange);
     case CXXScalarValueInitExprClass:
      return StmtStatics.<CXXScalarValueInitExpr>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/CXXScalarValueInitExpr::getSourceRange);
     case CXXStdInitializerListExprClass:
      if(true)throw new ClassCastException("Cannot be here");
      return StmtStatics.<CXXStdInitializerListExpr>getSourceRangeImpl$getSourceRange(this, /*AddrOf*//*FPtr*/CXXStdInitializerListExpr::getSourceRange);
     case CXXThisExprClass:
      return StmtStatics.<CXXThisExpr>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/CXXThisExpr::getSourceRange);
     case CXXThrowExprClass:
      return StmtStatics.<CXXThrowExpr>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/CXXThrowExpr::getSourceRange);
     case CXXTypeidExprClass:
      if(true)throw new ClassCastException("Cannot be here");
      return StmtStatics.<CXXTypeidExpr>getSourceRangeImpl$getSourceRange(this, /*AddrOf*//*FPtr*/CXXTypeidExpr::getSourceRange);
     case CXXUnresolvedConstructExprClass:
      return StmtStatics.<CXXUnresolvedConstructExpr>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/CXXUnresolvedConstructExpr::getSourceRange);
     case CXXUuidofExprClass:
      if(true)throw new ClassCastException("Cannot be here");
      return StmtStatics.<CXXUuidofExpr>getSourceRangeImpl$getSourceRange(this, /*AddrOf*//*FPtr*/CXXUuidofExpr::getSourceRange);
     case CallExprClass:
      return StmtStatics.<CallExpr>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/CallExpr::getSourceRange);
     case CUDAKernelCallExprClass:
      return StmtStatics.<CUDAKernelCallExpr>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/CUDAKernelCallExpr::getSourceRange);
     case CXXMemberCallExprClass:
      return StmtStatics.<CXXMemberCallExpr>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/CXXMemberCallExpr::getSourceRange);
     case CXXOperatorCallExprClass:
      if(true)throw new ClassCastException("Cannot be here");
      return StmtStatics.<CXXOperatorCallExpr>getSourceRangeImpl$getSourceRange(this, /*AddrOf*//*FPtr*/CXXOperatorCallExpr::getSourceRange);
     case UserDefinedLiteralClass:
      return StmtStatics.<UserDefinedLiteral>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/UserDefinedLiteral::getSourceRange);
     case CStyleCastExprClass:
      return StmtStatics.<CStyleCastExpr>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/CStyleCastExpr::getSourceRange);
     case CXXFunctionalCastExprClass:
      return StmtStatics.<CXXFunctionalCastExpr>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/CXXFunctionalCastExpr::getSourceRange);
     case CXXConstCastExprClass:
      return StmtStatics.<CXXConstCastExpr>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/CXXConstCastExpr::getSourceRange);
     case CXXDynamicCastExprClass:
      return StmtStatics.<CXXDynamicCastExpr>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/CXXDynamicCastExpr::getSourceRange);
     case CXXReinterpretCastExprClass:
      return StmtStatics.<CXXReinterpretCastExpr>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/CXXReinterpretCastExpr::getSourceRange);
     case CXXStaticCastExprClass:
      return StmtStatics.<CXXStaticCastExpr>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/CXXStaticCastExpr::getSourceRange);
     case ObjCBridgedCastExprClass:
      return StmtStatics.<ObjCBridgedCastExpr>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/ObjCBridgedCastExpr::getSourceRange);
     case ImplicitCastExprClass:
      return StmtStatics.<ImplicitCastExpr>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/ImplicitCastExpr::getSourceRange);
     case CharacterLiteralClass:
      return StmtStatics.<CharacterLiteral>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/CharacterLiteral::getSourceRange);
     case ChooseExprClass:
      return StmtStatics.<ChooseExpr>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/ChooseExpr::getSourceRange);
     case CompoundLiteralExprClass:
      return StmtStatics.<CompoundLiteralExpr>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/CompoundLiteralExpr::getSourceRange);
     case ConvertVectorExprClass:
      return StmtStatics.<ConvertVectorExpr>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/ConvertVectorExpr::getSourceRange);
     case CoawaitExprClass:
      return StmtStatics.<CoawaitExpr>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/CoawaitExpr::getSourceRange);
     case CoyieldExprClass:
      return StmtStatics.<CoyieldExpr>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/CoyieldExpr::getSourceRange);
     case DeclRefExprClass:
      return StmtStatics.<DeclRefExpr>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/DeclRefExpr::getSourceRange);
     case DependentScopeDeclRefExprClass:
      return StmtStatics.<DependentScopeDeclRefExpr>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/DependentScopeDeclRefExpr::getSourceRange);
     case DesignatedInitExprClass:
      return StmtStatics.<DesignatedInitExpr>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/DesignatedInitExpr::getSourceRange);
     case DesignatedInitUpdateExprClass:
      return StmtStatics.<DesignatedInitUpdateExpr>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/DesignatedInitUpdateExpr::getSourceRange);
     case ExprWithCleanupsClass:
      return StmtStatics.<ExprWithCleanups>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/ExprWithCleanups::getSourceRange);
     case ExpressionTraitExprClass:
      return StmtStatics.<ExpressionTraitExpr>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/ExpressionTraitExpr::getSourceRange);
     case ExtVectorElementExprClass:
      return StmtStatics.<ExtVectorElementExpr>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/ExtVectorElementExpr::getSourceRange);
     case FloatingLiteralClass:
      return StmtStatics.<FloatingLiteral>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/FloatingLiteral::getSourceRange);
     case FunctionParmPackExprClass:
      return StmtStatics.<FunctionParmPackExpr>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/FunctionParmPackExpr::getSourceRange);
     case GNUNullExprClass:
      return StmtStatics.<GNUNullExpr>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/GNUNullExpr::getSourceRange);
     case GenericSelectionExprClass:
      return StmtStatics.<GenericSelectionExpr>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/GenericSelectionExpr::getSourceRange);
     case ImaginaryLiteralClass:
      return StmtStatics.<ImaginaryLiteral>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/ImaginaryLiteral::getSourceRange);
     case ImplicitValueInitExprClass:
      return StmtStatics.<ImplicitValueInitExpr>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/ImplicitValueInitExpr::getSourceRange);
     case InitListExprClass:
      return StmtStatics.<InitListExpr>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/InitListExpr::getSourceRange);
     case IntegerLiteralClass:
      return StmtStatics.<IntegerLiteral>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/IntegerLiteral::getSourceRange);
     case LambdaExprClass:
      return StmtStatics.<LambdaExpr>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/LambdaExpr::getSourceRange);
     case MSPropertyRefExprClass:
      if(true)throw new ClassCastException("Cannot be here");
      return StmtStatics.<MSPropertyRefExpr>getSourceRangeImpl$getSourceRange(this, /*AddrOf*//*FPtr*/MSPropertyRefExpr::getSourceRange);
     case MSPropertySubscriptExprClass:
      return StmtStatics.<MSPropertySubscriptExpr>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/MSPropertySubscriptExpr::getSourceRange);
     case MaterializeTemporaryExprClass:
      return StmtStatics.<MaterializeTemporaryExpr>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/MaterializeTemporaryExpr::getSourceRange);
     case MemberExprClass:
      return StmtStatics.<MemberExpr>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/MemberExpr::getSourceRange);
     case NoInitExprClass:
      return StmtStatics.<NoInitExpr>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/NoInitExpr::getSourceRange);
     case OMPArraySectionExprClass:
      return StmtStatics.<OMPArraySectionExpr>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/OMPArraySectionExpr::getSourceRange);
     case ObjCArrayLiteralClass:
      if(true)throw new ClassCastException("Cannot be here");
      return StmtStatics.<ObjCArrayLiteral>getSourceRangeImpl$getSourceRange(this, /*AddrOf*//*FPtr*/ObjCArrayLiteral::getSourceRange);
     case ObjCAvailabilityCheckExprClass:
      if(true)throw new ClassCastException("Cannot be here");
      return StmtStatics.<ObjCAvailabilityCheckExpr>getSourceRangeImpl$getSourceRange(this, /*AddrOf*//*FPtr*/ObjCAvailabilityCheckExpr::getSourceRange);
     case ObjCBoolLiteralExprClass:
      return StmtStatics.<ObjCBoolLiteralExpr>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/ObjCBoolLiteralExpr::getSourceRange);
     case ObjCBoxedExprClass:
      if(true)throw new ClassCastException("Cannot be here");
      return StmtStatics.<ObjCBoxedExpr>getSourceRangeImpl$getSourceRange(this, /*AddrOf*//*FPtr*/ObjCBoxedExpr::getSourceRange);
     case ObjCDictionaryLiteralClass:
      if(true)throw new ClassCastException("Cannot be here");
      return StmtStatics.<ObjCDictionaryLiteral>getSourceRangeImpl$getSourceRange(this, /*AddrOf*//*FPtr*/ObjCDictionaryLiteral::getSourceRange);
     case ObjCEncodeExprClass:
      return StmtStatics.<ObjCEncodeExpr>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/ObjCEncodeExpr::getSourceRange);
     case ObjCIndirectCopyRestoreExprClass:
      return StmtStatics.<ObjCIndirectCopyRestoreExpr>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/ObjCIndirectCopyRestoreExpr::getSourceRange);
     case ObjCIsaExprClass:
      return StmtStatics.<ObjCIsaExpr>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/ObjCIsaExpr::getSourceRange);
     case ObjCIvarRefExprClass:
      return StmtStatics.<ObjCIvarRefExpr>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/ObjCIvarRefExpr::getSourceRange);
     case ObjCMessageExprClass:
      return StmtStatics.<ObjCMessageExpr>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/ObjCMessageExpr::getSourceRange);
     case ObjCPropertyRefExprClass:
      return StmtStatics.<ObjCPropertyRefExpr>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/ObjCPropertyRefExpr::getSourceRange);
     case ObjCProtocolExprClass:
      return StmtStatics.<ObjCProtocolExpr>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/ObjCProtocolExpr::getSourceRange);
     case ObjCSelectorExprClass:
      return StmtStatics.<ObjCSelectorExpr>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/ObjCSelectorExpr::getSourceRange);
     case ObjCStringLiteralClass:
      return StmtStatics.<ObjCStringLiteral>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/ObjCStringLiteral::getSourceRange);
     case ObjCSubscriptRefExprClass:
      return StmtStatics.<ObjCSubscriptRefExpr>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/ObjCSubscriptRefExpr::getSourceRange);
     case OffsetOfExprClass:
      return StmtStatics.<OffsetOfExpr>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/OffsetOfExpr::getSourceRange);
     case OpaqueValueExprClass:
      return StmtStatics.<OpaqueValueExpr>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/OpaqueValueExpr::getSourceRange);
     case UnresolvedLookupExprClass:
      return StmtStatics.<UnresolvedLookupExpr>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/UnresolvedLookupExpr::getSourceRange);
     case UnresolvedMemberExprClass:
      return StmtStatics.<UnresolvedMemberExpr>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/UnresolvedMemberExpr::getSourceRange);
     case PackExpansionExprClass:
      return StmtStatics.<PackExpansionExpr>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/PackExpansionExpr::getSourceRange);
     case ParenExprClass:
      return StmtStatics.<ParenExpr>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/ParenExpr::getSourceRange);
     case ParenListExprClass:
      return StmtStatics.<ParenListExpr>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/ParenListExpr::getSourceRange);
     case PredefinedExprClass:
      return StmtStatics.<PredefinedExpr>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/PredefinedExpr::getSourceRange);
     case PseudoObjectExprClass:
      return StmtStatics.<PseudoObjectExpr>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/PseudoObjectExpr::getSourceRange);
     case ShuffleVectorExprClass:
      return StmtStatics.<ShuffleVectorExpr>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/ShuffleVectorExpr::getSourceRange);
     case SizeOfPackExprClass:
      return StmtStatics.<SizeOfPackExpr>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/SizeOfPackExpr::getSourceRange);
     case StmtExprClass:
      return StmtStatics.<StmtExpr>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/StmtExpr::getSourceRange);
     case StringLiteralClass:
      return StmtStatics.<StringLiteral>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/StringLiteral::getSourceRange);
     case SubstNonTypeTemplateParmExprClass:
      return StmtStatics.<SubstNonTypeTemplateParmExpr>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/SubstNonTypeTemplateParmExpr::getSourceRange);
     case SubstNonTypeTemplateParmPackExprClass:
      return StmtStatics.<SubstNonTypeTemplateParmPackExpr>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/SubstNonTypeTemplateParmPackExpr::getSourceRange);
     case TypeTraitExprClass:
      return StmtStatics.<TypeTraitExpr>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/TypeTraitExpr::getSourceRange);
     case TypoExprClass:
      return StmtStatics.<TypoExpr>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/TypoExpr::getSourceRange);
     case UnaryExprOrTypeTraitExprClass:
      return StmtStatics.<UnaryExprOrTypeTraitExpr>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/UnaryExprOrTypeTraitExpr::getSourceRange);
     case UnaryOperatorClass:
      return StmtStatics.<UnaryOperator>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/UnaryOperator::getSourceRange);
     case VAArgExprClass:
      return StmtStatics.<VAArgExpr>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/VAArgExpr::getSourceRange);
     case ForStmtClass:
      return StmtStatics.<ForStmt>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/ForStmt::getSourceRange);
     case GotoStmtClass:
      return StmtStatics.<GotoStmt>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/GotoStmt::getSourceRange);
     case IfStmtClass:
      return StmtStatics.<IfStmt>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/IfStmt::getSourceRange);
     case IndirectGotoStmtClass:
      return StmtStatics.<IndirectGotoStmt>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/IndirectGotoStmt::getSourceRange);
     case LabelStmtClass:
      return StmtStatics.<LabelStmt>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/LabelStmt::getSourceRange);
     case MSDependentExistsStmtClass:
      return StmtStatics.<MSDependentExistsStmt>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/MSDependentExistsStmt::getSourceRange);
     case NullStmtClass:
      return StmtStatics.<NullStmt>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/NullStmt::getSourceRange);
     case OMPAtomicDirectiveClass:
      return StmtStatics.<OMPAtomicDirective>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/OMPAtomicDirective::getSourceRange);
     case OMPBarrierDirectiveClass:
      return StmtStatics.<OMPBarrierDirective>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/OMPBarrierDirective::getSourceRange);
     case OMPCancelDirectiveClass:
      return StmtStatics.<OMPCancelDirective>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/OMPCancelDirective::getSourceRange);
     case OMPCancellationPointDirectiveClass:
      return StmtStatics.<OMPCancellationPointDirective>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/OMPCancellationPointDirective::getSourceRange);
     case OMPCriticalDirectiveClass:
      return StmtStatics.<OMPCriticalDirective>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/OMPCriticalDirective::getSourceRange);
     case OMPFlushDirectiveClass:
      return StmtStatics.<OMPFlushDirective>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/OMPFlushDirective::getSourceRange);
     case OMPDistributeDirectiveClass:
      return StmtStatics.<OMPDistributeDirective>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/OMPDistributeDirective::getSourceRange);
     case OMPDistributeParallelForDirectiveClass:
      return StmtStatics.<OMPDistributeParallelForDirective>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/OMPDistributeParallelForDirective::getSourceRange);
     case OMPDistributeParallelForSimdDirectiveClass:
      return StmtStatics.<OMPDistributeParallelForSimdDirective>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/OMPDistributeParallelForSimdDirective::getSourceRange);
     case OMPDistributeSimdDirectiveClass:
      return StmtStatics.<OMPDistributeSimdDirective>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/OMPDistributeSimdDirective::getSourceRange);
     case OMPForDirectiveClass:
      return StmtStatics.<OMPForDirective>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/OMPForDirective::getSourceRange);
     case OMPForSimdDirectiveClass:
      return StmtStatics.<OMPForSimdDirective>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/OMPForSimdDirective::getSourceRange);
     case OMPParallelForDirectiveClass:
      return StmtStatics.<OMPParallelForDirective>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/OMPParallelForDirective::getSourceRange);
     case OMPParallelForSimdDirectiveClass:
      return StmtStatics.<OMPParallelForSimdDirective>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/OMPParallelForSimdDirective::getSourceRange);
     case OMPSimdDirectiveClass:
      return StmtStatics.<OMPSimdDirective>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/OMPSimdDirective::getSourceRange);
     case OMPTargetParallelForSimdDirectiveClass:
      return StmtStatics.<OMPTargetParallelForSimdDirective>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/OMPTargetParallelForSimdDirective::getSourceRange);
     case OMPTaskLoopDirectiveClass:
      return StmtStatics.<OMPTaskLoopDirective>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/OMPTaskLoopDirective::getSourceRange);
     case OMPTaskLoopSimdDirectiveClass:
      return StmtStatics.<OMPTaskLoopSimdDirective>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/OMPTaskLoopSimdDirective::getSourceRange);
     case OMPMasterDirectiveClass:
      return StmtStatics.<OMPMasterDirective>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/OMPMasterDirective::getSourceRange);
     case OMPOrderedDirectiveClass:
      return StmtStatics.<OMPOrderedDirective>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/OMPOrderedDirective::getSourceRange);
     case OMPParallelDirectiveClass:
      return StmtStatics.<OMPParallelDirective>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/OMPParallelDirective::getSourceRange);
     case OMPParallelSectionsDirectiveClass:
      return StmtStatics.<OMPParallelSectionsDirective>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/OMPParallelSectionsDirective::getSourceRange);
     case OMPSectionDirectiveClass:
      return StmtStatics.<OMPSectionDirective>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/OMPSectionDirective::getSourceRange);
     case OMPSectionsDirectiveClass:
      return StmtStatics.<OMPSectionsDirective>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/OMPSectionsDirective::getSourceRange);
     case OMPSingleDirectiveClass:
      return StmtStatics.<OMPSingleDirective>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/OMPSingleDirective::getSourceRange);
     case OMPTargetDataDirectiveClass:
      return StmtStatics.<OMPTargetDataDirective>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/OMPTargetDataDirective::getSourceRange);
     case OMPTargetDirectiveClass:
      return StmtStatics.<OMPTargetDirective>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/OMPTargetDirective::getSourceRange);
     case OMPTargetEnterDataDirectiveClass:
      return StmtStatics.<OMPTargetEnterDataDirective>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/OMPTargetEnterDataDirective::getSourceRange);
     case OMPTargetExitDataDirectiveClass:
      return StmtStatics.<OMPTargetExitDataDirective>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/OMPTargetExitDataDirective::getSourceRange);
     case OMPTargetParallelDirectiveClass:
      return StmtStatics.<OMPTargetParallelDirective>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/OMPTargetParallelDirective::getSourceRange);
     case OMPTargetParallelForDirectiveClass:
      return StmtStatics.<OMPTargetParallelForDirective>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/OMPTargetParallelForDirective::getSourceRange);
     case OMPTargetUpdateDirectiveClass:
      return StmtStatics.<OMPTargetUpdateDirective>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/OMPTargetUpdateDirective::getSourceRange);
     case OMPTaskDirectiveClass:
      return StmtStatics.<OMPTaskDirective>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/OMPTaskDirective::getSourceRange);
     case OMPTaskgroupDirectiveClass:
      return StmtStatics.<OMPTaskgroupDirective>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/OMPTaskgroupDirective::getSourceRange);
     case OMPTaskwaitDirectiveClass:
      return StmtStatics.<OMPTaskwaitDirective>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/OMPTaskwaitDirective::getSourceRange);
     case OMPTaskyieldDirectiveClass:
      return StmtStatics.<OMPTaskyieldDirective>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/OMPTaskyieldDirective::getSourceRange);
     case OMPTeamsDirectiveClass:
      return StmtStatics.<OMPTeamsDirective>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/OMPTeamsDirective::getSourceRange);
     case ObjCAtCatchStmtClass:
      return StmtStatics.<ObjCAtCatchStmt>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/ObjCAtCatchStmt::getSourceRange);
     case ObjCAtFinallyStmtClass:
      return StmtStatics.<ObjCAtFinallyStmt>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/ObjCAtFinallyStmt::getSourceRange);
     case ObjCAtSynchronizedStmtClass:
      return StmtStatics.<ObjCAtSynchronizedStmt>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/ObjCAtSynchronizedStmt::getSourceRange);
     case ObjCAtThrowStmtClass:
      return StmtStatics.<ObjCAtThrowStmt>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/ObjCAtThrowStmt::getSourceRange);
     case ObjCAtTryStmtClass:
      return StmtStatics.<ObjCAtTryStmt>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/ObjCAtTryStmt::getSourceRange);
     case ObjCAutoreleasePoolStmtClass:
      return StmtStatics.<ObjCAutoreleasePoolStmt>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/ObjCAutoreleasePoolStmt::getSourceRange);
     case ObjCForCollectionStmtClass:
      return StmtStatics.<ObjCForCollectionStmt>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/ObjCForCollectionStmt::getSourceRange);
     case ReturnStmtClass:
      return StmtStatics.<ReturnStmt>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/ReturnStmt::getSourceRange);
     case SEHExceptStmtClass:
      return StmtStatics.<SEHExceptStmt>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/SEHExceptStmt::getSourceRange);
     case SEHFinallyStmtClass:
      return StmtStatics.<SEHFinallyStmt>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/SEHFinallyStmt::getSourceRange);
     case SEHLeaveStmtClass:
      return StmtStatics.<SEHLeaveStmt>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/SEHLeaveStmt::getSourceRange);
     case SEHTryStmtClass:
      return StmtStatics.<SEHTryStmt>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/SEHTryStmt::getSourceRange);
     case CaseStmtClass:
      return StmtStatics.<CaseStmt>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/CaseStmt::getSourceRange);
     case DefaultStmtClass:
      return StmtStatics.<DefaultStmt>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/DefaultStmt::getSourceRange);
     case SwitchStmtClass:
      return StmtStatics.<SwitchStmt>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/SwitchStmt::getSourceRange);
     case WhileStmtClass:
      return StmtStatics.<WhileStmt>getSourceRangeImpl$Stmt(this, /*AddrOf*//*FPtr*/WhileStmt::getSourceRange);
    }
    throw new llvm_unreachable("unknown statement kind!");
  }


  //<editor-fold defaultstate="collapsed" desc="clang::Stmt::getLocStart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp", line = 257,
   FQN="clang::Stmt::getLocStart", NM="_ZNK5clang4Stmt11getLocStartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang4Stmt11getLocStartEv")
  //</editor-fold>
  public SourceLocation getLocStart() /*const*//* __attribute__((pure))*/ {
    //  llvm::errs() << "getLocStart() for " << getStmtClassName() << "\n";
    switch (getStmtClass()) {
     case NoStmtClass:
      throw new llvm_unreachable("statement without class");
     case GCCAsmStmtClass:
      return ((/*static_cast*//*const*/ GCCAsmStmt /*P*/ )(this)).getLocStart();
     case MSAsmStmtClass:
      return ((/*static_cast*//*const*/ MSAsmStmt /*P*/ )(this)).getLocStart();
     case AttributedStmtClass:
      return ((/*static_cast*//*const*/ AttributedStmt /*P*/ )(this)).getLocStart();
     case BreakStmtClass:
      return ((/*static_cast*//*const*/ BreakStmt /*P*/ )(this)).getLocStart();
     case CXXCatchStmtClass:
      return ((/*static_cast*//*const*/ CXXCatchStmt /*P*/ )(this)).getLocStart();
     case CXXForRangeStmtClass:
      return ((/*static_cast*//*const*/ CXXForRangeStmt /*P*/ )(this)).getLocStart();
     case CXXTryStmtClass:
      return ((/*static_cast*//*const*/ CXXTryStmt /*P*/ )(this)).getLocStart();
     case CapturedStmtClass:
      return ((/*static_cast*//*const*/ CapturedStmt /*P*/ )(this)).getLocStart();
     case CompoundStmtClass:
      return ((/*static_cast*//*const*/ CompoundStmt /*P*/ )(this)).getLocStart();
     case ContinueStmtClass:
      return ((/*static_cast*//*const*/ ContinueStmt /*P*/ )(this)).getLocStart();
     case CoreturnStmtClass:
      return ((/*static_cast*//*const*/ CoreturnStmt /*P*/ )(this)).getLocStart();
     case CoroutineBodyStmtClass:
      return ((/*static_cast*//*const*/ CoroutineBodyStmt /*P*/ )(this)).getLocStart();
     case DeclStmtClass:
      return ((/*static_cast*//*const*/ DeclStmt /*P*/ )(this)).getLocStart();
     case DoStmtClass:
      return ((/*static_cast*//*const*/ DoStmt /*P*/ )(this)).getLocStart();
     case BinaryConditionalOperatorClass:
      return ((/*static_cast*//*const*/ BinaryConditionalOperator /*P*/ )(this)).getLocStart();
     case ConditionalOperatorClass:
      return ((/*static_cast*//*const*/ ConditionalOperator /*P*/ )(this)).getLocStart();
     case AddrLabelExprClass:
      return ((/*static_cast*//*const*/ AddrLabelExpr /*P*/ )(this)).getLocStart();
     case ArraySubscriptExprClass:
      return ((/*static_cast*//*const*/ ArraySubscriptExpr /*P*/ )(this)).getLocStart();
     case ArrayTypeTraitExprClass:
      return ((/*static_cast*//*const*/ ArrayTypeTraitExpr /*P*/ )(this)).getLocStart();
     case AsTypeExprClass:
      return ((/*static_cast*//*const*/ AsTypeExpr /*P*/ )(this)).getLocStart();
     case AtomicExprClass:
      return ((/*static_cast*//*const*/ AtomicExpr /*P*/ )(this)).getLocStart();
     case BinaryOperatorClass:
      return ((/*static_cast*//*const*/ BinaryOperator /*P*/ )(this)).getLocStart();
     case CompoundAssignOperatorClass:
      return ((/*static_cast*//*const*/ CompoundAssignOperator /*P*/ )(this)).getLocStart();
     case BlockExprClass:
      return ((/*static_cast*//*const*/ BlockExpr /*P*/ )(this)).getLocStart();
     case CXXBindTemporaryExprClass:
      return ((/*static_cast*//*const*/ CXXBindTemporaryExpr /*P*/ )(this)).getLocStart();
     case CXXBoolLiteralExprClass:
      return ((/*static_cast*//*const*/ CXXBoolLiteralExpr /*P*/ )(this)).getLocStart();
     case CXXConstructExprClass:
      return ((/*static_cast*//*const*/ CXXConstructExpr /*P*/ )(this)).getLocStart();
     case CXXTemporaryObjectExprClass:
      return ((/*static_cast*//*const*/ CXXTemporaryObjectExpr /*P*/ )(this)).getLocStart();
     case CXXDefaultArgExprClass:
      return ((/*static_cast*//*const*/ CXXDefaultArgExpr /*P*/ )(this)).getLocStart();
     case CXXDefaultInitExprClass:
      return ((/*static_cast*//*const*/ CXXDefaultInitExpr /*P*/ )(this)).getLocStart();
     case CXXDeleteExprClass:
      return ((/*static_cast*//*const*/ CXXDeleteExpr /*P*/ )(this)).getLocStart();
     case CXXDependentScopeMemberExprClass:
      return ((/*static_cast*//*const*/ CXXDependentScopeMemberExpr /*P*/ )(this)).getLocStart();
     case CXXFoldExprClass:
      return ((/*static_cast*//*const*/ CXXFoldExpr /*P*/ )(this)).getLocStart();
     case CXXInheritedCtorInitExprClass:
      return ((/*static_cast*//*const*/ CXXInheritedCtorInitExpr /*P*/ )(this)).getLocStart();
     case CXXNewExprClass:
      return ((/*static_cast*//*const*/ CXXNewExpr /*P*/ )(this)).getLocStart();
     case CXXNoexceptExprClass:
      return ((/*static_cast*//*const*/ CXXNoexceptExpr /*P*/ )(this)).getLocStart();
     case CXXNullPtrLiteralExprClass:
      return ((/*static_cast*//*const*/ CXXNullPtrLiteralExpr /*P*/ )(this)).getLocStart();
     case CXXPseudoDestructorExprClass:
      return ((/*static_cast*//*const*/ CXXPseudoDestructorExpr /*P*/ )(this)).getLocStart();
     case CXXScalarValueInitExprClass:
      return ((/*static_cast*//*const*/ CXXScalarValueInitExpr /*P*/ )(this)).getLocStart();
     case CXXStdInitializerListExprClass:
      return ((/*static_cast*//*const*/ CXXStdInitializerListExpr /*P*/ )(this)).getLocStart();
     case CXXThisExprClass:
      return ((/*static_cast*//*const*/ CXXThisExpr /*P*/ )(this)).getLocStart();
     case CXXThrowExprClass:
      return ((/*static_cast*//*const*/ CXXThrowExpr /*P*/ )(this)).getLocStart();
     case CXXTypeidExprClass:
      return ((/*static_cast*//*const*/ CXXTypeidExpr /*P*/ )(this)).getLocStart();
     case CXXUnresolvedConstructExprClass:
      return ((/*static_cast*//*const*/ CXXUnresolvedConstructExpr /*P*/ )(this)).getLocStart();
     case CXXUuidofExprClass:
      return ((/*static_cast*//*const*/ CXXUuidofExpr /*P*/ )(this)).getLocStart();
     case CallExprClass:
      return ((/*static_cast*//*const*/ CallExpr /*P*/ )(this)).getLocStart();
     case CUDAKernelCallExprClass:
      return ((/*static_cast*//*const*/ CUDAKernelCallExpr /*P*/ )(this)).getLocStart();
     case CXXMemberCallExprClass:
      return ((/*static_cast*//*const*/ CXXMemberCallExpr /*P*/ )(this)).getLocStart();
     case CXXOperatorCallExprClass:
      return ((/*static_cast*//*const*/ CXXOperatorCallExpr /*P*/ )(this)).getLocStart();
     case UserDefinedLiteralClass:
      return ((/*static_cast*//*const*/ UserDefinedLiteral /*P*/ )(this)).getLocStart();
     case CStyleCastExprClass:
      return ((/*static_cast*//*const*/ CStyleCastExpr /*P*/ )(this)).getLocStart();
     case CXXFunctionalCastExprClass:
      return ((/*static_cast*//*const*/ CXXFunctionalCastExpr /*P*/ )(this)).getLocStart();
     case CXXConstCastExprClass:
      return ((/*static_cast*//*const*/ CXXConstCastExpr /*P*/ )(this)).getLocStart();
     case CXXDynamicCastExprClass:
      return ((/*static_cast*//*const*/ CXXDynamicCastExpr /*P*/ )(this)).getLocStart();
     case CXXReinterpretCastExprClass:
      return ((/*static_cast*//*const*/ CXXReinterpretCastExpr /*P*/ )(this)).getLocStart();
     case CXXStaticCastExprClass:
      return ((/*static_cast*//*const*/ CXXStaticCastExpr /*P*/ )(this)).getLocStart();
     case ObjCBridgedCastExprClass:
      return ((/*static_cast*//*const*/ ObjCBridgedCastExpr /*P*/ )(this)).getLocStart();
     case ImplicitCastExprClass:
      return ((/*static_cast*//*const*/ ImplicitCastExpr /*P*/ )(this)).getLocStart();
     case CharacterLiteralClass:
      return ((/*static_cast*//*const*/ CharacterLiteral /*P*/ )(this)).getLocStart();
     case ChooseExprClass:
      return ((/*static_cast*//*const*/ ChooseExpr /*P*/ )(this)).getLocStart();
     case CompoundLiteralExprClass:
      return ((/*static_cast*//*const*/ CompoundLiteralExpr /*P*/ )(this)).getLocStart();
     case ConvertVectorExprClass:
      return ((/*static_cast*//*const*/ ConvertVectorExpr /*P*/ )(this)).getLocStart();
     case CoawaitExprClass:
      return ((/*static_cast*//*const*/ CoawaitExpr /*P*/ )(this)).getLocStart();
     case CoyieldExprClass:
      return ((/*static_cast*//*const*/ CoyieldExpr /*P*/ )(this)).getLocStart();
     case DeclRefExprClass:
      return ((/*static_cast*//*const*/ DeclRefExpr /*P*/ )(this)).getLocStart();
     case DependentScopeDeclRefExprClass:
      return ((/*static_cast*//*const*/ DependentScopeDeclRefExpr /*P*/ )(this)).getLocStart();
     case DesignatedInitExprClass:
      return ((/*static_cast*//*const*/ DesignatedInitExpr /*P*/ )(this)).getLocStart();
     case DesignatedInitUpdateExprClass:
      return ((/*static_cast*//*const*/ DesignatedInitUpdateExpr /*P*/ )(this)).getLocStart();
     case ExprWithCleanupsClass:
      return ((/*static_cast*//*const*/ ExprWithCleanups /*P*/ )(this)).getLocStart();
     case ExpressionTraitExprClass:
      return ((/*static_cast*//*const*/ ExpressionTraitExpr /*P*/ )(this)).getLocStart();
     case ExtVectorElementExprClass:
      return ((/*static_cast*//*const*/ ExtVectorElementExpr /*P*/ )(this)).getLocStart();
     case FloatingLiteralClass:
      return ((/*static_cast*//*const*/ FloatingLiteral /*P*/ )(this)).getLocStart();
     case FunctionParmPackExprClass:
      return ((/*static_cast*//*const*/ FunctionParmPackExpr /*P*/ )(this)).getLocStart();
     case GNUNullExprClass:
      return ((/*static_cast*//*const*/ GNUNullExpr /*P*/ )(this)).getLocStart();
     case GenericSelectionExprClass:
      return ((/*static_cast*//*const*/ GenericSelectionExpr /*P*/ )(this)).getLocStart();
     case ImaginaryLiteralClass:
      return ((/*static_cast*//*const*/ ImaginaryLiteral /*P*/ )(this)).getLocStart();
     case ImplicitValueInitExprClass:
      return ((/*static_cast*//*const*/ ImplicitValueInitExpr /*P*/ )(this)).getLocStart();
     case InitListExprClass:
      return ((/*static_cast*//*const*/ InitListExpr /*P*/ )(this)).getLocStart();
     case IntegerLiteralClass:
      return ((/*static_cast*//*const*/ IntegerLiteral /*P*/ )(this)).getLocStart();
     case LambdaExprClass:
      return ((/*static_cast*//*const*/ LambdaExpr /*P*/ )(this)).getLocStart();
     case MSPropertyRefExprClass:
      return ((/*static_cast*//*const*/ MSPropertyRefExpr /*P*/ )(this)).getLocStart();
     case MSPropertySubscriptExprClass:
      return ((/*static_cast*//*const*/ MSPropertySubscriptExpr /*P*/ )(this)).getLocStart();
     case MaterializeTemporaryExprClass:
      return ((/*static_cast*//*const*/ MaterializeTemporaryExpr /*P*/ )(this)).getLocStart();
     case MemberExprClass:
      return ((/*static_cast*//*const*/ MemberExpr /*P*/ )(this)).getLocStart();
     case NoInitExprClass:
      return ((/*static_cast*//*const*/ NoInitExpr /*P*/ )(this)).getLocStart();
     case OMPArraySectionExprClass:
      return ((/*static_cast*//*const*/ OMPArraySectionExpr /*P*/ )(this)).getLocStart();
     case ObjCArrayLiteralClass:
      return ((/*static_cast*//*const*/ ObjCArrayLiteral /*P*/ )(this)).getLocStart();
     case ObjCAvailabilityCheckExprClass:
      return ((/*static_cast*//*const*/ ObjCAvailabilityCheckExpr /*P*/ )(this)).getLocStart();
     case ObjCBoolLiteralExprClass:
      return ((/*static_cast*//*const*/ ObjCBoolLiteralExpr /*P*/ )(this)).getLocStart();
     case ObjCBoxedExprClass:
      return ((/*static_cast*//*const*/ ObjCBoxedExpr /*P*/ )(this)).getLocStart();
     case ObjCDictionaryLiteralClass:
      return ((/*static_cast*//*const*/ ObjCDictionaryLiteral /*P*/ )(this)).getLocStart();
     case ObjCEncodeExprClass:
      return ((/*static_cast*//*const*/ ObjCEncodeExpr /*P*/ )(this)).getLocStart();
     case ObjCIndirectCopyRestoreExprClass:
      return ((/*static_cast*//*const*/ ObjCIndirectCopyRestoreExpr /*P*/ )(this)).getLocStart();
     case ObjCIsaExprClass:
      return ((/*static_cast*//*const*/ ObjCIsaExpr /*P*/ )(this)).getLocStart();
     case ObjCIvarRefExprClass:
      return ((/*static_cast*//*const*/ ObjCIvarRefExpr /*P*/ )(this)).getLocStart();
     case ObjCMessageExprClass:
      return ((/*static_cast*//*const*/ ObjCMessageExpr /*P*/ )(this)).getLocStart();
     case ObjCPropertyRefExprClass:
      return ((/*static_cast*//*const*/ ObjCPropertyRefExpr /*P*/ )(this)).getLocStart();
     case ObjCProtocolExprClass:
      return ((/*static_cast*//*const*/ ObjCProtocolExpr /*P*/ )(this)).getLocStart();
     case ObjCSelectorExprClass:
      return ((/*static_cast*//*const*/ ObjCSelectorExpr /*P*/ )(this)).getLocStart();
     case ObjCStringLiteralClass:
      return ((/*static_cast*//*const*/ ObjCStringLiteral /*P*/ )(this)).getLocStart();
     case ObjCSubscriptRefExprClass:
      return ((/*static_cast*//*const*/ ObjCSubscriptRefExpr /*P*/ )(this)).getLocStart();
     case OffsetOfExprClass:
      return ((/*static_cast*//*const*/ OffsetOfExpr /*P*/ )(this)).getLocStart();
     case OpaqueValueExprClass:
      return ((/*static_cast*//*const*/ OpaqueValueExpr /*P*/ )(this)).getLocStart();
     case UnresolvedLookupExprClass:
      return ((/*static_cast*//*const*/ UnresolvedLookupExpr /*P*/ )(this)).getLocStart();
     case UnresolvedMemberExprClass:
      return ((/*static_cast*//*const*/ UnresolvedMemberExpr /*P*/ )(this)).getLocStart();
     case PackExpansionExprClass:
      return ((/*static_cast*//*const*/ PackExpansionExpr /*P*/ )(this)).getLocStart();
     case ParenExprClass:
      return ((/*static_cast*//*const*/ ParenExpr /*P*/ )(this)).getLocStart();
     case ParenListExprClass:
      return ((/*static_cast*//*const*/ ParenListExpr /*P*/ )(this)).getLocStart();
     case PredefinedExprClass:
      return ((/*static_cast*//*const*/ PredefinedExpr /*P*/ )(this)).getLocStart();
     case PseudoObjectExprClass:
      return ((/*static_cast*//*const*/ PseudoObjectExpr /*P*/ )(this)).getLocStart();
     case ShuffleVectorExprClass:
      return ((/*static_cast*//*const*/ ShuffleVectorExpr /*P*/ )(this)).getLocStart();
     case SizeOfPackExprClass:
      return ((/*static_cast*//*const*/ SizeOfPackExpr /*P*/ )(this)).getLocStart();
     case StmtExprClass:
      return ((/*static_cast*//*const*/ StmtExpr /*P*/ )(this)).getLocStart();
     case StringLiteralClass:
      return ((/*static_cast*//*const*/ StringLiteral /*P*/ )(this)).getLocStart();
     case SubstNonTypeTemplateParmExprClass:
      return ((/*static_cast*//*const*/ SubstNonTypeTemplateParmExpr /*P*/ )(this)).getLocStart();
     case SubstNonTypeTemplateParmPackExprClass:
      return ((/*static_cast*//*const*/ SubstNonTypeTemplateParmPackExpr /*P*/ )(this)).getLocStart();
     case TypeTraitExprClass:
      return ((/*static_cast*//*const*/ TypeTraitExpr /*P*/ )(this)).getLocStart();
     case TypoExprClass:
      return ((/*static_cast*//*const*/ TypoExpr /*P*/ )(this)).getLocStart();
     case UnaryExprOrTypeTraitExprClass:
      return ((/*static_cast*//*const*/ UnaryExprOrTypeTraitExpr /*P*/ )(this)).getLocStart();
     case UnaryOperatorClass:
      return ((/*static_cast*//*const*/ UnaryOperator /*P*/ )(this)).getLocStart();
     case VAArgExprClass:
      return ((/*static_cast*//*const*/ VAArgExpr /*P*/ )(this)).getLocStart();
     case ForStmtClass:
      return ((/*static_cast*//*const*/ ForStmt /*P*/ )(this)).getLocStart();
     case GotoStmtClass:
      return ((/*static_cast*//*const*/ GotoStmt /*P*/ )(this)).getLocStart();
     case IfStmtClass:
      return ((/*static_cast*//*const*/ IfStmt /*P*/ )(this)).getLocStart();
     case IndirectGotoStmtClass:
      return ((/*static_cast*//*const*/ IndirectGotoStmt /*P*/ )(this)).getLocStart();
     case LabelStmtClass:
      return ((/*static_cast*//*const*/ LabelStmt /*P*/ )(this)).getLocStart();
     case MSDependentExistsStmtClass:
      return ((/*static_cast*//*const*/ MSDependentExistsStmt /*P*/ )(this)).getLocStart();
     case NullStmtClass:
      return ((/*static_cast*//*const*/ NullStmt /*P*/ )(this)).getLocStart();
     case OMPAtomicDirectiveClass:
      return ((/*static_cast*//*const*/ OMPAtomicDirective /*P*/ )(this)).getLocStart();
     case OMPBarrierDirectiveClass:
      return ((/*static_cast*//*const*/ OMPBarrierDirective /*P*/ )(this)).getLocStart();
     case OMPCancelDirectiveClass:
      return ((/*static_cast*//*const*/ OMPCancelDirective /*P*/ )(this)).getLocStart();
     case OMPCancellationPointDirectiveClass:
      return ((/*static_cast*//*const*/ OMPCancellationPointDirective /*P*/ )(this)).getLocStart();
     case OMPCriticalDirectiveClass:
      return ((/*static_cast*//*const*/ OMPCriticalDirective /*P*/ )(this)).getLocStart();
     case OMPFlushDirectiveClass:
      return ((/*static_cast*//*const*/ OMPFlushDirective /*P*/ )(this)).getLocStart();
     case OMPDistributeDirectiveClass:
      return ((/*static_cast*//*const*/ OMPDistributeDirective /*P*/ )(this)).getLocStart();
     case OMPDistributeParallelForDirectiveClass:
      return ((/*static_cast*//*const*/ OMPDistributeParallelForDirective /*P*/ )(this)).getLocStart();
     case OMPDistributeParallelForSimdDirectiveClass:
      return ((/*static_cast*//*const*/ OMPDistributeParallelForSimdDirective /*P*/ )(this)).getLocStart();
     case OMPDistributeSimdDirectiveClass:
      return ((/*static_cast*//*const*/ OMPDistributeSimdDirective /*P*/ )(this)).getLocStart();
     case OMPForDirectiveClass:
      return ((/*static_cast*//*const*/ OMPForDirective /*P*/ )(this)).getLocStart();
     case OMPForSimdDirectiveClass:
      return ((/*static_cast*//*const*/ OMPForSimdDirective /*P*/ )(this)).getLocStart();
     case OMPParallelForDirectiveClass:
      return ((/*static_cast*//*const*/ OMPParallelForDirective /*P*/ )(this)).getLocStart();
     case OMPParallelForSimdDirectiveClass:
      return ((/*static_cast*//*const*/ OMPParallelForSimdDirective /*P*/ )(this)).getLocStart();
     case OMPSimdDirectiveClass:
      return ((/*static_cast*//*const*/ OMPSimdDirective /*P*/ )(this)).getLocStart();
     case OMPTargetParallelForSimdDirectiveClass:
      return ((/*static_cast*//*const*/ OMPTargetParallelForSimdDirective /*P*/ )(this)).getLocStart();
     case OMPTaskLoopDirectiveClass:
      return ((/*static_cast*//*const*/ OMPTaskLoopDirective /*P*/ )(this)).getLocStart();
     case OMPTaskLoopSimdDirectiveClass:
      return ((/*static_cast*//*const*/ OMPTaskLoopSimdDirective /*P*/ )(this)).getLocStart();
     case OMPMasterDirectiveClass:
      return ((/*static_cast*//*const*/ OMPMasterDirective /*P*/ )(this)).getLocStart();
     case OMPOrderedDirectiveClass:
      return ((/*static_cast*//*const*/ OMPOrderedDirective /*P*/ )(this)).getLocStart();
     case OMPParallelDirectiveClass:
      return ((/*static_cast*//*const*/ OMPParallelDirective /*P*/ )(this)).getLocStart();
     case OMPParallelSectionsDirectiveClass:
      return ((/*static_cast*//*const*/ OMPParallelSectionsDirective /*P*/ )(this)).getLocStart();
     case OMPSectionDirectiveClass:
      return ((/*static_cast*//*const*/ OMPSectionDirective /*P*/ )(this)).getLocStart();
     case OMPSectionsDirectiveClass:
      return ((/*static_cast*//*const*/ OMPSectionsDirective /*P*/ )(this)).getLocStart();
     case OMPSingleDirectiveClass:
      return ((/*static_cast*//*const*/ OMPSingleDirective /*P*/ )(this)).getLocStart();
     case OMPTargetDataDirectiveClass:
      return ((/*static_cast*//*const*/ OMPTargetDataDirective /*P*/ )(this)).getLocStart();
     case OMPTargetDirectiveClass:
      return ((/*static_cast*//*const*/ OMPTargetDirective /*P*/ )(this)).getLocStart();
     case OMPTargetEnterDataDirectiveClass:
      return ((/*static_cast*//*const*/ OMPTargetEnterDataDirective /*P*/ )(this)).getLocStart();
     case OMPTargetExitDataDirectiveClass:
      return ((/*static_cast*//*const*/ OMPTargetExitDataDirective /*P*/ )(this)).getLocStart();
     case OMPTargetParallelDirectiveClass:
      return ((/*static_cast*//*const*/ OMPTargetParallelDirective /*P*/ )(this)).getLocStart();
     case OMPTargetParallelForDirectiveClass:
      return ((/*static_cast*//*const*/ OMPTargetParallelForDirective /*P*/ )(this)).getLocStart();
     case OMPTargetUpdateDirectiveClass:
      return ((/*static_cast*//*const*/ OMPTargetUpdateDirective /*P*/ )(this)).getLocStart();
     case OMPTaskDirectiveClass:
      return ((/*static_cast*//*const*/ OMPTaskDirective /*P*/ )(this)).getLocStart();
     case OMPTaskgroupDirectiveClass:
      return ((/*static_cast*//*const*/ OMPTaskgroupDirective /*P*/ )(this)).getLocStart();
     case OMPTaskwaitDirectiveClass:
      return ((/*static_cast*//*const*/ OMPTaskwaitDirective /*P*/ )(this)).getLocStart();
     case OMPTaskyieldDirectiveClass:
      return ((/*static_cast*//*const*/ OMPTaskyieldDirective /*P*/ )(this)).getLocStart();
     case OMPTeamsDirectiveClass:
      return ((/*static_cast*//*const*/ OMPTeamsDirective /*P*/ )(this)).getLocStart();
     case ObjCAtCatchStmtClass:
      return ((/*static_cast*//*const*/ ObjCAtCatchStmt /*P*/ )(this)).getLocStart();
     case ObjCAtFinallyStmtClass:
      return ((/*static_cast*//*const*/ ObjCAtFinallyStmt /*P*/ )(this)).getLocStart();
     case ObjCAtSynchronizedStmtClass:
      return ((/*static_cast*//*const*/ ObjCAtSynchronizedStmt /*P*/ )(this)).getLocStart();
     case ObjCAtThrowStmtClass:
      return ((/*static_cast*//*const*/ ObjCAtThrowStmt /*P*/ )(this)).getLocStart();
     case ObjCAtTryStmtClass:
      return ((/*static_cast*//*const*/ ObjCAtTryStmt /*P*/ )(this)).getLocStart();
     case ObjCAutoreleasePoolStmtClass:
      return ((/*static_cast*//*const*/ ObjCAutoreleasePoolStmt /*P*/ )(this)).getLocStart();
     case ObjCForCollectionStmtClass:
      return ((/*static_cast*//*const*/ ObjCForCollectionStmt /*P*/ )(this)).getLocStart();
     case ReturnStmtClass:
      return ((/*static_cast*//*const*/ ReturnStmt /*P*/ )(this)).getLocStart();
     case SEHExceptStmtClass:
      return ((/*static_cast*//*const*/ SEHExceptStmt /*P*/ )(this)).getLocStart();
     case SEHFinallyStmtClass:
      return ((/*static_cast*//*const*/ SEHFinallyStmt /*P*/ )(this)).getLocStart();
     case SEHLeaveStmtClass:
      return ((/*static_cast*//*const*/ SEHLeaveStmt /*P*/ )(this)).getLocStart();
     case SEHTryStmtClass:
      return ((/*static_cast*//*const*/ SEHTryStmt /*P*/ )(this)).getLocStart();
     case CaseStmtClass:
      return ((/*static_cast*//*const*/ CaseStmt /*P*/ )(this)).getLocStart();
     case DefaultStmtClass:
      return ((/*static_cast*//*const*/ DefaultStmt /*P*/ )(this)).getLocStart();
     case SwitchStmtClass:
      return ((/*static_cast*//*const*/ SwitchStmt /*P*/ )(this)).getLocStart();
     case WhileStmtClass:
      return ((/*static_cast*//*const*/ WhileStmt /*P*/ )(this)).getLocStart();
    }
    throw new llvm_unreachable("unknown statement kind");
  }


  //<editor-fold defaultstate="collapsed" desc="clang::Stmt::getLocEnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp", line = 270,
   FQN="clang::Stmt::getLocEnd", NM="_ZNK5clang4Stmt9getLocEndEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang4Stmt9getLocEndEv")
  //</editor-fold>
  public SourceLocation getLocEnd() /*const*//* __attribute__((pure))*/ {
    switch (getStmtClass()) {
     case NoStmtClass:
      throw new llvm_unreachable("statement without class");
     case GCCAsmStmtClass:
      return ((/*static_cast*//*const*/ GCCAsmStmt /*P*/ )(this)).getLocEnd();
     case MSAsmStmtClass:
      return ((/*static_cast*//*const*/ MSAsmStmt /*P*/ )(this)).getLocEnd();
     case AttributedStmtClass:
      return ((/*static_cast*//*const*/ AttributedStmt /*P*/ )(this)).getLocEnd();
     case BreakStmtClass:
      return ((/*static_cast*//*const*/ BreakStmt /*P*/ )(this)).getLocEnd();
     case CXXCatchStmtClass:
      return ((/*static_cast*//*const*/ CXXCatchStmt /*P*/ )(this)).getLocEnd();
     case CXXForRangeStmtClass:
      return ((/*static_cast*//*const*/ CXXForRangeStmt /*P*/ )(this)).getLocEnd();
     case CXXTryStmtClass:
      return ((/*static_cast*//*const*/ CXXTryStmt /*P*/ )(this)).getLocEnd();
     case CapturedStmtClass:
      return ((/*static_cast*//*const*/ CapturedStmt /*P*/ )(this)).getLocEnd();
     case CompoundStmtClass:
      return ((/*static_cast*//*const*/ CompoundStmt /*P*/ )(this)).getLocEnd();
     case ContinueStmtClass:
      return ((/*static_cast*//*const*/ ContinueStmt /*P*/ )(this)).getLocEnd();
     case CoreturnStmtClass:
      return ((/*static_cast*//*const*/ CoreturnStmt /*P*/ )(this)).getLocEnd();
     case CoroutineBodyStmtClass:
      return ((/*static_cast*//*const*/ CoroutineBodyStmt /*P*/ )(this)).getLocEnd();
     case DeclStmtClass:
      return ((/*static_cast*//*const*/ DeclStmt /*P*/ )(this)).getLocEnd();
     case DoStmtClass:
      return ((/*static_cast*//*const*/ DoStmt /*P*/ )(this)).getLocEnd();
     case BinaryConditionalOperatorClass:
      return ((/*static_cast*//*const*/ BinaryConditionalOperator /*P*/ )(this)).getLocEnd();
     case ConditionalOperatorClass:
      return ((/*static_cast*//*const*/ ConditionalOperator /*P*/ )(this)).getLocEnd();
     case AddrLabelExprClass:
      return ((/*static_cast*//*const*/ AddrLabelExpr /*P*/ )(this)).getLocEnd();
     case ArraySubscriptExprClass:
      return ((/*static_cast*//*const*/ ArraySubscriptExpr /*P*/ )(this)).getLocEnd();
     case ArrayTypeTraitExprClass:
      return ((/*static_cast*//*const*/ ArrayTypeTraitExpr /*P*/ )(this)).getLocEnd();
     case AsTypeExprClass:
      return ((/*static_cast*//*const*/ AsTypeExpr /*P*/ )(this)).getLocEnd();
     case AtomicExprClass:
      return ((/*static_cast*//*const*/ AtomicExpr /*P*/ )(this)).getLocEnd();
     case BinaryOperatorClass:
      return ((/*static_cast*//*const*/ BinaryOperator /*P*/ )(this)).getLocEnd();
     case CompoundAssignOperatorClass:
      return ((/*static_cast*//*const*/ CompoundAssignOperator /*P*/ )(this)).getLocEnd();
     case BlockExprClass:
      return ((/*static_cast*//*const*/ BlockExpr /*P*/ )(this)).getLocEnd();
     case CXXBindTemporaryExprClass:
      return ((/*static_cast*//*const*/ CXXBindTemporaryExpr /*P*/ )(this)).getLocEnd();
     case CXXBoolLiteralExprClass:
      return ((/*static_cast*//*const*/ CXXBoolLiteralExpr /*P*/ )(this)).getLocEnd();
     case CXXConstructExprClass:
      return ((/*static_cast*//*const*/ CXXConstructExpr /*P*/ )(this)).getLocEnd();
     case CXXTemporaryObjectExprClass:
      return ((/*static_cast*//*const*/ CXXTemporaryObjectExpr /*P*/ )(this)).getLocEnd();
     case CXXDefaultArgExprClass:
      return ((/*static_cast*//*const*/ CXXDefaultArgExpr /*P*/ )(this)).getLocEnd();
     case CXXDefaultInitExprClass:
      return ((/*static_cast*//*const*/ CXXDefaultInitExpr /*P*/ )(this)).getLocEnd();
     case CXXDeleteExprClass:
      return ((/*static_cast*//*const*/ CXXDeleteExpr /*P*/ )(this)).getLocEnd();
     case CXXDependentScopeMemberExprClass:
      return ((/*static_cast*//*const*/ CXXDependentScopeMemberExpr /*P*/ )(this)).getLocEnd();
     case CXXFoldExprClass:
      return ((/*static_cast*//*const*/ CXXFoldExpr /*P*/ )(this)).getLocEnd();
     case CXXInheritedCtorInitExprClass:
      return ((/*static_cast*//*const*/ CXXInheritedCtorInitExpr /*P*/ )(this)).getLocEnd();
     case CXXNewExprClass:
      return ((/*static_cast*//*const*/ CXXNewExpr /*P*/ )(this)).getLocEnd();
     case CXXNoexceptExprClass:
      return ((/*static_cast*//*const*/ CXXNoexceptExpr /*P*/ )(this)).getLocEnd();
     case CXXNullPtrLiteralExprClass:
      return ((/*static_cast*//*const*/ CXXNullPtrLiteralExpr /*P*/ )(this)).getLocEnd();
     case CXXPseudoDestructorExprClass:
      return ((/*static_cast*//*const*/ CXXPseudoDestructorExpr /*P*/ )(this)).getLocEnd();
     case CXXScalarValueInitExprClass:
      return ((/*static_cast*//*const*/ CXXScalarValueInitExpr /*P*/ )(this)).getLocEnd();
     case CXXStdInitializerListExprClass:
      return ((/*static_cast*//*const*/ CXXStdInitializerListExpr /*P*/ )(this)).getLocEnd();
     case CXXThisExprClass:
      return ((/*static_cast*//*const*/ CXXThisExpr /*P*/ )(this)).getLocEnd();
     case CXXThrowExprClass:
      return ((/*static_cast*//*const*/ CXXThrowExpr /*P*/ )(this)).getLocEnd();
     case CXXTypeidExprClass:
      return ((/*static_cast*//*const*/ CXXTypeidExpr /*P*/ )(this)).getLocEnd();
     case CXXUnresolvedConstructExprClass:
      return ((/*static_cast*//*const*/ CXXUnresolvedConstructExpr /*P*/ )(this)).getLocEnd();
     case CXXUuidofExprClass:
      return ((/*static_cast*//*const*/ CXXUuidofExpr /*P*/ )(this)).getLocEnd();
     case CallExprClass:
      return ((/*static_cast*//*const*/ CallExpr /*P*/ )(this)).getLocEnd();
     case CUDAKernelCallExprClass:
      return ((/*static_cast*//*const*/ CUDAKernelCallExpr /*P*/ )(this)).getLocEnd();
     case CXXMemberCallExprClass:
      return ((/*static_cast*//*const*/ CXXMemberCallExpr /*P*/ )(this)).getLocEnd();
     case CXXOperatorCallExprClass:
      return ((/*static_cast*//*const*/ CXXOperatorCallExpr /*P*/ )(this)).getLocEnd();
     case UserDefinedLiteralClass:
      return ((/*static_cast*//*const*/ UserDefinedLiteral /*P*/ )(this)).getLocEnd();
     case CStyleCastExprClass:
      return ((/*static_cast*//*const*/ CStyleCastExpr /*P*/ )(this)).getLocEnd();
     case CXXFunctionalCastExprClass:
      return ((/*static_cast*//*const*/ CXXFunctionalCastExpr /*P*/ )(this)).getLocEnd();
     case CXXConstCastExprClass:
      return ((/*static_cast*//*const*/ CXXConstCastExpr /*P*/ )(this)).getLocEnd();
     case CXXDynamicCastExprClass:
      return ((/*static_cast*//*const*/ CXXDynamicCastExpr /*P*/ )(this)).getLocEnd();
     case CXXReinterpretCastExprClass:
      return ((/*static_cast*//*const*/ CXXReinterpretCastExpr /*P*/ )(this)).getLocEnd();
     case CXXStaticCastExprClass:
      return ((/*static_cast*//*const*/ CXXStaticCastExpr /*P*/ )(this)).getLocEnd();
     case ObjCBridgedCastExprClass:
      return ((/*static_cast*//*const*/ ObjCBridgedCastExpr /*P*/ )(this)).getLocEnd();
     case ImplicitCastExprClass:
      return ((/*static_cast*//*const*/ ImplicitCastExpr /*P*/ )(this)).getLocEnd();
     case CharacterLiteralClass:
      return ((/*static_cast*//*const*/ CharacterLiteral /*P*/ )(this)).getLocEnd();
     case ChooseExprClass:
      return ((/*static_cast*//*const*/ ChooseExpr /*P*/ )(this)).getLocEnd();
     case CompoundLiteralExprClass:
      return ((/*static_cast*//*const*/ CompoundLiteralExpr /*P*/ )(this)).getLocEnd();
     case ConvertVectorExprClass:
      return ((/*static_cast*//*const*/ ConvertVectorExpr /*P*/ )(this)).getLocEnd();
     case CoawaitExprClass:
      return ((/*static_cast*//*const*/ CoawaitExpr /*P*/ )(this)).getLocEnd();
     case CoyieldExprClass:
      return ((/*static_cast*//*const*/ CoyieldExpr /*P*/ )(this)).getLocEnd();
     case DeclRefExprClass:
      return ((/*static_cast*//*const*/ DeclRefExpr /*P*/ )(this)).getLocEnd();
     case DependentScopeDeclRefExprClass:
      return ((/*static_cast*//*const*/ DependentScopeDeclRefExpr /*P*/ )(this)).getLocEnd();
     case DesignatedInitExprClass:
      return ((/*static_cast*//*const*/ DesignatedInitExpr /*P*/ )(this)).getLocEnd();
     case DesignatedInitUpdateExprClass:
      return ((/*static_cast*//*const*/ DesignatedInitUpdateExpr /*P*/ )(this)).getLocEnd();
     case ExprWithCleanupsClass:
      return ((/*static_cast*//*const*/ ExprWithCleanups /*P*/ )(this)).getLocEnd();
     case ExpressionTraitExprClass:
      return ((/*static_cast*//*const*/ ExpressionTraitExpr /*P*/ )(this)).getLocEnd();
     case ExtVectorElementExprClass:
      return ((/*static_cast*//*const*/ ExtVectorElementExpr /*P*/ )(this)).getLocEnd();
     case FloatingLiteralClass:
      return ((/*static_cast*//*const*/ FloatingLiteral /*P*/ )(this)).getLocEnd();
     case FunctionParmPackExprClass:
      return ((/*static_cast*//*const*/ FunctionParmPackExpr /*P*/ )(this)).getLocEnd();
     case GNUNullExprClass:
      return ((/*static_cast*//*const*/ GNUNullExpr /*P*/ )(this)).getLocEnd();
     case GenericSelectionExprClass:
      return ((/*static_cast*//*const*/ GenericSelectionExpr /*P*/ )(this)).getLocEnd();
     case ImaginaryLiteralClass:
      return ((/*static_cast*//*const*/ ImaginaryLiteral /*P*/ )(this)).getLocEnd();
     case ImplicitValueInitExprClass:
      return ((/*static_cast*//*const*/ ImplicitValueInitExpr /*P*/ )(this)).getLocEnd();
     case InitListExprClass:
      return ((/*static_cast*//*const*/ InitListExpr /*P*/ )(this)).getLocEnd();
     case IntegerLiteralClass:
      return ((/*static_cast*//*const*/ IntegerLiteral /*P*/ )(this)).getLocEnd();
     case LambdaExprClass:
      return ((/*static_cast*//*const*/ LambdaExpr /*P*/ )(this)).getLocEnd();
     case MSPropertyRefExprClass:
      return ((/*static_cast*//*const*/ MSPropertyRefExpr /*P*/ )(this)).getLocEnd();
     case MSPropertySubscriptExprClass:
      return ((/*static_cast*//*const*/ MSPropertySubscriptExpr /*P*/ )(this)).getLocEnd();
     case MaterializeTemporaryExprClass:
      return ((/*static_cast*//*const*/ MaterializeTemporaryExpr /*P*/ )(this)).getLocEnd();
     case MemberExprClass:
      return ((/*static_cast*//*const*/ MemberExpr /*P*/ )(this)).getLocEnd();
     case NoInitExprClass:
      return ((/*static_cast*//*const*/ NoInitExpr /*P*/ )(this)).getLocEnd();
     case OMPArraySectionExprClass:
      return ((/*static_cast*//*const*/ OMPArraySectionExpr /*P*/ )(this)).getLocEnd();
     case ObjCArrayLiteralClass:
      return ((/*static_cast*//*const*/ ObjCArrayLiteral /*P*/ )(this)).getLocEnd();
     case ObjCAvailabilityCheckExprClass:
      return ((/*static_cast*//*const*/ ObjCAvailabilityCheckExpr /*P*/ )(this)).getLocEnd();
     case ObjCBoolLiteralExprClass:
      return ((/*static_cast*//*const*/ ObjCBoolLiteralExpr /*P*/ )(this)).getLocEnd();
     case ObjCBoxedExprClass:
      return ((/*static_cast*//*const*/ ObjCBoxedExpr /*P*/ )(this)).getLocEnd();
     case ObjCDictionaryLiteralClass:
      return ((/*static_cast*//*const*/ ObjCDictionaryLiteral /*P*/ )(this)).getLocEnd();
     case ObjCEncodeExprClass:
      return ((/*static_cast*//*const*/ ObjCEncodeExpr /*P*/ )(this)).getLocEnd();
     case ObjCIndirectCopyRestoreExprClass:
      return ((/*static_cast*//*const*/ ObjCIndirectCopyRestoreExpr /*P*/ )(this)).getLocEnd();
     case ObjCIsaExprClass:
      return ((/*static_cast*//*const*/ ObjCIsaExpr /*P*/ )(this)).getLocEnd();
     case ObjCIvarRefExprClass:
      return ((/*static_cast*//*const*/ ObjCIvarRefExpr /*P*/ )(this)).getLocEnd();
     case ObjCMessageExprClass:
      return ((/*static_cast*//*const*/ ObjCMessageExpr /*P*/ )(this)).getLocEnd();
     case ObjCPropertyRefExprClass:
      return ((/*static_cast*//*const*/ ObjCPropertyRefExpr /*P*/ )(this)).getLocEnd();
     case ObjCProtocolExprClass:
      return ((/*static_cast*//*const*/ ObjCProtocolExpr /*P*/ )(this)).getLocEnd();
     case ObjCSelectorExprClass:
      return ((/*static_cast*//*const*/ ObjCSelectorExpr /*P*/ )(this)).getLocEnd();
     case ObjCStringLiteralClass:
      return ((/*static_cast*//*const*/ ObjCStringLiteral /*P*/ )(this)).getLocEnd();
     case ObjCSubscriptRefExprClass:
      return ((/*static_cast*//*const*/ ObjCSubscriptRefExpr /*P*/ )(this)).getLocEnd();
     case OffsetOfExprClass:
      return ((/*static_cast*//*const*/ OffsetOfExpr /*P*/ )(this)).getLocEnd();
     case OpaqueValueExprClass:
      return ((/*static_cast*//*const*/ OpaqueValueExpr /*P*/ )(this)).getLocEnd();
     case UnresolvedLookupExprClass:
      return ((/*static_cast*//*const*/ UnresolvedLookupExpr /*P*/ )(this)).getLocEnd();
     case UnresolvedMemberExprClass:
      return ((/*static_cast*//*const*/ UnresolvedMemberExpr /*P*/ )(this)).getLocEnd();
     case PackExpansionExprClass:
      return ((/*static_cast*//*const*/ PackExpansionExpr /*P*/ )(this)).getLocEnd();
     case ParenExprClass:
      return ((/*static_cast*//*const*/ ParenExpr /*P*/ )(this)).getLocEnd();
     case ParenListExprClass:
      return ((/*static_cast*//*const*/ ParenListExpr /*P*/ )(this)).getLocEnd();
     case PredefinedExprClass:
      return ((/*static_cast*//*const*/ PredefinedExpr /*P*/ )(this)).getLocEnd();
     case PseudoObjectExprClass:
      return ((/*static_cast*//*const*/ PseudoObjectExpr /*P*/ )(this)).getLocEnd();
     case ShuffleVectorExprClass:
      return ((/*static_cast*//*const*/ ShuffleVectorExpr /*P*/ )(this)).getLocEnd();
     case SizeOfPackExprClass:
      return ((/*static_cast*//*const*/ SizeOfPackExpr /*P*/ )(this)).getLocEnd();
     case StmtExprClass:
      return ((/*static_cast*//*const*/ StmtExpr /*P*/ )(this)).getLocEnd();
     case StringLiteralClass:
      return ((/*static_cast*//*const*/ StringLiteral /*P*/ )(this)).getLocEnd();
     case SubstNonTypeTemplateParmExprClass:
      return ((/*static_cast*//*const*/ SubstNonTypeTemplateParmExpr /*P*/ )(this)).getLocEnd();
     case SubstNonTypeTemplateParmPackExprClass:
      return ((/*static_cast*//*const*/ SubstNonTypeTemplateParmPackExpr /*P*/ )(this)).getLocEnd();
     case TypeTraitExprClass:
      return ((/*static_cast*//*const*/ TypeTraitExpr /*P*/ )(this)).getLocEnd();
     case TypoExprClass:
      return ((/*static_cast*//*const*/ TypoExpr /*P*/ )(this)).getLocEnd();
     case UnaryExprOrTypeTraitExprClass:
      return ((/*static_cast*//*const*/ UnaryExprOrTypeTraitExpr /*P*/ )(this)).getLocEnd();
     case UnaryOperatorClass:
      return ((/*static_cast*//*const*/ UnaryOperator /*P*/ )(this)).getLocEnd();
     case VAArgExprClass:
      return ((/*static_cast*//*const*/ VAArgExpr /*P*/ )(this)).getLocEnd();
     case ForStmtClass:
      return ((/*static_cast*//*const*/ ForStmt /*P*/ )(this)).getLocEnd();
     case GotoStmtClass:
      return ((/*static_cast*//*const*/ GotoStmt /*P*/ )(this)).getLocEnd();
     case IfStmtClass:
      return ((/*static_cast*//*const*/ IfStmt /*P*/ )(this)).getLocEnd();
     case IndirectGotoStmtClass:
      return ((/*static_cast*//*const*/ IndirectGotoStmt /*P*/ )(this)).getLocEnd();
     case LabelStmtClass:
      return ((/*static_cast*//*const*/ LabelStmt /*P*/ )(this)).getLocEnd();
     case MSDependentExistsStmtClass:
      return ((/*static_cast*//*const*/ MSDependentExistsStmt /*P*/ )(this)).getLocEnd();
     case NullStmtClass:
      return ((/*static_cast*//*const*/ NullStmt /*P*/ )(this)).getLocEnd();
     case OMPAtomicDirectiveClass:
      return ((/*static_cast*//*const*/ OMPAtomicDirective /*P*/ )(this)).getLocEnd();
     case OMPBarrierDirectiveClass:
      return ((/*static_cast*//*const*/ OMPBarrierDirective /*P*/ )(this)).getLocEnd();
     case OMPCancelDirectiveClass:
      return ((/*static_cast*//*const*/ OMPCancelDirective /*P*/ )(this)).getLocEnd();
     case OMPCancellationPointDirectiveClass:
      return ((/*static_cast*//*const*/ OMPCancellationPointDirective /*P*/ )(this)).getLocEnd();
     case OMPCriticalDirectiveClass:
      return ((/*static_cast*//*const*/ OMPCriticalDirective /*P*/ )(this)).getLocEnd();
     case OMPFlushDirectiveClass:
      return ((/*static_cast*//*const*/ OMPFlushDirective /*P*/ )(this)).getLocEnd();
     case OMPDistributeDirectiveClass:
      return ((/*static_cast*//*const*/ OMPDistributeDirective /*P*/ )(this)).getLocEnd();
     case OMPDistributeParallelForDirectiveClass:
      return ((/*static_cast*//*const*/ OMPDistributeParallelForDirective /*P*/ )(this)).getLocEnd();
     case OMPDistributeParallelForSimdDirectiveClass:
      return ((/*static_cast*//*const*/ OMPDistributeParallelForSimdDirective /*P*/ )(this)).getLocEnd();
     case OMPDistributeSimdDirectiveClass:
      return ((/*static_cast*//*const*/ OMPDistributeSimdDirective /*P*/ )(this)).getLocEnd();
     case OMPForDirectiveClass:
      return ((/*static_cast*//*const*/ OMPForDirective /*P*/ )(this)).getLocEnd();
     case OMPForSimdDirectiveClass:
      return ((/*static_cast*//*const*/ OMPForSimdDirective /*P*/ )(this)).getLocEnd();
     case OMPParallelForDirectiveClass:
      return ((/*static_cast*//*const*/ OMPParallelForDirective /*P*/ )(this)).getLocEnd();
     case OMPParallelForSimdDirectiveClass:
      return ((/*static_cast*//*const*/ OMPParallelForSimdDirective /*P*/ )(this)).getLocEnd();
     case OMPSimdDirectiveClass:
      return ((/*static_cast*//*const*/ OMPSimdDirective /*P*/ )(this)).getLocEnd();
     case OMPTargetParallelForSimdDirectiveClass:
      return ((/*static_cast*//*const*/ OMPTargetParallelForSimdDirective /*P*/ )(this)).getLocEnd();
     case OMPTaskLoopDirectiveClass:
      return ((/*static_cast*//*const*/ OMPTaskLoopDirective /*P*/ )(this)).getLocEnd();
     case OMPTaskLoopSimdDirectiveClass:
      return ((/*static_cast*//*const*/ OMPTaskLoopSimdDirective /*P*/ )(this)).getLocEnd();
     case OMPMasterDirectiveClass:
      return ((/*static_cast*//*const*/ OMPMasterDirective /*P*/ )(this)).getLocEnd();
     case OMPOrderedDirectiveClass:
      return ((/*static_cast*//*const*/ OMPOrderedDirective /*P*/ )(this)).getLocEnd();
     case OMPParallelDirectiveClass:
      return ((/*static_cast*//*const*/ OMPParallelDirective /*P*/ )(this)).getLocEnd();
     case OMPParallelSectionsDirectiveClass:
      return ((/*static_cast*//*const*/ OMPParallelSectionsDirective /*P*/ )(this)).getLocEnd();
     case OMPSectionDirectiveClass:
      return ((/*static_cast*//*const*/ OMPSectionDirective /*P*/ )(this)).getLocEnd();
     case OMPSectionsDirectiveClass:
      return ((/*static_cast*//*const*/ OMPSectionsDirective /*P*/ )(this)).getLocEnd();
     case OMPSingleDirectiveClass:
      return ((/*static_cast*//*const*/ OMPSingleDirective /*P*/ )(this)).getLocEnd();
     case OMPTargetDataDirectiveClass:
      return ((/*static_cast*//*const*/ OMPTargetDataDirective /*P*/ )(this)).getLocEnd();
     case OMPTargetDirectiveClass:
      return ((/*static_cast*//*const*/ OMPTargetDirective /*P*/ )(this)).getLocEnd();
     case OMPTargetEnterDataDirectiveClass:
      return ((/*static_cast*//*const*/ OMPTargetEnterDataDirective /*P*/ )(this)).getLocEnd();
     case OMPTargetExitDataDirectiveClass:
      return ((/*static_cast*//*const*/ OMPTargetExitDataDirective /*P*/ )(this)).getLocEnd();
     case OMPTargetParallelDirectiveClass:
      return ((/*static_cast*//*const*/ OMPTargetParallelDirective /*P*/ )(this)).getLocEnd();
     case OMPTargetParallelForDirectiveClass:
      return ((/*static_cast*//*const*/ OMPTargetParallelForDirective /*P*/ )(this)).getLocEnd();
     case OMPTargetUpdateDirectiveClass:
      return ((/*static_cast*//*const*/ OMPTargetUpdateDirective /*P*/ )(this)).getLocEnd();
     case OMPTaskDirectiveClass:
      return ((/*static_cast*//*const*/ OMPTaskDirective /*P*/ )(this)).getLocEnd();
     case OMPTaskgroupDirectiveClass:
      return ((/*static_cast*//*const*/ OMPTaskgroupDirective /*P*/ )(this)).getLocEnd();
     case OMPTaskwaitDirectiveClass:
      return ((/*static_cast*//*const*/ OMPTaskwaitDirective /*P*/ )(this)).getLocEnd();
     case OMPTaskyieldDirectiveClass:
      return ((/*static_cast*//*const*/ OMPTaskyieldDirective /*P*/ )(this)).getLocEnd();
     case OMPTeamsDirectiveClass:
      return ((/*static_cast*//*const*/ OMPTeamsDirective /*P*/ )(this)).getLocEnd();
     case ObjCAtCatchStmtClass:
      return ((/*static_cast*//*const*/ ObjCAtCatchStmt /*P*/ )(this)).getLocEnd();
     case ObjCAtFinallyStmtClass:
      return ((/*static_cast*//*const*/ ObjCAtFinallyStmt /*P*/ )(this)).getLocEnd();
     case ObjCAtSynchronizedStmtClass:
      return ((/*static_cast*//*const*/ ObjCAtSynchronizedStmt /*P*/ )(this)).getLocEnd();
     case ObjCAtThrowStmtClass:
      return ((/*static_cast*//*const*/ ObjCAtThrowStmt /*P*/ )(this)).getLocEnd();
     case ObjCAtTryStmtClass:
      return ((/*static_cast*//*const*/ ObjCAtTryStmt /*P*/ )(this)).getLocEnd();
     case ObjCAutoreleasePoolStmtClass:
      return ((/*static_cast*//*const*/ ObjCAutoreleasePoolStmt /*P*/ )(this)).getLocEnd();
     case ObjCForCollectionStmtClass:
      return ((/*static_cast*//*const*/ ObjCForCollectionStmt /*P*/ )(this)).getLocEnd();
     case ReturnStmtClass:
      return ((/*static_cast*//*const*/ ReturnStmt /*P*/ )(this)).getLocEnd();
     case SEHExceptStmtClass:
      return ((/*static_cast*//*const*/ SEHExceptStmt /*P*/ )(this)).getLocEnd();
     case SEHFinallyStmtClass:
      return ((/*static_cast*//*const*/ SEHFinallyStmt /*P*/ )(this)).getLocEnd();
     case SEHLeaveStmtClass:
      return ((/*static_cast*//*const*/ SEHLeaveStmt /*P*/ )(this)).getLocEnd();
     case SEHTryStmtClass:
      return ((/*static_cast*//*const*/ SEHTryStmt /*P*/ )(this)).getLocEnd();
     case CaseStmtClass:
      return ((/*static_cast*//*const*/ CaseStmt /*P*/ )(this)).getLocEnd();
     case DefaultStmtClass:
      return ((/*static_cast*//*const*/ DefaultStmt /*P*/ )(this)).getLocEnd();
     case SwitchStmtClass:
      return ((/*static_cast*//*const*/ SwitchStmt /*P*/ )(this)).getLocEnd();
     case WhileStmtClass:
      return ((/*static_cast*//*const*/ WhileStmt /*P*/ )(this)).getLocEnd();
    }
    throw new llvm_unreachable("unknown statement kind");
  }


  
  // global temp stats (until we have a per-module visitor)
  
  // global temp stats (until we have a per-module visitor)
  //<editor-fold defaultstate="collapsed" desc="clang::Stmt::addStmtClass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp", line = 87,
   FQN="clang::Stmt::addStmtClass", NM="_ZN5clang4Stmt12addStmtClassENS0_9StmtClassE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang4Stmt12addStmtClassENS0_9StmtClassE")
  //</editor-fold>
  public static void addStmtClass(StmtClass s) {
    ++getStmtInfoTableEntry(s).Counter;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::Stmt::EnableStatistics">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp", line = 92,
   FQN="clang::Stmt::EnableStatistics", NM="_ZN5clang4Stmt16EnableStatisticsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang4Stmt16EnableStatisticsEv")
  //</editor-fold>
  public static void EnableStatistics() {
    StatisticsEnabled = true;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::Stmt::PrintStats">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp", line = 62,
   FQN="clang::Stmt::PrintStats", NM="_ZN5clang4Stmt10PrintStatsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang4Stmt10PrintStatsEv")
  //</editor-fold>
  public static void PrintStats() {
    // Ensure the table is primed.
    getStmtInfoTableEntry(Stmt.StmtClass.NullStmtClass);
    
    /*uint*/int sum = 0;
    llvm.errs().$out(/*KEEP_STR*/"\n*** Stmt/Expr Stats:\n");
    for (int i = 0; i != Stmt.StmtClass.lastStmtConstant.getValue() + 1; i++) {
      if ($eq_ptr(StmtClassInfo[i].Name, null)) {
        continue;
      }
      sum += StmtClassInfo[i].Counter;
    }
    llvm.errs().$out(/*KEEP_STR*/"  ").$out_uint(sum).$out(/*KEEP_STR*/" stmts/exprs total.\n");
    sum = 0;
    for (int i = 0; i != Stmt.StmtClass.lastStmtConstant.getValue() + 1; i++) {
      if ($eq_ptr(StmtClassInfo[i].Name, null)) {
        continue;
      }
      if (StmtClassInfo[i].Counter == 0) {
        continue;
      }
      llvm.errs().$out(/*KEEP_STR*/"    ").$out_uint(StmtClassInfo[i].Counter).$out(/*KEEP_STR*/$SPACE).$out(
          StmtClassInfo[i].Name
      ).$out(/*KEEP_STR*/$COMMA_SPACE).$out_uint(StmtClassInfo[i].Size).$out(
          /*KEEP_STR*/" each ("
      ).$out_uint(StmtClassInfo[i].Counter * StmtClassInfo[i].Size).$out(
          /*KEEP_STR*/" bytes)\n"
      );
      sum += StmtClassInfo[i].Counter * StmtClassInfo[i].Size;
    }
    
    llvm.errs().$out(/*KEEP_STR*/"Total bytes = ").$out_uint(sum).$out(/*KEEP_STR*/$LF);
  }


  
  /// \brief Dumps the specified AST fragment and all subtrees to
  /// \c llvm::errs().
  //<editor-fold defaultstate="collapsed" desc="clang::Stmt::dump">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 2511,
   FQN="clang::Stmt::dump", NM="_ZNK5clang4Stmt4dumpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Stmt4dumpEv")
  //</editor-fold>
  public void dump() /*const*//* __attribute__((used)) __attribute__((noinline))*/ {
    ASTDumper P = null;
    try {
      P/*J*/= new ASTDumper(llvm.errs(), (/*const*/ CommandTraits /*P*/ )null, (/*const*/ SourceManager /*P*/ )null);
      P.dumpStmt(this);
    } finally {
      if (P != null) { P.$destroy(); }
    }
  }

  
  //===----------------------------------------------------------------------===//
  // Stmt method implementations
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::Stmt::dump">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 2497,
   FQN="clang::Stmt::dump", NM="_ZNK5clang4Stmt4dumpERNS_13SourceManagerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Stmt4dumpERNS_13SourceManagerE")
  //</editor-fold>
  public void dump(final SourceManager /*&*/ SM) /*const*//* __attribute__((used)) __attribute__((noinline))*/ {
    dump(llvm.errs(), SM);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Stmt::dump">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 2501,
   FQN="clang::Stmt::dump", NM="_ZNK5clang4Stmt4dumpERN4llvm11raw_ostreamERNS_13SourceManagerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Stmt4dumpERN4llvm11raw_ostreamERNS_13SourceManagerE")
  //</editor-fold>
  public void dump(final raw_ostream /*&*/ OS, final SourceManager /*&*/ SM) /*const*//* __attribute__((used)) __attribute__((noinline))*/ {
    ASTDumper P = null;
    try {
      P/*J*/= new ASTDumper(OS, (/*const*/ CommandTraits /*P*/ )null, $AddrOf(SM));
      P.dumpStmt(this);
    } finally {
      if (P != null) { P.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Stmt::dump">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 2506,
   FQN="clang::Stmt::dump", NM="_ZNK5clang4Stmt4dumpERN4llvm11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Stmt4dumpERN4llvm11raw_ostreamE")
  //</editor-fold>
  public void dump(final raw_ostream /*&*/ OS) /*const*//* __attribute__((used)) __attribute__((noinline))*/ {
    ASTDumper P = null;
    try {
      P/*J*/= new ASTDumper(OS, (/*const*/ CommandTraits /*P*/ )null, (/*const*/ SourceManager /*P*/ )null);
      P.dumpStmt(this);
    } finally {
      if (P != null) { P.$destroy(); }
    }
  }

  
  /// dumpColor - same as dump(), but forces color highlighting.
  //<editor-fold defaultstate="collapsed" desc="clang::Stmt::dumpColor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp", line = 2516,
   FQN="clang::Stmt::dumpColor", NM="_ZNK5clang4Stmt9dumpColorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Stmt9dumpColorEv")
  //</editor-fold>
  public void dumpColor() /*const*//* __attribute__((used)) __attribute__((noinline))*/ {
    ASTDumper P = null;
    try {
      P/*J*/= new ASTDumper(llvm.errs(), (/*const*/ CommandTraits /*P*/ )null, (/*const*/ SourceManager /*P*/ )null, /*ShowColors*/ true);
      P.dumpStmt(this);
    } finally {
      if (P != null) { P.$destroy(); }
    }
  }

  
  /// dumpPretty/printPretty - These two methods do a "pretty print" of the AST
  /// back to its original source language syntax.
  
  /// dumpPretty/printPretty - These two methods do a "pretty print" of the AST
  /// back to its original source language syntax.
  
  //===----------------------------------------------------------------------===//
  // Stmt method implementations
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::Stmt::dumpPretty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 2571,
   FQN="clang::Stmt::dumpPretty", NM="_ZNK5clang4Stmt10dumpPrettyERKNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZNK5clang4Stmt10dumpPrettyERKNS_10ASTContextE")
  //</editor-fold>
  public void dumpPretty(final /*const*/ ASTContext /*&*/ Context) /*const*/ {
    printPretty(llvm.errs(), (PrinterHelper /*P*/ )null, new PrintingPolicy(Context.getLangOpts()));
  }


  //<editor-fold defaultstate="collapsed" desc="clang::Stmt::printPretty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp", line = 2575,
   FQN="clang::Stmt::printPretty", NM="_ZNK5clang4Stmt11printPrettyERN4llvm11raw_ostreamEPNS_13PrinterHelperERKNS_14PrintingPolicyEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtPrinter.cpp -nm=_ZNK5clang4Stmt11printPrettyERN4llvm11raw_ostreamEPNS_13PrinterHelperERKNS_14PrintingPolicyEj")
  //</editor-fold>
  public void printPretty(final raw_ostream /*&*/ OS, 
             PrinterHelper /*P*/ Helper, 
             final /*const*/ PrintingPolicy /*&*/ Policy) /*const*/ {
    printPretty(OS, 
             Helper, 
             Policy, 
             0);
  }
  public void printPretty(final raw_ostream /*&*/ OS, 
             PrinterHelper /*P*/ Helper, 
             final /*const*/ PrintingPolicy /*&*/ Policy, 
             /*uint*/int Indentation/*= 0*/) /*const*/ {
    StmtPrinter P/*J*/= new StmtPrinter(OS, Helper, Policy, Indentation);
    P.Visit(((/*const_cast*/Stmt /*P*/ )(this)));
  }


  
  /// viewAST - Visualize an AST rooted at this Stmt* using GraphViz.  Only
  ///   works on systems with GraphViz (Mac OS X) or dot+gv installed.
  
  /// viewAST - Visualize an AST rooted at this Stmt* using GraphViz.  Only
  ///   works on systems with GraphViz (Mac OS X) or dot+gv installed.
  //<editor-fold defaultstate="collapsed" desc="clang::Stmt::viewAST">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtViz.cpp", line = 21,
   FQN="clang::Stmt::viewAST", NM="_ZNK5clang4Stmt7viewASTEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtViz.cpp -nm=_ZNK5clang4Stmt7viewASTEv")
  //</editor-fold>
  public void viewAST() /*const*/ {
    ViewGraph(this, new Twine(/*KEEP_STR*/"AST"));
  }


  
  /// Skip past any implicit AST nodes which might surround this
  /// statement, such as ExprWithCleanups or ImplicitCastExpr nodes.
  
  /// Skip past any implicit AST nodes which might surround this
  /// statement, such as ExprWithCleanups or ImplicitCastExpr nodes.
  //<editor-fold defaultstate="collapsed" desc="clang::Stmt::IgnoreImplicit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp", line = 96,
   FQN="clang::Stmt::IgnoreImplicit", NM="_ZN5clang4Stmt14IgnoreImplicitEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang4Stmt14IgnoreImplicitEv")
  //</editor-fold>
  public Stmt /*P*/ IgnoreImplicit() {
    Stmt /*P*/ s = this;
    {
      
      ExprWithCleanups /*P*/ ewc = dyn_cast_ExprWithCleanups(s);
      if ((ewc != null)) {
        s = ewc.getSubExpr();
      }
    }
    {
      
      MaterializeTemporaryExpr /*P*/ mte = dyn_cast_MaterializeTemporaryExpr(s);
      if ((mte != null)) {
        s = mte.GetTemporaryExpr();
      }
    }
    {
      
      CXXBindTemporaryExpr /*P*/ bte = dyn_cast_CXXBindTemporaryExpr(s);
      if ((bte != null)) {
        s = bte.getSubExpr();
      }
    }
    {
      
      ImplicitCastExpr /*P*/ ice;
      while (((/*P*/ ice = dyn_cast_ImplicitCastExpr(s)) != null)) {
        s = ice.getSubExpr();
      }
    }
    
    return s;
  }


  
  /// \brief Skip no-op (attributed, compound) container stmts and skip captured
  /// stmt at the top, if \a IgnoreCaptured is true.
  
  /// \brief Skip no-op (attributed, compound) container stmts and skip captured
  /// stmt at the top, if \a IgnoreCaptured is true.
  
  /// \brief Skip no-op (attributed, compound) container stmts and skip captured
  /// stmt at the top, if \a IgnoreCaptured is true.
  //<editor-fold defaultstate="collapsed" desc="clang::Stmt::IgnoreContainers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp", line = 116,
   FQN="clang::Stmt::IgnoreContainers", NM="_ZN5clang4Stmt16IgnoreContainersEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang4Stmt16IgnoreContainersEb")
  //</editor-fold>
  public Stmt /*P*/ IgnoreContainers() {
    return IgnoreContainers(false);
  }
  public Stmt /*P*/ IgnoreContainers(boolean IgnoreCaptured/*= false*/) {
    Stmt /*P*/ S = this;
    if (IgnoreCaptured) {
      {
        CapturedStmt /*P*/ CapS = dyn_cast_or_null_CapturedStmt(S);
        if ((CapS != null)) {
          S = CapS.getCapturedStmt();
        }
      }
    }
    while (true) {
      {
        AttributedStmt /*P*/ AS = dyn_cast_or_null_AttributedStmt(S);
        if ((AS != null)) {
          S = AS.getSubStmt();
        } else {
          CompoundStmt /*P*/ CS = dyn_cast_or_null_CompoundStmt(S);
          if ((CS != null)) {
            if (CS.size() != 1) {
              break;
            }
            S = CS.body_back();
          } else {
            break;
          }
        }
      }
    }
    return S;
  }


  
  /// \brief Strip off all label-like statements.
  ///
  /// This will strip off label statements, case statements, attributed
  /// statements and default statements recursively.
  //<editor-fold defaultstate="collapsed" desc="clang::Stmt::stripLabelLikeStatements">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp", line = 138,
   FQN="clang::Stmt::stripLabelLikeStatements", NM="_ZNK5clang4Stmt24stripLabelLikeStatementsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZNK5clang4Stmt24stripLabelLikeStatementsEv")
  //</editor-fold>
  public /*const*/ Stmt /*P*/ stripLabelLikeStatements$Const() /*const*/ {
    /*const*/ Stmt /*P*/ S = this;
    while (true) {
      {
        /*const*/ LabelStmt /*P*/ LS = dyn_cast_LabelStmt(S);
        if ((LS != null)) {
          S = LS.getSubStmt$Const();
        } else {
          /*const*/ SwitchCase /*P*/ SC = dyn_cast_SwitchCase(S);
          if ((SC != null)) {
            S = SC.getSubStmt$Const();
          } else {
            /*const*/ AttributedStmt /*P*/ AS = dyn_cast_AttributedStmt(S);
            if ((AS != null)) {
              S = AS.getSubStmt$Const();
            } else {
              return S;
            }
          }
        }
      }
    }
  }


  //<editor-fold defaultstate="collapsed" desc="clang::Stmt::stripLabelLikeStatements">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 396,
   FQN="clang::Stmt::stripLabelLikeStatements", NM="_ZN5clang4Stmt24stripLabelLikeStatementsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang4Stmt24stripLabelLikeStatementsEv")
  //</editor-fold>
  public Stmt /*P*/ stripLabelLikeStatements() {
    return ((/*const_cast*/Stmt /*P*/ )(((/*const_cast*//*const*/ Stmt /*P*/ )(this)).stripLabelLikeStatements$Const()));
  }

  
  /// Child Iterators: All subclasses must implement 'children'
  /// to permit easy iteration over the substatements/subexpessions of an
  /// AST node.  This permits easy iteration over all nodes in the AST.
  /*typedef StmtIterator child_iterator*/
//  public final class child_iterator extends StmtIterator{ };
  /*typedef ConstStmtIterator const_child_iterator*/
//  public final class const_child_iterator extends ConstStmtIterator{ };
  
  /*typedef llvm::iterator_range<child_iterator> child_range*/
//  public final class child_range extends iterator_range<Stmt/*P*/>{ };
  /*typedef llvm::iterator_range<const_child_iterator> const_child_range*/
//  public final class const_child_range extends iterator_range<ConstStmtIterator>{ };
  //<editor-fold defaultstate="collapsed" desc="clang::Stmt::children">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp", line = 208,
   FQN="clang::Stmt::children", NM="_ZN5clang4Stmt8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang4Stmt8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children() {
    switch (getStmtClass()) {
     case NoStmtClass:
      throw new llvm_unreachable("statement without class");
     case GCCAsmStmtClass:
      return ((/*static_cast*/GCCAsmStmt /*P*/ )(this)).children();
     case MSAsmStmtClass:
      return ((/*static_cast*/MSAsmStmt /*P*/ )(this)).children();
     case AttributedStmtClass:
      return ((/*static_cast*/AttributedStmt /*P*/ )(this)).children();
     case BreakStmtClass:
      return ((/*static_cast*/BreakStmt /*P*/ )(this)).children();
     case CXXCatchStmtClass:
      return ((/*static_cast*/CXXCatchStmt /*P*/ )(this)).children();
     case CXXForRangeStmtClass:
      return ((/*static_cast*/CXXForRangeStmt /*P*/ )(this)).children();
     case CXXTryStmtClass:
      return ((/*static_cast*/CXXTryStmt /*P*/ )(this)).children();
     case CapturedStmtClass:
      return ((/*static_cast*/CapturedStmt /*P*/ )(this)).children();
     case CompoundStmtClass:
      return ((/*static_cast*/CompoundStmt /*P*/ )(this)).children();
     case ContinueStmtClass:
      return ((/*static_cast*/ContinueStmt /*P*/ )(this)).children();
     case CoreturnStmtClass:
      return ((/*static_cast*/CoreturnStmt /*P*/ )(this)).children();
     case CoroutineBodyStmtClass:
      return ((/*static_cast*/CoroutineBodyStmt /*P*/ )(this)).children();
     case DeclStmtClass:
      return ((/*static_cast*/DeclStmt /*P*/ )(this)).children();
     case DoStmtClass:
      return ((/*static_cast*/DoStmt /*P*/ )(this)).children();
     case BinaryConditionalOperatorClass:
      return ((/*static_cast*/BinaryConditionalOperator /*P*/ )(this)).children();
     case ConditionalOperatorClass:
      return ((/*static_cast*/ConditionalOperator /*P*/ )(this)).children();
     case AddrLabelExprClass:
      return ((/*static_cast*/AddrLabelExpr /*P*/ )(this)).children();
     case ArraySubscriptExprClass:
      return ((/*static_cast*/ArraySubscriptExpr /*P*/ )(this)).children();
     case ArrayTypeTraitExprClass:
      return ((/*static_cast*/ArrayTypeTraitExpr /*P*/ )(this)).children();
     case AsTypeExprClass:
      return ((/*static_cast*/AsTypeExpr /*P*/ )(this)).children();
     case AtomicExprClass:
      return ((/*static_cast*/AtomicExpr /*P*/ )(this)).children();
     case BinaryOperatorClass:
      return ((/*static_cast*/BinaryOperator /*P*/ )(this)).children();
     case CompoundAssignOperatorClass:
      return ((/*static_cast*/CompoundAssignOperator /*P*/ )(this)).children();
     case BlockExprClass:
      return ((/*static_cast*/BlockExpr /*P*/ )(this)).children();
     case CXXBindTemporaryExprClass:
      return ((/*static_cast*/CXXBindTemporaryExpr /*P*/ )(this)).children();
     case CXXBoolLiteralExprClass:
      return ((/*static_cast*/CXXBoolLiteralExpr /*P*/ )(this)).children();
     case CXXConstructExprClass:
      return ((/*static_cast*/CXXConstructExpr /*P*/ )(this)).children();
     case CXXTemporaryObjectExprClass:
      return ((/*static_cast*/CXXTemporaryObjectExpr /*P*/ )(this)).children();
     case CXXDefaultArgExprClass:
      return ((/*static_cast*/CXXDefaultArgExpr /*P*/ )(this)).children();
     case CXXDefaultInitExprClass:
      return ((/*static_cast*/CXXDefaultInitExpr /*P*/ )(this)).children();
     case CXXDeleteExprClass:
      return ((/*static_cast*/CXXDeleteExpr /*P*/ )(this)).children();
     case CXXDependentScopeMemberExprClass:
      return ((/*static_cast*/CXXDependentScopeMemberExpr /*P*/ )(this)).children();
     case CXXFoldExprClass:
      return ((/*static_cast*/CXXFoldExpr /*P*/ )(this)).children();
     case CXXInheritedCtorInitExprClass:
      return ((/*static_cast*/CXXInheritedCtorInitExpr /*P*/ )(this)).children();
     case CXXNewExprClass:
      return ((/*static_cast*/CXXNewExpr /*P*/ )(this)).children();
     case CXXNoexceptExprClass:
      return ((/*static_cast*/CXXNoexceptExpr /*P*/ )(this)).children();
     case CXXNullPtrLiteralExprClass:
      return ((/*static_cast*/CXXNullPtrLiteralExpr /*P*/ )(this)).children();
     case CXXPseudoDestructorExprClass:
      return ((/*static_cast*/CXXPseudoDestructorExpr /*P*/ )(this)).children();
     case CXXScalarValueInitExprClass:
      return ((/*static_cast*/CXXScalarValueInitExpr /*P*/ )(this)).children();
     case CXXStdInitializerListExprClass:
      return ((/*static_cast*/CXXStdInitializerListExpr /*P*/ )(this)).children();
     case CXXThisExprClass:
      return ((/*static_cast*/CXXThisExpr /*P*/ )(this)).children();
     case CXXThrowExprClass:
      return ((/*static_cast*/CXXThrowExpr /*P*/ )(this)).children();
     case CXXTypeidExprClass:
      return ((/*static_cast*/CXXTypeidExpr /*P*/ )(this)).children();
     case CXXUnresolvedConstructExprClass:
      return ((/*static_cast*/CXXUnresolvedConstructExpr /*P*/ )(this)).children();
     case CXXUuidofExprClass:
      return ((/*static_cast*/CXXUuidofExpr /*P*/ )(this)).children();
     case CallExprClass:
      return ((/*static_cast*/CallExpr /*P*/ )(this)).children();
     case CUDAKernelCallExprClass:
      return ((/*static_cast*/CUDAKernelCallExpr /*P*/ )(this)).children();
     case CXXMemberCallExprClass:
      return ((/*static_cast*/CXXMemberCallExpr /*P*/ )(this)).children();
     case CXXOperatorCallExprClass:
      return ((/*static_cast*/CXXOperatorCallExpr /*P*/ )(this)).children();
     case UserDefinedLiteralClass:
      return ((/*static_cast*/UserDefinedLiteral /*P*/ )(this)).children();
     case CStyleCastExprClass:
      return ((/*static_cast*/CStyleCastExpr /*P*/ )(this)).children();
     case CXXFunctionalCastExprClass:
      return ((/*static_cast*/CXXFunctionalCastExpr /*P*/ )(this)).children();
     case CXXConstCastExprClass:
      return ((/*static_cast*/CXXConstCastExpr /*P*/ )(this)).children();
     case CXXDynamicCastExprClass:
      return ((/*static_cast*/CXXDynamicCastExpr /*P*/ )(this)).children();
     case CXXReinterpretCastExprClass:
      return ((/*static_cast*/CXXReinterpretCastExpr /*P*/ )(this)).children();
     case CXXStaticCastExprClass:
      return ((/*static_cast*/CXXStaticCastExpr /*P*/ )(this)).children();
     case ObjCBridgedCastExprClass:
      return ((/*static_cast*/ObjCBridgedCastExpr /*P*/ )(this)).children();
     case ImplicitCastExprClass:
      return ((/*static_cast*/ImplicitCastExpr /*P*/ )(this)).children();
     case CharacterLiteralClass:
      return ((/*static_cast*/CharacterLiteral /*P*/ )(this)).children();
     case ChooseExprClass:
      return ((/*static_cast*/ChooseExpr /*P*/ )(this)).children();
     case CompoundLiteralExprClass:
      return ((/*static_cast*/CompoundLiteralExpr /*P*/ )(this)).children();
     case ConvertVectorExprClass:
      return ((/*static_cast*/ConvertVectorExpr /*P*/ )(this)).children();
     case CoawaitExprClass:
      return ((/*static_cast*/CoawaitExpr /*P*/ )(this)).children();
     case CoyieldExprClass:
      return ((/*static_cast*/CoyieldExpr /*P*/ )(this)).children();
     case DeclRefExprClass:
      return ((/*static_cast*/DeclRefExpr /*P*/ )(this)).children();
     case DependentScopeDeclRefExprClass:
      return ((/*static_cast*/DependentScopeDeclRefExpr /*P*/ )(this)).children();
     case DesignatedInitExprClass:
      return ((/*static_cast*/DesignatedInitExpr /*P*/ )(this)).children();
     case DesignatedInitUpdateExprClass:
      return ((/*static_cast*/DesignatedInitUpdateExpr /*P*/ )(this)).children();
     case ExprWithCleanupsClass:
      return ((/*static_cast*/ExprWithCleanups /*P*/ )(this)).children();
     case ExpressionTraitExprClass:
      return ((/*static_cast*/ExpressionTraitExpr /*P*/ )(this)).children();
     case ExtVectorElementExprClass:
      return ((/*static_cast*/ExtVectorElementExpr /*P*/ )(this)).children();
     case FloatingLiteralClass:
      return ((/*static_cast*/FloatingLiteral /*P*/ )(this)).children();
     case FunctionParmPackExprClass:
      return ((/*static_cast*/FunctionParmPackExpr /*P*/ )(this)).children();
     case GNUNullExprClass:
      return ((/*static_cast*/GNUNullExpr /*P*/ )(this)).children();
     case GenericSelectionExprClass:
      return ((/*static_cast*/GenericSelectionExpr /*P*/ )(this)).children();
     case ImaginaryLiteralClass:
      return ((/*static_cast*/ImaginaryLiteral /*P*/ )(this)).children();
     case ImplicitValueInitExprClass:
      return ((/*static_cast*/ImplicitValueInitExpr /*P*/ )(this)).children();
     case InitListExprClass:
      return ((/*static_cast*/InitListExpr /*P*/ )(this)).children();
     case IntegerLiteralClass:
      return ((/*static_cast*/IntegerLiteral /*P*/ )(this)).children();
     case LambdaExprClass:
      return ((/*static_cast*/LambdaExpr /*P*/ )(this)).children();
     case MSPropertyRefExprClass:
      return ((/*static_cast*/MSPropertyRefExpr /*P*/ )(this)).children();
     case MSPropertySubscriptExprClass:
      return ((/*static_cast*/MSPropertySubscriptExpr /*P*/ )(this)).children();
     case MaterializeTemporaryExprClass:
      return ((/*static_cast*/MaterializeTemporaryExpr /*P*/ )(this)).children();
     case MemberExprClass:
      return ((/*static_cast*/MemberExpr /*P*/ )(this)).children();
     case NoInitExprClass:
      return ((/*static_cast*/NoInitExpr /*P*/ )(this)).children();
     case OMPArraySectionExprClass:
      return ((/*static_cast*/OMPArraySectionExpr /*P*/ )(this)).children();
     case ObjCArrayLiteralClass:
      return ((/*static_cast*/ObjCArrayLiteral /*P*/ )(this)).children();
     case ObjCAvailabilityCheckExprClass:
      return ((/*static_cast*/ObjCAvailabilityCheckExpr /*P*/ )(this)).children();
     case ObjCBoolLiteralExprClass:
      return ((/*static_cast*/ObjCBoolLiteralExpr /*P*/ )(this)).children();
     case ObjCBoxedExprClass:
      return ((/*static_cast*/ObjCBoxedExpr /*P*/ )(this)).children();
     case ObjCDictionaryLiteralClass:
      return ((/*static_cast*/ObjCDictionaryLiteral /*P*/ )(this)).children();
     case ObjCEncodeExprClass:
      return ((/*static_cast*/ObjCEncodeExpr /*P*/ )(this)).children();
     case ObjCIndirectCopyRestoreExprClass:
      return ((/*static_cast*/ObjCIndirectCopyRestoreExpr /*P*/ )(this)).children();
     case ObjCIsaExprClass:
      return ((/*static_cast*/ObjCIsaExpr /*P*/ )(this)).children();
     case ObjCIvarRefExprClass:
      return ((/*static_cast*/ObjCIvarRefExpr /*P*/ )(this)).children();
     case ObjCMessageExprClass:
      return ((/*static_cast*/ObjCMessageExpr /*P*/ )(this)).children();
     case ObjCPropertyRefExprClass:
      return ((/*static_cast*/ObjCPropertyRefExpr /*P*/ )(this)).children();
     case ObjCProtocolExprClass:
      return ((/*static_cast*/ObjCProtocolExpr /*P*/ )(this)).children();
     case ObjCSelectorExprClass:
      return ((/*static_cast*/ObjCSelectorExpr /*P*/ )(this)).children();
     case ObjCStringLiteralClass:
      return ((/*static_cast*/ObjCStringLiteral /*P*/ )(this)).children();
     case ObjCSubscriptRefExprClass:
      return ((/*static_cast*/ObjCSubscriptRefExpr /*P*/ )(this)).children();
     case OffsetOfExprClass:
      return ((/*static_cast*/OffsetOfExpr /*P*/ )(this)).children();
     case OpaqueValueExprClass:
      return ((/*static_cast*/OpaqueValueExpr /*P*/ )(this)).children();
     case UnresolvedLookupExprClass:
      return ((/*static_cast*/UnresolvedLookupExpr /*P*/ )(this)).children();
     case UnresolvedMemberExprClass:
      return ((/*static_cast*/UnresolvedMemberExpr /*P*/ )(this)).children();
     case PackExpansionExprClass:
      return ((/*static_cast*/PackExpansionExpr /*P*/ )(this)).children();
     case ParenExprClass:
      return ((/*static_cast*/ParenExpr /*P*/ )(this)).children();
     case ParenListExprClass:
      return ((/*static_cast*/ParenListExpr /*P*/ )(this)).children();
     case PredefinedExprClass:
      return ((/*static_cast*/PredefinedExpr /*P*/ )(this)).children();
     case PseudoObjectExprClass:
      return ((/*static_cast*/PseudoObjectExpr /*P*/ )(this)).children();
     case ShuffleVectorExprClass:
      return ((/*static_cast*/ShuffleVectorExpr /*P*/ )(this)).children();
     case SizeOfPackExprClass:
      return ((/*static_cast*/SizeOfPackExpr /*P*/ )(this)).children();
     case StmtExprClass:
      return ((/*static_cast*/StmtExpr /*P*/ )(this)).children();
     case StringLiteralClass:
      return ((/*static_cast*/StringLiteral /*P*/ )(this)).children();
     case SubstNonTypeTemplateParmExprClass:
      return ((/*static_cast*/SubstNonTypeTemplateParmExpr /*P*/ )(this)).children();
     case SubstNonTypeTemplateParmPackExprClass:
      return ((/*static_cast*/SubstNonTypeTemplateParmPackExpr /*P*/ )(this)).children();
     case TypeTraitExprClass:
      return ((/*static_cast*/TypeTraitExpr /*P*/ )(this)).children();
     case TypoExprClass:
      return ((/*static_cast*/TypoExpr /*P*/ )(this)).children();
     case UnaryExprOrTypeTraitExprClass:
      return ((/*static_cast*/UnaryExprOrTypeTraitExpr /*P*/ )(this)).children();
     case UnaryOperatorClass:
      return ((/*static_cast*/UnaryOperator /*P*/ )(this)).children();
     case VAArgExprClass:
      return ((/*static_cast*/VAArgExpr /*P*/ )(this)).children();
     case ForStmtClass:
      return ((/*static_cast*/ForStmt /*P*/ )(this)).children();
     case GotoStmtClass:
      return ((/*static_cast*/GotoStmt /*P*/ )(this)).children();
     case IfStmtClass:
      return ((/*static_cast*/IfStmt /*P*/ )(this)).children();
     case IndirectGotoStmtClass:
      return ((/*static_cast*/IndirectGotoStmt /*P*/ )(this)).children();
     case LabelStmtClass:
      return ((/*static_cast*/LabelStmt /*P*/ )(this)).children();
     case MSDependentExistsStmtClass:
      return ((/*static_cast*/MSDependentExistsStmt /*P*/ )(this)).children();
     case NullStmtClass:
      return ((/*static_cast*/NullStmt /*P*/ )(this)).children();
     case OMPAtomicDirectiveClass:
      return ((/*static_cast*/OMPAtomicDirective /*P*/ )(this)).children();
     case OMPBarrierDirectiveClass:
      return ((/*static_cast*/OMPBarrierDirective /*P*/ )(this)).children();
     case OMPCancelDirectiveClass:
      return ((/*static_cast*/OMPCancelDirective /*P*/ )(this)).children();
     case OMPCancellationPointDirectiveClass:
      return ((/*static_cast*/OMPCancellationPointDirective /*P*/ )(this)).children();
     case OMPCriticalDirectiveClass:
      return ((/*static_cast*/OMPCriticalDirective /*P*/ )(this)).children();
     case OMPFlushDirectiveClass:
      return ((/*static_cast*/OMPFlushDirective /*P*/ )(this)).children();
     case OMPDistributeDirectiveClass:
      return ((/*static_cast*/OMPDistributeDirective /*P*/ )(this)).children();
     case OMPDistributeParallelForDirectiveClass:
      return ((/*static_cast*/OMPDistributeParallelForDirective /*P*/ )(this)).children();
     case OMPDistributeParallelForSimdDirectiveClass:
      return ((/*static_cast*/OMPDistributeParallelForSimdDirective /*P*/ )(this)).children();
     case OMPDistributeSimdDirectiveClass:
      return ((/*static_cast*/OMPDistributeSimdDirective /*P*/ )(this)).children();
     case OMPForDirectiveClass:
      return ((/*static_cast*/OMPForDirective /*P*/ )(this)).children();
     case OMPForSimdDirectiveClass:
      return ((/*static_cast*/OMPForSimdDirective /*P*/ )(this)).children();
     case OMPParallelForDirectiveClass:
      return ((/*static_cast*/OMPParallelForDirective /*P*/ )(this)).children();
     case OMPParallelForSimdDirectiveClass:
      return ((/*static_cast*/OMPParallelForSimdDirective /*P*/ )(this)).children();
     case OMPSimdDirectiveClass:
      return ((/*static_cast*/OMPSimdDirective /*P*/ )(this)).children();
     case OMPTargetParallelForSimdDirectiveClass:
      return ((/*static_cast*/OMPTargetParallelForSimdDirective /*P*/ )(this)).children();
     case OMPTaskLoopDirectiveClass:
      return ((/*static_cast*/OMPTaskLoopDirective /*P*/ )(this)).children();
     case OMPTaskLoopSimdDirectiveClass:
      return ((/*static_cast*/OMPTaskLoopSimdDirective /*P*/ )(this)).children();
     case OMPMasterDirectiveClass:
      return ((/*static_cast*/OMPMasterDirective /*P*/ )(this)).children();
     case OMPOrderedDirectiveClass:
      return ((/*static_cast*/OMPOrderedDirective /*P*/ )(this)).children();
     case OMPParallelDirectiveClass:
      return ((/*static_cast*/OMPParallelDirective /*P*/ )(this)).children();
     case OMPParallelSectionsDirectiveClass:
      return ((/*static_cast*/OMPParallelSectionsDirective /*P*/ )(this)).children();
     case OMPSectionDirectiveClass:
      return ((/*static_cast*/OMPSectionDirective /*P*/ )(this)).children();
     case OMPSectionsDirectiveClass:
      return ((/*static_cast*/OMPSectionsDirective /*P*/ )(this)).children();
     case OMPSingleDirectiveClass:
      return ((/*static_cast*/OMPSingleDirective /*P*/ )(this)).children();
     case OMPTargetDataDirectiveClass:
      return ((/*static_cast*/OMPTargetDataDirective /*P*/ )(this)).children();
     case OMPTargetDirectiveClass:
      return ((/*static_cast*/OMPTargetDirective /*P*/ )(this)).children();
     case OMPTargetEnterDataDirectiveClass:
      return ((/*static_cast*/OMPTargetEnterDataDirective /*P*/ )(this)).children();
     case OMPTargetExitDataDirectiveClass:
      return ((/*static_cast*/OMPTargetExitDataDirective /*P*/ )(this)).children();
     case OMPTargetParallelDirectiveClass:
      return ((/*static_cast*/OMPTargetParallelDirective /*P*/ )(this)).children();
     case OMPTargetParallelForDirectiveClass:
      return ((/*static_cast*/OMPTargetParallelForDirective /*P*/ )(this)).children();
     case OMPTargetUpdateDirectiveClass:
      return ((/*static_cast*/OMPTargetUpdateDirective /*P*/ )(this)).children();
     case OMPTaskDirectiveClass:
      return ((/*static_cast*/OMPTaskDirective /*P*/ )(this)).children();
     case OMPTaskgroupDirectiveClass:
      return ((/*static_cast*/OMPTaskgroupDirective /*P*/ )(this)).children();
     case OMPTaskwaitDirectiveClass:
      return ((/*static_cast*/OMPTaskwaitDirective /*P*/ )(this)).children();
     case OMPTaskyieldDirectiveClass:
      return ((/*static_cast*/OMPTaskyieldDirective /*P*/ )(this)).children();
     case OMPTeamsDirectiveClass:
      return ((/*static_cast*/OMPTeamsDirective /*P*/ )(this)).children();
     case ObjCAtCatchStmtClass:
      return ((/*static_cast*/ObjCAtCatchStmt /*P*/ )(this)).children();
     case ObjCAtFinallyStmtClass:
      return ((/*static_cast*/ObjCAtFinallyStmt /*P*/ )(this)).children();
     case ObjCAtSynchronizedStmtClass:
      return ((/*static_cast*/ObjCAtSynchronizedStmt /*P*/ )(this)).children();
     case ObjCAtThrowStmtClass:
      return ((/*static_cast*/ObjCAtThrowStmt /*P*/ )(this)).children();
     case ObjCAtTryStmtClass:
      return ((/*static_cast*/ObjCAtTryStmt /*P*/ )(this)).children();
     case ObjCAutoreleasePoolStmtClass:
      return ((/*static_cast*/ObjCAutoreleasePoolStmt /*P*/ )(this)).children();
     case ObjCForCollectionStmtClass:
      return ((/*static_cast*/ObjCForCollectionStmt /*P*/ )(this)).children();
     case ReturnStmtClass:
      return ((/*static_cast*/ReturnStmt /*P*/ )(this)).children();
     case SEHExceptStmtClass:
      return ((/*static_cast*/SEHExceptStmt /*P*/ )(this)).children();
     case SEHFinallyStmtClass:
      return ((/*static_cast*/SEHFinallyStmt /*P*/ )(this)).children();
     case SEHLeaveStmtClass:
      return ((/*static_cast*/SEHLeaveStmt /*P*/ )(this)).children();
     case SEHTryStmtClass:
      return ((/*static_cast*/SEHTryStmt /*P*/ )(this)).children();
     case CaseStmtClass:
      return ((/*static_cast*/CaseStmt /*P*/ )(this)).children();
     case DefaultStmtClass:
      return ((/*static_cast*/DefaultStmt /*P*/ )(this)).children();
     case SwitchStmtClass:
      return ((/*static_cast*/SwitchStmt /*P*/ )(this)).children();
     case WhileStmtClass:
      return ((/*static_cast*/WhileStmt /*P*/ )(this)).children();
    }
    throw new llvm_unreachable("unknown statement kind!");
  }


  //<editor-fold defaultstate="collapsed" desc="clang::Stmt::children">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 411,
   FQN="clang::Stmt::children", NM="_ZNK5clang4Stmt8childrenEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Stmt8childrenEv")
  //</editor-fold>
  public iterator_range<Stmt/*P*/> children$Const() /*const*/ {
    iterator_range<Stmt/*P*/> Children = ((/*const_cast*/Stmt /*P*/ )(this)).children();
    return new iterator_range<Stmt>(new ConstStmtIterator(((StmtIterator)Children.begin())), new ConstStmtIterator(((StmtIterator)Children.end())));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Stmt::child_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 416,
   FQN="clang::Stmt::child_begin", NM="_ZN5clang4Stmt11child_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang4Stmt11child_beginEv")
  //</editor-fold>
  public StmtIterator child_begin() {
    return ((StmtIterator)children().begin());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Stmt::child_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 417,
   FQN="clang::Stmt::child_end", NM="_ZN5clang4Stmt9child_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang4Stmt9child_endEv")
  //</editor-fold>
  public StmtIterator child_end() {
    return ((StmtIterator)children().end());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::Stmt::child_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 419,
   FQN="clang::Stmt::child_begin", NM="_ZNK5clang4Stmt11child_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Stmt11child_beginEv")
  //</editor-fold>
  public ConstStmtIterator child_begin$Const() /*const*/ {
    return ((ConstStmtIterator)children$Const().begin());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::Stmt::child_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 420,
   FQN="clang::Stmt::child_end", NM="_ZNK5clang4Stmt9child_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZNK5clang4Stmt9child_endEv")
  //</editor-fold>
  public ConstStmtIterator child_end$Const() /*const*/ {
    return ((ConstStmtIterator)children$Const().end());
  }

  
  /// \brief Produce a unique representation of the given statement.
  ///
  /// \param ID once the profiling operation is complete, will contain
  /// the unique representation of the given statement.
  ///
  /// \param Context the AST context in which the statement resides
  ///
  /// \param Canonical whether the profile should be based on the canonical
  /// representation of this statement (e.g., where non-type template
  /// parameters are identified by index/level rather than their
  /// declaration pointers) or the exact representation of the statement as
  /// written in the source.
  
  /// \brief Produce a unique representation of the given statement.
  ///
  /// \param ID once the profiling operation is complete, will contain
  /// the unique representation of the given statement.
  ///
  /// \param Context the AST context in which the statement resides
  ///
  /// \param Canonical whether the profile should be based on the canonical
  /// representation of this statement (e.g., where non-type template
  /// parameters are identified by index/level rather than their
  /// declaration pointers) or the exact representation of the statement as
  /// written in the source.
  //<editor-fold defaultstate="collapsed" desc="clang::Stmt::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp", line = 1758,
   FQN="clang::Stmt::Profile", NM="_ZNK5clang4Stmt7ProfileERN4llvm16FoldingSetNodeIDERKNS_10ASTContextEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtProfile.cpp -nm=_ZNK5clang4Stmt7ProfileERN4llvm16FoldingSetNodeIDERKNS_10ASTContextEb")
  //</editor-fold>
  public void Profile(final FoldingSetNodeID /*&*/ ID, final /*const*/ ASTContext /*&*/ Context, 
         boolean Canonical) /*const*/ {
    StmtProfiler Profiler/*J*/= new StmtProfiler(ID, Context, Canonical);
    Profiler.Visit(this);
  }
 
  //<editor-fold defaultstate="collapsed" desc="clang::Stmt::operator new">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Stmt.h", line = 287,
   FQN="clang::Stmt::operator new", NM="_ZN5clang4StmtnwEjPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDumper.cpp -nm=_ZN5clang4StmtnwEjPv")
  //</editor-fold>  
  public/*public*/ static <T extends Stmt> T/*P*/ $new(final Object/*void P*/ Mem, New$ConstructorCallback<T/*P*/> New$Ctr) {
    // this is Stms with possible trailings
    return TrailingObjectsUtils.$new_uint_voidPtr(MemoryForStmt$Supplier, Mem, New$Ctr);
  }  
  
  // Only allow allocation of Stmts using the allocator in ASTContext
  // or by doing a placement new.
  // Only allow allocation of Stmts using the allocator in ASTContext
  // or by doing a placement new.
  //<editor-fold defaultstate="collapsed" desc="clang::Stmt::operator new">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*resolve recursion*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp", line = 53,
   FQN="clang::Stmt::operator new", NM="_ZN5clang4StmtnwEjRKNS_10ASTContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Stmt.cpp -nm=_ZN5clang4StmtnwEjRKNS_10ASTContextEj")
  //</editor-fold>  
  public static <T extends Stmt> T/*P*/ $new_uint_ASTContext$C_uint(final /*const*/ ASTContext /*&*/ C, New$ConstructorCallback<T/*P*/> New$StmtCtr) {
    return $new_uint_ASTContext$C_uint(C, /*JAVA*/1, New$StmtCtr);
  }
  public static <T extends Stmt> T/*P*/ $new_uint_ASTContext$C_uint(final /*const*/ ASTContext /*&*/ C, int Alignment, New$ConstructorCallback<T/*P*/> New$StmtCtr) {
    type$ptr Mem = C.Allocate$JavaRef();
    return $new_uint_ASTContext$C_uint(C, Alignment, Mem, New$StmtCtr);
  }
  public static <T extends Stmt> T/*P*/ $new_uint_ASTContext$C_uint(final /*const*/ ASTContext /*&*/ C, int Alignment, type$ptr<?> Mem, New$ConstructorCallback<T/*P*/> New$StmtCtr) {
    // TODO: keep $this in created Stmt?
    return TrailingObjectsUtils.$new_uint_voidPtr(MemoryForStmt$Supplier, Mem, New$StmtCtr);
  }
  
  public static <T extends Stmt> T/*P*/ $new_uint_ASTContext$C$P_uint(final /*const*/ ASTContext /*&*/ C, New$ConstructorCallback<T/*P*/> New$StmtCtr) {
    return $new_uint_ASTContext$C_uint(C, /*JAVA*/1, New$StmtCtr);
  }
  public static <T extends Stmt> T/*P*/ $new_uint_ASTContext$C$P_uint(final /*const*/ ASTContext /*&*/ C, int Alignment, New$ConstructorCallback<T/*P*/> New$StmtCtr) {
    return $new_uint_ASTContext$C_uint(C, Alignment, New$StmtCtr);
  }
  
  protected Stmt(Stmt other) {
    Unnamed_field.CallExprBits.NumPreArgs = other.Unnamed_field.CallExprBits.NumPreArgs;
    Unnamed_field.CastExprBits.BasePathSize = other.Unnamed_field.CastExprBits.BasePathSize;
    Unnamed_field.CastExprBits.Kind = other.Unnamed_field.CastExprBits.Kind;
    Unnamed_field.CharacterLiteralBits.Kind = other.Unnamed_field.CharacterLiteralBits.Kind;
    Unnamed_field.CompoundStmtBits.NumStmts = other.Unnamed_field.CompoundStmtBits.NumStmts;
    Unnamed_field.DeclRefExprBits.HadMultipleCandidates = other.Unnamed_field.DeclRefExprBits.HadMultipleCandidates;
    Unnamed_field.DeclRefExprBits.HasFoundDecl = other.Unnamed_field.DeclRefExprBits.HasFoundDecl;
    Unnamed_field.DeclRefExprBits.HasQualifier = other.Unnamed_field.DeclRefExprBits.HasQualifier;
    Unnamed_field.DeclRefExprBits.HasTemplateKWAndArgsInfo = other.Unnamed_field.DeclRefExprBits.HasTemplateKWAndArgsInfo;
    Unnamed_field.DeclRefExprBits.RefersToEnclosingVariableOrCapture = other.Unnamed_field.DeclRefExprBits.RefersToEnclosingVariableOrCapture;
    Unnamed_field.ExprBits.ContainsUnexpandedParameterPack = other.Unnamed_field.ExprBits.ContainsUnexpandedParameterPack;
    Unnamed_field.ExprBits.InstantiationDependent = other.Unnamed_field.ExprBits.InstantiationDependent;
    Unnamed_field.ExprBits.TypeDependent = other.Unnamed_field.ExprBits.TypeDependent;
    Unnamed_field.ExprBits.ValueDependent = other.Unnamed_field.ExprBits.ValueDependent;
    Unnamed_field.ExprBits.ObjectKind = other.Unnamed_field.ExprBits.ObjectKind;
    Unnamed_field.ExprBits.ValueKind = other.Unnamed_field.ExprBits.ValueKind;
    Unnamed_field.ExprWithCleanupsBits.CleanupsHaveSideEffects = other.Unnamed_field.ExprWithCleanupsBits.CleanupsHaveSideEffects;
    Unnamed_field.ExprWithCleanupsBits.NumObjects = other.Unnamed_field.ExprWithCleanupsBits.NumObjects;
    Unnamed_field.FloatingLiteralBits.IsExact = other.Unnamed_field.FloatingLiteralBits.IsExact;
    Unnamed_field.FloatingLiteralBits.Semantics = other.Unnamed_field.FloatingLiteralBits.Semantics;
    Unnamed_field.IfStmtBits.IsConstexpr = other.Unnamed_field.IfStmtBits.IsConstexpr;
    Unnamed_field.InitListExprBits.HadArrayRangeDesignator = other.Unnamed_field.InitListExprBits.HadArrayRangeDesignator;
    Unnamed_field.ObjCIndirectCopyRestoreExprBits.ShouldCopy = other.Unnamed_field.ObjCIndirectCopyRestoreExprBits.ShouldCopy;
    Unnamed_field.PseudoObjectExprBits.NumSubExprs = other.Unnamed_field.PseudoObjectExprBits.NumSubExprs;
    Unnamed_field.PseudoObjectExprBits.ResultIndex = other.Unnamed_field.PseudoObjectExprBits.ResultIndex;
    Unnamed_field.StmtBits.sClass = other.Unnamed_field.StmtBits.sClass;
    Unnamed_field.TypeTraitExprBits.Kind = other.Unnamed_field.TypeTraitExprBits.Kind;
    Unnamed_field.TypeTraitExprBits.NumArgs = other.Unnamed_field.TypeTraitExprBits.NumArgs;
    Unnamed_field.TypeTraitExprBits.Value = other.Unnamed_field.TypeTraitExprBits.Value;
    Unnamed_field.UnaryExprOrTypeTraitExprBits.IsType = other.Unnamed_field.UnaryExprOrTypeTraitExprBits.IsType;
    Unnamed_field.UnaryExprOrTypeTraitExprBits.Kind = other.Unnamed_field.UnaryExprOrTypeTraitExprBits.Kind;
  }
  
  private static boolean assertThisConsumedByCreatedStmt(Stmt createdObj, type$ptr Mem) {
    // Not all classes derived from Stmt have trailing objects.
    // They must pass Mem as null into Stmt.$new(null, CtrLambda);
    assert createdObj != null;
    assert Mem != null;
    if (ThreadLocalThisSupplier.isNullMemoryMarker(Mem)) {
      assert /*REMOVE*/true || !(createdObj instanceof TrailingObjects) : "when create TrailingObjects child " + NativeTrace.getIdentityStr(createdObj) + ", then Mem must be provided externally";
      assert !(createdObj instanceof ITrailingObjectsJavaBase) : "when create ITrailingObjectsJavaBase child " + NativeTrace.getIdentityStr(createdObj) + ", then Mem must be provided externally";
      assert /*REMOVE*/(createdObj.$this$plus1 == null) || (createdObj.$this$plus1.$array() == null && createdObj.$this$plus1.$index() == 1);
    } else {
      assert /*REMOVE*/true || (createdObj instanceof TrailingObjects) || (createdObj instanceof ITrailingObjectsJavaBase): "when create Stmt child " + NativeTrace.getIdentityStr(createdObj) + ", then Mem must be null, as Stmt.$new(null, ...) or class must be ITrailingObjectsJavaBase or TrailingObjects derived";
      assert Mem.$star() == createdObj : "createdDecl should be in Mem, but got: " + Mem.$star();
      assert createdObj.$this$plus1.$sub(1).$eq(Mem) : "expected " + Mem + " vs. " + createdObj.$this$plus1.$sub(1);
    }
    return true;
  }
  
  private static final ThreadLocalThisSupplier<Stmt> MemoryForStmt$Supplier = ThreadLocalThisSupplier.Create(Stmt::assertThisConsumedByCreatedStmt, Stmt.class.getName(), true);
  
  private final type$ptr<?> $this$plus1 = $toConst(MemoryForStmt$Supplier.consumeAssignedMemory$GetThisPlus1(this));
  
  protected final type$ptr<?> $this() {
    assert $this$plus1 != null;
    return $this$plus1.$sub(1);
  }
  
  protected final type$ptr<?> $this$plus1() {
    return $this$plus1;
  }
  
  public type$ptr<?> $TrailingObjects() {
    return $this$plus1();
  }
  
  @Override public String toString() {
    if (true) {
      std.string Buf = new std.string();
      raw_string_ostream OS = new raw_string_ostream(Buf);
      this.printPretty(OS, null, new PrintingPolicy(new LangOptions()));
      OS.flush();
      return "[" + Buf.toJavaString() + "]"; // NOI18N
    }
    return "" + "Unnamed_field=" + Unnamed_field; // NOI18N
  }
}
