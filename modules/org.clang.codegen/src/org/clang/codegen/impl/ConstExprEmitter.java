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
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.llvm.ir.*;
import org.clang.codegen.CodeGen.impl.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.java.AstTypesRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.codegen.java.CodegenRTTI.*;
import static org.clank.support.Native.$Deref;
import org.clank.support.aliases.type$ptr;
import static org.llvm.ir.java.IrRTTI.*;


//===----------------------------------------------------------------------===//
//                             ConstExprEmitter
//===----------------------------------------------------------------------===//

/// This class only needs to handle two cases:
/// 1) Literals (this is used by APValue emission to emit literals).
/// 2) Arrays, structs and unions (outside C++11 mode, we don't currently
///    constant fold these types).
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ConstExprEmitter">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprConstant.cpp", line = 605,
 FQN="(anonymous namespace)::ConstExprEmitter", NM="_ZN12_GLOBAL__N_116ConstExprEmitterE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprConstant.cpp -nm=_ZN12_GLOBAL__N_116ConstExprEmitterE")
//</editor-fold>
public class ConstExprEmitter implements /*public*/ StmtVisitor<ConstExprEmitter, Constant /*P*/ > {
  private final CodeGenModule /*&*/ CGM;
  private CodeGenFunction /*P*/ CGF;
  private final LLVMContext /*&*/ VMContext;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ConstExprEmitter::ConstExprEmitter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprConstant.cpp", line = 611,
   FQN="(anonymous namespace)::ConstExprEmitter::ConstExprEmitter", NM="_ZN12_GLOBAL__N_116ConstExprEmitterC1ERN5clang7CodeGen13CodeGenModuleEPNS2_15CodeGenFunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprConstant.cpp -nm=_ZN12_GLOBAL__N_116ConstExprEmitterC1ERN5clang7CodeGen13CodeGenModuleEPNS2_15CodeGenFunctionE")
  //</editor-fold>
  public ConstExprEmitter(final CodeGenModule /*&*/ cgm, CodeGenFunction /*P*/ cgf) {
    // : StmtVisitor<ConstExprEmitter, Constant * >(), CGM(cgm), CGF(cgf), VMContext(cgm.getLLVMContext()) 
    //START JInit
    $StmtVisitor();
    this./*&*/CGM=/*&*/cgm;
    this.CGF = cgf;
    this./*&*/VMContext=/*&*/cgm.getLLVMContext();
    //END JInit
  }

  
  //===--------------------------------------------------------------------===//
  //                            Visitor Methods
  //===--------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ConstExprEmitter::VisitStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprConstant.cpp", line = 619,
   FQN="(anonymous namespace)::ConstExprEmitter::VisitStmt", NM="_ZN12_GLOBAL__N_116ConstExprEmitter9VisitStmtEPN5clang4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprConstant.cpp -nm=_ZN12_GLOBAL__N_116ConstExprEmitter9VisitStmtEPN5clang4StmtE")
  //</editor-fold>
  public Constant /*P*/ VisitStmt(Stmt /*P*/ S) {
    return null;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ConstExprEmitter::VisitParenExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprConstant.cpp", line = 623,
   FQN="(anonymous namespace)::ConstExprEmitter::VisitParenExpr", NM="_ZN12_GLOBAL__N_116ConstExprEmitter14VisitParenExprEPN5clang9ParenExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprConstant.cpp -nm=_ZN12_GLOBAL__N_116ConstExprEmitter14VisitParenExprEPN5clang9ParenExprE")
  //</editor-fold>
  public Constant /*P*/ VisitParenExpr(ParenExpr /*P*/ PE) {
    return Visit(PE.getSubExpr());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ConstExprEmitter::VisitSubstNonTypeTemplateParmExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprConstant.cpp", line = 627,
   FQN="(anonymous namespace)::ConstExprEmitter::VisitSubstNonTypeTemplateParmExpr", NM="_ZN12_GLOBAL__N_116ConstExprEmitter33VisitSubstNonTypeTemplateParmExprEPN5clang28SubstNonTypeTemplateParmExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprConstant.cpp -nm=_ZN12_GLOBAL__N_116ConstExprEmitter33VisitSubstNonTypeTemplateParmExprEPN5clang28SubstNonTypeTemplateParmExprE")
  //</editor-fold>
  public Constant /*P*/ VisitSubstNonTypeTemplateParmExpr(SubstNonTypeTemplateParmExpr /*P*/ PE) {
    return Visit(PE.getReplacement());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ConstExprEmitter::VisitGenericSelectionExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprConstant.cpp", line = 632,
   FQN="(anonymous namespace)::ConstExprEmitter::VisitGenericSelectionExpr", NM="_ZN12_GLOBAL__N_116ConstExprEmitter25VisitGenericSelectionExprEPN5clang20GenericSelectionExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprConstant.cpp -nm=_ZN12_GLOBAL__N_116ConstExprEmitter25VisitGenericSelectionExprEPN5clang20GenericSelectionExprE")
  //</editor-fold>
  public Constant /*P*/ VisitGenericSelectionExpr(GenericSelectionExpr /*P*/ GE) {
    return Visit(GE.getResultExpr());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ConstExprEmitter::VisitChooseExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprConstant.cpp", line = 636,
   FQN="(anonymous namespace)::ConstExprEmitter::VisitChooseExpr", NM="_ZN12_GLOBAL__N_116ConstExprEmitter15VisitChooseExprEPN5clang10ChooseExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprConstant.cpp -nm=_ZN12_GLOBAL__N_116ConstExprEmitter15VisitChooseExprEPN5clang10ChooseExprE")
  //</editor-fold>
  public Constant /*P*/ VisitChooseExpr(ChooseExpr /*P*/ CE) {
    return Visit(CE.getChosenSubExpr());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ConstExprEmitter::VisitCompoundLiteralExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprConstant.cpp", line = 640,
   FQN="(anonymous namespace)::ConstExprEmitter::VisitCompoundLiteralExpr", NM="_ZN12_GLOBAL__N_116ConstExprEmitter24VisitCompoundLiteralExprEPN5clang19CompoundLiteralExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprConstant.cpp -nm=_ZN12_GLOBAL__N_116ConstExprEmitter24VisitCompoundLiteralExprEPN5clang19CompoundLiteralExprE")
  //</editor-fold>
  public Constant /*P*/ VisitCompoundLiteralExpr(CompoundLiteralExpr /*P*/ E) {
    return Visit(E.getInitializer());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ConstExprEmitter::VisitCastExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprConstant.cpp", line = 644,
   FQN="(anonymous namespace)::ConstExprEmitter::VisitCastExpr", NM="_ZN12_GLOBAL__N_116ConstExprEmitter13VisitCastExprEPN5clang8CastExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprConstant.cpp -nm=_ZN12_GLOBAL__N_116ConstExprEmitter13VisitCastExprEPN5clang8CastExprE")
  //</editor-fold>
  public Constant /*P*/ VisitCastExpr(CastExpr /*P*/ E) {
    {
      /*const*/ ExplicitCastExpr /*P*/ ECE = dyn_cast_ExplicitCastExpr(E);
      if ((ECE != null)) {
        CGM.EmitExplicitCastExprType(ECE, CGF);
      }
    }
    Expr /*P*/ subExpr = E.getSubExpr();
    Constant /*P*/ C = CGM.EmitConstantExpr(subExpr, subExpr.getType(), CGF);
    if (!(C != null)) {
      return null;
    }
    
    org.llvm.ir.Type /*P*/ destType = ConvertType(E.getType());
    switch (E.getCastKind()) {
     case CK_ToUnion:
      {
        // GCC cast to union extension
        assert (E.getType().$arrow().isUnionType()) : "Destination type is not union type!";
        
        // Build a struct with the union sub-element as the first member,
        // and padded to the appropriate size
        SmallVector<Constant /*P*/ > Elts/*J*/= new SmallVector<Constant /*P*/ >(2, (Constant /*P*/ )null);
        SmallVector<org.llvm.ir.Type /*P*/ > Types/*J*/= new SmallVector<org.llvm.ir.Type /*P*/ >(2, (org.llvm.ir.Type /*P*/ )null);
        Elts.push_back(C);
        Types.push_back(C.getType());
        /*uint*/int CurSize = $ulong2uint(CGM.getDataLayout().getTypeAllocSize(C.getType()));
        /*uint*/int TotalSize = $ulong2uint(CGM.getDataLayout().getTypeAllocSize(destType));
        assert ($lesseq_uint(CurSize, TotalSize)) : "Union size mismatch!";
        {
          /*uint*/int NumPadBytes = TotalSize - CurSize;
          if ((NumPadBytes != 0)) {
            org.llvm.ir.Type /*P*/ Ty = CGM.Int8Ty;
            if ($greater_uint(NumPadBytes, 1)) {
              Ty = org.llvm.ir.ArrayType.get(Ty, $uint2ulong(NumPadBytes));
            }
            
            Elts.push_back(UndefValue.get(Ty));
            Types.push_back(Ty);
          }
        }
        
        StructType /*P*/ STy = StructType.get(C.getType().getContext(), new ArrayRef<org.llvm.ir.Type /*P*/ >(Types, true), false);
        return ConstantStruct.get(STy, new ArrayRef<Constant /*P*/ >(Elts, true));
      }
     case CK_AddressSpaceConversion:
      return ConstantExpr.getAddrSpaceCast(C, destType);
     case CK_LValueToRValue:
     case CK_AtomicToNonAtomic:
     case CK_NonAtomicToAtomic:
     case CK_NoOp:
     case CK_ConstructorConversion:
      return C;
     case CK_Dependent:
      throw new llvm_unreachable("saw dependent cast!");
     case CK_BuiltinFnToFnPtr:
      throw new llvm_unreachable("builtin functions are handled elsewhere");
     case CK_ReinterpretMemberPointer:
     case CK_DerivedToBaseMemberPointer:
     case CK_BaseToDerivedMemberPointer:
      return CGM.getCXXABI().EmitMemberPointerConversion(E, C);
     case CK_ObjCObjectLValueCast:
     case CK_ARCProduceObject:
     case CK_ARCConsumeObject:
     case CK_ARCReclaimReturnedObject:
     case CK_ARCExtendBlockObject:
     case CK_CopyAndAutoreleaseBlockObject:
      
      // These will never be supported.
      return null;
     case CK_BitCast:
     case CK_ToVoid:
     case CK_Dynamic:
     case CK_LValueBitCast:
     case CK_NullToMemberPointer:
     case CK_UserDefinedConversion:
     case CK_CPointerToObjCPointerCast:
     case CK_BlockPointerToObjCPointerCast:
     case CK_AnyPointerToBlockPointerCast:
     case CK_ArrayToPointerDecay:
     case CK_FunctionToPointerDecay:
     case CK_BaseToDerived:
     case CK_DerivedToBase:
     case CK_UncheckedDerivedToBase:
     case CK_MemberPointerToBoolean:
     case CK_VectorSplat:
     case CK_FloatingRealToComplex:
     case CK_FloatingComplexToReal:
     case CK_FloatingComplexToBoolean:
     case CK_FloatingComplexCast:
     case CK_FloatingComplexToIntegralComplex:
     case CK_IntegralRealToComplex:
     case CK_IntegralComplexToReal:
     case CK_IntegralComplexToBoolean:
     case CK_IntegralComplexCast:
     case CK_IntegralComplexToFloatingComplex:
     case CK_PointerToIntegral:
     case CK_PointerToBoolean:
     case CK_NullToPointer:
     case CK_IntegralCast:
     case CK_BooleanToSignedIntegral:
     case CK_IntegralToPointer:
     case CK_IntegralToBoolean:
     case CK_IntegralToFloating:
     case CK_FloatingToIntegral:
     case CK_FloatingToBoolean:
     case CK_FloatingCast:
     case CK_ZeroToOCLEvent:
      
      // These don't need to be handled here because Evaluate knows how to
      // evaluate them in the cases where they can be folded.
      return null;
    }
    throw new llvm_unreachable("Invalid CastKind");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ConstExprEmitter::VisitCXXDefaultArgExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprConstant.cpp", line = 757,
   FQN="(anonymous namespace)::ConstExprEmitter::VisitCXXDefaultArgExpr", NM="_ZN12_GLOBAL__N_116ConstExprEmitter22VisitCXXDefaultArgExprEPN5clang17CXXDefaultArgExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprConstant.cpp -nm=_ZN12_GLOBAL__N_116ConstExprEmitter22VisitCXXDefaultArgExprEPN5clang17CXXDefaultArgExprE")
  //</editor-fold>
  public Constant /*P*/ VisitCXXDefaultArgExpr(CXXDefaultArgExpr /*P*/ DAE) {
    return Visit(DAE.getExpr());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ConstExprEmitter::VisitCXXDefaultInitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprConstant.cpp", line = 761,
   FQN="(anonymous namespace)::ConstExprEmitter::VisitCXXDefaultInitExpr", NM="_ZN12_GLOBAL__N_116ConstExprEmitter23VisitCXXDefaultInitExprEPN5clang18CXXDefaultInitExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprConstant.cpp -nm=_ZN12_GLOBAL__N_116ConstExprEmitter23VisitCXXDefaultInitExprEPN5clang18CXXDefaultInitExprE")
  //</editor-fold>
  public Constant /*P*/ VisitCXXDefaultInitExpr(CXXDefaultInitExpr /*P*/ DIE) {
    // No need for a DefaultInitExprScope: we don't handle 'this' in a
    // constant expression.
    return Visit(DIE.getExpr());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ConstExprEmitter::VisitExprWithCleanups">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprConstant.cpp", line = 767,
   FQN="(anonymous namespace)::ConstExprEmitter::VisitExprWithCleanups", NM="_ZN12_GLOBAL__N_116ConstExprEmitter21VisitExprWithCleanupsEPN5clang16ExprWithCleanupsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprConstant.cpp -nm=_ZN12_GLOBAL__N_116ConstExprEmitter21VisitExprWithCleanupsEPN5clang16ExprWithCleanupsE")
  //</editor-fold>
  public Constant /*P*/ VisitExprWithCleanups(ExprWithCleanups /*P*/ E) {
    if (!E.cleanupsHaveSideEffects()) {
      return Visit(E.getSubExpr());
    }
    return null;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ConstExprEmitter::VisitMaterializeTemporaryExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprConstant.cpp", line = 773,
   FQN="(anonymous namespace)::ConstExprEmitter::VisitMaterializeTemporaryExpr", NM="_ZN12_GLOBAL__N_116ConstExprEmitter29VisitMaterializeTemporaryExprEPN5clang24MaterializeTemporaryExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprConstant.cpp -nm=_ZN12_GLOBAL__N_116ConstExprEmitter29VisitMaterializeTemporaryExprEPN5clang24MaterializeTemporaryExprE")
  //</editor-fold>
  public Constant /*P*/ VisitMaterializeTemporaryExpr(MaterializeTemporaryExpr /*P*/ E) {
    return Visit(E.GetTemporaryExpr());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ConstExprEmitter::EmitArrayInitialization">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprConstant.cpp", line = 777,
   FQN="(anonymous namespace)::ConstExprEmitter::EmitArrayInitialization", NM="_ZN12_GLOBAL__N_116ConstExprEmitter23EmitArrayInitializationEPN5clang12InitListExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprConstant.cpp -nm=_ZN12_GLOBAL__N_116ConstExprEmitter23EmitArrayInitializationEPN5clang12InitListExprE")
  //</editor-fold>
  public Constant /*P*/ EmitArrayInitialization(InitListExpr /*P*/ ILE) {
    std.vector<Constant /*P*/ > Elts = null;
    try {
      if (ILE.isStringLiteralInit()) {
        return Visit(ILE.getInit(0));
      }
      
      org.llvm.ir.ArrayType /*P*/ AType = cast_ArrayType(ConvertType(ILE.getType()));
      org.llvm.ir.Type /*P*/ ElemTy = AType.getElementType();
      /*uint*/int NumInitElements = ILE.getNumInits();
      /*uint*/int NumElements = $ulong2uint(AType.getNumElements());
      
      // Initialising an array requires us to automatically
      // initialise any elements that have not been initialised explicitly
      /*uint*/int NumInitableElts = std.min_uint(NumInitElements, NumElements);
      
      // Initialize remaining array elements.
      // FIXME: This doesn't handle member pointers correctly!
      Constant /*P*/ fillC;
      {
        Expr /*P*/ filler = ILE.getArrayFiller();
        if ((filler != null)) {
          fillC = CGM.EmitConstantExpr(filler, filler.getType(), CGF);
        } else {
          fillC = Constant.getNullValue(ElemTy);
        }
      }
      if (!(fillC != null)) {
        return null;
      }
      
      // Try to use a ConstantAggregateZero if we can.
      if (fillC.isNullValue() && !(NumInitableElts != 0)) {
        return ConstantAggregateZero.get(AType);
      }
      
      // Copy initializer elements.
      Elts/*J*/= new std.vector<Constant /*P*/ >((Constant /*P*/ )null);
      Elts.reserve(NumInitableElts + NumElements);
      
      boolean RewriteType = false;
      for (/*uint*/int i = 0; $less_uint(i, NumInitableElts); ++i) {
        Expr /*P*/ Init = ILE.getInit(i);
        Constant /*P*/ C = CGM.EmitConstantExpr(Init, Init.getType(), CGF);
        if (!(C != null)) {
          return null;
        }
        RewriteType |= (C.getType() != ElemTy);
        Elts.push_back_T$C$R(C);
      }
      
      RewriteType |= (fillC.getType() != ElemTy);
      Elts.resize(NumElements, fillC);
      if (RewriteType) {
        std.vector<org.llvm.ir.Type /*P*/ > Types = null;
        try {
          // FIXME: Try to avoid packing the array
          Types/*J*/= new std.vector<org.llvm.ir.Type /*P*/ >((org.llvm.ir.Type /*P*/ )null);
          Types.reserve(NumInitableElts + NumElements);
          for (/*uint*/int i = 0, e = Elts.size(); $less_uint(i, e); ++i)  {
            Types.push_back_T$RR(Elts.$at(i).getType());
          }
          StructType /*P*/ SType = StructType.get(AType.getContext(), 
              new ArrayRef<org.llvm.ir.Type /*P*/ >(Types, true), true);
          return ConstantStruct.get(SType, new ArrayRef<Constant /*P*/ >(Elts, true));
        } finally {
          if (Types != null) { Types.$destroy(); }
        }
      }
      
      return ConstantArray.get(AType, new ArrayRef<Constant /*P*/ >(Elts, true));
    } finally {
      if (Elts != null) { Elts.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ConstExprEmitter::EmitRecordInitialization">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprConstant.cpp", line = 836,
   FQN="(anonymous namespace)::ConstExprEmitter::EmitRecordInitialization", NM="_ZN12_GLOBAL__N_116ConstExprEmitter24EmitRecordInitializationEPN5clang12InitListExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprConstant.cpp -nm=_ZN12_GLOBAL__N_116ConstExprEmitter24EmitRecordInitializationEPN5clang12InitListExprE")
  //</editor-fold>
  public Constant /*P*/ EmitRecordInitialization(InitListExpr /*P*/ ILE) {
    return ConstStructBuilder.BuildStruct(CGM, CGF, ILE);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ConstExprEmitter::VisitImplicitValueInitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprConstant.cpp", line = 840,
   FQN="(anonymous namespace)::ConstExprEmitter::VisitImplicitValueInitExpr", NM="_ZN12_GLOBAL__N_116ConstExprEmitter26VisitImplicitValueInitExprEPN5clang21ImplicitValueInitExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprConstant.cpp -nm=_ZN12_GLOBAL__N_116ConstExprEmitter26VisitImplicitValueInitExprEPN5clang21ImplicitValueInitExprE")
  //</editor-fold>
  public Constant /*P*/ VisitImplicitValueInitExpr(ImplicitValueInitExpr /*P*/ E) {
    return CGM.EmitNullConstant(E.getType());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ConstExprEmitter::VisitInitListExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprConstant.cpp", line = 844,
   FQN="(anonymous namespace)::ConstExprEmitter::VisitInitListExpr", NM="_ZN12_GLOBAL__N_116ConstExprEmitter17VisitInitListExprEPN5clang12InitListExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprConstant.cpp -nm=_ZN12_GLOBAL__N_116ConstExprEmitter17VisitInitListExprEPN5clang12InitListExprE")
  //</editor-fold>
  public Constant /*P*/ VisitInitListExpr(InitListExpr /*P*/ ILE) {
    if (ILE.getType().$arrow().isArrayType()) {
      return EmitArrayInitialization(ILE);
    }
    if (ILE.getType().$arrow().isRecordType()) {
      return EmitRecordInitialization(ILE);
    }
    
    return null;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ConstExprEmitter::EmitDesignatedInitUpdater">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprConstant.cpp", line = 854,
   FQN="(anonymous namespace)::ConstExprEmitter::EmitDesignatedInitUpdater", NM="_ZN12_GLOBAL__N_116ConstExprEmitter25EmitDesignatedInitUpdaterEPN4llvm8ConstantEPN5clang12InitListExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprConstant.cpp -nm=_ZN12_GLOBAL__N_116ConstExprEmitter25EmitDesignatedInitUpdaterEPN4llvm8ConstantEPN5clang12InitListExprE")
  //</editor-fold>
  public Constant /*P*/ EmitDesignatedInitUpdater(Constant /*P*/ Base, 
                           InitListExpr /*P*/ Updater) {
    QualType ExprType = Updater.getType();
    if (ExprType.$arrow().isArrayType()) {
      std.vector<Constant /*P*/ > Elts = null;
      try {
        org.llvm.ir.ArrayType /*P*/ AType = cast_ArrayType(ConvertType(new QualType(ExprType)));
        org.llvm.ir.Type /*P*/ ElemType = AType.getElementType();
        
        /*uint*/int NumInitElements = Updater.getNumInits();
        /*uint*/int NumElements = $ulong2uint(AType.getNumElements());
        
        Elts/*J*/= new std.vector<Constant /*P*/ >((Constant /*P*/ )null);
        Elts.reserve(NumElements);
        {
          
          ConstantDataArray /*P*/ DataArray = dyn_cast_ConstantDataArray(Base);
          if ((DataArray != null)) {
            for (/*uint*/int i = 0; i != NumElements; ++i)  {
              Elts.push_back_T$RR(DataArray.getElementAsConstant(i));
            }
          } else {
            ConstantArray /*P*/ Array = dyn_cast_ConstantArray(Base);
            if ((Array != null)) {
              for (/*uint*/int i = 0; i != NumElements; ++i)  {
                Elts.push_back_T$RR(Array.getOperand(i));
              }
            } else {
              return null; // FIXME: other array types not implemented
            }
          }
        }
        
        Constant /*P*/ fillC = null;
        {
          Expr /*P*/ filler = Updater.getArrayFiller();
          if ((filler != null)) {
            if (!isa_NoInitExpr(filler)) {
              fillC = CGM.EmitConstantExpr(filler, filler.getType(), CGF);
            }
          }
        }
        boolean RewriteType = ((fillC != null) && fillC.getType() != ElemType);
        
        for (/*uint*/int i = 0; i != NumElements; ++i) {
          Expr /*P*/ Init = null;
          if ($less_uint(i, NumInitElements)) {
            Init = Updater.getInit(i);
          }
          if (!(Init != null) && (fillC != null)) {
            Elts.$set(i, fillC);
          } else if (!(Init != null) || isa_NoInitExpr(Init)) {
            ; // Do nothing.
          } else {
            InitListExpr /*P*/ ChildILE = dyn_cast_InitListExpr(Init);
            if ((ChildILE != null)) {
              Elts.$set(i, EmitDesignatedInitUpdater(Elts.$at(i), ChildILE));
            } else {
              Elts.$set(i, CGM.EmitConstantExpr(Init, Init.getType(), CGF));
            }
          }
          if (!(Elts.$at(i) != null)) {
            return null;
          }
          RewriteType |= (Elts.$at(i).getType() != ElemType);
        }
        if (RewriteType) {
          std.vector<org.llvm.ir.Type /*P*/ > Types = null;
          try {
            Types/*J*/= new std.vector<org.llvm.ir.Type /*P*/ >((org.llvm.ir.Type /*P*/ )null);
            Types.reserve(NumElements);
            for (/*uint*/int i = 0; i != NumElements; ++i)  {
              Types.push_back_T$RR(Elts.$at(i).getType());
            }
            StructType /*P*/ SType = StructType.get(AType.getContext(), 
                new ArrayRef<org.llvm.ir.Type /*P*/ >(Types, true), true);
            return ConstantStruct.get(SType, new ArrayRef<Constant /*P*/ >(Elts, true));
          } finally {
            if (Types != null) { Types.$destroy(); }
          }
        }
        
        return ConstantArray.get(AType, new ArrayRef<Constant /*P*/ >(Elts, true));
      } finally {
        if (Elts != null) { Elts.$destroy(); }
      }
    }
    if (ExprType.$arrow().isRecordType()) {
      return ConstStructBuilder.BuildStruct(CGM, CGF, this, 
          dyn_cast_ConstantStruct(Base), Updater);
    }
    
    return null;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ConstExprEmitter::VisitDesignatedInitUpdateExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprConstant.cpp", line = 924,
   FQN="(anonymous namespace)::ConstExprEmitter::VisitDesignatedInitUpdateExpr", NM="_ZN12_GLOBAL__N_116ConstExprEmitter29VisitDesignatedInitUpdateExprEPN5clang24DesignatedInitUpdateExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprConstant.cpp -nm=_ZN12_GLOBAL__N_116ConstExprEmitter29VisitDesignatedInitUpdateExprEPN5clang24DesignatedInitUpdateExprE")
  //</editor-fold>
  public Constant /*P*/ VisitDesignatedInitUpdateExpr(DesignatedInitUpdateExpr /*P*/ E) {
    return EmitDesignatedInitUpdater(CGM.EmitConstantExpr(E.getBase(), E.getType(), CGF), 
        E.getUpdater());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ConstExprEmitter::VisitCXXConstructExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprConstant.cpp", line = 930,
   FQN="(anonymous namespace)::ConstExprEmitter::VisitCXXConstructExpr", NM="_ZN12_GLOBAL__N_116ConstExprEmitter21VisitCXXConstructExprEPN5clang16CXXConstructExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprConstant.cpp -nm=_ZN12_GLOBAL__N_116ConstExprEmitter21VisitCXXConstructExprEPN5clang16CXXConstructExprE")
  //</editor-fold>
  public Constant /*P*/ VisitCXXConstructExpr(CXXConstructExpr /*P*/ E) {
    if (!E.getConstructor().isTrivial()) {
      return null;
    }
    
    QualType Ty = E.getType();
    
    // FIXME: We should not have to call getBaseElementType here.
    /*const*/ RecordType /*P*/ RT = CGM.getContext().getBaseElementType(new QualType(Ty)).$arrow().getAs$RecordType();
    /*const*/ CXXRecordDecl /*P*/ RD = cast_CXXRecordDecl(RT.getDecl());
    
    // If the class doesn't have a trivial destructor, we can't emit it as a
    // constant expr.
    if (!RD.hasTrivialDestructor()) {
      return null;
    }
    
    // Only copy and default constructors can be trivial.
    if ((E.getNumArgs() != 0)) {
      assert (E.getNumArgs() == 1) : "trivial ctor with > 1 argument";
      assert (E.getConstructor().isCopyOrMoveConstructor()) : "trivial ctor has argument but isn't a copy/move ctor";
      
      Expr /*P*/ Arg = E.getArg(0);
      assert (CGM.getContext().hasSameUnqualifiedType(new QualType(Ty), Arg.getType())) : "argument to copy ctor is of wrong type";
      
      return Visit(Arg);
    }
    
    return CGM.EmitNullConstant(new QualType(Ty));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ConstExprEmitter::VisitStringLiteral">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprConstant.cpp", line = 964,
   FQN="(anonymous namespace)::ConstExprEmitter::VisitStringLiteral", NM="_ZN12_GLOBAL__N_116ConstExprEmitter18VisitStringLiteralEPN5clang13StringLiteralE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprConstant.cpp -nm=_ZN12_GLOBAL__N_116ConstExprEmitter18VisitStringLiteralEPN5clang13StringLiteralE")
  //</editor-fold>
  public Constant /*P*/ VisitStringLiteral(StringLiteral /*P*/ E) {
    return CGM.GetConstantArrayFromStringLiteral(E);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ConstExprEmitter::VisitObjCEncodeExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprConstant.cpp", line = 968,
   FQN="(anonymous namespace)::ConstExprEmitter::VisitObjCEncodeExpr", NM="_ZN12_GLOBAL__N_116ConstExprEmitter19VisitObjCEncodeExprEPN5clang14ObjCEncodeExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprConstant.cpp -nm=_ZN12_GLOBAL__N_116ConstExprEmitter19VisitObjCEncodeExprEPN5clang14ObjCEncodeExprE")
  //</editor-fold>
  public Constant /*P*/ VisitObjCEncodeExpr(ObjCEncodeExpr /*P*/ E) {
    // This must be an @encode initializing an array in a static initializer.
    // Don't emit it as the address of the string, emit the string data itself
    // as an inline array.
    std.string Str/*J*/= new std.string();
    CGM.getContext().getObjCEncodingForType(E.getEncodedType(), Str);
    QualType T = E.getType();
    if (T.$arrow().getTypeClass() == org.clang.ast.Type.TypeClass.TypeOfExpr) {
      T.$assignMove(cast_TypeOfExprType(T).getUnderlyingExpr().getType());
    }
    /*const*/ ConstantArrayType /*P*/ CAT = cast_ConstantArrayType(T);
    
    // Resize the string to the right size, adding zeros at the end, or
    // truncating as needed.
    Str.resize($ulong2uint(CAT.getSize().getZExtValue()), $$TERM);
    return ConstantDataArray.getString(VMContext, new StringRef(Str), false);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ConstExprEmitter::VisitUnaryExtension">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprConstant.cpp", line = 985,
   FQN="(anonymous namespace)::ConstExprEmitter::VisitUnaryExtension", NM="_ZN12_GLOBAL__N_116ConstExprEmitter19VisitUnaryExtensionEPKN5clang13UnaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprConstant.cpp -nm=_ZN12_GLOBAL__N_116ConstExprEmitter19VisitUnaryExtensionEPKN5clang13UnaryOperatorE")
  //</editor-fold>
  public Constant /*P*/ VisitUnaryExtension(/*const*/ UnaryOperator /*P*/ E) {
    return Visit(E.getSubExpr());
  }

  
  // Utility methods
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ConstExprEmitter::ConvertType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprConstant.cpp", line = 990,
   FQN="(anonymous namespace)::ConstExprEmitter::ConvertType", NM="_ZN12_GLOBAL__N_116ConstExprEmitter11ConvertTypeEN5clang8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprConstant.cpp -nm=_ZN12_GLOBAL__N_116ConstExprEmitter11ConvertTypeEN5clang8QualTypeE")
  //</editor-fold>
  public org.llvm.ir.Type /*P*/ ConvertType(QualType T) {
    return CGM.getTypes().ConvertType(new QualType(T));
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ConstExprEmitter::EmitLValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprConstant.cpp", line = 995,
   FQN="(anonymous namespace)::ConstExprEmitter::EmitLValue", NM="_ZN12_GLOBAL__N_116ConstExprEmitter10EmitLValueEN4llvm12PointerUnionIPKN5clang9ValueDeclEPKNS3_4ExprEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExprConstant.cpp -nm=_ZN12_GLOBAL__N_116ConstExprEmitter10EmitLValueEN4llvm12PointerUnionIPKN5clang9ValueDeclEPKNS3_4ExprEEE")
  //</editor-fold>
  public ConstantAddress EmitLValue(PointerUnion</*const*/ ValueDecl /*P*/ , /*const*/ Expr /*P*/ > LVBase) {
    {
      /*const*/ ValueDecl /*P*/ Decl = LVBase.dyn_cast(/*const*/ ValueDecl /*P*/.class);
      if ((Decl != null)) {
        if (Decl.hasAttr(WeakRefAttr.class)) {
          return CGM.GetWeakRefReference(Decl);
        }
        {
          /*const*/ FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(Decl);
          if ((FD != null)) {
            return new ConstantAddress(CGM.GetAddrOfFunction(new GlobalDecl(FD)), CharUnits.One());
          }
        }
        {
          /*const*/ VarDecl /*P*/ VD = dyn_cast_VarDecl(Decl);
          if ((VD != null)) {
            // We can never refer to a variable with local storage.
            if (!VD.hasLocalStorage()) {
              CharUnits Align = CGM.getContext().getDeclAlign(VD);
              if (VD.isFileVarDecl() || VD.hasExternalStorage()) {
                return new ConstantAddress(CGM.GetAddrOfGlobalVar(VD), new CharUnits(Align));
              } else if (VD.isLocalVarDecl()) {
                Constant /*P*/ Ptr = CGM.getOrCreateStaticVarDecl($Deref(VD), CGM.getLLVMLinkageVarDefinition(VD, /*isConstant=*/ false));
                return new ConstantAddress(Ptr, new CharUnits(Align));
              }
            }
          }
        }
        return ConstantAddress.invalid();
      }
    }
    
    Expr /*P*/ E = ((/*const_cast*/Expr /*P*/ )(LVBase.get(/*const*/ Expr /*P*/.class)));
    switch (E.getStmtClass()) {
     default:
      break;
     case CompoundLiteralExprClass:
      {
        // Note that due to the nature of compound literals, this is guaranteed
        // to be the only use of the variable, so we just generate it here.
        CompoundLiteralExpr /*P*/ CLE = cast_CompoundLiteralExpr(E);
        Constant /*P*/ C = CGM.EmitConstantExpr(CLE.getInitializer(), 
            CLE.getType(), CGF);
        // FIXME: "Leaked" on failure.
        if (!(C != null)) {
          return ConstantAddress.invalid();
        }
        
        CharUnits Align = CGM.getContext().getTypeAlignInChars(E.getType());
        
        GlobalVariable /*P*/ GV = /*NEW_EXPR [GlobalVariable::new]*/GlobalVariable.$new_GlobalVariable((type$ptr<?> New$Mem)->{
            return new GlobalVariable(CGM.getModule(), C.getType(), 
            E.getType().isConstant(CGM.getContext()), 
            GlobalValue.LinkageTypes.InternalLinkage, 
            C, new Twine(/*KEEP_STR*/".compoundliteral"), (GlobalVariable /*P*/ )null, 
            GlobalVariable.ThreadLocalMode.NotThreadLocal, 
            CGM.getContext().getTargetAddressSpace(E.getType()));
         });
        GV.setAlignment($long2uint(Align.getQuantity()));
        return new ConstantAddress(GV, new CharUnits(Align));
      }
     case StringLiteralClass:
      return CGM.GetAddrOfConstantStringFromLiteral(cast_StringLiteral(E));
     case ObjCEncodeExprClass:
      return CGM.GetAddrOfConstantStringFromObjCEncode(cast_ObjCEncodeExpr(E));
     case ObjCStringLiteralClass:
      {
        ObjCStringLiteral /*P*/ SL = cast_ObjCStringLiteral(E);
        ConstantAddress C = CGM.getObjCRuntime().GenerateConstantString(SL.getString());
        return C.getElementBitCast(ConvertType(E.getType()));
      }
     case PredefinedExprClass:
      {
        /*uint*/int Type = cast_PredefinedExpr(E).getIdentType().getValue();
        if ((CGF != null)) {
          LValue Res = CGF.EmitPredefinedLValue(cast_PredefinedExpr(E));
          return cast_ConstantAddress(Res.getAddress());
        } else if (Type == PredefinedExpr.IdentType.PrettyFunction.getValue()) {
          return CGM.GetAddrOfConstantCString(new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"top level"), $(".tmp"));
        }
        
        return CGM.GetAddrOfConstantCString(new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/$EMPTY), $(".tmp"));
      }
     case AddrLabelExprClass:
      {
        assert ((CGF != null)) : "Invalid address of label expression outside function.";
        Constant /*P*/ Ptr = CGF.GetAddrOfLabel(cast_AddrLabelExpr(E).getLabel());
        Ptr = ConstantExpr.getBitCast(Ptr, ConvertType(E.getType()));
        return new ConstantAddress(Ptr, CharUnits.One());
      }
     case CallExprClass:
      {
        CallExpr /*P*/ CE = cast_CallExpr(E);
        /*uint*/int builtin = CE.getBuiltinCallee();
        if (builtin
           != Builtin.ID.BI__builtin___CFStringMakeConstantString.getValue()
           && builtin
           != Builtin.ID.BI__builtin___NSStringMakeConstantString.getValue()) {
          break;
        }
        /*const*/ Expr /*P*/ Arg = CE.getArg(0).IgnoreParenCasts();
        /*const*/ StringLiteral /*P*/ Literal = cast_StringLiteral(Arg);
        if (builtin
           == Builtin.ID.BI__builtin___NSStringMakeConstantString.getValue()) {
          return CGM.getObjCRuntime().GenerateConstantString(Literal);
        }
        // FIXME: need to deal with UCN conversion issues.
        return CGM.GetAddrOfConstantCFString(Literal);
      }
     case BlockExprClass:
      {
        std.string FunctionName/*J*/= new std.string();
        if ((CGF != null)) {
          FunctionName.$assignMove(CGF.CurFn.getName().$string());
        } else {
          FunctionName.$assign_T$C$P(/*KEEP_STR*/"global");
        }
        
        // This is not really an l-value.
        Constant /*P*/ Ptr = CGM.GetAddrOfGlobalBlock(cast_BlockExpr(E), FunctionName.c_str());
        return new ConstantAddress(Ptr, CGM.getPointerAlign());
      }
     case CXXTypeidExprClass:
      {
        CXXTypeidExpr /*P*/ Typeid = cast_CXXTypeidExpr(E);
        QualType T/*J*/= new QualType();
        if (Typeid.isTypeOperand()) {
          T.$assignMove(Typeid.getTypeOperand(CGM.getContext()));
        } else {
          T.$assignMove(Typeid.getExprOperand().getType());
        }
        return new ConstantAddress(CGM.GetAddrOfRTTIDescriptor(new QualType(T)), 
            CGM.getPointerAlign());
      }
     case CXXUuidofExprClass:
      {
        return CGM.GetAddrOfUuidDescriptor(cast_CXXUuidofExpr(E));
      }
     case MaterializeTemporaryExprClass:
      {
        MaterializeTemporaryExpr /*P*/ MTE = cast_MaterializeTemporaryExpr(E);
        assert (MTE.getStorageDuration() == StorageDuration.SD_Static);
        SmallVector</*const*/ Expr /*P*/ > CommaLHSs/*J*/= new SmallVector</*const*/ Expr /*P*/ >(2, (/*const*/ Expr /*P*/ )null);
        SmallVector<SubobjectAdjustment> Adjustments/*J*/= new SmallVector<SubobjectAdjustment>(2, new SubobjectAdjustment());
        /*const*/ Expr /*P*/ Inner = MTE.GetTemporaryExpr().
            skipRValueSubobjectAdjustments(CommaLHSs, Adjustments);
        return CGM.GetAddrOfGlobalTemporary(MTE, Inner);
      }
    }
    
    return ConstantAddress.invalid();
  }

  
  @Override public String toString() {
    return "" + "CGM=" + CGM // NOI18N
              + ", CGF=" + CGF // NOI18N
              + ", VMContext=" + "[LLVMContext]" // NOI18N
              + super.toString(); // NOI18N
  }
}
