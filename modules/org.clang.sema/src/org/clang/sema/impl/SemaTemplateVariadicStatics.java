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

import org.clank.java.*;
import org.clank.support.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import org.clang.ast.*;
;
import org.clang.basic.*;
import org.clang.sema.*;
import static org.clang.sema.Sema_NestedClasses.SemaDiagnosticBuilder.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type SemaTemplateVariadicStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateVariadic.cpp -nm=_ZL16CheckFoldOperandRN5clang4SemaEPNS_4ExprE;_ZL16getDepthAndIndexPN5clang9NamedDeclE; -static-type=SemaTemplateVariadicStatics -package=org.clang.sema.impl")
//</editor-fold>
public final class SemaTemplateVariadicStatics {


/// \brief Retrieve the depth and index of a parameter pack.
//<editor-fold defaultstate="collapsed" desc="getDepthAndIndex">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateVariadic.cpp", line = 526,
 FQN="getDepthAndIndex", NM="_ZL16getDepthAndIndexPN5clang9NamedDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateVariadic.cpp -nm=_ZL16getDepthAndIndexPN5clang9NamedDeclE")
//</editor-fold>
public static std.pairUIntUInt getDepthAndIndex(NamedDecl /*P*/ ND) {
  {
    TemplateTypeParmDecl /*P*/ TTP = dyn_cast_TemplateTypeParmDecl(ND);
    if ((TTP != null)) {
      return std.make_pair_uint_uint(TTP.getDepth(), TTP.getIndex());
    }
  }
  {
    
    NonTypeTemplateParmDecl /*P*/ NTTP = dyn_cast_NonTypeTemplateParmDecl(ND);
    if ((NTTP != null)) {
      return std.make_pair_uint_uint(NTTP.getDepth(), NTTP.getIndex());
    }
  }
  
  TemplateTemplateParmDecl /*P*/ TTP = cast_TemplateTemplateParmDecl(ND);
  return std.make_pair_uint_uint(TTP.getDepth(), TTP.getIndex());
}

//<editor-fold defaultstate="collapsed" desc="CheckFoldOperand">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateVariadic.cpp", line = 939,
 FQN="CheckFoldOperand", NM="_ZL16CheckFoldOperandRN5clang4SemaEPNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateVariadic.cpp -nm=_ZL16CheckFoldOperandRN5clang4SemaEPNS_4ExprE")
//</editor-fold>
public static void CheckFoldOperand(final Sema /*&*/ S, Expr /*P*/ E) {
  if (!(E != null)) {
    return;
  }
  
  E = E.IgnoreImpCasts();
  if (isa_BinaryOperator(E) || isa_AbstractConditionalOperator(E)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(E.getExprLoc(), diag.err_fold_expression_bad_operand)), 
                  E.getSourceRange()), 
              FixItHint.CreateInsertion(E.getLocStart(), new StringRef(/*KEEP_STR*/$LPAREN))), 
          FixItHint.CreateInsertion(E.getLocEnd(), new StringRef(/*KEEP_STR*/$RPAREN))));
    } finally {
      $c$.$destroy();
    }
  }
}

} // END OF class SemaTemplateVariadicStatics
