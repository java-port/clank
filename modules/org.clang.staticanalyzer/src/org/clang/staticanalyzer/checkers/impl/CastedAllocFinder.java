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
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.basic.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CastedAllocFinder">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocSizeofChecker.cpp", line = 34,
 FQN="(anonymous namespace)::CastedAllocFinder", NM="_ZN12_GLOBAL__N_117CastedAllocFinderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocSizeofChecker.cpp -nm=_ZN12_GLOBAL__N_117CastedAllocFinderE")
//</editor-fold>
public class CastedAllocFinder implements /*public*/ ConstStmtVisitor<CastedAllocFinder, std.pairPtrPtr</*const*/ TypeSourceInfo /*P*/ , /*const*/ CallExpr /*P*/ > >, Destructors.ClassWithDestructor {
  private IdentifierInfo /*P*/ II_malloc;
  private IdentifierInfo /*P*/ II_calloc;
  private IdentifierInfo /*P*/ II_realloc;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CastedAllocFinder::CallRecord">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocSizeofChecker.cpp", line = 39,
   FQN="(anonymous namespace)::CastedAllocFinder::CallRecord", NM="_ZN12_GLOBAL__N_117CastedAllocFinder10CallRecordE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocSizeofChecker.cpp -nm=_ZN12_GLOBAL__N_117CastedAllocFinder10CallRecordE")
  //</editor-fold>
  public static class/*struct*/ CallRecord implements NativeCloneable<CallRecord> {
    public PointerUnion</*const*/ Stmt /*P*/ , /*const*/ VarDecl /*P*/ > CastedExprParent;
    public /*const*/ Expr /*P*/ CastedExpr;
    public /*const*/ TypeSourceInfo /*P*/ ExplicitCastType;
    public /*const*/ CallExpr /*P*/ AllocCall;
    
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CastedAllocFinder::CallRecord::CallRecord">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocSizeofChecker.cpp", line = 45,
     FQN="(anonymous namespace)::CastedAllocFinder::CallRecord::CallRecord", NM="_ZN12_GLOBAL__N_117CastedAllocFinder10CallRecordC1EN4llvm12PointerUnionIPKN5clang4StmtEPKNS4_7VarDeclEEEPKNS4_4ExprEPKNS4_14TypeSourceInfoEPKNS4_8CallExprE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocSizeofChecker.cpp -nm=_ZN12_GLOBAL__N_117CastedAllocFinder10CallRecordC1EN4llvm12PointerUnionIPKN5clang4StmtEPKNS4_7VarDeclEEEPKNS4_4ExprEPKNS4_14TypeSourceInfoEPKNS4_8CallExprE")
    //</editor-fold>
    public CallRecord(PointerUnion</*const*/ Stmt /*P*/ , /*const*/ VarDecl /*P*/ > CastedExprParent, /*const*/ Expr /*P*/ CastedExpr, 
        /*const*/ TypeSourceInfo /*P*/ ExplicitCastType, 
        /*const*/ CallExpr /*P*/ AllocCall) {
      // : CastedExprParent(CastedExprParent), CastedExpr(CastedExpr), ExplicitCastType(ExplicitCastType), AllocCall(AllocCall) 
      //START JInit
      this.CastedExprParent = new PointerUnion</*const*/ Stmt /*P*/ , /*const*/ VarDecl /*P*/ >(CastedExprParent);
      this.CastedExpr = CastedExpr;
      this.ExplicitCastType = ExplicitCastType;
      this.AllocCall = AllocCall;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CastedAllocFinder::CallRecord::CallRecord">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocSizeofChecker.cpp", line = 39,
     FQN="(anonymous namespace)::CastedAllocFinder::CallRecord::CallRecord", NM="_ZN12_GLOBAL__N_117CastedAllocFinder10CallRecordC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocSizeofChecker.cpp -nm=_ZN12_GLOBAL__N_117CastedAllocFinder10CallRecordC1EOS1_")
    //</editor-fold>
    public /*inline*/ CallRecord(JD$Move _dparam, final CallRecord /*&&*/$Prm0) {
      // : CastedExprParent(static_cast<CallRecord &&>().CastedExprParent), CastedExpr(static_cast<CallRecord &&>().CastedExpr), ExplicitCastType(static_cast<CallRecord &&>().ExplicitCastType), AllocCall(static_cast<CallRecord &&>().AllocCall) 
      //START JInit
      this.CastedExprParent = new PointerUnion</*const*/ Stmt /*P*/ , /*const*/ VarDecl /*P*/ >(JD$Move.INSTANCE, $Prm0.CastedExprParent);
      this.CastedExpr = $Prm0.CastedExpr;
      this.ExplicitCastType = $Prm0.ExplicitCastType;
      this.AllocCall = $Prm0.AllocCall;
      //END JInit
    }

    private CallRecord() {
      this.CastedExprParent = new PointerUnion</*const*/ Stmt /*P*/ , /*const*/ VarDecl /*P*/ >(/*const*/ Stmt /*P*/.class);
    }

    public /*inline*/ CallRecord(final CallRecord /*&&*/$Prm0) {
      // : CastedExprParent(static_cast<CallRecord &&>().CastedExprParent), CastedExpr(static_cast<CallRecord &&>().CastedExpr), ExplicitCastType(static_cast<CallRecord &&>().ExplicitCastType), AllocCall(static_cast<CallRecord &&>().AllocCall) 
      //START JInit
      this.CastedExprParent = new PointerUnion</*const*/ Stmt /*P*/ , /*const*/ VarDecl /*P*/ >($Prm0.CastedExprParent);
      this.CastedExpr = $Prm0.CastedExpr;
      this.ExplicitCastType = $Prm0.ExplicitCastType;
      this.AllocCall = $Prm0.AllocCall;
      //END JInit
    }
    
    @Override public CallRecord clone() {
      return new CallRecord(this);
    }
    
    @Override public String toString() {
      return "" + "CastedExprParent=" + CastedExprParent // NOI18N
                + ", CastedExpr=" + CastedExpr // NOI18N
                + ", ExplicitCastType=" + ExplicitCastType // NOI18N
                + ", AllocCall=" + AllocCall; // NOI18N
    }

  };
  
  /*typedef std::vector<CallRecord> CallVec*/
//  public final class CallVec extends std.vector<CallRecord>{ };
  public std.vector<CallRecord> Calls;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CastedAllocFinder::CastedAllocFinder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocSizeofChecker.cpp", line = 55,
   FQN="(anonymous namespace)::CastedAllocFinder::CastedAllocFinder", NM="_ZN12_GLOBAL__N_117CastedAllocFinderC1EPN5clang10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocSizeofChecker.cpp -nm=_ZN12_GLOBAL__N_117CastedAllocFinderC1EPN5clang10ASTContextE")
  //</editor-fold>
  public CastedAllocFinder(ASTContext /*P*/ Ctx) {
    // : ConstStmtVisitor<CastedAllocFinder, TypeCallPair>(), II_malloc(&Ctx->Idents.get("malloc")), II_calloc(&Ctx->Idents.get("calloc")), II_realloc(&Ctx->Idents.get("realloc")), Calls() 
    //START JInit
    $ConstStmtVisitor();
    this.II_malloc = $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"malloc")));
    this.II_calloc = $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"calloc")));
    this.II_realloc = $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"realloc")));
    this.Calls = new std.vector<CallRecord>(new CallRecord());
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CastedAllocFinder::VisitChild">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocSizeofChecker.cpp", line = 60,
   FQN="(anonymous namespace)::CastedAllocFinder::VisitChild", NM="_ZN12_GLOBAL__N_117CastedAllocFinder10VisitChildEN4llvm12PointerUnionIPKN5clang4StmtEPKNS3_7VarDeclEEES6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocSizeofChecker.cpp -nm=_ZN12_GLOBAL__N_117CastedAllocFinder10VisitChildEN4llvm12PointerUnionIPKN5clang4StmtEPKNS3_7VarDeclEEES6_")
  //</editor-fold>
  public void VisitChild(PointerUnion</*const*/ Stmt /*P*/ , /*const*/ VarDecl /*P*/ > Parent, /*const*/ Stmt /*P*/ S) {
    std.pairPtrPtr</*const*/ TypeSourceInfo /*P*/ , /*const*/ CallExpr /*P*/ > AllocCall = Visit(S);
    if ((AllocCall.second != null) && AllocCall.second != S) {
      Calls.push_back_T$RR(new CallRecord(new PointerUnion</*const*/ Stmt /*P*/ , /*const*/ VarDecl /*P*/ >(Parent), cast_Expr(S), AllocCall.first, 
              AllocCall.second));
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CastedAllocFinder::VisitChildren">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocSizeofChecker.cpp", line = 67,
   FQN="(anonymous namespace)::CastedAllocFinder::VisitChildren", NM="_ZN12_GLOBAL__N_117CastedAllocFinder13VisitChildrenEPKN5clang4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocSizeofChecker.cpp -nm=_ZN12_GLOBAL__N_117CastedAllocFinder13VisitChildrenEPKN5clang4StmtE")
  //</editor-fold>
  public void VisitChildren(/*const*/ Stmt /*P*/ S) {
    for (/*const*/ Stmt /*P*/ Child : S.children$Const())  {
      if ((Child != null)) {
        VisitChild(new PointerUnion</*const*/ Stmt /*P*/ , /*const*/ VarDecl /*P*/ >(JD$T.INSTANCE, /*const*/ Stmt /*P*/.class, S), Child);
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CastedAllocFinder::VisitCastExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocSizeofChecker.cpp", line = 73,
   FQN="(anonymous namespace)::CastedAllocFinder::VisitCastExpr", NM="_ZN12_GLOBAL__N_117CastedAllocFinder13VisitCastExprEPKN5clang8CastExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocSizeofChecker.cpp -nm=_ZN12_GLOBAL__N_117CastedAllocFinder13VisitCastExprEPKN5clang8CastExprE")
  //</editor-fold>
  public std.pairPtrPtr</*const*/ TypeSourceInfo /*P*/ , /*const*/ CallExpr /*P*/ > VisitCastExpr(/*const*/ CastExpr /*P*/ E) {
    return Visit(E.getSubExpr$Const());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CastedAllocFinder::VisitExplicitCastExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocSizeofChecker.cpp", line = 77,
   FQN="(anonymous namespace)::CastedAllocFinder::VisitExplicitCastExpr", NM="_ZN12_GLOBAL__N_117CastedAllocFinder21VisitExplicitCastExprEPKN5clang16ExplicitCastExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocSizeofChecker.cpp -nm=_ZN12_GLOBAL__N_117CastedAllocFinder21VisitExplicitCastExprEPKN5clang16ExplicitCastExprE")
  //</editor-fold>
  public std.pairPtrPtr</*const*/ TypeSourceInfo /*P*/ , /*const*/ CallExpr /*P*/ > VisitExplicitCastExpr(/*const*/ ExplicitCastExpr /*P*/ E) {
    return new std.pairPtrPtr</*const*/ TypeSourceInfo /*P*/ , /*const*/ CallExpr /*P*/ >(JD$T$RR_T1$RR.INSTANCE, E.getTypeInfoAsWritten(), 
        Visit(E.getSubExpr$Const()).second);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CastedAllocFinder::VisitParenExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocSizeofChecker.cpp", line = 82,
   FQN="(anonymous namespace)::CastedAllocFinder::VisitParenExpr", NM="_ZN12_GLOBAL__N_117CastedAllocFinder14VisitParenExprEPKN5clang9ParenExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocSizeofChecker.cpp -nm=_ZN12_GLOBAL__N_117CastedAllocFinder14VisitParenExprEPKN5clang9ParenExprE")
  //</editor-fold>
  public std.pairPtrPtr</*const*/ TypeSourceInfo /*P*/ , /*const*/ CallExpr /*P*/ > VisitParenExpr(/*const*/ ParenExpr /*P*/ E) {
    return Visit(E.getSubExpr$Const());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CastedAllocFinder::VisitStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocSizeofChecker.cpp", line = 86,
   FQN="(anonymous namespace)::CastedAllocFinder::VisitStmt", NM="_ZN12_GLOBAL__N_117CastedAllocFinder9VisitStmtEPKN5clang4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocSizeofChecker.cpp -nm=_ZN12_GLOBAL__N_117CastedAllocFinder9VisitStmtEPKN5clang4StmtE")
  //</editor-fold>
  public std.pairPtrPtr</*const*/ TypeSourceInfo /*P*/ , /*const*/ CallExpr /*P*/ > VisitStmt(/*const*/ Stmt /*P*/ S) {
    VisitChildren(S);
    return new std.pairPtrPtr</*const*/ TypeSourceInfo /*P*/ , /*const*/ CallExpr /*P*/ >();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CastedAllocFinder::VisitCallExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocSizeofChecker.cpp", line = 91,
   FQN="(anonymous namespace)::CastedAllocFinder::VisitCallExpr", NM="_ZN12_GLOBAL__N_117CastedAllocFinder13VisitCallExprEPKN5clang8CallExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocSizeofChecker.cpp -nm=_ZN12_GLOBAL__N_117CastedAllocFinder13VisitCallExprEPKN5clang8CallExprE")
  //</editor-fold>
  public std.pairPtrPtr</*const*/ TypeSourceInfo /*P*/ , /*const*/ CallExpr /*P*/ > VisitCallExpr(/*const*/ CallExpr /*P*/ E) {
    VisitChildren(E);
    /*const*/ FunctionDecl /*P*/ FD = E.getDirectCallee$Const();
    if ((FD != null)) {
      IdentifierInfo /*P*/ II = FD.getIdentifier();
      if (II == II_malloc || II == II_calloc || II == II_realloc) {
        return new std.pairPtrPtr</*const*/ TypeSourceInfo /*P*/ , /*const*/ CallExpr /*P*/ >(JD$T$RR_T1$RR.INSTANCE, (/*const*/ TypeSourceInfo /*P*/ )(/*const*/ TypeSourceInfo /*P*/ )null, E);
      }
    }
    return new std.pairPtrPtr</*const*/ TypeSourceInfo /*P*/ , /*const*/ CallExpr /*P*/ >();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CastedAllocFinder::VisitDeclStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocSizeofChecker.cpp", line = 102,
   FQN="(anonymous namespace)::CastedAllocFinder::VisitDeclStmt", NM="_ZN12_GLOBAL__N_117CastedAllocFinder13VisitDeclStmtEPKN5clang8DeclStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocSizeofChecker.cpp -nm=_ZN12_GLOBAL__N_117CastedAllocFinder13VisitDeclStmtEPKN5clang8DeclStmtE")
  //</editor-fold>
  public std.pairPtrPtr</*const*/ TypeSourceInfo /*P*/ , /*const*/ CallExpr /*P*/ > VisitDeclStmt(/*const*/ DeclStmt /*P*/ S) {
    for (/*const*/ Decl /*P*/ I : S.decls$Const())  {
      {
        /*const*/ VarDecl /*P*/ VD = dyn_cast_VarDecl(I);
        if ((VD != null)) {
          {
            /*const*/ Expr /*P*/ Init = VD.getInit$Const();
            if ((Init != null)) {
              VisitChild(new PointerUnion</*const*/ Stmt /*P*/ , /*const*/ VarDecl /*P*/ >(JD$T1.INSTANCE, /*const*/ VarDecl /*P*/.class, VD), Init);
            }
          }
        }
      }
    }
    return new std.pairPtrPtr</*const*/ TypeSourceInfo /*P*/ , /*const*/ CallExpr /*P*/ >();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CastedAllocFinder::~CastedAllocFinder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocSizeofChecker.cpp", line = 34,
   FQN="(anonymous namespace)::CastedAllocFinder::~CastedAllocFinder", NM="_ZN12_GLOBAL__N_117CastedAllocFinderD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocSizeofChecker.cpp -nm=_ZN12_GLOBAL__N_117CastedAllocFinderD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    Calls.$destroy();
    ConstStmtVisitor.super.$destroy$ConstStmtVisitor();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "II_malloc=" + II_malloc // NOI18N
              + ", II_calloc=" + II_calloc // NOI18N
              + ", II_realloc=" + II_realloc // NOI18N
              + ", Calls=" + Calls // NOI18N
              + super.toString(); // NOI18N
  }
}
