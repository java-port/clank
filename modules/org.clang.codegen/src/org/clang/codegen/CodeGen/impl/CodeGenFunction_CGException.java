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
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import static org.clang.basic.BasicClangGlobals.*;
import org.llvm.ir.*;
import org.clang.codegen.impl.*;
import org.clang.codegen.CodeGen.*;
import org.llvm.ir.ArrayType;
import org.llvm.ir.FunctionType;
import org.llvm.ir.Type;
import org.llvm.ir.intrinsic.ID;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import org.clang.codegen.CodeGen.impl.EHScopeStack.stable_iterator;
import static org.clang.codegen.impl.CGExceptionStatics.*;
import static org.clang.codegen.java.CodegenRTTI.*;
import static org.llvm.ir.intrinsic.IntrinsicGlobals.*;
import static org.llvm.ir.java.IrRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type CodeGenFunction_CGException">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 NM="org.clang.codegen.CodeGen.impl.CodeGenFunction_CGException",        
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this -extends=CodeGenFunction_CGDeclCXX ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction13EmitEndEHSpecEPKNS_4DeclE;_ZN5clang7CodeGen15CodeGenFunction13popCatchScopeEv;_ZN5clang7CodeGen15CodeGenFunction14EmitCXXTryStmtERKNS_10CXXTryStmtE;_ZN5clang7CodeGen15CodeGenFunction14EmitLandingPadEv;_ZN5clang7CodeGen15CodeGenFunction14EmitSEHTryStmtERKNS_10SEHTryStmtE;_ZN5clang7CodeGen15CodeGenFunction14ExitCXXTryStmtERKNS_10CXXTryStmtEb;_ZN5clang7CodeGen15CodeGenFunction14ExitSEHTryStmtERKNS_10SEHTryStmtE;_ZN5clang7CodeGen15CodeGenFunction15EmitStartEHSpecEPKNS_4DeclE;_ZN5clang7CodeGen15CodeGenFunction15EnterCXXTryStmtERKNS_10CXXTryStmtEb;_ZN5clang7CodeGen15CodeGenFunction15EnterSEHTryStmtERKNS_10SEHTryStmtE;_ZN5clang7CodeGen15CodeGenFunction16EmitAnyExprToExnEPKNS_4ExprENS0_7AddressE;_ZN5clang7CodeGen15CodeGenFunction16EmitCXXThrowExprEPKNS_12CXXThrowExprEb;_ZN5clang7CodeGen15CodeGenFunction16EmitSEHLeaveStmtERKNS_12SEHLeaveStmtE;_ZN5clang7CodeGen15CodeGenFunction16getEHResumeBlockEb;_ZN5clang7CodeGen15CodeGenFunction16getExceptionSlotEv;_ZN5clang7CodeGen15CodeGenFunction17getEHSelectorSlotEv;_ZN5clang7CodeGen15CodeGenFunction17getInvokeDestImplEv;_ZN5clang7CodeGen15CodeGenFunction18EmitCapturedLocalsERS1_PKNS_4StmtEb;_ZN5clang7CodeGen15CodeGenFunction18getEHDispatchBlockENS0_12EHScopeStack15stable_iteratorE;_ZN5clang7CodeGen15CodeGenFunction19getSelectorFromSlotEv;_ZN5clang7CodeGen15CodeGenFunction19getTerminateHandlerEv;_ZN5clang7CodeGen15CodeGenFunction20EmitSEHExceptionCodeEv;_ZN5clang7CodeGen15CodeGenFunction20EmitSEHExceptionInfoEv;_ZN5clang7CodeGen15CodeGenFunction20getExceptionFromSlotEv;_ZN5clang7CodeGen15CodeGenFunction20getMSVCDispatchBlockENS0_12EHScopeStack15stable_iteratorE;_ZN5clang7CodeGen15CodeGenFunction22getTerminateLandingPadEv;_ZN5clang7CodeGen15CodeGenFunction22startOutlinedSEHHelperERS1_bPKNS_4StmtE;_ZN5clang7CodeGen15CodeGenFunction24EmitSEHExceptionCodeSaveERS1_PN4llvm5ValueES5_;_ZN5clang7CodeGen15CodeGenFunction25GenerateSEHFilterFunctionERS1_RKNS_13SEHExceptStmtE;_ZN5clang7CodeGen15CodeGenFunction25recoverAddrOfEscapedLocalERS1_NS0_7AddressEPN4llvm5ValueE;_ZN5clang7CodeGen15CodeGenFunction26EmitSEHAbnormalTerminationEv;_ZN5clang7CodeGen15CodeGenFunction26GenerateSEHFinallyFunctionERS1_RKNS_14SEHFinallyStmtE; -static-type=CodeGenFunction_CGException -package=org.clang.codegen.CodeGen.impl")
//</editor-fold>
public abstract class CodeGenFunction_CGException extends CodeGenFunction_CGDeclCXX {
private final /*split clang::CodeGen::CodeGenFunction*/ CodeGenFunction $this() { return (CodeGenFunction)this; }
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::CodeGenFunction">
@Converted(kind = Converted.Kind.MANUAL_ADDED,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp", line = 40,
 FQN="clang::CodeGen::CodeGenFunction::CodeGenFunction", NM="_ZN5clang7CodeGen15CodeGenFunctionC1ERNS0_13CodeGenModuleEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp -nm=_ZN5clang7CodeGen15CodeGenFunctionC1ERNS0_13CodeGenModuleEb")
//</editor-fold>
protected CodeGenFunction_CGException(final CodeGenModule /*&*/ cgm) {
  super(cgm);
}


/// Emits a landing pad for the current EH stack.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitLandingPad">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp", line = 731,
 FQN="clang::CodeGen::CodeGenFunction::EmitLandingPad", NM="_ZN5clang7CodeGen15CodeGenFunction14EmitLandingPadEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction14EmitLandingPadEv")
//</editor-fold>
public final BasicBlock /*P*/ EmitLandingPad() {
  ApplyDebugLocation DL = null;
  try {
    assert ($this().EHStack.requiresLandingPad());
    
    final EHScope /*&*/ innermostEHScope = $this().EHStack.find($this().EHStack.getInnermostEHScope()).$star();
    switch (innermostEHScope.getKind()) {
     case Terminate:
      return $this().getTerminateLandingPad();
     case PadEnd:
      throw new llvm_unreachable("PadEnd unnecessary for Itanium!");
     case Catch:
     case Cleanup:
     case Filter:
      {
        BasicBlock /*P*/ lpad = innermostEHScope.getCachedLandingPad();
        if ((lpad != null)) {
          return lpad;
        }
      }
    }
    
    // Save the current IR generation state.
    CGBuilderTy.InsertPoint savedIP = $this().Builder.saveAndClearIP();
    DL = ApplyDebugLocation.CreateDefaultArtificial(/*Deref*/$this(), new SourceLocation($this().CurEHLocation));
    
    // Create and configure the landing pad.
    BasicBlock /*P*/ lpad = $this().createBasicBlock(new Twine(/*KEEP_STR*/"lpad"));
    $this().EmitBlock(lpad);
    
    LandingPadInst /*P*/ LPadInst = $this().Builder.CreateLandingPad(StructType.get(Unnamed_field9.Int8PtrTy, Int32Ty, null), 0);
    
    Value /*P*/ LPadExn = $this().Builder.CreateExtractValue(LPadInst, new ArrayRefUInt(0));
    $this().Builder.CreateStore(LPadExn, $this().getExceptionSlot());
    Value /*P*/ LPadSel = $this().Builder.CreateExtractValue(LPadInst, new ArrayRefUInt(1));
    $this().Builder.CreateStore(LPadSel, $this().getEHSelectorSlot());
    
    // Save the exception pointer.  It's safe to use a single exception
    // pointer per function because EH cleanups can never have nested
    // try/catches.
    // Build the landingpad instruction.
    
    // Accumulate all the handlers in scope.
    boolean hasCatchAll = false;
    boolean hasCleanup = false;
    boolean hasFilter = false;
    SmallVector<Value /*P*/ > filterTypes/*J*/= new SmallVector<Value /*P*/ >(4, (Value /*P*/ )null);
    SmallPtrSet<Value /*P*/ > catchTypes/*J*/= new SmallPtrSet<Value /*P*/ >(DenseMapInfo$LikePtr.$Info(), 4);
    done: for (EHScopeStack.iterator I = $this().EHStack.begin(), E = $this().EHStack.end(); I.$noteq(/*NO_COPY*/E);
         I.$preInc()) {
      switch (I.$arrow().getKind()) {
       case Cleanup:
        // If we have a cleanup, remember that.
        hasCleanup = (hasCleanup || cast_EHCleanupScope(I.$star()).isEHCleanup());
        continue;
       case Filter:
        {
          assert (I.next().$eq($this().EHStack.end())) : "EH filter is not end of EH stack";
          assert (!hasCatchAll) : "EH filter reached after catch-all";
          
          // Filter scopes get added to the landingpad in weird ways.
          final EHFilterScope /*&*/ filter = cast_EHFilterScope(I.$star());
          hasFilter = true;
          
          // Add all the filter values.
          for (/*uint*/int i = 0, e = filter.getNumFilters(); i != e; ++i)  {
            filterTypes.push_back(filter.getFilter(i));
          }
          break done;
        }
       case Terminate:
        // Terminate scopes are basically catch-alls.
        assert (!hasCatchAll);
        hasCatchAll = true;
        break done;
       case Catch:
        break;
       case PadEnd:
        throw new llvm_unreachable("PadEnd unnecessary for Itanium!");
      }
      
      final EHCatchScope /*&*/ catchScope = cast_EHCatchScope(I.$star());
      for (/*uint*/int hi = 0, he = catchScope.getNumHandlers(); hi != he; ++hi) {
        EHCatchScope.Handler handler = new EHCatchScope.Handler(catchScope.getHandler(hi));
        assert (handler.Type.Flags == 0) : "landingpads do not support catch handler flags";
        
        // If this is a catch-all, register that and abort.
        if (!(handler.Type.RTTI != null)) {
          assert (!hasCatchAll);
          hasCatchAll = true;
          break done;
        }
        
        // Check whether we already have a handler for this type.
        if (catchTypes.insert(handler.Type.RTTI).second) {
          // If not, add it directly to the landingpad.
          LPadInst.addClause(handler.Type.RTTI);
        }
      }
    }
   //done:
    // If we have a catch-all, add null to the landingpad.
    assert (!(hasCatchAll && hasFilter));
    if (hasCatchAll) {
      LPadInst.addClause(CGExceptionStatics.getCatchAllValue(/*Deref*/$this()));
      // If we have an EH filter, we need to add those handlers in the
      // right place in the landingpad, which is to say, at the end.
    } else if (hasFilter) {
      // Create a filter expression: a constant array indicating which filter
      // types there are. The personality routine only lands here if the filter
      // doesn't match.
      SmallVector<Constant /*P*/ > Filters/*J*/= new SmallVector<Constant /*P*/ >(8, (Constant /*P*/ )null);
      org.llvm.ir.ArrayType /*P*/ AType = org.llvm.ir.ArrayType.get(!filterTypes.empty() ? filterTypes.$at(0).getType() : Unnamed_field9.Int8PtrTy, 
          $uint2ulong(filterTypes.size()));
      
      for (/*uint*/int i = 0, e = filterTypes.size(); i != e; ++i)  {
        Filters.push_back(cast_Constant(filterTypes.$at(i)));
      }
      Constant /*P*/ FilterArray = ConstantArray.get(AType, new ArrayRef<Constant /*P*/ >(Filters, true));
      LPadInst.addClause(FilterArray);
      
      // Also check whether we need a cleanup.
      if (hasCleanup) {
        LPadInst.setCleanup(true);
      }
      // Otherwise, signal that we at least have cleanups.
    } else if (hasCleanup) {
      LPadInst.setCleanup(true);
    }
    assert (($greater_uint(LPadInst.getNumClauses(), 0) || LPadInst.isCleanup())) : "landingpad instruction has no clauses!";
    
    // Tell the backend how to generate the landing pad.
    $this().Builder.CreateBr($this().getEHDispatchBlock($this().EHStack.getInnermostEHScope()));
    
    // Restore the old IR generation state.
    $this().Builder.restoreIP(new IRBuilderBase.InsertPoint(savedIP));
    
    return lpad;
  } finally {
    if (DL != null) { DL.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::getInvokeDestImpl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp", line = 685,
 FQN="clang::CodeGen::CodeGenFunction::getInvokeDestImpl", NM="_ZN5clang7CodeGen15CodeGenFunction17getInvokeDestImplEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction17getInvokeDestImplEv")
//</editor-fold>
public final BasicBlock /*P*/ getInvokeDestImpl() {
  assert ($this().EHStack.requiresLandingPad());
  assert (!$this().EHStack.empty());
  
  // If exceptions are disabled and SEH is not in use, then there is no invoke
  // destination. SEH "works" even if exceptions are off. In practice, this
  // means that C++ destructors and other EH cleanups don't run, which is
  // consistent with MSVC's behavior.
  final /*const*/ LangOptions /*&*/ LO = $this().CGM.getLangOpts();
  if (!LO.Exceptions) {
    if (!LO.Borland && !LO.MicrosoftExt) {
      return null;
    }
    if (!$this().currentFunctionUsesSEHTry()) {
      return null;
    }
  }
  
  // Check the innermost scope for a cached landing pad.  If this is
  // a non-EH cleanup, we'll check enclosing scopes in EmitLandingPad.
  BasicBlock /*P*/ LP = $this().EHStack.begin().$arrow().getCachedLandingPad();
  if ((LP != null)) {
    return LP;
  }
  
  final /*const*/ EHPersonality /*&*/ Personality = EHPersonality.get(/*Deref*/$this());
  if (!$this().CurFn.hasPersonalityFn()) {
    $this().CurFn.setPersonalityFn(CGExceptionStatics.getOpaquePersonalityFn($this().CGM, Personality));
  }
  if (Personality.usesFuncletPads()) {
    // We don't need separate landing pads in the funclet model.
    LP = $this().getEHDispatchBlock($this().EHStack.getInnermostEHScope());
  } else {
    // Build the landing pad for this scope.
    LP = $this().EmitLandingPad();
  }
  assert Native.$bool(LP);
  
  // Cache the landing pad on the innermost scope.  If this is a
  // non-EH scope, cache the landing pad on the enclosing scope, too.
  for (EHScopeStack.iterator ir = $this().EHStack.begin(); true; ir.$preInc()) {
    ir.$arrow().setCachedLandingPad(LP);
    if (!CGExceptionStatics.isNonEHScope(ir.$star())) {
      break;
    }
  }
  
  return LP;
}


/// popCatchScope - Pops the catch scope at the top of the EHScope
/// stack, emitting any required code (other than the catch handlers
/// themselves).
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::popCatchScope">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp", line = 996,
 FQN="clang::CodeGen::CodeGenFunction::popCatchScope", NM="_ZN5clang7CodeGen15CodeGenFunction13popCatchScopeEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction13popCatchScopeEv")
//</editor-fold>
public final void popCatchScope() {
  final EHCatchScope /*&*/ catchScope = cast_EHCatchScope($this().EHStack.begin().$star());
  if (catchScope.hasEHBranches()) {
    CGExceptionStatics.emitCatchDispatchBlock(/*Deref*/$this(), catchScope);
  }
  $this().EHStack.popCatch();
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::getEHResumeBlock">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp", line = 1353,
 FQN="clang::CodeGen::CodeGenFunction::getEHResumeBlock", NM="_ZN5clang7CodeGen15CodeGenFunction16getEHResumeBlockEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction16getEHResumeBlockEb")
//</editor-fold>
public final BasicBlock /*P*/ getEHResumeBlock(boolean isCleanup) {
  if (($this().EHResumeBlock != null)) {
    return $this().EHResumeBlock;
  }
  
  CGBuilderTy.InsertPoint SavedIP = $this().Builder.saveIP();
  
  // We emit a jump to a notional label at the outermost unwind state.
  $this().EHResumeBlock = $this().createBasicBlock(new Twine(/*KEEP_STR*/"eh.resume"));
  $this().Builder.SetInsertPoint($this().EHResumeBlock);
  
  final /*const*/ EHPersonality /*&*/ Personality = EHPersonality.get(/*Deref*/$this());
  
  // This can always be a call because we necessarily didn't find
  // anything on the EH stack which needs our help.
  /*const*/char$ptr/*char P*/ RethrowName = $tryClone(Personality.CatchallRethrowFn);
  if ($noteq_ptr(RethrowName, null) && !isCleanup) {
    $this().EmitRuntimeCall(CGExceptionStatics.getCatchallRethrowFn($this().CGM, new StringRef(RethrowName)), 
        new ArrayRef<Value /*P*/ >($this().getExceptionFromSlot(), true)).setDoesNotReturn();
    $this().Builder.CreateUnreachable();
    $this().Builder.restoreIP(new IRBuilderBase.InsertPoint(SavedIP));
    return $this().EHResumeBlock;
  }
  
  // Recreate the landingpad's return value for the 'resume' instruction.
  Value /*P*/ Exn = $this().getExceptionFromSlot();
  Value /*P*/ Sel = $this().getSelectorFromSlot();
  
  org.llvm.ir.Type /*P*/ LPadType = StructType.get(Exn.getType(), 
      Sel.getType(), null);
  Value /*P*/ LPadVal = UndefValue.get(LPadType);
  LPadVal = $this().Builder.CreateInsertValue(LPadVal, Exn, new ArrayRefUInt(0), new Twine(/*KEEP_STR*/"lpad.val"));
  LPadVal = $this().Builder.CreateInsertValue(LPadVal, Sel, new ArrayRefUInt(1), new Twine(/*KEEP_STR*/"lpad.val"));
  
  $this().Builder.CreateResume(LPadVal);
  $this().Builder.restoreIP(new IRBuilderBase.InsertPoint(SavedIP));
  return $this().EHResumeBlock;
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::getEHDispatchBlock">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp", line = 575,
 FQN="clang::CodeGen::CodeGenFunction::getEHDispatchBlock", NM="_ZN5clang7CodeGen15CodeGenFunction18getEHDispatchBlockENS0_12EHScopeStack15stable_iteratorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction18getEHDispatchBlockENS0_12EHScopeStack15stable_iteratorE")
//</editor-fold>
public final BasicBlock /*P*/ getEHDispatchBlock(EHScopeStack.stable_iterator si) {
  if (EHPersonality.get(/*Deref*/$this()).usesFuncletPads()) {
    return $this().getMSVCDispatchBlock(new EHScopeStack.stable_iterator(si));
  }
  
  // The dispatch block for the end of the scope chain is a block that
  // just resumes unwinding.
  if (stable_iterator.$eq_stable_iterator(/*NO_COPY*/si, $this().EHStack.stable_end())) {
    return $this().getEHResumeBlock(true);
  }
  
  // Otherwise, we should look at the actual scope.
  final EHScope /*&*/ scope = $this().EHStack.find(/*NO_COPY*/si).$star();
  
  BasicBlock /*P*/ dispatchBlock = scope.getCachedEHDispatchBlock();
  if (!(dispatchBlock != null)) {
    switch (scope.getKind()) {
     case Catch:
      {
        // Apply a special case to a single catch-all.
        final EHCatchScope /*&*/ catchScope = cast_EHCatchScope(scope);
        if (catchScope.getNumHandlers() == 1
           && catchScope.getHandler(0).isCatchAll()) {
          dispatchBlock = catchScope.getHandler(0).Block;
          // Otherwise, make a dispatch block.
        } else {
          dispatchBlock = $this().createBasicBlock(new Twine(/*KEEP_STR*/"catch.dispatch"));
        }
        break;
      }
     case Cleanup:
      dispatchBlock = $this().createBasicBlock(new Twine(/*KEEP_STR*/"ehcleanup"));
      break;
     case Filter:
      dispatchBlock = $this().createBasicBlock(new Twine(/*KEEP_STR*/"filter.dispatch"));
      break;
     case Terminate:
      dispatchBlock = $this().getTerminateHandler();
      break;
     case PadEnd:
      throw new llvm_unreachable("PadEnd unnecessary for Itanium!");
    }
    scope.setCachedEHDispatchBlock(dispatchBlock);
  }
  return dispatchBlock;
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::getMSVCDispatchBlock">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp", line = 625,
 FQN="clang::CodeGen::CodeGenFunction::getMSVCDispatchBlock", NM="_ZN5clang7CodeGen15CodeGenFunction20getMSVCDispatchBlockENS0_12EHScopeStack15stable_iteratorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction20getMSVCDispatchBlockENS0_12EHScopeStack15stable_iteratorE")
//</editor-fold>
public final BasicBlock /*P*/ getMSVCDispatchBlock(EHScopeStack.stable_iterator SI) {
  CGBuilderTy Builder = null;
  try {
    // Returning nullptr indicates that the previous dispatch block should unwind
    // to caller.
    if (stable_iterator.$eq_stable_iterator(/*NO_COPY*/SI, $this().EHStack.stable_end())) {
      return null;
    }
    
    // Otherwise, we should look at the actual scope.
    final EHScope /*&*/ EHS = $this().EHStack.find(/*NO_COPY*/SI).$star();
    
    BasicBlock /*P*/ DispatchBlock = EHS.getCachedEHDispatchBlock();
    if ((DispatchBlock != null)) {
      return DispatchBlock;
    }
    if (EHS.getKind() == EHScope.Kind.Terminate) {
      DispatchBlock = $this().getTerminateHandler();
    } else {
      DispatchBlock = $this().createBasicBlock();
    }
    Builder/*J*/= new CGBuilderTy(/*Deref*/$this(), DispatchBlock);
    switch (EHS.getKind()) {
     case Catch:
      DispatchBlock.setName(new Twine(/*KEEP_STR*/"catch.dispatch"));
      break;
     case Cleanup:
      DispatchBlock.setName(new Twine(/*KEEP_STR*/"ehcleanup"));
      break;
     case Filter:
      throw new llvm_unreachable("exception specifications not handled yet!");
     case Terminate:
      DispatchBlock.setName(new Twine(/*KEEP_STR*/"terminate"));
      break;
     case PadEnd:
      throw new llvm_unreachable("PadEnd dispatch block missing!");
    }
    EHS.setCachedEHDispatchBlock(DispatchBlock);
    return DispatchBlock;
  } finally {
    if (Builder != null) { Builder.$destroy(); }
  }
}


/// Returns a pointer to the function's exception object and selector slot,
/// which is assigned in every landing pad.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::getExceptionSlot">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp", line = 383,
 FQN="clang::CodeGen::CodeGenFunction::getExceptionSlot", NM="_ZN5clang7CodeGen15CodeGenFunction16getExceptionSlotEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction16getExceptionSlotEv")
//</editor-fold>
public final Address getExceptionSlot() {
  if (!($this().ExceptionSlot != null)) {
    $this().ExceptionSlot = $this().CreateTempAlloca(Unnamed_field9.Int8PtrTy, new Twine(/*KEEP_STR*/"exn.slot"));
  }
  return new Address($this().ExceptionSlot, /*J:ToBase*/super.getPointerAlign());
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::getEHSelectorSlot">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp", line = 389,
 FQN="clang::CodeGen::CodeGenFunction::getEHSelectorSlot", NM="_ZN5clang7CodeGen15CodeGenFunction17getEHSelectorSlotEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction17getEHSelectorSlotEv")
//</editor-fold>
public final Address getEHSelectorSlot() {
  if (!($this().EHSelectorSlot != null)) {
    $this().EHSelectorSlot = $this().CreateTempAlloca(Int32Ty, new Twine(/*KEEP_STR*/"ehselector.slot"));
  }
  return new Address($this().EHSelectorSlot, CharUnits.fromQuantity(4));
}


/// Returns the contents of the function's exception object and selector
/// slots.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::getExceptionFromSlot">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp", line = 395,
 FQN="clang::CodeGen::CodeGenFunction::getExceptionFromSlot", NM="_ZN5clang7CodeGen15CodeGenFunction20getExceptionFromSlotEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction20getExceptionFromSlotEv")
//</editor-fold>
public final Value /*P*/ getExceptionFromSlot() {
  return $this().Builder.CreateLoad($this().getExceptionSlot(), $("exn"));
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::getSelectorFromSlot">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp", line = 399,
 FQN="clang::CodeGen::CodeGenFunction::getSelectorFromSlot", NM="_ZN5clang7CodeGen15CodeGenFunction19getSelectorFromSlotEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction19getSelectorFromSlotEv")
//</editor-fold>
public final Value /*P*/ getSelectorFromSlot() {
  return $this().Builder.CreateLoad($this().getEHSelectorSlot(), $("sel"));
}


/// EmitStartEHSpec - Emit the start of the exception spec.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitStartEHSpec">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp", line = 424,
 FQN="clang::CodeGen::CodeGenFunction::EmitStartEHSpec", NM="_ZN5clang7CodeGen15CodeGenFunction15EmitStartEHSpecEPKNS_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction15EmitStartEHSpecEPKNS_4DeclE")
//</editor-fold>
public final void EmitStartEHSpec(/*const*/ Decl /*P*/ D) {
  if (!$this().CGM.getLangOpts().CXXExceptions) {
    return;
  }
  
  /*const*/ FunctionDecl /*P*/ FD = dyn_cast_or_null_FunctionDecl(D);
  if (!(FD != null)) {
    {
      // Check if CapturedDecl is nothrow and create terminate scope for it.
      /*const*/ CapturedDecl /*P*/ CD = dyn_cast_or_null_CapturedDecl(D);
      if ((CD != null)) {
        if (CD.isNothrow()) {
          $this().EHStack.pushTerminate();
        }
      }
    }
    return;
  }
  /*const*/ FunctionProtoType /*P*/ Proto = FD.getType().$arrow().getAs(FunctionProtoType.class);
  if (!(Proto != null)) {
    return;
  }
  
  ExceptionSpecificationType EST = Proto.getExceptionSpecType();
  if (isNoexceptExceptionSpec(EST)) {
    if (Proto.getNoexceptSpec($this().getContext()) == FunctionProtoType.NoexceptResult.NR_Nothrow) {
      // noexcept functions are simple terminate scopes.
      $this().EHStack.pushTerminate();
    }
  } else if (EST == ExceptionSpecificationType.EST_Dynamic || EST == ExceptionSpecificationType.EST_DynamicNone) {
    // TODO: Revisit exception specifications for the MS ABI.  There is a way to
    // encode these in an object file but MSVC doesn't do anything with it.
    if ($this().getTarget().getCXXABI().isMicrosoft()) {
      return;
    }
    /*uint*/int NumExceptions = Proto.getNumExceptions();
    EHFilterScope /*P*/ Filter = $this().EHStack.pushFilter(NumExceptions);
    
    for (/*uint*/int I = 0; I != NumExceptions; ++I) {
      QualType Ty = Proto.getExceptionType(I);
      QualType ExceptType = Ty.getNonReferenceType().getUnqualifiedType();
      Value /*P*/ EHType = $this().CGM.GetAddrOfRTTIDescriptor(new QualType(ExceptType), 
          /*ForEH=*/ true);
      Filter.setFilter(I, EHType);
    }
  }
}


/// EmitEndEHSpec - Emit the end of the exception spec.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitEndEHSpec">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp", line = 503,
 FQN="clang::CodeGen::CodeGenFunction::EmitEndEHSpec", NM="_ZN5clang7CodeGen15CodeGenFunction13EmitEndEHSpecEPKNS_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction13EmitEndEHSpecEPKNS_4DeclE")
//</editor-fold>
public final void EmitEndEHSpec(/*const*/ Decl /*P*/ D) {
  if (!$this().CGM.getLangOpts().CXXExceptions) {
    return;
  }
  
  /*const*/ FunctionDecl /*P*/ FD = dyn_cast_or_null_FunctionDecl(D);
  if (!(FD != null)) {
    {
      // Check if CapturedDecl is nothrow and pop terminate scope for it.
      /*const*/ CapturedDecl /*P*/ CD = dyn_cast_or_null_CapturedDecl(D);
      if ((CD != null)) {
        if (CD.isNothrow()) {
          $this().EHStack.popTerminate();
        }
      }
    }
    return;
  }
  /*const*/ FunctionProtoType /*P*/ Proto = FD.getType().$arrow().getAs(FunctionProtoType.class);
  if (!(Proto != null)) {
    return;
  }
  
  ExceptionSpecificationType EST = Proto.getExceptionSpecType();
  if (isNoexceptExceptionSpec(EST)) {
    if (Proto.getNoexceptSpec($this().getContext()) == FunctionProtoType.NoexceptResult.NR_Nothrow) {
      $this().EHStack.popTerminate();
    }
  } else if (EST == ExceptionSpecificationType.EST_Dynamic || EST == ExceptionSpecificationType.EST_DynamicNone) {
    // TODO: Revisit exception specifications for the MS ABI.  There is a way to
    // encode these in an object file but MSVC doesn't do anything with it.
    if ($this().getTarget().getCXXABI().isMicrosoft()) {
      return;
    }
    final EHFilterScope /*&*/ filterScope = cast_EHFilterScope($this().EHStack.begin().$star());
    CGExceptionStatics.emitFilterDispatchBlock(/*Deref*/$this(), filterScope);
    $this().EHStack.popFilter();
  }
}


/// getTerminateLandingPad - Return a landing pad that just calls terminate.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::getTerminateLandingPad">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp", line = 1286,
 FQN="clang::CodeGen::CodeGenFunction::getTerminateLandingPad", NM="_ZN5clang7CodeGen15CodeGenFunction22getTerminateLandingPadEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction22getTerminateLandingPadEv")
//</editor-fold>
public final BasicBlock /*P*/ getTerminateLandingPad() {
  if (($this().TerminateLandingPad != null)) {
    return $this().TerminateLandingPad;
  }
  
  CGBuilderTy.InsertPoint SavedIP = $this().Builder.saveAndClearIP();
  
  // This will get inserted at the end of the function.
  $this().TerminateLandingPad = $this().createBasicBlock(new Twine(/*KEEP_STR*/"terminate.lpad"));
  $this().Builder.SetInsertPoint($this().TerminateLandingPad);
  
  // Tell the backend that this is a landing pad.
  final /*const*/ EHPersonality /*&*/ Personality = EHPersonality.get(/*Deref*/$this());
  if (!$this().CurFn.hasPersonalityFn()) {
    $this().CurFn.setPersonalityFn(CGExceptionStatics.getOpaquePersonalityFn($this().CGM, Personality));
  }
  
  LandingPadInst /*P*/ LPadInst = $this().Builder.CreateLandingPad(StructType.get(Unnamed_field9.Int8PtrTy, Int32Ty, null), 0);
  LPadInst.addClause(CGExceptionStatics.getCatchAllValue(/*Deref*/$this()));
  
  Value /*P*/ Exn = null;
  if ($this().getLangOpts().CPlusPlus) {
    Exn = $this().Builder.CreateExtractValue(LPadInst, new ArrayRefUInt(0));
  }
  CallInst /*P*/ terminateCall = $this().CGM.getCXXABI().emitTerminateForUnexpectedException(/*Deref*/$this(), Exn);
  terminateCall.setDoesNotReturn();
  $this().Builder.CreateUnreachable();
  
  // Restore the saved insertion state.
  $this().Builder.restoreIP(new IRBuilderBase.InsertPoint(SavedIP));
  
  return $this().TerminateLandingPad;
}


/// getTerminateHandler - Return a handler (not a landing pad, just
/// a catch handler) that just calls terminate.  This is used when
/// a terminate scope encloses a try.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::getTerminateHandler">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp", line = 1320,
 FQN="clang::CodeGen::CodeGenFunction::getTerminateHandler", NM="_ZN5clang7CodeGen15CodeGenFunction19getTerminateHandlerEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction19getTerminateHandlerEv")
//</editor-fold>
public final BasicBlock /*P*/ getTerminateHandler() {
  SaveAndRestore<Instruction /*P*/ > RestoreCurrentFuncletPad = null;
  try {
    if (($this().TerminateHandler != null)) {
      return $this().TerminateHandler;
    }
    
    CGBuilderTy.InsertPoint SavedIP = $this().Builder.saveAndClearIP();
    
    // Set up the terminate handler.  This block is inserted at the very
    // end of the function by FinishFunction.
    $this().TerminateHandler = $this().createBasicBlock(new Twine(/*KEEP_STR*/"terminate.handler"));
    $this().Builder.SetInsertPoint($this().TerminateHandler);
    Value /*P*/ Exn = null;
    RestoreCurrentFuncletPad/*J*/= new SaveAndRestore<Instruction /*P*/ >($this().CurrentFuncletPad_ref, true);
    if (EHPersonality.get(/*Deref*/$this()).usesFuncletPads()) {
      Value /*P*/ ParentPad = $this().CurrentFuncletPad;
      if (!(ParentPad != null)) {
        ParentPad = ConstantTokenNone.get($this().CGM.getLLVMContext());
      }
      $this().CurrentFuncletPad = $this().Builder.CreateCleanupPad(ParentPad);
    } else {
      if ($this().getLangOpts().CPlusPlus) {
        Exn = $this().getExceptionFromSlot();
      }
    }
    CallInst /*P*/ terminateCall = $this().CGM.getCXXABI().emitTerminateForUnexpectedException(/*Deref*/$this(), Exn);
    terminateCall.setDoesNotReturn();
    $this().Builder.CreateUnreachable();
    
    // Restore the saved insertion state.
    $this().Builder.restoreIP(new IRBuilderBase.InsertPoint(SavedIP));
    
    return $this().TerminateHandler;
  } finally {
    if (RestoreCurrentFuncletPad != null) { RestoreCurrentFuncletPad.$destroy(); }
  }
}

// end anonymous namespace

// Emits an exception expression into the given location.  This
// differs from EmitAnyExprToMem only in that, if a final copy-ctor
// call is required, an exception within that copy ctor causes
// std::terminate to be invoked.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitAnyExprToExn">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp", line = 357,
 FQN="clang::CodeGen::CodeGenFunction::EmitAnyExprToExn", NM="_ZN5clang7CodeGen15CodeGenFunction16EmitAnyExprToExnEPKNS_4ExprENS0_7AddressE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction16EmitAnyExprToExnEPKNS_4ExprENS0_7AddressE")
//</editor-fold>
public final void EmitAnyExprToExn(/*const*/ Expr /*P*/ e, Address addr) {
  // Make sure the exception object is cleaned up if there's an
  // exception during initialization.
  $this().<FreeException>pushFullExprCleanup(CleanupKind.EHCleanup, (Object... A) -> new FreeException((Value) A[0]), addr.getPointer());
  EHScopeStack.stable_iterator cleanup = $this().EHStack.stable_begin();
  
  // __cxa_allocate_exception returns a void*;  we need to cast this
  // to the appropriate type for the object.
  org.llvm.ir.Type /*P*/ ty = $this().ConvertTypeForMem(e.getType()).getPointerTo();
  Address typedAddr = $this().Builder.CreateBitCast(new Address(addr), ty);
  
  // FIXME: this isn't quite right!  If there's a final unelided call
  // to a copy constructor, then according to [except.terminate]p1 we
  // must call std::terminate() if that constructor throws, because
  // technically that copy occurs after the exception expression is
  // evaluated but before the exception is caught.  But the best way
  // to handle that is to teach EmitAggExpr to do the final copy
  // differently if it can't be elided.
  $this().EmitAnyExprToMem(e, new Address(typedAddr), e.getType().getQualifiers(), 
      /*IsInit*/ true);
  
  // Deactivate the cleanup block.
  $this().DeactivateCleanupBlock(new EHScopeStack.stable_iterator(cleanup), 
      cast_Instruction(typedAddr.getPointer()));
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EnterCXXTryStmt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp", line = 542,
 FQN="clang::CodeGen::CodeGenFunction::EnterCXXTryStmt", NM="_ZN5clang7CodeGen15CodeGenFunction15EnterCXXTryStmtERKNS_10CXXTryStmtEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction15EnterCXXTryStmtERKNS_10CXXTryStmtEb")
//</editor-fold>
public final void EnterCXXTryStmt(final /*const*/ CXXTryStmt /*&*/ S) {
  EnterCXXTryStmt(S, false);
}
public final void EnterCXXTryStmt(final /*const*/ CXXTryStmt /*&*/ S, boolean IsFnTryBlock/*= false*/) {
  /*uint*/int NumHandlers = S.getNumHandlers();
  EHCatchScope /*P*/ CatchScope = $this().EHStack.pushCatch(NumHandlers);
  
  for (/*uint*/int I = 0; I != NumHandlers; ++I) {
    /*const*/ CXXCatchStmt /*P*/ C = S.getHandler$Const(I);
    
    BasicBlock /*P*/ Handler = $this().createBasicBlock(new Twine(/*KEEP_STR*/$catch));
    if ((C.getExceptionDecl() != null)) {
      // FIXME: Dropping the reference type on the type into makes it
      // impossible to correctly implement catch-by-reference
      // semantics for pointers.  Unfortunately, this is what all
      // existing compilers do, and it's not clear that the standard
      // personality routine is capable of doing this right.  See C++ DR 388:
      //   http://www.open-std.org/jtc1/sc22/wg21/docs/cwg_active.html#388
      Qualifiers CaughtTypeQuals/*J*/= new Qualifiers();
      QualType CaughtType = $this().CGM.getContext().getUnqualifiedArrayType(C.getCaughtType().getNonReferenceType(), CaughtTypeQuals);
      
      CatchTypeInfo TypeInfo/*J*/= new CatchTypeInfo(null, 0);
      if (CaughtType.$arrow().isObjCObjectPointerType()) {
        TypeInfo.RTTI = $this().CGM.getObjCRuntime().GetEHType(new QualType(CaughtType));
      } else {
        TypeInfo.$assignMove($this().CGM.getCXXABI().getAddrOfCXXCatchHandlerType(new QualType(CaughtType), C.getCaughtType()));
      }
      CatchScope.setHandler(I, new CatchTypeInfo(TypeInfo), Handler);
    } else {
      // No exception decl indicates '...', a catch-all.
      CatchScope.setHandler(I, $this().CGM.getCXXABI().getCatchAllTypeInfo(), Handler);
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::ExitCXXTryStmt">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp", line = 1003,
 FQN="clang::CodeGen::CodeGenFunction::ExitCXXTryStmt", NM="_ZN5clang7CodeGen15CodeGenFunction14ExitCXXTryStmtERKNS_10CXXTryStmtEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction14ExitCXXTryStmtERKNS_10CXXTryStmtEb")
//</editor-fold>
public final void ExitCXXTryStmt(final /*const*/ CXXTryStmt /*&*/ S) {
  ExitCXXTryStmt(S, false);
}
public final void ExitCXXTryStmt(final /*const*/ CXXTryStmt /*&*/ S, boolean IsFnTryBlock/*= false*/) {
  /*uint*/int NumHandlers = S.getNumHandlers();
  final EHCatchScope /*&*/ CatchScope = cast_EHCatchScope($this().EHStack.begin().$star());
  assert (CatchScope.getNumHandlers() == NumHandlers);
  
  // If the catch was not required, bail out now.
  if (!CatchScope.hasEHBranches()) {
    CatchScope.clearHandlerBlocks();
    $this().EHStack.popCatch();
    return;
  }
  
  // Emit the structure of the EH dispatch for this catch.
  CGExceptionStatics.emitCatchDispatchBlock(/*Deref*/$this(), CatchScope);
  
  // Copy the handler blocks off before we pop the EH stack.  Emitting
  // the handlers might scribble on this memory.
  SmallVector<EHCatchScope.Handler> Handlers/*J*/= new SmallVector<EHCatchScope.Handler>(JD$T.INSTANCE, 8, CatchScope.begin(), CatchScope.begin().$add(NumHandlers), new EHCatchScope.Handler());
  
  $this().EHStack.popCatch();
  
  // The fall-through block.
  BasicBlock /*P*/ ContBB = $this().createBasicBlock(new Twine(/*KEEP_STR*/"try.cont"));
  
  // We just emitted the body of the try; jump to the continue block.
  if ($this().HaveInsertPoint()) {
    $this().Builder.CreateBr(ContBB);
  }
  
  // Determine if we need an implicit rethrow for all these catch handlers;
  // see the comment below.
  boolean doImplicitRethrow = false;
  if (IsFnTryBlock) {
    doImplicitRethrow = isa_CXXDestructorDecl($this().CurCodeDecl)
       || isa_CXXConstructorDecl($this().CurCodeDecl);
  }
  
  // Perversely, we emit the handlers backwards precisely because we
  // want them to appear in source order.  In all of these cases, the
  // catch block will have exactly one predecessor, which will be a
  // particular block in the catch dispatch.  However, in the case of
  // a catch-all, one of the dispatch blocks will branch to two
  // different handlers, and EmitBlockAfterUses will cause the second
  // handler to be moved before the first.
  for (/*uint*/int I = NumHandlers; I != 0; --I) {
    RunCleanupsScope CatchScope$1 = null;
    SaveAndRestore<Instruction /*P*/ > RestoreCurrentFuncletPad = null;
    try {
      BasicBlock /*P*/ CatchBlock = Handlers.$at(I - 1).Block;
      $this().EmitBlockAfterUses(CatchBlock);
      
      // Catch the exception if this isn't a catch-all.
      /*const*/ CXXCatchStmt /*P*/ C = S.getHandler$Const(I - 1);
      
      // Enter a cleanup scope, including the catch variable and the
      // end-catch.
      CatchScope$1/*J*/= new RunCleanupsScope(/*Deref*/$this());
      
      // Initialize the catch variable and set up the cleanups.
      RestoreCurrentFuncletPad/*J*/= new SaveAndRestore<Instruction /*P*/ >($this().CurrentFuncletPad_ref, true);
      $this().CGM.getCXXABI().emitBeginCatch(/*Deref*/$this(), C);
      
      // Emit the PGO counter increment.
      $this().incrementProfileCounter(C);
      
      // Perform the body of the catch.
      $this().EmitStmt(C.getHandlerBlock());
      
      // [except.handle]p11:
      //   The currently handled exception is rethrown if control
      //   reaches the end of a handler of the function-try-block of a
      //   constructor or destructor.
      
      // It is important that we only do this on fallthrough and not on
      // return.  Note that it's illegal to put a return in a
      // constructor function-try-block's catch handler (p14), so this
      // really only applies to destructors.
      if (doImplicitRethrow && $this().HaveInsertPoint()) {
        $this().CGM.getCXXABI().emitRethrow(/*Deref*/$this(), /*isNoReturn*/ false);
        $this().Builder.CreateUnreachable();
        $this().Builder.ClearInsertionPoint();
      }
      
      // Fall out through the catch cleanups.
      CatchScope$1.ForceCleanup();
      
      // Branch out of the try.
      if ($this().HaveInsertPoint()) {
        $this().Builder.CreateBr(ContBB);
      }
    } finally {
      if (RestoreCurrentFuncletPad != null) { RestoreCurrentFuncletPad.$destroy(); }
      if (CatchScope$1 != null) { CatchScope$1.$destroy(); }
    }
  }
  
  $this().EmitBlock(ContBB);
  $this().incrementProfileCounter($AddrOf(S));
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitCXXTryStmt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp", line = 536,
 FQN="clang::CodeGen::CodeGenFunction::EmitCXXTryStmt", NM="_ZN5clang7CodeGen15CodeGenFunction14EmitCXXTryStmtERKNS_10CXXTryStmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction14EmitCXXTryStmtERKNS_10CXXTryStmtE")
//</editor-fold>
public final void EmitCXXTryStmt(final /*const*/ CXXTryStmt /*&*/ S) {
  $this().EnterCXXTryStmt(S);
  $this().EmitStmt(S.getTryBlock$Const());
  $this().ExitCXXTryStmt(S);
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitSEHTryStmt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp", line = 1390,
 FQN="clang::CodeGen::CodeGenFunction::EmitSEHTryStmt", NM="_ZN5clang7CodeGen15CodeGenFunction14EmitSEHTryStmtERKNS_10SEHTryStmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction14EmitSEHTryStmtERKNS_10SEHTryStmtE")
//</editor-fold>
public final void EmitSEHTryStmt(final /*const*/ SEHTryStmt /*&*/ S) {
  $this().EnterSEHTryStmt(S);
  {
    JumpDest TryExit = $this().getJumpDestInCurrentScope(new StringRef(/*KEEP_STR*/"__try.__leave"));
    
    $this().SEHTryEpilogueStack.push_back($AddrOf(TryExit));
    $this().EmitStmt(S.getTryBlock());
    $this().SEHTryEpilogueStack.pop_back();
    if (!TryExit.getBlock().use_empty()) {
      $this().EmitBlock(TryExit.getBlock(), /*IsFinished=*/ true);
    } else {
      /*delete*/Destructors.$destroy((Destructors.ClassWithDestructor)TryExit.getBlock());
    }
  }
  $this().ExitSEHTryStmt(S);
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitSEHLeaveStmt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp", line = 1884,
 FQN="clang::CodeGen::CodeGenFunction::EmitSEHLeaveStmt", NM="_ZN5clang7CodeGen15CodeGenFunction16EmitSEHLeaveStmtERKNS_12SEHLeaveStmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction16EmitSEHLeaveStmtERKNS_12SEHLeaveStmtE")
//</editor-fold>
public final void EmitSEHLeaveStmt(final /*const*/ SEHLeaveStmt /*&*/ S) {
  // If this code is reachable then emit a stop point (if generating
  // debug info). We have to do this ourselves because we are on the
  // "simple" statement path.
  if ($this().HaveInsertPoint()) {
    $this().EmitStopPoint($AddrOf(S));
  }
  
  // This must be a __leave from a __finally block, which we warn on and is UB.
  // Just emit unreachable.
  if (!$this().isSEHTryScope()) {
    $this().Builder.CreateUnreachable();
    $this().Builder.ClearInsertionPoint();
    return;
  }
  
  $this().EmitBranchThroughCleanup(new JumpDest($Deref($this().SEHTryEpilogueStack.back())));
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EnterSEHTryStmt">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp", line = 1779,
 FQN="clang::CodeGen::CodeGenFunction::EnterSEHTryStmt", NM="_ZN5clang7CodeGen15CodeGenFunction15EnterSEHTryStmtERKNS_10SEHTryStmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction15EnterSEHTryStmtERKNS_10SEHTryStmtE")
//</editor-fold>
public final void EnterSEHTryStmt(final /*const*/ SEHTryStmt /*&*/ S) {
  CodeGenFunction HelperCGF = null;
  try {
    HelperCGF/*J*/= new CodeGenFunction($this().CGM, /*suppressNewContext=*/ true);
    {
      /*const*/ SEHFinallyStmt /*P*/ Finally = S.getFinallyHandler();
      if ((Finally != null)) {
        // Outline the finally block.
        Function /*P*/ FinallyFunc = HelperCGF.GenerateSEHFinallyFunction(/*Deref*/$this(), $Deref(Finally));
        
        // Push a cleanup for __finally blocks.
        $this().EHStack.<PerformSEHFinally>pushCleanup$T(CleanupKind.NormalAndEHCleanup, () -> new PerformSEHFinally(FinallyFunc));
        return;
      }
    }
    
    // Otherwise, we must have an __except block.
    /*const*/ SEHExceptStmt /*P*/ Except = S.getExceptHandler();
    assert Native.$bool(Except);
    EHCatchScope /*P*/ CatchScope = $this().EHStack.pushCatch(1);
    $this().SEHCodeSlotStack.push_back($this().CreateMemTemp($this().getContext().IntTy.$QualType(), new Twine(/*KEEP_STR*/"__exception_code")));
    
    // If the filter is known to evaluate to 1, then we can use the clause
    // "catch i8* null". We can't do this on x86 because the filter has to save
    // the exception code.
    Constant /*P*/ C = $this().CGM.EmitConstantExpr(Except.getFilterExpr(), $this().getContext().IntTy.$QualType(), $this());
    if ($this().CGM.getTarget().getTriple().getArch() != Triple.ArchType.x86 && (C != null)
       && C.isOneValue()) {
      CatchScope.setCatchAllHandler(0, $this().createBasicBlock(new Twine(/*KEEP_STR*/"__except")));
      return;
    }
    
    // In general, we have to emit an outlined filter function. Use the function
    // in place of the RTTI typeinfo global that C++ EH uses.
    Function /*P*/ FilterFunc = HelperCGF.GenerateSEHFilterFunction(/*Deref*/$this(), $Deref(Except));
    Constant /*P*/ OpaqueFunc = ConstantExpr.getBitCast(FilterFunc, Unnamed_field9.Int8PtrTy);
    CatchScope.setHandler(0, OpaqueFunc, $this().createBasicBlock(new Twine(/*KEEP_STR*/"__except.ret")));
  } finally {
    if (HelperCGF != null) { HelperCGF.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::ExitSEHTryStmt">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp", line = 1818,
 FQN="clang::CodeGen::CodeGenFunction::ExitSEHTryStmt", NM="_ZN5clang7CodeGen15CodeGenFunction14ExitSEHTryStmtERKNS_10SEHTryStmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction14ExitSEHTryStmtERKNS_10SEHTryStmtE")
//</editor-fold>
public final void ExitSEHTryStmt(final /*const*/ SEHTryStmt /*&*/ S) {
  // Just pop the cleanup if it's a __finally block.
  if ((S.getFinallyHandler() != null)) {
    $this().PopCleanupBlock();
    return;
  }
  
  // Otherwise, we must have an __except block.
  /*const*/ SEHExceptStmt /*P*/ Except = S.getExceptHandler();
  assert ((Except != null)) : "__try must have __finally xor __except";
  final EHCatchScope /*&*/ CatchScope = cast_EHCatchScope($this().EHStack.begin().$star());
  
  // Don't emit the __except block if the __try block lacked invokes.
  // TODO: Model unwind edges from instructions, either with iload / istore or
  // a try body function.
  if (!CatchScope.hasEHBranches()) {
    CatchScope.clearHandlerBlocks();
    $this().EHStack.popCatch();
    $this().SEHCodeSlotStack.pop_back();
    return;
  }
  
  // The fall-through block.
  BasicBlock /*P*/ ContBB = $this().createBasicBlock(new Twine(/*KEEP_STR*/"__try.cont"));
  
  // We just emitted the body of the __try; jump to the continue block.
  if ($this().HaveInsertPoint()) {
    $this().Builder.CreateBr(ContBB);
  }
  
  // Check if our filter function returned true.
  CGExceptionStatics.emitCatchDispatchBlock(/*Deref*/$this(), CatchScope);
  
  // Grab the block before we pop the handler.
  BasicBlock /*P*/ CatchPadBB = CatchScope.getHandler(0).Block;
  $this().EHStack.popCatch();
  
  $this().EmitBlockAfterUses(CatchPadBB);
  
  // __except blocks don't get outlined into funclets, so immediately do a
  // catchret.
  CatchPadInst /*P*/ CPI = cast_CatchPadInst(CatchPadBB.getFirstNonPHI());
  BasicBlock /*P*/ ExceptBB = $this().createBasicBlock(new Twine(/*KEEP_STR*/"__except"));
  $this().Builder.CreateCatchRet(CPI, ExceptBB);
  $this().EmitBlock(ExceptBB);
  
  // On Win64, the exception code is returned in EAX. Copy it into the slot.
  if ($this().CGM.getTarget().getTriple().getArch() != Triple.ArchType.x86) {
    Function /*P*/ SEHCodeIntrin = $this().CGM.getIntrinsic(ID.eh_exceptioncode);
    Value /*P*/ Code = $this().Builder.CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P(SEHCodeIntrin, /*{ */new ArrayRef<Value /*P*/ >(new Value /*P*/ /*const*/ [/*1*/] {CPI}, true)/* }*/);
    $this().Builder.CreateStore(Code, new Address($this().SEHCodeSlotStack.back()));
  }
  
  // Emit the __except body.
  $this().EmitStmt(Except.getBlock());
  
  // End the lifetime of the exception code.
  $this().SEHCodeSlotStack.pop_back();
  if ($this().HaveInsertPoint()) {
    $this().Builder.CreateBr(ContBB);
  }
  
  $this().EmitBlock(ContBB);
}


/// Arrange a function prototype that can be called by Windows exception
/// handling personalities. On Win64, the prototype looks like:
/// RetTy func(void *EHPtrs, void *ParentFP);
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::startOutlinedSEHHelper">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp", line = 1617,
 FQN="clang::CodeGen::CodeGenFunction::startOutlinedSEHHelper", NM="_ZN5clang7CodeGen15CodeGenFunction22startOutlinedSEHHelperERS1_bPKNS_4StmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction22startOutlinedSEHHelperERS1_bPKNS_4StmtE")
//</editor-fold>
public final void startOutlinedSEHHelper(final CodeGenFunction /*&*/ ParentCGF, 
                      boolean IsFilter, 
                      /*const*/ Stmt /*P*/ OutlinedStmt) {
  FunctionArgList Args = null;
  try {
    SourceLocation StartLoc = OutlinedStmt.getLocStart();
    
    // Get the mangled function name.
    SmallString/*<128>*/ Name/*J*/= new SmallString/*<128>*/(128);
    {
      raw_svector_ostream OS = null;
      try {
        OS/*J*/= new raw_svector_ostream(Name);
        /*const*/ FunctionDecl /*P*/ ParentSEHFn = ParentCGF.CurSEHParent;
        assert ((ParentSEHFn != null)) : "No CurSEHParent!";
        final MangleContext /*&*/ Mangler = $this().CGM.getCXXABI().getMangleContext();
        if (IsFilter) {
          Mangler.mangleSEHFilterExpression(ParentSEHFn, OS);
        } else {
          Mangler.mangleSEHFinallyBlock(ParentSEHFn, OS);
        }
      } finally {
        if (OS != null) { OS.$destroy(); }
      }
    }
    
    Args/*J*/= new FunctionArgList();
    if ($this().CGM.getTarget().getTriple().getArch() != Triple.ArchType.x86 || !IsFilter) {
      // All SEH finally functions take two parameters. Win64 filters take two
      // parameters. Win32 filters take no parameters.
      if (IsFilter) {
        Args.push_back(ImplicitParamDecl.Create($this().getContext(), (DeclContext /*P*/ )null, new SourceLocation(StartLoc), 
                $AddrOf($this().getContext().Idents.get(new StringRef(/*KEEP_STR*/"exception_pointers"))), 
                $this().getContext().VoidPtrTy.$QualType()));
      } else {
        Args.push_back(ImplicitParamDecl.Create($this().getContext(), (DeclContext /*P*/ )null, new SourceLocation(StartLoc), 
                $AddrOf($this().getContext().Idents.get(new StringRef(/*KEEP_STR*/"abnormal_termination"))), 
                $this().getContext().UnsignedCharTy.$QualType()));
      }
      Args.push_back(ImplicitParamDecl.Create($this().getContext(), (DeclContext /*P*/ )null, new SourceLocation(StartLoc), 
              $AddrOf($this().getContext().Idents.get(new StringRef(/*KEEP_STR*/"frame_pointer"))), $this().getContext().VoidPtrTy.$QualType()));
    }
    
    QualType RetTy = (IsFilter ? $this().getContext().LongTy : $this().getContext().VoidTy).$QualType();
    
    Function /*P*/ ParentFn = ParentCGF.CurFn;
    final /*const*/ CGFunctionInfo /*&*/ FnInfo = $this().CGM.getTypes().arrangeBuiltinFunctionDeclaration(new QualType(RetTy), Args);
    
    org.llvm.ir.FunctionType /*P*/ FnTy = $this().CGM.getTypes().GetFunctionType(FnInfo);
    Function /*P*/ Fn = Function.Create(FnTy, GlobalValue.LinkageTypes.InternalLinkage, new Twine(Name.str()), $AddrOf($this().CGM.getModule()));
    {
      // The filter is either in the same comdat as the function, or it's internal.
      Comdat /*P*/ C = ParentFn.getComdat();
      if ((C != null)) {
        Fn.setComdat(C);
      } else if (ParentFn.hasWeakLinkage() || ParentFn.hasLinkOnceLinkage()) {
        Comdat /*P*/ C$1 = $this().CGM.getModule().getOrInsertComdat(ParentFn.getName());
        ParentFn.setComdat(C$1);
        Fn.setComdat(C$1);
      } else {
        Fn.setLinkage(GlobalValue.LinkageTypes.InternalLinkage);
      }
    }
    
    $this().IsOutlinedSEHHelper = true;
    
    $this().StartFunction(new GlobalDecl(), new QualType(RetTy), Fn, FnInfo, Args, 
        OutlinedStmt.getLocStart(), OutlinedStmt.getLocStart());
    $this().CurSEHParent = ParentCGF.CurSEHParent;
    
    $this().CGM.SetLLVMFunctionAttributes((/*const*/ Decl /*P*/ )null, FnInfo, $this().CurFn);
    $this().EmitCapturedLocals(ParentCGF, OutlinedStmt, IsFilter);
  } finally {
    if (Args != null) { Args.$destroy(); }
  }
}


/// Create a stub filter function that will ultimately hold the code of the
/// filter expression. The EH preparation passes in LLVM will outline the code
/// from the main function body into this stub.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::GenerateSEHFilterFunction">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp", line = 1688,
 FQN="clang::CodeGen::CodeGenFunction::GenerateSEHFilterFunction", NM="_ZN5clang7CodeGen15CodeGenFunction25GenerateSEHFilterFunctionERS1_RKNS_13SEHExceptStmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction25GenerateSEHFilterFunctionERS1_RKNS_13SEHExceptStmtE")
//</editor-fold>
public final Function /*P*/ GenerateSEHFilterFunction(final CodeGenFunction /*&*/ ParentCGF, 
                         final /*const*/ SEHExceptStmt /*&*/ Except) {
  /*const*/ Expr /*P*/ FilterExpr = Except.getFilterExpr();
  $this().startOutlinedSEHHelper(ParentCGF, true, FilterExpr);
  
  // Emit the original filter expression, convert to i32, and return.
  Value /*P*/ R = $this().EmitScalarExpr(FilterExpr);
  R = $this().Builder.CreateIntCast(R, $this().ConvertType($this().getContext().LongTy.$QualType()), 
      FilterExpr.getType().$arrow().isSignedIntegerType());
  $this().Builder.CreateStore(R, new Address($this().ReturnValue));
  
  $this().FinishFunction(FilterExpr.getLocEnd());
  
  return $this().CurFn;
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::GenerateSEHFinallyFunction">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp", line = 1705,
 FQN="clang::CodeGen::CodeGenFunction::GenerateSEHFinallyFunction", NM="_ZN5clang7CodeGen15CodeGenFunction26GenerateSEHFinallyFunctionERS1_RKNS_14SEHFinallyStmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction26GenerateSEHFinallyFunctionERS1_RKNS_14SEHFinallyStmtE")
//</editor-fold>
public final Function /*P*/ GenerateSEHFinallyFunction(final CodeGenFunction /*&*/ ParentCGF, 
                          final /*const*/ SEHFinallyStmt /*&*/ Finally) {
  /*const*/ Stmt /*P*/ FinallyBlock = Finally.getBlock();
  $this().startOutlinedSEHHelper(ParentCGF, false, FinallyBlock);
  
  // Emit the original filter expression, convert to i32, and return.
  $this().EmitStmt(FinallyBlock);
  
  $this().FinishFunction(FinallyBlock.getLocEnd());
  
  return $this().CurFn;
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitSEHExceptionCodeSave">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp", line = 1719,
 FQN="clang::CodeGen::CodeGenFunction::EmitSEHExceptionCodeSave", NM="_ZN5clang7CodeGen15CodeGenFunction24EmitSEHExceptionCodeSaveERS1_PN4llvm5ValueES5_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction24EmitSEHExceptionCodeSaveERS1_PN4llvm5ValueES5_")
//</editor-fold>
public final void EmitSEHExceptionCodeSave(final CodeGenFunction /*&*/ ParentCGF, 
                        Value /*P*/ ParentFP, 
                        Value /*P*/ EntryFP) {
  // Get the pointer to the EXCEPTION_POINTERS struct. This is returned by the
  // __exception_info intrinsic.
  if ($this().CGM.getTarget().getTriple().getArch() != Triple.ArchType.x86) {
    // On Win64, the info is passed as the first parameter to the filter.
    $this().SEHInfo = $AddrOf($this().CurFn.arg_begin().$star());
    $this().SEHCodeSlotStack.push_back($this().CreateMemTemp($this().getContext().IntTy.$QualType(), new Twine(/*KEEP_STR*/"__exception_code")));
  } else {
    // On Win32, the EBP on entry to the filter points to the end of an
    // exception registration object. It contains 6 32-bit fields, and the info
    // pointer is stored in the second field. So, GEP 20 bytes backwards and
    // load the pointer.
    $this().SEHInfo = $this().Builder.CreateConstInBoundsGEP1_32(Int8Ty, EntryFP, -20);
    $this().SEHInfo = $this().Builder.CreateBitCast($this().SEHInfo, Unnamed_field9.Int8PtrTy.getPointerTo());
    $this().SEHInfo = $this().Builder.CreateAlignedLoad(Unnamed_field9.Int8PtrTy, $this().SEHInfo, /*J:ToBase*/super.getPointerAlign());
    $this().SEHCodeSlotStack.push_back($this().recoverAddrOfEscapedLocal(ParentCGF, new Address(ParentCGF.SEHCodeSlotStack.back()), ParentFP));
  }
  
  // Save the exception code in the exception slot to unify exception access in
  // the filter function and the landing pad.
  // struct EXCEPTION_POINTERS {
  //   EXCEPTION_RECORD *ExceptionRecord;
  //   CONTEXT *ContextRecord;
  // };
  // int exceptioncode = exception_pointers->ExceptionRecord->ExceptionCode;
  org.llvm.ir.Type /*P*/ RecordTy = $this().CGM.Int32Ty.getPointerTo();
  org.llvm.ir.Type /*P*/ PtrsTy = StructType.get(RecordTy, $this().CGM.Unnamed_field9.VoidPtrTy, null);
  Value /*P*/ Ptrs = $this().Builder.CreateBitCast($this().SEHInfo, PtrsTy.getPointerTo());
  Value /*P*/ Rec = $this().Builder.CreateStructGEP(PtrsTy, Ptrs, 0);
  Rec = $this().Builder.CreateAlignedLoad(Rec, /*J:ToBase*/super.getPointerAlign());
  Value /*P*/ Code = $this().Builder.CreateAlignedLoad(Rec, /*J:ToBase*/super.getIntAlign());
  assert (!$this().SEHCodeSlotStack.empty()) : "emitting EH code outside of __except";
  $this().Builder.CreateStore(Code, new Address($this().SEHCodeSlotStack.back()));
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitSEHExceptionCode">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp", line = 1767,
 FQN="clang::CodeGen::CodeGenFunction::EmitSEHExceptionCode", NM="_ZN5clang7CodeGen15CodeGenFunction20EmitSEHExceptionCodeEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction20EmitSEHExceptionCodeEv")
//</editor-fold>
public final Value /*P*/ EmitSEHExceptionCode() {
  assert (!$this().SEHCodeSlotStack.empty()) : "emitting EH code outside of __except";
  return $this().Builder.CreateLoad(new Address($this().SEHCodeSlotStack.back()));
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitSEHExceptionInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp", line = 1758,
 FQN="clang::CodeGen::CodeGenFunction::EmitSEHExceptionInfo", NM="_ZN5clang7CodeGen15CodeGenFunction20EmitSEHExceptionInfoEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction20EmitSEHExceptionInfoEv")
//</editor-fold>
public final Value /*P*/ EmitSEHExceptionInfo() {
  // Sema should diagnose calling this builtin outside of a filter context, but
  // don't crash if we screw up.
  if (!($this().SEHInfo != null)) {
    return UndefValue.get(Unnamed_field9.Int8PtrTy);
  }
  assert ($this().SEHInfo.getType() == Unnamed_field9.Int8PtrTy);
  return $this().SEHInfo;
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitSEHAbnormalTermination">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp", line = 1772,
 FQN="clang::CodeGen::CodeGenFunction::EmitSEHAbnormalTermination", NM="_ZN5clang7CodeGen15CodeGenFunction26EmitSEHAbnormalTerminationEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction26EmitSEHAbnormalTerminationEv")
//</editor-fold>
public final Value /*P*/ EmitSEHAbnormalTermination() {
  // Abnormal termination is just the first parameter to the outlined finally
  // helper.
  ilist_iterator<Argument> AI = $this().CurFn.arg_begin();
  return $this().Builder.CreateZExt($AddrOf(AI.$star()), Int32Ty);
}


/// Scan the outlined statement for captures from the parent function. For
/// each capture, mark the capture as escaped and emit a call to
/// llvm.localrecover. Insert the localrecover result into the LocalDeclMap.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitCapturedLocals">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp", line = 1536,
 FQN="clang::CodeGen::CodeGenFunction::EmitCapturedLocals", NM="_ZN5clang7CodeGen15CodeGenFunction18EmitCapturedLocalsERS1_PKNS_4StmtEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction18EmitCapturedLocalsERS1_PKNS_4StmtEb")
//</editor-fold>
public final void EmitCapturedLocals(final CodeGenFunction /*&*/ ParentCGF, 
                  /*const*/ Stmt /*P*/ OutlinedStmt, 
                  boolean IsFilter) {
  CaptureFinder Finder = null;
  CGBuilderTy Builder = null;
  try {
    // Find all captures in the Stmt.
    Finder/*J*/= new CaptureFinder(ParentCGF, ParentCGF.CXXABIThisDecl);
    Finder.Visit(OutlinedStmt);
    
    // We can exit early on x86_64 when there are no captures. We just have to
    // save the exception code in filters so that __exception_code() works.
    if (!Finder.foundCaptures()
       && $this().CGM.getTarget().getTriple().getArch() != Triple.ArchType.x86) {
      if (IsFilter) {
        $this().EmitSEHExceptionCodeSave(ParentCGF, (Value /*P*/ )null, (Value /*P*/ )null);
      }
      return;
    }
    
    Value /*P*/ EntryFP = null;
    Builder/*J*/= new CGBuilderTy($this().CGM, $this().AllocaInsertPt.$T$P());
    if (IsFilter && $this().CGM.getTarget().getTriple().getArch() == Triple.ArchType.x86) {
      // 32-bit SEH filters need to be careful about FP recovery.  The end of the
      // EH registration is passed in as the EBP physical register.  We can
      // recover that with llvm.frameaddress(1).
      EntryFP = Builder.CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P($this().CGM.getIntrinsic(ID.frameaddress), /*{ */new ArrayRef<Value /*P*/ >(new Value /*P*/ /*const*/ [/*1*/] {Builder.getInt32(1)}, true)/* }*/);
    } else {
      // Otherwise, for x64 and 32-bit finally functions, the parent FP is the
      // second parameter.
      ilist_iterator<Argument> AI = $this().CurFn.arg_begin();
      AI.$preInc();
      EntryFP = $AddrOf(AI.$star());
    }
    
    Value /*P*/ ParentFP = EntryFP;
    if (IsFilter) {
      // Given whatever FP the runtime provided us in EntryFP, recover the true
      // frame pointer of the parent function. We only need to do this in filters,
      // since finally funclets recover the parent FP for us.
      Function /*P*/ RecoverFPIntrin = $this().CGM.getIntrinsic(ID.x86_seh_recoverfp);
      Constant /*P*/ ParentI8Fn = ConstantExpr.getBitCast(ParentCGF.CurFn, Unnamed_field9.Int8PtrTy);
      ParentFP = Builder.CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P(RecoverFPIntrin, /*{ */new ArrayRef<Value /*P*/ >(new Value /*P*/ /*const*/ [/*2*/] {ParentI8Fn, EntryFP}, true)/* }*/);
    }
    
    // Create llvm.localrecover calls for all captures.
    for (/*const*/ VarDecl /*P*/ VD : Finder.Captures) {
      if (isa_ImplicitParamDecl(VD)) {
        $this().CGM.ErrorUnsupported(VD, $("'this' captured by SEH"));
        $this().CXXThisValue = UndefValue.get($this().ConvertTypeForMem(VD.getType()));
        continue;
      }
      if (VD.getType().$arrow().isVariablyModifiedType()) {
        $this().CGM.ErrorUnsupported(VD, $("VLA captured by SEH"));
        continue;
      }
      assert ((isa_ImplicitParamDecl(VD) || VD.isLocalVarDeclOrParm())) : "captured non-local variable";
      
      // If this decl hasn't been declared yet, it will be declared in the
      // OutlinedStmt.
      DenseMapIterator</*const*/ Decl /*P*/ , Address> I = ParentCGF.LocalDeclMap.find(VD);
      if (I.$eq(/*NO_ITER_COPY*/ParentCGF.LocalDeclMap.end())) {
        continue;
      }
      
      Address ParentVar = new Address(I.$arrow().second);
      $this().setAddrOfLocalVar(VD, $this().recoverAddrOfEscapedLocal(ParentCGF, new Address(ParentVar), ParentFP));
    }
    if (Finder.SEHCodeSlot.isValid()) {
      $this().SEHCodeSlotStack.push_back($this().recoverAddrOfEscapedLocal(ParentCGF, new Address(Finder.SEHCodeSlot), ParentFP));
    }
    if (IsFilter) {
      $this().EmitSEHExceptionCodeSave(ParentCGF, ParentFP, EntryFP);
    }
  } finally {
    if (Builder != null) { Builder.$destroy(); }
    if (Finder != null) { Finder.$destroy(); }
  }
}


/// Recovers the address of a local in a parent function. ParentVar is the
/// address of the variable used in the immediate parent function. It can
/// either be an alloca or a call to llvm.localrecover if there are nested
/// outlined functions. ParentFP is the frame pointer of the outermost parent
/// frame.
// end anonymous namespace
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::recoverAddrOfEscapedLocal">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*make_pair*/,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp", line = 1496,
 FQN="clang::CodeGen::CodeGenFunction::recoverAddrOfEscapedLocal", NM="_ZN5clang7CodeGen15CodeGenFunction25recoverAddrOfEscapedLocalERS1_NS0_7AddressEPN4llvm5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction25recoverAddrOfEscapedLocalERS1_NS0_7AddressEPN4llvm5ValueE")
//</editor-fold>
public final Address recoverAddrOfEscapedLocal(final CodeGenFunction /*&*/ ParentCGF, 
                         Address ParentVar, 
                         Value /*P*/ ParentFP) {
  CGBuilderTy Builder = null;
  try {
    CallInst /*P*/ RecoverCall = null;
    Builder/*J*/= new CGBuilderTy(/*Deref*/$this(), $this().AllocaInsertPt.$T$P());
    {
      AllocaInst /*P*/ ParentAlloca = dyn_cast_AllocaInst(ParentVar.getPointer());
      if ((ParentAlloca != null)) {
        // Mark the variable escaped if nobody else referenced it and compute the
        // localescape index.
        std.pairTypeBool<DenseMapIteratorTypeInt<AllocaInst /*P*/ /*P*/>> InsertPair = ParentCGF.EscapedLocals.insert_pair$KeyT$ValueT(std.make_pair_Ptr_uint2int(ParentAlloca, ParentCGF.EscapedLocals.size()));
        int FrameEscapeIdx = InsertPair.first.$arrow().second;
        // call i8* @llvm.localrecover(i8* bitcast(@parentFn), i8* %fp, i32 N)
        Function /*P*/ FrameRecoverFn = getDeclaration(/*AddrOf*/$this().CGM.getModule(), ID.localrecover);
        Constant /*P*/ ParentI8Fn = ConstantExpr.getBitCast(ParentCGF.CurFn, Unnamed_field9.Int8PtrTy);
        RecoverCall = Builder.CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P(FrameRecoverFn, /*{ */new ArrayRef<Value /*P*/ >(new Value /*P*/ /*const*/ [/*3*/] {
                  ParentI8Fn, ParentFP, 
                  ConstantInt.get(Int32Ty, $int2ulong(FrameEscapeIdx))}, true)/* }*/);
      } else {
        // If the parent didn't have an alloca, we're doing some nested outlining.
        // Just clone the existing localrecover call, but tweak the FP argument to
        // use our FP value. All other arguments are constants.
        IntrinsicInst /*P*/ ParentRecover = cast_IntrinsicInst(ParentVar.getPointer().stripPointerCasts());
        assert (ParentRecover.getIntrinsicID() ==ID.localrecover) : "expected alloca or localrecover in parent LocalDeclMap";
        RecoverCall = cast_CallInst(ParentRecover.clone());
        RecoverCall.setArgOperand(1, ParentFP);
        RecoverCall.insertBefore($this().AllocaInsertPt.$T$P());
      }
    }
    
    // Bitcast the variable, rename it, and insert it in the local decl map.
    Value /*P*/ ChildVar = Builder.CreateBitCast(RecoverCall, ParentVar.getType());
    ChildVar.setName(new Twine(ParentVar.getName()));
    return new Address(ChildVar, ParentVar.getAlignment());
  } finally {
    if (Builder != null) { Builder.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitCXXThrowExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp", line = 403,
 FQN="clang::CodeGen::CodeGenFunction::EmitCXXThrowExpr", NM="_ZN5clang7CodeGen15CodeGenFunction16EmitCXXThrowExprEPKNS_12CXXThrowExprEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction16EmitCXXThrowExprEPKNS_12CXXThrowExprEb")
//</editor-fold>
public final void EmitCXXThrowExpr(/*const*/ CXXThrowExpr /*P*/ E) {
  EmitCXXThrowExpr(E, 
                true);
}
public final void EmitCXXThrowExpr(/*const*/ CXXThrowExpr /*P*/ E, 
                boolean KeepInsertionPoint/*= true*/) {
  {
    /*const*/ Expr /*P*/ SubExpr = E.getSubExpr$Const();
    if ((SubExpr != null)) {
      QualType ThrowType = SubExpr.getType();
      if (ThrowType.$arrow().isObjCObjectPointerType()) {
        /*const*/ Stmt /*P*/ ThrowStmt = E.getSubExpr$Const();
        /*const*/ ObjCAtThrowStmt S/*J*/= new ObjCAtThrowStmt(E.getExprLoc(), ((/*const_cast*/Stmt /*P*/ )(ThrowStmt)));
        $this().CGM.getObjCRuntime().EmitThrowStmt(/*Deref*/$this(), S, false);
      } else {
        $this().CGM.getCXXABI().emitThrow(/*Deref*/$this(), E);
      }
    } else {
      $this().CGM.getCXXABI().emitRethrow(/*Deref*/$this(), /*isNoReturn=*/ true);
    }
  }
  
  // throw is an expression, and the expression emitters expect us
  // to leave ourselves at a valid insertion point.
  if (KeepInsertionPoint) {
    $this().EmitBlock($this().createBasicBlock(new Twine(/*KEEP_STR*/"throw.cont")));
  }
}

} // END OF class CodeGenFunction_CGException
