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
;
import org.clang.basic.*;
import org.clang.sema.*;


//<editor-fold defaultstate="collapsed" desc="static type SemaClangStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -body-delegate -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExceptionSpec.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=Tpl__ZN5clangL21TransformTypeSpecTypeERNS_14TypeLocBuilderET_;_ZN5clangL14canCalleeThrowERNS_4SemaEPKNS_4ExprEPKNS_4DeclE;_ZN5clangL14canTypeidThrowERNS_4SemaEPKNS_13CXXTypeidExprE;_ZN5clangL16canSubExprsThrowERNS_4SemaEPKNS_4ExprE;_ZN5clangL19canDynamicCastThrowEPKNS_18CXXDynamicCastExprE;_ZN5clangL21GetUnderlyingFunctionENS_8QualTypeE;_ZN5clangL24hasImplicitExceptionSpecEPNS_12FunctionDeclE;_ZN5clangL27CheckSpecForTypesEquivalentERNS_4SemaERKNS_17PartialDiagnosticES4_NS_8QualTypeENS_14SourceLocationES5_S6_; -static-type=SemaClangStatics -package=org.clang.sema.impl")
//</editor-fold>
public final class SemaClangStatics {

//<editor-fold defaultstate="collapsed" desc="clang::GetUnderlyingFunction">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExceptionSpec.cpp", line = 27,
 FQN="clang::GetUnderlyingFunction", NM="_ZN5clangL21GetUnderlyingFunctionENS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExceptionSpec.cpp -nm=_ZN5clangL21GetUnderlyingFunctionENS_8QualTypeE")
//</editor-fold>
public static /*const*/ FunctionProtoType /*P*/ GetUnderlyingFunction(QualType T) {
  return /*delegate*/org.clang.sema.impl.SemaExceptionSpecClangStatics.
    GetUnderlyingFunction(T);
}


/// Determine whether a function has an implicitly-generated exception
/// specification.
//<editor-fold defaultstate="collapsed" desc="clang::hasImplicitExceptionSpec">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExceptionSpec.cpp", line = 193,
 FQN="clang::hasImplicitExceptionSpec", NM="_ZN5clangL24hasImplicitExceptionSpecEPNS_12FunctionDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExceptionSpec.cpp -nm=_ZN5clangL24hasImplicitExceptionSpecEPNS_12FunctionDeclE")
//</editor-fold>
public static boolean hasImplicitExceptionSpec(FunctionDecl /*P*/ Decl) {
  return /*delegate*/org.clang.sema.impl.SemaExceptionSpecClangStatics.
    hasImplicitExceptionSpec(Decl);
}

//<editor-fold defaultstate="collapsed" desc="clang::CheckSpecForTypesEquivalent">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExceptionSpec.cpp", line = 757,
 FQN="clang::CheckSpecForTypesEquivalent", NM="_ZN5clangL27CheckSpecForTypesEquivalentERNS_4SemaERKNS_17PartialDiagnosticES4_NS_8QualTypeENS_14SourceLocationES5_S6_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExceptionSpec.cpp -nm=_ZN5clangL27CheckSpecForTypesEquivalentERNS_4SemaERKNS_17PartialDiagnosticES4_NS_8QualTypeENS_14SourceLocationES5_S6_")
//</editor-fold>
public static boolean CheckSpecForTypesEquivalent(final Sema /*&*/ S, 
                           final /*const*/ PartialDiagnostic /*&*/ DiagID, final /*const*/ PartialDiagnostic /*&*/ NoteID, 
                           QualType Target, SourceLocation TargetLoc, 
                           QualType Source, SourceLocation SourceLoc) {
  return /*delegate*/org.clang.sema.impl.SemaExceptionSpecClangStatics.
    CheckSpecForTypesEquivalent(S, 
                           DiagID, NoteID, 
                           Target, TargetLoc, 
                           Source, SourceLoc);
}

//<editor-fold defaultstate="collapsed" desc="clang::canSubExprsThrow">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExceptionSpec.cpp", line = 871,
 FQN="clang::canSubExprsThrow", NM="_ZN5clangL16canSubExprsThrowERNS_4SemaEPKNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExceptionSpec.cpp -nm=_ZN5clangL16canSubExprsThrowERNS_4SemaEPKNS_4ExprE")
//</editor-fold>
public static CanThrowResult canSubExprsThrow(final Sema /*&*/ S, /*const*/ Expr /*P*/ E) {
  return /*delegate*/org.clang.sema.impl.SemaExceptionSpecClangStatics.
    canSubExprsThrow(S, E);
}

//<editor-fold defaultstate="collapsed" desc="clang::canCalleeThrow">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExceptionSpec.cpp", line = 881,
 FQN="clang::canCalleeThrow", NM="_ZN5clangL14canCalleeThrowERNS_4SemaEPKNS_4ExprEPKNS_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExceptionSpec.cpp -nm=_ZN5clangL14canCalleeThrowERNS_4SemaEPKNS_4ExprEPKNS_4DeclE")
//</editor-fold>
public static CanThrowResult canCalleeThrow(final Sema /*&*/ S, /*const*/ Expr /*P*/ E, /*const*/ Decl /*P*/ D) {
  return /*delegate*/org.clang.sema.impl.SemaExceptionSpecClangStatics.
    canCalleeThrow(S, E, D);
}

//<editor-fold defaultstate="collapsed" desc="clang::canDynamicCastThrow">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExceptionSpec.cpp", line = 916,
 FQN="clang::canDynamicCastThrow", NM="_ZN5clangL19canDynamicCastThrowEPKNS_18CXXDynamicCastExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExceptionSpec.cpp -nm=_ZN5clangL19canDynamicCastThrowEPKNS_18CXXDynamicCastExprE")
//</editor-fold>
public static CanThrowResult canDynamicCastThrow(/*const*/ CXXDynamicCastExpr /*P*/ DC) {
  return /*delegate*/org.clang.sema.impl.SemaExceptionSpecClangStatics.
    canDynamicCastThrow(DC);
}

//<editor-fold defaultstate="collapsed" desc="clang::canTypeidThrow">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExceptionSpec.cpp", line = 929,
 FQN="clang::canTypeidThrow", NM="_ZN5clangL14canTypeidThrowERNS_4SemaEPKNS_13CXXTypeidExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExceptionSpec.cpp -nm=_ZN5clangL14canTypeidThrowERNS_4SemaEPKNS_13CXXTypeidExprE")
//</editor-fold>
public static CanThrowResult canTypeidThrow(final Sema /*&*/ S, /*const*/ CXXTypeidExpr /*P*/ DC) {
  return /*delegate*/org.clang.sema.impl.SemaExceptionSpecClangStatics.
    canTypeidThrow(S, DC);
}

/*template <class TyLoc> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="clang::TransformTypeSpecType">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/TreeTransform.h", line = 4182,
 FQN="clang::TransformTypeSpecType", NM="Tpl__ZN5clangL21TransformTypeSpecTypeERNS_14TypeLocBuilderET_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=Tpl__ZN5clangL21TransformTypeSpecTypeERNS_14TypeLocBuilderET_")
//</editor-fold>
public static /*inline*/ </*class*/ TyLoc extends TypeSpecTypeLoc> QualType TransformTypeSpecType(final TypeLocBuilder /*&*/ TLB, TyLoc T) {
  return /*delegate*/org.clang.sema.impl.TreeTransformClangStatics.
    TransformTypeSpecType(TLB, T);
}

} // END OF class SemaClangStatics
