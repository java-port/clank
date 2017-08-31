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
package org.clang.parse.impl;

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import static org.clang.basic.BasicClangGlobals.*;
import org.clang.basic.*;
import org.clang.sema.*;
import org.clang.parse.*;


//<editor-fold defaultstate="collapsed" desc="static type ParseDeclCXXStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDeclCXX.cpp -nm=_ZL33IsBuiltInOrStandardCXX11AttributePN5clang14IdentifierInfoES1_;_ZL37diagnoseDynamicExceptionSpecificationRN5clang6ParserENS_11SourceRangeEb; -static-type=ParseDeclCXXStatics -package=org.clang.parse.impl")
//</editor-fold>
public final class ParseDeclCXXStatics {

//<editor-fold defaultstate="collapsed" desc="diagnoseDynamicExceptionSpecification">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDeclCXX.cpp", line = 3455,
 FQN="diagnoseDynamicExceptionSpecification", NM="_ZL37diagnoseDynamicExceptionSpecificationRN5clang6ParserENS_11SourceRangeEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDeclCXX.cpp -nm=_ZL37diagnoseDynamicExceptionSpecificationRN5clang6ParserENS_11SourceRangeEb")
//</editor-fold>
public static void diagnoseDynamicExceptionSpecification(Parser /*&*/ P, SourceRange Range, boolean IsNoexcept) {
  if (P.getLangOpts().CPlusPlus11) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      /*const*/char$ptr/*char P*/ Replacement = $tryClone(IsNoexcept ? $noexcept : $("noexcept(false)"));
      $c$.clean($out_DiagnosticBuilder$C_SourceRange($c$.track(P.Diag(Range.getBegin(), diag.warn_exception_spec_deprecated)), /*NO_COPY*/Range));
      $c$.clean($out_DiagnosticBuilder$C_FixItHint$C($out_DiagnosticBuilder$C_char$ptr$C($c$.track(P.Diag(Range.getBegin(), diag.note_exception_spec_deprecated)), 
              Replacement), FixItHint.CreateReplacement(/*NO_COPY*/Range, new StringRef(Replacement))));
    } finally {
      $c$.$destroy();
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="IsBuiltInOrStandardCXX11Attribute">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDeclCXX.cpp", line = 3647,
 FQN="IsBuiltInOrStandardCXX11Attribute", NM="_ZL33IsBuiltInOrStandardCXX11AttributePN5clang14IdentifierInfoES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseDeclCXX.cpp -nm=_ZL33IsBuiltInOrStandardCXX11AttributePN5clang14IdentifierInfoES1_")
//</editor-fold>
public static boolean IsBuiltInOrStandardCXX11Attribute(IdentifierInfo /*P*/ AttrName, 
                                 IdentifierInfo /*P*/ ScopeName) {
  switch (AttributeList.getKind(AttrName, ScopeName, 
      AttributeList.Syntax.AS_CXX11)) {
   case AT_CarriesDependency:
   case AT_Deprecated:
   case AT_FallThrough:
   case AT_CXX11NoReturn:
    return true;
   case AT_WarnUnusedResult:
    return !(ScopeName != null) && AttrName.getName().equals(/*STRINGREF_STR*/"nodiscard");
   case AT_Unused:
    return !(ScopeName != null) && AttrName.getName().equals(/*STRINGREF_STR*/"maybe_unused");
   default:
    return false;
  }
}

} // END OF class ParseDeclCXXStatics
