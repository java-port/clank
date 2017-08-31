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

package org.clang.sema;

import static org.clank.support.Native.$Deref;
import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.analysis.*;
import org.clang.analysis.analyses.*;
import org.clang.analysis.analyses.consumed.ConsumedAnalyzer;
import org.clang.sema.impl.*;
import org.clang.sema.threadSafety.impl.*;
import org.clang.sema.consumed.impl.*;
import static org.clang.analysis.analyses.AnalysisClangGlobals.*;
import static org.clang.analysis.analyses.threadSafety.ThreadSafetyGlobals.*;
import static org.clang.basic.diag.*;
import static org.clang.sema.impl.AnalysisBasedWarningsStatics.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;

//<editor-fold defaultstate="collapsed" desc="clang::sema::AnalysisBasedWarnings">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/AnalysisBasedWarnings.h", line = 33,
 FQN="clang::sema::AnalysisBasedWarnings", NM="_ZN5clang4sema21AnalysisBasedWarningsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZN5clang4sema21AnalysisBasedWarningsE")
//</editor-fold>
public class AnalysisBasedWarnings implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::sema::AnalysisBasedWarnings::Policy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/AnalysisBasedWarnings.h", line = 35,
   FQN="clang::sema::AnalysisBasedWarnings::Policy", NM="_ZN5clang4sema21AnalysisBasedWarnings6PolicyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZN5clang4sema21AnalysisBasedWarnings6PolicyE")
  //</editor-fold>
  public static class Policy {
    /*friend  class AnalysisBasedWarnings*/
    // The warnings to run.
    private /*JBIT unsigned int*/ boolean enableCheckFallThrough /*: 1*/;
    private /*JBIT unsigned int*/ boolean enableCheckUnreachable /*: 1*/;
    private /*JBIT unsigned int*/ boolean enableThreadSafetyAnalysis /*: 1*/;
    private /*JBIT unsigned int*/ boolean enableConsumedAnalysis /*: 1*/;
  /*public:*/
    // namespace clang
    
    //===----------------------------------------------------------------------===//
    // AnalysisBasedWarnings - Worker object used by Sema to execute analysis-based
    //  warnings on a function, method, or block.
    //===----------------------------------------------------------------------===//
    //<editor-fold defaultstate="collapsed" desc="clang::sema::AnalysisBasedWarnings::Policy::Policy">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp", line = 1833,
     FQN="clang::sema::AnalysisBasedWarnings::Policy::Policy", NM="_ZN5clang4sema21AnalysisBasedWarnings6PolicyC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZN5clang4sema21AnalysisBasedWarnings6PolicyC1Ev")
    //</editor-fold>
    public Policy() {
      enableCheckFallThrough = true;
      enableCheckUnreachable = false;
      enableThreadSafetyAnalysis = false;
      enableConsumedAnalysis = false;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::sema::AnalysisBasedWarnings::Policy::disableCheckFallThrough">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/AnalysisBasedWarnings.h", line = 44,
     FQN="clang::sema::AnalysisBasedWarnings::Policy::disableCheckFallThrough", NM="_ZN5clang4sema21AnalysisBasedWarnings6Policy23disableCheckFallThroughEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZN5clang4sema21AnalysisBasedWarnings6Policy23disableCheckFallThroughEv")
    //</editor-fold>
    public void disableCheckFallThrough() {
      enableCheckFallThrough = false;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::sema::AnalysisBasedWarnings::Policy::Policy">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/AnalysisBasedWarnings.h", line = 35,
     FQN="clang::sema::AnalysisBasedWarnings::Policy::Policy", NM="_ZN5clang4sema21AnalysisBasedWarnings6PolicyC1ERKS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZN5clang4sema21AnalysisBasedWarnings6PolicyC1ERKS2_")
    //</editor-fold>
    public /*inline*/ Policy(final /*const*/ Policy /*&*/ $Prm0) {
      // : enableCheckFallThrough(.enableCheckFallThrough), enableCheckUnreachable(.enableCheckUnreachable), enableThreadSafetyAnalysis(.enableThreadSafetyAnalysis), enableConsumedAnalysis(.enableConsumedAnalysis) 
      //START JInit
      this.enableCheckFallThrough = $Prm0.enableCheckFallThrough;
      this.enableCheckUnreachable = $Prm0.enableCheckUnreachable;
      this.enableThreadSafetyAnalysis = $Prm0.enableThreadSafetyAnalysis;
      this.enableConsumedAnalysis = $Prm0.enableConsumedAnalysis;
      //END JInit
    }


    //<editor-fold defaultstate="collapsed" desc="clang::sema::AnalysisBasedWarnings::Policy::~Policy">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/AnalysisBasedWarnings.h", line = 35,
     FQN="clang::sema::AnalysisBasedWarnings::Policy::~Policy", NM="_ZN5clang4sema21AnalysisBasedWarnings6PolicyD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang4sema21AnalysisBasedWarnings6PolicyD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
    }


    //<editor-fold defaultstate="collapsed" desc="clang::sema::AnalysisBasedWarnings::Policy::Policy">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/AnalysisBasedWarnings.h", line = 35,
     FQN="clang::sema::AnalysisBasedWarnings::Policy::Policy", NM="_ZN5clang4sema21AnalysisBasedWarnings6PolicyC1EOS2_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN5clang4sema21AnalysisBasedWarnings6PolicyC1EOS2_")
    //</editor-fold>
    public /*inline*/ Policy(JD$Move _dparam, final Policy /*&&*/$Prm0) {
      // : enableCheckFallThrough(static_cast<Policy &&>().enableCheckFallThrough), enableCheckUnreachable(static_cast<Policy &&>().enableCheckUnreachable), enableThreadSafetyAnalysis(static_cast<Policy &&>().enableThreadSafetyAnalysis), enableConsumedAnalysis(static_cast<Policy &&>().enableConsumedAnalysis) 
      //START JInit
      this.enableCheckFallThrough = $Prm0.enableCheckFallThrough;
      this.enableCheckUnreachable = $Prm0.enableCheckUnreachable;
      this.enableThreadSafetyAnalysis = $Prm0.enableThreadSafetyAnalysis;
      this.enableConsumedAnalysis = $Prm0.enableConsumedAnalysis;
      //END JInit
    }

    
    @Override public String toString() {
      return "" + "enableCheckFallThrough=" + enableCheckFallThrough // NOI18N
                + ", enableCheckUnreachable=" + enableCheckUnreachable // NOI18N
                + ", enableThreadSafetyAnalysis=" + enableThreadSafetyAnalysis // NOI18N
                + ", enableConsumedAnalysis=" + enableConsumedAnalysis; // NOI18N
    }
  };
/*private:*/
  private final Sema /*&*/ S;
  private Policy DefaultPolicy;
  
  //<editor-fold defaultstate="collapsed" desc="clang::sema::AnalysisBasedWarnings::VisitFlag">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/AnalysisBasedWarnings.h", line = 51,
   FQN="clang::sema::AnalysisBasedWarnings::VisitFlag", NM="_ZN5clang4sema21AnalysisBasedWarnings9VisitFlagE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZN5clang4sema21AnalysisBasedWarnings9VisitFlagE")
  //</editor-fold>
  private enum VisitFlag implements Native.ComparableLower {
    NotVisited(0),
    Visited(1),
    Pending(2);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static VisitFlag valueOf(int val) {
      VisitFlag out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final VisitFlag[] VALUES;
      private static final VisitFlag[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (VisitFlag kind : VisitFlag.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new VisitFlag[min < 0 ? (1-min) : 0];
        VALUES = new VisitFlag[max >= 0 ? (1+max) : 0];
        for (VisitFlag kind : VisitFlag.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private VisitFlag(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((VisitFlag)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((VisitFlag)obj).value);}
    //</editor-fold>
  };
  private DenseMap</*const*/ FunctionDecl /*P*/ , VisitFlag> VisitedFD;
  
  /// \name Statistics
  /// @{
  
  /// \brief Number of function CFGs built and analyzed.
  private /*uint*/int NumFunctionsAnalyzed;
  
  /// \brief Number of functions for which the CFG could not be successfully
  /// built.
  private /*uint*/int NumFunctionsWithBadCFGs;
  
  /// \brief Total number of blocks across all CFGs.
  private /*uint*/int NumCFGBlocks;
  
  /// \brief Largest number of CFG blocks for a single function analyzed.
  private /*uint*/int MaxCFGBlocksPerFunction;
  
  /// \brief Total number of CFGs with variables analyzed for uninitialized
  /// uses.
  private /*uint*/int NumUninitAnalysisFunctions;
  
  /// \brief Total number of variables analyzed for uninitialized uses.
  private /*uint*/int NumUninitAnalysisVariables;
  
  /// \brief Max number of variables analyzed for uninitialized uses in a single
  /// function.
  private /*uint*/int MaxUninitAnalysisVariablesPerFunction;
  
  /// \brief Total number of block visits during uninitialized use analysis.
  private /*uint*/int NumUninitAnalysisBlockVisits;
  
  /// \brief Max number of block visits during uninitialized use analysis of
  /// a single function.
  private /*uint*/int MaxUninitAnalysisBlockVisitsPerFunction;

  /// @}
  /*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::sema::AnalysisBasedWarnings::AnalysisBasedWarnings">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp", line = 1844,
   FQN="clang::sema::AnalysisBasedWarnings::AnalysisBasedWarnings", NM="_ZN5clang4sema21AnalysisBasedWarningsC1ERNS_4SemaE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZN5clang4sema21AnalysisBasedWarningsC1ERNS_4SemaE")
  //</editor-fold>
  public AnalysisBasedWarnings(final Sema /*&*/ s) {
    // : S(s), DefaultPolicy(), VisitedFD(), NumFunctionsAnalyzed(0), NumFunctionsWithBadCFGs(0), NumCFGBlocks(0), MaxCFGBlocksPerFunction(0), NumUninitAnalysisFunctions(0), NumUninitAnalysisVariables(0), MaxUninitAnalysisVariablesPerFunction(0), NumUninitAnalysisBlockVisits(0), MaxUninitAnalysisBlockVisitsPerFunction(0) 
    //START JInit
    this./*&*/S=/*&*/s;
    this.DefaultPolicy = new Policy();
    this.VisitedFD = new DenseMap</*const*/ FunctionDecl /*P*/ , VisitFlag>(DenseMapInfo$LikePtr.$Info(), null);
    this.NumFunctionsAnalyzed = 0;
    this.NumFunctionsWithBadCFGs = 0;
    this.NumCFGBlocks = 0;
    this.MaxCFGBlocksPerFunction = 0;
    this.NumUninitAnalysisFunctions = 0;
    this.NumUninitAnalysisVariables = 0;
    this.MaxUninitAnalysisVariablesPerFunction = 0;
    this.NumUninitAnalysisBlockVisits = 0;
    this.MaxUninitAnalysisBlockVisitsPerFunction = 0;
    //END JInit
    
    //JAVA: using namespace diag;
    final DiagnosticsEngine /*&*/ D = S.getDiagnostics();
    
    DefaultPolicy.enableCheckUnreachable
       = (isEnabled(D, warn_unreachable) != 0)
       || (isEnabled(D, warn_unreachable_break) != 0)
       || (isEnabled(D, warn_unreachable_return) != 0)
       || (isEnabled(D, warn_unreachable_loop_increment) != 0);
    
    DefaultPolicy.enableThreadSafetyAnalysis
       = $uint2uint_1bit(isEnabled(D, warn_double_lock));
    
    DefaultPolicy.enableConsumedAnalysis
       = $uint2uint_1bit(isEnabled(D, warn_use_in_invalid_state));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::sema::AnalysisBasedWarnings::IssueWarnings">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp", line = 1877,
   FQN="clang::sema::AnalysisBasedWarnings::IssueWarnings", NM="_ZN5clang4sema21AnalysisBasedWarnings13IssueWarningsENS1_6PolicyEPNS0_17FunctionScopeInfoEPKNS_4DeclEPKNS_9BlockExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZN5clang4sema21AnalysisBasedWarnings13IssueWarningsENS1_6PolicyEPNS0_17FunctionScopeInfoEPKNS_4DeclEPKNS_9BlockExprE")
  //</editor-fold>
  public void IssueWarnings(AnalysisBasedWarnings.Policy P, 
               FunctionScopeInfo /*P*/ fscope, 
               /*const*/ Decl /*P*/ D, /*const*/ BlockExpr /*P*/ blkExpr) {
    AnalysisDeclContext AC = null;
    std.unique_ptr<LogicalErrorHandler> LEH = null;
    try {
      
      // We avoid doing analysis-based warnings when there are errors for
      // two reasons:
      // (1) The CFGs often can't be constructed (if the body is invalid), so
      //     don't bother trying.
      // (2) The code already has problems; running the analysis just takes more
      //     time.
      final DiagnosticsEngine /*&*/ Diags = S.getDiagnostics();
      
      // Do not do any analysis for declarations in system headers if we are
      // going to just ignore them.
      if (Diags.getSuppressSystemWarnings()
         && S.SourceMgr.isInSystemHeader(D.getLocation())) {
        return;
      }
      
      // For code in dependent contexts, we'll do this at instantiation time.
      if (cast_DeclContext(D).isDependentContext()) {
        return;
      }
      if (Diags.hasUncompilableErrorOccurred()) {
        // Flush out any possibly unreachable diagnostics.
        flushDiagnostics(S, fscope);
        return;
      }
      
      /*const*/ Stmt /*P*/ Body = D.getBody();
      assert (Body != null);
      
      // Construct the analysis context with the specified CFG build options.
      AC/*J*/= new AnalysisDeclContext(/* AnalysisDeclContextManager */ (AnalysisDeclContextManager /*P*/ )null, D);
      
      // Don't generate EH edges for CallExprs as we'd like to avoid the n^2
      // explosion for destructors that can result and the compile time hit.
      AC.getCFGBuildOptions().PruneTriviallyFalseEdges = true;
      AC.getCFGBuildOptions().AddEHEdges = false;
      AC.getCFGBuildOptions().AddInitializers = true;
      AC.getCFGBuildOptions().AddImplicitDtors = true;
      AC.getCFGBuildOptions().AddTemporaryDtors = true;
      AC.getCFGBuildOptions().AddCXXNewAllocator = false;
      AC.getCFGBuildOptions().AddCXXDefaultInitExprInCtors = true;
      
      // Force that certain expressions appear as CFGElements in the CFG.  This
      // is used to speed up various analyses.
      // FIXME: This isn't the right factoring.  This is here for initial
      // prototyping, but we need a way for analyses to say what expressions they
      // expect to always be CFGElements and then fill in the BuildOptions
      // appropriately.  This is essentially a layering violation.
      if (P.enableCheckUnreachable || P.enableThreadSafetyAnalysis
         || P.enableConsumedAnalysis) {
        // Unreachable code analysis and thread safety require a linearized CFG.
        AC.getCFGBuildOptions().setAllAlwaysAdd();
      } else {
        AC.getCFGBuildOptions().
            setAlwaysAdd(Stmt.StmtClass.BinaryOperatorClass).
            setAlwaysAdd(Stmt.StmtClass.CompoundAssignOperatorClass).
            setAlwaysAdd(Stmt.StmtClass.BlockExprClass).
            setAlwaysAdd(Stmt.StmtClass.CStyleCastExprClass).
            setAlwaysAdd(Stmt.StmtClass.DeclRefExprClass).
            setAlwaysAdd(Stmt.StmtClass.ImplicitCastExprClass).
            setAlwaysAdd(Stmt.StmtClass.UnaryOperatorClass).
            setAlwaysAdd(Stmt.StmtClass.AttributedStmtClass);
      }
      
      // Install the logical handler for -Wtautological-overlap-compare
      LEH/*J*/= new std.unique_ptr<LogicalErrorHandler>();
      if (!Diags.isIgnored(diag.warn_tautological_overlap_comparison, 
          D.getLocStart())) {
        LEH.reset(new LogicalErrorHandler(S));
        AC.getCFGBuildOptions().Observer = LEH.get();
      }
      
      // Emit delayed diagnostics.
      if (!fscope.PossiblyUnreachableDiags.empty()) {
        boolean analyzed = false;
        
        // Register the expressions with the CFGBuilder.
        for (final /*const*/ PossiblyUnreachableDiag /*&*/ D1 : fscope.PossiblyUnreachableDiags) {
          if ((D1.stmt != null)) {
            AC.registerForcedBlockExpression(D1.stmt);
          }
        }
        if ((AC.getCFG() != null)) {
          analyzed = true;
          for (final /*const*/ PossiblyUnreachableDiag /*&*/ D2 : fscope.PossiblyUnreachableDiags) {
            boolean processed = false;
            if ((D2.stmt != null)) {
              /*const*/ CFGBlock /*P*/ block = AC.getBlockForRegisteredExpression(D2.stmt);
              CFGReverseBlockReachabilityAnalysis /*P*/ cra = AC.getCFGReachablityAnalysis();
              // FIXME: We should be able to assert that block is non-null, but
              // the CFG analysis can skip potentially-evaluated expressions in
              // edge cases; see test/Sema/vla-2.c.
              if ((block != null) && (cra != null)) {
                // Can this block be reached from the entrance?
                if (cra.isReachable($AddrOf(AC.getCFG().getEntry()), block)) {
                  JavaCleaner $c$ = $createJavaCleaner();
                  try {
                    $c$.clean($c$.track(S.Diag(new SourceLocation(D2.Loc), D2.PD)));
                  } finally {
                    $c$.$destroy();
                  }
                }
                processed = true;
              }
            }
            if (!processed) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                // Emit the warning anyway if we cannot map to a basic block.
                $c$.clean($c$.track(S.Diag(new SourceLocation(D2.Loc), D2.PD)));
              } finally {
                $c$.$destroy();
              }
            }
          }
        }
        if (!analyzed) {
          flushDiagnostics(S, fscope);
        }
      }
      
      // Warning: check missing 'return'
      if (P.enableCheckFallThrough) {
        final /*const*/ CheckFallThroughDiagnostics /*&*/ CD = (isa_BlockDecl(D) ? CheckFallThroughDiagnostics.MakeForBlock() : (isa_CXXMethodDecl(D)
           && cast_CXXMethodDecl(D).getOverloadedOperator() == OverloadedOperatorKind.OO_Call
           && cast_CXXMethodDecl(D).getParent$Const().isLambda()) ? CheckFallThroughDiagnostics.MakeForLambda() : CheckFallThroughDiagnostics.MakeForFunction(D));
        CheckFallThroughForBody(S, D, Body, blkExpr, CD, AC);
      }
      
      // Warning: check for unreachable code
      if (P.enableCheckUnreachable) {
        // Only check for unreachable code on non-template instantiations.
        // Different template instantiations can effectively change the control-flow
        // and it is very difficult to prove that a snippet of code in a template
        // is unreachable for all instantiations.
        boolean isTemplateInstantiation = false;
        {
          /*const*/ FunctionDecl /*P*/ Function = dyn_cast_FunctionDecl(D);
          if ((Function != null)) {
            isTemplateInstantiation = Function.isTemplateInstantiation();
          }
        }
        if (!isTemplateInstantiation) {
          CheckUnreachable(S, AC);
        }
      }
      
      // Check for thread safety violations
      if (P.enableThreadSafetyAnalysis) {
        ThreadSafetyReporter Reporter = null;
        try {
          SourceLocation FL = AC.getDecl().getLocation();
          SourceLocation FEL = AC.getDecl().getLocEnd();
          Reporter/*J*/= new ThreadSafetyReporter(S, new SourceLocation(FL), new SourceLocation(FEL));
          if (!Diags.isIgnored(diag.warn_thread_safety_beta, D.getLocStart())) {
            Reporter.setIssueBetaWarnings(true);
          }
          if (!Diags.isIgnored(diag.warn_thread_safety_verbose, D.getLocStart())) {
            Reporter.setVerbose(true);
          }
          
          runThreadSafetyAnalysis(AC, Reporter, 
              create_type$ptr(S.ThreadSafetyDeclCache));
          Reporter.emitDiagnostics();
        } finally {
          if (Reporter != null) { Reporter.$destroy(); }
        }
      }
      
      // Check for violations of consumed properties.
      if (P.enableConsumedAnalysis) {
        ConsumedWarningsHandler WarningHandler = null;
        ConsumedAnalyzer Analyzer = null;
        try {
          WarningHandler/*J*/= new ConsumedWarningsHandler(S);
          Analyzer/*J*/= new ConsumedAnalyzer(WarningHandler);
          Analyzer.run(AC);
        } finally {
          if (Analyzer != null) { Analyzer.$destroy(); }
          if (WarningHandler != null) { WarningHandler.$destroy(); }
        }
      }
      if (!Diags.isIgnored(diag.warn_uninit_var, D.getLocStart())
         || !Diags.isIgnored(diag.warn_sometimes_uninit_var, D.getLocStart())
         || !Diags.isIgnored(diag.warn_maybe_uninit_var, D.getLocStart())) {
        {
          CFG /*P*/ cfg = AC.getCFG();
          if ((cfg != null)) {
            UninitValsDiagReporter reporter = null;
            try {
              reporter/*J*/= new UninitValsDiagReporter(S);
              UninitVariablesAnalysisStats stats/*J*/= new UninitVariablesAnalysisStats();
              //std.memset(/*AddrOf*/stats, 0, $sizeof_UninitVariablesAnalysisStats());
              runUninitializedVariablesAnalysis($Deref(cast_DeclContext(D)), $Deref(cfg), AC, 
                  reporter, stats);
              if (S.CollectStats && $greater_uint(stats.NumVariablesAnalyzed, 0)) {
                ++NumUninitAnalysisFunctions;
                NumUninitAnalysisVariables += stats.NumVariablesAnalyzed;
                NumUninitAnalysisBlockVisits += stats.NumBlockVisits;
                MaxUninitAnalysisVariablesPerFunction
                   = std.max(MaxUninitAnalysisVariablesPerFunction, 
                    stats.NumVariablesAnalyzed);
                MaxUninitAnalysisBlockVisitsPerFunction
                   = std.max(MaxUninitAnalysisBlockVisitsPerFunction, 
                    stats.NumBlockVisits);
              }
            } finally {
              if (reporter != null) { reporter.$destroy(); }
            }
          }
        }
      }
      
      boolean FallThroughDiagFull = !Diags.isIgnored(diag.warn_unannotated_fallthrough, D.getLocStart());
      boolean FallThroughDiagPerFunction = !Diags.isIgnored(diag.warn_unannotated_fallthrough_per_function, D.getLocStart());
      if (FallThroughDiagFull || FallThroughDiagPerFunction
         || fscope.HasFallthroughStmt) {
        DiagnoseSwitchLabelsFallthrough(S, AC, !FallThroughDiagFull);
      }
      if (S.getLangOpts().ObjCWeak
         && !Diags.isIgnored(diag.warn_arc_repeated_use_of_weak, D.getLocStart())) {
        diagnoseRepeatedUseOfWeak(S, fscope, D, AC.getParentMap());
      }
      
      // Check for infinite self-recursion in functions
      if (!Diags.isIgnored(diag.warn_infinite_recursive_function, 
          D.getLocStart())) {
        {
          /*const*/ FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(D);
          if ((FD != null)) {
            checkRecursiveFunction(S, FD, Body, AC);
          }
        }
      }
      
      // If none of the previous checks caused a CFG build, trigger one here
      // for -Wtautological-overlap-compare
      if (!Diags.isIgnored(diag.warn_tautological_overlap_comparison, 
          D.getLocStart())) {
        AC.getCFG();
      }
      
      // Collect statistics about the CFG if it was built.
      if (S.CollectStats && AC.isCFGBuilt()) {
        ++NumFunctionsAnalyzed;
        {
          CFG /*P*/ cfg = AC.getCFG();
          if ((cfg != null)) {
            // If we successfully built a CFG for this context, record some more
            // detail information about it.
            NumCFGBlocks += cfg.getNumBlockIDs();
            MaxCFGBlocksPerFunction = std.max(MaxCFGBlocksPerFunction, 
                cfg.getNumBlockIDs());
          } else {
            ++NumFunctionsWithBadCFGs;
          }
        }
      }
    } finally {
      if (LEH != null) { LEH.$destroy(); }
      if (AC != null) { AC.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::sema::AnalysisBasedWarnings::getDefaultPolicy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/AnalysisBasedWarnings.h", line = 96,
   FQN="clang::sema::AnalysisBasedWarnings::getDefaultPolicy", NM="_ZN5clang4sema21AnalysisBasedWarnings16getDefaultPolicyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZN5clang4sema21AnalysisBasedWarnings16getDefaultPolicyEv")
  //</editor-fold>
  public Policy getDefaultPolicy() {
    return new Policy(DefaultPolicy);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::sema::AnalysisBasedWarnings::PrintStats">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp", line = 2107,
   FQN="clang::sema::AnalysisBasedWarnings::PrintStats", NM="_ZNK5clang4sema21AnalysisBasedWarnings10PrintStatsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/AnalysisBasedWarnings.cpp -nm=_ZNK5clang4sema21AnalysisBasedWarnings10PrintStatsEv")
  //</editor-fold>
  public void PrintStats() /*const*/ {
    llvm.errs().$out(/*KEEP_STR*/"\n*** Analysis Based Warnings Stats:\n");
    
    /*uint*/int NumCFGsBuilt = NumFunctionsAnalyzed - NumFunctionsWithBadCFGs;
    /*uint*/int AvgCFGBlocksPerFunction = !(NumCFGsBuilt != 0) ? 0 : $div_uint(NumCFGBlocks, NumCFGsBuilt);
    llvm.errs().$out_uint(NumFunctionsAnalyzed).$out(/*KEEP_STR*/" functions analyzed (").$out_uint(
        NumFunctionsWithBadCFGs
    ).$out(/*KEEP_STR*/" w/o CFGs).\n").$out(
        /*KEEP_STR*/"  "
    ).$out_uint(NumCFGBlocks).$out(/*KEEP_STR*/" CFG blocks built.\n").$out(
        /*KEEP_STR*/"  "
    ).$out_uint(AvgCFGBlocksPerFunction).$out(
        /*KEEP_STR*/" average CFG blocks per function.\n"
    ).$out(
        /*KEEP_STR*/"  "
    ).$out_uint(MaxCFGBlocksPerFunction).$out(
        /*KEEP_STR*/" max CFG blocks per function.\n"
    );
    
    /*uint*/int AvgUninitVariablesPerFunction = !(NumUninitAnalysisFunctions != 0) ? 0 : $div_uint(NumUninitAnalysisVariables, NumUninitAnalysisFunctions);
    /*uint*/int AvgUninitBlockVisitsPerFunction = !(NumUninitAnalysisFunctions != 0) ? 0 : $div_uint(NumUninitAnalysisBlockVisits, NumUninitAnalysisFunctions);
    llvm.errs().$out_uint(NumUninitAnalysisFunctions).$out(
        /*KEEP_STR*/" functions analyzed for uninitialiazed variables\n"
    ).$out(
        /*KEEP_STR*/"  "
    ).$out_uint(NumUninitAnalysisVariables).$out(/*KEEP_STR*/" variables analyzed.\n").$out(
        /*KEEP_STR*/"  "
    ).$out_uint(AvgUninitVariablesPerFunction).$out(
        /*KEEP_STR*/" average variables per function.\n"
    ).$out(
        /*KEEP_STR*/"  "
    ).$out_uint(MaxUninitAnalysisVariablesPerFunction).$out(
        /*KEEP_STR*/" max variables per function.\n"
    ).$out(
        /*KEEP_STR*/"  "
    ).$out_uint(NumUninitAnalysisBlockVisits).$out(/*KEEP_STR*/" block visits.\n").$out(
        /*KEEP_STR*/"  "
    ).$out_uint(AvgUninitBlockVisitsPerFunction).$out(
        /*KEEP_STR*/" average block visits per function.\n"
    ).$out(
        /*KEEP_STR*/"  "
    ).$out_uint(MaxUninitAnalysisBlockVisitsPerFunction).$out(
        /*KEEP_STR*/" max block visits per function.\n"
    );
  }

  //<editor-fold defaultstate="collapsed" desc="clang::sema::AnalysisBasedWarnings::~AnalysisBasedWarnings">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/AnalysisBasedWarnings.h", line = 33,
   FQN="clang::sema::AnalysisBasedWarnings::~AnalysisBasedWarnings", NM="_ZN5clang4sema21AnalysisBasedWarningsD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang4sema21AnalysisBasedWarningsD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    VisitedFD.$destroy();
    //END JDestroy
  }


  
  @Override public String toString() {
    return "" + "S=" + "[Sema]" // NOI18N
              + ", DefaultPolicy=" + DefaultPolicy // NOI18N
              + ", VisitedFD=" + VisitedFD // NOI18N
              + ", NumFunctionsAnalyzed=" + NumFunctionsAnalyzed // NOI18N
              + ", NumFunctionsWithBadCFGs=" + NumFunctionsWithBadCFGs // NOI18N
              + ", NumCFGBlocks=" + NumCFGBlocks // NOI18N
              + ", MaxCFGBlocksPerFunction=" + MaxCFGBlocksPerFunction // NOI18N
              + ", NumUninitAnalysisFunctions=" + NumUninitAnalysisFunctions // NOI18N
              + ", NumUninitAnalysisVariables=" + NumUninitAnalysisVariables // NOI18N
              + ", MaxUninitAnalysisVariablesPerFunction=" + MaxUninitAnalysisVariablesPerFunction // NOI18N
              + ", NumUninitAnalysisBlockVisits=" + NumUninitAnalysisBlockVisits // NOI18N
              + ", MaxUninitAnalysisBlockVisitsPerFunction=" + MaxUninitAnalysisBlockVisitsPerFunction; // NOI18N
  }
}
