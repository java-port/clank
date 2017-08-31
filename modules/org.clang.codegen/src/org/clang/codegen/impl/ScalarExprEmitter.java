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

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.llvm.ir.*;
import org.clang.codegen.impl.*;
import org.clang.codegen.CodeGen.impl.*;
import org.llvm.ir.FunctionType;
import org.llvm.ir.VectorType;
import org.llvm.ir.Type;
import org.clang.ast.BinaryOperator;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.java.AstTypesRTTI.*;
import static org.clang.codegen.impl.CGExprScalarStatics.*;
import static org.llvm.ir.java.IrRTTI.*;
import org.llvm.ir.intrinsic.ID;
import org.clang.ast.DeclContext.specific_decl_iterator;
import static org.llvm.pass.IrLlvmGlobals.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 60,
 FQN="(anonymous namespace)::ScalarExprEmitter", NM="_ZN12_GLOBAL__N_117ScalarExprEmitterE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitterE")
//</editor-fold>
public class ScalarExprEmitter implements /*public*/ StmtVisitor<ScalarExprEmitter, Value /*P*/ > {
  private final CodeGenFunction /*&*/ CGF;
  private final CGBuilderTy /*&*/ Builder;
  private boolean IgnoreResultAssign;
  private final LLVMContext /*&*/ VMContext;
/*public:*/
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::ScalarExprEmitter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 68,
   FQN="(anonymous namespace)::ScalarExprEmitter::ScalarExprEmitter", NM="_ZN12_GLOBAL__N_117ScalarExprEmitterC1ERN5clang7CodeGen15CodeGenFunctionEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitterC1ERN5clang7CodeGen15CodeGenFunctionEb")
  //</editor-fold>
  public ScalarExprEmitter(final CodeGenFunction /*&*/ cgf) {
    this(cgf, false);
  }
  public ScalarExprEmitter(final CodeGenFunction /*&*/ cgf, boolean ira/*= false*/) {
    // : StmtVisitor<ScalarExprEmitter, Value * >(), CGF(cgf), Builder(CGF.Builder), IgnoreResultAssign(ira), VMContext(cgf.getLLVMContext()) 
    //START JInit
    $StmtVisitor();
    this./*&*/CGF=/*&*/cgf;
    this./*&*/Builder=/*&*/CGF.Builder;
    this.IgnoreResultAssign = ira;
    this./*&*/VMContext=/*&*/cgf.getLLVMContext();
    //END JInit
  }

  
  //===--------------------------------------------------------------------===//
  //                               Utilities
  //===--------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::TestAndClearIgnoreResultAssign">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 77,
   FQN="(anonymous namespace)::ScalarExprEmitter::TestAndClearIgnoreResultAssign", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter30TestAndClearIgnoreResultAssignEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter30TestAndClearIgnoreResultAssignEv")
  //</editor-fold>
  public boolean TestAndClearIgnoreResultAssign() {
    boolean I = IgnoreResultAssign;
    IgnoreResultAssign = false;
    return I;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::ConvertType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 83,
   FQN="(anonymous namespace)::ScalarExprEmitter::ConvertType", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter11ConvertTypeEN5clang8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter11ConvertTypeEN5clang8QualTypeE")
  //</editor-fold>
  public Type /*P*/ ConvertType(QualType T) {
    return CGF.ConvertType(new QualType(T));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::EmitLValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 84,
   FQN="(anonymous namespace)::ScalarExprEmitter::EmitLValue", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter10EmitLValueEPKN5clang4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter10EmitLValueEPKN5clang4ExprE")
  //</editor-fold>
  public LValue EmitLValue(/*const*/ Expr /*P*/ E) {
    return CGF.EmitLValue(E);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::EmitCheckedLValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 85,
   FQN="(anonymous namespace)::ScalarExprEmitter::EmitCheckedLValue", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter17EmitCheckedLValueEPKN5clang4ExprENS1_7CodeGen15CodeGenFunction13TypeCheckKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter17EmitCheckedLValueEPKN5clang4ExprENS1_7CodeGen15CodeGenFunction13TypeCheckKindE")
  //</editor-fold>
  public LValue EmitCheckedLValue(/*const*/ Expr /*P*/ E, CodeGenFunction.TypeCheckKind TCK) {
    return CGF.EmitCheckedLValue(E, TCK);
  }

  
  
  /// \brief Emit a sanitization check for the given "binary" operation (which
  /// might actually be a unary increment which has been lowered to a binary
  /// operation). The check passes if all values in \p Checks (which are \c i1),
  /// are \c true.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::EmitBinOpCheck">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 927,
   FQN="(anonymous namespace)::ScalarExprEmitter::EmitBinOpCheck", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter14EmitBinOpCheckEN4llvm8ArrayRefISt4pairIPNS1_5ValueEyEEERKNS_9BinOpInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter14EmitBinOpCheckEN4llvm8ArrayRefISt4pairIPNS1_5ValueEyEEERKNS_9BinOpInfoE")
  //</editor-fold>
  public void EmitBinOpCheck(ArrayRef<std.pairPtrULong<Value /*P*/ >> Checks, final /*const*/ BinOpInfo /*&*/ Info) {
    assert (CGF.IsSanitizerScope);
    StringRef CheckName/*J*/= new StringRef();
    SmallVector<Constant /*P*/ > StaticData/*J*/= new SmallVector<Constant /*P*/ >(4, (Constant /*P*/ )null);
    SmallVector<Value /*P*/ > DynamicData/*J*/= new SmallVector<Value /*P*/ >(2, (Value /*P*/ )null);
    
    BinaryOperatorKind Opcode = Info.Opcode;
    if (BinaryOperator.isCompoundAssignmentOp(Opcode)) {
      Opcode = BinaryOperator.getOpForCompoundAssignment(Opcode);
    }
    
    StaticData.push_back(CGF.EmitCheckSourceLocation(Info.E.getExprLoc()));
    /*const*/ UnaryOperator /*P*/ UO = dyn_cast_UnaryOperator(Info.E);
    if ((UO != null) && UO.getOpcode() == UnaryOperatorKind.UO_Minus) {
      CheckName.$assignMove(/*STRINGREF_STR*/"negate_overflow");
      StaticData.push_back(CGF.EmitCheckTypeDescriptor(UO.getType()));
      DynamicData.push_back(Info.RHS);
    } else {
      if (BinaryOperator.isShiftOp(Opcode)) {
        // Shift LHS negative or too large, or RHS out of bounds.
        CheckName.$assignMove(/*STRINGREF_STR*/"shift_out_of_bounds");
        /*const*/ BinaryOperator /*P*/ BO = cast_BinaryOperator(Info.E);
        StaticData.push_back(CGF.EmitCheckTypeDescriptor(BO.getLHS().getType()));
        StaticData.push_back(CGF.EmitCheckTypeDescriptor(BO.getRHS().getType()));
      } else if (Opcode == BinaryOperatorKind.BO_Div || Opcode == BinaryOperatorKind.BO_Rem) {
        // Divide or modulo by zero, or signed overflow (eg INT_MAX / -1).
        CheckName.$assignMove(/*STRINGREF_STR*/"divrem_overflow");
        StaticData.push_back(CGF.EmitCheckTypeDescriptor(new QualType(Info.Ty)));
      } else {
        // Arithmetic overflow (+, -, *).
        switch (Opcode) {
         case BO_Add:
          CheckName.$assignMove(/*STRINGREF_STR*/"add_overflow");
          break;
         case BO_Sub:
          CheckName.$assignMove(/*STRINGREF_STR*/"sub_overflow");
          break;
         case BO_Mul:
          CheckName.$assignMove(/*STRINGREF_STR*/"mul_overflow");
          break;
         default:
          throw new llvm_unreachable("unexpected opcode for bin op check");
        }
        StaticData.push_back(CGF.EmitCheckTypeDescriptor(new QualType(Info.Ty)));
      }
      DynamicData.push_back(Info.LHS);
      DynamicData.push_back(Info.RHS);
    }
    
    CGF.EmitCheck(new ArrayRef<std.pairPtrULong<Value /*P*/ >>(Checks), new StringRef(CheckName), new ArrayRef<Constant /*P*/ >(StaticData, true), new ArrayRef<Value /*P*/ >(DynamicData, true));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::EmitLoadOfLValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 92,
   FQN="(anonymous namespace)::ScalarExprEmitter::EmitLoadOfLValue", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter16EmitLoadOfLValueEN5clang7CodeGen6LValueENS1_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter16EmitLoadOfLValueEN5clang7CodeGen6LValueENS1_14SourceLocationE")
  //</editor-fold>
  public Value /*P*/ EmitLoadOfLValue(LValue LV, SourceLocation Loc) {
    return CGF.EmitLoadOfLValue(new LValue(LV), new SourceLocation(Loc)).getScalarVal();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::EmitLValueAlignmentAssumption">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 96,
   FQN="(anonymous namespace)::ScalarExprEmitter::EmitLValueAlignmentAssumption", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter29EmitLValueAlignmentAssumptionEPKN5clang4ExprEPN4llvm5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter29EmitLValueAlignmentAssumptionEPKN5clang4ExprEPN4llvm5ValueE")
  //</editor-fold>
  public void EmitLValueAlignmentAssumption(/*const*/ Expr /*P*/ E, Value /*P*/ V) {
    /*const*/ AlignValueAttr /*P*/ AVAttr = null;
    {
      /*const*/ DeclRefExpr /*P*/ DRE = dyn_cast_DeclRefExpr(E);
      if ((DRE != null)) {
        /*const*/ ValueDecl /*P*/ VD = DRE.getDecl$Const();
        if (VD.getType().$arrow().isReferenceType()) {
          {
            /*const*/ TypedefType /*P*/ TTy = dyn_cast_TypedefType(VD.getType().getNonReferenceType());
            if ((TTy != null)) {
              AVAttr = TTy.getDecl().getAttr(AlignValueAttr.class);
            }
          }
        } else {
          // Assumptions for function parameters are emitted at the start of the
          // function, so there is no need to repeat that here.
          if (isa_ParmVarDecl(VD)) {
            return;
          }
          
          AVAttr = VD.getAttr(AlignValueAttr.class);
        }
      }
    }
    if (!(AVAttr != null)) {
      {
        /*const*/ TypedefType /*P*/ TTy = dyn_cast_TypedefType(E.getType());
        if ((TTy != null)) {
          AVAttr = TTy.getDecl().getAttr(AlignValueAttr.class);
        }
      }
    }
    if (!(AVAttr != null)) {
      return;
    }
    
    Value /*P*/ AlignmentValue = CGF.EmitScalarExpr(AVAttr.getAlignment());
    ConstantInt /*P*/ AlignmentCI = cast_ConstantInt(AlignmentValue);
    CGF.EmitAlignmentAssumption(V, $ulong2uint(AlignmentCI.getZExtValue()));
  }

  
  /// EmitLoadOfLValue - Given an expression with complex type that represents a
  /// value l-value, this method emits the address of the l-value, then loads
  /// and returns the result.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::EmitLoadOfLValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 131,
   FQN="(anonymous namespace)::ScalarExprEmitter::EmitLoadOfLValue", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter16EmitLoadOfLValueEPKN5clang4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter16EmitLoadOfLValueEPKN5clang4ExprE")
  //</editor-fold>
  public Value /*P*/ EmitLoadOfLValue(/*const*/ Expr /*P*/ E) {
    Value /*P*/ V = EmitLoadOfLValue(EmitCheckedLValue(E, CodeGenFunction.TypeCheckKind.TCK_Load), 
        E.getExprLoc());
    
    EmitLValueAlignmentAssumption(E, V);
    return V;
  }

  
  /// EmitConversionToBool - Convert the specified expression value to a
  /// boolean (i1) truth value.  This is equivalent to "Val != 0".
  // end anonymous namespace.
  
  //===----------------------------------------------------------------------===//
  //                                Utilities
  //===----------------------------------------------------------------------===//
  
  /// EmitConversionToBool - Convert the specified expression value to a
  /// boolean (i1) truth value.  This is equivalent to "Val != 0".
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::EmitConversionToBool">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 578,
   FQN="(anonymous namespace)::ScalarExprEmitter::EmitConversionToBool", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter20EmitConversionToBoolEPN4llvm5ValueEN5clang8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter20EmitConversionToBoolEPN4llvm5ValueEN5clang8QualTypeE")
  //</editor-fold>
  public Value /*P*/ EmitConversionToBool(Value /*P*/ Src, QualType SrcType) {
    assert (SrcType.isCanonical()) : "EmitScalarConversion strips typedefs";
    if (SrcType.$arrow().isRealFloatingType()) {
      return EmitFloatToBoolConversion(Src);
    }
    {
      
      /*const*/ MemberPointerType /*P*/ MPT = dyn_cast_MemberPointerType(SrcType);
      if ((MPT != null)) {
        return CGF.CGM.getCXXABI().EmitMemberPointerIsNotNull(CGF, Src, MPT);
      }
    }
    assert ((SrcType.$arrow().isIntegerType() || isa_PointerType(Src.getType()))) : "Unknown scalar type to convert";
    if (isa_IntegerType(Src.getType())) {
      return EmitIntToBoolConversion(Src);
    }
    assert (isa_PointerType(Src.getType()));
    return EmitPointerToBoolConversion(Src);
  }

  
  /// Emit a check that a conversion to or from a floating-point type does not
  /// overflow.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::EmitFloatConversionCheck">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 597,
   FQN="(anonymous namespace)::ScalarExprEmitter::EmitFloatConversionCheck", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter24EmitFloatConversionCheckEPN4llvm5ValueEN5clang8QualTypeES3_S5_S5_PNS1_4TypeENS4_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter24EmitFloatConversionCheckEPN4llvm5ValueEN5clang8QualTypeES3_S5_S5_PNS1_4TypeENS4_14SourceLocationE")
  //</editor-fold>
  public void EmitFloatConversionCheck(Value /*P*/ OrigSrc, QualType OrigSrcType, Value /*P*/ Src, QualType SrcType, 
                          QualType DstType, Type /*P*/ DstTy, SourceLocation Loc) {
    CodeGenFunction.SanitizerScope SanScope = null;
    try {
      SanScope/*J*/= new CodeGenFunction.SanitizerScope(/*AddrOf*/CGF);
      //JAVA: using llvm::APFloat;
      //JAVA: using llvm::APSInt;
      
      Type /*P*/ SrcTy = Src.getType();
      
      Value /*P*/ Check = null;
      {
        IntegerType /*P*/ IntTy = dyn_cast_IntegerType(SrcTy);
        if ((IntTy != null)) {
          // Integer to floating-point. This can fail for unsigned short -> __half
          // or unsigned __int128 -> float.
          assert (DstType.$arrow().isFloatingType());
          boolean SrcIsUnsigned = OrigSrcType.$arrow().isUnsignedIntegerOrEnumerationType();
          
          APFloat LargestFloat = APFloat.getLargest(CGF.getContext().getFloatTypeSemantics(new QualType(DstType)));
          APSInt LargestInt/*J*/= new APSInt(IntTy.getBitWidth(), SrcIsUnsigned);
          
          bool$ptr IsExact = create_bool$ptr();
          if (LargestFloat.convertToInteger(LargestInt, APFloat.roundingMode.rmTowardZero, 
              /*AddrOf*/IsExact) != APFloat.opStatus.opOK) {
            // The range of representable values of this floating point type includes
            // all values of this integer type. Don't need an overflow check.
            return;
          }
          
          Value /*P*/ Max = ConstantInt.get(VMContext, LargestInt);
          if (SrcIsUnsigned) {
            Check = Builder.CreateICmpULE(Src, Max);
          } else {
            Value /*P*/ Min = ConstantInt.get(VMContext, LargestInt.$sub());
            Value /*P*/ GE = Builder.CreateICmpSGE(Src, Min);
            Value /*P*/ LE = Builder.CreateICmpSLE(Src, Max);
            Check = Builder.CreateAnd(GE, LE);
          }
        } else {
          final /*const*/ fltSemantics /*&*/ SrcSema = CGF.getContext().getFloatTypeSemantics(new QualType(OrigSrcType));
          if (isa_IntegerType(DstTy)) {
            // Floating-point to integer. This has undefined behavior if the source is
            // +-Inf, NaN, or doesn't fit into the destination type (after truncation
            // to an integer).
            /*uint*/int Width = CGF.getContext().getIntWidth(new QualType(DstType));
            boolean Unsigned = DstType.$arrow().isUnsignedIntegerOrEnumerationType();
            
            APSInt Min = APSInt.getMinValue(Width, Unsigned);
            APFloat MinSrc/*J*/= new APFloat(SrcSema, APFloat.uninitializedTag.uninitialized);
            if (((MinSrc.convertFromAPInt(Min, !Unsigned, APFloat.roundingMode.rmTowardZero)
               & APFloat.opStatus.opOverflow) != 0)) {
              // Don't need an overflow check for lower bound. Just check for
              // -Inf/NaN.
              MinSrc.$assignMove(APFloat.getInf(SrcSema, true));
            } else {
              // Find the largest value which is too small to represent (before
              // truncation toward zero).
              MinSrc.subtract(new APFloat(SrcSema, $int2ulong(1)), APFloat.roundingMode.rmTowardNegative);
            }
            
            APSInt Max = APSInt.getMaxValue(Width, Unsigned);
            APFloat MaxSrc/*J*/= new APFloat(SrcSema, APFloat.uninitializedTag.uninitialized);
            if (((MaxSrc.convertFromAPInt(Max, !Unsigned, APFloat.roundingMode.rmTowardZero)
               & APFloat.opStatus.opOverflow) != 0)) {
              // Don't need an overflow check for upper bound. Just check for
              // +Inf/NaN.
              MaxSrc.$assignMove(APFloat.getInf(SrcSema, false));
            } else {
              // Find the smallest value which is too large to represent (before
              // truncation toward zero).
              MaxSrc.add(new APFloat(SrcSema, $int2ulong(1)), APFloat.roundingMode.rmTowardPositive);
            }
            
            // If we're converting from __half, convert the range to float to match
            // the type of src.
            if (OrigSrcType.$arrow().isHalfType()) {
              final /*const*/ fltSemantics /*&*/ Sema = CGF.getContext().getFloatTypeSemantics(new QualType(SrcType));
              bool$ptr IsInexact = create_bool$ptr();
              MinSrc.convert(Sema, APFloat.roundingMode.rmTowardZero, /*AddrOf*/IsInexact);
              MaxSrc.convert(Sema, APFloat.roundingMode.rmTowardZero, /*AddrOf*/IsInexact);
            }
            
            Value /*P*/ GE = Builder.CreateFCmpOGT(Src, ConstantFP.get(VMContext, MinSrc));
            Value /*P*/ LE = Builder.CreateFCmpOLT(Src, ConstantFP.get(VMContext, MaxSrc));
            Check = Builder.CreateAnd(GE, LE);
          } else {
            // FIXME: Maybe split this sanitizer out from float-cast-overflow.
            //
            // Floating-point to floating-point. This has undefined behavior if the
            // source is not in the range of representable values of the destination
            // type. The C and C++ standards are spectacularly unclear here. We
            // diagnose finite out-of-range conversions, but allow infinities and NaNs
            // to convert to the corresponding value in the smaller type.
            //
            // C11 Annex F gives all such conversions defined behavior for IEC 60559
            // conforming implementations. Unfortunately, LLVM's fptrunc instruction
            // does not.
            
            // Converting from a lower rank to a higher rank can never have
            // undefined behavior, since higher-rank types must have a superset
            // of values of lower-rank types.
            if (CGF.getContext().getFloatingTypeOrder(new QualType(OrigSrcType), new QualType(DstType)) != 1) {
              return;
            }
            assert (!OrigSrcType.$arrow().isHalfType()) : "should not check conversion from __half, it has the lowest rank";
            
            final /*const*/ fltSemantics /*&*/ DstSema = CGF.getContext().getFloatTypeSemantics(new QualType(DstType));
            APFloat MinBad = APFloat.getLargest(DstSema, false);
            APFloat MaxBad = APFloat.getInf(DstSema, false);
            
            bool$ptr IsInexact = create_bool$ptr();
            MinBad.convert(SrcSema, APFloat.roundingMode.rmTowardZero, /*AddrOf*/IsInexact);
            MaxBad.convert(SrcSema, APFloat.roundingMode.rmTowardZero, /*AddrOf*/IsInexact);
            
            Value /*P*/ AbsSrc = CGF.EmitNounwindRuntimeCall(CGF.CGM.getIntrinsic(ID.fabs, new ArrayRef<Type /*P*/ >(Src.getType(), true)), new ArrayRef<Value /*P*/ >(Src, true));
            Value /*P*/ GE = Builder.CreateFCmpOGT(AbsSrc, ConstantFP.get(VMContext, MinBad));
            Value /*P*/ LE = Builder.CreateFCmpOLT(AbsSrc, ConstantFP.get(VMContext, MaxBad));
            Check = Builder.CreateNot(Builder.CreateAnd(GE, LE));
          }
        }
      }
      
      Constant /*P*/ StaticArgs[/*3*/] = new Constant /*P*/  [/*3*/] {
        CGF.EmitCheckSourceLocation(new SourceLocation(Loc)), 
        CGF.EmitCheckTypeDescriptor(new QualType(OrigSrcType)), 
        CGF.EmitCheckTypeDescriptor(new QualType(DstType))};
        CGF.EmitCheck(new ArrayRef<std.pairPtrULong<Value /*P*/ >>(std.make_pair_Ptr_ulong(Check, SanitizerKind.FloatCastOverflow), false), 
          new StringRef(/*KEEP_STR*/"float_cast_overflow"), new ArrayRef<Constant /*P*/ >(StaticArgs, true), new ArrayRef<Value /*P*/ >(OrigSrc, true));
    } finally {
      if (SanScope != null) { SanScope.$destroy(); }
    }
  }

  
  /// Emit a conversion from the specified type to the specified destination
  /// type, both of which are LLVM scalar types.
  
  /// Emit a conversion from the specified type to the specified destination type,
  /// both of which are LLVM scalar types.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::EmitScalarConversion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 732,
   FQN="(anonymous namespace)::ScalarExprEmitter::EmitScalarConversion", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter20EmitScalarConversionEPN4llvm5ValueEN5clang8QualTypeES5_NS4_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter20EmitScalarConversionEPN4llvm5ValueEN5clang8QualTypeES5_NS4_14SourceLocationE")
  //</editor-fold>
  public Value /*P*/ EmitScalarConversion(Value /*P*/ Src, QualType SrcType, 
                      QualType DstType, 
                      SourceLocation Loc) {
    return EmitScalarConversion(Src, new QualType(SrcType), new QualType(DstType), new SourceLocation(Loc), false);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::EmitScalarConversion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 738,
   FQN="(anonymous namespace)::ScalarExprEmitter::EmitScalarConversion", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter20EmitScalarConversionEPN4llvm5ValueEN5clang8QualTypeES5_NS4_14SourceLocationEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter20EmitScalarConversionEPN4llvm5ValueEN5clang8QualTypeES5_NS4_14SourceLocationEb")
  //</editor-fold>
  public Value /*P*/ EmitScalarConversion(Value /*P*/ Src, QualType SrcType, 
                      QualType DstType, 
                      SourceLocation Loc, 
                      boolean TreatBooleanAsSigned) {
    SrcType.$assignMove(CGF.getContext().getCanonicalType(/*NO_COPY*/SrcType).$QualType());
    DstType.$assignMove(CGF.getContext().getCanonicalType(/*NO_COPY*/DstType).$QualType());
    if (QualType.$eq_QualType$C(SrcType, DstType)) {
      return Src;
    }
    if (DstType.$arrow().isVoidType()) {
      return null;
    }
    
    Value /*P*/ OrigSrc = Src;
    QualType OrigSrcType = new QualType(SrcType);
    Type /*P*/ SrcTy = Src.getType();
    
    // Handle conversions to bool first, they are special: comparisons against 0.
    if (DstType.$arrow().isBooleanType()) {
      return EmitConversionToBool(Src, new QualType(SrcType));
    }
    
    Type /*P*/ DstTy = ConvertType(new QualType(DstType));
    
    // Cast from half through float if half isn't a native type.
    if (SrcType.$arrow().isHalfType() && !CGF.getContext().getLangOpts().NativeHalfType) {
      // Cast to FP using the intrinsic if the half type itself isn't supported.
      if (DstTy.isFloatingPointTy()) {
        if (!CGF.getContext().getLangOpts().HalfArgsAndReturns) {
          return Builder.CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P(CGF.CGM.getIntrinsic(ID.convert_from_fp16, new ArrayRef<Type /*P*/ >(DstTy, true)), 
              new ArrayRef<Value /*P*/ >(Src, true));
        }
      } else {
        // Cast to other types through float, using either the intrinsic or FPExt,
        // depending on whether the half type itself is supported
        // (as opposed to operations on half, available with NativeHalfType).
        if (!CGF.getContext().getLangOpts().HalfArgsAndReturns) {
          Src = Builder.CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P(CGF.CGM.getIntrinsic(ID.convert_from_fp16, 
                  new ArrayRef<Type /*P*/ >(CGF.CGM.FloatTy, true)), 
              new ArrayRef<Value /*P*/ >(Src, true));
        } else {
          Src = Builder.CreateFPExt(Src, CGF.CGM.FloatTy, new Twine(/*KEEP_STR*/"conv"));
        }
        SrcType.$assignMove(CGF.getContext().FloatTy.$QualType());
        SrcTy = CGF.FloatTy;
      }
    }
    
    // Ignore conversions like int -> uint.
    if (SrcTy == DstTy) {
      return Src;
    }
    
    // Handle pointer conversions next: pointers can only be converted to/from
    // other pointers and integers. Check for pointer types in terms of LLVM, as
    // some native types (like Obj-C id) may map to a pointer type.
    if (isa_PointerType(DstTy)) {
      // The source value may be an integer, or a pointer.
      if (isa_PointerType(SrcTy)) {
        return Builder.CreateBitCast(Src, DstTy, new Twine(/*KEEP_STR*/"conv"));
      }
      assert (SrcType.$arrow().isIntegerType()) : "Not ptr->ptr or int->ptr conversion?";
      // First, convert to the correct width so that we control the kind of
      // extension.
      Type /*P*/ MiddleTy = CGF.Unnamed_field8.IntPtrTy;
      boolean InputSigned = SrcType.$arrow().isSignedIntegerOrEnumerationType();
      Value /*P*/ IntResult = Builder.CreateIntCast(Src, MiddleTy, InputSigned, new Twine(/*KEEP_STR*/"conv"));
      // Then, cast to pointer.
      return Builder.CreateIntToPtr(IntResult, DstTy, new Twine(/*KEEP_STR*/"conv"));
    }
    if (isa_PointerType(SrcTy)) {
      // Must be an ptr to int cast.
      assert (isa_IntegerType(DstTy)) : "not ptr->int?";
      return Builder.CreatePtrToInt(Src, DstTy, new Twine(/*KEEP_STR*/"conv"));
    }
    
    // A scalar can be splatted to an extended vector of the same element type
    if (DstType.$arrow().isExtVectorType() && !SrcType.$arrow().isVectorType()) {
      // Sema should add casts to make sure that the source expression's type is
      // the same as the vector's element type (sans qualifiers)
      assert (DstType.$arrow().castAs(ExtVectorType.class).getElementType().getTypePtr() == SrcType.getTypePtr()) : "Splatted expr doesn't match with vector element type?";
      
      // Splat the element across to all elements
      /*uint*/int NumElements = DstTy.getVectorNumElements();
      return Builder.CreateVectorSplat(NumElements, Src, new Twine(/*KEEP_STR*/"splat"));
    }
    
    // Allow bitcast from vector to integer/fp of the same size.
    if (isa_VectorType(SrcTy)
       || isa_VectorType(DstTy)) {
      return Builder.CreateBitCast(Src, DstTy, new Twine(/*KEEP_STR*/"conv"));
    }
    
    // Finally, we have the arithmetic types: real int/float.
    Value /*P*/ Res = null;
    Type /*P*/ ResTy = DstTy;
    
    // An overflowing conversion has undefined behavior if either the source type
    // or the destination type is a floating-point type.
    if (CGF.SanOpts.has(SanitizerKind.FloatCastOverflow)
       && (OrigSrcType.$arrow().isFloatingType() || DstType.$arrow().isFloatingType())) {
      EmitFloatConversionCheck(OrigSrc, new QualType(OrigSrcType), Src, new QualType(SrcType), new QualType(DstType), DstTy, 
          new SourceLocation(Loc));
    }
    
    // Cast to half through float if half isn't a native type.
    if (DstType.$arrow().isHalfType() && !CGF.getContext().getLangOpts().NativeHalfType) {
      // Make sure we cast in a single step if from another FP type.
      if (SrcTy.isFloatingPointTy()) {
        // Use the intrinsic if the half type itself isn't supported
        // (as opposed to operations on half, available with NativeHalfType).
        if (!CGF.getContext().getLangOpts().HalfArgsAndReturns) {
          return Builder.CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P(CGF.CGM.getIntrinsic(ID.convert_to_fp16, new ArrayRef<Type /*P*/ >(SrcTy, true)), new ArrayRef<Value /*P*/ >(Src, true));
        }
        // If the half type is supported, just use an fptrunc.
        return Builder.CreateFPTrunc(Src, DstTy);
      }
      DstTy = CGF.FloatTy;
    }
    if (isa_IntegerType(SrcTy)) {
      boolean InputSigned = SrcType.$arrow().isSignedIntegerOrEnumerationType();
      if (SrcType.$arrow().isBooleanType() && TreatBooleanAsSigned) {
        InputSigned = true;
      }
      if (isa_IntegerType(DstTy)) {
        Res = Builder.CreateIntCast(Src, DstTy, InputSigned, new Twine(/*KEEP_STR*/"conv"));
      } else if (InputSigned) {
        Res = Builder.CreateSIToFP(Src, DstTy, new Twine(/*KEEP_STR*/"conv"));
      } else {
        Res = Builder.CreateUIToFP(Src, DstTy, new Twine(/*KEEP_STR*/"conv"));
      }
    } else if (isa_IntegerType(DstTy)) {
      assert (SrcTy.isFloatingPointTy()) : "Unknown real conversion";
      if (DstType.$arrow().isSignedIntegerOrEnumerationType()) {
        Res = Builder.CreateFPToSI(Src, DstTy, new Twine(/*KEEP_STR*/"conv"));
      } else {
        Res = Builder.CreateFPToUI(Src, DstTy, new Twine(/*KEEP_STR*/"conv"));
      }
    } else {
      assert (SrcTy.isFloatingPointTy() && DstTy.isFloatingPointTy()) : "Unknown real conversion";
      if (DstTy.getTypeID().getValue() < SrcTy.getTypeID().getValue()) {
        Res = Builder.CreateFPTrunc(Src, DstTy, new Twine(/*KEEP_STR*/"conv"));
      } else {
        Res = Builder.CreateFPExt(Src, DstTy, new Twine(/*KEEP_STR*/"conv"));
      }
    }
    if (DstTy != ResTy) {
      if (!CGF.getContext().getLangOpts().HalfArgsAndReturns) {
        assert (ResTy.isIntegerTy(16)) : "Only half FP requires extra conversion";
        Res = Builder.CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P(CGF.CGM.getIntrinsic(ID.convert_to_fp16, new ArrayRef<Type /*P*/ >(CGF.CGM.FloatTy, true)), 
            new ArrayRef<Value /*P*/ >(Res, true));
      } else {
        Res = Builder.CreateFPTrunc(Res, ResTy, new Twine(/*KEEP_STR*/"conv"));
      }
    }
    
    return Res;
  }

  
  /// Emit a conversion from the specified complex type to the specified
  /// destination type, where the destination type is an LLVM scalar type.
  
  /// Emit a conversion from the specified complex type to the specified
  /// destination type, where the destination type is an LLVM scalar type.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::EmitComplexToScalarConversion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 898,
   FQN="(anonymous namespace)::ScalarExprEmitter::EmitComplexToScalarConversion", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter29EmitComplexToScalarConversionESt4pairIPN4llvm5ValueES4_EN5clang8QualTypeES7_NS6_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter29EmitComplexToScalarConversionESt4pairIPN4llvm5ValueES4_EN5clang8QualTypeES7_NS6_14SourceLocationE")
  //</editor-fold>
  public Value /*P*/ EmitComplexToScalarConversion(std.pair<Value /*P*/ , Value /*P*/ > Src, QualType SrcTy, QualType DstTy, 
                               SourceLocation Loc) {
    // Get the source element type.
    SrcTy.$assignMove(SrcTy.$arrow().castAs(ComplexType.class).getElementType());
    
    // Handle conversions to bool first, they are special: comparisons against 0.
    if (DstTy.$arrow().isBooleanType()) {
      //  Complex != 0  -> (Real != 0) | (Imag != 0)
      Src.first = EmitScalarConversion(Src.first, new QualType(SrcTy), new QualType(DstTy), new SourceLocation(Loc));
      Src.second = EmitScalarConversion(Src.second, new QualType(SrcTy), new QualType(DstTy), new SourceLocation(Loc));
      return Builder.CreateOr(Src.first, Src.second, new Twine(/*KEEP_STR*/"tobool"));
    }
    
    // C99 6.3.1.7p2: "When a value of complex type is converted to a real type,
    // the imaginary part of the complex value is discarded and the value of the
    // real part is converted according to the conversion rules for the
    // corresponding real type.
    return EmitScalarConversion(Src.first, new QualType(SrcTy), new QualType(DstTy), new SourceLocation(Loc));
  }

  
  /// EmitNullValue - Emit a value that corresponds to null for the given type.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::EmitNullValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 919,
   FQN="(anonymous namespace)::ScalarExprEmitter::EmitNullValue", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter13EmitNullValueEN5clang8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter13EmitNullValueEN5clang8QualTypeE")
  //</editor-fold>
  public Value /*P*/ EmitNullValue(QualType Ty) {
    return CGF.EmitFromMemory(CGF.CGM.EmitNullConstant(new QualType(Ty)), new QualType(Ty));
  }

  
  /// EmitFloatToBoolConversion - Perform an FP to boolean conversion.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::EmitFloatToBoolConversion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 167,
   FQN="(anonymous namespace)::ScalarExprEmitter::EmitFloatToBoolConversion", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter25EmitFloatToBoolConversionEPN4llvm5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter25EmitFloatToBoolConversionEPN4llvm5ValueE")
  //</editor-fold>
  public Value /*P*/ EmitFloatToBoolConversion(Value /*P*/ V) {
    // Compare against 0.0 for fp scalars.
    Value /*P*/ Zero = Constant.getNullValue(V.getType());
    return Builder.CreateFCmpUNE(V, Zero, new Twine(/*KEEP_STR*/"tobool"));
  }

  
  /// EmitPointerToBoolConversion - Perform a pointer to boolean conversion.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::EmitPointerToBoolConversion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 174,
   FQN="(anonymous namespace)::ScalarExprEmitter::EmitPointerToBoolConversion", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter27EmitPointerToBoolConversionEPN4llvm5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter27EmitPointerToBoolConversionEPN4llvm5ValueE")
  //</editor-fold>
  public Value /*P*/ EmitPointerToBoolConversion(Value /*P*/ V) {
    Value /*P*/ Zero = ConstantPointerNull.get(cast_PointerType(V.getType()));
    return Builder.CreateICmpNE(V, Zero, new Twine(/*KEEP_STR*/"tobool"));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::EmitIntToBoolConversion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 180,
   FQN="(anonymous namespace)::ScalarExprEmitter::EmitIntToBoolConversion", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter23EmitIntToBoolConversionEPN4llvm5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter23EmitIntToBoolConversionEPN4llvm5ValueE")
  //</editor-fold>
  public Value /*P*/ EmitIntToBoolConversion(Value /*P*/ V) {
    {
      // Because of the type rules of C, we often end up computing a
      // logical value, then zero extending it to int, then wanting it
      // as a logical value again.  Optimize this common case.
      ZExtInst /*P*/ ZI = dyn_cast_ZExtInst(V);
      if ((ZI != null)) {
        if (ZI.getOperand(0).getType() == Builder.getInt1Ty()) {
          Value /*P*/ Result = ZI.getOperand(0);
          // If there aren't any more uses, zap the instruction to save space.
          // Note that there can be more uses, for example if this
          // is the result of an assignment.
          if (ZI.use_empty()) {
            ZI.eraseFromParent();
          }
          return Result;
        }
      }
    }
    
    return Builder.CreateIsNotNull(V, new Twine(/*KEEP_STR*/"tobool"));
  }

  
  //===--------------------------------------------------------------------===//
  //                            Visitor Methods
  //===--------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::Visit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 203,
   FQN="(anonymous namespace)::ScalarExprEmitter::Visit", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter5VisitEPN5clang4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter5VisitEPN5clang4ExprE")
  //</editor-fold>
  public Value /*P*/ Visit(Expr /*P*/ E) {
    ApplyDebugLocation DL = null;
    try {
      DL/*J*/= new ApplyDebugLocation(CGF, E);
      return StmtVisitor.super.Visit(E);
    } finally {
      if (DL != null) { DL.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::VisitStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 208,
   FQN="(anonymous namespace)::ScalarExprEmitter::VisitStmt", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter9VisitStmtEPN5clang4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter9VisitStmtEPN5clang4StmtE")
  //</editor-fold>
  public Value /*P*/ VisitStmt(Stmt /*P*/ S) {
    S.dump(CGF.getContext().getSourceManager());
    throw new llvm_unreachable("Stmt can't have complex result type!");
  }

  
  //===----------------------------------------------------------------------===//
  //                            Visitor Methods
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::VisitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 978,
   FQN="(anonymous namespace)::ScalarExprEmitter::VisitExpr", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter9VisitExprEPN5clang4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter9VisitExprEPN5clang4ExprE")
  //</editor-fold>
  public Value /*P*/ VisitExpr(Expr /*P*/ E) {
    CGF.ErrorUnsupported(E, $("scalar expression"));
    if (E.getType().$arrow().isVoidType()) {
      return null;
    }
    return UndefValue.get(CGF.ConvertType(E.getType()));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::VisitParenExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 214,
   FQN="(anonymous namespace)::ScalarExprEmitter::VisitParenExpr", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter14VisitParenExprEPN5clang9ParenExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter14VisitParenExprEPN5clang9ParenExprE")
  //</editor-fold>
  public Value /*P*/ VisitParenExpr(ParenExpr /*P*/ PE) {
    return Visit(PE.getSubExpr());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::VisitSubstNonTypeTemplateParmExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 217,
   FQN="(anonymous namespace)::ScalarExprEmitter::VisitSubstNonTypeTemplateParmExpr", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter33VisitSubstNonTypeTemplateParmExprEPN5clang28SubstNonTypeTemplateParmExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter33VisitSubstNonTypeTemplateParmExprEPN5clang28SubstNonTypeTemplateParmExprE")
  //</editor-fold>
  public Value /*P*/ VisitSubstNonTypeTemplateParmExpr(SubstNonTypeTemplateParmExpr /*P*/ E) {
    return Visit(E.getReplacement());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::VisitGenericSelectionExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 220,
   FQN="(anonymous namespace)::ScalarExprEmitter::VisitGenericSelectionExpr", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter25VisitGenericSelectionExprEPN5clang20GenericSelectionExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter25VisitGenericSelectionExprEPN5clang20GenericSelectionExprE")
  //</editor-fold>
  public Value /*P*/ VisitGenericSelectionExpr(GenericSelectionExpr /*P*/ GE) {
    return Visit(GE.getResultExpr());
  }

  
  // Leaves.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::VisitIntegerLiteral">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 225,
   FQN="(anonymous namespace)::ScalarExprEmitter::VisitIntegerLiteral", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter19VisitIntegerLiteralEPKN5clang14IntegerLiteralE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter19VisitIntegerLiteralEPKN5clang14IntegerLiteralE")
  //</editor-fold>
  public Value /*P*/ VisitIntegerLiteral(/*const*/ IntegerLiteral /*P*/ E) {
    return Builder.getInt(E.getValue());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::VisitFloatingLiteral">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 228,
   FQN="(anonymous namespace)::ScalarExprEmitter::VisitFloatingLiteral", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter20VisitFloatingLiteralEPKN5clang15FloatingLiteralE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter20VisitFloatingLiteralEPKN5clang15FloatingLiteralE")
  //</editor-fold>
  public Value /*P*/ VisitFloatingLiteral(/*const*/ FloatingLiteral /*P*/ E) {
    return ConstantFP.get(VMContext, E.getValue());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::VisitCharacterLiteral">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 231,
   FQN="(anonymous namespace)::ScalarExprEmitter::VisitCharacterLiteral", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter21VisitCharacterLiteralEPKN5clang16CharacterLiteralE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter21VisitCharacterLiteralEPKN5clang16CharacterLiteralE")
  //</editor-fold>
  public Value /*P*/ VisitCharacterLiteral(/*const*/ CharacterLiteral /*P*/ E) {
    return ConstantInt.get(ConvertType(E.getType()), $uint2ulong(E.getValue()));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::VisitObjCBoolLiteralExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 234,
   FQN="(anonymous namespace)::ScalarExprEmitter::VisitObjCBoolLiteralExpr", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter24VisitObjCBoolLiteralExprEPKN5clang19ObjCBoolLiteralExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter24VisitObjCBoolLiteralExprEPKN5clang19ObjCBoolLiteralExprE")
  //</editor-fold>
  public Value /*P*/ VisitObjCBoolLiteralExpr(/*const*/ ObjCBoolLiteralExpr /*P*/ E) {
    return ConstantInt.get(ConvertType(E.getType()), (E.getValue() ? 1 : 0));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::VisitCXXBoolLiteralExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 237,
   FQN="(anonymous namespace)::ScalarExprEmitter::VisitCXXBoolLiteralExpr", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter23VisitCXXBoolLiteralExprEPKN5clang18CXXBoolLiteralExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter23VisitCXXBoolLiteralExprEPKN5clang18CXXBoolLiteralExprE")
  //</editor-fold>
  public Value /*P*/ VisitCXXBoolLiteralExpr(/*const*/ CXXBoolLiteralExpr /*P*/ E) {
    return ConstantInt.get(ConvertType(E.getType()), (E.getValue() ? 1 : 0));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::VisitCXXScalarValueInitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 240,
   FQN="(anonymous namespace)::ScalarExprEmitter::VisitCXXScalarValueInitExpr", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter27VisitCXXScalarValueInitExprEPKN5clang22CXXScalarValueInitExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter27VisitCXXScalarValueInitExprEPKN5clang22CXXScalarValueInitExprE")
  //</editor-fold>
  public Value /*P*/ VisitCXXScalarValueInitExpr(/*const*/ CXXScalarValueInitExpr /*P*/ E) {
    return EmitNullValue(E.getType());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::VisitGNUNullExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 243,
   FQN="(anonymous namespace)::ScalarExprEmitter::VisitGNUNullExpr", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter16VisitGNUNullExprEPKN5clang11GNUNullExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter16VisitGNUNullExprEPKN5clang11GNUNullExprE")
  //</editor-fold>
  public Value /*P*/ VisitGNUNullExpr(/*const*/ GNUNullExpr /*P*/ E) {
    return EmitNullValue(E.getType());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::VisitOffsetOfExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 1902,
   FQN="(anonymous namespace)::ScalarExprEmitter::VisitOffsetOfExpr", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter17VisitOffsetOfExprEPN5clang12OffsetOfExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter17VisitOffsetOfExprEPN5clang12OffsetOfExprE")
  //</editor-fold>
  public Value /*P*/ VisitOffsetOfExpr(OffsetOfExpr /*P*/ E) {
    // Try folding the offsetof to a constant.
    APSInt Value/*J*/= new APSInt();
    if (E.EvaluateAsInt(Value, CGF.getContext())) {
      return Builder.getInt(Value);
    }
    
    // Loop over the components of the offsetof to compute the value.
    /*uint*/int n = E.getNumComponents();
    Type /*P*/ ResultType = ConvertType(E.getType());
    Value /*P*/ Result = Constant.getNullValue(ResultType);
    QualType CurrentType = E.getTypeSourceInfo().getType();
    for (/*uint*/int i = 0; i != n; ++i) {
      OffsetOfNode ON = new OffsetOfNode(E.getComponent(i));
      Value /*P*/ Offset = null;
      switch (ON.getKind()) {
       case OffsetOfNode.Kind.Array:
        {
          // Compute the index
          Expr /*P*/ IdxExpr = E.getIndexExpr(ON.getArrayExprIndex());
          Value /*P*/ Idx = CGF.EmitScalarExpr(IdxExpr);
          boolean IdxSigned = IdxExpr.getType().$arrow().isSignedIntegerOrEnumerationType();
          Idx = Builder.CreateIntCast(Idx, ResultType, IdxSigned, new Twine(/*KEEP_STR*/"conv"));
          
          // Save the element type
          CurrentType.$assignMove(
              CGF.getContext().getAsArrayType(new QualType(CurrentType)).getElementType()
          );
          
          // Compute the element size
          Value /*P*/ ElemSize = ConstantInt.get(ResultType, 
              CGF.getContext().getTypeSizeInChars(/*NO_COPY*/CurrentType).getQuantity());
          
          // Multiply out to compute the result
          Offset = Builder.CreateMul(Idx, ElemSize);
          break;
        }
       case OffsetOfNode.Kind.Field:
        {
          FieldDecl /*P*/ MemberDecl = ON.getField();
          RecordDecl /*P*/ RD = CurrentType.$arrow().getAs$RecordType().getDecl();
          final /*const*/ ASTRecordLayout /*&*/ RL = CGF.getContext().getASTRecordLayout(RD);
          
          // Compute the index of the field in its parent.
          /*uint*/int i$1 = 0;
          // FIXME: It would be nice if we didn't have to loop here!
          for (specific_decl_iterator<FieldDecl> Field = RD.field_begin(), 
              FieldEnd = RD.field_end();
               specific_decl_iterator.$noteq_specific_decl_iterator$SpecificDecl$C(Field, FieldEnd); Field.$preInc() , ++i$1) {
            if (Field.$star() == MemberDecl) {
              break;
            }
          }
          assert ($less_uint(i$1, RL.getFieldCount())) : "offsetof field in wrong type";
          
          // Compute the offset to the field
          long/*int64_t*/ OffsetInt = $div_ulong(RL.getFieldOffset(i$1)
            , CGF.getContext().getCharWidth());
          Offset = ConstantInt.get(ResultType, OffsetInt);
          
          // Save the element type.
          CurrentType.$assignMove(MemberDecl.getType());
          break;
        }
       case OffsetOfNode.Kind.Identifier:
        throw new llvm_unreachable("dependent __builtin_offsetof");
       case OffsetOfNode.Kind.Base:
        {
          if (ON.getBase().isVirtual()) {
            CGF.ErrorUnsupported(E, $("virtual base in offsetof"));
            continue;
          }
          
          RecordDecl /*P*/ RD = CurrentType.$arrow().getAs$RecordType().getDecl();
          final /*const*/ ASTRecordLayout /*&*/ RL = CGF.getContext().getASTRecordLayout(RD);
          
          // Save the element type.
          CurrentType.$assignMove(ON.getBase().getType());
          
          // Compute the offset to the base.
          /*const*/ RecordType /*P*/ BaseRT = CurrentType.$arrow().getAs$RecordType();
          CXXRecordDecl /*P*/ BaseRD = cast_CXXRecordDecl(BaseRT.getDecl());
          CharUnits OffsetInt = RL.getBaseClassOffset(BaseRD);
          Offset = ConstantInt.get(ResultType, OffsetInt.getQuantity());
          break;
        }
      }
      Result = Builder.CreateAdd(Result, Offset);
    }
    return Result;
  }

  
  /// VisitUnaryExprOrTypeTraitExpr - Return the size or alignment of the type of
  /// argument of the sizeof expression as an integer.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::VisitUnaryExprOrTypeTraitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 1993,
   FQN="(anonymous namespace)::ScalarExprEmitter::VisitUnaryExprOrTypeTraitExpr", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter29VisitUnaryExprOrTypeTraitExprEPKN5clang24UnaryExprOrTypeTraitExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter29VisitUnaryExprOrTypeTraitExprEPKN5clang24UnaryExprOrTypeTraitExprE")
  //</editor-fold>
  public Value /*P*/ VisitUnaryExprOrTypeTraitExpr(/*const*/ UnaryExprOrTypeTraitExpr /*P*/ E) {
    QualType TypeToSize = E.getTypeOfArgument();
    if (E.getKind() == UnaryExprOrTypeTrait.UETT_SizeOf) {
      {
        /*const*/ VariableArrayType /*P*/ VAT = CGF.getContext().getAsVariableArrayType(new QualType(TypeToSize));
        if ((VAT != null)) {
          if (E.isArgumentType()) {
            // sizeof(type) - make sure to emit the VLA size.
            CGF.EmitVariablyModifiedType(new QualType(TypeToSize));
          } else {
            // C99 6.5.3.4p2: If the argument is an expression of type
            // VLA, it is evaluated.
            CGF.EmitIgnoredExpr(E.getArgumentExpr$Const());
          }
          
          QualType eltType/*J*/= new QualType();
          Value /*P*/ numElts = null;
          pair<Value, QualType> vlaSize = CGF.getVLASize(VAT);
          numElts = vlaSize.first;
          eltType = vlaSize.second;
          
          Value /*P*/ size = numElts;
          
          // Scale the number of non-VLA elements by the non-VLA element size.
          CharUnits eltSize = CGF.getContext().getTypeSizeInChars(/*NO_COPY*/eltType);
          if (!eltSize.isOne()) {
            size = CGF.Builder.CreateNUWMul(CGF.CGM.getSize(new CharUnits(eltSize)), numElts);
          }
          
          return size;
        }
      }
    } else if (E.getKind() == UnaryExprOrTypeTrait.UETT_OpenMPRequiredSimdAlign) {
      long/*int64_t*/ Alignment = CGF.getContext().
          toCharUnitsFromBits($uint2long(CGF.getContext().getOpenMPDefaultSimdAlign(E.getTypeOfArgument().$arrow().getPointeeType()))).
          getQuantity();
      return ConstantInt.get(CGF.Unnamed_field8.SizeTy, Alignment);
    }
    
    // If this isn't sizeof(vla), the result must be constant; use the constant
    // folding logic so we don't have to duplicate it here.
    return Builder.getInt(E.EvaluateKnownConstInt(CGF.getContext()));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::VisitAddrLabelExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 248,
   FQN="(anonymous namespace)::ScalarExprEmitter::VisitAddrLabelExpr", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter18VisitAddrLabelExprEPKN5clang13AddrLabelExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter18VisitAddrLabelExprEPKN5clang13AddrLabelExprE")
  //</editor-fold>
  public Value /*P*/ VisitAddrLabelExpr(/*const*/ AddrLabelExpr /*P*/ E) {
    Value /*P*/ V = CGF.GetAddrOfLabel(E.getLabel());
    return Builder.CreateBitCast(V, ConvertType(E.getType()));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::VisitSizeOfPackExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 253,
   FQN="(anonymous namespace)::ScalarExprEmitter::VisitSizeOfPackExpr", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter19VisitSizeOfPackExprEPN5clang14SizeOfPackExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter19VisitSizeOfPackExprEPN5clang14SizeOfPackExprE")
  //</editor-fold>
  public Value /*P*/ VisitSizeOfPackExpr(SizeOfPackExpr /*P*/ E) {
    return ConstantInt.get(ConvertType(E.getType()), $uint2ulong(E.getPackLength()));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::VisitPseudoObjectExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 257,
   FQN="(anonymous namespace)::ScalarExprEmitter::VisitPseudoObjectExpr", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter21VisitPseudoObjectExprEPN5clang16PseudoObjectExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter21VisitPseudoObjectExprEPN5clang16PseudoObjectExprE")
  //</editor-fold>
  public Value /*P*/ VisitPseudoObjectExpr(PseudoObjectExpr /*P*/ E) {
    return CGF.EmitPseudoObjectRValue(E).getScalarVal();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::VisitOpaqueValueExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 261,
   FQN="(anonymous namespace)::ScalarExprEmitter::VisitOpaqueValueExpr", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter20VisitOpaqueValueExprEPN5clang15OpaqueValueExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter20VisitOpaqueValueExprEPN5clang15OpaqueValueExprE")
  //</editor-fold>
  public Value /*P*/ VisitOpaqueValueExpr(OpaqueValueExpr /*P*/ E) {
    if (E.isGLValue()) {
      return EmitLoadOfLValue(new LValue(CGF.getOpaqueLValueMapping(E)), E.getExprLoc());
    }
    
    // Otherwise, assume the mapping is the scalar directly.
    return CGF.getOpaqueRValueMapping(E).getScalarVal();
  }

  
  // l-values.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::VisitDeclRefExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 270,
   FQN="(anonymous namespace)::ScalarExprEmitter::VisitDeclRefExpr", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter16VisitDeclRefExprEPN5clang11DeclRefExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter16VisitDeclRefExprEPN5clang11DeclRefExprE")
  //</editor-fold>
  public Value /*P*/ VisitDeclRefExpr(DeclRefExpr /*P*/ E) {
    {
      CodeGenFunction.ConstantEmission result = CGF.tryEmitAsConstant(E);
      if (result.$bool()) {
        if (result.isReference()) {
          return EmitLoadOfLValue(result.getReferenceLValue(CGF, E), 
              E.getExprLoc());
        }
        return result.getValue();
      }
    }
    return EmitLoadOfLValue(E);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::VisitObjCSelectorExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 280,
   FQN="(anonymous namespace)::ScalarExprEmitter::VisitObjCSelectorExpr", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter21VisitObjCSelectorExprEPN5clang16ObjCSelectorExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter21VisitObjCSelectorExprEPN5clang16ObjCSelectorExprE")
  //</editor-fold>
  public Value /*P*/ VisitObjCSelectorExpr(ObjCSelectorExpr /*P*/ E) {
    return CGF.EmitObjCSelectorExpr(E);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::VisitObjCProtocolExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 283,
   FQN="(anonymous namespace)::ScalarExprEmitter::VisitObjCProtocolExpr", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter21VisitObjCProtocolExprEPN5clang16ObjCProtocolExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter21VisitObjCProtocolExprEPN5clang16ObjCProtocolExprE")
  //</editor-fold>
  public Value /*P*/ VisitObjCProtocolExpr(ObjCProtocolExpr /*P*/ E) {
    return CGF.EmitObjCProtocolExpr(E);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::VisitObjCIvarRefExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 286,
   FQN="(anonymous namespace)::ScalarExprEmitter::VisitObjCIvarRefExpr", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter20VisitObjCIvarRefExprEPN5clang15ObjCIvarRefExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter20VisitObjCIvarRefExprEPN5clang15ObjCIvarRefExprE")
  //</editor-fold>
  public Value /*P*/ VisitObjCIvarRefExpr(ObjCIvarRefExpr /*P*/ E) {
    return EmitLoadOfLValue(E);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::VisitObjCMessageExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 289,
   FQN="(anonymous namespace)::ScalarExprEmitter::VisitObjCMessageExpr", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter20VisitObjCMessageExprEPN5clang15ObjCMessageExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter20VisitObjCMessageExprEPN5clang15ObjCMessageExprE")
  //</editor-fold>
  public Value /*P*/ VisitObjCMessageExpr(ObjCMessageExpr /*P*/ E) {
    if ((E.getMethodDecl() != null)
       && E.getMethodDecl().getReturnType().$arrow().isReferenceType()) {
      return EmitLoadOfLValue(E);
    }
    return CGF.EmitObjCMessageExpr(E).getScalarVal();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::VisitObjCIsaExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 296,
   FQN="(anonymous namespace)::ScalarExprEmitter::VisitObjCIsaExpr", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter16VisitObjCIsaExprEPN5clang11ObjCIsaExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter16VisitObjCIsaExprEPN5clang11ObjCIsaExprE")
  //</editor-fold>
  public Value /*P*/ VisitObjCIsaExpr(ObjCIsaExpr /*P*/ E) {
    LValue LV = CGF.EmitObjCIsaExpr(E);
    Value /*P*/ V = CGF.EmitLoadOfLValue(new LValue(LV), E.getExprLoc()).getScalarVal();
    return V;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::VisitArraySubscriptExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 1127,
   FQN="(anonymous namespace)::ScalarExprEmitter::VisitArraySubscriptExpr", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter23VisitArraySubscriptExprEPN5clang18ArraySubscriptExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter23VisitArraySubscriptExprEPN5clang18ArraySubscriptExprE")
  //</editor-fold>
  public Value /*P*/ VisitArraySubscriptExpr(ArraySubscriptExpr /*P*/ E) {
    TestAndClearIgnoreResultAssign();
    
    // Emit subscript expressions in rvalue context's.  For most cases, this just
    // loads the lvalue formed by the subscript expr.  However, we have to be
    // careful, because the base of a vector subscript is occasionally an rvalue,
    // so we can't get it as an lvalue.
    if (!E.getBase().getType().$arrow().isVectorType()) {
      return EmitLoadOfLValue(E);
    }
    
    // Handle the vector case.  The base must be a vector, the index must be an
    // integer value.
    Value /*P*/ Base = Visit(E.getBase());
    Value /*P*/ Idx = Visit(E.getIdx());
    QualType IdxTy = E.getIdx().getType();
    if (CGF.SanOpts.has(SanitizerKind.ArrayBounds)) {
      CGF.EmitBoundsCheck(E, E.getBase(), Idx, new QualType(IdxTy), /*Accessed*/ true);
    }
    
    return Builder.CreateExtractElement(Base, Idx, new Twine(/*KEEP_STR*/"vecext"));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::VisitShuffleVectorExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 985,
   FQN="(anonymous namespace)::ScalarExprEmitter::VisitShuffleVectorExpr", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter22VisitShuffleVectorExprEPN5clang17ShuffleVectorExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter22VisitShuffleVectorExprEPN5clang17ShuffleVectorExprE")
  //</editor-fold>
  public Value /*P*/ VisitShuffleVectorExpr(ShuffleVectorExpr /*P*/ E) {
    // Vector Mask Case
    if (E.getNumSubExprs() == 2) {
      Value /*P*/ LHS = CGF.EmitScalarExpr(E.getExpr(0));
      Value /*P*/ RHS = CGF.EmitScalarExpr(E.getExpr(1));
      Value /*P*/ Mask;
      
      VectorType /*P*/ LTy = cast_VectorType(LHS.getType());
      /*uint*/int LHSElts = LTy.getNumElements();
      
      Mask = RHS;
      
      VectorType /*P*/ MTy = cast_VectorType(Mask.getType());
      
      // Mask off the high bits of each shuffle index.
      Value /*P*/ MaskBits = ConstantInt.get(MTy, llvm.NextPowerOf2($uint2ulong(LHSElts - 1)) - $int2ullong(1));
      Mask = Builder.CreateAnd(Mask, MaskBits, new Twine(/*KEEP_STR*/"mask"));
      
      // newv = undef
      // mask = mask & maskbits
      // for each elt
      //   n = extract mask i
      //   x = extract val n
      //   newv = insert newv, x, i
      VectorType /*P*/ RTy = VectorType.get(LTy.getElementType(), 
          MTy.getNumElements());
      Value /*P*/ NewV = UndefValue.get(RTy);
      for (/*uint*/int i = 0, e = MTy.getNumElements(); i != e; ++i) {
        Value /*P*/ IIndx = ConstantInt.get(CGF.Unnamed_field8.SizeTy, $uint2ulong(i));
        Value /*P*/ Indx = Builder.CreateExtractElement(Mask, IIndx, new Twine(/*KEEP_STR*/"shuf_idx"));
        
        Value /*P*/ VExt = Builder.CreateExtractElement(LHS, Indx, new Twine(/*KEEP_STR*/"shuf_elt"));
        NewV = Builder.CreateInsertElement(NewV, VExt, IIndx, new Twine(/*KEEP_STR*/"shuf_ins"));
      }
      return NewV;
    }
    
    Value /*P*/ V1 = CGF.EmitScalarExpr(E.getExpr(0));
    Value /*P*/ V2 = CGF.EmitScalarExpr(E.getExpr(1));
    
    SmallVector<Constant /*P*/ > indices/*J*/= new SmallVector<Constant /*P*/ >(32, (Constant /*P*/ )null);
    for (/*uint*/int i = 2; $less_uint(i, E.getNumSubExprs()); ++i) {
      APSInt Idx = E.getShuffleMaskIdx(CGF.getContext(), i - 2);
      // Check for -1 and output it as undef in the IR.
      if (Idx.isSigned() && Idx.isAllOnesValue()) {
        indices.push_back(UndefValue.get(CGF.Int32Ty));
      } else {
        indices.push_back(Builder.getInt32($ulong2uint(Idx.getZExtValue())));
      }
    }
    
    Value /*P*/ SV = ConstantVector.get(new ArrayRef<Constant /*P*/ >(indices, true));
    return Builder.CreateShuffleVector(V1, V2, SV, new Twine(/*KEEP_STR*/"shuffle"));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::VisitConvertVectorExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 1040,
   FQN="(anonymous namespace)::ScalarExprEmitter::VisitConvertVectorExpr", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter22VisitConvertVectorExprEPN5clang17ConvertVectorExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter22VisitConvertVectorExprEPN5clang17ConvertVectorExprE")
  //</editor-fold>
  public Value /*P*/ VisitConvertVectorExpr(ConvertVectorExpr /*P*/ E) {
    QualType SrcType = E.getSrcExpr().getType();
    QualType DstType = E.getType();
    
    Value /*P*/ Src = CGF.EmitScalarExpr(E.getSrcExpr());
    
    SrcType.$assignMove(CGF.getContext().getCanonicalType(/*NO_COPY*/SrcType).$QualType());
    DstType.$assignMove(CGF.getContext().getCanonicalType(/*NO_COPY*/DstType).$QualType());
    if (QualType.$eq_QualType$C(SrcType, DstType)) {
      return Src;
    }
    assert (SrcType.$arrow().isVectorType()) : "ConvertVector source type must be a vector";
    assert (DstType.$arrow().isVectorType()) : "ConvertVector destination type must be a vector";
    
    Type /*P*/ SrcTy = Src.getType();
    Type /*P*/ DstTy = ConvertType(new QualType(DstType));
    
    // Ignore conversions like int -> uint.
    if (SrcTy == DstTy) {
      return Src;
    }
    
    QualType SrcEltType = SrcType.$arrow().getAs(org.clang.ast.VectorType.class).getElementType();
    QualType DstEltType = DstType.$arrow().getAs(org.clang.ast.VectorType.class).getElementType();
    assert (SrcTy.isVectorTy()) : "ConvertVector source IR type must be a vector";
    assert (DstTy.isVectorTy()) : "ConvertVector destination IR type must be a vector";
    
    Type /*P*/ SrcEltTy = SrcTy.getVectorElementType();
    Type /*P*/ DstEltTy = DstTy.getVectorElementType();
    if (DstEltType.$arrow().isBooleanType()) {
      assert ((SrcEltTy.isFloatingPointTy() || isa_IntegerType(SrcEltTy))) : "Unknown boolean conversion";
      
      Value /*P*/ Zero = Constant.getNullValue(SrcTy);
      if (SrcEltTy.isFloatingPointTy()) {
        return Builder.CreateFCmpUNE(Src, Zero, new Twine(/*KEEP_STR*/"tobool"));
      } else {
        return Builder.CreateICmpNE(Src, Zero, new Twine(/*KEEP_STR*/"tobool"));
      }
    }
    
    // We have the arithmetic types: real int/float.
    Value /*P*/ Res = null;
    if (isa_IntegerType(SrcEltTy)) {
      boolean InputSigned = SrcEltType.$arrow().isSignedIntegerOrEnumerationType();
      if (isa_IntegerType(DstEltTy)) {
        Res = Builder.CreateIntCast(Src, DstTy, InputSigned, new Twine(/*KEEP_STR*/"conv"));
      } else if (InputSigned) {
        Res = Builder.CreateSIToFP(Src, DstTy, new Twine(/*KEEP_STR*/"conv"));
      } else {
        Res = Builder.CreateUIToFP(Src, DstTy, new Twine(/*KEEP_STR*/"conv"));
      }
    } else if (isa_IntegerType(DstEltTy)) {
      assert (SrcEltTy.isFloatingPointTy()) : "Unknown real conversion";
      if (DstEltType.$arrow().isSignedIntegerOrEnumerationType()) {
        Res = Builder.CreateFPToSI(Src, DstTy, new Twine(/*KEEP_STR*/"conv"));
      } else {
        Res = Builder.CreateFPToUI(Src, DstTy, new Twine(/*KEEP_STR*/"conv"));
      }
    } else {
      assert (SrcEltTy.isFloatingPointTy() && DstEltTy.isFloatingPointTy()) : "Unknown real conversion";
      if (DstEltTy.getTypeID().getValue() < SrcEltTy.getTypeID().getValue()) {
        Res = Builder.CreateFPTrunc(Src, DstTy, new Twine(/*KEEP_STR*/"conv"));
      } else {
        Res = Builder.CreateFPExt(Src, DstTy, new Twine(/*KEEP_STR*/"conv"));
      }
    }
    
    return Res;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::VisitMemberExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 1114,
   FQN="(anonymous namespace)::ScalarExprEmitter::VisitMemberExpr", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter15VisitMemberExprEPN5clang10MemberExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter15VisitMemberExprEPN5clang10MemberExprE")
  //</editor-fold>
  public Value /*P*/ VisitMemberExpr(MemberExpr /*P*/ E) {
    APSInt Value/*J*/= new APSInt();
    if (E.EvaluateAsInt(Value, CGF.getContext(), Expr.SideEffectsKind.SE_AllowSideEffects)) {
      if (E.isArrow()) {
        CGF.EmitScalarExpr(E.getBase());
      } else {
        EmitLValue(E.getBase());
      }
      return Builder.getInt(Value);
    }
    
    return EmitLoadOfLValue(E);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::VisitExtVectorElementExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 306,
   FQN="(anonymous namespace)::ScalarExprEmitter::VisitExtVectorElementExpr", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter25VisitExtVectorElementExprEPN5clang4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter25VisitExtVectorElementExprEPN5clang4ExprE")
  //</editor-fold>
  public Value /*P*/ VisitExtVectorElementExpr(Expr /*P*/ E) {
    return EmitLoadOfLValue(E);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::VisitCompoundLiteralExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 307,
   FQN="(anonymous namespace)::ScalarExprEmitter::VisitCompoundLiteralExpr", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter24VisitCompoundLiteralExprEPN5clang19CompoundLiteralExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter24VisitCompoundLiteralExprEPN5clang19CompoundLiteralExprE")
  //</editor-fold>
  public Value /*P*/ VisitCompoundLiteralExpr(CompoundLiteralExpr /*P*/ E) {
    return EmitLoadOfLValue(E);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::VisitInitListExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 1167,
   FQN="(anonymous namespace)::ScalarExprEmitter::VisitInitListExpr", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter17VisitInitListExprEPN5clang12InitListExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter17VisitInitListExprEPN5clang12InitListExprE")
  //</editor-fold>
  public Value /*P*/ VisitInitListExpr(InitListExpr /*P*/ E) {
    boolean Ignore = TestAndClearIgnoreResultAssign();
    ///*J:(void)*/Ignore;
    assert (Ignore == false) : "init list ignored";
    /*uint*/int NumInitElements = E.getNumInits();
    if (E.hadArrayRangeDesignator()) {
      CGF.ErrorUnsupported(E, $("GNU array range designator extension"));
    }
    
    VectorType /*P*/ VType = dyn_cast_VectorType(ConvertType(E.getType()));
    if (!(VType != null)) {
      if (NumInitElements == 0) {
        // C++11 value-initialization for the scalar.
        return EmitNullValue(E.getType());
      }
      // We have a scalar in braces. Just use the first element.
      return Visit(E.getInit(0));
    }
    
    /*uint*/int ResElts = VType.getNumElements();
    
    // Loop over initializers collecting the Value for each, and remembering
    // whether the source was swizzle (ExtVectorElementExpr).  This will allow
    // us to fold the shuffle for the swizzle into the shuffle for the vector
    // initializer, since LLVM optimizers generally do not want to touch
    // shuffles.
    /*uint*/int CurIdx = 0;
    boolean VIsUndefShuffle = false;
    type$ref<Value /*P*/ > V = create_type$ref(UndefValue.get(VType));
    for (/*uint*/int i = 0; i != NumInitElements; ++i) {
      Expr /*P*/ IE = E.getInit(i);
      type$ref<Value /*P*/ > Init = create_type$ref(Visit(IE));
      SmallVector<Constant /*P*/ > Args/*J*/= new SmallVector<Constant /*P*/ >(16, (Constant /*P*/ )null);
      
      VectorType /*P*/ VVT = dyn_cast_VectorType(Init.$deref().getType());
      
      // Handle scalar elements.  If the scalar initializer is actually one
      // element of a different vector of the same width, use shuffle instead of
      // extract+insert.
      if (!(VVT != null)) {
        if (isa_ExtVectorElementExpr(IE)) {
          ExtractElementInst /*P*/ EI = cast_ExtractElementInst(Init.$deref());
          if (EI.getVectorOperandType().getNumElements() == ResElts) {
            ConstantInt /*P*/ C = cast_ConstantInt(EI.getIndexOperand());
            Value /*P*/ LHS = null;
            Value /*P*/ RHS = null;
            if (CurIdx == 0) {
              // insert into undef -> shuffle (src, undef)
              // shufflemask must use an i32
              Args.push_back(getAsInt32(C, CGF.Int32Ty));
              Args.resize(ResElts, UndefValue.get(CGF.Int32Ty));
              
              LHS = EI.getVectorOperand();
              RHS = V.$deref();
              VIsUndefShuffle = true;
            } else if (VIsUndefShuffle) {
              // insert into undefshuffle && size match -> shuffle (v, src)
              ShuffleVectorInst /*P*/ SVV = cast_ShuffleVectorInst(V.$deref());
              for (/*uint*/int j = 0; j != CurIdx; ++j)  {
                Args.push_back(getMaskElt(SVV, j, 0, CGF.Int32Ty));
              }
              Args.push_back(Builder.getInt32($ullong2uint($uint2ullong(ResElts) + C.getZExtValue())));
              Args.resize(ResElts, UndefValue.get(CGF.Int32Ty));
              
              LHS = cast_ShuffleVectorInst(V.$deref()).getOperand(0);
              RHS = EI.getVectorOperand();
              VIsUndefShuffle = false;
            }
            if (!Args.empty()) {
              Constant /*P*/ Mask = ConstantVector.get(new ArrayRef<Constant /*P*/ >(Args, true));
              V.$set(Builder.CreateShuffleVector(LHS, RHS, Mask));
              ++CurIdx;
              continue;
            }
          }
        }
        V.$set(Builder.CreateInsertElement(V.$deref(), Init.$deref(), Builder.getInt32(CurIdx), 
            new Twine(/*KEEP_STR*/"vecinit")));
        VIsUndefShuffle = false;
        ++CurIdx;
        continue;
      }
      
      /*uint*/int InitElts = VVT.getNumElements();
      
      // If the initializer is an ExtVecEltExpr (a swizzle), and the swizzle's
      // input is the same width as the vector being constructed, generate an
      // optimized shuffle of the swizzle input into the result.
      /*uint*/int Offset = (CurIdx == 0) ? 0 : ResElts;
      if (isa_ExtVectorElementExpr(IE)) {
        ShuffleVectorInst /*P*/ SVI = cast_ShuffleVectorInst(Init.$deref());
        Value /*P*/ SVOp = SVI.getOperand(0);
        VectorType /*P*/ OpTy = cast_VectorType(SVOp.getType());
        if (OpTy.getNumElements() == ResElts) {
          for (/*uint*/int j = 0; j != CurIdx; ++j) {
            // If the current vector initializer is a shuffle with undef, merge
            // this shuffle directly into it.
            if (VIsUndefShuffle) {
              Args.push_back(getMaskElt(cast_ShuffleVectorInst(V.$deref()), j, 0, 
                      CGF.Int32Ty));
            } else {
              Args.push_back(Builder.getInt32(j));
            }
          }
          for (/*uint*/int j = 0, je = InitElts; j != je; ++j)  {
            Args.push_back(getMaskElt(SVI, j, Offset, CGF.Int32Ty));
          }
          Args.resize(ResElts, UndefValue.get(CGF.Int32Ty));
          if (VIsUndefShuffle) {
            V.$set(cast_ShuffleVectorInst(V.$deref()).getOperand(0));
          }
          
          Init.$set(SVOp);
        }
      }
      
      // Extend init to result vector length, and then shuffle its contribution
      // to the vector initializer into V.
      if (Args.empty()) {
        for (/*uint*/int j = 0; j != InitElts; ++j)  {
          Args.push_back(Builder.getInt32(j));
        }
        Args.resize(ResElts, UndefValue.get(CGF.Int32Ty));
        Constant /*P*/ Mask = ConstantVector.get(new ArrayRef<Constant /*P*/ >(Args, true));
        Init.$set(Builder.CreateShuffleVector(Init.$deref(), UndefValue.get(VVT), 
            Mask, new Twine(/*KEEP_STR*/"vext")));
        
        Args.clear();
        for (/*uint*/int j = 0; j != CurIdx; ++j)  {
          Args.push_back(Builder.getInt32(j));
        }
        for (/*uint*/int j = 0; j != InitElts; ++j)  {
          Args.push_back(Builder.getInt32(j + Offset));
        }
        Args.resize(ResElts, UndefValue.get(CGF.Int32Ty));
      }
      
      // If V is undef, make sure it ends up on the RHS of the shuffle to aid
      // merging subsequent shuffles into this one.
      if (CurIdx == 0) {
        std.swap(V, Init);
      }
      Constant /*P*/ Mask = ConstantVector.get(new ArrayRef<Constant /*P*/ >(Args, true));
      V.$set(Builder.CreateShuffleVector(V.$deref(), Init.$deref(), Mask, new Twine(/*KEEP_STR*/"vecinit")));
      VIsUndefShuffle = isa_UndefValue(Init);
      CurIdx += InitElts;
    }
    
    // FIXME: evaluate codegen vs. shuffling against constant null vector.
    // Emit remaining default initializers.
    Type /*P*/ EltTy = VType.getElementType();
    
    // Emit remaining default initializers
    for (; $less_uint(CurIdx, ResElts); ++CurIdx) {
      Value /*P*/ Idx = Builder.getInt32(CurIdx);
      Value /*P*/ Init = Constant.getNullValue(EltTy);
      V.$set(Builder.CreateInsertElement(V.$deref(), Init, Idx, new Twine(/*KEEP_STR*/"vecinit")));
    }
    return V.$deref();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::VisitImplicitValueInitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 313,
   FQN="(anonymous namespace)::ScalarExprEmitter::VisitImplicitValueInitExpr", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter26VisitImplicitValueInitExprEPKN5clang21ImplicitValueInitExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter26VisitImplicitValueInitExprEPKN5clang21ImplicitValueInitExprE")
  //</editor-fold>
  public Value /*P*/ VisitImplicitValueInitExpr(/*const*/ ImplicitValueInitExpr /*P*/ E) {
    return EmitNullValue(E.getType());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::VisitExplicitCastExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 316,
   FQN="(anonymous namespace)::ScalarExprEmitter::VisitExplicitCastExpr", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter21VisitExplicitCastExprEPN5clang16ExplicitCastExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter21VisitExplicitCastExprEPN5clang16ExplicitCastExprE")
  //</editor-fold>
  public Value /*P*/ VisitExplicitCastExpr(ExplicitCastExpr /*P*/ E) {
    CGF.CGM.EmitExplicitCastExprType(E, /*AddrOf*/CGF);
    return VisitCastExpr(E);
  }

  
  // VisitCastExpr - Emit code for an explicit or implicit cast.  Implicit casts
  // have to handle a more broad range of conversions than explicit casts, as they
  // handle things like function to ptr-to-function decay etc.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::VisitCastExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 1348,
   FQN="(anonymous namespace)::ScalarExprEmitter::VisitCastExpr", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter13VisitCastExprEPN5clang8CastExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter13VisitCastExprEPN5clang8CastExprE")
  //</editor-fold>
  public Value /*P*/ VisitCastExpr(CastExpr /*P*/ CE) {
    Expr /*P*/ E = CE.getSubExpr();
    QualType DestTy = CE.getType();
    CastKind Kind = CE.getCastKind();
    
    // These cases are generally not written to ignore the result of
    // evaluating their sub-expressions, so we clear this now.
    boolean Ignored = TestAndClearIgnoreResultAssign();
    
    // Since almost all cast kinds apply to scalars, this switch doesn't have
    // a default case, so the compiler will warn on a missing case.  The cases
    // are in the same order as in the CastKind enum.
    switch (Kind) {
     case CK_Dependent:
      throw new llvm_unreachable("dependent cast kind in IR gen!");
     case CK_BuiltinFnToFnPtr:
      throw new llvm_unreachable("builtin functions are handled elsewhere");
     case CK_LValueBitCast:
     case CK_ObjCObjectLValueCast:
      {
        Address Addr = EmitLValue(E).getAddress();
        Addr.$assignMove(Builder.CreateElementBitCast(new Address(Addr), CGF.ConvertTypeForMem(new QualType(DestTy))));
        LValue LV = CGF.MakeAddrLValue(new Address(Addr), new QualType(DestTy));
        return EmitLoadOfLValue(new LValue(LV), CE.getExprLoc());
      }
     case CK_CPointerToObjCPointerCast:
     case CK_BlockPointerToObjCPointerCast:
     case CK_AnyPointerToBlockPointerCast:
     case CK_BitCast:
      {
        Value /*P*/ Src = Visit(((/*const_cast*/Expr /*P*/ )(E)));
        Type /*P*/ SrcTy = Src.getType();
        Type /*P*/ DstTy = ConvertType(new QualType(DestTy));
        if (SrcTy.isPtrOrPtrVectorTy() && DstTy.isPtrOrPtrVectorTy()
           && SrcTy.getPointerAddressSpace() != DstTy.getPointerAddressSpace()) {
          throw new llvm_unreachable("wrong cast for pointers in different address spaces(must be an address space cast)!");
        }
        if (CGF.SanOpts.has(SanitizerKind.CFIUnrelatedCast)) {
          {
            /*const*/ org.clang.ast.PointerType /*P*/ PT = DestTy.$arrow().getAs(org.clang.ast.PointerType.class);
            if ((PT != null)) {
              CGF.EmitVTablePtrCheckForCast(PT.getPointeeType(), Src, 
                  /*MayBeNull=*/ true, 
                  CodeGenFunction.CFITypeCheckKind.CFITCK_UnrelatedCast, 
                  CE.getLocStart());
            }
          }
        }
        
        return Builder.CreateBitCast(Src, DstTy);
      }
     case CK_AddressSpaceConversion:
      {
        Value /*P*/ Src = Visit(((/*const_cast*/Expr /*P*/ )(E)));
        // Since target may map different address spaces in AST to the same address
        // space, an address space conversion may end up as a bitcast.
        return Builder.CreatePointerBitCastOrAddrSpaceCast(Src, 
            ConvertType(new QualType(DestTy)));
      }
     case CK_AtomicToNonAtomic:
     case CK_NonAtomicToAtomic:
     case CK_NoOp:
     case CK_UserDefinedConversion:
      return Visit(((/*const_cast*/Expr /*P*/ )(E)));
     case CK_BaseToDerived:
      {
        /*const*/ CXXRecordDecl /*P*/ DerivedClassDecl = DestTy.$arrow().getPointeeCXXRecordDecl();
        assert ((DerivedClassDecl != null)) : "BaseToDerived arg isn't a C++ object pointer!";
        
        Address Base = CGF.EmitPointerWithAlignment(E);
        Address Derived = CGF.GetAddressOfDerivedClass(new Address(Base), DerivedClassDecl, 
            CE.path_begin(), CE.path_end(), 
            CGF.ShouldNullCheckClassCastValue(CE));
        
        // C++11 [expr.static.cast]p11: Behavior is undefined if a downcast is
        // performed and the object is not of the derived type.
        if (CGF.sanitizePerformTypeCheck()) {
          CGF.EmitTypeCheck(CodeGenFunction.TypeCheckKind.TCK_DowncastPointer, CE.getExprLoc(), 
              Derived.getPointer(), DestTy.$arrow().getPointeeType());
        }
        if (CGF.SanOpts.has(SanitizerKind.CFIDerivedCast)) {
          CGF.EmitVTablePtrCheckForCast(DestTy.$arrow().getPointeeType(), 
              Derived.getPointer(), 
              /*MayBeNull=*/ true, 
              CodeGenFunction.CFITypeCheckKind.CFITCK_DerivedCast, 
              CE.getLocStart());
        }
        
        return Derived.getPointer();
      }
     case CK_UncheckedDerivedToBase:
     case CK_DerivedToBase:
      {
        // The EmitPointerWithAlignment path does this fine; just discard
        // the alignment.
        return CGF.EmitPointerWithAlignment(CE).getPointer();
      }
     case CK_Dynamic:
      {
        Address V = CGF.EmitPointerWithAlignment(E);
        /*const*/ CXXDynamicCastExpr /*P*/ DCE = cast_CXXDynamicCastExpr(CE);
        return CGF.EmitDynamicCast(new Address(V), DCE);
      }
     case CK_ArrayToPointerDecay:
      return CGF.EmitArrayToPointerDecay(E).getPointer();
     case CK_FunctionToPointerDecay:
      return EmitLValue(E).getPointer();
     case CK_NullToPointer:
      if (MustVisitNullValue(E)) {
        /*J:(void)*/Visit(E);
      }
      
      return ConstantPointerNull.get(cast_PointerType(ConvertType(new QualType(DestTy))));
     case CK_NullToMemberPointer:
      {
        if (MustVisitNullValue(E)) {
          /*J:(void)*/Visit(E);
        }
        
        /*const*/ MemberPointerType /*P*/ MPT = CE.getType().$arrow().getAs(MemberPointerType.class);
        return CGF.CGM.getCXXABI().EmitNullMemberPointer(MPT);
      }
     case CK_ReinterpretMemberPointer:
     case CK_BaseToDerivedMemberPointer:
     case CK_DerivedToBaseMemberPointer:
      {
        Value /*P*/ Src = Visit(E);
        
        // Note that the AST doesn't distinguish between checked and
        // unchecked member pointer conversions, so we always have to
        // implement checked conversions here.  This is inefficient when
        // actual control flow may be required in order to perform the
        // check, which it is for data member pointers (but not member
        // function pointers on Itanium and ARM).
        return CGF.CGM.getCXXABI().EmitMemberPointerConversion(CGF, CE, Src);
      }
     case CK_ARCProduceObject:
      return CGF.EmitARCRetainScalarExpr(E);
     case CK_ARCConsumeObject:
      return CGF.EmitObjCConsumeObject(E.getType(), Visit(E));
     case CK_ARCReclaimReturnedObject:
      return CGF.EmitARCReclaimReturnedObject(E, /*allowUnsafe*/ Ignored);
     case CK_ARCExtendBlockObject:
      return CGF.EmitARCExtendBlockObject(E);
     case CK_CopyAndAutoreleaseBlockObject:
      return CGF.EmitBlockCopyAndAutorelease(Visit(E), E.getType());
     case CK_FloatingRealToComplex:
     case CK_FloatingComplexCast:
     case CK_IntegralRealToComplex:
     case CK_IntegralComplexCast:
     case CK_IntegralComplexToFloatingComplex:
     case CK_FloatingComplexToIntegralComplex:
     case CK_ConstructorConversion:
     case CK_ToUnion:
      throw new llvm_unreachable("scalar cast to non-scalar value");
     case CK_LValueToRValue:
      assert (CGF.getContext().hasSameUnqualifiedType(E.getType(), new QualType(DestTy)));
      assert (E.isGLValue()) : "lvalue-to-rvalue applied to r-value!";
      return Visit(((/*const_cast*/Expr /*P*/ )(E)));
     case CK_IntegralToPointer:
      {
        Value /*P*/ Src = Visit(((/*const_cast*/Expr /*P*/ )(E)));
        
        // First, convert to the correct width so that we control the kind of
        // extension.
        Type /*P*/ MiddleTy = CGF.Unnamed_field8.IntPtrTy;
        boolean InputSigned = E.getType().$arrow().isSignedIntegerOrEnumerationType();
        Value /*P*/ IntResult = Builder.CreateIntCast(Src, MiddleTy, InputSigned, new Twine(/*KEEP_STR*/"conv"));
        
        return Builder.CreateIntToPtr(IntResult, ConvertType(new QualType(DestTy)));
      }
     case CK_PointerToIntegral:
      assert (!DestTy.$arrow().isBooleanType()) : "bool should use PointerToBool";
      return Builder.CreatePtrToInt(Visit(E), ConvertType(new QualType(DestTy)));
     case CK_ToVoid:
      {
        CGF.EmitIgnoredExpr(E);
        return null;
      }
     case CK_VectorSplat:
      {
        Type /*P*/ DstTy = ConvertType(new QualType(DestTy));
        Value /*P*/ Elt = Visit(((/*const_cast*/Expr /*P*/ )(E)));
        // Splat the element across to all elements
        /*uint*/int NumElements = DstTy.getVectorNumElements();
        return Builder.CreateVectorSplat(NumElements, Elt, new Twine(/*KEEP_STR*/"splat"));
      }
     case CK_IntegralCast:
     case CK_IntegralToFloating:
     case CK_FloatingToIntegral:
     case CK_FloatingCast:
      return EmitScalarConversion(Visit(E), E.getType(), new QualType(DestTy), 
          CE.getExprLoc());
     case CK_BooleanToSignedIntegral:
      return EmitScalarConversion(Visit(E), E.getType(), new QualType(DestTy), 
          CE.getExprLoc(), 
          /*TreatBooleanAsSigned=*/ true);
     case CK_IntegralToBoolean:
      return EmitIntToBoolConversion(Visit(E));
     case CK_PointerToBoolean:
      return EmitPointerToBoolConversion(Visit(E));
     case CK_FloatingToBoolean:
      return EmitFloatToBoolConversion(Visit(E));
     case CK_MemberPointerToBoolean:
      {
        Value /*P*/ MemPtr = Visit(E);
        /*const*/ MemberPointerType /*P*/ MPT = E.getType().$arrow().getAs(MemberPointerType.class);
        return CGF.CGM.getCXXABI().EmitMemberPointerIsNotNull(CGF, MemPtr, MPT);
      }
     case CK_FloatingComplexToReal:
     case CK_IntegralComplexToReal:
      return CGF.EmitComplexExpr(E, false, true).first;
     case CK_FloatingComplexToBoolean:
     case CK_IntegralComplexToBoolean:
      {
        std.pair<Value /*P*/ , Value /*P*/ > V = CGF.EmitComplexExpr(E);
        
        // TODO: kill this function off, inline appropriate case here
        return EmitComplexToScalarConversion(new std.pairPtrPtr<Value /*P*/ , Value /*P*/ >(V), E.getType(), new QualType(DestTy), 
            CE.getExprLoc());
      }
     case CK_ZeroToOCLEvent:
      {
        assert (DestTy.$arrow().isEventT()) : "CK_ZeroToOCLEvent cast on non-event type";
        return Constant.getNullValue(ConvertType(new QualType(DestTy)));
      }
    }
    throw new llvm_unreachable("unknown scalar cast");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::VisitCallExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 322,
   FQN="(anonymous namespace)::ScalarExprEmitter::VisitCallExpr", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter13VisitCallExprEPKN5clang8CallExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter13VisitCallExprEPKN5clang8CallExprE")
  //</editor-fold>
  public Value /*P*/ VisitCallExpr(/*const*/ CallExpr /*P*/ E) {
    if (E.getCallReturnType(CGF.getContext()).$arrow().isReferenceType()) {
      return EmitLoadOfLValue(E);
    }
    
    Value /*P*/ V = CGF.EmitCallExpr(E).getScalarVal();
    
    EmitLValueAlignmentAssumption(E, V);
    return V;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::VisitStmtExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 1581,
   FQN="(anonymous namespace)::ScalarExprEmitter::VisitStmtExpr", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter13VisitStmtExprEPKN5clang8StmtExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter13VisitStmtExprEPKN5clang8StmtExprE")
  //</editor-fold>
  public Value /*P*/ VisitStmtExpr(/*const*/ StmtExpr /*P*/ E) {
    CodeGenFunction.StmtExprEvaluation eval = null;
    try {
      eval/*J*/= new CodeGenFunction.StmtExprEvaluation(CGF);
      Address RetAlloca = CGF.EmitCompoundStmt(/*Deref*/E.getSubStmt$Const(), 
          !E.getType().$arrow().isVoidType());
      if (!RetAlloca.isValid()) {
        return null;
      }
      return CGF.EmitLoadOfScalar(CGF.MakeAddrLValue(new Address(RetAlloca), E.getType()), 
          E.getExprLoc());
    } finally {
      if (eval != null) { eval.$destroy(); }
    }
  }

  
  // Unary Operators.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::VisitUnaryPostDec">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 335,
   FQN="(anonymous namespace)::ScalarExprEmitter::VisitUnaryPostDec", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter17VisitUnaryPostDecEPKN5clang13UnaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter17VisitUnaryPostDecEPKN5clang13UnaryOperatorE")
  //</editor-fold>
  public Value /*P*/ VisitUnaryPostDec(/*const*/ UnaryOperator /*P*/ E) {
    LValue LV = EmitLValue(E.getSubExpr());
    return EmitScalarPrePostIncDec(E, new LValue(LV), false, false);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::VisitUnaryPostInc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 339,
   FQN="(anonymous namespace)::ScalarExprEmitter::VisitUnaryPostInc", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter17VisitUnaryPostIncEPKN5clang13UnaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter17VisitUnaryPostIncEPKN5clang13UnaryOperatorE")
  //</editor-fold>
  public Value /*P*/ VisitUnaryPostInc(/*const*/ UnaryOperator /*P*/ E) {
    LValue LV = EmitLValue(E.getSubExpr());
    return EmitScalarPrePostIncDec(E, new LValue(LV), true, false);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::VisitUnaryPreDec">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 343,
   FQN="(anonymous namespace)::ScalarExprEmitter::VisitUnaryPreDec", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter16VisitUnaryPreDecEPKN5clang13UnaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter16VisitUnaryPreDecEPKN5clang13UnaryOperatorE")
  //</editor-fold>
  public Value /*P*/ VisitUnaryPreDec(/*const*/ UnaryOperator /*P*/ E) {
    LValue LV = EmitLValue(E.getSubExpr());
    return EmitScalarPrePostIncDec(E, new LValue(LV), false, true);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::VisitUnaryPreInc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 347,
   FQN="(anonymous namespace)::ScalarExprEmitter::VisitUnaryPreInc", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter16VisitUnaryPreIncEPKN5clang13UnaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter16VisitUnaryPreIncEPKN5clang13UnaryOperatorE")
  //</editor-fold>
  public Value /*P*/ VisitUnaryPreInc(/*const*/ UnaryOperator /*P*/ E) {
    LValue LV = EmitLValue(E.getSubExpr());
    return EmitScalarPrePostIncDec(E, new LValue(LV), true, true);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::EmitIncDecConsiderOverflowBehavior">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 1607,
   FQN="(anonymous namespace)::ScalarExprEmitter::EmitIncDecConsiderOverflowBehavior", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter34EmitIncDecConsiderOverflowBehaviorEPKN5clang13UnaryOperatorEPN4llvm5ValueEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter34EmitIncDecConsiderOverflowBehaviorEPKN5clang13UnaryOperatorEPN4llvm5ValueEb")
  //</editor-fold>
  public Value /*P*/ EmitIncDecConsiderOverflowBehavior(/*const*/ UnaryOperator /*P*/ E, Value /*P*/ InVal, boolean IsInc) {
    Value /*P*/ Amount = ConstantInt.get(InVal.getType(), $int2ulong(IsInc ? 1 : -1), true);
    StringRef Name = new StringRef(IsInc ? $("inc") : $("dec"));
    switch (CGF.getLangOpts().getSignedOverflowBehavior()) {
     case SOB_Defined:
      return Builder.CreateAdd(InVal, Amount, new Twine(Name));
     case SOB_Undefined:
      if (!CGF.SanOpts.has(SanitizerKind.SignedIntegerOverflow)) {
        return Builder.CreateNSWAdd(InVal, Amount, new Twine(Name));
      }
     case SOB_Trapping:
      // Fall through.
      return EmitOverflowCheckedBinOp(createBinOpInfoFromIncDec(E, InVal, IsInc));
    }
    throw new llvm_unreachable("Unknown SignedOverflowBehaviorTy");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::EmitScalarPrePostIncDec">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 1625,
   FQN="(anonymous namespace)::ScalarExprEmitter::EmitScalarPrePostIncDec", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter23EmitScalarPrePostIncDecEPKN5clang13UnaryOperatorENS1_7CodeGen6LValueEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter23EmitScalarPrePostIncDecEPKN5clang13UnaryOperatorENS1_7CodeGen6LValueEbb")
  //</editor-fold>
  public Value /*P*/ EmitScalarPrePostIncDec(/*const*/ UnaryOperator /*P*/ E, LValue LV, 
                         boolean isInc, boolean isPre) {
    
    QualType type = E.getSubExpr().getType();
    PHINode /*P*/ atomicPHI = null;
    type$ptr<Value /*P*/ > value = create_type$null$ptr();
    Value /*P*/ input;
    
    int amount = (isInc ? 1 : -1);
    {
      
      /*const*/ AtomicType /*P*/ atomicTy = type.$arrow().getAs(AtomicType.class);
      if ((atomicTy != null)) {
        type.$assignMove(atomicTy.getValueType());
        if (isInc && type.$arrow().isBooleanType()) {
          Value /*P*/ True = CGF.EmitToMemory(Builder.getTrue(), new QualType(type));
          if (isPre) {
            Builder.CreateStore(True, LV.getAddress(), LV.isVolatileQualified()).
                setAtomic(AtomicOrdering.SequentiallyConsistent);
            return Builder.getTrue();
          }
          // For atomic bool increment, we just store true and return it for
          // preincrement, do an atomic swap with true for postincrement
          return Builder.CreateAtomicRMW(AtomicRMWInst.BinOp.Xchg, LV.getPointer(), True, 
              AtomicOrdering.SequentiallyConsistent);
        }
        // Special case for atomic increment / decrement on integers, emit
        // atomicrmw instructions.  We skip this if we want to be doing overflow
        // checking, and fall into the slow path with the atomic cmpxchg loop.
        if (!type.$arrow().isBooleanType() && type.$arrow().isIntegerType()
           && !(type.$arrow().isUnsignedIntegerType()
           && CGF.SanOpts.has(SanitizerKind.UnsignedIntegerOverflow))
           && CGF.getLangOpts().getSignedOverflowBehavior()
           != LangOptions.SignedOverflowBehaviorTy.SOB_Trapping) {
          AtomicRMWInst.BinOp aop = isInc ? AtomicRMWInst.BinOp.Add : AtomicRMWInst.BinOp.Sub;
          /*BinaryOps*/int op = isInc ? Instruction.BinaryOps.Add : Instruction.BinaryOps.Sub;
          Value /*P*/ amt = CGF.EmitToMemory(ConstantInt.get(ConvertType(new QualType(type)), $int2ulong(1), true), new QualType(type));
          Value /*P*/ old = Builder.CreateAtomicRMW(aop, 
              LV.getPointer(), amt, AtomicOrdering.SequentiallyConsistent);
          return isPre ? Builder.CreateBinOp(op, old, amt) : old;
        }
        value.$set(EmitLoadOfLValue(new LValue(LV), E.getExprLoc()));
        input = value.$star();
        // For every other atomic operation, we need to emit a load-op-cmpxchg loop
        BasicBlock /*P*/ startBB = Builder.GetInsertBlock();
        BasicBlock /*P*/ opBB = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"atomic_op"), CGF.CurFn);
        value.$set(CGF.EmitToMemory(value.$star(), new QualType(type)));
        Builder.CreateBr(opBB);
        Builder.SetInsertPoint(opBB);
        atomicPHI = Builder.CreatePHI(value.$star().getType(), 2);
        atomicPHI.addIncoming(value.$star(), startBB);
        value.$set(atomicPHI);
      } else {
        value.$set(EmitLoadOfLValue(new LValue(LV), E.getExprLoc()));
        input = value.$star();
      }
    }
    
    // Special case of integer increment that we have to check first: bool++.
    // Due to promotion rules, we get:
    //   bool++ -> bool = bool + 1
    //          -> bool = (int)bool + 1
    //          -> bool = ((int)bool + 1 != 0)
    // An interesting aspect of this is that increment is always true.
    // Decrement does not have this property.
    if (isInc && type.$arrow().isBooleanType()) {
      value.$set(Builder.getTrue());
      // Most common case by far: integer increment.
    } else if (type.$arrow().isIntegerType()) {
      // Note that signed integer inc/dec with width less than int can't
      // overflow because of promotion rules; we're just eliding a few steps here.
      boolean CanOverflow = $greatereq_uint(value.$star().getType().getIntegerBitWidth()
        , CGF.IntTy.getIntegerBitWidth());
      if (CanOverflow && type.$arrow().isSignedIntegerOrEnumerationType()) {
        value.$set(EmitIncDecConsiderOverflowBehavior(E, value.$star(), isInc));
      } else if (CanOverflow && type.$arrow().isUnsignedIntegerType()
         && CGF.SanOpts.has(SanitizerKind.UnsignedIntegerOverflow)) {
        value.$set(EmitOverflowCheckedBinOp(createBinOpInfoFromIncDec(E, value.$star(), isInc)));
      } else {
        Value /*P*/ amt = ConstantInt.get(value.$star().getType(), $int2ulong(amount), true);
        value.$set(Builder.CreateAdd(value.$star(), amt, new Twine(isInc ? $("inc") : $("dec"))));
      }
      // Next most common: pointer increment.
    } else {
      /*const*/ org.clang.ast.PointerType /*P*/ ptr = type.$arrow().getAs(org.clang.ast.PointerType.class);
      if ((ptr != null)) {
        QualType type$1 = ptr.getPointeeType();
        {
          
          // VLA types don't have constant size.
          /*const*/ VariableArrayType /*P*/ vla = CGF.getContext().getAsVariableArrayType(new QualType(type$1));
          if ((vla != null)) {
            Value /*P*/ numElts = CGF.getVLASize(vla).first;
            if (!isInc) {
              numElts = Builder.CreateNSWNeg(numElts, new Twine(/*KEEP_STR*/"vla.negsize"));
            }
            if (CGF.getLangOpts().isSignedOverflowDefined()) {
              value.$set(Builder.CreateGEP(value.$star(), numElts, new Twine(/*KEEP_STR*/"vla.inc")));
            } else {
              value.$set(Builder.CreateInBoundsGEP(value.$star(), new ArrayRef<Value /*P*/ >(numElts, true), new Twine(/*KEEP_STR*/"vla.inc")));
            }
            // Arithmetic on function pointers (!) is just +-1.
          } else if (type$1.$arrow().isFunctionType()) {
            Value /*P*/ amt = Builder.getInt32(amount);
            
            value.$set(CGF.EmitCastToVoidPtr(value.$star()));
            if (CGF.getLangOpts().isSignedOverflowDefined()) {
              value.$set(Builder.CreateGEP(value.$star(), amt, new Twine(/*KEEP_STR*/"incdec.funcptr")));
            } else {
              value.$set(Builder.CreateInBoundsGEP(value.$star(), new ArrayRef<Value /*P*/ >(amt, true), new Twine(/*KEEP_STR*/"incdec.funcptr")));
            }
            value.$set(Builder.CreateBitCast(value.$star(), input.getType()));
            // For everything else, we can just do a simple increment.
          } else {
            Value /*P*/ amt = Builder.getInt32(amount);
            if (CGF.getLangOpts().isSignedOverflowDefined()) {
              value.$set(Builder.CreateGEP(value.$star(), amt, new Twine(/*KEEP_STR*/"incdec.ptr")));
            } else {
              value.$set(Builder.CreateInBoundsGEP(value.$star(), new ArrayRef<Value /*P*/ >(amt, true), new Twine(/*KEEP_STR*/"incdec.ptr")));
            }
          }
        }
        // Vector increment/decrement.
      } else if (type.$arrow().isVectorType()) {
        if (type.$arrow().hasIntegerRepresentation()) {
          Value /*P*/ amt = ConstantInt.get(value.$star().getType(), $int2ulong(amount));
          
          value.$set(Builder.CreateAdd(value.$star(), amt, new Twine(isInc ? $("inc") : $("dec"))));
        } else {
          value.$set(Builder.CreateFAdd(value.$star(), 
              ConstantFP.get(value.$star().getType(), amount), 
              new Twine(isInc ? $("inc") : $("dec"))));
        }
        // Floating point.
      } else if (type.$arrow().isRealFloatingType()) {
        // Add the inc/dec to the real part.
        Value /*P*/ amt;
        if (type.$arrow().isHalfType() && !CGF.getContext().getLangOpts().NativeHalfType) {
          // Another special case: half FP increment should be done via float
          if (!CGF.getContext().getLangOpts().HalfArgsAndReturns) {
            value.$set(Builder.CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P(CGF.CGM.getIntrinsic(ID.convert_from_fp16, 
                    new ArrayRef<Type /*P*/ >(CGF.CGM.FloatTy, true)), 
                new ArrayRef<Value /*P*/ >(input, true), new Twine(/*KEEP_STR*/"incdec.conv")));
          } else {
            value.$set(Builder.CreateFPExt(input, CGF.CGM.FloatTy, new Twine(/*KEEP_STR*/"incdec.conv")));
          }
        }
        if (value.$star().getType().isFloatTy()) {
          amt = ConstantFP.get(VMContext, 
              new APFloat(((/*static_cast*/float)(amount))));
        } else if (value.$star().getType().isDoubleTy()) {
          amt = ConstantFP.get(VMContext, 
              new APFloat(((/*static_cast*/double)(amount))));
        } else {
          // Remaining types are Half, LongDouble or __float128. Convert from float.
          APFloat F/*J*/= new APFloat(((/*static_cast*/float)(amount)));
          bool$ptr ignored = create_bool$ptr();
          /*const*/ fltSemantics /*P*/ FS;
          // Don't use getFloatTypeSemantics because Half isn't
          // necessarily represented using the "half" LLVM type.
          if (value.$star().getType().isFP128Ty()) {
            FS = /*AddrOf*/CGF.getTarget().getFloat128Format();
          } else if (value.$star().getType().isHalfTy()) {
            FS = /*AddrOf*/CGF.getTarget().getHalfFormat();
          } else {
            FS = /*AddrOf*/CGF.getTarget().getLongDoubleFormat();
          }
          F.convert(/*Deref*/FS, APFloat.roundingMode.rmTowardZero, /*AddrOf*/ignored);
          amt = ConstantFP.get(VMContext, F);
        }
        value.$set(Builder.CreateFAdd(value.$star(), amt, new Twine(isInc ? $("inc") : $("dec"))));
        if (type.$arrow().isHalfType() && !CGF.getContext().getLangOpts().NativeHalfType) {
          if (!CGF.getContext().getLangOpts().HalfArgsAndReturns) {
            value.$set(Builder.CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P(CGF.CGM.getIntrinsic(ID.convert_to_fp16, 
                    new ArrayRef<Type /*P*/ >(CGF.CGM.FloatTy, true)), 
                new ArrayRef<Value /*P*/ >(value, 1), new Twine(/*KEEP_STR*/"incdec.conv")));
          } else {
            value.$set(Builder.CreateFPTrunc(value.$star(), input.getType(), new Twine(/*KEEP_STR*/"incdec.conv")));
          }
        }
        // Objective-C pointer types.
      } else {
        /*const*/ ObjCObjectPointerType /*P*/ OPT = type.$arrow().castAs(ObjCObjectPointerType.class);
        value.$set(CGF.EmitCastToVoidPtr(value.$star()));
        
        CharUnits size = CGF.getContext().getTypeSizeInChars(OPT.getObjectType());
        if (!isInc) {
          size.$assignMove(size.$sub());
        }
        Value /*P*/ sizeValue = ConstantInt.get(CGF.Unnamed_field8.SizeTy, size.getQuantity());
        if (CGF.getLangOpts().isSignedOverflowDefined()) {
          value.$set(Builder.CreateGEP(value.$star(), sizeValue, new Twine(/*KEEP_STR*/"incdec.objptr")));
        } else {
          value.$set(Builder.CreateInBoundsGEP(value.$star(), new ArrayRef<Value /*P*/ >(sizeValue, true), new Twine(/*KEEP_STR*/"incdec.objptr")));
        }
        value.$set(Builder.CreateBitCast(value.$star(), input.getType()));
      }
    }
    if ((atomicPHI != null)) {
      BasicBlock /*P*/ opBB = Builder.GetInsertBlock();
      BasicBlock /*P*/ contBB = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"atomic_cont"), CGF.CurFn);
      std.pair<RValue, Value /*P*/ > Pair = CGF.EmitAtomicCompareExchange(new LValue(LV), RValue.get(atomicPHI), RValue.get(value.$star()), E.getExprLoc());
      Value /*P*/ old = CGF.EmitToMemory(Pair.first.getScalarVal(), new QualType(type));
      Value /*P*/ success = Pair.second;
      atomicPHI.addIncoming(old, opBB);
      Builder.CreateCondBr(success, contBB, opBB);
      Builder.SetInsertPoint(contBB);
      return isPre ? value.$star() : input;
    }
    
    // Store the updated result through the lvalue.
    if (LV.isBitField()) {
      CGF.EmitStoreThroughBitfieldLValue(RValue.get(value.$star()), new LValue(LV), /*AddrOf*/value);
    } else {
      CGF.EmitStoreThroughLValue(RValue.get(value.$star()), new LValue(LV));
    }
    
    // If this is a postinc, return the value read from memory, otherwise use the
    // updated value.
    return isPre ? value.$star() : input;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::VisitUnaryAddrOf">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 360,
   FQN="(anonymous namespace)::ScalarExprEmitter::VisitUnaryAddrOf", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter16VisitUnaryAddrOfEPKN5clang13UnaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter16VisitUnaryAddrOfEPKN5clang13UnaryOperatorE")
  //</editor-fold>
  public Value /*P*/ VisitUnaryAddrOf(/*const*/ UnaryOperator /*P*/ E) {
    if (isa_MemberPointerType(E.getType())) { // never sugared
      return CGF.CGM.getMemberPointerConstant(E);
    }
    
    return EmitLValue(E.getSubExpr()).getPointer();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::VisitUnaryDeref">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 366,
   FQN="(anonymous namespace)::ScalarExprEmitter::VisitUnaryDeref", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter15VisitUnaryDerefEPKN5clang13UnaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter15VisitUnaryDerefEPKN5clang13UnaryOperatorE")
  //</editor-fold>
  public Value /*P*/ VisitUnaryDeref(/*const*/ UnaryOperator /*P*/ E) {
    if (E.getType().$arrow().isVoidType()) {
      return Visit(E.getSubExpr()); // the actual value should be unused
    }
    return EmitLoadOfLValue(E);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::VisitUnaryPlus">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 371,
   FQN="(anonymous namespace)::ScalarExprEmitter::VisitUnaryPlus", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter14VisitUnaryPlusEPKN5clang13UnaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter14VisitUnaryPlusEPKN5clang13UnaryOperatorE")
  //</editor-fold>
  public Value /*P*/ VisitUnaryPlus(/*const*/ UnaryOperator /*P*/ E) {
    // This differs from gcc, though, most likely due to a bug in gcc.
    TestAndClearIgnoreResultAssign();
    return Visit(E.getSubExpr());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::VisitUnaryMinus">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 1854,
   FQN="(anonymous namespace)::ScalarExprEmitter::VisitUnaryMinus", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter15VisitUnaryMinusEPKN5clang13UnaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter15VisitUnaryMinusEPKN5clang13UnaryOperatorE")
  //</editor-fold>
  public Value /*P*/ VisitUnaryMinus(/*const*/ UnaryOperator /*P*/ E) {
    TestAndClearIgnoreResultAssign();
    // Emit unary minus with EmitSub so we handle overflow cases etc.
    BinOpInfo BinOp/*J*/= new BinOpInfo();
    BinOp.RHS = Visit(E.getSubExpr());
    if (BinOp.RHS.getType().isFPOrFPVectorTy()) {
      BinOp.LHS = ConstantFP.getZeroValueForNegation(BinOp.RHS.getType());
    } else {
      BinOp.LHS = Constant.getNullValue(BinOp.RHS.getType());
    }
    BinOp.Ty.$assignMove(E.getType());
    BinOp.Opcode = BinaryOperatorKind.BO_Sub;
    BinOp.FPContractable = false;
    BinOp.E = E;
    return EmitSub(BinOp);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::VisitUnaryNot">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 1871,
   FQN="(anonymous namespace)::ScalarExprEmitter::VisitUnaryNot", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter13VisitUnaryNotEPKN5clang13UnaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter13VisitUnaryNotEPKN5clang13UnaryOperatorE")
  //</editor-fold>
  public Value /*P*/ VisitUnaryNot(/*const*/ UnaryOperator /*P*/ E) {
    TestAndClearIgnoreResultAssign();
    Value /*P*/ Op = Visit(E.getSubExpr());
    return Builder.CreateNot(Op, new Twine(/*KEEP_STR*/"neg"));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::VisitUnaryLNot">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 1877,
   FQN="(anonymous namespace)::ScalarExprEmitter::VisitUnaryLNot", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter14VisitUnaryLNotEPKN5clang13UnaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter14VisitUnaryLNotEPKN5clang13UnaryOperatorE")
  //</editor-fold>
  public Value /*P*/ VisitUnaryLNot(/*const*/ UnaryOperator /*P*/ E) {
    // Perform vector logical not on comparison with zero vector.
    if (E.getType().$arrow().isExtVectorType()) {
      Value /*P*/ Oper = Visit(E.getSubExpr());
      Value /*P*/ Zero = Constant.getNullValue(Oper.getType());
      Value /*P*/ Result;
      if (Oper.getType().isFPOrFPVectorTy()) {
        Result = Builder.CreateFCmp(CmpInst.Predicate.FCMP_OEQ, Oper, Zero, new Twine(/*KEEP_STR*/"cmp"));
      } else {
        Result = Builder.CreateICmp(CmpInst.Predicate.ICMP_EQ, Oper, Zero, new Twine(/*KEEP_STR*/"cmp"));
      }
      return Builder.CreateSExt(Result, ConvertType(E.getType()), new Twine(/*KEEP_STR*/"sext"));
    }
    
    // Compare operand to zero.
    Value /*P*/ BoolVal = CGF.EvaluateExprAsBool(E.getSubExpr());
    
    // Invert value.
    // TODO: Could dynamically modify easy computations here.  For example, if
    // the operand is an icmp ne, turn into icmp eq.
    BoolVal = Builder.CreateNot(BoolVal, new Twine(/*KEEP_STR*/"lnot"));
    
    // ZExt result to the expr type.
    return Builder.CreateZExt(BoolVal, ConvertType(E.getType()), new Twine(/*KEEP_STR*/"lnot.ext"));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::VisitUnaryReal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 2036,
   FQN="(anonymous namespace)::ScalarExprEmitter::VisitUnaryReal", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter14VisitUnaryRealEPKN5clang13UnaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter14VisitUnaryRealEPKN5clang13UnaryOperatorE")
  //</editor-fold>
  public Value /*P*/ VisitUnaryReal(/*const*/ UnaryOperator /*P*/ E) {
    Expr /*P*/ Op = E.getSubExpr();
    if (Op.getType().$arrow().isAnyComplexType()) {
      // If it's an l-value, load through the appropriate subobject l-value.
      // Note that we have to ask E because Op might be an l-value that
      // this won't work for, e.g. an Obj-C property.
      if (E.isGLValue()) {
        return CGF.EmitLoadOfLValue(CGF.EmitLValue(E), 
            E.getExprLoc()).getScalarVal();
      }
      
      // Otherwise, calculate and project.
      return CGF.EmitComplexExpr(Op, false, true).first;
    }
    
    return Visit(Op);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::VisitUnaryImag">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 2053,
   FQN="(anonymous namespace)::ScalarExprEmitter::VisitUnaryImag", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter14VisitUnaryImagEPKN5clang13UnaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter14VisitUnaryImagEPKN5clang13UnaryOperatorE")
  //</editor-fold>
  public Value /*P*/ VisitUnaryImag(/*const*/ UnaryOperator /*P*/ E) {
    Expr /*P*/ Op = E.getSubExpr();
    if (Op.getType().$arrow().isAnyComplexType()) {
      // If it's an l-value, load through the appropriate subobject l-value.
      // Note that we have to ask E because Op might be an l-value that
      // this won't work for, e.g. an Obj-C property.
      if (Op.isGLValue()) {
        return CGF.EmitLoadOfLValue(CGF.EmitLValue(E), 
            E.getExprLoc()).getScalarVal();
      }
      
      // Otherwise, calculate and project.
      return CGF.EmitComplexExpr(Op, true, false).second;
    }
    
    // __imag on a scalar returns zero.  Emit the subexpr to ensure side
    // effects are evaluated, but not the actual value.
    if (Op.isGLValue()) {
      CGF.EmitLValue(Op);
    } else {
      CGF.EmitScalarExpr(Op, true);
    }
    return Constant.getNullValue(ConvertType(E.getType()));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::VisitUnaryExtension">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 381,
   FQN="(anonymous namespace)::ScalarExprEmitter::VisitUnaryExtension", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter19VisitUnaryExtensionEPKN5clang13UnaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter19VisitUnaryExtensionEPKN5clang13UnaryOperatorE")
  //</editor-fold>
  public Value /*P*/ VisitUnaryExtension(/*const*/ UnaryOperator /*P*/ E) {
    return Visit(E.getSubExpr());
  }

  
  // C++
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::VisitMaterializeTemporaryExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 386,
   FQN="(anonymous namespace)::ScalarExprEmitter::VisitMaterializeTemporaryExpr", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter29VisitMaterializeTemporaryExprEPKN5clang24MaterializeTemporaryExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter29VisitMaterializeTemporaryExprEPKN5clang24MaterializeTemporaryExprE")
  //</editor-fold>
  public Value /*P*/ VisitMaterializeTemporaryExpr(/*const*/ MaterializeTemporaryExpr /*P*/ E) {
    return EmitLoadOfLValue(E);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::VisitCXXDefaultArgExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 390,
   FQN="(anonymous namespace)::ScalarExprEmitter::VisitCXXDefaultArgExpr", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter22VisitCXXDefaultArgExprEPN5clang17CXXDefaultArgExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter22VisitCXXDefaultArgExprEPN5clang17CXXDefaultArgExprE")
  //</editor-fold>
  public Value /*P*/ VisitCXXDefaultArgExpr(CXXDefaultArgExpr /*P*/ DAE) {
    return Visit(DAE.getExpr());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::VisitCXXDefaultInitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 393,
   FQN="(anonymous namespace)::ScalarExprEmitter::VisitCXXDefaultInitExpr", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter23VisitCXXDefaultInitExprEPN5clang18CXXDefaultInitExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter23VisitCXXDefaultInitExprEPN5clang18CXXDefaultInitExprE")
  //</editor-fold>
  public Value /*P*/ VisitCXXDefaultInitExpr(CXXDefaultInitExpr /*P*/ DIE) {
    CodeGenFunction.CXXDefaultInitExprScope Scope = null;
    try {
      Scope/*J*/= new CodeGenFunction.CXXDefaultInitExprScope(CGF);
      return Visit(DIE.getExpr());
    } finally {
      if (Scope != null) { Scope.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::VisitCXXThisExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 397,
   FQN="(anonymous namespace)::ScalarExprEmitter::VisitCXXThisExpr", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter16VisitCXXThisExprEPN5clang11CXXThisExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter16VisitCXXThisExprEPN5clang11CXXThisExprE")
  //</editor-fold>
  public Value /*P*/ VisitCXXThisExpr(CXXThisExpr /*P*/ TE) {
    return CGF.LoadCXXThis();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::VisitExprWithCleanups">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 401,
   FQN="(anonymous namespace)::ScalarExprEmitter::VisitExprWithCleanups", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter21VisitExprWithCleanupsEPN5clang16ExprWithCleanupsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter21VisitExprWithCleanupsEPN5clang16ExprWithCleanupsE")
  //</editor-fold>
  public Value /*P*/ VisitExprWithCleanups(ExprWithCleanups /*P*/ E) {
    CodeGenFunction.RunCleanupsScope Scope = null;
    try {
      CGF.enterFullExpression(E);
      Scope/*J*/= new CodeGenFunction.RunCleanupsScope(CGF);
      return Visit(E.getSubExpr());
    } finally {
      if (Scope != null) { Scope.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::VisitCXXNewExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 406,
   FQN="(anonymous namespace)::ScalarExprEmitter::VisitCXXNewExpr", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter15VisitCXXNewExprEPKN5clang10CXXNewExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter15VisitCXXNewExprEPKN5clang10CXXNewExprE")
  //</editor-fold>
  public Value /*P*/ VisitCXXNewExpr(/*const*/ CXXNewExpr /*P*/ E) {
    return CGF.EmitCXXNewExpr(E);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::VisitCXXDeleteExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 409,
   FQN="(anonymous namespace)::ScalarExprEmitter::VisitCXXDeleteExpr", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter18VisitCXXDeleteExprEPKN5clang13CXXDeleteExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter18VisitCXXDeleteExprEPKN5clang13CXXDeleteExprE")
  //</editor-fold>
  public Value /*P*/ VisitCXXDeleteExpr(/*const*/ CXXDeleteExpr /*P*/ E) {
    CGF.EmitCXXDeleteExpr(E);
    return null;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::VisitTypeTraitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 414,
   FQN="(anonymous namespace)::ScalarExprEmitter::VisitTypeTraitExpr", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter18VisitTypeTraitExprEPKN5clang13TypeTraitExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter18VisitTypeTraitExprEPKN5clang13TypeTraitExprE")
  //</editor-fold>
  public Value /*P*/ VisitTypeTraitExpr(/*const*/ TypeTraitExpr /*P*/ E) {
    return ConstantInt.get(ConvertType(E.getType()), (E.getValue() ? 1 : 0));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::VisitArrayTypeTraitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 418,
   FQN="(anonymous namespace)::ScalarExprEmitter::VisitArrayTypeTraitExpr", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter23VisitArrayTypeTraitExprEPKN5clang18ArrayTypeTraitExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter23VisitArrayTypeTraitExprEPKN5clang18ArrayTypeTraitExprE")
  //</editor-fold>
  public Value /*P*/ VisitArrayTypeTraitExpr(/*const*/ ArrayTypeTraitExpr /*P*/ E) {
    return ConstantInt.get(Builder.getInt32Ty(), E.getValue());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::VisitExpressionTraitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 422,
   FQN="(anonymous namespace)::ScalarExprEmitter::VisitExpressionTraitExpr", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter24VisitExpressionTraitExprEPKN5clang19ExpressionTraitExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter24VisitExpressionTraitExprEPKN5clang19ExpressionTraitExprE")
  //</editor-fold>
  public Value /*P*/ VisitExpressionTraitExpr(/*const*/ ExpressionTraitExpr /*P*/ E) {
    return ConstantInt.get(Builder.getInt1Ty(), (E.getValue() ? 1 : 0));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::VisitCXXPseudoDestructorExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 426,
   FQN="(anonymous namespace)::ScalarExprEmitter::VisitCXXPseudoDestructorExpr", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter28VisitCXXPseudoDestructorExprEPKN5clang23CXXPseudoDestructorExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter28VisitCXXPseudoDestructorExprEPKN5clang23CXXPseudoDestructorExprE")
  //</editor-fold>
  public Value /*P*/ VisitCXXPseudoDestructorExpr(/*const*/ CXXPseudoDestructorExpr /*P*/ E) {
    // C++ [expr.pseudo]p1:
    //   The result shall only be used as the operand for the function call
    //   operator (), and the result of such a call has type void. The only
    //   effect is the evaluation of the postfix-expression before the dot or
    //   arrow.
    CGF.EmitScalarExpr(E.getBase());
    return null;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::VisitCXXNullPtrLiteralExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 436,
   FQN="(anonymous namespace)::ScalarExprEmitter::VisitCXXNullPtrLiteralExpr", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter26VisitCXXNullPtrLiteralExprEPKN5clang21CXXNullPtrLiteralExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter26VisitCXXNullPtrLiteralExprEPKN5clang21CXXNullPtrLiteralExprE")
  //</editor-fold>
  public Value /*P*/ VisitCXXNullPtrLiteralExpr(/*const*/ CXXNullPtrLiteralExpr /*P*/ E) {
    return EmitNullValue(E.getType());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::VisitCXXThrowExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 440,
   FQN="(anonymous namespace)::ScalarExprEmitter::VisitCXXThrowExpr", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter17VisitCXXThrowExprEPKN5clang12CXXThrowExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter17VisitCXXThrowExprEPKN5clang12CXXThrowExprE")
  //</editor-fold>
  public Value /*P*/ VisitCXXThrowExpr(/*const*/ CXXThrowExpr /*P*/ E) {
    CGF.EmitCXXThrowExpr(E);
    return null;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::VisitCXXNoexceptExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 445,
   FQN="(anonymous namespace)::ScalarExprEmitter::VisitCXXNoexceptExpr", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter20VisitCXXNoexceptExprEPKN5clang15CXXNoexceptExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter20VisitCXXNoexceptExprEPKN5clang15CXXNoexceptExprE")
  //</editor-fold>
  public Value /*P*/ VisitCXXNoexceptExpr(/*const*/ CXXNoexceptExpr /*P*/ E) {
    return Builder.getInt1(E.getValue());
  }

  
  // Binary Operators.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::EmitMul">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 450,
   FQN="(anonymous namespace)::ScalarExprEmitter::EmitMul", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter7EmitMulERKNS_9BinOpInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter7EmitMulERKNS_9BinOpInfoE")
  //</editor-fold>
  public Value /*P*/ EmitMul(final /*const*/ BinOpInfo /*&*/ Ops) {
    if (Ops.Ty.$arrow().isSignedIntegerOrEnumerationType()) {
      switch (CGF.getLangOpts().getSignedOverflowBehavior()) {
       case SOB_Defined:
        return Builder.CreateMul(Ops.LHS, Ops.RHS, new Twine(/*KEEP_STR*/"mul"));
       case SOB_Undefined:
        if (!CGF.SanOpts.has(SanitizerKind.SignedIntegerOverflow)) {
          return Builder.CreateNSWMul(Ops.LHS, Ops.RHS, new Twine(/*KEEP_STR*/"mul"));
        }
       case SOB_Trapping:
        // Fall through.
        return EmitOverflowCheckedBinOp(Ops);
      }
    }
    if (Ops.Ty.$arrow().isUnsignedIntegerType()
       && CGF.SanOpts.has(SanitizerKind.UnsignedIntegerOverflow)) {
      return EmitOverflowCheckedBinOp(Ops);
    }
    if (Ops.LHS.getType().isFPOrFPVectorTy()) {
      return Builder.CreateFMul(Ops.LHS, Ops.RHS, new Twine(/*KEEP_STR*/"mul"));
    }
    return Builder.CreateMul(Ops.LHS, Ops.RHS, new Twine(/*KEEP_STR*/"mul"));
  }

  /// Create a binary op that checks for overflow.
  /// Currently only supports +, - and *.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::EmitOverflowCheckedBinOp">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 2308,
   FQN="(anonymous namespace)::ScalarExprEmitter::EmitOverflowCheckedBinOp", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter24EmitOverflowCheckedBinOpERKNS_9BinOpInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter24EmitOverflowCheckedBinOpERKNS_9BinOpInfoE")
  //</editor-fold>
  public Value /*P*/ EmitOverflowCheckedBinOp(final /*const*/ BinOpInfo /*&*/ Ops) {
    /*uint*/int IID;
    /*uint*/int OpID = 0;
    
    boolean isSigned = Ops.Ty.$arrow().isSignedIntegerOrEnumerationType();
    switch (Ops.Opcode) {
     case BO_Add:
     case BO_AddAssign:
      OpID = 1;
      IID = isSigned ? ID.sadd_with_overflow : ID.uadd_with_overflow;
      break;
     case BO_Sub:
     case BO_SubAssign:
      OpID = 2;
      IID = isSigned ? ID.ssub_with_overflow : ID.usub_with_overflow;
      break;
     case BO_Mul:
     case BO_MulAssign:
      OpID = 3;
      IID = isSigned ? ID.smul_with_overflow : ID.umul_with_overflow;
      break;
     default:
      throw new llvm_unreachable("Unsupported operation for overflow detection");
    }
    OpID <<= 1;
    if (isSigned) {
      OpID |= 1;
    }
    
    Type /*P*/ opTy = CGF.CGM.getTypes().ConvertType(new QualType(Ops.Ty));
    
    Function /*P*/ intrinsic = CGF.CGM.getIntrinsic(IID, new ArrayRef<Type /*P*/ >(opTy, true));
    
    Value /*P*/ resultAndOverflow = Builder.CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P(intrinsic, /*{ */new ArrayRef<Value /*P*/ >(new Value /*P*/ /*const*/ [/*2*/] {Ops.LHS, Ops.RHS}, true)/* }*/);
    Value /*P*/ result = Builder.CreateExtractValue(resultAndOverflow, new ArrayRefUInt(0));
    Value /*P*/ overflow = Builder.CreateExtractValue(resultAndOverflow, new ArrayRefUInt(1));
    
    // Handle overflow with llvm.trap if no custom handler has been specified.
    /*const*/std.string/*P*/ handlerName = /*AddrOf*/CGF.getLangOpts().OverflowHandler;
    if (handlerName.empty()) {
      // If the signed-integer-overflow sanitizer is enabled, emit a call to its
      // runtime. Otherwise, this is a -ftrapv check, so just emit a trap.
      if (!isSigned || CGF.SanOpts.has(SanitizerKind.SignedIntegerOverflow)) {
        CodeGenFunction.SanitizerScope SanScope = null;
        try {
          SanScope/*J*/= new CodeGenFunction.SanitizerScope(/*AddrOf*/CGF);
          Value /*P*/ NotOverflow = Builder.CreateNot(overflow);
          long/*uint64_t*/ Kind = isSigned ? SanitizerKind.SignedIntegerOverflow : SanitizerKind.UnsignedIntegerOverflow;
          EmitBinOpCheck(new ArrayRef<std.pairPtrULong<Value /*P*/ >>(std.make_pair_Ptr_ulong(NotOverflow, Kind), false), Ops);
        } finally {
          if (SanScope != null) { SanScope.$destroy(); }
        }
      } else {
        CGF.EmitTrapCheck(Builder.CreateNot(overflow));
      }
      return result;
    }
    
    // Branch in case of overflow.
    BasicBlock /*P*/ initialBB = Builder.GetInsertBlock();
    ilist_iterator<BasicBlock> insertPt = initialBB.getIterator();
    BasicBlock /*P*/ continueBB = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"nooverflow"), CGF.CurFn, 
        /*AddrOf*/std.next(new ilist_iterator<BasicBlock>(insertPt)).$star());
    BasicBlock /*P*/ overflowBB = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"overflow"), CGF.CurFn);
    
    Builder.CreateCondBr(overflow, overflowBB, continueBB);
    
    // If an overflow handler is set, then we want to call it and then use its
    // result, if it returns.
    Builder.SetInsertPoint(overflowBB);
    
    // Get the overflow handler.
    Type /*P*/ Int8Ty = CGF.Int8Ty;
    Type /*P*/ argTypes[/*4*/] = new Type /*P*/  [/*4*/] {CGF.Int64Ty, CGF.Int64Ty, Int8Ty, Int8Ty};
    FunctionType /*P*/ handlerTy = FunctionType.get(CGF.Int64Ty, new ArrayRef<Type /*P*/ >(argTypes, true), true);
    Value /*P*/ handler = CGF.CGM.CreateRuntimeFunction(handlerTy, new StringRef(/*Deref*/handlerName));
    
    // Sign extend the args to 64-bit, so that we can use the same handler for
    // all types of overflow.
    Value /*P*/ lhs = Builder.CreateSExt(Ops.LHS, CGF.Int64Ty);
    Value /*P*/ rhs = Builder.CreateSExt(Ops.RHS, CGF.Int64Ty);
    
    // Call the handler with the two arguments, the operation, and the size of
    // the result.
    Value /*P*/ handlerArgs[/*4*/] = new Value /*P*/  [/*4*/] {
      lhs, 
      rhs, 
      Builder.getInt8($uint2uchar(OpID)), 
      Builder.getInt8($uint2uchar(cast_IntegerType(opTy).getBitWidth()))
    };
    Value /*P*/ handlerResult = CGF.EmitNounwindRuntimeCall(handler, new ArrayRef<Value /*P*/ >(handlerArgs, true));
    
    // Truncate the result back to the desired size.
    handlerResult = Builder.CreateTrunc(handlerResult, opTy);
    Builder.CreateBr(continueBB);
    
    Builder.SetInsertPoint(continueBB);
    PHINode /*P*/ phi = Builder.CreatePHI(opTy, 2);
    phi.addIncoming(result, initialBB);
    phi.addIncoming(handlerResult, overflowBB);
    
    return phi;
  }

  
  // Check for undefined division and modulus behaviors.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::EmitUndefinedBehaviorIntegerDivAndRemCheck">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 2229,
   FQN="(anonymous namespace)::ScalarExprEmitter::EmitUndefinedBehaviorIntegerDivAndRemCheck", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter42EmitUndefinedBehaviorIntegerDivAndRemCheckERKNS_9BinOpInfoEPN4llvm5ValueEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter42EmitUndefinedBehaviorIntegerDivAndRemCheckERKNS_9BinOpInfoEPN4llvm5ValueEb")
  //</editor-fold>
  public void EmitUndefinedBehaviorIntegerDivAndRemCheck(final /*const*/ BinOpInfo /*&*/ Ops, Value /*P*/ Zero, boolean isDiv) {
    SmallVector<std.pairPtrULong<Value /*P*/ >> Checks/*J*/= new SmallVector<std.pairPtrULong<Value /*P*/ >>(2, new std.pairPtrULong<Value /*P*/ >());
    if (CGF.SanOpts.has(SanitizerKind.IntegerDivideByZero)) {
      Checks.push_back(std.make_pair_Ptr_ulong(Builder.CreateICmpNE(Ops.RHS, Zero), 
              SanitizerKind.IntegerDivideByZero));
    }
    if (CGF.SanOpts.has(SanitizerKind.SignedIntegerOverflow)
       && Ops.Ty.$arrow().hasSignedIntegerRepresentation()) {
      IntegerType /*P*/ Ty = cast_IntegerType(Zero.getType());
      
      Value /*P*/ IntMin = Builder.getInt(APInt.getSignedMinValue(Ty.getBitWidth()));
      Value /*P*/ NegOne = ConstantInt.get(Ty, -1L/*ULL*/);
      
      Value /*P*/ LHSCmp = Builder.CreateICmpNE(Ops.LHS, IntMin);
      Value /*P*/ RHSCmp = Builder.CreateICmpNE(Ops.RHS, NegOne);
      Value /*P*/ NotOverflow = Builder.CreateOr(LHSCmp, RHSCmp, new Twine(/*KEEP_STR*/"or"));
      Checks.push_back(std.make_pair_Ptr_ulong(NotOverflow, SanitizerKind.SignedIntegerOverflow));
    }
    if ($greater_uint(Checks.size(), 0)) {
      EmitBinOpCheck(new ArrayRef<std.pairPtrULong<Value /*P*/ >>(Checks, false), Ops);
    }
  }

  // Common helper for getting how wide LHS of shift is.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::GetWidthMinusOneValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 2692,
   FQN="(anonymous namespace)::ScalarExprEmitter::GetWidthMinusOneValue", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter21GetWidthMinusOneValueEPN4llvm5ValueES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter21GetWidthMinusOneValueEPN4llvm5ValueES3_")
  //</editor-fold>
  public static Value /*P*/ GetWidthMinusOneValue(Value /*P*/ LHS, Value /*P*/ RHS) {
    IntegerType /*P*/ Ty;
    {
      VectorType /*P*/ VT = dyn_cast_VectorType(LHS.getType());
      if ((VT != null)) {
        Ty = cast_IntegerType(VT.getElementType());
      } else {
        Ty = cast_IntegerType(LHS.getType());
      }
    }
    return ConstantInt.get(RHS.getType(), $uint2ulong(Ty.getBitWidth() - 1));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::EmitDiv">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 2257,
   FQN="(anonymous namespace)::ScalarExprEmitter::EmitDiv", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter7EmitDivERKNS_9BinOpInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter7EmitDivERKNS_9BinOpInfoE")
  //</editor-fold>
  public Value /*P*/ EmitDiv(final /*const*/ BinOpInfo /*&*/ Ops) {
    {
      CodeGenFunction.SanitizerScope SanScope = null;
      try {
        SanScope/*J*/= new CodeGenFunction.SanitizerScope(/*AddrOf*/CGF);
        if ((CGF.SanOpts.has(SanitizerKind.IntegerDivideByZero)
           || CGF.SanOpts.has(SanitizerKind.SignedIntegerOverflow))
           && Ops.Ty.$arrow().isIntegerType()) {
          Value /*P*/ Zero = Constant.getNullValue(ConvertType(new QualType(Ops.Ty)));
          EmitUndefinedBehaviorIntegerDivAndRemCheck(Ops, Zero, true);
        } else if (CGF.SanOpts.has(SanitizerKind.FloatDivideByZero)
           && Ops.Ty.$arrow().isRealFloatingType()) {
          Value /*P*/ Zero = Constant.getNullValue(ConvertType(new QualType(Ops.Ty)));
          Value /*P*/ NonZero = Builder.CreateFCmpUNE(Ops.RHS, Zero);
          EmitBinOpCheck(new ArrayRef<std.pairPtrULong<Value /*P*/ >>(std.make_pair_Ptr_ulong(NonZero, SanitizerKind.FloatDivideByZero), false), 
              Ops);
        }
      } finally {
        if (SanScope != null) { SanScope.$destroy(); }
      }
    }
    if (Ops.LHS.getType().isFPOrFPVectorTy()) {
      Value /*P*/ Val = Builder.CreateFDiv(Ops.LHS, Ops.RHS, new Twine(/*KEEP_STR*/"div"));
      if (CGF.getLangOpts().OpenCL) {
        // OpenCL 1.1 7.4: minimum accuracy of single precision / is 2.5ulp
        Type /*P*/ ValTy = Val.getType();
        if (ValTy.isFloatTy()
           || (isa_VectorType(ValTy)
           && cast_VectorType(ValTy).getElementType().isFloatTy())) {
          CGF.SetFPAccuracy(Val, (float) 2.5);
        }
      }
      return Val;
    } else if (Ops.Ty.$arrow().hasUnsignedIntegerRepresentation()) {
      return Builder.CreateUDiv(Ops.LHS, Ops.RHS, new Twine(/*KEEP_STR*/"div"));
    } else {
      return Builder.CreateSDiv(Ops.LHS, Ops.RHS, new Twine(/*KEEP_STR*/"div"));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::EmitRem">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 2292,
   FQN="(anonymous namespace)::ScalarExprEmitter::EmitRem", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter7EmitRemERKNS_9BinOpInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter7EmitRemERKNS_9BinOpInfoE")
  //</editor-fold>
  public Value /*P*/ EmitRem(final /*const*/ BinOpInfo /*&*/ Ops) {
    // Rem in C can't be a floating point type: C99 6.5.5p2.
    if (CGF.SanOpts.has(SanitizerKind.IntegerDivideByZero)) {
      CodeGenFunction.SanitizerScope SanScope = null;
      try {
        SanScope/*J*/= new CodeGenFunction.SanitizerScope(/*AddrOf*/CGF);
        Value /*P*/ Zero = Constant.getNullValue(ConvertType(new QualType(Ops.Ty)));
        if (Ops.Ty.$arrow().isIntegerType()) {
          EmitUndefinedBehaviorIntegerDivAndRemCheck(Ops, Zero, false);
        }
      } finally {
        if (SanScope != null) { SanScope.$destroy(); }
      }
    }
    if (Ops.Ty.$arrow().hasUnsignedIntegerRepresentation()) {
      return Builder.CreateURem(Ops.LHS, Ops.RHS, new Twine(/*KEEP_STR*/"rem"));
    } else {
      return Builder.CreateSRem(Ops.LHS, Ops.RHS, new Twine(/*KEEP_STR*/"rem"));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::EmitAdd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 2571,
   FQN="(anonymous namespace)::ScalarExprEmitter::EmitAdd", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter7EmitAddERKNS_9BinOpInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter7EmitAddERKNS_9BinOpInfoE")
  //</editor-fold>
  public Value /*P*/ EmitAdd(final /*const*/ BinOpInfo /*&*/ op) {
    if (op.LHS.getType().isPointerTy()
       || op.RHS.getType().isPointerTy()) {
      return emitPointerArithmetic(CGF, op, /*subtraction*/ false);
    }
    if (op.Ty.$arrow().isSignedIntegerOrEnumerationType()) {
      switch (CGF.getLangOpts().getSignedOverflowBehavior()) {
       case SOB_Defined:
        return Builder.CreateAdd(op.LHS, op.RHS, new Twine(/*KEEP_STR*/"add"));
       case SOB_Undefined:
        if (!CGF.SanOpts.has(SanitizerKind.SignedIntegerOverflow)) {
          return Builder.CreateNSWAdd(op.LHS, op.RHS, new Twine(/*KEEP_STR*/"add"));
        }
       case SOB_Trapping:
        // Fall through.
        return EmitOverflowCheckedBinOp(op);
      }
    }
    if (op.Ty.$arrow().isUnsignedIntegerType()
       && CGF.SanOpts.has(SanitizerKind.UnsignedIntegerOverflow)) {
      return EmitOverflowCheckedBinOp(op);
    }
    if (op.LHS.getType().isFPOrFPVectorTy()) {
      {
        // Try to form an fmuladd.
        Value /*P*/ FMulAdd = tryEmitFMulAdd(op, CGF, Builder);
        if ((FMulAdd != null)) {
          return FMulAdd;
        }
      }
      
      return Builder.CreateFAdd(op.LHS, op.RHS, new Twine(/*KEEP_STR*/"add"));
    }
    
    return Builder.CreateAdd(op.LHS, op.RHS, new Twine(/*KEEP_STR*/"add"));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::EmitSub">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 2604,
   FQN="(anonymous namespace)::ScalarExprEmitter::EmitSub", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter7EmitSubERKNS_9BinOpInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter7EmitSubERKNS_9BinOpInfoE")
  //</editor-fold>
  public Value /*P*/ EmitSub(final /*const*/ BinOpInfo /*&*/ op) {
    // The LHS is always a pointer if either side is.
    if (!op.LHS.getType().isPointerTy()) {
      if (op.Ty.$arrow().isSignedIntegerOrEnumerationType()) {
        switch (CGF.getLangOpts().getSignedOverflowBehavior()) {
         case SOB_Defined:
          return Builder.CreateSub(op.LHS, op.RHS, new Twine(/*KEEP_STR*/"sub"));
         case SOB_Undefined:
          if (!CGF.SanOpts.has(SanitizerKind.SignedIntegerOverflow)) {
            return Builder.CreateNSWSub(op.LHS, op.RHS, new Twine(/*KEEP_STR*/"sub"));
          }
         case SOB_Trapping:
          // Fall through.
          return EmitOverflowCheckedBinOp(op);
        }
      }
      if (op.Ty.$arrow().isUnsignedIntegerType()
         && CGF.SanOpts.has(SanitizerKind.UnsignedIntegerOverflow)) {
        return EmitOverflowCheckedBinOp(op);
      }
      if (op.LHS.getType().isFPOrFPVectorTy()) {
        {
          // Try to form an fmuladd.
          Value /*P*/ FMulAdd = tryEmitFMulAdd(op, CGF, Builder, true);
          if ((FMulAdd != null)) {
            return FMulAdd;
          }
        }
        return Builder.CreateFSub(op.LHS, op.RHS, new Twine(/*KEEP_STR*/"sub"));
      }
      
      return Builder.CreateSub(op.LHS, op.RHS, new Twine(/*KEEP_STR*/"sub"));
    }
    
    // If the RHS is not a pointer, then we have normal pointer
    // arithmetic.
    if (!op.RHS.getType().isPointerTy()) {
      return emitPointerArithmetic(CGF, op, /*subtraction*/ true);
    }
    
    // Otherwise, this is a pointer subtraction.
    
    // Do the raw subtraction part.
    Value /*P*/ LHS = Builder.CreatePtrToInt(op.LHS, CGF.Unnamed_field8.PtrDiffTy, new Twine(/*KEEP_STR*/"sub.ptr.lhs.cast"));
    Value /*P*/ RHS = Builder.CreatePtrToInt(op.RHS, CGF.Unnamed_field8.PtrDiffTy, new Twine(/*KEEP_STR*/"sub.ptr.rhs.cast"));
    Value /*P*/ diffInChars = Builder.CreateSub(LHS, RHS, new Twine(/*KEEP_STR*/"sub.ptr.sub"));
    
    // Okay, figure out the element size.
    /*const*/ BinaryOperator /*P*/ expr = cast_BinaryOperator(op.E);
    QualType elementType = expr.getLHS().getType().$arrow().getPointeeType();
    
    Value /*P*/ divisor = null;
    {
      
      // For a variable-length array, this is going to be non-constant.
      /*const*/ VariableArrayType /*P*/ vla = CGF.getContext().getAsVariableArrayType(new QualType(elementType));
      if ((vla != null)) {
        Value /*P*/ numElements;
        final pair<Value, QualType> vlaSize = CGF.getVLASize(vla);
        numElements = vlaSize.first;
        elementType = vlaSize.second;
        divisor = numElements;
        
        // Scale the number of non-VLA elements by the non-VLA element size.
        CharUnits eltSize = CGF.getContext().getTypeSizeInChars(/*NO_COPY*/elementType);
        if (!eltSize.isOne()) {
          divisor = CGF.Builder.CreateNUWMul(CGF.CGM.getSize(new CharUnits(eltSize)), divisor);
        }
        // For everything elese, we can just compute it, safe in the
        // assumption that Sema won't let anything through that we can't
        // safely compute the size of.
      } else {
        CharUnits elementSize/*J*/= new CharUnits();
        // Handle GCC extension for pointer arithmetic on void* and
        // function pointer types.
        if (elementType.$arrow().isVoidType() || elementType.$arrow().isFunctionType()) {
          elementSize.$assignMove(CharUnits.One());
        } else {
          elementSize.$assignMove(CGF.getContext().getTypeSizeInChars(/*NO_COPY*/elementType));
        }
        
        // Don't even emit the divide for element size of 1.
        if (elementSize.isOne()) {
          return diffInChars;
        }
        
        divisor = CGF.CGM.getSize(new CharUnits(elementSize));
      }
    }
    
    // Otherwise, do a full sdiv. This uses the "exact" form of sdiv, since
    // pointer difference in C is only defined in the case where both operands
    // are pointing to elements of an array.
    return Builder.CreateExactSDiv(diffInChars, divisor, new Twine(/*KEEP_STR*/"sub.ptr.div"));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::EmitShl">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*make_pair*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 2701,
   FQN="(anonymous namespace)::ScalarExprEmitter::EmitShl", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter7EmitShlERKNS_9BinOpInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter7EmitShlERKNS_9BinOpInfoE")
  //</editor-fold>
  public Value /*P*/ EmitShl(final /*const*/ BinOpInfo /*&*/ Ops) {
    // LLVM requires the LHS and RHS to be the same type: promote or truncate the
    // RHS to the same size as the LHS.
    Value /*P*/ RHS = Ops.RHS;
    if (Ops.LHS.getType() != RHS.getType()) {
      RHS = Builder.CreateIntCast(RHS, Ops.LHS.getType(), false, new Twine(/*KEEP_STR*/"sh_prom"));
    }
    
    boolean SanitizeBase = CGF.SanOpts.has(SanitizerKind.ShiftBase)
       && Ops.Ty.$arrow().hasSignedIntegerRepresentation()
       && !CGF.getLangOpts().isSignedOverflowDefined();
    boolean SanitizeExponent = CGF.SanOpts.has(SanitizerKind.ShiftExponent);
    // OpenCL 6.3j: shift values are effectively % word size of LHS.
    if (CGF.getLangOpts().OpenCL) {
      RHS
         = Builder.CreateAnd(RHS, GetWidthMinusOneValue(Ops.LHS, RHS), new Twine(/*KEEP_STR*/"shl.mask"));
    } else if ((SanitizeBase || SanitizeExponent)
       && isa_IntegerType(Ops.LHS.getType())) {
      CodeGenFunction.SanitizerScope SanScope = null;
      try {
        SanScope/*J*/= new CodeGenFunction.SanitizerScope(/*AddrOf*/CGF);
        SmallVector<std.pairPtrULong<Value /*P*/ >> Checks/*J*/= new SmallVector<std.pairPtrULong<Value /*P*/ >>(2, new std.pairPtrULong<Value /*P*/ >());
        Value /*P*/ WidthMinusOne = GetWidthMinusOneValue(Ops.LHS, RHS);
        Value /*P*/ ValidExponent = Builder.CreateICmpULE(RHS, WidthMinusOne);
        if (SanitizeExponent) {
          Checks.push_back(std.make_pair_Ptr_ulong(ValidExponent, SanitizerKind.ShiftExponent));
        }
        if (SanitizeBase) {
          // Check whether we are shifting any non-zero bits off the top of the
          // integer. We only emit this check if exponent is valid - otherwise
          // instructions below will have undefined behavior themselves.
          BasicBlock /*P*/ Orig = Builder.GetInsertBlock();
          BasicBlock /*P*/ Cont = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"cont"));
          BasicBlock /*P*/ CheckShiftBase = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"check"));
          Builder.CreateCondBr(ValidExponent, CheckShiftBase, Cont);
          CGF.EmitBlock(CheckShiftBase);
          Value /*P*/ BitsShiftedOff = Builder.CreateLShr(Ops.LHS, 
              Builder.CreateSub(WidthMinusOne, RHS, new Twine(/*KEEP_STR*/"shl.zeros"), 
                  /*NUW*/ true, /*NSW*/ true), 
              new Twine(/*KEEP_STR*/"shl.check"));
          if (CGF.getLangOpts().CPlusPlus) {
            // In C99, we are not permitted to shift a 1 bit into the sign bit.
            // Under C++11's rules, shifting a 1 bit into the sign bit is
            // OK, but shifting a 1 bit out of it is not. (C89 and C++03 don't
            // define signed left shifts, so we use the C99 and C++11 rules there).
            Value /*P*/ One = ConstantInt.get(BitsShiftedOff.getType(), $int2ulong(1));
            BitsShiftedOff = Builder.CreateLShr(BitsShiftedOff, One);
          }
          Value /*P*/ Zero = ConstantInt.get(BitsShiftedOff.getType(), $int2ulong(0));
          Value /*P*/ ValidBase = Builder.CreateICmpEQ(BitsShiftedOff, Zero);
          CGF.EmitBlock(Cont);
          PHINode /*P*/ BaseCheck = Builder.CreatePHI(ValidBase.getType(), 2);
          BaseCheck.addIncoming(Builder.getTrue(), Orig);
          BaseCheck.addIncoming(ValidBase, CheckShiftBase);
          Checks.push_back(std.make_pair_Ptr_ulong((Value /*P*/)BaseCheck, SanitizerKind.ShiftBase));
        }
        assert (!Checks.empty());
        EmitBinOpCheck(new ArrayRef<std.pairPtrULong<Value /*P*/ >>(Checks, false), Ops);
      } finally {
        if (SanScope != null) { SanScope.$destroy(); }
      }
    }
    
    return Builder.CreateShl(Ops.LHS, RHS, new Twine(/*KEEP_STR*/"shl"));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::EmitShr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 2766,
   FQN="(anonymous namespace)::ScalarExprEmitter::EmitShr", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter7EmitShrERKNS_9BinOpInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter7EmitShrERKNS_9BinOpInfoE")
  //</editor-fold>
  public Value /*P*/ EmitShr(final /*const*/ BinOpInfo /*&*/ Ops) {
    // LLVM requires the LHS and RHS to be the same type: promote or truncate the
    // RHS to the same size as the LHS.
    Value /*P*/ RHS = Ops.RHS;
    if (Ops.LHS.getType() != RHS.getType()) {
      RHS = Builder.CreateIntCast(RHS, Ops.LHS.getType(), false, new Twine(/*KEEP_STR*/"sh_prom"));
    }
    
    // OpenCL 6.3j: shift values are effectively % word size of LHS.
    if (CGF.getLangOpts().OpenCL) {
      RHS
         = Builder.CreateAnd(RHS, GetWidthMinusOneValue(Ops.LHS, RHS), new Twine(/*KEEP_STR*/"shr.mask"));
    } else if (CGF.SanOpts.has(SanitizerKind.ShiftExponent)
       && isa_IntegerType(Ops.LHS.getType())) {
      CodeGenFunction.SanitizerScope SanScope = null;
      try {
        SanScope/*J*/= new CodeGenFunction.SanitizerScope(/*AddrOf*/CGF);
        Value /*P*/ Valid = Builder.CreateICmpULE(RHS, GetWidthMinusOneValue(Ops.LHS, RHS));
        EmitBinOpCheck(new ArrayRef<std.pairPtrULong<Value /*P*/ >>(std.make_pair_Ptr_ulong(Valid, SanitizerKind.ShiftExponent), false), Ops);
      } finally {
        if (SanScope != null) { SanScope.$destroy(); }
      }
    }
    if (Ops.Ty.$arrow().hasUnsignedIntegerRepresentation()) {
      return Builder.CreateLShr(Ops.LHS, RHS, new Twine(/*KEEP_STR*/"shr"));
    }
    return Builder.CreateAShr(Ops.LHS, RHS, new Twine(/*KEEP_STR*/"shr"));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::EmitAnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 487,
   FQN="(anonymous namespace)::ScalarExprEmitter::EmitAnd", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter7EmitAndERKNS_9BinOpInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter7EmitAndERKNS_9BinOpInfoE")
  //</editor-fold>
  public Value /*P*/ EmitAnd(final /*const*/ BinOpInfo /*&*/ Ops) {
    return Builder.CreateAnd(Ops.LHS, Ops.RHS, new Twine(/*KEEP_STR*/"and"));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::EmitXor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 490,
   FQN="(anonymous namespace)::ScalarExprEmitter::EmitXor", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter7EmitXorERKNS_9BinOpInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter7EmitXorERKNS_9BinOpInfoE")
  //</editor-fold>
  public Value /*P*/ EmitXor(final /*const*/ BinOpInfo /*&*/ Ops) {
    return Builder.CreateXor(Ops.LHS, Ops.RHS, new Twine(/*KEEP_STR*/"xor"));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::EmitOr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 493,
   FQN="(anonymous namespace)::ScalarExprEmitter::EmitOr", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter6EmitOrERKNS_9BinOpInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter6EmitOrERKNS_9BinOpInfoE")
  //</editor-fold>
  public Value /*P*/ EmitOr(final /*const*/ BinOpInfo /*&*/ Ops) {
    return Builder.CreateOr(Ops.LHS, Ops.RHS, new Twine(/*KEEP_STR*/"or"));
  }

  
  
  //===----------------------------------------------------------------------===//
  //                           Binary Operators
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::EmitBinOps">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 2080,
   FQN="(anonymous namespace)::ScalarExprEmitter::EmitBinOps", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter10EmitBinOpsEPKN5clang14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter10EmitBinOpsEPKN5clang14BinaryOperatorE")
  //</editor-fold>
  public BinOpInfo EmitBinOps(/*const*/ BinaryOperator /*P*/ E) {
    TestAndClearIgnoreResultAssign();
    BinOpInfo Result/*J*/= new BinOpInfo();
    Result.LHS = Visit(E.getLHS());
    Result.RHS = Visit(E.getRHS());
    Result.Ty.$assignMove(E.getType());
    Result.Opcode = E.getOpcode();
    Result.FPContractable = E.isFPContractable();
    Result.E = E;
    return Result;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::EmitCompoundAssignLValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 2092,
   FQN="(anonymous namespace)::ScalarExprEmitter::EmitCompoundAssignLValue", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter24EmitCompoundAssignLValueEPKN5clang22CompoundAssignOperatorEMS0_FPN4llvm5ValueERKNS_9BinOpInfoEERS7_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter24EmitCompoundAssignLValueEPKN5clang22CompoundAssignOperatorEMS0_FPN4llvm5ValueERKNS_9BinOpInfoEERS7_")
  //</editor-fold>
  public LValue EmitCompoundAssignLValue(/*const*/ CompoundAssignOperator /*P*/ E, 
                          ScalarExprEmitter.Func Func, 
                          final type$ref<Value /*P*/ /*&*/> Result) {
    QualType LHSTy = E.getLHS().getType();
    BinOpInfo OpInfo/*J*/= new BinOpInfo();
    if (E.getComputationResultType().$arrow().isAnyComplexType()) {
      return CGF.EmitScalarCompoundAssignWithComplex(E, Result);
    }
    
    // Emit the RHS first.  __block variables need to have the rhs evaluated
    // first, plus this should improve codegen a little.
    OpInfo.RHS = Visit(E.getRHS());
    OpInfo.Ty.$assignMove(E.getComputationResultType());
    OpInfo.Opcode = E.getOpcode();
    OpInfo.FPContractable = E.isFPContractable();
    OpInfo.E = E;
    // Load/convert the LHS.
    LValue LHSLV = EmitCheckedLValue(E.getLHS(), CodeGenFunction.TypeCheckKind.TCK_Store);
    
    PHINode /*P*/ atomicPHI = null;
    {
      /*const*/ AtomicType /*P*/ atomicTy = LHSTy.$arrow().getAs(AtomicType.class);
      if ((atomicTy != null)) {
        QualType type = atomicTy.getValueType();
        if (!type.$arrow().isBooleanType() && type.$arrow().isIntegerType()
           && !(type.$arrow().isUnsignedIntegerType()
           && CGF.SanOpts.has(SanitizerKind.UnsignedIntegerOverflow))
           && CGF.getLangOpts().getSignedOverflowBehavior()
           != LangOptions.SignedOverflowBehaviorTy.SOB_Trapping) {
          AtomicRMWInst.BinOp aop = AtomicRMWInst.BinOp.BAD_BINOP;
          switch (OpInfo.Opcode) {
           case BO_MulAssign:
           case BO_DivAssign:
           case BO_RemAssign:
           case BO_ShlAssign:
           case BO_ShrAssign:
            // We don't have atomicrmw operands for *, %, /, <<, >>
            break;
           case BO_AddAssign:
            aop = AtomicRMWInst.BinOp.Add;
            break;
           case BO_SubAssign:
            aop = AtomicRMWInst.BinOp.Sub;
            break;
           case BO_AndAssign:
            aop = AtomicRMWInst.BinOp.And;
            break;
           case BO_XorAssign:
            aop = AtomicRMWInst.BinOp.Xor;
            break;
           case BO_OrAssign:
            aop = AtomicRMWInst.BinOp.Or;
            break;
           default:
            throw new llvm_unreachable("Invalid compound assignment type");
          }
          if (aop != AtomicRMWInst.BinOp.BAD_BINOP) {
            Value /*P*/ amt = CGF.EmitToMemory(EmitScalarConversion(OpInfo.RHS, E.getRHS().getType(), new QualType(LHSTy), 
                    E.getExprLoc()), 
                new QualType(LHSTy));
            Builder.CreateAtomicRMW(aop, LHSLV.getPointer(), amt, 
                AtomicOrdering.SequentiallyConsistent);
            return LHSLV;
          }
        }
        // FIXME: For floating point types, we should be saving and restoring the
        // floating point environment in the loop.
        BasicBlock /*P*/ startBB = Builder.GetInsertBlock();
        BasicBlock /*P*/ opBB = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"atomic_op"), CGF.CurFn);
        OpInfo.LHS = EmitLoadOfLValue(new LValue(LHSLV), E.getExprLoc());
        OpInfo.LHS = CGF.EmitToMemory(OpInfo.LHS, new QualType(type));
        Builder.CreateBr(opBB);
        Builder.SetInsertPoint(opBB);
        atomicPHI = Builder.CreatePHI(OpInfo.LHS.getType(), 2);
        atomicPHI.addIncoming(OpInfo.LHS, startBB);
        OpInfo.LHS = atomicPHI;
      } else {
        OpInfo.LHS = EmitLoadOfLValue(new LValue(LHSLV), E.getExprLoc());
      }
    }
    
    SourceLocation Loc = E.getExprLoc();
    OpInfo.LHS
       = EmitScalarConversion(OpInfo.LHS, new QualType(LHSTy), E.getComputationLHSType(), new SourceLocation(Loc));
    
    // Expand the binary operator.
    Result.$set(Func.$call(/*PtrMemI*/this, OpInfo));
    
    // Convert the result back to the LHS type.
    Result.$set(EmitScalarConversion(Result.$deref(), E.getComputationResultType(), new QualType(LHSTy), new SourceLocation(Loc)));
    if ((atomicPHI != null)) {
      BasicBlock /*P*/ opBB = Builder.GetInsertBlock();
      BasicBlock /*P*/ contBB = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"atomic_cont"), CGF.CurFn);
      std.pair<RValue, Value /*P*/ > Pair = CGF.EmitAtomicCompareExchange(new LValue(LHSLV), RValue.get(atomicPHI), RValue.get(Result.$deref()), E.getExprLoc());
      Value /*P*/ old = CGF.EmitToMemory(Pair.first.getScalarVal(), new QualType(LHSTy));
      Value /*P*/ success = Pair.second;
      atomicPHI.addIncoming(old, opBB);
      Builder.CreateCondBr(success, contBB, opBB);
      Builder.SetInsertPoint(contBB);
      return LHSLV;
    }
    
    // Store the result value into the LHS lvalue. Bit-fields are handled
    // specially because the result is altered by the store, i.e., [C99 6.5.16p1]
    // 'An assignment expression has the value of the left operand after the
    // assignment...'.
    if (LHSLV.isBitField()) {
      CGF.EmitStoreThroughBitfieldLValue(RValue.get(Result.$deref()), new LValue(LHSLV), Result.deref$ptr());
    } else {
      CGF.EmitStoreThroughLValue(RValue.get(Result.$deref()), new LValue(LHSLV));
    }
    
    return LHSLV;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::EmitCompoundAssign">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 2207,
   FQN="(anonymous namespace)::ScalarExprEmitter::EmitCompoundAssign", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter18EmitCompoundAssignEPKN5clang22CompoundAssignOperatorEMS0_FPN4llvm5ValueERKNS_9BinOpInfoEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter18EmitCompoundAssignEPKN5clang22CompoundAssignOperatorEMS0_FPN4llvm5ValueERKNS_9BinOpInfoEE")
  //</editor-fold>
  public Value /*P*/ EmitCompoundAssign(/*const*/ CompoundAssignOperator /*P*/ E, 
                    ScalarExprEmitter.Func Func) {
    boolean Ignore = TestAndClearIgnoreResultAssign();
    type$ref<Value /*P*/ > RHS = create_type$ref();
    LValue LHS = EmitCompoundAssignLValue(E, Func, RHS);
    
    // If the result is clearly ignored, return now.
    if (Ignore) {
      return null;
    }
    
    // The result of an assignment in C is the assigned r-value.
    if (!CGF.getLangOpts().CPlusPlus) {
      return RHS.$deref();
    }
    
    // If the lvalue is non-volatile, return the computed value of the assignment.
    if (!LHS.isVolatileQualified()) {
      return RHS.$deref();
    }
    
    // Otherwise, reload the value.
    return EmitLoadOfLValue(new LValue(LHS), E.getExprLoc());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::VisitBinMul">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 513,
   FQN="(anonymous namespace)::ScalarExprEmitter::VisitBinMul", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter11VisitBinMulEPKN5clang14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter11VisitBinMulEPKN5clang14BinaryOperatorE")
  //</editor-fold>
  public Value /*P*/ VisitBinMul(/*const*/ BinaryOperator /*P*/ E) {
    return EmitMul(EmitBinOps(E));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::VisitBinMulAssign">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 513,
   FQN="(anonymous namespace)::ScalarExprEmitter::VisitBinMulAssign", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter17VisitBinMulAssignEPKN5clang22CompoundAssignOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter17VisitBinMulAssignEPKN5clang22CompoundAssignOperatorE")
  //</editor-fold>
  public Value /*P*/ VisitBinMulAssign(/*const*/ CompoundAssignOperator /*P*/ E) {
    return EmitCompoundAssign(E, /*AddrOf*//*FPtr*/ScalarExprEmitter::EmitMul);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::VisitBinDiv">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 514,
   FQN="(anonymous namespace)::ScalarExprEmitter::VisitBinDiv", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter11VisitBinDivEPKN5clang14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter11VisitBinDivEPKN5clang14BinaryOperatorE")
  //</editor-fold>
  public Value /*P*/ VisitBinDiv(/*const*/ BinaryOperator /*P*/ E) {
    return EmitDiv(EmitBinOps(E));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::VisitBinDivAssign">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 514,
   FQN="(anonymous namespace)::ScalarExprEmitter::VisitBinDivAssign", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter17VisitBinDivAssignEPKN5clang22CompoundAssignOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter17VisitBinDivAssignEPKN5clang22CompoundAssignOperatorE")
  //</editor-fold>
  public Value /*P*/ VisitBinDivAssign(/*const*/ CompoundAssignOperator /*P*/ E) {
    return EmitCompoundAssign(E, /*AddrOf*//*FPtr*/ScalarExprEmitter::EmitDiv);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::VisitBinRem">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 515,
   FQN="(anonymous namespace)::ScalarExprEmitter::VisitBinRem", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter11VisitBinRemEPKN5clang14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter11VisitBinRemEPKN5clang14BinaryOperatorE")
  //</editor-fold>
  public Value /*P*/ VisitBinRem(/*const*/ BinaryOperator /*P*/ E) {
    return EmitRem(EmitBinOps(E));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::VisitBinRemAssign">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 515,
   FQN="(anonymous namespace)::ScalarExprEmitter::VisitBinRemAssign", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter17VisitBinRemAssignEPKN5clang22CompoundAssignOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter17VisitBinRemAssignEPKN5clang22CompoundAssignOperatorE")
  //</editor-fold>
  public Value /*P*/ VisitBinRemAssign(/*const*/ CompoundAssignOperator /*P*/ E) {
    return EmitCompoundAssign(E, /*AddrOf*//*FPtr*/ScalarExprEmitter::EmitRem);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::VisitBinAdd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 516,
   FQN="(anonymous namespace)::ScalarExprEmitter::VisitBinAdd", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter11VisitBinAddEPKN5clang14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter11VisitBinAddEPKN5clang14BinaryOperatorE")
  //</editor-fold>
  public Value /*P*/ VisitBinAdd(/*const*/ BinaryOperator /*P*/ E) {
    return EmitAdd(EmitBinOps(E));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::VisitBinAddAssign">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 516,
   FQN="(anonymous namespace)::ScalarExprEmitter::VisitBinAddAssign", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter17VisitBinAddAssignEPKN5clang22CompoundAssignOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter17VisitBinAddAssignEPKN5clang22CompoundAssignOperatorE")
  //</editor-fold>
  public Value /*P*/ VisitBinAddAssign(/*const*/ CompoundAssignOperator /*P*/ E) {
    return EmitCompoundAssign(E, /*AddrOf*//*FPtr*/ScalarExprEmitter::EmitAdd);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::VisitBinSub">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 517,
   FQN="(anonymous namespace)::ScalarExprEmitter::VisitBinSub", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter11VisitBinSubEPKN5clang14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter11VisitBinSubEPKN5clang14BinaryOperatorE")
  //</editor-fold>
  public Value /*P*/ VisitBinSub(/*const*/ BinaryOperator /*P*/ E) {
    return EmitSub(EmitBinOps(E));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::VisitBinSubAssign">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 517,
   FQN="(anonymous namespace)::ScalarExprEmitter::VisitBinSubAssign", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter17VisitBinSubAssignEPKN5clang22CompoundAssignOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter17VisitBinSubAssignEPKN5clang22CompoundAssignOperatorE")
  //</editor-fold>
  public Value /*P*/ VisitBinSubAssign(/*const*/ CompoundAssignOperator /*P*/ E) {
    return EmitCompoundAssign(E, /*AddrOf*//*FPtr*/ScalarExprEmitter::EmitSub);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::VisitBinShl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 518,
   FQN="(anonymous namespace)::ScalarExprEmitter::VisitBinShl", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter11VisitBinShlEPKN5clang14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter11VisitBinShlEPKN5clang14BinaryOperatorE")
  //</editor-fold>
  public Value /*P*/ VisitBinShl(/*const*/ BinaryOperator /*P*/ E) {
    return EmitShl(EmitBinOps(E));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::VisitBinShlAssign">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 518,
   FQN="(anonymous namespace)::ScalarExprEmitter::VisitBinShlAssign", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter17VisitBinShlAssignEPKN5clang22CompoundAssignOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter17VisitBinShlAssignEPKN5clang22CompoundAssignOperatorE")
  //</editor-fold>
  public Value /*P*/ VisitBinShlAssign(/*const*/ CompoundAssignOperator /*P*/ E) {
    return EmitCompoundAssign(E, /*AddrOf*//*FPtr*/ScalarExprEmitter::EmitShl);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::VisitBinShr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 519,
   FQN="(anonymous namespace)::ScalarExprEmitter::VisitBinShr", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter11VisitBinShrEPKN5clang14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter11VisitBinShrEPKN5clang14BinaryOperatorE")
  //</editor-fold>
  public Value /*P*/ VisitBinShr(/*const*/ BinaryOperator /*P*/ E) {
    return EmitShr(EmitBinOps(E));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::VisitBinShrAssign">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 519,
   FQN="(anonymous namespace)::ScalarExprEmitter::VisitBinShrAssign", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter17VisitBinShrAssignEPKN5clang22CompoundAssignOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter17VisitBinShrAssignEPKN5clang22CompoundAssignOperatorE")
  //</editor-fold>
  public Value /*P*/ VisitBinShrAssign(/*const*/ CompoundAssignOperator /*P*/ E) {
    return EmitCompoundAssign(E, /*AddrOf*//*FPtr*/ScalarExprEmitter::EmitShr);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::VisitBinAnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 520,
   FQN="(anonymous namespace)::ScalarExprEmitter::VisitBinAnd", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter11VisitBinAndEPKN5clang14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter11VisitBinAndEPKN5clang14BinaryOperatorE")
  //</editor-fold>
  public Value /*P*/ VisitBinAnd(/*const*/ BinaryOperator /*P*/ E) {
    return EmitAnd(EmitBinOps(E));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::VisitBinAndAssign">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 520,
   FQN="(anonymous namespace)::ScalarExprEmitter::VisitBinAndAssign", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter17VisitBinAndAssignEPKN5clang22CompoundAssignOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter17VisitBinAndAssignEPKN5clang22CompoundAssignOperatorE")
  //</editor-fold>
  public Value /*P*/ VisitBinAndAssign(/*const*/ CompoundAssignOperator /*P*/ E) {
    return EmitCompoundAssign(E, /*AddrOf*//*FPtr*/ScalarExprEmitter::EmitAnd);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::VisitBinXor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 521,
   FQN="(anonymous namespace)::ScalarExprEmitter::VisitBinXor", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter11VisitBinXorEPKN5clang14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter11VisitBinXorEPKN5clang14BinaryOperatorE")
  //</editor-fold>
  public Value /*P*/ VisitBinXor(/*const*/ BinaryOperator /*P*/ E) {
    return EmitXor(EmitBinOps(E));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::VisitBinXorAssign">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 521,
   FQN="(anonymous namespace)::ScalarExprEmitter::VisitBinXorAssign", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter17VisitBinXorAssignEPKN5clang22CompoundAssignOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter17VisitBinXorAssignEPKN5clang22CompoundAssignOperatorE")
  //</editor-fold>
  public Value /*P*/ VisitBinXorAssign(/*const*/ CompoundAssignOperator /*P*/ E) {
    return EmitCompoundAssign(E, /*AddrOf*//*FPtr*/ScalarExprEmitter::EmitXor);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::VisitBinOr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 522,
   FQN="(anonymous namespace)::ScalarExprEmitter::VisitBinOr", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter10VisitBinOrEPKN5clang14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter10VisitBinOrEPKN5clang14BinaryOperatorE")
  //</editor-fold>
  public Value /*P*/ VisitBinOr(/*const*/ BinaryOperator /*P*/ E) {
    return EmitOr(EmitBinOps(E));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::VisitBinOrAssign">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 522,
   FQN="(anonymous namespace)::ScalarExprEmitter::VisitBinOrAssign", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter16VisitBinOrAssignEPKN5clang22CompoundAssignOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter16VisitBinOrAssignEPKN5clang22CompoundAssignOperatorE")
  //</editor-fold>
  public Value /*P*/ VisitBinOrAssign(/*const*/ CompoundAssignOperator /*P*/ E) {
    return EmitCompoundAssign(E, /*AddrOf*//*FPtr*/ScalarExprEmitter::EmitOr);
  }

  
  // Comparisons.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::EmitCompare">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 2824,
   FQN="(anonymous namespace)::ScalarExprEmitter::EmitCompare", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter11EmitCompareEPKN5clang14BinaryOperatorEN4llvm7CmpInst9PredicateES7_S7_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter11EmitCompareEPKN5clang14BinaryOperatorEN4llvm7CmpInst9PredicateES7_S7_")
  //</editor-fold>
  public Value /*P*/ EmitCompare(/*const*/ BinaryOperator /*P*/ E, 
             CmpInst.Predicate UICmpOpc, 
             CmpInst.Predicate SICmpOpc, 
             CmpInst.Predicate FCmpOpc) {
    TestAndClearIgnoreResultAssign();
    Value /*P*/ Result;
    QualType LHSTy = E.getLHS().getType();
    QualType RHSTy = E.getRHS().getType();
    {
      /*const*/ MemberPointerType /*P*/ MPT = LHSTy.$arrow().getAs(MemberPointerType.class);
      if ((MPT != null)) {
        assert (E.getOpcode() == BinaryOperatorKind.BO_EQ || E.getOpcode() == BinaryOperatorKind.BO_NE);
        Value /*P*/ LHS = CGF.EmitScalarExpr(E.getLHS());
        Value /*P*/ RHS = CGF.EmitScalarExpr(E.getRHS());
        Result = CGF.CGM.getCXXABI().EmitMemberPointerComparison(CGF, LHS, RHS, MPT, E.getOpcode() == BinaryOperatorKind.BO_NE);
      } else if (!LHSTy.$arrow().isAnyComplexType() && !RHSTy.$arrow().isAnyComplexType()) {
        Value /*P*/ LHS = Visit(E.getLHS());
        Value /*P*/ RHS = Visit(E.getRHS());
        
        // If AltiVec, the comparison results in a numeric type, so we use
        // intrinsics comparing vectors and giving 0 or 1 as a result
        if (LHSTy.$arrow().isVectorType() && !E.getType().$arrow().isVectorType()) {
          // constants for mapping CR6 register bits to predicate result
          /*enum ANONYMOUS_INT_CONSTANTS {*/
            final /*uint*/int CR6_EQ = 0;
            final /*uint*/int CR6_EQ_REV = CR6_EQ + 1;
            final /*uint*/int CR6_LT = CR6_EQ_REV + 1;
            final /*uint*/int CR6_LT_REV = CR6_LT + 1;
          /*}*//*Unnamed enum*//*uint*/int CR6;
          
          /*ID*/int _ID = org.llvm.ir.intrinsic.ID.not_intrinsic;
          
          // in several cases vector arguments order will be reversed
          type$ref<Value /*P*/ > FirstVecArg = create_type$ref(LHS);
          type$ref<Value /*P*/ > SecondVecArg = create_type$ref(RHS);
          
          QualType ElTy = LHSTy.$arrow().getAs(org.clang.ast.VectorType.class).getElementType();
          /*const*/ BuiltinType /*P*/ BTy = ElTy.$arrow().getAs$BuiltinType();
          BuiltinType.Kind ElementKind = BTy.getKind();
          switch (E.getOpcode()) {
           default:
            throw new llvm_unreachable("is not a comparison operation");
           case BO_EQ:
            CR6 = CR6_LT;
            _ID = GetIntrinsic(IntrinsicType.VCMPEQ, ElementKind);
            break;
           case BO_NE:
            CR6 = CR6_EQ;
            _ID = GetIntrinsic(IntrinsicType.VCMPEQ, ElementKind);
            break;
           case BO_LT:
            CR6 = CR6_LT;
            _ID = GetIntrinsic(IntrinsicType.VCMPGT, ElementKind);
            std.swap(FirstVecArg, SecondVecArg);
            break;
           case BO_GT:
            CR6 = CR6_LT;
            _ID = GetIntrinsic(IntrinsicType.VCMPGT, ElementKind);
            break;
           case BO_LE:
            if (ElementKind == BuiltinType.Kind.Float) {
              CR6 = CR6_LT;
              _ID = ID.ppc_altivec_vcmpgefp_p;
              std.swap(FirstVecArg, SecondVecArg);
            } else {
              CR6 = CR6_EQ;
              _ID = GetIntrinsic(IntrinsicType.VCMPGT, ElementKind);
            }
            break;
           case BO_GE:
            if (ElementKind == BuiltinType.Kind.Float) {
              CR6 = CR6_LT;
              _ID = ID.ppc_altivec_vcmpgefp_p;
            } else {
              CR6 = CR6_EQ;
              _ID = GetIntrinsic(IntrinsicType.VCMPGT, ElementKind);
              std.swap(FirstVecArg, SecondVecArg);
            }
            break;
          }
          
          Value /*P*/ CR6Param = Builder.getInt32(CR6);
          Function /*P*/ F = CGF.CGM.getIntrinsic(_ID);
          Result = Builder.CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P(F, /*{ */new ArrayRef<Value /*P*/ >(new Value /*P*/ /*const*/ [/*3*/] {CR6Param, FirstVecArg.$deref(), SecondVecArg.$deref()}, true)/* }*/);
          return EmitScalarConversion(Result, CGF.getContext().BoolTy.$QualType(), E.getType(), 
              E.getExprLoc());
        }
        if (LHS.getType().isFPOrFPVectorTy()) {
          Result = Builder.CreateFCmp(FCmpOpc, LHS, RHS, new Twine(/*KEEP_STR*/"cmp"));
        } else if (LHSTy.$arrow().hasSignedIntegerRepresentation()) {
          Result = Builder.CreateICmp(SICmpOpc, LHS, RHS, new Twine(/*KEEP_STR*/"cmp"));
        } else {
          // Unsigned integers and pointers.
          Result = Builder.CreateICmp(UICmpOpc, LHS, RHS, new Twine(/*KEEP_STR*/"cmp"));
        }
        
        // If this is a vector comparison, sign extend the result to the appropriate
        // vector integer type and return it (don't convert to bool).
        if (LHSTy.$arrow().isVectorType()) {
          return Builder.CreateSExt(Result, ConvertType(E.getType()), new Twine(/*KEEP_STR*/"sext"));
        }
      } else {
        // Complex Comparison: can only be an equality comparison.
        std.pair<Value /*P*/ , Value /*P*/ > LHS/*J*/= new std.pairPtrPtr<Value /*P*/ , Value /*P*/ >();
        std.pair<Value /*P*/ , Value /*P*/ > RHS/*J*/= new std.pairPtrPtr<Value /*P*/ , Value /*P*/ >();
        QualType CETy/*J*/= new QualType();
        {
          /*const*/ ComplexType /*P*/ CTy = LHSTy.$arrow().getAs(ComplexType.class);
          if ((CTy != null)) {
            LHS.$assignMove(CGF.EmitComplexExpr(E.getLHS()));
            CETy.$assignMove(CTy.getElementType());
          } else {
            LHS.first = Visit(E.getLHS());
            LHS.second = Constant.getNullValue(LHS.first.getType());
            CETy.$assign(LHSTy);
          }
        }
        {
          /*const*/ ComplexType /*P*/ CTy = RHSTy.$arrow().getAs(ComplexType.class);
          if ((CTy != null)) {
            RHS.$assignMove(CGF.EmitComplexExpr(E.getRHS()));
            assert (CGF.getContext().hasSameUnqualifiedType(new QualType(CETy), CTy.getElementType())) : "The element types must always match.";
            ///*J:(void)*/CTy;
          } else {
            RHS.first = Visit(E.getRHS());
            RHS.second = Constant.getNullValue(RHS.first.getType());
            assert (CGF.getContext().hasSameUnqualifiedType(new QualType(CETy), new QualType(RHSTy))) : "The element types must always match.";
          }
        }
        
        Value /*P*/ ResultR;
        Value /*P*/ ResultI;
        if (CETy.$arrow().isRealFloatingType()) {
          ResultR = Builder.CreateFCmp(FCmpOpc, LHS.first, RHS.first, new Twine(/*KEEP_STR*/"cmp.r"));
          ResultI = Builder.CreateFCmp(FCmpOpc, LHS.second, RHS.second, new Twine(/*KEEP_STR*/"cmp.i"));
        } else {
          // Complex comparisons can only be equality comparisons.  As such, signed
          // and unsigned opcodes are the same.
          ResultR = Builder.CreateICmp(UICmpOpc, LHS.first, RHS.first, new Twine(/*KEEP_STR*/"cmp.r"));
          ResultI = Builder.CreateICmp(UICmpOpc, LHS.second, RHS.second, new Twine(/*KEEP_STR*/"cmp.i"));
        }
        if (E.getOpcode() == BinaryOperatorKind.BO_EQ) {
          Result = Builder.CreateAnd(ResultR, ResultI, new Twine(/*KEEP_STR*/"and.ri"));
        } else {
          assert (E.getOpcode() == BinaryOperatorKind.BO_NE) : "Complex comparison other than == or != ?";
          Result = Builder.CreateOr(ResultR, ResultI, new Twine(/*KEEP_STR*/"or.ri"));
        }
      }
    }
    
    return EmitScalarConversion(Result, CGF.getContext().BoolTy.$QualType(), E.getType(), 
        E.getExprLoc());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::VisitBinLT">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 533,
   FQN="(anonymous namespace)::ScalarExprEmitter::VisitBinLT", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter10VisitBinLTEPKN5clang14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter10VisitBinLTEPKN5clang14BinaryOperatorE")
  //</editor-fold>
  public Value /*P*/ VisitBinLT(/*const*/ BinaryOperator /*P*/ E) {
    return EmitCompare(E, ICmpInst.Predicate.ICMP_ULT, ICmpInst.Predicate.ICMP_SLT, FCmpInst.Predicate.FCMP_OLT);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::VisitBinGT">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 534,
   FQN="(anonymous namespace)::ScalarExprEmitter::VisitBinGT", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter10VisitBinGTEPKN5clang14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter10VisitBinGTEPKN5clang14BinaryOperatorE")
  //</editor-fold>
  public Value /*P*/ VisitBinGT(/*const*/ BinaryOperator /*P*/ E) {
    return EmitCompare(E, ICmpInst.Predicate.ICMP_UGT, ICmpInst.Predicate.ICMP_SGT, FCmpInst.Predicate.FCMP_OGT);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::VisitBinLE">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 535,
   FQN="(anonymous namespace)::ScalarExprEmitter::VisitBinLE", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter10VisitBinLEEPKN5clang14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter10VisitBinLEEPKN5clang14BinaryOperatorE")
  //</editor-fold>
  public Value /*P*/ VisitBinLE(/*const*/ BinaryOperator /*P*/ E) {
    return EmitCompare(E, ICmpInst.Predicate.ICMP_ULE, ICmpInst.Predicate.ICMP_SLE, FCmpInst.Predicate.FCMP_OLE);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::VisitBinGE">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 536,
   FQN="(anonymous namespace)::ScalarExprEmitter::VisitBinGE", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter10VisitBinGEEPKN5clang14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter10VisitBinGEEPKN5clang14BinaryOperatorE")
  //</editor-fold>
  public Value /*P*/ VisitBinGE(/*const*/ BinaryOperator /*P*/ E) {
    return EmitCompare(E, ICmpInst.Predicate.ICMP_UGE, ICmpInst.Predicate.ICMP_SGE, FCmpInst.Predicate.FCMP_OGE);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::VisitBinEQ">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 537,
   FQN="(anonymous namespace)::ScalarExprEmitter::VisitBinEQ", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter10VisitBinEQEPKN5clang14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter10VisitBinEQEPKN5clang14BinaryOperatorE")
  //</editor-fold>
  public Value /*P*/ VisitBinEQ(/*const*/ BinaryOperator /*P*/ E) {
    return EmitCompare(E, ICmpInst.Predicate.ICMP_EQ, ICmpInst.Predicate.ICMP_EQ, FCmpInst.Predicate.FCMP_OEQ);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::VisitBinNE">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 538,
   FQN="(anonymous namespace)::ScalarExprEmitter::VisitBinNE", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter10VisitBinNEEPKN5clang14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter10VisitBinNEEPKN5clang14BinaryOperatorE")
  //</editor-fold>
  public Value /*P*/ VisitBinNE(/*const*/ BinaryOperator /*P*/ E) {
    return EmitCompare(E, ICmpInst.Predicate.ICMP_NE, ICmpInst.Predicate.ICMP_NE, FCmpInst.Predicate.FCMP_UNE);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::VisitBinAssign">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 2972,
   FQN="(anonymous namespace)::ScalarExprEmitter::VisitBinAssign", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter14VisitBinAssignEPKN5clang14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter14VisitBinAssignEPKN5clang14BinaryOperatorE")
  //</editor-fold>
  public Value /*P*/ VisitBinAssign(/*const*/ BinaryOperator /*P*/ E) {
    boolean Ignore = TestAndClearIgnoreResultAssign();
    
    type$ptr<Value /*P*/ > RHS = create_type$null$ptr();
    LValue LHS/*J*/= new LValue();
    switch (E.getLHS().getType().getObjCLifetime()) {
     case OCL_Strong:
      pair<LValue, Value> t1 = CGF.EmitARCStoreStrong(E, Ignore);
      LHS = t1.first;
      RHS.$set(t1.second);
      break;
     case OCL_Autoreleasing:
      pair<LValue, Value> t2 = CGF.EmitARCStoreAutoreleasing(E);
      LHS = t2.first;
      RHS.$set(t2.second);
      break;
     case OCL_ExplicitNone:      
      pair<LValue, Value> t3 = CGF.EmitARCStoreUnsafeUnretained(E, Ignore);
      LHS = t3.first;
      RHS.$set(t3.second);
      break;
     case OCL_Weak:
      RHS.$set(Visit(E.getRHS()));
      LHS.$assignMove(EmitCheckedLValue(E.getLHS(), CodeGenFunction.TypeCheckKind.TCK_Store));
      RHS.$set(CGF.EmitARCStoreWeak(LHS.getAddress(), RHS.$star(), Ignore));
      break;
     case OCL_None:
      // __block variables need to have the rhs evaluated first, plus
      // this should improve codegen just a little.
      RHS.$set(Visit(E.getRHS()));
      LHS.$assignMove(EmitCheckedLValue(E.getLHS(), CodeGenFunction.TypeCheckKind.TCK_Store));
      
      // Store the value into the LHS.  Bit-fields are handled specially
      // because the result is altered by the store, i.e., [C99 6.5.16p1]
      // 'An assignment expression has the value of the left operand after
      // the assignment...'.
      if (LHS.isBitField()) {
        CGF.EmitStoreThroughBitfieldLValue(RValue.get(RHS.$star()), new LValue(LHS), /*AddrOf*/RHS);
      } else {
        CGF.EmitStoreThroughLValue(RValue.get(RHS.$star()), new LValue(LHS));
      }
    }
    
    // If the result is clearly ignored, return now.
    if (Ignore) {
      return null;
    }
    
    // The result of an assignment in C is the assigned r-value.
    if (!CGF.getLangOpts().CPlusPlus) {
      return RHS.$star();
    }
    
    // If the lvalue is non-volatile, return the computed value of the assignment.
    if (!LHS.isVolatileQualified()) {
      return RHS.$star();
    }
    
    // Otherwise, reload the value.
    return EmitLoadOfLValue(new LValue(LHS), E.getExprLoc());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::VisitBinLAnd">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 3029,
   FQN="(anonymous namespace)::ScalarExprEmitter::VisitBinLAnd", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter12VisitBinLAndEPKN5clang14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter12VisitBinLAndEPKN5clang14BinaryOperatorE")
  //</editor-fold>
  public Value /*P*/ VisitBinLAnd(/*const*/ BinaryOperator /*P*/ E) {
    // Perform vector logical and on comparisons with zero vectors.
    if (E.getType().$arrow().isVectorType()) {
      CGF.incrementProfileCounter(E);
      
      Value /*P*/ LHS = Visit(E.getLHS());
      Value /*P*/ RHS = Visit(E.getRHS());
      Value /*P*/ Zero = ConstantAggregateZero.get(LHS.getType());
      if (LHS.getType().isFPOrFPVectorTy()) {
        LHS = Builder.CreateFCmp(CmpInst.Predicate.FCMP_UNE, LHS, Zero, new Twine(/*KEEP_STR*/"cmp"));
        RHS = Builder.CreateFCmp(CmpInst.Predicate.FCMP_UNE, RHS, Zero, new Twine(/*KEEP_STR*/"cmp"));
      } else {
        LHS = Builder.CreateICmp(CmpInst.Predicate.ICMP_NE, LHS, Zero, new Twine(/*KEEP_STR*/"cmp"));
        RHS = Builder.CreateICmp(CmpInst.Predicate.ICMP_NE, RHS, Zero, new Twine(/*KEEP_STR*/"cmp"));
      }
      Value /*P*/ And = Builder.CreateAnd(LHS, RHS);
      return Builder.CreateSExt(And, ConvertType(E.getType()), new Twine(/*KEEP_STR*/"sext"));
    }
    
    Type /*P*/ ResTy = ConvertType(E.getType());
    
    // If we have 0 && RHS, see if we can elide RHS, if so, just return 0.
    // If we have 1 && X, just emit X without inserting the control flow.
    bool$ref LHSCondVal = create_bool$ref();
    if (CGF.ConstantFoldsToSimpleInteger(E.getLHS(), LHSCondVal)) {
      if (LHSCondVal.$deref()) { // If we have 1 && X, just emit X.
        CGF.incrementProfileCounter(E);
        
        Value /*P*/ RHSCond = CGF.EvaluateExprAsBool(E.getRHS());
        // ZExt result to int or bool.
        return Builder.CreateZExtOrBitCast(RHSCond, ResTy, new Twine(/*KEEP_STR*/"land.ext"));
      }
      
      // 0 && RHS: If it is safe, just elide the RHS, and return 0/false.
      if (!CGF.ContainsLabel(E.getRHS())) {
        return Constant.getNullValue(ResTy);
      }
    }
    
    BasicBlock /*P*/ ContBlock = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"land.end"));
    BasicBlock /*P*/ RHSBlock = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"land.rhs"));
    
    CodeGenFunction.ConditionalEvaluation eval/*J*/= new CodeGenFunction.ConditionalEvaluation(CGF);
    
    // Branch on the LHS first.  If it is false, go to the failure (cont) block.
    CGF.EmitBranchOnBoolExpr(E.getLHS(), RHSBlock, ContBlock, 
        CGF.getProfileCount(E.getRHS()));
    
    // Any edges into the ContBlock are now from an (indeterminate number of)
    // edges from this first condition.  All of these values will be false.  Start
    // setting up the PHI node in the Cont Block for this.
    PHINode /*P*/ PN = PHINode.Create(Type.getInt1Ty(VMContext), 2, 
        new Twine(/*KEEP_STR*/$EMPTY), ContBlock);
    for (PredIterator<BasicBlock, Value.user_iterator_impl<User> > PI = pred_begin_BasicBlock$P(ContBlock), PE = pred_end_BasicBlock$P(ContBlock);
         PI.$noteq(PE); PI.$preInc())  {
      PN.addIncoming(ConstantInt.getFalse(VMContext), PI.$star());
    }
    
    eval.begin(CGF);
    CGF.EmitBlock(RHSBlock);
    CGF.incrementProfileCounter(E);
    Value /*P*/ RHSCond = CGF.EvaluateExprAsBool(E.getRHS());
    eval.end(CGF);
    
    // Reaquire the RHS block, as there may be subblocks inserted.
    RHSBlock = Builder.GetInsertBlock();
    {
      ApplyDebugLocation NL = null;
      try {
        // There is no need to emit line number for unconditional branch.
        NL = ApplyDebugLocation.CreateEmpty(CGF);
        CGF.EmitBlock(ContBlock);
      } finally {
        if (NL != null) { NL.$destroy(); }
      }
    }
    // Insert an entry into the phi node for the edge with the value of RHSCond.
    PN.addIncoming(RHSCond, RHSBlock);
    
    // ZExt result to int.
    return Builder.CreateZExtOrBitCast(PN, ResTy, new Twine(/*KEEP_STR*/"land.ext"));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::VisitBinLOr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 3107,
   FQN="(anonymous namespace)::ScalarExprEmitter::VisitBinLOr", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter11VisitBinLOrEPKN5clang14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter11VisitBinLOrEPKN5clang14BinaryOperatorE")
  //</editor-fold>
  public Value /*P*/ VisitBinLOr(/*const*/ BinaryOperator /*P*/ E) {
    // Perform vector logical or on comparisons with zero vectors.
    if (E.getType().$arrow().isVectorType()) {
      CGF.incrementProfileCounter(E);
      
      Value /*P*/ LHS = Visit(E.getLHS());
      Value /*P*/ RHS = Visit(E.getRHS());
      Value /*P*/ Zero = ConstantAggregateZero.get(LHS.getType());
      if (LHS.getType().isFPOrFPVectorTy()) {
        LHS = Builder.CreateFCmp(CmpInst.Predicate.FCMP_UNE, LHS, Zero, new Twine(/*KEEP_STR*/"cmp"));
        RHS = Builder.CreateFCmp(CmpInst.Predicate.FCMP_UNE, RHS, Zero, new Twine(/*KEEP_STR*/"cmp"));
      } else {
        LHS = Builder.CreateICmp(CmpInst.Predicate.ICMP_NE, LHS, Zero, new Twine(/*KEEP_STR*/"cmp"));
        RHS = Builder.CreateICmp(CmpInst.Predicate.ICMP_NE, RHS, Zero, new Twine(/*KEEP_STR*/"cmp"));
      }
      Value /*P*/ Or = Builder.CreateOr(LHS, RHS);
      return Builder.CreateSExt(Or, ConvertType(E.getType()), new Twine(/*KEEP_STR*/"sext"));
    }
    
    Type /*P*/ ResTy = ConvertType(E.getType());
    
    // If we have 1 || RHS, see if we can elide RHS, if so, just return 1.
    // If we have 0 || X, just emit X without inserting the control flow.
    bool$ref LHSCondVal = create_bool$ref();
    if (CGF.ConstantFoldsToSimpleInteger(E.getLHS(), LHSCondVal)) {
      if (!LHSCondVal.$deref()) { // If we have 0 || X, just emit X.
        CGF.incrementProfileCounter(E);
        
        Value /*P*/ RHSCond = CGF.EvaluateExprAsBool(E.getRHS());
        // ZExt result to int or bool.
        return Builder.CreateZExtOrBitCast(RHSCond, ResTy, new Twine(/*KEEP_STR*/"lor.ext"));
      }
      
      // 1 || RHS: If it is safe, just elide the RHS, and return 1/true.
      if (!CGF.ContainsLabel(E.getRHS())) {
        return ConstantInt.get(ResTy, $int2ulong(1));
      }
    }
    
    BasicBlock /*P*/ ContBlock = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"lor.end"));
    BasicBlock /*P*/ RHSBlock = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"lor.rhs"));
    
    CodeGenFunction.ConditionalEvaluation eval/*J*/= new CodeGenFunction.ConditionalEvaluation(CGF);
    
    // Branch on the LHS first.  If it is true, go to the success (cont) block.
    CGF.EmitBranchOnBoolExpr(E.getLHS(), ContBlock, RHSBlock, 
        CGF.getCurrentProfileCount()
           - CGF.getProfileCount(E.getRHS()));
    
    // Any edges into the ContBlock are now from an (indeterminate number of)
    // edges from this first condition.  All of these values will be true.  Start
    // setting up the PHI node in the Cont Block for this.
    PHINode /*P*/ PN = PHINode.Create(Type.getInt1Ty(VMContext), 2, 
        new Twine(/*KEEP_STR*/$EMPTY), ContBlock);
    for (PredIterator<BasicBlock, Value.user_iterator_impl<User> > PI = pred_begin_BasicBlock$P(ContBlock), PE = pred_end_BasicBlock$P(ContBlock);
         PI.$noteq(PE); PI.$preInc())  {
      PN.addIncoming(ConstantInt.getTrue(VMContext), PI.$star());
    }
    
    eval.begin(CGF);
    
    // Emit the RHS condition as a bool value.
    CGF.EmitBlock(RHSBlock);
    CGF.incrementProfileCounter(E);
    Value /*P*/ RHSCond = CGF.EvaluateExprAsBool(E.getRHS());
    
    eval.end(CGF);
    
    // Reaquire the RHS block, as there may be subblocks inserted.
    RHSBlock = Builder.GetInsertBlock();
    
    // Emit an unconditional branch from this block to ContBlock.  Insert an entry
    // into the phi node for the edge with the value of RHSCond.
    CGF.EmitBlock(ContBlock);
    PN.addIncoming(RHSCond, RHSBlock);
    
    // ZExt result to int.
    return Builder.CreateZExtOrBitCast(PN, ResTy, new Twine(/*KEEP_STR*/"lor.ext"));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::VisitBinComma">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 3185,
   FQN="(anonymous namespace)::ScalarExprEmitter::VisitBinComma", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter13VisitBinCommaEPKN5clang14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter13VisitBinCommaEPKN5clang14BinaryOperatorE")
  //</editor-fold>
  public Value /*P*/ VisitBinComma(/*const*/ BinaryOperator /*P*/ E) {
    CGF.EmitIgnoredExpr(E.getLHS());
    CGF.EnsureInsertPoint();
    return Visit(E.getRHS());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::VisitBinPtrMemD">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 547,
   FQN="(anonymous namespace)::ScalarExprEmitter::VisitBinPtrMemD", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter15VisitBinPtrMemDEPKN5clang4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter15VisitBinPtrMemDEPKN5clang4ExprE")
  //</editor-fold>
  public Value /*P*/ VisitBinPtrMemD(/*const*/ Expr /*P*/ E) {
    return EmitLoadOfLValue(E);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::VisitBinPtrMemI">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 548,
   FQN="(anonymous namespace)::ScalarExprEmitter::VisitBinPtrMemI", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter15VisitBinPtrMemIEPKN5clang4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter15VisitBinPtrMemIEPKN5clang4ExprE")
  //</editor-fold>
  public Value /*P*/ VisitBinPtrMemI(/*const*/ Expr /*P*/ E) {
    return EmitLoadOfLValue(E);
  }

  
  // Other Operators.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::VisitBlockExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 3382,
   FQN="(anonymous namespace)::ScalarExprEmitter::VisitBlockExpr", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter14VisitBlockExprEPKN5clang9BlockExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter14VisitBlockExprEPKN5clang9BlockExprE")
  //</editor-fold>
  public Value /*P*/ VisitBlockExpr(/*const*/ BlockExpr /*P*/ block) {
    return CGF.EmitBlockLiteral(block);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::VisitAbstractConditionalOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 3213,
   FQN="(anonymous namespace)::ScalarExprEmitter::VisitAbstractConditionalOperator", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter32VisitAbstractConditionalOperatorEPKN5clang27AbstractConditionalOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter32VisitAbstractConditionalOperatorEPKN5clang27AbstractConditionalOperatorE")
  //</editor-fold>
  public Value /*P*/ VisitAbstractConditionalOperator(/*const*/ AbstractConditionalOperator /*P*/ E) {
    CodeGenFunction.OpaqueValueMapping binding = null;
    try {
      TestAndClearIgnoreResultAssign();
      
      // Bind the common expression if necessary.
      binding/*J*/= new CodeGenFunction.OpaqueValueMapping(CGF, E);
      
      Expr /*P*/ condExpr = E.getCond();
      Expr /*P*/ lhsExpr = E.getTrueExpr();
      Expr /*P*/ rhsExpr = E.getFalseExpr();
      
      // If the condition constant folds and can be elided, try to avoid emitting
      // the condition and the dead arm.
      bool$ref CondExprBool = create_bool$ref();
      if (CGF.ConstantFoldsToSimpleInteger(condExpr, CondExprBool)) {
        type$ref<Expr /*P*/ > live = create_type$ref(lhsExpr);
        type$ref<Expr /*P*/ > dead = create_type$ref(rhsExpr);
        if (!CondExprBool.$deref()) {
          std.swap(live, dead);
        }
        
        // If the dead side doesn't have labels we need, just emit the Live part.
        if (!CGF.ContainsLabel(dead.$deref())) {
          if (CondExprBool.$deref()) {
            CGF.incrementProfileCounter(E);
          }
          Value /*P*/ Result = Visit(live.$deref());
          
          // If the live part is a throw expression, it acts like it has a void
          // type, so evaluating it returns a null Value*.  However, a conditional
          // with non-void type must return a non-null Value*.
          if (!(Result != null) && !E.getType().$arrow().isVoidType()) {
            Result = UndefValue.get(CGF.ConvertType(E.getType()));
          }
          
          return Result;
        }
      }
      
      // OpenCL: If the condition is a vector, we can treat this condition like
      // the select function.
      if (CGF.getLangOpts().OpenCL
         && condExpr.getType().$arrow().isVectorType()) {
        CGF.incrementProfileCounter(E);
        
        Value /*P*/ CondV = CGF.EmitScalarExpr(condExpr);
        Value /*P*/ LHS = Visit(lhsExpr);
        Value /*P*/ RHS = Visit(rhsExpr);
        
        Type /*P*/ condType = ConvertType(condExpr.getType());
        VectorType /*P*/ vecTy = cast_VectorType(condType);
        
        /*uint*/int numElem = vecTy.getNumElements();
        Type /*P*/ elemType = vecTy.getElementType();
        
        Value /*P*/ zeroVec = Constant.getNullValue(vecTy);
        Value /*P*/ TestMSB = Builder.CreateICmpSLT(CondV, zeroVec);
        Value /*P*/ tmp = Builder.CreateSExt(TestMSB, 
            VectorType.get(elemType, 
                numElem), 
            new Twine(/*KEEP_STR*/"sext"));
        Value /*P*/ tmp2 = Builder.CreateNot(tmp);
        
        // Cast float to int to perform ANDs if necessary.
        Value /*P*/ RHSTmp = RHS;
        Value /*P*/ LHSTmp = LHS;
        boolean wasCast = false;
        VectorType /*P*/ rhsVTy = cast_VectorType(RHS.getType());
        if (rhsVTy.getElementType().isFloatingPointTy()) {
          RHSTmp = Builder.CreateBitCast(RHS, tmp2.getType());
          LHSTmp = Builder.CreateBitCast(LHS, tmp.getType());
          wasCast = true;
        }
        
        Value /*P*/ tmp3 = Builder.CreateAnd(RHSTmp, tmp2);
        Value /*P*/ tmp4 = Builder.CreateAnd(LHSTmp, tmp);
        Value /*P*/ tmp5 = Builder.CreateOr(tmp3, tmp4, new Twine(/*KEEP_STR*/"cond"));
        if (wasCast) {
          tmp5 = Builder.CreateBitCast(tmp5, RHS.getType());
        }
        
        return tmp5;
      }
      
      // If this is a really simple expression (like x ? 4 : 5), emit this as a
      // select instead of as control flow.  We can only do this if it is cheap and
      // safe to evaluate the LHS and RHS unconditionally.
      if (isCheapEnoughToEvaluateUnconditionally(lhsExpr, CGF)
         && isCheapEnoughToEvaluateUnconditionally(rhsExpr, CGF)) {
        CGF.incrementProfileCounter(E);
        
        Value /*P*/ CondV = CGF.EvaluateExprAsBool(condExpr);
        Value /*P*/ LHS = Visit(lhsExpr);
        Value /*P*/ RHS = Visit(rhsExpr);
        if (!(LHS != null)) {
          // If the conditional has void type, make sure we return a null Value*.
          assert (!(RHS != null)) : "LHS and RHS types must match";
          return null;
        }
        return Builder.CreateSelect(CondV, LHS, RHS, new Twine(/*KEEP_STR*/"cond"));
      }
      
      BasicBlock /*P*/ LHSBlock = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"cond.true"));
      BasicBlock /*P*/ RHSBlock = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"cond.false"));
      BasicBlock /*P*/ ContBlock = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"cond.end"));
      
      CodeGenFunction.ConditionalEvaluation eval/*J*/= new CodeGenFunction.ConditionalEvaluation(CGF);
      CGF.EmitBranchOnBoolExpr(condExpr, LHSBlock, RHSBlock, 
          CGF.getProfileCount(lhsExpr));
      
      CGF.EmitBlock(LHSBlock);
      CGF.incrementProfileCounter(E);
      eval.begin(CGF);
      Value /*P*/ LHS = Visit(lhsExpr);
      eval.end(CGF);
      
      LHSBlock = Builder.GetInsertBlock();
      Builder.CreateBr(ContBlock);
      
      CGF.EmitBlock(RHSBlock);
      eval.begin(CGF);
      Value /*P*/ RHS = Visit(rhsExpr);
      eval.end(CGF);
      
      RHSBlock = Builder.GetInsertBlock();
      CGF.EmitBlock(ContBlock);
      
      // If the LHS or RHS is a throw expression, it will be legitimately null.
      if (!(LHS != null)) {
        return RHS;
      }
      if (!(RHS != null)) {
        return LHS;
      }
      
      // Create a PHI node for the real part.
      PHINode /*P*/ PN = Builder.CreatePHI(LHS.getType(), 2, new Twine(/*KEEP_STR*/"cond"));
      PN.addIncoming(LHS, LHSBlock);
      PN.addIncoming(RHS, RHSBlock);
      return PN;
    } finally {
      if (binding != null) { binding.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::VisitChooseExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 3347,
   FQN="(anonymous namespace)::ScalarExprEmitter::VisitChooseExpr", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter15VisitChooseExprEPN5clang10ChooseExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter15VisitChooseExprEPN5clang10ChooseExprE")
  //</editor-fold>
  public Value /*P*/ VisitChooseExpr(ChooseExpr /*P*/ E) {
    return Visit(E.getChosenSubExpr());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::VisitVAArgExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 3351,
   FQN="(anonymous namespace)::ScalarExprEmitter::VisitVAArgExpr", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter14VisitVAArgExprEPN5clang9VAArgExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter14VisitVAArgExprEPN5clang9VAArgExprE")
  //</editor-fold>
  public Value /*P*/ VisitVAArgExpr(VAArgExpr /*P*/ VE) {
    QualType Ty = VE.getType();
    if (Ty.$arrow().isVariablyModifiedType()) {
      CGF.EmitVariablyModifiedType(new QualType(Ty));
    }
    
    Address ArgValue = Address.invalid();
    Address ArgPtr = CGF.EmitVAArg(VE, ArgValue);
    
    Type /*P*/ ArgTy = ConvertType(VE.getType());
    
    // If EmitVAArg fails, emit an error.
    if (!ArgPtr.isValid()) {
      CGF.ErrorUnsupported(VE, $("va_arg expression"));
      return UndefValue.get(ArgTy);
    }
    
    // FIXME Volatility.
    Value /*P*/ Val = Builder.CreateLoad(new Address(ArgPtr));
    
    // If EmitVAArg promoted the type, we must truncate it.
    if (ArgTy != Val.getType()) {
      if (ArgTy.isPointerTy() && !Val.getType().isPointerTy()) {
        Val = Builder.CreateIntToPtr(Val, ArgTy);
      } else {
        Val = Builder.CreateTrunc(Val, ArgTy);
      }
    }
    
    return Val;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::VisitObjCStringLiteral">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 555,
   FQN="(anonymous namespace)::ScalarExprEmitter::VisitObjCStringLiteral", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter22VisitObjCStringLiteralEPKN5clang17ObjCStringLiteralE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter22VisitObjCStringLiteralEPKN5clang17ObjCStringLiteralE")
  //</editor-fold>
  public Value /*P*/ VisitObjCStringLiteral(/*const*/ ObjCStringLiteral /*P*/ E) {
    return CGF.EmitObjCStringLiteral(E);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::VisitObjCBoxedExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 558,
   FQN="(anonymous namespace)::ScalarExprEmitter::VisitObjCBoxedExpr", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter18VisitObjCBoxedExprEPN5clang13ObjCBoxedExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter18VisitObjCBoxedExprEPN5clang13ObjCBoxedExprE")
  //</editor-fold>
  public Value /*P*/ VisitObjCBoxedExpr(ObjCBoxedExpr /*P*/ E) {
    return CGF.EmitObjCBoxedExpr(E);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::VisitObjCArrayLiteral">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 561,
   FQN="(anonymous namespace)::ScalarExprEmitter::VisitObjCArrayLiteral", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter21VisitObjCArrayLiteralEPN5clang16ObjCArrayLiteralE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter21VisitObjCArrayLiteralEPN5clang16ObjCArrayLiteralE")
  //</editor-fold>
  public Value /*P*/ VisitObjCArrayLiteral(ObjCArrayLiteral /*P*/ E) {
    return CGF.EmitObjCArrayLiteral(E);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::VisitObjCDictionaryLiteral">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 564,
   FQN="(anonymous namespace)::ScalarExprEmitter::VisitObjCDictionaryLiteral", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter26VisitObjCDictionaryLiteralEPN5clang21ObjCDictionaryLiteralE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter26VisitObjCDictionaryLiteralEPN5clang21ObjCDictionaryLiteralE")
  //</editor-fold>
  public Value /*P*/ VisitObjCDictionaryLiteral(ObjCDictionaryLiteral /*P*/ E) {
    return CGF.EmitObjCDictionaryLiteral(E);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::VisitAsTypeExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 3400,
   FQN="(anonymous namespace)::ScalarExprEmitter::VisitAsTypeExpr", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter15VisitAsTypeExprEPN5clang10AsTypeExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter15VisitAsTypeExprEPN5clang10AsTypeExprE")
  //</editor-fold>
  public Value /*P*/ VisitAsTypeExpr(AsTypeExpr /*P*/ E) {
    Value /*P*/ Src = CGF.EmitScalarExpr(E.getSrcExpr());
    Type /*P*/ DstTy = ConvertType(E.getType());
    
    Type /*P*/ SrcTy = Src.getType();
    /*uint*/int NumElementsSrc = isa_VectorType(SrcTy) ? cast_VectorType(SrcTy).getNumElements() : 0;
    /*uint*/int NumElementsDst = isa_VectorType(DstTy) ? cast_VectorType(DstTy).getNumElements() : 0;
    
    // Going from vec3 to non-vec3 is a special case and requires a shuffle
    // vector to get a vec4, then a bitcast if the target type is different.
    if (NumElementsSrc == 3 && NumElementsDst != 3) {
      Src = ConvertVec3AndVec4(Builder, CGF, Src, 4);
      Src = Builder.CreateBitCast(Src, DstTy);
      Src.setName(new Twine(/*KEEP_STR*/"astype"));
      return Src;
    }
    
    // Going from non-vec3 to vec3 is a special case and requires a bitcast
    // to vec4 if the original type is not vec4, then a shuffle vector to
    // get a vec3.
    if (NumElementsSrc != 3 && NumElementsDst == 3) {
      VectorType /*P*/ Vec4Ty = VectorType.get(DstTy.getVectorElementType(), 4);
      Src = Builder.CreateBitCast(Src, Vec4Ty);
      Src = ConvertVec3AndVec4(Builder, CGF, Src, 3);
      Src.setName(new Twine(/*KEEP_STR*/"astype"));
      return Src;
    }
    
    return Builder.CreateBitCast(Src, DstTy, new Twine(/*KEEP_STR*/"astype"));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScalarExprEmitter::VisitAtomicExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp", line = 3433,
   FQN="(anonymous namespace)::ScalarExprEmitter::VisitAtomicExpr", NM="_ZN12_GLOBAL__N_117ScalarExprEmitter15VisitAtomicExprEPN5clang10AtomicExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprScalar.cpp -nm=_ZN12_GLOBAL__N_117ScalarExprEmitter15VisitAtomicExprEPN5clang10AtomicExprE")
  //</editor-fold>
  public Value /*P*/ VisitAtomicExpr(AtomicExpr /*P*/ E) {
    return CGF.EmitAtomicExpr(E).getScalarVal();
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @FunctionalInterface public static interface Func {
    Value /*P*/ $call(ScalarExprEmitter $this, /*const*/ BinOpInfo /*&*/ opInfo);
  }


  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "CGF=" + CGF // NOI18N
              + ", Builder=" + Builder // NOI18N
              + ", IgnoreResultAssign=" + IgnoreResultAssign // NOI18N
              + ", VMContext=" + "[LLVMContext]" // NOI18N
              + super.toString(); // NOI18N
  }
}
