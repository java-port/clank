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

import static org.clank.support.Native.$Deref;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.analysis.*;
import org.clang.basic.*;
import org.clang.staticanalyzer.core.bugreporter.ento.*;
import org.clang.staticanalyzer.core.ento.*;
import static org.clang.ast.AstClangGlobals.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type VirtualCallCheckerStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/VirtualCallChecker.cpp -nm=_ZN12_GLOBAL__N_17WalkASTE; -static-type=VirtualCallCheckerStatics")
//</editor-fold>
public final class VirtualCallCheckerStatics {

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::WalkAST">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/VirtualCallChecker.cpp", line = 30,
 FQN="(anonymous namespace)::WalkAST", NM="_ZN12_GLOBAL__N_17WalkASTE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/VirtualCallChecker.cpp -nm=_ZN12_GLOBAL__N_17WalkASTE")
//</editor-fold>
public static class WalkAST implements /*public*/ StmtVisitorVoid<WalkAST>, Destructors.ClassWithDestructor {
  private /*const*/ CheckerBase /*P*/ Checker;
  private final BugReporter /*&*/ BR;
  private AnalysisDeclContext /*P*/ AC;
  
  /*typedef const CallExpr *WorkListUnit*/
//  public final class WorkListUnit extends /*const*/ CallExpr /*P*/ { };
  /*typedef SmallVector<WorkListUnit, 20> DFSWorkList*/
//  public final class DFSWorkList extends SmallVector</*const*/ CallExpr /*P*/ >{ };
  
  /// A vector representing the worklist which has a chain of CallExprs.
  private SmallVector</*const*/ CallExpr /*P*/ > WList;
  
  // PreVisited : A CallExpr to this FunctionDecl is in the worklist, but the
  // body has not been visited yet.
  // PostVisited : A CallExpr to this FunctionDecl is in the worklist, and the
  // body has been visited.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::WalkAST::Kind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/VirtualCallChecker.cpp", line = 45,
   FQN="(anonymous namespace)::WalkAST::Kind", NM="_ZN12_GLOBAL__N_17WalkAST4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/VirtualCallChecker.cpp -nm=_ZN12_GLOBAL__N_17WalkAST4KindE")
  //</editor-fold>
  private enum Kind implements Native.ComparableLower {
    NotVisited(0),
    PreVisited(NotVisited.getValue() + 1), /**< A CallExpr to this FunctionDecl is in the
    worklist, but the body has not yet been
    visited. */
    PostVisited(PreVisited.getValue() + 1); /**< A CallExpr to this FunctionDecl is in the
    worklist, and the body has been visited. */

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static Kind valueOf(int val) {
      Kind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final Kind[] VALUES;
      private static final Kind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (Kind kind : Kind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new Kind[min < 0 ? (1-min) : 0];
        VALUES = new Kind[max >= 0 ? (1+max) : 0];
        for (Kind kind : Kind.values()) {
          if (kind.value < 0) {
            if (_VALUES[-kind.value] == null) {
              _VALUES[-kind.value] = kind;
            } else {
              assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          } else {
            if (VALUES[kind.value] == null) {
              VALUES[kind.value] = kind;
            } else {
              assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          }
        }
      }
    }

    private final /*uint*/int value;
    private Kind(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((Kind)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((Kind)obj).value);}
    //</editor-fold>
  };
  
  /// A DenseMap that records visited states of FunctionDecls.
  private DenseMap</*const*/ FunctionDecl /*P*/ , Kind> VisitedFunctions;
  
  /// The CallExpr whose body is currently being visited.  This is used for
  /// generating bug reports.  This is null while visiting the body of a
  /// constructor or destructor.
  private /*const*/ CallExpr /*P*/ visitingCallExpr;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::WalkAST::WalkAST">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/VirtualCallChecker.cpp", line = 62,
   FQN="(anonymous namespace)::WalkAST::WalkAST", NM="_ZN12_GLOBAL__N_17WalkASTC1EPKN5clang4ento11CheckerBaseERNS2_11BugReporterEPNS1_19AnalysisDeclContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/VirtualCallChecker.cpp -nm=_ZN12_GLOBAL__N_17WalkASTC1EPKN5clang4ento11CheckerBaseERNS2_11BugReporterEPNS1_19AnalysisDeclContextE")
  //</editor-fold>
  public WalkAST(/*const*/ CheckerBase /*P*/ checker, final BugReporter /*&*/ br, 
      AnalysisDeclContext /*P*/ ac) {
    // : StmtVisitor<WalkAST>(), Checker(checker), BR(br), AC(ac), WList(), VisitedFunctions(), visitingCallExpr(null) 
    //START JInit
    $StmtVisitor();
    this.Checker = checker;
    this./*&*/BR=/*&*/br;
    this.AC = ac;
    this.WList = new SmallVector</*const*/ CallExpr /*P*/ >(20, (/*const*/ CallExpr /*P*/ )null);
    this.VisitedFunctions = new DenseMap</*const*/ FunctionDecl /*P*/ , Kind>(DenseMapInfo$LikePtr.$Info(),null);
    this.visitingCallExpr = null;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::WalkAST::hasWork">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/VirtualCallChecker.cpp", line = 66,
   FQN="(anonymous namespace)::WalkAST::hasWork", NM="_ZNK12_GLOBAL__N_17WalkAST7hasWorkEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/VirtualCallChecker.cpp -nm=_ZNK12_GLOBAL__N_17WalkAST7hasWorkEv")
  //</editor-fold>
  public boolean hasWork() /*const*/ {
    return !WList.empty();
  }

  
  /// This method adds a CallExpr to the worklist and marks the callee as
  /// being PreVisited.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::WalkAST::Enqueue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/VirtualCallChecker.cpp", line = 70,
   FQN="(anonymous namespace)::WalkAST::Enqueue", NM="_ZN12_GLOBAL__N_17WalkAST7EnqueueEPKN5clang8CallExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/VirtualCallChecker.cpp -nm=_ZN12_GLOBAL__N_17WalkAST7EnqueueEPKN5clang8CallExprE")
  //</editor-fold>
  public void Enqueue(/*const*/ CallExpr /*P*/ WLUnit) {
    /*const*/ FunctionDecl /*P*/ FD = WLUnit.getDirectCallee$Const();
    if (!(FD != null) || !(FD.getBody() != null)) {
      return;
    }
    final type$ref<Kind /*&*/> K = VisitedFunctions.ref$at(FD);
    if (K.$deref() != Kind.NotVisited) {
      return;
    }
    K.$set(Kind.PreVisited);
    WList.push_back(WLUnit);
  }

  
  /// This method returns an item from the worklist without removing it.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::WalkAST::Dequeue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/VirtualCallChecker.cpp", line = 82,
   FQN="(anonymous namespace)::WalkAST::Dequeue", NM="_ZN12_GLOBAL__N_17WalkAST7DequeueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/VirtualCallChecker.cpp -nm=_ZN12_GLOBAL__N_17WalkAST7DequeueEv")
  //</editor-fold>
  public /*const*/ CallExpr /*P*/ Dequeue() {
    assert (!WList.empty());
    return WList.back();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::WalkAST::Execute">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/VirtualCallChecker.cpp", line = 87,
   FQN="(anonymous namespace)::WalkAST::Execute", NM="_ZN12_GLOBAL__N_17WalkAST7ExecuteEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/VirtualCallChecker.cpp -nm=_ZN12_GLOBAL__N_17WalkAST7ExecuteEv")
  //</editor-fold>
  public void Execute() {
    while (hasWork()) {
      /*const*/ CallExpr /*P*/ WLUnit = Dequeue();
      /*const*/ FunctionDecl /*P*/ FD = WLUnit.getDirectCallee$Const();
      assert ((FD != null) && (FD.getBody() != null));
      if (VisitedFunctions.$at_T1$C$R(FD) == Kind.PreVisited) {
        SaveAndRestore</*const*/ CallExpr /*P*/ > SaveCall = null;
        try {
          // If the callee is PreVisited, walk its body.
          // Visit the body.
          SaveCall/*J*/= new SaveAndRestore</*const*/ CallExpr /*P*/ >(visitingCallExpr$ref, WLUnit, true);
          Visit(FD.getBody());
          
          // Mark the function as being PostVisited to indicate we have
          // scanned the body.
          VisitedFunctions.$set(FD, Kind.PostVisited);
          continue;
        } finally {
          if (SaveCall != null) { SaveCall.$destroy(); }
        }
      }
      
      // Otherwise, the callee is PostVisited.
      // Remove it from the worklist.
      assert (VisitedFunctions.$at_T1$C$R(FD) == Kind.PostVisited);
      WList.pop_back();
    }
  }

  
  // Stmt visitor methods.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::WalkAST::VisitCallExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/VirtualCallChecker.cpp", line = 133,
   FQN="(anonymous namespace)::WalkAST::VisitCallExpr", NM="_ZN12_GLOBAL__N_17WalkAST13VisitCallExprEPN5clang8CallExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/VirtualCallChecker.cpp -nm=_ZN12_GLOBAL__N_17WalkAST13VisitCallExprEPN5clang8CallExprE")
  //</editor-fold>
  public void VisitCallExpr(CallExpr /*P*/ CE) {
    VisitChildren(CE);
    Enqueue(CE);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::WalkAST::VisitCXXMemberCallExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/VirtualCallChecker.cpp", line = 138,
   FQN="(anonymous namespace)::WalkAST::VisitCXXMemberCallExpr", NM="_ZN12_GLOBAL__N_17WalkAST22VisitCXXMemberCallExprEPN5clang8CallExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/VirtualCallChecker.cpp -nm=_ZN12_GLOBAL__N_17WalkAST22VisitCXXMemberCallExprEPN5clang8CallExprE")
  //</editor-fold>
  public void VisitCXXMemberCallExpr(CallExpr /*P*/ CE) {
    VisitChildren(CE);
    boolean callIsNonVirtual = false;
    {
      
      // Several situations to elide for checking.
      MemberExpr /*P*/ CME = dyn_cast_MemberExpr(CE.getCallee());
      if ((CME != null)) {
        // If the member access is fully qualified (i.e., X::F), then treat
        // this as a non-virtual call and do not warn.
        if ((CME.getQualifier() != null)) {
          callIsNonVirtual = true;
        }
        {
          
          Expr /*P*/ base = CME.getBase().IgnoreImpCasts();
          if ((base != null)) {
            // Elide analyzing the call entirely if the base pointer is not 'this'.
            if (!isa_CXXThisExpr(base)) {
              return;
            }
            
            // If the most derived class is marked final, we know that now subclass
            // can override this member.
            if (base.getBestDynamicClassType().hasAttr(FinalAttr.class)) {
              callIsNonVirtual = true;
            }
          }
        }
      }
    }
    
    // Get the callee.
    /*const*/ CXXMethodDecl /*P*/ MD = dyn_cast_CXXMethodDecl(CE.getDirectCallee());
    if ((MD != null) && MD.isVirtual() && !callIsNonVirtual && !MD.hasAttr(FinalAttr.class)
       && !MD.getParent$Const().hasAttr(FinalAttr.class)) {
      ReportVirtualCall(CE, MD.isPure());
    }
    
    Enqueue(CE);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::WalkAST::VisitStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/VirtualCallChecker.cpp", line = 115,
   FQN="(anonymous namespace)::WalkAST::VisitStmt", NM="_ZN12_GLOBAL__N_17WalkAST9VisitStmtEPN5clang4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/VirtualCallChecker.cpp -nm=_ZN12_GLOBAL__N_17WalkAST9VisitStmtEPN5clang4StmtE")
  //</editor-fold>
  public void VisitStmt(Stmt /*P*/ S) {
    VisitChildren(S);
  }

  // end anonymous namespace
  
  //===----------------------------------------------------------------------===//
  // AST walking.
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::WalkAST::VisitChildren">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/VirtualCallChecker.cpp", line = 127,
   FQN="(anonymous namespace)::WalkAST::VisitChildren", NM="_ZN12_GLOBAL__N_17WalkAST13VisitChildrenEPN5clang4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/VirtualCallChecker.cpp -nm=_ZN12_GLOBAL__N_17WalkAST13VisitChildrenEPN5clang4StmtE")
  //</editor-fold>
  public void VisitChildren(Stmt /*P*/ S) {
    for (Stmt /*P*/ Child : S.children())  {
      if ((Child != null)) {
        Visit(Child);
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::WalkAST::ReportVirtualCall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/VirtualCallChecker.cpp", line = 170,
   FQN="(anonymous namespace)::WalkAST::ReportVirtualCall", NM="_ZN12_GLOBAL__N_17WalkAST17ReportVirtualCallEPKN5clang8CallExprEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/VirtualCallChecker.cpp -nm=_ZN12_GLOBAL__N_17WalkAST17ReportVirtualCallEPKN5clang8CallExprEb")
  //</editor-fold>
  public void ReportVirtualCall(/*const*/ CallExpr /*P*/ CE, boolean isPure) {
    raw_svector_ostream os = null;
    try {
      SmallString/*100*/ buf/*J*/= new SmallString/*100*/(100);
      os/*J*/= new raw_svector_ostream(buf);
      
      os.$out(/*KEEP_STR*/"Call Path : ");
      // Name of current visiting CallExpr.
      $out_raw_ostream_NamedDecl$C(os, $Deref(CE.getDirectCallee$Const()));
      
      // Name of the CallExpr whose body is current walking.
      if ((visitingCallExpr != null)) {
        $out_raw_ostream_NamedDecl$C(os.$out(/*KEEP_STR*/" <-- "), $Deref(visitingCallExpr.getDirectCallee$Const()));
      }
      // Names of FunctionDecls in worklist with state PostVisited.
      for (type$ptr</*const*/ CallExpr /*P*/ /*P*/> I = $tryClone(WList.end()), 
          /*P*/ E = $tryClone(WList.begin()); $noteq_ptr(I, E); I.$preDec()) {
        /*const*/ FunctionDecl /*P*/ FD = ((I.$sub(1)).$star()).getDirectCallee$Const();
        assert Native.$bool(FD);
        if (VisitedFunctions.$at_T1$C$R(FD) == Kind.PostVisited) {
          $out_raw_ostream_NamedDecl$C(os.$out(/*KEEP_STR*/" <-- "), $Deref(FD));
        }
      }
      
      PathDiagnosticLocation CELoc = PathDiagnosticLocation.createBegin(CE, BR.getSourceManager(), new PointerUnion</*const*/ LocationContext /*P*/ , AnalysisDeclContext /*P*/ >(JD$T1.INSTANCE, AnalysisDeclContext /*P*/.class, AC));
      SourceRange R = CE.getCallee$Const().getSourceRange();
      if (isPure) {
        os.$out(/*KEEP_STR*/$LF).$out(/*KEEP_STR*/"Call pure virtual functions during construction or ").$out(
            /*KEEP_STR*/"destruction may leads undefined behaviour"
        );
        BR.EmitBasicReport(AC.getDecl(), Checker, 
            new StringRef(/*KEEP_STR*/"Call pure virtual function during construction or Destruction"), 
            new StringRef(/*KEEP_STR*/"Cplusplus"), os.str(), new PathDiagnosticLocation(CELoc), new ArrayRef<SourceRange>(R, false));
        return;
      } else {
        os.$out(/*KEEP_STR*/$LF).$out(/*KEEP_STR*/"Call virtual functions during construction or ").$out(
            /*KEEP_STR*/"destruction will never go to a more derived class"
        );
        BR.EmitBasicReport(AC.getDecl(), Checker, 
            new StringRef(/*KEEP_STR*/"Call virtual function during construction or Destruction"), 
            new StringRef(/*KEEP_STR*/"Cplusplus"), os.str(), new PathDiagnosticLocation(CELoc), new ArrayRef<SourceRange>(R, false));
        return;
      }
    } finally {
      if (os != null) { os.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::WalkAST::~WalkAST">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/VirtualCallChecker.cpp", line = 30,
   FQN="(anonymous namespace)::WalkAST::~WalkAST", NM="_ZN12_GLOBAL__N_17WalkASTD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/VirtualCallChecker.cpp -nm=_ZN12_GLOBAL__N_17WalkASTD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    VisitedFunctions.$destroy();
    WList.$destroy();
    StmtVisitorVoid.super.$destroy$StmtVisitor();
    //END JDestroy
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  private type$ref</*const*/ CallExpr /*P*/> visitingCallExpr$ref = new type$ref</*const*/ CallExpr /*P*/>(){
    @Override
    public CallExpr $deref() {
      return visitingCallExpr;
    }
  
    @Override
    public CallExpr $set(CallExpr value) {
      visitingCallExpr = value;
      return visitingCallExpr;
    }
  };


  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Checker=" + Checker // NOI18N
              + ", BR=" + BR // NOI18N
              + ", AC=" + "[AnalysisDeclContext]" // NOI18N
              + ", WList=" + WList // NOI18N
              + ", VisitedFunctions=" + VisitedFunctions // NOI18N
              + ", visitingCallExpr=" + visitingCallExpr // NOI18N
              + super.toString(); // NOI18N
  }
}
} // END OF class VirtualCallCheckerStatics
