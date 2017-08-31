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
package org.clang.sema;

import static org.clank.support.Native.$Deref;
import static org.clank.support.Native.$AddrOf;
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
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.sema.impl.*;
import org.clank.java.stdimpl.aliases.*;
import org.clang.basic.target.*;
import static org.clang.basic.BasicClangGlobals.*;
import static org.clang.sema.Sema.*;
import static org.clang.sema.Sema_NestedClasses.SemaDiagnosticBuilder.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.basic.VersionTuple.*;
import org.clang.sema.DelayedDiagnostic.DDKind;
import static org.clang.sema.impl.SemaDeclAttrStatics.*;
import static org.clang.ast.java.AstAttributesRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type Sema_SemaDeclAttr">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this -extends=Sema_SemaDecl ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZN5clang4Sema11AddModeAttrENS_11SourceRangeEPNS_4DeclEPNS_14IdentifierInfoEjb;_ZN5clang4Sema14AddAlignedAttrENS_11SourceRangeEPNS_4DeclEPNS_14TypeSourceInfoEjb;_ZN5clang4Sema14AddAlignedAttrENS_11SourceRangeEPNS_4DeclEPNS_4ExprEjb;_ZN5clang4Sema15checkTargetAttrENS_14SourceLocationEN4llvm9StringRefE;_ZN5clang4Sema15mergeCommonAttrEPNS_4DeclENS_11SourceRangeEPNS_14IdentifierInfoEj;_ZN5clang4Sema15mergeFormatAttrEPNS_4DeclENS_11SourceRangeEPNS_14IdentifierInfoEiij;_ZN5clang4Sema16CheckRegparmAttrERKNS_13AttributeListERj;_ZN5clang4Sema16checkSectionNameENS_14SourceLocationEN4llvm9StringRefE;_ZN5clang4Sema16mergeMinSizeAttrEPNS_4DeclENS_11SourceRangeEj;_ZN5clang4Sema16mergeSectionAttrEPNS_4DeclENS_11SourceRangeEN4llvm9StringRefEj;_ZN5clang4Sema17AddAlignValueAttrENS_11SourceRangeEPNS_4DeclEPNS_4ExprEj;_ZN5clang4Sema17AddNSConsumedAttrENS_11SourceRangeEPNS_4DeclEjbb;_ZN5clang4Sema17CheckNoReturnAttrERKNS_13AttributeListE;_ZN5clang4Sema17ProcessPragmaWeakEPNS_5ScopeEPNS_4DeclE;_ZN5clang4Sema18mergeDLLExportAttrEPNS_4DeclENS_11SourceRangeEj;_ZN5clang4Sema18mergeDLLImportAttrEPNS_4DeclENS_11SourceRangeEj;_ZN5clang4Sema18redelayDiagnosticsERNS_4sema21DelayedDiagnosticPoolE;_ZN5clang4Sema19AddLaunchBoundsAttrENS_11SourceRangeEPNS_4DeclEPNS_4ExprES5_j;_ZN5clang4Sema19AddParameterABIAttrENS_11SourceRangeEPNS_4DeclENS_12ParameterABIEj;_ZN5clang4Sema19DeclApplyPragmaWeakEPNS_5ScopeEPNS_9NamedDeclERNS_8WeakInfoE;_ZN5clang4Sema19DeclClonePragmaWeakEPNS_9NamedDeclEPNS_14IdentifierInfoENS_14SourceLocationE;_ZN5clang4Sema19mergeVisibilityAttrEPNS_4DeclENS_11SourceRangeENS_14VisibilityAttr14VisibilityTypeEj;_ZN5clang4Sema20AddAssumeAlignedAttrENS_11SourceRangeEPNS_4DeclEPNS_4ExprES5_j;_ZN5clang4Sema20CheckCallingConvAttrERKNS_13AttributeListERNS_11CallingConvEPKNS_12FunctionDeclE;_ZN5clang4Sema21PopParsingDeclarationENS0_23DelayedDiagnosticsStateEPNS_4DeclE;_ZN5clang4Sema21ProcessDeclAttributesEPNS_5ScopeEPNS_4DeclERKNS_10DeclaratorE;_ZN5clang4Sema21mergeAlwaysInlineAttrEPNS_4DeclENS_11SourceRangeEPNS_14IdentifierInfoEj;_ZN5clang4Sema21mergeAvailabilityAttrEPNS_9NamedDeclENS_11SourceRangeEPNS_14IdentifierInfoEbNS_12VersionTupleES6_S6_bN4llvm9StringRefEbS8_NS0_21AvailabilityMergeKindEj;_ZN5clang4Sema21mergeOptimizeNoneAttrEPNS_4DeclENS_11SourceRangeEj;_ZN5clang4Sema22isValidPointerAttrTypeENS_8QualTypeEb;_ZN5clang4Sema22mergeMSInheritanceAttrEPNS_4DeclENS_11SourceRangeEbjNS_17MSInheritanceAttr8SpellingE;_ZN5clang4Sema23EmitAvailabilityWarningENS0_22AvailabilityDiagnosticEPNS_9NamedDeclEN4llvm9StringRefENS_14SourceLocationEPKNS_17ObjCInterfaceDeclEPKNS_16ObjCPropertyDeclEb;_ZN5clang4Sema23mergeTypeVisibilityAttrEPNS_4DeclENS_11SourceRangeENS_18TypeVisibilityAttr14VisibilityTypeEj;_ZN5clang4Sema24ProcessDeclAttributeListEPNS_5ScopeEPNS_4DeclEPKNS_13AttributeListEb;_ZN5clang4Sema24mergeInternalLinkageAttrEPNS_4DeclENS_11SourceRangeEPNS_14IdentifierInfoEj;_ZN5clang4Sema25checkUnusedDeclAttributesERNS_10DeclaratorE;_ZN5clang4Sema26CheckAlignasUnderalignmentEPNS_4DeclE;_ZN5clang4Sema30ProcessAccessDeclAttributeListEPNS_14AccessSpecDeclEPKNS_13AttributeListE;_ZN5clang4Sema30checkStringLiteralArgumentAttrERKNS_13AttributeListEjRN4llvm9StringRefEPNS_14SourceLocationE;_ZN5clang4Sema34checkMSInheritanceAttrOnDefinitionEPNS_13CXXRecordDeclENS_11SourceRangeEbNS_17MSInheritanceAttr8SpellingE; -static-type=Sema_SemaDeclAttr -package=org.clang.sema")
//</editor-fold>
public class Sema_SemaDeclAttr extends Sema_SemaDecl {
private final /*split clang::Sema*/ Sema $this() { return (Sema)this; }


/// Attribute merging methods. Return true if a new attribute was added.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::mergeAvailabilityAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 1959,
 FQN="clang::Sema::mergeAvailabilityAttr", NM="_ZN5clang4Sema21mergeAvailabilityAttrEPNS_9NamedDeclENS_11SourceRangeEPNS_14IdentifierInfoEbNS_12VersionTupleES6_S6_bN4llvm9StringRefEbS8_NS0_21AvailabilityMergeKindEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZN5clang4Sema21mergeAvailabilityAttrEPNS_9NamedDeclENS_11SourceRangeEPNS_14IdentifierInfoEbNS_12VersionTupleES6_S6_bN4llvm9StringRefEbS8_NS0_21AvailabilityMergeKindEj")
//</editor-fold>
public final AvailabilityAttr /*P*/ mergeAvailabilityAttr(NamedDecl /*P*/ D, SourceRange Range, 
                     IdentifierInfo /*P*/ Platform, 
                     boolean Implicit, 
                     VersionTuple Introduced, 
                     VersionTuple Deprecated, 
                     VersionTuple Obsoleted, 
                     boolean IsUnavailable, 
                     StringRef Message, 
                     boolean IsStrict, 
                     StringRef Replacement, 
                     AvailabilityMergeKind AMK, 
                     /*uint*/int AttrSpellingListIndex) {
  VersionTuple MergedIntroduced = new VersionTuple(Introduced);
  VersionTuple MergedDeprecated = new VersionTuple(Deprecated);
  VersionTuple MergedObsoleted = new VersionTuple(Obsoleted);
  boolean FoundAny = false;
  boolean OverrideOrImpl = false;
  switch (AMK) {
   case AMK_None:
   case AMK_Redeclaration:
    OverrideOrImpl = false;
    break;
   case AMK_Override:
   case AMK_ProtocolImplementation:
    OverrideOrImpl = true;
    break;
  }
  if (D.hasAttrs()) {
    final SmallVector<Attr /*P*/>/*&*/ Attrs = D.getAttrs();
    for (/*uint*/int i = 0, e = Attrs.size(); i != e;) {
      /*const*/ AvailabilityAttr /*P*/ OldAA = dyn_cast_AvailabilityAttr(Attrs.$at(i));
      if (!(OldAA != null)) {
        ++i;
        continue;
      }
      
      IdentifierInfo /*P*/ OldPlatform = OldAA.getPlatform();
      if (OldPlatform != Platform) {
        ++i;
        continue;
      }
      
      // If there is an existing availability attribute for this platform that
      // is explicit and the new one is implicit use the explicit one and
      // discard the new implicit attribute.
      if (!OldAA.isImplicit() && Implicit) {
        return null;
      }
      
      // If there is an existing attribute for this platform that is implicit
      // and the new attribute is explicit then erase the old one and
      // continue processing the attributes.
      if (!Implicit && OldAA.isImplicit()) {
        Attrs.erase(Attrs.begin().$add(i));
        --e;
        continue;
      }
      
      FoundAny = true;
      VersionTuple OldIntroduced = OldAA.getIntroduced();
      VersionTuple OldDeprecated = OldAA.getDeprecated();
      VersionTuple OldObsoleted = OldAA.getObsoleted();
      boolean OldIsUnavailable = OldAA.getUnavailable();
      if (!versionsMatch(OldIntroduced, Introduced, OverrideOrImpl)
         || !versionsMatch(Deprecated, OldDeprecated, OverrideOrImpl)
         || !versionsMatch(Obsoleted, OldObsoleted, OverrideOrImpl)
         || !(OldIsUnavailable == IsUnavailable
         || (OverrideOrImpl && !OldIsUnavailable && IsUnavailable))) {
        if (OverrideOrImpl) {
          int Which = -1;
          VersionTuple FirstVersion/*J*/= new VersionTuple();
          VersionTuple SecondVersion/*J*/= new VersionTuple();
          if (!versionsMatch(OldIntroduced, Introduced, OverrideOrImpl)) {
            Which = 0;
            FirstVersion.$assign(OldIntroduced);
            SecondVersion.$assign(Introduced);
          } else if (!versionsMatch(Deprecated, OldDeprecated, OverrideOrImpl)) {
            Which = 1;
            FirstVersion.$assign(Deprecated);
            SecondVersion.$assign(OldDeprecated);
          } else if (!versionsMatch(Obsoleted, OldObsoleted, OverrideOrImpl)) {
            Which = 2;
            FirstVersion.$assign(Obsoleted);
            SecondVersion.$assign(OldObsoleted);
          }
          if (Which == -1) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(OldAA.getLocation(), 
                          diag.warn_mismatched_availability_override_unavail)), 
                      AvailabilityAttr.getPrettyPlatformName(Platform.getName())), 
                  (AMK == AvailabilityMergeKind.AMK_Override)));
            } finally {
              $c$.$destroy();
            }
          } else {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(OldAA.getLocation(), 
                                      diag.warn_mismatched_availability_override)), 
                                  Which), 
                              AvailabilityAttr.getPrettyPlatformName(Platform.getName())), 
                          FirstVersion.getAsString()), SecondVersion.getAsString()), 
                  (AMK == AvailabilityMergeKind.AMK_Override)));
            } finally {
              $c$.$destroy();
            }
          }
          if (AMK == AvailabilityMergeKind.AMK_Override) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($c$.track($this().Diag(Range.getBegin(), diag.note_overridden_method)));
            } finally {
              $c$.$destroy();
            }
          } else {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($c$.track($this().Diag(Range.getBegin(), diag.note_protocol_method)));
            } finally {
              $c$.$destroy();
            }
          }
        } else {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track($this().Diag(OldAA.getLocation(), diag.warn_mismatched_availability)));
            $c$.clean($c$.track($this().Diag(Range.getBegin(), diag.note_previous_attribute)));
          } finally {
            $c$.$destroy();
          }
        }
        
        Attrs.erase(Attrs.begin().$add(i));
        --e;
        continue;
      }
      
      VersionTuple MergedIntroduced2 = new VersionTuple(MergedIntroduced);
      VersionTuple MergedDeprecated2 = new VersionTuple(MergedDeprecated);
      VersionTuple MergedObsoleted2 = new VersionTuple(MergedObsoleted);
      if (MergedIntroduced2.empty()) {
        MergedIntroduced2.$assign(OldIntroduced);
      }
      if (MergedDeprecated2.empty()) {
        MergedDeprecated2.$assign(OldDeprecated);
      }
      if (MergedObsoleted2.empty()) {
        MergedObsoleted2.$assign(OldObsoleted);
      }
      if (checkAvailabilityAttr(/*Deref*/$this(), OldAA.getRange(), Platform, 
          new VersionTuple(MergedIntroduced2), new VersionTuple(MergedDeprecated2), 
          new VersionTuple(MergedObsoleted2))) {
        Attrs.erase(Attrs.begin().$add(i));
        --e;
        continue;
      }
      
      MergedIntroduced.$assign(MergedIntroduced2);
      MergedDeprecated.$assign(MergedDeprecated2);
      MergedObsoleted.$assign(MergedObsoleted2);
      ++i;
    }
  }
  if (FoundAny
     && $eq_VersionTuple$C(MergedIntroduced, Introduced)
     && $eq_VersionTuple$C(MergedDeprecated, Deprecated)
     && $eq_VersionTuple$C(MergedObsoleted, Obsoleted)) {
    return null;
  }
  
  // Only create a new attribute if !OverrideOrImpl, but we want to do
  // the checking.
  if (!checkAvailabilityAttr(/*Deref*/$this(), new SourceRange(Range), Platform, new VersionTuple(MergedIntroduced), 
      new VersionTuple(MergedDeprecated), new VersionTuple(MergedObsoleted))
     && !OverrideOrImpl) {
    AvailabilityAttr /*P*/ Avail = /*FIXME:NEW_EXPR*//*::*//*new (Context)*/ new AvailabilityAttr(new SourceRange(Range), $this().Context, Platform, 
        new VersionTuple(Introduced), new VersionTuple(Deprecated), 
        new VersionTuple(Obsoleted), IsUnavailable, new StringRef(Message), 
        IsStrict, new StringRef(Replacement), 
        AttrSpellingListIndex);
    Avail.setImplicit(Implicit);
    return Avail;
  }
  return null;
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::mergeTypeVisibilityAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 2265,
 FQN="clang::Sema::mergeTypeVisibilityAttr", NM="_ZN5clang4Sema23mergeTypeVisibilityAttrEPNS_4DeclENS_11SourceRangeENS_18TypeVisibilityAttr14VisibilityTypeEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZN5clang4Sema23mergeTypeVisibilityAttrEPNS_4DeclENS_11SourceRangeENS_18TypeVisibilityAttr14VisibilityTypeEj")
//</editor-fold>
public final TypeVisibilityAttr /*P*/ mergeTypeVisibilityAttr(Decl /*P*/ D, SourceRange Range, 
                       TypeVisibilityAttr.VisibilityType Vis, 
                       /*uint*/int AttrSpellingListIndex) {
  return /*::*/mergeVisibilityAttr$TypeVisibilityAttr(/*Deref*/$this(), D, new SourceRange(Range), Vis, 
      AttrSpellingListIndex);
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::mergeVisibilityAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 2258,
 FQN="clang::Sema::mergeVisibilityAttr", NM="_ZN5clang4Sema19mergeVisibilityAttrEPNS_4DeclENS_11SourceRangeENS_14VisibilityAttr14VisibilityTypeEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZN5clang4Sema19mergeVisibilityAttrEPNS_4DeclENS_11SourceRangeENS_14VisibilityAttr14VisibilityTypeEj")
//</editor-fold>
public final VisibilityAttr /*P*/ mergeVisibilityAttr(Decl /*P*/ D, SourceRange Range, 
                   VisibilityAttr.VisibilityType Vis, 
                   /*uint*/int AttrSpellingListIndex) {
  return /*::*/mergeVisibilityAttr$VisibilityAttr(/*Deref*/$this(), D, new SourceRange(Range), Vis, 
      AttrSpellingListIndex);
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::mergeDLLImportAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 4997,
 FQN="clang::Sema::mergeDLLImportAttr", NM="_ZN5clang4Sema18mergeDLLImportAttrEPNS_4DeclENS_11SourceRangeEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZN5clang4Sema18mergeDLLImportAttrEPNS_4DeclENS_11SourceRangeEj")
//</editor-fold>
public final DLLImportAttr /*P*/ mergeDLLImportAttr(Decl /*P*/ D, SourceRange Range, 
                  /*uint*/int AttrSpellingListIndex) {
  if (D.hasAttr(DLLExportAttr.class)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Range.getBegin(), diag.warn_attribute_ignored)), /*KEEP_STR*/"'dllimport'"));
      return null;
    } finally {
      $c$.$destroy();
    }
  }
  if (D.hasAttr(DLLImportAttr.class)) {
    return null;
  }
  
  return /*FIXME:NEW_EXPR*//*::*//*new (Context)*/ new DLLImportAttr(new SourceRange(Range), $this().Context, AttrSpellingListIndex);
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::mergeDLLExportAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 5010,
 FQN="clang::Sema::mergeDLLExportAttr", NM="_ZN5clang4Sema18mergeDLLExportAttrEPNS_4DeclENS_11SourceRangeEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZN5clang4Sema18mergeDLLExportAttrEPNS_4DeclENS_11SourceRangeEj")
//</editor-fold>
public final DLLExportAttr /*P*/ mergeDLLExportAttr(Decl /*P*/ D, SourceRange Range, 
                  /*uint*/int AttrSpellingListIndex) {
  {
    DLLImportAttr /*P*/ Import = D.getAttr(DLLImportAttr.class);
    if ((Import != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Import.getLocation(), diag.warn_attribute_ignored)), Import));
        D.dropAttr(DLLImportAttr.class);
      } finally {
        $c$.$destroy();
      }
    }
  }
  if (D.hasAttr(DLLExportAttr.class)) {
    return null;
  }
  
  return /*FIXME:NEW_EXPR*//*::*//*new (Context)*/ new DLLExportAttr(new SourceRange(Range), $this().Context, AttrSpellingListIndex);
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::mergeMSInheritanceAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 5057,
 FQN="clang::Sema::mergeMSInheritanceAttr", NM="_ZN5clang4Sema22mergeMSInheritanceAttrEPNS_4DeclENS_11SourceRangeEbjNS_17MSInheritanceAttr8SpellingE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZN5clang4Sema22mergeMSInheritanceAttrEPNS_4DeclENS_11SourceRangeEbjNS_17MSInheritanceAttr8SpellingE")
//</editor-fold>
public final MSInheritanceAttr /*P*/ mergeMSInheritanceAttr(Decl /*P*/ D, SourceRange Range, boolean BestCase, 
                      /*uint*/int AttrSpellingListIndex, 
                      MSInheritanceAttr.Spelling SemanticSpelling) {
  {
    MSInheritanceAttr /*P*/ IA = D.getAttr(MSInheritanceAttr.class);
    if ((IA != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        if (IA.getSemanticSpelling() == SemanticSpelling) {
          return null;
        }
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(IA.getLocation(), diag.err_mismatched_ms_inheritance)), 
            1/*previous declaration*/));
        $c$.clean($c$.track($this().Diag(Range.getBegin(), diag.note_previous_ms_inheritance)));
        D.dropAttr(MSInheritanceAttr.class);
      } finally {
        $c$.$destroy();
      }
    }
  }
  
  CXXRecordDecl /*P*/ RD = cast_CXXRecordDecl(D);
  if (RD.hasDefinition()) {
    if ($this().checkMSInheritanceAttrOnDefinition(RD, new SourceRange(Range), BestCase, 
        SemanticSpelling)) {
      return null;
    }
  } else {
    if (isa_ClassTemplatePartialSpecializationDecl(RD)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Range.getBegin(), diag.warn_ignored_ms_inheritance)), 
            1/*partial specialization*/));
        return null;
      } finally {
        $c$.$destroy();
      }
    }
    if ((RD.getDescribedClassTemplate() != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Range.getBegin(), diag.warn_ignored_ms_inheritance)), 
            0/*primary template*/));
        return null;
      } finally {
        $c$.$destroy();
      }
    }
  }
  
  return /*FIXME:NEW_EXPR*//*::*//*new (Context)*/ new MSInheritanceAttr(new SourceRange(Range), $this().Context, BestCase, AttrSpellingListIndex);
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::mergeFormatAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 2863,
 FQN="clang::Sema::mergeFormatAttr", NM="_ZN5clang4Sema15mergeFormatAttrEPNS_4DeclENS_11SourceRangeEPNS_14IdentifierInfoEiij",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZN5clang4Sema15mergeFormatAttrEPNS_4DeclENS_11SourceRangeEPNS_14IdentifierInfoEiij")
//</editor-fold>
public final FormatAttr /*P*/ mergeFormatAttr(Decl /*P*/ D, SourceRange Range, 
               IdentifierInfo /*P*/ Format, int FormatIdx, 
               int FirstArg, 
               /*uint*/int AttrSpellingListIndex) {
  // Check whether we already have an equivalent format attribute.
  for (FormatAttr /*P*/ F : D.specific_attrs(FormatAttr.class)) {
    if (F.getType() == Format
       && F.getFormatIdx() == FormatIdx
       && F.getFirstArg() == FirstArg) {
      // If we don't have a valid location for this attribute, adopt the
      // location.
      if (F.getLocation().isInvalid()) {
        F.setRange(new SourceRange(Range));
      }
      return null;
    }
  }
  
  return /*FIXME:NEW_EXPR*//*::*//*new (Context)*/ new FormatAttr(new SourceRange(Range), $this().Context, Format, FormatIdx, 
      FirstArg, AttrSpellingListIndex);
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::mergeSectionAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 2617,
 FQN="clang::Sema::mergeSectionAttr", NM="_ZN5clang4Sema16mergeSectionAttrEPNS_4DeclENS_11SourceRangeEN4llvm9StringRefEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZN5clang4Sema16mergeSectionAttrEPNS_4DeclENS_11SourceRangeEN4llvm9StringRefEj")
//</editor-fold>
public final SectionAttr /*P*/ mergeSectionAttr(Decl /*P*/ D, SourceRange Range, 
                StringRef Name, 
                /*uint*/int AttrSpellingListIndex) {
  {
    SectionAttr /*P*/ ExistingAttr = D.getAttr(SectionAttr.class);
    if ((ExistingAttr != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        if ($eq_StringRef(ExistingAttr.getName(), /*NO_COPY*/Name)) {
          return null;
        }
        $c$.clean($c$.track($this().Diag(ExistingAttr.getLocation(), diag.warn_mismatched_section)));
        $c$.clean($c$.track($this().Diag(Range.getBegin(), diag.note_previous_attribute)));
        return null;
      } finally {
        $c$.$destroy();
      }
    }
  }
  return /*FIXME:NEW_EXPR*//*::*//*new (Context)*/ new SectionAttr(new SourceRange(Range), $this().Context, new StringRef(Name), 
      AttrSpellingListIndex);
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::mergeAlwaysInlineAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 3587,
 FQN="clang::Sema::mergeAlwaysInlineAttr", NM="_ZN5clang4Sema21mergeAlwaysInlineAttrEPNS_4DeclENS_11SourceRangeEPNS_14IdentifierInfoEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZN5clang4Sema21mergeAlwaysInlineAttrEPNS_4DeclENS_11SourceRangeEPNS_14IdentifierInfoEj")
//</editor-fold>
public final AlwaysInlineAttr /*P*/ mergeAlwaysInlineAttr(Decl /*P*/ D, SourceRange Range, 
                     IdentifierInfo /*P*/ Ident, 
                     /*uint*/int AttrSpellingListIndex) {
  {
    OptimizeNoneAttr /*P*/ Optnone = D.getAttr(OptimizeNoneAttr.class);
    if ((Optnone != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Range.getBegin(), diag.warn_attribute_ignored)), Ident));
        $c$.clean($c$.track($this().Diag(Optnone.getLocation(), diag.note_conflicting_attribute)));
        return null;
      } finally {
        $c$.$destroy();
      }
    }
  }
  if (D.hasAttr(AlwaysInlineAttr.class)) {
    return null;
  }
  
  return /*FIXME:NEW_EXPR*//*::*//*new (Context)*/ new AlwaysInlineAttr(new SourceRange(Range), $this().Context, 
      AttrSpellingListIndex);
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::mergeMinSizeAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 3639,
 FQN="clang::Sema::mergeMinSizeAttr", NM="_ZN5clang4Sema16mergeMinSizeAttrEPNS_4DeclENS_11SourceRangeEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZN5clang4Sema16mergeMinSizeAttrEPNS_4DeclENS_11SourceRangeEj")
//</editor-fold>
public final MinSizeAttr /*P*/ mergeMinSizeAttr(Decl /*P*/ D, SourceRange Range, 
                /*uint*/int AttrSpellingListIndex) {
  {
    OptimizeNoneAttr /*P*/ Optnone = D.getAttr(OptimizeNoneAttr.class);
    if ((Optnone != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Range.getBegin(), diag.warn_attribute_ignored)), /*KEEP_STR*/"'minsize'"));
        $c$.clean($c$.track($this().Diag(Optnone.getLocation(), diag.note_conflicting_attribute)));
        return null;
      } finally {
        $c$.$destroy();
      }
    }
  }
  if (D.hasAttr(MinSizeAttr.class)) {
    return null;
  }
  
  return /*FIXME:NEW_EXPR*//*::*//*new (Context)*/ new MinSizeAttr(new SourceRange(Range), $this().Context, AttrSpellingListIndex);
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::mergeOptimizeNoneAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 3653,
 FQN="clang::Sema::mergeOptimizeNoneAttr", NM="_ZN5clang4Sema21mergeOptimizeNoneAttrEPNS_4DeclENS_11SourceRangeEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZN5clang4Sema21mergeOptimizeNoneAttrEPNS_4DeclENS_11SourceRangeEj")
//</editor-fold>
public final OptimizeNoneAttr /*P*/ mergeOptimizeNoneAttr(Decl /*P*/ D, SourceRange Range, 
                     /*uint*/int AttrSpellingListIndex) {
  {
    AlwaysInlineAttr /*P*/ Inline = D.getAttr(AlwaysInlineAttr.class);
    if ((Inline != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Inline.getLocation(), diag.warn_attribute_ignored)), Inline));
        $c$.clean($c$.track($this().Diag(Range.getBegin(), diag.note_conflicting_attribute)));
        D.dropAttr(AlwaysInlineAttr.class);
      } finally {
        $c$.$destroy();
      }
    }
  }
  {
    MinSizeAttr /*P*/ MinSize = D.getAttr(MinSizeAttr.class);
    if ((MinSize != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(MinSize.getLocation(), diag.warn_attribute_ignored)), MinSize));
        $c$.clean($c$.track($this().Diag(Range.getBegin(), diag.note_conflicting_attribute)));
        D.dropAttr(MinSizeAttr.class);
      } finally {
        $c$.$destroy();
      }
    }
  }
  if (D.hasAttr(OptimizeNoneAttr.class)) {
    return null;
  }
  
  return /*FIXME:NEW_EXPR*//*::*//*new (Context)*/ new OptimizeNoneAttr(new SourceRange(Range), $this().Context, 
      AttrSpellingListIndex);
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::mergeInternalLinkageAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 3612,
 FQN="clang::Sema::mergeInternalLinkageAttr", NM="_ZN5clang4Sema24mergeInternalLinkageAttrEPNS_4DeclENS_11SourceRangeEPNS_14IdentifierInfoEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZN5clang4Sema24mergeInternalLinkageAttrEPNS_4DeclENS_11SourceRangeEPNS_14IdentifierInfoEj")
//</editor-fold>
public final InternalLinkageAttr /*P*/ mergeInternalLinkageAttr(Decl /*P*/ D, SourceRange Range, 
                        IdentifierInfo /*P*/ Ident, 
                        /*uint*/int AttrSpellingListIndex) {
  {
    VarDecl /*P*/ VD = dyn_cast_VarDecl(D);
    if ((VD != null)) {
      // Attribute applies to Var but not any subclass of it (like ParmVar,
      // ImplicitParm or VarTemplateSpecialization).
      if (VD.getKind() != Decl.Kind.Var) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Range.getBegin(), diag.warn_attribute_wrong_decl_type)), 
                  Ident), ($this().getLangOpts().CPlusPlus ? AttributeDeclKind.ExpectedFunctionVariableOrClass : AttributeDeclKind.ExpectedVariableOrFunction)));
          return null;
        } finally {
          $c$.$destroy();
        }
      }
      // Attribute does not apply to non-static local variables.
      if (VD.hasLocalStorage()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag(VD.getLocation(), diag.warn_internal_linkage_local_storage)));
          return null;
        } finally {
          $c$.$destroy();
        }
      }
    }
  }
  if (checkAttrMutualExclusion(CommonAttr.class, /*Deref*/$this(), D, new SourceRange(Range), Ident)) {
    return null;
  }
  
  return /*FIXME:NEW_EXPR*//*::*//*new (Context)*/ new InternalLinkageAttr(new SourceRange(Range), $this().Context, AttrSpellingListIndex);
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::mergeCommonAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 3603,
 FQN="clang::Sema::mergeCommonAttr", NM="_ZN5clang4Sema15mergeCommonAttrEPNS_4DeclENS_11SourceRangeEPNS_14IdentifierInfoEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZN5clang4Sema15mergeCommonAttrEPNS_4DeclENS_11SourceRangeEPNS_14IdentifierInfoEj")
//</editor-fold>
public final CommonAttr /*P*/ mergeCommonAttr(Decl /*P*/ D, SourceRange Range, 
               IdentifierInfo /*P*/ Ident, 
               /*uint*/int AttrSpellingListIndex) {
  if (checkAttrMutualExclusion(InternalLinkageAttr.class, /*Deref*/$this(), D, new SourceRange(Range), Ident)) {
    return null;
  }
  
  return /*FIXME:NEW_EXPR*//*::*//*new (Context)*/ new CommonAttr(new SourceRange(Range), $this().Context, AttrSpellingListIndex);
}


// More parsing and symbol table subroutines.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ProcessPragmaWeak">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 6087,
 FQN="clang::Sema::ProcessPragmaWeak", NM="_ZN5clang4Sema17ProcessPragmaWeakEPNS_5ScopeEPNS_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZN5clang4Sema17ProcessPragmaWeakEPNS_5ScopeEPNS_4DeclE")
//</editor-fold>
public final void ProcessPragmaWeak(Scope /*P*/ S, Decl /*P*/ D) {
  // It's valid to "forward-declare" #pragma weak, in which case we
  // have to do this.
  $this().LoadExternalWeakUndeclaredIdentifiers();
  if (!$this().WeakUndeclaredIdentifiers.empty()) {
    NamedDecl /*P*/ ND = null;
    {
      VarDecl /*P*/ VD = dyn_cast_VarDecl(D);
      if ((VD != null)) {
        if (VD.isExternC()) {
          ND = VD;
        }
      }
    }
    {
      FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(D);
      if ((FD != null)) {
        if (FD.isExternC()) {
          ND = FD;
        }
      }
    }
    if ((ND != null)) {
      {
        IdentifierInfo /*P*/ Id = ND.getIdentifier();
        if ((Id != null)) {
          StdVector.iterator<pairPtrType<IdentifierInfo /*P*/ , WeakInfo> /*P*/> I = $this().WeakUndeclaredIdentifiers.find(Id);
          if ($noteq___normal_iterator$C(I, $this().WeakUndeclaredIdentifiers.end())) {
            WeakInfo W = new WeakInfo(I.$arrow().second);
            $this().DeclApplyPragmaWeak(S, ND, W);
            $this().WeakUndeclaredIdentifiers.$at(Id).$assign(W);
          }
        }
      }
    }
  }
}

// Decl attributes - this routine is the top level dispatcher.

/// ProcessDeclAttributes - Given a declarator (PD) with attributes indicated in
/// it, apply them to D.  This is a bit tricky because PD can have attributes
/// specified in many different places, and we need to find and apply them all.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ProcessDeclAttributes">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 6115,
 FQN="clang::Sema::ProcessDeclAttributes", NM="_ZN5clang4Sema21ProcessDeclAttributesEPNS_5ScopeEPNS_4DeclERKNS_10DeclaratorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZN5clang4Sema21ProcessDeclAttributesEPNS_5ScopeEPNS_4DeclERKNS_10DeclaratorE")
//</editor-fold>
public final void ProcessDeclAttributes(Scope /*P*/ S, Decl /*P*/ D, final /*const*/ Declarator /*&*/ PD) {
  {
    // Apply decl attributes from the DeclSpec if present.
    /*const*/ AttributeList /*P*/ Attrs = PD.getDeclSpec().getAttributes$Const().getList();
    if ((Attrs != null)) {
      $this().ProcessDeclAttributeList(S, D, Attrs);
    }
  }
  
  // Walk the declarator structure, applying decl attributes that were in a type
  // position to the decl itself.  This handles cases like:
  //   int *__attr__(x)** D;
  // when X is a decl attribute.
  for (/*uint*/int i = 0, e = PD.getNumTypeObjects(); i != e; ++i)  {
    {
      /*const*/ AttributeList /*P*/ Attrs = PD.getTypeObject$Const(i).getAttrs();
      if ((Attrs != null)) {
        $this().ProcessDeclAttributeList(S, D, Attrs, /*IncludeCXX11Attributes=*/ false);
      }
    }
  }
  {
    
    // Finally, apply any attributes on the decl itself.
    /*const*/ AttributeList /*P*/ Attrs = PD.getAttributes$Const();
    if ((Attrs != null)) {
      $this().ProcessDeclAttributeList(S, D, Attrs);
    }
  }
}


/// ProcessDeclAttributeList - Apply all the decl attributes in the specified
/// attribute list to the specified decl, ignoring any type attributes.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ProcessDeclAttributeList">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 5924,
 FQN="clang::Sema::ProcessDeclAttributeList", NM="_ZN5clang4Sema24ProcessDeclAttributeListEPNS_5ScopeEPNS_4DeclEPKNS_13AttributeListEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZN5clang4Sema24ProcessDeclAttributeListEPNS_5ScopeEPNS_4DeclEPKNS_13AttributeListEb")
//</editor-fold>
public final void ProcessDeclAttributeList(Scope /*P*/ S, Decl /*P*/ D, 
                        /*const*/ AttributeList /*P*/ AttrList) {
  ProcessDeclAttributeList(S, D, 
                        AttrList, 
                        true);
}
public final void ProcessDeclAttributeList(Scope /*P*/ S, Decl /*P*/ D, 
                        /*const*/ AttributeList /*P*/ AttrList, 
                        boolean IncludeCXX11Attributes/*= true*/) {
  for (/*const*/ AttributeList /*P*/ l = AttrList; (l != null); l = l.getNext())  {
    ProcessDeclAttribute(/*Deref*/$this(), S, D, $Deref(l), IncludeCXX11Attributes);
  }
  
  // FIXME: We should be able to handle these cases in TableGen.
  // GCC accepts
  // static int a9 __attribute__((weakref));
  // but that looks really pointless. We reject it.
  if (D.hasAttr(WeakRefAttr.class) && !D.hasAttr(AliasAttr.class)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(AttrList.getLoc(), diag.err_attribute_weakref_without_alias)), 
          cast_NamedDecl(D)));
      D.dropAttr(WeakRefAttr.class);
      return;
    } finally {
      $c$.$destroy();
    }
  }
  
  // FIXME: We should be able to handle this in TableGen as well. It would be
  // good to have a way to specify "these attributes must appear as a group",
  // for these. Additionally, it would be good to have a way to specify "these
  // attribute must never appear as a group" for attributes like cold and hot.
  if (!D.hasAttr(OpenCLKernelAttr.class)) {
    {
      // These attributes cannot be applied to a non-kernel function.
      Attr /*P*/ A = D.getAttr(ReqdWorkGroupSizeAttr.class);
      if ((A != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // FIXME: This emits a different error message than
          // diag::err_attribute_wrong_decl_type + ExpectedKernelFunction.
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(D.getLocation(), diag.err_opencl_kernel_attr)), A));
          D.setInvalidDecl();
        } finally {
          $c$.$destroy();
        }
      } else {
        Attr /*P*/ A$1 = D.getAttr(WorkGroupSizeHintAttr.class);
        if ((A$1 != null)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(D.getLocation(), diag.err_opencl_kernel_attr)), A$1));
            D.setInvalidDecl();
          } finally {
            $c$.$destroy();
          }
        } else {
          Attr /*P*/ A$2 = D.getAttr(VecTypeHintAttr.class);
          if ((A$2 != null)) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(D.getLocation(), diag.err_opencl_kernel_attr)), A$2));
              D.setInvalidDecl();
            } finally {
              $c$.$destroy();
            }
          } else {
            Attr /*P*/ A$3 = D.getAttr(AMDGPUNumVGPRAttr.class);
            if ((A$3 != null)) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(D.getLocation(), diag.err_attribute_wrong_decl_type)), 
                        A$3), AttributeDeclKind.ExpectedKernelFunction));
                D.setInvalidDecl();
              } finally {
                $c$.$destroy();
              }
            } else {
              Attr /*P*/ A$4 = D.getAttr(AMDGPUNumSGPRAttr.class);
              if ((A$4 != null)) {
                JavaCleaner $c$ = $createJavaCleaner();
                try {
                  $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(D.getLocation(), diag.err_attribute_wrong_decl_type)), 
                          A$4), AttributeDeclKind.ExpectedKernelFunction));
                  D.setInvalidDecl();
                } finally {
                  $c$.$destroy();
                }
              }
            }
          }
        }
      }
    }
  }
}


// Annotation attributes are the only attributes allowed after an access
// specifier.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ProcessAccessDeclAttributeList">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 5972,
 FQN="clang::Sema::ProcessAccessDeclAttributeList", NM="_ZN5clang4Sema30ProcessAccessDeclAttributeListEPNS_14AccessSpecDeclEPKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZN5clang4Sema30ProcessAccessDeclAttributeListEPNS_14AccessSpecDeclEPKNS_13AttributeListE")
//</editor-fold>
public final boolean ProcessAccessDeclAttributeList(AccessSpecDecl /*P*/ ASDecl, 
                              /*const*/ AttributeList /*P*/ AttrList) {
  for (/*const*/ AttributeList /*P*/ l = AttrList; (l != null); l = l.getNext()) {
    if (l.getKind() == AttributeList.Kind.AT_Annotate) {
      ProcessDeclAttribute(/*Deref*/$this(), (Scope /*P*/ )null, ASDecl, $Deref(l), l.isCXX11Attribute());
    } else {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track($this().Diag(l.getLoc(), diag.err_only_annotate_after_access_spec)));
        return true;
      } finally {
        $c$.$destroy();
      }
    }
  }
  
  return false;
}


/// checkUnusedDeclAttributes - Given a declarator which is not being
/// used to build a declaration, complain about any decl attributes
/// which might be lying around on it.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::checkUnusedDeclAttributes">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 6007,
 FQN="clang::Sema::checkUnusedDeclAttributes", NM="_ZN5clang4Sema25checkUnusedDeclAttributesERNS_10DeclaratorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZN5clang4Sema25checkUnusedDeclAttributesERNS_10DeclaratorE")
//</editor-fold>
public final void checkUnusedDeclAttributes(final Declarator /*&*/ D) {
  /*::*/SemaDeclAttrStatics.checkUnusedDeclAttributes(/*Deref*/$this(), D.getDeclSpec().getAttributes$Const().getList());
  /*::*/SemaDeclAttrStatics.checkUnusedDeclAttributes(/*Deref*/$this(), D.getAttributes());
  for (/*uint*/int i = 0, e = D.getNumTypeObjects(); i != e; ++i)  {
    /*::*/SemaDeclAttrStatics.checkUnusedDeclAttributes(/*Deref*/$this(), D.getTypeObject(i).getAttrs());
  }
}


/// Determine if type T is a valid subject for a nonnull and similar
/// attributes. By default, we look through references (the behavior used by
/// nonnull), but if the second parameter is true, then we treat a reference
/// type as valid.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::isValidPointerAttrType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 1190,
 FQN="clang::Sema::isValidPointerAttrType", NM="_ZN5clang4Sema22isValidPointerAttrTypeENS_8QualTypeEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZN5clang4Sema22isValidPointerAttrTypeENS_8QualTypeEb")
//</editor-fold>
public final boolean isValidPointerAttrType(QualType T) {
  return isValidPointerAttrType(T, false);
}
public final boolean isValidPointerAttrType(QualType T, boolean RefOkay/*= false*/) {
  if (RefOkay) {
    if (T.$arrow().isReferenceType()) {
      return true;
    }
  } else {
    T.$assignMove(T.getNonReferenceType());
  }
  {
    
    // The nonnull attribute, and other similar attributes, can be applied to a
    // transparent union that contains a pointer type.
    /*const*/ RecordType /*P*/ UT = T.$arrow().getAsUnionType();
    if ((UT != null)) {
      if ((UT != null) && UT.getDecl().hasAttr(TransparentUnionAttr.class)) {
        RecordDecl /*P*/ UD = UT.getDecl();
        for (/*const*/ FieldDecl /*P*/ I : UD.fields()) {
          QualType QT = I.getType();
          if (QT.$arrow().isAnyPointerType() || QT.$arrow().isBlockPointerType()) {
            return true;
          }
        }
      }
    }
  }
  
  return T.$arrow().isAnyPointerType() || T.$arrow().isBlockPointerType();
}


/// Checks a regparm attribute, returning true if it is ill-formed and
/// otherwise setting numParams to the appropriate value.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckRegparmAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 4009,
 FQN="clang::Sema::CheckRegparmAttr", NM="_ZN5clang4Sema16CheckRegparmAttrERKNS_13AttributeListERj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZN5clang4Sema16CheckRegparmAttrERKNS_13AttributeListERj")
//</editor-fold>
public final boolean CheckRegparmAttr(final /*const*/ AttributeList /*&*/ Attr, final uint$ref/*uint &*/ numParams) {
  if (Attr.isInvalid()) {
    return true;
  }
  if (!checkAttributeNumArgs(/*Deref*/$this(), Attr, 1)) {
    Attr.setInvalid();
    return true;
  }
  
  uint$ref NP = create_uint$ref();
  Expr /*P*/ NumParamsExpr = Attr.getArgAsExpr(0);
  if (!checkUInt32Argument(/*Deref*/$this(), Attr, NumParamsExpr, NP)) {
    Attr.setInvalid();
    return true;
  }
  if ($this().Context.getTargetInfo().getRegParmMax() == 0) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Attr.getLoc(), diag.err_attribute_regparm_wrong_platform)), 
          NumParamsExpr.getSourceRange()));
      Attr.setInvalid();
      return true;
    } finally {
      $c$.$destroy();
    }
  }
  
  numParams.$set(NP.$deref());
  if ($greater_uint(numParams.$deref(), $this().Context.getTargetInfo().getRegParmMax())) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Attr.getLoc(), diag.err_attribute_regparm_invalid_number)), 
              $this().Context.getTargetInfo().getRegParmMax()), NumParamsExpr.getSourceRange()));
      Attr.setInvalid();
      return true;
    } finally {
      $c$.$destroy();
    }
  }
  
  return false;
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckCallingConvAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 3840,
 FQN="clang::Sema::CheckCallingConvAttr", NM="_ZN5clang4Sema20CheckCallingConvAttrERKNS_13AttributeListERNS_11CallingConvEPKNS_12FunctionDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZN5clang4Sema20CheckCallingConvAttrERKNS_13AttributeListERNS_11CallingConvEPKNS_12FunctionDeclE")
//</editor-fold>
public final boolean CheckCallingConvAttr(final /*const*/ AttributeList /*&*/ attr, final type$ref<CallingConv /*&*/> CC) {
  return CheckCallingConvAttr(attr, CC, 
                    (/*const*/ FunctionDecl /*P*/ )null);
}
public final boolean CheckCallingConvAttr(final /*const*/ AttributeList /*&*/ attr, final type$ref<CallingConv /*&*/> CC, 
                    /*const*/ FunctionDecl /*P*/ FD/*= null*/) {
  if (attr.isInvalid()) {
    return true;
  }
  if (attr.hasProcessingCache()) {
    CC.$set(CallingConv.valueOf(attr.getProcessingCache()));
    return false;
  }
  
  /*uint*/int ReqArgs = attr.getKind() == AttributeList.Kind.AT_Pcs ? 1 : 0;
  if (!checkAttributeNumArgs(/*Deref*/$this(), attr, ReqArgs)) {
    attr.setInvalid();
    return true;
  }
  
  // TODO: diagnose uses of these conventions on the wrong target.
  switch (attr.getKind()) {
   case AT_CDecl:
    CC.$set(CallingConv.CC_C);
    break;
   case AT_FastCall:
    CC.$set(CallingConv.CC_X86FastCall);
    break;
   case AT_StdCall:
    CC.$set(CallingConv.CC_X86StdCall);
    break;
   case AT_ThisCall:
    CC.$set(CallingConv.CC_X86ThisCall);
    break;
   case AT_Pascal:
    CC.$set(CallingConv.CC_X86Pascal);
    break;
   case AT_SwiftCall:
    CC.$set(CallingConv.CC_Swift);
    break;
   case AT_VectorCall:
    CC.$set(CallingConv.CC_X86VectorCall);
    break;
   case AT_MSABI:
    CC.$set($this().Context.getTargetInfo().getTriple().isOSWindows() ? CallingConv.CC_C : CallingConv.CC_X86_64Win64);
    break;
   case AT_SysVABI:
    CC.$set($this().Context.getTargetInfo().getTriple().isOSWindows() ? CallingConv.CC_X86_64SysV : CallingConv.CC_C);
    break;
   case AT_Pcs:
    {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        StringRef StrRef/*J*/= new StringRef();
        if (!$this().checkStringLiteralArgumentAttr(attr, 0, StrRef)) {
          attr.setInvalid();
          return true;
        }
        if ($eq_StringRef(/*NO_COPY*/StrRef, /*STRINGREF_STR*/"aapcs")) {
          CC.$set(CallingConv.CC_AAPCS);
          break;
        } else if ($eq_StringRef(/*NO_COPY*/StrRef, /*STRINGREF_STR*/"aapcs-vfp")) {
          CC.$set(CallingConv.CC_AAPCS_VFP);
          break;
        }
        
        attr.setInvalid();
        $c$.clean($c$.track($this().Diag(attr.getLoc(), diag.err_invalid_pcs)));
        return true;
      } finally {
        $c$.$destroy();
      }
    }
   case AT_IntelOclBicc:
    CC.$set(CallingConv.CC_IntelOclBicc);
    break;
   case AT_PreserveMost:
    CC.$set(CallingConv.CC_PreserveMost);
    break;
   case AT_PreserveAll:
    CC.$set(CallingConv.CC_PreserveAll);
    break;
   default:
    throw new llvm_unreachable("unexpected attribute kind");
  }
  
  final /*const*/ TargetInfo /*&*/ TI = $this().Context.getTargetInfo();
  TargetInfo.CallingConvCheckResult A = TI.checkCallingConvention(CC.$deref());
  if (A != TargetInfo.CallingConvCheckResult.CCCR_OK) {
    if (A == TargetInfo.CallingConvCheckResult.CCCR_Warning) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(attr.getLoc(), diag.warn_cconv_ignored)), attr.getName()));
      } finally {
        $c$.$destroy();
      }
    }
    
    // This convention is not valid for the target. Use the default function or
    // method calling convention.
    boolean IsCXXMethod = false;
    boolean IsVariadic = false;
    if ((FD != null)) {
      IsCXXMethod = FD.isCXXInstanceMember();
      IsVariadic = FD.isVariadic();
    }
    CC.$set($this().Context.getDefaultCallingConvention(IsVariadic, IsCXXMethod));
  }
  
  attr.setProcessingCache((/*uint*/int)CC.$deref().getValue());
  return false;
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckNoReturnAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 1692,
 FQN="clang::Sema::CheckNoReturnAttr", NM="_ZN5clang4Sema17CheckNoReturnAttrERKNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZN5clang4Sema17CheckNoReturnAttrERKNS_13AttributeListE")
//</editor-fold>
public final boolean CheckNoReturnAttr(final /*const*/ AttributeList /*&*/ attr) {
  if (!checkAttributeNumArgs(/*Deref*/$this(), attr, 0)) {
    attr.setInvalid();
    return true;
  }
  
  return false;
}


/// \brief Check if the argument \p ArgNum of \p Attr is a ASCII string literal.
/// If not emit an error and return false. If the argument is an identifier it
/// will emit an error with a fixit hint and treat it as if it was a string
/// literal.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::checkStringLiteralArgumentAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 314,
 FQN="clang::Sema::checkStringLiteralArgumentAttr", NM="_ZN5clang4Sema30checkStringLiteralArgumentAttrERKNS_13AttributeListEjRN4llvm9StringRefEPNS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZN5clang4Sema30checkStringLiteralArgumentAttrERKNS_13AttributeListEjRN4llvm9StringRefEPNS_14SourceLocationE")
//</editor-fold>
public final boolean checkStringLiteralArgumentAttr(final /*const*/ AttributeList /*&*/ Attr, 
                              /*uint*/int ArgNum, final StringRef /*&*/ Str) {
  return checkStringLiteralArgumentAttr(Attr, 
                              ArgNum, Str, 
                              (type$ptr<SourceLocation> /*P*/ )null);
}
public final boolean checkStringLiteralArgumentAttr(final /*const*/ AttributeList /*&*/ Attr, 
                              /*uint*/int ArgNum, final StringRef /*&*/ Str, 
                              type$ptr<SourceLocation> /*P*/ ArgLocation/*= null*/) {
  // Look for identifiers. If we have one emit a hint to fix it to a literal.
  if (Attr.isArgIdent(ArgNum)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      IdentifierLoc /*P*/ Loc = Attr.getArgAsIdent(ArgNum);
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc.Loc), diag.err_attribute_argument_type)), 
                      Attr.getName()), AttributeArgumentNType.AANT_ArgumentString), 
              FixItHint.CreateInsertion(/*NO_COPY*/Loc.Loc, new StringRef(/*KEEP_STR*/$DBL_QUOTE))), 
          FixItHint.CreateInsertion($this().getLocForEndOfToken(new SourceLocation(Loc.Loc)), new StringRef(/*KEEP_STR*/$DBL_QUOTE))));
      Str.$assignMove(Loc.Ident.getName());
      if (Native.$bool(ArgLocation)) {
        ArgLocation.$star().$assign(Loc.Loc);
      }
      return true;
    } finally {
      $c$.$destroy();
    }
  }
  
  // Now check for an actual string literal.
  Expr /*P*/ ArgExpr = Attr.getArgAsExpr(ArgNum);
  StringLiteral /*P*/ Literal = dyn_cast_StringLiteral(ArgExpr.IgnoreParenCasts());
  if (Native.$bool(ArgLocation)) {
    ArgLocation.$star().$assignMove(ArgExpr.getLocStart());
  }
  if (!(Literal != null) || !Literal.isAscii()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(ArgExpr.getLocStart(), diag.err_attribute_argument_type)), 
              Attr.getName()), AttributeArgumentNType.AANT_ArgumentString));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  
  Str.$assignMove(Literal.getString());
  return true;
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::checkSectionName">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 2631,
 FQN="clang::Sema::checkSectionName", NM="_ZN5clang4Sema16checkSectionNameENS_14SourceLocationEN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZN5clang4Sema16checkSectionNameENS_14SourceLocationEN4llvm9StringRefE")
//</editor-fold>
public final boolean checkSectionName(SourceLocation LiteralLoc, StringRef SecName) {
  std.string Error = $this().Context.getTargetInfo().isValidSectionSpecifier(new StringRef(SecName));
  if (!Error.empty()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(LiteralLoc), diag.err_attribute_section_invalid_for_target)), Error));
      return false;
    } finally {
      $c$.$destroy();
    }
  }
  return true;
}


// Check for things we'd like to warn about, no errors or validation for now.
// TODO: Validation should use a backend target library that specifies
// the allowable subtarget features and cpus. We could use something like a
// TargetCodeGenInfo hook here to do validation.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::checkTargetAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 2669,
 FQN="clang::Sema::checkTargetAttr", NM="_ZN5clang4Sema15checkTargetAttrENS_14SourceLocationEN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZN5clang4Sema15checkTargetAttrENS_14SourceLocationEN4llvm9StringRefE")
//</editor-fold>
public final void checkTargetAttr(SourceLocation LiteralLoc, StringRef AttrStr) {
  for (/*const*/char$ptr/*char P*/ Str : new /*const*/char$ptr/*char P*//*const*/ [/*2*/] {$("tune="), $("fpmath=")})  {
    if (AttrStr.find(/*STRINGREF_STR*/Str) != StringRef.npos) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(LiteralLoc), diag.warn_unsupported_target_attribute)), Str));
      } finally {
        $c$.$destroy();
      }
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::checkMSInheritanceAttrOnDefinition">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 3334,
 FQN="clang::Sema::checkMSInheritanceAttrOnDefinition", NM="_ZN5clang4Sema34checkMSInheritanceAttrOnDefinitionEPNS_13CXXRecordDeclENS_11SourceRangeEbNS_17MSInheritanceAttr8SpellingE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZN5clang4Sema34checkMSInheritanceAttrOnDefinitionEPNS_13CXXRecordDeclENS_11SourceRangeEbNS_17MSInheritanceAttr8SpellingE")
//</editor-fold>
public final boolean checkMSInheritanceAttrOnDefinition(CXXRecordDecl /*P*/ RD, SourceRange Range, boolean BestCase, 
                                  MSInheritanceAttr.Spelling SemanticSpelling) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    assert (RD.hasDefinition()) : "RD has no definition!";
    
    // We may not have seen base specifiers or any virtual methods yet.  We will
    // have to wait until the record is defined to catch any mismatches.
    if (!RD.getDefinition().isCompleteDefinition()) {
      return false;
    }
    
    // The unspecified model never matches what a definition could need.
    if (SemanticSpelling == MSInheritanceAttr.Spelling.Keyword_unspecified_inheritance) {
      return false;
    }
    if (BestCase) {
      if (RD.calculateInheritanceModel() == SemanticSpelling) {
        return false;
      }
    } else {
      if (RD.calculateInheritanceModel().getValue() <= SemanticSpelling.getValue()) {
        return false;
      }
    }
    
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Range.getBegin(), diag.err_mismatched_ms_inheritance)), 
        0/*definition*/));
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(RD.getDefinition().getLocation(), diag.note_defined_here)), 
        RD.getNameAsString()));
    return true;
  } finally {
    $c$.$destroy();
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckAlignasUnderalignment">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 3297,
 FQN="clang::Sema::CheckAlignasUnderalignment", NM="_ZN5clang4Sema26CheckAlignasUnderalignmentEPNS_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZN5clang4Sema26CheckAlignasUnderalignmentEPNS_4DeclE")
//</editor-fold>
public final void CheckAlignasUnderalignment(Decl /*P*/ D) {
  assert (D.hasAttrs()) : "no attributes on decl";
  
  QualType UnderlyingTy/*J*/= new QualType();
  QualType DiagTy/*J*/= new QualType();
  {
    ValueDecl /*P*/ VD = dyn_cast_ValueDecl(D);
    if ((VD != null)) {
      UnderlyingTy.$assign(DiagTy.$assignMove(VD.getType()));
    } else {
      UnderlyingTy.$assign(DiagTy.$assignMove($this().Context.getTagDeclType(cast_TagDecl(D))));
      {
        EnumDecl /*P*/ ED = dyn_cast_EnumDecl(D);
        if ((ED != null)) {
          UnderlyingTy.$assignMove(ED.getIntegerType());
        }
      }
    }
  }
  if (DiagTy.$arrow().isDependentType() || DiagTy.$arrow().isIncompleteType()) {
    return;
  }
  
  // C++11 [dcl.align]p5, C11 6.7.5/4:
  //   The combined effect of all alignment attributes in a declaration shall
  //   not specify an alignment that is less strict than the alignment that
  //   would otherwise be required for the entity being declared.
  AlignedAttr /*P*/ AlignasAttr = null;
  /*uint*/int Align = 0;
  for (AlignedAttr /*P*/ I : D.specific_attrs(AlignedAttr.class)) {
    if (I.isAlignmentDependent()) {
      return;
    }
    if (I.isAlignas()) {
      AlignasAttr = I;
    }
    Align = std.max(Align, I.getAlignment($this().Context));
  }
  if ((AlignasAttr != null) && (Align != 0)) {
    CharUnits RequestedAlign = $this().Context.toCharUnitsFromBits($uint2long(Align));
    CharUnits NaturalAlign = $this().Context.getTypeAlignInChars(new QualType(UnderlyingTy));
    if (NaturalAlign.$greater(RequestedAlign)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(AlignasAttr.getLocation(), diag.err_alignas_underaligned)), 
                DiagTy), (/*uint*/int)$long2uint(NaturalAlign.getQuantity())));
      } finally {
        $c$.$destroy();
      }
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::PopParsingDeclaration">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 6413,
 FQN="clang::Sema::PopParsingDeclaration", NM="_ZN5clang4Sema21PopParsingDeclarationENS0_23DelayedDiagnosticsStateEPNS_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZN5clang4Sema21PopParsingDeclarationENS0_23DelayedDiagnosticsStateEPNS_4DeclE")
//</editor-fold>
public final void PopParsingDeclaration(DelayedDiagnosticsState state, Decl /*P*/ decl) {
  assert Native.$bool($this().DelayedDiagnostics.getCurrentPool());
  final DelayedDiagnosticPool /*&*/ poppedPool = $Deref($this().DelayedDiagnostics.getCurrentPool());
  $this().DelayedDiagnostics.popWithoutEmitting(new DelayedDiagnosticsState(state));
  
  // When delaying diagnostics to run in the context of a parsed
  // declaration, we only want to actually emit anything if parsing
  // succeeds.
  if (!(decl != null)) {
    return;
  }
  
  // We emit all the active diagnostics in this pool or any of its
  // parents.  In general, we'll get one pool for the decl spec
  // and a child pool for each declarator; in a decl group like:
  //   deprecated_typedef foo, *bar, baz();
  // only the declarator pops will be passed decls.  This is correct;
  // we really do need to consider delayed diagnostics from the decl spec
  // for each of the different declarations.
  /*const*/ DelayedDiagnosticPool /*P*/ pool = $AddrOf(poppedPool);
  do {
    for (type$ptr<DelayedDiagnostic> i = $tryClone(pool.pool_begin()), /*P*/ e = $tryClone(pool.pool_end()); $noteq_ptr(i, e); i.$preInc()) {
      // This const_cast is a bit lame.  Really, Triggered should be mutable.
      final DelayedDiagnostic /*&*/ _diag = ((/*const_cast*/DelayedDiagnostic /*&*/ )(i.$star()));
      if (_diag.Triggered) {
        continue;
      }
      switch (DDKind.valueOf($uchar2int(_diag.Kind))) {
       case Deprecation:
       case Unavailable:
        // Don't bother giving deprecation/unavailable diagnostics if
        // the decl is invalid.
        if (!decl.isInvalidDecl()) {
          handleDelayedAvailabilityCheck(/*Deref*/$this(), _diag, decl);
        }
        break;
       case Access:
        $this().HandleDelayedAccessCheck(_diag, decl);
        break;
       case ForbiddenType:
        handleDelayedForbiddenType(/*Deref*/$this(), _diag, decl);
        break;
      }
    }
  } while (((pool = pool.getParent()) != null));
}


/// Given a set of delayed diagnostics, re-emit them as if they had
/// been delayed in the current context instead of in the given pool.
/// Essentially, this just moves them to the current pool.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::redelayDiagnostics">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 6463,
 FQN="clang::Sema::redelayDiagnostics", NM="_ZN5clang4Sema18redelayDiagnosticsERNS_4sema21DelayedDiagnosticPoolE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZN5clang4Sema18redelayDiagnosticsERNS_4sema21DelayedDiagnosticPoolE")
//</editor-fold>
public final void redelayDiagnostics(final DelayedDiagnosticPool /*&*/ pool) {
  DelayedDiagnosticPool /*P*/ curPool = $this().DelayedDiagnostics.getCurrentPool();
  assert ((curPool != null)) : "re-emitting in undelayed context not supported";
  curPool.steal(pool);
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::EmitAvailabilityWarning">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 6469,
 FQN="clang::Sema::EmitAvailabilityWarning", NM="_ZN5clang4Sema23EmitAvailabilityWarningENS0_22AvailabilityDiagnosticEPNS_9NamedDeclEN4llvm9StringRefENS_14SourceLocationEPKNS_17ObjCInterfaceDeclEPKNS_16ObjCPropertyDeclEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZN5clang4Sema23EmitAvailabilityWarningENS0_22AvailabilityDiagnosticEPNS_9NamedDeclEN4llvm9StringRefENS_14SourceLocationEPKNS_17ObjCInterfaceDeclEPKNS_16ObjCPropertyDeclEb")
//</editor-fold>
public final void EmitAvailabilityWarning(AvailabilityDiagnostic AD, 
                       NamedDecl /*P*/ D, StringRef Message, 
                       SourceLocation Loc, 
                       /*const*/ ObjCInterfaceDecl /*P*/ UnknownObjCClass, 
                       /*const*/ ObjCPropertyDecl /*P*/ ObjCProperty, 
                       boolean ObjCPropertyAccess) {
  // Delay if we're currently parsing a declaration.
  if ($this().DelayedDiagnostics.shouldDelayDiagnostics() && AD != AvailabilityDiagnostic.AD_Partial) {
    $this().DelayedDiagnostics.add(DelayedDiagnostic.makeAvailability(AD, new SourceLocation(Loc), D, UnknownObjCClass, ObjCProperty, new StringRef(Message), 
            ObjCPropertyAccess));
    return;
  }
  
  Decl /*P*/ Ctx = cast_Decl($this().getCurLexicalContext());
  DoEmitAvailabilityWarning(/*Deref*/$this(), AD, Ctx, D, new StringRef(Message), new SourceLocation(Loc), UnknownObjCClass, 
      ObjCProperty, ObjCPropertyAccess);
}


/// DeclClonePragmaWeak - clone existing decl (maybe definition),
/// \#pragma weak needs a non-definition decl and source may not have one.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::DeclClonePragmaWeak">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 6016,
 FQN="clang::Sema::DeclClonePragmaWeak", NM="_ZN5clang4Sema19DeclClonePragmaWeakEPNS_9NamedDeclEPNS_14IdentifierInfoENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZN5clang4Sema19DeclClonePragmaWeakEPNS_9NamedDeclEPNS_14IdentifierInfoENS_14SourceLocationE")
//</editor-fold>
public final NamedDecl /*P*/ DeclClonePragmaWeak(NamedDecl /*P*/ ND, IdentifierInfo /*P*/ II, 
                   SourceLocation Loc) {
  assert (isa_FunctionDecl(ND) || isa_VarDecl(ND));
  NamedDecl /*P*/ NewD = null;
  {
    FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(ND);
    if ((FD != null)) {
      FunctionDecl /*P*/ NewFD;
      // FIXME: Missing call to CheckFunctionDeclaration().
      // FIXME: Mangling?
      // FIXME: Is the qualifier info correct?
      // FIXME: Is the DeclContext correct?
      NewFD = FunctionDecl.Create(FD.getASTContext(), FD.getDeclContext(), 
          new SourceLocation(Loc), new SourceLocation(Loc), new DeclarationName(II), 
          FD.getType(), FD.getTypeSourceInfo(), 
          StorageClass.SC_None, false/*isInlineSpecified*/, 
          FD.hasPrototype(), 
          false/*isConstexprSpecified*/);
      NewD = NewFD;
      if ((FD.getQualifier() != null)) {
        NewFD.setQualifierInfo(FD.getQualifierLoc());
      }
      
      // Fake up parameter variables; they are declared as if this were
      // a typedef.
      QualType FDTy = FD.getType();
      {
        /*const*/ FunctionProtoType /*P*/ FT = FDTy.$arrow().getAs(FunctionProtoType.class);
        if ((FT != null)) {
          SmallVector<ParmVarDecl /*P*/ > Params/*J*/= new SmallVector<ParmVarDecl /*P*/ >(16, (ParmVarDecl /*P*/ )null);
          for (final /*const*/ QualType /*&*/ AI : FT.param_types()) {
            ParmVarDecl /*P*/ Param = $this().BuildParmVarDeclForTypedef(NewFD, new SourceLocation(Loc), new QualType(AI));
            Param.setScopeInfo(0, Params.size());
            Params.push_back(Param);
          }
          NewFD.setParams(new ArrayRef<ParmVarDecl /*P*/ >(Params, true));
        }
      }
    } else {
      VarDecl /*P*/ VD = dyn_cast_VarDecl(ND);
      if ((VD != null)) {
        NewD = VarDecl.Create(VD.getASTContext(), VD.getDeclContext(), 
            VD.getInnerLocStart(), VD.getLocation(), II, 
            VD.getType(), VD.getTypeSourceInfo(), 
            VD.getStorageClass());
        if ((VD.getQualifier() != null)) {
          VarDecl /*P*/ NewVD = cast_VarDecl(NewD);
          NewVD.setQualifierInfo(VD.getQualifierLoc());
        }
      }
    }
  }
  return NewD;
}


/// DeclApplyPragmaWeak - A declaration (maybe definition) needs \#pragma weak
/// applied to it, possibly with an alias.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::DeclApplyPragmaWeak">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 6064,
 FQN="clang::Sema::DeclApplyPragmaWeak", NM="_ZN5clang4Sema19DeclApplyPragmaWeakEPNS_5ScopeEPNS_9NamedDeclERNS_8WeakInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZN5clang4Sema19DeclApplyPragmaWeakEPNS_5ScopeEPNS_9NamedDeclERNS_8WeakInfoE")
//</editor-fold>
public final void DeclApplyPragmaWeak(Scope /*P*/ S, NamedDecl /*P*/ ND, final WeakInfo /*&*/ W) {
  if (W.getUsed()) {
    return; // only do this once
  }
  W.setUsed(true);
  if ((W.getAlias() != null)) { // clone decl, impersonate __attribute(weak,alias(...))
    IdentifierInfo /*P*/ NDId = ND.getIdentifier();
    NamedDecl /*P*/ NewD = $this().DeclClonePragmaWeak(ND, W.getAlias(), W.getLocation());
    NewD.addAttr(AliasAttr.CreateImplicit($this().Context, NDId.getName(), 
            new SourceRange(W.getLocation())));
    NewD.addAttr(WeakAttr.CreateImplicit($this().Context, new SourceRange(W.getLocation())));
    $this().WeakTopLevelDecl.push_back(NewD);
    // FIXME: "hideous" code from Sema::LazilyCreateBuiltin
    // to insert Decl at TU scope, sorry.
    DeclContext /*P*/ SavedContext = $this().CurContext;
    $this().CurContext = $this().Context.getTranslationUnitDecl();
    NewD.setDeclContext($this().CurContext);
    NewD.setLexicalDeclContext($this().CurContext);
    $this().PushOnScopeChains(NewD, S);
    $this().CurContext = SavedContext;
  } else { // just add weak to existing
    ND.addAttr(WeakAttr.CreateImplicit($this().Context, new SourceRange(W.getLocation())));
  }
}


/// AddAlignedAttr - Adds an aligned attribute to a particular declaration.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::AddAlignedAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 3184,
 FQN="clang::Sema::AddAlignedAttr", NM="_ZN5clang4Sema14AddAlignedAttrENS_11SourceRangeEPNS_4DeclEPNS_4ExprEjb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZN5clang4Sema14AddAlignedAttrENS_11SourceRangeEPNS_4DeclEPNS_4ExprEjb")
//</editor-fold>
public final void AddAlignedAttr(SourceRange AttrRange, Decl /*P*/ D, Expr /*P*/ E, 
              /*uint*/int SpellingListIndex, boolean IsPackExpansion) {
  AlignedAttr TmpAttr/*J*/= new AlignedAttr(new SourceRange(AttrRange), $this().Context, true, E, SpellingListIndex);
  SourceLocation AttrLoc = AttrRange.getBegin();
  
  // C++11 alignas(...) and C11 _Alignas(...) have additional requirements.
  if (TmpAttr.isAlignas()) {
    // C++11 [dcl.align]p1:
    //   An alignment-specifier may be applied to a variable or to a class
    //   data member, but it shall not be applied to a bit-field, a function
    //   parameter, the formal parameter of a catch clause, or a variable
    //   declared with the register storage class specifier. An
    //   alignment-specifier may also be applied to the declaration of a class
    //   or enumeration type.
    // C11 6.7.5/2:
    //   An alignment attribute shall not be specified in a declaration of
    //   a typedef, or a bit-field, or a function, or a parameter, or an
    //   object declared with the register storage-class specifier.
    int DiagKind = -1;
    if (isa_ParmVarDecl(D)) {
      DiagKind = 0;
    } else {
      VarDecl /*P*/ VD = dyn_cast_VarDecl(D);
      if ((VD != null)) {
        if (VD.getStorageClass() == StorageClass.SC_Register) {
          DiagKind = 1;
        }
        if (VD.isExceptionVariable()) {
          DiagKind = 2;
        }
      } else {
        FieldDecl /*P*/ FD = dyn_cast_FieldDecl(D);
        if ((FD != null)) {
          if (FD.isBitField()) {
            DiagKind = 3;
          }
        } else if (!isa_TagDecl(D)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(AttrLoc), diag.err_attribute_wrong_decl_type)), $AddrOf(TmpAttr)), 
                (TmpAttr.isC11() ? AttributeDeclKind.ExpectedVariableOrField : AttributeDeclKind.ExpectedVariableFieldOrTag)));
            return;
          } finally {
            $c$.$destroy();
          }
        }
      }
    }
    if (DiagKind != -1) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(AttrLoc), diag.err_alignas_attribute_wrong_decl_type)), 
                $AddrOf(TmpAttr)), DiagKind));
        return;
      } finally {
        $c$.$destroy();
      }
    }
  }
  if (E.isTypeDependent() || E.isValueDependent()) {
    // Save dependent expressions in the AST to be instantiated.
    AlignedAttr /*P*/ AA = /*FIXME:NEW_EXPR*//*::*//*new (Context)*/ new AlignedAttr(TmpAttr);
    AA.setPackExpansion(IsPackExpansion);
    D.addAttr(AA);
    return;
  }
  
  // FIXME: Cache the number on the Attr object?
  APSInt Alignment/*J*/= new APSInt();
  ActionResultTTrue<Expr /*P*/ > ICE = $this().VerifyIntegerConstantExpression(E, $AddrOf(Alignment), 
      diag.err_aligned_attribute_argument_not_int, 
      /*AllowFold*/ false);
  if (ICE.isInvalid()) {
    return;
  }
  
  long/*uint64_t*/ AlignVal = Alignment.getZExtValue();
  
  // C++11 [dcl.align]p2:
  //   -- if the constant expression evaluates to zero, the alignment
  //      specifier shall have no effect
  // C11 6.7.5p6:
  //   An alignment specification of zero has no effect.
  if (!(TmpAttr.isAlignas() && Alignment.$not())) {
    if (!llvm.isPowerOf2_64(AlignVal)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(AttrLoc), diag.err_alignment_not_power_of_two)), 
            E.getSourceRange()));
        return;
      } finally {
        $c$.$destroy();
      }
    }
  }
  
  // Alignment calculations can wrap around if it's greater than 2**28.
  /*uint*/int MaxValidAlignment = $this().Context.getTargetInfo().getTriple().isOSBinFormatCOFF() ? 8192 : 268435456;
  if ($greater_ulong_uint(AlignVal, MaxValidAlignment)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(AttrLoc), diag.err_attribute_aligned_too_great)), MaxValidAlignment), 
          E.getSourceRange()));
      return;
    } finally {
      $c$.$destroy();
    }
  }
  if ($this().Context.getTargetInfo().isTLSSupported()) {
    /*uint*/int MaxTLSAlign = $long2uint($this().Context.toCharUnitsFromBits($ushort2long($this().Context.getTargetInfo().getMaxTLSAlign())).
        getQuantity());
    VarDecl /*P*/ VD = dyn_cast_VarDecl(D);
    if ((MaxTLSAlign != 0) && $greater_ulong_uint(AlignVal, MaxTLSAlign) && (VD != null)
       && VD.getTLSKind() != VarDecl.TLSKind.TLS_None) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(VD.getLocation(), diag.err_tls_var_aligned_over_maximum)), 
                    (/*uint*/int)$ulong2uint(AlignVal)), VD), MaxTLSAlign));
        return;
      } finally {
        $c$.$destroy();
      }
    }
  }
  
  AlignedAttr /*P*/ AA = /*FIXME:NEW_EXPR*//*::*//*new (Context)*/ new AlignedAttr(new SourceRange(AttrRange), $this().Context, true, 
      ICE.get(), SpellingListIndex);
  AA.setPackExpansion(IsPackExpansion);
  D.addAttr(AA);
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::AddAlignedAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 3287,
 FQN="clang::Sema::AddAlignedAttr", NM="_ZN5clang4Sema14AddAlignedAttrENS_11SourceRangeEPNS_4DeclEPNS_14TypeSourceInfoEjb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZN5clang4Sema14AddAlignedAttrENS_11SourceRangeEPNS_4DeclEPNS_14TypeSourceInfoEjb")
//</editor-fold>
public final void AddAlignedAttr(SourceRange AttrRange, Decl /*P*/ D, TypeSourceInfo /*P*/ TS, 
              /*uint*/int SpellingListIndex, boolean IsPackExpansion) {
  // FIXME: Cache the number on the Attr object if non-dependent?
  // FIXME: Perform checking of type validity
  AlignedAttr /*P*/ AA = /*FIXME:NEW_EXPR*//*::*//*new (Context)*/ new AlignedAttr(new SourceRange(AttrRange), $this().Context, false, TS, 
      SpellingListIndex);
  AA.setPackExpansion(IsPackExpansion);
  D.addAttr(AA);
}


/// AddAssumeAlignedAttr - Adds an assume_aligned attribute to a particular
/// declaration.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::AddAssumeAlignedAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 1317,
 FQN="clang::Sema::AddAssumeAlignedAttr", NM="_ZN5clang4Sema20AddAssumeAlignedAttrENS_11SourceRangeEPNS_4DeclEPNS_4ExprES5_j",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZN5clang4Sema20AddAssumeAlignedAttrENS_11SourceRangeEPNS_4DeclEPNS_4ExprES5_j")
//</editor-fold>
public final void AddAssumeAlignedAttr(SourceRange AttrRange, Decl /*P*/ D, Expr /*P*/ E, 
                    Expr /*P*/ OE, /*uint*/int SpellingListIndex) {
  QualType ResultType = getFunctionOrMethodResultType(D);
  SourceRange SR = getFunctionOrMethodResultSourceRange(D);
  
  AssumeAlignedAttr TmpAttr/*J*/= new AssumeAlignedAttr(new SourceRange(AttrRange), $this().Context, E, OE, SpellingListIndex);
  SourceLocation AttrLoc = AttrRange.getBegin();
  if (!$this().isValidPointerAttrType(new QualType(ResultType), /* RefOkay */ true)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(AttrLoc), diag.warn_attribute_return_pointers_refs_only)), 
                  $AddrOf(TmpAttr)), AttrRange), SR));
      return;
    } finally {
      $c$.$destroy();
    }
  }
  if (!E.isValueDependent()) {
    APSInt I/*J*/= new APSInt(64);
    if (!E.isIntegerConstantExpr(I, $this().Context)) {
      if ((OE != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(AttrLoc), diag.err_attribute_argument_n_type)), 
                          $AddrOf(TmpAttr)), 1), AttributeArgumentNType.AANT_ArgumentIntegerConstant), 
              E.getSourceRange()));
        } finally {
          $c$.$destroy();
        }
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(AttrLoc), diag.err_attribute_argument_type)), 
                      $AddrOf(TmpAttr)), AttributeArgumentNType.AANT_ArgumentIntegerConstant), 
              E.getSourceRange()));
        } finally {
          $c$.$destroy();
        }
      }
      return;
    }
    if (!I.isPowerOf2()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(AttrLoc), diag.err_alignment_not_power_of_two)), 
            E.getSourceRange()));
        return;
      } finally {
        $c$.$destroy();
      }
    }
  }
  if ((OE != null)) {
    if (!OE.isValueDependent()) {
      APSInt I/*J*/= new APSInt(64);
      if (!OE.isIntegerConstantExpr(I, $this().Context)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(AttrLoc), diag.err_attribute_argument_n_type)), 
                          $AddrOf(TmpAttr)), 2), AttributeArgumentNType.AANT_ArgumentIntegerConstant), 
              OE.getSourceRange()));
          return;
        } finally {
          $c$.$destroy();
        }
      }
    }
  }
  
  D.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (Context)*/ new AssumeAlignedAttr(new SourceRange(AttrRange), $this().Context, E, OE, SpellingListIndex));
}


/// AddAlignValueAttr - Adds an align_value attribute to a particular
/// declaration.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::AddAlignValueAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 3101,
 FQN="clang::Sema::AddAlignValueAttr", NM="_ZN5clang4Sema17AddAlignValueAttrENS_11SourceRangeEPNS_4DeclEPNS_4ExprEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZN5clang4Sema17AddAlignValueAttrENS_11SourceRangeEPNS_4DeclEPNS_4ExprEj")
//</editor-fold>
public final void AddAlignValueAttr(SourceRange AttrRange, Decl /*P*/ D, Expr /*P*/ E, 
                 /*uint*/int SpellingListIndex) {
  AlignValueAttr TmpAttr/*J*/= new AlignValueAttr(new SourceRange(AttrRange), $this().Context, E, SpellingListIndex);
  SourceLocation AttrLoc = AttrRange.getBegin();
  
  QualType T/*J*/= new QualType();
  {
    TypedefNameDecl /*P*/ TD = dyn_cast_TypedefNameDecl(D);
    if ((TD != null)) {
      T.$assignMove(TD.getUnderlyingType());
    } else {
      ValueDecl /*P*/ VD = dyn_cast_ValueDecl(D);
      if ((VD != null)) {
        T.$assignMove(VD.getType());
      } else {
        throw new llvm_unreachable("Unknown decl type for align_value");
      }
    }
  }
  if (!T.$arrow().isDependentType() && !T.$arrow().isAnyPointerType()
     && !T.$arrow().isReferenceType() && !T.$arrow().isMemberPointerType()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(AttrLoc), diag.warn_attribute_pointer_or_reference_only)), 
                  $AddrOf(TmpAttr)), T), D.getSourceRange()));
      return;
    } finally {
      $c$.$destroy();
    }
  }
  if (!E.isValueDependent()) {
    APSInt Alignment/*J*/= new APSInt();
    ActionResultTTrue<Expr /*P*/ > ICE = $this().VerifyIntegerConstantExpression(E, $AddrOf(Alignment), 
        diag.err_align_value_attribute_argument_not_int, 
        /*AllowFold*/ false);
    if (ICE.isInvalid()) {
      return;
    }
    if (!Alignment.isPowerOf2()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(AttrLoc), diag.err_alignment_not_power_of_two)), 
            E.getSourceRange()));
        return;
      } finally {
        $c$.$destroy();
      }
    }
    
    D.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (Context)*/ new AlignValueAttr(new SourceRange(AttrRange), $this().Context, ICE.get(), 
            SpellingListIndex));
    return;
  }
  
  // Save dependent expressions in the AST to be instantiated.
  D.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (Context)*/ new AlignValueAttr(TmpAttr));
}


/// AddLaunchBoundsAttr - Adds a launch_bounds attribute to a particular
/// declaration.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::AddLaunchBoundsAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 4084,
 FQN="clang::Sema::AddLaunchBoundsAttr", NM="_ZN5clang4Sema19AddLaunchBoundsAttrENS_11SourceRangeEPNS_4DeclEPNS_4ExprES5_j",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZN5clang4Sema19AddLaunchBoundsAttrENS_11SourceRangeEPNS_4DeclEPNS_4ExprES5_j")
//</editor-fold>
public final void AddLaunchBoundsAttr(SourceRange AttrRange, Decl /*P*/ D, Expr /*P*/ MaxThreads, 
                   Expr /*P*/ MinBlocks, /*uint*/int SpellingListIndex) {
  CUDALaunchBoundsAttr TmpAttr/*J*/= new CUDALaunchBoundsAttr(new SourceRange(AttrRange), $this().Context, MaxThreads, MinBlocks, 
      SpellingListIndex);
  MaxThreads = makeLaunchBoundsArgExpr(/*Deref*/$this(), MaxThreads, TmpAttr, 0);
  if (MaxThreads == null) {
    return;
  }
  if ((MinBlocks != null)) {
    MinBlocks = makeLaunchBoundsArgExpr(/*Deref*/$this(), MinBlocks, TmpAttr, 1);
    if (MinBlocks == null) {
      return;
    }
  }
  
  D.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (Context)*/ new CUDALaunchBoundsAttr(new SourceRange(AttrRange), $this().Context, MaxThreads, MinBlocks, SpellingListIndex));
}


/// AddModeAttr - Adds a mode attribute to a particular declaration.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::AddModeAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 3439,
 FQN="clang::Sema::AddModeAttr", NM="_ZN5clang4Sema11AddModeAttrENS_11SourceRangeEPNS_4DeclEPNS_14IdentifierInfoEjb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZN5clang4Sema11AddModeAttrENS_11SourceRangeEPNS_4DeclEPNS_14IdentifierInfoEjb")
//</editor-fold>
public final void AddModeAttr(SourceRange AttrRange, Decl /*P*/ D, IdentifierInfo /*P*/ Name, 
           /*uint*/int SpellingListIndex) {
  AddModeAttr(AttrRange, D, Name, 
           SpellingListIndex, false);
}
public final void AddModeAttr(SourceRange AttrRange, Decl /*P*/ D, IdentifierInfo /*P*/ Name, 
           /*uint*/int SpellingListIndex, boolean InInstantiation/*= false*/) {
  StringRef Str = Name.getName();
  normalizeName(Str);
  SourceLocation AttrLoc = AttrRange.getBegin();
  
  uint$ref DestWidth = create_uint$ref(0);
  bool$ref IntegerMode = create_bool$ref(true);
  bool$ref ComplexMode = create_bool$ref(false);
  APInt VectorSize/*J*/= new APInt(64, 0);
  if ($greatereq_uint(Str.size(), 4) && Str.$at(0) == $$V) {
    // Minimal length of vector mode is 4: 'V' + NUMBER(>=1) + TYPE(>=2).
    /*size_t*/int StrSize = Str.size();
    /*size_t*/int VectorStringLength = 0;
    while ($less_uint((VectorStringLength + 1), StrSize)
       && (isdigit(Str.$at(VectorStringLength + 1)) != 0)) {
      ++VectorStringLength;
    }
    if ((VectorStringLength != 0)
       && !Str.substr(1, VectorStringLength).getAsInteger(10, VectorSize)
       && VectorSize.isPowerOf2()) {
      parseModeAttrArg(/*Deref*/$this(), Str.substr(VectorStringLength + 1), DestWidth, 
          IntegerMode, ComplexMode);
      // Avoid duplicate warning from template instantiation.
      if (!InInstantiation) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag(new SourceLocation(AttrLoc), diag.warn_vector_mode_deprecated)));
        } finally {
          $c$.$destroy();
        }
      }
    } else {
      VectorSize.$assign(0);
    }
  }
  if (VectorSize.$not()) {
    parseModeAttrArg(/*Deref*/$this(), new StringRef(Str), DestWidth, IntegerMode, ComplexMode);
  }
  
  // FIXME: Sync this with InitializePredefinedMacros; we need to match int8_t
  // and friends, at least with glibc.
  // FIXME: Make sure floating-point mappings are accurate
  // FIXME: Support XF and TF types
  if (!(DestWidth.$deref() != 0)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(AttrLoc), diag.err_machine_mode)), 0/*Unknown*/), Name));
      return;
    } finally {
      $c$.$destroy();
    }
  }
  
  QualType OldTy/*J*/= new QualType();
  {
    TypedefNameDecl /*P*/ TD = dyn_cast_TypedefNameDecl(D);
    if ((TD != null)) {
      OldTy.$assignMove(TD.getUnderlyingType());
    } else {
      EnumDecl /*P*/ ED = dyn_cast_EnumDecl(D);
      if ((ED != null)) {
        // Something like 'typedef enum { X } __attribute__((mode(XX))) T;'.
        // Try to get type from enum declaration, default to int.
        OldTy.$assignMove(ED.getIntegerType());
        if (OldTy.isNull()) {
          OldTy.$assignMove($this().Context.IntTy.$QualType());
        }
      } else {
        OldTy.$assignMove(cast_ValueDecl(D).getType());
      }
    }
  }
  if (OldTy.$arrow().isDependentType()) {
    D.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (Context)*/ new ModeAttr(new SourceRange(AttrRange), $this().Context, Name, SpellingListIndex));
    return;
  }
  
  // Base type can also be a vector type (see PR17453).
  // Distinguish between base type and base element type.
  QualType OldElemTy = new QualType(OldTy);
  {
    /*const*/ VectorType /*P*/ VT = OldTy.$arrow().getAs(VectorType.class);
    if ((VT != null)) {
      OldElemTy.$assignMove(VT.getElementType());
    }
  }
  
  // GCC allows 'mode' attribute on enumeration types (even incomplete), except
  // for vector modes. So, 'enum X __attribute__((mode(QI)));' forms a complete
  // type, 'enum { A } __attribute__((mode(V4SI)))' is rejected.
  if ((isa_EnumDecl(D) || (OldElemTy.$arrow().getAs$EnumType() != null))
     && VectorSize.getBoolValue()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(AttrLoc), diag.err_enum_mode_vector_type)), Name), AttrRange));
      return;
    } finally {
      $c$.$destroy();
    }
  }
  boolean IntegralOrAnyEnumType = OldElemTy.$arrow().isIntegralOrEnumerationType() || (OldElemTy.$arrow().getAs$EnumType() != null);
  if (!(OldElemTy.$arrow().getAs$BuiltinType() != null) && !OldElemTy.$arrow().isComplexType()
     && !IntegralOrAnyEnumType) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track($this().Diag(new SourceLocation(AttrLoc), diag.err_mode_not_primitive)));
    } finally {
      $c$.$destroy();
    }
  } else if (IntegerMode.$deref()) {
    if (!IntegralOrAnyEnumType) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track($this().Diag(new SourceLocation(AttrLoc), diag.err_mode_wrong_type)));
      } finally {
        $c$.$destroy();
      }
    }
  } else if (ComplexMode.$deref()) {
    if (!OldElemTy.$arrow().isComplexType()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track($this().Diag(new SourceLocation(AttrLoc), diag.err_mode_wrong_type)));
      } finally {
        $c$.$destroy();
      }
    }
  } else {
    if (!OldElemTy.$arrow().isFloatingType()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track($this().Diag(new SourceLocation(AttrLoc), diag.err_mode_wrong_type)));
      } finally {
        $c$.$destroy();
      }
    }
  }
  
  QualType NewElemTy/*J*/= new QualType();
  if (IntegerMode.$deref()) {
    NewElemTy.$assignMove($this().Context.getIntTypeForBitwidth(DestWidth.$deref(), 
            (OldElemTy.$arrow().isSignedIntegerType() ? 1 : 0)));
  } else {
    NewElemTy.$assignMove($this().Context.getRealTypeForBitwidth(DestWidth.$deref()));
  }
  if (NewElemTy.isNull()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(AttrLoc), diag.err_machine_mode)), 1/*Unsupported*/), Name));
      return;
    } finally {
      $c$.$destroy();
    }
  }
  if (ComplexMode.$deref()) {
    NewElemTy.$assignMove($this().Context.getComplexType(new QualType(NewElemTy)));
  }
  
  QualType NewTy = new QualType(NewElemTy);
  if (VectorSize.getBoolValue()) {
    NewTy.$assignMove($this().Context.getVectorType(new QualType(NewTy), $ulong2uint(VectorSize.getZExtValue()), 
            VectorType.VectorKind.GenericVector));
  } else {
    /*const*/ VectorType /*P*/ OldVT = OldTy.$arrow().getAs(VectorType.class);
    if ((OldVT != null)) {
      // Complex machine mode does not support base vector types.
      if (ComplexMode.$deref()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag(new SourceLocation(AttrLoc), diag.err_complex_mode_vector_type)));
          return;
        } finally {
          $c$.$destroy();
        }
      }
      /*uint*/int NumElements = $ullong2uint($div_ullong_ulong($this().Context.getTypeSize(new QualType(OldElemTy))
         * $uint2ullong(OldVT.getNumElements())
        , $this().Context.getTypeSize(new QualType(NewElemTy))));
      NewTy.$assignMove(
          $this().Context.getVectorType(new QualType(NewElemTy), NumElements, OldVT.getVectorKind())
      );
    }
  }
  if (NewTy.isNull()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track($this().Diag(new SourceLocation(AttrLoc), diag.err_mode_wrong_type)));
      return;
    } finally {
      $c$.$destroy();
    }
  }
  {
    
    // Install the new type.
    TypedefNameDecl /*P*/ TD = dyn_cast_TypedefNameDecl(D);
    if ((TD != null)) {
      TD.setModedTypeSourceInfo(TD.getTypeSourceInfo(), new QualType(NewTy));
    } else {
      EnumDecl /*P*/ ED = dyn_cast_EnumDecl(D);
      if ((ED != null)) {
        ED.setIntegerType(new QualType(NewTy));
      } else {
        cast_ValueDecl(D).setType(new QualType(NewTy));
      }
    }
  }
  
  D.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (Context)*/ new ModeAttr(new SourceRange(AttrRange), $this().Context, Name, SpellingListIndex));
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::AddParameterABIAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 3956,
 FQN="clang::Sema::AddParameterABIAttr", NM="_ZN5clang4Sema19AddParameterABIAttrENS_11SourceRangeEPNS_4DeclENS_12ParameterABIEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZN5clang4Sema19AddParameterABIAttrENS_11SourceRangeEPNS_4DeclENS_12ParameterABIEj")
//</editor-fold>
public final void AddParameterABIAttr(SourceRange range, Decl /*P*/ D, ParameterABI abi, 
                   /*uint*/int spellingIndex) {
  
  QualType type = cast_ParmVarDecl(D).getType();
  {
    
    ParameterABIAttr /*P*/ existingAttr = D.getAttr(ParameterABIAttr.class);
    if ((existingAttr != null)) {
      if (existingAttr.getABI() != abi) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(range.getBegin(), diag.err_attributes_are_not_compatible)), 
                  getParameterABISpelling(abi)), existingAttr));
          $c$.clean($c$.track($this().Diag(existingAttr.getLocation(), diag.note_conflicting_attribute)));
          return;
        } finally {
          $c$.$destroy();
        }
      }
    }
  }
  switch (abi) {
   case Ordinary:
    throw new llvm_unreachable("explicit attribute for ordinary parameter ABI?");
   case SwiftContext:
    if (!isValidSwiftContextType(new QualType(type))) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(range.getBegin(), diag.err_swift_abi_parameter_wrong_type)), 
                    getParameterABISpelling(abi)), 
                /*pointer to pointer */ 0), type));
      } finally {
        $c$.$destroy();
      }
    }
    D.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (Context)*/ new SwiftContextAttr(new SourceRange(range), $this().Context, spellingIndex));
    return;
   case SwiftErrorResult:
    if (!isValidSwiftErrorResultType(new QualType(type))) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(range.getBegin(), diag.err_swift_abi_parameter_wrong_type)), 
                    getParameterABISpelling(abi)), 
                /*pointer to pointer */ 1), type));
      } finally {
        $c$.$destroy();
      }
    }
    D.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (Context)*/ new SwiftErrorResultAttr(new SourceRange(range), $this().Context, spellingIndex));
    return;
   case SwiftIndirectResult:
    if (!isValidSwiftIndirectResultType(new QualType(type))) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(range.getBegin(), diag.err_swift_abi_parameter_wrong_type)), 
                    getParameterABISpelling(abi)), 
                /*pointer*/ 0), type));
      } finally {
        $c$.$destroy();
      }
    }
    D.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (Context)*/ new SwiftIndirectResultAttr(new SourceRange(range), $this().Context, spellingIndex));
    return;
  }
  throw new llvm_unreachable("bad parameter ABI attribute");
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::AddNSConsumedAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp", line = 4215,
 FQN="clang::Sema::AddNSConsumedAttr", NM="_ZN5clang4Sema17AddNSConsumedAttrENS_11SourceRangeEPNS_4DeclEjbb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDeclAttr.cpp -nm=_ZN5clang4Sema17AddNSConsumedAttrENS_11SourceRangeEPNS_4DeclEjbb")
//</editor-fold>
public final void AddNSConsumedAttr(SourceRange attrRange, Decl /*P*/ D, 
                 /*uint*/int spellingIndex, boolean isNSConsumed, 
                 boolean isTemplateInstantiation) {
  ParmVarDecl /*P*/ param = cast_ParmVarDecl(D);
  boolean typeOK;
  if (isNSConsumed) {
    typeOK = isValidSubjectOfNSAttribute(/*Deref*/$this(), param.getType());
  } else {
    typeOK = isValidSubjectOfCFAttribute(/*Deref*/$this(), param.getType());
  }
  if (!typeOK) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // These attributes are normally just advisory, but in ARC, ns_consumed
      // is significant.  Allow non-dependent code to contain inappropriate
      // attributes even in ARC, but require template instantiations to be
      // set up correctly.
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(D.getLocStart(), 
                      (isTemplateInstantiation && isNSConsumed
                         && $this().getLangOpts().ObjCAutoRefCount ? diag.err_ns_attribute_wrong_parameter_type : diag.warn_ns_attribute_wrong_parameter_type))), 
                  attrRange), 
              (isNSConsumed ? $("ns_consumed") : $("cf_consumed"))), 
          (isNSConsumed ? /*objc pointers*/ 0 : /*cf pointers*/ 1)));
      return;
    } finally {
      $c$.$destroy();
    }
  }
  if (isNSConsumed) {
    param.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (Context)*/ new NSConsumedAttr(new SourceRange(attrRange), $this().Context, spellingIndex));
  } else {
    param.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (Context)*/ new CFConsumedAttr(new SourceRange(attrRange), $this().Context, spellingIndex));
  }
}

} // END OF class Sema_SemaDeclAttr
