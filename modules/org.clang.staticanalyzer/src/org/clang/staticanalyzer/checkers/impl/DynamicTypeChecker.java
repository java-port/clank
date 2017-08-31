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
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.analysis.*;
import org.clang.basic.*;
import org.clang.staticanalyzer.core.bugreporter.ento.*;
import org.clang.staticanalyzer.core.ento.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import org.clang.staticanalyzer.checkers.ento.EntoGlobals;
import org.clang.staticanalyzer.java.CheckBase;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DynamicTypeChecker">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DynamicTypeChecker.cpp", line = 33,
 FQN="(anonymous namespace)::DynamicTypeChecker", NM="_ZN12_GLOBAL__N_118DynamicTypeCheckerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DynamicTypeChecker.cpp -nm=_ZN12_GLOBAL__N_118DynamicTypeCheckerE")
//</editor-fold>
public class DynamicTypeChecker extends /*public*/ Checker/*T<PostStmt<ImplicitCastExpr> > */
        implements org.clang.staticanalyzer.java.PostStmtChecker, Destructors.ClassWithDestructor {
  private /*mutable */std.unique_ptr<BugType> BT;
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DynamicTypeChecker::initBugType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DynamicTypeChecker.cpp", line = 35,
   FQN="(anonymous namespace)::DynamicTypeChecker::initBugType", NM="_ZNK12_GLOBAL__N_118DynamicTypeChecker11initBugTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DynamicTypeChecker.cpp -nm=_ZNK12_GLOBAL__N_118DynamicTypeChecker11initBugTypeEv")
  //</editor-fold>
  private void initBugType() /*const*/ {
    if (!BT.$bool()) {
      BT.reset(new BugType(this, new StringRef(/*KEEP_STR*/"Dynamic and static type mismatch"), new StringRef(/*KEEP_STR*/"Type Error")));
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DynamicTypeChecker::DynamicTypeBugVisitor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DynamicTypeChecker.cpp", line = 41,
   FQN="(anonymous namespace)::DynamicTypeChecker::DynamicTypeBugVisitor", NM="_ZN12_GLOBAL__N_118DynamicTypeChecker21DynamicTypeBugVisitorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DynamicTypeChecker.cpp -nm=_ZN12_GLOBAL__N_118DynamicTypeChecker21DynamicTypeBugVisitorE")
  //</editor-fold>
  private static class DynamicTypeBugVisitor extends /*public*/ BugReporterVisitorImpl<DynamicTypeBugVisitor> implements Destructors.ClassWithDestructor {
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DynamicTypeChecker::DynamicTypeBugVisitor::DynamicTypeBugVisitor">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DynamicTypeChecker.cpp", line = 44,
     FQN="(anonymous namespace)::DynamicTypeChecker::DynamicTypeBugVisitor::DynamicTypeBugVisitor", NM="_ZN12_GLOBAL__N_118DynamicTypeChecker21DynamicTypeBugVisitorC1EPKN5clang4ento9MemRegionE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DynamicTypeChecker.cpp -nm=_ZN12_GLOBAL__N_118DynamicTypeChecker21DynamicTypeBugVisitorC1EPKN5clang4ento9MemRegionE")
    //</editor-fold>
    public DynamicTypeBugVisitor(/*const*/ MemRegion /*P*/ Reg) {
      // : BugReporterVisitorImpl<DynamicTypeBugVisitor>(), Reg(Reg) 
      //START JInit
      super();
      this.Reg = Reg;
      //END JInit
    }

    
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DynamicTypeChecker::DynamicTypeBugVisitor::Profile">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DynamicTypeChecker.cpp", line = 46,
     FQN="(anonymous namespace)::DynamicTypeChecker::DynamicTypeBugVisitor::Profile", NM="_ZNK12_GLOBAL__N_118DynamicTypeChecker21DynamicTypeBugVisitor7ProfileERN4llvm16FoldingSetNodeIDE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DynamicTypeChecker.cpp -nm=_ZNK12_GLOBAL__N_118DynamicTypeChecker21DynamicTypeBugVisitor7ProfileERN4llvm16FoldingSetNodeIDE")
    //</editor-fold>
    @Override public void Profile(final FoldingSetNodeID /*&*/ ID) /*const*//* override*/ {
      final/*static*/ Object X = Profile$$.X;
      ID.AddPointer($AddrOf(X));
      ID.AddPointer(Reg);
    }
    private static final class Profile$$ {
      static final/*static*/ Object X = DynamicTypeBugVisitor.class;
    }

    
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DynamicTypeChecker::DynamicTypeBugVisitor::VisitNode">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DynamicTypeChecker.cpp", line = 94,
     FQN="(anonymous namespace)::DynamicTypeChecker::DynamicTypeBugVisitor::VisitNode", NM="_ZN12_GLOBAL__N_118DynamicTypeChecker21DynamicTypeBugVisitor9VisitNodeEPKN5clang4ento12ExplodedNodeES6_RNS3_18BugReporterContextERNS3_9BugReportE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DynamicTypeChecker.cpp -nm=_ZN12_GLOBAL__N_118DynamicTypeChecker21DynamicTypeBugVisitor9VisitNodeEPKN5clang4ento12ExplodedNodeES6_RNS3_18BugReporterContextERNS3_9BugReportE")
    //</editor-fold>
    @Override public PathDiagnosticPiece /*P*/ VisitNode(/*const*/ ExplodedNode /*P*/ N, /*const*/ ExplodedNode /*P*/ PrevN, final BugReporterContext /*&*/ BRC, 
             final BugReport /*&*/ BR)/* override*/ {
      IntrusiveRefCntPtr</*const*/ ProgramState> State = null;
      IntrusiveRefCntPtr</*const*/ ProgramState> StatePrev = null;
      raw_svector_ostream OS = null;
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        State = new IntrusiveRefCntPtr</*const*/ ProgramState>(N.getState());
        StatePrev = new IntrusiveRefCntPtr</*const*/ ProgramState>(PrevN.getState());
        
        DynamicTypeInfo TrackedType = $c$.clean(EntoGlobals.getDynamicTypeInfo($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), Reg));
        DynamicTypeInfo TrackedTypePrev = $c$.clean(EntoGlobals.getDynamicTypeInfo($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(StatePrev)), Reg));
        if (!TrackedType.isValid()) {
          return null;
        }
        if (TrackedTypePrev.isValid()
           && QualType.$eq_QualType$C(TrackedTypePrev.getType(), TrackedType.getType())) {
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
        QualType.print(TrackedType.getType().getTypePtr(), new Qualifiers(), OS, 
            new PrintingPolicy(LangOpts), new Twine());
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
        if (StatePrev != null) { StatePrev.$destroy(); }
        if (State != null) { State.$destroy(); }
        $c$.$destroy();
      }
    }

  /*private:*/
    // The tracked region.
    private /*const*/ MemRegion /*P*/ Reg;
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DynamicTypeChecker::DynamicTypeBugVisitor::~DynamicTypeBugVisitor">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DynamicTypeChecker.cpp", line = 41,
     FQN="(anonymous namespace)::DynamicTypeChecker::DynamicTypeBugVisitor::~DynamicTypeBugVisitor", NM="_ZN12_GLOBAL__N_118DynamicTypeChecker21DynamicTypeBugVisitorD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DynamicTypeChecker.cpp -nm=_ZN12_GLOBAL__N_118DynamicTypeChecker21DynamicTypeBugVisitorD0Ev")
    //</editor-fold>
    @Override public /*inline*/ void $destroy() {
      super.$destroy();
    }

    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DynamicTypeChecker::DynamicTypeBugVisitor::DynamicTypeBugVisitor">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DynamicTypeChecker.cpp", line = 41,
     FQN="(anonymous namespace)::DynamicTypeChecker::DynamicTypeBugVisitor::DynamicTypeBugVisitor", NM="_ZN12_GLOBAL__N_118DynamicTypeChecker21DynamicTypeBugVisitorC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DynamicTypeChecker.cpp -nm=_ZN12_GLOBAL__N_118DynamicTypeChecker21DynamicTypeBugVisitorC1ERKS1_")
    //</editor-fold>
    public /*inline*/ DynamicTypeBugVisitor(final /*const*/ DynamicTypeBugVisitor /*&*/ $Prm0) {
      // : BugReporterVisitorImpl<DynamicTypeBugVisitor>(), Reg(.Reg) 
      //START JInit
      super($Prm0);
      this.Reg = $Prm0.Reg;
      //END JInit
    }

    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN

    @Override public DynamicTypeBugVisitor clone() {
      return new DynamicTypeBugVisitor(this);
    }
    

    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////
    
    @Override public String toString() {
      return "" + "Reg=" + Reg // NOI18N
                + super.toString(); // NOI18N
    }
  };
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DynamicTypeChecker::reportTypeError">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DynamicTypeChecker.cpp", line = 71,
   FQN="(anonymous namespace)::DynamicTypeChecker::reportTypeError", NM="_ZNK12_GLOBAL__N_118DynamicTypeChecker15reportTypeErrorEN5clang8QualTypeES2_PKNS1_4ento9MemRegionEPKNS1_4StmtERNS3_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DynamicTypeChecker.cpp -nm=_ZNK12_GLOBAL__N_118DynamicTypeChecker15reportTypeErrorEN5clang8QualTypeES2_PKNS1_4ento9MemRegionEPKNS1_4StmtERNS3_14CheckerContextE")
  //</editor-fold>
  private void reportTypeError(QualType DynamicType, 
                 QualType StaticType, 
                 /*const*/ MemRegion /*P*/ Reg, 
                 /*const*/ Stmt /*P*/ ReportedNode, 
                 final CheckerContext /*&*/ C) /*const*/ {
    raw_svector_ostream OS = null;
    std.unique_ptr<BugReport> R = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      initBugType();
      SmallString/*<192>*/ Buf/*J*/= new SmallString/*<192>*/(192);
      OS/*J*/= new raw_svector_ostream(Buf);
      OS.$out(/*KEEP_STR*/"Object has a dynamic type '");
      QualType.print(DynamicType.getTypePtr(), new Qualifiers(), OS, new PrintingPolicy(C.getLangOpts()), 
          new Twine());
      OS.$out(/*KEEP_STR*/"' which is incompatible with static type '");
      QualType.print(StaticType.getTypePtr(), new Qualifiers(), OS, new PrintingPolicy(C.getLangOpts()), 
          new Twine());
      OS.$out(/*KEEP_STR*/$SGL_QUOTE);
      R/*J*/= new std.unique_ptr<BugReport>(new BugReport(BT.$star(), OS.str(), C.generateNonFatalErrorNode()));
      R.$arrow().markInteresting(Reg);
      R.$arrow().addVisitor($c$.track(new std.unique_ptr<BugReporterVisitor>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(llvm.make_unique(new DynamicTypeBugVisitor(Reg)))))); $c$.clean();
      R.$arrow().addRange(ReportedNode.getSourceRange());
      C.emitReport($c$.track(new std.unique_ptr<BugReport>(JD$Move.INSTANCE, std.move(R)))); $c$.clean();
    } finally {
      if (R != null) { R.$destroy(); }
      if (OS != null) { OS.$destroy(); }
      $c$.$destroy();
    }
  }

/*public:*/
  
  // TODO: consider checking explicit casts?
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DynamicTypeChecker::checkPostStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DynamicTypeChecker.cpp", line = 163,
   FQN="(anonymous namespace)::DynamicTypeChecker::checkPostStmt", NM="_ZNK12_GLOBAL__N_118DynamicTypeChecker13checkPostStmtEPKN5clang16ImplicitCastExprERNS1_4ento14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DynamicTypeChecker.cpp -nm=_ZNK12_GLOBAL__N_118DynamicTypeChecker13checkPostStmtEPKN5clang16ImplicitCastExprERNS1_4ento14CheckerContextE")
  //</editor-fold>
  public void checkPostStmt(/*const*/ ImplicitCastExpr /*P*/ CE, 
               final CheckerContext /*&*/ C) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> State = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // TODO: C++ support.
      if (CE.getCastKind() != CastKind.CK_BitCast) {
        return;
      }
      
      /*const*/ MemRegion /*P*/ Region = C.getSVal(CE).getAsRegion();
      if (!(Region != null)) {
        return;
      }
      
      State = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
      DynamicTypeInfo DynTypeInfo = $c$.clean(EntoGlobals.getDynamicTypeInfo($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), Region));
      if (!DynTypeInfo.isValid()) {
        return;
      }
      
      QualType DynType = DynTypeInfo.getType();
      QualType StaticType = CE.getType();
      
      /*const*/ ObjCObjectPointerType /*P*/ DynObjCType = DynType.$arrow().getAs(ObjCObjectPointerType.class);
      /*const*/ ObjCObjectPointerType /*P*/ StaticObjCType = StaticType.$arrow().getAs(ObjCObjectPointerType.class);
      if (!(DynObjCType != null) || !(StaticObjCType != null)) {
        return;
      }
      if (!DynamicTypeCheckerStatics.hasDefinition(DynObjCType) || !DynamicTypeCheckerStatics.hasDefinition(StaticObjCType)) {
        return;
      }
      
      final ASTContext /*&*/ ASTCtxt = C.getASTContext();
      
      // Strip kindeofness to correctly detect subtyping relationships.
      DynObjCType = DynObjCType.stripObjCKindOfTypeAndQuals(ASTCtxt);
      StaticObjCType = StaticObjCType.stripObjCKindOfTypeAndQuals(ASTCtxt);
      
      // Specialized objects are handled by the generics checker.
      if (StaticObjCType.isSpecialized()) {
        return;
      }
      if (ASTCtxt.canAssignObjCInterfaces(StaticObjCType, DynObjCType)) {
        return;
      }
      if (DynTypeInfo.canBeASubClass()
         && ASTCtxt.canAssignObjCInterfaces(DynObjCType, StaticObjCType)) {
        return;
      }
      
      reportTypeError(new QualType(DynType), new QualType(StaticType), Region, CE, C);
    } finally {
      if (State != null) { State.$destroy(); }
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DynamicTypeChecker::~DynamicTypeChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DynamicTypeChecker.cpp", line = 33,
   FQN="(anonymous namespace)::DynamicTypeChecker::~DynamicTypeChecker", NM="_ZN12_GLOBAL__N_118DynamicTypeCheckerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DynamicTypeChecker.cpp -nm=_ZN12_GLOBAL__N_118DynamicTypeCheckerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    BT.$destroy();
    super.$destroy();
    //END JDestroy
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DynamicTypeChecker::DynamicTypeChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DynamicTypeChecker.cpp", line = 33,
   FQN="(anonymous namespace)::DynamicTypeChecker::DynamicTypeChecker", NM="_ZN12_GLOBAL__N_118DynamicTypeCheckerC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DynamicTypeChecker.cpp -nm=_ZN12_GLOBAL__N_118DynamicTypeCheckerC1Ev")
  //</editor-fold>
  public /*inline*/ DynamicTypeChecker() {
    // : Checker<PostStmt<ImplicitCastExpr> >(), BT() 
    //START JInit
    super();
    this.BT = new std.unique_ptr<BugType>();
    //END JInit
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override public void $checkPostStmt(Stmt stmt, CheckerContext C) { if (stmt instanceof ImplicitCastExpr) { checkPostStmt((ImplicitCastExpr) stmt, C); } }

  private final CheckBase $CHECKS[] = {
    new org.clang.staticanalyzer.core.ento.check.PostStmt<ImplicitCastExpr>(ImplicitCastExpr.class)
  };

  @Override protected CheckBase[] $getChecks() { return $CHECKS; }
  

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "BT=" + BT // NOI18N
              + super.toString(); // NOI18N
  }
}
