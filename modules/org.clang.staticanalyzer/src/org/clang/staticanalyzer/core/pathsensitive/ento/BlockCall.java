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
import static org.clang.staticanalyzer.java.StaticanalyzerRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import org.clang.staticanalyzer.core.impl.CallEventStatics;


/// \brief Represents a call to a block.
///
/// Example: <tt>^{ /* ... */ }()</tt>
//<editor-fold defaultstate="collapsed" desc="clang::ento::BlockCall">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 504,
 FQN="clang::ento::BlockCall", NM="_ZN5clang4ento9BlockCallE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN5clang4ento9BlockCallE")
//</editor-fold>
public class BlockCall extends /*public*/ CallEvent implements Destructors.ClassWithDestructor {
  /*friend  class CallEventManager*/
/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BlockCall::BlockCall">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*cleaner*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 508,
   FQN="clang::ento::BlockCall::BlockCall", NM="_ZN5clang4ento9BlockCallC1EPKNS_8CallExprEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS_15LocationContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN5clang4ento9BlockCallC1EPKNS_8CallExprEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS_15LocationContextE")
  //</editor-fold>
  protected BlockCall(/*const*/ CallExpr /*P*/ CE, IntrusiveRefCntPtr</*const*/ ProgramState> St, 
      /*const*/ LocationContext /*P*/ LCtx) {
    // : CallEvent(CE, $c$.track(St), LCtx) 
    //START JInit
    /*ExprWithCleanups*/super(CE, /*$c$.track(*/new IntrusiveRefCntPtr</*const*/ ProgramState>(St)/*)*/, LCtx, JD$Clean.TRAILING);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BlockCall::BlockCall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 512,
   FQN="clang::ento::BlockCall::BlockCall", NM="_ZN5clang4ento9BlockCallC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN5clang4ento9BlockCallC1ERKS1_")
  //</editor-fold>
  protected BlockCall(final /*const*/ BlockCall /*&*/ Other) {
    // : CallEvent(Other) 
    //START JInit
    super(Other);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::BlockCall::cloneTo">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 513,
   FQN="clang::ento::BlockCall::cloneTo", NM="_ZNK5clang4ento9BlockCall7cloneToEPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK5clang4ento9BlockCall7cloneToEPv")
  //</editor-fold>
  @Override protected void cloneTo(Object/*void P*/ Dest) /*const*//* override*/ {
    assert false : "must use clone instead";
    /*NEW_EXPR [System]*/Dest = /*new (Dest)*/ $new_uint_voidPtr(Dest, (type$ptr<?> New$Mem)->{
        return new BlockCall(/*Deref*/this);
     });
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BlockCall::getExtraInvalidatedValues">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp", line = 602,
   FQN="clang::ento::BlockCall::getExtraInvalidatedValues", NM="_ZNK5clang4ento9BlockCall25getExtraInvalidatedValuesERN4llvm15SmallVectorImplINS0_4SValEEEPNS0_33RegionAndSymbolInvalidationTraitsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK5clang4ento9BlockCall25getExtraInvalidatedValuesERN4llvm15SmallVectorImplINS0_4SValEEEPNS0_33RegionAndSymbolInvalidationTraitsE")
  //</editor-fold>
  @Override protected void getExtraInvalidatedValues(final SmallVectorImpl<SVal> /*&*/ Values, 
                           RegionAndSymbolInvalidationTraits /*P*/ ETraits) /*const*//* override*/ {
    {
      // FIXME: This also needs to invalidate captured globals.
      /*const*/ MemRegion /*P*/ R = getBlockRegion();
      if ((R != null)) {
        Values.push_back(new NsLoc.MemRegionVal(R));
      }
    }
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BlockCall::getOriginExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 519,
   FQN="clang::ento::BlockCall::getOriginExpr", NM="_ZNK5clang4ento9BlockCall13getOriginExprEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK5clang4ento9BlockCall13getOriginExprEv")
  //</editor-fold>
  public /*virtual*/ /*const*/ CallExpr /*P*/ getOriginExpr() /*const*/ {
    return cast_CallExpr(super.getOriginExpr());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BlockCall::getNumArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 523,
   FQN="clang::ento::BlockCall::getNumArgs", NM="_ZNK5clang4ento9BlockCall10getNumArgsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK5clang4ento9BlockCall10getNumArgsEv")
  //</editor-fold>
  @Override public /*uint*/int getNumArgs() /*const*//* override*/ {
    return getOriginExpr().getNumArgs();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BlockCall::getArgExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 525,
   FQN="clang::ento::BlockCall::getArgExpr", NM="_ZNK5clang4ento9BlockCall10getArgExprEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK5clang4ento9BlockCall10getArgExprEj")
  //</editor-fold>
  @Override public /*const*/ Expr /*P*/ getArgExpr(/*uint*/int Index) /*const*//* override*/ {
    return getOriginExpr().getArg$Const(Index);
  }

  
  /// \brief Returns the region associated with this instance of the block.
  ///
  /// This may be NULL if the block's origin is unknown.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BlockCall::getBlockRegion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp", line = 588,
   FQN="clang::ento::BlockCall::getBlockRegion", NM="_ZNK5clang4ento9BlockCall14getBlockRegionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK5clang4ento9BlockCall14getBlockRegionEv")
  //</editor-fold>
  public /*const*/ BlockDataRegion /*P*/ getBlockRegion() /*const*/ {
    /*const*/ Expr /*P*/ Callee = getOriginExpr().getCallee$Const();
    /*const*/ MemRegion /*P*/ DataReg = getSVal(Callee).getAsRegion();
    
    return dyn_cast_or_null_BlockDataRegion(DataReg);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BlockCall::getDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 534,
   FQN="clang::ento::BlockCall::getDecl", NM="_ZNK5clang4ento9BlockCall7getDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK5clang4ento9BlockCall7getDeclEv")
  //</editor-fold>
  @Override public /*const*/ BlockDecl /*P*/ getDecl() /*const*//* override*/ {
    /*const*/ BlockDataRegion /*P*/ BR = getBlockRegion();
    if (!(BR != null)) {
      return null;
    }
    return BR.getDecl();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BlockCall::isConversionFromLambda">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 541,
   FQN="clang::ento::BlockCall::isConversionFromLambda", NM="_ZNK5clang4ento9BlockCall22isConversionFromLambdaEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK5clang4ento9BlockCall22isConversionFromLambdaEv")
  //</editor-fold>
  public boolean isConversionFromLambda() /*const*/ {
    /*const*/ BlockDecl /*P*/ BD = getDecl();
    if (!(BD != null)) {
      return false;
    }
    
    return BD.isConversionFromLambda();
  }

  
  /// \brief For a block converted from a C++ lambda, returns the block
  /// VarRegion for the variable holding the captured C++ lambda record.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BlockCall::getRegionStoringCapturedLambda">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 551,
   FQN="clang::ento::BlockCall::getRegionStoringCapturedLambda", NM="_ZNK5clang4ento9BlockCall30getRegionStoringCapturedLambdaEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK5clang4ento9BlockCall30getRegionStoringCapturedLambdaEv")
  //</editor-fold>
  public /*const*/ VarRegion /*P*/ getRegionStoringCapturedLambda() /*const*/ {
    assert (isConversionFromLambda());
    /*const*/ BlockDataRegion /*P*/ BR = getBlockRegion();
    assert ((BR != null)) : "Block converted from lambda must have a block region";
    
    BlockDataRegion.referenced_vars_iterator I = BR.referenced_vars_begin();
    assert (I.$noteq(BR.referenced_vars_end()));
    
    return I.getCapturedRegion();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BlockCall::getRuntimeDefinition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 562,
   FQN="clang::ento::BlockCall::getRuntimeDefinition", NM="_ZNK5clang4ento9BlockCall20getRuntimeDefinitionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK5clang4ento9BlockCall20getRuntimeDefinitionEv")
  //</editor-fold>
  @Override public RuntimeDefinition getRuntimeDefinition() /*const*//* override*/ {
    if (!isConversionFromLambda()) {
      return new RuntimeDefinition(getDecl());
    }
    
    // Clang converts lambdas to blocks with an implicit user-defined
    // conversion operator method on the lambda record that looks (roughly)
    // like:
    //
    // typedef R(^block_type)(P1, P2, ...);
    // operator block_type() const {
    //   auto Lambda = *this;
    //   return ^(P1 p1, P2 p2, ...){
    //     /* return Lambda(p1, p2, ...); */
    //   };
    // }
    //
    // Here R is the return type of the lambda and P1, P2, ... are
    // its parameter types. 'Lambda' is a fake VarDecl captured by the block
    // that is initialized to a copy of the lambda.
    //
    // Sema leaves the body of a lambda-converted block empty (it is
    // produced by CodeGen), so we can't analyze it directly. Instead, we skip
    // the block body and analyze the operator() method on the captured lambda.
    /*const*/ VarDecl /*P*/ LambdaVD = getRegionStoringCapturedLambda().getDecl();
    /*const*/ CXXRecordDecl /*P*/ LambdaDecl = LambdaVD.getType().$arrow().getAsCXXRecordDecl();
    CXXMethodDecl /*P*/ LambdaCallOperator = LambdaDecl.getLambdaCallOperator();
    
    return new RuntimeDefinition(LambdaCallOperator);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BlockCall::argumentsMayEscape">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 592,
   FQN="clang::ento::BlockCall::argumentsMayEscape", NM="_ZNK5clang4ento9BlockCall18argumentsMayEscapeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK5clang4ento9BlockCall18argumentsMayEscapeEv")
  //</editor-fold>
  @Override public boolean argumentsMayEscape() /*const*//* override*/ {
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BlockCall::getInitialStackFrameContents">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp", line = 609,
   FQN="clang::ento::BlockCall::getInitialStackFrameContents", NM="_ZNK5clang4ento9BlockCall28getInitialStackFrameContentsEPKNS_17StackFrameContextERN4llvm15SmallVectorImplISt4pairINS0_3LocENS0_4SValEEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK5clang4ento9BlockCall28getInitialStackFrameContentsEPKNS_17StackFrameContextERN4llvm15SmallVectorImplISt4pairINS0_3LocENS0_4SValEEEE")
  //</editor-fold>
  @Override public void getInitialStackFrameContents(/*const*/ StackFrameContext /*P*/ CalleeCtx, 
                              final SmallVectorImpl<std.pairTypeType<Loc, SVal> > /*&*/ Bindings) /*const*//* override*/ {
    final SValBuilder /*&*/ SVB = getState().$arrow().getStateManager().getSValBuilder();
    ArrayRef<ParmVarDecl /*P*/ > Params/*J*/= new ArrayRef<ParmVarDecl /*P*/ >(true);
    if (isConversionFromLambda()) {
      /*const*/ CXXMethodDecl /*P*/ LambdaOperatorDecl = cast_CXXMethodDecl(CalleeCtx.getDecl());
      Params.$assignMove(LambdaOperatorDecl.parameters$Const());
      
      // For blocks converted from a C++ lambda, the callee declaration is the
      // operator() method on the lambda so we bind "this" to
      // the lambda captured by the block.
      /*const*/ VarRegion /*P*/ CapturedLambdaRegion = getRegionStoringCapturedLambda();
      SVal ThisVal = new SVal(JD$Move.INSTANCE, new NsLoc.MemRegionVal(CapturedLambdaRegion));
      Loc ThisLoc = new Loc(JD$Move.INSTANCE, SVB.getCXXThis(LambdaOperatorDecl, CalleeCtx));
      Bindings.push_back(std.make_pair($Clone(ThisLoc), $Clone(ThisVal)));
    } else {
      Params.$assignMove(cast_BlockDecl(CalleeCtx.getDecl()).parameters$Const());
    }
    
    CallEventStatics.addParameterValuesToBindings(CalleeCtx, Bindings, SVB, /*Deref*/this, 
        new ArrayRef<ParmVarDecl /*P*/ >(Params));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BlockCall::parameters">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp", line = 595,
   FQN="clang::ento::BlockCall::parameters", NM="_ZNK5clang4ento9BlockCall10parametersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK5clang4ento9BlockCall10parametersEv")
  //</editor-fold>
  @Override public ArrayRef<ParmVarDecl /*P*/ > parameters() /*const*//* override*/ {
    /*const*/ BlockDecl /*P*/ D = getDecl();
    if (!(D != null)) {
      return new ArrayRef<ParmVarDecl /*P*/ >((ParmVarDecl /*P*/ /*const*/)null, true);
    }
    return D.parameters$Const();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BlockCall::getKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 601,
   FQN="clang::ento::BlockCall::getKind", NM="_ZNK5clang4ento9BlockCall7getKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK5clang4ento9BlockCall7getKindEv")
  //</editor-fold>
  @Override public CallEventKind getKind() /*const*//* override*/ {
    return CallEventKind.CE_Block;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BlockCall::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 603,
   FQN="clang::ento::BlockCall::classof", NM="_ZN5clang4ento9BlockCall7classofEPKNS0_9CallEventE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN5clang4ento9BlockCall7classofEPKNS0_9CallEventE")
  //</editor-fold>
  public static boolean classof(/*const*/ CallEvent /*P*/ CA) {
    return CA.getKind() == CallEventKind.CE_Block;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::BlockCall::~BlockCall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/CallEvent.h", line = 504,
   FQN="clang::ento::BlockCall::~BlockCall", NM="_ZN5clang4ento9BlockCallD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN5clang4ento9BlockCallD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override public BlockCall clone() { return new BlockCall(this); }
  
  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
