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
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import org.clang.analysis.*;
import org.clang.analysis.impl.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.analysis.impl.UninitializedValuesStatics.*;
import org.clang.ast.java.AstFunctionPointers;
import static org.clang.ast.java.AstDeclarationsRTTI.*;


/// \brief Classify each DeclRefExpr as an initialization or a use. Any
/// DeclRefExpr which isn't explicitly classified will be assumed to have
/// escaped the analysis and will be treated as an initialization.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ClassifyRefs">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp", line = 305,
 FQN="(anonymous namespace)::ClassifyRefs", NM="_ZN12_GLOBAL__N_112ClassifyRefsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp -nm=_ZN12_GLOBAL__N_112ClassifyRefsE")
//</editor-fold>
public class ClassifyRefs implements /*public*/ StmtVisitorVoid<ClassifyRefs>, AstFunctionPointers.Stmt2Void, Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ClassifyRefs::Class">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp", line = 307,
   FQN="(anonymous namespace)::ClassifyRefs::Class", NM="_ZN12_GLOBAL__N_112ClassifyRefs5ClassE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp -nm=_ZN12_GLOBAL__N_112ClassifyRefs5ClassE")
  //</editor-fold>
  public enum Class implements Native.ComparableLower {
    Init(0),
    Use(Init.getValue() + 1),
    SelfInit(Use.getValue() + 1),
    Ignore(SelfInit.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static Class valueOf(int val) {
      Class out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final Class[] VALUES;
      private static final Class[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (Class kind : Class.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new Class[min < 0 ? (1-min) : 0];
        VALUES = new Class[max >= 0 ? (1+max) : 0];
        for (Class kind : Class.values()) {
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
    private Class(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((Class)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((Class)obj).value);}
    //</editor-fold>
  };
/*private:*/
  private /*const*/ DeclContext /*P*/ DC;
  private DenseMap</*const*/ DeclRefExpr /*P*/ , Class> Classification;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ClassifyRefs::isTrackedVar">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp", line = 318,
   FQN="(anonymous namespace)::ClassifyRefs::isTrackedVar", NM="_ZNK12_GLOBAL__N_112ClassifyRefs12isTrackedVarEPKN5clang7VarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp -nm=_ZNK12_GLOBAL__N_112ClassifyRefs12isTrackedVarEPKN5clang7VarDeclE")
  //</editor-fold>
  private boolean isTrackedVar(/*const*/ VarDecl /*P*/ VD) /*const*/ {
    return /*::*/UninitializedValuesStatics.isTrackedVar(VD, DC);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ClassifyRefs::classify">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp", line = 361,
   FQN="(anonymous namespace)::ClassifyRefs::classify", NM="_ZN12_GLOBAL__N_112ClassifyRefs8classifyEPKN5clang4ExprENS0_5ClassE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp -nm=_ZN12_GLOBAL__N_112ClassifyRefs8classifyEPKN5clang4ExprENS0_5ClassE")
  //</editor-fold>
  private void classify(/*const*/ Expr /*P*/ E, Class C) {
    // The result of a ?: could also be an lvalue.
    E = E.IgnoreParens$Const();
    {
      /*const*/ ConditionalOperator /*P*/ CO = dyn_cast_ConditionalOperator(E);
      if ((CO != null)) {
        classify(CO.getTrueExpr(), C);
        classify(CO.getFalseExpr(), C);
        return;
      }
    }
    {
      
      /*const*/ BinaryConditionalOperator /*P*/ BCO = dyn_cast_BinaryConditionalOperator(E);
      if ((BCO != null)) {
        classify(BCO.getFalseExpr(), C);
        return;
      }
    }
    {
      
      /*const*/ OpaqueValueExpr /*P*/ OVE = dyn_cast_OpaqueValueExpr(E);
      if ((OVE != null)) {
        classify(OVE.getSourceExpr(), C);
        return;
      }
    }
    {
      
      /*const*/ MemberExpr /*P*/ ME = dyn_cast_MemberExpr(E);
      if ((ME != null)) {
        {
          VarDecl /*P*/ VD = dyn_cast_VarDecl(ME.getMemberDecl());
          if ((VD != null)) {
            if (!VD.isStaticDataMember()) {
              classify(ME.getBase(), C);
            }
          }
        }
        return;
      }
    }
    {
      
      /*const*/ BinaryOperator /*P*/ BO = dyn_cast_BinaryOperator(E);
      if ((BO != null)) {
        switch (BO.getOpcode()) {
         case BO_PtrMemD:
         case BO_PtrMemI:
          classify(BO.getLHS(), C);
          return;
         case BO_Comma:
          classify(BO.getRHS(), C);
          return;
         default:
          return;
        }
      }
    }
    
    FindVarResult Var = findVar(E, DC);
    {
      /*const*/ DeclRefExpr /*P*/ DRE = Var.getDeclRefExpr();
      if ((DRE != null)) {
        Classification.$set(DRE, std.max(Classification.$at_T1$C$R(DRE), C));
      }
    }
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ClassifyRefs::ClassifyRefs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp", line = 325,
   FQN="(anonymous namespace)::ClassifyRefs::ClassifyRefs", NM="_ZN12_GLOBAL__N_112ClassifyRefsC1ERN5clang19AnalysisDeclContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp -nm=_ZN12_GLOBAL__N_112ClassifyRefsC1ERN5clang19AnalysisDeclContextE")
  //</editor-fold>
  public ClassifyRefs(final AnalysisDeclContext /*&*/ AC) {
    // : StmtVisitor<ClassifyRefs>(), DC(cast<DeclContext>(AC.getDecl())), Classification() 
    //START JInit
    $StmtVisitor();
    this.DC = cast_DeclContext(AC.getDecl());
    this.Classification = new DenseMap</*const*/ DeclRefExpr /*P*/ , Class>(DenseMapInfo$LikePtr.$Info(), Class.valueOf(0));
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ClassifyRefs::VisitDeclStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp", line = 408,
   FQN="(anonymous namespace)::ClassifyRefs::VisitDeclStmt", NM="_ZN12_GLOBAL__N_112ClassifyRefs13VisitDeclStmtEPN5clang8DeclStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp -nm=_ZN12_GLOBAL__N_112ClassifyRefs13VisitDeclStmtEPN5clang8DeclStmtE")
  //</editor-fold>
  public void VisitDeclStmt(DeclStmt /*P*/ DS) {
    for (Decl /*P*/ DI : DS.decls()) {
      VarDecl /*P*/ VD = dyn_cast_VarDecl(DI);
      if ((VD != null) && isTrackedVar(VD)) {
        {
          /*const*/ DeclRefExpr /*P*/ DRE = getSelfInitExpr(VD);
          if ((DRE != null)) {
            Classification.$set(DRE, Class.SelfInit);
          }
        }
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ClassifyRefs::VisitUnaryOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp", line = 429,
   FQN="(anonymous namespace)::ClassifyRefs::VisitUnaryOperator", NM="_ZN12_GLOBAL__N_112ClassifyRefs18VisitUnaryOperatorEPN5clang13UnaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp -nm=_ZN12_GLOBAL__N_112ClassifyRefs18VisitUnaryOperatorEPN5clang13UnaryOperatorE")
  //</editor-fold>
  public void VisitUnaryOperator(UnaryOperator /*P*/ UO) {
    // Increment and decrement are uses despite there being no lvalue-to-rvalue
    // conversion.
    if (UO.isIncrementDecrementOp()) {
      classify(UO.getSubExpr(), Class.Use);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ClassifyRefs::VisitBinaryOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp", line = 417,
   FQN="(anonymous namespace)::ClassifyRefs::VisitBinaryOperator", NM="_ZN12_GLOBAL__N_112ClassifyRefs19VisitBinaryOperatorEPN5clang14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp -nm=_ZN12_GLOBAL__N_112ClassifyRefs19VisitBinaryOperatorEPN5clang14BinaryOperatorE")
  //</editor-fold>
  public void VisitBinaryOperator(BinaryOperator /*P*/ BO) {
    // Ignore the evaluation of a DeclRefExpr on the LHS of an assignment. If this
    // is not a compound-assignment, we will treat it as initializing the variable
    // when TransferFunctions visits it. A compound-assignment does not affect
    // whether a variable is uninitialized, and there's no point counting it as a
    // use.
    if (BO.isCompoundAssignmentOp()) {
      classify(BO.getLHS(), Class.Use);
    } else if (BO.getOpcode() == BinaryOperatorKind.BO_Assign || BO.getOpcode() == BinaryOperatorKind.BO_Comma) {
      classify(BO.getLHS(), Class.Ignore);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ClassifyRefs::VisitCallExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp", line = 440,
   FQN="(anonymous namespace)::ClassifyRefs::VisitCallExpr", NM="_ZN12_GLOBAL__N_112ClassifyRefs13VisitCallExprEPN5clang8CallExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp -nm=_ZN12_GLOBAL__N_112ClassifyRefs13VisitCallExprEPN5clang8CallExprE")
  //</editor-fold>
  public void VisitCallExpr(CallExpr /*P*/ CE) {
    // Classify arguments to std::move as used.
    if (CE.getNumArgs() == 1) {
      {
        FunctionDecl /*P*/ FD = CE.getDirectCallee();
        if ((FD != null)) {
          if (FD.isInStdNamespace() && (FD.getIdentifier() != null)
             && FD.getIdentifier().isStr(/*KEEP_STR*/"move")) {
            // RecordTypes are handled in SemaDeclCXX.cpp.
            if (!CE.getArg(0).getType().$arrow().isRecordType()) {
              classify(CE.getArg(0), Class.Use);
            }
            return;
          }
        }
      }
    }
    
    // If a value is passed by const pointer or by const reference to a function,
    // we should not assume that it is initialized by the call, and we
    // conservatively do not assume that it is used.
    for (Stmt.ExprIterator I = CE.arg_begin(), E = CE.arg_end();
         I.$noteq(E); I.$preInc()) {
      if ((I.$star()).isGLValue()) {
        if ((I.$star()).getType().isConstQualified()) {
          classify((I.$star()), Class.Ignore);
        }
      } else if (isPointerToConst((I.$star()).getType())) {
        /*const*/ Expr /*P*/ Ex = stripCasts(DC.getParentASTContext(), I.$star());
        /*const*/ UnaryOperator /*P*/ UO = dyn_cast_UnaryOperator(Ex);
        if ((UO != null) && UO.getOpcode() == UnaryOperatorKind.UO_AddrOf) {
          Ex = UO.getSubExpr();
        }
        classify(Ex, Class.Ignore);
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ClassifyRefs::VisitCastExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp", line = 472,
   FQN="(anonymous namespace)::ClassifyRefs::VisitCastExpr", NM="_ZN12_GLOBAL__N_112ClassifyRefs13VisitCastExprEPN5clang8CastExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp -nm=_ZN12_GLOBAL__N_112ClassifyRefs13VisitCastExprEPN5clang8CastExprE")
  //</editor-fold>
  public void VisitCastExpr(CastExpr /*P*/ CE) {
    if (CE.getCastKind() == CastKind.CK_LValueToRValue) {
      classify(CE.getSubExpr(), Class.Use);
    } else {
      CStyleCastExpr /*P*/ CSE = dyn_cast_CStyleCastExpr(CE);
      if ((CSE != null)) {
        if (CSE.getType().$arrow().isVoidType()) {
          // Squelch any detected load of an uninitialized value if
          // we cast it to void.
          // e.g. (void) x;
          classify(CSE.getSubExpr(), Class.Ignore);
        }
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ClassifyRefs::operator()">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp", line = 333,
   FQN="(anonymous namespace)::ClassifyRefs::operator()", NM="_ZN12_GLOBAL__N_112ClassifyRefsclEPN5clang4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp -nm=_ZN12_GLOBAL__N_112ClassifyRefsclEPN5clang4StmtE")
  //</editor-fold>
  public void $call(Stmt /*P*/ S) {
    Visit(S);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ClassifyRefs::get">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp", line = 335,
   FQN="(anonymous namespace)::ClassifyRefs::get", NM="_ZNK12_GLOBAL__N_112ClassifyRefs3getEPKN5clang11DeclRefExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp -nm=_ZNK12_GLOBAL__N_112ClassifyRefs3getEPKN5clang11DeclRefExprE")
  //</editor-fold>
  public Class get(/*const*/ DeclRefExpr /*P*/ DRE) /*const*/ {
    DenseMapIterator</*const*/ DeclRefExpr /*P*/ , Class> I = Classification.find$Const(DRE);
    if (I.$noteq(Classification.end$Const())) {
      return I.$arrow().second;
    }
    
    /*const*/ VarDecl /*P*/ VD = dyn_cast_VarDecl(DRE.getDecl$Const());
    if (!(VD != null) || !isTrackedVar(VD)) {
      return Class.Ignore;
    }
    
    return Class.Init;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ClassifyRefs::~ClassifyRefs">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp", line = 305,
   FQN="(anonymous namespace)::ClassifyRefs::~ClassifyRefs", NM="_ZN12_GLOBAL__N_112ClassifyRefsD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp -nm=_ZN12_GLOBAL__N_112ClassifyRefsD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    Classification.$destroy();
    StmtVisitorVoid.super.$destroy$StmtVisitor();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "DC=" + "[DeclContext]" // NOI18N
              + ", Classification=" + Classification // NOI18N
              + super.toString(); // NOI18N
  }
}
