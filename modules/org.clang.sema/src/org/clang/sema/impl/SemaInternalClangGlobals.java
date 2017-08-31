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
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.sema.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type SemaInternalClangGlobals">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAttr.cpp -nm=_ZN5clang10getDLLAttrEPNS_4DeclE;_ZN5clang18MarkVarDeclODRUsedEPNS_7VarDeclENS_14SourceLocationERNS_4SemaEPKj;_ZN5clang22DeclAttrsMatchCUDAModeERKNS_11LangOptionsEPNS_4DeclE;_ZN5clang23FTIHasNonVoidParametersERKNS_15DeclaratorChunk16FunctionTypeInfoE;_ZN5clang25FTIHasSingleVoidParameterERKNS_15DeclaratorChunk16FunctionTypeInfoE;_ZN5clang29IsVariableAConstantExpressionEPNS_7VarDeclERNS_10ASTContextE; -static-type=SemaInternalClangGlobals -package=org.clang.sema.impl")
//</editor-fold>
public final class SemaInternalClangGlobals {

//<editor-fold defaultstate="collapsed" desc="clang::FTIHasSingleVoidParameter">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/SemaInternal.h", line = 29,
 FQN="clang::FTIHasSingleVoidParameter", NM="_ZN5clang25FTIHasSingleVoidParameterERKNS_15DeclaratorChunk16FunctionTypeInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAttr.cpp -nm=_ZN5clang25FTIHasSingleVoidParameterERKNS_15DeclaratorChunk16FunctionTypeInfoE")
//</editor-fold>
public static /*inline*/ boolean FTIHasSingleVoidParameter(final /*const*/ DeclaratorChunk.FunctionTypeInfo /*&*/ FTI) {
  return FTI.NumParams == 1 && !FTI.isVariadic
     && FTI.Params.$star().Ident == null && (FTI.Params.$star().Param != null)
     && cast_ParmVarDecl(FTI.Params.$star().Param).getType().$arrow().isVoidType();
}

//<editor-fold defaultstate="collapsed" desc="clang::FTIHasNonVoidParameters">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/SemaInternal.h", line = 36,
 FQN="clang::FTIHasNonVoidParameters", NM="_ZN5clang23FTIHasNonVoidParametersERKNS_15DeclaratorChunk16FunctionTypeInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAttr.cpp -nm=_ZN5clang23FTIHasNonVoidParametersERKNS_15DeclaratorChunk16FunctionTypeInfoE")
//</editor-fold>
public static /*inline*/ boolean FTIHasNonVoidParameters(final /*const*/ DeclaratorChunk.FunctionTypeInfo /*&*/ FTI) {
  // Assume FTI is well-formed.
  return (FTI.NumParams != 0) && !FTIHasSingleVoidParameter(FTI);
}


// This requires the variable to be non-dependent and the initializer
// to not be value dependent.
//<editor-fold defaultstate="collapsed" desc="clang::IsVariableAConstantExpression">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/SemaInternal.h", line = 44,
 FQN="clang::IsVariableAConstantExpression", NM="_ZN5clang29IsVariableAConstantExpressionEPNS_7VarDeclERNS_10ASTContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAttr.cpp -nm=_ZN5clang29IsVariableAConstantExpressionEPNS_7VarDeclERNS_10ASTContextE")
//</editor-fold>
public static /*inline*/ boolean IsVariableAConstantExpression(VarDecl /*P*/ Var, final ASTContext /*&*/ Context) {
  type$ref</*const*/ VarDecl /*P*/ > DefVD = create_type$ref();
  return !isa_ParmVarDecl(Var)
     && Var.isUsableInConstantExpressions(Context)
     && (Var.getAnyInitializer(DefVD) != null) && DefVD.$deref().checkInitIsICE();
}


// Helper function to check whether D's attributes match current CUDA mode.
// Decls with mismatched attributes and related diagnostics may have to be
// ignored during this CUDA compilation pass.
//<editor-fold defaultstate="collapsed" desc="clang::DeclAttrsMatchCUDAMode">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/SemaInternal.h", line = 54,
 FQN="clang::DeclAttrsMatchCUDAMode", NM="_ZN5clang22DeclAttrsMatchCUDAModeERKNS_11LangOptionsEPNS_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAttr.cpp -nm=_ZN5clang22DeclAttrsMatchCUDAModeERKNS_11LangOptionsEPNS_4DeclE")
//</editor-fold>
public static /*inline*/ boolean DeclAttrsMatchCUDAMode(final /*const*/ LangOptions /*&*/ LangOpts, Decl /*P*/ D) {
  if (!LangOpts.CUDA || !(D != null)) {
    return true;
  }
  boolean isDeviceSideDecl = D.hasAttr(CUDADeviceAttr.class)
     || D.hasAttr(CUDASharedAttr.class)
     || D.hasAttr(CUDAGlobalAttr.class);
  return isDeviceSideDecl == LangOpts.CUDAIsDevice;
}


// Directly mark a variable odr-used. Given a choice, prefer to use 
// MarkVariableReferenced since it does additional checks and then 
// calls MarkVarDeclODRUsed.
// If the variable must be captured:
//  - if FunctionScopeIndexToStopAt is null, capture it in the CurContext
//  - else capture it in the DeclContext that maps to the 
//    *FunctionScopeIndexToStopAt on the FunctionScopeInfo stack.  
//<editor-fold defaultstate="collapsed" desc="clang::MarkVarDeclODRUsed">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/SemaInternal.h", line = 70,
 FQN="clang::MarkVarDeclODRUsed", NM="_ZN5clang18MarkVarDeclODRUsedEPNS_7VarDeclENS_14SourceLocationERNS_4SemaEPKj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAttr.cpp -nm=_ZN5clang18MarkVarDeclODRUsedEPNS_7VarDeclENS_14SourceLocationERNS_4SemaEPKj")
//</editor-fold>
public static /*inline*/ void MarkVarDeclODRUsed(VarDecl /*P*/ Var, 
                  SourceLocation Loc, final Sema /*&*/ SemaRef, 
                  /*const*/uint$ptr/*uint P*//*const*/ FunctionScopeIndexToStopAt) {
  // Keep track of used but undefined variables.
  // FIXME: We shouldn't suppress this warning for static data members.
  if (Var.hasDefinition(SemaRef.Context) == VarDecl.DefinitionKind.DeclarationOnly
     && (!Var.isExternallyVisible() || Var.isInline())
     && !(Var.isStaticDataMember() && Var.hasInit())) {
    final SourceLocation /*&*/ old = SemaRef.UndefinedButUsed.$at(Var.getCanonicalDecl());
    if (old.isInvalid()) {
      old.$assign(Loc);
    }
  }
  QualType CaptureType/*J*/= new QualType();
  QualType DeclRefType/*J*/= new QualType();
  SemaRef.tryCaptureVariable(Var, new SourceLocation(Loc), Sema.TryCaptureKind.TryCapture_Implicit, 
      /*EllipsisLoc*/ new SourceLocation(), 
      /*BuildAndDiagnose*/ true, 
      CaptureType, DeclRefType, 
      FunctionScopeIndexToStopAt);
  
  Var.markUsed(SemaRef.Context);
}


/// Return a DLL attribute from the declaration.
//<editor-fold defaultstate="collapsed" desc="clang::getDLLAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Sema/SemaInternal.h", line = 93,
 FQN="clang::getDLLAttr", NM="_ZN5clang10getDLLAttrEPNS_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaAttr.cpp -nm=_ZN5clang10getDLLAttrEPNS_4DeclE")
//</editor-fold>
public static /*inline*/ InheritableAttr /*P*/ getDLLAttr(Decl /*P*/ D) {
  assert (!(D.hasAttr(DLLImportAttr.class) && D.hasAttr(DLLExportAttr.class))) : "A declaration cannot be both dllimport and dllexport.";
  {
    DLLImportAttr /*P*/ Import = D.getAttr(DLLImportAttr.class);
    if ((Import != null)) {
      return Import;
    }
  }
  {
    DLLExportAttr /*P*/ Export = D.getAttr(DLLExportAttr.class);
    if ((Export != null)) {
      return Export;
    }
  }
  return null;
}

} // END OF class SemaInternalClangGlobals
