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

package org.clang.codegen.impl;

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.codegen.CodeGen.impl.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import org.clang.codegen.java.ExprEmitter;

/// A CRTP base class for emitting expressions of retainable object
/// pointer type in ARC.
/*template <typename Impl, typename Result> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARCExprEmitter">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 2584,
 FQN="(anonymous namespace)::ARCExprEmitter", NM="_ZN12_GLOBAL__N_114ARCExprEmitterE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN12_GLOBAL__N_114ARCExprEmitterE")
//</editor-fold>
public abstract class ARCExprEmitter</*typename*/ Impl extends ARCExprEmitter, /*typename*/ Result> implements ExprEmitter<Result>  {
/*protected:*/
  protected final CodeGenFunction /*&*/ CGF;
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARCExprEmitter::asImpl">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 2587,
   FQN="(anonymous namespace)::ARCExprEmitter::asImpl", NM="_ZN12_GLOBAL__N_114ARCExprEmitter6asImplEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN12_GLOBAL__N_114ARCExprEmitter6asImplEv")
  //</editor-fold>
  protected ExprEmitter<Result> /*&*/ asImpl() {
    return Native.$star(((/*static_cast*/Impl /*P*/ )(this)));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARCExprEmitter::ARCExprEmitter<Impl, Result>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 2589,
   FQN="(anonymous namespace)::ARCExprEmitter::ARCExprEmitter<Impl, Result>", NM="_ZN12_GLOBAL__N_114ARCExprEmitterC1ERN5clang7CodeGen15CodeGenFunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN12_GLOBAL__N_114ARCExprEmitterC1ERN5clang7CodeGen15CodeGenFunctionE")
  //</editor-fold>
  protected ARCExprEmitter(final CodeGenFunction /*&*/ CGF) {
    // : CGF(CGF) 
    //START JInit
    this./*&*/CGF=/*&*/CGF;
    //END JInit
  }

/*public:*/
  
  /// The general expression-emission logic.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARCExprEmitter::visit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 2780,
   FQN="(anonymous namespace)::ARCExprEmitter::visit", NM="_ZN12_GLOBAL__N_114ARCExprEmitter5visitEPKN5clang4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN12_GLOBAL__N_114ARCExprEmitter5visitEPKN5clang4ExprE")
  //</editor-fold>
  public Result visit(/*const*/ Expr /*P*/ e) {
    // We should *never* see a nested full-expression here, because if
    // we fail to emit at +1, our caller must not retain after we close
    // out the full-expression.  This isn't as important in the unsafe
    // emitter.
    assert (!isa_ExprWithCleanups(e));
    
    // Look through parens, __extension__, generic selection, etc.
    e = e.IgnoreParens$Const();
    {
      
      // Handle certain kinds of casts.
      /*const*/ CastExpr /*P*/ ce = dyn_cast_CastExpr(e);
      if ((ce != null)) {
        return asImpl().visitCastExpr(ce);
        // Handle the comma operator.
      } else {
        /*const*/ org.clang.ast.BinaryOperator /*P*/ op = dyn_cast_BinaryOperator(e);
        if ((op != null)) {
          return asImpl().visitBinaryOperator(op);

          // TODO: handle conditional operators here

          // For calls and message sends, use the retained-call logic.
          // Delegate inits are a special case in that they're the only
          // returns-retained expression that *isn't* surrounded by
          // a consume.
        } else if (isa_CallExpr(e)
           || (isa_ObjCMessageExpr(e)
           && !cast_ObjCMessageExpr(e).isDelegateInitCall())) {
          return asImpl().visitCall(e);
          // Look through pseudo-object expressions.
        } else {
          /*const*/ PseudoObjectExpr /*P*/ pseudo = dyn_cast_PseudoObjectExpr(e);
          if ((pseudo != null)) {
            return asImpl().visitPseudoObjectExpr(pseudo);
          }
        }
      }
    }
    
    return asImpl().visitExpr(e);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARCExprEmitter::visitCastExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 2670,
   FQN="(anonymous namespace)::ARCExprEmitter::visitCastExpr", NM="_ZN12_GLOBAL__N_114ARCExprEmitter13visitCastExprEPKN5clang8CastExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN12_GLOBAL__N_114ARCExprEmitter13visitCastExprEPKN5clang8CastExprE")
  //</editor-fold>
  public Result visitCastExpr(/*const*/ CastExpr /*P*/ e) {
    switch (e.getCastKind()) {
     case CK_NoOp:
      
      // No-op casts don't change the type, so we just ignore them.
      return asImpl().visit(e.getSubExpr$Const());
     case CK_CPointerToObjCPointerCast:
     case CK_BlockPointerToObjCPointerCast:
     case CK_AnyPointerToBlockPointerCast:
     case CK_BitCast:
      {
        org.llvm.ir.Type /*P*/ resultType = CGF.ConvertType(e.getType());
        assert (e.getSubExpr$Const().getType().$arrow().hasPointerRepresentation());
        Result result = asImpl().visit(e.getSubExpr$Const());
        return asImpl().emitBitCast(result, resultType);
      }
     case CK_LValueToRValue:
      
      // Handle some casts specially.
      return asImpl().visitLValueToRValue(e.getSubExpr$Const());
     case CK_ARCConsumeObject:
      return asImpl().visitConsumeObject(e.getSubExpr$Const());
     case CK_ARCExtendBlockObject:
      return asImpl().visitExtendBlockObject(e.getSubExpr$Const());
     case CK_ARCReclaimReturnedObject:
      return asImpl().visitReclaimReturnedObject(e.getSubExpr$Const());
     default:
      
      // Otherwise, use the default logic.
      return asImpl().visitExpr(e);
    }
  }

  
  /// Try to emit a PseudoObjectExpr under special ARC rules.
  ///
  /// This massively duplicates emitPseudoObjectRValue.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARCExprEmitter::visitPseudoObjectExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 2618,
   FQN="(anonymous namespace)::ARCExprEmitter::visitPseudoObjectExpr", NM="_ZN12_GLOBAL__N_114ARCExprEmitter21visitPseudoObjectExprEPKN5clang16PseudoObjectExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN12_GLOBAL__N_114ARCExprEmitter21visitPseudoObjectExprEPKN5clang16PseudoObjectExprE")
  //</editor-fold>
  public Result visitPseudoObjectExpr(/*const*/ PseudoObjectExpr /*P*/ E) {
    SmallVector<CodeGenFunction.OpaqueValueMappingData> opaques/*J*/= new SmallVector<CodeGenFunction.OpaqueValueMappingData>(4, new CodeGenFunction.OpaqueValueMappingData());
    
    // Find the result expression.
    /*const*/ Expr /*P*/ resultExpr = E.getResultExpr$Const();
    assert Native.$bool(resultExpr);
    Result result = null;
    
    for (type$ptr</*const*/ Expr /*P*/ /*const*/ /*P*/> i = $tryClone(E.semantics_begin$Const()), /*P*/ /*const*/ /*P*/ e = $tryClone(E.semantics_end$Const()); $noteq_ptr(i, e); i.$preInc()) {
      /*const*/ Expr /*P*/ semantic = i.$star();
      {
        
        // If this semantic expression is an opaque value, bind it
        // to the result of its source expression.
        /*const*/ OpaqueValueExpr /*P*/ ov = dyn_cast_OpaqueValueExpr(semantic);
        if ((ov != null)) {
          // JAVA: typedef CodeGenFunction::OpaqueValueMappingData OVMA
//          final class OVMA extends CodeGenFunction.OpaqueValueMappingData{ };
          CodeGenFunction.OpaqueValueMappingData opaqueData/*J*/= new CodeGenFunction.OpaqueValueMappingData();
          
          // If this semantic is the result of the pseudo-object
          // expression, try to evaluate the source as +1.
          if (ov == resultExpr) {
            assert (!CodeGenFunction.OpaqueValueMappingData.shouldBindAsLValue(ov));
            result = asImpl().visit(ov.getSourceExpr());
            opaqueData = CodeGenFunction.OpaqueValueMappingData.bind(CGF, ov, 
                RValue.get(asImpl().getValueOfResult(result)));
            // Otherwise, just bind it.
          } else {
            opaqueData = CodeGenFunction.OpaqueValueMappingData.bind(CGF, ov, ov.getSourceExpr());
          }
          opaques.push_back(opaqueData);
          // Otherwise, if the expression is the result, evaluate it
          // and remember the result.
        } else if (semantic == resultExpr) {
          result = asImpl().visit(semantic);
          // Otherwise, evaluate the expression in an ignored context.
        } else {
          CGF.EmitIgnoredExpr(semantic);
        }
      }
    }
    
    // Unbind all the opaques now.
    for (/*uint*/int i = 0, e = opaques.size(); i != e; ++i)  {
      opaques.$at(i).unbind(CGF);
    }
    
    return result;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARCExprEmitter::visitBinaryOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 2705,
   FQN="(anonymous namespace)::ARCExprEmitter::visitBinaryOperator", NM="_ZN12_GLOBAL__N_114ARCExprEmitter19visitBinaryOperatorEPKN5clang14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN12_GLOBAL__N_114ARCExprEmitter19visitBinaryOperatorEPKN5clang14BinaryOperatorE")
  //</editor-fold>
  public Result visitBinaryOperator(/*const*/ org.clang.ast.BinaryOperator /*P*/ e) {
    switch (e.getOpcode()) {
     case BO_Comma:
      CGF.EmitIgnoredExpr(e.getLHS());
      CGF.EnsureInsertPoint();
      return asImpl().visit(e.getRHS());
     case BO_Assign:
      return asImpl().visitBinAssign(e);
     default:
      return asImpl().visitExpr(e);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARCExprEmitter::visitBinAssign">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 2722,
   FQN="(anonymous namespace)::ARCExprEmitter::visitBinAssign", NM="_ZN12_GLOBAL__N_114ARCExprEmitter14visitBinAssignEPKN5clang14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN12_GLOBAL__N_114ARCExprEmitter14visitBinAssignEPKN5clang14BinaryOperatorE")
  //</editor-fold>
  public Result visitBinAssign(/*const*/ org.clang.ast.BinaryOperator /*P*/ e) {
    switch (e.getLHS().getType().getObjCLifetime()) {
     case OCL_ExplicitNone:
      return asImpl().visitBinAssignUnsafeUnretained(e);
     case OCL_Weak:
      return asImpl().visitBinAssignWeak(e);
     case OCL_Autoreleasing:
      return asImpl().visitBinAssignAutoreleasing(e);
     case OCL_Strong:
      return asImpl().visitBinAssignStrong(e);
     case OCL_None:
      return asImpl().visitExpr(e);
    }
    throw new llvm_unreachable("bad ObjC ownership qualifier");
  }

  
  /// The default rule for __unsafe_unretained emits the RHS recursively,
  /// stores into the unsafe variable, and propagates the result outward.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARCExprEmitter::visitBinAssignUnsafeUnretained">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 2745,
   FQN="(anonymous namespace)::ARCExprEmitter::visitBinAssignUnsafeUnretained", NM="_ZN12_GLOBAL__N_114ARCExprEmitter30visitBinAssignUnsafeUnretainedEPKN5clang14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN12_GLOBAL__N_114ARCExprEmitter30visitBinAssignUnsafeUnretainedEPKN5clang14BinaryOperatorE")
  //</editor-fold>
  public Result visitBinAssignUnsafeUnretained(/*const*/ org.clang.ast.BinaryOperator /*P*/ e) {
    // Recursively emit the RHS.
    // For __block safety, do this before emitting the LHS.
    Result result = asImpl().visit(e.getRHS());
    
    // Perform the store.
    LValue lvalue = CGF.EmitCheckedLValue(e.getLHS(), CodeGenFunction.TypeCheckKind.TCK_Store);
    CGF.EmitStoreThroughLValue(RValue.get(asImpl().getValueOfResult(result)), 
        lvalue);
    
    return result;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARCExprEmitter::visitBinAssignAutoreleasing">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 2761,
   FQN="(anonymous namespace)::ARCExprEmitter::visitBinAssignAutoreleasing", NM="_ZN12_GLOBAL__N_114ARCExprEmitter27visitBinAssignAutoreleasingEPKN5clang14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN12_GLOBAL__N_114ARCExprEmitter27visitBinAssignAutoreleasingEPKN5clang14BinaryOperatorE")
  //</editor-fold>
  public Result visitBinAssignAutoreleasing(/*const*/ org.clang.ast.BinaryOperator /*P*/ e) {
    return asImpl().visitExpr(e);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARCExprEmitter::visitBinAssignWeak">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 2767,
   FQN="(anonymous namespace)::ARCExprEmitter::visitBinAssignWeak", NM="_ZN12_GLOBAL__N_114ARCExprEmitter18visitBinAssignWeakEPKN5clang14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN12_GLOBAL__N_114ARCExprEmitter18visitBinAssignWeakEPKN5clang14BinaryOperatorE")
  //</editor-fold>
  public Result visitBinAssignWeak(/*const*/ org.clang.ast.BinaryOperator /*P*/ e) {
    return asImpl().visitExpr(e);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARCExprEmitter::visitBinAssignStrong">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp", line = 2773,
   FQN="(anonymous namespace)::ARCExprEmitter::visitBinAssignStrong", NM="_ZN12_GLOBAL__N_114ARCExprEmitter20visitBinAssignStrongEPKN5clang14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjC.cpp -nm=_ZN12_GLOBAL__N_114ARCExprEmitter20visitBinAssignStrongEPKN5clang14BinaryOperatorE")
  //</editor-fold>
  public Result visitBinAssignStrong(/*const*/ org.clang.ast.BinaryOperator /*P*/ e) {
    return asImpl().visitExpr(e);
  }

  
  @Override public String toString() {
    return "" + "CGF=" + CGF; // NOI18N
  }
// Minimal implementation:
//   Result visitLValueToRValue(const Expr *e)
//   Result visitConsumeObject(const Expr *e)
//   Result visitExtendBlockObject(const Expr *e)
//   Result visitReclaimReturnedObject(const Expr *e)
//   Result visitCall(const Expr *e)
//   Result visitExpr(const Expr *e)
//
//   Result emitBitCast(Result result, llvm::Type *resultType)
//   llvm::Value *getValueOfResult(Result result)
}
