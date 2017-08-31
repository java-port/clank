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

import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.lex.*;
import org.clang.sema.*;
import static org.clang.sema.Sema_NestedClasses.SemaDiagnosticBuilder.*;
import static org.clang.ast.java.AstFunctionPointers.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstAttributesRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type SemaObjCPropertyStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaObjCProperty.cpp -nm=_ZL13OwnershipMask;_ZL16AddPropertyAttrsRN5clang4SemaEPNS_14ObjCMethodDeclEPNS_16ObjCPropertyDeclE;_ZL16getOwnershipRulej;_ZL20LocPropertyAttributeRN5clang10ASTContextEPKcNS_14SourceLocationERS4_;_ZL20checkARCPropertyImplRN5clang4SemaENS_14SourceLocationEPNS_16ObjCPropertyDeclEPNS_12ObjCIvarDeclE;_ZL22getImpliedARCOwnershipN5clang16ObjCPropertyDecl21PropertyAttributeKindENS_8QualTypeE;_ZL26CollectImmediatePropertiesPN5clang17ObjCContainerDeclERN4llvm8DenseMapISt4pairIPNS_14IdentifierInfoEjEPNS_16ObjCPropertyDeclENS2_12DenseMapInfoIS7_EENS2_6detail12DenseMapPairIS7_S9_EEEESG_bb;_ZL26hasWrittenStorageAttributePN5clang16ObjCPropertyDeclENS_21ObjCPropertyQueryKindE;_ZL27checkAtomicPropertyMismatchRN5clang4SemaEPNS_16ObjCPropertyDeclES3_b;_ZL28CheckPropertyAgainstProtocolRN5clang4SemaEPNS_16ObjCPropertyDeclEPNS_16ObjCProtocolDeclERN4llvm15SmallPtrSetImplIS5_EE;_ZL28SuperClassImplementsPropertyPN5clang17ObjCInterfaceDeclEPNS_16ObjCPropertyDeclE;_ZL29DiagnoseUnimplementedAccessorRN5clang4SemaEPNS_17ObjCInterfaceDeclENS_8SelectorEPNS_12ObjCImplDeclEPNS_17ObjCContainerDeclEPNS_16ObjCCategoryDeclEPNS_16ObjCPropertyDeclERN4llvm11SmallPtrSetIPKNS_14ObjCMethodDeclELj8EEE;_ZL30checkPropertyDeclWithOwnershipRN5clang4SemaEPNS_16ObjCPropertyDeclE;_ZL31deducePropertyOwnershipFromTypeRN5clang4SemaENS_8QualTypeE;_ZL31makePropertyAttributesAsWrittenj;_ZL39DiagnosePropertyMismatchDeclInProtocolsRN5clang4SemaENS_14SourceLocationEPNS_17ObjCInterfaceDeclEPNS_16ObjCPropertyDeclE;_ZL40CollectSuperClassPropertyImplementationsPN5clang17ObjCInterfaceDeclERN4llvm8DenseMapISt4pairIPNS_14IdentifierInfoEjEPNS_16ObjCPropertyDeclENS2_12DenseMapInfoIS7_EENS2_6detail12DenseMapPairIS7_S9_EEEE;_ZL46setImpliedPropertyAttributeForReadOnlyPropertyPN5clang16ObjCPropertyDeclEPNS_12ObjCIvarDeclE; -static-type=SemaObjCPropertyStatics -package=org.clang.sema.impl")
//</editor-fold>
public final class SemaObjCPropertyStatics {


//===----------------------------------------------------------------------===//
// Grammar actions.
//===----------------------------------------------------------------------===//

/// getImpliedARCOwnership - Given a set of property attributes and a
/// type, infer an expected lifetime.  The type's ownership qualification
/// is not considered.
///
/// Returns OCL_None if the attributes as stated do not imply an ownership.
/// Never returns OCL_Autoreleasing.
//<editor-fold defaultstate="collapsed" desc="getImpliedARCOwnership">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaObjCProperty.cpp", line = 39,
 FQN="getImpliedARCOwnership", NM="_ZL22getImpliedARCOwnershipN5clang16ObjCPropertyDecl21PropertyAttributeKindENS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaObjCProperty.cpp -nm=_ZL22getImpliedARCOwnershipN5clang16ObjCPropertyDecl21PropertyAttributeKindENS_8QualTypeE")
//</editor-fold>
public static Qualifiers.ObjCLifetime getImpliedARCOwnership(/*ObjCPropertyDecl::PropertyAttributeKind*//*uint*/int attrs, 
                      QualType type) {
  // retain, strong, copy, weak, and unsafe_unretained are only legal
  // on properties of retainable pointer type.
  if (((attrs & (ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_retain
     | ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_strong
     | ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_copy)) != 0)) {
    return Qualifiers.ObjCLifetime.OCL_Strong;
  } else if (((attrs & ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_weak) != 0)) {
    return Qualifiers.ObjCLifetime.OCL_Weak;
  } else if (((attrs & ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_unsafe_unretained) != 0)) {
    return Qualifiers.ObjCLifetime.OCL_ExplicitNone;
  }
  
  // assign can appear on other types, so we have to check the
  // property type.
  if (((attrs & ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_assign) != 0)
     && type.$arrow().isObjCRetainableType()) {
    return Qualifiers.ObjCLifetime.OCL_ExplicitNone;
  }
  
  return Qualifiers.ObjCLifetime.OCL_None;
}


/// Check the internal consistency of a property declaration with
/// an explicit ownership qualifier.
//<editor-fold defaultstate="collapsed" desc="checkPropertyDeclWithOwnership">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaObjCProperty.cpp", line = 66,
 FQN="checkPropertyDeclWithOwnership", NM="_ZL30checkPropertyDeclWithOwnershipRN5clang4SemaEPNS_16ObjCPropertyDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaObjCProperty.cpp -nm=_ZL30checkPropertyDeclWithOwnershipRN5clang4SemaEPNS_16ObjCPropertyDeclE")
//</editor-fold>
public static void checkPropertyDeclWithOwnership(final Sema /*&*/ S, 
                              ObjCPropertyDecl /*P*/ property) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    if (property.isInvalidDecl()) {
      return;
    }
    
    /*ObjCPropertyDecl::PropertyAttributeKind*//*uint*/int propertyKind = property.getPropertyAttributes();
    Qualifiers.ObjCLifetime propertyLifetime = property.getType().getObjCLifetime();
    assert (propertyLifetime != Qualifiers.ObjCLifetime.OCL_None);
    
    Qualifiers.ObjCLifetime expectedLifetime = getImpliedARCOwnership(propertyKind, property.getType());
    if (!(expectedLifetime.getValue() != 0)) {
      // We have a lifetime qualifier but no dominating property
      // attribute.  That's okay, but restore reasonable invariants by
      // setting the property attribute according to the lifetime
      // qualifier.
      /*ObjCPropertyDecl::PropertyAttributeKind*//*uint*/int attr;
      if (propertyLifetime == Qualifiers.ObjCLifetime.OCL_Strong) {
        attr = ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_strong;
      } else if (propertyLifetime == Qualifiers.ObjCLifetime.OCL_Weak) {
        attr = ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_weak;
      } else {
        assert (propertyLifetime == Qualifiers.ObjCLifetime.OCL_ExplicitNone);
        attr = ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_unsafe_unretained;
      }
      property.setPropertyAttributes(attr);
      return;
    }
    if (propertyLifetime == expectedLifetime) {
      return;
    }
    
    property.setInvalidDecl();
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(property.getLocation(), 
                    diag.err_arc_inconsistent_property_ownership)), 
                property.getDeclName()), 
            expectedLifetime), 
        propertyLifetime));
  } finally {
    $c$.$destroy();
  }
}


/// \brief Check this Objective-C property against a property declared in the
/// given protocol.
//<editor-fold defaultstate="collapsed" desc="CheckPropertyAgainstProtocol">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaObjCProperty.cpp", line = 109,
 FQN="CheckPropertyAgainstProtocol", NM="_ZL28CheckPropertyAgainstProtocolRN5clang4SemaEPNS_16ObjCPropertyDeclEPNS_16ObjCProtocolDeclERN4llvm15SmallPtrSetImplIS5_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaObjCProperty.cpp -nm=_ZL28CheckPropertyAgainstProtocolRN5clang4SemaEPNS_16ObjCPropertyDeclEPNS_16ObjCProtocolDeclERN4llvm15SmallPtrSetImplIS5_EE")
//</editor-fold>
public static void CheckPropertyAgainstProtocol(final Sema /*&*/ S, ObjCPropertyDecl /*P*/ Prop, 
                            ObjCProtocolDecl /*P*/ Proto, 
                            final SmallPtrSetImpl<ObjCProtocolDecl /*P*/ > /*&*/ Known) {
  // Have we seen this protocol before?
  if (!Known.insert(Proto).second) {
    return;
  }
  
  // Look for a property with the same name.
  DeclContextLookupResult R = Proto.lookup(Prop.getDeclName());
  for (/*uint*/int I = 0, N = R.size(); I != N; ++I) {
    {
      ObjCPropertyDecl /*P*/ ProtoProp = dyn_cast_ObjCPropertyDecl(R.$at(I));
      if ((ProtoProp != null)) {
        S.DiagnosePropertyMismatch(Prop, ProtoProp, Proto.getIdentifier(), true);
        return;
      }
    }
  }
  
  // Check this property against any protocols we inherit.
  for (ObjCProtocolDecl /*P*/ P : Proto.protocols())  {
    CheckPropertyAgainstProtocol(S, Prop, P, Known);
  }
}

//<editor-fold defaultstate="collapsed" desc="deducePropertyOwnershipFromType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaObjCProperty.cpp", line = 131,
 FQN="deducePropertyOwnershipFromType", NM="_ZL31deducePropertyOwnershipFromTypeRN5clang4SemaENS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaObjCProperty.cpp -nm=_ZL31deducePropertyOwnershipFromTypeRN5clang4SemaENS_8QualTypeE")
//</editor-fold>
public static /*uint*/int deducePropertyOwnershipFromType(final Sema /*&*/ S, QualType T) {
  // In GC mode, just look for the __weak qualifier.
  if (S.getLangOpts().getGC() != LangOptions.GCMode.NonGC) {
    if (T.isObjCGCWeak()) {
      return ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_weak;
    }
    // In ARC/MRC, look for an explicit ownership qualifier.
    // For some reason, this only applies to __weak.
  } else {
    Qualifiers.ObjCLifetime ownership = T.getObjCLifetime();
    if ((ownership.getValue() != 0)) {
      switch (ownership) {
       case OCL_Weak:
        return ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_weak;
       case OCL_Strong:
        return ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_strong;
       case OCL_ExplicitNone:
        return ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_unsafe_unretained;
       case OCL_Autoreleasing:
       case OCL_None:
        return 0;
      }
      throw new llvm_unreachable("bad qualifier");
    }
  }
  
  return 0;
}

//<editor-fold defaultstate="collapsed" desc="OwnershipMask">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaObjCProperty.cpp", line = 156,
 FQN="OwnershipMask", NM="_ZL13OwnershipMask",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaObjCProperty.cpp -nm=_ZL13OwnershipMask")
//</editor-fold>
public static /*const*//*uint*/int OwnershipMask = (ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_assign
   | ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_retain
   | ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_copy
   | ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_weak
   | ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_strong
   | ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_unsafe_unretained);
//<editor-fold defaultstate="collapsed" desc="getOwnershipRule">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaObjCProperty.cpp", line = 164,
 FQN="getOwnershipRule", NM="_ZL16getOwnershipRulej",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaObjCProperty.cpp -nm=_ZL16getOwnershipRulej")
//</editor-fold>
public static /*uint*/int getOwnershipRule(/*uint*/int attr) {
  /*uint*/int result = attr & OwnershipMask;
  
  // From an ownership perspective, assign and unsafe_unretained are
  // identical; make sure one also implies the other.
  if (((result & (ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_assign
     | ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_unsafe_unretained)) != 0)) {
    result |= ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_assign
       | ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_unsafe_unretained;
  }
  
  return result;
}

//<editor-fold defaultstate="collapsed" desc="makePropertyAttributesAsWritten">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaObjCProperty.cpp", line = 279,
 FQN="makePropertyAttributesAsWritten", NM="_ZL31makePropertyAttributesAsWrittenj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaObjCProperty.cpp -nm=_ZL31makePropertyAttributesAsWrittenj")
//</editor-fold>
public static /*ObjCPropertyDecl::PropertyAttributeKind*//*uint*/int makePropertyAttributesAsWritten(/*uint*/int Attributes) {
  /*uint*/int attributesAsWritten = 0;
  if (((Attributes & ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_readonly) != 0)) {
    attributesAsWritten |= ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_readonly;
  }
  if (((Attributes & ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_readwrite) != 0)) {
    attributesAsWritten |= ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_readwrite;
  }
  if (((Attributes & ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_getter) != 0)) {
    attributesAsWritten |= ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_getter;
  }
  if (((Attributes & ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_setter) != 0)) {
    attributesAsWritten |= ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_setter;
  }
  if (((Attributes & ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_assign) != 0)) {
    attributesAsWritten |= ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_assign;
  }
  if (((Attributes & ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_retain) != 0)) {
    attributesAsWritten |= ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_retain;
  }
  if (((Attributes & ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_strong) != 0)) {
    attributesAsWritten |= ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_strong;
  }
  if (((Attributes & ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_weak) != 0)) {
    attributesAsWritten |= ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_weak;
  }
  if (((Attributes & ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_copy) != 0)) {
    attributesAsWritten |= ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_copy;
  }
  if (((Attributes & ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_unsafe_unretained) != 0)) {
    attributesAsWritten |= ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_unsafe_unretained;
  }
  if (((Attributes & ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_nonatomic) != 0)) {
    attributesAsWritten |= ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_nonatomic;
  }
  if (((Attributes & ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_atomic) != 0)) {
    attributesAsWritten |= ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_atomic;
  }
  if (((Attributes & ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_class) != 0)) {
    attributesAsWritten |= ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_class;
  }
  
  return (/*ObjCPropertyDecl::PropertyAttributeKind*//*uint*/int)attributesAsWritten;
}

//<editor-fold defaultstate="collapsed" desc="LocPropertyAttribute">
@Converted(kind = Converted.Kind.MANUAL,
 optimized = Converted.Optimization.VALUE_TYPE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaObjCProperty.cpp", line = 312,
 FQN="LocPropertyAttribute", NM="_ZL20LocPropertyAttributeRN5clang10ASTContextEPKcNS_14SourceLocationERS4_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaObjCProperty.cpp -nm=_ZL20LocPropertyAttributeRN5clang10ASTContextEPKcNS_14SourceLocationERS4_")
//</editor-fold>
public static boolean LocPropertyAttribute(final ASTContext /*&*/ Context, /*const*/char$ptr/*char P*/ attrName, 
                    SourceLocation LParenLoc, final SourceLocation /*&*/ Loc) {
  Lexer lexer = null;
  try {
    if (LParenLoc.isMacroID()) {
      return false;
    }
    
    final SourceManager /*&*/ SM = Context.getSourceManager();
    std.pairTypeUInt<FileID> locInfo = SM.getDecomposedLoc(/*NO_COPY*/LParenLoc);
    // Try to load the file buffer.
    // JAVA: use return marker vs creation of new bool$ptr
    final bool$ptr invalidTemp = null; // create_bool$ptr(false);
    StringRef file = SM.getBufferData(/*NO_COPY*/locInfo.first, /*$AddrOf*/(invalidTemp));
//    if (invalidTemp.$star()) {
//      return false;
//    }
    if (file == SourceManager.INVALID_BUFFER_DATA) {
      return false;
    }
    /*const*/char$ptr/*char P*/ tokenBegin = $tryClone(file.data().$add(locInfo.second));
    
    // Lex from the start of the given location.
    lexer/*J*/= new Lexer(SM.getLocForStartOfFile(/*NO_COPY*/locInfo.first), 
        Context.getLangOpts(), 
        file.begin(), tokenBegin, file.end());
    Token Tok/*J*/= new Token();
    do {
      lexer.LexFromRawLexer(Tok);
      if (Tok.is(tok.TokenKind.raw_identifier) && $eq_StringRef(Tok.getRawIdentifier(), /*STRINGREF_STR*/attrName)) {
        Loc.$assignMove(Tok.getLocation());
        return true;
      }
    } while (Tok.isNot(tok.TokenKind.r_paren));
    return false;
  } finally {
    if (lexer != null) { lexer.$destroy(); }
  }
}


/// Check for a mismatch in the atomicity of the given properties.
//<editor-fold defaultstate="collapsed" desc="checkAtomicPropertyMismatch">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaObjCProperty.cpp", line = 342,
 FQN="checkAtomicPropertyMismatch", NM="_ZL27checkAtomicPropertyMismatchRN5clang4SemaEPNS_16ObjCPropertyDeclES3_b",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaObjCProperty.cpp -nm=_ZL27checkAtomicPropertyMismatchRN5clang4SemaEPNS_16ObjCPropertyDeclES3_b")
//</editor-fold>
public static void checkAtomicPropertyMismatch(final Sema /*&*/ S, 
                           ObjCPropertyDecl /*P*/ OldProperty, 
                           ObjCPropertyDecl /*P*/ NewProperty, 
                           boolean PropagateAtomicity) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    // If the atomicity of both matches, we're done.
    boolean OldIsAtomic = (OldProperty.getPropertyAttributes() & ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_nonatomic)
       == 0;
    boolean NewIsAtomic = (NewProperty.getPropertyAttributes() & ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_nonatomic)
       == 0;
    if (OldIsAtomic == NewIsAtomic) {
      return;
    }
    
    // Determine whether the given property is readonly and implicitly
    // atomic.
    ObjCPropertyDecl2Bool isImplicitlyReadonlyAtomic = /*[]*/ (ObjCPropertyDecl /*P*/ Property) -> {
          // Is it readonly?
          /*PropertyAttributeKind*//*uint*/int Attrs = Property.getPropertyAttributes();
          if ((Attrs & ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_readonly) == 0) {
            return false;
          }
          
          // Is it nonatomic?
          if (((Attrs & ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_nonatomic) != 0)) {
            return false;
          }
          
          // Was 'atomic' specified directly?
          if (((Property.getPropertyAttributesAsWritten()
             & ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_atomic) != 0)) {
            return false;
          }
          
          return true;
        };
    
    // If we're allowed to propagate atomicity, and the new property did
    // not specify atomicity at all, propagate.
    /*const*//*uint*/int AtomicityMask = (ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_atomic | ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_nonatomic);
    if (PropagateAtomicity
       && ((NewProperty.getPropertyAttributesAsWritten() & AtomicityMask) == 0)) {
      /*uint*/int Attrs = NewProperty.getPropertyAttributes();
      Attrs = Attrs & ~AtomicityMask;
      if (OldIsAtomic) {
        Attrs |= ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_atomic;
      } else {
        Attrs |= ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_nonatomic;
      }
      
      NewProperty.overwritePropertyAttributes(Attrs);
      return;
    }
    
    // One of the properties is atomic; if it's a readonly property, and
    // 'atomic' wasn't explicitly specified, we're okay.
    if ((OldIsAtomic && isImplicitlyReadonlyAtomic.$call(OldProperty))
       || (NewIsAtomic && isImplicitlyReadonlyAtomic.$call(NewProperty))) {
      return;
    }
    
    // Diagnose the conflict.
    /*const*/ IdentifierInfo /*P*/ OldContextName;
    DeclContext /*P*/ OldDC = OldProperty.getDeclContext();
    {
      ObjCCategoryDecl /*P*/ Category = dyn_cast_ObjCCategoryDecl(OldDC);
      if ((Category != null)) {
        OldContextName = Category.getClassInterface().getIdentifier();
      } else {
        OldContextName = cast_ObjCContainerDecl(OldDC).getIdentifier();
      }
    }
    
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(NewProperty.getLocation(), diag.warn_property_attribute)), 
                NewProperty.getDeclName()), /*KEEP_STR*/"atomic"), 
        OldContextName));
    $c$.clean($c$.track(S.Diag(OldProperty.getLocation(), diag.note_property_declare)));
  } finally {
    $c$.$destroy();
  }
}

//<editor-fold defaultstate="collapsed" desc="checkARCPropertyImpl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaObjCProperty.cpp", line = 707,
 FQN="checkARCPropertyImpl", NM="_ZL20checkARCPropertyImplRN5clang4SemaENS_14SourceLocationEPNS_16ObjCPropertyDeclEPNS_12ObjCIvarDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaObjCProperty.cpp -nm=_ZL20checkARCPropertyImplRN5clang4SemaENS_14SourceLocationEPNS_16ObjCPropertyDeclEPNS_12ObjCIvarDeclE")
//</editor-fold>
public static void checkARCPropertyImpl(final Sema /*&*/ S, SourceLocation propertyImplLoc, 
                    ObjCPropertyDecl /*P*/ property, 
                    ObjCIvarDecl /*P*/ ivar) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    if (property.isInvalidDecl() || ivar.isInvalidDecl()) {
      return;
    }
    
    QualType ivarType = ivar.getType();
    Qualifiers.ObjCLifetime ivarLifetime = ivarType.getObjCLifetime();
    
    // The lifetime implied by the property's attributes.
    Qualifiers.ObjCLifetime propertyLifetime = getImpliedARCOwnership(property.getPropertyAttributes(), 
        property.getType());
    
    // We're fine if they match.
    if (propertyLifetime == ivarLifetime) {
      return;
    }
    
    // None isn't a valid lifetime for an object ivar in ARC, and
    // __autoreleasing is never valid; don't diagnose twice.
    if ((ivarLifetime == Qualifiers.ObjCLifetime.OCL_None
       && S.getLangOpts().ObjCAutoRefCount)
       || ivarLifetime == Qualifiers.ObjCLifetime.OCL_Autoreleasing) {
      return;
    }
    
    // If the ivar is private, and it's implicitly __unsafe_unretained
    // becaues of its type, then pretend it was actually implicitly
    // __strong.  This is only sound because we're processing the
    // property implementation before parsing any method bodies.
    if (ivarLifetime == Qualifiers.ObjCLifetime.OCL_ExplicitNone
       && propertyLifetime == Qualifiers.ObjCLifetime.OCL_Strong
       && ivar.getAccessControl() == ObjCIvarDecl.AccessControl.Private) {
      SplitQualType split = ivarType.split();
      if (split.Quals.hasObjCLifetime()) {
        assert (ivarType.$arrow().isObjCARCImplicitlyUnretainedType());
        split.Quals.setObjCLifetime(Qualifiers.ObjCLifetime.OCL_Strong);
        ivarType.$assignMove(S.Context.getQualifiedType(new SplitQualType(split)));
        ivar.setType(new QualType(ivarType));
        return;
      }
    }
    switch (propertyLifetime) {
     case OCL_Strong:
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(ivar.getLocation(), diag.err_arc_strong_property_ownership)), 
                  property.getDeclName()), 
              ivar.getDeclName()), 
          ivarLifetime));
      break;
     case OCL_Weak:
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(ivar.getLocation(), diag.error_weak_property)), 
              property.getDeclName()), 
          ivar.getDeclName()));
      break;
     case OCL_ExplicitNone:
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(ivar.getLocation(), diag.err_arc_assign_property_ownership)), 
                  property.getDeclName()), 
              ivar.getDeclName()), 
          ((property.getPropertyAttributesAsWritten()
             & ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_assign) != 0)));
      break;
     case OCL_Autoreleasing:
      throw new llvm_unreachable("properties cannot be autoreleasing");
     case OCL_None:
      // Any other property should be ignored.
      return;
    }
    
    $c$.clean($c$.track(S.Diag(property.getLocation(), diag.note_property_declare)));
    if (propertyImplLoc.isValid()) {
      $c$.clean($c$.track(S.Diag(new SourceLocation(propertyImplLoc), diag.note_property_synthesize)));
    }
  } finally {
    $c$.$destroy();
  }
}


/// setImpliedPropertyAttributeForReadOnlyProperty -
/// This routine evaludates life-time attributes for a 'readonly'
/// property with no known lifetime of its own, using backing
/// 'ivar's attribute, if any. If no backing 'ivar', property's
/// life-time is assumed 'strong'.
//<editor-fold defaultstate="collapsed" desc="setImpliedPropertyAttributeForReadOnlyProperty">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaObjCProperty.cpp", line = 787,
 FQN="setImpliedPropertyAttributeForReadOnlyProperty", NM="_ZL46setImpliedPropertyAttributeForReadOnlyPropertyPN5clang16ObjCPropertyDeclEPNS_12ObjCIvarDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaObjCProperty.cpp -nm=_ZL46setImpliedPropertyAttributeForReadOnlyPropertyPN5clang16ObjCPropertyDeclEPNS_12ObjCIvarDeclE")
//</editor-fold>
public static void setImpliedPropertyAttributeForReadOnlyProperty(ObjCPropertyDecl /*P*/ property, ObjCIvarDecl /*P*/ ivar) {
  Qualifiers.ObjCLifetime propertyLifetime = getImpliedARCOwnership(property.getPropertyAttributes(), 
      property.getType());
  if (propertyLifetime != Qualifiers.ObjCLifetime.OCL_None) {
    return;
  }
  if (!(ivar != null)) {
    // if no backing ivar, make property 'strong'.
    property.setPropertyAttributes(ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_strong);
    return;
  }
  // property assumes owenership of backing ivar.
  QualType ivarType = ivar.getType();
  Qualifiers.ObjCLifetime ivarLifetime = ivarType.getObjCLifetime();
  if (ivarLifetime == Qualifiers.ObjCLifetime.OCL_Strong) {
    property.setPropertyAttributes(ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_strong);
  } else if (ivarLifetime == Qualifiers.ObjCLifetime.OCL_Weak) {
    property.setPropertyAttributes(ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_weak);
  }
}


/// DiagnosePropertyMismatchDeclInProtocols - diagnose properties declared
/// in inherited protocols with mismatched types. Since any of them can
/// be candidate for synthesis.
//<editor-fold defaultstate="collapsed" desc="DiagnosePropertyMismatchDeclInProtocols">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaObjCProperty.cpp", line = 812,
 FQN="DiagnosePropertyMismatchDeclInProtocols", NM="_ZL39DiagnosePropertyMismatchDeclInProtocolsRN5clang4SemaENS_14SourceLocationEPNS_17ObjCInterfaceDeclEPNS_16ObjCPropertyDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaObjCProperty.cpp -nm=_ZL39DiagnosePropertyMismatchDeclInProtocolsRN5clang4SemaENS_14SourceLocationEPNS_17ObjCInterfaceDeclEPNS_16ObjCPropertyDeclE")
//</editor-fold>
public static void DiagnosePropertyMismatchDeclInProtocols(final Sema /*&*/ S, SourceLocation AtLoc, 
                                       ObjCInterfaceDecl /*P*/ ClassDecl, 
                                       ObjCPropertyDecl /*P*/ Property) {
  DenseMap</*const*/ ObjCProtocolDecl /*P*/ , ObjCPropertyDecl /*P*/ > PropMap/*J*/= new DenseMap</*const*/ ObjCProtocolDecl /*P*/ , ObjCPropertyDecl /*P*/ >(DenseMapInfo$LikePtr.$Info(), (ObjCPropertyDecl /*P*/ )null);
  for (/*const*/ ObjCProtocolDecl /*P*/ PI : ClassDecl.all_referenced_protocols()) {
    {
      /*const*/ ObjCProtocolDecl /*P*/ PDecl = PI.getDefinition$Const();
      if ((PDecl != null)) {
        PDecl.collectInheritedProtocolProperties(Property, PropMap);
      }
    }
  }
  {
    ObjCInterfaceDecl /*P*/ SDecl = ClassDecl.getSuperClass();
    if ((SDecl != null)) {
      while ((SDecl != null)) {
        for (/*const*/ ObjCProtocolDecl /*P*/ PI : SDecl.all_referenced_protocols()) {
          {
            /*const*/ ObjCProtocolDecl /*P*/ PDecl = PI.getDefinition$Const();
            if ((PDecl != null)) {
              PDecl.collectInheritedProtocolProperties(Property, PropMap);
            }
          }
        }
        SDecl = SDecl.getSuperClass();
      }
    }
  }
  if (PropMap.empty()) {
    return;
  }
  
  QualType RHSType = S.Context.getCanonicalType(Property.getType()).$QualType();
  boolean FirsTime = true;
  for (DenseMapIterator</*const*/ ObjCProtocolDecl /*P*/ , ObjCPropertyDecl /*P*/ > I = PropMap.begin(), E = PropMap.end(); I.$noteq(/*NO_ITER_COPY*/E); I.$postInc(0)) {
    ObjCPropertyDecl /*P*/ Prop = I.$arrow().second;
    QualType LHSType = S.Context.getCanonicalType(Prop.getType()).$QualType();
    if (!S.Context.propertyTypesAreCompatible(new QualType(LHSType), new QualType(RHSType))) {
      bool$ref IncompatibleObjC = create_bool$ref(false);
      QualType ConvertedType/*J*/= new QualType();
      if (!S.isObjCPointerConversion(new QualType(RHSType), new QualType(LHSType), ConvertedType, IncompatibleObjC)
         || IncompatibleObjC.$deref()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          if (FirsTime) {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Property.getLocation(), diag.warn_protocol_property_mismatch)), 
                Property.getType()));
            FirsTime = false;
          }
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Prop.getLocation(), diag.note_protocol_property_declare)), 
              Prop.getType()));
        } finally {
          $c$.$destroy();
        }
      }
    }
  }
  if (!FirsTime && AtLoc.isValid()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track(S.Diag(new SourceLocation(AtLoc), diag.note_property_synthesize)));
    } finally {
      $c$.$destroy();
    }
  }
}


/// Determine whether any storage attributes were written on the property.
//<editor-fold defaultstate="collapsed" desc="hasWrittenStorageAttribute">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaObjCProperty.cpp", line = 859,
 FQN="hasWrittenStorageAttribute", NM="_ZL26hasWrittenStorageAttributePN5clang16ObjCPropertyDeclENS_21ObjCPropertyQueryKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaObjCProperty.cpp -nm=_ZL26hasWrittenStorageAttributePN5clang16ObjCPropertyDeclENS_21ObjCPropertyQueryKindE")
//</editor-fold>
public static boolean hasWrittenStorageAttribute(ObjCPropertyDecl /*P*/ Prop, 
                          /*ObjCPropertyQueryKind*/byte/*uint8_t*/ QueryKind) {
  if (((Prop.getPropertyAttributesAsWritten() & OwnershipMask) != 0)) {
    return true;
  }
  
  // If this is a readwrite property in a class extension that refines
  // a readonly property in the original class definition, check it as
  // well.
  
  // If it's a readonly property, we're not interested.
  if (Prop.isReadOnly()) {
    return false;
  }
  
  // Is it declared in an extension?
  ObjCCategoryDecl /*P*/ Category = dyn_cast_ObjCCategoryDecl(Prop.getDeclContext());
  if (!(Category != null) || !Category.IsClassExtension()) {
    return false;
  }
  
  // Find the corresponding property in the primary class definition.
  ObjCInterfaceDecl /*P*/ OrigClass = Category.getClassInterface();
  for (NamedDecl /*P*/ Found : OrigClass.lookup(Prop.getDeclName())) {
    {
      ObjCPropertyDecl /*P*/ OrigProp = dyn_cast_ObjCPropertyDecl(Found);
      if ((OrigProp != null)) {
        return ((OrigProp.getPropertyAttributesAsWritten() & OwnershipMask) != 0);
      }
    }
  }
  
  // Look through all of the protocols.
  for (/*const*/ ObjCProtocolDecl /*P*/ Proto : OrigClass.all_referenced_protocols()) {
    {
      ObjCPropertyDecl /*P*/ OrigProp = Proto.FindPropertyDeclaration(Prop.getIdentifier(), QueryKind);
      if ((OrigProp != null)) {
        return ((OrigProp.getPropertyAttributesAsWritten() & OwnershipMask) != 0);
      }
    }
  }
  
  return false;
}


/// CollectImmediateProperties - This routine collects all properties in
/// the class and its conforming protocols; but not those in its super class.
//<editor-fold defaultstate="collapsed" desc="CollectImmediateProperties">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*make_pair*/,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaObjCProperty.cpp", line = 1535,
 FQN="CollectImmediateProperties", NM="_ZL26CollectImmediatePropertiesPN5clang17ObjCContainerDeclERN4llvm8DenseMapISt4pairIPNS_14IdentifierInfoEjEPNS_16ObjCPropertyDeclENS2_12DenseMapInfoIS7_EENS2_6detail12DenseMapPairIS7_S9_EEEESG_bb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaObjCProperty.cpp -nm=_ZL26CollectImmediatePropertiesPN5clang17ObjCContainerDeclERN4llvm8DenseMapISt4pairIPNS_14IdentifierInfoEjEPNS_16ObjCPropertyDeclENS2_12DenseMapInfoIS7_EENS2_6detail12DenseMapPairIS7_S9_EEEESG_bb")
//</editor-fold>
public static void CollectImmediateProperties(ObjCContainerDecl /*P*/ CDecl, 
                          final DenseMap<std.pairTypeUInt<IdentifierInfo /*P*/ >, ObjCPropertyDecl /*P*/ > /*&*/ PropMap, 
                          final DenseMap<std.pairTypeUInt<IdentifierInfo /*P*/ >, ObjCPropertyDecl /*P*/ > /*&*/ SuperPropMap) {
  CollectImmediateProperties(CDecl, 
                          PropMap, 
                          SuperPropMap, 
                          false, 
                          true);
}
public static void CollectImmediateProperties(ObjCContainerDecl /*P*/ CDecl, 
                          final DenseMap<std.pairTypeUInt<IdentifierInfo /*P*/ >, ObjCPropertyDecl /*P*/ > /*&*/ PropMap, 
                          final DenseMap<std.pairTypeUInt<IdentifierInfo /*P*/ >, ObjCPropertyDecl /*P*/ > /*&*/ SuperPropMap, 
                          boolean CollectClassPropsOnly/*= false*/) {
  CollectImmediateProperties(CDecl, 
                          PropMap, 
                          SuperPropMap, 
                          CollectClassPropsOnly, 
                          true);
}
public static void CollectImmediateProperties(ObjCContainerDecl /*P*/ CDecl, 
                          final DenseMap<std.pairTypeUInt<IdentifierInfo /*P*/ >, ObjCPropertyDecl /*P*/ > /*&*/ PropMap, 
                          final DenseMap<std.pairTypeUInt<IdentifierInfo /*P*/ >, ObjCPropertyDecl /*P*/ > /*&*/ SuperPropMap, 
                          boolean CollectClassPropsOnly/*= false*/, 
                          boolean IncludeProtocols/*= true*/) {
  {
    ObjCInterfaceDecl /*P*/ IDecl = dyn_cast_ObjCInterfaceDecl(CDecl);
    if ((IDecl != null)) {
      for (ObjCPropertyDecl /*P*/ Prop : IDecl.properties()) {
        if (CollectClassPropsOnly && !Prop.isClassProperty()) {
          continue;
        }
        PropMap.$set(std.make_pair_Ptr_bool2uint(Prop.getIdentifier(), Prop.isClassProperty()), 
          Prop);
      }
      
      // Collect the properties from visible extensions.
      for (ObjCCategoryDecl /*P*/ Ext : IDecl.visible_extensions())  {
        CollectImmediateProperties(Ext, PropMap, SuperPropMap, 
            CollectClassPropsOnly, IncludeProtocols);
      }
      if (IncludeProtocols) {
        // Scan through class's protocols.
        for (ObjCProtocolDecl /*P*/ PI : IDecl.all_referenced_protocols())  {
          CollectImmediateProperties(PI, PropMap, SuperPropMap, 
              CollectClassPropsOnly);
        }
      }
    }
  }
  {
    ObjCCategoryDecl /*P*/ CATDecl = dyn_cast_ObjCCategoryDecl(CDecl);
    if ((CATDecl != null)) {
      for (ObjCPropertyDecl /*P*/ Prop : CATDecl.properties()) {
        if (CollectClassPropsOnly && !Prop.isClassProperty()) {
          continue;
        }
        PropMap.$set(std.make_pair_Ptr_bool2uint(Prop.getIdentifier(), Prop.isClassProperty()), 
          Prop);
      }
      if (IncludeProtocols) {
        // Scan through class's protocols.
        for (ObjCProtocolDecl /*P*/ PI : CATDecl.protocols())  {
          CollectImmediateProperties(PI, PropMap, SuperPropMap, 
              CollectClassPropsOnly);
        }
      }
    } else {
      ObjCProtocolDecl /*P*/ PDecl = dyn_cast_ObjCProtocolDecl(CDecl);
      if ((PDecl != null)) {
        for (ObjCPropertyDecl /*P*/ Prop : PDecl.properties()) {
          if (CollectClassPropsOnly && !Prop.isClassProperty()) {
            continue;
          }
          ObjCPropertyDecl /*P*/ PropertyFromSuper = SuperPropMap.$at_T1$RR(std.make_pair_Ptr_bool2uint(Prop.getIdentifier(), 
                      Prop.isClassProperty()));
          // Exclude property for protocols which conform to class's super-class, 
          // as super-class has to implement the property.
          if (!(PropertyFromSuper != null)
             || PropertyFromSuper.getIdentifier() != Prop.getIdentifier()) {
            final type$ref<ObjCPropertyDecl /*P*/ /*&*/> PropEntry = PropMap.ref$at(std.make_pair_Ptr_bool2uint(Prop.getIdentifier(), 
                        Prop.isClassProperty()));
            if (!(PropEntry.$deref() != null)) {
              PropEntry.$set(Prop);
            }
          }
        }
        // Scan through protocol's protocols.
        for (ObjCProtocolDecl /*P*/ PI : PDecl.protocols())  {
          CollectImmediateProperties(PI, PropMap, SuperPropMap, 
              CollectClassPropsOnly);
        }
      }
    }
  }
}


/// CollectSuperClassPropertyImplementations - This routine collects list of
/// properties to be implemented in super class(s) and also coming from their
/// conforming protocols.
//<editor-fold defaultstate="collapsed" desc="CollectSuperClassPropertyImplementations">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaObjCProperty.cpp", line = 1603,
 FQN="CollectSuperClassPropertyImplementations", NM="_ZL40CollectSuperClassPropertyImplementationsPN5clang17ObjCInterfaceDeclERN4llvm8DenseMapISt4pairIPNS_14IdentifierInfoEjEPNS_16ObjCPropertyDeclENS2_12DenseMapInfoIS7_EENS2_6detail12DenseMapPairIS7_S9_EEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaObjCProperty.cpp -nm=_ZL40CollectSuperClassPropertyImplementationsPN5clang17ObjCInterfaceDeclERN4llvm8DenseMapISt4pairIPNS_14IdentifierInfoEjEPNS_16ObjCPropertyDeclENS2_12DenseMapInfoIS7_EENS2_6detail12DenseMapPairIS7_S9_EEEE")
//</editor-fold>
public static void CollectSuperClassPropertyImplementations(ObjCInterfaceDecl /*P*/ CDecl, 
                                        final DenseMap<std.pairTypeUInt<IdentifierInfo /*P*/ >, ObjCPropertyDecl /*P*/ > /*&*/ PropMap) {
  {
    ObjCInterfaceDecl /*P*/ SDecl = CDecl.getSuperClass();
    if ((SDecl != null)) {
      SmallVector<ObjCPropertyDecl /*P*/ > PO/*J*/= new SmallVector<ObjCPropertyDecl /*P*/ >(8, (ObjCPropertyDecl /*P*/ )null);
      while ((SDecl != null)) {
        SDecl.collectPropertiesToImplement(PropMap, PO);
        SDecl = SDecl.getSuperClass();
      }
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="SuperClassImplementsProperty">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaObjCProperty.cpp", line = 1646,
 FQN="SuperClassImplementsProperty", NM="_ZL28SuperClassImplementsPropertyPN5clang17ObjCInterfaceDeclEPNS_16ObjCPropertyDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaObjCProperty.cpp -nm=_ZL28SuperClassImplementsPropertyPN5clang17ObjCInterfaceDeclEPNS_16ObjCPropertyDeclE")
//</editor-fold>
public static boolean SuperClassImplementsProperty(ObjCInterfaceDecl /*P*/ IDecl, 
                            ObjCPropertyDecl /*P*/ Prop) {
  boolean SuperClassImplementsGetter = false;
  boolean SuperClassImplementsSetter = false;
  if (((Prop.getPropertyAttributes() & ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_readonly) != 0)) {
    SuperClassImplementsSetter = true;
  }
  while ((IDecl.getSuperClass() != null)) {
    ObjCInterfaceDecl /*P*/ SDecl = IDecl.getSuperClass();
    if (!SuperClassImplementsGetter && (SDecl.getInstanceMethod(Prop.getGetterName()) != null)) {
      SuperClassImplementsGetter = true;
    }
    if (!SuperClassImplementsSetter && (SDecl.getInstanceMethod(Prop.getSetterName()) != null)) {
      SuperClassImplementsSetter = true;
    }
    if (SuperClassImplementsGetter && SuperClassImplementsSetter) {
      return true;
    }
    IDecl = IDecl.getSuperClass();
  }
  return false;
}

//<editor-fold defaultstate="collapsed" desc="DiagnoseUnimplementedAccessor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaObjCProperty.cpp", line = 1768,
 FQN="DiagnoseUnimplementedAccessor", NM="_ZL29DiagnoseUnimplementedAccessorRN5clang4SemaEPNS_17ObjCInterfaceDeclENS_8SelectorEPNS_12ObjCImplDeclEPNS_17ObjCContainerDeclEPNS_16ObjCCategoryDeclEPNS_16ObjCPropertyDeclERN4llvm11SmallPtrSetIPKNS_14ObjCMethodDeclELj8EEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaObjCProperty.cpp -nm=_ZL29DiagnoseUnimplementedAccessorRN5clang4SemaEPNS_17ObjCInterfaceDeclENS_8SelectorEPNS_12ObjCImplDeclEPNS_17ObjCContainerDeclEPNS_16ObjCCategoryDeclEPNS_16ObjCPropertyDeclERN4llvm11SmallPtrSetIPKNS_14ObjCMethodDeclELj8EEE")
//</editor-fold>
public static void DiagnoseUnimplementedAccessor(final Sema /*&*/ S, ObjCInterfaceDecl /*P*/ PrimaryClass, Selector Method, 
                             ObjCImplDecl /*P*/ IMPDecl, ObjCContainerDecl /*P*/ CDecl, ObjCCategoryDecl /*P*/ C, 
                             ObjCPropertyDecl /*P*/ Prop, 
                             final SmallPtrSet</*const*/ ObjCMethodDecl /*P*/ > /*&*/ SMap) {
  // Check to see if we have a corresponding selector in SMap and with the
  // right method type.
  SmallPtrSetIterator</*const*/ ObjCMethodDecl /*P*/ > I = std.find_if(SMap.begin(), SMap.end(), 
      /*[&, &Method, &Prop]*/ (/*const*/ ObjCMethodDecl /*P*/ x) -> {
            return x.getSelector().$eq(/*NO_COPY*/Method)
               && x.isClassMethod() == Prop.isClassProperty();
          });
  // When reporting on missing property setter/getter implementation in
  // categories, do not report when they are declared in primary class,
  // class's protocol, or one of it super classes. This is because,
  // the class is going to implement them.
  if (I.$eq(SMap.end())
     && (PrimaryClass == null
     || !(PrimaryClass.lookupPropertyAccessor(new Selector(Method), C, 
      Prop.isClassProperty()) != null))) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      /*uint*/int _diag = isa_ObjCCategoryDecl(CDecl) ? (Prop.isClassProperty() ? diag.warn_impl_required_in_category_for_class_property : diag.warn_setter_getter_impl_required_in_category) : (Prop.isClassProperty() ? diag.warn_impl_required_for_class_property : diag.warn_setter_getter_impl_required);
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(IMPDecl.getLocation(), _diag)), Prop.getDeclName()), Method));
      $c$.clean($c$.track(S.Diag(Prop.getLocation(), diag.note_property_declare)));
      if (S.LangOpts.ObjCDefaultSynthProperties
         && S.LangOpts.ObjCRuntime.isNonFragile()) {
        {
          ObjCInterfaceDecl /*P*/ ID = dyn_cast_ObjCInterfaceDecl(CDecl);
          if ((ID != null)) {
            {
              /*const*/ ObjCInterfaceDecl /*P*/ RID = ID.isObjCRequiresPropertyDefs();
              if ((RID != null)) {
                $c$.clean($c$.track(S.Diag(RID.getLocation(), diag.note_suppressed_class_declare)));
              }
            }
          }
        }
      }
    } finally {
      $c$.$destroy();
    }
  }
}


/// AddPropertyAttrs - Propagates attributes from a property to the
/// implicitly-declared getter or setter for that property.
//<editor-fold defaultstate="collapsed" desc="AddPropertyAttrs">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaObjCProperty.cpp", line = 2129,
 FQN="AddPropertyAttrs", NM="_ZL16AddPropertyAttrsRN5clang4SemaEPNS_14ObjCMethodDeclEPNS_16ObjCPropertyDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaObjCProperty.cpp -nm=_ZL16AddPropertyAttrsRN5clang4SemaEPNS_14ObjCMethodDeclEPNS_16ObjCPropertyDeclE")
//</editor-fold>
public static void AddPropertyAttrs(final Sema /*&*/ S, ObjCMethodDecl /*P*/ PropertyMethod, 
                ObjCPropertyDecl /*P*/ Property) {
  // Should we just clone all attributes over?
  for (/*const*/ Attr /*P*/ A : Property.attrs()) {
    if (isa_DeprecatedAttr(A)
       || isa_UnavailableAttr(A)
       || isa_AvailabilityAttr(A)) {
      PropertyMethod.addAttr(A.clone(S.Context));
    }
  }
}

} // END OF class SemaObjCPropertyStatics
