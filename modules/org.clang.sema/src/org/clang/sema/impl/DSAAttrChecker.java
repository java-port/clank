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

package org.clang.sema.impl;

import org.clank.support.*;
import static org.clank.support.Native.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.sema.*;
import static org.clang.basic.BasicClangGlobals.*;
import static org.clang.ast.java.AstRTTI.*;
import org.clang.sema.impl.DSAStackTy.*;
import static org.clang.sema.impl.SemaOpenMPStatics.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;


//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DSAAttrChecker">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 1454,
 FQN="(anonymous namespace)::DSAAttrChecker", NM="_ZN12_GLOBAL__N_114DSAAttrCheckerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN12_GLOBAL__N_114DSAAttrCheckerE")
//</editor-fold>
public class DSAAttrChecker implements /*public*/ StmtVisitorVoid<DSAAttrChecker>, Destructors.ClassWithDestructor {
  private DSAStackTy /*P*/ Stack;
  private final Sema /*&*/ SemaRef;
  private boolean ErrorFound;
  private CapturedStmt /*P*/ CS;
  private SmallVector<Expr /*P*/ > ImplicitFirstprivate;
  private DenseMap<ValueDecl /*P*/ , Expr /*P*/ > VarsWithInheritedDSA;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DSAAttrChecker::VisitDeclRefExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 1463,
   FQN="(anonymous namespace)::DSAAttrChecker::VisitDeclRefExpr", NM="_ZN12_GLOBAL__N_114DSAAttrChecker16VisitDeclRefExprEPN5clang11DeclRefExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN12_GLOBAL__N_114DSAAttrChecker16VisitDeclRefExprEPN5clang11DeclRefExprE")
  //</editor-fold>
  public void VisitDeclRefExpr(DeclRefExpr /*P*/ E) {
    if (E.isTypeDependent() || E.isValueDependent()
       || E.containsUnexpandedParameterPack() || E.isInstantiationDependent()) {
      return;
    }
    {
      VarDecl /*P*/ VD = dyn_cast_VarDecl(E.getDecl());
      if ((VD != null)) {
        // Skip internally declared variables.
        if (VD.isLocalVarDecl() && !CS.capturesVariable(VD)) {
          return;
        }
        
        DSAVarData DVar = Stack.getTopDSA(VD, false);
        // Check if the variable has explicit DSA set and stop analysis if it so.
        if ((DVar.RefExpr != null)) {
          return;
        }
        
        SourceLocation ELoc = E.getExprLoc();
        OpenMPDirectiveKind DKind = Stack.getCurrentDirective();
        // The default(none) clause requires that each variable that is referenced
        // in the construct, and does not have a predetermined data-sharing
        // attribute, must have its data-sharing attribute explicitly determined
        // by being listed in a data-sharing attribute clause.
        if (DVar.CKind == OpenMPClauseKind.OMPC_unknown && Stack.getDefaultDSA() == DefaultDataSharingAttributes.DSA_none
           && isParallelOrTaskRegion(DKind)
           && VarsWithInheritedDSA.count(VD) == 0) {
          VarsWithInheritedDSA.$set(VD, E);
          return;
        }
        
        // OpenMP [2.9.3.6, Restrictions, p.2]
        //  A list item that appears in a reduction clause of the innermost
        //  enclosing worksharing or parallel construct may not be accessed in an
        //  explicit task.
        DVar.$assignMove(Stack.hasInnermostDSA(VD, /*[]*/ (OpenMPClauseKind C) -> {
                      return C == OpenMPClauseKind.OMPC_reduction;
                    }, 
                /*[]*/ (OpenMPDirectiveKind K) -> {
                      return isOpenMPParallelDirective(K)
                         || isOpenMPWorksharingDirective(K) || isOpenMPTeamsDirective(K);
                    }, 
                false));
        if (isOpenMPTaskingDirective(DKind) && DVar.CKind == OpenMPClauseKind.OMPC_reduction) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            ErrorFound = true;
            $c$.clean($c$.track(SemaRef.Diag(new SourceLocation(ELoc), diag.err_omp_reduction_in_task)));
            ReportOriginalDSA(SemaRef, Stack, VD, new DSAStackTy.DSAVarData(DVar));
            return;
          } finally {
            $c$.$destroy();
          }
        }
        
        // Define implicit data-sharing attributes for task.
        DVar.$assignMove(Stack.getImplicitDSA(VD, false));
        if (isOpenMPTaskingDirective(DKind) && DVar.CKind != OpenMPClauseKind.OMPC_shared
           && !((Stack.isLoopControlVariable(VD).first) != 0)) {
          ImplicitFirstprivate.push_back(E);
        }
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DSAAttrChecker::VisitMemberExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 1514,
   FQN="(anonymous namespace)::DSAAttrChecker::VisitMemberExpr", NM="_ZN12_GLOBAL__N_114DSAAttrChecker15VisitMemberExprEPN5clang10MemberExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN12_GLOBAL__N_114DSAAttrChecker15VisitMemberExprEPN5clang10MemberExprE")
  //</editor-fold>
  public void VisitMemberExpr(MemberExpr /*P*/ E) {
    if (E.isTypeDependent() || E.isValueDependent()
       || E.containsUnexpandedParameterPack() || E.isInstantiationDependent()) {
      return;
    }
    if (isa_CXXThisExpr(E.getBase().IgnoreParens())) {
      {
        FieldDecl /*P*/ FD = dyn_cast_FieldDecl(E.getMemberDecl());
        if ((FD != null)) {
          DSAVarData DVar = Stack.getTopDSA(FD, false);
          // Check if the variable has explicit DSA set and stop analysis if it
          // so.
          if ((DVar.RefExpr != null)) {
            return;
          }
          
          SourceLocation ELoc = E.getExprLoc();
          OpenMPDirectiveKind DKind = Stack.getCurrentDirective();
          // OpenMP [2.9.3.6, Restrictions, p.2]
          //  A list item that appears in a reduction clause of the innermost
          //  enclosing worksharing or parallel construct may not be accessed in
          //  an  explicit task.
          DVar.$assignMove(Stack.hasInnermostDSA(FD, /*[]*/ (OpenMPClauseKind C) -> {
                        return C == OpenMPClauseKind.OMPC_reduction;
                      }, 
                  /*[]*/ (OpenMPDirectiveKind K) -> {
                        return isOpenMPParallelDirective(K)
                           || isOpenMPWorksharingDirective(K)
                           || isOpenMPTeamsDirective(K);
                      }, 
                  false));
          if (isOpenMPTaskingDirective(DKind) && DVar.CKind == OpenMPClauseKind.OMPC_reduction) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              ErrorFound = true;
              $c$.clean($c$.track(SemaRef.Diag(new SourceLocation(ELoc), diag.err_omp_reduction_in_task)));
              ReportOriginalDSA(SemaRef, Stack, FD, new DSAStackTy.DSAVarData(DVar));
              return;
            } finally {
              $c$.$destroy();
            }
          }
          
          // Define implicit data-sharing attributes for task.
          DVar.$assignMove(Stack.getImplicitDSA(FD, false));
          if (isOpenMPTaskingDirective(DKind) && DVar.CKind != OpenMPClauseKind.OMPC_shared
             && !((Stack.isLoopControlVariable(FD).first) != 0)) {
            ImplicitFirstprivate.push_back(E);
          }
        }
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DSAAttrChecker::VisitOMPExecutableDirective">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 1555,
   FQN="(anonymous namespace)::DSAAttrChecker::VisitOMPExecutableDirective", NM="_ZN12_GLOBAL__N_114DSAAttrChecker27VisitOMPExecutableDirectiveEPN5clang22OMPExecutableDirectiveE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN12_GLOBAL__N_114DSAAttrChecker27VisitOMPExecutableDirectiveEPN5clang22OMPExecutableDirectiveE")
  //</editor-fold>
  public void VisitOMPExecutableDirective(OMPExecutableDirective /*P*/ S) {
    for (OMPClause /*P*/ C : S.clauses()) {
      // Skip analysis of arguments of implicitly defined firstprivate clause
      // for task directives.
      if ((C != null) && (!isa_OMPFirstprivateClause(C) || C.getLocStart().isValid())) {
        for (Stmt /*P*/ CC : C.children()) {
          if ((CC != null)) {
            Visit(CC);
          }
        }
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DSAAttrChecker::VisitStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 1566,
   FQN="(anonymous namespace)::DSAAttrChecker::VisitStmt", NM="_ZN12_GLOBAL__N_114DSAAttrChecker9VisitStmtEPN5clang4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN12_GLOBAL__N_114DSAAttrChecker9VisitStmtEPN5clang4StmtE")
  //</editor-fold>
  public void VisitStmt(Stmt /*P*/ S) {
    for (Stmt /*P*/ C : S.children()) {
      if ((C != null) && !isa_OMPExecutableDirective(C)) {
        Visit(C);
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DSAAttrChecker::isErrorFound">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 1573,
   FQN="(anonymous namespace)::DSAAttrChecker::isErrorFound", NM="_ZN12_GLOBAL__N_114DSAAttrChecker12isErrorFoundEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN12_GLOBAL__N_114DSAAttrChecker12isErrorFoundEv")
  //</editor-fold>
  public boolean isErrorFound() {
    return ErrorFound;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DSAAttrChecker::getImplicitFirstprivate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 1574,
   FQN="(anonymous namespace)::DSAAttrChecker::getImplicitFirstprivate", NM="_ZN12_GLOBAL__N_114DSAAttrChecker23getImplicitFirstprivateEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN12_GLOBAL__N_114DSAAttrChecker23getImplicitFirstprivateEv")
  //</editor-fold>
  public ArrayRef<Expr /*P*/ > getImplicitFirstprivate() {
    return new ArrayRef<Expr /*P*/ >(ImplicitFirstprivate, true);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DSAAttrChecker::getVarsWithInheritedDSA">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 1575,
   FQN="(anonymous namespace)::DSAAttrChecker::getVarsWithInheritedDSA", NM="_ZN12_GLOBAL__N_114DSAAttrChecker23getVarsWithInheritedDSAEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN12_GLOBAL__N_114DSAAttrChecker23getVarsWithInheritedDSAEv")
  //</editor-fold>
  public DenseMap<ValueDecl /*P*/ , Expr /*P*/ > /*&*/ getVarsWithInheritedDSA() {
    return VarsWithInheritedDSA;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DSAAttrChecker::DSAAttrChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 1579,
   FQN="(anonymous namespace)::DSAAttrChecker::DSAAttrChecker", NM="_ZN12_GLOBAL__N_114DSAAttrCheckerC1EPNS_10DSAStackTyERN5clang4SemaEPNS3_12CapturedStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN12_GLOBAL__N_114DSAAttrCheckerC1EPNS_10DSAStackTyERN5clang4SemaEPNS3_12CapturedStmtE")
  //</editor-fold>
  public DSAAttrChecker(DSAStackTy /*P*/ S, final Sema /*&*/ SemaRef, CapturedStmt /*P*/ CS) {
    // : StmtVisitor<DSAAttrChecker, void>(), Stack(S), SemaRef(SemaRef), ErrorFound(false), CS(CS), ImplicitFirstprivate(), VarsWithInheritedDSA() 
    //START JInit
    $StmtVisitor();
    this.Stack = S;
    this./*&*/SemaRef=/*&*/SemaRef;
    this.ErrorFound = false;
    this.CS = CS;
    this.ImplicitFirstprivate = new SmallVector<Expr /*P*/ >(8, (Expr /*P*/ )null);
    this.VarsWithInheritedDSA = new DenseMap<ValueDecl /*P*/ , Expr /*P*/ >(DenseMapInfo$LikePtr.$Info(), (Expr /*P*/ )null);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DSAAttrChecker::~DSAAttrChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 1454,
   FQN="(anonymous namespace)::DSAAttrChecker::~DSAAttrChecker", NM="_ZN12_GLOBAL__N_114DSAAttrCheckerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN12_GLOBAL__N_114DSAAttrCheckerD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    VarsWithInheritedDSA.$destroy();
    ImplicitFirstprivate.$destroy();
    //~StmtVisitorVoid<DSAAttrChecker>;
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "Stack=" + Stack // NOI18N
              + ", SemaRef=" + "[Sema]" // NOI18N
              + ", ErrorFound=" + ErrorFound // NOI18N
              + ", CS=" + CS // NOI18N
              + ", ImplicitFirstprivate=" + ImplicitFirstprivate // NOI18N
              + ", VarsWithInheritedDSA=" + VarsWithInheritedDSA // NOI18N
              + super.toString(); // NOI18N
  }
}
