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
package org.clang.rewrite.frontend.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.rewrite.frontend.impl.*;
import org.clang.ast.*;


//<editor-fold defaultstate="collapsed" desc="static type RewriteModernObjCStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZL12IsHeaderFileRKSs;_ZL13Write_class_tPN5clang10ASTContextERSsN4llvm9StringRefEPKNS_17ObjCInterfaceDeclEb;_ZL16Write_category_tRN12_GLOBAL__N_117RewriteModernObjCEPN5clang10ASTContextERSsPNS2_16ObjCCategoryDeclEPNS2_17ObjCInterfaceDeclEN4llvm8ArrayRefIPNS2_14ObjCMethodDeclEEESE_NSB_IPNS2_16ObjCProtocolDeclEEENSB_IPNS2_16ObjCPropertyDeclEEE;_ZL18scanToNextArgumentRPKc;_ZL19Write_IvarOffsetVarRN12_GLOBAL__N_117RewriteModernObjCEPN5clang10ASTContextERSsN4llvm8ArrayRefIPNS2_12ObjCIvarDeclEEEPNS2_17ObjCInterfaceDeclE;_ZL19Write_RethrowObjectRSs;_ZL19scanForProtocolRefsPKcS0_RS0_S1_;_ZL21BuildUniqueMethodNameRSsPN5clang14ObjCMethodDeclE;_ZL21WriteInternalIvarNamePKN5clang17ObjCInterfaceDeclEPNS_12ObjCIvarDeclERSs;_ZL25getFunctionSourceLocationRN12_GLOBAL__N_117RewriteModernObjCEPN5clang12FunctionDeclE;_ZL25hasObjCExceptionAttributeRN5clang10ASTContextEPKNS_17ObjCInterfaceDeclE;_ZL26RewriteOneForwardClassDeclPN5clang17ObjCInterfaceDeclERSs;_ZL27Write__ivar_list_t_TypeDeclRSsj;_ZL27Write__prop_list_t_TypeDeclRSsj;_ZL28Write_method_list_t_TypeDeclRSsj;_ZL29Write__class_ro_t_initializerPN5clang10ASTContextERSsjRKSsS4_N4llvm8ArrayRefIPNS_14ObjCMethodDeclEEENS6_IPNS_16ObjCProtocolDeclEEENS6_IPNS_12ObjCIvarDeclEEENS6_IPNS_16ObjCPropertyDeclEEENS5_9StringRefESJ_;_ZL29Write_prop_list_t_initializerRN12_GLOBAL__N_117RewriteModernObjCEPN5clang10ASTContextERSsN4llvm8ArrayRefIPNS2_16ObjCPropertyDeclEEEPKNS2_4DeclENS6_9StringRefESE_;_ZL30Write__ivar_list_t_initializerRN12_GLOBAL__N_117RewriteModernObjCEPN5clang10ASTContextERSsN4llvm8ArrayRefIPNS2_12ObjCIvarDeclEEENS6_9StringRefEPNS2_17ObjCInterfaceDeclE;_ZL30Write_protocol_list_t_TypeDeclRSsl;_ZL31HasLocalVariableExternalStoragePN5clang9ValueDeclE;_ZL31WriteModernMetadataDeclarationsPN5clang10ASTContextERSs;_ZL31Write_method_list_t_initializerRN12_GLOBAL__N_117RewriteModernObjCEPN5clang10ASTContextERSsN4llvm8ArrayRefIPNS2_14ObjCMethodDeclEEENS6_9StringRefESB_b;_ZL31Write_protocol_list_initializerPN5clang10ASTContextERSsN4llvm8ArrayRefIPNS_16ObjCProtocolDeclEEENS3_9StringRefES8_;_ZL32mustSynthesizeSetterGetterMethodPN5clang22ObjCImplementationDeclEPNS_16ObjCPropertyDeclEb;_ZL36Write_ProtocolExprReferencedMetadataPN5clang10ASTContextEPNS_16ObjCProtocolDeclERSs;_ZL38Write__extendedMethodTypes_initializerRN12_GLOBAL__N_117RewriteModernObjCEPN5clang10ASTContextERSsN4llvm8ArrayRefIPNS2_14ObjCMethodDeclEEENS6_9StringRefESB_; -static-type=RewriteModernObjCStatics -package=org.clang.rewrite.frontend.impl")
//</editor-fold>
public final class RewriteModernObjCStatics {

//<editor-fold defaultstate="collapsed" desc="IsHeaderFile">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 627,
 FQN="IsHeaderFile", NM="_ZL12IsHeaderFileRKSs",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZL12IsHeaderFileRKSs")
//</editor-fold>
public static boolean IsHeaderFile(/*const*/std.string/*&*/ Filename) {
  /*size_t*/int DotPos = Filename.rfind($$DOT);
  if (DotPos == std.string.npos) {
    // no file extension
    return false;
  }
  
  std.string Ext = new std.string(Filename.begin$Const().$add(DotPos).$add(1), Filename.end$Const());
  // C header: .h
  // C++ header: .hh or .H;
  return $eq_string$C_T$C$P(Ext, /*KEEP_STR*/"h") || $eq_string$C_T$C$P(Ext, /*KEEP_STR*/"hh") || $eq_string$C_T$C$P(Ext, /*KEEP_STR*/"H");
}

//<editor-fold defaultstate="collapsed" desc="WriteInternalIvarName">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 830,
 FQN="WriteInternalIvarName", NM="_ZL21WriteInternalIvarNamePKN5clang17ObjCInterfaceDeclEPNS_12ObjCIvarDeclERSs",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZL21WriteInternalIvarNamePKN5clang17ObjCInterfaceDeclEPNS_12ObjCIvarDeclERSs")
//</editor-fold>
public static void WriteInternalIvarName(/*const*/ ObjCInterfaceDecl /*P*/ IDecl, 
                     ObjCIvarDecl /*P*/ IvarDecl, std.string/*&*/ Result) {
  Result.$addassign_T$C$P(/*KEEP_STR*/"OBJC_IVAR_$_");
  $addassign_string_StringRef(Result, IDecl.getName());
  Result.$addassign_T$C$P(/*KEEP_STR*/"$");
  $addassign_string_StringRef(Result, IvarDecl.getName());
}


/// mustSynthesizeSetterGetterMethod - returns true if setter or getter has not
/// been found in the class implementation. In this case, it must be synthesized.
//<editor-fold defaultstate="collapsed" desc="mustSynthesizeSetterGetterMethod">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 910,
 FQN="mustSynthesizeSetterGetterMethod", NM="_ZL32mustSynthesizeSetterGetterMethodPN5clang22ObjCImplementationDeclEPNS_16ObjCPropertyDeclEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZL32mustSynthesizeSetterGetterMethodPN5clang22ObjCImplementationDeclEPNS_16ObjCPropertyDeclEb")
//</editor-fold>
public static boolean mustSynthesizeSetterGetterMethod(ObjCImplementationDecl /*P*/ IMP, 
                                ObjCPropertyDecl /*P*/ PD, 
                                boolean getter) {
  return getter ? !(IMP.getInstanceMethod(PD.getGetterName()) != null) : !(IMP.getInstanceMethod(PD.getSetterName()) != null);
}

//<editor-fold defaultstate="collapsed" desc="RewriteOneForwardClassDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 1045,
 FQN="RewriteOneForwardClassDecl", NM="_ZL26RewriteOneForwardClassDeclPN5clang17ObjCInterfaceDeclERSs",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZL26RewriteOneForwardClassDeclPN5clang17ObjCInterfaceDeclERSs")
//</editor-fold>
public static void RewriteOneForwardClassDecl(ObjCInterfaceDecl /*P*/ ForwardDecl, 
                          std.string/*&*/ typedefString) {
  typedefString.$addassign_T$C$P(/*KEEP_STR*/"\n#ifndef _REWRITER_typedef_");
  typedefString.$addassign(ForwardDecl.getNameAsString());
  typedefString.$addassign_T$C$P(/*KEEP_STR*/"\n");
  typedefString.$addassign_T$C$P(/*KEEP_STR*/"#define _REWRITER_typedef_");
  typedefString.$addassign(ForwardDecl.getNameAsString());
  typedefString.$addassign_T$C$P(/*KEEP_STR*/"\n");
  typedefString.$addassign_T$C$P(/*KEEP_STR*/"typedef struct objc_object ");
  typedefString.$addassign(ForwardDecl.getNameAsString());
  // typedef struct { } _objc_exc_Classname;
  typedefString.$addassign_T$C$P(/*KEEP_STR*/";\ntypedef struct {} _objc_exc_");
  typedefString.$addassign(ForwardDecl.getNameAsString());
  typedefString.$addassign_T$C$P(/*KEEP_STR*/";\n#endif\n");
}

//<editor-fold defaultstate="collapsed" desc="Write_RethrowObject">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 1847,
 FQN="Write_RethrowObject", NM="_ZL19Write_RethrowObjectRSs",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZL19Write_RethrowObjectRSs")
//</editor-fold>
public static void Write_RethrowObject(std.string/*&*/ buf) {
  buf.$addassign_T$C$P(/*KEEP_STR*/"{ struct _FIN { _FIN(id reth) : rethrow(reth) {}\n");
  buf.$addassign_T$C$P(/*KEEP_STR*/"\t~_FIN() { if (rethrow) objc_exception_throw(rethrow); }\n");
  buf.$addassign_T$C$P(/*KEEP_STR*/"\tid rethrow;\n");
  buf.$addassign_T$C$P(/*KEEP_STR*/"\t} _fin_force_rethow(_rethrow);");
}

//<editor-fold defaultstate="collapsed" desc="scanForProtocolRefs">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 2116,
 FQN="scanForProtocolRefs", NM="_ZL19scanForProtocolRefsPKcS0_RS0_S1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZL19scanForProtocolRefsPKcS0_RS0_S1_")
//</editor-fold>
public static boolean scanForProtocolRefs(/*const*/char$ptr/*char P*/ startBuf, /*const*/char$ptr/*char P*/ endBuf, 
                   char$ptr/*const char P &*/ startRef, char$ptr/*const char P &*/ endRef) {
  while (startBuf.$less(endBuf)) {
    if (startBuf.$star() == $$LT) {
      startRef = $tryClone(startBuf); // mark the start.
    }
    if (startBuf.$star() == $$GT) {
      if ((startRef != null) && startRef.$star() == $$LT) {
        endRef = $tryClone(startBuf); // mark the end.
        return true;
      }
      return false;
    }
    startBuf.$postInc();
  }
  return false;
}

//<editor-fold defaultstate="collapsed" desc="scanToNextArgument">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 2133,
 FQN="scanToNextArgument", NM="_ZL18scanToNextArgumentRPKc",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZL18scanToNextArgumentRPKc")
//</editor-fold>
public static void scanToNextArgument(char$ptr/*const char P &*/ argRef) {
  int angle = 0;
  while (argRef.$star() != $$RPAREN && (argRef.$star() != $$COMMA || angle > 0)) {
    if (argRef.$star() == $$LT) {
      angle++;
    } else if (argRef.$star() == $$GT) {
      angle--;
    }
    argRef.$postInc();
  }
  assert (angle == 0) : "scanToNextArgument - bad protocol type syntax";
}


/// getFunctionSourceLocation - returns start location of a function
/// definition. Complication arises when function has declared as
/// extern "C" or extern "C" {...}
//<editor-fold defaultstate="collapsed" desc="getFunctionSourceLocation">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 3044,
 FQN="getFunctionSourceLocation", NM="_ZL25getFunctionSourceLocationRN12_GLOBAL__N_117RewriteModernObjCEPN5clang12FunctionDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZL25getFunctionSourceLocationRN12_GLOBAL__N_117RewriteModernObjCEPN5clang12FunctionDeclE")
//</editor-fold>
public static SourceLocation getFunctionSourceLocation(RewriteModernObjC /*&*/ R, 
                         FunctionDecl /*P*/ FD) {
  if (FD.isExternC() && !FD.isMain()) {
    /*const*/ DeclContext /*P*/ DC = FD.getDeclContext();
    {
      /*const*/ LinkageSpecDecl /*P*/ LSD = dyn_cast(LinkageSpecDecl.class, DC);
      if ((LSD != null)) {
        // if it is extern "C" {...}, return function decl's own location.
        if (!LSD.getRBraceLoc().isValid()) {
          return LSD.getExternLoc();
        }
      }
    }
  }
  if (FD.getStorageClass() != StorageClass.SC_None) {
    R.RewriteBlockLiteralFunctionDecl(FD);
  }
  return FD.getTypeSpecStartLoc();
}

//<editor-fold defaultstate="collapsed" desc="HasLocalVariableExternalStorage">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 4043,
 FQN="HasLocalVariableExternalStorage", NM="_ZL31HasLocalVariableExternalStoragePN5clang9ValueDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZL31HasLocalVariableExternalStoragePN5clang9ValueDeclE")
//</editor-fold>
public static boolean HasLocalVariableExternalStorage(ValueDecl /*P*/ VD) {
  {
    VarDecl /*P*/ Var = dyn_cast(VarDecl.class, VD);
    if ((Var != null)) {
      return (Var.isFunctionOrMethodVarDecl() && !Var.hasLocalStorage());
    }
  }
  return false;
}

//<editor-fold defaultstate="collapsed" desc="BuildUniqueMethodName">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 4450,
 FQN="BuildUniqueMethodName", NM="_ZL21BuildUniqueMethodNameRSsPN5clang14ObjCMethodDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZL21BuildUniqueMethodNameRSsPN5clang14ObjCMethodDeclE")
//</editor-fold>
public static void BuildUniqueMethodName(std.string/*&*/ Name, 
                     ObjCMethodDecl /*P*/ MD) {
  ObjCInterfaceDecl /*P*/ IFace = MD.getClassInterface();
  Name.$assignMove(IFace.getName().$string());
  Name.$addassign($add_T$C$P_string(/*KEEP_STR*/"__", MD.getSelector().getAsString()));
  // Convert colons to underscores.
  /*size_t*/int loc = 0;
  while ((loc = Name.find(/*KEEP_STR*/":", loc)) != std.string.npos) {
    Name.replace(loc, 1, $UNDERSCORE);
  }
}


/// Write_ProtocolExprReferencedMetadata - This routine writer out the
/// protocol reference symbols in the for of:
/// struct _protocol_t *PROTOCOL_REF = &PROTOCOL_METADATA.
//<editor-fold defaultstate="collapsed" desc="Write_ProtocolExprReferencedMetadata">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 5825,
 FQN="Write_ProtocolExprReferencedMetadata", NM="_ZL36Write_ProtocolExprReferencedMetadataPN5clang10ASTContextEPNS_16ObjCProtocolDeclERSs",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZL36Write_ProtocolExprReferencedMetadataPN5clang10ASTContextEPNS_16ObjCProtocolDeclERSs")
//</editor-fold>
public static void Write_ProtocolExprReferencedMetadata(ASTContext /*P*/ Context, 
                                    ObjCProtocolDecl /*P*/ PDecl, 
                                    std.string/*&*/ Result) {
  // Also output .objc_protorefs$B section and its meta-data.
  if (Context.getLangOpts().MicrosoftExt) {
    Result.$addassign_T$C$P(/*KEEP_STR*/"static ");
  }
  Result.$addassign_T$C$P(/*KEEP_STR*/"struct _protocol_t *");
  Result.$addassign_T$C$P(/*KEEP_STR*/"_OBJC_PROTOCOL_REFERENCE_$_");
  Result.$addassign(PDecl.getNameAsString());
  Result.$addassign_T$C$P(/*KEEP_STR*/" = &");
  Result.$addassign_T$C$P(/*KEEP_STR*/"_OBJC_PROTOCOL_");
  Result.$addassign(PDecl.getNameAsString());
  Result.$addassign_T$C$P(/*KEEP_STR*/";\n");
}


/// WriteModernMetadataDeclarations - Writes out metadata declarations for modern ABI.
/// struct _prop_t {
///   const char *name;
///   char *attributes;
/// }

/// struct _prop_list_t {
///   uint32_t entsize;      // sizeof(struct _prop_t)
///   uint32_t count_of_properties;
///   struct _prop_t prop_list[count_of_properties];
/// }

/// struct _protocol_t;

/// struct _protocol_list_t {
///   long protocol_count;   // Note, this is 32/64 bit
///   struct _protocol_t * protocol_list[protocol_count];
/// }

/// struct _objc_method {
///   SEL _cmd;
///   const char *method_type;
///   char *_imp;
/// }

/// struct _method_list_t {
///   uint32_t entsize;  // sizeof(struct _objc_method)
///   uint32_t method_count;
///   struct _objc_method method_list[method_count];
/// }

/// struct _protocol_t {
///   id isa;  // NULL
///   const char *protocol_name;
///   const struct _protocol_list_t * protocol_list; // super protocols
///   const struct method_list_t *instance_methods;
///   const struct method_list_t *class_methods;
///   const struct method_list_t *optionalInstanceMethods;
///   const struct method_list_t *optionalClassMethods;
///   const struct _prop_list_t * properties;
///   const uint32_t size;  // sizeof(struct _protocol_t)
///   const uint32_t flags;  // = 0
///   const char ** extendedMethodTypes;
/// }

/// struct _ivar_t {
///   unsigned long int *offset;  // pointer to ivar offset location
///   const char *name;
///   const char *type;
///   uint32_t alignment;
///   uint32_t size;
/// }

/// struct _ivar_list_t {
///   uint32 entsize;  // sizeof(struct _ivar_t)
///   uint32 count;
///   struct _ivar_t list[count];
/// }

/// struct _class_ro_t {
///   uint32_t flags;
///   uint32_t instanceStart;
///   uint32_t instanceSize;
///   uint32_t reserved;  // only when building for 64bit targets
///   const uint8_t *ivarLayout;
///   const char *name;
///   const struct _method_list_t *baseMethods;
///   const struct _protocol_list_t *baseProtocols;
///   const struct _ivar_list_t *ivars;
///   const uint8_t *weakIvarLayout;
///   const struct _prop_list_t *properties;
/// }

/// struct _class_t {
///   struct _class_t *isa;
///   struct _class_t *superclass;
///   void *cache;
///   IMP *vtable;
///   struct _class_ro_t *ro;
/// }

/// struct _category_t {
///   const char *name;
///   struct _class_t *cls;
///   const struct _method_list_t *instance_methods;
///   const struct _method_list_t *class_methods;
///   const struct _protocol_list_t *protocols;
///   const struct _prop_list_t *properties;
/// }

/// MessageRefTy - LLVM for:
/// struct _message_ref_t {
///   IMP messenger;
///   SEL name;
/// };

/// SuperMessageRefTy - LLVM for:
/// struct _super_message_ref_t {
///   SUPER_IMP messenger;
///   SEL name;
/// };
//<editor-fold defaultstate="collapsed" desc="WriteModernMetadataDeclarations">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 6191,
 FQN="WriteModernMetadataDeclarations", NM="_ZL31WriteModernMetadataDeclarationsPN5clang10ASTContextERSs",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZL31WriteModernMetadataDeclarationsPN5clang10ASTContextERSs")
//</editor-fold>
public static void WriteModernMetadataDeclarations(ASTContext /*P*/ Context, std.string/*&*/ Result) {
  if (WriteModernMetadataDeclarations$$.meta_data_declared) {
    return;
  }
  
  Result.$addassign_T$C$P(/*KEEP_STR*/"\nstruct _prop_t {\n");
  Result.$addassign_T$C$P(/*KEEP_STR*/"\tconst char *name;\n");
  Result.$addassign_T$C$P(/*KEEP_STR*/"\tconst char *attributes;\n");
  Result.$addassign_T$C$P(/*KEEP_STR*/"};\n");
  
  Result.$addassign_T$C$P(/*KEEP_STR*/"\nstruct _protocol_t;\n");
  
  Result.$addassign_T$C$P(/*KEEP_STR*/"\nstruct _objc_method {\n");
  Result.$addassign_T$C$P(/*KEEP_STR*/"\tstruct objc_selector * _cmd;\n");
  Result.$addassign_T$C$P(/*KEEP_STR*/"\tconst char *method_type;\n");
  Result.$addassign_T$C$P(/*KEEP_STR*/"\tvoid  *_imp;\n");
  Result.$addassign_T$C$P(/*KEEP_STR*/"};\n");
  
  Result.$addassign_T$C$P(/*KEEP_STR*/"\nstruct _protocol_t {\n");
  Result.$addassign_T$C$P(/*KEEP_STR*/"\tvoid * isa;  // NULL\n");
  Result.$addassign_T$C$P(/*KEEP_STR*/"\tconst char *protocol_name;\n");
  Result.$addassign_T$C$P(/*KEEP_STR*/"\tconst struct _protocol_list_t * protocol_list; // super protocols\n");
  Result.$addassign_T$C$P(/*KEEP_STR*/"\tconst struct method_list_t *instance_methods;\n");
  Result.$addassign_T$C$P(/*KEEP_STR*/"\tconst struct method_list_t *class_methods;\n");
  Result.$addassign_T$C$P(/*KEEP_STR*/"\tconst struct method_list_t *optionalInstanceMethods;\n");
  Result.$addassign_T$C$P(/*KEEP_STR*/"\tconst struct method_list_t *optionalClassMethods;\n");
  Result.$addassign_T$C$P(/*KEEP_STR*/"\tconst struct _prop_list_t * properties;\n");
  Result.$addassign_T$C$P(/*KEEP_STR*/"\tconst unsigned int size;  // sizeof(struct _protocol_t)\n");
  Result.$addassign_T$C$P(/*KEEP_STR*/"\tconst unsigned int flags;  // = 0\n");
  Result.$addassign_T$C$P(/*KEEP_STR*/"\tconst char ** extendedMethodTypes;\n");
  Result.$addassign_T$C$P(/*KEEP_STR*/"};\n");
  
  Result.$addassign_T$C$P(/*KEEP_STR*/"\nstruct _ivar_t {\n");
  Result.$addassign_T$C$P(/*KEEP_STR*/"\tunsigned long int *offset;  // pointer to ivar offset location\n");
  Result.$addassign_T$C$P(/*KEEP_STR*/"\tconst char *name;\n");
  Result.$addassign_T$C$P(/*KEEP_STR*/"\tconst char *type;\n");
  Result.$addassign_T$C$P(/*KEEP_STR*/"\tunsigned int alignment;\n");
  Result.$addassign_T$C$P(/*KEEP_STR*/"\tunsigned int  size;\n");
  Result.$addassign_T$C$P(/*KEEP_STR*/"};\n");
  
  Result.$addassign_T$C$P(/*KEEP_STR*/"\nstruct _class_ro_t {\n");
  Result.$addassign_T$C$P(/*KEEP_STR*/"\tunsigned int flags;\n");
  Result.$addassign_T$C$P(/*KEEP_STR*/"\tunsigned int instanceStart;\n");
  Result.$addassign_T$C$P(/*KEEP_STR*/"\tunsigned int instanceSize;\n");
  /*const*/ Triple /*&*/ _Triple/*J*/= Context.getTargetInfo().getTriple();
  if (_Triple.getArch() == Triple.ArchType.x86_64) {
    Result.$addassign_T$C$P(/*KEEP_STR*/"\tunsigned int reserved;\n");
  }
  Result.$addassign_T$C$P(/*KEEP_STR*/"\tconst unsigned char *ivarLayout;\n");
  Result.$addassign_T$C$P(/*KEEP_STR*/"\tconst char *name;\n");
  Result.$addassign_T$C$P(/*KEEP_STR*/"\tconst struct _method_list_t *baseMethods;\n");
  Result.$addassign_T$C$P(/*KEEP_STR*/"\tconst struct _objc_protocol_list *baseProtocols;\n");
  Result.$addassign_T$C$P(/*KEEP_STR*/"\tconst struct _ivar_list_t *ivars;\n");
  Result.$addassign_T$C$P(/*KEEP_STR*/"\tconst unsigned char *weakIvarLayout;\n");
  Result.$addassign_T$C$P(/*KEEP_STR*/"\tconst struct _prop_list_t *properties;\n");
  Result.$addassign_T$C$P(/*KEEP_STR*/"};\n");
  
  Result.$addassign_T$C$P(/*KEEP_STR*/"\nstruct _class_t {\n");
  Result.$addassign_T$C$P(/*KEEP_STR*/"\tstruct _class_t *isa;\n");
  Result.$addassign_T$C$P(/*KEEP_STR*/"\tstruct _class_t *superclass;\n");
  Result.$addassign_T$C$P(/*KEEP_STR*/"\tvoid *cache;\n");
  Result.$addassign_T$C$P(/*KEEP_STR*/"\tvoid *vtable;\n");
  Result.$addassign_T$C$P(/*KEEP_STR*/"\tstruct _class_ro_t *ro;\n");
  Result.$addassign_T$C$P(/*KEEP_STR*/"};\n");
  
  Result.$addassign_T$C$P(/*KEEP_STR*/"\nstruct _category_t {\n");
  Result.$addassign_T$C$P(/*KEEP_STR*/"\tconst char *name;\n");
  Result.$addassign_T$C$P(/*KEEP_STR*/"\tstruct _class_t *cls;\n");
  Result.$addassign_T$C$P(/*KEEP_STR*/"\tconst struct _method_list_t *instance_methods;\n");
  Result.$addassign_T$C$P(/*KEEP_STR*/"\tconst struct _method_list_t *class_methods;\n");
  Result.$addassign_T$C$P(/*KEEP_STR*/"\tconst struct _protocol_list_t *protocols;\n");
  Result.$addassign_T$C$P(/*KEEP_STR*/"\tconst struct _prop_list_t *properties;\n");
  Result.$addassign_T$C$P(/*KEEP_STR*/"};\n");
  
  Result.$addassign_T$C$P(/*KEEP_STR*/"extern \"C\" __declspec(dllimport) struct objc_cache _objc_empty_cache;\n");
  Result.$addassign_T$C$P(/*KEEP_STR*/"#pragma warning(disable:4273)\n");
  WriteModernMetadataDeclarations$$.meta_data_declared = true;
}
private static final class WriteModernMetadataDeclarations$$ {
  static /*static*/ boolean meta_data_declared = false;
}

//<editor-fold defaultstate="collapsed" desc="Write_protocol_list_t_TypeDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 6269,
 FQN="Write_protocol_list_t_TypeDecl", NM="_ZL30Write_protocol_list_t_TypeDeclRSsl",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZL30Write_protocol_list_t_TypeDeclRSsl")
//</editor-fold>
public static void Write_protocol_list_t_TypeDecl(std.string/*&*/ Result, 
                              long super_protocol_count) {
  Result.$addassign_T$C$P(/*KEEP_STR*/"struct /*_protocol_list_t*/");
  Result.$addassign_T$C$P(/*KEEP_STR*/" {\n");
  Result.$addassign_T$C$P(/*KEEP_STR*/"\tlong protocol_count;  // Note, this is 32/64 bit\n");
  Result.$addassign_T$C$P(/*KEEP_STR*/"\tstruct _protocol_t *super_protocols[");
  Result.$addassign(utostr($long2ulong(super_protocol_count)));
  Result.$addassign_T$C$P(/*KEEP_STR*/"];\n");
  Result.$addassign_T$C$P(/*KEEP_STR*/"}");
}

//<editor-fold defaultstate="collapsed" desc="Write_method_list_t_TypeDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 6278,
 FQN="Write_method_list_t_TypeDecl", NM="_ZL28Write_method_list_t_TypeDeclRSsj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZL28Write_method_list_t_TypeDeclRSsj")
//</editor-fold>
public static void Write_method_list_t_TypeDecl(std.string/*&*/ Result, 
                            /*uint*/int method_count) {
  Result.$addassign_T$C$P(/*KEEP_STR*/"struct /*_method_list_t*/");
  Result.$addassign_T$C$P(/*KEEP_STR*/" {\n");
  Result.$addassign_T$C$P(/*KEEP_STR*/"\tunsigned int entsize;  // sizeof(struct _objc_method)\n");
  Result.$addassign_T$C$P(/*KEEP_STR*/"\tunsigned int method_count;\n");
  Result.$addassign_T$C$P(/*KEEP_STR*/"\tstruct _objc_method method_list[");
  Result.$addassign(utostr($uint2ulong(method_count)));
  Result.$addassign_T$C$P(/*KEEP_STR*/"];\n");
  Result.$addassign_T$C$P(/*KEEP_STR*/"}");
}

//<editor-fold defaultstate="collapsed" desc="Write__prop_list_t_TypeDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 6288,
 FQN="Write__prop_list_t_TypeDecl", NM="_ZL27Write__prop_list_t_TypeDeclRSsj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZL27Write__prop_list_t_TypeDeclRSsj")
//</editor-fold>
public static void Write__prop_list_t_TypeDecl(std.string/*&*/ Result, 
                           /*uint*/int property_count) {
  Result.$addassign_T$C$P(/*KEEP_STR*/"struct /*_prop_list_t*/");
  Result.$addassign_T$C$P(/*KEEP_STR*/" {\n");
  Result.$addassign_T$C$P(/*KEEP_STR*/"\tunsigned int entsize;  // sizeof(struct _prop_t)\n");
  Result.$addassign_T$C$P(/*KEEP_STR*/"\tunsigned int count_of_properties;\n");
  Result.$addassign_T$C$P(/*KEEP_STR*/"\tstruct _prop_t prop_list[");
  Result.$addassign(utostr($uint2ulong(property_count)));
  Result.$addassign_T$C$P(/*KEEP_STR*/"];\n");
  Result.$addassign_T$C$P(/*KEEP_STR*/"}");
}

//<editor-fold defaultstate="collapsed" desc="Write__ivar_list_t_TypeDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 6298,
 FQN="Write__ivar_list_t_TypeDecl", NM="_ZL27Write__ivar_list_t_TypeDeclRSsj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZL27Write__ivar_list_t_TypeDeclRSsj")
//</editor-fold>
public static void Write__ivar_list_t_TypeDecl(std.string/*&*/ Result, 
                           /*uint*/int ivar_count) {
  Result.$addassign_T$C$P(/*KEEP_STR*/"struct /*_ivar_list_t*/");
  Result.$addassign_T$C$P(/*KEEP_STR*/" {\n");
  Result.$addassign_T$C$P(/*KEEP_STR*/"\tunsigned int entsize;  // sizeof(struct _prop_t)\n");
  Result.$addassign_T$C$P(/*KEEP_STR*/"\tunsigned int count;\n");
  Result.$addassign_T$C$P(/*KEEP_STR*/"\tstruct _ivar_t ivar_list[");
  Result.$addassign(utostr($uint2ulong(ivar_count)));
  Result.$addassign_T$C$P(/*KEEP_STR*/"];\n");
  Result.$addassign_T$C$P(/*KEEP_STR*/"}");
}

//<editor-fold defaultstate="collapsed" desc="Write_protocol_list_initializer">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 6308,
 FQN="Write_protocol_list_initializer", NM="_ZL31Write_protocol_list_initializerPN5clang10ASTContextERSsN4llvm8ArrayRefIPNS_16ObjCProtocolDeclEEENS3_9StringRefES8_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZL31Write_protocol_list_initializerPN5clang10ASTContextERSsN4llvm8ArrayRefIPNS_16ObjCProtocolDeclEEENS3_9StringRefES8_")
//</editor-fold>
public static void Write_protocol_list_initializer(ASTContext /*P*/ Context, std.string/*&*/ Result, 
                               ArrayRef<ObjCProtocolDecl /*P*/ > SuperProtocols, 
                               StringRef VarName, 
                               StringRef ProtocolName) {
  if ($greater_uint(SuperProtocols.size(), 0)) {
    Result.$addassign_T$C$P(/*KEEP_STR*/"\nstatic ");
    Write_protocol_list_t_TypeDecl(Result, SuperProtocols.size());
    Result.$addassign_T$C$P(/*KEEP_STR*/" ");
    $addassign_string_StringRef(Result, /*NO_COPY*/VarName);
    $addassign_string_StringRef(Result, /*NO_COPY*/ProtocolName);
    Result.$addassign_T$C$P(/*KEEP_STR*/" __attribute__ ((used, section (\"__DATA,__objc_const\"))) = {\n");
    Result.$addassign_T$C$P(/*KEEP_STR*/"\t");
    Result.$addassign(utostr($uint2ulong(SuperProtocols.size())));
    Result.$addassign_T$C$P(/*KEEP_STR*/",\n");
    for (/*uint*/int i = 0, e = SuperProtocols.size(); $less_uint(i, e); i++) {
      ObjCProtocolDecl /*P*/ SuperPD = SuperProtocols.$at(i);
      Result.$addassign_T$C$P(/*KEEP_STR*/"\t&");
      Result.$addassign_T$C$P(/*KEEP_STR*/"_OBJC_PROTOCOL_");
      Result.$addassign(SuperPD.getNameAsString());
      if (i == e - 1) {
        Result.$addassign_T$C$P(/*KEEP_STR*/"\n};\n");
      } else {
        Result.$addassign_T$C$P(/*KEEP_STR*/",\n");
      }
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="Write_method_list_t_initializer">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 6331,
 FQN="Write_method_list_t_initializer", NM="_ZL31Write_method_list_t_initializerRN12_GLOBAL__N_117RewriteModernObjCEPN5clang10ASTContextERSsN4llvm8ArrayRefIPNS2_14ObjCMethodDeclEEENS6_9StringRefESB_b",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZL31Write_method_list_t_initializerRN12_GLOBAL__N_117RewriteModernObjCEPN5clang10ASTContextERSsN4llvm8ArrayRefIPNS2_14ObjCMethodDeclEEENS6_9StringRefESB_b")
//</editor-fold>
public static void Write_method_list_t_initializer(RewriteModernObjC /*&*/ RewriteObj, 
                               ASTContext /*P*/ Context, std.string/*&*/ Result, 
                               ArrayRef<ObjCMethodDecl /*P*/ > Methods, 
                               StringRef VarName, 
                               StringRef TopLevelDeclName, 
                               boolean MethodImpl) {
  if ($greater_uint(Methods.size(), 0)) {
    Result.$addassign_T$C$P(/*KEEP_STR*/"\nstatic ");
    Write_method_list_t_TypeDecl(Result, Methods.size());
    Result.$addassign_T$C$P(/*KEEP_STR*/" ");
    $addassign_string_StringRef(Result, /*NO_COPY*/VarName);
    $addassign_string_StringRef(Result, /*NO_COPY*/TopLevelDeclName);
    Result.$addassign_T$C$P(/*KEEP_STR*/" __attribute__ ((used, section (\"__DATA,__objc_const\"))) = {\n");
    Result.$addassign_T$C$P(/*KEEP_STR*/"\t");
    Result.$addassign_T$C$P(/*KEEP_STR*/"sizeof(_objc_method)");
    Result.$addassign_T$C$P(/*KEEP_STR*/",\n");
    Result.$addassign_T$C$P(/*KEEP_STR*/"\t");
    Result.$addassign(utostr($uint2ulong(Methods.size())));
    Result.$addassign_T$C$P(/*KEEP_STR*/",\n");
    for (/*uint*/int i = 0, e = Methods.size(); $less_uint(i, e); i++) {
      ObjCMethodDecl /*P*/ MD = Methods.$at(i);
      if (i == 0) {
        Result.$addassign_T$C$P(/*KEEP_STR*/"\t{{(struct objc_selector *)\"");
      } else {
        Result.$addassign_T$C$P(/*KEEP_STR*/"\t{(struct objc_selector *)\"");
      }
      Result.$addassign((MD).getSelector().getAsString());
      Result.$addassign_T$C$P(/*KEEP_STR*/"\"");
      Result.$addassign_T$C$P(/*KEEP_STR*/", ");
      std.string MethodTypeString/*J*/= new std.string();
      Context.getObjCEncodingForMethodDecl(MD, MethodTypeString);
      Result.$addassign_T$C$P(/*KEEP_STR*/"\"");
      Result.$addassign(MethodTypeString);
      Result.$addassign_T$C$P(/*KEEP_STR*/"\"");
      Result.$addassign_T$C$P(/*KEEP_STR*/", ");
      if (!MethodImpl) {
        Result.$addassign_T$C$P(/*KEEP_STR*/"0");
      } else {
        Result.$addassign_T$C$P(/*KEEP_STR*/"(void *)");
        Result.$addassign(RewriteObj.MethodInternalNames.$at_T1$C$R(MD));
      }
      if (i == e - 1) {
        Result.$addassign_T$C$P(/*KEEP_STR*/"}}\n");
      } else {
        Result.$addassign_T$C$P(/*KEEP_STR*/"},\n");
      }
    }
    Result.$addassign_T$C$P(/*KEEP_STR*/"};\n");
  }
}

//<editor-fold defaultstate="collapsed" desc="Write_prop_list_t_initializer">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 6372,
 FQN="Write_prop_list_t_initializer", NM="_ZL29Write_prop_list_t_initializerRN12_GLOBAL__N_117RewriteModernObjCEPN5clang10ASTContextERSsN4llvm8ArrayRefIPNS2_16ObjCPropertyDeclEEEPKNS2_4DeclENS6_9StringRefESE_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZL29Write_prop_list_t_initializerRN12_GLOBAL__N_117RewriteModernObjCEPN5clang10ASTContextERSsN4llvm8ArrayRefIPNS2_16ObjCPropertyDeclEEEPKNS2_4DeclENS6_9StringRefESE_")
//</editor-fold>
public static void Write_prop_list_t_initializer(RewriteModernObjC /*&*/ RewriteObj, 
                             ASTContext /*P*/ Context, std.string/*&*/ Result, 
                             ArrayRef<ObjCPropertyDecl /*P*/ > Properties, 
                             /*const*/ Decl /*P*/ Container, 
                             StringRef VarName, 
                             StringRef ProtocolName) {
  if ($greater_uint(Properties.size(), 0)) {
    Result.$addassign_T$C$P(/*KEEP_STR*/"\nstatic ");
    Write__prop_list_t_TypeDecl(Result, Properties.size());
    Result.$addassign_T$C$P(/*KEEP_STR*/" ");
    $addassign_string_StringRef(Result, /*NO_COPY*/VarName);
    $addassign_string_StringRef(Result, /*NO_COPY*/ProtocolName);
    Result.$addassign_T$C$P(/*KEEP_STR*/" __attribute__ ((used, section (\"__DATA,__objc_const\"))) = {\n");
    Result.$addassign_T$C$P(/*KEEP_STR*/"\t");
    Result.$addassign_T$C$P(/*KEEP_STR*/"sizeof(_prop_t)");
    Result.$addassign_T$C$P(/*KEEP_STR*/",\n");
    Result.$addassign_T$C$P(/*KEEP_STR*/"\t");
    Result.$addassign(utostr($uint2ulong(Properties.size())));
    Result.$addassign_T$C$P(/*KEEP_STR*/",\n");
    for (/*uint*/int i = 0, e = Properties.size(); $less_uint(i, e); i++) {
      ObjCPropertyDecl /*P*/ PropDecl = Properties.$at(i);
      if (i == 0) {
        Result.$addassign_T$C$P(/*KEEP_STR*/"\t{{\"");
      } else {
        Result.$addassign_T$C$P(/*KEEP_STR*/"\t{\"");
      }
      $addassign_string_StringRef(Result, PropDecl.getName());
      Result.$addassign_T$C$P(/*KEEP_STR*/"\",");
      std.string PropertyTypeString/*J*/= new std.string(), QuotePropertyTypeString/*J*/= new std.string();
      Context.getObjCEncodingForPropertyDecl(PropDecl, Container, PropertyTypeString);
      RewriteObj.QuoteDoublequotes(PropertyTypeString, QuotePropertyTypeString);
      Result.$addassign_T$C$P(/*KEEP_STR*/"\"");
      Result.$addassign(QuotePropertyTypeString);
      Result.$addassign_T$C$P(/*KEEP_STR*/"\"");
      if (i == e - 1) {
        Result.$addassign_T$C$P(/*KEEP_STR*/"}}\n");
      } else {
        Result.$addassign_T$C$P(/*KEEP_STR*/"},\n");
      }
    }
    Result.$addassign_T$C$P(/*KEEP_STR*/"};\n");
  }
}

//<editor-fold defaultstate="collapsed" desc="Write__class_ro_t_initializer">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 6420,
 FQN="Write__class_ro_t_initializer", NM="_ZL29Write__class_ro_t_initializerPN5clang10ASTContextERSsjRKSsS4_N4llvm8ArrayRefIPNS_14ObjCMethodDeclEEENS6_IPNS_16ObjCProtocolDeclEEENS6_IPNS_12ObjCIvarDeclEEENS6_IPNS_16ObjCPropertyDeclEEENS5_9StringRefESJ_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZL29Write__class_ro_t_initializerPN5clang10ASTContextERSsjRKSsS4_N4llvm8ArrayRefIPNS_14ObjCMethodDeclEEENS6_IPNS_16ObjCProtocolDeclEEENS6_IPNS_12ObjCIvarDeclEEENS6_IPNS_16ObjCPropertyDeclEEENS5_9StringRefESJ_")
//</editor-fold>
public static void Write__class_ro_t_initializer(ASTContext /*P*/ Context, std.string/*&*/ Result, 
                             /*uint*/int flags, 
                             /*const*/std.string/*&*/ InstanceStart, 
                             /*const*/std.string/*&*/ InstanceSize, 
                             ArrayRef<ObjCMethodDecl /*P*/ > baseMethods, 
                             ArrayRef<ObjCProtocolDecl /*P*/ > baseProtocols, 
                             ArrayRef<ObjCIvarDecl /*P*/ > ivars, 
                             ArrayRef<ObjCPropertyDecl /*P*/ > Properties, 
                             StringRef VarName, 
                             StringRef ClassName) {
  Result.$addassign_T$C$P(/*KEEP_STR*/"\nstatic struct _class_ro_t ");
  $addassign_string_StringRef(Result, /*NO_COPY*/VarName);
  $addassign_string_StringRef(Result, /*NO_COPY*/ClassName);
  Result.$addassign_T$C$P(/*KEEP_STR*/" __attribute__ ((used, section (\"__DATA,__objc_const\"))) = {\n");
  Result.$addassign_T$C$P(/*KEEP_STR*/"\t");
  Result.$addassign(llvm.utostr($uint2ulong(flags)));
  Result.$addassign_T$C$P(/*KEEP_STR*/", ");
  Result.$addassign(InstanceStart);
  Result.$addassign_T$C$P(/*KEEP_STR*/", ");
  Result.$addassign(InstanceSize);
  Result.$addassign_T$C$P(/*KEEP_STR*/", \n");
  Result.$addassign_T$C$P(/*KEEP_STR*/"\t");
  /*const*/ Triple /*&*/ _Triple/*J*/= Context.getTargetInfo().getTriple();
  if (_Triple.getArch() == Triple.ArchType.x86_64) {
    // uint32_t const reserved; // only when building for 64bit targets
    Result.$addassign_T$C$P(/*KEEP_STR*/"(unsigned int)0, \n\t");
  }
  // const uint8_t * const ivarLayout;
  Result.$addassign_T$C$P(/*KEEP_STR*/"0, \n\t");
  Result.$addassign_T$C$P(/*KEEP_STR*/"\"");
  $addassign_string_StringRef(Result, /*NO_COPY*/ClassName);
  Result.$addassign_T$C$P(/*KEEP_STR*/"\",\n\t");
  boolean metaclass = ((flags & MetaDataDlags.CLS_META) != 0);
  if ($greater_uint(baseMethods.size(), 0)) {
    Result.$addassign_T$C$P(/*KEEP_STR*/"(const struct _method_list_t *)&");
    if (metaclass) {
      Result.$addassign_T$C$P(/*KEEP_STR*/"_OBJC_$_CLASS_METHODS_");
    } else {
      Result.$addassign_T$C$P(/*KEEP_STR*/"_OBJC_$_INSTANCE_METHODS_");
    }
    $addassign_string_StringRef(Result, /*NO_COPY*/ClassName);
    Result.$addassign_T$C$P(/*KEEP_STR*/",\n\t");
  } else {
    Result.$addassign_T$C$P(/*KEEP_STR*/"0, \n\t");
  }
  if (!metaclass && $greater_uint(baseProtocols.size(), 0)) {
    Result.$addassign_T$C$P(/*KEEP_STR*/"(const struct _objc_protocol_list *)&");
    Result.$addassign_T$C$P(/*KEEP_STR*/"_OBJC_CLASS_PROTOCOLS_$_");
    $addassign_string_StringRef(Result, /*NO_COPY*/ClassName);
    Result.$addassign_T$C$P(/*KEEP_STR*/",\n\t");
  } else {
    Result.$addassign_T$C$P(/*KEEP_STR*/"0, \n\t");
  }
  if (!metaclass && $greater_uint(ivars.size(), 0)) {
    Result.$addassign_T$C$P(/*KEEP_STR*/"(const struct _ivar_list_t *)&");
    Result.$addassign_T$C$P(/*KEEP_STR*/"_OBJC_$_INSTANCE_VARIABLES_");
    $addassign_string_StringRef(Result, /*NO_COPY*/ClassName);
    Result.$addassign_T$C$P(/*KEEP_STR*/",\n\t");
  } else {
    Result.$addassign_T$C$P(/*KEEP_STR*/"0, \n\t");
  }
  
  // weakIvarLayout
  Result.$addassign_T$C$P(/*KEEP_STR*/"0, \n\t");
  if (!metaclass && $greater_uint(Properties.size(), 0)) {
    Result.$addassign_T$C$P(/*KEEP_STR*/"(const struct _prop_list_t *)&");
    Result.$addassign_T$C$P(/*KEEP_STR*/"_OBJC_$_PROP_LIST_");
    $addassign_string_StringRef(Result, /*NO_COPY*/ClassName);
    Result.$addassign_T$C$P(/*KEEP_STR*/",\n");
  } else {
    Result.$addassign_T$C$P(/*KEEP_STR*/"0, \n");
  }
  
  Result.$addassign_T$C$P(/*KEEP_STR*/"};\n");
}

//<editor-fold defaultstate="collapsed" desc="Write_class_t">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 6487,
 FQN="Write_class_t", NM="_ZL13Write_class_tPN5clang10ASTContextERSsN4llvm9StringRefEPKNS_17ObjCInterfaceDeclEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZL13Write_class_tPN5clang10ASTContextERSsN4llvm9StringRefEPKNS_17ObjCInterfaceDeclEb")
//</editor-fold>
public static void Write_class_t(ASTContext /*P*/ Context, std.string/*&*/ Result, 
             StringRef VarName, 
             /*const*/ ObjCInterfaceDecl /*P*/ CDecl, boolean metaclass) {
  boolean rootClass = (!(CDecl.getSuperClass() != null));
  /*const*/ ObjCInterfaceDecl /*P*/ RootClass = CDecl;
  if (!rootClass) {
    // Find the Root class
    RootClass = CDecl.getSuperClass();
    while ((RootClass.getSuperClass() != null)) {
      RootClass = RootClass.getSuperClass();
    }
  }
  if (metaclass && rootClass) {
    // Need to handle a case of use of forward declaration.
    Result.$addassign_T$C$P(/*KEEP_STR*/"\n");
    Result.$addassign_T$C$P(/*KEEP_STR*/"extern \"C\" ");
    if ((CDecl.getImplementation() != null)) {
      Result.$addassign_T$C$P(/*KEEP_STR*/"__declspec(dllexport) ");
    } else {
      Result.$addassign_T$C$P(/*KEEP_STR*/"__declspec(dllimport) ");
    }
    
    Result.$addassign_T$C$P(/*KEEP_STR*/"struct _class_t OBJC_CLASS_$_");
    Result.$addassign(CDecl.getNameAsString());
    Result.$addassign_T$C$P(/*KEEP_STR*/";\n");
  }
  // Also, for possibility of 'super' metadata class not having been defined yet.
  if (!rootClass) {
    ObjCInterfaceDecl /*P*/ SuperClass = CDecl.getSuperClass();
    Result.$addassign_T$C$P(/*KEEP_STR*/"\n");
    Result.$addassign_T$C$P(/*KEEP_STR*/"extern \"C\" ");
    if ((SuperClass.getImplementation() != null)) {
      Result.$addassign_T$C$P(/*KEEP_STR*/"__declspec(dllexport) ");
    } else {
      Result.$addassign_T$C$P(/*KEEP_STR*/"__declspec(dllimport) ");
    }
    
    Result.$addassign_T$C$P(/*KEEP_STR*/"struct _class_t ");
    $addassign_string_StringRef(Result, /*NO_COPY*/VarName);
    Result.$addassign(SuperClass.getNameAsString());
    Result.$addassign_T$C$P(/*KEEP_STR*/";\n");
    if (metaclass && RootClass != SuperClass) {
      Result.$addassign_T$C$P(/*KEEP_STR*/"extern \"C\" ");
      if ((RootClass.getImplementation() != null)) {
        Result.$addassign_T$C$P(/*KEEP_STR*/"__declspec(dllexport) ");
      } else {
        Result.$addassign_T$C$P(/*KEEP_STR*/"__declspec(dllimport) ");
      }
      
      Result.$addassign_T$C$P(/*KEEP_STR*/"struct _class_t ");
      $addassign_string_StringRef(Result, /*NO_COPY*/VarName);
      Result.$addassign(RootClass.getNameAsString());
      Result.$addassign_T$C$P(/*KEEP_STR*/";\n");
    }
  }
  
  Result.$addassign_T$C$P(/*KEEP_STR*/"\nextern \"C\" __declspec(dllexport) struct _class_t ");
  $addassign_string_StringRef(Result, /*NO_COPY*/VarName);
  Result.$addassign(CDecl.getNameAsString());
  Result.$addassign_T$C$P(/*KEEP_STR*/" __attribute__ ((used, section (\"__DATA,__objc_data\"))) = {\n");
  Result.$addassign_T$C$P(/*KEEP_STR*/"\t");
  if (metaclass) {
    if (!rootClass) {
      Result.$addassign_T$C$P(/*KEEP_STR*/"0, // &");
      $addassign_string_StringRef(Result, /*NO_COPY*/VarName);
      Result.$addassign(RootClass.getNameAsString());
      Result.$addassign_T$C$P(/*KEEP_STR*/",\n\t");
      Result.$addassign_T$C$P(/*KEEP_STR*/"0, // &");
      $addassign_string_StringRef(Result, /*NO_COPY*/VarName);
      Result.$addassign(CDecl.getSuperClass().getNameAsString());
      Result.$addassign_T$C$P(/*KEEP_STR*/",\n\t");
    } else {
      Result.$addassign_T$C$P(/*KEEP_STR*/"0, // &");
      $addassign_string_StringRef(Result, /*NO_COPY*/VarName);
      Result.$addassign(CDecl.getNameAsString());
      Result.$addassign_T$C$P(/*KEEP_STR*/",\n\t");
      Result.$addassign_T$C$P(/*KEEP_STR*/"0, // &OBJC_CLASS_$_");
      Result.$addassign(CDecl.getNameAsString());
      Result.$addassign_T$C$P(/*KEEP_STR*/",\n\t");
    }
  } else {
    Result.$addassign_T$C$P(/*KEEP_STR*/"0, // &OBJC_METACLASS_$_");
    Result.$addassign(CDecl.getNameAsString());
    Result.$addassign_T$C$P(/*KEEP_STR*/",\n\t");
    if (!rootClass) {
      Result.$addassign_T$C$P(/*KEEP_STR*/"0, // &");
      $addassign_string_StringRef(Result, /*NO_COPY*/VarName);
      Result.$addassign(CDecl.getSuperClass().getNameAsString());
      Result.$addassign_T$C$P(/*KEEP_STR*/",\n\t");
    } else {
      Result.$addassign_T$C$P(/*KEEP_STR*/"0,\n\t");
    }
  }
  Result.$addassign_T$C$P(/*KEEP_STR*/"0, // (void *)&_objc_empty_cache,\n\t");
  Result.$addassign_T$C$P(/*KEEP_STR*/"0, // unused, was (void *)&_objc_empty_vtable,\n\t");
  if (metaclass) {
    Result.$addassign_T$C$P(/*KEEP_STR*/"&_OBJC_METACLASS_RO_$_");
  } else {
    Result.$addassign_T$C$P(/*KEEP_STR*/"&_OBJC_CLASS_RO_$_");
  }
  Result.$addassign(CDecl.getNameAsString());
  Result.$addassign_T$C$P(/*KEEP_STR*/",\n};\n");
  
  // Add static function to initialize some of the meta-data fields.
  // avoid doing it twice.
  if (metaclass) {
    return;
  }
  
  /*const*/ ObjCInterfaceDecl /*P*/ SuperClass = rootClass ? CDecl : CDecl.getSuperClass();
  
  Result.$addassign_T$C$P(/*KEEP_STR*/"static void OBJC_CLASS_SETUP_$_");
  Result.$addassign(CDecl.getNameAsString());
  Result.$addassign_T$C$P(/*KEEP_STR*/"(void ) {\n");
  Result.$addassign_T$C$P(/*KEEP_STR*/"\tOBJC_METACLASS_$_");
  Result.$addassign(CDecl.getNameAsString());
  Result.$addassign_T$C$P(/*KEEP_STR*/".isa = ");
  Result.$addassign_T$C$P(/*KEEP_STR*/"&OBJC_METACLASS_$_");
  Result.$addassign(RootClass.getNameAsString());
  Result.$addassign_T$C$P(/*KEEP_STR*/";\n");
  
  Result.$addassign_T$C$P(/*KEEP_STR*/"\tOBJC_METACLASS_$_");
  Result.$addassign(CDecl.getNameAsString());
  Result.$addassign_T$C$P(/*KEEP_STR*/".superclass = ");
  if (rootClass) {
    Result.$addassign_T$C$P(/*KEEP_STR*/"&OBJC_CLASS_$_");
  } else {
    Result.$addassign_T$C$P(/*KEEP_STR*/"&OBJC_METACLASS_$_");
  }
  
  Result.$addassign(SuperClass.getNameAsString());
  Result.$addassign_T$C$P(/*KEEP_STR*/";\n");
  
  Result.$addassign_T$C$P(/*KEEP_STR*/"\tOBJC_METACLASS_$_");
  Result.$addassign(CDecl.getNameAsString());
  Result.$addassign_T$C$P(/*KEEP_STR*/".cache = ");
  Result.$addassign_T$C$P(/*KEEP_STR*/"&_objc_empty_cache");
  Result.$addassign_T$C$P(/*KEEP_STR*/";\n");
  
  Result.$addassign_T$C$P(/*KEEP_STR*/"\tOBJC_CLASS_$_");
  Result.$addassign(CDecl.getNameAsString());
  Result.$addassign_T$C$P(/*KEEP_STR*/".isa = ");
  Result.$addassign_T$C$P(/*KEEP_STR*/"&OBJC_METACLASS_$_");
  Result.$addassign(CDecl.getNameAsString());
  Result.$addassign_T$C$P(/*KEEP_STR*/";\n");
  if (!rootClass) {
    Result.$addassign_T$C$P(/*KEEP_STR*/"\tOBJC_CLASS_$_");
    Result.$addassign(CDecl.getNameAsString());
    Result.$addassign_T$C$P(/*KEEP_STR*/".superclass = ");
    Result.$addassign_T$C$P(/*KEEP_STR*/"&OBJC_CLASS_$_");
    Result.$addassign(SuperClass.getNameAsString());
    Result.$addassign_T$C$P(/*KEEP_STR*/";\n");
  }
  
  Result.$addassign_T$C$P(/*KEEP_STR*/"\tOBJC_CLASS_$_");
  Result.$addassign(CDecl.getNameAsString());
  Result.$addassign_T$C$P(/*KEEP_STR*/".cache = ");
  Result.$addassign_T$C$P(/*KEEP_STR*/"&_objc_empty_cache");
  Result.$addassign_T$C$P(/*KEEP_STR*/";\n");
  Result.$addassign_T$C$P(/*KEEP_STR*/"}\n");
}

//<editor-fold defaultstate="collapsed" desc="Write_category_t">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 6627,
 FQN="Write_category_t", NM="_ZL16Write_category_tRN12_GLOBAL__N_117RewriteModernObjCEPN5clang10ASTContextERSsPNS2_16ObjCCategoryDeclEPNS2_17ObjCInterfaceDeclEN4llvm8ArrayRefIPNS2_14ObjCMethodDeclEEESE_NSB_IPNS2_16ObjCProtocolDeclEEENSB_IPNS2_16ObjCPropertyDeclEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZL16Write_category_tRN12_GLOBAL__N_117RewriteModernObjCEPN5clang10ASTContextERSsPNS2_16ObjCCategoryDeclEPNS2_17ObjCInterfaceDeclEN4llvm8ArrayRefIPNS2_14ObjCMethodDeclEEESE_NSB_IPNS2_16ObjCProtocolDeclEEENSB_IPNS2_16ObjCPropertyDeclEEE")
//</editor-fold>
public static void Write_category_t(RewriteModernObjC /*&*/ RewriteObj, ASTContext /*P*/ Context, 
                std.string/*&*/ Result, 
                ObjCCategoryDecl /*P*/ CatDecl, 
                ObjCInterfaceDecl /*P*/ ClassDecl, 
                ArrayRef<ObjCMethodDecl /*P*/ > InstanceMethods, 
                ArrayRef<ObjCMethodDecl /*P*/ > ClassMethods, 
                ArrayRef<ObjCProtocolDecl /*P*/ > RefedProtocols, 
                ArrayRef<ObjCPropertyDecl /*P*/ > ClassProperties) {
  StringRef CatName = CatDecl.getName();
  StringRef ClassName = ClassDecl.getName();
  // must declare an extern class object in case this class is not implemented 
  // in this TU.
  Result.$addassign_T$C$P(/*KEEP_STR*/"\n");
  Result.$addassign_T$C$P(/*KEEP_STR*/"extern \"C\" ");
  if ((ClassDecl.getImplementation() != null)) {
    Result.$addassign_T$C$P(/*KEEP_STR*/"__declspec(dllexport) ");
  } else {
    Result.$addassign_T$C$P(/*KEEP_STR*/"__declspec(dllimport) ");
  }
  
  Result.$addassign_T$C$P(/*KEEP_STR*/"struct _class_t ");
  Result.$addassign_T$C$P(/*KEEP_STR*/"OBJC_CLASS_$_");
  $addassign_string_StringRef(Result, /*NO_COPY*/ClassName);
  Result.$addassign_T$C$P(/*KEEP_STR*/";\n");
  
  Result.$addassign_T$C$P(/*KEEP_STR*/"\nstatic struct _category_t ");
  Result.$addassign_T$C$P(/*KEEP_STR*/"_OBJC_$_CATEGORY_");
  $addassign_string_StringRef(Result, /*NO_COPY*/ClassName);
  Result.$addassign_T$C$P(/*KEEP_STR*/"_$_");
  $addassign_string_StringRef(Result, /*NO_COPY*/CatName);
  Result.$addassign_T$C$P(/*KEEP_STR*/" __attribute__ ((used, section (\"__DATA,__objc_const\"))) = \n");
  Result.$addassign_T$C$P(/*KEEP_STR*/"{\n");
  Result.$addassign_T$C$P(/*KEEP_STR*/"\t\"");
  $addassign_string_StringRef(Result, /*NO_COPY*/ClassName);
  Result.$addassign_T$C$P(/*KEEP_STR*/"\",\n");
  Result.$addassign_T$C$P(/*KEEP_STR*/"\t0, // &");
  Result.$addassign_T$C$P(/*KEEP_STR*/"OBJC_CLASS_$_");
  $addassign_string_StringRef(Result, /*NO_COPY*/ClassName);
  Result.$addassign_T$C$P(/*KEEP_STR*/",\n");
  if ($greater_uint(InstanceMethods.size(), 0)) {
    Result.$addassign_T$C$P(/*KEEP_STR*/"\t(const struct _method_list_t *)&");
    Result.$addassign_T$C$P(/*KEEP_STR*/"_OBJC_$_CATEGORY_INSTANCE_METHODS_");
    $addassign_string_StringRef(Result, /*NO_COPY*/ClassName);
    Result.$addassign_T$C$P(/*KEEP_STR*/"_$_");
    $addassign_string_StringRef(Result, /*NO_COPY*/CatName);
    Result.$addassign_T$C$P(/*KEEP_STR*/",\n");
  } else {
    Result.$addassign_T$C$P(/*KEEP_STR*/"\t0,\n");
  }
  if ($greater_uint(ClassMethods.size(), 0)) {
    Result.$addassign_T$C$P(/*KEEP_STR*/"\t(const struct _method_list_t *)&");
    Result.$addassign_T$C$P(/*KEEP_STR*/"_OBJC_$_CATEGORY_CLASS_METHODS_");
    $addassign_string_StringRef(Result, /*NO_COPY*/ClassName);
    Result.$addassign_T$C$P(/*KEEP_STR*/"_$_");
    $addassign_string_StringRef(Result, /*NO_COPY*/CatName);
    Result.$addassign_T$C$P(/*KEEP_STR*/",\n");
  } else {
    Result.$addassign_T$C$P(/*KEEP_STR*/"\t0,\n");
  }
  if ($greater_uint(RefedProtocols.size(), 0)) {
    Result.$addassign_T$C$P(/*KEEP_STR*/"\t(const struct _protocol_list_t *)&");
    Result.$addassign_T$C$P(/*KEEP_STR*/"_OBJC_CATEGORY_PROTOCOLS_$_");
    $addassign_string_StringRef(Result, /*NO_COPY*/ClassName);
    Result.$addassign_T$C$P(/*KEEP_STR*/"_$_");
    $addassign_string_StringRef(Result, /*NO_COPY*/CatName);
    Result.$addassign_T$C$P(/*KEEP_STR*/",\n");
  } else {
    Result.$addassign_T$C$P(/*KEEP_STR*/"\t0,\n");
  }
  if ($greater_uint(ClassProperties.size(), 0)) {
    Result.$addassign_T$C$P(/*KEEP_STR*/"\t(const struct _prop_list_t *)&");
    Result.$addassign_T$C$P(/*KEEP_STR*/"_OBJC_$_PROP_LIST_");
    $addassign_string_StringRef(Result, /*NO_COPY*/ClassName);
    Result.$addassign_T$C$P(/*KEEP_STR*/"_$_");
    $addassign_string_StringRef(Result, /*NO_COPY*/CatName);
    Result.$addassign_T$C$P(/*KEEP_STR*/",\n");
  } else {
    Result.$addassign_T$C$P(/*KEEP_STR*/"\t0,\n");
  }
  
  Result.$addassign_T$C$P(/*KEEP_STR*/"};\n");
  
  // Add static function to initialize the class pointer in the category structure.
  Result.$addassign_T$C$P(/*KEEP_STR*/"static void OBJC_CATEGORY_SETUP_$_");
  Result.$addassign(ClassDecl.getNameAsString());
  Result.$addassign_T$C$P(/*KEEP_STR*/"_$_");
  $addassign_string_StringRef(Result, /*NO_COPY*/CatName);
  Result.$addassign_T$C$P(/*KEEP_STR*/"(void ) {\n");
  Result.$addassign_T$C$P(/*KEEP_STR*/"\t_OBJC_$_CATEGORY_");
  Result.$addassign(ClassDecl.getNameAsString());
  Result.$addassign_T$C$P(/*KEEP_STR*/"_$_");
  $addassign_string_StringRef(Result, /*NO_COPY*/CatName);
  Result.$addassign_T$C$P(/*KEEP_STR*/".cls = ");
  Result.$addassign_T$C$P(/*KEEP_STR*/"&OBJC_CLASS_$_");
  $addassign_string_StringRef(Result, /*NO_COPY*/ClassName);
  Result.$addassign_T$C$P(/*KEEP_STR*/";\n}\n");
}

//<editor-fold defaultstate="collapsed" desc="Write__extendedMethodTypes_initializer">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 6709,
 FQN="Write__extendedMethodTypes_initializer", NM="_ZL38Write__extendedMethodTypes_initializerRN12_GLOBAL__N_117RewriteModernObjCEPN5clang10ASTContextERSsN4llvm8ArrayRefIPNS2_14ObjCMethodDeclEEENS6_9StringRefESB_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZL38Write__extendedMethodTypes_initializerRN12_GLOBAL__N_117RewriteModernObjCEPN5clang10ASTContextERSsN4llvm8ArrayRefIPNS2_14ObjCMethodDeclEEENS6_9StringRefESB_")
//</editor-fold>
public static void Write__extendedMethodTypes_initializer(RewriteModernObjC /*&*/ RewriteObj, 
                                      ASTContext /*P*/ Context, std.string/*&*/ Result, 
                                      ArrayRef<ObjCMethodDecl /*P*/ > Methods, 
                                      StringRef VarName, 
                                      StringRef ProtocolName) {
  if (Methods.size() == 0) {
    return;
  }
  
  Result.$addassign_T$C$P(/*KEEP_STR*/"\nstatic const char *");
  $addassign_string_StringRef(Result, /*NO_COPY*/VarName);
  $addassign_string_StringRef(Result, /*NO_COPY*/ProtocolName);
  Result.$addassign_T$C$P(/*KEEP_STR*/" [] __attribute__ ((used, section (\"__DATA,__objc_const\"))) = \n");
  Result.$addassign_T$C$P(/*KEEP_STR*/"{\n");
  for (/*uint*/int i = 0, e = Methods.size(); $less_uint(i, e); i++) {
    ObjCMethodDecl /*P*/ MD = Methods.$at(i);
    std.string MethodTypeString/*J*/= new std.string(), QuoteMethodTypeString/*J*/= new std.string();
    Context.getObjCEncodingForMethodDecl(MD, MethodTypeString, true);
    RewriteObj.QuoteDoublequotes(MethodTypeString, QuoteMethodTypeString);
    Result.$addassign_T$C$P(/*KEEP_STR*/"\t\"");
    Result.$addassign(QuoteMethodTypeString);
    Result.$addassign_T$C$P(/*KEEP_STR*/"\"");
    if (i == e - 1) {
      Result.$addassign_T$C$P(/*KEEP_STR*/"\n};\n");
    } else {
      Result.$addassign_T$C$P(/*KEEP_STR*/",\n");
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="Write_IvarOffsetVar">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 6735,
 FQN="Write_IvarOffsetVar", NM="_ZL19Write_IvarOffsetVarRN12_GLOBAL__N_117RewriteModernObjCEPN5clang10ASTContextERSsN4llvm8ArrayRefIPNS2_12ObjCIvarDeclEEEPNS2_17ObjCInterfaceDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZL19Write_IvarOffsetVarRN12_GLOBAL__N_117RewriteModernObjCEPN5clang10ASTContextERSsN4llvm8ArrayRefIPNS2_12ObjCIvarDeclEEEPNS2_17ObjCInterfaceDeclE")
//</editor-fold>
public static void Write_IvarOffsetVar(RewriteModernObjC /*&*/ RewriteObj, 
                   ASTContext /*P*/ Context, 
                   std.string/*&*/ Result, 
                   ArrayRef<ObjCIvarDecl /*P*/ > Ivars, 
                   ObjCInterfaceDecl /*P*/ CDecl) {
  // FIXME. visibilty of offset symbols may have to be set; for Darwin
  // this is what happens:
  /**
  if (Ivar->getAccessControl() == ObjCIvarDecl::Private ||
  Ivar->getAccessControl() == ObjCIvarDecl::Package ||
  Class->getVisibility() == HiddenVisibility)
  Visibility shoud be: HiddenVisibility;
  else
  Visibility shoud be: DefaultVisibility;
  */
  Result.$addassign_T$C$P(/*KEEP_STR*/"\n");
  for (/*uint*/int i = 0, e = Ivars.size(); $less_uint(i, e); i++) {
    ObjCIvarDecl /*P*/ IvarDecl = Ivars.$at(i);
    if (Context.getLangOpts().MicrosoftExt) {
      Result.$addassign_T$C$P(/*KEEP_STR*/"__declspec(allocate(\".objc_ivar$B\")) ");
    }
    if (!Context.getLangOpts().MicrosoftExt
       || IvarDecl.getAccessControl() == ObjCIvarDecl.AccessControl.Private
       || IvarDecl.getAccessControl() == ObjCIvarDecl.AccessControl.Package) {
      Result.$addassign_T$C$P(/*KEEP_STR*/"extern \"C\" unsigned long int ");
    } else {
      Result.$addassign_T$C$P(/*KEEP_STR*/"extern \"C\" __declspec(dllexport) unsigned long int ");
    }
    if (Ivars.$at(i).isBitField()) {
      RewriteObj.ObjCIvarBitfieldGroupOffset(IvarDecl, Result);
    } else {
      WriteInternalIvarName(CDecl, IvarDecl, Result);
    }
    Result.$addassign_T$C$P(/*KEEP_STR*/" __attribute__ ((used, section (\"__DATA,__objc_ivar\")))");
    Result.$addassign_T$C$P(/*KEEP_STR*/" = ");
    RewriteObj.RewriteIvarOffsetComputation(IvarDecl, Result);
    Result.$addassign_T$C$P(/*KEEP_STR*/";\n");
    if (Ivars.$at(i).isBitField()) {
      {
        // skip over rest of the ivar bitfields.
        while (($less_uint(i, e)) && Ivars.$at(i).isBitField()) {
          ++i;
        }
        if ($less_uint(i, e)) {
          --i;
        }
      }
      ;
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="Write__ivar_list_t_initializer">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 6778,
 FQN="Write__ivar_list_t_initializer", NM="_ZL30Write__ivar_list_t_initializerRN12_GLOBAL__N_117RewriteModernObjCEPN5clang10ASTContextERSsN4llvm8ArrayRefIPNS2_12ObjCIvarDeclEEENS6_9StringRefEPNS2_17ObjCInterfaceDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZL30Write__ivar_list_t_initializerRN12_GLOBAL__N_117RewriteModernObjCEPN5clang10ASTContextERSsN4llvm8ArrayRefIPNS2_12ObjCIvarDeclEEENS6_9StringRefEPNS2_17ObjCInterfaceDeclE")
//</editor-fold>
public static void Write__ivar_list_t_initializer(RewriteModernObjC /*&*/ RewriteObj, 
                              ASTContext /*P*/ Context, std.string/*&*/ Result, 
                              ArrayRef<ObjCIvarDecl /*P*/ > OriginalIvars, 
                              StringRef VarName, 
                              ObjCInterfaceDecl /*P*/ CDecl) {
  if ($greater_uint(OriginalIvars.size(), 0)) {
    Write_IvarOffsetVar(RewriteObj, Context, Result, new ArrayRef<ObjCIvarDecl /*P*/ >(OriginalIvars), CDecl);
    SmallVector<ObjCIvarDecl /*P*/ > Ivars/*J*/= new SmallVector<ObjCIvarDecl /*P*/ >(8, (ObjCIvarDecl /*P*/ )null);
    // strip off all but the first ivar bitfield from each group of ivars.
    // Such ivars in the ivar list table will be replaced by their grouping struct
    // 'ivar'.
    for (/*uint*/int i = 0, e = OriginalIvars.size(); $less_uint(i, e); i++) {
      if (OriginalIvars.$at(i).isBitField()) {
        Ivars.push_back(OriginalIvars.$at(i));
        {
          // skip over rest of the ivar bitfields.
          while (($less_uint(i, e)) && OriginalIvars.$at(i).isBitField()) {
            ++i;
          }
          if ($less_uint(i, e)) {
            --i;
          }
        }
        ;
      } else {
        Ivars.push_back(OriginalIvars.$at(i));
      }
    }
    
    Result.$addassign_T$C$P(/*KEEP_STR*/"\nstatic ");
    Write__ivar_list_t_TypeDecl(Result, Ivars.size());
    Result.$addassign_T$C$P(/*KEEP_STR*/" ");
    $addassign_string_StringRef(Result, /*NO_COPY*/VarName);
    Result.$addassign(CDecl.getNameAsString());
    Result.$addassign_T$C$P(/*KEEP_STR*/" __attribute__ ((used, section (\"__DATA,__objc_const\"))) = {\n");
    Result.$addassign_T$C$P(/*KEEP_STR*/"\t");
    Result.$addassign_T$C$P(/*KEEP_STR*/"sizeof(_ivar_t)");
    Result.$addassign_T$C$P(/*KEEP_STR*/",\n");
    Result.$addassign_T$C$P(/*KEEP_STR*/"\t");
    Result.$addassign(utostr($uint2ulong(Ivars.size())));
    Result.$addassign_T$C$P(/*KEEP_STR*/",\n");
    for (/*uint*/int i = 0, e = Ivars.size(); $less_uint(i, e); i++) {
      ObjCIvarDecl /*P*/ IvarDecl = Ivars.$at(i);
      if (i == 0) {
        Result.$addassign_T$C$P(/*KEEP_STR*/"\t{{");
      } else {
        Result.$addassign_T$C$P(/*KEEP_STR*/"\t {");
      }
      Result.$addassign_T$C$P(/*KEEP_STR*/"(unsigned long int *)&");
      if (Ivars.$at(i).isBitField()) {
        RewriteObj.ObjCIvarBitfieldGroupOffset(IvarDecl, Result);
      } else {
        WriteInternalIvarName(CDecl, IvarDecl, Result);
      }
      Result.$addassign_T$C$P(/*KEEP_STR*/", ");
      
      Result.$addassign_T$C$P(/*KEEP_STR*/"\"");
      if (Ivars.$at(i).isBitField()) {
        RewriteObj.ObjCIvarBitfieldGroupDecl(Ivars.$at(i), Result);
      } else {
        $addassign_string_StringRef(Result, IvarDecl.getName());
      }
      Result.$addassign_T$C$P(/*KEEP_STR*/"\", ");
      
      QualType IVQT = IvarDecl.getType();
      if (IvarDecl.isBitField()) {
        IVQT.$assignMove(RewriteObj.GetGroupRecordTypeForObjCIvarBitfield(IvarDecl));
      }
      
      std.string IvarTypeString/*J*/= new std.string(), QuoteIvarTypeString/*J*/= new std.string();
      Context.getObjCEncodingForType(new QualType(IVQT), IvarTypeString, 
          IvarDecl);
      RewriteObj.QuoteDoublequotes(IvarTypeString, QuoteIvarTypeString);
      Result.$addassign_T$C$P(/*KEEP_STR*/"\"");
      Result.$addassign(QuoteIvarTypeString);
      Result.$addassign_T$C$P(/*KEEP_STR*/"\", ");
      
      // FIXME. this alignment represents the host alignment and need be changed to
      // represent the target alignment.
      /*uint*/int Align = $div_uint(Context.getTypeAlign(new QualType(IVQT)), 8);
      Align = llvm.Log2_32(Align);
      Result.$addassign(llvm.utostr($uint2ulong(Align)));
      Result.$addassign_T$C$P(/*KEEP_STR*/", ");
      CharUnits Size = Context.getTypeSizeInChars(new QualType(IVQT));
      Result.$addassign(llvm.utostr(Size.getQuantity()));
      if (i == e - 1) {
        Result.$addassign_T$C$P(/*KEEP_STR*/"}}\n");
      } else {
        Result.$addassign_T$C$P(/*KEEP_STR*/"},\n");
      }
    }
    Result.$addassign_T$C$P(/*KEEP_STR*/"};\n");
  }
}


/// hasObjCExceptionAttribute - Return true if this class or any super
/// class has the __objc_exception__ attribute.
/// FIXME. Move this to ASTContext.cpp as it is also used for IRGen.
//<editor-fold defaultstate="collapsed" desc="hasObjCExceptionAttribute">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp", line = 7006,
 FQN="hasObjCExceptionAttribute", NM="_ZL25hasObjCExceptionAttributeRN5clang10ASTContextEPKNS_17ObjCInterfaceDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.rewrite/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/Rewrite/RewriteModernObjC.cpp -nm=_ZL25hasObjCExceptionAttributeRN5clang10ASTContextEPKNS_17ObjCInterfaceDeclE")
//</editor-fold>
public static boolean hasObjCExceptionAttribute(ASTContext /*&*/ Context, 
                         /*const*/ ObjCInterfaceDecl /*P*/ OID) {
  if (OID.hasAttr(ObjCExceptionAttr.class)) {
    return true;
  }
  {
    /*const*/ ObjCInterfaceDecl /*P*/ Super = OID.getSuperClass();
    if ((Super != null)) {
      return hasObjCExceptionAttribute(Context, Super);
    }
  }
  return false;
}

} // END OF class RewriteModernObjCStatics
