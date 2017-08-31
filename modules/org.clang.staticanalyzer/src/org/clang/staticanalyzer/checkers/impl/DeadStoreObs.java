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
import org.clank.java.*;
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
import org.clang.staticanalyzer.checkers.impl.*;
import org.clang.staticanalyzer.core.bugreporter.ento.*;
import org.clang.staticanalyzer.core.ento.*;
import static org.clang.ast.AstClangGlobals.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import org.clang.analysis.analyses.*;
import static org.clang.staticanalyzer.checkers.impl.DeadStoresCheckerStatics.*;
import static org.clang.ast.java.AstStatementsRTTI.*;


//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeadStoreObs">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DeadStoresChecker.cpp", line = 123,
 FQN="(anonymous namespace)::DeadStoreObs", NM="_ZN12_GLOBAL__N_112DeadStoreObsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DeadStoresChecker.cpp -nm=_ZN12_GLOBAL__N_112DeadStoreObsE")
//</editor-fold>
public class DeadStoreObs extends /*public*/ LiveVariables.Observer implements Destructors.ClassWithDestructor {
  private final /*const*/ CFG /*&*/ cfg;
  private final ASTContext /*&*/ Ctx;
  private final BugReporter /*&*/ BR;
  private /*const*/ CheckerBase /*P*/ Checker;
  private AnalysisDeclContext /*P*/ AC;
  private final ParentMap /*&*/ Parents;
  private SmallPtrSet</*const*/ VarDecl /*P*/ > Escaped;
  private std.unique_ptr<ReachableCode> reachableCode;
  private /*const*/ CFGBlock /*P*/ currentBlock;
  private std.unique_ptr<DenseSet</*const*/ VarDecl /*P*/ > > InEH;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeadStoreObs::DeadStoreKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DeadStoresChecker.cpp", line = 135,
   FQN="(anonymous namespace)::DeadStoreObs::DeadStoreKind", NM="_ZN12_GLOBAL__N_112DeadStoreObs13DeadStoreKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DeadStoresChecker.cpp -nm=_ZN12_GLOBAL__N_112DeadStoreObs13DeadStoreKindE")
  //</editor-fold>
  private enum DeadStoreKind implements Native.ComparableLower {
    Standard(0),
    Enclosing(Standard.getValue() + 1),
    DeadIncrement(Enclosing.getValue() + 1),
    DeadInit(DeadIncrement.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static DeadStoreKind valueOf(int val) {
      DeadStoreKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final DeadStoreKind[] VALUES;
      private static final DeadStoreKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (DeadStoreKind kind : DeadStoreKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new DeadStoreKind[min < 0 ? (1-min) : 0];
        VALUES = new DeadStoreKind[max >= 0 ? (1+max) : 0];
        for (DeadStoreKind kind : DeadStoreKind.values()) {
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
    private DeadStoreKind(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((DeadStoreKind)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((DeadStoreKind)obj).value);}
    //</editor-fold>
  };
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeadStoreObs::DeadStoreObs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DeadStoresChecker.cpp", line = 138,
   FQN="(anonymous namespace)::DeadStoreObs::DeadStoreObs", NM="_ZN12_GLOBAL__N_112DeadStoreObsC1ERKN5clang3CFGERNS1_10ASTContextERNS1_4ento11BugReporterEPKNS7_11CheckerBaseEPNS1_19AnalysisDeclContextERNS1_9ParentMapERN4llvm11SmallPtrSetIPKNS1_7VarDeclELj20EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DeadStoresChecker.cpp -nm=_ZN12_GLOBAL__N_112DeadStoreObsC1ERKN5clang3CFGERNS1_10ASTContextERNS1_4ento11BugReporterEPKNS7_11CheckerBaseEPNS1_19AnalysisDeclContextERNS1_9ParentMapERN4llvm11SmallPtrSetIPKNS1_7VarDeclELj20EEE")
  //</editor-fold>
  public DeadStoreObs(final /*const*/ CFG /*&*/ cfg, final ASTContext /*&*/ ctx, final BugReporter /*&*/ br, 
      /*const*/ CheckerBase /*P*/ checker, AnalysisDeclContext /*P*/ ac, 
      final ParentMap /*&*/ parents, 
      final SmallPtrSet</*const*/ VarDecl /*P*/ > /*&*/ escaped) {
    // : LiveVariables::Observer(), cfg(cfg), Ctx(ctx), BR(br), Checker(checker), AC(ac), Parents(parents), Escaped(escaped), reachableCode(), currentBlock(null), InEH() 
    //START JInit
    super();
    this./*&*/cfg=/*&*/cfg;
    this./*&*/Ctx=/*&*/ctx;
    this./*&*/BR=/*&*/br;
    this.Checker = checker;
    this.AC = ac;
    this./*&*/Parents=/*&*/parents;
    this.Escaped = new SmallPtrSet</*const*/ VarDecl /*P*/ >(escaped);
    this.reachableCode = new std.unique_ptr<ReachableCode>();
    this.currentBlock = null;
    this.InEH = new std.unique_ptr<DenseSet</*const*/ VarDecl /*P*/ > >();
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeadStoreObs::~DeadStoreObs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DeadStoresChecker.cpp", line = 145,
   FQN="(anonymous namespace)::DeadStoreObs::~DeadStoreObs", NM="_ZN12_GLOBAL__N_112DeadStoreObsD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DeadStoresChecker.cpp -nm=_ZN12_GLOBAL__N_112DeadStoreObsD0Ev")
  //</editor-fold>
  @Override public void $destroy()/* override*/ {
    //START JDestroy
    InEH.$destroy();
    reachableCode.$destroy();
    Escaped.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeadStoreObs::isLive">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DeadStoresChecker.cpp", line = 147,
   FQN="(anonymous namespace)::DeadStoreObs::isLive", NM="_ZN12_GLOBAL__N_112DeadStoreObs6isLiveERKN5clang13LiveVariables14LivenessValuesEPKNS1_7VarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DeadStoresChecker.cpp -nm=_ZN12_GLOBAL__N_112DeadStoreObs6isLiveERKN5clang13LiveVariables14LivenessValuesEPKNS1_7VarDeclE")
  //</editor-fold>
  public boolean isLive(final /*const*/ LiveVariables.LivenessValues /*&*/ Live, /*const*/ VarDecl /*P*/ D) {
    if (Live.isLive(D)) {
      return true;
    }
    // Lazily construct the set that records which VarDecls are in
    // EH code.
    if (!(InEH.get() != null)) {
      InEH.reset(new DenseSet</*const*/ VarDecl /*P*/ >(DenseMapInfo$LikePtr.$Info()));
      EHCodeVisitor V/*J*/= new EHCodeVisitor($Deref(InEH.get()));
      V.TraverseStmt(AC.getBody());
    }
    // Treat all VarDecls that occur in EH code as being "always live"
    // when considering to suppress dead stores.  Frequently stores
    // are followed by reads in EH code, but we don't have the ability
    // to analyze that yet.
    return (InEH.$arrow().count(D) != 0);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeadStoreObs::Report">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DeadStoresChecker.cpp", line = 164,
   FQN="(anonymous namespace)::DeadStoreObs::Report", NM="_ZN12_GLOBAL__N_112DeadStoreObs6ReportEPKN5clang7VarDeclENS0_13DeadStoreKindENS1_4ento22PathDiagnosticLocationENS1_11SourceRangeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DeadStoresChecker.cpp -nm=_ZN12_GLOBAL__N_112DeadStoreObs6ReportEPKN5clang7VarDeclENS0_13DeadStoreKindENS1_4ento22PathDiagnosticLocationENS1_11SourceRangeE")
  //</editor-fold>
  public void Report(/*const*/ VarDecl /*P*/ V, DeadStoreKind dsk, 
        PathDiagnosticLocation L, SourceRange R) {
    raw_svector_ostream os = null;
    try {
      if ((Escaped.count(V) != 0)) {
        return;
      }
      
      // Compute reachable blocks within the CFG for trivial cases
      // where a bogus dead store can be reported because itself is unreachable.
      if (!(reachableCode.get() != null)) {
        reachableCode.reset(new ReachableCode(cfg));
        reachableCode.$arrow().computeReachableBlocks();
      }
      if (!reachableCode.$arrow().isReachable(currentBlock)) {
        return;
      }
      
      SmallString/*64*/ buf/*J*/= new SmallString/*64*/(64);
      os/*J*/= new raw_svector_ostream(buf);
      /*const*/char$ptr/*char P*/ BugType = null;
      switch (dsk) {
       case DeadInit:
        BugType = $tryClone($("Dead initialization"));
        $out_raw_ostream_NamedDecl$C(os.$out(/*KEEP_STR*/"Value stored to '"), $Deref(V)).$out(
            /*KEEP_STR*/"' during its initialization is never read"
        );
        break;
       case DeadIncrement:
        BugType = $tryClone($("Dead increment"));
       case Standard:
        if (!Native.$bool(BugType)) {
          BugType = $tryClone($("Dead assignment"));
        }
        $out_raw_ostream_NamedDecl$C(os.$out(/*KEEP_STR*/"Value stored to '"), $Deref(V)).$out(/*KEEP_STR*/"' is never read");
        break;
       case Enclosing:
        // Don't report issues in this case, e.g.: "if (x = foo())",
        // where 'x' is unused later.  We have yet to see a case where
        // this is a real bug.
        return;
      }
      
      BR.EmitBasicReport(AC.getDecl(), Checker, new StringRef(BugType), new StringRef(/*KEEP_STR*/"Dead store"), os.str(), 
          new PathDiagnosticLocation(L), new ArrayRef<SourceRange>(R, false));
    } finally {
      if (os != null) { os.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeadStoreObs::CheckVarDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DeadStoresChecker.cpp", line = 208,
   FQN="(anonymous namespace)::DeadStoreObs::CheckVarDecl", NM="_ZN12_GLOBAL__N_112DeadStoreObs12CheckVarDeclEPKN5clang7VarDeclEPKNS1_4ExprES7_NS0_13DeadStoreKindERKNS1_13LiveVariables14LivenessValuesE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DeadStoresChecker.cpp -nm=_ZN12_GLOBAL__N_112DeadStoreObs12CheckVarDeclEPKN5clang7VarDeclEPKNS1_4ExprES7_NS0_13DeadStoreKindERKNS1_13LiveVariables14LivenessValuesE")
  //</editor-fold>
  public void CheckVarDecl(/*const*/ VarDecl /*P*/ VD, /*const*/ Expr /*P*/ Ex, /*const*/ Expr /*P*/ Val, 
              DeadStoreKind dsk, 
              final /*const*/ LiveVariables.LivenessValues /*&*/ Live) {
    if (!VD.hasLocalStorage()) {
      return;
    }
    // Reference types confuse the dead stores checker.  Skip them
    // for now.
    if ((VD.getType().$arrow().getAs(ReferenceType.class) != null)) {
      return;
    }
    if (!isLive(Live, VD)
       && !(VD.hasAttr(UnusedAttr.class) || VD.hasAttr(BlocksAttr.class)
       || VD.hasAttr(ObjCPreciseLifetimeAttr.class))) {
      
      PathDiagnosticLocation ExLoc = PathDiagnosticLocation.createBegin(Ex, BR.getSourceManager(), new PointerUnion</*const*/ LocationContext /*P*/ , AnalysisDeclContext /*P*/ >(JD$T1.INSTANCE, AnalysisDeclContext /*P*/.class, AC));
      Report(VD, dsk, new PathDiagnosticLocation(ExLoc), Val.getSourceRange());
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeadStoreObs::CheckDeclRef">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DeadStoresChecker.cpp", line = 229,
   FQN="(anonymous namespace)::DeadStoreObs::CheckDeclRef", NM="_ZN12_GLOBAL__N_112DeadStoreObs12CheckDeclRefEPKN5clang11DeclRefExprEPKNS1_4ExprENS0_13DeadStoreKindERKNS1_13LiveVariables14LivenessValuesE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DeadStoresChecker.cpp -nm=_ZN12_GLOBAL__N_112DeadStoreObs12CheckDeclRefEPKN5clang11DeclRefExprEPKNS1_4ExprENS0_13DeadStoreKindERKNS1_13LiveVariables14LivenessValuesE")
  //</editor-fold>
  public void CheckDeclRef(/*const*/ DeclRefExpr /*P*/ DR, /*const*/ Expr /*P*/ Val, DeadStoreKind dsk, 
              final /*const*/ LiveVariables.LivenessValues /*&*/ Live) {
    {
      /*const*/ VarDecl /*P*/ VD = dyn_cast_VarDecl(DR.getDecl$Const());
      if ((VD != null)) {
        CheckVarDecl(VD, DR, Val, dsk, Live);
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeadStoreObs::isIncrement">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DeadStoresChecker.cpp", line = 235,
   FQN="(anonymous namespace)::DeadStoreObs::isIncrement", NM="_ZN12_GLOBAL__N_112DeadStoreObs11isIncrementEPN5clang7VarDeclEPKNS1_14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DeadStoresChecker.cpp -nm=_ZN12_GLOBAL__N_112DeadStoreObs11isIncrementEPN5clang7VarDeclEPKNS1_14BinaryOperatorE")
  //</editor-fold>
  public boolean isIncrement(VarDecl /*P*/ VD, /*const*/ BinaryOperator /*P*/ B) {
    if (B.isCompoundAssignmentOp()) {
      return true;
    }
    
    /*const*/ Expr /*P*/ RHS = B.getRHS().IgnoreParenCasts();
    /*const*/ BinaryOperator /*P*/ BRHS = dyn_cast_BinaryOperator(RHS);
    if (!(BRHS != null)) {
      return false;
    }
    
    /*const*/ DeclRefExpr /*P*/ DR;
    if (((DR = dyn_cast_DeclRefExpr(BRHS.getLHS().IgnoreParenCasts())) != null)) {
      if (DR.getDecl$Const() == VD) {
        return true;
      }
    }
    if (((DR = dyn_cast_DeclRefExpr(BRHS.getRHS().IgnoreParenCasts())) != null)) {
      if (DR.getDecl$Const() == VD) {
        return true;
      }
    }
    
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DeadStoreObs::observeStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DeadStoresChecker.cpp", line = 258,
   FQN="(anonymous namespace)::DeadStoreObs::observeStmt", NM="_ZN12_GLOBAL__N_112DeadStoreObs11observeStmtEPKN5clang4StmtEPKNS1_8CFGBlockERKNS1_13LiveVariables14LivenessValuesE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/DeadStoresChecker.cpp -nm=_ZN12_GLOBAL__N_112DeadStoreObs11observeStmtEPKN5clang4StmtEPKNS1_8CFGBlockERKNS1_13LiveVariables14LivenessValuesE")
  //</editor-fold>
  @Override public void observeStmt(/*const*/ Stmt /*P*/ S, /*const*/ CFGBlock /*P*/ block, 
             final /*const*/ LiveVariables.LivenessValues /*&*/ Live)/* override*/ {
    
    currentBlock = block;
    
    // Skip statements in macros.
    if (S.getLocStart().isMacroID()) {
      return;
    }
    {
      
      // Only cover dead stores from regular assignments.  ++/-- dead stores
      // have never flagged a real bug.
      /*const*/ BinaryOperator /*P*/ B = dyn_cast_BinaryOperator(S);
      if ((B != null)) {
        if (!B.isAssignmentOp()) {
          return; // Skip non-assignments.
        }
        {
          
          DeclRefExpr /*P*/ DR = dyn_cast_DeclRefExpr(B.getLHS());
          if ((DR != null)) {
            {
              VarDecl /*P*/ VD = dyn_cast_VarDecl(DR.getDecl());
              if ((VD != null)) {
                // Special case: check for assigning null to a pointer.
                //  This is a common form of defensive programming.
                /*const*/ Expr /*P*/ RHS = LookThroughTransitiveAssignmentsAndCommaOperators(B.getRHS());
                RHS = RHS.IgnoreParenCasts$Const();
                
                QualType T = VD.getType();
                if (T.isVolatileQualified()) {
                  return;
                }
                if (T.$arrow().isPointerType() || T.$arrow().isObjCObjectPointerType()) {
                  if ((RHS.isNullPointerConstant(Ctx, Expr.NullPointerConstantValueDependence.NPC_ValueDependentIsNull).getValue() != 0)) {
                    return;
                  }
                }
                {
                  
                  // Special case: self-assignments.  These are often used to shut up
                  //  "unused variable" compiler warnings.
                  /*const*/ DeclRefExpr /*P*/ RhsDR = dyn_cast_DeclRefExpr(RHS);
                  if ((RhsDR != null)) {
                    if (VD == dyn_cast_VarDecl(RhsDR.getDecl$Const())) {
                      return;
                    }
                  }
                }
                
                // Otherwise, issue a warning.
                DeadStoreKind dsk = Parents.isConsumedExpr_Expr$C$P(B) ? DeadStoreKind.Enclosing : (isIncrement(VD, B) ? DeadStoreKind.DeadIncrement : DeadStoreKind.Standard);
                
                CheckVarDecl(VD, DR, B.getRHS(), dsk, Live);
              }
            }
          }
        }
      } else {
        /*const*/ UnaryOperator /*P*/ U = dyn_cast_UnaryOperator(S);
        if ((U != null)) {
          if (!U.isIncrementOp() || U.isPrefix()) {
            return;
          }
          
          /*const*/ Stmt /*P*/ parent = Parents.getParentIgnoreParenCasts_Stmt$C$P(U);
          if (!(parent != null) || !isa_ReturnStmt(parent)) {
            return;
          }
          
          /*const*/ Expr /*P*/ Ex = U.getSubExpr().IgnoreParenCasts();
          {
            
            /*const*/ DeclRefExpr /*P*/ DR = dyn_cast_DeclRefExpr(Ex);
            if ((DR != null)) {
              CheckDeclRef(DR, U, DeadStoreKind.DeadIncrement, Live);
            }
          }
        } else {
          /*const*/ DeclStmt /*P*/ DS = dyn_cast_DeclStmt(S);
          if ((DS != null)) {
            // Iterate through the decls.  Warn if any initializers are complex
            // expressions that are not live (never used).
            for (/*const*/ Decl /*P*/ DI : DS.decls$Const()) {
              /*const*/ VarDecl /*P*/ V = dyn_cast_VarDecl(DI);
              if (!(V != null)) {
                continue;
              }
              if (V.hasLocalStorage()) {
                // Reference types confuse the dead stores checker.  Skip them
                // for now.
                if ((V.getType().$arrow().getAs(ReferenceType.class) != null)) {
                  return;
                }
                {
                  
                  /*const*/ Expr /*P*/ E = V.getInit$Const();
                  if ((E != null)) {
                    {
                      /*const*/ ExprWithCleanups /*P*/ exprClean;
                      while (((/*P*/ exprClean = dyn_cast_ExprWithCleanups(E)) != null)) {
                        E = exprClean.getSubExpr$Const();
                      }
                    }
                    
                    // Look through transitive assignments, e.g.:
                    // int x = y = 0;
                    E = LookThroughTransitiveAssignmentsAndCommaOperators(E);
                    
                    // Don't warn on C++ objects (yet) until we can show that their
                    // constructors/destructors don't have side effects.
                    if (isa_CXXConstructExpr(E)) {
                      return;
                    }
                    
                    // A dead initialization is a variable that is dead after it
                    // is initialized.  We don't flag warnings for those variables
                    // marked 'unused' or 'objc_precise_lifetime'.
                    if (!isLive(Live, V)
                       && !V.hasAttr(UnusedAttr.class)
                       && !V.hasAttr(ObjCPreciseLifetimeAttr.class)) {
                      // Special case: check for initializations with constants.
                      //
                      //  e.g. : int x = 0;
                      //
                      // If x is EVER assigned a new value later, don't issue
                      // a warning.  This is because such initialization can be
                      // due to defensive programming.
                      if (E.isEvaluatable(Ctx)) {
                        return;
                      }
                      {
                        
                        /*const*/ DeclRefExpr /*P*/ DRE = dyn_cast_DeclRefExpr(E.IgnoreParenCasts$Const());
                        if ((DRE != null)) {
                          {
                            /*const*/ VarDecl /*P*/ VD = dyn_cast_VarDecl(DRE.getDecl$Const());
                            if ((VD != null)) {
                              // Special case: check for initialization from constant
                              //  variables.
                              //
                              //  e.g. extern const int MyConstant;
                              //       int x = MyConstant;
                              //
                              if (VD.hasGlobalStorage()
                                 && VD.getType().isConstQualified()) {
                                return;
                              }
                              // Special case: check for initialization from scalar
                              //  parameters.  This is often a form of defensive
                              //  programming.  Non-scalars are still an error since
                              //  because it more likely represents an actual algorithmic
                              //  bug.
                              if (isa_ParmVarDecl(VD) && VD.getType().$arrow().isScalarType()) {
                                return;
                              }
                            }
                          }
                        }
                      }
                      
                      PathDiagnosticLocation Loc = PathDiagnosticLocation.create(V, BR.getSourceManager());
                      Report(V, DeadStoreKind.DeadInit, new PathDiagnosticLocation(Loc), E.getSourceRange());
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }

  
  @Override public String toString() {
    return "" + "cfg=" + cfg // NOI18N
              + ", Ctx=" + "[ASTContext]" // NOI18N
              + ", BR=" + BR // NOI18N
              + ", Checker=" + Checker // NOI18N
              + ", AC=" + "[AnalysisDeclContext]" // NOI18N
              + ", Parents=" + Parents // NOI18N
              + ", Escaped=" + Escaped // NOI18N
              + ", reachableCode=" + reachableCode // NOI18N
              + ", currentBlock=" + currentBlock // NOI18N
              + ", InEH=" + InEH // NOI18N
              + super.toString(); // NOI18N
  }
}
