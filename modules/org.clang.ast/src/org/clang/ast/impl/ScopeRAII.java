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

package org.clang.ast.impl;

import org.clank.java.*;
import org.clank.support.*;


/// RAII object wrapping a full-expression or block scope, and handling
/// the ending of the lifetime of temporaries created within it.
/*template <bool IsFullExpression> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScopeRAII">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 901,
 FQN="(anonymous namespace)::ScopeRAII", NM="_ZN12_GLOBAL__N_19ScopeRAIIE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_19ScopeRAIIE")
//</editor-fold>
public class ScopeRAII/*<boolean IsFullExpression>*/  implements Destructors.ClassWithDestructor {
  private final EvalInfo /*&*/ Info;
  private /*uint*/int OldStackSize;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScopeRAII::ScopeRAII<IsFullExpression>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 906,
   FQN="(anonymous namespace)::ScopeRAII::ScopeRAII<IsFullExpression>", NM="_ZN12_GLOBAL__N_19ScopeRAIIC1ERNS_8EvalInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_19ScopeRAIIC1ERNS_8EvalInfoE")
  //</editor-fold>
  public ScopeRAII(final boolean IsFullExpression, final EvalInfo /*&*/ Info) {
    // : Info(Info), OldStackSize(Info.CleanupStack.size()) 
    //START JInit
    this.IsFullExpression = IsFullExpression;
    this./*&*/Info=/*&*/Info;
    this.OldStackSize = Info.CleanupStack.size();
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScopeRAII::~ScopeRAII<IsFullExpression>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 908,
   FQN="(anonymous namespace)::ScopeRAII::~ScopeRAII<IsFullExpression>", NM="_ZN12_GLOBAL__N_19ScopeRAIID0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_19ScopeRAIID0Ev")
  //</editor-fold>
  public void $destroy() {
    // Body moved to a static method to encourage the compiler to inline away
    // instances of this class.
    cleanup(IsFullExpression, Info, OldStackSize);
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ScopeRAII::cleanup">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 914,
   FQN="(anonymous namespace)::ScopeRAII::cleanup", NM="_ZN12_GLOBAL__N_19ScopeRAII7cleanupERNS_8EvalInfoEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_19ScopeRAII7cleanupERNS_8EvalInfoEj")
  //</editor-fold>
  private static void cleanup(boolean IsFullExpression, final EvalInfo /*&*/ Info, /*uint*/int OldStackSize) {
    /*uint*/int NewEnd = OldStackSize;
    for (/*uint*/int I = OldStackSize, N = Info.CleanupStack.size();
         I != N; ++I) {
      if (IsFullExpression && Info.CleanupStack.$at(I).isLifetimeExtended()) {
        // Full-expression cleanup of a lifetime-extended temporary: nothing
        // to do, just move this cleanup to the right place in the stack.
        std.swap(Info.CleanupStack.$at(I), Info.CleanupStack.$at(NewEnd));
        ++NewEnd;
      } else {
        // End the lifetime of the object.
        Info.CleanupStack.$at(I).endLifetime();
      }
    }
    Info.CleanupStack.erase(Info.CleanupStack.begin().$add(NewEnd), 
        Info.CleanupStack.end());
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN
  
  private final boolean IsFullExpression;

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Info=" + Info // NOI18N
              + ", OldStackSize=" + OldStackSize; // NOI18N
  }
}
