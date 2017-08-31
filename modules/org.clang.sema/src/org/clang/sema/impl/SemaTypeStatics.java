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

import static org.clank.support.Native.$Deref;
import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
;
import org.clang.basic.*;
import org.clang.lex.llvm.*;
import org.clang.sema.*;
import static org.clang.basic.BasicClangGlobals.*;
import static org.clang.sema.Sema_NestedClasses.SemaDiagnosticBuilder.*;
import static org.clang.sema.java.SemaFunctionPointers.*;
import static org.clang.ast.java.AstRTTI.*;
import org.clang.ast.FunctionType.ExtInfo;
import org.clang.basic.java.BasicFunctionPointers.UInt2SourceLocation;
import org.clang.sema.DeclaratorChunk.ParamInfo;
import static org.clang.ast.java.AstTypesRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type SemaTypeStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZL14isArraySizeVLARN5clang4SemaEPNS_4ExprERN4llvm6APSIntE;_ZL15getAttrListKindN5clang14AttributedType4KindE;_ZL16processTypeAttrsRN12_GLOBAL__N_119TypeProcessingStateERN5clang8QualTypeE16TypeAttrLocationPNS2_13AttributeListE;_ZL17applyObjCTypeArgsRN5clang4SemaENS_14SourceLocationENS_8QualTypeEN4llvm8ArrayRefIPNS_14TypeSourceInfoEEENS_11SourceRangeEb;_ZL17fillAtomicQualLocN5clang13AtomicTypeLocERKNS_15DeclaratorChunkE;_ZL17getCCTypeAttrKindRN5clang13AttributeListE;_ZL17inferARCWritebackRN12_GLOBAL__N_119TypeProcessingStateERN5clang8QualTypeE;_ZL18getDecltypeForExprRN5clang4SemaEPNS_4ExprE;_ZL18hasNullabilityAttrPKN5clang13AttributeListE;_ZL18spliceAttrIntoListRN5clang13AttributeListERPS0_;_ZL19spliceAttrOutOfListRN5clang13AttributeListERPS0_;_ZL20HandleVectorSizeAttrRN5clang8QualTypeERKNS_13AttributeListERNS_4SemaE;_ZL20handleObjCGCTypeAttrRN12_GLOBAL__N_119TypeProcessingStateERN5clang13AttributeListERNS2_8QualTypeE;_ZL20transferARCOwnershipRN12_GLOBAL__N_119TypeProcessingStateERN5clang8QualTypeENS2_10Qualifiers12ObjCLifetimeE;_ZL21ConvertDeclSpecToTypeRN12_GLOBAL__N_119TypeProcessingStateE;_ZL21fillAttributedTypeLocN5clang17AttributedTypeLocEPKNS_13AttributeListES3_;_ZL21getImageAccessAttrStrPN5clang13AttributeListE;_ZL22HandleOpenCLAccessAttrRN5clang8QualTypeERKNS_13AttributeListERNS_4SemaE;_ZL22assignInheritanceModelRN5clang4SemaEPNS_13CXXRecordDeclE;_ZL22checkExtParameterInfosRN5clang4SemaEN4llvm8ArrayRefINS_8QualTypeEEERKNS_17FunctionProtoType12ExtProtoInfoENS2_12function_refIFNS_14SourceLocationEjEEE;_ZL22checkQualifiedFunctionRN5clang4SemaENS_8QualTypeENS_14SourceLocationEN12_GLOBAL__N_121QualifiedFunctionKindE;_ZL22handleFunctionTypeAttrRN12_GLOBAL__N_119TypeProcessingStateERN5clang13AttributeListERNS2_8QualTypeE;_ZL22mapNullabilityAttrKindN5clang13AttributeList4KindE;_ZL22moveAttrFromListToListRN5clang13AttributeListERPS0_S3_;_ZL23HandleExtVectorTypeAttrRN5clang8QualTypeERKNS_13AttributeListERNS_4SemaE;_ZL23getCCForDeclaratorChunkRN5clang4SemaERNS_10DeclaratorERKNS_15DeclaratorChunk16FunctionTypeInfoEj;_ZL23isPermittedNeonBaseTypeRN5clang8QualTypeENS_10VectorType10VectorKindERNS_4SemaE;_ZL23maybeMovePastReturnTypeRN5clang10DeclaratorEjb;_ZL24GetFullTypeForDeclaratorRN12_GLOBAL__N_119TypeProcessingStateEN5clang8QualTypeEPNS2_14TypeSourceInfoE;_ZL24HandleNeonVectorTypeAttrRN5clang8QualTypeERKNS_13AttributeListERNS_4SemaENS_10VectorType10VectorKindE;_ZL24diagnoseBadTypeAttributeRN5clang4SemaERKNS_13AttributeListENS_8QualTypeE;_ZL24isOmittedBlockReturnTypeRKN5clang10DeclaratorE;_ZL25classifyPointerDeclaratorRN5clang4SemaENS_8QualTypeERNS_10DeclaratorE;_ZL25getLiteralDiagFromTagKindN5clang11TagTypeKindE;_ZL25getPrintableNameForEntityN5clang15DeclarationNameE;_ZL25handleObjCPointerTypeAttrRN12_GLOBAL__N_119TypeProcessingStateERN5clang13AttributeListERNS2_8QualTypeE;_ZL26distributeFunctionTypeAttrRN12_GLOBAL__N_119TypeProcessingStateERN5clang13AttributeListENS2_8QualTypeE;_ZL26inferARCLifetimeForPointeeRN5clang4SemaENS_8QualTypeENS_14SourceLocationEb;_ZL26warnAboutAmbiguousFunctionRN5clang4SemaERNS_10DeclaratorERNS_15DeclaratorChunkENS_8QualTypeE;_ZL27applyObjCProtocolQualifiersRN5clang4SemaENS_14SourceLocationENS_11SourceRangeENS_8QualTypeEN4llvm8ArrayRefIPNS_16ObjCProtocolDeclEEEPKS2_b;_ZL27checkNullabilityConsistencyRN12_GLOBAL__N_119TypeProcessingStateENS_17SimplePointerKindEN5clang14SourceLocationE;_ZL27checkOmittedBlockReturnTypeRN5clang4SemaERNS_10DeclaratorENS_8QualTypeE;_ZL27handleObjCOwnershipTypeAttrRN12_GLOBAL__N_119TypeProcessingStateERN5clang13AttributeListERNS2_8QualTypeE;_ZL27hasDirectOwnershipQualifierN5clang8QualTypeE;_ZL28GetDeclSpecTypeForDeclaratorRN12_GLOBAL__N_119TypeProcessingStateERPN5clang14TypeSourceInfoE;_ZL29distributeNullabilityTypeAttrRN12_GLOBAL__N_119TypeProcessingStateEN5clang8QualTypeERNS2_13AttributeListE;_ZL29distributeObjCPointerTypeAttrRN12_GLOBAL__N_119TypeProcessingStateERN5clang13AttributeListENS2_8QualTypeE;_ZL29getFunctionQualifiersAsStringPKN5clang17FunctionProtoTypeE;_ZL29maybeSynthesizeBlockSignatureRN12_GLOBAL__N_119TypeProcessingStateEN5clang8QualTypeE;_ZL30transferARCOwnershipToDeclSpecRN5clang4SemaERNS_8QualTypeENS_10Qualifiers12ObjCLifetimeE;_ZL31HandleAddressSpaceTypeAttributeRN5clang8QualTypeERKNS_13AttributeListERNS_4SemaE;_ZL31diagnoseAndRemoveTypeQualifiersRN5clang4SemaERKNS_8DeclSpecERjNS_8QualTypeEjj;_ZL32handleMSPointerTypeQualifierAttrRN12_GLOBAL__N_119TypeProcessingStateERN5clang13AttributeListERNS2_8QualTypeE;_ZL33distributeTypeAttrsFromDeclaratorRN12_GLOBAL__N_119TypeProcessingStateERN5clang8QualTypeE;_ZL37diagnoseRedundantReturnTypeQualifiersRN5clang4SemaENS_8QualTypeERNS_10DeclaratorEj;_ZL37distributeFunctionTypeAttrToInnermostRN12_GLOBAL__N_119TypeProcessingStateERN5clang13AttributeListERPS3_RNS2_8QualTypeE;_ZL37getNullabilityCompletenessCheckFileIDRN5clang4SemaENS_14SourceLocationE;_ZL37transferARCOwnershipToDeclaratorChunkRN12_GLOBAL__N_119TypeProcessingStateEN5clang10Qualifiers12ObjCLifetimeEj;_ZL38distributeFunctionTypeAttrFromDeclSpecRN12_GLOBAL__N_119TypeProcessingStateERN5clang13AttributeListERNS2_8QualTypeE;_ZL40distributeFunctionTypeAttrFromDeclaratorRN12_GLOBAL__N_119TypeProcessingStateERN5clang13AttributeListERNS2_8QualTypeE;_ZL43distributeObjCPointerTypeAttrFromDeclaratorRN12_GLOBAL__N_119TypeProcessingStateERN5clang13AttributeListERNS2_8QualTypeE; -static-type=SemaTypeStatics -package=org.clang.sema.impl")
//</editor-fold>
public final class SemaTypeStatics {


/// isOmittedBlockReturnType - Return true if this declarator is missing a
/// return type because this is a omitted return type on a block literal.
//<editor-fold defaultstate="collapsed" desc="isOmittedBlockReturnType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 48,
 FQN="isOmittedBlockReturnType", NM="_ZL24isOmittedBlockReturnTypeRKN5clang10DeclaratorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZL24isOmittedBlockReturnTypeRKN5clang10DeclaratorE")
//</editor-fold>
public static boolean isOmittedBlockReturnType(final /*const*/ Declarator /*&*/ D) {
  if (D.getContext() != Declarator.TheContext.BlockLiteralContext
     || D.getDeclSpec().hasTypeSpecifier()) {
    return false;
  }
  if (D.getNumTypeObjects() == 0) {
    return true; // ^{ ... }
  }
  if (D.getNumTypeObjects() == 1
     && D.getTypeObject$Const(0).Kind == DeclaratorChunk.Unnamed_enum.Function) {
    return true; // ^(int X, float Y) { ... }
  }
  
  return false;
}


/// diagnoseBadTypeAttribute - Diagnoses a type attribute which
/// doesn't apply to the given type.
//<editor-fold defaultstate="collapsed" desc="diagnoseBadTypeAttribute">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 65,
 FQN="diagnoseBadTypeAttribute", NM="_ZL24diagnoseBadTypeAttributeRN5clang4SemaERKNS_13AttributeListENS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZL24diagnoseBadTypeAttributeRN5clang4SemaERKNS_13AttributeListENS_8QualTypeE")
//</editor-fold>
public static void diagnoseBadTypeAttribute(final Sema /*&*/ S, final /*const*/ AttributeList /*&*/ attr, 
                        QualType type) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    TypeDiagSelector WhichType;
    boolean useExpansionLoc = true;
    switch (attr.getKind()) {
     case AT_ObjCGC:
      WhichType = TypeDiagSelector.TDS_Pointer;
      break;
     case AT_ObjCOwnership:
      WhichType = TypeDiagSelector.TDS_ObjCObjOrBlock;
      break;
     default:
      // Assume everything else was a function attribute.
      WhichType = TypeDiagSelector.TDS_Function;
      useExpansionLoc = false;
      break;
    }
    
    SourceLocation loc = attr.getLoc();
    StringRef name = attr.getName().getName();
    
    // The GC attributes are usually written with macros;  special-case them.
    IdentifierInfo /*P*/ II = attr.isArgIdent(0) ? attr.getArgAsIdent(0).Ident : null;
    if (useExpansionLoc && loc.isMacroID() && (II != null)) {
      if (II.isStr(/*KEEP_STR*/"strong")) {
        if (S.findMacroSpelling(loc, new StringRef(/*KEEP_STR*/"__strong"))) {
          name.$assignMove(/*STRINGREF_STR*/"__strong");
        }
      } else if (II.isStr(/*KEEP_STR*/"weak")) {
        if (S.findMacroSpelling(loc, new StringRef(/*KEEP_STR*/"__weak"))) {
          name.$assignMove(/*STRINGREF_STR*/"__weak");
        }
      }
    }
    
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(loc), diag.warn_type_attribute_wrong_type)), name), WhichType), 
        type));
  } finally {
    $c$.$destroy();
  }
}

// end anonymous namespace
//<editor-fold defaultstate="collapsed" desc="spliceAttrIntoList">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 251,
 FQN="spliceAttrIntoList", NM="_ZL18spliceAttrIntoListRN5clang13AttributeListERPS0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZL18spliceAttrIntoListRN5clang13AttributeListERPS0_")
//</editor-fold>
public static void spliceAttrIntoList(final AttributeList /*&*/ attr, final type$ref<AttributeList/*P*/>/*&*/ head) {
  attr.setNext(head.$deref());
  head.$set($AddrOf(attr));
}

//<editor-fold defaultstate="collapsed" desc="spliceAttrOutOfList">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 256,
 FQN="spliceAttrOutOfList", NM="_ZL19spliceAttrOutOfListRN5clang13AttributeListERPS0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZL19spliceAttrOutOfListRN5clang13AttributeListERPS0_")
//</editor-fold>
public static void spliceAttrOutOfList(final AttributeList /*&*/ attr, final type$ref<AttributeList/*P*/>/*&*/ head) {
  if (head.$deref() == $AddrOf(attr)) {
    head.$set(attr.getNext());
    return;
  }
  
  AttributeList /*P*/ cur = head.$deref();
  while (true) {
    assert ((cur != null) && (cur.getNext() != null)) : "ran out of attrs?";
    if (cur.getNext() == $AddrOf(attr)) {
      cur.setNext(attr.getNext());
      return;
    }
    cur = cur.getNext();
  }
}

//<editor-fold defaultstate="collapsed" desc="moveAttrFromListToList">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 273,
 FQN="moveAttrFromListToList", NM="_ZL22moveAttrFromListToListRN5clang13AttributeListERPS0_S3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZL22moveAttrFromListToListRN5clang13AttributeListERPS0_S3_")
//</editor-fold>
public static void moveAttrFromListToList(final AttributeList /*&*/ attr, 
                      final type$ref<AttributeList/*P*/>/*&*/ fromList, 
                      final type$ref<AttributeList/*P*/>/*&*/ toList) {
  spliceAttrOutOfList(attr, fromList);
  spliceAttrIntoList(attr, toList);
}

//<editor-fold defaultstate="collapsed" desc="processTypeAttrs">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 6529,
 FQN="processTypeAttrs", NM="_ZL16processTypeAttrsRN12_GLOBAL__N_119TypeProcessingStateERN5clang8QualTypeE16TypeAttrLocationPNS2_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZL16processTypeAttrsRN12_GLOBAL__N_119TypeProcessingStateERN5clang8QualTypeE16TypeAttrLocationPNS2_13AttributeListE")
//</editor-fold>
public static void processTypeAttrs(final TypeProcessingState /*&*/ state, final QualType /*&*/ type, 
                TypeAttrLocation TAL, AttributeList /*P*/ attrs) {
  // Scan through and apply attributes to this type where it makes sense.  Some
  // attributes (such as __address_space__, __vector_size__, etc) apply to the
  // type, but others can be present in the type specifiers even though they
  // apply to the decl.  Here we apply type attributes and ignore the rest.
  boolean hasOpenCLAddressSpace = false;
  while ((attrs != null)) {
    final AttributeList /*&*/ attr = $Deref(attrs);
    attrs = attr.getNext(); // reset to the next here due to early loop continue
    // stmts
    
    // Skip attributes that were marked to be invalid.
    if (attr.isInvalid()) {
      continue;
    }
    if (attr.isCXX11Attribute()) {
      // [[gnu::...]] attributes are treated as declaration attributes, so may
      // not appertain to a DeclaratorChunk, even if we handle them as type
      // attributes.
      if ((attr.getScopeName() != null) && attr.getScopeName().isStr(/*KEEP_STR*/"gnu")) {
        if (TAL == TypeAttrLocation.TAL_DeclChunk) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(state.getSema().Diag(attr.getLoc(), 
                    diag.warn_cxx11_gnu_attribute_on_type)), 
                attr.getName()));
            continue;
          } finally {
            $c$.$destroy();
          }
        }
      } else if (TAL != TypeAttrLocation.TAL_DeclChunk) {
        // Otherwise, only consider type processing for a C++11 attribute if
        // it's actually been applied to a type.
        continue;
      }
    }
    
    // If this is an attribute we can handle, do so now,
    // otherwise, add it to the FnAttrs list for rechaining.
    switch (attr.getKind()) {
     default:
      // A C++11 attribute on a declarator chunk must appertain to a type.
      if (attr.isCXX11Attribute() && TAL == TypeAttrLocation.TAL_DeclChunk) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(state.getSema().Diag(attr.getLoc(), diag.err_attribute_not_type_attr)), 
              attr.getName()));
          attr.setUsedAsTypeAttr();
        } finally {
          $c$.$destroy();
        }
      }
      break;
     case UnknownAttribute:
      if (attr.isCXX11Attribute() && TAL == TypeAttrLocation.TAL_DeclChunk) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(state.getSema().Diag(attr.getLoc(), 
                  diag.warn_unknown_attribute_ignored)), 
              attr.getName()));
        } finally {
          $c$.$destroy();
        }
      }
      break;
     case IgnoredAttribute:
      break;
     case AT_MayAlias:
      // FIXME: This attribute needs to actually be handled, but if we ignore
      // it it breaks large amounts of Linux software.
      attr.setUsedAsTypeAttr();
      break;
     case AT_OpenCLPrivateAddressSpace:
     case AT_OpenCLGlobalAddressSpace:
     case AT_OpenCLLocalAddressSpace:
     case AT_OpenCLConstantAddressSpace:
     case AT_OpenCLGenericAddressSpace:
     case AT_AddressSpace:
      HandleAddressSpaceTypeAttribute(type, attr, state.getSema());
      attr.setUsedAsTypeAttr();
      hasOpenCLAddressSpace = true;
      break;
     case AT_ObjCGC:
     case AT_ObjCOwnership:
      if (!handleObjCPointerTypeAttr(state, attr, type)) {
        distributeObjCPointerTypeAttr(state, attr, new QualType(type));
      }
      attr.setUsedAsTypeAttr();
      break;
     case AT_VectorSize:
      HandleVectorSizeAttr(type, attr, state.getSema());
      attr.setUsedAsTypeAttr();
      break;
     case AT_ExtVectorType:
      HandleExtVectorTypeAttr(type, attr, state.getSema());
      attr.setUsedAsTypeAttr();
      break;
     case AT_NeonVectorType:
      HandleNeonVectorTypeAttr(type, attr, state.getSema(), 
          VectorType.VectorKind.NeonVector);
      attr.setUsedAsTypeAttr();
      break;
     case AT_NeonPolyVectorType:
      HandleNeonVectorTypeAttr(type, attr, state.getSema(), 
          VectorType.VectorKind.NeonPolyVector);
      attr.setUsedAsTypeAttr();
      break;
     case AT_OpenCLAccess:
      HandleOpenCLAccessAttr(type, attr, state.getSema());
      attr.setUsedAsTypeAttr();
      break;
     case AT_Ptr32:
     case AT_Ptr64:
     case AT_SPtr:
     case AT_UPtr:
      if (!handleMSPointerTypeQualifierAttr(state, attr, type)) {
        attr.setUsedAsTypeAttr();
      }
      break;
     case AT_TypeNonNull:
     case AT_TypeNullable:
     case AT_TypeNullUnspecified:
      // Either add nullability here or try to distribute it.  We
      // don't want to distribute the nullability specifier past any
      // dependent type, because that complicates the user model.
      if (type.$arrow().canHaveNullability() || type.$arrow().isDependentType()
         || !distributeNullabilityTypeAttr(state, new QualType(type), attr)) {
        if (state.getSema().checkNullabilityTypeSpecifier(type, 
            mapNullabilityAttrKind(attr.getKind()), 
            attr.getLoc(), 
            attr.isContextSensitiveKeywordAttribute())) {
          attr.setInvalid();
        }
        
        attr.setUsedAsTypeAttr();
      }
      break;
     case AT_ObjCKindOf:
      // '__kindof' must be part of the decl-specifiers.
      switch (TAL) {
       case TAL_DeclSpec:
        break;
       case TAL_DeclChunk:
       case TAL_DeclName:
        {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(state.getSema().Diag(attr.getLoc(), 
                        diag.err_objc_kindof_wrong_position)), 
                    FixItHint.CreateRemoval(new SourceRange(attr.getLoc()))), 
                FixItHint.CreateInsertion(state.getDeclarator().getDeclSpec().getLocStart(), new StringRef(/*KEEP_STR*/"__kindof "))));
            break;
          } finally {
            $c$.$destroy();
          }
        }
      }
      
      // Apply it regardless.
      if (state.getSema().checkObjCKindOfType(type, attr.getLoc())) {
        attr.setInvalid();
      }
      attr.setUsedAsTypeAttr();
      break;
     case AT_NSReturnsRetained:
      if (!state.getSema().getLangOpts().ObjCAutoRefCount) {
        break;
      }
     case AT_NoReturn:
     case AT_Regparm:
     case AT_CDecl:
     case AT_FastCall:
     case AT_StdCall:
     case AT_ThisCall:
     case AT_Pascal:
     case AT_SwiftCall:
     case AT_VectorCall:
     case AT_MSABI:
     case AT_SysVABI:
     case AT_Pcs:
     case AT_IntelOclBicc:
     case AT_PreserveMost:
     case AT_PreserveAll:
      // fallthrough into the function attrs
      attr.setUsedAsTypeAttr();
      
      // Never process function type attributes as part of the
      // declaration-specifiers.
      if (TAL == TypeAttrLocation.TAL_DeclSpec) {
        distributeFunctionTypeAttrFromDeclSpec(state, attr, type);
      } else 
      // Otherwise, handle the possible delays.
      if (!handleFunctionTypeAttr(state, attr, type)) {
        distributeFunctionTypeAttr(state, attr, new QualType(type));
      }
      break;
    }
  }
  
  // If address space is not set, OpenCL 2.0 defines non private default
  // address spaces for some cases:
  // OpenCL 2.0, section 6.5:
  // The address space for a variable at program scope or a static variable
  // inside a function can either be __global or __constant, but defaults to
  // __global if not specified.
  // (...)
  // Pointers that are declared without pointing to a named address space point
  // to the generic address space.
  if ($greatereq_uint(state.getSema().getLangOpts().OpenCLVersion, 200)
     && !hasOpenCLAddressSpace && type.getAddressSpace() == 0
     && (TAL == TypeAttrLocation.TAL_DeclSpec || TAL == TypeAttrLocation.TAL_DeclChunk)) {
    final Declarator /*&*/ D = state.getDeclarator();
    if ($greater_uint(state.getCurrentChunkIndex(), 0)
       && D.getTypeObject(state.getCurrentChunkIndex() - 1).Kind
       == DeclaratorChunk.Unnamed_enum.Pointer) {
      type.$assignMove(state.getSema().Context.getAddrSpaceQualType(new QualType(type), LangAS.ID.opencl_generic));
    } else if (state.getCurrentChunkIndex() == 0
       && D.getContext() == Declarator.TheContext.FileContext
       && !D.isFunctionDeclarator() && !D.isFunctionDefinition()
       && D.getDeclSpec().getStorageClassSpec() != DeclSpec.SCS.SCS_typedef
       && !type.$arrow().isSamplerT()) {
      type.$assignMove(state.getSema().Context.getAddrSpaceQualType(new QualType(type), LangAS.ID.opencl_global));
    } else if (state.getCurrentChunkIndex() == 0
       && D.getContext() == Declarator.TheContext.BlockContext
       && D.getDeclSpec().getStorageClassSpec() == DeclSpec.SCS.SCS_static) {
      type.$assignMove(state.getSema().Context.getAddrSpaceQualType(new QualType(type), LangAS.ID.opencl_global));
    }
  }
}


/// Process an individual function attribute.  Returns true to
/// indicate that the attribute was handled, false if it wasn't.
//<editor-fold defaultstate="collapsed" desc="handleFunctionTypeAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 6108,
 FQN="handleFunctionTypeAttr", NM="_ZL22handleFunctionTypeAttrRN12_GLOBAL__N_119TypeProcessingStateERN5clang13AttributeListERNS2_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZL22handleFunctionTypeAttrRN12_GLOBAL__N_119TypeProcessingStateERN5clang13AttributeListERNS2_8QualTypeE")
//</editor-fold>
public static boolean handleFunctionTypeAttr(final TypeProcessingState /*&*/ state, 
                      final AttributeList /*&*/ attr, 
                      final QualType /*&*/ type) {
  FunctionTypeUnwrapper unwrapped = null;
  try {
    final Sema /*&*/ S = state.getSema();
    
    unwrapped/*J*/= new FunctionTypeUnwrapper(S, new QualType(type));
    if (attr.getKind() == AttributeList.Kind.AT_NoReturn) {
      if (S.CheckNoReturnAttr(attr)) {
        return true;
      }
      
      // Delay if this is not a function type.
      if (!unwrapped.isFunctionType()) {
        return false;
      }
      
      // Otherwise we can process right away.
      FunctionType.ExtInfo EI = unwrapped.get().getExtInfo().withNoReturn(true);
      type.$assignMove(unwrapped.wrap(S, S.Context.adjustFunctionType(unwrapped.get(), new FunctionType.ExtInfo(EI))));
      return true;
    }
    
    // ns_returns_retained is not always a type attribute, but if we got
    // here, we're treating it as one right now.
    if (attr.getKind() == AttributeList.Kind.AT_NSReturnsRetained) {
      assert (S.getLangOpts().ObjCAutoRefCount) : "ns_returns_retained treated as type attribute in non-ARC";
      if ((attr.getNumArgs() != 0)) {
        return true;
      }
      
      // Delay if this is not a function type.
      if (!unwrapped.isFunctionType()) {
        return false;
      }
      
      FunctionType.ExtInfo EI = unwrapped.get().getExtInfo().withProducesResult(true);
      type.$assignMove(unwrapped.wrap(S, S.Context.adjustFunctionType(unwrapped.get(), new FunctionType.ExtInfo(EI))));
      return true;
    }
    if (attr.getKind() == AttributeList.Kind.AT_Regparm) {
      uint$ref value = create_uint$ref();
      if (S.CheckRegparmAttr(attr, value)) {
        return true;
      }
      
      // Delay if this is not a function type.
      if (!unwrapped.isFunctionType()) {
        return false;
      }
      
      // Diagnose regparm with fastcall.
      /*const*/ FunctionType /*P*/ fn = unwrapped.get();
      CallingConv CC = fn.getCallConv();
      if (CC == CallingConv.CC_X86FastCall) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(attr.getLoc(), diag.err_attributes_are_not_compatible)), 
                  FunctionType.getNameForCallConv(CC)), 
              /*KEEP_STR*/"regparm"));
          attr.setInvalid();
          return true;
        } finally {
          $c$.$destroy();
        }
      }
      
      FunctionType.ExtInfo EI = unwrapped.get().getExtInfo().withRegParm(value.$deref());
      type.$assignMove(unwrapped.wrap(S, S.Context.adjustFunctionType(unwrapped.get(), new FunctionType.ExtInfo(EI))));
      return true;
    }
    
    // Delay if the type didn't work out to a function.
    if (!unwrapped.isFunctionType()) {
      return false;
    }
    
    // Otherwise, a calling convention.
    type$ref<CallingConv> CCref = new type$ref$single<CallingConv>();
    if (S.CheckCallingConvAttr(attr, CCref)) {
      return true;
    }
    CallingConv CC = CCref.$deref();
    
    /*const*/ FunctionType /*P*/ fn = unwrapped.get();
    CallingConv CCOld = fn.getCallConv();
    AttributedType.Kind CCAttrKind = getCCTypeAttrKind(attr);
    if (CCOld != CC) {
      // Error out on when there's already an attribute on the type
      // and the CCs don't match.
      /*const*/ AttributedType /*P*/ AT = S.getCallingConvAttributedType(new QualType(type));
      if ((AT != null) && AT.getAttrKind() != CCAttrKind) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(attr.getLoc(), diag.err_attributes_are_not_compatible)), 
                  FunctionType.getNameForCallConv(CC)), 
              FunctionType.getNameForCallConv(CCOld)));
          attr.setInvalid();
          return true;
        } finally {
          $c$.$destroy();
        }
      }
    }
    
    // Diagnose use of variadic functions with calling conventions that
    // don't support them (e.g. because they're callee-cleanup).
    // We delay warning about this on unprototyped function declarations
    // until after redeclaration checking, just in case we pick up a
    // prototype that way.  And apparently we also "delay" warning about
    // unprototyped function types in general, despite not necessarily having
    // much ability to diagnose it later.
    if (!supportsVariadicCall(CC)) {
      /*const*/ FunctionProtoType /*P*/ FnP = dyn_cast_FunctionProtoType(fn);
      if ((FnP != null) && FnP.isVariadic()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          /*uint*/int DiagID = diag.err_cconv_varargs;
          
          // stdcall and fastcall are ignored with a warning for GCC and MS
          // compatibility.
          boolean IsInvalid = true;
          if (CC == CallingConv.CC_X86StdCall || CC == CallingConv.CC_X86FastCall) {
            DiagID = diag.warn_cconv_varargs;
            IsInvalid = false;
          }
          
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(attr.getLoc(), DiagID)), FunctionType.getNameForCallConv(CC)));
          if (IsInvalid) {
            attr.setInvalid();
          }
          return true;
        } finally {
          $c$.$destroy();
        }
      }
    }
    
    // Also diagnose fastcall with regparm.
    if (CC == CallingConv.CC_X86FastCall && fn.getHasRegParm()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(attr.getLoc(), diag.err_attributes_are_not_compatible)), 
                /*KEEP_STR*/"regparm"), FunctionType.getNameForCallConv(CallingConv.CC_X86FastCall)));
        attr.setInvalid();
        return true;
      } finally {
        $c$.$destroy();
      }
    }
    
    // Modify the CC from the wrapped function type, wrap it all back, and then
    // wrap the whole thing in an AttributedType as written.  The modified type
    // might have a different CC if we ignored the attribute.
    QualType Equivalent/*J*/= new QualType();
    if (CCOld == CC) {
      Equivalent.$assign(type);
    } else {
      ExtInfo EI = unwrapped.get().getExtInfo().withCallingConv(CC);
      Equivalent.$assignMove(
          unwrapped.wrap(S, S.Context.adjustFunctionType(unwrapped.get(), new FunctionType.ExtInfo(EI)))
      );
    }
    type.$assignMove(S.Context.getAttributedType(CCAttrKind, new QualType(type), new QualType(Equivalent)));
    return true;
  } finally {
    if (unwrapped != null) { unwrapped.$destroy(); }
  }
}

// end anonymous namespace
//<editor-fold defaultstate="collapsed" desc="handleMSPointerTypeQualifierAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 5745,
 FQN="handleMSPointerTypeQualifierAttr", NM="_ZL32handleMSPointerTypeQualifierAttrRN12_GLOBAL__N_119TypeProcessingStateERN5clang13AttributeListERNS2_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZL32handleMSPointerTypeQualifierAttrRN12_GLOBAL__N_119TypeProcessingStateERN5clang13AttributeListERNS2_8QualTypeE")
//</editor-fold>
public static boolean handleMSPointerTypeQualifierAttr(final TypeProcessingState /*&*/ State, 
                                final AttributeList /*&*/ Attr, 
                                final QualType /*&*/ Type) {
  final Sema /*&*/ S = State.getSema();
  
  AttributeList.Kind Kind = Attr.getKind();
  QualType Desugared = new QualType(Type);
  /*const*/ AttributedType /*P*/ AT = dyn_cast_AttributedType(Type);
  while ((AT != null)) {
    AttributedType.Kind CurAttrKind = AT.getAttrKind();
    
    // You cannot specify duplicate type attributes, so if the attribute has
    // already been applied, flag it.
    if (getAttrListKind(CurAttrKind) == Kind) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.warn_duplicate_attribute_exact)), 
            Attr.getName()));
        return true;
      } finally {
        $c$.$destroy();
      }
    }
    
    // You cannot have both __sptr and __uptr on the same type, nor can you
    // have __ptr32 and __ptr64.
    if ((CurAttrKind == AttributedType.Kind.attr_ptr32
       && Kind == AttributeList.Kind.AT_Ptr64)
       || (CurAttrKind == AttributedType.Kind.attr_ptr64
       && Kind == AttributeList.Kind.AT_Ptr32)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_attributes_are_not_compatible)), 
                /*KEEP_STR*/"'__ptr32'"), /*KEEP_STR*/"'__ptr64'"));
        return true;
      } finally {
        $c$.$destroy();
      }
    } else if ((CurAttrKind == AttributedType.Kind.attr_sptr
       && Kind == AttributeList.Kind.AT_UPtr)
       || (CurAttrKind == AttributedType.Kind.attr_uptr
       && Kind == AttributeList.Kind.AT_SPtr)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_attributes_are_not_compatible)), 
                /*KEEP_STR*/"'__sptr'"), /*KEEP_STR*/"'__uptr'"));
        return true;
      } finally {
        $c$.$destroy();
      }
    }
    
    Desugared.$assignMove(AT.getEquivalentType());
    AT = dyn_cast_AttributedType(Desugared);
  }
  
  // Pointer type qualifiers can only operate on pointer types, but not
  // pointer-to-member types.
  if (!isa_PointerType(Desugared)) {
    if (Type.$arrow().isMemberPointerType()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_attribute_no_member_pointers)), 
            Attr.getName()));
      } finally {
        $c$.$destroy();
      }
    } else {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_attribute_pointers_only)), 
                Attr.getName()), 0));
      } finally {
        $c$.$destroy();
      }
    }
    return true;
  }
  
  AttributedType.Kind TAK;
  switch (Kind) {
   default:
    throw new llvm_unreachable("Unknown attribute kind");
   case AT_Ptr32:
    TAK = AttributedType.Kind.attr_ptr32;
    break;
   case AT_Ptr64:
    TAK = AttributedType.Kind.attr_ptr64;
    break;
   case AT_SPtr:
    TAK = AttributedType.Kind.attr_sptr;
    break;
   case AT_UPtr:
    TAK = AttributedType.Kind.attr_uptr;
    break;
  }
  
  Type.$assignMove(S.Context.getAttributedType(TAK, new QualType(Type), new QualType(Type)));
  return false;
}


/// handleObjCGCTypeAttr - Process the __attribute__((objc_gc)) type
/// attribute on the specified type.  Returns true to indicate that
/// the attribute was handled, false to indicate that the type does
/// not permit the attribute.
//<editor-fold defaultstate="collapsed" desc="handleObjCGCTypeAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 5553,
 FQN="handleObjCGCTypeAttr", NM="_ZL20handleObjCGCTypeAttrRN12_GLOBAL__N_119TypeProcessingStateERN5clang13AttributeListERNS2_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZL20handleObjCGCTypeAttrRN12_GLOBAL__N_119TypeProcessingStateERN5clang13AttributeListERNS2_8QualTypeE")
//</editor-fold>
public static boolean handleObjCGCTypeAttr(final TypeProcessingState /*&*/ state, 
                    final AttributeList /*&*/ attr, 
                    final QualType /*&*/ type) {
  final Sema /*&*/ S = state.getSema();
  
  // Delay if this isn't some kind of pointer.
  if (!type.$arrow().isPointerType()
     && !type.$arrow().isObjCObjectPointerType()
     && !type.$arrow().isBlockPointerType()) {
    return false;
  }
  if (type.getObjCGCAttr() != Qualifiers.GC.GCNone) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track(S.Diag(attr.getLoc(), diag.err_attribute_multiple_objc_gc)));
      attr.setInvalid();
      return true;
    } finally {
      $c$.$destroy();
    }
  }
  
  // Check the attribute arguments.
  if (!attr.isArgIdent(0)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(attr.getLoc(), diag.err_attribute_argument_type)), 
              attr.getName()), AttributeArgumentNType.AANT_ArgumentString));
      attr.setInvalid();
      return true;
    } finally {
      $c$.$destroy();
    }
  }
  Qualifiers.GC GCAttr;
  if ($greater_uint(attr.getNumArgs(), 1)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(attr.getLoc(), diag.err_attribute_wrong_number_arguments)), 
              attr.getName()), 1));
      attr.setInvalid();
      return true;
    } finally {
      $c$.$destroy();
    }
  }
  
  IdentifierInfo /*P*/ II = attr.getArgAsIdent(0).Ident;
  if (II.isStr(/*KEEP_STR*/"weak")) {
    GCAttr = Qualifiers.GC.Weak;
  } else if (II.isStr(/*KEEP_STR*/"strong")) {
    GCAttr = Qualifiers.GC.Strong;
  } else {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(attr.getLoc(), diag.warn_attribute_type_not_supported)), 
              attr.getName()), II));
      attr.setInvalid();
      return true;
    } finally {
      $c$.$destroy();
    }
  }
  
  QualType origType = new QualType(type);
  type.$assignMove(S.Context.getObjCGCQualType(new QualType(origType), GCAttr));
  
  // Make an attributed type to preserve the source information.
  if (attr.getLoc().isValid()) {
    type.$assignMove(S.Context.getAttributedType(AttributedType.Kind.attr_objc_gc, 
            new QualType(origType), new QualType(type)));
  }
  
  return true;
}


/// handleObjCOwnershipTypeAttr - Process an objc_ownership
/// attribute on the specified type.
///
/// Returns 'true' if the attribute was handled.
//<editor-fold defaultstate="collapsed" desc="handleObjCOwnershipTypeAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 5367,
 FQN="handleObjCOwnershipTypeAttr", NM="_ZL27handleObjCOwnershipTypeAttrRN12_GLOBAL__N_119TypeProcessingStateERN5clang13AttributeListERNS2_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZL27handleObjCOwnershipTypeAttrRN12_GLOBAL__N_119TypeProcessingStateERN5clang13AttributeListERNS2_8QualTypeE")
//</editor-fold>
public static boolean handleObjCOwnershipTypeAttr(final TypeProcessingState /*&*/ state, 
                           final AttributeList /*&*/ attr, 
                           final QualType /*&*/ type) {
  boolean NonObjCPointer = false;
  if (!type.$arrow().isDependentType() && !type.$arrow().isUndeducedType()) {
    {
      /*const*/ PointerType /*P*/ ptr = type.$arrow().getAs(PointerType.class);
      if ((ptr != null)) {
        QualType pointee = ptr.getPointeeType();
        if (pointee.$arrow().isObjCRetainableType() || pointee.$arrow().isPointerType()) {
          return false;
        }
        // It is important not to lose the source info that there was an attribute
        // applied to non-objc pointer. We will create an attributed type but
        // its type will be the same as the original type.
        NonObjCPointer = true;
      } else if (!type.$arrow().isObjCRetainableType()) {
        return false;
      }
    }
    
    // Don't accept an ownership attribute in the declspec if it would
    // just be the return type of a block pointer.
    if (state.isProcessingDeclSpec()) {
      final Declarator /*&*/ D = state.getDeclarator();
      if ((maybeMovePastReturnType(D, D.getNumTypeObjects(), 
          /*onlyBlockPointers=*/ true) != null)) {
        return false;
      }
    }
  }
  
  final Sema /*&*/ S = state.getSema();
  SourceLocation AttrLoc = attr.getLoc();
  if (AttrLoc.isMacroID()) {
    AttrLoc.$assignMove(S.getSourceManager().getImmediateExpansionRange(/*NO_COPY*/AttrLoc).first);
  }
  if (!attr.isArgIdent(0)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(AttrLoc), diag.err_attribute_argument_type)), 
              attr.getName()), AttributeArgumentNType.AANT_ArgumentString));
      attr.setInvalid();
      return true;
    } finally {
      $c$.$destroy();
    }
  }
  
  IdentifierInfo /*P*/ II = attr.getArgAsIdent(0).Ident;
  Qualifiers.ObjCLifetime lifetime;
  if (II.isStr(/*KEEP_STR*/"none")) {
    lifetime = Qualifiers.ObjCLifetime.OCL_ExplicitNone;
  } else if (II.isStr(/*KEEP_STR*/"strong")) {
    lifetime = Qualifiers.ObjCLifetime.OCL_Strong;
  } else if (II.isStr(/*KEEP_STR*/"weak")) {
    lifetime = Qualifiers.ObjCLifetime.OCL_Weak;
  } else if (II.isStr(/*KEEP_STR*/"autoreleasing")) {
    lifetime = Qualifiers.ObjCLifetime.OCL_Autoreleasing;
  } else {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(AttrLoc), diag.warn_attribute_type_not_supported)), 
              attr.getName()), II));
      attr.setInvalid();
      return true;
    } finally {
      $c$.$destroy();
    }
  }
  
  // Just ignore lifetime attributes other than __weak and __unsafe_unretained
  // outside of ARC mode.
  if (!S.getLangOpts().ObjCAutoRefCount
     && lifetime != Qualifiers.ObjCLifetime.OCL_Weak
     && lifetime != Qualifiers.ObjCLifetime.OCL_ExplicitNone) {
    return true;
  }
  
  SplitQualType underlyingType = type.split();
  {
    
    // Check for redundant/conflicting ownership qualifiers.
    Qualifiers.ObjCLifetime previousLifetime = type.getQualifiers().getObjCLifetime();
    if ((previousLifetime.getValue() != 0)) {
      // If it's written directly, that's an error.
      if (hasDirectOwnershipQualifier(new QualType(type))) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(AttrLoc), diag.err_attr_objc_ownership_redundant)), 
              type));
          return true;
        } finally {
          $c$.$destroy();
        }
      }
      
      // Otherwise, if the qualifiers actually conflict, pull sugar off
      // and remove the ObjCLifetime qualifiers.
      if (previousLifetime != lifetime) {
        // It's possible to have multiple local ObjCLifetime qualifiers. We
        // can't stop after we reach a type that is directly qualified.
        /*const*/ Type /*P*/ prevTy = null;
        while (!(prevTy != null) || prevTy != underlyingType.Ty) {
          prevTy = underlyingType.Ty;
          underlyingType.$assignMove(underlyingType.getSingleStepDesugaredType());
        }
        underlyingType.Quals.removeObjCLifetime();
      }
    }
  }
  
  underlyingType.Quals.addObjCLifetime(lifetime);
  if (NonObjCPointer) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      StringRef name = attr.getName().getName();
      switch (lifetime) {
       case OCL_None:
       case OCL_ExplicitNone:
        break;
       case OCL_Strong:
        name.$assignMove(/*STRINGREF_STR*/"__strong");
        break;
       case OCL_Weak:
        name.$assignMove(/*STRINGREF_STR*/"__weak");
        break;
       case OCL_Autoreleasing:
        name.$assignMove(/*STRINGREF_STR*/"__autoreleasing");
        break;
      }
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(AttrLoc), diag.warn_type_attribute_wrong_type)), name), 
              TypeDiagSelector.TDS_ObjCObjOrBlock), type));
    } finally {
      $c$.$destroy();
    }
  }
  
  // Don't actually add the __unsafe_unretained qualifier in non-ARC files,
  // because having both 'T' and '__unsafe_unretained T' exist in the type
  // system causes unfortunate widespread consistency problems.  (For example,
  // they're not considered compatible types, and we mangle them identicially
  // as template arguments.)  These problems are all individually fixable,
  // but it's easier to just not add the qualifier and instead sniff it out
  // in specific places using isObjCInertUnsafeUnretainedType().
  //
  // Doing this does means we miss some trivial consistency checks that
  // would've triggered in ARC, but that's better than trying to solve all
  // the coexistence problems with __unsafe_unretained.
  if (!S.getLangOpts().ObjCAutoRefCount
     && lifetime == Qualifiers.ObjCLifetime.OCL_ExplicitNone) {
    type.$assignMove(S.Context.getAttributedType(AttributedType.Kind.attr_objc_inert_unsafe_unretained, 
            new QualType(type), new QualType(type)));
    return true;
  }
  
  QualType origType = new QualType(type);
  if (!NonObjCPointer) {
    type.$assignMove(S.Context.getQualifiedType(new SplitQualType(underlyingType)));
  }
  
  // If we have a valid source location for the attribute, use an
  // AttributedType instead.
  if (AttrLoc.isValid()) {
    type.$assignMove(S.Context.getAttributedType(AttributedType.Kind.attr_objc_ownership, 
            new QualType(origType), new QualType(type)));
  }
  
  SemaSourceLocationUnsignedQualType2Void diagnoseOrDelay = (_S, loc, diagnostic, _type) -> 
    {
      if (_S.DelayedDiagnostics.shouldDelayDiagnostics()) {
        _S.DelayedDiagnostics.add(DelayedDiagnostic.makeForbiddenType(_S.getSourceManager().getExpansionLoc(/*NO_COPY*/loc), 
                diagnostic, new QualType(_type), /*ignored*/ 0));
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track(_S.Diag(new SourceLocation(loc), diagnostic)));
        } finally {
          $c$.$destroy();
        }
      }
    }
;
  
  // Sometimes, __weak isn't allowed.
  if (lifetime == Qualifiers.ObjCLifetime.OCL_Weak
     && !S.getLangOpts().ObjCWeak && !NonObjCPointer) {
    
    // Use a specialized diagnostic if the runtime just doesn't support them.
    /*uint*/int diagnostic = (S.getLangOpts().ObjCWeakRuntime ? diag.err_arc_weak_disabled : diag.err_arc_weak_no_runtime);
    
    // In any case, delay the diagnostic until we know what we're parsing.
    diagnoseOrDelay.$call(S, /*NO_COPY*/AttrLoc, diagnostic, /*NO_COPY*/type);
    
    attr.setInvalid();
    return true;
  }
  
  // Forbid __weak for class objects marked as
  // objc_arc_weak_reference_unavailable
  if (lifetime == Qualifiers.ObjCLifetime.OCL_Weak) {
    {
      /*const*/ ObjCObjectPointerType /*P*/ ObjT = type.$arrow().getAs(ObjCObjectPointerType.class);
      if ((ObjT != null)) {
        {
          ObjCInterfaceDecl /*P*/ Class = ObjT.getInterfaceDecl();
          if ((Class != null)) {
            if (Class.isArcWeakrefUnavailable()) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                $c$.clean($c$.track(S.Diag(new SourceLocation(AttrLoc), diag.err_arc_unsupported_weak_class)));
                $c$.clean($c$.track(S.Diag(ObjT.getInterfaceDecl().getLocation(), 
                    diag.note_class_declared)));
              } finally {
                $c$.$destroy();
              }
            }
          }
        }
      }
    }
  }
  
  return true;
}

//<editor-fold defaultstate="collapsed" desc="handleObjCPointerTypeAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 308,
 FQN="handleObjCPointerTypeAttr", NM="_ZL25handleObjCPointerTypeAttrRN12_GLOBAL__N_119TypeProcessingStateERN5clang13AttributeListERNS2_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZL25handleObjCPointerTypeAttrRN12_GLOBAL__N_119TypeProcessingStateERN5clang13AttributeListERNS2_8QualTypeE")
//</editor-fold>
public static boolean handleObjCPointerTypeAttr(final TypeProcessingState /*&*/ state, 
                         final AttributeList /*&*/ attr, final QualType /*&*/ type) {
  if (attr.getKind() == AttributeList.Kind.AT_ObjCGC) {
    return handleObjCGCTypeAttr(state, attr, type);
  }
  assert (attr.getKind() == AttributeList.Kind.AT_ObjCOwnership);
  return handleObjCOwnershipTypeAttr(state, attr, type);
}


/// Given the index of a declarator chunk, check whether that chunk
/// directly specifies the return type of a function and, if so, find
/// an appropriate place for it.
///
/// \param i - a notional index which the search will start
///   immediately inside
///
/// \param onlyBlockPointers Whether we should only look into block
/// pointer types (vs. all pointer types).
//<editor-fold defaultstate="collapsed" desc="maybeMovePastReturnType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 325,
 FQN="maybeMovePastReturnType", NM="_ZL23maybeMovePastReturnTypeRN5clang10DeclaratorEjb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZL23maybeMovePastReturnTypeRN5clang10DeclaratorEjb")
//</editor-fold>
public static DeclaratorChunk /*P*/ maybeMovePastReturnType(final Declarator /*&*/ declarator, 
                       /*uint*/int i, 
                       boolean onlyBlockPointers) {
  assert ($lesseq_uint(i, declarator.getNumTypeObjects()));
  
  DeclaratorChunk /*P*/ result = null;
  
  // First, look inwards past parens for a function declarator.
  continue_outer: for (; i != 0; --i) {
    final DeclaratorChunk /*&*/ fnChunk = declarator.getTypeObject(i - 1);
    switch (fnChunk.Kind) {
     case Paren:
      continue;
     case Pointer:
     case BlockPointer:
     case Array:
     case Reference:
     case MemberPointer:
     case Pipe:
      
      // If we find anything except a function, bail out.
      return result;
     case Function:
      
      // If we do find a function declarator, scan inwards from that,
      // looking for a (block-)pointer declarator.
      for (--i; i != 0; --i) {
        final DeclaratorChunk /*&*/ ptrChunk = declarator.getTypeObject(i - 1);
        switch (ptrChunk.Kind) {
         case Paren:
         case Array:
         case Function:
         case Reference:
         case Pipe:
          continue;
         case MemberPointer:
         case Pointer:
          if (onlyBlockPointers) {
            continue;
          }
         case BlockPointer:
          
          // fallthrough
          result = $AddrOf(ptrChunk);
          continue continue_outer;
        }
        throw new llvm_unreachable("bad declarator chunk kind");
      }
      
      // If we run out of declarators doing that, we're done.
      return result;
    }
    throw new llvm_unreachable("bad declarator chunk kind");
   //continue_outer:
    
    // Okay, reconsider from our new point.
    //;
  }
  
  // Ran out of chunks, bail out.
  return result;
}


/// Given that an objc_gc attribute was written somewhere on a
/// declaration *other* than on the declarator itself (for which, use
/// distributeObjCPointerTypeAttrFromDeclarator), and given that it
/// didn't apply in whatever position it was written in, try to move
/// it to a more appropriate position.
//<editor-fold defaultstate="collapsed" desc="distributeObjCPointerTypeAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 393,
 FQN="distributeObjCPointerTypeAttr", NM="_ZL29distributeObjCPointerTypeAttrRN12_GLOBAL__N_119TypeProcessingStateERN5clang13AttributeListENS2_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZL29distributeObjCPointerTypeAttrRN12_GLOBAL__N_119TypeProcessingStateERN5clang13AttributeListENS2_8QualTypeE")
//</editor-fold>
public static void distributeObjCPointerTypeAttr(final TypeProcessingState /*&*/ state, 
                             final AttributeList /*&*/ attr, 
                             QualType type) {
  final Declarator /*&*/ declarator = state.getDeclarator();
  
  // Move it to the outermost normal or block pointer declarator.
  error: for (/*uint*/int i = state.getCurrentChunkIndex(); i != 0; --i) {
    final DeclaratorChunk /*&*/ chunk = declarator.getTypeObject(i - 1);
    switch (chunk.Kind) {
     case Pointer:
     case BlockPointer:
      {
        // But don't move an ARC ownership attribute to the return type
        // of a block.
        DeclaratorChunk /*P*/ destChunk = null;
        if (state.isProcessingDeclSpec()
           && attr.getKind() == AttributeList.Kind.AT_ObjCOwnership) {
          destChunk = maybeMovePastReturnType(declarator, i - 1, 
              /*onlyBlockPointers=*/ true);
        }
        if (!(destChunk != null)) {
          destChunk = $AddrOf(chunk);
        }
        
        moveAttrFromListToList(attr, state.getCurrentAttrListRef(), 
            destChunk.getAttrListRef());
        return;
      }
     case Paren:
     case Array:
      continue;
     case Function:
      
      // We may be starting at the return type of a block.
      if (state.isProcessingDeclSpec()
         && attr.getKind() == AttributeList.Kind.AT_ObjCOwnership) {
        {
          DeclaratorChunk /*P*/ dest = maybeMovePastReturnType(declarator, i, 
              /*onlyBlockPointers=*/ true);
          if ((dest != null)) {
            moveAttrFromListToList(attr, state.getCurrentAttrListRef(), 
                dest.getAttrListRef());
            return;
          }
        }
      }
      break error;
     case Reference:
     case MemberPointer:
     case Pipe:
      
      // Don't walk through these.
      break error;
    }
  }
 //error:
  
  diagnoseBadTypeAttribute(state.getSema(), attr, new QualType(type));
}


/// Distribute an objc_gc type attribute that was written on the
/// declarator.
//<editor-fold defaultstate="collapsed" desc="distributeObjCPointerTypeAttrFromDeclarator">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 450,
 FQN="distributeObjCPointerTypeAttrFromDeclarator", NM="_ZL43distributeObjCPointerTypeAttrFromDeclaratorRN12_GLOBAL__N_119TypeProcessingStateERN5clang13AttributeListERNS2_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZL43distributeObjCPointerTypeAttrFromDeclaratorRN12_GLOBAL__N_119TypeProcessingStateERN5clang13AttributeListERNS2_8QualTypeE")
//</editor-fold>
public static void distributeObjCPointerTypeAttrFromDeclarator(final TypeProcessingState /*&*/ state, 
                                           final AttributeList /*&*/ attr, 
                                           final QualType /*&*/ declSpecType) {
  final Declarator /*&*/ declarator = state.getDeclarator();
  
  // objc_gc goes on the innermost pointer to something that's not a
  // pointer.
  /*uint*/int innermost = -1/*U*/;
  boolean considerDeclSpec = true;
  done: for (/*uint*/int i = 0, e = declarator.getNumTypeObjects(); i != e; ++i) {
    final DeclaratorChunk /*&*/ chunk = declarator.getTypeObject(i);
    switch (chunk.Kind) {
     case Pointer:
     case BlockPointer:
      innermost = i;
      continue;
     case Reference:
     case MemberPointer:
     case Paren:
     case Array:
     case Pipe:
      continue;
     case Function:
      considerDeclSpec = false;
      break done;
    }
  }
 //done:
  
  // That might actually be the decl spec if we weren't blocked by
  // anything in the declarator.
  if (considerDeclSpec) {
    if (handleObjCPointerTypeAttr(state, attr, declSpecType)) {
      // Splice the attribute into the decl spec.  Prevents the
      // attribute from being applied multiple times and gives
      // the source-location-filler something to work with.
      state.saveDeclSpecAttrs();
      moveAttrFromListToList(attr, declarator.getAttrListRef(), 
          declarator.getMutableDeclSpec().getAttributes().getListRef());
      return;
    }
  }
  
  // Otherwise, if we found an appropriate chunk, splice the attribute
  // into it.
  if (innermost != -1/*U*/) {
    moveAttrFromListToList(attr, declarator.getAttrListRef(), 
        declarator.getTypeObject(innermost).getAttrListRef());
    return;
  }
  
  // Otherwise, diagnose when we're done building the type.
  spliceAttrOutOfList(attr, declarator.getAttrListRef());
  state.addIgnoredTypeAttr(attr);
}


/// A function type attribute was written somewhere in a declaration
/// *other* than on the declarator itself or in the decl spec.  Given
/// that it didn't apply in whatever position it was written in, try
/// to move it to a more appropriate position.
//<editor-fold defaultstate="collapsed" desc="distributeFunctionTypeAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 513,
 FQN="distributeFunctionTypeAttr", NM="_ZL26distributeFunctionTypeAttrRN12_GLOBAL__N_119TypeProcessingStateERN5clang13AttributeListENS2_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZL26distributeFunctionTypeAttrRN12_GLOBAL__N_119TypeProcessingStateERN5clang13AttributeListENS2_8QualTypeE")
//</editor-fold>
public static void distributeFunctionTypeAttr(final TypeProcessingState /*&*/ state, 
                          final AttributeList /*&*/ attr, 
                          QualType type) {
  final Declarator /*&*/ declarator = state.getDeclarator();
  
  // Try to push the attribute from the return type of a function to
  // the function itself.
  for (/*uint*/int i = state.getCurrentChunkIndex(); i != 0; --i) {
    final DeclaratorChunk /*&*/ chunk = declarator.getTypeObject(i - 1);
    switch (chunk.Kind) {
     case Function:
      moveAttrFromListToList(attr, state.getCurrentAttrListRef(), 
          chunk.getAttrListRef());
      return;
     case Paren:
     case Pointer:
     case BlockPointer:
     case Array:
     case Reference:
     case MemberPointer:
     case Pipe:
      continue;
    }
  }
  
  diagnoseBadTypeAttribute(state.getSema(), attr, new QualType(type));
}


/// Try to distribute a function type attribute to the innermost
/// function chunk or type.  Returns true if the attribute was
/// distributed, false if no location was found.
//<editor-fold defaultstate="collapsed" desc="distributeFunctionTypeAttrToInnermost">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 545,
 FQN="distributeFunctionTypeAttrToInnermost", NM="_ZL37distributeFunctionTypeAttrToInnermostRN12_GLOBAL__N_119TypeProcessingStateERN5clang13AttributeListERPS3_RNS2_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZL37distributeFunctionTypeAttrToInnermostRN12_GLOBAL__N_119TypeProcessingStateERN5clang13AttributeListERPS3_RNS2_8QualTypeE")
//</editor-fold>
public static boolean distributeFunctionTypeAttrToInnermost(final TypeProcessingState /*&*/ state, 
                                     final AttributeList /*&*/ attr, 
                                     final type$ref<AttributeList/*P*/>/*&*/ attrList, 
                                     final QualType /*&*/ declSpecType) {
  final Declarator /*&*/ declarator = state.getDeclarator();
  
  // Put it on the innermost function chunk, if there is one.
  for (/*uint*/int i = 0, e = declarator.getNumTypeObjects(); i != e; ++i) {
    final DeclaratorChunk /*&*/ chunk = declarator.getTypeObject(i);
    if (chunk.Kind != DeclaratorChunk.Unnamed_enum.Function) {
      continue;
    }
    
    moveAttrFromListToList(attr, attrList, chunk.getAttrListRef());
    return true;
  }
  
  return handleFunctionTypeAttr(state, attr, declSpecType);
}


/// A function type attribute was written in the decl spec.  Try to
/// apply it somewhere.
//<editor-fold defaultstate="collapsed" desc="distributeFunctionTypeAttrFromDeclSpec">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 566,
 FQN="distributeFunctionTypeAttrFromDeclSpec", NM="_ZL38distributeFunctionTypeAttrFromDeclSpecRN12_GLOBAL__N_119TypeProcessingStateERN5clang13AttributeListERNS2_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZL38distributeFunctionTypeAttrFromDeclSpecRN12_GLOBAL__N_119TypeProcessingStateERN5clang13AttributeListERNS2_8QualTypeE")
//</editor-fold>
public static void distributeFunctionTypeAttrFromDeclSpec(final TypeProcessingState /*&*/ state, 
                                      final AttributeList /*&*/ attr, 
                                      final QualType /*&*/ declSpecType) {
  state.saveDeclSpecAttrs();
  
  // C++11 attributes before the decl specifiers actually appertain to
  // the declarators. Move them straight there. We don't support the
  // 'put them wherever you like' semantics we allow for GNU attributes.
  if (attr.isCXX11Attribute()) {
    moveAttrFromListToList(attr, state.getCurrentAttrListRef(), 
        state.getDeclarator().getAttrListRef());
    return;
  }
  
  // Try to distribute to the innermost.
  if (distributeFunctionTypeAttrToInnermost(state, attr, 
      state.getCurrentAttrListRef(), 
      declSpecType)) {
    return;
  }
  
  // If that failed, diagnose the bad attribute when the declarator is
  // fully built.
  state.addIgnoredTypeAttr(attr);
}


/// A function type attribute was written on the declarator.  Try to
/// apply it somewhere.
//<editor-fold defaultstate="collapsed" desc="distributeFunctionTypeAttrFromDeclarator">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 594,
 FQN="distributeFunctionTypeAttrFromDeclarator", NM="_ZL40distributeFunctionTypeAttrFromDeclaratorRN12_GLOBAL__N_119TypeProcessingStateERN5clang13AttributeListERNS2_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZL40distributeFunctionTypeAttrFromDeclaratorRN12_GLOBAL__N_119TypeProcessingStateERN5clang13AttributeListERNS2_8QualTypeE")
//</editor-fold>
public static void distributeFunctionTypeAttrFromDeclarator(final TypeProcessingState /*&*/ state, 
                                        final AttributeList /*&*/ attr, 
                                        final QualType /*&*/ declSpecType) {
  final Declarator /*&*/ declarator = state.getDeclarator();
  
  // Try to distribute to the innermost.
  if (distributeFunctionTypeAttrToInnermost(state, attr, 
      declarator.getAttrListRef(), 
      declSpecType)) {
    return;
  }
  
  // If that failed, diagnose the bad attribute when the declarator is
  // fully built.
  spliceAttrOutOfList(attr, declarator.getAttrListRef());
  state.addIgnoredTypeAttr(attr);
}


/// \brief Given that there are attributes written on the declarator
/// itself, try to distribute any type attributes to the appropriate
/// declarator chunk.
///
/// These are attributes like the following:
///   int f ATTR;
///   int (f ATTR)();
/// but not necessarily this:
///   int f() ATTR;
//<editor-fold defaultstate="collapsed" desc="distributeTypeAttrsFromDeclarator">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 621,
 FQN="distributeTypeAttrsFromDeclarator", NM="_ZL33distributeTypeAttrsFromDeclaratorRN12_GLOBAL__N_119TypeProcessingStateERN5clang8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZL33distributeTypeAttrsFromDeclaratorRN12_GLOBAL__N_119TypeProcessingStateERN5clang8QualTypeE")
//</editor-fold>
public static void distributeTypeAttrsFromDeclarator(final TypeProcessingState /*&*/ state, 
                                 final QualType /*&*/ declSpecType) {
  // Collect all the type attributes from the declarator itself.
  assert ((state.getDeclarator().getAttributes() != null)) : "declarator has no attrs!";
  AttributeList /*P*/ attr = state.getDeclarator().getAttributes();
  AttributeList /*P*/ next;
  do {
    next = attr.getNext();
    
    // Do not distribute C++11 attributes. They have strict rules for what
    // they appertain to.
    if (attr.isCXX11Attribute()) {
      continue;
    }
    switch (attr.getKind()) {
     case AT_ObjCGC:
     case AT_ObjCOwnership:
      distributeObjCPointerTypeAttrFromDeclarator(state, $Deref(attr), declSpecType);
      break;
     case AT_NSReturnsRetained:
      if (!state.getSema().getLangOpts().ObjCAutoRefCount) {
        break;
      }
     case AT_NoReturn:
     case AT_Regparm:
     case AT_CDecl:
     case AT_FastCall:
     case AT_StdCall:
     case AT_ThisCall:
     case AT_Pascal:
     case AT_SwiftCall:
     case AT_VectorCall:
     case AT_MSABI:
     case AT_SysVABI:
     case AT_Pcs:
     case AT_IntelOclBicc:
     case AT_PreserveMost:
     case AT_PreserveAll:
      // fallthrough
      distributeFunctionTypeAttrFromDeclarator(state, $Deref(attr), declSpecType);
      break;
     case AT_Ptr32:
     case AT_Ptr64:
     case AT_SPtr:
     case AT_UPtr:
      // Microsoft type attributes cannot go after the declarator-id.
      continue;
     case AT_TypeNonNull:
     case AT_TypeNullable:
     case AT_TypeNullUnspecified:
     case AT_ObjCKindOf:
      // Nullability specifiers cannot go after the declarator-id.
      
      // Objective-C __kindof does not get distributed.
      continue;
     default:
      break;
    }
  } while (((attr = next) != null));
}


/// Add a synthetic '()' to a block-literal declarator if it is
/// required, given the return type.
//<editor-fold defaultstate="collapsed" desc="maybeSynthesizeBlockSignature">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 668,
 FQN="maybeSynthesizeBlockSignature", NM="_ZL29maybeSynthesizeBlockSignatureRN12_GLOBAL__N_119TypeProcessingStateEN5clang8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZL29maybeSynthesizeBlockSignatureRN12_GLOBAL__N_119TypeProcessingStateEN5clang8QualTypeE")
//</editor-fold>
public static void maybeSynthesizeBlockSignature(final TypeProcessingState /*&*/ state, 
                             QualType declSpecType) {
  final Declarator /*&*/ declarator = state.getDeclarator();
  
  // First, check whether the declarator would produce a function,
  // i.e. whether the innermost semantic chunk is a function.
  if (declarator.isFunctionDeclarator()) {
    // If so, make that declarator a prototyped declarator.
    declarator.getFunctionTypeInfo().hasPrototype = true;
    return;
  }
  
  // If there are any type objects, the type as written won't name a
  // function, regardless of the decl spec type.  This is because a
  // block signature declarator is always an abstract-declarator, and
  // abstract-declarators can't just be parentheses chunks.  Therefore
  // we need to build a function chunk unless there are no type
  // objects and the decl spec type is a function.
  if (!(declarator.getNumTypeObjects() != 0) && declSpecType.$arrow().isFunctionType()) {
    return;
  }
  
  // Note that there *are* cases with invalid declarators where
  // declarators consist solely of parentheses.  In general, these
  // occur only in failed efforts to make function declarators, so
  // faking up the function chunk is still the right thing to do.
  
  // Otherwise, we need to fake up a function declarator.
  SourceLocation loc = declarator.getLocStart();
  
  // ...and *prepend* it to the declarator.
  SourceLocation NoLoc/*J*/= new SourceLocation();
  declarator.AddInnermostTypeInfo(DeclaratorChunk.getFunction(/*HasProto=*/ true, 
          /*IsAmbiguous=*/ false, 
          /*LParenLoc=*/ new SourceLocation(NoLoc), 
          /*ArgInfo=*/ (type$ptr<ParamInfo> /*P*/ )null, 
          /*NumArgs=*/ 0, 
          /*EllipsisLoc=*/ new SourceLocation(NoLoc), 
          /*RParenLoc=*/ new SourceLocation(NoLoc), 
          /*TypeQuals=*/ 0, 
          /*RefQualifierIsLvalueRef=*/ true, 
          /*RefQualifierLoc=*/ new SourceLocation(NoLoc), 
          /*ConstQualifierLoc=*/ new SourceLocation(NoLoc), 
          /*VolatileQualifierLoc=*/ new SourceLocation(NoLoc), 
          /*RestrictQualifierLoc=*/ new SourceLocation(NoLoc), 
          /*MutableLoc=*/ new SourceLocation(NoLoc), ExceptionSpecificationType.EST_None, 
          /*ESpecRange=*/ new SourceRange(), 
          /*Exceptions=*/ (type$ptr<OpaquePtr<QualType>> /*P*/ )null, 
          /*ExceptionRanges=*/ (type$ptr<SourceRange> /*P*/ )null, 
          /*NumExceptions=*/ 0, 
          /*NoexceptExpr=*/ (Expr /*P*/ )null, 
          /*ExceptionSpecTokens=*/ (SmallVectorToken /*P*/)null, 
          new SourceLocation(loc), new SourceLocation(loc), declarator));
  
  // For consistency, make sure the state still has us as processing
  // the decl spec.
  assert (state.getCurrentChunkIndex() == declarator.getNumTypeObjects() - 1);
  state.setCurrentChunkIndex(declarator.getNumTypeObjects());
}

//<editor-fold defaultstate="collapsed" desc="diagnoseAndRemoveTypeQualifiers">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 728,
 FQN="diagnoseAndRemoveTypeQualifiers", NM="_ZL31diagnoseAndRemoveTypeQualifiersRN5clang4SemaERKNS_8DeclSpecERjNS_8QualTypeEjj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZL31diagnoseAndRemoveTypeQualifiersRN5clang4SemaERKNS_8DeclSpecERjNS_8QualTypeEjj")
//</editor-fold>
public static void diagnoseAndRemoveTypeQualifiers(final Sema /*&*/ S, final /*const*/ DeclSpec /*&*/ DS, 
                               final uint$ref/*uint &*/ TypeQuals, 
                               QualType TypeSoFar, 
                               /*uint*/int RemoveTQs, 
                               /*uint*/int DiagID) {
  // If this occurs outside a template instantiation, warn the user about
  // it; they probably didn't mean to specify a redundant qualifier.
  /*typedef std::pair<DeclSpec::TQ, SourceLocation> QualLoc*/
//  final class QualLoc extends std.pair<DeclSpec.TQ, SourceLocation>{ };
  for (std.pair<DeclSpec.TQ, SourceLocation> Qual : new /*const*/ pair [/*4*/] {
    new std.pairTypeType<DeclSpec.TQ, SourceLocation>(JD$T$RR_T1$RR.INSTANCE, DeclSpec.TQ.TQ_const, DS.getConstSpecLoc()), 
    new std.pairTypeType<DeclSpec.TQ, SourceLocation>(JD$T$RR_T1$RR.INSTANCE, DeclSpec.TQ.TQ_restrict, DS.getRestrictSpecLoc()), 
    new std.pairTypeType<DeclSpec.TQ, SourceLocation>(JD$T$RR_T1$RR.INSTANCE, DeclSpec.TQ.TQ_volatile, DS.getVolatileSpecLoc()), 
    new std.pairTypeType<DeclSpec.TQ, SourceLocation>(JD$T$RR_T1$RR.INSTANCE, DeclSpec.TQ.TQ_atomic, DS.getAtomicSpecLoc())}) {
    if (!((RemoveTQs & Qual.first.getValue()) != 0)) {
      continue;
    }
    if (S.ActiveTemplateInstantiations.empty()) {
      if (((TypeQuals.$deref() & Qual.first.getValue()) != 0)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Qual.second), DiagID)), 
                      DeclSpec.getSpecifierName_TQ(Qual.first)), TypeSoFar), 
              FixItHint.CreateRemoval(new SourceRange(/*NO_COPY*/Qual.second))));
        } finally {
          $c$.$destroy();
        }
      }
    }
    
    TypeQuals.$set$andassign(~Qual.first.getValue());
  }
}


/// Return true if this is omitted block return type. Also check type
/// attributes and type qualifiers when returning true.
//<editor-fold defaultstate="collapsed" desc="checkOmittedBlockReturnType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 756,
 FQN="checkOmittedBlockReturnType", NM="_ZL27checkOmittedBlockReturnTypeRN5clang4SemaERNS_10DeclaratorENS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZL27checkOmittedBlockReturnTypeRN5clang4SemaERNS_10DeclaratorENS_8QualTypeE")
//</editor-fold>
public static boolean checkOmittedBlockReturnType(final Sema /*&*/ S, final Declarator /*&*/ declarator, 
                           QualType Result) {
  if (!isOmittedBlockReturnType(declarator)) {
    return false;
  }
  
  // Warn if we see type attributes for omitted return type on a block literal.
  final type$ref<AttributeList/*P*/>/*&*/ attrs = declarator.getMutableDeclSpec().getAttributes().getListRef();
  AttributeList /*P*/ prev = null;
  for (AttributeList /*P*/ cur = attrs.$deref(); (cur != null); cur = cur.getNext()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      final AttributeList /*&*/ attr = $Deref(cur);
      // Skip attributes that were marked to be invalid or non-type
      // attributes.
      if (attr.isInvalid() || !attr.isTypeAttr()) {
        prev = cur;
        continue;
      }
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(attr.getLoc(), 
              diag.warn_block_literal_attributes_on_omitted_return_type)), 
          attr.getName()));
      // Remove cur from the list.
      if ((prev != null)) {
        prev.setNext(cur.getNext());
        prev = cur;
      } else {
        attrs.$set(cur.getNext());
      }
    } finally {
      $c$.$destroy();
    }
  }
  
  // Warn if we see type qualifiers for omitted return type on a block literal.
  final /*const*/ DeclSpec /*&*/ DS = declarator.getDeclSpec();
  uint$ref TypeQuals = create_uint$ref(DS.getTypeQualifiers());
  diagnoseAndRemoveTypeQualifiers(S, DS, TypeQuals, new QualType(Result), (/*uint*/int)-1, 
      diag.warn_block_literal_qualifiers_on_omitted_return_type);
  declarator.getMutableDeclSpec().ClearTypeQualifiers();
  
  return true;
}


/// Apply Objective-C type arguments to the given type.
//<editor-fold defaultstate="collapsed" desc="applyObjCTypeArgs">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 796,
 FQN="applyObjCTypeArgs", NM="_ZL17applyObjCTypeArgsRN5clang4SemaENS_14SourceLocationENS_8QualTypeEN4llvm8ArrayRefIPNS_14TypeSourceInfoEEENS_11SourceRangeEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZL17applyObjCTypeArgsRN5clang4SemaENS_14SourceLocationENS_8QualTypeEN4llvm8ArrayRefIPNS_14TypeSourceInfoEEENS_11SourceRangeEb")
//</editor-fold>
public static QualType applyObjCTypeArgs(final Sema /*&*/ S, SourceLocation loc, QualType type, 
                 ArrayRef<TypeSourceInfo /*P*/ > typeArgs, 
                 SourceRange typeArgsRange) {
  return applyObjCTypeArgs(S, loc, type, 
                 typeArgs, 
                 typeArgsRange, 
                 false);
}
public static QualType applyObjCTypeArgs(final Sema /*&*/ S, SourceLocation loc, QualType type, 
                 ArrayRef<TypeSourceInfo /*P*/ > typeArgs, 
                 SourceRange typeArgsRange, 
                 boolean failOnError/*= false*/) {
  // We can only apply type arguments to an Objective-C class type.
  /*const*/ ObjCObjectType /*P*/ objcObjectType = type.$arrow().getAs(ObjCObjectType.class);
  if (!(objcObjectType != null) || !(objcObjectType.getInterface() != null)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(loc), diag.err_objc_type_args_non_class)), 
              type), 
          typeArgsRange));
      if (failOnError) {
        return new QualType();
      }
      return new QualType(JD$Move.INSTANCE, type);
    } finally {
      $c$.$destroy();
    }
  }
  
  // The class type must be parameterized.
  ObjCInterfaceDecl /*P*/ objcClass = objcObjectType.getInterface();
  ObjCTypeParamList /*P*/ typeParams = objcClass.getTypeParamList();
  if (!(typeParams != null)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(loc), diag.err_objc_type_args_non_parameterized_class)), 
              objcClass.getDeclName()), 
          FixItHint.CreateRemoval(/*NO_COPY*/typeArgsRange)));
      if (failOnError) {
        return new QualType();
      }
      
      return new QualType(JD$Move.INSTANCE, type);
    } finally {
      $c$.$destroy();
    }
  }
  
  // The type must not already be specialized.
  if (objcObjectType.isSpecialized()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(loc), diag.err_objc_type_args_specialized_class)), 
              type), 
          FixItHint.CreateRemoval(/*NO_COPY*/typeArgsRange)));
      if (failOnError) {
        return new QualType();
      }
      
      return new QualType(JD$Move.INSTANCE, type);
    } finally {
      $c$.$destroy();
    }
  }
  
  // Check the type arguments.
  SmallVector<QualType> finalTypeArgs/*J*/= new SmallVector<QualType>(4, new QualType());
  /*uint*/int numTypeParams = typeParams.size();
  boolean anyPackExpansions = false;
  for (/*uint*/int i = 0, n = typeArgs.size(); i != n; ++i) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      TypeSourceInfo /*P*/ typeArgInfo = typeArgs.$at(i);
      QualType typeArg = typeArgInfo.getType();
      {
        
        // Type arguments cannot have explicit qualifiers or nullability.
        // We ignore indirect sources of these, e.g. behind typedefs or
        // template arguments.
        TypeLoc qual = typeArgInfo.getTypeLoc().findExplicitQualifierLoc();
        if (qual.$bool()) {
          boolean diagnosed = false;
          SourceRange rangeToRemove/*J*/= new SourceRange();
          {
            AttributedTypeLoc attr = qual.getAs(AttributedTypeLoc.class);
            if (attr.$bool()) {
              rangeToRemove.$assignMove(attr.getLocalSourceRange());
              if (attr.getTypePtr().getImmediateNullability().$bool()) {
                typeArg.$assignMove(attr.getTypePtr().getModifiedType());
                $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(attr.getLocStart(), 
                            diag.err_objc_type_arg_explicit_nullability)), 
                        typeArg), FixItHint.CreateRemoval(/*NO_COPY*/rangeToRemove)));
                diagnosed = true;
              }
            }
          }
          if (!diagnosed) {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(qual.getLocStart(), diag.err_objc_type_arg_qualified)), 
                        typeArg), typeArg.getQualifiers().getAsString()), 
                FixItHint.CreateRemoval(/*NO_COPY*/rangeToRemove)));
          }
        }
      }
      
      // Remove qualifiers even if they're non-local.
      typeArg.$assignMove(typeArg.getUnqualifiedType());
      
      finalTypeArgs.push_back(typeArg);
      if ((typeArg.$arrow().getAs(PackExpansionType.class) != null)) {
        anyPackExpansions = true;
      }
      
      // Find the corresponding type parameter, if there is one.
      ObjCTypeParamDecl /*P*/ typeParam = null;
      if (!anyPackExpansions) {
        if ($less_uint(i, numTypeParams)) {
          typeParam = typeParams.begin().$at(i);
        } else {
          // Too many arguments.
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(loc), diag.err_objc_type_args_wrong_arity)), 
                          false), 
                      objcClass.getDeclName()), 
                  (/*uint*/int)typeArgs.size()), 
              numTypeParams));
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(objcClass.getLocation(), diag.note_previous_decl)), 
              objcClass));
          if (failOnError) {
            return new QualType();
          }
          
          return new QualType(JD$Move.INSTANCE, type);
        }
      }
      {
        
        // Objective-C object pointer types must be substitutable for the bounds.
        /*const*/ ObjCObjectPointerType /*P*/ typeArgObjC = typeArg.$arrow().getAs(ObjCObjectPointerType.class);
        if ((typeArgObjC != null)) {
          // If we don't have a type parameter to match against, assume
          // everything is fine. There was a prior pack expansion that
          // means we won't be able to match anything.
          if (!(typeParam != null)) {
            assert (anyPackExpansions) : "Too many arguments?";
            continue;
          }
          
          // Retrieve the bound.
          QualType bound = typeParam.getUnderlyingType();
          /*const*/ ObjCObjectPointerType /*P*/ boundObjC = bound.$arrow().getAs(ObjCObjectPointerType.class);
          
          // Determine whether the type argument is substitutable for the bound.
          if (typeArgObjC.isObjCIdType()) {
            // When the type argument is 'id', the only acceptable type
            // parameter bound is 'id'.
            if (boundObjC.isObjCIdType()) {
              continue;
            }
          } else if (S.Context.canAssignObjCInterfaces(boundObjC, typeArgObjC)) {
            // Otherwise, we follow the assignability rules.
            continue;
          }
          
          // Diagnose the mismatch.
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(typeArgInfo.getTypeLoc().getLocStart(), 
                          diag.err_objc_type_arg_does_not_match_bound)), 
                      typeArg), bound), typeParam.getDeclName()));
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(typeParam.getLocation(), diag.note_objc_type_param_here)), 
              typeParam.getDeclName()));
          if (failOnError) {
            return new QualType();
          }
          
          return new QualType(JD$Move.INSTANCE, type);
        }
      }
      
      // Block pointer types are permitted for unqualified 'id' bounds.
      if (typeArg.$arrow().isBlockPointerType()) {
        // If we don't have a type parameter to match against, assume
        // everything is fine. There was a prior pack expansion that
        // means we won't be able to match anything.
        if (!(typeParam != null)) {
          assert (anyPackExpansions) : "Too many arguments?";
          continue;
        }
        
        // Retrieve the bound.
        QualType bound = typeParam.getUnderlyingType();
        if (bound.$arrow().isBlockCompatibleObjCPointerType(S.Context)) {
          continue;
        }
        
        // Diagnose the mismatch.
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(typeArgInfo.getTypeLoc().getLocStart(), 
                        diag.err_objc_type_arg_does_not_match_bound)), 
                    typeArg), bound), typeParam.getDeclName()));
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(typeParam.getLocation(), diag.note_objc_type_param_here)), 
            typeParam.getDeclName()));
        if (failOnError) {
          return new QualType();
        }
        
        return new QualType(JD$Move.INSTANCE, type);
      }
      
      // Dependent types will be checked at instantiation time.
      if (typeArg.$arrow().isDependentType()) {
        continue;
      }
      
      // Diagnose non-id-compatible type arguments.
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(typeArgInfo.getTypeLoc().getLocStart(), 
                  diag.err_objc_type_arg_not_id_compatible)), 
              typeArg), 
          typeArgInfo.getTypeLoc().getSourceRange()));
      if (failOnError) {
        return new QualType();
      }
      
      return new QualType(JD$Move.INSTANCE, type);
    } finally {
      $c$.$destroy();
    }
  }
  
  // Make sure we didn't have the wrong number of arguments.
  if (!anyPackExpansions && finalTypeArgs.size() != numTypeParams) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(loc), diag.err_objc_type_args_wrong_arity)), 
                      ($less_uint(typeArgs.size(), typeParams.size()))), 
                  objcClass.getDeclName()), 
              (/*uint*/int)finalTypeArgs.size()), 
          (/*uint*/int)numTypeParams));
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(objcClass.getLocation(), diag.note_previous_decl)), 
          objcClass));
      if (failOnError) {
        return new QualType();
      }
      
      return new QualType(JD$Move.INSTANCE, type);
    } finally {
      $c$.$destroy();
    }
  }
  
  // Success. Form the specialized type.
  return S.Context.getObjCObjectType(new QualType(type), new ArrayRef<QualType>(finalTypeArgs, false), /*{ */new ArrayRef<ObjCProtocolDecl /*P*/ >(true)/* }*/, false);
}


/// Apply Objective-C protocol qualifiers to the given type.
//<editor-fold defaultstate="collapsed" desc="applyObjCProtocolQualifiers">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 1004,
 FQN="applyObjCProtocolQualifiers", NM="_ZL27applyObjCProtocolQualifiersRN5clang4SemaENS_14SourceLocationENS_11SourceRangeENS_8QualTypeEN4llvm8ArrayRefIPNS_16ObjCProtocolDeclEEEPKS2_b",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZL27applyObjCProtocolQualifiersRN5clang4SemaENS_14SourceLocationENS_11SourceRangeENS_8QualTypeEN4llvm8ArrayRefIPNS_16ObjCProtocolDeclEEEPKS2_b")
//</editor-fold>
public static QualType applyObjCProtocolQualifiers(final Sema /*&*/ S, SourceLocation loc, SourceRange range, QualType type, 
                           ArrayRef<ObjCProtocolDecl /*P*/ > protocols, 
                           /*const*/type$ptr<SourceLocation> /*P*/ protocolLocs) {
  return applyObjCProtocolQualifiers(S, loc, range, type, 
                           protocols, 
                           protocolLocs, 
                           false);
}
public static QualType applyObjCProtocolQualifiers(final Sema /*&*/ S, SourceLocation loc, SourceRange range, QualType type, 
                           ArrayRef<ObjCProtocolDecl /*P*/ > protocols, 
                           /*const*/type$ptr<SourceLocation> /*P*/ protocolLocs, 
                           boolean failOnError/*= false*/) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    final ASTContext /*&*/ ctx = S.Context;
    {
      /*const*/ ObjCObjectType /*P*/ objT = dyn_cast_ObjCObjectType(type.getTypePtr());
      if ((objT != null)) {
        // FIXME: Check for protocols to which the class type is already
        // known to conform.
        return ctx.getObjCObjectType(objT.getBaseType(), 
            objT.getTypeArgsAsWritten(), 
            new ArrayRef<ObjCProtocolDecl /*P*/ >(protocols), 
            objT.isKindOfTypeAsWritten());
      }
    }
    if (type.$arrow().isObjCObjectType()) {
      // Silently overwrite any existing protocol qualifiers.
      // TODO: determine whether that's the right thing to do.
      
      // FIXME: Check for protocols to which the class type is already
      // known to conform.
      return ctx.getObjCObjectType(new QualType(type), /*{ */new ArrayRef<QualType>(false)/* }*/, new ArrayRef<ObjCProtocolDecl /*P*/ >(protocols), false);
    }
    
    // id<protocol-list>
    if (type.$arrow().isObjCIdType()) {
      /*const*/ ObjCObjectPointerType /*P*/ objPtr = type.$arrow().castAs(ObjCObjectPointerType.class);
      type.$assignMove(ctx.getObjCObjectType(ctx.ObjCBuiltinIdTy.$QualType(), /*{ */new ArrayRef<QualType>(false)/* }*/, new ArrayRef<ObjCProtocolDecl /*P*/ >(protocols), 
              objPtr.isKindOfType()));
      return ctx.getObjCObjectPointerType(new QualType(type));
    }
    
    // Class<protocol-list>
    if (type.$arrow().isObjCClassType()) {
      /*const*/ ObjCObjectPointerType /*P*/ objPtr = type.$arrow().castAs(ObjCObjectPointerType.class);
      type.$assignMove(ctx.getObjCObjectType(ctx.ObjCBuiltinClassTy.$QualType(), /*{ */new ArrayRef<QualType>(false)/* }*/, new ArrayRef<ObjCProtocolDecl /*P*/ >(protocols), 
              objPtr.isKindOfType()));
      return ctx.getObjCObjectPointerType(new QualType(type));
    }
    
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(loc), diag.err_invalid_protocol_qualifiers)), 
        range));
    if (failOnError) {
      return new QualType();
    }
    
    return new QualType(JD$Move.INSTANCE, type);
  } finally {
    $c$.$destroy();
  }
}

//<editor-fold defaultstate="collapsed" desc="getImageAccessAttrStr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 1223,
 FQN="getImageAccessAttrStr", NM="_ZL21getImageAccessAttrStrPN5clang13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZL21getImageAccessAttrStrPN5clang13AttributeListE")
//</editor-fold>
public static StringRef getImageAccessAttrStr(AttributeList /*P*/ attrs) {
  if ((attrs != null)) {
    
    AttributeList /*P*/ Next;
    do {
      final AttributeList /*&*/ Attr = $Deref(attrs);
      Next = Attr.getNext();
      if (Attr.getKind() == AttributeList.Kind.AT_OpenCLAccess) {
        return Attr.getName().getName();
      }
    } while ((Next != null));
  }
  return new StringRef(/*KEEP_STR*/$EMPTY);
}


/// \brief Convert the specified declspec to the appropriate type
/// object.
/// \param state Specifies the declarator containing the declaration specifier
/// to be converted, along with other associated processing state.
/// \returns The type described by the declaration specifiers.  This function
/// never returns null.
//<editor-fold defaultstate="collapsed" desc="ConvertDeclSpecToType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 1244,
 FQN="ConvertDeclSpecToType", NM="_ZL21ConvertDeclSpecToTypeRN12_GLOBAL__N_119TypeProcessingStateE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZL21ConvertDeclSpecToTypeRN12_GLOBAL__N_119TypeProcessingStateE")
//</editor-fold>
public static QualType ConvertDeclSpecToType(final TypeProcessingState /*&*/ state) {
  // FIXME: Should move the logic from DeclSpec::Finish to here for validity
  // checking.
  final Sema /*&*/ S = state.getSema();
  final Declarator /*&*/ declarator = state.getDeclarator();
  final /*const*/ DeclSpec /*&*/ DS = declarator.getDeclSpec();
  SourceLocation DeclLoc = declarator.getIdentifierLoc();
  if (DeclLoc.isInvalid()) {
    DeclLoc.$assignMove(DS.getLocStart());
  }
  
  final ASTContext /*&*/ Context = S.Context;
  
  QualType Result/*J*/= new QualType();
  switch (DS.getTypeSpecType()) {
   case TST_void:
    Result.$assignMove(Context.VoidTy.$QualType());
    break;
   case TST_char:
    if (DS.getTypeSpecSign() == DeclSpec.TSS_unspecified) {
      Result.$assignMove(Context.CharTy.$QualType());
    } else if (DS.getTypeSpecSign() == DeclSpec.TSS_signed) {
      Result.$assignMove(Context.SignedCharTy.$QualType());
    } else {
      assert (DS.getTypeSpecSign() == DeclSpec.TSS_unsigned) : "Unknown TSS value";
      Result.$assignMove(Context.UnsignedCharTy.$QualType());
    }
    break;
   case TST_wchar:
    if (DS.getTypeSpecSign() == DeclSpec.TSS_unspecified) {
      Result.$assignMove(Context.WCharTy.$QualType());
    } else if (DS.getTypeSpecSign() == DeclSpec.TSS_signed) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(DS.getTypeSpecSignLoc(), diag.ext_invalid_sign_spec)), 
            DS.getSpecifierName(DS.getTypeSpecType(), 
                Context.getPrintingPolicy())));
        Result.$assignMove(Context.getSignedWCharType());
      } finally {
        $c$.$destroy();
      }
    } else {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        assert (DS.getTypeSpecSign() == DeclSpec.TSS_unsigned) : "Unknown TSS value";
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(DS.getTypeSpecSignLoc(), diag.ext_invalid_sign_spec)), 
            DS.getSpecifierName(DS.getTypeSpecType(), 
                Context.getPrintingPolicy())));
        Result.$assignMove(Context.getUnsignedWCharType());
      } finally {
        $c$.$destroy();
      }
    }
    break;
   case TST_char16:
    assert (DS.getTypeSpecSign() == DeclSpec.TSS_unspecified) : "Unknown TSS value";
    Result.$assignMove(Context.Char16Ty.$QualType());
    break;
   case TST_char32:
    assert (DS.getTypeSpecSign() == DeclSpec.TSS_unspecified) : "Unknown TSS value";
    Result.$assignMove(Context.Char32Ty.$QualType());
    break;
   case TST_unspecified:
    // If this is a missing declspec in a block literal return context, then it
    // is inferred from the return statements inside the block.
    // The declspec is always missing in a lambda expr context; it is either
    // specified with a trailing return type or inferred.
    if (S.getLangOpts().CPlusPlus14
       && declarator.getContext() == Declarator.TheContext.LambdaExprContext) {
      // In C++1y, a lambda's implicit return type is 'auto'.
      Result.$assignMove(Context.getAutoDeductType());
      break;
    } else if (declarator.getContext() == Declarator.TheContext.LambdaExprContext
       || checkOmittedBlockReturnType(S, declarator, 
        Context.DependentTy.$QualType())) {
      Result.$assignMove(Context.DependentTy.$QualType());
      break;
    }
    
    // Unspecified typespec defaults to int in C90.  However, the C90 grammar
    // [C90 6.5] only allows a decl-spec if there was *some* type-specifier,
    // type-qualifier, or storage-class-specifier.  If not, emit an extwarn.
    // Note that the one exception to this is function definitions, which are
    // allowed to be completely missing a declspec.  This is handled in the
    // parser already though by it pretending to have seen an 'int' in this
    // case.
    if (S.getLangOpts().ImplicitInt) {
      // In C89 mode, we only warn if there is a completely missing declspec
      // when one is not allowed.
      if (DS.isEmpty()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(DeclLoc), diag.ext_missing_declspec)), 
                  DS.getSourceRange()), 
              FixItHint.CreateInsertion(DS.getLocStart(), new StringRef(/*KEEP_STR*/$int))));
        } finally {
          $c$.$destroy();
        }
      }
    } else if (!DS.hasTypeSpecifier()) {
      // C99 and C++ require a type specifier.  For example, C99 6.7.2p2 says:
      // "At least one type specifier shall be given in the declaration
      // specifiers in each declaration, and in the specifier-qualifier list in
      // each struct declaration and type name."
      if (S.getLangOpts().CPlusPlus) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(DeclLoc), diag.err_missing_type_specifier)), 
              DS.getSourceRange()));
          
          // When this occurs in C++ code, often something is very broken with the
          // value being declared, poison it as invalid so we don't get chains of
          // errors.
          declarator.setInvalidType(true);
        } finally {
          $c$.$destroy();
        }
      } else if ($greatereq_uint(S.getLangOpts().OpenCLVersion, 200) && DS.isTypeSpecPipe()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(DeclLoc), diag.err_missing_actual_pipe_type)), 
              DS.getSourceRange()));
          declarator.setInvalidType(true);
        } finally {
          $c$.$destroy();
        }
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(DeclLoc), diag.ext_missing_type_specifier)), 
              DS.getSourceRange()));
        } finally {
          $c$.$destroy();
        }
      }
    }
   case TST_int:
    {
      if (DS.getTypeSpecSign() != DeclSpec.TSS_unsigned) {
        switch (DS.getTypeSpecWidth()) {
         case TSW_unspecified:
          Result.$assignMove(Context.IntTy.$QualType());
          break;
         case TSW_short:
          Result.$assignMove(Context.ShortTy.$QualType());
          break;
         case TSW_long:
          Result.$assignMove(Context.LongTy.$QualType());
          break;
         case TSW_longlong:
          Result.$assignMove(Context.LongLongTy.$QualType());
          
          // 'long long' is a C99 or C++11 feature.
          if (!S.getLangOpts().C99) {
            if (S.getLangOpts().CPlusPlus) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                $c$.clean($c$.track(S.Diag(DS.getTypeSpecWidthLoc(), 
                    S.getLangOpts().CPlusPlus11 ? diag.warn_cxx98_compat_longlong : diag.ext_cxx11_longlong)));
              } finally {
                $c$.$destroy();
              }
            } else {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                $c$.clean($c$.track(S.Diag(DS.getTypeSpecWidthLoc(), diag.ext_c99_longlong)));
              } finally {
                $c$.$destroy();
              }
            }
          }
          break;
        }
      } else {
        switch (DS.getTypeSpecWidth()) {
         case TSW_unspecified:
          Result.$assignMove(Context.UnsignedIntTy.$QualType());
          break;
         case TSW_short:
          Result.$assignMove(Context.UnsignedShortTy.$QualType());
          break;
         case TSW_long:
          Result.$assignMove(Context.UnsignedLongTy.$QualType());
          break;
         case TSW_longlong:
          Result.$assignMove(Context.UnsignedLongLongTy.$QualType());
          
          // 'long long' is a C99 or C++11 feature.
          if (!S.getLangOpts().C99) {
            if (S.getLangOpts().CPlusPlus) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                $c$.clean($c$.track(S.Diag(DS.getTypeSpecWidthLoc(), 
                    S.getLangOpts().CPlusPlus11 ? diag.warn_cxx98_compat_longlong : diag.ext_cxx11_longlong)));
              } finally {
                $c$.$destroy();
              }
            } else {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                $c$.clean($c$.track(S.Diag(DS.getTypeSpecWidthLoc(), diag.ext_c99_longlong)));
              } finally {
                $c$.$destroy();
              }
            }
          }
          break;
        }
      }
      break;
    }
   case TST_int128:
    if (!S.Context.getTargetInfo().hasInt128Type()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(DS.getTypeSpecTypeLoc(), diag.err_type_unsupported)), 
            /*KEEP_STR*/"__int128"));
      } finally {
        $c$.$destroy();
      }
    }
    if (DS.getTypeSpecSign() == DeclSpec.TSS_unsigned) {
      Result.$assignMove(Context.UnsignedInt128Ty.$QualType());
    } else {
      Result.$assignMove(Context.Int128Ty.$QualType());
    }
    break;
   case TST_half:
    Result.$assignMove(Context.HalfTy.$QualType());
    break;
   case TST_float:
    Result.$assignMove(Context.FloatTy.$QualType());
    break;
   case TST_double:
    if (DS.getTypeSpecWidth() == DeclSpec.TSW_long) {
      Result.$assignMove(Context.LongDoubleTy.$QualType());
    } else {
      Result.$assignMove(Context.DoubleTy.$QualType());
    }
    if (S.getLangOpts().OpenCL
       && !(($greatereq_uint(S.getLangOpts().OpenCLVersion, 120))
       || S.getOpenCLOptions().cl_khr_fp64)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(DS.getTypeSpecTypeLoc(), diag.err_type_requires_extension)), 
                Result), /*KEEP_STR*/"cl_khr_fp64"));
        declarator.setInvalidType(true);
      } finally {
        $c$.$destroy();
      }
    }
    break;
   case TST_float128:
    if (!S.Context.getTargetInfo().hasFloat128Type()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(DS.getTypeSpecTypeLoc(), diag.err_type_unsupported)), 
            /*KEEP_STR*/"__float128"));
      } finally {
        $c$.$destroy();
      }
    }
    Result.$assignMove(Context.Float128Ty.$QualType());
    break;
   case TST_bool:
    Result.$assignMove(Context.BoolTy.$QualType());
    break; // _Bool or bool
    //break;
   case TST_decimal32: // _Decimal32
   case TST_decimal64: // _Decimal64
   case TST_decimal128: // _Decimal128
    {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track(S.Diag(DS.getTypeSpecTypeLoc(), diag.err_decimal_unsupported)));
        Result.$assignMove(Context.IntTy.$QualType());
        declarator.setInvalidType(true);
        break;
      } finally {
        $c$.$destroy();
      }
    }
   case TST_class:
   case TST_enum:
   case TST_union:
   case TST_struct:
   case TST_interface:
    {
      TypeDecl /*P*/ D = dyn_cast_or_null_TypeDecl(DS.getRepAsDecl());
      if (!(D != null)) {
        // This can happen in C++ with ambiguous lookups.
        Result.$assignMove(Context.IntTy.$QualType());
        declarator.setInvalidType(true);
        break;
      }
      
      // If the type is deprecated or unavailable, diagnose it.
      S.DiagnoseUseOfDecl(D, DS.getTypeSpecTypeNameLoc());
      assert (DS.getTypeSpecWidth().getValue() == 0 && DS.getTypeSpecComplex().getValue() == 0 && DS.getTypeSpecSign().getValue() == 0) : "No qualifiers on tag names!";
      
      // TypeQuals handled by caller.
      Result.$assignMove(Context.getTypeDeclType(D));
      
      // In both C and C++, make an ElaboratedType.
      ElaboratedTypeKeyword Keyword = ElaboratedType.getKeywordForTypeSpec(DS.getTypeSpecType().getValue());
      Result.$assignMove(S.getElaboratedType(Keyword, DS.getTypeSpecScope$Const(), new QualType(Result)));
      break;
    }
   case TST_typename:
    {
      assert (DS.getTypeSpecWidth().getValue() == 0 && DS.getTypeSpecComplex().getValue() == 0 && DS.getTypeSpecSign().getValue() == 0) : "Can't handle qualifiers on typedef names yet!";
      Result.$assignMove(S.GetTypeFromParser(DS.getRepAsType()));
      if (Result.isNull()) {
        declarator.setInvalidType(true);
      } else if (S.getLangOpts().OpenCL) {
        if ((Result.$arrow().getAs(AtomicType.class) != null)) {
          StringRef TypeName = Result.getBaseTypeIdentifier().getName();
          boolean NoExtTypes = new StringSwitchBool(/*NO_COPY*/TypeName).
              Cases(/*KEEP_STR*/"atomic_int", /*KEEP_STR*/"atomic_uint", /*KEEP_STR*/"atomic_float", 
              /*KEEP_STR*/"atomic_flag", true).
              Default(false);
          if (!S.getOpenCLOptions().cl_khr_int64_base_atomics && !NoExtTypes) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(DS.getTypeSpecTypeLoc(), diag.err_type_requires_extension)), 
                      Result), /*KEEP_STR*/"cl_khr_int64_base_atomics"));
              declarator.setInvalidType(true);
            } finally {
              $c$.$destroy();
            }
          }
          if (!S.getOpenCLOptions().cl_khr_int64_extended_atomics
             && !NoExtTypes) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(DS.getTypeSpecTypeLoc(), diag.err_type_requires_extension)), 
                      Result), /*KEEP_STR*/"cl_khr_int64_extended_atomics"));
              declarator.setInvalidType(true);
            } finally {
              $c$.$destroy();
            }
          }
          if (!S.getOpenCLOptions().cl_khr_fp64
             && !(TypeName.compare(/*STRINGREF_STR*/"atomic_double") != 0)) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(DS.getTypeSpecTypeLoc(), diag.err_type_requires_extension)), 
                      Result), /*KEEP_STR*/"cl_khr_fp64"));
              declarator.setInvalidType(true);
            } finally {
              $c$.$destroy();
            }
          }
        } else if (!S.getOpenCLOptions().cl_khr_gl_msaa_sharing
           && (Result.$arrow().isOCLImage2dArrayMSAADepthROType()
           || Result.$arrow().isOCLImage2dArrayMSAADepthWOType()
           || Result.$arrow().isOCLImage2dArrayMSAADepthRWType()
           || Result.$arrow().isOCLImage2dArrayMSAAROType()
           || Result.$arrow().isOCLImage2dArrayMSAARWType()
           || Result.$arrow().isOCLImage2dArrayMSAAWOType()
           || Result.$arrow().isOCLImage2dMSAADepthROType()
           || Result.$arrow().isOCLImage2dMSAADepthRWType()
           || Result.$arrow().isOCLImage2dMSAADepthWOType()
           || Result.$arrow().isOCLImage2dMSAAROType()
           || Result.$arrow().isOCLImage2dMSAARWType()
           || Result.$arrow().isOCLImage2dMSAAWOType())) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(DS.getTypeSpecTypeLoc(), diag.err_type_requires_extension)), 
                    Result), /*KEEP_STR*/"cl_khr_gl_msaa_sharing"));
            declarator.setInvalidType(true);
          } finally {
            $c$.$destroy();
          }
        }
      }
      
      // TypeQuals handled by caller.
      break;
    }
   case TST_typeofType:
    // FIXME: Preserve type source info.
    Result.$assignMove(S.GetTypeFromParser(DS.getRepAsType()));
    assert (!Result.isNull()) : "Didn't get a type for typeof?";
    if (!Result.$arrow().isDependentType()) {
      {
        /*const*/ TagType /*P*/ TT = Result.$arrow().getAs(TagType.class);
        if ((TT != null)) {
          S.DiagnoseUseOfDecl(TT.getDecl(), DS.getTypeSpecTypeLoc());
        }
      }
    }
    // TypeQuals handled by caller.
    Result.$assignMove(Context.getTypeOfType(new QualType(Result)));
    break;
   case TST_typeofExpr:
    {
      Expr /*P*/ E = DS.getRepAsExpr();
      assert ((E != null)) : "Didn't get an expression for typeof?";
      // TypeQuals handled by caller.
      Result.$assignMove(S.BuildTypeofExprType(E, DS.getTypeSpecTypeLoc()));
      if (Result.isNull()) {
        Result.$assignMove(Context.IntTy.$QualType());
        declarator.setInvalidType(true);
      }
      break;
    }
   case TST_decltype:
    {
      Expr /*P*/ E = DS.getRepAsExpr();
      assert ((E != null)) : "Didn't get an expression for decltype?";
      // TypeQuals handled by caller.
      Result.$assignMove(S.BuildDecltypeType(E, DS.getTypeSpecTypeLoc()));
      if (Result.isNull()) {
        Result.$assignMove(Context.IntTy.$QualType());
        declarator.setInvalidType(true);
      }
      break;
    }
   case TST_underlyingType:
    Result.$assignMove(S.GetTypeFromParser(DS.getRepAsType()));
    assert (!Result.isNull()) : "Didn't get a type for __underlying_type?";
    Result.$assignMove(S.BuildUnaryTransformType(new QualType(Result), 
            UnaryTransformType.UTTKind.EnumUnderlyingType, 
            DS.getTypeSpecTypeLoc()));
    if (Result.isNull()) {
      Result.$assignMove(Context.IntTy.$QualType());
      declarator.setInvalidType(true);
    }
    break;
   case TST_auto:
    // TypeQuals handled by caller.
    // If auto is mentioned in a lambda parameter context, convert it to a 
    // template parameter type immediately, with the appropriate depth and 
    // index, and update sema's state (LambdaScopeInfo) for the current lambda 
    // being analyzed (which tracks the invented type template parameter).
    if (declarator.getContext() == Declarator.TheContext.LambdaExprParameterContext) {
      LambdaScopeInfo /*P*/ LSI = S.getCurLambda();
      assert ((LSI != null)) : "No LambdaScopeInfo on the stack!";
      /*const*//*uint*/int TemplateParameterDepth = LSI.AutoTemplateParameterDepth;
      /*const*//*uint*/int AutoParameterPosition = LSI.AutoTemplateParams.size();
      /*const*/boolean IsParameterPack = declarator.hasEllipsis();
      
      // Turns out we must create the TemplateTypeParmDecl here to 
      // retrieve the corresponding template parameter type. 
      TemplateTypeParmDecl /*P*/ CorrespondingTemplateParam = TemplateTypeParmDecl.Create(Context, 
          // Temporarily add to the TranslationUnit DeclContext.  When the 
          // associated TemplateParameterList is attached to a template
          // declaration (such as FunctionTemplateDecl), the DeclContext 
          // for each template parameter gets updated appropriately via
          // a call to AdoptTemplateParameterList. 
          Context.getTranslationUnitDecl(), 
          /*KeyLoc*/ new SourceLocation(), 
          /*NameLoc*/ declarator.getLocStart(), 
          TemplateParameterDepth, 
          AutoParameterPosition,  // our template param index 
          /* Identifier*/
          (IdentifierInfo /*P*/ )null, false, IsParameterPack);
      LSI.AutoTemplateParams.push_back(CorrespondingTemplateParam);
      // Replace the 'auto' in the function parameter with this invented 
      // template type parameter.
      Result.$assignMove(new QualType(CorrespondingTemplateParam.getTypeForDecl(), 0));
    } else {
      Result.$assignMove(Context.getAutoType(new QualType(), AutoTypeKeyword.Auto, false));
    }
    break;
   case TST_auto_type:
    Result.$assignMove(Context.getAutoType(new QualType(), AutoTypeKeyword.GNUAutoType, false));
    break;
   case TST_decltype_auto:
    Result.$assignMove(Context.getAutoType(new QualType(), AutoTypeKeyword.DecltypeAuto, 
            /*IsDependent*/ false));
    break;
   case TST_unknown_anytype:
    Result.$assignMove(Context.UnknownAnyTy.$QualType());
    break;
   case TST_atomic:
    Result.$assignMove(S.GetTypeFromParser(DS.getRepAsType()));
    assert (!Result.isNull()) : "Didn't get a type for _Atomic?";
    Result.$assignMove(S.BuildAtomicType(new QualType(Result), DS.getTypeSpecTypeLoc()));
    if (Result.isNull()) {
      Result.$assignMove(Context.IntTy.$QualType());
      declarator.setInvalidType(true);
    }
    break;
   case TST_image1d_t:
    Result.$assignMove(new StringSwitch<QualType>(getImageAccessAttrStr(DS.getAttributes$Const().getList())).Cases(/*KEEP_STR*/"write_only", /*KEEP_STR*/"__write_only", Context.OCLImage1dWOTy.$QualType()).Cases(/*KEEP_STR*/"read_write", /*KEEP_STR*/"__read_write", Context.OCLImage1dRWTy.$QualType()).Default(Context.OCLImage1dROTy.$QualType()));
    break;
   case TST_image1d_array_t:
    Result.$assignMove(new StringSwitch<QualType>(getImageAccessAttrStr(DS.getAttributes$Const().getList())).Cases(/*KEEP_STR*/"write_only", /*KEEP_STR*/"__write_only", Context.OCLImage1dArrayWOTy.$QualType()).Cases(/*KEEP_STR*/"read_write", /*KEEP_STR*/"__read_write", Context.OCLImage1dArrayRWTy.$QualType()).Default(Context.OCLImage1dArrayROTy.$QualType()));
    break;
   case TST_image1d_buffer_t:
    Result.$assignMove(new StringSwitch<QualType>(getImageAccessAttrStr(DS.getAttributes$Const().getList())).Cases(/*KEEP_STR*/"write_only", /*KEEP_STR*/"__write_only", Context.OCLImage1dBufferWOTy.$QualType()).Cases(/*KEEP_STR*/"read_write", /*KEEP_STR*/"__read_write", Context.OCLImage1dBufferRWTy.$QualType()).Default(Context.OCLImage1dBufferROTy.$QualType()));
    break;
   case TST_image2d_t:
    Result.$assignMove(new StringSwitch<QualType>(getImageAccessAttrStr(DS.getAttributes$Const().getList())).Cases(/*KEEP_STR*/"write_only", /*KEEP_STR*/"__write_only", Context.OCLImage2dWOTy.$QualType()).Cases(/*KEEP_STR*/"read_write", /*KEEP_STR*/"__read_write", Context.OCLImage2dRWTy.$QualType()).Default(Context.OCLImage2dROTy.$QualType()));
    break;
   case TST_image2d_array_t:
    Result.$assignMove(new StringSwitch<QualType>(getImageAccessAttrStr(DS.getAttributes$Const().getList())).Cases(/*KEEP_STR*/"write_only", /*KEEP_STR*/"__write_only", Context.OCLImage2dArrayWOTy.$QualType()).Cases(/*KEEP_STR*/"read_write", /*KEEP_STR*/"__read_write", Context.OCLImage2dArrayRWTy.$QualType()).Default(Context.OCLImage2dArrayROTy.$QualType()));
    break;
   case TST_image2d_depth_t:
    Result.$assignMove(new StringSwitch<QualType>(getImageAccessAttrStr(DS.getAttributes$Const().getList())).Cases(/*KEEP_STR*/"write_only", /*KEEP_STR*/"__write_only", Context.OCLImage2dDepthWOTy.$QualType()).Cases(/*KEEP_STR*/"read_write", /*KEEP_STR*/"__read_write", Context.OCLImage2dDepthRWTy.$QualType()).Default(Context.OCLImage2dDepthROTy.$QualType()));
    break;
   case TST_image2d_array_depth_t:
    Result.$assignMove(new StringSwitch<QualType>(getImageAccessAttrStr(DS.getAttributes$Const().getList())).Cases(/*KEEP_STR*/"write_only", /*KEEP_STR*/"__write_only", Context.OCLImage2dArrayDepthWOTy.$QualType()).Cases(/*KEEP_STR*/"read_write", /*KEEP_STR*/"__read_write", Context.OCLImage2dArrayDepthRWTy.$QualType()).Default(Context.OCLImage2dArrayDepthROTy.$QualType()));
    break;
   case TST_image2d_msaa_t:
    Result.$assignMove(new StringSwitch<QualType>(getImageAccessAttrStr(DS.getAttributes$Const().getList())).Cases(/*KEEP_STR*/"write_only", /*KEEP_STR*/"__write_only", Context.OCLImage2dMSAAWOTy.$QualType()).Cases(/*KEEP_STR*/"read_write", /*KEEP_STR*/"__read_write", Context.OCLImage2dMSAARWTy.$QualType()).Default(Context.OCLImage2dMSAAROTy.$QualType()));
    break;
   case TST_image2d_array_msaa_t:
    Result.$assignMove(new StringSwitch<QualType>(getImageAccessAttrStr(DS.getAttributes$Const().getList())).Cases(/*KEEP_STR*/"write_only", /*KEEP_STR*/"__write_only", Context.OCLImage2dArrayMSAAWOTy.$QualType()).Cases(/*KEEP_STR*/"read_write", /*KEEP_STR*/"__read_write", Context.OCLImage2dArrayMSAARWTy.$QualType()).Default(Context.OCLImage2dArrayMSAAROTy.$QualType()));
    break;
   case TST_image2d_msaa_depth_t:
    Result.$assignMove(new StringSwitch<QualType>(getImageAccessAttrStr(DS.getAttributes$Const().getList())).Cases(/*KEEP_STR*/"write_only", /*KEEP_STR*/"__write_only", Context.OCLImage2dMSAADepthWOTy.$QualType()).Cases(/*KEEP_STR*/"read_write", /*KEEP_STR*/"__read_write", Context.OCLImage2dMSAADepthRWTy.$QualType()).Default(Context.OCLImage2dMSAADepthROTy.$QualType()));
    break;
   case TST_image2d_array_msaa_depth_t:
    Result.$assignMove(new StringSwitch<QualType>(getImageAccessAttrStr(DS.getAttributes$Const().getList())).Cases(/*KEEP_STR*/"write_only", /*KEEP_STR*/"__write_only", Context.OCLImage2dArrayMSAADepthWOTy.$QualType()).Cases(/*KEEP_STR*/"read_write", /*KEEP_STR*/"__read_write", Context.OCLImage2dArrayMSAADepthRWTy.$QualType()).Default(Context.OCLImage2dArrayMSAADepthROTy.$QualType()));
    break;
   case TST_image3d_t:
    Result.$assignMove(new StringSwitch<QualType>(getImageAccessAttrStr(DS.getAttributes$Const().getList())).Cases(/*KEEP_STR*/"write_only", /*KEEP_STR*/"__write_only", Context.OCLImage3dWOTy.$QualType()).Cases(/*KEEP_STR*/"read_write", /*KEEP_STR*/"__read_write", Context.OCLImage3dRWTy.$QualType()).Default(Context.OCLImage3dROTy.$QualType()));
    break;
   case TST_error:
    Result.$assignMove(Context.IntTy.$QualType());
    declarator.setInvalidType(true);
    break;
  }
  
  // Handle complex types.
  if (DS.getTypeSpecComplex() == DeclSpec.TSC.TSC_complex) {
    if (S.getLangOpts().Freestanding) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track(S.Diag(DS.getTypeSpecComplexLoc(), diag.ext_freestanding_complex)));
      } finally {
        $c$.$destroy();
      }
    }
    Result.$assignMove(Context.getComplexType(new QualType(Result)));
  } else if (DS.isTypeAltiVecVector()) {
    /*uint*/int typeSize = ((/*static_cast*//*uint*/int)($ulong2uint(Context.getTypeSize(new QualType(Result)))));
    assert ($greater_uint(typeSize, 0)) : "type size for vector must be greater than 0 bits";
    VectorType.VectorKind VecKind = VectorType.VectorKind.AltiVecVector;
    if (DS.isTypeAltiVecPixel()) {
      VecKind = VectorType.VectorKind.AltiVecPixel;
    } else if (DS.isTypeAltiVecBool()) {
      VecKind = VectorType.VectorKind.AltiVecBool;
    }
    Result.$assignMove(Context.getVectorType(new QualType(Result), $div_uint(128, typeSize), VecKind));
  }
  
  // FIXME: Imaginary.
  if (DS.getTypeSpecComplex() == DeclSpec.TSC.TSC_imaginary) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track(S.Diag(DS.getTypeSpecComplexLoc(), diag.err_imaginary_not_supported)));
    } finally {
      $c$.$destroy();
    }
  }
  
  // Before we process any type attributes, synthesize a block literal
  // function declarator if necessary.
  if (declarator.getContext() == Declarator.TheContext.BlockLiteralContext) {
    maybeSynthesizeBlockSignature(state, new QualType(Result));
  }
  
  // Apply any type attributes from the decl spec.  This may cause the
  // list of type attributes to be temporarily saved while the type
  // attributes are pushed around.
  // pipe attributes will be handled later ( at GetFullTypeForDeclarator )
  if (!DS.isTypeSpecPipe()) {
    processTypeAttrs(state, Result, TypeAttrLocation.TAL_DeclSpec, DS.getAttributes$Const().getList());
  }
  {
    
    // Apply const/volatile/restrict qualifiers to T.
    uint$ref TypeQuals = create_uint$ref(DS.getTypeQualifiers());
    if ((TypeQuals.$deref() != 0)) {
      // Warn about CV qualifiers on function types.
      // C99 6.7.3p8:
      //   If the specification of a function type includes any type qualifiers,
      //   the behavior is undefined.
      // C++11 [dcl.fct]p7:
      //   The effect of a cv-qualifier-seq in a function declarator is not the
      //   same as adding cv-qualification on top of the function type. In the
      //   latter case, the cv-qualifiers are ignored.
      if ((TypeQuals.$deref() != 0) && Result.$arrow().isFunctionType()) {
        diagnoseAndRemoveTypeQualifiers(S, DS, TypeQuals, new QualType(Result), DeclSpec.TQ.TQ_const.getValue() | DeclSpec.TQ.TQ_volatile.getValue(), 
            S.getLangOpts().CPlusPlus ? diag.warn_typecheck_function_qualifiers_ignored : diag.warn_typecheck_function_qualifiers_unspecified);
        // No diagnostic for 'restrict' or '_Atomic' applied to a
        // function type; we'll diagnose those later, in BuildQualifiedType.
      }
      
      // C++11 [dcl.ref]p1:
      //   Cv-qualified references are ill-formed except when the
      //   cv-qualifiers are introduced through the use of a typedef-name
      //   or decltype-specifier, in which case the cv-qualifiers are ignored.
      //
      // There don't appear to be any other contexts in which a cv-qualified
      // reference type could be formed, so the 'ill-formed' clause here appears
      // to never happen.
      if ((TypeQuals.$deref() != 0) && Result.$arrow().isReferenceType()) {
        diagnoseAndRemoveTypeQualifiers(S, DS, TypeQuals, new QualType(Result), 
            DeclSpec.TQ.TQ_const.getValue() | DeclSpec.TQ.TQ_volatile.getValue() | DeclSpec.TQ.TQ_atomic.getValue(), 
            diag.warn_typecheck_reference_qualifiers);
      }
      
      // C90 6.5.3 constraints: "The same type qualifier shall not appear more
      // than once in the same specifier-list or qualifier-list, either directly
      // or via one or more typedefs."
      if (!S.getLangOpts().C99 && !S.getLangOpts().CPlusPlus
         && ((TypeQuals.$deref() & Result.getCVRQualifiers()) != 0)) {
        if (((TypeQuals.$deref() & DeclSpec.TQ.TQ_const.getValue()) != 0) && Result.isConstQualified()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(DS.getConstSpecLoc(), diag.ext_duplicate_declspec)), 
                /*KEEP_STR*/"const"));
          } finally {
            $c$.$destroy();
          }
        }
        if (((TypeQuals.$deref() & DeclSpec.TQ.TQ_volatile.getValue()) != 0) && Result.isVolatileQualified()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(DS.getVolatileSpecLoc(), diag.ext_duplicate_declspec)), 
                /*KEEP_STR*/"volatile"));
          } finally {
            $c$.$destroy();
          }
        }
        // C90 doesn't have restrict nor _Atomic, so it doesn't force us to
        // produce a warning in this case.
      }
      
      QualType Qualified = S.BuildQualifiedType(new QualType(Result), new SourceLocation(DeclLoc), TypeQuals.$deref(), $AddrOf(DS));
      
      // If adding qualifiers fails, just use the unqualified type.
      if (Qualified.isNull()) {
        declarator.setInvalidType(true);
      } else {
        Result.$assign(Qualified);
      }
    }
  }
  assert (!Result.isNull()) : "This function should not return a null type";
  return Result;
}

//<editor-fold defaultstate="collapsed" desc="getPrintableNameForEntity">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 1739,
 FQN="getPrintableNameForEntity", NM="_ZL25getPrintableNameForEntityN5clang15DeclarationNameE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZL25getPrintableNameForEntityN5clang15DeclarationNameE")
//</editor-fold>
public static std.string getPrintableNameForEntity(DeclarationName Entity) {
  if (Entity.$bool()) {
    return Entity.getAsString();
  }
  
  return new std.string(/*KEEP_STR*/"type name");
}


/// Given that we're building a pointer or reference to the given
//<editor-fold defaultstate="collapsed" desc="inferARCLifetimeForPointee">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 1832,
 FQN="inferARCLifetimeForPointee", NM="_ZL26inferARCLifetimeForPointeeRN5clang4SemaENS_8QualTypeENS_14SourceLocationEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZL26inferARCLifetimeForPointeeRN5clang4SemaENS_8QualTypeENS_14SourceLocationEb")
//</editor-fold>
public static QualType inferARCLifetimeForPointee(final Sema /*&*/ S, QualType type, 
                          SourceLocation loc, 
                          boolean isReference) {
  // Bail out if retention is unrequired or already specified.
  if (!type.$arrow().isObjCLifetimeType()
     || type.getObjCLifetime() != Qualifiers.ObjCLifetime.OCL_None) {
    return new QualType(JD$Move.INSTANCE, type);
  }
  
  Qualifiers.ObjCLifetime implicitLifetime = Qualifiers.ObjCLifetime.OCL_None;
  
  // If the object type is const-qualified, we can safely use
  // __unsafe_unretained.  This is safe (because there are no read
  // barriers), and it'll be safe to coerce anything but __weak* to
  // the resulting type.
  if (type.isConstQualified()) {
    implicitLifetime = Qualifiers.ObjCLifetime.OCL_ExplicitNone;
    // Otherwise, check whether the static type does not require
    // retaining.  This currently only triggers for Class (possibly
    // protocol-qualifed, and arrays thereof).
  } else if (type.$arrow().isObjCARCImplicitlyUnretainedType()) {
    implicitLifetime = Qualifiers.ObjCLifetime.OCL_ExplicitNone;
    // If we are in an unevaluated context, like sizeof, skip adding a
    // qualification.
  } else if (S.isUnevaluatedContext()) {
    return new QualType(JD$Move.INSTANCE, type);
    // If that failed, give an error and recover using __strong.  __strong
    // is the option most likely to prevent spurious second-order diagnostics,
    // like when binding a reference to a field.
  } else {
    // These types can show up in private ivars in system headers, so
    // we need this to not be an error in those cases.  Instead we
    // want to delay.
    if (S.DelayedDiagnostics.shouldDelayDiagnostics()) {
      S.DelayedDiagnostics.add(DelayedDiagnostic.makeForbiddenType(new SourceLocation(loc), 
              diag.err_arc_indirect_no_ownership, new QualType(type), (isReference ? 1 : 0)));
    } else {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(loc), diag.err_arc_indirect_no_ownership)), type), isReference));
      } finally {
        $c$.$destroy();
      }
    }
    implicitLifetime = Qualifiers.ObjCLifetime.OCL_Strong;
  }
  assert ((implicitLifetime.getValue() != 0)) : "didn't infer any lifetime!";
  
  Qualifiers qs/*J*/= new Qualifiers();
  qs.addObjCLifetime(implicitLifetime);
  return S.Context.getQualifiedType(new QualType(type), new Qualifiers(qs));
}

//<editor-fold defaultstate="collapsed" desc="getFunctionQualifiersAsString">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 1883,
 FQN="getFunctionQualifiersAsString", NM="_ZL29getFunctionQualifiersAsStringPKN5clang17FunctionProtoTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZL29getFunctionQualifiersAsStringPKN5clang17FunctionProtoTypeE")
//</editor-fold>
public static std.string getFunctionQualifiersAsString(/*const*/ FunctionProtoType /*P*/ FnTy) {
  std.string Quals = Qualifiers.fromCVRMask(FnTy.getTypeQuals()).getAsString();
  switch (FnTy.getRefQualifier()) {
   case RQ_None:
    break;
   case RQ_LValue:
    if (!Quals.empty()) {
      Quals.$addassign_T($$SPACE);
    }
    Quals.$addassign_T($$AMP);
    break;
   case RQ_RValue:
    if (!Quals.empty()) {
      Quals.$addassign_T($$SPACE);
    }
    Quals.$addassign_T$C$P(/*KEEP_STR*/"&&");
    break;
  }
  
  return Quals;
}

// end anonymous namespace

/// Check whether the type T is a qualified function type, and if it is,
/// diagnose that it cannot be contained within the given kind of declarator.
//<editor-fold defaultstate="collapsed" desc="checkQualifiedFunction">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 1923,
 FQN="checkQualifiedFunction", NM="_ZL22checkQualifiedFunctionRN5clang4SemaENS_8QualTypeENS_14SourceLocationEN12_GLOBAL__N_121QualifiedFunctionKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZL22checkQualifiedFunctionRN5clang4SemaENS_8QualTypeENS_14SourceLocationEN12_GLOBAL__N_121QualifiedFunctionKindE")
//</editor-fold>
public static boolean checkQualifiedFunction(final Sema /*&*/ S, QualType T, SourceLocation Loc, 
                      QualifiedFunctionKind QFK) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    // Does T refer to a function type with a cv-qualifier or a ref-qualifier?
    /*const*/ FunctionProtoType /*P*/ FPT = T.$arrow().getAs(FunctionProtoType.class);
    if (!(FPT != null) || (FPT.getTypeQuals() == 0 && FPT.getRefQualifier() == RefQualifierKind.RQ_None)) {
      return false;
    }
    
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc), diag.err_compound_qualified_function_type)), 
                    QFK), isa_FunctionType(T.IgnoreParens())), T), 
        getFunctionQualifiersAsString(FPT)));
    return true;
  } finally {
    $c$.$destroy();
  }
}


/// Check whether the specified array size makes the array type a VLA.  If so,
/// return true, if not, return the size of the array in SizeVal.
//<editor-fold defaultstate="collapsed" desc="isArraySizeVLA">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 2050,
 FQN="isArraySizeVLA", NM="_ZL14isArraySizeVLARN5clang4SemaEPNS_4ExprERN4llvm6APSIntE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZL14isArraySizeVLARN5clang4SemaEPNS_4ExprERN4llvm6APSIntE")
//</editor-fold>
public static boolean isArraySizeVLA(final Sema /*&*/ S, Expr /*P*/ ArraySize, final APSInt /*&*/ SizeVal) {
   Sema.VerifyICEDiagnoser Diagnoser = null;
  try {
    // If the size is an ICE, it certainly isn't a VLA. If we're in a GNU mode
    // (like gnu99, but not c99) accept any evaluatable value as an extension.
    //<editor-fold defaultstate="collapsed" desc="VLADiagnoser">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 2053,
     FQN="VLADiagnoser", NM="_ZZL14isArraySizeVLARN5clang4SemaEPNS_4ExprERN4llvm6APSIntEE12VLADiagnoser",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZZL14isArraySizeVLARN5clang4SemaEPNS_4ExprERN4llvm6APSIntEE12VLADiagnoser")
    //</editor-fold>
     class VLADiagnoser extends /*public*/ Sema.VerifyICEDiagnoser implements Destructors.ClassWithDestructor {
    /*public:*/
      //<editor-fold defaultstate="collapsed" desc="isArraySizeVLA(Sema & , Expr * , APSInt & )::VLADiagnoser::VLADiagnoser">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 2055,
       FQN="isArraySizeVLA(Sema & , Expr * , APSInt & )::VLADiagnoser::VLADiagnoser", NM="_ZZL14isArraySizeVLARN5clang4SemaEPNS_4ExprERN4llvm6APSIntEEN12VLADiagnoserC1Ev",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZZL14isArraySizeVLARN5clang4SemaEPNS_4ExprERN4llvm6APSIntEEN12VLADiagnoserC1Ev")
      //</editor-fold>
      public VLADiagnoser() {
        // : Sema::VerifyICEDiagnoser(true) 
        //START JInit
        super(true);
        //END JInit
      }

      
      //<editor-fold defaultstate="collapsed" desc="isArraySizeVLA(Sema & , Expr * , APSInt & )::VLADiagnoser::diagnoseNotICE">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 2057,
       FQN="isArraySizeVLA(Sema & , Expr * , APSInt & )::VLADiagnoser::diagnoseNotICE", NM="_ZZL14isArraySizeVLARN5clang4SemaEPNS_4ExprERN4llvm6APSIntEEN12VLADiagnoser14diagnoseNotICEES1_NS_14SourceLocationENS_11SourceRangeE",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZZL14isArraySizeVLARN5clang4SemaEPNS_4ExprERN4llvm6APSIntEEN12VLADiagnoser14diagnoseNotICEES1_NS_14SourceLocationENS_11SourceRangeE")
      //</editor-fold>
      @Override public void diagnoseNotICE(final Sema /*&*/ S, SourceLocation Loc, SourceRange SR)/* override*/ {
      }

      
      //<editor-fold defaultstate="collapsed" desc="isArraySizeVLA(Sema & , Expr * , APSInt & )::VLADiagnoser::diagnoseFold">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 2060,
       FQN="isArraySizeVLA(Sema & , Expr * , APSInt & )::VLADiagnoser::diagnoseFold", NM="_ZZL14isArraySizeVLARN5clang4SemaEPNS_4ExprERN4llvm6APSIntEEN12VLADiagnoser12diagnoseFoldES1_NS_14SourceLocationENS_11SourceRangeE",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZZL14isArraySizeVLARN5clang4SemaEPNS_4ExprERN4llvm6APSIntEEN12VLADiagnoser12diagnoseFoldES1_NS_14SourceLocationENS_11SourceRangeE")
      //</editor-fold>
      @Override public void diagnoseFold(final Sema /*&*/ S, SourceLocation Loc, SourceRange SR)/* override*/ {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc), diag.ext_vla_folded_to_constant)), SR));
        } finally {
          $c$.$destroy();
        }
      }

      //<editor-fold defaultstate="collapsed" desc="isArraySizeVLA(Sema & , Expr * , APSInt & )::VLADiagnoser::~VLADiagnoser">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 2053,
       FQN="isArraySizeVLA(Sema & , Expr * , APSInt & )::VLADiagnoser::~VLADiagnoser", NM="_ZZL14isArraySizeVLARN5clang4SemaEPNS_4ExprERN4llvm6APSIntEEN12VLADiagnoserD0Ev",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZZL14isArraySizeVLARN5clang4SemaEPNS_4ExprERN4llvm6APSIntEEN12VLADiagnoserD0Ev")
      //</editor-fold>
      @Override public /*inline*/ void $destroy() {
        super.$destroy();
      }

      
      @Override public String toString() {
        return "" + super.toString(); // NOI18N
      }
    }; Diagnoser/*J*/= new VLADiagnoser();
    
    return S.VerifyIntegerConstantExpression(ArraySize, $AddrOf(SizeVal), Diagnoser, 
        S.LangOpts.GNUMode
           || S.LangOpts.OpenCL).isInvalid();
  } finally {
    if (Diagnoser != null) { Diagnoser.$destroy(); }
  }
}


/// Check the extended parameter information.  Most of the necessary
/// checking should occur when applying the parameter attribute; the
/// only other checks required are positional restrictions.
//<editor-fold defaultstate="collapsed" desc="checkExtParameterInfos">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 2359,
 FQN="checkExtParameterInfos", NM="_ZL22checkExtParameterInfosRN5clang4SemaEN4llvm8ArrayRefINS_8QualTypeEEERKNS_17FunctionProtoType12ExtProtoInfoENS2_12function_refIFNS_14SourceLocationEjEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZL22checkExtParameterInfosRN5clang4SemaEN4llvm8ArrayRefINS_8QualTypeEEERKNS_17FunctionProtoType12ExtProtoInfoENS2_12function_refIFNS_14SourceLocationEjEEE")
//</editor-fold>
public static void checkExtParameterInfos(final Sema /*&*/ S, ArrayRef<QualType> paramTypes, 
                      final /*const*/ FunctionProtoType.ExtProtoInfo /*&*/ EPI, 
                      UInt2SourceLocation getParamLoc) {
  assert ((EPI.ExtParameterInfos != null)) : "shouldn't get here without param infos";
  
  final boolean hasCheckedSwiftCall[] = new boolean[]{false};
  CheckForSwiftCCUnsigned2Void checkForSwiftCC = (paramIndex) -> 
    {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // Only do this once.
        if (hasCheckedSwiftCall[0]) {
          return;
        }
        hasCheckedSwiftCall[0] = true;
        if (EPI.ExtInfo.getCC() == CallingConv.CC_Swift) {
          return;
        }
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(getParamLoc.$call(paramIndex), diag.err_swift_param_attr_not_swiftcall)), 
            BasicClangGlobals.getParameterABISpelling(EPI.ExtParameterInfos.$at(paramIndex).getABI())));
      } finally {
        $c$.$destroy();
      }
    }
;
  
  for (/*size_t*/int paramIndex = 0, numParams = paramTypes.size();
       paramIndex != numParams; ++paramIndex) {
    switch (EPI.ExtParameterInfos.$at(paramIndex).getABI()) {
     case Ordinary:
      // Nothing interesting to check for orindary-ABI parameters.
      continue;
     case SwiftIndirectResult:
      
      // swift_indirect_result parameters must be a prefix of the function
      // arguments.
      checkForSwiftCC.$call(paramIndex);
      if (paramIndex != 0
         && EPI.ExtParameterInfos.$at(paramIndex - 1).getABI()
         != ParameterABI.SwiftIndirectResult) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track(S.Diag(getParamLoc.$call(paramIndex), 
              diag.err_swift_indirect_result_not_first)));
        } finally {
          $c$.$destroy();
        }
      }
      continue;
     case SwiftContext:
      
      // swift_context parameters must be the last parameter except for
      // a possible swift_error parameter.
      checkForSwiftCC.$call(paramIndex);
      if (!(paramIndex == numParams - 1
         || (paramIndex == numParams - 2
         && EPI.ExtParameterInfos.$at(numParams - 1).getABI()
         == ParameterABI.SwiftErrorResult))) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track(S.Diag(getParamLoc.$call(paramIndex), 
              diag.err_swift_context_not_before_swift_error_result)));
        } finally {
          $c$.$destroy();
        }
      }
      continue;
     case SwiftErrorResult:
      
      // swift_error parameters must be the last parameter.
      checkForSwiftCC.$call(paramIndex);
      if (paramIndex != numParams - 1) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track(S.Diag(getParamLoc.$call(paramIndex), 
              diag.err_swift_error_result_not_last)));
        } finally {
          $c$.$destroy();
        }
      } else if (paramIndex == 0
         || EPI.ExtParameterInfos.$at(paramIndex - 1).getABI()
         != ParameterABI.SwiftContext) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track(S.Diag(getParamLoc.$call(paramIndex), 
              diag.err_swift_error_result_not_after_swift_context)));
        } finally {
          $c$.$destroy();
        }
      }
      continue;
    }
    throw new llvm_unreachable("bad ABI kind");
  }
}

//<editor-fold defaultstate="collapsed" desc="transferARCOwnershipToDeclaratorChunk">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 4607,
 FQN="transferARCOwnershipToDeclaratorChunk", NM="_ZL37transferARCOwnershipToDeclaratorChunkRN12_GLOBAL__N_119TypeProcessingStateEN5clang10Qualifiers12ObjCLifetimeEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZL37transferARCOwnershipToDeclaratorChunkRN12_GLOBAL__N_119TypeProcessingStateEN5clang10Qualifiers12ObjCLifetimeEj")
//</editor-fold>
public static void transferARCOwnershipToDeclaratorChunk(final TypeProcessingState /*&*/ state, 
                                     Qualifiers.ObjCLifetime ownership, 
                                     /*uint*/int chunkIndex) {
  final Sema /*&*/ S = state.getSema();
  final Declarator /*&*/ D = state.getDeclarator();
  
  // Look for an explicit lifetime attribute.
  final DeclaratorChunk /*&*/ chunk = D.getTypeObject(chunkIndex);
  for (/*const*/ AttributeList /*P*/ attr = chunk.getAttrs(); (attr != null);
       attr = attr.getNext())  {
    if (attr.getKind() == AttributeList.Kind.AT_ObjCOwnership) {
      return;
    }
  }
  
  /*const*/char$ptr/*char P*/ attrStr = null;
  switch (ownership) {
   case OCL_None:
    throw new llvm_unreachable("no ownership!");
   case OCL_ExplicitNone:
    attrStr = $tryClone($("none"));
    break;
   case OCL_Strong:
    attrStr = $tryClone($("strong"));
    break;
   case OCL_Weak:
    attrStr = $tryClone($("weak"));
    break;
   case OCL_Autoreleasing:
    attrStr = $tryClone($("autoreleasing"));
    break;
  }
  
  IdentifierLoc /*P*/ Arg = /*FIXME:NEW_EXPR*//*new (S.Context)*/ new IdentifierLoc();
  Arg.Ident = $AddrOf(S.Context.Idents.get(new StringRef(attrStr)));
  Arg.Loc.$assignMove(new SourceLocation());
  
  type$ptr<PointerUnion<Expr /*P*/ , IdentifierLoc /*P*/ >> Args/*J*/= create_type$ptr(new PointerUnion<Expr /*P*/ , IdentifierLoc /*P*/ >(JD$T1.INSTANCE, IdentifierLoc /*P*/ .class, Arg));
  
  // If there wasn't one, add one (with an invalid source location
  // so that we don't make an AttributedType for it).
  AttributeList /*P*/ attr = D.getAttributePool().
      create($AddrOf(S.Context.Idents.get(new StringRef(/*KEEP_STR*/"objc_ownership"))), new SourceRange(new SourceLocation()), 
      /*scope*/ (IdentifierInfo /*P*/ )null, new SourceLocation(), 
      /*args*/ $AddrOf(Args), 1, AttributeList.Syntax.AS_GNU);
  spliceAttrIntoList($Deref(attr), chunk.getAttrListRef());
  // TODO: mark whether we did this inference?
}


/// Given that this is the declaration of a parameter under ARC,
/// attempt to infer attributes and such for pointer-to-whatever
/// types.
//<editor-fold defaultstate="collapsed" desc="inferARCWriteback">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 2557,
 FQN="inferARCWriteback", NM="_ZL17inferARCWritebackRN12_GLOBAL__N_119TypeProcessingStateERN5clang8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZL17inferARCWritebackRN12_GLOBAL__N_119TypeProcessingStateERN5clang8QualTypeE")
//</editor-fold>
public static void inferARCWriteback(final TypeProcessingState /*&*/ state, 
                 final QualType /*&*/ declSpecType) {
  final Sema /*&*/ S = state.getSema();
  final Declarator /*&*/ declarator = state.getDeclarator();
  
  // TODO: should we care about decl qualifiers?
  
  // Check whether the declarator has the expected form.  We walk
  // from the inside out in order to make the block logic work.
  /*uint*/int outermostPointerIndex = 0;
  boolean isBlockPointer = false;
  /*uint*/int numPointers = 0;
  done: for (/*uint*/int i = 0, e = declarator.getNumTypeObjects(); i != e; ++i) {
    /*uint*/int chunkIndex = i;
    final DeclaratorChunk /*&*/ chunk = declarator.getTypeObject(chunkIndex);
    switch (chunk.Kind) {
     case Paren:
      // Ignore parens.
      break;
     case Reference:
     case Pointer:
      // Count the number of pointers.  Treat references
      // interchangeably as pointers; if they're mis-ordered, normal
      // type building will discover that.
      outermostPointerIndex = chunkIndex;
      numPointers++;
      break;
     case BlockPointer:
      // If we have a pointer to block pointer, that's an acceptable
      // indirect reference; anything else is not an application of
      // the rules.
      if (numPointers != 1) {
        return;
      }
      numPointers++;
      outermostPointerIndex = chunkIndex;
      isBlockPointer = true;
      
      // We don't care about pointer structure in return values here.
      break done;
     case Array: // suppress if written (id[])?
     case Function:
     case MemberPointer:
     case Pipe:
      return;
    }
  }
 //done:
  
  // If we have *one* pointer, then we want to throw the qualifier on
  // the declaration-specifiers, which means that it needs to be a
  // retainable object type.
  if (numPointers == 1) {
    // If it's not a retainable object type, the rule doesn't apply.
    if (!declSpecType.$arrow().isObjCRetainableType()) {
      return;
    }
    
    // If it already has lifetime, don't do anything.
    if ((declSpecType.getObjCLifetime().getValue() != 0)) {
      return;
    }
    
    // Otherwise, modify the type in-place.
    Qualifiers qs/*J*/= new Qualifiers();
    if (declSpecType.$arrow().isObjCARCImplicitlyUnretainedType()) {
      qs.addObjCLifetime(Qualifiers.ObjCLifetime.OCL_ExplicitNone);
    } else {
      qs.addObjCLifetime(Qualifiers.ObjCLifetime.OCL_Autoreleasing);
    }
    declSpecType.$assignMove(S.Context.getQualifiedType(new QualType(declSpecType), new Qualifiers(qs)));
    // If we have *two* pointers, then we want to throw the qualifier on
    // the outermost pointer.
  } else if (numPointers == 2) {
    // If we don't have a block pointer, we need to check whether the
    // declaration-specifiers gave us something that will turn into a
    // retainable object pointer after we slap the first pointer on it.
    if (!isBlockPointer && !declSpecType.$arrow().isObjCObjectType()) {
      return;
    }
    
    // Look for an explicit lifetime attribute there.
    final DeclaratorChunk /*&*/ chunk = declarator.getTypeObject(outermostPointerIndex);
    if (chunk.Kind != DeclaratorChunk.Unnamed_enum.Pointer
       && chunk.Kind != DeclaratorChunk.Unnamed_enum.BlockPointer) {
      return;
    }
    for (/*const*/ AttributeList /*P*/ attr = chunk.getAttrs(); (attr != null);
         attr = attr.getNext())  {
      if (attr.getKind() == AttributeList.Kind.AT_ObjCOwnership) {
        return;
      }
    }
    
    transferARCOwnershipToDeclaratorChunk(state, Qualifiers.ObjCLifetime.OCL_Autoreleasing, 
        outermostPointerIndex);
    // Any other number of pointers/references does not trigger the rule.
  } else {
    return;
  }
  // TODO: mark whether we did this inference?
}


// Diagnose pointless type qualifiers on the return type of a function.
//<editor-fold defaultstate="collapsed" desc="diagnoseRedundantReturnTypeQualifiers">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 2705,
 FQN="diagnoseRedundantReturnTypeQualifiers", NM="_ZL37diagnoseRedundantReturnTypeQualifiersRN5clang4SemaENS_8QualTypeERNS_10DeclaratorEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZL37diagnoseRedundantReturnTypeQualifiersRN5clang4SemaENS_8QualTypeERNS_10DeclaratorEj")
//</editor-fold>
public static void diagnoseRedundantReturnTypeQualifiers(final Sema /*&*/ S, QualType RetTy, 
                                     final Declarator /*&*/ D, 
                                     /*uint*/int FunctionChunkIndex) {
  if (D.getTypeObject(FunctionChunkIndex).Unnamed_field3.Fun.hasTrailingReturnType()) {
    // FIXME: TypeSourceInfo doesn't preserve location information for
    // qualifiers.
    S.diagnoseIgnoredQualifiers(diag.warn_qual_return_type, 
        RetTy.getLocalCVRQualifiers(), 
        D.getIdentifierLoc());
    return;
  }
  
  for (/*uint*/int OuterChunkIndex = FunctionChunkIndex + 1, 
      End = D.getNumTypeObjects();
       OuterChunkIndex != End; ++OuterChunkIndex) {
    final DeclaratorChunk /*&*/ OuterChunk = D.getTypeObject(OuterChunkIndex);
    switch (OuterChunk.Kind) {
     case Paren:
      continue;
     case Pointer:
      {
        final DeclaratorChunk.PointerTypeInfo /*&*/ PTI = OuterChunk.Unnamed_field3.Ptr;
        S.diagnoseIgnoredQualifiers(diag.warn_qual_return_type, 
            PTI.TypeQuals, 
            new SourceLocation(), 
            SourceLocation.getFromRawEncoding(PTI.ConstQualLoc), 
            SourceLocation.getFromRawEncoding(PTI.VolatileQualLoc), 
            SourceLocation.getFromRawEncoding(PTI.RestrictQualLoc), 
            SourceLocation.getFromRawEncoding(PTI.AtomicQualLoc), 
            SourceLocation.getFromRawEncoding(PTI.UnalignedQualLoc));
        return;
      }
     case Function:
     case BlockPointer:
     case Reference:
     case Array:
     case MemberPointer:
     case Pipe:
      // FIXME: We can't currently provide an accurate source location and a
      // fix-it hint for these.
      /*uint*/int AtomicQual = RetTy.$arrow().isAtomicType() ? DeclSpec.TQ.TQ_atomic.getValue() : 0;
      S.diagnoseIgnoredQualifiers(diag.warn_qual_return_type, 
          RetTy.getCVRQualifiers() | AtomicQual, 
          D.getIdentifierLoc());
      return;
    }
    throw new llvm_unreachable("unknown declarator chunk kind");
  }
  
  // If the qualifiers come from a conversion function type, don't diagnose
  // them -- they're not necessarily redundant, since such a conversion
  // operator can be explicitly called as "x.operator const int()".
  if (D.getName().getKind() == UnqualifiedId.IdKind.IK_ConversionFunctionId) {
    return;
  }
  
  // Just parens all the way out to the decl specifiers. Diagnose any qualifiers
  // which are present there.
  S.diagnoseIgnoredQualifiers(diag.warn_qual_return_type, 
      D.getDeclSpec().getTypeQualifiers(), 
      D.getIdentifierLoc(), 
      D.getDeclSpec().getConstSpecLoc(), 
      D.getDeclSpec().getVolatileSpecLoc(), 
      D.getDeclSpec().getRestrictSpecLoc(), 
      D.getDeclSpec().getAtomicSpecLoc(), 
      D.getDeclSpec().getUnalignedSpecLoc());
}

//<editor-fold defaultstate="collapsed" desc="GetDeclSpecTypeForDeclarator">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 2775,
 FQN="GetDeclSpecTypeForDeclarator", NM="_ZL28GetDeclSpecTypeForDeclaratorRN12_GLOBAL__N_119TypeProcessingStateERPN5clang14TypeSourceInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZL28GetDeclSpecTypeForDeclaratorRN12_GLOBAL__N_119TypeProcessingStateERPN5clang14TypeSourceInfoE")
//</editor-fold>
public static QualType GetDeclSpecTypeForDeclarator(final TypeProcessingState /*&*/ state, 
                            final type$ptr<TypeSourceInfo/*P*/>/*&*/ ReturnTypeInfo) {
  final Sema /*&*/ SemaRef = state.getSema();
  final Declarator /*&*/ D = state.getDeclarator();
  QualType T/*J*/= new QualType();
  ReturnTypeInfo.$set(null);
  
  // The TagDecl owned by the DeclSpec.
  TagDecl /*P*/ OwnedTagDecl = null;
  switch (D.getName().getKind()) {
   case IK_ImplicitSelfParam:
   case IK_OperatorFunctionId:
   case IK_Identifier:
   case IK_LiteralOperatorId:
   case IK_TemplateId:
    T.$assignMove(ConvertDeclSpecToType(state));
    if (!D.isInvalidType() && D.getDeclSpec().isTypeSpecOwned()) {
      OwnedTagDecl = cast_TagDecl(D.getDeclSpec().getRepAsDecl());
      // Owned declaration is embedded in declarator.
      OwnedTagDecl.setEmbeddedInDeclarator(true);
    }
    break;
   case IK_ConstructorName:
   case IK_ConstructorTemplateId:
   case IK_DestructorName:
    // Constructors and destructors don't have return types. Use
    // "void" instead.
    T.$assignMove(SemaRef.Context.VoidTy.$QualType());
    processTypeAttrs(state, T, TypeAttrLocation.TAL_DeclSpec, 
        D.getDeclSpec().getAttributes$Const().getList());
    break;
   case IK_ConversionFunctionId:
    // The result type of a conversion function is the type that it
    // converts to.
    T.$assignMove(SemaRef.GetTypeFromParser(D.getName().Unnamed_field1.ConversionFunctionId.$OpaquePtr$T(), 
            ReturnTypeInfo));
    break;
  }
  if ((D.getAttributes() != null)) {
    distributeTypeAttrsFromDeclarator(state, T);
  }
  
  // C++11 [dcl.spec.auto]p5: reject 'auto' if it is not in an allowed context.
  if (D.getDeclSpec().containsPlaceholderType()) {
    int Error = -1;
    switch (D.getContext()) {
     case LambdaExprContext:
      throw new llvm_unreachable("Can't specify a type specifier in lambda grammar");
     case ObjCParameterContext:
     case ObjCResultContext:
     case PrototypeContext:
      Error = 0;
      break;
     case LambdaExprParameterContext:
      // In C++14, generic lambdas allow 'auto' in their parameters.
      if (!(SemaRef.getLangOpts().CPlusPlus14
         && D.getDeclSpec().getTypeSpecType() == DeclSpec.TST_auto)) {
        Error = 16;
      }
      break;
     case MemberContext:
      {
        if (D.getDeclSpec().getStorageClassSpec() == DeclSpec.SCS.SCS_static
           || D.isFunctionDeclarator()) {
          break;
        }
        boolean Cxx = SemaRef.getLangOpts().CPlusPlus;
        switch (cast_TagDecl(SemaRef.CurContext).getTagKind()) {
         case TTK_Enum:
          throw new llvm_unreachable("unhandled tag kind");
         case TTK_Struct:
          Error = Cxx ? 1 : 2; /* Struct member */
          break;
         case TTK_Union:
          Error = Cxx ? 3 : 4; /* Union member */
          break;
         case TTK_Class:
          Error = 5; /* Class member */
          break;
         case TTK_Interface:
          Error = 6; /* Interface member */
          break;
        }
        break;
      }
     case CXXCatchContext:
     case ObjCCatchContext:
      Error = 7; // Exception declaration
      break;
     case TemplateParamContext:
      Error = 8; // Template parameter
      break;
     case BlockLiteralContext:
      Error = 9; // Block literal
      break;
     case TemplateTypeArgContext:
      Error = 10; // Template type argument
      break;
     case AliasDeclContext:
     case AliasTemplateContext:
      Error = 12; // Type alias
      break;
     case TrailingReturnContext:
      if (!SemaRef.getLangOpts().CPlusPlus14
         || D.getDeclSpec().getTypeSpecType() == DeclSpec.TST_auto_type) {
        Error = 13; // Function return type
      }
      break;
     case ConversionIdContext:
      if (!SemaRef.getLangOpts().CPlusPlus14
         || D.getDeclSpec().getTypeSpecType() == DeclSpec.TST_auto_type) {
        Error = 14; // conversion-type-id
      }
      break;
     case TypeNameContext:
      Error = 15; // Generic
      break;
     case FileContext:
     case BlockContext:
     case ForContext:
     case InitStmtContext:
     case ConditionContext:
      break;
     case CXXNewContext:
      if (D.getDeclSpec().getTypeSpecType() == DeclSpec.TST_auto_type) {
        Error = 17; // 'new' type
      }
      break;
     case KNRTypeListContext:
      Error = 18; // K&R function parameter
      break;
    }
    if (D.getDeclSpec().getStorageClassSpec() == DeclSpec.SCS.SCS_typedef) {
      Error = 11;
    }
    
    // In Objective-C it is an error to use 'auto' on a function declarator
    // (and everywhere for '__auto_type').
    if (D.isFunctionDeclarator()
       && (!SemaRef.getLangOpts().CPlusPlus11
       || D.getDeclSpec().getTypeSpecType() == DeclSpec.TST_auto_type)) {
      Error = 13;
    }
    
    boolean HaveTrailing = false;
    
    // C++11 [dcl.spec.auto]p2: 'auto' is always fine if the declarator
    // contains a trailing return type. That is only legal at the outermost
    // level. Check all declarator chunks (outermost first) anyway, to give
    // better diagnostics.
    // We don't support '__auto_type' with trailing return types.
    if (SemaRef.getLangOpts().CPlusPlus11
       && D.getDeclSpec().getTypeSpecType() != DeclSpec.TST_auto_type) {
      for (/*uint*/int i = 0, e = D.getNumTypeObjects(); i != e; ++i) {
        /*uint*/int chunkIndex = e - i - 1;
        state.setCurrentChunkIndex(chunkIndex);
        final DeclaratorChunk /*&*/ DeclType = D.getTypeObject(chunkIndex);
        if (DeclType.Kind == DeclaratorChunk.Unnamed_enum.Function) {
          final /*const*/ DeclaratorChunk.FunctionTypeInfo /*&*/ FTI = DeclType.Unnamed_field3.Fun;
          if (FTI.hasTrailingReturnType()) {
            HaveTrailing = true;
            Error = -1;
            break;
          }
        }
      }
    }
    
    SourceRange AutoRange = new SourceRange(D.getDeclSpec().getTypeSpecTypeLoc());
    if (D.getName().getKind() == UnqualifiedId.IdKind.IK_ConversionFunctionId) {
      AutoRange.$assignMove(D.getName().getSourceRange());
    }
    if (Error != -1) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        /*uint*/int Keyword;
        switch (D.getDeclSpec().getTypeSpecType()) {
         case TST_auto:
          Keyword = 0;
          break;
         case TST_decltype_auto:
          Keyword = 1;
          break;
         case TST_auto_type:
          Keyword = 2;
          break;
         default:
          throw new llvm_unreachable("unknown auto TypeSpecType");
        }
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(AutoRange.getBegin(), diag.err_auto_not_allowed)), 
                    Keyword), Error), AutoRange));
        T.$assignMove(SemaRef.Context.IntTy.$QualType());
        D.setInvalidType(true);
      } finally {
        $c$.$destroy();
      }
    } else if (!HaveTrailing) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // If there was a trailing return type, we already got
        // warn_cxx98_compat_trailing_return_type in the parser.
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(AutoRange.getBegin(), 
                diag.warn_cxx98_compat_auto_type_specifier)), 
            AutoRange));
      } finally {
        $c$.$destroy();
      }
    }
  }
  if (SemaRef.getLangOpts().CPlusPlus
     && $bool2uint_1bit((OwnedTagDecl != null)) && OwnedTagDecl.isCompleteDefinition()) {
    // Check the contexts where C++ forbids the declaration of a new class
    // or enumeration in a type-specifier-seq.
    /*uint*/int DiagID = 0;
    switch (D.getContext()) {
     case TrailingReturnContext:
      // Class and enumeration definitions are syntactically not allowed in
      // trailing return types.
      throw new llvm_unreachable("parser should not have allowed this");
//      break;
     case FileContext:
     case MemberContext:
     case BlockContext:
     case ForContext:
     case InitStmtContext:
     case BlockLiteralContext:
     case LambdaExprContext:
     case AliasDeclContext:
      // C++11 [dcl.type]p3:
      //   A type-specifier-seq shall not define a class or enumeration unless
      //   it appears in the type-id of an alias-declaration (7.1.3) that is not
      //   the declaration of a template-declaration.
      break;
     case AliasTemplateContext:
      DiagID = diag.err_type_defined_in_alias_template;
      break;
     case TypeNameContext:
     case ConversionIdContext:
     case TemplateParamContext:
     case CXXNewContext:
     case CXXCatchContext:
     case ObjCCatchContext:
     case TemplateTypeArgContext:
      DiagID = diag.err_type_defined_in_type_specifier;
      break;
     case PrototypeContext:
     case LambdaExprParameterContext:
     case ObjCParameterContext:
     case ObjCResultContext:
     case KNRTypeListContext:
      // C++ [dcl.fct]p6:
      //   Types shall not be defined in return or parameter types.
      DiagID = diag.err_type_defined_in_param_type;
      break;
     case ConditionContext:
      // C++ 6.4p2:
      // The type-specifier-seq shall not contain typedef and shall not declare
      // a new class or enumeration.
      DiagID = diag.err_type_defined_in_condition;
      break;
    }
    if (DiagID != 0) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(OwnedTagDecl.getLocation(), DiagID)), 
            SemaRef.Context.getTypeDeclType(OwnedTagDecl)));
        D.setInvalidType(true);
      } finally {
        $c$.$destroy();
      }
    }
  }
  assert (!T.isNull()) : "This function should not return a null type";
  return T;
}


/// Produce an appropriate diagnostic for an ambiguity between a function
/// declarator and a C++ direct-initializer.
//<editor-fold defaultstate="collapsed" desc="warnAboutAmbiguousFunction">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 3023,
 FQN="warnAboutAmbiguousFunction", NM="_ZL26warnAboutAmbiguousFunctionRN5clang4SemaERNS_10DeclaratorERNS_15DeclaratorChunkENS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZL26warnAboutAmbiguousFunctionRN5clang4SemaERNS_10DeclaratorERNS_15DeclaratorChunkENS_8QualTypeE")
//</editor-fold>
public static void warnAboutAmbiguousFunction(final Sema /*&*/ S, final Declarator /*&*/ D, 
                          final DeclaratorChunk /*&*/ DeclType, QualType RT) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    final /*const*/ DeclaratorChunk.FunctionTypeInfo /*&*/ FTI = DeclType.Unnamed_field3.Fun;
    assert (FTI.isAmbiguous) : "no direct-initializer / function ambiguity";
    
    // If the return type is void there is no ambiguity.
    if (RT.$arrow().isVoidType()) {
      return;
    }
    
    // An initializer for a non-class type can have at most one argument.
    if (!RT.$arrow().isRecordType() && $greater_uint(FTI.NumParams, 1)) {
      return;
    }
    
    // An initializer for a reference must have exactly one argument.
    if (RT.$arrow().isReferenceType() && FTI.NumParams != 1) {
      return;
    }
    
    // Only warn if this declarator is declaring a function at block scope, and
    // doesn't have a storage class (such as 'extern') specified.
    if (!D.isFunctionDeclarator()
       || D.getFunctionDefinitionKind() != FunctionDefinitionKind.FDK_Declaration
       || !S.CurContext.isFunctionOrMethod()
       || D.getDeclSpec().getStorageClassSpec()
       != DeclSpec.SCS.SCS_unspecified) {
      return;
    }
    
    // Inside a condition, a direct initializer is not permitted. We allow one to
    // be parsed in order to give better diagnostics in condition parsing.
    if (D.getContext() == Declarator.TheContext.ConditionContext) {
      return;
    }
    
    SourceRange ParenRange/*J*/= new SourceRange(/*NO_COPY*/DeclType.Loc, /*NO_COPY*/DeclType.EndLoc);
    
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(DeclType.Loc), 
            (FTI.NumParams != 0) ? diag.warn_parens_disambiguated_as_function_declaration : diag.warn_empty_parens_are_function_decl)), 
        ParenRange));
    
    // If the declaration looks like:
    //   T var1,
    //   f();
    // and name lookup finds a function named 'f', then the ',' was
    // probably intended to be a ';'.
    if (!D.isFirstDeclarator() && (D.getIdentifier() != null)) {
      FullSourceLoc Comma/*J*/= new FullSourceLoc(D.getCommaLoc(), S.SourceMgr);
      FullSourceLoc Name/*J*/= new FullSourceLoc(D.getIdentifierLoc(), S.SourceMgr);
      if (Comma.getFileID().$noteq(Name.getFileID())
         || Comma.getSpellingLineNumber() != Name.getSpellingLineNumber()) {
        LookupResult Result = null;
        try {
          Result/*J*/= new LookupResult(S, new DeclarationName(D.getIdentifier()), new SourceLocation(), 
              Sema.LookupNameKind.LookupOrdinaryName);
          if (S.LookupName(Result, S.getCurScope())) {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(D.getCommaLoc(), diag.note_empty_parens_function_call)), 
                    FixItHint.CreateReplacement(new SourceRange(D.getCommaLoc()), new StringRef(/*KEEP_STR*/$SEMI))), 
                D.getIdentifier()));
          }
        } finally {
          if (Result != null) { Result.$destroy(); }
        }
      }
    }
    if ($greater_uint(FTI.NumParams, 0)) {
      // For a declaration with parameters, eg. "T var(T());", suggest adding
      // parens around the first parameter to turn the declaration into a
      // variable declaration.
      SourceRange Range = FTI.Params.$at(0).Param.getSourceRange();
      SourceLocation B = Range.getBegin();
      SourceLocation E = S.getLocForEndOfToken(Range.getEnd());
      // FIXME: Maybe we should suggest adding braces instead of parens
      // in C++11 for classes that don't have an initializer_list constructor.
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(B), diag.note_additional_parens_for_variable_declaration)), 
              FixItHint.CreateInsertion(/*NO_COPY*/B, new StringRef(/*KEEP_STR*/$LPAREN))), 
          FixItHint.CreateInsertion(/*NO_COPY*/E, new StringRef(/*KEEP_STR*/$RPAREN))));
    } else {
      // For a declaration without parameters, eg. "T var();", suggest replacing
      // the parens with an initializer to turn the declaration into a variable
      // declaration.
      /*const*/ CXXRecordDecl /*P*/ RD = RT.$arrow().getAsCXXRecordDecl();
      
      // Empty parens mean value-initialization, and no parens mean
      // default initialization. These are equivalent if the default
      // constructor is user-provided or if zero-initialization is a
      // no-op.
      if ((RD != null) && RD.hasDefinition()
         && (RD.isEmpty() || RD.hasUserProvidedDefaultConstructor())) {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(DeclType.Loc), diag.note_empty_parens_default_ctor)), 
            FixItHint.CreateRemoval(/*NO_COPY*/ParenRange)));
      } else {
        std.string Init = S.getFixItZeroInitializerForType(new QualType(RT), ParenRange.getBegin());
        if (Init.empty() && S.LangOpts.CPlusPlus11) {
          Init.$assign_T$C$P(/*KEEP_STR*/"{}");
        }
        if (!Init.empty()) {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(DeclType.Loc), diag.note_empty_parens_zero_initialize)), 
              FixItHint.CreateReplacement(/*NO_COPY*/ParenRange, new StringRef(Init))));
        }
      }
    }
  } finally {
    $c$.$destroy();
  }
}


/// Helper for figuring out the default CC for a function declarator type.  If
/// this is the outermost chunk, then we can determine the CC from the
/// declarator context.  If not, then this could be either a member function
/// type or normal function type.
//<editor-fold defaultstate="collapsed" desc="getCCForDeclaratorChunk">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 3122,
 FQN="getCCForDeclaratorChunk", NM="_ZL23getCCForDeclaratorChunkRN5clang4SemaERNS_10DeclaratorERKNS_15DeclaratorChunk16FunctionTypeInfoEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZL23getCCForDeclaratorChunkRN5clang4SemaERNS_10DeclaratorERKNS_15DeclaratorChunk16FunctionTypeInfoEj")
//</editor-fold>
public static CallingConv getCCForDeclaratorChunk(final Sema /*&*/ S, final Declarator /*&*/ D, 
                       final /*const*/ DeclaratorChunk.FunctionTypeInfo /*&*/ FTI, 
                       /*uint*/int ChunkIndex) {
  assert (D.getTypeObject(ChunkIndex).Kind == DeclaratorChunk.Unnamed_enum.Function);
  
  // Check for an explicit CC attribute.
  for (AttributeList /*P*/ Attr = FTI.$getAttrList(); (Attr != null); Attr = Attr.getNext()) {
    switch (Attr.getKind()) {
     case AT_CDecl:
     case AT_FastCall:
     case AT_StdCall:
     case AT_ThisCall:
     case AT_Pascal:
     case AT_SwiftCall:
     case AT_VectorCall:
     case AT_MSABI:
     case AT_SysVABI:
     case AT_Pcs:
     case AT_IntelOclBicc:
     case AT_PreserveMost:
     case AT_PreserveAll:
      {
        // Ignore attributes that don't validate or can't apply to the
        // function type.  We'll diagnose the failure to apply them in
        // handleFunctionTypeAttr.
        type$ref<CallingConv> CC = new type$ref$single<CallingConv>();
        if (!S.CheckCallingConvAttr($Deref(Attr), CC)
           && (!FTI.isVariadic || supportsVariadicCall(CC.$deref()))) {
          return CC.$deref();
        }
        break;
      }
     default:
      break;
    }
  }
  
  boolean IsCXXInstanceMethod = false;
  if (S.getLangOpts().CPlusPlus) {
    // Look inwards through parentheses to see if this chunk will form a
    // member pointer type or if we're the declarator.  Any type attributes
    // between here and there will override the CC we choose here.
    /*uint*/int I = ChunkIndex;
    boolean FoundNonParen = false;
    while ((I != 0) && !FoundNonParen) {
      --I;
      if (D.getTypeObject(I).Kind != DeclaratorChunk.Unnamed_enum.Paren) {
        FoundNonParen = true;
      }
    }
    if (FoundNonParen) {
      // If we're not the declarator, we're a regular function type unless we're
      // in a member pointer.
      IsCXXInstanceMethod
         = D.getTypeObject(I).Kind == DeclaratorChunk.Unnamed_enum.MemberPointer;
    } else if (D.getContext() == Declarator.TheContext.LambdaExprContext) {
      // This can only be a call operator for a lambda, which is an instance
      // method.
      IsCXXInstanceMethod = true;
    } else {
      // We're the innermost decl chunk, so must be a function declarator.
      assert (D.isFunctionDeclarator());
      
      // If we're inside a record, we're declaring a method, but it could be
      // explicitly or implicitly static.
      IsCXXInstanceMethod
         = D.isFirstDeclarationOfMember()
         && D.getDeclSpec().getStorageClassSpec() != DeclSpec.SCS.SCS_typedef
         && !D.isStaticMember();
    }
  }
  
  CallingConv CC = S.Context.getDefaultCallingConvention(FTI.isVariadic, 
      IsCXXInstanceMethod);
  
  // Attribute AT_OpenCLKernel affects the calling convention for SPIR
  // and AMDGPU targets, hence it cannot be treated as a calling
  // convention attribute. This is the simplest place to infer
  // calling convention for OpenCL kernels.
  if (S.getLangOpts().OpenCL) {
    for (/*const*/ AttributeList /*P*/ Attr = D.getDeclSpec().getAttributes$Const().getList();
         (Attr != null); Attr = Attr.getNext()) {
      if (Attr.getKind() == AttributeList.Kind.AT_OpenCLKernel) {
        Triple.ArchType arch = S.Context.getTargetInfo().getTriple().getArch();
        if (arch == Triple.ArchType.spir || arch == Triple.ArchType.spir64
           || arch == Triple.ArchType.amdgcn) {
          CC = CallingConv.CC_OpenCLKernel;
        }
        break;
      }
    }
  }
  
  return CC;
}


/// Check whether there is a nullability attribute of any kind in the given
/// attribute list.
//<editor-fold defaultstate="collapsed" desc="hasNullabilityAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 3248,
 FQN="hasNullabilityAttr", NM="_ZL18hasNullabilityAttrPKN5clang13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZL18hasNullabilityAttrPKN5clang13AttributeListE")
//</editor-fold>
public static boolean hasNullabilityAttr(/*const*/ AttributeList /*P*/ attrs) {
  for (/*const*/ AttributeList /*P*/ attr = attrs; (attr != null);
       attr = attr.getNext()) {
    if (attr.getKind() == AttributeList.Kind.AT_TypeNonNull
       || attr.getKind() == AttributeList.Kind.AT_TypeNullable
       || attr.getKind() == AttributeList.Kind.AT_TypeNullUnspecified) {
      return true;
    }
  }
  
  return false;
}

// end anonymous namespace

/// Classify the given declarator, whose type-specified is \c type, based on
/// what kind of pointer it refers to.
///
/// This is used to determine the default nullability.
//<editor-fold defaultstate="collapsed" desc="classifyPointerDeclarator">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 3282,
 FQN="classifyPointerDeclarator", NM="_ZL25classifyPointerDeclaratorRN5clang4SemaENS_8QualTypeERNS_10DeclaratorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZL25classifyPointerDeclaratorRN5clang4SemaENS_8QualTypeERNS_10DeclaratorE")
//</editor-fold>
public static PointerDeclaratorKind classifyPointerDeclarator(final Sema /*&*/ S, 
                         QualType type, 
                         final Declarator /*&*/ declarator) {
  /*uint*/int numNormalPointers = 0;
  
  // For any dependent type, we consider it a non-pointer.
  if (type.$arrow().isDependentType()) {
    return PointerDeclaratorKind.NonPointer;
  }
  
  // Look through the declarator chunks to identify pointers.
  for (/*uint*/int i = 0, n = declarator.getNumTypeObjects(); i != n; ++i) {
    final DeclaratorChunk /*&*/ chunk = declarator.getTypeObject(i);
    switch (chunk.Kind) {
     case Array:
     case Function:
     case Pipe:
      break;
     case BlockPointer:
     case MemberPointer:
      return $greater_uint(numNormalPointers, 0) ? PointerDeclaratorKind.MultiLevelPointer : PointerDeclaratorKind.SingleLevelPointer;
     case Paren:
     case Reference:
      continue;
     case Pointer:
      ++numNormalPointers;
      if ($greater_uint(numNormalPointers, 2)) {
        return PointerDeclaratorKind.MultiLevelPointer;
      }
      continue;
    }
  }
  
  // Then, dig into the type specifier itself.
  /*uint*/int numTypeSpecifierPointers = 0;
  do {
    {
      // Decompose normal pointers.
      /*const*/ PointerType /*P*/ ptrType = type.$arrow().getAs(PointerType.class);
      if ((ptrType != null)) {
        ++numNormalPointers;
        if ($greater_uint(numNormalPointers, 2)) {
          return PointerDeclaratorKind.MultiLevelPointer;
        }
        
        type.$assignMove(ptrType.getPointeeType());
        ++numTypeSpecifierPointers;
        continue;
      }
    }
    
    // Decompose block pointers.
    if ((type.$arrow().getAs(BlockPointerType.class) != null)) {
      return $greater_uint(numNormalPointers, 0) ? PointerDeclaratorKind.MultiLevelPointer : PointerDeclaratorKind.SingleLevelPointer;
    }
    
    // Decompose member pointers.
    if ((type.$arrow().getAs(MemberPointerType.class) != null)) {
      return $greater_uint(numNormalPointers, 0) ? PointerDeclaratorKind.MultiLevelPointer : PointerDeclaratorKind.SingleLevelPointer;
    }
    {
      
      // Look at Objective-C object pointers.
      /*const*/ ObjCObjectPointerType /*P*/ objcObjectPtr = type.$arrow().getAs(ObjCObjectPointerType.class);
      if ((objcObjectPtr != null)) {
        ++numNormalPointers;
        ++numTypeSpecifierPointers;
        {
          
          // If this is NSError**, report that.
          ObjCInterfaceDecl /*P*/ objcClassDecl = objcObjectPtr.getInterfaceDecl();
          if ((objcClassDecl != null)) {
            if (objcClassDecl.getIdentifier() == S.getNSErrorIdent()
               && numNormalPointers == 2 && $less_uint(numTypeSpecifierPointers, 2)) {
              return PointerDeclaratorKind.NSErrorPointerPointer;
            }
          }
        }
        
        break;
      }
    }
    {
      
      // Look at Objective-C class types.
      /*const*/ ObjCInterfaceType /*P*/ objcClass = type.$arrow().<ObjCInterfaceType>getAs$ObjCInterfaceType();
      if ((objcClass != null)) {
        if (objcClass.getInterface().getIdentifier() == S.getNSErrorIdent()) {
          if (numNormalPointers == 2 && $less_uint(numTypeSpecifierPointers, 2)) {
            return PointerDeclaratorKind.NSErrorPointerPointer;
          }
          ;
        }
        
        break;
      }
    }
    
    // If at this point we haven't seen a pointer, we won't see one.
    if (numNormalPointers == 0) {
      return PointerDeclaratorKind.NonPointer;
    }
    {
      
      /*const*/ RecordType /*P*/ recordType = type.$arrow().<RecordType>getAs$RecordType();
      if ((recordType != null)) {
        RecordDecl /*P*/ recordDecl = recordType.getDecl();
        
        boolean isCFError = false;
        if ((S.CFError != null)) {
          // If we already know about CFError, test it directly.
          isCFError = (S.CFError == recordDecl);
        } else {
          // Check whether this is CFError, which we identify based on its bridge
          // to NSError.
          if (recordDecl.getTagKind() == TagTypeKind.TTK_Struct && $greater_uint(numNormalPointers, 0)) {
            {
              ObjCBridgeAttr /*P*/ bridgeAttr = recordDecl.getAttr(ObjCBridgeAttr.class);
              if ((bridgeAttr != null)) {
                if (bridgeAttr.getBridgedType() == S.getNSErrorIdent()) {
                  S.CFError = recordDecl;
                  isCFError = true;
                }
              }
            }
          }
        }
        
        // If this is CFErrorRef*, report it as such.
        if (isCFError && numNormalPointers == 2 && $less_uint(numTypeSpecifierPointers, 2)) {
          return PointerDeclaratorKind.CFErrorRefPointer;
        }
        break;
      }
    }
    
    break;
  } while (true);
  switch (numNormalPointers) {
   case 0:
    return PointerDeclaratorKind.NonPointer;
   case 1:
    return PointerDeclaratorKind.SingleLevelPointer;
   case 2:
    return PointerDeclaratorKind.MaybePointerToCFRef;
   default:
    return PointerDeclaratorKind.MultiLevelPointer;
  }
}

//<editor-fold defaultstate="collapsed" desc="getNullabilityCompletenessCheckFileID">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 3419,
 FQN="getNullabilityCompletenessCheckFileID", NM="_ZL37getNullabilityCompletenessCheckFileIDRN5clang4SemaENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZL37getNullabilityCompletenessCheckFileIDRN5clang4SemaENS_14SourceLocationE")
//</editor-fold>
public static FileID getNullabilityCompletenessCheckFileID(final Sema /*&*/ S, 
                                     SourceLocation loc) {
  // If we're anywhere in a function, method, or closure context, don't perform
  // completeness checks.
  for (DeclContext /*P*/ ctx = S.CurContext; (ctx != null); ctx = ctx.getParent()) {
    if (ctx.isFunctionOrMethod()) {
      return new FileID();
    }
    if (ctx.isFileContext()) {
      break;
    }
  }
  
  // We only care about the expansion location.
  loc.$assignMove(S.SourceMgr.getExpansionLoc(/*NO_COPY*/loc));
  FileID file = S.SourceMgr.getFileID(/*NO_COPY*/loc);
  if (file.isInvalid()) {
    return new FileID();
  }
  
  // Retrieve file information.
  bool$ptr invalid = create_bool$ptr(false);
  final /*const*/ SrcMgr.SLocEntry /*&*/ sloc = S.SourceMgr.getSLocEntry(/*NO_COPY*/file, invalid);
  if (invalid.$star() || !sloc.isFile()) {
    return new FileID();
  }
  
  // We don't want to perform completeness checks on the main file or in
  // system headers.
  final /*const*/ SrcMgr.FileInfo /*&*/ fileInfo = sloc.getFile();
  if (fileInfo.getIncludeLoc().isInvalid()) {
    return new FileID();
  }
  if (fileInfo.getFileCharacteristic() != SrcMgr.CharacteristicKind.C_User
     && S.Diags.getSuppressSystemWarnings()) {
    return new FileID();
  }
  
  return file;
}


/// Check for consistent use of nullability.
//<editor-fold defaultstate="collapsed" desc="checkNullabilityConsistency">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 3457,
 FQN="checkNullabilityConsistency", NM="_ZL27checkNullabilityConsistencyRN12_GLOBAL__N_119TypeProcessingStateENS_17SimplePointerKindEN5clang14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZL27checkNullabilityConsistencyRN12_GLOBAL__N_119TypeProcessingStateENS_17SimplePointerKindEN5clang14SourceLocationE")
//</editor-fold>
public static void checkNullabilityConsistency(final TypeProcessingState /*&*/ state, 
                           SimplePointerKind pointerKind, 
                           SourceLocation pointerLoc) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    final Sema /*&*/ S = state.getSema();
    
    // Determine which file we're performing consistency checking for.
    FileID file = getNullabilityCompletenessCheckFileID(S, new SourceLocation(pointerLoc));
    if (file.isInvalid()) {
      return;
    }
    
    // If we haven't seen any type nullability in this file, we won't warn now
    // about anything.
    final FileNullability /*&*/ fileNullability = S.NullabilityMap.$at(/*NO_COPY*/file);
    if (!fileNullability.SawTypeNullability) {
      // If this is the first pointer declarator in the file, record it.
      if (fileNullability.PointerLoc.isInvalid()
         && !S.Context.getDiagnostics().isIgnored(diag.warn_nullability_missing, 
          /*NO_COPY*/pointerLoc)) {
        fileNullability.PointerLoc.$assign(pointerLoc);
        fileNullability.PointerKind = $uint2uchar(((/*static_cast*//*uint*/int)pointerKind.getValue()));
      }
      
      return;
    }
    
    // Complain about missing nullability.
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(pointerLoc), diag.warn_nullability_missing)), 
        ((/*static_cast*//*uint*/int)pointerKind.getValue())));
  } finally {
    $c$.$destroy();
  }
}

//<editor-fold defaultstate="collapsed" desc="GetFullTypeForDeclarator">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 3487,
 FQN="GetFullTypeForDeclarator", NM="_ZL24GetFullTypeForDeclaratorRN12_GLOBAL__N_119TypeProcessingStateEN5clang8QualTypeEPNS2_14TypeSourceInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZL24GetFullTypeForDeclaratorRN12_GLOBAL__N_119TypeProcessingStateEN5clang8QualTypeEPNS2_14TypeSourceInfoE")
//</editor-fold>
public static TypeSourceInfo /*P*/ GetFullTypeForDeclarator(final TypeProcessingState /*&*/ state, 
                        QualType declSpecType, 
                        type$ptr<TypeSourceInfo /*P*/> TInfo) {
  // The TypeSourceInfo that this function returns will not be a null type.
  // If there is an error, this function will fill in a dummy type as fallback.
  QualType T = new QualType(declSpecType);
  final Declarator /*&*/ D = state.getDeclarator();
  final Sema /*&*/ S = state.getSema();
  final ASTContext /*&*/ Context = S.Context;
  final /*const*/ LangOptions /*&*/ LangOpts = S.getLangOpts();
  
  // The name we're declaring, if any.
  DeclarationName Name/*J*/= new DeclarationName();
  if ((D.getIdentifier() != null)) {
    Name.$assignMove(new DeclarationName(D.getIdentifier()));
  }
  
  // Does this declaration declare a typedef-name?
  boolean IsTypedefName = D.getDeclSpec().getStorageClassSpec() == DeclSpec.SCS.SCS_typedef
     || D.getContext() == Declarator.TheContext.AliasDeclContext
     || D.getContext() == Declarator.TheContext.AliasTemplateContext;
  
  // Does T refer to a function type with a cv-qualifier or a ref-qualifier?
  boolean IsQualifiedFunction = T.$arrow().isFunctionProtoType()
     && (T.$arrow().castAs(FunctionProtoType.class).getTypeQuals() != 0
     || T.$arrow().castAs(FunctionProtoType.class).getRefQualifier() != RefQualifierKind.RQ_None);
  {
    
    // If T is 'decltype(auto)', the only declarators we can have are parens
    // and at most one function declarator if this is a function declaration.
    /*const*/ AutoType /*P*/ AT = T.$arrow().getAs(AutoType.class);
    if ((AT != null)) {
      if (AT.isDecltypeAuto()) {
        for (/*uint*/int I = 0, E = D.getNumTypeObjects(); I != E; ++I) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            /*uint*/int Index = E - I - 1;
            final DeclaratorChunk /*&*/ DeclChunk = D.getTypeObject(Index);
            /*uint*/int DiagId = diag.err_decltype_auto_compound_type;
            /*uint*/int DiagKind = 0;
            switch (DeclChunk.Kind) {
             case Paren:
              continue;
             case Function:
              {
                uint$ref FnIndex = create_uint$ref();
                if (D.isFunctionDeclarationContext()
                   && D.isFunctionDeclarator(FnIndex) && FnIndex.$deref() == Index) {
                  continue;
                }
                DiagId = diag.err_decltype_auto_function_declarator_not_declaration;
                break;
              }
             case Pointer:
             case BlockPointer:
             case MemberPointer:
              DiagKind = 0;
              break;
             case Reference:
              DiagKind = 1;
              break;
             case Array:
              DiagKind = 2;
              break;
             case Pipe:
              break;
            }
            
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(DeclChunk.Loc), DiagId)), DiagKind));
            D.setInvalidType(true);
            break;
          } finally {
            $c$.$destroy();
          }
        }
      }
    }
  }
  
  // Determine whether we should infer _Nonnull on pointer types.
  final Optional<NullabilityKind> inferNullability/*J*/= new Optional<NullabilityKind>();
  final boolean inferNullabilityCS[] = new boolean[]{false};
  final boolean inferNullabilityInnerOnly[] = new boolean[]{false};
  final boolean inferNullabilityInnerOnlyComplete[] = new boolean[]{false};
  
  // Are we in an assume-nonnull region?
  boolean inAssumeNonNullRegion = false;
  if (S.PP.getPragmaAssumeNonNullLoc().isValid()) {
    inAssumeNonNullRegion = true;
    // Determine which file we saw the assume-nonnull region in.
    FileID file = getNullabilityCompletenessCheckFileID(S, S.PP.getPragmaAssumeNonNullLoc());
    if (file.isValid()) {
      final FileNullability /*&*/ fileNullability = S.NullabilityMap.$at(/*NO_COPY*/file);
      
      // If we haven't seen any type nullability before, now we have.
      if (!fileNullability.SawTypeNullability) {
        if (fileNullability.PointerLoc.isValid()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(fileNullability.PointerLoc), diag.warn_nullability_missing)), 
                ((/*static_cast*//*uint*/int)($uchar2uint(fileNullability.PointerKind)))));
          } finally {
            $c$.$destroy();
          }
        }
        
        fileNullability.SawTypeNullability = true;
      }
    }
  }
  
  // Whether to complain about missing nullability specifiers or not.
  /*enum ANONYMOUS_INT_CONSTANTS {*/
    /// Never complain.
    final /*uint*/int CAMN_No = 0;
    /// Complain on the inner pointers (but not the outermost
    /// pointer).
    final /*uint*/int CAMN_InnerPointers = CAMN_No + 1;
    /// Complain about any pointers that don't have nullability
    /// specified or inferred.
    final /*uint*/int CAMN_Yes = CAMN_InnerPointers + 1;
  /*}*//*Unnamed enum*//*uint*/final int complainAboutMissingNullability[] = new int[]{CAMN_No};
  final /*uint*/int NumPointersRemaining[] = new int[]{0};
  if (IsTypedefName) {
    // For typedefs, we do not infer any nullability (the default),
    // and we only complain about missing nullability specifiers on
    // inner pointers.
    complainAboutMissingNullability[0] = CAMN_InnerPointers;
    if (T.$arrow().canHaveNullability() && !T.$arrow().getNullability(S.Context).$bool()) {
      ++NumPointersRemaining[0];
    }
    
    for (/*uint*/int i = 0, n = D.getNumTypeObjects(); i != n; ++i) {
      final DeclaratorChunk /*&*/ chunk = D.getTypeObject(i);
      switch (chunk.Kind) {
       case Array:
       case Function:
       case Pipe:
        break;
       case BlockPointer:
       case MemberPointer:
        ++NumPointersRemaining[0];
        break;
       case Paren:
       case Reference:
        continue;
       case Pointer:
        ++NumPointersRemaining[0];
        continue;
      }
    }
  } else {
    boolean isFunctionOrMethod = false;
    {
      Declarator.TheContext context = state.getDeclarator().getContext();
      switch (context) {
       case ObjCParameterContext:
       case ObjCResultContext:
       case PrototypeContext:
       case TrailingReturnContext:
        isFunctionOrMethod = true;
       case MemberContext:
        // fallthrough
        if (state.getDeclarator().isObjCIvar() && !isFunctionOrMethod) {
          complainAboutMissingNullability[0] = CAMN_No;
          break;
        }
        
        // Weak properties are inferred to be nullable.
        if (state.getDeclarator().isObjCWeakProperty() && inAssumeNonNullRegion) {
          inferNullability.$assign_T$RR(/*KEEP_ENUM*/NullabilityKind.Nullable);
          break;
        }
       case FileContext:
       case KNRTypeListContext:
        
        // fallthrough
        complainAboutMissingNullability[0] = CAMN_Yes;
        
        // Nullability inference depends on the type and declarator.
        switch (classifyPointerDeclarator(S, new QualType(T), D)) {
         case NonPointer:
         case MultiLevelPointer:
          // Cannot infer nullability.
          break;
         case SingleLevelPointer:
          // Infer _Nonnull if we are in an assumes-nonnull region.
          if (inAssumeNonNullRegion) {
            inferNullability.$assign_T$RR(/*KEEP_ENUM*/NullabilityKind.NonNull);
            inferNullabilityCS[0] = (context == Declarator.TheContext.ObjCParameterContext
               || context == Declarator.TheContext.ObjCResultContext);
          }
          break;
         case CFErrorRefPointer:
         case NSErrorPointerPointer:
          // Within a function or method signature, infer _Nullable at both
          // levels.
          if (isFunctionOrMethod && inAssumeNonNullRegion) {
            inferNullability.$assign_T$RR(/*KEEP_ENUM*/NullabilityKind.Nullable);
          }
          break;
         case MaybePointerToCFRef:
          if (isFunctionOrMethod) {
            // On pointer-to-pointer parameters marked cf_returns_retained or
            // cf_returns_not_retained, if the outer pointer is explicit then
            // infer the inner pointer as _Nullable.
            AttributeList2Bool hasCFReturnsAttr =  (NextAttr) -> 
                    
              {
                while ((NextAttr != null)) {
                  if (NextAttr.getKind() == AttributeList.Kind.AT_CFReturnsRetained
                     || NextAttr.getKind() == AttributeList.Kind.AT_CFReturnsNotRetained) {
                    return true;
                  }
                  NextAttr = NextAttr.getNext();
                }
                return false;
              }
;
            {
              /*const*/ DeclaratorChunk /*P*/ InnermostChunk = D.getInnermostNonParenChunk();
              if ((InnermostChunk != null)) {
                if (hasCFReturnsAttr.$call(D.getAttributes())
                   || hasCFReturnsAttr.$call(InnermostChunk.getAttrs())
                   || hasCFReturnsAttr.$call(D.getDeclSpec().getAttributes$Const().getList())) {
                  inferNullability.$assign_T$RR(/*KEEP_ENUM*/NullabilityKind.Nullable);
                  inferNullabilityInnerOnly[0] = true;
                }
              }
            }
          }
          break;
        }
        break;
       case ConversionIdContext:
        complainAboutMissingNullability[0] = CAMN_Yes;
        break;
       case AliasDeclContext:
       case AliasTemplateContext:
       case BlockContext:
       case BlockLiteralContext:
       case ConditionContext:
       case CXXCatchContext:
       case CXXNewContext:
       case ForContext:
       case InitStmtContext:
       case LambdaExprContext:
       case LambdaExprParameterContext:
       case ObjCCatchContext:
       case TemplateParamContext:
       case TemplateTypeArgContext:
       case TypeNameContext:
        // Don't infer in these contexts.
        break;
      }
    }
  }
  
  // Local function that checks the nullability for a given pointer declarator.
  // Returns true if _Nonnull was inferred.
  SimplePointerKindSourceLocationAttributeList2AttributeList inferPointerNullability = (pointerKind, pointerLoc, attrs) -> 
    {
      // We've seen a pointer.
      if ($greater_uint(NumPointersRemaining[0], 0)) {
        --NumPointersRemaining[0];
      }
      
      // If a nullability attribute is present, there's nothing to do.
      if (hasNullabilityAttr(attrs.$deref())) {
        return null;
      }
      
      // If we're supposed to infer nullability, do so now.
      if (inferNullability.$bool() && !inferNullabilityInnerOnlyComplete[0]) {
        AttributeList.Syntax syntax = inferNullabilityCS[0] ? AttributeList.Syntax.AS_ContextSensitiveKeyword : AttributeList.Syntax.AS_Keyword;
        AttributeList /*P*/ nullabilityAttr = state.getDeclarator().getAttributePool().
            create(S.getNullabilityKeyword(inferNullability.$star()), 
            new SourceRange(/*NO_COPY*/pointerLoc), 
            (IdentifierInfo /*P*/ )null, new SourceLocation(), 
            (type$ptr<PointerUnion<Expr /*P*/ , IdentifierLoc /*P*/ >>/*P*/ )null, 0, syntax);
        
        spliceAttrIntoList($Deref(nullabilityAttr), attrs);
        if (inferNullabilityCS[0]) {
          state.getDeclarator().getMutableDeclSpec().getObjCQualifiers().
              setObjCDeclQualifier(ObjCDeclSpec.ObjCDeclQualifier.DQ_CSNullability);
        }
        if (inferNullabilityInnerOnly[0]) {
          inferNullabilityInnerOnlyComplete[0] = true;
        }
        return nullabilityAttr;
      }
      
      // If we're supposed to complain about missing nullability, do so
      // now if it's truly missing.
      switch (complainAboutMissingNullability[0]) {
       case CAMN_No:
        break;
       case CAMN_InnerPointers:
        if (NumPointersRemaining[0] == 0) {
          break;
        }
       case CAMN_Yes:
        // Fallthrough.
        checkNullabilityConsistency(state, pointerKind, new SourceLocation(pointerLoc));
      }
      return null;
    }
;
  
  // If the type itself could have nullability but does not, infer pointer
  // nullability and perform consistency checking.
  if (T.$arrow().canHaveNullability() && S.ActiveTemplateInstantiations.empty()
     && !T.$arrow().getNullability(S.Context).$bool()) {
    SimplePointerKind pointerKind = SimplePointerKind.Pointer;
    if (T.$arrow().isBlockPointerType()) {
      pointerKind = SimplePointerKind.BlockPointer;
    } else if (T.$arrow().isMemberPointerType()) {
      pointerKind = SimplePointerKind.MemberPointer;
    }
    {
      
      AttributeList /*P*/ attr = inferPointerNullability.$call(
          /*KEEP_ENUM*/pointerKind, D.getDeclSpec().getTypeSpecTypeLoc(), 
          D.getMutableDeclSpec().getAttributes().getListRef()
      );
      if ((attr != null)) {
        T.$assignMove(Context.getAttributedType(AttributedType.getNullabilityAttrKind(inferNullability.$star()), new QualType(T), new QualType(T)));
        attr.setUsedAsTypeAttr();
      }
    }
  }
  
  // Walk the DeclTypeInfo, building the recursive type as we go.
  // DeclTypeInfos are ordered from the identifier out, which is
  // opposite of what we want :).
  for (/*uint*/int i = 0, e = D.getNumTypeObjects(); i != e; ++i) {
    /*uint*/int chunkIndex = e - i - 1;
    state.setCurrentChunkIndex(chunkIndex);
    final DeclaratorChunk /*&*/ DeclType = D.getTypeObject(chunkIndex);
    IsQualifiedFunction &= DeclType.Kind == DeclaratorChunk.Unnamed_enum.Paren;
    switch (DeclType.Kind) {
     case Paren:
      T.$assignMove(S.BuildParenType(new QualType(T)));
      break;
     case BlockPointer:
      // If blocks are disabled, emit an error.
      if (!LangOpts.Blocks) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(DeclType.Loc), diag.err_blocks_disable)), LangOpts.OpenCL));
        } finally {
          $c$.$destroy();
        }
      }
      
      // Handle pointer nullability.
      inferPointerNullability.$call(/*KEEP_ENUM*/SimplePointerKind.BlockPointer, 
          /*NO_COPY*/DeclType.Loc, DeclType.getAttrListRef()
      );
      
      T.$assignMove(S.BuildBlockPointerType(new QualType(T), D.getIdentifierLoc(), new DeclarationName(Name)));
      if ((DeclType.Unnamed_field3.Cls.TypeQuals != 0) || LangOpts.OpenCL) {
        // OpenCL v2.0, s6.12.5 - Block variable declarations are implicitly
        // qualified with const.
        if (LangOpts.OpenCL) {
          DeclType.Unnamed_field3.Cls.TypeQuals |= $int2uint_5bits(DeclSpec.TQ.TQ_const.getValue());
        }
        T.$assignMove(S.BuildQualifiedType(new QualType(T), new SourceLocation(DeclType.Loc), DeclType.Unnamed_field3.Cls.TypeQuals));
      }
      break;
     case Pointer:
      // Verify that we're not building a pointer to pointer to function with
      // exception specification.
      if (LangOpts.CPlusPlus && S.CheckDistantExceptionSpec(new QualType(T))) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track(S.Diag(D.getIdentifierLoc(), diag.err_distant_exception_spec)));
          D.setInvalidType(true);
        } finally {
          $c$.$destroy();
        }
        // Build the type anyway.
      }
      
      // Handle pointer nullability
      inferPointerNullability.$call(/*KEEP_ENUM*/SimplePointerKind.Pointer, /*NO_COPY*/DeclType.Loc, 
          DeclType.getAttrListRef()
      );
      if (LangOpts.ObjC1 && $bool2uint_1bit((T.$arrow().getAs(ObjCObjectType.class) != null))) {
        T.$assignMove(Context.getObjCObjectPointerType(new QualType(T)));
        if ((DeclType.Unnamed_field3.Ptr.TypeQuals != 0)) {
          T.$assignMove(S.BuildQualifiedType(new QualType(T), new SourceLocation(DeclType.Loc), DeclType.Unnamed_field3.Ptr.TypeQuals));
        }
        break;
      }
      
      // OpenCL v2.0 s6.9b - Pointer to image/sampler cannot be used.
      // OpenCL v2.0 s6.13.16.1 - Pointer to pipe cannot be used.
      // OpenCL v2.0 s6.12.5 - Pointers to Blocks are not allowed.
      if (LangOpts.OpenCL) {
        if (T.$arrow().isImageType() || T.$arrow().isSamplerT() || T.$arrow().isPipeType()
           || T.$arrow().isBlockPointerType()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(D.getIdentifierLoc(), diag.err_opencl_pointer_to_type)), T));
            D.setInvalidType(true);
          } finally {
            $c$.$destroy();
          }
        }
      }
      
      T.$assignMove(S.BuildPointerType(new QualType(T), new SourceLocation(DeclType.Loc), new DeclarationName(Name)));
      if ((DeclType.Unnamed_field3.Ptr.TypeQuals != 0)) {
        T.$assignMove(S.BuildQualifiedType(new QualType(T), new SourceLocation(DeclType.Loc), DeclType.Unnamed_field3.Ptr.TypeQuals));
      }
      break;
     case Reference:
      {
        // Verify that we're not building a reference to pointer to function with
        // exception specification.
        if (LangOpts.CPlusPlus && S.CheckDistantExceptionSpec(new QualType(T))) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track(S.Diag(D.getIdentifierLoc(), diag.err_distant_exception_spec)));
            D.setInvalidType(true);
          } finally {
            $c$.$destroy();
          }
          // Build the type anyway.
        }
        T.$assignMove(S.BuildReferenceType(new QualType(T), DeclType.Unnamed_field3.Ref.LValueRef, new SourceLocation(DeclType.Loc), new DeclarationName(Name)));
        if (DeclType.Unnamed_field3.Ref.HasRestrict) {
          T.$assignMove(S.BuildQualifiedType(new QualType(T), new SourceLocation(DeclType.Loc), Qualifiers.TQ.Restrict));
        }
        break;
      }
     case Array:
      {
        // Verify that we're not building an array of pointers to function with
        // exception specification.
        if (LangOpts.CPlusPlus && S.CheckDistantExceptionSpec(new QualType(T))) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track(S.Diag(D.getIdentifierLoc(), diag.err_distant_exception_spec)));
            D.setInvalidType(true);
          } finally {
            $c$.$destroy();
          }
          // Build the type anyway.
        }
        final DeclaratorChunk.ArrayTypeInfo /*&*/ ATI = DeclType.Unnamed_field3.Arr;
        Expr /*P*/ ArraySize = ((/*static_cast*/Expr /*P*/ )(ATI.NumElts));
        ArrayType.ArraySizeModifier ASM;
        if (ATI.isStar) {
          ASM = ArrayType.ArraySizeModifier.Star;
        } else if (ATI.hasStatic) {
          ASM = ArrayType.ArraySizeModifier.Static;
        } else {
          ASM = ArrayType.ArraySizeModifier.Normal;
        }
        if (ASM == ArrayType.ArraySizeModifier.Star && !D.isPrototypeContext()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            // FIXME: This check isn't quite right: it allows star in prototypes
            // for function definitions, and disallows some edge cases detailed
            // in http://gcc.gnu.org/ml/gcc-patches/2009-02/msg00133.html
            $c$.clean($c$.track(S.Diag(new SourceLocation(DeclType.Loc), diag.err_array_star_outside_prototype)));
            ASM = ArrayType.ArraySizeModifier.Normal;
            D.setInvalidType(true);
          } finally {
            $c$.$destroy();
          }
        }
        
        // C99 6.7.5.2p1: The optional type qualifiers and the keyword static
        // shall appear only in a declaration of a function parameter with an
        // array type, ...
        if (ASM == ArrayType.ArraySizeModifier.Static || (ATI.TypeQuals != 0)) {
          if (!(D.isPrototypeContext()
             || D.getContext() == Declarator.TheContext.KNRTypeListContext)) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(DeclType.Loc), diag.err_array_static_outside_prototype)), 
                  (ASM == ArrayType.ArraySizeModifier.Static ? $("'static'") : $("type qualifier"))));
              // Remove the 'static' and the type qualifiers.
              if (ASM == ArrayType.ArraySizeModifier.Static) {
                ASM = ArrayType.ArraySizeModifier.Normal;
              }
              ATI.TypeQuals = $uint2uint_5bits(0);
              D.setInvalidType(true);
            } finally {
              $c$.$destroy();
            }
          }
          
          // C99 6.7.5.2p1: ... and then only in the outermost array type
          // derivation.
          /*uint*/int x = chunkIndex;
          while (x != 0) {
            // Walk outwards along the declarator chunks.
            x--;
            final /*const*/ DeclaratorChunk /*&*/ DC = D.getTypeObject(x);
            switch (DC.Kind) {
             case Paren:
              continue;
             case Array:
             case Pointer:
             case Reference:
             case MemberPointer:
              {
                JavaCleaner $c$ = $createJavaCleaner();
                try {
                  $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(DeclType.Loc), diag.err_array_static_not_outermost)), 
                      (ASM == ArrayType.ArraySizeModifier.Static ? $("'static'") : $("type qualifier"))));
                  if (ASM == ArrayType.ArraySizeModifier.Static) {
                    ASM = ArrayType.ArraySizeModifier.Normal;
                  }
                  ATI.TypeQuals = $uint2uint_5bits(0);
                  D.setInvalidType(true);
                  break;
                } finally {
                  $c$.$destroy();
                }
              }
             case Function:
             case BlockPointer:
             case Pipe:
              // These are invalid anyway, so just ignore.
              break;
            }
          }
        }
        /*const*/ AutoType /*P*/ AT = T.$arrow().getContainedAutoType();
        // Allow arrays of auto if we are a generic lambda parameter.
        // i.e. [](auto (&array)[5]) { return array[0]; }; OK
        if ((AT != null) && D.getContext() != Declarator.TheContext.LambdaExprParameterContext) {
          // We've already diagnosed this for decltype(auto).
          if (!AT.isDecltypeAuto()) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(DeclType.Loc), diag.err_illegal_decl_array_of_auto)), 
                      getPrintableNameForEntity(new DeclarationName(Name))), T));
            } finally {
              $c$.$destroy();
            }
          }
          T.$assignMove(new QualType());
          break;
        }
        
        T.$assignMove(S.BuildArrayType(new QualType(T), ASM, ArraySize, ATI.TypeQuals, 
                new SourceRange(/*NO_COPY*/DeclType.Loc, /*NO_COPY*/DeclType.EndLoc), new DeclarationName(Name)));
        break;
      }
     case Function:
      {
        // If the function declarator has a prototype (i.e. it is not () and
        // does not have a K&R-style identifier list), then the arguments are part
        // of the type, otherwise the argument list is ().
        final /*const*/ DeclaratorChunk.FunctionTypeInfo /*&*/ FTI = DeclType.Unnamed_field3.Fun;
        IsQualifiedFunction = (FTI.TypeQuals != 0) || FTI.hasRefQualifier();
        
        // Check for auto functions and trailing return type and adjust the
        // return type accordingly.
        if (!D.isInvalidType()) {
          // trailing-return-type is only required if we're declaring a function,
          // and not, for instance, a pointer to a function.
          if (D.getDeclSpec().containsPlaceholderType()
             && !FTI.hasTrailingReturnType() && chunkIndex == 0
             && !S.getLangOpts().CPlusPlus14) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($c$.track(S.Diag(D.getDeclSpec().getTypeSpecTypeLoc(), 
                  D.getDeclSpec().getTypeSpecType() == DeclSpec.TST_auto ? diag.err_auto_missing_trailing_return : diag.err_deduced_return_type)));
              T.$assignMove(Context.IntTy.$QualType());
              D.setInvalidType(true);
            } finally {
              $c$.$destroy();
            }
          } else if (FTI.hasTrailingReturnType()) {
            // T must be exactly 'auto' at this point. See CWG issue 681.
            if (isa_ParenType(T)) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(D.getDeclSpec().getTypeSpecTypeLoc(), 
                            diag.err_trailing_return_in_parens)), 
                        T), D.getDeclSpec().getSourceRange()));
                D.setInvalidType(true);
              } finally {
                $c$.$destroy();
              }
            } else if (D.getContext() != Declarator.TheContext.LambdaExprContext
               && (T.hasQualifiers() || !isa_AutoType(T)
               || cast_AutoType(T).getKeyword() != AutoTypeKeyword.Auto)) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(D.getDeclSpec().getTypeSpecTypeLoc(), 
                            diag.err_trailing_return_without_auto)), 
                        T), D.getDeclSpec().getSourceRange()));
                D.setInvalidType(true);
              } finally {
                $c$.$destroy();
              }
            }
            T.$assignMove(S.GetTypeFromParser(FTI.getTrailingReturnType(), TInfo));
            if (T.isNull()) {
              // An error occurred parsing the trailing return type.
              T.$assignMove(Context.IntTy.$QualType());
              D.setInvalidType(true);
            }
          }
        }
        
        // C99 6.7.5.3p1: The return type may not be a function or array type.
        // For conversion functions, we'll diagnose this particular error later.
        if ((T.$arrow().isArrayType() || T.$arrow().isFunctionType())
           && (D.getName().getKind() != UnqualifiedId.IdKind.IK_ConversionFunctionId)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            /*uint*/int diagID = diag.err_func_returning_array_function;
            // Last processing chunk in block context means this function chunk
            // represents the block.
            if (chunkIndex == 0
               && D.getContext() == Declarator.TheContext.BlockLiteralContext) {
              diagID = diag.err_block_returning_array_function;
            }
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(DeclType.Loc), diagID)), T.$arrow().isFunctionType()), T));
            T.$assignMove(Context.IntTy.$QualType());
            D.setInvalidType(true);
          } finally {
            $c$.$destroy();
          }
        }
        
        // Do not allow returning half FP value.
        // FIXME: This really should be in BuildFunctionType.
        if (T.$arrow().isHalfType()) {
          if (S.getLangOpts().OpenCL) {
            if (!S.getOpenCLOptions().cl_khr_fp16) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(D.getIdentifierLoc(), diag.err_opencl_invalid_return)), 
                        T), 0/*pointer hint*/));
                D.setInvalidType(true);
              } finally {
                $c$.$destroy();
              }
            }
          } else if (!S.getLangOpts().HalfArgsAndReturns) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(D.getIdentifierLoc(), 
                      diag.err_parameters_retval_cannot_have_fp16_type)), 1));
              D.setInvalidType(true);
            } finally {
              $c$.$destroy();
            }
          }
        }
        
        // OpenCL v2.0 s6.12.5 - A block cannot be the return value of a
        // function.
        if (LangOpts.OpenCL && (T.$arrow().isBlockPointerType() || T.$arrow().isImageType()
           || T.$arrow().isSamplerT() || T.$arrow().isPipeType())) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(D.getIdentifierLoc(), diag.err_opencl_invalid_return)), 
                    T), 1/*hint off*/));
            D.setInvalidType(true);
          } finally {
            $c$.$destroy();
          }
        }
        
        // Methods cannot return interface types. All ObjC objects are
        // passed by reference.
        if (T.$arrow().isObjCObjectType()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            SourceLocation DiagLoc/*J*/= new SourceLocation(), FixitLoc/*J*/= new SourceLocation();
            if ((TInfo.$star() != null)) {
              DiagLoc.$assignMove(TInfo.$star().getTypeLoc().getLocStart());
              FixitLoc.$assignMove(S.getLocForEndOfToken(TInfo.$star().getTypeLoc().getLocEnd()));
            } else {
              DiagLoc.$assignMove(D.getDeclSpec().getTypeSpecTypeLoc());
              FixitLoc.$assignMove(S.getLocForEndOfToken(D.getDeclSpec().getLocEnd()));
            }
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(DiagLoc), diag.err_object_cannot_be_passed_returned_by_value)), 
                        0), T), 
                FixItHint.CreateInsertion(/*NO_COPY*/FixitLoc, new StringRef(/*KEEP_STR*/$STAR))));
            
            T.$assignMove(Context.getObjCObjectPointerType(new QualType(T)));
            if ((TInfo.$star() != null)) {
              TypeLocBuilder TLB = null;
              try {
                TLB/*J*/= new TypeLocBuilder();
                TLB.pushFullCopy(TInfo.$star().getTypeLoc());
                ObjCObjectPointerTypeLoc TLoc = TLB.push(ObjCObjectPointerTypeLoc.class, new QualType(T));
                TLoc.setStarLoc(new SourceLocation(FixitLoc));
                TInfo.$set(TLB.getTypeSourceInfo(Context, new QualType(T)));
              } finally {
                if (TLB != null) { TLB.$destroy(); }
              }
            }
            
            D.setInvalidType(true);
          } finally {
            $c$.$destroy();
          }
        }
        
        // cv-qualifiers on return types are pointless except when the type is a
        // class type in C++.
        if (((T.getCVRQualifiers() != 0) || T.$arrow().isAtomicType())
           && !(S.getLangOpts().CPlusPlus
           && (T.$arrow().isDependentType() || T.$arrow().isRecordType()))) {
          if (T.$arrow().isVoidType() && !S.getLangOpts().CPlusPlus
             && D.getFunctionDefinitionKind() == FunctionDefinitionKind.FDK_Definition) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              // [6.9.1/3] qualified void return is invalid on a C
              // function definition.  Apparently ok on declarations and
              // in C++ though (!)
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(DeclType.Loc), diag.err_func_returning_qualified_void)), T));
            } finally {
              $c$.$destroy();
            }
          } else {
            diagnoseRedundantReturnTypeQualifiers(S, new QualType(T), D, chunkIndex);
          }
        }
        
        // Objective-C ARC ownership qualifiers are ignored on the function
        // return type (by type canonicalization). Complain if this attribute
        // was written here.
        if (T.getQualifiers().hasObjCLifetime()) {
          SourceLocation AttrLoc/*J*/= new SourceLocation();
          if ($less_uint(chunkIndex + 1, D.getNumTypeObjects())) {
            DeclaratorChunk ReturnTypeChunk = new DeclaratorChunk(D.getTypeObject(chunkIndex + 1));
            for (/*const*/ AttributeList /*P*/ Attr = ReturnTypeChunk.getAttrs();
                 (Attr != null); Attr = Attr.getNext()) {
              if (Attr.getKind() == AttributeList.Kind.AT_ObjCOwnership) {
                AttrLoc.$assignMove(Attr.getLoc());
                break;
              }
            }
          }
          if (AttrLoc.isInvalid()) {
            for (/*const*/ AttributeList /*P*/ Attr = D.getDeclSpec().getAttributes$Const().getList();
                 (Attr != null); Attr = Attr.getNext()) {
              if (Attr.getKind() == AttributeList.Kind.AT_ObjCOwnership) {
                AttrLoc.$assignMove(Attr.getLoc());
                break;
              }
            }
          }
          if (AttrLoc.isValid()) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              // The ownership attributes are almost always written via
              // the predefined
              // __strong/__weak/__autoreleasing/__unsafe_unretained.
              if (AttrLoc.isMacroID()) {
                AttrLoc.$assignMove(S.SourceMgr.getImmediateExpansionRange(/*NO_COPY*/AttrLoc).first);
              }
              
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(AttrLoc), diag.warn_arc_lifetime_result_type)), 
                  T.getQualifiers().getObjCLifetime()));
            } finally {
              $c$.$destroy();
            }
          }
        }
        if (LangOpts.CPlusPlus && D.getDeclSpec().hasTagDefinition()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            // C++ [dcl.fct]p6:
            //   Types shall not be defined in return or parameter types.
            TagDecl /*P*/ Tag = cast_TagDecl(D.getDeclSpec().getRepAsDecl());
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Tag.getLocation(), diag.err_type_defined_in_result_type)), 
                Context.getTypeDeclType(Tag)));
          } finally {
            $c$.$destroy();
          }
        }
        
        // Exception specs are not allowed in typedefs. Complain, but add it
        // anyway.
        if (IsTypedefName && (FTI.getExceptionSpecType().getValue() != 0)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(FTI.getExceptionSpecLocBeg(), 
                    diag.err_exception_spec_in_typedef)), 
                (D.getContext() == Declarator.TheContext.AliasDeclContext
                   || D.getContext() == Declarator.TheContext.AliasTemplateContext)));
          } finally {
            $c$.$destroy();
          }
        }
        
        // If we see "T var();" or "T var(T());" at block scope, it is probably
        // an attempt to initialize a variable, not a function declaration.
        if (FTI.isAmbiguous) {
          warnAboutAmbiguousFunction(S, D, DeclType, new QualType(T));
        }
        
        FunctionType.ExtInfo EI/*J*/= new FunctionType.ExtInfo(getCCForDeclaratorChunk(S, D, FTI, chunkIndex));
        if (!(FTI.NumParams != 0) && !FTI.isVariadic && !LangOpts.CPlusPlus) {
          // Simple void foo(), where the incoming T is the result type.
          T.$assignMove(Context.getFunctionNoProtoType(new QualType(T), EI));
        } else {
          // We allow a zero-parameter variadic function in C if the
          // function is marked with the "overloadable" attribute. Scan
          // for this attribute now.
          if (!(FTI.NumParams != 0) && FTI.isVariadic && !LangOpts.CPlusPlus) {
            boolean Overloadable = false;
            for (/*const*/ AttributeList /*P*/ Attrs = D.getAttributes();
                 (Attrs != null); Attrs = Attrs.getNext()) {
              if (Attrs.getKind() == AttributeList.Kind.AT_Overloadable) {
                Overloadable = true;
                break;
              }
            }
            if (!Overloadable) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                $c$.clean($c$.track(S.Diag(FTI.getEllipsisLoc(), diag.err_ellipsis_first_param)));
              } finally {
                $c$.$destroy();
              }
            }
          }
          if ((FTI.NumParams != 0) && FTI.Params.$at(0).Param == null) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              // C99 6.7.5.3p3: Reject int(x,y,z) when it's not a function
              // definition.
              $c$.clean($c$.track(S.Diag(new SourceLocation(FTI.Params.$at(0).IdentLoc), 
                  diag.err_ident_list_in_fn_declaration)));
              D.setInvalidType(true);
              // Recover by creating a K&R-style function type.
              T.$assignMove(Context.getFunctionNoProtoType(new QualType(T), EI));
              break;
            } finally {
              $c$.$destroy();
            }
          }
          
          FunctionProtoType.ExtProtoInfo EPI/*J*/= new FunctionProtoType.ExtProtoInfo();
          EPI.ExtInfo.$assign(EI);
          EPI.Variadic = FTI.isVariadic;
          EPI.HasTrailingReturn = FTI.hasTrailingReturnType();
          EPI.TypeQuals = $uint2uchar(FTI.TypeQuals);
          EPI.RefQualifier = !FTI.hasRefQualifier() ? RefQualifierKind.RQ_None : FTI.RefQualifierIsLValueRef ? RefQualifierKind.RQ_LValue : RefQualifierKind.RQ_RValue;
          
          // Otherwise, we have a function with a parameter list that is
          // potentially variadic.
          SmallVector<QualType> ParamTys/*J*/= new SmallVector<QualType>(16, new QualType());
          ParamTys.reserve(FTI.NumParams);
          
          SmallVector<FunctionProtoType.ExtParameterInfo> ExtParameterInfos/*J*/= new SmallVector<FunctionProtoType.ExtParameterInfo>(JD$UInt_T$C$R.INSTANCE, 16, FTI.NumParams, new FunctionProtoType.ExtParameterInfo());
          boolean HasAnyInterestingExtParameterInfos = false;
          
          for (/*uint*/int i$1 = 0, e$1 = FTI.NumParams; i$1 != e$1; ++i$1) {
            ParmVarDecl /*P*/ Param = cast_ParmVarDecl(FTI.Params.$at(i$1).Param);
            QualType ParamTy = Param.getType();
            assert (!ParamTy.isNull()) : "Couldn't parse type?";
            
            // Look for 'void'.  void is allowed only as a single parameter to a
            // function with no other parameters (C99 6.7.5.3p10).  We record
            // int(void) as a FunctionProtoType with an empty parameter list.
            if (ParamTy.$arrow().isVoidType()) {
              // If this is something like 'float(int, void)', reject it.  'void'
              // is an incomplete type (C99 6.2.5p19) and function decls cannot
              // have parameters of incomplete type.
              if (FTI.NumParams != 1 || FTI.isVariadic) {
                JavaCleaner $c$ = $createJavaCleaner();
                try {
                  $c$.clean($c$.track(S.Diag(new SourceLocation(DeclType.Loc), diag.err_void_only_param)));
                  ParamTy.$assignMove(Context.IntTy.$QualType());
                  Param.setType(new QualType(ParamTy));
                } finally {
                  $c$.$destroy();
                }
              } else if ((FTI.Params.$at(i$1).Ident != null)) {
                JavaCleaner $c$ = $createJavaCleaner();
                try {
                  // Reject, but continue to parse 'int(void abc)'.
                  $c$.clean($c$.track(S.Diag(new SourceLocation(FTI.Params.$at(i$1).IdentLoc), diag.err_param_with_void_type)));
                  ParamTy.$assignMove(Context.IntTy.$QualType());
                  Param.setType(new QualType(ParamTy));
                } finally {
                  $c$.$destroy();
                }
              } else {
                // Reject, but continue to parse 'float(const void)'.
                if (ParamTy.hasQualifiers()) {
                  JavaCleaner $c$ = $createJavaCleaner();
                  try {
                    $c$.clean($c$.track(S.Diag(new SourceLocation(DeclType.Loc), diag.err_void_param_qualified)));
                  } finally {
                    $c$.$destroy();
                  }
                }
                
                // Do not add 'void' to the list.
                break;
              }
            } else if (ParamTy.$arrow().isHalfType()) {
              // Disallow half FP parameters.
              // FIXME: This really should be in BuildFunctionType.
              if (S.getLangOpts().OpenCL) {
                if (!S.getOpenCLOptions().cl_khr_fp16) {
                  JavaCleaner $c$ = $createJavaCleaner();
                  try {
                    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Param.getLocation(), 
                            diag.err_opencl_half_param)), ParamTy));
                    D.setInvalidType();
                    Param.setInvalidDecl();
                  } finally {
                    $c$.$destroy();
                  }
                }
              } else if (!S.getLangOpts().HalfArgsAndReturns) {
                JavaCleaner $c$ = $createJavaCleaner();
                try {
                  $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Param.getLocation(), 
                          diag.err_parameters_retval_cannot_have_fp16_type)), 0));
                  D.setInvalidType();
                } finally {
                  $c$.$destroy();
                }
              }
            } else if (!FTI.hasPrototype) {
              if (ParamTy.$arrow().isPromotableIntegerType()) {
                ParamTy.$assignMove(Context.getPromotedIntegerType(new QualType(ParamTy)));
                Param.setKNRPromoted(true);
              } else {
                /*const*/ BuiltinType /*P*/ BTy = ParamTy.$arrow().<BuiltinType>getAs$BuiltinType();
                if ((BTy != null)) {
                  if (BTy.getKind() == BuiltinType.Kind.Float) {
                    ParamTy.$assignMove(Context.DoubleTy.$QualType());
                    Param.setKNRPromoted(true);
                  }
                }
              }
            }
            if (LangOpts.ObjCAutoRefCount && Param.hasAttr(NSConsumedAttr.class)) {
              ExtParameterInfos.$at(i$1).$assignMove(ExtParameterInfos.$at(i$1).withIsConsumed(true));
              HasAnyInterestingExtParameterInfos = true;
            }
            {
              
              ParameterABIAttr /*P*/ attr = Param.getAttr(ParameterABIAttr.class);
              if ((attr != null)) {
                ExtParameterInfos.$at(i$1).$assignMove(
                    ExtParameterInfos.$at(i$1).withABI(attr.getABI())
                );
                HasAnyInterestingExtParameterInfos = true;
              }
            }
            
            ParamTys.push_back(ParamTy);
          }
          if (HasAnyInterestingExtParameterInfos) {
            EPI.ExtParameterInfos = ExtParameterInfos.data();
            checkExtParameterInfos(S, new ArrayRef<QualType>(ParamTys, false), EPI, 
                new UInt2SourceLocation(){ 
                  @Override
                  public SourceLocation $call(int i) {
                        return FTI.Params.$at(i).Param.getLocation();
                  }
                });
          }
          SmallVector<QualType> Exceptions/*J*/= new SmallVector<QualType>(4, new QualType());
          SmallVector<OpaquePtr<QualType>> DynamicExceptions/*J*/= new SmallVector<OpaquePtr<QualType>>(2, new OpaquePtr<QualType>());
          SmallVector<SourceRange> DynamicExceptionRanges/*J*/= new SmallVector<SourceRange>(2, SourceRange.EMPTY);
          Expr /*P*/ NoexceptExpr = null;
          if (FTI.getExceptionSpecType() == ExceptionSpecificationType.EST_Dynamic) {
            // FIXME: It's rather inefficient to have to split into two vectors
            // here.
            /*uint*/int N = FTI.NumExceptions;
            DynamicExceptions.reserve(N);
            DynamicExceptionRanges.reserve(N);
            for (/*uint*/int I = 0; I != N; ++I) {
              DynamicExceptions.push_back(FTI.Unnamed_field21.Exceptions.$at(I).Ty);
              DynamicExceptionRanges.push_back(FTI.Unnamed_field21.Exceptions.$at(I).Range);
            }
          } else if (FTI.getExceptionSpecType() == ExceptionSpecificationType.EST_ComputedNoexcept) {
            NoexceptExpr = FTI.Unnamed_field21.NoexceptExpr;
          }
          
          S.checkExceptionSpecification(D.isFunctionDeclarationContext(), 
              FTI.getExceptionSpecType(), 
              new ArrayRef<OpaquePtr<QualType>>(DynamicExceptions, false), 
              new ArrayRef<SourceRange>(DynamicExceptionRanges, false), 
              NoexceptExpr, 
              Exceptions, 
              EPI.ExceptionSpec);
          
          T.$assignMove(Context.getFunctionType(new QualType(T), new ArrayRef<QualType>(ParamTys, false), EPI));
        }
        break;
      }
     case MemberPointer:
      {
        // The scope spec must refer to a class, or be dependent.
        final CXXScopeSpec /*&*/ SS = DeclType.Unnamed_field3.Mem.Scope();
        QualType ClsType/*J*/= new QualType();
        
        // Handle pointer nullability.
        inferPointerNullability.$call(/*KEEP_ENUM*/SimplePointerKind.MemberPointer, 
            /*NO_COPY*/DeclType.Loc, DeclType.getAttrListRef()
        );
        if (SS.isInvalid()) {
          // Avoid emitting extra errors if we already errored on the scope.
          D.setInvalidType(true);
        } else if (S.isDependentScopeSpecifier(SS)
           || (dyn_cast_or_null_CXXRecordDecl(S.computeDeclContext(SS)) != null)) {
          NestedNameSpecifier /*P*/ NNS = SS.getScopeRep();
          NestedNameSpecifier /*P*/ NNSPrefix = NNS.getPrefix();
          switch (NNS.getKind()) {
           case Identifier:
            ClsType.$assignMove(Context.getDependentNameType(ElaboratedTypeKeyword.ETK_None, NNSPrefix, 
                    NNS.getAsIdentifier()));
            break;
           case Namespace:
           case NamespaceAlias:
           case Global:
           case Super:
            throw new llvm_unreachable("Nested-name-specifier must name a type");
           case TypeSpec:
           case TypeSpecWithTemplate:
            ClsType.$assignMove(new QualType(NNS.getAsType(), 0));
            // Note: if the NNS has a prefix and ClsType is a nondependent
            // TemplateSpecializationType, then the NNS prefix is NOT included
            // in ClsType; hence we wrap ClsType into an ElaboratedType.
            // NOTE: in particular, no wrap occurs if ClsType already is an
            // Elaborated, DependentName, or DependentTemplateSpecialization.
            if ((NNSPrefix != null) && isa_TemplateSpecializationType(NNS.getAsType())) {
              ClsType.$assignMove(Context.getElaboratedType(ElaboratedTypeKeyword.ETK_None, NNSPrefix, new QualType(ClsType)));
            }
            break;
          }
        } else {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(DeclType.Unnamed_field3.Mem.Scope().getBeginLoc(), 
                        diag.err_illegal_decl_mempointer_in_nonclass)), 
                    ((D.getIdentifier() != null) ? D.getIdentifier().getName() : new StringRef(/*KEEP_STR*/"type name"))), 
                DeclType.Unnamed_field3.Mem.Scope().getRange()));
            D.setInvalidType(true);
          } finally {
            $c$.$destroy();
          }
        }
        if (!ClsType.isNull()) {
          T.$assignMove(S.BuildMemberPointerType(new QualType(T), new QualType(ClsType), new SourceLocation(DeclType.Loc), 
                  new DeclarationName(D.getIdentifier())));
        }
        if (T.isNull()) {
          T.$assignMove(Context.IntTy.$QualType());
          D.setInvalidType(true);
        } else if ((DeclType.Unnamed_field3.Mem.TypeQuals != 0)) {
          T.$assignMove(S.BuildQualifiedType(new QualType(T), new SourceLocation(DeclType.Loc), DeclType.Unnamed_field3.Mem.TypeQuals));
        }
        break;
      }
     case Pipe:
      {
        T.$assignMove(S.BuildPipeType(new QualType(T), new SourceLocation(DeclType.Loc)));
        break;
      }
    }
    if (T.isNull()) {
      D.setInvalidType(true);
      T.$assignMove(Context.IntTy.$QualType());
    }
    
    // See if there are any attributes on this declarator chunk.
    processTypeAttrs(state, T, TypeAttrLocation.TAL_DeclChunk, 
        ((/*const_cast*/AttributeList /*P*/ )(DeclType.getAttrs())));
  }
  assert (!T.isNull()) : "T must not be null after this point";
  if (LangOpts.CPlusPlus && T.$arrow().isFunctionType()) {
    /*const*/ FunctionProtoType /*P*/ FnTy = T.$arrow().getAs(FunctionProtoType.class);
    assert ((FnTy != null)) : "Why oh why is there not a FunctionProtoType here?";
    
    // C++ 8.3.5p4:
    //   A cv-qualifier-seq shall only be part of the function type
    //   for a nonstatic member function, the function type to which a pointer
    //   to member refers, or the top-level function type of a function typedef
    //   declaration.
    //
    // Core issue 547 also allows cv-qualifiers on function types that are
    // top-level template type arguments.
    boolean FreeFunction;
    if (!D.getCXXScopeSpec().isSet()) {
      FreeFunction = ((D.getContext() != Declarator.TheContext.MemberContext
         && D.getContext() != Declarator.TheContext.LambdaExprContext)
         || D.getDeclSpec().isFriendSpecified());
    } else {
      DeclContext /*P*/ DC = S.computeDeclContext(D.getCXXScopeSpec());
      FreeFunction = ((DC != null) && !DC.isRecord());
    }
    
    // C++11 [dcl.fct]p6 (w/DR1417):
    // An attempt to specify a function type with a cv-qualifier-seq or a
    // ref-qualifier (including by typedef-name) is ill-formed unless it is:
    //  - the function type for a non-static member function,
    //  - the function type to which a pointer to member refers,
    //  - the top-level function type of a function typedef declaration or
    //    alias-declaration,
    //  - the type-id in the default argument of a type-parameter, or
    //  - the type-id of a template-argument for a type-parameter
    //
    // FIXME: Checking this here is insufficient. We accept-invalid on:
    //
    //   template<typename T> struct S { void f(T); };
    //   S<int() const> s;
    //
    // ... for instance.
    if (IsQualifiedFunction
       && !(!FreeFunction
       && D.getDeclSpec().getStorageClassSpec() != DeclSpec.SCS.SCS_static)
       && !IsTypedefName
       && D.getContext() != Declarator.TheContext.TemplateTypeArgContext) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        SourceLocation Loc = D.getLocStart();
        SourceRange RemovalRange/*J*/= new SourceRange();
        uint$ref I = create_uint$ref();
        if (D.isFunctionDeclarator(I)) {
          SmallVector<SourceLocation> RemovalLocs/*J*/= new SmallVector<SourceLocation>(4, new SourceLocation());
          final /*const*/ DeclaratorChunk /*&*/ Chunk = D.getTypeObject(I.$deref());
          assert (Chunk.Kind == DeclaratorChunk.Unnamed_enum.Function);
          if (Chunk.Unnamed_field3.Fun.hasRefQualifier()) {
            RemovalLocs.push_back(Chunk.Unnamed_field3.Fun.getRefQualifierLoc());
          }
          if (((Chunk.Unnamed_field3.Fun.TypeQuals & $int2uint_4bits(Qualifiers.TQ.Const)) != 0)) {
            RemovalLocs.push_back(Chunk.Unnamed_field3.Fun.getConstQualifierLoc());
          }
          if (((Chunk.Unnamed_field3.Fun.TypeQuals & $int2uint_4bits(Qualifiers.TQ.Volatile)) != 0)) {
            RemovalLocs.push_back(Chunk.Unnamed_field3.Fun.getVolatileQualifierLoc());
          }
          if (((Chunk.Unnamed_field3.Fun.TypeQuals & $int2uint_4bits(Qualifiers.TQ.Restrict)) != 0)) {
            RemovalLocs.push_back(Chunk.Unnamed_field3.Fun.getRestrictQualifierLoc());
          }
          if (!RemovalLocs.empty()) {
            std.sort(RemovalLocs.begin(), RemovalLocs.end(), 
                new BeforeThanCompareSourceLocation(S.getSourceManager()));
            RemovalRange.$assignMove(new SourceRange(/*NO_COPY*/RemovalLocs.front(), /*NO_COPY*/RemovalLocs.back()));
            Loc.$assign(RemovalLocs.front());
          }
        }
        
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc), diag.err_invalid_qualified_function_type)), 
                            FreeFunction), D.isFunctionDeclarator()), T), 
                getFunctionQualifiersAsString(FnTy)), 
            FixItHint.CreateRemoval(/*NO_COPY*/RemovalRange)));
        
        // Strip the cv-qualifiers and ref-qualifiers from the type.
        FunctionProtoType.ExtProtoInfo EPI = FnTy.getExtProtoInfo();
        EPI.TypeQuals = 0;
        EPI.RefQualifier = RefQualifierKind.RQ_None;
        
        T.$assignMove(Context.getFunctionType(FnTy.getReturnType(), FnTy.getParamTypes(), 
                EPI));
        // Rebuild any parens around the identifier in the function type.
        for (/*uint*/int i = 0, e = D.getNumTypeObjects(); i != e; ++i) {
          if (D.getTypeObject(i).Kind != DeclaratorChunk.Unnamed_enum.Paren) {
            break;
          }
          T.$assignMove(S.BuildParenType(new QualType(T)));
        }
      } finally {
        $c$.$destroy();
      }
    }
  }
  
  // Apply any undistributed attributes from the declarator.
  processTypeAttrs(state, T, TypeAttrLocation.TAL_DeclName, D.getAttributes());
  
  // Diagnose any ignored type attributes.
  state.diagnoseIgnoredTypeAttrs(new QualType(T));
  
  // C++0x [dcl.constexpr]p9:
  //  A constexpr specifier used in an object declaration declares the object
  //  as const.
  if (D.getDeclSpec().isConstexprSpecified() && T.$arrow().isObjectType()) {
    T.addConst();
  }
  
  // If there was an ellipsis in the declarator, the declaration declares a
  // parameter pack whose type may be a pack expansion type.
  if (D.hasEllipsis()) {
    // C++0x [dcl.fct]p13:
    //   A declarator-id or abstract-declarator containing an ellipsis shall
    //   only be used in a parameter-declaration. Such a parameter-declaration
    //   is a parameter pack (14.5.3). [...]
    switch (D.getContext()) {
     case PrototypeContext:
     case LambdaExprParameterContext:
      // C++0x [dcl.fct]p13:
      //   [...] When it is part of a parameter-declaration-clause, the
      //   parameter pack is a function parameter pack (14.5.3). The type T
      //   of the declarator-id of the function parameter pack shall contain
      //   a template parameter pack; each template parameter pack in T is
      //   expanded by the function parameter pack.
      //
      // We represent function parameter packs as function parameters whose
      // type is a pack expansion.
      if (!T.$arrow().containsUnexpandedParameterPack()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(D.getEllipsisLoc(), 
                      diag.err_function_parameter_pack_without_parameter_packs)), 
                  T), D.getSourceRange()));
          D.setEllipsisLoc(new SourceLocation());
        } finally {
          $c$.$destroy();
        }
      } else {
        T.$assignMove(Context.getPackExpansionType(new QualType(T), new OptionalUInt(None)));
      }
      break;
     case TemplateParamContext:
      // C++0x [temp.param]p15:
      //   If a template-parameter is a [...] is a parameter-declaration that
      //   declares a parameter pack (8.3.5), then the template-parameter is a
      //   template parameter pack (14.5.3).
      //
      // Note: core issue 778 clarifies that, if there are any unexpanded
      // parameter packs in the type of the non-type template parameter, then
      // it expands those parameter packs.
      if (T.$arrow().containsUnexpandedParameterPack()) {
        T.$assignMove(Context.getPackExpansionType(new QualType(T), new OptionalUInt(None)));
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track(S.Diag(D.getEllipsisLoc(), 
              LangOpts.CPlusPlus11 ? diag.warn_cxx98_compat_variadic_templates : diag.ext_variadic_templates)));
        } finally {
          $c$.$destroy();
        }
      }
      break;
     case FileContext:
     case KNRTypeListContext:
     case ObjCParameterContext: // FIXME: special diagnostic here?
     case ObjCResultContext: // FIXME: special diagnostic here?
     case TypeNameContext:
     case CXXNewContext:
     case AliasDeclContext:
     case AliasTemplateContext:
     case MemberContext:
     case BlockContext:
     case ForContext:
     case InitStmtContext:
     case ConditionContext:
     case CXXCatchContext:
     case ObjCCatchContext:
     case BlockLiteralContext:
     case LambdaExprContext:
     case ConversionIdContext:
     case TrailingReturnContext:
     case TemplateTypeArgContext:
      {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // FIXME: We may want to allow parameter packs in block-literal contexts
          // in the future.
          $c$.clean($c$.track(S.Diag(D.getEllipsisLoc(), 
              diag.err_ellipsis_in_declarator_not_parameter)));
          D.setEllipsisLoc(new SourceLocation());
          break;
        } finally {
          $c$.$destroy();
        }
      }
    }
  }
  assert (!T.isNull()) : "T must not be null at the end of this function";
  if (D.isInvalidType()) {
    return Context.getTrivialTypeSourceInfo(new QualType(T));
  }
  
  return S.GetTypeSourceInfoForDeclarator(D, new QualType(T), TInfo.$star());
}

//<editor-fold defaultstate="collapsed" desc="transferARCOwnershipToDeclSpec">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 4596,
 FQN="transferARCOwnershipToDeclSpec", NM="_ZL30transferARCOwnershipToDeclSpecRN5clang4SemaERNS_8QualTypeENS_10Qualifiers12ObjCLifetimeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZL30transferARCOwnershipToDeclSpecRN5clang4SemaERNS_8QualTypeENS_10Qualifiers12ObjCLifetimeE")
//</editor-fold>
public static void transferARCOwnershipToDeclSpec(final Sema /*&*/ S, 
                              final QualType /*&*/ declSpecTy, 
                              Qualifiers.ObjCLifetime ownership) {
  if (declSpecTy.$arrow().isObjCRetainableType()
     && declSpecTy.getObjCLifetime() == Qualifiers.ObjCLifetime.OCL_None) {
    Qualifiers qs/*J*/= new Qualifiers();
    qs.addObjCLifetime(ownership);
    declSpecTy.$assignMove(S.Context.getQualifiedType(new QualType(declSpecTy), new Qualifiers(qs)));
  }
}


/// \brief Used for transferring ownership in casts resulting in l-values.
//<editor-fold defaultstate="collapsed" desc="transferARCOwnership">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 4647,
 FQN="transferARCOwnership", NM="_ZL20transferARCOwnershipRN12_GLOBAL__N_119TypeProcessingStateERN5clang8QualTypeENS2_10Qualifiers12ObjCLifetimeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZL20transferARCOwnershipRN12_GLOBAL__N_119TypeProcessingStateERN5clang8QualTypeENS2_10Qualifiers12ObjCLifetimeE")
//</editor-fold>
public static void transferARCOwnership(final TypeProcessingState /*&*/ state, 
                    final QualType /*&*/ declSpecTy, 
                    Qualifiers.ObjCLifetime ownership) {
  final Sema /*&*/ S = state.getSema();
  final Declarator /*&*/ D = state.getDeclarator();
  
  int inner = -1;
  boolean hasIndirection = false;
  for (/*uint*/int i = 0, e = D.getNumTypeObjects(); i != e; ++i) {
    final DeclaratorChunk /*&*/ chunk = D.getTypeObject(i);
    switch (chunk.Kind) {
     case Paren:
      // Ignore parens.
      break;
     case Array:
     case Reference:
     case Pointer:
      if (inner != -1) {
        hasIndirection = true;
      }
      inner = i;
      break;
     case BlockPointer:
      if (inner != -1) {
        transferARCOwnershipToDeclaratorChunk(state, ownership, i);
      }
      return;
     case Function:
     case MemberPointer:
     case Pipe:
      return;
    }
  }
  if (inner == -1) {
    return;
  }
  
  final DeclaratorChunk /*&*/ chunk = D.getTypeObject(inner);
  if (chunk.Kind == DeclaratorChunk.Unnamed_enum.Pointer) {
    if (declSpecTy.$arrow().isObjCRetainableType()) {
      transferARCOwnershipToDeclSpec(S, declSpecTy, ownership);
      return;
    }
    if (declSpecTy.$arrow().isObjCObjectType() && hasIndirection) {
      transferARCOwnershipToDeclaratorChunk(state, ownership, inner);
      return;
    }
  } else {
    assert (chunk.Kind == DeclaratorChunk.Unnamed_enum.Array || chunk.Kind == DeclaratorChunk.Unnamed_enum.Reference);
    transferARCOwnershipToDeclSpec(S, declSpecTy, ownership);
    return;
  }
}


/// Map an AttributedType::Kind to an AttributeList::Kind.
//<editor-fold defaultstate="collapsed" desc="getAttrListKind">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 4714,
 FQN="getAttrListKind", NM="_ZL15getAttrListKindN5clang14AttributedType4KindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZL15getAttrListKindN5clang14AttributedType4KindE")
//</editor-fold>
public static AttributeList.Kind getAttrListKind(AttributedType.Kind kind) {
  switch (kind) {
   case attr_address_space:
    return AttributeList.Kind.AT_AddressSpace;
   case attr_regparm:
    return AttributeList.Kind.AT_Regparm;
   case attr_vector_size:
    return AttributeList.Kind.AT_VectorSize;
   case attr_neon_vector_type:
    return AttributeList.Kind.AT_NeonVectorType;
   case attr_neon_polyvector_type:
    return AttributeList.Kind.AT_NeonPolyVectorType;
   case attr_objc_gc:
    return AttributeList.Kind.AT_ObjCGC;
   case attr_objc_ownership:
   case attr_objc_inert_unsafe_unretained:
    return AttributeList.Kind.AT_ObjCOwnership;
   case attr_noreturn:
    return AttributeList.Kind.AT_NoReturn;
   case attr_cdecl:
    return AttributeList.Kind.AT_CDecl;
   case attr_fastcall:
    return AttributeList.Kind.AT_FastCall;
   case attr_stdcall:
    return AttributeList.Kind.AT_StdCall;
   case attr_thiscall:
    return AttributeList.Kind.AT_ThisCall;
   case attr_pascal:
    return AttributeList.Kind.AT_Pascal;
   case attr_swiftcall:
    return AttributeList.Kind.AT_SwiftCall;
   case attr_vectorcall:
    return AttributeList.Kind.AT_VectorCall;
   case attr_pcs:
   case attr_pcs_vfp:
    return AttributeList.Kind.AT_Pcs;
   case attr_inteloclbicc:
    return AttributeList.Kind.AT_IntelOclBicc;
   case attr_ms_abi:
    return AttributeList.Kind.AT_MSABI;
   case attr_sysv_abi:
    return AttributeList.Kind.AT_SysVABI;
   case attr_preserve_most:
    return AttributeList.Kind.AT_PreserveMost;
   case attr_preserve_all:
    return AttributeList.Kind.AT_PreserveAll;
   case attr_ptr32:
    return AttributeList.Kind.AT_Ptr32;
   case attr_ptr64:
    return AttributeList.Kind.AT_Ptr64;
   case attr_sptr:
    return AttributeList.Kind.AT_SPtr;
   case attr_uptr:
    return AttributeList.Kind.AT_UPtr;
   case attr_nonnull:
    return AttributeList.Kind.AT_TypeNonNull;
   case attr_nullable:
    return AttributeList.Kind.AT_TypeNullable;
   case attr_null_unspecified:
    return AttributeList.Kind.AT_TypeNullUnspecified;
   case attr_objc_kindof:
    return AttributeList.Kind.AT_ObjCKindOf;
  }
  throw new llvm_unreachable("unexpected attribute kind!");
}

//<editor-fold defaultstate="collapsed" desc="fillAttributedTypeLoc">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 4780,
 FQN="fillAttributedTypeLoc", NM="_ZL21fillAttributedTypeLocN5clang17AttributedTypeLocEPKNS_13AttributeListES3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZL21fillAttributedTypeLocN5clang17AttributedTypeLocEPKNS_13AttributeListES3_")
//</editor-fold>
public static void fillAttributedTypeLoc(AttributedTypeLoc TL, 
                     /*const*/ AttributeList /*P*/ attrs) {
  fillAttributedTypeLoc(TL, 
                     attrs, 
                     (/*const*/ AttributeList /*P*/ )null);
}
public static void fillAttributedTypeLoc(AttributedTypeLoc TL, 
                     /*const*/ AttributeList /*P*/ attrs, 
                     /*const*/ AttributeList /*P*/ DeclAttrs/*= null*/) {
  // DeclAttrs and attrs cannot be both empty.
  assert (((attrs != null) || (DeclAttrs != null))) : "no type attributes in the expected location!";
  
  AttributeList.Kind parsedKind = getAttrListKind(TL.getAttrKind());
  // Try to search for an attribute of matching kind in attrs list.
  while ((attrs != null) && attrs.getKind() != parsedKind) {
    attrs = attrs.getNext();
  }
  if (!(attrs != null)) {
    // No matching type attribute in attrs list found.
    // Try searching through C++11 attributes in the declarator attribute list.
    while ((DeclAttrs != null) && (!DeclAttrs.isCXX11Attribute()
       || DeclAttrs.getKind() != parsedKind)) {
      DeclAttrs = DeclAttrs.getNext();
    }
    attrs = DeclAttrs;
  }
  assert ((attrs != null)) : "no matching type attribute in expected location!";
  
  TL.setAttrNameLoc(attrs.getLoc());
  if (TL.hasAttrExprOperand()) {
    assert (attrs.isArgExpr(0)) : "mismatched attribute operand kind";
    TL.setAttrExprOperand(attrs.getArgAsExpr(0));
  } else if (TL.hasAttrEnumOperand()) {
    assert ((attrs.isArgIdent(0) || attrs.isArgExpr(0))) : "unexpected attribute operand kind";
    if (attrs.isArgIdent(0)) {
      TL.setAttrEnumOperandLoc(new SourceLocation(attrs.getArgAsIdent(0).Loc));
    } else {
      TL.setAttrEnumOperandLoc(attrs.getArgAsExpr(0).getExprLoc());
    }
  }
  
  // FIXME: preserve this information to here.
  if (TL.hasAttrOperand()) {
    TL.setAttrOperandParensRange(new SourceRange());
  }
}

// end anonymous namespace
//<editor-fold defaultstate="collapsed" desc="fillAtomicQualLoc">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 5113,
 FQN="fillAtomicQualLoc", NM="_ZL17fillAtomicQualLocN5clang13AtomicTypeLocERKNS_15DeclaratorChunkE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZL17fillAtomicQualLocN5clang13AtomicTypeLocERKNS_15DeclaratorChunkE")
//</editor-fold>
public static void fillAtomicQualLoc(AtomicTypeLoc ATL, final /*const*/ DeclaratorChunk /*&*/ Chunk) {
  SourceLocation Loc/*J*/= new SourceLocation();
  switch (Chunk.Kind) {
   case Function:
   case Array:
   case Paren:
   case Pipe:
    throw new llvm_unreachable("cannot be _Atomic qualified");
   case Pointer:
    Loc.$assignMove(SourceLocation.getFromRawEncoding(Chunk.Unnamed_field3.Ptr.AtomicQualLoc));
    break;
   case BlockPointer:
   case Reference:
   case MemberPointer:
    // FIXME: Provide a source location for the _Atomic keyword.
    break;
  }
  
  ATL.setKWLoc(new SourceLocation(Loc));
  ATL.setParensRange(new SourceRange());
}


//===----------------------------------------------------------------------===//
// Type Attribute Processing
//===----------------------------------------------------------------------===//

/// HandleAddressSpaceTypeAttribute - Process an address_space attribute on the
/// specified type.  The attribute contains 1 argument, the id of the address
/// space for the type.
//<editor-fold defaultstate="collapsed" desc="HandleAddressSpaceTypeAttribute">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 5254,
 FQN="HandleAddressSpaceTypeAttribute", NM="_ZL31HandleAddressSpaceTypeAttributeRN5clang8QualTypeERKNS_13AttributeListERNS_4SemaE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZL31HandleAddressSpaceTypeAttributeRN5clang8QualTypeERKNS_13AttributeListERNS_4SemaE")
//</editor-fold>
public static void HandleAddressSpaceTypeAttribute(final QualType /*&*/ Type, 
                               final /*const*/ AttributeList /*&*/ Attr, final Sema /*&*/ S) {
  
  // If this type is already address space qualified, reject it.
  // ISO/IEC TR 18037 S5.3 (amending C99 6.7.3): "No type shall be qualified by
  // qualifiers for two or more different address spaces."
  if ((Type.getAddressSpace() != 0)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track(S.Diag(Attr.getLoc(), diag.err_attribute_address_multiple_qualifiers)));
      Attr.setInvalid();
      return;
    } finally {
      $c$.$destroy();
    }
  }
  
  // ISO/IEC TR 18037 S5.3 (amending C99 6.7.3): "A function type shall not be
  // qualified by an address-space qualifier."
  if (Type.$arrow().isFunctionType()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track(S.Diag(Attr.getLoc(), diag.err_attribute_address_function_type)));
      Attr.setInvalid();
      return;
    } finally {
      $c$.$destroy();
    }
  }
  
  /*uint*/int ASIdx;
  if (Attr.getKind() == AttributeList.Kind.AT_AddressSpace) {
    // Check the attribute arguments.
    if (Attr.getNumArgs() != 1) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_attribute_wrong_number_arguments)), 
                Attr.getName()), 1));
        Attr.setInvalid();
        return;
      } finally {
        $c$.$destroy();
      }
    }
    Expr /*P*/ ASArgExpr = ((/*static_cast*/Expr /*P*/ )(Attr.getArgAsExpr(0)));
    APSInt addrSpace/*J*/= new APSInt(32);
    if (ASArgExpr.isTypeDependent() || ASArgExpr.isValueDependent()
       || !ASArgExpr.isIntegerConstantExpr(addrSpace, S.Context)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_attribute_argument_type)), 
                    Attr.getName()), AttributeArgumentNType.AANT_ArgumentIntegerConstant), 
            ASArgExpr.getSourceRange()));
        Attr.setInvalid();
        return;
      } finally {
        $c$.$destroy();
      }
    }
    
    // Bounds checking.
    if (addrSpace.isSigned()) {
      if (addrSpace.isNegative()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_attribute_address_space_negative)), 
              ASArgExpr.getSourceRange()));
          Attr.setInvalid();
          return;
        } finally {
          $c$.$destroy();
        }
      }
      addrSpace.setIsSigned(false);
    }
    APSInt max/*J*/= new APSInt(addrSpace.getBitWidth());
    max.$assign(/*KEEP_ENUM*/Qualifiers.MaxAddressSpace);
    if (addrSpace.$greater(max)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_attribute_address_space_too_high)), 
                ((int)(Qualifiers.MaxAddressSpace))), ASArgExpr.getSourceRange()));
        Attr.setInvalid();
        return;
      } finally {
        $c$.$destroy();
      }
    }
    ASIdx = ((/*static_cast*//*uint*/int)($ulong2uint(addrSpace.getZExtValue())));
  } else {
    // The keyword-based type attributes imply which address space to use.
    switch (Attr.getKind()) {
     case AT_OpenCLGlobalAddressSpace:
      ASIdx = LangAS.ID.opencl_global;
      break;
     case AT_OpenCLLocalAddressSpace:
      ASIdx = LangAS.ID.opencl_local;
      break;
     case AT_OpenCLConstantAddressSpace:
      ASIdx = LangAS.ID.opencl_constant;
      break;
     case AT_OpenCLGenericAddressSpace:
      ASIdx = LangAS.ID.opencl_generic;
      break;
     default:
      assert (Attr.getKind() == AttributeList.Kind.AT_OpenCLPrivateAddressSpace);
      ASIdx = 0;
      break;
    }
  }
  
  Type.$assignMove(S.Context.getAddrSpaceQualType(new QualType(Type), ASIdx));
}


/// Does this type have a "direct" ownership qualifier?  That is,
/// is it written like "__strong id", as opposed to something like
/// "typeof(foo)", where that happens to be strong?
//<editor-fold defaultstate="collapsed" desc="hasDirectOwnershipQualifier">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 5336,
 FQN="hasDirectOwnershipQualifier", NM="_ZL27hasDirectOwnershipQualifierN5clang8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZL27hasDirectOwnershipQualifierN5clang8QualTypeE")
//</editor-fold>
public static boolean hasDirectOwnershipQualifier(QualType type) {
  // Fast path: no qualifier at all.
  assert (type.getQualifiers().hasObjCLifetime());
  while (true) {
    {
      // __strong id
      /*const*/ AttributedType /*P*/ attr = dyn_cast_AttributedType(type);
      if ((attr != null)) {
        if (attr.getAttrKind() == AttributedType.Kind.attr_objc_ownership) {
          return true;
        }
        
        type.$assignMove(attr.getModifiedType());
        // X *__strong (...)
      } else {
        /*const*/ ParenType /*P*/ paren = dyn_cast_ParenType(type);
        if ((paren != null)) {
          type.$assignMove(paren.getInnerType());
          // That's it for things we want to complain about.  In particular,
          // we do not want to look through typedefs, typeof(expr),
          // typeof(type), or any other way that the type is somehow
          // abstracted.
        } else {
          
          return false;
        }
      }
    }
  }
}


/// Map a nullability attribute kind to a nullability kind.
//<editor-fold defaultstate="collapsed" desc="mapNullabilityAttrKind">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 5956,
 FQN="mapNullabilityAttrKind", NM="_ZL22mapNullabilityAttrKindN5clang13AttributeList4KindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZL22mapNullabilityAttrKindN5clang13AttributeList4KindE")
//</editor-fold>
public static NullabilityKind mapNullabilityAttrKind(AttributeList.Kind kind) {
  switch (kind) {
   case AT_TypeNonNull:
    return NullabilityKind.NonNull;
   case AT_TypeNullable:
    return NullabilityKind.Nullable;
   case AT_TypeNullUnspecified:
    return NullabilityKind.Unspecified;
   default:
    throw new llvm_unreachable("not a nullability attribute kind");
  }
}


/// Distribute a nullability type attribute that cannot be applied to
/// the type specifier to a pointer, block pointer, or member pointer
/// declarator, complaining if necessary.
///
/// \returns true if the nullability annotation was distributed, false
/// otherwise.
//<editor-fold defaultstate="collapsed" desc="distributeNullabilityTypeAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 5978,
 FQN="distributeNullabilityTypeAttr", NM="_ZL29distributeNullabilityTypeAttrRN12_GLOBAL__N_119TypeProcessingStateEN5clang8QualTypeERNS2_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZL29distributeNullabilityTypeAttrRN12_GLOBAL__N_119TypeProcessingStateEN5clang8QualTypeERNS2_13AttributeListE")
//</editor-fold>
public static boolean distributeNullabilityTypeAttr(final TypeProcessingState /*&*/ state, 
                             QualType type, 
                             final AttributeList /*&*/ attr) {
  final Declarator /*&*/ declarator = state.getDeclarator();
  
  /// Attempt to move the attribute to the specified chunk.
  DeclaratorChunkBool2Bool moveToChunk =  (chunk, inFunction) -> 
    {
      Sema.SemaDiagnosticBuilder diag = null;
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // If there is already a nullability attribute there, don't add
        // one.
        if (hasNullabilityAttr(chunk.getAttrListRef().$deref())) {
          return false;
        }
        
        // Complain about the nullability qualifier being in the wrong
        // place.
        /*enum ANONYMOUS_INT_CONSTANTS {*/
          final /*uint*/int PK_Pointer = 0;
          final /*uint*/int PK_BlockPointer = PK_Pointer + 1;
          final /*uint*/int PK_MemberPointer = PK_BlockPointer + 1;
          final /*uint*/int PK_FunctionPointer = PK_MemberPointer + 1;
          final /*uint*/int PK_MemberFunctionPointer = PK_FunctionPointer + 1;
        /*}*//*Unnamed enum*//*uint*/int pointerKind = chunk.Kind == DeclaratorChunk.Unnamed_enum.Pointer ? (inFunction ? PK_FunctionPointer : PK_Pointer) : chunk.Kind == DeclaratorChunk.Unnamed_enum.BlockPointer ? PK_BlockPointer : inFunction ? PK_MemberFunctionPointer : PK_MemberPointer;
        
        /*FIXME: Initializer produces not destroyed temporary!*/diag = $c$.clean(new Sema.SemaDiagnosticBuilder($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(state.getSema().Diag(attr.getLoc(), 
                            org.clang.basic.diag.warn_nullability_declspec)), 
                        new std.pairTypeBool<NullabilityKind>(JD$T$RR_T1$RR.INSTANCE, mapNullabilityAttrKind(attr.getKind()), 
                            attr.isContextSensitiveKeywordAttribute())), 
                    type), 
                ((/*static_cast*//*uint*/int)(pointerKind)))));
        
        // FIXME: MemberPointer chunks don't carry the location of the *.
        if (chunk.Kind != DeclaratorChunk.Unnamed_enum.MemberPointer) {
          $out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R(diag, FixItHint.CreateRemoval(new SourceRange(attr.getLoc()))), 
              FixItHint.CreateInsertion(state.getSema().getPreprocessor().
                      getLocForEndOfToken(/*NO_COPY*/chunk.Loc), 
                  new StringRef($add_string_T$C$P($add_T$C$P_string(/*KEEP_STR*/" ", attr.getName().getName().str()), /*KEEP_STR*/" "))));
        }
        
        moveAttrFromListToList(attr, state.getCurrentAttrListRef(), 
            chunk.getAttrListRef());
        return true;
      } finally {
        if (diag != null) { diag.$destroy(); }
        $c$.$destroy();
      }
    }
;
  
  // Move it to the outermost pointer, member pointer, or block
  // pointer declarator.
  for (/*uint*/int i = state.getCurrentChunkIndex(); i != 0; --i) {
    final DeclaratorChunk /*&*/ chunk = declarator.getTypeObject(i - 1);
    switch (chunk.Kind) {
     case Pointer:
     case BlockPointer:
     case MemberPointer:
      return moveToChunk.$call(chunk, /*KEEP_BOOL*/false);
     case Paren:
     case Array:
      continue;
     case Function:
      {
        // Try to move past the return type to a function/block/member
        // function pointer.
        DeclaratorChunk /*P*/ dest = maybeMovePastReturnType(declarator, i, 
            /*onlyBlockPointers=*/ false);
        if ((dest != null)) {
          return moveToChunk.$call($Deref(dest), /*KEEP_BOOL*/true);
        }
      }
      
      return false;
     case Reference:
     case Pipe:
      
      // Don't walk through these.
      return false;
    }
  }
  
  return false;
}

//<editor-fold defaultstate="collapsed" desc="getCCTypeAttrKind">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 6060,
 FQN="getCCTypeAttrKind", NM="_ZL17getCCTypeAttrKindRN5clang13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZL17getCCTypeAttrKindRN5clang13AttributeListE")
//</editor-fold>
public static AttributedType.Kind getCCTypeAttrKind(final AttributeList /*&*/ Attr) {
  assert (!Attr.isInvalid());
  switch (Attr.getKind()) {
   default:
    throw new llvm_unreachable("not a calling convention attribute");
   case AT_CDecl:
    return AttributedType.Kind.attr_cdecl;
   case AT_FastCall:
    return AttributedType.Kind.attr_fastcall;
   case AT_StdCall:
    return AttributedType.Kind.attr_stdcall;
   case AT_ThisCall:
    return AttributedType.Kind.attr_thiscall;
   case AT_Pascal:
    return AttributedType.Kind.attr_pascal;
   case AT_SwiftCall:
    return AttributedType.Kind.attr_swiftcall;
   case AT_VectorCall:
    return AttributedType.Kind.attr_vectorcall;
   case AT_Pcs:
    {
      // The attribute may have had a fixit applied where we treated an
      // identifier as a string literal.  The contents of the string are valid,
      // but the form may not be.
      StringRef Str/*J*/= new StringRef();
      if (Attr.isArgExpr(0)) {
        Str.$assignMove(cast_StringLiteral(Attr.getArgAsExpr(0)).getString());
      } else {
        Str.$assignMove(Attr.getArgAsIdent(0).Ident.getName());
      }
      return new StringSwitch<AttributedType.Kind>(/*NO_COPY*/Str).
          Case(/*KEEP_STR*/"aapcs", AttributedType.Kind.attr_pcs).
          Case(/*KEEP_STR*/"aapcs-vfp", AttributedType.Kind.attr_pcs_vfp).$T1();
    }
   case AT_IntelOclBicc:
    return AttributedType.Kind.attr_inteloclbicc;
   case AT_MSABI:
    return AttributedType.Kind.attr_ms_abi;
   case AT_SysVABI:
    return AttributedType.Kind.attr_sysv_abi;
   case AT_PreserveMost:
    return AttributedType.Kind.attr_preserve_most;
   case AT_PreserveAll:
    return AttributedType.Kind.attr_preserve_all;
  }
  //throw new llvm_unreachable("unexpected attribute kind!");
}


/// HandleVectorSizeAttribute - this attribute is only applicable to integral
/// and float scalars, although arrays, pointers, and function return values are
/// allowed in conjunction with this construct. Aggregates with this attribute
/// are invalid, even if they are of the same size as a corresponding scalar.
/// The raw attribute should contain precisely 1 argument, the vector size for
/// the variable, measured in bytes. If curType and rawAttr are well formed,
/// this routine will return a new vector type.
//<editor-fold defaultstate="collapsed" desc="HandleVectorSizeAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 6303,
 FQN="HandleVectorSizeAttr", NM="_ZL20HandleVectorSizeAttrRN5clang8QualTypeERKNS_13AttributeListERNS_4SemaE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZL20HandleVectorSizeAttrRN5clang8QualTypeERKNS_13AttributeListERNS_4SemaE")
//</editor-fold>
public static void HandleVectorSizeAttr(final QualType /*&*/ CurType, final /*const*/ AttributeList /*&*/ Attr, 
                    final Sema /*&*/ S) {
  // Check the attribute arguments.
  if (Attr.getNumArgs() != 1) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_attribute_wrong_number_arguments)), 
              Attr.getName()), 1));
      Attr.setInvalid();
      return;
    } finally {
      $c$.$destroy();
    }
  }
  Expr /*P*/ sizeExpr = ((/*static_cast*/Expr /*P*/ )(Attr.getArgAsExpr(0)));
  APSInt vecSize/*J*/= new APSInt(32);
  if (sizeExpr.isTypeDependent() || sizeExpr.isValueDependent()
     || !sizeExpr.isIntegerConstantExpr(vecSize, S.Context)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_attribute_argument_type)), 
                  Attr.getName()), AttributeArgumentNType.AANT_ArgumentIntegerConstant), 
          sizeExpr.getSourceRange()));
      Attr.setInvalid();
      return;
    } finally {
      $c$.$destroy();
    }
  }
  // The base type must be integer (not Boolean or enumeration) or float, and
  // can't already be a vector.
  if (!CurType.$arrow().isBuiltinType() || CurType.$arrow().isBooleanType()
     || (!CurType.$arrow().isIntegerType() && !CurType.$arrow().isRealFloatingType())) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_attribute_invalid_vector_type)), CurType));
      Attr.setInvalid();
      return;
    } finally {
      $c$.$destroy();
    }
  }
  /*uint*/int typeSize = ((/*static_cast*//*uint*/int)($ulong2uint(S.Context.getTypeSize(new QualType(CurType)))));
  // vecSize is specified in bytes - convert to bits.
  /*uint*/int vectorSize = ((/*static_cast*//*uint*/int)($ullong2uint(vecSize.getZExtValue() * 8)));
  
  // the vector size needs to be an integral multiple of the type size.
  if ((($rem_uint(vectorSize, typeSize)) != 0)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_attribute_invalid_size)), 
          sizeExpr.getSourceRange()));
      Attr.setInvalid();
      return;
    } finally {
      $c$.$destroy();
    }
  }
  if (VectorType.isVectorSizeTooLarge($div_uint(vectorSize, typeSize))) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_attribute_size_too_large)), 
          sizeExpr.getSourceRange()));
      Attr.setInvalid();
      return;
    } finally {
      $c$.$destroy();
    }
  }
  if (vectorSize == 0) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_attribute_zero_size)), 
          sizeExpr.getSourceRange()));
      Attr.setInvalid();
      return;
    } finally {
      $c$.$destroy();
    }
  }
  
  // Success! Instantiate the vector type, the number of elements is > 0, and
  // not required to be a power of 2, unlike GCC.
  CurType.$assignMove(S.Context.getVectorType(new QualType(CurType), $div_uint(vectorSize, typeSize), 
          VectorType.VectorKind.GenericVector));
}


/// \brief Process the OpenCL-like ext_vector_type attribute when it occurs on
/// a type.
//<editor-fold defaultstate="collapsed" desc="HandleExtVectorTypeAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 6362,
 FQN="HandleExtVectorTypeAttr", NM="_ZL23HandleExtVectorTypeAttrRN5clang8QualTypeERKNS_13AttributeListERNS_4SemaE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZL23HandleExtVectorTypeAttrRN5clang8QualTypeERKNS_13AttributeListERNS_4SemaE")
//</editor-fold>
public static void HandleExtVectorTypeAttr(final QualType /*&*/ CurType, 
                       final /*const*/ AttributeList /*&*/ Attr, 
                       final Sema /*&*/ S) {
  // check the attribute arguments.
  if (Attr.getNumArgs() != 1) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_attribute_wrong_number_arguments)), 
              Attr.getName()), 1));
      return;
    } finally {
      $c$.$destroy();
    }
  }
  
  Expr /*P*/ sizeExpr;
  
  // Special case where the argument is a template id.
  if (Attr.isArgIdent(0)) {
    CXXScopeSpec SS = null;
    try {
      SS/*J*/= new CXXScopeSpec();
      SourceLocation TemplateKWLoc/*J*/= new SourceLocation();
      UnqualifiedId id/*J*/= new UnqualifiedId();
      id.setIdentifier(Attr.getArgAsIdent(0).Ident, Attr.getLoc());
      
      ActionResultTTrue<Expr /*P*/ > Size = S.ActOnIdExpression(S.getCurScope(), SS, new SourceLocation(TemplateKWLoc), 
          id, false, false);
      if (Size.isInvalid()) {
        return;
      }
      
      sizeExpr = Size.get();
    } finally {
      if (SS != null) { SS.$destroy(); }
    }
  } else {
    sizeExpr = Attr.getArgAsExpr(0);
  }
  
  // Create the vector type.
  QualType T = S.BuildExtVectorType(new QualType(CurType), sizeExpr, Attr.getLoc());
  if (!T.isNull()) {
    CurType.$assign(T);
  }
}

//<editor-fold defaultstate="collapsed" desc="isPermittedNeonBaseType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 6397,
 FQN="isPermittedNeonBaseType", NM="_ZL23isPermittedNeonBaseTypeRN5clang8QualTypeENS_10VectorType10VectorKindERNS_4SemaE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZL23isPermittedNeonBaseTypeRN5clang8QualTypeENS_10VectorType10VectorKindERNS_4SemaE")
//</editor-fold>
public static boolean isPermittedNeonBaseType(final QualType /*&*/ Ty, 
                       VectorType.VectorKind VecKind, final Sema /*&*/ S) {
  /*const*/ BuiltinType /*P*/ BTy = Ty.$arrow().<BuiltinType>getAs$BuiltinType();
  if (!(BTy != null)) {
    return false;
  }
  
  Triple triple = new Triple(S.Context.getTargetInfo().getTriple());
  
  // Signed poly is mathematically wrong, but has been baked into some ABIs by
  // now.
  boolean IsPolyUnsigned = triple.getArch() == Triple.ArchType.aarch64
     || triple.getArch() == Triple.ArchType.aarch64_be;
  if (VecKind == VectorType.VectorKind.NeonPolyVector) {
    if (IsPolyUnsigned) {
      // AArch64 polynomial vectors are unsigned and support poly64.
      return BTy.getKind() == BuiltinType.Kind.UChar
         || BTy.getKind() == BuiltinType.Kind.UShort
         || BTy.getKind() == BuiltinType.Kind.ULong
         || BTy.getKind() == BuiltinType.Kind.ULongLong;
    } else {
      // AArch32 polynomial vector are signed.
      return BTy.getKind() == BuiltinType.Kind.SChar
         || BTy.getKind() == BuiltinType.Kind.Short;
    }
  }
  
  // Non-polynomial vector types: the usual suspects are allowed, as well as
  // float64_t on AArch64.
  boolean Is64Bit = triple.getArch() == Triple.ArchType.aarch64
     || triple.getArch() == Triple.ArchType.aarch64_be;
  if (Is64Bit && BTy.getKind() == BuiltinType.Kind.Double) {
    return true;
  }
  
  return BTy.getKind() == BuiltinType.Kind.SChar
     || BTy.getKind() == BuiltinType.Kind.UChar
     || BTy.getKind() == BuiltinType.Kind.Short
     || BTy.getKind() == BuiltinType.Kind.UShort
     || BTy.getKind() == BuiltinType.Kind.Int
     || BTy.getKind() == BuiltinType.Kind.UInt
     || BTy.getKind() == BuiltinType.Kind.Long
     || BTy.getKind() == BuiltinType.Kind.ULong
     || BTy.getKind() == BuiltinType.Kind.LongLong
     || BTy.getKind() == BuiltinType.Kind.ULongLong
     || BTy.getKind() == BuiltinType.Kind.Float
     || BTy.getKind() == BuiltinType.Kind.Half;
}


/// HandleNeonVectorTypeAttr - The "neon_vector_type" and
/// "neon_polyvector_type" attributes are used to create vector types that
/// are mangled according to ARM's ABI.  Otherwise, these types are identical
/// to those created with the "vector_size" attribute.  Unlike "vector_size"
/// the argument to these Neon attributes is the number of vector elements,
/// not the vector size in bytes.  The vector width and element type must
/// match one of the standard Neon vector types.
//<editor-fold defaultstate="collapsed" desc="HandleNeonVectorTypeAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 6452,
 FQN="HandleNeonVectorTypeAttr", NM="_ZL24HandleNeonVectorTypeAttrRN5clang8QualTypeERKNS_13AttributeListERNS_4SemaENS_10VectorType10VectorKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZL24HandleNeonVectorTypeAttrRN5clang8QualTypeERKNS_13AttributeListERNS_4SemaENS_10VectorType10VectorKindE")
//</editor-fold>
public static void HandleNeonVectorTypeAttr(final QualType /*&*/ CurType, 
                        final /*const*/ AttributeList /*&*/ Attr, final Sema /*&*/ S, 
                        VectorType.VectorKind VecKind) {
  // Target must have NEON
  if (!S.Context.getTargetInfo().hasFeature(new StringRef(/*KEEP_STR*/"neon"))) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_attribute_unsupported)), Attr.getName()));
      Attr.setInvalid();
      return;
    } finally {
      $c$.$destroy();
    }
  }
  // Check the attribute arguments.
  if (Attr.getNumArgs() != 1) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_attribute_wrong_number_arguments)), 
              Attr.getName()), 1));
      Attr.setInvalid();
      return;
    } finally {
      $c$.$destroy();
    }
  }
  // The number of elements must be an ICE.
  Expr /*P*/ numEltsExpr = ((/*static_cast*/Expr /*P*/ )(Attr.getArgAsExpr(0)));
  APSInt numEltsInt/*J*/= new APSInt(32);
  if (numEltsExpr.isTypeDependent() || numEltsExpr.isValueDependent()
     || !numEltsExpr.isIntegerConstantExpr(numEltsInt, S.Context)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_attribute_argument_type)), 
                  Attr.getName()), AttributeArgumentNType.AANT_ArgumentIntegerConstant), 
          numEltsExpr.getSourceRange()));
      Attr.setInvalid();
      return;
    } finally {
      $c$.$destroy();
    }
  }
  // Only certain element types are supported for Neon vectors.
  if (!isPermittedNeonBaseType(CurType, VecKind, S)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_attribute_invalid_vector_type)), CurType));
      Attr.setInvalid();
      return;
    } finally {
      $c$.$destroy();
    }
  }
  
  // The total size of the vector must be 64 or 128 bits.
  /*uint*/int typeSize = ((/*static_cast*//*uint*/int)($ulong2uint(S.Context.getTypeSize(new QualType(CurType)))));
  /*uint*/int numElts = ((/*static_cast*//*uint*/int)($ulong2uint(numEltsInt.getZExtValue())));
  /*uint*/int vecSize = typeSize * numElts;
  if (vecSize != 64 && vecSize != 128) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLoc(), diag.err_attribute_bad_neon_vector_size)), CurType));
      Attr.setInvalid();
      return;
    } finally {
      $c$.$destroy();
    }
  }
  
  CurType.$assignMove(S.Context.getVectorType(new QualType(CurType), numElts, VecKind));
}


/// Handle OpenCL Access Qualifier Attribute.
//<editor-fold defaultstate="collapsed" desc="HandleOpenCLAccessAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 6500,
 FQN="HandleOpenCLAccessAttr", NM="_ZL22HandleOpenCLAccessAttrRN5clang8QualTypeERKNS_13AttributeListERNS_4SemaE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZL22HandleOpenCLAccessAttrRN5clang8QualTypeERKNS_13AttributeListERNS_4SemaE")
//</editor-fold>
public static void HandleOpenCLAccessAttr(final QualType /*&*/ CurType, final /*const*/ AttributeList /*&*/ Attr, 
                      final Sema /*&*/ S) {
  // OpenCL v2.0 s6.6 - Access qualifier can be used only for image and pipe type.
  if (!(CurType.$arrow().isImageType() || CurType.$arrow().isPipeType())) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track(S.Diag(Attr.getLoc(), diag.err_opencl_invalid_access_qualifier)));
      Attr.setInvalid();
      return;
    } finally {
      $c$.$destroy();
    }
  }
  {
    
    /*const*/ TypedefType /*P*/ TypedefTy = CurType.$arrow().<TypedefType>getAs$TypedefType();
    if ((TypedefTy != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        QualType PointeeTy = TypedefTy.desugar();
        $c$.clean($c$.track(S.Diag(Attr.getLoc(), diag.err_opencl_multiple_access_qualifiers)));
        
        std.string PrevAccessQual/*J*/= new std.string();
        switch (cast_BuiltinType(PointeeTy.getTypePtr()).getKind()) {
         case OCLImage1dRO:
          PrevAccessQual.$assign_T$C$P(/*KEEP_STR*/"read_only");
          break;
         case OCLImage1dArrayRO:
          PrevAccessQual.$assign_T$C$P(/*KEEP_STR*/"read_only");
          break;
         case OCLImage1dBufferRO:
          PrevAccessQual.$assign_T$C$P(/*KEEP_STR*/"read_only");
          break;
         case OCLImage2dRO:
          PrevAccessQual.$assign_T$C$P(/*KEEP_STR*/"read_only");
          break;
         case OCLImage2dArrayRO:
          PrevAccessQual.$assign_T$C$P(/*KEEP_STR*/"read_only");
          break;
         case OCLImage2dDepthRO:
          PrevAccessQual.$assign_T$C$P(/*KEEP_STR*/"read_only");
          break;
         case OCLImage2dArrayDepthRO:
          PrevAccessQual.$assign_T$C$P(/*KEEP_STR*/"read_only");
          break;
         case OCLImage2dMSAARO:
          PrevAccessQual.$assign_T$C$P(/*KEEP_STR*/"read_only");
          break;
         case OCLImage2dArrayMSAARO:
          PrevAccessQual.$assign_T$C$P(/*KEEP_STR*/"read_only");
          break;
         case OCLImage2dMSAADepthRO:
          PrevAccessQual.$assign_T$C$P(/*KEEP_STR*/"read_only");
          break;
         case OCLImage2dArrayMSAADepthRO:
          PrevAccessQual.$assign_T$C$P(/*KEEP_STR*/"read_only");
          break;
         case OCLImage3dRO:
          PrevAccessQual.$assign_T$C$P(/*KEEP_STR*/"read_only");
          break;
         case OCLImage1dWO:
          PrevAccessQual.$assign_T$C$P(/*KEEP_STR*/"write_only");
          break;
         case OCLImage1dArrayWO:
          PrevAccessQual.$assign_T$C$P(/*KEEP_STR*/"write_only");
          break;
         case OCLImage1dBufferWO:
          PrevAccessQual.$assign_T$C$P(/*KEEP_STR*/"write_only");
          break;
         case OCLImage2dWO:
          PrevAccessQual.$assign_T$C$P(/*KEEP_STR*/"write_only");
          break;
         case OCLImage2dArrayWO:
          PrevAccessQual.$assign_T$C$P(/*KEEP_STR*/"write_only");
          break;
         case OCLImage2dDepthWO:
          PrevAccessQual.$assign_T$C$P(/*KEEP_STR*/"write_only");
          break;
         case OCLImage2dArrayDepthWO:
          PrevAccessQual.$assign_T$C$P(/*KEEP_STR*/"write_only");
          break;
         case OCLImage2dMSAAWO:
          PrevAccessQual.$assign_T$C$P(/*KEEP_STR*/"write_only");
          break;
         case OCLImage2dArrayMSAAWO:
          PrevAccessQual.$assign_T$C$P(/*KEEP_STR*/"write_only");
          break;
         case OCLImage2dMSAADepthWO:
          PrevAccessQual.$assign_T$C$P(/*KEEP_STR*/"write_only");
          break;
         case OCLImage2dArrayMSAADepthWO:
          PrevAccessQual.$assign_T$C$P(/*KEEP_STR*/"write_only");
          break;
         case OCLImage3dWO:
          PrevAccessQual.$assign_T$C$P(/*KEEP_STR*/"write_only");
          break;
         case OCLImage1dRW:
          PrevAccessQual.$assign_T$C$P(/*KEEP_STR*/"read_write");
          break;
         case OCLImage1dArrayRW:
          PrevAccessQual.$assign_T$C$P(/*KEEP_STR*/"read_write");
          break;
         case OCLImage1dBufferRW:
          PrevAccessQual.$assign_T$C$P(/*KEEP_STR*/"read_write");
          break;
         case OCLImage2dRW:
          PrevAccessQual.$assign_T$C$P(/*KEEP_STR*/"read_write");
          break;
         case OCLImage2dArrayRW:
          PrevAccessQual.$assign_T$C$P(/*KEEP_STR*/"read_write");
          break;
         case OCLImage2dDepthRW:
          PrevAccessQual.$assign_T$C$P(/*KEEP_STR*/"read_write");
          break;
         case OCLImage2dArrayDepthRW:
          PrevAccessQual.$assign_T$C$P(/*KEEP_STR*/"read_write");
          break;
         case OCLImage2dMSAARW:
          PrevAccessQual.$assign_T$C$P(/*KEEP_STR*/"read_write");
          break;
         case OCLImage2dArrayMSAARW:
          PrevAccessQual.$assign_T$C$P(/*KEEP_STR*/"read_write");
          break;
         case OCLImage2dMSAADepthRW:
          PrevAccessQual.$assign_T$C$P(/*KEEP_STR*/"read_write");
          break;
         case OCLImage2dArrayMSAADepthRW:
          PrevAccessQual.$assign_T$C$P(/*KEEP_STR*/"read_write");
          break;
         case OCLImage3dRW:
          PrevAccessQual.$assign_T$C$P(/*KEEP_STR*/"read_write");
          break;
         default:
          assert (false) : "Unable to find corresponding image type.";
        }
        
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(TypedefTy.getDecl().getLocStart(), 
                diag.note_opencl_typedef_access_qualifier)), PrevAccessQual));
      } finally {
        $c$.$destroy();
      }
    }
  }
}


/// Locks in the inheritance model for the given class and all of its bases.
//<editor-fold defaultstate="collapsed" desc="assignInheritanceModel">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 6900,
 FQN="assignInheritanceModel", NM="_ZL22assignInheritanceModelRN5clang4SemaEPNS_13CXXRecordDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZL22assignInheritanceModelRN5clang4SemaEPNS_13CXXRecordDeclE")
//</editor-fold>
public static void assignInheritanceModel(final Sema /*&*/ S, CXXRecordDecl /*P*/ RD) {
  RD = RD.getMostRecentDecl();
  if (!RD.hasAttr(MSInheritanceAttr.class)) {
    MSInheritanceAttr.Spelling IM = null;
    switch (S.MSPointerToMemberRepresentationMethod) {
     case PPTMK_BestCase:
      IM = RD.calculateInheritanceModel();
      break;
     case PPTMK_FullGeneralitySingleInheritance:
      IM = MSInheritanceAttr.Spelling.Keyword_single_inheritance;
      break;
     case PPTMK_FullGeneralityMultipleInheritance:
      IM = MSInheritanceAttr.Spelling.Keyword_multiple_inheritance;
      break;
     case PPTMK_FullGeneralityVirtualInheritance:
      IM = MSInheritanceAttr.Spelling.Keyword_unspecified_inheritance;
      break;
    }
    
    RD.addAttr(MSInheritanceAttr.CreateImplicit(S.getASTContext(), IM, 
            /*BestCase=*/ S.MSPointerToMemberRepresentationMethod
               == LangOptions.PragmaMSPointersToMembersKind.PPTMK_BestCase, 
            S.ImplicitMSInheritanceAttrLoc.isValid() ? new SourceRange(/*NO_COPY*/S.ImplicitMSInheritanceAttrLoc) : RD.getSourceRange()));
    S.Consumer.AssignInheritanceModel(RD);
  }
}


/// \brief Get diagnostic %select index for tag kind for
/// literal type diagnostic message.
/// WARNING: Indexes apply to particular diagnostics only!
///
/// \returns diagnostic %select index.
//<editor-fold defaultstate="collapsed" desc="getLiteralDiagFromTagKind">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 7103,
 FQN="getLiteralDiagFromTagKind", NM="_ZL25getLiteralDiagFromTagKindN5clang11TagTypeKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZL25getLiteralDiagFromTagKindN5clang11TagTypeKindE")
//</editor-fold>
public static /*uint*/int getLiteralDiagFromTagKind(TagTypeKind Tag) {
  switch (Tag) {
   case TTK_Struct:
    return 0;
   case TTK_Interface:
    return 1;
   case TTK_Class:
    return 2;
   default:
    throw new llvm_unreachable("Invalid tag kind for literal type diagnostic!");
  }
}


/// getDecltypeForExpr - Given an expr, will return the decltype for
/// that expression, according to the rules in C++11
/// [dcl.type.simple]p4 and C++11 [expr.lambda.prim]p18.
//<editor-fold defaultstate="collapsed" desc="getDecltypeForExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp", line = 7246,
 FQN="getDecltypeForExpr", NM="_ZL18getDecltypeForExprRN5clang4SemaEPNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaType.cpp -nm=_ZL18getDecltypeForExprRN5clang4SemaEPNS_4ExprE")
//</editor-fold>
public static QualType getDecltypeForExpr(final Sema /*&*/ S, Expr /*P*/ E) {
  if (E.isTypeDependent()) {
    return S.Context.DependentTy.$QualType();
  }
  {
    
    // C++11 [dcl.type.simple]p4:
    //   The type denoted by decltype(e) is defined as follows:
    //
    //     - if e is an unparenthesized id-expression or an unparenthesized class
    //       member access (5.2.5), decltype(e) is the type of the entity named
    //       by e. If there is no such entity, or if e names a set of overloaded
    //       functions, the program is ill-formed;
    //
    // We apply the same rules for Objective-C ivar and property references.
    /*const*/ DeclRefExpr /*P*/ DRE = dyn_cast_DeclRefExpr(E);
    if ((DRE != null)) {
      {
        /*const*/ ValueDecl /*P*/ VD = dyn_cast_ValueDecl(DRE.getDecl$Const());
        if ((VD != null)) {
          return VD.getType();
        }
      }
    } else {
      /*const*/ MemberExpr /*P*/ ME = dyn_cast_MemberExpr(E);
      if ((ME != null)) {
        {
          /*const*/ FieldDecl /*P*/ FD = dyn_cast_FieldDecl(ME.getMemberDecl());
          if ((FD != null)) {
            return FD.getType();
          }
        }
      } else {
        /*const*/ ObjCIvarRefExpr /*P*/ IR = dyn_cast_ObjCIvarRefExpr(E);
        if ((IR != null)) {
          return IR.getDecl$Const().getType();
        } else {
          /*const*/ ObjCPropertyRefExpr /*P*/ PR = dyn_cast_ObjCPropertyRefExpr(E);
          if ((PR != null)) {
            if (PR.isExplicitProperty()) {
              return PR.getExplicitProperty().getType();
            }
          } else {
            PredefinedExpr /*P*/ PE = dyn_cast_PredefinedExpr(E);
            if ((PE != null)) {
              return PE.getType();
            }
          }
        }
      }
    }
  }
  
  // C++11 [expr.lambda.prim]p18:
  //   Every occurrence of decltype((x)) where x is a possibly
  //   parenthesized id-expression that names an entity of automatic
  //   storage duration is treated as if x were transformed into an
  //   access to a corresponding data member of the closure type that
  //   would have been declared if x were an odr-use of the denoted
  //   entity.
  //JAVA: using namespace sema;
  if ((S.getCurLambda() != null)) {
    if (isa_ParenExpr(E)) {
      {
        DeclRefExpr /*P*/ DRE = dyn_cast_DeclRefExpr(E.IgnoreParens());
        if ((DRE != null)) {
          {
            VarDecl /*P*/ Var = dyn_cast_VarDecl(DRE.getDecl());
            if ((Var != null)) {
              QualType T = S.getCapturedDeclRefType(Var, DRE.getLocation());
              if (!T.isNull()) {
                return S.Context.getLValueReferenceType(new QualType(T));
              }
            }
          }
        }
      }
    }
  }
  
  // C++11 [dcl.type.simple]p4:
  //   [...]
  QualType T = E.getType();
  switch (E.getValueKind()) {
   case VK_XValue:
    //     - otherwise, if e is an xvalue, decltype(e) is T&&, where T is the
    //       type of e;
    T.$assignMove(S.Context.getRValueReferenceType(new QualType(T)));
    break;
   case VK_LValue:
    //     - otherwise, if e is an lvalue, decltype(e) is T&, where T is the
    //       type of e;
    T.$assignMove(S.Context.getLValueReferenceType(new QualType(T)));
    break;
   case VK_RValue:
    //  - otherwise, decltype(e) is the type of e.
    break;
  }
  
  return T;
}

} // END OF class SemaTypeStatics
