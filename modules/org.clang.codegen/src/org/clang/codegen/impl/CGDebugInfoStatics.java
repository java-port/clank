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
import static org.llvm.support.llvm.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.llvm.ir.*;
import org.clang.codegen.CodeGen.impl.*;
import org.clang.ast.DeclContext.specific_decl_iterator;
import static org.clang.ast.java.AstTypesRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import org.clang.basic.codegenoptions.*;
import org.llvm.support.dwarf.*;


//<editor-fold defaultstate="collapsed" desc="static type CGDebugInfoStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZL10getDwarfCCN5clang11CallingConvE;_ZL13getAccessFlagN5clang15AccessSpecifierEPKNS_10RecordDeclE;_ZL14hasCXXManglingPKN5clang7TagDeclEPN4llvm13DICompileUnitE;_ZL15getTagForRecordPKN5clang10RecordDeclE;_ZL20getUniqueTagTypeNamePKN5clang7TagTypeERNS_7CodeGen13CodeGenModuleEPN4llvm13DICompileUnitE;_ZL20hasDefaultGetterNamePKN5clang16ObjCPropertyDeclEPKNS_14ObjCMethodDeclE;_ZL20hasDefaultSetterNamePKN5clang16ObjCPropertyDeclEPKNS_14ObjCMethodDeclE;_ZL20isFunctionLocalClassPKN5clang13CXXRecordDeclE;_ZL20shouldOmitDefinitionN5clang14codegenoptions13DebugInfoKindEbPKNS_10RecordDeclERKNS_11LangOptionsE;_ZL22UnwrapTypeForDebugInfoN5clang8QualTypeERKNS_10ASTContextE;_ZL22isDefinedInClangModulePKN5clang10RecordDeclE;_ZL27hasExplicitMemberDefinitionN5clang11DeclContext22specific_decl_iteratorINS_13CXXMethodDeclEEES3_;_ZN12_GLOBAL__N_116BlockLayoutChunkE;_ZN12_GLOBAL__N_1ltERKNS_16BlockLayoutChunkES2_; -static-type=CGDebugInfoStatics -package=org.clang.codegen.impl")
//</editor-fold>
public final class CGDebugInfoStatics {


/// \return whether a C++ mangling exists for the type defined by TD.
//<editor-fold defaultstate="collapsed" desc="hasCXXMangling">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 668,
 FQN="hasCXXMangling", NM="_ZL14hasCXXManglingPKN5clang7TagDeclEPN4llvm13DICompileUnitE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZL14hasCXXManglingPKN5clang7TagDeclEPN4llvm13DICompileUnitE")
//</editor-fold>
public static boolean hasCXXMangling(/*const*/ TagDecl /*P*/ TD, DICompileUnit /*P*/ TheCU) {
  switch (TheCU.getSourceLanguage()) {
   case SourceLanguage.DW_LANG_C_plus_plus:
    return true;
   case SourceLanguage.DW_LANG_ObjC_plus_plus:
    return isa_CXXRecordDecl(TD) || isa_EnumDecl(TD);
   default:
    return false;
  }
}


/// In C++ mode, types have linkage, so we can rely on the ODR and
/// on their mangled names, if they're external.
//<editor-fold defaultstate="collapsed" desc="getUniqueTagTypeName">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 681,
 FQN="getUniqueTagTypeName", NM="_ZL20getUniqueTagTypeNamePKN5clang7TagTypeERNS_7CodeGen13CodeGenModuleEPN4llvm13DICompileUnitE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZL20getUniqueTagTypeNamePKN5clang7TagTypeERNS_7CodeGen13CodeGenModuleEPN4llvm13DICompileUnitE")
//</editor-fold>
public static SmallString/*256*/ getUniqueTagTypeName(/*const*/ TagType /*P*/ Ty, 
                    final CodeGenModule /*&*/ CGM, 
                    DICompileUnit /*P*/ TheCU) {
  raw_svector_ostream Out = null;
  try {
    SmallString/*256*/ FullName/*J*/= new SmallString/*256*/(256);
    /*const*/ TagDecl /*P*/ TD = Ty.getDecl();
    if (!hasCXXMangling(TD, TheCU) || !TD.isExternallyVisible()) {
      return FullName;
    }
    
    // TODO: This is using the RTTI name. Is there a better way to get
    // a unique string for a type?
    Out/*J*/= new raw_svector_ostream(FullName);
    CGM.getCXXABI().getMangleContext().mangleCXXRTTIName(new QualType(Ty, 0), Out);
    return FullName;
  } finally {
    if (Out != null) { Out.$destroy(); }
  }
}


/// \return the approproate DWARF tag for a composite type.
//<editor-fold defaultstate="collapsed" desc="getTagForRecord">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 698,
 FQN="getTagForRecord", NM="_ZL15getTagForRecordPKN5clang10RecordDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZL15getTagForRecordPKN5clang10RecordDeclE")
//</editor-fold>
public static /*Tag*//*uint16_t*/char getTagForRecord(/*const*/ RecordDecl /*P*/ RD) {
  /*Tag*//*uint16_t*/char _Tag;
  if (RD.isStruct() || RD.isInterface()) {
    _Tag = Tag.DW_TAG_structure_type;
  } else if (RD.isUnion()) {
    _Tag = Tag.DW_TAG_union_type;
  } else {
    // FIXME: This could be a struct type giving a default visibility different
    // than C++ class type, but needs llvm metadata changes first.
    assert (RD.isClass());
    _Tag = Tag.DW_TAG_class_type;
  }
  return _Tag;
}

//<editor-fold defaultstate="collapsed" desc="getDwarfCC">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 868,
 FQN="getDwarfCC", NM="_ZL10getDwarfCCN5clang11CallingConvE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZL10getDwarfCCN5clang11CallingConvE")
//</editor-fold>
public static /*uint*/int getDwarfCC(org.clang.basic.CallingConv CC) { 
  switch (CC) {
   case CC_C:
    // Avoid emitting DW_AT_calling_convention if the C convention was used.
    return 0;
   case CC_X86StdCall:
    return CallingConvention.DW_CC_BORLAND_stdcall;
   case CC_X86FastCall:
    return CallingConvention.DW_CC_BORLAND_msfastcall;
   case CC_X86ThisCall:
    return CallingConvention.DW_CC_BORLAND_thiscall;
   case CC_X86VectorCall:
    return CallingConvention.DW_CC_LLVM_vectorcall;
   case CC_X86Pascal:
    return CallingConvention.DW_CC_BORLAND_pascal;
   case CC_X86_64Win64:
   case CC_X86_64SysV:
   case CC_AAPCS:
   case CC_AAPCS_VFP:
   case CC_IntelOclBicc:
   case CC_SpirFunction:
   case CC_OpenCLKernel:
   case CC_Swift:
   case CC_PreserveMost:
   case CC_PreserveAll:
    
    // FIXME: Create new DW_CC_ codes for these calling conventions.
    return 0;
  }
  return 0;
}


/// Convert an AccessSpecifier into the corresponding DINode flag.
/// As an optimization, return 0 if the access specifier equals the
/// default for the containing type.
//<editor-fold defaultstate="collapsed" desc="getAccessFlag">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 927,
 FQN="getAccessFlag", NM="_ZL13getAccessFlagN5clang15AccessSpecifierEPKNS_10RecordDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZL13getAccessFlagN5clang15AccessSpecifierEPKNS_10RecordDeclE")
//</editor-fold>
public static /*uint*/int getAccessFlag(AccessSpecifier Access, /*const*/ RecordDecl /*P*/ RD) {
  AccessSpecifier Default = AccessSpecifier.AS_none;
  if ((RD != null) && RD.isClass()) {
    Default = AccessSpecifier.AS_private;
  } else if ((RD != null) && (RD.isStruct() || RD.isUnion())) {
    Default = AccessSpecifier.AS_public;
  }
  if (Access == Default) {
    return 0;
  }
  switch (Access) {
   case AS_private:
    return DINode.DIFlags.FlagPrivate;
   case AS_protected:
    return DINode.DIFlags.FlagProtected;
   case AS_public:
    return DINode.DIFlags.FlagPublic;
   case AS_none:
    return 0;
  }
  throw new llvm_unreachable("unexpected access enumerator");
}


/// isFunctionLocalClass - Return true if CXXRecordDecl is defined
/// inside a function.
//<editor-fold defaultstate="collapsed" desc="isFunctionLocalClass">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 1200,
 FQN="isFunctionLocalClass", NM="_ZL20isFunctionLocalClassPKN5clang13CXXRecordDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZL20isFunctionLocalClassPKN5clang13CXXRecordDeclE")
//</editor-fold>
public static boolean isFunctionLocalClass(/*const*/ CXXRecordDecl /*P*/ RD) {
  {
    /*const*/ CXXRecordDecl /*P*/ NRD = dyn_cast_CXXRecordDecl(RD.getDeclContext$Const());
    if ((NRD != null)) {
      return isFunctionLocalClass(NRD);
    }
  }
  if (isa_FunctionDecl(RD.getDeclContext$Const())) {
    return true;
  }
  return false;
}

//<editor-fold defaultstate="collapsed" desc="hasExplicitMemberDefinition">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 1624,
 FQN="hasExplicitMemberDefinition", NM="_ZL27hasExplicitMemberDefinitionN5clang11DeclContext22specific_decl_iteratorINS_13CXXMethodDeclEEES3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZL27hasExplicitMemberDefinitionN5clang11DeclContext22specific_decl_iteratorINS_13CXXMethodDeclEEES3_")
//</editor-fold>
public static boolean hasExplicitMemberDefinition(specific_decl_iterator<CXXMethodDecl> I, 
                           specific_decl_iterator<CXXMethodDecl> End) {
  for (CXXMethodDecl /*P*/ MD : llvm.make_range(new specific_decl_iterator<CXXMethodDecl>(I), new specific_decl_iterator<CXXMethodDecl>(End)))  {
    {
      FunctionDecl /*P*/ Tmpl = MD.getInstantiatedFromMemberFunction();
      if ((Tmpl != null)) {
        if (!Tmpl.isImplicit() && Tmpl.isThisDeclarationADefinition()
           && !MD.getMemberSpecializationInfo().isExplicitSpecialization()) {
          return true;
        }
      }
    }
  }
  return false;
}


/// Does a type definition exist in an imported clang module?
//<editor-fold defaultstate="collapsed" desc="isDefinedInClangModule">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 1635,
 FQN="isDefinedInClangModule", NM="_ZL22isDefinedInClangModulePKN5clang10RecordDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZL22isDefinedInClangModulePKN5clang10RecordDeclE")
//</editor-fold>
public static boolean isDefinedInClangModule(/*const*/ RecordDecl /*P*/ RD) {
  if (!(RD != null) || !RD.isFromASTFile()) {
    return false;
  }
  if (!RD.isExternallyVisible() && RD.getName().empty()) {
    return false;
  }
  {
    /*const*/ CXXRecordDecl /*P*/ CXXDecl = dyn_cast_CXXRecordDecl(RD);
    if ((CXXDecl != null)) {
      assert (CXXDecl.isCompleteDefinition()) : "incomplete record definition";
      if (CXXDecl.getTemplateSpecializationKind() != TemplateSpecializationKind.TSK_Undeclared) {
        // Make sure the instantiation is actually in a module.
        if (specific_decl_iterator.$noteq_specific_decl_iterator$SpecificDecl$C(CXXDecl.field_begin(), CXXDecl.field_end())) {
          return CXXDecl.field_begin().$arrow().isFromASTFile();
        }
      }
    }
  }
  
  return true;
}

//<editor-fold defaultstate="collapsed" desc="shouldOmitDefinition">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 1651,
 FQN="shouldOmitDefinition", NM="_ZL20shouldOmitDefinitionN5clang14codegenoptions13DebugInfoKindEbPKNS_10RecordDeclERKNS_11LangOptionsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZL20shouldOmitDefinitionN5clang14codegenoptions13DebugInfoKindEbPKNS_10RecordDeclERKNS_11LangOptionsE")
//</editor-fold>
public static boolean shouldOmitDefinition(DebugInfoKind DebugKind, 
                    boolean DebugTypeExtRefs, /*const*/ RecordDecl /*P*/ RD, 
                    final /*const*/ LangOptions /*&*/ LangOpts) {
  if (DebugTypeExtRefs && isDefinedInClangModule(RD.getDefinition())) {
    return true;
  }
  if (DebugKind.getValue() > DebugInfoKind.LimitedDebugInfo.getValue()) {
    return false;
  }
  if (!LangOpts.CPlusPlus) {
    return false;
  }
  if (!RD.isCompleteDefinitionRequired()) {
    return true;
  }
  
  /*const*/ CXXRecordDecl /*P*/ CXXDecl = dyn_cast_CXXRecordDecl(RD);
  if (!(CXXDecl != null)) {
    return false;
  }
  if (CXXDecl.hasDefinition() && CXXDecl.isDynamicClass()) {
    return true;
  }
  
  TemplateSpecializationKind Spec = TemplateSpecializationKind.TSK_Undeclared;
  {
    /*const*/ ClassTemplateSpecializationDecl /*P*/ SD = dyn_cast_ClassTemplateSpecializationDecl(RD);
    if ((SD != null)) {
      Spec = SD.getSpecializationKind();
    }
  }
  if (Spec == TemplateSpecializationKind.TSK_ExplicitInstantiationDeclaration
     && hasExplicitMemberDefinition(CXXDecl.method_begin(), 
      CXXDecl.method_end())) {
    return true;
  }
  
  return false;
}


/// \return true if Getter has the default name for the property PD.
//<editor-fold defaultstate="collapsed" desc="hasDefaultGetterName">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 1764,
 FQN="hasDefaultGetterName", NM="_ZL20hasDefaultGetterNamePKN5clang16ObjCPropertyDeclEPKNS_14ObjCMethodDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZL20hasDefaultGetterNamePKN5clang16ObjCPropertyDeclEPKNS_14ObjCMethodDeclE")
//</editor-fold>
public static boolean hasDefaultGetterName(/*const*/ ObjCPropertyDecl /*P*/ PD, 
                    /*const*/ ObjCMethodDecl /*P*/ Getter) {
  assert Native.$bool(PD);
  if (!(Getter != null)) {
    return true;
  }
  assert (Getter.getDeclName().isObjCZeroArgSelector());
  return $eq_StringRef(PD.getName(), 
      Getter.getDeclName().getObjCSelector().getNameForSlot(0));
}


/// \return true if Setter has the default name for the property PD.
//<editor-fold defaultstate="collapsed" desc="hasDefaultSetterName">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 1776,
 FQN="hasDefaultSetterName", NM="_ZL20hasDefaultSetterNamePKN5clang16ObjCPropertyDeclEPKNS_14ObjCMethodDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZL20hasDefaultSetterNamePKN5clang16ObjCPropertyDeclEPKNS_14ObjCMethodDeclE")
//</editor-fold>
public static boolean hasDefaultSetterName(/*const*/ ObjCPropertyDecl /*P*/ PD, 
                    /*const*/ ObjCMethodDecl /*P*/ Setter) {
  assert Native.$bool(PD);
  if (!(Setter != null)) {
    return true;
  }
  assert (Setter.getDeclName().isObjCOneArgSelector());
  return $eq_StringRef(SelectorTable.constructSetterName(PD.getName()).$StringRef(), 
      Setter.getDeclName().getObjCSelector().getNameForSlot(0));
}

//<editor-fold defaultstate="collapsed" desc="UnwrapTypeForDebugInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 2252,
 FQN="UnwrapTypeForDebugInfo", NM="_ZL22UnwrapTypeForDebugInfoN5clang8QualTypeERKNS_10ASTContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZL22UnwrapTypeForDebugInfoN5clang8QualTypeERKNS_10ASTContextE")
//</editor-fold>
public static QualType UnwrapTypeForDebugInfo(QualType T, final /*const*/ ASTContext /*&*/ C) {
  Qualifiers Quals/*J*/= new Qualifiers();
  do {
    Qualifiers InnerQuals = T.getLocalQualifiers();
    // Qualifiers::operator+() doesn't like it if you add a Qualifier
    // that is already there.
    Quals.$addassign(Qualifiers.removeCommonQualifiers(Quals, InnerQuals));
    Quals.$addassign(/*NO_COPY*/InnerQuals);
    QualType LastT = new QualType(T);
    switch (T.$arrow().getTypeClass()) {
     default:
      return C.getQualifiedType(T.getTypePtr(), new Qualifiers(Quals));
     case TemplateSpecialization:
      {
        /*const*/ TemplateSpecializationType /*P*/ Spec = cast_TemplateSpecializationType(T);
        if (Spec.isTypeAlias()) {
          return C.getQualifiedType(T.getTypePtr(), new Qualifiers(Quals));
        }
        T.$assignMove(Spec.desugar());
        break;
      }
     case TypeOfExpr:
      T.$assignMove(cast_TypeOfExprType(T).getUnderlyingExpr().getType());
      break;
     case TypeOf:
      T.$assignMove(cast_TypeOfType(T).getUnderlyingType());
      break;
     case Decltype:
      T.$assignMove(cast_DecltypeType(T).getUnderlyingType());
      break;
     case UnaryTransform:
      T.$assignMove(cast_UnaryTransformType(T).getUnderlyingType());
      break;
     case Attributed:
      T.$assignMove(cast_AttributedType(T).getEquivalentType());
      break;
     case Elaborated:
      T.$assignMove(cast_ElaboratedType(T).getNamedType());
      break;
     case Paren:
      T.$assignMove(cast_ParenType(T).getInnerType());
      break;
     case SubstTemplateTypeParm:
      T.$assignMove(cast_SubstTemplateTypeParmType(T).getReplacementType());
      break;
     case Auto:
      QualType DT = cast_AutoType(T).getDeducedType();
      assert (!DT.isNull()) : "Undeduced types shouldn't reach here.";
      T.$assign(DT);
      break;
    }
    assert (QualType.$noteq_QualType$C(T, LastT)) : "Type unwrapping failed to unwrap!";
    ///*J:(void)*/LastT;
  } while (true);
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BlockLayoutChunk">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 3332,
 FQN="(anonymous namespace)::BlockLayoutChunk", NM="_ZN12_GLOBAL__N_116BlockLayoutChunkE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN12_GLOBAL__N_116BlockLayoutChunkE")
//</editor-fold>
public static class/*struct*/ BlockLayoutChunk {
  public long/*uint64_t*/ OffsetInBits;
  public /*const*/ BlockDecl.Capture /*P*/ Capture;
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BlockLayoutChunk::BlockLayoutChunk">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 3332,
   FQN="(anonymous namespace)::BlockLayoutChunk::BlockLayoutChunk", NM="_ZN12_GLOBAL__N_116BlockLayoutChunkC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN12_GLOBAL__N_116BlockLayoutChunkC1Ev")
  //</editor-fold>
  public /*inline*/ BlockLayoutChunk() {
  }

  
  @Override public String toString() {
    return "" + "OffsetInBits=" + OffsetInBits // NOI18N
              + ", Capture=" + Capture; // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::operator<">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp", line = 3336,
 FQN="(anonymous namespace)::operator<", NM="_ZN12_GLOBAL__N_1ltERKNS_16BlockLayoutChunkES2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDebugInfo.cpp -nm=_ZN12_GLOBAL__N_1ltERKNS_16BlockLayoutChunkES2_")
//</editor-fold>
public static boolean $less_BlockLayoutChunk$C(final /*const*/ BlockLayoutChunk /*&*/ l, final /*const*/ BlockLayoutChunk /*&*/ r) {
  return $less_ulong(l.OffsetInBits, r.OffsetInBits);
}

} // END OF class CGDebugInfoStatics
