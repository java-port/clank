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
package org.clang.staticanalyzer.checkers.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.analysis.*;
import org.clang.basic.*;
import org.clang.staticanalyzer.checkers.ento.*;
import org.clang.staticanalyzer.checkers.ento.impl.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import org.clang.staticanalyzer.checkers.ento.objc_retain.*;
import static org.clang.staticanalyzer.java.StaticanalyzerRTTI.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.staticanalyzer.checkers.impl.RetainCountCheckerStatics.*;
import org.clang.analysis.domainspecific.ento.*;;


//<editor-fold defaultstate="collapsed" desc="static type RetainCountCheckerStatics">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.clang.staticanalyzer.checkers.impl.RetainCountCheckerStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZL13GetReturnTypePKN5clang4ExprERNS_10ASTContextE;_ZL13getRefBindingN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEEPKNS2_7SymExprE;_ZL13isAutoreleasePKN5clang12FunctionDeclEN4llvm9StringRefE;_ZL13setRefBindingN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEEPKNS2_7SymExprEN12_GLOBAL__N_16RefValE;_ZL16removeRefBindingN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEEPKNS2_7SymExprE;_ZL17GetAllocationSiteRN5clang4ento19ProgramStateManagerEPKNS0_12ExplodedNodeEPKNS0_7SymExprE;_ZL17isMakeCollectablePKN5clang12FunctionDeclEN4llvm9StringRefE;_ZL18updateOutParameterN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEENS2_4SValENS2_11objc_retain9ArgEffectE;_ZL21isSynthesizedAccessorPKN5clang17StackFrameContextE;_ZL26isNumericLiteralExpressionPKN5clang4ExprE;_ZL29getStopTrackingHardEquivalentN5clang4ento11objc_retain9ArgEffectE;_ZL8isRetainPKN5clang12FunctionDeclEN4llvm9StringRefE;_ZL9isReleasePKN5clang12FunctionDeclEN4llvm9StringRefE;_ZN12_GLOBAL__N_120StopTrackingCallbackE; -static-type=RetainCountCheckerStatics -package=org.clang.staticanalyzer.checkers.impl")
//</editor-fold>
public final class RetainCountCheckerStatics {

//<editor-fold defaultstate="collapsed" desc="getRefBinding">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 365,
 FQN="getRefBinding", NM="_ZL13getRefBindingN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEEPKNS2_7SymExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZL13getRefBindingN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEEPKNS2_7SymExprE")
//</editor-fold>
public static /*inline*/ /*const*/ RefVal /*P*/ getRefBinding(IntrusiveRefCntPtr</*const*/ ProgramState> State, 
             /*const*/ SymExpr /*P*/ Sym) {
  return State.$arrow().get(ProgramStateTraitRefBindings.$Instance, Sym);
}

//<editor-fold defaultstate="collapsed" desc="setRefBinding">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 370,
 FQN="setRefBinding", NM="_ZL13setRefBindingN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEEPKNS2_7SymExprEN12_GLOBAL__N_16RefValE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZL13setRefBindingN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEEPKNS2_7SymExprEN12_GLOBAL__N_16RefValE")
//</editor-fold>
public static /*inline*/ IntrusiveRefCntPtr</*const*/ ProgramState> setRefBinding(IntrusiveRefCntPtr</*const*/ ProgramState> State, 
             /*const*/ SymExpr /*P*/ Sym, RefVal Val) {
  return State.$arrow().set(ProgramStateTraitRefBindings.$Instance, Sym, new RefVal(Val));
}

//<editor-fold defaultstate="collapsed" desc="removeRefBinding">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 375,
 FQN="removeRefBinding", NM="_ZL16removeRefBindingN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEEPKNS2_7SymExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZL16removeRefBindingN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEEPKNS2_7SymExprE")
//</editor-fold>
public static IntrusiveRefCntPtr</*const*/ ProgramState> removeRefBinding(IntrusiveRefCntPtr</*const*/ ProgramState> State, /*const*/ SymExpr /*P*/ Sym) {
  return State.$arrow().remove(ProgramStateTraitRefBindings.$Instance, Sym);
}


//===----------------------------------------------------------------------===//
// Summary creation for functions (largely uses of Core Foundation).
//===----------------------------------------------------------------------===//
//<editor-fold defaultstate="collapsed" desc="isRetain">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 885,
 FQN="isRetain", NM="_ZL8isRetainPKN5clang12FunctionDeclEN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZL8isRetainPKN5clang12FunctionDeclEN4llvm9StringRefE")
//</editor-fold>
public static boolean isRetain(/*const*/ FunctionDecl /*P*/ FD, StringRef FName) {
  return FName.endswith(/*STRINGREF_STR*/"Retain");
}

//<editor-fold defaultstate="collapsed" desc="isRelease">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 889,
 FQN="isRelease", NM="_ZL9isReleasePKN5clang12FunctionDeclEN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZL9isReleasePKN5clang12FunctionDeclEN4llvm9StringRefE")
//</editor-fold>
public static boolean isRelease(/*const*/ FunctionDecl /*P*/ FD, StringRef FName) {
  return FName.endswith(/*STRINGREF_STR*/"Release");
}

//<editor-fold defaultstate="collapsed" desc="isAutorelease">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 893,
 FQN="isAutorelease", NM="_ZL13isAutoreleasePKN5clang12FunctionDeclEN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZL13isAutoreleasePKN5clang12FunctionDeclEN4llvm9StringRefE")
//</editor-fold>
public static boolean isAutorelease(/*const*/ FunctionDecl /*P*/ FD, StringRef FName) {
  return FName.endswith(/*STRINGREF_STR*/"Autorelease");
}

//<editor-fold defaultstate="collapsed" desc="isMakeCollectable">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 897,
 FQN="isMakeCollectable", NM="_ZL17isMakeCollectablePKN5clang12FunctionDeclEN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZL17isMakeCollectablePKN5clang12FunctionDeclEN4llvm9StringRefE")
//</editor-fold>
public static boolean isMakeCollectable(/*const*/ FunctionDecl /*P*/ FD, StringRef FName) {
  // FIXME: Remove FunctionDecl parameter.
  // FIXME: Is it really okay if MakeCollectable isn't a suffix?
  return FName.find(/*STRINGREF_STR*/"MakeCollectable") != StringRef.npos;
}

//<editor-fold defaultstate="collapsed" desc="getStopTrackingHardEquivalent">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 903,
 FQN="getStopTrackingHardEquivalent", NM="_ZL29getStopTrackingHardEquivalentN5clang4ento11objc_retain9ArgEffectE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZL29getStopTrackingHardEquivalentN5clang4ento11objc_retain9ArgEffectE")
//</editor-fold>
public static objc_retain.ArgEffect getStopTrackingHardEquivalent(objc_retain.ArgEffect E) {
  switch (E) {
   case DoNothing:
   case Autorelease:
   case DecRefBridgedTransferred:
   case IncRef:
   case IncRefMsg:
   case MakeCollectable:
   case UnretainedOutParameter:
   case RetainedOutParameter:
   case MayEscape:
   case StopTracking:
   case StopTrackingHard:
    return ArgEffect.StopTrackingHard;
   case DecRef:
   case DecRefAndStopTrackingHard:
    return ArgEffect.DecRefAndStopTrackingHard;
   case DecRefMsg:
   case DecRefMsgAndStopTrackingHard:
    return ArgEffect.DecRefMsgAndStopTrackingHard;
   case Dealloc:
    return ArgEffect.Dealloc;
  }
  throw new llvm_unreachable("Unknown ArgEffect kind");
}

//<editor-fold defaultstate="collapsed" desc="isNumericLiteralExpression">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 1871,
 FQN="isNumericLiteralExpression", NM="_ZL26isNumericLiteralExpressionPKN5clang4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZL26isNumericLiteralExpressionPKN5clang4ExprE")
//</editor-fold>
public static boolean isNumericLiteralExpression(/*const*/ Expr /*P*/ E) {
  // FIXME: This set of cases was copied from SemaExprObjC.
  return isa_IntegerLiteral(E)
     || isa_CharacterLiteral(E)
     || isa_FloatingLiteral(E)
     || isa_ObjCBoolLiteralExpr(E)
     || isa_CXXBoolLiteralExpr(E);
}


/// Returns true if this stack frame is for an Objective-C method that is a
/// property getter or setter whose body has been synthesized by the analyzer.
//<editor-fold defaultstate="collapsed" desc="isSynthesizedAccessor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 1882,
 FQN="isSynthesizedAccessor", NM="_ZL21isSynthesizedAccessorPKN5clang17StackFrameContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZL21isSynthesizedAccessorPKN5clang17StackFrameContextE")
//</editor-fold>
public static boolean isSynthesizedAccessor(/*const*/ StackFrameContext /*P*/ SFC) {
  /*const*/ ObjCMethodDecl /*P*/ Method = dyn_cast_or_null_ObjCMethodDecl(SFC.getDecl());
  if (!(Method != null) || !Method.isPropertyAccessor()) {
    return false;
  }
  
  return SFC.getAnalysisDeclContext().isBodyAutosynthesized();
}

// end anonymous namespace
//<editor-fold defaultstate="collapsed" desc="GetAllocationSite">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 2213,
 FQN="GetAllocationSite", NM="_ZL17GetAllocationSiteRN5clang4ento19ProgramStateManagerEPKNS0_12ExplodedNodeEPKNS0_7SymExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZL17GetAllocationSiteRN5clang4ento19ProgramStateManagerEPKNS0_12ExplodedNodeEPKNS0_7SymExprE")
//</editor-fold>
public static AllocationInfo GetAllocationSite(final ProgramStateManager /*&*/ StateMgr, /*const*/ ExplodedNode /*P*/ N, 
                 /*const*/ SymExpr /*P*/ Sym) {
  /*const*/ ExplodedNode /*P*/ AllocationNode = N;
  /*const*/ ExplodedNode /*P*/ AllocationNodeInCurrentOrParentContext = N;
  /*const*/ MemRegion /*P*/ FirstBinding = null;
  /*const*/ LocationContext /*P*/ LeakContext = N.getLocationContext();
  
  // The location context of the init method called on the leaked object, if
  // available.
  /*const*/ LocationContext /*P*/ InitMethodContext = null;
  while ((N != null)) {
    IntrusiveRefCntPtr</*const*/ ProgramState> St = null;
    StoreManager.FindUniqueBinding FB = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      St = new IntrusiveRefCntPtr</*const*/ ProgramState>(N.getState());
      /*const*/ LocationContext /*P*/ NContext = N.getLocationContext();
      if ($c$.clean(!(getRefBinding($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(St)), Sym) != null))) {
        break;
      }
      
      FB/*J*/= new StoreManager.FindUniqueBinding(Sym);
      StateMgr.iterBindings($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(St)), FB); $c$.clean();
      if (FB.$bool()) {
        /*const*/ MemRegion /*P*/ R = FB.getRegion();
        /*const*/ VarRegion /*P*/ VR = R.getBaseRegion().getAs(VarRegion.class);
        // Do not show local variables belonging to a function other than
        // where the error is reported.
        if (!(VR != null) || VR.getStackFrame() == LeakContext.getCurrentStackFrame()) {
          FirstBinding = R;
        }
      }
      
      // AllocationNode is the last node in which the symbol was tracked.
      AllocationNode = N;
      
      // AllocationNodeInCurrentContext, is the last node in the current or
      // parent context in which the symbol was tracked.
      //
      // Note that the allocation site might be in the parent conext. For example,
      // the case where an allocation happens in a block that captures a reference
      // to it and that reference is overwritten/dropped by another call to
      // the block.
      if (NContext == LeakContext || NContext.isParentOf(LeakContext)) {
        AllocationNodeInCurrentOrParentContext = N;
      }
      
      // Find the last init that was called on the given symbol and store the
      // init method's location context.
      if (!(InitMethodContext != null)) {
        {
          Optional<CallEnter> CEP = N.getLocation().getAs(CallEnter.class);
          if (CEP.$bool()) {
            /*const*/ Stmt /*P*/ CE = CEP.$arrow().getCallExpr();
            {
              /*const*/ ObjCMessageExpr /*P*/ ME = dyn_cast_or_null_ObjCMessageExpr(CE);
              if ((ME != null)) {
                /*const*/ Stmt /*P*/ RecExpr = ME.getInstanceReceiver$Const();
                if ((RecExpr != null)) {
                  SVal RecV = St.$arrow().getSVal(RecExpr, NContext);
                  if (ME.getMethodFamily() == ObjCMethodFamily.OMF_init && RecV.getAsSymbol() == Sym) {
                    InitMethodContext = CEP.$arrow().getCalleeContext();
                  }
                }
              }
            }
          }
        }
      }
      
      N = N.pred_empty() ? null : (N.pred_begin$Const()).$star();
    } finally {
      if (FB != null) { FB.$destroy(); }
      if (St != null) { St.$destroy(); }
      $c$.$destroy();
    }
  }
  
  // If we are reporting a leak of the object that was allocated with alloc,
  // mark its init method as interesting.
  /*const*/ LocationContext /*P*/ InterestingMethodContext = null;
  if ((InitMethodContext != null)) {
    /*const*/ ProgramPoint AllocPP = AllocationNode.getLocation();
    {
      Optional<StmtPoint> SP = AllocPP.getAs(StmtPoint.class);
      if (SP.$bool()) {
        {
          /*const*/ ObjCMessageExpr /*P*/ ME = SP.$arrow().<ObjCMessageExpr>getStmtAs(ObjCMessageExpr.class);
          if ((ME != null)) {
            if (ME.getMethodFamily() == ObjCMethodFamily.OMF_alloc) {
              InterestingMethodContext = InitMethodContext;
            }
          }
        }
      }
    }
  }
  
  // If allocation happened in a function different from the leak node context,
  // do not report the binding.
  assert ((N != null)) : "Could not find allocation node";
  if (N.getLocationContext() != LeakContext) {
    FirstBinding = null;
  }
  
  return new AllocationInfo(AllocationNodeInCurrentOrParentContext, 
      FirstBinding, 
      InterestingMethodContext);
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StopTrackingCallback">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 2684,
 FQN="(anonymous namespace)::StopTrackingCallback", NM="_ZN12_GLOBAL__N_120StopTrackingCallbackE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZN12_GLOBAL__N_120StopTrackingCallbackE")
//</editor-fold>
public static final class StopTrackingCallback extends /*public*/ SymbolVisitor implements Destructors.ClassWithDestructor {
  private IntrusiveRefCntPtr</*const*/ ProgramState> state;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StopTrackingCallback::StopTrackingCallback">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 2687,
   FQN="(anonymous namespace)::StopTrackingCallback::StopTrackingCallback", NM="_ZN12_GLOBAL__N_120StopTrackingCallbackC1EN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZN12_GLOBAL__N_120StopTrackingCallbackC1EN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEE")
  //</editor-fold>
  public StopTrackingCallback(IntrusiveRefCntPtr</*const*/ ProgramState> st) {
    // : SymbolVisitor(), state(std::move(st)) 
    //START JInit
    super();
    this.state = new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, std.move(st));
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StopTrackingCallback::getState">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 2688,
   FQN="(anonymous namespace)::StopTrackingCallback::getState", NM="_ZNK12_GLOBAL__N_120StopTrackingCallback8getStateEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZNK12_GLOBAL__N_120StopTrackingCallback8getStateEv")
  //</editor-fold>
  public IntrusiveRefCntPtr</*const*/ ProgramState> getState() /*const*/ {
    return new IntrusiveRefCntPtr</*const*/ ProgramState>(state);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StopTrackingCallback::VisitSymbol">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 2690,
   FQN="(anonymous namespace)::StopTrackingCallback::VisitSymbol", NM="_ZN12_GLOBAL__N_120StopTrackingCallback11VisitSymbolEPKN5clang4ento7SymExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZN12_GLOBAL__N_120StopTrackingCallback11VisitSymbolEPKN5clang4ento7SymExprE")
  //</editor-fold>
  @Override public boolean VisitSymbol(/*const*/ SymExpr /*P*/ sym)/* override*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean(state.$assign($c$.track(state.$arrow().remove(ProgramStateTraitRefBindings.$Instance, sym))));
      return true;
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StopTrackingCallback::StopTrackingCallback">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 2684,
   FQN="(anonymous namespace)::StopTrackingCallback::StopTrackingCallback", NM="_ZN12_GLOBAL__N_120StopTrackingCallbackC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZN12_GLOBAL__N_120StopTrackingCallbackC1EOS0_")
  //</editor-fold>
  public /*inline*/ StopTrackingCallback(JD$Move _dparam, final StopTrackingCallback /*&&*/$Prm0) {
    // : SymbolVisitor(static_cast<StopTrackingCallback &&>()), state(static_cast<StopTrackingCallback &&>().state) 
    //START JInit
    super(JD$Move.INSTANCE, $Prm0);
    this.state = new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, $Prm0.state);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StopTrackingCallback::~StopTrackingCallback">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 2684,
   FQN="(anonymous namespace)::StopTrackingCallback::~StopTrackingCallback", NM="_ZN12_GLOBAL__N_120StopTrackingCallbackD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZN12_GLOBAL__N_120StopTrackingCallbackD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    state.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "state=" + state // NOI18N
              + super.toString(); // NOI18N
  }
}

/// GetReturnType - Used to get the return type of a message expression or
///  function call with the intention of affixing that type to a tracked symbol.
///  While the return type can be queried directly from RetEx, when
///  invoking class methods we augment to the return type to be that of
///  a pointer to the class (as opposed it just being id).
// FIXME: We may be able to do this with related result types instead.
// This function is probably overestimating.
//<editor-fold defaultstate="collapsed" desc="GetReturnType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 2908,
 FQN="GetReturnType", NM="_ZL13GetReturnTypePKN5clang4ExprERNS_10ASTContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZL13GetReturnTypePKN5clang4ExprERNS_10ASTContextE")
//</editor-fold>
public static QualType GetReturnType(/*const*/ Expr /*P*/ RetE, final ASTContext /*&*/ Ctx) {
  QualType RetTy = RetE.getType();
  {
    // If RetE is not a message expression just return its type.
    // If RetE is a message expression, return its types if it is something
    /// more specific than id.
    /*const*/ ObjCMessageExpr /*P*/ ME = dyn_cast_ObjCMessageExpr(RetE);
    if ((ME != null)) {
      {
        /*const*/ ObjCObjectPointerType /*P*/ PT = RetTy.$arrow().getAs(ObjCObjectPointerType.class);
        if ((PT != null)) {
          if (PT.isObjCQualifiedIdType() || PT.isObjCIdType()
             || PT.isObjCClassType()) {
            // At this point we know the return type of the message expression is
            // id, id<...>, or Class. If we have an ObjCInterfaceDecl, we know this
            // is a call to a class method whose type we can resolve.  In such
            // cases, promote the return type to XXX* (where XXX is the class).
            /*const*/ ObjCInterfaceDecl /*P*/ D = ME.getReceiverInterface();
            return !(D != null) ? new QualType(RetTy) : Ctx.getObjCObjectPointerType(Ctx.getObjCInterfaceType(D));
          }
        }
      }
    }
  }
  
  return RetTy;
}

//<editor-fold defaultstate="collapsed" desc="updateOutParameter">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp", line = 2968,
 FQN="updateOutParameter", NM="_ZL18updateOutParameterN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEENS2_4SValENS2_11objc_retain9ArgEffectE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/RetainCountChecker.cpp -nm=_ZL18updateOutParameterN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEENS2_4SValENS2_11objc_retain9ArgEffectE")
//</editor-fold>
public static IntrusiveRefCntPtr</*const*/ ProgramState> updateOutParameter(IntrusiveRefCntPtr</*const*/ ProgramState> State, 
                  SVal ArgVal, 
                  objc_retain.ArgEffect Effect) {
  /*const*/ TypedValueRegion /*P*/ ArgRegion = dyn_cast_or_null_TypedValueRegion(ArgVal.getAsRegion());
  if (!(ArgRegion != null)) {
    return new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, State);
  }
  
  QualType PointeeTy = ArgRegion.getValueType();
  if (!coreFoundation.isCFObjectRef(new QualType(PointeeTy))) {
    return new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, State);
  }
  
  SVal PointeeVal = State.$arrow().getSVal(ArgRegion);
  /*const*/ SymExpr /*P*/ Pointee = PointeeVal.getAsLocSymbol();
  if (!(Pointee != null)) {
    return new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, State);
  }
  switch (Effect) {
   case UnretainedOutParameter:
    {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean(State.$assign($c$.track(setRefBinding($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), Pointee, 
                RefVal.makeNotOwned(RetEffect.ObjKind.CF, new QualType(PointeeTy))))));
        break;
      } finally {
        $c$.$destroy();
      }
    }
   case RetainedOutParameter:
    // Do nothing. Retained out parameters will either point to a +1 reference
    // or NULL, but the way you check for failure differs depending on the API.
    // Consequently, we don't have a good way to track them yet.
    break;
   default:
    throw new llvm_unreachable("only for out parameters");
  }
  
  return new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, State);
}

} // END OF class RetainCountCheckerStatics
