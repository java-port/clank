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

import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.analysis.*;
import org.clang.basic.*;
import org.clang.staticanalyzer.checkers.ento.impl.*;
import org.clang.staticanalyzer.core.bugreporter.ento.*;
import org.clang.staticanalyzer.core.ento.*;
import org.clang.staticanalyzer.core.ento.check.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import static org.clang.staticanalyzer.java.StaticanalyzerRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstTypesRTTI.*;
import org.clang.staticanalyzer.checkers.ento.EntoGlobals;
import org.clang.staticanalyzer.java.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DynamicTypePropagation">
@Converted(kind = Converted.Kind.MANUAL,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DynamicTypePropagation.cpp", line = 50,
 FQN="(anonymous namespace)::DynamicTypePropagation", NM="_ZN12_GLOBAL__N_122DynamicTypePropagationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DynamicTypePropagation.cpp -nm=_ZN12_GLOBAL__N_122DynamicTypePropagationE")
//</editor-fold>
public class DynamicTypePropagation extends /*public*/ Checker/*<PreCall, PostCall, DeadSymbols, PostStmt<CastExpr>, PostStmt<CXXNewExpr>, PreObjCMessage, PostObjCMessage>*/ 
        implements org.clang.staticanalyzer.java.PreObjCMessageChecker, org.clang.staticanalyzer.java.PreCallChecker, org.clang.staticanalyzer.java.PostStmtChecker, org.clang.staticanalyzer.java.PostObjCMessageChecker, org.clang.staticanalyzer.java.PostCallChecker, org.clang.staticanalyzer.java.DeadSymbolsChecker, Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DynamicTypePropagation::getObjectTypeForAllocAndNew">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DynamicTypePropagation.cpp", line = 308,
   FQN="(anonymous namespace)::DynamicTypePropagation::getObjectTypeForAllocAndNew", NM="_ZNK12_GLOBAL__N_122DynamicTypePropagation27getObjectTypeForAllocAndNewEPKN5clang15ObjCMessageExprERNS1_4ento14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DynamicTypePropagation.cpp -nm=_ZNK12_GLOBAL__N_122DynamicTypePropagation27getObjectTypeForAllocAndNewEPKN5clang15ObjCMessageExprERNS1_4ento14CheckerContextE")
  //</editor-fold>
  private /*const*/ ObjCObjectType /*P*/ getObjectTypeForAllocAndNew(/*const*/ ObjCMessageExpr /*P*/ MsgE, 
                             final CheckerContext /*&*/ C) /*const*/ {
    if (MsgE.getReceiverKind() == ObjCMessageExpr.ReceiverKind.Class) {
      {
        /*const*/ ObjCObjectType /*P*/ ObjTy = MsgE.getClassReceiver().$arrow().getAs(ObjCObjectType.class);
        if ((ObjTy != null)) {
          return ObjTy;
        }
      }
    }
    if (MsgE.getReceiverKind() == ObjCMessageExpr.ReceiverKind.SuperClass) {
      {
        /*const*/ ObjCObjectType /*P*/ ObjTy = MsgE.getSuperType().$arrow().getAs(ObjCObjectType.class);
        if ((ObjTy != null)) {
          return ObjTy;
        }
      }
    }
    
    /*const*/ Expr /*P*/ RecE = MsgE.getInstanceReceiver$Const();
    if (!(RecE != null)) {
      return null;
    }
    
    RecE = RecE.IgnoreParenImpCasts$Const();
    {
      /*const*/ DeclRefExpr /*P*/ DRE = dyn_cast_DeclRefExpr(RecE);
      if ((DRE != null)) {
        /*const*/ StackFrameContext /*P*/ SFCtx = C.getStackFrame();
        // Are we calling [self alloc]? If this is self, get the type of the
        // enclosing ObjC class.
        if (DRE.getDecl$Const() == SFCtx.getSelfDecl()) {
          {
            /*const*/ ObjCMethodDecl /*P*/ MD = dyn_cast_ObjCMethodDecl(SFCtx.getDecl());
            if ((MD != null)) {
              {
                /*const*/ ObjCObjectType /*P*/ ObjTy = dyn_cast_ObjCObjectType(MD.getClassInterface$Const().getTypeForDecl());
                if ((ObjTy != null)) {
                  return ObjTy;
                }
              }
            }
          }
        }
      }
    }
    return null;
  }

  
  /// \brief Return a better dynamic type if one can be derived from the cast.
  
  // Return a better dynamic type if one can be derived from the cast.
  // Compare the current dynamic type of the region and the new type to which we
  // are casting. If the new type is lower in the inheritance hierarchy, pick it.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DynamicTypePropagation::getBetterObjCType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DynamicTypePropagation.cpp", line = 345,
   FQN="(anonymous namespace)::DynamicTypePropagation::getBetterObjCType", NM="_ZNK12_GLOBAL__N_122DynamicTypePropagation17getBetterObjCTypeEPKN5clang4ExprERNS1_4ento14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DynamicTypePropagation.cpp -nm=_ZNK12_GLOBAL__N_122DynamicTypePropagation17getBetterObjCTypeEPKN5clang4ExprERNS1_4ento14CheckerContextE")
  //</editor-fold>
  private /*const*/ ObjCObjectPointerType /*P*/ getBetterObjCType(/*const*/ Expr /*P*/ CastE, 
                   final CheckerContext /*&*/ C) /*const*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      /*const*/ MemRegion /*P*/ ToR = C.getSVal(CastE).getAsRegion();
      assert Native.$bool(ToR);
      
      // Get the old and new types.
      /*const*/ ObjCObjectPointerType /*P*/ NewTy = CastE.getType().$arrow().getAs(ObjCObjectPointerType.class);
      if (!(NewTy != null)) {
        return null;
      }
      QualType OldDTy = $c$.clean(EntoGlobals.getDynamicTypeInfo($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState())), ToR).getType());
      if (OldDTy.isNull()) {
        return NewTy;
      }
      /*const*/ ObjCObjectPointerType /*P*/ OldTy = OldDTy.$arrow().getAs(ObjCObjectPointerType.class);
      if (!(OldTy != null)) {
        return null;
      }
      
      // Id the old type is 'id', the new one is more precise.
      if (OldTy.isObjCIdType() && !NewTy.isObjCIdType()) {
        return NewTy;
      }
      
      // Return new if it's a subclass of old.
      /*const*/ ObjCInterfaceDecl /*P*/ ToI = NewTy.getInterfaceDecl();
      /*const*/ ObjCInterfaceDecl /*P*/ FromI = OldTy.getInterfaceDecl();
      if ((ToI != null) && (FromI != null) && FromI.isSuperClassOf(ToI)) {
        return NewTy;
      }
      
      return null;
    } finally {
      $c$.$destroy();
    }
  }

  
  
  /// TODO: Handle explicit casts.
  ///       Handle C++ casts.
  ///
  /// Precondition: the cast is between ObjCObjectPointers.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DynamicTypePropagation::dynamicTypePropagationOnCasts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DynamicTypePropagation.cpp", line = 277,
   FQN="(anonymous namespace)::DynamicTypePropagation::dynamicTypePropagationOnCasts", NM="_ZNK12_GLOBAL__N_122DynamicTypePropagation29dynamicTypePropagationOnCastsEPKN5clang8CastExprERN4llvm18IntrusiveRefCntPtrIKNS1_4ento12ProgramStateEEERNS7_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DynamicTypePropagation.cpp -nm=_ZNK12_GLOBAL__N_122DynamicTypePropagation29dynamicTypePropagationOnCastsEPKN5clang8CastExprERN4llvm18IntrusiveRefCntPtrIKNS1_4ento12ProgramStateEEERNS7_14CheckerContextE")
  //</editor-fold>
  private ExplodedNode /*P*/ dynamicTypePropagationOnCasts(/*const*/ CastExpr /*P*/ CE, final IntrusiveRefCntPtr</*const*/ ProgramState> /*&*/ State, final CheckerContext /*&*/ C) /*const*/ {
    // We only track type info for regions.
    /*const*/ MemRegion /*P*/ ToR = C.getSVal(CE).getAsRegion();
    if (!(ToR != null)) {
      return C.getPredecessor();
    }
    if (isa_ExplicitCastExpr(CE)) {
      return C.getPredecessor();
    }
    {
      
      /*const*/ Type /*P*/ NewTy = getBetterObjCType(CE, C);
      if ((NewTy != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean(State.$assign($c$.track(EntoGlobals.setDynamicTypeInfo($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), ToR, new QualType(NewTy, 0)))));
          return $c$.clean(C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))));
        } finally {
          $c$.$destroy();
        }
      }
    }
    return C.getPredecessor();
  }

  
  private /*mutable */std.unique_ptr<BugType> ObjCGenericsBugType;
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DynamicTypePropagation::initBugType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DynamicTypePropagation.cpp", line = 70,
   FQN="(anonymous namespace)::DynamicTypePropagation::initBugType", NM="_ZNK12_GLOBAL__N_122DynamicTypePropagation11initBugTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DynamicTypePropagation.cpp -nm=_ZNK12_GLOBAL__N_122DynamicTypePropagation11initBugTypeEv")
  //</editor-fold>
  private void initBugType() /*const*/ {
    if (!ObjCGenericsBugType.$bool()) {
      ObjCGenericsBugType.reset(new BugType(this, new StringRef(/*KEEP_STR*/"Generics"), new StringRef(categories.CoreFoundationObjectiveC)));
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DynamicTypePropagation::GenericsBugVisitor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DynamicTypePropagation.cpp", line = 76,
   FQN="(anonymous namespace)::DynamicTypePropagation::GenericsBugVisitor", NM="_ZN12_GLOBAL__N_122DynamicTypePropagation18GenericsBugVisitorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DynamicTypePropagation.cpp -nm=_ZN12_GLOBAL__N_122DynamicTypePropagation18GenericsBugVisitorE")
  //</editor-fold>
  private static class GenericsBugVisitor extends /*public*/ BugReporterVisitorImpl<GenericsBugVisitor> implements Destructors.ClassWithDestructor {
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DynamicTypePropagation::GenericsBugVisitor::GenericsBugVisitor">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DynamicTypePropagation.cpp", line = 78,
     FQN="(anonymous namespace)::DynamicTypePropagation::GenericsBugVisitor::GenericsBugVisitor", NM="_ZN12_GLOBAL__N_122DynamicTypePropagation18GenericsBugVisitorC1EPKN5clang4ento7SymExprE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DynamicTypePropagation.cpp -nm=_ZN12_GLOBAL__N_122DynamicTypePropagation18GenericsBugVisitorC1EPKN5clang4ento7SymExprE")
    //</editor-fold>
    public GenericsBugVisitor(/*const*/ SymExpr /*P*/ S) {
      // : BugReporterVisitorImpl<GenericsBugVisitor>(), Sym(S) 
      //START JInit
      super();
      this.Sym = S;
      //END JInit
    }

    
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DynamicTypePropagation::GenericsBugVisitor::Profile">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DynamicTypePropagation.cpp", line = 80,
     FQN="(anonymous namespace)::DynamicTypePropagation::GenericsBugVisitor::Profile", NM="_ZNK12_GLOBAL__N_122DynamicTypePropagation18GenericsBugVisitor7ProfileERN4llvm16FoldingSetNodeIDE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DynamicTypePropagation.cpp -nm=_ZNK12_GLOBAL__N_122DynamicTypePropagation18GenericsBugVisitor7ProfileERN4llvm16FoldingSetNodeIDE")
    //</editor-fold>
    @Override public void Profile(final FoldingSetNodeID /*&*/ ID) /*const*//* override*/ {
      final/*static*/ Object X = Profile$$.X;
      ID.AddPointer($AddrOf(X));
      ID.AddPointer(Sym);
    }
    private static final class Profile$$ {
      static final/*static*/ Object X = GenericsBugVisitor.class;
    }

    
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DynamicTypePropagation::GenericsBugVisitor::VisitNode">
    @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DynamicTypePropagation.cpp", line = 895,
     FQN="(anonymous namespace)::DynamicTypePropagation::GenericsBugVisitor::VisitNode", NM="_ZN12_GLOBAL__N_122DynamicTypePropagation18GenericsBugVisitor9VisitNodeEPKN5clang4ento12ExplodedNodeES6_RNS3_18BugReporterContextERNS3_9BugReportE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DynamicTypePropagation.cpp -nm=_ZN12_GLOBAL__N_122DynamicTypePropagation18GenericsBugVisitor9VisitNodeEPKN5clang4ento12ExplodedNodeES6_RNS3_18BugReporterContextERNS3_9BugReportE")
    //</editor-fold>
    @Override public PathDiagnosticPiece /*P*/ VisitNode(/*const*/ ExplodedNode /*P*/ N, /*const*/ ExplodedNode /*P*/ PrevN, final BugReporterContext /*&*/ BRC, 
             final BugReport /*&*/ BR)/* override*/ {
      IntrusiveRefCntPtr</*const*/ ProgramState> state = null;
      IntrusiveRefCntPtr</*const*/ ProgramState> statePrev = null;
      raw_svector_ostream OS = null;
      try {
        state = new IntrusiveRefCntPtr</*const*/ ProgramState>(N.getState());
        statePrev = new IntrusiveRefCntPtr</*const*/ ProgramState>(PrevN.getState());
        
        type$ptr</*const*/ ObjCObjectPointerType /*P*/ /*const*/ /*P*/> TrackedType = state.$arrow()./*<MostSpecializedTypeArgsMap>*/get(ProgramStateTraitMostSpecializedTypeArgsMap.$Instance, Sym);
        type$ptr</*const*/ ObjCObjectPointerType /*P*/ /*const*/ /*P*/> TrackedTypePrev = statePrev.$arrow()./*<MostSpecializedTypeArgsMap>*/get(ProgramStateTraitMostSpecializedTypeArgsMap.$Instance, Sym);
        if (!/*JAVA*/(TrackedType != null)) {
          return null;
        }
        if (/*JAVA*/(TrackedTypePrev != null) && TrackedTypePrev.$star() == TrackedType.$star()) {
          return null;
        }
        
        // Retrieve the associated statement.
        /*const*/ Stmt /*P*/ S = null;
        ProgramPoint ProgLoc = N.getLocation();
        {
          Optional<StmtPoint> SP = ProgLoc.getAs(StmtPoint.class);
          if (SP.$bool()) {
            S = SP.$arrow().getStmt();
          }
        }
        if (!(S != null)) {
          return null;
        }
        
        final /*const*/ LangOptions /*&*/ LangOpts = BRC.getASTContext().getLangOpts();
        
        SmallString/*<256>*/ Buf/*J*/= new SmallString/*<256>*/(256);
        OS/*J*/= new raw_svector_ostream(Buf);
        OS.$out(/*KEEP_STR*/"Type '");
        QualType.print(TrackedType.$star(), new Qualifiers(), OS, new PrintingPolicy(LangOpts), new Twine());
        OS.$out(/*KEEP_STR*/"' is inferred from ");
        {
          
          /*const*/ ExplicitCastExpr /*P*/ ExplicitCast = dyn_cast_ExplicitCastExpr(S);
          if ((ExplicitCast != null)) {
            OS.$out(/*KEEP_STR*/"explicit cast (from '");
            QualType.print(ExplicitCast.getSubExpr$Const().getType().getTypePtr(), 
                new Qualifiers(), OS, new PrintingPolicy(LangOpts), new Twine());
            OS.$out(/*KEEP_STR*/"' to '");
            QualType.print(ExplicitCast.getType().getTypePtr(), new Qualifiers(), OS, 
                new PrintingPolicy(LangOpts), new Twine());
            OS.$out(/*KEEP_STR*/"')");
          } else {
            /*const*/ ImplicitCastExpr /*P*/ ImplicitCast = dyn_cast_ImplicitCastExpr(S);
            if ((ImplicitCast != null)) {
              OS.$out(/*KEEP_STR*/"implicit cast (from '");
              QualType.print(ImplicitCast.getSubExpr$Const().getType().getTypePtr(), 
                  new Qualifiers(), OS, new PrintingPolicy(LangOpts), new Twine());
              OS.$out(/*KEEP_STR*/"' to '");
              QualType.print(ImplicitCast.getType().getTypePtr(), new Qualifiers(), OS, 
                  new PrintingPolicy(LangOpts), new Twine());
              OS.$out(/*KEEP_STR*/"')");
            } else {
              OS.$out(/*KEEP_STR*/"this context");
            }
          }
        }
        
        // Generate the extra diagnostic.
        PathDiagnosticLocation Pos/*J*/= new PathDiagnosticLocation(S, BRC.getSourceManager(), 
            new PointerUnion</*const*/ LocationContext /*P*/ , AnalysisDeclContext /*P*/ >(JD$T.INSTANCE, /*const*/ LocationContext /*P*/.class, N.getLocationContext()));
        return new PathDiagnosticEventPiece(Pos, OS.str(), true, (StackHintGenerator /*P*/ )null);
      } finally {
        if (OS != null) { OS.$destroy(); }
        if (statePrev != null) { statePrev.$destroy(); }
        if (state != null) { state.$destroy(); }
      }
    }

  /*private:*/
    // The tracked symbol.
    private /*const*/ SymExpr /*P*/ Sym;
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DynamicTypePropagation::GenericsBugVisitor::~GenericsBugVisitor">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DynamicTypePropagation.cpp", line = 76,
     FQN="(anonymous namespace)::DynamicTypePropagation::GenericsBugVisitor::~GenericsBugVisitor", NM="_ZN12_GLOBAL__N_122DynamicTypePropagation18GenericsBugVisitorD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DynamicTypePropagation.cpp -nm=_ZN12_GLOBAL__N_122DynamicTypePropagation18GenericsBugVisitorD0Ev")
    //</editor-fold>
    @Override public /*inline*/ void $destroy() {
      super.$destroy();
    }

    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DynamicTypePropagation::GenericsBugVisitor::GenericsBugVisitor">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DynamicTypePropagation.cpp", line = 76,
     FQN="(anonymous namespace)::DynamicTypePropagation::GenericsBugVisitor::GenericsBugVisitor", NM="_ZN12_GLOBAL__N_122DynamicTypePropagation18GenericsBugVisitorC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DynamicTypePropagation.cpp -nm=_ZN12_GLOBAL__N_122DynamicTypePropagation18GenericsBugVisitorC1ERKS1_")
    //</editor-fold>
    public /*inline*/ GenericsBugVisitor(final /*const*/ GenericsBugVisitor /*&*/ $Prm0) {
      // : BugReporterVisitorImpl<GenericsBugVisitor>(), Sym(.Sym) 
      //START JInit
      super($Prm0);
      this.Sym = $Prm0.Sym;
      //END JInit
    }

    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN

    @Override public GenericsBugVisitor clone() {
      return new GenericsBugVisitor(this);
    }
    

    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////
    
    @Override public String toString() {
      return "" + "Sym=" + "[SymExpr]" // NOI18N
                + super.toString(); // NOI18N
    }
  };
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DynamicTypePropagation::reportGenericsBug">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DynamicTypePropagation.cpp", line = 871,
   FQN="(anonymous namespace)::DynamicTypePropagation::reportGenericsBug", NM="_ZNK12_GLOBAL__N_122DynamicTypePropagation17reportGenericsBugEPKN5clang21ObjCObjectPointerTypeES4_PNS1_4ento12ExplodedNodeEPKNS5_7SymExprERNS5_14CheckerContextEPKNS1_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DynamicTypePropagation.cpp -nm=_ZNK12_GLOBAL__N_122DynamicTypePropagation17reportGenericsBugEPKN5clang21ObjCObjectPointerTypeES4_PNS1_4ento12ExplodedNodeEPKNS5_7SymExprERNS5_14CheckerContextEPKNS1_4StmtE")
  //</editor-fold>
  private void reportGenericsBug(/*const*/ ObjCObjectPointerType /*P*/ From, /*const*/ ObjCObjectPointerType /*P*/ To, 
                   ExplodedNode /*P*/ N, /*const*/ SymExpr /*P*/ Sym, final CheckerContext /*&*/ C) /*const*/ {
    reportGenericsBug(From, To, 
                   N, Sym, C, 
                   (/*const*/ Stmt /*P*/ )null);
  }
  private void reportGenericsBug(/*const*/ ObjCObjectPointerType /*P*/ From, /*const*/ ObjCObjectPointerType /*P*/ To, 
                   ExplodedNode /*P*/ N, /*const*/ SymExpr /*P*/ Sym, final CheckerContext /*&*/ C, 
                   /*const*/ Stmt /*P*/ ReportedNode/*= null*/) /*const*/ {
    raw_svector_ostream OS = null;
    std.unique_ptr<BugReport> R = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      if (!CheckGenerics.$ConstBoolRef()) {
        return;
      }
      
      initBugType();
      SmallString/*<192>*/ Buf/*J*/= new SmallString/*<192>*/(192);
      OS/*J*/= new raw_svector_ostream(Buf);
      OS.$out(/*KEEP_STR*/"Conversion from value of type '");
      QualType.print(From, new Qualifiers(), OS, new PrintingPolicy(C.getLangOpts()), new Twine());
      OS.$out(/*KEEP_STR*/"' to incompatible type '");
      QualType.print(To, new Qualifiers(), OS, new PrintingPolicy(C.getLangOpts()), new Twine());
      OS.$out(/*KEEP_STR*/$SGL_QUOTE);
      R/*J*/= new std.unique_ptr<BugReport>(new BugReport(ObjCGenericsBugType.$star(), OS.str(), N));
      R.$arrow().markInteresting(Sym);
      R.$arrow().addVisitor($c$.track(new std.unique_ptr<BugReporterVisitor>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(llvm.make_unique(new GenericsBugVisitor(Sym)))))); $c$.clean();
      if ((ReportedNode != null)) {
        R.$arrow().addRange(ReportedNode.getSourceRange());
      }
      C.emitReport($c$.track(new std.unique_ptr<BugReport>(JD$Move.INSTANCE, std.move(R)))); $c$.clean();
    } finally {
      if (R != null) { R.$destroy(); }
      if (OS != null) { OS.$destroy(); }
      $c$.$destroy();
    }
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DynamicTypePropagation::checkPreCall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DynamicTypePropagation.cpp", line = 157,
   FQN="(anonymous namespace)::DynamicTypePropagation::checkPreCall", NM="_ZNK12_GLOBAL__N_122DynamicTypePropagation12checkPreCallERKN5clang4ento9CallEventERNS2_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DynamicTypePropagation.cpp -nm=_ZNK12_GLOBAL__N_122DynamicTypePropagation12checkPreCallERKN5clang4ento9CallEventERNS2_14CheckerContextE")
  //</editor-fold>
  public void checkPreCall(final /*const*/ CallEvent /*&*/ Call, 
              final CheckerContext /*&*/ C) /*const*/ {
    {
      /*const*/ CXXConstructorCall /*P*/ Ctor = dyn_cast_CXXConstructorCall($AddrOf(Call));
      if ((Ctor != null)) {
        // C++11 [class.cdtor]p4: When a virtual function is called directly or
        //   indirectly from a constructor or from a destructor, including during
        //   the construction or destruction of the class's non-static data members,
        //   and the object to which the call applies is the object under
        //   construction or destruction, the function called is the final overrider
        //   in the constructor's or destructor's class and not one overriding it in
        //   a more-derived class.
        switch (Ctor.getOriginExpr().getConstructionKind()) {
         case CK_Complete:
         case CK_Delegating:
          // No additional type info necessary.
          return;
         case CK_NonVirtualBase:
         case CK_VirtualBase:
          {
            /*const*/ MemRegion /*P*/ Target = Ctor.getCXXThisVal().getAsRegion();
            if ((Target != null)) {
              DynamicTypePropagationStatics.recordFixedType(Target, Ctor.getDecl(), C);
            }
          }
          return;
        }
        
        return;
      }
    }
    {
      
      /*const*/ CXXDestructorCall /*P*/ Dtor = dyn_cast_CXXDestructorCall($AddrOf(Call));
      if ((Dtor != null)) {
        // C++11 [class.cdtor]p4 (see above)
        if (!Dtor.isBaseDestructor()) {
          return;
        }
        
        /*const*/ MemRegion /*P*/ Target = Dtor.getCXXThisVal().getAsRegion();
        if (!(Target != null)) {
          return;
        }
        
        /*const*/ Decl /*P*/ D = Dtor.getDecl();
        if (!(D != null)) {
          return;
        }
        
        DynamicTypePropagationStatics.recordFixedType(Target, cast_CXXDestructorDecl(D), C);
        return;
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DynamicTypePropagation::checkPostCall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DynamicTypePropagation.cpp", line = 201,
   FQN="(anonymous namespace)::DynamicTypePropagation::checkPostCall", NM="_ZNK12_GLOBAL__N_122DynamicTypePropagation13checkPostCallERKN5clang4ento9CallEventERNS2_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DynamicTypePropagation.cpp -nm=_ZNK12_GLOBAL__N_122DynamicTypePropagation13checkPostCallERKN5clang4ento9CallEventERNS2_14CheckerContextE")
  //</editor-fold>
  public void checkPostCall(final /*const*/ CallEvent /*&*/ Call, 
               final CheckerContext /*&*/ C) /*const*/ {
    {
      // We can obtain perfect type info for return values from some calls.
      /*const*/ ObjCMethodCall /*P*/ Msg = dyn_cast_ObjCMethodCall($AddrOf(Call));
      if ((Msg != null)) {
        IntrusiveRefCntPtr</*const*/ ProgramState> State = null;
        try {
          
          // Get the returned value if it's a region.
          /*const*/ MemRegion /*P*/ RetReg = Call.getReturnValue().getAsRegion();
          if (!(RetReg != null)) {
            return;
          }
          
          State = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
          /*const*/ ObjCMethodDecl /*P*/ D = Msg.getDecl();
          if ((D != null) && D.hasRelatedResultType()) {
            switch (Msg.getMethodFamily()) {
             default:
              break;
             case OMF_alloc:
             case OMF_new:
              {
                JavaCleaner $c$ = $createJavaCleaner();
                try {
                  // Get the type of object that will get created.
                  /*const*/ ObjCMessageExpr /*P*/ MsgE = Msg.getOriginExpr();
                  /*const*/ ObjCObjectType /*P*/ ObjTy = getObjectTypeForAllocAndNew(MsgE, C);
                  if (!(ObjTy != null)) {
                    return;
                  }
                  QualType DynResTy = C.getASTContext().getObjCObjectPointerType(new QualType(ObjTy, 0));
                  $c$.clean(C.addTransition($c$.track(EntoGlobals.setDynamicTypeInfo($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), RetReg, new QualType(DynResTy), false))));
                  break;
                } finally {
                  $c$.$destroy();
                }
              }
             case OMF_init:
              {
                JavaCleaner $c$ = $createJavaCleaner();
                try {
                  // Assume, the result of the init method has the same dynamic type as
                  // the receiver and propagate the dynamic type info.
                  /*const*/ MemRegion /*P*/ RecReg = Msg.getReceiverSVal().getAsRegion();
                  if (!(RecReg != null)) {
                    return;
                  }
                  DynamicTypeInfo RecDynType = $c$.clean(EntoGlobals.getDynamicTypeInfo($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), RecReg));
                  $c$.clean(C.addTransition($c$.track(EntoGlobals.setDynamicTypeInfo($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), RetReg, new DynamicTypeInfo(RecDynType)))));
                  break;
                } finally {
                  $c$.$destroy();
                }
              }
            }
          }
          return;
        } finally {
          if (State != null) { State.$destroy(); }
        }
      }
    }
    {
      
      /*const*/ CXXConstructorCall /*P*/ Ctor = dyn_cast_CXXConstructorCall($AddrOf(Call));
      if ((Ctor != null)) {
        // We may need to undo the effects of our pre-call check.
        switch (Ctor.getOriginExpr().getConstructionKind()) {
         case CK_Complete:
         case CK_Delegating:
          // No additional work necessary.
          // Note: This will leave behind the actual type of the object for
          // complete constructors, but arguably that's a good thing, since it
          // means the dynamic type info will be correct even for objects
          // constructed with operator new.
          return;
         case CK_NonVirtualBase:
         case CK_VirtualBase:
          {
            /*const*/ MemRegion /*P*/ Target = Ctor.getCXXThisVal().getAsRegion();
            if ((Target != null)) {
              // We just finished a base constructor. Now we can use the subclass's
              // type when resolving virtual calls.
              /*const*/ Decl /*P*/ D = C.getLocationContext().getDecl();
              DynamicTypePropagationStatics.recordFixedType(Target, cast_CXXConstructorDecl(D), C);
            }
          }
          return;
        }
      }
    }
  }

  
  /// Type inference based on static type information that is available for the
  /// cast and the tracked type information for the given symbol. When the tracked
  /// symbol and the destination type of the cast are unrelated, report an error.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DynamicTypePropagation::checkPostStmt">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*IllegalConv function-local static var is context dependent*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DynamicTypePropagation.cpp", line = 522,
   FQN="(anonymous namespace)::DynamicTypePropagation::checkPostStmt", NM="_ZNK12_GLOBAL__N_122DynamicTypePropagation13checkPostStmtEPKN5clang8CastExprERNS1_4ento14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DynamicTypePropagation.cpp -nm=_ZNK12_GLOBAL__N_122DynamicTypePropagation13checkPostStmtEPKN5clang8CastExprERNS1_4ento14CheckerContextE")
  //</editor-fold>
  public void checkPostStmt(/*const*/ CastExpr /*P*/ CE, 
               final CheckerContext /*&*/ C) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> State = null;
    try {
      if (CE.getCastKind() != CastKind.CK_BitCast) {
        return;
      }
      
      QualType OriginType = CE.getSubExpr$Const().getType();
      QualType DestType = CE.getType();
      
      /*const*/ ObjCObjectPointerType /*P*/ OrigObjectPtrType = OriginType.$arrow().getAs(ObjCObjectPointerType.class);
      /*const*/ ObjCObjectPointerType /*P*/ DestObjectPtrType = DestType.$arrow().getAs(ObjCObjectPointerType.class);
      if (!(OrigObjectPtrType != null) || !(DestObjectPtrType != null)) {
        return;
      }
      
      State = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
      ExplodedNode /*P*/ AfterTypeProp = dynamicTypePropagationOnCasts(CE, State, C);
      
      final ASTContext /*&*/ ASTCtxt = C.getASTContext();
      
      // This checker detects the subtyping relationships using the assignment
      // rules. In order to be able to do this the kindofness must be stripped
      // first. The checker treats every type as kindof type anyways: when the
      // tracked type is the subtype of the static type it tries to look up the
      // methods in the tracked type first.
      OrigObjectPtrType = OrigObjectPtrType.stripObjCKindOfTypeAndQuals(ASTCtxt);
      DestObjectPtrType = DestObjectPtrType.stripObjCKindOfTypeAndQuals(ASTCtxt);
      
      // TODO: erase tracked information when there is a cast to unrelated type
      //       and everything is unspecialized statically.
      if (OrigObjectPtrType.isUnspecialized()
         && DestObjectPtrType.isUnspecialized()) {
        return;
      }
      
      /*const*/ SymExpr /*P*/ Sym = State.$arrow().getSVal(CE, C.getLocationContext()).getAsSymbol();
      if (!(Sym != null)) {
        return;
      }
      
      // Check which assignments are legal.
      boolean OrigToDest = ASTCtxt.canAssignObjCInterfaces(DestObjectPtrType, OrigObjectPtrType);
      boolean DestToOrig = ASTCtxt.canAssignObjCInterfaces(OrigObjectPtrType, DestObjectPtrType);
      type$ptr</*const*/ ObjCObjectPointerType /*P*/ /*const*/ /*P*/> TrackedType = State.$arrow()./*<MostSpecializedTypeArgsMap>*/get(ProgramStateTraitMostSpecializedTypeArgsMap.$Instance, Sym);
      
      // Downcasts and upcasts handled in an uniform way regardless of being
      // explicit. Explicit casts however can happen between mismatched types.
      if (isa_ExplicitCastExpr(CE) && !OrigToDest && !DestToOrig) {
        // Mismatched types. If the DestType specialized, store it. Forget the
        // tracked type otherwise.
        if (DestObjectPtrType.isSpecialized()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean(State.$assign($c$.track(State.$arrow()./*<MostSpecializedTypeArgsMap>*/set(ProgramStateTraitMostSpecializedTypeArgsMap.$Instance, Sym, DestObjectPtrType))));
            $c$.clean(C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), AfterTypeProp));
          } finally {
            $c$.$destroy();
          }
        } else if (/*JAVA*/(TrackedType != null)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean(State.$assign($c$.track(State.$arrow()./*<MostSpecializedTypeArgsMap>*/remove(ProgramStateTraitMostSpecializedTypeArgsMap.$Instance, Sym))));
            $c$.clean(C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), AfterTypeProp));
          } finally {
            $c$.$destroy();
          }
        }
        return;
      }
      
      // The tracked type should be the sub or super class of the static destination
      // type. When an (implicit) upcast or a downcast happens according to static
      // types, and there is no subtyping relationship between the tracked and the
      // static destination types, it indicates an error.
      if (/*JAVA*/(TrackedType != null)
         && !ASTCtxt.canAssignObjCInterfaces(DestObjectPtrType, TrackedType.$star())
         && !ASTCtxt.canAssignObjCInterfaces(TrackedType.$star(), DestObjectPtrType)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // JAVA: need to use accessor
          final/*static*/ CheckerProgramPointTag IllegalConv = checkPostStmt$$.IllegalConv();
          ExplodedNode /*P*/ N = $c$.clean(C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), AfterTypeProp, $AddrOf(IllegalConv)));
          reportGenericsBug(TrackedType.$star(), DestObjectPtrType, N, Sym, C);
          return;
        } finally {
          $c$.$destroy();
        }
      }
      
      // Handle downcasts and upcasts.
      /*const*/ ObjCObjectPointerType /*P*/ LowerBound = DestObjectPtrType;
      /*const*/ ObjCObjectPointerType /*P*/ UpperBound = OrigObjectPtrType;
      if (OrigToDest && !DestToOrig) {
        // JAVA: std.swap(LowerBound, UpperBound);
        /*const*/ ObjCObjectPointerType /*P*/ $tmp = LowerBound;
        UpperBound = LowerBound;
        LowerBound = $tmp;
      }
      
      // The id type is not a real bound. Eliminate it.
      LowerBound = LowerBound.isObjCIdType() ? UpperBound : LowerBound;
      UpperBound = UpperBound.isObjCIdType() ? LowerBound : UpperBound;
      if (DynamicTypePropagationStatics.storeWhenMoreInformative(State, Sym, TrackedType, LowerBound, UpperBound, 
          ASTCtxt)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean(C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), AfterTypeProp));
        } finally {
          $c$.$destroy();
        }
      }
    } finally {
      if (State != null) { State.$destroy(); }
    }
  }
  // MANUAL: moved below in extra members
//  private static final class checkPostStmt$$ {
//    // JAVA: must not be static!
//    static final /*static*/ CheckerProgramPointTag IllegalConv;
//  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DynamicTypePropagation::checkPostStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DynamicTypePropagation.cpp", line = 294,
   FQN="(anonymous namespace)::DynamicTypePropagation::checkPostStmt", NM="_ZNK12_GLOBAL__N_122DynamicTypePropagation13checkPostStmtEPKN5clang10CXXNewExprERNS1_4ento14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DynamicTypePropagation.cpp -nm=_ZNK12_GLOBAL__N_122DynamicTypePropagation13checkPostStmtEPKN5clang10CXXNewExprERNS1_4ento14CheckerContextE")
  //</editor-fold>
  public void checkPostStmt(/*const*/ CXXNewExpr /*P*/ NewE, 
               final CheckerContext /*&*/ C) /*const*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      if (NewE.isArray()) {
        return;
      }
      
      // We only track dynamic type info for regions.
      /*const*/ MemRegion /*P*/ MR = C.getSVal(NewE).getAsRegion();
      if (!(MR != null)) {
        return;
      }
      
      $c$.clean(C.addTransition($c$.track(EntoGlobals.setDynamicTypeInfo($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState())), MR, NewE.getType(), 
              /*CanBeSubclass=*/ false))));
    } finally {
      $c$.$destroy();
    }
  }

  // end anonymous namespace
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DynamicTypePropagation::checkDeadSymbols">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DynamicTypePropagation.cpp", line = 115,
   FQN="(anonymous namespace)::DynamicTypePropagation::checkDeadSymbols", NM="_ZNK12_GLOBAL__N_122DynamicTypePropagation16checkDeadSymbolsERN5clang4ento12SymbolReaperERNS2_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DynamicTypePropagation.cpp -nm=_ZNK12_GLOBAL__N_122DynamicTypePropagation16checkDeadSymbolsERN5clang4ento12SymbolReaperERNS2_14CheckerContextE")
  //</editor-fold>
  public void checkDeadSymbols(final SymbolReaper /*&*/ SR, 
                  final CheckerContext /*&*/ C) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> State = null;
    ImmutableMapPtrType</*const*/ MemRegion /*P*/ , DynamicTypeInfo> TypeMap = null;
    ImmutableMapPtrPtr</*const*/ SymExpr /*P*/ , /*const*/ ObjCObjectPointerType /*P*/ > TyArgMap = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      State = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
      TypeMap = State.$arrow()./*<DynamicTypeMap>*/get(ProgramStateTraitDynamicTypeMap.$Instance);
      ImmutableMapPtrType.iterator</*const*/ MemRegion /*P*/ , DynamicTypeInfo> I = null;
      ImmutableMapPtrType.iterator</*const*/ MemRegion /*P*/ , DynamicTypeInfo> E = null;
      try {
        for (I = TypeMap.begin(), E = TypeMap.end();
             I.$noteq(E); I.$preInc()) {
          if (!SR.isLiveRegion(I.$arrow().first)) {
            $c$.clean(State.$assign($c$.track(State.$arrow()./*<DynamicTypeMap>*/remove(ProgramStateTraitDynamicTypeMap.$Instance, I.$arrow().first))));
          }
        }
      } finally {
        if (E != null) { E.$destroy(); }
        if (I != null) { I.$destroy(); }
      }
      if (!SR.hasDeadSymbols()) {
        $c$.clean(C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))));
        return;
      }
      
      TyArgMap = State.$arrow()./*<MostSpecializedTypeArgsMap>*/get(ProgramStateTraitMostSpecializedTypeArgsMap.$Instance);
      ImmutableMapPtrPtr.iterator</*const*/ SymExpr /*P*/ , /*const*/ ObjCObjectPointerType /*P*/ > I2 = null;
      ImmutableMapPtrPtr.iterator</*const*/ SymExpr /*P*/ , /*const*/ ObjCObjectPointerType /*P*/ > E2 = null;
      try {
        for (I2 = TyArgMap.begin(), 
            E2 = TyArgMap.end();
             I2.$noteq(E2); I2.$preInc()) {
          if (SR.isDead(I2.$arrow().first)) {
            $c$.clean(State.$assign($c$.track(State.$arrow()./*<MostSpecializedTypeArgsMap>*/remove(ProgramStateTraitMostSpecializedTypeArgsMap.$Instance, I2.$arrow().first))));
          }
        }
      } finally {
        if (E2 != null) { E2.$destroy(); }
        if (I2 != null) { I2.$destroy(); }
      }
      
      $c$.clean(C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))));
    } finally {
      if (TyArgMap != null) { TyArgMap.$destroy(); }
      if (TypeMap != null) { TypeMap.$destroy(); }
      if (State != null) { State.$destroy(); }
      $c$.$destroy();
    }
  }

  
  /// When the receiver has a tracked type, use that type to validate the
  /// argumments of the message expression and the return value.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DynamicTypePropagation::checkPreObjCMessage">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*Tag is context dependent*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DynamicTypePropagation.cpp", line = 706,
   FQN="(anonymous namespace)::DynamicTypePropagation::checkPreObjCMessage", NM="_ZNK12_GLOBAL__N_122DynamicTypePropagation19checkPreObjCMessageERKN5clang4ento14ObjCMethodCallERNS2_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DynamicTypePropagation.cpp -nm=_ZNK12_GLOBAL__N_122DynamicTypePropagation19checkPreObjCMessageERKN5clang4ento14ObjCMethodCallERNS2_14CheckerContextE")
  //</editor-fold>
  public void checkPreObjCMessage(final /*const*/ ObjCMethodCall /*&*/ M, 
                     final CheckerContext /*&*/ C) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> State = null;
    try {
      State = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
      /*const*/ SymExpr /*P*/ Sym = M.getReceiverSVal().getAsSymbol();
      if (!(Sym != null)) {
        return;
      }
      
      type$ptr</*const*/ ObjCObjectPointerType /*P*/ /*const*/ /*P*/> TrackedType = State.$arrow()./*<MostSpecializedTypeArgsMap>*/get(ProgramStateTraitMostSpecializedTypeArgsMap.$Instance, Sym);
      if (!/*JAVA*/(TrackedType != null)) {
        return;
      }
      
      // Get the type arguments from tracked type and substitute type arguments
      // before do the semantic check.
      final ASTContext /*&*/ ASTCtxt = C.getASTContext();
      /*const*/ ObjCMessageExpr /*P*/ MessageExpr = M.getOriginExpr();
      /*const*/ ObjCMethodDecl /*P*/ Method = DynamicTypePropagationStatics.findMethodDecl(MessageExpr, TrackedType.$star(), ASTCtxt);
      
      // It is possible to call non-existent methods in Obj-C.
      if (!(Method != null)) {
        return;
      }
      
      Optional<ArrayRef<QualType> > TypeArgs = (TrackedType.$star()).getObjCSubstitutions(Method.getDeclContext$Const());
      // This case might happen when there is an unspecialized override of a
      // specialized method.
      if (!TypeArgs.$bool()) {
        return;
      }
      
      for (/*uint*/int i = 0; $less_uint(i, Method.param_size()); i++) {
        /*const*/ Expr /*P*/ Arg = MessageExpr.getArg$Const(i);
        /*const*/ ParmVarDecl /*P*/ Param = Method.parameters().$at(i);
        
        QualType OrigParamType = Param.getType();
        if (!DynamicTypePropagationStatics.isObjCTypeParamDependent(new QualType(OrigParamType))) {
          continue;
        }
        
        QualType ParamType = OrigParamType.substObjCTypeArgs(ASTCtxt, new ArrayRef<QualType>(TypeArgs.$star()), ObjCSubstitutionContext.Parameter);
        // Check if it can be assigned
        /*const*/ ObjCObjectPointerType /*P*/ ParamObjectPtrType = ParamType.$arrow().getAs(ObjCObjectPointerType.class);
        /*const*/ ObjCObjectPointerType /*P*/ ArgObjectPtrType = DynamicTypePropagationStatics.stripCastsAndSugar(Arg).getType().$arrow().getAs(ObjCObjectPointerType.class);
        if (!(ParamObjectPtrType != null) || !(ArgObjectPtrType != null)) {
          continue;
        }
        
        // Check if we have more concrete tracked type that is not a super type of
        // the static argument type.
        SVal ArgSVal = M.getArgSVal(i);
        /*const*/ SymExpr /*P*/ ArgSym = ArgSVal.getAsSymbol();
        if ((ArgSym != null)) {
          type$ptr</*const*/ ObjCObjectPointerType /*P*/ /*const*/ /*P*/> TrackedArgType = State.$arrow()./*<MostSpecializedTypeArgsMap>*/get(ProgramStateTraitMostSpecializedTypeArgsMap.$Instance, ArgSym);
          if (/*JAVA*/(TrackedArgType != null)
             && ASTCtxt.canAssignObjCInterfaces(ArgObjectPtrType, TrackedArgType.$star())) {
            ArgObjectPtrType = TrackedArgType.$star();
          }
        }
        
        // Warn when argument is incompatible with the parameter.
        if (!ASTCtxt.canAssignObjCInterfaces(ParamObjectPtrType, 
            ArgObjectPtrType)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            // JAVA: need to use accessor
            final/*static*/ CheckerProgramPointTag Tag = checkPreObjCMessage$$.Tag();
            ExplodedNode /*P*/ N = $c$.clean(C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), $AddrOf(Tag)));
            reportGenericsBug(ArgObjectPtrType, ParamObjectPtrType, N, Sym, C, Arg);
            return;
          } finally {
            $c$.$destroy();
          }
        }
      }
    } finally {
      if (State != null) { State.$destroy(); }
    }
  }
  // MANUAL: moved below in extra members
//  private static final class checkPreObjCMessage$$ {
//    // JAVA: must not be static
//    static final /*static*/ CheckerProgramPointTag Tag;
//  }

  
  /// This callback is used to infer the types for Class variables. This info is
  /// used later to validate messages that sent to classes. Class variables are
  /// initialized with by invoking the 'class' method on a class.
  /// This method is also used to infer the type information for the return
  /// types.
  // TODO: right now it only tracks generic types. Extend this to track every
  // type in the DynamicTypeMap and diagnose type errors!
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DynamicTypePropagation::checkPostObjCMessage">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DynamicTypePropagation.cpp", line = 785,
   FQN="(anonymous namespace)::DynamicTypePropagation::checkPostObjCMessage", NM="_ZNK12_GLOBAL__N_122DynamicTypePropagation20checkPostObjCMessageERKN5clang4ento14ObjCMethodCallERNS2_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DynamicTypePropagation.cpp -nm=_ZNK12_GLOBAL__N_122DynamicTypePropagation20checkPostObjCMessageERKN5clang4ento14ObjCMethodCallERNS2_14CheckerContextE")
  //</editor-fold>
  public void checkPostObjCMessage(final /*const*/ ObjCMethodCall /*&*/ M, 
                      final CheckerContext /*&*/ C) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> State = null;
    try {
      /*const*/ ObjCMessageExpr /*P*/ MessageExpr = M.getOriginExpr();
      
      /*const*/ SymExpr /*P*/ RetSym = M.getReturnValue().getAsSymbol();
      if (!(RetSym != null)) {
        return;
      }
      
      Selector Sel = MessageExpr.getSelector();
      State = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
      // Inference for class variables.
      // We are only interested in cases where the class method is invoked on a
      // class. This method is provided by the runtime and available on all classes.
      if (MessageExpr.getReceiverKind() == ObjCMessageExpr.ReceiverKind.Class
         && $eq_string$C_T$C$P(Sel.getAsString(), /*KEEP_STR*/"class")) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          QualType ReceiverType = MessageExpr.getClassReceiver();
          /*const*/ ObjCObjectType /*P*/ ReceiverClassType = ReceiverType.$arrow().getAs(ObjCObjectType.class);
          QualType ReceiverClassPointerType = C.getASTContext().getObjCObjectPointerType(new QualType(ReceiverClassType, 0));
          if (!ReceiverClassType.isSpecialized()) {
            return;
          }
          /*const*/ ObjCObjectPointerType /*P*/ InferredType = ReceiverClassPointerType.$arrow().getAs(ObjCObjectPointerType.class);
          assert Native.$bool(InferredType);
          
          $c$.clean(State.$assign($c$.track(State.$arrow()./*<MostSpecializedTypeArgsMap>*/set(ProgramStateTraitMostSpecializedTypeArgsMap.$Instance, RetSym, InferredType))));
          $c$.clean(C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))));
          return;
        } finally {
          $c$.$destroy();
        }
      }
      
      // Tracking for return types.
      /*const*/ SymExpr /*P*/ RecSym = M.getReceiverSVal().getAsSymbol();
      if (!(RecSym != null)) {
        return;
      }
      
      type$ptr</*const*/ ObjCObjectPointerType /*P*/ /*const*/ /*P*/> TrackedType = State.$arrow()./*<MostSpecializedTypeArgsMap>*/get(ProgramStateTraitMostSpecializedTypeArgsMap.$Instance, RecSym);
      if (!/*JAVA*/(TrackedType != null)) {
        return;
      }
      
      final ASTContext /*&*/ ASTCtxt = C.getASTContext();
      /*const*/ ObjCMethodDecl /*P*/ Method = DynamicTypePropagationStatics.findMethodDecl(MessageExpr, TrackedType.$star(), ASTCtxt);
      if (!(Method != null)) {
        return;
      }
      
      Optional<ArrayRef<QualType> > TypeArgs = (TrackedType.$star()).getObjCSubstitutions(Method.getDeclContext$Const());
      if (!TypeArgs.$bool()) {
        return;
      }
      
      QualType ResultType = DynamicTypePropagationStatics.getReturnTypeForMethod(Method, new ArrayRef<QualType>(TypeArgs.$star()), TrackedType.$star(), ASTCtxt);
      // The static type is the same as the deduced type.
      if (ResultType.isNull()) {
        return;
      }
      
      /*const*/ MemRegion /*P*/ RetRegion = M.getReturnValue().getAsRegion();
      ExplodedNode /*P*/ Pred = C.getPredecessor();
      // When there is an entry available for the return symbol in DynamicTypeMap,
      // the call was inlined, and the information in the DynamicTypeMap is should
      // be precise.
      if ((RetRegion != null) && !(State.$arrow()./*<DynamicTypeMap>*/get(ProgramStateTraitDynamicTypeMap.$Instance, RetRegion) != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // TODO: we have duplicated information in DynamicTypeMap and
          // MostSpecializedTypeArgsMap. We should only store anything in the later if
          // the stored data differs from the one stored in the former.
          $c$.clean(State.$assign($c$.track(EntoGlobals.setDynamicTypeInfo($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), RetRegion, new QualType(ResultType), 
                  /*CanBeSubclass=*/ true))));
          $c$.clean(Pred = C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))));
        } finally {
          $c$.$destroy();
        }
      }
      
      /*const*/ ObjCObjectPointerType /*P*/ ResultPtrType = ResultType.$arrow().getAs(ObjCObjectPointerType.class);
      if (!(ResultPtrType != null) || ResultPtrType.isUnspecialized()) {
        return;
      }
      
      // When the result is a specialized type and it is not tracked yet, track it
      // for the result symbol.
      if (!(State.$arrow()./*<MostSpecializedTypeArgsMap>*/get(ProgramStateTraitMostSpecializedTypeArgsMap.$Instance, RetSym) !=/*JAVA*/ null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean(State.$assign($c$.track(State.$arrow()./*<MostSpecializedTypeArgsMap>*/set(ProgramStateTraitMostSpecializedTypeArgsMap.$Instance, RetSym, ResultPtrType))));
          $c$.clean(C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), Pred));
        } finally {
          $c$.$destroy();
        }
      }
    } finally {
      if (State != null) { State.$destroy(); }
    }
  }

  
  /// This value is set to true, when the Generics checker is turned on.
  public DefaultBool CheckGenerics;
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DynamicTypePropagation::~DynamicTypePropagation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DynamicTypePropagation.cpp", line = 50,
   FQN="(anonymous namespace)::DynamicTypePropagation::~DynamicTypePropagation", NM="_ZN12_GLOBAL__N_122DynamicTypePropagationD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DynamicTypePropagation.cpp -nm=_ZN12_GLOBAL__N_122DynamicTypePropagationD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    ObjCGenericsBugType.$destroy();
    super.$destroy();
    //END JDestroy
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DynamicTypePropagation::DynamicTypePropagation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DynamicTypePropagation.cpp", line = 50,
   FQN="(anonymous namespace)::DynamicTypePropagation::DynamicTypePropagation", NM="_ZN12_GLOBAL__N_122DynamicTypePropagationC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DynamicTypePropagation.cpp -nm=_ZN12_GLOBAL__N_122DynamicTypePropagationC1Ev")
  //</editor-fold>
  public /*inline*/ DynamicTypePropagation() {
    // : Checker<PreCall, PostCall, DeadSymbols, PostStmt<CastExpr>, PostStmt<CXXNewExpr>, PreObjCMessage, PostObjCMessage>(), ObjCGenericsBugType(), CheckGenerics() 
    //START JInit
    super();
    this.ObjCGenericsBugType = new std.unique_ptr<BugType>();
    this.CheckGenerics = new DefaultBool();
    //END JInit
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override
  public void $checkPostStmt(Stmt stmt, CheckerContext C) {
    if (stmt instanceof CastExpr) {
      checkPostStmt((CastExpr) stmt, C);
    } else if (stmt instanceof CXXNewExpr) {
      checkPostStmt((CXXNewExpr) stmt, C);
    }
  }

  private final CheckBase $CHECKS[] = {
    new PreCall(),
    new PostCall(),
    new DeadSymbols(),
    new org.clang.staticanalyzer.core.ento.check.PostStmt<CastExpr>(CastExpr.class),
    new org.clang.staticanalyzer.core.ento.check.PostStmt<CXXNewExpr>(CXXNewExpr.class),
    new PreObjCMessage(),
    new PostObjCMessage()
  };

  @Override
  protected CheckBase[] $getChecks() {
    return $CHECKS;
  }

  // MANUAL: we need to remove static but keep delay of initialization
  private final class checkPostStmt$$ {
    // JAVA: must not be static!
     /*static final*//*static*/ CheckerProgramPointTag $IllegalConv/*J*/;// = new CheckerProgramPointTag(this, new StringRef(/*KEEP_STR*/"IllegalConversion"));
     private final DynamicTypePropagation $this;
     private checkPostStmt$$(DynamicTypePropagation owner) {
       this.$this = owner;
     }
     CheckerProgramPointTag IllegalConv() {
       if ($IllegalConv == null) {
         $IllegalConv/*J*/ = new CheckerProgramPointTag($this, new StringRef(/*KEEP_STR*/"IllegalConversion"));
       }
       return $IllegalConv;
     }
  }
  private final checkPostStmt$$ checkPostStmt$$ = new checkPostStmt$$(this);

  // MANUAL: we need to remove static but keep delay of initialization
  private final class checkPreObjCMessage$$ {
    // JAVA: must not be static!
     /*static final*//*static*/ CheckerProgramPointTag $Tag/*J*/;// = new CheckerProgramPointTag(this, new StringRef(/*KEEP_STR*/"ArgTypeMismatch"));
     private final DynamicTypePropagation $this;
     private checkPreObjCMessage$$(DynamicTypePropagation owner) {
       this.$this = owner;
     }
     CheckerProgramPointTag Tag() {
       if ($Tag == null) {
         $Tag/*J*/ = new CheckerProgramPointTag($this, new StringRef(/*KEEP_STR*/"ArgTypeMismatch"));
       }
       return $Tag;
     }
  }
  private final checkPreObjCMessage$$ checkPreObjCMessage$$ = new checkPreObjCMessage$$(this);
  

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "ObjCGenericsBugType=" + ObjCGenericsBugType // NOI18N
              + ", CheckGenerics=" + CheckGenerics // NOI18N
              + super.toString(); // NOI18N
  }
}
