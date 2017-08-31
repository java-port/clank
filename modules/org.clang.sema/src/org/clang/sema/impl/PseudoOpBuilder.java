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

package org.clang.sema.impl;

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clank.support.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.sema.*;
import static org.clang.sema.SemaClangGlobals.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;


//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PseudoOpBuilder">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp", line = 187,
 FQN="(anonymous namespace)::PseudoOpBuilder", NM="_ZN12_GLOBAL__N_115PseudoOpBuilderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp -nm=_ZN12_GLOBAL__N_115PseudoOpBuilderE")
//</editor-fold>
public abstract class PseudoOpBuilder implements Destructors.ClassWithDestructor {
/*public:*/
  public final Sema /*&*/ S;
  public /*uint*/int ResultIndex;
  public SourceLocation GenericLoc;
  public SmallVector<Expr /*P*/ > Semantics;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PseudoOpBuilder::PseudoOpBuilder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp", line = 194,
   FQN="(anonymous namespace)::PseudoOpBuilder::PseudoOpBuilder", NM="_ZN12_GLOBAL__N_115PseudoOpBuilderC1ERN5clang4SemaENS1_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp -nm=_ZN12_GLOBAL__N_115PseudoOpBuilderC1ERN5clang4SemaENS1_14SourceLocationE")
  //</editor-fold>
  public PseudoOpBuilder(final Sema /*&*/ S, SourceLocation genericLoc) {
    // : S(S), ResultIndex(PseudoObjectExpr::NoResult), GenericLoc(genericLoc), Semantics() 
    //START JInit
    this./*&*/S=/*&*/S;
    this.ResultIndex = PseudoObjectExpr.NoResult;
    this.GenericLoc = new SourceLocation(genericLoc);
    this.Semantics = new SmallVector<Expr /*P*/ >(4, (Expr /*P*/ )null);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PseudoOpBuilder::~PseudoOpBuilder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp", line = 198,
   FQN="(anonymous namespace)::PseudoOpBuilder::~PseudoOpBuilder", NM="_ZN12_GLOBAL__N_115PseudoOpBuilderD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp -nm=_ZN12_GLOBAL__N_115PseudoOpBuilderD0Ev")
  //</editor-fold>
  public /*virtual*/ void $destroy() {
    //START JDestroy
    Semantics.$destroy();
    //END JDestroy
  }

  
  /// Add a normal semantic expression.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PseudoOpBuilder::addSemanticExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp", line = 201,
   FQN="(anonymous namespace)::PseudoOpBuilder::addSemanticExpr", NM="_ZN12_GLOBAL__N_115PseudoOpBuilder15addSemanticExprEPN5clang4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp -nm=_ZN12_GLOBAL__N_115PseudoOpBuilder15addSemanticExprEPN5clang4ExprE")
  //</editor-fold>
  public void addSemanticExpr(Expr /*P*/ semantic) {
    Semantics.push_back(semantic);
  }

  
  /// Add the 'result' semantic expression.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PseudoOpBuilder::addResultSemanticExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp", line = 206,
   FQN="(anonymous namespace)::PseudoOpBuilder::addResultSemanticExpr", NM="_ZN12_GLOBAL__N_115PseudoOpBuilder21addResultSemanticExprEPN5clang4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp -nm=_ZN12_GLOBAL__N_115PseudoOpBuilder21addResultSemanticExprEPN5clang4ExprE")
  //</editor-fold>
  public void addResultSemanticExpr(Expr /*P*/ resultExpr) {
    assert (ResultIndex == PseudoObjectExpr.NoResult);
    ResultIndex = Semantics.size();
    Semantics.push_back(resultExpr);
  }

  
  
  /// The main skeleton for building an r-value operation.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PseudoOpBuilder::buildRValueOperation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp", line = 409,
   FQN="(anonymous namespace)::PseudoOpBuilder::buildRValueOperation", NM="_ZN12_GLOBAL__N_115PseudoOpBuilder20buildRValueOperationEPN5clang4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp -nm=_ZN12_GLOBAL__N_115PseudoOpBuilder20buildRValueOperationEPN5clang4ExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > buildRValueOperation(Expr /*P*/ op) {
    Expr /*P*/ syntacticBase = rebuildAndCaptureObject(op);
    
    ActionResultTTrue<Expr /*P*/ > getExpr = buildGet();
    if (getExpr.isInvalid()) {
      return ExprError();
    }
    addResultSemanticExpr(getExpr.get());
    
    return complete(syntacticBase);
  }

  
  /// The basic skeleton for building a simple or compound
  /// assignment operation.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PseudoOpBuilder::buildAssignmentOperation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp", line = 421,
   FQN="(anonymous namespace)::PseudoOpBuilder::buildAssignmentOperation", NM="_ZN12_GLOBAL__N_115PseudoOpBuilder24buildAssignmentOperationEPN5clang5ScopeENS1_14SourceLocationENS1_18BinaryOperatorKindEPNS1_4ExprES7_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp -nm=_ZN12_GLOBAL__N_115PseudoOpBuilder24buildAssignmentOperationEPN5clang5ScopeENS1_14SourceLocationENS1_18BinaryOperatorKindEPNS1_4ExprES7_")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > buildAssignmentOperation(Scope /*P*/ Sc, SourceLocation opcLoc, 
                          BinaryOperatorKind opcode, 
                          Expr /*P*/ LHS, Expr /*P*/ RHS) {
    assert (BinaryOperator.isAssignmentOp(opcode));
    
    Expr /*P*/ syntacticLHS = rebuildAndCaptureObject(LHS);
    OpaqueValueExpr /*P*/ capturedRHS = capture(RHS);
    
    // In some very specific cases, semantic analysis of the RHS as an
    // expression may require it to be rewritten.  In these cases, we
    // cannot safely keep the OVE around.  Fortunately, we don't really
    // need to: we don't use this particular OVE in multiple places, and
    // no clients rely that closely on matching up expressions in the
    // semantic expression with expressions from the syntactic form.
    Expr /*P*/ semanticRHS = capturedRHS;
    if (RHS.hasPlaceholderType() || isa_InitListExpr(RHS)) {
      semanticRHS = RHS;
      Semantics.pop_back();
    }
    
    Expr /*P*/ syntactic;
    
    ActionResultTTrue<Expr /*P*/ > result/*J*/= new ActionResultTTrue<Expr /*P*/ >();
    if (opcode == BinaryOperatorKind.BO_Assign) {
      result.$assign(semanticRHS);
      syntactic = /*NEW_EXPR [Stmt::new]*//*new (S.Context)*/ Stmt.$new_uint_ASTContext$C_uint(S.Context, (type$ptr<?> New$Mem)->new BinaryOperator(syntacticLHS, capturedRHS, 
          opcode, capturedRHS.getType(), 
          capturedRHS.getValueKind(), 
          ExprObjectKind.OK_Ordinary, new SourceLocation(opcLoc), false));
    } else {
      ActionResultTTrue<Expr /*P*/ > opLHS = buildGet();
      if (opLHS.isInvalid()) {
        return ExprError();
      }
      
      // Build an ordinary, non-compound operation.
      BinaryOperatorKind nonCompound = BinaryOperator.getOpForCompoundAssignment(opcode);
      result.$assignMove(S.BuildBinOp(Sc, new SourceLocation(opcLoc), nonCompound, opLHS.get(), semanticRHS));
      if (result.isInvalid()) {
        return ExprError();
      }
      
      syntactic
         = /*NEW_EXPR [Stmt::new]*//*new (S.Context)*/ Stmt.$new_uint_ASTContext$C_uint(S.Context, (type$ptr<?> New$Mem)->new CompoundAssignOperator(syntacticLHS, capturedRHS, opcode, 
          result.get().getType(), 
          result.get().getValueKind(), 
          ExprObjectKind.OK_Ordinary, 
          opLHS.get().getType(), 
          result.get().getType(), 
          new SourceLocation(opcLoc), false));
    }
    
    // The result of the assignment, if not void, is the value set into
    // the l-value.
    result.$assignMove(buildSet(result.get(), new SourceLocation(opcLoc), captureSetValueAsResult()));
    if (result.isInvalid()) {
      return ExprError();
    }
    addSemanticExpr(result.get());
    if (!captureSetValueAsResult() && !result.get().getType().$arrow().isVoidType()
       && (result.get().isTypeDependent() || CanCaptureValue(result.get()))) {
      setResultToLastSemantic();
    }
    
    return complete(syntactic);
  }

  
  /// The basic skeleton for building an increment or decrement
  /// operation.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PseudoOpBuilder::buildIncDecOperation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp", line = 485,
   FQN="(anonymous namespace)::PseudoOpBuilder::buildIncDecOperation", NM="_ZN12_GLOBAL__N_115PseudoOpBuilder20buildIncDecOperationEPN5clang5ScopeENS1_14SourceLocationENS1_17UnaryOperatorKindEPNS1_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp -nm=_ZN12_GLOBAL__N_115PseudoOpBuilder20buildIncDecOperationEPN5clang5ScopeENS1_14SourceLocationENS1_17UnaryOperatorKindEPNS1_4ExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > buildIncDecOperation(Scope /*P*/ Sc, SourceLocation opcLoc, 
                      UnaryOperatorKind opcode, 
                      Expr /*P*/ op) {
    assert (UnaryOperator.isIncrementDecrementOp(opcode));
    
    Expr /*P*/ syntacticOp = rebuildAndCaptureObject(op);
    
    // Load the value.
    ActionResultTTrue<Expr /*P*/ > result = buildGet();
    if (result.isInvalid()) {
      return ExprError();
    }
    
    QualType resultType = result.get().getType();
    
    // That's the postfix result.
    if (UnaryOperator.isPostfix(opcode)
       && (result.get().isTypeDependent() || CanCaptureValue(result.get()))) {
      result.$assign(capture(result.get()));
      setResultToLastSemantic();
    }
    
    // Add or subtract a literal 1.
    APInt oneV/*J*/= new APInt($ulong2uint(S.Context.getTypeSize(S.Context.IntTy.$QualType())), 1);
    Expr /*P*/ one = IntegerLiteral.Create(S.Context, oneV, S.Context.IntTy.$QualType(), 
        new SourceLocation(GenericLoc));
    if (UnaryOperator.isIncrementOp(opcode)) {
      result.$assignMove(S.BuildBinOp(Sc, new SourceLocation(opcLoc), BinaryOperatorKind.BO_Add, result.get(), one));
    } else {
      result.$assignMove(S.BuildBinOp(Sc, new SourceLocation(opcLoc), BinaryOperatorKind.BO_Sub, result.get(), one));
    }
    if (result.isInvalid()) {
      return ExprError();
    }
    
    // Store that back into the result.  The value stored is the result
    // of a prefix operation.
    result.$assignMove(buildSet(result.get(), new SourceLocation(opcLoc), UnaryOperator.isPrefix(opcode)
               && captureSetValueAsResult()));
    if (result.isInvalid()) {
      return ExprError();
    }
    addSemanticExpr(result.get());
    if (UnaryOperator.isPrefix(opcode) && !captureSetValueAsResult()
       && !result.get().getType().$arrow().isVoidType()
       && (result.get().isTypeDependent() || CanCaptureValue(result.get()))) {
      setResultToLastSemantic();
    }
    
    UnaryOperator /*P*/ syntactic = /*NEW_EXPR [Stmt::new]*//*new (S.Context)*/ Stmt.$new_uint_ASTContext$C_uint(S.Context, (type$ptr<?> New$Mem)->new UnaryOperator(syntacticOp, opcode, new QualType(resultType), 
        ExprValueKind.VK_LValue, ExprObjectKind.OK_Ordinary, new SourceLocation(opcLoc)));
    return complete(syntactic);
  }

  
  
  /// The routine which creates the final PseudoObjectExpr.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PseudoOpBuilder::complete">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp", line = 403,
   FQN="(anonymous namespace)::PseudoOpBuilder::complete", NM="_ZN12_GLOBAL__N_115PseudoOpBuilder8completeEPN5clang4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp -nm=_ZN12_GLOBAL__N_115PseudoOpBuilder8completeEPN5clang4ExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > complete(Expr /*P*/ syntactic) {
    return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, PseudoObjectExpr.Create(S.Context, syntactic, 
            new ArrayRef<Expr /*P*/ >(Semantics, true), ResultIndex));
  }

  
  
  /// Capture the given expression in an OpaqueValueExpr.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PseudoOpBuilder::capture">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp", line = 361,
   FQN="(anonymous namespace)::PseudoOpBuilder::capture", NM="_ZN12_GLOBAL__N_115PseudoOpBuilder7captureEPN5clang4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp -nm=_ZN12_GLOBAL__N_115PseudoOpBuilder7captureEPN5clang4ExprE")
  //</editor-fold>
  public OpaqueValueExpr /*P*/ capture(Expr /*P*/ e) {
    // Make a new OVE whose source is the given expression.
    OpaqueValueExpr /*P*/ captured = /*NEW_EXPR [Stmt::new]*//*new (S.Context)*/ Stmt.$new_uint_ASTContext$C_uint(S.Context, (type$ptr<?> New$Mem)->new OpaqueValueExpr(new SourceLocation(GenericLoc), e.getType(), 
        e.getValueKind(), e.getObjectKind(), 
        e));
    
    // Make sure we bind that in the semantics.
    addSemanticExpr(captured);
    return captured;
  }

  
  /// Capture the given expression as the result of this pseudo-object
  /// operation.  This routine is safe against expressions which may
  /// already be captured.
  ///
  /// \returns the captured expression, which will be the
  ///   same as the input if the input was already captured
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PseudoOpBuilder::captureValueAsResult">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp", line = 379,
   FQN="(anonymous namespace)::PseudoOpBuilder::captureValueAsResult", NM="_ZN12_GLOBAL__N_115PseudoOpBuilder20captureValueAsResultEPN5clang4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp -nm=_ZN12_GLOBAL__N_115PseudoOpBuilder20captureValueAsResultEPN5clang4ExprE")
  //</editor-fold>
  public OpaqueValueExpr /*P*/ captureValueAsResult(Expr /*P*/ e) {
    assert (ResultIndex == PseudoObjectExpr.NoResult);
    
    // If the expression hasn't already been captured, just capture it
    // and set the new semantic 
    if (!isa_OpaqueValueExpr(e)) {
      OpaqueValueExpr /*P*/ cap = capture(e);
      setResultToLastSemantic();
      return cap;
    }
    
    // Otherwise, it must already be one of our semantic expressions;
    // set ResultIndex to its index.
    /*uint*/int index = 0;
    for (;; ++index) {
      assert ($less_uint(index, Semantics.size())) : "captured expression not found in semantics!";
      if (e == Semantics.$at(index)) {
        break;
      }
    }
    ResultIndex = index;
    return cast_OpaqueValueExpr(e);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PseudoOpBuilder::setResultToLastSemantic">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp", line = 226,
   FQN="(anonymous namespace)::PseudoOpBuilder::setResultToLastSemantic", NM="_ZN12_GLOBAL__N_115PseudoOpBuilder23setResultToLastSemanticEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp -nm=_ZN12_GLOBAL__N_115PseudoOpBuilder23setResultToLastSemanticEv")
  //</editor-fold>
  public void setResultToLastSemantic() {
    assert (ResultIndex == PseudoObjectExpr.NoResult);
    ResultIndex = Semantics.size() - 1;
  }

  
  /// Return true if assignments have a non-void result.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PseudoOpBuilder::CanCaptureValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp", line = 232,
   FQN="(anonymous namespace)::PseudoOpBuilder::CanCaptureValue", NM="_ZN12_GLOBAL__N_115PseudoOpBuilder15CanCaptureValueEPN5clang4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp -nm=_ZN12_GLOBAL__N_115PseudoOpBuilder15CanCaptureValueEPN5clang4ExprE")
  //</editor-fold>
  public static boolean CanCaptureValue(Expr /*P*/ exp) {
    if (exp.isGLValue()) {
      return true;
    }
    QualType ty = exp.getType();
    assert (!ty.$arrow().isIncompleteType());
    assert (!ty.$arrow().isDependentType());
    {
      
      /*const*/ CXXRecordDecl /*P*/ ClassDecl = ty.$arrow().getAsCXXRecordDecl();
      if ((ClassDecl != null)) {
        return ClassDecl.isTriviallyCopyable();
      }
    }
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PseudoOpBuilder::rebuildAndCaptureObject">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp", line = 244,
   FQN="(anonymous namespace)::PseudoOpBuilder::rebuildAndCaptureObject", NM="_ZN12_GLOBAL__N_115PseudoOpBuilder23rebuildAndCaptureObjectEPN5clang4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp -nm=_ZN12_GLOBAL__N_115PseudoOpBuilder23rebuildAndCaptureObjectEPN5clang4ExprE")
  //</editor-fold>
  public abstract /*virtual*/ Expr /*P*/ rebuildAndCaptureObject(Expr /*P*/ $Prm0)/* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PseudoOpBuilder::buildGet">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp", line = 245,
   FQN="(anonymous namespace)::PseudoOpBuilder::buildGet", NM="_ZN12_GLOBAL__N_115PseudoOpBuilder8buildGetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp -nm=_ZN12_GLOBAL__N_115PseudoOpBuilder8buildGetEv")
  //</editor-fold>
  public abstract /*virtual*/ ActionResultTTrue<Expr /*P*/ > buildGet()/* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PseudoOpBuilder::buildSet">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp", line = 246,
   FQN="(anonymous namespace)::PseudoOpBuilder::buildSet", NM="_ZN12_GLOBAL__N_115PseudoOpBuilder8buildSetEPN5clang4ExprENS1_14SourceLocationEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp -nm=_ZN12_GLOBAL__N_115PseudoOpBuilder8buildSetEPN5clang4ExprENS1_14SourceLocationEb")
  //</editor-fold>
  public abstract /*virtual*/ ActionResultTTrue<Expr /*P*/ > buildSet(Expr /*P*/ $Prm0, SourceLocation $Prm1, 
          boolean captureSetValueAsResult)/* = 0*/;

  /// \brief Should the result of an assignment be the formal result of the
  /// setter call or the value that was passed to the setter?
  ///
  /// Different pseudo-object language features use different language rules
  /// for this.
  /// The default is to use the set value.  Currently, this affects the
  /// behavior of simple assignments, compound assignments, and prefix
  /// increment and decrement.
  /// Postfix increment and decrement always use the getter result as the
  /// expression result.
  ///
  /// If this method returns true, and the set value isn't capturable for
  /// some reason, the result of the expression will be void.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PseudoOpBuilder::captureSetValueAsResult">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp", line = 261,
   FQN="(anonymous namespace)::PseudoOpBuilder::captureSetValueAsResult", NM="_ZNK12_GLOBAL__N_115PseudoOpBuilder23captureSetValueAsResultEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaPseudoObject.cpp -nm=_ZNK12_GLOBAL__N_115PseudoOpBuilder23captureSetValueAsResultEv")
  //</editor-fold>
  public /*virtual*/ boolean captureSetValueAsResult() /*const*/ {
    return true;
  }

  
  @Override public String toString() {
    return "" + "S=" + "[Sema]" // NOI18N
              + ", ResultIndex=" + ResultIndex // NOI18N
              + ", GenericLoc=" + GenericLoc // NOI18N
              + ", Semantics=" + Semantics; // NOI18N
  }
}
