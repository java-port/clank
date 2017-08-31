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

package org.clang.analysis.impl;

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
import org.clang.basic.*;
import org.clang.analysis.*;
import org.clang.analysis.analyses.*;
import static org.clang.analysis.impl.LiveVariablesStatics.*;
import static org.clang.basic.BasicClangGlobals.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LiveVariablesImpl">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/LiveVariables.cpp", line = 82,
 FQN="(anonymous namespace)::LiveVariablesImpl", NM="_ZN12_GLOBAL__N_117LiveVariablesImplE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/LiveVariables.cpp -nm=_ZN12_GLOBAL__N_117LiveVariablesImplE")
//</editor-fold>
public class LiveVariablesImpl implements Destructors.ClassWithDestructor {
/*public:*/
  public final AnalysisDeclContext /*&*/ analysisContext;
  public ImmutableSetPtr.Factory</*const*/ Stmt /*P*/ > SSetFact;
  public ImmutableSetPtr.Factory</*const*/ VarDecl /*P*/ > DSetFact;
  public DenseMap</*const*/ CFGBlock /*P*/ , LiveVariables.LivenessValues> blocksEndToLiveness;
  public DenseMap</*const*/ CFGBlock /*P*/ , LiveVariables.LivenessValues> blocksBeginToLiveness;
  public DenseMap</*const*/ Stmt /*P*/ , LiveVariables.LivenessValues> stmtsToLiveness;
  public DenseMapTypeUInt</*const*/ DeclRefExpr /*P*/ > inAssignment;
  public /*const*/boolean killAtAssign;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LiveVariablesImpl::merge">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/LiveVariables.cpp", line = 142,
   FQN="(anonymous namespace)::LiveVariablesImpl::merge", NM="_ZN12_GLOBAL__N_117LiveVariablesImpl5mergeEN5clang13LiveVariables14LivenessValuesES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/LiveVariables.cpp -nm=_ZN12_GLOBAL__N_117LiveVariablesImpl5mergeEN5clang13LiveVariables14LivenessValuesES3_")
  //</editor-fold>
  public LiveVariables.LivenessValues merge(LiveVariables.LivenessValues valsA, 
       LiveVariables.LivenessValues valsB) {
    ImmutableSetRefPtr</*const*/ Stmt /*P*/ > SSetRefA = null;
    ImmutableSetRefPtr</*const*/ Stmt /*P*/ > SSetRefB = null;
    ImmutableSetRefPtr</*const*/ VarDecl /*P*/ > DSetRefA = null;
    ImmutableSetRefPtr</*const*/ VarDecl /*P*/ > DSetRefB = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      
      SSetRefA/*J*/= new ImmutableSetRefPtr</*const*/ Stmt /*P*/ >(valsA.liveStmts.getRootWithoutRetain(), SSetFact.getTreeFactory());
      SSetRefB/*J*/= new ImmutableSetRefPtr</*const*/ Stmt /*P*/ >(valsB.liveStmts.getRootWithoutRetain(), SSetFact.getTreeFactory());
      
      DSetRefA/*J*/= new ImmutableSetRefPtr</*const*/ VarDecl /*P*/ >(valsA.liveDecls.getRootWithoutRetain(), DSetFact.getTreeFactory());
      DSetRefB/*J*/= new ImmutableSetRefPtr</*const*/ VarDecl /*P*/ >(valsB.liveDecls.getRootWithoutRetain(), DSetFact.getTreeFactory());
      
      $c$.clean(SSetRefA.$assign($c$.track(mergeSets($c$.track(new ImmutableSetRefPtr</*const*/ Stmt /*P*/ /*, ImutContainerInfoT$P<const Stmt>*/ >(SSetRefA)), $c$.track(new ImmutableSetRefPtr</*const*/ Stmt /*P*/ /*, ImutContainerInfoT$P<const Stmt>*/ >(SSetRefB))))));
      $c$.clean(DSetRefA.$assign($c$.track(mergeSets($c$.track(new ImmutableSetRefPtr</*const*/ VarDecl /*P*/ /*, ImutContainerInfoT$P<const VarDecl>*/ >(DSetRefA)), $c$.track(new ImmutableSetRefPtr</*const*/ VarDecl /*P*/ /*, ImutContainerInfoT$P<const VarDecl>*/ >(DSetRefB))))));
      
      // asImmutableSet() canonicalizes the tree, allowing us to do an easy
      // comparison afterwards.
      return $c$.clean(new LiveVariables.LivenessValues($c$.track(SSetRefA.asImmutableSet()), 
          $c$.track(DSetRefA.asImmutableSet())));
    } finally {
      if (DSetRefB != null) { DSetRefB.$destroy(); }
      if (DSetRefA != null) { DSetRefA.$destroy(); }
      if (SSetRefB != null) { SSetRefB.$destroy(); }
      if (SSetRefA != null) { SSetRefA.$destroy(); }
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LiveVariablesImpl::runOnBlock">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/LiveVariables.cpp", line = 440,
   FQN="(anonymous namespace)::LiveVariablesImpl::runOnBlock", NM="_ZN12_GLOBAL__N_117LiveVariablesImpl10runOnBlockEPKN5clang8CFGBlockENS1_13LiveVariables14LivenessValuesEPNS5_8ObserverE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/LiveVariables.cpp -nm=_ZN12_GLOBAL__N_117LiveVariablesImpl10runOnBlockEPKN5clang8CFGBlockENS1_13LiveVariables14LivenessValuesEPNS5_8ObserverE")
  //</editor-fold>
  public LiveVariables.LivenessValues runOnBlock(/*const*/ CFGBlock /*P*/ block, 
            LiveVariables.LivenessValues val) {
    return runOnBlock(block, 
            val, 
            (LiveVariables.Observer /*P*/ )null);
  }
  public LiveVariables.LivenessValues runOnBlock(/*const*/ CFGBlock /*P*/ block, 
            LiveVariables.LivenessValues val, 
            LiveVariables.Observer /*P*/ obs/*= null*/) {
    
    TransferFunctions TF/*J*/= new TransferFunctions(/*Deref*/this, val, obs, block);
    {
      
      // Visit the terminator (if any).
      /*const*/ Stmt /*P*/ term = block.getTerminator$Const().$Stmt$C$P();
      if ((term != null)) {
        TF.Visit(((/*const_cast*/Stmt /*P*/ )(term)));
      }
    }
    
    // Apply the transfer function for all Stmts in the block.
    for (type$ptr</*const*/ CFGElement /*P*/ > it = $tryClone(block.rbegin$Const()), 
        /*P*/ ei = $tryClone(block.rend$Const()); $noteq_ptr(it, ei); it.$preInc()) {
      final /*const*/ CFGElement /*&*/ elem = it.$star();
      {
        
        Optional<CFGAutomaticObjDtor> Dtor = elem.getAs(CFGAutomaticObjDtor.class);
        if (Dtor.$bool()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean(val.liveDecls.$assign($c$.track(DSetFact.add($c$.track(new ImmutableSetPtr</*const*/ VarDecl /*P*/ >(val.liveDecls)), Dtor.$arrow().getVarDecl()))));
            continue;
          } finally {
            $c$.$destroy();
          }
        }
      }
      if (!elem.getAs(CFGStmt.class).$bool()) {
        continue;
      }
      
      /*const*/ Stmt /*P*/ S = elem.castAs(CFGStmt.class).getStmt();
      TF.Visit(((/*const_cast*/Stmt /*P*/ )(S)));
      stmtsToLiveness.$at_T1$C$R(S).$assign(val);
    }
    return new LiveVariables.LivenessValues(JD$Move.INSTANCE, val);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LiveVariablesImpl::dumpBlockLiveness">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/LiveVariables.cpp", line = 568,
   FQN="(anonymous namespace)::LiveVariablesImpl::dumpBlockLiveness", NM="_ZN12_GLOBAL__N_117LiveVariablesImpl17dumpBlockLivenessERKN5clang13SourceManagerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/LiveVariables.cpp -nm=_ZN12_GLOBAL__N_117LiveVariablesImpl17dumpBlockLivenessERKN5clang13SourceManagerE")
  //</editor-fold>
  public void dumpBlockLiveness(final /*const*/ SourceManager /*&*/ M) {
    std.vector</*const*/ CFGBlock /*P*/ > vec = null;
    std.vector</*const*/ VarDecl /*P*/ > declVec = null;
    try {
      vec/*J*/= new std.vector</*const*/ CFGBlock /*P*/ >((/*const*/ CFGBlock /*P*/ )null);
      for (DenseMapIterator</*const*/ CFGBlock /*P*/ , LiveVariables.LivenessValues> it = blocksEndToLiveness.begin(), ei = blocksEndToLiveness.end();
           it.$noteq(/*NO_ITER_COPY*/ei); it.$preInc()) {
        vec.push_back_T$C$R(it.$arrow().first);
      }
      std.sort(vec.begin(), vec.end(), /*[]*/ (/*const*/ CFGBlock /*P*/ A, /*const*/ CFGBlock /*P*/ B) -> {
                return $less_uint(A.getBlockID(), B.getBlockID());
              });
      
      declVec/*J*/= new std.vector</*const*/ VarDecl /*P*/ >((/*const*/ VarDecl /*P*/ )null);
      
      for (std.vector.iterator</*const*/ CFGBlock /*P*/> it = vec.begin(), ei = vec.end(); $noteq___normal_iterator$C(it, ei); it.$preInc()) {
        llvm.errs().$out(/*KEEP_STR*/"\n[ B").$out_uint((it.$star()).getBlockID()).$out(
            /*KEEP_STR*/" (live variables at block exit) ]\n"
        );
        
        LiveVariables.LivenessValues vals = new LiveVariables.LivenessValues(blocksEndToLiveness.$at_T1$C$R(it.$star()));
        declVec.clear();
        ImutAVLValueIteratorPtrBoolPtr</*const*/ VarDecl /*P*/> si = null;
        ImutAVLValueIteratorPtrBoolPtr</*const*/ VarDecl /*P*/> se = null;
        try {
          
          for (si = vals.liveDecls.begin(), 
              se = vals.liveDecls.end(); si.$noteq(se); si.$preInc()) {
            declVec.push_back_T$C$R(si.$star());
          }
        } finally {
          if (se != null) { se.$destroy(); }
          if (si != null) { si.$destroy(); }
        }
        
        std.sort(declVec.begin(), declVec.end(), /*[]*/ (/*const*/ Decl /*P*/ A, /*const*/ Decl /*P*/ B) -> {
                  return $less_SourceLocation$C(A.getLocStart(), B.getLocStart());
                });

        for (std.vector.iterator<VarDecl> di = declVec.begin(), 
            de = declVec.end(); $noteq___normal_iterator$C(di, de); di.$preInc()) {
          llvm.errs().$out(/*KEEP_STR*/$SPACE).$out((di.$star()).getDeclName().getAsString()).$out(
              /*KEEP_STR*/" <"
          );
          (di.$star()).getLocation().dump(M);
          llvm.errs().$out(/*KEEP_STR*/$GT_LF);
        }
      }
      llvm.errs().$out(/*KEEP_STR*/$LF);
    } finally {
      if (declVec != null) { declVec.$destroy(); }
      if (vec != null) { vec.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LiveVariablesImpl::LiveVariablesImpl">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/LiveVariables.cpp", line = 103,
   FQN="(anonymous namespace)::LiveVariablesImpl::LiveVariablesImpl", NM="_ZN12_GLOBAL__N_117LiveVariablesImplC1ERN5clang19AnalysisDeclContextEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/LiveVariables.cpp -nm=_ZN12_GLOBAL__N_117LiveVariablesImplC1ERN5clang19AnalysisDeclContextEb")
  //</editor-fold>
  public LiveVariablesImpl(final AnalysisDeclContext /*&*/ ac, boolean KillAtAssign) {
    // : analysisContext(ac), SSetFact(false), DSetFact(false), blocksEndToLiveness(), blocksBeginToLiveness(), stmtsToLiveness(), inAssignment(), killAtAssign(KillAtAssign) 
    //START JInit
    this./*&*/analysisContext=/*&*/ac;
    this.SSetFact = new ImmutableSetPtr.Factory</*const*/ Stmt /*P*/ >(new ImutContainerInfoT$P(null), false);
    this.DSetFact = new ImmutableSetPtr.Factory</*const*/ VarDecl /*P*/ >(new ImutContainerInfoT$P(null), false);
    this.blocksEndToLiveness = new DenseMap</*const*/ CFGBlock /*P*/ , LiveVariables.LivenessValues>(DenseMapInfo$LikePtr.$Info(), new LiveVariables.LivenessValues());
    this.blocksBeginToLiveness = new DenseMap</*const*/ CFGBlock /*P*/ , LiveVariables.LivenessValues>(DenseMapInfo$LikePtr.$Info(), new LiveVariables.LivenessValues());
    this.stmtsToLiveness = new DenseMap</*const*/ Stmt /*P*/ , LiveVariables.LivenessValues>(DenseMapInfo$LikePtr.$Info(), new LiveVariables.LivenessValues());
    this.inAssignment = new DenseMapTypeUInt</*const*/ DeclRefExpr /*P*/ >(DenseMapInfo$LikePtr.$Info(), 0);
    this.killAtAssign = KillAtAssign;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LiveVariablesImpl::~LiveVariablesImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/LiveVariables.cpp", line = 82,
   FQN="(anonymous namespace)::LiveVariablesImpl::~LiveVariablesImpl", NM="_ZN12_GLOBAL__N_117LiveVariablesImplD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/LiveVariables.cpp -nm=_ZN12_GLOBAL__N_117LiveVariablesImplD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    inAssignment.$destroy();
    stmtsToLiveness.$destroy();
    blocksBeginToLiveness.$destroy();
    blocksEndToLiveness.$destroy();
    DSetFact.$destroy();
    SSetFact.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "analysisContext=" + "[AnalysisDeclContext]" // NOI18N
              + ", SSetFact=" + SSetFact // NOI18N
              + ", DSetFact=" + DSetFact // NOI18N
              + ", blocksEndToLiveness=" + blocksEndToLiveness // NOI18N
              + ", blocksBeginToLiveness=" + blocksBeginToLiveness // NOI18N
              + ", stmtsToLiveness=" + stmtsToLiveness // NOI18N
              + ", inAssignment=" + inAssignment // NOI18N
              + ", killAtAssign=" + killAtAssign; // NOI18N
  }
}
