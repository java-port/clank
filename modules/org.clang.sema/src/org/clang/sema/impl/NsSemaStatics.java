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
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.sema.*;
import static org.clang.ast.java.AstAttributesRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type NsSemaStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=_ZN5clang4sema28instantiateTemplateAttributeEPKNS_4AttrERNS_10ASTContextERNS_4SemaERKNS_30MultiLevelTemplateArgumentListE; -static-type=NsSemaStatics -package=org.clang.sema.impl")
//</editor-fold>
public final class NsSemaStatics {

//<editor-fold defaultstate="collapsed" desc="clang::sema::instantiateTemplateAttribute">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/Sema/AttrTemplateInstantiate.inc", line = 12,
 FQN="clang::sema::instantiateTemplateAttribute", NM="_ZN5clang4sema28instantiateTemplateAttributeEPKNS_4AttrERNS_10ASTContextERNS_4SemaERKNS_30MultiLevelTemplateArgumentListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateInstantiateDecl.cpp -nm=_ZN5clang4sema28instantiateTemplateAttributeEPKNS_4AttrERNS_10ASTContextERNS_4SemaERKNS_30MultiLevelTemplateArgumentListE")
//</editor-fold>
public static Attr /*P*/ instantiateTemplateAttribute(/*const*/ Attr /*P*/ At, final ASTContext /*&*/ C, final Sema /*&*/ S, 
                            final /*const*/ MultiLevelTemplateArgumentList /*&*/ TemplateArgs) {
  switch (At.getKind()) {
   case AMDGPUNumSGPR:
    {
      /*const*/ AMDGPUNumSGPRAttr /*P*/ A = cast_AMDGPUNumSGPRAttr(At);
      return A.clone(C);
    }
   case AMDGPUNumVGPR:
    {
      /*const*/ AMDGPUNumVGPRAttr /*P*/ A = cast_AMDGPUNumVGPRAttr(At);
      return A.clone(C);
    }
   case ARMInterrupt:
    {
      /*const*/ ARMInterruptAttr /*P*/ A = cast_ARMInterruptAttr(At);
      return A.clone(C);
    }
   case AbiTag:
    {
      /*const*/ AbiTagAttr /*P*/ A = cast_AbiTagAttr(At);
      return A.clone(C);
    }
   case AcquireCapability:
    {
      /*const*/ AcquireCapabilityAttr /*P*/ A = cast_AcquireCapabilityAttr(At);
      Expr/*P*/ tempInstArgs[] = (/*FIXME:NEW_EXPR*//*new (C, 16)*/ new Expr /*P*/ [A.args_size()]);
      {
        EnterExpressionEvaluationContext Unevaluated = null;
        try {
          Unevaluated/*J*/= new EnterExpressionEvaluationContext(S, Sema.ExpressionEvaluationContext.Unevaluated);
          type$ptr<Expr/*P*/> TI = create_type$ptr(tempInstArgs);
          type$ptr<Expr/*P*/> I = $tryClone(A.args_begin());
          type$ptr<Expr/*P*/> E = $tryClone(A.args_end());
          for (; $noteq_ptr(I, E); I.$preInc() , TI.$preInc()) {
            ActionResultTTrue<Expr /*P*/ > Result = S.SubstExpr(I.$star(), TemplateArgs);
            TI.$set(Result.getAs(Expr.class));
          }
        } finally {
          if (Unevaluated != null) { Unevaluated.$destroy(); }
        }
      }
      return /*FIXME:NEW_EXPR*//*new (C)*/ new AcquireCapabilityAttr(new SourceRange(A.getLocation()), C, create_type$ptr(tempInstArgs), A.args_size(), A.getSpellingListIndex());
    }
   case AcquiredAfter:
    {
      /*const*/ AcquiredAfterAttr /*P*/ A = cast_AcquiredAfterAttr(At);
      Expr/*P*/ tempInstArgs[] = (/*FIXME:NEW_EXPR*//*new (C, 16)*/ new Expr /*P*/ [A.args_size()]);
      {
        EnterExpressionEvaluationContext Unevaluated = null;
        try {
          Unevaluated/*J*/= new EnterExpressionEvaluationContext(S, Sema.ExpressionEvaluationContext.Unevaluated);
          type$ptr<Expr/*P*/> TI = create_type$ptr(tempInstArgs);
          type$ptr<Expr/*P*/> I = $tryClone(A.args_begin());
          type$ptr<Expr/*P*/> E = $tryClone(A.args_end());
          for (; $noteq_ptr(I, E); I.$preInc() , TI.$preInc()) {
            ActionResultTTrue<Expr /*P*/ > Result = S.SubstExpr(I.$star(), TemplateArgs);
            TI.$set(Result.getAs(Expr.class));
          }
        } finally {
          if (Unevaluated != null) { Unevaluated.$destroy(); }
        }
      }
      return /*FIXME:NEW_EXPR*//*new (C)*/ new AcquiredAfterAttr(new SourceRange(A.getLocation()), C, create_type$ptr(tempInstArgs), A.args_size(), A.getSpellingListIndex());
    }
   case AcquiredBefore:
    {
      /*const*/ AcquiredBeforeAttr /*P*/ A = cast_AcquiredBeforeAttr(At);
      Expr/*P*/ tempInstArgs[] = (/*FIXME:NEW_EXPR*//*new (C, 16)*/ new Expr /*P*/ [A.args_size()]);
      {
        EnterExpressionEvaluationContext Unevaluated = null;
        try {
          Unevaluated/*J*/= new EnterExpressionEvaluationContext(S, Sema.ExpressionEvaluationContext.Unevaluated);
          type$ptr<Expr/*P*/> TI = create_type$ptr(tempInstArgs);
          type$ptr<Expr/*P*/> I = $tryClone(A.args_begin());
          type$ptr<Expr/*P*/> E = $tryClone(A.args_end());
          for (; $noteq_ptr(I, E); I.$preInc() , TI.$preInc()) {
            ActionResultTTrue<Expr /*P*/ > Result = S.SubstExpr(I.$star(), TemplateArgs);
            TI.$set(Result.getAs(Expr.class));
          }
        } finally {
          if (Unevaluated != null) { Unevaluated.$destroy(); }
        }
      }
      return /*FIXME:NEW_EXPR*//*new (C)*/ new AcquiredBeforeAttr(new SourceRange(A.getLocation()), C, create_type$ptr(tempInstArgs), A.args_size(), A.getSpellingListIndex());
    }
   case Alias:
    {
      /*const*/ AliasAttr /*P*/ A = cast_AliasAttr(At);
      return A.clone(C);
    }
   case AlignMac68k:
    {
      /*const*/ AlignMac68kAttr /*P*/ A = cast_AlignMac68kAttr(At);
      return A.clone(C);
    }
   case AlignValue:
    {
      /*const*/ AlignValueAttr /*P*/ A = cast_AlignValueAttr(At);
      return A.clone(C);
    }
   case Aligned:
    {
      /*const*/ AlignedAttr /*P*/ A = cast_AlignedAttr(At);
      return A.clone(C);
    }
   case AlwaysInline:
    {
      /*const*/ AlwaysInlineAttr /*P*/ A = cast_AlwaysInlineAttr(At);
      return A.clone(C);
    }
   case AnalyzerNoReturn:
    {
      /*const*/ AnalyzerNoReturnAttr /*P*/ A = cast_AnalyzerNoReturnAttr(At);
      return A.clone(C);
    }
   case Annotate:
    {
      /*const*/ AnnotateAttr /*P*/ A = cast_AnnotateAttr(At);
      return A.clone(C);
    }
   case AnyX86Interrupt:
    {
      /*const*/ AnyX86InterruptAttr /*P*/ A = cast_AnyX86InterruptAttr(At);
      return A.clone(C);
    }
   case ArcWeakrefUnavailable:
    {
      /*const*/ ArcWeakrefUnavailableAttr /*P*/ A = cast_ArcWeakrefUnavailableAttr(At);
      return A.clone(C);
    }
   case ArgumentWithTypeTag:
    {
      /*const*/ ArgumentWithTypeTagAttr /*P*/ A = cast_ArgumentWithTypeTagAttr(At);
      return A.clone(C);
    }
   case AsmLabel:
    {
      /*const*/ AsmLabelAttr /*P*/ A = cast_AsmLabelAttr(At);
      return A.clone(C);
    }
   case AssertCapability:
    {
      /*const*/ AssertCapabilityAttr /*P*/ A = cast_AssertCapabilityAttr(At);
      Expr /*P*/ tempInstExpr;
      {
        EnterExpressionEvaluationContext Unevaluated = null;
        try {
          Unevaluated/*J*/= new EnterExpressionEvaluationContext(S, Sema.ExpressionEvaluationContext.Unevaluated);
          ActionResultTTrue<Expr /*P*/ > Result = S.SubstExpr(A.getExpr(), TemplateArgs);
          tempInstExpr = Result.getAs(Expr.class);
        } finally {
          if (Unevaluated != null) { Unevaluated.$destroy(); }
        }
      }
      return /*FIXME:NEW_EXPR*//*new (C)*/ new AssertCapabilityAttr(new SourceRange(A.getLocation()), C, tempInstExpr, A.getSpellingListIndex());
    }
   case AssertExclusiveLock:
    {
      /*const*/ AssertExclusiveLockAttr /*P*/ A = cast_AssertExclusiveLockAttr(At);
      Expr/*P*/ tempInstArgs[] = (/*FIXME:NEW_EXPR*//*new (C, 16)*/ new Expr /*P*/ [A.args_size()]);
      {
        EnterExpressionEvaluationContext Unevaluated = null;
        try {
          Unevaluated/*J*/= new EnterExpressionEvaluationContext(S, Sema.ExpressionEvaluationContext.Unevaluated);
          type$ptr<Expr/*P*/> TI = create_type$ptr(tempInstArgs);
          type$ptr<Expr/*P*/> I = $tryClone(A.args_begin());
          type$ptr<Expr/*P*/> E = $tryClone(A.args_end());
          for (; $noteq_ptr(I, E); I.$preInc() , TI.$preInc()) {
            ActionResultTTrue<Expr /*P*/ > Result = S.SubstExpr(I.$star(), TemplateArgs);
            TI.$set(Result.getAs(Expr.class));
          }
        } finally {
          if (Unevaluated != null) { Unevaluated.$destroy(); }
        }
      }
      return /*FIXME:NEW_EXPR*//*new (C)*/ new AssertExclusiveLockAttr(new SourceRange(A.getLocation()), C, create_type$ptr(tempInstArgs), A.args_size(), A.getSpellingListIndex());
    }
   case AssertSharedLock:
    {
      /*const*/ AssertSharedLockAttr /*P*/ A = cast_AssertSharedLockAttr(At);
      Expr/*P*/ tempInstArgs[] = (/*FIXME:NEW_EXPR*//*new (C, 16)*/ new Expr /*P*/ [A.args_size()]);
      {
        EnterExpressionEvaluationContext Unevaluated = null;
        try {
          Unevaluated/*J*/= new EnterExpressionEvaluationContext(S, Sema.ExpressionEvaluationContext.Unevaluated);
          type$ptr<Expr/*P*/> TI = create_type$ptr(tempInstArgs);
          type$ptr<Expr/*P*/> I = $tryClone(A.args_begin());
          type$ptr<Expr/*P*/> E = $tryClone(A.args_end());
          for (; $noteq_ptr(I, E); I.$preInc() , TI.$preInc()) {
            ActionResultTTrue<Expr /*P*/ > Result = S.SubstExpr(I.$star(), TemplateArgs);
            TI.$set(Result.getAs(Expr.class));
          }
        } finally {
          if (Unevaluated != null) { Unevaluated.$destroy(); }
        }
      }
      return /*FIXME:NEW_EXPR*//*new (C)*/ new AssertSharedLockAttr(new SourceRange(A.getLocation()), C, create_type$ptr(tempInstArgs), A.args_size(), A.getSpellingListIndex());
    }
   case AssumeAligned:
    {
      /*const*/ AssumeAlignedAttr /*P*/ A = cast_AssumeAlignedAttr(At);
      return A.clone(C);
    }
   case Availability:
    {
      /*const*/ AvailabilityAttr /*P*/ A = cast_AvailabilityAttr(At);
      return A.clone(C);
    }
   case Blocks:
    {
      /*const*/ BlocksAttr /*P*/ A = cast_BlocksAttr(At);
      return A.clone(C);
    }
   case C11NoReturn:
    {
      /*const*/ C11NoReturnAttr /*P*/ A = cast_C11NoReturnAttr(At);
      return A.clone(C);
    }
   case CDecl:
    {
      /*const*/ CDeclAttr /*P*/ A = cast_CDeclAttr(At);
      return A.clone(C);
    }
   case CFAuditedTransfer:
    {
      /*const*/ CFAuditedTransferAttr /*P*/ A = cast_CFAuditedTransferAttr(At);
      return A.clone(C);
    }
   case CFConsumed:
    {
      /*const*/ CFConsumedAttr /*P*/ A = cast_CFConsumedAttr(At);
      return A.clone(C);
    }
   case CFReturnsNotRetained:
    {
      /*const*/ CFReturnsNotRetainedAttr /*P*/ A = cast_CFReturnsNotRetainedAttr(At);
      return A.clone(C);
    }
   case CFReturnsRetained:
    {
      /*const*/ CFReturnsRetainedAttr /*P*/ A = cast_CFReturnsRetainedAttr(At);
      return A.clone(C);
    }
   case CFUnknownTransfer:
    {
      /*const*/ CFUnknownTransferAttr /*P*/ A = cast_CFUnknownTransferAttr(At);
      return A.clone(C);
    }
   case CUDAConstant:
    {
      /*const*/ CUDAConstantAttr /*P*/ A = cast_CUDAConstantAttr(At);
      return A.clone(C);
    }
   case CUDADevice:
    {
      /*const*/ CUDADeviceAttr /*P*/ A = cast_CUDADeviceAttr(At);
      return A.clone(C);
    }
   case CUDAGlobal:
    {
      /*const*/ CUDAGlobalAttr /*P*/ A = cast_CUDAGlobalAttr(At);
      return A.clone(C);
    }
   case CUDAHost:
    {
      /*const*/ CUDAHostAttr /*P*/ A = cast_CUDAHostAttr(At);
      return A.clone(C);
    }
   case CUDAInvalidTarget:
    {
      /*const*/ CUDAInvalidTargetAttr /*P*/ A = cast_CUDAInvalidTargetAttr(At);
      return A.clone(C);
    }
   case CUDALaunchBounds:
    {
      /*const*/ CUDALaunchBoundsAttr /*P*/ A = cast_CUDALaunchBoundsAttr(At);
      return A.clone(C);
    }
   case CUDAShared:
    {
      /*const*/ CUDASharedAttr /*P*/ A = cast_CUDASharedAttr(At);
      return A.clone(C);
    }
   case CXX11NoReturn:
    {
      /*const*/ CXX11NoReturnAttr /*P*/ A = cast_CXX11NoReturnAttr(At);
      return A.clone(C);
    }
   case CallableWhen:
    {
      /*const*/ CallableWhenAttr /*P*/ A = cast_CallableWhenAttr(At);
      return A.clone(C);
    }
   case Capability:
    {
      /*const*/ CapabilityAttr /*P*/ A = cast_CapabilityAttr(At);
      return A.clone(C);
    }
   case CapturedRecord:
    {
      /*const*/ CapturedRecordAttr /*P*/ A = cast_CapturedRecordAttr(At);
      return A.clone(C);
    }
   case CarriesDependency:
    {
      /*const*/ CarriesDependencyAttr /*P*/ A = cast_CarriesDependencyAttr(At);
      return A.clone(C);
    }
   case Cleanup:
    {
      /*const*/ CleanupAttr /*P*/ A = cast_CleanupAttr(At);
      return A.clone(C);
    }
   case Cold:
    {
      /*const*/ ColdAttr /*P*/ A = cast_ColdAttr(At);
      return A.clone(C);
    }
   case Common:
    {
      /*const*/ CommonAttr /*P*/ A = cast_CommonAttr(At);
      return A.clone(C);
    }
   case Const:
    {
      /*const*/ ConstAttr /*P*/ A = cast_ConstAttr(At);
      return A.clone(C);
    }
   case Constructor:
    {
      /*const*/ ConstructorAttr /*P*/ A = cast_ConstructorAttr(At);
      return A.clone(C);
    }
   case Consumable:
    {
      /*const*/ ConsumableAttr /*P*/ A = cast_ConsumableAttr(At);
      return A.clone(C);
    }
   case ConsumableAutoCast:
    {
      /*const*/ ConsumableAutoCastAttr /*P*/ A = cast_ConsumableAutoCastAttr(At);
      return A.clone(C);
    }
   case ConsumableSetOnRead:
    {
      /*const*/ ConsumableSetOnReadAttr /*P*/ A = cast_ConsumableSetOnReadAttr(At);
      return A.clone(C);
    }
   case DLLExport:
    {
      /*const*/ DLLExportAttr /*P*/ A = cast_DLLExportAttr(At);
      return A.clone(C);
    }
   case DLLImport:
    {
      /*const*/ DLLImportAttr /*P*/ A = cast_DLLImportAttr(At);
      return A.clone(C);
    }
   case Deprecated:
    {
      /*const*/ DeprecatedAttr /*P*/ A = cast_DeprecatedAttr(At);
      return A.clone(C);
    }
   case Destructor:
    {
      /*const*/ DestructorAttr /*P*/ A = cast_DestructorAttr(At);
      return A.clone(C);
    }
   case DisableTailCalls:
    {
      /*const*/ DisableTailCallsAttr /*P*/ A = cast_DisableTailCallsAttr(At);
      return A.clone(C);
    }
   case EmptyBases:
    {
      /*const*/ EmptyBasesAttr /*P*/ A = cast_EmptyBasesAttr(At);
      return A.clone(C);
    }
   case EnableIf:
    {
      /*const*/ EnableIfAttr /*P*/ A = cast_EnableIfAttr(At);
      Expr /*P*/ tempInstCond;
      {
        EnterExpressionEvaluationContext Unevaluated = null;
        try {
          Unevaluated/*J*/= new EnterExpressionEvaluationContext(S, Sema.ExpressionEvaluationContext.Unevaluated);
          ActionResultTTrue<Expr /*P*/ > Result = S.SubstExpr(A.getCond(), TemplateArgs);
          tempInstCond = Result.getAs(Expr.class);
        } finally {
          if (Unevaluated != null) { Unevaluated.$destroy(); }
        }
      }
      return /*FIXME:NEW_EXPR*//*new (C)*/ new EnableIfAttr(new SourceRange(A.getLocation()), C, tempInstCond, A.getMessage(), A.getSpellingListIndex());
    }
   case ExclusiveTrylockFunction:
    {
      /*const*/ ExclusiveTrylockFunctionAttr /*P*/ A = cast_ExclusiveTrylockFunctionAttr(At);
      Expr /*P*/ tempInstSuccessValue;
      {
        EnterExpressionEvaluationContext Unevaluated = null;
        try {
          Unevaluated/*J*/= new EnterExpressionEvaluationContext(S, Sema.ExpressionEvaluationContext.Unevaluated);
          ActionResultTTrue<Expr /*P*/ > Result = S.SubstExpr(A.getSuccessValue(), TemplateArgs);
          tempInstSuccessValue = Result.getAs(Expr.class);
        } finally {
          if (Unevaluated != null) { Unevaluated.$destroy(); }
        }
      }
      Expr/*P*/ tempInstArgs[] = (/*FIXME:NEW_EXPR*//*new (C, 16)*/ new Expr /*P*/ [A.args_size()]);
      {
        EnterExpressionEvaluationContext Unevaluated = null;
        try {
          Unevaluated/*J*/= new EnterExpressionEvaluationContext(S, Sema.ExpressionEvaluationContext.Unevaluated);
          type$ptr<Expr/*P*/> TI = create_type$ptr(tempInstArgs);
          type$ptr<Expr/*P*/> I = $tryClone(A.args_begin());
          type$ptr<Expr/*P*/> E = $tryClone(A.args_end());
          for (; $noteq_ptr(I, E); I.$preInc() , TI.$preInc()) {
            ActionResultTTrue<Expr /*P*/ > Result = S.SubstExpr(I.$star(), TemplateArgs);
            TI.$set(Result.getAs(Expr.class));
          }
        } finally {
          if (Unevaluated != null) { Unevaluated.$destroy(); }
        }
      }
      return /*FIXME:NEW_EXPR*//*new (C)*/ new ExclusiveTrylockFunctionAttr(new SourceRange(A.getLocation()), C, tempInstSuccessValue, create_type$ptr(tempInstArgs), A.args_size(), A.getSpellingListIndex());
    }
   case FallThrough:
    {
      /*const*/ FallThroughAttr /*P*/ A = cast_FallThroughAttr(At);
      return A.clone(C);
    }
   case FastCall:
    {
      /*const*/ FastCallAttr /*P*/ A = cast_FastCallAttr(At);
      return A.clone(C);
    }
   case Final:
    {
      /*const*/ FinalAttr /*P*/ A = cast_FinalAttr(At);
      return A.clone(C);
    }
   case FlagEnum:
    {
      /*const*/ FlagEnumAttr /*P*/ A = cast_FlagEnumAttr(At);
      return A.clone(C);
    }
   case Flatten:
    {
      /*const*/ FlattenAttr /*P*/ A = cast_FlattenAttr(At);
      return A.clone(C);
    }
   case Format:
    {
      /*const*/ FormatAttr /*P*/ A = cast_FormatAttr(At);
      return A.clone(C);
    }
   case FormatArg:
    {
      /*const*/ FormatArgAttr /*P*/ A = cast_FormatArgAttr(At);
      return A.clone(C);
    }
   case GNUInline:
    {
      /*const*/ GNUInlineAttr /*P*/ A = cast_GNUInlineAttr(At);
      return A.clone(C);
    }
   case GuardedBy:
    {
      /*const*/ GuardedByAttr /*P*/ A = cast_GuardedByAttr(At);
      Expr /*P*/ tempInstArg;
      {
        EnterExpressionEvaluationContext Unevaluated = null;
        try {
          Unevaluated/*J*/= new EnterExpressionEvaluationContext(S, Sema.ExpressionEvaluationContext.Unevaluated);
          ActionResultTTrue<Expr /*P*/ > Result = S.SubstExpr(A.getArg(), TemplateArgs);
          tempInstArg = Result.getAs(Expr.class);
        } finally {
          if (Unevaluated != null) { Unevaluated.$destroy(); }
        }
      }
      return /*FIXME:NEW_EXPR*//*new (C)*/ new GuardedByAttr(new SourceRange(A.getLocation()), C, tempInstArg, A.getSpellingListIndex());
    }
   case GuardedVar:
    {
      /*const*/ GuardedVarAttr /*P*/ A = cast_GuardedVarAttr(At);
      return A.clone(C);
    }
   case Hot:
    {
      /*const*/ HotAttr /*P*/ A = cast_HotAttr(At);
      return A.clone(C);
    }
   case IBAction:
    {
      /*const*/ IBActionAttr /*P*/ A = cast_IBActionAttr(At);
      return A.clone(C);
    }
   case IBOutlet:
    {
      /*const*/ IBOutletAttr /*P*/ A = cast_IBOutletAttr(At);
      return A.clone(C);
    }
   case IBOutletCollection:
    {
      /*const*/ IBOutletCollectionAttr /*P*/ A = cast_IBOutletCollectionAttr(At);
      return A.clone(C);
    }
   case IFunc:
    {
      /*const*/ IFuncAttr /*P*/ A = cast_IFuncAttr(At);
      return A.clone(C);
    }
   case InitPriority:
    {
      /*const*/ InitPriorityAttr /*P*/ A = cast_InitPriorityAttr(At);
      return A.clone(C);
    }
   case InitSeg:
    {
      /*const*/ InitSegAttr /*P*/ A = cast_InitSegAttr(At);
      return A.clone(C);
    }
   case IntelOclBicc:
    {
      /*const*/ IntelOclBiccAttr /*P*/ A = cast_IntelOclBiccAttr(At);
      return A.clone(C);
    }
   case InternalLinkage:
    {
      /*const*/ InternalLinkageAttr /*P*/ A = cast_InternalLinkageAttr(At);
      return A.clone(C);
    }
   case LTOVisibilityPublic:
    {
      /*const*/ LTOVisibilityPublicAttr /*P*/ A = cast_LTOVisibilityPublicAttr(At);
      return A.clone(C);
    }
   case LayoutVersion:
    {
      /*const*/ LayoutVersionAttr /*P*/ A = cast_LayoutVersionAttr(At);
      return A.clone(C);
    }
   case LockReturned:
    {
      /*const*/ LockReturnedAttr /*P*/ A = cast_LockReturnedAttr(At);
      Expr /*P*/ tempInstArg;
      {
        EnterExpressionEvaluationContext Unevaluated = null;
        try {
          Unevaluated/*J*/= new EnterExpressionEvaluationContext(S, Sema.ExpressionEvaluationContext.Unevaluated);
          ActionResultTTrue<Expr /*P*/ > Result = S.SubstExpr(A.getArg(), TemplateArgs);
          tempInstArg = Result.getAs(Expr.class);
        } finally {
          if (Unevaluated != null) { Unevaluated.$destroy(); }
        }
      }
      return /*FIXME:NEW_EXPR*//*new (C)*/ new LockReturnedAttr(new SourceRange(A.getLocation()), C, tempInstArg, A.getSpellingListIndex());
    }
   case LocksExcluded:
    {
      /*const*/ LocksExcludedAttr /*P*/ A = cast_LocksExcludedAttr(At);
      Expr/*P*/ tempInstArgs[] = (/*FIXME:NEW_EXPR*//*new (C, 16)*/ new Expr /*P*/ [A.args_size()]);
      {
        EnterExpressionEvaluationContext Unevaluated = null;
        try {
          Unevaluated/*J*/= new EnterExpressionEvaluationContext(S, Sema.ExpressionEvaluationContext.Unevaluated);
          type$ptr<Expr/*P*/> TI = create_type$ptr(tempInstArgs);
          type$ptr<Expr/*P*/> I = $tryClone(A.args_begin());
          type$ptr<Expr/*P*/> E = $tryClone(A.args_end());
          for (; $noteq_ptr(I, E); I.$preInc() , TI.$preInc()) {
            ActionResultTTrue<Expr /*P*/ > Result = S.SubstExpr(I.$star(), TemplateArgs);
            TI.$set(Result.getAs(Expr.class));
          }
        } finally {
          if (Unevaluated != null) { Unevaluated.$destroy(); }
        }
      }
      return /*FIXME:NEW_EXPR*//*new (C)*/ new LocksExcludedAttr(new SourceRange(A.getLocation()), C, create_type$ptr(tempInstArgs), A.args_size(), A.getSpellingListIndex());
    }
   case LoopHint:
    {
      /*const*/ LoopHintAttr /*P*/ A = cast_LoopHintAttr(At);
      return A.clone(C);
    }
   case MSABI:
    {
      /*const*/ MSABIAttr /*P*/ A = cast_MSABIAttr(At);
      return A.clone(C);
    }
   case MSInheritance:
    {
      /*const*/ MSInheritanceAttr /*P*/ A = cast_MSInheritanceAttr(At);
      return A.clone(C);
    }
   case MSNoVTable:
    {
      /*const*/ MSNoVTableAttr /*P*/ A = cast_MSNoVTableAttr(At);
      return A.clone(C);
    }
   case MSP430Interrupt:
    {
      /*const*/ MSP430InterruptAttr /*P*/ A = cast_MSP430InterruptAttr(At);
      return A.clone(C);
    }
   case MSStruct:
    {
      /*const*/ MSStructAttr /*P*/ A = cast_MSStructAttr(At);
      return A.clone(C);
    }
   case MSVtorDisp:
    {
      /*const*/ MSVtorDispAttr /*P*/ A = cast_MSVtorDispAttr(At);
      return A.clone(C);
    }
   case MaxFieldAlignment:
    {
      /*const*/ MaxFieldAlignmentAttr /*P*/ A = cast_MaxFieldAlignmentAttr(At);
      return A.clone(C);
    }
   case MayAlias:
    {
      /*const*/ MayAliasAttr /*P*/ A = cast_MayAliasAttr(At);
      return A.clone(C);
    }
   case MinSize:
    {
      /*const*/ MinSizeAttr /*P*/ A = cast_MinSizeAttr(At);
      return A.clone(C);
    }
   case Mips16:
    {
      /*const*/ Mips16Attr /*P*/ A = cast_Mips16Attr(At);
      return A.clone(C);
    }
   case MipsInterrupt:
    {
      /*const*/ MipsInterruptAttr /*P*/ A = cast_MipsInterruptAttr(At);
      return A.clone(C);
    }
   case Mode:
    {
      /*const*/ ModeAttr /*P*/ A = cast_ModeAttr(At);
      return A.clone(C);
    }
   case NSConsumed:
    {
      /*const*/ NSConsumedAttr /*P*/ A = cast_NSConsumedAttr(At);
      return A.clone(C);
    }
   case NSConsumesSelf:
    {
      /*const*/ NSConsumesSelfAttr /*P*/ A = cast_NSConsumesSelfAttr(At);
      return A.clone(C);
    }
   case NSReturnsAutoreleased:
    {
      /*const*/ NSReturnsAutoreleasedAttr /*P*/ A = cast_NSReturnsAutoreleasedAttr(At);
      return A.clone(C);
    }
   case NSReturnsNotRetained:
    {
      /*const*/ NSReturnsNotRetainedAttr /*P*/ A = cast_NSReturnsNotRetainedAttr(At);
      return A.clone(C);
    }
   case NSReturnsRetained:
    {
      /*const*/ NSReturnsRetainedAttr /*P*/ A = cast_NSReturnsRetainedAttr(At);
      return A.clone(C);
    }
   case Naked:
    {
      /*const*/ NakedAttr /*P*/ A = cast_NakedAttr(At);
      return A.clone(C);
    }
   case NoAlias:
    {
      /*const*/ NoAliasAttr /*P*/ A = cast_NoAliasAttr(At);
      return A.clone(C);
    }
   case NoCommon:
    {
      /*const*/ NoCommonAttr /*P*/ A = cast_NoCommonAttr(At);
      return A.clone(C);
    }
   case NoDebug:
    {
      /*const*/ NoDebugAttr /*P*/ A = cast_NoDebugAttr(At);
      return A.clone(C);
    }
   case NoDuplicate:
    {
      /*const*/ NoDuplicateAttr /*P*/ A = cast_NoDuplicateAttr(At);
      return A.clone(C);
    }
   case NoInline:
    {
      /*const*/ NoInlineAttr /*P*/ A = cast_NoInlineAttr(At);
      return A.clone(C);
    }
   case NoInstrumentFunction:
    {
      /*const*/ NoInstrumentFunctionAttr /*P*/ A = cast_NoInstrumentFunctionAttr(At);
      return A.clone(C);
    }
   case NoMips16:
    {
      /*const*/ NoMips16Attr /*P*/ A = cast_NoMips16Attr(At);
      return A.clone(C);
    }
   case NoReturn:
    {
      /*const*/ NoReturnAttr /*P*/ A = cast_NoReturnAttr(At);
      return A.clone(C);
    }
   case NoSanitize:
    {
      /*const*/ NoSanitizeAttr /*P*/ A = cast_NoSanitizeAttr(At);
      return A.clone(C);
    }
   case NoSplitStack:
    {
      /*const*/ NoSplitStackAttr /*P*/ A = cast_NoSplitStackAttr(At);
      return A.clone(C);
    }
   case NoThreadSafetyAnalysis:
    {
      /*const*/ NoThreadSafetyAnalysisAttr /*P*/ A = cast_NoThreadSafetyAnalysisAttr(At);
      return A.clone(C);
    }
   case NoThrow:
    {
      /*const*/ NoThrowAttr /*P*/ A = cast_NoThrowAttr(At);
      return A.clone(C);
    }
   case NonNull:
    {
      /*const*/ NonNullAttr /*P*/ A = cast_NonNullAttr(At);
      return A.clone(C);
    }
   case NotTailCalled:
    {
      /*const*/ NotTailCalledAttr /*P*/ A = cast_NotTailCalledAttr(At);
      return A.clone(C);
    }
   case OMPCaptureNoInit:
    {
      /*const*/ OMPCaptureNoInitAttr /*P*/ A = cast_OMPCaptureNoInitAttr(At);
      return A.clone(C);
    }
   case OMPDeclareSimdDecl:
    {
      /*const*/ OMPDeclareSimdDeclAttr /*P*/ A = cast_OMPDeclareSimdDeclAttr(At);
      return A.clone(C);
    }
   case OMPDeclareTargetDecl:
    {
      /*const*/ OMPDeclareTargetDeclAttr /*P*/ A = cast_OMPDeclareTargetDeclAttr(At);
      return A.clone(C);
    }
   case OMPThreadPrivateDecl:
    {
      /*const*/ OMPThreadPrivateDeclAttr /*P*/ A = cast_OMPThreadPrivateDeclAttr(At);
      return A.clone(C);
    }
   case ObjCBoxable:
    {
      /*const*/ ObjCBoxableAttr /*P*/ A = cast_ObjCBoxableAttr(At);
      return A.clone(C);
    }
   case ObjCBridge:
    {
      /*const*/ ObjCBridgeAttr /*P*/ A = cast_ObjCBridgeAttr(At);
      return A.clone(C);
    }
   case ObjCBridgeMutable:
    {
      /*const*/ ObjCBridgeMutableAttr /*P*/ A = cast_ObjCBridgeMutableAttr(At);
      return A.clone(C);
    }
   case ObjCBridgeRelated:
    {
      /*const*/ ObjCBridgeRelatedAttr /*P*/ A = cast_ObjCBridgeRelatedAttr(At);
      return A.clone(C);
    }
   case ObjCDesignatedInitializer:
    {
      /*const*/ ObjCDesignatedInitializerAttr /*P*/ A = cast_ObjCDesignatedInitializerAttr(At);
      return A.clone(C);
    }
   case ObjCException:
    {
      /*const*/ ObjCExceptionAttr /*P*/ A = cast_ObjCExceptionAttr(At);
      return A.clone(C);
    }
   case ObjCExplicitProtocolImpl:
    {
      /*const*/ ObjCExplicitProtocolImplAttr /*P*/ A = cast_ObjCExplicitProtocolImplAttr(At);
      return A.clone(C);
    }
   case ObjCIndependentClass:
    {
      /*const*/ ObjCIndependentClassAttr /*P*/ A = cast_ObjCIndependentClassAttr(At);
      return A.clone(C);
    }
   case ObjCMethodFamily:
    {
      /*const*/ ObjCMethodFamilyAttr /*P*/ A = cast_ObjCMethodFamilyAttr(At);
      return A.clone(C);
    }
   case ObjCNSObject:
    {
      /*const*/ ObjCNSObjectAttr /*P*/ A = cast_ObjCNSObjectAttr(At);
      return A.clone(C);
    }
   case ObjCPreciseLifetime:
    {
      /*const*/ ObjCPreciseLifetimeAttr /*P*/ A = cast_ObjCPreciseLifetimeAttr(At);
      return A.clone(C);
    }
   case ObjCRequiresPropertyDefs:
    {
      /*const*/ ObjCRequiresPropertyDefsAttr /*P*/ A = cast_ObjCRequiresPropertyDefsAttr(At);
      return A.clone(C);
    }
   case ObjCRequiresSuper:
    {
      /*const*/ ObjCRequiresSuperAttr /*P*/ A = cast_ObjCRequiresSuperAttr(At);
      return A.clone(C);
    }
   case ObjCReturnsInnerPointer:
    {
      /*const*/ ObjCReturnsInnerPointerAttr /*P*/ A = cast_ObjCReturnsInnerPointerAttr(At);
      return A.clone(C);
    }
   case ObjCRootClass:
    {
      /*const*/ ObjCRootClassAttr /*P*/ A = cast_ObjCRootClassAttr(At);
      return A.clone(C);
    }
   case ObjCRuntimeName:
    {
      /*const*/ ObjCRuntimeNameAttr /*P*/ A = cast_ObjCRuntimeNameAttr(At);
      return A.clone(C);
    }
   case ObjCRuntimeVisible:
    {
      /*const*/ ObjCRuntimeVisibleAttr /*P*/ A = cast_ObjCRuntimeVisibleAttr(At);
      return A.clone(C);
    }
   case OpenCLAccess:
    {
      /*const*/ OpenCLAccessAttr /*P*/ A = cast_OpenCLAccessAttr(At);
      return A.clone(C);
    }
   case OpenCLKernel:
    {
      /*const*/ OpenCLKernelAttr /*P*/ A = cast_OpenCLKernelAttr(At);
      return A.clone(C);
    }
   case OpenCLUnrollHint:
    {
      /*const*/ OpenCLUnrollHintAttr /*P*/ A = cast_OpenCLUnrollHintAttr(At);
      return A.clone(C);
    }
   case OptimizeNone:
    {
      /*const*/ OptimizeNoneAttr /*P*/ A = cast_OptimizeNoneAttr(At);
      return A.clone(C);
    }
   case Overloadable:
    {
      /*const*/ OverloadableAttr /*P*/ A = cast_OverloadableAttr(At);
      return A.clone(C);
    }
   case Override:
    {
      /*const*/ OverrideAttr /*P*/ A = cast_OverrideAttr(At);
      return A.clone(C);
    }
   case Ownership:
    {
      /*const*/ OwnershipAttr /*P*/ A = cast_OwnershipAttr(At);
      return A.clone(C);
    }
   case Packed:
    {
      /*const*/ PackedAttr /*P*/ A = cast_PackedAttr(At);
      return A.clone(C);
    }
   case ParamTypestate:
    {
      /*const*/ ParamTypestateAttr /*P*/ A = cast_ParamTypestateAttr(At);
      return A.clone(C);
    }
   case Pascal:
    {
      /*const*/ PascalAttr /*P*/ A = cast_PascalAttr(At);
      return A.clone(C);
    }
   case PassObjectSize:
    {
      /*const*/ PassObjectSizeAttr /*P*/ A = cast_PassObjectSizeAttr(At);
      return A.clone(C);
    }
   case Pcs:
    {
      /*const*/ PcsAttr /*P*/ A = cast_PcsAttr(At);
      return A.clone(C);
    }
   case PreserveAll:
    {
      /*const*/ PreserveAllAttr /*P*/ A = cast_PreserveAllAttr(At);
      return A.clone(C);
    }
   case PreserveMost:
    {
      /*const*/ PreserveMostAttr /*P*/ A = cast_PreserveMostAttr(At);
      return A.clone(C);
    }
   case PtGuardedBy:
    {
      /*const*/ PtGuardedByAttr /*P*/ A = cast_PtGuardedByAttr(At);
      Expr /*P*/ tempInstArg;
      {
        EnterExpressionEvaluationContext Unevaluated = null;
        try {
          Unevaluated/*J*/= new EnterExpressionEvaluationContext(S, Sema.ExpressionEvaluationContext.Unevaluated);
          ActionResultTTrue<Expr /*P*/ > Result = S.SubstExpr(A.getArg(), TemplateArgs);
          tempInstArg = Result.getAs(Expr.class);
        } finally {
          if (Unevaluated != null) { Unevaluated.$destroy(); }
        }
      }
      return /*FIXME:NEW_EXPR*//*new (C)*/ new PtGuardedByAttr(new SourceRange(A.getLocation()), C, tempInstArg, A.getSpellingListIndex());
    }
   case PtGuardedVar:
    {
      /*const*/ PtGuardedVarAttr /*P*/ A = cast_PtGuardedVarAttr(At);
      return A.clone(C);
    }
   case Pure:
    {
      /*const*/ PureAttr /*P*/ A = cast_PureAttr(At);
      return A.clone(C);
    }
   case ReleaseCapability:
    {
      /*const*/ ReleaseCapabilityAttr /*P*/ A = cast_ReleaseCapabilityAttr(At);
      Expr/*P*/ tempInstArgs[] = (/*FIXME:NEW_EXPR*//*new (C, 16)*/ new Expr /*P*/ [A.args_size()]);
      {
        EnterExpressionEvaluationContext Unevaluated = null;
        try {
          Unevaluated/*J*/= new EnterExpressionEvaluationContext(S, Sema.ExpressionEvaluationContext.Unevaluated);
          type$ptr<Expr/*P*/> TI = create_type$ptr(tempInstArgs);
          type$ptr<Expr/*P*/> I = $tryClone(A.args_begin());
          type$ptr<Expr/*P*/> E = $tryClone(A.args_end());
          for (; $noteq_ptr(I, E); I.$preInc() , TI.$preInc()) {
            ActionResultTTrue<Expr /*P*/ > Result = S.SubstExpr(I.$star(), TemplateArgs);
            TI.$set(Result.getAs(Expr.class));
          }
        } finally {
          if (Unevaluated != null) { Unevaluated.$destroy(); }
        }
      }
      return /*FIXME:NEW_EXPR*//*new (C)*/ new ReleaseCapabilityAttr(new SourceRange(A.getLocation()), C, create_type$ptr(tempInstArgs), A.args_size(), A.getSpellingListIndex());
    }
   case RenderScriptKernel:
    {
      /*const*/ RenderScriptKernelAttr /*P*/ A = cast_RenderScriptKernelAttr(At);
      return A.clone(C);
    }
   case ReqdWorkGroupSize:
    {
      /*const*/ ReqdWorkGroupSizeAttr /*P*/ A = cast_ReqdWorkGroupSizeAttr(At);
      return A.clone(C);
    }
   case RequiresCapability:
    {
      /*const*/ RequiresCapabilityAttr /*P*/ A = cast_RequiresCapabilityAttr(At);
      Expr/*P*/ tempInstArgs[] = (/*FIXME:NEW_EXPR*//*new (C, 16)*/ new Expr /*P*/ [A.args_size()]);
      {
        EnterExpressionEvaluationContext Unevaluated = null;
        try {
          Unevaluated/*J*/= new EnterExpressionEvaluationContext(S, Sema.ExpressionEvaluationContext.Unevaluated);
          type$ptr<Expr/*P*/> TI = create_type$ptr(tempInstArgs);
          type$ptr<Expr/*P*/> I = $tryClone(A.args_begin());
          type$ptr<Expr/*P*/> E = $tryClone(A.args_end());
          for (; $noteq_ptr(I, E); I.$preInc() , TI.$preInc()) {
            ActionResultTTrue<Expr /*P*/ > Result = S.SubstExpr(I.$star(), TemplateArgs);
            TI.$set(Result.getAs(Expr.class));
          }
        } finally {
          if (Unevaluated != null) { Unevaluated.$destroy(); }
        }
      }
      return /*FIXME:NEW_EXPR*//*new (C)*/ new RequiresCapabilityAttr(new SourceRange(A.getLocation()), C, create_type$ptr(tempInstArgs), A.args_size(), A.getSpellingListIndex());
    }
   case Restrict:
    {
      /*const*/ RestrictAttr /*P*/ A = cast_RestrictAttr(At);
      return A.clone(C);
    }
   case ReturnTypestate:
    {
      /*const*/ ReturnTypestateAttr /*P*/ A = cast_ReturnTypestateAttr(At);
      return A.clone(C);
    }
   case ReturnsNonNull:
    {
      /*const*/ ReturnsNonNullAttr /*P*/ A = cast_ReturnsNonNullAttr(At);
      return A.clone(C);
    }
   case ReturnsTwice:
    {
      /*const*/ ReturnsTwiceAttr /*P*/ A = cast_ReturnsTwiceAttr(At);
      return A.clone(C);
    }
   case ScopedLockable:
    {
      /*const*/ ScopedLockableAttr /*P*/ A = cast_ScopedLockableAttr(At);
      return A.clone(C);
    }
   case Section:
    {
      /*const*/ SectionAttr /*P*/ A = cast_SectionAttr(At);
      return A.clone(C);
    }
   case SelectAny:
    {
      /*const*/ SelectAnyAttr /*P*/ A = cast_SelectAnyAttr(At);
      return A.clone(C);
    }
   case Sentinel:
    {
      /*const*/ SentinelAttr /*P*/ A = cast_SentinelAttr(At);
      return A.clone(C);
    }
   case SetTypestate:
    {
      /*const*/ SetTypestateAttr /*P*/ A = cast_SetTypestateAttr(At);
      return A.clone(C);
    }
   case SharedTrylockFunction:
    {
      /*const*/ SharedTrylockFunctionAttr /*P*/ A = cast_SharedTrylockFunctionAttr(At);
      Expr /*P*/ tempInstSuccessValue;
      {
        EnterExpressionEvaluationContext Unevaluated = null;
        try {
          Unevaluated/*J*/= new EnterExpressionEvaluationContext(S, Sema.ExpressionEvaluationContext.Unevaluated);
          ActionResultTTrue<Expr /*P*/ > Result = S.SubstExpr(A.getSuccessValue(), TemplateArgs);
          tempInstSuccessValue = Result.getAs(Expr.class);
        } finally {
          if (Unevaluated != null) { Unevaluated.$destroy(); }
        }
      }
      Expr/*P*/ tempInstArgs[] = (/*FIXME:NEW_EXPR*//*new (C, 16)*/ new Expr /*P*/ [A.args_size()]);
      {
        EnterExpressionEvaluationContext Unevaluated = null;
        try {
          Unevaluated/*J*/= new EnterExpressionEvaluationContext(S, Sema.ExpressionEvaluationContext.Unevaluated);
          type$ptr<Expr/*P*/> TI = create_type$ptr(tempInstArgs);
          type$ptr<Expr/*P*/> I = $tryClone(A.args_begin());
          type$ptr<Expr/*P*/> E = $tryClone(A.args_end());
          for (; $noteq_ptr(I, E); I.$preInc() , TI.$preInc()) {
            ActionResultTTrue<Expr /*P*/ > Result = S.SubstExpr(I.$star(), TemplateArgs);
            TI.$set(Result.getAs(Expr.class));
          }
        } finally {
          if (Unevaluated != null) { Unevaluated.$destroy(); }
        }
      }
      return /*FIXME:NEW_EXPR*//*new (C)*/ new SharedTrylockFunctionAttr(new SourceRange(A.getLocation()), C, tempInstSuccessValue, create_type$ptr(tempInstArgs), A.args_size(), A.getSpellingListIndex());
    }
   case StdCall:
    {
      /*const*/ StdCallAttr /*P*/ A = cast_StdCallAttr(At);
      return A.clone(C);
    }
   case SwiftCall:
    {
      /*const*/ SwiftCallAttr /*P*/ A = cast_SwiftCallAttr(At);
      return A.clone(C);
    }
   case SwiftContext:
    {
      /*const*/ SwiftContextAttr /*P*/ A = cast_SwiftContextAttr(At);
      return A.clone(C);
    }
   case SwiftErrorResult:
    {
      /*const*/ SwiftErrorResultAttr /*P*/ A = cast_SwiftErrorResultAttr(At);
      return A.clone(C);
    }
   case SwiftIndirectResult:
    {
      /*const*/ SwiftIndirectResultAttr /*P*/ A = cast_SwiftIndirectResultAttr(At);
      return A.clone(C);
    }
   case SysVABI:
    {
      /*const*/ SysVABIAttr /*P*/ A = cast_SysVABIAttr(At);
      return A.clone(C);
    }
   case TLSModel:
    {
      /*const*/ TLSModelAttr /*P*/ A = cast_TLSModelAttr(At);
      return A.clone(C);
    }
   case Target:
    {
      /*const*/ TargetAttr /*P*/ A = cast_TargetAttr(At);
      return A.clone(C);
    }
   case TestTypestate:
    {
      /*const*/ TestTypestateAttr /*P*/ A = cast_TestTypestateAttr(At);
      return A.clone(C);
    }
   case ThisCall:
    {
      /*const*/ ThisCallAttr /*P*/ A = cast_ThisCallAttr(At);
      return A.clone(C);
    }
   case Thread:
    {
      /*const*/ ThreadAttr /*P*/ A = cast_ThreadAttr(At);
      return A.clone(C);
    }
   case TransparentUnion:
    {
      /*const*/ TransparentUnionAttr /*P*/ A = cast_TransparentUnionAttr(At);
      return A.clone(C);
    }
   case TryAcquireCapability:
    {
      /*const*/ TryAcquireCapabilityAttr /*P*/ A = cast_TryAcquireCapabilityAttr(At);
      Expr /*P*/ tempInstSuccessValue;
      {
        EnterExpressionEvaluationContext Unevaluated = null;
        try {
          Unevaluated/*J*/= new EnterExpressionEvaluationContext(S, Sema.ExpressionEvaluationContext.Unevaluated);
          ActionResultTTrue<Expr /*P*/ > Result = S.SubstExpr(A.getSuccessValue(), TemplateArgs);
          tempInstSuccessValue = Result.getAs(Expr.class);
        } finally {
          if (Unevaluated != null) { Unevaluated.$destroy(); }
        }
      }
      Expr/*P*/ tempInstArgs[] = (/*FIXME:NEW_EXPR*//*new (C, 16)*/ new Expr /*P*/ [A.args_size()]);
      {
        EnterExpressionEvaluationContext Unevaluated = null;
        try {
          Unevaluated/*J*/= new EnterExpressionEvaluationContext(S, Sema.ExpressionEvaluationContext.Unevaluated);
          type$ptr<Expr/*P*/> TI = create_type$ptr(tempInstArgs);
          type$ptr<Expr/*P*/> I = $tryClone(A.args_begin());
          type$ptr<Expr/*P*/> E = $tryClone(A.args_end());
          for (; $noteq_ptr(I, E); I.$preInc() , TI.$preInc()) {
            ActionResultTTrue<Expr /*P*/ > Result = S.SubstExpr(I.$star(), TemplateArgs);
            TI.$set(Result.getAs(Expr.class));
          }
        } finally {
          if (Unevaluated != null) { Unevaluated.$destroy(); }
        }
      }
      return /*FIXME:NEW_EXPR*//*new (C)*/ new TryAcquireCapabilityAttr(new SourceRange(A.getLocation()), C, tempInstSuccessValue, create_type$ptr(tempInstArgs), A.args_size(), A.getSpellingListIndex());
    }
   case TypeTagForDatatype:
    {
      /*const*/ TypeTagForDatatypeAttr /*P*/ A = cast_TypeTagForDatatypeAttr(At);
      return A.clone(C);
    }
   case TypeVisibility:
    {
      return null;
    }
   case Unavailable:
    {
      /*const*/ UnavailableAttr /*P*/ A = cast_UnavailableAttr(At);
      return A.clone(C);
    }
   case Unused:
    {
      /*const*/ UnusedAttr /*P*/ A = cast_UnusedAttr(At);
      return A.clone(C);
    }
   case Used:
    {
      /*const*/ UsedAttr /*P*/ A = cast_UsedAttr(At);
      return A.clone(C);
    }
   case Uuid:
    {
      /*const*/ UuidAttr /*P*/ A = cast_UuidAttr(At);
      return A.clone(C);
    }
   case VecReturn:
    {
      /*const*/ VecReturnAttr /*P*/ A = cast_VecReturnAttr(At);
      return A.clone(C);
    }
   case VecTypeHint:
    {
      /*const*/ VecTypeHintAttr /*P*/ A = cast_VecTypeHintAttr(At);
      return A.clone(C);
    }
   case VectorCall:
    {
      /*const*/ VectorCallAttr /*P*/ A = cast_VectorCallAttr(At);
      return A.clone(C);
    }
   case Visibility:
    {
      return null;
    }
   case WarnUnused:
    {
      /*const*/ WarnUnusedAttr /*P*/ A = cast_WarnUnusedAttr(At);
      return A.clone(C);
    }
   case WarnUnusedResult:
    {
      /*const*/ WarnUnusedResultAttr /*P*/ A = cast_WarnUnusedResultAttr(At);
      return A.clone(C);
    }
   case Weak:
    {
      /*const*/ WeakAttr /*P*/ A = cast_WeakAttr(At);
      return A.clone(C);
    }
   case WeakImport:
    {
      /*const*/ WeakImportAttr /*P*/ A = cast_WeakImportAttr(At);
      return A.clone(C);
    }
   case WeakRef:
    {
      /*const*/ WeakRefAttr /*P*/ A = cast_WeakRefAttr(At);
      return A.clone(C);
    }
   case WorkGroupSizeHint:
    {
      /*const*/ WorkGroupSizeHintAttr /*P*/ A = cast_WorkGroupSizeHintAttr(At);
      return A.clone(C);
    }
   case X86ForceAlignArgPointer:
    {
      /*const*/ X86ForceAlignArgPointerAttr /*P*/ A = cast_X86ForceAlignArgPointerAttr(At);
      return A.clone(C);
    }
   case XRayInstrument:
    {
      /*const*/ XRayInstrumentAttr /*P*/ A = cast_XRayInstrumentAttr(At);
      return A.clone(C);
    }
  } // end switch
  throw new llvm_unreachable("Unknown attribute!");
//  return null;
}

} // END OF class NsSemaStatics
