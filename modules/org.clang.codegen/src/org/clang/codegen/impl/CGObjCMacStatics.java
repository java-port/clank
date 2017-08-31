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

import org.clank.java.*;
import org.clank.support.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.llvm.ir.*;
import org.clang.codegen.CodeGen.impl.*;
import org.llvm.ir.Type;
import static org.clang.ast.java.AstDeclarationsRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type CGObjCMacStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_CGObjCMac_cpp_Unnamed_enum;_ZL10getStorageRN5clang7CodeGen13CodeGenModuleEN4llvm9StringRefE;_ZL12addIfPresentRN4llvm8DenseSetIPNS_5ValueENS_12DenseMapInfoIS2_EEEEN5clang7CodeGen7AddressE;_ZL12addIfPresentRN4llvm8DenseSetIPNS_5ValueENS_12DenseMapInfoIS2_EEEES2_;_ZL13ModuleVersion;_ZL13hasWeakMemberN5clang8QualTypeE;_ZL14getConstantGEPRN4llvm11LLVMContextEPNS_14GlobalVariableEjj;_ZL15hasMRCWeakIvarsRN5clang7CodeGen13CodeGenModuleEPKNS_22ObjCImplementationDeclE;_ZL17isWeakLinkedClassPKN5clang17ObjCInterfaceDeclE;_ZL20GetGCAttrTypeForTypeRN5clang10ASTContextENS_8QualTypeEb;_ZL25hasObjCExceptionAttributeRN5clang10ASTContextEPKNS_17ObjCInterfaceDeclE;_ZL32appendSelectorForMessageRefTableRNSt7__cxx1112basic_stringIcSt11char_traitsIcESaIcEEEN5clang8SelectorE; -static-type=CGObjCMacStatics -package=org.clang.codegen.impl")
//</editor-fold>
public final class CGObjCMacStatics {

// end anonymous namespace

/* *** Helper Functions *** */

/// getConstantGEP() - Help routine to construct simple GEPs.
//<editor-fold defaultstate="collapsed" desc="getConstantGEP">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 1680,
 FQN="getConstantGEP", NM="_ZL14getConstantGEPRN4llvm11LLVMContextEPNS_14GlobalVariableEjj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZL14getConstantGEPRN4llvm11LLVMContextEPNS_14GlobalVariableEjj")
//</editor-fold>
public static Constant /*P*/ getConstantGEP(final LLVMContext /*&*/ VMContext, 
              GlobalVariable /*P*/ C, /*uint*/int idx0, 
              /*uint*/int idx1) {
  Value /*P*/ Idxs[/*2*/] = new Value /*P*/  [/*2*/] {
    ConstantInt.get(Type.getInt32Ty(VMContext), $uint2ulong(idx0)), 
    ConstantInt.get(Type.getInt32Ty(VMContext), $uint2ulong(idx1))
  };
  return ConstantExpr.getGetElementPtr_Type$P_Constant$P_ArrayRef$Value$P_bool_Type$P(C.getValueType(), C, new ArrayRef<Value /*P*/ >(Idxs, true));
}


/// hasObjCExceptionAttribute - Return true if this class or any super
/// class has the __objc_exception__ attribute.
//<editor-fold defaultstate="collapsed" desc="hasObjCExceptionAttribute">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 1692,
 FQN="hasObjCExceptionAttribute", NM="_ZL25hasObjCExceptionAttributeRN5clang10ASTContextEPKNS_17ObjCInterfaceDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZL25hasObjCExceptionAttributeRN5clang10ASTContextEPKNS_17ObjCInterfaceDeclE")
//</editor-fold>
public static boolean hasObjCExceptionAttribute(final ASTContext /*&*/ Context, 
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

//<editor-fold defaultstate="collapsed" desc="(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 1771,
 FQN="(anonymous)", NM="_CGObjCMac_cpp_Unnamed_enum",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_CGObjCMac_cpp_Unnamed_enum")
//</editor-fold>
/*enum ANONYMOUS_INT_CONSTANTS {*/
  public static final /*uint*/int kCFTaggedObjectID_Integer = (1 << 1) + 1;
/*}*/
//<editor-fold defaultstate="collapsed" desc="isWeakLinkedClass">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 1856,
 FQN="isWeakLinkedClass", NM="_ZL17isWeakLinkedClassPKN5clang17ObjCInterfaceDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZL17isWeakLinkedClassPKN5clang17ObjCInterfaceDeclE")
//</editor-fold>
public static boolean isWeakLinkedClass(/*const*/ ObjCInterfaceDecl /*P*/ ID) {
  do {
    if (ID.isWeakImported()) {
      return true;
    }
  } while (((ID = ID.getSuperClass()) != null));
  
  return false;
}

//<editor-fold defaultstate="collapsed" desc="GetGCAttrTypeForType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 1969,
 FQN="GetGCAttrTypeForType", NM="_ZL20GetGCAttrTypeForTypeRN5clang10ASTContextENS_8QualTypeEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZL20GetGCAttrTypeForTypeRN5clang10ASTContextENS_8QualTypeEb")
//</editor-fold>
public static Qualifiers.GC GetGCAttrTypeForType(final ASTContext /*&*/ Ctx, QualType FQT) {
  return GetGCAttrTypeForType(Ctx, FQT, 
                    false);
}
public static Qualifiers.GC GetGCAttrTypeForType(final ASTContext /*&*/ Ctx, QualType FQT, 
                    boolean pointee/*= false*/) {
  // Note that GC qualification applies recursively to C pointer types
  // that aren't otherwise decorated.  This is weird, but it's probably
  // an intentional workaround to the unreliable placement of GC qualifiers.
  if (FQT.isObjCGCStrong()) {
    return Qualifiers.GC.Strong;
  }
  if (FQT.isObjCGCWeak()) {
    return Qualifiers.GC.Weak;
  }
  {
    
    Qualifiers.ObjCLifetime ownership = FQT.getObjCLifetime();
    if ((ownership.getValue() != 0)) {
      // Ownership does not apply recursively to C pointer types.
      if (pointee) {
        return Qualifiers.GC.GCNone;
      }
      switch (ownership) {
       case OCL_Weak:
        return Qualifiers.GC.Weak;
       case OCL_Strong:
        return Qualifiers.GC.Strong;
       case OCL_ExplicitNone:
        return Qualifiers.GC.GCNone;
       case OCL_Autoreleasing:
        throw new llvm_unreachable("autoreleasing ivar?");
       case OCL_None:
        throw new llvm_unreachable("known nonzero");
      }
      throw new llvm_unreachable("bad objc ownership");
    }
  }
  
  // Treat unqualified retainable pointers as strong.
  if (FQT.$arrow().isObjCObjectPointerType() || FQT.$arrow().isBlockPointerType()) {
    return Qualifiers.GC.Strong;
  }
  
  // Walk into C pointer types, but only in GC.
  if (Ctx.getLangOpts().getGC() != LangOptions.GCMode.NonGC) {
    {
      /*const*/ org.clang.ast.PointerType /*P*/ PT = FQT.$arrow().getAs(org.clang.ast.PointerType.class);
      if ((PT != null)) {
        return GetGCAttrTypeForType(Ctx, PT.getPointeeType(), /*pointee*/ true);
      }
    }
  }
  
  return Qualifiers.GC.GCNone;
}

//<editor-fold defaultstate="collapsed" desc="hasWeakMember">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 3204,
 FQN="hasWeakMember", NM="_ZL13hasWeakMemberN5clang8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZL13hasWeakMemberN5clang8QualTypeE")
//</editor-fold>
public static boolean hasWeakMember(QualType type) {
  if (type.getObjCLifetime() == Qualifiers.ObjCLifetime.OCL_Weak) {
    return true;
  }
  {
    
    /*const*/ RecordType /*P*/ recType = type.$arrow().getAs$RecordType();
    if ((recType != null)) {
      for (FieldDecl /*P*/ field : recType.getDecl().fields()) {
        if (hasWeakMember(field.getType())) {
          return true;
        }
      }
    }
  }
  
  return false;
}


/// For compatibility, we only want to set the "HasMRCWeakIvars" flag
/// (and actually fill in a layout string) if we really do have any
/// __weak ivars.
//<editor-fold defaultstate="collapsed" desc="hasMRCWeakIvars">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 3222,
 FQN="hasMRCWeakIvars", NM="_ZL15hasMRCWeakIvarsRN5clang7CodeGen13CodeGenModuleEPKNS_22ObjCImplementationDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZL15hasMRCWeakIvarsRN5clang7CodeGen13CodeGenModuleEPKNS_22ObjCImplementationDeclE")
//</editor-fold>
public static boolean hasMRCWeakIvars(final CodeGenModule /*&*/ CGM, 
               /*const*/ ObjCImplementationDecl /*P*/ ID) {
  if (!CGM.getLangOpts().ObjCWeak) {
    return false;
  }
  assert (CGM.getLangOpts().getGC() == LangOptions.GCMode.NonGC);
  
  for (/*const*/ ObjCIvarDecl /*P*/ ivar = ID.getClassInterface$Const().all_declared_ivar_begin$Const();
       (ivar != null); ivar = ivar.getNextIvar$Const()) {
    if (hasWeakMember(ivar.getType())) {
      return true;
    }
  }
  
  return false;
}

//<editor-fold defaultstate="collapsed" desc="addIfPresent">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 3884,
 FQN="addIfPresent", NM="_ZL12addIfPresentRN4llvm8DenseSetIPNS_5ValueENS_12DenseMapInfoIS2_EEEES2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZL12addIfPresentRN4llvm8DenseSetIPNS_5ValueENS_12DenseMapInfoIS2_EEEES2_")
//</editor-fold>
public static void addIfPresent(final DenseSet<Value /*P*/ > /*&*/ S, Value /*P*/ V) {
  if ((V != null)) {
    S.insert(V);
  }
}

//<editor-fold defaultstate="collapsed" desc="addIfPresent">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 3888,
 FQN="addIfPresent", NM="_ZL12addIfPresentRN4llvm8DenseSetIPNS_5ValueENS_12DenseMapInfoIS2_EEEEN5clang7CodeGen7AddressE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZL12addIfPresentRN4llvm8DenseSetIPNS_5ValueENS_12DenseMapInfoIS2_EEEEN5clang7CodeGen7AddressE")
//</editor-fold>
public static void addIfPresent(final DenseSet<Value /*P*/ > /*&*/ S, Address V) {
  if (V.isValid()) {
    S.insert(V.getPointer());
  }
}


// struct objc_module {
//   unsigned long version;
//   unsigned long size;
//   const char *name;
//   Symtab symtab;
// };

// FIXME: Get from somewhere
//<editor-fold defaultstate="collapsed" desc="ModuleVersion">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 4588,
 FQN="ModuleVersion", NM="_ZL13ModuleVersion",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZL13ModuleVersion")
//</editor-fold>
public static /*const*/int ModuleVersion = 7;
//<editor-fold defaultstate="collapsed" desc="getStorage">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 5981,
 FQN="getStorage", NM="_ZL10getStorageRN5clang7CodeGen13CodeGenModuleEN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZL10getStorageRN5clang7CodeGen13CodeGenModuleEN4llvm9StringRefE")
//</editor-fold>
public static GlobalValue.DLLStorageClassTypes getStorage(final CodeGenModule /*&*/ CGM, 
          StringRef Name) {
  final IdentifierInfo /*&*/ II = CGM.getContext().Idents.get(/*NO_COPY*/Name);
  TranslationUnitDecl /*P*/ TUDecl = CGM.getContext().getTranslationUnitDecl();
  DeclContext /*P*/ DC = TranslationUnitDecl.castToDeclContext(TUDecl);
  
  /*const*/ VarDecl /*P*/ VD = null;
  for (final NamedDecl /*P*/ /*const*/ /*&*/ Result : DC.lookup(new DeclarationName(/*AddrOf*/II)))  {
    if (((VD = dyn_cast_VarDecl(Result)) != null)) {
      break;
    }
  }
  if (!(VD != null)) {
    return GlobalValue.DLLStorageClassTypes.DLLImportStorageClass;
  }
  if (VD.hasAttr(DLLExportAttr.class)) {
    return GlobalValue.DLLStorageClassTypes.DLLExportStorageClass;
  }
  if (VD.hasAttr(DLLImportAttr.class)) {
    return GlobalValue.DLLStorageClassTypes.DLLImportStorageClass;
  }
  return GlobalValue.DLLStorageClassTypes.DefaultStorageClass;
}

//<editor-fold defaultstate="collapsed" desc="appendSelectorForMessageRefTable">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 6764,
 FQN="appendSelectorForMessageRefTable", NM="_ZL32appendSelectorForMessageRefTableRNSt7__cxx1112basic_stringIcSt11char_traitsIcESaIcEEEN5clang8SelectorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZL32appendSelectorForMessageRefTableRNSt7__cxx1112basic_stringIcSt11char_traitsIcESaIcEEEN5clang8SelectorE")
//</editor-fold>
public static void appendSelectorForMessageRefTable(final std.string/*&*/ buffer, 
                                Selector selector) {
  if (selector.isUnarySelector()) {
    $addassign_string_StringRef(buffer, selector.getNameForSlot(0));
    return;
  }
  
  for (/*uint*/int i = 0, e = selector.getNumArgs(); i != e; ++i) {
    $addassign_string_StringRef(buffer, selector.getNameForSlot(i));
    buffer.$addassign_T($$UNDERSCORE);
  }
}

} // END OF class CGObjCMacStatics
