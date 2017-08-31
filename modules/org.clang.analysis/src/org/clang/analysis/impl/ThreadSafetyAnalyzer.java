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

import static org.clank.support.Native.$Deref;
import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.llvm.adt.ADTAliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import org.clang.basic.*;
import org.clang.analysis.*;
import org.clang.analysis.analyses.*;
import org.clang.analysis.impl.*;
import org.clang.analysis.threadSafety.impl.*;
import static org.clang.ast.java.AstStatementsRTTI.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.analysis.java.AnalysisRTTI.*;
import static org.clang.analysis.impl.ThreadSafetyStatics.*;
import org.clang.analysis.analyses.threadSafety.*;
import org.clang.analysis.analyses.threadSafety.til.*;
import org.clang.ast.java.ArgsAttrBase;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstAttributesRTTI.*;


/// \brief Class which implements the core thread safety analysis routines.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ThreadSafetyAnalyzer">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 906,
 FQN="(anonymous namespace)::ThreadSafetyAnalyzer", NM="_ZN12_GLOBAL__N_120ThreadSafetyAnalyzerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN12_GLOBAL__N_120ThreadSafetyAnalyzerE")
//</editor-fold>
public class ThreadSafetyAnalyzer implements Destructors.ClassWithDestructor {
  /*friend  class BuildLockset*/
  /*friend  class threadSafety::BeforeSet*/
  
  private BumpPtrAllocatorImpl Bpa;
  private MemRegionRef Arena;
  /*friend*/public/*private*/ SExprBuilder SxBuilder;
  
  /*friend*/public/*private*/ final ThreadSafetyHandler /*&*/ Handler;
  private /*const*/ CXXMethodDecl /*P*/ CurrentMethod;
  /*friend*/protected/*private*/ LocalVariableMap LocalVarMap;
  /*friend*/public/*private*/ FactManager FactMan;
  private std.vector<CFGBlockInfo> BlockInfo;
  
  private BeforeSet /*P*/ GlobalBeforeSet;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ThreadSafetyAnalyzer::ThreadSafetyAnalyzer">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 923,
   FQN="(anonymous namespace)::ThreadSafetyAnalyzer::ThreadSafetyAnalyzer", NM="_ZN12_GLOBAL__N_120ThreadSafetyAnalyzerC1ERN5clang12threadSafety19ThreadSafetyHandlerEPNS2_9BeforeSetE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN12_GLOBAL__N_120ThreadSafetyAnalyzerC1ERN5clang12threadSafety19ThreadSafetyHandlerEPNS2_9BeforeSetE")
  //</editor-fold>
  public ThreadSafetyAnalyzer(final ThreadSafetyHandler /*&*/ H, BeforeSet /*P*/ Bset) {
    // : Bpa(), Arena(&Bpa), SxBuilder(Arena), Handler(H), LocalVarMap(), FactMan(), BlockInfo(), GlobalBeforeSet(Bset) 
    //START JInit
    this.Bpa = new BumpPtrAllocatorImpl();
    this.Arena = new MemRegionRef($AddrOf(Bpa));
    this.SxBuilder = new SExprBuilder(new MemRegionRef(Arena));
    this./*&*/Handler=/*&*/H;
    this.LocalVarMap = new LocalVariableMap();
    this.FactMan = new FactManager();
    this.BlockInfo = new std.vector<CFGBlockInfo>(()->new CFGBlockInfo());
    this.GlobalBeforeSet = Bset;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ThreadSafetyAnalyzer::inCurrentScope">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 1169,
   FQN="(anonymous namespace)::ThreadSafetyAnalyzer::inCurrentScope", NM="_ZN12_GLOBAL__N_120ThreadSafetyAnalyzer14inCurrentScopeERKN5clang12threadSafety14CapabilityExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN12_GLOBAL__N_120ThreadSafetyAnalyzer14inCurrentScopeERKN5clang12threadSafety14CapabilityExprE")
  //</editor-fold>
  public /*inline*/ boolean inCurrentScope(final /*const*/ CapabilityExpr /*&*/ CapE) {
    if (!(CurrentMethod != null)) {
      return false;
    }
    {
      /*const*/ Project /*P*/ P = dyn_cast_or_null_Project(CapE.sexpr());
      if ((P != null)) {
        /*const*/ ValueDecl /*P*/ VD = P.clangDecl();
        if ((VD != null)) {
          return VD.getDeclContext$Const() == CurrentMethod.getDeclContext$Const();
        }
      }
    }
    return false;
  }

  
  
  /// \brief Add a new lock to the lockset, warning if the lock is already there.
  /// \param ReqAttr -- true if this is part of an initial Requires attribute.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ThreadSafetyAnalyzer::addLock">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 1183,
   FQN="(anonymous namespace)::ThreadSafetyAnalyzer::addLock", NM="_ZN12_GLOBAL__N_120ThreadSafetyAnalyzer7addLockERNS_7FactSetESt10unique_ptrINS_9FactEntryESt14default_deleteIS4_EEN4llvm9StringRefEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN12_GLOBAL__N_120ThreadSafetyAnalyzer7addLockERNS_7FactSetESt10unique_ptrINS_9FactEntryESt14default_deleteIS4_EEN4llvm9StringRefEb")
  //</editor-fold>
  public void addLock(final FactSet /*&*/ FSet, 
         std.unique_ptr<FactEntry> Entry, 
         StringRef DiagKind) {
    addLock(FSet, 
         Entry, 
         DiagKind, false);
  }
  public void addLock(final FactSet /*&*/ FSet, 
         std.unique_ptr<FactEntry> Entry, 
         StringRef DiagKind, boolean ReqAttr/*= false*/) {
    if (Entry.$arrow().shouldIgnore()) {
      return;
    }
    if (!ReqAttr && !Entry.$arrow().negative()) {
      // look for the negative capability, and remove it from the fact set.
      CapabilityExpr NegC = Entry.$star().$not();
      FactEntry /*P*/ Nen = FSet.findLock(FactMan, NegC);
      if ((Nen != null)) {
        FSet.removeLock(FactMan, NegC);
      } else {
        if (inCurrentScope(Entry.$star()) && !Entry.$arrow().asserted()) {
          Handler.handleNegativeNotHeld(new StringRef(DiagKind), new StringRef(Entry.$arrow().__toString()), 
              new StringRef(NegC.__toString()), Entry.$arrow().loc());
        }
      }
    }
    
    // Check before/after constraints
    if (Handler.issueBetaWarnings()
       && !Entry.$arrow().asserted() && !Entry.$arrow().declared()) {
      GlobalBeforeSet.checkBeforeAfter(Entry.$arrow().valueDecl(), FSet, /*Deref*/this, 
          Entry.$arrow().loc(), new StringRef(DiagKind));
    }
    
    // FIXME: Don't always warn when we have support for reentrant locks.
    if ((FSet.findLock(FactMan, Entry.$star()) != null)) {
      if (!Entry.$arrow().asserted()) {
        Handler.handleDoubleLock(new StringRef(DiagKind), new StringRef(Entry.$arrow().__toString()), Entry.$arrow().loc());
      }
    } else {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean(FSet.addLock(FactMan, $c$.track(new std.unique_ptr<FactEntry>(JD$Move.INSTANCE, std.move(Entry)))));
      } finally {
        $c$.$destroy();
      }
    }
  }

  
  /// \brief Remove a lock from the lockset, warning if the lock is not there.
  /// \param UnlockLoc The source location of the unlock (only used in error msg)
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ThreadSafetyAnalyzer::removeLock">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 1222,
   FQN="(anonymous namespace)::ThreadSafetyAnalyzer::removeLock", NM="_ZN12_GLOBAL__N_120ThreadSafetyAnalyzer10removeLockERNS_7FactSetERKN5clang12threadSafety14CapabilityExprENS3_14SourceLocationEbNS4_8LockKindEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN12_GLOBAL__N_120ThreadSafetyAnalyzer10removeLockERNS_7FactSetERKN5clang12threadSafety14CapabilityExprENS3_14SourceLocationEbNS4_8LockKindEN4llvm9StringRefE")
  //</editor-fold>
  public void removeLock(final FactSet /*&*/ FSet, final /*const*/ CapabilityExpr /*&*/ Cp, 
            SourceLocation UnlockLoc, 
            boolean FullyRemove, LockKind ReceivedKind, 
            StringRef DiagKind) {
    if (Cp.shouldIgnore()) {
      return;
    }
    
    /*const*/ FactEntry /*P*/ LDat = FSet.findLock(FactMan, Cp);
    if (!(LDat != null)) {
      Handler.handleUnmatchedUnlock(new StringRef(DiagKind), new StringRef(Cp.__toString()), new SourceLocation(UnlockLoc));
      return;
    }
    
    // Generic lock removal doesn't care about lock kind mismatches, but
    // otherwise diagnose when the lock kinds are mismatched.
    if (ReceivedKind != LockKind.LK_Generic && LDat.kind() != ReceivedKind) {
      Handler.handleIncorrectUnlockKind(new StringRef(DiagKind), new StringRef(Cp.__toString()), 
          LDat.kind(), ReceivedKind, new SourceLocation(UnlockLoc));
    }
    
    LDat.handleUnlock(FSet, FactMan, Cp, new SourceLocation(UnlockLoc), FullyRemove, Handler, 
        new StringRef(DiagKind));
  }

  
  /*template <typename AttrType> TEMPLATE*/
  
  /// \brief Extract the list of mutexIDs from the attribute on an expression,
  /// and push them onto Mtxs, discarding any duplicates.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ThreadSafetyAnalyzer::getMutexIDs">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 1250,
   FQN="(anonymous namespace)::ThreadSafetyAnalyzer::getMutexIDs", NM="Tpl__ZN12_GLOBAL__N_120ThreadSafetyAnalyzer11getMutexIDsERNS_10CapExprSetEPT_PN5clang4ExprEPKNS5_9NamedDeclEPNS5_7VarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=Tpl__ZN12_GLOBAL__N_120ThreadSafetyAnalyzer11getMutexIDsERNS_10CapExprSetEPT_PN5clang4ExprEPKNS5_9NamedDeclEPNS5_7VarDeclE")
  //</editor-fold>
  public </*typename*/ AttrType extends InheritableAttr & ArgsAttrBase> void getMutexIDs(final CapExprSet /*&*/ Mtxs, AttrType /*P*/ Attr, 
             Expr /*P*/ Exp, /*const*/ NamedDecl /*P*/ D) {
    getMutexIDs(Mtxs, Attr, 
             Exp, D, 
             (VarDecl /*P*/ )null);
  }
  public </*typename*/ AttrType extends InheritableAttr & ArgsAttrBase> void getMutexIDs(final CapExprSet /*&*/ Mtxs, AttrType /*P*/ Attr, 
             Expr /*P*/ Exp, /*const*/ NamedDecl /*P*/ D, 
             VarDecl /*P*/ SelfDecl/*= null*/) {
  if (Attr.args_size() == 0) {
    // The mutex held is the "this" object.
    CapabilityExpr Cp = SxBuilder.translateAttrExpr((/*const*/ Expr /*P*/ )null, D, Exp, SelfDecl);
    if (Cp.isInvalid()) {
      warnInvalidLock(Handler, (/*const*/ Expr /*P*/ )null, D, Exp, ClassifyDiagnostic$HasArgIteratorRange(Attr));
      return;
    }
    //else
    if (!Cp.shouldIgnore()) {
      Mtxs.push_back_nodup(Cp);
    }
    return;
  }
  
  for (/*const*/ Expr /*P*/ Arg : Attr.args()) {
    CapabilityExpr Cp = SxBuilder.translateAttrExpr(Arg, D, Exp, SelfDecl);
    if (Cp.isInvalid()) {
      warnInvalidLock(Handler, (/*const*/ Expr /*P*/ )null, D, Exp, ClassifyDiagnostic$HasArgIteratorRange(Attr));
      continue;
    }
    //else
    if (!Cp.shouldIgnore()) {
      Mtxs.push_back_nodup(Cp);
    }
  }
}
  
  /*template <class AttrType> TEMPLATE*/
  
  /// \brief Extract the list of mutexIDs from a trylock attribute.  If the
  /// trylock applies to the given edge, then push them onto Mtxs, discarding
  /// any duplicates.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ThreadSafetyAnalyzer::getMutexIDs">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 1283,
   FQN="(anonymous namespace)::ThreadSafetyAnalyzer::getMutexIDs", NM="Tpl__ZN12_GLOBAL__N_120ThreadSafetyAnalyzer11getMutexIDsERNS_10CapExprSetEPT_PN5clang4ExprEPKNS5_9NamedDeclEPKNS5_8CFGBlockESD_S7_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=Tpl__ZN12_GLOBAL__N_120ThreadSafetyAnalyzer11getMutexIDsERNS_10CapExprSetEPT_PN5clang4ExprEPKNS5_9NamedDeclEPKNS5_8CFGBlockESD_S7_b")
  //</editor-fold>
  public </*class*/ AttrType extends InheritableAttr & ArgsAttrBase> void getMutexIDs(final CapExprSet /*&*/ Mtxs, AttrType /*P*/ Attr, 
             Expr /*P*/ Exp, /*const*/ NamedDecl /*P*/ D, 
             /*const*/ CFGBlock /*P*/ PredBlock, 
             /*const*/ CFGBlock /*P*/ CurrBlock, 
             Expr /*P*/ BrE, boolean Neg) {
    // Find out which branch has the lock
    boolean branch = false;
    {
      CXXBoolLiteralExpr /*P*/ BLE = dyn_cast_or_null_CXXBoolLiteralExpr(BrE);
      if ((BLE != null)) {
        branch = BLE.getValue();
      } else {
        IntegerLiteral /*P*/ ILE = dyn_cast_or_null_IntegerLiteral(BrE);
        if ((ILE != null)) {
          branch = ILE.getValue().getBoolValue();
        }
      }
    }
    
    int branchnum = branch ? 0 : 1;
    if (Neg) {
      branchnum = ((!(branchnum != 0)) ? 1 : 0);
    }
    
    // If we've taken the trylock branch, then add the lock
    int i = 0;
    for (type$ptr</*const*/ CFGBlock.AdjacentBlock /*P*/ > SI = $tryClone(PredBlock.succ_begin$Const()), 
        /*P*/ SE = $tryClone(PredBlock.succ_end$Const()); $noteq_ptr(SI, SE) && i < 2; SI.$preInc() , ++i) {
      if (SI.$star().$CFGBlock$P() == CurrBlock && i == branchnum) {
        getMutexIDs(Mtxs, Attr, Exp, D);
      }
    }
  }

  
  
  // If Cond can be traced back to a function call, return the call expression.
  // The negate variable should be called with false, and will be set to true
  // if the function call is negated, e.g. if (!mu.tryLock(...))
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ThreadSafetyAnalyzer::getTrylockCallExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 1328,
   FQN="(anonymous namespace)::ThreadSafetyAnalyzer::getTrylockCallExpr", NM="_ZN12_GLOBAL__N_120ThreadSafetyAnalyzer18getTrylockCallExprEPKN5clang4StmtEN4llvm12ImmutableMapIPKNS1_9NamedDeclEjNS5_16ImutKeyValueInfoIS9_jEEEERb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN12_GLOBAL__N_120ThreadSafetyAnalyzer18getTrylockCallExprEPKN5clang4StmtEN4llvm12ImmutableMapIPKNS1_9NamedDeclEjNS5_16ImutKeyValueInfoIS9_jEEEERb")
  //</editor-fold>
  public /*const*/ CallExpr /*P*/ getTrylockCallExpr(/*const*/ Stmt /*P*/ Cond, 
                    ImmutableMapPtrUInt</*const*/ NamedDecl /*P*/ > C, 
                    final bool$ref/*bool &*/ Negate) {
    if (!(Cond != null)) {
      return null;
    }
    {
      
      /*const*/ CallExpr /*P*/ CallExp = dyn_cast_CallExpr(Cond);
      if ((CallExp != null)) {
        return CallExp;
      } else {
        /*const*/ ParenExpr /*P*/ PE = dyn_cast_ParenExpr(Cond);
        if ((PE != null)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            return $c$.clean(getTrylockCallExpr(PE.getSubExpr$Const(), $c$.track(new ImmutableMapPtrUInt</*const*/ NamedDecl /*P*/ >(C)), Negate));
          } finally {
            $c$.$destroy();
          }
        } else {
          /*const*/ ImplicitCastExpr /*P*/ CE = dyn_cast_ImplicitCastExpr(Cond);
          if ((CE != null)) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              return $c$.clean(getTrylockCallExpr(CE.getSubExpr$Const(), $c$.track(new ImmutableMapPtrUInt</*const*/ NamedDecl /*P*/ >(C)), Negate));
            } finally {
              $c$.$destroy();
            }
          } else {
            /*const*/ ExprWithCleanups /*P*/ EWC = dyn_cast_ExprWithCleanups(Cond);
            if ((EWC != null)) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                return $c$.clean(getTrylockCallExpr(EWC.getSubExpr$Const(), $c$.track(new ImmutableMapPtrUInt</*const*/ NamedDecl /*P*/ >(C)), Negate));
              } finally {
                $c$.$destroy();
              }
            } else {
              /*const*/ DeclRefExpr /*P*/ DRE = dyn_cast_DeclRefExpr(Cond);
              if ((DRE != null)) {
                JavaCleaner $c$ = $createJavaCleaner();
                try {
                  /*const*/ Expr /*P*/ E = LocalVarMap.lookupExpr(DRE.getDecl$Const(), C);
                  return $c$.clean(getTrylockCallExpr(E, $c$.track(new ImmutableMapPtrUInt</*const*/ NamedDecl /*P*/ >(C)), Negate));
                } finally {
                  $c$.$destroy();
                }
              } else {
                /*const*/ UnaryOperator /*P*/ UOP = dyn_cast_UnaryOperator(Cond);
                if ((UOP != null)) {
                  if (UOP.getOpcode() == UnaryOperatorKind.UO_LNot) {
                    JavaCleaner $c$ = $createJavaCleaner();
                    try {
                      Negate.$set(!Negate.$deref());
                      return $c$.clean(getTrylockCallExpr(UOP.getSubExpr(), $c$.track(new ImmutableMapPtrUInt</*const*/ NamedDecl /*P*/ >(C)), Negate));
                    } finally {
                      $c$.$destroy();
                    }
                  }
                  return null;
                } else {
                  /*const*/ BinaryOperator /*P*/ BOP = dyn_cast_BinaryOperator(Cond);
                  if ((BOP != null)) {
                    if (BOP.getOpcode() == BinaryOperatorKind.BO_EQ || BOP.getOpcode() == BinaryOperatorKind.BO_NE) {
                      if (BOP.getOpcode() == BinaryOperatorKind.BO_NE) {
                        Negate.$set(!Negate.$deref());
                      }
                      
                      bool$ref TCond = create_bool$ref(false);
                      if (getStaticBooleanValue(BOP.getRHS(), TCond)) {
                        JavaCleaner $c$ = $createJavaCleaner();
                        try {
                          if (!TCond.$deref()) {
                            Negate.$set(!Negate.$deref());
                          }
                          return $c$.clean(getTrylockCallExpr(BOP.getLHS(), $c$.track(new ImmutableMapPtrUInt</*const*/ NamedDecl /*P*/ >(C)), Negate));
                        } finally {
                          $c$.$destroy();
                        }
                      }
                      TCond.$set(false);
                      if (getStaticBooleanValue(BOP.getLHS(), TCond)) {
                        JavaCleaner $c$ = $createJavaCleaner();
                        try {
                          if (!TCond.$deref()) {
                            Negate.$set(!Negate.$deref());
                          }
                          return $c$.clean(getTrylockCallExpr(BOP.getRHS(), $c$.track(new ImmutableMapPtrUInt</*const*/ NamedDecl /*P*/ >(C)), Negate));
                        } finally {
                          $c$.$destroy();
                        }
                      }
                      return null;
                    }
                    if (BOP.getOpcode() == BinaryOperatorKind.BO_LAnd) {
                      JavaCleaner $c$ = $createJavaCleaner();
                      try {
                        // LHS must have been evaluated in a different block.
                        return $c$.clean(getTrylockCallExpr(BOP.getRHS(), $c$.track(new ImmutableMapPtrUInt</*const*/ NamedDecl /*P*/ >(C)), Negate));
                      } finally {
                        $c$.$destroy();
                      }
                    }
                    if (BOP.getOpcode() == BinaryOperatorKind.BO_LOr) {
                      JavaCleaner $c$ = $createJavaCleaner();
                      try {
                        return $c$.clean(getTrylockCallExpr(BOP.getRHS(), $c$.track(new ImmutableMapPtrUInt</*const*/ NamedDecl /*P*/ >(C)), Negate));
                      } finally {
                        $c$.$destroy();
                      }
                    }
                    return null;
                  }
                }
              }
            }
          }
        }
      }
    }
    return null;
  }

  
  
  /// \brief Find the lockset that holds on the edge between PredBlock
  /// and CurrBlock.  The edge set is the exit set of PredBlock (passed
  /// as the ExitSet parameter) plus any trylocks, which are conditionally held.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ThreadSafetyAnalyzer::getEdgeLockset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 1390,
   FQN="(anonymous namespace)::ThreadSafetyAnalyzer::getEdgeLockset", NM="_ZN12_GLOBAL__N_120ThreadSafetyAnalyzer14getEdgeLocksetERNS_7FactSetERKS1_PKN5clang8CFGBlockES8_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN12_GLOBAL__N_120ThreadSafetyAnalyzer14getEdgeLocksetERNS_7FactSetERKS1_PKN5clang8CFGBlockES8_")
  //</editor-fold>
  public void getEdgeLockset(final FactSet /*&*/ Result, 
                final /*const*/ FactSet /*&*/ ExitSet, 
                /*const*/ CFGBlock /*P*/ PredBlock, 
                /*const*/ CFGBlock /*P*/ CurrBlock) {
    CapExprSet ExclusiveLocksToAdd = null;
    CapExprSet SharedLocksToAdd = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      Result.$assign(ExitSet);
      
      /*const*/ Stmt /*P*/ Cond = PredBlock.getTerminatorCondition$Const();
      if (!(Cond != null)) {
        return;
      }
      
      bool$ref Negate = create_bool$ref(false);
      /*const*/ CFGBlockInfo /*P*/ PredBlockInfo = $AddrOf(BlockInfo.$at(PredBlock.getBlockID()));
      final /*const*/ImmutableMapPtrUInt</*const*/ NamedDecl /*P*/ > /*&*/ LVarCtx = PredBlockInfo.ExitContext;
      StringRef CapDiagKind = new StringRef(/*KEEP_STR*/"mutex");
      
      CallExpr /*P*/ Exp = $c$.clean(((/*const_cast*/CallExpr /*P*/ )(getTrylockCallExpr(Cond, $c$.track(new ImmutableMapPtrUInt</*const*/ NamedDecl /*P*/ >(LVarCtx)), Negate))));
      if (!(Exp != null)) {
        return;
      }
      
      NamedDecl /*P*/ FunDecl = dyn_cast_or_null_NamedDecl(Exp.getCalleeDecl());
      if (!(FunDecl != null) || !FunDecl.hasAttrs()) {
        return;
      }
      
      ExclusiveLocksToAdd/*J*/= new CapExprSet();
      SharedLocksToAdd/*J*/= new CapExprSet();
      
      // If the condition is a call to a Trylock function, then grab the attributes
      for (Attr /*P*/ $Attr : FunDecl.attrs()) {
        switch ($Attr.getKind()) {
         case ExclusiveTrylockFunction:
          {
            ExclusiveTrylockFunctionAttr /*P*/ A = cast_ExclusiveTrylockFunctionAttr($Attr);
            getMutexIDs(ExclusiveLocksToAdd, A, Exp, FunDecl, 
                PredBlock, CurrBlock, A.getSuccessValue(), Negate.$deref());
            CapDiagKind.$assignMove(ClassifyDiagnostic$HasArgIteratorRange(A));
            break;
          }
         case SharedTrylockFunction:
          {
            SharedTrylockFunctionAttr /*P*/ A = cast_SharedTrylockFunctionAttr($Attr);
            getMutexIDs(SharedLocksToAdd, A, Exp, FunDecl, 
                PredBlock, CurrBlock, A.getSuccessValue(), Negate.$deref());
            CapDiagKind.$assignMove(ClassifyDiagnostic$HasArgIteratorRange(A));
            break;
          }
         default:
          break;
        }
      }
      
      // Add and remove locks.
      SourceLocation Loc = Exp.getExprLoc();
      for (final /*const*/ CapabilityExpr /*&*/ ExclusiveLockToAdd : ExclusiveLocksToAdd)  {
        addLock(Result, $c$.track(new std.unique_ptr<FactEntry>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(llvm.make_unique(new LockableFactEntry(ExclusiveLockToAdd, 
                    LockKind.LK_Exclusive, Loc))))), 
            new StringRef(CapDiagKind)); $c$.clean();
      }
      for (final /*const*/ CapabilityExpr /*&*/ SharedLockToAdd : SharedLocksToAdd)  {
        addLock(Result, $c$.track(new std.unique_ptr<FactEntry>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(llvm.make_unique(new LockableFactEntry(SharedLockToAdd, 
                    LockKind.LK_Shared, Loc))))), 
            new StringRef(CapDiagKind)); $c$.clean();
      }
    } finally {
      if (SharedLocksToAdd != null) { SharedLocksToAdd.$destroy(); }
      if (ExclusiveLocksToAdd != null) { ExclusiveLocksToAdd.$destroy(); }
      $c$.$destroy();
    }
  }

  
  
  /// \brief Compute the intersection of two locksets and issue warnings for any
  /// locks in the symmetric difference.
  ///
  /// This function is used at a merge point in the CFG when comparing the lockset
  /// of each branch being merged. For example, given the following sequence:
  /// A; if () then B; else C; D; we need to check that the lockset after B and C
  /// are the same. In the event of a difference, we use the intersection of these
  /// two locksets at the start of D.
  ///
  /// \param FSet1 The first lockset.
  /// \param FSet2 The second lockset.
  /// \param JoinLoc The location of the join point for error reporting
  /// \param LEK1 The error message to report if a mutex is missing from LSet1
  /// \param LEK2 The error message to report if a mutex is missing from Lset2
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ThreadSafetyAnalyzer::intersectAndWarn">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 2018,
   FQN="(anonymous namespace)::ThreadSafetyAnalyzer::intersectAndWarn", NM="_ZN12_GLOBAL__N_120ThreadSafetyAnalyzer16intersectAndWarnERNS_7FactSetERKS1_N5clang14SourceLocationENS5_12threadSafety13LockErrorKindES8_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN12_GLOBAL__N_120ThreadSafetyAnalyzer16intersectAndWarnERNS_7FactSetERKS1_N5clang14SourceLocationENS5_12threadSafety13LockErrorKindES8_b")
  //</editor-fold>
  public void intersectAndWarn(final FactSet /*&*/ FSet1, 
                  final /*const*/ FactSet /*&*/ FSet2, 
                  SourceLocation JoinLoc, 
                  LockErrorKind LEK1, 
                  LockErrorKind LEK2) {
    intersectAndWarn(FSet1, 
                  FSet2, 
                  JoinLoc, 
                  LEK1, 
                  LEK2, 
                  true);
  }
  public void intersectAndWarn(final FactSet /*&*/ FSet1, 
                  final /*const*/ FactSet /*&*/ FSet2, 
                  SourceLocation JoinLoc, 
                  LockErrorKind LEK1, 
                  LockErrorKind LEK2, 
                  boolean Modify/*= true*/) {
    FactSet FSet1Orig = new FactSet(FSet1);
    
    // Find locks in FSet2 that conflict or are not in FSet1, and warn.
    for (final /*const*/char/*ushort &*/ Fact : FSet2) {
      /*const*/ FactEntry /*P*/ LDat1 = null;
      /*const*/ FactEntry /*P*/ LDat2 = $AddrOf(FactMan.$at(Fact));
      ushort$ptr/*ushort P*/ Iter1 = $tryClone(FSet1.findLockIter(FactMan, $Deref(LDat2)));
      if ($noteq_ptr(Iter1, FSet1.end())) {
        LDat1 = $AddrOf(FactMan.$at(Iter1.$star()));
      }
      if ((LDat1 != null)) {
        if (LDat1.kind() != LDat2.kind()) {
          Handler.handleExclusiveAndShared(new StringRef(/*KEEP_STR*/"mutex"), new StringRef(LDat2.__toString()), 
              LDat2.loc(), LDat1.loc());
          if (Modify && LDat1.kind() != LockKind.LK_Exclusive) {
            // Take the exclusive lock, which is the one in FSet2.
            Iter1.$set(Fact);
          }
        } else if (Modify && LDat1.asserted() && !LDat2.asserted()) {
          // The non-asserted lock in FSet2 is the one we want to track.
          Iter1.$set(Fact);
        }
      } else {
        LDat2.handleRemovalFromIntersection(FSet2, FactMan, new SourceLocation(JoinLoc), LEK1, 
            Handler);
      }
    }
    
    // Find locks in FSet1 that are not in FSet2, and remove them.
    for (final /*const*/char/*ushort &*/ Fact : FSet1Orig) {
      /*const*/ FactEntry /*P*/ LDat1 = $AddrOf(FactMan.$at(Fact));
      /*const*/ FactEntry /*P*/ LDat2 = FSet2.findLock(FactMan, $Deref(LDat1));
      if (!(LDat2 != null)) {
        LDat1.handleRemovalFromIntersection(FSet1Orig, FactMan, new SourceLocation(JoinLoc), LEK2, 
            Handler);
        if (Modify) {
          FSet1.removeLock(FactMan, $Deref(LDat1));
        }
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ThreadSafetyAnalyzer::intersectAndWarn">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 956,
   FQN="(anonymous namespace)::ThreadSafetyAnalyzer::intersectAndWarn", NM="_ZN12_GLOBAL__N_120ThreadSafetyAnalyzer16intersectAndWarnERNS_7FactSetERKS1_N5clang14SourceLocationENS5_12threadSafety13LockErrorKindEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN12_GLOBAL__N_120ThreadSafetyAnalyzer16intersectAndWarnERNS_7FactSetERKS1_N5clang14SourceLocationENS5_12threadSafety13LockErrorKindEb")
  //</editor-fold>
  public void intersectAndWarn(final FactSet /*&*/ FSet1, final /*const*/ FactSet /*&*/ FSet2, 
                  SourceLocation JoinLoc, LockErrorKind LEK1) {
    intersectAndWarn(FSet1, FSet2, 
                  JoinLoc, LEK1, 
                  true);
  }
  public void intersectAndWarn(final FactSet /*&*/ FSet1, final /*const*/ FactSet /*&*/ FSet2, 
                  SourceLocation JoinLoc, LockErrorKind LEK1, 
                  boolean Modify/*= true*/) {
    intersectAndWarn(FSet1, FSet2, new SourceLocation(JoinLoc), LEK1, LEK1, Modify);
  }

  
  
  /// \brief Check a function's CFG for thread-safety violations.
  ///
  /// We traverse the blocks in the CFG, compute the set of mutexes that are held
  /// at the end of each block, and issue warnings for thread safety violations.
  /// Each block in the CFG is traversed exactly once.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ThreadSafetyAnalyzer::runAnalysis">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 2088,
   FQN="(anonymous namespace)::ThreadSafetyAnalyzer::runAnalysis", NM="_ZN12_GLOBAL__N_120ThreadSafetyAnalyzer11runAnalysisERN5clang19AnalysisDeclContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN12_GLOBAL__N_120ThreadSafetyAnalyzer11runAnalysisERN5clang19AnalysisDeclContextE")
  //</editor-fold>
  public void runAnalysis(final AnalysisDeclContext /*&*/ AC) {
    PostOrderCFGView.CFGBlockSet VisitedBlocks = null;
    CapExprSet ExclusiveLocksAcquired = null;
    CapExprSet SharedLocksAcquired = null;
    CapExprSet LocksReleased = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // TODO: this whole function needs be rewritten as a visitor for CFGWalker.
      // For now, we just use the walker to set things up.
      CFGWalker walker/*J*/= new CFGWalker();
      if (!walker.init(AC)) {
        return;
      }
      
      // AC.dumpCFG(true);
      // threadSafety::printSCFG(walker);
      CFG /*P*/ CFGraph = walker.getGraph();
      /*const*/ NamedDecl /*P*/ D = walker.getDecl();
      /*const*/ FunctionDecl /*P*/ CurrentFunction = dyn_cast_FunctionDecl(D);
      CurrentMethod = dyn_cast_CXXMethodDecl(D);
      if (D.hasAttr(NoThreadSafetyAnalysisAttr.class)) {
        return;
      }
      
      // FIXME: Do something a bit more intelligent inside constructor and
      // destructor code.  Constructors and destructors must assume unique access
      // to 'this', so checks on member variable access is disabled, but we should
      // still enable checks on other objects.
      if (isa_CXXConstructorDecl(D)) {
        return; // Don't check inside constructors.
      }
      if (isa_CXXDestructorDecl(D)) {
        return; // Don't check inside destructors.
      }
      
      Handler.enterFunction(CurrentFunction);
      
      BlockInfo.resize(CFGraph.getNumBlockIDs(), 
          $c$.track(CFGBlockInfo.getEmptyBlockInfo(LocalVarMap))); $c$.clean();
      
      // We need to explore the CFG via a "topological" ordering.
      // That way, we will be guaranteed to have information about required
      // predecessor locksets when exploring a new block.
      /*const*/ PostOrderCFGView /*P*/ SortedGraph = walker.getSortedGraph();
      VisitedBlocks/*J*/= new PostOrderCFGView.CFGBlockSet(CFGraph);
      
      // Mark entry block as reachable
      BlockInfo.$at(CFGraph.getEntry().getBlockID()).Reachable = true;
      
      // Compute SSA names for local variables
      LocalVarMap.traverseCFG(CFGraph, SortedGraph, BlockInfo);
      
      // Fill in source locations for all CFGBlocks.
      findBlockLocations(CFGraph, SortedGraph, BlockInfo);
      
      ExclusiveLocksAcquired/*J*/= new CapExprSet();
      SharedLocksAcquired/*J*/= new CapExprSet();
      LocksReleased/*J*/= new CapExprSet();
      
      // Add locks from exclusive_locks_required and shared_locks_required
      // to initial lockset. Also turn off checking for lock and unlock functions.
      // FIXME: is there a more intelligent way to check lock/unlock functions?
      if (!SortedGraph.empty() && D.hasAttrs()) {
        CapExprSet ExclusiveLocksToAdd = null;
        CapExprSet SharedLocksToAdd = null;
        try {
          /*const*/ CFGBlock /*P*/ FirstBlock = SortedGraph.begin$Const().$star();
          final FactSet /*&*/ InitialLockset = BlockInfo.$at(FirstBlock.getBlockID()).EntrySet;
          
          ExclusiveLocksToAdd/*J*/= new CapExprSet();
          SharedLocksToAdd/*J*/= new CapExprSet();
          StringRef CapDiagKind = new StringRef(/*KEEP_STR*/"mutex");
          
          SourceLocation Loc = D.getLocation();
          for (/*const*/ Attr /*P*/ $Attr : D.attrs()) {
            Loc.$assignMove($Attr.getLocation());
            {
              /*const*/ RequiresCapabilityAttr /*P*/ A = dyn_cast_RequiresCapabilityAttr($Attr);
              if ((A != null)) {
                getMutexIDs(A.isShared() ? SharedLocksToAdd : ExclusiveLocksToAdd, A, 
                    (Expr /*P*/ )null, D);
                CapDiagKind.$assignMove(ClassifyDiagnostic$HasArgIteratorRange(A));
              } else {
                /*const*/ ReleaseCapabilityAttr /*P*/ A$1 = dyn_cast_ReleaseCapabilityAttr($Attr);
                if ((A$1 != null)) {
                  // UNLOCK_FUNCTION() is used to hide the underlying lock implementation.
                  // We must ignore such methods.
                  if (A$1.args_size() == 0) {
                    return;
                  }
                  // FIXME -- deal with exclusive vs. shared unlock functions?
                  getMutexIDs(ExclusiveLocksToAdd, A$1, (Expr /*P*/ )null, D);
                  getMutexIDs(LocksReleased, A$1, (Expr /*P*/ )null, D);
                  CapDiagKind.$assignMove(ClassifyDiagnostic$HasArgIteratorRange(A$1));
                } else {
                  /*const*/ AcquireCapabilityAttr /*P*/ A$2 = dyn_cast_AcquireCapabilityAttr($Attr);
                  if ((A$2 != null)) {
                    if (A$2.args_size() == 0) {
                      return;
                    }
                    getMutexIDs(A$2.isShared() ? SharedLocksAcquired : ExclusiveLocksAcquired, 
                        A$2, (Expr /*P*/ )null, D);
                    CapDiagKind.$assignMove(ClassifyDiagnostic$HasArgIteratorRange(A$2));
                  } else if (isa_ExclusiveTrylockFunctionAttr($Attr)) {
                    // Don't try to check trylock functions for now
                    return;
                  } else if (isa_SharedTrylockFunctionAttr($Attr)) {
                    // Don't try to check trylock functions for now
                    return;
                  }
                }
              }
            }
          }
          
          // FIXME -- Loc can be wrong here.
          for (final /*const*/ CapabilityExpr /*&*/ Mu : ExclusiveLocksToAdd) {
            unique_ptr<LockableFactEntry> Entry = null;
            try {
              Entry = llvm.make_unique(new LockableFactEntry(Mu, LockKind.LK_Exclusive, Loc));
              Entry.$arrow().setDeclared(true);
              addLock(InitialLockset, $c$.track(new std.unique_ptr<FactEntry>(JD$Unique_ptr$_Up$_Ep.INSTANCE, std.move(Entry))), new StringRef(CapDiagKind), true); $c$.clean();
            } finally {
              if (Entry != null) { Entry.$destroy(); }
            }
          }
          for (final /*const*/ CapabilityExpr /*&*/ Mu : SharedLocksToAdd) {
            unique_ptr<LockableFactEntry> Entry = null;
            try {
              Entry = llvm.make_unique(new LockableFactEntry(Mu, LockKind.LK_Shared, Loc));
              Entry.$arrow().setDeclared(true);
              addLock(InitialLockset, $c$.track(new std.unique_ptr<FactEntry>(JD$Unique_ptr$_Up$_Ep.INSTANCE, std.move(Entry))), new StringRef(CapDiagKind), true); $c$.clean();
            } finally {
              if (Entry != null) { Entry.$destroy(); }
            }
          }
        } finally {
          if (SharedLocksToAdd != null) { SharedLocksToAdd.$destroy(); }
          if (ExclusiveLocksToAdd != null) { ExclusiveLocksToAdd.$destroy(); }
        }
      }
      
      for (/*const*/ CFGBlock /*P*/ CurrBlock : $Deref(SortedGraph)) {
        BuildLockset LocksetBuilder = null;
        try {
          int CurrBlockID = CurrBlock.getBlockID();
          CFGBlockInfo /*P*/ CurrBlockInfo = $AddrOf(BlockInfo.$at(CurrBlockID));
          
          // Use the default initial lockset in case there are no predecessors.
          VisitedBlocks.insert(CurrBlock);
          
          // Iterate through the predecessor blocks and warn if the lockset for all
          // predecessors is not the same. We take the entry lockset of the current
          // block to be the intersection of all previous locksets.
          // FIXME: By keeping the intersection, we may output more errors in future
          // for a lock which is not in the intersection, but was in the union. We
          // may want to also keep the union in future. As an example, let's say
          // the intersection contains Mutex L, and the union contains L and M.
          // Later we unlock M. At this point, we would output an error because we
          // never locked M; although the real error is probably that we forgot to
          // lock M on all code paths. Conversely, let's say that later we lock M.
          // In this case, we should compare against the intersection instead of the
          // union because the real error is probably that we forgot to unlock M on
          // all code paths.
          boolean LocksetInitialized = false;
          SmallVector<CFGBlock /*P*/ > SpecialBlocks/*J*/= new SmallVector<CFGBlock /*P*/ >(8, (CFGBlock /*P*/ )null);
          for (type$ptr</*const*/ CFGBlock.AdjacentBlock /*P*/ > PI = $tryClone(CurrBlock.pred_begin$Const()), 
              /*P*/ PE = $tryClone(CurrBlock.pred_end$Const()); $noteq_ptr(PI, PE); PI.$preInc()) {
            FactSet PrevLockset = null;
            try {
              
              // if *PI -> CurrBlock is a back edge
              if (PI.$star().$CFGBlock$P() == null || !VisitedBlocks.alreadySet(PI.$star().$CFGBlock$P())) {
                continue;
              }
              
              int PrevBlockID = (PI.$star()).$arrow().getBlockID();
              CFGBlockInfo /*P*/ PrevBlockInfo = $AddrOf(BlockInfo.$at(PrevBlockID));
              
              // Ignore edges from blocks that can't return.
              if (neverReturns(PI.$star().$CFGBlock$P()) || !PrevBlockInfo.Reachable) {
                continue;
              }
              
              // Okay, we can reach this block from the entry.
              CurrBlockInfo.Reachable = true;
              {
                
                // If the previous block ended in a 'continue' or 'break' statement, then
                // a difference in locksets is probably due to a bug in that block, rather
                // than in some other predecessor. In that case, keep the other
                // predecessor's lockset.
                /*const*/ Stmt /*P*/ Terminator = (PI.$star()).$arrow().getTerminator().$Stmt$P();
                if ((Terminator != null)) {
                  if (isa_ContinueStmt(Terminator) || isa_BreakStmt(Terminator)) {
                    SpecialBlocks.push_back(PI.$star().$CFGBlock$P());
                    continue;
                  }
                }
              }
              
              PrevLockset/*J*/= new FactSet();
              getEdgeLockset(PrevLockset, PrevBlockInfo.ExitSet, PI.$star().$CFGBlock$P(), CurrBlock);
              if (!LocksetInitialized) {
                CurrBlockInfo.EntrySet.$assign(PrevLockset);
                LocksetInitialized = true;
              } else {
                intersectAndWarn(CurrBlockInfo.EntrySet, PrevLockset, 
                    new SourceLocation(CurrBlockInfo.EntryLoc), 
                    LockErrorKind.LEK_LockedSomePredecessors);
              }
            } finally {
              if (PrevLockset != null) { PrevLockset.$destroy(); }
            }
          }
          
          // Skip rest of block if it's not reachable.
          if (!CurrBlockInfo.Reachable) {
            continue;
          }
          
          // Process continue and break blocks. Assume that the lockset for the
          // resulting block is unaffected by any discrepancies in them.
          for (/*const*/ CFGBlock /*P*/ PrevBlock : SpecialBlocks) {
            int PrevBlockID = PrevBlock.getBlockID();
            CFGBlockInfo /*P*/ PrevBlockInfo = $AddrOf(BlockInfo.$at(PrevBlockID));
            if (!LocksetInitialized) {
              CurrBlockInfo.EntrySet.$assign(PrevBlockInfo.ExitSet);
              LocksetInitialized = true;
            } else {
              FactSet PrevLockset = null;
              try {
                // Determine whether this edge is a loop terminator for diagnostic
                // purposes. FIXME: A 'break' statement might be a loop terminator, but
                // it might also be part of a switch. Also, a subsequent destructor
                // might add to the lockset, in which case the real issue might be a
                // double lock on the other path.
                /*const*/ Stmt /*P*/ Terminator = PrevBlock.getTerminator$Const().$Stmt$C$P();
                boolean IsLoop = (Terminator != null) && isa_ContinueStmt(Terminator);
                
                PrevLockset/*J*/= new FactSet();
                getEdgeLockset(PrevLockset, PrevBlockInfo.ExitSet, 
                    PrevBlock, CurrBlock);
                
                // Do not update EntrySet.
                intersectAndWarn(CurrBlockInfo.EntrySet, PrevLockset, 
                    new SourceLocation(PrevBlockInfo.ExitLoc), 
                    IsLoop ? LockErrorKind.LEK_LockedSomeLoopIterations : LockErrorKind.LEK_LockedSomePredecessors, 
                    false);
              } finally {
                if (PrevLockset != null) { PrevLockset.$destroy(); }
              }
            }
          }
          
          LocksetBuilder/*J*/= new BuildLockset(this, $Deref(CurrBlockInfo));
          
          // Visit all the statements in the basic block.
          for (std.reverse_iterator</*const*/ CFGElement> BI = CurrBlock.begin$Const(), 
              BE = CurrBlock.end$Const(); $noteq_reverse_iterator$C(BI, BE); BI.$preInc()) {
            switch (BI.$arrow().getKind()) {
             case Statement:
              {
                CFGStmt CS = BI.$arrow().castAs(CFGStmt.class);
                LocksetBuilder.Visit(((/*const_cast*/Stmt /*P*/ )(CS.getStmt())));
                break;
              }
             case AutomaticObjectDtor:
              {
                CFGAutomaticObjDtor AD = BI.$arrow().castAs(CFGAutomaticObjDtor.class);
                CXXDestructorDecl /*P*/ DD = ((/*const_cast*/CXXDestructorDecl /*P*/ )(AD.getDestructorDecl(AC.getASTContext())));
                if (!DD.hasAttrs()) {
                  break;
                }
                
                // Create a dummy expression,
                VarDecl /*P*/ VD = ((/*const_cast*/VarDecl /*P*/ )(AD.getVarDecl()));
                DeclRefExpr DRE/*J*/= new DeclRefExpr(VD, false, VD.getType().getNonReferenceType(), 
                    ExprValueKind.VK_LValue, AD.getTriggerStmt().getLocEnd());
                LocksetBuilder.handleCall($AddrOf(DRE), DD);
                break;
              }
             default:
              break;
            }
          }
          CurrBlockInfo.ExitSet.$assign(LocksetBuilder.FSet);
          
          // For every back edge from CurrBlock (the end of the loop) to another block
          // (FirstLoopBlock) we need to check that the Lockset of Block is equal to
          // the one held at the beginning of FirstLoopBlock. We can look up the
          // Lockset held at the beginning of FirstLoopBlock in the EntryLockSets map.
          for (type$ptr</*const*/ CFGBlock.AdjacentBlock /*P*/ > SI = $tryClone(CurrBlock.succ_begin$Const()), 
              /*P*/ SE = $tryClone(CurrBlock.succ_end$Const()); $noteq_ptr(SI, SE); SI.$preInc()) {
            
            // if CurrBlock -> *SI is *not* a back edge
            if (SI.$star().$CFGBlock$P() == null || !VisitedBlocks.alreadySet(SI.$star().$CFGBlock$P())) {
              continue;
            }
            
            CFGBlock /*P*/ FirstLoopBlock = SI.$star().$CFGBlock$P();
            CFGBlockInfo /*P*/ PreLoop = $AddrOf(BlockInfo.$at(FirstLoopBlock.getBlockID()));
            CFGBlockInfo /*P*/ LoopEnd = $AddrOf(BlockInfo.$at(CurrBlockID));
            intersectAndWarn(LoopEnd.ExitSet, PreLoop.EntrySet, 
                new SourceLocation(PreLoop.EntryLoc), 
                LockErrorKind.LEK_LockedSomeLoopIterations, 
                false);
          }
        } finally {
          if (LocksetBuilder != null) { LocksetBuilder.$destroy(); }
        }
      }
      
      CFGBlockInfo /*P*/ Initial = $AddrOf(BlockInfo.$at(CFGraph.getEntry().getBlockID()));
      CFGBlockInfo /*P*/ Final = $AddrOf(BlockInfo.$at(CFGraph.getExit().getBlockID()));
      
      // Skip the final check if the exit block is unreachable.
      if (!Final.Reachable) {
        return;
      }
      
      // By default, we expect all locks held on entry to be held on exit.
      FactSet ExpectedExitSet = new FactSet(Initial.EntrySet);
      
      // Adjust the expected exit set by adding or removing locks, as declared
      // by *-LOCK_FUNCTION and UNLOCK_FUNCTION.  The intersect below will then
      // issue the appropriate warning.
      // FIXME: the location here is not quite right.
      for (final /*const*/ CapabilityExpr /*&*/ Lock : ExclusiveLocksAcquired)  {
        $c$.clean(ExpectedExitSet.addLock(FactMan, $c$.track(new std.unique_ptr<FactEntry>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(llvm.make_unique(new LockableFactEntry(Lock, LockKind.LK_Exclusive, D.getLocation())))))));
      }
      for (final /*const*/ CapabilityExpr /*&*/ Lock : SharedLocksAcquired)  {
        $c$.clean(ExpectedExitSet.addLock(FactMan, $c$.track(new std.unique_ptr<FactEntry>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(llvm.make_unique(new LockableFactEntry(Lock, LockKind.LK_Shared, D.getLocation())))))));
      }
      for (final /*const*/ CapabilityExpr /*&*/ Lock : LocksReleased)  {
        ExpectedExitSet.removeLock(FactMan, Lock);
      }
      
      // FIXME: Should we call this function for all blocks which exit the function?
      intersectAndWarn(ExpectedExitSet, Final.ExitSet, 
          new SourceLocation(Final.ExitLoc), 
          LockErrorKind.LEK_LockedAtEndOfFunction, 
          LockErrorKind.LEK_NotLockedAtEndOfFunction, 
          false);
      
      Handler.leaveFunction(CurrentFunction);
    } finally {
      if (LocksReleased != null) { LocksReleased.$destroy(); }
      if (SharedLocksAcquired != null) { SharedLocksAcquired.$destroy(); }
      if (ExclusiveLocksAcquired != null) { ExclusiveLocksAcquired.$destroy(); }
      if (VisitedBlocks != null) { VisitedBlocks.$destroy(); }
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ThreadSafetyAnalyzer::~ThreadSafetyAnalyzer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 906,
   FQN="(anonymous namespace)::ThreadSafetyAnalyzer::~ThreadSafetyAnalyzer", NM="_ZN12_GLOBAL__N_120ThreadSafetyAnalyzerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN12_GLOBAL__N_120ThreadSafetyAnalyzerD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    BlockInfo.$destroy();
    FactMan.$destroy();
    LocalVarMap.$destroy();
    SxBuilder.$destroy();
    Bpa.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "Bpa=" + "[BumpPtrAllocatorImpl]" // NOI18N
              + ", Arena=" + Arena // NOI18N
              + ", SxBuilder=" + "[SExprBuilder]" // NOI18N
              + ", Handler=" + "[ThreadSafetyHandler]" // NOI18N
              + ", CurrentMethod=" + CurrentMethod // NOI18N
              + ", LocalVarMap=" + LocalVarMap // NOI18N
              + ", FactMan=" + "[FactManager]" // NOI18N
              + ", BlockInfo=" + BlockInfo // NOI18N
              + ", GlobalBeforeSet=" + GlobalBeforeSet; // NOI18N
  }
}
