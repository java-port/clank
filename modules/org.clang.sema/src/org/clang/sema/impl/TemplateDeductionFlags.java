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

package org.clang.sema.impl;

import org.clank.support.*;

/// \brief Various flags that control template argument deduction.
///
/// These flags can be bitwise-OR'd together.
//<editor-fold defaultstate="collapsed" desc="clang::TemplateDeductionFlags">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp", line = 33,
 FQN="clang::TemplateDeductionFlags", NM="_ZN5clang22TemplateDeductionFlagsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZN5clang22TemplateDeductionFlagsE")
//</editor-fold>
public final class/*enum*/ TemplateDeductionFlags {
  /// \brief No template argument deduction flags, which indicates the
  /// strictest results for template argument deduction (as used for, e.g.,
  /// matching class template partial specializations).
  public static final /*uint*/int TDF_None = 0;
  /// \brief Within template argument deduction from a function call, we are
  /// matching with a parameter type for which the original parameter was
  /// a reference.
  public static final /*uint*/int TDF_ParamWithReferenceType = 0x1;
  /// \brief Within template argument deduction from a function call, we
  /// are matching in a case where we ignore cv-qualifiers.
  public static final /*uint*/int TDF_IgnoreQualifiers = 0x02;
  /// \brief Within template argument deduction from a function call,
  /// we are matching in a case where we can perform template argument
  /// deduction from a template-id of a derived class of the argument type.
  public static final /*uint*/int TDF_DerivedClass = 0x04;
  /// \brief Allow non-dependent types to differ, e.g., when performing
  /// template argument deduction from a function call where conversions
  /// may apply.
  public static final /*uint*/int TDF_SkipNonDependent = 0x08;
  /// \brief Whether we are performing template argument deduction for
  /// parameters and arguments in a top-level template argument
  public static final /*uint*/int TDF_TopLevelParameterTypeList = 0x10;
  /// \brief Within template argument deduction from overload resolution per
  /// C++ [over.over] allow matching function types that are compatible in
  /// terms of noreturn and default calling convention adjustments.
  public static final /*uint*/int TDF_InOverloadResolution = 0x20;
}
