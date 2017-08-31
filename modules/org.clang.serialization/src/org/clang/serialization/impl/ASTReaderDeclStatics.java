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

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import org.clang.ast.*;
import org.clang.serialization.java.SerializationFunctionPointers.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.serialization.impl.ASTReaderDeclStatics.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.support.*;
import org.clang.ast.java.Common$TemplateParmDecl;


//<editor-fold defaultstate="collapsed" desc="static type ASTReaderDeclStatics">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.clang.serialization.impl.ASTReaderDeclStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=Tpl__Z14merged_redeclsPT_;Tpl__ZL11assert_castT_;Tpl__ZL11assert_castz;Tpl__ZL18forAllLaterRedeclsPT_T0_;Tpl__ZL30inheritDefaultTemplateArgumentRN5clang10ASTContextEPT_PNS_4DeclE;_ZL12getNamespacePKN5clang19NestedNameSpecifierE;_ZL12isSameEntityPN5clang9NamedDeclES1_;_ZL13newDeclIDListRN5clang10ASTContextEPjRN4llvm15SmallVectorImplIjEE;_ZL15isSameQualifierPKN5clang19NestedNameSpecifierES2_;_ZL17getDeclForMergingPN5clang9NamedDeclEb;_ZL22isConsumerInterestedInPN5clang4DeclEb;_ZL23isSameTemplateParameterPKN5clang9NamedDeclES2_;_ZL27isSameTemplateParameterListPKN5clang21TemplateParameterListES2_;_ZL31inheritDefaultTemplateArgumentsRN5clang10ASTContextEPNS_12TemplateDeclES3_; -static-type=ASTReaderDeclStatics -package=org.clang.serialization.impl")
//</editor-fold>
public final class ASTReaderDeclStatics {

// end anonymous namespace
/*template <typename DeclT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="merged_redecls">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 441,
 FQN="merged_redecls", NM="Tpl__Z14merged_redeclsPT_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=Tpl__Z14merged_redeclsPT_")
//</editor-fold>
public static </*typename*/ DeclT extends Redeclarable> iterator_range<DeclT /*P*/ > merged_redecls(DeclT /*P*/ D) {
  return llvm.make_range(new MergedRedeclIterator<DeclT>(D), 
      new MergedRedeclIterator<DeclT>());
}

//<editor-fold defaultstate="collapsed" desc="newDeclIDList">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 1906,
 FQN="newDeclIDList", NM="_ZL13newDeclIDListRN5clang10ASTContextEPjRN4llvm15SmallVectorImplIjEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZL13newDeclIDListRN5clang10ASTContextEPjRN4llvm15SmallVectorImplIjEE")
//</editor-fold>
public static /*uint32_t P*/uint$ptr newDeclIDList(final ASTContext /*&*/ Context, /*uint32_t P*/uint$ptr Old, 
             final SmallVectorImplUInt /*&*/ IDs) {
  assert (!IDs.empty()) : "no IDs to add to list";
  if (Native.$bool(Old)) {
    IDs.insert(IDs.end(), Old.$add(1), Old.$add(1).$add(Old.$at(0)));
    std.sort(IDs.begin(), IDs.end());
    IDs.erase(std.unique(IDs.begin(), IDs.end()), IDs.end());
  }
  
  uint$ptr/*uint P*/ Result = create_uint$ptr(new int[1 + IDs.size()]);//(/*NEW_EXPR [operator new[]] NM=_ZnajRKN5clang10ASTContextEj*/
  ///*new (Context)*/ /*FIXME 1: $array_new_uint_ASTContext$C_uint*/new$uint(1 + IDs.size()));
  Result.$set(IDs.size());
  std.copy(IDs.begin(), IDs.end(), Result.$add(1));
  return Result;
}


/// \brief "Cast" to type T, asserting if we don't have an implicit conversion.
/// We use this to put code in a template that will only be valid for certain
/// instantiations.
/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="assert_cast">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 2325,
 FQN="assert_cast", NM="Tpl__ZL11assert_castT_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=Tpl__ZL11assert_castT_")
//</editor-fold>
public static </*typename*/ T> T assert_cast(T t) {
  return t;
}

/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="assert_cast">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 2326,
 FQN="assert_cast", NM="Tpl__ZL11assert_castz",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=Tpl__ZL11assert_castz")
//</editor-fold>
public static </*typename*/ T> T assert_cast(Object ... $VarArg) {
  throw new llvm_unreachable("bad assert_cast");
}


/// \brief Determine whether the consumer will be interested in seeing
/// this declaration (via HandleTopLevelDecl).
///
/// This routine should return true for anything that might affect
/// code generation, e.g., inline function definitions, Objective-C
/// declarations with metadata, etc.
//<editor-fold defaultstate="collapsed" desc="isConsumerInterestedIn">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 2497,
 FQN="isConsumerInterestedIn", NM="_ZL22isConsumerInterestedInPN5clang4DeclEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZL22isConsumerInterestedInPN5clang4DeclEb")
//</editor-fold>
public static boolean isConsumerInterestedIn(Decl /*P*/ D, boolean HasBody) {
  // An ObjCMethodDecl is never considered as "interesting" because its
  // implementation container always is.
  if (isa_FileScopeAsmDecl(D)
     || isa_ObjCProtocolDecl(D)
     || isa_ObjCImplDecl(D)
     || isa_ImportDecl(D)
     || isa_PragmaCommentDecl(D)
     || isa_PragmaDetectMismatchDecl(D)) {
    return true;
  }
  if (isa_OMPThreadPrivateDecl(D) || isa_OMPDeclareReductionDecl(D)) {
    return !D.getDeclContext().isFunctionOrMethod();
  }
  {
    VarDecl /*P*/ Var = dyn_cast_VarDecl(D);
    if ((Var != null)) {
      return Var.isFileVarDecl()
         && Var.isThisDeclarationADefinition() == VarDecl.DefinitionKind.Definition;
    }
  }
  {
    FunctionDecl /*P*/ Func = dyn_cast_FunctionDecl(D);
    if ((Func != null)) {
      return Func.doesThisDeclarationHaveABody() || HasBody;
    }
  }
  
  return false;
}


/// \brief Determine whether two template parameter lists are similar enough
/// that they may be used in declarations of the same template.
//<editor-fold defaultstate="collapsed" desc="isSameTemplateParameterList">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 2620,
 FQN="isSameTemplateParameterList", NM="_ZL27isSameTemplateParameterListPKN5clang21TemplateParameterListES2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZL27isSameTemplateParameterListPKN5clang21TemplateParameterListES2_")
//</editor-fold>
public static boolean isSameTemplateParameterList(/*const*/ TemplateParameterList /*P*/ X, 
                           /*const*/ TemplateParameterList /*P*/ Y) {
  if (X.size() != Y.size()) {
    return false;
  }
  
  for (/*uint*/int I = 0, N = X.size(); I != N; ++I)  {
    if (!isSameTemplateParameter(X.getParam$Const(I), Y.getParam$Const(I))) {
      return false;
    }
  }
  
  return true;
}


/// \brief Determine whether two template parameters are similar enough
/// that they may be used in declarations of the same template.
//<editor-fold defaultstate="collapsed" desc="isSameTemplateParameter">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 2548,
 FQN="isSameTemplateParameter", NM="_ZL23isSameTemplateParameterPKN5clang9NamedDeclES2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZL23isSameTemplateParameterPKN5clang9NamedDeclES2_")
//</editor-fold>
public static boolean isSameTemplateParameter(/*const*/ NamedDecl /*P*/ X, 
                       /*const*/ NamedDecl /*P*/ Y) {
  if (X.getKind() != Y.getKind()) {
    return false;
  }
  {
    
    /*const*/ TemplateTypeParmDecl /*P*/ TX = dyn_cast_TemplateTypeParmDecl(X);
    if ((TX != null)) {
      /*const*/ TemplateTypeParmDecl /*P*/ TY = cast_TemplateTypeParmDecl(Y);
      return TX.isParameterPack() == TY.isParameterPack();
    }
  }
  {
    
    /*const*/ NonTypeTemplateParmDecl /*P*/ TX = dyn_cast_NonTypeTemplateParmDecl(X);
    if ((TX != null)) {
      /*const*/ NonTypeTemplateParmDecl /*P*/ TY = cast_NonTypeTemplateParmDecl(Y);
      return TX.isParameterPack() == TY.isParameterPack()
         && TX.getASTContext().hasSameType(TX.getType(), TY.getType());
    }
  }
  
  /*const*/ TemplateTemplateParmDecl /*P*/ TX = cast_TemplateTemplateParmDecl(X);
  /*const*/ TemplateTemplateParmDecl /*P*/ TY = cast_TemplateTemplateParmDecl(Y);
  return TX.isParameterPack() == TY.isParameterPack()
     && isSameTemplateParameterList(TX.getTemplateParameters(), 
      TY.getTemplateParameters());
}

//<editor-fold defaultstate="collapsed" desc="getNamespace">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 2571,
 FQN="getNamespace", NM="_ZL12getNamespacePKN5clang19NestedNameSpecifierE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZL12getNamespacePKN5clang19NestedNameSpecifierE")
//</editor-fold>
public static NamespaceDecl /*P*/ getNamespace(/*const*/ NestedNameSpecifier /*P*/ X) {
  {
    NamespaceDecl /*P*/ NS = X.getAsNamespace();
    if ((NS != null)) {
      return NS;
    }
  }
  {
    NamespaceAliasDecl /*P*/ NAS = X.getAsNamespaceAlias();
    if ((NAS != null)) {
      return NAS.getNamespace();
    }
  }
  return null;
}

//<editor-fold defaultstate="collapsed" desc="isSameQualifier">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 2579,
 FQN="isSameQualifier", NM="_ZL15isSameQualifierPKN5clang19NestedNameSpecifierES2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZL15isSameQualifierPKN5clang19NestedNameSpecifierES2_")
//</editor-fold>
public static boolean isSameQualifier(/*const*/ NestedNameSpecifier /*P*/ X, 
               /*const*/ NestedNameSpecifier /*P*/ Y) {
  {
    NamespaceDecl /*P*/ NSX = getNamespace(X);
    if ((NSX != null)) {
      NamespaceDecl /*P*/ NSY = getNamespace(Y);
      if (!(NSY != null) || NSX.getCanonicalDecl() != NSY.getCanonicalDecl()) {
        return false;
      }
    } else if (X.getKind() != Y.getKind()) {
      return false;
    }
  }
  
  // FIXME: For namespaces and types, we're permitted to check that the entity
  // is named via the same tokens. We should probably do so.
  switch (X.getKind()) {
   case Identifier:
    if (X.getAsIdentifier() != Y.getAsIdentifier()) {
      return false;
    }
    break;
   case Namespace:
   case NamespaceAlias:
    // We've already checked that we named the same namespace.
    break;
   case TypeSpec:
   case TypeSpecWithTemplate:
    if (QualType.$noteq_QualType$C(X.getAsType().getCanonicalTypeInternal(), 
        Y.getAsType().getCanonicalTypeInternal())) {
      return false;
    }
    break;
   case Global:
   case Super:
    return true;
  }
  
  // Recurse into earlier portion of NNS, if any.
  NestedNameSpecifier /*P*/ PX = X.getPrefix();
  NestedNameSpecifier /*P*/ PY = Y.getPrefix();
  if ((PX != null) && (PY != null)) {
    return isSameQualifier(PX, PY);
  }
  return !(PX != null) && !(PY != null);
}


/// \brief Determine whether the two declarations refer to the same entity.
//<editor-fold defaultstate="collapsed" desc="isSameEntity">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 2633,
 FQN="isSameEntity", NM="_ZL12isSameEntityPN5clang9NamedDeclES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZL12isSameEntityPN5clang9NamedDeclES1_")
//</editor-fold>
public static boolean isSameEntity(NamedDecl /*P*/ X, NamedDecl /*P*/ Y) {
  assert (DeclarationName.$eq_DeclarationName(X.getDeclName(), Y.getDeclName())) : "Declaration name mismatch!";
  if (X == Y) {
    return true;
  }
  
  // Must be in the same context.
  if (!X.getDeclContext().getRedeclContext().Equals(Y.getDeclContext().getRedeclContext())) {
    return false;
  }
  {
    
    // Two typedefs refer to the same entity if they have the same underlying
    // type.
    TypedefNameDecl /*P*/ TypedefX = dyn_cast_TypedefNameDecl(X);
    if ((TypedefX != null)) {
      {
        TypedefNameDecl /*P*/ TypedefY = dyn_cast_TypedefNameDecl(Y);
        if ((TypedefY != null)) {
          return X.getASTContext().hasSameType(TypedefX.getUnderlyingType(), 
              TypedefY.getUnderlyingType());
        }
      }
    }
  }
  
  // Must have the same kind.
  if (X.getKind() != Y.getKind()) {
    return false;
  }
  
  // Objective-C classes and protocols with the same name always match.
  if (isa_ObjCInterfaceDecl(X) || isa_ObjCProtocolDecl(X)) {
    return true;
  }
  if (isa_ClassTemplateSpecializationDecl(X)) {
    // No need to handle these here: we merge them when adding them to the
    // template.
    return false;
  }
  {
    
    // Compatible tags match.
    TagDecl /*P*/ TagX = dyn_cast_TagDecl(X);
    if ((TagX != null)) {
      TagDecl /*P*/ TagY = cast_TagDecl(Y);
      return (TagX.getTagKind() == TagY.getTagKind())
         || ((TagX.getTagKind() == TagTypeKind.TTK_Struct || TagX.getTagKind() == TagTypeKind.TTK_Class
         || TagX.getTagKind() == TagTypeKind.TTK_Interface)
         && (TagY.getTagKind() == TagTypeKind.TTK_Struct || TagY.getTagKind() == TagTypeKind.TTK_Class
         || TagY.getTagKind() == TagTypeKind.TTK_Interface));
    }
  }
  {
    
    // Functions with the same type and linkage match.
    // FIXME: This needs to cope with merging of prototyped/non-prototyped
    // functions, etc.
    FunctionDecl /*P*/ FuncX = dyn_cast_FunctionDecl(X);
    if ((FuncX != null)) {
      FunctionDecl /*P*/ FuncY = cast_FunctionDecl(Y);
      {
        CXXConstructorDecl /*P*/ CtorX = dyn_cast_CXXConstructorDecl(X);
        if ((CtorX != null)) {
          CXXConstructorDecl /*P*/ CtorY = cast_CXXConstructorDecl(Y);
          if (CtorX.getInheritedConstructor().$bool()
             && !isSameEntity(CtorX.getInheritedConstructor().getConstructor(), 
              CtorY.getInheritedConstructor().getConstructor())) {
            return false;
          }
        }
      }
      return (FuncX.getLinkageInternal() == FuncY.getLinkageInternal())
         && FuncX.getASTContext().hasSameType(FuncX.getType(), FuncY.getType());
    }
  }
  {
    
    // Variables with the same type and linkage match.
    VarDecl /*P*/ VarX = dyn_cast_VarDecl(X);
    if ((VarX != null)) {
      VarDecl /*P*/ VarY = cast_VarDecl(Y);
      if (VarX.getLinkageInternal() == VarY.getLinkageInternal()) {
        final ASTContext /*&*/ C = VarX.getASTContext();
        if (C.hasSameType(VarX.getType(), VarY.getType())) {
          return true;
        }
        
        // We can get decls with different types on the redecl chain. Eg.
        // template <typename T> struct S { static T Var[]; }; // #1
        // template <typename T> T S<T>::Var[sizeof(T)]; // #2
        // Only? happens when completing an incomplete array type. In this case
        // when comparing #1 and #2 we should go through their element type.
        /*const*/ ArrayType /*P*/ VarXTy = C.getAsArrayType(VarX.getType());
        /*const*/ ArrayType /*P*/ VarYTy = C.getAsArrayType(VarY.getType());
        if (!(VarXTy != null) || !(VarYTy != null)) {
          return false;
        }
        if (VarXTy.isIncompleteArrayType() || VarYTy.isIncompleteArrayType()) {
          return C.hasSameType(VarXTy.getElementType(), VarYTy.getElementType());
        }
      }
      return false;
    }
  }
  {
    
    // Namespaces with the same name and inlinedness match.
    NamespaceDecl /*P*/ NamespaceX = dyn_cast_NamespaceDecl(X);
    if ((NamespaceX != null)) {
      NamespaceDecl /*P*/ NamespaceY = cast_NamespaceDecl(Y);
      return NamespaceX.isInline() == NamespaceY.isInline();
    }
  }
  {
    
    // Identical template names and kinds match if their template parameter lists
    // and patterns match.
    TemplateDecl /*P*/ TemplateX = dyn_cast_TemplateDecl(X);
    if ((TemplateX != null)) {
      TemplateDecl /*P*/ TemplateY = cast_TemplateDecl(Y);
      return isSameEntity(TemplateX.getTemplatedDecl(), 
          TemplateY.getTemplatedDecl())
         && isSameTemplateParameterList(TemplateX.getTemplateParameters(), 
          TemplateY.getTemplateParameters());
    }
  }
  {
    
    // Fields with the same name and the same type match.
    FieldDecl /*P*/ FDX = dyn_cast_FieldDecl(X);
    if ((FDX != null)) {
      FieldDecl /*P*/ FDY = cast_FieldDecl(Y);
      // FIXME: Also check the bitwidth is odr-equivalent, if any.
      return X.getASTContext().hasSameType(FDX.getType(), FDY.getType());
    }
  }
  {
    
    // Indirect fields with the same target field match.
    IndirectFieldDecl /*P*/ IFDX = dyn_cast_IndirectFieldDecl(X);
    if ((IFDX != null)) {
      IndirectFieldDecl /*P*/ IFDY = cast_IndirectFieldDecl(Y);
      return IFDX.getAnonField().getCanonicalDecl()
         == IFDY.getAnonField().getCanonicalDecl();
    }
  }
  
  // Enumerators with the same name match.
  if (isa_EnumConstantDecl(X)) {
    // FIXME: Also check the value is odr-equivalent.
    return true;
  }
  {
    
    // Using shadow declarations with the same target match.
    UsingShadowDecl /*P*/ USX = dyn_cast_UsingShadowDecl(X);
    if ((USX != null)) {
      UsingShadowDecl /*P*/ USY = cast_UsingShadowDecl(Y);
      return USX.getTargetDecl() == USY.getTargetDecl();
    }
  }
  {
    
    // Using declarations with the same qualifier match. (We already know that
    // the name matches.)
    UsingDecl /*P*/ UX = dyn_cast_UsingDecl(X);
    if ((UX != null)) {
      UsingDecl /*P*/ UY = cast_UsingDecl(Y);
      return isSameQualifier(UX.getQualifier(), UY.getQualifier())
         && UX.hasTypename() == UY.hasTypename()
         && UX.isAccessDeclaration() == UY.isAccessDeclaration();
    }
  }
  {
    UnresolvedUsingValueDecl /*P*/ UX = dyn_cast_UnresolvedUsingValueDecl(X);
    if ((UX != null)) {
      UnresolvedUsingValueDecl /*P*/ UY = cast_UnresolvedUsingValueDecl(Y);
      return isSameQualifier(UX.getQualifier(), UY.getQualifier())
         && UX.isAccessDeclaration() == UY.isAccessDeclaration();
    }
  }
  {
    UnresolvedUsingTypenameDecl /*P*/ UX = dyn_cast_UnresolvedUsingTypenameDecl(X);
    if ((UX != null)) {
      return isSameQualifier(UX.getQualifier(), 
          cast_UnresolvedUsingTypenameDecl(Y).getQualifier());
    }
  }
  {
    
    // Namespace alias definitions with the same target match.
    NamespaceAliasDecl /*P*/ NAX = dyn_cast_NamespaceAliasDecl(X);
    if ((NAX != null)) {
      NamespaceAliasDecl /*P*/ NAY = cast_NamespaceAliasDecl(Y);
      return NAX.getNamespace().Equals(NAY.getNamespace());
    }
  }
  
  return false;
}


/// Find the declaration that should be merged into, given the declaration found
/// by name lookup. If we're merging an anonymous declaration within a typedef,
/// we need a matching typedef, and we merge with the type inside it.
//<editor-fold defaultstate="collapsed" desc="getDeclForMerging">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 2858,
 FQN="getDeclForMerging", NM="_ZL17getDeclForMergingPN5clang9NamedDeclEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZL17getDeclForMergingPN5clang9NamedDeclEb")
//</editor-fold>
public static NamedDecl /*P*/ getDeclForMerging(NamedDecl /*P*/ Found, 
                 boolean IsTypedefNameForLinkage) {
  if (!IsTypedefNameForLinkage) {
    return Found;
  }
  
  // If we found a typedef declaration that gives a name to some other
  // declaration, then we want that inner declaration. Declarations from
  // AST files are handled via ImportedTypedefNamesForLinkage.
  if (Found.isFromASTFile()) {
    return null;
  }
  {
    
    TypedefNameDecl /*P*/ TND = dyn_cast_TypedefNameDecl(Found);
    if ((TND != null)) {
      return TND.getAnonDeclWithTypedefName();
    }
  }
  
  return null;
}


/// Inherit the default template argument from \p From to \p To. Returns
/// \c false if there is no default template for \p From.
/*template <typename ParmDecl> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="inheritDefaultTemplateArgument">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 3097,
 FQN="inheritDefaultTemplateArgument", NM="Tpl__ZL30inheritDefaultTemplateArgumentRN5clang10ASTContextEPT_PNS_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=Tpl__ZL30inheritDefaultTemplateArgumentRN5clang10ASTContextEPT_PNS_4DeclE")
//</editor-fold>
public static </*typename*/ ParmDecl extends Common$TemplateParmDecl> boolean inheritDefaultTemplateArgument(final ASTContext /*&*/ Context, ParmDecl /*P*/ From, 
                              Decl /*P*/ ToD) {
  Common$TemplateParmDecl /*P*/ To = (Common$TemplateParmDecl)ToD;
  if (Native.$not(From.hasDefaultArgument())) {
    return false;
  }
  To.setInheritedDefaultArgument(Context, From);
  return true;
}

//<editor-fold defaultstate="collapsed" desc="inheritDefaultTemplateArguments">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 3106,
 FQN="inheritDefaultTemplateArguments", NM="_ZL31inheritDefaultTemplateArgumentsRN5clang10ASTContextEPNS_12TemplateDeclES3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=_ZL31inheritDefaultTemplateArgumentsRN5clang10ASTContextEPNS_12TemplateDeclES3_")
//</editor-fold>
public static void inheritDefaultTemplateArguments(final ASTContext /*&*/ Context, 
                               TemplateDecl /*P*/ From, 
                               TemplateDecl /*P*/ To) {
  TemplateParameterList /*P*/ FromTP = From.getTemplateParameters();
  TemplateParameterList /*P*/ ToTP = To.getTemplateParameters();
  assert (FromTP.size() == ToTP.size()) : "merged mismatched templates?";
  
  for (/*uint*/int I = 0, N = FromTP.size(); I != N; ++I) {
    NamedDecl /*P*/ FromParam = FromTP.getParam(N - I - 1);
    if (FromParam.isParameterPack()) {
      continue;
    }
    NamedDecl /*P*/ ToParam = ToTP.getParam(N - I - 1);
    {
      
      TemplateTypeParmDecl /*P*/ FTTP = dyn_cast_TemplateTypeParmDecl(FromParam);
      if ((FTTP != null)) {
        if (!inheritDefaultTemplateArgument(Context, FTTP, ToParam)) {
          break;
        }
      } else {
        NonTypeTemplateParmDecl /*P*/ FNTTP = dyn_cast_NonTypeTemplateParmDecl(FromParam);
        if ((FNTTP != null)) {
          if (!inheritDefaultTemplateArgument(Context, FNTTP, ToParam)) {
            break;
          }
        } else {
          if (!inheritDefaultTemplateArgument(Context, cast_TemplateTemplateParmDecl(FromParam), ToParam)) {
            break;
          }
        }
      }
    }
  }
}

/*template <typename DeclT, typename Fn> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="forAllLaterRedecls">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp", line = 3696,
 FQN="forAllLaterRedecls", NM="Tpl__ZL18forAllLaterRedeclsPT_T0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReaderDecl.cpp -nm=Tpl__ZL18forAllLaterRedeclsPT_T0_")
//</editor-fold>
public static </*typename*/ DeclT extends FunctionDecl, /*typename*/ Fn extends FunctionDecl2Void> void forAllLaterRedecls(DeclT /*P*/ D, Fn F) {
  F.$call(D);
  
  // Check whether we've already merged D into its redeclaration chain.
  // MostRecent may or may not be nullptr if D has not been merged. If
  // not, walk the merged redecl chain and see if it's there.
  Redeclarable /*P*/ MostRecent = (Redeclarable) D.getMostRecentDecl();
  boolean Found = false;
  for (Redeclarable /*P*/ Redecl = MostRecent; Native.$bool(Redecl) && !Found;
       Redecl = (Redeclarable) Redecl.getPreviousDecl())  {
    Found = (Native.$eq(Redecl, D));
  }
  
  // If this declaration is merged, apply the functor to all later decls.
  if (Found) {
    for (Redeclarable /*P*/ Redecl = MostRecent; Native.$noteq(Redecl, D);
         Redecl = (Redeclarable) Redecl.getPreviousDecl())  {
      F.$call((FunctionDecl)Redecl);
    }
  }
}

} // END OF class ASTReaderDeclStatics
