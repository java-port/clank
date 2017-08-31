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

import static org.clank.support.Native.$Deref;
import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import static org.clang.ast.ASTContextGlobals.$new_uint_ASTContext$C_uint;
import org.clang.ast.aliases.*;
import org.clang.ast.llvm.*;
import org.clang.basic.*;
import org.clang.sema.*;
import static org.clang.basic.PartialDiagnostic.*;
import static org.clang.sema.Sema_NestedClasses.SemaDiagnosticBuilder.*;
import static org.clang.sema.SemaClangGlobals.*;
import static org.clang.ast.DeclContext.specific_decl_iterator.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.AstClangGlobals.*;
import static org.clang.sema.impl.SemaDeclCXXStatics.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstStatementsRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type SemaDeclCXXStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZL10extendLeftRN5clang11SourceRangeES0_;_ZL11extendRightRN5clang11SourceRangeES0_;_ZL13CastForMovingRN5clang4SemaEPNS_4ExprENS_8QualTypeE;_ZL13GetKeyForBaseRN5clang10ASTContextENS_8QualTypeE;_ZL15GetKeyForMemberRN5clang10ASTContextEPNS_18CXXCtorInitializerE;_ZL16getNamespaceDeclPN5clang9NamedDeclE;_ZL17NoteIndirectBasesRN5clang10ASTContextERN4llvm11SmallPtrSetINS_8QualTypeELj4EEERKS4_;_ZL17RefersToRValueRefPN5clang4ExprE;_ZL17getMSPropertyAttrPN5clang13AttributeListE;_ZL18hasOneRealArgumentN4llvm15MutableArrayRefIPN5clang4ExprEEE;_ZL18isStaticDataMemberPKN5clang4DeclE;_ZL19FindBaseInitializerRN5clang4SemaEPNS_13CXXRecordDeclENS_8QualTypeERPKNS_16CXXBaseSpecifierES8_;_ZL19isVirtualDirectBasePN5clang13CXXRecordDeclES1_;_ZL20findUserDeclaredCtorPN5clang13CXXRecordDeclE;_ZL20getImplicitMethodEPIRN5clang4SemaEPNS_13CXXMethodDeclE;_ZL21DelegatingCycleHelperPN5clang18CXXConstructorDeclERN4llvm8SmallSetIS1_Lj4ESt4lessIS1_EEES7_S7_RNS_4SemaE;_ZL21PopulateKeysForFieldsPN5clang9FieldDeclERN4llvm15SmallVectorImplIPKvEE;_ZL21SearchForReturnInStmtRN5clang4SemaEPNS_4StmtE;_ZL21buildSingleCopyAssignRN5clang4SemaENS_14SourceLocationENS_8QualTypeERKN12_GLOBAL__N_111ExprBuilderES7_bb;_ZL22CheckConstexprDeclStmtRN5clang4SemaEPKNS_12FunctionDeclEPNS_8DeclStmtERNS_14SourceLocationE;_ZL22findDirectBaseWithTypePN5clang13CXXRecordDeclENS_8QualTypeERb;_ZL23AddMostOverridenMethodsPKN5clang13CXXMethodDeclERN4llvm15SmallPtrSetImplIS2_EE;_ZL23CheckAbstractClassUsageRN12_GLOBAL__N_117AbstractUsageInfoEPN5clang13CXXMethodDeclE;_ZL23CheckAbstractClassUsageRN12_GLOBAL__N_117AbstractUsageInfoEPN5clang13CXXRecordDeclE;_ZL23CollectFieldInitializerRN5clang4SemaERN12_GLOBAL__N_116BaseAndFieldInfoEPNS_9FieldDeclEPNS_17IndirectFieldDeclE;_ZL23findCircularInheritancePKN5clang13CXXRecordDeclES2_;_ZL24IsEquivalentForUsingDeclRN5clang10ASTContextEPNS_9NamedDeclES3_;_ZL24LookupStdInitializerListRN5clang4SemaENS_14SourceLocationE;_ZL24checkTrivialClassMembersRN5clang4SemaEPNS_13CXXRecordDeclENS0_16CXXSpecialMemberEbb;_ZL24findTrivialSpecialMemberRN5clang4SemaEPNS_13CXXRecordDeclENS0_16CXXSpecialMemberEjbPPNS_13CXXMethodDeclE;_ZL24getRecordDiagFromTagKindN5clang11TagTypeKindE;_ZL24specialMemberIsConstexprRN5clang4SemaEPNS_13CXXRecordDeclENS0_16CXXSpecialMemberEjbPNS_18CXXConstructorDeclEPNS0_24InheritedConstructorInfoE;_ZL25checkTrivialSubobjectCallRN5clang4SemaENS_14SourceLocationENS_8QualTypeEbNS0_16CXXSpecialMemberE20TrivialSubobjectKindb;_ZL26CheckConstexprFunctionStmtRN5clang4SemaEPKNS_12FunctionDeclEPNS_4StmtERN4llvm15SmallVectorImplINS_14SourceLocationEEERS9_;_ZL26TryNamespaceTypoCorrectionRN5clang4SemaERNS_12LookupResultEPNS_5ScopeERNS_12CXXScopeSpecENS_14SourceLocationEPNS_14IdentifierInfoE;_ZL26buildMemcpyForAssignmentOpRN5clang4SemaENS_14SourceLocationENS_8QualTypeERKN12_GLOBAL__N_111ExprBuilderES7_;_ZL27CheckOperatorNewDeclarationRN5clang4SemaEPKNS_12FunctionDeclE;_ZL27CheckOperatorNewDeleteTypesRN5clang4SemaEPKNS_12FunctionDeclENS_7CanQualINS_4TypeEEES7_jj;_ZL27DefineImplicitSpecialMemberRN5clang4SemaEPNS_13CXXMethodDeclENS_14SourceLocationE;_ZL27ReferenceDllExportedMethodsRN5clang4SemaEPNS_13CXXRecordDeclE;_ZL27lookupCallFromSpecialMemberRN5clang4SemaEPNS_13CXXRecordDeclENS0_16CXXSpecialMemberEjb;_ZL28BuildImplicitBaseInitializerRN5clang4SemaEPNS_18CXXConstructorDeclE23ImplicitInitializerKindPNS_16CXXBaseSpecifierEbRPNS_18CXXCtorInitializerE;_ZL28CheckConstexprParameterTypesRN5clang4SemaEPKNS_12FunctionDeclE;_ZL28InitializationHasSideEffectsRKN5clang9FieldDeclE;_ZL28computeImplicitExceptionSpecRN5clang4SemaENS_14SourceLocationEPNS_13CXXMethodDeclE;_ZL29CheckConstexprCtorInitializerRN5clang4SemaEPKNS_12FunctionDeclEPNS_9FieldDeclERN4llvm8SmallSetIPNS_4DeclELj16ESt4lessISA_EEERb;_ZL30BuildImplicitMemberInitializerRN5clang4SemaEPNS_18CXXConstructorDeclE23ImplicitInitializerKindPNS_9FieldDeclEPNS_17IndirectFieldDeclERPNS_18CXXCtorInitializerE;_ZL30CheckOperatorDeleteDeclarationRN5clang4SemaEPNS_12FunctionDeclE;_ZL30functionDeclHasDefaultArgumentPKN5clang12FunctionDeclE;_ZL31DiagnoseNamespaceInlineMismatchRN5clang4SemaENS_14SourceLocationES2_PNS_14IdentifierInfoEPbPNS_13NamespaceDeclE;_ZL31diagnoseDeprecatedCopyOperationRN5clang4SemaEPNS_13CXXMethodDeclENS_14SourceLocationE;_ZL32buildSingleCopyAssignRecursivelyRN5clang4SemaENS_14SourceLocationENS_8QualTypeERKN12_GLOBAL__N_111ExprBuilderES7_bbj;_ZL33DiagnoseBaseOrMemInitializerOrderRN5clang4SemaEPKNS_18CXXConstructorDeclEN4llvm8ArrayRefIPNS_18CXXCtorInitializerEEE;_ZL33IsUsingDirectiveInToplevelContextPN5clang11DeclContextE;_ZL33defaultedSpecialMemberIsConstexprRN5clang4SemaEPNS_13CXXRecordDeclENS0_16CXXSpecialMemberEbPNS_18CXXConstructorDeclEPNS0_24InheritedConstructorInfoE;_ZL33getDefaultArgExprsForConstructorsRN5clang4SemaEPNS_13CXXRecordDeclE;_ZL33isIncompleteOrZeroLengthArrayTypeRN5clang10ASTContextENS_8QualTypeE;_ZL34CheckForDanglingReferenceOrPointerRN5clang4SemaEPNS_9ValueDeclEPNS_4ExprENS_14SourceLocationE;_ZL34checkMoveAssignmentForRepeatedMoveRN5clang4SemaEPNS_13CXXRecordDeclENS_14SourceLocationE;_ZL38CheckOperatorNewDeleteDeclarationScopeRN5clang4SemaEPKNS_12FunctionDeclE;_ZL41checkLiteralOperatorTemplateParameterListRN5clang4SemaEPNS_20FunctionTemplateDeclE;_ZN12_GLOBAL__N_118CheckRedundantInitERN5clang4SemaEPNS0_18CXXCtorInitializerERS4_;_ZN12_GLOBAL__N_123CheckRedundantUnionInitERN5clang4SemaEPNS0_18CXXCtorInitializerERN4llvm8DenseMapIPNS0_10RecordDeclESt4pairIPNS0_9NamedDeclES4_ENS5_12DenseMapInfoIS8_EENS5_6detail12DenseMapPairIS8_SC_EEEE;_ZN12_GLOBAL__N_1L27DiagnoseUninitializedFieldsERN5clang4SemaEPKNS0_18CXXConstructorDeclE; -static-type=SemaDeclCXXStatics -package=org.clang.sema.impl")
//</editor-fold>
public final class SemaDeclCXXStatics {

//<editor-fold defaultstate="collapsed" desc="functionDeclHasDefaultArgument">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 420,
 FQN="functionDeclHasDefaultArgument", NM="_ZL30functionDeclHasDefaultArgumentPKN5clang12FunctionDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZL30functionDeclHasDefaultArgumentPKN5clang12FunctionDeclE")
//</editor-fold>
public static boolean functionDeclHasDefaultArgument(/*const*/ FunctionDecl /*P*/ FD) {
  for (/*uint*/int NumParams = FD.getNumParams(); $greater_uint(NumParams, 0); --NumParams) {
    /*const*/ ParmVarDecl /*P*/ PVD = FD.getParamDecl$Const(NumParams - 1);
    if (!PVD.hasDefaultArg()) {
      return false;
    }
    if (!PVD.hasInheritedDefaultArg()) {
      return true;
    }
  }
  return false;
}


// CheckConstexprParameterTypes - Check whether a function's parameter types
// are all literal types. If so, return true. If not, produce a suitable
// diagnostic and return false.
//<editor-fold defaultstate="collapsed" desc="CheckConstexprParameterTypes">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 764,
 FQN="CheckConstexprParameterTypes", NM="_ZL28CheckConstexprParameterTypesRN5clang4SemaEPKNS_12FunctionDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZL28CheckConstexprParameterTypesRN5clang4SemaEPKNS_12FunctionDeclE")
//</editor-fold>
public static boolean CheckConstexprParameterTypes(final Sema /*&*/ SemaRef, 
                            /*const*/ FunctionDecl /*P*/ FD) {
  /*uint*/int ArgIndex = 0;
  /*const*/ FunctionProtoType /*P*/ FT = FD.getType().$arrow().getAs(FunctionProtoType.class);
  for (type$ptr<QualType> i = $tryClone(FT.param_type_begin()), 
      /*P*/ e = $tryClone(FT.param_type_end());
       $noteq_ptr(i, e); i.$preInc() , ++ArgIndex) {
    /*const*/ ParmVarDecl /*P*/ PD = FD.getParamDecl$Const(ArgIndex);
    SourceLocation ParamLoc = PD.getLocation();
    if (!(i.$star()).$arrow().isDependentType()
       && SemaRef.RequireLiteralType$T(new SourceLocation(ParamLoc), new QualType(i.$star()), 
        diag.err_constexpr_non_literal_param, 
        ArgIndex + 1, PD.getSourceRange(), 
        isa_CXXConstructorDecl(FD))) {
      return false;
    }
  }
  return true;
}


/// \brief Get diagnostic %select index for tag kind for
/// record diagnostic message.
/// WARNING: Indexes apply to particular diagnostics only!
///
/// \returns diagnostic %select index.
//<editor-fold defaultstate="collapsed" desc="getRecordDiagFromTagKind">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 788,
 FQN="getRecordDiagFromTagKind", NM="_ZL24getRecordDiagFromTagKindN5clang11TagTypeKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZL24getRecordDiagFromTagKindN5clang11TagTypeKindE")
//</editor-fold>
public static /*uint*/int getRecordDiagFromTagKind(TagTypeKind Tag) {
  switch (Tag) {
   case TTK_Struct:
    return 0;
   case TTK_Interface:
    return 1;
   case TTK_Class:
    return 2;
   default:
    throw new llvm_unreachable("Invalid tag kind for record diagnostic!");
  }
}


/// Check the given declaration statement is legal within a constexpr function
/// body. C++11 [dcl.constexpr]p3,p4, and C++1y [dcl.constexpr]p3.
///
/// \return true if the body is OK (maybe only as an extension), false if we
///         have diagnosed a problem.
//<editor-fold defaultstate="collapsed" desc="CheckConstexprDeclStmt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 863,
 FQN="CheckConstexprDeclStmt", NM="_ZL22CheckConstexprDeclStmtRN5clang4SemaEPKNS_12FunctionDeclEPNS_8DeclStmtERNS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZL22CheckConstexprDeclStmtRN5clang4SemaEPKNS_12FunctionDeclEPNS_8DeclStmtERNS_14SourceLocationE")
//</editor-fold>
public static boolean CheckConstexprDeclStmt(final Sema /*&*/ SemaRef, /*const*/ FunctionDecl /*P*/ Dcl, 
                      DeclStmt /*P*/ DS, final SourceLocation /*&*/ Cxx1yLoc) {
  // C++11 [dcl.constexpr]p3 and p4:
  //  The definition of a constexpr function(p3) or constructor(p4) [...] shall
  //  contain only
  for (/*const*/ Decl /*P*/ DclIt : DS.decls()) {
    switch (DclIt.getKind()) {
     case StaticAssert:
     case Using:
     case UsingShadow:
     case UsingDirective:
     case UnresolvedUsingTypename:
     case UnresolvedUsingValue:
      //   - static_assert-declarations
      //   - using-declarations,
      //   - using-directives,
      continue;
     case Typedef:
     case TypeAlias:
      {
        //   - typedef declarations and alias-declarations that do not define
        //     classes or enumerations,
        /*const*/ TypedefNameDecl /*P*/ TN = cast_TypedefNameDecl(DclIt);
        if (TN.getUnderlyingType().$arrow().isVariablyModifiedType()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            // Don't allow variably-modified types in constexpr functions.
            TypeLoc TL = TN.getTypeSourceInfo().getTypeLoc();
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(TL.getBeginLoc(), diag.err_constexpr_vla)), 
                        TL.getSourceRange()), TL.getType()), 
                isa_CXXConstructorDecl(Dcl)));
            return false;
          } finally {
            $c$.$destroy();
          }
        }
        continue;
      }
     case Enum:
     case CXXRecord:
      // C++1y allows types to be defined, not just declared.
      if (cast_TagDecl(DclIt).isThisDeclarationADefinition()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(DS.getLocStart(), 
                  SemaRef.getLangOpts().CPlusPlus14 ? diag.warn_cxx11_compat_constexpr_type_definition : diag.ext_constexpr_type_definition)), 
              isa_CXXConstructorDecl(Dcl)));
        } finally {
          $c$.$destroy();
        }
      }
      continue;
     case EnumConstant:
     case IndirectField:
     case ParmVar:
      // These can only appear with other declarations which are banned in
      // C++11 and permitted in C++1y, so ignore them.
      continue;
     case Var:
      {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // C++1y [dcl.constexpr]p3 allows anything except:
          //   a definition of a variable of non-literal type or of static or
          //   thread storage duration or for which no initialization is performed.
          /*const*/ VarDecl /*P*/ VD = cast_VarDecl(DclIt);
          if ((VD.isThisDeclarationADefinition().getValue() != 0)) {
            if (VD.isStaticLocal()) {
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(VD.getLocation(), 
                          diag.err_constexpr_local_var_static)), 
                      isa_CXXConstructorDecl(Dcl)), 
                  (VD.getTLSKind() == VarDecl.TLSKind.TLS_Dynamic)));
              return false;
            }
            if (!VD.getType().$arrow().isDependentType()
               && SemaRef.RequireLiteralType$T(VD.getLocation(), VD.getType(), 
                diag.err_constexpr_local_var_non_literal_type, 
                isa_CXXConstructorDecl(Dcl))) {
              return false;
            }
            if (!VD.getType().$arrow().isDependentType()
               && !VD.hasInit() && !VD.isCXXForRangeDecl()) {
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(VD.getLocation(), 
                      diag.err_constexpr_local_var_no_init)), 
                  isa_CXXConstructorDecl(Dcl)));
              return false;
            }
          }
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(VD.getLocation(), 
                  SemaRef.getLangOpts().CPlusPlus14 ? diag.warn_cxx11_compat_constexpr_local_var : diag.ext_constexpr_local_var)), 
              isa_CXXConstructorDecl(Dcl)));
          continue;
        } finally {
          $c$.$destroy();
        }
      }
     case NamespaceAlias:
     case Function:
      // These are disallowed in C++11 and permitted in C++1y. Allow them
      // everywhere as an extension.
      if (!Cxx1yLoc.isValid()) {
        Cxx1yLoc.$assignMove(DS.getLocStart());
      }
      continue;
     default:
      {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(DS.getLocStart(), diag.err_constexpr_body_invalid_stmt)), 
              isa_CXXConstructorDecl(Dcl)));
          return false;
        } finally {
          $c$.$destroy();
        }
      }
    }
  }
  
  return true;
}


/// Check that the given field is initialized within a constexpr constructor.
///
/// \param Dcl The constexpr constructor being checked.
/// \param Field The field being checked. This may be a member of an anonymous
///        struct or union nested within the class being checked.
/// \param Inits All declarations, including anonymous struct/union members and
///        indirect members, for which any initialization was provided.
/// \param Diagnosed Set to true if an error is produced.
//<editor-fold defaultstate="collapsed" desc="CheckConstexprCtorInitializer">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 976,
 FQN="CheckConstexprCtorInitializer", NM="_ZL29CheckConstexprCtorInitializerRN5clang4SemaEPKNS_12FunctionDeclEPNS_9FieldDeclERN4llvm8SmallSetIPNS_4DeclELj16ESt4lessISA_EEERb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZL29CheckConstexprCtorInitializerRN5clang4SemaEPKNS_12FunctionDeclEPNS_9FieldDeclERN4llvm8SmallSetIPNS_4DeclELj16ESt4lessISA_EEERb")
//</editor-fold>
public static void CheckConstexprCtorInitializer(final Sema /*&*/ SemaRef, 
                             /*const*/ FunctionDecl /*P*/ Dcl, 
                             FieldDecl /*P*/ Field, 
                             final SmallSetT$PLess$T$P<Decl /*P*/ > /*&*/ Inits, 
                             final bool$ref/*bool &*/ Diagnosed) {
  if (Field.isInvalidDecl()) {
    return;
  }
  if (Field.isUnnamedBitfield()) {
    return;
  }
  
  // Anonymous unions with no variant members and empty anonymous structs do not
  // need to be explicitly initialized. FIXME: Anonymous structs that contain no
  // indirect fields don't need initializing.
  if (Field.isAnonymousStructOrUnion()
     && (Field.getType().$arrow().isUnionType() ? !Field.getType().$arrow().getAsCXXRecordDecl().hasVariantMembers() : Field.getType().$arrow().getAsCXXRecordDecl().isEmpty())) {
    return;
  }
  if (!(Inits.count(Field) != 0)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      if (!Diagnosed.$deref()) {
        $c$.clean($c$.track(SemaRef.Diag(Dcl.getLocation(), diag.err_constexpr_ctor_missing_init)));
        Diagnosed.$set(true);
      }
      $c$.clean($c$.track(SemaRef.Diag(Field.getLocation(), diag.note_constexpr_ctor_missing_init)));
    } finally {
      $c$.$destroy();
    }
  } else if (Field.isAnonymousStructOrUnion()) {
    /*const*/ RecordDecl /*P*/ RD = Field.getType().$arrow().<RecordType>castAs$RecordType().getDecl();
    for (FieldDecl /*P*/ I : RD.fields())  {
      // If an anonymous union contains an anonymous struct of which any member
      // is initialized, all members must be initialized.
      if (!RD.isUnion() || (Inits.count(I) != 0)) {
        CheckConstexprCtorInitializer(SemaRef, Dcl, I, Inits, Diagnosed);
      }
    }
  }
}


/// Check the provided statement is allowed in a constexpr function
/// definition.
//<editor-fold defaultstate="collapsed" desc="CheckConstexprFunctionStmt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 1014,
 FQN="CheckConstexprFunctionStmt", NM="_ZL26CheckConstexprFunctionStmtRN5clang4SemaEPKNS_12FunctionDeclEPNS_4StmtERN4llvm15SmallVectorImplINS_14SourceLocationEEERS9_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZL26CheckConstexprFunctionStmtRN5clang4SemaEPKNS_12FunctionDeclEPNS_4StmtERN4llvm15SmallVectorImplINS_14SourceLocationEEERS9_")
//</editor-fold>
public static boolean CheckConstexprFunctionStmt(final Sema /*&*/ SemaRef, /*const*/ FunctionDecl /*P*/ Dcl, Stmt /*P*/ S, 
                          final SmallVectorImpl<SourceLocation> /*&*/ ReturnStmts, 
                          final SourceLocation /*&*/ Cxx1yLoc) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    // - its function-body shall be [...] a compound-statement that contains only
    switch (S.getStmtClass()) {
     case NullStmtClass:
      //   - null statements,
      return true;
     case DeclStmtClass:
      //   - static_assert-declarations
      //   - using-declarations,
      //   - using-directives,
      //   - typedef declarations and alias-declarations that do not define
      //     classes or enumerations,
      if (!CheckConstexprDeclStmt(SemaRef, Dcl, cast_DeclStmt(S), Cxx1yLoc)) {
        return false;
      }
      return true;
     case ReturnStmtClass:
      //   - and exactly one return statement;
      if (isa_CXXConstructorDecl(Dcl)) {
        // C++1y allows return statements in constexpr constructors.
        if (!Cxx1yLoc.isValid()) {
          Cxx1yLoc.$assignMove(S.getLocStart());
        }
        return true;
      }
      
      ReturnStmts.push_back(S.getLocStart());
      return true;
     case CompoundStmtClass:
      {
        // C++1y allows compound-statements.
        if (!Cxx1yLoc.isValid()) {
          Cxx1yLoc.$assignMove(S.getLocStart());
        }
        
        CompoundStmt /*P*/ CompStmt = cast_CompoundStmt(S);
        for (Stmt /*P*/ BodyIt : CompStmt.body()) {
          if (!CheckConstexprFunctionStmt(SemaRef, Dcl, BodyIt, ReturnStmts, 
              Cxx1yLoc)) {
            return false;
          }
        }
        return true;
      }
     case AttributedStmtClass:
      if (!Cxx1yLoc.isValid()) {
        Cxx1yLoc.$assignMove(S.getLocStart());
      }
      return true;
     case IfStmtClass:
      {
        // C++1y allows if-statements.
        if (!Cxx1yLoc.isValid()) {
          Cxx1yLoc.$assignMove(S.getLocStart());
        }
        
        IfStmt /*P*/ If = cast_IfStmt(S);
        if (!CheckConstexprFunctionStmt(SemaRef, Dcl, If.getThen(), ReturnStmts, 
            Cxx1yLoc)) {
          return false;
        }
        if ((If.getElse() != null)
           && !CheckConstexprFunctionStmt(SemaRef, Dcl, If.getElse(), ReturnStmts, 
            Cxx1yLoc)) {
          return false;
        }
        return true;
      }
     case WhileStmtClass:
     case DoStmtClass:
     case ForStmtClass:
     case CXXForRangeStmtClass:
     case ContinueStmtClass:
      // C++1y allows all of these. We don't allow them as extensions in C++11,
      // because they don't make sense without variable mutation.
      if (!SemaRef.getLangOpts().CPlusPlus14) {
        break;
      }
      if (!Cxx1yLoc.isValid()) {
        Cxx1yLoc.$assignMove(S.getLocStart());
      }
      for (Stmt /*P*/ SubStmt : S.children())  {
        if ((SubStmt != null)
           && !CheckConstexprFunctionStmt(SemaRef, Dcl, SubStmt, ReturnStmts, 
            Cxx1yLoc)) {
          return false;
        }
      }
      return true;
     case SwitchStmtClass:
     case CaseStmtClass:
     case DefaultStmtClass:
     case BreakStmtClass:
      // C++1y allows switch-statements, and since they don't need variable
      // mutation, we can reasonably allow them in C++11 as an extension.
      if (!Cxx1yLoc.isValid()) {
        Cxx1yLoc.$assignMove(S.getLocStart());
      }
      for (Stmt /*P*/ SubStmt : S.children())  {
        if ((SubStmt != null)
           && !CheckConstexprFunctionStmt(SemaRef, Dcl, SubStmt, ReturnStmts, 
            Cxx1yLoc)) {
          return false;
        }
      }
      return true;
     default:
      if (!isa_Expr(S)) {
        break;
      }
      
      // C++1y allows expression-statements.
      if (!Cxx1yLoc.isValid()) {
        Cxx1yLoc.$assignMove(S.getLocStart());
      }
      return true;
    }
    
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(S.getLocStart(), diag.err_constexpr_body_invalid_stmt)), 
        isa_CXXConstructorDecl(Dcl)));
    return false;
  } finally {
    $c$.$destroy();
  }
}


/// \brief Determine whether the given class is a base class of the given
/// class, including looking at dependent bases.
//<editor-fold defaultstate="collapsed" desc="findCircularInheritance">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 1316,
 FQN="findCircularInheritance", NM="_ZL23findCircularInheritancePKN5clang13CXXRecordDeclES2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZL23findCircularInheritancePKN5clang13CXXRecordDeclES2_")
//</editor-fold>
public static boolean findCircularInheritance(/*const*/ CXXRecordDecl /*P*/ Class, 
                       /*const*/ CXXRecordDecl /*P*/ Current) {
  SmallVector</*const*/ CXXRecordDecl /*P*/ > Queue/*J*/= new SmallVector</*const*/ CXXRecordDecl /*P*/ >(8, (/*const*/ CXXRecordDecl /*P*/ )null);
  
  Class = Class.getCanonicalDecl$Const();
  while (true) {
    for (final /*const*/ CXXBaseSpecifier /*&*/ I : Current.bases$Const()) {
      CXXRecordDecl /*P*/ Base = I.getType().$arrow().getAsCXXRecordDecl();
      if (!(Base != null)) {
        continue;
      }
      
      Base = Base.getDefinition();
      if (!(Base != null)) {
        continue;
      }
      if (Base.getCanonicalDecl() == Class) {
        return true;
      }
      
      Queue.push_back(Base);
    }
    if (Queue.empty()) {
      return false;
    }
    
    Current = Queue.pop_back_val();
  }
  
  //return false;
}


/// \brief Recursively add the bases of Type.  Don't add Type itself.
//<editor-fold defaultstate="collapsed" desc="NoteIndirectBases">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 1534,
 FQN="NoteIndirectBases", NM="_ZL17NoteIndirectBasesRN5clang10ASTContextERN4llvm11SmallPtrSetINS_8QualTypeELj4EEERKS4_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZL17NoteIndirectBasesRN5clang10ASTContextERN4llvm11SmallPtrSetINS_8QualTypeELj4EEERKS4_")
//</editor-fold>
public static void NoteIndirectBases(final ASTContext /*&*/ Context, final SmallPtrSet<QualType> /*&*/ Set, 
                 final /*const*/ QualType /*&*/ Type) {
  {
    // Even though the incoming type is a base, it might not be
    // a class -- it could be a template parm, for instance.
    /*const*/ RecordType /*P*/ Rec = Type.$arrow().<RecordType>getAs$RecordType();
    if ((Rec != null)) {
      CXXRecordDecl /*P*/ Decl = Rec.getAsCXXRecordDecl();
      
      // Iterate over its bases.
      for (final /*const*/ CXXBaseSpecifier /*&*/ BaseSpec : Decl.bases()) {
        QualType Base = Context.getCanonicalType(BaseSpec.getType()).
            getUnqualifiedType().$QualType();
        if (Set.insert(new QualType(Base)).second) {
          // If we've not already seen it, recurse.
          NoteIndirectBases(Context, Set, Base);
        }
      }
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="InitializationHasSideEffects">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 1982,
 FQN="InitializationHasSideEffects", NM="_ZL28InitializationHasSideEffectsRKN5clang9FieldDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZL28InitializationHasSideEffectsRKN5clang9FieldDeclE")
//</editor-fold>
public static boolean InitializationHasSideEffects(final /*const*/ FieldDecl /*&*/ FD) {
  /*const*/ Type /*P*/ T = FD.getType().$arrow().getBaseElementTypeUnsafe();
  {
    // FIXME: Destruction of ObjC lifetime types has side-effects.
    /*const*/ CXXRecordDecl /*P*/ RD = T.getAsCXXRecordDecl();
    if ((RD != null)) {
      return !RD.isCompleteDefinition()
         || !RD.hasTrivialDefaultConstructor()
         || !RD.hasTrivialDestructor();
    }
  }
  return false;
}

//<editor-fold defaultstate="collapsed" desc="getMSPropertyAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 1992,
 FQN="getMSPropertyAttr", NM="_ZL17getMSPropertyAttrPN5clang13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZL17getMSPropertyAttrPN5clang13AttributeListE")
//</editor-fold>
public static AttributeList /*P*/ getMSPropertyAttr(AttributeList /*P*/ list) {
  for (AttributeList /*P*/ it = list; it != null; it = it.getNext())  {
    if (it.isDeclspecPropertyAttribute()) {
      return it;
    }
  }
  return null;
}


// Diagnose value-uses of fields to initialize themselves, e.g.
//   foo(foo)
// where foo is not also a parameter to the constructor.
// Also diagnose across field uninitialized use such as
//   x(y), y(x)
// TODO: implement -Wuninitialized and fold this into that framework.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DiagnoseUninitializedFields">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 2615,
 FQN="(anonymous namespace)::DiagnoseUninitializedFields", NM="_ZN12_GLOBAL__N_1L27DiagnoseUninitializedFieldsERN5clang4SemaEPKNS0_18CXXConstructorDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN12_GLOBAL__N_1L27DiagnoseUninitializedFieldsERN5clang4SemaEPKNS0_18CXXConstructorDeclE")
//</editor-fold>
public static void DiagnoseUninitializedFields(final Sema /*&*/ SemaRef, /*const*/ CXXConstructorDecl /*P*/ Constructor) {
  UninitializedFieldVisitor UninitializedChecker = null;
  try {
    if (SemaRef.getDiagnostics().isIgnored(diag.warn_field_is_uninit, 
        Constructor.getLocation())) {
      return;
    }
    if (Constructor.isInvalidDecl()) {
      return;
    }
    
    /*const*/ CXXRecordDecl /*P*/ RD = Constructor.getParent$Const();
    if ((RD.getDescribedClassTemplate() != null)) {
      return;
    }
    
    // Holds fields that are uninitialized.
    SmallPtrSet<ValueDecl /*P*/ > UninitializedFields/*J*/= new SmallPtrSet<ValueDecl /*P*/ >(DenseMapInfo$LikePtr.$Info(), 4);
    
    // At the beginning, all fields are uninitialized.
    for (Decl /*P*/ I : RD.decls()) {
      {
        FieldDecl /*P*/ FD = dyn_cast_FieldDecl(I);
        if ((FD != null)) {
          UninitializedFields.insert(FD);
        } else {
          IndirectFieldDecl /*P*/ IFD = dyn_cast_IndirectFieldDecl(I);
          if ((IFD != null)) {
            UninitializedFields.insert(IFD.getAnonField());
          }
        }
      }
    }
    
    SmallPtrSet<QualType> UninitializedBaseClasses/*J*/= new SmallPtrSet<QualType>(DenseMapInfoQualType.$Info(), 4);
    for (CXXBaseSpecifier I : RD.bases$Const())  {
      UninitializedBaseClasses.insert(I.getType().getCanonicalType());
    }
    if (UninitializedFields.empty() && UninitializedBaseClasses.empty()) {
      return;
    }
    
    UninitializedChecker/*J*/= new UninitializedFieldVisitor(SemaRef, 
        UninitializedFields, 
        UninitializedBaseClasses);
    
    for (/*const*/ CXXCtorInitializer /*P*/ FieldInit : Constructor.inits$Const()) {
      if (UninitializedFields.empty() && UninitializedBaseClasses.empty()) {
        break;
      }
      
      Expr /*P*/ InitExpr = FieldInit.getInit();
      if (!(InitExpr != null)) {
        continue;
      }
      {
        
        CXXDefaultInitExpr /*P*/ Default = dyn_cast_CXXDefaultInitExpr(InitExpr);
        if ((Default != null)) {
          InitExpr = Default.getExpr();
          if (!(InitExpr != null)) {
            continue;
          }
          // In class initializers will point to the constructor.
          UninitializedChecker.CheckInitializer(InitExpr, Constructor, 
              FieldInit.getAnyMember(), 
              FieldInit.getBaseClass());
        } else {
          UninitializedChecker.CheckInitializer(InitExpr, (/*const*/ CXXConstructorDecl /*P*/ )null, 
              FieldInit.getAnyMember(), 
              FieldInit.getBaseClass());
        }
      }
    }
  } finally {
    if (UninitializedChecker != null) { UninitializedChecker.$destroy(); }
  }
}


/// \brief Find the direct and/or virtual base specifiers that
/// correspond to the given base type, for use in base initialization
/// within a constructor.
//<editor-fold defaultstate="collapsed" desc="FindBaseInitializer">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 2746,
 FQN="FindBaseInitializer", NM="_ZL19FindBaseInitializerRN5clang4SemaEPNS_13CXXRecordDeclENS_8QualTypeERPKNS_16CXXBaseSpecifierES8_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZL19FindBaseInitializerRN5clang4SemaEPNS_13CXXRecordDeclENS_8QualTypeERPKNS_16CXXBaseSpecifierES8_")
//</editor-fold>
public static boolean FindBaseInitializer(final Sema /*&*/ SemaRef, 
                   CXXRecordDecl /*P*/ ClassDecl, 
                   QualType BaseType, 
                   final type$ref</*const*/ CXXBaseSpecifier /*P*/ /*&*/> DirectBaseSpec, 
                   final type$ref</*const*/ CXXBaseSpecifier /*P*/ /*&*/> VirtualBaseSpec) {
  // First, check for a direct base class.
  DirectBaseSpec.$set(null);
  for (final /*const*/ CXXBaseSpecifier /*&*/ Base : ClassDecl.bases()) {
    if (SemaRef.Context.hasSameUnqualifiedType(new QualType(BaseType), Base.getType())) {
      // We found a direct base of this type. That's what we're
      // initializing.
      DirectBaseSpec.$set($AddrOf(Base));
      break;
    }
  }
  
  // Check for a virtual base class.
  // FIXME: We might be able to short-circuit this if we know in advance that
  // there are no virtual bases.
  VirtualBaseSpec.$set(null);
  if (!(DirectBaseSpec.$deref() != null) || !DirectBaseSpec.$deref().isVirtual()) {
    CXXBasePaths Paths = null;
    try {
      // We haven't found a base yet; search the class hierarchy for a
      // virtual base class.
      Paths/*J*/= new CXXBasePaths(/*FindAmbiguities=*/ true, /*RecordPaths=*/ true, 
          /*DetectVirtual=*/ false);
      if (SemaRef.IsDerivedFrom(ClassDecl.getLocation(), 
          SemaRef.Context.getTypeDeclType(ClassDecl), 
          new QualType(BaseType), Paths)) {
        for (std.list.iterator<CXXBasePath> Path = Paths.begin();
             Path.$noteq(Paths.end()); Path.$preInc()) {
          if (Path.$arrow().back().Base.isVirtual()) {
            VirtualBaseSpec.$set(Path.$arrow().back().Base);
            break;
          }
        }
      }
    } finally {
      if (Paths != null) { Paths.$destroy(); }
    }
  }
  
  return (DirectBaseSpec.$deref() != null) || (VirtualBaseSpec.$deref() != null);
}


/// Checks a member initializer expression for cases where reference (or
/// pointer) members are bound to by-value parameters (or their addresses).
//<editor-fold defaultstate="collapsed" desc="CheckForDanglingReferenceOrPointer">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 3015,
 FQN="CheckForDanglingReferenceOrPointer", NM="_ZL34CheckForDanglingReferenceOrPointerRN5clang4SemaEPNS_9ValueDeclEPNS_4ExprENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZL34CheckForDanglingReferenceOrPointerRN5clang4SemaEPNS_9ValueDeclEPNS_4ExprENS_14SourceLocationE")
//</editor-fold>
public static void CheckForDanglingReferenceOrPointer(final Sema /*&*/ S, ValueDecl /*P*/ Member, 
                                  Expr /*P*/ Init, 
                                  SourceLocation IdLoc) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    QualType MemberTy = Member.getType();
    
    // We only handle pointers and references currently.
    // FIXME: Would this be relevant for ObjC object pointers? Or block pointers?
    if (!MemberTy.$arrow().isReferenceType() && !MemberTy.$arrow().isPointerType()) {
      return;
    }
    
    /*const*/boolean IsPointer = MemberTy.$arrow().isPointerType();
    if (IsPointer) {
      {
        /*const*/ UnaryOperator /*P*/ Op = dyn_cast_UnaryOperator(Init.IgnoreParenImpCasts());
        if ((Op != null)) {
          // The only case we're worried about with pointers requires taking the
          // address.
          if (Op.getOpcode() != UnaryOperatorKind.UO_AddrOf) {
            return;
          }
          
          Init = Op.getSubExpr();
        } else {
          // We only handle address-of expression initializers for pointers.
          return;
        }
      }
    }
    {
      
      /*const*/ DeclRefExpr /*P*/ DRE = dyn_cast_DeclRefExpr(Init.IgnoreParens());
      if ((DRE != null)) {
        // We only warn when referring to a non-reference parameter declaration.
        /*const*/ ParmVarDecl /*P*/ Parameter = dyn_cast_ParmVarDecl(DRE.getDecl$Const());
        if (!(Parameter != null) || Parameter.getType().$arrow().isReferenceType()) {
          return;
        }
        
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Init.getExprLoc(), 
                        IsPointer ? diag.warn_init_ptr_member_to_parameter_addr : diag.warn_bind_ref_member_to_parameter)), 
                    Member), Parameter), Init.getSourceRange()));
      } else {
        // Other initializers are fine.
        return;
      }
    }
    
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Member.getLocation(), diag.note_ref_or_ptr_member_declared_here)), 
        (/*uint*/int)(IsPointer ? 1 : 0)));
  } finally {
    $c$.$destroy();
  }
}


// Create a static_cast\<T&&>(expr).
//<editor-fold defaultstate="collapsed" desc="CastForMoving">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 3324,
 FQN="CastForMoving", NM="_ZL13CastForMovingRN5clang4SemaEPNS_4ExprENS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZL13CastForMovingRN5clang4SemaEPNS_4ExprENS_8QualTypeE")
//</editor-fold>
public static Expr /*P*/ CastForMoving(final Sema /*&*/ SemaRef, Expr /*P*/ E) {
  return CastForMoving(SemaRef, E, new QualType());
}
public static Expr /*P*/ CastForMoving(final Sema /*&*/ SemaRef, Expr /*P*/ E, QualType T/*= QualType()*/) {
  if (T.isNull()) {
    T.$assignMove(E.getType());
  }
  QualType TargetType = SemaRef.BuildReferenceType(new QualType(T), /*SpelledAsLValue*/ false, new SourceLocation(), new DeclarationName());
  SourceLocation ExprLoc = E.getLocStart();
  TypeSourceInfo /*P*/ TargetLoc = SemaRef.Context.getTrivialTypeSourceInfo(new QualType(TargetType), new SourceLocation(ExprLoc));
  
  return SemaRef.BuildCXXNamedCast(new SourceLocation(ExprLoc), tok.TokenKind.kw_static_cast, TargetLoc, E, 
      new SourceRange(/*NO_COPY*/ExprLoc, /*NO_COPY*/ExprLoc), 
      E.getSourceRange()).get();
}

//<editor-fold defaultstate="collapsed" desc="BuildImplicitBaseInitializer">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 3346,
 FQN="BuildImplicitBaseInitializer", NM="_ZL28BuildImplicitBaseInitializerRN5clang4SemaEPNS_18CXXConstructorDeclE23ImplicitInitializerKindPNS_16CXXBaseSpecifierEbRPNS_18CXXCtorInitializerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZL28BuildImplicitBaseInitializerRN5clang4SemaEPNS_18CXXConstructorDeclE23ImplicitInitializerKindPNS_16CXXBaseSpecifierEbRPNS_18CXXCtorInitializerE")
//</editor-fold>
public static boolean BuildImplicitBaseInitializer(final Sema /*&*/ SemaRef, CXXConstructorDecl /*P*/ Constructor, 
                            ImplicitInitializerKind ImplicitInitKind, 
                            CXXBaseSpecifier /*P*/ BaseSpec, 
                            boolean IsInheritedVirtualBase, 
                            final type$ref<CXXCtorInitializer /*P*/ /*&*/> CXXBaseInit) {
  InitializedEntity InitEntity = InitializedEntity.InitializeBase(SemaRef.Context, BaseSpec, 
      IsInheritedVirtualBase);
  
  ActionResultTTrue<Expr /*P*/ > BaseInit/*J*/= new ActionResultTTrue<Expr /*P*/ >();
  switch (ImplicitInitKind) {
   case IIK_Inherit:
   case IIK_Default:
    {
      InitializationSequence InitSeq = null;
      try {
        InitializationKind InitKind = InitializationKind.CreateDefault(Constructor.getLocation());
        InitSeq/*J*/= new InitializationSequence(SemaRef, InitEntity, InitKind, new MutableArrayRef<Expr /*P*/ >(None, true));
        BaseInit.$assignMove(InitSeq.Perform(SemaRef, InitEntity, InitKind, new MutableArrayRef<Expr /*P*/ >(None, true)));
        break;
      } finally {
        if (InitSeq != null) { InitSeq.$destroy(); }
      }
    }
   case IIK_Move:
   case IIK_Copy:
    {
      InitializationSequence InitSeq = null;
      try {
        boolean Moving = ImplicitInitKind == ImplicitInitializerKind.IIK_Move;
        ParmVarDecl /*P*/ Param = Constructor.getParamDecl(0);
        QualType ParamType = Param.getType().getNonReferenceType();
        
        Expr /*P*/ CopyCtorArg = DeclRefExpr.Create(SemaRef.Context, new NestedNameSpecifierLoc(), 
            new SourceLocation(), Param, false, 
            Constructor.getLocation(), new QualType(ParamType), 
            ExprValueKind.VK_LValue, (NamedDecl /*P*/ )null);
        
        SemaRef.MarkDeclRefReferenced(cast_DeclRefExpr(CopyCtorArg));
        
        // Cast to the base class to avoid ambiguities.
        QualType ArgTy = SemaRef.Context.getQualifiedType(BaseSpec.getType().getUnqualifiedType(), 
            ParamType.getQualifiers());
        if (Moving) {
          CopyCtorArg = CastForMoving(SemaRef, CopyCtorArg);
        }
        
        SmallVector<CXXBaseSpecifier /*P*/> BasePath/*J*/= new SmallVector<CXXBaseSpecifier /*P*/>(4, null);
        BasePath.push_back(BaseSpec);
        CopyCtorArg = SemaRef.ImpCastExprToType(CopyCtorArg, new QualType(ArgTy), 
            CastKind.CK_UncheckedDerivedToBase, 
            Moving ? ExprValueKind.VK_XValue : ExprValueKind.VK_LValue, 
            $AddrOf(BasePath)).get();
        
        InitializationKind InitKind = InitializationKind.CreateDirect(Constructor.getLocation(), 
            new SourceLocation(), new SourceLocation());
        InitSeq/*J*/= new InitializationSequence(SemaRef, InitEntity, InitKind, new MutableArrayRef<Expr /*P*/ >(CopyCtorArg, true));
        BaseInit.$assignMove(InitSeq.Perform(SemaRef, InitEntity, InitKind, new MutableArrayRef<Expr /*P*/ >(CopyCtorArg, true)));
        break;
      } finally {
        if (InitSeq != null) { InitSeq.$destroy(); }
      }
    }
  }
  
  BaseInit.$assignMove(SemaRef.MaybeCreateExprWithCleanups(new ActionResultTTrue<Expr /*P*/ >(BaseInit)));
  if (BaseInit.isInvalid()) {
    return true;
  }
  
  CXXBaseInit.$set(/*FIXME:NEW_EXPR*//*new (SemaRef.Context)*/ new CXXCtorInitializer(SemaRef.Context, 
      SemaRef.Context.getTrivialTypeSourceInfo(BaseSpec.getType(), 
          new SourceLocation()), 
      BaseSpec.isVirtual(), 
      new SourceLocation(), 
      BaseInit.getAs(Expr.class), 
      new SourceLocation(), 
      new SourceLocation()));
  
  return false;
}

//<editor-fold defaultstate="collapsed" desc="RefersToRValueRef">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 3424,
 FQN="RefersToRValueRef", NM="_ZL17RefersToRValueRefPN5clang4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZL17RefersToRValueRefPN5clang4ExprE")
//</editor-fold>
public static boolean RefersToRValueRef(Expr /*P*/ MemRef) {
  ValueDecl /*P*/ Referenced = cast_MemberExpr(MemRef).getMemberDecl();
  return Referenced.getType().$arrow().isRValueReferenceType();
}

//<editor-fold defaultstate="collapsed" desc="BuildImplicitMemberInitializer">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 optimized = Converted.Optimization.VALUE_TYPE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 3429,
 FQN="BuildImplicitMemberInitializer", NM="_ZL30BuildImplicitMemberInitializerRN5clang4SemaEPNS_18CXXConstructorDeclE23ImplicitInitializerKindPNS_9FieldDeclEPNS_17IndirectFieldDeclERPNS_18CXXCtorInitializerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZL30BuildImplicitMemberInitializerRN5clang4SemaEPNS_18CXXConstructorDeclE23ImplicitInitializerKindPNS_9FieldDeclEPNS_17IndirectFieldDeclERPNS_18CXXCtorInitializerE")
//</editor-fold>
public static boolean BuildImplicitMemberInitializer(final Sema /*&*/ SemaRef, CXXConstructorDecl /*P*/ Constructor, 
                              ImplicitInitializerKind ImplicitInitKind, 
                              FieldDecl /*P*/ Field, IndirectFieldDecl /*P*/ Indirect, 
                              final type$ptr<CXXCtorInitializer /*P*/ /*&*/> CXXMemberInit) {
  if (Field.isInvalidDecl()) {
    return true;
  }
  
  SourceLocation Loc = Constructor.getLocation();
  if (ImplicitInitKind == ImplicitInitializerKind.IIK_Copy || ImplicitInitKind == ImplicitInitializerKind.IIK_Move) {
    CXXScopeSpec SS = null;
    LookupResult MemberLookup = null;
    InitializationSequence InitSeq = null;
    try {
      boolean Moving = ImplicitInitKind == ImplicitInitializerKind.IIK_Move;
      ParmVarDecl /*P*/ Param = Constructor.getParamDecl(0);
      QualType ParamType = Param.getType().getNonReferenceType();
      
      // Suppress copying zero-width bitfields.
      if (Field.isBitField() && Field.getBitWidthValue(SemaRef.Context) == 0) {
        return false;
      }
      
      Expr /*P*/ MemberExprBase = DeclRefExpr.Create(SemaRef.Context, new NestedNameSpecifierLoc(), 
          new SourceLocation(), Param, false, 
          new SourceLocation(Loc), new QualType(ParamType), ExprValueKind.VK_LValue, (NamedDecl /*P*/ )null);
      
      SemaRef.MarkDeclRefReferenced(cast_DeclRefExpr(MemberExprBase));
      if (Moving) {
        MemberExprBase = CastForMoving(SemaRef, MemberExprBase);
      }
      
      // Build a reference to this field within the parameter.
      SS/*J*/= new CXXScopeSpec();
      MemberLookup/*J*/= new LookupResult(SemaRef, Field.getDeclName(), new SourceLocation(Loc), 
          Sema.LookupNameKind.LookupMemberName);
      MemberLookup.addDecl((Indirect != null) ? cast_ValueDecl(Indirect) : cast_ValueDecl(Field), AccessSpecifier.AS_public);
      MemberLookup.resolveKind();
      ActionResultTTrue<Expr /*P*/ > CtorArg = SemaRef.BuildMemberReferenceExpr2(MemberExprBase, 
          new QualType(ParamType), new SourceLocation(Loc), 
          /*IsArrow=*/ false, 
          SS, 
          /*TemplateKWLoc=*/ new SourceLocation(), 
          /*FirstQualifierInScope=*/ (NamedDecl /*P*/ )null, 
          MemberLookup, 
          /*TemplateArgs=*/ (/*const*/ TemplateArgumentListInfo /*P*/ )null, 
          /*S*/ (/*const*/ Scope /*P*/ )null);
      if (CtorArg.isInvalid()) {
        return true;
      }
      
      // C++11 [class.copy]p15:
      //   - if a member m has rvalue reference type T&&, it is direct-initialized
      //     with static_cast<T&&>(x.m);
      if (RefersToRValueRef(CtorArg.get())) {
        CtorArg.$assign(CastForMoving(SemaRef, CtorArg.get()));
      }
      
      // When the field we are copying is an array, create index variables for 
      // each dimension of the array. We use these index variables to subscript
      // the source array, and other clients (e.g., CodeGen) will perform the
      // necessary iteration with these index variables.
      SmallVector<VarDecl /*P*/ > IndexVariables/*J*/= new SmallVector<VarDecl /*P*/ >(4, (VarDecl /*P*/ )null);
      QualType BaseType = Field.getType();
      QualType SizeType = SemaRef.Context.getSizeType().$QualType();
      boolean InitializingArray = false;
      {
        /*const*/ ConstantArrayType /*P*/ Array;
        while (((/*P*/ Array = SemaRef.Context.getAsConstantArrayType(new QualType(BaseType))) != null)) {
          InitializingArray = true;
          // Create the iteration variable for this array index.
          IdentifierInfo /*P*/ IterationVarName = null;
          {
            raw_svector_ostream OS = null;
            try {
              SmallString/*8*/ Str/*J*/= new SmallString/*8*/(8);
              OS/*J*/= new raw_svector_ostream(Str);
              OS.$out(/*KEEP_STR*/"__i").$out_uint(IndexVariables.size());
              assert Str.compare(OS.str()) == 0 : "OS must use Str " + Str.toJavaString() + " vs. " + OS.str().toJavaString();
              IterationVarName = $AddrOf(SemaRef.Context.Idents.get(Str/*PERF: OS.str()*/));
            } finally {
              if (OS != null) { OS.$destroy(); }
            }
          }
          VarDecl /*P*/ IterationVar = VarDecl.Create(SemaRef.Context, SemaRef.CurContext, new SourceLocation(Loc), new SourceLocation(Loc), 
              IterationVarName, new QualType(SizeType), 
              SemaRef.Context.getTrivialTypeSourceInfo(new QualType(SizeType), new SourceLocation(Loc)), 
              StorageClass.SC_None);
          IndexVariables.push_back(IterationVar);
          
          // Create a reference to the iteration variable.
          ActionResultTTrue<Expr /*P*/ > IterationVarRef = SemaRef.BuildDeclRefExpr(IterationVar, new QualType(SizeType), ExprValueKind.VK_LValue, new SourceLocation(Loc));
          assert (!IterationVarRef.isInvalid()) : "Reference to invented variable cannot fail!";
          IterationVarRef.$assignMove(SemaRef.DefaultLvalueConversion(IterationVarRef.get()));
          assert (!IterationVarRef.isInvalid()) : "Conversion of invented variable cannot fail!";
          
          // Subscript the array with this iteration variable.
          CtorArg.$assignMove(SemaRef.CreateBuiltinArraySubscriptExpr(CtorArg.get(), new SourceLocation(Loc), 
                  IterationVarRef.get(), 
                  new SourceLocation(Loc)));
          if (CtorArg.isInvalid()) {
            return true;
          }
          
          BaseType.$assignMove(Array.getElementType());
        }
      }
      
      // The array subscript expression is an lvalue, which is wrong for moving.
      if (Moving && InitializingArray) {
        CtorArg.$assign(CastForMoving(SemaRef, CtorArg.get()));
      }
      
      // Construct the entity that we will be initializing. For an array, this
      // will be first element in the array, which may require several levels
      // of array-subscript entities. 
      SmallVector<InitializedEntity> Entities/*J*/= new SmallVector<InitializedEntity>(4, new InitializedEntity());
      Entities.reserve(1 + IndexVariables.size());
      if ((Indirect != null)) {
        Entities.push_back(InitializedEntity.InitializeMember(Indirect));
      } else {
        Entities.push_back(InitializedEntity.InitializeMember(Field));
      }
      for (/*uint*/int I = 0, N = IndexVariables.size(); I != N; ++I)  {
        Entities.push_back(InitializedEntity.InitializeElement(SemaRef.Context, 
                0, 
                Entities.back()));
      }
      
      // Direct-initialize to use the copy constructor.
      InitializationKind InitKind = InitializationKind.CreateDirect(new SourceLocation(Loc), new SourceLocation(), new SourceLocation());
      
      Expr /*P*/ CtorArgE = CtorArg.getAs(Expr.class);
      InitSeq/*J*/= new InitializationSequence(SemaRef, Entities.back(), InitKind, 
          new MutableArrayRef<Expr /*P*/ >(CtorArgE, true));
      
      ActionResultTTrue<Expr /*P*/ > MemberInit = InitSeq.Perform(SemaRef, Entities.back(), InitKind, 
          new MutableArrayRef<Expr /*P*/ >($AddrOf(CtorArgE), 1, true));
      MemberInit.$assignMove(SemaRef.MaybeCreateExprWithCleanups(new ActionResultTTrue<Expr /*P*/ >(MemberInit)));
      if (MemberInit.isInvalid()) {
        return true;
      }
      if ((Indirect != null)) {
        assert (IndexVariables.size() == 0) : "Indirect field improperly initialized";
        CXXMemberInit.$set(/*FIXME:NEW_EXPR*//*new (SemaRef.Context)*/ new CXXCtorInitializer(SemaRef.Context, Indirect, 
            new SourceLocation(Loc), new SourceLocation(Loc), 
            MemberInit.getAs(Expr.class), 
            new SourceLocation(Loc)));
      } else {
        CXXMemberInit.$set(CXXCtorInitializer.Create(SemaRef.Context, Field, new SourceLocation(Loc), 
            new SourceLocation(Loc), MemberInit.getAs(Expr.class), 
            new SourceLocation(Loc), 
            IndexVariables.data(), 
            IndexVariables.size()));
      }
      return false;
    } finally {
      if (InitSeq != null) { InitSeq.$destroy(); }
      if (MemberLookup != null) { MemberLookup.$destroy(); }
      if (SS != null) { SS.$destroy(); }
    }
  }
  assert ((ImplicitInitKind == ImplicitInitializerKind.IIK_Default || ImplicitInitKind == ImplicitInitializerKind.IIK_Inherit)) : "Unhandled implicit init kind!";
  
  QualType FieldBaseElementType = SemaRef.Context.getBaseElementType(Field.getType());
  if (FieldBaseElementType.$arrow().isRecordType()) {
    InitializationSequence InitSeq = null;
    try {
      InitializedEntity InitEntity = (Indirect != null) ? InitializedEntity.InitializeMember(Indirect) : InitializedEntity.InitializeMember(Field);
      InitializationKind InitKind = InitializationKind.CreateDefault(new SourceLocation(Loc));
      
      InitSeq/*J*/= new InitializationSequence(SemaRef, InitEntity, InitKind, new MutableArrayRef<Expr /*P*/ >(None, true));
      ActionResultTTrue<Expr /*P*/ > MemberInit = InitSeq.Perform(SemaRef, InitEntity, InitKind, new MutableArrayRef<Expr /*P*/ >(None, true));
      
      MemberInit.$assignMove(SemaRef.MaybeCreateExprWithCleanups(new ActionResultTTrue<Expr /*P*/ >(MemberInit)));
      if (MemberInit.isInvalid()) {
        return true;
      }
      if ((Indirect != null)) {
        CXXMemberInit.$set(/*FIXME:NEW_EXPR*//*new (SemaRef.Context)*/ new CXXCtorInitializer(SemaRef.Context, 
            Indirect, new SourceLocation(Loc), 
            new SourceLocation(Loc), 
            MemberInit.get(), 
            new SourceLocation(Loc)));
      } else {
        CXXMemberInit.$set(/*FIXME:NEW_EXPR*//*new (SemaRef.Context)*/ new CXXCtorInitializer(SemaRef.Context, 
            Field, new SourceLocation(Loc), new SourceLocation(Loc), 
            MemberInit.get(), 
            new SourceLocation(Loc)));
      }
      return false;
    } finally {
      if (InitSeq != null) { InitSeq.$destroy(); }
    }
  }
  if (!Field.getParent().isUnion()) {
    if (FieldBaseElementType.$arrow().isReferenceType()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(Constructor.getLocation(), 
                            diag.err_uninitialized_member_in_ctor)), 
                        (int)(Constructor.isImplicit() ? 1 : 0)), 
                    SemaRef.Context.getTagDeclType(Constructor.getParent())), 
                0), Field.getDeclName()));
        $c$.clean($c$.track(SemaRef.Diag(Field.getLocation(), diag.note_declared_at)));
        return true;
      } finally {
        $c$.$destroy();
      }
    }
    if (FieldBaseElementType.isConstQualified()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(Constructor.getLocation(), 
                            diag.err_uninitialized_member_in_ctor)), 
                        (int)(Constructor.isImplicit() ? 1 : 0)), 
                    SemaRef.Context.getTagDeclType(Constructor.getParent())), 
                1), Field.getDeclName()));
        $c$.clean($c$.track(SemaRef.Diag(Field.getLocation(), diag.note_declared_at)));
        return true;
      } finally {
        $c$.$destroy();
      }
    }
  }
  if (SemaRef.getLangOpts().ObjCAutoRefCount
     && FieldBaseElementType.$arrow().isObjCRetainableType()
     && FieldBaseElementType.getObjCLifetime() != Qualifiers.ObjCLifetime.OCL_None
     && FieldBaseElementType.getObjCLifetime() != Qualifiers.ObjCLifetime.OCL_ExplicitNone) {
    // ARC:
    //   Default-initialize Objective-C pointers to NULL.
    CXXMemberInit.$set(/*NEW_EXPR [operator new] NM=_ZnwjRKN5clang10ASTContextEj*/
    /*new (SemaRef.Context)*/ $new_uint_ASTContext$C_uint(SemaRef.Context, (type$ptr<?> New$Mem)->{
        return new CXXCtorInitializer(SemaRef.Context, Field, 
                new SourceLocation(Loc), new SourceLocation(Loc), 
                /*NEW_EXPR [Stmt::new]*//*new (SemaRef.Context)*/ Stmt.$new_uint_ASTContext$C_uint(SemaRef.Context, (type$ptr<?> New$Mem2)->{
                    return new ImplicitValueInitExpr(Field.getType());
                 }), 
                new SourceLocation(Loc));
     }));
    return false;
  }
  
  // Nothing to initialize.
  CXXMemberInit.$set(null);
  return false;
}


/// \brief Determine whether the given type is an incomplete or zero-lenfgth
/// array type.
//<editor-fold defaultstate="collapsed" desc="isIncompleteOrZeroLengthArrayType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 3749,
 FQN="isIncompleteOrZeroLengthArrayType", NM="_ZL33isIncompleteOrZeroLengthArrayTypeRN5clang10ASTContextENS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZL33isIncompleteOrZeroLengthArrayTypeRN5clang10ASTContextENS_8QualTypeE")
//</editor-fold>
public static boolean isIncompleteOrZeroLengthArrayType(final ASTContext /*&*/ Context, QualType T) {
  if (T.$arrow().isIncompleteArrayType()) {
    return true;
  }
  {
    
    /*const*/ ConstantArrayType /*P*/ ArrayT;
    while (((/*P*/ ArrayT = Context.getAsConstantArrayType(new QualType(T))) != null)) {
      if (ArrayT.getSize().$not()) {
        return true;
      }
      
      T.$assignMove(ArrayT.getElementType());
    }
  }
  
  return false;
}

//<editor-fold defaultstate="collapsed" desc="CollectFieldInitializer">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 3763,
 FQN="CollectFieldInitializer", NM="_ZL23CollectFieldInitializerRN5clang4SemaERN12_GLOBAL__N_116BaseAndFieldInfoEPNS_9FieldDeclEPNS_17IndirectFieldDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZL23CollectFieldInitializerRN5clang4SemaERN12_GLOBAL__N_116BaseAndFieldInfoEPNS_9FieldDeclEPNS_17IndirectFieldDeclE")
//</editor-fold>
public static boolean CollectFieldInitializer(final Sema /*&*/ SemaRef, final BaseAndFieldInfo /*&*/ Info, 
                       FieldDecl /*P*/ Field) {
  return CollectFieldInitializer(SemaRef, Info, 
                       Field, 
                       (IndirectFieldDecl /*P*/ )null);
}
public static boolean CollectFieldInitializer(final Sema /*&*/ SemaRef, final BaseAndFieldInfo /*&*/ Info, 
                       FieldDecl /*P*/ Field, 
                       IndirectFieldDecl /*P*/ Indirect/*= null*/) {
  if (Field.isInvalidDecl()) {
    return false;
  }
  {
    
    // Overwhelmingly common case: we have a direct initializer for this field.
    CXXCtorInitializer /*P*/ Init = Info.AllBaseFields.lookup(Field.getCanonicalDecl());
    if ((Init != null)) {
      return Info.addFieldInitializer(Init);
    }
  }
  
  // C++11 [class.base.init]p8:
  //   if the entity is a non-static data member that has a
  //   brace-or-equal-initializer and either
  //   -- the constructor's class is a union and no other variant member of that
  //      union is designated by a mem-initializer-id or
  //   -- the constructor's class is not a union, and, if the entity is a member
  //      of an anonymous union, no other member of that union is designated by
  //      a mem-initializer-id,
  //   the entity is initialized as specified in [dcl.init].
  //
  // We also apply the same rules to handle anonymous structs within anonymous
  // unions.
  if (Info.isWithinInactiveUnionMember(Field, Indirect)) {
    return false;
  }
  if (Field.hasInClassInitializer() && !Info.isImplicitCopyOrMove()) {
    ActionResultTTrue<Expr /*P*/ > DIE = SemaRef.BuildCXXDefaultInitExpr(Info.Ctor.getLocation(), Field);
    if (DIE.isInvalid()) {
      return true;
    }
    CXXCtorInitializer /*P*/ Init;
    if ((Indirect != null)) {
      Init = /*FIXME:NEW_EXPR*//*new (SemaRef.Context)*/ new CXXCtorInitializer(SemaRef.Context, Indirect, new SourceLocation(), 
          new SourceLocation(), DIE.get(), new SourceLocation());
    } else {
      Init = /*FIXME:NEW_EXPR*//*new (SemaRef.Context)*/ new CXXCtorInitializer(SemaRef.Context, Field, new SourceLocation(), 
          new SourceLocation(), DIE.get(), new SourceLocation());
    }
    return Info.addFieldInitializer(Init);
  }
  
  // Don't initialize incomplete or zero-length arrays.
  if (isIncompleteOrZeroLengthArrayType(SemaRef.Context, Field.getType())) {
    return false;
  }
  
  // Don't try to build an implicit initializer if there were semantic
  // errors in any of the initializers (and therefore we might be
  // missing some that the user actually wrote).
  if (Info.AnyErrorsInInits) {
    return false;
  }
  
  type$ptr<CXXCtorInitializer /*P*/ > Init = create_type$null$ptr(null);
  if (BuildImplicitMemberInitializer(Info.S, Info.Ctor, Info.IIK, Field, 
      Indirect, Init)) {
    return true;
  }
  if (!(Init.$star() != null)) {
    return false;
  }
  
  return Info.addFieldInitializer(Init.$star());
}

//<editor-fold defaultstate="collapsed" desc="PopulateKeysForFields">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 4025,
 FQN="PopulateKeysForFields", NM="_ZL21PopulateKeysForFieldsPN5clang9FieldDeclERN4llvm15SmallVectorImplIPKvEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZL21PopulateKeysForFieldsPN5clang9FieldDeclERN4llvm15SmallVectorImplIPKvEE")
//</editor-fold>
public static void PopulateKeysForFields(FieldDecl /*P*/ Field, final SmallVectorImpl</*const*/Object/*void P*/ > /*&*/ IdealInits) {
  {
    /*const*/ RecordType /*P*/ RT = Field.getType().$arrow().<RecordType>getAs$RecordType();
    if ((RT != null)) {
      /*const*/ RecordDecl /*P*/ RD = RT.getDecl();
      if (RD.isAnonymousStructOrUnion()) {
        for (FieldDecl /*P*/ Field$1 : RD.fields())  {
          PopulateKeysForFields(Field$1, IdealInits);
        }
        return;
      }
    }
  }
  IdealInits.push_back(Field.getCanonicalDecl());
}

//<editor-fold defaultstate="collapsed" desc="GetKeyForBase">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 4037,
 FQN="GetKeyForBase", NM="_ZL13GetKeyForBaseRN5clang10ASTContextENS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZL13GetKeyForBaseRN5clang10ASTContextENS_8QualTypeE")
//</editor-fold>
public static /*const*/Object/*void P*/ GetKeyForBase(final ASTContext /*&*/ Context, QualType BaseType) {
  return Context.getCanonicalType(new QualType(BaseType)).getTypePtr();
}

//<editor-fold defaultstate="collapsed" desc="GetKeyForMember">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 4041,
 FQN="GetKeyForMember", NM="_ZL15GetKeyForMemberRN5clang10ASTContextEPNS_18CXXCtorInitializerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZL15GetKeyForMemberRN5clang10ASTContextEPNS_18CXXCtorInitializerE")
//</editor-fold>
public static /*const*/Object/*void P*/ GetKeyForMember(final ASTContext /*&*/ Context, 
               CXXCtorInitializer /*P*/ Member) {
  if (!Member.isAnyMemberInitializer()) {
    return GetKeyForBase(Context, new QualType(Member.getBaseClass(), 0));
  }
  
  return Member.getAnyMember().getCanonicalDecl();
}

//<editor-fold defaultstate="collapsed" desc="DiagnoseBaseOrMemInitializerOrder">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 4049,
 FQN="DiagnoseBaseOrMemInitializerOrder", NM="_ZL33DiagnoseBaseOrMemInitializerOrderRN5clang4SemaEPKNS_18CXXConstructorDeclEN4llvm8ArrayRefIPNS_18CXXCtorInitializerEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZL33DiagnoseBaseOrMemInitializerOrderRN5clang4SemaEPKNS_18CXXConstructorDeclEN4llvm8ArrayRefIPNS_18CXXCtorInitializerEEE")
//</editor-fold>
public static void DiagnoseBaseOrMemInitializerOrder(final Sema /*&*/ SemaRef, /*const*/ CXXConstructorDecl /*P*/ Constructor, 
                                 ArrayRef<CXXCtorInitializer /*P*/ > Inits) {
  if (Constructor.getDeclContext$Const().isDependentContext()) {
    return;
  }
  
  // Don't check initializers order unless the warning is enabled at the
  // location of at least one initializer. 
  boolean ShouldCheckOrder = false;
  for (/*uint*/int InitIndex = 0; InitIndex != Inits.size(); ++InitIndex) {
    CXXCtorInitializer /*P*/ Init = Inits.$at(InitIndex);
    if (!SemaRef.Diags.isIgnored(diag.warn_initializer_out_of_order, 
        Init.getSourceLocation())) {
      ShouldCheckOrder = true;
      break;
    }
  }
  if (!ShouldCheckOrder) {
    return;
  }
  
  // Build the list of bases and members in the order that they'll
  // actually be initialized.  The explicit initializers should be in
  // this same order but may be missing things.
  SmallVector</*const*/Object/*void P*/> IdealInitKeys/*J*/= new SmallVector</*const*/Object/*void P*/>(32, (/*const*/Object/*void P*/)null);
  
  /*const*/ CXXRecordDecl /*P*/ ClassDecl = Constructor.getParent$Const();
  
  // 1. Virtual bases.
  for (final /*const*/ CXXBaseSpecifier /*&*/ VBase : ClassDecl.vbases$Const())  {
    IdealInitKeys.push_back(GetKeyForBase(SemaRef.Context, VBase.getType()));
  }
  
  // 2. Non-virtual bases.
  for (final /*const*/ CXXBaseSpecifier /*&*/ Base : ClassDecl.bases$Const()) {
    if (Base.isVirtual()) {
      continue;
    }
    IdealInitKeys.push_back(GetKeyForBase(SemaRef.Context, Base.getType()));
  }
  
  // 3. Direct fields.
  for (FieldDecl /*P*/ Field : ClassDecl.fields()) {
    if (Field.isUnnamedBitfield()) {
      continue;
    }
    
    PopulateKeysForFields(Field, IdealInitKeys);
  }
  
  /*uint*/int NumIdealInits = IdealInitKeys.size();
  /*uint*/int IdealIndex = 0;
  
  CXXCtorInitializer /*P*/ PrevInit = null;
  for (/*uint*/int InitIndex = 0; InitIndex != Inits.size(); ++InitIndex) {
    CXXCtorInitializer /*P*/ Init = Inits.$at(InitIndex);
    /*const*/Object/*void P*/ InitKey = GetKeyForMember(SemaRef.Context, Init);
    
    // Scan forward to try to find this initializer in the idealized
    // initializers list.
    for (; IdealIndex != NumIdealInits; ++IdealIndex)  {
      if ($eq_ptr(InitKey, IdealInitKeys.$at(IdealIndex))) {
        break;
      }
    }
    
    // If we didn't find this initializer, it must be because we
    // scanned past it on a previous iteration.  That can only
    // happen if we're out of order;  emit a warning.
    if (IdealIndex == NumIdealInits && (PrevInit != null)) {
      Sema.SemaDiagnosticBuilder D = null;
      try {
        D = SemaRef.Diag(PrevInit.getSourceLocation(), 
            diag.warn_initializer_out_of_order);
        if (PrevInit.isAnyMemberInitializer()) {
          $out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R(D, 0), PrevInit.getAnyMember().getDeclName());
        } else {
          $out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R(D, 1), PrevInit.getTypeSourceInfo().getType());
        }
        if (Init.isAnyMemberInitializer()) {
          $out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R(D, 0), Init.getAnyMember().getDeclName());
        } else {
          $out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R(D, 1), Init.getTypeSourceInfo().getType());
        }
        
        // Move back to the initializer's location in the ideal list.
        for (IdealIndex = 0; IdealIndex != NumIdealInits; ++IdealIndex)  {
          if ($eq_ptr(InitKey, IdealInitKeys.$at(IdealIndex))) {
            break;
          }
        }
        assert ($less_uint(IdealIndex, NumIdealInits)) : "initializer not found in initializer list";
      } finally {
        if (D != null) { D.$destroy(); }
      }
    }
    
    PrevInit = Init;
  }
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckRedundantInit">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 4141,
 FQN="(anonymous namespace)::CheckRedundantInit", NM="_ZN12_GLOBAL__N_118CheckRedundantInitERN5clang4SemaEPNS0_18CXXCtorInitializerERS4_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN12_GLOBAL__N_118CheckRedundantInitERN5clang4SemaEPNS0_18CXXCtorInitializerERS4_")
//</editor-fold>
public static boolean CheckRedundantInit(final Sema /*&*/ S, 
                  CXXCtorInitializer /*P*/ Init, 
                  final type$ref<CXXCtorInitializer /*P*/ /*&*/> PrevInit) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    if (!(PrevInit.$deref() != null)) {
      PrevInit.$set(Init);
      return false;
    }
    {
      
      FieldDecl /*P*/ Field = Init.getAnyMember();
      if ((Field != null)) {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Init.getSourceLocation(), 
                    diag.err_multiple_mem_initialization)), 
                Field.getDeclName()), 
            Init.getSourceRange()));
      } else {
        /*const*/ Type /*P*/ BaseClass = Init.getBaseClass();
        assert ((BaseClass != null)) : "neither field nor base";
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Init.getSourceLocation(), 
                    diag.err_multiple_base_initialization)), 
                new QualType(BaseClass, 0)), 
            Init.getSourceRange()));
      }
    }
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(PrevInit.$deref().getSourceLocation(), diag.note_previous_initializer)), 
            0), PrevInit.$deref().getSourceRange()));
    
    return true;
  } finally {
    $c$.$destroy();
  }
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckRedundantUnionInit">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 4171,
 FQN="(anonymous namespace)::CheckRedundantUnionInit", NM="_ZN12_GLOBAL__N_123CheckRedundantUnionInitERN5clang4SemaEPNS0_18CXXCtorInitializerERN4llvm8DenseMapIPNS0_10RecordDeclESt4pairIPNS0_9NamedDeclES4_ENS5_12DenseMapInfoIS8_EENS5_6detail12DenseMapPairIS8_SC_EEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZN12_GLOBAL__N_123CheckRedundantUnionInitERN5clang4SemaEPNS0_18CXXCtorInitializerERN4llvm8DenseMapIPNS0_10RecordDeclESt4pairIPNS0_9NamedDeclES4_ENS5_12DenseMapInfoIS8_EENS5_6detail12DenseMapPairIS8_SC_EEEE")
//</editor-fold>
public static boolean CheckRedundantUnionInit(final Sema /*&*/ S, 
                       CXXCtorInitializer /*P*/ Init, 
                       final DenseMap<RecordDecl /*P*/ , std.pair<NamedDecl /*P*/ , CXXCtorInitializer /*P*/ >> /*&*/ Unions) {
  FieldDecl /*P*/ Field = Init.getAnyMember();
  RecordDecl /*P*/ Parent = Field.getParent();
  NamedDecl /*P*/ Child = Field;
  while (Parent.isAnonymousStructOrUnion() || Parent.isUnion()) {
    if (Parent.isUnion()) {
      final std.pair<NamedDecl /*P*/ , CXXCtorInitializer /*P*/ > /*&*/ En = Unions.$at_T1$C$R(Parent);
      if ((En.first != null) && En.first != Child) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Init.getSourceLocation(), 
                      diag.err_multiple_mem_union_initialization)), 
                  Field.getDeclName()), 
              Init.getSourceRange()));
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(En.second.getSourceLocation(), diag.note_previous_initializer)), 
                  0), En.second.getSourceRange()));
          return true;
        } finally {
          $c$.$destroy();
        }
      }
      if (!(En.first != null)) {
        En.first = Child;
        En.second = Init;
      }
      if (!Parent.isAnonymousStructOrUnion()) {
        return false;
      }
    }
    
    Child = Parent;
    Parent = cast_RecordDecl(Parent.getDeclContext());
  }
  
  return false;
}


/// Check for invalid uses of an abstract type in a method declaration.
//<editor-fold defaultstate="collapsed" desc="CheckAbstractClassUsage">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 4600,
 FQN="CheckAbstractClassUsage", NM="_ZL23CheckAbstractClassUsageRN12_GLOBAL__N_117AbstractUsageInfoEPN5clang13CXXMethodDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZL23CheckAbstractClassUsageRN12_GLOBAL__N_117AbstractUsageInfoEPN5clang13CXXMethodDeclE")
//</editor-fold>
public static void CheckAbstractClassUsage(final AbstractUsageInfo /*&*/ Info, 
                       CXXMethodDecl /*P*/ MD) {
  // No need to do the check on definitions, which require that
  // the return/param types be complete.
  if (MD.doesThisDeclarationHaveABody()) {
    return;
  }
  {
    
    // For safety's sake, just ignore it if we don't have type source
    // information.  This should never happen for non-implicit methods,
    // but...
    TypeSourceInfo /*P*/ TSI = MD.getTypeSourceInfo();
    if ((TSI != null)) {
      Info.CheckType(MD, TSI.getTypeLoc(), Sema.AbstractDiagSelID.AbstractNone);
    }
  }
}


/// Check for invalid uses of an abstract type within a class definition.
//<editor-fold defaultstate="collapsed" desc="CheckAbstractClassUsage">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 4615,
 FQN="CheckAbstractClassUsage", NM="_ZL23CheckAbstractClassUsageRN12_GLOBAL__N_117AbstractUsageInfoEPN5clang13CXXRecordDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZL23CheckAbstractClassUsageRN12_GLOBAL__N_117AbstractUsageInfoEPN5clang13CXXRecordDeclE")
//</editor-fold>
public static void CheckAbstractClassUsage(final AbstractUsageInfo /*&*/ Info, 
                       CXXRecordDecl /*P*/ RD) {
  for (Decl /*P*/ D : RD.decls()) {
    if (D.isImplicit()) {
      continue;
    }
    
    // Methods and method templates.
    if (isa_CXXMethodDecl(D)) {
      CheckAbstractClassUsage(Info, cast_CXXMethodDecl(D));
    } else if (isa_FunctionTemplateDecl(D)) {
      FunctionDecl /*P*/ FD = cast_FunctionTemplateDecl(D).getTemplatedDecl();
      CheckAbstractClassUsage(Info, cast_CXXMethodDecl(FD));
      // Fields and static variables.
    } else if (isa_FieldDecl(D)) {
      FieldDecl /*P*/ FD = cast_FieldDecl(D);
      {
        TypeSourceInfo /*P*/ TSI = FD.getTypeSourceInfo();
        if ((TSI != null)) {
          Info.CheckType(FD, TSI.getTypeLoc(), Sema.AbstractDiagSelID.AbstractFieldType);
        }
      }
    } else if (isa_VarDecl(D)) {
      VarDecl /*P*/ VD = cast_VarDecl(D);
      {
        TypeSourceInfo /*P*/ TSI = VD.getTypeSourceInfo();
        if ((TSI != null)) {
          Info.CheckType(VD, TSI.getTypeLoc(), Sema.AbstractDiagSelID.AbstractVariableType);
        }
      }
      // Nested classes and class templates.
    } else if (isa_CXXRecordDecl(D)) {
      CheckAbstractClassUsage(Info, cast_CXXRecordDecl(D));
    } else if (isa_ClassTemplateDecl(D)) {
      CheckAbstractClassUsage(Info, 
          cast_ClassTemplateDecl(D).getTemplatedDecl());
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="ReferenceDllExportedMethods">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 4647,
 FQN="ReferenceDllExportedMethods", NM="_ZL27ReferenceDllExportedMethodsRN5clang4SemaEPNS_13CXXRecordDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZL27ReferenceDllExportedMethodsRN5clang4SemaEPNS_13CXXRecordDeclE")
//</editor-fold>
public static void ReferenceDllExportedMethods(final Sema /*&*/ S, CXXRecordDecl /*P*/ Class) {
  Attr /*P*/ ClassAttr = getDLLAttr(Class);
  if (!(ClassAttr != null)) {
    return;
  }
  assert (ClassAttr.getKind() == attr.Kind.DLLExport);
  
  TemplateSpecializationKind TSK = Class.getTemplateSpecializationKind();
  if (TSK == TemplateSpecializationKind.TSK_ExplicitInstantiationDeclaration) {
    // Don't go any further if this is just an explicit instantiation
    // declaration.
    return;
  }
  
  for (Decl /*P*/ Member : Class.decls()) {
    CXXMethodDecl /*P*/ MD = dyn_cast_CXXMethodDecl(Member);
    if (!(MD != null)) {
      continue;
    }
    if ((Member.getAttr(DLLExportAttr.class) != null)) {
      if (MD.isUserProvided()) {
        // Instantiate non-default class member functions ...
        
        // .. except for certain kinds of template specializations.
        if (TSK == TemplateSpecializationKind.TSK_ImplicitInstantiation && !ClassAttr.isInherited()) {
          continue;
        }
        
        S.MarkFunctionReferenced(Class.getLocation(), MD);
        // The function will be passed to the consumer when its definition is
        // encountered.
      } else if (!MD.isTrivial() || MD.isExplicitlyDefaulted()
         || MD.isCopyAssignmentOperator()
         || MD.isMoveAssignmentOperator()) {
        // Synthesize and instantiate non-trivial implicit methods, explicitly
        // defaulted methods, and the copy and move assignment operators. The
        // latter are exported even if they are trivial, because the address of
        // an operator can be taken and should compare equal accross libraries.
        DiagnosticErrorTrap Trap/*J*/= new DiagnosticErrorTrap(S.Diags);
        S.MarkFunctionReferenced(Class.getLocation(), MD);
        if (Trap.hasErrorOccurred()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(ClassAttr.getLocation(), diag.note_due_to_dllexported_class)), 
                    Class.getName()), !S.getLangOpts().CPlusPlus11));
            break;
          } finally {
            $c$.$destroy();
          }
        }
        
        // There is no later point when we will see the definition of this
        // function, so pass it to the consumer now.
        S.Consumer.HandleTopLevelDecl(new DeclGroupRef(MD));
      }
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="DefineImplicitSpecialMember">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 4871,
 FQN="DefineImplicitSpecialMember", NM="_ZL27DefineImplicitSpecialMemberRN5clang4SemaEPNS_13CXXMethodDeclENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZL27DefineImplicitSpecialMemberRN5clang4SemaEPNS_13CXXMethodDeclENS_14SourceLocationE")
//</editor-fold>
public static void DefineImplicitSpecialMember(final Sema /*&*/ S, CXXMethodDecl /*P*/ MD, 
                           SourceLocation DefaultLoc) {
  switch (S.getSpecialMember(MD)) {
   case CXXDefaultConstructor:
    S.DefineImplicitDefaultConstructor(new SourceLocation(DefaultLoc), 
        cast_CXXConstructorDecl(MD));
    break;
   case CXXCopyConstructor:
    S.DefineImplicitCopyConstructor(new SourceLocation(DefaultLoc), cast_CXXConstructorDecl(MD));
    break;
   case CXXCopyAssignment:
    S.DefineImplicitCopyAssignment(new SourceLocation(DefaultLoc), MD);
    break;
   case CXXDestructor:
    S.DefineImplicitDestructor(new SourceLocation(DefaultLoc), cast_CXXDestructorDecl(MD));
    break;
   case CXXMoveConstructor:
    S.DefineImplicitMoveConstructor(new SourceLocation(DefaultLoc), cast_CXXConstructorDecl(MD));
    break;
   case CXXMoveAssignment:
    S.DefineImplicitMoveAssignment(new SourceLocation(DefaultLoc), MD);
    break;
   case CXXInvalid:
    throw new llvm_unreachable("Invalid special member.");
  }
}


/// Look up the special member function that would be called by a special
/// member function for a subobject of class type.
///
/// \param Class The class type of the subobject.
/// \param CSM The kind of special member function.
/// \param FieldQuals If the subobject is a field, its cv-qualifiers.
/// \param ConstRHS True if this is a copy operation with a const object
///        on its RHS, that is, if the argument to the outer special member
///        function is 'const' and this is not a field marked 'mutable'.
//<editor-fold defaultstate="collapsed" desc="lookupCallFromSpecialMember">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 5053,
 FQN="lookupCallFromSpecialMember", NM="_ZL27lookupCallFromSpecialMemberRN5clang4SemaEPNS_13CXXRecordDeclENS0_16CXXSpecialMemberEjb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZL27lookupCallFromSpecialMemberRN5clang4SemaEPNS_13CXXRecordDeclENS0_16CXXSpecialMemberEjb")
//</editor-fold>
public static Sema.SpecialMemberOverloadResult /*P*/ lookupCallFromSpecialMember(final Sema /*&*/ S, CXXRecordDecl /*P*/ Class, Sema.CXXSpecialMember CSM, 
                           /*uint*/int FieldQuals, boolean ConstRHS) {
  /*uint*/int LHSQuals = 0;
  if (CSM == Sema.CXXSpecialMember.CXXCopyAssignment || CSM == Sema.CXXSpecialMember.CXXMoveAssignment) {
    LHSQuals = FieldQuals;
  }
  
  /*uint*/int RHSQuals = FieldQuals;
  if (CSM == Sema.CXXSpecialMember.CXXDefaultConstructor || CSM == Sema.CXXSpecialMember.CXXDestructor) {
    RHSQuals = 0;
  } else if (ConstRHS) {
    RHSQuals |= Qualifiers.TQ.Const;
  }
  
  return S.LookupSpecialMember(Class, CSM, 
      ((RHSQuals & Qualifiers.TQ.Const) != 0), 
      ((RHSQuals & Qualifiers.TQ.Volatile) != 0), 
      false, 
      ((LHSQuals & Qualifiers.TQ.Const) != 0), 
      ((LHSQuals & Qualifiers.TQ.Volatile) != 0));
}


/// Is the special member function which would be selected to perform the
/// specified operation on the specified class type a constexpr constructor?
//<editor-fold defaultstate="collapsed" desc="specialMemberIsConstexpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 5157,
 FQN="specialMemberIsConstexpr", NM="_ZL24specialMemberIsConstexprRN5clang4SemaEPNS_13CXXRecordDeclENS0_16CXXSpecialMemberEjbPNS_18CXXConstructorDeclEPNS0_24InheritedConstructorInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZL24specialMemberIsConstexprRN5clang4SemaEPNS_13CXXRecordDeclENS0_16CXXSpecialMemberEjbPNS_18CXXConstructorDeclEPNS0_24InheritedConstructorInfoE")
//</editor-fold>
public static boolean specialMemberIsConstexpr(final Sema /*&*/ S, CXXRecordDecl /*P*/ ClassDecl, 
                        Sema.CXXSpecialMember CSM, /*uint*/int Quals, 
                        boolean ConstRHS) {
  return specialMemberIsConstexpr(S, ClassDecl, 
                        CSM, Quals, 
                        ConstRHS, 
                        (CXXConstructorDecl /*P*/ )null, 
                        (Sema.InheritedConstructorInfo /*P*/ )null);
}
public static boolean specialMemberIsConstexpr(final Sema /*&*/ S, CXXRecordDecl /*P*/ ClassDecl, 
                        Sema.CXXSpecialMember CSM, /*uint*/int Quals, 
                        boolean ConstRHS, 
                        CXXConstructorDecl /*P*/ InheritedCtor/*= null*/) {
  return specialMemberIsConstexpr(S, ClassDecl, 
                        CSM, Quals, 
                        ConstRHS, 
                        InheritedCtor, 
                        (Sema.InheritedConstructorInfo /*P*/ )null);
}
public static boolean specialMemberIsConstexpr(final Sema /*&*/ S, CXXRecordDecl /*P*/ ClassDecl, 
                        Sema.CXXSpecialMember CSM, /*uint*/int Quals, 
                        boolean ConstRHS, 
                        CXXConstructorDecl /*P*/ InheritedCtor/*= null*/, 
                        Sema.InheritedConstructorInfo /*P*/ Inherited/*= null*/) {
  // If we're inheriting a constructor, see if we need to call it for this base
  // class.
  if ((InheritedCtor != null)) {
    assert (CSM == Sema.CXXSpecialMember.CXXDefaultConstructor);
    CXXConstructorDecl /*P*/ BaseCtor = Inherited.findConstructorForBase(ClassDecl, InheritedCtor).first;
    if ((BaseCtor != null)) {
      return BaseCtor.isConstexpr();
    }
  }
  if (CSM == Sema.CXXSpecialMember.CXXDefaultConstructor) {
    return ClassDecl.hasConstexprDefaultConstructor();
  }
  
  Sema.SpecialMemberOverloadResult /*P*/ SMOR = lookupCallFromSpecialMember(S, ClassDecl, CSM, Quals, ConstRHS);
  if (!(SMOR != null) || !(SMOR.getMethod() != null)) {
    // A constructor we wouldn't select can't be "involved in initializing"
    // anything.
    return true;
  }
  return SMOR.getMethod().isConstexpr();
}


/// Determine whether the specified special member function would be constexpr
/// if it were implicitly defined.
//<editor-fold defaultstate="collapsed" desc="defaultedSpecialMemberIsConstexpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 5187,
 FQN="defaultedSpecialMemberIsConstexpr", NM="_ZL33defaultedSpecialMemberIsConstexprRN5clang4SemaEPNS_13CXXRecordDeclENS0_16CXXSpecialMemberEbPNS_18CXXConstructorDeclEPNS0_24InheritedConstructorInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZL33defaultedSpecialMemberIsConstexprRN5clang4SemaEPNS_13CXXRecordDeclENS0_16CXXSpecialMemberEbPNS_18CXXConstructorDeclEPNS0_24InheritedConstructorInfoE")
//</editor-fold>
public static boolean defaultedSpecialMemberIsConstexpr(final Sema /*&*/ S, CXXRecordDecl /*P*/ ClassDecl, Sema.CXXSpecialMember CSM, 
                                 boolean ConstArg) {
  return defaultedSpecialMemberIsConstexpr(S, ClassDecl, CSM, 
                                 ConstArg, (CXXConstructorDecl /*P*/ )null, 
                                 (Sema.InheritedConstructorInfo /*P*/ )null);
}
public static boolean defaultedSpecialMemberIsConstexpr(final Sema /*&*/ S, CXXRecordDecl /*P*/ ClassDecl, Sema.CXXSpecialMember CSM, 
                                 boolean ConstArg, CXXConstructorDecl /*P*/ InheritedCtor/*= null*/) {
  return defaultedSpecialMemberIsConstexpr(S, ClassDecl, CSM, 
                                 ConstArg, InheritedCtor, 
                                 (Sema.InheritedConstructorInfo /*P*/ )null);
}
public static boolean defaultedSpecialMemberIsConstexpr(final Sema /*&*/ S, CXXRecordDecl /*P*/ ClassDecl, Sema.CXXSpecialMember CSM, 
                                 boolean ConstArg, CXXConstructorDecl /*P*/ InheritedCtor/*= null*/, 
                                 Sema.InheritedConstructorInfo /*P*/ Inherited/*= null*/) {
  if (!S.getLangOpts().CPlusPlus11) {
    return false;
  }
  
  // C++11 [dcl.constexpr]p4:
  // In the definition of a constexpr constructor [...]
  boolean Ctor = true;
  switch (CSM) {
   case CXXDefaultConstructor:
    if ((Inherited != null)) {
      break;
    }
    // Since default constructor lookup is essentially trivial (and cannot
    // involve, for instance, template instantiation), we compute whether a
    // defaulted default constructor is constexpr directly within CXXRecordDecl.
    //
    // This is important for performance; we need to know whether the default
    // constructor is constexpr to determine whether the type is a literal type.
    return ClassDecl.defaultedDefaultConstructorIsConstexpr();
   case CXXCopyConstructor:
   case CXXMoveConstructor:
    // For copy or move constructors, we need to perform overload resolution.
    break;
   case CXXCopyAssignment:
   case CXXMoveAssignment:
    if (!S.getLangOpts().CPlusPlus14) {
      return false;
    }
    // In C++1y, we need to perform overload resolution.
    Ctor = false;
    break;
   case CXXDestructor:
   case CXXInvalid:
    return false;
  }
  
  //   -- if the class is a non-empty union, or for each non-empty anonymous
  //      union member of a non-union class, exactly one non-static data member
  //      shall be initialized; [DR1359]
  //
  // If we squint, this is guaranteed, since exactly one non-static data member
  // will be initialized (if the constructor isn't deleted), we just don't know
  // which one.
  if (Ctor && ClassDecl.isUnion()) {
    return CSM == Sema.CXXSpecialMember.CXXDefaultConstructor ? ClassDecl.hasInClassInitializer()
       || !ClassDecl.hasVariantMembers() : true;
  }
  
  //   -- the class shall not have any virtual base classes;
  if (Ctor && (ClassDecl.getNumVBases() != 0)) {
    return false;
  }
  
  // C++1y [class.copy]p26:
  //   -- [the class] is a literal type, and
  if (!Ctor && !ClassDecl.isLiteral()) {
    return false;
  }
  
  //   -- every constructor involved in initializing [...] base class
  //      sub-objects shall be a constexpr constructor;
  //   -- the assignment operator selected to copy/move each direct base
  //      class is a constexpr function, and
  for (final /*const*/ CXXBaseSpecifier /*&*/ B : ClassDecl.bases()) {
    /*const*/ RecordType /*P*/ BaseType = B.getType().$arrow().<RecordType>getAs$RecordType();
    if (!(BaseType != null)) {
      continue;
    }
    
    CXXRecordDecl /*P*/ BaseClassDecl = cast_CXXRecordDecl(BaseType.getDecl());
    if (!specialMemberIsConstexpr(S, BaseClassDecl, CSM, 0, ConstArg, 
        InheritedCtor, Inherited)) {
      return false;
    }
  }
  
  //   -- every constructor involved in initializing non-static data members
  //      [...] shall be a constexpr constructor;
  //   -- every non-static data member and base class sub-object shall be
  //      initialized
  //   -- for each non-static data member of X that is of class type (or array
  //      thereof), the assignment operator selected to copy/move that member is
  //      a constexpr function
  for (/*const*/ FieldDecl /*P*/ F : ClassDecl.fields()) {
    if (F.isInvalidDecl()) {
      continue;
    }
    if (CSM == Sema.CXXSpecialMember.CXXDefaultConstructor && F.hasInClassInitializer()) {
      continue;
    }
    QualType BaseType = S.Context.getBaseElementType(F.getType());
    {
      /*const*/ RecordType /*P*/ RecordTy = BaseType.$arrow().<RecordType>getAs$RecordType();
      if ((RecordTy != null)) {
        CXXRecordDecl /*P*/ FieldRecDecl = cast_CXXRecordDecl(RecordTy.getDecl());
        if (!specialMemberIsConstexpr(S, FieldRecDecl, CSM, 
            BaseType.getCVRQualifiers(), 
            ConstArg && !F.isMutable())) {
          return false;
        }
      } else if (CSM == Sema.CXXSpecialMember.CXXDefaultConstructor) {
        return false;
      }
    }
  }
  
  // All OK, it's constexpr!
  return true;
}

//<editor-fold defaultstate="collapsed" desc="computeImplicitExceptionSpec">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 5291,
 FQN="computeImplicitExceptionSpec", NM="_ZL28computeImplicitExceptionSpecRN5clang4SemaENS_14SourceLocationEPNS_13CXXMethodDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZL28computeImplicitExceptionSpecRN5clang4SemaENS_14SourceLocationEPNS_13CXXMethodDeclE")
//</editor-fold>
public static Sema.ImplicitExceptionSpecification computeImplicitExceptionSpec(final Sema /*&*/ S, SourceLocation Loc, CXXMethodDecl /*P*/ MD) {
  switch (S.getSpecialMember(MD)) {
   case CXXDefaultConstructor:
    return S.ComputeDefaultedDefaultCtorExceptionSpec(new SourceLocation(Loc), MD);
   case CXXCopyConstructor:
    return S.ComputeDefaultedCopyCtorExceptionSpec(MD);
   case CXXCopyAssignment:
    return S.ComputeDefaultedCopyAssignmentExceptionSpec(MD);
   case CXXMoveConstructor:
    return S.ComputeDefaultedMoveCtorExceptionSpec(MD);
   case CXXMoveAssignment:
    return S.ComputeDefaultedMoveAssignmentExceptionSpec(MD);
   case CXXDestructor:
    return S.ComputeDefaultedDtorExceptionSpec(MD);
   case CXXInvalid:
    break;
  }
  assert (cast_CXXConstructorDecl(MD).getInheritedConstructor().$bool()) : "only special members have implicit exception specs";
  return S.ComputeInheritingCtorExceptionSpec(new SourceLocation(Loc), 
      cast_CXXConstructorDecl(MD));
}

//<editor-fold defaultstate="collapsed" desc="getImplicitMethodEPI">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 5315,
 FQN="getImplicitMethodEPI", NM="_ZL20getImplicitMethodEPIRN5clang4SemaEPNS_13CXXMethodDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZL20getImplicitMethodEPIRN5clang4SemaEPNS_13CXXMethodDeclE")
//</editor-fold>
public static FunctionProtoType.ExtProtoInfo getImplicitMethodEPI(final Sema /*&*/ S, 
                    CXXMethodDecl /*P*/ MD) {
  FunctionProtoType.ExtProtoInfo EPI/*J*/= new FunctionProtoType.ExtProtoInfo();
  
  // Build an exception specification pointing back at this member.
  EPI.ExceptionSpec.Type = ExceptionSpecificationType.EST_Unevaluated;
  EPI.ExceptionSpec.SourceDecl = MD;
  
  // Set the calling convention to the default for C++ instance methods.
  EPI.ExtInfo.$assignMove(EPI.ExtInfo.withCallingConv(S.Context.getDefaultCallingConvention(/*IsVariadic=*/ false, 
              /*IsCXXMethod=*/ true)));
  return EPI;
}


/// Perform lookup for a special member of the specified kind, and determine
/// whether it is trivial. If the triviality can be determined without the
/// lookup, skip it. This is intended for use when determining whether a
/// special member of a containing object is trivial, and thus does not ever
/// perform overload resolution for default constructors.
///
/// If \p Selected is not \c NULL, \c *Selected will be filled in with the
/// member that was most likely to be intended to be trivial, if any.
//<editor-fold defaultstate="collapsed" desc="findTrivialSpecialMember">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 6038,
 FQN="findTrivialSpecialMember", NM="_ZL24findTrivialSpecialMemberRN5clang4SemaEPNS_13CXXRecordDeclENS0_16CXXSpecialMemberEjbPPNS_13CXXMethodDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZL24findTrivialSpecialMemberRN5clang4SemaEPNS_13CXXRecordDeclENS0_16CXXSpecialMemberEjbPPNS_13CXXMethodDeclE")
//</editor-fold>
public static boolean findTrivialSpecialMember(final Sema /*&*/ S, CXXRecordDecl /*P*/ RD, 
                        Sema.CXXSpecialMember CSM, /*uint*/int Quals, 
                        boolean ConstRHS, type$ptr<CXXMethodDecl/*P*/>/*P*/ Selected) {
  if ((Selected != null)) {
    Selected.$set(null);
  }
  switch (CSM) {
   case CXXInvalid:
    throw new llvm_unreachable("not a special member");
   case CXXDefaultConstructor:
    // C++11 [class.ctor]p5:
    //   A default constructor is trivial if:
    //    - all the [direct subobjects] have trivial default constructors
    //
    // Note, no overload resolution is performed in this case.
    if (RD.hasTrivialDefaultConstructor()) {
      return true;
    }
    if ((Selected != null)) {
      // If there's a default constructor which could have been trivial, dig it
      // out. Otherwise, if there's any user-provided default constructor, point
      // to that as an example of why there's not a trivial one.
      CXXConstructorDecl /*P*/ DefCtor = null;
      if (RD.needsImplicitDefaultConstructor()) {
        S.DeclareImplicitDefaultConstructor(RD);
      }
      for (CXXConstructorDecl /*P*/ CI : RD.ctors()) {
        if (!CI.isDefaultConstructor()) {
          continue;
        }
        DefCtor = CI;
        if (!DefCtor.isUserProvided()) {
          break;
        }
      }
      
      Selected.$set(DefCtor);
    }
    
    return false;
   case CXXDestructor:
    // C++11 [class.dtor]p5:
    //   A destructor is trivial if:
    //    - all the direct [subobjects] have trivial destructors
    if (RD.hasTrivialDestructor()) {
      return true;
    }
    if ((Selected != null)) {
      if (RD.needsImplicitDestructor()) {
        S.DeclareImplicitDestructor(RD);
      }
      Selected.$set(RD.getDestructor());
    }
    
    return false;
   case CXXCopyConstructor:
    // C++11 [class.copy]p12:
    //   A copy constructor is trivial if:
    //    - the constructor selected to copy each direct [subobject] is trivial
    if (RD.hasTrivialCopyConstructor()) {
      if (Quals == Qualifiers.TQ.Const) {
        // We must either select the trivial copy constructor or reach an
        // ambiguity; no need to actually perform overload resolution.
        return true;
      }
    } else if (!(Selected != null)) {
      return false;
    }
    // In C++98, we are not supposed to perform overload resolution here, but we
    // treat that as a language defect, as suggested on cxx-abi-dev, to treat
    // cases like B as having a non-trivial copy constructor:
    //   struct A { template<typename T> A(T&); };
    //   struct B { mutable A a; };
    //goto NeedOverloadResolution;
   case CXXCopyAssignment:
     if (CSM == Sema.CXXSpecialMember.CXXCopyAssignment) {
      // C++11 [class.copy]p25:
      //   A copy assignment operator is trivial if:
      //    - the assignment operator selected to copy each direct [subobject] is
      //      trivial
      if (RD.hasTrivialCopyAssignment()) {
        if (Quals == Qualifiers.TQ.Const) {
          return true;
        }
      } else if (!(Selected != null)) {
        return false;
      }
     }
    // In C++98, we are not supposed to perform overload resolution here, but we
    // treat that as a language defect.
    //goto NeedOverloadResolution;
   case CXXMoveConstructor:
   case CXXMoveAssignment:
   //NeedOverloadResolution:
    Sema.SpecialMemberOverloadResult /*P*/ SMOR = lookupCallFromSpecialMember(S, RD, CSM, Quals, ConstRHS);
    
    // The standard doesn't describe how to behave if the lookup is ambiguous.
    // We treat it as not making the member non-trivial, just like the standard
    // mandates for the default constructor. This should rarely matter, because
    // the member will also be deleted.
    if (SMOR.getKind() == Sema.SpecialMemberOverloadResult.Kind.Ambiguous) {
      return true;
    }
    if (!(SMOR.getMethod() != null)) {
      assert (SMOR.getKind() == Sema.SpecialMemberOverloadResult.Kind.NoMemberOrDeleted);
      return false;
    }
    
    // We deliberately don't check if we found a deleted special member. We're
    // not supposed to!
    if ((Selected != null)) {
      Selected.$set(SMOR.getMethod());
    }
    return SMOR.getMethod().isTrivial();
  }
  throw new llvm_unreachable("unknown special method kind");
}

//<editor-fold defaultstate="collapsed" desc="findUserDeclaredCtor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 6155,
 FQN="findUserDeclaredCtor", NM="_ZL20findUserDeclaredCtorPN5clang13CXXRecordDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZL20findUserDeclaredCtorPN5clang13CXXRecordDeclE")
//</editor-fold>
public static CXXConstructorDecl /*P*/ findUserDeclaredCtor(CXXRecordDecl /*P*/ RD) {
  for (CXXConstructorDecl /*P*/ CI : RD.ctors())  {
    if (!CI.isImplicit()) {
      return CI;
    }
  }
  
  // Look for constructor templates.
  /*typedef CXXRecordDecl::specific_decl_iterator<FunctionTemplateDecl> tmpl_iter*/
//  final class tmpl_iter extends CXXRecordDecl.specific_decl_iterator<FunctionTemplateDecl>{ };
  for (CXXRecordDecl.specific_decl_iterator<FunctionTemplateDecl> TI/*J*/= new CXXRecordDecl.specific_decl_iterator<FunctionTemplateDecl>(FunctionTemplateDecl.class, RD.decls_begin()), 
          TE/*J*/= new CXXRecordDecl.specific_decl_iterator<FunctionTemplateDecl>(FunctionTemplateDecl.class, RD.decls_end()); $noteq_specific_decl_iterator$SpecificDecl$C(TI, TE); TI.$preInc()) {
    {
      CXXConstructorDecl /*P*/ CD = dyn_cast_CXXConstructorDecl(TI.$arrow().getTemplatedDecl());
      if ((CD != null)) {
        return CD;
      }
    }
  }
  
  return null;
}


/// Check whether the special member selected for a given type would be trivial.
//<editor-fold defaultstate="collapsed" desc="checkTrivialSubobjectCall">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 6183,
 FQN="checkTrivialSubobjectCall", NM="_ZL25checkTrivialSubobjectCallRN5clang4SemaENS_14SourceLocationENS_8QualTypeEbNS0_16CXXSpecialMemberE20TrivialSubobjectKindb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZL25checkTrivialSubobjectCallRN5clang4SemaENS_14SourceLocationENS_8QualTypeEbNS0_16CXXSpecialMemberE20TrivialSubobjectKindb")
//</editor-fold>
public static boolean checkTrivialSubobjectCall(final Sema /*&*/ S, SourceLocation SubobjLoc, 
                         QualType SubType, boolean ConstRHS, 
                         Sema.CXXSpecialMember CSM, 
                         TrivialSubobjectKind Kind, 
                         boolean Diagnose) {
  CXXRecordDecl /*P*/ SubRD = SubType.$arrow().getAsCXXRecordDecl();
  if (!(SubRD != null)) {
    return true;
  }
  
  type$ptr<CXXMethodDecl /*P*/> Selected = create_type$null$ptr();
  if (findTrivialSpecialMember(S, SubRD, CSM, SubType.getCVRQualifiers(), 
      ConstRHS, Diagnose ? $AddrOf(Selected) : (type$ptr<CXXMethodDecl/*P*/>/*P*/ )null)) {
    return true;
  }
  if (Diagnose) {
    if (ConstRHS) {
      SubType.addConst();
    }
    if (!(Selected.$star() != null) && CSM == Sema.CXXSpecialMember.CXXDefaultConstructor) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(SubobjLoc), diag.note_nontrivial_no_def_ctor)), 
                Kind), SubType.getUnqualifiedType()));
        {
          CXXConstructorDecl /*P*/ CD = findUserDeclaredCtor(SubRD);
          if ((CD != null)) {
            $c$.clean($c$.track(S.Diag(CD.getLocation(), diag.note_user_declared_ctor)));
          }
        }
      } finally {
        $c$.$destroy();
      }
    } else if (!(Selected.$star() != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(SubobjLoc), diag.note_nontrivial_no_copy)), 
                        Kind), SubType.getUnqualifiedType()), CSM), SubType));
      } finally {
        $c$.$destroy();
      }
    } else if (Selected.$star().isUserProvided()) {
      if (Kind == TrivialSubobjectKind.TSK_CompleteObject) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Selected.$star().getLocation(), diag.note_nontrivial_user_provided)), 
                      Kind), SubType.getUnqualifiedType()), CSM));
        } finally {
          $c$.$destroy();
        }
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(SubobjLoc), diag.note_nontrivial_user_provided)), 
                      Kind), SubType.getUnqualifiedType()), CSM));
          $c$.clean($c$.track(S.Diag(Selected.$star().getLocation(), diag.note_declared_at)));
        } finally {
          $c$.$destroy();
        }
      }
    } else {
      if (Kind != TrivialSubobjectKind.TSK_CompleteObject) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(SubobjLoc), diag.note_nontrivial_subobject)), 
                      Kind), SubType.getUnqualifiedType()), CSM));
        } finally {
          $c$.$destroy();
        }
      }
      
      // Explain why the defaulted or deleted special member isn't trivial.
      S.SpecialMemberIsTrivial(Selected.$star(), CSM, Diagnose);
    }
  }
  
  return false;
}


/// Check whether the members of a class type allow a special member to be
/// trivial.
//<editor-fold defaultstate="collapsed" desc="checkTrivialClassMembers">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 6233,
 FQN="checkTrivialClassMembers", NM="_ZL24checkTrivialClassMembersRN5clang4SemaEPNS_13CXXRecordDeclENS0_16CXXSpecialMemberEbb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZL24checkTrivialClassMembersRN5clang4SemaEPNS_13CXXRecordDeclENS0_16CXXSpecialMemberEbb")
//</editor-fold>
public static boolean checkTrivialClassMembers(final Sema /*&*/ S, CXXRecordDecl /*P*/ RD, 
                        Sema.CXXSpecialMember CSM, 
                        boolean ConstArg, boolean Diagnose) {
  for (/*const*/ FieldDecl /*P*/ FI : RD.fields()) {
    if (FI.isInvalidDecl() || FI.isUnnamedBitfield()) {
      continue;
    }
    
    QualType FieldType = S.Context.getBaseElementType(FI.getType());
    
    // Pretend anonymous struct or union members are members of this class.
    if (FI.isAnonymousStructOrUnion()) {
      if (!checkTrivialClassMembers(S, FieldType.$arrow().getAsCXXRecordDecl(), 
          CSM, ConstArg, Diagnose)) {
        return false;
      }
      continue;
    }
    
    // C++11 [class.ctor]p5:
    //   A default constructor is trivial if [...]
    //    -- no non-static data member of its class has a
    //       brace-or-equal-initializer
    if (CSM == Sema.CXXSpecialMember.CXXDefaultConstructor && FI.hasInClassInitializer()) {
      if (Diagnose) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(FI.getLocation(), diag.note_nontrivial_in_class_init)), FI));
        } finally {
          $c$.$destroy();
        }
      }
      return false;
    }
    
    // Objective C ARC 4.3.5:
    //   [...] nontrivally ownership-qualified types are [...] not trivially
    //   default constructible, copy constructible, move constructible, copy
    //   assignable, move assignable, or destructible [...]
    if (S.getLangOpts().ObjCAutoRefCount
       && FieldType.hasNonTrivialObjCLifetime()) {
      if (Diagnose) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(FI.getLocation(), diag.note_nontrivial_objc_ownership)), 
                  RD), FieldType.getObjCLifetime()));
        } finally {
          $c$.$destroy();
        }
      }
      return false;
    }
    
    boolean ConstRHS = ConstArg && !FI.isMutable();
    if (!checkTrivialSubobjectCall(S, FI.getLocation(), new QualType(FieldType), ConstRHS, 
        CSM, TrivialSubobjectKind.TSK_Field, Diagnose)) {
      return false;
    }
  }
  
  return true;
}

// end anonymous namespace

/// \brief Add the most overriden methods from MD to Methods
//<editor-fold defaultstate="collapsed" desc="AddMostOverridenMethods">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 6502,
 FQN="AddMostOverridenMethods", NM="_ZL23AddMostOverridenMethodsPKN5clang13CXXMethodDeclERN4llvm15SmallPtrSetImplIS2_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZL23AddMostOverridenMethodsPKN5clang13CXXMethodDeclERN4llvm15SmallPtrSetImplIS2_EE")
//</editor-fold>
public static void AddMostOverridenMethods(/*const*/ CXXMethodDecl /*P*/ MD, 
                       final SmallPtrSetImpl</*const*/ CXXMethodDecl /*P*/ > /*&*/ Methods) {
  if (MD.size_overridden_methods() == 0) {
    Methods.insert(MD.getCanonicalDecl$Const());
  }
  for (type$ptr<CXXMethodDecl>/*method_iterator*/ I = $tryClone(MD.begin_overridden_methods()), 
      /*P*/ /*const*/ /*P*/ E = $tryClone(MD.end_overridden_methods());
       $noteq_ptr(I, E); I.$preInc())  {
    AddMostOverridenMethods(I.$star(), Methods);
  }
}

//<editor-fold defaultstate="collapsed" desc="extendLeft">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 7064,
 FQN="extendLeft", NM="_ZL10extendLeftRN5clang11SourceRangeES0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZL10extendLeftRN5clang11SourceRangeES0_")
//</editor-fold>
public static void extendLeft(final SourceRange /*&*/ R, SourceRange Before) {
  if (Before.isInvalid()) {
    return;
  }
  R.setBegin(Before.getBegin());
  if (R.getEnd().isInvalid()) {
    R.setEnd(Before.getEnd());
  }
}

//<editor-fold defaultstate="collapsed" desc="extendRight">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 7072,
 FQN="extendRight", NM="_ZL11extendRightRN5clang11SourceRangeES0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZL11extendRightRN5clang11SourceRangeES0_")
//</editor-fold>
public static void extendRight(final SourceRange /*&*/ R, SourceRange After) {
  if (After.isInvalid()) {
    return;
  }
  if (R.getBegin().isInvalid()) {
    R.setBegin(After.getBegin());
  }
  R.setEnd(After.getEnd());
}


//===----------------------------------------------------------------------===//
// Namespace Handling
//===----------------------------------------------------------------------===//

/// \brief Diagnose a mismatch in 'inline' qualifiers when a namespace is
/// reopened.
//<editor-fold defaultstate="collapsed" desc="DiagnoseNamespaceInlineMismatch">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 7291,
 FQN="DiagnoseNamespaceInlineMismatch", NM="_ZL31DiagnoseNamespaceInlineMismatchRN5clang4SemaENS_14SourceLocationES2_PNS_14IdentifierInfoEPbPNS_13NamespaceDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZL31DiagnoseNamespaceInlineMismatchRN5clang4SemaENS_14SourceLocationES2_PNS_14IdentifierInfoEPbPNS_13NamespaceDeclE")
//</editor-fold>
public static void DiagnoseNamespaceInlineMismatch(final Sema /*&*/ S, SourceLocation KeywordLoc, 
                               SourceLocation Loc, 
                               IdentifierInfo /*P*/ II, bool$ptr/*bool P*/ IsInline, 
                               NamespaceDecl /*P*/ PrevNS) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    assert (IsInline.$star() != PrevNS.isInline());
    
    // HACK: Work around a bug in libstdc++4.6's <atomic>, where
    // std::__atomic[0,1,2] are defined as non-inline namespaces, then reopened as
    // inline namespaces, with the intention of bringing names into namespace std.
    //
    // We support this just well enough to get that case working; this is not
    // sufficient to support reopening namespaces as inline in general.
    if (IsInline.$star() && (II != null) && II.getName().startswith(/*STRINGREF_STR*/"__atomic")
       && S.getSourceManager().isInSystemHeader(/*NO_COPY*/Loc)) {
      // Mark all prior declarations of the namespace as inline.
      for (NamespaceDecl /*P*/ NS = PrevNS.getMostRecentDecl(); (NS != null);
           NS = NS.getPreviousDecl())  {
        NS.setInline(IsInline.$star());
      }
      // Patch up the lookup table for the containing namespace. This isn't really
      // correct, but it's good enough for this particular case.
      for (Decl /*P*/ I : PrevNS.decls())  {
        {
          NamedDecl /*P*/ ND = dyn_cast_NamedDecl(I);
          if ((ND != null)) {
            PrevNS.getParent().makeDeclVisibleInContext(ND);
          }
        }
      }
      return;
    }
    if (PrevNS.isInline()) {
      // The user probably just forgot the 'inline', so suggest that it
      // be added back.
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc), diag.warn_inline_namespace_reopened_noninline)), 
          FixItHint.CreateInsertion(/*NO_COPY*/KeywordLoc, new StringRef(/*KEEP_STR*/"inline "))));
    } else {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc), diag.err_inline_namespace_mismatch)), IsInline.$star()));
    }
    
    $c$.clean($c$.track(S.Diag(PrevNS.getLocation(), diag.note_previous_definition)));
    IsInline.$set(PrevNS.isInline());
  } finally {
    $c$.$destroy();
  }
}


/// getNamespaceDecl - Returns the namespace a decl represents. If the decl
/// is a namespace alias, returns the namespace it points to.
//<editor-fold defaultstate="collapsed" desc="getNamespaceDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 7478,
 FQN="getNamespaceDecl", NM="_ZL16getNamespaceDeclPN5clang9NamedDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZL16getNamespaceDeclPN5clang9NamedDeclE")
//</editor-fold>
public static /*inline*/ NamespaceDecl /*P*/ getNamespaceDecl(NamedDecl /*P*/ D) {
  {
    NamespaceAliasDecl /*P*/ AD = dyn_cast_or_null_NamespaceAliasDecl(D);
    if ((AD != null)) {
      return AD.getNamespace();
    }
  }
  return dyn_cast_or_null_NamespaceDecl(D);
}

//<editor-fold defaultstate="collapsed" desc="LookupStdInitializerList">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 7582,
 FQN="LookupStdInitializerList", NM="_ZL24LookupStdInitializerListRN5clang4SemaENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZL24LookupStdInitializerListRN5clang4SemaENS_14SourceLocationE")
//</editor-fold>
public static ClassTemplateDecl /*P*/ LookupStdInitializerList(final Sema /*&*/ S, SourceLocation Loc) {
  LookupResult Result = null;
  try {
    NamespaceDecl /*P*/ Std = S.getStdNamespace();
    if (!(Std != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track(S.Diag(new SourceLocation(Loc), diag.err_implied_std_initializer_list_not_found)));
        return null;
      } finally {
        $c$.$destroy();
      }
    }
    
    Result/*J*/= new LookupResult(S, new DeclarationName($AddrOf(S.PP.getIdentifierTable().get(new StringRef(/*KEEP_STR*/"initializer_list")))), 
        new SourceLocation(Loc), Sema.LookupNameKind.LookupOrdinaryName);
    if (!S.LookupQualifiedName(Result, Std)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track(S.Diag(new SourceLocation(Loc), diag.err_implied_std_initializer_list_not_found)));
        return null;
      } finally {
        $c$.$destroy();
      }
    }
    ClassTemplateDecl /*P*/ Template = Result.<ClassTemplateDecl>getAsSingle(ClassTemplateDecl.class);
    if (!(Template != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        Result.suppressDiagnostics();
        // We found something weird. Complain about the first thing we found.
        NamedDecl /*P*/ Found = Result.begin().$star();
        $c$.clean($c$.track(S.Diag(Found.getLocation(), diag.err_malformed_std_initializer_list)));
        return null;
      } finally {
        $c$.$destroy();
      }
    }
    
    // We found some template called std::initializer_list. Now verify that it's
    // correct.
    TemplateParameterList /*P*/ Params = Template.getTemplateParameters();
    if (Params.getMinRequiredArguments() != 1
       || !isa_TemplateTypeParmDecl(Params.getParam(0))) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track(S.Diag(Template.getLocation(), diag.err_malformed_std_initializer_list)));
        return null;
      } finally {
        $c$.$destroy();
      }
    }
    
    return Template;
  } finally {
    if (Result != null) { Result.$destroy(); }
  }
}


/// \brief Determine whether a using statement is in a context where it will be
/// apply in all contexts.
//<editor-fold defaultstate="collapsed" desc="IsUsingDirectiveInToplevelContext">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 7650,
 FQN="IsUsingDirectiveInToplevelContext", NM="_ZL33IsUsingDirectiveInToplevelContextPN5clang11DeclContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZL33IsUsingDirectiveInToplevelContextPN5clang11DeclContextE")
//</editor-fold>
public static boolean IsUsingDirectiveInToplevelContext(DeclContext /*P*/ CurContext) {
  switch (CurContext.getDeclKind()) {
   case TranslationUnit:
    return true;
   case LinkageSpec:
    return IsUsingDirectiveInToplevelContext(CurContext.getParent());
   default:
    return false;
  }
}

//<editor-fold defaultstate="collapsed" desc="TryNamespaceTypoCorrection">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 7675,
 FQN="TryNamespaceTypoCorrection", NM="_ZL26TryNamespaceTypoCorrectionRN5clang4SemaERNS_12LookupResultEPNS_5ScopeERNS_12CXXScopeSpecENS_14SourceLocationEPNS_14IdentifierInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZL26TryNamespaceTypoCorrectionRN5clang4SemaERNS_12LookupResultEPNS_5ScopeERNS_12CXXScopeSpecENS_14SourceLocationEPNS_14IdentifierInfoE")
//</editor-fold>
public static boolean TryNamespaceTypoCorrection(final Sema /*&*/ S, final LookupResult /*&*/ R, Scope /*P*/ Sc, 
                          final CXXScopeSpec /*&*/ SS, 
                          SourceLocation IdentLoc, 
                          IdentifierInfo /*P*/ Ident) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    R.clear();
    {
      TypoCorrection Corrected = null;
      try {
        Corrected = $c$.clean(S.CorrectTypo(R.getLookupNameInfo(), R.getLookupKind(), Sc, $AddrOf(SS), 
            $c$.track(new std.unique_ptr<CorrectionCandidateCallback>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(llvm.make_unique(new NamespaceValidatorCCC())))), 
            Sema.CorrectTypoKind.CTK_ErrorRecovery));
        if (Corrected.$bool()) {
          {
            DeclContext /*P*/ DC = S.computeDeclContext(SS, false);
            if ((DC != null)) {
              std.string CorrectedStr/*J*/= Corrected.getAsString(S.getLangOpts());
              boolean DroppedSpecifier = Corrected.WillReplaceSpecifier()
                 && Ident.getName().equals(new StringRef(CorrectedStr));
              S.diagnoseTypo(Corrected, 
                  $out_PartialDiagnostic$C_SourceRange($out_PartialDiagnostic$C_int($out$Same2DeclContext($out_PartialDiagnostic$C_IdentifierInfo$C$P($c$.track(S.PDiag(diag.err_using_directive_member_suggest)), 
                                  Ident), DC), (DroppedSpecifier ? 1 : 0)), SS.getRange()), 
                  $c$.track(S.PDiag(diag.note_namespace_defined_here))); $c$.clean();
            } else {
              S.diagnoseTypo(Corrected, 
                  $out_PartialDiagnostic$C_IdentifierInfo$C$P($c$.track(S.PDiag(diag.err_using_directive_suggest)), Ident), 
                  $c$.track(S.PDiag(diag.note_namespace_defined_here))); $c$.clean();
            }
          }
          R.addDecl(Corrected.getFoundDecl());
          return true;
        }
      } finally {
        if (Corrected != null) { Corrected.$destroy(); }
      }
    }
    return false;
  } finally {
    $c$.$destroy();
  }
}


/// \brief Determine whether a using declaration considers the given
/// declarations as "equivalent", e.g., if they are redeclarations of
/// the same entity or are both typedefs of the same type.
//<editor-fold defaultstate="collapsed" desc="IsEquivalentForUsingDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 7875,
 FQN="IsEquivalentForUsingDecl", NM="_ZL24IsEquivalentForUsingDeclRN5clang10ASTContextEPNS_9NamedDeclES3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZL24IsEquivalentForUsingDeclRN5clang10ASTContextEPNS_9NamedDeclES3_")
//</editor-fold>
public static boolean IsEquivalentForUsingDecl(final ASTContext /*&*/ Context, NamedDecl /*P*/ D1, NamedDecl /*P*/ D2) {
  if (D1.getCanonicalDecl() == D2.getCanonicalDecl()) {
    return true;
  }
  {
    
    TypedefNameDecl /*P*/ TD1 = dyn_cast_TypedefNameDecl(D1);
    if ((TD1 != null)) {
      {
        TypedefNameDecl /*P*/ TD2 = dyn_cast_TypedefNameDecl(D2);
        if ((TD2 != null)) {
          return Context.hasSameType(TD1.getUnderlyingType(), 
              TD2.getUnderlyingType());
        }
      }
    }
  }
  
  return false;
}


/// Determine whether a direct base class is a virtual base class.
//<editor-fold defaultstate="collapsed" desc="isVirtualDirectBase">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 8031,
 FQN="isVirtualDirectBase", NM="_ZL19isVirtualDirectBasePN5clang13CXXRecordDeclES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZL19isVirtualDirectBasePN5clang13CXXRecordDeclES1_")
//</editor-fold>
public static boolean isVirtualDirectBase(CXXRecordDecl /*P*/ Derived, CXXRecordDecl /*P*/ Base) {
  if (!(Derived.getNumVBases() != 0)) {
    return false;
  }
  for (final CXXBaseSpecifier /*&*/ B : Derived.bases())  {
    if (B.getType().$arrow().getAsCXXRecordDecl() == Base) {
      return B.isVirtual();
    }
  }
  throw new llvm_unreachable("not a direct base class");
}


/// Find the base specifier for a base class with the given type.
//<editor-fold defaultstate="collapsed" desc="findDirectBaseWithType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 8133,
 FQN="findDirectBaseWithType", NM="_ZL22findDirectBaseWithTypePN5clang13CXXRecordDeclENS_8QualTypeERb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZL22findDirectBaseWithTypePN5clang13CXXRecordDeclENS_8QualTypeERb")
//</editor-fold>
public static CXXBaseSpecifier /*P*/ findDirectBaseWithType(CXXRecordDecl /*P*/ Derived, 
                      QualType DesiredBase, 
                      final bool$ref/*bool &*/ AnyDependentBases) {
  // Check whether the named type is a direct base class.
  CanQual<Type> CanonicalDesiredBase = DesiredBase.$arrow().getCanonicalTypeUnqualified();
  for (final CXXBaseSpecifier /*&*/ Base : Derived.bases()) {
    CanQual<Type> BaseType = Base.getType().$arrow().getCanonicalTypeUnqualified();
    if ($eq_CanQual$T_CanQual$U(/*NO_COPY*/CanonicalDesiredBase, /*NO_COPY*/BaseType)) {
      return $AddrOf(Base);
    }
    if (((CanProxyType)BaseType.$arrow()).$arrow().isDependentType()) {
      AnyDependentBases.$set(true);
    }
  }
  return null;
}

//<editor-fold defaultstate="collapsed" desc="getDefaultArgExprsForConstructors">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 9563,
 FQN="getDefaultArgExprsForConstructors", NM="_ZL33getDefaultArgExprsForConstructorsRN5clang4SemaEPNS_13CXXRecordDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZL33getDefaultArgExprsForConstructorsRN5clang4SemaEPNS_13CXXRecordDeclE")
//</editor-fold>
public static void getDefaultArgExprsForConstructors(final Sema /*&*/ S, CXXRecordDecl /*P*/ Class) {
  // Don't do anything for template patterns.
  if ((Class.getDescribedClassTemplate() != null)) {
    return;
  }
  
  CallingConv ExpectedCallingConv = S.Context.getDefaultCallingConvention(/*IsVariadic=*/ false, /*IsCXXMethod=*/ true);
  
  CXXConstructorDecl /*P*/ LastExportedDefaultCtor = null;
  for (Decl /*P*/ Member : Class.decls()) {
    CXXConstructorDecl /*P*/ CD = dyn_cast_CXXConstructorDecl(Member);
    if (!(CD != null)) {
      {
        // Recurse on nested classes.
        CXXRecordDecl /*P*/ NestedRD = dyn_cast_CXXRecordDecl(Member);
        if ((NestedRD != null)) {
          getDefaultArgExprsForConstructors(S, NestedRD);
        }
      }
      continue;
    } else if (!CD.isDefaultConstructor() || !CD.hasAttr(DLLExportAttr.class)) {
      continue;
    }
    
    CallingConv ActualCallingConv = CD.getType().$arrow().getAs(FunctionProtoType.class).getCallConv();
    
    // Skip default constructors with typical calling conventions and no default
    // arguments.
    /*uint*/int NumParams = CD.getNumParams();
    if (ExpectedCallingConv == ActualCallingConv && NumParams == 0) {
      continue;
    }
    if ((LastExportedDefaultCtor != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(LastExportedDefaultCtor.getLocation(), 
                diag.err_attribute_dll_ambiguous_default_ctor)), Class));
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(CD.getLocation(), diag.note_entity_declared_at)), 
            CD.getDeclName()));
        return;
      } finally {
        $c$.$destroy();
      }
    }
    LastExportedDefaultCtor = CD;
    
    for (/*uint*/int I = 0; I != NumParams; ++I) {
      // Skip any default arguments that we've already instantiated.
      if ((S.Context.getDefaultArgExprForConstructor(CD, I) != null)) {
        continue;
      }
      
      Expr /*P*/ DefaultArg = S.BuildCXXDefaultArgExpr(Class.getLocation(), CD, 
          CD.getParamDecl(I)).get();
      S.DiscardCleanupsInEvaluationContext();
      S.Context.addDefaultArgExprForConstructor(CD, I, DefaultArg);
    }
  }
}

// end anonymous namespace

/// When generating a defaulted copy or move assignment operator, if a field
/// should be copied with __builtin_memcpy rather than via explicit assignments,
/// do so. This optimization only applies for arrays of scalars, and for arrays
/// of class type where the selected copy/move-assignment operator is trivial.
//<editor-fold defaultstate="collapsed" desc="buildMemcpyForAssignmentOp">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 9800,
 FQN="buildMemcpyForAssignmentOp", NM="_ZL26buildMemcpyForAssignmentOpRN5clang4SemaENS_14SourceLocationENS_8QualTypeERKN12_GLOBAL__N_111ExprBuilderES7_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZL26buildMemcpyForAssignmentOpRN5clang4SemaENS_14SourceLocationENS_8QualTypeERKN12_GLOBAL__N_111ExprBuilderES7_")
//</editor-fold>
public static ActionResultTTrue<Stmt /*P*/ > buildMemcpyForAssignmentOp(final Sema /*&*/ S, SourceLocation Loc, QualType T, 
                          final /*const*/ ExprBuilder /*&*/ ToB, final /*const*/ ExprBuilder /*&*/ FromB) {
  LookupResult R = null;
  try {
    // Compute the size of the memory buffer to be copied.
    QualType SizeType = S.Context.getSizeType().$QualType();
    APInt Size/*J*/= new APInt($ulong2uint(S.Context.getTypeSize(new QualType(SizeType))), 
        S.Context.getTypeSizeInChars(new QualType(T)).getQuantity());
    
    // Take the address of the field references for "from" and "to". We
    // directly construct UnaryOperators here because semantic analysis
    // does not permit us to take the address of an xvalue.
    Expr /*P*/ From = FromB.build(S, new SourceLocation(Loc));
    final Expr /*P*/ L$From = From;
    From = /*NEW_EXPR [Stmt::new]*//*new (S.Context)*/ Stmt.$new_uint_ASTContext$C_uint(S.Context, (type$ptr<?> New$Mem)->new UnaryOperator(L$From, UnaryOperatorKind.UO_AddrOf, 
        S.Context.getPointerType(L$From.getType()), 
        ExprValueKind.VK_RValue, ExprObjectKind.OK_Ordinary, new SourceLocation(Loc)));
    Expr /*P*/ To = ToB.build(S, new SourceLocation(Loc));
    final Expr /*P*/ L$To = To;
    To = /*NEW_EXPR [Stmt::new]*//*new (S.Context)*/ Stmt.$new_uint_ASTContext$C_uint(S.Context, (type$ptr<?> New$Mem)->new UnaryOperator(L$To, UnaryOperatorKind.UO_AddrOf, 
        S.Context.getPointerType(L$To.getType()), 
        ExprValueKind.VK_RValue, ExprObjectKind.OK_Ordinary, new SourceLocation(Loc)));
    
    /*const*/ Type /*P*/ E = T.$arrow().getBaseElementTypeUnsafe();
    boolean NeedsCollectableMemCpy = E.isRecordType() && E.<RecordType>getAs$RecordType().getDecl().hasObjectMember();
    
    // Create a reference to the __builtin_objc_memmove_collectable function
    StringRef MemCpyName = new StringRef(NeedsCollectableMemCpy ? $("__builtin_objc_memmove_collectable") : $("__builtin_memcpy"));
    R/*J*/= new LookupResult(S, new DeclarationName($AddrOf(S.Context.Idents.get(/*NO_COPY*/MemCpyName))), new SourceLocation(Loc), 
        Sema.LookupNameKind.LookupOrdinaryName);
    S.LookupName(R, S.TUScope, true);
    
    FunctionDecl /*P*/ MemCpy = R.<FunctionDecl>getAsSingle(FunctionDecl.class);
    if (!(MemCpy != null)) {
      // Something went horribly wrong earlier, and we will have complained
      // about it.
      return StmtError();
    }
    
    ActionResultTTrue<Expr /*P*/ > MemCpyRef = S.BuildDeclRefExpr(MemCpy, S.Context.BuiltinFnTy.$QualType(), 
        ExprValueKind.VK_RValue, new SourceLocation(Loc), (/*const*/ CXXScopeSpec /*P*/ )null);
    assert (MemCpyRef.isUsable()) : "Builtin reference cannot fail";
    
    Expr /*P*/ CallArgs[/*3*/] = new Expr /*P*/ [/*3*/] {
      To, From, IntegerLiteral.Create(S.Context, Size, new QualType(SizeType), new SourceLocation(Loc))
    };
    ActionResultTTrue<Expr /*P*/ > Call = S.ActOnCallExpr(/*Scope=*/ (Scope /*P*/ )null, MemCpyRef.get(), 
        new SourceLocation(Loc), new MutableArrayRef<Expr /*P*/ >(CallArgs, true), new SourceLocation(Loc));
    assert (!Call.isInvalid()) : "Call to __builtin_memcpy cannot fail!";
    return new ActionResultTTrue<Stmt /*P*/ >(JD$T.INSTANCE, Call.getAs(Stmt.class));
  } finally {
    if (R != null) { R.$destroy(); }
  }
}


/// \brief Builds a statement that copies/moves the given entity from \p From to
/// \c To.
///
/// This routine is used to copy/move the members of a class with an
/// implicitly-declared copy/move assignment operator. When the entities being
/// copied are arrays, this routine builds for loops to copy them.
///
/// \param S The Sema object used for type-checking.
///
/// \param Loc The location where the implicit copy/move is being generated.
///
/// \param T The type of the expressions being copied/moved. Both expressions
/// must have this type.
///
/// \param To The expression we are copying/moving to.
///
/// \param From The expression we are copying/moving from.
///
/// \param CopyingBaseSubobject Whether we're copying/moving a base subobject.
/// Otherwise, it's a non-static member subobject.
///
/// \param Copying Whether we're copying or moving.
///
/// \param Depth Internal parameter recording the depth of the recursion.
///
/// \returns A statement or a loop that copies the expressions, or StmtResult(0)
/// if a memcpy should be used instead.
//<editor-fold defaultstate="collapsed" desc="buildSingleCopyAssignRecursively">
@Converted(kind = Converted.Kind.MANUAL,
 optimized = Converted.Optimization.VALUE_TYPE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 9879,
 FQN="buildSingleCopyAssignRecursively", NM="_ZL32buildSingleCopyAssignRecursivelyRN5clang4SemaENS_14SourceLocationENS_8QualTypeERKN12_GLOBAL__N_111ExprBuilderES7_bbj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZL32buildSingleCopyAssignRecursivelyRN5clang4SemaENS_14SourceLocationENS_8QualTypeERKN12_GLOBAL__N_111ExprBuilderES7_bbj")
//</editor-fold>
public static ActionResultTTrue<Stmt /*P*/ > buildSingleCopyAssignRecursively(final Sema /*&*/ S, SourceLocation Loc, QualType T, 
                                final /*const*/ ExprBuilder /*&*/ To, final /*const*/ ExprBuilder /*&*/ From, 
                                boolean CopyingBaseSubobject, boolean Copying) {
  return buildSingleCopyAssignRecursively(S, Loc, T, 
                                To, From, 
                                CopyingBaseSubobject, Copying, 
                                0);
}
public static ActionResultTTrue<Stmt /*P*/ > buildSingleCopyAssignRecursively(final Sema /*&*/ S, SourceLocation Loc, QualType T, 
                                final /*const*/ ExprBuilder /*&*/ To, final /*const*/ ExprBuilder /*&*/ From, 
                                boolean CopyingBaseSubobject, boolean Copying, 
                                /*uint*/int Depth/*= 0*/) {
  RefBuilder IterationVarRef = null;
  LvalueConvBuilder IterationVarRefRVal = null;
  SubscriptBuilder FromIndexCopy = null;
  MoveCastBuilder FromIndexMove = null;
  SubscriptBuilder ToIndex = null;
  try {
    {
      // C++11 [class.copy]p28:
      //   Each subobject is assigned in the manner appropriate to its type:
      //
      //     - if the subobject is of class type, as if by a call to operator= with
      //       the subobject as the object expression and the corresponding
      //       subobject of x as a single function argument (as if by explicit
      //       qualification; that is, ignoring any possible virtual overriding
      //       functions in more derived classes);
      //
      // C++03 [class.copy]p13:
      //     - if the subobject is of class type, the copy assignment operator for
      //       the class is used (as if by explicit qualification; that is,
      //       ignoring any possible virtual overriding functions in more derived
      //       classes);
      /*const*/ RecordType /*P*/ RecordTy = T.$arrow().<RecordType>getAs$RecordType();
      if ((RecordTy != null)) {
        LookupResult OpLookup = null;
        CXXScopeSpec SS = null;
        try {
          CXXRecordDecl /*P*/ ClassDecl = cast_CXXRecordDecl(RecordTy.getDecl());
          
          // Look for operator=.
          DeclarationName Name = S.Context.DeclarationNames.getCXXOperatorName(OverloadedOperatorKind.OO_Equal);
          OpLookup/*J*/= new LookupResult(S, new DeclarationName(Name), new SourceLocation(Loc), Sema.LookupNameKind.LookupOrdinaryName);
          S.LookupQualifiedName(OpLookup, ClassDecl, false);
          
          // Prior to C++11, filter out any result that isn't a copy/move-assignment
          // operator.
          if (!S.getLangOpts().CPlusPlus11) {
            LookupResult.Filter F = null;
            try {
              F = OpLookup.makeFilter();
              while (F.hasNext()) {
                NamedDecl /*P*/ D = F.next();
                {
                  CXXMethodDecl /*P*/ Method = dyn_cast_CXXMethodDecl(D);
                  if ((Method != null)) {
                    if (Method.isCopyAssignmentOperator()
                       || (!Copying && Method.isMoveAssignmentOperator())) {
                      continue;
                    }
                  }
                }
                
                F.erase();
              }
              F.done();
            } finally {
              if (F != null) { F.$destroy(); }
            }
          }
          
          // Suppress the protected check (C++ [class.protected]) for each of the
          // assignment operators we found. This strange dance is required when
          // we're assigning via a base classes's copy-assignment operator. To
          // ensure that we're getting the right base class subobject (without
          // ambiguities), we need to cast "this" to that subobject type; to
          // ensure that we don't go through the virtual call mechanism, we need
          // to qualify the operator= name with the base class (see below). However,
          // this means that if the base class has a protected copy assignment
          // operator, the protected member access check will fail. So, we
          // rewrite "protected" access to "public" access in this case, since we
          // know by construction that we're calling from a derived class.
          if (CopyingBaseSubobject) {
            for (UnresolvedSetIterator L = OpLookup.begin(), LEnd = OpLookup.end();
                 L.$noteq(LEnd); L.$preInc()) {
              if (L.getAccess() == AccessSpecifier.AS_protected) {
                L.setAccess(AccessSpecifier.AS_public);
              }
            }
          }
          
          // Create the nested-name-specifier that will be used to qualify the
          // reference to operator=; this is required to suppress the virtual
          // call mechanism.
          SS/*J*/= new CXXScopeSpec();
          /*const*/ Type /*P*/ CanonicalT = S.Context.getCanonicalType(T.getTypePtr());
          SS.MakeTrivial(S.Context, 
              NestedNameSpecifier.Create(S.Context, (NestedNameSpecifier /*P*/ )null, false, 
                  CanonicalT), 
              new SourceRange(/*NO_COPY*/Loc));
          
          // Create the reference to operator=.
          ActionResultTTrue<Expr /*P*/ > OpEqualRef = S.BuildMemberReferenceExpr2(To.build(S, new SourceLocation(Loc)), new QualType(T), new SourceLocation(Loc), /*isArrow=*/ false, 
              SS, /*TemplateKWLoc=*/ new SourceLocation(), 
              /*FirstQualifierInScope=*/ (NamedDecl /*P*/ )null, 
              OpLookup, 
              /*TemplateArgs=*/ (/*const*/ TemplateArgumentListInfo /*P*/ )null, /*S*/ (/*const*/ Scope /*P*/ )null, 
              /*SuppressQualifierCheck=*/ true);
          if (OpEqualRef.isInvalid()) {
            return StmtError();
          }
          
          // Build the call to the assignment operator.
          Expr /*P*/ FromInst = From.build(S, new SourceLocation(Loc));
          ActionResultTTrue<Expr /*P*/ > Call = S.BuildCallToMemberFunction(/*Scope=*/ (Scope /*P*/ )null, 
              OpEqualRef.getAs(Expr.class), 
              new SourceLocation(Loc), new MutableArrayRef<Expr /*P*/ >(FromInst, true), new SourceLocation(Loc));
          if (Call.isInvalid()) {
            return StmtError();
          }
          
          // If we built a call to a trivial 'operator=' while copying an array,
          // bail out. We'll replace the whole shebang with a memcpy.
          CXXMemberCallExpr /*P*/ CE = dyn_cast_CXXMemberCallExpr(Call.get());
          if ((CE != null) && CE.getMethodDecl().isTrivial() && (Depth != 0)) {
            return new ActionResultTTrue<Stmt /*P*/ >(JD$T.INSTANCE, (Stmt /*P*/ )(Stmt /*P*/ )null);
          }
          
          // Convert to an expression-statement, and clean up any produced
          // temporaries.
          return S.ActOnExprStmt(new ActionResultTTrue<Expr /*P*/ >(Call));
        } finally {
          if (SS != null) { SS.$destroy(); }
          if (OpLookup != null) { OpLookup.$destroy(); }
        }
      }
    }
    
    //     - if the subobject is of scalar type, the built-in assignment
    //       operator is used.
    /*const*/ ConstantArrayType /*P*/ ArrayTy = S.Context.getAsConstantArrayType(new QualType(T));
    if (!(ArrayTy != null)) {
      ActionResultTTrue<Expr /*P*/ > Assignment = S.CreateBuiltinBinOp(new SourceLocation(Loc), BinaryOperatorKind.BO_Assign, To.build(S, new SourceLocation(Loc)), From.build(S, new SourceLocation(Loc)));
      if (Assignment.isInvalid()) {
        return StmtError();
      }
      return S.ActOnExprStmt(new ActionResultTTrue<Expr /*P*/ >(Assignment));
    }
    
    //     - if the subobject is an array, each element is assigned, in the
    //       manner appropriate to the element type;
    
    // Construct a loop over the array bounds, e.g.,
    //
    //   for (__SIZE_TYPE__ i0 = 0; i0 != array-size; ++i0)
    //
    // that will copy each of the array elements. 
    QualType SizeType = S.Context.getSizeType().$QualType();
    
    // Create the iteration variable.
    IdentifierInfo /*P*/ IterationVarName = null;
    {
      raw_svector_ostream OS = null;
      try {
        SmallString/*8*/ Str/*J*/= new SmallString/*8*/(8);
        OS/*J*/= new raw_svector_ostream(Str);
        OS.$out(/*KEEP_STR*/"__i").$out_uint(Depth);
        assert Str.equals(OS.str()) : "JAVA: expects the same content " + Str + " vs. " + OS.str();
        IterationVarName = $AddrOf(S.Context.Idents.get(/*JAVA: PERF*/Str));
      } finally {
        if (OS != null) { OS.$destroy(); }
      }
    }
    VarDecl /*P*/ IterationVar = VarDecl.Create(S.Context, S.CurContext, new SourceLocation(Loc), new SourceLocation(Loc), 
        IterationVarName, new QualType(SizeType), 
        S.Context.getTrivialTypeSourceInfo(new QualType(SizeType), new SourceLocation(Loc)), 
        StorageClass.SC_None);
    
    // Initialize the iteration variable to zero.
    APInt Zero/*J*/= new APInt($ulong2uint(S.Context.getTypeSize(new QualType(SizeType))), 0);
    IterationVar.setInit(IntegerLiteral.Create(S.Context, Zero, new QualType(SizeType), new SourceLocation(Loc)));
    
    // Creates a reference to the iteration variable.
    IterationVarRef/*J*/= new RefBuilder(IterationVar, new QualType(SizeType));
    IterationVarRefRVal/*J*/= new LvalueConvBuilder(IterationVarRef);
    
    // Create the DeclStmt that holds the iteration variable.
    Stmt /*P*/ InitStmt = /*NEW_EXPR [Stmt::new]*//*new (S.Context)*/ Stmt.$new_uint_ASTContext$C_uint(S.Context, (type$ptr<?> New$Mem)->new DeclStmt(new DeclGroupRef(IterationVar), new SourceLocation(Loc), new SourceLocation(Loc)));
    
    // Subscript the "from" and "to" expressions with the iteration variable.
    FromIndexCopy/*J*/= new SubscriptBuilder(From, IterationVarRefRVal);
    FromIndexMove/*J*/= new MoveCastBuilder(FromIndexCopy);
    /*const*/ ExprBuilder /*P*/ FromIndex;
    if (Copying) {
      FromIndex = $AddrOf(FromIndexCopy);
    } else {
      FromIndex = $AddrOf(FromIndexMove);
    }
    
    ToIndex/*J*/= new SubscriptBuilder(To, IterationVarRefRVal);
    
    // Build the copy/move for an individual element of the array.
    ActionResultTTrue<Stmt /*P*/ > Copy = buildSingleCopyAssignRecursively(S, new SourceLocation(Loc), ArrayTy.getElementType(), 
        ToIndex, $Deref(FromIndex), CopyingBaseSubobject, 
        Copying, Depth + 1);
    // Bail out if copying fails or if we determined that we should use memcpy.
    if (Copy.isInvalid() || !(Copy.get() != null)) {
      return Copy;
    }
    
    // Create the comparison against the array bound.
    APInt Upper = ArrayTy.getSize().zextOrTrunc($ulong2uint(S.Context.getTypeSize(new QualType(SizeType))));
    final LvalueConvBuilder L$IterationVarRefRVal = IterationVarRefRVal;
    Expr /*P*/ Comparison = /*NEW_EXPR [Stmt::new]*//*new (S.Context)*/ Stmt.$new_uint_ASTContext$C_uint(S.Context, (type$ptr<?> New$Mem)->new BinaryOperator(L$IterationVarRefRVal.build(S, new SourceLocation(Loc)), 
        IntegerLiteral.Create(S.Context, Upper, new QualType(SizeType), new SourceLocation(Loc)), 
        BinaryOperatorKind.BO_NE, S.Context.BoolTy.$QualType(), 
        ExprValueKind.VK_RValue, ExprObjectKind.OK_Ordinary, new SourceLocation(Loc), false));
    
    // Create the pre-increment of the iteration variable.
    final RefBuilder L$IterationVarRef = IterationVarRef;
    Expr /*P*/ Increment = /*NEW_EXPR [Stmt::new]*//*new (S.Context)*/ Stmt.$new_uint_ASTContext$C_uint(S.Context, (type$ptr<?> New$Mem)->new UnaryOperator(L$IterationVarRef.build(S, new SourceLocation(Loc)), UnaryOperatorKind.UO_PreInc, 
        new QualType(SizeType), ExprValueKind.VK_LValue, ExprObjectKind.OK_Ordinary, new SourceLocation(Loc)));
    
    // Construct the loop that copies all elements of this array.
    return S.ActOnForStmt(new SourceLocation(Loc), new SourceLocation(Loc), InitStmt, 
        S.ActOnCondition((Scope /*P*/ )null, new SourceLocation(Loc), Comparison, Sema.ConditionKind.Boolean), 
        S.MakeFullDiscardedValueExpr(Increment), new SourceLocation(Loc), Copy.get());
  } finally {
    if (ToIndex != null) { ToIndex.$destroy(); }
    if (FromIndexMove != null) { FromIndexMove.$destroy(); }
    if (FromIndexCopy != null) { FromIndexCopy.$destroy(); }
    if (IterationVarRefRVal != null) { IterationVarRefRVal.$destroy(); }
    if (IterationVarRef != null) { IterationVarRef.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="buildSingleCopyAssign">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 10069,
 FQN="buildSingleCopyAssign", NM="_ZL21buildSingleCopyAssignRN5clang4SemaENS_14SourceLocationENS_8QualTypeERKN12_GLOBAL__N_111ExprBuilderES7_bb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZL21buildSingleCopyAssignRN5clang4SemaENS_14SourceLocationENS_8QualTypeERKN12_GLOBAL__N_111ExprBuilderES7_bb")
//</editor-fold>
public static ActionResultTTrue<Stmt /*P*/ > buildSingleCopyAssign(final Sema /*&*/ S, SourceLocation Loc, QualType T, 
                     final /*const*/ ExprBuilder /*&*/ To, final /*const*/ ExprBuilder /*&*/ From, 
                     boolean CopyingBaseSubobject, boolean Copying) {
  // Maybe we should use a memcpy?
  if (T.$arrow().isArrayType() && !T.isConstQualified() && !T.isVolatileQualified()
     && T.isTriviallyCopyableType(S.Context)) {
    return buildMemcpyForAssignmentOp(S, new SourceLocation(Loc), new QualType(T), To, From);
  }
  
  ActionResultTTrue<Stmt /*P*/ > Result/*J*/= buildSingleCopyAssignRecursively(S, new SourceLocation(Loc), new QualType(T), To, From, 
      CopyingBaseSubobject, 
      Copying, 0);
  
  // If we ended up picking a trivial assignment operator for an array of a
  // non-trivially-copyable class type, just emit a memcpy.
  if (!Result.isInvalid() && !(Result.get() != null)) {
    return buildMemcpyForAssignmentOp(S, new SourceLocation(Loc), new QualType(T), To, From);
  }
  
  return Result;
}


/// Diagnose an implicit copy operation for a class which is odr-used, but
/// which is deprecated because the class has a user-declared copy constructor,
/// copy assignment operator, or destructor.
//<editor-fold defaultstate="collapsed" desc="diagnoseDeprecatedCopyOperation">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 10225,
 FQN="diagnoseDeprecatedCopyOperation", NM="_ZL31diagnoseDeprecatedCopyOperationRN5clang4SemaEPNS_13CXXMethodDeclENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZL31diagnoseDeprecatedCopyOperationRN5clang4SemaEPNS_13CXXMethodDeclENS_14SourceLocationE")
//</editor-fold>
public static void diagnoseDeprecatedCopyOperation(final Sema /*&*/ S, CXXMethodDecl /*P*/ CopyOp, 
                               SourceLocation UseLoc) {
  assert (CopyOp.isImplicit());
  
  CXXRecordDecl /*P*/ RD = CopyOp.getParent();
  CXXMethodDecl /*P*/ UserDeclaredOperation = null;
  
  // In Microsoft mode, assignment operations don't affect constructors and
  // vice versa.
  if (RD.hasUserDeclaredDestructor()) {
    UserDeclaredOperation = RD.getDestructor();
  } else if (!isa_CXXConstructorDecl(CopyOp)
     && RD.hasUserDeclaredCopyConstructor()
     && !S.getLangOpts().MSVCCompat) {
    // Find any user-declared copy constructor.
    for (CXXConstructorDecl /*P*/ I : RD.ctors()) {
      if (I.isCopyConstructor()) {
        UserDeclaredOperation = I;
        break;
      }
    }
    assert Native.$bool(UserDeclaredOperation);
  } else if (isa_CXXConstructorDecl(CopyOp)
     && RD.hasUserDeclaredCopyAssignment()
     && !S.getLangOpts().MSVCCompat) {
    // Find any user-declared move assignment operator.
    for (CXXMethodDecl /*P*/ I : RD.methods()) {
      if (I.isCopyAssignmentOperator()) {
        UserDeclaredOperation = I;
        break;
      }
    }
    assert Native.$bool(UserDeclaredOperation);
  }
  if ((UserDeclaredOperation != null)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(UserDeclaredOperation.getLocation(), 
                      diag.warn_deprecated_copy_operation)), 
                  RD), /*copy assignment*/ !isa_CXXConstructorDecl(CopyOp)), 
          /*destructor*/ isa_CXXDestructorDecl(UserDeclaredOperation)));
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(UseLoc), diag.note_member_synthesized_at)), 
              (isa_CXXConstructorDecl(CopyOp) ? Sema.CXXSpecialMember.CXXCopyConstructor : Sema.CXXSpecialMember.CXXCopyAssignment)), 
          RD));
    } finally {
      $c$.$destroy();
    }
  }
}


/// Check if we're implicitly defining a move assignment operator for a class
/// with virtual bases. Such a move assignment might move-assign the virtual
/// base multiple times.
//<editor-fold defaultstate="collapsed" desc="checkMoveAssignmentForRepeatedMove">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 10619,
 FQN="checkMoveAssignmentForRepeatedMove", NM="_ZL34checkMoveAssignmentForRepeatedMoveRN5clang4SemaEPNS_13CXXRecordDeclENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZL34checkMoveAssignmentForRepeatedMoveRN5clang4SemaEPNS_13CXXRecordDeclENS_14SourceLocationE")
//</editor-fold>
public static void checkMoveAssignmentForRepeatedMove(final Sema /*&*/ S, CXXRecordDecl /*P*/ Class, 
                                  SourceLocation CurrentLocation) {
  assert (!Class.isDependentContext()) : "should not define dependent move";
  
  // Only a virtual base could get implicitly move-assigned multiple times.
  // Only a non-trivial move assignment can observe this. We only want to
  // diagnose if we implicitly define an assignment operator that assigns
  // two base classes, both of which move-assign the same virtual base.
  if (Class.getNumVBases() == 0 || Class.hasTrivialMoveAssignment()
     || $less_uint(Class.getNumBases(), 2)) {
    return;
  }
  
  SmallVector<CXXBaseSpecifier /*P*/> Worklist/*J*/= new SmallVector<CXXBaseSpecifier /*P*/>(16, null);
  // JAVA: typedef llvm::DenseMap<CXXRecordDecl *, CXXBaseSpecifier *> VBaseMap
//  final class VBaseMap extends DenseMap<CXXRecordDecl /*P*/ , CXXBaseSpecifier /*P*/ >{ };
  DenseMap<CXXRecordDecl /*P*/ , CXXBaseSpecifier /*P*/ > VBases/*J*/= new DenseMap<CXXRecordDecl /*P*/ , CXXBaseSpecifier /*P*/ >(DenseMapInfo$LikePtr.$Info(), (CXXBaseSpecifier /*P*/ )null);
  
  for (final CXXBaseSpecifier /*&*/ BI : Class.bases()) {
    Worklist.push_back($AddrOf(BI));
    while (!Worklist.empty()) {
      CXXBaseSpecifier /*P*/ BaseSpec = Worklist.pop_back_val();
      CXXRecordDecl /*P*/ Base = BaseSpec.getType().$arrow().getAsCXXRecordDecl();
      
      // If the base has no non-trivial move assignment operators,
      // we don't care about moves from it.
      if (!Base.hasNonTrivialMoveAssignment()) {
        continue;
      }
      
      // If there's nothing virtual here, skip it.
      if (!BaseSpec.isVirtual() && !(Base.getNumVBases() != 0)) {
        continue;
      }
      
      // If we're not actually going to call a move assignment for this base,
      // or the selected move assignment is trivial, skip it.
      Sema.SpecialMemberOverloadResult /*P*/ SMOR = S.LookupSpecialMember(Base, Sema.CXXSpecialMember.CXXMoveAssignment, 
          /*ConstArg*/ false, /*VolatileArg*/ false, 
          /*RValueThis*/ true, /*ConstThis*/ false, 
          /*VolatileThis*/ false);
      if (!(SMOR.getMethod() != null) || SMOR.getMethod().isTrivial()
         || !SMOR.getMethod().isMoveAssignmentOperator()) {
        continue;
      }
      if (BaseSpec.isVirtual()) {
        // We're going to move-assign this virtual base, and its move
        // assignment operator is not trivial. If this can happen for
        // multiple distinct direct bases of Class, diagnose it. (If it
        // only happens in one base, we'll diagnose it when synthesizing
        // that base class's move assignment operator.)
        final type$ref<CXXBaseSpecifier /*P*/ /*&*/> Existing = VBases.insert_pair$KeyT$ValueT(std.make_pair_Ptr_Ptr(Base.getCanonicalDecl(), $AddrOf(BI))).
            first.$arrow().second$ref();
        if ((Existing.$deref() != null) && Existing.$deref() != $AddrOf(BI)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(CurrentLocation), diag.warn_vbase_moved_multiple_times)), 
                    Class), Base));
            $c$.clean($out_SemaDiagnosticBuilder_SourceRange($out_SemaDiagnosticBuilder_CanQual($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Existing.$deref().getLocStart(), diag.note_vbase_moved_here)), 
                            (Base.getCanonicalDecl()
                               == Existing.$deref().getType().$arrow().getAsCXXRecordDecl().getCanonicalDecl())), 
                        Base), Existing.$deref().getType()), Existing.$deref().getSourceRange()));
            $c$.clean($out_SemaDiagnosticBuilder_SourceRange($out_SemaDiagnosticBuilder_CanQual($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(BI.getLocStart(), diag.note_vbase_moved_here)), 
                            (Base.getCanonicalDecl()
                               == BI.getType().$arrow().getAsCXXRecordDecl().getCanonicalDecl())), 
                        Base), BI.getType()), BaseSpec.getSourceRange()));
            
            // Only diagnose each vbase once.
            Existing.$set(null);
          } finally {
            $c$.$destroy();
          }
        }
      } else {
        // Only walk over bases that have defaulted move assignment operators.
        // We assume that any user-provided move assignment operator handles
        // the multiple-moves-of-vbase case itself somehow.
        if (!SMOR.getMethod().isDefaulted()) {
          continue;
        }
        
        // We're going to move the base classes of Base. Add them to the list.
        for (final CXXBaseSpecifier /*&*/ BI$1 : Base.bases())  {
          Worklist.push_back($AddrOf(BI$1));
        }
      }
    }
  }
}


/// \brief Determine whether the given list arguments contains exactly one 
/// "real" (non-default) argument.
//<editor-fold defaultstate="collapsed" desc="hasOneRealArgument">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 11412,
 FQN="hasOneRealArgument", NM="_ZL18hasOneRealArgumentN4llvm15MutableArrayRefIPN5clang4ExprEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZL18hasOneRealArgumentN4llvm15MutableArrayRefIPN5clang4ExprEEE")
//</editor-fold>
public static boolean hasOneRealArgument(MutableArrayRef<Expr /*P*/ > Args) {
  switch (Args.size()) {
   case 0:
    return false;
   default:
    if (!Args.$at(1).isDefaultArgument()) {
      return false;
    }
   case 1:
    
    // fall through
    return !Args.$at(0).isDefaultArgument();
  }
  
  //return false;
}

//<editor-fold defaultstate="collapsed" desc="CheckOperatorNewDeleteDeclarationScope">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 11654,
 FQN="CheckOperatorNewDeleteDeclarationScope", NM="_ZL38CheckOperatorNewDeleteDeclarationScopeRN5clang4SemaEPKNS_12FunctionDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZL38CheckOperatorNewDeleteDeclarationScopeRN5clang4SemaEPKNS_12FunctionDeclE")
//</editor-fold>
public static /*inline*/ boolean CheckOperatorNewDeleteDeclarationScope(final Sema /*&*/ SemaRef, 
                                      /*const*/ FunctionDecl /*P*/ FnDecl) {
  /*const*/ DeclContext /*P*/ DC = FnDecl.getDeclContext$Const().getRedeclContext$Const();
  if (isa_NamespaceDecl(DC)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      return $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(FnDecl.getLocation(), 
              diag.err_operator_new_delete_declared_in_namespace)), 
          FnDecl.getDeclName()).$bool());
    } finally {
      $c$.$destroy();
    }
  }
  if (isa_TranslationUnitDecl(DC)
     && FnDecl.getStorageClass() == StorageClass.SC_Static) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      return $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(FnDecl.getLocation(), 
              diag.err_operator_new_delete_declared_static)), 
          FnDecl.getDeclName()).$bool());
    } finally {
      $c$.$destroy();
    }
  }
  
  return false;
}

//<editor-fold defaultstate="collapsed" desc="CheckOperatorNewDeleteTypes">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 11674,
 FQN="CheckOperatorNewDeleteTypes", NM="_ZL27CheckOperatorNewDeleteTypesRN5clang4SemaEPKNS_12FunctionDeclENS_7CanQualINS_4TypeEEES7_jj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZL27CheckOperatorNewDeleteTypesRN5clang4SemaEPKNS_12FunctionDeclENS_7CanQualINS_4TypeEEES7_jj")
//</editor-fold>
public static /*inline*/ boolean CheckOperatorNewDeleteTypes(final Sema /*&*/ SemaRef, /*const*/ FunctionDecl /*P*/ FnDecl, 
                           CanQual<Type> ExpectedResultType, 
                           CanQual<Type> ExpectedFirstParamType, 
                           /*uint*/int DependentParamTypeDiag, 
                           /*uint*/int InvalidParamTypeDiag) {
  QualType ResultType = FnDecl.getType().$arrow().getAs(FunctionType.class).getReturnType();
  
  // Check that the result type is not dependent.
  if (ResultType.$arrow().isDependentType()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      return $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(FnDecl.getLocation(), 
                  diag.err_operator_new_delete_dependent_result_type)), 
              FnDecl.getDeclName()), ExpectedResultType).$bool());
    } finally {
      $c$.$destroy();
    }
  }
  
  // Check that the result type is what we expect.
  if ($noteq_CanQual$T_CanQual$U(SemaRef.Context.getCanonicalType(new QualType(ResultType)), /*NO_COPY*/ExpectedResultType)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      return $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(FnDecl.getLocation(), 
                  diag.err_operator_new_delete_invalid_result_type)), 
              FnDecl.getDeclName()), ExpectedResultType).$bool());
    } finally {
      $c$.$destroy();
    }
  }
  
  // A function template must have at least 2 parameters.
  if ((FnDecl.getDescribedFunctionTemplate() != null) && $less_uint(FnDecl.getNumParams(), 2)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      return $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(FnDecl.getLocation(), 
              diag.err_operator_new_delete_template_too_few_parameters)), 
          FnDecl.getDeclName()).$bool());
    } finally {
      $c$.$destroy();
    }
  }
  
  // The function decl must have at least 1 parameter.
  if (FnDecl.getNumParams() == 0) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      return $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(FnDecl.getLocation(), 
              diag.err_operator_new_delete_too_few_parameters)), 
          FnDecl.getDeclName()).$bool());
    } finally {
      $c$.$destroy();
    }
  }
  
  // Check the first parameter type is not dependent.
  QualType FirstParamType = FnDecl.getParamDecl$Const(0).getType();
  if (FirstParamType.$arrow().isDependentType()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      return $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(FnDecl.getLocation(), DependentParamTypeDiag)), 
              FnDecl.getDeclName()), ExpectedFirstParamType).$bool());
    } finally {
      $c$.$destroy();
    }
  }
  
  // Check that the first parameter type is what we expect.
  if ($noteq_CanQual$T_CanQual$U(SemaRef.Context.getCanonicalType(new QualType(FirstParamType)).getUnqualifiedType(), 
      /*NO_COPY*/ExpectedFirstParamType)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      return $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(FnDecl.getLocation(), InvalidParamTypeDiag)), 
              FnDecl.getDeclName()), ExpectedFirstParamType).$bool());
    } finally {
      $c$.$destroy();
    }
  }
  
  return false;
}

//<editor-fold defaultstate="collapsed" desc="CheckOperatorNewDeclaration">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 11722,
 FQN="CheckOperatorNewDeclaration", NM="_ZL27CheckOperatorNewDeclarationRN5clang4SemaEPKNS_12FunctionDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZL27CheckOperatorNewDeclarationRN5clang4SemaEPKNS_12FunctionDeclE")
//</editor-fold>
public static boolean CheckOperatorNewDeclaration(final Sema /*&*/ SemaRef, /*const*/ FunctionDecl /*P*/ FnDecl) {
  // C++ [basic.stc.dynamic.allocation]p1:
  //   A program is ill-formed if an allocation function is declared in a
  //   namespace scope other than global scope or declared static in global 
  //   scope.
  if (CheckOperatorNewDeleteDeclarationScope(SemaRef, FnDecl)) {
    return true;
  }
  
  CanQual<Type> SizeTy = SemaRef.Context.getCanonicalType(SemaRef.Context.getSizeType().$QualType());
  
  // C++ [basic.stc.dynamic.allocation]p1:
  //  The return type shall be void*. The first parameter shall have type 
  //  std::size_t.
  if (CheckOperatorNewDeleteTypes(SemaRef, FnDecl, new CanQual<Type>(SemaRef.Context.VoidPtrTy), 
      new CanQual<Type>(SizeTy), 
      diag.err_operator_new_dependent_param_type, 
      diag.err_operator_new_param_type)) {
    return true;
  }
  
  // C++ [basic.stc.dynamic.allocation]p1:
  //  The first parameter shall not have an associated default argument.
  if (FnDecl.getParamDecl$Const(0).hasDefaultArg()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      return $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(FnDecl.getLocation(), 
                  diag.err_operator_new_default_arg)), 
              FnDecl.getDeclName()), FnDecl.getParamDecl$Const(0).getDefaultArgRange()).$bool());
    } finally {
      $c$.$destroy();
    }
  }
  
  return false;
}

//<editor-fold defaultstate="collapsed" desc="CheckOperatorDeleteDeclaration">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 11753,
 FQN="CheckOperatorDeleteDeclaration", NM="_ZL30CheckOperatorDeleteDeclarationRN5clang4SemaEPNS_12FunctionDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZL30CheckOperatorDeleteDeclarationRN5clang4SemaEPNS_12FunctionDeclE")
//</editor-fold>
public static boolean CheckOperatorDeleteDeclaration(final Sema /*&*/ SemaRef, FunctionDecl /*P*/ FnDecl) {
  // C++ [basic.stc.dynamic.deallocation]p1:
  //   A program is ill-formed if deallocation functions are declared in a
  //   namespace scope other than global scope or declared static in global 
  //   scope.
  if (CheckOperatorNewDeleteDeclarationScope(SemaRef, FnDecl)) {
    return true;
  }
  
  // C++ [basic.stc.dynamic.deallocation]p2:
  //   Each deallocation function shall return void and its first parameter 
  //   shall be void*.
  if (CheckOperatorNewDeleteTypes(SemaRef, FnDecl, new CanQual<Type>(SemaRef.Context.VoidTy), 
      new CanQual<Type>(SemaRef.Context.VoidPtrTy), 
      diag.err_operator_delete_dependent_param_type, 
      diag.err_operator_delete_param_type)) {
    return true;
  }
  
  return false;
}

//<editor-fold defaultstate="collapsed" desc="checkLiteralOperatorTemplateParameterList">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 11911,
 FQN="checkLiteralOperatorTemplateParameterList", NM="_ZL41checkLiteralOperatorTemplateParameterListRN5clang4SemaEPNS_20FunctionTemplateDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZL41checkLiteralOperatorTemplateParameterListRN5clang4SemaEPNS_20FunctionTemplateDeclE")
//</editor-fold>
public static boolean checkLiteralOperatorTemplateParameterList(final Sema /*&*/ SemaRef, 
                                         FunctionTemplateDecl /*P*/ TpDecl) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    TemplateParameterList /*P*/ TemplateParams = TpDecl.getTemplateParameters();
    
    // Must have one or two template parameters.
    if (TemplateParams.size() == 1) {
      NonTypeTemplateParmDecl /*P*/ PmDecl = dyn_cast_NonTypeTemplateParmDecl(TemplateParams.getParam(0));
      
      // The template parameter must be a char parameter pack.
      if ((PmDecl != null) && PmDecl.isTemplateParameterPack()
         && SemaRef.Context.hasSameType(PmDecl.getType(), SemaRef.Context.CharTy.$QualType())) {
        return false;
      }
    } else if (TemplateParams.size() == 2) {
      TemplateTypeParmDecl /*P*/ PmType = dyn_cast_TemplateTypeParmDecl(TemplateParams.getParam(0));
      NonTypeTemplateParmDecl /*P*/ PmArgs = dyn_cast_NonTypeTemplateParmDecl(TemplateParams.getParam(1));
      
      // The second template parameter must be a parameter pack with the
      // first template parameter as its type.
      if ((PmType != null) && (PmArgs != null) && !PmType.isTemplateParameterPack()
         && PmArgs.isTemplateParameterPack()) {
        /*const*/ TemplateTypeParmType /*P*/ TArgs = PmArgs.getType().$arrow().<TemplateTypeParmType>getAs$TemplateTypeParmType();
        if ((TArgs != null) && TArgs.getDepth() == PmType.getDepth()
           && TArgs.getIndex() == PmType.getIndex()) {
          if (SemaRef.ActiveTemplateInstantiations.empty()) {
            $c$.clean($c$.track(SemaRef.Diag(TpDecl.getLocation(), 
                diag.ext_string_literal_operator_template)));
          }
          return false;
        }
      }
    }
    
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(TpDecl.getTemplateParameters().getSourceRange().getBegin(), 
            diag.err_literal_operator_template)), 
        TpDecl.getTemplateParameters().getSourceRange()));
    return true;
  } finally {
    $c$.$destroy();
  }
}

//<editor-fold defaultstate="collapsed" desc="SearchForReturnInStmt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 13121,
 FQN="SearchForReturnInStmt", NM="_ZL21SearchForReturnInStmtRN5clang4SemaEPNS_4StmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZL21SearchForReturnInStmtRN5clang4SemaEPNS_4StmtE")
//</editor-fold>
public static void SearchForReturnInStmt(final Sema /*&*/ Self, Stmt /*P*/ S) {
  for (Stmt /*P*/ SubStmt : S.children()) {
    if (!(SubStmt != null)) {
      continue;
    }
    if (isa_ReturnStmt(SubStmt)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track(Self.Diag(SubStmt.getLocStart(), 
            diag.err_return_in_constructor_handler)));
      } finally {
        $c$.$destroy();
      }
    }
    if (!isa_Expr(SubStmt)) {
      SearchForReturnInStmt(Self, SubStmt);
    }
  }
}


/// \brief Determine whether the given declaration is a static data member.
//<editor-fold defaultstate="collapsed" desc="isStaticDataMember">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 13302,
 FQN="isStaticDataMember", NM="_ZL18isStaticDataMemberPKN5clang4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZL18isStaticDataMemberPKN5clang4DeclE")
//</editor-fold>
public static boolean isStaticDataMember(/*const*/ Decl /*P*/ D) {
  {
    /*const*/ VarDecl /*P*/ Var = dyn_cast_or_null_VarDecl(D);
    if ((Var != null)) {
      return Var.isStaticDataMember();
    }
  }
  
  return false;
}

//<editor-fold defaultstate="collapsed" desc="DelegatingCycleHelper">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp", line = 13636,
 FQN="DelegatingCycleHelper", NM="_ZL21DelegatingCycleHelperPN5clang18CXXConstructorDeclERN4llvm8SmallSetIS1_Lj4ESt4lessIS1_EEES7_S7_RNS_4SemaE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclCXX.cpp -nm=_ZL21DelegatingCycleHelperPN5clang18CXXConstructorDeclERN4llvm8SmallSetIS1_Lj4ESt4lessIS1_EEES7_S7_RNS_4SemaE")
//</editor-fold>
public static void DelegatingCycleHelper(CXXConstructorDecl /*P*/ Ctor, 
                     final SmallSetT$PLess$T$P<CXXConstructorDecl /*P*/ > /*&*/ Valid, 
                     final SmallSetT$PLess$T$P<CXXConstructorDecl /*P*/ > /*&*/ Invalid, 
                     final SmallSetT$PLess$T$P<CXXConstructorDecl /*P*/ > /*&*/ Current, 
                     final Sema /*&*/ S) {
  if (Ctor.isInvalidDecl()) {
    return;
  }
  
  CXXConstructorDecl /*P*/ Target = Ctor.getTargetConstructor();
  
  // Target may not be determinable yet, for instance if this is a dependent
  // call in an uninstantiated template.
  if ((Target != null)) {
    type$ref</*const*/ FunctionDecl /*P*/ > FNTarget = create_type$ref();
    /*J:(void)*/Target.hasBody(FNTarget);
    Target = ((/*const_cast*/CXXConstructorDecl /*P*/ )(cast_or_null_CXXConstructorDecl(FNTarget.$deref())));
  }
  
  CXXConstructorDecl /*P*/ Canonical = Ctor.getCanonicalDecl(), 
      /*P*/ TCanonical = (Target != null) ? Target.// Avoid dereferencing a null pointer here.
      getCanonicalDecl() : null;
  if (!Current.insert(Canonical).second) {
    return;
  }
  
  // We know that beyond here, we aren't chaining into a cycle.
  if (!(Target != null) || !Target.isDelegatingConstructor()
     || Target.isInvalidDecl() || (Valid.count(TCanonical) != 0)) {
    Valid.insert$T(Current.begin(), Current.end());
    Current.clear();
    // We've hit a cycle.
  } else if (TCanonical == Canonical || (Invalid.count(TCanonical) != 0)
     || (Current.count(TCanonical) != 0)) {
    // If we haven't diagnosed this cycle yet, do so now.
    if (!(Invalid.count(TCanonical) != 0)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag((Ctor.init_begin().$star()).getSourceLocation(), 
                diag.warn_delegating_ctor_cycle)), 
            Ctor));
        
        // Don't add a note for a function delegating directly to itself.
        if (TCanonical != Canonical) {
          $c$.clean($c$.track(S.Diag(Target.getLocation(), diag.note_it_delegates_to)));
        }
        
        CXXConstructorDecl /*P*/ C = Target;
        while (C.getCanonicalDecl() != Canonical) {
          type$ref</*const*/ FunctionDecl /*P*/ > FNTarget = create_type$ref();
          /*J:(void)*/C.getTargetConstructor().hasBody(FNTarget);
          assert ((FNTarget.$deref() != null)) : "Ctor cycle through bodiless function";
          
          C = ((/*const_cast*/CXXConstructorDecl /*P*/ )(cast_CXXConstructorDecl(FNTarget.$deref())));
          $c$.clean($c$.track(S.Diag(C.getLocation(), diag.note_which_delegates_to)));
        }
      } finally {
        $c$.$destroy();
      }
    }
    
    Invalid.insert$T(Current.begin(), Current.end());
    Current.clear();
  } else {
    DelegatingCycleHelper(Target, Valid, Invalid, Current, S);
  }
}

} // END OF class SemaDeclCXXStatics
