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
import org.clang.basic.*;


//<editor-fold defaultstate="collapsed" desc="static type ExceptionSpecificationTypeClangGlobals">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprClassification.cpp -nm=_ZN5clang13mergeCanThrowENS_14CanThrowResultES0_;_ZN5clang22isDynamicExceptionSpecENS_26ExceptionSpecificationTypeE;_ZN5clang23isNoexceptExceptionSpecENS_26ExceptionSpecificationTypeE;_ZN5clang25isUnresolvedExceptionSpecENS_26ExceptionSpecificationTypeE; -static-type=ExceptionSpecificationTypeClangGlobals -package=org.clang.basic.impl")
//</editor-fold>
public final class ExceptionSpecificationTypeClangGlobals {

//<editor-fold defaultstate="collapsed" desc="clang::isDynamicExceptionSpec">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ExceptionSpecificationType.h", line = 33,
 FQN="clang::isDynamicExceptionSpec", NM="_ZN5clang22isDynamicExceptionSpecENS_26ExceptionSpecificationTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprClassification.cpp -nm=_ZN5clang22isDynamicExceptionSpecENS_26ExceptionSpecificationTypeE")
//</editor-fold>
public static /*inline*/ boolean isDynamicExceptionSpec(ExceptionSpecificationType ESpecType) {
  return ESpecType.getValue() >= ExceptionSpecificationType.EST_DynamicNone.getValue() && ESpecType.getValue() <= ExceptionSpecificationType.EST_MSAny.getValue();
}

//<editor-fold defaultstate="collapsed" desc="clang::isNoexceptExceptionSpec">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ExceptionSpecificationType.h", line = 37,
 FQN="clang::isNoexceptExceptionSpec", NM="_ZN5clang23isNoexceptExceptionSpecENS_26ExceptionSpecificationTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprClassification.cpp -nm=_ZN5clang23isNoexceptExceptionSpecENS_26ExceptionSpecificationTypeE")
//</editor-fold>
public static /*inline*/ boolean isNoexceptExceptionSpec(ExceptionSpecificationType ESpecType) {
  return ESpecType == ExceptionSpecificationType.EST_BasicNoexcept || ESpecType == ExceptionSpecificationType.EST_ComputedNoexcept;
}

//<editor-fold defaultstate="collapsed" desc="clang::isUnresolvedExceptionSpec">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ExceptionSpecificationType.h", line = 41,
 FQN="clang::isUnresolvedExceptionSpec", NM="_ZN5clang25isUnresolvedExceptionSpecENS_26ExceptionSpecificationTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprClassification.cpp -nm=_ZN5clang25isUnresolvedExceptionSpecENS_26ExceptionSpecificationTypeE")
//</editor-fold>
public static /*inline*/ boolean isUnresolvedExceptionSpec(ExceptionSpecificationType ESpecType) {
  return ESpecType == ExceptionSpecificationType.EST_Unevaluated || ESpecType == ExceptionSpecificationType.EST_Uninstantiated;
}

//<editor-fold defaultstate="collapsed" desc="clang::mergeCanThrow">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ExceptionSpecificationType.h", line = 52,
 FQN="clang::mergeCanThrow", NM="_ZN5clang13mergeCanThrowENS_14CanThrowResultES0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprClassification.cpp -nm=_ZN5clang13mergeCanThrowENS_14CanThrowResultES0_")
//</editor-fold>
public static /*inline*/ CanThrowResult mergeCanThrow(CanThrowResult CT1, CanThrowResult CT2) {
  // CanThrowResult constants are ordered so that the maximum is the correct
  // merge result.
  return CT1.getValue() > CT2.getValue() ? CT1 : CT2;
}

} // END OF class ExceptionSpecificationTypeClangGlobals
