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
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.staticanalyzer.core.bugreporter.ento.*;
import org.clang.staticanalyzer.core.ento.*;
import org.clang.staticanalyzer.core.ento.check.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import org.clang.staticanalyzer.java.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::NonNullParamChecker">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC, // delegate to EventDispatcher<ImplicitNullDerefEvent> instead of exnending it
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NonNullParamChecker.cpp", line = 30,
 FQN="(anonymous namespace)::NonNullParamChecker", NM="_ZN12_GLOBAL__N_119NonNullParamCheckerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NonNullParamChecker.cpp -nm=_ZN12_GLOBAL__N_119NonNullParamCheckerE")
//</editor-fold>
public class NonNullParamChecker extends /*public*/ Checker/*<PreCall, EventDispatcher<ImplicitNullDerefEvent> > */
        implements org.clang.staticanalyzer.java.PreCallChecker, Destructors.ClassWithDestructor {
  private /*mutable */std.unique_ptr<BugType> BTAttrNonNull;
  private /*mutable */std.unique_ptr<BugType> BTNullRefArg;
/*public:*/
  
  // end anonymous namespace
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::NonNullParamChecker::checkPreCall">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NonNullParamChecker.cpp", line = 47,
   FQN="(anonymous namespace)::NonNullParamChecker::checkPreCall", NM="_ZNK12_GLOBAL__N_119NonNullParamChecker12checkPreCallERKN5clang4ento9CallEventERNS2_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NonNullParamChecker.cpp -nm=_ZNK12_GLOBAL__N_119NonNullParamChecker12checkPreCallERKN5clang4ento9CallEventERNS2_14CheckerContextE")
  //</editor-fold>
  public void checkPreCall(final /*const*/ CallEvent /*&*/ Call, 
              final CheckerContext /*&*/ C) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> state = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      /*const*/ Decl /*P*/ FD = Call.getDecl();
      if (!(FD != null)) {
        return;
      }
      
      // Merge all non-null attributes
      /*uint*/int NumArgs = Call.getNumArgs();
      SmallBitVector AttrNonNull/*J*/= new SmallBitVector(NumArgs);
      for (/*const*/ NonNullAttr /*P*/ NonNull : FD.specific_attrs(NonNullAttr.class)) {
        if (!(NonNull.args_size() != 0)) {
          AttrNonNull.set(0, NumArgs);
          break;
        }
        for (/*uint*/int Val : NonNull.args()) {
          if ($greatereq_uint(Val, NumArgs)) {
            continue;
          }
          AttrNonNull.set(Val);
        }
      }
      
      state = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());

      mapped_iterator<ParmVarDecl/*P*/, QualType> TyI = Call.param_type_begin();
      mapped_iterator<ParmVarDecl/*P*/, QualType> TyE = Call.param_type_end();      

      for (/*uint*/int idx = 0; $less_uint(idx, NumArgs); ++idx) {
        IntrusiveRefCntPtr</*const*/ ProgramState> stateNotNull = null;
        IntrusiveRefCntPtr</*const*/ ProgramState> stateNull = null;
        try {
          
          // Check if the parameter is a reference. We want to report when reference
          // to a null pointer is passed as a paramter.
          boolean haveRefTypeParam = false;
          if (TyI.$noteq(TyE)) {
            haveRefTypeParam = (TyI.$star()).$arrow().isReferenceType();
            TyI.$postInc(0);
          }
          
          boolean haveAttrNonNull = AttrNonNull.$at(idx).$bool();
          if (!haveAttrNonNull) {
            // Check if the parameter is also marked 'nonnull'.
            ArrayRef<ParmVarDecl /*P*/ > parms = Call.parameters();
            if ($less_uint(idx, parms.size())) {
              haveAttrNonNull = parms.$at(idx).hasAttr(NonNullAttr.class);
            }
          }
          if (!haveRefTypeParam && !haveAttrNonNull) {
            continue;
          }
          
          // If the value is unknown or undefined, we can't perform this check.
          /*const*/ Expr /*P*/ ArgE = Call.getArgExpr(idx);
          SVal V = Call.getArgSVal(idx);
          Optional<DefinedSVal> DV = V.getAs(DefinedSVal.class);
          if (!DV.$bool()) {
            continue;
          }
          
          // Process the case when the argument is not a location.
          assert (!haveRefTypeParam || DV.$arrow().getAs(Loc.class).$bool());
          if (haveAttrNonNull && !DV.$arrow().getAs(Loc.class).$bool()) {
            // If the argument is a union type, we want to handle a potential
            // transparent_union GCC extension.
            if (!(ArgE != null)) {
              continue;
            }
            
            QualType T = ArgE.getType();
            /*const*/ RecordType /*P*/ UT = T.$arrow().getAsUnionType();
            if (!(UT != null) || !UT.getDecl().hasAttr(TransparentUnionAttr.class)) {
              continue;
            }
            {
              
              Optional<NsNonloc.CompoundVal> CSV = DV.$arrow().getAs(NsNonloc.CompoundVal.class);
              if (CSV.$bool()) {
                ImmutableList.iterator<SVal> CSV_I = CSV.$arrow().begin();
                assert (CSV_I.$noteq(CSV.$arrow().end()));
                V.$assign(CSV_I.$star());
                DV.$assignMove(V.getAs(DefinedSVal.class));
                assert (CSV_I.$preInc().$eq(CSV.$arrow().end()));
                // FIXME: Handle (some_union){ some_other_union_val }, which turns into
                // a LazyCompoundVal inside a CompoundVal.
                if (!V.getAs(Loc.class).$bool()) {
                  continue;
                }
                {
                  // Retrieve the corresponding expression.
                  /*const*/ CompoundLiteralExpr /*P*/ CE = dyn_cast_CompoundLiteralExpr(ArgE);
                  if ((CE != null)) {
                    {
                      /*const*/ InitListExpr /*P*/ IE = dyn_cast_InitListExpr(CE.getInitializer$Const());
                      if ((IE != null)) {
                        ArgE = dyn_cast_Expr((IE.begin$Const()).$star());
                      }
                    }
                  }
                }
              } else {
                // FIXME: Handle LazyCompoundVals?
                continue;
              }
            }
          }
          
          final ConstraintManager /*&*/ CM = C.getConstraintManager();
          stateNotNull/*J*/= new IntrusiveRefCntPtr</*const*/ ProgramState>();
          stateNull/*J*/= new IntrusiveRefCntPtr</*const*/ ProgramState>();
//          $c$.clean(std.tie(stateNotNull, stateNull).$assign($c$.track(CM.assumeDual($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), new DefinedSVal(DV.$star())))));
          // JAVA: when unfold tie make sure returned pair is cleaned (in this case ProgramState was moved to other instances)
          std.pairTypeType<IntrusiveRefCntPtr</*const*/ ProgramState>, IntrusiveRefCntPtr</*const*/ ProgramState>> $assumeDual = 
                  $c$.track(CM.assumeDual($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), new DefinedSVal(DV.$star())));
          stateNotNull.$assign($assumeDual.first);
          stateNull.$assign($assumeDual.second);
          assert !$assumeDual.first.$bool();
          assert !$assumeDual.second.$bool();
          $c$.clean();

          if (stateNull.$bool()) {
            if (!stateNotNull.$bool()) {
              {
                // Generate an error node.  Check for a null node in case
                // we cache out.
                ExplodedNode /*P*/ errorNode = $c$.clean(C.generateErrorNode($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(stateNull))));
                if ((errorNode != null)) {
                  std.unique_ptr<BugReport> R = null;
                  try {
                    
                    R/*J*/= new std.unique_ptr<BugReport>();
                    if (haveAttrNonNull) {
                      $c$.clean(R.$assignMove($c$.track(genReportNullAttrNonNull(errorNode, ArgE))));
                    } else if (haveRefTypeParam) {
                      $c$.clean(R.$assignMove($c$.track(genReportReferenceToNullPointer(errorNode, ArgE))));
                    }
                    
                    // Highlight the range of the argument that was null.
                    R.$arrow().addRange(Call.getArgSourceRange(idx));
                    
                    // Emit the bug report.
                    C.emitReport($c$.track(new std.unique_ptr<BugReport>(JD$Move.INSTANCE, std.move(R)))); $c$.clean();
                  } finally {
                    if (R != null) { R.$destroy(); }
                  }
                }
              }
              
              // Always return.  Either we cached out or we just emitted an error.
              return;
            }
            {
              ExplodedNode /*P*/ N = $c$.clean(C.generateSink($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(stateNull)), C.getPredecessor()));
              if ((N != null)) {
                ImplicitNullDerefEvent event = new ImplicitNullDerefEvent(
                  V, false, N, $AddrOf(C.getBugReporter()), 
                  /*IsDirectDereference=*/ haveRefTypeParam);
                $Dispatcher.dispatchEvent(event);
              }
            }
          }
          
          // If a pointer value passed the check we should assume that it is
          // indeed not null from this point forward.
          assert ((stateNotNull).$bool());
          $c$.clean(state.$assign($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(stateNotNull))));
        } finally {
          if (stateNull != null) { stateNull.$destroy(); }
          if (stateNotNull != null) { stateNotNull.$destroy(); }
        }
      }
      
      // If we reach here all of the arguments passed the nonnull check.
      // If 'state' has been updated generated a new node.
      $c$.clean(C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state))));
    } finally {
      if (state != null) { state.$destroy(); }
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::NonNullParamChecker::genReportNullAttrNonNull">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NonNullParamChecker.cpp", line = 183,
   FQN="(anonymous namespace)::NonNullParamChecker::genReportNullAttrNonNull", NM="_ZNK12_GLOBAL__N_119NonNullParamChecker24genReportNullAttrNonNullEPKN5clang4ento12ExplodedNodeEPKNS1_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NonNullParamChecker.cpp -nm=_ZNK12_GLOBAL__N_119NonNullParamChecker24genReportNullAttrNonNullEPKN5clang4ento12ExplodedNodeEPKNS1_4ExprE")
  //</editor-fold>
  public std.unique_ptr<BugReport> genReportNullAttrNonNull(/*const*/ ExplodedNode /*P*/ ErrorNode, 
                          /*const*/ Expr /*P*/ ArgE) /*const*/ {
    unique_ptr<BugReport> R = null;
    try {
      // Lazily allocate the BugType object if it hasn't already been
      // created. Ownership is transferred to the BugReporter object once
      // the BugReport is passed to 'EmitWarning'.
      if (!BTAttrNonNull.$bool()) {
        BTAttrNonNull.reset(new BugType(this, new StringRef(/*KEEP_STR*/"Argument with 'nonnull' attribute passed null"), new StringRef(/*KEEP_STR*/"API")));
      }
      
      R = llvm.make_unique(new BugReport(BTAttrNonNull.$star(), 
          $("Null pointer passed as an argument to a 'nonnull' parameter"), ErrorNode));
      if ((ArgE != null)) {
        NsBugreporter.trackNullOrUndefValue(ErrorNode, ArgE, R.$star());
      }
      
      return new std.unique_ptr<BugReport>(JD$Move.INSTANCE, R);
    } finally {
      if (R != null) { R.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::NonNullParamChecker::genReportReferenceToNullPointer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NonNullParamChecker.cpp", line = 202,
   FQN="(anonymous namespace)::NonNullParamChecker::genReportReferenceToNullPointer", NM="_ZNK12_GLOBAL__N_119NonNullParamChecker31genReportReferenceToNullPointerEPKN5clang4ento12ExplodedNodeEPKNS1_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NonNullParamChecker.cpp -nm=_ZNK12_GLOBAL__N_119NonNullParamChecker31genReportReferenceToNullPointerEPKN5clang4ento12ExplodedNodeEPKNS1_4ExprE")
  //</editor-fold>
  public std.unique_ptr<BugReport> genReportReferenceToNullPointer(/*const*/ ExplodedNode /*P*/ ErrorNode, /*const*/ Expr /*P*/ ArgE) /*const*/ {
    unique_ptr<BugReport> R = null;
    try {
      if (!BTNullRefArg.$bool()) {
        BTNullRefArg.reset(new BuiltinBug(this, $("Dereference of null pointer")));
      }
      
      R = llvm.make_unique(new BugReport(BTNullRefArg.$star(), $("Forming reference to null pointer"), ErrorNode));
      if ((ArgE != null)) {
        /*const*/ Expr /*P*/ ArgEDeref = NsBugreporter.getDerefExpr(ArgE);
        if (!(ArgEDeref != null)) {
          ArgEDeref = ArgE;
        }
        NsBugreporter.trackNullOrUndefValue(ErrorNode, 
            ArgEDeref, 
            R.$star());
      }
      return new std.unique_ptr<BugReport>(JD$Move.INSTANCE, R);
    } finally {
      if (R != null) { R.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::NonNullParamChecker::~NonNullParamChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NonNullParamChecker.cpp", line = 30,
   FQN="(anonymous namespace)::NonNullParamChecker::~NonNullParamChecker", NM="_ZN12_GLOBAL__N_119NonNullParamCheckerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NonNullParamChecker.cpp -nm=_ZN12_GLOBAL__N_119NonNullParamCheckerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    BTNullRefArg.$destroy();
    BTAttrNonNull.$destroy();
    super.$destroy();
    //END JDestroy
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::NonNullParamChecker::NonNullParamChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NonNullParamChecker.cpp", line = 30,
   FQN="(anonymous namespace)::NonNullParamChecker::NonNullParamChecker", NM="_ZN12_GLOBAL__N_119NonNullParamCheckerC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/NonNullParamChecker.cpp -nm=_ZN12_GLOBAL__N_119NonNullParamCheckerC1Ev")
  //</editor-fold>
  public /*inline*/ NonNullParamChecker() {
    // : Checker<PreCall, EventDispatcher<ImplicitNullDerefEvent> >(), BTAttrNonNull(), BTNullRefArg() 
    //START JInit
    super();
    this.BTAttrNonNull = new std.unique_ptr<BugType>();
    this.BTNullRefArg = new std.unique_ptr<BugType>();
    //END JInit
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  EventDispatcher<ImplicitNullDerefEvent> $Dispatcher = new EventDispatcher<ImplicitNullDerefEvent>(ImplicitNullDerefEvent.class);

  private final CheckBase $CHECKS[] = {
    new PreCall(),
    $Dispatcher
  };

  @Override
  protected CheckBase[] $getChecks() {
    return $CHECKS;
  }
  
  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////

  @Override public String toString() {
    return "" + "BTAttrNonNull=" + BTAttrNonNull // NOI18N
              + ", BTNullRefArg=" + BTNullRefArg // NOI18N
              + super.toString(); // NOI18N
  }
}
