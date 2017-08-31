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
import org.clang.sema.*;

/// Used by Sema::DiagnoseUnusedBackingIvarInAccessor to check if a property
/// accessor references the backing ivar.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnusedBackingIvarChecker">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp", line = 4722,
 FQN="(anonymous namespace)::UnusedBackingIvarChecker", NM="_ZN12_GLOBAL__N_124UnusedBackingIvarCheckerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp -nm=_ZN12_GLOBAL__N_124UnusedBackingIvarCheckerE")
//</editor-fold>
public class UnusedBackingIvarChecker implements /*public*/ RecursiveASTVisitor<UnusedBackingIvarChecker> {
/*public:*/
  public final Sema /*&*/ S;
  public /*const*/ ObjCMethodDecl /*P*/ Method;
  public /*const*/ ObjCIvarDecl /*P*/ IvarD;
  public boolean AccessedIvar;
  public boolean InvokedSelfMethod;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnusedBackingIvarChecker::UnusedBackingIvarChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp", line = 4731,
   FQN="(anonymous namespace)::UnusedBackingIvarChecker::UnusedBackingIvarChecker", NM="_ZN12_GLOBAL__N_124UnusedBackingIvarCheckerC1ERN5clang4SemaEPKNS1_14ObjCMethodDeclEPKNS1_12ObjCIvarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp -nm=_ZN12_GLOBAL__N_124UnusedBackingIvarCheckerC1ERN5clang4SemaEPKNS1_14ObjCMethodDeclEPKNS1_12ObjCIvarDeclE")
  //</editor-fold>
  public UnusedBackingIvarChecker(final Sema /*&*/ S, /*const*/ ObjCMethodDecl /*P*/ Method, 
      /*const*/ ObjCIvarDecl /*P*/ IvarD) {
    // : RecursiveASTVisitor<UnusedBackingIvarChecker>(), S(S), Method(Method), IvarD(IvarD), AccessedIvar(false), InvokedSelfMethod(false) 
    //START JInit
    $RecursiveASTVisitor();
    this./*&*/S=/*&*/S;
    this.Method = Method;
    this.IvarD = IvarD;
    this.AccessedIvar = false;
    this.InvokedSelfMethod = false;
    //END JInit
    assert Native.$bool(IvarD);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnusedBackingIvarChecker::VisitObjCIvarRefExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp", line = 4738,
   FQN="(anonymous namespace)::UnusedBackingIvarChecker::VisitObjCIvarRefExpr", NM="_ZN12_GLOBAL__N_124UnusedBackingIvarChecker20VisitObjCIvarRefExprEPN5clang15ObjCIvarRefExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp -nm=_ZN12_GLOBAL__N_124UnusedBackingIvarChecker20VisitObjCIvarRefExprEPN5clang15ObjCIvarRefExprE")
  //</editor-fold>
  public boolean VisitObjCIvarRefExpr(ObjCIvarRefExpr /*P*/ E) {
    if (E.getDecl() == IvarD) {
      AccessedIvar = true;
      return false;
    }
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnusedBackingIvarChecker::VisitObjCMessageExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp", line = 4746,
   FQN="(anonymous namespace)::UnusedBackingIvarChecker::VisitObjCMessageExpr", NM="_ZN12_GLOBAL__N_124UnusedBackingIvarChecker20VisitObjCMessageExprEPN5clang15ObjCMessageExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclObjC.cpp -nm=_ZN12_GLOBAL__N_124UnusedBackingIvarChecker20VisitObjCMessageExprEPN5clang15ObjCMessageExprE")
  //</editor-fold>
  public boolean VisitObjCMessageExpr(ObjCMessageExpr /*P*/ E) {
    if (E.getReceiverKind() == ObjCMessageExpr.ReceiverKind.Instance
       && S.isSelfExpr(E.getInstanceReceiver(), Method)) {
      InvokedSelfMethod = true;
    }
    return true;
  }

  @Override
  public boolean has_overridden_traverse_with_queue_method(String TraverseMethodName) {
    // no any overridden traverse with queue methods
    return false;
  }
  
  @Override public String toString() {
    return "" + "S=" + "[Sema]" // NOI18N
              + ", Method=" + Method // NOI18N
              + ", IvarD=" + IvarD // NOI18N
              + ", AccessedIvar=" + AccessedIvar // NOI18N
              + ", InvokedSelfMethod=" + InvokedSelfMethod // NOI18N
              + super.toString(); // NOI18N
  }
}
