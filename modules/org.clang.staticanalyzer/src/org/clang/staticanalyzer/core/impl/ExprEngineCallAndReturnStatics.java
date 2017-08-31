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
package org.clang.staticanalyzer.core.impl;

import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.analysis.*;
import org.clang.basic.*;
import org.clang.frontend.staticanalyzer.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import static org.clang.staticanalyzer.java.StaticanalyzerRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import org.clang.analysis.analyses.*;
import static org.clang.ast.QualType.*;


//<editor-fold defaultstate="collapsed" desc="static type ExprEngineCallAndReturnStatics">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.clang.staticanalyzer.core.impl.ExprEngineCallAndReturnStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineCallAndReturn.cpp -nm=_ZL11getLastStmtPKN5clang4ento12ExplodedNodeE;_ZL13mayInlineDeclPN5clang19AnalysisDeclContextERNS_15AnalyzerOptionsE;_ZL15NumInlinedCalls;_ZL16isContainerClassRKN5clang10ASTContextEPKNS_13CXXRecordDeclE;_ZL17adjustReturnValueN5clang4ento4SValENS_8QualTypeES2_RNS0_12StoreManagerE;_ZL17isContainerMethodRKN5clang10ASTContextEPKNS_12FunctionDeclE;_ZL17mayInlineCallKindRKN5clang4ento9CallEventEPKNS0_12ExplodedNodeERNS_15AnalyzerOptionsE;_ZL18isCXXSharedPtrDtorPKN5clang12FunctionDeclE;_ZL18isTemporaryPRValuePKN5clang16CXXConstructExprENS_4ento4SValE;_ZL20getInlineFailedStateN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEEPKNS1_4StmtE;_ZL24NumReachedInlineCountMax;_ZL25isTrivialObjectAssignmentRKN5clang4ento9CallEventE;_ZL30NumOfDynamicDispatchPathSplits;_ZL31wasDifferentDeclUsedForInliningN5clang4ento12CallEventRefINS0_9CallEventEEEPKNS_17StackFrameContextE;_ZL9hasMemberRKN5clang10ASTContextEPKNS_13CXXRecordDeclEN4llvm9StringRefE; -static-type=ExprEngineCallAndReturnStatics -package=org.clang.staticanalyzer.core.impl")
//</editor-fold>
public final class ExprEngineCallAndReturnStatics {

//<editor-fold defaultstate="collapsed" desc="NumOfDynamicDispatchPathSplits">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineCallAndReturn.cpp", line = 31,
 FQN="NumOfDynamicDispatchPathSplits", NM="_ZL30NumOfDynamicDispatchPathSplits",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineCallAndReturn.cpp -nm=_ZL30NumOfDynamicDispatchPathSplits")
//</editor-fold>
public static Statistic NumOfDynamicDispatchPathSplits = new Statistic($("ExprEngine"), $("NumOfDynamicDispatchPathSplits"), $("The # of times we split the path due to imprecise dynamic dispatch info"), (/*(void)*/0), false);
//<editor-fold defaultstate="collapsed" desc="NumInlinedCalls">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineCallAndReturn.cpp", line = 34,
 FQN="NumInlinedCalls", NM="_ZL15NumInlinedCalls",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineCallAndReturn.cpp -nm=_ZL15NumInlinedCalls")
//</editor-fold>
public static Statistic NumInlinedCalls = new Statistic($("ExprEngine"), $("NumInlinedCalls"), $("The # of times we inlined a call"), (/*(void)*/0), false);
//<editor-fold defaultstate="collapsed" desc="NumReachedInlineCountMax">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineCallAndReturn.cpp", line = 37,
 FQN="NumReachedInlineCountMax", NM="_ZL24NumReachedInlineCountMax",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineCallAndReturn.cpp -nm=_ZL24NumReachedInlineCountMax")
//</editor-fold>
public static Statistic NumReachedInlineCountMax = new Statistic($("ExprEngine"), $("NumReachedInlineCountMax"), $("The # of times we reached inline count maximum"), (/*(void)*/0), false);

// Find the last statement on the path to the exploded node and the
// corresponding Block.
//<editor-fold defaultstate="collapsed" desc="getLastStmt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineCallAndReturn.cpp", line = 73,
 FQN="getLastStmt", NM="_ZL11getLastStmtPKN5clang4ento12ExplodedNodeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineCallAndReturn.cpp -nm=_ZL11getLastStmtPKN5clang4ento12ExplodedNodeE")
//</editor-fold>
public static std.pairPtrPtr</*const*/ Stmt /*P*/ , /*const*/ CFGBlock /*P*/ > getLastStmt(/*const*/ ExplodedNode /*P*/ Node) {
  /*const*/ Stmt /*P*/ S = null;
  /*const*/ CFGBlock /*P*/ Blk = null;
  /*const*/ StackFrameContext /*P*/ SF = Node.getLocation().getLocationContext().getCurrentStackFrame();
  
  // Back up through the ExplodedGraph until we reach a statement node in this
  // stack frame.
  while ((Node != null)) {
    final /*const*/ ProgramPoint /*&*/ PP = Node.getLocation();
    if (PP.getLocationContext().getCurrentStackFrame() == SF) {
      {
        Optional<StmtPoint> SP = PP.getAs(StmtPoint.class);
        if (SP.$bool()) {
          S = SP.$arrow().getStmt();
          break;
        } else {
          Optional<CallExitEnd> CEE = PP.getAs(CallExitEnd.class);
          if (CEE.$bool()) {
            S = CEE.$arrow().getCalleeContext().getCallSite();
            if ((S != null)) {
              break;
            }
            
            // If there is no statement, this is an implicitly-generated call.
            // We'll walk backwards over it and then continue the loop to find
            // an actual statement.
            Optional<CallEnter> CE/*J*/= new Optional<CallEnter>();
            do {
              Node = Node.getFirstPred$Const();
              CE.$assignMove(Node.<CallEnter>getLocationAs(CallEnter.class));
            } while (!CE.$bool() || CE.$arrow().getCalleeContext() != CEE.$arrow().getCalleeContext());
            // Continue searching the graph.
          } else {
            Optional<BlockEdge> BE = PP.getAs(BlockEdge.class);
            if (BE.$bool()) {
              Blk = BE.$arrow().getSrc();
            }
          }
        }
      }
    } else {
      Optional<CallEnter> CE = PP.getAs(CallEnter.class);
      if (CE.$bool()) {
        // If we reached the CallEnter for this function, it has no statements.
        if (CE.$arrow().getCalleeContext() == SF) {
          break;
        }
      }
    }
    if (Node.pred_empty()) {
      return new std.pairPtrPtr</*const*/ Stmt /*P*/ , /*const*/ CFGBlock /*P*/ >(JD$Pair$_U1$_U2.INSTANCE, (/*const*/ Stmt /*P*/ )null, (/*const*/ CFGBlock /*P*/ )null);
    }
    
    Node = Node.pred_begin$Const().$star();
  }
  
  return std.make_pair_Ptr_Ptr(S, Blk);
}


/// Adjusts a return value when the called function's return type does not
/// match the caller's expression type. This can happen when a dynamic call
/// is devirtualized, and the overridding method has a covariant (more specific)
/// return type than the parent's method. For C++ objects, this means we need
/// to add base casts.
//<editor-fold defaultstate="collapsed" desc="adjustReturnValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineCallAndReturn.cpp", line = 127,
 FQN="adjustReturnValue", NM="_ZL17adjustReturnValueN5clang4ento4SValENS_8QualTypeES2_RNS0_12StoreManagerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineCallAndReturn.cpp -nm=_ZL17adjustReturnValueN5clang4ento4SValENS_8QualTypeES2_RNS0_12StoreManagerE")
//</editor-fold>
public static SVal adjustReturnValue(SVal V, QualType ExpectedTy, QualType ActualTy, 
                 final StoreManager /*&*/ StoreMgr) {
  // For now, the only adjustments we handle apply only to locations.
  if (!V.getAs(Loc.class).$bool()) {
    return new SVal(JD$Move.INSTANCE, V);
  }
  
  // If the types already match, don't do any unnecessary work.
  ExpectedTy.$assignMove(ExpectedTy.getCanonicalType());
  ActualTy.$assignMove(ActualTy.getCanonicalType());
  if (QualType.$eq_QualType$C(ExpectedTy, ActualTy)) {
    return new SVal(JD$Move.INSTANCE, V);
  }
  
  // No adjustment is needed between Objective-C pointer types.
  if (ExpectedTy.$arrow().isObjCObjectPointerType()
     && ActualTy.$arrow().isObjCObjectPointerType()) {
    return new SVal(JD$Move.INSTANCE, V);
  }
  
  // C++ object pointers may need "derived-to-base" casts.
  /*const*/ CXXRecordDecl /*P*/ ExpectedClass = ExpectedTy.$arrow().getPointeeCXXRecordDecl();
  /*const*/ CXXRecordDecl /*P*/ ActualClass = ActualTy.$arrow().getPointeeCXXRecordDecl();
  if ((ExpectedClass != null) && (ActualClass != null)) {
    CXXBasePaths Paths = null;
    try {
      Paths/*J*/= new CXXBasePaths(/*FindAmbiguities=*/ true, /*RecordPaths=*/ true, 
          /*DetectVirtual=*/ false);
      if (ActualClass.isDerivedFrom(ExpectedClass, Paths)
         && !Paths.isAmbiguous(ActualTy.$arrow().getCanonicalTypeUnqualified())) {
        return StoreMgr.evalDerivedToBase(new SVal(V), Paths.front());
      }
    } finally {
      if (Paths != null) { Paths.$destroy(); }
    }
  }
  
  // Unfortunately, Objective-C does not enforce that overridden methods have
  // covariant return types, so we can't assert that that never happens.
  // Be safe and return UnknownVal().
  return new SVal(JD$Move.INSTANCE, new UnknownVal());
}

//<editor-fold defaultstate="collapsed" desc="wasDifferentDeclUsedForInlining">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineCallAndReturn.cpp", line = 186,
 FQN="wasDifferentDeclUsedForInlining", NM="_ZL31wasDifferentDeclUsedForInliningN5clang4ento12CallEventRefINS0_9CallEventEEEPKNS_17StackFrameContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineCallAndReturn.cpp -nm=_ZL31wasDifferentDeclUsedForInliningN5clang4ento12CallEventRefINS0_9CallEventEEEPKNS_17StackFrameContextE")
//</editor-fold>
public static boolean wasDifferentDeclUsedForInlining(CallEventRef<CallEvent> Call, 
                               /*const*/ StackFrameContext /*P*/ calleeCtx) {
  /*const*/ Decl /*P*/ RuntimeCallee = calleeCtx.getDecl();
  /*const*/ Decl /*P*/ StaticDecl = Call.$arrow().getDecl();
  assert Native.$bool(RuntimeCallee);
  if (!(StaticDecl != null)) {
    return true;
  }
  return RuntimeCallee.getCanonicalDecl$Const() != StaticDecl.getCanonicalDecl$Const();
}


/// Returns true if the CXXConstructExpr \p E was intended to construct a
/// prvalue for the region in \p V.
///
/// Note that we can't just test for rvalue vs. glvalue because
/// CXXConstructExprs embedded in DeclStmts and initializers are considered
/// rvalues by the AST, and the analyzer would like to treat them as lvalues.
//<editor-fold defaultstate="collapsed" desc="isTemporaryPRValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineCallAndReturn.cpp", line = 202,
 FQN="isTemporaryPRValue", NM="_ZL18isTemporaryPRValuePKN5clang16CXXConstructExprENS_4ento4SValE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineCallAndReturn.cpp -nm=_ZL18isTemporaryPRValuePKN5clang16CXXConstructExprENS_4ento4SValE")
//</editor-fold>
public static boolean isTemporaryPRValue(/*const*/ CXXConstructExpr /*P*/ E, SVal V) {
  if (E.isGLValue()) {
    return false;
  }
  
  /*const*/ MemRegion /*P*/ MR = V.getAsRegion();
  if (!(MR != null)) {
    return false;
  }
  
  return isa_CXXTempObjectRegion(MR);
}

//<editor-fold defaultstate="collapsed" desc="getInlineFailedState">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineCallAndReturn.cpp", line = 458,
 FQN="getInlineFailedState", NM="_ZL20getInlineFailedStateN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEEPKNS1_4StmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineCallAndReturn.cpp -nm=_ZL20getInlineFailedStateN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEEPKNS1_4StmtE")
//</editor-fold>
public static IntrusiveRefCntPtr</*const*/ ProgramState> getInlineFailedState(IntrusiveRefCntPtr</*const*/ ProgramState> State, 
                    /*const*/ Stmt /*P*/ CallE) {
  /*const*/Object/*void P*/ ReplayState = State.$arrow()./*<ReplayWithoutInlining>*/get(ProgramStateTraitReplayWithoutInlining.$Instance);
  if (!(ReplayState != null)) {
    return new IntrusiveRefCntPtr</*const*/ ProgramState>((/*const*/ ProgramState /*P*/ )null);
  }
  assert (ReplayState == CallE) : "Backtracked to the wrong call.";
  ///*J:(void)*/CallE;
  
  return State.$arrow()./*<ReplayWithoutInlining>*/remove(ProgramStateTraitReplayWithoutInlining.$Instance);
}

//<editor-fold defaultstate="collapsed" desc="mayInlineCallKind">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineCallAndReturn.cpp", line = 578,
 FQN="mayInlineCallKind", NM="_ZL17mayInlineCallKindRKN5clang4ento9CallEventEPKNS0_12ExplodedNodeERNS_15AnalyzerOptionsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineCallAndReturn.cpp -nm=_ZL17mayInlineCallKindRKN5clang4ento9CallEventEPKNS0_12ExplodedNodeERNS_15AnalyzerOptionsE")
//</editor-fold>
public static CallInlinePolicy mayInlineCallKind(final /*const*/ CallEvent /*&*/ Call, 
                 /*const*/ ExplodedNode /*P*/ Pred, 
                 final AnalyzerOptions /*&*/ Opts) {
  /*const*/ LocationContext /*P*/ CurLC = Pred.getLocationContext();
  /*const*/ StackFrameContext /*P*/ CallerSFC = CurLC.getCurrentStackFrame();
  switch (Call.getKind()) {
   case CE_Function:
   case CE_Block:
    break;
   case CE_CXXMember:
   case CE_CXXMemberOperator:
    if (!Opts.mayInlineCXXMemberFunction(CXXInlineableMemberKind.CIMK_MemberFunctions)) {
      return CallInlinePolicy.CIP_DisallowedAlways;
    }
    break;
   case CE_CXXConstructor:
    {
      if (!Opts.mayInlineCXXMemberFunction(CXXInlineableMemberKind.CIMK_Constructors)) {
        return CallInlinePolicy.CIP_DisallowedAlways;
      }
      
      final /*const*/ CXXConstructorCall /*&*/ Ctor = cast_CXXConstructorCall(Call);
      
      // FIXME: We don't handle constructors or destructors for arrays properly.
      // Even once we do, we still need to be careful about implicitly-generated
      // initializers for array fields in default move/copy constructors.
      /*const*/ MemRegion /*P*/ Target = Ctor.getCXXThisVal().getAsRegion();
      if ((Target != null) && isa_ElementRegion(Target)) {
        return CallInlinePolicy.CIP_DisallowedOnce;
      }
      
      // FIXME: This is a hack. We don't use the correct region for a new
      // expression, so if we inline the constructor its result will just be
      // thrown away. This short-term hack is tracked in <rdar://problem/12180598>
      // and the longer-term possible fix is discussed in PR12014.
      /*const*/ CXXConstructExpr /*P*/ CtorExpr = Ctor.getOriginExpr();
      {
        /*const*/ Stmt /*P*/ Parent = CurLC.getParentMap().getParent_Stmt$C$P(CtorExpr);
        if ((Parent != null)) {
          if (isa_CXXNewExpr(Parent)) {
            return CallInlinePolicy.CIP_DisallowedOnce;
          }
        }
      }
      
      // Inlining constructors requires including initializers in the CFG.
      /*const*/ AnalysisDeclContext /*P*/ ADC = CallerSFC.getAnalysisDeclContext();
      assert (ADC.getCFGBuildOptions$Const().AddInitializers) : "No CFG initializers";
      ///*J:(void)*/ADC;
      
      // If the destructor is trivial, it's always safe to inline the constructor.
      if (Ctor.getDecl().getParent$Const().hasTrivialDestructor()) {
        break;
      }
      
      // For other types, only inline constructors if destructor inlining is
      // also enabled.
      if (!Opts.mayInlineCXXMemberFunction(CXXInlineableMemberKind.CIMK_Destructors)) {
        return CallInlinePolicy.CIP_DisallowedAlways;
      }
      
      // FIXME: This is a hack. We don't handle temporary destructors
      // right now, so we shouldn't inline their constructors.
      if (CtorExpr.getConstructionKind() == CXXConstructExpr.ConstructionKind.CK_Complete) {
        if (!(Target != null) || !isa_DeclRegion(Target)) {
          return CallInlinePolicy.CIP_DisallowedOnce;
        }
      }
      
      break;
    }
   case CE_CXXDestructor:
    {
      if (!Opts.mayInlineCXXMemberFunction(CXXInlineableMemberKind.CIMK_Destructors)) {
        return CallInlinePolicy.CIP_DisallowedAlways;
      }
      
      // Inlining destructors requires building the CFG correctly.
      /*const*/ AnalysisDeclContext /*P*/ ADC = CallerSFC.getAnalysisDeclContext();
      assert (ADC.getCFGBuildOptions$Const().AddImplicitDtors) : "No CFG destructors";
      ///*J:(void)*/ADC;
      
      final /*const*/ CXXDestructorCall /*&*/ Dtor = cast_CXXDestructorCall(Call);
      
      // FIXME: We don't handle constructors or destructors for arrays properly.
      /*const*/ MemRegion /*P*/ Target = Dtor.getCXXThisVal().getAsRegion();
      if ((Target != null) && isa_ElementRegion(Target)) {
        return CallInlinePolicy.CIP_DisallowedOnce;
      }
      
      break;
    }
   case CE_CXXAllocator:
    if (Opts.mayInlineCXXAllocator()) {
      break;
    }
    // Do not inline allocators until we model deallocators.
    // This is unfortunate, but basically necessary for smart pointers and such.
    return CallInlinePolicy.CIP_DisallowedAlways;
   case CE_ObjCMessage:
    if (!Opts.mayInlineObjCMethod()) {
      return CallInlinePolicy.CIP_DisallowedAlways;
    }
    if (!(Opts.getIPAMode() == IPAKind.IPAK_DynamicDispatch
       || Opts.getIPAMode() == IPAKind.IPAK_DynamicDispatchBifurcate)) {
      return CallInlinePolicy.CIP_DisallowedAlways;
    }
    break;
  }
  
  return CallInlinePolicy.CIP_Allowed;
}


/// Returns true if the given C++ class contains a member with the given name.
//<editor-fold defaultstate="collapsed" desc="hasMember">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineCallAndReturn.cpp", line = 673,
 FQN="hasMember", NM="_ZL9hasMemberRKN5clang10ASTContextEPKNS_13CXXRecordDeclEN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineCallAndReturn.cpp -nm=_ZL9hasMemberRKN5clang10ASTContextEPKNS_13CXXRecordDeclEN4llvm9StringRefE")
//</editor-fold>
public static boolean hasMember(final /*const*/ ASTContext /*&*/ Ctx, /*const*/ CXXRecordDecl /*P*/ RD, 
         StringRef Name) {
  CXXBasePaths Paths = null;
  try {
    final /*const*/ IdentifierInfo /*&*/ II = Ctx.Idents.get(/*NO_COPY*/Name);
    DeclarationName DeclName = Ctx.DeclarationNames.getIdentifier($AddrOf(II));
    if (!RD.lookup(new DeclarationName(DeclName)).empty()) {
      return true;
    }
    
    Paths/*J*/= new CXXBasePaths(false, false, false);
    DeclarationName L$DeclName = DeclName;
    if (RD.lookupInBases(/*FuncArg*//*[=L$DeclName(DeclName)]*/ (/*const*/ CXXBaseSpecifier /*P*/ Specifier, final CXXBasePath /*&*/ Path) -> {
              return CXXRecordDecl.FindOrdinaryMember(Specifier, Path, new DeclarationName(L$DeclName));
            }, 
        Paths)) {
      return true;
    }
    
    return false;
  } finally {
    if (Paths != null) { Paths.$destroy(); }
  }
}


/// Returns true if the given C++ class is a container or iterator.
///
/// Our heuristic for this is whether it contains a method named 'begin()' or a
/// nested type named 'iterator' or 'iterator_category'.
//<editor-fold defaultstate="collapsed" desc="isContainerClass">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineCallAndReturn.cpp", line = 695,
 FQN="isContainerClass", NM="_ZL16isContainerClassRKN5clang10ASTContextEPKNS_13CXXRecordDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineCallAndReturn.cpp -nm=_ZL16isContainerClassRKN5clang10ASTContextEPKNS_13CXXRecordDeclE")
//</editor-fold>
public static boolean isContainerClass(final /*const*/ ASTContext /*&*/ Ctx, /*const*/ CXXRecordDecl /*P*/ RD) {
  return hasMember(Ctx, RD, new StringRef(/*KEEP_STR*/"begin"))
     || hasMember(Ctx, RD, new StringRef(/*KEEP_STR*/"iterator"))
     || hasMember(Ctx, RD, new StringRef(/*KEEP_STR*/"iterator_category"));
}


/// Returns true if the given function refers to a method of a C++ container
/// or iterator.
///
/// We generally do a poor job modeling most containers right now, and might
/// prefer not to inline their methods.
//<editor-fold defaultstate="collapsed" desc="isContainerMethod">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineCallAndReturn.cpp", line = 706,
 FQN="isContainerMethod", NM="_ZL17isContainerMethodRKN5clang10ASTContextEPKNS_12FunctionDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineCallAndReturn.cpp -nm=_ZL17isContainerMethodRKN5clang10ASTContextEPKNS_12FunctionDeclE")
//</editor-fold>
public static boolean isContainerMethod(final /*const*/ ASTContext /*&*/ Ctx, 
                 /*const*/ FunctionDecl /*P*/ FD) {
  {
    /*const*/ CXXMethodDecl /*P*/ MD = dyn_cast_CXXMethodDecl(FD);
    if ((MD != null)) {
      return isContainerClass(Ctx, MD.getParent$Const());
    }
  }
  return false;
}


/// Returns true if the given function is the destructor of a class named
/// "shared_ptr".
//<editor-fold defaultstate="collapsed" desc="isCXXSharedPtrDtor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineCallAndReturn.cpp", line = 715,
 FQN="isCXXSharedPtrDtor", NM="_ZL18isCXXSharedPtrDtorPKN5clang12FunctionDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineCallAndReturn.cpp -nm=_ZL18isCXXSharedPtrDtorPKN5clang12FunctionDeclE")
//</editor-fold>
public static boolean isCXXSharedPtrDtor(/*const*/ FunctionDecl /*P*/ FD) {
  /*const*/ CXXDestructorDecl /*P*/ Dtor = dyn_cast_CXXDestructorDecl(FD);
  if (!(Dtor != null)) {
    return false;
  }
  
  /*const*/ CXXRecordDecl /*P*/ RD = Dtor.getParent$Const();
  {
    /*const*/ IdentifierInfo /*P*/ II = RD.getDeclName().getAsIdentifierInfo();
    if ((II != null)) {
      if (II.isStr(/*KEEP_STR*/"shared_ptr")) {
        return true;
      }
    }
  }
  
  return false;
}


/// Returns true if the function in \p CalleeADC may be inlined in general.
///
/// This checks static properties of the function, such as its signature and
/// CFG, to determine whether the analyzer should ever consider inlining it,
/// in any context.
//<editor-fold defaultstate="collapsed" desc="mayInlineDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineCallAndReturn.cpp", line = 733,
 FQN="mayInlineDecl", NM="_ZL13mayInlineDeclPN5clang19AnalysisDeclContextERNS_15AnalyzerOptionsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineCallAndReturn.cpp -nm=_ZL13mayInlineDeclPN5clang19AnalysisDeclContextERNS_15AnalyzerOptionsE")
//</editor-fold>
public static boolean mayInlineDecl(AnalysisDeclContext /*P*/ CalleeADC, 
             final AnalyzerOptions /*&*/ Opts) {
  // FIXME: Do not inline variadic calls.
  if (CallEvent.isVariadic(CalleeADC.getDecl())) {
    return false;
  }
  
  // Check certain C++-related inlining policies.
  final ASTContext /*&*/ Ctx = CalleeADC.getASTContext();
  if (Ctx.getLangOpts().CPlusPlus) {
    {
      /*const*/ FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(CalleeADC.getDecl());
      if ((FD != null)) {
        // Conditionally control the inlining of template functions.
        if (!Opts.mayInlineTemplateFunctions()) {
          if (FD.getTemplatedKind() != FunctionDecl.TemplatedKind.TK_NonTemplate) {
            return false;
          }
        }
        
        // Conditionally control the inlining of C++ standard library functions.
        if (!Opts.mayInlineCXXStandardLibrary()) {
          if (Ctx.getSourceManager().isInSystemHeader(FD.getLocation())) {
            if (AnalysisDeclContext.isInStdNamespace(FD)) {
              return false;
            }
          }
        }
        
        // Conditionally control the inlining of methods on objects that look
        // like C++ containers.
        if (!Opts.mayInlineCXXContainerMethods()) {
          if (!Ctx.getSourceManager().isInMainFile(FD.getLocation())) {
            if (isContainerMethod(Ctx, FD)) {
              return false;
            }
          }
        }
        
        // Conditionally control the inlining of the destructor of C++ shared_ptr.
        // We don't currently do a good job modeling shared_ptr because we can't
        // see the reference count, so treating as opaque is probably the best
        // idea.
        if (!Opts.mayInlineCXXSharedPtrDtor()) {
          if (isCXXSharedPtrDtor(FD)) {
            return false;
          }
        }
      }
    }
  }
  
  // It is possible that the CFG cannot be constructed.
  // Be safe, and check if the CalleeCFG is valid.
  /*const*/ CFG /*P*/ CalleeCFG = CalleeADC.getCFG();
  if (!(CalleeCFG != null)) {
    return false;
  }
  
  // Do not inline large functions.
  if ($greater_uint(CalleeCFG.getNumBlockIDs(), Opts.getMaxInlinableSize())) {
    return false;
  }
  
  // It is possible that the live variables analysis cannot be
  // run.  If so, bail out.
  if (!(CalleeADC.<RelaxedLiveVariables>getAnalysis(RelaxedLiveVariables.class) != null)) {
    return false;
  }
  
  return true;
}

//<editor-fold defaultstate="collapsed" desc="isTrivialObjectAssignment">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineCallAndReturn.cpp", line = 876,
 FQN="isTrivialObjectAssignment", NM="_ZL25isTrivialObjectAssignmentRKN5clang4ento9CallEventE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExprEngineCallAndReturn.cpp -nm=_ZL25isTrivialObjectAssignmentRKN5clang4ento9CallEventE")
//</editor-fold>
public static boolean isTrivialObjectAssignment(final /*const*/ CallEvent /*&*/ Call) {
  /*const*/ CXXInstanceCall /*P*/ ICall = dyn_cast_CXXInstanceCall($AddrOf(Call));
  if (!(ICall != null)) {
    return false;
  }
  
  /*const*/ CXXMethodDecl /*P*/ MD = dyn_cast_or_null_CXXMethodDecl(ICall.getDecl());
  if (!(MD != null)) {
    return false;
  }
  if (!(MD.isCopyAssignmentOperator() || MD.isMoveAssignmentOperator())) {
    return false;
  }
  
  return MD.isTrivial();
}

} // END OF class ExprEngineCallAndReturnStatics
