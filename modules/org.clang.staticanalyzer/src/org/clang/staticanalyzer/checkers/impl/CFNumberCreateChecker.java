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
import static org.llvm.adt.ADTAliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.analysis.*;
import org.clang.basic.*;
import org.clang.staticanalyzer.core.bugreporter.ento.*;
import org.clang.staticanalyzer.core.ento.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import static org.clang.staticanalyzer.java.StaticanalyzerRTTI.*;
import org.clang.staticanalyzer.java.*;
import static org.clang.staticanalyzer.checkers.impl.BasicObjCFoundationChecksStatics.GetCFNumberSize;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFNumberCreateChecker">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BasicObjCFoundationChecks.cpp", line = 343,
 FQN="(anonymous namespace)::CFNumberCreateChecker", NM="_ZN12_GLOBAL__N_121CFNumberCreateCheckerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BasicObjCFoundationChecks.cpp -nm=_ZN12_GLOBAL__N_121CFNumberCreateCheckerE")
//</editor-fold>
public class CFNumberCreateChecker extends /*public*/ Checker/*T<org.clang.staticanalyzer.core.ento.check.PreStmt<CallExpr> > */
         implements org.clang.staticanalyzer.java.PreStmtChecker, Destructors.ClassWithDestructor {
  private /*mutable */std.unique_ptr<APIMisuse> BT;
  private /*mutable */IdentifierInfo /*P*/ II;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFNumberCreateChecker::CFNumberCreateChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BasicObjCFoundationChecks.cpp", line = 347,
   FQN="(anonymous namespace)::CFNumberCreateChecker::CFNumberCreateChecker", NM="_ZN12_GLOBAL__N_121CFNumberCreateCheckerC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BasicObjCFoundationChecks.cpp -nm=_ZN12_GLOBAL__N_121CFNumberCreateCheckerC1Ev")
  //</editor-fold>
  public CFNumberCreateChecker() {
    // : Checker<PreStmt<CallExpr> >(), BT(), II(null) 
    //START JInit
    super();
    this.BT = new std.unique_ptr<APIMisuse>();
    this.II = null;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFNumberCreateChecker::checkPreStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BasicObjCFoundationChecks.cpp", line = 428,
   FQN="(anonymous namespace)::CFNumberCreateChecker::checkPreStmt", NM="_ZNK12_GLOBAL__N_121CFNumberCreateChecker12checkPreStmtEPKN5clang8CallExprERNS1_4ento14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BasicObjCFoundationChecks.cpp -nm=_ZNK12_GLOBAL__N_121CFNumberCreateChecker12checkPreStmtEPKN5clang8CallExprERNS1_4ento14CheckerContextE")
  //</editor-fold>
  public void checkPreStmt(/*const*/ CallExpr /*P*/ CE, 
              final CheckerContext /*&*/ C) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> state = null;
    try {
      state = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
      /*const*/ FunctionDecl /*P*/ FD = C.getCalleeDecl(CE);
      if (!(FD != null)) {
        return;
      }
      
      final ASTContext /*&*/ Ctx = C.getASTContext();
      if (!(II != null)) {
        II = $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"CFNumberCreate")));
      }
      if (FD.getIdentifier() != II || CE.getNumArgs() != 3) {
        return;
      }
      
      // Get the value of the "theType" argument.
      /*const*/ LocationContext /*P*/ LCtx = C.getLocationContext();
      SVal TheTypeVal = state.$arrow().getSVal(CE.getArg$Const(1), LCtx);
      
      // FIXME: We really should allow ranges of valid theType values, and
      //   bifurcate the state appropriately.
      Optional<NsNonloc.ConcreteInt> V = TheTypeVal.getAs(NsNonloc.ConcreteInt.class);
      if (!V.$bool()) {
        return;
      }
      
      long/*uint64_t*/ NumberKind = V.$arrow().getValue().getLimitedValue();
      OptionalULong OptTargetSize = BasicObjCFoundationChecksStatics.GetCFNumberSize(Ctx, NumberKind);
      
      // FIXME: In some cases we can emit an error.
      if (!OptTargetSize.$bool()) {
        return;
      }
      
      long/*uint64_t*/ TargetSize = OptTargetSize.$star();
      
      // Look at the value of the integer being passed by reference.  Essentially
      // we want to catch cases where the value passed in is not equal to the
      // size of the type being created.
      SVal TheValueExpr = state.$arrow().getSVal(CE.getArg$Const(2), LCtx);
      
      // FIXME: Eventually we should handle arbitrary locations.  We can do this
      //  by having an enhanced memory model that does low-level typing.
      Optional<NsLoc.MemRegionVal> LV = TheValueExpr.getAs(NsLoc.MemRegionVal.class);
      if (!LV.$bool()) {
        return;
      }
      
      /*const*/ TypedValueRegion /*P*/ R = dyn_cast_TypedValueRegion(LV.$arrow().stripCasts());
      if (!(R != null)) {
        return;
      }
      
      QualType T = Ctx.getCanonicalType(R.getValueType()).$QualType();
      
      // FIXME: If the pointee isn't an integer type, should we flag a warning?
      //  People can do weird stuff with pointers.
      if (!T.$arrow().isIntegralOrEnumerationType()) {
        return;
      }
      
      long/*uint64_t*/ SourceSize = Ctx.getTypeSize(new QualType(T));
      
      // CHECK: is SourceSize == TargetSize
      if (SourceSize == TargetSize) {
        return;
      }
      
      // Generate an error.  Only generate a sink error node
      // if 'SourceSize < TargetSize'; otherwise generate a non-fatal error node.
      //
      // FIXME: We can actually create an abstract "CFNumber" object that has
      //  the bits initialized to the provided values.
      //
      ExplodedNode /*P*/ N = $less_ulong(SourceSize, TargetSize) ? C.generateErrorNode() : C.generateNonFatalErrorNode();
      if ((N != null)) {
        raw_svector_ostream os = null;
        unique_ptr<BugReport> report = null;
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          SmallString/*<128>*/ sbuf/*J*/= new SmallString/*<128>*/(128);
          os/*J*/= new raw_svector_ostream(sbuf);
          
          os.$out((SourceSize == $int2ullong(8) ? $("An ") : $("A "))).$out_ullong(
              SourceSize
          ).$out(/*KEEP_STR*/" bit integer is used to initialize a CFNumber object that represents ").$out(
              (TargetSize == $int2ullong(8) ? $("an ") : $("a "))
          ).$out_ullong(
              TargetSize
          ).$out(/*KEEP_STR*/" bit integer. ");
          if ($less_ulong(SourceSize, TargetSize)) {
            os.$out_ullong((TargetSize - SourceSize)).$out(
                /*KEEP_STR*/" bits of the CFNumber value will be garbage."
            );
          } else {
            os.$out_ullong((SourceSize - TargetSize)).$out(
                /*KEEP_STR*/" bits of the input integer will be lost."
            );
          }
          if (!BT.$bool()) {
            BT.reset(new APIMisuse(this, $("Bad use of CFNumberCreate")));
          }
          
          report = llvm.make_unique(new BugReport(BT.$star(), os.str(), N));
          report.$arrow().addRange(CE.getArg$Const(2).getSourceRange());
          C.emitReport($c$.track(new std.unique_ptr<BugReport>(JD$Move.INSTANCE, std.move(report)))); $c$.clean();
        } finally {
          if (report != null) { report.$destroy(); }
          if (os != null) { os.$destroy(); }
          $c$.$destroy();
        }
      }
    } finally {
      if (state != null) { state.$destroy(); }
    }
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFNumberCreateChecker::EmitError">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BasicObjCFoundationChecks.cpp", line = 352,
   FQN="(anonymous namespace)::CFNumberCreateChecker::EmitError", NM="_ZN12_GLOBAL__N_121CFNumberCreateChecker9EmitErrorEPKN5clang4ento11TypedRegionEPKNS1_4ExprEyyy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BasicObjCFoundationChecks.cpp -nm=_ZN12_GLOBAL__N_121CFNumberCreateChecker9EmitErrorEPKN5clang4ento11TypedRegionEPKNS1_4ExprEyyy")
  //</editor-fold>
  private void EmitError(/*const*/ TypedRegion /*P*/ R, /*const*/ Expr /*P*/ Ex, 
           long/*uint64_t*/ SourceSize, long/*uint64_t*/ TargetSize, long/*uint64_t*/ NumberKind) {
    throw new UnsupportedOperationException("<<<DeclJavaPrinter::VisitFunctionDecl NULL BODY IN USED Translation Unit>>>");
  }


  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFNumberCreateChecker::~CFNumberCreateChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BasicObjCFoundationChecks.cpp", line = 343,
   FQN="(anonymous namespace)::CFNumberCreateChecker::~CFNumberCreateChecker", NM="_ZN12_GLOBAL__N_121CFNumberCreateCheckerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BasicObjCFoundationChecks.cpp -nm=_ZN12_GLOBAL__N_121CFNumberCreateCheckerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    BT.$destroy();
    super.$destroy();
    //END JDestroy
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override  public void $checkPreStmt(Stmt stmt, CheckerContext C) { if (stmt instanceof CallExpr) { checkPreStmt((CallExpr) stmt, C); } }

  private final CheckBase $CHECKS[] = {
    new org.clang.staticanalyzer.core.ento.check.PreStmt<CallExpr>(CallExpr.class)
  };

  @Override protected CheckBase[] $getChecks() { return $CHECKS; }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "BT=" + BT // NOI18N
              + ", II=" + II // NOI18N
              + super.toString(); // NOI18N
  }
}
