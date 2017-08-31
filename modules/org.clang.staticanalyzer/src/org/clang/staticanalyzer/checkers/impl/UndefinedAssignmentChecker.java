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
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.staticanalyzer.core.bugreporter.ento.*;
import org.clang.staticanalyzer.core.ento.*;
import org.clang.staticanalyzer.core.ento.check.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import org.clang.staticanalyzer.java.*;
import static org.clang.ast.java.AstStatementsRTTI.*;


//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UndefinedAssignmentChecker">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/UndefinedAssignmentChecker.cpp", line = 25,
 FQN="(anonymous namespace)::UndefinedAssignmentChecker", NM="_ZN12_GLOBAL__N_126UndefinedAssignmentCheckerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/UndefinedAssignmentChecker.cpp -nm=_ZN12_GLOBAL__N_126UndefinedAssignmentCheckerE")
//</editor-fold>
public class UndefinedAssignmentChecker extends /*public*/ Checker/*T<Bind> */
        implements org.clang.staticanalyzer.java.BindChecker, Destructors.ClassWithDestructor {
  private /*mutable */std.unique_ptr<BugType> BT;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UndefinedAssignmentChecker::checkBind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/UndefinedAssignmentChecker.cpp", line = 35,
   FQN="(anonymous namespace)::UndefinedAssignmentChecker::checkBind", NM="_ZNK12_GLOBAL__N_126UndefinedAssignmentChecker9checkBindEN5clang4ento4SValES3_PKNS1_4StmtERNS2_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/UndefinedAssignmentChecker.cpp -nm=_ZNK12_GLOBAL__N_126UndefinedAssignmentChecker9checkBindEN5clang4ento4SValES3_PKNS1_4StmtERNS2_14CheckerContextE")
  //</editor-fold>
  public void checkBind(SVal location, SVal val, 
           /*const*/ Stmt /*P*/ StoreE, 
           final CheckerContext /*&*/ C) /*const*/ {
    unique_ptr<BugReport> R = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      if (!val.isUndef$SVal()) {
        return;
      }
      {
        
        // Do not report assignments of uninitialized values inside swap functions.
        // This should allow to swap partially uninitialized structs
        // (radar://14129997)
        /*const*/ FunctionDecl /*P*/ EnclosingFunctionDecl = dyn_cast_FunctionDecl(C.getStackFrame().getDecl());
        if ((EnclosingFunctionDecl != null)) {
          if ($eq_StringRef(C.getCalleeName(EnclosingFunctionDecl), /*STRINGREF_STR*/"swap")) {
            return;
          }
        }
      }
      
      ExplodedNode /*P*/ N = C.generateErrorNode();
      if (!(N != null)) {
        return;
      }
      
      /*const*/char$ptr/*char P*/ str = $("Assigned value is garbage or undefined");
      if (!BT.$bool()) {
        BT.reset(new BuiltinBug(this, str));
      }
      
      // Generate a report for this bug.
      /*const*/ Expr /*P*/ ex = null;
      while ((StoreE != null)) {
        {
          /*const*/ BinaryOperator /*P*/ B = dyn_cast_BinaryOperator(StoreE);
          if ((B != null)) {
            if (B.isCompoundAssignmentOp()) {
              IntrusiveRefCntPtr</*const*/ ProgramState> state = null;
              try {
                state = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
                if (state.$arrow().getSVal(B.getLHS(), C.getLocationContext()).isUndef$SVal()) {
                  str = $("The left expression of the compound assignment is an uninitialized value. The computed value will also be garbage");
                  ex = B.getLHS();
                  break;
                }
              } finally {
                if (state != null) { state.$destroy(); }
              }
            }
            
            ex = B.getRHS();
            break;
          }
        }
        {
          
          /*const*/ DeclStmt /*P*/ DS = dyn_cast_DeclStmt(StoreE);
          if ((DS != null)) {
            /*const*/ VarDecl /*P*/ VD = dyn_cast_VarDecl(DS.getSingleDecl$Const());
            ex = VD.getInit$Const();
          }
        }
        
        break;
      }
      
      R = llvm.make_unique(new BugReport(BT.$star(), str, N));
      if ((ex != null)) {
        R.$arrow().addRange(ex.getSourceRange());
        NsBugreporter.trackNullOrUndefValue(N, ex, R.$star());
      }
      C.emitReport($c$.track(new std.unique_ptr<BugReport>(JD$Move.INSTANCE, std.move(R)))); $c$.clean();
    } finally {
      if (R != null) { R.$destroy(); }
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UndefinedAssignmentChecker::~UndefinedAssignmentChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/UndefinedAssignmentChecker.cpp", line = 25,
   FQN="(anonymous namespace)::UndefinedAssignmentChecker::~UndefinedAssignmentChecker", NM="_ZN12_GLOBAL__N_126UndefinedAssignmentCheckerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/UndefinedAssignmentChecker.cpp -nm=_ZN12_GLOBAL__N_126UndefinedAssignmentCheckerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    BT.$destroy();
    super.$destroy();
    //END JDestroy
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UndefinedAssignmentChecker::UndefinedAssignmentChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/UndefinedAssignmentChecker.cpp", line = 25,
   FQN="(anonymous namespace)::UndefinedAssignmentChecker::UndefinedAssignmentChecker", NM="_ZN12_GLOBAL__N_126UndefinedAssignmentCheckerC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/UndefinedAssignmentChecker.cpp -nm=_ZN12_GLOBAL__N_126UndefinedAssignmentCheckerC1Ev")
  //</editor-fold>
  public /*inline*/ UndefinedAssignmentChecker() {
    // : Checker<Bind>(), BT() 
    //START JInit
    super();
    this.BT = new std.unique_ptr<BugType>();
    //END JInit
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  private final CheckBase $CHECKS[] = {
    new Bind()
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
