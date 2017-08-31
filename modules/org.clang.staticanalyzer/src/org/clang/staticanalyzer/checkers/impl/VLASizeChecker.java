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
import org.clang.analysis.*;
import org.clang.staticanalyzer.core.bugreporter.ento.*;
import org.clang.staticanalyzer.core.ento.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import org.clang.staticanalyzer.java.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VLASizeChecker">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/VLASizeChecker.cpp", line = 31,
 FQN="(anonymous namespace)::VLASizeChecker", NM="_ZN12_GLOBAL__N_114VLASizeCheckerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/VLASizeChecker.cpp -nm=_ZN12_GLOBAL__N_114VLASizeCheckerE")
//</editor-fold>
public class VLASizeChecker extends /*public*/ Checker/*T<PreStmt<DeclStmt> > */
        implements org.clang.staticanalyzer.java.PreStmtChecker, Destructors.ClassWithDestructor {
  private /*mutable */std.unique_ptr<BugType> BT;
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VLASizeChecker::VLASize_Kind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/VLASizeChecker.cpp", line = 33,
   FQN="(anonymous namespace)::VLASizeChecker::VLASize_Kind", NM="_ZN12_GLOBAL__N_114VLASizeChecker12VLASize_KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/VLASizeChecker.cpp -nm=_ZN12_GLOBAL__N_114VLASizeChecker12VLASize_KindE")
  //</editor-fold>
  private enum VLASize_Kind implements Native.NativeUIntEnum {
    VLA_Garbage(0),
    VLA_Zero(VLA_Garbage.getValue() + 1),
    VLA_Tainted(VLA_Zero.getValue() + 1),
    VLA_Negative(VLA_Tainted.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static VLASize_Kind valueOf(int val) {
      VLASize_Kind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final VLASize_Kind[] VALUES;
      private static final VLASize_Kind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (VLASize_Kind kind : VLASize_Kind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new VLASize_Kind[min < 0 ? (1-min) : 0];
        VALUES = new VLASize_Kind[max >= 0 ? (1+max) : 0];
        for (VLASize_Kind kind : VLASize_Kind.values()) {
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
    private VLASize_Kind(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
  
  // end anonymous namespace
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VLASizeChecker::reportBug">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/VLASizeChecker.cpp", line = 44,
   FQN="(anonymous namespace)::VLASizeChecker::reportBug", NM="_ZNK12_GLOBAL__N_114VLASizeChecker9reportBugENS0_12VLASize_KindEPKN5clang4ExprEN4llvm18IntrusiveRefCntPtrIKNS2_4ento12ProgramStateEEERNS8_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/VLASizeChecker.cpp -nm=_ZNK12_GLOBAL__N_114VLASizeChecker9reportBugENS0_12VLASize_KindEPKN5clang4ExprEN4llvm18IntrusiveRefCntPtrIKNS2_4ento12ProgramStateEEERNS8_14CheckerContextE")
  //</editor-fold>
  private void reportBug(VLASize_Kind Kind, 
           /*const*/ Expr /*P*/ SizeE, 
           IntrusiveRefCntPtr</*const*/ ProgramState> State, 
           final CheckerContext /*&*/ C) /*const*/ {
    raw_svector_ostream os = null;
    unique_ptr<BugReport> report = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // Generate an error node.
      ExplodedNode /*P*/ N = $c$.clean(C.generateErrorNode($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))));
      if (!(N != null)) {
        return;
      }
      if (!BT.$bool()) {
        BT.reset(new BuiltinBug(this, $("Dangerous variable-length array (VLA) declaration")));
      }
      
      SmallString/*<256>*/ buf/*J*/= new SmallString/*<256>*/(256);
      os/*J*/= new raw_svector_ostream(buf);
      os.$out(/*KEEP_STR*/"Declared variable-length array (VLA) ");
      switch (Kind) {
       case VLA_Garbage:
        os.$out(/*KEEP_STR*/"uses a garbage value as its size");
        break;
       case VLA_Zero:
        os.$out(/*KEEP_STR*/"has zero size");
        break;
       case VLA_Tainted:
        os.$out(/*KEEP_STR*/"has tainted size");
        break;
       case VLA_Negative:
        os.$out(/*KEEP_STR*/"has negative size");
        break;
      }
      
      report = llvm.make_unique(new BugReport(BT.$star(), os.str(), N));
      report.$arrow().addRange(SizeE.getSourceRange());
      NsBugreporter.trackNullOrUndefValue(N, SizeE, report.$star());
      C.emitReport($c$.track(new std.unique_ptr<BugReport>(JD$Move.INSTANCE, std.move(report)))); $c$.clean();
    } finally {
      if (report != null) { report.$destroy(); }
      if (os != null) { os.$destroy(); }
      $c$.$destroy();
    }
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VLASizeChecker::checkPreStmt">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/VLASizeChecker.cpp", line = 81,
   FQN="(anonymous namespace)::VLASizeChecker::checkPreStmt", NM="_ZNK12_GLOBAL__N_114VLASizeChecker12checkPreStmtEPKN5clang8DeclStmtERNS1_4ento14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/VLASizeChecker.cpp -nm=_ZNK12_GLOBAL__N_114VLASizeChecker12checkPreStmtEPKN5clang8DeclStmtERNS1_4ento14CheckerContextE")
  //</editor-fold>
  public void checkPreStmt(/*const*/ DeclStmt /*P*/ DS, final CheckerContext /*&*/ C) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> state = null;
    IntrusiveRefCntPtr</*const*/ ProgramState> stateNotZero = null;
    IntrusiveRefCntPtr</*const*/ ProgramState> stateZero = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      if (!DS.isSingleDecl()) {
        return;
      }
      
      /*const*/ VarDecl /*P*/ VD = dyn_cast_VarDecl(DS.getSingleDecl$Const());
      if (!(VD != null)) {
        return;
      }
      
      final ASTContext /*&*/ Ctx = C.getASTContext();
      /*const*/ VariableArrayType /*P*/ VLA = Ctx.getAsVariableArrayType(VD.getType());
      if (!(VLA != null)) {
        return;
      }
      
      // FIXME: Handle multi-dimensional VLAs.
      /*const*/ Expr /*P*/ SE = VLA.getSizeExpr();
      state = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
      SVal sizeV = state.$arrow().getSVal(SE, C.getLocationContext());
      if (sizeV.isUndef$SVal()) {
        reportBug(VLASize_Kind.VLA_Garbage, SE, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), C); $c$.clean();
        return;
      }
      
      // See if the size value is known. It can't be undefined because we would have
      // warned about that already.
      if (sizeV.isUnknown$SVal()) {
        return;
      }
      
      // Check if the size is tainted.
      if (state.$arrow().isTainted(new SVal(sizeV))) {
        reportBug(VLASize_Kind.VLA_Tainted, SE, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>((/*const*/ ProgramState /*P*/ )null)), C); $c$.clean();
        return;
      }
      
      // Check if the size is zero.
      DefinedSVal sizeD = sizeV.castAs(DefinedSVal.class);
      
      stateNotZero/*J*/= new IntrusiveRefCntPtr</*const*/ ProgramState>();
      stateZero/*J*/= new IntrusiveRefCntPtr</*const*/ ProgramState>();
//      $c$.clean(std.tie(stateNotZero, stateZero).$assign($c$.track(state.$arrow().assume(new DefinedOrUnknownSVal(sizeD)))));
      // JAVA: when unfold tie make sure returned pair is cleaned (in this case ProgramState was moved to other instances)
      std.pairTypeType<IntrusiveRefCntPtr</*const*/ ProgramState>, IntrusiveRefCntPtr</*const*/ ProgramState>> $assume = 
              $c$.track(state.$arrow().assume(new DefinedOrUnknownSVal(sizeD)));
      stateNotZero.$assign($assume.first);
      stateZero.$assign($assume.second);
      assert !$assume.first.$bool();
      assert !$assume.second.$bool();
      $c$.clean();
      
      if (stateZero.$bool() && !stateNotZero.$bool()) {
        reportBug(VLASize_Kind.VLA_Zero, SE, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(stateZero)), C); $c$.clean();
        return;
      }
      
      // From this point on, assume that the size is not zero.
      $c$.clean(state.$assign($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(stateNotZero))));
      
      // VLASizeChecker is responsible for defining the extent of the array being
      // declared. We do this by multiplying the array length by the element size,
      // then matching that with the array region's extent symbol.
      
      // Check if the size is negative.
      final SValBuilder /*&*/ svalBuilder = C.getSValBuilder();
      
      QualType Ty = SE.getType();
      DefinedOrUnknownSVal Zero = svalBuilder.makeZeroVal(new QualType(Ty));
      
      SVal LessThanZeroVal = $c$.clean(svalBuilder.evalBinOp($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), BinaryOperatorKind.BO_LT, new SVal(sizeD), new SVal(Zero), new QualType(Ty)));
      {
        Optional<DefinedSVal> LessThanZeroDVal = LessThanZeroVal.getAs(DefinedSVal.class);
        if (LessThanZeroDVal.$bool()) {
          IntrusiveRefCntPtr</*const*/ ProgramState> StatePos = null;
          IntrusiveRefCntPtr</*const*/ ProgramState> StateNeg = null;
          try {
            final ConstraintManager /*&*/ CM = C.getConstraintManager();
            StatePos/*J*/= new IntrusiveRefCntPtr</*const*/ ProgramState>();
            StateNeg/*J*/= new IntrusiveRefCntPtr</*const*/ ProgramState>();
            
//            $c$.clean(std.tie(StateNeg, StatePos).$assign($c$.track(CM.assumeDual($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), new DefinedSVal(LessThanZeroDVal.$star())))));
            // JAVA: when unfold tie make sure returned pair is cleaned (in this case ProgramState was moved to other instances)
            std.pairTypeType<IntrusiveRefCntPtr</*const*/ ProgramState>, IntrusiveRefCntPtr</*const*/ ProgramState>> $assumeDual = 
                    $c$.track(CM.assumeDual($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), new DefinedSVal(LessThanZeroDVal.$star())));
            StateNeg.$assign($assumeDual.first);
            StatePos.$assign($assumeDual.second);
            assert !$assumeDual.first.$bool();
            assert !$assumeDual.second.$bool();
            $c$.clean();
      
            if (StateNeg.$bool() && !StatePos.$bool()) {
              reportBug(VLASize_Kind.VLA_Negative, SE, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), C); $c$.clean();
              return;
            }
            $c$.clean(state.$assign($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(StatePos))));
          } finally {
            if (StateNeg != null) { StateNeg.$destroy(); }
            if (StatePos != null) { StatePos.$destroy(); }
          }
        }
      }
      
      // Convert the array length to size_t.
      QualType SizeTy = Ctx.getSizeType().$QualType();
      NonLoc ArrayLength = svalBuilder.evalCast(new SVal(sizeD), new QualType(SizeTy), SE.getType()).castAs(NonLoc.class);
      
      // Get the element size.
      CharUnits EleSize = Ctx.getTypeSizeInChars(VLA.getElementType());
      SVal EleSizeVal = new SVal(JD$Move.INSTANCE, svalBuilder.makeIntVal(EleSize.getQuantity(), new QualType(SizeTy)));
      
      // Multiply the array length by the element size.
      SVal ArraySizeVal = $c$.clean(svalBuilder.evalBinOpNN($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), BinaryOperatorKind.BO_Mul, new NonLoc(ArrayLength), EleSizeVal.castAs(NonLoc.class), new QualType(SizeTy)));
      
      // Finally, assume that the array's extent matches the given size.
      /*const*/ LocationContext /*P*/ LC = C.getLocationContext();
      DefinedOrUnknownSVal Extent = state.$arrow().getRegion(VD, LC).getExtent(svalBuilder);
      DefinedOrUnknownSVal ArraySize = ArraySizeVal.castAs(DefinedOrUnknownSVal.class);
      DefinedOrUnknownSVal sizeIsKnown = $c$.clean(svalBuilder.evalEQ($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), new DefinedOrUnknownSVal(Extent), new DefinedOrUnknownSVal(ArraySize)));
      $c$.clean(state.$assign($c$.track(state.$arrow().assume(new DefinedOrUnknownSVal(sizeIsKnown), true))));
      
      // Assume should not fail at this point.
      assert ((state).$bool());
      
      // Remember our assumptions!
      $c$.clean(C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state))));
    } finally {
      if (stateZero != null) { stateZero.$destroy(); }
      if (stateNotZero != null) { stateNotZero.$destroy(); }
      if (state != null) { state.$destroy(); }
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VLASizeChecker::~VLASizeChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/VLASizeChecker.cpp", line = 31,
   FQN="(anonymous namespace)::VLASizeChecker::~VLASizeChecker", NM="_ZN12_GLOBAL__N_114VLASizeCheckerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/VLASizeChecker.cpp -nm=_ZN12_GLOBAL__N_114VLASizeCheckerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    BT.$destroy();
    super.$destroy();
    //END JDestroy
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VLASizeChecker::VLASizeChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/VLASizeChecker.cpp", line = 31,
   FQN="(anonymous namespace)::VLASizeChecker::VLASizeChecker", NM="_ZN12_GLOBAL__N_114VLASizeCheckerC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/VLASizeChecker.cpp -nm=_ZN12_GLOBAL__N_114VLASizeCheckerC1Ev")
  //</editor-fold>
  public /*inline*/ VLASizeChecker() {
    // : Checker<PreStmt<DeclStmt> >(), BT() 
    //START JInit
    super();
    this.BT = new std.unique_ptr<BugType>();
    //END JInit
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override
  public void $checkPreStmt(Stmt stmt, CheckerContext C) {
    if (stmt instanceof DeclStmt) {
      checkPreStmt((DeclStmt) stmt, C);
    }
  }

  private final CheckBase $CHECKS[] = {
    new org.clang.staticanalyzer.core.ento.check.PreStmt<DeclStmt>(DeclStmt.class)
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
