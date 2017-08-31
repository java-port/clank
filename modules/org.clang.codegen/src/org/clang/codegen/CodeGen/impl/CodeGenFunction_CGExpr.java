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
package org.clang.codegen.CodeGen.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.ast.java.*;
import org.clang.basic.*;
import org.llvm.ir.*;
import org.clang.codegen.impl.*;
import org.clang.codegen.CodeGen.*;
import org.llvm.ir.intrinsic.ID;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.java.AstTypesRTTI.*;
import static org.clank.support.Native.$AddrOf;
import static org.clank.support.Native.$Deref;
import org.llvm.adt.HashingGlobals.hash_code;
import static org.llvm.ir.java.IrRTTI.*;
import org.llvm.support.sys.path;
import static org.llvm.support.sys.path.*;
import org.llvm.transforms.utils.SanitizerStatKind;


//<editor-fold defaultstate="collapsed" desc="static type CodeGenFunction_CGExpr">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 NM="org.clang.codegen.CodeGen.impl.CodeGenFunction_CGExpr",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this -extends=CodeGenFunction_CGException ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction10EmitLValueEPKNS_4ExprE;_ZN5clang7CodeGen15CodeGenFunction11EmitAnyExprEPKNS_4ExprENS0_12AggValueSlotEb;_ZN5clang7CodeGen15CodeGenFunction12CreateIRTempENS_8QualTypeERKN4llvm5TwineE;_ZN5clang7CodeGen15CodeGenFunction12EmitCallExprEPKNS_8CallExprENS0_15ReturnValueSlotE;_ZN5clang7CodeGen15CodeGenFunction12EmitToMemoryEPN4llvm5ValueENS_8QualTypeE;_ZN5clang7CodeGen15CodeGenFunction12EmitTrapCallEN4llvm9Intrinsic2IDE;_ZN5clang7CodeGen15CodeGenFunction13CreateMemTempENS_8QualTypeENS_9CharUnitsERKN4llvm5TwineE;_ZN5clang7CodeGen15CodeGenFunction13CreateMemTempENS_8QualTypeERKN4llvm5TwineE;_ZN5clang7CodeGen15CodeGenFunction13EmitTrapCheckEPN4llvm5ValueE;_ZN5clang7CodeGen15CodeGenFunction13EmitTypeCheckENS1_13TypeCheckKindENS_14SourceLocationEPN4llvm5ValueENS_8QualTypeENS_9CharUnitsEb;_ZN5clang7CodeGen15CodeGenFunction13SetFPAccuracyEPN4llvm5ValueEf;_ZN5clang7CodeGen15CodeGenFunction14EmitCastLValueEPKNS_8CastExprE;_ZN5clang7CodeGen15CodeGenFunction14EmitCheckValueEPN4llvm5ValueE;_ZN5clang7CodeGen15CodeGenFunction14EmitFromMemoryEPN4llvm5ValueENS_8QualTypeE;_ZN5clang7CodeGen15CodeGenFunction14EmitIvarOffsetEPKNS_17ObjCInterfaceDeclEPKNS_12ObjCIvarDeclE;_ZN5clang7CodeGen15CodeGenFunction14EmitMemberExprEPKNS_10MemberExprE;_ZN5clang7CodeGen15CodeGenFunction14GetUndefRValueENS_8QualTypeE;_ZN5clang7CodeGen15CodeGenFunction14InitTempAllocaENS0_7AddressEPN4llvm5ValueE;_ZN5clang7CodeGen15CodeGenFunction15EmitBoundsCheckEPKNS_4ExprES4_PN4llvm5ValueENS_8QualTypeEb;_ZN5clang7CodeGen15CodeGenFunction15EmitIgnoredExprEPKNS_4ExprE;_ZN5clang7CodeGen15CodeGenFunction16CreateTempAllocaEPN4llvm4TypeENS_9CharUnitsERKNS2_5TwineE;_ZN5clang7CodeGen15CodeGenFunction16CreateTempAllocaEPN4llvm4TypeERKNS2_5TwineE;_ZN5clang7CodeGen15CodeGenFunction16EmitAnyExprToMemEPKNS_4ExprENS0_7AddressENS_10QualifiersEb;_ZN5clang7CodeGen15CodeGenFunction16EmitCfiCheckFailEv;_ZN5clang7CodeGen15CodeGenFunction16EmitLambdaLValueEPKNS_10LambdaExprE;_ZN5clang7CodeGen15CodeGenFunction16EmitLoadOfLValueENS0_6LValueENS_14SourceLocationE;_ZN5clang7CodeGen15CodeGenFunction16EmitLoadOfScalarENS0_6LValueENS_14SourceLocationE;_ZN5clang7CodeGen15CodeGenFunction16EmitLoadOfScalarENS0_7AddressEbNS_8QualTypeENS_14SourceLocationENS0_15AlignmentSourceEPN4llvm6MDNodeES3_yb;_ZN5clang7CodeGen15CodeGenFunction17EmitAnyExprToTempEPKNS_4ExprE;_ZN5clang7CodeGen15CodeGenFunction17EmitCXXUuidofExprEPKNS_13CXXUuidofExprE;_ZN5clang7CodeGen15CodeGenFunction17EmitCastToVoidPtrEPN4llvm5ValueE;_ZN5clang7CodeGen15CodeGenFunction17EmitCheckedLValueEPKNS_4ExprENS1_13TypeCheckKindE;_ZN5clang7CodeGen15CodeGenFunction17EmitDeclRefLValueEPKNS_11DeclRefExprE;_ZN5clang7CodeGen15CodeGenFunction17EmitLValueForIvarENS_8QualTypeEPN4llvm5ValueEPKNS_12ObjCIvarDeclEj;_ZN5clang7CodeGen15CodeGenFunction17EmitLoadOfPointerENS0_7AddressEPKNS_11PointerTypeEPNS0_15AlignmentSourceE;_ZN5clang7CodeGen15CodeGenFunction17EmitStoreOfScalarEPN4llvm5ValueENS0_6LValueEb;_ZN5clang7CodeGen15CodeGenFunction17EmitStoreOfScalarEPN4llvm5ValueENS0_7AddressEbNS_8QualTypeENS0_15AlignmentSourceEPNS2_6MDNodeEbS6_yb;_ZN5clang7CodeGen15CodeGenFunction17EmitUnaryOpLValueEPKNS_13UnaryOperatorE;_ZN5clang7CodeGen15CodeGenFunction17tryEmitAsConstantEPNS_11DeclRefExprE;_ZN5clang7CodeGen15CodeGenFunction18EmitCallExprLValueEPKNS_8CallExprE;_ZN5clang7CodeGen15CodeGenFunction18EmitInitListLValueEPKNS_12InitListExprE;_ZN5clang7CodeGen15CodeGenFunction18EmitLValueForFieldENS0_6LValueEPKNS_9FieldDeclE;_ZN5clang7CodeGen15CodeGenFunction18EmitRValueForFieldENS0_6LValueEPKNS_9FieldDeclENS_14SourceLocationE;_ZN5clang7CodeGen15CodeGenFunction18EmitStmtExprLValueEPKNS_8StmtExprE;_ZN5clang7CodeGen15CodeGenFunction18EvaluateExprAsBoolEPKNS_4ExprE;_ZN5clang7CodeGen15CodeGenFunction18getAccessedFieldNoEjPKN4llvm8ConstantE;_ZN5clang7CodeGen15CodeGenFunction19EmitCXXTypeidLValueEPKNS_13CXXTypeidExprE;_ZN5clang7CodeGen15CodeGenFunction19EmitCXXUuidofLValueEPKNS_13CXXUuidofExprE;_ZN5clang7CodeGen15CodeGenFunction19EmitLoadOfReferenceENS0_7AddressEPKNS_13ReferenceTypeEPNS0_15AlignmentSourceE;_ZN5clang7CodeGen15CodeGenFunction19EmitVAArgExprLValueEPKNS_9VAArgExprE;_ZN5clang7CodeGen15CodeGenFunction19convertTempToRValueENS0_7AddressENS_8QualTypeENS_14SourceLocationE;_ZN5clang7CodeGen15CodeGenFunction20EmitCfiSlowPathCheckEyPN4llvm5ValueEPNS2_11ConstantIntES4_NS2_8ArrayRefIPNS2_8ConstantEEE;_ZN5clang7CodeGen15CodeGenFunction20EmitPredefinedLValueEPKNS_14PredefinedExprE;_ZN5clang7CodeGen15CodeGenFunction21EmitObjCIvarRefLValueEPKNS_15ObjCIvarRefExprE;_ZN5clang7CodeGen15CodeGenFunction21EmitOpaqueValueLValueEPKNS_15OpaqueValueExprE;_ZN5clang7CodeGen15CodeGenFunction21EmitUnsupportedLValueEPKNS_4ExprEPKc;_ZN5clang7CodeGen15CodeGenFunction21EmitUnsupportedRValueEPKNS_4ExprEPKc;_ZN5clang7CodeGen15CodeGenFunction22EmitArraySubscriptExprEPKNS_18ArraySubscriptExprEb;_ZN5clang7CodeGen15CodeGenFunction22EmitCXXConstructLValueEPKNS_16CXXConstructExprE;_ZN5clang7CodeGen15CodeGenFunction22EmitObjCSelectorLValueEPKNS_16ObjCSelectorExprE;_ZN5clang7CodeGen15CodeGenFunction22EmitPseudoObjectLValueEPKNS_16PseudoObjectExprE;_ZN5clang7CodeGen15CodeGenFunction22EmitPseudoObjectRValueEPKNS_16PseudoObjectExprENS0_12AggValueSlotE;_ZN5clang7CodeGen15CodeGenFunction22EmitStoreThroughLValueENS0_6RValueENS0_6LValueEb;_ZN5clang7CodeGen15CodeGenFunction23EmitArrayToPointerDecayEPKNS_4ExprEPNS0_15AlignmentSourceE;_ZN5clang7CodeGen15CodeGenFunction23EmitCheckSourceLocationENS_14SourceLocationE;_ZN5clang7CodeGen15CodeGenFunction23EmitCheckTypeDescriptorENS_8QualTypeE;_ZN5clang7CodeGen15CodeGenFunction23EmitLoadOfPointerLValueENS0_7AddressEPKNS_11PointerTypeE;_ZN5clang7CodeGen15CodeGenFunction23EmitOMPArraySectionExprEPKNS_19OMPArraySectionExprEb;_ZN5clang7CodeGen15CodeGenFunction23EmitStringLiteralLValueEPKNS_13StringLiteralE;_ZN5clang7CodeGen15CodeGenFunction23getRangeForLoadFromTypeENS_8QualTypeE;_ZN5clang7CodeGen15CodeGenFunction24EmitBinaryOperatorLValueEPKNS_14BinaryOperatorE;_ZN5clang7CodeGen15CodeGenFunction24EmitComplexPrePostIncDecEPKNS_13UnaryOperatorENS0_6LValueEbb;_ZN5clang7CodeGen15CodeGenFunction24EmitExtVectorElementExprEPKNS_20ExtVectorElementExprE;_ZN5clang7CodeGen15CodeGenFunction24EmitLValueForLambdaFieldEPKNS_9FieldDeclE;_ZN5clang7CodeGen15CodeGenFunction24EmitLoadOfBitfieldLValueENS0_6LValueE;_ZN5clang7CodeGen15CodeGenFunction24EmitObjCEncodeExprLValueEPKNS_14ObjCEncodeExprE;_ZN5clang7CodeGen15CodeGenFunction24EmitPointerWithAlignmentEPKNS_4ExprEPNS0_15AlignmentSourceE;_ZN5clang7CodeGen15CodeGenFunction25EmitCompoundLiteralLValueEPKNS_19CompoundLiteralExprE;_ZN5clang7CodeGen15CodeGenFunction25EmitLoadOfGlobalRegLValueENS0_6LValueE;_ZN5clang7CodeGen15CodeGenFunction25EmitLoadOfReferenceLValueENS0_7AddressEPKNS_13ReferenceTypeE;_ZN5clang7CodeGen15CodeGenFunction25EmitObjCMessageExprLValueEPKNS_15ObjCMessageExprE;_ZN5clang7CodeGen15CodeGenFunction26EmitCXXBindTemporaryLValueEPKNS_20CXXBindTemporaryExprE;_ZN5clang7CodeGen15CodeGenFunction26EmitExtVectorElementLValueENS0_6LValueE;_ZN5clang7CodeGen15CodeGenFunction26EmitReferenceBindingToExprEPKNS_4ExprE;_ZN5clang7CodeGen15CodeGenFunction28CreateDefaultAlignTempAllocaEPN4llvm4TypeERKNS2_5TwineE;_ZN5clang7CodeGen15CodeGenFunction28EmitMaterializeTemporaryExprEPKNS_24MaterializeTemporaryExprE;_ZN5clang7CodeGen15CodeGenFunction29EmitConditionalOperatorLValueEPKNS_27AbstractConditionalOperatorE;_ZN5clang7CodeGen15CodeGenFunction30EmitStoreThroughBitfieldLValueENS0_6RValueENS0_6LValueEPPN4llvm5ValueE;_ZN5clang7CodeGen15CodeGenFunction31EmitStoreThroughGlobalRegLValueENS0_6RValueENS0_6LValueE;_ZN5clang7CodeGen15CodeGenFunction32EmitLValueForFieldInitializationENS0_6LValueEPKNS_9FieldDeclE;_ZN5clang7CodeGen15CodeGenFunction32EmitLoadOfExtVectorElementLValueENS0_6LValueE;_ZN5clang7CodeGen15CodeGenFunction33EmitPointerToDataMemberBinaryExprEPKNS_14BinaryOperatorE;_ZN5clang7CodeGen15CodeGenFunction40EmitStoreThroughExtVectorComponentLValueENS0_6RValueENS0_6LValueE;_ZN5clang7CodeGen15CodeGenFunction8EmitCallENS_8QualTypeEPN4llvm5ValueEPKNS_8CallExprENS0_15ReturnValueSlotENS0_12CGCalleeInfoES5_;_ZN5clang7CodeGen15CodeGenFunction9EmitCheckEN4llvm8ArrayRefISt4pairIPNS2_5ValueEyEEENS2_9StringRefENS3_IPNS2_8ConstantEEENS3_IS6_EE;_ZNK5clang7CodeGen15CodeGenFunction24sanitizePerformTypeCheckEv; -static-type=CodeGenFunction_CGExpr -package=org.clang.codegen.CodeGen.impl")
//</editor-fold>
public abstract class CodeGenFunction_CGExpr extends CodeGenFunction_CGException {
private final /*split clang::CodeGen::CodeGenFunction*/ CodeGenFunction $this() { return (CodeGenFunction)this; }
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::CodeGenFunction">
@Converted(kind = Converted.Kind.MANUAL_ADDED,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp", line = 40,
 FQN="clang::CodeGen::CodeGenFunction::CodeGenFunction", NM="_ZN5clang7CodeGen15CodeGenFunctionC1ERNS0_13CodeGenModuleEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp -nm=_ZN5clang7CodeGen15CodeGenFunctionC1ERNS0_13CodeGenModuleEb")
//</editor-fold>
protected CodeGenFunction_CGExpr(final CodeGenModule /*&*/ cgm) {
  super(cgm);
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitLoadOfReference">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp", line = 1958,
 FQN="clang::CodeGen::CodeGenFunction::EmitLoadOfReference", NM="_ZN5clang7CodeGen15CodeGenFunction19EmitLoadOfReferenceENS0_7AddressEPKNS_13ReferenceTypeEPNS0_15AlignmentSourceE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction19EmitLoadOfReferenceENS0_7AddressEPKNS_13ReferenceTypeEPNS0_15AlignmentSourceE")
//</editor-fold>
public final Address EmitLoadOfReference(Address Addr, 
                   /*const*/ ReferenceType /*P*/ RefTy) {
  return EmitLoadOfReference(Addr, 
                   RefTy, 
                   create_type$null$ptr());
}
public final Address EmitLoadOfReference(Address Addr, 
                   /*const*/ ReferenceType /*P*/ RefTy, 
                   type$ptr<AlignmentSource /*P*/> Source/*= null*/) {
  Value /*P*/ Ptr = $this().Builder.CreateLoad(new Address(Addr));
  return new Address(Ptr, $this().getNaturalTypeAlignment(RefTy.getPointeeType(), 
          Source, /*forPointee*/ true));
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitLoadOfReferenceLValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp", line = 1967,
 FQN="clang::CodeGen::CodeGenFunction::EmitLoadOfReferenceLValue", NM="_ZN5clang7CodeGen15CodeGenFunction25EmitLoadOfReferenceLValueENS0_7AddressEPKNS_13ReferenceTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction25EmitLoadOfReferenceLValueENS0_7AddressEPKNS_13ReferenceTypeE")
//</editor-fold>
public final LValue EmitLoadOfReferenceLValue(Address RefAddr, 
                         /*const*/ ReferenceType /*P*/ RefTy) {
  type$ptr<AlignmentSource> Source = create_type$null$ptr();
  Address Addr = $this().EmitLoadOfReference(new Address(RefAddr), RefTy, $AddrOf(Source));
  return $this().MakeAddrLValue(new Address(Addr), RefTy.getPointeeType(), Source.$star());
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitLoadOfPointer">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp", line = 1974,
 FQN="clang::CodeGen::CodeGenFunction::EmitLoadOfPointer", NM="_ZN5clang7CodeGen15CodeGenFunction17EmitLoadOfPointerENS0_7AddressEPKNS_11PointerTypeEPNS0_15AlignmentSourceE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction17EmitLoadOfPointerENS0_7AddressEPKNS_11PointerTypeEPNS0_15AlignmentSourceE")
//</editor-fold>
public final Address EmitLoadOfPointer(Address Ptr, 
                 /*const*/ org.clang.ast.PointerType /*P*/ PtrTy) {
  return EmitLoadOfPointer(Ptr, 
                 PtrTy, 
                 create_type$null$ptr());
}
public final Address EmitLoadOfPointer(Address Ptr, 
                 /*const*/ org.clang.ast.PointerType /*P*/ PtrTy, 
                 type$ptr<AlignmentSource /*P*/> Source/*= null*/) {
  Value /*P*/ Addr = $this().Builder.CreateLoad(new Address(Ptr));
  return new Address(Addr, $this().getNaturalTypeAlignment(PtrTy.getPointeeType(), Source, 
          /*forPointeeType=*/ true));
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitLoadOfPointerLValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp", line = 1982,
 FQN="clang::CodeGen::CodeGenFunction::EmitLoadOfPointerLValue", NM="_ZN5clang7CodeGen15CodeGenFunction23EmitLoadOfPointerLValueENS0_7AddressEPKNS_11PointerTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction23EmitLoadOfPointerLValueENS0_7AddressEPKNS_11PointerTypeE")
//</editor-fold>
public final LValue EmitLoadOfPointerLValue(Address PtrAddr, 
                       /*const*/ org.clang.ast.PointerType /*P*/ PtrTy) {
  type$ptr<AlignmentSource> Source = create_type$null$ptr();
  Address Addr = $this().EmitLoadOfPointer(new Address(PtrAddr), PtrTy, $AddrOf(Source));
  return $this().MakeAddrLValue(new Address(Addr), PtrTy.getPointeeType(), Source.$star());
}


/// CreateTempAlloca - This creates a alloca and inserts it into the entry
/// block. The caller is responsible for setting an appropriate alignment on
/// the alloca.

/// CreateTempAlloca - This creates a alloca and inserts it into the entry
/// block.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::CreateTempAlloca">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp", line = 69,
 FQN="clang::CodeGen::CodeGenFunction::CreateTempAlloca", NM="_ZN5clang7CodeGen15CodeGenFunction16CreateTempAllocaEPN4llvm4TypeERKNS2_5TwineE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction16CreateTempAllocaEPN4llvm4TypeERKNS2_5TwineE")
//</editor-fold>
public final AllocaInst /*P*/ CreateTempAlloca(org.llvm.ir.Type /*P*/ Ty) {
  return CreateTempAlloca(Ty, 
                new Twine(/*KEEP_STR*/"tmp"));
}
public final AllocaInst /*P*/ CreateTempAlloca(org.llvm.ir.Type /*P*/ Ty, 
                final /*const*/ Twine /*&*/ Name/*= "tmp"*/) {
  return /*NEW_EXPR [UnaryInstruction::new]*/UnaryInstruction.$new_UnaryInstruction((type$ptr<?> New$Mem)->{
      return new AllocaInst(Ty, (Value /*P*/ )null, Name, $this().AllocaInsertPt.$T$P());
   });
}


/// CreateTempAlloca - This creates a alloca and inserts it into the entry
/// block.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::CreateTempAlloca">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp", line = 60,
 FQN="clang::CodeGen::CodeGenFunction::CreateTempAlloca", NM="_ZN5clang7CodeGen15CodeGenFunction16CreateTempAllocaEPN4llvm4TypeENS_9CharUnitsERKNS2_5TwineE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction16CreateTempAllocaEPN4llvm4TypeENS_9CharUnitsERKNS2_5TwineE")
//</editor-fold>
public final Address CreateTempAlloca(org.llvm.ir.Type /*P*/ Ty, CharUnits Align) {
  return CreateTempAlloca(Ty, Align, 
                new Twine(/*KEEP_STR*/"tmp"));
}
public final Address CreateTempAlloca(org.llvm.ir.Type /*P*/ Ty, CharUnits Align, 
                final /*const*/ Twine /*&*/ Name/*= "tmp"*/) {
  AllocaInst /*P*/ Alloca = $this().CreateTempAlloca(Ty, Name);
  Alloca.setAlignment($long2uint(Align.getQuantity()));
  return new Address(Alloca, new CharUnits(Align));
}


/// CreateDefaultAlignedTempAlloca - This creates an alloca with the
/// default ABI alignment of the given LLVM type.
///
/// IMPORTANT NOTE: This is *not* generally the right alignment for
/// any given AST type that happens to have been lowered to the
/// given IR type.  This should only ever be used for function-local,
/// IR-driven manipulations like saving and restoring a value.  Do
/// not hand this address off to arbitrary IRGen routines, and especially
/// do not pass it as an argument to a function that might expect a
/// properly ABI-aligned value.

/// CreateDefaultAlignTempAlloca - This creates an alloca with the
/// default alignment of the corresponding LLVM type, which is *not*
/// guaranteed to be related in any way to the expected alignment of
/// an AST type that might have been lowered to Ty.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::CreateDefaultAlignTempAlloca">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp", line = 78,
 FQN="clang::CodeGen::CodeGenFunction::CreateDefaultAlignTempAlloca", NM="_ZN5clang7CodeGen15CodeGenFunction28CreateDefaultAlignTempAllocaEPN4llvm4TypeERKNS2_5TwineE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction28CreateDefaultAlignTempAllocaEPN4llvm4TypeERKNS2_5TwineE")
//</editor-fold>
public final Address CreateDefaultAlignTempAlloca(org.llvm.ir.Type /*P*/ Ty) {
  return CreateDefaultAlignTempAlloca(Ty, 
                            new Twine(/*KEEP_STR*/"tmp"));
}
public final Address CreateDefaultAlignTempAlloca(org.llvm.ir.Type /*P*/ Ty, 
                            final /*const*/ Twine /*&*/ Name/*= "tmp"*/) {
  CharUnits Align = CharUnits.fromQuantity($uint2long($this().CGM.getDataLayout().getABITypeAlignment(Ty)));
  return $this().CreateTempAlloca(Ty, new CharUnits(Align), Name);
}


/// InitTempAlloca - Provide an initial value for the given alloca which
/// will be observable at all locations in the function.
///
/// The address should be something that was returned from one of
/// the CreateTempAlloca or CreateMemTemp routines, and the
/// initializer must be valid in the entry block (i.e. it must
/// either be a constant or an argument value).
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::InitTempAlloca">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp", line = 85,
 FQN="clang::CodeGen::CodeGenFunction::InitTempAlloca", NM="_ZN5clang7CodeGen15CodeGenFunction14InitTempAllocaENS0_7AddressEPN4llvm5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction14InitTempAllocaENS0_7AddressEPN4llvm5ValueE")
//</editor-fold>
public final void InitTempAlloca(Address Var, Value /*P*/ Init) {
  assert (isa_AllocaInst(Var.getPointer()));
  StoreInst /*P*/ Store = /*NEW_EXPR [StoreInst::new]*/StoreInst.$new_StoreInst((type$ptr<?> New$Mem)->{
      return new StoreInst(Init, Var.getPointer());
   });
  Store.setAlignment($long2uint(Var.getAlignment().getQuantity()));
  BasicBlock /*P*/ Block = $this().AllocaInsertPt.$arrow_AssertingVH().getParent();
  Block.getInstList().insertAfter($this().AllocaInsertPt.$arrow_AssertingVH().getIterator(), Store);
}


/// CreateIRTemp - Create a temporary IR object of the given type, with
/// appropriate alignment. This routine should only be used when an temporary
/// value needs to be stored into an alloca (for example, to avoid explicit
/// PHI construction), but the type is the IR type, not the type appropriate
/// for storing in memory.
///
/// That is, this is exactly equivalent to CreateMemTemp, but calling
/// ConvertType instead of ConvertTypeForMem.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::CreateIRTemp">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp", line = 93,
 FQN="clang::CodeGen::CodeGenFunction::CreateIRTemp", NM="_ZN5clang7CodeGen15CodeGenFunction12CreateIRTempENS_8QualTypeERKN4llvm5TwineE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction12CreateIRTempENS_8QualTypeERKN4llvm5TwineE")
//</editor-fold>
public final Address CreateIRTemp(QualType Ty) {
  return CreateIRTemp(Ty, new Twine(/*KEEP_STR*/"tmp"));
}
public final Address CreateIRTemp(QualType Ty, final /*const*/ Twine /*&*/ Name/*= "tmp"*/) {
  CharUnits Align = $this().getContext().getTypeAlignInChars(new QualType(Ty));
  return $this().CreateTempAlloca($this().ConvertType(new QualType(Ty)), new CharUnits(Align), Name);
}


/// CreateMemTemp - Create a temporary memory object of the given type, with
/// appropriate alignment.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::CreateMemTemp">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp", line = 98,
 FQN="clang::CodeGen::CodeGenFunction::CreateMemTemp", NM="_ZN5clang7CodeGen15CodeGenFunction13CreateMemTempENS_8QualTypeERKN4llvm5TwineE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction13CreateMemTempENS_8QualTypeERKN4llvm5TwineE")
//</editor-fold>
public final Address CreateMemTemp(QualType Ty) {
  return CreateMemTemp(Ty, new Twine(/*KEEP_STR*/"tmp"));
}
public final Address CreateMemTemp(QualType Ty, final /*const*/ Twine /*&*/ Name/*= "tmp"*/) {
  // FIXME: Should we prefer the preferred type alignment here?
  return $this().CreateMemTemp(new QualType(Ty), $this().getContext().getTypeAlignInChars(new QualType(Ty)), Name);
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::CreateMemTemp">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp", line = 103,
 FQN="clang::CodeGen::CodeGenFunction::CreateMemTemp", NM="_ZN5clang7CodeGen15CodeGenFunction13CreateMemTempENS_8QualTypeENS_9CharUnitsERKN4llvm5TwineE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction13CreateMemTempENS_8QualTypeENS_9CharUnitsERKN4llvm5TwineE")
//</editor-fold>
public final Address CreateMemTemp(QualType Ty, CharUnits Align) {
  return CreateMemTemp(Ty, Align, 
             new Twine(/*KEEP_STR*/"tmp"));
}
public final Address CreateMemTemp(QualType Ty, CharUnits Align, 
             final /*const*/ Twine /*&*/ Name/*= "tmp"*/) {
  return $this().CreateTempAlloca($this().ConvertTypeForMem(new QualType(Ty)), new CharUnits(Align), Name);
}


/// Emit a cast to void* in the appropriate address space.

//===--------------------------------------------------------------------===//
//                        Miscellaneous Helper Methods
//===--------------------------------------------------------------------===//
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitCastToVoidPtr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp", line = 46,
 FQN="clang::CodeGen::CodeGenFunction::EmitCastToVoidPtr", NM="_ZN5clang7CodeGen15CodeGenFunction17EmitCastToVoidPtrEPN4llvm5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction17EmitCastToVoidPtrEPN4llvm5ValueE")
//</editor-fold>
public final Value /*P*/ EmitCastToVoidPtr(Value /*P*/ value) {
  /*uint*/int addressSpace = cast_PointerType(value.getType()).getAddressSpace();
  
  org.llvm.ir.PointerType /*P*/ destType = Unnamed_field9.Int8PtrTy;
  if ((addressSpace != 0)) {
    destType = org.llvm.ir.Type.getInt8PtrTy($this().getLLVMContext(), addressSpace);
  }
  if (value.getType() == destType) {
    return value;
  }
  return $this().Builder.CreateBitCast(value, destType);
}


/// EvaluateExprAsBool - Perform the usual unary conversions on the specified
/// expression and compare the result against zero, returning an Int1Ty value.

/// EvaluateExprAsBool - Perform the usual unary conversions on the specified
/// expression and compare the result against zero, returning an Int1Ty value.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EvaluateExprAsBool">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp", line = 110,
 FQN="clang::CodeGen::CodeGenFunction::EvaluateExprAsBool", NM="_ZN5clang7CodeGen15CodeGenFunction18EvaluateExprAsBoolEPKNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction18EvaluateExprAsBoolEPKNS_4ExprE")
//</editor-fold>
public final Value /*P*/ EvaluateExprAsBool(/*const*/ Expr /*P*/ E) {
  $this().PGO.setCurrentStmt(E);
  {
    /*const*/ MemberPointerType /*P*/ MPT = E.getType().$arrow().getAs(MemberPointerType.class);
    if ((MPT != null)) {
      Value /*P*/ MemPtr = $this().EmitScalarExpr(E);
      return $this().CGM.getCXXABI().EmitMemberPointerIsNotNull(/*Deref*/$this(), MemPtr, MPT);
    }
  }
  
  QualType BoolTy = $this().getContext().BoolTy.$QualType();
  SourceLocation Loc = E.getExprLoc();
  if (!E.getType().$arrow().isAnyComplexType()) {
    return $this().EmitScalarConversion($this().EmitScalarExpr(E), E.getType(), new QualType(BoolTy), new SourceLocation(Loc));
  }
  
  return $this().EmitComplexToScalarConversion($this().EmitComplexExpr(E), E.getType(), new QualType(BoolTy), 
      new SourceLocation(Loc));
}


/// EmitIgnoredExpr - Emit an expression in a context which ignores the result.

/// EmitIgnoredExpr - Emit code to compute the specified expression,
/// ignoring the result.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitIgnoredExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp", line = 128,
 FQN="clang::CodeGen::CodeGenFunction::EmitIgnoredExpr", NM="_ZN5clang7CodeGen15CodeGenFunction15EmitIgnoredExprEPKNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction15EmitIgnoredExprEPKNS_4ExprE")
//</editor-fold>
public final void EmitIgnoredExpr(/*const*/ Expr /*P*/ E) {
  if (E.isRValue()) {
    /*J:(void)*/$this().EmitAnyExpr(E, AggValueSlot.ignored(), true);
    /*JAVA:return*/return;
  }
  
  // Just emit it as an l-value and drop the result.
  $this().EmitLValue(E);
}


/// EmitAnyExpr - Emit code to compute the specified expression which can have
/// any type.  The result is returned as an RValue struct.  If this is an
/// aggregate expression, the aggloc/agglocvolatile arguments indicate where
/// the result should be returned.
///
/// \param ignoreResult True if the resulting value isn't used.

/// EmitAnyExpr - Emit code to compute the specified expression which
/// can have any type.  The result is returned as an RValue struct.
/// If this is an aggregate expression, AggSlot indicates where the
/// result should be returned.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitAnyExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp", line = 140,
 FQN="clang::CodeGen::CodeGenFunction::EmitAnyExpr", NM="_ZN5clang7CodeGen15CodeGenFunction11EmitAnyExprEPKNS_4ExprENS0_12AggValueSlotEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction11EmitAnyExprEPKNS_4ExprENS0_12AggValueSlotEb")
//</editor-fold>
public final RValue EmitAnyExpr(/*const*/ Expr /*P*/ E) {
  return EmitAnyExpr(E, 
           AggValueSlot.ignored(), 
           false);
}
public final RValue EmitAnyExpr(/*const*/ Expr /*P*/ E, 
           AggValueSlot aggSlot/*= AggValueSlot::ignored()*/) {
  return EmitAnyExpr(E, 
           aggSlot, 
           false);
}
public final RValue EmitAnyExpr(/*const*/ Expr /*P*/ E, 
           AggValueSlot aggSlot/*= AggValueSlot::ignored()*/, 
           boolean ignoreResult/*= false*/) {
  switch (CodeGenFunction.getEvaluationKind(E.getType())) {
   case TEK_Scalar:
    return RValue.get($this().EmitScalarExpr(E, ignoreResult));
   case TEK_Complex:
    return RValue.getComplex($this().EmitComplexExpr(E, ignoreResult, ignoreResult));
   case TEK_Aggregate:
    if (!ignoreResult && aggSlot.isIgnored()) {
      aggSlot.$assignMove($this().CreateAggTemp(E.getType(), new Twine(/*KEEP_STR*/"agg-temp")));
    }
    $this().EmitAggExpr(E, new AggValueSlot(aggSlot));
    return aggSlot.asRValue();
  }
  throw new llvm_unreachable("bad evaluation kind");
}


/// EmitAnyExprToTemp - Similary to EmitAnyExpr(), however, the result will
/// always be accessible even if no aggregate location is provided.

/// EmitAnyExprToTemp - Similary to EmitAnyExpr(), however, the result will
/// always be accessible even if no aggregate location is provided.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitAnyExprToTemp">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp", line = 159,
 FQN="clang::CodeGen::CodeGenFunction::EmitAnyExprToTemp", NM="_ZN5clang7CodeGen15CodeGenFunction17EmitAnyExprToTempEPKNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction17EmitAnyExprToTempEPKNS_4ExprE")
//</editor-fold>
public final RValue EmitAnyExprToTemp(/*const*/ Expr /*P*/ E) {
  AggValueSlot AggSlot = AggValueSlot.ignored();
  if (CodeGenFunction.hasAggregateEvaluationKind(E.getType())) {
    AggSlot.$assignMove($this().CreateAggTemp(E.getType(), new Twine(/*KEEP_STR*/"agg.tmp")));
  }
  return $this().EmitAnyExpr(E, new AggValueSlot(AggSlot));
}


/// EmitAnyExprToMem - Emits the code necessary to evaluate an
/// arbitrary expression into the given memory location.

/// EmitAnyExprToMem - Evaluate an expression into a given memory
/// location.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitAnyExprToMem">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp", line = 169,
 FQN="clang::CodeGen::CodeGenFunction::EmitAnyExprToMem", NM="_ZN5clang7CodeGen15CodeGenFunction16EmitAnyExprToMemEPKNS_4ExprENS0_7AddressENS_10QualifiersEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction16EmitAnyExprToMemEPKNS_4ExprENS0_7AddressENS_10QualifiersEb")
//</editor-fold>
public final void EmitAnyExprToMem(/*const*/ Expr /*P*/ E, 
                Address Location, 
                Qualifiers Quals, 
                boolean IsInit) {
  // FIXME: This function should take an LValue as an argument.
  switch (CodeGenFunction.getEvaluationKind(E.getType())) {
   case TEK_Complex:
    $this().EmitComplexExprIntoLValue(E, $this().MakeAddrLValue(new Address(Location), E.getType()), 
        /*isInit*/ false);
    return;
   case TEK_Aggregate:
    {
      $this().EmitAggExpr(E, AggValueSlot.forAddr(new Address(Location), new Qualifiers(Quals), 
              AggValueSlot.IsDestructed_t.valueOf(IsInit?1:0), 
              AggValueSlot.NeedsGCBarriers_t.DoesNotNeedGCBarriers, 
              AggValueSlot.IsAliased_t.valueOf(IsInit?0:1)));
      return;
    }
   case TEK_Scalar:
    {
      RValue RV = RValue.get($this().EmitScalarExpr(E, /*Ignore*/ false));
      LValue LV = $this().MakeAddrLValue(new Address(Location), E.getType());
      $this().EmitStoreThroughLValue(new RValue(RV), new LValue(LV));
      return;
    }
  }
  throw new llvm_unreachable("bad evaluation kind");
}


/// getAccessedFieldNo - Given an encoded value and a result number, return
/// the input field number being accessed.

/// getAccessedFieldNo - Given an encoded value and a result number, return the
/// input field number being accessed.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::getAccessedFieldNo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp", line = 507,
 FQN="clang::CodeGen::CodeGenFunction::getAccessedFieldNo", NM="_ZN5clang7CodeGen15CodeGenFunction18getAccessedFieldNoEjPKN4llvm8ConstantE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction18getAccessedFieldNoEjPKN4llvm8ConstantE")
//</editor-fold>
public static /*uint*/int getAccessedFieldNo(/*uint*/int Idx, 
                  /*const*/ Constant /*P*/ Elts) {
  return $ulong2uint(cast_ConstantInt(Elts.getAggregateElement(Idx)).
      getZExtValue());
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitCXXUuidofExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp", line = 3892,
 FQN="clang::CodeGen::CodeGenFunction::EmitCXXUuidofExpr", NM="_ZN5clang7CodeGen15CodeGenFunction17EmitCXXUuidofExprEPKNS_13CXXUuidofExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction17EmitCXXUuidofExprEPKNS_13CXXUuidofExprE")
//</editor-fold>
public final Address EmitCXXUuidofExpr(/*const*/ CXXUuidofExpr /*P*/ E) {
  return $this().Builder.CreateElementBitCast(new Address(JD$Move.INSTANCE, $this().CGM.GetAddrOfUuidDescriptor(E)), 
      $this().ConvertType(E.getType()));
}


/// \brief Whether any type-checking sanitizers are enabled. If \c false,
/// calls to EmitTypeCheck can be skipped.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::sanitizePerformTypeCheck">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp", line = 525,
 FQN="clang::CodeGen::CodeGenFunction::sanitizePerformTypeCheck", NM="_ZNK5clang7CodeGen15CodeGenFunction24sanitizePerformTypeCheckEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZNK5clang7CodeGen15CodeGenFunction24sanitizePerformTypeCheckEv")
//</editor-fold>
public final boolean sanitizePerformTypeCheck() /*const*/ {
  return $this().SanOpts.has(SanitizerKind.Null)
     || $this().SanOpts.has(SanitizerKind.Alignment)
     || $this().SanOpts.has(SanitizerKind.ObjectSize)
     || $this().SanOpts.has(SanitizerKind.Vptr);
}


/// \brief Emit a check that \p V is the address of storage of the
/// appropriate size and alignment for an object of type \p Type.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitTypeCheck">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp", line = 532,
 FQN="clang::CodeGen::CodeGenFunction::EmitTypeCheck", NM="_ZN5clang7CodeGen15CodeGenFunction13EmitTypeCheckENS1_13TypeCheckKindENS_14SourceLocationEPN4llvm5ValueENS_8QualTypeENS_9CharUnitsEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction13EmitTypeCheckENS1_13TypeCheckKindENS_14SourceLocationEPN4llvm5ValueENS_8QualTypeENS_9CharUnitsEb")
//</editor-fold>
public final void EmitTypeCheck(TypeCheckKind TCK, SourceLocation Loc, 
             Value /*P*/ Ptr, QualType Ty) {
  EmitTypeCheck(TCK, Loc, 
             Ptr, Ty, 
             CharUnits.Zero(), false);
}
public final void EmitTypeCheck(TypeCheckKind TCK, SourceLocation Loc, 
             Value /*P*/ Ptr, QualType Ty, 
             CharUnits Alignment/*= CharUnits::Zero()*/) {
  EmitTypeCheck(TCK, Loc, 
             Ptr, Ty, 
             Alignment, false);
}
public final void EmitTypeCheck(TypeCheckKind TCK, SourceLocation Loc, 
             Value /*P*/ Ptr, QualType Ty, 
             CharUnits Alignment/*= CharUnits::Zero()*/, boolean SkipNullCheck/*= false*/) {
  SanitizerScope SanScope = null;
  try {
    if (!$this().sanitizePerformTypeCheck()) {
      return;
    }
    
    // Don't check pointers outside the default address space. The null check
    // isn't correct, the object-size check isn't supported by LLVM, and we can't
    // communicate the addresses to the runtime handler for the vptr check.
    if ((Ptr.getType().getPointerAddressSpace() != 0)) {
      return;
    }
    
    SanScope/*J*/= new SanitizerScope($this());
    
    SmallVector<std.pairPtrULong<Value /*P*/ >> Checks/*J*/= new SmallVector<std.pairPtrULong<Value /*P*/ >>(3, new std.pairPtrULong<Value /*P*/ >());
    BasicBlock /*P*/ Done = null;
    
    boolean AllowNullPointers = TCK == TypeCheckKind.TCK_DowncastPointer || TCK == TypeCheckKind.TCK_Upcast
       || TCK == TypeCheckKind.TCK_UpcastToVirtualBase;
    if (($this().SanOpts.has(SanitizerKind.Null) || AllowNullPointers)
       && !SkipNullCheck) {
      // The glvalue must not be an empty glvalue.
      Value /*P*/ IsNonNull = $this().Builder.CreateIsNotNull(Ptr);
      if (AllowNullPointers) {
        // When performing pointer casts, it's OK if the value is null.
        // Skip the remaining checks in that case.
        Done = $this().createBasicBlock(new Twine(/*KEEP_STR*/"null"));
        BasicBlock /*P*/ Rest = $this().createBasicBlock(new Twine(/*KEEP_STR*/"not.null"));
        $this().Builder.CreateCondBr(IsNonNull, Rest, Done);
        $this().EmitBlock(Rest);
      } else {
        Checks.push_back(std.make_pair_Ptr_ulong(IsNonNull, SanitizerKind.Null));
      }
    }
    if ($this().SanOpts.has(SanitizerKind.ObjectSize) && !Ty.$arrow().isIncompleteType()) {
      long/*uint64_t*/ Size = $this().getContext().getTypeSizeInChars(/*NO_COPY*/Ty).getQuantity();
      
      // The glvalue must refer to a large enough storage region.
      // FIXME: If Address Sanitizer is enabled, insert dynamic instrumentation
      //        to check this.
      // FIXME: Get object address space
      org.llvm.ir.Type /*P*/ Tys[/*2*/] = new org.llvm.ir.Type /*P*/  [/*2*/] {Unnamed_field8.IntPtrTy, Unnamed_field9.Int8PtrTy};
      Value /*P*/ F = $this().CGM.getIntrinsic(ID.objectsize, new ArrayRef<org.llvm.ir.Type /*P*/ >(Tys, true));
      Value /*P*/ Min = $this().Builder.getFalse();
      Value /*P*/ CastAddr = $this().Builder.CreateBitCast(Ptr, Unnamed_field9.Int8PtrTy);
      Value /*P*/ LargeEnough = $this().Builder.CreateICmpUGE($this().Builder.CreateCall_Value$P_ArrayRef$Value$P_Twine$C_MDNode$P(F, /*{ */new ArrayRef<Value /*P*/ >(new Value /*P*/ /*const*/ [/*2*/] {CastAddr, Min}, true)/* }*/), 
          ConstantInt.get(Unnamed_field8.IntPtrTy, Size));
      Checks.push_back(std.make_pair_Ptr_ulong(LargeEnough, SanitizerKind.ObjectSize));
    }
    
    long/*uint64_t*/ AlignVal = $int2ulong(0);
    if ($this().SanOpts.has(SanitizerKind.Alignment)) {
      AlignVal = Alignment.getQuantity();
      if (!Ty.$arrow().isIncompleteType() && !(AlignVal != 0)) {
        AlignVal = $this().getContext().getTypeAlignInChars(new QualType(Ty)).getQuantity();
      }
      
      // The glvalue must be suitably aligned.
      if ((AlignVal != 0)) {
        Value /*P*/ Align = $this().Builder.CreateAnd($this().Builder.CreatePtrToInt(Ptr, Unnamed_field8.IntPtrTy), 
            ConstantInt.get(Unnamed_field8.IntPtrTy, AlignVal - $int2ullong(1)));
        Value /*P*/ Aligned = $this().Builder.CreateICmpEQ(Align, ConstantInt.get(Unnamed_field8.IntPtrTy, $int2ulong(0)));
        Checks.push_back(std.make_pair_Ptr_ulong(Aligned, SanitizerKind.Alignment));
      }
    }
    if ($greater_uint(Checks.size(), 0)) {
      Constant /*P*/ StaticData[/*4*/] = new Constant /*P*/  [/*4*/] {
        $this().EmitCheckSourceLocation(new SourceLocation(Loc)), 
        $this().EmitCheckTypeDescriptor(new QualType(Ty)), 
        ConstantInt.get(Unnamed_field8.SizeTy, AlignVal), 
        ConstantInt.get(Int8Ty, TCK.getValue())
      };
      $this().EmitCheck(new ArrayRef<std.pairPtrULong<Value /*P*/ >>(Checks, false), new StringRef(/*KEEP_STR*/"type_mismatch"), new ArrayRef<Constant /*P*/ >(StaticData, true), new ArrayRef<Value /*P*/ >(Ptr, true));
    }
    
    // If possible, check that the vptr indicates that there is a subobject of
    // type Ty at offset zero within this object.
    //
    // C++11 [basic.life]p5,6:
    //   [For storage which does not refer to an object within its lifetime]
    //   The program has undefined behavior if:
    //    -- the [pointer or glvalue] is used to access a non-static data member
    //       or call a non-static member function
    CXXRecordDecl /*P*/ RD = Ty.$arrow().getAsCXXRecordDecl();
    if ($this().SanOpts.has(SanitizerKind.Vptr)
       && (TCK == TypeCheckKind.TCK_MemberAccess || TCK == TypeCheckKind.TCK_MemberCall
       || TCK == TypeCheckKind.TCK_DowncastPointer || TCK == TypeCheckKind.TCK_DowncastReference
       || TCK == TypeCheckKind.TCK_UpcastToVirtualBase)
       && (RD != null) && RD.hasDefinition() && RD.isDynamicClass()) {
      raw_svector_ostream Out = null;
      try {
        // Compute a hash of the mangled name of the type.
        //
        // FIXME: This is not guaranteed to be deterministic! Move to a
        //        fingerprinting mechanism once LLVM provides one. For the time
        //        being the implementation happens to be deterministic.
        SmallString/*<64>*/ MangledName/*J*/= new SmallString/*<64>*/(64);
        Out/*J*/= new raw_svector_ostream(MangledName);
        $this().CGM.getCXXABI().getMangleContext().mangleCXXRTTI(Ty.getUnqualifiedType(), 
            Out);
        
        // Blacklist based on the mangled type.
        if (!$this().CGM.getContext().getSanitizerBlacklist().isBlacklistedType(Out.str())) {
          hash_code TypeHash = HashingGlobals.hash_value(Out.str());
          
          // Load the vptr, and compute hash_16_bytes(TypeHash, vptr).
          Value /*P*/ Low = ConstantInt.get(Int64Ty, $uint2ulong(TypeHash.$uint()));
          org.llvm.ir.Type /*P*/ VPtrTy = org.llvm.ir.PointerType.get(Unnamed_field8.IntPtrTy, 0);
          Address VPtrAddr/*J*/= new Address($this().Builder.CreateBitCast(Ptr, VPtrTy), /*J:ToBase*/super.getPointerAlign());
          Value /*P*/ VPtrVal = $this().Builder.CreateLoad(new Address(VPtrAddr));
          Value /*P*/ High = $this().Builder.CreateZExt(VPtrVal, Int64Ty);
          
          Value /*P*/ Hash = CGExprStatics.emitHash16Bytes($this().Builder, Low, High);
          Hash = $this().Builder.CreateTrunc(Hash, Unnamed_field8.IntPtrTy);
          
          // Look the hash up in our cache.
          /*const*/int CacheSize = 128;
          org.llvm.ir.Type /*P*/ HashTable = org.llvm.ir.ArrayType.get(Unnamed_field8.IntPtrTy, $int2ulong(CacheSize));
          Value /*P*/ Cache = $this().CGM.CreateRuntimeVariable(HashTable, 
              new StringRef(/*KEEP_STR*/"__ubsan_vptr_type_cache"));
          Value /*P*/ Slot = $this().Builder.CreateAnd(Hash, 
              ConstantInt.get(Unnamed_field8.IntPtrTy, 
                  $int2ulong(CacheSize - 1)));
          Value /*P*/ Indices[/*2*/] = new Value /*P*/  [/*2*/] {$this().Builder.getInt32(0), Slot};
          Value /*P*/ CacheVal = $this().Builder.CreateAlignedLoad($this().Builder.CreateInBoundsGEP(Cache, new ArrayRef<Value /*P*/ >(Indices, true)), 
              /*J:ToBase*/super.getPointerAlign());
          
          // If the hash isn't in the cache, call a runtime handler to perform the
          // hard work of checking whether the vptr is for an object of the right
          // type. This will either fill in the cache and return, or produce a
          // diagnostic.
          Value /*P*/ EqualHash = $this().Builder.CreateICmpEQ(CacheVal, Hash);
          Constant /*P*/ StaticData[/*4*/] = new Constant /*P*/  [/*4*/] {
            $this().EmitCheckSourceLocation(new SourceLocation(Loc)), 
            $this().EmitCheckTypeDescriptor(new QualType(Ty)), 
            $this().CGM.GetAddrOfRTTIDescriptor(Ty.getUnqualifiedType()), 
            ConstantInt.get(Int8Ty, TCK.getValue())
          };
          Value /*P*/ DynamicData[/*2*/] = new Value /*P*/  [/*2*/] {Ptr, Hash};
          $this().EmitCheck(new ArrayRef<std.pairPtrULong<Value /*P*/ >>(std.make_pair_Ptr_ulong(EqualHash, SanitizerKind.Vptr), false), 
              new StringRef(/*KEEP_STR*/"dynamic_type_cache_miss"), new ArrayRef<Constant /*P*/ >(StaticData, true), new ArrayRef<Value /*P*/ >(DynamicData, true));
        }
      } finally {
        if (Out != null) { Out.$destroy(); }
      }
    }
    if ((Done != null)) {
      $this().Builder.CreateBr(Done);
      $this().EmitBlock(Done);
    }
  } finally {
    if (SanScope != null) { SanScope.$destroy(); }
  }
}


/// \brief Emit a check that \p Base points into an array object, which
/// we can access at index \p Index. \p Accessed should be \c false if we
/// this expression is used as an lvalue, for instance in "&Arr[Idx]".
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitBoundsCheck">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp", line = 743,
 FQN="clang::CodeGen::CodeGenFunction::EmitBoundsCheck", NM="_ZN5clang7CodeGen15CodeGenFunction15EmitBoundsCheckEPKNS_4ExprES4_PN4llvm5ValueENS_8QualTypeEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction15EmitBoundsCheckEPKNS_4ExprES4_PN4llvm5ValueENS_8QualTypeEb")
//</editor-fold>
public final void EmitBoundsCheck(/*const*/ Expr /*P*/ E, /*const*/ Expr /*P*/ Base, 
               Value /*P*/ Index, QualType IndexType, 
               boolean Accessed) {
  SanitizerScope SanScope = null;
  try {
    assert ($this().SanOpts.has(SanitizerKind.ArrayBounds)) : "should not be called unless adding bounds checks";
    SanScope/*J*/= new SanitizerScope($this());
    
    QualType IndexedType/*J*/= new QualType();
    Value /*P*/ Bound = CGExprStatics.getArrayIndexingBound(/*Deref*/$this(), Base, IndexedType);
    if (!(Bound != null)) {
      return;
    }
    
    boolean IndexSigned = IndexType.$arrow().isSignedIntegerOrEnumerationType();
    Value /*P*/ IndexVal = $this().Builder.CreateIntCast(Index, Unnamed_field8.SizeTy, IndexSigned);
    Value /*P*/ BoundVal = $this().Builder.CreateIntCast(Bound, Unnamed_field8.SizeTy, false);
    
    Constant /*P*/ StaticData[/*3*/] = new Constant /*P*/  [/*3*/] {
      $this().EmitCheckSourceLocation(E.getExprLoc()), 
      $this().EmitCheckTypeDescriptor(new QualType(IndexedType)), 
      $this().EmitCheckTypeDescriptor(new QualType(IndexType))
    };
    Value /*P*/ Check = Accessed ? $this().Builder.CreateICmpULT(IndexVal, BoundVal) : $this().Builder.CreateICmpULE(IndexVal, BoundVal);
    $this().EmitCheck(new ArrayRef<std.pairPtrULong<Value /*P*/ >>(std.make_pair_Ptr_ulong(Check, SanitizerKind.ArrayBounds), false), new StringRef(/*KEEP_STR*/"out_of_bounds"), 
        new ArrayRef<Constant /*P*/ >(StaticData, true), new ArrayRef<Value /*P*/ >(Index, true));
  } finally {
    if (SanScope != null) { SanScope.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitComplexPrePostIncDec">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp", line = 771,
 FQN="clang::CodeGen::CodeGenFunction::EmitComplexPrePostIncDec", NM="_ZN5clang7CodeGen15CodeGenFunction24EmitComplexPrePostIncDecEPKNS_13UnaryOperatorENS0_6LValueEbb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction24EmitComplexPrePostIncDecEPKNS_13UnaryOperatorENS0_6LValueEbb")
//</editor-fold>
public final std.pair<Value /*P*/ , Value /*P*/ > EmitComplexPrePostIncDec(/*const*/ UnaryOperator /*P*/ E, LValue LV, 
                        boolean isInc, boolean isPre) {
  std.pair<Value /*P*/ , Value /*P*/ > InVal = $this().EmitLoadOfComplex(new LValue(LV), E.getExprLoc());
  
  Value /*P*/ NextVal;
  if (isa_IntegerType(InVal.first.getType())) {
    long/*uint64_t*/ AmountVal = $int2ulong(isInc ? 1 : -1);
    NextVal = ConstantInt.get(InVal.first.getType(), AmountVal, true);
    
    // Add the inc/dec to the real part.
    NextVal = $this().Builder.CreateAdd(InVal.first, NextVal, new Twine(isInc ? $("inc") : $("dec")));
  } else {
    QualType ElemTy = E.getType().$arrow().getAs(ComplexType.class).getElementType();
    APFloat FVal/*J*/= new APFloat($this().getContext().getFloatTypeSemantics(new QualType(ElemTy)), $int2ulong(1));
    if (!isInc) {
      FVal.changeSign();
    }
    NextVal = ConstantFP.get($this().getLLVMContext(), FVal);
    
    // Add the inc/dec to the real part.
    NextVal = $this().Builder.CreateFAdd(InVal.first, NextVal, new Twine(isInc ? $("inc") : $("dec")));
  }
  
  std.pair<Value /*P*/ , Value /*P*/ > IncVal/*J*/= new std.pairPtrPtr<Value /*P*/ , Value /*P*/ >(JD$T$RR_T1$RR.INSTANCE, NextVal, InVal.second);
  
  // Store the updated result through the lvalue.
  $this().EmitStoreOfComplex(new std.pairPtrPtr<Value /*P*/ , Value /*P*/ >(IncVal), new LValue(LV), /*init*/ false);
  
  // If this is a postinc, return the value read from memory, otherwise use the
  // updated value.
  return new std.pairPtrPtr<Value /*P*/ , Value /*P*/ >(isPre ? IncVal : InVal);
}


//===--------------------------------------------------------------------===//
//                         LValue Expression Emission
//===--------------------------------------------------------------------===//

/// GetUndefRValue - Get an appropriate 'undef' rvalue for the given type.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::GetUndefRValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp", line = 903,
 FQN="clang::CodeGen::CodeGenFunction::GetUndefRValue", NM="_ZN5clang7CodeGen15CodeGenFunction14GetUndefRValueENS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction14GetUndefRValueENS_8QualTypeE")
//</editor-fold>
public final RValue GetUndefRValue(QualType Ty) {
  if (Ty.$arrow().isVoidType()) {
    return RValue.get((Value /*P*/ )null);
  }
  switch (CodeGenFunction.getEvaluationKind(new QualType(Ty))) {
   case TEK_Complex:
    {
      org.llvm.ir.Type /*P*/ EltTy = $this().ConvertType(Ty.$arrow().castAs(ComplexType.class).getElementType());
      Value /*P*/ U = UndefValue.get(EltTy);
      return RValue.getComplex(std.make_pair_Ptr_Ptr(U, U));
    }
   case TEK_Aggregate:
    {
      Address DestPtr = $this().CreateMemTemp(new QualType(Ty), new Twine(/*KEEP_STR*/"undef.agg.tmp"));
      return RValue.getAggregate(new Address(DestPtr));
    }
   case TEK_Scalar:
    return RValue.get(UndefValue.get($this().ConvertType(new QualType(Ty))));
  }
  throw new llvm_unreachable("bad evaluation kind");
}


/// EmitUnsupportedRValue - Emit a dummy r-value using the type of E
/// and issue an ErrorUnsupported style diagnostic (using the
/// provided Name).
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitUnsupportedRValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp", line = 929,
 FQN="clang::CodeGen::CodeGenFunction::EmitUnsupportedRValue", NM="_ZN5clang7CodeGen15CodeGenFunction21EmitUnsupportedRValueEPKNS_4ExprEPKc",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction21EmitUnsupportedRValueEPKNS_4ExprEPKc")
//</editor-fold>
public final RValue EmitUnsupportedRValue(/*const*/ Expr /*P*/ E, 
                     /*const*/char$ptr/*char P*/ Name) {
  $this().ErrorUnsupported(E, Name);
  return $this().GetUndefRValue(E.getType());
}


/// EmitUnsupportedLValue - Emit a dummy l-value using the type of E and issue
/// an ErrorUnsupported style diagnostic (using the provided Name).
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitUnsupportedLValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp", line = 935,
 FQN="clang::CodeGen::CodeGenFunction::EmitUnsupportedLValue", NM="_ZN5clang7CodeGen15CodeGenFunction21EmitUnsupportedLValueEPKNS_4ExprEPKc",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction21EmitUnsupportedLValueEPKNS_4ExprEPKc")
//</editor-fold>
public final LValue EmitUnsupportedLValue(/*const*/ Expr /*P*/ E, 
                     /*const*/char$ptr/*char P*/ Name) {
  $this().ErrorUnsupported(E, Name);
  org.llvm.ir.Type /*P*/ Ty = org.llvm.ir.PointerType.getUnqual($this().ConvertType(E.getType()));
  return $this().MakeAddrLValue(new Address(UndefValue.get(Ty), CharUnits.One()), 
      E.getType());
}


/// EmitLValue - Emit code to compute a designator that specifies the location
/// of the expression.
///
/// This can return one of two things: a simple address or a bitfield
/// reference.  In either case, the LLVM Value* in the LValue structure is
/// guaranteed to be an LLVM pointer type.
///
/// If this returns a bitfield reference, nothing about the pointee type of
/// the LLVM value is known: For example, it may not be a pointer to an
/// integer.
///
/// If this returns a normal address, and if the lvalue's C type is fixed
/// size, this method guarantees that the returned pointer type will point to
/// an LLVM type of the same size of the lvalue's type.  If the lvalue has a
/// variable length type, this is not possible.
///

/// EmitLValue - Emit code to compute a designator that specifies the location
/// of the expression.
///
/// This can return one of two things: a simple address or a bitfield reference.
/// In either case, the LLVM Value* in the LValue structure is guaranteed to be
/// an LLVM pointer type.
///
/// If this returns a bitfield reference, nothing about the pointee type of the
/// LLVM value is known: For example, it may not be a pointer to an integer.
///
/// If this returns a normal address, and if the lvalue's C type is fixed size,
/// this method guarantees that the returned pointer type will point to an LLVM
/// type of the same size of the lvalue's type.  If the lvalue has a variable
/// length type, this is not possible.
///
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitLValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp", line = 970,
 FQN="clang::CodeGen::CodeGenFunction::EmitLValue", NM="_ZN5clang7CodeGen15CodeGenFunction10EmitLValueEPKNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction10EmitLValueEPKNS_4ExprE")
//</editor-fold>
public final LValue EmitLValue(/*const*/ Expr /*P*/ E) {
  ApplyDebugLocation DL = null;
  try {
    DL/*J*/= new ApplyDebugLocation(/*Deref*/$this(), E);
    switch (E.getStmtClass()) {
     default:
      return $this().EmitUnsupportedLValue(E, $("l-value expression"));
     case ObjCPropertyRefExprClass:
      throw new llvm_unreachable("cannot emit a property reference directly");
     case ObjCSelectorExprClass:
      return $this().EmitObjCSelectorLValue(cast_ObjCSelectorExpr(E));
     case ObjCIsaExprClass:
      return $this().EmitObjCIsaExpr(cast_ObjCIsaExpr(E));
     case BinaryOperatorClass:
      return $this().EmitBinaryOperatorLValue(cast_BinaryOperator(E));
     case CompoundAssignOperatorClass:
      {
        QualType Ty = E.getType();
        {
          /*const*/ AtomicType /*P*/ AT = Ty.$arrow().getAs(AtomicType.class);
          if ((AT != null)) {
            Ty.$assignMove(AT.getValueType());
          }
        }
        if (!Ty.$arrow().isAnyComplexType()) {
          return $this().EmitCompoundAssignmentLValue(cast_CompoundAssignOperator(E));
        }
        return $this().EmitComplexCompoundAssignmentLValue(cast_CompoundAssignOperator(E));
      }
     case CallExprClass:
     case CXXMemberCallExprClass:
     case CXXOperatorCallExprClass:
     case UserDefinedLiteralClass:
      return $this().EmitCallExprLValue(cast_CallExpr(E));
     case VAArgExprClass:
      return $this().EmitVAArgExprLValue(cast_VAArgExpr(E));
     case DeclRefExprClass:
      return $this().EmitDeclRefLValue(cast_DeclRefExpr(E));
     case ParenExprClass:
      return $this().EmitLValue(cast_ParenExpr(E).getSubExpr$Const());
     case GenericSelectionExprClass:
      return $this().EmitLValue(cast_GenericSelectionExpr(E).getResultExpr$Const());
     case PredefinedExprClass:
      return $this().EmitPredefinedLValue(cast_PredefinedExpr(E));
     case StringLiteralClass:
      return $this().EmitStringLiteralLValue(cast_StringLiteral(E));
     case ObjCEncodeExprClass:
      return $this().EmitObjCEncodeExprLValue(cast_ObjCEncodeExpr(E));
     case PseudoObjectExprClass:
      return $this().EmitPseudoObjectLValue(cast_PseudoObjectExpr(E));
     case InitListExprClass:
      return $this().EmitInitListLValue(cast_InitListExpr(E));
     case CXXTemporaryObjectExprClass:
     case CXXConstructExprClass:
      return $this().EmitCXXConstructLValue(cast_CXXConstructExpr(E));
     case CXXBindTemporaryExprClass:
      return $this().EmitCXXBindTemporaryLValue(cast_CXXBindTemporaryExpr(E));
     case CXXUuidofExprClass:
      return $this().EmitCXXUuidofLValue(cast_CXXUuidofExpr(E));
     case LambdaExprClass:
      return $this().EmitLambdaLValue(cast_LambdaExpr(E));
     case ExprWithCleanupsClass:
      {
        RunCleanupsScope Scope = null;
        try {
          /*const*/ ExprWithCleanups /*P*/ cleanups = cast_ExprWithCleanups(E);
          $this().enterFullExpression(cleanups);
          Scope/*J*/= new RunCleanupsScope(/*Deref*/$this());
          return $this().EmitLValue(cleanups.getSubExpr$Const());
        } finally {
          if (Scope != null) { Scope.$destroy(); }
        }
      }
     case CXXDefaultArgExprClass:
      return $this().EmitLValue(cast_CXXDefaultArgExpr(E).getExpr$Const());
     case CXXDefaultInitExprClass:
      {
        CXXDefaultInitExprScope Scope = null;
        try {
          Scope/*J*/= new CXXDefaultInitExprScope(/*Deref*/$this());
          return $this().EmitLValue(cast_CXXDefaultInitExpr(E).getExpr$Const());
        } finally {
          if (Scope != null) { Scope.$destroy(); }
        }
      }
     case CXXTypeidExprClass:
      return $this().EmitCXXTypeidLValue(cast_CXXTypeidExpr(E));
     case ObjCMessageExprClass:
      return $this().EmitObjCMessageExprLValue(cast_ObjCMessageExpr(E));
     case ObjCIvarRefExprClass:
      return $this().EmitObjCIvarRefLValue(cast_ObjCIvarRefExpr(E));
     case StmtExprClass:
      return $this().EmitStmtExprLValue(cast_StmtExpr(E));
     case UnaryOperatorClass:
      return $this().EmitUnaryOpLValue(cast_UnaryOperator(E));
     case ArraySubscriptExprClass:
      return $this().EmitArraySubscriptExpr(cast_ArraySubscriptExpr(E));
     case OMPArraySectionExprClass:
      return $this().EmitOMPArraySectionExpr(cast_OMPArraySectionExpr(E));
     case ExtVectorElementExprClass:
      return $this().EmitExtVectorElementExpr(cast_ExtVectorElementExpr(E));
     case MemberExprClass:
      return $this().EmitMemberExpr(cast_MemberExpr(E));
     case CompoundLiteralExprClass:
      return $this().EmitCompoundLiteralLValue(cast_CompoundLiteralExpr(E));
     case ConditionalOperatorClass:
      return $this().EmitConditionalOperatorLValue(cast_ConditionalOperator(E));
     case BinaryConditionalOperatorClass:
      return $this().EmitConditionalOperatorLValue(cast_BinaryConditionalOperator(E));
     case ChooseExprClass:
      return $this().EmitLValue(cast_ChooseExpr(E).getChosenSubExpr());
     case OpaqueValueExprClass:
      return $this().EmitOpaqueValueLValue(cast_OpaqueValueExpr(E));
     case SubstNonTypeTemplateParmExprClass:
      return $this().EmitLValue(cast_SubstNonTypeTemplateParmExpr(E).getReplacement());
     case ImplicitCastExprClass:
     case CStyleCastExprClass:
     case CXXFunctionalCastExprClass:
     case CXXStaticCastExprClass:
     case CXXDynamicCastExprClass:
     case CXXReinterpretCastExprClass:
     case CXXConstCastExprClass:
     case ObjCBridgedCastExprClass:
      return $this().EmitCastLValue(cast_CastExpr(E));
     case MaterializeTemporaryExprClass:
      return $this().EmitMaterializeTemporaryExpr(cast_MaterializeTemporaryExpr(E));
    }
  } finally {
    if (DL != null) { DL.$destroy(); }
  }
}


/// \brief Same as EmitLValue but additionally we generate checking code to
/// guard against undefined behavior.  This is only suitable when we know
/// that the address will be used to access the object.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitCheckedLValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp", line = 943,
 FQN="clang::CodeGen::CodeGenFunction::EmitCheckedLValue", NM="_ZN5clang7CodeGen15CodeGenFunction17EmitCheckedLValueEPKNS_4ExprENS1_13TypeCheckKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction17EmitCheckedLValueEPKNS_4ExprENS1_13TypeCheckKindE")
//</editor-fold>
public final LValue EmitCheckedLValue(/*const*/ Expr /*P*/ E, TypeCheckKind TCK) {
  LValue LV/*J*/= new LValue();
  if ($this().SanOpts.has(SanitizerKind.ArrayBounds) && isa_ArraySubscriptExpr(E)) {
    LV.$assignMove($this().EmitArraySubscriptExpr(cast_ArraySubscriptExpr(E), /*Accessed*/ true));
  } else {
    LV.$assignMove($this().EmitLValue(E));
  }
  if (!isa_DeclRefExpr(E) && !LV.isBitField() && LV.isSimple()) {
    $this().EmitTypeCheck(TCK, E.getExprLoc(), LV.getPointer(), 
        E.getType(), LV.getAlignment());
  }
  return LV;
}


/// Given the address of a temporary variable, produce an r-value of
/// its type.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::convertTempToRValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp", line = 4156,
 FQN="clang::CodeGen::CodeGenFunction::convertTempToRValue", NM="_ZN5clang7CodeGen15CodeGenFunction19convertTempToRValueENS0_7AddressENS_8QualTypeENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction19convertTempToRValueENS0_7AddressENS_8QualTypeENS_14SourceLocationE")
//</editor-fold>
public final RValue convertTempToRValue(Address addr, 
                   QualType type, 
                   SourceLocation loc) {
  LValue lvalue = $this().MakeAddrLValue(new Address(addr), new QualType(type), AlignmentSource.Decl);
  switch (CodeGenFunction.getEvaluationKind(new QualType(type))) {
   case TEK_Complex:
    return RValue.getComplex($this().EmitLoadOfComplex(new LValue(lvalue), new SourceLocation(loc)));
   case TEK_Aggregate:
    return lvalue.asAggregateRValue();
   case TEK_Scalar:
    return RValue.get($this().EmitLoadOfScalar(new LValue(lvalue), new SourceLocation(loc)));
  }
  throw new llvm_unreachable("bad evaluation kind");
}


/// EmitToMemory - Change a scalar value from its value
/// representation to its in-memory representation.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitToMemory">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp", line = 1349,
 FQN="clang::CodeGen::CodeGenFunction::EmitToMemory", NM="_ZN5clang7CodeGen15CodeGenFunction12EmitToMemoryEPN4llvm5ValueENS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction12EmitToMemoryEPN4llvm5ValueENS_8QualTypeE")
//</editor-fold>
public final Value /*P*/ EmitToMemory(Value /*P*/ $Value, QualType Ty) {
  // Bool has a different representation in memory than in registers.
  if (CGExprStatics.hasBooleanRepresentation(new QualType(Ty))) {
    // This should really always be an i1, but sometimes it's already
    // an i8, and it's awkward to track those cases down.
    if ($Value.getType().isIntegerTy(1)) {
      return $this().Builder.CreateZExt($Value, $this().ConvertTypeForMem(new QualType(Ty)), new Twine(/*KEEP_STR*/"frombool"));
    }
    assert ($Value.getType().isIntegerTy($ulong2uint($this().getContext().getTypeSize(new QualType(Ty))))) : "wrong value rep of bool";
  }
  
  return $Value;
}


/// EmitFromMemory - Change a scalar value from its memory
/// representation to its value representation.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitFromMemory">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp", line = 1363,
 FQN="clang::CodeGen::CodeGenFunction::EmitFromMemory", NM="_ZN5clang7CodeGen15CodeGenFunction14EmitFromMemoryEPN4llvm5ValueENS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction14EmitFromMemoryEPN4llvm5ValueENS_8QualTypeE")
//</editor-fold>
public final Value /*P*/ EmitFromMemory(Value /*P*/ $Value, QualType Ty) {
  // Bool has a different representation in memory than in registers.
  if (CGExprStatics.hasBooleanRepresentation(new QualType(Ty))) {
    assert ($Value.getType().isIntegerTy($ulong2uint($this().getContext().getTypeSize(new QualType(Ty))))) : "wrong value rep of bool";
    return $this().Builder.CreateTrunc($Value, $this().Builder.getInt1Ty(), new Twine(/*KEEP_STR*/"tobool"));
  }
  
  return $Value;
}


/// EmitLoadOfScalar - Load a scalar value from an address, taking
/// care to appropriately convert from the memory representation to
/// the LLVM value representation.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitLoadOfScalar">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp", line = 1262,
 FQN="clang::CodeGen::CodeGenFunction::EmitLoadOfScalar", NM="_ZN5clang7CodeGen15CodeGenFunction16EmitLoadOfScalarENS0_7AddressEbNS_8QualTypeENS_14SourceLocationENS0_15AlignmentSourceEPN4llvm6MDNodeES3_yb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction16EmitLoadOfScalarENS0_7AddressEbNS_8QualTypeENS_14SourceLocationENS0_15AlignmentSourceEPN4llvm6MDNodeES3_yb")
//</editor-fold>
public final Value /*P*/ EmitLoadOfScalar(Address Addr, boolean Volatile, 
                QualType Ty, 
                SourceLocation Loc) {
  return EmitLoadOfScalar(Addr, Volatile, 
                Ty, 
                Loc, 
                AlignmentSource.Type, 
                (MDNode /*P*/ )null, 
                new QualType(), 
                $int2ulong(0), 
                false);
}
public final Value /*P*/ EmitLoadOfScalar(Address Addr, boolean Volatile, 
                QualType Ty, 
                SourceLocation Loc, 
                AlignmentSource AlignSource/*= AlignmentSource::Type*/) {
  return EmitLoadOfScalar(Addr, Volatile, 
                Ty, 
                Loc, 
                AlignSource, 
                (MDNode /*P*/ )null, 
                new QualType(), 
                $int2ulong(0), 
                false);
}
public final Value /*P*/ EmitLoadOfScalar(Address Addr, boolean Volatile, 
                QualType Ty, 
                SourceLocation Loc, 
                AlignmentSource AlignSource/*= AlignmentSource::Type*/, 
                MDNode /*P*/ TBAAInfo/*= null*/) {
  return EmitLoadOfScalar(Addr, Volatile, 
                Ty, 
                Loc, 
                AlignSource, 
                TBAAInfo, 
                new QualType(), 
                $int2ulong(0), 
                false);
}
public final Value /*P*/ EmitLoadOfScalar(Address Addr, boolean Volatile, 
                QualType Ty, 
                SourceLocation Loc, 
                AlignmentSource AlignSource/*= AlignmentSource::Type*/, 
                MDNode /*P*/ TBAAInfo/*= null*/, 
                QualType TBAABaseType/*= QualType()*/) {
  return EmitLoadOfScalar(Addr, Volatile, 
                Ty, 
                Loc, 
                AlignSource, 
                TBAAInfo, 
                TBAABaseType, 
                $int2ulong(0), 
                false);
}
public final Value /*P*/ EmitLoadOfScalar(Address Addr, boolean Volatile, 
                QualType Ty, 
                SourceLocation Loc, 
                AlignmentSource AlignSource/*= AlignmentSource::Type*/, 
                MDNode /*P*/ TBAAInfo/*= null*/, 
                QualType TBAABaseType/*= QualType()*/, 
                long/*uint64_t*/ TBAAOffset/*= 0*/) {
  return EmitLoadOfScalar(Addr, Volatile, 
                Ty, 
                Loc, 
                AlignSource, 
                TBAAInfo, 
                TBAABaseType, 
                TBAAOffset, 
                false);
}
public final Value /*P*/ EmitLoadOfScalar(Address Addr, boolean Volatile, 
                QualType Ty, 
                SourceLocation Loc, 
                AlignmentSource AlignSource/*= AlignmentSource::Type*/, 
                MDNode /*P*/ TBAAInfo/*= null*/, 
                QualType TBAABaseType/*= QualType()*/, 
                long/*uint64_t*/ TBAAOffset/*= 0*/, 
                boolean isNontemporal/*= false*/) {
  // For better performance, handle vector loads differently.
  if (Ty.$arrow().isVectorType()) {
    /*const*/ org.llvm.ir.Type /*P*/ EltTy = Addr.getElementType();
    
    /*const*/ org.llvm.ir.VectorType /*P*/ VTy = cast_VectorType(EltTy);
    
    // Handle vectors of size 3 like size 4 for better performance.
    if (VTy.getNumElements() == 3) {
      
      // Bitcast to vec4 type.
      org.llvm.ir.VectorType /*P*/ vec4Ty = org.llvm.ir.VectorType.get(VTy.getElementType(), 
          4);
      Address Cast = $this().Builder.CreateElementBitCast(new Address(Addr), vec4Ty, new Twine(/*KEEP_STR*/"castToVec4"));
      // Now load value.
      Value /*P*/ V = $this().Builder.CreateLoad(new Address(Cast), Volatile, new Twine(/*KEEP_STR*/"loadVec4"));
      
      // Shuffle vector to get vec3.
      V = $this().Builder.CreateShuffleVector(V, UndefValue.get(vec4Ty), 
          /*{ */new ArrayRefUInt(new /*const*//*uint*/int [/*3*/] {0, 1, 2})/* }*/, new Twine(/*KEEP_STR*/"extractVec"));
      return $this().EmitFromMemory(V, new QualType(Ty));
    }
  }
  
  // Atomic operations have to be done on integral types.
  LValue AtomicLValue = LValue.MakeAddr(new Address(Addr), new QualType(Ty), $this().getContext(), AlignSource, TBAAInfo);
  if (Ty.$arrow().isAtomicType() || $this().LValueIsSuitableForInlineAtomic(new LValue(AtomicLValue))) {
    return $this().EmitAtomicLoad(new LValue(AtomicLValue), new SourceLocation(Loc)).getScalarVal();
  }
  
  LoadInst /*P*/ Load = $this().Builder.CreateLoad(new Address(Addr), Volatile);
  if (isNontemporal) {
    MDNode /*P*/ Node = MDNode.get(Load.getContext(), new ArrayRef<Metadata /*P*/ >(ConstantAsMetadata.get($this().Builder.getInt32(1)), true));
    Load.setMetadata($this().CGM.getModule().getMDKindID(new StringRef(/*KEEP_STR*/"nontemporal")), Node);
  }
  if ((TBAAInfo != null)) {
    MDNode /*P*/ TBAAPath = $this().CGM.getTBAAStructTagInfo(new QualType(TBAABaseType), TBAAInfo, 
        TBAAOffset);
    if ((TBAAPath != null)) {
      $this().CGM.DecorateInstructionWithTBAA(Load, TBAAPath, 
          false/*ConvertTypeToTag*/);
    }
  }
  
  boolean NeedsBoolCheck = $this().SanOpts.has(SanitizerKind.Bool) && CGExprStatics.hasBooleanRepresentation(new QualType(Ty));
  boolean NeedsEnumCheck = $this().SanOpts.has(SanitizerKind.Enum) && (Ty.$arrow().getAs$EnumType() != null);
  if (NeedsBoolCheck || NeedsEnumCheck) {
    SanitizerScope SanScope = null;
    try {
      SanScope/*J*/= new SanitizerScope($this());
      APInt Min/*J*/= new APInt();
      APInt End/*J*/= new APInt();
      if (CGExprStatics.getRangeForType(/*Deref*/$this(), new QualType(Ty), Min, End, true)) {
        End.$preDec();
        Value /*P*/ Check;
        if (Min.$not()) {
          Check = $this().Builder.CreateICmpULE(Load, ConstantInt.get($this().getLLVMContext(), End));
        } else {
          Value /*P*/ Upper = $this().Builder.CreateICmpSLE(Load, ConstantInt.get($this().getLLVMContext(), End));
          Value /*P*/ Lower = $this().Builder.CreateICmpSGE(Load, ConstantInt.get($this().getLLVMContext(), Min));
          Check = $this().Builder.CreateAnd(Upper, Lower);
        }
        Constant /*P*/ StaticArgs[/*2*/] = new Constant /*P*/  [/*2*/] {
          $this().EmitCheckSourceLocation(new SourceLocation(Loc)), 
          $this().EmitCheckTypeDescriptor(new QualType(Ty))
        };
        long/*uint64_t*/ Kind = NeedsEnumCheck ? SanitizerKind.Enum : SanitizerKind.Bool;
        $this().EmitCheck(new ArrayRef<std.pairPtrULong<Value /*P*/ >>(std.make_pair_Ptr_ulong(Check, Kind), false), new StringRef(/*KEEP_STR*/"load_invalid_value"), new ArrayRef<Constant /*P*/ >(StaticArgs, true), 
            new ArrayRef<Value /*P*/ >($this().EmitCheckValue(Load), true));
      }
    } finally {
      if (SanScope != null) { SanScope.$destroy(); }
    }
  } else if ($2bits_uint2uint($this().CGM.getCodeGenOpts().OptimizationLevel) > 0) {
    {
      MDNode /*P*/ RangeInfo = $this().getRangeForLoadFromType(new QualType(Ty));
      if ((RangeInfo != null)) {
        Load.setMetadata(LLVMContext.Unnamed_enum.MD_range.getValue(), RangeInfo);
      }
    }
  }
  
  return $this().EmitFromMemory(Load, new QualType(Ty));
}


/// EmitLoadOfScalar - Load a scalar value from an address, taking
/// care to appropriately convert from the memory representation to
/// the LLVM value representation.  The l-value must be a simple
/// l-value.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitLoadOfScalar">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp", line = 1196,
 FQN="clang::CodeGen::CodeGenFunction::EmitLoadOfScalar", NM="_ZN5clang7CodeGen15CodeGenFunction16EmitLoadOfScalarENS0_6LValueENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction16EmitLoadOfScalarENS0_6LValueENS_14SourceLocationE")
//</editor-fold>
public final Value /*P*/ EmitLoadOfScalar(LValue lvalue, 
                SourceLocation Loc) {
  return $this().EmitLoadOfScalar(lvalue.getAddress(), lvalue.isVolatile(), 
      lvalue.getType(), new SourceLocation(Loc), lvalue.getAlignmentSource(), 
      lvalue.getTBAAInfo(), 
      lvalue.getTBAABaseType(), lvalue.getTBAAOffset(), 
      lvalue.isNontemporal());
}


/// EmitStoreOfScalar - Store a scalar value to an address, taking
/// care to appropriately convert from the memory representation to
/// the LLVM value representation.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitStoreOfScalar">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp", line = 1374,
 FQN="clang::CodeGen::CodeGenFunction::EmitStoreOfScalar", NM="_ZN5clang7CodeGen15CodeGenFunction17EmitStoreOfScalarEPN4llvm5ValueENS0_7AddressEbNS_8QualTypeENS0_15AlignmentSourceEPNS2_6MDNodeEbS6_yb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction17EmitStoreOfScalarEPN4llvm5ValueENS0_7AddressEbNS_8QualTypeENS0_15AlignmentSourceEPNS2_6MDNodeEbS6_yb")
//</editor-fold>
public final void EmitStoreOfScalar(Value /*P*/ $Value, Address Addr, 
                 boolean Volatile, QualType Ty) {
  EmitStoreOfScalar($Value, Addr, 
                 Volatile, Ty, 
                 AlignmentSource.Type, 
                 (MDNode /*P*/ )null, 
                 false, new QualType(), 
                 $int2ulong(0), 
                 false);
}
public final void EmitStoreOfScalar(Value /*P*/ $Value, Address Addr, 
                 boolean Volatile, QualType Ty, 
                 AlignmentSource AlignSource/*= AlignmentSource::Type*/) {
  EmitStoreOfScalar($Value, Addr, 
                 Volatile, Ty, 
                 AlignSource, 
                 (MDNode /*P*/ )null, 
                 false, new QualType(), 
                 $int2ulong(0), 
                 false);
}
public final void EmitStoreOfScalar(Value /*P*/ $Value, Address Addr, 
                 boolean Volatile, QualType Ty, 
                 AlignmentSource AlignSource/*= AlignmentSource::Type*/, 
                 MDNode /*P*/ TBAAInfo/*= null*/) {
  EmitStoreOfScalar($Value, Addr, 
                 Volatile, Ty, 
                 AlignSource, 
                 TBAAInfo, 
                 false, new QualType(), 
                 $int2ulong(0), 
                 false);
}
public final void EmitStoreOfScalar(Value /*P*/ $Value, Address Addr, 
                 boolean Volatile, QualType Ty, 
                 AlignmentSource AlignSource/*= AlignmentSource::Type*/, 
                 MDNode /*P*/ TBAAInfo/*= null*/, 
                 boolean isInit/*= false*/) {
  EmitStoreOfScalar($Value, Addr, 
                 Volatile, Ty, 
                 AlignSource, 
                 TBAAInfo, 
                 isInit, new QualType(), 
                 $int2ulong(0), 
                 false);
}
public final void EmitStoreOfScalar(Value /*P*/ $Value, Address Addr, 
                 boolean Volatile, QualType Ty, 
                 AlignmentSource AlignSource/*= AlignmentSource::Type*/, 
                 MDNode /*P*/ TBAAInfo/*= null*/, 
                 boolean isInit/*= false*/, QualType TBAABaseType/*= QualType()*/) {
  EmitStoreOfScalar($Value, Addr, 
                 Volatile, Ty, 
                 AlignSource, 
                 TBAAInfo, 
                 isInit, TBAABaseType, 
                 $int2ulong(0), 
                 false);
}
public final void EmitStoreOfScalar(Value /*P*/ $Value, Address Addr, 
                 boolean Volatile, QualType Ty, 
                 AlignmentSource AlignSource/*= AlignmentSource::Type*/, 
                 MDNode /*P*/ TBAAInfo/*= null*/, 
                 boolean isInit/*= false*/, QualType TBAABaseType/*= QualType()*/, 
                 long/*uint64_t*/ TBAAOffset/*= 0*/) {
  EmitStoreOfScalar($Value, Addr, 
                 Volatile, Ty, 
                 AlignSource, 
                 TBAAInfo, 
                 isInit, TBAABaseType, 
                 TBAAOffset, 
                 false);
}
public final void EmitStoreOfScalar(Value /*P*/ $Value, Address Addr, 
                 boolean Volatile, QualType Ty, 
                 AlignmentSource AlignSource/*= AlignmentSource::Type*/, 
                 MDNode /*P*/ TBAAInfo/*= null*/, 
                 boolean isInit/*= false*/, QualType TBAABaseType/*= QualType()*/, 
                 long/*uint64_t*/ TBAAOffset/*= 0*/, 
                 boolean isNontemporal/*= false*/) {
  
  // Handle vectors differently to get better performance.
  if (Ty.$arrow().isVectorType()) {
    org.llvm.ir.Type /*P*/ SrcTy = $Value.getType();
    org.llvm.ir.VectorType /*P*/ VecTy = cast_VectorType(SrcTy);
    // Handle vec3 special.
    if (VecTy.getNumElements() == 3) {
      // Our source is a vec3, do a shuffle vector to make it a vec4.
      Constant /*P*/ Mask[/*4*/] = new Constant /*P*/  [/*4*/] {
        $this().Builder.getInt32(0), $this().Builder.getInt32(1), 
        $this().Builder.getInt32(2), 
        UndefValue.get($this().Builder.getInt32Ty())};
      Value /*P*/ MaskV = ConstantVector.get(new ArrayRef<Constant /*P*/ >(Mask, true));
      $Value = $this().Builder.CreateShuffleVector($Value, 
          UndefValue.get(VecTy), 
          MaskV, new Twine(/*KEEP_STR*/"extractVec"));
      SrcTy = org.llvm.ir.VectorType.get(VecTy.getElementType(), 4);
    }
    if (Addr.getElementType() != SrcTy) {
      Addr.$assignMove($this().Builder.CreateElementBitCast(new Address(Addr), SrcTy, new Twine(/*KEEP_STR*/"storetmp")));
    }
  }
  
  $Value = $this().EmitToMemory($Value, new QualType(Ty));
  
  LValue AtomicLValue = LValue.MakeAddr(new Address(Addr), new QualType(Ty), $this().getContext(), AlignSource, TBAAInfo);
  if (Ty.$arrow().isAtomicType()
     || (!isInit && $this().LValueIsSuitableForInlineAtomic(new LValue(AtomicLValue)))) {
    $this().EmitAtomicStore(RValue.get($Value), new LValue(AtomicLValue), isInit);
    return;
  }
  
  StoreInst /*P*/ Store = $this().Builder.CreateStore($Value, new Address(Addr), Volatile);
  if (isNontemporal) {
    MDNode /*P*/ Node = MDNode.get(Store.getContext(), 
        new ArrayRef<Metadata /*P*/ >(ConstantAsMetadata.get($this().Builder.getInt32(1)), true));
    Store.setMetadata($this().CGM.getModule().getMDKindID(new StringRef(/*KEEP_STR*/"nontemporal")), Node);
  }
  if ((TBAAInfo != null)) {
    MDNode /*P*/ TBAAPath = $this().CGM.getTBAAStructTagInfo(new QualType(TBAABaseType), TBAAInfo, 
        TBAAOffset);
    if ((TBAAPath != null)) {
      $this().CGM.DecorateInstructionWithTBAA(Store, TBAAPath, 
          false/*ConvertTypeToTag*/);
    }
  }
}


/// EmitStoreOfScalar - Store a scalar value to an address, taking
/// care to appropriately convert from the memory representation to
/// the LLVM value representation.  The l-value must be a simple
/// l-value.  The isInit flag indicates whether this is an initialization.
/// If so, atomic qualifiers are ignored and the store is always non-atomic.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitStoreOfScalar">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp", line = 1429,
 FQN="clang::CodeGen::CodeGenFunction::EmitStoreOfScalar", NM="_ZN5clang7CodeGen15CodeGenFunction17EmitStoreOfScalarEPN4llvm5ValueENS0_6LValueEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction17EmitStoreOfScalarEPN4llvm5ValueENS0_6LValueEb")
//</editor-fold>
public final void EmitStoreOfScalar(Value /*P*/ value, LValue lvalue) {
  EmitStoreOfScalar(value, lvalue, 
                 false);
}
public final void EmitStoreOfScalar(Value /*P*/ value, LValue lvalue, 
                 boolean isInit/*= false*/) {
  $this().EmitStoreOfScalar(value, lvalue.getAddress(), lvalue.isVolatile(), 
      lvalue.getType(), lvalue.getAlignmentSource(), 
      lvalue.getTBAAInfo(), isInit, lvalue.getTBAABaseType(), 
      lvalue.getTBAAOffset(), lvalue.isNontemporal());
}


/// EmitLoadOfLValue - Given an expression that represents a value lvalue,
/// this method emits the address of the lvalue, then loads the result as an
/// rvalue, returning the rvalue.

/// EmitLoadOfLValue - Given an expression that represents a value lvalue, this
/// method emits the address of the lvalue, then loads the result as an rvalue,
/// returning the rvalue.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitLoadOfLValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp", line = 1440,
 FQN="clang::CodeGen::CodeGenFunction::EmitLoadOfLValue", NM="_ZN5clang7CodeGen15CodeGenFunction16EmitLoadOfLValueENS0_6LValueENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction16EmitLoadOfLValueENS0_6LValueENS_14SourceLocationE")
//</editor-fold>
public final RValue EmitLoadOfLValue(LValue LV, SourceLocation Loc) {
  if (LV.isObjCWeak()) {
    // load of a __weak object.
    Address AddrWeakObj = LV.getAddress();
    return RValue.get($this().CGM.getObjCRuntime().EmitObjCWeakRead(/*Deref*/$this(), 
            new Address(AddrWeakObj)));
  }
  if (LV.getQuals().getObjCLifetime() == Qualifiers.ObjCLifetime.OCL_Weak) {
    // In MRC mode, we do a load+autorelease.
    if (!$this().getLangOpts().ObjCAutoRefCount) {
      return RValue.get($this().EmitARCLoadWeak(LV.getAddress()));
    }
    
    // In ARC mode, we load retained and then consume the value.
    Value /*P*/ Object = $this().EmitARCLoadWeakRetained(LV.getAddress());
    Object = $this().EmitObjCConsumeObject(LV.getType(), Object);
    return RValue.get(Object);
  }
  if (LV.isSimple()) {
    assert (!LV.getType().$arrow().isFunctionType());
    
    // Everything needs a load.
    return RValue.get($this().EmitLoadOfScalar(new LValue(LV), new SourceLocation(Loc)));
  }
  if (LV.isVectorElt()) {
    LoadInst /*P*/ Load = $this().Builder.CreateLoad(LV.getVectorAddress(), 
        LV.isVolatileQualified());
    return RValue.get($this().Builder.CreateExtractElement(Load, LV.getVectorIdx(), 
            new Twine(/*KEEP_STR*/"vecext")));
  }
  
  // If this is a reference to a subset of the elements of a vector, either
  // shuffle the input or extract/insert them as appropriate.
  if (LV.isExtVectorElt()) {
    return $this().EmitLoadOfExtVectorElementLValue(new LValue(LV));
  }
  
  // Global Register variables always invoke intrinsics
  if (LV.isGlobalReg()) {
    return $this().EmitLoadOfGlobalRegLValue(new LValue(LV));
  }
  assert (LV.isBitField()) : "Unknown LValue type!";
  return $this().EmitLoadOfBitfieldLValue(new LValue(LV));
}


// If this is a reference to a subset of the elements of a vector, create an
// appropriate shufflevector.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitLoadOfExtVectorElementLValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp", line = 1517,
 FQN="clang::CodeGen::CodeGenFunction::EmitLoadOfExtVectorElementLValue", NM="_ZN5clang7CodeGen15CodeGenFunction32EmitLoadOfExtVectorElementLValueENS0_6LValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction32EmitLoadOfExtVectorElementLValueENS0_6LValueE")
//</editor-fold>
public final RValue EmitLoadOfExtVectorElementLValue(LValue LV) {
  Value /*P*/ Vec = $this().Builder.CreateLoad(LV.getExtVectorAddress(), 
      LV.isVolatileQualified());
  
  /*const*/ Constant /*P*/ Elts = LV.getExtVectorElts();
  
  // If the result of the expression is a non-vector type, we must be extracting
  // a single element.  Just codegen as an extractelement.
  /*const*/ org.clang.ast.VectorType /*P*/ ExprVT = LV.getType().$arrow().getAs(org.clang.ast.VectorType.class);
  if (!(ExprVT != null)) {
    /*uint*/int InIdx = getAccessedFieldNo(0, Elts);
    Value /*P*/ Elt = ConstantInt.get(Unnamed_field8.SizeTy, $uint2ulong(InIdx));
    return RValue.get($this().Builder.CreateExtractElement(Vec, Elt));
  }
  
  // Always use shuffle vector to try to retain the original program structure
  /*uint*/int NumResultElts = ExprVT.getNumElements();
  
  SmallVector<Constant /*P*/ > Mask/*J*/= new SmallVector<Constant /*P*/ >(4, (Constant /*P*/ )null);
  for (/*uint*/int i = 0; i != NumResultElts; ++i)  {
    Mask.push_back($this().Builder.getInt32(getAccessedFieldNo(i, Elts)));
  }
  
  Value /*P*/ MaskV = ConstantVector.get(new ArrayRef<Constant /*P*/ >(Mask, true));
  Vec = $this().Builder.CreateShuffleVector(Vec, UndefValue.get(Vec.getType()), 
      MaskV);
  return RValue.get(Vec);
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitLoadOfBitfieldLValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp", line = 1486,
 FQN="clang::CodeGen::CodeGenFunction::EmitLoadOfBitfieldLValue", NM="_ZN5clang7CodeGen15CodeGenFunction24EmitLoadOfBitfieldLValueENS0_6LValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction24EmitLoadOfBitfieldLValueENS0_6LValueE")
//</editor-fold>
public final RValue EmitLoadOfBitfieldLValue(LValue LV) {
  final /*const*/ CGBitFieldInfo /*&*/ Info = LV.getBitFieldInfo();
  
  // Get the output type.
  org.llvm.ir.Type /*P*/ ResLTy = $this().ConvertType(LV.getType());
  
  Address Ptr = LV.getBitFieldAddress();
  Value /*P*/ Val = $this().Builder.CreateLoad(new Address(Ptr), LV.isVolatileQualified(), new Twine(/*KEEP_STR*/"bf.load"));
  if (Info.IsSigned) {
    assert ($lesseq_uint(((/*static_cast*//*uint*/int)($16bits_uint2uint(Info.Offset) + $15bits_uint2uint(Info.Size))), Info.StorageSize));
    /*uint*/int HighBits = Info.StorageSize - $16bits_uint2uint(Info.Offset) - $15bits_uint2uint(Info.Size);
    if ((HighBits != 0)) {
      Val = $this().Builder.CreateShl(Val, $uint2ulong(HighBits), new Twine(/*KEEP_STR*/"bf.shl"));
    }
    if ((($16bits_uint2uint(Info.Offset) + HighBits) != 0)) {
      Val = $this().Builder.CreateAShr(Val, $uint2ulong($16bits_uint2uint(Info.Offset) + HighBits), new Twine(/*KEEP_STR*/"bf.ashr"));
    }
  } else {
    if (($16bits_uint2uint(Info.Offset) != 0)) {
      Val = $this().Builder.CreateLShr(Val, $uint2ulong($16bits_uint2uint(Info.Offset)), new Twine(/*KEEP_STR*/"bf.lshr"));
    }
    if ($less_uint(((/*static_cast*//*uint*/int)($16bits_uint2uint(Info.Offset))) + $15bits_uint2uint(Info.Size), Info.StorageSize)) {
      Val = $this().Builder.CreateAnd(Val, APInt.getLowBitsSet(Info.StorageSize, 
              $15bits_uint2uint(Info.Size)), 
          new Twine(/*KEEP_STR*/"bf.clear"));
    }
  }
  Val = $this().Builder.CreateIntCast(Val, ResLTy, Info.IsSigned, new Twine(/*KEEP_STR*/"bf.cast"));
  
  return RValue.get(Val);
}


/// @brief Load of global gamed gegisters are always calls to intrinsics.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitLoadOfGlobalRegLValue">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp", line = 1568,
 FQN="clang::CodeGen::CodeGenFunction::EmitLoadOfGlobalRegLValue", NM="_ZN5clang7CodeGen15CodeGenFunction25EmitLoadOfGlobalRegLValueENS0_6LValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction25EmitLoadOfGlobalRegLValueENS0_6LValueE")
//</editor-fold>
public final RValue EmitLoadOfGlobalRegLValue(LValue LV) {
  assert ((LV.getType().$arrow().isIntegerType() || LV.getType().$arrow().isPointerType())) : "Bad type for register variable";
  MDNode /*P*/ RegName = cast_MDNode(cast_MetadataAsValue(LV.getGlobalReg()).getMetadata());
  
  // We accept integer and pointer types only
  org.llvm.ir.Type /*P*/ OrigTy = $this().CGM.getTypes().ConvertType(LV.getType());
  org.llvm.ir.Type /*P*/ Ty = OrigTy;
  if (OrigTy.isPointerTy()) {
    Ty = $this().CGM.getTypes().getDataLayout().getIntPtrType(OrigTy);
  }
  org.llvm.ir.Type /*P*/ Types[/*1*/] = new org.llvm.ir.Type /*P*/  [/*1*/] {Ty};
  
  Value /*P*/ F = $this().CGM.getIntrinsic(ID.read_register, new ArrayRef<org.llvm.ir.Type /*P*/ >(Types, true));
  Value /*P*/ Call = $this().Builder.CreateCall_Value$P_ArrayRef$Value$P_Twine$C_MDNode$P(F, new ArrayRef<Value /*P*/ >(MetadataAsValue.get(Ty.getContext(), RegName), true));
  if (OrigTy.isPointerTy()) {
    Call = $this().Builder.CreateIntToPtr(Call, OrigTy);
  }
  return RValue.get(Call);
}


/// EmitStoreThroughLValue - Store the specified rvalue into the specified
/// lvalue, where both are guaranteed to the have the same type, and that type
/// is 'Ty'.

/// EmitStoreThroughLValue - Store the specified rvalue into the specified
/// lvalue, where both are guaranteed to the have the same type, and that type
/// is 'Ty'.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitStoreThroughLValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp", line = 1593,
 FQN="clang::CodeGen::CodeGenFunction::EmitStoreThroughLValue", NM="_ZN5clang7CodeGen15CodeGenFunction22EmitStoreThroughLValueENS0_6RValueENS0_6LValueEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction22EmitStoreThroughLValueENS0_6RValueENS0_6LValueEb")
//</editor-fold>
public final void EmitStoreThroughLValue(RValue Src, LValue Dst) {
  EmitStoreThroughLValue(Src, Dst, 
                      false);
}
public final void EmitStoreThroughLValue(RValue Src, LValue Dst, 
                      boolean isInit/*= false*/) {
  if (!Dst.isSimple()) {
    if (Dst.isVectorElt()) {
      // Read/modify/write the vector, inserting the new element.
      Value /*P*/ Vec = $this().Builder.CreateLoad(Dst.getVectorAddress(), 
          Dst.isVolatileQualified());
      Vec = $this().Builder.CreateInsertElement(Vec, Src.getScalarVal(), 
          Dst.getVectorIdx(), new Twine(/*KEEP_STR*/"vecins"));
      $this().Builder.CreateStore(Vec, Dst.getVectorAddress(), 
          Dst.isVolatileQualified());
      return;
    }
    
    // If this is an update of extended vector elements, insert them as
    // appropriate.
    if (Dst.isExtVectorElt()) {
      $this().EmitStoreThroughExtVectorComponentLValue(new RValue(Src), new LValue(Dst));
      /*JAVA:return*/return;
    }
    if (Dst.isGlobalReg()) {
      $this().EmitStoreThroughGlobalRegLValue(new RValue(Src), new LValue(Dst));
      /*JAVA:return*/return;
    }
    assert (Dst.isBitField()) : "Unknown LValue type";
    $this().EmitStoreThroughBitfieldLValue(new RValue(Src), new LValue(Dst));
    /*JAVA:return*/return;
  }
  {
    
    // There's special magic for assigning into an ARC-qualified l-value.
    Qualifiers.ObjCLifetime Lifetime = Dst.getQuals().getObjCLifetime();
    if ((Lifetime.getValue() != 0)) {
      switch (Lifetime) {
       case OCL_None:
        throw new llvm_unreachable("present but none");
       case OCL_ExplicitNone:
        // nothing special
        break;
       case OCL_Strong:
        $this().EmitARCStoreStrong(new LValue(Dst), Src.getScalarVal(), /*ignore*/ true);
        return;
       case OCL_Weak:
        $this().EmitARCStoreWeak(Dst.getAddress(), Src.getScalarVal(), /*ignore*/ true);
        return;
       case OCL_Autoreleasing:
        Src.$assignMove(RValue.get($this().EmitObjCExtendObjectLifetime(Dst.getType(), 
                    Src.getScalarVal())));
        // fall into the normal path
        break;
      }
    }
  }
  if (Dst.isObjCWeak() && !Dst.isNonGC()) {
    // load of a __weak object.
    Address LvalueDst = Dst.getAddress();
    Value /*P*/ src = Src.getScalarVal();
    $this().CGM.getObjCRuntime().EmitObjCWeakAssign(/*Deref*/$this(), src, new Address(LvalueDst));
    return;
  }
  if (Dst.isObjCStrong() && !Dst.isNonGC()) {
    // load of a __strong object.
    Address LvalueDst = Dst.getAddress();
    Value /*P*/ src = Src.getScalarVal();
    if (Dst.isObjCIvar()) {
      assert ((Dst.getBaseIvarExp() != null)) : "BaseIvarExp is NULL";
      org.llvm.ir.Type /*P*/ ResultType = Unnamed_field8.IntPtrTy;
      Address dst = $this().EmitPointerWithAlignment(Dst.getBaseIvarExp());
      Value /*P*/ RHS = dst.getPointer();
      RHS = $this().Builder.CreatePtrToInt(RHS, ResultType, new Twine(/*KEEP_STR*/"sub.ptr.rhs.cast"));
      Value /*P*/ LHS = $this().Builder.CreatePtrToInt(LvalueDst.getPointer(), ResultType, 
          new Twine(/*KEEP_STR*/"sub.ptr.lhs.cast"));
      Value /*P*/ BytesBetween = $this().Builder.CreateSub(LHS, RHS, new Twine(/*KEEP_STR*/"ivar.offset"));
      $this().CGM.getObjCRuntime().EmitObjCIvarAssign(/*Deref*/$this(), src, new Address(dst), 
          BytesBetween);
    } else if (Dst.isGlobalObjCRef()) {
      $this().CGM.getObjCRuntime().EmitObjCGlobalAssign(/*Deref*/$this(), src, new Address(LvalueDst), 
          Dst.isThreadLocalRef());
    } else {
      $this().CGM.getObjCRuntime().EmitObjCStrongCastAssign(/*Deref*/$this(), src, new Address(LvalueDst));
    }
    return;
  }
  assert (Src.isScalar()) : "Can't emit an agg store with this method";
  $this().EmitStoreOfScalar(Src.getScalarVal(), new LValue(Dst), isInit);
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitStoreThroughExtVectorComponentLValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp", line = 1749,
 FQN="clang::CodeGen::CodeGenFunction::EmitStoreThroughExtVectorComponentLValue", NM="_ZN5clang7CodeGen15CodeGenFunction40EmitStoreThroughExtVectorComponentLValueENS0_6RValueENS0_6LValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction40EmitStoreThroughExtVectorComponentLValueENS0_6RValueENS0_6LValueE")
//</editor-fold>
public final void EmitStoreThroughExtVectorComponentLValue(RValue Src, 
                                        LValue Dst) {
  // This access turns into a read/modify/write of the vector.  Load the input
  // value now.
  Value /*P*/ Vec = $this().Builder.CreateLoad(Dst.getExtVectorAddress(), 
      Dst.isVolatileQualified());
  /*const*/ Constant /*P*/ Elts = Dst.getExtVectorElts();
  
  Value /*P*/ SrcVal = Src.getScalarVal();
  {
    
    /*const*/ org.clang.ast.VectorType /*P*/ VTy = Dst.getType().$arrow().getAs(org.clang.ast.VectorType.class);
    if ((VTy != null)) {
      /*uint*/int NumSrcElts = VTy.getNumElements();
      /*uint*/int NumDstElts = Vec.getType().getVectorNumElements();
      if (NumDstElts == NumSrcElts) {
        // Use shuffle vector is the src and destination are the same number of
        // elements and restore the vector mask since it is on the side it will be
        // stored.
        SmallVector<Constant /*P*/ > Mask/*J*/= new SmallVector<Constant /*P*/ >(JD$UInt_T$C$R.INSTANCE, 4, NumDstElts, (Constant /*P*/ )null);
        for (/*uint*/int i = 0; i != NumSrcElts; ++i)  {
          Mask.$set(getAccessedFieldNo(i, Elts), $this().Builder.getInt32(i));
        }
        
        Value /*P*/ MaskV = ConstantVector.get(new ArrayRef<Constant /*P*/ >(Mask, true));
        Vec = $this().Builder.CreateShuffleVector(SrcVal, 
            UndefValue.get(Vec.getType()), 
            MaskV);
      } else if ($greater_uint(NumDstElts, NumSrcElts)) {
        // Extended the source vector to the same length and then shuffle it
        // into the destination.
        // FIXME: since we're shuffling with undef, can we just use the indices
        //        into that?  This could be simpler.
        SmallVector<Constant /*P*/ > ExtMask/*J*/= new SmallVector<Constant /*P*/ >(4, (Constant /*P*/ )null);
        for (/*uint*/int i = 0; i != NumSrcElts; ++i)  {
          ExtMask.push_back($this().Builder.getInt32(i));
        }
        ExtMask.resize(NumDstElts, UndefValue.get(Int32Ty));
        Value /*P*/ ExtMaskV = ConstantVector.get(new ArrayRef<Constant /*P*/ >(ExtMask, true));
        Value /*P*/ ExtSrcVal = $this().Builder.CreateShuffleVector(SrcVal, 
            UndefValue.get(SrcVal.getType()), 
            ExtMaskV);
        // build identity
        SmallVector<Constant /*P*/ > Mask/*J*/= new SmallVector<Constant /*P*/ >(4, (Constant /*P*/ )null);
        for (/*uint*/int i = 0; i != NumDstElts; ++i)  {
          Mask.push_back($this().Builder.getInt32(i));
        }
        
        // When the vector size is odd and .odd or .hi is used, the last element
        // of the Elts constant array will be one past the size of the vector.
        // Ignore the last element here, if it is greater than the mask size.
        if (getAccessedFieldNo(NumSrcElts - 1, Elts) == Mask.size()) {
          NumSrcElts--;
        }
        
        // modify when what gets shuffled in
        for (/*uint*/int i = 0; i != NumSrcElts; ++i)  {
          Mask.$set(getAccessedFieldNo(i, Elts), $this().Builder.getInt32(i + NumDstElts));
        }
        Value /*P*/ MaskV = ConstantVector.get(new ArrayRef<Constant /*P*/ >(Mask, true));
        Vec = $this().Builder.CreateShuffleVector(Vec, ExtSrcVal, MaskV);
      } else {
        // We should never shorten the vector
        throw new llvm_unreachable("unexpected shorten vector length");
      }
    } else {
      // If the Src is a scalar (not a vector) it must be updating one element.
      /*uint*/int InIdx = getAccessedFieldNo(0, Elts);
      Value /*P*/ Elt = ConstantInt.get(Unnamed_field8.SizeTy, $uint2ulong(InIdx));
      Vec = $this().Builder.CreateInsertElement(Vec, SrcVal, Elt);
    }
  }
  
  $this().Builder.CreateStore(Vec, Dst.getExtVectorAddress(), 
      Dst.isVolatileQualified());
}


/// @brief Store of global named registers are always calls to intrinsics.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitStoreThroughGlobalRegLValue">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp", line = 1820,
 FQN="clang::CodeGen::CodeGenFunction::EmitStoreThroughGlobalRegLValue", NM="_ZN5clang7CodeGen15CodeGenFunction31EmitStoreThroughGlobalRegLValueENS0_6RValueENS0_6LValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction31EmitStoreThroughGlobalRegLValueENS0_6RValueENS0_6LValueE")
//</editor-fold>
public final void EmitStoreThroughGlobalRegLValue(RValue Src, LValue Dst) {
  assert ((Dst.getType().$arrow().isIntegerType() || Dst.getType().$arrow().isPointerType())) : "Bad type for register variable";
  MDNode /*P*/ RegName = cast_MDNode(cast_MetadataAsValue(Dst.getGlobalReg()).getMetadata());
  assert ((RegName != null)) : "Register LValue is not metadata";
  
  // We accept integer and pointer types only
  org.llvm.ir.Type /*P*/ OrigTy = $this().CGM.getTypes().ConvertType(Dst.getType());
  org.llvm.ir.Type /*P*/ Ty = OrigTy;
  if (OrigTy.isPointerTy()) {
    Ty = $this().CGM.getTypes().getDataLayout().getIntPtrType(OrigTy);
  }
  org.llvm.ir.Type /*P*/ Types[/*1*/] = new org.llvm.ir.Type /*P*/  [/*1*/] {Ty};
  
  Value /*P*/ F = $this().CGM.getIntrinsic(ID.write_register, new ArrayRef<org.llvm.ir.Type /*P*/ >(Types, true));
  Value /*P*/ $Value = Src.getScalarVal();
  if (OrigTy.isPointerTy()) {
    $Value = $this().Builder.CreatePtrToInt($Value, Ty);
  }
  $this().Builder.CreateCall_Value$P_ArrayRef$Value$P_Twine$C_MDNode$P(F, /*{ */new ArrayRef<Value /*P*/ >(new Value /*P*/ /*const*/ [/*2*/] {MetadataAsValue.get(Ty.getContext(), RegName), $Value}, true)/* }*/);
}


/// EmitStoreThroughBitfieldLValue - Store Src into Dst with same constraints
/// as EmitStoreThroughLValue.
///
/// \param Result [out] - If non-null, this will be set to a Value* for the
/// bit-field contents after the store, appropriate for use as the result of
/// an assignment to the bit-field.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitStoreThroughBitfieldLValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp", line = 1682,
 FQN="clang::CodeGen::CodeGenFunction::EmitStoreThroughBitfieldLValue", NM="_ZN5clang7CodeGen15CodeGenFunction30EmitStoreThroughBitfieldLValueENS0_6RValueENS0_6LValueEPPN4llvm5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction30EmitStoreThroughBitfieldLValueENS0_6RValueENS0_6LValueEPPN4llvm5ValueE")
//</editor-fold>
public final void EmitStoreThroughBitfieldLValue(RValue Src, LValue Dst) {
  EmitStoreThroughBitfieldLValue(Src, Dst, 
                              (type$ptr<Value /*P*/ /*P*/>)null);
}
public final void EmitStoreThroughBitfieldLValue(RValue Src, LValue Dst, 
                              type$ptr<Value /*P*/ /*P*/> Result/*= null*/) {
  final /*const*/ CGBitFieldInfo /*&*/ Info = Dst.getBitFieldInfo();
  org.llvm.ir.Type /*P*/ ResLTy = $this().ConvertTypeForMem(Dst.getType());
  Address Ptr = Dst.getBitFieldAddress();
  
  // Get the source value, truncated to the width of the bit-field.
  Value /*P*/ SrcVal = Src.getScalarVal();
  
  // Cast the source to the storage type and shift it into place.
  SrcVal = $this().Builder.CreateIntCast(SrcVal, Ptr.getElementType(), 
      /*IsSigned=*/ false);
  Value /*P*/ MaskedVal = SrcVal;
  
  // See if there are other bits in the bitfield's storage we'll need to load
  // and mask together with source before storing.
  if (Info.StorageSize != $15bits_uint2uint(Info.Size)) {
    assert ($greater_uint(Info.StorageSize, $15bits_uint2uint(Info.Size))) : "Invalid bitfield size.";
    Value /*P*/ Val = $this().Builder.CreateLoad(new Address(Ptr), Dst.isVolatileQualified(), new Twine(/*KEEP_STR*/"bf.load"));
    
    // Mask the source value as needed.
    if (!CGExprStatics.hasBooleanRepresentation(Dst.getType())) {
      SrcVal = $this().Builder.CreateAnd(SrcVal, 
          APInt.getLowBitsSet(Info.StorageSize, 
              $15bits_uint2uint(Info.Size)), 
          new Twine(/*KEEP_STR*/"bf.value"));
    }
    MaskedVal = SrcVal;
    if (($16bits_uint2uint(Info.Offset) != 0)) {
      SrcVal = $this().Builder.CreateShl(SrcVal, $uint2ulong($16bits_uint2uint(Info.Offset)), new Twine(/*KEEP_STR*/"bf.shl"));
    }
    
    // Mask out the original value.
    Val = $this().Builder.CreateAnd(Val, 
        APInt.getBitsSet(Info.StorageSize, 
            $16bits_uint2uint(Info.Offset), 
            $16bits_uint2uint(Info.Offset) + $15bits_uint2uint(Info.Size)).$bitnot(), 
        new Twine(/*KEEP_STR*/"bf.clear"));
    
    // Or together the unchanged values and the source value.
    SrcVal = $this().Builder.CreateOr(Val, SrcVal, new Twine(/*KEEP_STR*/"bf.set"));
  } else {
    assert ($16bits_uint2uint(Info.Offset) == 0);
  }
  
  // Write the new value back out.
  $this().Builder.CreateStore(SrcVal, new Address(Ptr), Dst.isVolatileQualified());
  
  // Return the new value of the bit-field, if requested.
  if (Native.$bool(Result)) {
    Value /*P*/ ResultVal = MaskedVal;
    
    // Sign extend the value if needed.
    if (Info.IsSigned) {
      assert ($lesseq_uint($15bits_uint2uint(Info.Size), Info.StorageSize));
      /*uint*/int HighBits = Info.StorageSize - $15bits_uint2uint(Info.Size);
      if ((HighBits != 0)) {
        ResultVal = $this().Builder.CreateShl(ResultVal, $uint2ulong(HighBits), new Twine(/*KEEP_STR*/"bf.result.shl"));
        ResultVal = $this().Builder.CreateAShr(ResultVal, $uint2ulong(HighBits), new Twine(/*KEEP_STR*/"bf.result.ashr"));
      }
    }
    
    ResultVal = $this().Builder.CreateIntCast(ResultVal, ResLTy, Info.IsSigned, 
        new Twine(/*KEEP_STR*/"bf.result.cast"));
    Result.$set($this().EmitFromMemory(ResultVal, Dst.getType()));
  }
}


// Note: only available for agg return types
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitBinaryOperatorLValue">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp", line = 3811,
 FQN="clang::CodeGen::CodeGenFunction::EmitBinaryOperatorLValue", NM="_ZN5clang7CodeGen15CodeGenFunction24EmitBinaryOperatorLValueEPKNS_14BinaryOperatorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction24EmitBinaryOperatorLValueEPKNS_14BinaryOperatorE")
//</editor-fold>
public final LValue EmitBinaryOperatorLValue(/*const*/ org.clang.ast.BinaryOperator /*P*/ E) {
  // Comma expressions just emit their LHS then their RHS as an l-value.
  if (E.getOpcode() == BinaryOperatorKind.BO_Comma) {
    $this().EmitIgnoredExpr(E.getLHS());
    $this().EnsureInsertPoint();
    return $this().EmitLValue(E.getRHS());
  }
  if (E.getOpcode() == BinaryOperatorKind.BO_PtrMemD
     || E.getOpcode() == BinaryOperatorKind.BO_PtrMemI) {
    return $this().EmitPointerToDataMemberBinaryExpr(E);
  }
  assert (E.getOpcode() == BinaryOperatorKind.BO_Assign) : "unexpected binary l-value";
  
  // Note that in all of these cases, __block variables need the RHS
  // evaluated first just in case the variable gets moved by the RHS.
  switch (CodeGenFunction.getEvaluationKind(E.getType())) {
   case TEK_Scalar:
    {
      switch (E.getLHS().getType().getObjCLifetime()) {
       case OCL_Strong:
        return new LValue(JD$Move.INSTANCE, $this().EmitARCStoreStrong(E, /*ignored*/ false).first);
       case OCL_Autoreleasing:
        return new LValue(JD$Move.INSTANCE, $this().EmitARCStoreAutoreleasing(E).first);
       case OCL_None:
       case OCL_ExplicitNone:
       case OCL_Weak:
        
        // No reason to do any of these differently.
        break;
      }
      
      RValue RV = $this().EmitAnyExpr(E.getRHS());
      LValue LV = $this().EmitCheckedLValue(E.getLHS(), TypeCheckKind.TCK_Store);
      $this().EmitStoreThroughLValue(new RValue(RV), new LValue(LV));
      return LV;
    }
   case TEK_Complex:
    return $this().EmitComplexAssignmentLValue(E);
   case TEK_Aggregate:
    return $this().EmitAggExprToLValue(E);
  }
  throw new llvm_unreachable("bad evaluation kind");
}

// Note: only available for agg return types
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitCallExprLValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp", line = 3859,
 FQN="clang::CodeGen::CodeGenFunction::EmitCallExprLValue", NM="_ZN5clang7CodeGen15CodeGenFunction18EmitCallExprLValueEPKNS_8CallExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction18EmitCallExprLValueEPKNS_8CallExprE")
//</editor-fold>
public final LValue EmitCallExprLValue(/*const*/ CallExpr /*P*/ E) {
  RValue RV = $this().EmitCallExpr(E);
  if (!RV.isScalar()) {
    return $this().MakeAddrLValue(RV.getAggregateAddress(), E.getType(), 
        AlignmentSource.Decl);
  }
  assert (E.getCallReturnType($this().getContext()).$arrow().isReferenceType()) : "Can't have a scalar return unless the return type is a reference type!";
  
  return $this().MakeNaturalAlignPointeeAddrLValue(RV.getScalarVal(), E.getType());
}

// Note: only available for agg return types
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitVAArgExprLValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp", line = 3873,
 FQN="clang::CodeGen::CodeGenFunction::EmitVAArgExprLValue", NM="_ZN5clang7CodeGen15CodeGenFunction19EmitVAArgExprLValueEPKNS_9VAArgExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction19EmitVAArgExprLValueEPKNS_9VAArgExprE")
//</editor-fold>
public final LValue EmitVAArgExprLValue(/*const*/ VAArgExpr /*P*/ E) {
  // FIXME: This shouldn't require another copy.
  return $this().EmitAggExprToLValue(E);
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitDeclRefLValue">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp", line = 2072,
 FQN="clang::CodeGen::CodeGenFunction::EmitDeclRefLValue", NM="_ZN5clang7CodeGen15CodeGenFunction17EmitDeclRefLValueEPKNS_11DeclRefExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction17EmitDeclRefLValueEPKNS_11DeclRefExprE")
//</editor-fold>
public final LValue EmitDeclRefLValue(/*const*/ DeclRefExpr /*P*/ E) {
  /*const*/ NamedDecl /*P*/ ND = E.getDecl$Const();
  QualType T = E.getType();
  {
    
    type$ref</*const*/ VarDecl /*P*/ > VD = create_type$ref(dyn_cast_VarDecl(ND));
    if ((VD.$deref() != null)) {
      // Global Named registers access via intrinsics only
      if (VD.$deref().getStorageClass() == StorageClass.SC_Register
         && VD.$deref().hasAttr(AsmLabelAttr.class) && !VD.$deref().isLocalVarDecl()) {
        return CGExprStatics.EmitGlobalNamedRegister(VD.$deref(), $this().CGM);
      }
      
      // A DeclRefExpr for a reference initialized by a constant expression can
      // appear without being odr-used. Directly emit the constant initializer.
      /*const*/ Expr /*P*/ Init = VD.$deref().getAnyInitializer(VD);
      if ((Init != null) && !isa_ParmVarDecl(VD) && VD.$deref().getType().$arrow().isReferenceType()
         && VD.$deref().isUsableInConstantExpressions($this().getContext())
         && VD.$deref().checkInitIsICE()
        // Do not emit if it is private OpenMP variable.
         && !(E.refersToEnclosingVariableOrCapture() && ($this().CapturedStmtInfo != null)
         && ($this().LocalDeclMap.count(VD.$deref()) != 0))) {
        Constant /*P*/ Val = $this().CGM.EmitConstantValue($Deref(VD.$deref().evaluateValue()), VD.$deref().getType(), $this());
        assert ((Val != null)) : "failed to emit reference constant expression";
        // FIXME: Eventually we will want to emit vector element references.
        
        // Should we be using the alignment of the constant pointer we emitted?
        CharUnits Alignment = $this().getNaturalTypeAlignment(E.getType(), create_type$null$ptr(), 
            /*pointee*/ true);
        
        return $this().MakeAddrLValue(new Address(Val, new CharUnits(Alignment)), new QualType(T), AlignmentSource.Decl);
      }
      
      // Check for captured variables.
      if (E.refersToEnclosingVariableOrCapture()) {
        {
          FieldDecl /*P*/ FD = $this().LambdaCaptureFields.lookup(VD.$deref());
          if ((FD != null)) {
            return CGExprStatics.EmitCapturedFieldLValue(/*Deref*/$this(), FD, $this().CXXABIThisValue);
          } else if (($this().CapturedStmtInfo != null)) {
            DenseMapIterator</*const*/ Decl /*P*/ , Address> it = $this().LocalDeclMap.find(VD.$deref());
            if (it.$noteq(/*NO_ITER_COPY*/$this().LocalDeclMap.end())) {
              {
                /*const*/ ReferenceType /*P*/ RefTy = VD.$deref().getType().$arrow().getAs(ReferenceType.class);
                if ((RefTy != null)) {
                  return $this().EmitLoadOfReferenceLValue(new Address(it.$arrow().second), RefTy);
                }
              }
              return $this().MakeAddrLValue(new Address(it.$arrow().second), new QualType(T));
            }
            LValue CapLVal = CGExprStatics.EmitCapturedFieldLValue(/*Deref*/$this(), $this().CapturedStmtInfo.lookup(VD.$deref()), 
                $this().CapturedStmtInfo.getContextValue());
            return $this().MakeAddrLValue(new Address(CapLVal.getPointer(), $this().getContext().getDeclAlign(VD.$deref())), 
                CapLVal.getType(), AlignmentSource.Decl);
          }
        }
        assert (isa_BlockDecl($this().CurCodeDecl));
        Address addr = $this().GetAddrOfBlockDecl(VD.$deref(), VD.$deref().hasAttr(BlocksAttr.class));
        return $this().MakeAddrLValue(new Address(addr), new QualType(T), AlignmentSource.Decl);
      }
    }
  }
  
  // FIXME: We should be able to assert this for FunctionDecls as well!
  // FIXME: We should be able to assert this for all DeclRefExprs, not just
  // those with a valid source location.
  assert ((ND.isUsed(false) || !isa_VarDecl(ND) || !E.getLocation().isValid())) : "Should not use decl without marking it used!";
  if (ND.hasAttr(WeakRefAttr.class)) {
    /*const*/ ValueDecl /*P*/ VD = cast_ValueDecl(ND);
    ConstantAddress Aliasee = $this().CGM.GetWeakRefReference(VD);
    return $this().MakeAddrLValue(new Address(Aliasee), new QualType(T), AlignmentSource.Decl);
  }
  {
    
    /*const*/ VarDecl /*P*/ VD = dyn_cast_VarDecl(ND);
    if ((VD != null)) {
      // Check if this is a global variable.
      if (VD.hasLinkage() || VD.isStaticDataMember()) {
        return CGExprStatics.EmitGlobalVarDeclLValue(/*Deref*/$this(), E, VD);
      }
      
      Address addr = Address.invalid();
      
      // The variable should generally be present in the local decl map.
      DenseMapIterator</*const*/ Decl /*P*/ , Address> iter = $this().LocalDeclMap.find(VD);
      if (iter.$noteq(/*NO_ITER_COPY*/$this().LocalDeclMap.end())) {
        addr.$assign(iter.$arrow().second);
        // Otherwise, it might be static local we haven't emitted yet for
        // some reason; most likely, because it's in an outer function.
      } else if (VD.isStaticLocal()) {
        addr.$assignMove(new Address($this().CGM.getOrCreateStaticVarDecl($Deref(VD), $this().CGM.getLLVMLinkageVarDefinition(VD, /*isConstant=*/ false)), 
                $this().getContext().getDeclAlign(VD)));
        // No other cases for now.
      } else {
        throw new llvm_unreachable("DeclRefExpr for Decl not entered in LocalDeclMap?");
      }
      
      // Check for OpenMP threadprivate variables.
      if (($this().getLangOpts().OpenMP != 0) && VD.hasAttr(OMPThreadPrivateDeclAttr.class)) {
        return CGExprStatics.EmitThreadPrivateVarDeclLValue(/*Deref*/$this(), VD, new QualType(T), new Address(addr), $this().getTypes().ConvertTypeForMem(VD.getType()), 
            E.getExprLoc());
      }
      
      // Drill into block byref variables.
      boolean isBlockByref = VD.hasAttr(BlocksAttr.class);
      if (isBlockByref) {
        addr.$assignMove($this().emitBlockByrefAddress(new Address(addr), VD));
      }
      
      // Drill into reference types.
      LValue LV/*J*/= new LValue();
      {
        /*const*/ ReferenceType /*P*/ RefTy = VD.getType().$arrow().getAs(ReferenceType.class);
        if ((RefTy != null)) {
          LV.$assignMove($this().EmitLoadOfReferenceLValue(new Address(addr), RefTy));
        } else {
          LV.$assignMove($this().MakeAddrLValue(new Address(addr), new QualType(T), AlignmentSource.Decl));
        }
      }
      
      boolean isLocalStorage = VD.hasLocalStorage();
      
      boolean NonGCable = isLocalStorage
         && !VD.getType().$arrow().isReferenceType()
         && !isBlockByref;
      if (NonGCable) {
        LV.getQuals().removeObjCGCAttr();
        LV.setNonGC(true);
      }
      
      boolean isImpreciseLifetime = (isLocalStorage && !VD.hasAttr(ObjCPreciseLifetimeAttr.class));
      if (isImpreciseLifetime) {
        LV.setARCPreciseLifetime(ARCPreciseLifetime_t.ARCImpreciseLifetime);
      }
      CGExprStatics.setObjCGCLValueClass($this().getContext(), E, LV);
      return LV;
    }
  }
  {
    
    /*const*/ FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(ND);
    if ((FD != null)) {
      return CGExprStatics.EmitFunctionDeclLValue(/*Deref*/$this(), E, FD);
    }
  }
  throw new llvm_unreachable("Unhandled DeclRefExpr");
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitStringLiteralLValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp", line = 2274,
 FQN="clang::CodeGen::CodeGenFunction::EmitStringLiteralLValue", NM="_ZN5clang7CodeGen15CodeGenFunction23EmitStringLiteralLValueEPKNS_13StringLiteralE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction23EmitStringLiteralLValueEPKNS_13StringLiteralE")
//</editor-fold>
public final LValue EmitStringLiteralLValue(/*const*/ StringLiteral /*P*/ E) {
  return $this().MakeAddrLValue(new Address(JD$Move.INSTANCE, $this().CGM.GetAddrOfConstantStringFromLiteral(E)), 
      E.getType(), AlignmentSource.Decl);
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitObjCEncodeExprLValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp", line = 2279,
 FQN="clang::CodeGen::CodeGenFunction::EmitObjCEncodeExprLValue", NM="_ZN5clang7CodeGen15CodeGenFunction24EmitObjCEncodeExprLValueEPKNS_14ObjCEncodeExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction24EmitObjCEncodeExprLValueEPKNS_14ObjCEncodeExprE")
//</editor-fold>
public final LValue EmitObjCEncodeExprLValue(/*const*/ ObjCEncodeExpr /*P*/ E) {
  return $this().MakeAddrLValue(new Address(JD$Move.INSTANCE, $this().CGM.GetAddrOfConstantStringFromObjCEncode(E)), 
      E.getType(), AlignmentSource.Decl);
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitPredefinedLValue">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp", line = 2284,
 FQN="clang::CodeGen::CodeGenFunction::EmitPredefinedLValue", NM="_ZN5clang7CodeGen15CodeGenFunction20EmitPredefinedLValueEPKNS_14PredefinedExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction20EmitPredefinedLValueEPKNS_14PredefinedExprE")
//</editor-fold>
public final LValue EmitPredefinedLValue(/*const*/ PredefinedExpr /*P*/ E) {
  /*const*/ StringLiteral /*P*/ SL = E.getFunctionName$Const();
  assert (SL != null) : "No StringLiteral name in PredefinedExpr";
  StringRef FnName = $this().CurFn.getName();
  if (FnName.startswith(/*STRINGREF_STR*/"\001")) {
    FnName.$assignMove(FnName.substr(1));
  }
  type$ptr<std.string> NameItems = create_type$ptr(new std.string [/*2*/] {PredefinedExpr.getIdentTypeName(E.getIdentType()).str(), FnName.str()});
  std.string GVName = llvm.join(NameItems, NameItems.$add(2), new StringRef(/*KEEP_STR*/$DOT));
  if (($this().CurCodeDecl != null) && isa_BlockDecl($this().CurCodeDecl)) {
    ConstantAddress C = $this().CGM.GetAddrOfConstantCString(FnName.$string(), GVName.c_str());
    return $this().MakeAddrLValue(new Address(C), E.getType(), AlignmentSource.Decl);
  }
  ConstantAddress C = $this().CGM.GetAddrOfConstantStringFromLiteral(SL, new StringRef(GVName));
  return $this().MakeAddrLValue(new Address(C), E.getType(), AlignmentSource.Decl);
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitUnaryOpLValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp", line = 2212,
 FQN="clang::CodeGen::CodeGenFunction::EmitUnaryOpLValue", NM="_ZN5clang7CodeGen15CodeGenFunction17EmitUnaryOpLValueEPKNS_13UnaryOperatorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction17EmitUnaryOpLValueEPKNS_13UnaryOperatorE")
//</editor-fold>
public final LValue EmitUnaryOpLValue(/*const*/ UnaryOperator /*P*/ E) {
  // __extension__ doesn't affect lvalue-ness.
  if (E.getOpcode() == UnaryOperatorKind.UO_Extension) {
    return $this().EmitLValue(E.getSubExpr());
  }
  
  QualType ExprTy = $this().getContext().getCanonicalType(E.getSubExpr().getType()).$QualType();
  switch (E.getOpcode()) {
   default:
    throw new llvm_unreachable("Unknown unary operator lvalue!");
   case UO_Deref:
    {
      QualType T = E.getSubExpr().getType().$arrow().getPointeeType();
      assert (!T.isNull()) : "CodeGenFunction::EmitUnaryOpLValue: Illegal type";
      
      type$ptr<AlignmentSource> AlignSource = create_type$null$ptr();
      Address Addr = $this().EmitPointerWithAlignment(E.getSubExpr(), $AddrOf(AlignSource));
      LValue LV = $this().MakeAddrLValue(new Address(Addr), new QualType(T), AlignSource.$star());
      LV.getQuals().setAddressSpace(ExprTy.getAddressSpace());
      
      // We should not generate __weak write barrier on indirect reference
      // of a pointer to object; as in void foo (__weak id *param); *param = 0;
      // But, we continue to generate __strong write barrier on indirect write
      // into a pointer to object.
      if ($this().getLangOpts().ObjC1
         && $this().getLangOpts().getGC() != LangOptions.GCMode.NonGC
         && LV.isObjCWeak()) {
        LV.setNonGC(!E.isOBJCGCCandidate($this().getContext()));
      }
      return LV;
    }
   case UO_Real:
   case UO_Imag:
    {
      LValue LV = $this().EmitLValue(E.getSubExpr());
      assert (LV.isSimple()) : "real/imag on non-ordinary l-value";
      
      // __real is valid on scalars.  This is a faster way of testing that.
      // __imag can only produce an rvalue on scalars.
      if (E.getOpcode() == UnaryOperatorKind.UO_Real
         && !LV.getAddress().getElementType().isStructTy()) {
        assert (E.getSubExpr().getType().$arrow().isArithmeticType());
        return LV;
      }
      assert (E.getSubExpr().getType().$arrow().isAnyComplexType());
      
      Address Component = (E.getOpcode() == UnaryOperatorKind.UO_Real ? $this().emitAddrOfRealComponent(LV.getAddress(), LV.getType()) : $this().emitAddrOfImagComponent(LV.getAddress(), LV.getType()));
      return $this().MakeAddrLValue(new Address(Component), new QualType(ExprTy), LV.getAlignmentSource());
    }
   case UO_PreInc:
   case UO_PreDec:
    {
      LValue LV = $this().EmitLValue(E.getSubExpr());
      boolean isInc = E.getOpcode() == UnaryOperatorKind.UO_PreInc;
      if (E.getType().$arrow().isAnyComplexType()) {
        $this().EmitComplexPrePostIncDec(E, new LValue(LV), isInc, true/*isPre*/);
      } else {
        $this().EmitScalarPrePostIncDec(E, new LValue(LV), isInc, true/*isPre*/);
      }
      return LV;
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitArraySubscriptExpr">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp", line = 2869,
 FQN="clang::CodeGen::CodeGenFunction::EmitArraySubscriptExpr", NM="_ZN5clang7CodeGen15CodeGenFunction22EmitArraySubscriptExprEPKNS_18ArraySubscriptExprEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction22EmitArraySubscriptExprEPKNS_18ArraySubscriptExprEb")
//</editor-fold>
public final LValue EmitArraySubscriptExpr(/*const*/ ArraySubscriptExpr /*P*/ E) {
  return EmitArraySubscriptExpr(E, 
                      false);
}
public final LValue EmitArraySubscriptExpr(/*const*/ ArraySubscriptExpr /*P*/ E, 
                      boolean Accessed/*= false*/) {
  // The index must always be an integer, which is not an aggregate.  Emit it.
  Value /*P*/ Idx = $this().EmitScalarExpr(E.getIdx$Const());
  QualType IdxTy = E.getIdx$Const().getType();
  boolean IdxSigned = IdxTy.$arrow().isSignedIntegerOrEnumerationType();
  if ($this().SanOpts.has(SanitizerKind.ArrayBounds)) {
    $this().EmitBoundsCheck(E, E.getBase$Const(), Idx, new QualType(IdxTy), Accessed);
  }
  
  // If the base is a vector type, then we are forming a vector element lvalue
  // with this subscript.
  if (E.getBase$Const().getType().$arrow().isVectorType()
     && !isa_ExtVectorElementExpr(E.getBase$Const())) {
    // Emit the vector as an lvalue to get its address.
    LValue LHS = $this().EmitLValue(E.getBase$Const());
    assert (LHS.isSimple()) : "Can only subscript lvalue vectors here!";
    return LValue.MakeVectorElt(LHS.getAddress(), Idx, 
        E.getBase$Const().getType(), 
        LHS.getAlignmentSource());
  }
  
  // All the other cases basically behave like simple offsetting.
  
  // Extend or truncate the index type to 32 or 64-bits.
  if (Idx.getType() != Unnamed_field8.IntPtrTy) {
    Idx = $this().Builder.CreateIntCast(Idx, Unnamed_field8.IntPtrTy, IdxSigned, new Twine(/*KEEP_STR*/"idxprom"));
  }
  
  // Handle the extvector case we ignored above.
  if (isa_ExtVectorElementExpr(E.getBase$Const())) {
    LValue LV = $this().EmitLValue(E.getBase$Const());
    Address Addr = $this().EmitExtVectorElementLValue(new LValue(LV));
    
    QualType EltType = LV.getType().$arrow().castAs(org.clang.ast.VectorType.class).getElementType();
    Addr.$assignMove(CGExprStatics.emitArraySubscriptGEP(/*Deref*/$this(), new Address(Addr), new ArrayRef<Value /*P*/ >(Idx, true), new QualType(EltType), /*inbounds*/ true));
    return $this().MakeAddrLValue(new Address(Addr), new QualType(EltType), LV.getAlignmentSource());
  }
  
  type$ptr<AlignmentSource> AlignSource = create_type$null$ptr();
  Address Addr = Address.invalid();
  {
    /*const*/ VariableArrayType /*P*/ vla = $this().getContext().getAsVariableArrayType(E.getType());
    if ((vla != null)) {
      // The base must be a pointer, which is not an aggregate.  Emit
      // it.  It needs to be emitted first in case it's what captures
      // the VLA bounds.
      Addr.$assignMove($this().EmitPointerWithAlignment(E.getBase$Const(), $AddrOf(AlignSource)));
      
      // The element count here is the total number of non-VLA elements.
      Value /*P*/ numElements = $this().getVLASize(vla).first;
      
      // Effectively, the multiply by the VLA size is part of the GEP.
      // GEP indexes are signed, and scaling an index isn't permitted to
      // signed-overflow, so we use the same semantics for our explicit
      // multiply.  We suppress this if overflow is not undefined behavior.
      if ($this().getLangOpts().isSignedOverflowDefined()) {
        Idx = $this().Builder.CreateMul(Idx, numElements);
      } else {
        Idx = $this().Builder.CreateNSWMul(Idx, numElements);
      }
      
      Addr.$assignMove(CGExprStatics.emitArraySubscriptGEP(/*Deref*/$this(), new Address(Addr), new ArrayRef<Value /*P*/ >(Idx, true), vla.getElementType(), 
              !$this().getLangOpts().isSignedOverflowDefined()));
    } else {
      /*const*/ ObjCObjectType /*P*/ OIT = E.getType().$arrow().getAs(ObjCObjectType.class);
      if ((OIT != null)) {
        // Indexing over an interface, as in "NSString *P; P[4];"
        CharUnits InterfaceSize = $this().getContext().getTypeSizeInChars(OIT);
        Value /*P*/ InterfaceSizeVal = ConstantInt.get(Idx.getType(), InterfaceSize.getQuantity());
        ;
        
        Value /*P*/ ScaledIdx = $this().Builder.CreateMul(Idx, InterfaceSizeVal);
        
        // Emit the base pointer.
        Addr.$assignMove($this().EmitPointerWithAlignment(E.getBase$Const(), $AddrOf(AlignSource)));
        
        // We don't necessarily build correct LLVM struct types for ObjC
        // interfaces, so we can't rely on GEP to do this scaling
        // correctly, so we need to cast to i8*.  FIXME: is this actually
        // true?  A lot of other things in the fragile ABI would break...
        org.llvm.ir.Type /*P*/ OrigBaseTy = Addr.getType();
        Addr.$assignMove($this().Builder.CreateElementBitCast(new Address(Addr), Int8Ty));
        
        // Do the GEP.
        CharUnits EltAlign = CGExprStatics.getArrayElementAlign(Addr.getAlignment(), Idx, new CharUnits(InterfaceSize));
        Value /*P*/ EltPtr = CGExprStatics.emitArraySubscriptGEP(/*Deref*/$this(), Addr.getPointer(), new ArrayRef<Value /*P*/ >(ScaledIdx, true), false);
        Addr.$assignMove(new Address(EltPtr, new CharUnits(EltAlign)));
        
        // Cast back.
        Addr.$assignMove($this().Builder.CreateBitCast(new Address(Addr), OrigBaseTy));
      } else {
        /*const*/ Expr /*P*/ Array = CGExprStatics.isSimpleArrayDecayOperand(E.getBase$Const());
        if ((Array != null)) {
          // If this is A[i] where A is an array, the frontend will have decayed the
          // base to be a ArrayToPointerDecay implicit cast.  While correct, it is
          // inefficient at -O0 to emit a "gep A, 0, 0" when codegen'ing it, then a
          // "gep x, i" here.  Emit one "gep A, 0, i".
          assert (Array.getType().$arrow().isArrayType()) : "Array to pointer decay must have array source type!";
          LValue ArrayLV/*J*/= new LValue();
          {
            // For simple multidimensional array indexing, set the 'accessed' flag for
            // better bounds-checking of the base expression.
            /*const*/ ArraySubscriptExpr /*P*/ ASE = dyn_cast_ArraySubscriptExpr(Array);
            if ((ASE != null)) {
              ArrayLV.$assignMove($this().EmitArraySubscriptExpr(ASE, /*Accessed*/ true));
            } else {
              ArrayLV.$assignMove($this().EmitLValue(Array));
            }
          }
          
          // Propagate the alignment from the array itself to the result.
          Addr.$assignMove(CGExprStatics.emitArraySubscriptGEP(/*Deref*/$this(), ArrayLV.getAddress(), 
                  /*{ */new ArrayRef<Value /*P*/ >(new Value /*P*/ /*const*/ [/*2*/] {$this().CGM.getSize(CharUnits.Zero()), Idx}, true)/* }*/, 
                  E.getType(), 
                  !$this().getLangOpts().isSignedOverflowDefined()));
          AlignSource.$set(ArrayLV.getAlignmentSource());
        } else {
          // The base must be a pointer; emit it with an estimate of its alignment.
          Addr.$assignMove($this().EmitPointerWithAlignment(E.getBase$Const(), $AddrOf(AlignSource)));
          Addr.$assignMove(CGExprStatics.emitArraySubscriptGEP(/*Deref*/$this(), new Address(Addr), new ArrayRef<Value /*P*/ >(Idx, true), E.getType(), 
                  !$this().getLangOpts().isSignedOverflowDefined()));
        }
      }
    }
  }
  
  LValue LV = $this().MakeAddrLValue(new Address(Addr), E.getType(), AlignSource.$star());
  
  // TODO: Preserve/extend path TBAA metadata?
  if ($this().getLangOpts().ObjC1
     && $this().getLangOpts().getGC() != LangOptions.GCMode.NonGC) {
    LV.setNonGC(!E.isOBJCGCCandidate($this().getContext()));
    CGExprStatics.setObjCGCLValueClass($this().getContext(), E, LV);
  }
  return LV;
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitOMPArraySectionExpr">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp", line = 3033,
 FQN="clang::CodeGen::CodeGenFunction::EmitOMPArraySectionExpr", NM="_ZN5clang7CodeGen15CodeGenFunction23EmitOMPArraySectionExprEPKNS_19OMPArraySectionExprEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction23EmitOMPArraySectionExprEPKNS_19OMPArraySectionExprEb")
//</editor-fold>
public final LValue EmitOMPArraySectionExpr(/*const*/ OMPArraySectionExpr /*P*/ E) {
  return EmitOMPArraySectionExpr(E, 
                       true);
}
public final LValue EmitOMPArraySectionExpr(/*const*/ OMPArraySectionExpr /*P*/ E, 
                       boolean IsLowerBound/*= true*/) {
  QualType BaseTy/*J*/= new QualType();
  {
    /*const*/ OMPArraySectionExpr /*P*/ ASE = dyn_cast_OMPArraySectionExpr(E.getBase$Const().IgnoreParenImpCasts$Const());
    if ((ASE != null)) {
      BaseTy.$assignMove(OMPArraySectionExpr.getBaseOriginalType(ASE));
    } else {
      BaseTy.$assignMove(E.getBase$Const().getType());
    }
  }
  QualType ResultExprTy/*J*/= new QualType();
  {
    /*const*/ org.clang.ast.ArrayType /*P*/ AT = $this().getContext().getAsArrayType(new QualType(BaseTy));
    if ((AT != null)) {
      ResultExprTy.$assignMove(AT.getElementType());
    } else {
      ResultExprTy.$assignMove(BaseTy.$arrow().getPointeeType());
    }
  }
  Value /*P*/ Idx = null;
  if (IsLowerBound || E.getColonLoc().isInvalid()) {
    {
      // Requesting lower bound or upper bound, but without provided length and
      // without ':' symbol for the default length -> length = 1.
      // Idx = LowerBound ?: 0;
      /*const*/ Expr /*P*/ LowerBound = E.getLowerBound$Const();
      if ((LowerBound != null)) {
        Idx = $this().Builder.CreateIntCast($this().EmitScalarExpr(LowerBound), Unnamed_field8.IntPtrTy, 
            LowerBound.getType().$arrow().hasSignedIntegerRepresentation());
      } else {
        Idx = ConstantInt.getNullValue(Unnamed_field8.IntPtrTy);
      }
    }
  } else {
    // Try to emit length or lower bound as constant. If this is possible, 1
    // is subtracted from constant length or lower bound. Otherwise, emit LLVM
    // IR (LB + Len) - 1.
    final ASTContext /*&*/ C = $this().CGM.getContext();
    /*const*/ Expr /*P*/ Length = E.getLength$Const();
    APSInt ConstLength/*J*/= new APSInt();
    if ((Length != null)) {
      // Idx = LowerBound + Length - 1;
      if (Length.isIntegerConstantExpr(ConstLength, C)) {
        ConstLength.$assign(ConstLength.zextOrTrunc($uchar2uint(PointerWidthInBits)));
        Length = null;
      }
      /*const*/ Expr /*P*/ LowerBound = E.getLowerBound$Const();
      APSInt ConstLowerBound/*J*/= new APSInt($uchar2uint(PointerWidthInBits), /*isUnsigned=*/ false);
      if ((LowerBound != null) && LowerBound.isIntegerConstantExpr(ConstLowerBound, C)) {
        ConstLowerBound.$assign(ConstLowerBound.zextOrTrunc($uchar2uint(PointerWidthInBits)));
        LowerBound = null;
      }
      if (!(Length != null)) {
        ConstLength.$preDec();
      } else if (!(LowerBound != null)) {
        ConstLowerBound.$preDec();
      }
      if ((Length != null) || (LowerBound != null)) {
        Value /*P*/ LowerBoundVal = (LowerBound != null) ? $this().Builder.CreateIntCast($this().EmitScalarExpr(LowerBound), Unnamed_field8.IntPtrTy, 
            LowerBound.getType().$arrow().hasSignedIntegerRepresentation()) : ConstantInt.get(Unnamed_field8.IntPtrTy, ConstLowerBound);
        Value /*P*/ LengthVal = (Length != null) ? $this().Builder.CreateIntCast($this().EmitScalarExpr(Length), Unnamed_field8.IntPtrTy, 
            Length.getType().$arrow().hasSignedIntegerRepresentation()) : ConstantInt.get(Unnamed_field8.IntPtrTy, ConstLength);
        Idx = $this().Builder.CreateAdd(LowerBoundVal, LengthVal, new Twine(/*KEEP_STR*/"lb_add_len"), 
            /*HasNUW=*/ false, 
            !$this().getLangOpts().isSignedOverflowDefined());
        if ((Length != null) && (LowerBound != null)) {
          Idx = $this().Builder.CreateSub(Idx, ConstantInt.get(Unnamed_field8.IntPtrTy, /*V=*/ $int2ulong(1)), new Twine(/*KEEP_STR*/"idx_sub_1"), 
              /*HasNUW=*/ false, !$this().getLangOpts().isSignedOverflowDefined());
        }
      } else {
        Idx = ConstantInt.get(Unnamed_field8.IntPtrTy, ConstLength.$add(ConstLowerBound));
      }
    } else {
      // Idx = ArraySize - 1;
      QualType ArrayTy = BaseTy.$arrow().isPointerType() ? E.getBase$Const().IgnoreParenImpCasts$Const().getType() : new QualType(BaseTy);
      {
        /*const*/ VariableArrayType /*P*/ VAT = C.getAsVariableArrayType(new QualType(ArrayTy));
        if ((VAT != null)) {
          Length = VAT.getSizeExpr();
          if (Length.isIntegerConstantExpr(ConstLength, C)) {
            Length = null;
          }
        } else {
          /*const*/ ConstantArrayType /*P*/ CAT = C.getAsConstantArrayType(new QualType(ArrayTy));
          ConstLength.$assign(new APInt(CAT.getSize()));
        }
      }
      if ((Length != null)) {
        Value /*P*/ LengthVal = $this().Builder.CreateIntCast($this().EmitScalarExpr(Length), Unnamed_field8.IntPtrTy, 
            Length.getType().$arrow().hasSignedIntegerRepresentation());
        Idx = $this().Builder.CreateSub(LengthVal, ConstantInt.get(Unnamed_field8.IntPtrTy, /*V=*/ $int2ulong(1)), new Twine(/*KEEP_STR*/"len_sub_1"), 
            /*HasNUW=*/ false, !$this().getLangOpts().isSignedOverflowDefined());
      } else {
        ConstLength.$assign(ConstLength.zextOrTrunc($uchar2uint(PointerWidthInBits)));
        ConstLength.$preDec();
        Idx = ConstantInt.get(Unnamed_field8.IntPtrTy, ConstLength);
      }
    }
  }
  assert Native.$bool(Idx);
  
  Address EltPtr = Address.invalid();
  type$ref<AlignmentSource> AlignSource = create_type$ref();
  {
    /*const*/ VariableArrayType /*P*/ VLA = $this().getContext().getAsVariableArrayType(new QualType(ResultExprTy));
    if ((VLA != null)) {
      // The base must be a pointer, which is not an aggregate.  Emit
      // it.  It needs to be emitted first in case it's what captures
      // the VLA bounds.
      Address Base = CGExprStatics.emitOMPArraySectionBase(/*Deref*/$this(), E.getBase$Const(), AlignSource, new QualType(BaseTy), 
          VLA.getElementType(), IsLowerBound);
      // The element count here is the total number of non-VLA elements.
      Value /*P*/ NumElements = $this().getVLASize(VLA).first;
      
      // Effectively, the multiply by the VLA size is part of the GEP.
      // GEP indexes are signed, and scaling an index isn't permitted to
      // signed-overflow, so we use the same semantics for our explicit
      // multiply.  We suppress this if overflow is not undefined behavior.
      if ($this().getLangOpts().isSignedOverflowDefined()) {
        Idx = $this().Builder.CreateMul(Idx, NumElements);
      } else {
        Idx = $this().Builder.CreateNSWMul(Idx, NumElements);
      }
      EltPtr.$assignMove(CGExprStatics.emitArraySubscriptGEP(/*Deref*/$this(), new Address(Base), new ArrayRef<Value /*P*/ >(Idx, true), VLA.getElementType(), 
              !$this().getLangOpts().isSignedOverflowDefined()));
    } else {
      /*const*/ Expr /*P*/ Array = CGExprStatics.isSimpleArrayDecayOperand(E.getBase$Const());
      if ((Array != null)) {
        // If this is A[i] where A is an array, the frontend will have decayed the
        // base to be a ArrayToPointerDecay implicit cast.  While correct, it is
        // inefficient at -O0 to emit a "gep A, 0, 0" when codegen'ing it, then a
        // "gep x, i" here.  Emit one "gep A, 0, i".
        assert (Array.getType().$arrow().isArrayType()) : "Array to pointer decay must have array source type!";
        LValue ArrayLV/*J*/= new LValue();
        {
          // For simple multidimensional array indexing, set the 'accessed' flag for
          // better bounds-checking of the base expression.
          /*const*/ ArraySubscriptExpr /*P*/ ASE = dyn_cast_ArraySubscriptExpr(Array);
          if ((ASE != null)) {
            ArrayLV.$assignMove($this().EmitArraySubscriptExpr(ASE, /*Accessed*/ true));
          } else {
            ArrayLV.$assignMove($this().EmitLValue(Array));
          }
        }
        
        // Propagate the alignment from the array itself to the result.
        EltPtr.$assignMove(CGExprStatics.emitArraySubscriptGEP(/*Deref*/$this(), ArrayLV.getAddress(), /*{ */new ArrayRef<Value /*P*/ >(new Value /*P*/ /*const*/ [/*2*/] {$this().CGM.getSize(CharUnits.Zero()), Idx}, true)/* }*/, 
                new QualType(ResultExprTy), !$this().getLangOpts().isSignedOverflowDefined()));
        AlignSource.$set(ArrayLV.getAlignmentSource());
      } else {
        Address Base = CGExprStatics.emitOMPArraySectionBase(/*Deref*/$this(), E.getBase$Const(), AlignSource, 
            new QualType(BaseTy), new QualType(ResultExprTy), IsLowerBound);
        EltPtr.$assignMove(CGExprStatics.emitArraySubscriptGEP(/*Deref*/$this(), new Address(Base), new ArrayRef<Value /*P*/ >(Idx, true), new QualType(ResultExprTy), 
                !$this().getLangOpts().isSignedOverflowDefined()));
      }
    }
  }
  
  return $this().MakeAddrLValue(new Address(EltPtr), new QualType(ResultExprTy), AlignSource.$deref());
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitExtVectorElementExpr">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp", line = 3185,
 FQN="clang::CodeGen::CodeGenFunction::EmitExtVectorElementExpr", NM="_ZN5clang7CodeGen15CodeGenFunction24EmitExtVectorElementExprEPKNS_20ExtVectorElementExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction24EmitExtVectorElementExprEPKNS_20ExtVectorElementExprE")
//</editor-fold>
public final LValue EmitExtVectorElementExpr(/*const*/ ExtVectorElementExpr /*P*/ E) {
  // Emit the base vector as an l-value.
  LValue Base/*J*/= new LValue();
  
  // ExtVectorElementExpr's base can either be a vector or pointer to vector.
  if (E.isArrow()) {
    // If it is a pointer to a vector, emit the address and form an lvalue with
    // it.
    type$ptr<AlignmentSource> AlignSource = create_type$null$ptr();
    Address Ptr = $this().EmitPointerWithAlignment(E.getBase$Const(), $AddrOf(AlignSource));
    /*const*/ org.clang.ast.PointerType /*P*/ PT = E.getBase$Const().getType().$arrow().getAs(org.clang.ast.PointerType.class);
    Base.$assignMove($this().MakeAddrLValue(new Address(Ptr), PT.getPointeeType(), AlignSource.$star()));
    Base.getQuals().removeObjCGCAttr();
  } else if (E.getBase$Const().isGLValue()) {
    // Otherwise, if the base is an lvalue ( as in the case of foo.x.x),
    // emit the base as an lvalue.
    assert (E.getBase$Const().getType().$arrow().isVectorType());
    Base.$assignMove($this().EmitLValue(E.getBase$Const()));
  } else {
    // Otherwise, the base is a normal rvalue (as in (V+V).x), emit it as such.
    assert (E.getBase$Const().getType().$arrow().isVectorType()) : "Result must be a vector";
    Value /*P*/ Vec = $this().EmitScalarExpr(E.getBase$Const());
    
    // Store the vector to memory (because LValue wants an address).
    Address VecMem = $this().CreateMemTemp(E.getBase$Const().getType());
    $this().Builder.CreateStore(Vec, new Address(VecMem));
    Base.$assignMove($this().MakeAddrLValue(new Address(VecMem), E.getBase$Const().getType(), 
            AlignmentSource.Decl));
  }
  
  QualType type = E.getType().withCVRQualifiers(Base.getQuals().getCVRQualifiers());
  
  // Encode the element access list into a vector of unsigned indices.
  SmallVectorUInt Indices/*J*/= new SmallVectorUInt(4, (/*uint32_t*/int)0);
  E.getEncodedElementAccess(Indices);
  if (Base.isSimple()) {
    Constant /*P*/ CV = ConstantDataVector.get_LLVMContext_ArrayRefUInt($this().getLLVMContext(), new ArrayRefUInt(Indices));
    return LValue.MakeExtVectorElt(Base.getAddress(), CV, new QualType(type), 
        Base.getAlignmentSource());
  }
  assert (Base.isExtVectorElt()) : "Can only subscript lvalue vec elts here!";
  
  Constant /*P*/ BaseElts = Base.getExtVectorElts();
  SmallVector<Constant /*P*/ > CElts/*J*/= new SmallVector<Constant /*P*/ >(4, (Constant /*P*/ )null);
  
  for (/*uint*/int i = 0, e = Indices.size(); i != e; ++i)  {
    CElts.push_back(BaseElts.getAggregateElement(Indices.$at(i)));
  }
  Constant /*P*/ CV = ConstantVector.get(new ArrayRef<Constant /*P*/ >(CElts, true));
  return LValue.MakeExtVectorElt(Base.getExtVectorAddress(), CV, new QualType(type), 
      Base.getAlignmentSource());
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitMemberExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp", line = 3242,
 FQN="clang::CodeGen::CodeGenFunction::EmitMemberExpr", NM="_ZN5clang7CodeGen15CodeGenFunction14EmitMemberExprEPKNS_10MemberExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction14EmitMemberExprEPKNS_10MemberExprE")
//</editor-fold>
public final LValue EmitMemberExpr(/*const*/ MemberExpr /*P*/ E) {
  Expr /*P*/ BaseExpr = E.getBase();
  
  // If this is s.x, emit s as an lvalue.  If it is s->x, emit s as a scalar.
  LValue BaseLV/*J*/= new LValue();
  if (E.isArrow()) {
    type$ptr<AlignmentSource> AlignSource = create_type$null$ptr();
    Address Addr = $this().EmitPointerWithAlignment(BaseExpr, $AddrOf(AlignSource));
    QualType PtrTy = BaseExpr.getType().$arrow().getPointeeType();
    $this().EmitTypeCheck(TypeCheckKind.TCK_MemberAccess, E.getExprLoc(), Addr.getPointer(), new QualType(PtrTy));
    BaseLV.$assignMove($this().MakeAddrLValue(new Address(Addr), new QualType(PtrTy), AlignSource.$star()));
  } else {
    BaseLV.$assignMove($this().EmitCheckedLValue(BaseExpr, TypeCheckKind.TCK_MemberAccess));
  }
  
  NamedDecl /*P*/ ND = E.getMemberDecl();
  {
    FieldDecl /*P*/ Field = dyn_cast_FieldDecl(ND);
    if ((Field != null)) {
      LValue LV = $this().EmitLValueForField(new LValue(BaseLV), Field);
      CGExprStatics.setObjCGCLValueClass($this().getContext(), E, LV);
      return LV;
    }
  }
  {
    
    VarDecl /*P*/ VD = dyn_cast_VarDecl(ND);
    if ((VD != null)) {
      return CGExprStatics.EmitGlobalVarDeclLValue(/*Deref*/$this(), E, VD);
    }
  }
  {
    
    /*const*/ FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(ND);
    if ((FD != null)) {
      return CGExprStatics.EmitFunctionDeclLValue(/*Deref*/$this(), E, FD);
    }
  }
  throw new llvm_unreachable("Unhandled member declaration!");
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitCompoundLiteralLValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp", line = 3440,
 FQN="clang::CodeGen::CodeGenFunction::EmitCompoundLiteralLValue", NM="_ZN5clang7CodeGen15CodeGenFunction25EmitCompoundLiteralLValueEPKNS_19CompoundLiteralExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction25EmitCompoundLiteralLValueEPKNS_19CompoundLiteralExprE")
//</editor-fold>
public final LValue EmitCompoundLiteralLValue(/*const*/ CompoundLiteralExpr /*P*/ E) {
  if (E.isFileScope()) {
    ConstantAddress GlobalPtr = $this().CGM.GetAddrOfConstantCompoundLiteral(E);
    return $this().MakeAddrLValue(new Address(GlobalPtr), E.getType(), AlignmentSource.Decl);
  }
  if (E.getType().$arrow().isVariablyModifiedType()) {
    // make sure to emit the VLA size.
    $this().EmitVariablyModifiedType(E.getType());
  }
  
  Address DeclPtr = $this().CreateMemTemp(E.getType(), new Twine(/*KEEP_STR*/".compoundliteral"));
  /*const*/ Expr /*P*/ InitExpr = E.getInitializer$Const();
  LValue Result = $this().MakeAddrLValue(new Address(DeclPtr), E.getType(), AlignmentSource.Decl);
  
  $this().EmitAnyExprToMem(InitExpr, new Address(DeclPtr), E.getType().getQualifiers(), 
      /*Init*/ true);
  
  return Result;
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitInitListLValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp", line = 3459,
 FQN="clang::CodeGen::CodeGenFunction::EmitInitListLValue", NM="_ZN5clang7CodeGen15CodeGenFunction18EmitInitListLValueEPKNS_12InitListExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction18EmitInitListLValueEPKNS_12InitListExprE")
//</editor-fold>
public final LValue EmitInitListLValue(/*const*/ InitListExpr /*P*/ E) {
  if (!E.isGLValue()) {
    // Initializing an aggregate temporary in C++11: T{...}.
    return $this().EmitAggExprToLValue(E);
  }
  
  // An lvalue initializer list must be initializing a reference.
  assert (E.getNumInits() == 1) : "reference init with multiple values";
  return $this().EmitLValue(E.getInit$Const(0));
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitConditionalOperatorLValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp", line = 3482,
 FQN="clang::CodeGen::CodeGenFunction::EmitConditionalOperatorLValue", NM="_ZN5clang7CodeGen15CodeGenFunction29EmitConditionalOperatorLValueEPKNS_27AbstractConditionalOperatorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction29EmitConditionalOperatorLValueEPKNS_27AbstractConditionalOperatorE")
//</editor-fold>
public final LValue EmitConditionalOperatorLValue(/*const*/ AbstractConditionalOperator /*P*/ expr) {
  OpaqueValueMapping binding = null;
  try {
    if (!expr.isGLValue()) {
      // ?: here should be an aggregate.
      assert (CodeGenFunction.hasAggregateEvaluationKind(expr.getType())) : "Unexpected conditional operator!";
      return $this().EmitAggExprToLValue(expr);
    }
    
    binding/*J*/= new OpaqueValueMapping(/*Deref*/$this(), expr);
    
    /*const*/ Expr /*P*/ condExpr = expr.getCond();
    bool$ref CondExprBool = create_bool$ref();
    if ($this().ConstantFoldsToSimpleInteger(condExpr, CondExprBool)) {
      type$ref</*const*/ Expr /*P*/ > live = create_type$ref(expr.getTrueExpr());
      type$ref</*const*/ Expr /*P*/ > dead = create_type$ref(expr.getFalseExpr());
      if (!CondExprBool.$deref()) {
        std.swap(live, dead);
      }
      if (!CodeGenFunction.ContainsLabel(dead.$deref())) {
        // If the true case is live, we need to track its region.
        if (CondExprBool.$deref()) {
          $this().incrementProfileCounter(expr);
        }
        return $this().EmitLValue(live.$deref());
      }
    }
    
    BasicBlock /*P*/ lhsBlock = $this().createBasicBlock(new Twine(/*KEEP_STR*/"cond.true"));
    BasicBlock /*P*/ rhsBlock = $this().createBasicBlock(new Twine(/*KEEP_STR*/"cond.false"));
    BasicBlock /*P*/ contBlock = $this().createBasicBlock(new Twine(/*KEEP_STR*/"cond.end"));
    
    ConditionalEvaluation eval/*J*/= new ConditionalEvaluation(/*Deref*/$this());
    $this().EmitBranchOnBoolExpr(condExpr, lhsBlock, rhsBlock, $this().getProfileCount(expr));
    
    // Any temporaries created here are conditional.
    $this().EmitBlock(lhsBlock);
    $this().incrementProfileCounter(expr);
    eval.begin(/*Deref*/$this());
    Optional<LValue> lhs = CGExprStatics.EmitLValueOrThrowExpression(/*Deref*/$this(), expr.getTrueExpr());
    eval.end(/*Deref*/$this());
    if (lhs.$bool() && !lhs.$arrow().isSimple()) {
      return $this().EmitUnsupportedLValue(expr, $("conditional operator"));
    }
    
    lhsBlock = $this().Builder.GetInsertBlock();
    if (lhs.$bool()) {
      $this().Builder.CreateBr(contBlock);
    }
    
    // Any temporaries created here are conditional.
    $this().EmitBlock(rhsBlock);
    eval.begin(/*Deref*/$this());
    Optional<LValue> rhs = CGExprStatics.EmitLValueOrThrowExpression(/*Deref*/$this(), expr.getFalseExpr());
    eval.end(/*Deref*/$this());
    if (rhs.$bool() && !rhs.$arrow().isSimple()) {
      return $this().EmitUnsupportedLValue(expr, $("conditional operator"));
    }
    rhsBlock = $this().Builder.GetInsertBlock();
    
    $this().EmitBlock(contBlock);
    if (lhs.$bool() && rhs.$bool()) {
      PHINode /*P*/ phi = $this().Builder.CreatePHI(lhs.$arrow().getPointer().getType(), 
          2, new Twine(/*KEEP_STR*/"cond-lvalue"));
      phi.addIncoming(lhs.$arrow().getPointer(), lhsBlock);
      phi.addIncoming(rhs.$arrow().getPointer(), rhsBlock);
      Address result/*J*/= new Address(phi, new CharUnits(std.min(lhs.$arrow().getAlignment(), rhs.$arrow().getAlignment())));
      AlignmentSource alignSource = std.max(lhs.$arrow().getAlignmentSource(), rhs.$arrow().getAlignmentSource());
      return $this().MakeAddrLValue(new Address(result), expr.getType(), alignSource);
    } else {
      assert ((lhs.$bool() || rhs.$bool())) : "both operands of glvalue conditional are throw-expressions?";
      return new LValue(lhs.$bool() ? lhs.$star() : rhs.$star());
    }
  } finally {
    if (binding != null) { binding.$destroy(); }
  }
}


/// EmitCastLValue - Casts are never lvalues unless that cast is to a reference
/// type. If the cast is to a reference, we can have the usual lvalue result,
/// otherwise if a cast is needed by the code generator in an lvalue context,
/// then it must mean that we need the address of an aggregate in order to
/// access one of its members.  This can happen for all the reasons that casts
/// are permitted with aggregate result, including noop aggregate casts, and
/// cast from scalar to union.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitCastLValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp", line = 3564,
 FQN="clang::CodeGen::CodeGenFunction::EmitCastLValue", NM="_ZN5clang7CodeGen15CodeGenFunction14EmitCastLValueEPKNS_8CastExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction14EmitCastLValueEPKNS_8CastExprE")
//</editor-fold>
public final LValue EmitCastLValue(/*const*/ CastExpr /*P*/ E) {
  switch (E.getCastKind()) {
   case CK_ToVoid:
   case CK_BitCast:
   case CK_ArrayToPointerDecay:
   case CK_FunctionToPointerDecay:
   case CK_NullToMemberPointer:
   case CK_NullToPointer:
   case CK_IntegralToPointer:
   case CK_PointerToIntegral:
   case CK_PointerToBoolean:
   case CK_VectorSplat:
   case CK_IntegralCast:
   case CK_BooleanToSignedIntegral:
   case CK_IntegralToBoolean:
   case CK_IntegralToFloating:
   case CK_FloatingToIntegral:
   case CK_FloatingToBoolean:
   case CK_FloatingCast:
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
   case CK_DerivedToBaseMemberPointer:
   case CK_BaseToDerivedMemberPointer:
   case CK_MemberPointerToBoolean:
   case CK_ReinterpretMemberPointer:
   case CK_AnyPointerToBlockPointerCast:
   case CK_ARCProduceObject:
   case CK_ARCConsumeObject:
   case CK_ARCReclaimReturnedObject:
   case CK_ARCExtendBlockObject:
   case CK_CopyAndAutoreleaseBlockObject:
   case CK_AddressSpaceConversion:
    return $this().EmitUnsupportedLValue(E, $("unexpected cast lvalue"));
   case CK_Dependent:
    throw new llvm_unreachable("dependent cast kind in IR gen!");
   case CK_BuiltinFnToFnPtr:
    throw new llvm_unreachable("builtin functions are handled elsewhere");
   case CK_NonAtomicToAtomic:
   case CK_AtomicToNonAtomic:
    
    // These are never l-values; just use the aggregate emission code.
    return $this().EmitAggExprToLValue(E);
   case CK_Dynamic:
    {
      LValue LV = $this().EmitLValue(E.getSubExpr$Const());
      Address V = LV.getAddress();
      /*const*/ CXXDynamicCastExpr /*P*/ DCE = cast_CXXDynamicCastExpr(E);
      return $this().MakeNaturalAlignAddrLValue($this().EmitDynamicCast(new Address(V), DCE), E.getType());
    }
   case CK_ConstructorConversion:
   case CK_UserDefinedConversion:
   case CK_CPointerToObjCPointerCast:
   case CK_BlockPointerToObjCPointerCast:
   case CK_NoOp:
   case CK_LValueToRValue:
    return $this().EmitLValue(E.getSubExpr$Const());
   case CK_UncheckedDerivedToBase:
   case CK_DerivedToBase:
    {
      /*const*/ RecordType /*P*/ DerivedClassTy = E.getSubExpr$Const().getType().$arrow().getAs$RecordType();
      CXXRecordDecl /*P*/ DerivedClassDecl = cast_CXXRecordDecl(DerivedClassTy.getDecl());
      
      LValue LV = $this().EmitLValue(E.getSubExpr$Const());
      Address This = LV.getAddress();
      
      // Perform the derived-to-base conversion
      Address Base = $this().GetAddressOfBaseClass(new Address(This), DerivedClassDecl, E.path_begin$Const(), E.path_end$Const(), 
          /*NullCheckValue=*/ false, E.getExprLoc());
      
      return $this().MakeAddrLValue(new Address(Base), E.getType(), LV.getAlignmentSource());
    }
   case CK_ToUnion:
    return $this().EmitAggExprToLValue(E);
   case CK_BaseToDerived:
    {
      /*const*/ RecordType /*P*/ DerivedClassTy = E.getType().$arrow().getAs$RecordType();
      CXXRecordDecl /*P*/ DerivedClassDecl = cast_CXXRecordDecl(DerivedClassTy.getDecl());
      
      LValue LV = $this().EmitLValue(E.getSubExpr$Const());
      
      // Perform the base-to-derived conversion
      Address Derived = $this().GetAddressOfDerivedClass(LV.getAddress(), DerivedClassDecl, 
          E.path_begin$Const(), E.path_end$Const(), 
          /*NullCheckValue=*/ false);
      
      // C++11 [expr.static.cast]p2: Behavior is undefined if a downcast is
      // performed and the object is not of the derived type.
      if ($this().sanitizePerformTypeCheck()) {
        $this().EmitTypeCheck(TypeCheckKind.TCK_DowncastReference, E.getExprLoc(), 
            Derived.getPointer(), E.getType());
      }
      if ($this().SanOpts.has(SanitizerKind.CFIDerivedCast)) {
        $this().EmitVTablePtrCheckForCast(E.getType(), Derived.getPointer(), 
            /*MayBeNull=*/ false, 
            CFITypeCheckKind.CFITCK_DerivedCast, E.getLocStart());
      }
      
      return $this().MakeAddrLValue(new Address(Derived), E.getType(), LV.getAlignmentSource());
    }
   case CK_LValueBitCast:
    {
      // This must be a reinterpret_cast (or c-style equivalent).
      /*const*/ ExplicitCastExpr /*P*/ CE = cast_ExplicitCastExpr(E);
      
      $this().CGM.EmitExplicitCastExprType(CE, $this());
      LValue LV = $this().EmitLValue(E.getSubExpr$Const());
      Address V = $this().Builder.CreateBitCast(LV.getAddress(), 
          $this().ConvertType(CE.getTypeAsWritten()));
      if ($this().SanOpts.has(SanitizerKind.CFIUnrelatedCast)) {
        $this().EmitVTablePtrCheckForCast(E.getType(), V.getPointer(), 
            /*MayBeNull=*/ false, 
            CFITypeCheckKind.CFITCK_UnrelatedCast, E.getLocStart());
      }
      
      return $this().MakeAddrLValue(new Address(V), E.getType(), LV.getAlignmentSource());
    }
   case CK_ObjCObjectLValueCast:
    {
      LValue LV = $this().EmitLValue(E.getSubExpr$Const());
      Address V = $this().Builder.CreateElementBitCast(LV.getAddress(), 
          $this().ConvertType(E.getType()));
      return $this().MakeAddrLValue(new Address(V), E.getType(), LV.getAlignmentSource());
    }
   case CK_ZeroToOCLEvent:
    throw new llvm_unreachable("NULL to OpenCL event lvalue cast is not valid");
  }
  throw new llvm_unreachable("Unhandled lvalue cast kind?");
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitMaterializeTemporaryExpr">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp", line = 350,
 FQN="clang::CodeGen::CodeGenFunction::EmitMaterializeTemporaryExpr", NM="_ZN5clang7CodeGen15CodeGenFunction28EmitMaterializeTemporaryExprEPKNS_24MaterializeTemporaryExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction28EmitMaterializeTemporaryExprEPKNS_24MaterializeTemporaryExprE")
//</editor-fold>
public final LValue EmitMaterializeTemporaryExpr(/*const*/ MaterializeTemporaryExpr /*P*/ M) {
  /*const*/ Expr /*P*/ E = M.GetTemporaryExpr();
  
  // FIXME: ideally this would use EmitAnyExprToMem, however, we cannot do so
  // as that will cause the lifetime adjustment to be lost for ARC
  Qualifiers.ObjCLifetime ownership = M.getType().getObjCLifetime();
  if (ownership != Qualifiers.ObjCLifetime.OCL_None
     && ownership != Qualifiers.ObjCLifetime.OCL_ExplicitNone) {
    Address Object = CGExprStatics.createReferenceTemporary(/*Deref*/$this(), M, E);
    {
      GlobalVariable /*P*/ Var = dyn_cast_GlobalVariable(Object.getPointer());
      if ((Var != null)) {
        Object.$assignMove(new Address(ConstantExpr.getBitCast(Var, 
                    $this().ConvertTypeForMem(E.getType()).
                        getPointerTo(Object.getAddressSpace())), 
                Object.getAlignment()));
        
        // createReferenceTemporary will promote the temporary to a global with a
        // constant initializer if it can.  It can only do this to a value of
        // ARC-manageable type if the value is global and therefore "immune" to
        // ref-counting operations.  Therefore we have no need to emit either a
        // dynamic initialization or a cleanup and we can just return the address
        // of the temporary.
        if (Var.hasInitializer()) {
          return $this().MakeAddrLValue(new Address(Object), M.getType(), AlignmentSource.Decl);
        }
        
        Var.setInitializer($this().CGM.EmitNullConstant(E.getType()));
      }
    }
    LValue RefTempDst = $this().MakeAddrLValue(new Address(Object), M.getType(), 
        AlignmentSource.Decl);
    switch (CodeGenFunction.getEvaluationKind(E.getType())) {
     default:
      throw new llvm_unreachable("expected scalar or aggregate expression");
     case TEK_Scalar:
      $this().EmitScalarInit(E, M.getExtendingDecl(), new LValue(RefTempDst), false);
      break;
     case TEK_Aggregate:
      {
        $this().EmitAggExpr(E, AggValueSlot.forAddr(new Address(Object), 
                E.getType().getQualifiers(), 
                AggValueSlot.IsDestructed_t.IsDestructed, 
                AggValueSlot.NeedsGCBarriers_t.DoesNotNeedGCBarriers, 
                AggValueSlot.IsAliased_t.IsNotAliased));
        break;
      }
    }
    
    CGExprStatics.pushTemporaryCleanup(/*Deref*/$this(), M, E, new Address(Object));
    return RefTempDst;
  }
  
  SmallVector</*const*/ Expr /*P*/ > CommaLHSs/*J*/= new SmallVector</*const*/ Expr /*P*/ >(2, (/*const*/ Expr /*P*/ )null);
  SmallVector<SubobjectAdjustment> Adjustments/*J*/= new SmallVector<SubobjectAdjustment>(2, new SubobjectAdjustment());
  E = E.skipRValueSubobjectAdjustments(CommaLHSs, Adjustments);
  
  for (final /*const*/ Expr /*P*/ /*const*/ /*&*/ Ignored : CommaLHSs)  {
    $this().EmitIgnoredExpr(Ignored);
  }
  {
    
    /*const*/ OpaqueValueExpr /*P*/ opaque = dyn_cast_OpaqueValueExpr(E);
    if ((opaque != null)) {
      if (opaque.getType().$arrow().isRecordType()) {
        assert (Adjustments.empty());
        return $this().EmitOpaqueValueLValue(opaque);
      }
    }
  }
  
  // Create and initialize the reference temporary.
  Address Object = CGExprStatics.createReferenceTemporary(/*Deref*/$this(), M, E);
  {
    GlobalVariable /*P*/ Var = dyn_cast_GlobalVariable(Object.getPointer());
    if ((Var != null)) {
      Object.$assignMove(new Address(ConstantExpr.getBitCast(Var, $this().ConvertTypeForMem(E.getType()).getPointerTo()), 
              Object.getAlignment()));
      // If the temporary is a global and has a constant initializer or is a
      // constant temporary that we promoted to a global, we may have already
      // initialized it.
      if (!Var.hasInitializer()) {
        Var.setInitializer($this().CGM.EmitNullConstant(E.getType()));
        $this().EmitAnyExprToMem(E, new Address(Object), new Qualifiers(), /*IsInit*/ true);
      }
    } else {
      switch (M.getStorageDuration()) {
       case SD_Automatic:
       case SD_FullExpression:
        {
          Value /*P*/ Size = $this().EmitLifetimeStart($this().CGM.getDataLayout().getTypeAllocSize(Object.getElementType()), 
              Object.getPointer());
          if ((Size != null)) {
            if (M.getStorageDuration() == StorageDuration.SD_Automatic) {
              $this().<CallLifetimeEnd>pushCleanupAfterFullExpr(CleanupKind.NormalEHLifetimeMarker, 
                  new Address(Object), Size);
            } else {
              $this().<CallLifetimeEnd>pushFullExprCleanup(CleanupKind.NormalEHLifetimeMarker, 
                      (Object... A) -> new CallLifetimeEnd((Address) A[0], (Value) A[1]),
                      new Address(Object), Size);
            }
          }
        }
        break;
       default:
        break;
      }
      $this().EmitAnyExprToMem(E, new Address(Object), new Qualifiers(), /*IsInit*/ true);
    }
  }
  CGExprStatics.pushTemporaryCleanup(/*Deref*/$this(), M, E, new Address(Object));
  
  // Perform derived-to-base casts and/or field accesses, to get from the
  // temporary object we created (and, potentially, for which we extended
  // the lifetime) to the subobject we're binding the reference to.
  for (/*uint*/int I = Adjustments.size(); I != 0; --I) {
    final SubobjectAdjustment /*&*/ Adjustment = Adjustments.$at(I - 1);
    switch (Adjustment.Kind) {
     case DerivedToBaseAdjustment:
      Object.$assignMove(
          $this().GetAddressOfBaseClass(new Address(Object), Adjustment.Unnamed_field1.DerivedToBase.DerivedClass, 
              Adjustment.Unnamed_field1.DerivedToBase.BasePath.path_begin$Const(), 
              Adjustment.Unnamed_field1.DerivedToBase.BasePath.path_end$Const(), 
              /*NullCheckValue=*/ false, E.getExprLoc())
      );
      break;
     case FieldAdjustment:
      {
        LValue LV = $this().MakeAddrLValue(new Address(Object), E.getType(), 
            AlignmentSource.Decl);
        LV.$assignMove($this().EmitLValueForField(new LValue(LV), Adjustment.Unnamed_field1.Field));
        assert (LV.isSimple()) : "materialized temporary field is not a simple lvalue";
        Object.$assignMove(LV.getAddress());
        break;
      }
     case MemberPointerAdjustment:
      {
        Value /*P*/ Ptr = $this().EmitScalarExpr(Adjustment.Unnamed_field1.Ptr.RHS);
        Object.$assignMove($this().EmitCXXMemberDataPointerAddress(E, new Address(Object), Ptr, 
                Adjustment.Unnamed_field1.Ptr.MPT));
        break;
      }
    }
  }
  
  return $this().MakeAddrLValue(new Address(Object), M.getType(), AlignmentSource.Decl);
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitOpaqueValueLValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp", line = 3704,
 FQN="clang::CodeGen::CodeGenFunction::EmitOpaqueValueLValue", NM="_ZN5clang7CodeGen15CodeGenFunction21EmitOpaqueValueLValueEPKNS_15OpaqueValueExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction21EmitOpaqueValueLValueEPKNS_15OpaqueValueExprE")
//</editor-fold>
public final LValue EmitOpaqueValueLValue(/*const*/ OpaqueValueExpr /*P*/ e) {
  assert (OpaqueValueMappingData.shouldBindAsLValue(e));
  return new LValue($this().getOpaqueLValueMapping(e));
}


/// @brief Generates lvalue for partial ext_vector access.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitExtVectorElementLValue">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp", line = 1546,
 FQN="clang::CodeGen::CodeGenFunction::EmitExtVectorElementLValue", NM="_ZN5clang7CodeGen15CodeGenFunction26EmitExtVectorElementLValueENS0_6LValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction26EmitExtVectorElementLValueENS0_6LValueE")
//</editor-fold>
public final Address EmitExtVectorElementLValue(LValue LV) {
  Address VectorAddress = LV.getExtVectorAddress();
  /*const*/ org.clang.ast.VectorType /*P*/ ExprVT = LV.getType().$arrow().getAs(org.clang.ast.VectorType.class);
  QualType EQT = ExprVT.getElementType();
  org.llvm.ir.Type /*P*/ VectorElementTy = $this().CGM.getTypes().ConvertType(new QualType(EQT));
  
  Address CastToPointerElement = $this().Builder.CreateElementBitCast(new Address(VectorAddress), VectorElementTy, 
      new Twine(/*KEEP_STR*/"conv.ptr.element"));
  
  /*const*/ Constant /*P*/ Elts = LV.getExtVectorElts();
  /*uint*/int ix = getAccessedFieldNo(0, Elts);
  
  Address VectorBasePtrPlusIx = $this().Builder.CreateConstInBoundsGEP(new Address(CastToPointerElement), $uint2ulong(ix), 
      $this().getContext().getTypeSizeInChars(/*NO_COPY*/EQT), 
      new Twine(/*KEEP_STR*/"vector.elt"));
  
  return VectorBasePtrPlusIx;
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitRValueForField">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp", line = 3709,
 FQN="clang::CodeGen::CodeGenFunction::EmitRValueForField", NM="_ZN5clang7CodeGen15CodeGenFunction18EmitRValueForFieldENS0_6LValueEPKNS_9FieldDeclENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction18EmitRValueForFieldENS0_6LValueEPKNS_9FieldDeclENS_14SourceLocationE")
//</editor-fold>
public final RValue EmitRValueForField(LValue LV, 
                  /*const*/ FieldDecl /*P*/ FD, 
                  SourceLocation Loc) {
  QualType FT = FD.getType();
  LValue FieldLV = $this().EmitLValueForField(new LValue(LV), FD);
  switch (CodeGenFunction.getEvaluationKind(new QualType(FT))) {
   case TEK_Complex:
    return RValue.getComplex($this().EmitLoadOfComplex(new LValue(FieldLV), new SourceLocation(Loc)));
   case TEK_Aggregate:
    return FieldLV.asAggregateRValue();
   case TEK_Scalar:
    // This routine is used to load fields one-by-one to perform a copy, so
    // don't load reference fields.
    if (FD.getType().$arrow().isReferenceType()) {
      return RValue.get(FieldLV.getPointer());
    }
    return $this().EmitLoadOfLValue(new LValue(FieldLV), new SourceLocation(Loc));
  }
  throw new llvm_unreachable("bad evaluation kind");
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitArrayToPointerDecay">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp", line = 2763,
 FQN="clang::CodeGen::CodeGenFunction::EmitArrayToPointerDecay", NM="_ZN5clang7CodeGen15CodeGenFunction23EmitArrayToPointerDecayEPKNS_4ExprEPNS0_15AlignmentSourceE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction23EmitArrayToPointerDecayEPKNS_4ExprEPNS0_15AlignmentSourceE")
//</editor-fold>
public final Address EmitArrayToPointerDecay(/*const*/ Expr /*P*/ E) {
  return EmitArrayToPointerDecay(E, 
                       create_type$null$ptr());
}
public final Address EmitArrayToPointerDecay(/*const*/ Expr /*P*/ E, 
                       type$ptr<AlignmentSource /*P*/> AlignSource/*= null*/) {
  assert (E.getType().$arrow().isArrayType()) : "Array to pointer decay must have array source type!";
  
  // Expressions of array type can't be bitfields or vector elements.
  LValue LV = $this().EmitLValue(E);
  Address Addr = LV.getAddress();
  if ((AlignSource != null)) {
    AlignSource.$set(LV.getAlignmentSource());
  }
  
  // If the array type was an incomplete type, we need to make sure
  // the decay ends up being the right type.
  org.llvm.ir.Type /*P*/ NewTy = $this().ConvertType(E.getType());
  Addr.$assignMove($this().Builder.CreateElementBitCast(new Address(Addr), NewTy));
  
  // Note that VLA pointers are always decayed, so we don't need to do
  // anything here.
  if (!E.getType().$arrow().isVariableArrayType()) {
    assert (isa_ArrayType(Addr.getElementType())) : "Expected pointer to array";
    Addr.$assignMove($this().Builder.CreateStructGEP(new Address(Addr), 0, CharUnits.Zero(), new Twine(/*KEEP_STR*/"arraydecay")));
  }
  
  QualType EltType = E.getType().$arrow().castAsArrayTypeUnsafe().getElementType();
  return $this().Builder.CreateElementBitCast(new Address(Addr), $this().ConvertTypeForMem(new QualType(EltType)));
}


/// Try to emit a reference to the given value without producing it as
/// an l-value.  This is actually more than an optimization: we can't
/// produce an l-value for variables that we never actually captured
/// in a block or lambda, which means const int variables or constexpr
/// literals or similar.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::tryEmitAsConstant">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp", line = 1134,
 FQN="clang::CodeGen::CodeGenFunction::tryEmitAsConstant", NM="_ZN5clang7CodeGen15CodeGenFunction17tryEmitAsConstantEPNS_11DeclRefExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction17tryEmitAsConstantEPNS_11DeclRefExprE")
//</editor-fold>
public final CodeGenFunction.ConstantEmission tryEmitAsConstant(DeclRefExpr /*P*/ refExpr) {
  Expr.EvalResult result = null;
  try {
    ValueDecl /*P*/ value = refExpr.getDecl();
    
    // The value needs to be an enum constant or a constant variable.
    ConstantEmissionKind CEK;
    if (isa_ParmVarDecl(value)) {
      CEK = ConstantEmissionKind.CEK_None;
    } else {
      VarDecl /*P*/ var = dyn_cast_VarDecl(value);
      if ((var != null)) {
        CEK = CGExprStatics.checkVarTypeForConstantEmission(var.getType());
      } else if (isa_EnumConstantDecl(value)) {
        CEK = ConstantEmissionKind.CEK_AsValueOnly;
      } else {
        CEK = ConstantEmissionKind.CEK_None;
      }
    }
    if (CEK == ConstantEmissionKind.CEK_None) {
      return new ConstantEmission();
    }
    
    result/*J*/= new Expr.EvalResult();
    boolean resultIsReference;
    QualType resultType/*J*/= new QualType();
    
    // It's best to evaluate all the way as an r-value if that's permitted.
    if (CEK != ConstantEmissionKind.CEK_AsReferenceOnly
       && refExpr.EvaluateAsRValue(result, $this().getContext())) {
      resultIsReference = false;
      resultType.$assignMove(refExpr.getType());
      // Otherwise, try to evaluate as an l-value.
    } else if (CEK != ConstantEmissionKind.CEK_AsValueOnly
       && refExpr.EvaluateAsLValue(result, $this().getContext())) {
      resultIsReference = true;
      resultType.$assignMove(value.getType());
      // Failure.
    } else {
      return new ConstantEmission();
    }
    
    // In any case, if the initializer has side-effects, abandon ship.
    if (result.HasSideEffects) {
      return new ConstantEmission();
    }
    
    // Emit as a constant.
    Constant /*P*/ C = $this().CGM.EmitConstantValue(result.Val, new QualType(resultType), $this());
    
    // Make sure we emit a debug reference to the global variable.
    // This should probably fire even for
    if (isa_VarDecl(value)) {
      if (!$this().getContext().DeclMustBeEmitted(cast_VarDecl(value))) {
        $this().EmitDeclRefExprDbgValue(refExpr, C);
      }
    } else {
      assert (isa_EnumConstantDecl(value));
      $this().EmitDeclRefExprDbgValue(refExpr, C);
    }
    
    // If we emitted a reference constant, we need to dereference that.
    if (resultIsReference) {
      return ConstantEmission.forReference(C);
    }
    
    return ConstantEmission.forValue(C);
  } finally {
    if (result != null) { result.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitPseudoObjectRValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp", line = 4256,
 FQN="clang::CodeGen::CodeGenFunction::EmitPseudoObjectRValue", NM="_ZN5clang7CodeGen15CodeGenFunction22EmitPseudoObjectRValueEPKNS_16PseudoObjectExprENS0_12AggValueSlotE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction22EmitPseudoObjectRValueEPKNS_16PseudoObjectExprENS0_12AggValueSlotE")
//</editor-fold>
public final RValue EmitPseudoObjectRValue(/*const*/ PseudoObjectExpr /*P*/ E) {
  return EmitPseudoObjectRValue(E, 
                      AggValueSlot.ignored());
}
public final RValue EmitPseudoObjectRValue(/*const*/ PseudoObjectExpr /*P*/ E, 
                      AggValueSlot slot/*= AggValueSlot::ignored()*/) {
  return new RValue(JD$Move.INSTANCE, CGExprStatics.emitPseudoObjectExpr(/*Deref*/$this(), E, false, new AggValueSlot(slot)).RV);
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitPseudoObjectLValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp", line = 4261,
 FQN="clang::CodeGen::CodeGenFunction::EmitPseudoObjectLValue", NM="_ZN5clang7CodeGen15CodeGenFunction22EmitPseudoObjectLValueEPKNS_16PseudoObjectExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction22EmitPseudoObjectLValueEPKNS_16PseudoObjectExprE")
//</editor-fold>
public final LValue EmitPseudoObjectLValue(/*const*/ PseudoObjectExpr /*P*/ E) {
  return new LValue(JD$Move.INSTANCE, CGExprStatics.emitPseudoObjectExpr(/*Deref*/$this(), E, true, AggValueSlot.ignored()).LV);
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitIvarOffset">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp", line = 3940,
 FQN="clang::CodeGen::CodeGenFunction::EmitIvarOffset", NM="_ZN5clang7CodeGen15CodeGenFunction14EmitIvarOffsetEPKNS_17ObjCInterfaceDeclEPKNS_12ObjCIvarDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction14EmitIvarOffsetEPKNS_17ObjCInterfaceDeclEPKNS_12ObjCIvarDeclE")
//</editor-fold>
public final Value /*P*/ EmitIvarOffset(/*const*/ ObjCInterfaceDecl /*P*/ Interface, 
              /*const*/ ObjCIvarDecl /*P*/ Ivar) {
  return $this().CGM.getObjCRuntime().EmitIvarOffset(/*Deref*/$this(), Interface, Ivar);
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitLValueForField">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp", line = 3310,
 FQN="clang::CodeGen::CodeGenFunction::EmitLValueForField", NM="_ZN5clang7CodeGen15CodeGenFunction18EmitLValueForFieldENS0_6LValueEPKNS_9FieldDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction18EmitLValueForFieldENS0_6LValueEPKNS_9FieldDeclE")
//</editor-fold>
public final LValue EmitLValueForField(LValue base, 
                  /*const*/ FieldDecl /*P*/ field) {
  type$ptr<AlignmentSource> fieldAlignSource = create_type$ptr(CodeGenStatics.getFieldAlignmentSource(base.getAlignmentSource()));
  if (field.isBitField()) {
    final /*const*/ CGRecordLayout /*&*/ RL = $this().CGM.getTypes().getCGRecordLayout(field.getParent$Const());
    final /*const*/ CGBitFieldInfo /*&*/ Info = RL.getBitFieldInfo(field);
    Address Addr = base.getAddress();
    /*uint*/int Idx = RL.getLLVMFieldNo(field);
    if (Idx != 0) {
      // For structs, we GEP to the field that the record layout suggests.
      Addr.$assignMove($this().Builder.CreateStructGEP(new Address(Addr), Idx, new CharUnits(Info.StorageOffset), 
              new Twine(field.getName())));
    }
    // Get the access type.
    org.llvm.ir.Type /*P*/ FieldIntTy = org.llvm.ir.Type.getIntNTy($this().getLLVMContext(), Info.StorageSize);
    if (Addr.getElementType() != FieldIntTy) {
      Addr.$assignMove($this().Builder.CreateElementBitCast(new Address(Addr), FieldIntTy));
    }
    
    QualType fieldType = field.getType().withCVRQualifiers(base.getVRQualifiers());
    return LValue.MakeBitfield(new Address(Addr), Info, new QualType(fieldType), fieldAlignSource.$star());
  }
  
  /*const*/ RecordDecl /*P*/ rec = field.getParent$Const();
  QualType type = field.getType();
  
  boolean mayAlias = rec.hasAttr(MayAliasAttr.class);
  
  Address addr = base.getAddress();
  /*uint*/int cvr = base.getVRQualifiers();
  boolean TBAAPath = $this().CGM.getCodeGenOpts().StructPathTBAA;
  if (rec.isUnion()) {
    // For unions, there is no pointer adjustment.
    assert (!type.$arrow().isReferenceType()) : "union has reference member";
    // TODO: handle path-aware TBAA for union.
    TBAAPath = false;
  } else {
    // For structs, we GEP to the field that the record layout suggests.
    addr.$assignMove(CGExprStatics.emitAddrOfFieldStorage(/*Deref*/$this(), new Address(addr), field));
    {
      
      // If this is a reference field, load the reference right now.
      /*const*/ ReferenceType /*P*/ refType = type.$arrow().getAs(ReferenceType.class);
      if ((refType != null)) {
        LoadInst /*P*/ load = $this().Builder.CreateLoad(new Address(addr), $("ref"));
        if (((cvr & Qualifiers.TQ.Volatile) != 0)) {
          load.setVolatile(true);
        }
        
        // Loading the reference will disable path-aware TBAA.
        TBAAPath = false;
        if ($this().CGM.shouldUseTBAA()) {
          MDNode /*P*/ tbaa;
          if (mayAlias) {
            tbaa = $this().CGM.getTBAAInfo($this().getContext().CharTy.$QualType());
          } else {
            tbaa = $this().CGM.getTBAAInfo(new QualType(type));
          }
          if ((tbaa != null)) {
            $this().CGM.DecorateInstructionWithTBAA(load, tbaa);
          }
        }
        
        mayAlias = false;
        type.$assignMove(refType.getPointeeType());
        
        CharUnits alignment = $this().getNaturalTypeAlignment(new QualType(type), $AddrOf(fieldAlignSource), /*pointee*/ true);
        addr.$assignMove(new Address(load, new CharUnits(alignment)));
        
        // Qualifiers on the struct don't apply to the referencee, and
        // we'll pick up CVR from the actual type later, so reset these
        // additional qualifiers now.
        cvr = 0;
      }
    }
  }
  
  // Make sure that the address is pointing to the right type.  This is critical
  // for both unions and structs.  A union needs a bitcast, a struct element
  // will need a bitcast if the LLVM type laid out doesn't match the desired
  // type.
  addr.$assignMove($this().Builder.CreateElementBitCast(new Address(addr), 
          $this().CGM.getTypes().ConvertTypeForMem(new QualType(type)), 
          new Twine(field.getName())));
  if (field.hasAttr(AnnotateAttr.class)) {
    addr.$assignMove($this().EmitFieldAnnotations(field, new Address(addr)));
  }
  
  LValue LV = $this().MakeAddrLValue(new Address(addr), new QualType(type), fieldAlignSource.$star());
  LV.getQuals().addCVRQualifiers(cvr);
  if (TBAAPath) {
    final /*const*/ ASTRecordLayout /*&*/ Layout = $this().getContext().getASTRecordLayout(field.getParent$Const());
    // Set the base type to be the base type of the base LValue and
    // update offset to be relative to the base type.
    LV.setTBAABaseType(mayAlias ? $this().getContext().CharTy.$QualType() : base.getTBAABaseType());
    LV.setTBAAOffset(mayAlias ? $int2ullong(0) : base.getTBAAOffset()
           + $div_ulong(Layout.getFieldOffset(field.getFieldIndex())
          , $this().getContext().getCharWidth()));
  }
  
  // __weak attribute on a field is ignored.
  if (LV.getQuals().getObjCGCAttr() == Qualifiers.GC.Weak) {
    LV.getQuals().removeObjCGCAttr();
  }
  
  // Fields of may_alias structs act like 'char' for TBAA purposes.
  // FIXME: this should get propagated down through anonymous structs
  // and unions.
  if (mayAlias && (LV.getTBAAInfo() != null)) {
    LV.setTBAAInfo($this().CGM.getTBAAInfo($this().getContext().CharTy.$QualType()));
  }
  
  return LV;
}


/// Given that we are currently emitting a lambda, emit an l-value for
/// one of its members.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitLValueForLambdaField">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp", line = 3274,
 FQN="clang::CodeGen::CodeGenFunction::EmitLValueForLambdaField", NM="_ZN5clang7CodeGen15CodeGenFunction24EmitLValueForLambdaFieldEPKNS_9FieldDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction24EmitLValueForLambdaFieldEPKNS_9FieldDeclE")
//</editor-fold>
public final LValue EmitLValueForLambdaField(/*const*/ FieldDecl /*P*/ Field) {
  assert (cast_CXXMethodDecl($this().CurCodeDecl).getParent$Const().isLambda());
  assert (cast_CXXMethodDecl($this().CurCodeDecl).getParent$Const() == Field.getParent$Const());
  QualType LambdaTagType = $this().getContext().getTagDeclType(Field.getParent$Const());
  LValue LambdaLV = $this().MakeNaturalAlignAddrLValue($this().CXXABIThisValue, new QualType(LambdaTagType));
  return $this().EmitLValueForField(new LValue(LambdaLV), Field);
}


/// EmitLValueForFieldInitialization - Like EmitLValueForField, except that
/// if the Field is a reference, this will return the address of the reference
/// and not the address of the value stored in the reference.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitLValueForFieldInitialization">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp", line = 3421,
 FQN="clang::CodeGen::CodeGenFunction::EmitLValueForFieldInitialization", NM="_ZN5clang7CodeGen15CodeGenFunction32EmitLValueForFieldInitializationENS0_6LValueEPKNS_9FieldDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction32EmitLValueForFieldInitializationENS0_6LValueEPKNS_9FieldDeclE")
//</editor-fold>
public final LValue EmitLValueForFieldInitialization(LValue Base, 
                                /*const*/ FieldDecl /*P*/ Field) {
  QualType FieldType = Field.getType();
  if (!FieldType.$arrow().isReferenceType()) {
    return $this().EmitLValueForField(new LValue(Base), Field);
  }
  
  Address V = CGExprStatics.emitAddrOfFieldStorage(/*Deref*/$this(), Base.getAddress(), Field);
  
  // Make sure that the address is pointing to the right type.
  org.llvm.ir.Type /*P*/ llvmType = $this().ConvertTypeForMem(new QualType(FieldType));
  V.$assignMove($this().Builder.CreateElementBitCast(new Address(V), llvmType, new Twine(Field.getName())));
  
  // TODO: access-path TBAA?
  AlignmentSource FieldAlignSource = CodeGenStatics.getFieldAlignmentSource(Base.getAlignmentSource());
  return $this().MakeAddrLValue(new Address(V), new QualType(FieldType), FieldAlignSource);
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitLValueForIvar">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp", line = 3945,
 FQN="clang::CodeGen::CodeGenFunction::EmitLValueForIvar", NM="_ZN5clang7CodeGen15CodeGenFunction17EmitLValueForIvarENS_8QualTypeEPN4llvm5ValueEPKNS_12ObjCIvarDeclEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction17EmitLValueForIvarENS_8QualTypeEPN4llvm5ValueEPKNS_12ObjCIvarDeclEj")
//</editor-fold>
public final LValue EmitLValueForIvar(QualType ObjectTy, 
                 Value /*P*/ BaseValue, 
                 /*const*/ ObjCIvarDecl /*P*/ Ivar, 
                 /*uint*/int CVRQualifiers) {
  return $this().CGM.getObjCRuntime().EmitObjCValueForIvar(/*Deref*/$this(), new QualType(ObjectTy), BaseValue, 
      Ivar, CVRQualifiers);
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitCXXConstructLValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp", line = 3878,
 FQN="clang::CodeGen::CodeGenFunction::EmitCXXConstructLValue", NM="_ZN5clang7CodeGen15CodeGenFunction22EmitCXXConstructLValueEPKNS_16CXXConstructExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction22EmitCXXConstructLValueEPKNS_16CXXConstructExprE")
//</editor-fold>
public final LValue EmitCXXConstructLValue(/*const*/ CXXConstructExpr /*P*/ E) {
  assert (E.getType().$arrow().getAsCXXRecordDecl().hasTrivialDestructor()) : "binding l-value to type which needs a temporary";
  AggValueSlot Slot = $this().CreateAggTemp(E.getType());
  $this().EmitCXXConstructExpr(E, new AggValueSlot(Slot));
  return $this().MakeAddrLValue(Slot.getAddress(), E.getType(), 
      AlignmentSource.Decl);
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitCXXBindTemporaryLValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp", line = 3902,
 FQN="clang::CodeGen::CodeGenFunction::EmitCXXBindTemporaryLValue", NM="_ZN5clang7CodeGen15CodeGenFunction26EmitCXXBindTemporaryLValueEPKNS_20CXXBindTemporaryExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction26EmitCXXBindTemporaryLValueEPKNS_20CXXBindTemporaryExprE")
//</editor-fold>
public final LValue EmitCXXBindTemporaryLValue(/*const*/ CXXBindTemporaryExpr /*P*/ E) {
  AggValueSlot Slot = $this().CreateAggTemp(E.getType(), new Twine(/*KEEP_STR*/"temp.lvalue"));
  Slot.setExternallyDestructed();
  $this().EmitAggExpr(E.getSubExpr$Const(), new AggValueSlot(Slot));
  $this().EmitCXXTemporary(E.getTemporary$Const(), E.getType(), Slot.getAddress());
  return $this().MakeAddrLValue(Slot.getAddress(), E.getType(), 
      AlignmentSource.Decl);
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitLambdaLValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp", line = 3912,
 FQN="clang::CodeGen::CodeGenFunction::EmitLambdaLValue", NM="_ZN5clang7CodeGen15CodeGenFunction16EmitLambdaLValueEPKNS_10LambdaExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction16EmitLambdaLValueEPKNS_10LambdaExprE")
//</editor-fold>
public final LValue EmitLambdaLValue(/*const*/ LambdaExpr /*P*/ E) {
  AggValueSlot Slot = $this().CreateAggTemp(E.getType(), new Twine(/*KEEP_STR*/"temp.lvalue"));
  $this().EmitLambdaExpr(E, new AggValueSlot(Slot));
  return $this().MakeAddrLValue(Slot.getAddress(), E.getType(), 
      AlignmentSource.Decl);
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitCXXTypeidLValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp", line = 3887,
 FQN="clang::CodeGen::CodeGenFunction::EmitCXXTypeidLValue", NM="_ZN5clang7CodeGen15CodeGenFunction19EmitCXXTypeidLValueEPKNS_13CXXTypeidExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction19EmitCXXTypeidLValueEPKNS_13CXXTypeidExprE")
//</editor-fold>
public final LValue EmitCXXTypeidLValue(/*const*/ CXXTypeidExpr /*P*/ E) {
  return $this().MakeNaturalAlignAddrLValue($this().EmitCXXTypeidExpr(E), E.getType());
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitCXXUuidofLValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp", line = 3897,
 FQN="clang::CodeGen::CodeGenFunction::EmitCXXUuidofLValue", NM="_ZN5clang7CodeGen15CodeGenFunction19EmitCXXUuidofLValueEPKNS_13CXXUuidofExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction19EmitCXXUuidofLValueEPKNS_13CXXUuidofExprE")
//</editor-fold>
public final LValue EmitCXXUuidofLValue(/*const*/ CXXUuidofExpr /*P*/ E) {
  return $this().MakeAddrLValue($this().EmitCXXUuidofExpr(E), E.getType(), 
      AlignmentSource.Decl);
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitObjCMessageExprLValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp", line = 3920,
 FQN="clang::CodeGen::CodeGenFunction::EmitObjCMessageExprLValue", NM="_ZN5clang7CodeGen15CodeGenFunction25EmitObjCMessageExprLValueEPKNS_15ObjCMessageExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction25EmitObjCMessageExprLValueEPKNS_15ObjCMessageExprE")
//</editor-fold>
public final LValue EmitObjCMessageExprLValue(/*const*/ ObjCMessageExpr /*P*/ E) {
  RValue RV = $this().EmitObjCMessageExpr(E);
  if (!RV.isScalar()) {
    return $this().MakeAddrLValue(RV.getAggregateAddress(), E.getType(), 
        AlignmentSource.Decl);
  }
  assert (E.getMethodDecl$Const().getReturnType().$arrow().isReferenceType()) : "Can't have a scalar return unless the return type is a reference type!";
  
  return $this().MakeNaturalAlignPointeeAddrLValue(RV.getScalarVal(), E.getType());
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitObjCIvarRefLValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp", line = 3953,
 FQN="clang::CodeGen::CodeGenFunction::EmitObjCIvarRefLValue", NM="_ZN5clang7CodeGen15CodeGenFunction21EmitObjCIvarRefLValueEPKNS_15ObjCIvarRefExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction21EmitObjCIvarRefLValueEPKNS_15ObjCIvarRefExprE")
//</editor-fold>
public final LValue EmitObjCIvarRefLValue(/*const*/ ObjCIvarRefExpr /*P*/ E) {
  // FIXME: A lot of the code below could be shared with EmitMemberExpr.
  Value /*P*/ BaseValue = null;
  /*const*/ Expr /*P*/ BaseExpr = E.getBase$Const();
  Qualifiers BaseQuals/*J*/= new Qualifiers();
  QualType ObjectTy/*J*/= new QualType();
  if (E.isArrow()) {
    BaseValue = $this().EmitScalarExpr(BaseExpr);
    ObjectTy.$assignMove(BaseExpr.getType().$arrow().getPointeeType());
    BaseQuals.$assignMove(ObjectTy.getQualifiers());
  } else {
    LValue BaseLV = $this().EmitLValue(BaseExpr);
    BaseValue = BaseLV.getPointer();
    ObjectTy.$assignMove(BaseExpr.getType());
    BaseQuals.$assignMove(ObjectTy.getQualifiers());
  }
  
  LValue LV = $this().EmitLValueForIvar(new QualType(ObjectTy), BaseValue, E.getDecl$Const(), 
      BaseQuals.getCVRQualifiers());
  CGExprStatics.setObjCGCLValueClass($this().getContext(), E, LV);
  return LV;
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitStmtExprLValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp", line = 3977,
 FQN="clang::CodeGen::CodeGenFunction::EmitStmtExprLValue", NM="_ZN5clang7CodeGen15CodeGenFunction18EmitStmtExprLValueEPKNS_8StmtExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction18EmitStmtExprLValueEPKNS_8StmtExprE")
//</editor-fold>
public final LValue EmitStmtExprLValue(/*const*/ StmtExpr /*P*/ E) {
  // Can only get l-value for message expression returning aggregate type
  RValue RV = $this().EmitAnyExprToTemp(E);
  return $this().MakeAddrLValue(RV.getAggregateAddress(), E.getType(), 
      AlignmentSource.Decl);
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitPointerToDataMemberBinaryExpr">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp", line = 4132,
 FQN="clang::CodeGen::CodeGenFunction::EmitPointerToDataMemberBinaryExpr", NM="_ZN5clang7CodeGen15CodeGenFunction33EmitPointerToDataMemberBinaryExprEPKNS_14BinaryOperatorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction33EmitPointerToDataMemberBinaryExprEPKNS_14BinaryOperatorE")
//</editor-fold>
public final LValue EmitPointerToDataMemberBinaryExpr(/*const*/ org.clang.ast.BinaryOperator /*P*/ E) {
  Address BaseAddr = Address.invalid();
  if (E.getOpcode() == BinaryOperatorKind.BO_PtrMemI) {
    BaseAddr.$assignMove($this().EmitPointerWithAlignment(E.getLHS()));
  } else {
    BaseAddr.$assignMove($this().EmitLValue(E.getLHS()).getAddress());
  }
  
  Value /*P*/ OffsetV = $this().EmitScalarExpr(E.getRHS());
  
  /*const*/ MemberPointerType /*P*/ MPT = E.getRHS().getType().$arrow().getAs(MemberPointerType.class);
  
  type$ptr<AlignmentSource> AlignSource = create_type$null$ptr();
  Address MemberAddr = $this().EmitCXXMemberDataPointerAddress(E, new Address(BaseAddr), OffsetV, MPT, 
      $AddrOf(AlignSource));
  
  return $this().MakeAddrLValue(new Address(MemberAddr), MPT.getPointeeType(), AlignSource.$star());
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitObjCSelectorLValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp", line = 3934,
 FQN="clang::CodeGen::CodeGenFunction::EmitObjCSelectorLValue", NM="_ZN5clang7CodeGen15CodeGenFunction22EmitObjCSelectorLValueEPKNS_16ObjCSelectorExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction22EmitObjCSelectorLValueEPKNS_16ObjCSelectorExprE")
//</editor-fold>
public final LValue EmitObjCSelectorLValue(/*const*/ ObjCSelectorExpr /*P*/ E) {
  Address V = $this().CGM.getObjCRuntime().GetAddrOfSelector(/*Deref*/$this(), E.getSelector());
  return $this().MakeAddrLValue(new Address(V), E.getType(), AlignmentSource.Decl);
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitCall">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp", line = 3984,
 FQN="clang::CodeGen::CodeGenFunction::EmitCall", NM="_ZN5clang7CodeGen15CodeGenFunction8EmitCallENS_8QualTypeEPN4llvm5ValueEPKNS_8CallExprENS0_15ReturnValueSlotENS0_12CGCalleeInfoES5_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction8EmitCallENS_8QualTypeEPN4llvm5ValueEPKNS_8CallExprENS0_15ReturnValueSlotENS0_12CGCalleeInfoES5_")
//</editor-fold>
public final RValue EmitCall(QualType CalleeType, Value /*P*/ Callee, 
        /*const*/ CallExpr /*P*/ E, ReturnValueSlot ReturnValue) {
  return EmitCall(CalleeType, Callee, 
        E, ReturnValue, 
        new CGCalleeInfo(), (Value /*P*/ )null);
}
public final RValue EmitCall(QualType CalleeType, Value /*P*/ Callee, 
        /*const*/ CallExpr /*P*/ E, ReturnValueSlot ReturnValue, 
        CGCalleeInfo CalleeInfo/*= CGCalleeInfo()*/) {
  return EmitCall(CalleeType, Callee, 
        E, ReturnValue, 
        CalleeInfo, (Value /*P*/ )null);
}
public final RValue EmitCall(QualType CalleeType, Value /*P*/ Callee, 
        /*const*/ CallExpr /*P*/ E, ReturnValueSlot ReturnValue, 
        CGCalleeInfo CalleeInfo/*= CGCalleeInfo()*/, Value /*P*/ Chain/*= null*/) {
  CallArgList Args = null;
  try {
    // Get the actual function type. The callee type will always be a pointer to
    // function type or a block pointer type.
    assert (CalleeType.$arrow().isFunctionPointerType()) : "Call must have function pointer type!";
    
    // Preserve the non-canonical function type because things like exception
    // specifications disappear in the canonical type. That information is useful
    // to drive the generation of more accurate code for this call later on.
    /*const*/ FunctionProtoType /*P*/ NonCanonicalFTP = CalleeType.$arrow().getAs(org.clang.ast.PointerType.class).
    getPointeeType().$arrow().getAs(FunctionProtoType.class);
    
    /*const*/ Decl /*P*/ TargetDecl = CalleeInfo.getCalleeDecl();
    {
      
      /*const*/ FunctionDecl /*P*/ FD = dyn_cast_or_null_FunctionDecl(TargetDecl);
      if ((FD != null)) {
        // We can only guarantee that a function is called from the correct
        // context/function based on the appropriate target attributes,
        // so only check in the case where we have both always_inline and target
        // since otherwise we could be making a conditional call after a check for
        // the proper cpu features (and it won't cause code generation issues due to
        // function based code generation).
        if (TargetDecl.hasAttr(AlwaysInlineAttr.class)
           && TargetDecl.hasAttr(TargetAttr.class)) {
          $this().checkTargetFeatures(E, FD);
        }
      }
    }
    
    CalleeType.$assignMove($this().getContext().getCanonicalType(/*NO_COPY*/CalleeType).$QualType());
    
    /*const*/ org.clang.ast.FunctionType /*P*/ FnType = AstTypesRTTI.cast_FunctionType(AstTypesRTTI.cast_PointerType(CalleeType).getPointeeType());
    if ($this().getLangOpts().CPlusPlus && $this().SanOpts.has(SanitizerKind.Function)
       && (!(TargetDecl != null) || !isa_FunctionDecl(TargetDecl))) {
      {
        Constant /*P*/ PrefixSig = $this().CGM.getTargetCodeGenInfo().getUBSanFunctionSignature($this().CGM);
        if ((PrefixSig != null)) {
          SanitizerScope SanScope = null;
          try {
            SanScope/*J*/= new SanitizerScope($this());
            Constant /*P*/ FTRTTIConst = $this().CGM.GetAddrOfRTTIDescriptor(new QualType(FnType, 0), /*ForEH=*/ true);
            org.llvm.ir.Type /*P*/ PrefixStructTyElems[/*2*/] = new org.llvm.ir.Type /*P*/  [/*2*/] {
              PrefixSig.getType(), 
              FTRTTIConst.getType()
            };
            StructType /*P*/ PrefixStructTy = StructType.get($this().CGM.getLLVMContext(), new ArrayRef<org.llvm.ir.Type /*P*/ >(PrefixStructTyElems, true), /*isPacked=*/ true);
            
            Value /*P*/ CalleePrefixStruct = $this().Builder.CreateBitCast(Callee, org.llvm.ir.PointerType.getUnqual(PrefixStructTy));
            Value /*P*/ CalleeSigPtr = $this().Builder.CreateConstGEP2_32(PrefixStructTy, CalleePrefixStruct, 0, 0);
            Value /*P*/ CalleeSig = $this().Builder.CreateAlignedLoad(CalleeSigPtr, /*J:ToBase*/super.getIntAlign());
            Value /*P*/ CalleeSigMatch = $this().Builder.CreateICmpEQ(CalleeSig, PrefixSig);
            
            BasicBlock /*P*/ Cont = $this().createBasicBlock(new Twine(/*KEEP_STR*/"cont"));
            BasicBlock /*P*/ TypeCheck = $this().createBasicBlock(new Twine(/*KEEP_STR*/"typecheck"));
            $this().Builder.CreateCondBr(CalleeSigMatch, TypeCheck, Cont);
            
            $this().EmitBlock(TypeCheck);
            Value /*P*/ CalleeRTTIPtr = $this().Builder.CreateConstGEP2_32(PrefixStructTy, CalleePrefixStruct, 0, 1);
            Value /*P*/ CalleeRTTI = $this().Builder.CreateAlignedLoad(CalleeRTTIPtr, /*J:ToBase*/super.getPointerAlign());
            Value /*P*/ CalleeRTTIMatch = $this().Builder.CreateICmpEQ(CalleeRTTI, FTRTTIConst);
            Constant /*P*/ StaticData[/*2*/] = new Constant /*P*/  [/*2*/] {
              $this().EmitCheckSourceLocation(E.getLocStart()), 
              $this().EmitCheckTypeDescriptor(new QualType(CalleeType))
            };
            $this().EmitCheck(new ArrayRef<std.pairPtrULong<Value /*P*/ >>(std.make_pair_Ptr_ulong(CalleeRTTIMatch, SanitizerKind.Function), false), 
                new StringRef(/*KEEP_STR*/"function_type_mismatch"), new ArrayRef<Constant /*P*/ >(StaticData, true), new ArrayRef<Value /*P*/ >(Callee, true));
            
            $this().Builder.CreateBr(Cont);
            $this().EmitBlock(Cont);
          } finally {
            if (SanScope != null) { SanScope.$destroy(); }
          }
        }
      }
    }
    
    // If we are checking indirect calls and this call is indirect, check that the
    // function pointer is a member of the bit set for the function type.
    if ($this().SanOpts.has(SanitizerKind.CFIICall)
       && (!(TargetDecl != null) || !isa_FunctionDecl(TargetDecl))) {
      SanitizerScope SanScope = null;
      try {
        SanScope/*J*/= new SanitizerScope($this());
        $this().EmitSanitizerStatReport(SanitizerStatKind.SanStat_CFI_ICall);
        
        Metadata /*P*/ MD = $this().CGM.CreateMetadataIdentifierForType(new QualType(FnType, 0));
        Value /*P*/ TypeId = MetadataAsValue.get($this().getLLVMContext(), MD);
        
        Value /*P*/ CastedCallee = $this().Builder.CreateBitCast(Callee, Unnamed_field9.Int8PtrTy);
        Value /*P*/ TypeTest = $this().Builder.CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P($this().CGM.getIntrinsic(ID.type_test), /*{ */new ArrayRef<Value /*P*/ >(new Value /*P*/ /*const*/ [/*2*/] {CastedCallee, TypeId}, true)/* }*/);
        
        ConstantInt /*P*/ CrossDsoTypeId = $this().CGM.CreateCrossDsoCfiTypeId(MD);
        Constant /*P*/ StaticData[/*3*/] = new Constant /*P*/  [/*3*/] {
          ConstantInt.get(Int8Ty, CFITypeCheckKind.CFITCK_ICall.getValue()), 
          $this().EmitCheckSourceLocation(E.getLocStart()), 
          $this().EmitCheckTypeDescriptor(new QualType(FnType, 0))
        };
        if ($this().CGM.getCodeGenOpts().SanitizeCfiCrossDso && (CrossDsoTypeId != null)) {
          $this().EmitCfiSlowPathCheck(SanitizerKind.CFIICall, TypeTest, CrossDsoTypeId, 
              CastedCallee, new ArrayRef<Constant /*P*/ >(StaticData, true));
        } else {
          $this().EmitCheck(new ArrayRef<std.pairPtrULong<Value /*P*/ >>(std.make_pair_Ptr_ulong(TypeTest, SanitizerKind.CFIICall), false), 
              new StringRef(/*KEEP_STR*/"cfi_check_fail"), new ArrayRef<Constant /*P*/ >(StaticData, true), 
              /*{ */new ArrayRef<Value /*P*/ >(new Value /*P*/ /*const*/ [/*2*/] {CastedCallee, UndefValue.get(Unnamed_field8.IntPtrTy)}, true)/* }*/);
        }
      } finally {
        if (SanScope != null) { SanScope.$destroy(); }
      }
    }
    
    Args/*J*/= new CallArgList();
    if ((Chain != null)) {
      Args.add(RValue.get($this().Builder.CreateBitCast(Chain, $this().CGM.Unnamed_field9.VoidPtrTy)), 
          $this().CGM.getContext().VoidPtrTy.$QualType());
    }
    $this().EmitCallArgs(Args, dyn_cast_FunctionProtoType(FnType), E.arguments$Const(), 
        E.getDirectCallee$Const(), /*ParamsToSkip*/ 0);
    
    final /*const*/ CGFunctionInfo /*&*/ FnInfo = $this().CGM.getTypes().arrangeFreeFunctionCall(Args, FnType, /*isChainCall=*/ (Chain != null));
    
    // C99 6.5.2.2p6:
    //   If the expression that denotes the called function has a type
    //   that does not include a prototype, [the default argument
    //   promotions are performed]. If the number of arguments does not
    //   equal the number of parameters, the behavior is undefined. If
    //   the function is defined with a type that includes a prototype,
    //   and either the prototype ends with an ellipsis (, ...) or the
    //   types of the arguments after promotion are not compatible with
    //   the types of the parameters, the behavior is undefined. If the
    //   function is defined with a type that does not include a
    //   prototype, and the types of the arguments after promotion are
    //   not compatible with those of the parameters after promotion,
    //   the behavior is undefined [except in some trivial cases].
    // That is, in the general case, we should assume that a call
    // through an unprototyped function type works like a *non-variadic*
    // call.  The way we make this work is to cast to the exact type
    // of the promoted arguments.
    //
    // Chain calls use this same code path to add the invisible chain parameter
    // to the function type.
    if (isa_FunctionNoProtoType(FnType) || (Chain != null)) {
      org.llvm.ir.Type /*P*/ CalleeTy = $this().getTypes().GetFunctionType(FnInfo);
      CalleeTy = CalleeTy.getPointerTo();
      Callee = $this().Builder.CreateBitCast(Callee, CalleeTy, new Twine(/*KEEP_STR*/"callee.knr.cast"));
    }
    
    return $this().EmitCall(FnInfo, Callee, new ReturnValueSlot(ReturnValue), Args, 
        new CGCalleeInfo(NonCanonicalFTP, TargetDecl));
  } finally {
    if (Args != null) { Args.$destroy(); }
  }
}


//===--------------------------------------------------------------------===//
//                             Expression Emission
//===--------------------------------------------------------------------===//
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitCallExpr">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp", line = 3733,
 FQN="clang::CodeGen::CodeGenFunction::EmitCallExpr", NM="_ZN5clang7CodeGen15CodeGenFunction12EmitCallExprEPKNS_8CallExprENS0_15ReturnValueSlotE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction12EmitCallExprEPKNS_8CallExprENS0_15ReturnValueSlotE")
//</editor-fold>
public final RValue EmitCallExpr(/*const*/ CallExpr /*P*/ E) {
  return EmitCallExpr(E, 
            new ReturnValueSlot());
}
public final RValue EmitCallExpr(/*const*/ CallExpr /*P*/ E, 
            ReturnValueSlot ReturnValue/*= ReturnValueSlot()*/) {
  // Builtins never have block type.
  if (E.getCallee$Const().getType().$arrow().isBlockPointerType()) {
    return $this().EmitBlockCallExpr(E, new ReturnValueSlot(ReturnValue));
  }
  {
    
    /*const*/ CXXMemberCallExpr /*P*/ CE = dyn_cast_CXXMemberCallExpr(E);
    if ((CE != null)) {
      return $this().EmitCXXMemberCallExpr(CE, new ReturnValueSlot(ReturnValue));
    }
  }
  {
    
    /*const*/ CUDAKernelCallExpr /*P*/ CE = dyn_cast_CUDAKernelCallExpr(E);
    if ((CE != null)) {
      return $this().EmitCUDAKernelCallExpr(CE, new ReturnValueSlot(ReturnValue));
    }
  }
  
  /*const*/ Decl /*P*/ TargetDecl = E.getCalleeDecl$Const();
  {
    /*const*/ FunctionDecl /*P*/ FD = dyn_cast_or_null_FunctionDecl(TargetDecl);
    if ((FD != null)) {
      {
        /*uint*/int builtinID = FD.getBuiltinID();
        if ((builtinID != 0)) {
          return $this().EmitBuiltinExpr(FD, builtinID, E, new ReturnValueSlot(ReturnValue));
        }
      }
    }
  }
  {
    
    /*const*/ CXXOperatorCallExpr /*P*/ CE = dyn_cast_CXXOperatorCallExpr(E);
    if ((CE != null)) {
      {
        /*const*/ CXXMethodDecl /*P*/ MD = dyn_cast_or_null_CXXMethodDecl(TargetDecl);
        if ((MD != null)) {
          return $this().EmitCXXOperatorMemberCallExpr(CE, MD, new ReturnValueSlot(ReturnValue));
        }
      }
    }
  }
  {
    
    /*const*/ CXXPseudoDestructorExpr /*P*/ PseudoDtor = dyn_cast_CXXPseudoDestructorExpr(E.getCallee$Const().IgnoreParens$Const());
    if ((PseudoDtor != null)) {
      QualType DestroyedType = PseudoDtor.getDestroyedType();
      if (DestroyedType.hasStrongOrWeakObjCLifetime()) {
        // Automatic Reference Counting:
        //   If the pseudo-expression names a retainable object with weak or
        //   strong lifetime, the object shall be released.
        Expr /*P*/ BaseExpr = PseudoDtor.getBase();
        Address BaseValue = Address.invalid();
        Qualifiers BaseQuals/*J*/= new Qualifiers();
        
        // If this is s.x, emit s as an lvalue. If it is s->x, emit s as a scalar.
        if (PseudoDtor.isArrow()) {
          BaseValue.$assignMove($this().EmitPointerWithAlignment(BaseExpr));
          /*const*/ org.clang.ast.PointerType /*P*/ PTy = BaseExpr.getType().$arrow().getAs(org.clang.ast.PointerType.class);
          BaseQuals.$assignMove(PTy.getPointeeType().getQualifiers());
        } else {
          LValue BaseLV = $this().EmitLValue(BaseExpr);
          BaseValue.$assignMove(BaseLV.getAddress());
          QualType BaseTy = BaseExpr.getType();
          BaseQuals.$assignMove(BaseTy.getQualifiers());
        }
        switch (DestroyedType.getObjCLifetime()) {
         case OCL_None:
         case OCL_ExplicitNone:
         case OCL_Autoreleasing:
          break;
         case OCL_Strong:
          $this().EmitARCRelease($this().Builder.CreateLoad(new Address(BaseValue), 
                  PseudoDtor.getDestroyedType().isVolatileQualified()), 
              ARCPreciseLifetime_t.ARCPreciseLifetime);
          break;
         case OCL_Weak:
          $this().EmitARCDestroyWeak(new Address(BaseValue));
          break;
        }
      } else {
        // C++ [expr.pseudo]p1:
        //   The result shall only be used as the operand for the function call
        //   operator (), and the result of such a call has type void. The only
        //   effect is the evaluation of the postfix-expression before the dot or
        //   arrow.
        $this().EmitScalarExpr(E.getCallee$Const());
      }
      
      return RValue.get((Value /*P*/ )null);
    }
  }
  
  Value /*P*/ Callee = $this().EmitScalarExpr(E.getCallee$Const());
  return $this().EmitCall(E.getCallee$Const().getType(), Callee, E, new ReturnValueSlot(ReturnValue), 
      new CGCalleeInfo(TargetDecl));
}


/// \brief Emits a reference binding to the passed in expression.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitReferenceBindingToExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp", line = 484,
 FQN="clang::CodeGen::CodeGenFunction::EmitReferenceBindingToExpr", NM="_ZN5clang7CodeGen15CodeGenFunction26EmitReferenceBindingToExprEPKNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction26EmitReferenceBindingToExprEPKNS_4ExprE")
//</editor-fold>
public final RValue EmitReferenceBindingToExpr(/*const*/ Expr /*P*/ E) {
  // Emit the expression as an lvalue.
  LValue LV = $this().EmitLValue(E);
  assert (LV.isSimple());
  Value /*P*/ $Value = LV.getPointer();
  if ($this().sanitizePerformTypeCheck() && !E.getType().$arrow().isFunctionType()) {
    // C++11 [dcl.ref]p5 (as amended by core issue 453):
    //   If a glvalue to which a reference is directly bound designates neither
    //   an existing object or function of an appropriate type nor a region of
    //   storage of suitable size and alignment to contain an object of the
    //   reference's type, the behavior is undefined.
    QualType Ty = E.getType();
    $this().EmitTypeCheck(TypeCheckKind.TCK_ReferenceBinding, E.getExprLoc(), $Value, new QualType(Ty));
  }
  
  return RValue.get($Value);
}


/// \brief Emit a description of a type in a format suitable for passing to
/// a runtime sanitizer handler.

/// Emit a type description suitable for use by a runtime sanitizer library. The
/// format of a type descriptor is
///
/// \code
///   { i16 TypeKind, i16 TypeInfo }
/// \endcode
///
/// followed by an array of i8 containing the type name. TypeKind is 0 for an
/// integer, 1 for a floating point value, and -1 for anything else.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitCheckTypeDescriptor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp", line = 2310,
 FQN="clang::CodeGen::CodeGenFunction::EmitCheckTypeDescriptor", NM="_ZN5clang7CodeGen15CodeGenFunction23EmitCheckTypeDescriptorENS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction23EmitCheckTypeDescriptorENS_8QualTypeE")
//</editor-fold>
public final Constant /*P*/ EmitCheckTypeDescriptor(QualType T) {
  {
    // Only emit each type's descriptor once.
    Constant /*P*/ C = $this().CGM.getTypeDescriptorFromMap(new QualType(T));
    if ((C != null)) {
      return C;
    }
  }
  
  /*uint16_t*/char TypeKind = $int2ushort(-1);
  /*uint16_t*/char TypeInfo = $int2ushort(0);
  if (T.$arrow().isIntegerType()) {
    TypeKind = $int2ushort(0);
    TypeInfo = $uint2ushort((llvm.Log2_32($ulong2uint($this().getContext().getTypeSize(new QualType(T)))) << 1)
       | (T.$arrow().isSignedIntegerType() ? 1 : 0));
  } else if (T.$arrow().isFloatingType()) {
    TypeKind = $int2ushort(1);
    TypeInfo = $ulong2ushort($this().getContext().getTypeSize(new QualType(T)));
  }
  
  // Format the type name as if for a diagnostic, including quotes and
  // optionally an 'aka'.
  SmallString/*<32>*/ Buffer/*J*/= new SmallString/*<32>*/(32);
  $this().CGM.getDiags().ConvertArgToString(DiagnosticsEngine.ArgumentKind.ak_qualtype, 
      (Object/*intptr_t*/)T.getAsOpaquePtr(), 
      new StringRef(), new StringRef(), new ArrayRef<std.pair<DiagnosticsEngine.ArgumentKind, ?/*,intptr_t*/>>(None, false), Buffer, 
      new ArrayRef<Object/*intptr_t*/>(None));
  
  Constant /*P*/ Components[/*3*/] = new Constant /*P*/  [/*3*/] {
    $this().Builder.getInt16(TypeKind), $this().Builder.getInt16(TypeInfo), 
    ConstantDataArray.getString($this().getLLVMContext(), Buffer.$StringRef())
  };
  Constant /*P*/ Descriptor = ConstantStruct.getAnon(new ArrayRef<Constant /*P*/ >(Components, true));
  
  GlobalVariable /*P*/ GV = /*NEW_EXPR [GlobalVariable::new]*/GlobalVariable.$new_GlobalVariable((type$ptr<?> New$Mem)->{
      return new GlobalVariable($this().CGM.getModule(), Descriptor.getType(), 
              /*isConstant=*/ true, GlobalVariable.LinkageTypes.PrivateLinkage, Descriptor);
   });
  GV.setUnnamedAddr(GlobalValue.UnnamedAddr.Global);
  $this().CGM.getSanitizerMetadata().disableSanitizerForGlobal(GV);
  
  // Remember the descriptor for this type.
  $this().CGM.setTypeDescriptorInMap(new QualType(T), GV);
  
  return GV;
}


/// \brief Convert a value into a format suitable for passing to a runtime
/// sanitizer handler.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitCheckValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp", line = 2353,
 FQN="clang::CodeGen::CodeGenFunction::EmitCheckValue", NM="_ZN5clang7CodeGen15CodeGenFunction14EmitCheckValueEPN4llvm5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction14EmitCheckValueEPN4llvm5ValueE")
//</editor-fold>
public final Value /*P*/ EmitCheckValue(Value /*P*/ V) {
  org.llvm.ir.Type /*P*/ TargetTy = Unnamed_field8.IntPtrTy;
  
  // Floating-point types which fit into intptr_t are bitcast to integers
  // and then passed directly (after zero-extension, if necessary).
  if (V.getType().isFloatingPointTy()) {
    /*uint*/int Bits = V.getType().getPrimitiveSizeInBits();
    if ($lesseq_uint(Bits, TargetTy.getIntegerBitWidth())) {
      V = $this().Builder.CreateBitCast(V, org.llvm.ir.Type.getIntNTy($this().getLLVMContext(), 
              Bits));
    }
  }
  
  // Integers which fit in intptr_t are zero-extended and passed directly.
  if (V.getType().isIntegerTy()
     && $lesseq_uint(V.getType().getIntegerBitWidth(), TargetTy.getIntegerBitWidth())) {
    return $this().Builder.CreateZExt(V, TargetTy);
  }
  
  // Pointers are passed directly, everything else is passed by address.
  if (!V.getType().isPointerTy()) {
    Address Ptr = $this().CreateDefaultAlignTempAlloca(V.getType());
    $this().Builder.CreateStore(V, new Address(Ptr));
    V = Ptr.getPointer();
  }
  return $this().Builder.CreatePtrToInt(V, TargetTy);
}


/// \brief Emit a description of a source location in a format suitable for
/// passing to a runtime sanitizer handler.

/// \brief Emit a representation of a SourceLocation for passing to a handler
/// in a sanitizer runtime library. The format for this data is:
/// \code
///   struct SourceLocation {
///     const char *Filename;
///     int32_t Line, Column;
///   };
/// \endcode
/// For an invalid SourceLocation, the Filename pointer is null.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitCheckSourceLocation">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp", line = 2388,
 FQN="clang::CodeGen::CodeGenFunction::EmitCheckSourceLocation", NM="_ZN5clang7CodeGen15CodeGenFunction23EmitCheckSourceLocationENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction23EmitCheckSourceLocationENS_14SourceLocationE")
//</editor-fold>
public final Constant /*P*/ EmitCheckSourceLocation(SourceLocation Loc) {
  Constant /*P*/ Filename;
  int Line;
  int Column;
  
  PresumedLoc PLoc = $this().getContext().getSourceManager().getPresumedLoc(/*NO_COPY*/Loc);
  if (PLoc.isValid()) {
    StringRef FilenameString = new StringRef(PLoc.getFilename());
    
    int PathComponentsToStrip = $this().CGM.getCodeGenOpts().EmitCheckPathComponentsToStrip;
    if (PathComponentsToStrip < 0) {
      assert (PathComponentsToStrip != (-2147483647 - 1));
      int PathComponentsToKeep = -PathComponentsToStrip;
      org.llvm.support.sys.path.reverse_iterator I = rbegin(/*NO_COPY*/FilenameString);
      org.llvm.support.sys.path.reverse_iterator E = rend(/*NO_COPY*/FilenameString);
      while (I.$noteq(E) && (--PathComponentsToKeep != 0)) {
        I.$preInc();
      }
      
      FilenameString.$assignMove(FilenameString.substr(I.$sub(E)));
    } else if (PathComponentsToStrip > 0) {
      org.llvm.support.sys.path.const_iterator I = path.begin(/*NO_COPY*/FilenameString);
      org.llvm.support.sys.path.const_iterator E = path.end(/*NO_COPY*/FilenameString);
      while (I.$noteq(E) && ((PathComponentsToStrip--) != 0)) {
        I.$preInc();
      }
      if (I.$noteq(E)) {
        FilenameString.$assignMove(
            FilenameString.substr(I.$sub(path.begin(/*NO_COPY*/FilenameString)))
        );
      } else {
        FilenameString.$assignMove(path.filename(/*NO_COPY*/FilenameString));
      }
    }
    
    ConstantAddress FilenameGV = $this().CGM.GetAddrOfConstantCString(FilenameString.$string(), $(".src"));
    $this().CGM.getSanitizerMetadata().disableSanitizerForGlobal(cast_GlobalVariable(FilenameGV.getPointer()));
    Filename = FilenameGV.getPointer();
    Line = PLoc.getLine();
    Column = PLoc.getColumn();
  } else {
    Filename = Constant.getNullValue(Unnamed_field9.Int8PtrTy);
    Line = Column = 0;
  }
  
  Constant /*P*/ Data[/*3*/] = new Constant /*P*/  [/*3*/] {
    Filename, $this().Builder.getInt32(Line), 
    $this().Builder.getInt32(Column)};
  
  return ConstantStruct.getAnon(new ArrayRef<Constant /*P*/ >(Data, true));
}


/// \brief Create a basic block that will call a handler function in a
/// sanitizer runtime with the provided arguments, and create a conditional
/// branch to it.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitCheck">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp", line = 2497,
 FQN="clang::CodeGen::CodeGenFunction::EmitCheck", NM="_ZN5clang7CodeGen15CodeGenFunction9EmitCheckEN4llvm8ArrayRefISt4pairIPNS2_5ValueEyEEENS2_9StringRefENS3_IPNS2_8ConstantEEENS3_IS6_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction9EmitCheckEN4llvm8ArrayRefISt4pairIPNS2_5ValueEyEEENS2_9StringRefENS3_IPNS2_8ConstantEEENS3_IS6_EE")
//</editor-fold>
public final void EmitCheck(ArrayRef<std.pairPtrULong<Value /*P*/ >> Checked, 
         StringRef CheckName, ArrayRef<Constant /*P*/ > StaticArgs, 
         ArrayRef<Value /*P*/ > DynamicArgs) {
  assert ($this().IsSanitizerScope);
  assert ($greater_uint(Checked.size(), 0));
  
  type$ref<Value /*P*/> FatalCond = create_type$ref();
  type$ref<Value /*P*/> RecoverableCond = create_type$ref();
  type$ref<Value /*P*/> TrapCond = create_type$ref();
  for (int i = 0, n = Checked.size(); i < n; ++i) {
    Value /*P*/ Check = Checked.$at(i).first;
    // -fsanitize-trap= overrides -fsanitize-recover=.
    final type$ref<Value /*P*/ /*&*/> Cond = $this().CGM.getCodeGenOpts().SanitizeTrap.has(Checked.$at(i).second) ? TrapCond : $this().CGM.getCodeGenOpts().SanitizeRecover.has(Checked.$at(i).second) ? RecoverableCond : FatalCond;
    Cond.$set((Cond.$deref() != null) ? $this().Builder.CreateAnd(Cond.$deref(), Check) : Check);
  }
  if ((TrapCond != null)) {
    $this().EmitTrapCheck(TrapCond.$deref());
  }
  if (!(FatalCond != null) && !(RecoverableCond != null)) {
    return;
  }
  
  Value /*P*/ JointCond;
  if ((FatalCond != null) && (RecoverableCond != null)) {
    JointCond = $this().Builder.CreateAnd(FatalCond.$deref(), RecoverableCond.$deref());
  } else {
    JointCond = (FatalCond.$deref() != null) ? FatalCond.$deref() : RecoverableCond.$deref();
  }
  assert Native.$bool(JointCond);
  
  CheckRecoverableKind RecoverKind = CGExprStatics.getRecoverableKind(Checked.$at(0).second);
  assert ($this().SanOpts.has(Checked.$at(0).second));
  for (int i = 1, n = Checked.size(); i < n; ++i) {
    assert (RecoverKind == CGExprStatics.getRecoverableKind(Checked.$at(i).second)) : "All recoverable kinds in a single check must be same!";
    assert ($this().SanOpts.has(Checked.$at(i).second));
  }
  
  BasicBlock /*P*/ Cont = $this().createBasicBlock(new Twine(/*KEEP_STR*/"cont"));
  BasicBlock /*P*/ Handlers = $this().createBasicBlock($add_char$ptr$C_StringRef$C(/*KEEP_STR*/"handler.", CheckName));
  Instruction /*P*/ Branch = $this().Builder.CreateCondBr(JointCond, Cont, Handlers);
  // Give hint that we very much don't expect to execute the handler
  // Value chosen to match UR_NONTAKEN_WEIGHT, see BranchProbabilityInfo.cpp
  MDBuilder MDHelper/*J*/= new MDBuilder($this().getLLVMContext());
  MDNode /*P*/ Node = MDHelper.createBranchWeights((1/*U*/ << 20) - 1, 1);
  Branch.setMetadata(LLVMContext.Unnamed_enum.MD_prof.getValue(), Node);
  $this().EmitBlock(Handlers);
  
  // Handler functions take an i8* pointing to the (handler-specific) static
  // information block, followed by a sequence of intptr_t arguments
  // representing operand values.
  SmallVector<Value /*P*/ > Args/*J*/= new SmallVector<Value /*P*/ >(4, (Value /*P*/ )null);
  SmallVector<org.llvm.ir.Type /*P*/ > ArgTypes/*J*/= new SmallVector<org.llvm.ir.Type /*P*/ >(4, (org.llvm.ir.Type /*P*/ )null);
  Args.reserve(DynamicArgs.size() + 1);
  ArgTypes.reserve(DynamicArgs.size() + 1);
  
  // Emit handler arguments and create handler function type.
  if (!StaticArgs.empty()) {
    Constant /*P*/ Info = ConstantStruct.getAnon(new ArrayRef<Constant /*P*/ >(StaticArgs));
    GlobalVariable /*P*/ InfoPtr = /*NEW_EXPR [GlobalVariable::new]*/GlobalVariable.$new_GlobalVariable((type$ptr<?> New$Mem)->{
        return new GlobalVariable($this().CGM.getModule(), Info.getType(), false, 
                GlobalVariable.LinkageTypes.PrivateLinkage, Info);
     });
    InfoPtr.setUnnamedAddr(GlobalValue.UnnamedAddr.Global);
    $this().CGM.getSanitizerMetadata().disableSanitizerForGlobal(InfoPtr);
    Args.push_back($this().Builder.CreateBitCast(InfoPtr, Unnamed_field9.Int8PtrTy));
    ArgTypes.push_back(Unnamed_field9.Int8PtrTy);
  }
  
  for (/*size_t*/int i = 0, n = DynamicArgs.size(); i != n; ++i) {
    Args.push_back($this().EmitCheckValue(DynamicArgs.$at(i)));
    ArgTypes.push_back(Unnamed_field8.IntPtrTy);
  }
  
  org.llvm.ir.FunctionType /*P*/ FnType = org.llvm.ir.FunctionType.get($this().CGM.VoidTy, new ArrayRef<org.llvm.ir.Type /*P*/ >(ArgTypes, true), false);
  if (!(FatalCond != null) || !(RecoverableCond != null)) {
    // Simple case: we need to generate a single handler call, either
    // fatal, or non-fatal.
    CGExprStatics.emitCheckHandlerCall(/*Deref*/$this(), FnType, new ArrayRef<Value /*P*/ >(Args, true), new StringRef(CheckName), RecoverKind, 
        (FatalCond != (Value /*P*/ )null), Cont);
  } else {
    // Emit two handler calls: first one for set of unrecoverable checks,
    // another one for recoverable.
    BasicBlock /*P*/ NonFatalHandlerBB = $this().createBasicBlock($add_char$ptr$C_StringRef$C(/*KEEP_STR*/"non_fatal.", CheckName));
    BasicBlock /*P*/ FatalHandlerBB = $this().createBasicBlock($add_char$ptr$C_StringRef$C(/*KEEP_STR*/"fatal.", CheckName));
    $this().Builder.CreateCondBr(FatalCond.$deref(), NonFatalHandlerBB, FatalHandlerBB);
    $this().EmitBlock(FatalHandlerBB);
    CGExprStatics.emitCheckHandlerCall(/*Deref*/$this(), FnType, new ArrayRef<Value /*P*/ >(Args, true), new StringRef(CheckName), RecoverKind, true, 
        NonFatalHandlerBB);
    $this().EmitBlock(NonFatalHandlerBB);
    CGExprStatics.emitCheckHandlerCall(/*Deref*/$this(), FnType, new ArrayRef<Value /*P*/ >(Args, true), new StringRef(CheckName), RecoverKind, false, 
        Cont);
  }
  
  $this().EmitBlock(Cont);
}


/// \brief Emit a slow path cross-DSO CFI check which calls __cfi_slowpath
/// if Cond if false.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitCfiSlowPathCheck">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp", line = 2602,
 FQN="clang::CodeGen::CodeGenFunction::EmitCfiSlowPathCheck", NM="_ZN5clang7CodeGen15CodeGenFunction20EmitCfiSlowPathCheckEyPN4llvm5ValueEPNS2_11ConstantIntES4_NS2_8ArrayRefIPNS2_8ConstantEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction20EmitCfiSlowPathCheckEyPN4llvm5ValueEPNS2_11ConstantIntES4_NS2_8ArrayRefIPNS2_8ConstantEEE")
//</editor-fold>
public final void EmitCfiSlowPathCheck(long/*uint64_t*/ Kind, Value /*P*/ Cond, ConstantInt /*P*/ TypeId, 
                    Value /*P*/ Ptr, ArrayRef<Constant /*P*/ > StaticArgs) {
  BasicBlock /*P*/ Cont = $this().createBasicBlock(new Twine(/*KEEP_STR*/"cfi.cont"));
  
  BasicBlock /*P*/ CheckBB = $this().createBasicBlock(new Twine(/*KEEP_STR*/"cfi.slowpath"));
  BranchInst /*P*/ BI = $this().Builder.CreateCondBr(Cond, Cont, CheckBB);
  
  MDBuilder MDHelper/*J*/= new MDBuilder($this().getLLVMContext());
  MDNode /*P*/ Node = MDHelper.createBranchWeights((1/*U*/ << 20) - 1, 1);
  BI.setMetadata(LLVMContext.Unnamed_enum.MD_prof.getValue(), Node);
  
  $this().EmitBlock(CheckBB);
  
  boolean WithDiag = !$this().CGM.getCodeGenOpts().SanitizeTrap.has(Kind);
  
  CallInst /*P*/ CheckCall;
  if (WithDiag) {
    Constant /*P*/ Info = ConstantStruct.getAnon(new ArrayRef<Constant /*P*/ >(StaticArgs));
    GlobalVariable /*P*/ InfoPtr = /*NEW_EXPR [GlobalVariable::new]*/GlobalVariable.$new_GlobalVariable((type$ptr<?> New$Mem)->{
        return new GlobalVariable($this().CGM.getModule(), Info.getType(), false, 
                GlobalVariable.LinkageTypes.PrivateLinkage, Info);
     });
    InfoPtr.setUnnamedAddr(GlobalValue.UnnamedAddr.Global);
    $this().CGM.getSanitizerMetadata().disableSanitizerForGlobal(InfoPtr);
    
    Constant /*P*/ SlowPathDiagFn = $this().CGM.getModule().getOrInsertFunction(new StringRef(/*KEEP_STR*/"__cfi_slowpath_diag"), 
        org.llvm.ir.FunctionType.get(VoidTy, /*{ */new ArrayRef<org.llvm.ir.Type /*P*/ >(new org.llvm.ir.Type /*P*/ /*const*/ [/*3*/] {Int64Ty, Unnamed_field9.Int8PtrTy, Unnamed_field9.Int8PtrTy}, true)/* }*/, 
            false));
    CheckCall = $this().Builder.CreateCall_Value$P_ArrayRef$Value$P_Twine$C_MDNode$P(SlowPathDiagFn, 
        /*{ */new ArrayRef<Value /*P*/ >(new Value /*P*/ /*const*/ [/*3*/] {TypeId, Ptr, $this().Builder.CreateBitCast(InfoPtr, Unnamed_field9.Int8PtrTy)}, true)/* }*/);
  } else {
    Constant /*P*/ SlowPathFn = $this().CGM.getModule().getOrInsertFunction(new StringRef(/*KEEP_STR*/"__cfi_slowpath"), 
        org.llvm.ir.FunctionType.get(VoidTy, /*{ */new ArrayRef<org.llvm.ir.Type /*P*/ >(new org.llvm.ir.Type /*P*/ /*const*/ [/*2*/] {Int64Ty, Unnamed_field9.Int8PtrTy}, true)/* }*/, false));
    CheckCall = $this().Builder.CreateCall_Value$P_ArrayRef$Value$P_Twine$C_MDNode$P(SlowPathFn, /*{ */new ArrayRef<Value /*P*/ >(new Value /*P*/ /*const*/ [/*2*/] {TypeId, Ptr}, true)/* }*/);
  }
  
  CheckCall.setDoesNotThrow();
  
  $this().EmitBlock(Cont);
}


/// \brief Create a basic block that will call the trap intrinsic, and emit a
/// conditional branch to it, for the -ftrapv checks.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitTrapCheck">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp", line = 2732,
 FQN="clang::CodeGen::CodeGenFunction::EmitTrapCheck", NM="_ZN5clang7CodeGen15CodeGenFunction13EmitTrapCheckEPN4llvm5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction13EmitTrapCheckEPN4llvm5ValueE")
//</editor-fold>
public final void EmitTrapCheck(Value /*P*/ Checked) {
  BasicBlock /*P*/ Cont = $this().createBasicBlock(new Twine(/*KEEP_STR*/"cont"));
  
  // If we're optimizing, collapse all calls to trap down to just one per
  // function to save on code size.
  if (!($2bits_uint2uint($this().CGM.getCodeGenOpts().OptimizationLevel) != 0) || !($this().TrapBB != null)) {
    $this().TrapBB = $this().createBasicBlock(new Twine(/*KEEP_STR*/"trap"));
    $this().Builder.CreateCondBr(Checked, Cont, $this().TrapBB);
    $this().EmitBlock($this().TrapBB);
    CallInst /*P*/ TrapCall = $this().EmitTrapCall(ID.trap);
    TrapCall.setDoesNotReturn();
    TrapCall.setDoesNotThrow();
    $this().Builder.CreateUnreachable();
  } else {
    $this().Builder.CreateCondBr(Checked, Cont, $this().TrapBB);
  }
  
  $this().EmitBlock(Cont);
}


/// \brief Emit a call to trap or debugtrap and attach function attribute
/// "trap-func-name" if specified.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitTrapCall">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp", line = 2752,
 FQN="clang::CodeGen::CodeGenFunction::EmitTrapCall", NM="_ZN5clang7CodeGen15CodeGenFunction12EmitTrapCallEN4llvm9Intrinsic2IDE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction12EmitTrapCallEN4llvm9Intrinsic2IDE")
//</editor-fold>
public final CallInst /*P*/ EmitTrapCall(/*Intrinsic.ID*/int IntrID) {
  CallInst /*P*/ TrapCall = $this().Builder.CreateCall_Value$P_ArrayRef$Value$P_Twine$C_MDNode$P($this().CGM.getIntrinsic(IntrID));
  if (!$this().CGM.getCodeGenOpts().TrapFuncName.empty()) {
    TrapCall.addAttribute(AttributeSet.AttrIndex.FunctionIndex.getValue(), 
        new StringRef(/*KEEP_STR*/"trap-func-name"), 
        new StringRef($this().CGM.getCodeGenOpts().TrapFuncName));
  }
  
  return TrapCall;
}


/// \brief Emit a cross-DSO CFI failure handling function.

// This function is basically a switch over the CFI failure kind, which is
// extracted from CFICheckFailData (1st function argument). Each case is either
// llvm.trap or a call to one of the two runtime handlers, based on
// -fsanitize-trap and -fsanitize-recover settings.  Default case (invalid
// failure kind) traps, but this should really never happen.  CFICheckFailData
// can be nullptr if the calling module has -fsanitize-trap behavior for this
// check kind; in this case __cfi_check_fail traps as well.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitCfiCheckFail">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp", line = 2653,
 FQN="clang::CodeGen::CodeGenFunction::EmitCfiCheckFail", NM="_ZN5clang7CodeGen15CodeGenFunction16EmitCfiCheckFailEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction16EmitCfiCheckFailEv")
//</editor-fold>
public final void EmitCfiCheckFail() {
  SanitizerScope SanScope = null;
  FunctionArgList Args = null;
  ImplicitParamDecl ArgData = null;
  ImplicitParamDecl ArgAddr = null;
  try {
    SanScope/*J*/= new SanitizerScope($this());
    Args/*J*/= new FunctionArgList();
    ArgData/*J*/= new ImplicitParamDecl($this().getContext(), (DeclContext /*P*/ )null, new SourceLocation(), (IdentifierInfo /*P*/ )null, 
        $this().getContext().VoidPtrTy.$QualType());
    ArgAddr/*J*/= new ImplicitParamDecl($this().getContext(), (DeclContext /*P*/ )null, new SourceLocation(), (IdentifierInfo /*P*/ )null, 
        $this().getContext().VoidPtrTy.$QualType());
    Args.push_back($AddrOf(ArgData));
    Args.push_back($AddrOf(ArgAddr));
    
    final /*const*/ CGFunctionInfo /*&*/ FI = $this().CGM.getTypes().arrangeBuiltinFunctionDeclaration($this().getContext().VoidTy.$QualType(), Args);
    
    Function /*P*/ F = Function.Create(org.llvm.ir.FunctionType.get(VoidTy, /*{ */new ArrayRef<org.llvm.ir.Type /*P*/ >(new org.llvm.ir.Type /*P*/ /*const*/ [/*2*/] {Unnamed_field9.VoidPtrTy, Unnamed_field9.VoidPtrTy}, true)/* }*/, false), 
        GlobalValue.LinkageTypes.WeakODRLinkage, new Twine(/*KEEP_STR*/"__cfi_check_fail"), $AddrOf($this().CGM.getModule()));
    F.setVisibility(GlobalValue.VisibilityTypes.HiddenVisibility);
    
    $this().StartFunction(new GlobalDecl(), $this().CGM.getContext().VoidTy.$QualType(), F, FI, Args, 
        new SourceLocation());
    
    Value /*P*/ Data = $this().EmitLoadOfScalar($this().GetAddrOfLocalVar($AddrOf(ArgData)), /*Volatile=*/ false, 
        $this().CGM.getContext().VoidPtrTy.$QualType(), ArgData.getLocation());
    Value /*P*/ Addr = $this().EmitLoadOfScalar($this().GetAddrOfLocalVar($AddrOf(ArgAddr)), /*Volatile=*/ false, 
        $this().CGM.getContext().VoidPtrTy.$QualType(), ArgAddr.getLocation());
    
    // Data == nullptr means the calling module has trap behaviour for this check.
    Value /*P*/ DataIsNotNullPtr = $this().Builder.CreateICmpNE(Data, ConstantPointerNull.get(Unnamed_field9.Int8PtrTy));
    $this().EmitTrapCheck(DataIsNotNullPtr);
    
    StructType /*P*/ SourceLocationTy = StructType.get(Unnamed_field9.VoidPtrTy, Int32Ty, Int32Ty, null);
    StructType /*P*/ CfiCheckFailDataTy = StructType.get(Int8Ty, SourceLocationTy, Unnamed_field9.VoidPtrTy, null);
    
    Value /*P*/ V = $this().Builder.CreateConstGEP2_32(CfiCheckFailDataTy, 
        $this().Builder.CreatePointerCast(Data, CfiCheckFailDataTy.getPointerTo(0)), 0, 
        0);
    Address CheckKindAddr/*J*/= new Address(V, /*J:ToBase*/super.getIntAlign());
    Value /*P*/ CheckKind = $this().Builder.CreateLoad(new Address(CheckKindAddr));
    
    Value /*P*/ AllVtables = MetadataAsValue.get($this().CGM.getLLVMContext(), 
        MDString.get($this().CGM.getLLVMContext(), $("all-vtables")));
    Value /*P*/ ValidVtable = $this().Builder.CreateZExt($this().Builder.CreateCall_Function$P_ArrayRef$Value$P_Twine$C_MDNode$P($this().CGM.getIntrinsic(ID.type_test), 
            /*{ */new ArrayRef<Value /*P*/ >(new Value /*P*/ /*const*/ [/*2*/] {Addr, AllVtables}, true)/* }*/), 
        Unnamed_field8.IntPtrTy);
    
    std.pairTypeLong<CFITypeCheckKind> CheckKinds[/*5*/] = new /*const*/ std.pairTypeLong [/*5*/] {
      new std.pairTypeLong<CFITypeCheckKind>(CFITypeCheckKind.CFITCK_VCall, SanitizerKind.CFIVCall), 
      new std.pairTypeLong<CFITypeCheckKind>(CFITypeCheckKind.CFITCK_NVCall, SanitizerKind.CFINVCall), 
      new std.pairTypeLong<CFITypeCheckKind>(CFITypeCheckKind.CFITCK_DerivedCast, SanitizerKind.CFIDerivedCast), 
      new std.pairTypeLong<CFITypeCheckKind>(CFITypeCheckKind.CFITCK_UnrelatedCast, SanitizerKind.CFIUnrelatedCast), 
      new std.pairTypeLong<CFITypeCheckKind>(CFITypeCheckKind.CFITCK_ICall, SanitizerKind.CFIICall)};
    
    SmallVector<std.pairPtrULong<Value /*P*/ >> Checks/*J*/= new SmallVector<std.pairPtrULong<Value /*P*/ >>(5, new std.pairPtrULong<Value /*P*/ >());
    for (std.pairTypeLong<CFITypeCheckKind> CheckKindMaskPair : CheckKinds) {
      int Kind = CheckKindMaskPair.first.getValue();
      long/*uint64_t*/ Mask = CheckKindMaskPair.second;
      Value /*P*/ Cond = $this().Builder.CreateICmpNE(CheckKind, ConstantInt.get(Int8Ty, $int2ulong(Kind)));
      if ($this().CGM.getLangOpts().Sanitize.has(Mask)) {
        $this().EmitCheck(new ArrayRef<std.pairPtrULong<Value /*P*/ >>(std.make_pair_Ptr_ulong(Cond, Mask), false), new StringRef(/*KEEP_STR*/"cfi_check_fail"), /*{ */new ArrayRef<Constant /*P*/ >(true)/* }*/, 
            /*{ */new ArrayRef<Value /*P*/ >(new Value /*P*/ /*const*/ [/*3*/] {Data, Addr, ValidVtable}, true)/* }*/);
      } else {
        $this().EmitTrapCheck(Cond);
      }
    }
    
    $this().FinishFunction();
    // The only reference to this function will be created during LTO link.
    // Make sure it survives until then.
    $this().CGM.addUsedGlobal(F);
  } finally {
    if (ArgAddr != null) { ArgAddr.$destroy(); }
    if (ArgData != null) { ArgData.$destroy(); }
    if (Args != null) { Args.$destroy(); }
    if (SanScope != null) { SanScope.$destroy(); }
  }
}


/// SetFPAccuracy - Set the minimum required accuracy of the given floating
/// point operation, expressed as the maximum relative error in ulp.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::SetFPAccuracy">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp", line = 4171,
 FQN="clang::CodeGen::CodeGenFunction::SetFPAccuracy", NM="_ZN5clang7CodeGen15CodeGenFunction13SetFPAccuracyEPN4llvm5ValueEf",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction13SetFPAccuracyEPN4llvm5ValueEf")
//</editor-fold>
public final void SetFPAccuracy(Value /*P*/ Val, float Accuracy) {
  assert (Val.getType().isFPOrFPVectorTy());
  if (Accuracy == 0. || !isa_Instruction(Val)) {
    return;
  }
  
  MDBuilder MDHelper/*J*/= new MDBuilder($this().getLLVMContext());
  MDNode /*P*/ Node = MDHelper.createFPMath(Accuracy);
  
  cast_Instruction(Val).setMetadata(LLVMContext.Unnamed_enum.MD_fpmath.getValue(), Node);
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::getRangeForLoadFromType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp", line = 1252,
 FQN="clang::CodeGen::CodeGenFunction::getRangeForLoadFromType", NM="_ZN5clang7CodeGen15CodeGenFunction23getRangeForLoadFromTypeENS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction23getRangeForLoadFromTypeENS_8QualTypeE")
//</editor-fold>
protected/*private*/ final MDNode /*P*/ getRangeForLoadFromType(QualType Ty) {
  APInt Min/*J*/= new APInt();
  APInt End/*J*/= new APInt();
  if (!CGExprStatics.getRangeForType(/*Deref*/$this(), new QualType(Ty), Min, End, 
      $this().CGM.getCodeGenOpts().StrictEnums)) {
    return null;
  }
  
  MDBuilder MDHelper/*J*/= new MDBuilder($this().getLLVMContext());
  return MDHelper.createRange(Min, End);
}


/// EmitPointerWithAlignment - Given an expression with a pointer
/// type, emit the value and compute our best estimate of the
/// alignment of the pointee.
///
/// Note that this function will conservatively fall back on the type
/// when it doesn't 
///
/// \param Source - If non-null, this will be initialized with
///   information about the source of the alignment.  Note that this
///   function will conservatively fall back on the type when it
///   doesn't recognize the expression, which means that sometimes
///   
///   a worst-case One
///   reasonable way to use this information is when there's a
///   language guarantee that the pointer must be aligned to some
///   stricter value, and we're simply trying to ensure that
///   sufficiently obvious uses of under-aligned objects don't get
///   miscompiled; for example, a placement new into the address of
///   a local variable.  In such a case, it's quite reasonable to
///   just ignore the returned alignment when it isn't from an
///   explicit source.

//===----------------------------------------------------------------------===//
//                         LValue Expression Emission
//===----------------------------------------------------------------------===//

/// EmitPointerWithAlignment - Given an expression of pointer type, try to
/// derive a more accurate bound on the alignment of the pointer.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitPointerWithAlignment">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp", line = 820,
 FQN="clang::CodeGen::CodeGenFunction::EmitPointerWithAlignment", NM="_ZN5clang7CodeGen15CodeGenFunction24EmitPointerWithAlignmentEPKNS_4ExprEPNS0_15AlignmentSourceE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction24EmitPointerWithAlignmentEPKNS_4ExprEPNS0_15AlignmentSourceE")
//</editor-fold>
public final Address EmitPointerWithAlignment(/*const*/ Expr /*P*/ E) {
  return EmitPointerWithAlignment(E, 
                        create_type$null$ptr());
}
public final Address EmitPointerWithAlignment(/*const*/ Expr /*P*/ E, 
                        type$ptr<AlignmentSource /*P*/> Source/*= null*/) {
  // We allow this with ObjC object pointers because of fragile ABIs.
  assert (E.getType().$arrow().isPointerType() || E.getType().$arrow().isObjCObjectPointerType());
  E = E.IgnoreParens$Const();
  {
    
    // Casts:
    /*const*/ CastExpr /*P*/ CE = dyn_cast_CastExpr(E);
    if ((CE != null)) {
      {
        /*const*/ ExplicitCastExpr /*P*/ ECE = dyn_cast_ExplicitCastExpr(CE);
        if ((ECE != null)) {
          $this().CGM.EmitExplicitCastExprType(ECE, $this());
        }
      }
      switch (CE.getCastKind()) {
       case CK_BitCast:
       case CK_NoOp:
        {
          // Non-converting casts (but not C's implicit conversion from void*).
          /*const*/ org.clang.ast.PointerType /*P*/ PtrTy = CE.getSubExpr$Const().getType().$arrow().getAs(org.clang.ast.PointerType.class);
          if ((PtrTy != null)) {
            if (PtrTy.getPointeeType().$arrow().isVoidType()) {
              break;
            }
            
            type$ptr<AlignmentSource> InnerSource = create_type$null$ptr();
            Address Addr = $this().EmitPointerWithAlignment(CE.getSubExpr$Const(), $AddrOf(InnerSource));
            if ((Source != null)) {
              Source.$set(InnerSource.$star());
            }
            
            // If this is an explicit bitcast, and the source l-value is
            // opaque, honor the alignment of the casted-to type.
            if (isa_ExplicitCastExpr(CE)
               && InnerSource.$star() != AlignmentSource.Decl) {
              Addr.$assignMove(new Address(Addr.getPointer(), 
                      $this().getNaturalPointeeTypeAlignment(E.getType(), Source)));
            }
            if ($this().SanOpts.has(SanitizerKind.CFIUnrelatedCast)
               && CE.getCastKind() == CastKind.CK_BitCast) {
              {
                /*const*/ org.clang.ast.PointerType /*P*/ PT = E.getType().$arrow().getAs(org.clang.ast.PointerType.class);
                if ((PT != null)) {
                  $this().EmitVTablePtrCheckForCast(PT.getPointeeType(), Addr.getPointer(), 
                      /*MayBeNull=*/ true, 
                      CodeGenFunction.CFITypeCheckKind.CFITCK_UnrelatedCast, 
                      CE.getLocStart());
                }
              }
            }
            
            return $this().Builder.CreateBitCast(new Address(Addr), $this().ConvertType(E.getType()));
          }
        }
        break;
       case CK_ArrayToPointerDecay:
        
        // Array-to-pointer decay.
        return $this().EmitArrayToPointerDecay(CE.getSubExpr$Const(), Source);
       case CK_UncheckedDerivedToBase:
       case CK_DerivedToBase:
        {
          Address Addr = $this().EmitPointerWithAlignment(CE.getSubExpr$Const(), Source);
          /*const*/ CXXRecordDecl /*P*/ Derived = CE.getSubExpr$Const().getType().$arrow().getPointeeCXXRecordDecl();
          return $this().GetAddressOfBaseClass(new Address(Addr), Derived, 
              CE.path_begin$Const(), CE.path_end$Const(), 
              CodeGenFunction.ShouldNullCheckClassCastValue(CE), 
              CE.getExprLoc());
        }
       default:
        
        // TODO: Is there any reason to treat base-to-derived conversions
        // specially?
        break;
      }
    }
  }
  {
    
    // Unary &.
    /*const*/ UnaryOperator /*P*/ UO = dyn_cast_UnaryOperator(E);
    if ((UO != null)) {
      if (UO.getOpcode() == UnaryOperatorKind.UO_AddrOf) {
        LValue LV = $this().EmitLValue(UO.getSubExpr());
        if ((Source != null)) {
          Source.$set(LV.getAlignmentSource());
        }
        return LV.getAddress();
      }
    }
  }
  
  // TODO: conditional operators, comma.
  
  // Otherwise, use the alignment of the type.
  CharUnits Align = $this().getNaturalPointeeTypeAlignment(E.getType(), Source);
  return new Address($this().EmitScalarExpr(E), new CharUnits(Align));
}

} // END OF class CodeGenFunction_CGExpr
