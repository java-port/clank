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

import org.clank.support.*;
import org.clang.basic.*;
import org.clang.codegen.CodeGen.impl.*;


//<editor-fold defaultstate="collapsed" desc="static type CodeGenStatics">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.clang.codegen.CodeGen.impl.CodeGenStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -body-delegate -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCUDANV.cpp ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTypes.cpp ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN5clang7CodeGen13toCXXCtorTypeENS0_12StructorTypeE;_ZN5clang7CodeGen13toCXXDtorTypeENS0_12StructorTypeE;_ZN5clang7CodeGen15getFromCtorTypeENS_11CXXCtorTypeE;_ZN5clang7CodeGen15getFromDtorTypeENS_11CXXDtorTypeE;_ZN5clang7CodeGen19CreateItaniumCXXABIERNS0_13CodeGenModuleE;_ZN5clang7CodeGen19CreateNVCUDARuntimeERNS0_13CodeGenModuleE;_ZN5clang7CodeGen20CreateGNUObjCRuntimeERNS0_13CodeGenModuleE;_ZN5clang7CodeGen20CreateMacObjCRuntimeERNS0_13CodeGenModuleE;_ZN5clang7CodeGen21CreateMicrosoftCXXABIERNS0_13CodeGenModuleE;_ZN5clang7CodeGenL23getFieldAlignmentSourceENS0_15AlignmentSourceE;_ZN5clang7CodeGenorENS0_16BlockFieldFlag_tES1_;_ZN5clang7CodeGenorENS0_17BlockLiteralFlagsES1_; -static-type=CodeGenStatics -package=org.clang.codegen.CodeGen.impl")
//</editor-fold>
public final class CodeGenStatics {


/// Given that the base address has the given alignment source, what's
/// our confidence in the alignment of the field?
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::getFieldAlignmentSource">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGValue.h", line = 143,
 FQN="clang::CodeGen::getFieldAlignmentSource", NM="_ZN5clang7CodeGenL23getFieldAlignmentSourceENS0_15AlignmentSourceE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZN5clang7CodeGenL23getFieldAlignmentSourceENS0_15AlignmentSourceE")
//</editor-fold>
public static /*inline*/ AlignmentSource getFieldAlignmentSource(AlignmentSource Source) {
  return /*delegate*/org.clang.codegen.CodeGen.impl.CGValueCodeGenStatics.
    getFieldAlignmentSource(Source);
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::toCXXCtorType">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTypes.h", line = 65,
 FQN="clang::CodeGen::toCXXCtorType", NM="_ZN5clang7CodeGen13toCXXCtorTypeENS0_12StructorTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZN5clang7CodeGen13toCXXCtorTypeENS0_12StructorTypeE")
//</editor-fold>
public static /*inline*/ CXXCtorType toCXXCtorType(StructorType T) {
  return /*delegate*/org.clang.codegen.CodeGen.impl.CodeGenTypesCodeGenStatics.
    toCXXCtorType(T);
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::getFromCtorType">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTypes.h", line = 77,
 FQN="clang::CodeGen::getFromCtorType", NM="_ZN5clang7CodeGen15getFromCtorTypeENS_11CXXCtorTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZN5clang7CodeGen15getFromCtorTypeENS_11CXXCtorTypeE")
//</editor-fold>
public static /*inline*/ StructorType getFromCtorType(CXXCtorType T) {
  return /*delegate*/org.clang.codegen.CodeGen.impl.CodeGenTypesCodeGenStatics.
    getFromCtorType(T);
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::toCXXDtorType">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTypes.h", line = 92,
 FQN="clang::CodeGen::toCXXDtorType", NM="_ZN5clang7CodeGen13toCXXDtorTypeENS0_12StructorTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZN5clang7CodeGen13toCXXDtorTypeENS0_12StructorTypeE")
//</editor-fold>
public static /*inline*/ CXXDtorType toCXXDtorType(StructorType T) {
  return /*delegate*/org.clang.codegen.CodeGen.impl.CodeGenTypesCodeGenStatics.
    toCXXDtorType(T);
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::getFromDtorType">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTypes.h", line = 104,
 FQN="clang::CodeGen::getFromDtorType", NM="_ZN5clang7CodeGen15getFromDtorTypeENS_11CXXDtorTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZN5clang7CodeGen15getFromDtorTypeENS_11CXXDtorTypeE")
//</editor-fold>
public static /*inline*/ StructorType getFromDtorType(CXXDtorType T) {
  return /*delegate*/org.clang.codegen.CodeGen.impl.CodeGenTypesCodeGenStatics.
    getFromDtorType(T);
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::operator|">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.h", line = 94,
 FQN="clang::CodeGen::operator|", NM="_ZN5clang7CodeGenorENS0_17BlockLiteralFlagsES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZN5clang7CodeGenorENS0_17BlockLiteralFlagsES1_")
//</editor-fold>
public static /*inline*/ BlockFlags $bitor_BlockLiteralFlags(/*BlockLiteralFlags*/int l, /*BlockLiteralFlags*/int r) {
  return /*delegate*/org.clang.codegen.CodeGen.impl.CGBlocksCodeGenStatics.
    $bitor_BlockLiteralFlags(l, r);
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::operator|">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.h", line = 139,
 FQN="clang::CodeGen::operator|", NM="_ZN5clang7CodeGenorENS0_16BlockFieldFlag_tES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZN5clang7CodeGenorENS0_16BlockFieldFlag_tES1_")
//</editor-fold>
public static /*inline*/ BlockFieldFlags $bitor_BlockFieldFlag_t(/*BlockFieldFlag_t*//*uint*/int l, /*BlockFieldFlag_t*//*uint*/int r) {
  return /*delegate*/org.clang.codegen.CodeGen.impl.CGBlocksCodeGenStatics.
    $bitor_BlockFieldFlag_t(l, r);
}


/// Creates an instance of a CUDA runtime class.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CreateNVCUDARuntime">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCUDANV.cpp", line = 365,
 FQN="clang::CodeGen::CreateNVCUDARuntime", NM="_ZN5clang7CodeGen19CreateNVCUDARuntimeERNS0_13CodeGenModuleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCUDANV.cpp -nm=_ZN5clang7CodeGen19CreateNVCUDARuntimeERNS0_13CodeGenModuleE")
//</editor-fold>
public static CGCUDARuntime /*P*/ CreateNVCUDARuntime(final CodeGenModule /*&*/ CGM) {
  return /*delegate*/org.clang.codegen.CodeGen.impl.CGCUDANVCodeGenStatics.
    CreateNVCUDARuntime(CGM);
}


/// Creates an instance of an Objective-C runtime class.
//TODO: This should include some way of selecting which runtime to target.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CreateGNUObjCRuntime">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp", line = 2937,
 FQN="clang::CodeGen::CreateGNUObjCRuntime", NM="_ZN5clang7CodeGen20CreateGNUObjCRuntimeERNS0_13CodeGenModuleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp -nm=_ZN5clang7CodeGen20CreateGNUObjCRuntimeERNS0_13CodeGenModuleE")
//</editor-fold>
public static CGObjCRuntime /*P*/ CreateGNUObjCRuntime(final CodeGenModule /*&*/ CGM) {
  return /*delegate*/org.clang.codegen.CodeGen.impl.CGObjCGNUCodeGenStatics.
    CreateGNUObjCRuntime(CGM);
}


/* *** */
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CreateMacObjCRuntime">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 7374,
 FQN="clang::CodeGen::CreateMacObjCRuntime", NM="_ZN5clang7CodeGen20CreateMacObjCRuntimeERNS0_13CodeGenModuleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN5clang7CodeGen20CreateMacObjCRuntimeERNS0_13CodeGenModuleE")
//</editor-fold>
public static CGObjCRuntime /*P*/ CreateMacObjCRuntime(final CodeGenModule /*&*/ CGM) {
  return /*delegate*/org.clang.codegen.CodeGen.impl.CGObjCMacCodeGenStatics.
    CreateMacObjCRuntime(CGM);
}


// Create an instance of a C++ ABI class:

/// Creates an Itanium-family ABI.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CreateItaniumCXXABI">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 450,
 FQN="clang::CodeGen::CreateItaniumCXXABI", NM="_ZN5clang7CodeGen19CreateItaniumCXXABIERNS0_13CodeGenModuleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZN5clang7CodeGen19CreateItaniumCXXABIERNS0_13CodeGenModuleE")
//</editor-fold>
public static CGCXXABI /*P*/ CreateItaniumCXXABI(final CodeGenModule /*&*/ CGM) {
  return /*delegate*/org.clang.codegen.CodeGen.impl.ItaniumCXXABICodeGenStatics.
    CreateItaniumCXXABI(CGM);
}


/// Creates a Microsoft-family ABI.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CreateMicrosoftCXXABI">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 3275,
 FQN="clang::CodeGen::CreateMicrosoftCXXABI", NM="_ZN5clang7CodeGen21CreateMicrosoftCXXABIERNS0_13CodeGenModuleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN5clang7CodeGen21CreateMicrosoftCXXABIERNS0_13CodeGenModuleE")
//</editor-fold>
public static CGCXXABI /*P*/ CreateMicrosoftCXXABI(final CodeGenModule /*&*/ CGM) {
  return /*delegate*/org.clang.codegen.CodeGen.impl.MicrosoftCXXABICodeGenStatics.
    CreateMicrosoftCXXABI(CGM);
}

} // END OF class CodeGenStatics
