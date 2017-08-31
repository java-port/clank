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
package org.clang.ast.impl;

import static org.clank.support.Native.$Deref;
import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.ast.*;
import org.clang.ast.ast_type_traits.*;
import static org.clang.ast.java.AstJavaFixedRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstTypesRTTI.*;
import static org.clang.ast.QualType.$eq_QualType$C;
import org.clang.basic.target.TargetInfo;


//<editor-fold defaultstate="collapsed" desc="static type ASTContextStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=Tpl__ZL17getDynNodeFromMapRKT_RKT0_;Tpl__ZN12_GLOBAL__N_118createDynTypedNodeERKT_;_ZL14EncodeBitFieldPKN5clang10ASTContextERSsNS_8QualTypeEPKNS_9FieldDeclE;_ZL15getFloatingRankN5clang8QualTypeE;_ZL16CmpProtocolNamesPKPN5clang16ObjCProtocolDeclES3_;_ZL16CreateVaListDeclPKN5clang10ASTContextENS_10TargetInfo17BuiltinVaListKindE;_ZL16sameObjCTypeArgsRN5clang10ASTContextEPKNS_17ObjCInterfaceDeclEN4llvm8ArrayRefINS_8QualTypeEEES8_b;_ZL17DecodeTypeFromStrRPKcRKN5clang10ASTContextERNS3_19GetBuiltinTypeErrorERbb;_ZL17charUnitsToStringRKN5clang9CharUnitsE;_ZL18CreateMSVaListDeclPKN5clang10ASTContextE;_ZL18getAddressSpaceMapRKN5clang10TargetInfoERKNS_11LangOptionsE;_ZL19areSortedAndUniquedN4llvm8ArrayRefIPN5clang16ObjCProtocolDeclEEE;_ZL20addRedeclaredMethodsPKN5clang14ObjCMethodDeclERN4llvm15SmallVectorImplIPKNS_9NamedDeclEEE;_ZL20areCompatVectorTypesPKN5clang10VectorTypeES2_;_ZL20hasAnyPackExpansionsN4llvm8ArrayRefIN5clang16TemplateArgumentEEE;_ZL20mergeEnumWithIntegerRN5clang10ASTContextEPKNS_8EnumTypeENS_8QualTypeEb;_ZL21getIntegerTypeForEnumPKN5clang8EnumTypeE;_ZL21isCanonicalResultTypeN5clang8QualTypeE;_ZL21isTypeTypedefedAsBOOLN5clang8QualTypeE;_ZL22SortAndUniqueProtocolsRN4llvm15SmallVectorImplIPN5clang16ObjCProtocolDeclEEE;_ZL23ObjCEncodingForEnumTypePKN5clang10ASTContextEPKNS_8EnumTypeE;_ZL24canAssignObjCObjectTypesRN5clang10ASTContextENS_8QualTypeES2_;_ZL26NeedsInjectedClassNameTypePKN5clang10RecordDeclE;_ZL26basicGVALinkageForFunctionRKN5clang10ASTContextEPKNS_12FunctionDeclE;_ZL26basicGVALinkageForVariableRKN5clang10ASTContextEPKNS_7VarDeclE;_ZL26compareObjCProtocolsByNamePKPN5clang16ObjCProtocolDeclES3_;_ZL26getIntersectionOfProtocolsRN5clang10ASTContextEPKNS_17ObjCInterfaceDeclEPKNS_21ObjCObjectPointerTypeES7_RN4llvm15SmallVectorImplIPNS_16ObjCProtocolDeclEEE;_ZL27getConstantArrayInfoInCharsRKN5clang10ASTContextEPKNS_17ConstantArrayTypeE;_ZL28CreateCharPtrNamedVaListDeclPKN5clang10ASTContextEN4llvm9StringRefE;_ZL29adjustGVALinkageForAttributesRKN5clang10ASTContextENS_10GVALinkageEPKNS_4DeclE;_ZL29isAddrSpaceMapManglingEnabledRKN5clang10TargetInfoERKNS_11LangOptionsE;_ZL30CreateCharPtrBuiltinVaListDeclPKN5clang10ASTContextE;_ZL30CreateSystemZBuiltinVaListDeclPKN5clang10ASTContextE;_ZL30CreateVoidPtrBuiltinVaListDeclPKN5clang10ASTContextE;_ZL31CreateAAPCSABIBuiltinVaListDeclPKN5clang10ASTContextE;_ZL31CreatePNaClABIBuiltinVaListDeclPKN5clang10ASTContextE;_ZL31CreatePowerABIBuiltinVaListDeclPKN5clang10ASTContextE;_ZL31getObjCEncodingForPrimitiveKindPKN5clang10ASTContextENS_11BuiltinType4KindE;_ZL32CreateX86_64ABIBuiltinVaListDeclPKN5clang10ASTContextE;_ZL32getFunctionTypeWithExceptionSpecRN5clang10ASTContextENS_8QualTypeERKNS_17FunctionProtoType17ExceptionSpecInfoE;_ZL33CreateAArch64ABIBuiltinVaListDeclPKN5clang10ASTContextE;_ZN12_GLOBAL__N_118createDynTypedNodeIN5clang22NestedNameSpecifierLocEEENS1_15ast_type_traits12DynTypedNodeERKT_;_ZN12_GLOBAL__N_118createDynTypedNodeIN5clang7TypeLocEEENS1_15ast_type_traits12DynTypedNodeERKT_;_ZN12_GLOBAL__N_120adjustDeclToTemplateEPKN5clang4DeclE;_ZN12_GLOBAL__N_134getSingleDynTypedNodeFromParentMapEN4llvm13PointerUnion4IPKN5clang4DeclEPKNS2_4StmtEPNS2_15ast_type_traits12DynTypedNodeEPNS0_11SmallVectorISA_Lj2EEEEE; -static-type=ASTContextStatics -package=org.clang.ast.impl")
//</editor-fold>
public final class ASTContextStatics {

/// If we have a 'templated' declaration for a template, adjust 'D' to
/// refer to the actual template.
/// If we have an implicit instantiation, adjust 'D' to refer to template.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::adjustDeclToTemplate">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 264,
 FQN="(anonymous namespace)::adjustDeclToTemplate", NM="_ZN12_GLOBAL__N_120adjustDeclToTemplateEPKN5clang4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN12_GLOBAL__N_120adjustDeclToTemplateEPKN5clang4DeclE")
//</editor-fold>
public static /*const*/ Decl /*P*/ adjustDeclToTemplate(/*const*/ Decl /*P*/ D) {
  {
    /*const*/ FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(D);
    if ((FD != null)) {
      {
        // Is this function declaration part of a function template?
        /*const*/ FunctionTemplateDecl /*P*/ FTD = FD.getDescribedFunctionTemplate();
        if ((FTD != null)) {
          return FTD;
        }
      }
      
      // Nothing to do if function is not an implicit instantiation.
      if (FD.getTemplateSpecializationKind() != TemplateSpecializationKind.TSK_ImplicitInstantiation) {
        return D;
      }
      {
        
        // Function is an implicit instantiation of a function template?
        /*const*/ FunctionTemplateDecl /*P*/ FTD = FD.getPrimaryTemplate();
        if ((FTD != null)) {
          return FTD;
        }
      }
      {
        
        // Function is instantiated from a member definition of a class template?
        /*const*/ FunctionDecl /*P*/ MemberDecl = FD.getInstantiatedFromMemberFunction();
        if ((MemberDecl != null)) {
          return MemberDecl;
        }
      }
      
      return D;
    }
  }
  {
    /*const*/ VarDecl /*P*/ VD = dyn_cast_VarDecl(D);
    if ((VD != null)) {
      // Static data member is instantiated from a member definition of a class
      // template?
      if (VD.isStaticDataMember()) {
        {
          /*const*/ VarDecl /*P*/ MemberDecl = VD.getInstantiatedFromStaticDataMember();
          if ((MemberDecl != null)) {
            return MemberDecl;
          }
        }
      }
      
      return D;
    }
  }
  {
    /*const*/ CXXRecordDecl /*P*/ CRD = dyn_cast_CXXRecordDecl(D);
    if ((CRD != null)) {
      {
        // Is this class declaration part of a class template?
        /*const*/ ClassTemplateDecl /*P*/ CTD = CRD.getDescribedClassTemplate();
        if ((CTD != null)) {
          return CTD;
        }
      }
      {
        
        // Class is an implicit instantiation of a class template or partial
        // specialization?
        /*const*/ ClassTemplateSpecializationDecl /*P*/ CTSD = dyn_cast_ClassTemplateSpecializationDecl(CRD);
        if ((CTSD != null)) {
          if (CTSD.getSpecializationKind() != TemplateSpecializationKind.TSK_ImplicitInstantiation) {
            return D;
          }
          PointerUnion<ClassTemplateDecl /*P*/ , ClassTemplatePartialSpecializationDecl /*P*/ > PU = CTSD.getSpecializedTemplateOrPartial();
          return (PU.is(ClassTemplateDecl /*P*/.class) != 0) ? ((/*static_cast*//*const*/ Decl /*P*/ )(PU.get(ClassTemplateDecl /*P*/.class))) : ((/*static_cast*//*const*/ Decl /*P*/ )(PU.get(ClassTemplatePartialSpecializationDecl /*P*/.class)));
        }
      }
      {
        
        // Class is instantiated from a member definition of a class template?
        /*const*/ MemberSpecializationInfo /*P*/ Info = CRD.getMemberSpecializationInfo();
        if ((Info != null)) {
          return Info.getInstantiatedFrom();
        }
      }
      
      return D;
    }
  }
  {
    /*const*/ EnumDecl /*P*/ ED = dyn_cast_EnumDecl(D);
    if ((ED != null)) {
      {
        // Enum is instantiated from a member definition of a class template?
        /*const*/ EnumDecl /*P*/ MemberDecl = ED.getInstantiatedFromMemberEnum();
        if ((MemberDecl != null)) {
          return MemberDecl;
        }
      }
      
      return D;
    }
  }
  // FIXME: Adjust alias templates?
  return D;
}

//<editor-fold defaultstate="collapsed" desc="addRedeclaredMethods">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 404,
 FQN="addRedeclaredMethods", NM="_ZL20addRedeclaredMethodsPKN5clang14ObjCMethodDeclERN4llvm15SmallVectorImplIPKNS_9NamedDeclEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZL20addRedeclaredMethodsPKN5clang14ObjCMethodDeclERN4llvm15SmallVectorImplIPKNS_9NamedDeclEEE")
//</editor-fold>
public static void addRedeclaredMethods(/*const*/ ObjCMethodDecl /*P*/ ObjCMethod, 
                    final SmallVectorImpl</*const*/ NamedDecl /*P*/ > /*&*/ Redeclared) {
  /*const*/ DeclContext /*P*/ DC = ObjCMethod.getDeclContext$Const();
  {
    /*const*/ ObjCImplDecl /*P*/ IMD = dyn_cast_ObjCImplDecl(DC);
    if ((IMD != null)) {
      /*const*/ ObjCInterfaceDecl /*P*/ ID = IMD.getClassInterface$Const();
      if (!(ID != null)) {
        return;
      }
      // Add redeclared method here.
      for (/*const*/ ObjCCategoryDecl /*P*/ Ext : ID.known_extensions()) {
        {
          ObjCMethodDecl /*P*/ RedeclaredMethod = Ext.getMethod(ObjCMethod.getSelector(), 
              ObjCMethod.isInstanceMethod());
          if ((RedeclaredMethod != null)) {
            Redeclared.push_back(RedeclaredMethod);
          }
        }
      }
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="getAddressSpaceMap">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 696,
 FQN="getAddressSpaceMap", NM="_ZL18getAddressSpaceMapRKN5clang10TargetInfoERKNS_11LangOptionsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZL18getAddressSpaceMapRKN5clang10TargetInfoERKNS_11LangOptionsE")
//</editor-fold>
public static /*const*/LangAS.Map /*P*/ getAddressSpaceMap(final /*const*/ TargetInfo /*&*/ T, 
                  final /*const*/ LangOptions /*&*/ LOpts) {
  if (LOpts.FakeAddressSpaceMap) {
    // The fake address space map must have a distinct entry for each
    // language-specific address space.
    final/*static*/ /*const*//*uint*/int FakeAddrSpaceMap[/*7*/] = getAddressSpaceMap$$.FakeAddrSpaceMap;
    return /*AddrOf*/new LangAS.Map(FakeAddrSpaceMap);
  } else {
    return $AddrOf(T.getAddressSpaceMap());
  }
}
private static final class getAddressSpaceMap$$ {
  static final/*static*/ /*const*//*uint*/int FakeAddrSpaceMap[/*7*/] = new /*const*//*uint*/int [/*7*/] {
  1,  // opencl_global
  2,  // opencl_local
  3,  // opencl_constant
  4,  // opencl_generic
  5,  // cuda_device
  6,  // cuda_constant
  7 // cuda_shared
};
}

//<editor-fold defaultstate="collapsed" desc="isAddrSpaceMapManglingEnabled">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 716,
 FQN="isAddrSpaceMapManglingEnabled", NM="_ZL29isAddrSpaceMapManglingEnabledRKN5clang10TargetInfoERKNS_11LangOptionsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZL29isAddrSpaceMapManglingEnabledRKN5clang10TargetInfoERKNS_11LangOptionsE")
//</editor-fold>
public static boolean isAddrSpaceMapManglingEnabled(final /*const*/ TargetInfo /*&*/ TI, 
                             final /*const*/ LangOptions /*&*/ LangOpts) {
  switch (LangOpts.getAddressSpaceMapMangling()) {
   case ASMM_Target:
    return TI.useAddressSpaceMapMangling();
   case ASMM_On:
    return true;
   case ASMM_Off:
    return false;
  }
  throw new llvm_unreachable("getAddressSpaceMapMangling() doesn't cover anything.");
}


/// getConstantArrayInfoInChars - Performing the computation in CharUnits
/// instead of in bits prevents overflowing the uint64_t for some large arrays.
//<editor-fold defaultstate="collapsed" desc="getConstantArrayInfoInChars">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 1467,
 FQN="getConstantArrayInfoInChars", NM="_ZL27getConstantArrayInfoInCharsRKN5clang10ASTContextEPKNS_17ConstantArrayTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZL27getConstantArrayInfoInCharsRKN5clang10ASTContextEPKNS_17ConstantArrayTypeE")
//</editor-fold>
public static std.pairTypeType<CharUnits, CharUnits> getConstantArrayInfoInChars(final /*const*/ ASTContext /*&*/ Context, 
                           /*const*/ ConstantArrayType /*P*/ CAT) {
  std.pair<CharUnits, CharUnits> EltInfo = Context.getTypeInfoInChars(CAT.getElementType());
  long/*uint64_t*/ Size = CAT.getSize().getZExtValue();
  assert ((Size == 0 || $lesseq_ulong_ullong(((/*static_cast*/long/*uint64_t*/)(EltInfo.first.getQuantity())), $div_ulong((long/*uint64_t*/)$int2ulong((-1)), Size)))) : "Overflow in array type char size evaluation";
  long/*uint64_t*/ Width = EltInfo.first.getQuantity() * Size;
  /*uint*/int Align = $long2uint(EltInfo.second.getQuantity());
  if (!Context.getTargetInfo().getCXXABI().isMicrosoft()
     || Context.getTargetInfo().getPointerWidth(0) == 64) {
    Width = llvm.alignTo(Width, $uint2ulong(Align));
  }
  return std.make_pair(CharUnits.fromQuantity(Width), 
      CharUnits.fromQuantity($uint2long(Align)));
}


/// Get a function type and produce the equivalent function type with the
/// specified exception specification. Type sugar that can be present on a
/// declaration of a function with an exception specification is permitted
/// and preserved. Other type sugar (for instance, typedefs) is not.
//<editor-fold defaultstate="collapsed" desc="getFunctionTypeWithExceptionSpec">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 2263,
 FQN="getFunctionTypeWithExceptionSpec", NM="_ZL32getFunctionTypeWithExceptionSpecRN5clang10ASTContextENS_8QualTypeERKNS_17FunctionProtoType17ExceptionSpecInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZL32getFunctionTypeWithExceptionSpecRN5clang10ASTContextENS_8QualTypeERKNS_17FunctionProtoType17ExceptionSpecInfoE")
//</editor-fold>
public static QualType getFunctionTypeWithExceptionSpec(final ASTContext /*&*/ Context, QualType Orig, 
                                final /*const*/ FunctionProtoType.ExceptionSpecInfo /*&*/ ESI) {
  {
    // Might have some parens.
    /*const*/ ParenType /*P*/ PT = dyn_cast_ParenType(Orig);
    if ((PT != null)) {
      return Context.getParenType(getFunctionTypeWithExceptionSpec(Context, PT.getInnerType(), ESI));
    }
  }
  {
    
    // Might have a calling-convention attribute.
    /*const*/ AttributedType /*P*/ AT = dyn_cast_AttributedType(Orig);
    if ((AT != null)) {
      return Context.getAttributedType(AT.getAttrKind(), 
          getFunctionTypeWithExceptionSpec(Context, AT.getModifiedType(), ESI), 
          getFunctionTypeWithExceptionSpec(Context, AT.getEquivalentType(), 
              ESI));
    }
  }
  
  // Anything else must be a function type. Rebuild it with the new exception
  // specification.
  /*const*/ FunctionProtoType /*P*/ Proto = cast_FunctionProtoType(Orig);
  return Context.getFunctionType(Proto.getReturnType(), Proto.getParamTypes(), 
      Proto.getExtProtoInfo().withExceptionSpec(ESI));
}


/// \brief Determine whether \p T is canonical as the result type of a function.
//<editor-fold defaultstate="collapsed" desc="isCanonicalResultType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 2988,
 FQN="isCanonicalResultType", NM="_ZL21isCanonicalResultTypeN5clang8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZL21isCanonicalResultTypeN5clang8QualTypeE")
//</editor-fold>
public static boolean isCanonicalResultType(QualType T) {
  return T.isCanonical()
     && (T.getObjCLifetime() == Qualifiers.ObjCLifetime.OCL_None
     || T.getObjCLifetime() == Qualifiers.ObjCLifetime.OCL_ExplicitNone);
}

//<editor-fold defaultstate="collapsed" desc="NeedsInjectedClassNameType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 3155,
 FQN="NeedsInjectedClassNameType", NM="_ZL26NeedsInjectedClassNameTypePKN5clang10RecordDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZL26NeedsInjectedClassNameTypePKN5clang10RecordDeclE")
//</editor-fold>
public static boolean NeedsInjectedClassNameType(/*const*/ RecordDecl /*P*/ D) {
  if (!isa_CXXRecordDecl(D)) {
    return false;
  }
  /*const*/ CXXRecordDecl /*P*/ RD = cast_CXXRecordDecl(D);
  if (isa_ClassTemplatePartialSpecializationDecl(RD)) {
    return true;
  }
  if ((RD.getDescribedClassTemplate() != null)
     && !isa_ClassTemplateSpecializationDecl(RD)) {
    return true;
  }
  return false;
}

//<editor-fold defaultstate="collapsed" desc="hasAnyPackExpansions">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 3406,
 FQN="hasAnyPackExpansions", NM="_ZL20hasAnyPackExpansionsN4llvm8ArrayRefIN5clang16TemplateArgumentEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZL20hasAnyPackExpansionsN4llvm8ArrayRefIN5clang16TemplateArgumentEEE")
//</editor-fold>
public static boolean hasAnyPackExpansions(ArrayRef<TemplateArgument> Args) {
  for (final /*const*/ TemplateArgument /*&*/ Arg : Args)  {
    if (Arg.isPackExpansion()) {
      return true;
    }
  }
  
  return true;
}


/// CmpProtocolNames - Comparison predicate for sorting protocols
/// alphabetically.
//<editor-fold defaultstate="collapsed" desc="CmpProtocolNames">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 3681,
 FQN="CmpProtocolNames", NM="_ZL16CmpProtocolNamesPKPN5clang16ObjCProtocolDeclES3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZL16CmpProtocolNamesPKPN5clang16ObjCProtocolDeclES3_")
//</editor-fold>
public static int CmpProtocolNames(type$ptr<ObjCProtocolDecl/*P const*/>/*P*/ LHS, 
                type$ptr<ObjCProtocolDecl/*P const*/>/*P*/ RHS) {
  return DeclarationName.compare((LHS.$star()).getDeclName(), (RHS.$star()).getDeclName());
}
@Converted(kind = Converted.Kind.MANUAL_DUPLICATED)
public static int CmpProtocolNames_2(ObjCProtocolDecl/*P const*/ LHS, 
                ObjCProtocolDecl/*P const*/ RHS) {
  return DeclarationName.compare(LHS.getDeclName(), RHS.getDeclName());
}

//<editor-fold defaultstate="collapsed" desc="areSortedAndUniqued">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 3686,
 FQN="areSortedAndUniqued", NM="_ZL19areSortedAndUniquedN4llvm8ArrayRefIPN5clang16ObjCProtocolDeclEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZL19areSortedAndUniquedN4llvm8ArrayRefIPN5clang16ObjCProtocolDeclEEE")
//</editor-fold>
public static boolean areSortedAndUniqued(ArrayRef<ObjCProtocolDecl /*P*/ > Protocols) {
  if (Protocols.empty()) {
    return true;
  }
  if (Protocols.$at(0).getCanonicalDecl() != Protocols.$at(0)) {
    return false;
  }
  
  for (/*uint*/int i = 1; i != Protocols.size(); ++i)  {
    if (CmpProtocolNames($AddrOf(Protocols.ptr$at(i - 1)), $AddrOf(Protocols.ptr$at(i))) >= 0
       || Protocols.$at(i).getCanonicalDecl() != Protocols.$at(i)) {
      return false;
    }
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="SortAndUniqueProtocols">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 3699,
 FQN="SortAndUniqueProtocols", NM="_ZL22SortAndUniqueProtocolsRN4llvm15SmallVectorImplIPN5clang16ObjCProtocolDeclEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZL22SortAndUniqueProtocolsRN4llvm15SmallVectorImplIPN5clang16ObjCProtocolDeclEEE")
//</editor-fold>
public static void SortAndUniqueProtocols(final SmallVectorImpl<ObjCProtocolDecl /*P*/ > /*&*/ Protocols) {
  // Sort protocols, keyed by name.
  llvm.array_pod_sort(Protocols.begin(), Protocols.end(), /*FuncRef*/ASTContextStatics::CmpProtocolNames_2);
  
  // Canonicalize.
  for(int i = 0; i < Protocols.size(); i++) {
  //for (final type$ptr<ObjCProtocolDecl /*P*/ /*&*/> P : Protocols)  {
    final type$ptr<ObjCProtocolDecl /*P*/ /*&*/> P = Protocols.ptr$at(i);
    P.$set(P.$star().getCanonicalDecl());
  }
  
  // Remove duplicates.
  type$ptr<ObjCProtocolDecl /*P*/ /*P*/> ProtocolsEnd = $tryClone(std.unique$ptr(Protocols.begin(), Protocols.end()));
  Protocols.erase(ProtocolsEnd, Protocols.end());
}


/// getFloatingRank - Return a relative rank for floating point types.
/// This routine will assert if passed a built-in type that isn't a float.
//<editor-fold defaultstate="collapsed" desc="getFloatingRank">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 4628,
 FQN="getFloatingRank", NM="_ZL15getFloatingRankN5clang8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZL15getFloatingRankN5clang8QualTypeE")
//</editor-fold>
public static FloatingRank getFloatingRank(QualType T) {
  {
    /*const*/ ComplexType /*P*/ CT = T.$arrow().getAs(ComplexType.class);
    if ((CT != null)) {
      return getFloatingRank(CT.getElementType());
    }
  }
  assert ((T.$arrow().<BuiltinType>getAs$BuiltinType() != null)) : "getFloatingRank(): not a floating type";
  switch (T.$arrow().<BuiltinType>getAs$BuiltinType().getKind()) {
   default:
    throw new llvm_unreachable("getFloatingRank(): not a floating type");
   case Half:
    return FloatingRank.HalfRank;
   case Float:
    return FloatingRank.FloatRank;
   case Double:
    return FloatingRank.DoubleRank;
   case LongDouble:
    return FloatingRank.LongDoubleRank;
   case Float128:
    return FloatingRank.Float128Rank;
  }
}

//<editor-fold defaultstate="collapsed" desc="getIntegerTypeForEnum">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 4831,
 FQN="getIntegerTypeForEnum", NM="_ZL21getIntegerTypeForEnumPKN5clang8EnumTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZL21getIntegerTypeForEnumPKN5clang8EnumTypeE")
//</editor-fold>
public static /*const*/ Type /*P*/ getIntegerTypeForEnum(/*const*/ EnumType /*P*/ ET) {
  // Incomplete enum types are not treated as integer types.
  // FIXME: In C++, enum types are never integer types.
  if (ET.getDecl().isComplete() && !ET.getDecl().isScoped()) {
    return ET.getDecl().getIntegerType().getTypePtr();
  }
  return null;
}


// This returns true if a type has been typedefed to BOOL:
// typedef <type> BOOL;
//<editor-fold defaultstate="collapsed" desc="isTypeTypedefedAsBOOL">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 5110,
 FQN="isTypeTypedefedAsBOOL", NM="_ZL21isTypeTypedefedAsBOOLN5clang8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZL21isTypeTypedefedAsBOOLN5clang8QualTypeE")
//</editor-fold>
public static boolean isTypeTypedefedAsBOOL(QualType T) {
  {
    /*const*/ TypedefType /*P*/ TT = dyn_cast_TypedefType(T);
    if ((TT != null)) {
      {
        IdentifierInfo /*P*/ II = TT.getDecl().getIdentifier();
        if ((II != null)) {
          return II.isStr(/*KEEP_STR*/"BOOL");
        }
      }
    }
  }
  
  return false;
}

//<editor-fold defaultstate="collapsed" desc="charUnitsToString">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 5163,
 FQN="charUnitsToString", NM="_ZL17charUnitsToStringRKN5clang9CharUnitsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZL17charUnitsToStringRKN5clang9CharUnitsE")
//</editor-fold>
public static /*inline*/ std.string charUnitsToString(final /*const*/ CharUnits /*&*/ CU) {
  return llvm.itostr(CU.getQuantity());
}

//<editor-fold defaultstate="collapsed" desc="getObjCEncodingForPrimitiveKind">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 5487,
 FQN="getObjCEncodingForPrimitiveKind", NM="_ZL31getObjCEncodingForPrimitiveKindPKN5clang10ASTContextENS_11BuiltinType4KindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZL31getObjCEncodingForPrimitiveKindPKN5clang10ASTContextENS_11BuiltinType4KindE")
//</editor-fold>
public static /*char*/byte getObjCEncodingForPrimitiveKind(/*const*/ ASTContext /*P*/ C, 
                               BuiltinType.Kind kind) {
  switch (kind) {
   case Void:
    return $$v;
   case Bool:
    return $$B;
   case Char_U:
   case UChar:
    return $$C;
   case Char16:
   case UShort:
    return $$S;
   case Char32:
   case UInt:
    return $$I;
   case ULong:
    return C.getTargetInfo().getLongWidth() == 32 ? $$L : $$Q;
   case UInt128:
    return $$T;
   case ULongLong:
    return $$Q;
   case Char_S:
   case SChar:
    return $$c;
   case Short:
    return $$s;
   case WChar_S:
   case WChar_U:
   case Int:
    return $$i;
   case Long:
    return C.getTargetInfo().getLongWidth() == 32 ? $$l : $$q;
   case LongLong:
    return $$q;
   case Int128:
    return $$t;
   case Float:
    return $$f;
   case Double:
    return $$d;
   case LongDouble:
    return $$D;
   case NullPtr:
    return $$STAR; // like char*
   case Float128:
   case Half:
    // FIXME: potentially need @encodes for these!
    return $$SPACE;
   case ObjCId:
   case ObjCClass:
   case ObjCSel:
    throw new llvm_unreachable("@encoding ObjC primitive type");
   case OCLImage1dRO:
   case OCLImage1dArrayRO:
   case OCLImage1dBufferRO:
   case OCLImage2dRO:
   case OCLImage2dArrayRO:
   case OCLImage2dDepthRO:
   case OCLImage2dArrayDepthRO:
   case OCLImage2dMSAARO:
   case OCLImage2dArrayMSAARO:
   case OCLImage2dMSAADepthRO:
   case OCLImage2dArrayMSAADepthRO:
   case OCLImage3dRO:
   case OCLImage1dWO:
   case OCLImage1dArrayWO:
   case OCLImage1dBufferWO:
   case OCLImage2dWO:
   case OCLImage2dArrayWO:
   case OCLImage2dDepthWO:
   case OCLImage2dArrayDepthWO:
   case OCLImage2dMSAAWO:
   case OCLImage2dArrayMSAAWO:
   case OCLImage2dMSAADepthWO:
   case OCLImage2dArrayMSAADepthWO:
   case OCLImage3dWO:
   case OCLImage1dRW:
   case OCLImage1dArrayRW:
   case OCLImage1dBufferRW:
   case OCLImage2dRW:
   case OCLImage2dArrayRW:
   case OCLImage2dDepthRW:
   case OCLImage2dArrayDepthRW:
   case OCLImage2dMSAARW:
   case OCLImage2dArrayMSAARW:
   case OCLImage2dMSAADepthRW:
   case OCLImage2dArrayMSAADepthRW:
   case OCLImage3dRW:
   case OCLEvent:
   case OCLClkEvent:
   case OCLQueue:
   case OCLNDRange:
   case OCLReserveID:
   case OCLSampler:
   case Dependent:
   case Overload:
   case BoundMember:
   case PseudoObject:
   case UnknownAny:
   case BuiltinFn:
   case ARCUnbridgedCast:
   case OMPArraySection:
    throw new llvm_unreachable("invalid builtin type for @encode");
  }
  throw new llvm_unreachable("invalid BuiltinType::Kind value");
}

//<editor-fold defaultstate="collapsed" desc="ObjCEncodingForEnumType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 5547,
 FQN="ObjCEncodingForEnumType", NM="_ZL23ObjCEncodingForEnumTypePKN5clang10ASTContextEPKNS_8EnumTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZL23ObjCEncodingForEnumTypePKN5clang10ASTContextEPKNS_8EnumTypeE")
//</editor-fold>
public static /*char*/byte ObjCEncodingForEnumType(/*const*/ ASTContext /*P*/ C, /*const*/ EnumType /*P*/ ET) {
  EnumDecl /*P*/ Enum = ET.getDecl();
  
  // The encoding of an non-fixed enum type is always 'i', regardless of size.
  if (!Enum.isFixed()) {
    return $$i;
  }
  
  // The encoding of a fixed enum type matches its fixed underlying type.
  /*const*/ BuiltinType /*P*/ BT = Enum.getIntegerType().$arrow().<BuiltinType>castAs$BuiltinType();
  return getObjCEncodingForPrimitiveKind(C, BT.getKind());
}

//<editor-fold defaultstate="collapsed" desc="EncodeBitField">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 5559,
 FQN="EncodeBitField", NM="_ZL14EncodeBitFieldPKN5clang10ASTContextERSsNS_8QualTypeEPKNS_9FieldDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZL14EncodeBitFieldPKN5clang10ASTContextERSsNS_8QualTypeEPKNS_9FieldDeclE")
//</editor-fold>
public static void EncodeBitField(/*const*/ ASTContext /*P*/ Ctx, final std.string/*&*/ S, 
              QualType T, /*const*/ FieldDecl /*P*/ FD) {
  assert (FD.isBitField()) : "not a bitfield - getObjCEncodingForTypeImpl";
  S.$addassign_T($$b);
  // The NeXT runtime encodes bit fields as b followed by the number of bits.
  // The GNU runtime requires more information; bitfields are encoded as b,
  // then the offset (in bits) of the first element, then the type of the
  // bitfield, then the size in bits.  For example, in this structure:
  //
  // struct
  // {
  //    int integer;
  //    int flags:2;
  // };
  // On a 32-bit system, the encoding for flags would be b2 for the NeXT
  // runtime, but b32i2 for the GNU runtime.  The reason for this extra
  // information is not especially sensible, but we're stuck with it for
  // compatibility with GCC, although providing it breaks anything that
  // actually uses runtime introspection and wants to work on both runtimes...
  if (Ctx.getLangOpts().ObjCRuntime.isGNUFamily()) {
    /*const*/ RecordDecl /*P*/ RD = FD.getParent$Const();
    final /*const*/ ASTRecordLayout /*&*/ RL = Ctx.getASTRecordLayout(RD);
    S.$addassign(llvm.utostr(RL.getFieldOffset(FD.getFieldIndex())));
    {
      /*const*/ EnumType /*P*/ ET = T.$arrow().<EnumType>getAs$EnumType();
      if ((ET != null)) {
        S.$addassign_T(ObjCEncodingForEnumType(Ctx, ET));
      } else {
        /*const*/ BuiltinType /*P*/ BT = T.$arrow().<BuiltinType>castAs$BuiltinType();
        S.$addassign_T(getObjCEncodingForPrimitiveKind(Ctx, BT.getKind()));
      }
    }
  }
  S.$addassign(llvm.utostr($uint2ulong(FD.getBitWidthValue($Deref(Ctx)))));
}


//===----------------------------------------------------------------------===//
// __builtin_va_list Construction Functions
//===----------------------------------------------------------------------===//
//<editor-fold defaultstate="collapsed" desc="CreateCharPtrNamedVaListDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 6167,
 FQN="CreateCharPtrNamedVaListDecl", NM="_ZL28CreateCharPtrNamedVaListDeclPKN5clang10ASTContextEN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZL28CreateCharPtrNamedVaListDeclPKN5clang10ASTContextEN4llvm9StringRefE")
//</editor-fold>
public static TypedefDecl /*P*/ CreateCharPtrNamedVaListDecl(/*const*/ ASTContext /*P*/ Context, 
                            StringRef Name) {
  // typedef char* __builtin[_ms]_va_list;
  QualType T = Context.getPointerType(new CanQual<Type>(Context.CharTy)).$QualType();
  return Context.buildImplicitTypedef(new QualType(T), new StringRef(Name));
}

//<editor-fold defaultstate="collapsed" desc="CreateMSVaListDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 6174,
 FQN="CreateMSVaListDecl", NM="_ZL18CreateMSVaListDeclPKN5clang10ASTContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZL18CreateMSVaListDeclPKN5clang10ASTContextE")
//</editor-fold>
public static TypedefDecl /*P*/ CreateMSVaListDecl(/*const*/ ASTContext /*P*/ Context) {
  return CreateCharPtrNamedVaListDecl(Context, new StringRef(/*KEEP_STR*/"__builtin_ms_va_list"));
}

//<editor-fold defaultstate="collapsed" desc="CreateCharPtrBuiltinVaListDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 6178,
 FQN="CreateCharPtrBuiltinVaListDecl", NM="_ZL30CreateCharPtrBuiltinVaListDeclPKN5clang10ASTContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZL30CreateCharPtrBuiltinVaListDeclPKN5clang10ASTContextE")
//</editor-fold>
public static TypedefDecl /*P*/ CreateCharPtrBuiltinVaListDecl(/*const*/ ASTContext /*P*/ Context) {
  return CreateCharPtrNamedVaListDecl(Context, new StringRef(/*KEEP_STR*/"__builtin_va_list"));
}

//<editor-fold defaultstate="collapsed" desc="CreateVoidPtrBuiltinVaListDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 6182,
 FQN="CreateVoidPtrBuiltinVaListDecl", NM="_ZL30CreateVoidPtrBuiltinVaListDeclPKN5clang10ASTContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZL30CreateVoidPtrBuiltinVaListDeclPKN5clang10ASTContextE")
//</editor-fold>
public static TypedefDecl /*P*/ CreateVoidPtrBuiltinVaListDecl(/*const*/ ASTContext /*P*/ Context) {
  // typedef void* __builtin_va_list;
  QualType T = Context.getPointerType(new CanQual<Type>(Context.VoidTy)).$QualType();
  return Context.buildImplicitTypedef(new QualType(T), new StringRef(/*KEEP_STR*/"__builtin_va_list"));
}

//<editor-fold defaultstate="collapsed" desc="CreateAArch64ABIBuiltinVaListDecl">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 6188,
 FQN="CreateAArch64ABIBuiltinVaListDecl", NM="_ZL33CreateAArch64ABIBuiltinVaListDeclPKN5clang10ASTContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZL33CreateAArch64ABIBuiltinVaListDeclPKN5clang10ASTContextE")
//</editor-fold>
public static TypedefDecl /*P*/ CreateAArch64ABIBuiltinVaListDecl(/*const*/ ASTContext /*P*/ Context) {
  // struct __va_list
  RecordDecl /*P*/ VaListTagDecl = Context.buildImplicitRecord(new StringRef(/*KEEP_STR*/"__va_list"));
  if (Context.getLangOpts().CPlusPlus) {
    // namespace std { struct __va_list {
    NamespaceDecl /*P*/ NS;
    NS = NamespaceDecl.Create(((/*const_cast*/ASTContext /*&*/ )($Deref(Context))), 
        Context.getTranslationUnitDecl(), 
        /*Inline*/ false, new SourceLocation(), 
        new SourceLocation(), $AddrOf(Context.Idents.get(new StringRef(/*KEEP_STR*/"std"))), 
        /*PrevDecl*/ (NamespaceDecl /*P*/ )null);
    NS.setImplicit();
    VaListTagDecl.setDeclContext(NS);
  }
  
  VaListTagDecl.startDefinition();
  
  /*const*//*size_t*/int NumFields = 5;
  QualType FieldTypes[/*5*/]/*J*/= new$T(new QualType [5], ()->new QualType());
  /*const*/char$ptr/*char P*/ FieldNames[/*5*/] = new char$ptr[5];
  
  // void *__stack;
  FieldTypes[0].$assignMove(Context.getPointerType(new CanQual<Type>(Context.VoidTy)).$QualType());
  FieldNames[0]=$("__stack");
  
  // void *__gr_top;
  FieldTypes[1].$assignMove(Context.getPointerType(new CanQual<Type>(Context.VoidTy)).$QualType());
  FieldNames[1]=$("__gr_top");
  
  // void *__vr_top;
  FieldTypes[2].$assignMove(Context.getPointerType(new CanQual<Type>(Context.VoidTy)).$QualType());
  FieldNames[2]=$("__vr_top");
  
  // int __gr_offs;
  FieldTypes[3].$assignMove(Context.IntTy.$QualType());
  FieldNames[3]=$("__gr_offs");
  
  // int __vr_offs;
  FieldTypes[4].$assignMove(Context.IntTy.$QualType());
  FieldNames[4]=$("__vr_offs");
  
  // Create fields
  for (/*uint*/int i = 0; $less_uint(i, NumFields); ++i) {
    FieldDecl /*P*/ Field = FieldDecl.Create(((/*const_cast*/ASTContext /*&*/ )($Deref(Context))), 
        VaListTagDecl, 
        new SourceLocation(), 
        new SourceLocation(), 
        $AddrOf(Context.Idents.get(new StringRef(FieldNames[i]))), 
        new QualType(FieldTypes[i]), /*TInfo=*/ (TypeSourceInfo /*P*/ )null, 
        /*BitWidth=*/ (Expr /*P*/ )null, 
        /*Mutable=*/ false, 
        InClassInitStyle.ICIS_NoInit);
    Field.setAccess(AccessSpecifier.AS_public);
    VaListTagDecl.addDecl(Field);
  }
  VaListTagDecl.completeDefinition();
  Context.VaListTagDecl = VaListTagDecl;
  QualType VaListTagType = Context.getRecordType(VaListTagDecl);
  
  // } __builtin_va_list;
  return Context.buildImplicitTypedef(new QualType(VaListTagType), new StringRef(/*KEEP_STR*/"__builtin_va_list"));
}

//<editor-fold defaultstate="collapsed" desc="CreatePowerABIBuiltinVaListDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 6252,
 FQN="CreatePowerABIBuiltinVaListDecl", NM="_ZL31CreatePowerABIBuiltinVaListDeclPKN5clang10ASTContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZL31CreatePowerABIBuiltinVaListDeclPKN5clang10ASTContextE")
//</editor-fold>
public static TypedefDecl /*P*/ CreatePowerABIBuiltinVaListDecl(/*const*/ ASTContext /*P*/ Context) {
  // typedef struct __va_list_tag {
  RecordDecl /*P*/ VaListTagDecl;
  
  VaListTagDecl = Context.buildImplicitRecord(new StringRef(/*KEEP_STR*/"__va_list_tag"));
  VaListTagDecl.startDefinition();
  
  /*const*//*size_t*/int NumFields = 5;
  QualType FieldTypes[/*5*/]/*J*/= new$T(new QualType [5], ()->new QualType());
  /*const*/char$ptr/*char P*/ FieldNames[/*5*/] = new char$ptr[5];
  
  //   unsigned char gpr;
  FieldTypes[0].$assignMove(Context.UnsignedCharTy.$QualType());
  FieldNames[0]=$("gpr");
  
  //   unsigned char fpr;
  FieldTypes[1].$assignMove(Context.UnsignedCharTy.$QualType());
  FieldNames[1]=$("fpr");
  
  //   unsigned short reserved;
  FieldTypes[2].$assignMove(Context.UnsignedShortTy.$QualType());
  FieldNames[2]=$("reserved");
  
  //   void* overflow_arg_area;
  FieldTypes[3].$assignMove(Context.getPointerType(new CanQual<Type>(Context.VoidTy)).$QualType());
  FieldNames[3]=$("overflow_arg_area");
  
  //   void* reg_save_area;
  FieldTypes[4].$assignMove(Context.getPointerType(new CanQual<Type>(Context.VoidTy)).$QualType());
  FieldNames[4]=$("reg_save_area");
  
  // Create fields
  for (/*uint*/int i = 0; $less_uint(i, NumFields); ++i) {
    FieldDecl /*P*/ Field = FieldDecl.Create($Deref(Context), VaListTagDecl, 
        new SourceLocation(), 
        new SourceLocation(), 
        $AddrOf(Context.Idents.get(new StringRef(FieldNames[i]))), 
        new QualType(FieldTypes[i]), /*TInfo=*/ (TypeSourceInfo /*P*/ )null, 
        /*BitWidth=*/ (Expr /*P*/ )null, 
        /*Mutable=*/ false, 
        InClassInitStyle.ICIS_NoInit);
    Field.setAccess(AccessSpecifier.AS_public);
    VaListTagDecl.addDecl(Field);
  }
  VaListTagDecl.completeDefinition();
  Context.VaListTagDecl = VaListTagDecl;
  QualType VaListTagType = Context.getRecordType(VaListTagDecl);
  
  // } __va_list_tag;
  TypedefDecl /*P*/ VaListTagTypedefDecl = Context.buildImplicitTypedef(new QualType(VaListTagType), new StringRef(/*KEEP_STR*/"__va_list_tag"));
  
  QualType VaListTagTypedefType = Context.getTypedefType(VaListTagTypedefDecl);
  
  // typedef __va_list_tag __builtin_va_list[1];
  APInt Size/*J*/= new APInt($ulong2uint(Context.getTypeSize(Context.getSizeType().$QualType())), 1);
  QualType VaListTagArrayType = Context.getConstantArrayType(new QualType(VaListTagTypedefType), 
      Size, ArrayType.ArraySizeModifier.Normal, 0);
  return Context.buildImplicitTypedef(new QualType(VaListTagArrayType), new StringRef(/*KEEP_STR*/"__builtin_va_list"));
}

//<editor-fold defaultstate="collapsed" desc="CreateX86_64ABIBuiltinVaListDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 6315,
 FQN="CreateX86_64ABIBuiltinVaListDecl", NM="_ZL32CreateX86_64ABIBuiltinVaListDeclPKN5clang10ASTContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZL32CreateX86_64ABIBuiltinVaListDeclPKN5clang10ASTContextE")
//</editor-fold>
public static TypedefDecl /*P*/ CreateX86_64ABIBuiltinVaListDecl(/*const*/ ASTContext /*P*/ Context) {
  // struct __va_list_tag {
  RecordDecl /*P*/ VaListTagDecl;
  VaListTagDecl = Context.buildImplicitRecord(new StringRef(/*KEEP_STR*/"__va_list_tag"));
  VaListTagDecl.startDefinition();
  
  /*const*//*size_t*/int NumFields = 4;
  QualType FieldTypes[/*4*/]/*J*/= new$T(new QualType [4], ()->new QualType());
  /*const*/char$ptr/*char P*/ FieldNames[/*4*/] = new char$ptr[4];
  
  //   unsigned gp_offset;
  FieldTypes[0].$assignMove(Context.UnsignedIntTy.$QualType());
  FieldNames[0]=$("gp_offset");
  
  //   unsigned fp_offset;
  FieldTypes[1].$assignMove(Context.UnsignedIntTy.$QualType());
  FieldNames[1]=$("fp_offset");
  
  //   void* overflow_arg_area;
  FieldTypes[2].$assignMove(Context.getPointerType(new CanQual<Type>(Context.VoidTy)).$QualType());
  FieldNames[2]=$("overflow_arg_area");
  
  //   void* reg_save_area;
  FieldTypes[3].$assignMove(Context.getPointerType(new CanQual<Type>(Context.VoidTy)).$QualType());
  FieldNames[3]=$("reg_save_area");
  
  // Create fields
  for (/*uint*/int i = 0; $less_uint(i, NumFields); ++i) {
    FieldDecl /*P*/ Field = FieldDecl.Create(((/*const_cast*/ASTContext /*&*/ )($Deref(Context))), 
        VaListTagDecl, 
        new SourceLocation(), 
        new SourceLocation(), 
        $AddrOf(Context.Idents.get(new StringRef(FieldNames[i]))), 
        new QualType(FieldTypes[i]), /*TInfo=*/ (TypeSourceInfo /*P*/ )null, 
        /*BitWidth=*/ (Expr /*P*/ )null, 
        /*Mutable=*/ false, 
        InClassInitStyle.ICIS_NoInit);
    Field.setAccess(AccessSpecifier.AS_public);
    VaListTagDecl.addDecl(Field);
  }
  VaListTagDecl.completeDefinition();
  Context.VaListTagDecl = VaListTagDecl;
  QualType VaListTagType = Context.getRecordType(VaListTagDecl);
  
  // };
  
  // typedef struct __va_list_tag __builtin_va_list[1];
  APInt Size/*J*/= new APInt($ulong2uint(Context.getTypeSize(Context.getSizeType().$QualType())), 1);
  QualType VaListTagArrayType = Context.getConstantArrayType(new QualType(VaListTagType), Size, ArrayType.ArraySizeModifier.Normal, 0);
  return Context.buildImplicitTypedef(new QualType(VaListTagArrayType), new StringRef(/*KEEP_STR*/"__builtin_va_list"));
}

//<editor-fold defaultstate="collapsed" desc="CreatePNaClABIBuiltinVaListDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 6369,
 FQN="CreatePNaClABIBuiltinVaListDecl", NM="_ZL31CreatePNaClABIBuiltinVaListDeclPKN5clang10ASTContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZL31CreatePNaClABIBuiltinVaListDeclPKN5clang10ASTContextE")
//</editor-fold>
public static TypedefDecl /*P*/ CreatePNaClABIBuiltinVaListDecl(/*const*/ ASTContext /*P*/ Context) {
  // typedef int __builtin_va_list[4];
  APInt Size/*J*/= new APInt($ulong2uint(Context.getTypeSize(Context.getSizeType().$QualType())), 4);
  QualType IntArrayType = Context.getConstantArrayType(Context.IntTy.$QualType(), 
      Size, ArrayType.ArraySizeModifier.Normal, 0);
  return Context.buildImplicitTypedef(new QualType(IntArrayType), new StringRef(/*KEEP_STR*/"__builtin_va_list"));
}

//<editor-fold defaultstate="collapsed" desc="CreateAAPCSABIBuiltinVaListDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 6378,
 FQN="CreateAAPCSABIBuiltinVaListDecl", NM="_ZL31CreateAAPCSABIBuiltinVaListDeclPKN5clang10ASTContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZL31CreateAAPCSABIBuiltinVaListDeclPKN5clang10ASTContextE")
//</editor-fold>
public static TypedefDecl /*P*/ CreateAAPCSABIBuiltinVaListDecl(/*const*/ ASTContext /*P*/ Context) {
  // struct __va_list
  RecordDecl /*P*/ VaListDecl = Context.buildImplicitRecord(new StringRef(/*KEEP_STR*/"__va_list"));
  if (Context.getLangOpts().CPlusPlus) {
    // namespace std { struct __va_list {
    NamespaceDecl /*P*/ NS;
    NS = NamespaceDecl.Create(((/*const_cast*/ASTContext /*&*/ )($Deref(Context))), 
        Context.getTranslationUnitDecl(), 
        /*Inline*/ false, new SourceLocation(), 
        new SourceLocation(), $AddrOf(Context.Idents.get(new StringRef(/*KEEP_STR*/"std"))), 
        /*PrevDecl*/ (NamespaceDecl /*P*/ )null);
    NS.setImplicit();
    VaListDecl.setDeclContext(NS);
  }
  
  VaListDecl.startDefinition();
  
  // void * __ap;
  FieldDecl /*P*/ Field = FieldDecl.Create(((/*const_cast*/ASTContext /*&*/ )($Deref(Context))), 
      VaListDecl, 
      new SourceLocation(), 
      new SourceLocation(), 
      $AddrOf(Context.Idents.get(new StringRef(/*KEEP_STR*/"__ap"))), 
      Context.getPointerType(new CanQual<Type>(Context.VoidTy)).$QualType(), 
      /*TInfo=*/ (TypeSourceInfo /*P*/ )null, 
      /*BitWidth=*/ (Expr /*P*/ )null, 
      /*Mutable=*/ false, 
      InClassInitStyle.ICIS_NoInit);
  Field.setAccess(AccessSpecifier.AS_public);
  VaListDecl.addDecl(Field);
  
  // };
  VaListDecl.completeDefinition();
  Context.VaListTagDecl = VaListDecl;
  
  // typedef struct __va_list __builtin_va_list;
  QualType T = Context.getRecordType(VaListDecl);
  return Context.buildImplicitTypedef(new QualType(T), new StringRef(/*KEEP_STR*/"__builtin_va_list"));
}

//<editor-fold defaultstate="collapsed" desc="CreateSystemZBuiltinVaListDecl">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 6419,
 FQN="CreateSystemZBuiltinVaListDecl", NM="_ZL30CreateSystemZBuiltinVaListDeclPKN5clang10ASTContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZL30CreateSystemZBuiltinVaListDeclPKN5clang10ASTContextE")
//</editor-fold>
public static TypedefDecl /*P*/ CreateSystemZBuiltinVaListDecl(/*const*/ ASTContext /*P*/ Context) {
  // struct __va_list_tag {
  RecordDecl /*P*/ VaListTagDecl;
  VaListTagDecl = Context.buildImplicitRecord(new StringRef(/*KEEP_STR*/"__va_list_tag"));
  VaListTagDecl.startDefinition();
  
  /*const*//*size_t*/int NumFields = 4;
  QualType FieldTypes[/*4*/]/*J*/= new$T(new QualType [4], ()->new QualType());
  /*const*/char$ptr/*char P*/ FieldNames[/*4*/] = new char$ptr[4];
  
  //   long __gpr;
  FieldTypes[0].$assignMove(Context.LongTy.$QualType());
  FieldNames[0]=$("__gpr");
  
  //   long __fpr;
  FieldTypes[1].$assignMove(Context.LongTy.$QualType());
  FieldNames[1]=$("__fpr");
  
  //   void *__overflow_arg_area;
  FieldTypes[2].$assignMove(Context.getPointerType(new CanQual<Type>(Context.VoidTy)).$QualType());
  FieldNames[2]=$("__overflow_arg_area");
  
  //   void *__reg_save_area;
  FieldTypes[3].$assignMove(Context.getPointerType(new CanQual<Type>(Context.VoidTy)).$QualType());
  FieldNames[3]=$("__reg_save_area");
  
  // Create fields
  for (/*uint*/int i = 0; $less_uint(i, NumFields); ++i) {
    FieldDecl /*P*/ Field = FieldDecl.Create(((/*const_cast*/ASTContext /*&*/ )($Deref(Context))), 
        VaListTagDecl, 
        new SourceLocation(), 
        new SourceLocation(), 
        $AddrOf(Context.Idents.get(new StringRef(FieldNames[i]))), 
        new QualType(FieldTypes[i]), /*TInfo=*/ (TypeSourceInfo /*P*/ )null, 
        /*BitWidth=*/ (Expr /*P*/ )null, 
        /*Mutable=*/ false, 
        InClassInitStyle.ICIS_NoInit);
    Field.setAccess(AccessSpecifier.AS_public);
    VaListTagDecl.addDecl(Field);
  }
  VaListTagDecl.completeDefinition();
  Context.VaListTagDecl = VaListTagDecl;
  QualType VaListTagType = Context.getRecordType(VaListTagDecl);
  
  // };
  
  // typedef __va_list_tag __builtin_va_list[1];
  APInt Size/*J*/= new APInt($ulong2uint(Context.getTypeSize(Context.getSizeType().$QualType())), 1);
  QualType VaListTagArrayType = Context.getConstantArrayType(new QualType(VaListTagType), Size, ArrayType.ArraySizeModifier.Normal, 0);
  
  return Context.buildImplicitTypedef(new QualType(VaListTagArrayType), new StringRef(/*KEEP_STR*/"__builtin_va_list"));
}

//<editor-fold defaultstate="collapsed" desc="CreateVaListDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 6474,
 FQN="CreateVaListDecl", NM="_ZL16CreateVaListDeclPKN5clang10ASTContextENS_10TargetInfo17BuiltinVaListKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZL16CreateVaListDeclPKN5clang10ASTContextENS_10TargetInfo17BuiltinVaListKindE")
//</editor-fold>
public static TypedefDecl /*P*/ CreateVaListDecl(/*const*/ ASTContext /*P*/ Context, 
                TargetInfo.BuiltinVaListKind Kind) {
  switch (Kind) {
   case CharPtrBuiltinVaList:
    return CreateCharPtrBuiltinVaListDecl(Context);
   case VoidPtrBuiltinVaList:
    return CreateVoidPtrBuiltinVaListDecl(Context);
   case AArch64ABIBuiltinVaList:
    return CreateAArch64ABIBuiltinVaListDecl(Context);
   case PowerABIBuiltinVaList:
    return CreatePowerABIBuiltinVaListDecl(Context);
   case X86_64ABIBuiltinVaList:
    return CreateX86_64ABIBuiltinVaListDecl(Context);
   case PNaClABIBuiltinVaList:
    return CreatePNaClABIBuiltinVaListDecl(Context);
   case AAPCSABIBuiltinVaList:
    return CreateAAPCSABIBuiltinVaListDecl(Context);
   case SystemZBuiltinVaList:
    return CreateSystemZBuiltinVaListDecl(Context);
  }
  throw new llvm_unreachable("Unhandled __builtin_va_list type kind");
}


//===----------------------------------------------------------------------===//
//                        Type Compatibility Testing
//===----------------------------------------------------------------------===//

/// areCompatVectorTypes - Return true if the two specified vector types are
/// compatible.
//<editor-fold defaultstate="collapsed" desc="areCompatVectorTypes">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 6752,
 FQN="areCompatVectorTypes", NM="_ZL20areCompatVectorTypesPKN5clang10VectorTypeES2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZL20areCompatVectorTypesPKN5clang10VectorTypeES2_")
//</editor-fold>
public static boolean areCompatVectorTypes(/*const*/ VectorType /*P*/ LHS, 
                    /*const*/ VectorType /*P*/ RHS) {
  assert (LHS.isCanonicalUnqualified() && RHS.isCanonicalUnqualified());
  return $eq_QualType$C(LHS.getElementType(), RHS.getElementType())
     && LHS.getNumElements() == RHS.getNumElements();
}


/// Comparison routine for Objective-C protocols to be used with
/// llvm::array_pod_sort.
//<editor-fold defaultstate="collapsed" desc="compareObjCProtocolsByName">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 7046,
 FQN="compareObjCProtocolsByName", NM="_ZL26compareObjCProtocolsByNamePKPN5clang16ObjCProtocolDeclES3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZL26compareObjCProtocolsByNamePKPN5clang16ObjCProtocolDeclES3_")
//</editor-fold>
public static int compareObjCProtocolsByName(type$ptr<ObjCProtocolDecl/*P const*/>/*P*/ lhs, 
                          type$ptr<ObjCProtocolDecl/*P const*/>/*P*/ rhs) {
  return (lhs.$star()).getName().compare((rhs.$star()).getName());
}


/// getIntersectionOfProtocols - This routine finds the intersection of set
/// of protocols inherited from two distinct objective-c pointer objects with
/// the given common base.
/// It is used to build composite qualifier list of the composite type of
/// the conditional expression involving two objective-c pointer objects.
//<editor-fold defaultstate="collapsed" desc="getIntersectionOfProtocols">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 7057,
 FQN="getIntersectionOfProtocols", NM="_ZL26getIntersectionOfProtocolsRN5clang10ASTContextEPKNS_17ObjCInterfaceDeclEPKNS_21ObjCObjectPointerTypeES7_RN4llvm15SmallVectorImplIPNS_16ObjCProtocolDeclEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZL26getIntersectionOfProtocolsRN5clang10ASTContextEPKNS_17ObjCInterfaceDeclEPKNS_21ObjCObjectPointerTypeES7_RN4llvm15SmallVectorImplIPNS_16ObjCProtocolDeclEEE")
//</editor-fold>
public static void getIntersectionOfProtocols(final ASTContext /*&*/ Context, 
                          /*const*/ ObjCInterfaceDecl /*P*/ CommonBase, 
                          /*const*/ ObjCObjectPointerType /*P*/ LHSOPT, 
                          /*const*/ ObjCObjectPointerType /*P*/ RHSOPT, 
                          final SmallVectorImpl<ObjCProtocolDecl /*P*/ > /*&*/ IntersectionSet) {
  
  /*const*/ ObjCObjectType /*P*/ LHS = LHSOPT.getObjectType();
  /*const*/ ObjCObjectType /*P*/ RHS = RHSOPT.getObjectType();
  assert ((LHS.getInterface() != null)) : "LHS must have an interface base";
  assert ((RHS.getInterface() != null)) : "RHS must have an interface base";
  
  // Add all of the protocols for the LHS.
  SmallPtrSet<ObjCProtocolDecl /*P*/ > LHSProtocolSet/*J*/= new SmallPtrSet<ObjCProtocolDecl /*P*/ >(DenseMapInfo$LikePtr.$Info(), 8);
  
  // Start with the protocol qualifiers.
  for (ObjCProtocolDecl /*P*/ proto : LHS.quals()) {
    Context.CollectInheritedProtocols(proto, LHSProtocolSet);
  }
  
  // Also add the protocols associated with the LHS interface.
  Context.CollectInheritedProtocols(LHS.getInterface(), LHSProtocolSet);
  
  // Add all of the protocls for the RHS.
  SmallPtrSet<ObjCProtocolDecl /*P*/ > RHSProtocolSet/*J*/= new SmallPtrSet<ObjCProtocolDecl /*P*/ >(DenseMapInfo$LikePtr.$Info(), 8);
  
  // Start with the protocol qualifiers.
  for (ObjCProtocolDecl /*P*/ proto : RHS.quals()) {
    Context.CollectInheritedProtocols(proto, RHSProtocolSet);
  }
  
  // Also add the protocols associated with the RHS interface.
  Context.CollectInheritedProtocols(RHS.getInterface(), RHSProtocolSet);
  
  // Compute the intersection of the collected protocol sets.
  for (ObjCProtocolDecl /*P*/ proto : LHSProtocolSet) {
    if ((RHSProtocolSet.count(proto) != 0)) {
      IntersectionSet.push_back(proto);
    }
  }
  
  // Compute the set of protocols that is implied by either the common type or
  // the protocols within the intersection.
  SmallPtrSet<ObjCProtocolDecl /*P*/ > ImpliedProtocols/*J*/= new SmallPtrSet<ObjCProtocolDecl /*P*/ >(DenseMapInfo$LikePtr.$Info(), 8);
  Context.CollectInheritedProtocols(CommonBase, ImpliedProtocols);
  
  // Remove any implied protocols from the list of inherited protocols.
  if (!ImpliedProtocols.empty()) {
    IntersectionSet.erase(std.remove_if(IntersectionSet.begin(), 
            IntersectionSet.end(), 
            /*[&, &ImpliedProtocols]*/ (ObjCProtocolDecl /*P*/ proto) -> {
                  return $greater_uint(ImpliedProtocols.count(proto), 0);
                }), 
        IntersectionSet.end());
  }
  
  // Sort the remaining protocols by name.
  llvm.array_pod_sort(IntersectionSet.begin(), IntersectionSet.end(), 
      /*FuncRef*/ASTContextStatics::compareObjCProtocolsByName);
}


/// Determine whether the first type is a subtype of the second.
//<editor-fold defaultstate="collapsed" desc="canAssignObjCObjectTypes">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 7119,
 FQN="canAssignObjCObjectTypes", NM="_ZL24canAssignObjCObjectTypesRN5clang10ASTContextENS_8QualTypeES2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZL24canAssignObjCObjectTypesRN5clang10ASTContextENS_8QualTypeES2_")
//</editor-fold>
public static boolean canAssignObjCObjectTypes(final ASTContext /*&*/ ctx, QualType lhs, 
                        QualType rhs) {
  // Common case: two object pointers.
  /*const*/ ObjCObjectPointerType /*P*/ lhsOPT = lhs.$arrow().getAs(ObjCObjectPointerType.class);
  /*const*/ ObjCObjectPointerType /*P*/ rhsOPT = rhs.$arrow().getAs(ObjCObjectPointerType.class);
  if ((lhsOPT != null) && (rhsOPT != null)) {
    return ctx.canAssignObjCInterfaces(lhsOPT, rhsOPT);
  }
  
  // Two block pointers.
  /*const*/ BlockPointerType /*P*/ lhsBlock = lhs.$arrow().getAs(BlockPointerType.class);
  /*const*/ BlockPointerType /*P*/ rhsBlock = rhs.$arrow().getAs(BlockPointerType.class);
  if ((lhsBlock != null) && (rhsBlock != null)) {
    return ctx.typesAreBlockPointerCompatible(new QualType(lhs), new QualType(rhs));
  }
  
  // If either is an unqualified 'id' and the other is a block, it's
  // acceptable.
  if (((lhsOPT != null) && lhsOPT.isObjCIdType() && (rhsBlock != null))
     || ((rhsOPT != null) && rhsOPT.isObjCIdType() && (lhsBlock != null))) {
    return true;
  }
  
  return false;
}


// Check that the given Objective-C type argument lists are equivalent.
//<editor-fold defaultstate="collapsed" desc="sameObjCTypeArgs">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 7143,
 FQN="sameObjCTypeArgs", NM="_ZL16sameObjCTypeArgsRN5clang10ASTContextEPKNS_17ObjCInterfaceDeclEN4llvm8ArrayRefINS_8QualTypeEEES8_b",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZL16sameObjCTypeArgsRN5clang10ASTContextEPKNS_17ObjCInterfaceDeclEN4llvm8ArrayRefINS_8QualTypeEEES8_b")
//</editor-fold>
public static boolean sameObjCTypeArgs(final ASTContext /*&*/ ctx, 
                /*const*/ ObjCInterfaceDecl /*P*/ iface, 
                ArrayRef<QualType> lhsArgs, 
                ArrayRef<QualType> rhsArgs, 
                boolean stripKindOf) {
  if (lhsArgs.size() != rhsArgs.size()) {
    return false;
  }
  
  ObjCTypeParamList /*P*/ typeParams = iface.getTypeParamList();
  for (/*uint*/int i = 0, n = lhsArgs.size(); i != n; ++i) {
    if (ctx.hasSameType(new QualType(lhsArgs.$at(i)), new QualType(rhsArgs.$at(i)))) {
      continue;
    }
    switch (typeParams.begin().$at(i).getVariance()) {
     case Invariant:
      if (!stripKindOf
         || !ctx.hasSameType(lhsArgs.$at(i).stripObjCKindOfType(ctx), 
          rhsArgs.$at(i).stripObjCKindOfType(ctx))) {
        return false;
      }
      break;
     case Covariant:
      if (!canAssignObjCObjectTypes(ctx, new QualType(lhsArgs.$at(i)), new QualType(rhsArgs.$at(i)))) {
        return false;
      }
      break;
     case Contravariant:
      if (!canAssignObjCObjectTypes(ctx, new QualType(rhsArgs.$at(i)), new QualType(lhsArgs.$at(i)))) {
        return false;
      }
      break;
    }
  }
  
  return true;
}


/// Given that we have an enum type and a non-enum type, try to merge them.
//<editor-fold defaultstate="collapsed" desc="mergeEnumWithInteger">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 7607,
 FQN="mergeEnumWithInteger", NM="_ZL20mergeEnumWithIntegerRN5clang10ASTContextEPKNS_8EnumTypeENS_8QualTypeEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZL20mergeEnumWithIntegerRN5clang10ASTContextEPKNS_8EnumTypeENS_8QualTypeEb")
//</editor-fold>
public static QualType mergeEnumWithInteger(final ASTContext /*&*/ Context, /*const*/ EnumType /*P*/ ET, 
                    QualType other, boolean isBlockReturnType) {
  // C99 6.7.2.2p4: Each enumerated type shall be compatible with char,
  // a signed integer type, or an unsigned integer type.
  // Compatibility is based on the underlying type, not the promotion
  // type.
  QualType underlyingType = ET.getDecl().getIntegerType();
  if (underlyingType.isNull()) {
    return new QualType();
  }
  if (Context.hasSameType(new QualType(underlyingType), new QualType(other))) {
    return new QualType(JD$Move.INSTANCE, other);
  }
  
  // In block return types, we're more permissive and accept any
  // integral type of the same size.
  if (isBlockReturnType && other.$arrow().isIntegerType()
     && Context.getTypeSize(new QualType(underlyingType)) == Context.getTypeSize(new QualType(other))) {
    return new QualType(JD$Move.INSTANCE, other);
  }
  
  return new QualType();
}


//===----------------------------------------------------------------------===//
//                          Builtin Type Computation
//===----------------------------------------------------------------------===//

/// DecodeTypeFromStr - This decodes one type descriptor from Str, advancing the
/// pointer over the consumed characters.  This returns the resultant type.  If
/// AllowTypeModifiers is false then modifier like * are not parsed, just basic
/// types.  This allows "v2i*" to be parsed as a pointer to a v2i instead of
/// a vector of "i*".
///
/// RequiresICE is filled in on return to indicate whether the value is required
/// to be an Integer Constant Expression.
//<editor-fold defaultstate="collapsed" desc="DecodeTypeFromStr">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 8091,
 FQN="DecodeTypeFromStr", NM="_ZL17DecodeTypeFromStrRPKcRKN5clang10ASTContextERNS3_19GetBuiltinTypeErrorERbb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZL17DecodeTypeFromStrRPKcRKN5clang10ASTContextERNS3_19GetBuiltinTypeErrorERbb")
//</editor-fold>
public static QualType DecodeTypeFromStr(final char$ptr/*const char P &*/ Str, final /*const*/ ASTContext /*&*/ Context, 
                 final type$ref<ASTContext.GetBuiltinTypeError /*&*/> Error, 
                 final bool$ref/*bool &*/ RequiresICE, 
                 boolean AllowTypeModifiers) {
  // Modifiers.
  int HowLong = 0;
  boolean Signed = false;
  boolean Unsigned = false;
  RequiresICE.$set(false);
  
  // Read the prefixed modifiers first.
  boolean Done = false;
  while (!Done) {
    switch (Str.$postInc().$star()) {
     default:
      Done = true;
      Str.$preDec();
      break;
     case 'I':
      RequiresICE.$set(true);
      break;
     case 'S':
      assert (!Unsigned) : "Can't use both 'S' and 'U' modifiers!";
      assert (!Signed) : "Can't use 'S' modifier multiple times!";
      Signed = true;
      break;
     case 'U':
      assert (!Signed) : "Can't use both 'S' and 'U' modifiers!";
      assert (!Unsigned) : "Can't use 'U' modifier multiple times!";
      Unsigned = true;
      break;
     case 'L':
      assert (HowLong <= 2) : "Can't have LLLL modifier";
      ++HowLong;
      break;
     case 'W':
      // This modifier represents int64 type.
      assert (HowLong == 0) : "Can't use both 'L' and 'W' modifiers!";
      switch (Context.getTargetInfo().getInt64Type()) {
       default:
        throw new llvm_unreachable("Unexpected integer type");
       case SignedLong:
        HowLong = 1;
        break;
       case SignedLongLong:
        HowLong = 2;
        break;
      }
    }
  }
  
  QualType Type/*J*/= new QualType();
  
  // Read the base type.
  switch (Str.$postInc().$star()) {
   default:
    throw new llvm_unreachable("Unknown builtin type letter!");
   case 'v':
    assert (HowLong == 0 && !Signed && !Unsigned) : "Bad modifiers used with 'v'!";
    Type.$assignMove(Context.VoidTy.$QualType());
    break;
   case 'h':
    assert (HowLong == 0 && !Signed && !Unsigned) : "Bad modifiers used with 'h'!";
    Type.$assignMove(Context.HalfTy.$QualType());
    break;
   case 'f':
    assert (HowLong == 0 && !Signed && !Unsigned) : "Bad modifiers used with 'f'!";
    Type.$assignMove(Context.FloatTy.$QualType());
    break;
   case 'd':
    assert (HowLong < 2 && !Signed && !Unsigned) : "Bad modifiers used with 'd'!";
    if ((HowLong != 0)) {
      Type.$assignMove(Context.LongDoubleTy.$QualType());
    } else {
      Type.$assignMove(Context.DoubleTy.$QualType());
    }
    break;
   case 's':
    assert (HowLong == 0) : "Bad modifiers used with 's'!";
    if (Unsigned) {
      Type.$assignMove(Context.UnsignedShortTy.$QualType());
    } else {
      Type.$assignMove(Context.ShortTy.$QualType());
    }
    break;
   case 'i':
    if (HowLong == 3) {
      Type.$assignMove((Unsigned ? Context.UnsignedInt128Ty : Context.Int128Ty).$QualType());
    } else if (HowLong == 2) {
      Type.$assignMove((Unsigned ? Context.UnsignedLongLongTy : Context.LongLongTy).$QualType());
    } else if (HowLong == 1) {
      Type.$assignMove((Unsigned ? Context.UnsignedLongTy : Context.LongTy).$QualType());
    } else {
      Type.$assignMove((Unsigned ? Context.UnsignedIntTy : Context.IntTy).$QualType());
    }
    break;
   case 'c':
    assert (HowLong == 0) : "Bad modifiers used with 'c'!";
    if (Signed) {
      Type.$assignMove(Context.SignedCharTy.$QualType());
    } else if (Unsigned) {
      Type.$assignMove(Context.UnsignedCharTy.$QualType());
    } else {
      Type.$assignMove(Context.CharTy.$QualType());
    }
    break;
   case 'b': // boolean
    assert (HowLong == 0 && !Signed && !Unsigned) : "Bad modifiers for 'b'!";
    Type.$assignMove(Context.BoolTy.$QualType());
    break;
   case 'z': // size_t.
    assert (HowLong == 0 && !Signed && !Unsigned) : "Bad modifiers for 'z'!";
    Type.$assignMove(Context.getSizeType().$QualType());
    break;
   case 'F':
    Type.$assignMove(Context.getCFConstantStringType());
    break;
   case 'G':
    Type.$assignMove(Context.getObjCIdType());
    break;
   case 'H':
    Type.$assignMove(Context.getObjCSelType());
    break;
   case 'M':
    Type.$assignMove(Context.getObjCSuperType());
    break;
   case 'a':
    Type.$assignMove(Context.getBuiltinVaListType());
    assert (!Type.isNull()) : "builtin va list type not initialized!";
    break;
   case 'A':
    // This is a "reference" to a va_list; however, what exactly
    // this means depends on how va_list is defined. There are two
    // different kinds of va_list: ones passed by value, and ones
    // passed by reference.  An example of a by-value va_list is
    // x86, where va_list is a char*. An example of by-ref va_list
    // is x86-64, where va_list is a __va_list_tag[1]. For x86,
    // we want this argument to be a char*&; for x86-64, we want
    // it to be a __va_list_tag*.
    Type.$assignMove(Context.getBuiltinVaListType());
    assert (!Type.isNull()) : "builtin va list type not initialized!";
    if (Type.$arrow().isArrayType()) {
      Type.$assignMove(Context.getArrayDecayedType(new QualType(Type)));
    } else {
      Type.$assignMove(Context.getLValueReferenceType(new QualType(Type)));
    }
    break;
   case 'V':
    {
      char$ptr/*char P*/ End = create_char$null$ptr();
      /*uint*/int NumElements = (int)strtoul(Str, End.$addr(), 10);
      assert ($noteq_ptr(End, Str)) : "Missing vector size";
      Str.$assign(End);
      
      QualType ElementType = DecodeTypeFromStr(Str, Context, Error, 
          RequiresICE, false);
      assert (!RequiresICE.$deref()) : "Can't require vector ICE";
      
      // TODO: No way to make AltiVec vectors in builtins yet.
      Type.$assignMove(Context.getVectorType(new QualType(ElementType), NumElements, 
              VectorType.VectorKind.GenericVector));
      break;
    }
   case 'E':
    {
      char$ptr/*char P*/ End = create_char$null$ptr();
      
      /*uint*/int NumElements = (int)strtoul(Str, End.$addr(), 10);
      assert ($noteq_ptr(End, Str)) : "Missing vector size";
      
      Str.$assign(End);
      
      QualType ElementType = DecodeTypeFromStr(Str, Context, Error, RequiresICE, 
          false);
      Type.$assignMove(Context.getExtVectorType(new QualType(ElementType), NumElements));
      break;
    }
   case 'X':
    {
      QualType ElementType = DecodeTypeFromStr(Str, Context, Error, RequiresICE, 
          false);
      assert (!RequiresICE.$deref()) : "Can't require complex ICE";
      Type.$assignMove(Context.getComplexType(new QualType(ElementType)));
      break;
    }
   case 'Y':
    {
      Type.$assignMove(Context.getPointerDiffType());
      break;
    }
   case 'P':
    Type.$assignMove(Context.getFILEType());
    if (Type.isNull()) {
      Error.$set(ASTContext.GetBuiltinTypeError.GE_Missing_stdio);
      return new QualType();
    }
    break;
   case 'J':
    if (Signed) {
      Type.$assignMove(Context.getsigjmp_bufType());
    } else {
      Type.$assignMove(Context.getjmp_bufType());
    }
    if (Type.isNull()) {
      Error.$set(ASTContext.GetBuiltinTypeError.GE_Missing_setjmp);
      return new QualType();
    }
    break;
   case 'K':
    assert (HowLong == 0 && !Signed && !Unsigned) : "Bad modifiers for 'K'!";
    Type.$assignMove(Context.getucontext_tType());
    if (Type.isNull()) {
      Error.$set(ASTContext.GetBuiltinTypeError.GE_Missing_ucontext);
      return new QualType();
    }
    break;
   case 'p':
    Type.$assignMove(Context.getProcessIDType());
    break;
  }
  
  // If there are modifiers and if we're allowed to parse them, go for it.
  Done = !AllowTypeModifiers;
  while (!Done) {
    {
      /*char*/byte c = Str.$postInc().$star();
      switch (c) {
       default:
        Done = true;
        Str.$preDec();
        break;
       case '*':
       case '&':
        {
          // Both pointers and references can have their pointee types
          // qualified with an address space.
          char$ptr/*char P*/ End = create_char$null$ptr();
          /*uint*/int AddrSpace = (int)strtoul(Str, End.$addr(), 10);
          if ($noteq_ptr(End, Str) && AddrSpace != 0) {
            Type.$assignMove(Context.getAddrSpaceQualType(new QualType(Type), AddrSpace));
            Str.$assign(End);
          }
          if (c == $$STAR) {
            Type.$assignMove(Context.getPointerType(new QualType(Type)));
          } else {
            Type.$assignMove(Context.getLValueReferenceType(new QualType(Type)));
          }
          break;
        }
       case 'C':
        // FIXME: There's no way to have a built-in with an rvalue ref arg.
        Type.$assignMove(Type.withConst());
        break;
       case 'D':
        Type.$assignMove(Context.getVolatileType(new QualType(Type)));
        break;
       case 'R':
        Type.$assignMove(Type.withRestrict());
        break;
      }
    }
  }
  assert ((!RequiresICE.$deref() || Type.$arrow().isIntegralOrEnumerationType())) : "Integer constant 'I' type must be an integer";
  
  return Type;
}

//<editor-fold defaultstate="collapsed" desc="basicGVALinkageForFunction">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 8399,
 FQN="basicGVALinkageForFunction", NM="_ZL26basicGVALinkageForFunctionRKN5clang10ASTContextEPKNS_12FunctionDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZL26basicGVALinkageForFunctionRKN5clang10ASTContextEPKNS_12FunctionDeclE")
//</editor-fold>
public static GVALinkage basicGVALinkageForFunction(final /*const*/ ASTContext /*&*/ Context, 
                          /*const*/ FunctionDecl /*P*/ FD) {
  if (!FD.isExternallyVisible()) {
    return GVALinkage.GVA_Internal;
  }
  
  GVALinkage External = GVALinkage.GVA_StrongExternal;
  switch (FD.getTemplateSpecializationKind()) {
   case TSK_Undeclared:
   case TSK_ExplicitSpecialization:
    External = GVALinkage.GVA_StrongExternal;
    break;
   case TSK_ExplicitInstantiationDefinition:
    return GVALinkage.GVA_StrongODR;
   case TSK_ExplicitInstantiationDeclaration:
    
    // C++11 [temp.explicit]p10:
    //   [ Note: The intent is that an inline function that is the subject of
    //   an explicit instantiation declaration will still be implicitly
    //   instantiated when used so that the body can be considered for
    //   inlining, but that no out-of-line copy of the inline function would be
    //   generated in the translation unit. -- end note ]
    return GVALinkage.GVA_AvailableExternally;
   case TSK_ImplicitInstantiation:
    External = GVALinkage.GVA_DiscardableODR;
    break;
  }
  if (!FD.isInlined()) {
    return External;
  }
  if ((!Context.getLangOpts().CPlusPlus
     && !Context.getTargetInfo().getCXXABI().isMicrosoft()
     && !FD.hasAttr(DLLExportAttr.class))
     || FD.hasAttr(GNUInlineAttr.class)) {
    // FIXME: This doesn't match gcc's behavior for dllexport inline functions.
    
    // GNU or C99 inline semantics. Determine whether this symbol should be
    // externally visible.
    if (FD.isInlineDefinitionExternallyVisible()) {
      return External;
    }
    
    // C99 inline semantics, where the symbol is not externally visible.
    return GVALinkage.GVA_AvailableExternally;
  }
  
  // Functions specified with extern and inline in -fms-compatibility mode
  // forcibly get emitted.  While the body of the function cannot be later
  // replaced, the function definition cannot be discarded.
  if (FD.isMSExternInline()) {
    return GVALinkage.GVA_StrongODR;
  }
  
  return GVALinkage.GVA_DiscardableODR;
}

//<editor-fold defaultstate="collapsed" desc="adjustGVALinkageForAttributes">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 8455,
 FQN="adjustGVALinkageForAttributes", NM="_ZL29adjustGVALinkageForAttributesRKN5clang10ASTContextENS_10GVALinkageEPKNS_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZL29adjustGVALinkageForAttributesRKN5clang10ASTContextENS_10GVALinkageEPKNS_4DeclE")
//</editor-fold>
public static GVALinkage adjustGVALinkageForAttributes(final /*const*/ ASTContext /*&*/ Context, 
                             GVALinkage L, /*const*/ Decl /*P*/ D) {
  // See http://msdn.microsoft.com/en-us/library/xa0d9ste.aspx
  // dllexport/dllimport on inline functions.
  if (D.hasAttr(DLLImportAttr.class)) {
    if (L == GVALinkage.GVA_DiscardableODR || L == GVALinkage.GVA_StrongODR) {
      return GVALinkage.GVA_AvailableExternally;
    }
  } else if (D.hasAttr(DLLExportAttr.class)) {
    if (L == GVALinkage.GVA_DiscardableODR) {
      return GVALinkage.GVA_StrongODR;
    }
  } else if (Context.getLangOpts().CUDA && Context.getLangOpts().CUDAIsDevice
     && D.hasAttr(CUDAGlobalAttr.class)) {
    // Device-side functions with __global__ attribute must always be
    // visible externally so they can be launched from host.
    if (L == GVALinkage.GVA_DiscardableODR || L == GVALinkage.GVA_Internal) {
      return GVALinkage.GVA_StrongODR;
    }
  }
  return L;
}

//<editor-fold defaultstate="collapsed" desc="basicGVALinkageForVariable">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 8480,
 FQN="basicGVALinkageForVariable", NM="_ZL26basicGVALinkageForVariableRKN5clang10ASTContextEPKNS_7VarDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZL26basicGVALinkageForVariableRKN5clang10ASTContextEPKNS_7VarDeclE")
//</editor-fold>
public static GVALinkage basicGVALinkageForVariable(final /*const*/ ASTContext /*&*/ Context, 
                          /*const*/ VarDecl /*P*/ VD) {
  if (!VD.isExternallyVisible()) {
    return GVALinkage.GVA_Internal;
  }
  if (VD.isStaticLocal()) {
    GVALinkage StaticLocalLinkage = GVALinkage.GVA_DiscardableODR;
    /*const*/ DeclContext /*P*/ LexicalContext = VD.getParentFunctionOrMethod$Const();
    while ((LexicalContext != null) && !isa_FunctionDecl(LexicalContext)) {
      LexicalContext = LexicalContext.getLexicalParent$Const();
    }
    
    // Let the static local variable inherit its linkage from the nearest
    // enclosing function.
    if ((LexicalContext != null)) {
      StaticLocalLinkage
         = Context.GetGVALinkageForFunction(cast_FunctionDecl(LexicalContext));
    }
    
    // GVA_StrongODR function linkage is stronger than what we need,
    // downgrade to GVA_DiscardableODR.
    // This allows us to discard the variable if we never end up needing it.
    return StaticLocalLinkage == GVALinkage.GVA_StrongODR ? GVALinkage.GVA_DiscardableODR : StaticLocalLinkage;
  }
  
  // MSVC treats in-class initialized static data members as definitions.
  // By giving them non-strong linkage, out-of-line definitions won't
  // cause link errors.
  if (Context.isMSStaticDataMemberInlineDefinition(VD)) {
    return GVALinkage.GVA_DiscardableODR;
  }
  
  // Most non-template variables have strong linkage; inline variables are
  // linkonce_odr or (occasionally, for compatibility) weak_odr.
  GVALinkage StrongLinkage = GVALinkage.GVA_INVALID;
  switch (Context.getInlineVariableDefinitionKind(VD)) {
   case None:
    StrongLinkage = GVALinkage.GVA_StrongExternal;
    break;
   case Weak:
   case WeakUnknown:
    StrongLinkage = GVALinkage.GVA_DiscardableODR;
    break;
   case Strong:
    StrongLinkage = GVALinkage.GVA_StrongODR;
    break;
  }
  switch (VD.getTemplateSpecializationKind()) {
   case TSK_Undeclared:
    return StrongLinkage;
   case TSK_ExplicitSpecialization:
    return Context.getTargetInfo().getCXXABI().isMicrosoft()
       && VD.isStaticDataMember() ? GVALinkage.GVA_StrongODR : StrongLinkage;
   case TSK_ExplicitInstantiationDefinition:
    return GVALinkage.GVA_StrongODR;
   case TSK_ExplicitInstantiationDeclaration:
    return GVALinkage.GVA_AvailableExternally;
   case TSK_ImplicitInstantiation:
    return GVALinkage.GVA_DiscardableODR;
  }
  throw new llvm_unreachable("Invalid Linkage!");
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::getSingleDynTypedNodeFromParentMap">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 8888,
 FQN="(anonymous namespace)::getSingleDynTypedNodeFromParentMap", NM="_ZN12_GLOBAL__N_134getSingleDynTypedNodeFromParentMapEN4llvm13PointerUnion4IPKN5clang4DeclEPKNS2_4StmtEPNS2_15ast_type_traits12DynTypedNodeEPNS0_11SmallVectorISA_Lj2EEEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN12_GLOBAL__N_134getSingleDynTypedNodeFromParentMapEN4llvm13PointerUnion4IPKN5clang4DeclEPKNS2_4StmtEPNS2_15ast_type_traits12DynTypedNodeEPNS0_11SmallVectorISA_Lj2EEEEE")
//</editor-fold>
public static DynTypedNode getSingleDynTypedNodeFromParentMap(PointerUnion4</*const*/ Decl /*P*/ , /*const*/ Stmt /*P*/ , DynTypedNode /*P*/ , SmallVector<DynTypedNode> /*P*/> U) {
  {
    /*const*/ Decl /*P*/ D = U.dyn_cast(/*const*/ Decl /*P*/.class);
    if ((D != null)) {
      return DynTypedNode.create($Deref(D));
    }
  }
  {
    /*const*/ Stmt /*P*/ S = U.dyn_cast(/*const*/ Stmt /*P*/.class);
    if ((S != null)) {
      return DynTypedNode.create($Deref(S));
    }
  }
  return new DynTypedNode($Deref(U.get(DynTypedNode /*P*/.class)));
}


/// Template specializations to abstract away from pointers and TypeLocs.
/// @{
/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::createDynTypedNode">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 8900,
 FQN="(anonymous namespace)::createDynTypedNode", NM="Tpl__ZN12_GLOBAL__N_118createDynTypedNodeERKT_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=Tpl__ZN12_GLOBAL__N_118createDynTypedNodeERKT_")
//</editor-fold>
public static DynTypedNode createDynTypedNode(final /*const*/ Object /*&*/ Node) {
  if (Node instanceof Decl) {
    return createDynTypedNode((Decl)Node);
  } else if (Node instanceof Stmt) {
    return createDynTypedNode((Stmt)Node);
  } else if (Node instanceof Type) {
    return createDynTypedNode((Type)Node);
  } else if (Node instanceof TypeLoc) {
    return createDynTypedNode((TypeLoc)Node);
  } else if (Node instanceof NestedNameSpecifierLoc) {
    return createDynTypedNode((NestedNameSpecifierLoc)Node);
  } else if (Node instanceof NestedNameSpecifier) {
    return createDynTypedNode((NestedNameSpecifier)Node);
  } else if (Node instanceof CXXCtorInitializer) {
    return createDynTypedNode((CXXCtorInitializer)Node);
  } else if (Node instanceof QualType) {
    return createDynTypedNode((QualType)Node);
  } else if (Node instanceof TemplateArgument) {
    return createDynTypedNode((TemplateArgument)Node);
  } 
  throw new UnsupportedOperationException("Not implemented for class "+Node.getClass().getName());
}
public static DynTypedNode createDynTypedNode(final Decl /*P*/ /*const*/ /*&*/ Node) {
  return DynTypedNode.create($Deref(Node));
}
public static DynTypedNode createDynTypedNode(final Stmt /*P*/ /*const*/ /*&*/ Node) {
  return DynTypedNode.create($Deref(Node));
}
public static DynTypedNode createDynTypedNode(final /*const*/ Type /*&*/ Node) {
  return DynTypedNode.create($Deref(Node));
}
public static DynTypedNode createDynTypedNode(final /*const*/ TypeLoc /*&*/ Node) {
  return DynTypedNode.create($Deref(Node));
}
public static DynTypedNode createDynTypedNode(final /*const*/ NestedNameSpecifierLoc /*&*/ Node) {
  return DynTypedNode.create($Deref(Node));
}
public static DynTypedNode createDynTypedNode(final /*const*/ NestedNameSpecifier /*&*/ Node) {
  return DynTypedNode.create($Deref(Node));
}
public static DynTypedNode createDynTypedNode(final /*const*/ CXXCtorInitializer /*&*/ Node) {
  return DynTypedNode.create($Deref(Node));
}
public static DynTypedNode createDynTypedNode(final /*const*/ QualType /*&*/ Node) {
  return DynTypedNode.create($Deref(Node));
}
public static DynTypedNode createDynTypedNode(final /*const*/ TemplateArgument /*&*/ Node) {
  return DynTypedNode.create($Deref(Node));
}

// anonymous namespace
/*template <typename NodeTy, typename MapTy> TEMPLATE*/
// anonymous namespace
/*template <typename NodeTy, typename MapTy> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="getDynNodeFromMap">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp", line = 9044,
 FQN="getDynNodeFromMap", NM="Tpl__ZL17getDynNodeFromMapRKT_RKT0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=Tpl__ZL17getDynNodeFromMapRKT_RKT0_")
//</editor-fold>
public static </*typename*/ NodeTy, /*typename*/ MapTy extends DenseMap<NodeTy, PointerUnion4</*const*/ Decl /*P*/ , /*const*/ Stmt /*P*/ , DynTypedNode /*P*/ , SmallVector<DynTypedNode> /*P*/> /*P*/>> 
        ASTContext.DynTypedNodeList getDynNodeFromMap(final /*const*/ NodeTy /*&*/ Node, 
                 final /*const*/ MapTy /*&*/ Map) {
  /*<dependent type>*/DenseMapIterator<NodeTy, PointerUnion4<Decl, Stmt, DynTypedNode, SmallVector<DynTypedNode>>> I = Map.find(Node);
  if (Native.$eq(I, Map.end())) {
    return new ASTContext.DynTypedNodeList(new ArrayRef<DynTypedNode>(false));
  }
  {
    SmallVector<DynTypedNode> V = I.$star().second./*template */dyn_cast(SmallVector.class);
    if (V != null) {
      return new ASTContext.DynTypedNodeList(llvm.makeArrayRef(V));
    }
  }
  return new ASTContext.DynTypedNodeList(getSingleDynTypedNodeFromParentMap(I.$star().second));
}

} // END OF class ASTContextStatics
