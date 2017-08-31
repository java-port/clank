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

import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.ast.llvm.*;
import org.clang.ast.FunctionProtoType.*;
import org.clang.basic.*;
import static org.clang.basic.BasicClangGlobals.*;
import static org.clang.basic.PartialDiagnostic.*;
import static org.clang.sema.Sema_NestedClasses.SemaDiagnosticBuilder.*;
import static org.clang.ast.QualType.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.sema.impl.SemaExceptionSpecClangStatics.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type Sema_SemaExceptionSpec">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this -extends=Sema_SemaDeclObjC ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExceptionSpec.cpp -nm=_ZN5clang4Sema19UpdateExceptionSpecEPNS_12FunctionDeclERKNS_17FunctionProtoType17ExceptionSpecInfoE;_ZN5clang4Sema20ResolveExceptionSpecENS_14SourceLocationEPKNS_17FunctionProtoTypeE;_ZN5clang4Sema23CheckParamExceptionSpecERKNS_17PartialDiagnosticEPKNS_17FunctionProtoTypeENS_14SourceLocationES6_S7_;_ZN5clang4Sema24CheckExceptionSpecSubsetERKNS_17PartialDiagnosticES3_PKNS_17FunctionProtoTypeENS_14SourceLocationES6_S7_;_ZN5clang4Sema25CheckDistantExceptionSpecENS_8QualTypeE;_ZN5clang4Sema27CheckSpecifiedExceptionTypeERNS_8QualTypeENS_11SourceRangeE;_ZN5clang4Sema28CheckEquivalentExceptionSpecEPKNS_17FunctionProtoTypeENS_14SourceLocationES3_S4_;_ZN5clang4Sema28CheckEquivalentExceptionSpecEPNS_12FunctionDeclES2_;_ZN5clang4Sema28CheckEquivalentExceptionSpecERKNS_17PartialDiagnosticES3_PKNS_17FunctionProtoTypeENS_14SourceLocationES6_S7_PbS8_bb;_ZN5clang4Sema31CheckExceptionSpecCompatibilityEPNS_4ExprENS_8QualTypeE;_ZN5clang4Sema33isLibstdcxxEagerExceptionSpecHackERKNS_10DeclaratorE;_ZN5clang4Sema36CheckOverridingFunctionExceptionSpecEPKNS_13CXXMethodDeclES3_;_ZN5clang4Sema8canThrowEPKNS_4ExprE; -static-type=Sema_SemaExceptionSpec -package=org.clang.sema")
//</editor-fold>
public class Sema_SemaExceptionSpec extends Sema_SemaDeclObjC {
private final /*split clang::Sema*/ Sema $this() { return (Sema)this; }

//<editor-fold defaultstate="collapsed" desc="clang::Sema::canThrow">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExceptionSpec.cpp", line = 950,
 FQN="clang::Sema::canThrow", NM="_ZN5clang4Sema8canThrowEPKNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExceptionSpec.cpp -nm=_ZN5clang4Sema8canThrowEPKNS_4ExprE")
//</editor-fold>
public final CanThrowResult canThrow(/*const*/ Expr /*P*/ E) {
  // C++ [expr.unary.noexcept]p3:
  //   [Can throw] if in a potentially-evaluated context the expression would
  //   contain:
  switch (E.getStmtClass()) {
   case CXXThrowExprClass:
    //   - a potentially evaluated throw-expression
    return CanThrowResult.CT_Can;
   case CXXDynamicCastExprClass:
    {
      //   - a potentially evaluated dynamic_cast expression dynamic_cast<T>(v),
      //     where T is a reference type, that requires a run-time check
      CanThrowResult CT = canDynamicCastThrow(cast_CXXDynamicCastExpr(E));
      if (CT == CanThrowResult.CT_Can) {
        return CT;
      }
      return mergeCanThrow(CT, canSubExprsThrow(/*Deref*/$this(), E));
    }
   case CXXTypeidExprClass:
    //   - a potentially evaluated typeid expression applied to a glvalue
    //     expression whose type is a polymorphic class type
    return canTypeidThrow(/*Deref*/$this(), cast_CXXTypeidExpr(E));
   case CallExprClass:
   case CXXMemberCallExprClass:
   case CXXOperatorCallExprClass:
   case UserDefinedLiteralClass:
    {
      /*const*/ CallExpr /*P*/ CE = cast_CallExpr(E);
      CanThrowResult CT;
      if (E.isTypeDependent()) {
        CT = CanThrowResult.CT_Dependent;
      } else if (isa_CXXPseudoDestructorExpr(CE.getCallee$Const().IgnoreParens$Const())) {
        CT = CanThrowResult.CT_Cannot;
      } else if ((CE.getCalleeDecl$Const() != null)) {
        CT = canCalleeThrow(/*Deref*/$this(), E, CE.getCalleeDecl$Const());
      } else {
        CT = CanThrowResult.CT_Can;
      }
      if (CT == CanThrowResult.CT_Can) {
        return CT;
      }
      return mergeCanThrow(CT, canSubExprsThrow(/*Deref*/$this(), E));
    }
   case CXXConstructExprClass:
   case CXXTemporaryObjectExprClass:
    {
      CanThrowResult CT = canCalleeThrow(/*Deref*/$this(), E, 
          cast_CXXConstructExpr(E).getConstructor());
      if (CT == CanThrowResult.CT_Can) {
        return CT;
      }
      return mergeCanThrow(CT, canSubExprsThrow(/*Deref*/$this(), E));
    }
   case CXXInheritedCtorInitExprClass:
    return canCalleeThrow(/*Deref*/$this(), E, 
        cast_CXXInheritedCtorInitExpr(E).getConstructor());
   case LambdaExprClass:
    {
      /*const*/ LambdaExpr /*P*/ Lambda = cast_LambdaExpr(E);
      CanThrowResult CT = CanThrowResult.CT_Cannot;
      for (type$ptr<Expr /*P*/ /*const*/ /*P*/> Cap = $tryClone(Lambda.capture_init_begin$Const()), 
          /*P*/ /*const*/ /*P*/ CapEnd = $tryClone(Lambda.capture_init_end$Const());
           $noteq_ptr(Cap, CapEnd); Cap.$preInc())  {
        CT = mergeCanThrow(CT, $this().canThrow(Cap.$star()));
      }
      return CT;
    }
   case CXXNewExprClass:
    {
      CanThrowResult CT;
      if (E.isTypeDependent()) {
        CT = CanThrowResult.CT_Dependent;
      } else {
        CT = canCalleeThrow(/*Deref*/$this(), E, cast_CXXNewExpr(E).getOperatorNew());
      }
      if (CT == CanThrowResult.CT_Can) {
        return CT;
      }
      return mergeCanThrow(CT, canSubExprsThrow(/*Deref*/$this(), E));
    }
   case CXXDeleteExprClass:
    {
      CanThrowResult CT;
      QualType DTy = cast_CXXDeleteExpr(E).getDestroyedType();
      if (DTy.isNull() || DTy.$arrow().isDependentType()) {
        CT = CanThrowResult.CT_Dependent;
      } else {
        CT = canCalleeThrow(/*Deref*/$this(), E, 
            cast_CXXDeleteExpr(E).getOperatorDelete());
        {
          /*const*/ RecordType /*P*/ RT = DTy.$arrow().getAs$RecordType();
          if ((RT != null)) {
            /*const*/ CXXRecordDecl /*P*/ RD = cast_CXXRecordDecl(RT.getDecl());
            /*const*/ CXXDestructorDecl /*P*/ DD = RD.getDestructor();
            if ((DD != null)) {
              CT = mergeCanThrow(CT, canCalleeThrow(/*Deref*/$this(), E, DD));
            }
          }
        }
        if (CT == CanThrowResult.CT_Can) {
          return CT;
        }
      }
      return mergeCanThrow(CT, canSubExprsThrow(/*Deref*/$this(), E));
    }
   case CXXBindTemporaryExprClass:
    {
      // The bound temporary has to be destroyed again, which might throw.
      CanThrowResult CT = canCalleeThrow(/*Deref*/$this(), E, 
          cast_CXXBindTemporaryExpr(E).getTemporary$Const().getDestructor());
      if (CT == CanThrowResult.CT_Can) {
        return CT;
      }
      return mergeCanThrow(CT, canSubExprsThrow(/*Deref*/$this(), E));
    }
   case ObjCMessageExprClass:
   case ObjCPropertyRefExprClass:
   case ObjCSubscriptRefExprClass:
    
    // ObjC message sends are like function calls, but never have exception
    // specs.
    return CanThrowResult.CT_Can;
   case ObjCArrayLiteralClass:
   case ObjCDictionaryLiteralClass:
   case ObjCBoxedExprClass:
    
    // All the ObjC literals that are implemented as calls are
    // potentially throwing unless we decide to close off that
    // possibility.
    return CanThrowResult.CT_Can;
   case CoawaitExprClass:
   case ConditionalOperatorClass:
   case CompoundLiteralExprClass:
   case CoyieldExprClass:
   case CXXConstCastExprClass:
   case CXXReinterpretCastExprClass:
   case CXXStdInitializerListExprClass:
   case DesignatedInitExprClass:
   case DesignatedInitUpdateExprClass:
   case ExprWithCleanupsClass:
   case ExtVectorElementExprClass:
   case InitListExprClass:
   case MemberExprClass:
   case ObjCIsaExprClass:
   case ObjCIvarRefExprClass:
   case ParenExprClass:
   case ParenListExprClass:
   case ShuffleVectorExprClass:
   case ConvertVectorExprClass:
   case VAArgExprClass:
    
    // Many other things have subexpressions, so we have to test those.
    // Some are simple:
    return canSubExprsThrow(/*Deref*/$this(), E);
   case ArraySubscriptExprClass:
   case OMPArraySectionExprClass:
   case BinaryOperatorClass:
   case CompoundAssignOperatorClass:
   case CStyleCastExprClass:
   case CXXStaticCastExprClass:
   case CXXFunctionalCastExprClass:
   case ImplicitCastExprClass:
   case MaterializeTemporaryExprClass:
   case UnaryOperatorClass:
    {
      CanThrowResult CT = E.isTypeDependent() ? CanThrowResult.CT_Dependent : CanThrowResult.CT_Cannot;
      return mergeCanThrow(CT, canSubExprsThrow(/*Deref*/$this(), E));
    }
   case StmtExprClass:
    
    // FIXME: We should handle StmtExpr, but that opens a MASSIVE can of worms.
    return CanThrowResult.CT_Can;
   case CXXDefaultArgExprClass:
    return $this().canThrow(cast_CXXDefaultArgExpr(E).getExpr$Const());
   case CXXDefaultInitExprClass:
    return $this().canThrow(cast_CXXDefaultInitExpr(E).getExpr$Const());
   case ChooseExprClass:
    if (E.isTypeDependent() || E.isValueDependent()) {
      return CanThrowResult.CT_Dependent;
    }
    return $this().canThrow(cast_ChooseExpr(E).getChosenSubExpr());
   case GenericSelectionExprClass:
    if (cast_GenericSelectionExpr(E).isResultDependent()) {
      return CanThrowResult.CT_Dependent;
    }
    return $this().canThrow(cast_GenericSelectionExpr(E).getResultExpr$Const());
   case CXXDependentScopeMemberExprClass:
   case CXXUnresolvedConstructExprClass:
   case DependentScopeDeclRefExprClass:
   case CXXFoldExprClass:
    
    // Some expressions are always dependent.
    return CanThrowResult.CT_Dependent;
   case AsTypeExprClass:
   case BinaryConditionalOperatorClass:
   case BlockExprClass:
   case CUDAKernelCallExprClass:
   case DeclRefExprClass:
   case ObjCBridgedCastExprClass:
   case ObjCIndirectCopyRestoreExprClass:
   case ObjCProtocolExprClass:
   case ObjCSelectorExprClass:
   case ObjCAvailabilityCheckExprClass:
   case OffsetOfExprClass:
   case PackExpansionExprClass:
   case PseudoObjectExprClass:
   case SubstNonTypeTemplateParmExprClass:
   case SubstNonTypeTemplateParmPackExprClass:
   case FunctionParmPackExprClass:
   case UnaryExprOrTypeTraitExprClass:
   case UnresolvedLookupExprClass:
   case UnresolvedMemberExprClass:
   case TypoExprClass:
    // FIXME: Can any of the above throw?  If so, when?
    return CanThrowResult.CT_Cannot;
   case AddrLabelExprClass:
   case ArrayTypeTraitExprClass:
   case AtomicExprClass:
   case TypeTraitExprClass:
   case CXXBoolLiteralExprClass:
   case CXXNoexceptExprClass:
   case CXXNullPtrLiteralExprClass:
   case CXXPseudoDestructorExprClass:
   case CXXScalarValueInitExprClass:
   case CXXThisExprClass:
   case CXXUuidofExprClass:
   case CharacterLiteralClass:
   case ExpressionTraitExprClass:
   case FloatingLiteralClass:
   case GNUNullExprClass:
   case ImaginaryLiteralClass:
   case ImplicitValueInitExprClass:
   case IntegerLiteralClass:
   case NoInitExprClass:
   case ObjCEncodeExprClass:
   case ObjCStringLiteralClass:
   case ObjCBoolLiteralExprClass:
   case OpaqueValueExprClass:
   case PredefinedExprClass:
   case SizeOfPackExprClass:
   case StringLiteralClass:
    // These expressions can never throw.
    return CanThrowResult.CT_Cannot;
   case MSPropertyRefExprClass:
   case MSPropertySubscriptExprClass:
    throw new llvm_unreachable("Invalid class for expression");
   case GCCAsmStmtClass:
   case MSAsmStmtClass:
   case AttributedStmtClass:
   case BreakStmtClass:
   case CXXCatchStmtClass:
   case CXXForRangeStmtClass:
   case CXXTryStmtClass:
   case CapturedStmtClass:
   case CompoundStmtClass:
   case ContinueStmtClass:
   case CoreturnStmtClass:
   case CoroutineBodyStmtClass:
   case DeclStmtClass:
   case DoStmtClass:
   case ForStmtClass:
   case GotoStmtClass:
   case IfStmtClass:
   case IndirectGotoStmtClass:
   case LabelStmtClass:
   case MSDependentExistsStmtClass:
   case NullStmtClass:
   case OMPAtomicDirectiveClass:
   case OMPBarrierDirectiveClass:
   case OMPCancelDirectiveClass:
   case OMPCancellationPointDirectiveClass:
   case OMPCriticalDirectiveClass:
   case OMPFlushDirectiveClass:
   case OMPDistributeDirectiveClass:
   case OMPDistributeParallelForDirectiveClass:
   case OMPDistributeParallelForSimdDirectiveClass:
   case OMPDistributeSimdDirectiveClass:
   case OMPForDirectiveClass:
   case OMPForSimdDirectiveClass:
   case OMPParallelForDirectiveClass:
   case OMPParallelForSimdDirectiveClass:
   case OMPSimdDirectiveClass:
   case OMPTargetParallelForSimdDirectiveClass:
   case OMPTaskLoopDirectiveClass:
   case OMPTaskLoopSimdDirectiveClass:
   case OMPMasterDirectiveClass:
   case OMPOrderedDirectiveClass:
   case OMPParallelDirectiveClass:
   case OMPParallelSectionsDirectiveClass:
   case OMPSectionDirectiveClass:
   case OMPSectionsDirectiveClass:
   case OMPSingleDirectiveClass:
   case OMPTargetDataDirectiveClass:
   case OMPTargetDirectiveClass:
   case OMPTargetEnterDataDirectiveClass:
   case OMPTargetExitDataDirectiveClass:
   case OMPTargetParallelDirectiveClass:
   case OMPTargetParallelForDirectiveClass:
   case OMPTargetUpdateDirectiveClass:
   case OMPTaskDirectiveClass:
   case OMPTaskgroupDirectiveClass:
   case OMPTaskwaitDirectiveClass:
   case OMPTaskyieldDirectiveClass:
   case OMPTeamsDirectiveClass:
   case ObjCAtCatchStmtClass:
   case ObjCAtFinallyStmtClass:
   case ObjCAtSynchronizedStmtClass:
   case ObjCAtThrowStmtClass:
   case ObjCAtTryStmtClass:
   case ObjCAutoreleasePoolStmtClass:
   case ObjCForCollectionStmtClass:
   case ReturnStmtClass:
   case SEHExceptStmtClass:
   case SEHFinallyStmtClass:
   case SEHLeaveStmtClass:
   case SEHTryStmtClass:
   case CaseStmtClass:
   case DefaultStmtClass:
   case SwitchStmtClass:
   case WhileStmtClass:
   case NoStmtClass:
    throw new llvm_unreachable("Invalid class for expression");
  }
  throw new llvm_unreachable("Bogus StmtClass");
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ResolveExceptionSpec">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExceptionSpec.cpp", line = 146,
 FQN="clang::Sema::ResolveExceptionSpec", NM="_ZN5clang4Sema20ResolveExceptionSpecENS_14SourceLocationEPKNS_17FunctionProtoTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExceptionSpec.cpp -nm=_ZN5clang4Sema20ResolveExceptionSpecENS_14SourceLocationEPKNS_17FunctionProtoTypeE")
//</editor-fold>
public final /*const*/ FunctionProtoType /*P*/ ResolveExceptionSpec(SourceLocation Loc, /*const*/ FunctionProtoType /*P*/ FPT) {
  if (FPT.getExceptionSpecType() == ExceptionSpecificationType.EST_Unparsed) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track($this().Diag(new SourceLocation(Loc), diag.err_exception_spec_not_parsed)));
      return null;
    } finally {
      $c$.$destroy();
    }
  }
  if (!isUnresolvedExceptionSpec(FPT.getExceptionSpecType())) {
    return FPT;
  }
  
  FunctionDecl /*P*/ SourceDecl = FPT.getExceptionSpecDecl();
  /*const*/ FunctionProtoType /*P*/ SourceFPT = SourceDecl.getType().$arrow().castAs(FunctionProtoType.class);
  
  // If the exception specification has already been resolved, just return it.
  if (!isUnresolvedExceptionSpec(SourceFPT.getExceptionSpecType())) {
    return SourceFPT;
  }
  
  // Compute or instantiate the exception specification now.
  if (SourceFPT.getExceptionSpecType() == ExceptionSpecificationType.EST_Unevaluated) {
    $this().EvaluateImplicitExceptionSpec(new SourceLocation(Loc), cast_CXXMethodDecl(SourceDecl));
  } else {
    $this().InstantiateExceptionSpec(new SourceLocation(Loc), SourceDecl);
  }
  
  /*const*/ FunctionProtoType /*P*/ Proto = SourceDecl.getType().$arrow().castAs(FunctionProtoType.class);
  if (Proto.getExceptionSpecType() == org.clang.basic.ExceptionSpecificationType.EST_Unparsed) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track($this().Diag(new SourceLocation(Loc), diag.err_exception_spec_not_parsed)));
      Proto = null;
    } finally {
      $c$.$destroy();
    }
  }
  return Proto;
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::UpdateExceptionSpec">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExceptionSpec.cpp", line = 179,
 FQN="clang::Sema::UpdateExceptionSpec", NM="_ZN5clang4Sema19UpdateExceptionSpecEPNS_12FunctionDeclERKNS_17FunctionProtoType17ExceptionSpecInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExceptionSpec.cpp -nm=_ZN5clang4Sema19UpdateExceptionSpecEPNS_12FunctionDeclERKNS_17FunctionProtoType17ExceptionSpecInfoE")
//</editor-fold>
public final void UpdateExceptionSpec(FunctionDecl /*P*/ FD, 
                   final /*const*/ FunctionProtoType.ExceptionSpecInfo /*&*/ ESI) {
  // If we've fully resolved the exception specification, notify listeners.
  if (!isUnresolvedExceptionSpec(ESI.Type)) {
    {
      ASTMutationListener /*P*/ Listener = $this().getASTMutationListener();
      if ((Listener != null)) {
        Listener.ResolvedExceptionSpec(FD);
      }
    }
  }
  
  for (FunctionDecl /*P*/ Redecl : FD.redeclarable_redecls())  {
    $this().Context.adjustExceptionSpec(cast_FunctionDecl(Redecl), ESI);
  }
}


/// CheckSpecifiedExceptionType - Check if the given type is valid in an
/// exception specification. Incomplete types, or pointers to incomplete types
/// other than void are not allowed.
///
/// \param[in,out] T  The exception type. This will be decayed to a pointer type
///                   when the input is an array or a function type.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckSpecifiedExceptionType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExceptionSpec.cpp", line = 71,
 FQN="clang::Sema::CheckSpecifiedExceptionType", NM="_ZN5clang4Sema27CheckSpecifiedExceptionTypeERNS_8QualTypeENS_11SourceRangeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExceptionSpec.cpp -nm=_ZN5clang4Sema27CheckSpecifiedExceptionTypeERNS_8QualTypeENS_11SourceRangeE")
//</editor-fold>
public final boolean CheckSpecifiedExceptionType(final QualType /*&*/ T, SourceRange Range) {
  // C++11 [except.spec]p2:
  //   A type cv T, "array of T", or "function returning T" denoted
  //   in an exception-specification is adjusted to type T, "pointer to T", or
  //   "pointer to function returning T", respectively.
  //
  // We also apply this rule in C++98.
  if (T.$arrow().isArrayType()) {
    T.$assignMove($this().Context.getArrayDecayedType(new QualType(T)));
  } else if (T.$arrow().isFunctionType()) {
    T.$assignMove($this().Context.getPointerType(new QualType(T)));
  }
  
  int Kind = 0;
  QualType PointeeT = new QualType(T);
  {
    /*const*/ PointerType /*P*/ PT = T.$arrow().getAs(PointerType.class);
    if ((PT != null)) {
      PointeeT.$assignMove(PT.getPointeeType());
      Kind = 1;
      
      // cv void* is explicitly permitted, despite being a pointer to an
      // incomplete type.
      if (PointeeT.$arrow().isVoidType()) {
        return false;
      }
    } else {
      /*const*/ ReferenceType /*P*/ RT = T.$arrow().getAs(ReferenceType.class);
      if ((RT != null)) {
        PointeeT.$assignMove(RT.getPointeeType());
        Kind = 2;
        if (RT.isRValueReferenceType()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            // C++11 [except.spec]p2:
            //   A type denoted in an exception-specification shall not denote [...]
            //   an rvalue reference type.
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Range.getBegin(), diag.err_rref_in_exception_spec)), 
                    T), Range));
            return true;
          } finally {
            $c$.$destroy();
          }
        }
      }
    }
  }
  
  // C++11 [except.spec]p2:
  //   A type denoted in an exception-specification shall not denote an
  //   incomplete type other than a class currently being defined [...].
  //   A type denoted in an exception-specification shall not denote a
  //   pointer or reference to an incomplete type, other than (cv) void* or a
  //   pointer or reference to a class currently being defined.
  // In Microsoft mode, downgrade this to a warning.
  /*uint*/int DiagID = diag.err_incomplete_in_exception_spec;
  boolean ReturnValueOnError = true;
  if ($this().getLangOpts().MicrosoftExt) {
    DiagID = diag.ext_incomplete_in_exception_spec;
    ReturnValueOnError = false;
  }
  if (!(PointeeT.$arrow().isRecordType()
     && PointeeT.$arrow().getAs$RecordType().isBeingDefined())
     && $this().RequireCompleteType$T(Range.getBegin(), new QualType(PointeeT), DiagID, Kind, Range)) {
    return ReturnValueOnError;
  }
  
  return false;
}


/// CheckDistantExceptionSpec - Check if the given type is a pointer or pointer
/// to member to a function with an exception specification. This means that
/// it is invalid to add another level of indirection.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckDistantExceptionSpec">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExceptionSpec.cpp", line = 131,
 FQN="clang::Sema::CheckDistantExceptionSpec", NM="_ZN5clang4Sema25CheckDistantExceptionSpecENS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExceptionSpec.cpp -nm=_ZN5clang4Sema25CheckDistantExceptionSpecENS_8QualTypeE")
//</editor-fold>
public final boolean CheckDistantExceptionSpec(QualType T) {
  {
    /*const*/ PointerType /*P*/ PT = T.$arrow().getAs(PointerType.class);
    if ((PT != null)) {
      T.$assignMove(PT.getPointeeType());
    } else {
      /*const*/ MemberPointerType /*P*/ PT$1 = T.$arrow().getAs(MemberPointerType.class);
      if ((PT$1 != null)) {
        T.$assignMove(PT$1.getPointeeType());
      } else {
        return false;
      }
    }
  }
  
  /*const*/ FunctionProtoType /*P*/ FnT = T.$arrow().getAs(FunctionProtoType.class);
  if (!(FnT != null)) {
    return false;
  }
  
  return FnT.hasExceptionSpec();
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckEquivalentExceptionSpec">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExceptionSpec.cpp", line = 212,
 FQN="clang::Sema::CheckEquivalentExceptionSpec", NM="_ZN5clang4Sema28CheckEquivalentExceptionSpecEPNS_12FunctionDeclES2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExceptionSpec.cpp -nm=_ZN5clang4Sema28CheckEquivalentExceptionSpecEPNS_12FunctionDeclES2_")
//</editor-fold>
public final boolean CheckEquivalentExceptionSpec(FunctionDecl /*P*/ Old, FunctionDecl /*P*/ New) {
  raw_svector_ostream OS = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    OverloadedOperatorKind OO = New.getDeclName().getCXXOverloadedOperator();
    boolean IsOperatorNew = OO == OverloadedOperatorKind.OO_New || OO == OverloadedOperatorKind.OO_Array_New;
    bool$ptr MissingExceptionSpecification = create_bool$ptr(false);
    bool$ptr MissingEmptyExceptionSpecification = create_bool$ptr(false);
    
    /*uint*/int DiagID = diag.err_mismatched_exception_spec;
    boolean ReturnValueOnError = true;
    if ($this().getLangOpts().MicrosoftExt) {
      DiagID = diag.ext_mismatched_exception_spec;
      ReturnValueOnError = false;
    }
    
    // Check the types as written: they must match before any exception
    // specification adjustment is applied.
    if ($c$.clean(!$this().CheckEquivalentExceptionSpec($c$.track($this().PDiag(DiagID)), $c$.track($this().PDiag(diag.note_previous_declaration)), 
        Old.getType().$arrow().getAs(FunctionProtoType.class), Old.getLocation(), 
        New.getType().$arrow().getAs(FunctionProtoType.class), New.getLocation(), 
        $AddrOf(MissingExceptionSpecification), $AddrOf(MissingEmptyExceptionSpecification), 
        /*AllowNoexceptAllMatchWithNoSpec=*/ true, IsOperatorNew))) {
      // C++11 [except.spec]p4 [DR1492]:
      //   If a declaration of a function has an implicit
      //   exception-specification, other declarations of the function shall
      //   not specify an exception-specification.
      if ($this().getLangOpts().CPlusPlus11
         && hasImplicitExceptionSpec(Old) != hasImplicitExceptionSpec(New)) {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(New.getLocation(), diag.ext_implicit_exception_spec_mismatch)), 
            hasImplicitExceptionSpec(Old)));
        if (Old.getLocation().isValid()) {
          $c$.clean($c$.track($this().Diag(Old.getLocation(), diag.note_previous_declaration)));
        }
      }
      return false;
    }
    
    // The failure was something other than an missing exception
    // specification; return an error, except in MS mode where this is a warning.
    if (!MissingExceptionSpecification.$star()) {
      return ReturnValueOnError;
    }
    
    /*const*/ FunctionProtoType /*P*/ NewProto = New.getType().$arrow().castAs(FunctionProtoType.class);
    
    // The new function declaration is only missing an empty exception
    // specification "throw()". If the throw() specification came from a
    // function in a system header that has C linkage, just add an empty
    // exception specification to the "new" declaration. This is an
    // egregious workaround for glibc, which adds throw() specifications
    // to many libc functions as an optimization. Unfortunately, that
    // optimization isn't permitted by the C++ standard, so we're forced
    // to work around it here.
    if (MissingEmptyExceptionSpecification.$star() && (NewProto != null)
       && (Old.getLocation().isInvalid()
       || $this().Context.getSourceManager().isInSystemHeader(Old.getLocation()))
       && Old.isExternC()) {
      New.setType($this().Context.getFunctionType(NewProto.getReturnType(), NewProto.getParamTypes(), 
              NewProto.getExtProtoInfo().withExceptionSpec(new ExceptionSpecInfo(ExceptionSpecificationType.EST_DynamicNone))));
      return false;
    }
    
    /*const*/ FunctionProtoType /*P*/ OldProto = Old.getType().$arrow().castAs(FunctionProtoType.class);
    
    FunctionProtoType.ExceptionSpecInfo ESI = new FunctionProtoType.ExceptionSpecInfo(OldProto.getExceptionSpecType());
    if (ESI.Type == ExceptionSpecificationType.EST_Dynamic) {
      ESI.Exceptions.$assignMove(OldProto.exceptions());
    }
    if (ESI.Type == ExceptionSpecificationType.EST_ComputedNoexcept) {
      // For computed noexcept, we can't just take the expression from the old
      // prototype. It likely contains references to the old prototype's
      // parameters.
      New.setInvalidDecl();
    } else {
      // Update the type of the function with the appropriate exception
      // specification.
      New.setType($this().Context.getFunctionType(NewProto.getReturnType(), NewProto.getParamTypes(), 
              NewProto.getExtProtoInfo().withExceptionSpec(ESI)));
    }
    if ($this().getLangOpts().MicrosoftExt && ESI.Type != ExceptionSpecificationType.EST_ComputedNoexcept) {
      // Allow missing exception specifications in redeclarations as an extension.
      DiagID = diag.ext_ms_missing_exception_specification;
      ReturnValueOnError = false;
    } else if (New.isReplaceableGlobalAllocationFunction()
       && ESI.Type != ExceptionSpecificationType.EST_ComputedNoexcept) {
      // Allow missing exception specifications in redeclarations as an extension,
      // when declaring a replaceable global allocation function.
      DiagID = diag.ext_missing_exception_specification;
      ReturnValueOnError = false;
    } else {
      DiagID = diag.err_missing_exception_specification;
      ReturnValueOnError = true;
    }
    
    // Warn about the lack of exception specification.
    SmallString/*128*/ ExceptionSpecString/*J*/= new SmallString/*128*/(128);
    OS/*J*/= new raw_svector_ostream(ExceptionSpecString);
    switch (OldProto.getExceptionSpecType()) {
     case EST_DynamicNone:
      OS.$out(/*KEEP_STR*/"throw()");
      break;
     case EST_Dynamic:
      {
        OS.$out(/*KEEP_STR*/"throw(");
        boolean OnFirstException = true;
        for (final /*const*/ QualType /*&*/ E : OldProto.exceptions()) {
          if (OnFirstException) {
            OnFirstException = false;
          } else {
            OS.$out(/*KEEP_STR*/$COMMA_SPACE);
          }
          
          OS.$out(E.getAsString($this().getPrintingPolicy()));
        }
        OS.$out(/*KEEP_STR*/$RPAREN);
        break;
      }
     case EST_BasicNoexcept:
      OS.$out(/*KEEP_STR*/$noexcept);
      break;
     case EST_ComputedNoexcept:
      OS.$out(/*KEEP_STR*/"noexcept(");
      assert (OldProto.getNoexceptExpr() != null) : "Expected non-null Expr";
      OldProto.getNoexceptExpr().printPretty(OS, (PrinterHelper /*P*/ )null, $this().getPrintingPolicy());
      OS.$out(/*KEEP_STR*/$RPAREN);
      break;
     default:
      throw new llvm_unreachable("This spec type is compatible with none.");
    }
    
    SourceLocation FixItLoc/*J*/= new SourceLocation();
    {
      TypeSourceInfo /*P*/ TSInfo = New.getTypeSourceInfo();
      if ((TSInfo != null)) {
        TypeLoc TL = TSInfo.getTypeLoc().IgnoreParens();
        {
          // FIXME: Preserve enough information so that we can produce a correct fixit
          // location when there is a trailing return type.
          FunctionProtoTypeLoc FTLoc = TL.getAs(FunctionProtoTypeLoc.class);
          if (FTLoc.$bool()) {
            if (!FTLoc.getTypePtr().hasTrailingReturn()) {
              FixItLoc.$assignMove($this().getLocForEndOfToken(FTLoc.getLocalRangeEnd()));
            }
          }
        }
      }
    }
    if (FixItLoc.isInvalid()) {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(New.getLocation(), DiagID)), 
              New), OS.str()));
    } else {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(New.getLocation(), DiagID)), 
                  New), OS.str()), 
          FixItHint.CreateInsertion(/*NO_COPY*/FixItLoc, new StringRef($add_T$C$P_string(/*KEEP_STR*/" ", OS.str().str())))));
    }
    if (Old.getLocation().isValid()) {
      $c$.clean($c$.track($this().Diag(Old.getLocation(), diag.note_previous_declaration)));
    }
    
    return ReturnValueOnError;
  } finally {
    if (OS != null) { OS.$destroy(); }
    $c$.$destroy();
  }
}


/// CheckEquivalentExceptionSpec - Check if the two types have equivalent
/// exception specifications. Exception specifications are equivalent if
/// they allow exactly the same set of exception types. It does not matter how
/// that is achieved. See C++ [except.spec]p2.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckEquivalentExceptionSpec">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExceptionSpec.cpp", line = 376,
 FQN="clang::Sema::CheckEquivalentExceptionSpec", NM="_ZN5clang4Sema28CheckEquivalentExceptionSpecEPKNS_17FunctionProtoTypeENS_14SourceLocationES3_S4_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExceptionSpec.cpp -nm=_ZN5clang4Sema28CheckEquivalentExceptionSpecEPKNS_17FunctionProtoTypeENS_14SourceLocationES3_S4_")
//</editor-fold>
public final boolean CheckEquivalentExceptionSpec(/*const*/ FunctionProtoType /*P*/ Old, SourceLocation OldLoc, 
                            /*const*/ FunctionProtoType /*P*/ New, SourceLocation NewLoc) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    /*uint*/int DiagID = diag.err_mismatched_exception_spec;
    if ($this().getLangOpts().MicrosoftExt) {
      DiagID = diag.ext_mismatched_exception_spec;
    }
    boolean Result = $c$.clean($this().CheckEquivalentExceptionSpec($c$.track($this().PDiag(DiagID)), 
        $c$.track($this().PDiag(diag.note_previous_declaration)), Old, new SourceLocation(OldLoc), New, new SourceLocation(NewLoc)));
    
    // In Microsoft mode, mismatching exception specifications just cause a warning.
    if ($this().getLangOpts().MicrosoftExt) {
      return false;
    }
    return Result;
  } finally {
    $c$.$destroy();
  }
}


/// CheckEquivalentExceptionSpec - Check if the two types have compatible
/// exception specifications. See C++ [except.spec]p3.
///
/// \return \c false if the exception specifications match, \c true if there is
/// a problem. If \c true is returned, either a diagnostic has already been
/// produced or \c *MissingExceptionSpecification is set to \c true.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckEquivalentExceptionSpec">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExceptionSpec.cpp", line = 397,
 FQN="clang::Sema::CheckEquivalentExceptionSpec", NM="_ZN5clang4Sema28CheckEquivalentExceptionSpecERKNS_17PartialDiagnosticES3_PKNS_17FunctionProtoTypeENS_14SourceLocationES6_S7_PbS8_bb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExceptionSpec.cpp -nm=_ZN5clang4Sema28CheckEquivalentExceptionSpecERKNS_17PartialDiagnosticES3_PKNS_17FunctionProtoTypeENS_14SourceLocationES6_S7_PbS8_bb")
//</editor-fold>
public final boolean CheckEquivalentExceptionSpec(final /*const*/ PartialDiagnostic /*&*/ DiagID, 
                            final /*const*/ PartialDiagnostic /*&*/ NoteID, 
                            /*const*/ FunctionProtoType /*P*/ Old, 
                            SourceLocation OldLoc, 
                            /*const*/ FunctionProtoType /*P*/ New, 
                            SourceLocation NewLoc) {
  return CheckEquivalentExceptionSpec(DiagID, 
                            NoteID, 
                            Old, 
                            OldLoc, 
                            New, 
                            NewLoc, 
                            (bool$ptr/*bool P*/ )null, 
                            (bool$ptr/*bool P*/ )null, 
                            false, 
                            false);
}
public final boolean CheckEquivalentExceptionSpec(final /*const*/ PartialDiagnostic /*&*/ DiagID, 
                            final /*const*/ PartialDiagnostic /*&*/ NoteID, 
                            /*const*/ FunctionProtoType /*P*/ Old, 
                            SourceLocation OldLoc, 
                            /*const*/ FunctionProtoType /*P*/ New, 
                            SourceLocation NewLoc, 
                            bool$ptr/*bool P*/ MissingExceptionSpecification/*= null*/) {
  return CheckEquivalentExceptionSpec(DiagID, 
                            NoteID, 
                            Old, 
                            OldLoc, 
                            New, 
                            NewLoc, 
                            MissingExceptionSpecification, 
                            (bool$ptr/*bool P*/ )null, 
                            false, 
                            false);
}
public final boolean CheckEquivalentExceptionSpec(final /*const*/ PartialDiagnostic /*&*/ DiagID, 
                            final /*const*/ PartialDiagnostic /*&*/ NoteID, 
                            /*const*/ FunctionProtoType /*P*/ Old, 
                            SourceLocation OldLoc, 
                            /*const*/ FunctionProtoType /*P*/ New, 
                            SourceLocation NewLoc, 
                            bool$ptr/*bool P*/ MissingExceptionSpecification/*= null*/, 
                            bool$ptr/*bool P*/ MissingEmptyExceptionSpecification/*= null*/) {
  return CheckEquivalentExceptionSpec(DiagID, 
                            NoteID, 
                            Old, 
                            OldLoc, 
                            New, 
                            NewLoc, 
                            MissingExceptionSpecification, 
                            MissingEmptyExceptionSpecification, 
                            false, 
                            false);
}
public final boolean CheckEquivalentExceptionSpec(final /*const*/ PartialDiagnostic /*&*/ DiagID, 
                            final /*const*/ PartialDiagnostic /*&*/ NoteID, 
                            /*const*/ FunctionProtoType /*P*/ Old, 
                            SourceLocation OldLoc, 
                            /*const*/ FunctionProtoType /*P*/ New, 
                            SourceLocation NewLoc, 
                            bool$ptr/*bool P*/ MissingExceptionSpecification/*= null*/, 
                            bool$ptr/*bool P*/ MissingEmptyExceptionSpecification/*= null*/, 
                            boolean AllowNoexceptAllMatchWithNoSpec/*= false*/) {
  return CheckEquivalentExceptionSpec(DiagID, 
                            NoteID, 
                            Old, 
                            OldLoc, 
                            New, 
                            NewLoc, 
                            MissingExceptionSpecification, 
                            MissingEmptyExceptionSpecification, 
                            AllowNoexceptAllMatchWithNoSpec, 
                            false);
}
public final boolean CheckEquivalentExceptionSpec(final /*const*/ PartialDiagnostic /*&*/ DiagID, 
                            final /*const*/ PartialDiagnostic /*&*/ NoteID, 
                            /*const*/ FunctionProtoType /*P*/ Old, 
                            SourceLocation OldLoc, 
                            /*const*/ FunctionProtoType /*P*/ New, 
                            SourceLocation NewLoc, 
                            bool$ptr/*bool P*/ MissingExceptionSpecification/*= null*/, 
                            bool$ptr/*bool P*/ MissingEmptyExceptionSpecification/*= null*/, 
                            boolean AllowNoexceptAllMatchWithNoSpec/*= false*/, 
                            boolean IsOperatorNew/*= false*/) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    // Just completely ignore this under -fno-exceptions.
    if (!$this().getLangOpts().CXXExceptions) {
      return false;
    }
    if (Native.$bool(MissingExceptionSpecification)) {
      MissingExceptionSpecification.$set(false);
    }
    if (Native.$bool(MissingEmptyExceptionSpecification)) {
      MissingEmptyExceptionSpecification.$set(false);
    }
    
    Old = $this().ResolveExceptionSpec(new SourceLocation(NewLoc), Old);
    if (!(Old != null)) {
      return false;
    }
    New = $this().ResolveExceptionSpec(new SourceLocation(NewLoc), New);
    if (!(New != null)) {
      return false;
    }
    
    // C++0x [except.spec]p3: Two exception-specifications are compatible if:
    //   - both are non-throwing, regardless of their form,
    //   - both have the form noexcept(constant-expression) and the constant-
    //     expressions are equivalent,
    //   - both are dynamic-exception-specifications that have the same set of
    //     adjusted types.
    //
    // C++0x [except.spec]p12: An exception-specification is non-throwing if it is
    //   of the form throw(), noexcept, or noexcept(constant-expression) where the
    //   constant-expression yields true.
    //
    // C++0x [except.spec]p4: If any declaration of a function has an exception-
    //   specifier that is not a noexcept-specification allowing all exceptions,
    //   all declarations [...] of that function shall have a compatible
    //   exception-specification.
    //
    // That last point basically means that noexcept(false) matches no spec.
    // It's considered when AllowNoexceptAllMatchWithNoSpec is true.
    ExceptionSpecificationType OldEST = Old.getExceptionSpecType();
    ExceptionSpecificationType NewEST = New.getExceptionSpecType();
    assert (!isUnresolvedExceptionSpec(OldEST) && !isUnresolvedExceptionSpec(NewEST)) : "Shouldn't see unknown exception specifications here";
    
    // Shortcut the case where both have no spec.
    if (OldEST == ExceptionSpecificationType.EST_None && NewEST == ExceptionSpecificationType.EST_None) {
      return false;
    }
    
    FunctionProtoType.NoexceptResult OldNR = Old.getNoexceptSpec($this().Context);
    FunctionProtoType.NoexceptResult NewNR = New.getNoexceptSpec($this().Context);
    if (OldNR == FunctionProtoType.NoexceptResult.NR_BadNoexcept
       || NewNR == FunctionProtoType.NoexceptResult.NR_BadNoexcept) {
      return false;
    }
    
    // Dependent noexcept specifiers are compatible with each other, but nothing
    // else.
    // One noexcept is compatible with another if the argument is the same
    if (OldNR == NewNR
       && OldNR != FunctionProtoType.NoexceptResult.NR_NoNoexcept
       && NewNR != FunctionProtoType.NoexceptResult.NR_NoNoexcept) {
      return false;
    }
    if (OldNR != NewNR
       && OldNR != FunctionProtoType.NoexceptResult.NR_NoNoexcept
       && NewNR != FunctionProtoType.NoexceptResult.NR_NoNoexcept) {
      $c$.clean($c$.track($this().Diag(new SourceLocation(NewLoc), DiagID)));
      if (NoteID.getDiagID() != 0 && OldLoc.isValid()) {
        $c$.clean($c$.track($this().Diag(new SourceLocation(OldLoc), NoteID)));
      }
      return true;
    }
    
    // The MS extension throw(...) is compatible with itself.
    if (OldEST == ExceptionSpecificationType.EST_MSAny && NewEST == ExceptionSpecificationType.EST_MSAny) {
      return false;
    }
    
    // It's also compatible with no spec.
    if ((OldEST == ExceptionSpecificationType.EST_None && NewEST == ExceptionSpecificationType.EST_MSAny)
       || (OldEST == ExceptionSpecificationType.EST_MSAny && NewEST == ExceptionSpecificationType.EST_None)) {
      return false;
    }
    
    // It's also compatible with noexcept(false).
    if (OldEST == ExceptionSpecificationType.EST_MSAny && NewNR == FunctionProtoType.NoexceptResult.NR_Throw) {
      return false;
    }
    if (NewEST == ExceptionSpecificationType.EST_MSAny && OldNR == FunctionProtoType.NoexceptResult.NR_Throw) {
      return false;
    }
    
    // As described above, noexcept(false) matches no spec only for functions.
    if (AllowNoexceptAllMatchWithNoSpec) {
      if (OldEST == ExceptionSpecificationType.EST_None && NewNR == FunctionProtoType.NoexceptResult.NR_Throw) {
        return false;
      }
      if (NewEST == ExceptionSpecificationType.EST_None && OldNR == FunctionProtoType.NoexceptResult.NR_Throw) {
        return false;
      }
    }
    
    // Any non-throwing specifications are compatible.
    boolean OldNonThrowing = OldNR == FunctionProtoType.NoexceptResult.NR_Nothrow
       || OldEST == ExceptionSpecificationType.EST_DynamicNone;
    boolean NewNonThrowing = NewNR == FunctionProtoType.NoexceptResult.NR_Nothrow
       || NewEST == ExceptionSpecificationType.EST_DynamicNone;
    if (OldNonThrowing && NewNonThrowing) {
      return false;
    }
    
    // As a special compatibility feature, under C++0x we accept no spec and
    // throw(std::bad_alloc) as equivalent for operator new and operator new[].
    // This is because the implicit declaration changed, but old code would break.
    if ($this().getLangOpts().CPlusPlus11 && IsOperatorNew) {
      /*const*/ FunctionProtoType /*P*/ WithExceptions = null;
      if (OldEST == ExceptionSpecificationType.EST_None && NewEST == ExceptionSpecificationType.EST_Dynamic) {
        WithExceptions = New;
      } else if (OldEST == ExceptionSpecificationType.EST_Dynamic && NewEST == ExceptionSpecificationType.EST_None) {
        WithExceptions = Old;
      }
      if ((WithExceptions != null) && WithExceptions.getNumExceptions() == 1) {
        // One has no spec, the other throw(something). If that something is
        // std::bad_alloc, all conditions are met.
        QualType Exception = new QualType(WithExceptions.exception_begin().$star());
        {
          CXXRecordDecl /*P*/ ExRecord = Exception.$arrow().getAsCXXRecordDecl();
          if ((ExRecord != null)) {
            IdentifierInfo /*P*/ Name = ExRecord.getIdentifier();
            if ((Name != null) && $eq_StringRef(Name.getName(), /*STRINGREF_STR*/"bad_alloc")) {
              // It's called bad_alloc, but is it in std?
              if (ExRecord.isInStdNamespace()) {
                return false;
              }
            }
          }
        }
      }
    }
    
    // At this point, the only remaining valid case is two matching dynamic
    // specifications. We return here unless both specifications are dynamic.
    if (OldEST != ExceptionSpecificationType.EST_Dynamic || NewEST != ExceptionSpecificationType.EST_Dynamic) {
      if (Native.$bool(MissingExceptionSpecification) && Old.hasExceptionSpec()
         && !New.hasExceptionSpec()) {
        // The old type has an exception specification of some sort, but
        // the new type does not.
        MissingExceptionSpecification.$set(true);
        if (Native.$bool(MissingEmptyExceptionSpecification) && OldNonThrowing) {
          // The old type has a throw() or noexcept(true) exception specification
          // and the new type has no exception specification, and the caller asked
          // to handle this itself.
          MissingEmptyExceptionSpecification.$set(true);
        }
        
        return true;
      }
      
      $c$.clean($c$.track($this().Diag(new SourceLocation(NewLoc), DiagID)));
      if (NoteID.getDiagID() != 0 && OldLoc.isValid()) {
        $c$.clean($c$.track($this().Diag(new SourceLocation(OldLoc), NoteID)));
      }
      return true;
    }
    assert (OldEST == ExceptionSpecificationType.EST_Dynamic && NewEST == ExceptionSpecificationType.EST_Dynamic) : "Exception compatibility logic error: non-dynamic spec slipped through.";
    
    boolean Success = true;
    // Both have a dynamic exception spec. Collect the first set, then compare
    // to the second.
    SmallPtrSet<CanQual<Type>> OldTypes/*J*/= new SmallPtrSet<CanQual<Type>>(DenseMapInfoCanQual$Type.$Info(), 8);
    SmallPtrSet<CanQual<Type>> NewTypes/*J*/= new SmallPtrSet<CanQual<Type>>(DenseMapInfoCanQual$Type.$Info(), 8);
    for (final /*const*/ QualType /*&*/ I : Old.exceptions())  {
      OldTypes.insert($this().Context.getCanonicalType(new QualType(I)).getUnqualifiedType());
    }
    
    for (final /*const*/ QualType /*&*/ I : New.exceptions()) {
      CanQual<Type> TypePtr = $this().Context.getCanonicalType(new QualType(I)).getUnqualifiedType();
      if ((OldTypes.count(new CanQual<Type>(TypePtr)) != 0)) {
        NewTypes.insert(new CanQual<Type>(TypePtr));
      } else {
        Success = false;
      }
    }
    
    Success = Success && OldTypes.size() == NewTypes.size();
    if (Success) {
      return false;
    }
    $c$.clean($c$.track($this().Diag(new SourceLocation(NewLoc), DiagID)));
    if (NoteID.getDiagID() != 0 && OldLoc.isValid()) {
      $c$.clean($c$.track($this().Diag(new SourceLocation(OldLoc), NoteID)));
    }
    return true;
  } finally {
    $c$.$destroy();
  }
}


/// CheckExceptionSpecSubset - Check whether the second function type's
/// exception specification is a subset (or equivalent) of the first function
/// type. This is used by override and pointer assignment checks.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckExceptionSpecSubset">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExceptionSpec.cpp", line = 589,
 FQN="clang::Sema::CheckExceptionSpecSubset", NM="_ZN5clang4Sema24CheckExceptionSpecSubsetERKNS_17PartialDiagnosticES3_PKNS_17FunctionProtoTypeENS_14SourceLocationES6_S7_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExceptionSpec.cpp -nm=_ZN5clang4Sema24CheckExceptionSpecSubsetERKNS_17PartialDiagnosticES3_PKNS_17FunctionProtoTypeENS_14SourceLocationES6_S7_")
//</editor-fold>
public final boolean CheckExceptionSpecSubset(final /*const*/ PartialDiagnostic /*&*/ DiagID, final /*const*/ PartialDiagnostic /*&*/ NoteID, 
                        /*const*/ FunctionProtoType /*P*/ Superset, SourceLocation SuperLoc, 
                        /*const*/ FunctionProtoType /*P*/ Subset, SourceLocation SubLoc) {
  
  // Just auto-succeed under -fno-exceptions.
  if (!$this().getLangOpts().CXXExceptions) {
    return false;
  }
  
  // FIXME: As usual, we could be more specific in our error messages, but
  // that better waits until we've got types with source locations.
  if (!SubLoc.isValid()) {
    SubLoc.$assign(SuperLoc);
  }
  
  // Resolve the exception specifications, if needed.
  Superset = $this().ResolveExceptionSpec(new SourceLocation(SuperLoc), Superset);
  if (!(Superset != null)) {
    return false;
  }
  Subset = $this().ResolveExceptionSpec(new SourceLocation(SubLoc), Subset);
  if (!(Subset != null)) {
    return false;
  }
  
  ExceptionSpecificationType SuperEST = Superset.getExceptionSpecType();
  
  // If superset contains everything, we're done.
  if (SuperEST == ExceptionSpecificationType.EST_None || SuperEST == ExceptionSpecificationType.EST_MSAny) {
    return $this().CheckParamExceptionSpec(NoteID, Superset, new SourceLocation(SuperLoc), Subset, new SourceLocation(SubLoc));
  }
  
  // If there are dependent noexcept specs, assume everything is fine. Unlike
  // with the equivalency check, this is safe in this case, because we don't
  // want to merge declarations. Checks after instantiation will catch any
  // omissions we make here.
  // We also shortcut checking if a noexcept expression was bad.
  FunctionProtoType.NoexceptResult SuperNR = Superset.getNoexceptSpec($this().Context);
  if (SuperNR == FunctionProtoType.NoexceptResult.NR_BadNoexcept
     || SuperNR == FunctionProtoType.NoexceptResult.NR_Dependent) {
    return false;
  }
  
  // Another case of the superset containing everything.
  if (SuperNR == FunctionProtoType.NoexceptResult.NR_Throw) {
    return $this().CheckParamExceptionSpec(NoteID, Superset, new SourceLocation(SuperLoc), Subset, new SourceLocation(SubLoc));
  }
  
  ExceptionSpecificationType SubEST = Subset.getExceptionSpecType();
  assert (!isUnresolvedExceptionSpec(SuperEST) && !isUnresolvedExceptionSpec(SubEST)) : "Shouldn't see unknown exception specifications here";
  
  // It does not. If the subset contains everything, we've failed.
  if (SubEST == ExceptionSpecificationType.EST_None || SubEST == ExceptionSpecificationType.EST_MSAny) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track($this().Diag(new SourceLocation(SubLoc), DiagID)));
      if (NoteID.getDiagID() != 0) {
        $c$.clean($c$.track($this().Diag(new SourceLocation(SuperLoc), NoteID)));
      }
      return true;
    } finally {
      $c$.$destroy();
    }
  }
  
  FunctionProtoType.NoexceptResult SubNR = Subset.getNoexceptSpec($this().Context);
  if (SubNR == FunctionProtoType.NoexceptResult.NR_BadNoexcept
     || SubNR == FunctionProtoType.NoexceptResult.NR_Dependent) {
    return false;
  }
  
  // Another case of the subset containing everything.
  if (SubNR == FunctionProtoType.NoexceptResult.NR_Throw) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track($this().Diag(new SourceLocation(SubLoc), DiagID)));
      if (NoteID.getDiagID() != 0) {
        $c$.clean($c$.track($this().Diag(new SourceLocation(SuperLoc), NoteID)));
      }
      return true;
    } finally {
      $c$.$destroy();
    }
  }
  
  // If the subset contains nothing, we're done.
  if (SubEST == ExceptionSpecificationType.EST_DynamicNone || SubNR == FunctionProtoType.NoexceptResult.NR_Nothrow) {
    return $this().CheckParamExceptionSpec(NoteID, Superset, new SourceLocation(SuperLoc), Subset, new SourceLocation(SubLoc));
  }
  
  // Otherwise, if the superset contains nothing, we've failed.
  if (SuperEST == ExceptionSpecificationType.EST_DynamicNone || SuperNR == FunctionProtoType.NoexceptResult.NR_Nothrow) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track($this().Diag(new SourceLocation(SubLoc), DiagID)));
      if (NoteID.getDiagID() != 0) {
        $c$.clean($c$.track($this().Diag(new SourceLocation(SuperLoc), NoteID)));
      }
      return true;
    } finally {
      $c$.$destroy();
    }
  }
  assert (SuperEST == ExceptionSpecificationType.EST_Dynamic && SubEST == ExceptionSpecificationType.EST_Dynamic) : "Exception spec subset: non-dynamic case slipped through.";
  
  // Neither contains everything or nothing. Do a proper comparison.
  for (final /*const*/ QualType /*&*/ SubI : Subset.exceptions()) {
    CXXBasePaths Paths = null;
    try {
      // Take one type from the subset.
      QualType CanonicalSubT = $this().Context.getCanonicalType(new QualType(SubI)).$QualType();
      // Unwrap pointers and references so that we can do checks within a class
      // hierarchy. Don't unwrap member pointers; they don't have hierarchy
      // conversions on the pointee.
      boolean SubIsPointer = false;
      {
        /*const*/ ReferenceType /*P*/ RefTy = CanonicalSubT.$arrow().getAs(ReferenceType.class);
        if ((RefTy != null)) {
          CanonicalSubT.$assignMove(RefTy.getPointeeType());
        }
      }
      {
        /*const*/ PointerType /*P*/ PtrTy = CanonicalSubT.$arrow().getAs(PointerType.class);
        if ((PtrTy != null)) {
          CanonicalSubT.$assignMove(PtrTy.getPointeeType());
          SubIsPointer = true;
        }
      }
      boolean SubIsClass = CanonicalSubT.$arrow().isRecordType();
      CanonicalSubT.$assignMove(CanonicalSubT.getLocalUnqualifiedType());
      
      Paths/*J*/= new CXXBasePaths(/*FindAmbiguities=*/ true, /*RecordPaths=*/ true, 
          /*DetectVirtual=*/ false);
      
      boolean Contained = false;
      // Make sure it's in the superset.
      for (final /*const*/ QualType /*&*/ SuperI : Superset.exceptions()) {
        QualType CanonicalSuperT = $this().Context.getCanonicalType(new QualType(SuperI)).$QualType();
        {
          // SubT must be SuperT or derived from it, or pointer or reference to
          // such types.
          /*const*/ ReferenceType /*P*/ RefTy = CanonicalSuperT.$arrow().getAs(ReferenceType.class);
          if ((RefTy != null)) {
            CanonicalSuperT.$assignMove(RefTy.getPointeeType());
          }
        }
        if (SubIsPointer) {
          {
            /*const*/ PointerType /*P*/ PtrTy = CanonicalSuperT.$arrow().getAs(PointerType.class);
            if ((PtrTy != null)) {
              CanonicalSuperT.$assignMove(PtrTy.getPointeeType());
            } else {
              continue;
            }
          }
        }
        CanonicalSuperT.$assignMove(CanonicalSuperT.getLocalUnqualifiedType());
        // If the types are the same, move on to the next type in the subset.
        if ($eq_QualType$C(CanonicalSubT, CanonicalSuperT)) {
          Contained = true;
          break;
        }
        
        // Otherwise we need to check the inheritance.
        if (!SubIsClass || !CanonicalSuperT.$arrow().isRecordType()) {
          continue;
        }
        
        Paths.clear();
        if (!$this().IsDerivedFrom(new SourceLocation(SubLoc), new QualType(CanonicalSubT), new QualType(CanonicalSuperT), Paths)) {
          continue;
        }
        if (Paths.isAmbiguous($this().Context.getCanonicalType(new QualType(CanonicalSuperT)))) {
          continue;
        }
        
        // Do this check from a context without privileges.
        switch ($this().CheckBaseClassAccess(new SourceLocation(), 
            new QualType(CanonicalSuperT), new QualType(CanonicalSubT), 
            Paths.front(), 
            /*Diagnostic*/ 0, 
            /*ForceCheck*/ true, 
            /*ForceUnprivileged*/ true)) {
         case AR_accessible:
          break;
         case AR_inaccessible:
          continue;
         case AR_dependent:
          throw new llvm_unreachable("access check dependent for unprivileged context");
         case AR_delayed:
          throw new llvm_unreachable("access check delayed in non-declaration");
        }
        
        Contained = true;
        break;
      }
      if (!Contained) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag(new SourceLocation(SubLoc), DiagID)));
          if (NoteID.getDiagID() != 0) {
            $c$.clean($c$.track($this().Diag(new SourceLocation(SuperLoc), NoteID)));
          }
          return true;
        } finally {
          $c$.$destroy();
        }
      }
    } finally {
      if (Paths != null) { Paths.$destroy(); }
    }
  }
  // We've run half the gauntlet.
  return $this().CheckParamExceptionSpec(NoteID, Superset, new SourceLocation(SuperLoc), Subset, new SourceLocation(SubLoc));
}


/// CheckParamExceptionSpec - Check if the parameter and return types of the
/// two functions have equivalent exception specs. This is part of the
/// assignment and override compatibility check. We do not check the parameters
/// of parameter function pointers recursively, as no sane programmer would
/// even be able to write such a function type.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckParamExceptionSpec">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExceptionSpec.cpp", line = 778,
 FQN="clang::Sema::CheckParamExceptionSpec", NM="_ZN5clang4Sema23CheckParamExceptionSpecERKNS_17PartialDiagnosticEPKNS_17FunctionProtoTypeENS_14SourceLocationES6_S7_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExceptionSpec.cpp -nm=_ZN5clang4Sema23CheckParamExceptionSpecERKNS_17PartialDiagnosticEPKNS_17FunctionProtoTypeENS_14SourceLocationES6_S7_")
//</editor-fold>
public final boolean CheckParamExceptionSpec(final /*const*/ PartialDiagnostic /*&*/ NoteID, 
                       /*const*/ FunctionProtoType /*P*/ Target, 
                       SourceLocation TargetLoc, 
                       /*const*/ FunctionProtoType /*P*/ Source, 
                       SourceLocation SourceLoc) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    if ($c$.clean(CheckSpecForTypesEquivalent(/*Deref*/$this(), $out_PartialDiagnostic$C_int($c$.track($this().PDiag(diag.err_deep_exception_specs_differ)), 0), $c$.track($this().PDiag()), 
        Target.getReturnType(), new SourceLocation(TargetLoc), Source.getReturnType(), 
        new SourceLocation(SourceLoc)))) {
      return true;
    }
    
    // We shouldn't even be testing this unless the arguments are otherwise
    // compatible.
    assert (Target.getNumParams() == Source.getNumParams()) : "Functions have different argument counts.";
    for (/*uint*/int i = 0, E = Target.getNumParams(); i != E; ++i) {
      if ($c$.clean(CheckSpecForTypesEquivalent(/*Deref*/$this(), $out_PartialDiagnostic$C_int($c$.track($this().PDiag(diag.err_deep_exception_specs_differ)), 1), $c$.track($this().PDiag()), 
          Target.getParamType(i), new SourceLocation(TargetLoc), Source.getParamType(i), 
          new SourceLocation(SourceLoc)))) {
        return true;
      }
    }
    return false;
  } finally {
    $c$.$destroy();
  }
}


/// \brief Determine if we're in a case where we need to (incorrectly) eagerly
/// parse an exception specification to work around a libstdc++ bug.

/// HACK: libstdc++ has a bug where it shadows std::swap with a member
/// swap function then tries to call std::swap unqualified from the exception
/// specification of that function. This function detects whether we're in
/// such a case and turns off delay-parsing of exception specifications.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::isLibstdcxxEagerExceptionSpecHack">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExceptionSpec.cpp", line = 42,
 FQN="clang::Sema::isLibstdcxxEagerExceptionSpecHack", NM="_ZN5clang4Sema33isLibstdcxxEagerExceptionSpecHackERKNS_10DeclaratorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExceptionSpec.cpp -nm=_ZN5clang4Sema33isLibstdcxxEagerExceptionSpecHackERKNS_10DeclaratorE")
//</editor-fold>
public final boolean isLibstdcxxEagerExceptionSpecHack(final /*const*/ Declarator /*&*/ D) {
  CXXRecordDecl /*P*/ RD = dyn_cast_CXXRecordDecl($this().CurContext);
  
  // All the problem cases are member functions named "swap" within class
  // templates declared directly within namespace std.
  if (!(RD != null) || RD.getEnclosingNamespaceContext() != $this().getStdNamespace()
     || !(RD.getIdentifier() != null) || !(RD.getDescribedClassTemplate() != null)
     || !(D.getIdentifier() != null) || !D.getIdentifier().isStr(/*KEEP_STR*/"swap")) {
    return false;
  }
  
  // Only apply this hack within a system header.
  if (!$this().Context.getSourceManager().isInSystemHeader(D.getLocStart())) {
    return false;
  }
  
  return new StringSwitchBool(RD.getIdentifier().getName()).
      Case(/*KEEP_STR*/"array", true).
      Case(/*KEEP_STR*/"pair", true).
      Case(/*KEEP_STR*/"priority_queue", true).
      Case(/*KEEP_STR*/"stack", true).
      Case(/*KEEP_STR*/"queue", true).
      Default(false);
}


/// CheckOverridingFunctionExceptionSpec - Checks whether the exception
/// spec is a subset of base spec.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckOverridingFunctionExceptionSpec">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExceptionSpec.cpp", line = 833,
 FQN="clang::Sema::CheckOverridingFunctionExceptionSpec", NM="_ZN5clang4Sema36CheckOverridingFunctionExceptionSpecEPKNS_13CXXMethodDeclES3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExceptionSpec.cpp -nm=_ZN5clang4Sema36CheckOverridingFunctionExceptionSpecEPKNS_13CXXMethodDeclES3_")
//</editor-fold>
public final boolean CheckOverridingFunctionExceptionSpec(/*const*/ CXXMethodDecl /*P*/ New, 
                                    /*const*/ CXXMethodDecl /*P*/ Old) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    // If the new exception specification hasn't been parsed yet, skip the check.
    // We'll get called again once it's been parsed.
    if (New.getType().$arrow().castAs(FunctionProtoType.class).getExceptionSpecType()
       == ExceptionSpecificationType.EST_Unparsed) {
      return false;
    }
    if ($this().getLangOpts().CPlusPlus11 && isa_CXXDestructorDecl(New)) {
      // Don't check uninstantiated template destructors at all. We can only
      // synthesize correct specs after the template is instantiated.
      if (New.getParent$Const().isDependentType()) {
        return false;
      }
      if (New.getParent$Const().isBeingDefined()) {
        // The destructor might be updated once the definition is finished. So
        // remember it and check later.
        $this().DelayedExceptionSpecChecks.push_back(std.make_pair_Ptr_Ptr(New, Old));
        return false;
      }
    }
    // If the old exception specification hasn't been parsed yet, remember that
    // we need to perform this check when we get to the end of the outermost
    // lexically-surrounding class.
    if (Old.getType().$arrow().castAs(FunctionProtoType.class).getExceptionSpecType()
       == ExceptionSpecificationType.EST_Unparsed) {
      $this().DelayedExceptionSpecChecks.push_back(std.make_pair_Ptr_Ptr(New, Old));
      return false;
    }
    /*uint*/int DiagID = diag.err_override_exception_spec;
    if ($this().getLangOpts().MicrosoftExt) {
      DiagID = diag.ext_override_exception_spec;
    }
    return $c$.clean($this().CheckExceptionSpecSubset($c$.track($this().PDiag(DiagID)), 
        $c$.track($this().PDiag(diag.note_overridden_virtual_function)), 
        Old.getType().$arrow().getAs(FunctionProtoType.class), 
        Old.getLocation(), 
        New.getType().$arrow().getAs(FunctionProtoType.class), 
        New.getLocation()));
  } finally {
    $c$.$destroy();
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckExceptionSpecCompatibility">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExceptionSpec.cpp", line = 803,
 FQN="clang::Sema::CheckExceptionSpecCompatibility", NM="_ZN5clang4Sema31CheckExceptionSpecCompatibilityEPNS_4ExprENS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExceptionSpec.cpp -nm=_ZN5clang4Sema31CheckExceptionSpecCompatibilityEPNS_4ExprENS_8QualTypeE")
//</editor-fold>
public final boolean CheckExceptionSpecCompatibility(Expr /*P*/ From, QualType ToType) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    // First we check for applicability.
    // Target type must be a function, function pointer or function reference.
    /*const*/ FunctionProtoType /*P*/ ToFunc = GetUnderlyingFunction(new QualType(ToType));
    if (!(ToFunc != null) || ToFunc.hasDependentExceptionSpec()) {
      return false;
    }
    
    // SourceType must be a function or function pointer.
    /*const*/ FunctionProtoType /*P*/ FromFunc = GetUnderlyingFunction(From.getType());
    if (!(FromFunc != null) || FromFunc.hasDependentExceptionSpec()) {
      return false;
    }
    
    // Now we've got the correct types on both sides, check their compatibility.
    // This means that the source of the conversion can only throw a subset of
    // the exceptions of the target, and any exception specs on arguments or
    // return types must be equivalent.
    //
    // FIXME: If there is a nested dependent exception specification, we should
    // not be checking it here. This is fine:
    //   template<typename T> void f() {
    //     void (*p)(void (*) throw(T));
    //     void (*q)(void (*) throw(int)) = p;
    //   }
    // ... because it might be instantiated with T=int.
    return $c$.clean($this().CheckExceptionSpecSubset($c$.track($this().PDiag(diag.err_incompatible_exception_specs)), 
        $c$.track($this().PDiag()), ToFunc, 
        From.getSourceRange().getBegin(), 
        FromFunc, new SourceLocation()));
  } finally {
    $c$.$destroy();
  }
}

} // END OF class Sema_SemaExceptionSpec
