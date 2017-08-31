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

import org.clank.java.*;
import org.clank.support.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.clang.basic.*;
import org.clang.ast.*;
import static org.clang.ast.java.AstFunctionPointers.*;
import static org.clang.ast.java.AstTypesRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type TypeStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=Tpl__ZL10getAsSugarPKN5clang4TypeE;Tpl__ZN12_GLOBAL__N_115simpleTransformERN5clang10ASTContextENS0_8QualTypeEOT_;_ZL18computeLinkageInfoN5clang8QualTypeE;_ZL18computeLinkageInfoPKN5clang4TypeE;_ZL21getInterestingTagDeclPN5clang7TagDeclE;_ZL23computeCachedPropertiesPKN5clang4TypeE; -static-type=TypeStatics -package=org.clang.ast.impl")
//</editor-fold>
public final class TypeStatics {


/// \brief This will check for a T (which should be a Type which can act as
/// sugar, such as a TypedefType) by removing any existing sugar until it
/// reaches a T or a non-sugared type.
/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="getAsSugar">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*type-class param*/,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 308,
 FQN="getAsSugar", NM="Tpl__ZL10getAsSugarPKN5clang4TypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=Tpl__ZL10getAsSugarPKN5clang4TypeE")
//</editor-fold>
public static </*typename*/ T> /*const*/ T /*P*/ getAsSugar(Class<T> clazz, /*const*/ Type /*P*/ Cur) {
  while (true) {
    {
      /*const*/ T /*P*/ Sugar = dyn_cast/*<T>*/(clazz, Cur);
      if (Sugar != null) {
        return Sugar;
      }
    }
    switch (Cur.getTypeClass()) {
     case Builtin:
      {
        /*const*/ BuiltinType /*P*/ Ty = cast_BuiltinType(Cur);
        if (!Ty.isSugared()) {
          return null;
        }
        Cur = Ty.desugar().getTypePtr();
        break;
      }
     case Complex:
      {
        /*const*/ ComplexType /*P*/ Ty = cast_ComplexType(Cur);
        if (!Ty.isSugared()) {
          return null;
        }
        Cur = Ty.desugar().getTypePtr();
        break;
      }
     case Pointer:
      {
        /*const*/ PointerType /*P*/ Ty = cast_PointerType(Cur);
        if (!Ty.isSugared()) {
          return null;
        }
        Cur = Ty.desugar().getTypePtr();
        break;
      }
     case BlockPointer:
      {
        /*const*/ BlockPointerType /*P*/ Ty = cast_BlockPointerType(Cur);
        if (!Ty.isSugared()) {
          return null;
        }
        Cur = Ty.desugar().getTypePtr();
        break;
      }
     case LValueReference:
      {
        /*const*/ LValueReferenceType /*P*/ Ty = cast_LValueReferenceType(Cur);
        if (!Ty.isSugared()) {
          return null;
        }
        Cur = Ty.desugar().getTypePtr();
        break;
      }
     case RValueReference:
      {
        /*const*/ RValueReferenceType /*P*/ Ty = cast_RValueReferenceType(Cur);
        if (!Ty.isSugared()) {
          return null;
        }
        Cur = Ty.desugar().getTypePtr();
        break;
      }
     case MemberPointer:
      {
        /*const*/ MemberPointerType /*P*/ Ty = cast_MemberPointerType(Cur);
        if (!Ty.isSugared()) {
          return null;
        }
        Cur = Ty.desugar().getTypePtr();
        break;
      }
     case ConstantArray:
      {
        /*const*/ ConstantArrayType /*P*/ Ty = cast_ConstantArrayType(Cur);
        if (!Ty.isSugared()) {
          return null;
        }
        Cur = Ty.desugar().getTypePtr();
        break;
      }
     case IncompleteArray:
      {
        /*const*/ IncompleteArrayType /*P*/ Ty = cast_IncompleteArrayType(Cur);
        if (!Ty.isSugared()) {
          return null;
        }
        Cur = Ty.desugar().getTypePtr();
        break;
      }
     case VariableArray:
      {
        /*const*/ VariableArrayType /*P*/ Ty = cast_VariableArrayType(Cur);
        if (!Ty.isSugared()) {
          return null;
        }
        Cur = Ty.desugar().getTypePtr();
        break;
      }
     case DependentSizedArray:
      {
        /*const*/ DependentSizedArrayType /*P*/ Ty = cast_DependentSizedArrayType(Cur);
        if (!Ty.isSugared()) {
          return null;
        }
        Cur = Ty.desugar().getTypePtr();
        break;
      }
     case DependentSizedExtVector:
      {
        /*const*/ DependentSizedExtVectorType /*P*/ Ty = cast_DependentSizedExtVectorType(Cur);
        if (!Ty.isSugared()) {
          return null;
        }
        Cur = Ty.desugar().getTypePtr();
        break;
      }
     case Vector:
      {
        /*const*/ VectorType /*P*/ Ty = cast_VectorType(Cur);
        if (!Ty.isSugared()) {
          return null;
        }
        Cur = Ty.desugar().getTypePtr();
        break;
      }
     case ExtVector:
      {
        /*const*/ ExtVectorType /*P*/ Ty = cast_ExtVectorType(Cur);
        if (!Ty.isSugared()) {
          return null;
        }
        Cur = Ty.desugar().getTypePtr();
        break;
      }
     case FunctionProto:
      {
        /*const*/ FunctionProtoType /*P*/ Ty = cast_FunctionProtoType(Cur);
        if (!Ty.isSugared()) {
          return null;
        }
        Cur = Ty.desugar().getTypePtr();
        break;
      }
     case FunctionNoProto:
      {
        /*const*/ FunctionNoProtoType /*P*/ Ty = cast_FunctionNoProtoType(Cur);
        if (!Ty.isSugared()) {
          return null;
        }
        Cur = Ty.desugar().getTypePtr();
        break;
      }
     case UnresolvedUsing:
      {
        /*const*/ UnresolvedUsingType /*P*/ Ty = cast_UnresolvedUsingType(Cur);
        if (!Ty.isSugared()) {
          return null;
        }
        Cur = Ty.desugar().getTypePtr();
        break;
      }
     case Paren:
      {
        /*const*/ ParenType /*P*/ Ty = cast_ParenType(Cur);
        if (!Ty.isSugared()) {
          return null;
        }
        Cur = Ty.desugar().getTypePtr();
        break;
      }
     case Typedef:
      {
        /*const*/ TypedefType /*P*/ Ty = cast_TypedefType(Cur);
        if (!Ty.isSugared()) {
          return null;
        }
        Cur = Ty.desugar().getTypePtr();
        break;
      }
     case Adjusted:
      {
        /*const*/ AdjustedType /*P*/ Ty = cast_AdjustedType(Cur);
        if (!Ty.isSugared()) {
          return null;
        }
        Cur = Ty.desugar().getTypePtr();
        break;
      }
     case Decayed:
      {
        /*const*/ DecayedType /*P*/ Ty = cast_DecayedType(Cur);
        if (!Ty.isSugared()) {
          return null;
        }
        Cur = Ty.desugar().getTypePtr();
        break;
      }
     case TypeOfExpr:
      {
        /*const*/ TypeOfExprType /*P*/ Ty = cast_TypeOfExprType(Cur);
        if (!Ty.isSugared()) {
          return null;
        }
        Cur = Ty.desugar().getTypePtr();
        break;
      }
     case TypeOf:
      {
        /*const*/ TypeOfType /*P*/ Ty = cast_TypeOfType(Cur);
        if (!Ty.isSugared()) {
          return null;
        }
        Cur = Ty.desugar().getTypePtr();
        break;
      }
     case Decltype:
      {
        /*const*/ DecltypeType /*P*/ Ty = cast_DecltypeType(Cur);
        if (!Ty.isSugared()) {
          return null;
        }
        Cur = Ty.desugar().getTypePtr();
        break;
      }
     case UnaryTransform:
      {
        /*const*/ UnaryTransformType /*P*/ Ty = cast_UnaryTransformType(Cur);
        if (!Ty.isSugared()) {
          return null;
        }
        Cur = Ty.desugar().getTypePtr();
        break;
      }
     case Record:
      {
        /*const*/ RecordType /*P*/ Ty = cast_RecordType(Cur);
        if (!Ty.isSugared()) {
          return null;
        }
        Cur = Ty.desugar().getTypePtr();
        break;
      }
     case Enum:
      {
        /*const*/ EnumType /*P*/ Ty = cast_EnumType(Cur);
        if (!Ty.isSugared()) {
          return null;
        }
        Cur = Ty.desugar().getTypePtr();
        break;
      }
     case Elaborated:
      {
        /*const*/ ElaboratedType /*P*/ Ty = cast_ElaboratedType(Cur);
        if (!Ty.isSugared()) {
          return null;
        }
        Cur = Ty.desugar().getTypePtr();
        break;
      }
     case Attributed:
      {
        /*const*/ AttributedType /*P*/ Ty = cast_AttributedType(Cur);
        if (!Ty.isSugared()) {
          return null;
        }
        Cur = Ty.desugar().getTypePtr();
        break;
      }
     case TemplateTypeParm:
      {
        /*const*/ TemplateTypeParmType /*P*/ Ty = cast_TemplateTypeParmType(Cur);
        if (!Ty.isSugared()) {
          return null;
        }
        Cur = Ty.desugar().getTypePtr();
        break;
      }
     case SubstTemplateTypeParm:
      {
        /*const*/ SubstTemplateTypeParmType /*P*/ Ty = cast_SubstTemplateTypeParmType(Cur);
        if (!Ty.isSugared()) {
          return null;
        }
        Cur = Ty.desugar().getTypePtr();
        break;
      }
     case SubstTemplateTypeParmPack:
      {
        /*const*/ SubstTemplateTypeParmPackType /*P*/ Ty = cast_SubstTemplateTypeParmPackType(Cur);
        if (!Ty.isSugared()) {
          return null;
        }
        Cur = Ty.desugar().getTypePtr();
        break;
      }
     case TemplateSpecialization:
      {
        /*const*/ TemplateSpecializationType /*P*/ Ty = cast_TemplateSpecializationType(Cur);
        if (!Ty.isSugared()) {
          return null;
        }
        Cur = Ty.desugar().getTypePtr();
        break;
      }
     case Auto:
      {
        /*const*/ AutoType /*P*/ Ty = cast_AutoType(Cur);
        if (!Ty.isSugared()) {
          return null;
        }
        Cur = Ty.desugar().getTypePtr();
        break;
      }
     case InjectedClassName:
      {
        /*const*/ InjectedClassNameType /*P*/ Ty = cast_InjectedClassNameType(Cur);
        if (!Ty.isSugared()) {
          return null;
        }
        Cur = Ty.desugar().getTypePtr();
        break;
      }
     case DependentName:
      {
        /*const*/ DependentNameType /*P*/ Ty = cast_DependentNameType(Cur);
        if (!Ty.isSugared()) {
          return null;
        }
        Cur = Ty.desugar().getTypePtr();
        break;
      }
     case DependentTemplateSpecialization:
      {
        /*const*/ DependentTemplateSpecializationType /*P*/ Ty = cast_DependentTemplateSpecializationType(Cur);
        if (!Ty.isSugared()) {
          return null;
        }
        Cur = Ty.desugar().getTypePtr();
        break;
      }
     case PackExpansion:
      {
        /*const*/ PackExpansionType /*P*/ Ty = cast_PackExpansionType(Cur);
        if (!Ty.isSugared()) {
          return null;
        }
        Cur = Ty.desugar().getTypePtr();
        break;
      }
     case ObjCObject:
      {
        /*const*/ ObjCObjectType /*P*/ Ty = cast_ObjCObjectType(Cur);
        if (!Ty.isSugared()) {
          return null;
        }
        Cur = Ty.desugar().getTypePtr();
        break;
      }
     case ObjCInterface:
      {
        /*const*/ ObjCInterfaceType /*P*/ Ty = cast_ObjCInterfaceType(Cur);
        if (!Ty.isSugared()) {
          return null;
        }
        Cur = Ty.desugar().getTypePtr();
        break;
      }
     case ObjCObjectPointer:
      {
        /*const*/ ObjCObjectPointerType /*P*/ Ty = cast_ObjCObjectPointerType(Cur);
        if (!Ty.isSugared()) {
          return null;
        }
        Cur = Ty.desugar().getTypePtr();
        break;
      }
     case Pipe:
      {
        /*const*/ PipeType /*P*/ Ty = cast_PipeType(Cur);
        if (!Ty.isSugared()) {
          return null;
        }
        Cur = Ty.desugar().getTypePtr();
        break;
      }
     case Atomic:
      {
        /*const*/ AtomicType /*P*/ Ty = cast_AtomicType(Cur);
        if (!Ty.isSugared()) {
          return null;
        }
        Cur = Ty.desugar().getTypePtr();
        break;
      }
    }
  }
}

/*template <typename F> TEMPLATE*/

/// Perform a simple type transformation that does not change the
/// semantics of the type.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::simpleTransform">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 1041,
 FQN="(anonymous namespace)::simpleTransform", NM="Tpl__ZN12_GLOBAL__N_115simpleTransformERN5clang10ASTContextENS0_8QualTypeEOT_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=Tpl__ZN12_GLOBAL__N_115simpleTransformERN5clang10ASTContextENS0_8QualTypeEOT_")
//</editor-fold>
public static /*<typename F>*/ QualType simpleTransform(final ASTContext /*&*/ ctx, QualType type, final QualType2QualType /*&&*/f) {
  // Transform the type. If it changed, return the transformed result.
  QualType transformed = f.$call(type);
  if ($noteq_ptr(transformed.getAsOpaquePtr(), type.getAsOpaquePtr())) {
    return transformed;
  }
  
  // Split out the qualifiers from the type.
  SplitQualType splitType = type.split();
  
  // Visit the type itself.
  SimpleTransformVisitor visitor/*J*/= /*ParenList*/new SimpleTransformVisitor(ctx, std.move(f));
  QualType result = visitor.Visit(splitType.Ty);
  if (result.isNull()) {
    return result;
  }
  
  // Reconstruct the transformed type by applying the local qualifiers
  // from the split type.
  return ctx.getQualifiedType(new QualType(result), new Qualifiers(splitType.Quals));
}

//<editor-fold defaultstate="collapsed" desc="getInterestingTagDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 2951,
 FQN="getInterestingTagDecl", NM="_ZL21getInterestingTagDeclPN5clang7TagDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZL21getInterestingTagDeclPN5clang7TagDeclE")
//</editor-fold>
public static TagDecl /*P*/ getInterestingTagDecl(TagDecl /*P*/ decl) {
  for (TagDecl /*P*/ I : decl.redeclarable_redecls()) {
    if (I.isCompleteDefinition() || I.isBeingDefined()) {
      return I;
    }
  }
  // If there's no definition (not even in progress), return what we have.
  return decl;
}

//<editor-fold defaultstate="collapsed" desc="computeCachedProperties">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 3284,
 FQN="computeCachedProperties", NM="_ZL23computeCachedPropertiesPKN5clang4TypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZL23computeCachedPropertiesPKN5clang4TypeE")
//</editor-fold>
public static CachedProperties computeCachedProperties(/*const*/ Type /*P*/ T) {
  switch (T.getTypeClass()) {
   case Paren:
   case Typedef:
   case Adjusted:
   case Decayed:
   case Elaborated:
   case Attributed:
   case SubstTemplateTypeParm:
    throw new llvm_unreachable("didn't expect a non-canonical type here");
   case DependentSizedArray:
   case DependentSizedExtVector:
   case UnresolvedUsing:
   case TypeOfExpr:
   case TypeOf:
   case Decltype:
   case UnaryTransform:
   case TemplateTypeParm:
   case SubstTemplateTypeParmPack:
   case TemplateSpecialization:
   case InjectedClassName:
   case DependentName:
   case DependentTemplateSpecialization:
   case PackExpansion:
    // Treat instantiation-dependent types as external.
    assert (T.isInstantiationDependentType());
    return new CachedProperties(Linkage.ExternalLinkage, false);
   case Auto:
    // Give non-deduced 'auto' types external linkage. We should only see them
    // here in error recovery.
    return new CachedProperties(Linkage.ExternalLinkage, false);
   case Builtin:
    // C++ [basic.link]p8:
    //   A type is said to have linkage if and only if:
    //     - it is a fundamental type (3.9.1); or
    return new CachedProperties(Linkage.ExternalLinkage, false);
   case Record:
   case Enum:
    {
      /*const*/ TagDecl /*P*/ Tag = cast_TagType(T).getDecl();
      
      // C++ [basic.link]p8:
      //     - it is a class or enumeration type that is named (or has a name
      //       for linkage purposes (7.1.3)) and the name has linkage; or
      //     -  it is a specialization of a class template (14); or
      Linkage L = Tag.getLinkageInternal();
      boolean IsLocalOrUnnamed = Tag.getDeclContext$Const().isFunctionOrMethod()
         || !Tag.hasNameForLinkage();
      return new CachedProperties(L, IsLocalOrUnnamed);
    }
   case Complex:
    
    // C++ [basic.link]p8:
    //   - it is a compound type (3.9.2) other than a class or enumeration, 
    //     compounded exclusively from types that have linkage; or
    return TypePropertyCache.$for(Private.class).get(cast_ComplexType(T).getElementType());
   case Pointer:
    return TypePropertyCache.$for(Private.class).get(cast_PointerType(T).getPointeeType());
   case BlockPointer:
    return TypePropertyCache.$for(Private.class).get(cast_BlockPointerType(T).getPointeeType());
   case LValueReference:
   case RValueReference:
    return TypePropertyCache.$for(Private.class).get(cast_ReferenceType(T).getPointeeType());
   case MemberPointer:
    {
      /*const*/ MemberPointerType /*P*/ MPT = cast_MemberPointerType(T);
      return CachedProperties.merge(TypePropertyCache.$for(Private.class).get(MPT.__getClass()), 
          TypePropertyCache.$for(Private.class).get(MPT.getPointeeType()));
    }
   case ConstantArray:
   case IncompleteArray:
   case VariableArray:
    return TypePropertyCache.$for(Private.class).get(cast_ArrayType(T).getElementType());
   case Vector:
   case ExtVector:
    return TypePropertyCache.$for(Private.class).get(cast_VectorType(T).getElementType());
   case FunctionNoProto:
    return TypePropertyCache.$for(Private.class).get(cast_FunctionType(T).getReturnType());
   case FunctionProto:
    {
      /*const*/ FunctionProtoType /*P*/ FPT = cast_FunctionProtoType(T);
      CachedProperties result = TypePropertyCache.$for(Private.class).get(FPT.getReturnType());
      for (final /*const*/ QualType /*&*/ ai : FPT.param_types())  {
        result.$assignMove(CachedProperties.merge(new CachedProperties(result), TypePropertyCache.$for(Private.class).get(new QualType(ai))));
      }
      return result;
    }
   case ObjCInterface:
    {
      Linkage L = cast_ObjCInterfaceType(T).getDecl().getLinkageInternal();
      return new CachedProperties(L, false);
    }
   case ObjCObject:
    return TypePropertyCache.$for(Private.class).get(cast_ObjCObjectType(T).getBaseType());
   case ObjCObjectPointer:
    return TypePropertyCache.$for(Private.class).get(cast_ObjCObjectPointerType(T).getPointeeType());
   case Atomic:
    return TypePropertyCache.$for(Private.class).get(cast_AtomicType(T).getValueType());
   case Pipe:
    return TypePropertyCache.$for(Private.class).get(cast_PipeType(T).getElementType());
  }
  throw new llvm_unreachable("unhandled type class");
}

//<editor-fold defaultstate="collapsed" desc="computeLinkageInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 3459,
 FQN="computeLinkageInfo", NM="_ZL18computeLinkageInfoN5clang8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZL18computeLinkageInfoN5clang8QualTypeE")
//</editor-fold>
public static LinkageInfo computeLinkageInfo(QualType T) {
  return computeLinkageInfo(T.getTypePtr());
}

//<editor-fold defaultstate="collapsed" desc="computeLinkageInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp", line = 3388,
 FQN="computeLinkageInfo", NM="_ZL18computeLinkageInfoPKN5clang4TypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp -nm=_ZL18computeLinkageInfoPKN5clang4TypeE")
//</editor-fold>
public static LinkageInfo computeLinkageInfo(/*const*/ Type /*P*/ T) {
  switch (T.getTypeClass()) {
   case Paren:
   case Typedef:
   case Adjusted:
   case Decayed:
   case Elaborated:
   case Attributed:
   case SubstTemplateTypeParm:
    throw new llvm_unreachable("didn't expect a non-canonical type here");
   case DependentSizedArray:
   case DependentSizedExtVector:
   case UnresolvedUsing:
   case TypeOfExpr:
   case TypeOf:
   case Decltype:
   case UnaryTransform:
   case TemplateTypeParm:
   case SubstTemplateTypeParmPack:
   case TemplateSpecialization:
   case InjectedClassName:
   case DependentName:
   case DependentTemplateSpecialization:
   case PackExpansion:
    // Treat instantiation-dependent types as external.
    assert (T.isInstantiationDependentType());
    return LinkageInfo.external();
   case Builtin:
    return LinkageInfo.external();
   case Auto:
    return LinkageInfo.external();
   case Record:
   case Enum:
    return cast_TagType(T).getDecl().getLinkageAndVisibility();
   case Complex:
    return computeLinkageInfo(cast_ComplexType(T).getElementType());
   case Pointer:
    return computeLinkageInfo(cast_PointerType(T).getPointeeType());
   case BlockPointer:
    return computeLinkageInfo(cast_BlockPointerType(T).getPointeeType());
   case LValueReference:
   case RValueReference:
    return computeLinkageInfo(cast_ReferenceType(T).getPointeeType());
   case MemberPointer:
    {
      /*const*/ MemberPointerType /*P*/ MPT = cast_MemberPointerType(T);
      LinkageInfo LV = computeLinkageInfo(MPT.__getClass());
      LV.merge(computeLinkageInfo(MPT.getPointeeType()));
      return LV;
    }
   case ConstantArray:
   case IncompleteArray:
   case VariableArray:
    return computeLinkageInfo(cast_ArrayType(T).getElementType());
   case Vector:
   case ExtVector:
    return computeLinkageInfo(cast_VectorType(T).getElementType());
   case FunctionNoProto:
    return computeLinkageInfo(cast_FunctionType(T).getReturnType());
   case FunctionProto:
    {
      /*const*/ FunctionProtoType /*P*/ FPT = cast_FunctionProtoType(T);
      LinkageInfo LV = computeLinkageInfo(FPT.getReturnType());
      for (final /*const*/ QualType /*&*/ ai : FPT.param_types())  {
        LV.merge(computeLinkageInfo(new QualType(ai)));
      }
      return LV;
    }
   case ObjCInterface:
    return cast_ObjCInterfaceType(T).getDecl().getLinkageAndVisibility();
   case ObjCObject:
    return computeLinkageInfo(cast_ObjCObjectType(T).getBaseType());
   case ObjCObjectPointer:
    return computeLinkageInfo(cast_ObjCObjectPointerType(T).getPointeeType());
   case Atomic:
    return computeLinkageInfo(cast_AtomicType(T).getValueType());
   case Pipe:
    return computeLinkageInfo(cast_PipeType(T).getElementType());
  }
  throw new llvm_unreachable("unhandled type class");
}

} // END OF class TypeStatics
