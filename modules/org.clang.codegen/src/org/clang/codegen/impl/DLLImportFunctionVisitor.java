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

package org.clang.codegen.impl;

import org.clank.support.*;
import org.clang.ast.*;
import org.clang.codegen.impl.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DLLImportFunctionVisitor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 1680,
 FQN="(anonymous namespace)::DLLImportFunctionVisitor", NM="_ZN12_GLOBAL__N_124DLLImportFunctionVisitorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN12_GLOBAL__N_124DLLImportFunctionVisitorE")
//</editor-fold>
public class/*struct*/ DLLImportFunctionVisitor implements /*public*/ RecursiveASTVisitor<DLLImportFunctionVisitor> {
  public boolean SafeToInline/* = true*/;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DLLImportFunctionVisitor::VisitVarDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 1684,
   FQN="(anonymous namespace)::DLLImportFunctionVisitor::VisitVarDecl", NM="_ZN12_GLOBAL__N_124DLLImportFunctionVisitor12VisitVarDeclEPN5clang7VarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN12_GLOBAL__N_124DLLImportFunctionVisitor12VisitVarDeclEPN5clang7VarDeclE")
  //</editor-fold>
  public boolean VisitVarDecl(VarDecl /*P*/ VD) {
    // A thread-local variable cannot be imported.
    SafeToInline = !(VD.getTLSKind().getValue() != 0);
    return SafeToInline;
  }

  
  // Make sure we're not referencing non-imported vars or functions.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DLLImportFunctionVisitor::VisitDeclRefExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 1691,
   FQN="(anonymous namespace)::DLLImportFunctionVisitor::VisitDeclRefExpr", NM="_ZN12_GLOBAL__N_124DLLImportFunctionVisitor16VisitDeclRefExprEPN5clang11DeclRefExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN12_GLOBAL__N_124DLLImportFunctionVisitor16VisitDeclRefExprEPN5clang11DeclRefExprE")
  //</editor-fold>
  public boolean VisitDeclRefExpr(DeclRefExpr /*P*/ E) {
    ValueDecl /*P*/ VD = E.getDecl();
    if (isa_FunctionDecl(VD)) {
      SafeToInline = VD.hasAttr(DLLImportAttr.class);
    } else {
      VarDecl /*P*/ V = dyn_cast_VarDecl(VD);
      if ((V != null)) {
        SafeToInline = !V.hasGlobalStorage() || V.hasAttr(DLLImportAttr.class);
      }
    }
    return SafeToInline;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DLLImportFunctionVisitor::VisitCXXDeleteExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 1699,
   FQN="(anonymous namespace)::DLLImportFunctionVisitor::VisitCXXDeleteExpr", NM="_ZN12_GLOBAL__N_124DLLImportFunctionVisitor18VisitCXXDeleteExprEPN5clang13CXXDeleteExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN12_GLOBAL__N_124DLLImportFunctionVisitor18VisitCXXDeleteExprEPN5clang13CXXDeleteExprE")
  //</editor-fold>
  public boolean VisitCXXDeleteExpr(CXXDeleteExpr /*P*/ E) {
    SafeToInline = E.getOperatorDelete().hasAttr(DLLImportAttr.class);
    return SafeToInline;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DLLImportFunctionVisitor::VisitCXXNewExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 1703,
   FQN="(anonymous namespace)::DLLImportFunctionVisitor::VisitCXXNewExpr", NM="_ZN12_GLOBAL__N_124DLLImportFunctionVisitor15VisitCXXNewExprEPN5clang10CXXNewExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN12_GLOBAL__N_124DLLImportFunctionVisitor15VisitCXXNewExprEPN5clang10CXXNewExprE")
  //</editor-fold>
  public boolean VisitCXXNewExpr(CXXNewExpr /*P*/ E) {
    SafeToInline = E.getOperatorNew().hasAttr(DLLImportAttr.class);
    return SafeToInline;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DLLImportFunctionVisitor::DLLImportFunctionVisitor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp", line = 1680,
   FQN="(anonymous namespace)::DLLImportFunctionVisitor::DLLImportFunctionVisitor", NM="_ZN12_GLOBAL__N_124DLLImportFunctionVisitorC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenModule.cpp -nm=_ZN12_GLOBAL__N_124DLLImportFunctionVisitorC1Ev")
  //</editor-fold>
  public /*inline*/ DLLImportFunctionVisitor() {
    // : RecursiveASTVisitor<DLLImportFunctionVisitor>(), SafeToInline(true) 
    //START JInit
    $RecursiveASTVisitor();
    /*InClass*/this.SafeToInline = true;
    //END JInit
  }

  
  @Override public String toString() {
    return "" + "SafeToInline=" + SafeToInline // NOI18N
              + super.toString(); // NOI18N
  }
}
