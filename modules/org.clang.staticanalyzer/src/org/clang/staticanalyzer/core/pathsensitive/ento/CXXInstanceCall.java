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

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.NativePointer.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.analysis.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import org.clang.staticanalyzer.checkers.ento.EntoGlobals;
import static org.clank.support.Native.$Clone;
import static org.clank.support.Native.$createJavaCleaner;


/// \brief Represents a non-static C++ member function call, no matter how
/// it is written.
//<editor-fold defaultstate="collapsed" desc="clang::ento::CXXInstanceCall">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 610,
 FQN="clang::ento::CXXInstanceCall", NM="_ZN5clang4ento15CXXInstanceCallE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN5clang4ento15CXXInstanceCallE")
//</editor-fold>
public abstract class CXXInstanceCall extends /*public*/ AnyFunctionCall implements Destructors.ClassWithDestructor {
/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CXXInstanceCall::getExtraInvalidatedValues">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp", line = 433,
   FQN="clang::ento::CXXInstanceCall::getExtraInvalidatedValues", NM="_ZNK5clang4ento15CXXInstanceCall25getExtraInvalidatedValuesERN4llvm15SmallVectorImplINS0_4SValEEEPNS0_33RegionAndSymbolInvalidationTraitsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK5clang4ento15CXXInstanceCall25getExtraInvalidatedValuesERN4llvm15SmallVectorImplINS0_4SValEEEPNS0_33RegionAndSymbolInvalidationTraitsE")
  //</editor-fold>
  @Override protected void getExtraInvalidatedValues(final SmallVectorImpl<SVal> /*&*/ Values, RegionAndSymbolInvalidationTraits /*P*/ ETraits) /*const*//* override*/ {
    SVal ThisVal = getCXXThisVal();
    Values.push_back(ThisVal);
    {
      
      // Don't invalidate if the method is const and there are no mutable fields.
      /*const*/ CXXMethodDecl /*P*/ D = cast_or_null_CXXMethodDecl(getDecl());
      if ((D != null)) {
        if (!D.isConst()) {
          return;
        }
        // Get the record decl for the class of 'This'. D->getParent() may return a
        // base class decl, rather than the class of the instance which needs to be
        // checked for mutable fields.
        /*const*/ Expr /*P*/ Ex = getCXXThisExpr().ignoreParenBaseCasts$Const();
        /*const*/ CXXRecordDecl /*P*/ ParentRecord = Ex.getType().$arrow().getAsCXXRecordDecl();
        if (!(ParentRecord != null) || ParentRecord.hasMutableFields()) {
          return;
        }
        // Preserve CXXThis.
        /*const*/ MemRegion /*P*/ ThisRegion = ThisVal.getAsRegion();
        if (!(ThisRegion != null)) {
          return;
        }
        
        ETraits.setTrait(ThisRegion.getBaseRegion(), 
            RegionAndSymbolInvalidationTraits.InvalidationKinds.TK_PreserveContents);
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CXXInstanceCall::CXXInstanceCall">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*cleaner*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 615,
   FQN="clang::ento::CXXInstanceCall::CXXInstanceCall", NM="_ZN5clang4ento15CXXInstanceCallC1EPKNS_8CallExprEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS_15LocationContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN5clang4ento15CXXInstanceCallC1EPKNS_8CallExprEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS_15LocationContextE")
  //</editor-fold>
  /*use ctr with cleaner*/private/*protected*/ CXXInstanceCall(/*const*/ CallExpr /*P*/ CE, IntrusiveRefCntPtr</*const*/ ProgramState> St, 
      /*const*/ LocationContext /*P*/ LCtx) {
    // : AnyFunctionCall(CE, $c$.track(St), LCtx) 
    //START JInit
    /*ExprWithCleanups*/super(CE, /*$c$.track(*/new IntrusiveRefCntPtr</*const*/ ProgramState>(St)/*)*/, LCtx, JD$Clean.TRAILING);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::CXXInstanceCall::CXXInstanceCall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 618,
   FQN="clang::ento::CXXInstanceCall::CXXInstanceCall", NM="_ZN5clang4ento15CXXInstanceCallC1EPKNS_12FunctionDeclEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS_15LocationContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN5clang4ento15CXXInstanceCallC1EPKNS_12FunctionDeclEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS_15LocationContextE")
  //</editor-fold>
  /*use ctr with cleaner*/private/*protected*/ CXXInstanceCall(/*const*/ FunctionDecl /*P*/ D, IntrusiveRefCntPtr</*const*/ ProgramState> St, 
      /*const*/ LocationContext /*P*/ LCtx) {
    // : AnyFunctionCall(D, $c$.track(St), LCtx) 
    //START JInit
    /*ExprWithCleanups*/super(D, /*$c$.track(*/new IntrusiveRefCntPtr</*const*/ ProgramState>(St)/*)*/, LCtx, JD$Clean.TRAILING);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CXXInstanceCall::CXXInstanceCall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 623,
   FQN="clang::ento::CXXInstanceCall::CXXInstanceCall", NM="_ZN5clang4ento15CXXInstanceCallC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN5clang4ento15CXXInstanceCallC1ERKS1_")
  //</editor-fold>
  protected CXXInstanceCall(final /*const*/ CXXInstanceCall /*&*/ Other) {
    // : AnyFunctionCall(Other) 
    //START JInit
    super(Other);
    //END JInit
  }

/*public:*/
  /// \brief Returns the expression representing the implicit 'this' object.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CXXInstanceCall::getCXXThisExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 627,
   FQN="clang::ento::CXXInstanceCall::getCXXThisExpr", NM="_ZNK5clang4ento15CXXInstanceCall14getCXXThisExprEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK5clang4ento15CXXInstanceCall14getCXXThisExprEv")
  //</editor-fold>
  public /*virtual*/ /*const*/ Expr /*P*/ getCXXThisExpr() /*const*/ {
    return null;
  }

  
  /// \brief Returns the value of the implicit 'this' object.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CXXInstanceCall::getCXXThisVal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp", line = 459,
   FQN="clang::ento::CXXInstanceCall::getCXXThisVal", NM="_ZNK5clang4ento15CXXInstanceCall13getCXXThisValEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK5clang4ento15CXXInstanceCall13getCXXThisValEv")
  //</editor-fold>
  public SVal getCXXThisVal() /*const*/ {
    /*const*/ Expr /*P*/ Base = getCXXThisExpr();
    // FIXME: This doesn't handle an overloaded ->* operator.
    if (!(Base != null)) {
      return new SVal(JD$Move.INSTANCE, new UnknownVal());
    }
    
    SVal ThisVal = getSVal(Base);
    assert (ThisVal.isUnknownOrUndef$SVal() || ThisVal.getAs(Loc.class).$bool());
    return ThisVal;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CXXInstanceCall::getDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp", line = 421,
   FQN="clang::ento::CXXInstanceCall::getDecl", NM="_ZNK5clang4ento15CXXInstanceCall7getDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK5clang4ento15CXXInstanceCall7getDeclEv")
  //</editor-fold>
  @Override public /*const*/ FunctionDecl /*P*/ getDecl() /*const*//* override*/ {
    /*const*/ CallExpr /*P*/ CE = cast_or_null_CallExpr(getOriginExpr());
    if (!(CE != null)) {
      return super.getDecl();
    }
    
    /*const*/ FunctionDecl /*P*/ D = CE.getDirectCallee$Const();
    if ((D != null)) {
      return D;
    }
    
    return getSVal(CE.getCallee$Const()).getAsFunctionDecl();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CXXInstanceCall::getRuntimeDefinition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp", line = 471,
   FQN="clang::ento::CXXInstanceCall::getRuntimeDefinition", NM="_ZNK5clang4ento15CXXInstanceCall20getRuntimeDefinitionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK5clang4ento15CXXInstanceCall20getRuntimeDefinitionEv")
  //</editor-fold>
  @Override public RuntimeDefinition getRuntimeDefinition() /*const*//* override*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {  
      // Do we have a decl at all?
      /*const*/ Decl /*P*/ D = getDecl();
      if (!(D != null)) {
        return new RuntimeDefinition();
      }

      // If the method is non-virtual, we know we can inline it.
      /*const*/ CXXMethodDecl /*P*/ MD = cast_CXXMethodDecl(D);
      if (!MD.isVirtual()) {
        return super.getRuntimeDefinition();
      }

      // Do we know the implicit 'this' object being called?
      /*const*/ MemRegion /*P*/ R = getCXXThisVal().getAsRegion();
      if (!(R != null)) {
        return new RuntimeDefinition();
      }

      // Do we know anything about the type of 'this'?
      DynamicTypeInfo DynType = $c$.clean(EntoGlobals.getDynamicTypeInfo($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(getState())), R));
      if (!DynType.isValid()) {
        return new RuntimeDefinition();
      }

      // Is the type a C++ class? (This is mostly a defensive check.)
      QualType RegionType = DynType.getType().$arrow().getPointeeType();
      assert (!RegionType.isNull()) : "DynamicTypeInfo should always be a pointer.";

      /*const*/ CXXRecordDecl /*P*/ RD = RegionType.$arrow().getAsCXXRecordDecl();
      if (!(RD != null) || !RD.hasDefinition()) {
        return new RuntimeDefinition();
      }

      // Find the decl for this method in that class.
      /*const*/ CXXMethodDecl /*P*/ Result = MD.getCorrespondingMethodInClass$Const(RD, true);
      if (!(Result != null)) {
        // We might not even get the original statically-resolved method due to
        // some particularly nasty casting (e.g. casts to sister classes).
        // However, we should at least be able to search up and down our own class
        // hierarchy, and some real bugs have been caught by checking this.
        assert (!RD.isDerivedFrom(MD.getParent$Const())) : "Couldn't find known method";

        // FIXME: This is checking that our DynamicTypeInfo is at least as good as
        // the static type. However, because we currently don't update
        // DynamicTypeInfo when an object is cast, we can't actually be sure the
        // DynamicTypeInfo is up to date. This assert should be re-enabled once
        // this is fixed. <rdar://problem/12287087>
        //assert(!MD->getParent()->isDerivedFrom(RD) && "Bad DynamicTypeInfo");
        return new RuntimeDefinition();
      }

      // Does the decl that we found have an implementation?
      type$ref</*const*/ FunctionDecl /*P*/ > Definition = create_type$ref();
      if (!Result.hasBody(Definition)) {
        return new RuntimeDefinition();
      }

      // We found a definition. If we're not sure that this devirtualization is
      // actually what will happen at runtime, make sure to provide the region so
      // that ExprEngine can decide what to do with it.
      if (DynType.canBeASubClass()) {
        return new RuntimeDefinition(Definition.$deref(), R.StripCasts());
      }
      return new RuntimeDefinition(Definition.$deref(), /*DispatchRegion=*/ (/*const*/ MemRegion /*P*/ )null);
    } finally {
     $c$.$destroy();
    } 
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CXXInstanceCall::getInitialStackFrameContents">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp", line = 532,
   FQN="clang::ento::CXXInstanceCall::getInitialStackFrameContents", NM="_ZNK5clang4ento15CXXInstanceCall28getInitialStackFrameContentsEPKNS_17StackFrameContextERN4llvm15SmallVectorImplISt4pairINS0_3LocENS0_4SValEEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK5clang4ento15CXXInstanceCall28getInitialStackFrameContentsEPKNS_17StackFrameContextERN4llvm15SmallVectorImplISt4pairINS0_3LocENS0_4SValEEEE")
  //</editor-fold>
  @Override public void getInitialStackFrameContents(/*const*/ StackFrameContext /*P*/ CalleeCtx, 
                              final SmallVectorImpl<std.pairTypeType<Loc, SVal> > /*&*/ Bindings) /*const*//* override*/ {
    super.getInitialStackFrameContents(CalleeCtx, Bindings);
    
    // Handle the binding of 'this' in the new stack frame.
    SVal ThisVal = getCXXThisVal();
    if (!ThisVal.isUnknown$SVal()) {
      final ProgramStateManager /*&*/ StateMgr = getState().$arrow().getStateManager();
      final SValBuilder /*&*/ SVB = StateMgr.getSValBuilder();
      
      /*const*/ CXXMethodDecl /*P*/ MD = cast_CXXMethodDecl(CalleeCtx.getDecl());
      Loc ThisLoc = new Loc(JD$Move.INSTANCE, SVB.getCXXThis(MD, CalleeCtx));
      
      // If we devirtualized to a different member function, we need to make sure
      // we have the proper layering of CXXBaseObjectRegions.
      if (MD.getCanonicalDecl$Const() != getDecl().getCanonicalDecl$Const()) {
        final ASTContext /*&*/ Ctx = SVB.getContext();
        /*const*/ CXXRecordDecl /*P*/ Class = MD.getParent$Const();
        QualType Ty = Ctx.getPointerType(Ctx.getRecordType(Class));
        
        // FIXME: CallEvent maybe shouldn't be directly accessing StoreManager.
        bool$ref Failed = create_bool$ref();
        ThisVal.$assignMove(StateMgr.getStoreManager().evalDynamicCast(new SVal(ThisVal), new QualType(Ty), Failed));
        assert (!Failed.$deref()) : "Calling an incorrectly devirtualized method";
      }
      if (!ThisVal.isUnknown$SVal()) {
        Bindings.push_back(std.make_pair($Clone(ThisLoc), $Clone(ThisVal)));
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CXXInstanceCall::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 639,
   FQN="clang::ento::CXXInstanceCall::classof", NM="_ZN5clang4ento15CXXInstanceCall7classofEPKNS0_9CallEventE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN5clang4ento15CXXInstanceCall7classofEPKNS0_9CallEventE")
  //</editor-fold>
  public static boolean classof(/*const*/ CallEvent /*P*/ CA) {
    return CA.getKind().getValue() >= CallEventKind.CE_BEG_CXX_INSTANCE_CALLS.getValue()
       && CA.getKind().getValue() <= CallEventKind.CE_END_CXX_INSTANCE_CALLS.getValue();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::CXXInstanceCall::~CXXInstanceCall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 610,
   FQN="clang::ento::CXXInstanceCall::~CXXInstanceCall", NM="_ZN5clang4ento15CXXInstanceCallD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN5clang4ento15CXXInstanceCallD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  protected CXXInstanceCall(/*const*/ CallExpr /*P*/ CE, IntrusiveRefCntPtr</*const*/ ProgramState> St, 
    /*const*/ LocationContext /*P*/ LCtx, JD$Clean _dparm) {
    this(CE, St, LCtx);
    // do cleanup
    if (_dparm != null) St.$destroy();
  }
  
  protected CXXInstanceCall(/*const*/ FunctionDecl /*P*/ D, IntrusiveRefCntPtr</*const*/ ProgramState> St, 
      /*const*/ LocationContext /*P*/ LCtx, JD$Clean _dparm) {
    this(D, St, LCtx);
    // do cleanup
    if (_dparm != null) St.$destroy();
  } 
  

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
