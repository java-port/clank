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
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.analysis.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;


/// \brief Represents a call to a C++ constructor.
///
/// Example: \c T(1)
//<editor-fold defaultstate="collapsed" desc="clang::ento::CXXConstructorCall">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 776,
 FQN="clang::ento::CXXConstructorCall", NM="_ZN5clang4ento18CXXConstructorCallE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN5clang4ento18CXXConstructorCallE")
//</editor-fold>
public class CXXConstructorCall extends /*public*/ AnyFunctionCall implements Destructors.ClassWithDestructor {
  /*friend  class CallEventManager*/
/*protected:*/
  /// Creates a constructor call.
  ///
  /// \param CE The constructor expression as written in the source.
  /// \param Target The region where the object should be constructed. If NULL,
  ///               a new symbolic region will be used.
  /// \param St The path-sensitive state at this point in the program.
  /// \param LCtx The location context at this point in the program.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CXXConstructorCall::CXXConstructorCall">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*cleaner*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 787,
   FQN="clang::ento::CXXConstructorCall::CXXConstructorCall", NM="_ZN5clang4ento18CXXConstructorCallC1EPKNS_16CXXConstructExprEPKNS0_9MemRegionEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS_15LocationContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN5clang4ento18CXXConstructorCallC1EPKNS_16CXXConstructExprEPKNS0_9MemRegionEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS_15LocationContextE")
  //</editor-fold>
  protected CXXConstructorCall(/*const*/ CXXConstructExpr /*P*/ CE, /*const*/ MemRegion /*P*/ Target, 
      IntrusiveRefCntPtr</*const*/ ProgramState> St, /*const*/ LocationContext /*P*/ LCtx) {
    // : AnyFunctionCall(CE, $c$.track(St), LCtx) 
    //START JInit
    /*ExprWithCleanups*/super(CE, /*$c$.track(*/new IntrusiveRefCntPtr</*const*/ ProgramState>(St)/*)*/, LCtx, JD$Clean.TRAILING);
    //END JInit
    Data = Target;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CXXConstructorCall::CXXConstructorCall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 793,
   FQN="clang::ento::CXXConstructorCall::CXXConstructorCall", NM="_ZN5clang4ento18CXXConstructorCallC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN5clang4ento18CXXConstructorCallC1ERKS1_")
  //</editor-fold>
  protected CXXConstructorCall(final /*const*/ CXXConstructorCall /*&*/ Other) {
    // : AnyFunctionCall(Other) 
    //START JInit
    super(Other);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::CXXConstructorCall::cloneTo">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 794,
   FQN="clang::ento::CXXConstructorCall::cloneTo", NM="_ZNK5clang4ento18CXXConstructorCall7cloneToEPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK5clang4ento18CXXConstructorCall7cloneToEPv")
  //</editor-fold>
  @Override protected void cloneTo(Object/*void P*/ Dest) /*const*//* override*/ {
    assert false : "must use clone instead";
    /*NEW_EXPR [System]*/Dest = /*new (Dest)*/ $new_uint_voidPtr(Dest, (type$ptr<?> New$Mem)->{
        return new CXXConstructorCall(/*Deref*/this);
     });
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CXXConstructorCall::getExtraInvalidatedValues">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp", line = 639,
   FQN="clang::ento::CXXConstructorCall::getExtraInvalidatedValues", NM="_ZNK5clang4ento18CXXConstructorCall25getExtraInvalidatedValuesERN4llvm15SmallVectorImplINS0_4SValEEEPNS0_33RegionAndSymbolInvalidationTraitsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK5clang4ento18CXXConstructorCall25getExtraInvalidatedValuesERN4llvm15SmallVectorImplINS0_4SValEEEPNS0_33RegionAndSymbolInvalidationTraitsE")
  //</editor-fold>
  @Override protected void getExtraInvalidatedValues(final SmallVectorImpl<SVal> /*&*/ Values, 
                           RegionAndSymbolInvalidationTraits /*P*/ ETraits) /*const*//* override*/ {
    if ((Data != null)) {
      Values.push_back(new NsLoc.MemRegionVal(((/*static_cast*//*const*/ MemRegion /*P*/ )(Data))));
    }
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CXXConstructorCall::getOriginExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 800,
   FQN="clang::ento::CXXConstructorCall::getOriginExpr", NM="_ZNK5clang4ento18CXXConstructorCall13getOriginExprEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK5clang4ento18CXXConstructorCall13getOriginExprEv")
  //</editor-fold>
  public /*virtual*/ /*const*/ CXXConstructExpr /*P*/ getOriginExpr() /*const*/ {
    return cast_CXXConstructExpr(super.getOriginExpr());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CXXConstructorCall::getDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 804,
   FQN="clang::ento::CXXConstructorCall::getDecl", NM="_ZNK5clang4ento18CXXConstructorCall7getDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK5clang4ento18CXXConstructorCall7getDeclEv")
  //</editor-fold>
  @Override public /*const*/ CXXConstructorDecl /*P*/ getDecl() /*const*//* override*/ {
    return getOriginExpr().getConstructor();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CXXConstructorCall::getNumArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 808,
   FQN="clang::ento::CXXConstructorCall::getNumArgs", NM="_ZNK5clang4ento18CXXConstructorCall10getNumArgsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK5clang4ento18CXXConstructorCall10getNumArgsEv")
  //</editor-fold>
  @Override public /*uint*/int getNumArgs() /*const*//* override*/ {
    return getOriginExpr().getNumArgs();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CXXConstructorCall::getArgExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 810,
   FQN="clang::ento::CXXConstructorCall::getArgExpr", NM="_ZNK5clang4ento18CXXConstructorCall10getArgExprEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK5clang4ento18CXXConstructorCall10getArgExprEj")
  //</editor-fold>
  @Override public /*const*/ Expr /*P*/ getArgExpr(/*uint*/int Index) /*const*//* override*/ {
    return getOriginExpr().getArg$Const(Index);
  }

  
  /// \brief Returns the value of the implicit 'this' object.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CXXConstructorCall::getCXXThisVal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp", line = 633,
   FQN="clang::ento::CXXConstructorCall::getCXXThisVal", NM="_ZNK5clang4ento18CXXConstructorCall13getCXXThisValEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK5clang4ento18CXXConstructorCall13getCXXThisValEv")
  //</editor-fold>
  public SVal getCXXThisVal() /*const*/ {
    if ((Data != null)) {
      return new SVal(JD$Move.INSTANCE, new NsLoc.MemRegionVal(((/*static_cast*//*const*/ MemRegion /*P*/ )(Data))));
    }
    return new SVal(JD$Move.INSTANCE, new UnknownVal());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CXXConstructorCall::getInitialStackFrameContents">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp", line = 645,
   FQN="clang::ento::CXXConstructorCall::getInitialStackFrameContents", NM="_ZNK5clang4ento18CXXConstructorCall28getInitialStackFrameContentsEPKNS_17StackFrameContextERN4llvm15SmallVectorImplISt4pairINS0_3LocENS0_4SValEEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK5clang4ento18CXXConstructorCall28getInitialStackFrameContentsEPKNS_17StackFrameContextERN4llvm15SmallVectorImplISt4pairINS0_3LocENS0_4SValEEEE")
  //</editor-fold>
  @Override public void getInitialStackFrameContents(/*const*/ StackFrameContext /*P*/ CalleeCtx, 
                              final SmallVectorImpl<std.pairTypeType<Loc, SVal> > /*&*/ Bindings) /*const*//* override*/ {
    super.getInitialStackFrameContents(CalleeCtx, Bindings);
    
    SVal ThisVal = getCXXThisVal();
    if (!ThisVal.isUnknown$SVal()) {
      final SValBuilder /*&*/ SVB = getState().$arrow().getStateManager().getSValBuilder();
      /*const*/ CXXMethodDecl /*P*/ MD = cast_CXXMethodDecl(CalleeCtx.getDecl());
      Loc ThisLoc = new Loc(JD$Move.INSTANCE, SVB.getCXXThis(MD, CalleeCtx));
      Bindings.push_back(std.make_pair($Clone(ThisLoc), $Clone(ThisVal)));
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CXXConstructorCall::getKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 820,
   FQN="clang::ento::CXXConstructorCall::getKind", NM="_ZNK5clang4ento18CXXConstructorCall7getKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK5clang4ento18CXXConstructorCall7getKindEv")
  //</editor-fold>
  @Override public CallEventKind getKind() /*const*//* override*/ {
    return CallEventKind.CE_CXXConstructor;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CXXConstructorCall::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 822,
   FQN="clang::ento::CXXConstructorCall::classof", NM="_ZN5clang4ento18CXXConstructorCall7classofEPKNS0_9CallEventE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN5clang4ento18CXXConstructorCall7classofEPKNS0_9CallEventE")
  //</editor-fold>
  public static boolean classof(/*const*/ CallEvent /*P*/ CA) {
    return CA.getKind() == CallEventKind.CE_CXXConstructor;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::CXXConstructorCall::~CXXConstructorCall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 776,
   FQN="clang::ento::CXXConstructorCall::~CXXConstructorCall", NM="_ZN5clang4ento18CXXConstructorCallD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN5clang4ento18CXXConstructorCallD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override public CXXConstructorCall clone() { return new CXXConstructorCall(this); }
  
  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
