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

package org.clang.codegen.impl;

import org.clank.support.*;
import static org.clank.support.NativePointer.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.llvm.ir.*;
import org.clang.codegen.impl.*;
import org.clang.codegen.CodeGen.impl.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PerformFinally">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp", line = 1116,
 FQN="(anonymous namespace)::PerformFinally", NM="_ZN12_GLOBAL__N_114PerformFinallyE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp -nm=_ZN12_GLOBAL__N_114PerformFinallyE")
//</editor-fold>
public final class/*struct*/ PerformFinally extends /**/ EHScopeStack.Cleanup {
  public /*const*/ Stmt /*P*/ Body;
  public Value /*P*/ ForEHVar;
  public Value /*P*/ EndCatchFn;
  public Value /*P*/ RethrowFn;
  public Value /*P*/ SavedExnVar;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PerformFinally::PerformFinally">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp", line = 1123,
   FQN="(anonymous namespace)::PerformFinally::PerformFinally", NM="_ZN12_GLOBAL__N_114PerformFinallyC1EPKN5clang4StmtEPN4llvm5ValueES7_S7_S7_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp -nm=_ZN12_GLOBAL__N_114PerformFinallyC1EPKN5clang4StmtEPN4llvm5ValueES7_S7_S7_")
  //</editor-fold>
  public PerformFinally(/*const*/ Stmt /*P*/ Body, Value /*P*/ ForEHVar, 
      Value /*P*/ EndCatchFn, 
      Value /*P*/ RethrowFn, Value /*P*/ SavedExnVar) {
    // : EHScopeStack::Cleanup(), Body(Body), ForEHVar(ForEHVar), EndCatchFn(EndCatchFn), RethrowFn(RethrowFn), SavedExnVar(SavedExnVar) 
    //START JInit
    super();
    this.Body = Body;
    this.ForEHVar = ForEHVar;
    this.EndCatchFn = EndCatchFn;
    this.RethrowFn = RethrowFn;
    this.SavedExnVar = SavedExnVar;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PerformFinally::Emit">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp", line = 1129,
   FQN="(anonymous namespace)::PerformFinally::Emit", NM="_ZN12_GLOBAL__N_114PerformFinally4EmitERN5clang7CodeGen15CodeGenFunctionENS2_12EHScopeStack7Cleanup5FlagsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp -nm=_ZN12_GLOBAL__N_114PerformFinally4EmitERN5clang7CodeGen15CodeGenFunctionENS2_12EHScopeStack7Cleanup5FlagsE")
  //</editor-fold>
  @Override public void Emit(final CodeGenFunction /*&*/ CGF, EHScopeStack.Cleanup.Flags flags)/* override*/ {
    // Enter a cleanup to call the end-catch function if one was provided.
    if ((EndCatchFn != null)) {
      CGF.EHStack.<CallEndCatchForFinally>pushCleanup$T(CleanupKind.NormalAndEHCleanup, 
          () -> new CallEndCatchForFinally(ForEHVar, EndCatchFn));
    }
    
    // Save the current cleanup destination in case there are
    // cleanups in the finally block.
    Value /*P*/ SavedCleanupDest = CGF.Builder.CreateLoad(CGF.getNormalCleanupDestSlot(), 
        $("cleanup.dest.saved"));
    
    // Emit the finally block.
    CGF.EmitStmt(Body);
    
    // If the end of the finally is reachable, check whether this was
    // for EH.  If so, rethrow.
    if (CGF.HaveInsertPoint()) {
      BasicBlock /*P*/ RethrowBB = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"finally.rethrow"));
      BasicBlock /*P*/ ContBB = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"finally.cont"));
      
      Value /*P*/ ShouldRethrow = CGF.Builder.CreateFlagLoad(ForEHVar, new Twine(/*KEEP_STR*/"finally.shouldthrow"));
      CGF.Builder.CreateCondBr(ShouldRethrow, RethrowBB, ContBB);
      
      CGF.EmitBlock(RethrowBB);
      if ((SavedExnVar != null)) {
        CGF.EmitRuntimeCallOrInvoke(RethrowFn, 
            new ArrayRef<Value /*P*/ >(CGF.Builder.CreateAlignedLoad(SavedExnVar, CGF.getPointerAlign()), true));
      } else {
        CGF.EmitRuntimeCallOrInvoke(RethrowFn);
      }
      CGF.Builder.CreateUnreachable();
      
      CGF.EmitBlock(ContBB);
      
      // Restore the cleanup destination.
      CGF.Builder.CreateStore(SavedCleanupDest, 
          CGF.getNormalCleanupDestSlot());
    }
    
    // Leave the end-catch cleanup.  As an optimization, pretend that
    // the fallthrough path was inaccessible; we've dynamically proven
    // that we're not in the EH case along that path.
    if ((EndCatchFn != null)) {
      CGBuilderTy.InsertPoint SavedIP = CGF.Builder.saveAndClearIP();
      CGF.PopCleanupBlock();
      CGF.Builder.restoreIP(new IRBuilderBase.InsertPoint(SavedIP));
    }
    
    // Now make sure we actually have an insertion point or the
    // cleanup gods will hate us.
    CGF.EnsureInsertPoint();
  }

  
  @Override public String toString() {
    return "" + "Body=" + "[Stmt]" // NOI18N
              + ", ForEHVar=" + ForEHVar // NOI18N
              + ", EndCatchFn=" + EndCatchFn // NOI18N
              + ", RethrowFn=" + RethrowFn // NOI18N
              + ", SavedExnVar=" + SavedExnVar // NOI18N
              + super.toString(); // NOI18N
  }
}
