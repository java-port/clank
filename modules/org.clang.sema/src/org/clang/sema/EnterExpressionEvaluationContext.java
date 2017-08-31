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

package org.clang.sema;

import org.clank.support.*;
import org.clang.ast.*;


/// \brief RAII object that enters a new expression evaluation context.
//<editor-fold defaultstate="collapsed" desc="clang::EnterExpressionEvaluationContext">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 9606,
 FQN="clang::EnterExpressionEvaluationContext", NM="_ZN5clang32EnterExpressionEvaluationContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang32EnterExpressionEvaluationContextE")
//</editor-fold>
public class EnterExpressionEvaluationContext implements Destructors.ClassWithDestructor {
  private final Sema /*&*/ Actions;
  private boolean Entered/* = true*/;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::EnterExpressionEvaluationContext::EnterExpressionEvaluationContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 9611,
   FQN="clang::EnterExpressionEvaluationContext::EnterExpressionEvaluationContext", NM="_ZN5clang32EnterExpressionEvaluationContextC1ERNS_4SemaENS1_27ExpressionEvaluationContextEPNS_4DeclEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang32EnterExpressionEvaluationContextC1ERNS_4SemaENS1_27ExpressionEvaluationContextEPNS_4DeclEbb")
  //</editor-fold>
  public EnterExpressionEvaluationContext(final Sema /*&*/ Actions, 
      Sema.ExpressionEvaluationContext NewContext) {
    this(Actions, 
      NewContext, 
      (Decl /*P*/ )null, 
      false, 
      true);
  }
  public EnterExpressionEvaluationContext(final Sema /*&*/ Actions, 
      Sema.ExpressionEvaluationContext NewContext, 
      Decl /*P*/ LambdaContextDecl/*= null*/) {
    this(Actions, 
      NewContext, 
      LambdaContextDecl, 
      false, 
      true);
  }
  public EnterExpressionEvaluationContext(final Sema /*&*/ Actions, 
      Sema.ExpressionEvaluationContext NewContext, 
      Decl /*P*/ LambdaContextDecl/*= null*/, 
      boolean IsDecltype/*= false*/) {
    this(Actions, 
      NewContext, 
      LambdaContextDecl, 
      IsDecltype, 
      true);
  }
  public EnterExpressionEvaluationContext(final Sema /*&*/ Actions, 
      Sema.ExpressionEvaluationContext NewContext, 
      Decl /*P*/ LambdaContextDecl/*= null*/, 
      boolean IsDecltype/*= false*/, 
      boolean ShouldEnter/*= true*/) {
    // : Actions(Actions), Entered(ShouldEnter) 
    //START JInit
    this./*&*/Actions=/*&*/Actions;
    this.Entered = ShouldEnter;
    //END JInit
    if (Entered) {
      Actions.PushExpressionEvaluationContext(NewContext, LambdaContextDecl, 
          IsDecltype);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::EnterExpressionEvaluationContext::EnterExpressionEvaluationContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 9621,
   FQN="clang::EnterExpressionEvaluationContext::EnterExpressionEvaluationContext", NM="_ZN5clang32EnterExpressionEvaluationContextC1ERNS_4SemaENS1_27ExpressionEvaluationContextENS1_24ReuseLambdaContextDecl_tEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang32EnterExpressionEvaluationContextC1ERNS_4SemaENS1_27ExpressionEvaluationContextENS1_24ReuseLambdaContextDecl_tEb")
  //</editor-fold>
  public EnterExpressionEvaluationContext(final Sema /*&*/ Actions, 
      Sema.ExpressionEvaluationContext NewContext, 
      Sema.ReuseLambdaContextDecl_t $Prm2) {
    this(Actions, 
      NewContext, 
      $Prm2, 
      false);
  }
  public EnterExpressionEvaluationContext(final Sema /*&*/ Actions, 
      Sema.ExpressionEvaluationContext NewContext, 
      Sema.ReuseLambdaContextDecl_t $Prm2, 
      boolean IsDecltype/*= false*/) {
    // : Actions(Actions), Entered(true) 
    //START JInit
    this./*&*/Actions=/*&*/Actions;
    /*InClass*/this.Entered = true;
    //END JInit
    Actions.PushExpressionEvaluationContext(NewContext, 
        Sema.ReuseLambdaContextDecl_t.ReuseLambdaContextDecl, 
        IsDecltype);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::EnterExpressionEvaluationContext::~EnterExpressionEvaluationContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/Sema.h", line = 9631,
   FQN="clang::EnterExpressionEvaluationContext::~EnterExpressionEvaluationContext", NM="_ZN5clang32EnterExpressionEvaluationContextD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN5clang32EnterExpressionEvaluationContextD0Ev")
  //</editor-fold>
  public void $destroy() {
    if (Entered) {
      Actions.PopExpressionEvaluationContext();
    }
  }

  
  @Override public String toString() {
    return "" + "Actions=" + "[Sema]" // NOI18N
              + ", Entered=" + Entered; // NOI18N
  }
}
