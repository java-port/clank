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

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.staticanalyzer.core.bugreporter.ento.*;
import org.clang.staticanalyzer.core.ento.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import static org.clang.staticanalyzer.java.StaticanalyzerRTTI.*;
import static org.clang.staticanalyzer.checkers.impl.CastSizeCheckerStatics.*;
import org.clang.staticanalyzer.java.CheckBase;
import static org.clang.ast.java.AstTypesRTTI.*;


//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CastSizeChecker">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CastSizeChecker.cpp", line = 25,
 FQN="(anonymous namespace)::CastSizeChecker", NM="_ZN12_GLOBAL__N_115CastSizeCheckerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CastSizeChecker.cpp -nm=_ZN12_GLOBAL__N_115CastSizeCheckerE")
//</editor-fold>
public class CastSizeChecker extends /*public*/ Checker/*T<PreStmt<CastExpr> > */
        implements org.clang.staticanalyzer.java.PreStmtChecker, Destructors.ClassWithDestructor {
  private /*mutable */std.unique_ptr<BuiltinBug> BT;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CastSizeChecker::checkPreStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CastSizeChecker.cpp", line = 88,
   FQN="(anonymous namespace)::CastSizeChecker::checkPreStmt", NM="_ZNK12_GLOBAL__N_115CastSizeChecker12checkPreStmtEPKN5clang8CastExprERNS1_4ento14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CastSizeChecker.cpp -nm=_ZNK12_GLOBAL__N_115CastSizeChecker12checkPreStmtEPKN5clang8CastExprERNS1_4ento14CheckerContextE")
  //</editor-fold>
  public void checkPreStmt(/*const*/ CastExpr /*P*/ CE, final CheckerContext /*&*/ C) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> state = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      /*const*/ Expr /*P*/ E = CE.getSubExpr$Const();
      final ASTContext /*&*/ Ctx = C.getASTContext();
      QualType ToTy = Ctx.getCanonicalType(CE.getType()).$QualType();
      /*const*/ PointerType /*P*/ ToPTy = dyn_cast_PointerType(ToTy.getTypePtr());
      if (!(ToPTy != null)) {
        return;
      }
      
      QualType ToPointeeTy = ToPTy.getPointeeType();
      
      // Only perform the check if 'ToPointeeTy' is a complete type.
      if (ToPointeeTy.$arrow().isIncompleteType()) {
        return;
      }
      
      state = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
      /*const*/ MemRegion /*P*/ R = state.$arrow().getSVal(E, C.getLocationContext()).getAsRegion();
      if (!(R != null)) {
        return;
      }
      
      /*const*/ SymbolicRegion /*P*/ SR = dyn_cast_SymbolicRegion(R);
      if (!(SR != null)) {
        return;
      }
      
      final SValBuilder /*&*/ svalBuilder = C.getSValBuilder();
      SVal extent = new SVal(JD$Move.INSTANCE, SR.getExtent(svalBuilder));
      /*const*/ APSInt /*P*/ extentInt = $c$.clean(svalBuilder.getKnownValue($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), new SVal(extent)));
      if (!(extentInt != null)) {
        return;
      }
      
      CharUnits regionSize = CharUnits.fromQuantity(extentInt.getSExtValue());
      CharUnits typeSize = C.getASTContext().getTypeSizeInChars(/*NO_COPY*/ToPointeeTy);
      
      // Ignore void, and a few other un-sizeable types.
      if (typeSize.isZero()) {
        return;
      }
      if (regionSize.$mod(typeSize) == 0) {
        return;
      }
      if (CastSizeCheckerStatics.evenFlexibleArraySize(Ctx, new CharUnits(regionSize), new CharUnits(typeSize), new QualType(ToPointeeTy))) {
        return;
      }
      {
        
        ExplodedNode /*P*/ errorNode = C.generateErrorNode();
        if ((errorNode != null)) {
          unique_ptr<BugReport> R$1 = null;
          try {
            if (!BT.$bool()) {
              BT.reset(new BuiltinBug(this, $("Cast region with wrong size."), 
                      $("Cast a region whose size is not a multiple of the destination type size.")));
            }
            R$1 = llvm.make_unique(new BugReport(BT.$star(), BT.$arrow().getDescription(), errorNode));
            R$1.$arrow().addRange(CE.getSourceRange());
            C.emitReport($c$.track(new std.unique_ptr<BugReport>(JD$Move.INSTANCE, std.move(R$1)))); $c$.clean();
          } finally {
            if (R$1 != null) { R$1.$destroy(); }
          }
        }
      }
    } finally {
      if (state != null) { state.$destroy(); }
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CastSizeChecker::~CastSizeChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CastSizeChecker.cpp", line = 25,
   FQN="(anonymous namespace)::CastSizeChecker::~CastSizeChecker", NM="_ZN12_GLOBAL__N_115CastSizeCheckerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CastSizeChecker.cpp -nm=_ZN12_GLOBAL__N_115CastSizeCheckerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    BT.$destroy();
    super.$destroy();
    //END JDestroy
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CastSizeChecker::CastSizeChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CastSizeChecker.cpp", line = 25,
   FQN="(anonymous namespace)::CastSizeChecker::CastSizeChecker", NM="_ZN12_GLOBAL__N_115CastSizeCheckerC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CastSizeChecker.cpp -nm=_ZN12_GLOBAL__N_115CastSizeCheckerC1Ev")
  //</editor-fold>
  public /*inline*/ CastSizeChecker() {
    // : Checker<PreStmt<CastExpr> >(), BT() 
    //START JInit
    super();
    this.BT = new std.unique_ptr<BuiltinBug>();
    //END JInit
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override
  public void $checkPreStmt(Stmt stmt, CheckerContext C) {
    if (stmt instanceof CastExpr) {
      checkPreStmt((CastExpr) stmt, C);
    }
  }

  private final CheckBase $CHECKS[] = {
    new org.clang.staticanalyzer.core.ento.check.PreStmt<CastExpr>(CastExpr.class)
  };

  @Override
  protected CheckBase[] $getChecks() {
    return $CHECKS;
  }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "BT=" + BT // NOI18N
              + super.toString(); // NOI18N
  }
}
