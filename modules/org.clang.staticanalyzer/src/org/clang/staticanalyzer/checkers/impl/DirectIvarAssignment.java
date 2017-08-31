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

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.ast.java.AstFunctionPointers.*;
import org.clang.analysis.*;
import org.clang.staticanalyzer.checkers.impl.*;
import org.clang.staticanalyzer.core.bugreporter.ento.*;
import org.clang.staticanalyzer.core.ento.*;
import org.clang.staticanalyzer.core.ento.check.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.staticanalyzer.checkers.impl.DirectIvarAssignmentStatics.*;
import org.clang.staticanalyzer.java.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DirectIvarAssignment">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DirectIvarAssignment.cpp", line = 52,
 FQN="(anonymous namespace)::DirectIvarAssignment", NM="_ZN12_GLOBAL__N_120DirectIvarAssignmentE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DirectIvarAssignment.cpp -nm=_ZN12_GLOBAL__N_120DirectIvarAssignmentE")
//</editor-fold>
public class DirectIvarAssignment extends /*public*/ Checker/*T<ASTDecl<ObjCImplementationDecl> > */
        implements org.clang.staticanalyzer.java.ASTDeclChecker<ObjCImplementationDecl>, Destructors.ClassWithDestructor {
  
  /*typedef llvm::DenseMap<const ObjCIvarDecl *, const ObjCPropertyDecl *> IvarToPropertyMapTy*/
//  public final class IvarToPropertyMapTy extends DenseMap</*const*/ ObjCIvarDecl /*P*/ , /*const*/ ObjCPropertyDecl /*P*/ >{ };
  
  /// A helper class, which walks the AST and locates all assignments to ivars
  /// in the given function.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DirectIvarAssignment::MethodCrawler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DirectIvarAssignment.cpp", line = 60,
   FQN="(anonymous namespace)::DirectIvarAssignment::MethodCrawler", NM="_ZN12_GLOBAL__N_120DirectIvarAssignment13MethodCrawlerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DirectIvarAssignment.cpp -nm=_ZN12_GLOBAL__N_120DirectIvarAssignment13MethodCrawlerE")
  //</editor-fold>
  private static class MethodCrawler implements /*public*/ ConstStmtVisitorVoid<MethodCrawler> {
    private final /*const*/DenseMap</*const*/ ObjCIvarDecl /*P*/ , /*const*/ ObjCPropertyDecl /*P*/ > /*&*/ IvarToPropMap;
    private /*const*/ ObjCMethodDecl /*P*/ MD;
    private /*const*/ ObjCInterfaceDecl /*P*/ InterfD;
    private final BugReporter /*&*/ BR;
    private /*const*/ CheckerBase /*P*/ Checker;
    private PointerUnion</*const*/ LocationContext /*P*/ , AnalysisDeclContext /*P*/ > DCtx;
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DirectIvarAssignment::MethodCrawler::MethodCrawler">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DirectIvarAssignment.cpp", line = 69,
     FQN="(anonymous namespace)::DirectIvarAssignment::MethodCrawler::MethodCrawler", NM="_ZN12_GLOBAL__N_120DirectIvarAssignment13MethodCrawlerC1ERKN4llvm8DenseMapIPKN5clang12ObjCIvarDeclEPKNS4_16ObjCPropertyDeclENS2_12DenseMapInfoIS7_EENS2_6detail12DenseMapPairIS7_SA_EEEEPKNS4_14ObjCMethodDeclEPKNS4_17ObjCInterfaceDeclERNS4_4ento11BugReporterEPKNSP_11CheckerBaseEPNS4_19AnalysisDeclContextE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DirectIvarAssignment.cpp -nm=_ZN12_GLOBAL__N_120DirectIvarAssignment13MethodCrawlerC1ERKN4llvm8DenseMapIPKN5clang12ObjCIvarDeclEPKNS4_16ObjCPropertyDeclENS2_12DenseMapInfoIS7_EENS2_6detail12DenseMapPairIS7_SA_EEEEPKNS4_14ObjCMethodDeclEPKNS4_17ObjCInterfaceDeclERNS4_4ento11BugReporterEPKNSP_11CheckerBaseEPNS4_19AnalysisDeclContextE")
    //</editor-fold>
    public MethodCrawler(final /*const*/DenseMap</*const*/ ObjCIvarDecl /*P*/ , /*const*/ ObjCPropertyDecl /*P*/ > /*&*/ InMap, /*const*/ ObjCMethodDecl /*P*/ InMD, 
        /*const*/ ObjCInterfaceDecl /*P*/ InID, final BugReporter /*&*/ InBR, 
        /*const*/ CheckerBase /*P*/ Checker, AnalysisDeclContext /*P*/ InDCtx) {
      // : ConstStmtVisitor<MethodCrawler>(), IvarToPropMap(InMap), MD(InMD), InterfD(InID), BR(InBR), Checker(Checker), DCtx(InDCtx) 
      //START JInit
      $ConstStmtVisitor();
      this./*&*/IvarToPropMap=/*&*/InMap;
      this.MD = InMD;
      this.InterfD = InID;
      this./*&*/BR=/*&*/InBR;
      this.Checker = Checker;
      this.DCtx = new PointerUnion</*const*/ LocationContext /*P*/ , AnalysisDeclContext /*P*/ >(JD$T1.INSTANCE, AnalysisDeclContext /*P*/.class, InDCtx);
      //END JInit
    }

    
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DirectIvarAssignment::MethodCrawler::VisitStmt">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DirectIvarAssignment.cpp", line = 75,
     FQN="(anonymous namespace)::DirectIvarAssignment::MethodCrawler::VisitStmt", NM="_ZN12_GLOBAL__N_120DirectIvarAssignment13MethodCrawler9VisitStmtEPKN5clang4StmtE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DirectIvarAssignment.cpp -nm=_ZN12_GLOBAL__N_120DirectIvarAssignment13MethodCrawler9VisitStmtEPKN5clang4StmtE")
    //</editor-fold>
    public void VisitStmt(/*const*/ Stmt /*P*/ S) {
      VisitChildren(S);
    }

    
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DirectIvarAssignment::MethodCrawler::VisitBinaryOperator">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DirectIvarAssignment.cpp", line = 164,
     FQN="(anonymous namespace)::DirectIvarAssignment::MethodCrawler::VisitBinaryOperator", NM="_ZN12_GLOBAL__N_120DirectIvarAssignment13MethodCrawler19VisitBinaryOperatorEPKN5clang14BinaryOperatorE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DirectIvarAssignment.cpp -nm=_ZN12_GLOBAL__N_120DirectIvarAssignment13MethodCrawler19VisitBinaryOperatorEPKN5clang14BinaryOperatorE")
    //</editor-fold>
    public void VisitBinaryOperator(/*const*/ BinaryOperator /*P*/ BO) {
      if (!BO.isAssignmentOp()) {
        return;
      }
      
      /*const*/ ObjCIvarRefExpr /*P*/ IvarRef = dyn_cast_ObjCIvarRefExpr(BO.getLHS().IgnoreParenCasts());
      if (!(IvarRef != null)) {
        return;
      }
      {
        
        /*const*/ ObjCIvarDecl /*P*/ D = IvarRef.getDecl$Const();
        if ((D != null)) {
          DenseMapIterator</*const*/ ObjCIvarDecl /*P*/ , /*const*/ ObjCPropertyDecl /*P*/ > I = IvarToPropMap.find$Const(D);
          if (I.$noteq(IvarToPropMap.end$Const())) {
            /*const*/ ObjCPropertyDecl /*P*/ PD = I.$arrow().second;
            // Skip warnings on Ivars, annotated with
            // objc_allow_direct_instance_variable_assignment. This annotation serves
            // as a false positive suppression mechanism for the checker. The
            // annotation is allowed on properties and ivars.
            if (isAnnotatedToAllowDirectAssignment(PD)
               || isAnnotatedToAllowDirectAssignment(D)) {
              return;
            }
            
            ObjCMethodDecl /*P*/ GetterMethod = InterfD.getInstanceMethod(PD.getGetterName());
            ObjCMethodDecl /*P*/ SetterMethod = InterfD.getInstanceMethod(PD.getSetterName());
            if ((SetterMethod != null) && SetterMethod.getCanonicalDecl() == MD) {
              return;
            }
            if ((GetterMethod != null) && GetterMethod.getCanonicalDecl() == MD) {
              return;
            }
            
            BR.EmitBasicReport(MD, Checker, new StringRef(/*KEEP_STR*/"Property access"), new StringRef(categories.CoreFoundationObjectiveC), 
                new StringRef(/*KEEP_STR*/"Direct assignment to an instance variable backing a property; use the setter instead"), 
                new PathDiagnosticLocation(IvarRef, BR.getSourceManager(), new PointerUnion</*const*/ LocationContext /*P*/ , AnalysisDeclContext /*P*/ >(DCtx)));
          }
        }
      }
    }

    
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DirectIvarAssignment::MethodCrawler::VisitChildren">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DirectIvarAssignment.cpp", line = 79,
     FQN="(anonymous namespace)::DirectIvarAssignment::MethodCrawler::VisitChildren", NM="_ZN12_GLOBAL__N_120DirectIvarAssignment13MethodCrawler13VisitChildrenEPKN5clang4StmtE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DirectIvarAssignment.cpp -nm=_ZN12_GLOBAL__N_120DirectIvarAssignment13MethodCrawler13VisitChildrenEPKN5clang4StmtE")
    //</editor-fold>
    public void VisitChildren(/*const*/ Stmt /*P*/ S) {
      for (/*const*/ Stmt /*P*/ Child : S.children$Const())  {
        if ((Child != null)) {
          /*J:ToBase*/ConstStmtVisitorVoid /*P*/ .super.Visit(Child);
        }
      }
    }

    
    @Override public String toString() {
      return "" + "IvarToPropMap=" + IvarToPropMap // NOI18N
                + ", MD=" + MD // NOI18N
                + ", InterfD=" + InterfD // NOI18N
                + ", BR=" + BR // NOI18N
                + ", Checker=" + Checker // NOI18N
                + ", DCtx=" + "[PointerUnion$LocationContext$AnalysisDeclContext]" // NOI18N
                + super.toString(); // NOI18N
    }
  };
/*public:*/
  public ObjCMethodDecl2Bool ShouldSkipMethod;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DirectIvarAssignment::DirectIvarAssignment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DirectIvarAssignment.cpp", line = 89,
   FQN="(anonymous namespace)::DirectIvarAssignment::DirectIvarAssignment", NM="_ZN12_GLOBAL__N_120DirectIvarAssignmentC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DirectIvarAssignment.cpp -nm=_ZN12_GLOBAL__N_120DirectIvarAssignmentC1Ev")
  //</editor-fold>
  public DirectIvarAssignment() {
    // : Checker<ASTDecl<ObjCImplementationDecl> >(), ShouldSkipMethod(&FPtrDefaultMethodFilter) 
    //START JInit
    super();
    this.ShouldSkipMethod = DirectIvarAssignmentStatics::DefaultMethodFilter;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DirectIvarAssignment::checkASTDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DirectIvarAssignment.cpp", line = 117,
   FQN="(anonymous namespace)::DirectIvarAssignment::checkASTDecl", NM="_ZNK12_GLOBAL__N_120DirectIvarAssignment12checkASTDeclEPKN5clang22ObjCImplementationDeclERNS1_4ento15AnalysisManagerERNS5_11BugReporterE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DirectIvarAssignment.cpp -nm=_ZNK12_GLOBAL__N_120DirectIvarAssignment12checkASTDeclEPKN5clang22ObjCImplementationDeclERNS1_4ento15AnalysisManagerERNS5_11BugReporterE")
  //</editor-fold>
  public void checkASTDecl(/*const*/ ObjCImplementationDecl /*P*/ D, 
              final AnalysisManager /*&*/ Mgr, 
              final BugReporter /*&*/ BR) /*const*/ {
    /*const*/ ObjCInterfaceDecl /*P*/ InterD = D.getClassInterface$Const();
    
    DenseMap</*const*/ ObjCIvarDecl /*P*/ , /*const*/ ObjCPropertyDecl /*P*/ > IvarToPropMap/*J*/= new DenseMap</*const*/ ObjCIvarDecl /*P*/ , /*const*/ ObjCPropertyDecl /*P*/ >(DenseMapInfo$LikePtr.$Info(), (/*const*/ ObjCPropertyDecl /*P*/ )null);
    
    // Find all properties for this class.
    for (/*const*/ ObjCPropertyDecl /*P*/ PD : InterD.instance_properties()) {
      // Find the corresponding IVar.
      /*const*/ ObjCIvarDecl /*P*/ ID = findPropertyBackingIvar(PD, InterD, 
          Mgr.getASTContext());
      if (!(ID != null)) {
        continue;
      }
      
      // Store the IVar to property mapping.
      IvarToPropMap.$set(ID, PD);
    }
    if (IvarToPropMap.empty()) {
      return;
    }
    
    for (/*const*/ ObjCMethodDecl /*P*/ M : D.instance_methods()) {
      AnalysisDeclContext /*P*/ DCtx = Mgr.getAnalysisDeclContext(M);
      if (ShouldSkipMethod.$call(M)) {
        continue;
      }
      
      /*const*/ Stmt /*P*/ Body = M.getBody();
      assert Native.$bool(Body);
      
      MethodCrawler MC/*J*/= new MethodCrawler(IvarToPropMap, M.getCanonicalDecl$Const(), InterD, BR, this, 
          DCtx);
      MC.VisitStmt(Body);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DirectIvarAssignment::~DirectIvarAssignment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DirectIvarAssignment.cpp", line = 52,
   FQN="(anonymous namespace)::DirectIvarAssignment::~DirectIvarAssignment", NM="_ZN12_GLOBAL__N_120DirectIvarAssignmentD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DirectIvarAssignment.cpp -nm=_ZN12_GLOBAL__N_120DirectIvarAssignmentD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  private final CheckBase $CHECKS[] = {
    new ASTDecl<ObjCImplementationDecl>(ObjCImplementationDecl.class)
  };

  @Override protected CheckBase[] $getChecks() { return $CHECKS; }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////

  @Override public String toString() {
    return "" + "ShouldSkipMethod=" + ShouldSkipMethod // NOI18N
              + super.toString(); // NOI18N
  }
}
