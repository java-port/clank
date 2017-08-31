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
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import static org.clang.ast.java.AstStatementsRTTI.cast_ObjCAtTryStmt;
import static org.clang.ast.java.AstStatementsRTTI.isa_ObjCAtTryStmt;
import org.llvm.ir.*;
import org.clang.codegen.impl.*;
import org.clang.codegen.CodeGen.impl.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PerformFragileFinally">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 3702,
 FQN="(anonymous namespace)::PerformFragileFinally", NM="_ZN12_GLOBAL__N_121PerformFragileFinallyE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_121PerformFragileFinallyE")
//</editor-fold>
public final class/*struct*/ PerformFragileFinally extends /**/ EHScopeStack.Cleanup {
  public final /*const*/ Stmt /*&*/ S;
  public Address SyncArgSlot;
  public Address CallTryExitVar;
  public Address ExceptionData;
  public final ObjCTypesHelper /*&*/ ObjCTypes;
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PerformFragileFinally::PerformFragileFinally">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 3708,
   FQN="(anonymous namespace)::PerformFragileFinally::PerformFragileFinally", NM="_ZN12_GLOBAL__N_121PerformFragileFinallyC1EPKN5clang4StmtENS1_7CodeGen7AddressES6_S6_PNS_15ObjCTypesHelperE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_121PerformFragileFinallyC1EPKN5clang4StmtENS1_7CodeGen7AddressES6_S6_PNS_15ObjCTypesHelperE")
  //</editor-fold>
  public PerformFragileFinally(/*const*/ Stmt /*P*/ S, 
      Address SyncArgSlot, 
      Address CallTryExitVar, 
      Address ExceptionData, 
      ObjCTypesHelper /*P*/ ObjCTypes) {
    // : EHScopeStack::Cleanup(), S(*S), SyncArgSlot(SyncArgSlot), CallTryExitVar(CallTryExitVar), ExceptionData(ExceptionData), ObjCTypes(*ObjCTypes) 
    //START JInit
    super();
    this./*&*/S=/*&*//*Deref*/S;
    this.SyncArgSlot = new Address(SyncArgSlot);
    this.CallTryExitVar = new Address(CallTryExitVar);
    this.ExceptionData = new Address(ExceptionData);
    this./*&*/ObjCTypes=/*&*//*Deref*/ObjCTypes;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PerformFragileFinally::Emit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 3716,
   FQN="(anonymous namespace)::PerformFragileFinally::Emit", NM="_ZN12_GLOBAL__N_121PerformFragileFinally4EmitERN5clang7CodeGen15CodeGenFunctionENS2_12EHScopeStack7Cleanup5FlagsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_121PerformFragileFinally4EmitERN5clang7CodeGen15CodeGenFunctionENS2_12EHScopeStack7Cleanup5FlagsE")
  //</editor-fold>
  @Override public void Emit(final CodeGenFunction /*&*/ CGF, EHScopeStack.Cleanup.Flags flags)/* override*/ {
    // Check whether we need to call objc_exception_try_exit.
    // In optimized code, this branch will always be folded.
    BasicBlock /*P*/ FinallyCallExit = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"finally.call_exit"));
    BasicBlock /*P*/ FinallyNoCallExit = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"finally.no_call_exit"));
    CGF.Builder.CreateCondBr(CGF.Builder.CreateLoad(new Address(CallTryExitVar)), 
        FinallyCallExit, FinallyNoCallExit);
    
    CGF.EmitBlock(FinallyCallExit);
    CGF.EmitNounwindRuntimeCall(ObjCTypes.getExceptionTryExitFn(), 
        new ArrayRef<Value /*P*/ >(ExceptionData.getPointer(), true));
    
    CGF.EmitBlock(FinallyNoCallExit);
    if (isa_ObjCAtTryStmt(S)) {
      {
        /*const*/ ObjCAtFinallyStmt /*P*/ FinallyStmt = cast_ObjCAtTryStmt(S).getFinallyStmt$Const();
        if ((FinallyStmt != null)) {
          // Don't try to do the @finally if this is an EH cleanup.
          if (flags.isForEHCleanup()) {
            return;
          }
          
          // Save the current cleanup destination in case there's
          // control flow inside the finally statement.
          Value /*P*/ CurCleanupDest = CGF.Builder.CreateLoad(CGF.getNormalCleanupDestSlot());
          
          CGF.EmitStmt(FinallyStmt.getFinallyBody$Const());
          if (CGF.HaveInsertPoint()) {
            CGF.Builder.CreateStore(CurCleanupDest, 
                CGF.getNormalCleanupDestSlot());
          } else {
            // Currently, the end of the cleanup must always exist.
            CGF.EnsureInsertPoint();
          }
        }
      }
    } else {
      // Emit objc_sync_exit(expr); as finally's sole statement for
      // @synchronized.
      Value /*P*/ SyncArg = CGF.Builder.CreateLoad(new Address(SyncArgSlot));
      CGF.EmitNounwindRuntimeCall(ObjCTypes.getSyncExitFn(), new ArrayRef<Value /*P*/ >(SyncArg, true));
    }
  }

  
  @Override public String toString() {
    return "" + "S=" + "[Stmt]" // NOI18N
              + ", SyncArgSlot=" + SyncArgSlot // NOI18N
              + ", CallTryExitVar=" + CallTryExitVar // NOI18N
              + ", ExceptionData=" + ExceptionData // NOI18N
              + ", ObjCTypes=" + ObjCTypes // NOI18N
              + super.toString(); // NOI18N
  }
}
