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
package org.clang.basic.impl;

import org.clank.support.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.basic.*;


//<editor-fold defaultstate="collapsed" desc="static type SpecifiersClangGlobals">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Checker.cpp ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp -nm=_ZN5clang18isLegalForFunctionENS_12StorageClassE;_ZN5clang18isLegalForVariableENS_12StorageClassE;_ZN5clang20supportsVariadicCallENS_11CallingConvE;_ZN5clang23getParameterABISpellingENS_12ParameterABIE;_ZN5clang23isTemplateInstantiationENS_26TemplateSpecializationKindE;_ZN5clang47isTemplateExplicitInstantiationOrSpecializationENS_26TemplateSpecializationKindE; -static-type=SpecifiersClangGlobals -package=org.clang.basic.impl")
//</editor-fold>
public final class SpecifiersClangGlobals {


/// \brief Determine whether this template specialization kind refers
/// to an instantiation of an entity (as opposed to a non-template or
/// an explicit specialization).
//<editor-fold defaultstate="collapsed" desc="clang::isTemplateInstantiation">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Specifiers.h", line = 165,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Specifiers.h", old_line = 162,
 FQN="clang::isTemplateInstantiation", NM="_ZN5clang23isTemplateInstantiationENS_26TemplateSpecializationKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Checker.cpp -nm=_ZN5clang23isTemplateInstantiationENS_26TemplateSpecializationKindE")
//</editor-fold>
public static /*inline*/ boolean isTemplateInstantiation(TemplateSpecializationKind Kind) {
  return Kind != TemplateSpecializationKind.TSK_Undeclared && Kind != TemplateSpecializationKind.TSK_ExplicitSpecialization;
}


/// \brief True if this template specialization kind is an explicit
/// specialization, explicit instantiation declaration, or explicit
/// instantiation definition.
//<editor-fold defaultstate="collapsed" desc="clang::isTemplateExplicitInstantiationOrSpecialization">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Specifiers.h", line = 172,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Specifiers.h", old_line = 169,
 FQN="clang::isTemplateExplicitInstantiationOrSpecialization", NM="_ZN5clang47isTemplateExplicitInstantiationOrSpecializationENS_26TemplateSpecializationKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Checker.cpp -nm=_ZN5clang47isTemplateExplicitInstantiationOrSpecializationENS_26TemplateSpecializationKindE")
//</editor-fold>
public static /*inline*/ boolean isTemplateExplicitInstantiationOrSpecialization(TemplateSpecializationKind Kind) {
  switch (Kind) {
   case TSK_ExplicitSpecialization:
   case TSK_ExplicitInstantiationDeclaration:
   case TSK_ExplicitInstantiationDefinition:
    return true;
   case TSK_Undeclared:
   case TSK_ImplicitInstantiation:
    return false;
  }
  throw new llvm_unreachable("bad template specialization kind");
}


/// \brief Checks whether the given storage class is legal for functions.
//<editor-fold defaultstate="collapsed" desc="clang::isLegalForFunction">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Specifiers.h", line = 214,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Specifiers.h", old_line = 211,
 FQN="clang::isLegalForFunction", NM="_ZN5clang18isLegalForFunctionENS_12StorageClassE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Checker.cpp -nm=_ZN5clang18isLegalForFunctionENS_12StorageClassE")
//</editor-fold>
public static /*inline*/ boolean isLegalForFunction(StorageClass SC) {
  return SC.getValue() <= StorageClass.SC_PrivateExtern.getValue();
}


/// \brief Checks whether the given storage class is legal for variables.
//<editor-fold defaultstate="collapsed" desc="clang::isLegalForVariable">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Specifiers.h", line = 219,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Specifiers.h", old_line = 216,
 FQN="clang::isLegalForVariable", NM="_ZN5clang18isLegalForVariableENS_12StorageClassE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Checker.cpp -nm=_ZN5clang18isLegalForVariableENS_12StorageClassE")
//</editor-fold>
public static /*inline*/ boolean isLegalForVariable(StorageClass SC) {
  return true;
}


/// \brief Checks whether the given calling convention supports variadic
/// calls. Unprototyped calls also use the variadic call rules.
//<editor-fold defaultstate="collapsed" desc="clang::supportsVariadicCall">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Specifiers.h", line = 252,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Specifiers.h", old_line = 246,
 FQN="clang::supportsVariadicCall", NM="_ZN5clang20supportsVariadicCallENS_11CallingConvE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Checker.cpp -nm=_ZN5clang20supportsVariadicCallENS_11CallingConvE")
//</editor-fold>
public static /*inline*/ boolean supportsVariadicCall(CallingConv CC) {
  switch (CC) {
   case CC_X86StdCall:
   case CC_X86FastCall:
   case CC_X86ThisCall:
   case CC_X86Pascal:
   case CC_X86VectorCall:
   case CC_SpirFunction:
   case CC_OpenCLKernel:
   case CC_Swift:
    return false;
   default:
    return true;
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::getParameterABISpelling">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp", line = 636,
 FQN="clang::getParameterABISpelling", NM="_ZN5clang23getParameterABISpellingENS_12ParameterABIE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp -nm=_ZN5clang23getParameterABISpellingENS_12ParameterABIE")
//</editor-fold>
public static StringRef getParameterABISpelling(ParameterABI ABI) {
  switch (ABI) {
   case Ordinary:
    throw new llvm_unreachable("asking for spelling of ordinary parameter ABI");
   case SwiftContext:
    return new StringRef(/*KEEP_STR*/"swift_context");
   case SwiftErrorResult:
    return new StringRef(/*KEEP_STR*/"swift_error_result");
   case SwiftIndirectResult:
    return new StringRef(/*KEEP_STR*/"swift_indirect_result");
  }
  throw new llvm_unreachable("bad parameter ABI kind");
}

} // END OF class SpecifiersClangGlobals
