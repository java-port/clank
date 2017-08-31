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
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.sema.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SubscriptBuilder">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 9780,
 FQN="(anonymous namespace)::SubscriptBuilder", NM="_ZN12_GLOBAL__N_116SubscriptBuilderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN12_GLOBAL__N_116SubscriptBuilderE")
//</editor-fold>
public class SubscriptBuilder extends /*public*/ ExprBuilder implements Destructors.ClassWithDestructor {
  private final /*const*/ ExprBuilder /*&*/ Base;
  private final /*const*/ ExprBuilder /*&*/ Index;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SubscriptBuilder::build">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 9785,
   FQN="(anonymous namespace)::SubscriptBuilder::build", NM="_ZNK12_GLOBAL__N_116SubscriptBuilder5buildERN5clang4SemaENS1_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZNK12_GLOBAL__N_116SubscriptBuilder5buildERN5clang4SemaENS1_14SourceLocationE")
  //</editor-fold>
  @Override public Expr /*P*/ build(final Sema /*&*/ S, SourceLocation Loc) /*const*//* override*/ {
    return assertNotNull(S.CreateBuiltinArraySubscriptExpr(Base.build(S, new SourceLocation(Loc)), new SourceLocation(Loc), Index.build(S, new SourceLocation(Loc)), new SourceLocation(Loc)).get());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SubscriptBuilder::SubscriptBuilder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 9790,
   FQN="(anonymous namespace)::SubscriptBuilder::SubscriptBuilder", NM="_ZN12_GLOBAL__N_116SubscriptBuilderC1ERKNS_11ExprBuilderES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN12_GLOBAL__N_116SubscriptBuilderC1ERKNS_11ExprBuilderES3_")
  //</editor-fold>
  public SubscriptBuilder(final /*const*/ ExprBuilder /*&*/ Base, final /*const*/ ExprBuilder /*&*/ Index) {
    // : ExprBuilder(), Base(Base), Index(Index) 
    //START JInit
    super();
    this./*&*/Base=/*&*/Base;
    this./*&*/Index=/*&*/Index;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SubscriptBuilder::~SubscriptBuilder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 9780,
   FQN="(anonymous namespace)::SubscriptBuilder::~SubscriptBuilder", NM="_ZN12_GLOBAL__N_116SubscriptBuilderD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN12_GLOBAL__N_116SubscriptBuilderD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + "Base=" + "[ExprBuilder]" // NOI18N
              + ", Index=" + "[ExprBuilder]" // NOI18N
              + super.toString(); // NOI18N
  }
}
