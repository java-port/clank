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
package org.clang.codegen.CodeGen.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import static org.clang.ast.AstClangGlobals.$out_DiagnosticBuilder$C_QualType;
import org.clang.basic.*;
import static org.clang.basic.BasicClangGlobals.*;
import org.llvm.ir.*;
import org.clang.codegen.CodeGen.*;
import org.clang.basic.target.TargetInfo;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.java.AstStatementsRTTI.*;
import org.clang.codegen.impl.CGStmtStatics;
import static org.clang.codegen.impl.CGStmtStatics.*;
import static org.llvm.ir.java.IrRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type CodeGenFunction_CGStmt">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 NM="org.clang.codegen.CodeGen.impl.CodeGenFunction_CGStmt",        
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this -extends=CodeGenFunction_CGObjC ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction10EmitBranchEPN4llvm10BasicBlockE;_ZN5clang7CodeGen15CodeGenFunction10EmitDoStmtERKNS_6DoStmtEN4llvm8ArrayRefIPKNS_4AttrEEE;_ZN5clang7CodeGen15CodeGenFunction10EmitIfStmtERKNS_6IfStmtE;_ZN5clang7CodeGen15CodeGenFunction11EmitAsmStmtERKNS_7AsmStmtE;_ZN5clang7CodeGen15CodeGenFunction11EmitForStmtERKNS_7ForStmtEN4llvm8ArrayRefIPKNS_4AttrEEE;_ZN5clang7CodeGen15CodeGenFunction12EmitAsmInputERKNS_10TargetInfo14ConstraintInfoEPKNS_4ExprERNSt7__cxx1112basic_stringIcSt11char_traitsIcESaIcEEE;_ZN5clang7CodeGen15CodeGenFunction12EmitCaseStmtERKNS_8CaseStmtE;_ZN5clang7CodeGen15CodeGenFunction12EmitDeclStmtERKNS_8DeclStmtE;_ZN5clang7CodeGen15CodeGenFunction12EmitGotoStmtERKNS_8GotoStmtE;_ZN5clang7CodeGen15CodeGenFunction13EmitBreakStmtERKNS_9BreakStmtE;_ZN5clang7CodeGen15CodeGenFunction13EmitLabelStmtERKNS_9LabelStmtE;_ZN5clang7CodeGen15CodeGenFunction13EmitStopPointEPKNS_4StmtE;_ZN5clang7CodeGen15CodeGenFunction13EmitWhileStmtERKNS_9WhileStmtEN4llvm8ArrayRefIPKNS_4AttrEEE;_ZN5clang7CodeGen15CodeGenFunction14EmitReturnStmtERKNS_10ReturnStmtE;_ZN5clang7CodeGen15CodeGenFunction14EmitSimpleStmtEPKNS_4StmtE;_ZN5clang7CodeGen15CodeGenFunction14EmitSwitchStmtERKNS_10SwitchStmtE;_ZN5clang7CodeGen15CodeGenFunction15EmitDefaultStmtERKNS_11DefaultStmtE;_ZN5clang7CodeGen15CodeGenFunction16EmitCapturedStmtERKNS_12CapturedStmtENS_18CapturedRegionKindE;_ZN5clang7CodeGen15CodeGenFunction16EmitCompoundStmtERKNS_12CompoundStmtEbNS0_12AggValueSlotE;_ZN5clang7CodeGen15CodeGenFunction16EmitContinueStmtERKNS_12ContinueStmtE;_ZN5clang7CodeGen15CodeGenFunction17EmitCaseStmtRangeERKNS_8CaseStmtE;_ZN5clang7CodeGen15CodeGenFunction18EmitAsmInputLValueERKNS_10TargetInfo14ConstraintInfoENS0_6LValueENS_8QualTypeERNSt7__cxx1112basic_stringIcSt11char_traitsIcESaIcEEENS_14SourceLocationE;_ZN5clang7CodeGen15CodeGenFunction18EmitAttributedStmtERKNS_14AttributedStmtE;_ZN5clang7CodeGen15CodeGenFunction18EmitBlockAfterUsesEPN4llvm10BasicBlockE;_ZN5clang7CodeGen15CodeGenFunction18EmitReturnOfRValueENS0_6RValueENS_8QualTypeE;_ZN5clang7CodeGen15CodeGenFunction18InitCapturedStructERKNS_12CapturedStmtE;_ZN5clang7CodeGen15CodeGenFunction19EmitCXXForRangeStmtERKNS_15CXXForRangeStmtEN4llvm8ArrayRefIPKNS_4AttrEEE;_ZN5clang7CodeGen15CodeGenFunction19getJumpDestForLabelEPKNS_9LabelDeclE;_ZN5clang7CodeGen15CodeGenFunction20EmitIndirectGotoStmtERKNS_16IndirectGotoStmtE;_ZN5clang7CodeGen15CodeGenFunction24SimplifyForwardingBlocksEPN4llvm10BasicBlockE;_ZN5clang7CodeGen15CodeGenFunction28EmitCompoundStmtWithoutScopeERKNS_12CompoundStmtEbNS0_12AggValueSlotE;_ZN5clang7CodeGen15CodeGenFunction28GenerateCapturedStmtArgumentERKNS_12CapturedStmtE;_ZN5clang7CodeGen15CodeGenFunction28GenerateCapturedStmtFunctionERKNS_12CapturedStmtE;_ZN5clang7CodeGen15CodeGenFunction8EmitStmtEPKNS_4StmtE;_ZN5clang7CodeGen15CodeGenFunction9EmitBlockEPN4llvm10BasicBlockEb;_ZN5clang7CodeGen15CodeGenFunction9EmitLabelEPKNS_9LabelDeclE; -static-type=CodeGenFunction_CGStmt -package=org.clang.codegen.CodeGen.impl")
//</editor-fold>
public abstract class CodeGenFunction_CGStmt extends CodeGenFunction_CGObjC {
private final /*split clang::CodeGen::CodeGenFunction*/ CodeGenFunction $this() { return (CodeGenFunction)this; }
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::CodeGenFunction">
@Converted(kind = Converted.Kind.MANUAL_ADDED,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp", line = 40,
 FQN="clang::CodeGen::CodeGenFunction::CodeGenFunction", NM="_ZN5clang7CodeGen15CodeGenFunctionC1ERNS0_13CodeGenModuleEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp -nm=_ZN5clang7CodeGen15CodeGenFunctionC1ERNS0_13CodeGenModuleEb")
//</editor-fold>
protected CodeGenFunction_CGStmt(final CodeGenModule /*&*/ cgm) {
  super(cgm);
}


/// getBasicBlockForLabel - Return the LLVM basicblock that the specified
/// label maps to.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::getJumpDestForLabel">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp", line = 451,
 FQN="clang::CodeGen::CodeGenFunction::getJumpDestForLabel", NM="_ZN5clang7CodeGen15CodeGenFunction19getJumpDestForLabelEPKNS_9LabelDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction19getJumpDestForLabelEPKNS_9LabelDeclE")
//</editor-fold>
public final CodeGenFunction.JumpDest getJumpDestForLabel(/*const*/ LabelDecl /*P*/ D) {
  final JumpDest /*&*/ Dest = $this().LabelMap.$at_T1$C$R(D);
  if (Dest.isValid()) {
    return new CodeGenFunction.JumpDest(Dest);
  }
  
  // Create, but don't insert, the new block.
  Dest.$assignMove(new JumpDest($this().createBasicBlock(new Twine(D.getName())), 
          EHScopeStack.stable_iterator.invalid(), 
          $this().NextCleanupDestIndex++));
  return new CodeGenFunction.JumpDest(Dest);
}


/// SimplifyForwardingBlocks - If the given basic block is only a branch to
/// another basic block, simplify it. This assumes that no other code could
/// potentially reference the basic block.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::SimplifyForwardingBlocks">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp", line = 375,
 FQN="clang::CodeGen::CodeGenFunction::SimplifyForwardingBlocks", NM="_ZN5clang7CodeGen15CodeGenFunction24SimplifyForwardingBlocksEPN4llvm10BasicBlockE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction24SimplifyForwardingBlocksEPN4llvm10BasicBlockE")
//</editor-fold>
public final void SimplifyForwardingBlocks(BasicBlock /*P*/ BB) {
  BranchInst /*P*/ BI = dyn_cast_BranchInst(BB.getTerminator());
  
  // If there is a cleanup stack, then we it isn't worth trying to
  // simplify this block (we would need to remove it from the scope map
  // and cleanup entry).
  if (!$this().EHStack.empty()) {
    return;
  }
  
  // Can only simplify direct branches.
  if (!(BI != null) || !BI.isUnconditional()) {
    return;
  }
  
  // Can only simplify empty blocks.
  if (BI.getIterator().$noteq(BB.begin())) {
    return;
  }
  
  BB.replaceAllUsesWith(BI.getSuccessor(0));
  BI.eraseFromParent();
  BB.eraseFromParent();
}


/// EmitBlock - Emit the given block \arg BB and set it as the insert point,
/// adding a fall-through branch from the current insert block if
/// necessary. It is legal to call this function even if there is no current
/// insertion point.
///
/// IsFinished - If true, indicates that the caller has finished emitting
/// branches to the given block and does not expect to emit code into it. This
/// means the block can be ignored if it is unreachable.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitBlock">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp", line = 397,
 FQN="clang::CodeGen::CodeGenFunction::EmitBlock", NM="_ZN5clang7CodeGen15CodeGenFunction9EmitBlockEPN4llvm10BasicBlockEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction9EmitBlockEPN4llvm10BasicBlockEb")
//</editor-fold>
public final void EmitBlock(BasicBlock /*P*/ BB) {
  EmitBlock(BB, false);
}
public final void EmitBlock(BasicBlock /*P*/ BB, boolean IsFinished/*= false*/) {
  BasicBlock /*P*/ CurBB = $this().Builder.GetInsertBlock();
  
  // Fall out of the current block (if necessary).
  $this().EmitBranch(BB);
  if (IsFinished && BB.use_empty()) {
    /*delete*/Destructors.$destroy((Destructors.ClassWithDestructor)BB);
    return;
  }
  
  // Place the block after the current block, if possible, or else at
  // the end of the function.
  if ((CurBB != null) && (CurBB.getParent() != null)) {
    $this().CurFn.getBasicBlockList().insertAfter(CurBB.getIterator(), BB);
  } else {
    $this().CurFn.getBasicBlockList().push_back(BB);
  }
  $this().Builder.SetInsertPoint(BB);
}


/// EmitBlockAfterUses - Emit the given block somewhere hopefully
/// near its uses, and leave the insertion point in it.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitBlockAfterUses">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp", line = 434,
 FQN="clang::CodeGen::CodeGenFunction::EmitBlockAfterUses", NM="_ZN5clang7CodeGen15CodeGenFunction18EmitBlockAfterUsesEPN4llvm10BasicBlockE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction18EmitBlockAfterUsesEPN4llvm10BasicBlockE")
//</editor-fold>
public final void EmitBlockAfterUses(BasicBlock /*P*/ block) {
  boolean inserted = false;
  for (User /*P*/ u : block.users()) {
    {
      Instruction /*P*/ insn = dyn_cast_Instruction(u);
      if ((insn != null)) {
        $this().CurFn.getBasicBlockList().insertAfter(insn.getParent().getIterator(), 
            block);
        inserted = true;
        break;
      }
    }
  }
  if (!inserted) {
    $this().CurFn.getBasicBlockList().push_back(block);
  }
  
  $this().Builder.SetInsertPoint(block);
}


/// EmitBranch - Emit a branch to the specified basic block from the current
/// insert block, taking care to avoid creation of branches from dummy
/// blocks. It is legal to call this function even if there is no current
/// insertion point.
///
/// This function clears the current insertion point. The caller should follow
/// calls to this function with calls to Emit*Block prior to generation new
/// code.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitBranch">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp", line = 417,
 FQN="clang::CodeGen::CodeGenFunction::EmitBranch", NM="_ZN5clang7CodeGen15CodeGenFunction10EmitBranchEPN4llvm10BasicBlockE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction10EmitBranchEPN4llvm10BasicBlockE")
//</editor-fold>
public final void EmitBranch(BasicBlock /*P*/ Target) {
  // Emit a branch from the current block to the target one if this
  // was a real block.  If this was just a fall-through block after a
  // terminator, don't emit it.
  BasicBlock /*P*/ CurBB = $this().Builder.GetInsertBlock();
  if (!(CurBB != null) || (CurBB.getTerminator() != null)) {
    // If there is no insert point or the previous block is already
    // terminated, don't touch it.
  } else {
    // Otherwise, create a fall-through branch.
    $this().Builder.CreateBr(Target);
  }
  
  $this().Builder.ClearInsertionPoint();
}


//===--------------------------------------------------------------------===//
//                             Statement Emission
//===--------------------------------------------------------------------===//

/// EmitStopPoint - Emit a debug stoppoint if we are emitting debug info.

//===----------------------------------------------------------------------===//
//                              Statement Emission
//===----------------------------------------------------------------------===//
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitStopPoint">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp", line = 38,
 FQN="clang::CodeGen::CodeGenFunction::EmitStopPoint", NM="_ZN5clang7CodeGen15CodeGenFunction13EmitStopPointEPKNS_4StmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction13EmitStopPointEPKNS_4StmtE")
//</editor-fold>
public final void EmitStopPoint(/*const*/ Stmt /*P*/ S) {
  {
    CGDebugInfo /*P*/ DI = $this().getDebugInfo();
    if ((DI != null)) {
      SourceLocation Loc/*J*/= new SourceLocation();
      Loc.$assignMove(S.getLocStart());
      DI.EmitLocation($this().Builder, new SourceLocation(Loc));
      
      $this().LastStopPoint.$assign(Loc);
    }
  }
}


/// EmitStmt - Emit the code for the statement \arg S. It is legal to call
/// this function even if there is no current insertion point.
///
/// This function may clear the current insertion point; callers should use
/// EnsureInsertPoint if they wish to subsequently generate code without first
/// calling EmitBlock, EmitBranch, or EmitStmt.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitStmt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp", line = 48,
 FQN="clang::CodeGen::CodeGenFunction::EmitStmt", NM="_ZN5clang7CodeGen15CodeGenFunction8EmitStmtEPKNS_4StmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction8EmitStmtEPKNS_4StmtE")
//</editor-fold>
public final void EmitStmt(/*const*/ Stmt /*P*/ S) {
  assert ((S != null)) : "Null statement?";
  $this().PGO.setCurrentStmt(S);
  
  // These statements have their own debug info handling.
  if ($this().EmitSimpleStmt(S)) {
    return;
  }
  
  // Check if we are generating unreachable code.
  if (!$this().HaveInsertPoint()) {
    // If so, and the statement doesn't contain a label, then we do not need to
    // generate actual code. This is safe because (1) the current point is
    // unreachable, so we don't need to execute the code, and (2) we've already
    // handled the statements which update internal data structures (like the
    // local variable map) which could be used by subsequent statements.
    if (!CodeGenFunction.ContainsLabel(S)) {
      // Verify that any decl statements were handled as simple, they may be in
      // scope of subsequent reachable statements.
      assert (!isa_DeclStmt($Deref(S))) : "Unexpected DeclStmt!";
      return;
    }
    
    // Otherwise, make a new block to hold the code.
    $this().EnsureInsertPoint();
  }
  
  // Generate a stoppoint if we are emitting debug info.
  $this().EmitStopPoint(S);
  switch (S.getStmtClass()) {
   case NoStmtClass:
   case CXXCatchStmtClass:
   case SEHExceptStmtClass:
   case SEHFinallyStmtClass:
   case MSDependentExistsStmtClass:
    throw new llvm_unreachable("invalid statement class to emit generically");
   case NullStmtClass:
   case CompoundStmtClass:
   case DeclStmtClass:
   case LabelStmtClass:
   case AttributedStmtClass:
   case GotoStmtClass:
   case BreakStmtClass:
   case ContinueStmtClass:
   case DefaultStmtClass:
   case CaseStmtClass:
   case SEHLeaveStmtClass:
    throw new llvm_unreachable("should have emitted these statements as simple");
   case BinaryConditionalOperatorClass:
   case ConditionalOperatorClass:
   case AddrLabelExprClass:
   case ArraySubscriptExprClass:
   case ArrayTypeTraitExprClass:
   case AsTypeExprClass:
   case AtomicExprClass:
   case BinaryOperatorClass:
   case CompoundAssignOperatorClass:
   case BlockExprClass:
   case CXXBindTemporaryExprClass:
   case CXXBoolLiteralExprClass:
   case CXXConstructExprClass:
   case CXXTemporaryObjectExprClass:
   case CXXDefaultArgExprClass:
   case CXXDefaultInitExprClass:
   case CXXDeleteExprClass:
   case CXXDependentScopeMemberExprClass:
   case CXXFoldExprClass:
   case CXXInheritedCtorInitExprClass:
   case CXXNewExprClass:
   case CXXNoexceptExprClass:
   case CXXNullPtrLiteralExprClass:
   case CXXPseudoDestructorExprClass:
   case CXXScalarValueInitExprClass:
   case CXXStdInitializerListExprClass:
   case CXXThisExprClass:
   case CXXThrowExprClass:
   case CXXTypeidExprClass:
   case CXXUnresolvedConstructExprClass:
   case CXXUuidofExprClass:
   case CallExprClass:
   case CUDAKernelCallExprClass:
   case CXXMemberCallExprClass:
   case CXXOperatorCallExprClass:
   case UserDefinedLiteralClass:
   case CStyleCastExprClass:
   case CXXFunctionalCastExprClass:
   case CXXConstCastExprClass:
   case CXXDynamicCastExprClass:
   case CXXReinterpretCastExprClass:
   case CXXStaticCastExprClass:
   case ObjCBridgedCastExprClass:
   case ImplicitCastExprClass:
   case CharacterLiteralClass:
   case ChooseExprClass:
   case CompoundLiteralExprClass:
   case ConvertVectorExprClass:
   case CoawaitExprClass:
   case CoyieldExprClass:
   case DeclRefExprClass:
   case DependentScopeDeclRefExprClass:
   case DesignatedInitExprClass:
   case DesignatedInitUpdateExprClass:
   case ExprWithCleanupsClass:
   case ExpressionTraitExprClass:
   case ExtVectorElementExprClass:
   case FloatingLiteralClass:
   case FunctionParmPackExprClass:
   case GNUNullExprClass:
   case GenericSelectionExprClass:
   case ImaginaryLiteralClass:
   case ImplicitValueInitExprClass:
   case InitListExprClass:
   case IntegerLiteralClass:
   case LambdaExprClass:
   case MSPropertyRefExprClass:
   case MSPropertySubscriptExprClass:
   case MaterializeTemporaryExprClass:
   case MemberExprClass:
   case NoInitExprClass:
   case OMPArraySectionExprClass:
   case ObjCArrayLiteralClass:
   case ObjCAvailabilityCheckExprClass:
   case ObjCBoolLiteralExprClass:
   case ObjCBoxedExprClass:
   case ObjCDictionaryLiteralClass:
   case ObjCEncodeExprClass:
   case ObjCIndirectCopyRestoreExprClass:
   case ObjCIsaExprClass:
   case ObjCIvarRefExprClass:
   case ObjCMessageExprClass:
   case ObjCPropertyRefExprClass:
   case ObjCProtocolExprClass:
   case ObjCSelectorExprClass:
   case ObjCStringLiteralClass:
   case ObjCSubscriptRefExprClass:
   case OffsetOfExprClass:
   case OpaqueValueExprClass:
   case UnresolvedLookupExprClass:
   case UnresolvedMemberExprClass:
   case PackExpansionExprClass:
   case ParenExprClass:
   case ParenListExprClass:
   case PredefinedExprClass:
   case PseudoObjectExprClass:
   case ShuffleVectorExprClass:
   case SizeOfPackExprClass:
   case StmtExprClass:
   case StringLiteralClass:
   case SubstNonTypeTemplateParmExprClass:
   case SubstNonTypeTemplateParmPackExprClass:
   case TypeTraitExprClass:
   case TypoExprClass:
   case UnaryExprOrTypeTraitExprClass:
   case UnaryOperatorClass:
   case VAArgExprClass:
    {
      // Remember the block we came in on.
      BasicBlock /*P*/ incoming = $this().Builder.GetInsertBlock();
      assert ((incoming != null)) : "expression emission must have an insertion point";
      
      $this().EmitIgnoredExpr(cast_Expr(S));
      
      BasicBlock /*P*/ outgoing = $this().Builder.GetInsertBlock();
      assert ((outgoing != null)) : "expression emission cleared block!";
      
      // The expression emitters assume (reasonably!) that the insertion
      // point is always set.  To maintain that, the call-emission code
      // for noreturn functions has to enter a new block with no
      // predecessors.  We want to kill that block and mark the current
      // insertion point unreachable in the common case of a call like
      // "exit();".  Since expression emission doesn't otherwise create
      // blocks with no predecessors, we can just test for that.
      // However, we must be careful not to do this to our incoming
      // block, because *statement* emission does sometimes create
      // reachable blocks which will have no predecessors until later in
      // the function.  This occurs with, e.g., labels that are not
      // reachable by fallthrough.
      if (incoming != outgoing && outgoing.use_empty()) {
        outgoing.eraseFromParent();
        $this().Builder.ClearInsertionPoint();
      }
      break;
    }
   case IndirectGotoStmtClass:
    $this().EmitIndirectGotoStmt(cast_IndirectGotoStmt($Deref(S)));
    break;
   case IfStmtClass:
    $this().EmitIfStmt(cast_IfStmt($Deref(S)));
    break;
   case WhileStmtClass:
    $this().EmitWhileStmt(cast_WhileStmt($Deref(S)));
    break;
   case DoStmtClass:
    $this().EmitDoStmt(cast_DoStmt($Deref(S)));
    break;
   case ForStmtClass:
    $this().EmitForStmt(cast_ForStmt($Deref(S)));
    break;
   case ReturnStmtClass:
    $this().EmitReturnStmt(cast_ReturnStmt($Deref(S)));
    break;
   case SwitchStmtClass:
    $this().EmitSwitchStmt(cast_SwitchStmt($Deref(S)));
    break;
   case GCCAsmStmtClass: // Intentional fall-through.
   case MSAsmStmtClass:
    $this().EmitAsmStmt(cast_AsmStmt($Deref(S)));
    break;
   case CoroutineBodyStmtClass:
   case CoreturnStmtClass:
    $this().CGM.ErrorUnsupported(S, $("coroutine"));
    break;
   case CapturedStmtClass:
    {
      /*const*/ CapturedStmt /*P*/ CS = cast_CapturedStmt(S);
      $this().EmitCapturedStmt($Deref(CS), CS.getCapturedRegionKind());
    }
    break;
   case ObjCAtTryStmtClass:
    $this().EmitObjCAtTryStmt(cast_ObjCAtTryStmt($Deref(S)));
    break;
   case ObjCAtCatchStmtClass:
    throw new llvm_unreachable("@catch statements should be handled by EmitObjCAtTryStmt");
   case ObjCAtFinallyStmtClass:
    throw new llvm_unreachable("@finally statements should be handled by EmitObjCAtTryStmt");
   case ObjCAtThrowStmtClass:
    $this().EmitObjCAtThrowStmt(cast_ObjCAtThrowStmt($Deref(S)));
    break;
   case ObjCAtSynchronizedStmtClass:
    $this().EmitObjCAtSynchronizedStmt(cast_ObjCAtSynchronizedStmt($Deref(S)));
    break;
   case ObjCForCollectionStmtClass:
    $this().EmitObjCForCollectionStmt(cast_ObjCForCollectionStmt($Deref(S)));
    break;
   case ObjCAutoreleasePoolStmtClass:
    $this().EmitObjCAutoreleasePoolStmt(cast_ObjCAutoreleasePoolStmt($Deref(S)));
    break;
   case CXXTryStmtClass:
    $this().EmitCXXTryStmt(cast_CXXTryStmt($Deref(S)));
    break;
   case CXXForRangeStmtClass:
    $this().EmitCXXForRangeStmt(cast_CXXForRangeStmt($Deref(S)));
    break;
   case SEHTryStmtClass:
    $this().EmitSEHTryStmt(cast_SEHTryStmt($Deref(S)));
    break;
   case OMPParallelDirectiveClass:
    $this().EmitOMPParallelDirective(cast_OMPParallelDirective($Deref(S)));
    break;
   case OMPSimdDirectiveClass:
    $this().EmitOMPSimdDirective(cast_OMPSimdDirective($Deref(S)));
    break;
   case OMPForDirectiveClass:
    $this().EmitOMPForDirective(cast_OMPForDirective($Deref(S)));
    break;
   case OMPForSimdDirectiveClass:
    $this().EmitOMPForSimdDirective(cast_OMPForSimdDirective($Deref(S)));
    break;
   case OMPSectionsDirectiveClass:
    $this().EmitOMPSectionsDirective(cast_OMPSectionsDirective($Deref(S)));
    break;
   case OMPSectionDirectiveClass:
    $this().EmitOMPSectionDirective(cast_OMPSectionDirective($Deref(S)));
    break;
   case OMPSingleDirectiveClass:
    $this().EmitOMPSingleDirective(cast_OMPSingleDirective($Deref(S)));
    break;
   case OMPMasterDirectiveClass:
    $this().EmitOMPMasterDirective(cast_OMPMasterDirective($Deref(S)));
    break;
   case OMPCriticalDirectiveClass:
    $this().EmitOMPCriticalDirective(cast_OMPCriticalDirective($Deref(S)));
    break;
   case OMPParallelForDirectiveClass:
    $this().EmitOMPParallelForDirective(cast_OMPParallelForDirective($Deref(S)));
    break;
   case OMPParallelForSimdDirectiveClass:
    $this().EmitOMPParallelForSimdDirective(cast_OMPParallelForSimdDirective($Deref(S)));
    break;
   case OMPParallelSectionsDirectiveClass:
    $this().EmitOMPParallelSectionsDirective(cast_OMPParallelSectionsDirective($Deref(S)));
    break;
   case OMPTaskDirectiveClass:
    $this().EmitOMPTaskDirective(cast_OMPTaskDirective($Deref(S)));
    break;
   case OMPTaskyieldDirectiveClass:
    $this().EmitOMPTaskyieldDirective(cast_OMPTaskyieldDirective($Deref(S)));
    break;
   case OMPBarrierDirectiveClass:
    $this().EmitOMPBarrierDirective(cast_OMPBarrierDirective($Deref(S)));
    break;
   case OMPTaskwaitDirectiveClass:
    $this().EmitOMPTaskwaitDirective(cast_OMPTaskwaitDirective($Deref(S)));
    break;
   case OMPTaskgroupDirectiveClass:
    $this().EmitOMPTaskgroupDirective(cast_OMPTaskgroupDirective($Deref(S)));
    break;
   case OMPFlushDirectiveClass:
    $this().EmitOMPFlushDirective(cast_OMPFlushDirective($Deref(S)));
    break;
   case OMPOrderedDirectiveClass:
    $this().EmitOMPOrderedDirective(cast_OMPOrderedDirective($Deref(S)));
    break;
   case OMPAtomicDirectiveClass:
    $this().EmitOMPAtomicDirective(cast_OMPAtomicDirective($Deref(S)));
    break;
   case OMPTargetDirectiveClass:
    $this().EmitOMPTargetDirective(cast_OMPTargetDirective($Deref(S)));
    break;
   case OMPTeamsDirectiveClass:
    $this().EmitOMPTeamsDirective(cast_OMPTeamsDirective($Deref(S)));
    break;
   case OMPCancellationPointDirectiveClass:
    $this().EmitOMPCancellationPointDirective(cast_OMPCancellationPointDirective($Deref(S)));
    break;
   case OMPCancelDirectiveClass:
    $this().EmitOMPCancelDirective(cast_OMPCancelDirective($Deref(S)));
    break;
   case OMPTargetDataDirectiveClass:
    $this().EmitOMPTargetDataDirective(cast_OMPTargetDataDirective($Deref(S)));
    break;
   case OMPTargetEnterDataDirectiveClass:
    $this().EmitOMPTargetEnterDataDirective(cast_OMPTargetEnterDataDirective($Deref(S)));
    break;
   case OMPTargetExitDataDirectiveClass:
    $this().EmitOMPTargetExitDataDirective(cast_OMPTargetExitDataDirective($Deref(S)));
    break;
   case OMPTargetParallelDirectiveClass:
    $this().EmitOMPTargetParallelDirective(cast_OMPTargetParallelDirective($Deref(S)));
    break;
   case OMPTargetParallelForDirectiveClass:
    $this().EmitOMPTargetParallelForDirective(cast_OMPTargetParallelForDirective($Deref(S)));
    break;
   case OMPTaskLoopDirectiveClass:
    $this().EmitOMPTaskLoopDirective(cast_OMPTaskLoopDirective($Deref(S)));
    break;
   case OMPTaskLoopSimdDirectiveClass:
    $this().EmitOMPTaskLoopSimdDirective(cast_OMPTaskLoopSimdDirective($Deref(S)));
    break;
   case OMPDistributeDirectiveClass:
    $this().EmitOMPDistributeDirective(cast_OMPDistributeDirective($Deref(S)));
    break;
   case OMPTargetUpdateDirectiveClass:
    $this().EmitOMPTargetUpdateDirective(cast_OMPTargetUpdateDirective($Deref(S)));
    break;
   case OMPDistributeParallelForDirectiveClass:
    $this().EmitOMPDistributeParallelForDirective(cast_OMPDistributeParallelForDirective($Deref(S)));
    break;
   case OMPDistributeParallelForSimdDirectiveClass:
    $this().EmitOMPDistributeParallelForSimdDirective(cast_OMPDistributeParallelForSimdDirective($Deref(S)));
    break;
   case OMPDistributeSimdDirectiveClass:
    $this().EmitOMPDistributeSimdDirective(cast_OMPDistributeSimdDirective($Deref(S)));
    break;
   case OMPTargetParallelForSimdDirectiveClass:
    $this().EmitOMPTargetParallelForSimdDirective(cast_OMPTargetParallelForSimdDirective($Deref(S)));
    break;
  }
}


/// EmitSimpleStmt - Try to emit a "simple" statement which does not
/// necessarily require an insertion point or debug information; typically
/// because the statement amounts to a jump or a container of other
/// statements.
///
/// \return True if the statement was handled.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitSimpleStmt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp", line = 301,
 FQN="clang::CodeGen::CodeGenFunction::EmitSimpleStmt", NM="_ZN5clang7CodeGen15CodeGenFunction14EmitSimpleStmtEPKNS_4StmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction14EmitSimpleStmtEPKNS_4StmtE")
//</editor-fold>
public final boolean EmitSimpleStmt(/*const*/ Stmt /*P*/ S) {
  switch (S.getStmtClass()) {
   default:
    return false;
   case NullStmtClass:
    break;
   case CompoundStmtClass:
    $this().EmitCompoundStmt(cast_CompoundStmt($Deref(S)));
    break;
   case DeclStmtClass:
    $this().EmitDeclStmt(cast_DeclStmt($Deref(S)));
    break;
   case LabelStmtClass:
    $this().EmitLabelStmt(cast_LabelStmt($Deref(S)));
    break;
   case AttributedStmtClass:
    $this().EmitAttributedStmt(cast_AttributedStmt($Deref(S)));
    break;
   case GotoStmtClass:
    $this().EmitGotoStmt(cast_GotoStmt($Deref(S)));
    break;
   case BreakStmtClass:
    $this().EmitBreakStmt(cast_BreakStmt($Deref(S)));
    break;
   case ContinueStmtClass:
    $this().EmitContinueStmt(cast_ContinueStmt($Deref(S)));
    break;
   case DefaultStmtClass:
    $this().EmitDefaultStmt(cast_DefaultStmt($Deref(S)));
    break;
   case CaseStmtClass:
    $this().EmitCaseStmt(cast_CaseStmt($Deref(S)));
    break;
   case SEHLeaveStmtClass:
    $this().EmitSEHLeaveStmt(cast_SEHLeaveStmt($Deref(S)));
    break;
  }
  
  return true;
}


/// EmitCompoundStmt - Emit a compound statement {..} node.  If GetLast is true,
/// this captures the expression result of the last sub-statement and returns it
/// (for use by the statement expression extension).
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitCompoundStmt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp", line = 324,
 FQN="clang::CodeGen::CodeGenFunction::EmitCompoundStmt", NM="_ZN5clang7CodeGen15CodeGenFunction16EmitCompoundStmtERKNS_12CompoundStmtEbNS0_12AggValueSlotE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction16EmitCompoundStmtERKNS_12CompoundStmtEbNS0_12AggValueSlotE")
//</editor-fold>
public final Address EmitCompoundStmt(final /*const*/ CompoundStmt /*&*/ S) {
  return EmitCompoundStmt(S, false, 
                AggValueSlot.ignored());
}
public final Address EmitCompoundStmt(final /*const*/ CompoundStmt /*&*/ S, boolean GetLast/*= false*/) {
  return EmitCompoundStmt(S, GetLast, 
                AggValueSlot.ignored());
}
public final Address EmitCompoundStmt(final /*const*/ CompoundStmt /*&*/ S, boolean GetLast/*= false*/, 
                AggValueSlot AggSlot/*= AggValueSlot::ignored()*/) {
  PrettyStackTraceLoc CrashInfo = null;
  LexicalScope Scope = null;
  try {
    CrashInfo/*J*/= new PrettyStackTraceLoc($this().getContext().getSourceManager(), S.getLBracLoc(), 
        $("LLVM IR generation of compound statement ('{}')"));
    
    // Keep track of the current cleanup stack depth, including debug scopes.
    Scope/*J*/= new LexicalScope(/*Deref*/$this(), S.getSourceRange());
    
    return $this().EmitCompoundStmtWithoutScope(S, GetLast, new AggValueSlot(AggSlot));
  } finally {
    if (Scope != null) { Scope.$destroy(); }
    if (CrashInfo != null) { CrashInfo.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitCompoundStmtWithoutScope">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp", line = 335,
 FQN="clang::CodeGen::CodeGenFunction::EmitCompoundStmtWithoutScope", NM="_ZN5clang7CodeGen15CodeGenFunction28EmitCompoundStmtWithoutScopeERKNS_12CompoundStmtEbNS0_12AggValueSlotE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction28EmitCompoundStmtWithoutScopeERKNS_12CompoundStmtEbNS0_12AggValueSlotE")
//</editor-fold>
public final Address EmitCompoundStmtWithoutScope(final /*const*/ CompoundStmt /*&*/ S) {
  return EmitCompoundStmtWithoutScope(S, 
                            false, 
                            AggValueSlot.ignored());
}
public final Address EmitCompoundStmtWithoutScope(final /*const*/ CompoundStmt /*&*/ S, 
                            boolean GetLast/*= false*/) {
  return EmitCompoundStmtWithoutScope(S, 
                            GetLast, 
                            AggValueSlot.ignored());
}
public final Address EmitCompoundStmtWithoutScope(final /*const*/ CompoundStmt /*&*/ S, 
                            boolean GetLast/*= false*/, 
                            AggValueSlot AggSlot/*= AggValueSlot::ignored()*/) {
  
  for (type$ptr<Stmt /*P*/ /*const*/ /*P*/> I = $tryClone(S.body_begin$Const()), 
      /*P*/ /*const*/ /*P*/ E = $tryClone(S.body_end$Const().$sub((GetLast ? 1 : 0))); $noteq_ptr(I, E); I.$preInc())  {
    $this().EmitStmt(I.$star());
  }
  
  Address RetAlloca = Address.invalid();
  if (GetLast) {
    // We have to special case labels here.  They are statements, but when put
    // at the end of a statement expression, they yield the value of their
    // subexpression.  Handle this by walking through all labels we encounter,
    // emitting them before we evaluate the subexpr.
    /*const*/ Stmt /*P*/ LastStmt = S.body_back$Const();
    {
      /*const*/ LabelStmt /*P*/ LS;
      while (((/*P*/ LS = dyn_cast_LabelStmt(LastStmt)) != null)) {
        $this().EmitLabel(LS.getDecl());
        LastStmt = LS.getSubStmt$Const();
      }
    }
    
    $this().EnsureInsertPoint();
    
    QualType ExprTy = cast_Expr(LastStmt).getType();
    if (CodeGenFunction.hasAggregateEvaluationKind(new QualType(ExprTy))) {
      $this().EmitAggExpr(cast_Expr(LastStmt), new AggValueSlot(AggSlot));
    } else {
      // We can't return an RValue here because there might be cleanups at
      // the end of the StmtExpr.  Because of that, we have to emit the result
      // here into a temporary alloca.
      RetAlloca.$assignMove($this().CreateMemTemp(new QualType(ExprTy)));
      $this().EmitAnyExprToMem(cast_Expr(LastStmt), new Address(RetAlloca), new Qualifiers(), 
          /*IsInit*/ false);
    }
  }
  
  return RetAlloca;
}


/// EmitLabel - Emit the block for the given label. It is legal to call this
/// function even if there is no current insertion point.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitLabel">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp", line = 463,
 FQN="clang::CodeGen::CodeGenFunction::EmitLabel", NM="_ZN5clang7CodeGen15CodeGenFunction9EmitLabelEPKNS_9LabelDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction9EmitLabelEPKNS_9LabelDeclE")
//</editor-fold>
public final void EmitLabel(/*const*/ LabelDecl /*P*/ D) {
  // Add this label to the current lexical scope if we're within any
  // normal cleanups.  Jumps "in" to this label --- when permitted by
  // the language --- may need to be routed around such cleanups.
  if ($this().EHStack.hasNormalCleanups() && ($this().CurLexicalScope != null)) {
    $this().CurLexicalScope.addLabel(D);
  }
  
  final JumpDest /*&*/ Dest = $this().LabelMap.$at_T1$C$R(D);
  
  // If we didn't need a forward reference to this label, just go
  // ahead and create a destination at the current scope.
  if (!Dest.isValid()) {
    Dest.$assignMove($this().getJumpDestInCurrentScope(D.getName()));
    // Otherwise, we need to give this label a target depth and remove
    // it from the branch-fixups list.
  } else {
    assert (!Dest.getScopeDepth().isValid()) : "already emitted label!";
    Dest.setScopeDepth($this().EHStack.stable_begin());
    $this().ResolveBranchFixups(Dest.getBlock());
  }
  
  $this().EmitBlock(Dest.getBlock());
  $this().incrementProfileCounter(D.getStmt());
}

// helper for EmitLabelStmt.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitLabelStmt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp", line = 513,
 FQN="clang::CodeGen::CodeGenFunction::EmitLabelStmt", NM="_ZN5clang7CodeGen15CodeGenFunction13EmitLabelStmtERKNS_9LabelStmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction13EmitLabelStmtERKNS_9LabelStmtE")
//</editor-fold>
public final void EmitLabelStmt(final /*const*/ LabelStmt /*&*/ S) {
  $this().EmitLabel(S.getDecl());
  $this().EmitStmt(S.getSubStmt$Const());
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitAttributedStmt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp", line = 518,
 FQN="clang::CodeGen::CodeGenFunction::EmitAttributedStmt", NM="_ZN5clang7CodeGen15CodeGenFunction18EmitAttributedStmtERKNS_14AttributedStmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction18EmitAttributedStmtERKNS_14AttributedStmtE")
//</editor-fold>
public final void EmitAttributedStmt(final /*const*/ AttributedStmt /*&*/ S) {
  /*const*/ Stmt /*P*/ SubStmt = S.getSubStmt$Const();
  switch (SubStmt.getStmtClass()) {
   case DoStmtClass:
    $this().EmitDoStmt(cast_DoStmt($Deref(SubStmt)), S.getAttrs());
    break;
   case ForStmtClass:
    $this().EmitForStmt(cast_ForStmt($Deref(SubStmt)), S.getAttrs());
    break;
   case WhileStmtClass:
    $this().EmitWhileStmt(cast_WhileStmt($Deref(SubStmt)), S.getAttrs());
    break;
   case CXXForRangeStmtClass:
    $this().EmitCXXForRangeStmt(cast_CXXForRangeStmt($Deref(SubStmt)), S.getAttrs());
    break;
   default:
    $this().EmitStmt(SubStmt);
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitGotoStmt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp", line = 538,
 FQN="clang::CodeGen::CodeGenFunction::EmitGotoStmt", NM="_ZN5clang7CodeGen15CodeGenFunction12EmitGotoStmtERKNS_8GotoStmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction12EmitGotoStmtERKNS_8GotoStmtE")
//</editor-fold>
public final void EmitGotoStmt(final /*const*/ GotoStmt /*&*/ S) {
  // If this code is reachable then emit a stop point (if generating
  // debug info). We have to do this ourselves because we are on the
  // "simple" statement path.
  if ($this().HaveInsertPoint()) {
    $this().EmitStopPoint($AddrOf(S));
  }
  
  $this().EmitBranchThroughCleanup($this().getJumpDestForLabel(S.getLabel()));
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitIndirectGotoStmt">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp", line = 549,
 FQN="clang::CodeGen::CodeGenFunction::EmitIndirectGotoStmt", NM="_ZN5clang7CodeGen15CodeGenFunction20EmitIndirectGotoStmtERKNS_16IndirectGotoStmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction20EmitIndirectGotoStmtERKNS_16IndirectGotoStmtE")
//</editor-fold>
public final void EmitIndirectGotoStmt(final /*const*/ IndirectGotoStmt /*&*/ S) {
  {
    /*const*/ LabelDecl /*P*/ Target = S.getConstantTarget$Const();
    if ((Target != null)) {
      $this().EmitBranchThroughCleanup($this().getJumpDestForLabel(Target));
      return;
    }
  }
  
  // Ensure that we have an i8* for our PHI node.
  Value /*P*/ V = $this().Builder.CreateBitCast($this().EmitScalarExpr(S.getTarget$Const()), 
      Unnamed_field9.Int8PtrTy, new Twine(/*KEEP_STR*/"addr"));
  BasicBlock /*P*/ CurBB = $this().Builder.GetInsertBlock();
  
  // Get the basic block for the indirect goto.
  BasicBlock /*P*/ IndGotoBB = $this().GetIndirectGotoBlock();
  
  // The first instruction in the block has to be the PHI for the switch dest,
  // add an entry for this branch.
  cast_PHINode(IndGotoBB.begin().$star()).addIncoming(V, CurBB);
  
  $this().EmitBranch(IndGotoBB);
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitIfStmt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp", line = 570,
 FQN="clang::CodeGen::CodeGenFunction::EmitIfStmt", NM="_ZN5clang7CodeGen15CodeGenFunction10EmitIfStmtERKNS_6IfStmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction10EmitIfStmtERKNS_6IfStmtE")
//</editor-fold>
public final void EmitIfStmt(final /*const*/ IfStmt /*&*/ S) {
  LexicalScope ConditionScope = null;
  try {
    // C99 6.8.4.1: The first substatement is executed if the expression compares
    // unequal to 0.  The condition must be a scalar type.
    ConditionScope/*J*/= new LexicalScope(/*Deref*/$this(), S.getCond$Const().getSourceRange());
    if ((S.getInit$Const() != null)) {
      $this().EmitStmt(S.getInit$Const());
    }
    if ((S.getConditionVariable() != null)) {
      $this().EmitAutoVarDecl($Deref(S.getConditionVariable()));
    }
    
    // If the condition constant folds and can be elided, try to avoid emitting
    // the condition and the dead arm of the if/else.
    bool$ref CondConstant = create_bool$ref();
    if ($this().ConstantFoldsToSimpleInteger(S.getCond$Const(), CondConstant, 
        S.isConstexpr())) {
      // Figure out which block (then or else) is executed.
      type$ref</*const*/ Stmt /*P*/ > Executed = create_type$ref(S.getThen$Const());
      type$ref</*const*/ Stmt /*P*/ > Skipped = create_type$ref(S.getElse$Const());
      if (!CondConstant.$deref()) { // Condition false?
        std.swap(Executed, Skipped);
      }
      
      // If the skipped block has no labels in it, just emit the executed block.
      // This avoids emitting dead code and simplifies the CFG substantially.
      if (S.isConstexpr() || !CodeGenFunction.ContainsLabel(Skipped.$deref())) {
        if (CondConstant.$deref()) {
          $this().incrementProfileCounter($AddrOf(S));
        }
        if ((Executed.$deref() != null)) {
          RunCleanupsScope ExecutedScope = null;
          try {
            ExecutedScope/*J*/= new RunCleanupsScope(/*Deref*/$this());
            $this().EmitStmt(Executed.$deref());
          } finally {
            if (ExecutedScope != null) { ExecutedScope.$destroy(); }
          }
        }
        return;
      }
    }
    
    // Otherwise, the condition did not fold, or we couldn't elide it.  Just emit
    // the conditional branch.
    BasicBlock /*P*/ ThenBlock = $this().createBasicBlock(new Twine(/*KEEP_STR*/"if.then"));
    BasicBlock /*P*/ ContBlock = $this().createBasicBlock(new Twine(/*KEEP_STR*/"if.end"));
    BasicBlock /*P*/ ElseBlock = ContBlock;
    if ((S.getElse$Const() != null)) {
      ElseBlock = $this().createBasicBlock(new Twine(/*KEEP_STR*/"if.else"));
    }
    
    $this().EmitBranchOnBoolExpr(S.getCond$Const(), ThenBlock, ElseBlock, 
        $this().getProfileCount(S.getThen$Const()));
    
    // Emit the 'then' code.
    $this().EmitBlock(ThenBlock);
    $this().incrementProfileCounter($AddrOf(S));
    {
      RunCleanupsScope ThenScope = null;
      try {
        ThenScope/*J*/= new RunCleanupsScope(/*Deref*/$this());
        $this().EmitStmt(S.getThen$Const());
      } finally {
        if (ThenScope != null) { ThenScope.$destroy(); }
      }
    }
    $this().EmitBranch(ContBlock);
    {
      
      // Emit the 'else' code if present.
      /*const*/ Stmt /*P*/ Else = S.getElse$Const();
      if ((Else != null)) {
        {
          ApplyDebugLocation NL = null;
          try {
            // There is no need to emit line number for an unconditional branch.
            NL = ApplyDebugLocation.CreateEmpty(/*Deref*/$this());
            $this().EmitBlock(ElseBlock);
          } finally {
            if (NL != null) { NL.$destroy(); }
          }
        }
        {
          RunCleanupsScope ElseScope = null;
          try {
            ElseScope/*J*/= new RunCleanupsScope(/*Deref*/$this());
            $this().EmitStmt(Else);
          } finally {
            if (ElseScope != null) { ElseScope.$destroy(); }
          }
        }
        {
          ApplyDebugLocation NL = null;
          try {
            // There is no need to emit line number for an unconditional branch.
            NL = ApplyDebugLocation.CreateEmpty(/*Deref*/$this());
            $this().EmitBranch(ContBlock);
          } finally {
            if (NL != null) { NL.$destroy(); }
          }
        }
      }
    }
    
    // Emit the continuation block for code after the if.
    $this().EmitBlock(ContBlock, true);
  } finally {
    if (ConditionScope != null) { ConditionScope.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitWhileStmt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp", line = 647,
 FQN="clang::CodeGen::CodeGenFunction::EmitWhileStmt", NM="_ZN5clang7CodeGen15CodeGenFunction13EmitWhileStmtERKNS_9WhileStmtEN4llvm8ArrayRefIPKNS_4AttrEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction13EmitWhileStmtERKNS_9WhileStmtEN4llvm8ArrayRefIPKNS_4AttrEEE")
//</editor-fold>
public final void EmitWhileStmt(final /*const*/ WhileStmt /*&*/ S) {
  EmitWhileStmt(S, 
             new ArrayRef</*const*/ Attr /*P*/ >(None, true));
}
public final void EmitWhileStmt(final /*const*/ WhileStmt /*&*/ S, 
             ArrayRef</*const*/ Attr /*P*/ > WhileAttrs/*= None*/) {
  RunCleanupsScope ConditionScope = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    // Emit the header for the loop, which will also become
    // the continue target.
    JumpDest LoopHeader = $this().getJumpDestInCurrentScope(new StringRef(/*KEEP_STR*/"while.cond"));
    $this().EmitBlock(LoopHeader.getBlock());
    
    $this().LoopStack.push(LoopHeader.getBlock(), $this().CGM.getContext(), new ArrayRef</*const*/ Attr /*P*/ >(WhileAttrs), 
        $c$.track(new DebugLoc($this().Builder.getCurrentDebugLocation()))); $c$.clean();
    
    // Create an exit block for when the condition fails, which will
    // also become the break target.
    JumpDest LoopExit = $this().getJumpDestInCurrentScope(new StringRef(/*KEEP_STR*/"while.end"));
    
    // Store the blocks to use for break and continue.
    $this().BreakContinueStack.push_back(new BreakContinue(new JumpDest(LoopExit), new JumpDest(LoopHeader)));
    
    // C++ [stmt.while]p2:
    //   When the condition of a while statement is a declaration, the
    //   scope of the variable that is declared extends from its point
    //   of declaration (3.3.2) to the end of the while statement.
    //   [...]
    //   The object created in a condition is destroyed and created
    //   with each iteration of the loop.
    ConditionScope/*J*/= new RunCleanupsScope(/*Deref*/$this());
    if ((S.getConditionVariable() != null)) {
      $this().EmitAutoVarDecl($Deref(S.getConditionVariable()));
    }
    
    // Evaluate the conditional in the while header.  C99 6.8.5.1: The
    // evaluation of the controlling expression takes place before each
    // execution of the loop body.
    Value /*P*/ BoolCondVal = $this().EvaluateExprAsBool(S.getCond$Const());
    
    // while(1) is common, avoid extra exit blocks.  Be sure
    // to correctly handle break/continue though.
    boolean EmitBoolCondBranch = true;
    {
      ConstantInt /*P*/ C = dyn_cast_ConstantInt(BoolCondVal);
      if ((C != null)) {
        if (C.isOne()) {
          EmitBoolCondBranch = false;
        }
      }
    }
    
    // As long as the condition is true, go to the loop body.
    BasicBlock /*P*/ LoopBody = $this().createBasicBlock(new Twine(/*KEEP_STR*/"while.body"));
    if (EmitBoolCondBranch) {
      BasicBlock /*P*/ ExitBlock = LoopExit.getBlock();
      if (ConditionScope.requiresCleanups()) {
        ExitBlock = $this().createBasicBlock(new Twine(/*KEEP_STR*/"while.exit"));
      }
      $this().Builder.CreateCondBr(BoolCondVal, LoopBody, ExitBlock, 
          $this().createProfileWeightsForLoop(S.getCond$Const(), $this().getProfileCount(S.getBody$Const())));
      if (ExitBlock != LoopExit.getBlock()) {
        $this().EmitBlock(ExitBlock);
        $this().EmitBranchThroughCleanup(new JumpDest(LoopExit));
      }
    }
    {
      RunCleanupsScope BodyScope = null;
      try {
        BodyScope/*J*/= new RunCleanupsScope(/*Deref*/$this());
        $this().EmitBlock(LoopBody);
        $this().incrementProfileCounter($AddrOf(S));
        $this().EmitStmt(S.getBody$Const());
      } finally {
        if (BodyScope != null) { BodyScope.$destroy(); }
      }
    }
    
    $this().BreakContinueStack.pop_back();
    
    // Immediately force cleanup.
    ConditionScope.ForceCleanup();
    
    $this().EmitStopPoint($AddrOf(S));
    // Branch to the loop header again.
    $this().EmitBranch(LoopHeader.getBlock());
    
    $this().LoopStack.pop();
    
    // Emit the exit block.
    $this().EmitBlock(LoopExit.getBlock(), true);
    
    // The LoopHeader typically is just a branch if we skipped emitting
    // a branch, try to erase it.
    if (!EmitBoolCondBranch) {
      $this().SimplifyForwardingBlocks(LoopHeader.getBlock());
    }
  } finally {
    if (ConditionScope != null) { ConditionScope.$destroy(); }
    $c$.$destroy();
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitDoStmt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp", line = 733,
 FQN="clang::CodeGen::CodeGenFunction::EmitDoStmt", NM="_ZN5clang7CodeGen15CodeGenFunction10EmitDoStmtERKNS_6DoStmtEN4llvm8ArrayRefIPKNS_4AttrEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction10EmitDoStmtERKNS_6DoStmtEN4llvm8ArrayRefIPKNS_4AttrEEE")
//</editor-fold>
public final void EmitDoStmt(final /*const*/ DoStmt /*&*/ S) {
  EmitDoStmt(S, 
          new ArrayRef</*const*/ Attr /*P*/ >(None, true));
}
public final void EmitDoStmt(final /*const*/ DoStmt /*&*/ S, 
          ArrayRef</*const*/ Attr /*P*/ > DoAttrs/*= None*/) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    JumpDest LoopExit = $this().getJumpDestInCurrentScope(new StringRef(/*KEEP_STR*/"do.end"));
    JumpDest LoopCond = $this().getJumpDestInCurrentScope(new StringRef(/*KEEP_STR*/"do.cond"));
    
    long/*uint64_t*/ ParentCount = $this().getCurrentProfileCount();
    
    // Store the blocks to use for break and continue.
    $this().BreakContinueStack.push_back(new BreakContinue(new JumpDest(LoopExit), new JumpDest(LoopCond)));
    
    // Emit the body of the loop.
    BasicBlock /*P*/ LoopBody = $this().createBasicBlock(new Twine(/*KEEP_STR*/"do.body"));
    
    $this().LoopStack.push(LoopBody, $this().CGM.getContext(), new ArrayRef</*const*/ Attr /*P*/ >(DoAttrs), 
        $c$.track(new DebugLoc($this().Builder.getCurrentDebugLocation()))); $c$.clean();
    
    $this().EmitBlockWithFallThrough(LoopBody, $AddrOf(S));
    {
      RunCleanupsScope BodyScope = null;
      try {
        BodyScope/*J*/= new RunCleanupsScope(/*Deref*/$this());
        $this().EmitStmt(S.getBody$Const());
      } finally {
        if (BodyScope != null) { BodyScope.$destroy(); }
      }
    }
    
    $this().EmitBlock(LoopCond.getBlock());
    
    // C99 6.8.5.2: "The evaluation of the controlling expression takes place
    // after each execution of the loop body."
    
    // Evaluate the conditional in the while header.
    // C99 6.8.5p2/p4: The first substatement is executed if the expression
    // compares unequal to 0.  The condition must be a scalar type.
    Value /*P*/ BoolCondVal = $this().EvaluateExprAsBool(S.getCond$Const());
    
    $this().BreakContinueStack.pop_back();
    
    // "do {} while (0)" is common in macros, avoid extra blocks.  Be sure
    // to correctly handle break/continue though.
    boolean EmitBoolCondBranch = true;
    {
      ConstantInt /*P*/ C = dyn_cast_ConstantInt(BoolCondVal);
      if ((C != null)) {
        if (C.isZero()) {
          EmitBoolCondBranch = false;
        }
      }
    }
    
    // As long as the condition is true, iterate the loop.
    if (EmitBoolCondBranch) {
      long/*uint64_t*/ BackedgeCount = $this().getProfileCount(S.getBody$Const()) - ParentCount;
      $this().Builder.CreateCondBr(BoolCondVal, LoopBody, LoopExit.getBlock(), 
          $this().createProfileWeightsForLoop(S.getCond$Const(), BackedgeCount));
    }
    
    $this().LoopStack.pop();
    
    // Emit the exit block.
    $this().EmitBlock(LoopExit.getBlock());
    
    // The DoCond block typically is just a branch if we skipped
    // emitting a branch, try to erase it.
    if (!EmitBoolCondBranch) {
      $this().SimplifyForwardingBlocks(LoopCond.getBlock());
    }
  } finally {
    $c$.$destroy();
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitForStmt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp", line = 793,
 FQN="clang::CodeGen::CodeGenFunction::EmitForStmt", NM="_ZN5clang7CodeGen15CodeGenFunction11EmitForStmtERKNS_7ForStmtEN4llvm8ArrayRefIPKNS_4AttrEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction11EmitForStmtERKNS_7ForStmtEN4llvm8ArrayRefIPKNS_4AttrEEE")
//</editor-fold>
public final void EmitForStmt(final /*const*/ ForStmt /*&*/ S) {
  EmitForStmt(S, 
           new ArrayRef</*const*/ Attr /*P*/ >(None, true));
}
public final void EmitForStmt(final /*const*/ ForStmt /*&*/ S, 
           ArrayRef</*const*/ Attr /*P*/ > ForAttrs/*= None*/) {
  LexicalScope ForScope = null;
  DebugLoc DL = null;
  LexicalScope ConditionScope = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    JumpDest LoopExit = $this().getJumpDestInCurrentScope(new StringRef(/*KEEP_STR*/"for.end"));
    
    ForScope/*J*/= new LexicalScope(/*Deref*/$this(), S.getSourceRange());
    
    DL = new DebugLoc($this().Builder.getCurrentDebugLocation());
    
    // Evaluate the first part before the loop.
    if ((S.getInit$Const() != null)) {
      $this().EmitStmt(S.getInit$Const());
    }
    
    // Start the loop with a block that tests the condition.
    // If there's an increment, the continue scope will be overwritten
    // later.
    JumpDest Continue = $this().getJumpDestInCurrentScope(new StringRef(/*KEEP_STR*/"for.cond"));
    BasicBlock /*P*/ CondBlock = Continue.getBlock();
    $this().EmitBlock(CondBlock);
    
    $this().LoopStack.push(CondBlock, $this().CGM.getContext(), new ArrayRef</*const*/ Attr /*P*/ >(ForAttrs), $c$.track(new DebugLoc(DL))); $c$.clean();
    
    // If the for loop doesn't have an increment we can just use the
    // condition as the continue block.  Otherwise we'll need to create
    // a block for it (in the current scope, i.e. in the scope of the
    // condition), and that we will become our continue block.
    if ((S.getInc$Const() != null)) {
      Continue.$assignMove($this().getJumpDestInCurrentScope(new StringRef(/*KEEP_STR*/"for.inc")));
    }
    
    // Store the blocks to use for break and continue.
    $this().BreakContinueStack.push_back(new BreakContinue(new JumpDest(LoopExit), new JumpDest(Continue)));
    
    // Create a cleanup scope for the condition variable cleanups.
    ConditionScope/*J*/= new LexicalScope(/*Deref*/$this(), S.getSourceRange());
    if ((S.getCond$Const() != null)) {
      // If the for statement has a condition scope, emit the local variable
      // declaration.
      if ((S.getConditionVariable() != null)) {
        $this().EmitAutoVarDecl($Deref(S.getConditionVariable()));
      }
      
      BasicBlock /*P*/ ExitBlock = LoopExit.getBlock();
      // If there are any cleanups between here and the loop-exit scope,
      // create a block to stage a loop exit along.
      if (ForScope.requiresCleanups()) {
        ExitBlock = $this().createBasicBlock(new Twine(/*KEEP_STR*/"for.cond.cleanup"));
      }
      
      // As long as the condition is true, iterate the loop.
      BasicBlock /*P*/ ForBody = $this().createBasicBlock(new Twine(/*KEEP_STR*/"for.body"));
      
      // C99 6.8.5p2/p4: The first substatement is executed if the expression
      // compares unequal to 0.  The condition must be a scalar type.
      Value /*P*/ BoolCondVal = $this().EvaluateExprAsBool(S.getCond$Const());
      $this().Builder.CreateCondBr(BoolCondVal, ForBody, ExitBlock, 
          $this().createProfileWeightsForLoop(S.getCond$Const(), $this().getProfileCount(S.getBody$Const())));
      if (ExitBlock != LoopExit.getBlock()) {
        $this().EmitBlock(ExitBlock);
        $this().EmitBranchThroughCleanup(new JumpDest(LoopExit));
      }
      
      $this().EmitBlock(ForBody);
    } else {
      // Treat it as a non-zero constant.  Don't even create a new block for the
      // body, just fall into it.
    }
    $this().incrementProfileCounter($AddrOf(S));
    {
      RunCleanupsScope BodyScope = null;
      try {
        // Create a separate cleanup scope for the body, in case it is not
        // a compound statement.
        BodyScope/*J*/= new RunCleanupsScope(/*Deref*/$this());
        $this().EmitStmt(S.getBody$Const());
      } finally {
        if (BodyScope != null) { BodyScope.$destroy(); }
      }
    }
    
    // If there is an increment, emit it next.
    if ((S.getInc$Const() != null)) {
      $this().EmitBlock(Continue.getBlock());
      $this().EmitStmt(S.getInc$Const());
    }
    
    $this().BreakContinueStack.pop_back();
    
    ConditionScope.ForceCleanup_LexicalScope();
    
    $this().EmitStopPoint($AddrOf(S));
    $this().EmitBranch(CondBlock);
    
    ForScope.ForceCleanup_LexicalScope();
    
    $this().LoopStack.pop();
    
    // Emit the fall-through block.
    $this().EmitBlock(LoopExit.getBlock(), true);
  } finally {
    if (ConditionScope != null) { ConditionScope.$destroy(); }
    if (DL != null) { DL.$destroy(); }
    if (ForScope != null) { ForScope.$destroy(); }
    $c$.$destroy();
  }
}


/// EmitReturnStmt - Note that due to GCC extensions, this can have an operand
/// if the function returns void, or may be missing one if the function returns
/// non-void.  Fun stuff :).
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitReturnStmt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp", line = 981,
 FQN="clang::CodeGen::CodeGenFunction::EmitReturnStmt", NM="_ZN5clang7CodeGen15CodeGenFunction14EmitReturnStmtERKNS_10ReturnStmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction14EmitReturnStmtERKNS_10ReturnStmtE")
//</editor-fold>
public final void EmitReturnStmt(final /*const*/ ReturnStmt /*&*/ S) {
  RunCleanupsScope cleanupScope = null;
  try {
    // Returning from an outlined SEH helper is UB, and we already warn on it.
    if ($this().IsOutlinedSEHHelper) {
      $this().Builder.CreateUnreachable();
      $this().Builder.ClearInsertionPoint();
    }
    
    // Emit the result value, even if unused, to evalute the side effects.
    /*const*/ Expr /*P*/ RV = S.getRetValue$Const();
    
    // Treat block literals in a return expression as if they appeared
    // in their own scope.  This permits a small, easily-implemented
    // exception to our over-conservative rules about not jumping to
    // statements following block literals with non-trivial cleanups.
    cleanupScope/*J*/= new RunCleanupsScope(/*Deref*/$this());
    {
      /*const*/ ExprWithCleanups /*P*/ cleanups = dyn_cast_or_null_ExprWithCleanups(RV);
      if ((cleanups != null)) {
        $this().enterFullExpression(cleanups);
        RV = cleanups.getSubExpr$Const();
      }
    }
    
    // FIXME: Clean this up by using an LValue for ReturnTemp,
    // EmitStoreThroughLValue, and EmitAnyExpr.
    if ($this().getLangOpts().ElideConstructors
       && (S.getNRVOCandidate() != null) && S.getNRVOCandidate().isNRVOVariable()) {
      {
        // Apply the named return value optimization for this return statement,
        // which means doing nothing: the appropriate result has already been
        // constructed into the NRVO variable.
        
        // If there is an NRVO flag for this variable, set it to 1 into indicate
        // that the cleanup code should not destroy the variable.
        Value /*P*/ NRVOFlag = $this().NRVOFlags.$at_T1$RR(S.getNRVOCandidate());
        if ((NRVOFlag != null)) {
          $this().Builder.CreateFlagStore(($this().Builder.getTrue() != null), NRVOFlag);
        }
      }
    } else if (!$this().ReturnValue.isValid() || ((RV != null) && RV.getType().$arrow().isVoidType())) {
      // Make sure not to return anything, but evaluate the expression
      // for side effects.
      if ((RV != null)) {
        $this().EmitAnyExpr(RV);
      }
    } else if (!(RV != null)) {
      // Do nothing (return value is left uninitialized)
    } else if ($this().FnRetTy.$arrow().isReferenceType()) {
      // If this function returns a reference, take the address of the expression
      // rather than the value.
      RValue Result = $this().EmitReferenceBindingToExpr(RV);
      $this().Builder.CreateStore(Result.getScalarVal(), new Address($this().ReturnValue));
    } else {
      switch (CodeGenFunction.getEvaluationKind(RV.getType())) {
       case TEK_Scalar:
        $this().Builder.CreateStore($this().EmitScalarExpr(RV), new Address($this().ReturnValue));
        break;
       case TEK_Complex:
        $this().EmitComplexExprIntoLValue(RV, $this().MakeAddrLValue(new Address($this().ReturnValue), RV.getType()), 
            /*isInit*/ true);
        break;
       case TEK_Aggregate:
        $this().EmitAggExpr(RV, AggValueSlot.forAddr(new Address($this().ReturnValue), 
                new Qualifiers(), 
                AggValueSlot.IsDestructed_t.IsDestructed, 
                AggValueSlot.NeedsGCBarriers_t.DoesNotNeedGCBarriers, 
                AggValueSlot.IsAliased_t.IsNotAliased));
        break;
      }
    }
    
    ++$this().NumReturnExprs;
    if (!(RV != null) || RV.isEvaluatable($this().getContext())) {
      ++$this().NumSimpleReturnExprs;
    }
    
    cleanupScope.ForceCleanup();
    $this().EmitBranchThroughCleanup(new JumpDest($this().ReturnBlock));
  } finally {
    if (cleanupScope != null) { cleanupScope.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitDeclStmt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp", line = 1053,
 FQN="clang::CodeGen::CodeGenFunction::EmitDeclStmt", NM="_ZN5clang7CodeGen15CodeGenFunction12EmitDeclStmtERKNS_8DeclStmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction12EmitDeclStmtERKNS_8DeclStmtE")
//</editor-fold>
public final void EmitDeclStmt(final /*const*/ DeclStmt /*&*/ S) {
  // As long as debug info is modeled with instructions, we have to ensure we
  // have a place to insert here and write the stop point here.
  if ($this().HaveInsertPoint()) {
    $this().EmitStopPoint($AddrOf(S));
  }
  
  for (/*const*/ Decl /*P*/ I : S.decls$Const())  {
    $this().EmitDecl($Deref(I));
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitBreakStmt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp", line = 1063,
 FQN="clang::CodeGen::CodeGenFunction::EmitBreakStmt", NM="_ZN5clang7CodeGen15CodeGenFunction13EmitBreakStmtERKNS_9BreakStmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction13EmitBreakStmtERKNS_9BreakStmtE")
//</editor-fold>
public final void EmitBreakStmt(final /*const*/ BreakStmt /*&*/ S) {
  assert (!$this().BreakContinueStack.empty()) : "break stmt not in a loop or switch!";
  
  // If this code is reachable then emit a stop point (if generating
  // debug info). We have to do this ourselves because we are on the
  // "simple" statement path.
  if ($this().HaveInsertPoint()) {
    $this().EmitStopPoint($AddrOf(S));
  }
  
  $this().EmitBranchThroughCleanup(new JumpDest($this().BreakContinueStack.back().BreakBlock));
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitContinueStmt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp", line = 1075,
 FQN="clang::CodeGen::CodeGenFunction::EmitContinueStmt", NM="_ZN5clang7CodeGen15CodeGenFunction16EmitContinueStmtERKNS_12ContinueStmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction16EmitContinueStmtERKNS_12ContinueStmtE")
//</editor-fold>
public final void EmitContinueStmt(final /*const*/ ContinueStmt /*&*/ S) {
  assert (!$this().BreakContinueStack.empty()) : "continue stmt not in a loop!";
  
  // If this code is reachable then emit a stop point (if generating
  // debug info). We have to do this ourselves because we are on the
  // "simple" statement path.
  if ($this().HaveInsertPoint()) {
    $this().EmitStopPoint($AddrOf(S));
  }
  
  $this().EmitBranchThroughCleanup(new JumpDest($this().BreakContinueStack.back().ContinueBlock));
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitSwitchStmt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp", line = 1472,
 FQN="clang::CodeGen::CodeGenFunction::EmitSwitchStmt", NM="_ZN5clang7CodeGen15CodeGenFunction14EmitSwitchStmtERKNS_10SwitchStmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction14EmitSwitchStmtERKNS_10SwitchStmtE")
//</editor-fold>
public final void EmitSwitchStmt(final /*const*/ SwitchStmt /*&*/ S) {
  RunCleanupsScope ConditionScope = null;
  try {
    // Handle nested switch statements.
    SwitchInst /*P*/ SavedSwitchInsn = $this().SwitchInsn;
    SmallVectorULong /*P*/ SavedSwitchWeights = $this().SwitchWeights;
    BasicBlock /*P*/ SavedCRBlock = $this().CaseRangeBlock;
    
    // See if we can constant fold the condition of the switch and therefore only
    // emit the live case statement (if any) of the switch.
    APSInt ConstantCondValue/*J*/= new APSInt();
    if ($this().ConstantFoldsToSimpleInteger(S.getCond$Const(), ConstantCondValue)) {
      SmallVector</*const*/ Stmt /*P*/ > CaseStmts/*J*/= new SmallVector</*const*/ Stmt /*P*/ >(4, (/*const*/ Stmt /*P*/ )null);
      type$ref</*const*/ SwitchCase /*P*/ > Case = create_type$null$ref(null);
      if (CGStmtStatics.FindCaseStatementsForValue(S, ConstantCondValue, CaseStmts, 
          $this().getContext(), Case)) {
        RunCleanupsScope ExecutedScope = null;
        try {
          if ((Case.$deref() != null)) {
            $this().incrementProfileCounter(Case.$deref());
          }
          ExecutedScope/*J*/= new RunCleanupsScope(/*Deref*/$this());
          if ((S.getInit$Const() != null)) {
            $this().EmitStmt(S.getInit$Const());
          }
          
          // Emit the condition variable if needed inside the entire cleanup scope
          // used by this special case for constant folded switches.
          if ((S.getConditionVariable() != null)) {
            $this().EmitAutoVarDecl($Deref(S.getConditionVariable()));
          }
          
          // At this point, we are no longer "within" a switch instance, so
          // we can temporarily enforce this to ensure that any embedded case
          // statements are not emitted.
          $this().SwitchInsn = null;
          
          // Okay, we can dead code eliminate everything except this case.  Emit the
          // specified series of statements and we're good.
          for (/*uint*/int i = 0, e = CaseStmts.size(); i != e; ++i)  {
            $this().EmitStmt(CaseStmts.$at(i));
          }
          $this().incrementProfileCounter($AddrOf(S));
          
          // Now we want to restore the saved switch instance so that nested
          // switches continue to function properly
          $this().SwitchInsn = SavedSwitchInsn;
          
          return;
        } finally {
          if (ExecutedScope != null) { ExecutedScope.$destroy(); }
        }
      }
    }
    
    JumpDest SwitchExit = $this().getJumpDestInCurrentScope(new StringRef(/*KEEP_STR*/"sw.epilog"));
    
    ConditionScope/*J*/= new RunCleanupsScope(/*Deref*/$this());
    if ((S.getInit$Const() != null)) {
      $this().EmitStmt(S.getInit$Const());
    }
    if ((S.getConditionVariable() != null)) {
      $this().EmitAutoVarDecl($Deref(S.getConditionVariable()));
    }
    Value /*P*/ CondV = $this().EmitScalarExpr(S.getCond$Const());
    
    // Create basic block to hold stuff that comes after switch
    // statement. We also need to create a default block now so that
    // explicit case ranges tests can have a place to jump to on
    // failure.
    BasicBlock /*P*/ DefaultBlock = $this().createBasicBlock(new Twine(/*KEEP_STR*/"sw.default"));
    $this().SwitchInsn = $this().Builder.CreateSwitch(CondV, DefaultBlock);
    if ($this().PGO.haveRegionCounts()) {
      // Walk the SwitchCase list to find how many there are.
      long/*uint64_t*/ DefaultCount = $int2ulong(0);
      /*uint*/int NumCases = 0;
      for (/*const*/ SwitchCase /*P*/ Case = S.getSwitchCaseList$Const();
           (Case != null);
           Case = Case.getNextSwitchCase$Const()) {
        if (isa_DefaultStmt(Case)) {
          DefaultCount = $this().getProfileCount(Case);
        }
        NumCases += 1;
      }
      $this().SwitchWeights = new SmallVectorULong(16, (long/*uint64_t*/)0);
      $this().SwitchWeights.reserve(NumCases);
      // The default needs to be first. We store the edge count, so we already
      // know the right weight.
      $this().SwitchWeights.push_back(DefaultCount);
    }
    $this().CaseRangeBlock = DefaultBlock;
    
    // Clear the insertion point to indicate we are in unreachable code.
    $this().Builder.ClearInsertionPoint();
    
    // All break statements jump to NextBlock. If BreakContinueStack is non-empty
    // then reuse last ContinueBlock.
    JumpDest OuterContinue/*J*/= new JumpDest();
    if (!$this().BreakContinueStack.empty()) {
      OuterContinue.$assign($this().BreakContinueStack.back().ContinueBlock);
    }
    
    $this().BreakContinueStack.push_back(new BreakContinue(new JumpDest(SwitchExit), new JumpDest(OuterContinue)));
    
    // Emit switch body.
    $this().EmitStmt(S.getBody$Const());
    
    $this().BreakContinueStack.pop_back();
    
    // Update the default block in case explicit case range tests have
    // been chained on top.
    $this().SwitchInsn.setDefaultDest($this().CaseRangeBlock);
    
    // If a default was never emitted:
    if (!(DefaultBlock.getParent() != null)) {
      // If we have cleanups, emit the default block so that there's a
      // place to jump through the cleanups from.
      if (ConditionScope.requiresCleanups()) {
        $this().EmitBlock(DefaultBlock);
        // Otherwise, just forward the default block to the switch end.
      } else {
        DefaultBlock.replaceAllUsesWith(SwitchExit.getBlock());
        /*delete*/Destructors.$destroy((Destructors.ClassWithDestructor)DefaultBlock);
      }
    }
    
    ConditionScope.ForceCleanup();
    
    // Emit continuation.
    $this().EmitBlock(SwitchExit.getBlock(), true);
    $this().incrementProfileCounter($AddrOf(S));
    
    // If the switch has a condition wrapped by __builtin_unpredictable,
    // create metadata that specifies that the switch is unpredictable.
    // Don't bother if not optimizing because that metadata would not be used.
    /*const*/ CallExpr /*P*/ Call = dyn_cast_CallExpr(S.getCond$Const());
    if ((Call != null) && $2bits_uint2uint($this().CGM.getCodeGenOpts().OptimizationLevel) != 0) {
      /*const*/ FunctionDecl /*P*/ FD = dyn_cast_or_null_FunctionDecl(Call.getCalleeDecl$Const());
      if ((FD != null) && FD.getBuiltinID() == Builtin.ID.BI__builtin_unpredictable.getValue()) {
        MDBuilder MDHelper/*J*/= new MDBuilder($this().getLLVMContext());
        $this().SwitchInsn.setMetadata(LLVMContext.Unnamed_enum.MD_unpredictable.getValue(), 
            MDHelper.createUnpredictable());
      }
    }
    if (($this().SwitchWeights != null)) {
      assert ($this().SwitchWeights.size() == 1 + $this().SwitchInsn.getNumCases()) : "switch weights do not match switch cases";
      // If there's only one jump destination there's no sense weighting it.
      if ($greater_uint($this().SwitchWeights.size(), 1)) {
        $this().SwitchInsn.setMetadata(LLVMContext.Unnamed_enum.MD_prof.getValue(), 
            $this().createProfileWeights(new ArrayRefULong($Deref($this().SwitchWeights))));
      }
      /*delete*/Destructors.$destroy((Destructors.ClassWithDestructor)$this().SwitchWeights);
    }
    $this().SwitchInsn = SavedSwitchInsn;
    $this().SwitchWeights = SavedSwitchWeights;
    $this().CaseRangeBlock = SavedCRBlock;
  } finally {
    if (ConditionScope != null) { ConditionScope.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitDefaultStmt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp", line = 1251,
 FQN="clang::CodeGen::CodeGenFunction::EmitDefaultStmt", NM="_ZN5clang7CodeGen15CodeGenFunction15EmitDefaultStmtERKNS_11DefaultStmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction15EmitDefaultStmtERKNS_11DefaultStmtE")
//</editor-fold>
public final void EmitDefaultStmt(final /*const*/ DefaultStmt /*&*/ S) {
  // If there is no enclosing switch instance that we're aware of, then this
  // default statement can be elided. This situation only happens when we've
  // constant-folded the switch.
  if (!($this().SwitchInsn != null)) {
    $this().EmitStmt(S.getSubStmt$Const());
    return;
  }
  
  BasicBlock /*P*/ DefaultBlock = $this().SwitchInsn.getDefaultDest();
  assert (DefaultBlock.empty()) : "EmitDefaultStmt: Default block already defined?";
  
  $this().EmitBlockWithFallThrough(DefaultBlock, $AddrOf(S));
  
  $this().EmitStmt(S.getSubStmt$Const());
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitCaseStmt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp", line = 1168,
 FQN="clang::CodeGen::CodeGenFunction::EmitCaseStmt", NM="_ZN5clang7CodeGen15CodeGenFunction12EmitCaseStmtERKNS_8CaseStmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction12EmitCaseStmtERKNS_8CaseStmtE")
//</editor-fold>
public final void EmitCaseStmt(final /*const*/ CaseStmt /*&*/ S) {
  // If there is no enclosing switch instance that we're aware of, then this
  // case statement and its block can be elided.  This situation only happens
  // when we've constant-folded the switch, are emitting the constant case,
  // and part of the constant case includes another case statement.  For
  // instance: switch (4) { case 4: do { case 5: } while (1); }
  if (!($this().SwitchInsn != null)) {
    $this().EmitStmt(S.getSubStmt$Const());
    return;
  }
  
  // Handle case ranges.
  if ((S.getRHS$Const() != null)) {
    $this().EmitCaseStmtRange(S);
    return;
  }
  
  ConstantInt /*P*/ CaseVal = $this().Builder.getInt(S.getLHS$Const().EvaluateKnownConstInt($this().getContext()));
  
  // If the body of the case is just a 'break', try to not emit an empty block.
  // If we're profiling or we're not optimizing, leave the block in for better
  // debug and coverage analysis.
  if (!$this().CGM.getCodeGenOpts().hasProfileClangInstr()
     && $2bits_uint2uint($this().CGM.getCodeGenOpts().OptimizationLevel) > 0
     && isa_BreakStmt(S.getSubStmt$Const())) {
    JumpDest Block = new JumpDest($this().BreakContinueStack.back().BreakBlock);
    
    // Only do this optimization if there are no cleanups that need emitting.
    if ($this().isObviouslyBranchWithoutCleanups(new JumpDest(Block))) {
      if (($this().SwitchWeights != null)) {
        $this().SwitchWeights.push_back($this().getProfileCount($AddrOf(S)));
      }
      $this().SwitchInsn.addCase(CaseVal, Block.getBlock());
      
      // If there was a fallthrough into this case, make sure to redirect it to
      // the end of the switch as well.
      if (($this().Builder.GetInsertBlock() != null)) {
        $this().Builder.CreateBr(Block.getBlock());
        $this().Builder.ClearInsertionPoint();
      }
      return;
    }
  }
  
  BasicBlock /*P*/ CaseDest = $this().createBasicBlock(new Twine(/*KEEP_STR*/"sw.bb"));
  $this().EmitBlockWithFallThrough(CaseDest, $AddrOf(S));
  if (($this().SwitchWeights != null)) {
    $this().SwitchWeights.push_back($this().getProfileCount($AddrOf(S)));
  }
  $this().SwitchInsn.addCase(CaseVal, CaseDest);
  
  // Recursively emitting the statement is acceptable, but is not wonderful for
  // code where we have many case statements nested together, i.e.:
  //  case 1:
  //    case 2:
  //      case 3: etc.
  // Handling this recursively will create a new block for each case statement
  // that falls through to the next case which is IR intensive.  It also causes
  // deep recursion which can run into stack depth limitations.  Handle
  // sequential non-range case statements specially.
  /*const*/ CaseStmt /*P*/ CurCase = $AddrOf(S);
  /*const*/ CaseStmt /*P*/ NextCase = dyn_cast_CaseStmt(S.getSubStmt$Const());
  
  // Otherwise, iteratively add consecutive cases to this switch stmt.
  while ((NextCase != null) && NextCase.getRHS$Const() == null) {
    CurCase = NextCase;
    ConstantInt /*P*/ CaseVal$1 = $this().Builder.getInt(CurCase.getLHS$Const().EvaluateKnownConstInt($this().getContext()));
    if (($this().SwitchWeights != null)) {
      $this().SwitchWeights.push_back($this().getProfileCount(NextCase));
    }
    if ($this().CGM.getCodeGenOpts().hasProfileClangInstr()) {
      CaseDest = $this().createBasicBlock(new Twine(/*KEEP_STR*/"sw.bb"));
      $this().EmitBlockWithFallThrough(CaseDest, $AddrOf(S));
    }
    
    $this().SwitchInsn.addCase(CaseVal$1, CaseDest);
    NextCase = dyn_cast_CaseStmt(CurCase.getSubStmt$Const());
  }
  
  // Normal default recursion for non-cases.
  $this().EmitStmt(CurCase.getSubStmt$Const());
}


/// EmitCaseStmtRange - If case statement range is not too big then
/// add multiple cases to switch instruction, one for each value within
/// the range. If range is too big then emit "if" condition check.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitCaseStmtRange">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp", line = 1090,
 FQN="clang::CodeGen::CodeGenFunction::EmitCaseStmtRange", NM="_ZN5clang7CodeGen15CodeGenFunction17EmitCaseStmtRangeERKNS_8CaseStmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction17EmitCaseStmtRangeERKNS_8CaseStmtE")
//</editor-fold>
public final void EmitCaseStmtRange(final /*const*/ CaseStmt /*&*/ S) {
  assert ((S.getRHS$Const() != null)) : "Expected RHS value in CaseStmt";
  
  APSInt LHS = S.getLHS$Const().EvaluateKnownConstInt($this().getContext());
  APSInt RHS = S.getRHS$Const().EvaluateKnownConstInt($this().getContext());
  
  // Emit the code for this case. We do this first to make sure it is
  // properly chained from our predecessor before generating the
  // switch machinery to enter this block.
  BasicBlock /*P*/ CaseDest = $this().createBasicBlock(new Twine(/*KEEP_STR*/"sw.bb"));
  $this().EmitBlockWithFallThrough(CaseDest, $AddrOf(S));
  $this().EmitStmt(S.getSubStmt$Const());
  
  // If range is empty, do nothing.
  if (LHS.isSigned() ? RHS.slt(LHS) : RHS.ult(LHS)) {
    return;
  }
  
  APInt Range = new APInt(JD$Move.INSTANCE, RHS.$sub(LHS));
  // FIXME: parameters such as this should not be hardcoded.
  if (Range.ult(new APInt(JD$UInt_ULong.INSTANCE, Range.getBitWidth(), $int2ulong(64)))) {
    // Range is small enough to add multiple switch instruction cases.
    long/*uint64_t*/ Total = $this().getProfileCount($AddrOf(S));
    /*uint*/int NCases = $ullong2uint(Range.getZExtValue() + $int2ullong(1));
    // We only have one region counter for the entire set of cases here, so we
    // need to divide the weights evenly between the generated cases, ensuring
    // that the total weight is preserved. E.g., a weight of 5 over three cases
    // will be distributed as weights of 2, 2, and 1.
    long/*uint64_t*/ Weight = $div_ulong_uint(Total, NCases);
    long/*uint64_t*/ Rem = $rem_ulong_uint(Total, NCases);
    for (/*uint*/int I = 0; I != NCases; ++I) {
      if (($this().SwitchWeights != null)) {
        $this().SwitchWeights.push_back(Weight + $int2ullong(((Rem != 0) ? 1 : 0)));
      }
      if ((Rem != 0)) {
        Rem--;
      }
      $this().SwitchInsn.addCase($this().Builder.getInt(LHS), CaseDest);
      LHS.$postInc(0);
    }
    return;
  }
  
  // The range is too big. Emit "if" condition into a new block,
  // making sure to save and restore the current insertion point.
  BasicBlock /*P*/ RestoreBB = $this().Builder.GetInsertBlock();
  
  // Push this test onto the chain of range checks (which terminates
  // in the default basic block). The switch's default will be changed
  // to the top of this chain after switch emission is complete.
  BasicBlock /*P*/ FalseDest = $this().CaseRangeBlock;
  $this().CaseRangeBlock = $this().createBasicBlock(new Twine(/*KEEP_STR*/"sw.caserange"));
  
  $this().CurFn.getBasicBlockList().push_back($this().CaseRangeBlock);
  $this().Builder.SetInsertPoint($this().CaseRangeBlock);
  
  // Emit range check.
  Value /*P*/ Diff = $this().Builder.CreateSub($this().SwitchInsn.getCondition(), $this().Builder.getInt(LHS));
  Value /*P*/ Cond = $this().Builder.CreateICmpULE(Diff, $this().Builder.getInt(Range), new Twine(/*KEEP_STR*/"inbounds"));
  
  MDNode /*P*/ Weights = null;
  if (($this().SwitchWeights != null)) {
    long/*uint64_t*/ ThisCount = $this().getProfileCount($AddrOf(S));
    long/*uint64_t*/ DefaultCount = ($Deref($this().SwitchWeights)).$at(0);
    Weights = $this().createProfileWeights(ThisCount, DefaultCount);
    
    // Since we're chaining the switch default through each large case range, we
    // need to update the weight for the default, ie, the first case, to include
    // this case.
    (/*Deref*/$this().SwitchWeights).$set(0, (/*Deref*/$this().SwitchWeights).$at(0) + ThisCount);
  }
  $this().Builder.CreateCondBr(Cond, CaseDest, FalseDest, Weights);
  
  // Restore the appropriate insertion point.
  if ((RestoreBB != null)) {
    $this().Builder.SetInsertPoint(RestoreBB);
  } else {
    $this().Builder.ClearInsertionPoint();
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitAsmStmt">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp", line = 1791,
 FQN="clang::CodeGen::CodeGenFunction::EmitAsmStmt", NM="_ZN5clang7CodeGen15CodeGenFunction11EmitAsmStmtERKNS_7AsmStmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction11EmitAsmStmtERKNS_7AsmStmtE")
//</editor-fold>
public final void EmitAsmStmt(final /*const*/ AsmStmt /*&*/ S) {
  SmallVector<TargetInfo.ConstraintInfo> OutputConstraintInfos = null;
  SmallVector<TargetInfo.ConstraintInfo> InputConstraintInfos = null;
  std.vector<LValue> ResultRegDests = null;
  std.vector<QualType> ResultRegQualTys = null;
  std.vector<org.llvm.ir.Type /*P*/ > ResultRegTypes = null;
  std.vector<org.llvm.ir.Type /*P*/ > ResultTruncRegTypes = null;
  std.vector<org.llvm.ir.Type /*P*/ > ArgTypes = null;
  std.vector<Value /*P*/ > Args = null;
  std.vector<Value /*P*/ > InOutArgs = null;
  std.vector<org.llvm.ir.Type /*P*/ > InOutArgTypes = null;
  std.vector<Value /*P*/ > RegResults = null;
  try {
    // Assemble the final asm string.
    std.string AsmString = S.generateAsmString($this().getContext());
    
    // Get all the output and input constraints together.
    OutputConstraintInfos/*J*/= new SmallVector<TargetInfo.ConstraintInfo>(4, new TargetInfo.ConstraintInfo());
    InputConstraintInfos/*J*/= new SmallVector<TargetInfo.ConstraintInfo>(4, new TargetInfo.ConstraintInfo());
    
    for (/*uint*/int i = 0, e = S.getNumOutputs(); i != e; i++) {
      TargetInfo.ConstraintInfo Info = null;
      try {
        StringRef Name/*J*/= new StringRef();
        {
          /*const*/ GCCAsmStmt /*P*/ GAS = dyn_cast_GCCAsmStmt($AddrOf(S));
          if ((GAS != null)) {
            Name.$assignMove(GAS.getOutputName(i));
          }
        }
        Info/*J*/= new TargetInfo.ConstraintInfo(S.getOutputConstraint(i), new StringRef(Name));
        boolean IsValid = $this().getTarget().validateOutputConstraint(Info);
        ///*J:(void)*/IsValid;
        assert (IsValid) : "Failed to parse output constraint";
        OutputConstraintInfos.push_back_T$C$R(Info);
      } finally {
        if (Info != null) { Info.$destroy(); }
      }
    }
    
    for (/*uint*/int i = 0, e = S.getNumInputs(); i != e; i++) {
      TargetInfo.ConstraintInfo Info = null;
      try {
        StringRef Name/*J*/= new StringRef();
        {
          /*const*/ GCCAsmStmt /*P*/ GAS = dyn_cast_GCCAsmStmt($AddrOf(S));
          if ((GAS != null)) {
            Name.$assignMove(GAS.getInputName(i));
          }
        }
        Info/*J*/= new TargetInfo.ConstraintInfo(S.getInputConstraint(i), new StringRef(Name));
        boolean IsValid = $this().getTarget().validateInputConstraint(new MutableArrayRef<TargetInfo.ConstraintInfo>(OutputConstraintInfos, false), Info);
        assert (IsValid) : "Failed to parse input constraint";
        ///*J:(void)*/IsValid;
        InputConstraintInfos.push_back_T$C$R(Info);
      } finally {
        if (Info != null) { Info.$destroy(); }
      }
    }
    
    std.string Constraints/*J*/= new std.string();
    
    ResultRegDests/*J*/= new std.vector<LValue>(new LValue());
    ResultRegQualTys/*J*/= new std.vector<QualType>(new QualType());
    ResultRegTypes/*J*/= new std.vector<org.llvm.ir.Type /*P*/ >((org.llvm.ir.Type /*P*/ )null);
    ResultTruncRegTypes/*J*/= new std.vector<org.llvm.ir.Type /*P*/ >((org.llvm.ir.Type /*P*/ )null);
    ArgTypes/*J*/= new std.vector<org.llvm.ir.Type /*P*/ >((org.llvm.ir.Type /*P*/ )null);
    Args/*J*/= new std.vector<Value /*P*/ >((Value /*P*/ )null);
    
    // Keep track of inout constraints.
    std.string InOutConstraints/*J*/= new std.string();
    InOutArgs/*J*/= new std.vector<Value /*P*/ >((Value /*P*/ )null);
    InOutArgTypes/*J*/= new std.vector<org.llvm.ir.Type /*P*/ >((org.llvm.ir.Type /*P*/ )null);
    
    // An inline asm can be marked readonly if it meets the following conditions:
    //  - it doesn't have any sideeffects
    //  - it doesn't clobber memory
    //  - it doesn't return a value by-reference
    // It can be marked readnone if it doesn't have any input memory constraints
    // in addition to meeting the conditions listed above.
    boolean ReadOnly = true;
    boolean ReadNone = true;
    
    for (/*uint*/int i = 0, e = S.getNumOutputs(); i != e; i++) {
      final TargetInfo.ConstraintInfo /*&*/ Info = OutputConstraintInfos.$at(i);
      
      // Simplify the output constraint.
      std.string OutputConstraint/*J*/= S.getOutputConstraint(i).$string();
      OutputConstraint.$assignMove(SimplifyConstraint(OutputConstraint.c_str().$add(1), 
              $this().getTarget()));
      
      /*const*/ Expr /*P*/ OutExpr = S.getOutputExpr(i);
      OutExpr = OutExpr.IgnoreParenNoopCasts$Const($this().getContext());
      
      OutputConstraint.$assignMove(AddVariableConstraints(OutputConstraint, $Deref(OutExpr), 
              $this().getTarget(), $this().CGM, S, 
              Info.earlyClobber()));
      
      LValue Dest = $this().EmitLValue(OutExpr);
      if (!Constraints.empty()) {
        Constraints.$addassign_T($$COMMA);
      }
      
      // If this is a register output, then make the inline asm return it
      // by-value.  If this is a memory result, return the value by-reference.
      if (!Info.allowsMemory() && CodeGenFunction.hasScalarEvaluationKind(OutExpr.getType())) {
        Constraints.$addassign($add_T$C$P_string$C(/*KEEP_STR*/"=", OutputConstraint));
        ResultRegQualTys.push_back_T$RR(OutExpr.getType());
        ResultRegDests.push_back_T$C$R(Dest);
        ResultRegTypes.push_back_T$RR($this().ConvertTypeForMem(OutExpr.getType()));
        ResultTruncRegTypes.push_back_T$C$R(ResultRegTypes.back());
        
        // If this output is tied to an input, and if the input is larger, then
        // we need to set the actual result type of the inline asm node to be the
        // same as the input type.
        if (Info.hasMatchingInput()) {
          /*uint*/int InputNo;
          for (InputNo = 0; InputNo != S.getNumInputs(); ++InputNo) {
            final TargetInfo.ConstraintInfo /*&*/ Input = InputConstraintInfos.$at(InputNo);
            if (Input.hasTiedOperand() && Input.getTiedOperand() == i) {
              break;
            }
          }
          assert (InputNo != S.getNumInputs()) : "Didn't find matching input!";
          
          QualType InputTy = S.getInputExpr(InputNo).getType();
          QualType OutputType = OutExpr.getType();
          
          long/*uint64_t*/ InputSize = $this().getContext().getTypeSize(new QualType(InputTy));
          if ($less_ulong($this().getContext().getTypeSize(new QualType(OutputType)), InputSize)) {
            // Form the asm to return the value as a larger integer or fp type.
            ResultRegTypes.push_back($this().ConvertType(new QualType(InputTy)));
          }
        }
        {
          org.llvm.ir.Type /*P*/ AdjTy = $this().getTargetHooks().adjustInlineAsmType(/*Deref*/$this(), new StringRef(OutputConstraint), 
              ResultRegTypes.back());
          if ((AdjTy != null)) {
            ResultRegTypes.push_back(AdjTy);
          } else {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_QualType($c$.track($this().CGM.getDiags().Report(S.getAsmLoc(), 
                          diag.err_asm_invalid_type_in_input)), 
                      OutExpr.getType()), new StringRef(OutputConstraint)));
            } finally {
              $c$.$destroy();
            }
          }
        }
      } else {
        ArgTypes.push_back_T$RR(Dest.getAddress().getType());
        Args.push_back_T$RR(Dest.getPointer());
        Constraints.$addassign_T$C$P(/*KEEP_STR*/"=*");
        Constraints.$addassign(OutputConstraint);
        ReadOnly = ReadNone = false;
      }
      if (Info.isReadWrite()) {
        InOutConstraints.$addassign_T($$COMMA);
        
        /*const*/ Expr /*P*/ InputExpr = S.getOutputExpr(i);
        Value /*P*/ Arg = $this().EmitAsmInputLValue(Info, new LValue(Dest), InputExpr.getType(), 
            InOutConstraints, 
            InputExpr.getExprLoc());
        {
          
          org.llvm.ir.Type /*P*/ AdjTy = $this().getTargetHooks().adjustInlineAsmType(/*Deref*/$this(), new StringRef(OutputConstraint), 
              Arg.getType());
          if ((AdjTy != null)) {
            Arg = $this().Builder.CreateBitCast(Arg, AdjTy);
          }
        }
        if (Info.allowsRegister()) {
          InOutConstraints.$addassign(llvm.utostr($uint2ulong(i)));
        } else {
          InOutConstraints.$addassign(OutputConstraint);
        }
        
        InOutArgTypes.push_back_T$RR(Arg.getType());
        InOutArgs.push_back_T$C$R(Arg);
      }
    }
    
    // If this is a Microsoft-style asm blob, store the return registers (EAX:EDX)
    // to the return value slot. Only do this when returning in registers.
    if (isa_MSAsmStmt($AddrOf(S))) {
      final /*const*/ ABIArgInfo /*&*/ RetAI = $this().CurFnInfo.getReturnInfo$Const();
      if (RetAI.isDirect() || RetAI.isExtend()) {
        // Make a fake lvalue for the return value slot.
        LValue ReturnSlot = $this().MakeAddrLValue(new Address($this().ReturnValue), new QualType($this().FnRetTy));
        $this().CGM.getTargetCodeGenInfo().addReturnRegisterOutputs(/*Deref*/$this(), new LValue(ReturnSlot), Constraints, ResultRegTypes, ResultTruncRegTypes, 
            ResultRegDests, AsmString, S.getNumOutputs());
        $this().SawAsmBlock = true;
      }
    }
    
    for (/*uint*/int i = 0, e = S.getNumInputs(); i != e; i++) {
      /*const*/ Expr /*P*/ InputExpr = S.getInputExpr(i);
      
      final TargetInfo.ConstraintInfo /*&*/ Info = InputConstraintInfos.$at(i);
      if (Info.allowsMemory()) {
        ReadNone = false;
      }
      if (!Constraints.empty()) {
        Constraints.$addassign_T($$COMMA);
      }
      
      // Simplify the input constraint.
      std.string InputConstraint/*J*/= S.getInputConstraint(i).$string();
      InputConstraint.$assignMove(SimplifyConstraint(InputConstraint.c_str(), $this().getTarget(), 
              $AddrOf(OutputConstraintInfos)));
      
      InputConstraint.$assignMove(AddVariableConstraints(InputConstraint, $Deref(InputExpr.IgnoreParenNoopCasts$Const($this().getContext())), 
              $this().getTarget(), $this().CGM, S, false/* No EarlyClobber */));
      
      Value /*P*/ Arg = $this().EmitAsmInput(Info, InputExpr, Constraints);
      
      // If this input argument is tied to a larger output result, extend the
      // input to be the same size as the output.  The LLVM backend wants to see
      // the input and output of a matching constraint be the same size.  Note
      // that GCC does not define what the top bits are here.  We use zext because
      // that is usually cheaper, but LLVM IR should really get an anyext someday.
      if (Info.hasTiedOperand()) {
        /*uint*/int Output = Info.getTiedOperand();
        QualType OutputType = S.getOutputExpr(Output).getType();
        QualType InputTy = InputExpr.getType();
        if ($greater_ulong($this().getContext().getTypeSize(new QualType(OutputType))
          , $this().getContext().getTypeSize(new QualType(InputTy)))) {
          // Use ptrtoint as appropriate so that we can do our extension.
          if (isa_PointerType(Arg.getType())) {
            Arg = $this().Builder.CreatePtrToInt(Arg, Unnamed_field8.IntPtrTy);
          }
          org.llvm.ir.Type /*P*/ OutputTy = $this().ConvertType(new QualType(OutputType));
          if (isa_IntegerType(OutputTy)) {
            Arg = $this().Builder.CreateZExt(Arg, OutputTy);
          } else if (isa_PointerType(OutputTy)) {
            Arg = $this().Builder.CreateZExt(Arg, Unnamed_field8.IntPtrTy);
          } else {
            assert (OutputTy.isFloatingPointTy()) : "Unexpected output type";
            Arg = $this().Builder.CreateFPExt(Arg, OutputTy);
          }
        }
      }
      {
        org.llvm.ir.Type /*P*/ AdjTy = $this().getTargetHooks().adjustInlineAsmType(/*Deref*/$this(), new StringRef(InputConstraint), 
            Arg.getType());
        if ((AdjTy != null)) {
          Arg = $this().Builder.CreateBitCast(Arg, AdjTy);
        } else {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_QualType($c$.track($this().CGM.getDiags().Report(S.getAsmLoc(), diag.err_asm_invalid_type_in_input)), 
                    InputExpr.getType()), new StringRef(InputConstraint)));
          } finally {
            $c$.$destroy();
          }
        }
      }
      
      ArgTypes.push_back_T$RR(Arg.getType());
      Args.push_back_T$C$R(Arg);
      Constraints.$addassign(InputConstraint);
    }
    
    // Append the "input" part of inout constraints last.
    for (/*uint*/int i = 0, e = InOutArgs.size(); i != e; i++) {
      ArgTypes.push_back_T$C$R(InOutArgTypes.$at(i));
      Args.push_back_T$C$R(InOutArgs.$at(i));
    }
    Constraints.$addassign(InOutConstraints);
    
    // Clobbers
    for (/*uint*/int i = 0, e = S.getNumClobbers(); i != e; i++) {
      StringRef Clobber = S.getClobber(i);
      if ($eq_StringRef(/*NO_COPY*/Clobber, /*STRINGREF_STR*/"memory")) {
        ReadOnly = ReadNone = false;
      } else if ($noteq_StringRef(/*NO_COPY*/Clobber, /*STRINGREF_STR*/"cc")) {
        Clobber.$assignMove($this().getTarget().getNormalizedGCCRegisterName(new StringRef(Clobber)));
      }
      if (!Constraints.empty()) {
        Constraints.$addassign_T($$COMMA);
      }
      
      Constraints.$addassign_T$C$P(/*KEEP_STR*/"~{");
      $addassign_string_StringRef(Constraints, /*NO_COPY*/Clobber);
      Constraints.$addassign_T($$RCURLY);
    }
    
    // Add machine specific clobbers
    std.string MachineClobbers = new std.string(JD$T$C$P_T2$C$R.INSTANCE, $this().getTarget().getClobbers());
    if (!MachineClobbers.empty()) {
      if (!Constraints.empty()) {
        Constraints.$addassign_T($$COMMA);
      }
      Constraints.$addassign(MachineClobbers);
    }
    
    org.llvm.ir.Type /*P*/ ResultType;
    if (ResultRegTypes.empty()) {
      ResultType = VoidTy;
    } else if (ResultRegTypes.size() == 1) {
      ResultType = ResultRegTypes.$at(0);
    } else {
      ResultType = StructType.get($this().getLLVMContext(), new ArrayRef<org.llvm.ir.Type /*P*/ >(ResultRegTypes, true));
    }
    
    org.llvm.ir.FunctionType /*P*/ FTy = org.llvm.ir.FunctionType.get(ResultType, new ArrayRef<org.llvm.ir.Type /*P*/ >(ArgTypes, true), false);
    
    boolean HasSideEffect = S.isVolatile() || S.getNumOutputs() == 0;
    InlineAsm.AsmDialect AsmDialect = isa_MSAsmStmt($AddrOf(S)) ? InlineAsm.AsmDialect.AD_Intel : InlineAsm.AsmDialect.AD_ATT;
    InlineAsm /*P*/ IA = InlineAsm.get(FTy, new StringRef(AsmString), new StringRef(Constraints), HasSideEffect, 
        /* IsAlignStack */ false, AsmDialect);
    CallInst /*P*/ Result = $this().Builder.CreateCall_Value$P_ArrayRef$Value$P_Twine$C_MDNode$P(IA, new ArrayRef<Value /*P*/ >(Args, true));
    Result.addAttribute(AttributeSet.AttrIndex.FunctionIndex.getValue(), 
        Attribute.AttrKind.NoUnwind);
    if (isa_MSAsmStmt($AddrOf(S))) {
      // If the assembly contains any labels, mark the call noduplicate to prevent
      // defining the same ASM label twice (PR23715). This is pretty hacky, but it
      // works.
      if (AsmString.find_T$C$P_size_type$_CharT(/*KEEP_STR*/"__MSASMLABEL_") != std.string.npos) {
        Result.addAttribute(AttributeSet.AttrIndex.FunctionIndex.getValue(), 
            Attribute.AttrKind.NoDuplicate);
      }
    }
    
    // Attach readnone and readonly attributes.
    if (!HasSideEffect) {
      if (ReadNone) {
        Result.addAttribute(AttributeSet.AttrIndex.FunctionIndex.getValue(), 
            Attribute.AttrKind.ReadNone);
      } else if (ReadOnly) {
        Result.addAttribute(AttributeSet.AttrIndex.FunctionIndex.getValue(), 
            Attribute.AttrKind.ReadOnly);
      }
    }
    {
      
      // Slap the source location of the inline asm into a !srcloc metadata on the
      // call.
      /*const*/ GCCAsmStmt /*P*/ gccAsmStmt = dyn_cast_GCCAsmStmt($AddrOf(S));
      if ((gccAsmStmt != null)) {
        Result.setMetadata(new StringRef(/*KEEP_STR*/"srcloc"), CGStmtStatics.getAsmSrcLocInfo(gccAsmStmt.getAsmString$Const(), 
                /*Deref*/$this()));
      } else {
        // At least put the line number on MS inline asm blobs.
        ConstantInt /*P*/ Loc = ConstantInt.get(Int32Ty, $uint2ulong(S.getAsmLoc().getRawEncoding()));
        Result.setMetadata(new StringRef(/*KEEP_STR*/"srcloc"), 
            MDNode.get($this().getLLVMContext(), 
                new ArrayRef<Metadata /*P*/ >(ConstantAsMetadata.get(Loc), true)));
      }
    }
    if ($this().getLangOpts().CUDA && $this().getLangOpts().CUDAIsDevice) {
      // Conservatively, mark all inline asm blocks in CUDA as convergent
      // (meaning, they may call an intrinsically convergent op, such as bar.sync,
      // and so can't have certain optimizations applied around them).
      Result.addAttribute(AttributeSet.AttrIndex.FunctionIndex.getValue(), 
          Attribute.AttrKind.Convergent);
    }
    
    // Extract all of the register value results from the asm.
    RegResults/*J*/= new std.vector<Value /*P*/ >((Value /*P*/ )null);
    if (ResultRegTypes.size() == 1) {
      RegResults.push_back_T$RR(Result);
    } else {
      for (/*uint*/int i = 0, e = ResultRegTypes.size(); i != e; ++i) {
        Value /*P*/ Tmp = $this().Builder.CreateExtractValue(Result, new ArrayRefUInt(i), new Twine(/*KEEP_STR*/"asmresult"));
        RegResults.push_back_T$C$R(Tmp);
      }
    }
    assert (RegResults.size() == ResultRegTypes.size());
    assert (RegResults.size() == ResultTruncRegTypes.size());
    assert (RegResults.size() == ResultRegDests.size());
    for (/*uint*/int i = 0, e = RegResults.size(); i != e; ++i) {
      Value /*P*/ Tmp = RegResults.$at(i);
      
      // If the result type of the LLVM IR asm doesn't match the result type of
      // the expression, do the conversion.
      if (ResultRegTypes.$at(i) != ResultTruncRegTypes.$at(i)) {
        org.llvm.ir.Type /*P*/ TruncTy = ResultTruncRegTypes.$at(i);
        
        // Truncate the integer result to the right size, note that TruncTy can be
        // a pointer.
        if (TruncTy.isFloatingPointTy()) {
          Tmp = $this().Builder.CreateFPTrunc(Tmp, TruncTy);
        } else if (TruncTy.isPointerTy() && Tmp.getType().isIntegerTy()) {
          long/*uint64_t*/ ResSize = $this().CGM.getDataLayout().getTypeSizeInBits(TruncTy);
          Tmp = $this().Builder.CreateTrunc(Tmp, 
              IntegerType.get($this().getLLVMContext(), (/*uint*/int)$ulong2uint(ResSize)));
          Tmp = $this().Builder.CreateIntToPtr(Tmp, TruncTy);
        } else if (Tmp.getType().isPointerTy() && TruncTy.isIntegerTy()) {
          long/*uint64_t*/ TmpSize = $this().CGM.getDataLayout().getTypeSizeInBits(Tmp.getType());
          Tmp = $this().Builder.CreatePtrToInt(Tmp, 
              IntegerType.get($this().getLLVMContext(), (/*uint*/int)$ulong2uint(TmpSize)));
          Tmp = $this().Builder.CreateTrunc(Tmp, TruncTy);
        } else if (TruncTy.isIntegerTy()) {
          Tmp = $this().Builder.CreateTrunc(Tmp, TruncTy);
        } else if (TruncTy.isVectorTy()) {
          Tmp = $this().Builder.CreateBitCast(Tmp, TruncTy);
        }
      }
      
      $this().EmitStoreThroughLValue(RValue.get(Tmp), new LValue(ResultRegDests.$at(i)));
    }
  } finally {
    if (RegResults != null) { RegResults.$destroy(); }
    if (InOutArgTypes != null) { InOutArgTypes.$destroy(); }
    if (InOutArgs != null) { InOutArgs.$destroy(); }
    if (Args != null) { Args.$destroy(); }
    if (ArgTypes != null) { ArgTypes.$destroy(); }
    if (ResultTruncRegTypes != null) { ResultTruncRegTypes.$destroy(); }
    if (ResultRegTypes != null) { ResultRegTypes.$destroy(); }
    if (ResultRegQualTys != null) { ResultRegQualTys.$destroy(); }
    if (ResultRegDests != null) { ResultRegDests.$destroy(); }
    if (InputConstraintInfos != null) { InputConstraintInfos.$destroy(); }
    if (OutputConstraintInfos != null) { OutputConstraintInfos.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitCXXForRangeStmt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp", line = 890,
 FQN="clang::CodeGen::CodeGenFunction::EmitCXXForRangeStmt", NM="_ZN5clang7CodeGen15CodeGenFunction19EmitCXXForRangeStmtERKNS_15CXXForRangeStmtEN4llvm8ArrayRefIPKNS_4AttrEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction19EmitCXXForRangeStmtERKNS_15CXXForRangeStmtEN4llvm8ArrayRefIPKNS_4AttrEEE")
//</editor-fold>
public final void EmitCXXForRangeStmt(final /*const*/ CXXForRangeStmt /*&*/ S) {
  EmitCXXForRangeStmt(S, 
                   new ArrayRef</*const*/ Attr /*P*/ >(None, true));
}
public final void EmitCXXForRangeStmt(final /*const*/ CXXForRangeStmt /*&*/ S, 
                   ArrayRef</*const*/ Attr /*P*/ > ForAttrs/*= None*/) {
  LexicalScope ForScope = null;
  DebugLoc DL = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    JumpDest LoopExit = $this().getJumpDestInCurrentScope(new StringRef(/*KEEP_STR*/"for.end"));
    
    ForScope/*J*/= new LexicalScope(/*Deref*/$this(), S.getSourceRange());
    
    DL = new DebugLoc($this().Builder.getCurrentDebugLocation());
    
    // Evaluate the first pieces before the loop.
    $this().EmitStmt(S.getRangeStmt$Const());
    $this().EmitStmt(S.getBeginStmt$Const());
    $this().EmitStmt(S.getEndStmt$Const());
    
    // Start the loop with a block that tests the condition.
    // If there's an increment, the continue scope will be overwritten
    // later.
    BasicBlock /*P*/ CondBlock = $this().createBasicBlock(new Twine(/*KEEP_STR*/"for.cond"));
    $this().EmitBlock(CondBlock);
    
    $this().LoopStack.push(CondBlock, $this().CGM.getContext(), new ArrayRef</*const*/ Attr /*P*/ >(ForAttrs), $c$.track(new DebugLoc(DL))); $c$.clean();
    
    // If there are any cleanups between here and the loop-exit scope,
    // create a block to stage a loop exit along.
    BasicBlock /*P*/ ExitBlock = LoopExit.getBlock();
    if (ForScope.requiresCleanups()) {
      ExitBlock = $this().createBasicBlock(new Twine(/*KEEP_STR*/"for.cond.cleanup"));
    }
    
    // The loop body, consisting of the specified body and the loop variable.
    BasicBlock /*P*/ ForBody = $this().createBasicBlock(new Twine(/*KEEP_STR*/"for.body"));
    
    // The body is executed if the expression, contextually converted
    // to bool, is true.
    Value /*P*/ BoolCondVal = $this().EvaluateExprAsBool(S.getCond$Const());
    $this().Builder.CreateCondBr(BoolCondVal, ForBody, ExitBlock, 
        $this().createProfileWeightsForLoop(S.getCond$Const(), $this().getProfileCount(S.getBody$Const())));
    if (ExitBlock != LoopExit.getBlock()) {
      $this().EmitBlock(ExitBlock);
      $this().EmitBranchThroughCleanup(new JumpDest(LoopExit));
    }
    
    $this().EmitBlock(ForBody);
    $this().incrementProfileCounter($AddrOf(S));
    
    // Create a block for the increment. In case of a 'continue', we jump there.
    JumpDest Continue = $this().getJumpDestInCurrentScope(new StringRef(/*KEEP_STR*/"for.inc"));
    
    // Store the blocks to use for break and continue.
    $this().BreakContinueStack.push_back(new BreakContinue(new JumpDest(LoopExit), new JumpDest(Continue)));
    {
      LexicalScope BodyScope = null;
      try {
        // Create a separate cleanup scope for the loop variable and body.
        BodyScope/*J*/= new LexicalScope(/*Deref*/$this(), S.getSourceRange());
        $this().EmitStmt(S.getLoopVarStmt$Const());
        $this().EmitStmt(S.getBody$Const());
      } finally {
        if (BodyScope != null) { BodyScope.$destroy(); }
      }
    }
    
    $this().EmitStopPoint($AddrOf(S));
    // If there is an increment, emit it next.
    $this().EmitBlock(Continue.getBlock());
    $this().EmitStmt(S.getInc$Const());
    
    $this().BreakContinueStack.pop_back();
    
    $this().EmitBranch(CondBlock);
    
    ForScope.ForceCleanup_LexicalScope();
    
    $this().LoopStack.pop();
    
    // Emit the fall-through block.
    $this().EmitBlock(LoopExit.getBlock(), true);
  } finally {
    if (DL != null) { DL.$destroy(); }
    if (ForScope != null) { ForScope.$destroy(); }
    $c$.$destroy();
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::InitCapturedStruct">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp", line = 2146,
 FQN="clang::CodeGen::CodeGenFunction::InitCapturedStruct", NM="_ZN5clang7CodeGen15CodeGenFunction18InitCapturedStructERKNS_12CapturedStmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction18InitCapturedStructERKNS_12CapturedStmtE")
//</editor-fold>
public final LValue InitCapturedStruct(final /*const*/ CapturedStmt /*&*/ S) {
  /*const*/ RecordDecl /*P*/ RD = S.getCapturedRecordDecl();
  QualType RecordTy = $this().getContext().getRecordType(RD);
  
  // Initialize the captured struct.
  LValue SlotLV = $this().MakeAddrLValue($this().CreateMemTemp(new QualType(RecordTy), new Twine(/*KEEP_STR*/"agg.captured")), new QualType(RecordTy));
  
  DeclContext.specific_decl_iterator<FieldDecl> CurField = RD.field_begin();
  for (type$ptr<Expr /*P*/ /*const*/ /*P*/> I = $tryClone(S.capture_init_begin$Const()), 
      /*P*/ /*const*/ /*P*/ E = $tryClone(S.capture_init_end$Const());
       $noteq_ptr(I, E); I.$preInc() , CurField.$preInc()) {
    LValue LV = $this().EmitLValueForFieldInitialization(new LValue(SlotLV), CurField.$star());
    if (CurField.$arrow().hasCapturedVLAType()) {
      /*const*/ VariableArrayType /*P*/ VAT = CurField.$arrow().getCapturedVLAType();
      $this().EmitStoreThroughLValue(RValue.get($this().VLASizeMap.$at_T1$RR(VAT.getSizeExpr())), new LValue(LV));
    } else {
      $this().EmitInitializerForField(CurField.$star(), new LValue(LV), I.$star(), new ArrayRef<VarDecl /*P*/ >(None, true));
    }
  }
  
  return SlotLV;
}


/// Generate an outlined function for the body of a CapturedStmt, store any
/// captured variables into the captured struct, and call the outlined function.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitCapturedStmt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp", line = 2172,
 FQN="clang::CodeGen::CodeGenFunction::EmitCapturedStmt", NM="_ZN5clang7CodeGen15CodeGenFunction16EmitCapturedStmtERKNS_12CapturedStmtENS_18CapturedRegionKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction16EmitCapturedStmtERKNS_12CapturedStmtENS_18CapturedRegionKindE")
//</editor-fold>
public final Function /*P*/ EmitCapturedStmt(final /*const*/ CapturedStmt /*&*/ S, CapturedRegionKind K) {
  CodeGenFunction CGF = null;
  CGCapturedStmtRAII CapInfoRAII = null;
  try {
    LValue CapStruct = $this().InitCapturedStruct(S);
    
    // Emit the CapturedDecl
    CGF/*J*/= new CodeGenFunction($this().CGM, true);
    CapInfoRAII/*J*/= new CGCapturedStmtRAII(CGF, new CGCapturedStmtInfo(S, K));
    Function /*P*/ F = CGF.GenerateCapturedStmtFunction(S);
    /*delete*/Destructors.$destroy((Destructors.ClassWithDestructor)CGF.CapturedStmtInfo);
    
    // Emit call to the helper function.
    $this().EmitCallOrInvoke(F, new ArrayRef<Value /*P*/ >(CapStruct.getPointer(), true));
    
    return F;
  } finally {
    if (CapInfoRAII != null) { CapInfoRAII.$destroy(); }
    if (CGF != null) { CGF.$destroy(); }
  }
}


/// Creates the outlined function for a CapturedStmt.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::GenerateCapturedStmtFunction">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp", line = 2194,
 FQN="clang::CodeGen::CodeGenFunction::GenerateCapturedStmtFunction", NM="_ZN5clang7CodeGen15CodeGenFunction28GenerateCapturedStmtFunctionERKNS_12CapturedStmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction28GenerateCapturedStmtFunctionERKNS_12CapturedStmtE")
//</editor-fold>
public final Function /*P*/ GenerateCapturedStmtFunction(final /*const*/ CapturedStmt /*&*/ S) {
  FunctionArgList Args = null;
  try {
    assert (($this().CapturedStmtInfo != null)) : "CapturedStmtInfo should be set when generating the captured function";
    /*const*/ CapturedDecl /*P*/ CD = S.getCapturedDecl$Const();
    /*const*/ RecordDecl /*P*/ RD = S.getCapturedRecordDecl();
    SourceLocation Loc = S.getLocStart();
    assert (CD.hasBody()) : "missing CapturedDecl body";
    
    // Build the argument list.
    final ASTContext /*&*/ Ctx = $this().CGM.getContext();
    Args/*J*/= new FunctionArgList();
    Args.append_T(CD.param_begin(), CD.param_end());
    
    // Create the function declaration.
    org.clang.ast.FunctionType.ExtInfo ExtInfo/*J*/= new org.clang.ast.FunctionType.ExtInfo();
    final /*const*/ CGFunctionInfo /*&*/ FuncInfo = $this().CGM.getTypes().arrangeBuiltinFunctionDeclaration(Ctx.VoidTy.$QualType(), Args);
    org.llvm.ir.FunctionType /*P*/ FuncLLVMTy = $this().CGM.getTypes().GetFunctionType(FuncInfo);
    
    Function /*P*/ F = Function.Create(FuncLLVMTy, GlobalValue.LinkageTypes.InternalLinkage, 
        new Twine($this().CapturedStmtInfo.getHelperName()), $AddrOf($this().CGM.getModule()));
    $this().CGM.SetInternalFunctionAttributes(CD, F, FuncInfo);
    if (CD.isNothrow()) {
      F.addFnAttr(Attribute.AttrKind.NoUnwind);
    }
    
    // Generate the function.
    $this().StartFunction(new GlobalDecl(CD), Ctx.VoidTy.$QualType(), F, FuncInfo, Args, 
        CD.getLocation(), 
        CD.getBody().getLocStart());
    // Set the context parameter in CapturedStmtInfo.
    Address DeclPtr = $this().GetAddrOfLocalVar(CD.getContextParam());
    $this().CapturedStmtInfo.setContextValue($this().Builder.CreateLoad(new Address(DeclPtr)));
    
    // Initialize variable-length arrays.
    LValue Base = $this().MakeNaturalAlignAddrLValue($this().CapturedStmtInfo.getContextValue(), 
        Ctx.getTagDeclType(RD));
    for (FieldDecl /*P*/ FD : RD.fields()) {
      if (FD.hasCapturedVLAType()) {
        Value /*P*/ ExprArg = $this().EmitLoadOfLValue($this().EmitLValueForField(new LValue(Base), FD), 
            S.getLocStart()).getScalarVal();
        /*const*/ VariableArrayType /*P*/ VAT = FD.getCapturedVLAType();
        $this().VLASizeMap.$set(VAT.getSizeExpr(), ExprArg);
      }
    }
    
    // If 'this' is captured, load it into CXXThisValue.
    if ($this().CapturedStmtInfo.isCXXThisExprCaptured()) {
      FieldDecl /*P*/ FD = $this().CapturedStmtInfo.getThisFieldDecl();
      LValue ThisLValue = $this().EmitLValueForField(new LValue(Base), FD);
      $this().CXXThisValue = $this().EmitLoadOfLValue(new LValue(ThisLValue), new SourceLocation(Loc)).getScalarVal();
    }
    
    $this().PGO.assignRegionCounters(new GlobalDecl(CD), F);
    $this().CapturedStmtInfo.EmitBody(/*Deref*/$this(), CD.getBody());
    $this().FinishFunction(CD.getBodyRBrace());
    
    return F;
  } finally {
    if (Args != null) { Args.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::GenerateCapturedStmtArgument">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp", line = 2188,
 FQN="clang::CodeGen::CodeGenFunction::GenerateCapturedStmtArgument", NM="_ZN5clang7CodeGen15CodeGenFunction28GenerateCapturedStmtArgumentERKNS_12CapturedStmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction28GenerateCapturedStmtArgumentERKNS_12CapturedStmtE")
//</editor-fold>
public final Address GenerateCapturedStmtArgument(final /*const*/ CapturedStmt /*&*/ S) {
  LValue CapStruct = $this().InitCapturedStruct(S);
  return CapStruct.getAddress();
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitReturnOfRValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp", line = 966,
 FQN="clang::CodeGen::CodeGenFunction::EmitReturnOfRValue", NM="_ZN5clang7CodeGen15CodeGenFunction18EmitReturnOfRValueENS0_6RValueENS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction18EmitReturnOfRValueENS0_6RValueENS_8QualTypeE")
//</editor-fold>
protected/*private*/ final void EmitReturnOfRValue(RValue RV, QualType Ty) {
  if (RV.isScalar()) {
    $this().Builder.CreateStore(RV.getScalarVal(), new Address($this().ReturnValue));
  } else if (RV.isAggregate()) {
    $this().EmitAggregateCopy(new Address($this().ReturnValue), RV.getAggregateAddress(), new QualType(Ty));
  } else {
    $this().EmitStoreOfComplex(RV.getComplexVal(), $this().MakeAddrLValue(new Address($this().ReturnValue), new QualType(Ty)), 
        /*init*/ true);
  }
  $this().EmitBranchThroughCleanup(new JumpDest($this().ReturnBlock));
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitAsmInput">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp", line = 1735,
 FQN="clang::CodeGen::CodeGenFunction::EmitAsmInput", NM="_ZN5clang7CodeGen15CodeGenFunction12EmitAsmInputERKNS_10TargetInfo14ConstraintInfoEPKNS_4ExprERSs",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction12EmitAsmInputERKNS_10TargetInfo14ConstraintInfoEPKNS_4ExprERSs")
//</editor-fold>
protected/*private*/ final Value /*P*/ EmitAsmInput(final /*const*/ TargetInfo.ConstraintInfo /*&*/ Info, 
            /*const*/ Expr /*P*/ InputExpr, 
            final std.string/*&*/ ConstraintStr) {
  // If this can't be a register or memory, i.e., has to be a constant
  // (immediate or symbolic), try to emit it as such.
  if (!Info.allowsRegister() && !Info.allowsMemory()) {
    APSInt Result/*J*/= new APSInt();
    if (InputExpr.EvaluateAsInt(Result, $this().getContext())) {
      return ConstantInt.get($this().getLLVMContext(), Result);
    }
    assert (!Info.requiresImmediateConstant()) : "Required-immediate inlineasm arg isn't constant?";
  }
  if (Info.allowsRegister() || !Info.allowsMemory()) {
    if (CodeGenFunction.hasScalarEvaluationKind(InputExpr.getType())) {
      return $this().EmitScalarExpr(InputExpr);
    }
  }
  if (InputExpr.getStmtClass() == Expr.StmtClass.CXXThisExprClass) {
    return $this().EmitScalarExpr(InputExpr);
  }
  InputExpr = InputExpr.IgnoreParenNoopCasts$Const($this().getContext());
  LValue Dest = $this().EmitLValue(InputExpr);
  return $this().EmitAsmInputLValue(Info, new LValue(Dest), InputExpr.getType(), ConstraintStr, 
      InputExpr.getExprLoc());
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitAsmInputLValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp", line = 1704,
 FQN="clang::CodeGen::CodeGenFunction::EmitAsmInputLValue", NM="_ZN5clang7CodeGen15CodeGenFunction18EmitAsmInputLValueERKNS_10TargetInfo14ConstraintInfoENS0_6LValueENS_8QualTypeERSsNS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGStmt.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction18EmitAsmInputLValueERKNS_10TargetInfo14ConstraintInfoENS0_6LValueENS_8QualTypeERSsNS_14SourceLocationE")
//</editor-fold>
protected/*private*/ final Value /*P*/ EmitAsmInputLValue(final /*const*/ TargetInfo.ConstraintInfo /*&*/ Info, 
                  LValue InputValue, QualType InputType, 
                  final std.string/*&*/ ConstraintStr, 
                  SourceLocation Loc) {
  Value /*P*/ Arg;
  if (Info.allowsRegister() || !Info.allowsMemory()) {
    if (CodeGenFunction.hasScalarEvaluationKind(new QualType(InputType))) {
      Arg = $this().EmitLoadOfLValue(new LValue(InputValue), new SourceLocation(Loc)).getScalarVal();
    } else {
      org.llvm.ir.Type /*P*/ Ty = $this().ConvertType(new QualType(InputType));
      long/*uint64_t*/ Size = $this().CGM.getDataLayout().getTypeSizeInBits(Ty);
      if ($lesseq_ulong_ullong(Size, $int2ullong(64)) && llvm.isPowerOf2_64(Size)) {
        Ty = IntegerType.get($this().getLLVMContext(), $ulong2uint(Size));
        Ty = org.llvm.ir.PointerType.getUnqual(Ty);
        
        Arg = $this().Builder.CreateLoad($this().Builder.CreateBitCast(InputValue.getAddress(), 
                Ty));
      } else {
        Arg = InputValue.getPointer();
        ConstraintStr.$addassign_T($$STAR);
      }
    }
  } else {
    Arg = InputValue.getPointer();
    ConstraintStr.$addassign_T($$STAR);
  }
  
  return Arg;
}

} // END OF class CodeGenFunction_CGStmt
