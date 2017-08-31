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
package org.clang.analysis.impl;

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.Native.*;
import org.clang.ast.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.analysis.java.AnalysisRTTI.*;
import org.clang.analysis.analyses.threadSafety.til.*;


//<editor-fold defaultstate="collapsed" desc="static type ThreadSafetyCommonStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyCommon.cpp -nm=_ZL13isCalleeArrowPKN5clang4ExprE;_ZL13maybeUpdateVDPN5clang12threadSafety3til5SExprEPKNS_9ValueDeclE;_ZL15isIncompletePhiPKN5clang12threadSafety3til5SExprE;_ZL17hasCppPointerTypePKN5clang12threadSafety3til5SExprE;_ZL19getFirstVirtualDeclPKN5clang13CXXMethodDeclE;_ZL21getValueDeclFromSExprPKN5clang12threadSafety3til5SExprE; -static-type=ThreadSafetyCommonStatics -package=org.clang.analysis.impl")
//</editor-fold>
public final class ThreadSafetyCommonStatics {


// Return true if E is a variable that points to an incomplete Phi node.
//<editor-fold defaultstate="collapsed" desc="isIncompletePhi">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyCommon.cpp", line = 62,
 FQN="isIncompletePhi", NM="_ZL15isIncompletePhiPKN5clang12threadSafety3til5SExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyCommon.cpp -nm=_ZL15isIncompletePhiPKN5clang12threadSafety3til5SExprE")
//</editor-fold>
public static boolean isIncompletePhi(/*const*/ SExpr /*P*/ E) {
  {
    /*const*/ Phi /*P*/ Ph = dyn_cast_Phi(E);
    if ((Ph != null)) {
      return Ph.status() == Phi.Status.PH_Incomplete;
    }
  }
  return false;
}

//<editor-fold defaultstate="collapsed" desc="isCalleeArrow">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyCommon.cpp", line = 82,
 FQN="isCalleeArrow", NM="_ZL13isCalleeArrowPKN5clang4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyCommon.cpp -nm=_ZL13isCalleeArrowPKN5clang4ExprE")
//</editor-fold>
public static boolean isCalleeArrow(/*const*/ Expr /*P*/ E) {
  /*const*/ MemberExpr /*P*/ ME = dyn_cast_MemberExpr(E.IgnoreParenCasts$Const());
  return (ME != null) ? ME.isArrow() : false;
}

//<editor-fold defaultstate="collapsed" desc="getValueDeclFromSExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyCommon.cpp", line = 299,
 FQN="getValueDeclFromSExpr", NM="_ZL21getValueDeclFromSExprPKN5clang12threadSafety3til5SExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyCommon.cpp -nm=_ZL21getValueDeclFromSExprPKN5clang12threadSafety3til5SExprE")
//</editor-fold>
public static /*const*/ ValueDecl /*P*/ getValueDeclFromSExpr(/*const*/ SExpr /*P*/ E) {
  {
    /*const*/ Variable /*P*/ V = dyn_cast_Variable(E);
    if ((V != null)) {
      return V.clangDecl();
    }
  }
  {
    /*const*/ Phi /*P*/ Ph = dyn_cast_Phi(E);
    if ((Ph != null)) {
      return Ph.clangDecl();
    }
  }
  {
    /*const*/ Project /*P*/ P = dyn_cast_Project(E);
    if ((P != null)) {
      return P.clangDecl();
    }
  }
  {
    /*const*/ LiteralPtr /*P*/ L = dyn_cast_LiteralPtr(E);
    if ((L != null)) {
      return L.clangDecl();
    }
  }
  return null;
}

//<editor-fold defaultstate="collapsed" desc="hasCppPointerType">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyCommon.cpp", line = 311,
 FQN="hasCppPointerType", NM="_ZL17hasCppPointerTypePKN5clang12threadSafety3til5SExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyCommon.cpp -nm=_ZL17hasCppPointerTypePKN5clang12threadSafety3til5SExprE")
//</editor-fold>
public static boolean hasCppPointerType(/*const*/ SExpr /*P*/ E) {
  /*const*/ ValueDecl /*P*/ VD = getValueDeclFromSExpr(E);
  if ((VD != null) && VD.getType().$arrow().isPointerType()) {
    return true;
  }
  {
    /*const*/ Cast /*P*/ C = dyn_cast_Cast(E);
    if ((C != null)) {
      return C.castOpcode() == TIL_CastOpcode.CAST_objToPtr;
    }
  }
  
  return false;
}


// Grab the very first declaration of virtual method D
//<editor-fold defaultstate="collapsed" desc="getFirstVirtualDecl">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyCommon.cpp", line = 322,
 FQN="getFirstVirtualDecl", NM="_ZL19getFirstVirtualDeclPKN5clang13CXXMethodDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyCommon.cpp -nm=_ZL19getFirstVirtualDeclPKN5clang13CXXMethodDeclE")
//</editor-fold>
public static /*const*/ CXXMethodDecl /*P*/ getFirstVirtualDecl(/*const*/ CXXMethodDecl /*P*/ D) {
  while (true) {
    D = D.getCanonicalDecl$Const();
    type$ptr<CXXMethodDecl>/*method_iterator*/ I = $tryClone(D.begin_overridden_methods());
    type$ptr<CXXMethodDecl>/*method_iterator*/ E = $tryClone(D.end_overridden_methods());
    if ($eq_ptr(I, E)) {
      return D; // Method does not override anything
    }
    D = I.$star(); // FIXME: this does not work with multiple inheritance.
  }
  //return null;
}


// if E is a til::Variable, update its clangDecl.
//<editor-fold defaultstate="collapsed" desc="maybeUpdateVD">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyCommon.cpp", line = 634,
 FQN="maybeUpdateVD", NM="_ZL13maybeUpdateVDPN5clang12threadSafety3til5SExprEPKNS_9ValueDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafetyCommon.cpp -nm=_ZL13maybeUpdateVDPN5clang12threadSafety3til5SExprEPKNS_9ValueDeclE")
//</editor-fold>
public static void maybeUpdateVD(SExpr /*P*/ E, /*const*/ ValueDecl /*P*/ VD) {
  if (!(E != null)) {
    return;
  }
  {
    Variable /*P*/ V = dyn_cast_Variable(E);
    if ((V != null)) {
      if (!(V.clangDecl() != null)) {
        V.setClangDecl(VD);
      }
    }
  }
}

} // END OF class ThreadSafetyCommonStatics
