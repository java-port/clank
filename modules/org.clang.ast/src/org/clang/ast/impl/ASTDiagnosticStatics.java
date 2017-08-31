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
import org.clank.support.aliases.*;
import static org.clank.support.Casts.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.ast.*;
import static org.clang.ast.QualType.*;
import static org.clang.ast.java.AstTypesRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type ASTDiagnosticStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp -nm=_ZL22FormatTemplateTypeDiffRN5clang10ASTContextENS_8QualTypeES2_bbbbRN4llvm11raw_ostreamE;_ZL29ConvertTypeToDiagnosticStringRN5clang10ASTContextENS_8QualTypeEN4llvm8ArrayRefISt4pairINS_17DiagnosticsEngine12ArgumentKindEiEEENS4_IiEE;_ZL7DesugarRN5clang10ASTContextENS_8QualTypeERb; -static-type=ASTDiagnosticStatics -package=org.clang.ast.impl")
//</editor-fold>
public final class ASTDiagnosticStatics {


// Returns a desugared version of the QualType, and marks ShouldAKA as true
// whenever we remove significant sugar from the type.
//<editor-fold defaultstate="collapsed" desc="Desugar">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp", line = 30,
 FQN="Desugar", NM="_ZL7DesugarRN5clang10ASTContextENS_8QualTypeERb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp -nm=_ZL7DesugarRN5clang10ASTContextENS_8QualTypeERb")
//</editor-fold>
public static QualType Desugar(final ASTContext /*&*/ Context, QualType QT, final bool$ref/*bool &*/ ShouldAKA) {
  QualifierCollector QC/*J*/= new QualifierCollector();
  while (true) {
    /*const*/ Type /*P*/ Ty = QC.strip(new QualType(QT));
    {
      
      // Don't aka just because we saw an elaborated type...
      /*const*/ ElaboratedType /*P*/ ET = dyn_cast_ElaboratedType(Ty);
      if ((ET != null)) {
        QT.$assignMove(ET.desugar());
        continue;
      }
    }
    {
      // ... or a paren type ...
      /*const*/ ParenType /*P*/ PT = dyn_cast_ParenType(Ty);
      if ((PT != null)) {
        QT.$assignMove(PT.desugar());
        continue;
      }
    }
    {
      // ...or a substituted template type parameter ...
      /*const*/ SubstTemplateTypeParmType /*P*/ ST = dyn_cast_SubstTemplateTypeParmType(Ty);
      if ((ST != null)) {
        QT.$assignMove(ST.desugar());
        continue;
      }
    }
    {
      // ...or an attributed type...
      /*const*/ AttributedType /*P*/ AT = dyn_cast_AttributedType(Ty);
      if ((AT != null)) {
        QT.$assignMove(AT.desugar());
        continue;
      }
    }
    {
      // ...or an adjusted type...
      /*const*/ AdjustedType /*P*/ AT = dyn_cast_AdjustedType(Ty);
      if ((AT != null)) {
        QT.$assignMove(AT.desugar());
        continue;
      }
    }
    {
      // ... or an auto type.
      /*const*/ AutoType /*P*/ AT = dyn_cast_AutoType(Ty);
      if ((AT != null)) {
        if (!AT.isSugared()) {
          break;
        }
        QT.$assignMove(AT.desugar());
        continue;
      }
    }
    {
      
      // Desugar FunctionType if return type or any parameter type should be
      // desugared. Preserve nullability attribute on desugared types.
      /*const*/ FunctionType /*P*/ FT = dyn_cast_FunctionType(Ty);
      if ((FT != null)) {
        bool$ref DesugarReturn = create_bool$ref(false);
        QualType SugarRT = FT.getReturnType();
        QualType RT = Desugar(Context, new QualType(SugarRT), DesugarReturn);
        {
          Optional<NullabilityKind> nullability = AttributedType.stripOuterNullability(SugarRT);
          if (nullability.$bool()) {
            RT.$assignMove(Context.getAttributedType(AttributedType.getNullabilityAttrKind(nullability.$star()), new QualType(RT), new QualType(RT)));
          }
        }
        
        bool$ref DesugarArgument = create_bool$ref(false);
        SmallVector<QualType> Args/*J*/= new SmallVector<QualType>(4, new QualType());
        /*const*/ FunctionProtoType /*P*/ FPT = dyn_cast_FunctionProtoType(FT);
        if ((FPT != null)) {
          for (QualType SugarPT : FPT.param_types()) {
            QualType PT = Desugar(Context, new QualType(SugarPT), DesugarArgument);
            {
              Optional<NullabilityKind> nullability = AttributedType.stripOuterNullability(SugarPT);
              if (nullability.$bool()) {
                PT.$assignMove(Context.getAttributedType(AttributedType.getNullabilityAttrKind(nullability.$star()), new QualType(PT), new QualType(PT)));
              }
            }
            Args.push_back(PT);
          }
        }
        if (DesugarReturn.$deref() || DesugarArgument.$deref()) {
          ShouldAKA.$set(true);
          QT.$assignMove((FPT != null) ? Context.getFunctionType(new QualType(RT), new ArrayRef<QualType>(Args, false), FPT.getExtProtoInfo()) : Context.getFunctionNoProtoType(new QualType(RT), FT.getExtInfo()));
          break;
        }
      }
    }
    {
      
      // Desugar template specializations if any template argument should be
      // desugared.
      /*const*/ TemplateSpecializationType /*P*/ TST = dyn_cast_TemplateSpecializationType(Ty);
      if ((TST != null)) {
        if (!TST.isTypeAlias()) {
          bool$ref DesugarArgument = create_bool$ref(false);
          SmallVector<TemplateArgument> Args/*J*/= new SmallVector<TemplateArgument>(4, new TemplateArgument());
          for (/*uint*/int I = 0, N = TST.getNumArgs(); I != N; ++I) {
            final /*const*/ TemplateArgument /*&*/ Arg = TST.getArg(I);
            if (Arg.getKind() == TemplateArgument.ArgKind.Type) {
              Args.push_back(new TemplateArgument(Desugar(Context, Arg.getAsType(), DesugarArgument)));
            } else {
              Args.push_back(Arg);
            }
          }
          if (DesugarArgument.$deref()) {
            ShouldAKA.$set(true);
            QT.$assignMove(Context.getTemplateSpecializationType(TST.getTemplateName(), new ArrayRef<TemplateArgument>(Args, false), new QualType(QT)));
          }
          break;
        }
      }
    }
    
    // Don't desugar magic Objective-C types.
    if ($eq_QualType$C(new QualType(Ty, 0), Context.getObjCIdType())
       || $eq_QualType$C(new QualType(Ty, 0), Context.getObjCClassType())
       || $eq_QualType$C(new QualType(Ty, 0), Context.getObjCSelType())
       || $eq_QualType$C(new QualType(Ty, 0), Context.getObjCProtoType())) {
      break;
    }
    
    // Don't desugar va_list.
    if ($eq_QualType$C(new QualType(Ty, 0), Context.getBuiltinVaListType())
       || $eq_QualType$C(new QualType(Ty, 0), Context.getBuiltinMSVaListType())) {
      break;
    }
    
    // Otherwise, do a single-step desugar.
    QualType Underlying/*J*/= new QualType();
    boolean IsSugar = false;
    switch (Ty.getTypeClass()) {
     case Builtin:
      {
        /*const*/ BuiltinType /*P*/ CTy = cast_BuiltinType(Ty);
        if (CTy.isSugared()) {
          IsSugar = true;
          Underlying.$assignMove(CTy.desugar());
        }
        break;
      }
     case Complex:
      {
        /*const*/ ComplexType /*P*/ CTy = cast_ComplexType(Ty);
        if (CTy.isSugared()) {
          IsSugar = true;
          Underlying.$assignMove(CTy.desugar());
        }
        break;
      }
     case Pointer:
      {
        /*const*/ PointerType /*P*/ CTy = cast_PointerType(Ty);
        if (CTy.isSugared()) {
          IsSugar = true;
          Underlying.$assignMove(CTy.desugar());
        }
        break;
      }
     case BlockPointer:
      {
        /*const*/ BlockPointerType /*P*/ CTy = cast_BlockPointerType(Ty);
        if (CTy.isSugared()) {
          IsSugar = true;
          Underlying.$assignMove(CTy.desugar());
        }
        break;
      }
     case LValueReference:
      {
        /*const*/ LValueReferenceType /*P*/ CTy = cast_LValueReferenceType(Ty);
        if (CTy.isSugared()) {
          IsSugar = true;
          Underlying.$assignMove(CTy.desugar());
        }
        break;
      }
     case RValueReference:
      {
        /*const*/ RValueReferenceType /*P*/ CTy = cast_RValueReferenceType(Ty);
        if (CTy.isSugared()) {
          IsSugar = true;
          Underlying.$assignMove(CTy.desugar());
        }
        break;
      }
     case MemberPointer:
      {
        /*const*/ MemberPointerType /*P*/ CTy = cast_MemberPointerType(Ty);
        if (CTy.isSugared()) {
          IsSugar = true;
          Underlying.$assignMove(CTy.desugar());
        }
        break;
      }
     case ConstantArray:
      {
        /*const*/ ConstantArrayType /*P*/ CTy = cast_ConstantArrayType(Ty);
        if (CTy.isSugared()) {
          IsSugar = true;
          Underlying.$assignMove(CTy.desugar());
        }
        break;
      }
     case IncompleteArray:
      {
        /*const*/ IncompleteArrayType /*P*/ CTy = cast_IncompleteArrayType(Ty);
        if (CTy.isSugared()) {
          IsSugar = true;
          Underlying.$assignMove(CTy.desugar());
        }
        break;
      }
     case VariableArray:
      {
        /*const*/ VariableArrayType /*P*/ CTy = cast_VariableArrayType(Ty);
        if (CTy.isSugared()) {
          IsSugar = true;
          Underlying.$assignMove(CTy.desugar());
        }
        break;
      }
     case DependentSizedArray:
      {
        /*const*/ DependentSizedArrayType /*P*/ CTy = cast_DependentSizedArrayType(Ty);
        if (CTy.isSugared()) {
          IsSugar = true;
          Underlying.$assignMove(CTy.desugar());
        }
        break;
      }
     case DependentSizedExtVector:
      {
        /*const*/ DependentSizedExtVectorType /*P*/ CTy = cast_DependentSizedExtVectorType(Ty);
        if (CTy.isSugared()) {
          IsSugar = true;
          Underlying.$assignMove(CTy.desugar());
        }
        break;
      }
     case Vector:
      {
        /*const*/ VectorType /*P*/ CTy = cast_VectorType(Ty);
        if (CTy.isSugared()) {
          IsSugar = true;
          Underlying.$assignMove(CTy.desugar());
        }
        break;
      }
     case ExtVector:
      {
        /*const*/ ExtVectorType /*P*/ CTy = cast_ExtVectorType(Ty);
        if (CTy.isSugared()) {
          IsSugar = true;
          Underlying.$assignMove(CTy.desugar());
        }
        break;
      }
     case FunctionProto:
      {
        /*const*/ FunctionProtoType /*P*/ CTy = cast_FunctionProtoType(Ty);
        if (CTy.isSugared()) {
          IsSugar = true;
          Underlying.$assignMove(CTy.desugar());
        }
        break;
      }
     case FunctionNoProto:
      {
        /*const*/ FunctionNoProtoType /*P*/ CTy = cast_FunctionNoProtoType(Ty);
        if (CTy.isSugared()) {
          IsSugar = true;
          Underlying.$assignMove(CTy.desugar());
        }
        break;
      }
     case UnresolvedUsing:
      {
        /*const*/ UnresolvedUsingType /*P*/ CTy = cast_UnresolvedUsingType(Ty);
        if (CTy.isSugared()) {
          IsSugar = true;
          Underlying.$assignMove(CTy.desugar());
        }
        break;
      }
     case Paren:
      {
        /*const*/ ParenType /*P*/ CTy = cast_ParenType(Ty);
        if (CTy.isSugared()) {
          IsSugar = true;
          Underlying.$assignMove(CTy.desugar());
        }
        break;
      }
     case Typedef:
      {
        /*const*/ TypedefType /*P*/ CTy = cast_TypedefType(Ty);
        if (CTy.isSugared()) {
          IsSugar = true;
          Underlying.$assignMove(CTy.desugar());
        }
        break;
      }
     case Adjusted:
      {
        /*const*/ AdjustedType /*P*/ CTy = cast_AdjustedType(Ty);
        if (CTy.isSugared()) {
          IsSugar = true;
          Underlying.$assignMove(CTy.desugar());
        }
        break;
      }
     case Decayed:
      {
        /*const*/ DecayedType /*P*/ CTy = cast_DecayedType(Ty);
        if (CTy.isSugared()) {
          IsSugar = true;
          Underlying.$assignMove(CTy.desugar());
        }
        break;
      }
     case TypeOfExpr:
      {
        /*const*/ TypeOfExprType /*P*/ CTy = cast_TypeOfExprType(Ty);
        if (CTy.isSugared()) {
          IsSugar = true;
          Underlying.$assignMove(CTy.desugar());
        }
        break;
      }
     case TypeOf:
      {
        /*const*/ TypeOfType /*P*/ CTy = cast_TypeOfType(Ty);
        if (CTy.isSugared()) {
          IsSugar = true;
          Underlying.$assignMove(CTy.desugar());
        }
        break;
      }
     case Decltype:
      {
        /*const*/ DecltypeType /*P*/ CTy = cast_DecltypeType(Ty);
        if (CTy.isSugared()) {
          IsSugar = true;
          Underlying.$assignMove(CTy.desugar());
        }
        break;
      }
     case UnaryTransform:
      {
        /*const*/ UnaryTransformType /*P*/ CTy = cast_UnaryTransformType(Ty);
        if (CTy.isSugared()) {
          IsSugar = true;
          Underlying.$assignMove(CTy.desugar());
        }
        break;
      }
     case Record:
      {
        /*const*/ RecordType /*P*/ CTy = cast_RecordType(Ty);
        if (CTy.isSugared()) {
          IsSugar = true;
          Underlying.$assignMove(CTy.desugar());
        }
        break;
      }
     case Enum:
      {
        /*const*/ EnumType /*P*/ CTy = cast_EnumType(Ty);
        if (CTy.isSugared()) {
          IsSugar = true;
          Underlying.$assignMove(CTy.desugar());
        }
        break;
      }
     case Elaborated:
      {
        /*const*/ ElaboratedType /*P*/ CTy = cast_ElaboratedType(Ty);
        if (CTy.isSugared()) {
          IsSugar = true;
          Underlying.$assignMove(CTy.desugar());
        }
        break;
      }
     case Attributed:
      {
        /*const*/ AttributedType /*P*/ CTy = cast_AttributedType(Ty);
        if (CTy.isSugared()) {
          IsSugar = true;
          Underlying.$assignMove(CTy.desugar());
        }
        break;
      }
     case TemplateTypeParm:
      {
        /*const*/ TemplateTypeParmType /*P*/ CTy = cast_TemplateTypeParmType(Ty);
        if (CTy.isSugared()) {
          IsSugar = true;
          Underlying.$assignMove(CTy.desugar());
        }
        break;
      }
     case SubstTemplateTypeParm:
      {
        /*const*/ SubstTemplateTypeParmType /*P*/ CTy = cast_SubstTemplateTypeParmType(Ty);
        if (CTy.isSugared()) {
          IsSugar = true;
          Underlying.$assignMove(CTy.desugar());
        }
        break;
      }
     case SubstTemplateTypeParmPack:
      {
        /*const*/ SubstTemplateTypeParmPackType /*P*/ CTy = cast_SubstTemplateTypeParmPackType(Ty);
        if (CTy.isSugared()) {
          IsSugar = true;
          Underlying.$assignMove(CTy.desugar());
        }
        break;
      }
     case TemplateSpecialization:
      {
        /*const*/ TemplateSpecializationType /*P*/ CTy = cast_TemplateSpecializationType(Ty);
        if (CTy.isSugared()) {
          IsSugar = true;
          Underlying.$assignMove(CTy.desugar());
        }
        break;
      }
     case Auto:
      {
        /*const*/ AutoType /*P*/ CTy = cast_AutoType(Ty);
        if (CTy.isSugared()) {
          IsSugar = true;
          Underlying.$assignMove(CTy.desugar());
        }
        break;
      }
     case InjectedClassName:
      {
        /*const*/ InjectedClassNameType /*P*/ CTy = cast_InjectedClassNameType(Ty);
        if (CTy.isSugared()) {
          IsSugar = true;
          Underlying.$assignMove(CTy.desugar());
        }
        break;
      }
     case DependentName:
      {
        /*const*/ DependentNameType /*P*/ CTy = cast_DependentNameType(Ty);
        if (CTy.isSugared()) {
          IsSugar = true;
          Underlying.$assignMove(CTy.desugar());
        }
        break;
      }
     case DependentTemplateSpecialization:
      {
        /*const*/ DependentTemplateSpecializationType /*P*/ CTy = cast_DependentTemplateSpecializationType(Ty);
        if (CTy.isSugared()) {
          IsSugar = true;
          Underlying.$assignMove(CTy.desugar());
        }
        break;
      }
     case PackExpansion:
      {
        /*const*/ PackExpansionType /*P*/ CTy = cast_PackExpansionType(Ty);
        if (CTy.isSugared()) {
          IsSugar = true;
          Underlying.$assignMove(CTy.desugar());
        }
        break;
      }
     case ObjCObject:
      {
        /*const*/ ObjCObjectType /*P*/ CTy = cast_ObjCObjectType(Ty);
        if (CTy.isSugared()) {
          IsSugar = true;
          Underlying.$assignMove(CTy.desugar());
        }
        break;
      }
     case ObjCInterface:
      {
        /*const*/ ObjCInterfaceType /*P*/ CTy = cast_ObjCInterfaceType(Ty);
        if (CTy.isSugared()) {
          IsSugar = true;
          Underlying.$assignMove(CTy.desugar());
        }
        break;
      }
     case ObjCObjectPointer:
      {
        /*const*/ ObjCObjectPointerType /*P*/ CTy = cast_ObjCObjectPointerType(Ty);
        if (CTy.isSugared()) {
          IsSugar = true;
          Underlying.$assignMove(CTy.desugar());
        }
        break;
      }
     case Pipe:
      {
        /*const*/ PipeType /*P*/ CTy = cast_PipeType(Ty);
        if (CTy.isSugared()) {
          IsSugar = true;
          Underlying.$assignMove(CTy.desugar());
        }
        break;
      }
     case Atomic:
      {
        /*const*/ AtomicType /*P*/ CTy = cast_AtomicType(Ty);
        if (CTy.isSugared()) {
          IsSugar = true;
          Underlying.$assignMove(CTy.desugar());
        }
        break;
      }
    }
    
    // If it wasn't sugared, we're done.
    if (!IsSugar) {
      break;
    }
    
    // If the desugared type is a vector type, we don't want to expand
    // it, it will turn into an attribute mess. People want their "vec4".
    if (isa_VectorType(Underlying)) {
      break;
    }
    {
      
      // Don't desugar through the primary typedef of an anonymous type.
      /*const*/ TagType /*P*/ UTT = Underlying.$arrow().getAs(TagType.class);
      if ((UTT != null)) {
        {
          /*const*/ TypedefType /*P*/ QTT = dyn_cast_TypedefType(QT);
          if ((QTT != null)) {
            if (UTT.getDecl().getTypedefNameForAnonDecl() == QTT.getDecl()) {
              break;
            }
          }
        }
      }
    }
    
    // Record that we actually looked through an opaque type here.
    ShouldAKA.$set(true);
    QT.$assign(Underlying);
  }
  {
    
    // If we have a pointer-like type, desugar the pointee as well.
    // FIXME: Handle other pointer-like types.
    /*const*/ PointerType /*P*/ Ty = QT.$arrow().getAs(PointerType.class);
    if ((Ty != null)) {
      QT.$assignMove(Context.getPointerType(Desugar(Context, Ty.getPointeeType(), 
                  ShouldAKA)));
    } else {
      /*const*/ ObjCObjectPointerType /*P*/ Ty$1 = QT.$arrow().getAs(ObjCObjectPointerType.class);
      if ((Ty$1 != null)) {
        QT.$assignMove(Context.getObjCObjectPointerType(Desugar(Context, Ty$1.getPointeeType(), 
                    ShouldAKA)));
      } else {
        /*const*/ LValueReferenceType /*P*/ Ty$2 = QT.$arrow().getAs(LValueReferenceType.class);
        if ((Ty$2 != null)) {
          QT.$assignMove(Context.getLValueReferenceType(Desugar(Context, Ty$2.getPointeeType(), 
                      ShouldAKA)));
        } else {
          /*const*/ RValueReferenceType /*P*/ Ty$3 = QT.$arrow().getAs(RValueReferenceType.class);
          if ((Ty$3 != null)) {
            QT.$assignMove(Context.getRValueReferenceType(Desugar(Context, Ty$3.getPointeeType(), 
                        ShouldAKA)));
          } else {
            /*const*/ ObjCObjectType /*P*/ Ty$4 = QT.$arrow().getAs(ObjCObjectType.class);
            if ((Ty$4 != null)) {
              if (Ty$4.getBaseType().getTypePtr() != Ty$4 && !ShouldAKA.$deref()) {
                QualType BaseType = Desugar(Context, Ty$4.getBaseType(), ShouldAKA);
                QT.$assignMove(Context.getObjCObjectType(new QualType(BaseType), Ty$4.getTypeArgsAsWritten(), 
                        llvm.makeArrayRef(Ty$4.qual_begin(), 
                            Ty$4.getNumProtocols()), 
                        Ty$4.isKindOfTypeAsWritten()));
              }
            }
          }
        }
      }
    }
  }
  
  return QC.apply(Context, new QualType(QT));
}


/// \brief Convert the given type to a string suitable for printing as part of 
/// a diagnostic.
///
/// There are four main criteria when determining whether we should have an
/// a.k.a. clause when pretty-printing a type:
///
/// 1) Some types provide very minimal sugar that doesn't impede the
///    user's understanding --- for example, elaborated type
///    specifiers.  If this is all the sugar we see, we don't want an
///    a.k.a. clause.
/// 2) Some types are technically sugared but are much more familiar
///    when seen in their sugared form --- for example, va_list,
///    vector types, and the magic Objective C types.  We don't
///    want to desugar these, even if we do produce an a.k.a. clause.
/// 3) Some types may have already been desugared previously in this diagnostic.
///    if this is the case, doing another "aka" would just be clutter.
/// 4) Two different types within the same diagnostic have the same output
///    string.  In this case, force an a.k.a with the desugared type when
///    doing so will provide additional information.
///
/// \param Context the context in which the type was allocated
/// \param Ty the type to print
/// \param QualTypeVals pointer values to QualTypes which are used in the
/// diagnostic message
//<editor-fold defaultstate="collapsed" desc="ConvertTypeToDiagnosticString">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp", line = 228,
 FQN="ConvertTypeToDiagnosticString", NM="_ZL29ConvertTypeToDiagnosticStringRN5clang10ASTContextENS_8QualTypeEN4llvm8ArrayRefISt4pairINS_17DiagnosticsEngine12ArgumentKindEiEEENS4_IiEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp -nm=_ZL29ConvertTypeToDiagnosticStringRN5clang10ASTContextENS_8QualTypeEN4llvm8ArrayRefISt4pairINS_17DiagnosticsEngine12ArgumentKindEiEEENS4_IiEE")
//</editor-fold>
public static std.string ConvertTypeToDiagnosticString(final ASTContext /*&*/ Context, QualType Ty, 
                             ArrayRef<std.pair<DiagnosticsEngine.ArgumentKind, ?/*,intptr_t*/>> PrevArgs, 
                             ArrayRef<Object/*intptr_t*/> QualTypeVals) {
  // FIXME: Playing with std::string is really slow.
  boolean ForceAKA = false;
  QualType CanTy = Ty.getCanonicalType();
  std.string S = Ty.getAsString(Context.getPrintingPolicy());
  std.string CanS = CanTy.getAsString(Context.getPrintingPolicy());
  
  for (/*uint*/int I = 0, E = QualTypeVals.size(); I != E; ++I) {
    QualType CompareTy = QualType.getFromOpaquePtr(reinterpret_cast(Object/*void P*/ .class, QualTypeVals.$at(I)));
    if (CompareTy.isNull()) {
      continue;
    }
    if ($eq_QualType$C(CompareTy, Ty)) {
      continue; // Same types
    }
    QualType CompareCanTy = CompareTy.getCanonicalType();
    if ($eq_QualType$C(CompareCanTy, CanTy)) {
      continue; // Same canonical types
    }
    std.string CompareS = CompareTy.getAsString(Context.getPrintingPolicy());
    bool$ref ShouldAKA = create_bool$ref(false);
    QualType CompareDesugar = Desugar(Context, new QualType(CompareTy), ShouldAKA);
    std.string CompareDesugarStr = CompareDesugar.getAsString(Context.getPrintingPolicy());
    if ($noteq_string$C(CompareS, S) && $noteq_string$C(CompareDesugarStr, S)) {
      continue; // The type string is different than the comparison string
      // and the desugared comparison string.
    }
    std.string CompareCanS = CompareCanTy.getAsString(Context.getPrintingPolicy());
    if ($eq_str$C(CompareCanS, CanS)) {
      continue; // No new info from canonical type
    }
    
    ForceAKA = true;
    break;
  }
  
  // Check to see if we already desugared this type in this
  // diagnostic.  If so, don't do it again.
  boolean Repeated = false;
  for (/*uint*/int i = 0, e = PrevArgs.size(); i != e; ++i) {
    // TODO: Handle ak_declcontext case.
    if (PrevArgs.$at(i).first == DiagnosticsEngine.ArgumentKind.ak_qualtype) {
      Object/*void P*/ Ptr = (Object/*void P*/ )PrevArgs.$at(i).second;
      QualType PrevTy/*J*/= QualType.getFromOpaquePtr(Ptr);
      if ($eq_QualType$C(PrevTy, Ty)) {
        Repeated = true;
        break;
      }
    }
  }
  
  // Consider producing an a.k.a. clause if removing all the direct
  // sugar gives us something "significantly different".
  if (!Repeated) {
    bool$ref ShouldAKA = create_bool$ref(false);
    QualType DesugaredTy = Desugar(Context, new QualType(Ty), ShouldAKA);
    if (ShouldAKA.$deref() || ForceAKA) {
      if ($eq_QualType$C(DesugaredTy, Ty)) {
        DesugaredTy.$assignMove(Ty.getCanonicalType());
      }
      std.string akaStr = DesugaredTy.getAsString(Context.getPrintingPolicy());
      if ($noteq_string$C(akaStr, S)) {
        S.$assignMove($add_string_T$C$P($add_string_string$C($add_string_T$C$P($add_T$C$P_string$C(/*KEEP_STR*/"'", S), /*KEEP_STR*/"' (aka '"), akaStr), /*KEEP_STR*/"')"));
        return S;
      }
    }
    
    // Give some additional info on vector types. These are either not desugared
    // or displaying complex __attribute__ expressions so add details of the
    // type and element count.
    if (Ty.$arrow().isVectorType()) {
      raw_string_ostream OS = null;
      try {
        /*const*/ VectorType /*P*/ VTy = Ty.$arrow().getAs(VectorType.class);
        std.string DecoratedString/*J*/= new std.string();
        OS/*J*/= new raw_string_ostream(DecoratedString);
        /*const*/char$ptr/*char P*/ Values = $tryClone($greater_uint(VTy.getNumElements(), 1) ? $("values") : $("value"));
        OS.$out(/*KEEP_STR*/$SGL_QUOTE).$out(S).$out(/*KEEP_STR*/"' (vector of ").$out_uint(VTy.getNumElements()).$out(/*KEEP_STR*/" '").$out(
            VTy.getElementType().getAsString(Context.getPrintingPolicy())
        ).$out(
            /*KEEP_STR*/"' "
        ).$out(Values).$out(/*KEEP_STR*/$RPAREN);
        return new std.string(OS.str());
      } finally {
        if (OS != null) { OS.$destroy(); }
      }
    }
  }
  
  S.$assignMove($add_string_T$C$P($add_T$C$P_string$C(/*KEEP_STR*/"'", S), /*KEEP_STR*/"'"));
  return S;
}

// end anonymous namespace

/// FormatTemplateTypeDiff - A helper static function to start the template
/// diff and return the properly formatted string.  Returns true if the diff
/// is successful.
//<editor-fold defaultstate="collapsed" desc="FormatTemplateTypeDiff">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp", line = 2038,
 FQN="FormatTemplateTypeDiff", NM="_ZL22FormatTemplateTypeDiffRN5clang10ASTContextENS_8QualTypeES2_bbbbRN4llvm11raw_ostreamE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp -nm=_ZL22FormatTemplateTypeDiffRN5clang10ASTContextENS_8QualTypeES2_bbbbRN4llvm11raw_ostreamE")
//</editor-fold>
public static boolean FormatTemplateTypeDiff(final ASTContext /*&*/ Context, QualType FromType, 
                      QualType ToType, boolean PrintTree, 
                      boolean PrintFromType, boolean ElideType, 
                      boolean ShowColors, final raw_ostream /*&*/ OS) {
  TemplateDiff TD = null;
  try {
    if (PrintTree) {
      PrintFromType = true;
    }
    TD/*J*/= new TemplateDiff(OS, Context, new QualType(FromType), new QualType(ToType), PrintTree, PrintFromType, 
        ElideType, ShowColors);
    TD.DiffTemplate();
    return TD.Emit();
  } finally {
    if (TD != null) { TD.$destroy(); }
  }
}

} // END OF class ASTDiagnosticStatics
