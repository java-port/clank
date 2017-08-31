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

import java.util.Iterator;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.llvm.adt.ADTAliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.ast.java.*;
import org.clang.basic.*;
import org.llvm.ir.*;
import org.clang.codegen.CodeGen.*;
import org.clang.codegen.CodeGen.target.impl.*;
import org.clang.basic.target.TargetInfo;
import org.llvm.ir.Type;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import org.clang.codegen.java.ClangCodeGenFunctionPointers.*;
import static org.llvm.ir.java.IrRTTI.*;


/// CodeGenFunction - This class organizes the per-function state that is used
/// while generating LLVM code.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 105,
 FQN="clang::CodeGen::CodeGenFunction", NM="_ZN5clang7CodeGen15CodeGenFunctionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunctionE")
//</editor-fold>
public class CodeGenFunction extends CodeGenFunction_CodeGenPGO implements Destructors.ClassWithDestructor {
  
  /*friend  class CGCXXABI*/
  
  public final CodeGenModule /*&*/ CGM; // Per-module state.
  public final /*const*/ TargetInfo /*&*/ Target;
  
  // JAVA: typedef std::pair<llvm::Value *, llvm::Value *> ComplexPairTy
//  public final class ComplexPairTy extends std.pair<Value /*P*/ , Value /*P*/ >{ };
  public LoopInfoStack LoopStack;
  public CGBuilderTy Builder;
  
  /// CurFuncDecl - Holds the Decl for the current outermost
  /// non-closure context.
  public /*const*/ Decl /*P*/ CurFuncDecl;
  /// CurCodeDecl - This is the inner-most code context, which includes blocks.
  public /*const*/ Decl /*P*/ CurCodeDecl;
  public /*const*/ CGFunctionInfo /*P*/ CurFnInfo;
  public QualType FnRetTy;
  public Function /*P*/ CurFn;
  
  /// CurGD - The GlobalDecl for the current function being compiled.
  public GlobalDecl CurGD;
  
  /// PrologueCleanupDepth - The cleanup depth enclosing all the
  /// cleanups associated with the parameters.
  public EHScopeStack.stable_iterator PrologueCleanupDepth;
  
  /// ReturnBlock - Unified return block.
  public JumpDest ReturnBlock;
  
  /// ReturnValue - The temporary alloca to hold the return
  /// value. This is invalid iff the function has no return value.
  public Address ReturnValue;
  
  /// AllocaInsertPoint - This is an instruction in the entry block before which
  /// we prefer to insert allocas.
  public AssertingVH<Instruction> AllocaInsertPt;
  public CGCapturedStmtInfo /*P*/ CapturedStmtInfo;
  
  /// \brief Sanitizers enabled for this function.
  public SanitizerSet SanOpts;
  
  /// \brief True if CodeGen currently emits code implementing sanitizer checks.
  public boolean IsSanitizerScope;
  
  /// In C++, whether we are code generating a thunk.  This controls whether we
  /// should emit cleanups.
  public boolean CurFuncIsThunk;
  
  /// In ARC, whether we should autorelease the return value.
  public boolean AutoreleaseResult;
  
  /// Whether we processed a Microsoft-style asm block during CodeGen. These can
  /// potentially set the return value.
  public boolean SawAsmBlock;
  
  public /*const*/ FunctionDecl /*P*/ CurSEHParent/* = null*/;
  
  /// True if the current function is an outlined SEH helper. This can be a
  /// finally block or filter expression.
  public boolean IsOutlinedSEHHelper;
  
  public /*const*/ CGBlockInfo /*P*/ BlockInfo;
  public Value /*P*/ BlockPointer;
  
  public DenseMap</*const*/ VarDecl /*P*/ , FieldDecl /*P*/ > LambdaCaptureFields;
  public FieldDecl /*P*/ LambdaThisCaptureField;
  
  /// \brief A mapping from NRVO variables to the flags used to indicate
  /// when the NRVO has been applied to this variable.
  public DenseMap</*const*/ VarDecl /*P*/ , Value /*P*/ > NRVOFlags;
  
  public EHScopeStack EHStack;
  public SmallString LifetimeExtendedCleanupStack;
  public SmallVector</*const*/ JumpDest /*P*/ > SEHTryEpilogueStack;
  
  public Instruction /*P*/ CurrentFuncletPad/* = null*/;
  
  /// i32s containing the indexes of the cleanup destinations.
  public AllocaInst /*P*/ NormalCleanupDest;
  
  public /*uint*/int NextCleanupDestIndex;
  
  /// FirstBlockInfo - The head of a singly-linked-list of block layouts.
  public CGBlockInfo /*P*/ FirstBlockInfo;
  
  /// EHResumeBlock - Unified block containing a call to llvm.eh.resume.
  public BasicBlock /*P*/ EHResumeBlock;
  
  /// The exception slot.  All landing pads write the current exception pointer
  /// into this alloca.
  public Value /*P*/ ExceptionSlot;
  
  /// The selector slot.  Under the MandatoryCleanup model, all landing pads
  /// write the current selector value into this alloca.
  public AllocaInst /*P*/ EHSelectorSlot;
  
  /// A stack of exception code slots. Entering an __except block pushes a slot
  /// on the stack and leaving pops one. The __exception_code() intrinsic loads
  /// a value from the top of the stack.
  public SmallVector<Address> SEHCodeSlotStack;
  
  /// Value returned by __exception_info intrinsic.
  public Value /*P*/ SEHInfo/* = null*/;

  /*template <class T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::saveValueInCond">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 362,
   FQN="clang::CodeGen::CodeGenFunction::saveValueInCond", NM="Tpl__ZN5clang7CodeGen15CodeGenFunction15saveValueInCondET_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=Tpl__ZN5clang7CodeGen15CodeGenFunction15saveValueInCondET_")
  //</editor-fold>
  public final </*class*/ T>  T saveValueInCond(T value) {
    return DominatingValue.<T>save(/*Deref*/this, value);
  }

  /// ObjCEHValueStack - Stack of Objective-C exception values, used for
  /// rethrows.
  public SmallVector<Value /*P*/ > ObjCEHValueStack;
  
  /// Returns true inside SEH __try blocks.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::isSEHTryScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 395,
   FQN="clang::CodeGen::CodeGenFunction::isSEHTryScope", NM="_ZNK5clang7CodeGen15CodeGenFunction13isSEHTryScopeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZNK5clang7CodeGen15CodeGenFunction13isSEHTryScopeEv")
  //</editor-fold>
  public final boolean isSEHTryScope() /*const*/ {
    return !SEHTryEpilogueStack.empty();
  }

  
  /// Returns true while emitting a cleanuppad.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::isCleanupPadScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 398,
   FQN="clang::CodeGen::CodeGenFunction::isCleanupPadScope", NM="_ZNK5clang7CodeGen15CodeGenFunction17isCleanupPadScopeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZNK5clang7CodeGen15CodeGenFunction17isCleanupPadScopeEv")
  //</editor-fold>
  public final boolean isCleanupPadScope() /*const*/ {
    return (CurrentFuncletPad != null) && isa_CleanupPadInst(CurrentFuncletPad);
  }

  
  /// pushFullExprCleanup - Push a cleanup to be run at the end of the
  /// current full-expression.  Safe against the possibility that
  /// we're currently inside a conditionally-evaluated expression.
  /*template <class T, class ... As> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::pushFullExprCleanup">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 406,
   FQN="clang::CodeGen::CodeGenFunction::pushFullExprCleanup", NM="Tpl__ZN5clang7CodeGen15CodeGenFunction19pushFullExprCleanupENS0_11CleanupKindEDpT0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=Tpl__ZN5clang7CodeGen15CodeGenFunction19pushFullExprCleanupENS0_11CleanupKindEDpT0_")
  //</editor-fold>
  public final </*class*/ T extends EHScopeStack.Cleanup> void pushFullExprCleanup(/*CleanupKind*//*uint*/int kind, final SupplierEx<T> $factory, Object ... A) {
    // If we're not in a conditional branch, or if none of the
    // arguments requires saving, then use the unconditional cleanup.
    if (!isInConditionalBranch()) {
      EHStack.<T>pushCleanup$T(kind, () ->$factory.$call(A));
      /*JAVA:return*/return;
    }
    
    // Stash values in a tuple so we can guarantee the order of saves.
    // JAVA: typedef std::tuple<typename DominatingValue<As>::saved_type...> SavedTuple
//    final class SavedTuple extends DominatingValue.saved_type[]{ };
    Object[] Saved/*J*/= new Object[A.length];
    for(int i = 0; i < A.length; i++) {
      Saved[i] = saveValueInCond(A[i]);
    }
    
    // JAVA: typedef EHScopeStack::ConditionalCleanup<T, As...> CleanupType
//    final class CleanupType extends EHScopeStack.ConditionalCleanup<T, As...>{ };
    EHStack.pushCleanupTuple(kind, $factory, Saved);
    initFullExprCleanup();
  }

  
  /// \brief Queue a cleanup to be pushed after finishing the current
  /// full-expression.
  /*template <class T, class ... As> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::pushCleanupAfterFullExpr">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 424,
   FQN="clang::CodeGen::CodeGenFunction::pushCleanupAfterFullExpr", NM="Tpl__ZN5clang7CodeGen15CodeGenFunction24pushCleanupAfterFullExprENS0_11CleanupKindEDpT0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=Tpl__ZN5clang7CodeGen15CodeGenFunction24pushCleanupAfterFullExprENS0_11CleanupKindEDpT0_")
  //</editor-fold>
  public final </*class*/ T> void pushCleanupAfterFullExpr(/*CleanupKind*//*uint*/int Kind, Object ...A) {
    assert (!isInConditionalBranch()) : "can't defer conditional cleanup";
    
    LifetimeExtendedCleanupHeader Header = new LifetimeExtendedCleanupHeader(4/*$sizeof_T()*/, Kind);
    
    /*size_t*/int OldSize = LifetimeExtendedCleanupStack.size();
    LifetimeExtendedCleanupStack.resize(LifetimeExtendedCleanupStack.size() + sizeof(Header) + Header.Size);
    
    static_assert(Native.$eq($rem_uint_int(sizeof(Header), 8/*AlignOf.<T>Alignment*/), 0), 
            $("Cleanup will be allocated on misaligned address"));
    char$ptr/*char P*/ Buffer = $tryClone(/*AddrOf*/LifetimeExtendedCleanupStack.ptr$at(OldSize));
    throw new UnsupportedOperationException("Fix commented lines");
//    /*NEW_EXPR [System]*/Buffer = /*new (Buffer)*/ $new_uint_voidPtr(Buffer, (type$ptr<?> New$Mem)->{
//        return new LifetimeExtendedCleanupHeader(Header);
//     });
//    /*FIXME: NEW_EXPR [NoNewFun]*/Buffer.$add(sizeof(Header)) = /*new (Buffer + sizeof (Header))*/ A;//new T(( A... ));
  }

  
  // JAVA: typedef llvm::DenseMap<const Decl *, Address> DeclMapTy
//  public final class DeclMapTy extends DenseMap</*const*/ Decl /*P*/ , Address>{ };
  
  /// The given basic block lies in the current EH scope, but may be a
  /// target of a potentially scope-crossing jump; get a stable handle
  /// to which we can perform this jump later.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::getJumpDestInCurrentScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 700,
   FQN="clang::CodeGen::CodeGenFunction::getJumpDestInCurrentScope", NM="_ZN5clang7CodeGen15CodeGenFunction25getJumpDestInCurrentScopeEPN4llvm10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction25getJumpDestInCurrentScopeEPN4llvm10BasicBlockE")
  //</editor-fold>
  public final JumpDest getJumpDestInCurrentScope(BasicBlock /*P*/ Target) {
    return new JumpDest(Target, 
        EHStack.getInnermostNormalCleanup(), 
        NextCleanupDestIndex++);
  }

  
  /// The given basic block lies in the current EH scope, but may be a
  /// target of a potentially scope-crossing jump; get a stable handle
  /// to which we can perform this jump later.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::getJumpDestInCurrentScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 709,
   FQN="clang::CodeGen::CodeGenFunction::getJumpDestInCurrentScope", NM="_ZN5clang7CodeGen15CodeGenFunction25getJumpDestInCurrentScopeEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction25getJumpDestInCurrentScopeEN4llvm9StringRefE")
  //</editor-fold>
  public final JumpDest getJumpDestInCurrentScope() {
    return getJumpDestInCurrentScope(new StringRef());
  }
  public final JumpDest getJumpDestInCurrentScope(StringRef Name/*= StringRef()*/) {
    return getJumpDestInCurrentScope(createBasicBlock(new Twine(Name)));
  }

  
  /// isInConditionalBranch - Return true if we're currently emitting
  /// one branch or the other of a conditional expression.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::isInConditionalBranch">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 761,
   FQN="clang::CodeGen::CodeGenFunction::isInConditionalBranch", NM="_ZNK5clang7CodeGen15CodeGenFunction21isInConditionalBranchEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZNK5clang7CodeGen15CodeGenFunction21isInConditionalBranchEv")
  //</editor-fold>
  public final boolean isInConditionalBranch() /*const*/ {
    return OutermostConditional != null;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::setBeforeOutermostConditional">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 763,
   FQN="clang::CodeGen::CodeGenFunction::setBeforeOutermostConditional", NM="_ZN5clang7CodeGen15CodeGenFunction29setBeforeOutermostConditionalEPN4llvm5ValueENS0_7AddressE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction29setBeforeOutermostConditionalEPN4llvm5ValueENS0_7AddressE")
  //</editor-fold>
  public final void setBeforeOutermostConditional(Value /*P*/ value, Address addr) {
    assert (isInConditionalBranch());
    BasicBlock /*P*/ block = OutermostConditional.getStartingBlock();
    StoreInst /*P*/ store = /*NEW_EXPR [StoreInst::new]*/StoreInst.$new_StoreInst((type$ptr<?> New$Mem)->{
        return new StoreInst(value, addr.getPointer(), $AddrOf(block.back()));
     });
    store.setAlignment($long2uint(addr.getAlignment().getQuantity()));
  }

  protected/*private*/ CGDebugInfo /*P*/ DebugInfo;
  protected/*private*/ boolean DisableDebugInfo;
  
  /// DidCallStackSave - Whether llvm.stacksave has been called. Used to avoid
  /// calling llvm.stacksave for multiple VLAs in the same scope.
  protected/*private*/ boolean DidCallStackSave;
  
  /// IndirectBranch - The first time an indirect goto is seen we create a block
  /// with an indirect branch.  Every time we see the address of a label taken,
  /// we add the label to the indirect goto.  Every subsequent indirect goto is
  /// codegen'd as a jump to the IndirectBranch's basic block.
  protected/*private*/ IndirectBrInst /*P*/ IndirectBranch;
  
  /// LocalDeclMap - This keeps track of the LLVM allocas or globals for local C
  /// decls.
  protected/*private*/ DenseMap</*const*/ Decl /*P*/ , Address> LocalDeclMap;
  
  /// SizeArguments - If a ParmVarDecl had the pass_object_size attribute, this
  /// will contain a mapping from said ParmVarDecl to its implicit "object_size"
  /// parameter.
  protected/*private*/ SmallDenseMap</*const*/ ParmVarDecl /*P*/ , /*const*/ ImplicitParamDecl /*P*/ > SizeArguments;
  
  /// Track escaped local variables with auto storage. Used during SEH
  /// outlining to produce a call to llvm.localescape.
  protected/*private*/ DenseMapTypeInt<AllocaInst /*P*/ > EscapedLocals;
  
  /// LabelMap - This keeps track of the LLVM basic block for each C label.
  protected/*private*/ DenseMap</*const*/ LabelDecl /*P*/ , JumpDest> LabelMap;
  protected/*private*/ SmallVector<BreakContinue> BreakContinueStack;
  
  protected/*private*/ CodeGenPGO PGO;
  /// Increment the profiler's counter for the given statement.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::incrementProfileCounter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 978,
   FQN="clang::CodeGen::CodeGenFunction::incrementProfileCounter", NM="_ZN5clang7CodeGen15CodeGenFunction23incrementProfileCounterEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction23incrementProfileCounterEPKNS_4StmtE")
  //</editor-fold>
  public final void incrementProfileCounter(/*const*/ Stmt /*P*/ S) {
    if (CGM.getCodeGenOpts().hasProfileClangInstr()) {
      PGO.emitCounterIncrement(Builder, S);
    }
    PGO.setCurrentStmt(S);
  }

  
  /// Get the profiler's count for the given statement.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::getProfileCount">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 985,
   FQN="clang::CodeGen::CodeGenFunction::getProfileCount", NM="_ZN5clang7CodeGen15CodeGenFunction15getProfileCountEPKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction15getProfileCountEPKNS_4StmtE")
  //</editor-fold>
  public final long/*uint64_t*/ getProfileCount(/*const*/ Stmt /*P*/ S) {
    OptionalULong Count = PGO.getStmtCount(S);
    if (!Count.hasValue()) {
      return $int2ulong(0);
    }
    return Count.$star();
  }

  
  /// Set the profiler's current count.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::setCurrentProfileCount">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 993,
   FQN="clang::CodeGen::CodeGenFunction::setCurrentProfileCount", NM="_ZN5clang7CodeGen15CodeGenFunction22setCurrentProfileCountEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction22setCurrentProfileCountEy")
  //</editor-fold>
  public final void setCurrentProfileCount(long/*uint64_t*/ Count) {
    PGO.setCurrentRegionCount(Count);
  }

  
  /// Get the profiler's current count. This is generally the count for the most
  /// recently incremented counter.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::getCurrentProfileCount">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 999,
   FQN="clang::CodeGen::CodeGenFunction::getCurrentProfileCount", NM="_ZN5clang7CodeGen15CodeGenFunction22getCurrentProfileCountEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction22getCurrentProfileCountEv")
  //</editor-fold>
  public final long/*uint64_t*/ getCurrentProfileCount() {
    return PGO.getCurrentRegionCount();
  }

  
  /// SwitchInsn - This is nearest current switch instruction. It is null if
  /// current context is not in a switch.
  protected/*private*/ SwitchInst /*P*/ SwitchInsn;
  /// The branch weights of SwitchInsn when doing instrumentation based PGO.
  protected/*private*/ SmallVectorULong /*P*/ SwitchWeights;
  
  /// CaseRangeBlock - This block holds if condition check for last case
  /// statement range in current switch instruction.
  protected/*private*/ BasicBlock /*P*/ CaseRangeBlock;
  
  /// OpaqueLValues - Keeps track of the current set of opaque value
  /// expressions.
  protected/*private*/ DenseMap</*const*/ OpaqueValueExpr /*P*/ , LValue> OpaqueLValues;
  protected/*private*/ DenseMap</*const*/ OpaqueValueExpr /*P*/ , RValue> OpaqueRValues;
  
  // VLASizeMap - This keeps track of the associated size for each VLA type.
  // We track this by the size expression rather than the type itself because
  // in certain situations, like a const qualifier applied to an VLA typedef,
  // multiple VLA types can share the same size expression.
  // FIXME: Maybe this could be a stack of maps that is pushed/popped as we
  // enter/leave scopes.
  protected/*private*/ DenseMap</*const*/ Expr /*P*/ , Value /*P*/ > VLASizeMap;
  
  /// A block containing a single 'unreachable' instruction.  Created
  /// lazily by getUnreachableBlock().
  protected/*private*/ BasicBlock /*P*/ UnreachableBlock;
  
  /// Counts of the number return expressions in the function.
  protected/*private*/ /*uint*/int NumReturnExprs;
  
  /// Count the number of simple (constant) return expressions in the function.
  protected/*private*/ /*uint*/int NumSimpleReturnExprs;
  
  /// The last regular (non-return) debug location (breakpoint) in the function.
  protected/*private*/ SourceLocation LastStopPoint;
  /// CXXThisDecl - When generating code for a C++ member function,
  /// this will hold the implicit 'this' declaration.
  protected/*private*/ ImplicitParamDecl /*P*/ CXXABIThisDecl;
  protected/*private*/ Value /*P*/ CXXABIThisValue;
  protected/*private*/ Value /*P*/ CXXThisValue;
  protected/*private*/ CharUnits CXXABIThisAlignment;
  protected/*private*/ CharUnits CXXThisAlignment;
  
  /// The value of 'this' to use when evaluating CXXDefaultInitExprs within
  /// this expression.
  protected/*private*/ Address CXXDefaultInitExprThis/* = Address::invalid()*/;
  
  /// The values of function arguments to use when evaluating
  /// CXXInheritedCtorInitExprs within this context.
  protected/*private*/ CallArgList CXXInheritedCtorInitExprArgs;
  
  /// CXXStructorImplicitParamDecl - When generating code for a constructor or
  /// destructor, this will hold the implicit argument (e.g. VTT).
  protected/*private*/ ImplicitParamDecl /*P*/ CXXStructorImplicitParamDecl;
  protected/*private*/ Value /*P*/ CXXStructorImplicitParamValue;
  
  /// OutermostConditional - Points to the outermost active
  /// conditional control.  This is used so that we know if a
  /// temporary should be destroyed conditionally.
  protected/*private*/ ConditionalEvaluation /*P*/ OutermostConditional;
  
  /// The current lexical scope.
  protected/*private*/ LexicalScope /*P*/ CurLexicalScope;
  
  /// The current source location that should be used for exception
  /// handling code.
  protected/*private*/ SourceLocation CurEHLocation;
  
  /// BlockByrefInfos - For each __block variable, contains
  /// information about the layout of the variable.
  protected/*private*/ DenseMap</*const*/ ValueDecl /*P*/ , BlockByrefInfo> BlockByrefInfos;
  
  protected/*private*/ BasicBlock /*P*/ TerminateLandingPad;
  protected/*private*/ BasicBlock /*P*/ TerminateHandler;
  protected/*private*/ BasicBlock /*P*/ TrapBB;
  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::getTypes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 1195,
   FQN="clang::CodeGen::CodeGenFunction::getTypes", NM="_ZNK5clang7CodeGen15CodeGenFunction8getTypesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZNK5clang7CodeGen15CodeGenFunction8getTypesEv")
  //</editor-fold>
  public final CodeGenTypes /*&*/ getTypes() /*const*/ {
    return CGM.getTypes();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::getContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 1196,
   FQN="clang::CodeGen::CodeGenFunction::getContext", NM="_ZNK5clang7CodeGen15CodeGenFunction10getContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZNK5clang7CodeGen15CodeGenFunction10getContextEv")
  //</editor-fold>
  public final ASTContext /*&*/ getContext() /*const*/ {
    return CGM.getContext();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::getDebugInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 1197,
   FQN="clang::CodeGen::CodeGenFunction::getDebugInfo", NM="_ZN5clang7CodeGen15CodeGenFunction12getDebugInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction12getDebugInfoEv")
  //</editor-fold>
  public final CGDebugInfo /*P*/ getDebugInfo() {
    if (DisableDebugInfo) {
      return null;
    }
    return DebugInfo;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::disableDebugInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 1202,
   FQN="clang::CodeGen::CodeGenFunction::disableDebugInfo", NM="_ZN5clang7CodeGen15CodeGenFunction16disableDebugInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction16disableDebugInfoEv")
  //</editor-fold>
  public final void disableDebugInfo() {
    DisableDebugInfo = true;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::enableDebugInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 1203,
   FQN="clang::CodeGen::CodeGenFunction::enableDebugInfo", NM="_ZN5clang7CodeGen15CodeGenFunction15enableDebugInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction15enableDebugInfoEv")
  //</editor-fold>
  public final void enableDebugInfo() {
    DisableDebugInfo = false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::shouldUseFusedARCCalls">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 1205,
   FQN="clang::CodeGen::CodeGenFunction::shouldUseFusedARCCalls", NM="_ZN5clang7CodeGen15CodeGenFunction22shouldUseFusedARCCallsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction22shouldUseFusedARCCallsEv")
  //</editor-fold>
  public final boolean shouldUseFusedARCCalls() {
    return $2bits_uint2uint(CGM.getCodeGenOpts().OptimizationLevel) == 0;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::getLangOpts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 1209,
   FQN="clang::CodeGen::CodeGenFunction::getLangOpts", NM="_ZNK5clang7CodeGen15CodeGenFunction11getLangOptsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZNK5clang7CodeGen15CodeGenFunction11getLangOptsEv")
  //</editor-fold>
  public final /*const*/ LangOptions /*&*/ getLangOpts() /*const*/ {
    return CGM.getLangOpts();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::getUnreachableBlock">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 1223,
   FQN="clang::CodeGen::CodeGenFunction::getUnreachableBlock", NM="_ZN5clang7CodeGen15CodeGenFunction19getUnreachableBlockEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction19getUnreachableBlockEv")
  //</editor-fold>
  public final BasicBlock /*P*/ getUnreachableBlock() {
    if (!(UnreachableBlock != null)) {
      UnreachableBlock = createBasicBlock(new Twine(/*KEEP_STR*/"unreachable"));
      /*NEW_EXPR [UnreachableInst::new]*/UnreachableInst.$new_UnreachableInst((type$ptr<?> New$Mem)->{
          return new UnreachableInst(getLLVMContext(), UnreachableBlock);
       });
    }
    return UnreachableBlock;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::getInvokeDest">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 1231,
   FQN="clang::CodeGen::CodeGenFunction::getInvokeDest", NM="_ZN5clang7CodeGen15CodeGenFunction13getInvokeDestEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction13getInvokeDestEv")
  //</editor-fold>
  public final BasicBlock /*P*/ getInvokeDest() {
    if (!EHStack.requiresLandingPad()) {
      return null;
    }
    return getInvokeDestImpl();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::currentFunctionUsesSEHTry">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 1236,
   FQN="clang::CodeGen::CodeGenFunction::currentFunctionUsesSEHTry", NM="_ZNK5clang7CodeGen15CodeGenFunction25currentFunctionUsesSEHTryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZNK5clang7CodeGen15CodeGenFunction25currentFunctionUsesSEHTryEv")
  //</editor-fold>
  public final boolean currentFunctionUsesSEHTry() /*const*/ {
    return CurSEHParent != null;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::getTarget">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 1238,
   FQN="clang::CodeGen::CodeGenFunction::getTarget", NM="_ZNK5clang7CodeGen15CodeGenFunction9getTargetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZNK5clang7CodeGen15CodeGenFunction9getTargetEv")
  //</editor-fold>
  public final /*const*/ TargetInfo /*&*/ getTarget() /*const*/ {
    return Target;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::getLLVMContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 1239,
   FQN="clang::CodeGen::CodeGenFunction::getLLVMContext", NM="_ZN5clang7CodeGen15CodeGenFunction14getLLVMContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction14getLLVMContextEv")
  //</editor-fold>
  public final LLVMContext /*&*/ getLLVMContext() {
    return CGM.getLLVMContext();
  }

  
  //===--------------------------------------------------------------------===//
  //                                  Cleanups
  //===--------------------------------------------------------------------===//
  // JAVA: typedef void (Destroyer)(CodeGenFunction &, Address, QualType)
//  public final class Destroyer extends /*ADD MAPPING FOR FUN PTR[void (CodeGenFunction & , Address, QualType)]*/void (CodeGenFunction /*&*/ , Address, QualType){ };
  
  /// Determines whether an EH cleanup is required to destroy a type
  /// with the given destruction kind.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::needsEHCleanup">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 1286,
   FQN="clang::CodeGen::CodeGenFunction::needsEHCleanup", NM="_ZN5clang7CodeGen15CodeGenFunction14needsEHCleanupENS_8QualType15DestructionKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction14needsEHCleanupENS_8QualType15DestructionKindE")
  //</editor-fold>
  public final boolean needsEHCleanup(QualType.DestructionKind kind) {
    switch (kind) {
     case DK_none:
      return false;
     case DK_cxx_destructor:
     case DK_objc_weak_lifetime:
      return getLangOpts().Exceptions;
     case DK_objc_strong_lifetime:
      return getLangOpts().Exceptions
         && CGM.getCodeGenOpts().ObjCAutoRefCountExceptions;
    }
    throw new llvm_unreachable("bad destruction kind");
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::getCleanupKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 1300,
   FQN="clang::CodeGen::CodeGenFunction::getCleanupKind", NM="_ZN5clang7CodeGen15CodeGenFunction14getCleanupKindENS_8QualType15DestructionKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction14getCleanupKindENS_8QualType15DestructionKindE")
  //</editor-fold>
  public final /*CleanupKind*//*uint*/int getCleanupKind(QualType.DestructionKind kind) {
    return (needsEHCleanup(kind) ? CleanupKind.NormalAndEHCleanup : CleanupKind.NormalCleanup);
  }

  
  // JAVA: typedef llvm::SmallVector<VPtr, 4> VPtrsVector
//  public final class VPtrsVector extends SmallVector<VPtr>{ };
  
  // JAVA: typedef llvm::SmallPtrSet<const CXXRecordDecl *, 4> VisitedVirtualBasesSetTy
//  public final class VisitedVirtualBasesSetTy extends SmallPtrSet</*const*/ CXXRecordDecl /*P*/ >{ };
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::ConvertType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 1564,
   FQN="clang::CodeGen::CodeGenFunction::ConvertType", NM="_ZN5clang7CodeGen15CodeGenFunction11ConvertTypeEPKNS_8TypeDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction11ConvertTypeEPKNS_8TypeDeclE")
  //</editor-fold>
  public final org.llvm.ir.Type /*P*/ ConvertType(/*const*/ TypeDecl /*P*/ T) {
    return ConvertType(getContext().getTypeDeclType(T));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::hasScalarEvaluationKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 1579,
   FQN="clang::CodeGen::CodeGenFunction::hasScalarEvaluationKind", NM="_ZN5clang7CodeGen15CodeGenFunction23hasScalarEvaluationKindENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction23hasScalarEvaluationKindENS_8QualTypeE")
  //</editor-fold>
  public static boolean hasScalarEvaluationKind(QualType T) {
    return CodeGenFunction.getEvaluationKind(new QualType(T)) == TypeEvaluationKind.TEK_Scalar;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::hasAggregateEvaluationKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 1583,
   FQN="clang::CodeGen::CodeGenFunction::hasAggregateEvaluationKind", NM="_ZN5clang7CodeGen15CodeGenFunction26hasAggregateEvaluationKindENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction26hasAggregateEvaluationKindENS_8QualTypeE")
  //</editor-fold>
  public static boolean hasAggregateEvaluationKind(QualType T) {
    return CodeGenFunction.getEvaluationKind(new QualType(T)) == TypeEvaluationKind.TEK_Aggregate;
  }

  
  /// createBasicBlock - Create an LLVM basic block.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::createBasicBlock">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 1588,
   FQN="clang::CodeGen::CodeGenFunction::createBasicBlock", NM="_ZN5clang7CodeGen15CodeGenFunction16createBasicBlockERKN4llvm5TwineEPNS2_8FunctionEPNS2_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction16createBasicBlockERKN4llvm5TwineEPNS2_8FunctionEPNS2_10BasicBlockE")
  //</editor-fold>
  public final BasicBlock /*P*/ createBasicBlock() {
    return createBasicBlock(new Twine(/*KEEP_STR*/$EMPTY), 
                  (Function /*P*/ )null, 
                  (BasicBlock /*P*/ )null);
  }
  public final BasicBlock /*P*/ createBasicBlock(final /*const*/ Twine /*&*/ name/*= ""*/) {
    return createBasicBlock(name, 
                  (Function /*P*/ )null, 
                  (BasicBlock /*P*/ )null);
  }
  public final BasicBlock /*P*/ createBasicBlock(final /*const*/ Twine /*&*/ name/*= ""*/, 
                  Function /*P*/ parent/*= null*/) {
    return createBasicBlock(name, 
                  parent, 
                  (BasicBlock /*P*/ )null);
  }
  public final BasicBlock /*P*/ createBasicBlock(final /*const*/ Twine /*&*/ name/*= ""*/, 
                  Function /*P*/ parent/*= null*/, 
                  BasicBlock /*P*/ before/*= null*/) {
    return BasicBlock.Create(getLLVMContext(), name, parent, before);
  }

  
  /// HaveInsertPoint - True if an insertion point is defined. If not, this
  /// indicates that the current code being emitted is unreachable.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::HaveInsertPoint">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 1633,
   FQN="clang::CodeGen::CodeGenFunction::HaveInsertPoint", NM="_ZNK5clang7CodeGen15CodeGenFunction15HaveInsertPointEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZNK5clang7CodeGen15CodeGenFunction15HaveInsertPointEv")
  //</editor-fold>
  public final boolean HaveInsertPoint() /*const*/ {
    return Builder.GetInsertBlock() != null;
  }

  
  /// EnsureInsertPoint - Ensure that an insertion point is defined so that
  /// emitted IR has a place to go. Note that by definition, if this function
  /// creates a block then that block is unreachable; callers may do better to
  /// detect when no insertion point is defined and simply skip IR generation.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EnsureInsertPoint">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 1641,
   FQN="clang::CodeGen::CodeGenFunction::EnsureInsertPoint", NM="_ZN5clang7CodeGen15CodeGenFunction17EnsureInsertPointEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction17EnsureInsertPointEv")
  //</editor-fold>
  public final void EnsureInsertPoint() {
    if (!HaveInsertPoint()) {
      EmitBlock(createBasicBlock());
    }
  }

  
  //===--------------------------------------------------------------------===//
  //                                  Helpers
  //===--------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::MakeAddrLValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 1654,
   FQN="clang::CodeGen::CodeGenFunction::MakeAddrLValue", NM="_ZN5clang7CodeGen15CodeGenFunction14MakeAddrLValueENS0_7AddressENS_8QualTypeENS0_15AlignmentSourceE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction14MakeAddrLValueENS0_7AddressENS_8QualTypeENS0_15AlignmentSourceE")
  //</editor-fold>
  public final LValue MakeAddrLValue(Address Addr, QualType T) {
    return MakeAddrLValue(Addr, T, 
                AlignmentSource.Type);
  }
  public final LValue MakeAddrLValue(Address Addr, QualType T, 
                AlignmentSource AlignSource/*= AlignmentSource::Type*/) {
    return LValue.MakeAddr(new Address(Addr), new QualType(T), getContext(), AlignSource, 
        CGM.getTBAAInfo(new QualType(T)));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::MakeAddrLValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 1660,
   FQN="clang::CodeGen::CodeGenFunction::MakeAddrLValue", NM="_ZN5clang7CodeGen15CodeGenFunction14MakeAddrLValueEPN4llvm5ValueENS_8QualTypeENS_9CharUnitsENS0_15AlignmentSourceE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction14MakeAddrLValueEPN4llvm5ValueENS_8QualTypeENS_9CharUnitsENS0_15AlignmentSourceE")
  //</editor-fold>
  public final LValue MakeAddrLValue(Value /*P*/ V, QualType T, CharUnits Alignment) {
    return MakeAddrLValue(V, T, Alignment, 
                AlignmentSource.Type);
  }
  public final LValue MakeAddrLValue(Value /*P*/ V, QualType T, CharUnits Alignment, 
                AlignmentSource AlignSource/*= AlignmentSource::Type*/) {
    return LValue.MakeAddr(new Address(V, new CharUnits(Alignment)), new QualType(T), getContext(), 
        AlignSource, CGM.getTBAAInfo(new QualType(T)));
  }

  
  /// CreateAggTemp - Create a temporary memory object for the given
  /// aggregate type.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::CreateAggTemp">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 1729,
   FQN="clang::CodeGen::CodeGenFunction::CreateAggTemp", NM="_ZN5clang7CodeGen15CodeGenFunction13CreateAggTempENS_8QualTypeERKN4llvm5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction13CreateAggTempENS_8QualTypeERKN4llvm5TwineE")
  //</editor-fold>
  public final AggValueSlot CreateAggTemp(QualType T) {
    return CreateAggTemp(T, new Twine(/*KEEP_STR*/"tmp"));
  }
  public final AggValueSlot CreateAggTemp(QualType T, final /*const*/ Twine /*&*/ Name/*= "tmp"*/) {
    return AggValueSlot.forAddr(CreateMemTemp(new QualType(T), Name), 
        T.getQualifiers(), 
        AggValueSlot.IsDestructed_t.IsNotDestructed, 
        AggValueSlot.NeedsGCBarriers_t.DoesNotNeedGCBarriers, 
        AggValueSlot.IsAliased_t.IsNotAliased);
  }

  
  /// hasVolatileMember - returns true if aggregate type has a volatile
  /// member.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::hasVolatileMember">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 1784,
   FQN="clang::CodeGen::CodeGenFunction::hasVolatileMember", NM="_ZN5clang7CodeGen15CodeGenFunction17hasVolatileMemberENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction17hasVolatileMemberENS_8QualTypeE")
  //</editor-fold>
  public final boolean hasVolatileMember(QualType T) {
    {
      /*const*/ RecordType /*P*/ RT = T.$arrow().getAs$RecordType();
      if ((RT != null)) {
        /*const*/ RecordDecl /*P*/ RD = cast_RecordDecl(RT.getDecl());
        return RD.hasVolatileMember();
      }
    }
    return false;
  }

  /// EmitAggregateCopy - Emit an aggregate assignment.
  ///
  /// The difference to EmitAggregateCopy is that tail padding is not copied.
  /// This is required for correctness when assigning non-POD structures in C++.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitAggregateAssign">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 1795,
   FQN="clang::CodeGen::CodeGenFunction::EmitAggregateAssign", NM="_ZN5clang7CodeGen15CodeGenFunction19EmitAggregateAssignENS0_7AddressES2_NS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction19EmitAggregateAssignENS0_7AddressES2_NS_8QualTypeE")
  //</editor-fold>
  public final void EmitAggregateAssign(Address DestPtr, Address SrcPtr, 
                     QualType EltTy) {
    boolean IsVolatile = hasVolatileMember(new QualType(EltTy));
    EmitAggregateCopy(new Address(DestPtr), new Address(SrcPtr), new QualType(EltTy), IsVolatile, true);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitAggregateCopyCtor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 1801,
   FQN="clang::CodeGen::CodeGenFunction::EmitAggregateCopyCtor", NM="_ZN5clang7CodeGen15CodeGenFunction21EmitAggregateCopyCtorENS0_7AddressES2_NS_8QualTypeES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction21EmitAggregateCopyCtorENS0_7AddressES2_NS_8QualTypeES3_")
  //</editor-fold>
  public final void EmitAggregateCopyCtor(Address DestPtr, Address SrcPtr, 
                       QualType DestTy, QualType SrcTy) {
    EmitAggregateCopy(new Address(DestPtr), new Address(SrcPtr), new QualType(SrcTy), /*IsVolatile=*/ false, 
        /*IsAssignment=*/ false);
  }

  
  /// GetAddrOfLocalVar - Return the address of a local variable.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::GetAddrOfLocalVar">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 1818,
   FQN="clang::CodeGen::CodeGenFunction::GetAddrOfLocalVar", NM="_ZN5clang7CodeGen15CodeGenFunction17GetAddrOfLocalVarEPKNS_7VarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction17GetAddrOfLocalVarEPKNS_7VarDeclE")
  //</editor-fold>
  public final Address GetAddrOfLocalVar(/*const*/ VarDecl /*P*/ VD) {
    DenseMapIterator</*const*/ Decl /*P*/ , Address> it = LocalDeclMap.find(VD);
    assert (it.$noteq(/*NO_ITER_COPY*/LocalDeclMap.end())) : "Invalid argument to GetAddrOfLocalVar(), no decl!";
    return new Address(it.$arrow().second);
  }

  
  /// getOpaqueLValueMapping - Given an opaque value expression (which
  /// must be mapped to an l-value), return its mapping.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::getOpaqueLValueMapping">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 1827,
   FQN="clang::CodeGen::CodeGenFunction::getOpaqueLValueMapping", NM="_ZN5clang7CodeGen15CodeGenFunction22getOpaqueLValueMappingEPKNS_15OpaqueValueExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction22getOpaqueLValueMappingEPKNS_15OpaqueValueExprE")
  //</editor-fold>
  public final /*const*/ LValue /*&*/ getOpaqueLValueMapping(/*const*/ OpaqueValueExpr /*P*/ e) {
    assert (OpaqueValueMapping.shouldBindAsLValue(e));
    
    DenseMapIterator</*const*/ OpaqueValueExpr /*P*/ , LValue> it = OpaqueLValues.find(e);
    assert (it.$noteq(/*NO_ITER_COPY*/OpaqueLValues.end())) : "no mapping for opaque value!";
    return it.$arrow().second;
  }

  
  /// getOpaqueRValueMapping - Given an opaque value expression (which
  /// must be mapped to an r-value), return its mapping.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::getOpaqueRValueMapping">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 1838,
   FQN="clang::CodeGen::CodeGenFunction::getOpaqueRValueMapping", NM="_ZN5clang7CodeGen15CodeGenFunction22getOpaqueRValueMappingEPKNS_15OpaqueValueExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction22getOpaqueRValueMappingEPKNS_15OpaqueValueExprE")
  //</editor-fold>
  public final /*const*/ RValue /*&*/ getOpaqueRValueMapping(/*const*/ OpaqueValueExpr /*P*/ e) {
    assert (!OpaqueValueMapping.shouldBindAsLValue(e));
    
    DenseMapIterator</*const*/ OpaqueValueExpr /*P*/ , RValue> it = OpaqueRValues.find(e);
    assert (it.$noteq(/*NO_ITER_COPY*/OpaqueRValues.end())) : "no mapping for opaque value!";
    return it.$arrow().second;
  }

  
  /// LoadCXXThis - Load the value of 'this'. This function is only valid while
  /// generating code for an C++ member function.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::LoadCXXThis">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 1898,
   FQN="clang::CodeGen::CodeGenFunction::LoadCXXThis", NM="_ZN5clang7CodeGen15CodeGenFunction11LoadCXXThisEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction11LoadCXXThisEv")
  //</editor-fold>
  public final Value /*P*/ LoadCXXThis() {
    assert ((CXXThisValue != null)) : "no 'this' value for this function";
    return CXXThisValue;
  }

  
  /// LoadCXXVTT - Load the VTT parameter to base constructors/destructors have
  /// virtual bases.
  // FIXME: Every place that calls LoadCXXVTT is something
  // that needs to be abstracted properly.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::LoadCXXVTT">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 1908,
   FQN="clang::CodeGen::CodeGenFunction::LoadCXXVTT", NM="_ZN5clang7CodeGen15CodeGenFunction10LoadCXXVTTEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction10LoadCXXVTTEv")
  //</editor-fold>
  public final Value /*P*/ LoadCXXVTT() {
    assert ((CXXStructorImplicitParamValue != null)) : "no VTT value for this function";
    return CXXStructorImplicitParamValue;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitAlignmentAssumption">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 2088,
   FQN="clang::CodeGen::CodeGenFunction::EmitAlignmentAssumption", NM="_ZN5clang7CodeGen15CodeGenFunction23EmitAlignmentAssumptionEPN4llvm5ValueEjS4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction23EmitAlignmentAssumptionEPN4llvm5ValueEjS4_")
  //</editor-fold>
  public final void EmitAlignmentAssumption(Value /*P*/ PtrValue, /*uint*/int Alignment) {
    EmitAlignmentAssumption(PtrValue, Alignment, 
                         (Value /*P*/ )null);
  }
  public final void EmitAlignmentAssumption(Value /*P*/ PtrValue, /*uint*/int Alignment, 
                         Value /*P*/ OffsetValue/*= null*/) {
    Builder.CreateAlignmentAssumption(CGM.getDataLayout(), PtrValue, Alignment, 
        OffsetValue);
  }

  
  // JAVA: typedef void (SpecialInitFn)(CodeGenFunction &, const VarDecl &, llvm::Value *)
//  public final class SpecialInitFn extends /*ADD MAPPING FOR FUN PTR[void (CodeGenFunction & , const VarDecl & , Value * )]*/void (CodeGenFunction /*&*/ , /*const*/ VarDecl /*&*/ , Value /*P*/ ){ };
  
  // JAVA: typedef const llvm::function_ref<void (CodeGenFunction &, llvm::Value *, const OMPTaskDataTy &)> TaskGenTy
//  public final class TaskGenTy extends /*const*/CodeGenFunction.ValueOMPTaskDataTy2Void{ };
  
  /// Retrieves the default cleanup kind for an ARC cleanup.
  /// Except under -fobjc-arc-eh, ARC cleanups are normal-only.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::getARCCleanupKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 2957,
   FQN="clang::CodeGen::CodeGenFunction::getARCCleanupKind", NM="_ZN5clang7CodeGen15CodeGenFunction17getARCCleanupKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction17getARCCleanupKindEv")
  //</editor-fold>
  public final /*CleanupKind*//*uint*/int getARCCleanupKind() {
    return CGM.getCodeGenOpts().ObjCAutoRefCountExceptions ? CleanupKind.NormalAndEHCleanup : CleanupKind.NormalCleanup;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::enterFullExpression">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 3124,
   FQN="clang::CodeGen::CodeGenFunction::enterFullExpression", NM="_ZN5clang7CodeGen15CodeGenFunction19enterFullExpressionEPKNS_16ExprWithCleanupsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction19enterFullExpressionEPKNS_16ExprWithCleanupsE")
  //</editor-fold>
  public final void enterFullExpression(/*const*/ ExprWithCleanups /*P*/ E) {
    if (E.getNumObjects() == 0) {
      return;
    }
    enterNonTrivialFullExpression(E);
  }

  
  protected/*private*/ SmallVector<std.pair<Instruction /*P*/ , Value /*P*/ >> DeferredReplacements;
  
  /// Set the address of a local variable.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::setAddrOfLocalVar">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 3251,
   FQN="clang::CodeGen::CodeGenFunction::setAddrOfLocalVar", NM="_ZN5clang7CodeGen15CodeGenFunction17setAddrOfLocalVarEPKNS_7VarDeclENS0_7AddressE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction17setAddrOfLocalVarEPKNS_7VarDeclENS0_7AddressE")
  //</editor-fold>
  protected/*private*/ final void setAddrOfLocalVar(/*const*/ VarDecl /*P*/ VD, Address Addr) {
    assert (!(LocalDeclMap.count(VD) != 0)) : "Decl already exists in LocalDeclMap!";
    LocalDeclMap.insert_pair$KeyT$ValueT(/*{ */new std.pairPtrType</*const*/ Decl /*P*/ , Address>(JD$T$RR_T1$RR.INSTANCE, VD, new Address(/*Fwd*/Addr))/* }*/);
  }

  // Determine whether the given argument is an Objective-C method
  // that may have type parameters in its signature.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::isObjCMethodWithTypeParams">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 3294,
   FQN="clang::CodeGen::CodeGenFunction::isObjCMethodWithTypeParams", NM="_ZN5clang7CodeGen15CodeGenFunction26isObjCMethodWithTypeParamsEPKNS_14ObjCMethodDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction26isObjCMethodWithTypeParamsEPKNS_14ObjCMethodDeclE")
  //</editor-fold>
  public static boolean isObjCMethodWithTypeParams(/*const*/ ObjCMethodDecl /*P*/ method) {
    /*const*/ DeclContext /*P*/ dc = method.getDeclContext$Const();
    {
      /*const*/ ObjCInterfaceDecl /*P*/ classDecl = dyn_cast_ObjCInterfaceDecl(dc);
      if ((classDecl != null)) {
        return (classDecl.getTypeParamListAsWritten() != null);
      }
    }
    {
      
      /*const*/ ObjCCategoryDecl /*P*/ catDecl = dyn_cast_ObjCCategoryDecl(dc);
      if ((catDecl != null)) {
        return (catDecl.getTypeParamList() != null);
      }
    }
    
    return false;
  }

  
  /*template <typename T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::isObjCMethodWithTypeParams">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 3308,
   FQN="clang::CodeGen::CodeGenFunction::isObjCMethodWithTypeParams", NM="Tpl__ZN5clang7CodeGen15CodeGenFunction26isObjCMethodWithTypeParamsEPKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=Tpl__ZN5clang7CodeGen15CodeGenFunction26isObjCMethodWithTypeParamsEPKT_")
  //</editor-fold>
  public static </*typename*/ T> boolean isObjCMethodWithTypeParams$T(/*const*/ T /*P*/ $Prm0) {
    return false;
  }

  
  /// EmitCallArgs - Emit call arguments for a function.
  /*template <typename T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitCallArgs">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 3313,
   FQN="clang::CodeGen::CodeGenFunction::EmitCallArgs", NM="Tpl__ZN5clang7CodeGen15CodeGenFunction12EmitCallArgsERNS0_11CallArgListEPKT_N4llvm14iterator_rangeINS_4Stmt17ConstExprIteratorEEEPKNS_12FunctionDeclEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=Tpl__ZN5clang7CodeGen15CodeGenFunction12EmitCallArgsERNS0_11CallArgListEPKT_N4llvm14iterator_rangeINS_4Stmt17ConstExprIteratorEEEPKNS_12FunctionDeclEj")
  //</editor-fold>
  public final </*typename*/ T extends ParamType> void EmitCallArgs(final CallArgList /*&*/ Args, /*const*/ T /*P*/ CallArgTypeInfo, 
              iterator_range</*const*/ Expr /*P*/ /*const*/> ArgRange) {
    EmitCallArgs(Args, CallArgTypeInfo, 
              ArgRange, 
              (/*const*/ FunctionDecl /*P*/ )null, 
              0);
  }
  public final </*typename*/ T extends ParamType> void EmitCallArgs(final CallArgList /*&*/ Args, /*const*/ T /*P*/ CallArgTypeInfo, 
              iterator_range</*const*/ Expr /*P*/ /*const*/> ArgRange, 
              /*const*/ FunctionDecl /*P*/ CalleeDecl/*= null*/) {
    EmitCallArgs(Args, CallArgTypeInfo, 
              ArgRange, 
              CalleeDecl, 
              0);
  }
  public final </*typename*/ T extends ParamType> void EmitCallArgs(final CallArgList /*&*/ Args, /*const*/ T /*P*/ CallArgTypeInfo, 
              iterator_range</*const*/ Expr /*P*/ /*const*/> ArgRange, 
              /*const*/ FunctionDecl /*P*/ CalleeDecl/*= null*/, 
              /*uint*/int ParamsToSkip/*= 0*/) {
    SmallVector<QualType> ArgTypes/*J*/= new SmallVector<QualType>(16, new QualType());
    Stmt.ConstExprIterator Arg = ((Stmt.ConstExprIterator)ArgRange.begin());
    assert Native.$bool((ParamsToSkip == 0 || CallArgTypeInfo != null)) : "Can't skip parameters if type info is not provided";
    if (CallArgTypeInfo != null) {
      boolean isGenericMethod = isObjCMethodWithTypeParams(CallArgTypeInfo);
      
      // First, use the argument types that the type info knows about
      for (type$ptr<QualType> I = CallArgTypeInfo.param_type_begin().$add(ParamsToSkip), 
          E = CallArgTypeInfo.param_type_end();
           Native.$noteq_ptr(I, E); I.$preInc() , Arg.$preInc()) {
        assert (Arg.$noteq(((Stmt.ConstExprIterator)ArgRange.end()))) : "Running over edge of argument list!";
        assert isGenericMethod ||
               I.$star().$star().isVariablyModifiedType() ||
               I.$star().getNonReferenceType().$star().isObjCRetainableType() || 
               Native.$eq(getContext().getCanonicalType(I.$star().getNonReferenceType()).getTypePtr(),
                          getContext().getCanonicalType((Arg.$star()).getType()).getTypePtr()) : "type mismatch in call argument!";
        ArgTypes.push_back(I.$star());
      }
    }
    
    // Either we've emitted all the call args, or we have a call to variadic
    // function.
    assert Arg.$eq(ArgRange.end()) || 
           Native.$not(CallArgTypeInfo) || 
           CallArgTypeInfo.isVariadic() : "Extra arguments in non-variadic function!";
    
    // If we still have any arguments, emit them using the type of the argument.
    Iterator<Expr> iterator = new JavaIterator<Expr>(Arg, ArgRange.end());
    while(iterator.hasNext()) {
      ArgTypes.push_back(getVarArgType(iterator.next()));
    }
    
    EmitCallArgs1(Args, new ArrayRef<QualType>(ArgTypes, false), new iterator_range</*const*/ Expr /*P*/ /*const*/>(ArgRange), CalleeDecl, ParamsToSkip);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::getTargetHooks">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 3393,
   FQN="clang::CodeGen::CodeGenFunction::getTargetHooks", NM="_ZNK5clang7CodeGen15CodeGenFunction14getTargetHooksEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZNK5clang7CodeGen15CodeGenFunction14getTargetHooksEv")
  //</editor-fold>
  protected/*private*/ final /*const*/ TargetCodeGenInfo /*&*/ getTargetHooks() /*const*/ {
    return CGM.getTargetCodeGenInfo();
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @FunctionalInterface public static interface AddressQualType2Void {
    void $call(CodeGenFunction $this, Address addr, QualType t);
  }
  
  @FunctionalInterface public static interface Address2Value {
    Value /*P*/ $call(CodeGenFunction $this, Address /*P*/ addr);
  }
  
  @FunctionalInterface public static interface ValueProducer {
    Value /*P*/ $call(CodeGenFunction $this);
  }
  
  @FunctionalInterface public static interface Value2Value {
    Value /*P*/ $call(CodeGenFunction $this, Value /*P*/ val);
  }
  
  @FunctionalInterface public static interface ValueQualType2Void {
    void $call(CodeGenFunction $this, Value /*P*/ val, QualType t);
  }
  
  @FunctionalInterface public static interface ValueOMPTaskDataTy2Void {
    void $call(CodeGenFunction $this, Value /*P*/ val, OMPTaskDataTy /*&*/ t);
  }
  
  @FunctionalInterface public static interface GenFun {
    void $call(CodeGenFunction $this);
  }
  
  @FunctionalInterface public static interface ThreeExpr2Void {
    void $call(CodeGenFunction /*&*/ $this, 
            /*const*/ Expr /*P*/ e1, 
            /*const*/ Expr /*P*/ e2, 
            /*const*/ Expr /*P*/ e3);
  }
  
  public type$ref<Instruction /*P*/> CurrentFuncletPad_ref = new type$ref<Instruction /*P*/>(){
    @Override
    public Instruction $deref() {
      return CurrentFuncletPad;
    }
  
    @Override
    public Instruction $set(Instruction value) {
      CurrentFuncletPad = value;
      return CurrentFuncletPad;
    }
  };
  
  public type$ref<FieldDecl /*P*/> LambdaThisCaptureField_ref = new type$ref<FieldDecl /*P*/>(){
    @Override
    public FieldDecl $deref() {
      return LambdaThisCaptureField;
    }
  
    @Override
    public FieldDecl $set(FieldDecl value) {
      LambdaThisCaptureField = value;
      return LambdaThisCaptureField;
    }
  };
  
  protected type$ref<ImplicitParamDecl> CXXStructorImplicitParamDecl_ref = new type$ref<ImplicitParamDecl>(){
    @Override
    public ImplicitParamDecl $deref() {
      return CXXStructorImplicitParamDecl;
    }
  
    @Override
    public ImplicitParamDecl $set(ImplicitParamDecl value) {
      CXXStructorImplicitParamDecl = value;
      return CXXStructorImplicitParamDecl;
    }
  
  };

  protected type$ref<Value /*P*/> CXXStructorImplicitParamValue_ref = new type$ref<Value /*P*/>() {
    @Override
    public Value $deref() {
      return CXXStructorImplicitParamValue;
    }

    @Override
    public Value $set(Value value) {
      CXXStructorImplicitParamValue = value;
      return CXXStructorImplicitParamValue;
    }
  };
  
  @Converted(kind = Converted.Kind.MANUAL_INSTANTIATION)
  public final </*typename*/ T extends ParamTypeObjC> void EmitCallArgs(final CallArgList /*&*/ Args, /*const*/ T /*P*/ CallArgTypeInfo, 
              iterator_range</*const*/ Expr /*P*/ /*const*/> ArgRange) {
    EmitCallArgs(Args, CallArgTypeInfo, 
              ArgRange, 
              (/*const*/ FunctionDecl /*P*/ )null, 
              0);
  }
  public final </*typename*/ T extends ParamTypeObjC> void EmitCallArgs(final CallArgList /*&*/ Args, /*const*/ T /*P*/ CallArgTypeInfo, 
              iterator_range</*const*/ Expr /*P*/ /*const*/> ArgRange, 
              /*const*/ FunctionDecl /*P*/ CalleeDecl/*= null*/) {
    EmitCallArgs(Args, CallArgTypeInfo, 
              ArgRange, 
              CalleeDecl, 
              0);
  }
  public final </*typename*/ T extends ParamTypeObjC> void EmitCallArgs(final CallArgList /*&*/ Args, /*const*/ T /*P*/ CallArgTypeInfo, 
              iterator_range</*const*/ Expr /*P*/ /*const*/> ArgRange, 
              /*const*/ FunctionDecl /*P*/ CalleeDecl/*= null*/, 
              /*uint*/int ParamsToSkip/*= 0*/) {
    SmallVector<QualType> ArgTypes/*J*/= new SmallVector<QualType>(16, new QualType());
    Stmt.ConstExprIterator Arg = ((Stmt.ConstExprIterator)ArgRange.begin());
    assert Native.$bool((ParamsToSkip == 0 || CallArgTypeInfo != null)) : "Can't skip parameters if type info is not provided";
    if (CallArgTypeInfo != null) {
      boolean isGenericMethod = isObjCMethodWithTypeParams((ObjCMethodDecl)CallArgTypeInfo);
  
      // First, use the argument types that the type info knows about
      for (mapped_iterator<ParmVarDecl/*P*/, QualType> I = CallArgTypeInfo.param_type_begin().$add(ParamsToSkip), 
          E = CallArgTypeInfo.param_type_end();
           Native.$noteq_ptr(I, E); I.$preInc() , Arg.$preInc()) {
        assert (Arg.$noteq(((Stmt.ConstExprIterator)ArgRange.end()))) : "Running over edge of argument list!";
        assert isGenericMethod ||
               I.$star().$star().isVariablyModifiedType() ||
               I.$star().getNonReferenceType().$star().isObjCRetainableType() || 
               Native.$eq(getContext().getCanonicalType(I.$star().getNonReferenceType()).getTypePtr(),
                          getContext().getCanonicalType((Arg.$star()).getType()).getTypePtr()) : "type mismatch in call argument!";
        ArgTypes.push_back((QualType)I.$star());
      }
    }
  
    // Either we've emitted all the call args, or we have a call to variadic
    // function.
    assert Arg.$eq(ArgRange.end()) || 
           Native.$not(CallArgTypeInfo) || 
           CallArgTypeInfo.isVariadic() : "Extra arguments in non-variadic function!";
  
    // If we still have any arguments, emit them using the type of the argument.
    Iterator<Expr> iterator = new JavaIterator<Expr>(Arg, ArgRange.end());
    while(iterator.hasNext()) {
      ArgTypes.push_back(getVarArgType(iterator.next()));
    }
  
    EmitCallArgs1(Args, new ArrayRef<QualType>(ArgTypes, false), new iterator_range</*const*/ Expr /*P*/ /*const*/>(ArgRange), CalleeDecl, ParamsToSkip);
  }
  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::CodeGenFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.h", line = 106,
   FQN="clang::CodeGen::CodeGenFunction::CodeGenFunction", NM="_ZN5clang7CodeGen15CodeGenFunctionC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp -nm=_ZN5clang7CodeGen15CodeGenFunctionC1ERKS1_")
  //</editor-fold>
  protected/*private*/ CodeGenFunction(final /*const*/ CodeGenFunction /*&*/ $Prm0) {  super(null); throw new UnsupportedOperationException("Deleted");}
  
  /*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::CodeGenFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp", line = 40,
   FQN="clang::CodeGen::CodeGenFunction::CodeGenFunction", NM="_ZN5clang7CodeGen15CodeGenFunctionC1ERNS0_13CodeGenModuleEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp -nm=_ZN5clang7CodeGen15CodeGenFunctionC1ERNS0_13CodeGenModuleEb")
  //</editor-fold>
  public CodeGenFunction(final CodeGenModule /*&*/ cgm) {
    this(cgm, false);
  }
  public CodeGenFunction(final CodeGenModule /*&*/ cgm, boolean suppressNewContext/*= false*/) {
    // : CodeGenTypeCache(cgm), CGM(cgm), Target(cgm.getTarget()), LoopStack(), Builder(cgm, cgm.getModule().getContext(), ConstantFolder(), CGBuilderInserterTy(this)), FnRetTy(), CurFn(null), CurGD(), PrologueCleanupDepth(), ReturnBlock(), ReturnValue(Address::invalid()), AllocaInsertPt(), CapturedStmtInfo(null), SanOpts(CGM.getLangOpts().Sanitize), IsSanitizerScope(false), CurFuncIsThunk(false), AutoreleaseResult(false), SawAsmBlock(false), CurSEHParent(null), IsOutlinedSEHHelper(false), BlockInfo(null), BlockPointer(null), LambdaCaptureFields(), LambdaThisCaptureField(null), NRVOFlags(), EHStack(), LifetimeExtendedCleanupStack(), SEHTryEpilogueStack(), CurrentFuncletPad(null), NormalCleanupDest(null), NextCleanupDestIndex(1), FirstBlockInfo(null), EHResumeBlock(null), ExceptionSlot(null), EHSelectorSlot(null), SEHCodeSlotStack(), SEHInfo(null), ObjCEHValueStack(), DebugInfo(CGM.getModuleDebugInfo()), DisableDebugInfo(false), DidCallStackSave(false), IndirectBranch(null), LocalDeclMap(), SizeArguments(), EscapedLocals(), LabelMap(), BreakContinueStack(), PGO(cgm), SwitchInsn(null), SwitchWeights(null), CaseRangeBlock(null), OpaqueLValues(), OpaqueRValues(), VLASizeMap(), UnreachableBlock(null), NumReturnExprs(0), NumSimpleReturnExprs(0), LastStopPoint(), CXXABIThisDecl(null), CXXABIThisValue(null), CXXThisValue(null), CXXABIThisAlignment(), CXXThisAlignment(), CXXDefaultInitExprThis(Address::invalid()), CXXInheritedCtorInitExprArgs(), CXXStructorImplicitParamDecl(null), CXXStructorImplicitParamValue(null), OutermostConditional(null), CurLexicalScope(null), CurEHLocation(), BlockByrefInfos(), TerminateLandingPad(null), TerminateHandler(null), TrapBB(null), DeferredReplacements() 
    //START JInit
    super(cgm);
    this./*&*/CGM=/*&*/cgm;
    this./*&*/Target=/*&*/cgm.getTarget();
    this.LoopStack = new LoopInfoStack();
    this.Builder = new CGBuilderTy(cgm, cgm.getModule().getContext(), new ConstantFolder(), 
        new CGBuilderInserter(this));
    this.FnRetTy = new QualType();
    this.CurFn = null;
    this.CurGD = new GlobalDecl();
    this.PrologueCleanupDepth = new EHScopeStack.stable_iterator();
    this.ReturnBlock = new JumpDest();
    this.ReturnValue = Address.invalid();
    this.AllocaInsertPt = new AssertingVH<Instruction>();
    this.CapturedStmtInfo = null;
    this.SanOpts = new SanitizerSet(CGM.getLangOpts().Sanitize);
    this.IsSanitizerScope = false;
    this.CurFuncIsThunk = false;
    this.AutoreleaseResult = false;
    this.SawAsmBlock = false;
    /*InClass*/this.CurSEHParent = null;
    this.IsOutlinedSEHHelper = false;
    this.BlockInfo = null;
    this.BlockPointer = null;
    this.LambdaCaptureFields = new DenseMap</*const*/ VarDecl /*P*/ , FieldDecl /*P*/ >(DenseMapInfo$LikePtr.$Info(), (FieldDecl /*P*/ )null);
    this.LambdaThisCaptureField = null;
    this.NRVOFlags = new DenseMap</*const*/ VarDecl /*P*/ , Value /*P*/ >(DenseMapInfo$LikePtr.$Info(), (Value /*P*/ )null);
    this.EHStack = new EHScopeStack();
    this.LifetimeExtendedCleanupStack = new SmallString(256);
    this.SEHTryEpilogueStack = new SmallVector</*const*/ JumpDest /*P*/ >(2, (/*const*/ JumpDest /*P*/ )null);
    /*InClass*/this.CurrentFuncletPad = null;
    this.NormalCleanupDest = null;
    this.NextCleanupDestIndex = 1;
    this.FirstBlockInfo = null;
    this.EHResumeBlock = null;
    this.ExceptionSlot = null;
    this.EHSelectorSlot = null;
    this.SEHCodeSlotStack = new SmallVector<Address>(1, new Address());
    /*InClass*/this.SEHInfo = null;
    this.ObjCEHValueStack = new SmallVector<Value /*P*/ >(8, (Value /*P*/ )null);
    this.DebugInfo = CGM.getModuleDebugInfo();
    this.DisableDebugInfo = false;
    this.DidCallStackSave = false;
    this.IndirectBranch = null;
    this.LocalDeclMap = new DenseMap</*const*/ Decl /*P*/ , Address>(DenseMapInfo$LikePtr.$Info(), new Address());
    this.SizeArguments = new SmallDenseMap</*const*/ ParmVarDecl /*P*/ , /*const*/ ImplicitParamDecl /*P*/ >(DenseMapInfo$LikePtr.$Info(), 2, (/*const*/ ImplicitParamDecl /*P*/ )null);
    this.EscapedLocals = new DenseMapTypeInt<AllocaInst /*P*/ >(DenseMapInfo$LikePtr.$Info(), 0);
    this.LabelMap = new DenseMap</*const*/ LabelDecl /*P*/ , JumpDest>(DenseMapInfo$LikePtr.$Info(), new JumpDest());
    this.BreakContinueStack = new SmallVector<BreakContinue>(8, new BreakContinue());
    this.PGO = new CodeGenPGO(cgm);
    this.SwitchInsn = null;
    this.SwitchWeights = null;
    this.CaseRangeBlock = null;
    this.OpaqueLValues = new DenseMap</*const*/ OpaqueValueExpr /*P*/ , LValue>(DenseMapInfo$LikePtr.$Info(), new LValue());
    this.OpaqueRValues = new DenseMap</*const*/ OpaqueValueExpr /*P*/ , RValue>(DenseMapInfo$LikePtr.$Info(), new RValue());
    this.VLASizeMap = new DenseMap</*const*/ Expr /*P*/ , Value /*P*/ >(DenseMapInfo$LikePtr.$Info(), (Value /*P*/ )null);
    this.UnreachableBlock = null;
    this.NumReturnExprs = 0;
    this.NumSimpleReturnExprs = 0;
    this.LastStopPoint = new SourceLocation();
    this.CXXABIThisDecl = null;
    this.CXXABIThisValue = null;
    this.CXXThisValue = null;
    this.CXXABIThisAlignment = new CharUnits();
    this.CXXThisAlignment = new CharUnits();
    /*InClass*/this.CXXDefaultInitExprThis = Address.invalid();
    this.CXXInheritedCtorInitExprArgs = new CallArgList();
    this.CXXStructorImplicitParamDecl = null;
    this.CXXStructorImplicitParamValue = null;
    this.OutermostConditional = null;
    this.CurLexicalScope = null;
    this.CurEHLocation = new SourceLocation();
    this.BlockByrefInfos = new DenseMap</*const*/ ValueDecl /*P*/ , BlockByrefInfo>(DenseMapInfo$LikePtr.$Info(), new BlockByrefInfo());
    this.TerminateLandingPad = null;
    this.TerminateHandler = null;
    this.TrapBB = null;
    this.DeferredReplacements = new SmallVector<std.pair<Instruction /*P*/ , Value /*P*/ >>(4, new std.pairPtrPtr<Instruction /*P*/ , Value /*P*/ >());
    //END JInit
    if (!suppressNewContext) {
      CGM.getCXXABI().getMangleContext().startNewFunction();
    }
  
    FastMathFlags FMF/*J*/= new FastMathFlags();
    if (CGM.getLangOpts().FastMath) {
      FMF.setUnsafeAlgebra();
    }
    if (CGM.getLangOpts().FiniteMathOnly) {
      FMF.setNoNaNs();
      FMF.setNoInfs();
    }
    if (CGM.getCodeGenOpts().NoNaNsFPMath) {
      FMF.setNoNaNs();
    }
    if (CGM.getCodeGenOpts().NoSignedZeros) {
      FMF.setNoSignedZeros();
    }
    if (CGM.getCodeGenOpts().ReciprocalMath) {
      FMF.setAllowReciprocal();
    }
    Builder.setFastMathFlags(new FastMathFlags(FMF));
  }
  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::~CodeGenFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp", line = 85,
   FQN="clang::CodeGen::CodeGenFunction::~CodeGenFunction", NM="_ZN5clang7CodeGen15CodeGenFunctionD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp -nm=_ZN5clang7CodeGen15CodeGenFunctionD0Ev")
  //</editor-fold>
  public void $destroy() {
    assert (LifetimeExtendedCleanupStack.empty()) : "failed to emit a cleanup";
  
    // If there are any unclaimed block infos, go ahead and destroy them
    // now.  This can happen if IR-gen gets clever and skips evaluating
    // something.
    if ((FirstBlockInfo != null)) {
      CodeGenFunction.destroyBlockInfos(FirstBlockInfo);
    }
    if ((getLangOpts().OpenMP != 0)) {
      CGM.getOpenMPRuntime().functionFinished(/*Deref*/this);
    }
    //START JDestroy
    DeferredReplacements.$destroy();
    BlockByrefInfos.$destroy();
    CXXInheritedCtorInitExprArgs.$destroy();
    VLASizeMap.$destroy();
    OpaqueRValues.$destroy();
    OpaqueLValues.$destroy();
    PGO.$destroy();
    BreakContinueStack.$destroy();
    LabelMap.$destroy();
    EscapedLocals.$destroy();
    SizeArguments.$destroy();
    LocalDeclMap.$destroy();
    ObjCEHValueStack.$destroy();
    SEHCodeSlotStack.$destroy();
    SEHTryEpilogueStack.$destroy();
    LifetimeExtendedCleanupStack.$destroy();
    EHStack.$destroy();
    NRVOFlags.$destroy();
    LambdaCaptureFields.$destroy();
    AllocaInsertPt.$destroy();
    Builder.$destroy();
    LoopStack.$destroy();
    //super.$destroy();
    //END JDestroy
  }

  public static </*typename*/ T> boolean isObjCMethodWithTypeParams(/*const*/ T /*P*/ $Prm0) {
    return ($Prm0 instanceof ObjCMethodDecl) ? isObjCMethodWithTypeParams((ObjCMethodDecl)$Prm0) : isObjCMethodWithTypeParams$T($Prm0);
  }
  
  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "CGM=" + CGM // NOI18N
              + ", Target=" + Target // NOI18N
              + ", LoopStack=" + LoopStack // NOI18N
              + ", Builder=" + Builder // NOI18N
              + ", CurFuncDecl=" + "[Decl]" // NOI18N
              + ", CurCodeDecl=" + "[Decl]" // NOI18N
              + ", CurFnInfo=" + CurFnInfo // NOI18N
              + ", FnRetTy=" + FnRetTy // NOI18N
              + ", CurFn=" + CurFn // NOI18N
              + ", CurGD=" + "[GlobalDecl]" // NOI18N
              + ", PrologueCleanupDepth=" + PrologueCleanupDepth // NOI18N
              + ", ReturnBlock=" + ReturnBlock // NOI18N
              + ", ReturnValue=" + ReturnValue // NOI18N
              + ", AllocaInsertPt=" + AllocaInsertPt // NOI18N
              + ", CapturedStmtInfo=" + CapturedStmtInfo // NOI18N
              + ", SanOpts=" + SanOpts // NOI18N
              + ", IsSanitizerScope=" + IsSanitizerScope // NOI18N
              + ", CurFuncIsThunk=" + CurFuncIsThunk // NOI18N
              + ", AutoreleaseResult=" + AutoreleaseResult // NOI18N
              + ", SawAsmBlock=" + SawAsmBlock // NOI18N
              + ", CurSEHParent=" + "[FunctionDecl]" // NOI18N
              + ", IsOutlinedSEHHelper=" + IsOutlinedSEHHelper // NOI18N
              + ", BlockInfo=" + BlockInfo // NOI18N
              + ", BlockPointer=" + BlockPointer // NOI18N
              + ", LambdaCaptureFields=" + "[DenseMap$VarDecl$FieldDecl]" // NOI18N
              + ", LambdaThisCaptureField=" + "[FieldDecl]" // NOI18N
              + ", NRVOFlags=" + NRVOFlags // NOI18N
              + ", EHStack=" + EHStack // NOI18N
              + ", LifetimeExtendedCleanupStack=" + LifetimeExtendedCleanupStack // NOI18N
              + ", SEHTryEpilogueStack=" + SEHTryEpilogueStack // NOI18N
              + ", CurrentFuncletPad=" + CurrentFuncletPad // NOI18N
              + ", NormalCleanupDest=" + NormalCleanupDest // NOI18N
              + ", NextCleanupDestIndex=" + NextCleanupDestIndex // NOI18N
              + ", FirstBlockInfo=" + FirstBlockInfo // NOI18N
              + ", EHResumeBlock=" + EHResumeBlock // NOI18N
              + ", ExceptionSlot=" + ExceptionSlot // NOI18N
              + ", EHSelectorSlot=" + EHSelectorSlot // NOI18N
              + ", SEHCodeSlotStack=" + SEHCodeSlotStack // NOI18N
              + ", SEHInfo=" + SEHInfo // NOI18N
              + ", ObjCEHValueStack=" + ObjCEHValueStack // NOI18N
              + ", DebugInfo=" + DebugInfo // NOI18N
              + ", DisableDebugInfo=" + DisableDebugInfo // NOI18N
              + ", DidCallStackSave=" + DidCallStackSave // NOI18N
              + ", IndirectBranch=" + IndirectBranch // NOI18N
              + ", LocalDeclMap=" + LocalDeclMap // NOI18N
              + ", SizeArguments=" + "[SmallDenseMap$ParmVarDecl$ImplicitParamDecl]" // NOI18N
              + ", EscapedLocals=" + EscapedLocals // NOI18N
              + ", LabelMap=" + LabelMap // NOI18N
              + ", BreakContinueStack=" + BreakContinueStack // NOI18N
              + ", PGO=" + PGO // NOI18N
              + ", SwitchInsn=" + SwitchInsn // NOI18N
              + ", SwitchWeights=" + SwitchWeights // NOI18N
              + ", CaseRangeBlock=" + CaseRangeBlock // NOI18N
              + ", OpaqueLValues=" + OpaqueLValues // NOI18N
              + ", OpaqueRValues=" + OpaqueRValues // NOI18N
              + ", VLASizeMap=" + VLASizeMap // NOI18N
              + ", UnreachableBlock=" + UnreachableBlock // NOI18N
              + ", NumReturnExprs=" + NumReturnExprs // NOI18N
              + ", NumSimpleReturnExprs=" + NumSimpleReturnExprs // NOI18N
              + ", LastStopPoint=" + LastStopPoint // NOI18N
              + ", CXXABIThisDecl=" + "[ImplicitParamDecl]" // NOI18N
              + ", CXXABIThisValue=" + CXXABIThisValue // NOI18N
              + ", CXXThisValue=" + CXXThisValue // NOI18N
              + ", CXXABIThisAlignment=" + CXXABIThisAlignment // NOI18N
              + ", CXXThisAlignment=" + CXXThisAlignment // NOI18N
              + ", CXXDefaultInitExprThis=" + CXXDefaultInitExprThis // NOI18N
              + ", CXXInheritedCtorInitExprArgs=" + CXXInheritedCtorInitExprArgs // NOI18N
              + ", CXXStructorImplicitParamDecl=" + "[ImplicitParamDecl]" // NOI18N
              + ", CXXStructorImplicitParamValue=" + CXXStructorImplicitParamValue // NOI18N
              + ", OutermostConditional=" + OutermostConditional // NOI18N
              + ", CurLexicalScope=" + CurLexicalScope // NOI18N
              + ", CurEHLocation=" + CurEHLocation // NOI18N
              + ", BlockByrefInfos=" + BlockByrefInfos // NOI18N
              + ", TerminateLandingPad=" + TerminateLandingPad // NOI18N
              + ", TerminateHandler=" + TerminateHandler // NOI18N
              + ", TrapBB=" + TrapBB // NOI18N
              + ", DeferredReplacements=" + DeferredReplacements // NOI18N
              + super.toString(); // NOI18N
  }
}
