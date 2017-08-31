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

import static org.clank.support.Native.$AddrOf;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import org.clang.ast.*;
import static org.clang.ast.java.AstJavaFixedRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;

//<editor-fold defaultstate="collapsed" desc="static type ItaniumMangleStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=Tpl__ZL26isStreamCharSpecializationPKN5clang31ClassTemplateSpecializationDeclERAT__Kc;_ZL10isCharTypeN5clang8QualTypeE;_ZL10isTemplatePKN5clang9NamedDeclERPKNS_20TemplateArgumentListE;_ZL14isStdNamespacePKN5clang11DeclContextE;_ZL19isTypeSubstitutableN5clang10QualifiersEPKNS_4TypeE;_ZL20isCharSpecializationN5clang8QualTypeEPKc;_ZL22IgnoreLinkageSpecDeclsPKN5clang11DeclContextE;_ZL23mangleAArch64VectorBasePKN5clang11BuiltinTypeE;_ZL24isParenthesizedADLCalleePKN5clang8CallExprE;_ZL32hasMangledSubstitutionQualifiersN5clang8QualTypeE;_ZL5isStdPKN5clang13NamespaceDeclE;_ZN12_GLOBAL__N_1L11getStructorEPKN5clang12FunctionDeclE;_ZN12_GLOBAL__N_1L11getStructorEPKN5clang9NamedDeclE;_ZN12_GLOBAL__N_1L12UnknownArityE;_ZN12_GLOBAL__N_1L17GetLocalClassDeclEPKN5clang4DeclE;_ZN12_GLOBAL__N_1L23getEffectiveDeclContextEPKN5clang4DeclE;_ZN12_GLOBAL__N_1L23isLocalContainerContextEPKN5clang11DeclContextE;_ZN12_GLOBAL__N_1L25getEffectiveParentContextEPKN5clang11DeclContextE;_ZN12_GLOBAL__N_1L8isLambdaEPKN5clang9NamedDeclE; -static-type=ItaniumMangleStatics -package=org.clang.ast.impl")
//</editor-fold>
public final class ItaniumMangleStatics {


/// Retrieve the declaration context that should be used when mangling the given
/// declaration.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::getEffectiveDeclContext">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 48,
 FQN="(anonymous namespace)::getEffectiveDeclContext", NM="_ZN12_GLOBAL__N_1L23getEffectiveDeclContextEPKN5clang4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_1L23getEffectiveDeclContextEPKN5clang4DeclE")
//</editor-fold>
public static /*const*/ DeclContext /*P*/ getEffectiveDeclContext(/*const*/ Decl /*P*/ D) {
  {
    // The ABI assumes that lambda closure types that occur within 
    // default arguments live in the context of the function. However, due to
    // the way in which Clang parses and creates function declarations, this is
    // not the case: the lambda closure type ends up living in the context 
    // where the function itself resides, because the function declaration itself
    // had not yet been created. Fix the context here.
    /*const*/ CXXRecordDecl /*P*/ RD = dyn_cast_CXXRecordDecl(D);
    if ((RD != null)) {
      if (RD.isLambda()) {
        {
          ParmVarDecl /*P*/ ContextParam = dyn_cast_or_null_ParmVarDecl(RD.getLambdaContextDecl());
          if ((ContextParam != null)) {
            return ContextParam.getDeclContext();
          }
        }
      }
    }
  }
  {
    
    // Perform the same check for block literals.
    /*const*/ BlockDecl /*P*/ BD = dyn_cast_BlockDecl(D);
    if ((BD != null)) {
      {
        ParmVarDecl /*P*/ ContextParam = dyn_cast_or_null_ParmVarDecl(BD.getBlockManglingContextDecl());
        if ((ContextParam != null)) {
          return ContextParam.getDeclContext();
        }
      }
    }
  }
  
  /*const*/ DeclContext /*P*/ DC = D.getDeclContext$Const();
  if (isa_CapturedDecl(DC) || isa_OMPDeclareReductionDecl(DC)) {
    return getEffectiveDeclContext(cast_Decl(DC));
  }
  {
    
    /*const*/ VarDecl /*P*/ VD = dyn_cast_VarDecl(D);
    if ((VD != null)) {
      if (VD.isExternC()) {
        return VD.getASTContext().getTranslationUnitDecl();
      }
    }
  }
  {
    
    /*const*/ FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(D);
    if ((FD != null)) {
      if (FD.isExternC()) {
        return FD.getASTContext().getTranslationUnitDecl();
      }
    }
  }
  
  return DC.getRedeclContext$Const();
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::getEffectiveParentContext">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 85,
 FQN="(anonymous namespace)::getEffectiveParentContext", NM="_ZN12_GLOBAL__N_1L25getEffectiveParentContextEPKN5clang11DeclContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_1L25getEffectiveParentContextEPKN5clang11DeclContextE")
//</editor-fold>
public static /*const*/ DeclContext /*P*/ getEffectiveParentContext(/*const*/ DeclContext /*P*/ DC) {
  return getEffectiveDeclContext(cast_Decl(DC));
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::isLocalContainerContext">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 89,
 FQN="(anonymous namespace)::isLocalContainerContext", NM="_ZN12_GLOBAL__N_1L23isLocalContainerContextEPKN5clang11DeclContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_1L23isLocalContainerContextEPKN5clang11DeclContextE")
//</editor-fold>
public static boolean isLocalContainerContext(/*const*/ DeclContext /*P*/ DC) {
  return isa_FunctionDecl(DC) || isa_ObjCMethodDecl(DC) || isa_BlockDecl(DC);
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::GetLocalClassDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 93,
 FQN="(anonymous namespace)::GetLocalClassDecl", NM="_ZN12_GLOBAL__N_1L17GetLocalClassDeclEPKN5clang4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_1L17GetLocalClassDeclEPKN5clang4DeclE")
//</editor-fold>
public static /*const*/ RecordDecl /*P*/ GetLocalClassDecl(/*const*/ Decl /*P*/ D) {
  /*const*/ DeclContext /*P*/ DC = getEffectiveDeclContext(D);
  while (!DC.isNamespace() && !DC.isTranslationUnit()) {
    if (isLocalContainerContext(DC)) {
      return dyn_cast_RecordDecl(D);
    }
    D = cast_Decl(DC);
    DC = getEffectiveDeclContext(D);
  }
  return null;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::getStructor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 104,
 FQN="(anonymous namespace)::getStructor", NM="_ZN12_GLOBAL__N_1L11getStructorEPKN5clang12FunctionDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_1L11getStructorEPKN5clang12FunctionDeclE")
//</editor-fold>
public static /*const*/ FunctionDecl /*P*/ getStructor(/*const*/ FunctionDecl /*P*/ fn) {
  {
    /*const*/ FunctionTemplateDecl /*P*/ ftd = fn.getPrimaryTemplate();
    if ((ftd != null)) {
      return ftd.getTemplatedDecl();
    }
  }
  
  return fn;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::getStructor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 111,
 FQN="(anonymous namespace)::getStructor", NM="_ZN12_GLOBAL__N_1L11getStructorEPKN5clang9NamedDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_1L11getStructorEPKN5clang9NamedDeclE")
//</editor-fold>
public static /*const*/ NamedDecl /*P*/ getStructor(/*const*/ NamedDecl /*P*/ decl) {
  /*const*/ FunctionDecl /*P*/ fn = dyn_cast_or_null_FunctionDecl(decl);
  return ((fn != null) ? getStructor(fn) : decl);
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::isLambda">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 116,
 FQN="(anonymous namespace)::isLambda", NM="_ZN12_GLOBAL__N_1L8isLambdaEPKN5clang9NamedDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_1L8isLambdaEPKN5clang9NamedDeclE")
//</editor-fold>
public static boolean isLambda(/*const*/ NamedDecl /*P*/ ND) {
  /*const*/ CXXRecordDecl /*P*/ Record = dyn_cast_CXXRecordDecl(ND);
  if (!(Record != null)) {
    return false;
  }
  
  return Record.isLambda();
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UnknownArity">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 124,
 FQN="(anonymous namespace)::UnknownArity", NM="_ZN12_GLOBAL__N_1L12UnknownArityE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZN12_GLOBAL__N_1L12UnknownArityE")
//</editor-fold>
public static /*const*//*uint*/int UnknownArity = ~0/*U*/;
//<editor-fold defaultstate="collapsed" desc="IgnoreLinkageSpecDecls">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 746,
 FQN="IgnoreLinkageSpecDecls", NM="_ZL22IgnoreLinkageSpecDeclsPKN5clang11DeclContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZL22IgnoreLinkageSpecDeclsPKN5clang11DeclContextE")
//</editor-fold>
public static /*const*/ DeclContext /*P*/ IgnoreLinkageSpecDecls(/*const*/ DeclContext /*P*/ DC) {
  while (isa_LinkageSpecDecl(DC)) {
    DC = getEffectiveParentContext(DC);
  }
  
  return DC;
}


/// Return whether a given namespace is the 'std' namespace.
//<editor-fold defaultstate="collapsed" desc="isStd">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 755,
 FQN="isStd", NM="_ZL5isStdPKN5clang13NamespaceDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZL5isStdPKN5clang13NamespaceDeclE")
//</editor-fold>
public static boolean isStd(/*const*/ NamespaceDecl /*P*/ NS) {
  if (!IgnoreLinkageSpecDecls(getEffectiveParentContext(NS)).
      isTranslationUnit()) {
    return false;
  }
  
  /*const*/ IdentifierInfo /*P*/ II = NS.getOriginalNamespace$Const().getIdentifier();
  return (II != null) && II.isStr(/*KEEP_STR*/"std");
}


// isStdNamespace - Return whether a given decl context is a toplevel 'std'
// namespace.
//<editor-fold defaultstate="collapsed" desc="isStdNamespace">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 766,
 FQN="isStdNamespace", NM="_ZL14isStdNamespacePKN5clang11DeclContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZL14isStdNamespacePKN5clang11DeclContextE")
//</editor-fold>
public static boolean isStdNamespace(/*const*/ DeclContext /*P*/ DC) {
  if (!DC.isNamespace()) {
    return false;
  }
  
  return isStd(cast_NamespaceDecl(DC));
}

//<editor-fold defaultstate="collapsed" desc="isTemplate">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 773,
 FQN="isTemplate", NM="_ZL10isTemplatePKN5clang9NamedDeclERPKNS_20TemplateArgumentListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZL10isTemplatePKN5clang9NamedDeclERPKNS_20TemplateArgumentListE")
//</editor-fold>
public static /*const*/ TemplateDecl /*P*/ isTemplate(/*const*/ NamedDecl /*P*/ ND, final type$ref</*const*/ TemplateArgumentList /*P*/ /*&*/> TemplateArgs) {
  {
    // Check if we have a function template.
    /*const*/ FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(ND);
    if ((FD != null)) {
      {
        /*const*/ TemplateDecl /*P*/ TD = FD.getPrimaryTemplate();
        if ((TD != null)) {
          TemplateArgs.$set(FD.getTemplateSpecializationArgs());
          return TD;
        }
      }
    }
  }
  {
    
    // Check if we have a class template.
    /*const*/ ClassTemplateSpecializationDecl /*P*/ Spec = dyn_cast_ClassTemplateSpecializationDecl(ND);
    if ((Spec != null)) {
      TemplateArgs.$set($AddrOf(Spec.getTemplateArgs()));
      return Spec.getSpecializedTemplate();
    }
  }
  {
    
    // Check if we have a variable template.
    /*const*/ VarTemplateSpecializationDecl /*P*/ Spec = dyn_cast_VarTemplateSpecializationDecl(ND);
    if ((Spec != null)) {
      TemplateArgs.$set($AddrOf(Spec.getTemplateArgs()));
      return Spec.getSpecializedTemplate();
    }
  }
  
  return null;
}

//<editor-fold defaultstate="collapsed" desc="isTypeSubstitutable">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 2180,
 FQN="isTypeSubstitutable", NM="_ZL19isTypeSubstitutableN5clang10QualifiersEPKNS_4TypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZL19isTypeSubstitutableN5clang10QualifiersEPKNS_4TypeE")
//</editor-fold>
public static boolean isTypeSubstitutable(Qualifiers Quals, /*const*/ Type /*P*/ Ty) {
  if (Quals.$bool()) {
    return true;
  }
  if (Ty.isSpecificBuiltinType(BuiltinType.Kind.ObjCSel.getValue())) {
    return true;
  }
  if (Ty.isOpenCLSpecificType()) {
    return true;
  }
  if (Ty.isBuiltinType()) {
    return false;
  }
  
  return true;
}

//<editor-fold defaultstate="collapsed" desc="mangleAArch64VectorBase">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 2770,
 FQN="mangleAArch64VectorBase", NM="_ZL23mangleAArch64VectorBasePKN5clang11BuiltinTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZL23mangleAArch64VectorBasePKN5clang11BuiltinTypeE")
//</editor-fold>
public static StringRef mangleAArch64VectorBase(/*const*/ BuiltinType /*P*/ EltType) {
  switch (EltType.getKind()) {
   case SChar:
    return new StringRef(/*KEEP_STR*/"Int8");
   case Short:
    return new StringRef(/*KEEP_STR*/"Int16");
   case Int:
    return new StringRef(/*KEEP_STR*/"Int32");
   case Long:
   case LongLong:
    return new StringRef(/*KEEP_STR*/"Int64");
   case UChar:
    return new StringRef(/*KEEP_STR*/"Uint8");
   case UShort:
    return new StringRef(/*KEEP_STR*/"Uint16");
   case UInt:
    return new StringRef(/*KEEP_STR*/"Uint32");
   case ULong:
   case ULongLong:
    return new StringRef(/*KEEP_STR*/"Uint64");
   case Half:
    return new StringRef(/*KEEP_STR*/"Float16");
   case Float:
    return new StringRef(/*KEEP_STR*/"Float32");
   case Double:
    return new StringRef(/*KEEP_STR*/"Float64");
   default:
    throw new llvm_unreachable("Unexpected vector element base type");
  }
}


/// Look at the callee of the given call expression and determine if
/// it's a parenthesized id-expression which would have triggered ADL
/// otherwise.
//<editor-fold defaultstate="collapsed" desc="isParenthesizedADLCallee">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 3129,
 FQN="isParenthesizedADLCallee", NM="_ZL24isParenthesizedADLCalleePKN5clang8CallExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZL24isParenthesizedADLCalleePKN5clang8CallExprE")
//</editor-fold>
public static boolean isParenthesizedADLCallee(/*const*/ CallExpr /*P*/ call) {
  /*const*/ Expr /*P*/ callee = call.getCallee$Const();
  /*const*/ Expr /*P*/ fn = callee.IgnoreParens$Const();
  
  // Must be parenthesized.  IgnoreParens() skips __extension__ nodes,
  // too, but for those to appear in the callee, it would have to be
  // parenthesized.
  if (callee == fn) {
    return false;
  }
  
  // Must be an unresolved lookup.
  /*const*/ UnresolvedLookupExpr /*P*/ lookup = dyn_cast_UnresolvedLookupExpr(fn);
  if (!(lookup != null)) {
    return false;
  }
  assert (!lookup.requiresADL());
  
  // Must be an unqualified lookup.
  if ((lookup.getQualifier() != null)) {
    return false;
  }
  
  // Must not have found a class member.  Note that if one is a class
  // member, they're all class members.
  if ($greater_uint(lookup.getNumDecls(), 0)
     && (lookup.decls_begin().$star()).isCXXClassMember()) {
    return false;
  }
  
  // Otherwise, ADL would have been triggered.
  return true;
}


/// Determine whether the given type has any qualifiers that are relevant for
/// substitutions.
//<editor-fold defaultstate="collapsed" desc="hasMangledSubstitutionQualifiers">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 4215,
 FQN="hasMangledSubstitutionQualifiers", NM="_ZL32hasMangledSubstitutionQualifiersN5clang8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZL32hasMangledSubstitutionQualifiersN5clang8QualTypeE")
//</editor-fold>
public static boolean hasMangledSubstitutionQualifiers(QualType T) {
  Qualifiers Qs = T.getQualifiers();
  return (Qs.getCVRQualifiers() != 0) || Qs.hasAddressSpace();
}

//<editor-fold defaultstate="collapsed" desc="isCharType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 4252,
 FQN="isCharType", NM="_ZL10isCharTypeN5clang8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZL10isCharTypeN5clang8QualTypeE")
//</editor-fold>
public static boolean isCharType(QualType T) {
  if (T.isNull()) {
    return false;
  }
  
  return T.$arrow().isSpecificBuiltinType(BuiltinType.Kind.Char_S.getValue())
     || T.$arrow().isSpecificBuiltinType(BuiltinType.Kind.Char_U.getValue());
}


/// Returns whether a given type is a template specialization of a given name
/// with a single argument of type char.
//<editor-fold defaultstate="collapsed" desc="isCharSpecialization">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 4262,
 FQN="isCharSpecialization", NM="_ZL20isCharSpecializationN5clang8QualTypeEPKc",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=_ZL20isCharSpecializationN5clang8QualTypeEPKc")
//</editor-fold>
public static boolean isCharSpecialization(QualType T, /*const*/char$ptr/*char P*/ Name) {
  if (T.isNull()) {
    return false;
  }
  
  /*const*/ RecordType /*P*/ RT = T.$arrow().<RecordType>getAs$RecordType();
  if (!(RT != null)) {
    return false;
  }
  
  /*const*/ ClassTemplateSpecializationDecl /*P*/ SD = dyn_cast_ClassTemplateSpecializationDecl(RT.getDecl());
  if (!(SD != null)) {
    return false;
  }
  if (!isStdNamespace(getEffectiveDeclContext(SD))) {
    return false;
  }
  
  final /*const*/ TemplateArgumentList /*&*/ TemplateArgs = SD.getTemplateArgs();
  if (TemplateArgs.size() != 1) {
    return false;
  }
  if (!isCharType(TemplateArgs.$at(0).getAsType())) {
    return false;
  }
  
  return $eq_StringRef(SD.getIdentifier().getName(), /*STRINGREF_STR*/Name);
}

/*template <std::size_t StrLen> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="isStreamCharSpecialization">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp", line = 4289,
 FQN="isStreamCharSpecialization", NM="Tpl__ZL26isStreamCharSpecializationPKN5clang31ClassTemplateSpecializationDeclERAT__Kc",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ItaniumMangle.cpp -nm=Tpl__ZL26isStreamCharSpecializationPKN5clang31ClassTemplateSpecializationDeclERAT__Kc")
//</editor-fold>
public static /*<uintint StrLen>*/ boolean isStreamCharSpecialization(/*const*/ ClassTemplateSpecializationDecl /*P*/ SD, 
                          final String Str) {
  if (Native.$not(SD.getIdentifier().isStr(Str))) {
    return false;
  }
  
  final /*const*/ TemplateArgumentList /*&*/ TemplateArgs = SD.getTemplateArgs();
  if (TemplateArgs.size() != 2) {
    return false;
  }
  if (!isCharType(TemplateArgs.$at(0).getAsType())) {
    return false;
  }
  if (!isCharSpecialization(TemplateArgs.$at(1).getAsType(), $("char_traits"))) {
    return false;
  }
  
  return true;
}

} // END OF class ItaniumMangleStatics
