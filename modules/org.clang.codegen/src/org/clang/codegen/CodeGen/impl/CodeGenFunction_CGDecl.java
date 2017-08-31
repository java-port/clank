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
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.llvm.ir.*;
import org.clang.codegen.impl.*;
import org.clang.codegen.CodeGen.*;
import org.llvm.ir.intrinsic.ID;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.java.AstRTTI.*;
import org.clang.basic.codegenoptions.DebugInfoKind;
import static org.clang.codegen.impl.CGDeclStatics.*;
import org.clank.support.aliases.type$ptr;
import static org.llvm.ir.java.IrRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type CodeGenFunction_CGDecl">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 NM="org.clang.codegen.CodeGen.impl.CodeGenFunction_CGDecl",        
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this -extends=CodeGenFunction_CGCleanup ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction11EmitVarDeclERKNS_7VarDeclE;_ZN5clang7CodeGen15CodeGenFunction11emitDestroyENS0_7AddressENS_8QualTypeEPFvRS1_S2_S3_Eb;_ZN5clang7CodeGen15CodeGenFunction11pushDestroyENS0_11CleanupKindENS0_7AddressENS_8QualTypeEPFvRS1_S3_S4_Eb;_ZN5clang7CodeGen15CodeGenFunction11pushDestroyENS_8QualType15DestructionKindENS0_7AddressES2_;_ZN5clang7CodeGen15CodeGenFunction12EmitParmDeclERKNS_7VarDeclENS1_10ParamValueEj;_ZN5clang7CodeGen15CodeGenFunction12getDestroyerENS_8QualType15DestructionKindE;_ZN5clang7CodeGen15CodeGenFunction13pushEHDestroyENS_8QualType15DestructionKindENS0_7AddressES2_;_ZN5clang7CodeGen15CodeGenFunction14EmitExprAsInitEPKNS_4ExprEPKNS_9ValueDeclENS0_6LValueEb;_ZN5clang7CodeGen15CodeGenFunction14EmitScalarInitEPKNS_4ExprEPKNS_9ValueDeclENS0_6LValueEb;_ZN5clang7CodeGen15CodeGenFunction14EmitScalarInitEPN4llvm5ValueENS0_6LValueE;_ZN5clang7CodeGen15CodeGenFunction15EmitAutoVarDeclERKNS_7VarDeclE;_ZN5clang7CodeGen15CodeGenFunction15EmitAutoVarInitERKNS1_15AutoVarEmissionE;_ZN5clang7CodeGen15CodeGenFunction15EmitLifetimeEndEPN4llvm5ValueES4_;_ZN5clang7CodeGen15CodeGenFunction16emitArrayDestroyEPN4llvm5ValueES4_NS_8QualTypeENS_9CharUnitsEPFvRS1_NS0_7AddressES5_Ebb;_ZN5clang7CodeGen15CodeGenFunction16pushStackRestoreENS0_11CleanupKindENS0_7AddressE;_ZN5clang7CodeGen15CodeGenFunction17EmitAutoVarAllocaERKNS_7VarDeclE;_ZN5clang7CodeGen15CodeGenFunction17EmitLifetimeStartEyPN4llvm5ValueE;_ZN5clang7CodeGen15CodeGenFunction17EmitStaticVarDeclERKNS_7VarDeclEN4llvm11GlobalValue12LinkageTypesE;_ZN5clang7CodeGen15CodeGenFunction19EmitAutoVarCleanupsERKNS1_15AutoVarEmissionE;_ZN5clang7CodeGen15CodeGenFunction20isTrivialInitializerEPKNS_4ExprE;_ZN5clang7CodeGen15CodeGenFunction22emitAutoVarTypeCleanupERKNS1_15AutoVarEmissionENS_8QualType15DestructionKindE;_ZN5clang7CodeGen15CodeGenFunction27pushLifetimeExtendedDestroyENS0_11CleanupKindENS0_7AddressENS_8QualTypeEPFvRS1_S3_S4_Eb;_ZN5clang7CodeGen15CodeGenFunction29AddInitializerToStaticVarDeclERKNS_7VarDeclEPN4llvm14GlobalVariableE;_ZN5clang7CodeGen15CodeGenFunction30pushRegularPartialArrayCleanupEPN4llvm5ValueES4_NS_8QualTypeENS_9CharUnitsEPFvRS1_NS0_7AddressES5_E;_ZN5clang7CodeGen15CodeGenFunction32pushIrregularPartialArrayCleanupEPN4llvm5ValueENS0_7AddressENS_8QualTypeENS_9CharUnitsEPFvRS1_S5_S6_E;_ZN5clang7CodeGen15CodeGenFunction8EmitDeclERKNS_4DeclE; -static-type=CodeGenFunction_CGDecl -package=org.clang.codegen.CodeGen.impl")
//</editor-fold>
public abstract class CodeGenFunction_CGDecl extends CodeGenFunction_CGCleanup {
private final /*split clang::CodeGen::CodeGenFunction*/ CodeGenFunction $this() { return (CodeGenFunction)this; }
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::CodeGenFunction">
@Converted(kind = Converted.Kind.MANUAL_ADDED,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp", line = 40,
 FQN="clang::CodeGen::CodeGenFunction::CodeGenFunction", NM="_ZN5clang7CodeGen15CodeGenFunctionC1ERNS0_13CodeGenModuleEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp -nm=_ZN5clang7CodeGen15CodeGenFunctionC1ERNS0_13CodeGenModuleEb")
//</editor-fold>
protected CodeGenFunction_CGDecl(final CodeGenModule /*&*/ cgm) {
  super(cgm);
}

// end anonymous namespace

/// pushIrregularPartialArrayCleanup - Push an EH cleanup to destroy
/// already-constructed elements of the given array.  The cleanup
/// may be popped with DeactivateCleanupBlock or PopCleanupBlock.
///
/// \param elementType - the immediate element type of the array;
///   possibly still an array type
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::pushIrregularPartialArrayCleanup">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp", line = 1682,
 FQN="clang::CodeGen::CodeGenFunction::pushIrregularPartialArrayCleanup", NM="_ZN5clang7CodeGen15CodeGenFunction32pushIrregularPartialArrayCleanupEPN4llvm5ValueENS0_7AddressENS_8QualTypeENS_9CharUnitsEPFvRS1_S5_S6_E",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction32pushIrregularPartialArrayCleanupEPN4llvm5ValueENS0_7AddressENS_8QualTypeENS_9CharUnitsEPFvRS1_S5_S6_E")
//</editor-fold>
public final void pushIrregularPartialArrayCleanup(Value /*P*/ arrayBegin, 
                                Address arrayEndPointer, 
                                QualType elementType, 
                                CharUnits elementAlign, 
                                CodeGenFunction.AddressQualType2Void destroyer) {
  $this().<IrregularPartialArrayDestroy>pushFullExprCleanup(CleanupKind.EHCleanup, 
      (Object... A) -> new IrregularPartialArrayDestroy((Value) A[0], (Address) A[1], (QualType) A[2], (CharUnits) A[3], (CodeGenFunction.AddressQualType2Void) A[4]),
      arrayBegin, new Address(arrayEndPointer), 
      new QualType(elementType), new CharUnits(elementAlign), 
      destroyer);
}


/// pushRegularPartialArrayCleanup - Push an EH cleanup to destroy
/// already-constructed elements of the given array.  The cleanup
/// may be popped with DeactivateCleanupBlock or PopCleanupBlock.
///
/// \param elementType - the immediate element type of the array;
///   possibly still an array type
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::pushRegularPartialArrayCleanup">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp", line = 1699,
 FQN="clang::CodeGen::CodeGenFunction::pushRegularPartialArrayCleanup", NM="_ZN5clang7CodeGen15CodeGenFunction30pushRegularPartialArrayCleanupEPN4llvm5ValueES4_NS_8QualTypeENS_9CharUnitsEPFvRS1_NS0_7AddressES5_E",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction30pushRegularPartialArrayCleanupEPN4llvm5ValueES4_NS_8QualTypeENS_9CharUnitsEPFvRS1_NS0_7AddressES5_E")
//</editor-fold>
public final void pushRegularPartialArrayCleanup(Value /*P*/ arrayBegin, 
                              Value /*P*/ arrayEnd, 
                              QualType elementType, 
                              CharUnits elementAlign, 
                              CodeGenFunction.AddressQualType2Void destroyer) {
  $this().<RegularPartialArrayDestroy>pushFullExprCleanup(CleanupKind.EHCleanup, 
      (Object... A) -> new RegularPartialArrayDestroy((Value) A[0], (Value) A[1], (QualType) A[2], (CharUnits) A[3], (CodeGenFunction.AddressQualType2Void) A[4]),
      arrayBegin, arrayEnd, 
      new QualType(elementType), new CharUnits(elementAlign), 
      destroyer);
}


/// pushDestroy - Push the standard destructor for the given type as
/// at least a normal cleanup.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::pushDestroy">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp", line = 1454,
 FQN="clang::CodeGen::CodeGenFunction::pushDestroy", NM="_ZN5clang7CodeGen15CodeGenFunction11pushDestroyENS_8QualType15DestructionKindENS0_7AddressES2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction11pushDestroyENS_8QualType15DestructionKindENS0_7AddressES2_")
//</editor-fold>
public final void pushDestroy(QualType.DestructionKind dtorKind, 
           Address addr, QualType type) {
  assert ((dtorKind.getValue() != 0)) : "cannot push destructor for trivial type";
  
  /*CleanupKind*//*uint*/int cleanupKind = $this().getCleanupKind(dtorKind);
  $this().pushDestroy(cleanupKind, new Address(addr), new QualType(type), $this().getDestroyer(dtorKind), 
      ((cleanupKind & CleanupKind.EHCleanup) != 0));
}


/// pushEHDestroy - Push the standard destructor for the given type as
/// an EH-only cleanup.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::pushEHDestroy">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp", line = 1444,
 FQN="clang::CodeGen::CodeGenFunction::pushEHDestroy", NM="_ZN5clang7CodeGen15CodeGenFunction13pushEHDestroyENS_8QualType15DestructionKindENS0_7AddressES2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction13pushEHDestroyENS_8QualType15DestructionKindENS0_7AddressES2_")
//</editor-fold>
public final void pushEHDestroy(QualType.DestructionKind dtorKind, 
             Address addr, QualType type) {
  assert ((dtorKind.getValue() != 0)) : "cannot push destructor for trivial type";
  assert ($this().needsEHCleanup(dtorKind));
  
  $this().pushDestroy(CleanupKind.EHCleanup, new Address(addr), new QualType(type), $this().getDestroyer(dtorKind), true);
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::pushDestroy">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp", line = 1463,
 FQN="clang::CodeGen::CodeGenFunction::pushDestroy", NM="_ZN5clang7CodeGen15CodeGenFunction11pushDestroyENS0_11CleanupKindENS0_7AddressENS_8QualTypeEPFvRS1_S3_S4_Eb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction11pushDestroyENS0_11CleanupKindENS0_7AddressENS_8QualTypeEPFvRS1_S3_S4_Eb")
//</editor-fold>
public final void pushDestroy(/*CleanupKind*//*uint*/int cleanupKind, Address addr, 
           QualType type, CodeGenFunction.AddressQualType2Void destroyer, 
           boolean useEHCleanupForArray) {
  $this().<DestroyObject>pushFullExprCleanup(cleanupKind, 
      (Object... A) -> new DestroyObject((Address) A[0], (QualType) A[1], (CodeGenFunction.AddressQualType2Void) A[2], (Boolean) A[3]),
      new Address(addr), new QualType(type), destroyer, useEHCleanupForArray);
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::pushLifetimeExtendedDestroy">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp", line = 1474,
 FQN="clang::CodeGen::CodeGenFunction::pushLifetimeExtendedDestroy", NM="_ZN5clang7CodeGen15CodeGenFunction27pushLifetimeExtendedDestroyENS0_11CleanupKindENS0_7AddressENS_8QualTypeEPFvRS1_S3_S4_Eb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction27pushLifetimeExtendedDestroyENS0_11CleanupKindENS0_7AddressENS_8QualTypeEPFvRS1_S3_S4_Eb")
//</editor-fold>
public final void pushLifetimeExtendedDestroy(/*CleanupKind*//*uint*/int cleanupKind, Address addr, QualType type, 
                           CodeGenFunction.AddressQualType2Void destroyer, boolean useEHCleanupForArray) {
  assert (!$this().isInConditionalBranch()) : "performing lifetime extension from within conditional";
  
  // Push an EH-only cleanup for the object now.
  // FIXME: When popping normal cleanups, we need to keep this EH cleanup
  // around in case a temporary's destructor throws an exception.
  if (((cleanupKind & CleanupKind.EHCleanup) != 0)) {
    $this().EHStack.<DestroyObject>pushCleanup$T((cleanupKind & ~CleanupKind.NormalCleanup), () -> new DestroyObject(new Address(addr), new QualType(type), 
        destroyer, useEHCleanupForArray));
  }
  
  // Remember that we need to push a full cleanup for the object at the
  // end of the full-expression.
  $this().<DestroyObject>pushCleanupAfterFullExpr(cleanupKind, new Address(addr), new QualType(type), destroyer, useEHCleanupForArray);
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::pushStackRestore">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp", line = 1470,
 FQN="clang::CodeGen::CodeGenFunction::pushStackRestore", NM="_ZN5clang7CodeGen15CodeGenFunction16pushStackRestoreENS0_11CleanupKindENS0_7AddressE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction16pushStackRestoreENS0_11CleanupKindENS0_7AddressE")
//</editor-fold>
public final void pushStackRestore(/*CleanupKind*//*uint*/int Kind, Address SPMem) {
  $this().EHStack.<CallStackRestore>pushCleanup$T(Kind, () -> new CallStackRestore(new Address(SPMem)));
}


/// emitDestroy - Immediately perform the destruction of the given
/// object.
///
/// \param addr - the address of the object; a type*
/// \param type - the type of the object; if an array type, all
///   objects are destroyed in reverse order
/// \param destroyer - the function to call to destroy individual
///   elements
/// \param useEHCleanupForArray - whether an EH cleanup should be
///   used when destroying array elements, in case one of the
///   destructions throws an exception
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::emitDestroy">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp", line = 1505,
 FQN="clang::CodeGen::CodeGenFunction::emitDestroy", NM="_ZN5clang7CodeGen15CodeGenFunction11emitDestroyENS0_7AddressENS_8QualTypeEPFvRS1_S2_S3_Eb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction11emitDestroyENS0_7AddressENS_8QualTypeEPFvRS1_S2_S3_Eb")
//</editor-fold>
public final void emitDestroy(Address addr, QualType type, 
           CodeGenFunction.AddressQualType2Void destroyer, 
           boolean useEHCleanupForArray) {
  /*const*/ org.clang.ast.ArrayType /*P*/ arrayType = $this().getContext().getAsArrayType(new QualType(type));
  if (!(arrayType != null)) {
    destroyer.$call(/*Deref*/$this(), new Address(addr), new QualType(type));
    /*JAVA:return*/return;
  }
  
  Value /*P*/ length = $this().emitArrayLength(arrayType, type, addr);
  
  CharUnits elementAlign = addr.getAlignment().
      alignmentOfArrayElement($this().getContext().getTypeSizeInChars(/*NO_COPY*/type));
  
  // Normally we have to check whether the array is zero-length.
  boolean checkZeroLength = true;
  {
    
    // But if the array length is constant, we can suppress that.
    ConstantInt /*P*/ constLength = dyn_cast_ConstantInt(length);
    if ((constLength != null)) {
      // ...and if it's constant zero, we can just skip the entire thing.
      if (constLength.isZero()) {
        return;
      }
      checkZeroLength = false;
    }
  }
  
  Value /*P*/ begin = addr.getPointer();
  Value /*P*/ end = $this().Builder.CreateInBoundsGEP(begin, new ArrayRef<Value /*P*/ >(length, true));
  $this().emitArrayDestroy(begin, end, new QualType(type), new CharUnits(elementAlign), destroyer, 
      checkZeroLength, useEHCleanupForArray);
}


/// emitArrayDestroy - Destroys all the elements of the given array,
/// beginning from last to first.  The array cannot be zero-length.
///
/// \param begin - a type* denoting the first element of the array
/// \param end - a type* denoting one past the end of the array
/// \param elementType - the element type of the array
/// \param destroyer - the function to call to destroy elements
/// \param useEHCleanup - whether to push an EH cleanup to destroy
///   the remaining elements in case the destruction of a single
///   element throws
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::emitArrayDestroy">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp", line = 1544,
 FQN="clang::CodeGen::CodeGenFunction::emitArrayDestroy", NM="_ZN5clang7CodeGen15CodeGenFunction16emitArrayDestroyEPN4llvm5ValueES4_NS_8QualTypeENS_9CharUnitsEPFvRS1_NS0_7AddressES5_Ebb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction16emitArrayDestroyEPN4llvm5ValueES4_NS_8QualTypeENS_9CharUnitsEPFvRS1_NS0_7AddressES5_Ebb")
//</editor-fold>
public final void emitArrayDestroy(Value /*P*/ begin, 
                Value /*P*/ end, 
                QualType elementType, 
                CharUnits elementAlign, 
                CodeGenFunction.AddressQualType2Void destroyer, 
                boolean checkZeroLength, 
                boolean useEHCleanup) {
  assert (!elementType.$arrow().isArrayType());
  
  // The basic structure here is a do-while loop, because we don't
  // need to check for the zero-element case.
  BasicBlock /*P*/ bodyBB = $this().createBasicBlock(new Twine(/*KEEP_STR*/"arraydestroy.body"));
  BasicBlock /*P*/ doneBB = $this().createBasicBlock(new Twine(/*KEEP_STR*/"arraydestroy.done"));
  if (checkZeroLength) {
    Value /*P*/ isEmpty = $this().Builder.CreateICmpEQ(begin, end, 
        new Twine(/*KEEP_STR*/"arraydestroy.isempty"));
    $this().Builder.CreateCondBr(isEmpty, doneBB, bodyBB);
  }
  
  // Enter the loop body, making that address the current address.
  BasicBlock /*P*/ entryBB = $this().Builder.GetInsertBlock();
  $this().EmitBlock(bodyBB);
  PHINode /*P*/ elementPast = $this().Builder.CreatePHI(begin.getType(), 2, new Twine(/*KEEP_STR*/"arraydestroy.elementPast"));
  elementPast.addIncoming(end, entryBB);
  
  // Shift the address back by one element.
  Value /*P*/ negativeOne = ConstantInt.get(Unnamed_field8.SizeTy, $int2ulong(-1), true);
  Value /*P*/ element = $this().Builder.CreateInBoundsGEP(elementPast, new ArrayRef<Value /*P*/ >(negativeOne, true), 
      new Twine(/*KEEP_STR*/"arraydestroy.element"));
  if (useEHCleanup) {
    $this().pushRegularPartialArrayCleanup(begin, element, new QualType(elementType), new CharUnits(elementAlign), 
        destroyer);
  }
  
  // Perform the actual destruction there.
  destroyer.$call(/*Deref*/$this(), new Address(element, new CharUnits(elementAlign)), new QualType(elementType));
  if (useEHCleanup) {
    $this().PopCleanupBlock();
  }
  
  // Check whether we've reached the end.
  Value /*P*/ done = $this().Builder.CreateICmpEQ(element, begin, new Twine(/*KEEP_STR*/"arraydestroy.done"));
  $this().Builder.CreateCondBr(done, doneBB, bodyBB);
  elementPast.addIncoming(element, $this().Builder.GetInsertBlock());
  
  // Done.
  $this().EmitBlock(doneBB);
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::getDestroyer">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp", line = 1428,
 FQN="clang::CodeGen::CodeGenFunction::getDestroyer", NM="_ZN5clang7CodeGen15CodeGenFunction12getDestroyerENS_8QualType15DestructionKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction12getDestroyerENS_8QualType15DestructionKindE")
//</editor-fold>
public final CodeGenFunction.AddressQualType2Void getDestroyer(QualType.DestructionKind kind) {
  switch (kind) {
   case DK_none:
    throw new llvm_unreachable("no destroyer for trivial dtor");
   case DK_cxx_destructor:
    return /*FuncRef*/CodeGenFunction::destroyCXXObject;
   case DK_objc_strong_lifetime:
    return /*FuncRef*/CodeGenFunction::destroyARCStrongPrecise;
   case DK_objc_weak_lifetime:
    return /*FuncRef*/CodeGenFunction::destroyARCWeak;
  }
  throw new llvm_unreachable("Unknown DestructionKind");
}


/// EmitExprAsInit - Emits the code necessary to initialize a
/// location in memory with the given initializer.

/// Emit an expression as an initializer for a variable at the given
/// location.  The expression is not necessarily the normal
/// initializer for the variable, and the address is not necessarily
/// its normal location.
///
/// \param init the initializing expression
/// \param var the variable to act as if we're initializing
/// \param loc the address to initialize; its type is a pointer
///   to the LLVM mapping of the variable's type
/// \param alignment the alignment of the address
/// \param capturedByInit true if the variable is a __block variable
///   whose address is potentially changed by the initializer
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitExprAsInit">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp", line = 1287,
 FQN="clang::CodeGen::CodeGenFunction::EmitExprAsInit", NM="_ZN5clang7CodeGen15CodeGenFunction14EmitExprAsInitEPKNS_4ExprEPKNS_9ValueDeclENS0_6LValueEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction14EmitExprAsInitEPKNS_4ExprEPKNS_9ValueDeclENS0_6LValueEb")
//</editor-fold>
public final void EmitExprAsInit(/*const*/ Expr /*P*/ init, /*const*/ ValueDecl /*P*/ D, 
              LValue lvalue, boolean capturedByInit) {
  QualType type = D.getType();
  if (type.$arrow().isReferenceType()) {
    RValue rvalue = $this().EmitReferenceBindingToExpr(init);
    if (capturedByInit) {
      CGDeclStatics.drillIntoBlockVariable(/*Deref*/$this(), lvalue, cast_VarDecl(D));
    }
    $this().EmitStoreThroughLValue(new RValue(rvalue), new LValue(lvalue), true);
    return;
  }
  switch (CodeGenFunction.getEvaluationKind(new QualType(type))) {
   case TEK_Scalar:
    $this().EmitScalarInit(init, D, new LValue(lvalue), capturedByInit);
    return;
   case TEK_Complex:
    {
      std.pair<Value /*P*/ , Value /*P*/ > complex = $this().EmitComplexExpr(init);
      if (capturedByInit) {
        CGDeclStatics.drillIntoBlockVariable(/*Deref*/$this(), lvalue, cast_VarDecl(D));
      }
      $this().EmitStoreOfComplex(new std.pairPtrPtr<Value /*P*/ , Value /*P*/ >(complex), new LValue(lvalue), /*init*/ true);
      return;
    }
   case TEK_Aggregate:
    if (type.$arrow().isAtomicType()) {
      $this().EmitAtomicInit(((/*const_cast*/Expr /*P*/ )(init)), new LValue(lvalue));
    } else {
      // TODO: how can we delay here if D is captured by its initializer?
      $this().EmitAggExpr(init, AggValueSlot.forLValue(lvalue, 
              AggValueSlot.IsDestructed_t.IsDestructed, 
              AggValueSlot.NeedsGCBarriers_t.DoesNotNeedGCBarriers, 
              AggValueSlot.IsAliased_t.IsNotAliased));
    }
    return;
  }
  throw new llvm_unreachable("bad evaluation kind");
}


/// Emit a lifetime.begin marker if some criteria are satisfied.
/// \return a pointer to the temporary size Value if a marker was emitted, null
/// otherwise
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitLifetimeStart">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp", line = 930,
 FQN="clang::CodeGen::CodeGenFunction::EmitLifetimeStart", NM="_ZN5clang7CodeGen15CodeGenFunction17EmitLifetimeStartEyPN4llvm5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction17EmitLifetimeStartEyPN4llvm5ValueE")
//</editor-fold>
public final Value /*P*/ EmitLifetimeStart(long/*uint64_t*/ Size, 
                 Value /*P*/ Addr) {
  if (!CGDeclStatics.shouldEmitLifetimeMarkers($this().CGM.getCodeGenOpts(), $this().getLangOpts())) {
    return null;
  }
  
  Value /*P*/ SizeV = ConstantInt.get(Int64Ty, Size);
  Addr = $this().Builder.CreateBitCast(Addr, Unnamed_field9.Int8PtrTy);
  CallInst /*P*/ C = $this().Builder.CreateCall_Value$P_ArrayRef$Value$P_Twine$C_MDNode$P($this().CGM.getLLVMLifetimeStartFn(), /*{ */new ArrayRef<Value /*P*/ >(new Value /*P*/ /*const*/ [/*2*/] {SizeV, Addr}, true)/* }*/);
  C.setDoesNotThrow();
  return SizeV;
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitLifetimeEnd">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp", line = 943,
 FQN="clang::CodeGen::CodeGenFunction::EmitLifetimeEnd", NM="_ZN5clang7CodeGen15CodeGenFunction15EmitLifetimeEndEPN4llvm5ValueES4_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction15EmitLifetimeEndEPN4llvm5ValueES4_")
//</editor-fold>
public final void EmitLifetimeEnd(Value /*P*/ Size, Value /*P*/ Addr) {
  Addr = $this().Builder.CreateBitCast(Addr, Unnamed_field9.Int8PtrTy);
  CallInst /*P*/ C = $this().Builder.CreateCall_Value$P_ArrayRef$Value$P_Twine$C_MDNode$P($this().CGM.getLLVMLifetimeEndFn(), /*{ */new ArrayRef<Value /*P*/ >(new Value /*P*/ /*const*/ [/*2*/] {Size, Addr}, true)/* }*/);
  C.setDoesNotThrow();
}


//===--------------------------------------------------------------------===//
//                            Declaration Emission
//===--------------------------------------------------------------------===//

/// EmitDecl - Emit a declaration.
///
/// This function can be called with a null (unreachable) insert point.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp", line = 38,
 FQN="clang::CodeGen::CodeGenFunction::EmitDecl", NM="_ZN5clang7CodeGen15CodeGenFunction8EmitDeclERKNS_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction8EmitDeclERKNS_4DeclE")
//</editor-fold>
public final void EmitDecl(final /*const*/ Decl /*&*/ D) {
  switch (D.getKind()) {
   case BuiltinTemplate:
   case TranslationUnit:
   case ExternCContext:
   case Namespace:
   case UnresolvedUsingTypename:
   case ClassTemplateSpecialization:
   case ClassTemplatePartialSpecialization:
   case VarTemplateSpecialization:
   case VarTemplatePartialSpecialization:
   case TemplateTypeParm:
   case UnresolvedUsingValue:
   case NonTypeTemplateParm:
   case CXXMethod:
   case CXXConstructor:
   case CXXDestructor:
   case CXXConversion:
   case Field:
   case MSProperty:
   case IndirectField:
   case ObjCIvar:
   case ObjCAtDefsField:
   case ParmVar:
   case ImplicitParam:
   case ClassTemplate:
   case VarTemplate:
   case FunctionTemplate:
   case TypeAliasTemplate:
   case TemplateTemplateParm:
   case ObjCMethod:
   case ObjCCategory:
   case ObjCProtocol:
   case ObjCInterface:
   case ObjCCategoryImpl:
   case ObjCImplementation:
   case ObjCProperty:
   case ObjCCompatibleAlias:
   case PragmaComment:
   case PragmaDetectMismatch:
   case AccessSpec:
   case LinkageSpec:
   case ObjCPropertyImpl:
   case FileScopeAsm:
   case Friend:
   case FriendTemplate:
   case Block:
   case Captured:
   case ClassScopeFunctionSpecialization:
   case UsingShadow:
   case ConstructorUsingShadow:
   case ObjCTypeParam:
    throw new llvm_unreachable("Declaration should not be in declstmts!");
   case Function: // void X();
   case Record: // struct/union/class X;
   case Enum: // enum X;
   case EnumConstant: // enum ? { X = ? }
   case CXXRecord: // struct/union/class X; [C++]
   case StaticAssert: // static_assert(X, ""); [C++0x]
   case Label: // __label__ x;
   case Import:
   case OMPThreadPrivate:
   case OMPCapturedExpr:
   case Empty:
    // None of these decls require codegen support.
    return;
   case NamespaceAlias:
    {
      CGDebugInfo /*P*/ DI = $this().getDebugInfo();
      if ((DI != null)) {
        DI.EmitNamespaceAlias(cast_NamespaceAliasDecl(D));
      }
    }
    return;
   case Using: // using X; [C++]
    {
      CGDebugInfo /*P*/ DI = $this().getDebugInfo();
      if ((DI != null)) {
        DI.EmitUsingDecl(cast_UsingDecl(D));
      }
    }
    return;
   case UsingDirective: // using namespace X; [C++]
    {
      CGDebugInfo /*P*/ DI = $this().getDebugInfo();
      if ((DI != null)) {
        DI.EmitUsingDirective(cast_UsingDirectiveDecl(D));
      }
    }
    return;
   case Var:
    {
      final /*const*/ VarDecl /*&*/ VD = cast_VarDecl(D);
      assert (VD.isLocalVarDecl()) : "Should not see file-scope variables inside a function!";
      $this().EmitVarDecl(VD);
      /*JAVA:return*/return;
    }
   case OMPDeclareReduction:
    $this().CGM.EmitOMPDeclareReduction(cast_OMPDeclareReductionDecl($AddrOf(D)), $this());
    /*JAVA:return*/return;
   case Typedef: // typedef int X;
   case TypeAlias:
    { // using X = int; [C++0x]
      final /*const*/ TypedefNameDecl /*&*/ TD = cast_TypedefNameDecl(D);
      QualType Ty = TD.getUnderlyingType();
      if (Ty.$arrow().isVariablyModifiedType()) {
        $this().EmitVariablyModifiedType(new QualType(Ty));
      }
    }
  }
}


/// EmitVarDecl - Emit a local variable declaration.
///
/// This function can be called with a null (unreachable) insert point.

/// EmitVarDecl - This method handles emission of any variable declaration
/// inside a function, including static vars etc.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitVarDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp", line = 140,
 FQN="clang::CodeGen::CodeGenFunction::EmitVarDecl", NM="_ZN5clang7CodeGen15CodeGenFunction11EmitVarDeclERKNS_7VarDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction11EmitVarDeclERKNS_7VarDeclE")
//</editor-fold>
public final void EmitVarDecl(final /*const*/ VarDecl /*&*/ D) {
  if (D.isStaticLocal()) {
    GlobalValue.LinkageTypes Linkage = $this().CGM.getLLVMLinkageVarDefinition($AddrOf(D), /*isConstant=*/ false);
    
    // FIXME: We need to force the emission/use of a guard variable for
    // some variables even if we can constant-evaluate them because
    // we can't guarantee every translation unit will constant-evaluate them.
    $this().EmitStaticVarDecl(D, Linkage);
    /*JAVA:return*/return;
  }
  if (D.hasExternalStorage()) {
    // Don't emit it now, allow it to be emitted lazily on its first use.
    return;
  }
  if (D.getType().getAddressSpace() == LangAS.ID.opencl_local) {
    $this().CGM.getOpenCLRuntime().EmitWorkGroupLocalVarDecl(/*Deref*/$this(), D);
    /*JAVA:return*/return;
  }
  assert (D.hasLocalStorage());
  $this().EmitAutoVarDecl(D);
  /*JAVA:return*/return;
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitScalarInit">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp", line = 660,
 FQN="clang::CodeGen::CodeGenFunction::EmitScalarInit", NM="_ZN5clang7CodeGen15CodeGenFunction14EmitScalarInitEPKNS_4ExprEPKNS_9ValueDeclENS0_6LValueEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction14EmitScalarInitEPKNS_4ExprEPKNS_9ValueDeclENS0_6LValueEb")
//</editor-fold>
public final void EmitScalarInit(/*const*/ Expr /*P*/ init, /*const*/ ValueDecl /*P*/ D, 
              LValue lvalue, boolean capturedByInit) {
  CodeGenFunction.RunCleanupsScope Scope = null;
  try {
    Qualifiers.ObjCLifetime lifetime = lvalue.getObjCLifetime();
    if (!(lifetime.getValue() != 0)) {
      Value /*P*/ value = $this().EmitScalarExpr(init);
      if (capturedByInit) {
        CGDeclStatics.drillIntoBlockVariable(/*Deref*/$this(), lvalue, cast_VarDecl(D));
      }
      $this().EmitStoreThroughLValue(RValue.get(value), new LValue(lvalue), true);
      return;
    }
    {
      
      /*const*/ CXXDefaultInitExpr /*P*/ DIE = dyn_cast_CXXDefaultInitExpr(init);
      if ((DIE != null)) {
        init = DIE.getExpr$Const();
      }
    }
    {
      
      // If we're emitting a value with lifetime, we have to do the
      // initialization *before* we leave the cleanup scopes.
      /*const*/ ExprWithCleanups /*P*/ ewc = dyn_cast_ExprWithCleanups(init);
      if ((ewc != null)) {
        $this().enterFullExpression(ewc);
        init = ewc.getSubExpr$Const();
      }
    }
    Scope/*J*/= new CodeGenFunction.RunCleanupsScope(/*Deref*/$this());
    
    // We have to maintain the illusion that the variable is
    // zero-initialized.  If the variable might be accessed in its
    // initializer, zero-initialize before running the initializer, then
    // actually perform the initialization with an assign.
    boolean accessedByInit = false;
    if (lifetime != Qualifiers.ObjCLifetime.OCL_ExplicitNone) {
      accessedByInit = (capturedByInit || CGDeclStatics.isAccessedBy(D, init));
    }
    if (accessedByInit) {
      LValue tempLV = new LValue(lvalue);
      // Drill down to the __block object if necessary.
      if (capturedByInit) {
        // We can use a simple GEP for this because it can't have been
        // moved yet.
        tempLV.setAddress($this().emitBlockByrefAddress(tempLV.getAddress(), 
                cast_VarDecl(D), 
                /*follow*/ false));
      }
      
      org.llvm.ir.PointerType /*P*/ ty = cast_PointerType(tempLV.getAddress().getElementType());
      Value /*P*/ zero = ConstantPointerNull.get(ty);
      
      // If __weak, we want to use a barrier under certain conditions.
      if (lifetime == Qualifiers.ObjCLifetime.OCL_Weak) {
        $this().EmitARCInitWeak(tempLV.getAddress(), zero);
      } else {
        
        // Otherwise just do a simple store.
        $this().EmitStoreOfScalar(zero, new LValue(tempLV), /* isInitialization */ true);
      }
    }
    
    // Emit the initializer.
    Value /*P*/ value = null;
    switch (lifetime) {
     case OCL_None:
      throw new llvm_unreachable("present but none");
     case OCL_ExplicitNone:
      value = $this().EmitARCUnsafeUnretainedScalarExpr(init);
      break;
     case OCL_Strong:
      {
        value = $this().EmitARCRetainScalarExpr(init);
        break;
      }
     case OCL_Weak:
      {
        // If it's not accessed by the initializer, try to emit the
        // initialization with a copy or move.
        if (!accessedByInit && CGDeclStatics.tryEmitARCCopyWeakInit(/*Deref*/$this(), lvalue, init)) {
          return;
        }
        
        // No way to optimize a producing initializer into this.  It's not
        // worth optimizing for, because the value will immediately
        // disappear in the common case.
        value = $this().EmitScalarExpr(init);
        if (capturedByInit) {
          CGDeclStatics.drillIntoBlockVariable(/*Deref*/$this(), lvalue, cast_VarDecl(D));
        }
        if (accessedByInit) {
          $this().EmitARCStoreWeak(lvalue.getAddress(), value, /*ignored*/ true);
        } else {
          $this().EmitARCInitWeak(lvalue.getAddress(), value);
        }
        return;
      }
     case OCL_Autoreleasing:
      value = $this().EmitARCRetainAutoreleaseScalarExpr(init);
      break;
    }
    if (capturedByInit) {
      CGDeclStatics.drillIntoBlockVariable(/*Deref*/$this(), lvalue, cast_VarDecl(D));
    }
    
    // If the variable might have been accessed by its initializer, we
    // might have to initialize with a barrier.  We have to do this for
    // both __weak and __strong, but __weak got filtered out above.
    if (accessedByInit && lifetime == Qualifiers.ObjCLifetime.OCL_Strong) {
      Value /*P*/ oldValue = $this().EmitLoadOfScalar(new LValue(lvalue), init.getExprLoc());
      $this().EmitStoreOfScalar(value, new LValue(lvalue), /* isInitialization */ true);
      $this().EmitARCRelease(oldValue, ARCPreciseLifetime_t.ARCImpreciseLifetime);
      return;
    }
    
    $this().EmitStoreOfScalar(value, new LValue(lvalue), /* isInitialization */ true);
  } finally {
    if (Scope != null) { Scope.$destroy(); }
  }
}


/// EmitScalarInit - Initialize the given lvalue with the given object.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitScalarInit">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp", line = 769,
 FQN="clang::CodeGen::CodeGenFunction::EmitScalarInit", NM="_ZN5clang7CodeGen15CodeGenFunction14EmitScalarInitEPN4llvm5ValueENS0_6LValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction14EmitScalarInitEPN4llvm5ValueENS0_6LValueE")
//</editor-fold>
public final void EmitScalarInit(Value /*P*/ init, LValue lvalue) {
  Qualifiers.ObjCLifetime lifetime = lvalue.getObjCLifetime();
  if (!(lifetime.getValue() != 0)) {
    $this().EmitStoreThroughLValue(RValue.get(init), new LValue(lvalue), true);
    /*JAVA:return*/return;
  }
  switch (lifetime) {
   case OCL_None:
    throw new llvm_unreachable("present but none");
   case OCL_ExplicitNone:
    // nothing to do
    break;
   case OCL_Strong:
    init = $this().EmitARCRetain(lvalue.getType(), init);
    break;
   case OCL_Weak:
    // Initialize and then skip the primitive store.
    $this().EmitARCInitWeak(lvalue.getAddress(), init);
    return;
   case OCL_Autoreleasing:
    init = $this().EmitARCRetainAutorelease(lvalue.getType(), init);
    break;
  }
  
  $this().EmitStoreOfScalar(init, new LValue(lvalue), /* isInitialization */ true);
}


/// \brief Determine whether the given initializer is trivial in the sense
/// that it requires no code to be generated.

/// \brief Determine whether the given initializer is trivial in the sense
/// that it requires no code to be generated.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::isTrivialInitializer">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp", line = 1164,
 FQN="clang::CodeGen::CodeGenFunction::isTrivialInitializer", NM="_ZN5clang7CodeGen15CodeGenFunction20isTrivialInitializerEPKNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction20isTrivialInitializerEPKNS_4ExprE")
//</editor-fold>
public final boolean isTrivialInitializer(/*const*/ Expr /*P*/ Init) {
  if (!(Init != null)) {
    return true;
  }
  {
    
    /*const*/ CXXConstructExpr /*P*/ Construct = dyn_cast_CXXConstructExpr(Init);
    if ((Construct != null)) {
      {
        CXXConstructorDecl /*P*/ Constructor = Construct.getConstructor();
        if ((Constructor != null)) {
          if (Constructor.isTrivial()
             && Constructor.isDefaultConstructor()
             && !Construct.requiresZeroInitialization()) {
            return true;
          }
        }
      }
    }
  }
  
  return false;
}


/// EmitAutoVarDecl - Emit an auto variable declaration.
///
/// This function can be called with a null (unreachable) insert point.

/// EmitAutoVarDecl - Emit code and set up an entry in LocalDeclMap for a
/// variable declaration with auto, register, or no storage class specifier.
/// These turn into simple stack objects, or GlobalValues depending on target.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitAutoVarDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp", line = 904,
 FQN="clang::CodeGen::CodeGenFunction::EmitAutoVarDecl", NM="_ZN5clang7CodeGen15CodeGenFunction15EmitAutoVarDeclERKNS_7VarDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction15EmitAutoVarDeclERKNS_7VarDeclE")
//</editor-fold>
public final void EmitAutoVarDecl(final /*const*/ VarDecl /*&*/ D) {
  AutoVarEmission emission = $this().EmitAutoVarAlloca(D);
  $this().EmitAutoVarInit(emission);
  $this().EmitAutoVarCleanups(emission);
}


/// EmitAutoVarAlloca - Emit the alloca and debug information for a
/// local variable.  Does not emit initialization or destruction.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitAutoVarAlloca">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp", line = 952,
 FQN="clang::CodeGen::CodeGenFunction::EmitAutoVarAlloca", NM="_ZN5clang7CodeGen15CodeGenFunction17EmitAutoVarAllocaERKNS_7VarDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction17EmitAutoVarAllocaERKNS_7VarDeclE")
//</editor-fold>
public final CodeGenFunction.AutoVarEmission EmitAutoVarAlloca(final /*const*/ VarDecl /*&*/ D) {
  QualType Ty = D.getType();
  
  AutoVarEmission emission/*J*/= new AutoVarEmission(D);
  
  boolean isByRef = D.hasAttr(BlocksAttr.class);
  emission.IsByRef = isByRef;
  
  CharUnits alignment = $this().getContext().getDeclAlign($AddrOf(D));
  
  // If the type is variably-modified, emit all the VLA sizes for it.
  if (Ty.$arrow().isVariablyModifiedType()) {
    $this().EmitVariablyModifiedType(new QualType(Ty));
  }
  
  Address address = Address.invalid();
  if (Ty.$arrow().isConstantSizeType()) {
    boolean NRVO = $this().getLangOpts().ElideConstructors
       && D.isNRVOVariable();
    
    // If this value is an array or struct with a statically determinable
    // constant initializer, there are optimizations we can do.
    //
    // TODO: We should constant-evaluate the initializer of any variable,
    // as long as it is initialized by a constant expression. Currently,
    // isConstantInitializer produces wrong answers for structs with
    // reference or bitfield members, and a few other cases, and checking
    // for POD-ness protects us from some of these.
    if ((D.getInit$Const() != null) && (Ty.$arrow().isArrayType() || Ty.$arrow().isRecordType())
       && (D.isConstexpr()
       || ((Ty.isPODType($this().getContext())
       || $this().getContext().getBaseElementType(new QualType(Ty)).$arrow().isObjCObjectPointerType())
       && D.getInit$Const().isConstantInitializer($this().getContext(), false)))) {
      
      // If the variable's a const type, and it's neither an NRVO
      // candidate nor a __block variable and has no mutable members,
      // emit it as a global instead.
      if ($this().CGM.getCodeGenOpts().MergeAllConstants && !NRVO && !isByRef
         && $this().CGM.isTypeConstant(new QualType(Ty), true)) {
        $this().EmitStaticVarDecl(D, GlobalValue.LinkageTypes.InternalLinkage);
        
        // Signal this condition to later callbacks.
        emission.Addr.$assignMove(Address.invalid());
        assert (emission.wasEmittedAsGlobal());
        return emission;
      }
      
      // Otherwise, tell the initialization code that we're in this case.
      emission.IsConstantAggregate = true;
    }
    
    // A normal fixed sized variable becomes an alloca in the entry block,
    // unless it's an NRVO variable.
    if (NRVO) {
      // The named return value optimization: allocate this variable in the
      // return slot, so that we can elide the copy when returning this
      // variable (C++0x [class.copy]p34).
      address.$assign($this().ReturnValue);
      {
        
        /*const*/ RecordType /*P*/ RecordTy = Ty.$arrow().getAs$RecordType();
        if ((RecordTy != null)) {
          if (!cast_CXXRecordDecl(RecordTy.getDecl()).hasTrivialDestructor()) {
            // Create a flag that is used to indicate when the NRVO was applied
            // to this variable. Set it to zero to indicate that NRVO was not
            // applied.
            Value /*P*/ Zero = $this().Builder.getFalse();
            Address NRVOFlag = $this().CreateTempAlloca(Zero.getType(), CharUnits.One(), new Twine(/*KEEP_STR*/"nrvo"));
            $this().EnsureInsertPoint();
            $this().Builder.CreateStore(Zero, new Address(NRVOFlag));
            
            // Record the NRVO flag for this variable.
            $this().NRVOFlags.$set($AddrOf(D), NRVOFlag.getPointer());
            emission.NRVOFlag = NRVOFlag.getPointer();
          }
        }
      }
    } else {
      CharUnits allocaAlignment/*J*/= new CharUnits();
      org.llvm.ir.Type /*P*/ allocaTy;
      if (isByRef) {
        final /*const*/ BlockByrefInfo /*&*/ byrefInfo = $this().getBlockByrefInfo($AddrOf(D));
        allocaTy = byrefInfo.Type;
        allocaAlignment.$assign(byrefInfo.ByrefAlignment);
      } else {
        allocaTy = $this().ConvertTypeForMem(new QualType(Ty));
        allocaAlignment.$assign(alignment);
      }
      
      // Create the alloca.  Note that we set the name separately from
      // building the instruction so that it's there even in no-asserts
      // builds.
      address.$assignMove($this().CreateTempAlloca(allocaTy, new CharUnits(allocaAlignment)));
      address.getPointer().setName(new Twine(D.getName()));
      
      // Don't emit lifetime markers for MSVC catch parameters. The lifetime of
      // the catch parameter starts in the catchpad instruction, and we can't
      // insert code in those basic blocks.
      boolean IsMSCatchParam = D.isExceptionVariable() && $this().getTarget().getCXXABI().isMicrosoft();
      
      // Emit a lifetime intrinsic if meaningful.  There's no point
      // in doing this if we don't have a valid insertion point (?).
      if ($this().HaveInsertPoint() && !IsMSCatchParam) {
        long/*uint64_t*/ size = $this().CGM.getDataLayout().getTypeAllocSize(allocaTy);
        emission.SizeForLifetimeMarkers
           = $this().EmitLifetimeStart(size, address.getPointer());
      } else {
        assert (!emission.useLifetimeMarkers());
      }
    }
  } else {
    $this().EnsureInsertPoint();
    if (!$this().DidCallStackSave) {
      // Save the stack.
      Address Stack = $this().CreateTempAlloca(Unnamed_field9.Int8PtrTy, /*J:ToBase*/super.getPointerAlign(), new Twine(/*KEEP_STR*/"saved_stack"));
      
      Value /*P*/ F = $this().CGM.getIntrinsic(ID.stacksave);
      Value /*P*/ V = $this().Builder.CreateCall_Value$P_ArrayRef$Value$P_Twine$C_MDNode$P(F);
      $this().Builder.CreateStore(V, new Address(Stack));
      
      $this().DidCallStackSave = true;
      
      // Push a cleanup block and restore the stack there.
      // FIXME: in general circumstances, this should be an EH cleanup.
      $this().pushStackRestore(CleanupKind.NormalCleanup, new Address(Stack));
    }
    
    //std.tie(elementCount, elementType).$assign($this().getVLASize(new QualType(Ty)));
    pair<Value, QualType> tmp = $this().getVLASize(new QualType(Ty));
    Value /*P*/ elementCount = tmp.first;
    QualType elementType/*J*/= tmp.second;
    
    org.llvm.ir.Type /*P*/ llvmTy = $this().ConvertTypeForMem(new QualType(elementType));
    
    // Allocate memory for the array.
    AllocaInst /*P*/ vla = $this().Builder.CreateAlloca(llvmTy, elementCount, new Twine(/*KEEP_STR*/"vla"));
    vla.setAlignment($long2uint(alignment.getQuantity()));
    
    address.$assignMove(new Address(vla, new CharUnits(alignment)));
  }
  
  $this().setAddrOfLocalVar($AddrOf(D), new Address(address));
  emission.Addr.$assign(address);
  
  // Emit debug info for local var declaration.
  if ($this().HaveInsertPoint()) {
    {
      CGDebugInfo /*P*/ DI = $this().getDebugInfo();
      if ((DI != null)) {
        if ($this().CGM.getCodeGenOpts().getDebugInfo().getValue()
           >= DebugInfoKind.LimitedDebugInfo.getValue()) {
          DI.setLocation(D.getLocation());
          DI.EmitDeclareOfAutoVariable($AddrOf(D), address.getPointer(), $this().Builder);
        }
      }
    }
  }
  if (D.hasAttr(AnnotateAttr.class)) {
    $this().EmitVarAnnotations($AddrOf(D), address.getPointer());
  }
  
  return emission;
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitAutoVarInit">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp", line = 1178,
 FQN="clang::CodeGen::CodeGenFunction::EmitAutoVarInit", NM="_ZN5clang7CodeGen15CodeGenFunction15EmitAutoVarInitERKNS1_15AutoVarEmissionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction15EmitAutoVarInitERKNS1_15AutoVarEmissionE")
//</editor-fold>
public final void EmitAutoVarInit(final /*const*/ AutoVarEmission /*&*/ emission) {
  ApplyDebugLocation DL = null;
  try {
    assert ((emission.Variable != null)) : "emission was not valid!";
    
    // If this was emitted as a global constant, we're done.
    if (emission.wasEmittedAsGlobal()) {
      return;
    }
    
    final /*const*/ VarDecl /*&*/ D = $Deref(emission.Variable);
    DL = ApplyDebugLocation.CreateDefaultArtificial(/*Deref*/$this(), D.getLocation());
    QualType type = D.getType();
    
    // If this local has an initializer, emit it now.
    /*const*/ Expr /*P*/ Init = D.getInit$Const();
    
    // If we are at an unreachable point, we don't need to emit the initializer
    // unless it contains a label.
    if (!$this().HaveInsertPoint()) {
      if (!(Init != null) || !CodeGenFunction.ContainsLabel(Init)) {
        return;
      }
      $this().EnsureInsertPoint();
    }
    
    // Initialize the structure of a __block variable.
    if (emission.IsByRef) {
      $this().emitByrefStructureInit(emission);
    }
    if ($this().isTrivialInitializer(Init)) {
      return;
    }
    
    // Check whether this is a byref variable that's potentially
    // captured and moved by its own initializer.  If so, we'll need to
    // emit the initializer first, then copy into the variable.
    boolean capturedByInit = emission.IsByRef && CGDeclStatics.isCapturedBy(D, Init);
    
    Address Loc = capturedByInit ? new Address(emission.Addr) : emission.getObjectAddress(/*Deref*/$this());
    
    Constant /*P*/ constant = null;
    if (emission.IsConstantAggregate || D.isConstexpr()) {
      assert (!capturedByInit) : "constant init contains a capturing block?";
      constant = $this().CGM.EmitConstantInit(D, $this());
    }
    if (!(constant != null)) {
      LValue lv = $this().MakeAddrLValue(new Address(Loc), new QualType(type));
      lv.setNonGC(true);
      $this().EmitExprAsInit(Init, $AddrOf(D), new LValue(lv), capturedByInit);
      /*JAVA:return*/return;
    }
    if (!emission.IsConstantAggregate) {
      // For simple scalar/complex initialization, store the value directly.
      LValue lv = $this().MakeAddrLValue(new Address(Loc), new QualType(type));
      lv.setNonGC(true);
      $this().EmitStoreThroughLValue(RValue.get(constant), new LValue(lv), true);
      /*JAVA:return*/return;
    }
    
    // If this is a simple aggregate initialization, we can optimize it
    // in various ways.
    boolean isVolatile = type.isVolatileQualified();
    
    Value /*P*/ SizeVal = ConstantInt.get(Unnamed_field8.IntPtrTy, 
        $this().getContext().getTypeSizeInChars(/*NO_COPY*/type).getQuantity());
    
    org.llvm.ir.Type /*P*/ BP = Unnamed_field9.Int8PtrTy;
    if (Loc.getType() != BP) {
      Loc.$assignMove($this().Builder.CreateBitCast(new Address(Loc), BP));
    }
    
    // If the initializer is all or mostly zeros, codegen with memset then do
    // a few stores afterward.
    if (CGDeclStatics.shouldUseMemSetPlusStoresToInitialize(constant, 
        $this().CGM.getDataLayout().getTypeAllocSize(constant.getType()))) {
      $this().Builder.CreateMemSet(new Address(Loc), ConstantInt.get(Int8Ty, $int2ulong(0)), SizeVal, 
          isVolatile);
      // Zero and undef don't require a stores.
      if (!constant.isNullValue() && !isa_UndefValue(constant)) {
        Loc.$assignMove($this().Builder.CreateBitCast(new Address(Loc), constant.getType().getPointerTo()));
        CGDeclStatics.emitStoresForInitAfterMemset(constant, Loc.getPointer(), 
            isVolatile, $this().Builder);
      }
    } else {
      // Otherwise, create a temporary global with the initializer then
      // memcpy from the global to the alloca.
      std.string Name = getStaticDeclName($this().CGM, D);
      final Constant /*P*/ L$constant = constant;
      GlobalVariable /*P*/ GV = /*NEW_EXPR [GlobalVariable::new]*/GlobalVariable.$new_GlobalVariable((type$ptr<?> New$Mem)->{
          return new GlobalVariable($this().CGM.getModule(), L$constant.getType(), true, 
                  GlobalValue.LinkageTypes.PrivateLinkage, 
                  L$constant, new Twine(Name));
       });
      GV.setAlignment($long2uint(Loc.getAlignment().getQuantity()));
      GV.setUnnamedAddr(GlobalValue.UnnamedAddr.Global);
      
      Address SrcPtr = new Address(GV, Loc.getAlignment());
      if (SrcPtr.getType() != BP) {
        SrcPtr.$assignMove($this().Builder.CreateBitCast(new Address(SrcPtr), BP));
      }
      
      $this().Builder.CreateMemCpy(new Address(Loc), new Address(SrcPtr), SizeVal, isVolatile);
    }
  } finally {
    if (DL != null) { DL.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitAutoVarCleanups">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp", line = 1382,
 FQN="clang::CodeGen::CodeGenFunction::EmitAutoVarCleanups", NM="_ZN5clang7CodeGen15CodeGenFunction19EmitAutoVarCleanupsERKNS1_15AutoVarEmissionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction19EmitAutoVarCleanupsERKNS1_15AutoVarEmissionE")
//</editor-fold>
public final void EmitAutoVarCleanups(final /*const*/ AutoVarEmission /*&*/ emission) {
  assert ((emission.Variable != null)) : "emission was not valid!";
  
  // If this was emitted as a global constant, we're done.
  if (emission.wasEmittedAsGlobal()) {
    return;
  }
  
  // If we don't have an insertion point, we're done.  Sema prevents
  // us from jumping into any of these scopes anyway.
  if (!$this().HaveInsertPoint()) {
    return;
  }
  
  final /*const*/ VarDecl /*&*/ D = $Deref(emission.Variable);
  
  // Make sure we call @llvm.lifetime.end.  This needs to happen
  // *last*, so the cleanup needs to be pushed *first*.
  if (emission.useLifetimeMarkers()) {
    $this().EHStack.<CallLifetimeEnd>pushCleanup$T(CleanupKind.NormalEHLifetimeMarker, 
        () -> new CallLifetimeEnd(
        emission.getAllocatedAddress(), 
        emission.getSizeForLifetimeMarkers()));
  }
  {
    
    // Check the type for a cleanup.
    QualType.DestructionKind dtorKind = D.getType().isDestructedType();
    if ((dtorKind.getValue() != 0)) {
      $this().emitAutoVarTypeCleanup(emission, dtorKind);
    }
  }
  
  // In GC mode, honor objc_precise_lifetime.
  if ($this().getLangOpts().getGC() != LangOptions.GCMode.NonGC
     && D.hasAttr(ObjCPreciseLifetimeAttr.class)) {
    $this().EHStack.<ExtendGCLifetime>pushCleanup$T(CleanupKind.NormalCleanup, () -> new ExtendGCLifetime(/*AddrOf*/D));
  }
  {
    
    // Handle the cleanup attribute.
    /*const*/ CleanupAttr /*P*/ CA = D.getAttr(CleanupAttr.class);
    if ((CA != null)) {
      /*const*/ FunctionDecl /*P*/ FD = CA.getFunctionDecl();
      
      Constant /*P*/ F = $this().CGM.GetAddrOfFunction(new GlobalDecl(FD));
      assert ((F != null)) : "Could not find function!";
      
      final /*const*/ CGFunctionInfo /*&*/ Info = $this().CGM.getTypes().arrangeFunctionDeclaration(FD);
      $this().EHStack.<CallCleanupFunction>pushCleanup$T(CleanupKind.NormalAndEHCleanup, () -> new CallCleanupFunction(F, /*AddrOf*/Info, /*AddrOf*/D));
    }
  }
  
  // If this is a block variable, call _Block_object_destroy
  // (on the unforwarded address).
  if (emission.IsByRef) {
    $this().enterByrefCleanup(emission);
  }
}


/// Enter a destroy cleanup for the given local variable.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::emitAutoVarTypeCleanup">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp", line = 1325,
 FQN="clang::CodeGen::CodeGenFunction::emitAutoVarTypeCleanup", NM="_ZN5clang7CodeGen15CodeGenFunction22emitAutoVarTypeCleanupERKNS1_15AutoVarEmissionENS_8QualType15DestructionKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction22emitAutoVarTypeCleanupERKNS1_15AutoVarEmissionENS_8QualType15DestructionKindE")
//</editor-fold>
public final void emitAutoVarTypeCleanup(final /*const*/ CodeGenFunction.AutoVarEmission /*&*/ emission, 
                      QualType.DestructionKind dtorKind) {
  assert (dtorKind != QualType.DestructionKind.DK_none);
  
  // Note that for __block variables, we want to destroy the
  // original stack object, not the possibly forwarded object.
  Address addr = emission.getObjectAddress(/*Deref*/$this());
  
  /*const*/ VarDecl /*P*/ var = emission.Variable;
  QualType type = var.getType();
  
  /*CleanupKind*//*uint*/int cleanupKind = CleanupKind.NormalAndEHCleanup;
  CodeGenFunction.AddressQualType2Void destroyer = null;
  switch (dtorKind) {
   case DK_none:
    throw new llvm_unreachable("no cleanup for trivially-destructible variable");
   case DK_cxx_destructor:
    // If there's an NRVO flag on the emission, we need a different
    // cleanup.
    if ((emission.NRVOFlag != null)) {
      assert (!type.$arrow().isArrayType());
      CXXDestructorDecl /*P*/ dtor = type.$arrow().getAsCXXRecordDecl().getDestructor();
      $this().EHStack.<DestroyNRVOVariable>pushCleanup$T(cleanupKind, 
          () -> new DestroyNRVOVariable(new Address(addr), 
          dtor, emission.NRVOFlag));
      return;
    }
    break;
   case DK_objc_strong_lifetime:
    // Suppress cleanups for pseudo-strong variables.
    if (var.isARCPseudoStrong()) {
      return;
    }
    
    // Otherwise, consider whether to use an EH cleanup or not.
    cleanupKind = $this().getARCCleanupKind();
    
    // Use the imprecise destroyer by default.
    if (!var.hasAttr(ObjCPreciseLifetimeAttr.class)) {
      destroyer = CodeGenFunction::destroyARCStrongImprecise;
    }
    break;
   case DK_objc_weak_lifetime:
    break;
  }
  
  // If we haven't chosen a more specific destroyer, use the default.
  if (!(destroyer != null)) {
    destroyer = $tryClone($this().getDestroyer(dtorKind));
  }
  
  // Use an EH cleanup in array destructors iff the destructor itself
  // is being pushed as an EH cleanup.
  boolean useEHCleanup = ((cleanupKind & CleanupKind.EHCleanup) != 0);
  CodeGenFunction.AddressQualType2Void $destroyer = destroyer;
  $this().EHStack.<DestroyObject>pushCleanup$T(cleanupKind, () -> new DestroyObject(new Address(addr), new QualType(type), $destroyer, 
      useEHCleanup));
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitStaticVarDecl">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp", line = 352,
 FQN="clang::CodeGen::CodeGenFunction::EmitStaticVarDecl", NM="_ZN5clang7CodeGen15CodeGenFunction17EmitStaticVarDeclERKNS_7VarDeclEN4llvm11GlobalValue12LinkageTypesE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction17EmitStaticVarDeclERKNS_7VarDeclEN4llvm11GlobalValue12LinkageTypesE")
//</editor-fold>
public final void EmitStaticVarDecl(final /*const*/ VarDecl /*&*/ D, 
                 GlobalValue.LinkageTypes Linkage) {
  // Check to see if we already have a global variable for this
  // declaration.  This can happen when double-emitting function
  // bodies, e.g. with complete and base constructors.
  Constant /*P*/ addr = $this().CGM.getOrCreateStaticVarDecl(D, Linkage);
  CharUnits alignment = $this().getContext().getDeclAlign($AddrOf(D));
  
  // Store into LocalDeclMap before generating initializer to handle
  // circular references.
  $this().setAddrOfLocalVar($AddrOf(D), new Address(addr, new CharUnits(alignment)));
  
  // We can't have a VLA here, but we can have a pointer to a VLA,
  // even though that doesn't really make any sense.
  // Make sure to evaluate VLA bounds now so that we have them for later.
  if (D.getType().$arrow().isVariablyModifiedType()) {
    $this().EmitVariablyModifiedType(D.getType());
  }
  
  // Save the type in case adding the initializer forces a type change.
  org.llvm.ir.Type /*P*/ expectedType = addr.getType();
  
  GlobalVariable /*P*/ var = cast_GlobalVariable(addr.stripPointerCasts());
  
  // CUDA's local and local static __shared__ variables should not
  // have any non-empty initializers. This is ensured by Sema.
  // Whatever initializer such variable may have when it gets here is
  // a no-op and should not be emitted.
  boolean isCudaSharedVar = $this().getLangOpts().CUDA && $this().getLangOpts().CUDAIsDevice
     && D.hasAttr(CUDASharedAttr.class);
  // If this value has an initializer, emit it.
  if ((D.getInit$Const() != null) && !isCudaSharedVar) {
    var = $this().AddInitializerToStaticVarDecl(D, var);
  }
  
  var.setAlignment($long2uint(alignment.getQuantity()));
  if (D.hasAttr(AnnotateAttr.class)) {
    $this().CGM.AddGlobalAnnotations($AddrOf(D), var);
  }
  {
    
    /*const*/ SectionAttr /*P*/ SA = D.getAttr(SectionAttr.class);
    if ((SA != null)) {
      var.setSection(SA.getName());
    }
  }
  if (D.hasAttr(UsedAttr.class)) {
    $this().CGM.addUsedGlobal(var);
  }
  
  // We may have to cast the constant because of the initializer
  // mismatch above.
  //
  // FIXME: It is really dangerous to store this in the map; if anyone
  // RAUW's the GV uses of this constant will be invalid.
  Constant /*P*/ castedAddr = ConstantExpr.getPointerBitCastOrAddrSpaceCast(var, expectedType);
  if (var != castedAddr) {
    $this().LocalDeclMap.find($AddrOf(D)).$arrow().second.$assignMove(new Address(castedAddr, new CharUnits(alignment)));
  }
  $this().CGM.setStaticLocalDeclAddress($AddrOf(D), castedAddr);
  
  $this().CGM.getSanitizerMetadata().reportGlobalToASan(var, D);
  
  // Emit global variable debug descriptor for static vars.
  CGDebugInfo /*P*/ DI = $this().getDebugInfo();
  if ((DI != null)
     && $this().CGM.getCodeGenOpts().getDebugInfo().getValue() >= DebugInfoKind.LimitedDebugInfo.getValue()) {
    DI.setLocation(D.getLocation());
    DI.EmitGlobalVariable(var, $AddrOf(D));
  }
}


/// EmitParmDecl - Emit a ParmVarDecl or an ImplicitParamDecl.
// end anonymous namespace

/// Emit an alloca (or GlobalValue depending on target)
/// for the specified parameter and set up LocalDeclMap.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::EmitParmDecl">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp", line = 1747,
 FQN="clang::CodeGen::CodeGenFunction::EmitParmDecl", NM="_ZN5clang7CodeGen15CodeGenFunction12EmitParmDeclERKNS_7VarDeclENS1_10ParamValueEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction12EmitParmDeclERKNS_7VarDeclENS1_10ParamValueEj")
//</editor-fold>
public final void EmitParmDecl(final /*const*/ VarDecl /*&*/ D, ParamValue Arg, 
            /*uint*/int ArgNo) {
  // FIXME: Why isn't ImplicitParamDecl a ParmVarDecl?
  assert ((isa_ParmVarDecl(D) || isa_ImplicitParamDecl(D))) : "Invalid argument to EmitParmDecl";
  
  Arg.getAnyValue().setName(new Twine(D.getName()));
  
  QualType Ty = D.getType();
  {
    
    // Use better IR generation for certain implicit parameters.
    /*const*/ ImplicitParamDecl /*P*/ IPD = dyn_cast_ImplicitParamDecl($AddrOf(D));
    if ((IPD != null)) {
      // The only implicit argument a block has is its literal.
      // We assume this is always passed directly.
      if (($this().BlockInfo != null)) {
        $this().setBlockContextParameter(IPD, ArgNo, Arg.getDirectValue());
        return;
      }
    }
  }
  
  Address DeclPtr = Address.invalid();
  boolean DoStore = false;
  boolean IsScalar = CodeGenFunction.hasScalarEvaluationKind(new QualType(Ty));
  // If we already have a pointer to the argument, reuse the input pointer.
  if (Arg.isIndirect()) {
    DeclPtr.$assignMove(Arg.getIndirectAddress());
    // If we have a prettier pointer type at this point, bitcast to that.
    /*uint*/int AS = DeclPtr.getType().getAddressSpace();
    org.llvm.ir.Type /*P*/ IRTy = $this().ConvertTypeForMem(new QualType(Ty)).getPointerTo(AS);
    if (DeclPtr.getType() != IRTy) {
      DeclPtr.$assignMove($this().Builder.CreateBitCast(new Address(DeclPtr), IRTy, new Twine(D.getName())));
    }
    
    // Push a destructor cleanup for this parameter if the ABI requires it.
    // Don't push a cleanup in a thunk for a method that will also emit a
    // cleanup.
    if (!IsScalar && !$this().CurFuncIsThunk
       && $this().getTarget().getCXXABI().areArgsDestroyedLeftToRightInCallee()) {
      /*const*/ CXXRecordDecl /*P*/ RD = Ty.$arrow().getAsCXXRecordDecl();
      if ((RD != null) && RD.hasNonTrivialDestructor()) {
        $this().pushDestroy(QualType.DestructionKind.DK_cxx_destructor, new Address(DeclPtr), new QualType(Ty));
      }
    }
  } else {
    // Otherwise, create a temporary to hold the value.
    DeclPtr.$assignMove($this().CreateMemTemp(new QualType(Ty), $this().getContext().getDeclAlign($AddrOf(D)), 
            $add_StringRef$C_char$ptr$C(D.getName(), /*KEEP_STR*/".addr")));
    DoStore = true;
  }
  
  Value /*P*/ ArgVal = (DoStore ? Arg.getDirectValue() : null);
  
  LValue lv = $this().MakeAddrLValue(new Address(DeclPtr), new QualType(Ty));
  if (IsScalar) {
    Qualifiers qs = Ty.getQualifiers();
    {
      Qualifiers.ObjCLifetime lt = qs.getObjCLifetime();
      if ((lt.getValue() != 0)) {
        // We honor __attribute__((ns_consumed)) for types with lifetime.
        // For __strong, it's handled by just skipping the initial retain;
        // otherwise we have to balance out the initial +1 with an extra
        // cleanup to do the release at the end of the function.
        boolean isConsumed = D.hasAttr(NSConsumedAttr.class);
        
        // 'self' is always formally __strong, but if this is not an
        // init method then we don't want to retain it.
        if (D.isARCPseudoStrong()) {
          /*const*/ ObjCMethodDecl /*P*/ method = cast_ObjCMethodDecl($this().CurCodeDecl);
          assert ($AddrOf(D) == method.getSelfDecl());
          assert (lt == Qualifiers.ObjCLifetime.OCL_Strong);
          assert (qs.hasConst());
          assert (method.getMethodFamily() != ObjCMethodFamily.OMF_init);
          ///*J:(void)*/method;
          lt = Qualifiers.ObjCLifetime.OCL_ExplicitNone;
        }
        if (lt == Qualifiers.ObjCLifetime.OCL_Strong) {
          if (!isConsumed) {
            if ($2bits_uint2uint($this().CGM.getCodeGenOpts().OptimizationLevel) == 0) {
              // use objc_storeStrong(&dest, value) for retaining the
              // object. But first, store a null into 'dest' because
              // objc_storeStrong attempts to release its old value.
              Value /*P*/ Null = $this().CGM.EmitNullConstant(D.getType());
              $this().EmitStoreOfScalar(Null, new LValue(lv), /* isInitialization */ true);
              $this().EmitARCStoreStrongCall(lv.getAddress(), ArgVal, true);
              DoStore = false;
            } else {
              // Don't use objc_retainBlock for block pointers, because we
              // don't want to Block_copy something just because we got it
              // as a parameter.
              ArgVal = $this().EmitARCRetainNonBlock(ArgVal);
            }
          }
        } else {
          // Push the cleanup for a consumed parameter.
          if (isConsumed) {
            ARCPreciseLifetime_t precise = (D.hasAttr(ObjCPreciseLifetimeAttr.class) ? ARCPreciseLifetime_t.ARCPreciseLifetime : ARCPreciseLifetime_t.ARCImpreciseLifetime);
            Value $ArgVal = ArgVal;
            $this().EHStack.<ConsumeARCParameter>pushCleanup$T($this().getARCCleanupKind(), () -> new ConsumeARCParameter($ArgVal, 
                precise));
          }
          if (lt == Qualifiers.ObjCLifetime.OCL_Weak) {
            $this().EmitARCInitWeak(new Address(DeclPtr), ArgVal);
            DoStore = false; // The weak init is a store, no need to do two.
          }
        }
        
        // Enter the cleanup scope.
        CGDeclStatics.EmitAutoVarWithLifetime(/*Deref*/$this(), D, new Address(DeclPtr), lt);
      }
    }
  }
  
  // Store the initial value into the alloca.
  if (DoStore) {
    $this().EmitStoreOfScalar(ArgVal, new LValue(lv), /* isInitialization */ true);
  }
  
  $this().setAddrOfLocalVar($AddrOf(D), new Address(DeclPtr));
  {
    
    // Emit debug info for param declaration.
    CGDebugInfo /*P*/ DI = $this().getDebugInfo();
    if ((DI != null)) {
      if ($this().CGM.getCodeGenOpts().getDebugInfo().getValue()
         >= DebugInfoKind.LimitedDebugInfo.getValue()) {
        DI.EmitDeclareOfArgVariable($AddrOf(D), DeclPtr.getPointer(), ArgNo, $this().Builder);
      }
    }
  }
  if (D.hasAttr(AnnotateAttr.class)) {
    $this().EmitVarAnnotations($AddrOf(D), DeclPtr.getPointer());
  }
}


/// AddInitializerToStaticVarDecl - Add the initializer for 'D' to the
/// global variable that has already been created for it.  If the initializer
/// has a different type than GV does, this may free GV and return a different
/// one.  Otherwise it just returns GV.

/// AddInitializerToStaticVarDecl - Add the initializer for 'D' to the
/// global variable that has already been created for it.  If the initializer
/// has a different type than GV does, this may free GV and return a different
/// one.  Otherwise it just returns GV.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::AddInitializerToStaticVarDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp", line = 291,
 FQN="clang::CodeGen::CodeGenFunction::AddInitializerToStaticVarDecl", NM="_ZN5clang7CodeGen15CodeGenFunction29AddInitializerToStaticVarDeclERKNS_7VarDeclEPN4llvm14GlobalVariableE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction29AddInitializerToStaticVarDeclERKNS_7VarDeclEPN4llvm14GlobalVariableE")
//</editor-fold>
public final GlobalVariable /*P*/ AddInitializerToStaticVarDecl(final /*const*/ VarDecl /*&*/ D, 
                             GlobalVariable /*P*/ GV) {
  Constant /*P*/ Init = $this().CGM.EmitConstantInit(D, $this());
  
  // If constant emission failed, then this should be a C++ static
  // initializer.
  if (!(Init != null)) {
    if (!$this().getLangOpts().CPlusPlus) {
      $this().CGM.ErrorUnsupported(D.getInit$Const(), $("constant l-value expression"));
    } else if (($this().Builder.GetInsertBlock() != null)) {
      // Since we have a static initializer, this global variable can't
      // be constant.
      GV.setConstant(false);
      
      $this().EmitCXXGuardedInit(D, GV, /*PerformInit*/ true);
    }
    return GV;
  }
  
  // The initializer may differ in type from the global. Rewrite
  // the global to match the initializer.  (We have to do this
  // because some types, like unions, can't be completely represented
  // in the LLVM type system.)
  if (GV.getType().getElementType() != Init.getType()) {
    GlobalVariable /*P*/ OldGV = GV;
    
    GV = /*NEW_EXPR [GlobalVariable::new]*/GlobalVariable.$new_GlobalVariable((type$ptr<?> New$Mem)->{
        return new GlobalVariable($this().CGM.getModule(), Init.getType(), 
                OldGV.isConstant(), 
                OldGV.getLinkage(), Init, new Twine(/*KEEP_STR*/$EMPTY), 
                /*InsertBefore*/ OldGV, 
                OldGV.getThreadLocalMode(), 
                $this().CGM.getContext().getTargetAddressSpace(D.getType()));
     });
    GV.setVisibility(OldGV.getVisibility());
    GV.setComdat(OldGV.getComdat());
    
    // Steal the name of the old global
    GV.takeName(OldGV);
    
    // Replace all uses of the old global with the new global
    Constant /*P*/ NewPtrForOldDecl = ConstantExpr.getBitCast(GV, OldGV.getType());
    OldGV.replaceAllUsesWith(NewPtrForOldDecl);
    
    // Erase the old global, since it is no longer used.
    OldGV.eraseFromParent();
  }
  
  GV.setConstant($this().CGM.isTypeConstant(D.getType(), true));
  GV.setInitializer(Init);
  if (CGDeclStatics.hasNontrivialDestruction(D.getType())) {
    // We have a constant initializer, but a nontrivial destructor. We still
    // need to perform a guarded "initialization" in order to register the
    // destructor.
    $this().EmitCXXGuardedInit(D, GV, /*PerformInit*/ false);
  }
  
  return GV;
}

} // END OF class CodeGenFunction_CGDecl
