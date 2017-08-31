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
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.llvm.ir.*;
import org.clang.codegen.CodeGen.*;
import org.clang.codegen.CodeGen.impl.*;
import static org.clang.ast.AstClangGlobals.*;
import static org.clang.ast.java.AstTypesRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type CGVTablesStatics">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.clang.codegen.impl.CGVTablesStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZL18setThunkPropertiesRN5clang7CodeGen13CodeGenModuleERKNS_9ThunkInfoEPN4llvm8FunctionEbNS_10GlobalDeclE;_ZL18setThunkVisibilityRN5clang7CodeGen13CodeGenModuleEPKNS_13CXXMethodDeclERKNS_9ThunkInfoEPN4llvm8FunctionE;_ZL23PerformReturnAdjustmentRN5clang7CodeGen15CodeGenFunctionENS_8QualTypeENS0_6RValueERKNS_9ThunkInfoE;_ZL35shouldEmitAvailableExternallyVTableRKN5clang7CodeGen13CodeGenModuleEPKNS_13CXXRecordDeclE;_ZL38shouldEmitVTableAtEndOfTranslationUnitRN5clang7CodeGen13CodeGenModuleEPKNS_13CXXRecordDeclE;_ZL7similarRKN5clang7CodeGen10ABIArgInfoENS_7CanQualINS_4TypeEEES3_S6_; -static-type=CGVTablesStatics -package=org.clang.codegen.impl")
//</editor-fold>
public final class CGVTablesStatics {

//<editor-fold defaultstate="collapsed" desc="setThunkVisibility">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp", line = 53,
 FQN="setThunkVisibility", NM="_ZL18setThunkVisibilityRN5clang7CodeGen13CodeGenModuleEPKNS_13CXXMethodDeclERKNS_9ThunkInfoEPN4llvm8FunctionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZL18setThunkVisibilityRN5clang7CodeGen13CodeGenModuleEPKNS_13CXXMethodDeclERKNS_9ThunkInfoEPN4llvm8FunctionE")
//</editor-fold>
public static void setThunkVisibility(final CodeGenModule /*&*/ CGM, /*const*/ CXXMethodDecl /*P*/ MD, 
                  final /*const*/ ThunkInfo /*&*/ Thunk, Function /*P*/ Fn) {
  CGM.setGlobalVisibility(Fn, MD);
}

//<editor-fold defaultstate="collapsed" desc="setThunkProperties">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp", line = 58,
 FQN="setThunkProperties", NM="_ZL18setThunkPropertiesRN5clang7CodeGen13CodeGenModuleERKNS_9ThunkInfoEPN4llvm8FunctionEbNS_10GlobalDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZL18setThunkPropertiesRN5clang7CodeGen13CodeGenModuleERKNS_9ThunkInfoEPN4llvm8FunctionEbNS_10GlobalDeclE")
//</editor-fold>
public static void setThunkProperties(final CodeGenModule /*&*/ CGM, final /*const*/ ThunkInfo /*&*/ Thunk, 
                  Function /*P*/ ThunkFn, boolean ForVTable, 
                  GlobalDecl GD) {
  CGM.setFunctionLinkage(new GlobalDecl(GD), ThunkFn);
  CGM.getCXXABI().setThunkLinkage(ThunkFn, ForVTable, new GlobalDecl(GD), 
      !Thunk.Return.isEmpty());
  
  // Set the right visibility.
  /*const*/ CXXMethodDecl /*P*/ MD = cast_CXXMethodDecl(GD.getDecl());
  setThunkVisibility(CGM, MD, Thunk, ThunkFn);
  if (CGM.supportsCOMDAT() && ThunkFn.isWeakForLinker()) {
    ThunkFn.setComdat(CGM.getModule().getOrInsertComdat(ThunkFn.getName()));
  }
}

//<editor-fold defaultstate="collapsed" desc="similar">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp", line = 74,
 FQN="similar", NM="_ZL7similarRKN5clang7CodeGen10ABIArgInfoENS_7CanQualINS_4TypeEEES3_S6_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZL7similarRKN5clang7CodeGen10ABIArgInfoENS_7CanQualINS_4TypeEEES3_S6_")
//</editor-fold>
public static boolean similar(final /*const*/ ABIArgInfo /*&*/ infoL, CanQual<org.clang.ast.Type> typeL, 
       final /*const*/ ABIArgInfo /*&*/ infoR, CanQual<org.clang.ast.Type> typeR) {
  return (infoL.getKind() == infoR.getKind()
     && ($eq_CanQual$T_CanQual$U(/*NO_COPY*/typeL, /*NO_COPY*/typeR)
     || (isa_PointerType(typeL) && isa_PointerType(typeR))
     || (isa_ReferenceType(typeL) && isa_ReferenceType(typeR))));
}

//<editor-fold defaultstate="collapsed" desc="PerformReturnAdjustment">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp", line = 83,
 FQN="PerformReturnAdjustment", NM="_ZL23PerformReturnAdjustmentRN5clang7CodeGen15CodeGenFunctionENS_8QualTypeENS0_6RValueERKNS_9ThunkInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZL23PerformReturnAdjustmentRN5clang7CodeGen15CodeGenFunctionENS_8QualTypeENS0_6RValueERKNS_9ThunkInfoE")
//</editor-fold>
public static RValue PerformReturnAdjustment(final CodeGenFunction /*&*/ CGF, 
                       QualType ResultType, RValue RV, 
                       final /*const*/ ThunkInfo /*&*/ Thunk) {
  // Emit the return adjustment.
  boolean NullCheckValue = !ResultType.$arrow().isReferenceType();
  
  BasicBlock /*P*/ AdjustNull = null;
  BasicBlock /*P*/ AdjustNotNull = null;
  BasicBlock /*P*/ AdjustEnd = null;
  
  Value /*P*/ ReturnValue = RV.getScalarVal();
  if (NullCheckValue) {
    AdjustNull = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"adjust.null"));
    AdjustNotNull = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"adjust.notnull"));
    AdjustEnd = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"adjust.end"));
    
    Value /*P*/ IsNull = CGF.Builder.CreateIsNull(ReturnValue);
    CGF.Builder.CreateCondBr(IsNull, AdjustNull, AdjustNotNull);
    CGF.EmitBlock(AdjustNotNull);
  }
  
  CXXRecordDecl /*P*/ ClassDecl = ResultType.$arrow().getPointeeType().$arrow().getAsCXXRecordDecl();
  CharUnits ClassAlign = CGF.CGM.getClassPointerAlignment(ClassDecl);
  ReturnValue = CGF.CGM.getCXXABI().performReturnAdjustment(CGF, 
      new Address(ReturnValue, new CharUnits(ClassAlign)), 
      Thunk.Return);
  if (NullCheckValue) {
    CGF.Builder.CreateBr(AdjustEnd);
    CGF.EmitBlock(AdjustNull);
    CGF.Builder.CreateBr(AdjustEnd);
    CGF.EmitBlock(AdjustEnd);
    
    PHINode /*P*/ PHI = CGF.Builder.CreatePHI(ReturnValue.getType(), 2);
    PHI.addIncoming(ReturnValue, AdjustNotNull);
    PHI.addIncoming(Constant.getNullValue(ReturnValue.getType()), 
        AdjustNull);
    ReturnValue = PHI;
  }
  
  return RValue.get(ReturnValue);
}

//<editor-fold defaultstate="collapsed" desc="shouldEmitAvailableExternallyVTable">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp", line = 717,
 FQN="shouldEmitAvailableExternallyVTable", NM="_ZL35shouldEmitAvailableExternallyVTableRKN5clang7CodeGen13CodeGenModuleEPKNS_13CXXRecordDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZL35shouldEmitAvailableExternallyVTableRKN5clang7CodeGen13CodeGenModuleEPKNS_13CXXRecordDeclE")
//</editor-fold>
public static boolean shouldEmitAvailableExternallyVTable(final /*const*/ CodeGenModule /*&*/ CGM, 
                                   /*const*/ CXXRecordDecl /*P*/ RD) {
  return $2bits_uint2uint(CGM.getCodeGenOpts().OptimizationLevel) > 0
     && CGM.getCXXABI().canSpeculativelyEmitVTable(RD);
}


/// Given that we're currently at the end of the translation unit, and
/// we've emitted a reference to the vtable for this class, should
/// we define that vtable?
//<editor-fold defaultstate="collapsed" desc="shouldEmitVTableAtEndOfTranslationUnit">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp", line = 877,
 FQN="shouldEmitVTableAtEndOfTranslationUnit", NM="_ZL38shouldEmitVTableAtEndOfTranslationUnitRN5clang7CodeGen13CodeGenModuleEPKNS_13CXXRecordDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGVTables.cpp -nm=_ZL38shouldEmitVTableAtEndOfTranslationUnitRN5clang7CodeGen13CodeGenModuleEPKNS_13CXXRecordDeclE")
//</editor-fold>
public static boolean shouldEmitVTableAtEndOfTranslationUnit(final CodeGenModule /*&*/ CGM, 
                                      /*const*/ CXXRecordDecl /*P*/ RD) {
  // If vtable is internal then it has to be done.
  if (!CGM.getVTables().isVTableExternal(RD)) {
    return true;
  }
  
  // If it's external then maybe we will need it as available_externally.
  return shouldEmitAvailableExternallyVTable(CGM, RD);
}

} // END OF class CGVTablesStatics
