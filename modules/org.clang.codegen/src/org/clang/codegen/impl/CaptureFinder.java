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
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.codegen.CodeGen.impl.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;

/// Find all local variable captures in the statement.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CaptureFinder">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp", line = 1439,
 FQN="(anonymous namespace)::CaptureFinder", NM="_ZN12_GLOBAL__N_113CaptureFinderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp -nm=_ZN12_GLOBAL__N_113CaptureFinderE")
//</editor-fold>
public class/*struct*/ CaptureFinder implements ConstStmtVisitorVoid<CaptureFinder>, Destructors.ClassWithDestructor {
  public final CodeGenFunction /*&*/ ParentCGF;
  public /*const*/ VarDecl /*P*/ ParentThis;
  public SmallSetVector</*const*/ VarDecl /*P*/ > Captures;
  public Address SEHCodeSlot/* = Address::invalid()*/;
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CaptureFinder::CaptureFinder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp", line = 1444,
   FQN="(anonymous namespace)::CaptureFinder::CaptureFinder", NM="_ZN12_GLOBAL__N_113CaptureFinderC1ERN5clang7CodeGen15CodeGenFunctionEPKNS1_7VarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp -nm=_ZN12_GLOBAL__N_113CaptureFinderC1ERN5clang7CodeGen15CodeGenFunctionEPKNS1_7VarDeclE")
  //</editor-fold>
  public CaptureFinder(final CodeGenFunction /*&*/ ParentCGF, /*const*/ VarDecl /*P*/ ParentThis) {
    // : ConstStmtVisitor<CaptureFinder>(), ParentCGF(ParentCGF), ParentThis(ParentThis), Captures(), SEHCodeSlot(Address::invalid()) 
    //START JInit
    $ConstStmtVisitor();
    this./*&*/ParentCGF=/*&*/ParentCGF;
    this.ParentThis = ParentThis;
    this.Captures = new SmallSetVector</*const*/ VarDecl /*P*/ >(4, (/*const*/ VarDecl /*P*/ ) null);
    /*InClass*/this.SEHCodeSlot = Address.invalid();
    //END JInit
  }

  
  // Return true if we need to do any capturing work.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CaptureFinder::foundCaptures">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp", line = 1448,
   FQN="(anonymous namespace)::CaptureFinder::foundCaptures", NM="_ZN12_GLOBAL__N_113CaptureFinder13foundCapturesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp -nm=_ZN12_GLOBAL__N_113CaptureFinder13foundCapturesEv")
  //</editor-fold>
  public boolean foundCaptures() {
    return !Captures.empty() || SEHCodeSlot.isValid();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CaptureFinder::Visit">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp", line = 1452,
   FQN="(anonymous namespace)::CaptureFinder::Visit", NM="_ZN12_GLOBAL__N_113CaptureFinder5VisitEPKN5clang4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp -nm=_ZN12_GLOBAL__N_113CaptureFinder5VisitEPKN5clang4StmtE")
  //</editor-fold>
  public void Visit(/*const*/ Stmt /*P*/ S) {
    // See if this is a capture, then recurse.
    ConstStmtVisitorVoid.super.Visit(S);
    for (/*const*/ Stmt /*P*/ Child : S.children$Const())  {
      if ((Child != null)) {
        Visit(Child);
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CaptureFinder::VisitDeclRefExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp", line = 1460,
   FQN="(anonymous namespace)::CaptureFinder::VisitDeclRefExpr", NM="_ZN12_GLOBAL__N_113CaptureFinder16VisitDeclRefExprEPKN5clang11DeclRefExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp -nm=_ZN12_GLOBAL__N_113CaptureFinder16VisitDeclRefExprEPKN5clang11DeclRefExprE")
  //</editor-fold>
  public void VisitDeclRefExpr(/*const*/ DeclRefExpr /*P*/ E) {
    // If this is already a capture, just make sure we capture 'this'.
    if (E.refersToEnclosingVariableOrCapture()) {
      Captures.insert(ParentThis);
      return;
    }
    
    /*const*/ VarDecl /*P*/ D = dyn_cast_VarDecl(E.getDecl$Const());
    if ((D != null) && D.isLocalVarDeclOrParm() && D.hasLocalStorage()) {
      Captures.insert(D);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CaptureFinder::VisitCXXThisExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp", line = 1472,
   FQN="(anonymous namespace)::CaptureFinder::VisitCXXThisExpr", NM="_ZN12_GLOBAL__N_113CaptureFinder16VisitCXXThisExprEPKN5clang11CXXThisExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp -nm=_ZN12_GLOBAL__N_113CaptureFinder16VisitCXXThisExprEPKN5clang11CXXThisExprE")
  //</editor-fold>
  public void VisitCXXThisExpr(/*const*/ CXXThisExpr /*P*/ E) {
    Captures.insert(ParentThis);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CaptureFinder::VisitCallExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp", line = 1476,
   FQN="(anonymous namespace)::CaptureFinder::VisitCallExpr", NM="_ZN12_GLOBAL__N_113CaptureFinder13VisitCallExprEPKN5clang8CallExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp -nm=_ZN12_GLOBAL__N_113CaptureFinder13VisitCallExprEPKN5clang8CallExprE")
  //</editor-fold>
  public void VisitCallExpr(/*const*/ CallExpr /*P*/ E) {
    // We only need to add parent frame allocations for these builtins in x86.
    if (ParentCGF.getTarget().getTriple().getArch() != Triple.ArchType.x86) {
      return;
    }
    
    /*uint*/int ID = E.getBuiltinCallee();
    switch (Builtin.ID.valueOf(ID)) {
     case BI__exception_code:
     case BI_exception_code:
      // This is the simple case where we are the outermost finally. All we
      // have to do here is make sure we escape this and recover it in the
      // outlined handler.
      if (!SEHCodeSlot.isValid()) {
        SEHCodeSlot.$assign(ParentCGF.SEHCodeSlotStack.back());
      }
      break;
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CaptureFinder::~CaptureFinder">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp", line = 1439,
   FQN="(anonymous namespace)::CaptureFinder::~CaptureFinder", NM="_ZN12_GLOBAL__N_113CaptureFinderD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp -nm=_ZN12_GLOBAL__N_113CaptureFinderD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    Captures.$destroy();
    ConstStmtVisitorVoid.super.$destroy$ConstStmtVisitor();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "ParentCGF=" + ParentCGF // NOI18N
              + ", ParentThis=" + "[VarDecl]" // NOI18N
              + ", Captures=" + "[SmallSetVector$VarDecl]" // NOI18N
              + ", SEHCodeSlot=" + SEHCodeSlot // NOI18N
              + super.toString(); // NOI18N
  }
}
