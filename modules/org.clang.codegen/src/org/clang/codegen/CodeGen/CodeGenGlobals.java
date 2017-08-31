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
package org.clang.codegen.CodeGen;

import org.clank.support.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.codegen.CodeGen.*;
import org.clang.codegen.CodeGen.impl.*;


//<editor-fold defaultstate="collapsed" desc="static type CodeGenGlobals">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.clang.codegen.CodeGen.CodeGenGlobals",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenABITypes.cpp -nm=_ZN5clang7CodeGen20arrangeCXXMethodTypeERNS0_13CodeGenModuleEPKNS_13CXXRecordDeclEPKNS_17FunctionProtoTypeEPKNS_13CXXMethodDeclE;_ZN5clang7CodeGen23arrangeFreeFunctionCallERNS0_13CodeGenModuleENS_7CanQualINS_4TypeEEEN4llvm8ArrayRefIS5_EENS_12FunctionType7ExtInfoENS0_12RequiredArgsE;_ZN5clang7CodeGen23arrangeFreeFunctionTypeERNS0_13CodeGenModuleENS_7CanQualINS_17FunctionProtoTypeEEEPKNS_12FunctionDeclE;_ZN5clang7CodeGen23arrangeFreeFunctionTypeERNS0_13CodeGenModuleENS_7CanQualINS_19FunctionNoProtoTypeEEE;_ZN5clang7CodeGen31arrangeObjCMessageSendSignatureERNS0_13CodeGenModuleEPKNS_14ObjCMethodDeclENS_8QualTypeE; -static-type=CodeGenGlobals -package=org.clang.codegen.CodeGen")
//</editor-fold>
public final class CodeGenGlobals {

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::arrangeObjCMessageSendSignature">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenABITypes.cpp", line = 29,
 FQN="clang::CodeGen::arrangeObjCMessageSendSignature", NM="_ZN5clang7CodeGen31arrangeObjCMessageSendSignatureERNS0_13CodeGenModuleEPKNS_14ObjCMethodDeclENS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenABITypes.cpp -nm=_ZN5clang7CodeGen31arrangeObjCMessageSendSignatureERNS0_13CodeGenModuleEPKNS_14ObjCMethodDeclENS_8QualTypeE")
//</editor-fold>
public static /*const*/ CGFunctionInfo /*&*/ arrangeObjCMessageSendSignature(final CodeGenModule /*&*/ CGM, 
                               /*const*/ ObjCMethodDecl /*P*/ MD, 
                               QualType receiverType) {
  return CGM.getTypes().arrangeObjCMessageSendSignature(MD, new QualType(receiverType));
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::arrangeFreeFunctionType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenABITypes.cpp", line = 36,
 FQN="clang::CodeGen::arrangeFreeFunctionType", NM="_ZN5clang7CodeGen23arrangeFreeFunctionTypeERNS0_13CodeGenModuleENS_7CanQualINS_17FunctionProtoTypeEEEPKNS_12FunctionDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenABITypes.cpp -nm=_ZN5clang7CodeGen23arrangeFreeFunctionTypeERNS0_13CodeGenModuleENS_7CanQualINS_17FunctionProtoTypeEEEPKNS_12FunctionDeclE")
//</editor-fold>
public static /*const*/ CGFunctionInfo /*&*/ arrangeFreeFunctionType(final CodeGenModule /*&*/ CGM, 
                       CanQual<FunctionProtoType> Ty, 
                       /*const*/ FunctionDecl /*P*/ FD) {
  return CGM.getTypes().arrangeFreeFunctionType(new CanQual<FunctionProtoType>(Ty), FD);
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::arrangeFreeFunctionType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenABITypes.cpp", line = 43,
 FQN="clang::CodeGen::arrangeFreeFunctionType", NM="_ZN5clang7CodeGen23arrangeFreeFunctionTypeERNS0_13CodeGenModuleENS_7CanQualINS_19FunctionNoProtoTypeEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenABITypes.cpp -nm=_ZN5clang7CodeGen23arrangeFreeFunctionTypeERNS0_13CodeGenModuleENS_7CanQualINS_19FunctionNoProtoTypeEEE")
//</editor-fold>
public static /*const*/ CGFunctionInfo /*&*/ arrangeFreeFunctionType(final CodeGenModule /*&*/ CGM, 
                       CanQual<FunctionNoProtoType> Ty) {
  return CGM.getTypes().arrangeFreeFunctionType(new CanQual<FunctionNoProtoType>(Ty));
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::arrangeCXXMethodType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenABITypes.cpp", line = 49,
 FQN="clang::CodeGen::arrangeCXXMethodType", NM="_ZN5clang7CodeGen20arrangeCXXMethodTypeERNS0_13CodeGenModuleEPKNS_13CXXRecordDeclEPKNS_17FunctionProtoTypeEPKNS_13CXXMethodDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenABITypes.cpp -nm=_ZN5clang7CodeGen20arrangeCXXMethodTypeERNS0_13CodeGenModuleEPKNS_13CXXRecordDeclEPKNS_17FunctionProtoTypeEPKNS_13CXXMethodDeclE")
//</editor-fold>
public static /*const*/ CGFunctionInfo /*&*/ arrangeCXXMethodType(final CodeGenModule /*&*/ CGM, 
                    /*const*/ CXXRecordDecl /*P*/ RD, 
                    /*const*/ FunctionProtoType /*P*/ FTP, 
                    /*const*/ CXXMethodDecl /*P*/ MD) {
  return CGM.getTypes().arrangeCXXMethodType(RD, FTP, MD);
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::arrangeFreeFunctionCall">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenABITypes.cpp", line = 57,
 FQN="clang::CodeGen::arrangeFreeFunctionCall", NM="_ZN5clang7CodeGen23arrangeFreeFunctionCallERNS0_13CodeGenModuleENS_7CanQualINS_4TypeEEEN4llvm8ArrayRefIS5_EENS_12FunctionType7ExtInfoENS0_12RequiredArgsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenABITypes.cpp -nm=_ZN5clang7CodeGen23arrangeFreeFunctionCallERNS0_13CodeGenModuleENS_7CanQualINS_4TypeEEEN4llvm8ArrayRefIS5_EENS_12FunctionType7ExtInfoENS0_12RequiredArgsE")
//</editor-fold>
public static /*const*/ CGFunctionInfo /*&*/ arrangeFreeFunctionCall(final CodeGenModule /*&*/ CGM, 
                       CanQual<org.clang.ast.Type> returnType, 
                       ArrayRef<CanQual<org.clang.ast.Type>> argTypes, 
                       org.clang.ast.FunctionType.ExtInfo info, 
                       RequiredArgs args) {
  return CGM.getTypes().arrangeLLVMFunctionInfo(new CanQual<org.clang.ast.Type>(returnType), /*IsInstanceMethod=*/ false, /*IsChainCall=*/ false, new ArrayRef<CanQual<org.clang.ast.Type>>(argTypes), 
      new org.clang.ast.FunctionType.ExtInfo(info), /*{ */new ArrayRef<FunctionProtoType.ExtParameterInfo>(false)/* }*/, new RequiredArgs(args));
}

} // END OF class CodeGenGlobals
