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

package org.clang.analysis.impl;

import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import org.clang.basic.*;
import org.clang.analysis.impl.*;
import static org.clang.ast.java.AstRTTI.*;
import org.clang.analysis.analyses.threadSafety.*;
import static org.clang.analysis.analyses.threadSafety.ThreadSafetyGlobals.*;
import static org.clang.analysis.impl.ThreadSafetyStatics.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstAttributesRTTI.*;


/// \brief We use this class to visit different types of expressions in
/// CFGBlocks, and build up the lockset.
/// An expression may cause us to add or remove locks from the lockset, or else
/// output error messages related to missing locks.
/// FIXME: In future, we may be able to not inherit from a visitor.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BuildLockset">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 1459,
 FQN="(anonymous namespace)::BuildLockset", NM="_ZN12_GLOBAL__N_112BuildLocksetE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN12_GLOBAL__N_112BuildLocksetE")
//</editor-fold>
public class BuildLockset implements /*public*/ StmtVisitorVoid<BuildLockset>, Destructors.ClassWithDestructor {
  /*friend  class ThreadSafetyAnalyzer*/
  
  private ThreadSafetyAnalyzer /*P*/ Analyzer;
   /*friend*/protected/*private*/ FactSet FSet;
  private ImmutableMapPtrUInt</*const*/ NamedDecl /*P*/ > LVarCtx;
  private /*uint*/int CtxIndex;
  
  // helper functions
  // namespace
  
  /// \brief Warn if the LSet does not contain a lock sufficient to protect access
  /// of at least the passed in AccessKind.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BuildLockset::warnIfMutexNotHeld">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 1501,
   FQN="(anonymous namespace)::BuildLockset::warnIfMutexNotHeld", NM="_ZN12_GLOBAL__N_112BuildLockset18warnIfMutexNotHeldEPKN5clang9NamedDeclEPKNS1_4ExprENS1_12threadSafety10AccessKindEPS5_NS8_22ProtectedOperationKindEN4llvm9StringRefENS1_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN12_GLOBAL__N_112BuildLockset18warnIfMutexNotHeldEPKN5clang9NamedDeclEPKNS1_4ExprENS1_12threadSafety10AccessKindEPS5_NS8_22ProtectedOperationKindEN4llvm9StringRefENS1_14SourceLocationE")
  //</editor-fold>
  private void warnIfMutexNotHeld(/*const*/ NamedDecl /*P*/ D, /*const*/ Expr /*P*/ Exp, 
                    AccessKind AK, Expr /*P*/ MutexExp, 
                    ProtectedOperationKind POK, 
                    StringRef DiagKind, SourceLocation Loc) {
    LockKind LK = getLockKindFromAccessKind(AK);
    
    CapabilityExpr Cp = Analyzer.SxBuilder.translateAttrExpr(MutexExp, D, Exp);
    if (Cp.isInvalid()) {
      warnInvalidLock(Analyzer.Handler, MutexExp, D, Exp, new StringRef(DiagKind));
      return;
    } else if (Cp.shouldIgnore()) {
      return;
    }
    if (Cp.negative()) {
      // Negative capabilities act like locks excluded
      FactEntry /*P*/ LDat = FSet.findLock(Analyzer.FactMan, Cp.$not());
      if ((LDat != null)) {
        Analyzer.Handler.handleFunExcludesLock(new StringRef(DiagKind), new StringRef(D.getNameAsString()), new StringRef((Cp.$not()).__toString()), new SourceLocation(Loc));
        return;
      }
      
      // If this does not refer to a negative capability in the same class,
      // then stop here.
      if (!Analyzer.inCurrentScope(Cp)) {
        return;
      }
      
      // Otherwise the negative requirement must be propagated to the caller.
      LDat = FSet.findLock(Analyzer.FactMan, Cp);
      if (!(LDat != null)) {
        Analyzer.Handler.handleMutexNotHeld(new StringRef(/*KEEP_STR*/$EMPTY), D, POK, new StringRef(Cp.__toString()), 
            LockKind.LK_Shared, new SourceLocation(Loc));
      }
      return;
    }
    
    FactEntry /*P*/ LDat = FSet.findLockUniv(Analyzer.FactMan, Cp);
    boolean NoError = true;
    if (!(LDat != null)) {
      // No exact match found.  Look for a partial match.
      LDat = FSet.findPartialMatch(Analyzer.FactMan, Cp);
      if ((LDat != null)) {
        // Warn that there's no precise match.
        std.string PartMatchStr = LDat.__toString();
        StringRef PartMatchName/*J*/= new StringRef(PartMatchStr);
        Analyzer.Handler.handleMutexNotHeld(new StringRef(DiagKind), D, POK, new StringRef(Cp.__toString()), 
            LK, new SourceLocation(Loc), $AddrOf(PartMatchName));
      } else {
        // Warn that there's no match at all.
        Analyzer.Handler.handleMutexNotHeld(new StringRef(DiagKind), D, POK, new StringRef(Cp.__toString()), 
            LK, new SourceLocation(Loc));
      }
      NoError = false;
    }
    // Make sure the mutex we found is the right kind.
    if (NoError && (LDat != null) && !LDat.isAtLeast(LK)) {
      Analyzer.Handler.handleMutexNotHeld(new StringRef(DiagKind), D, POK, new StringRef(Cp.__toString()), 
          LK, new SourceLocation(Loc));
    }
  }

  
  /// \brief Warn if the LSet contains the given lock.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BuildLockset::warnIfMutexHeld">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 1564,
   FQN="(anonymous namespace)::BuildLockset::warnIfMutexHeld", NM="_ZN12_GLOBAL__N_112BuildLockset15warnIfMutexHeldEPKN5clang9NamedDeclEPKNS1_4ExprEPS5_N4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN12_GLOBAL__N_112BuildLockset15warnIfMutexHeldEPKN5clang9NamedDeclEPKNS1_4ExprEPS5_N4llvm9StringRefE")
  //</editor-fold>
  private void warnIfMutexHeld(/*const*/ NamedDecl /*P*/ D, /*const*/ Expr /*P*/ Exp, 
                 Expr /*P*/ MutexExp, StringRef DiagKind) {
    CapabilityExpr Cp = Analyzer.SxBuilder.translateAttrExpr(MutexExp, D, Exp);
    if (Cp.isInvalid()) {
      warnInvalidLock(Analyzer.Handler, MutexExp, D, Exp, new StringRef(DiagKind));
      return;
    } else if (Cp.shouldIgnore()) {
      return;
    }
    
    FactEntry /*P*/ LDat = FSet.findLock(Analyzer.FactMan, Cp);
    if ((LDat != null)) {
      Analyzer.Handler.handleFunExcludesLock(new StringRef(DiagKind), new StringRef(D.getNameAsString()), new StringRef(Cp.__toString()), Exp.getExprLoc());
    }
  }

  
  
  /// \brief Checks guarded_by and pt_guarded_by attributes.
  /// Whenever we identify an access (read or write) to a DeclRefExpr that is
  /// marked with guarded_by, we must ensure the appropriate mutexes are held.
  /// Similarly, we check if the access is to an expression that dereferences
  /// a pointer marked with pt_guarded_by.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BuildLockset::checkAccess">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 1586,
   FQN="(anonymous namespace)::BuildLockset::checkAccess", NM="_ZN12_GLOBAL__N_112BuildLockset11checkAccessEPKN5clang4ExprENS1_12threadSafety10AccessKindENS5_22ProtectedOperationKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN12_GLOBAL__N_112BuildLockset11checkAccessEPKN5clang4ExprENS1_12threadSafety10AccessKindENS5_22ProtectedOperationKindE")
  //</editor-fold>
  private void checkAccess(/*const*/ Expr /*P*/ Exp, AccessKind AK) {
    checkAccess(Exp, AK, 
             ProtectedOperationKind.POK_VarAccess);
  }
  private void checkAccess(/*const*/ Expr /*P*/ Exp, AccessKind AK, 
             ProtectedOperationKind POK/*= POK_VarAccess*/) {
    Exp = Exp.IgnoreParenCasts$Const();
    
    SourceLocation Loc = Exp.getExprLoc();
    {
      
      // Local variables of reference type cannot be re-assigned;
      // map them to their initializer.
      /*const*/ DeclRefExpr /*P*/ DRE;
      while (((/*const*/ /*P*/ DRE = dyn_cast_DeclRefExpr(Exp)) != null)) {
        /*const*/ VarDecl /*P*/ VD = dyn_cast_VarDecl(DRE.getDecl$Const().getCanonicalDecl$Const());
        if ((VD != null) && VD.isLocalVarDecl() && VD.getType().$arrow().isReferenceType()) {
          {
            /*const*/ Expr /*P*/ E = VD.getInit$Const();
            if ((E != null)) {
              Exp = E;
              continue;
            }
          }
        }
        break;
      }
    }
    {
      
      /*const*/ UnaryOperator /*P*/ UO = dyn_cast_UnaryOperator(Exp);
      if ((UO != null)) {
        // For dereferences
        if (UO.getOpcode() == UnaryOperatorKind.UO_Deref) {
          checkPtAccess(UO.getSubExpr(), AK, POK);
        }
        return;
      }
    }
    {
      
      /*const*/ ArraySubscriptExpr /*P*/ AE = dyn_cast_ArraySubscriptExpr(Exp);
      if ((AE != null)) {
        checkPtAccess(AE.getLHS$Const(), AK, POK);
        return;
      }
    }
    {
      
      /*const*/ MemberExpr /*P*/ ME = dyn_cast_MemberExpr(Exp);
      if ((ME != null)) {
        if (ME.isArrow()) {
          checkPtAccess(ME.getBase(), AK, POK);
        } else {
          checkAccess(ME.getBase(), AK, POK);
        }
      }
    }
    
    /*const*/ ValueDecl /*P*/ D = getValueDecl(Exp);
    if (!(D != null) || !D.hasAttrs()) {
      return;
    }
    if (D.hasAttr(GuardedVarAttr.class) && FSet.isEmpty(Analyzer.FactMan)) {
      Analyzer.Handler.handleNoMutexHeld(new StringRef(/*KEEP_STR*/"mutex"), D, POK, AK, new SourceLocation(Loc));
    }
    
    for (/*const*/ GuardedByAttr /*P*/ I : D.specific_attrs(GuardedByAttr.class))  {
      warnIfMutexNotHeld(D, Exp, AK, I.getArg(), POK, 
          ClassifyDiagnostic$NotHasArgIteratorRange(I), new SourceLocation(Loc));
    }
  }

  
  /// \brief Checks pt_guarded_by and pt_guarded_var attributes.
  /// POK is the same  operationKind that was passed to checkAccess.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BuildLockset::checkPtAccess">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 1640,
   FQN="(anonymous namespace)::BuildLockset::checkPtAccess", NM="_ZN12_GLOBAL__N_112BuildLockset13checkPtAccessEPKN5clang4ExprENS1_12threadSafety10AccessKindENS5_22ProtectedOperationKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN12_GLOBAL__N_112BuildLockset13checkPtAccessEPKN5clang4ExprENS1_12threadSafety10AccessKindENS5_22ProtectedOperationKindE")
  //</editor-fold>
  private void checkPtAccess(/*const*/ Expr /*P*/ Exp, AccessKind AK) {
    checkPtAccess(Exp, AK, 
               ProtectedOperationKind.POK_VarAccess);
  }
  private void checkPtAccess(/*const*/ Expr /*P*/ Exp, AccessKind AK, 
               ProtectedOperationKind POK/*= POK_VarAccess*/) {
    while (true) {
      {
        /*const*/ ParenExpr /*P*/ PE = dyn_cast_ParenExpr(Exp);
        if ((PE != null)) {
          Exp = PE.getSubExpr$Const();
          continue;
        }
      }
      {
        /*const*/ CastExpr /*P*/ CE = dyn_cast_CastExpr(Exp);
        if ((CE != null)) {
          if (CE.getCastKind() == CastKind.CK_ArrayToPointerDecay) {
            // If it's an actual array, and not a pointer, then it's elements
            // are protected by GUARDED_BY, not PT_GUARDED_BY;
            checkAccess(CE.getSubExpr$Const(), AK, POK);
            return;
          }
          Exp = CE.getSubExpr$Const();
          continue;
        }
      }
      break;
    }
    
    // Pass by reference warnings are under a different flag.
    ProtectedOperationKind PtPOK = ProtectedOperationKind.POK_VarDereference;
    if (POK == ProtectedOperationKind.POK_PassByRef) {
      PtPOK = ProtectedOperationKind.POK_PtPassByRef;
    }
    
    /*const*/ ValueDecl /*P*/ D = getValueDecl(Exp);
    if (!(D != null) || !D.hasAttrs()) {
      return;
    }
    if (D.hasAttr(PtGuardedVarAttr.class) && FSet.isEmpty(Analyzer.FactMan)) {
      Analyzer.Handler.handleNoMutexHeld(new StringRef(/*KEEP_STR*/"mutex"), D, PtPOK, AK, 
          Exp.getExprLoc());
    }
    
    for (/*const*/ PtGuardedByAttr /*P*/ I : D.specific_attrs(PtGuardedByAttr.class))  {
      warnIfMutexNotHeld(D, Exp, AK, I.getArg(), PtPOK, 
          ClassifyDiagnostic$NotHasArgIteratorRange(I), Exp.getExprLoc());
    }
  }

  
  
  /// \brief Process a function call, method call, constructor call,
  /// or destructor call.  This involves looking at the attributes on the
  /// corresponding function/method/constructor/destructor, issuing warnings,
  /// and updating the locksets accordingly.
  ///
  /// FIXME: For classes annotated with one of the guarded annotations, we need
  /// to treat const method calls as reads and non-const method calls as writes,
  /// and check that the appropriate locks are held. Non-const method calls with
  /// the same signature as const method calls can be also treated as reads.
  ///
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BuildLockset::handleCall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 1687,
   FQN="(anonymous namespace)::BuildLockset::handleCall", NM="_ZN12_GLOBAL__N_112BuildLockset10handleCallEPN5clang4ExprEPKNS1_9NamedDeclEPNS1_7VarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN12_GLOBAL__N_112BuildLockset10handleCallEPN5clang4ExprEPKNS1_9NamedDeclEPNS1_7VarDeclE")
  //</editor-fold>
  /*friend*/protected/*private*/ void handleCall(Expr /*P*/ Exp, /*const*/ NamedDecl /*P*/ D) {
    handleCall(Exp, D, (VarDecl /*P*/ )null);
  }
  /*friend*/protected/*private*/ void handleCall(Expr /*P*/ Exp, /*const*/ NamedDecl /*P*/ D, VarDecl /*P*/ VD/*= null*/) {
    CapExprSet ExclusiveLocksToAdd = null;
    CapExprSet SharedLocksToAdd = null;
    CapExprSet ExclusiveLocksToRemove = null;
    CapExprSet SharedLocksToRemove = null;
    CapExprSet GenericLocksToRemove = null;
    CapExprSet ScopedExclusiveReqs = null;
    CapExprSet ScopedSharedReqs = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      SourceLocation Loc = Exp.getExprLoc();
      ExclusiveLocksToAdd/*J*/= new CapExprSet();
      SharedLocksToAdd/*J*/= new CapExprSet();
      ExclusiveLocksToRemove/*J*/= new CapExprSet();
      SharedLocksToRemove/*J*/= new CapExprSet();
      GenericLocksToRemove/*J*/= new CapExprSet();
      ScopedExclusiveReqs/*J*/= new CapExprSet();
      ScopedSharedReqs/*J*/= new CapExprSet();
      StringRef CapDiagKind = new StringRef(/*KEEP_STR*/"mutex");
      
      // Figure out if we're calling the constructor of scoped lockable class
      boolean isScopedVar = false;
      if ((VD != null)) {
        {
          /*const*/ CXXConstructorDecl /*P*/ CD = dyn_cast_CXXConstructorDecl(D);
          if ((CD != null)) {
            /*const*/ CXXRecordDecl /*P*/ PD = CD.getParent$Const();
            if ((PD != null) && PD.hasAttr(ScopedLockableAttr.class)) {
              isScopedVar = true;
            }
          }
        }
      }
      
      for (Attr /*P*/ Atconst : D.attrs()) {
        Attr /*P*/ At = ((/*const_cast*/Attr /*P*/ )(Atconst));
        switch (At.getKind()) {
         case AcquireCapability:
          {
            AcquireCapabilityAttr /*P*/ A = cast_AcquireCapabilityAttr(At);
            Analyzer.getMutexIDs(A.isShared() ? SharedLocksToAdd : ExclusiveLocksToAdd, 
                A, Exp, D, VD);
            
            CapDiagKind.$assignMove(ClassifyDiagnostic$HasArgIteratorRange(A));
            break;
          }
         case AssertExclusiveLock:
          {
            CapExprSet AssertLocks = null;
            try {
              AssertExclusiveLockAttr /*P*/ A = cast_AssertExclusiveLockAttr(At);
              
              AssertLocks/*J*/= new CapExprSet();
              Analyzer.getMutexIDs(AssertLocks, A, Exp, D, VD);
              for (final /*const*/ CapabilityExpr /*&*/ AssertLock : AssertLocks)  {
                Analyzer.addLock(FSet, 
                    $c$.track(new std.unique_ptr<FactEntry>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(llvm.make_unique(new LockableFactEntry(AssertLock, LockKind.LK_Exclusive, Loc, false, true))))), 
                    ClassifyDiagnostic$HasArgIteratorRange(A)); $c$.clean();
              }
              break;
            } finally {
              if (AssertLocks != null) { AssertLocks.$destroy(); }
            }
          }
         case AssertSharedLock:
          {
            CapExprSet AssertLocks = null;
            try {
              AssertSharedLockAttr /*P*/ A = cast_AssertSharedLockAttr(At);
              
              AssertLocks/*J*/= new CapExprSet();
              Analyzer.getMutexIDs(AssertLocks, A, Exp, D, VD);
              for (final /*const*/ CapabilityExpr /*&*/ AssertLock : AssertLocks)  {
                Analyzer.addLock(FSet, $c$.track(new std.unique_ptr<FactEntry>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(llvm.make_unique(new LockableFactEntry(AssertLock, LockKind.LK_Shared, Loc, false, true))))), 
                    ClassifyDiagnostic$HasArgIteratorRange(A)); $c$.clean();
              }
              break;
            } finally {
              if (AssertLocks != null) { AssertLocks.$destroy(); }
            }
          }
         case ReleaseCapability:
          {
            ReleaseCapabilityAttr /*P*/ A = cast_ReleaseCapabilityAttr(At);
            if (A.isGeneric()) {
              Analyzer.getMutexIDs(GenericLocksToRemove, A, Exp, D, VD);
            } else if (A.isShared()) {
              Analyzer.getMutexIDs(SharedLocksToRemove, A, Exp, D, VD);
            } else {
              Analyzer.getMutexIDs(ExclusiveLocksToRemove, A, Exp, D, VD);
            }
            
            CapDiagKind.$assignMove(ClassifyDiagnostic$HasArgIteratorRange(A));
            break;
          }
         case RequiresCapability:
          {
            RequiresCapabilityAttr /*P*/ A = cast_RequiresCapabilityAttr(At);
            for (Expr /*P*/ Arg : A.args()) {
              warnIfMutexNotHeld(D, Exp, A.isShared() ? AccessKind.AK_Read : AccessKind.AK_Written, Arg, 
                  ProtectedOperationKind.POK_FunctionCall, ClassifyDiagnostic$HasArgIteratorRange(A), 
                  Exp.getExprLoc());
              // use for adopting a lock
              if (isScopedVar) {
                Analyzer.getMutexIDs(A.isShared() ? ScopedSharedReqs : ScopedExclusiveReqs, 
                    A, Exp, D, VD);
              }
            }
            break;
          }
         case LocksExcluded:
          {
            LocksExcludedAttr /*P*/ A = cast_LocksExcludedAttr(At);
            for (Expr /*P*/ Arg : A.args())  {
              warnIfMutexHeld(D, Exp, Arg, ClassifyDiagnostic$HasArgIteratorRange(A));
            }
            break;
          }
         default:
          
          // Ignore attributes unrelated to thread-safety
          break;
        }
      }
      
      // Add locks.
      for (final /*const*/ CapabilityExpr /*&*/ M : ExclusiveLocksToAdd)  {
        Analyzer.addLock(FSet, $c$.track(new std.unique_ptr<FactEntry>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(llvm.make_unique(new LockableFactEntry(M, LockKind.LK_Exclusive, Loc, isScopedVar))))), 
            new StringRef(CapDiagKind)); $c$.clean();
      }
      for (final /*const*/ CapabilityExpr /*&*/ M : SharedLocksToAdd)  {
        Analyzer.addLock(FSet, $c$.track(new std.unique_ptr<FactEntry>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(llvm.make_unique(new LockableFactEntry(M, LockKind.LK_Shared, Loc, isScopedVar))))), 
            new StringRef(CapDiagKind)); $c$.clean();
      }
      if (isScopedVar) {
        // Add the managing object as a dummy mutex, mapped to the underlying mutex.
        SourceLocation MLoc = VD.getLocation();
        DeclRefExpr DRE/*J*/= new DeclRefExpr(VD, false, VD.getType(), ExprValueKind.VK_LValue, VD.getLocation());
        // FIXME: does this store a pointer to DRE?
        CapabilityExpr Scp = Analyzer.SxBuilder.translateAttrExpr($AddrOf(DRE), (SExprBuilder.CallingContext /*P*/ )null);
        
        std.copy(ScopedExclusiveReqs.begin(), ScopedExclusiveReqs.end(), 
            std.back_inserter(ExclusiveLocksToAdd));
        std.copy(ScopedSharedReqs.begin(), ScopedSharedReqs.end(), 
            std.back_inserter(SharedLocksToAdd));
        Analyzer.addLock(FSet, 
            $c$.track(new std.unique_ptr<FactEntry>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(llvm.make_unique(new ScopedLockableFactEntry(Scp, MLoc, ExclusiveLocksToAdd, SharedLocksToAdd))))), 
            new StringRef(CapDiagKind)); $c$.clean();
      }
      
      // Remove locks.
      // FIXME -- should only fully remove if the attribute refers to 'this'.
      boolean Dtor = isa_CXXDestructorDecl(D);
      for (final /*const*/ CapabilityExpr /*&*/ M : ExclusiveLocksToRemove)  {
        Analyzer.removeLock(FSet, M, new SourceLocation(Loc), Dtor, LockKind.LK_Exclusive, new StringRef(CapDiagKind));
      }
      for (final /*const*/ CapabilityExpr /*&*/ M : SharedLocksToRemove)  {
        Analyzer.removeLock(FSet, M, new SourceLocation(Loc), Dtor, LockKind.LK_Shared, new StringRef(CapDiagKind));
      }
      for (final /*const*/ CapabilityExpr /*&*/ M : GenericLocksToRemove)  {
        Analyzer.removeLock(FSet, M, new SourceLocation(Loc), Dtor, LockKind.LK_Generic, new StringRef(CapDiagKind));
      }
    } finally {
      if (ScopedSharedReqs != null) { ScopedSharedReqs.$destroy(); }
      if (ScopedExclusiveReqs != null) { ScopedExclusiveReqs.$destroy(); }
      if (GenericLocksToRemove != null) { GenericLocksToRemove.$destroy(); }
      if (SharedLocksToRemove != null) { SharedLocksToRemove.$destroy(); }
      if (ExclusiveLocksToRemove != null) { ExclusiveLocksToRemove.$destroy(); }
      if (SharedLocksToAdd != null) { SharedLocksToAdd.$destroy(); }
      if (ExclusiveLocksToAdd != null) { ExclusiveLocksToAdd.$destroy(); }
      $c$.$destroy();
    }
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BuildLockset::BuildLockset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 1482,
   FQN="(anonymous namespace)::BuildLockset::BuildLockset", NM="_ZN12_GLOBAL__N_112BuildLocksetC1EPNS_20ThreadSafetyAnalyzerERNS_12CFGBlockInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN12_GLOBAL__N_112BuildLocksetC1EPNS_20ThreadSafetyAnalyzerERNS_12CFGBlockInfoE")
  //</editor-fold>
  public BuildLockset(ThreadSafetyAnalyzer /*P*/ Anlzr, final CFGBlockInfo /*&*/ Info) {
    // : StmtVisitor<BuildLockset>(), Analyzer(Anlzr), FSet(Info.EntrySet), LVarCtx(Info.EntryContext), CtxIndex(Info.EntryIndex) 
    //START JInit
    $StmtVisitor();
    this.Analyzer = Anlzr;
    this.FSet = new FactSet(Info.EntrySet);
    this.LVarCtx = new ImmutableMapPtrUInt</*const*/ NamedDecl /*P*/ >(Info.EntryContext);
    this.CtxIndex = Info.EntryIndex;
    //END JInit
  }

  
  
  /// \brief For unary operations which read and write a variable, we need to
  /// check whether we hold any required mutexes. Reads are checked in
  /// VisitCastExpr.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BuildLockset::VisitUnaryOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 1832,
   FQN="(anonymous namespace)::BuildLockset::VisitUnaryOperator", NM="_ZN12_GLOBAL__N_112BuildLockset18VisitUnaryOperatorEPN5clang13UnaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN12_GLOBAL__N_112BuildLockset18VisitUnaryOperatorEPN5clang13UnaryOperatorE")
  //</editor-fold>
  public void VisitUnaryOperator(UnaryOperator /*P*/ UO) {
    switch (UO.getOpcode()) {
     case UO_PostDec:
     case UO_PostInc:
     case UO_PreDec:
     case UO_PreInc:
      {
        checkAccess(UO.getSubExpr(), AccessKind.AK_Written);
        break;
      }
     default:
      break;
    }
  }

  
  /// For binary operations which assign to a variable (writes), we need to check
  /// whether we hold any required mutexes.
  /// FIXME: Deal with non-primitive types.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BuildLockset::VisitBinaryOperator">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 1849,
   FQN="(anonymous namespace)::BuildLockset::VisitBinaryOperator", NM="_ZN12_GLOBAL__N_112BuildLockset19VisitBinaryOperatorEPN5clang14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN12_GLOBAL__N_112BuildLockset19VisitBinaryOperatorEPN5clang14BinaryOperatorE")
  //</editor-fold>
  public void VisitBinaryOperator(BinaryOperator /*P*/ BO) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      if (!BO.isAssignmentOp()) {
        return;
      }
      
      // adjust the context
      $c$.clean(LVarCtx.$assign($c$.track(Analyzer.LocalVarMap.getNextContext(create_uint$ref(CtxIndex), BO, $c$.track(new ImmutableMapPtrUInt</*const*/ NamedDecl /*P*/ >(LVarCtx))))));
      
      checkAccess(BO.getLHS(), AccessKind.AK_Written);
    } finally {
      $c$.$destroy();
    }
  }

  
  /// Whenever we do an LValue to Rvalue cast, we are reading a variable and
  /// need to ensure we hold any required mutexes.
  /// FIXME: Deal with non-primitive types.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BuildLockset::VisitCastExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 1863,
   FQN="(anonymous namespace)::BuildLockset::VisitCastExpr", NM="_ZN12_GLOBAL__N_112BuildLockset13VisitCastExprEPN5clang8CastExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN12_GLOBAL__N_112BuildLockset13VisitCastExprEPN5clang8CastExprE")
  //</editor-fold>
  public void VisitCastExpr(CastExpr /*P*/ CE) {
    if (CE.getCastKind() != CastKind.CK_LValueToRValue) {
      return;
    }
    checkAccess(CE.getSubExpr(), AccessKind.AK_Read);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BuildLockset::VisitCallExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 1870,
   FQN="(anonymous namespace)::BuildLockset::VisitCallExpr", NM="_ZN12_GLOBAL__N_112BuildLockset13VisitCallExprEPN5clang8CallExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN12_GLOBAL__N_112BuildLockset13VisitCallExprEPN5clang8CallExprE")
  //</editor-fold>
  public void VisitCallExpr(CallExpr /*P*/ Exp) {
    boolean ExamineArgs = true;
    boolean OperatorFun = false;
    {
      
      CXXMemberCallExpr /*P*/ CE = dyn_cast_CXXMemberCallExpr(Exp);
      if ((CE != null)) {
        MemberExpr /*P*/ ME = dyn_cast_MemberExpr(CE.getCallee());
        // ME can be null when calling a method pointer
        CXXMethodDecl /*P*/ MD = CE.getMethodDecl();
        if ((ME != null) && (MD != null)) {
          if (ME.isArrow()) {
            if (MD.isConst()) {
              checkPtAccess(CE.getImplicitObjectArgument(), AccessKind.AK_Read);
            } else { // FIXME -- should be AK_Written
              checkPtAccess(CE.getImplicitObjectArgument(), AccessKind.AK_Read);
            }
          } else {
            if (MD.isConst()) {
              checkAccess(CE.getImplicitObjectArgument(), AccessKind.AK_Read);
            } else { // FIXME -- should be AK_Written
              checkAccess(CE.getImplicitObjectArgument(), AccessKind.AK_Read);
            }
          }
        }
      } else {
        CXXOperatorCallExpr /*P*/ OE = dyn_cast_CXXOperatorCallExpr(Exp);
        if ((OE != null)) {
          OperatorFun = true;
          
          OverloadedOperatorKind OEop = OE.getOperator();
          switch (OEop) {
           case OO_Equal:
            {
              ExamineArgs = false;
              /*const*/ Expr /*P*/ Target = OE.getArg(0);
              /*const*/ Expr /*P*/ Source = OE.getArg(1);
              checkAccess(Target, AccessKind.AK_Written);
              checkAccess(Source, AccessKind.AK_Read);
              break;
            }
           case OO_Star:
           case OO_Arrow:
           case OO_Subscript:
            {
              /*const*/ Expr /*P*/ Obj = OE.getArg(0);
              checkAccess(Obj, AccessKind.AK_Read);
              if (!(OEop == OverloadedOperatorKind.OO_Star && $greater_uint(OE.getNumArgs(), 1))) {
                // Grrr.  operator* can be multiplication...
                checkPtAccess(Obj, AccessKind.AK_Read);
              }
              break;
            }
           default:
            {
              // TODO: get rid of this, and rely on pass-by-ref instead.
              /*const*/ Expr /*P*/ Obj = OE.getArg(0);
              checkAccess(Obj, AccessKind.AK_Read);
              break;
            }
          }
        }
      }
    }
    if (ExamineArgs) {
      {
        FunctionDecl /*P*/ FD = Exp.getDirectCallee();
        if ((FD != null)) {
          
          // NO_THREAD_SAFETY_ANALYSIS does double duty here.  Normally it
          // only turns off checking within the body of a function, but we also
          // use it to turn off checking in arguments to the function.  This
          // could result in some false negatives, but the alternative is to
          // create yet another attribute.
          //
          if (!FD.hasAttr(NoThreadSafetyAnalysisAttr.class)) {
            /*uint*/int Fn = FD.getNumParams();
            /*uint*/int Cn = Exp.getNumArgs();
            /*uint*/int Skip = 0;
            
            /*uint*/int i = 0;
            if (OperatorFun) {
              if (isa_CXXMethodDecl(FD)) {
                // First arg in operator call is implicit self argument,
                // and doesn't appear in the FunctionDecl.
                Skip = 1;
                Cn--;
              } else {
                // Ignore the first argument of operators; it's been checked above.
                i = 1;
              }
            }
            // Ignore default arguments
            /*uint*/int n = ($less_uint(Fn, Cn)) ? Fn : Cn;
            
            for (; $less_uint(i, n); ++i) {
              ParmVarDecl /*P*/ Pvd = FD.getParamDecl(i);
              Expr /*P*/ Arg = Exp.getArg(i + Skip);
              QualType Qt = Pvd.getType();
              if (Qt.$arrow().isReferenceType()) {
                checkAccess(Arg, AccessKind.AK_Read, ProtectedOperationKind.POK_PassByRef);
              }
            }
          }
        }
      }
    }
    
    NamedDecl /*P*/ D = dyn_cast_or_null_NamedDecl(Exp.getCalleeDecl());
    if (!(D != null) || !D.hasAttrs()) {
      return;
    }
    handleCall(Exp, D);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BuildLockset::VisitCXXConstructExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 1972,
   FQN="(anonymous namespace)::BuildLockset::VisitCXXConstructExpr", NM="_ZN12_GLOBAL__N_112BuildLockset21VisitCXXConstructExprEPN5clang16CXXConstructExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN12_GLOBAL__N_112BuildLockset21VisitCXXConstructExprEPN5clang16CXXConstructExprE")
  //</editor-fold>
  public void VisitCXXConstructExpr(CXXConstructExpr /*P*/ Exp) {
    /*const*/ CXXConstructorDecl /*P*/ D = Exp.getConstructor();
    if ((D != null) && D.isCopyConstructor()) {
      /*const*/ Expr /*P*/ Source = Exp.getArg(0);
      checkAccess(Source, AccessKind.AK_Read);
    }
    // FIXME -- only handles constructors in DeclStmt below.
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BuildLockset::VisitDeclStmt">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 1981,
   FQN="(anonymous namespace)::BuildLockset::VisitDeclStmt", NM="_ZN12_GLOBAL__N_112BuildLockset13VisitDeclStmtEPN5clang8DeclStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN12_GLOBAL__N_112BuildLockset13VisitDeclStmtEPN5clang8DeclStmtE")
  //</editor-fold>
  public void VisitDeclStmt(DeclStmt /*P*/ S) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // adjust the context
      $c$.clean(LVarCtx.$assign($c$.track(Analyzer.LocalVarMap.getNextContext(create_uint$ref(CtxIndex), S, $c$.track(new ImmutableMapPtrUInt</*const*/ NamedDecl /*P*/ >(LVarCtx))))));
      
      for (Decl /*P*/ D : S.getDeclGroup()) {
        {
          VarDecl /*P*/ VD = dyn_cast_or_null_VarDecl(D);
          if ((VD != null)) {
            Expr /*P*/ E = VD.getInit();
            {
              // handle constructors that involve temporaries
              ExprWithCleanups /*P*/ EWC = dyn_cast_or_null_ExprWithCleanups(E);
              if ((EWC != null)) {
                E = EWC.getSubExpr();
              }
            }
            {
              
              CXXConstructExpr /*P*/ CE = dyn_cast_or_null_CXXConstructExpr(E);
              if ((CE != null)) {
                NamedDecl /*P*/ CtorD = dyn_cast_or_null_NamedDecl(CE.getConstructor());
                if (!(CtorD != null) || !CtorD.hasAttrs()) {
                  return;
                }
                handleCall(CE, CtorD, VD);
              }
            }
          }
        }
      }
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BuildLockset::~BuildLockset">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 1459,
   FQN="(anonymous namespace)::BuildLockset::~BuildLockset", NM="_ZN12_GLOBAL__N_112BuildLocksetD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN12_GLOBAL__N_112BuildLocksetD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    LVarCtx.$destroy();
    FSet.$destroy();
    StmtVisitorVoid.super.$destroy$StmtVisitor();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "Analyzer=" + Analyzer // NOI18N
              + ", FSet=" + FSet // NOI18N
              + ", LVarCtx=" + LVarCtx // NOI18N
              + ", CtxIndex=" + CtxIndex // NOI18N
              + super.toString(); // NOI18N
  }
}
