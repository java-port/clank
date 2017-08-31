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

package org.clang.staticanalyzer.core.pathsensitive.ento;

import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.analysis.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstStatementsRTTI.*;

/// \brief Manages the lifetime of CallEvent objects.
///
/// CallEventManager provides a way to create arbitrary CallEvents "on the
/// stack" as if they were value objects by keeping a cache of CallEvent-sized
/// memory blocks. The CallEvents created by CallEventManager are only valid
/// for the lifetime of the OwnedCallEvent that holds them; right now these
/// objects cannot be copied and ownership cannot be transferred.
//<editor-fold defaultstate="collapsed" desc="clang::ento::CallEventManager">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 993,
 FQN="clang::ento::CallEventManager", NM="_ZN5clang4ento16CallEventManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN5clang4ento16CallEventManagerE")
//</editor-fold>
public class CallEventManager implements Destructors.ClassWithDestructor {
  /*friend  class CallEvent*/
  
  private final BumpPtrAllocatorImpl /*&*/ Alloc;
  private final SmallVector<Object/*void P*/> Cache;
  // JAVA: typedef SimpleFunctionCall CallEventTemplateTy
//  public final class CallEventTemplateTy extends SimpleFunctionCall{ };
  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CallEventManager::reclaim">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 1000,
   FQN="clang::ento::CallEventManager::reclaim", NM="_ZN5clang4ento16CallEventManager7reclaimEPKv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN5clang4ento16CallEventManager7reclaimEPKv")
  //</editor-fold>
  /*package*//*friend*//*private*/ void reclaim(/*const*/Object/*void P*/ Memory) {
    Cache.push_back(((/*const_cast*/Object/*void P*/ )(Memory)));
  }

  
  /// Returns memory that can be initialized as a CallEvent.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CallEventManager::allocate">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*Alloc*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 1005,
   FQN="clang::ento::CallEventManager::allocate", NM="_ZN5clang4ento16CallEventManager8allocateEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN5clang4ento16CallEventManager8allocateEv")
  //</editor-fold>
  /*package*//*friend*//*private*/<T> Object/*void P*/ allocate(Class<T> clazz) {
    // JAVA: MEMORY
    if (true) {
      // we can not reuse memory in Java like in C++, because objects could be of different 
      // java-types 
      return null;
    }
    if (Cache.empty()) {
      return Alloc.<T>Allocate$T(clazz);
    } else {
      return Cache.pop_back_val();
    }
  }

  
  /*template <typename T, typename Arg> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CallEventManager::create">
  @Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 1013,
   FQN="clang::ento::CallEventManager::create", NM="Tpl__ZN5clang4ento16CallEventManager6createET0_N4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS_15LocationContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=Tpl__ZN5clang4ento16CallEventManager6createET0_N4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS_15LocationContextE")
  //</editor-fold>
  private </*typename*/ T, /*typename*/ Arg> T /*P*/ create(Arg A, IntrusiveRefCntPtr</*const*/ ProgramState> St, /*const*/ LocationContext /*P*/ LCtx) {
//    static_assert($sizeof_T() == $sizeof_SimpleFunctionCall(), $("CallEvent subclasses are not all the same size"));
//    return ((/*JCast*/T /*P*/ )(/*FIXME: NEW_EXPR [NoNewFun]*/allocate() = /*new (allocate())*/ new T(( A, St, LCtx ))));
    throw new UnsupportedOperationException("Generate (and map) or use one of create* specializations");
  }

  
  /*template <typename T, typename Arg1, typename Arg2> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CallEventManager::create">
  @Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 1020,
   FQN="clang::ento::CallEventManager::create", NM="Tpl__ZN5clang4ento16CallEventManager6createET0_T1_N4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS_15LocationContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=Tpl__ZN5clang4ento16CallEventManager6createET0_T1_N4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS_15LocationContextE")
  //</editor-fold>
  private </*typename*/ T, /*typename*/ Arg1, /*typename*/ Arg2> T /*P*/ create(Arg1 A1, Arg2 A2, IntrusiveRefCntPtr</*const*/ ProgramState> St, /*const*/ LocationContext /*P*/ LCtx) {
//    static_assert($sizeof_T() == $sizeof_SimpleFunctionCall(), $("CallEvent subclasses are not all the same size"));
//    return ((/*JCast*/T /*P*/ )(/*FIXME: NEW_EXPR [NoNewFun]*/allocate() = /*new (allocate())*/ new T(( A1, A2, St, LCtx ))));
    throw new UnsupportedOperationException("Generate (and map) or use one of create* specializations");
  }
  
  
  /*template <typename T, typename Arg1, typename Arg2, typename Arg3> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CallEventManager::create">
  @Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 1027,
   FQN="clang::ento::CallEventManager::create", NM="Tpl__ZN5clang4ento16CallEventManager6createET0_T1_T2_N4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS_15LocationContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=Tpl__ZN5clang4ento16CallEventManager6createET0_T1_T2_N4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS_15LocationContextE")
  //</editor-fold>
  private </*typename*/ T, /*typename*/ Arg1, /*typename*/ Arg2, /*typename*/ Arg3> T /*P*/ create(Arg1 A1, Arg2 A2, Arg3 A3, IntrusiveRefCntPtr</*const*/ ProgramState> St, 
        /*const*/ LocationContext /*P*/ LCtx) {
//    static_assert($sizeof_T() == $sizeof_SimpleFunctionCall(), $("CallEvent subclasses are not all the same size"));
//    return ((/*JCast*/T /*P*/ )(/*FIXME: NEW_EXPR [NoNewFun]*/allocate() = /*new (allocate())*/ new T(( A1, A2, A3, St, LCtx ))));
    throw new UnsupportedOperationException("Generate (and map) or use one of create* specializations");
  }

  
  /*template <typename T, typename Arg1, typename Arg2, typename Arg3, typename Arg4> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CallEventManager::create">
  @Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 1036,
   FQN="clang::ento::CallEventManager::create", NM="Tpl__ZN5clang4ento16CallEventManager6createET0_T1_T2_T3_N4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS_15LocationContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=Tpl__ZN5clang4ento16CallEventManager6createET0_T1_T2_T3_N4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS_15LocationContextE")
  //</editor-fold>
  private </*typename*/ T, /*typename*/ Arg1, /*typename*/ Arg2, /*typename*/ Arg3, /*typename*/ Arg4> T /*P*/ create(Arg1 A1, Arg2 A2, Arg3 A3, Arg4 A4, IntrusiveRefCntPtr</*const*/ ProgramState> St, 
        /*const*/ LocationContext /*P*/ LCtx) {
//    static_assert($sizeof_T() == $sizeof_SimpleFunctionCall(), $("CallEvent subclasses are not all the same size"));
//    return ((/*JCast*/T /*P*/ )(/*FIXME: NEW_EXPR [NoNewFun]*/allocate() = /*new (allocate())*/ new T(( A1, A2, A3, A4, St, LCtx ))));
    throw new UnsupportedOperationException("Generate (and map) or use one of create* specializations");
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CallEventManager::CallEventManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 1044,
   FQN="clang::ento::CallEventManager::CallEventManager", NM="_ZN5clang4ento16CallEventManagerC1ERN4llvm20BumpPtrAllocatorImplINS2_15MallocAllocatorELj4096ELj4096EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN5clang4ento16CallEventManagerC1ERN4llvm20BumpPtrAllocatorImplINS2_15MallocAllocatorELj4096ELj4096EEE")
  //</editor-fold>
  public CallEventManager(final BumpPtrAllocatorImpl /*&*/ alloc) {
    // : Alloc(alloc), Cache() 
    //START JInit
    this./*&*/Alloc=/*&*/alloc;
    this.Cache = new SmallVector<Object/*void P*/>(8, null);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CallEventManager::getCaller">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp", line = 1057,
   FQN="clang::ento::CallEventManager::getCaller", NM="_ZN5clang4ento16CallEventManager9getCallerEPKNS_17StackFrameContextEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN5clang4ento16CallEventManager9getCallerEPKNS_17StackFrameContextEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEE")
  //</editor-fold>
  public CallEventRef<CallEvent> getCaller(/*const*/ StackFrameContext /*P*/ CalleeCtx, 
           IntrusiveRefCntPtr</*const*/ ProgramState> State) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      /*const*/ LocationContext /*P*/ ParentCtx = CalleeCtx.getParent();
      /*const*/ LocationContext /*P*/ CallerCtx = ParentCtx.getCurrentStackFrame();
      assert ((CallerCtx != null)) : "This should not be used for top-level stack frames";
      
      /*const*/ Stmt /*P*/ CallSite = CalleeCtx.getCallSite();
      if ((CallSite != null)) {
        {
          /*const*/ CallExpr /*P*/ CE = dyn_cast_CallExpr(CallSite);
          if ((CE != null)) {
            return $c$.clean(getSimpleCall(CE, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), CallerCtx));
          }
        }
        switch (CallSite.getStmtClass()) {
         case CXXConstructExprClass:
         case CXXTemporaryObjectExprClass:
          {
            final SValBuilder /*&*/ SVB = State.$arrow().getStateManager().getSValBuilder();
            /*const*/ CXXMethodDecl /*P*/ Ctor = cast_CXXMethodDecl(CalleeCtx.getDecl());
            Loc ThisPtr = new Loc(JD$Move.INSTANCE, SVB.getCXXThis(Ctor, CalleeCtx));
            SVal ThisVal = State.$arrow().getSVal(new Loc(ThisPtr));
            
            return $c$.clean($c$.track(getCXXConstructorCall(cast_CXXConstructExpr(CallSite),
                    ThisVal.getAsRegion(), $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), CallerCtx)).$CallEventRef$SuperT());
          }
         case CXXNewExprClass:
          return $c$.clean($c$.track(getCXXAllocatorCall(cast_CXXNewExpr(CallSite), $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), CallerCtx)).$CallEventRef$SuperT());
         case ObjCMessageExprClass:
          return $c$.clean($c$.track(getObjCMethodCall(cast_ObjCMessageExpr(CallSite), 
              $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), CallerCtx)).$CallEventRef$SuperT());
         default:
          throw new llvm_unreachable("This is not an inlineable statement.");
        }
      }
      
      // Fall back to the CFG. The only thing we haven't handled yet is
      // destructors, though this could change in the future.
      /*const*/ CFGBlock /*P*/ B = CalleeCtx.getCallSiteBlock();
      CFGElement E = ($Deref(B)).$at(CalleeCtx.getIndex());
      assert (E.getAs(CFGImplicitDtor.class).$bool()) : "All other CFG elements should have exprs";
      assert (!E.getAs(CFGTemporaryDtor.class).$bool()) : "We don't handle temporaries yet";
      
      final SValBuilder /*&*/ SVB = State.$arrow().getStateManager().getSValBuilder();
      /*const*/ CXXDestructorDecl /*P*/ Dtor = cast_CXXDestructorDecl(CalleeCtx.getDecl());
      Loc ThisPtr = new Loc(JD$Move.INSTANCE, SVB.getCXXThis(Dtor, CalleeCtx));
      SVal ThisVal = State.$arrow().getSVal(new Loc(ThisPtr));
      
      /*const*/ Stmt /*P*/ Trigger;
      {
        Optional<CFGAutomaticObjDtor> AutoDtor = E.getAs(CFGAutomaticObjDtor.class);
        if (AutoDtor.$bool()) {
          Trigger = AutoDtor.$arrow().getTriggerStmt();
        } else {
          Optional<CFGDeleteDtor> DeleteDtor = E.getAs(CFGDeleteDtor.class);
          if (DeleteDtor.$bool()) {
            Trigger = cast_Stmt(DeleteDtor.$arrow().getDeleteExpr());
          } else {
            Trigger = Dtor.getBody();
          }
        }
      }
      
      return $c$.clean($c$.track(getCXXDestructorCall(Dtor, Trigger, ThisVal.getAsRegion(), 
          E.getAs(CFGBaseDtor.class).hasValue(), $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), 
          CallerCtx)).$CallEventRef$SuperT());
    } finally {
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CallEventManager::getSimpleCall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp", line = 1035,
   FQN="clang::ento::CallEventManager::getSimpleCall", NM="_ZN5clang4ento16CallEventManager13getSimpleCallEPKNS_8CallExprEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS_15LocationContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN5clang4ento16CallEventManager13getSimpleCallEPKNS_8CallExprEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS_15LocationContextE")
  //</editor-fold>
  public CallEventRef<CallEvent> getSimpleCall(/*const*/ CallExpr /*P*/ CE, IntrusiveRefCntPtr</*const*/ ProgramState> State, 
               /*const*/ LocationContext /*P*/ LCtx) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      {
        /*const*/ CXXMemberCallExpr /*P*/ MCE = dyn_cast_CXXMemberCallExpr(CE);
        if ((MCE != null)) {
          return $c$.clean(new CallEventRef<CallEvent>(this.<CXXMemberCall, /*const*/ CXXMemberCallExpr /*P*/ >createCXXMemberCall(MCE, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), LCtx)));
        }
      }
      {
        
        /*const*/ CXXOperatorCallExpr /*P*/ OpCE = dyn_cast_CXXOperatorCallExpr(CE);
        if ((OpCE != null)) {
          /*const*/ FunctionDecl /*P*/ DirectCallee = OpCE.getDirectCallee$Const();
          {
            /*const*/ CXXMethodDecl /*P*/ MD = dyn_cast_CXXMethodDecl(DirectCallee);
            if ((MD != null)) {
              if (MD.isInstance()) {
                return $c$.clean(new CallEventRef<CallEvent>(this.<CXXMemberOperatorCall, /*const*/ CXXOperatorCallExpr /*P*/ >createCXXMemberOperatorCall(OpCE, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), LCtx)));
              }
            }
          }
        } else if (CE.getCallee$Const().getType().$arrow().isBlockPointerType()) {
          return $c$.clean(new CallEventRef<CallEvent>(this.<BlockCall, /*const*/ CallExpr /*P*/ >createBlockCall(CE, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), LCtx)));
        }
      }
      
      // Otherwise, it's a normal function call, static member function call, or
      // something we can't reason about.
      return $c$.clean(new CallEventRef<CallEvent>(this.<SimpleFunctionCall, /*const*/ CallExpr /*P*/ >createSimpleFunctionCall(CE, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), LCtx)));
    } finally {
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CallEventManager::getObjCMethodCall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 1055,
   FQN="clang::ento::CallEventManager::getObjCMethodCall", NM="_ZN5clang4ento16CallEventManager17getObjCMethodCallEPKNS_15ObjCMessageExprEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS_15LocationContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN5clang4ento16CallEventManager17getObjCMethodCallEPKNS_15ObjCMessageExprEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS_15LocationContextE")
  //</editor-fold>
  public CallEventRef<ObjCMethodCall> getObjCMethodCall(/*const*/ ObjCMessageExpr /*P*/ E, IntrusiveRefCntPtr</*const*/ ProgramState> State, 
                   /*const*/ LocationContext /*P*/ LCtx) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      return $c$.clean(new CallEventRef<ObjCMethodCall>(this.<ObjCMethodCall, /*const*/ ObjCMessageExpr /*P*/ >createObjCMethodCall(E, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), LCtx)));
    } finally {
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CallEventManager::getCXXConstructorCall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 1061,
   FQN="clang::ento::CallEventManager::getCXXConstructorCall", NM="_ZN5clang4ento16CallEventManager21getCXXConstructorCallEPKNS_16CXXConstructExprEPKNS0_9MemRegionEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS_15LocationContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN5clang4ento16CallEventManager21getCXXConstructorCallEPKNS_16CXXConstructExprEPKNS0_9MemRegionEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS_15LocationContextE")
  //</editor-fold>
  public CallEventRef<CXXConstructorCall> getCXXConstructorCall(/*const*/ CXXConstructExpr /*P*/ E, /*const*/ MemRegion /*P*/ Target, 
                       IntrusiveRefCntPtr</*const*/ ProgramState> State, /*const*/ LocationContext /*P*/ LCtx) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      return $c$.clean(new CallEventRef<CXXConstructorCall>(this.<CXXConstructorCall, /*const*/ CXXConstructExpr /*P*/ , /*const*/ MemRegion /*P*/ >createCXXConstructorCall(E, Target, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), LCtx)));
    } finally {
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CallEventManager::getCXXDestructorCall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 1067,
   FQN="clang::ento::CallEventManager::getCXXDestructorCall", NM="_ZN5clang4ento16CallEventManager20getCXXDestructorCallEPKNS_17CXXDestructorDeclEPKNS_4StmtEPKNS0_9MemRegionEbN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS_15LocationContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN5clang4ento16CallEventManager20getCXXDestructorCallEPKNS_17CXXDestructorDeclEPKNS_4StmtEPKNS0_9MemRegionEbN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS_15LocationContextE")
  //</editor-fold>
  public CallEventRef<CXXDestructorCall> getCXXDestructorCall(/*const*/ CXXDestructorDecl /*P*/ DD, /*const*/ Stmt /*P*/ Trigger, 
                      /*const*/ MemRegion /*P*/ Target, boolean IsBase, 
                      IntrusiveRefCntPtr</*const*/ ProgramState> State, /*const*/ LocationContext /*P*/ LCtx) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      return $c$.clean(new CallEventRef<CXXDestructorCall>(this.<CXXDestructorCall, /*const*/ CXXDestructorDecl /*P*/ , /*const*/ Stmt /*P*/ , /*const*/ MemRegion /*P*/ >createCXXDestructorCall(DD, Trigger, Target, IsBase, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), LCtx)));
    } finally {
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CallEventManager::getCXXAllocatorCall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 1074,
   FQN="clang::ento::CallEventManager::getCXXAllocatorCall", NM="_ZN5clang4ento16CallEventManager19getCXXAllocatorCallEPKNS_10CXXNewExprEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS_15LocationContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN5clang4ento16CallEventManager19getCXXAllocatorCallEPKNS_10CXXNewExprEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS_15LocationContextE")
  //</editor-fold>
  public CallEventRef<CXXAllocatorCall> getCXXAllocatorCall(/*const*/ CXXNewExpr /*P*/ E, IntrusiveRefCntPtr</*const*/ ProgramState> State, 
                     /*const*/ LocationContext /*P*/ LCtx) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      return $c$.clean(new CallEventRef<CXXAllocatorCall>(this.<CXXAllocatorCall, /*const*/ CXXNewExpr /*P*/ >createCXXAllocatorCall(E, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), LCtx)));
    } finally {
      $c$.$destroy();
    }
  }


  //<editor-fold defaultstate="collapsed" desc="clang::ento::CallEventManager::~CallEventManager">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 993,
   FQN="clang::ento::CallEventManager::~CallEventManager", NM="_ZN5clang4ento16CallEventManagerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ProgramState.cpp -nm=_ZN5clang4ento16CallEventManagerD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    Cache.$destroy();
    //END JDestroy
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN
  
  @Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 1013,
   FQN="clang::ento::CallEventManager::create", NM="_ZN5clang4ento16CallEventManager6createINS0_14ObjCMethodCallEPKNS_15ObjCMessageExprEEEPT_T0_N4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS_15LocationContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN5clang4ento16CallEventManager6createINS0_14ObjCMethodCallEPKNS_15ObjCMessageExprEEEPT_T0_N4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS_15LocationContextE")
  //</editor-fold>
  private ObjCMethodCall /*P*/ createObjCMethodCall(/*const*/ ObjCMessageExpr /*P*/ A, IntrusiveRefCntPtr</*const*/ ProgramState> St, /*const*/ LocationContext /*P*/ LCtx) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      //static_assert($sizeof_ObjCMethodCall() == $sizeof_SimpleFunctionCall(), $("CallEvent subclasses are not all the same size"));
      return $c$.clean(/*NEW_EXPR [System] allocate() = new (allocate())*/ $new_uint_voidPtr(allocate(ObjCMethodCall.class), (type$ptr<?> New$Mem)->{
          return new ObjCMethodCall(A, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(St)), LCtx);
       }));
    } finally {
      $c$.$destroy();
    }
  }
  @Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 1013,
   FQN="clang::ento::CallEventManager::create", NM="_ZN5clang4ento16CallEventManager6createINS0_16CXXAllocatorCallEPKNS_10CXXNewExprEEEPT_T0_N4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS_15LocationContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN5clang4ento16CallEventManager6createINS0_16CXXAllocatorCallEPKNS_10CXXNewExprEEEPT_T0_N4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS_15LocationContextE")
  //</editor-fold>
  private CXXAllocatorCall /*P*/ createCXXAllocatorCall(/*const*/ CXXNewExpr /*P*/ A, IntrusiveRefCntPtr</*const*/ ProgramState> St, /*const*/ LocationContext /*P*/ LCtx) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      //static_assert($sizeof_CXXAllocatorCall() == $sizeof_SimpleFunctionCall(), $("CallEvent subclasses are not all the same size"));
      return $c$.clean(/*NEW_EXPR [System] allocate() = new (allocate())*/ $new_uint_voidPtr(allocate(CXXAllocatorCall.class), (type$ptr<?> New$Mem)->{
          return new CXXAllocatorCall(A, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(St)), LCtx);
       }));
    } finally {
      $c$.$destroy();
    }
  }
  @Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 1013,
   FQN="clang::ento::CallEventManager::create", NM="_ZN5clang4ento16CallEventManager6createINS0_13CXXMemberCallEPKNS_17CXXMemberCallExprEEEPT_T0_N4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS_15LocationContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN5clang4ento16CallEventManager6createINS0_13CXXMemberCallEPKNS_17CXXMemberCallExprEEEPT_T0_N4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS_15LocationContextE")
  //</editor-fold>
  private CXXMemberCall /*P*/ createCXXMemberCall(/*const*/ CXXMemberCallExpr /*P*/ A, IntrusiveRefCntPtr</*const*/ ProgramState> St, /*const*/ LocationContext /*P*/ LCtx) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      //static_assert($sizeof_CXXMemberCall() == $sizeof_SimpleFunctionCall(), $("CallEvent subclasses are not all the same size"));
      return $c$.clean(/*NEW_EXPR [System] allocate() = new (allocate())*/ $new_uint_voidPtr(allocate(CXXMemberCall.class), (type$ptr<?> New$Mem)->{
          return new CXXMemberCall(A, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(St)), LCtx);
       }));
    } finally {
      $c$.$destroy();
    }
  }
  @Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 1013,
   FQN="clang::ento::CallEventManager::create", NM="_ZN5clang4ento16CallEventManager6createINS0_21CXXMemberOperatorCallEPKNS_19CXXOperatorCallExprEEEPT_T0_N4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS_15LocationContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN5clang4ento16CallEventManager6createINS0_21CXXMemberOperatorCallEPKNS_19CXXOperatorCallExprEEEPT_T0_N4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS_15LocationContextE")
  //</editor-fold>
  private CXXMemberOperatorCall /*P*/ createCXXMemberOperatorCall(/*const*/ CXXOperatorCallExpr /*P*/ A, IntrusiveRefCntPtr</*const*/ ProgramState> St, /*const*/ LocationContext /*P*/ LCtx) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      //static_assert($sizeof_CXXMemberOperatorCall() == $sizeof_SimpleFunctionCall(), $("CallEvent subclasses are not all the same size"));
      return $c$.clean(/*NEW_EXPR [System] allocate() = new (allocate())*/ $new_uint_voidPtr(allocate(CXXMemberOperatorCall.class), (type$ptr<?> New$Mem)->{
          return new CXXMemberOperatorCall(A, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(St)), LCtx);
       }));
    } finally {
      $c$.$destroy();
    }
  }
  @Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 1013,
   FQN="clang::ento::CallEventManager::create", NM="_ZN5clang4ento16CallEventManager6createINS0_9BlockCallEPKNS_8CallExprEEEPT_T0_N4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS_15LocationContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN5clang4ento16CallEventManager6createINS0_9BlockCallEPKNS_8CallExprEEEPT_T0_N4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS_15LocationContextE")
  //</editor-fold>
  private BlockCall /*P*/ createBlockCall(/*const*/ CallExpr /*P*/ A, IntrusiveRefCntPtr</*const*/ ProgramState> St, /*const*/ LocationContext /*P*/ LCtx) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      //static_assert($sizeof_BlockCall() == $sizeof_SimpleFunctionCall(), $("CallEvent subclasses are not all the same size"));
      return $c$.clean(/*NEW_EXPR [System] allocate() = new (allocate())*/ $new_uint_voidPtr(allocate(BlockCall.class), (type$ptr<?> New$Mem)->{
          return new BlockCall(A, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(St)), LCtx);
       }));
    } finally {
      $c$.$destroy();
    }
  }
  @Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 1013,
   FQN="clang::ento::CallEventManager::create", NM="_ZN5clang4ento16CallEventManager6createINS0_18SimpleFunctionCallEPKNS_8CallExprEEEPT_T0_N4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS_15LocationContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN5clang4ento16CallEventManager6createINS0_18SimpleFunctionCallEPKNS_8CallExprEEEPT_T0_N4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS_15LocationContextE")
  //</editor-fold>
  private SimpleFunctionCall /*P*/ createSimpleFunctionCall(/*const*/ CallExpr /*P*/ A, IntrusiveRefCntPtr</*const*/ ProgramState> St, /*const*/ LocationContext /*P*/ LCtx) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      //static_assert($sizeof_SimpleFunctionCall() == $sizeof_SimpleFunctionCall(), $("CallEvent subclasses are not all the same size"));
      return $c$.clean(/*NEW_EXPR [System] allocate() = new (allocate())*/ $new_uint_voidPtr(allocate(SimpleFunctionCall.class), (type$ptr<?> New$Mem)->{
          return new SimpleFunctionCall(A, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(St)), LCtx);
       }));
    } finally {
      $c$.$destroy();
    }
  }
  
  //////
  @Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 1020,
   FQN="clang::ento::CallEventManager::create", NM="_ZN5clang4ento16CallEventManager6createINS0_18CXXConstructorCallEPKNS_16CXXConstructExprEPKNS0_9MemRegionEEEPT_T0_T1_N4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS_15LocationContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN5clang4ento16CallEventManager6createINS0_18CXXConstructorCallEPKNS_16CXXConstructExprEPKNS0_9MemRegionEEEPT_T0_T1_N4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS_15LocationContextE")
  //</editor-fold>
  private CXXConstructorCall /*P*/ createCXXConstructorCall(/*const*/ CXXConstructExpr /*P*/ A1, /*const*/ MemRegion /*P*/ A2, IntrusiveRefCntPtr</*const*/ ProgramState> St, /*const*/ LocationContext /*P*/ LCtx) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      //static_assert($sizeof_CXXConstructorCall() == $sizeof_SimpleFunctionCall(), $("CallEvent subclasses are not all the same size"));
      return $c$.clean(/*NEW_EXPR [System]allocate() = new (allocate())*/ $new_uint_voidPtr(allocate(CXXConstructorCall.class), (type$ptr<?> New$Mem)->{
          return new CXXConstructorCall(A1, A2, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(St)), LCtx);
       }));
    } finally {
      $c$.$destroy();
    }
  }
  
  ////////
  @Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 1036,
   FQN="clang::ento::CallEventManager::create", NM="_ZN5clang4ento16CallEventManager6createINS0_17CXXDestructorCallEPKNS_17CXXDestructorDeclEPKNS_4StmtEPKNS0_9MemRegionEbEEPT_T0_T1_T2_T3_N4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS_15LocationContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN5clang4ento16CallEventManager6createINS0_17CXXDestructorCallEPKNS_17CXXDestructorDeclEPKNS_4StmtEPKNS0_9MemRegionEbEEPT_T0_T1_T2_T3_N4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS_15LocationContextE")
  //</editor-fold>
  private CXXDestructorCall /*P*/ createCXXDestructorCall(/*const*/ CXXDestructorDecl /*P*/ A1, /*const*/ Stmt /*P*/ A2, /*const*/ MemRegion /*P*/ A3, boolean A4, IntrusiveRefCntPtr</*const*/ ProgramState> St, 
        /*const*/ LocationContext /*P*/ LCtx) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      //static_assert($sizeof_CXXDestructorCall() == $sizeof_SimpleFunctionCall(), $("CallEvent subclasses are not all the same size"));
      return $c$.clean(/*NEW_EXPR [System]allocate() = new (allocate())*/ $new_uint_voidPtr(allocate(CXXDestructorCall.class), (type$ptr<?> New$Mem)->{
          return new CXXDestructorCall(A1, A2, A3, A4, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(St)), LCtx);
       }));
    } finally {
      $c$.$destroy();
    }
  }  
  
  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Alloc=" + "[BumpPtrAllocatorImpl]" // NOI18N
              + ", Cache=" + Cache; // NOI18N
  }
}
