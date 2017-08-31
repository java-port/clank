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

import static org.clank.support.Native.$AddrOf;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.llvm.adt.ADTAliases.*;
import static org.clank.support.NativePointer.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.sema.*;
import static org.clang.sema.java.SemaRTTI.*;
import static org.clang.sema.impl.SemaLambdaStatics.*;


//<editor-fold defaultstate="collapsed" desc="static type SemaLambdaClangGlobals">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLambda.cpp -nm=_ZN5clang51getStackIndexOfNearestEnclosingCaptureCapableLambdaEN4llvm8ArrayRefIPKNS_4sema17FunctionScopeInfoEEEPNS_7VarDeclERNS_4SemaE; -static-type=SemaLambdaClangGlobals -package=org.clang.sema.impl")
//</editor-fold>
public final class SemaLambdaClangGlobals {


/// \brief Examines the FunctionScopeInfo stack to determine the nearest
/// enclosing lambda (to the current lambda) that is 'capture-capable' for 
/// the variable referenced in the current lambda (i.e. \p VarToCapture).
/// If successful, returns the index into Sema's FunctionScopeInfo stack
/// of the capture-capable lambda's LambdaScopeInfo. 
/// See Implementation for more detailed comments. 

/// \brief Examines the FunctionScopeInfo stack to determine the nearest
/// enclosing lambda (to the current lambda) that is 'capture-capable' for 
/// the variable referenced in the current lambda (i.e. \p VarToCapture).
/// If successful, returns the index into Sema's FunctionScopeInfo stack
/// of the capture-capable lambda's LambdaScopeInfo.
///
/// Given the current stack of lambdas being processed by Sema and
/// the variable of interest, to identify the nearest enclosing lambda (to the 
/// current lambda at the top of the stack) that can truly capture
/// a variable, it has to have the following two properties:
///  a) 'capture-ready' - be the innermost lambda that is 'capture-ready':
///     - climb down the stack (i.e. starting from the innermost and examining
///       each outer lambda step by step) checking if each enclosing
///       lambda can either implicitly or explicitly capture the variable.
///       Record the first such lambda that is enclosed in a non-dependent
///       context. If no such lambda currently exists return failure.
///  b) 'capture-capable' - make sure the 'capture-ready' lambda can truly
///  capture the variable by checking all its enclosing lambdas:
///     - check if all outer lambdas enclosing the 'capture-ready' lambda
///       identified above in 'a' can also capture the variable (this is done
///       via tryCaptureVariable for variables and CheckCXXThisCapture for
///       'this' by passing in the index of the Lambda identified in step 'a')
///
/// \param FunctionScopes - Sema's stack of nested FunctionScopeInfo's (which a
/// LambdaScopeInfo inherits from).  The current/deepest/innermost lambda
/// is at the top of the stack.
///
/// \param VarToCapture - the variable to capture.  If NULL, capture 'this'.
///
///
/// \returns An Optional<unsigned> Index that if evaluates to 'true' contains
/// the index (into Sema's FunctionScopeInfo stack) of the innermost lambda
/// which is capture-capable.  If the return value evaluates to 'false' then
/// no lambda is capture-capable for \p VarToCapture.
//<editor-fold defaultstate="collapsed" desc="clang::getStackIndexOfNearestEnclosingCaptureCapableLambda">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLambda.cpp", line = 170,
 FQN="clang::getStackIndexOfNearestEnclosingCaptureCapableLambda", NM="_ZN5clang51getStackIndexOfNearestEnclosingCaptureCapableLambdaEN4llvm8ArrayRefIPKNS_4sema17FunctionScopeInfoEEEPNS_7VarDeclERNS_4SemaE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLambda.cpp -nm=_ZN5clang51getStackIndexOfNearestEnclosingCaptureCapableLambdaEN4llvm8ArrayRefIPKNS_4sema17FunctionScopeInfoEEEPNS_7VarDeclERNS_4SemaE")
//</editor-fold>
public static OptionalUInt getStackIndexOfNearestEnclosingCaptureCapableLambda(ArrayRef</*const*/ FunctionScopeInfo /*P*/ > FunctionScopes, 
                                                   VarDecl /*P*/ VarToCapture, final Sema /*&*/ S) {
  
  /*const*/OptionalUInt NoLambdaIsCaptureCapable/*J*/= new OptionalUInt();
  
  /*const*/OptionalUInt OptionalStackIndex = getStackIndexOfNearestEnclosingCaptureReadyLambda(new ArrayRef</*const*/ FunctionScopeInfo /*P*/ >(FunctionScopes), 
      VarToCapture);
  if (!OptionalStackIndex.$bool()) {
    return NoLambdaIsCaptureCapable;
  }
  
  uint$ptr IndexOfCaptureReadyLambda = create_uint$ptr(OptionalStackIndex.getValue$Const());
  assert (((IndexOfCaptureReadyLambda.$star() != (FunctionScopes.size() - 1)) || (S.getCurGenericLambda() != null))) : "The capture ready lambda for a potential capture can only be the current lambda if it is a generic lambda";
  
  /*const*/ LambdaScopeInfo /*P*/ /*const*/ CaptureReadyLambdaLSI = cast_LambdaScopeInfo(FunctionScopes.$at(IndexOfCaptureReadyLambda.$star()));
  
  // If VarToCapture is null, we are attempting to capture 'this'
  /*const*/boolean IsCapturingThis = !(VarToCapture != null);
  /*const*/boolean IsCapturingVariable = !IsCapturingThis;
  if (IsCapturingVariable) {
    // Check if the capture-ready lambda can truly capture the variable, by
    // checking whether all enclosing lambdas of the capture-ready lambda allow
    // the capture - i.e. make sure it is capture-capable.
    QualType CaptureType/*J*/= new QualType();
    QualType DeclRefType/*J*/= new QualType();
    /*const*/boolean CanCaptureVariable = !S.tryCaptureVariable(VarToCapture, 
        /*ExprVarIsUsedInLoc*/ new SourceLocation(), 
        Sema.TryCaptureKind.TryCapture_Implicit, 
        /*EllipsisLoc*/ new SourceLocation(), 
        /*BuildAndDiagnose*/ false, CaptureType, 
        DeclRefType, $AddrOf(IndexOfCaptureReadyLambda));
    if (!CanCaptureVariable) {
      return NoLambdaIsCaptureCapable;
    }
  } else {
    // Check if the capture-ready lambda can truly capture 'this' by checking
    // whether all enclosing lambdas of the capture-ready lambda can capture
    // 'this'.
    /*const*/boolean CanCaptureThis = !S.CheckCXXThisCapture(new SourceLocation(CaptureReadyLambdaLSI.PotentialThisCaptureLocation), 
        /*Explicit*/ false, /*BuildAndDiagnose*/ false, 
        $AddrOf(IndexOfCaptureReadyLambda));
    if (!CanCaptureThis) {
      return NoLambdaIsCaptureCapable;
    }
  }
  return new OptionalUInt(JD$T$C$R.INSTANCE, IndexOfCaptureReadyLambda);
}

} // END OF class SemaLambdaClangGlobals
