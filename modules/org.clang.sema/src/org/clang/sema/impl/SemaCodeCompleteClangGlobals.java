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
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.ast.aliases.*;
import org.clang.basic.*;
import org.clang.sema.*;
import org.clang.clangc.*;
import static org.clang.sema.SemaClangGlobals.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstTypesRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type SemaCodeCompleteClangGlobals">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN5clang16getDeclUsageTypeERNS_10ASTContextEPKNS_9NamedDeclE;_ZN5clang20getCursorKindForDeclEPKNS_4DeclE;_ZN5clang21getMacroUsagePriorityEN4llvm9StringRefERKNS_11LangOptionsEb;_ZN5clang22getSimplifiedTypeClassENS_7CanQualINS_4TypeEEE; -static-type=SemaCodeCompleteClangGlobals -package=org.clang.sema.impl")
//</editor-fold>
public final class SemaCodeCompleteClangGlobals {


/// \brief Determine the simplified type class of the given canonical type.

/// \brief A simplified classification of types used to determine whether two
/// types are "similar enough" when adjusting priorities.
//<editor-fold defaultstate="collapsed" desc="clang::getSimplifiedTypeClass">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 601,
 FQN="clang::getSimplifiedTypeClass", NM="_ZN5clang22getSimplifiedTypeClassENS_7CanQualINS_4TypeEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN5clang22getSimplifiedTypeClassENS_7CanQualINS_4TypeEEE")
//</editor-fold>
public static SimplifiedTypeClass getSimplifiedTypeClass(CanQual<Type> T) {
  switch (((CanProxyType)T.$arrow()).$arrow().getTypeClass()) {
   case Builtin:
    switch (cast_BuiltinType(T).getKind()) {
     case Void:
      return SimplifiedTypeClass.STC_Void;
     case NullPtr:
      return SimplifiedTypeClass.STC_Pointer;
     case Overload:
     case Dependent:
      return SimplifiedTypeClass.STC_Other;
     case ObjCId:
     case ObjCClass:
     case ObjCSel:
      return SimplifiedTypeClass.STC_ObjectiveC;
     default:
      return SimplifiedTypeClass.STC_Arithmetic;
    }
   case Complex:
    return SimplifiedTypeClass.STC_Arithmetic;
   case Pointer:
    return SimplifiedTypeClass.STC_Pointer;
   case BlockPointer:
    return SimplifiedTypeClass.STC_Block;
   case LValueReference:
   case RValueReference:
    return getSimplifiedTypeClass(((CanProxyReferenceType)((CanProxyType)T.$arrow()).$arrow().getAs(ReferenceType.class)).$arrow().getPointeeType());
   case ConstantArray:
   case IncompleteArray:
   case VariableArray:
   case DependentSizedArray:
    return SimplifiedTypeClass.STC_Array;
   case DependentSizedExtVector:
   case Vector:
   case ExtVector:
    return SimplifiedTypeClass.STC_Arithmetic;
   case FunctionProto:
   case FunctionNoProto:
    return SimplifiedTypeClass.STC_Function;
   case Record:
    return SimplifiedTypeClass.STC_Record;
   case Enum:
    return SimplifiedTypeClass.STC_Arithmetic;
   case ObjCObject:
   case ObjCInterface:
   case ObjCObjectPointer:
    return SimplifiedTypeClass.STC_ObjectiveC;
   default:
    return SimplifiedTypeClass.STC_Other;
  }
}


/// \brief Determine the type that this declaration will have if it is used
/// as a type or in an expression.

/// \brief Get the type that a given expression will have if this declaration
/// is used as an expression in its "typical" code-completion form.
//<editor-fold defaultstate="collapsed" desc="clang::getDeclUsageType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 670,
 FQN="clang::getDeclUsageType", NM="_ZN5clang16getDeclUsageTypeERNS_10ASTContextEPKNS_9NamedDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN5clang16getDeclUsageTypeERNS_10ASTContextEPKNS_9NamedDeclE")
//</editor-fold>
public static QualType getDeclUsageType(final ASTContext /*&*/ C, /*const*/ NamedDecl /*P*/ ND) {
  ND = cast_NamedDecl(ND.getUnderlyingDecl$Const());
  {
    
    /*const*/ TypeDecl /*P*/ Type = dyn_cast_TypeDecl(ND);
    if ((Type != null)) {
      return C.getTypeDeclType(Type);
    }
  }
  {
    /*const*/ ObjCInterfaceDecl /*P*/ Iface = dyn_cast_ObjCInterfaceDecl(ND);
    if ((Iface != null)) {
      return C.getObjCInterfaceType(Iface);
    }
  }
  
  QualType T/*J*/= new QualType();
  {
    /*const*/ FunctionDecl /*P*/ Function = ND.getAsFunction$Const();
    if ((Function != null)) {
      T.$assignMove(Function.getCallResultType());
    } else {
      /*const*/ ObjCMethodDecl /*P*/ Method = dyn_cast_ObjCMethodDecl(ND);
      if ((Method != null)) {
        T.$assignMove(Method.getSendResultType());
      } else {
        /*const*/ EnumConstantDecl /*P*/ Enumerator = dyn_cast_EnumConstantDecl(ND);
        if ((Enumerator != null)) {
          T.$assignMove(C.getTypeDeclType(cast_EnumDecl(Enumerator.getDeclContext$Const())));
        } else {
          /*const*/ ObjCPropertyDecl /*P*/ Property = dyn_cast_ObjCPropertyDecl(ND);
          if ((Property != null)) {
            T.$assignMove(Property.getType());
          } else {
            /*const*/ ValueDecl /*P*/ Value = dyn_cast_ValueDecl(ND);
            if ((Value != null)) {
              T.$assignMove(Value.getType());
            } else {
              return new QualType();
            }
          }
        }
      }
    }
  }
  
  // Dig through references, function pointers, and block pointers to
  // get down to the likely type of an expression when the entity is
  // used.
  do {
    {
      /*const*/ ReferenceType /*P*/ Ref = T.$arrow().getAs(ReferenceType.class);
      if ((Ref != null)) {
        T.$assignMove(Ref.getPointeeType());
        continue;
      }
    }
    {
      
      /*const*/ PointerType /*P*/ Pointer = T.$arrow().getAs(PointerType.class);
      if ((Pointer != null)) {
        if (Pointer.getPointeeType().$arrow().isFunctionType()) {
          T.$assignMove(Pointer.getPointeeType());
          continue;
        }
        
        break;
      }
    }
    {
      
      /*const*/ BlockPointerType /*P*/ Block = T.$arrow().getAs(BlockPointerType.class);
      if ((Block != null)) {
        T.$assignMove(Block.getPointeeType());
        continue;
      }
    }
    {
      
      /*const*/ FunctionType /*P*/ Function = T.$arrow().getAs(FunctionType.class);
      if ((Function != null)) {
        T.$assignMove(Function.getReturnType());
        continue;
      }
    }
    
    break;
  } while (true);
  
  return T;
}


/// \brief Determine the priority to be given to a macro code completion result
/// with the given name.
///
/// \param MacroName The name of the macro.
///
/// \param LangOpts Options describing the current language dialect.
///
/// \param PreferredTypeIsPointer Whether the preferred type for the context
/// of this macro is a pointer type.
//<editor-fold defaultstate="collapsed" desc="clang::getMacroUsagePriority">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 2999,
 FQN="clang::getMacroUsagePriority", NM="_ZN5clang21getMacroUsagePriorityEN4llvm9StringRefERKNS_11LangOptionsEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN5clang21getMacroUsagePriorityEN4llvm9StringRefERKNS_11LangOptionsEb")
//</editor-fold>
public static /*uint*/int getMacroUsagePriority(StringRef MacroName, 
                     final /*const*/ LangOptions /*&*/ LangOpts) {
  return getMacroUsagePriority(MacroName, 
                     LangOpts, 
                     false);
}
public static /*uint*/int getMacroUsagePriority(StringRef MacroName, 
                     final /*const*/ LangOptions /*&*/ LangOpts, 
                     boolean PreferredTypeIsPointer/*= false*/) {
  /*uint*/int Priority = CCP_Macro;
  
  // Treat the "nil", "Nil" and "NULL" macros as null pointer constants.
  if (MacroName.equals(/*STRINGREF_STR*/"nil") || MacroName.equals(/*STRINGREF_STR*/"NULL")
     || MacroName.equals(/*STRINGREF_STR*/"Nil")) {
    Priority = CCP_Constant;
    if (PreferredTypeIsPointer) {
      Priority = $div_uint(Priority, CCF_SimilarTypeMatch);
    }
  } else // Treat "YES", "NO", "true", and "false" as constants.
  if (MacroName.equals(/*STRINGREF_STR*/"YES") || MacroName.equals(/*STRINGREF_STR*/"NO")
     || MacroName.equals(/*STRINGREF_STR*/$true) || MacroName.equals(/*STRINGREF_STR*/$false)) {
    Priority = CCP_Constant;
  } else // Treat "bool" as a type.
  if (MacroName.equals(/*STRINGREF_STR*/$bool)) {
    Priority = CCP_Type + (LangOpts.ObjC1 ? CCD_bool_in_ObjC : 0);
  }
  
  return Priority;
}


/// \brief Determine the libclang cursor kind associated with the given
/// declaration.
//<editor-fold defaultstate="collapsed" desc="clang::getCursorKindForDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 3023,
 FQN="clang::getCursorKindForDecl", NM="_ZN5clang20getCursorKindForDeclEPKNS_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN5clang20getCursorKindForDeclEPKNS_4DeclE")
//</editor-fold>
public static CXCursorKind getCursorKindForDecl(/*const*/ Decl /*P*/ D) {
  if (!(D != null)) {
    return CXCursorKind.CXCursor_UnexposedDecl;
  }
  switch (D.getKind()) {
   case Enum:
    return CXCursorKind.CXCursor_EnumDecl;
   case EnumConstant:
    return CXCursorKind.CXCursor_EnumConstantDecl;
   case Field:
    return CXCursorKind.CXCursor_FieldDecl;
   case Function:
    return CXCursorKind.CXCursor_FunctionDecl;
   case ObjCCategory:
    return CXCursorKind.CXCursor_ObjCCategoryDecl;
   case ObjCCategoryImpl:
    return CXCursorKind.CXCursor_ObjCCategoryImplDecl;
   case ObjCImplementation:
    return CXCursorKind.CXCursor_ObjCImplementationDecl;
   case ObjCInterface:
    return CXCursorKind.CXCursor_ObjCInterfaceDecl;
   case ObjCIvar:
    return CXCursorKind.CXCursor_ObjCIvarDecl;
   case ObjCMethod:
    return cast_ObjCMethodDecl(D).isInstanceMethod() ? CXCursorKind.CXCursor_ObjCInstanceMethodDecl : CXCursorKind.CXCursor_ObjCClassMethodDecl;
   case CXXMethod:
    return CXCursorKind.CXCursor_CXXMethod;
   case CXXConstructor:
    return CXCursorKind.CXCursor_Constructor;
   case CXXDestructor:
    return CXCursorKind.CXCursor_Destructor;
   case CXXConversion:
    return CXCursorKind.CXCursor_ConversionFunction;
   case ObjCProperty:
    return CXCursorKind.CXCursor_ObjCPropertyDecl;
   case ObjCProtocol:
    return CXCursorKind.CXCursor_ObjCProtocolDecl;
   case ParmVar:
    return CXCursorKind.CXCursor_ParmDecl;
   case Typedef:
    return CXCursorKind.CXCursor_TypedefDecl;
   case TypeAlias:
    return CXCursorKind.CXCursor_TypeAliasDecl;
   case TypeAliasTemplate:
    return CXCursorKind.CXCursor_TypeAliasTemplateDecl;
   case Var:
    return CXCursorKind.CXCursor_VarDecl;
   case Namespace:
    return CXCursorKind.CXCursor_Namespace;
   case NamespaceAlias:
    return CXCursorKind.CXCursor_NamespaceAlias;
   case TemplateTypeParm:
    return CXCursorKind.CXCursor_TemplateTypeParameter;
   case NonTypeTemplateParm:
    return CXCursorKind.CXCursor_NonTypeTemplateParameter;
   case TemplateTemplateParm:
    return CXCursorKind.CXCursor_TemplateTemplateParameter;
   case FunctionTemplate:
    return CXCursorKind.CXCursor_FunctionTemplate;
   case ClassTemplate:
    return CXCursorKind.CXCursor_ClassTemplate;
   case AccessSpec:
    return CXCursorKind.CXCursor_CXXAccessSpecifier;
   case ClassTemplatePartialSpecialization:
    return CXCursorKind.CXCursor_ClassTemplatePartialSpecialization;
   case UsingDirective:
    return CXCursorKind.CXCursor_UsingDirective;
   case StaticAssert:
    return CXCursorKind.CXCursor_StaticAssert;
   case TranslationUnit:
    return CXCursorKind.CXCursor_TranslationUnit;
   case Using:
   case UnresolvedUsingValue:
   case UnresolvedUsingTypename:
    return CXCursorKind.CXCursor_UsingDeclaration;
   case ObjCPropertyImpl:
    switch (cast_ObjCPropertyImplDecl(D).getPropertyImplementation()) {
     case Dynamic:
      return CXCursorKind.CXCursor_ObjCDynamicDecl;
     case Synthesize:
      return CXCursorKind.CXCursor_ObjCSynthesizeDecl;
    }
   case Import:
    return CXCursorKind.CXCursor_ModuleImportDecl;
   case ObjCTypeParam:
    return CXCursorKind.CXCursor_TemplateTypeParameter;
   default:
    {
      /*const*/ TagDecl /*P*/ TD = dyn_cast_TagDecl(D);
      if ((TD != null)) {
        switch (TD.getTagKind()) {
         case TTK_Interface: // fall through
         case TTK_Struct:
          return CXCursorKind.CXCursor_StructDecl;
         case TTK_Class:
          return CXCursorKind.CXCursor_ClassDecl;
         case TTK_Union:
          return CXCursorKind.CXCursor_UnionDecl;
         case TTK_Enum:
          return CXCursorKind.CXCursor_EnumDecl;
        }
      }
    }
  }
  
  return CXCursorKind.CXCursor_UnexposedDecl;
}

} // END OF class SemaCodeCompleteClangGlobals
