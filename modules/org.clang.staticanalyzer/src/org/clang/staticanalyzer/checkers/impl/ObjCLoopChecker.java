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
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.staticanalyzer.checkers.ento.impl.*;
import org.clang.staticanalyzer.core.ento.*;
import org.clang.staticanalyzer.core.ento.check.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import org.clang.staticanalyzer.java.*;
import static org.clang.staticanalyzer.checkers.impl.BasicObjCFoundationChecksStatics.*;
import org.clank.support.aliases.bool$ptr;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCLoopChecker">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BasicObjCFoundationChecks.cpp", line = 836,
 FQN="(anonymous namespace)::ObjCLoopChecker", NM="_ZN12_GLOBAL__N_115ObjCLoopCheckerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BasicObjCFoundationChecks.cpp -nm=_ZN12_GLOBAL__N_115ObjCLoopCheckerE")
//</editor-fold>
public class ObjCLoopChecker extends /*public*/ Checker/*<PostStmt<ObjCForCollectionStmt>, PostObjCMessage, DeadSymbols, PointerEscape>*/ 
        implements org.clang.staticanalyzer.java.PostStmtChecker, org.clang.staticanalyzer.java.PostObjCMessageChecker, org.clang.staticanalyzer.java.PointerEscapeChecker, org.clang.staticanalyzer.java.DeadSymbolsChecker, Destructors.ClassWithDestructor {
  private /*mutable */IdentifierInfo /*P*/ CountSelectorII;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCLoopChecker::isCollectionCountMethod">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BasicObjCFoundationChecks.cpp", line = 1028,
   FQN="(anonymous namespace)::ObjCLoopChecker::isCollectionCountMethod", NM="_ZNK12_GLOBAL__N_115ObjCLoopChecker23isCollectionCountMethodERKN5clang4ento14ObjCMethodCallERNS2_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BasicObjCFoundationChecks.cpp -nm=_ZNK12_GLOBAL__N_115ObjCLoopChecker23isCollectionCountMethodERKN5clang4ento14ObjCMethodCallERNS2_14CheckerContextE")
  //</editor-fold>
  private boolean isCollectionCountMethod(final /*const*/ ObjCMethodCall /*&*/ M, 
                         final CheckerContext /*&*/ C) /*const*/ {
    Selector S = M.getSelector();
    // Initialize the identifiers on first use.
    if (!(CountSelectorII != null)) {
      CountSelectorII = $AddrOf(C.getASTContext().Idents.get(new StringRef(/*KEEP_STR*/"count")));
    }
    
    // If the method returns collection count, record the value.
    return S.isUnarySelector()
       && (S.getIdentifierInfoForSlot(0) == CountSelectorII);
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCLoopChecker::ObjCLoopChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BasicObjCFoundationChecks.cpp", line = 847,
   FQN="(anonymous namespace)::ObjCLoopChecker::ObjCLoopChecker", NM="_ZN12_GLOBAL__N_115ObjCLoopCheckerC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BasicObjCFoundationChecks.cpp -nm=_ZN12_GLOBAL__N_115ObjCLoopCheckerC1Ev")
  //</editor-fold>
  public ObjCLoopChecker() {
    // : Checker<PostStmt<ObjCForCollectionStmt>, PostObjCMessage, DeadSymbols, PointerEscape>(), CountSelectorII(null) 
    //START JInit
    super();
    this.CountSelectorII = null;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCLoopChecker::checkPostStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BasicObjCFoundationChecks.cpp", line = 1005,
   FQN="(anonymous namespace)::ObjCLoopChecker::checkPostStmt", NM="_ZNK12_GLOBAL__N_115ObjCLoopChecker13checkPostStmtEPKN5clang21ObjCForCollectionStmtERNS1_4ento14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BasicObjCFoundationChecks.cpp -nm=_ZNK12_GLOBAL__N_115ObjCLoopChecker13checkPostStmtEPKN5clang21ObjCForCollectionStmtERNS1_4ento14CheckerContextE")
  //</editor-fold>
  public void checkPostStmt(/*const*/ ObjCForCollectionStmt /*P*/ FCS, 
               final CheckerContext /*&*/ C) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> State = null;
    try {
      State = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());

      // Check if this is the branch for the end of the loop.
      SVal CollectionSentinel = C.getSVal(FCS);
      if (CollectionSentinel.isZeroConstant()) {
        if (!BasicObjCFoundationChecksStatics.alreadyExecutedAtLeastOneLoopIteration(C.getPredecessor(), FCS)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean(State.$assign($c$.track(BasicObjCFoundationChecksStatics.assumeCollectionNonEmpty(C, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), FCS, /*Assumption*/ false))));
          } finally {
            $c$.$destroy();
          }
        }
        // Otherwise, this is a branch that goes through the loop body.
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean(State.$assign($c$.track(BasicObjCFoundationChecksStatics.checkCollectionNonNil(C, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), FCS))));
          $c$.clean(State.$assign($c$.track(BasicObjCFoundationChecksStatics.checkElementNonNil(C, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), FCS))));
          $c$.clean(State.$assign($c$.track(BasicObjCFoundationChecksStatics.assumeCollectionNonEmpty(C, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), FCS, /*Assumption*/ true))));
        } finally {
          $c$.$destroy();
        }
      }
      if (!State.$bool()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean(C.generateSink($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState())), C.getPredecessor()));
        } finally {
          $c$.$destroy();
        }
      } else if ($noteq_IntrusiveRefCntPtr(State, C.getState())) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean(C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))));
        } finally {
          $c$.$destroy();
        }
      }
    } finally {
     if (State != null) { State.$destroy(); }
    } 
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCLoopChecker::checkPostObjCMessage">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BasicObjCFoundationChecks.cpp", line = 1040,
   FQN="(anonymous namespace)::ObjCLoopChecker::checkPostObjCMessage", NM="_ZNK12_GLOBAL__N_115ObjCLoopChecker20checkPostObjCMessageERKN5clang4ento14ObjCMethodCallERNS2_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BasicObjCFoundationChecks.cpp -nm=_ZNK12_GLOBAL__N_115ObjCLoopChecker20checkPostObjCMessageERKN5clang4ento14ObjCMethodCallERNS2_14CheckerContextE")
  //</editor-fold>
  public void checkPostObjCMessage(final /*const*/ ObjCMethodCall /*&*/ M, 
                      final CheckerContext /*&*/ C) /*const*/ {
    if (!M.isInstanceMessage()) {
      return;
    }
    
    /*const*/ ObjCInterfaceDecl /*P*/ ClassID = M.getReceiverInterface();
    if (!(ClassID != null)) {
      return;
    }
    
    FoundationClass Class = BasicObjCFoundationChecksStatics.findKnownClass(ClassID);
    if (Class != FoundationClass.FC_NSDictionary
       && Class != FoundationClass.FC_NSArray
       && Class != FoundationClass.FC_NSSet
       && Class != FoundationClass.FC_NSOrderedSet) {
      return;
    }
    
    /*const*/ SymExpr /*P*/ ContainerS = M.getReceiverSVal().getAsSymbol();
    if (!(ContainerS != null)) {
      return;
    }
    
    // If we are processing a call to "count", get the symbolic value returned by
    // a call to "count" and add it to the map.
    if (!isCollectionCountMethod(M, C)) {
      return;
    }
    
    /*const*/ Expr /*P*/ MsgExpr = M.getOriginExpr();
    /*const*/ SymExpr /*P*/ CountS = C.getSVal(MsgExpr).getAsSymbol();
    if ((CountS != null)) {
      IntrusiveRefCntPtr</*const*/ ProgramState> State = null;
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        State = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
        
        C.getSymbolManager().addSymbolDependency(ContainerS, CountS);
        $c$.clean(State.$assign($c$.track(State.$arrow().set(ProgramStateTraitContainerCountMap.$Instance, ContainerS, CountS))));
        {
          
          /*const*/bool$ptr/*bool P*/ NonEmpty = State.$arrow().get(ProgramStateTraitContainerNonEmptyMap.$Instance, ContainerS);
          if (/*JAVA*/(NonEmpty != null)) {
            $c$.clean(State.$assign($c$.track(State.$arrow().remove(ProgramStateTraitContainerNonEmptyMap.$Instance, ContainerS))));
            $c$.clean(State.$assign($c$.track(BasicObjCFoundationChecksStatics.assumeCollectionNonEmpty(C, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), ContainerS, NonEmpty.$star()))));
          }
        }
        
        $c$.clean(C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))));
      } finally {
        if (State != null) { State.$destroy(); }
        $c$.$destroy();
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCLoopChecker::checkDeadSymbols">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BasicObjCFoundationChecks.cpp", line = 1148,
   FQN="(anonymous namespace)::ObjCLoopChecker::checkDeadSymbols", NM="_ZNK12_GLOBAL__N_115ObjCLoopChecker16checkDeadSymbolsERN5clang4ento12SymbolReaperERNS2_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BasicObjCFoundationChecks.cpp -nm=_ZNK12_GLOBAL__N_115ObjCLoopChecker16checkDeadSymbolsERN5clang4ento12SymbolReaperERNS2_14CheckerContextE")
  //</editor-fold>
  public void checkDeadSymbols(final SymbolReaper /*&*/ SymReaper, 
                  final CheckerContext /*&*/ C) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> State = null;
    ImmutableMapPtrPtr</*const*/ SymExpr /*P*/ , /*const*/ SymExpr /*P*/ > Tracked = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      State = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
      
      // Remove the dead symbols from the collection count map.
      Tracked = State.$arrow()./*<ContainerCountMap>*/get(ProgramStateTraitContainerCountMap.$Instance);
      ImmutableMapPtrPtr.iterator</*const*/ SymExpr /*P*/ , /*const*/ SymExpr /*P*/ > I = null;
      ImmutableMapPtrPtr.iterator</*const*/ SymExpr /*P*/ , /*const*/ SymExpr /*P*/ > E = null;
      try {
        for (I = Tracked.begin(), 
            E = Tracked.end(); I.$noteq(E); I.$preInc()) {
          /*const*/ SymExpr /*P*/ Sym = I.$arrow().first;
          if (SymReaper.isDead(Sym)) {
            $c$.clean(State.$assign($c$.track(State.$arrow()./*<ContainerCountMap>*/remove(ProgramStateTraitContainerCountMap.$Instance, Sym))));
            $c$.clean(State.$assign($c$.track(State.$arrow()./*<ContainerNonEmptyMap>*/remove(ProgramStateTraitContainerNonEmptyMap.$Instance, Sym))));
          }
        }
      } finally {
        if (E != null) { E.$destroy(); }
        if (I != null) { I.$destroy(); }
      }
      
      $c$.clean(C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))));
    } finally {
      if (Tracked != null) { Tracked.$destroy(); }
      if (State != null) { State.$destroy(); }
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCLoopChecker::checkPointerEscape">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BasicObjCFoundationChecks.cpp", line = 1120,
   FQN="(anonymous namespace)::ObjCLoopChecker::checkPointerEscape", NM="_ZNK12_GLOBAL__N_115ObjCLoopChecker18checkPointerEscapeEN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEERKNS1_8DenseSetIPKNS4_7SymExprENS1_12DenseMapInfoISB_EEEEPKNS4_9CallEventENS4_17PointerEscapeKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BasicObjCFoundationChecks.cpp -nm=_ZNK12_GLOBAL__N_115ObjCLoopChecker18checkPointerEscapeEN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEERKNS1_8DenseSetIPKNS4_7SymExprENS1_12DenseMapInfoISB_EEEEPKNS4_9CallEventENS4_17PointerEscapeKindE")
  //</editor-fold>
  public IntrusiveRefCntPtr</*const*/ ProgramState> checkPointerEscape(IntrusiveRefCntPtr</*const*/ ProgramState> State, 
                    final /*const*/DenseSet</*const*/ SymExpr /*P*/ > /*&*/ Escaped, 
                    /*const*/ CallEvent /*P*/ Call, 
                    PointerEscapeKind Kind) /*const*/ {
    /*const*/ SymExpr /*P*/ ImmutableReceiver = BasicObjCFoundationChecksStatics.getMethodReceiverIfKnownImmutable(Call);
    
    // Remove the invalidated symbols form the collection count map.
    for (DenseSet.iterator<SymExpr> I = Escaped.begin$Const(), 
        E = Escaped.end$Const();
         I.$noteq(E); I.$preInc()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        /*const*/ SymExpr /*P*/ Sym = I.$star();
        
        // Don't invalidate this symbol's count if we know the method being called
        // is declared on an immutable class. This isn't completely correct if the
        // receiver is also passed as an argument, but in most uses of NSArray,
        // NSDictionary, etc. this isn't likely to happen in a dangerous way.
        if (Sym == ImmutableReceiver) {
          continue;
        }
        
        // The symbol escaped. Pessimistically, assume that the count could have
        // changed.
        $c$.clean(State.$assign($c$.track(State.$arrow()./*<ContainerCountMap>*/remove(ProgramStateTraitContainerCountMap.$Instance, Sym))));
        $c$.clean(State.$assign($c$.track(State.$arrow()./*<ContainerNonEmptyMap>*/remove(ProgramStateTraitContainerNonEmptyMap.$Instance, Sym))));
      } finally {
        $c$.$destroy();
      }
    }
    return new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, State);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCLoopChecker::~ObjCLoopChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BasicObjCFoundationChecks.cpp", line = 836,
   FQN="(anonymous namespace)::ObjCLoopChecker::~ObjCLoopChecker", NM="_ZN12_GLOBAL__N_115ObjCLoopCheckerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BasicObjCFoundationChecks.cpp -nm=_ZN12_GLOBAL__N_115ObjCLoopCheckerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override
  public void $checkPostStmt(Stmt stmt, CheckerContext C) {
    if (stmt instanceof ObjCForCollectionStmt) {
      checkPostStmt((ObjCForCollectionStmt) stmt, C);
    }
  }

  private final CheckBase $CHECKS[] = {
    new org.clang.staticanalyzer.core.ento.check.PostStmt<ObjCForCollectionStmt>(ObjCForCollectionStmt.class),
    new PostObjCMessage(),
    new DeadSymbols(),
    new PointerEscape()
  };

  @Override
  protected CheckBase[] $getChecks() {
    return $CHECKS;
  }


  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "CountSelectorII=" + CountSelectorII // NOI18N
              + super.toString(); // NOI18N
  }
}
