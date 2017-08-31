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
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.ast.*;
import static org.clang.ast.java.AstJavaFixedRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstTypesRTTI.*;
import static org.clang.ast.AstClangGlobals.*;
import org.clang.ast.DeclContext.*;
import static org.clang.ast.DeclContext.specific_decl_iterator.*;
import static org.clang.basic.BasicClangGlobals.*;


//<editor-fold defaultstate="collapsed" desc="static type ASTImporterStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZL13getFieldIndexPN5clang4DeclE;_ZL14ImportCastPathPN5clang8CastExprERN4llvm11SmallVectorIPNS_16CXXBaseSpecifierELj4EEE;_ZL24IsStructurallyEquivalentPKN5clang14IdentifierInfoES2_;_ZL24IsStructurallyEquivalentRN12_GLOBAL__N_128StructuralEquivalenceContextEN5clang8QualTypeES3_;_ZL24IsStructurallyEquivalentRN12_GLOBAL__N_128StructuralEquivalenceContextEPN5clang10RecordDeclES4_;_ZL24IsStructurallyEquivalentRN12_GLOBAL__N_128StructuralEquivalenceContextEPN5clang17ClassTemplateDeclES4_;_ZL24IsStructurallyEquivalentRN12_GLOBAL__N_128StructuralEquivalenceContextEPN5clang19NestedNameSpecifierES4_;_ZL24IsStructurallyEquivalentRN12_GLOBAL__N_128StructuralEquivalenceContextEPN5clang20TemplateTypeParmDeclES4_;_ZL24IsStructurallyEquivalentRN12_GLOBAL__N_128StructuralEquivalenceContextEPN5clang21TemplateParameterListES4_;_ZL24IsStructurallyEquivalentRN12_GLOBAL__N_128StructuralEquivalenceContextEPN5clang23NonTypeTemplateParmDeclES4_;_ZL24IsStructurallyEquivalentRN12_GLOBAL__N_128StructuralEquivalenceContextEPN5clang24TemplateTemplateParmDeclES4_;_ZL24IsStructurallyEquivalentRN12_GLOBAL__N_128StructuralEquivalenceContextEPN5clang4DeclES4_;_ZL24IsStructurallyEquivalentRN12_GLOBAL__N_128StructuralEquivalenceContextEPN5clang4ExprES4_;_ZL24IsStructurallyEquivalentRN12_GLOBAL__N_128StructuralEquivalenceContextEPN5clang8EnumDeclES4_;_ZL24IsStructurallyEquivalentRN12_GLOBAL__N_128StructuralEquivalenceContextEPN5clang9FieldDeclES4_;_ZL24IsStructurallyEquivalentRN12_GLOBAL__N_128StructuralEquivalenceContextERKN5clang16TemplateArgumentES5_;_ZL29IsArrayStructurallyEquivalentRN12_GLOBAL__N_128StructuralEquivalenceContextEPKN5clang9ArrayTypeES5_;_ZL30findUntaggedStructOrUnionIndexPN5clang10RecordDeclE; -static-type=ASTImporterStatics -package=org.clang.ast.impl")
//</editor-fold>
public final class ASTImporterStatics {


/// \brief Determine structural equivalence of two types.
//<editor-fold defaultstate="collapsed" desc="IsStructurallyEquivalent">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 466,
 FQN="IsStructurallyEquivalent", NM="_ZL24IsStructurallyEquivalentRN12_GLOBAL__N_128StructuralEquivalenceContextEN5clang8QualTypeES3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZL24IsStructurallyEquivalentRN12_GLOBAL__N_128StructuralEquivalenceContextEN5clang8QualTypeES3_")
//</editor-fold>
public static boolean IsStructurallyEquivalent(final StructuralEquivalenceContext /*&*/ Context, 
                        QualType T1, QualType T2) {
  if (T1.isNull() || T2.isNull()) {
    return T1.isNull() && T2.isNull();
  }
  if (!Context.StrictTypeSpelling) {
    // We aren't being strict about token-to-token equivalence of types,
    // so map down to the canonical type.
    T1.$assignMove(Context.C1.getCanonicalType(new QualType(T1)).$QualType());
    T2.$assignMove(Context.C2.getCanonicalType(new QualType(T2)).$QualType());
  }
  if (T1.getQualifiers().$noteq(T2.getQualifiers())) {
    return false;
  }
  
  Type.TypeClass TC = T1.$arrow().getTypeClass();
  if (T1.$arrow().getTypeClass() != T2.$arrow().getTypeClass()) {
    // Compare function types with prototypes vs. without prototypes as if
    // both did not have prototypes.
    if (T1.$arrow().getTypeClass() == Type.TypeClass.FunctionProto
       && T2.$arrow().getTypeClass() == Type.TypeClass.FunctionNoProto) {
      TC = Type.TypeClass.FunctionNoProto;
    } else if (T1.$arrow().getTypeClass() == Type.TypeClass.FunctionNoProto
       && T2.$arrow().getTypeClass() == Type.TypeClass.FunctionProto) {
      TC = Type.TypeClass.FunctionNoProto;
    } else {
      return false;
    }
  }
  switch (TC) {
   case Builtin:
    // FIXME: Deal with Char_S/Char_U. 
    if (cast_BuiltinType(T1).getKind() != cast_BuiltinType(T2).getKind()) {
      return false;
    }
    break;
   case Complex:
    if (!IsStructurallyEquivalent(Context, 
        cast_ComplexType(T1).getElementType(), 
        cast_ComplexType(T2).getElementType())) {
      return false;
    }
    break;
   case Adjusted:
   case Decayed:
    if (!IsStructurallyEquivalent(Context, 
        cast_AdjustedType(T1).getOriginalType(), 
        cast_AdjustedType(T2).getOriginalType())) {
      return false;
    }
    break;
   case Pointer:
    if (!IsStructurallyEquivalent(Context, 
        cast_PointerType(T1).getPointeeType(), 
        cast_PointerType(T2).getPointeeType())) {
      return false;
    }
    break;
   case BlockPointer:
    if (!IsStructurallyEquivalent(Context, 
        cast_BlockPointerType(T1).getPointeeType(), 
        cast_BlockPointerType(T2).getPointeeType())) {
      return false;
    }
    break;
   case LValueReference:
   case RValueReference:
    {
      /*const*/ ReferenceType /*P*/ Ref1 = cast_ReferenceType(T1);
      /*const*/ ReferenceType /*P*/ Ref2 = cast_ReferenceType(T2);
      if (Ref1.isSpelledAsLValue() != Ref2.isSpelledAsLValue()) {
        return false;
      }
      if (Ref1.isInnerRef() != Ref2.isInnerRef()) {
        return false;
      }
      if (!IsStructurallyEquivalent(Context, 
          Ref1.getPointeeTypeAsWritten(), 
          Ref2.getPointeeTypeAsWritten())) {
        return false;
      }
      break;
    }
   case MemberPointer:
    {
      /*const*/ MemberPointerType /*P*/ MemPtr1 = cast_MemberPointerType(T1);
      /*const*/ MemberPointerType /*P*/ MemPtr2 = cast_MemberPointerType(T2);
      if (!IsStructurallyEquivalent(Context, 
          MemPtr1.getPointeeType(), 
          MemPtr2.getPointeeType())) {
        return false;
      }
      if (!IsStructurallyEquivalent(Context, 
          new QualType(MemPtr1.__getClass(), 0), 
          new QualType(MemPtr2.__getClass(), 0))) {
        return false;
      }
      break;
    }
   case ConstantArray:
    {
      /*const*/ ConstantArrayType /*P*/ Array1 = cast_ConstantArrayType(T1);
      /*const*/ ConstantArrayType /*P*/ Array2 = cast_ConstantArrayType(T2);
      if (!APInt.isSameValue(Array1.getSize(), Array2.getSize())) {
        return false;
      }
      if (!IsArrayStructurallyEquivalent(Context, Array1, Array2)) {
        return false;
      }
      break;
    }
   case IncompleteArray:
    if (!IsArrayStructurallyEquivalent(Context, 
        cast_ArrayType(T1), 
        cast_ArrayType(T2))) {
      return false;
    }
    break;
   case VariableArray:
    {
      /*const*/ VariableArrayType /*P*/ Array1 = cast_VariableArrayType(T1);
      /*const*/ VariableArrayType /*P*/ Array2 = cast_VariableArrayType(T2);
      if (!IsStructurallyEquivalent(Context, 
          Array1.getSizeExpr(), Array2.getSizeExpr())) {
        return false;
      }
      if (!IsArrayStructurallyEquivalent(Context, Array1, Array2)) {
        return false;
      }
      
      break;
    }
   case DependentSizedArray:
    {
      /*const*/ DependentSizedArrayType /*P*/ Array1 = cast_DependentSizedArrayType(T1);
      /*const*/ DependentSizedArrayType /*P*/ Array2 = cast_DependentSizedArrayType(T2);
      if (!IsStructurallyEquivalent(Context, 
          Array1.getSizeExpr(), Array2.getSizeExpr())) {
        return false;
      }
      if (!IsArrayStructurallyEquivalent(Context, Array1, Array2)) {
        return false;
      }
      
      break;
    }
   case DependentSizedExtVector:
    {
      /*const*/ DependentSizedExtVectorType /*P*/ Vec1 = cast_DependentSizedExtVectorType(T1);
      /*const*/ DependentSizedExtVectorType /*P*/ Vec2 = cast_DependentSizedExtVectorType(T2);
      if (!IsStructurallyEquivalent(Context, 
          Vec1.getSizeExpr(), Vec2.getSizeExpr())) {
        return false;
      }
      if (!IsStructurallyEquivalent(Context, 
          Vec1.getElementType(), 
          Vec2.getElementType())) {
        return false;
      }
      break;
    }
   case Vector:
   case ExtVector:
    {
      /*const*/ VectorType /*P*/ Vec1 = cast_VectorType(T1);
      /*const*/ VectorType /*P*/ Vec2 = cast_VectorType(T2);
      if (!IsStructurallyEquivalent(Context, 
          Vec1.getElementType(), 
          Vec2.getElementType())) {
        return false;
      }
      if (Vec1.getNumElements() != Vec2.getNumElements()) {
        return false;
      }
      if (Vec1.getVectorKind() != Vec2.getVectorKind()) {
        return false;
      }
      break;
    }
   case FunctionProto:
    {
      /*const*/ FunctionProtoType /*P*/ Proto1 = cast_FunctionProtoType(T1);
      /*const*/ FunctionProtoType /*P*/ Proto2 = cast_FunctionProtoType(T2);
      if (Proto1.getNumParams() != Proto2.getNumParams()) {
        return false;
      }
      for (/*uint*/int I = 0, N = Proto1.getNumParams(); I != N; ++I) {
        if (!IsStructurallyEquivalent(Context, Proto1.getParamType(I), 
            Proto2.getParamType(I))) {
          return false;
        }
      }
      if (Proto1.isVariadic() != Proto2.isVariadic()) {
        return false;
      }
      if (Proto1.getExceptionSpecType() != Proto2.getExceptionSpecType()) {
        return false;
      }
      if (Proto1.getExceptionSpecType() == ExceptionSpecificationType.EST_Dynamic) {
        if (Proto1.getNumExceptions() != Proto2.getNumExceptions()) {
          return false;
        }
        for (/*uint*/int I = 0, N = Proto1.getNumExceptions(); I != N; ++I) {
          if (!IsStructurallyEquivalent(Context, 
              Proto1.getExceptionType(I), 
              Proto2.getExceptionType(I))) {
            return false;
          }
        }
      } else if (Proto1.getExceptionSpecType() == ExceptionSpecificationType.EST_ComputedNoexcept) {
        if (!IsStructurallyEquivalent(Context, 
            Proto1.getNoexceptExpr(), 
            Proto2.getNoexceptExpr())) {
          return false;
        }
      }
      if (Proto1.getTypeQuals() != Proto2.getTypeQuals()) {
        return false;
      }
      // Fall through to check the bits common with FunctionNoProtoType.
    }
   case FunctionNoProto:
    {
      /*const*/ FunctionType /*P*/ Function1 = cast_FunctionType(T1);
      /*const*/ FunctionType /*P*/ Function2 = cast_FunctionType(T2);
      if (!IsStructurallyEquivalent(Context, Function1.getReturnType(), 
          Function2.getReturnType())) {
        return false;
      }
      if (Function1.getExtInfo().$noteq(Function2.getExtInfo())) {
        return false;
      }
      break;
    }
   case UnresolvedUsing:
    if (!IsStructurallyEquivalent(Context, 
        cast_UnresolvedUsingType(T1).getDecl(), 
        cast_UnresolvedUsingType(T2).getDecl())) {
      return false;
    }
    
    break;
   case Attributed:
    if (!IsStructurallyEquivalent(Context, 
        cast_AttributedType(T1).getModifiedType(), 
        cast_AttributedType(T2).getModifiedType())) {
      return false;
    }
    if (!IsStructurallyEquivalent(Context, 
        cast_AttributedType(T1).getEquivalentType(), 
        cast_AttributedType(T2).getEquivalentType())) {
      return false;
    }
    break;
   case Paren:
    if (!IsStructurallyEquivalent(Context, 
        cast_ParenType(T1).getInnerType(), 
        cast_ParenType(T2).getInnerType())) {
      return false;
    }
    break;
   case Typedef:
    if (!IsStructurallyEquivalent(Context, 
        cast_TypedefType(T1).getDecl(), 
        cast_TypedefType(T2).getDecl())) {
      return false;
    }
    break;
   case TypeOfExpr:
    if (!IsStructurallyEquivalent(Context, 
        cast_TypeOfExprType(T1).getUnderlyingExpr(), 
        cast_TypeOfExprType(T2).getUnderlyingExpr())) {
      return false;
    }
    break;
   case TypeOf:
    if (!IsStructurallyEquivalent(Context, 
        cast_TypeOfType(T1).getUnderlyingType(), 
        cast_TypeOfType(T2).getUnderlyingType())) {
      return false;
    }
    break;
   case UnaryTransform:
    if (!IsStructurallyEquivalent(Context, 
        cast_UnaryTransformType(T1).getUnderlyingType(), 
        cast_UnaryTransformType(T1).getUnderlyingType())) {
      return false;
    }
    break;
   case Decltype:
    if (!IsStructurallyEquivalent(Context, 
        cast_DecltypeType(T1).getUnderlyingExpr(), 
        cast_DecltypeType(T2).getUnderlyingExpr())) {
      return false;
    }
    break;
   case Auto:
    if (!IsStructurallyEquivalent(Context, 
        cast_AutoType(T1).getDeducedType(), 
        cast_AutoType(T2).getDeducedType())) {
      return false;
    }
    break;
   case Record:
   case Enum:
    if (!IsStructurallyEquivalent(Context, 
        cast_TagType(T1).getDecl(), 
        cast_TagType(T2).getDecl())) {
      return false;
    }
    break;
   case TemplateTypeParm:
    {
      /*const*/ TemplateTypeParmType /*P*/ Parm1 = cast_TemplateTypeParmType(T1);
      /*const*/ TemplateTypeParmType /*P*/ Parm2 = cast_TemplateTypeParmType(T2);
      if (Parm1.getDepth() != Parm2.getDepth()) {
        return false;
      }
      if (Parm1.getIndex() != Parm2.getIndex()) {
        return false;
      }
      if (Parm1.isParameterPack() != Parm2.isParameterPack()) {
        return false;
      }
      
      // Names of template type parameters are never significant.
      break;
    }
   case SubstTemplateTypeParm:
    {
      /*const*/ SubstTemplateTypeParmType /*P*/ Subst1 = cast_SubstTemplateTypeParmType(T1);
      /*const*/ SubstTemplateTypeParmType /*P*/ Subst2 = cast_SubstTemplateTypeParmType(T2);
      if (!IsStructurallyEquivalent(Context, 
          new QualType(Subst1.getReplacedParameter(), 0), 
          new QualType(Subst2.getReplacedParameter(), 0))) {
        return false;
      }
      if (!IsStructurallyEquivalent(Context, 
          Subst1.getReplacementType(), 
          Subst2.getReplacementType())) {
        return false;
      }
      break;
    }
   case SubstTemplateTypeParmPack:
    {
      /*const*/ SubstTemplateTypeParmPackType /*P*/ Subst1 = cast_SubstTemplateTypeParmPackType(T1);
      /*const*/ SubstTemplateTypeParmPackType /*P*/ Subst2 = cast_SubstTemplateTypeParmPackType(T2);
      if (!IsStructurallyEquivalent(Context, 
          new QualType(Subst1.getReplacedParameter(), 0), 
          new QualType(Subst2.getReplacedParameter(), 0))) {
        return false;
      }
      if (!IsStructurallyEquivalent(Context, 
          Subst1.getArgumentPack(), 
          Subst2.getArgumentPack())) {
        return false;
      }
      break;
    }
   case TemplateSpecialization:
    {
      /*const*/ TemplateSpecializationType /*P*/ Spec1 = cast_TemplateSpecializationType(T1);
      /*const*/ TemplateSpecializationType /*P*/ Spec2 = cast_TemplateSpecializationType(T2);
      if (!IsStructurallyEquivalent(Context, 
          new TemplateArgument(Spec1.getTemplateName()), 
          new TemplateArgument(Spec2.getTemplateName()))) {
        return false;
      }
      if (Spec1.getNumArgs() != Spec2.getNumArgs()) {
        return false;
      }
      for (/*uint*/int I = 0, N = Spec1.getNumArgs(); I != N; ++I) {
        if (!IsStructurallyEquivalent(Context, 
            Spec1.getArg(I), Spec2.getArg(I))) {
          return false;
        }
      }
      break;
    }
   case Elaborated:
    {
      /*const*/ ElaboratedType /*P*/ Elab1 = cast_ElaboratedType(T1);
      /*const*/ ElaboratedType /*P*/ Elab2 = cast_ElaboratedType(T2);
      // CHECKME: what if a keyword is ETK_None or ETK_typename ?
      if (Elab1.getKeyword() != Elab2.getKeyword()) {
        return false;
      }
      if (!IsStructurallyEquivalent(Context, 
          Elab1.getQualifier(), 
          Elab2.getQualifier())) {
        return false;
      }
      if (!IsStructurallyEquivalent(Context, 
          Elab1.getNamedType(), 
          Elab2.getNamedType())) {
        return false;
      }
      break;
    }
   case InjectedClassName:
    {
      /*const*/ InjectedClassNameType /*P*/ Inj1 = cast_InjectedClassNameType(T1);
      /*const*/ InjectedClassNameType /*P*/ Inj2 = cast_InjectedClassNameType(T2);
      if (!IsStructurallyEquivalent(Context, 
          Inj1.getInjectedSpecializationType(), 
          Inj2.getInjectedSpecializationType())) {
        return false;
      }
      break;
    }
   case DependentName:
    {
      /*const*/ DependentNameType /*P*/ Typename1 = cast_DependentNameType(T1);
      /*const*/ DependentNameType /*P*/ Typename2 = cast_DependentNameType(T2);
      if (!IsStructurallyEquivalent(Context, 
          Typename1.getQualifier(), 
          Typename2.getQualifier())) {
        return false;
      }
      if (!IsStructurallyEquivalent(Typename1.getIdentifier(), 
          Typename2.getIdentifier())) {
        return false;
      }
      
      break;
    }
   case DependentTemplateSpecialization:
    {
      /*const*/ DependentTemplateSpecializationType /*P*/ Spec1 = cast_DependentTemplateSpecializationType(T1);
      /*const*/ DependentTemplateSpecializationType /*P*/ Spec2 = cast_DependentTemplateSpecializationType(T2);
      if (!IsStructurallyEquivalent(Context, 
          Spec1.getQualifier(), 
          Spec2.getQualifier())) {
        return false;
      }
      if (!IsStructurallyEquivalent(Spec1.getIdentifier(), 
          Spec2.getIdentifier())) {
        return false;
      }
      if (Spec1.getNumArgs() != Spec2.getNumArgs()) {
        return false;
      }
      for (/*uint*/int I = 0, N = Spec1.getNumArgs(); I != N; ++I) {
        if (!IsStructurallyEquivalent(Context, 
            Spec1.getArg(I), Spec2.getArg(I))) {
          return false;
        }
      }
      break;
    }
   case PackExpansion:
    if (!IsStructurallyEquivalent(Context, 
        cast_PackExpansionType(T1).getPattern(), 
        cast_PackExpansionType(T2).getPattern())) {
      return false;
    }
    break;
   case ObjCInterface:
    {
      /*const*/ ObjCInterfaceType /*P*/ Iface1 = cast_ObjCInterfaceType(T1);
      /*const*/ ObjCInterfaceType /*P*/ Iface2 = cast_ObjCInterfaceType(T2);
      if (!IsStructurallyEquivalent(Context, 
          Iface1.getDecl(), Iface2.getDecl())) {
        return false;
      }
      break;
    }
   case ObjCObject:
    {
      /*const*/ ObjCObjectType /*P*/ Obj1 = cast_ObjCObjectType(T1);
      /*const*/ ObjCObjectType /*P*/ Obj2 = cast_ObjCObjectType(T2);
      if (!IsStructurallyEquivalent(Context, 
          Obj1.getBaseType(), 
          Obj2.getBaseType())) {
        return false;
      }
      if (Obj1.getNumProtocols() != Obj2.getNumProtocols()) {
        return false;
      }
      for (/*uint*/int I = 0, N = Obj1.getNumProtocols(); I != N; ++I) {
        if (!IsStructurallyEquivalent(Context, 
            Obj1.getProtocol(I), 
            Obj2.getProtocol(I))) {
          return false;
        }
      }
      break;
    }
   case ObjCObjectPointer:
    {
      /*const*/ ObjCObjectPointerType /*P*/ Ptr1 = cast_ObjCObjectPointerType(T1);
      /*const*/ ObjCObjectPointerType /*P*/ Ptr2 = cast_ObjCObjectPointerType(T2);
      if (!IsStructurallyEquivalent(Context, 
          Ptr1.getPointeeType(), 
          Ptr2.getPointeeType())) {
        return false;
      }
      break;
    }
   case Atomic:
    {
      if (!IsStructurallyEquivalent(Context, 
          cast_AtomicType(T1).getValueType(), 
          cast_AtomicType(T2).getValueType())) {
        return false;
      }
      break;
    }
   case Pipe:
    {
      if (!IsStructurallyEquivalent(Context, 
          cast_PipeType(T1).getElementType(), 
          cast_PipeType(T2).getElementType())) {
        return false;
      }
      break;
    }
  } // end switch
  
  return true;
}


/// \brief Determine structural equivalence of two declarations.
//<editor-fold defaultstate="collapsed" desc="IsStructurallyEquivalent">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 1394,
 FQN="IsStructurallyEquivalent", NM="_ZL24IsStructurallyEquivalentRN12_GLOBAL__N_128StructuralEquivalenceContextEPN5clang4DeclES4_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZL24IsStructurallyEquivalentRN12_GLOBAL__N_128StructuralEquivalenceContextEPN5clang4DeclES4_")
//</editor-fold>
public static boolean IsStructurallyEquivalent(final StructuralEquivalenceContext /*&*/ Context, 
                        Decl /*P*/ D1, Decl /*P*/ D2) {
  // FIXME: Check for known structural equivalences via a callback of some sort.
  
  // Check whether we already know that these two declarations are not
  // structurally equivalent.
  if ((Context.NonEquivalentDecls.count(std.make_pair_Ptr_Ptr(D1.getCanonicalDecl(), 
          D2.getCanonicalDecl())) != 0)) {
    return false;
  }
  
  // Determine whether we've already produced a tentative equivalence for D1.
  final Decl /*P*/ /*&*/ EquivToD1 = Context.TentativeEquivalences.$at_T1$RR(D1.getCanonicalDecl());
  if ((EquivToD1 != null)) {
    return EquivToD1 == D2.getCanonicalDecl();
  }
  
  // Produce a tentative equivalence D1 <-> D2, which will be checked later.
  Context.TentativeEquivalences.$set(D1.getCanonicalDecl(), D2.getCanonicalDecl());
  Context.DeclsToCheck.push_back_T$RR(D1.getCanonicalDecl());
  return true;
}


/// \brief Determine structural equivalence of two expressions.
//<editor-fold defaultstate="collapsed" desc="IsStructurallyEquivalent">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 365,
 FQN="IsStructurallyEquivalent", NM="_ZL24IsStructurallyEquivalentRN12_GLOBAL__N_128StructuralEquivalenceContextEPN5clang4ExprES4_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZL24IsStructurallyEquivalentRN12_GLOBAL__N_128StructuralEquivalenceContextEPN5clang4ExprES4_")
//</editor-fold>
public static boolean IsStructurallyEquivalent(final StructuralEquivalenceContext /*&*/ Context, 
                        Expr /*P*/ E1, Expr /*P*/ E2) {
  if (!(E1 != null) || !(E2 != null)) {
    return E1 == E2;
  }
  
  // FIXME: Actually perform a structural comparison!
  return true;
}


/// \brief Determine whether two identifiers are equivalent.
//<editor-fold defaultstate="collapsed" desc="IsStructurallyEquivalent">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 375,
 FQN="IsStructurallyEquivalent", NM="_ZL24IsStructurallyEquivalentPKN5clang14IdentifierInfoES2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZL24IsStructurallyEquivalentPKN5clang14IdentifierInfoES2_")
//</editor-fold>
public static boolean IsStructurallyEquivalent(/*const*/ IdentifierInfo /*P*/ Name1, 
                        /*const*/ IdentifierInfo /*P*/ Name2) {
  if (!(Name1 != null) || !(Name2 != null)) {
    return Name1 == Name2;
  }
  
  return $eq_StringRef(Name1.getName(), Name2.getName());
}


/// \brief Determine whether two nested-name-specifiers are equivalent.
//<editor-fold defaultstate="collapsed" desc="IsStructurallyEquivalent">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 384,
 FQN="IsStructurallyEquivalent", NM="_ZL24IsStructurallyEquivalentRN12_GLOBAL__N_128StructuralEquivalenceContextEPN5clang19NestedNameSpecifierES4_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZL24IsStructurallyEquivalentRN12_GLOBAL__N_128StructuralEquivalenceContextEPN5clang19NestedNameSpecifierES4_")
//</editor-fold>
public static boolean IsStructurallyEquivalent(final StructuralEquivalenceContext /*&*/ Context, 
                        NestedNameSpecifier /*P*/ NNS1, 
                        NestedNameSpecifier /*P*/ NNS2) {
  // FIXME: Implement!
  return true;
}


/// \brief Determine whether two template arguments are equivalent.
//<editor-fold defaultstate="collapsed" desc="IsStructurallyEquivalent">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 392,
 FQN="IsStructurallyEquivalent", NM="_ZL24IsStructurallyEquivalentRN12_GLOBAL__N_128StructuralEquivalenceContextERKN5clang16TemplateArgumentES5_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZL24IsStructurallyEquivalentRN12_GLOBAL__N_128StructuralEquivalenceContextERKN5clang16TemplateArgumentES5_")
//</editor-fold>
public static boolean IsStructurallyEquivalent(final StructuralEquivalenceContext /*&*/ Context, 
                        final /*const*/ TemplateArgument /*&*/ Arg1, 
                        final /*const*/ TemplateArgument /*&*/ Arg2) {
  if (Arg1.getKind() != Arg2.getKind()) {
    return false;
  }
  switch (Arg1.getKind()) {
   case Null:
    return true;
   case Type:
    return Context.IsStructurallyEquivalent(Arg1.getAsType(), Arg2.getAsType());
   case Integral:
    if (!Context.IsStructurallyEquivalent(Arg1.getIntegralType(), 
        Arg2.getIntegralType())) {
      return false;
    }
    
    return APSInt.isSameValue(Arg1.getAsIntegral(), Arg2.getAsIntegral());
   case Declaration:
    return Context.IsStructurallyEquivalent(Arg1.getAsDecl(), Arg2.getAsDecl());
   case NullPtr:
    return true; // FIXME: Is this correct?
   case Template:
    return IsStructurallyEquivalent(Context, 
        new TemplateArgument(Arg1.getAsTemplate()), 
        new TemplateArgument(Arg2.getAsTemplate()));
   case TemplateExpansion:
    return IsStructurallyEquivalent(Context, 
        new TemplateArgument(Arg1.getAsTemplateOrTemplatePattern()), 
        new TemplateArgument(Arg2.getAsTemplateOrTemplatePattern()));
   case Expression:
    return IsStructurallyEquivalent(Context, 
        Arg1.getAsExpr(), Arg2.getAsExpr());
   case Pack:
    if (Arg1.pack_size() != Arg2.pack_size()) {
      return false;
    }
    
    for (/*uint*/int I = 0, N = Arg1.pack_size(); I != N; ++I)  {
      if (!IsStructurallyEquivalent(Context, 
          Arg1.pack_begin().$at(I), 
          Arg2.pack_begin().$at(I))) {
        return false;
      }
    }
    
    return true;
  }
  throw new llvm_unreachable("Invalid template argument kind");
}


/// \brief Determine structural equivalence for the common part of array 
/// types.
//<editor-fold defaultstate="collapsed" desc="IsArrayStructurallyEquivalent">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 450,
 FQN="IsArrayStructurallyEquivalent", NM="_ZL29IsArrayStructurallyEquivalentRN12_GLOBAL__N_128StructuralEquivalenceContextEPKN5clang9ArrayTypeES5_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZL29IsArrayStructurallyEquivalentRN12_GLOBAL__N_128StructuralEquivalenceContextEPKN5clang9ArrayTypeES5_")
//</editor-fold>
public static boolean IsArrayStructurallyEquivalent(final StructuralEquivalenceContext /*&*/ Context, 
                             /*const*/ ArrayType /*P*/ Array1, 
                             /*const*/ ArrayType /*P*/ Array2) {
  if (!IsStructurallyEquivalent(Context, 
      Array1.getElementType(), 
      Array2.getElementType())) {
    return false;
  }
  if (Array1.getSizeModifier() != Array2.getSizeModifier()) {
    return false;
  }
  if (Array1.getIndexTypeQualifiers().$noteq(Array2.getIndexTypeQualifiers())) {
    return false;
  }
  
  return true;
}


/// \brief Determine structural equivalence of two fields.
//<editor-fold defaultstate="collapsed" desc="IsStructurallyEquivalent">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 950,
 FQN="IsStructurallyEquivalent", NM="_ZL24IsStructurallyEquivalentRN12_GLOBAL__N_128StructuralEquivalenceContextEPN5clang9FieldDeclES4_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZL24IsStructurallyEquivalentRN12_GLOBAL__N_128StructuralEquivalenceContextEPN5clang9FieldDeclES4_")
//</editor-fold>
public static boolean IsStructurallyEquivalent(final StructuralEquivalenceContext /*&*/ Context, 
                        FieldDecl /*P*/ Field1, FieldDecl /*P*/ Field2) {
  RecordDecl /*P*/ Owner2 = cast_RecordDecl(Field2.getDeclContext());
  
  // For anonymous structs/unions, match up the anonymous struct/union type
  // declarations directly, so that we don't go off searching for anonymous
  // types
  if (Field1.isAnonymousStructOrUnion()
     && Field2.isAnonymousStructOrUnion()) {
    RecordDecl /*P*/ D1 = Field1.getType().$arrow().<RecordType>castAs$RecordType().getDecl();
    RecordDecl /*P*/ D2 = Field2.getType().$arrow().<RecordType>castAs$RecordType().getDecl();
    return IsStructurallyEquivalent(Context, D1, D2);
  }
  
  // Check for equivalent field names.
  IdentifierInfo /*P*/ Name1 = Field1.getIdentifier();
  IdentifierInfo /*P*/ Name2 = Field2.getIdentifier();
  if (!/*::*/IsStructurallyEquivalent(Name1, Name2)) {
    return false;
  }
  if (!IsStructurallyEquivalent(Context, 
      Field1.getType(), Field2.getType())) {
    if (Context.Complain) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_QualType($c$.track(Context.Diag2(Owner2.getLocation(), diag.warn_odr_tag_type_inconsistent)), 
            Context.C2.getTypeDeclType(Owner2)));
        $c$.clean($out_DiagnosticBuilder$C_QualType($out_DiagnosticBuilder$C_DeclarationName($c$.track(Context.Diag2(Field2.getLocation(), diag.note_odr_field)), 
                Field2.getDeclName()), Field2.getType()));
        $c$.clean($out_DiagnosticBuilder$C_QualType($out_DiagnosticBuilder$C_DeclarationName($c$.track(Context.Diag1(Field1.getLocation(), diag.note_odr_field)), 
                Field1.getDeclName()), Field1.getType()));
      } finally {
        $c$.$destroy();
      }
    }
    return false;
  }
  if (Field1.isBitField() != Field2.isBitField()) {
    if (Context.Complain) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_QualType($c$.track(Context.Diag2(Owner2.getLocation(), diag.warn_odr_tag_type_inconsistent)), 
            Context.C2.getTypeDeclType(Owner2)));
        if (Field1.isBitField()) {
          $c$.clean($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_QualType($out_DiagnosticBuilder$C_DeclarationName($c$.track(Context.Diag1(Field1.getLocation(), diag.note_odr_bit_field)), 
                      Field1.getDeclName()), Field1.getType()), 
              Field1.getBitWidthValue(Context.C1)));
          $c$.clean($out_DiagnosticBuilder$C_DeclarationName($c$.track(Context.Diag2(Field2.getLocation(), diag.note_odr_not_bit_field)), 
              Field2.getDeclName()));
        } else {
          $c$.clean($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_QualType($out_DiagnosticBuilder$C_DeclarationName($c$.track(Context.Diag2(Field2.getLocation(), diag.note_odr_bit_field)), 
                      Field2.getDeclName()), Field2.getType()), 
              Field2.getBitWidthValue(Context.C2)));
          $c$.clean($out_DiagnosticBuilder$C_DeclarationName($c$.track(Context.Diag1(Field1.getLocation(), diag.note_odr_not_bit_field)), 
              Field1.getDeclName()));
        }
      } finally {
        $c$.$destroy();
      }
    }
    return false;
  }
  if (Field1.isBitField()) {
    // Make sure that the bit-fields are the same length.
    /*uint*/int Bits1 = Field1.getBitWidthValue(Context.C1);
    /*uint*/int Bits2 = Field2.getBitWidthValue(Context.C2);
    if (Bits1 != Bits2) {
      if (Context.Complain) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_QualType($c$.track(Context.Diag2(Owner2.getLocation(), diag.warn_odr_tag_type_inconsistent)), 
              Context.C2.getTypeDeclType(Owner2)));
          $c$.clean($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_QualType($out_DiagnosticBuilder$C_DeclarationName($c$.track(Context.Diag2(Field2.getLocation(), diag.note_odr_bit_field)), 
                      Field2.getDeclName()), Field2.getType()), Bits2));
          $c$.clean($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_QualType($out_DiagnosticBuilder$C_DeclarationName($c$.track(Context.Diag1(Field1.getLocation(), diag.note_odr_bit_field)), 
                      Field1.getDeclName()), Field1.getType()), Bits1));
        } finally {
          $c$.$destroy();
        }
      }
      return false;
    }
  }
  
  return true;
}


/// \brief Find the index of the given anonymous struct/union within its
/// context.
///
/// \returns Returns the index of this anonymous struct/union in its context,
/// including the next assigned index (if none of them match). Returns an
/// empty option if the context is not a record, i.e.. if the anonymous
/// struct/union is at namespace or block scope.
//<editor-fold defaultstate="collapsed" desc="findUntaggedStructOrUnionIndex">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 1032,
 FQN="findUntaggedStructOrUnionIndex", NM="_ZL30findUntaggedStructOrUnionIndexPN5clang10RecordDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZL30findUntaggedStructOrUnionIndexPN5clang10RecordDeclE")
//</editor-fold>
public static OptionalUInt findUntaggedStructOrUnionIndex(RecordDecl /*P*/ Anon) {
  final ASTContext /*&*/ Context = Anon.getASTContext();
  QualType AnonTy = Context.getRecordType(Anon);
  
  RecordDecl /*P*/ Owner = dyn_cast_RecordDecl(Anon.getDeclContext());
  if (!(Owner != null)) {
    return new OptionalUInt(None);
  }
  
  /*uint*/int Index = 0;
  for (/*const*/ Decl /*P*/ D : Owner.noload_decls()) {
    /*const*/ FieldDecl /*P*/ F = dyn_cast_FieldDecl(D);
    if (!(F != null)) {
      continue;
    }
    if (F.isAnonymousStructOrUnion()) {
      if (Context.hasSameType(F.getType(), new QualType(AnonTy))) {
        break;
      }
      ++Index;
      continue;
    }
    
    // If the field looks like this:
    // struct { ... } A;
    QualType FieldType = F.getType();
    {
      /*const*/ RecordType /*P*/ RecType = dyn_cast_RecordType(FieldType);
      if ((RecType != null)) {
        /*const*/ RecordDecl /*P*/ RecDecl = RecType.getDecl();
        if (RecDecl.getDeclContext$Const() == Owner
           && !(RecDecl.getIdentifier() != null)) {
          if (Context.hasSameType(new QualType(FieldType), new QualType(AnonTy))) {
            break;
          }
          ++Index;
          continue;
        }
      }
    }
  }
  
  return new OptionalUInt(JD$T$C$R.INSTANCE, Index);
}


/// \brief Determine structural equivalence of two records.
//<editor-fold defaultstate="collapsed" desc="IsStructurallyEquivalent">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 1072,
 FQN="IsStructurallyEquivalent", NM="_ZL24IsStructurallyEquivalentRN12_GLOBAL__N_128StructuralEquivalenceContextEPN5clang10RecordDeclES4_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZL24IsStructurallyEquivalentRN12_GLOBAL__N_128StructuralEquivalenceContextEPN5clang10RecordDeclES4_")
//</editor-fold>
public static boolean IsStructurallyEquivalent(final StructuralEquivalenceContext /*&*/ Context, 
                        RecordDecl /*P*/ D1, RecordDecl /*P*/ D2) {
  if (D1.isUnion() != D2.isUnion()) {
    if (Context.Complain) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_QualType($c$.track(Context.Diag2(D2.getLocation(), diag.warn_odr_tag_type_inconsistent)), 
            Context.C2.getTypeDeclType(D2)));
        $c$.clean($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_DeclarationName($c$.track(Context.Diag1(D1.getLocation(), diag.note_odr_tag_kind_here)), 
                D1.getDeclName()), (/*uint*/int)D1.getTagKind().getValue()));
      } finally {
        $c$.$destroy();
      }
    }
    return false;
  }
  if (D1.isAnonymousStructOrUnion() && D2.isAnonymousStructOrUnion()) {
    {
      // If both anonymous structs/unions are in a record context, make sure
      // they occur in the same location in the context records.
      OptionalUInt Index1 = findUntaggedStructOrUnionIndex(D1);
      if (Index1.$bool()) {
        {
          OptionalUInt Index2 = findUntaggedStructOrUnionIndex(D2);
          if (Index2.$bool()) {
            if (Index1.$star() != Index2.$star()) {
              return false;
            }
          }
        }
      }
    }
  }
  
  // If both declarations are class template specializations, we know
  // the ODR applies, so check the template and template arguments.
  ClassTemplateSpecializationDecl /*P*/ Spec1 = dyn_cast_ClassTemplateSpecializationDecl(D1);
  ClassTemplateSpecializationDecl /*P*/ Spec2 = dyn_cast_ClassTemplateSpecializationDecl(D2);
  if ((Spec1 != null) && (Spec2 != null)) {
    // Check that the specialized templates are the same.
    if (!IsStructurallyEquivalent(Context, Spec1.getSpecializedTemplate(), 
        Spec2.getSpecializedTemplate())) {
      return false;
    }
    
    // Check that the template arguments are the same.
    if (Spec1.getTemplateArgs().size() != Spec2.getTemplateArgs().size()) {
      return false;
    }
    
    for (/*uint*/int I = 0, N = Spec1.getTemplateArgs().size(); I != N; ++I)  {
      if (!IsStructurallyEquivalent(Context, 
          Spec1.getTemplateArgs().get(I), 
          Spec2.getTemplateArgs().get(I))) {
        return false;
      }
    }
  } else // If one is a class template specialization and the other is not, these
  // structures are different.
  if ((Spec1 != null) || (Spec2 != null)) {
    return false;
  }
  
  // Compare the definitions of these two records. If either or both are
  // incomplete, we assume that they are equivalent.
  D1 = D1.getDefinition();
  D2 = D2.getDefinition();
  if (!(D1 != null) || !(D2 != null)) {
    return true;
  }
  {
    
    CXXRecordDecl /*P*/ D1CXX = dyn_cast_CXXRecordDecl(D1);
    if ((D1CXX != null)) {
      {
        CXXRecordDecl /*P*/ D2CXX = dyn_cast_CXXRecordDecl(D2);
        if ((D2CXX != null)) {
          if (D1CXX.getNumBases() != D2CXX.getNumBases()) {
            if (Context.Complain) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                $c$.clean($out_DiagnosticBuilder$C_QualType($c$.track(Context.Diag2(D2.getLocation(), diag.warn_odr_tag_type_inconsistent)), 
                    Context.C2.getTypeDeclType(D2)));
                $c$.clean($out_DiagnosticBuilder$C_uint($c$.track(Context.Diag2(D2.getLocation(), diag.note_odr_number_of_bases)), 
                    D2CXX.getNumBases()));
                $c$.clean($out_DiagnosticBuilder$C_uint($c$.track(Context.Diag1(D1.getLocation(), diag.note_odr_number_of_bases)), 
                    D1CXX.getNumBases()));
              } finally {
                $c$.$destroy();
              }
            }
            return false;
          }
          
          // Check the base classes. 
          for (type$ptr<CXXBaseSpecifier /*P*/ > Base1 = $tryClone(D1CXX.bases_begin()), 
              /*P*/ BaseEnd1 = $tryClone(D1CXX.bases_end()), 
              /*P*/ Base2 = $tryClone(D2CXX.bases_begin());
               $noteq_ptr(Base1, BaseEnd1);
               Base1.$preInc() , Base2.$preInc()) {
            if (!IsStructurallyEquivalent(Context, 
                Base1./*->*/$star().getType(), Base2./*->*/$star().getType())) {
              if (Context.Complain) {
                JavaCleaner $c$ = $createJavaCleaner();
                try {
                  $c$.clean($out_DiagnosticBuilder$C_QualType($c$.track(Context.Diag2(D2.getLocation(), diag.warn_odr_tag_type_inconsistent)), 
                      Context.C2.getTypeDeclType(D2)));
                  $c$.clean($out_DiagnosticBuilder$C_SourceRange($out_DiagnosticBuilder$C_QualType($c$.track(Context.Diag2(Base2./*->*/$star().getLocStart(), diag.note_odr_base)), 
                          Base2./*->*/$star().getType()), 
                      Base2./*->*/$star().getSourceRange()));
                  $c$.clean($out_DiagnosticBuilder$C_SourceRange($out_DiagnosticBuilder$C_QualType($c$.track(Context.Diag1(Base1./*->*/$star().getLocStart(), diag.note_odr_base)), 
                          Base1./*->*/$star().getType()), 
                      Base1./*->*/$star().getSourceRange()));
                } finally {
                  $c$.$destroy();
                }
              }
              return false;
            }
            
            // Check virtual vs. non-virtual inheritance mismatch.
            if (Base1./*->*/$star().isVirtual() != Base2./*->*/$star().isVirtual()) {
              if (Context.Complain) {
                JavaCleaner $c$ = $createJavaCleaner();
                try {
                  $c$.clean($out_DiagnosticBuilder$C_QualType($c$.track(Context.Diag2(D2.getLocation(), diag.warn_odr_tag_type_inconsistent)), 
                      Context.C2.getTypeDeclType(D2)));
                  $c$.clean($out_DiagnosticBuilder$C_SourceRange($out$Same2Bool($c$.track(Context.Diag2(Base2./*->*/$star().getLocStart(), 
                              diag.note_odr_virtual_base)), 
                          Base2./*->*/$star().isVirtual()), Base2./*->*/$star().getSourceRange()));
                  $c$.clean($out_DiagnosticBuilder$C_SourceRange($out$Same2Bool($c$.track(Context.Diag1(Base1./*->*/$star().getLocStart(), diag.note_odr_base)), 
                          Base1./*->*/$star().isVirtual()), 
                      Base1./*->*/$star().getSourceRange()));
                } finally {
                  $c$.$destroy();
                }
              }
              return false;
            }
          }
        } else if ($greater_uint(D1CXX.getNumBases(), 0)) {
          if (Context.Complain) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_DiagnosticBuilder$C_QualType($c$.track(Context.Diag2(D2.getLocation(), diag.warn_odr_tag_type_inconsistent)), 
                  Context.C2.getTypeDeclType(D2)));
              type$ptr</*const*/ CXXBaseSpecifier /*P*/> Base1 = $tryClone(D1CXX.bases_begin());
              $c$.clean($out_DiagnosticBuilder$C_SourceRange($out_DiagnosticBuilder$C_QualType($c$.track(Context.Diag1(Base1.$star().getLocStart(), diag.note_odr_base)), 
                      Base1.$star().getType()), 
                  Base1.$star().getSourceRange()));
              $c$.clean($c$.track(Context.Diag2(D2.getLocation(), diag.note_odr_missing_base)));
            } finally {
              $c$.$destroy();
            }
          }
          return false;
        }
      }
    }
  }
  
  // Check the fields for consistency.
  specific_decl_iterator<FieldDecl> Field2 = D2.field_begin();
  specific_decl_iterator<FieldDecl> Field2End = D2.field_end();
  for (specific_decl_iterator<FieldDecl> Field1 = D1.field_begin(), 
      Field1End = D1.field_end();
       $noteq_specific_decl_iterator$SpecificDecl$C(Field1, Field1End);
       Field1.$preInc() , Field2.$preInc()) {
    if ($eq_specific_decl_iterator$SpecificDecl$C(Field2, Field2End)) {
      if (Context.Complain) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_QualType($c$.track(Context.Diag2(D2.getLocation(), diag.warn_odr_tag_type_inconsistent)), 
              Context.C2.getTypeDeclType(D2)));
          $c$.clean($out_DiagnosticBuilder$C_QualType($out_DiagnosticBuilder$C_DeclarationName($c$.track(Context.Diag1(Field1.$arrow().getLocation(), diag.note_odr_field)), 
                  Field1.$arrow().getDeclName()), Field1.$arrow().getType()));
          $c$.clean($c$.track(Context.Diag2(D2.getLocation(), diag.note_odr_missing_field)));
        } finally {
          $c$.$destroy();
        }
      }
      return false;
    }
    if (!IsStructurallyEquivalent(Context, Field1.$star(), Field2.$star())) {
      return false;
    }
  }
  if ($noteq_specific_decl_iterator$SpecificDecl$C(Field2, Field2End)) {
    if (Context.Complain) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_QualType($c$.track(Context.Diag2(D2.getLocation(), diag.warn_odr_tag_type_inconsistent)), 
            Context.C2.getTypeDeclType(D2)));
        $c$.clean($out_DiagnosticBuilder$C_QualType($out_DiagnosticBuilder$C_DeclarationName($c$.track(Context.Diag2(Field2.$arrow().getLocation(), diag.note_odr_field)), 
                Field2.$arrow().getDeclName()), Field2.$arrow().getType()));
        $c$.clean($c$.track(Context.Diag1(D1.getLocation(), diag.note_odr_missing_field)));
      } finally {
        $c$.$destroy();
      }
    }
    return false;
  }
  
  return true;
}


/// \brief Determine structural equivalence of two enums.
//<editor-fold defaultstate="collapsed" desc="IsStructurallyEquivalent">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 1230,
 FQN="IsStructurallyEquivalent", NM="_ZL24IsStructurallyEquivalentRN12_GLOBAL__N_128StructuralEquivalenceContextEPN5clang8EnumDeclES4_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZL24IsStructurallyEquivalentRN12_GLOBAL__N_128StructuralEquivalenceContextEPN5clang8EnumDeclES4_")
//</editor-fold>
public static boolean IsStructurallyEquivalent(final StructuralEquivalenceContext /*&*/ Context, 
                        EnumDecl /*P*/ D1, EnumDecl /*P*/ D2) {
  specific_decl_iterator<EnumConstantDecl> EC2 = D2.enumerator_begin();
  specific_decl_iterator<EnumConstantDecl> EC2End = D2.enumerator_end();
  for (specific_decl_iterator<EnumConstantDecl> EC1 = D1.enumerator_begin(), 
      EC1End = D1.enumerator_end();
       $noteq_specific_decl_iterator$SpecificDecl$C(EC1, EC1End); EC1.$preInc() , EC2.$preInc()) {
    if ($eq_specific_decl_iterator$SpecificDecl$C(EC2, EC2End)) {
      if (Context.Complain) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_QualType($c$.track(Context.Diag2(D2.getLocation(), diag.warn_odr_tag_type_inconsistent)), 
              Context.C2.getTypeDeclType(D2)));
          $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_DeclarationName($c$.track(Context.Diag1(EC1.$arrow().getLocation(), diag.note_odr_enumerator)), 
                  EC1.$arrow().getDeclName()), 
              new StringRef(EC1.$arrow().getInitVal().__toString(10))));
          $c$.clean($c$.track(Context.Diag2(D2.getLocation(), diag.note_odr_missing_enumerator)));
        } finally {
          $c$.$destroy();
        }
      }
      return false;
    }
    
    APSInt Val1 = new APSInt(EC1.$arrow().getInitVal());
    APSInt Val2 = new APSInt(EC2.$arrow().getInitVal());
    if (!APSInt.isSameValue(Val1, Val2)
       || !IsStructurallyEquivalent(EC1.$arrow().getIdentifier(), EC2.$arrow().getIdentifier())) {
      if (Context.Complain) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_QualType($c$.track(Context.Diag2(D2.getLocation(), diag.warn_odr_tag_type_inconsistent)), 
              Context.C2.getTypeDeclType(D2)));
          $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_DeclarationName($c$.track(Context.Diag2(EC2.$arrow().getLocation(), diag.note_odr_enumerator)), 
                  EC2.$arrow().getDeclName()), 
              new StringRef(EC2.$arrow().getInitVal().__toString(10))));
          $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_DeclarationName($c$.track(Context.Diag1(EC1.$arrow().getLocation(), diag.note_odr_enumerator)), 
                  EC1.$arrow().getDeclName()), 
              new StringRef(EC1.$arrow().getInitVal().__toString(10))));
        } finally {
          $c$.$destroy();
        }
      }
      return false;
    }
  }
  if ($noteq_specific_decl_iterator$SpecificDecl$C(EC2, EC2End)) {
    if (Context.Complain) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_QualType($c$.track(Context.Diag2(D2.getLocation(), diag.warn_odr_tag_type_inconsistent)), 
            Context.C2.getTypeDeclType(D2)));
        $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_DeclarationName($c$.track(Context.Diag2(EC2.$arrow().getLocation(), diag.note_odr_enumerator)), 
                EC2.$arrow().getDeclName()), 
            new StringRef(EC2.$arrow().getInitVal().__toString(10))));
        $c$.clean($c$.track(Context.Diag1(D1.getLocation(), diag.note_odr_missing_enumerator)));
      } finally {
        $c$.$destroy();
      }
    }
    return false;
  }
  
  return true;
}

//<editor-fold defaultstate="collapsed" desc="IsStructurallyEquivalent">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 1282,
 FQN="IsStructurallyEquivalent", NM="_ZL24IsStructurallyEquivalentRN12_GLOBAL__N_128StructuralEquivalenceContextEPN5clang21TemplateParameterListES4_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZL24IsStructurallyEquivalentRN12_GLOBAL__N_128StructuralEquivalenceContextEPN5clang21TemplateParameterListES4_")
//</editor-fold>
public static boolean IsStructurallyEquivalent(final StructuralEquivalenceContext /*&*/ Context, 
                        TemplateParameterList /*P*/ Params1, 
                        TemplateParameterList /*P*/ Params2) {
  if (Params1.size() != Params2.size()) {
    if (Context.Complain) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_uint($out_DiagnosticBuilder$C_uint($c$.track(Context.Diag2(Params2.getTemplateLoc(), 
                    diag.err_odr_different_num_template_parameters)), 
                Params1.size()), Params2.size()));
        $c$.clean($c$.track(Context.Diag1(Params1.getTemplateLoc(), 
            diag.note_odr_template_parameter_list)));
      } finally {
        $c$.$destroy();
      }
    }
    return false;
  }
  
  for (/*uint*/int I = 0, N = Params1.size(); I != N; ++I) {
    if (Params1.getParam(I).getKind() != Params2.getParam(I).getKind()) {
      if (Context.Complain) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track(Context.Diag2(Params2.getParam(I).getLocation(), 
              diag.err_odr_different_template_parameter_kind)));
          $c$.clean($c$.track(Context.Diag1(Params1.getParam(I).getLocation(), 
              diag.note_odr_template_parameter_here)));
        } finally {
          $c$.$destroy();
        }
      }
      return false;
    }
    if (!Context.IsStructurallyEquivalent(Params1.getParam(I), 
        Params2.getParam(I))) {
      
      return false;
    }
  }
  
  return true;
}

//<editor-fold defaultstate="collapsed" desc="IsStructurallyEquivalent">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 1317,
 FQN="IsStructurallyEquivalent", NM="_ZL24IsStructurallyEquivalentRN12_GLOBAL__N_128StructuralEquivalenceContextEPN5clang20TemplateTypeParmDeclES4_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZL24IsStructurallyEquivalentRN12_GLOBAL__N_128StructuralEquivalenceContextEPN5clang20TemplateTypeParmDeclES4_")
//</editor-fold>
public static boolean IsStructurallyEquivalent(final StructuralEquivalenceContext /*&*/ Context, 
                        TemplateTypeParmDecl /*P*/ D1, 
                        TemplateTypeParmDecl /*P*/ D2) {
  if (D1.isParameterPack() != D2.isParameterPack()) {
    if (Context.Complain) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out$Same2Bool($c$.track(Context.Diag2(D2.getLocation(), diag.err_odr_parameter_pack_non_pack)), 
            D2.isParameterPack()));
        $c$.clean($out$Same2Bool($c$.track(Context.Diag1(D1.getLocation(), diag.note_odr_parameter_pack_non_pack)), 
            D1.isParameterPack()));
      } finally {
        $c$.$destroy();
      }
    }
    return false;
  }
  
  return true;
}

//<editor-fold defaultstate="collapsed" desc="IsStructurallyEquivalent">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 1333,
 FQN="IsStructurallyEquivalent", NM="_ZL24IsStructurallyEquivalentRN12_GLOBAL__N_128StructuralEquivalenceContextEPN5clang23NonTypeTemplateParmDeclES4_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZL24IsStructurallyEquivalentRN12_GLOBAL__N_128StructuralEquivalenceContextEPN5clang23NonTypeTemplateParmDeclES4_")
//</editor-fold>
public static boolean IsStructurallyEquivalent(final StructuralEquivalenceContext /*&*/ Context, 
                        NonTypeTemplateParmDecl /*P*/ D1, 
                        NonTypeTemplateParmDecl /*P*/ D2) {
  if (D1.isParameterPack() != D2.isParameterPack()) {
    if (Context.Complain) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out$Same2Bool($c$.track(Context.Diag2(D2.getLocation(), diag.err_odr_parameter_pack_non_pack)), 
            D2.isParameterPack()));
        $c$.clean($out$Same2Bool($c$.track(Context.Diag1(D1.getLocation(), diag.note_odr_parameter_pack_non_pack)), 
            D1.isParameterPack()));
      } finally {
        $c$.$destroy();
      }
    }
    return false;
  }
  
  // Check types.
  if (!Context.IsStructurallyEquivalent(D1.getType(), D2.getType())) {
    if (Context.Complain) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_QualType($out_DiagnosticBuilder$C_QualType($c$.track(Context.Diag2(D2.getLocation(), 
                    diag.err_odr_non_type_parameter_type_inconsistent)), 
                D2.getType()), D1.getType()));
        $c$.clean($out_DiagnosticBuilder$C_QualType($c$.track(Context.Diag1(D1.getLocation(), diag.note_odr_value_here)), 
            D1.getType()));
      } finally {
        $c$.$destroy();
      }
    }
    return false;
  }
  
  return true;
}

//<editor-fold defaultstate="collapsed" desc="IsStructurallyEquivalent">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 1361,
 FQN="IsStructurallyEquivalent", NM="_ZL24IsStructurallyEquivalentRN12_GLOBAL__N_128StructuralEquivalenceContextEPN5clang24TemplateTemplateParmDeclES4_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZL24IsStructurallyEquivalentRN12_GLOBAL__N_128StructuralEquivalenceContextEPN5clang24TemplateTemplateParmDeclES4_")
//</editor-fold>
public static boolean IsStructurallyEquivalent(final StructuralEquivalenceContext /*&*/ Context, 
                        TemplateTemplateParmDecl /*P*/ D1, 
                        TemplateTemplateParmDecl /*P*/ D2) {
  if (D1.isParameterPack() != D2.isParameterPack()) {
    if (Context.Complain) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out$Same2Bool($c$.track(Context.Diag2(D2.getLocation(), diag.err_odr_parameter_pack_non_pack)), 
            D2.isParameterPack()));
        $c$.clean($out$Same2Bool($c$.track(Context.Diag1(D1.getLocation(), diag.note_odr_parameter_pack_non_pack)), 
            D1.isParameterPack()));
      } finally {
        $c$.$destroy();
      }
    }
    return false;
  }
  
  // Check template parameter lists.
  return IsStructurallyEquivalent(Context, D1.getTemplateParameters(), 
      D2.getTemplateParameters());
}

//<editor-fold defaultstate="collapsed" desc="IsStructurallyEquivalent">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 1379,
 FQN="IsStructurallyEquivalent", NM="_ZL24IsStructurallyEquivalentRN12_GLOBAL__N_128StructuralEquivalenceContextEPN5clang17ClassTemplateDeclES4_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZL24IsStructurallyEquivalentRN12_GLOBAL__N_128StructuralEquivalenceContextEPN5clang17ClassTemplateDeclES4_")
//</editor-fold>
public static boolean IsStructurallyEquivalent(final StructuralEquivalenceContext /*&*/ Context, 
                        ClassTemplateDecl /*P*/ D1, 
                        ClassTemplateDecl /*P*/ D2) {
  // Check template parameters.
  if (!IsStructurallyEquivalent(Context, 
      D1.getTemplateParameters(), 
      D2.getTemplateParameters())) {
    return false;
  }
  
  // Check the templated declaration.
  return Context.IsStructurallyEquivalent(D1.getTemplatedDecl(), 
      D2.getTemplatedDecl());
}

//<editor-fold defaultstate="collapsed" desc="getFieldIndex">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 3155,
 FQN="getFieldIndex", NM="_ZL13getFieldIndexPN5clang4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZL13getFieldIndexPN5clang4DeclE")
//</editor-fold>
public static /*uint*/int getFieldIndex(Decl /*P*/ F) {
  RecordDecl /*P*/ Owner = dyn_cast_RecordDecl(F.getDeclContext());
  if (!(Owner != null)) {
    return 0;
  }
  
  /*uint*/int Index = 1;
  for (/*const*/ Decl /*P*/ D : Owner.noload_decls()) {
    if (D == F) {
      return Index;
    }
    if (isa_FieldDecl($Deref(D)) || isa_IndirectFieldDecl($Deref(D))) {
      ++Index;
    }
  }
  
  return Index;
}

//<editor-fold defaultstate="collapsed" desc="ImportCastPath">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp", line = 5766,
 FQN="ImportCastPath", NM="_ZL14ImportCastPathPN5clang8CastExprERN4llvm11SmallVectorIPNS_16CXXBaseSpecifierELj4EEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTImporter.cpp -nm=_ZL14ImportCastPathPN5clang8CastExprERN4llvm11SmallVectorIPNS_16CXXBaseSpecifierELj4EEE")
//</editor-fold>
public static boolean ImportCastPath(CastExpr /*P*/ E, final SmallVector<CXXBaseSpecifier /*P*/> /*&*/ Path) {
  if (E.path_empty()) {
    return false;
  }
  
  // TODO: import cast paths
  return true;
}

} // END OF class ASTImporterStatics
