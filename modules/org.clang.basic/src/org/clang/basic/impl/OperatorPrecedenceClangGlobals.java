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


//<editor-fold defaultstate="collapsed" desc="static type OperatorPrecedenceClangGlobals">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/OperatorPrecedence.cpp -nm=_ZN5clang18getBinOpPrecedenceENS_3tok9TokenKindEbb; -static-type=OperatorPrecedenceClangGlobals -package=org.clang.basic.impl")
//</editor-fold>
public final class OperatorPrecedenceClangGlobals {


/// \brief Return the precedence of the specified binary operator token.
//<editor-fold defaultstate="collapsed" desc="clang::getBinOpPrecedence">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/OperatorPrecedence.cpp", line = 18,
 FQN="clang::getBinOpPrecedence", NM="_ZN5clang18getBinOpPrecedenceENS_3tok9TokenKindEbb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/OperatorPrecedence.cpp -nm=_ZN5clang18getBinOpPrecedenceENS_3tok9TokenKindEbb")
//</editor-fold>
public static prec.Level getBinOpPrecedence(/*tok.TokenKind*/char Kind, boolean GreaterThanIsOperator, 
                  boolean CPlusPlus11) {
  switch (Kind) {
   case tok.TokenKind.greater:
    // C++ [temp.names]p3:
    //   [...] When parsing a template-argument-list, the first
    //   non-nested > is taken as the ending delimiter rather than a
    //   greater-than operator. [...]
    if (GreaterThanIsOperator) {
      return prec.Level.Relational;
    }
    return prec.Level.Unknown;
   case tok.TokenKind.greatergreater:
    // C++11 [temp.names]p3:
    //
    //   [...] Similarly, the first non-nested >> is treated as two
    //   consecutive but distinct > tokens, the first of which is
    //   taken as the end of the template-argument-list and completes
    //   the template-id. [...]
    if (GreaterThanIsOperator || !CPlusPlus11) {
      return prec.Level.Shift;
    }
    return prec.Level.Unknown;
   default:
    return prec.Level.Unknown;
   case tok.TokenKind.comma:
    return prec.Level.Comma;
   case tok.TokenKind.equal:
   case tok.TokenKind.starequal:
   case tok.TokenKind.slashequal:
   case tok.TokenKind.percentequal:
   case tok.TokenKind.plusequal:
   case tok.TokenKind.minusequal:
   case tok.TokenKind.lesslessequal:
   case tok.TokenKind.greatergreaterequal:
   case tok.TokenKind.ampequal:
   case tok.TokenKind.caretequal:
   case tok.TokenKind.pipeequal:
    return prec.Level.Assignment;
   case tok.TokenKind.question:
    return prec.Level.Conditional;
   case tok.TokenKind.pipepipe:
    return prec.Level.LogicalOr;
   case tok.TokenKind.caretcaret:
   case tok.TokenKind.ampamp:
    return prec.Level.LogicalAnd;
   case tok.TokenKind.pipe:
    return prec.Level.InclusiveOr;
   case tok.TokenKind.caret:
    return prec.Level.ExclusiveOr;
   case tok.TokenKind.amp:
    return prec.Level.And;
   case tok.TokenKind.exclaimequal:
   case tok.TokenKind.equalequal:
    return prec.Level.Equality;
   case tok.TokenKind.lessequal:
   case tok.TokenKind.less:
   case tok.TokenKind.greaterequal:
    return prec.Level.Relational;
   case tok.TokenKind.lessless:
    return prec.Level.Shift;
   case tok.TokenKind.plus:
   case tok.TokenKind.minus:
    return prec.Level.Additive;
   case tok.TokenKind.percent:
   case tok.TokenKind.slash:
   case tok.TokenKind.star:
    return prec.Level.Multiplicative;
   case tok.TokenKind.periodstar:
   case tok.TokenKind.arrowstar:
    return prec.Level.PointerToMember;
  }
}

} // END OF class OperatorPrecedenceClangGlobals
