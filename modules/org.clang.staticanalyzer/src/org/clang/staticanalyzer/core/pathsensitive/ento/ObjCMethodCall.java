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
import static org.llvm.support.llvm.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.analysis.*;
import org.clang.basic.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstTypesRTTI.*;
import org.clang.staticanalyzer.checkers.ento.EntoGlobals;
import org.clang.staticanalyzer.core.impl.CallEventStatics;
import static org.clang.staticanalyzer.core.impl.CallEventStatics.addParameterValuesToBindings;


/// \brief Represents any expression that calls an Objective-C method.
///
/// This includes all of the kinds listed in ObjCMessageKind.
//<editor-fold defaultstate="collapsed" desc="clang::ento::ObjCMethodCall">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 881,
 FQN="clang::ento::ObjCMethodCall", NM="_ZN5clang4ento14ObjCMethodCallE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN5clang4ento14ObjCMethodCallE")
//</editor-fold>
public class ObjCMethodCall extends /*public*/ CallEvent implements Destructors.ClassWithDestructor {
  /*friend  class CallEventManager*/
  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ObjCMethodCall::getContainingPseudoObjectExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp", line = 754,
   FQN="clang::ento::ObjCMethodCall::getContainingPseudoObjectExpr", NM="_ZNK5clang4ento14ObjCMethodCall29getContainingPseudoObjectExprEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK5clang4ento14ObjCMethodCall29getContainingPseudoObjectExprEv")
  //</editor-fold>
  private /*const*/ PseudoObjectExpr /*P*/ getContainingPseudoObjectExpr() /*const*/ {
    assert ((Data != null)) : "Lazy lookup not yet performed.";
    assert (getMessageKind() != ObjCMessageKind.OCM_Message) : "Explicit message send.";
    return PointerIntPair.</*const*/ PseudoObjectExpr /*P*/ >getFromOpaqueValue_ConstVoidPtr(Data).getPointer();
  }

/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ObjCMethodCall::ObjCMethodCall">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*cleaner*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 887,
   FQN="clang::ento::ObjCMethodCall::ObjCMethodCall", NM="_ZN5clang4ento14ObjCMethodCallC1EPKNS_15ObjCMessageExprEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS_15LocationContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN5clang4ento14ObjCMethodCallC1EPKNS_15ObjCMessageExprEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS_15LocationContextE")
  //</editor-fold>
  protected ObjCMethodCall(/*const*/ ObjCMessageExpr /*P*/ Msg, IntrusiveRefCntPtr</*const*/ ProgramState> St, 
      /*const*/ LocationContext /*P*/ LCtx) {
    // : CallEvent(Msg, $c$.track(St), LCtx) 
    //START JInit
    /*ExprWithCleanups*/super(Msg, /*$c$.track(*/new IntrusiveRefCntPtr</*const*/ ProgramState>(St)/*)*/, LCtx, JD$Clean.TRAILING);
    //END JInit
    Data = null;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ObjCMethodCall::ObjCMethodCall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 893,
   FQN="clang::ento::ObjCMethodCall::ObjCMethodCall", NM="_ZN5clang4ento14ObjCMethodCallC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN5clang4ento14ObjCMethodCallC1ERKS1_")
  //</editor-fold>
  protected ObjCMethodCall(final /*const*/ ObjCMethodCall /*&*/ Other) {
    // : CallEvent(Other) 
    //START JInit
    super(Other);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::ObjCMethodCall::cloneTo">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 894,
   FQN="clang::ento::ObjCMethodCall::cloneTo", NM="_ZNK5clang4ento14ObjCMethodCall7cloneToEPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK5clang4ento14ObjCMethodCall7cloneToEPv")
  //</editor-fold>
  @Override protected void cloneTo(Object/*void P*/ Dest) /*const*//* override*/ {
    assert false : "must use clone instead";
    /*NEW_EXPR [System]*/Dest = /*new (Dest)*/ $new_uint_voidPtr(Dest, (type$ptr<?> New$Mem)->{
        return new ObjCMethodCall(/*Deref*/this);
     });
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ObjCMethodCall::getExtraInvalidatedValues">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp", line = 681,
   FQN="clang::ento::ObjCMethodCall::getExtraInvalidatedValues", NM="_ZNK5clang4ento14ObjCMethodCall25getExtraInvalidatedValuesERN4llvm15SmallVectorImplINS0_4SValEEEPNS0_33RegionAndSymbolInvalidationTraitsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK5clang4ento14ObjCMethodCall25getExtraInvalidatedValuesERN4llvm15SmallVectorImplINS0_4SValEEEPNS0_33RegionAndSymbolInvalidationTraitsE")
  //</editor-fold>
  @Override protected void getExtraInvalidatedValues(final SmallVectorImpl<SVal> /*&*/ Values, RegionAndSymbolInvalidationTraits /*P*/ ETraits) /*const*//* override*/ {
    {
      
      // If the method call is a setter for property known to be backed by
      // an instance variable, don't invalidate the entire receiver, just
      // the storage for that instance variable.
      /*const*/ ObjCPropertyDecl /*P*/ PropDecl = getAccessedProperty();
      if ((PropDecl != null)) {
        {
          /*const*/ ObjCIvarDecl /*P*/ PropIvar = PropDecl.getPropertyIvarDecl();
          if ((PropIvar != null)) {
            SVal IvarLVal = getState().$arrow().getLValue(PropIvar, getReceiverSVal());
            /*const*/ MemRegion /*P*/ IvarRegion = IvarLVal.getAsRegion();
            ETraits.setTrait(IvarRegion, 
                RegionAndSymbolInvalidationTraits.InvalidationKinds.TK_DoNotInvalidateSuperRegion);
            ETraits.setTrait(IvarRegion, 
                RegionAndSymbolInvalidationTraits.InvalidationKinds.TK_SuppressEscape);
            Values.push_back(IvarLVal);
            return;
          }
        }
      }
    }
    
    Values.push_back(getReceiverSVal());
  }

  
  /// Check if the selector may have multiple definitions (may have overrides).
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ObjCMethodCall::canBeOverridenInSubclass">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp", line = 839,
   FQN="clang::ento::ObjCMethodCall::canBeOverridenInSubclass", NM="_ZNK5clang4ento14ObjCMethodCall24canBeOverridenInSubclassEPNS_17ObjCInterfaceDeclENS_8SelectorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK5clang4ento14ObjCMethodCall24canBeOverridenInSubclassEPNS_17ObjCInterfaceDeclENS_8SelectorE")
  //</editor-fold>
  protected boolean canBeOverridenInSubclass(ObjCInterfaceDecl /*P*/ IDecl, 
                          Selector Sel) /*const*/ {
    assert Native.$bool(IDecl);
    final /*const*/ SourceManager /*&*/ SM = getState().$arrow().getStateManager().getContext().getSourceManager();
    
    // If the class interface is declared inside the main file, assume it is not
    // subcassed.
    // TODO: It could actually be subclassed if the subclass is private as well.
    // This is probably very rare.
    SourceLocation InterfLoc = IDecl.getEndOfDefinitionLoc();
    if (InterfLoc.isValid() && SM.isInMainFile(/*NO_COPY*/InterfLoc)) {
      return false;
    }
    
    // Assume that property accessors are not overridden.
    if (getMessageKind() == ObjCMessageKind.OCM_PropertyAccess) {
      return false;
    }
    
    // We assume that if the method is public (declared outside of main file) or
    // has a parent which publicly declares the method, the method could be
    // overridden in a subclass.
    
    // Find the first declaration in the class hierarchy that declares
    // the selector.
    ObjCMethodDecl /*P*/ D = null;
    while (true) {
      D = IDecl.lookupMethod(new Selector(Sel), true);
      
      // Cannot find a public definition.
      if (!(D != null)) {
        return false;
      }
      
      // If outside the main file,
      if (D.getLocation().isValid() && !SM.isInMainFile(D.getLocation())) {
        return true;
      }
      if (D.isOverriding()) {
        // Search in the superclass on the next iteration.
        IDecl = D.getClassInterface();
        if (!(IDecl != null)) {
          return false;
        }
        
        IDecl = IDecl.getSuperClass();
        if (!(IDecl != null)) {
          return false;
        }
        
        continue;
      }
      
      return false;
    }
    //throw new llvm_unreachable("The while loop should always terminate.");
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ObjCMethodCall::getOriginExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 904,
   FQN="clang::ento::ObjCMethodCall::getOriginExpr", NM="_ZNK5clang4ento14ObjCMethodCall13getOriginExprEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK5clang4ento14ObjCMethodCall13getOriginExprEv")
  //</editor-fold>
  public /*virtual*/ /*const*/ ObjCMessageExpr /*P*/ getOriginExpr() /*const*/ {
    return cast_ObjCMessageExpr(super.getOriginExpr());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::ObjCMethodCall::getDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 907,
   FQN="clang::ento::ObjCMethodCall::getDecl", NM="_ZNK5clang4ento14ObjCMethodCall7getDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK5clang4ento14ObjCMethodCall7getDeclEv")
  //</editor-fold>
  @Override public /*const*/ ObjCMethodDecl /*P*/ getDecl() /*const*//* override*/ {
    return getOriginExpr().getMethodDecl$Const();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::ObjCMethodCall::getNumArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 910,
   FQN="clang::ento::ObjCMethodCall::getNumArgs", NM="_ZNK5clang4ento14ObjCMethodCall10getNumArgsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK5clang4ento14ObjCMethodCall10getNumArgsEv")
  //</editor-fold>
  @Override public /*uint*/int getNumArgs() /*const*//* override*/ {
    return getOriginExpr().getNumArgs();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::ObjCMethodCall::getArgExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 913,
   FQN="clang::ento::ObjCMethodCall::getArgExpr", NM="_ZNK5clang4ento14ObjCMethodCall10getArgExprEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK5clang4ento14ObjCMethodCall10getArgExprEj")
  //</editor-fold>
  @Override public /*const*/ Expr /*P*/ getArgExpr(/*uint*/int Index) /*const*//* override*/ {
    return getOriginExpr().getArg$Const(Index);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ObjCMethodCall::isInstanceMessage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 917,
   FQN="clang::ento::ObjCMethodCall::isInstanceMessage", NM="_ZNK5clang4ento14ObjCMethodCall17isInstanceMessageEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK5clang4ento14ObjCMethodCall17isInstanceMessageEv")
  //</editor-fold>
  public boolean isInstanceMessage() /*const*/ {
    return getOriginExpr().isInstanceMessage();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::ObjCMethodCall::getMethodFamily">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 920,
   FQN="clang::ento::ObjCMethodCall::getMethodFamily", NM="_ZNK5clang4ento14ObjCMethodCall15getMethodFamilyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK5clang4ento14ObjCMethodCall15getMethodFamilyEv")
  //</editor-fold>
  public ObjCMethodFamily getMethodFamily() /*const*/ {
    return getOriginExpr().getMethodFamily();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::ObjCMethodCall::getSelector">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 923,
   FQN="clang::ento::ObjCMethodCall::getSelector", NM="_ZNK5clang4ento14ObjCMethodCall11getSelectorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK5clang4ento14ObjCMethodCall11getSelectorEv")
  //</editor-fold>
  public Selector getSelector() /*const*/ {
    return getOriginExpr().getSelector();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ObjCMethodCall::getSourceRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp", line = 741,
   FQN="clang::ento::ObjCMethodCall::getSourceRange", NM="_ZNK5clang4ento14ObjCMethodCall14getSourceRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK5clang4ento14ObjCMethodCall14getSourceRangeEv")
  //</editor-fold>
  @Override public SourceRange getSourceRange() /*const*//* override*/ {
    switch (getMessageKind()) {
     case OCM_Message:
      return getOriginExpr().getSourceRange();
     case OCM_PropertyAccess:
     case OCM_Subscript:
      return getContainingPseudoObjectExpr().getSourceRange();
    }
    throw new llvm_unreachable("unknown message kind");
  }

  
  /// \brief Returns the value of the receiver at the time of this call.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ObjCMethodCall::getReceiverSVal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp", line = 712,
   FQN="clang::ento::ObjCMethodCall::getReceiverSVal", NM="_ZNK5clang4ento14ObjCMethodCall15getReceiverSValEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK5clang4ento14ObjCMethodCall15getReceiverSValEv")
  //</editor-fold>
  public SVal getReceiverSVal() /*const*/ {
    // FIXME: Is this the best way to handle class receivers?
    if (!isInstanceMessage()) {
      return new SVal(JD$Move.INSTANCE, new UnknownVal());
    }
    {
      
      /*const*/ Expr /*P*/ RecE = getOriginExpr().getInstanceReceiver$Const();
      if ((RecE != null)) {
        return getSVal(RecE);
      }
    }
    
    // An instance message with no expression means we are sending to super.
    // In this case the object reference is the same as 'self'.
    assert (getOriginExpr().getReceiverKind() == ObjCMessageExpr.ReceiverKind.SuperInstance);
    SVal SelfVal = getSelfSVal();
    assert (SelfVal.isValid$SVal()) : "Calling super but not in ObjC method";
    return SelfVal;
  }

  
  /// \brief Return the value of 'self' if available.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ObjCMethodCall::getSelfSVal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp", line = 704,
   FQN="clang::ento::ObjCMethodCall::getSelfSVal", NM="_ZNK5clang4ento14ObjCMethodCall11getSelfSValEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK5clang4ento14ObjCMethodCall11getSelfSValEv")
  //</editor-fold>
  public SVal getSelfSVal() /*const*/ {
    /*const*/ LocationContext /*P*/ LCtx = getLocationContext();
    /*const*/ ImplicitParamDecl /*P*/ SelfDecl = LCtx.getSelfDecl();
    if (!(SelfDecl != null)) {
      return new SVal();
    }
    return getState().$arrow().getSVal(getState().$arrow().getRegion(SelfDecl, LCtx));
  }

  
  /// \brief Get the interface for the receiver.
  ///
  /// This works whether this is an instance message or a class message.
  /// However, it currently just uses the static type of the receiver.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ObjCMethodCall::getReceiverInterface">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 939,
   FQN="clang::ento::ObjCMethodCall::getReceiverInterface", NM="_ZNK5clang4ento14ObjCMethodCall20getReceiverInterfaceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK5clang4ento14ObjCMethodCall20getReceiverInterfaceEv")
  //</editor-fold>
  public /*const*/ ObjCInterfaceDecl /*P*/ getReceiverInterface() /*const*/ {
    return getOriginExpr().getReceiverInterface();
  }

  
  /// \brief Checks if the receiver refers to 'self' or 'super'.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ObjCMethodCall::isReceiverSelfOrSuper">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp", line = 728,
   FQN="clang::ento::ObjCMethodCall::isReceiverSelfOrSuper", NM="_ZNK5clang4ento14ObjCMethodCall21isReceiverSelfOrSuperEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK5clang4ento14ObjCMethodCall21isReceiverSelfOrSuperEv")
  //</editor-fold>
  public boolean isReceiverSelfOrSuper() /*const*/ {
    if (getOriginExpr().getReceiverKind() == ObjCMessageExpr.ReceiverKind.SuperInstance
       || getOriginExpr().getReceiverKind() == ObjCMessageExpr.ReceiverKind.SuperClass) {
      return true;
    }
    if (!isInstanceMessage()) {
      return false;
    }
    
    SVal RecVal = getSVal(getOriginExpr().getInstanceReceiver$Const());
    
    return (RecVal.$eq(getSelfSVal()));
  }

  
  /// Returns how the message was written in the source (property access,
  /// subscript, or explicit message send).
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ObjCMethodCall::getMessageKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp", line = 772,
   FQN="clang::ento::ObjCMethodCall::getMessageKind", NM="_ZNK5clang4ento14ObjCMethodCall14getMessageKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK5clang4ento14ObjCMethodCall14getMessageKindEv")
  //</editor-fold>
  public ObjCMessageKind getMessageKind() /*const*/ {
    if (!(Data != null)) {
      
      // Find the parent, ignoring implicit casts.
      final ParentMap /*&*/ PM = getLocationContext().getParentMap();
      /*const*/ Stmt /*P*/ S = PM.getParentIgnoreParenCasts_Stmt$C$P(getOriginExpr());
      {
        
        // Check if parent is a PseudoObjectExpr.
        /*const*/ PseudoObjectExpr /*P*/ POE = dyn_cast_or_null_PseudoObjectExpr(S);
        if ((POE != null)) {
          /*const*/ Expr /*P*/ Syntactic = CallEventStatics.getSyntacticFromForPseudoObjectExpr(POE);
          
          ObjCMessageKind K;
          switch (Syntactic.getStmtClass()) {
           case ObjCPropertyRefExprClass:
            K = ObjCMessageKind.OCM_PropertyAccess;
            break;
           case ObjCSubscriptRefExprClass:
            K = ObjCMessageKind.OCM_Subscript;
            break;
           default:
            // FIXME: Can this ever happen?
            K = ObjCMessageKind.OCM_Message;
            break;
          }
          if (K != ObjCMessageKind.OCM_Message) {
            ((/*const_cast*/ObjCMethodCall /*P*/ )(this)).Data
               = new PointerIntPair</*const*/ PseudoObjectExpr /*P*/ >(POE, K.getValue()).getOpaqueValue();
            assert (getMessageKind() == K);
            return K;
          }
        }
      }
      
      ((/*const_cast*/ObjCMethodCall /*P*/ )(this)).Data 
         = new PointerIntPair</*const*/ PseudoObjectExpr /*P*/ >((/*const*/ PseudoObjectExpr /*P*/ )null, 1).getOpaqueValue();
      assert (getMessageKind() == ObjCMessageKind.OCM_Message);
      return ObjCMessageKind.OCM_Message;
    }
    
    PointerIntPair</*const*/ PseudoObjectExpr /*P*/ > Info = PointerIntPair.</*const*/ PseudoObjectExpr /*P*/ >getFromOpaqueValue_ConstVoidPtr(Data);
    if (!(Info.getPointer() != null)) {
      return ObjCMessageKind.OCM_Message;
    }
    return /*static_cast*/ObjCMessageKind.valueOf(Info.getInt());
  }

  
  /// Returns true if this property access or subscript is a setter (has the
  /// form of an assignment).
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ObjCMethodCall::isSetter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 952,
   FQN="clang::ento::ObjCMethodCall::isSetter", NM="_ZNK5clang4ento14ObjCMethodCall8isSetterEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK5clang4ento14ObjCMethodCall8isSetterEv")
  //</editor-fold>
  public boolean isSetter() /*const*/ {
    switch (getMessageKind()) {
     case OCM_Message:
      throw new llvm_unreachable("This is not a pseudo-object access!");
     case OCM_PropertyAccess:
      return $greater_uint(getNumArgs(), 0);
     case OCM_Subscript:
      return $greater_uint(getNumArgs(), 1);
    }
    throw new llvm_unreachable("Unknown message kind");
  }

  
  // Returns the property accessed by this method, either explicitly via
  // property syntax or implicitly via a getter or setter method. Returns
  // nullptr if the call is not a prooperty access.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ObjCMethodCall::getAccessedProperty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp", line = 817,
   FQN="clang::ento::ObjCMethodCall::getAccessedProperty", NM="_ZNK5clang4ento14ObjCMethodCall19getAccessedPropertyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK5clang4ento14ObjCMethodCall19getAccessedPropertyEv")
  //</editor-fold>
  public /*const*/ ObjCPropertyDecl /*P*/ getAccessedProperty() /*const*/ {
    // Look for properties accessed with property syntax (foo.bar = ...)
    if (getMessageKind() == ObjCMessageKind.OCM_PropertyAccess) {
      /*const*/ PseudoObjectExpr /*P*/ POE = getContainingPseudoObjectExpr();
      assert ((POE != null)) : "Property access without PseudoObjectExpr?";
      
      /*const*/ Expr /*P*/ Syntactic = CallEventStatics.getSyntacticFromForPseudoObjectExpr(POE);
      /*const*/ ObjCPropertyRefExpr /*P*/ RefExpr = cast_ObjCPropertyRefExpr(Syntactic);
      if (RefExpr.isExplicitProperty()) {
        return RefExpr.getExplicitProperty();
      }
    }
    
    // Look for properties accessed with method syntax ([foo setBar:...]).
    /*const*/ ObjCMethodDecl /*P*/ MD = getDecl();
    if (!(MD != null) || !MD.isPropertyAccessor()) {
      return null;
    }
    
    // Note: This is potentially quite slow.
    return MD.findPropertyDecl();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ObjCMethodCall::getRuntimeDefinition">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*make_pair and other. PMC is not static because context dependent*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp", line = 894,
   FQN="clang::ento::ObjCMethodCall::getRuntimeDefinition", NM="_ZNK5clang4ento14ObjCMethodCall20getRuntimeDefinitionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK5clang4ento14ObjCMethodCall20getRuntimeDefinitionEv")
  //</editor-fold>
  @Override public RuntimeDefinition getRuntimeDefinition() /*const*//* override*/ {
    /*const*/ ObjCMessageExpr /*P*/ E = getOriginExpr();
    assert Native.$bool(E);
    Selector Sel = E.getSelector();
    if (E.isInstanceMessage()) {
      
      // Find the receiver type.
      /*const*/ ObjCObjectPointerType /*P*/ ReceiverT = null;
      boolean CanBeSubClassed = false;
      QualType SupersType = E.getSuperType();
      /*const*/ MemRegion /*P*/ Receiver = null;
      if (!SupersType.isNull()) {
        // Super always means the type of immediate predecessor to the method
        // where the call occurs.
        ReceiverT = cast_ObjCObjectPointerType(SupersType);
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          Receiver = getReceiverSVal().getAsRegion();
          if (!(Receiver != null)) {
            return new RuntimeDefinition();
          }

          DynamicTypeInfo DTI = $c$.clean(EntoGlobals.getDynamicTypeInfo($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(getState())), Receiver));
          QualType DynType = DTI.getType();
          CanBeSubClassed = DTI.canBeASubClass();
          ReceiverT = dyn_cast_ObjCObjectPointerType(DynType);
          if ((ReceiverT != null) && CanBeSubClassed) {
            {
              ObjCInterfaceDecl /*P*/ IDecl = ReceiverT.getInterfaceDecl();
              if ((IDecl != null)) {
                if (!canBeOverridenInSubclass(IDecl, new Selector(Sel))) {
                  CanBeSubClassed = false;
                }
              }
            }
          }
        } finally {
         $c$.$destroy();
        } 
      }
      
      // Lookup the method implementation.
      if ((ReceiverT != null)) {
        {
          ObjCInterfaceDecl /*P*/ IDecl = ReceiverT.getInterfaceDecl();
          if ((IDecl != null)) {
            // Repeatedly calling lookupPrivateMethod() is expensive, especially
            // when in many cases it returns null.  We cache the results so
            // that repeated queries on the same ObjCIntefaceDecl and Selector
            // don't incur the same cost.  On some test cases, we can see the
            // same query being issued thousands of times.
            //
            // NOTE: This cache is essentially a "global" variable, but it
            // only gets lazily created when we get here.  The value of the
            // cache probably comes from it being global across ExprEngines,
            // where the same queries may get issued.  If we are worried about
            // concurrency, or possibly loading/unloading ASTs, etc., we may
            // need to revisit this someday.  In terms of memory, this table
            // stays around until clang quits, which also may be bad if we
            // need to release memory.
            // JAVA: typedef std::pair<const ObjCInterfaceDecl *, Selector> PrivateMethodKey
//            final class PrivateMethodKey extends std.pairPtrType</*const*/ ObjCInterfaceDecl /*P*/ , Selector>{ };
            // JAVA: typedef llvm::DenseMap<PrivateMethodKey, Optional<const ObjCMethodDecl *> > PrivateMethodCache
//            final class PrivateMethodCache extends DenseMap<std.pairPtrType</*const*/ ObjCInterfaceDecl /*P*/ , Selector>, Optional</*const*/ ObjCMethodDecl /*P*/ >>{ };
            
            final/*static*/ DenseMap<std.pairPtrType</*const*/ ObjCInterfaceDecl /*P*/ , Selector>, OptionalPtr</*const*/ ObjCMethodDecl /*P*/ >> PMC = getRuntimeDefinition$$.PMC(this);
            final OptionalPtr</*const*/ ObjCMethodDecl /*P*/ > /*&*/ Val = PMC.$at_T1$RR(new std.pairPtrType</*const*/ ObjCInterfaceDecl /*P*/ , Selector>(JD$Pair$_U1$_U2.INSTANCE, /*Fwd2*//*Fwd*/IDecl, new Selector(JD$Move.INSTANCE, /*Fwd*/new Selector(/*Fwd2*/Sel))));
            
            // Query lookupPrivateMethod() if the cache does not hit.
            if (!Val.hasValue()) {
              Val.$assign_T$RR(IDecl.lookupPrivateMethod(Sel));
              
              // If the method is a property accessor, we should try to "inline" it
              // even if we don't actually have an implementation.
              if (!(Val.$star() != null)) {
                {
                  /*const*/ ObjCMethodDecl /*P*/ CompileTimeMD = E.getMethodDecl$Const();
                  if ((CompileTimeMD != null)) {
                    if (CompileTimeMD.isPropertyAccessor()) {
                      if (!(CompileTimeMD.getSelfDecl() != null)
                         && isa_ObjCCategoryDecl(CompileTimeMD.getDeclContext$Const())) {
                        // If the method is an accessor in a category, and it doesn't
                        // have a self declaration, first
                        // try to find the method in a class extension. This
                        // works around a bug in Sema where multiple accessors
                        // are synthesized for properties in class
                        // extensions that are redeclared in a category and the
                        // the implicit parameters are not filled in for
                        // the method on the category.
                        // This ensures we find the accessor in the extension, which
                        // has the implicit parameters filled in.
                        /*const*/ ObjCInterfaceDecl /*P*/ ID = CompileTimeMD.getClassInterface$Const();
                        for (ObjCCategoryDecl /*P*/ CatDecl : ID.visible_extensions()) {
                          Val.$assign_T$RR(CatDecl.getMethod(new Selector(Sel), 
                                  CompileTimeMD.isInstanceMethod()));
                          if ((Val.$star() != null)) {
                            break;
                          }
                        }
                      }
                      if (!(Val.$star() != null)) {
                        Val.$assign_T$RR(IDecl.lookupInstanceMethod(new Selector(Sel)));
                      }
                    }
                  }
                }
              }
            }
            
            /*const*/ ObjCMethodDecl /*P*/ MD = Val.getValue();
            if (CanBeSubClassed) {
              return new RuntimeDefinition(MD, Receiver);
            } else {
              return new RuntimeDefinition(MD, (/*const*/ MemRegion /*P*/ )null);
            }
          }
        }
      }
    } else {
      {
        // This is a class method.
        // If we have type info for the receiver class, we are calling via
        // class name.
        ObjCInterfaceDecl /*P*/ IDecl = E.getReceiverInterface();
        if ((IDecl != null)) {
          // Find/Return the method implementation.
          return new RuntimeDefinition(IDecl.lookupPrivateClassMethod(Sel));
        }
      }
    }
    
    return new RuntimeDefinition();
  }
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC)
  private static final class getRuntimeDefinition$$ {
    // JAVA: must not be static!
    static/*static*/ DenseMap<
            std.pairPtrType</*const*/ ObjCInterfaceDecl /*P*/ , Selector>, 
            OptionalPtr</*const*/ ObjCMethodDecl /*P*/ >> PMC(ObjCMethodCall $this) {              
      // get it from manager vs. declare static global cache which is invalid between different TUs
      return $this.getLocationContext().getAnalysisDeclContext().getManager().$getObjCInterfaceDecl$Selector$Cache();
    }
//            new DenseMap<std.pair</*const*/ ObjCInterfaceDecl /*P*/ , Selector>,
//                    Optional</*const*/ ObjCMethodDecl /*P*/ >>(
//                            new DenseMapInfoPair</*const*/ ObjCInterfaceDecl /*P*/ , Selector>(DenseMapInfo$LikePtr.$Info(), DenseMapInfoSelector.$Info()),
//                            new Optional</*const*/ ObjCMethodDecl /*P*/ >());
    
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::ObjCMethodCall::argumentsMayEscape">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp", line = 1007,
   FQN="clang::ento::ObjCMethodCall::argumentsMayEscape", NM="_ZNK5clang4ento14ObjCMethodCall18argumentsMayEscapeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK5clang4ento14ObjCMethodCall18argumentsMayEscapeEv")
  //</editor-fold>
  @Override public boolean argumentsMayEscape() /*const*//* override*/ {
    if (isInSystemHeader() && !isInstanceMessage()) {
      Selector Sel = getSelector();
      if (Sel.getNumArgs() == 1
         && Sel.getIdentifierInfoForSlot(0).isStr(/*KEEP_STR*/"valueWithPointer")) {
        return true;
      }
    }
    
    return super.argumentsMayEscape();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ObjCMethodCall::getInitialStackFrameContents">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp", line = 1018,
   FQN="clang::ento::ObjCMethodCall::getInitialStackFrameContents", NM="_ZNK5clang4ento14ObjCMethodCall28getInitialStackFrameContentsEPKNS_17StackFrameContextERN4llvm15SmallVectorImplISt4pairINS0_3LocENS0_4SValEEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK5clang4ento14ObjCMethodCall28getInitialStackFrameContentsEPKNS_17StackFrameContextERN4llvm15SmallVectorImplISt4pairINS0_3LocENS0_4SValEEEE")
  //</editor-fold>
  @Override public void getInitialStackFrameContents(/*const*/ StackFrameContext /*P*/ CalleeCtx, 
                              final SmallVectorImpl<std.pairTypeType<Loc, SVal> > /*&*/ Bindings) /*const*//* override*/ {
    /*const*/ ObjCMethodDecl /*P*/ D = cast_ObjCMethodDecl(CalleeCtx.getDecl());
    final SValBuilder /*&*/ SVB = getState().$arrow().getStateManager().getSValBuilder();
    CallEventStatics.addParameterValuesToBindings(CalleeCtx, Bindings, SVB, /*Deref*/this, 
        D.parameters());
    
    SVal SelfVal = getReceiverSVal();
    if (!SelfVal.isUnknown$SVal()) {
      /*const*/ VarDecl /*P*/ SelfD = CalleeCtx.getAnalysisDeclContext().getSelfDecl();
      final MemRegionManager /*&*/ MRMgr = SVB.getRegionManager();
      Loc SelfLoc = SVB.makeLoc(MRMgr.getVarRegion(SelfD, CalleeCtx));
      Bindings.push_back(std.make_pair($Clone(SelfLoc), $Clone(SelfVal)));
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ObjCMethodCall::parameters">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp", line = 674,
   FQN="clang::ento::ObjCMethodCall::parameters", NM="_ZNK5clang4ento14ObjCMethodCall10parametersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK5clang4ento14ObjCMethodCall10parametersEv")
  //</editor-fold>
  @Override public ArrayRef<ParmVarDecl /*P*/ > parameters() /*const*//* override*/ {
    /*const*/ ObjCMethodDecl /*P*/ D = getDecl();
    if (!(D != null)) {
      return new ArrayRef<ParmVarDecl /*P*/ >(None, true);
    }
    return D.parameters();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ObjCMethodCall::getKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 978,
   FQN="clang::ento::ObjCMethodCall::getKind", NM="_ZNK5clang4ento14ObjCMethodCall7getKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK5clang4ento14ObjCMethodCall7getKindEv")
  //</editor-fold>
  @Override public CallEventKind getKind() /*const*//* override*/ {
    return CallEventKind.CE_ObjCMessage;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ObjCMethodCall::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 980,
   FQN="clang::ento::ObjCMethodCall::classof", NM="_ZN5clang4ento14ObjCMethodCall7classofEPKNS0_9CallEventE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN5clang4ento14ObjCMethodCall7classofEPKNS0_9CallEventE")
  //</editor-fold>
  public static boolean classof(/*const*/ CallEvent /*P*/ CA) {
    return CA.getKind() == CallEventKind.CE_ObjCMessage;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::ObjCMethodCall::~ObjCMethodCall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 881,
   FQN="clang::ento::ObjCMethodCall::~ObjCMethodCall", NM="_ZN5clang4ento14ObjCMethodCallD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN5clang4ento14ObjCMethodCallD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override public ObjCMethodCall clone() { return new ObjCMethodCall(this); }
  
  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
