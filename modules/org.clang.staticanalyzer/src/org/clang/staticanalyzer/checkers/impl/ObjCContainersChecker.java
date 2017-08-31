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
import org.clang.staticanalyzer.checkers.ento.impl.*;
import org.clang.staticanalyzer.core.bugreporter.ento.*;
import org.clang.staticanalyzer.core.ento.*;
import org.clang.staticanalyzer.core.ento.check.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import org.clang.staticanalyzer.java.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCContainersChecker">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCContainersChecker.cpp", line = 31,
 FQN="(anonymous namespace)::ObjCContainersChecker", NM="_ZN12_GLOBAL__N_121ObjCContainersCheckerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCContainersChecker.cpp -nm=_ZN12_GLOBAL__N_121ObjCContainersCheckerE")
//</editor-fold>
public class ObjCContainersChecker extends /*public*/ Checker/*<org.clang.staticanalyzer.core.ento.check.PreStmt<CallExpr>, org.clang.staticanalyzer.core.ento.check.PostStmt<CallExpr>, PointerEscape>*/ 
        implements org.clang.staticanalyzer.java.PreStmtChecker, org.clang.staticanalyzer.java.PostStmtChecker, org.clang.staticanalyzer.java.PointerEscapeChecker, Destructors.ClassWithDestructor {
  private /*mutable */std.unique_ptr<BugType> BT;
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCContainersChecker::initBugType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCContainersChecker.cpp", line = 35,
   FQN="(anonymous namespace)::ObjCContainersChecker::initBugType", NM="_ZNK12_GLOBAL__N_121ObjCContainersChecker11initBugTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCContainersChecker.cpp -nm=_ZNK12_GLOBAL__N_121ObjCContainersChecker11initBugTypeEv")
  //</editor-fold>
  private /*inline*/ void initBugType() /*const*/ {
    if (!BT.$bool()) {
      BT.reset(new BugType(this, new StringRef(/*KEEP_STR*/"CFArray API"), 
              new StringRef(categories.CoreFoundationObjectiveC)));
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCContainersChecker::getArraySym">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCContainersChecker.cpp", line = 41,
   FQN="(anonymous namespace)::ObjCContainersChecker::getArraySym", NM="_ZNK12_GLOBAL__N_121ObjCContainersChecker11getArraySymEPKN5clang4ExprERNS1_4ento14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCContainersChecker.cpp -nm=_ZNK12_GLOBAL__N_121ObjCContainersChecker11getArraySymEPKN5clang4ExprERNS1_4ento14CheckerContextE")
  //</editor-fold>
  private /*inline*/ /*const*/ SymExpr /*P*/ getArraySym(/*const*/ Expr /*P*/ E, final CheckerContext /*&*/ C) /*const*/ {
    SVal ArrayRef = C.getState().$arrow().getSVal(E, C.getLocationContext());
    /*const*/ SymExpr /*P*/ ArraySym = ArrayRef.getAsSymbol();
    return ArraySym;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCContainersChecker::addSizeInfo">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCContainersChecker.cpp", line = 66,
   FQN="(anonymous namespace)::ObjCContainersChecker::addSizeInfo", NM="_ZNK12_GLOBAL__N_121ObjCContainersChecker11addSizeInfoEPKN5clang4ExprES4_RNS1_4ento14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCContainersChecker.cpp -nm=_ZNK12_GLOBAL__N_121ObjCContainersChecker11addSizeInfoEPKN5clang4ExprES4_RNS1_4ento14CheckerContextE")
  //</editor-fold>
  private void addSizeInfo(/*const*/ Expr /*P*/ Array, /*const*/ Expr /*P*/ Size, 
             final CheckerContext /*&*/ C) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> State = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      State = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
      SVal SizeV = State.$arrow().getSVal(Size, C.getLocationContext());
      // Undefined is reported by another checker.
      if (SizeV.isUnknownOrUndef$SVal()) {
        return;
      }
      
      // Get the ArrayRef symbol.
      SVal ArrayRef = State.$arrow().getSVal(Array, C.getLocationContext());
      /*const*/ SymExpr /*P*/ ArraySym = ArrayRef.getAsSymbol();
      if (!(ArraySym != null)) {
        return;
      }
      
      $c$.clean(C.addTransition($c$.track(State.$arrow().set(ProgramStateTraitArraySizeMap.$Instance, ArraySym, SizeV.castAs(DefinedSVal.class)))));
    } finally {
      if (State != null) { State.$destroy(); }
      $c$.$destroy();
    }
  }

/*public:*/
  /// A tag to id this checker.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCContainersChecker::getTag">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCContainersChecker.cpp", line = 52,
   FQN="(anonymous namespace)::ObjCContainersChecker::getTag", NM="_ZN12_GLOBAL__N_121ObjCContainersChecker6getTagEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCContainersChecker.cpp -nm=_ZN12_GLOBAL__N_121ObjCContainersChecker6getTagEv")
  //</editor-fold>
  public static Object/*void P*/ getTag() {
    final/*static*/ Object Tag = getTag$$.Tag;
    return $AddrOf(Tag);
  }
  private static final class getTag$$ {
    static final/*static*/ Object Tag = ObjCContainersChecker.class;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCContainersChecker::checkPostStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCContainersChecker.cpp", line = 84,
   FQN="(anonymous namespace)::ObjCContainersChecker::checkPostStmt", NM="_ZNK12_GLOBAL__N_121ObjCContainersChecker13checkPostStmtEPKN5clang8CallExprERNS1_4ento14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCContainersChecker.cpp -nm=_ZNK12_GLOBAL__N_121ObjCContainersChecker13checkPostStmtEPKN5clang8CallExprERNS1_4ento14CheckerContextE")
  //</editor-fold>
  public void checkPostStmt(/*const*/ CallExpr /*P*/ CE, 
               final CheckerContext /*&*/ C) /*const*/ {
    StringRef Name = C.getCalleeName(CE);
    if (Name.empty() || $less_uint(CE.getNumArgs(), 1)) {
      return;
    }
    
    // Add array size information to the state.
    if (Name.equals(/*STRINGREF_STR*/"CFArrayCreate")) {
      if ($less_uint(CE.getNumArgs(), 3)) {
        return;
      }
      // Note, we can visit the Create method in the post-visit because
      // the CFIndex parameter is passed in by value and will not be invalidated
      // by the call.
      addSizeInfo(CE, CE.getArg$Const(2), C);
      return;
    }
    if (Name.equals(/*STRINGREF_STR*/"CFArrayGetCount")) {
      addSizeInfo(CE.getArg$Const(0), CE, C);
      return;
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCContainersChecker::checkPreStmt">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCContainersChecker.cpp", line = 107,
   FQN="(anonymous namespace)::ObjCContainersChecker::checkPreStmt", NM="_ZNK12_GLOBAL__N_121ObjCContainersChecker12checkPreStmtEPKN5clang8CallExprERNS1_4ento14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCContainersChecker.cpp -nm=_ZNK12_GLOBAL__N_121ObjCContainersChecker12checkPreStmtEPKN5clang8CallExprERNS1_4ento14CheckerContextE")
  //</editor-fold>
  public void checkPreStmt(/*const*/ CallExpr /*P*/ CE, 
              final CheckerContext /*&*/ C) /*const*/ {
    StringRef Name = C.getCalleeName(CE);
    if (Name.empty() || $less_uint(CE.getNumArgs(), 2)) {
      return;
    }
    
    // Check the array access.
    if (Name.equals(/*STRINGREF_STR*/"CFArrayGetValueAtIndex")) {
      IntrusiveRefCntPtr</*const*/ ProgramState> State = null;
      IntrusiveRefCntPtr</*const*/ ProgramState> StInBound = null;
      IntrusiveRefCntPtr</*const*/ ProgramState> StOutBound = null;
      try {
        State = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
        // Retrieve the size.
        // Find out if we saw this array symbol before and have information about
        // it.
        /*const*/ Expr /*P*/ ArrayExpr = CE.getArg$Const(0);
        /*const*/ SymExpr /*P*/ ArraySym = getArraySym(ArrayExpr, C);
        if (!(ArraySym != null)) {
          return;
        }
        
        /*const*/ DefinedSVal /*P*/ Size = State.$arrow().get(ProgramStateTraitArraySizeMap.$Instance, ArraySym);
        if (!(Size != null)) {
          return;
        }
        
        // Get the index.
        /*const*/ Expr /*P*/ IdxExpr = CE.getArg$Const(1);
        SVal IdxVal = State.$arrow().getSVal(IdxExpr, C.getLocationContext());
        if (IdxVal.isUnknownOrUndef$SVal()) {
          return;
        }
        DefinedSVal Idx = IdxVal.castAs(DefinedSVal.class);
        
        // Now, check if 'Idx in [0, Size-1]'.
        /*const*/ QualType T = IdxExpr.getType();
        StInBound = State.$arrow().assumeInBound(new DefinedOrUnknownSVal(Idx), new DefinedOrUnknownSVal($Deref(Size)), true, new QualType(T));
        StOutBound = State.$arrow().assumeInBound(new DefinedOrUnknownSVal(Idx), new DefinedOrUnknownSVal($Deref(Size)), false, new QualType(T));
        if (StOutBound.$bool() && !StInBound.$bool()) {
          unique_ptr<BugReport> R = null;
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            ExplodedNode /*P*/ N = $c$.clean(C.generateErrorNode($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(StOutBound))));
            if (!(N != null)) {
              return;
            }
            initBugType();
            R = llvm.make_unique(new BugReport(BT.$star(), $("Index is out of bounds"), N));
            R.$arrow().addRange(IdxExpr.getSourceRange());
            C.emitReport($c$.track(new std.unique_ptr<BugReport>(JD$Move.INSTANCE, std.move(R)))); $c$.clean();
            return;
          } finally {
            if (R != null) { R.$destroy(); }
            $c$.$destroy();
          }
        }
      } finally {
        if (StOutBound != null) { StOutBound.$destroy(); }
        if (StInBound != null) { StInBound.$destroy(); }
        if (State != null) { State.$destroy(); }
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCContainersChecker::checkPointerEscape">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCContainersChecker.cpp", line = 153,
   FQN="(anonymous namespace)::ObjCContainersChecker::checkPointerEscape", NM="_ZNK12_GLOBAL__N_121ObjCContainersChecker18checkPointerEscapeEN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEERKNS1_8DenseSetIPKNS4_7SymExprENS1_12DenseMapInfoISB_EEEEPKNS4_9CallEventENS4_17PointerEscapeKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCContainersChecker.cpp -nm=_ZNK12_GLOBAL__N_121ObjCContainersChecker18checkPointerEscapeEN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEERKNS1_8DenseSetIPKNS4_7SymExprENS1_12DenseMapInfoISB_EEEEPKNS4_9CallEventENS4_17PointerEscapeKindE")
  //</editor-fold>
  public IntrusiveRefCntPtr</*const*/ ProgramState> checkPointerEscape(IntrusiveRefCntPtr</*const*/ ProgramState> State, 
                    final /*const*/DenseSet</*const*/ SymExpr /*P*/ > /*&*/ Escaped, 
                    /*const*/ CallEvent /*P*/ Call, 
                    PointerEscapeKind Kind) /*const*/ {
    for (final /*const*/ SymExpr /*P*/ /*const*/ /*&*/ Sym : Escaped) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // When a symbol for a mutable array escapes, we can't reason precisely
        // about its size any more -- so remove it from the map.
        // Note that we aren't notified here when a CFMutableArrayRef escapes as a
        // CFArrayRef. This is because CFArrayRef is typedef'd as a pointer to a
        // const-qualified type.
        $c$.clean(State.$assign($c$.track(State.$arrow().remove(ProgramStateTraitArraySizeMap.$Instance, Sym))));
      } finally {
        $c$.$destroy();
      }
    }
    return new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, State);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCContainersChecker::~ObjCContainersChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCContainersChecker.cpp", line = 31,
   FQN="(anonymous namespace)::ObjCContainersChecker::~ObjCContainersChecker", NM="_ZN12_GLOBAL__N_121ObjCContainersCheckerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCContainersChecker.cpp -nm=_ZN12_GLOBAL__N_121ObjCContainersCheckerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    BT.$destroy();
    super.$destroy();
    //END JDestroy
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCContainersChecker::ObjCContainersChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCContainersChecker.cpp", line = 31,
   FQN="(anonymous namespace)::ObjCContainersChecker::ObjCContainersChecker", NM="_ZN12_GLOBAL__N_121ObjCContainersCheckerC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCContainersChecker.cpp -nm=_ZN12_GLOBAL__N_121ObjCContainersCheckerC1Ev")
  //</editor-fold>
  public /*inline*/ ObjCContainersChecker() {
    // : Checker<PreStmt<CallExpr>, PostStmt<CallExpr>, PointerEscape>(), BT() 
    //START JInit
    super();
    this.BT = new std.unique_ptr<BugType>();
    //END JInit
   }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override
  public void $checkPreStmt(Stmt stmt, CheckerContext C) {
    if (stmt instanceof CallExpr) {
      checkPreStmt((CallExpr) stmt, C);
    }
  }

  @Override
  public void $checkPostStmt(Stmt stmt, CheckerContext C) {
    if (stmt instanceof CallExpr) {
      checkPostStmt((CallExpr) stmt, C);
    }
  }

  private final CheckBase $CHECKS[] = {
    new org.clang.staticanalyzer.core.ento.check.PreStmt<CallExpr>(CallExpr.class),
    new org.clang.staticanalyzer.core.ento.check.PostStmt<CallExpr>(CallExpr.class),
    new PointerEscape()
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
