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
import org.clank.support.JavaDifferentiators.*;
import org.clang.ast.*;
import org.clang.sema.*;
import static org.clang.sema.impl.SemaOpenMPStatics.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;


// Transform MemberExpression for specified FieldDecl of current class to
// DeclRefExpr to specified OMPCapturedExprDecl.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TransformExprToCaptures">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 8828,
 FQN="(anonymous namespace)::TransformExprToCaptures", NM="_ZN12_GLOBAL__N_123TransformExprToCapturesE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN12_GLOBAL__N_123TransformExprToCapturesE")
//</editor-fold>
public class TransformExprToCaptures extends /*public*/ TreeTransform<TransformExprToCaptures> implements Destructors.ClassWithDestructor {
  /*typedef TreeTransform<TransformExprToCaptures> BaseTransform*/
//  public final class BaseTransform extends TreeTransform<TransformExprToCaptures>{ };
  private ValueDecl /*P*/ Field;
  private DeclRefExpr /*P*/ CapturedExpr;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TransformExprToCaptures::TransformExprToCaptures">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 8834,
   FQN="(anonymous namespace)::TransformExprToCaptures::TransformExprToCaptures", NM="_ZN12_GLOBAL__N_123TransformExprToCapturesC1ERN5clang4SemaEPNS1_9ValueDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN12_GLOBAL__N_123TransformExprToCapturesC1ERN5clang4SemaEPNS1_9ValueDeclE")
  //</editor-fold>
  public TransformExprToCaptures(final Sema /*&*/ SemaRef, ValueDecl /*P*/ FieldDecl) {
    // : BaseTransform(SemaRef), Field(FieldDecl), CapturedExpr(null) 
    //START JInit
    super(SemaRef);
    this.Field = FieldDecl;
    this.CapturedExpr = null;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TransformExprToCaptures::TransformMemberExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 8837,
   FQN="(anonymous namespace)::TransformExprToCaptures::TransformMemberExpr", NM="_ZN12_GLOBAL__N_123TransformExprToCaptures19TransformMemberExprEPN5clang10MemberExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN12_GLOBAL__N_123TransformExprToCaptures19TransformMemberExprEPN5clang10MemberExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > TransformMemberExpr(MemberExpr /*P*/ E) {
    if (isa_CXXThisExpr(E.getBase().IgnoreParenImpCasts())
       && E.getMemberDecl() == Field) {
      CapturedExpr = buildCapture(SemaRef, Field, E, /*WithInit=*/ false);
      return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, CapturedExpr);
    }
    return super.TransformMemberExpr(E);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TransformExprToCaptures::getCapturedExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 8845,
   FQN="(anonymous namespace)::TransformExprToCaptures::getCapturedExpr", NM="_ZN12_GLOBAL__N_123TransformExprToCaptures15getCapturedExprEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN12_GLOBAL__N_123TransformExprToCaptures15getCapturedExprEv")
  //</editor-fold>
  public DeclRefExpr /*P*/ getCapturedExpr() {
    return CapturedExpr;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TransformExprToCaptures::~TransformExprToCaptures">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 8828,
   FQN="(anonymous namespace)::TransformExprToCaptures::~TransformExprToCaptures", NM="_ZN12_GLOBAL__N_123TransformExprToCapturesD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN12_GLOBAL__N_123TransformExprToCapturesD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + "Field=" + Field // NOI18N
              + ", CapturedExpr=" + CapturedExpr // NOI18N
              + super.toString(); // NOI18N
  }
}
