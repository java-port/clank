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
package org.clang.serialization.impl;

import org.clank.support.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.serialization.*;
import org.clang.serialization.java.SerializationFunctionPointers.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstTypesRTTI.*;
import static org.clang.serialization.impl.SerializationStatics.*;
import org.llvm.support.*;


//<editor-fold defaultstate="collapsed" desc="static type SerializationStatics">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.clang.serialization.impl.SerializationStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTCommon.cpp -nm=Tpl__ZN5clang13serialization10MakeTypeIDERNS_10ASTContextENS_8QualTypeET_;Tpl__ZN5clang13serialization26numberAnonymousDeclsWithinEPKNS_11DeclContextET_;_ZN5clang13serialization11ComputeHashENS_8SelectorE;_ZN5clang13serialization18TypeIdxFromBuiltinEPKNS_11BuiltinTypeE;_ZN5clang13serialization22isRedeclarableDeclKindEj;_ZN5clang13serialization24getDefinitiveDeclContextEPKNS_11DeclContextE;_ZN5clang13serialization31needsAnonymousDeclarationNumberEPKNS_9NamedDeclE; -static-type=SerializationStatics -package=org.clang.serialization.impl")
//</editor-fold>
public final class SerializationStatics {

//<editor-fold defaultstate="collapsed" desc="clang::serialization::TypeIdxFromBuiltin">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTCommon.cpp", line = 26,
 FQN="clang::serialization::TypeIdxFromBuiltin", NM="_ZN5clang13serialization18TypeIdxFromBuiltinEPKNS_11BuiltinTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTCommon.cpp -nm=_ZN5clang13serialization18TypeIdxFromBuiltinEPKNS_11BuiltinTypeE")
//</editor-fold>
public static TypeIdx TypeIdxFromBuiltin(/*const*/ BuiltinType /*P*/ BT) {
  /*uint*/int ID = 0;
  switch (BT.getKind()) {
   case Void:
    ID = PredefinedTypeIDs.PREDEF_TYPE_VOID_ID;
    break;
   case Bool:
    ID = PredefinedTypeIDs.PREDEF_TYPE_BOOL_ID;
    break;
   case Char_U:
    ID = PredefinedTypeIDs.PREDEF_TYPE_CHAR_U_ID;
    break;
   case UChar:
    ID = PredefinedTypeIDs.PREDEF_TYPE_UCHAR_ID;
    break;
   case UShort:
    ID = PredefinedTypeIDs.PREDEF_TYPE_USHORT_ID;
    break;
   case UInt:
    ID = PredefinedTypeIDs.PREDEF_TYPE_UINT_ID;
    break;
   case ULong:
    ID = PredefinedTypeIDs.PREDEF_TYPE_ULONG_ID;
    break;
   case ULongLong:
    ID = PredefinedTypeIDs.PREDEF_TYPE_ULONGLONG_ID;
    break;
   case UInt128:
    ID = PredefinedTypeIDs.PREDEF_TYPE_UINT128_ID;
    break;
   case Char_S:
    ID = PredefinedTypeIDs.PREDEF_TYPE_CHAR_S_ID;
    break;
   case SChar:
    ID = PredefinedTypeIDs.PREDEF_TYPE_SCHAR_ID;
    break;
   case WChar_S:
   case WChar_U:
    ID = PredefinedTypeIDs.PREDEF_TYPE_WCHAR_ID;
    break;
   case Short:
    ID = PredefinedTypeIDs.PREDEF_TYPE_SHORT_ID;
    break;
   case Int:
    ID = PredefinedTypeIDs.PREDEF_TYPE_INT_ID;
    break;
   case Long:
    ID = PredefinedTypeIDs.PREDEF_TYPE_LONG_ID;
    break;
   case LongLong:
    ID = PredefinedTypeIDs.PREDEF_TYPE_LONGLONG_ID;
    break;
   case Int128:
    ID = PredefinedTypeIDs.PREDEF_TYPE_INT128_ID;
    break;
   case Half:
    ID = PredefinedTypeIDs.PREDEF_TYPE_HALF_ID;
    break;
   case Float:
    ID = PredefinedTypeIDs.PREDEF_TYPE_FLOAT_ID;
    break;
   case Double:
    ID = PredefinedTypeIDs.PREDEF_TYPE_DOUBLE_ID;
    break;
   case LongDouble:
    ID = PredefinedTypeIDs.PREDEF_TYPE_LONGDOUBLE_ID;
    break;
   case Float128:
    ID = PredefinedTypeIDs.PREDEF_TYPE_FLOAT128_ID;
    break;
   case NullPtr:
    ID = PredefinedTypeIDs.PREDEF_TYPE_NULLPTR_ID;
    break;
   case Char16:
    ID = PredefinedTypeIDs.PREDEF_TYPE_CHAR16_ID;
    break;
   case Char32:
    ID = PredefinedTypeIDs.PREDEF_TYPE_CHAR32_ID;
    break;
   case Overload:
    ID = PredefinedTypeIDs.PREDEF_TYPE_OVERLOAD_ID;
    break;
   case BoundMember:
    ID = PredefinedTypeIDs.PREDEF_TYPE_BOUND_MEMBER;
    break;
   case PseudoObject:
    ID = PredefinedTypeIDs.PREDEF_TYPE_PSEUDO_OBJECT;
    break;
   case Dependent:
    ID = PredefinedTypeIDs.PREDEF_TYPE_DEPENDENT_ID;
    break;
   case UnknownAny:
    ID = PredefinedTypeIDs.PREDEF_TYPE_UNKNOWN_ANY;
    break;
   case ARCUnbridgedCast:
    ID = PredefinedTypeIDs.PREDEF_TYPE_ARC_UNBRIDGED_CAST;
    break;
   case ObjCId:
    ID = PredefinedTypeIDs.PREDEF_TYPE_OBJC_ID;
    break;
   case ObjCClass:
    ID = PredefinedTypeIDs.PREDEF_TYPE_OBJC_CLASS;
    break;
   case ObjCSel:
    ID = PredefinedTypeIDs.PREDEF_TYPE_OBJC_SEL;
    break;
   case OCLImage1dRO:
    ID = PredefinedTypeIDs.PREDEF_TYPE_OCLImage1dRO_ID;
    break;
   case OCLImage1dArrayRO:
    ID = PredefinedTypeIDs.PREDEF_TYPE_OCLImage1dArrayRO_ID;
    break;
   case OCLImage1dBufferRO:
    ID = PredefinedTypeIDs.PREDEF_TYPE_OCLImage1dBufferRO_ID;
    break;
   case OCLImage2dRO:
    ID = PredefinedTypeIDs.PREDEF_TYPE_OCLImage2dRO_ID;
    break;
   case OCLImage2dArrayRO:
    ID = PredefinedTypeIDs.PREDEF_TYPE_OCLImage2dArrayRO_ID;
    break;
   case OCLImage2dDepthRO:
    ID = PredefinedTypeIDs.PREDEF_TYPE_OCLImage2dDepthRO_ID;
    break;
   case OCLImage2dArrayDepthRO:
    ID = PredefinedTypeIDs.PREDEF_TYPE_OCLImage2dArrayDepthRO_ID;
    break;
   case OCLImage2dMSAARO:
    ID = PredefinedTypeIDs.PREDEF_TYPE_OCLImage2dMSAARO_ID;
    break;
   case OCLImage2dArrayMSAARO:
    ID = PredefinedTypeIDs.PREDEF_TYPE_OCLImage2dArrayMSAARO_ID;
    break;
   case OCLImage2dMSAADepthRO:
    ID = PredefinedTypeIDs.PREDEF_TYPE_OCLImage2dMSAADepthRO_ID;
    break;
   case OCLImage2dArrayMSAADepthRO:
    ID = PredefinedTypeIDs.PREDEF_TYPE_OCLImage2dArrayMSAADepthRO_ID;
    break;
   case OCLImage3dRO:
    ID = PredefinedTypeIDs.PREDEF_TYPE_OCLImage3dRO_ID;
    break;
   case OCLImage1dWO:
    ID = PredefinedTypeIDs.PREDEF_TYPE_OCLImage1dWO_ID;
    break;
   case OCLImage1dArrayWO:
    ID = PredefinedTypeIDs.PREDEF_TYPE_OCLImage1dArrayWO_ID;
    break;
   case OCLImage1dBufferWO:
    ID = PredefinedTypeIDs.PREDEF_TYPE_OCLImage1dBufferWO_ID;
    break;
   case OCLImage2dWO:
    ID = PredefinedTypeIDs.PREDEF_TYPE_OCLImage2dWO_ID;
    break;
   case OCLImage2dArrayWO:
    ID = PredefinedTypeIDs.PREDEF_TYPE_OCLImage2dArrayWO_ID;
    break;
   case OCLImage2dDepthWO:
    ID = PredefinedTypeIDs.PREDEF_TYPE_OCLImage2dDepthWO_ID;
    break;
   case OCLImage2dArrayDepthWO:
    ID = PredefinedTypeIDs.PREDEF_TYPE_OCLImage2dArrayDepthWO_ID;
    break;
   case OCLImage2dMSAAWO:
    ID = PredefinedTypeIDs.PREDEF_TYPE_OCLImage2dMSAAWO_ID;
    break;
   case OCLImage2dArrayMSAAWO:
    ID = PredefinedTypeIDs.PREDEF_TYPE_OCLImage2dArrayMSAAWO_ID;
    break;
   case OCLImage2dMSAADepthWO:
    ID = PredefinedTypeIDs.PREDEF_TYPE_OCLImage2dMSAADepthWO_ID;
    break;
   case OCLImage2dArrayMSAADepthWO:
    ID = PredefinedTypeIDs.PREDEF_TYPE_OCLImage2dArrayMSAADepthWO_ID;
    break;
   case OCLImage3dWO:
    ID = PredefinedTypeIDs.PREDEF_TYPE_OCLImage3dWO_ID;
    break;
   case OCLImage1dRW:
    ID = PredefinedTypeIDs.PREDEF_TYPE_OCLImage1dRW_ID;
    break;
   case OCLImage1dArrayRW:
    ID = PredefinedTypeIDs.PREDEF_TYPE_OCLImage1dArrayRW_ID;
    break;
   case OCLImage1dBufferRW:
    ID = PredefinedTypeIDs.PREDEF_TYPE_OCLImage1dBufferRW_ID;
    break;
   case OCLImage2dRW:
    ID = PredefinedTypeIDs.PREDEF_TYPE_OCLImage2dRW_ID;
    break;
   case OCLImage2dArrayRW:
    ID = PredefinedTypeIDs.PREDEF_TYPE_OCLImage2dArrayRW_ID;
    break;
   case OCLImage2dDepthRW:
    ID = PredefinedTypeIDs.PREDEF_TYPE_OCLImage2dDepthRW_ID;
    break;
   case OCLImage2dArrayDepthRW:
    ID = PredefinedTypeIDs.PREDEF_TYPE_OCLImage2dArrayDepthRW_ID;
    break;
   case OCLImage2dMSAARW:
    ID = PredefinedTypeIDs.PREDEF_TYPE_OCLImage2dMSAARW_ID;
    break;
   case OCLImage2dArrayMSAARW:
    ID = PredefinedTypeIDs.PREDEF_TYPE_OCLImage2dArrayMSAARW_ID;
    break;
   case OCLImage2dMSAADepthRW:
    ID = PredefinedTypeIDs.PREDEF_TYPE_OCLImage2dMSAADepthRW_ID;
    break;
   case OCLImage2dArrayMSAADepthRW:
    ID = PredefinedTypeIDs.PREDEF_TYPE_OCLImage2dArrayMSAADepthRW_ID;
    break;
   case OCLImage3dRW:
    ID = PredefinedTypeIDs.PREDEF_TYPE_OCLImage3dRW_ID;
    break;
   case OCLSampler:
    ID = PredefinedTypeIDs.PREDEF_TYPE_SAMPLER_ID;
    break;
   case OCLEvent:
    ID = PredefinedTypeIDs.PREDEF_TYPE_EVENT_ID;
    break;
   case OCLClkEvent:
    ID = PredefinedTypeIDs.PREDEF_TYPE_CLK_EVENT_ID;
    break;
   case OCLQueue:
    ID = PredefinedTypeIDs.PREDEF_TYPE_QUEUE_ID;
    break;
   case OCLNDRange:
    ID = PredefinedTypeIDs.PREDEF_TYPE_NDRANGE_ID;
    break;
   case OCLReserveID:
    ID = PredefinedTypeIDs.PREDEF_TYPE_RESERVE_ID_ID;
    break;
   case BuiltinFn:
    ID = PredefinedTypeIDs.PREDEF_TYPE_BUILTIN_FN;
    break;
   case OMPArraySection:
    ID = PredefinedTypeIDs.PREDEF_TYPE_OMP_ARRAY_SECTION;
    break;
  }
  
  return new TypeIdx(ID);
}

/*template <typename IdxForTypeTy> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="clang::serialization::MakeTypeID">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTCommon.h", line = 48,
 FQN="clang::serialization::MakeTypeID", NM="Tpl__ZN5clang13serialization10MakeTypeIDERNS_10ASTContextENS_8QualTypeET_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTCommon.cpp -nm=Tpl__ZN5clang13serialization10MakeTypeIDERNS_10ASTContextENS_8QualTypeET_")
//</editor-fold>
public static </*typename*/ IdxForTypeTy extends QualType2TypeIdx> /*uint32_t*/int MakeTypeID(final ASTContext /*&*/ Context, QualType T, IdxForTypeTy IdxForType) {
  if (T.isNull()) {
    return PredefinedTypeIDs.PREDEF_TYPE_NULL_ID;
  }
  
  /*uint*/int FastQuals = T.getLocalFastQualifiers();
  T.removeLocalFastQualifiers();
  if (T.hasLocalNonFastQualifiers()) {
    return IdxForType.$call(T).asTypeID(FastQuals);
  }
  assert (!T.hasLocalQualifiers());
  {
    
    /*const*/ BuiltinType /*P*/ BT = dyn_cast_BuiltinType(T.getTypePtr());
    if ((BT != null)) {
      return TypeIdxFromBuiltin(BT).asTypeID(FastQuals);
    }
  }
  if (QualType.$eq_QualType$C(T, Context.AutoDeductTy)) {
    return new TypeIdx(PredefinedTypeIDs.PREDEF_TYPE_AUTO_DEDUCT).asTypeID(FastQuals);
  }
  if (QualType.$eq_QualType$C(T, Context.AutoRRefDeductTy)) {
    return new TypeIdx(PredefinedTypeIDs.PREDEF_TYPE_AUTO_RREF_DEDUCT).asTypeID(FastQuals);
  }
  
  return IdxForType.$call(T).asTypeID(FastQuals);
}

//<editor-fold defaultstate="collapsed" desc="clang::serialization::ComputeHash">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTCommon.cpp", line = 167,
 FQN="clang::serialization::ComputeHash", NM="_ZN5clang13serialization11ComputeHashENS_8SelectorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTCommon.cpp -nm=_ZN5clang13serialization11ComputeHashENS_8SelectorE")
//</editor-fold>
public static /*uint*/int ComputeHash(Selector Sel) {
  /*uint*/int N = Sel.getNumArgs();
  if (N == 0) {
    ++N;
  }
  /*uint*/int R = 5381;
  for (/*uint*/int I = 0; I != N; ++I)  {
    {
      IdentifierInfo /*P*/ II = Sel.getIdentifierInfoForSlot(I);
      if ((II != null)) {
        R = llvm.HashString(II.getName(), R);
      }
    }
  }
  return R;
}


/// \brief Retrieve the "definitive" declaration that provides all of the
/// visible entries for the given declaration context, if there is one.
///
/// The "definitive" declaration is the only place where we need to look to
/// find information about the declarations within the given declaration
/// context. For example, C++ and Objective-C classes, C structs/unions, and
/// Objective-C protocols, categories, and extensions are all defined in a
/// single place in the source code, so they have definitive declarations
/// associated with them. C++ namespaces, on the other hand, can have
/// multiple definitions.
//<editor-fold defaultstate="collapsed" desc="clang::serialization::getDefinitiveDeclContext">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTCommon.cpp", line = 178,
 FQN="clang::serialization::getDefinitiveDeclContext", NM="_ZN5clang13serialization24getDefinitiveDeclContextEPKNS_11DeclContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTCommon.cpp -nm=_ZN5clang13serialization24getDefinitiveDeclContextEPKNS_11DeclContextE")
//</editor-fold>
public static /*const*/ DeclContext /*P*/ getDefinitiveDeclContext(/*const*/ DeclContext /*P*/ DC) {
  switch (DC.getDeclKind()) {
   case TranslationUnit:
   case ExternCContext:
   case Namespace:
   case LinkageSpec:
    // These entities may have multiple definitions.
    return null;
   case Enum:
   case Record:
    {
      
      // C/C++ tag types can only be defined in one place.
      /*const*/ TagDecl /*P*/ Def = cast_TagDecl(DC).getDefinition();
      if ((Def != null)) {
        return Def;
      }
    }
    return null;
   case CXXRecord:
   case ClassTemplateSpecialization:
   case ClassTemplatePartialSpecialization:
    
    // FIXME: These can be defined in one place... except special member
    // functions and out-of-line definitions.
    return null;
   case Function:
   case CXXMethod:
   case CXXConstructor:
   case CXXDestructor:
   case CXXConversion:
   case ObjCMethod:
   case Block:
   case Captured:
   case ObjCCategory:
   case ObjCCategoryImpl:
   case ObjCImplementation:
    // Objective C categories, category implementations, and class
    // implementations can only be defined in one place.
    return DC;
   case ObjCProtocol:
    {
      /*const*/ ObjCProtocolDecl /*P*/ Def = cast_ObjCProtocolDecl(DC).getDefinition$Const();
      if ((Def != null)) {
        return Def;
      }
    }
    return null;
   case ObjCInterface:
    
    // FIXME: These are defined in one place, but properties in class extensions
    // end up being back-patched into the main interface. See
    // Sema::HandlePropertyInClassExtension for the offending code.
    return null;
   default:
    throw new llvm_unreachable("Unhandled DeclContext in AST reader");
  }
  //throw new llvm_unreachable("Unhandled decl kind");
}


/// \brief Determine whether the given declaration kind is redeclarable.
//<editor-fold defaultstate="collapsed" desc="clang::serialization::isRedeclarableDeclKind">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTCommon.cpp", line = 237,
 FQN="clang::serialization::isRedeclarableDeclKind", NM="_ZN5clang13serialization22isRedeclarableDeclKindEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTCommon.cpp -nm=_ZN5clang13serialization22isRedeclarableDeclKindEj")
//</editor-fold>
public static boolean isRedeclarableDeclKind(/*uint*/int Kind) {
  switch (/*static_cast*/Decl.Kind.valueOf(Kind)) {
   case TranslationUnit:
   case ExternCContext:
    // Special case of a "merged" declaration.
    return true;
   case Namespace:
   case NamespaceAlias:
   case Typedef:
   case TypeAlias:
   case Enum:
   case Record:
   case CXXRecord:
   case ClassTemplateSpecialization:
   case ClassTemplatePartialSpecialization:
   case VarTemplateSpecialization:
   case VarTemplatePartialSpecialization:
   case Function:
   case CXXMethod:
   case CXXConstructor:
   case CXXDestructor:
   case CXXConversion:
   case UsingShadow:
   case ConstructorUsingShadow:
   case Var:
   case FunctionTemplate:
   case ClassTemplate:
   case VarTemplate:
   case TypeAliasTemplate:
   case ObjCProtocol:
   case ObjCInterface:
   case Empty:
    return true;
   case UsingDirective:
   case Label:
   case UnresolvedUsingTypename:
   case TemplateTypeParm:
   case EnumConstant:
   case UnresolvedUsingValue:
   case IndirectField:
   case Field:
   case MSProperty:
   case ObjCIvar:
   case ObjCAtDefsField:
   case NonTypeTemplateParm:
   case TemplateTemplateParm:
   case Using:
   case ObjCMethod:
   case ObjCCategory:
   case ObjCCategoryImpl:
   case ObjCImplementation:
   case ObjCProperty:
   case ObjCCompatibleAlias:
   case LinkageSpec:
   case ObjCPropertyImpl:
   case PragmaComment:
   case PragmaDetectMismatch:
   case FileScopeAsm:
   case AccessSpec:
   case Friend:
   case FriendTemplate:
   case StaticAssert:
   case Block:
   case Captured:
   case ClassScopeFunctionSpecialization:
   case Import:
   case OMPThreadPrivate:
   case OMPCapturedExpr:
   case OMPDeclareReduction:
   case BuiltinTemplate:
    
    // Never redeclarable.
    return false;
   case ImplicitParam:
   case ParmVar:
   case ObjCTypeParam:
    
    // These indirectly derive from Redeclarable<T> but are not actually
    // redeclarable.
    return false;
  }
  throw new llvm_unreachable("Unhandled declaration kind");
}


/// \brief Determine whether the given declaration needs an anonymous
/// declaration number.
//<editor-fold defaultstate="collapsed" desc="clang::serialization::needsAnonymousDeclarationNumber">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTCommon.cpp", line = 323,
 FQN="clang::serialization::needsAnonymousDeclarationNumber", NM="_ZN5clang13serialization31needsAnonymousDeclarationNumberEPKNS_9NamedDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTCommon.cpp -nm=_ZN5clang13serialization31needsAnonymousDeclarationNumberEPKNS_9NamedDeclE")
//</editor-fold>
public static boolean needsAnonymousDeclarationNumber(/*const*/ NamedDecl /*P*/ D) {
  // Friend declarations in dependent contexts aren't anonymous in the usual
  // sense, but they cannot be found by name lookup in their semantic context
  // (or indeed in any context), so we treat them as anonymous.
  //
  // This doesn't apply to friend tag decls; Sema makes those available to name
  // lookup in the surrounding context.
  if ((D.getFriendObjectKind().getValue() != 0)
     && D.getLexicalDeclContext$Const().isDependentContext() && !isa_TagDecl(D)) {
    {
      // For function templates and class templates, the template is numbered and
      // not its pattern.
      /*const*/ FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(D);
      if ((FD != null)) {
        return !(FD.getDescribedFunctionTemplate() != null);
      }
    }
    {
      /*const*/ CXXRecordDecl /*P*/ RD = dyn_cast_CXXRecordDecl(D);
      if ((RD != null)) {
        return !(RD.getDescribedClassTemplate() != null);
      }
    }
    return true;
  }
  
  // Otherwise, we only care about anonymous class members.
  if (D.getDeclName().$bool() || !isa_CXXRecordDecl(D.getLexicalDeclContext$Const())) {
    return false;
  }
  return isa_TagDecl(D) || isa_FieldDecl(D);
}


/// \brief Visit each declaration within \c DC that needs an anonymous
/// declaration number and call \p Visit with the declaration and its number.
/*template <typename Fn> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="clang::serialization::numberAnonymousDeclsWithin">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTCommon.h", line = 94,
 FQN="clang::serialization::numberAnonymousDeclsWithin", NM="Tpl__ZN5clang13serialization26numberAnonymousDeclsWithinEPKNS_11DeclContextET_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTCommon.cpp -nm=Tpl__ZN5clang13serialization26numberAnonymousDeclsWithinEPKNS_11DeclContextET_")
//</editor-fold>
public static </*typename*/ Fn extends NamedDeclUInt2Void> void numberAnonymousDeclsWithin(/*const*/ DeclContext /*P*/ DC, 
                          Fn Visit) {
  /*uint*/int Index = 0;
  for (Decl /*P*/ LexicalD : DC.decls()) {
    {
      // For a friend decl, we care about the declaration within it, if any.
      FriendDecl /*P*/ FD = dyn_cast_FriendDecl(LexicalD);
      if ((FD != null)) {
        LexicalD = FD.getFriendDecl();
      }
    }
    
    NamedDecl /*P*/ ND = dyn_cast_or_null_NamedDecl(LexicalD);
    if (!(ND != null) || !needsAnonymousDeclarationNumber(ND)) {
      continue;
    }
    
    Visit.$call(ND, Index++);
  }
}

} // END OF class SerializationStatics
