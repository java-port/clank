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
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.sema.*;
import org.clang.parse.*;
import org.clang.sema.java.SemaFunctionPointers.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ThreadprivateListParserHelper">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseOpenMP.cpp", line = 46,
 FQN="(anonymous namespace)::ThreadprivateListParserHelper", NM="_ZN12_GLOBAL__N_129ThreadprivateListParserHelperE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseOpenMP.cpp -nm=_ZN12_GLOBAL__N_129ThreadprivateListParserHelperE")
//</editor-fold>
public final class ThreadprivateListParserHelper implements Destructors.ClassWithDestructor, CXXScopeSpec$RefDeclarationNameInfo2Void {
  private SmallVector<Expr /*P*/ > Identifiers;
  private Parser /*P*/ P;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ThreadprivateListParserHelper::ThreadprivateListParserHelper">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseOpenMP.cpp", line = 51,
   FQN="(anonymous namespace)::ThreadprivateListParserHelper::ThreadprivateListParserHelper", NM="_ZN12_GLOBAL__N_129ThreadprivateListParserHelperC1EPN5clang6ParserE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseOpenMP.cpp -nm=_ZN12_GLOBAL__N_129ThreadprivateListParserHelperC1EPN5clang6ParserE")
  //</editor-fold>
  public ThreadprivateListParserHelper(Parser /*P*/ P) {
    // : Identifiers(), P(P) 
    //START JInit
    this.Identifiers = new SmallVector<Expr /*P*/ >(4, (Expr /*P*/ )null);
    this.P = P;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ThreadprivateListParserHelper::operator()">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseOpenMP.cpp", line = 52,
   FQN="(anonymous namespace)::ThreadprivateListParserHelper::operator()", NM="_ZN12_GLOBAL__N_129ThreadprivateListParserHelperclERN5clang12CXXScopeSpecENS1_19DeclarationNameInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseOpenMP.cpp -nm=_ZN12_GLOBAL__N_129ThreadprivateListParserHelperclERN5clang12CXXScopeSpecENS1_19DeclarationNameInfoE")
  //</editor-fold>
  public void $call(CXXScopeSpec /*&*/ SS, DeclarationNameInfo NameInfo) {
    ActionResultTTrue<Expr /*P*/ > Res = P.getActions().ActOnOpenMPIdExpression(P.getCurScope(), SS, NameInfo);
    if (Res.isUsable()) {
      Identifiers.push_back(Res.get());
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ThreadprivateListParserHelper::getIdentifiers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseOpenMP.cpp", line = 58,
   FQN="(anonymous namespace)::ThreadprivateListParserHelper::getIdentifiers", NM="_ZNK12_GLOBAL__N_129ThreadprivateListParserHelper14getIdentifiersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseOpenMP.cpp -nm=_ZNK12_GLOBAL__N_129ThreadprivateListParserHelper14getIdentifiersEv")
  //</editor-fold>
  public ArrayRef<Expr /*P*/ > getIdentifiers() /*const*/ {
    return new ArrayRef<Expr /*P*/ >(Identifiers);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ThreadprivateListParserHelper::~ThreadprivateListParserHelper">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseOpenMP.cpp", line = 46,
   FQN="(anonymous namespace)::ThreadprivateListParserHelper::~ThreadprivateListParserHelper", NM="_ZN12_GLOBAL__N_129ThreadprivateListParserHelperD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.parse/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Parse/ParseOpenMP.cpp -nm=_ZN12_GLOBAL__N_129ThreadprivateListParserHelperD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    Identifiers.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "Identifiers=" + Identifiers // NOI18N
              + ", P=" + P; // NOI18N
  }
}
