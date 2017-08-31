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
import static org.llvm.support.llvm.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.lex.*;
import org.clang.sema.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CastExpressionIdValidator">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExpr.cpp", line = 489,
 FQN="(anonymous namespace)::CastExpressionIdValidator", NM="_ZN12_GLOBAL__N_125CastExpressionIdValidatorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExpr.cpp -nm=_ZN12_GLOBAL__N_125CastExpressionIdValidatorE")
//</editor-fold>
public class CastExpressionIdValidator extends /*public*/ CorrectionCandidateCallback implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CastExpressionIdValidator::CastExpressionIdValidator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExpr.cpp", line = 491,
   FQN="(anonymous namespace)::CastExpressionIdValidator::CastExpressionIdValidator", NM="_ZN12_GLOBAL__N_125CastExpressionIdValidatorC1EN5clang5TokenEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExpr.cpp -nm=_ZN12_GLOBAL__N_125CastExpressionIdValidatorC1EN5clang5TokenEbb")
  //</editor-fold>
  public CastExpressionIdValidator(Token Next, boolean AllowTypes, boolean AllowNonTypes) {
    // : CorrectionCandidateCallback(), NextToken(Next), AllowNonTypes(AllowNonTypes) 
    //START JInit
    super();
    this.NextToken = new Token(Next);
    this.AllowNonTypes = AllowNonTypes;
    //END JInit
    WantTypeSpecifiers = WantFunctionLikeCasts = AllowTypes;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CastExpressionIdValidator::ValidateCandidate">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExpr.cpp", line = 496,
   FQN="(anonymous namespace)::CastExpressionIdValidator::ValidateCandidate", NM="_ZN12_GLOBAL__N_125CastExpressionIdValidator17ValidateCandidateERKN5clang14TypoCorrectionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExpr.cpp -nm=_ZN12_GLOBAL__N_125CastExpressionIdValidator17ValidateCandidateERKN5clang14TypoCorrectionE")
  //</editor-fold>
  @Override public boolean ValidateCandidate(/*const*/ TypoCorrection /*&*/ candidate)/* override*/ {
    NamedDecl /*P*/ ND = candidate.getCorrectionDecl();
    if (!(ND != null)) {
      return candidate.isKeyword();
    }
    if (isa(TypeDecl.class, ND)) {
      return WantTypeSpecifiers;
    }
    if (!AllowNonTypes || !super.ValidateCandidate(candidate)) {
      return false;
    }
    if (!NextToken.isOneOf$T(tok.TokenKind.equal, tok.TokenKind.arrow, tok.TokenKind.period)) {
      return true;
    }
    
    for (NamedDecl /*P*/ C : candidate) {
      NamedDecl /*P*/ _ND = C.getUnderlyingDecl();
      if (isa(ValueDecl.class, _ND) && !isa(FunctionDecl.class, _ND)) {
        return true;
      }
    }
    return false;
  }

/*private:*/
  private Token NextToken;
  private boolean AllowNonTypes;
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CastExpressionIdValidator::~CastExpressionIdValidator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExpr.cpp", line = 489,
   FQN="(anonymous namespace)::CastExpressionIdValidator::~CastExpressionIdValidator", NM="_ZN12_GLOBAL__N_125CastExpressionIdValidatorD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseExpr.cpp -nm=_ZN12_GLOBAL__N_125CastExpressionIdValidatorD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + "NextToken=" + NextToken // NOI18N
              + ", AllowNonTypes=" + AllowNonTypes // NOI18N
              + super.toString(); // NOI18N
  }
}
