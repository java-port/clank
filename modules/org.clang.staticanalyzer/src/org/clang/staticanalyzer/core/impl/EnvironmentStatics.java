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
package org.clang.staticanalyzer.core.impl;

import org.clank.support.*;
import org.clang.ast.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type EnvironmentStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Environment.cpp -nm=_ZL22ignoreTransparentExprsPKN5clang4ExprE;_ZL22ignoreTransparentExprsPKN5clang4StmtE; -static-type=EnvironmentStatics -package=org.clang.staticanalyzer.core.impl")
//</editor-fold>
public final class EnvironmentStatics {

//<editor-fold defaultstate="collapsed" desc="ignoreTransparentExprs">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Environment.cpp", line = 24,
 FQN="ignoreTransparentExprs", NM="_ZL22ignoreTransparentExprsPKN5clang4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Environment.cpp -nm=_ZL22ignoreTransparentExprsPKN5clang4ExprE")
//</editor-fold>
public static /*const*/ Expr /*P*/ ignoreTransparentExprs(/*const*/ Expr /*P*/ E) {
  E = E.IgnoreParens$Const();
  switch (E.getStmtClass()) {
   case OpaqueValueExprClass:
    E = cast_OpaqueValueExpr(E).getSourceExpr();
    break;
   case ExprWithCleanupsClass:
    E = cast_ExprWithCleanups(E).getSubExpr$Const();
    break;
   case CXXBindTemporaryExprClass:
    E = cast_CXXBindTemporaryExpr(E).getSubExpr$Const();
    break;
   case SubstNonTypeTemplateParmExprClass:
    E = cast_SubstNonTypeTemplateParmExpr(E).getReplacement();
    break;
   default:
    // This is the base case: we can't look through more than we already have.
    return E;
  }
  
  return ignoreTransparentExprs(E);
}

//<editor-fold defaultstate="collapsed" desc="ignoreTransparentExprs">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Environment.cpp", line = 48,
 FQN="ignoreTransparentExprs", NM="_ZL22ignoreTransparentExprsPKN5clang4StmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Environment.cpp -nm=_ZL22ignoreTransparentExprsPKN5clang4StmtE")
//</editor-fold>
public static /*const*/ Stmt /*P*/ ignoreTransparentExprs(/*const*/ Stmt /*P*/ S) {
  {
    /*const*/ Expr /*P*/ E = dyn_cast_Expr(S);
    if ((E != null)) {
      return ignoreTransparentExprs(E);
    }
  }
  return S;
}

} // END OF class EnvironmentStatics
