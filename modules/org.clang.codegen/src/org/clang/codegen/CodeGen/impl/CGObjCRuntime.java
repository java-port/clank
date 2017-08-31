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

import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import static org.clang.ast.ASTContextGlobals.*;
import org.clang.basic.*;
import org.llvm.ir.*;
import org.clang.codegen.impl.*;
import org.clang.codegen.CodeGen.*;
import org.llvm.ir.PointerType;
import org.llvm.ir.Type;
import static org.llvm.ir.java.IrRTTI.*;
import static org.clang.codegen.impl.CGObjCRuntimeStatics.*;


// FIXME: Several methods should be pure virtual but aren't to avoid the
// partially-implemented subclass breaking.

/// Implements runtime-specific code generation functions.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGObjCRuntime">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCRuntime.h", line = 63,
 FQN="clang::CodeGen::CGObjCRuntime", NM="_ZN5clang7CodeGen13CGObjCRuntimeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN5clang7CodeGen13CGObjCRuntimeE")
//</editor-fold>
public abstract class CGObjCRuntime implements Destructors.ClassWithDestructor {
/*protected:*/
  protected final CodeGenModule /*&*/ CGM;
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGObjCRuntime::CGObjCRuntime">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCRuntime.h", line = 66,
   FQN="clang::CodeGen::CGObjCRuntime::CGObjCRuntime", NM="_ZN5clang7CodeGen13CGObjCRuntimeC1ERNS0_13CodeGenModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN5clang7CodeGen13CGObjCRuntimeC1ERNS0_13CodeGenModuleE")
  //</editor-fold>
  protected CGObjCRuntime(final CodeGenModule /*&*/ CGM) {
    // : CGM(CGM) 
    //START JInit
    this./*&*/CGM=/*&*/CGM;
    //END JInit
  }

  
  // Utility functions for unified ivar access. These need to
  // eventually be folded into other places (the structure layout
  // code).
  
  /// Compute an offset to the given ivar, suitable for passing to
  /// EmitValueForIvarAtOffset.  Note that the correct handling of
  /// bit-fields is carefully coordinated by these two, use caution!
  ///
  /// The latter overload is suitable for computing the offset of a
  /// sythesized ivar.
  
  // Utility functions for unified ivar access. These need to
  // eventually be folded into other places (the structure layout
  // code).

  /// Compute an offset to the given ivar, suitable for passing to
  /// EmitValueForIvarAtOffset.  Note that the correct handling of
  /// bit-fields is carefully coordinated by these two, use caution!
  ///
  /// The latter overload is suitable for computing the offset of a
  /// sythesized ivar.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGObjCRuntime::ComputeIvarBaseOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCRuntime.cpp", line = 65,
   FQN="clang::CodeGen::CGObjCRuntime::ComputeIvarBaseOffset", NM="_ZN5clang7CodeGen13CGObjCRuntime21ComputeIvarBaseOffsetERNS0_13CodeGenModuleEPKNS_17ObjCInterfaceDeclEPKNS_12ObjCIvarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCRuntime.cpp -nm=_ZN5clang7CodeGen13CGObjCRuntime21ComputeIvarBaseOffsetERNS0_13CodeGenModuleEPKNS_17ObjCInterfaceDeclEPKNS_12ObjCIvarDeclE")
  //</editor-fold>
  protected long/*uint64_t*/ ComputeIvarBaseOffset_1(final CodeGenModule /*&*/ CGM, 
                         /*const*/ ObjCInterfaceDecl /*P*/ OID, 
                         /*const*/ ObjCIvarDecl /*P*/ Ivar) {
    return $div_ulong(LookupFieldBitOffset(CGM, OID, (/*const*/ ObjCImplementationDecl /*P*/ )null, Ivar)
      , CGM.getContext().getCharWidth());
  }


  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGObjCRuntime::ComputeIvarBaseOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCRuntime.cpp", line = 72,
   FQN="clang::CodeGen::CGObjCRuntime::ComputeIvarBaseOffset", NM="_ZN5clang7CodeGen13CGObjCRuntime21ComputeIvarBaseOffsetERNS0_13CodeGenModuleEPKNS_22ObjCImplementationDeclEPKNS_12ObjCIvarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCRuntime.cpp -nm=_ZN5clang7CodeGen13CGObjCRuntime21ComputeIvarBaseOffsetERNS0_13CodeGenModuleEPKNS_22ObjCImplementationDeclEPKNS_12ObjCIvarDeclE")
  //</editor-fold>
  protected long/*uint64_t*/ ComputeIvarBaseOffset(final CodeGenModule /*&*/ CGM, 
                                                                                 /*const*/ ObjCImplementationDecl /*P*/ OID, 
                                                                                 /*const*/ ObjCIvarDecl /*P*/ Ivar) {
    return $div_ulong(LookupFieldBitOffset(CGM, OID.getClassInterface$Const(), OID, Ivar)
      , CGM.getContext().getCharWidth());
  }


  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGObjCRuntime::EmitValueForIvarAtOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCRuntime.cpp", line = 86,
   FQN="clang::CodeGen::CGObjCRuntime::EmitValueForIvarAtOffset", NM="_ZN5clang7CodeGen13CGObjCRuntime24EmitValueForIvarAtOffsetERNS0_15CodeGenFunctionEPKNS_17ObjCInterfaceDeclEPN4llvm5ValueEPKNS_12ObjCIvarDeclEjS9_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCRuntime.cpp -nm=_ZN5clang7CodeGen13CGObjCRuntime24EmitValueForIvarAtOffsetERNS0_15CodeGenFunctionEPKNS_17ObjCInterfaceDeclEPN4llvm5ValueEPKNS_12ObjCIvarDeclEjS9_")
  //</editor-fold>
  protected LValue EmitValueForIvarAtOffset(final CodeGenFunction /*&*/ CGF, 
                          /*const*/ ObjCInterfaceDecl /*P*/ OID, 
                          Value /*P*/ BaseValue, 
                          /*const*/ ObjCIvarDecl /*P*/ Ivar, 
                          /*uint*/int CVRQualifiers, 
                          Value /*P*/ Offset) {
    // Compute (type*) ( (char *) BaseValue + Offset)
    QualType IvarTy = Ivar.getType();
    Type /*P*/ LTy = CGF.CGM.getTypes().ConvertTypeForMem(new QualType(IvarTy));
    Value /*P*/ V = CGF.Builder.CreateBitCast(BaseValue, CGF.Unnamed_field9.Int8PtrTy);
    V = CGF.Builder.CreateInBoundsGEP(V, new ArrayRef<Value /*P*/ >(Offset, true), new Twine(/*KEEP_STR*/"add.ptr"));
    if (!Ivar.isBitField()) {
      V = CGF.Builder.CreateBitCast(V, PointerType.getUnqual(LTy));
      LValue LV = CGF.MakeNaturalAlignAddrLValue(V, new QualType(IvarTy));
      LV.getQuals().addCVRQualifiers(CVRQualifiers);
      return LV;
    }
    
    // We need to compute an access strategy for this bit-field. We are given the
    // offset to the first byte in the bit-field, the sub-byte offset is taken
    // from the original layout. We reuse the normal bit-field access strategy by
    // treating this as an access to a struct where the bit-field is in byte 0,
    // and adjust the containing type size as appropriate.
    //
    // FIXME: Note that currently we make a very conservative estimate of the
    // alignment of the bit-field, because (a) it is not clear what guarantees the
    // runtime makes us, and (b) we don't have a way to specify that the struct is
    // at an alignment plus offset.
    //
    // Note, there is a subtle invariant here: we can only call this routine on
    // non-synthesized ivars but we may be called for synthesized ivars.  However,
    // a synthesized ivar can never be a bit-field, so this is safe.
    long/*uint64_t*/ FieldBitOffset = LookupFieldBitOffset(CGF.CGM, OID, (/*const*/ ObjCImplementationDecl /*P*/ )null, Ivar);
    long/*uint64_t*/ BitOffset = $rem_ulong(FieldBitOffset, CGF.CGM.getContext().getCharWidth());
    long/*uint64_t*/ AlignmentBits = $uint2ulong(CGF.CGM.getTarget().getCharAlign());
    long/*uint64_t*/ BitFieldSize = $uint2ulong(Ivar.getBitWidthValue(CGF.getContext()));
    CharUnits StorageSize = CGF.CGM.getContext().toCharUnitsFromBits(llvm.alignTo(BitOffset + BitFieldSize, AlignmentBits));
    CharUnits Alignment = CGF.CGM.getContext().toCharUnitsFromBits(AlignmentBits);
    
    // Allocate a new CGBitFieldInfo object to describe this access.
    //
    // FIXME: This is incredibly wasteful, these should be uniqued or part of some
    // layout object. However, this is blocked on other cleanups to the
    // Objective-C code, so for now we just live with allocating a bunch of these
    // objects.
    CGBitFieldInfo /*P*/ Info = /*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
    /*new (CGF.CGM.getContext())*/ $new_uint_ASTContext$C_uint(CGF.CGM.getContext(), (type$ptr<?> New$Mem)->{
        return CGBitFieldInfo.MakeInfo(CGF.CGM.getTypes(), Ivar, BitOffset, BitFieldSize, 
                CGF.CGM.getContext().toBits(new CharUnits(StorageSize)), 
                CharUnits.fromQuantity(0));
     });
    
    Address Addr/*J*/= new Address(V, new CharUnits(Alignment));
    Addr.$assignMove(CGF.Builder.CreateElementBitCast(new Address(Addr), 
            Type.getIntNTy(CGF.getLLVMContext(), 
                Info.StorageSize)));
    return LValue.MakeBitfield(new Address(Addr), /*Deref*/Info, 
        IvarTy.withCVRQualifiers(CVRQualifiers), 
        AlignmentSource.Decl);
  }


  /// Emits a try / catch statement.  This function is intended to be called by
  /// subclasses, and provides a generic mechanism for generating these, which
  /// should be usable by all runtimes.  The caller must provide the functions
  /// to call when entering and exiting a \@catch() block, and the function
  /// used to rethrow exceptions.  If the begin and end catch functions are
  /// NULL, then the function assumes that the EH personality function provides
  /// the thrown object directly.
  /// Emits a try / catch statement.  This function is intended to be called by
  /// subclasses, and provides a generic mechanism for generating these, which
  /// should be usable by all runtimes.  The caller must provide the functions
  /// to call when entering and exiting a \@catch() block, and the function
  /// used to rethrow exceptions.  If the begin and end catch functions are
  /// NULL, then the function assumes that the EH personality function provides
  /// the thrown object directly.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGObjCRuntime::EmitTryCatchStmt">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCRuntime.cpp", line = 173,
   FQN="clang::CodeGen::CGObjCRuntime::EmitTryCatchStmt", NM="_ZN5clang7CodeGen13CGObjCRuntime16EmitTryCatchStmtERNS0_15CodeGenFunctionERKNS_13ObjCAtTryStmtEPN4llvm8ConstantES9_S9_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCRuntime.cpp -nm=_ZN5clang7CodeGen13CGObjCRuntime16EmitTryCatchStmtERNS0_15CodeGenFunctionERKNS_13ObjCAtTryStmtEPN4llvm8ConstantES9_S9_")
  //</editor-fold>
  protected void EmitTryCatchStmt(final CodeGenFunction /*&*/ CGF, 
                  final /*const*/ ObjCAtTryStmt /*&*/ S, 
                  Constant /*P*/ beginCatchFn, 
                  Constant /*P*/ endCatchFn, 
                  Constant /*P*/ exceptionRethrowFn) {
    // Jump destination for falling out of catch bodies.
    CodeGenFunction.JumpDest Cont/*J*/= new CodeGenFunction.JumpDest();
    if ((S.getNumCatchStmts() != 0)) {
      Cont.$assignMove(CGF.getJumpDestInCurrentScope(new StringRef(/*KEEP_STR*/"eh.cont")));
    }
    
    CodeGenFunction.FinallyInfo FinallyInfo/*J*/= new CodeGenFunction.FinallyInfo();
    {
      /*const*/ ObjCAtFinallyStmt /*P*/ Finally = S.getFinallyStmt$Const();
      if ((Finally != null)) {
        FinallyInfo.enter(CGF, Finally.getFinallyBody$Const(), 
            beginCatchFn, endCatchFn, exceptionRethrowFn);
      }
    }
    
    SmallVector<CatchHandler> Handlers/*J*/= new SmallVector<CatchHandler>(8, new CatchHandler());
    
    // Enter the catch, if there is one.
    if ((S.getNumCatchStmts() != 0)) {
      for (/*uint*/int I = 0, N = S.getNumCatchStmts(); I != N; ++I) {
        /*const*/ ObjCAtCatchStmt /*P*/ CatchStmt = S.getCatchStmt$Const(I);
        /*const*/ VarDecl /*P*/ CatchDecl = CatchStmt.getCatchParamDecl$Const();
        
        Handlers.push_back(new CatchHandler());
        final CatchHandler /*&*/ Handler = Handlers.back();
        Handler.Variable = CatchDecl;
        Handler.Body = CatchStmt.getCatchBody$Const();
        Handler.Block = CGF.createBasicBlock(new Twine(/*KEEP_STR*/$catch));
        
        // @catch(...) always matches.
        if (!(CatchDecl != null)) {
          Handler.TypeInfo = null; // catch-all
          // Don't consider any other catches.
          break;
        }
        
        Handler.TypeInfo = GetEHType(CatchDecl.getType());
      }
      
      EHCatchScope /*P*/ Catch = CGF.EHStack.pushCatch(Handlers.size());
      for (/*uint*/int I = 0, E = Handlers.size(); I != E; ++I)  {
        Catch.setHandler(I, Handlers.$at(I).TypeInfo, Handlers.$at(I).Block);
      }
    }
    
    // Emit the try body.
    CGF.EmitStmt(S.getTryBody$Const());
    
    // Leave the try.
    if ((S.getNumCatchStmts() != 0)) {
      CGF.popCatchScope();
    }
    
    // Remember where we were.
    CGBuilderTy.InsertPoint SavedIP = CGF.Builder.saveAndClearIP();
    
    // Emit the handlers.
    for (/*uint*/int I = 0, E = Handlers.size(); I != E; ++I) {
      CodeGenFunction.LexicalScope cleanups = null;
      try {
        final CatchHandler /*&*/ Handler = Handlers.$at(I);
        
        CGF.EmitBlock(Handler.Block);
        Value /*P*/ RawExn = CGF.getExceptionFromSlot();
        
        // Enter the catch.
        Value /*P*/ Exn = RawExn;
        if ((beginCatchFn != null)) {
          Exn = CGF.Builder.CreateCall_Value$P_ArrayRef$Value$P_Twine$C_MDNode$P(beginCatchFn, new ArrayRef<Value /*P*/ >(RawExn, true), new Twine(/*KEEP_STR*/"exn.adjusted"));
          cast_CallInst(Exn).setDoesNotThrow();
        }
        
        cleanups/*J*/= new CodeGenFunction.LexicalScope(CGF, Handler.Body.getSourceRange());
        if ((endCatchFn != null)) {
          // Add a cleanup to leave the catch.
          boolean EndCatchMightThrow = (Handler.Variable == null);
          
          CGF.EHStack.<CallObjCEndCatch>pushCleanup$T(CleanupKind.NormalAndEHCleanup, 
              () -> new CallObjCEndCatch(EndCatchMightThrow, 
              endCatchFn));
        }
        {
          
          // Bind the catch parameter if it exists.
          /*const*/ VarDecl /*P*/ CatchParam = Handler.Variable;
          if ((CatchParam != null)) {
            Type /*P*/ CatchType = CGF.ConvertType(CatchParam.getType());
            Value /*P*/ CastExn = CGF.Builder.CreateBitCast(Exn, CatchType);
            
            CGF.EmitAutoVarDecl(/*Deref*/CatchParam);
            EmitInitOfCatchParam(CGF, CastExn, CatchParam);
          }
        }
        
        CGF.ObjCEHValueStack.push_back(Exn);
        CGF.EmitStmt(Handler.Body);
        CGF.ObjCEHValueStack.pop_back();
        
        // Leave any cleanups associated with the catch.
        cleanups.ForceCleanup_LexicalScope();
        
        CGF.EmitBranchThroughCleanup(new CodeGenFunction.JumpDest(Cont));
      } finally {
        if (cleanups != null) { cleanups.$destroy(); }
      }
    }
    
    // Go back to the try-statement fallthrough.
    CGF.Builder.restoreIP(new IRBuilderBase.InsertPoint(SavedIP));
    
    // Pop out of the finally.
    if ((S.getFinallyStmt$Const() != null)) {
      FinallyInfo.exit(CGF);
    }
    if (Cont.isValid()) {
      CGF.EmitBlock(Cont.getBlock());
    }
  }


  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGObjCRuntime::EmitInitOfCatchParam">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCRuntime.cpp", line = 282,
   FQN="clang::CodeGen::CGObjCRuntime::EmitInitOfCatchParam", NM="_ZN5clang7CodeGen13CGObjCRuntime20EmitInitOfCatchParamERNS0_15CodeGenFunctionEPN4llvm5ValueEPKNS_7VarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCRuntime.cpp -nm=_ZN5clang7CodeGen13CGObjCRuntime20EmitInitOfCatchParamERNS0_15CodeGenFunctionEPN4llvm5ValueEPKNS_7VarDeclE")
  //</editor-fold>
  protected void EmitInitOfCatchParam(final CodeGenFunction /*&*/ CGF, 
                      Value /*P*/ exn, 
                      /*const*/ VarDecl /*P*/ paramDecl) {
    
    Address paramAddr = CGF.GetAddrOfLocalVar(paramDecl);
    switch (paramDecl.getType().getQualifiers().getObjCLifetime()) {
     case OCL_Strong:
      exn = CGF.EmitARCRetainNonBlock(exn);
     case OCL_None:
     case OCL_ExplicitNone:
     case OCL_Autoreleasing:
      // fallthrough
      CGF.Builder.CreateStore(exn, new Address(paramAddr));
      return;
     case OCL_Weak:
      CGF.EmitARCInitWeak(new Address(paramAddr), exn);
      return;
    }
    throw new llvm_unreachable("invalid ownership qualifier");
  }


  
  /// Emits an \@synchronize() statement, using the \p syncEnterFn and
  /// \p syncExitFn arguments as the functions called to lock and unlock
  /// the object.  This function can be called by subclasses that use
  /// zero-cost exception handling.
  
  /// Emits an \@synchronize() statement, using the \p syncEnterFn and
  /// \p syncExitFn arguments as the functions called to lock and unlock
  /// the object.  This function can be called by subclasses that use
  /// zero-cost exception handling.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGObjCRuntime::EmitAtSynchronizedStmt">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCRuntime.cpp", line = 319,
   FQN="clang::CodeGen::CGObjCRuntime::EmitAtSynchronizedStmt", NM="_ZN5clang7CodeGen13CGObjCRuntime22EmitAtSynchronizedStmtERNS0_15CodeGenFunctionERKNS_22ObjCAtSynchronizedStmtEPN4llvm8FunctionES9_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCRuntime.cpp -nm=_ZN5clang7CodeGen13CGObjCRuntime22EmitAtSynchronizedStmtERNS0_15CodeGenFunctionERKNS_22ObjCAtSynchronizedStmtEPN4llvm8FunctionES9_")
  //</editor-fold>
  protected void EmitAtSynchronizedStmt(final CodeGenFunction /*&*/ CGF, 
                        final /*const*/ ObjCAtSynchronizedStmt /*&*/ S, 
                        Function /*P*/ syncEnterFn, 
                        Function /*P*/ syncExitFn) {
    CodeGenFunction.RunCleanupsScope cleanups = null;
    try {
      cleanups/*J*/= new CodeGenFunction.RunCleanupsScope(CGF);
      
      // Evaluate the lock operand.  This is guaranteed to dominate the
      // ARC release and lock-release cleanups.
      /*const*/ Expr /*P*/ lockExpr = S.getSynchExpr$Const();
      Value /*P*/ lock;
      if (CGF.getLangOpts().ObjCAutoRefCount) {
        lock = CGF.EmitARCRetainScalarExpr(lockExpr);
        lock = CGF.EmitObjCConsumeObject(lockExpr.getType(), lock);
      } else {
        lock = CGF.EmitScalarExpr(lockExpr);
      }
      lock = CGF.Builder.CreateBitCast(lock, CGF.Unnamed_field9.VoidPtrTy);
      
      // Acquire the lock.
      CGF.Builder.CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P(syncEnterFn, new ArrayRef<Value /*P*/ >(lock, true)).setDoesNotThrow();
      
      // Register an all-paths cleanup to release the lock.
      final Value $lock = lock;
      CGF.EHStack.<CallSyncExit>pushCleanup$T(CleanupKind.NormalAndEHCleanup, () -> new CallSyncExit(syncExitFn, $lock));
      
      // Emit the body of the statement.
      CGF.EmitStmt(S.getSynchBody$Const());
    } finally {
      if (cleanups != null) { cleanups.$destroy(); }
    }
  }


/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGObjCRuntime::~CGObjCRuntime">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 3370,
   FQN="clang::CodeGen::CGObjCRuntime::~CGObjCRuntime", NM="_ZN5clang7CodeGen13CGObjCRuntimeD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN5clang7CodeGen13CGObjCRuntimeD0Ev")
  //</editor-fold>
  public void $destroy() {
  }

  
  /// Generate the function required to register all Objective-C components in
  /// this compilation unit with the runtime library.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGObjCRuntime::ModuleInitFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCRuntime.h", line = 121,
   FQN="clang::CodeGen::CGObjCRuntime::ModuleInitFunction", NM="_ZN5clang7CodeGen13CGObjCRuntime18ModuleInitFunctionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN5clang7CodeGen13CGObjCRuntime18ModuleInitFunctionEv")
  //</editor-fold>
  public abstract /*virtual*/ Function /*P*/ ModuleInitFunction()/* = 0*/;

  
  /// Get a selector for the specified name and type values.
  /// The result should have the LLVM type for ASTContext::getObjCSelType().
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGObjCRuntime::GetSelector">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCRuntime.h", line = 125,
   FQN="clang::CodeGen::CGObjCRuntime::GetSelector", NM="_ZN5clang7CodeGen13CGObjCRuntime11GetSelectorERNS0_15CodeGenFunctionENS_8SelectorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN5clang7CodeGen13CGObjCRuntime11GetSelectorERNS0_15CodeGenFunctionENS_8SelectorE")
  //</editor-fold>
  public abstract /*virtual*/ Value /*P*/ GetSelector(final CodeGenFunction /*&*/ CGF, Selector Sel)/* = 0*/;

  
  /// Get the address of a selector for the specified name and type values.
  /// This is a rarely-used language extension, but sadly it exists.
  ///
  /// The result should have the LLVM type for a pointer to
  /// ASTContext::getObjCSelType().
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGObjCRuntime::GetAddrOfSelector">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCRuntime.h", line = 132,
   FQN="clang::CodeGen::CGObjCRuntime::GetAddrOfSelector", NM="_ZN5clang7CodeGen13CGObjCRuntime17GetAddrOfSelectorERNS0_15CodeGenFunctionENS_8SelectorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN5clang7CodeGen13CGObjCRuntime17GetAddrOfSelectorERNS0_15CodeGenFunctionENS_8SelectorE")
  //</editor-fold>
  public abstract /*virtual*/ Address GetAddrOfSelector(final CodeGenFunction /*&*/ CGF, Selector Sel)/* = 0*/;

  
  /// Get a typed selector.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGObjCRuntime::GetSelector">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCRuntime.h", line = 135,
   FQN="clang::CodeGen::CGObjCRuntime::GetSelector", NM="_ZN5clang7CodeGen13CGObjCRuntime11GetSelectorERNS0_15CodeGenFunctionEPKNS_14ObjCMethodDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN5clang7CodeGen13CGObjCRuntime11GetSelectorERNS0_15CodeGenFunctionEPKNS_14ObjCMethodDeclE")
  //</editor-fold>
  public abstract /*virtual*/ Value /*P*/ GetSelector(final CodeGenFunction /*&*/ CGF, 
             /*const*/ ObjCMethodDecl /*P*/ Method)/* = 0*/;

  
  /// Get the type constant to catch for the given ObjC pointer type.
  /// This is used externally to implement catching ObjC types in C++.
  /// Runtimes which don't support this should add the appropriate
  /// error to Sema.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGObjCRuntime::GetEHType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCRuntime.h", line = 142,
   FQN="clang::CodeGen::CGObjCRuntime::GetEHType", NM="_ZN5clang7CodeGen13CGObjCRuntime9GetEHTypeENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN5clang7CodeGen13CGObjCRuntime9GetEHTypeENS_8QualTypeE")
  //</editor-fold>
  public abstract /*virtual*/ Constant /*P*/ GetEHType(QualType T)/* = 0*/;

  
  /// Generate a constant string object.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGObjCRuntime::GenerateConstantString">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCRuntime.h", line = 145,
   FQN="clang::CodeGen::CGObjCRuntime::GenerateConstantString", NM="_ZN5clang7CodeGen13CGObjCRuntime22GenerateConstantStringEPKNS_13StringLiteralE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN5clang7CodeGen13CGObjCRuntime22GenerateConstantStringEPKNS_13StringLiteralE")
  //</editor-fold>
  public abstract /*virtual*/ ConstantAddress GenerateConstantString(/*const*/ StringLiteral /*P*/ $Prm0)/* = 0*/;

  
  /// Generate a category.  A category contains a list of methods (and
  /// accompanying metadata) and a list of protocols.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGObjCRuntime::GenerateCategory">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCRuntime.h", line = 149,
   FQN="clang::CodeGen::CGObjCRuntime::GenerateCategory", NM="_ZN5clang7CodeGen13CGObjCRuntime16GenerateCategoryEPKNS_20ObjCCategoryImplDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN5clang7CodeGen13CGObjCRuntime16GenerateCategoryEPKNS_20ObjCCategoryImplDeclE")
  //</editor-fold>
  public abstract /*virtual*/ void GenerateCategory(/*const*/ ObjCCategoryImplDecl /*P*/ OCD)/* = 0*/;

  
  /// Generate a class structure for this class.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGObjCRuntime::GenerateClass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCRuntime.h", line = 152,
   FQN="clang::CodeGen::CGObjCRuntime::GenerateClass", NM="_ZN5clang7CodeGen13CGObjCRuntime13GenerateClassEPKNS_22ObjCImplementationDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN5clang7CodeGen13CGObjCRuntime13GenerateClassEPKNS_22ObjCImplementationDeclE")
  //</editor-fold>
  public abstract /*virtual*/ void GenerateClass(/*const*/ ObjCImplementationDecl /*P*/ OID)/* = 0*/;

  
  /// Register an class alias.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGObjCRuntime::RegisterAlias">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCRuntime.h", line = 155,
   FQN="clang::CodeGen::CGObjCRuntime::RegisterAlias", NM="_ZN5clang7CodeGen13CGObjCRuntime13RegisterAliasEPKNS_23ObjCCompatibleAliasDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN5clang7CodeGen13CGObjCRuntime13RegisterAliasEPKNS_23ObjCCompatibleAliasDeclE")
  //</editor-fold>
  public abstract /*virtual*/ void RegisterAlias(/*const*/ ObjCCompatibleAliasDecl /*P*/ OAD)/* = 0*/;

  
  /// Generate an Objective-C message send operation.
  ///
  /// \param Method - The method being called, this may be null if synthesizing
  /// a property setter or getter.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGObjCRuntime::GenerateMessageSend">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCRuntime.h", line = 161,
   FQN="clang::CodeGen::CGObjCRuntime::GenerateMessageSend", NM="_ZN5clang7CodeGen13CGObjCRuntime19GenerateMessageSendERNS0_15CodeGenFunctionENS0_15ReturnValueSlotENS_8QualTypeENS_8SelectorEPN4llvm5ValueERKNS0_11CallArgListEPKNS_17ObjCInterfaceDeclEPKNS_14ObjCMethodDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN5clang7CodeGen13CGObjCRuntime19GenerateMessageSendERNS0_15CodeGenFunctionENS0_15ReturnValueSlotENS_8QualTypeENS_8SelectorEPN4llvm5ValueERKNS0_11CallArgListEPKNS_17ObjCInterfaceDeclEPKNS_14ObjCMethodDeclE")
  //</editor-fold>
  public abstract /*virtual*/ RValue GenerateMessageSend(final CodeGenFunction /*&*/ CGF, 
                     ReturnValueSlot ReturnSlot, 
                     QualType ResultType, 
                     Selector Sel, 
                     Value /*P*/ Receiver, 
                     final /*const*/ CallArgList /*&*/ CallArgs, 
                     /*const*/ ObjCInterfaceDecl /*P*/ Class/*= null*/, 
                     /*const*/ ObjCMethodDecl /*P*/ Method/*= null*/)/* = 0*/;

  
  /// Generate an Objective-C message send operation to the super
  /// class initiated in a method for Class and with the given Self
  /// object.
  ///
  /// \param Method - The method being called, this may be null if synthesizing
  /// a property setter or getter.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGObjCRuntime::GenerateMessageSendSuper">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCRuntime.h", line = 177,
   FQN="clang::CodeGen::CGObjCRuntime::GenerateMessageSendSuper", NM="_ZN5clang7CodeGen13CGObjCRuntime24GenerateMessageSendSuperERNS0_15CodeGenFunctionENS0_15ReturnValueSlotENS_8QualTypeENS_8SelectorEPKNS_17ObjCInterfaceDeclEbPN4llvm5ValueEbRKNS0_11CallArgListEPKNS_14ObjCMethodDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN5clang7CodeGen13CGObjCRuntime24GenerateMessageSendSuperERNS0_15CodeGenFunctionENS0_15ReturnValueSlotENS_8QualTypeENS_8SelectorEPKNS_17ObjCInterfaceDeclEbPN4llvm5ValueEbRKNS0_11CallArgListEPKNS_14ObjCMethodDeclE")
  //</editor-fold>
  public abstract /*virtual*/ RValue GenerateMessageSendSuper(final CodeGenFunction /*&*/ CGF, 
                          ReturnValueSlot ReturnSlot, 
                          QualType ResultType, 
                          Selector Sel, 
                          /*const*/ ObjCInterfaceDecl /*P*/ Class, 
                          boolean isCategoryImpl, 
                          Value /*P*/ Self, 
                          boolean IsClassMessage, 
                          final /*const*/ CallArgList /*&*/ CallArgs, 
                          /*const*/ ObjCMethodDecl /*P*/ Method/*= null*/)/* = 0*/;

  
  /// Emit the code to return the named protocol as an object, as in a
  /// \@protocol expression.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGObjCRuntime::GenerateProtocolRef">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCRuntime.h", line = 191,
   FQN="clang::CodeGen::CGObjCRuntime::GenerateProtocolRef", NM="_ZN5clang7CodeGen13CGObjCRuntime19GenerateProtocolRefERNS0_15CodeGenFunctionEPKNS_16ObjCProtocolDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN5clang7CodeGen13CGObjCRuntime19GenerateProtocolRefERNS0_15CodeGenFunctionEPKNS_16ObjCProtocolDeclE")
  //</editor-fold>
  public abstract /*virtual*/ Value /*P*/ GenerateProtocolRef(final CodeGenFunction /*&*/ CGF, 
                     /*const*/ ObjCProtocolDecl /*P*/ OPD)/* = 0*/;

  
  /// Generate the named protocol.  Protocols contain method metadata but no
  /// implementations.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGObjCRuntime::GenerateProtocol">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCRuntime.h", line = 196,
   FQN="clang::CodeGen::CGObjCRuntime::GenerateProtocol", NM="_ZN5clang7CodeGen13CGObjCRuntime16GenerateProtocolEPKNS_16ObjCProtocolDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN5clang7CodeGen13CGObjCRuntime16GenerateProtocolEPKNS_16ObjCProtocolDeclE")
  //</editor-fold>
  public abstract /*virtual*/ void GenerateProtocol(/*const*/ ObjCProtocolDecl /*P*/ OPD)/* = 0*/;

  
  /// Generate a function preamble for a method with the specified
  /// types.
  
  // FIXME: Current this just generates the Function definition, but really this
  // should also be generating the loads of the parameters, as the runtime
  // should have full control over how parameters are passed.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGObjCRuntime::GenerateMethod">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCRuntime.h", line = 204,
   FQN="clang::CodeGen::CGObjCRuntime::GenerateMethod", NM="_ZN5clang7CodeGen13CGObjCRuntime14GenerateMethodEPKNS_14ObjCMethodDeclEPKNS_17ObjCContainerDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN5clang7CodeGen13CGObjCRuntime14GenerateMethodEPKNS_14ObjCMethodDeclEPKNS_17ObjCContainerDeclE")
  //</editor-fold>
  public abstract /*virtual*/ Function /*P*/ GenerateMethod(/*const*/ ObjCMethodDecl /*P*/ OMD, 
                /*const*/ ObjCContainerDecl /*P*/ CD)/* = 0*/;

  
  /// Return the runtime function for getting properties.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGObjCRuntime::GetPropertyGetFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCRuntime.h", line = 208,
   FQN="clang::CodeGen::CGObjCRuntime::GetPropertyGetFunction", NM="_ZN5clang7CodeGen13CGObjCRuntime22GetPropertyGetFunctionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN5clang7CodeGen13CGObjCRuntime22GetPropertyGetFunctionEv")
  //</editor-fold>
  public abstract /*virtual*/ Constant /*P*/ GetPropertyGetFunction()/* = 0*/;

  
  /// Return the runtime function for setting properties.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGObjCRuntime::GetPropertySetFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCRuntime.h", line = 211,
   FQN="clang::CodeGen::CGObjCRuntime::GetPropertySetFunction", NM="_ZN5clang7CodeGen13CGObjCRuntime22GetPropertySetFunctionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN5clang7CodeGen13CGObjCRuntime22GetPropertySetFunctionEv")
  //</editor-fold>
  public abstract /*virtual*/ Constant /*P*/ GetPropertySetFunction()/* = 0*/;

  
  /// Return the runtime function for optimized setting properties.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGObjCRuntime::GetOptimizedPropertySetFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCRuntime.h", line = 214,
   FQN="clang::CodeGen::CGObjCRuntime::GetOptimizedPropertySetFunction", NM="_ZN5clang7CodeGen13CGObjCRuntime31GetOptimizedPropertySetFunctionEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN5clang7CodeGen13CGObjCRuntime31GetOptimizedPropertySetFunctionEbb")
  //</editor-fold>
  public abstract /*virtual*/ Constant /*P*/ GetOptimizedPropertySetFunction(boolean atomic, 
                                 boolean copy)/* = 0*/;

  
  // API for atomic copying of qualified aggregates in getter.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGObjCRuntime::GetGetStructFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCRuntime.h", line = 218,
   FQN="clang::CodeGen::CGObjCRuntime::GetGetStructFunction", NM="_ZN5clang7CodeGen13CGObjCRuntime20GetGetStructFunctionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN5clang7CodeGen13CGObjCRuntime20GetGetStructFunctionEv")
  //</editor-fold>
  public abstract /*virtual*/ Constant /*P*/ GetGetStructFunction()/* = 0*/;

  // API for atomic copying of qualified aggregates in setter.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGObjCRuntime::GetSetStructFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCRuntime.h", line = 220,
   FQN="clang::CodeGen::CGObjCRuntime::GetSetStructFunction", NM="_ZN5clang7CodeGen13CGObjCRuntime20GetSetStructFunctionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN5clang7CodeGen13CGObjCRuntime20GetSetStructFunctionEv")
  //</editor-fold>
  public abstract /*virtual*/ Constant /*P*/ GetSetStructFunction()/* = 0*/;

  /// API for atomic copying of qualified aggregates with non-trivial copy
  /// assignment (c++) in setter.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGObjCRuntime::GetCppAtomicObjectSetFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCRuntime.h", line = 223,
   FQN="clang::CodeGen::CGObjCRuntime::GetCppAtomicObjectSetFunction", NM="_ZN5clang7CodeGen13CGObjCRuntime29GetCppAtomicObjectSetFunctionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN5clang7CodeGen13CGObjCRuntime29GetCppAtomicObjectSetFunctionEv")
  //</editor-fold>
  public abstract /*virtual*/ Constant /*P*/ GetCppAtomicObjectSetFunction()/* = 0*/;

  /// API for atomic copying of qualified aggregates with non-trivial copy
  /// assignment (c++) in getter.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGObjCRuntime::GetCppAtomicObjectGetFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCRuntime.h", line = 226,
   FQN="clang::CodeGen::CGObjCRuntime::GetCppAtomicObjectGetFunction", NM="_ZN5clang7CodeGen13CGObjCRuntime29GetCppAtomicObjectGetFunctionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN5clang7CodeGen13CGObjCRuntime29GetCppAtomicObjectGetFunctionEv")
  //</editor-fold>
  public abstract /*virtual*/ Constant /*P*/ GetCppAtomicObjectGetFunction()/* = 0*/;

  
  /// GetClass - Return a reference to the class for the given
  /// interface decl.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGObjCRuntime::GetClass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCRuntime.h", line = 230,
   FQN="clang::CodeGen::CGObjCRuntime::GetClass", NM="_ZN5clang7CodeGen13CGObjCRuntime8GetClassERNS0_15CodeGenFunctionEPKNS_17ObjCInterfaceDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN5clang7CodeGen13CGObjCRuntime8GetClassERNS0_15CodeGenFunctionEPKNS_17ObjCInterfaceDeclE")
  //</editor-fold>
  public abstract /*virtual*/ Value /*P*/ GetClass(final CodeGenFunction /*&*/ CGF, 
          /*const*/ ObjCInterfaceDecl /*P*/ OID)/* = 0*/;

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGObjCRuntime::EmitNSAutoreleasePoolClassRef">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCRuntime.h", line = 234,
   FQN="clang::CodeGen::CGObjCRuntime::EmitNSAutoreleasePoolClassRef", NM="_ZN5clang7CodeGen13CGObjCRuntime29EmitNSAutoreleasePoolClassRefERNS0_15CodeGenFunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN5clang7CodeGen13CGObjCRuntime29EmitNSAutoreleasePoolClassRefERNS0_15CodeGenFunctionE")
  //</editor-fold>
  public /*virtual*/ Value /*P*/ EmitNSAutoreleasePoolClassRef(final CodeGenFunction /*&*/ CGF) {
    throw new llvm_unreachable("autoreleasepool unsupported in this ABI");
  }

  
  /// EnumerationMutationFunction - Return the function that's called by the
  /// compiler when a mutation is detected during foreach iteration.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGObjCRuntime::EnumerationMutationFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCRuntime.h", line = 240,
   FQN="clang::CodeGen::CGObjCRuntime::EnumerationMutationFunction", NM="_ZN5clang7CodeGen13CGObjCRuntime27EnumerationMutationFunctionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN5clang7CodeGen13CGObjCRuntime27EnumerationMutationFunctionEv")
  //</editor-fold>
  public abstract /*virtual*/ Constant /*P*/ EnumerationMutationFunction()/* = 0*/;

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGObjCRuntime::EmitSynchronizedStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCRuntime.h", line = 242,
   FQN="clang::CodeGen::CGObjCRuntime::EmitSynchronizedStmt", NM="_ZN5clang7CodeGen13CGObjCRuntime20EmitSynchronizedStmtERNS0_15CodeGenFunctionERKNS_22ObjCAtSynchronizedStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN5clang7CodeGen13CGObjCRuntime20EmitSynchronizedStmtERNS0_15CodeGenFunctionERKNS_22ObjCAtSynchronizedStmtE")
  //</editor-fold>
  public abstract /*virtual*/ void EmitSynchronizedStmt(final CodeGenFunction /*&*/ CGF, 
                      final /*const*/ ObjCAtSynchronizedStmt /*&*/ S)/* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGObjCRuntime::EmitTryStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCRuntime.h", line = 244,
   FQN="clang::CodeGen::CGObjCRuntime::EmitTryStmt", NM="_ZN5clang7CodeGen13CGObjCRuntime11EmitTryStmtERNS0_15CodeGenFunctionERKNS_13ObjCAtTryStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN5clang7CodeGen13CGObjCRuntime11EmitTryStmtERNS0_15CodeGenFunctionERKNS_13ObjCAtTryStmtE")
  //</editor-fold>
  public abstract /*virtual*/ void EmitTryStmt(final CodeGenFunction /*&*/ CGF, 
             final /*const*/ ObjCAtTryStmt /*&*/ S)/* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGObjCRuntime::EmitThrowStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCRuntime.h", line = 246,
   FQN="clang::CodeGen::CGObjCRuntime::EmitThrowStmt", NM="_ZN5clang7CodeGen13CGObjCRuntime13EmitThrowStmtERNS0_15CodeGenFunctionERKNS_15ObjCAtThrowStmtEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN5clang7CodeGen13CGObjCRuntime13EmitThrowStmtERNS0_15CodeGenFunctionERKNS_15ObjCAtThrowStmtEb")
  //</editor-fold>
  public abstract /*virtual*/ void EmitThrowStmt(final CodeGenFunction /*&*/ CGF, 
               final /*const*/ ObjCAtThrowStmt /*&*/ S, 
               boolean ClearInsertionPoint/*= true*/)/* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGObjCRuntime::EmitObjCWeakRead">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCRuntime.h", line = 249,
   FQN="clang::CodeGen::CGObjCRuntime::EmitObjCWeakRead", NM="_ZN5clang7CodeGen13CGObjCRuntime16EmitObjCWeakReadERNS0_15CodeGenFunctionENS0_7AddressE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN5clang7CodeGen13CGObjCRuntime16EmitObjCWeakReadERNS0_15CodeGenFunctionENS0_7AddressE")
  //</editor-fold>
  public abstract /*virtual*/ Value /*P*/ EmitObjCWeakRead(final CodeGenFunction /*&*/ CGF, 
                  Address AddrWeakObj)/* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGObjCRuntime::EmitObjCWeakAssign">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCRuntime.h", line = 251,
   FQN="clang::CodeGen::CGObjCRuntime::EmitObjCWeakAssign", NM="_ZN5clang7CodeGen13CGObjCRuntime18EmitObjCWeakAssignERNS0_15CodeGenFunctionEPN4llvm5ValueENS0_7AddressE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN5clang7CodeGen13CGObjCRuntime18EmitObjCWeakAssignERNS0_15CodeGenFunctionEPN4llvm5ValueENS0_7AddressE")
  //</editor-fold>
  public abstract /*virtual*/ void EmitObjCWeakAssign(final CodeGenFunction /*&*/ CGF, 
                    Value /*P*/ src, Address dest)/* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGObjCRuntime::EmitObjCGlobalAssign">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCRuntime.h", line = 253,
   FQN="clang::CodeGen::CGObjCRuntime::EmitObjCGlobalAssign", NM="_ZN5clang7CodeGen13CGObjCRuntime20EmitObjCGlobalAssignERNS0_15CodeGenFunctionEPN4llvm5ValueENS0_7AddressEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN5clang7CodeGen13CGObjCRuntime20EmitObjCGlobalAssignERNS0_15CodeGenFunctionEPN4llvm5ValueENS0_7AddressEb")
  //</editor-fold>
  public abstract /*virtual*/ void EmitObjCGlobalAssign(final CodeGenFunction /*&*/ CGF, 
                      Value /*P*/ src, Address dest, 
                      boolean threadlocal/*= false*/)/* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGObjCRuntime::EmitObjCIvarAssign">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCRuntime.h", line = 256,
   FQN="clang::CodeGen::CGObjCRuntime::EmitObjCIvarAssign", NM="_ZN5clang7CodeGen13CGObjCRuntime18EmitObjCIvarAssignERNS0_15CodeGenFunctionEPN4llvm5ValueENS0_7AddressES6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN5clang7CodeGen13CGObjCRuntime18EmitObjCIvarAssignERNS0_15CodeGenFunctionEPN4llvm5ValueENS0_7AddressES6_")
  //</editor-fold>
  public abstract /*virtual*/ void EmitObjCIvarAssign(final CodeGenFunction /*&*/ CGF, 
                    Value /*P*/ src, Address dest, 
                    Value /*P*/ ivarOffset)/* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGObjCRuntime::EmitObjCStrongCastAssign">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCRuntime.h", line = 259,
   FQN="clang::CodeGen::CGObjCRuntime::EmitObjCStrongCastAssign", NM="_ZN5clang7CodeGen13CGObjCRuntime24EmitObjCStrongCastAssignERNS0_15CodeGenFunctionEPN4llvm5ValueENS0_7AddressE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN5clang7CodeGen13CGObjCRuntime24EmitObjCStrongCastAssignERNS0_15CodeGenFunctionEPN4llvm5ValueENS0_7AddressE")
  //</editor-fold>
  public abstract /*virtual*/ void EmitObjCStrongCastAssign(final CodeGenFunction /*&*/ CGF, 
                          Value /*P*/ src, Address dest)/* = 0*/;

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGObjCRuntime::EmitObjCValueForIvar">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCRuntime.h", line = 262,
   FQN="clang::CodeGen::CGObjCRuntime::EmitObjCValueForIvar", NM="_ZN5clang7CodeGen13CGObjCRuntime20EmitObjCValueForIvarERNS0_15CodeGenFunctionENS_8QualTypeEPN4llvm5ValueEPKNS_12ObjCIvarDeclEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN5clang7CodeGen13CGObjCRuntime20EmitObjCValueForIvarERNS0_15CodeGenFunctionENS_8QualTypeEPN4llvm5ValueEPKNS_12ObjCIvarDeclEj")
  //</editor-fold>
  public abstract /*virtual*/ LValue EmitObjCValueForIvar(final CodeGenFunction /*&*/ CGF, 
                      QualType ObjectTy, 
                      Value /*P*/ BaseValue, 
                      /*const*/ ObjCIvarDecl /*P*/ Ivar, 
                      /*uint*/int CVRQualifiers)/* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGObjCRuntime::EmitIvarOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCRuntime.h", line = 267,
   FQN="clang::CodeGen::CGObjCRuntime::EmitIvarOffset", NM="_ZN5clang7CodeGen13CGObjCRuntime14EmitIvarOffsetERNS0_15CodeGenFunctionEPKNS_17ObjCInterfaceDeclEPKNS_12ObjCIvarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN5clang7CodeGen13CGObjCRuntime14EmitIvarOffsetERNS0_15CodeGenFunctionEPKNS_17ObjCInterfaceDeclEPKNS_12ObjCIvarDeclE")
  //</editor-fold>
  public abstract /*virtual*/ Value /*P*/ EmitIvarOffset(final CodeGenFunction /*&*/ CGF, 
                /*const*/ ObjCInterfaceDecl /*P*/ Interface, 
                /*const*/ ObjCIvarDecl /*P*/ Ivar)/* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGObjCRuntime::EmitGCMemmoveCollectable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCRuntime.h", line = 270,
   FQN="clang::CodeGen::CGObjCRuntime::EmitGCMemmoveCollectable", NM="_ZN5clang7CodeGen13CGObjCRuntime24EmitGCMemmoveCollectableERNS0_15CodeGenFunctionENS0_7AddressES4_PN4llvm5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN5clang7CodeGen13CGObjCRuntime24EmitGCMemmoveCollectableERNS0_15CodeGenFunctionENS0_7AddressES4_PN4llvm5ValueE")
  //</editor-fold>
  public abstract /*virtual*/ void EmitGCMemmoveCollectable(final CodeGenFunction /*&*/ CGF, 
                          Address DestPtr, 
                          Address SrcPtr, 
                          Value /*P*/ Size)/* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGObjCRuntime::BuildGCBlockLayout">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCRuntime.h", line = 274,
   FQN="clang::CodeGen::CGObjCRuntime::BuildGCBlockLayout", NM="_ZN5clang7CodeGen13CGObjCRuntime18BuildGCBlockLayoutERNS0_13CodeGenModuleERKNS0_11CGBlockInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN5clang7CodeGen13CGObjCRuntime18BuildGCBlockLayoutERNS0_13CodeGenModuleERKNS0_11CGBlockInfoE")
  //</editor-fold>
  public abstract /*virtual*/ Constant /*P*/ BuildGCBlockLayout(final CodeGenModule /*&*/ CGM, 
                    final /*const*/ CGBlockInfo /*&*/ blockInfo)/* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGObjCRuntime::BuildRCBlockLayout">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCRuntime.h", line = 276,
   FQN="clang::CodeGen::CGObjCRuntime::BuildRCBlockLayout", NM="_ZN5clang7CodeGen13CGObjCRuntime18BuildRCBlockLayoutERNS0_13CodeGenModuleERKNS0_11CGBlockInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN5clang7CodeGen13CGObjCRuntime18BuildRCBlockLayoutERNS0_13CodeGenModuleERKNS0_11CGBlockInfoE")
  //</editor-fold>
  public abstract /*virtual*/ Constant /*P*/ BuildRCBlockLayout(final CodeGenModule /*&*/ CGM, 
                    final /*const*/ CGBlockInfo /*&*/ blockInfo)/* = 0*/;

  
  /// Returns an i8* which points to the byref layout information.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGObjCRuntime::BuildByrefLayout">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCRuntime.h", line = 280,
   FQN="clang::CodeGen::CGObjCRuntime::BuildByrefLayout", NM="_ZN5clang7CodeGen13CGObjCRuntime16BuildByrefLayoutERNS0_13CodeGenModuleENS_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN5clang7CodeGen13CGObjCRuntime16BuildByrefLayoutERNS0_13CodeGenModuleENS_8QualTypeE")
  //</editor-fold>
  public abstract /*virtual*/ Constant /*P*/ BuildByrefLayout(final CodeGenModule /*&*/ CGM, 
                  QualType T)/* = 0*/;

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGObjCRuntime::GetClassGlobal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCRuntime.h", line = 283,
   FQN="clang::CodeGen::CGObjCRuntime::GetClassGlobal", NM="_ZN5clang7CodeGen13CGObjCRuntime14GetClassGlobalEN4llvm9StringRefEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN5clang7CodeGen13CGObjCRuntime14GetClassGlobalEN4llvm9StringRefEb")
  //</editor-fold>
  public abstract /*virtual*/ GlobalVariable /*P*/ GetClassGlobal(StringRef Name, 
                boolean Weak/*= false*/)/* = 0*/;

  
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGObjCRuntime::MessageSendInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCRuntime.h", line = 286,
   FQN="clang::CodeGen::CGObjCRuntime::MessageSendInfo", NM="_ZN5clang7CodeGen13CGObjCRuntime15MessageSendInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN5clang7CodeGen13CGObjCRuntime15MessageSendInfoE")
  //</editor-fold>
  public static class/*struct*/ MessageSendInfo {
    public final /*const*/ CGFunctionInfo /*&*/ CallInfo;
    public PointerType /*P*/ MessengerType;
    
    //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGObjCRuntime::MessageSendInfo::MessageSendInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCRuntime.h", line = 290,
     FQN="clang::CodeGen::CGObjCRuntime::MessageSendInfo::MessageSendInfo", NM="_ZN5clang7CodeGen13CGObjCRuntime15MessageSendInfoC1ERKNS0_14CGFunctionInfoEPN4llvm11PointerTypeE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN5clang7CodeGen13CGObjCRuntime15MessageSendInfoC1ERKNS0_14CGFunctionInfoEPN4llvm11PointerTypeE")
    //</editor-fold>
    public MessageSendInfo(final /*const*/ CGFunctionInfo /*&*/ callInfo, 
        PointerType /*P*/ messengerType) {
      // : CallInfo(callInfo), MessengerType(messengerType) 
      //START JInit
      this./*&*/CallInfo=/*&*/callInfo;
      this.MessengerType = messengerType;
      //END JInit
    }


    //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGObjCRuntime::MessageSendInfo::MessageSendInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCRuntime.h", line = 286,
     FQN="clang::CodeGen::CGObjCRuntime::MessageSendInfo::MessageSendInfo", NM="_ZN5clang7CodeGen13CGObjCRuntime15MessageSendInfoC1EOS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCRuntime.cpp -nm=_ZN5clang7CodeGen13CGObjCRuntime15MessageSendInfoC1EOS2_")
    //</editor-fold>
    public /*inline*/ MessageSendInfo(JD$Move _dparam, final MessageSendInfo /*&&*/$Prm0) {
      // : CallInfo(static_cast<MessageSendInfo &&>().CallInfo), MessengerType(static_cast<MessageSendInfo &&>().MessengerType) 
      //START JInit
      this./*&*/CallInfo=/*&*/$Prm0.CallInfo;
      this.MessengerType = $Prm0.MessengerType;
      //END JInit
    }

    
    @Override public String toString() {
      return "" + "CallInfo=" + CallInfo // NOI18N
                + ", MessengerType=" + MessengerType; // NOI18N
    }
  };
  
  /// Compute the pointer-to-function type to which a message send
  /// should be casted in order to correctly call the given method
  /// with the given arguments.
  ///
  /// \param method - may be null
  /// \param resultType - the result type to use if there's no method
  /// \param callArgs - the actual arguments, including implicit ones
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGObjCRuntime::getMessageSendInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCRuntime.cpp", line = 354,
   FQN="clang::CodeGen::CGObjCRuntime::getMessageSendInfo", NM="_ZN5clang7CodeGen13CGObjCRuntime18getMessageSendInfoEPKNS_14ObjCMethodDeclENS_8QualTypeERNS0_11CallArgListE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCRuntime.cpp -nm=_ZN5clang7CodeGen13CGObjCRuntime18getMessageSendInfoEPKNS_14ObjCMethodDeclENS_8QualTypeERNS0_11CallArgListE")
  //</editor-fold>
  public CGObjCRuntime.MessageSendInfo getMessageSendInfo(/*const*/ ObjCMethodDecl /*P*/ method, 
                    QualType resultType, 
                    final CallArgList /*&*/ callArgs) {
    // If there's a method, use information from that.
    if ((method != null)) {
      final /*const*/ CGFunctionInfo /*&*/ signature = CGM.getTypes().arrangeObjCMessageSendSignature(method, new QualType(callArgs.$at(0).Ty));
      
      PointerType /*P*/ signatureType = CGM.getTypes().GetFunctionType(signature).getPointerTo();
      
      final /*const*/ CGFunctionInfo /*&*/ signatureForCall = CGM.getTypes().arrangeCall(signature, callArgs);
      
      return new MessageSendInfo(signatureForCall, signatureType);
    }
    
    // There's no method;  just use a default CC.
    final /*const*/ CGFunctionInfo /*&*/ argsInfo = CGM.getTypes().arrangeUnprototypedObjCMessageSend(new QualType(resultType), callArgs);
    
    // Derive the signature to call from that.
    PointerType /*P*/ signatureType = CGM.getTypes().GetFunctionType(argsInfo).getPointerTo();
    return new MessageSendInfo(argsInfo, signatureType);
  }


  
  // FIXME: This probably shouldn't be here, but the code to compute
  // it is here.
  
  // FIXME: This probably shouldn't be here, but the code to compute
  // it is here.
  //<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CGObjCRuntime::ComputeBitfieldBitOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCRuntime.cpp", line = 79,
   FQN="clang::CodeGen::CGObjCRuntime::ComputeBitfieldBitOffset", NM="_ZN5clang7CodeGen13CGObjCRuntime24ComputeBitfieldBitOffsetERNS0_13CodeGenModuleEPKNS_17ObjCInterfaceDeclEPKNS_12ObjCIvarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCRuntime.cpp -nm=_ZN5clang7CodeGen13CGObjCRuntime24ComputeBitfieldBitOffsetERNS0_13CodeGenModuleEPKNS_17ObjCInterfaceDeclEPKNS_12ObjCIvarDeclE")
  //</editor-fold>
  public /*uint*/int ComputeBitfieldBitOffset(final CodeGenModule /*&*/ CGM, 
                          /*const*/ ObjCInterfaceDecl /*P*/ ID, 
                          /*const*/ ObjCIvarDecl /*P*/ Ivar) {
    return $ulong2uint(LookupFieldBitOffset(CGM, ID, ID.getImplementation(), Ivar));
  }


  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public final /*virtual*/ RValue GenerateMessageSend(final CodeGenFunction /*&*/ CGF, 
                     ReturnValueSlot ReturnSlot, 
                     QualType ResultType, 
                     Selector Sel, 
                     Value /*P*/ Receiver, 
                     final /*const*/ CallArgList /*&*/ CallArgs) /* = 0*/ {
    return GenerateMessageSend(CGF, ReturnSlot, ResultType, Sel, Receiver, CallArgs, null);
  }
  public final /*virtual*/ RValue GenerateMessageSend(final CodeGenFunction /*&*/ CGF, 
                     ReturnValueSlot ReturnSlot, 
                     QualType ResultType, 
                     Selector Sel, 
                     Value /*P*/ Receiver, 
                     final /*const*/ CallArgList /*&*/ CallArgs, 
                     /*const*/ ObjCInterfaceDecl /*P*/ Class/*= null*/)/* = 0*/{
    return GenerateMessageSend(CGF, ReturnSlot, ResultType, Sel, Receiver, CallArgs, Class, null);
  }
  public final /*virtual*/ RValue GenerateMessageSendSuper(final CodeGenFunction /*&*/ CGF, 
                          ReturnValueSlot ReturnSlot, 
                          QualType ResultType, 
                          Selector Sel, 
                          /*const*/ ObjCInterfaceDecl /*P*/ Class, 
                          boolean isCategoryImpl, 
                          Value /*P*/ Self, 
                          boolean IsClassMessage, 
                          final /*const*/ CallArgList /*&*/ CallArgs)/* = 0*/ {
    return GenerateMessageSendSuper(CGF, ReturnSlot, ResultType, Sel, Class, isCategoryImpl, Self, IsClassMessage, CallArgs, null);
  }
  public /*virtual*/ Function /*P*/ GenerateMethod(/*const*/ ObjCMethodDecl /*P*/ OMD)/* = 0*/ {
    return GenerateMethod(OMD, null);
  }
  public /*virtual*/ void EmitThrowStmt(final CodeGenFunction /*&*/ CGF, 
               final /*const*/ ObjCAtThrowStmt /*&*/ S)/* = 0*/ {
    EmitThrowStmt(CGF, S, true);
  }
  public /*virtual*/ void EmitObjCGlobalAssign(final CodeGenFunction /*&*/ CGF, 
                      Value /*P*/ src, Address dest)/* = 0*/ {
    EmitObjCGlobalAssign(CGF, src, dest, false);
  }
  public /*virtual*/ GlobalVariable /*P*/ GetClassGlobal(StringRef Name)/* = 0*/{
    return GetClassGlobal(Name, false);
  }


  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "CGM=" + CGM; // NOI18N
  }
}
