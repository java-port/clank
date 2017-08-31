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

import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.lex.*;
import static org.clang.sema.Sema.*;
import static org.clang.sema.Sema_NestedClasses.SemaDiagnosticBuilder.*;
import static org.clang.ast.QualType.*;
import static org.clang.ast.AstClangGlobals.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import org.clang.basic.llvm.DenseMapInfoSelector;
import static org.clang.sema.impl.SemaObjCPropertyStatics.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.java.AstTypesRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type Sema_SemaObjCProperty">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this -extends=Sema_SemaLookup ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaObjCProperty.cpp -nm=_ZN5clang4Sema13ActOnPropertyEPNS_5ScopeENS_14SourceLocationES3_RNS_15FieldDeclaratorERNS_12ObjCDeclSpecENS_8SelectorES8_NS_3tok15ObjCKeywordKindEPNS_11DeclContextE;_ZN5clang4Sema18CreatePropertyDeclEPNS_5ScopeEPNS_17ObjCContainerDeclENS_14SourceLocationES5_RNS_15FieldDeclaratorENS_8SelectorES8_bjjNS_8QualTypeEPNS_14TypeSourceInfoENS_3tok15ObjCKeywordKindEPNS_11DeclContextE;_ZN5clang4Sema19ProcessPropertyDeclEPNS_16ObjCPropertyDeclE;_ZN5clang4Sema21ActOnPropertyImplDeclEPNS_5ScopeENS_14SourceLocationES3_bPNS_14IdentifierInfoES5_S3_NS_21ObjCPropertyQueryKindE;_ZN5clang4Sema24DiagnosePropertyMismatchEPNS_16ObjCPropertyDeclES2_PKNS_14IdentifierInfoEb;_ZN5clang4Sema27CheckObjCPropertyAttributesEPNS_4DeclENS_14SourceLocationERjb;_ZN5clang4Sema27DefaultSynthesizePropertiesEPNS_5ScopeEPNS_12ObjCImplDeclEPNS_17ObjCInterfaceDeclE;_ZN5clang4Sema27DefaultSynthesizePropertiesEPNS_5ScopeEPNS_4DeclE;_ZN5clang4Sema30HandlePropertyInClassExtensionEPNS_5ScopeENS_14SourceLocationES3_RNS_15FieldDeclaratorENS_8SelectorES6_bRjjNS_8QualTypeEPNS_14TypeSourceInfoENS_3tok15ObjCKeywordKindE;_ZN5clang4Sema30IvarBacksCurrentMethodAccessorEPNS_17ObjCInterfaceDeclEPNS_14ObjCMethodDeclEPNS_12ObjCIvarDeclE;_ZN5clang4Sema31AtomicPropertySetterGetterRulesEPNS_12ObjCImplDeclEPNS_17ObjCInterfaceDeclE;_ZN5clang4Sema31DiagnoseUnimplementedPropertiesEPNS_5ScopeEPNS_12ObjCImplDeclEPNS_17ObjCContainerDeclEb;_ZN5clang4Sema32DiagnosePropertyAccessorMismatchEPNS_16ObjCPropertyDeclEPNS_14ObjCMethodDeclENS_14SourceLocationE;_ZN5clang4Sema37DiagnoseOwningPropertyGetterSynthesisEPKNS_22ObjCImplementationDeclE;_ZN5clang4Sema38DiagnoseMissingDesignatedInitOverridesEPKNS_22ObjCImplementationDeclEPKNS_17ObjCInterfaceDeclE;_ZN5clang4Sema40diagnoseNullResettableSynthesizedSettersEPKNS_12ObjCImplDeclE; -static-type=Sema_SemaObjCProperty -package=org.clang.sema")
//</editor-fold>
public class Sema_SemaObjCProperty extends Sema_SemaLookup {
private final /*split clang::Sema*/ Sema $this() { return (Sema)this; }


/// DiagnoseUnimplementedProperties - This routine warns on those properties
/// which must be implemented by this implementation.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::DiagnoseUnimplementedProperties">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*make_pair*/,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaObjCProperty.cpp", line = 1806,
 FQN="clang::Sema::DiagnoseUnimplementedProperties", NM="_ZN5clang4Sema31DiagnoseUnimplementedPropertiesEPNS_5ScopeEPNS_12ObjCImplDeclEPNS_17ObjCContainerDeclEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaObjCProperty.cpp -nm=_ZN5clang4Sema31DiagnoseUnimplementedPropertiesEPNS_5ScopeEPNS_12ObjCImplDeclEPNS_17ObjCContainerDeclEb")
//</editor-fold>
public final void DiagnoseUnimplementedProperties(Scope /*P*/ S, ObjCImplDecl /*P*/ IMPDecl, 
                               ObjCContainerDecl /*P*/ CDecl, 
                               boolean SynthesizeProperties) {
  DenseMap<std.pairTypeUInt<IdentifierInfo /*P*/ >, ObjCPropertyDecl /*P*/ > PropMap/*J*/= 
          new DenseMap<std.pairTypeUInt<IdentifierInfo /*P*/ >, ObjCPropertyDecl /*P*/ >(
                  DenseMapInfoPairTypePtrUInt.$Info(), (ObjCPropertyDecl /*P*/ )null);
  ObjCInterfaceDecl /*P*/ IDecl = dyn_cast_ObjCInterfaceDecl(CDecl);
  
  // Since we don't synthesize class properties, we should emit diagnose even
  // if SynthesizeProperties is true.
  DenseMap<std.pairTypeUInt<IdentifierInfo /*P*/ >, ObjCPropertyDecl /*P*/ > NoNeedToImplPropMap/*J*/= 
          new DenseMap<std.pairTypeUInt<IdentifierInfo /*P*/ >, ObjCPropertyDecl /*P*/ >(
                  DenseMapInfoPairTypePtrUInt.$Info(), (ObjCPropertyDecl /*P*/ )null);
  // Gather properties which need not be implemented in this class
  // or category.
  if (!(IDecl != null)) {
    {
      ObjCCategoryDecl /*P*/ C = dyn_cast_ObjCCategoryDecl(CDecl);
      if ((C != null)) {
        // For categories, no need to implement properties declared in
        // its primary class (and its super classes) if property is
        // declared in one of those containers.
        if (((IDecl = C.getClassInterface()) != null)) {
          SmallVector<ObjCPropertyDecl /*P*/ > PO/*J*/= new SmallVector<ObjCPropertyDecl /*P*/ >(8, (ObjCPropertyDecl /*P*/ )null);
          IDecl.collectPropertiesToImplement(NoNeedToImplPropMap, PO);
        }
      }
    }
  }
  if ((IDecl != null)) {
    CollectSuperClassPropertyImplementations(IDecl, NoNeedToImplPropMap);
  }
  
  // When SynthesizeProperties is true, we only check class properties.
  CollectImmediateProperties(CDecl, PropMap, NoNeedToImplPropMap, 
      SynthesizeProperties/*CollectClassPropsOnly*/);
  
  // Scan the @interface to see if any of the protocols it adopts
  // require an explicit implementation, via attribute
  // 'objc_protocol_requires_explicit_implementation'.
  if ((IDecl != null)) {
    std.unique_ptr<DenseMap<std.pairTypeUInt<IdentifierInfo /*P*/ >, ObjCPropertyDecl /*P*/ > > LazyMap = null;
    try {
      LazyMap/*J*/= new std.unique_ptr<DenseMap<std.pairTypeUInt<IdentifierInfo /*P*/ >, ObjCPropertyDecl /*P*/ > >();
      
      for (ObjCProtocolDecl /*P*/ PDecl : IDecl.all_referenced_protocols()) {
        if (!PDecl.hasAttr(ObjCExplicitProtocolImplAttr.class)) {
          continue;
        }
        // Lazily construct a set of all the properties in the @interface
        // of the class, without looking at the superclass.  We cannot
        // use the call to CollectImmediateProperties() above as that
        // utilizes information from the super class's properties as well
        // as scans the adopted protocols.  This work only triggers for protocols
        // with the attribute, which is very rare, and only occurs when
        // analyzing the @implementation.
        if (!LazyMap.$bool()) {
          DenseMap<std.pairTypeUInt<IdentifierInfo /*P*/ >, ObjCPropertyDecl /*P*/ > NoNeedToImplPropMap$1/*J*/= 
                  new DenseMap<std.pairTypeUInt<IdentifierInfo /*P*/ >, ObjCPropertyDecl /*P*/ >(
                          DenseMapInfoPairTypePtrUInt.$Info(), (ObjCPropertyDecl /*P*/ )null);
          LazyMap.reset(new DenseMap<std.pairTypeUInt<IdentifierInfo /*P*/ >, ObjCPropertyDecl /*P*/ >(
                  DenseMapInfoPairTypePtrUInt.$Info(), (ObjCPropertyDecl /*P*/ )null));
          CollectImmediateProperties(CDecl, LazyMap.$star(), NoNeedToImplPropMap$1, 
              /* CollectClassPropsOnly */ false, 
              /* IncludeProtocols */ false);
        }
        // Add the properties of 'PDecl' to the list of properties that
        // need to be implemented.
        for (ObjCPropertyDecl /*P*/ PropDecl : PDecl.properties()) {
          if (((LazyMap.$star()).$at_T1$RR(std.make_pair_Ptr_bool2uint(PropDecl.getIdentifier(), 
                      PropDecl.isClassProperty())) != null)) {
            continue;
          }
          PropMap.$set(std.make_pair_Ptr_bool2uint(PropDecl.getIdentifier(), 
                      PropDecl.isClassProperty()), PropDecl);
        }
      }
    } finally {
      if (LazyMap != null) { LazyMap.$destroy(); }
    }
  }
  if (PropMap.empty()) {
    return;
  }
  
  DenseSet<ObjCPropertyDecl /*P*/ > PropImplMap/*J*/= new DenseSet<ObjCPropertyDecl /*P*/ >(DenseMapInfo$LikePtr.$Info());
  for (/*const*/ ObjCPropertyImplDecl /*P*/ I : IMPDecl.property_impls())  {
    PropImplMap.insert(I.getPropertyDecl());
  }
  
  SmallPtrSet</*const*/ ObjCMethodDecl /*P*/ > InsMap/*J*/= new SmallPtrSet</*const*/ ObjCMethodDecl /*P*/ >(DenseMapInfo$LikePtr.$Info(), 8);
  // Collect property accessors implemented in current implementation.
  for (/*const*/ ObjCMethodDecl /*P*/ I : IMPDecl.methods())  {
    InsMap.insert(I);
  }
  
  ObjCCategoryDecl /*P*/ C = dyn_cast_ObjCCategoryDecl(CDecl);
  ObjCInterfaceDecl /*P*/ PrimaryClass = null;
  if ((C != null) && !C.IsClassExtension()) {
    if (((PrimaryClass = C.getClassInterface()) != null)) {
      {
        // Report unimplemented properties in the category as well.
        ObjCImplDecl /*P*/ IMP = PrimaryClass.getImplementation();
        if ((IMP != null)) {
          // When reporting on missing setter/getters, do not report when
          // setter/getter is implemented in category's primary class
          // implementation.
          for (/*const*/ ObjCMethodDecl /*P*/ I : IMP.methods())  {
            InsMap.insert(I);
          }
        }
      }
    }
  }
  
  for (DenseMapIterator<std.pairTypeUInt<IdentifierInfo /*P*/ >, ObjCPropertyDecl /*P*/ > P = PropMap.begin(), E = PropMap.end(); P.$noteq(/*NO_ITER_COPY*/E); P.$preInc()) {
    ObjCPropertyDecl /*P*/ Prop = P.$arrow().second;
    // Is there a matching property synthesize/dynamic?
    if (Prop.isInvalidDecl()
       || Prop.getPropertyImplementation() == ObjCPropertyDecl.PropertyControl.Optional
       || (PropImplMap.count(Prop) != 0)
       || Prop.getAvailability() == AvailabilityResult.AR_Unavailable) {
      continue;
    }
    
    // Diagnose unimplemented getters and setters.
    DiagnoseUnimplementedAccessor(/*Deref*/$this(), 
        PrimaryClass, Prop.getGetterName(), IMPDecl, CDecl, C, Prop, InsMap);
    if (!Prop.isReadOnly()) {
      DiagnoseUnimplementedAccessor(/*Deref*/$this(), 
          PrimaryClass, Prop.getSetterName(), 
          IMPDecl, CDecl, C, Prop, InsMap);
    }
  }
}


/// Diagnose any null-resettable synthesized setters.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::diagnoseNullResettableSynthesizedSetters">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaObjCProperty.cpp", line = 1914,
 FQN="clang::Sema::diagnoseNullResettableSynthesizedSetters", NM="_ZN5clang4Sema40diagnoseNullResettableSynthesizedSettersEPKNS_12ObjCImplDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaObjCProperty.cpp -nm=_ZN5clang4Sema40diagnoseNullResettableSynthesizedSettersEPKNS_12ObjCImplDeclE")
//</editor-fold>
public final void diagnoseNullResettableSynthesizedSetters(/*const*/ ObjCImplDecl /*P*/ impDecl) {
  for (/*const*/ ObjCPropertyImplDecl /*P*/ propertyImpl : impDecl.property_impls()) {
    /*const*/ ObjCPropertyDecl /*P*/ property = propertyImpl.getPropertyDecl();
    
    // Warn about null_resettable properties with synthesized setters,
    // because the setter won't properly handle nil.
    if (propertyImpl.getPropertyImplementation()
       == ObjCPropertyImplDecl.Kind.Synthesize
       && ((property.getPropertyAttributes()
       & ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_null_resettable) != 0)
       && (property.getGetterMethodDecl() != null)
       && (property.getSetterMethodDecl() != null)) {
      ObjCMethodDecl /*P*/ getterMethod = property.getGetterMethodDecl();
      ObjCMethodDecl /*P*/ setterMethod = property.getSetterMethodDecl();
      if (!(impDecl.getInstanceMethod(setterMethod.getSelector()) != null)
         && !(impDecl.getInstanceMethod(getterMethod.getSelector()) != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          SourceLocation loc = propertyImpl.getLocation();
          if (loc.isInvalid()) {
            loc.$assignMove(impDecl.getLocStart());
          }
          
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(loc), diag.warn_null_resettable_setter)), 
                  setterMethod.getSelector()), property.getDeclName()));
        } finally {
          $c$.$destroy();
        }
      }
    }
  }
}


/// DefaultSynthesizeProperties - This routine default synthesizes all
/// properties which must be synthesized in the class's \@implementation.

/// \brief Default synthesizes all properties which must be synthesized
/// in class's \@implementation.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::DefaultSynthesizeProperties">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*make_pair*/,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaObjCProperty.cpp", line = 1669,
 FQN="clang::Sema::DefaultSynthesizeProperties", NM="_ZN5clang4Sema27DefaultSynthesizePropertiesEPNS_5ScopeEPNS_12ObjCImplDeclEPNS_17ObjCInterfaceDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaObjCProperty.cpp -nm=_ZN5clang4Sema27DefaultSynthesizePropertiesEPNS_5ScopeEPNS_12ObjCImplDeclEPNS_17ObjCInterfaceDeclE")
//</editor-fold>
public final void DefaultSynthesizeProperties(Scope /*P*/ S, ObjCImplDecl /*P*/ IMPDecl, 
                           ObjCInterfaceDecl /*P*/ IDecl) {
  DenseMap<std.pairTypeUInt<IdentifierInfo /*P*/ >, ObjCPropertyDecl /*P*/ > PropMap/*J*/= 
          new DenseMap<std.pairTypeUInt<IdentifierInfo /*P*/ >, ObjCPropertyDecl /*P*/ >(
                  DenseMapInfoPairTypePtrUInt.$Info(), (ObjCPropertyDecl /*P*/ )null);
  SmallVector<ObjCPropertyDecl /*P*/ > PropertyOrder/*J*/= new SmallVector<ObjCPropertyDecl /*P*/ >(8, (ObjCPropertyDecl /*P*/ )null);
  IDecl.collectPropertiesToImplement(PropMap, PropertyOrder);
  if (PropMap.empty()) {
    return;
  }
  DenseMap<std.pairTypeUInt<IdentifierInfo /*P*/ >, ObjCPropertyDecl /*P*/ > SuperPropMap/*J*/= 
          new DenseMap<std.pairTypeUInt<IdentifierInfo /*P*/ >, ObjCPropertyDecl /*P*/ >(
                  DenseMapInfoPairTypePtrUInt.$Info(), (ObjCPropertyDecl /*P*/ )null);
  CollectSuperClassPropertyImplementations(IDecl, SuperPropMap);
  
  for (/*uint*/int i = 0, e = PropertyOrder.size(); i != e; i++) {
    ObjCPropertyDecl /*P*/ Prop = PropertyOrder.$at(i);
    // Is there a matching property synthesize/dynamic?
    if (Prop.isInvalidDecl()
       || Prop.isClassProperty()
       || Prop.getPropertyImplementation() == ObjCPropertyDecl.PropertyControl.Optional) {
      continue;
    }
    // Property may have been synthesized by user.
    if ((IMPDecl.FindPropertyImplDecl(Prop.getIdentifier(), Prop.getQueryKind()) != null)) {
      continue;
    }
    if ((IMPDecl.getInstanceMethod(Prop.getGetterName()) != null)) {
      if (((Prop.getPropertyAttributes() & ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_readonly) != 0)) {
        continue;
      }
      if ((IMPDecl.getInstanceMethod(Prop.getSetterName()) != null)) {
        continue;
      }
    }
    {
      ObjCPropertyImplDecl /*P*/ PID = IMPDecl.FindPropertyImplIvarDecl(Prop.getIdentifier());
      if ((PID != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Prop.getLocation(), diag.warn_no_autosynthesis_shared_ivar_property)), 
              Prop.getIdentifier()));
          if (PID.getLocation().isValid()) {
            $c$.clean($c$.track($this().Diag(PID.getLocation(), diag.note_property_synthesize)));
          }
          continue;
        } finally {
          $c$.$destroy();
        }
      }
    }
    ObjCPropertyDecl /*P*/ PropInSuperClass = SuperPropMap.$at_T1$RR(std.make_pair_Ptr_bool2uint(Prop.getIdentifier(), 
                Prop.isClassProperty()));
    {
      ObjCProtocolDecl /*P*/ Proto = dyn_cast_ObjCProtocolDecl(Prop.getDeclContext());
      if ((Proto != null)) {
        // We won't auto-synthesize properties declared in protocols.
        // Suppress the warning if class's superclass implements property's
        // getter and implements property's setter (if readwrite property).
        // Or, if property is going to be implemented in its super class.
        if (!SuperClassImplementsProperty(IDecl, Prop) && !(PropInSuperClass != null)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(IMPDecl.getLocation(), 
                        diag.warn_auto_synthesizing_protocol_property)), 
                    Prop), Proto));
            $c$.clean($c$.track($this().Diag(Prop.getLocation(), diag.note_property_declare)));
          } finally {
            $c$.$destroy();
          }
        }
        continue;
      }
    }
    // If property to be implemented in the super class, ignore.
    if ((PropInSuperClass != null)) {
      if (((Prop.getPropertyAttributes() & ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_readwrite) != 0)
         && ((PropInSuperClass.getPropertyAttributes()
         & ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_readonly) != 0)
         && !(IMPDecl.getInstanceMethod(Prop.getSetterName()) != null)
         && !IDecl.HasUserDeclaredSetterMethod(Prop)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Prop.getLocation(), diag.warn_no_autosynthesis_property)), 
              Prop.getIdentifier()));
          $c$.clean($c$.track($this().Diag(PropInSuperClass.getLocation(), diag.note_property_declare)));
        } finally {
          $c$.$destroy();
        }
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Prop.getLocation(), diag.warn_autosynthesis_property_in_superclass)), 
              Prop.getIdentifier()));
          $c$.clean($c$.track($this().Diag(PropInSuperClass.getLocation(), diag.note_property_declare)));
          $c$.clean($c$.track($this().Diag(IMPDecl.getLocation(), diag.note_while_in_implementation)));
        } finally {
          $c$.$destroy();
        }
      }
      continue;
    }
    // We use invalid SourceLocations for the synthesized ivars since they
    // aren't really synthesized at a particular location; they just exist.
    // Saying that they are located at the @implementation isn't really going
    // to help users.
    ObjCPropertyImplDecl /*P*/ PIDecl = dyn_cast_or_null_ObjCPropertyImplDecl($this().ActOnPropertyImplDecl(S, new SourceLocation(), new SourceLocation(), 
    true, 
    /* property = */ Prop.getIdentifier(), 
    /* ivar = */ Prop.getDefaultSynthIvarName($this().Context), 
    Prop.getLocation(), Prop.getQueryKind()));
    if ((PIDecl != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track($this().Diag(Prop.getLocation(), diag.warn_missing_explicit_synthesis)));
        $c$.clean($c$.track($this().Diag(IMPDecl.getLocation(), diag.note_while_in_implementation)));
      } finally {
        $c$.$destroy();
      }
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::DefaultSynthesizeProperties">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaObjCProperty.cpp", line = 1757,
 FQN="clang::Sema::DefaultSynthesizeProperties", NM="_ZN5clang4Sema27DefaultSynthesizePropertiesEPNS_5ScopeEPNS_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaObjCProperty.cpp -nm=_ZN5clang4Sema27DefaultSynthesizePropertiesEPNS_5ScopeEPNS_4DeclE")
//</editor-fold>
public final void DefaultSynthesizeProperties(Scope /*P*/ S, Decl /*P*/ D) {
  if (!$this().LangOpts.ObjCDefaultSynthProperties || $this().LangOpts.ObjCRuntime.isFragile()) {
    return;
  }
  ObjCImplementationDecl /*P*/ IC = dyn_cast_or_null_ObjCImplementationDecl(D);
  if (!(IC != null)) {
    return;
  }
  {
    ObjCInterfaceDecl /*P*/ IDecl = IC.getClassInterface();
    if ((IDecl != null)) {
      if (!(IDecl.isObjCRequiresPropertyDefs() != null)) {
        $this().DefaultSynthesizeProperties(S, IC, IDecl);
      }
    }
  }
}


/// IvarBacksCurrentMethodAccessor - This routine returns 'true' if 'IV' is
/// an ivar synthesized for 'Method' and 'Method' is a property accessor
/// declared in class 'IFace'.

/// IvarBacksCurrentMethodAccessor - This routine returns 'true' if 'IV' is
/// an ivar synthesized for 'Method' and 'Method' is a property accessor
/// declared in class 'IFace'.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::IvarBacksCurrentMethodAccessor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaObjCProperty.cpp", line = 1617,
 FQN="clang::Sema::IvarBacksCurrentMethodAccessor", NM="_ZN5clang4Sema30IvarBacksCurrentMethodAccessorEPNS_17ObjCInterfaceDeclEPNS_14ObjCMethodDeclEPNS_12ObjCIvarDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaObjCProperty.cpp -nm=_ZN5clang4Sema30IvarBacksCurrentMethodAccessorEPNS_17ObjCInterfaceDeclEPNS_14ObjCMethodDeclEPNS_12ObjCIvarDeclE")
//</editor-fold>
public final boolean IvarBacksCurrentMethodAccessor(ObjCInterfaceDecl /*P*/ IFace, 
                              ObjCMethodDecl /*P*/ Method, ObjCIvarDecl /*P*/ IV) {
  if (!IV.getSynthesize()) {
    return false;
  }
  ObjCMethodDecl /*P*/ IMD = IFace.lookupMethod(Method.getSelector(), 
      Method.isInstanceMethod());
  if (!(IMD != null) || !IMD.isPropertyAccessor()) {
    return false;
  }
  
  // look up a property declaration whose one of its accessors is implemented
  // by this method.
  for (/*const*/ ObjCPropertyDecl /*P*/ Property : IFace.instance_properties()) {
    if ((Property.getGetterName().$eq(IMD.getSelector())
       || Property.getSetterName().$eq(IMD.getSelector()))
       && (Property.getPropertyIvarDecl() == IV)) {
      return true;
    }
  }
  // Also look up property declaration in class extension whose one of its
  // accessors is implemented by this method.
  for (/*const*/ ObjCCategoryDecl /*P*/ Ext : IFace.known_extensions())  {
    for (/*const*/ ObjCPropertyDecl /*P*/ Property : Ext.instance_properties())  {
      if ((Property.getGetterName().$eq(IMD.getSelector())
         || Property.getSetterName().$eq(IMD.getSelector()))
         && (Property.getPropertyIvarDecl() == IV)) {
        return true;
      }
    }
  }
  return false;
}


/// Called by ActOnProperty to handle \@property declarations in
/// class extensions.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::HandlePropertyInClassExtension">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaObjCProperty.cpp", line = 410,
 FQN="clang::Sema::HandlePropertyInClassExtension", NM="_ZN5clang4Sema30HandlePropertyInClassExtensionEPNS_5ScopeENS_14SourceLocationES3_RNS_15FieldDeclaratorENS_8SelectorES6_bRjjNS_8QualTypeEPNS_14TypeSourceInfoENS_3tok15ObjCKeywordKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaObjCProperty.cpp -nm=_ZN5clang4Sema30HandlePropertyInClassExtensionEPNS_5ScopeENS_14SourceLocationES3_RNS_15FieldDeclaratorENS_8SelectorES6_bRjjNS_8QualTypeEPNS_14TypeSourceInfoENS_3tok15ObjCKeywordKindE")
//</editor-fold>
public final ObjCPropertyDecl /*P*/ HandlePropertyInClassExtension(Scope /*P*/ S, 
                              SourceLocation AtLoc, 
                              SourceLocation LParenLoc, 
                              final FieldDeclarator /*&*/ FD, 
                              Selector GetterSel, Selector SetterSel, 
                              /*const*/boolean isReadWrite, 
                              final uint$ref/*uint &*/ Attributes, 
                              /*const*//*uint*/int AttributesAsWritten, 
                              QualType T, 
                              TypeSourceInfo /*P*/ TSI, 
                              /*tok.ObjCKeywordKind*/char MethodImplKind) {
  ObjCCategoryDecl /*P*/ CDecl = cast_ObjCCategoryDecl($this().CurContext);
  // Diagnose if this property is already in continuation class.
  DeclContext /*P*/ DC = $this().CurContext;
  IdentifierInfo /*P*/ PropertyId = FD.D.getIdentifier();
  ObjCInterfaceDecl /*P*/ CCPrimary = CDecl.getClassInterface();
  
  // We need to look in the @interface to see if the @property was
  // already declared.
  if (!(CCPrimary != null)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track($this().Diag(CDecl.getLocation(), diag.err_continuation_class)));
      return null;
    } finally {
      $c$.$destroy();
    }
  }
  
  boolean isClassProperty = ((AttributesAsWritten & ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_class) != 0)
     || ((Attributes.$deref() & ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_class) != 0);
  
  // Find the property in the extended class's primary class or
  // extensions.
  ObjCPropertyDecl /*P*/ PIDecl = CCPrimary.FindPropertyVisibleInPrimaryClass(PropertyId, ObjCPropertyDecl.getQueryKind(isClassProperty));
  
  // If we found a property in an extension, complain. 
  if ((PIDecl != null) && isa_ObjCCategoryDecl(PIDecl.getDeclContext())) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track($this().Diag(new SourceLocation(AtLoc), diag.err_duplicate_property)));
      $c$.clean($c$.track($this().Diag(PIDecl.getLocation(), diag.note_property_declare)));
      return null;
    } finally {
      $c$.$destroy();
    }
  }
  
  // Check for consistency with the previous declaration, if there is one.
  if ((PIDecl != null)) {
    // A readonly property declared in the primary class can be refined
    // by adding a readwrite property within an extension.
    // Anything else is an error.
    if (!(PIDecl.isReadOnly() && isReadWrite)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // Tailor the diagnostics for the common case where a readwrite
        // property is declared both in the @interface and the continuation.
        // This is a common error where the user often intended the original
        // declaration to be readonly.
        /*uint*/int _diag = ((Attributes.$deref() & ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_readwrite) != 0)
           && ((PIDecl.getPropertyAttributesAsWritten()
           & ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_readwrite) != 0) ? diag.err_use_continuation_class_redeclaration_readwrite : diag.err_use_continuation_class;
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(AtLoc), _diag)), 
            CCPrimary.getDeclName()));
        $c$.clean($c$.track($this().Diag(PIDecl.getLocation(), diag.note_property_declare)));
        return null;
      } finally {
        $c$.$destroy();
      }
    }
    
    // Check for consistency of getters.
    if (PIDecl.getGetterName().$noteq(/*NO_COPY*/GetterSel)) {
      // If the getter was written explicitly, complain.
      if (((AttributesAsWritten & ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_getter) != 0)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(AtLoc), diag.warn_property_redecl_getter_mismatch)), 
                  PIDecl.getGetterName()), GetterSel));
          $c$.clean($c$.track($this().Diag(PIDecl.getLocation(), diag.note_property_declare)));
        } finally {
          $c$.$destroy();
        }
      }
      
      // Always adopt the getter from the original declaration.
      GetterSel.$assignMove(PIDecl.getGetterName());
      Attributes.$set$orassign(ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_getter);
    }
    
    // Check consistency of ownership.
    /*uint*/int ExistingOwnership = getOwnershipRule(PIDecl.getPropertyAttributes());
    /*uint*/int NewOwnership = getOwnershipRule(Attributes.$deref());
    if ((ExistingOwnership != 0) && NewOwnership != ExistingOwnership) {
      // If the ownership was written explicitly, complain.
      if ((getOwnershipRule(AttributesAsWritten) != 0)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag(new SourceLocation(AtLoc), diag.warn_property_attr_mismatch)));
          $c$.clean($c$.track($this().Diag(PIDecl.getLocation(), diag.note_property_declare)));
        } finally {
          $c$.$destroy();
        }
      }
      
      // Take the ownership from the original property.
      Attributes.$set((Attributes.$deref() & ~OwnershipMask) | ExistingOwnership);
    }
    
    // If the redeclaration is 'weak' but the original property is not, 
    if (((Attributes.$deref() & ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_weak) != 0)
       && !((PIDecl.getPropertyAttributesAsWritten()
       & ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_weak) != 0)
       && (PIDecl.getType().$arrow().getAs(ObjCObjectPointerType.class) != null)
       && PIDecl.getType().getObjCLifetime() == Qualifiers.ObjCLifetime.OCL_None) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track($this().Diag(new SourceLocation(AtLoc), diag.warn_property_implicitly_mismatched)));
        $c$.clean($c$.track($this().Diag(PIDecl.getLocation(), diag.note_property_declare)));
      } finally {
        $c$.$destroy();
      }
    }
  }
  
  // Create a new ObjCPropertyDecl with the DeclContext being
  // the class extension.
  ObjCPropertyDecl /*P*/ PDecl = $this().CreatePropertyDecl(S, CDecl, new SourceLocation(AtLoc), new SourceLocation(LParenLoc), 
      FD, new Selector(GetterSel), new Selector(SetterSel), 
      isReadWrite, 
      Attributes.$deref(), AttributesAsWritten, 
      new QualType(T), TSI, MethodImplKind, DC);
  
  // If there was no declaration of a property with the same name in
  // the primary class, we're done.
  if (!(PIDecl != null)) {
    $this().ProcessPropertyDecl(PDecl);
    return PDecl;
  }
  if (!$this().Context.hasSameType(PIDecl.getType(), PDecl.getType())) {
    bool$ref IncompatibleObjC = create_bool$ref(false);
    QualType ConvertedType/*J*/= new QualType();
    // Relax the strict type matching for property type in continuation class.
    // Allow property object type of continuation class to be different as long
    // as it narrows the object type in its primary class property. Note that
    // this conversion is safe only because the wider type is for a 'readonly'
    // property in primary class and 'narrowed' type for a 'readwrite' property
    // in continuation class.
    QualType PrimaryClassPropertyT = $this().Context.getCanonicalType(PIDecl.getType()).$QualType();
    QualType ClassExtPropertyT = $this().Context.getCanonicalType(PDecl.getType()).$QualType();
    if (!isa_ObjCObjectPointerType(PrimaryClassPropertyT)
       || !isa_ObjCObjectPointerType(ClassExtPropertyT)
       || (!$this().isObjCPointerConversion(new QualType(ClassExtPropertyT), new QualType(PrimaryClassPropertyT), 
        ConvertedType, IncompatibleObjC))
       || IncompatibleObjC.$deref()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(AtLoc), 
                diag.err_type_mismatch_continuation_class)), PDecl.getType()));
        $c$.clean($c$.track($this().Diag(PIDecl.getLocation(), diag.note_property_declare)));
        return null;
      } finally {
        $c$.$destroy();
      }
    }
  }
  
  // Check that atomicity of property in class extension matches the previous
  // declaration.
  checkAtomicPropertyMismatch(/*Deref*/$this(), PIDecl, PDecl, true);
  
  // Make sure getter/setter are appropriately synthesized.
  $this().ProcessPropertyDecl(PDecl);
  return PDecl;
}


/// Called by ActOnProperty and HandlePropertyInClassExtension to
/// handle creating the ObjcPropertyDecl for a category or \@interface.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CreatePropertyDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaObjCProperty.cpp", line = 559,
 FQN="clang::Sema::CreatePropertyDecl", NM="_ZN5clang4Sema18CreatePropertyDeclEPNS_5ScopeEPNS_17ObjCContainerDeclENS_14SourceLocationES5_RNS_15FieldDeclaratorENS_8SelectorES8_bjjNS_8QualTypeEPNS_14TypeSourceInfoENS_3tok15ObjCKeywordKindEPNS_11DeclContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaObjCProperty.cpp -nm=_ZN5clang4Sema18CreatePropertyDeclEPNS_5ScopeEPNS_17ObjCContainerDeclENS_14SourceLocationES5_RNS_15FieldDeclaratorENS_8SelectorES8_bjjNS_8QualTypeEPNS_14TypeSourceInfoENS_3tok15ObjCKeywordKindEPNS_11DeclContextE")
//</editor-fold>
public final ObjCPropertyDecl /*P*/ CreatePropertyDecl(Scope /*P*/ S, 
                  ObjCContainerDecl /*P*/ CDecl, 
                  SourceLocation AtLoc, 
                  SourceLocation LParenLoc, 
                  final FieldDeclarator /*&*/ FD, 
                  Selector GetterSel, 
                  Selector SetterSel, 
                  /*const*/boolean isReadWrite, 
                  /*const*//*uint*/int Attributes, 
                  /*const*//*uint*/int AttributesAsWritten, 
                  QualType T, 
                  TypeSourceInfo /*P*/ TInfo, 
                  /*tok.ObjCKeywordKind*/char MethodImplKind) {
  return CreatePropertyDecl(S, 
                  CDecl, 
                  AtLoc, 
                  LParenLoc, 
                  FD, 
                  GetterSel, 
                  SetterSel, 
                  isReadWrite, 
                  Attributes, 
                  AttributesAsWritten, 
                  T, 
                  TInfo, 
                  MethodImplKind, 
                  (DeclContext /*P*/ )null);
}
public final ObjCPropertyDecl /*P*/ CreatePropertyDecl(Scope /*P*/ S, 
                  ObjCContainerDecl /*P*/ CDecl, 
                  SourceLocation AtLoc, 
                  SourceLocation LParenLoc, 
                  final FieldDeclarator /*&*/ FD, 
                  Selector GetterSel, 
                  Selector SetterSel, 
                  /*const*/boolean isReadWrite, 
                  /*const*//*uint*/int Attributes, 
                  /*const*//*uint*/int AttributesAsWritten, 
                  QualType T, 
                  TypeSourceInfo /*P*/ TInfo, 
                  /*tok.ObjCKeywordKind*/char MethodImplKind, 
                  DeclContext /*P*/ lexicalDC/*= null*/) {
  IdentifierInfo /*P*/ PropertyId = FD.D.getIdentifier();
  
  // Property defaults to 'assign' if it is readwrite, unless this is ARC
  // and the type is retainable.
  boolean isAssign;
  if (((Attributes & (ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_assign
     | ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_unsafe_unretained)) != 0)) {
    isAssign = true;
  } else if ((getOwnershipRule(Attributes) != 0) || !isReadWrite) {
    isAssign = false;
  } else {
    isAssign = (!$this().getLangOpts().ObjCAutoRefCount
       || !T.$arrow().isObjCRetainableType());
  }
  
  // Issue a warning if property is 'assign' as default and its
  // object, which is gc'able conforms to NSCopying protocol
  if ($this().getLangOpts().getGC() != LangOptions.GCMode.NonGC
     && isAssign && !((Attributes & ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_assign) != 0)) {
    {
      /*const*/ ObjCObjectPointerType /*P*/ ObjPtrTy = T.$arrow().getAs(ObjCObjectPointerType.class);
      if ((ObjPtrTy != null)) {
        ObjCInterfaceDecl /*P*/ IDecl = ObjPtrTy.getObjectType().getInterface();
        if ((IDecl != null)) {
          {
            ObjCProtocolDecl /*P*/ PNSCopying = $this().LookupProtocol($AddrOf($this().Context.Idents.get(new StringRef(/*KEEP_STR*/"NSCopying"))), new SourceLocation(AtLoc));
            if ((PNSCopying != null)) {
              if (IDecl.ClassImplementsProtocol(PNSCopying, true)) {
                JavaCleaner $c$ = $createJavaCleaner();
                try {
                  $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(AtLoc), diag.warn_implements_nscopying)), PropertyId));
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
  if (T.$arrow().isObjCObjectType()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      SourceLocation StarLoc = TInfo.getTypeLoc().getLocEnd();
      StarLoc.$assignMove($this().getLocForEndOfToken(new SourceLocation(StarLoc)));
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(FD.D.getIdentifierLoc(), diag.err_statically_allocated_object)), 
          FixItHint.CreateInsertion(/*NO_COPY*/StarLoc, new StringRef(/*KEEP_STR*/$STAR))));
      T.$assignMove($this().Context.getObjCObjectPointerType(new QualType(T)));
      SourceLocation TLoc = TInfo.getTypeLoc().getLocStart();
      TInfo = $this().Context.getTrivialTypeSourceInfo(new QualType(T), new SourceLocation(TLoc));
    } finally {
      $c$.$destroy();
    }
  }
  
  DeclContext /*P*/ DC = cast_DeclContext(CDecl);
  ObjCPropertyDecl /*P*/ PDecl = ObjCPropertyDecl.Create($this().Context, DC, 
      FD.D.getIdentifierLoc(), 
      PropertyId, new SourceLocation(AtLoc), 
      new SourceLocation(LParenLoc), new QualType(T), TInfo);
  
  boolean isClassProperty = ((AttributesAsWritten & ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_class) != 0)
     || ((Attributes & ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_class) != 0);
  {
    // Class property and instance property can have the same name.
    ObjCPropertyDecl /*P*/ prevDecl = ObjCPropertyDecl.findPropertyDecl(DC, PropertyId, ObjCPropertyDecl.getQueryKind(isClassProperty));
    if ((prevDecl != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track($this().Diag(PDecl.getLocation(), diag.err_duplicate_property)));
        $c$.clean($c$.track($this().Diag(prevDecl.getLocation(), diag.note_property_declare)));
        PDecl.setInvalidDecl();
      } finally {
        $c$.$destroy();
      }
    } else {
      DC.addDecl(PDecl);
      if ((lexicalDC != null)) {
        PDecl.setLexicalDeclContext(lexicalDC);
      }
    }
  }
  if (T.$arrow().isArrayType() || T.$arrow().isFunctionType()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(AtLoc), diag.err_property_type)), T));
      PDecl.setInvalidDecl();
    } finally {
      $c$.$destroy();
    }
  }
  
  $this().ProcessDeclAttributes(S, PDecl, FD.D);
  
  // Regardless of setter/getter attribute, we save the default getter/setter
  // selector names in anticipation of declaration of setter/getter methods.
  PDecl.setGetterName(new Selector(GetterSel));
  PDecl.setSetterName(new Selector(SetterSel));
  PDecl.setPropertyAttributesAsWritten(makePropertyAttributesAsWritten(AttributesAsWritten));
  if (((Attributes & ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_readonly) != 0)) {
    PDecl.setPropertyAttributes(ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_readonly);
  }
  if (((Attributes & ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_getter) != 0)) {
    PDecl.setPropertyAttributes(ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_getter);
  }
  if (((Attributes & ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_setter) != 0)) {
    PDecl.setPropertyAttributes(ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_setter);
  }
  if (isReadWrite) {
    PDecl.setPropertyAttributes(ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_readwrite);
  }
  if (((Attributes & ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_retain) != 0)) {
    PDecl.setPropertyAttributes(ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_retain);
  }
  if (((Attributes & ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_strong) != 0)) {
    PDecl.setPropertyAttributes(ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_strong);
  }
  if (((Attributes & ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_weak) != 0)) {
    PDecl.setPropertyAttributes(ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_weak);
  }
  if (((Attributes & ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_copy) != 0)) {
    PDecl.setPropertyAttributes(ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_copy);
  }
  if (((Attributes & ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_unsafe_unretained) != 0)) {
    PDecl.setPropertyAttributes(ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_unsafe_unretained);
  }
  if (isAssign) {
    PDecl.setPropertyAttributes(ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_assign);
  }
  
  // In the semantic attributes, one of nonatomic or atomic is always set.
  if (((Attributes & ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_nonatomic) != 0)) {
    PDecl.setPropertyAttributes(ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_nonatomic);
  } else {
    PDecl.setPropertyAttributes(ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_atomic);
  }
  
  // 'unsafe_unretained' is alias for 'assign'.
  if (((Attributes & ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_unsafe_unretained) != 0)) {
    PDecl.setPropertyAttributes(ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_assign);
  }
  if (isAssign) {
    PDecl.setPropertyAttributes(ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_unsafe_unretained);
  }
  if (MethodImplKind == tok.ObjCKeywordKind.objc_required) {
    PDecl.setPropertyImplementation(ObjCPropertyDecl.PropertyControl.Required);
  } else if (MethodImplKind == tok.ObjCKeywordKind.objc_optional) {
    PDecl.setPropertyImplementation(ObjCPropertyDecl.PropertyControl.Optional);
  }
  if (((Attributes & ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_nullability) != 0)) {
    PDecl.setPropertyAttributes(ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_nullability);
  }
  if (((Attributes & ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_null_resettable) != 0)) {
    PDecl.setPropertyAttributes(ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_null_resettable);
  }
  if (((Attributes & ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_class) != 0)) {
    PDecl.setPropertyAttributes(ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_class);
  }
  
  return PDecl;
}


/// AtomicPropertySetterGetterRules - This routine enforces the rule (via
/// warning) when atomic property has one but not the other user-declared
/// setter or getter.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::AtomicPropertySetterGetterRules">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*make_pair*/,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaObjCProperty.cpp", line = 1941,
 FQN="clang::Sema::AtomicPropertySetterGetterRules", NM="_ZN5clang4Sema31AtomicPropertySetterGetterRulesEPNS_12ObjCImplDeclEPNS_17ObjCInterfaceDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaObjCProperty.cpp -nm=_ZN5clang4Sema31AtomicPropertySetterGetterRulesEPNS_12ObjCImplDeclEPNS_17ObjCInterfaceDeclE")
//</editor-fold>
public final void AtomicPropertySetterGetterRules(ObjCImplDecl /*P*/ IMPDecl, 
                               ObjCInterfaceDecl /*P*/ IDecl) {
  // Rules apply in non-GC mode only
  if ($this().getLangOpts().getGC() != LangOptions.GCMode.NonGC) {
    return;
  }
  DenseMap<std.pairTypeUInt<IdentifierInfo /*P*/ >, ObjCPropertyDecl /*P*/ > PM/*J*/= 
          new DenseMap<std.pairTypeUInt<IdentifierInfo /*P*/ >, ObjCPropertyDecl /*P*/ >(
                  DenseMapInfoPairTypePtrUInt.$Info(), (ObjCPropertyDecl /*P*/ )null);
  for (ObjCPropertyDecl /*P*/ Prop : IDecl.properties())  {
    PM.$set(std.make_pair_Ptr_bool2uint(Prop.getIdentifier(), Prop.isClassProperty()), Prop);
  }
  for (/*const*/ ObjCCategoryDecl /*P*/ Ext : IDecl.known_extensions())  {
    for (ObjCPropertyDecl /*P*/ Prop : Ext.properties())  {
      PM.$set(std.make_pair_Ptr_bool2uint(Prop.getIdentifier(), Prop.isClassProperty()), Prop);
    }
  }
  
  for (DenseMapIterator<std.pairTypeUInt<IdentifierInfo /*P*/ >, ObjCPropertyDecl /*P*/ > I = PM.begin(), E = PM.end();
       I.$noteq(/*NO_ITER_COPY*/E); I.$preInc()) {
    /*const*/ ObjCPropertyDecl /*P*/ Property = I.$arrow().second;
    ObjCMethodDecl /*P*/ GetterMethod = null;
    ObjCMethodDecl /*P*/ SetterMethod = null;
    boolean LookedUpGetterSetter = false;
    
    /*uint*/int Attributes = Property.getPropertyAttributes();
    /*uint*/int AttributesAsWritten = Property.getPropertyAttributesAsWritten();
    if (!((AttributesAsWritten & ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_atomic) != 0)
       && !((AttributesAsWritten & ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_nonatomic) != 0)) {
      GetterMethod = Property.isClassProperty() ? IMPDecl.getClassMethod(Property.getGetterName()) : IMPDecl.getInstanceMethod(Property.getGetterName());
      SetterMethod = Property.isClassProperty() ? IMPDecl.getClassMethod(Property.getSetterName()) : IMPDecl.getInstanceMethod(Property.getSetterName());
      LookedUpGetterSetter = true;
      if ((GetterMethod != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(GetterMethod.getLocation(), 
                      diag.warn_default_atomic_custom_getter_setter)), 
                  Property.getIdentifier()), 0));
          $c$.clean($c$.track($this().Diag(Property.getLocation(), diag.note_property_declare)));
        } finally {
          $c$.$destroy();
        }
      }
      if ((SetterMethod != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(SetterMethod.getLocation(), 
                      diag.warn_default_atomic_custom_getter_setter)), 
                  Property.getIdentifier()), 1));
          $c$.clean($c$.track($this().Diag(Property.getLocation(), diag.note_property_declare)));
        } finally {
          $c$.$destroy();
        }
      }
    }
    
    // We only care about readwrite atomic property.
    if (((Attributes & ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_nonatomic) != 0)
       || !((Attributes & ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_readwrite) != 0)) {
      continue;
    }
    {
      /*const*/ ObjCPropertyImplDecl /*P*/ PIDecl = IMPDecl.FindPropertyImplDecl(Property.getIdentifier(), Property.getQueryKind());
      if ((PIDecl != null)) {
        if (PIDecl.getPropertyImplementation() == ObjCPropertyImplDecl.Kind.Dynamic) {
          continue;
        }
        if (!LookedUpGetterSetter) {
          GetterMethod = Property.isClassProperty() ? IMPDecl.getClassMethod(Property.getGetterName()) : IMPDecl.getInstanceMethod(Property.getGetterName());
          SetterMethod = Property.isClassProperty() ? IMPDecl.getClassMethod(Property.getSetterName()) : IMPDecl.getInstanceMethod(Property.getSetterName());
        }
        if (((GetterMethod != null) && !(SetterMethod != null)) || (!(GetterMethod != null) && (SetterMethod != null))) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            SourceLocation MethodLoc = ((GetterMethod != null) ? GetterMethod.getLocation() : SetterMethod.getLocation());
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(MethodLoc), diag.warn_atomic_property_rule)), 
                        Property.getIdentifier()), (GetterMethod != (ObjCMethodDecl /*P*/ )null)), 
                (SetterMethod != (ObjCMethodDecl /*P*/ )null)));
            // fixit stuff.
            if (Property.getLParenLoc().isValid()
               && !((AttributesAsWritten & ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_atomic) != 0)) {
              // @property () ... case.
              SourceLocation AfterLParen = $this().getLocForEndOfToken(Property.getLParenLoc());
              StringRef NonatomicStr = new StringRef((AttributesAsWritten != 0) ? $("nonatomic, ") : $("nonatomic"));
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Property.getLocation(), 
                      diag.note_atomic_property_fixup_suggest)), 
                  FixItHint.CreateInsertion(/*NO_COPY*/AfterLParen, /*NO_COPY*/NonatomicStr)));
            } else if (Property.getLParenLoc().isInvalid()) {
              //@property id etc.
              SourceLocation startLoc = Property.getTypeSourceInfo().getTypeLoc().getBeginLoc();
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Property.getLocation(), 
                      diag.note_atomic_property_fixup_suggest)), 
                  FixItHint.CreateInsertion(/*NO_COPY*/startLoc, new StringRef(/*KEEP_STR*/"(nonatomic) "))));
            } else {
              $c$.clean($c$.track($this().Diag(new SourceLocation(MethodLoc), diag.note_atomic_property_fixup_suggest)));
            }
            $c$.clean($c$.track($this().Diag(Property.getLocation(), diag.note_property_declare)));
          } finally {
            $c$.$destroy();
          }
        }
      }
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::DiagnoseOwningPropertyGetterSynthesis">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaObjCProperty.cpp", line = 2037,
 FQN="clang::Sema::DiagnoseOwningPropertyGetterSynthesis", NM="_ZN5clang4Sema37DiagnoseOwningPropertyGetterSynthesisEPKNS_22ObjCImplementationDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaObjCProperty.cpp -nm=_ZN5clang4Sema37DiagnoseOwningPropertyGetterSynthesisEPKNS_22ObjCImplementationDeclE")
//</editor-fold>
public final void DiagnoseOwningPropertyGetterSynthesis(/*const*/ ObjCImplementationDecl /*P*/ D) {
  if ($this().getLangOpts().getGC() == LangOptions.GCMode.GCOnly) {
    return;
  }
  
  for (/*const*/ ObjCPropertyImplDecl /*P*/ PID : D.property_impls()) {
    /*const*/ ObjCPropertyDecl /*P*/ PD = PID.getPropertyDecl();
    if ((PD != null) && !PD.hasAttr(NSReturnsNotRetainedAttr.class)
       && !PD.isClassProperty()
       && !(D.getInstanceMethod(PD.getGetterName()) != null)) {
      ObjCMethodDecl /*P*/ method = PD.getGetterMethodDecl();
      if (!(method != null)) {
        continue;
      }
      ObjCMethodFamily family = method.getMethodFamily();
      if (family == ObjCMethodFamily.OMF_alloc || family == ObjCMethodFamily.OMF_copy
         || family == ObjCMethodFamily.OMF_mutableCopy || family == ObjCMethodFamily.OMF_new) {
        SemaDiagnosticBuilder noteDiag = null;
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          if ($this().getLangOpts().ObjCAutoRefCount) {
            $c$.clean($c$.track($this().Diag(PD.getLocation(), diag.err_cocoa_naming_owned_rule)));
          } else {
            $c$.clean($c$.track($this().Diag(PD.getLocation(), diag.warn_cocoa_naming_owned_rule)));
          }
          
          // Look for a getter explicitly declared alongside the property.
          // If we find one, use its location for the note.
          SourceLocation noteLoc = PD.getLocation();
          SourceLocation fixItLoc/*J*/= new SourceLocation();
          for (Decl /*P*/ getterRedecl : method.decl_redecls()) {
            if (getterRedecl.isImplicit()) {
              continue;
            }
            if (getterRedecl.getDeclContext() != PD.getDeclContext$Const()) {
              continue;
            }
            noteLoc.$assignMove(getterRedecl.getLocation());
            fixItLoc.$assignMove(getterRedecl.getLocEnd());
          }
          
          final Preprocessor /*&*/ PP = $this().getPreprocessor();
          TokenValue tokens[/*9*/] = new TokenValue [/*9*/] {
            new TokenValue(tok.TokenKind.kw___attribute), new TokenValue(tok.TokenKind.l_paren), new TokenValue(tok.TokenKind.l_paren), 
            new TokenValue(PP.getIdentifierInfo(new StringRef(/*KEEP_STR*/"objc_method_family"))), new TokenValue(tok.TokenKind.l_paren), 
            new TokenValue(PP.getIdentifierInfo(new StringRef(/*KEEP_STR*/"none"))), new TokenValue(tok.TokenKind.r_paren), 
            new TokenValue(tok.TokenKind.r_paren), new TokenValue(tok.TokenKind.r_paren)
          };
          StringRef spelling = new StringRef(/*KEEP_STR*/"__attribute__((objc_method_family(none)))");
          StringRef macroName = PP.getLastMacroWithSpelling(new SourceLocation(noteLoc), new ArrayRef<TokenValue>(tokens, false));
          if (!macroName.empty()) {
            spelling.$assign(macroName);
          }
          
          /*FIXME: Initializer produces not destroyed temporary!*/noteDiag = $c$.clean(new SemaDiagnosticBuilder($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(noteLoc), diag.note_cocoa_naming_declare_family)), 
                      method.getDeclName()), spelling)));
          if (fixItLoc.isValid()) {
            SmallString/*64*/ fixItText/*J*/= new SmallString/*64*/(new StringRef(/*KEEP_STR*/$SPACE), 64);
            fixItText.$addassign(/*NO_COPY*/spelling);
            $out_SemaDiagnosticBuilder$C_T$C$R(noteDiag, FixItHint.CreateInsertion(/*NO_COPY*/fixItLoc, fixItText.$StringRef()));
          }
        } finally {
          if (noteDiag != null) { noteDiag.$destroy(); }
          $c$.$destroy();
        }
      }
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::DiagnoseMissingDesignatedInitOverrides">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaObjCProperty.cpp", line = 2094,
 FQN="clang::Sema::DiagnoseMissingDesignatedInitOverrides", NM="_ZN5clang4Sema38DiagnoseMissingDesignatedInitOverridesEPKNS_22ObjCImplementationDeclEPKNS_17ObjCInterfaceDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaObjCProperty.cpp -nm=_ZN5clang4Sema38DiagnoseMissingDesignatedInitOverridesEPKNS_22ObjCImplementationDeclEPKNS_17ObjCInterfaceDeclE")
//</editor-fold>
public final void DiagnoseMissingDesignatedInitOverrides(/*const*/ ObjCImplementationDecl /*P*/ ImplD, 
                                      /*const*/ ObjCInterfaceDecl /*P*/ IFD) {
  assert (IFD.hasDesignatedInitializers());
  /*const*/ ObjCInterfaceDecl /*P*/ SuperD = IFD.getSuperClass();
  if (!(SuperD != null)) {
    return;
  }
  
  SmallPtrSet<Selector> InitSelSet/*J*/= new SmallPtrSet<Selector>(DenseMapInfoSelector.$Info(), 8);
  for (/*const*/ ObjCMethodDecl /*P*/ I : ImplD.instance_methods())  {
    if (I.getMethodFamily() == ObjCMethodFamily.OMF_init) {
      InitSelSet.insert(I.getSelector());
    }
  }
  
  SmallVector</*const*/ ObjCMethodDecl /*P*/ > DesignatedInits/*J*/= new SmallVector</*const*/ ObjCMethodDecl /*P*/ >(8, (/*const*/ ObjCMethodDecl /*P*/ )null);
  SuperD.getDesignatedInitializers(DesignatedInits);
  for (type$ptr</*const*/ ObjCMethodDecl /*P*/ /*P*/> I = $tryClone(DesignatedInits.begin()), /*P*/ E = $tryClone(DesignatedInits.end()); $noteq_ptr(I, E); I.$preInc()) {
    /*const*/ ObjCMethodDecl /*P*/ MD = I.$star();
    if (!(InitSelSet.count(MD.getSelector()) != 0)) {
      boolean Ignore = false;
      {
        ObjCMethodDecl /*P*/ IMD = IFD.getInstanceMethod(MD.getSelector());
        if ((IMD != null)) {
          Ignore = IMD.isUnavailable();
        }
      }
      if (!Ignore) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(ImplD.getLocation(), 
                  diag.warn_objc_implementation_missing_designated_init_override)), 
              MD.getSelector()));
          $c$.clean($c$.track($this().Diag(MD.getLocation(), diag.note_objc_designated_init_marked_here)));
        } finally {
          $c$.$destroy();
        }
      }
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::DiagnosePropertyAccessorMismatch">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaObjCProperty.cpp", line = 1490,
 FQN="clang::Sema::DiagnosePropertyAccessorMismatch", NM="_ZN5clang4Sema32DiagnosePropertyAccessorMismatchEPNS_16ObjCPropertyDeclEPNS_14ObjCMethodDeclENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaObjCProperty.cpp -nm=_ZN5clang4Sema32DiagnosePropertyAccessorMismatchEPNS_16ObjCPropertyDeclEPNS_14ObjCMethodDeclENS_14SourceLocationE")
//</editor-fold>
public final boolean DiagnosePropertyAccessorMismatch(ObjCPropertyDecl /*P*/ property, 
                                ObjCMethodDecl /*P*/ GetterMethod, 
                                SourceLocation Loc) {
  if (!(GetterMethod != null)) {
    return false;
  }
  QualType GetterType = GetterMethod.getReturnType().getNonReferenceType();
  QualType PropertyRValueType = property.getType().getNonReferenceType().getAtomicUnqualifiedType();
  boolean compat = $this().Context.hasSameType(new QualType(PropertyRValueType), new QualType(GetterType));
  if (!compat) {
    /*const*/ ObjCObjectPointerType /*P*/ propertyObjCPtr = null;
    /*const*/ ObjCObjectPointerType /*P*/ getterObjCPtr = null;
    if (((propertyObjCPtr
       = PropertyRValueType.$arrow().getAs(ObjCObjectPointerType.class)) != null)
       && ((getterObjCPtr = GetterType.$arrow().getAs(ObjCObjectPointerType.class)) != null)) {
      compat = $this().Context.canAssignObjCInterfaces(getterObjCPtr, propertyObjCPtr);
    } else if ($this().CheckAssignmentConstraints(new SourceLocation(Loc), new QualType(GetterType), new QualType(PropertyRValueType))
       != AssignConvertType.Compatible) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.error_property_accessor_type)), 
                        property.getDeclName()), PropertyRValueType), 
                GetterMethod.getSelector()), GetterType));
        $c$.clean($c$.track($this().Diag(GetterMethod.getLocation(), diag.note_declared_at)));
        return true;
      } finally {
        $c$.$destroy();
      }
    } else {
      compat = true;
      QualType lhsType = $this().Context.getCanonicalType(new QualType(PropertyRValueType)).$QualType();
      QualType rhsType = $this().Context.getCanonicalType(new QualType(GetterType)).getUnqualifiedType().$QualType();
      if ($noteq_QualType$C(lhsType, rhsType) && lhsType.$arrow().isArithmeticType()) {
        compat = false;
      }
    }
  }
  if (!compat) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.warn_accessor_property_type_mismatch)), 
              property.getDeclName()), 
          GetterMethod.getSelector()));
      $c$.clean($c$.track($this().Diag(GetterMethod.getLocation(), diag.note_declared_at)));
      return true;
    } finally {
      $c$.$destroy();
    }
  }
  
  return false;
}


/// Ensure attributes are consistent with type.
/// \param [in, out] Attributes The attributes to check; they will
/// be modified to be consistent with \p PropertyTy.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckObjCPropertyAttributes">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaObjCProperty.cpp", line = 2363,
 FQN="clang::Sema::CheckObjCPropertyAttributes", NM="_ZN5clang4Sema27CheckObjCPropertyAttributesEPNS_4DeclENS_14SourceLocationERjb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaObjCProperty.cpp -nm=_ZN5clang4Sema27CheckObjCPropertyAttributesEPNS_4DeclENS_14SourceLocationERjb")
//</editor-fold>
public final void CheckObjCPropertyAttributes(Decl /*P*/ PDecl, 
                           SourceLocation Loc, 
                           final uint$ref/*uint &*/ Attributes, 
                           boolean propertyInPrimaryClass) {
  // FIXME: Improve the reported location.
  if (!(PDecl != null) || PDecl.isInvalidDecl()) {
    return;
  }
  if (((Attributes.$deref() & ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_readonly) != 0)
     && ((Attributes.$deref() & ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_readwrite) != 0)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.err_objc_property_attr_mutually_exclusive)), 
              /*KEEP_STR*/"readonly"), /*KEEP_STR*/"readwrite"));
    } finally {
      $c$.$destroy();
    }
  }
  
  ObjCPropertyDecl /*P*/ PropertyDecl = cast_ObjCPropertyDecl(PDecl);
  QualType PropertyTy = PropertyDecl.getType();
  
  // Check for copy or retain on non-object types.
  if (((Attributes.$deref() & (ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_weak | ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_copy
     | ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_retain | ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_strong)) != 0)
     && !PropertyTy.$arrow().isObjCRetainableType()
     && !PropertyDecl.hasAttr(ObjCNSObjectAttr.class)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.err_objc_property_requires_object)), 
          (((Attributes.$deref() & ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_weak) != 0) ? $("weak") : ((Attributes.$deref() & ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_copy) != 0) ? $("copy") : $("retain (or strong)"))));
      Attributes.$set$andassign(~(ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_weak | ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_copy
         | ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_retain | ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_strong));
      PropertyDecl.setInvalidDecl();
    } finally {
      $c$.$destroy();
    }
  }
  
  // Check for more than one of { assign, copy, retain }.
  if (((Attributes.$deref() & ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_assign) != 0)) {
    if (((Attributes.$deref() & ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_copy) != 0)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.err_objc_property_attr_mutually_exclusive)), 
                /*KEEP_STR*/"assign"), /*KEEP_STR*/"copy"));
        Attributes.$set$andassign(~ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_copy);
      } finally {
        $c$.$destroy();
      }
    }
    if (((Attributes.$deref() & ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_retain) != 0)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.err_objc_property_attr_mutually_exclusive)), 
                /*KEEP_STR*/"assign"), /*KEEP_STR*/"retain"));
        Attributes.$set$andassign(~ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_retain);
      } finally {
        $c$.$destroy();
      }
    }
    if (((Attributes.$deref() & ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_strong) != 0)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.err_objc_property_attr_mutually_exclusive)), 
                /*KEEP_STR*/"assign"), /*KEEP_STR*/"strong"));
        Attributes.$set$andassign(~ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_strong);
      } finally {
        $c$.$destroy();
      }
    }
    if ($this().getLangOpts().ObjCAutoRefCount
       && ((Attributes.$deref() & ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_weak) != 0)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.err_objc_property_attr_mutually_exclusive)), 
                /*KEEP_STR*/"assign"), /*KEEP_STR*/"weak"));
        Attributes.$set$andassign(~ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_weak);
      } finally {
        $c$.$destroy();
      }
    }
    if (PropertyDecl.hasAttr(IBOutletCollectionAttr.class)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track($this().Diag(new SourceLocation(Loc), diag.warn_iboutletcollection_property_assign)));
      } finally {
        $c$.$destroy();
      }
    }
  } else if (((Attributes.$deref() & ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_unsafe_unretained) != 0)) {
    if (((Attributes.$deref() & ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_copy) != 0)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.err_objc_property_attr_mutually_exclusive)), 
                /*KEEP_STR*/"unsafe_unretained"), /*KEEP_STR*/"copy"));
        Attributes.$set$andassign(~ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_copy);
      } finally {
        $c$.$destroy();
      }
    }
    if (((Attributes.$deref() & ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_retain) != 0)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.err_objc_property_attr_mutually_exclusive)), 
                /*KEEP_STR*/"unsafe_unretained"), /*KEEP_STR*/"retain"));
        Attributes.$set$andassign(~ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_retain);
      } finally {
        $c$.$destroy();
      }
    }
    if (((Attributes.$deref() & ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_strong) != 0)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.err_objc_property_attr_mutually_exclusive)), 
                /*KEEP_STR*/"unsafe_unretained"), /*KEEP_STR*/"strong"));
        Attributes.$set$andassign(~ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_strong);
      } finally {
        $c$.$destroy();
      }
    }
    if ($this().getLangOpts().ObjCAutoRefCount
       && ((Attributes.$deref() & ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_weak) != 0)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.err_objc_property_attr_mutually_exclusive)), 
                /*KEEP_STR*/"unsafe_unretained"), /*KEEP_STR*/"weak"));
        Attributes.$set$andassign(~ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_weak);
      } finally {
        $c$.$destroy();
      }
    }
  } else if (((Attributes.$deref() & ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_copy) != 0)) {
    if (((Attributes.$deref() & ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_retain) != 0)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.err_objc_property_attr_mutually_exclusive)), 
                /*KEEP_STR*/"copy"), /*KEEP_STR*/"retain"));
        Attributes.$set$andassign(~ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_retain);
      } finally {
        $c$.$destroy();
      }
    }
    if (((Attributes.$deref() & ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_strong) != 0)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.err_objc_property_attr_mutually_exclusive)), 
                /*KEEP_STR*/"copy"), /*KEEP_STR*/"strong"));
        Attributes.$set$andassign(~ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_strong);
      } finally {
        $c$.$destroy();
      }
    }
    if (((Attributes.$deref() & ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_weak) != 0)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.err_objc_property_attr_mutually_exclusive)), 
                /*KEEP_STR*/"copy"), /*KEEP_STR*/"weak"));
        Attributes.$set$andassign(~ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_weak);
      } finally {
        $c$.$destroy();
      }
    }
  } else if (((Attributes.$deref() & ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_retain) != 0)
     && ((Attributes.$deref() & ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_weak) != 0)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.err_objc_property_attr_mutually_exclusive)), 
              /*KEEP_STR*/"retain"), /*KEEP_STR*/"weak"));
      Attributes.$set$andassign(~ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_retain);
    } finally {
      $c$.$destroy();
    }
  } else if (((Attributes.$deref() & ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_strong) != 0)
     && ((Attributes.$deref() & ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_weak) != 0)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.err_objc_property_attr_mutually_exclusive)), 
              /*KEEP_STR*/"strong"), /*KEEP_STR*/"weak"));
      Attributes.$set$andassign(~ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_weak);
    } finally {
      $c$.$destroy();
    }
  }
  if (((Attributes.$deref() & ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_weak) != 0)) {
    {
      // 'weak' and 'nonnull' are mutually exclusive.
      Optional<NullabilityKind> nullability = PropertyTy.$arrow().getNullability($this().Context);
      if (nullability.$bool()) {
        if (nullability.$star() == NullabilityKind.NonNull) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.err_objc_property_attr_mutually_exclusive)), 
                    /*KEEP_STR*/"nonnull"), /*KEEP_STR*/"weak"));
          } finally {
            $c$.$destroy();
          }
        }
      }
    }
  }
  if (((Attributes.$deref() & ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_atomic) != 0)
     && ((Attributes.$deref() & ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_nonatomic) != 0)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.err_objc_property_attr_mutually_exclusive)), 
              /*KEEP_STR*/"atomic"), /*KEEP_STR*/"nonatomic"));
      Attributes.$set$andassign(~ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_atomic);
    } finally {
      $c$.$destroy();
    }
  }
  
  // Warn if user supplied no assignment attribute, property is
  // readwrite, and this is an object type.
  if (!(getOwnershipRule(Attributes.$deref()) != 0) && PropertyTy.$arrow().isObjCRetainableType()) {
    if (((Attributes.$deref() & ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_readonly) != 0)) {
      // do nothing
    } else if ($this().getLangOpts().ObjCAutoRefCount) {
      // With arc, @property definitions should default to strong when 
      // not specified.
      PropertyDecl.setPropertyAttributes(ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_strong);
    } else if (PropertyTy.$arrow().isObjCObjectPointerType()) {
      boolean isAnyClassTy = (PropertyTy.$arrow().isObjCClassType()
         || PropertyTy.$arrow().isObjCQualifiedClassType());
      // In non-gc, non-arc mode, 'Class' is treated as a 'void *' no need to
      // issue any warning.
      if (isAnyClassTy && $this().getLangOpts().getGC() == LangOptions.GCMode.NonGC) {
        ;
      } else if (propertyInPrimaryClass) {
        // Don't issue warning on property with no life time in class 
        // extension as it is inherited from property in primary class.
        // Skip this warning in gc-only mode.
        if ($this().getLangOpts().getGC() != LangOptions.GCMode.GCOnly) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track($this().Diag(new SourceLocation(Loc), diag.warn_objc_property_no_assignment_attribute)));
          } finally {
            $c$.$destroy();
          }
        }
        
        // If non-gc code warn that this is likely inappropriate.
        if ($this().getLangOpts().getGC() == LangOptions.GCMode.NonGC) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track($this().Diag(new SourceLocation(Loc), diag.warn_objc_property_default_assign_on_object)));
          } finally {
            $c$.$destroy();
          }
        }
      }
    }
    // FIXME: Implement warning dependent on NSCopying being
    // implemented. See also:
    // <rdar://5168496&4855821&5607453&5096644&4947311&5698469&4947014&5168496>
    // (please trim this list while you are at it).
  }
  if (!((Attributes.$deref() & ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_copy) != 0)
     && !((Attributes.$deref() & ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_readonly) != 0)
     && $this().getLangOpts().getGC() == LangOptions.GCMode.GCOnly
     && PropertyTy.$arrow().isBlockPointerType()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track($this().Diag(new SourceLocation(Loc), diag.warn_objc_property_copy_missing_on_block)));
    } finally {
      $c$.$destroy();
    }
  } else if (((Attributes.$deref() & ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_retain) != 0)
     && !((Attributes.$deref() & ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_readonly) != 0)
     && !((Attributes.$deref() & ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_strong) != 0)
     && PropertyTy.$arrow().isBlockPointerType()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track($this().Diag(new SourceLocation(Loc), diag.warn_objc_property_retain_of_block)));
    } finally {
      $c$.$destroy();
    }
  }
  if (((Attributes.$deref() & ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_readonly) != 0)
     && ((Attributes.$deref() & ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_setter) != 0)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track($this().Diag(new SourceLocation(Loc), diag.warn_objc_readonly_property_has_setter)));
    } finally {
      $c$.$destroy();
    }
  }
}


/// Process the specified property declaration and create decls for the
/// setters and getters as needed.
/// \param property The property declaration being processed

/// ProcessPropertyDecl - Make sure that any user-defined setter/getter methods
/// have the property type and issue diagnostics if they don't.
/// Also synthesize a getter/setter method if none exist (and update the
/// appropriate lookup tables.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ProcessPropertyDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaObjCProperty.cpp", line = 2144,
 FQN="clang::Sema::ProcessPropertyDecl", NM="_ZN5clang4Sema19ProcessPropertyDeclEPNS_16ObjCPropertyDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaObjCProperty.cpp -nm=_ZN5clang4Sema19ProcessPropertyDeclEPNS_16ObjCPropertyDeclE")
//</editor-fold>
public final void ProcessPropertyDecl(ObjCPropertyDecl /*P*/ property) {
  ObjCMethodDecl /*P*/ GetterMethod;
  ObjCMethodDecl /*P*/ SetterMethod;
  ObjCContainerDecl /*P*/ CD = cast_ObjCContainerDecl(property.getDeclContext());
  if (CD.isInvalidDecl()) {
    return;
  }
  
  boolean IsClassProperty = property.isClassProperty();
  GetterMethod = IsClassProperty ? CD.getClassMethod(property.getGetterName()) : CD.getInstanceMethod(property.getGetterName());
  
  // if setter or getter is not found in class extension, it might be
  // in the primary class.
  if (!(GetterMethod != null)) {
    {
      /*const*/ ObjCCategoryDecl /*P*/ CatDecl = dyn_cast_ObjCCategoryDecl(CD);
      if ((CatDecl != null)) {
        if (CatDecl.IsClassExtension()) {
          GetterMethod = IsClassProperty ? CatDecl.getClassInterface$Const().
              getClassMethod(property.getGetterName()) : CatDecl.getClassInterface$Const().
              getInstanceMethod(property.getGetterName());
        }
      }
    }
  }
  
  SetterMethod = IsClassProperty ? CD.getClassMethod(property.getSetterName()) : CD.getInstanceMethod(property.getSetterName());
  if (!(SetterMethod != null)) {
    {
      /*const*/ ObjCCategoryDecl /*P*/ CatDecl = dyn_cast_ObjCCategoryDecl(CD);
      if ((CatDecl != null)) {
        if (CatDecl.IsClassExtension()) {
          SetterMethod = IsClassProperty ? CatDecl.getClassInterface$Const().
              getClassMethod(property.getSetterName()) : CatDecl.getClassInterface$Const().
              getInstanceMethod(property.getSetterName());
        }
      }
    }
  }
  $this().DiagnosePropertyAccessorMismatch(property, GetterMethod, 
      property.getLocation());
  if ((SetterMethod != null)) {
    /*ObjCPropertyDecl::PropertyAttributeKind*//*uint*/int CAttr = property.getPropertyAttributes();
    if ((!((CAttr & ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_readonly) != 0))
       && $noteq_CanQual$T_CanQual$U($this().Context.getCanonicalType(SetterMethod.getReturnType()), 
        /*NO_COPY*/$this().Context.VoidTy)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track($this().Diag(SetterMethod.getLocation(), diag.err_setter_type_void)));
      } finally {
        $c$.$destroy();
      }
    }
    if (SetterMethod.param_size() != 1
       || !$this().Context.hasSameUnqualifiedType((SetterMethod.param_begin().$star()).getType().getNonReferenceType(), 
        property.getType().getNonReferenceType())) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(property.getLocation(), 
                    diag.warn_accessor_property_type_mismatch)), 
                property.getDeclName()), 
            SetterMethod.getSelector()));
        $c$.clean($c$.track($this().Diag(SetterMethod.getLocation(), diag.note_declared_at)));
      } finally {
        $c$.$destroy();
      }
    }
  }
  
  // Synthesize getter/setter methods if none exist.
  // Find the default getter and if one not found, add one.
  // FIXME: The synthesized property we set here is misleading. We almost always
  // synthesize these methods unless the user explicitly provided prototypes
  // (which is odd, but allowed). Sema should be typechecking that the
  // declarations jive in that situation (which it is not currently).
  if (!(GetterMethod != null)) {
    // No instance/class method of same name as property getter name was found.
    // Declare a getter method and add it to the list of methods
    // for this class.
    SourceLocation Loc = property.getLocation();
    
    // The getter returns the declared property type with all qualifiers
    // removed.
    QualType resultTy = property.getType().getAtomicUnqualifiedType();
    
    // If the property is null_resettable, the getter returns nonnull.
    if (((property.getPropertyAttributes()
       & ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_null_resettable) != 0)) {
      QualType modifiedTy = new QualType(resultTy);
      {
        Optional<NullabilityKind> nullability = AttributedType.stripOuterNullability(modifiedTy);
        if (nullability.$bool()) {
          if (nullability.$star() == NullabilityKind.Unspecified) {
            resultTy.$assignMove($this().Context.getAttributedType(AttributedType.Kind.attr_nonnull, 
                    new QualType(modifiedTy), new QualType(modifiedTy)));
          }
        }
      }
    }
    
    GetterMethod = ObjCMethodDecl.Create($this().Context, new SourceLocation(Loc), new SourceLocation(Loc), 
        property.getGetterName(), 
        new QualType(resultTy), (TypeSourceInfo /*P*/ )null, CD, 
        !IsClassProperty, /*isVariadic=*/ false, 
        /*isPropertyAccessor=*/ true, 
        /*isImplicitlyDeclared=*/ true, /*isDefined=*/ false, 
        (property.getPropertyImplementation()
           == ObjCPropertyDecl.PropertyControl.Optional) ? ObjCMethodDecl.ImplementationControl.Optional : ObjCMethodDecl.ImplementationControl.Required);
    CD.addDecl(GetterMethod);
    
    AddPropertyAttrs(/*Deref*/$this(), GetterMethod, property);
    if (property.hasAttr(NSReturnsNotRetainedAttr.class)) {
      GetterMethod.addAttr(NSReturnsNotRetainedAttr.CreateImplicit($this().Context, 
              new SourceRange(/*NO_COPY*/Loc)));
    }
    if (property.hasAttr(ObjCReturnsInnerPointerAttr.class)) {
      GetterMethod.addAttr(ObjCReturnsInnerPointerAttr.CreateImplicit($this().Context, new SourceRange(/*NO_COPY*/Loc)));
    }
    {
      
      /*const*/ SectionAttr /*P*/ SA = property.getAttr(SectionAttr.class);
      if ((SA != null)) {
        GetterMethod.addAttr(SectionAttr.CreateImplicit($this().Context, SectionAttr.Spelling.GNU_section, 
                SA.getName(), new SourceRange(/*NO_COPY*/Loc)));
      }
    }
    if ($this().getLangOpts().ObjCAutoRefCount) {
      $this().CheckARCMethodDecl(GetterMethod);
    }
  } else {
    // A user declared getter will be synthesize when @synthesize of
    // the property with the same name is seen in the @implementation
    GetterMethod.setPropertyAccessor(true);
  }
  property.setGetterMethodDecl(GetterMethod);
  
  // Skip setter if property is read-only.
  if (!property.isReadOnly()) {
    // Find the default setter and if one not found, add one.
    if (!(SetterMethod != null)) {
      // No instance/class method of same name as property setter name was
      // found.
      // Declare a setter method and add it to the list of methods
      // for this class.
      SourceLocation Loc = property.getLocation();
      
      SetterMethod
         = ObjCMethodDecl.Create($this().Context, new SourceLocation(Loc), new SourceLocation(Loc), 
          property.getSetterName(), $this().Context.VoidTy.$QualType(), 
          (TypeSourceInfo /*P*/ )null, CD, !IsClassProperty, 
          /*isVariadic=*/ false, 
          /*isPropertyAccessor=*/ true, 
          /*isImplicitlyDeclared=*/ true, 
          /*isDefined=*/ false, 
          (property.getPropertyImplementation()
             == ObjCPropertyDecl.PropertyControl.Optional) ? ObjCMethodDecl.ImplementationControl.Optional : ObjCMethodDecl.ImplementationControl.Required);
      
      // Remove all qualifiers from the setter's parameter type.
      QualType paramTy = property.getType().getUnqualifiedType().getAtomicUnqualifiedType();
      
      // If the property is null_resettable, the setter accepts a
      // nullable value.
      if (((property.getPropertyAttributes()
         & ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_null_resettable) != 0)) {
        QualType modifiedTy = new QualType(paramTy);
        {
          Optional<NullabilityKind> nullability = AttributedType.stripOuterNullability(modifiedTy);
          if (nullability.$bool()) {
            if (nullability.$star() == NullabilityKind.Unspecified) {
              paramTy.$assignMove($this().Context.getAttributedType(AttributedType.Kind.attr_nullable, 
                      new QualType(modifiedTy), new QualType(modifiedTy)));
            }
          }
        }
      }
      
      // Invent the arguments for the setter. We don't bother making a
      // nice name for the argument.
      ParmVarDecl /*P*/ Argument = ParmVarDecl.Create($this().Context, SetterMethod, 
          new SourceLocation(Loc), new SourceLocation(Loc), 
          property.getIdentifier(), 
          new QualType(paramTy), 
          /*TInfo=*/ (TypeSourceInfo /*P*/ )null, 
          StorageClass.SC_None, 
          (Expr /*P*/ )null);
      SetterMethod.setMethodParams($this().Context, new ArrayRef<ParmVarDecl /*P*/ >(Argument, true), new ArrayRef<SourceLocation>(None, false));
      
      AddPropertyAttrs(/*Deref*/$this(), SetterMethod, property);
      
      CD.addDecl(SetterMethod);
      {
        /*const*/ SectionAttr /*P*/ SA = property.getAttr(SectionAttr.class);
        if ((SA != null)) {
          SetterMethod.addAttr(SectionAttr.CreateImplicit($this().Context, SectionAttr.Spelling.GNU_section, 
                  SA.getName(), new SourceRange(/*NO_COPY*/Loc)));
        }
      }
      // It's possible for the user to have set a very odd custom
      // setter selector that causes it to have a method family.
      if ($this().getLangOpts().ObjCAutoRefCount) {
        $this().CheckARCMethodDecl(SetterMethod);
      }
    } else {
      // A user declared setter will be synthesize when @synthesize of
      // the property with the same name is seen in the @implementation
      SetterMethod.setPropertyAccessor(true);
    }
    property.setSetterMethodDecl(SetterMethod);
  }
  // Add any synthesized methods to the global pool. This allows us to
  // handle the following, which is supported by GCC (and part of the design).
  //
  // @interface Foo
  // @property double bar;
  // @end
  //
  // void thisIsUnfortunate() {
  //   id foo;
  //   double bar = [foo bar];
  // }
  //
  if (!IsClassProperty) {
    if ((GetterMethod != null)) {
      $this().AddInstanceMethodToGlobalPool(GetterMethod);
    }
    if ((SetterMethod != null)) {
      $this().AddInstanceMethodToGlobalPool(SetterMethod);
    }
  } else {
    if ((GetterMethod != null)) {
      $this().AddFactoryMethodToGlobalPool(GetterMethod);
    }
    if ((SetterMethod != null)) {
      $this().AddFactoryMethodToGlobalPool(SetterMethod);
    }
  }
  
  ObjCInterfaceDecl /*P*/ CurrentClass = dyn_cast_ObjCInterfaceDecl(CD);
  if (!(CurrentClass != null)) {
    {
      ObjCCategoryDecl /*P*/ Cat = dyn_cast_ObjCCategoryDecl(CD);
      if ((Cat != null)) {
        CurrentClass = Cat.getClassInterface();
      } else {
        ObjCImplDecl /*P*/ Impl = dyn_cast_ObjCImplDecl(CD);
        if ((Impl != null)) {
          CurrentClass = Impl.getClassInterface();
        }
      }
    }
  }
  if ((GetterMethod != null)) {
    $this().CheckObjCMethodOverrides(GetterMethod, CurrentClass, Sema.ResultTypeCompatibilityKind.RTC_Unknown);
  }
  if ((SetterMethod != null)) {
    $this().CheckObjCMethodOverrides(SetterMethod, CurrentClass, Sema.ResultTypeCompatibilityKind.RTC_Unknown);
  }
}


//===----------------------------------------------------------------------===//
// Helper methods.
//===----------------------------------------------------------------------===//

/// DiagnosePropertyMismatch - Compares two properties for their
/// attributes and types and warns on a variety of inconsistencies.
///
//<editor-fold defaultstate="collapsed" desc="clang::Sema::DiagnosePropertyMismatch">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaObjCProperty.cpp", line = 1415,
 FQN="clang::Sema::DiagnosePropertyMismatch", NM="_ZN5clang4Sema24DiagnosePropertyMismatchEPNS_16ObjCPropertyDeclES2_PKNS_14IdentifierInfoEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaObjCProperty.cpp -nm=_ZN5clang4Sema24DiagnosePropertyMismatchEPNS_16ObjCPropertyDeclES2_PKNS_14IdentifierInfoEb")
//</editor-fold>
public final void DiagnosePropertyMismatch(ObjCPropertyDecl /*P*/ Property, 
                        ObjCPropertyDecl /*P*/ SuperProperty, 
                        /*const*/ IdentifierInfo /*P*/ inheritedName, 
                        boolean OverridingProtocolProperty) {
  /*ObjCPropertyDecl::PropertyAttributeKind*//*uint*/int CAttr = Property.getPropertyAttributes();
  /*ObjCPropertyDecl::PropertyAttributeKind*//*uint*/int SAttr = SuperProperty.getPropertyAttributes();
  
  // We allow readonly properties without an explicit ownership
  // (assign/unsafe_unretained/weak/retain/strong/copy) in super class
  // to be overridden by a property with any explicit ownership in the subclass.
  if (!OverridingProtocolProperty
     && !(getOwnershipRule(SAttr) != 0) && (getOwnershipRule(CAttr) != 0)) {
    ;
  } else {
    if (((CAttr & ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_readonly) != 0)
       && ((SAttr & ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_readwrite) != 0)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Property.getLocation(), diag.warn_readonly_property)), 
                Property.getDeclName()), inheritedName));
      } finally {
        $c$.$destroy();
      }
    }
    if ((CAttr & ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_copy)
       != (SAttr & ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_copy)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Property.getLocation(), diag.warn_property_attribute)), 
                    Property.getDeclName()), /*KEEP_STR*/"copy"), inheritedName));
      } finally {
        $c$.$destroy();
      }
    } else if (!((SAttr & ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_readonly) != 0)) {
      /*uint*/int CAttrRetain = (CAttr
         & (ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_retain | ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_strong));
      /*uint*/int SAttrRetain = (SAttr
         & (ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_retain | ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_strong));
      boolean CStrong = (CAttrRetain != 0);
      boolean SStrong = (SAttrRetain != 0);
      if (CStrong != SStrong) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Property.getLocation(), diag.warn_property_attribute)), 
                      Property.getDeclName()), /*KEEP_STR*/"retain (or strong)"), inheritedName));
        } finally {
          $c$.$destroy();
        }
      }
    }
  }
  
  // Check for nonatomic; note that nonatomic is effectively
  // meaningless for readonly properties, so don't diagnose if the
  // atomic property is 'readonly'.
  checkAtomicPropertyMismatch(/*Deref*/$this(), SuperProperty, Property, false);
  if (Property.getSetterName().$noteq(SuperProperty.getSetterName())) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Property.getLocation(), diag.warn_property_attribute)), 
                  Property.getDeclName()), /*KEEP_STR*/"setter"), inheritedName));
      $c$.clean($c$.track($this().Diag(SuperProperty.getLocation(), diag.note_property_declare)));
    } finally {
      $c$.$destroy();
    }
  }
  if (Property.getGetterName().$noteq(SuperProperty.getGetterName())) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Property.getLocation(), diag.warn_property_attribute)), 
                  Property.getDeclName()), /*KEEP_STR*/"getter"), inheritedName));
      $c$.clean($c$.track($this().Diag(SuperProperty.getLocation(), diag.note_property_declare)));
    } finally {
      $c$.$destroy();
    }
  }
  
  QualType LHSType = $this().Context.getCanonicalType(SuperProperty.getType()).$QualType();
  QualType RHSType = $this().Context.getCanonicalType(Property.getType()).$QualType();
  if (!$this().Context.propertyTypesAreCompatible(new QualType(LHSType), new QualType(RHSType))) {
    // Do cases not handled in above.
    // FIXME. For future support of covariant property types, revisit this.
    bool$ref IncompatibleObjC = create_bool$ref(false);
    QualType ConvertedType/*J*/= new QualType();
    if (!$this().isObjCPointerConversion(new QualType(RHSType), new QualType(LHSType), 
        ConvertedType, IncompatibleObjC)
       || IncompatibleObjC.$deref()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Property.getLocation(), diag.warn_property_types_are_incompatible)), 
                    Property.getType()), SuperProperty.getType()), inheritedName));
        $c$.clean($c$.track($this().Diag(SuperProperty.getLocation(), diag.note_property_declare)));
      } finally {
        $c$.$destroy();
      }
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnProperty">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaObjCProperty.cpp", line = 178,
 FQN="clang::Sema::ActOnProperty", NM="_ZN5clang4Sema13ActOnPropertyEPNS_5ScopeENS_14SourceLocationES3_RNS_15FieldDeclaratorERNS_12ObjCDeclSpecENS_8SelectorES8_NS_3tok15ObjCKeywordKindEPNS_11DeclContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaObjCProperty.cpp -nm=_ZN5clang4Sema13ActOnPropertyEPNS_5ScopeENS_14SourceLocationES3_RNS_15FieldDeclaratorERNS_12ObjCDeclSpecENS_8SelectorES8_NS_3tok15ObjCKeywordKindEPNS_11DeclContextE")
//</editor-fold>
public final Decl /*P*/ ActOnProperty(Scope /*P*/ S, SourceLocation AtLoc, 
             SourceLocation LParenLoc, 
             final FieldDeclarator /*&*/ FD, 
             final ObjCDeclSpec /*&*/ ODS, 
             Selector GetterSel, 
             Selector SetterSel, 
             /*tok.ObjCKeywordKind*/char MethodImplKind) {
  return ActOnProperty(S, AtLoc, 
             LParenLoc, 
             FD, 
             ODS, 
             GetterSel, 
             SetterSel, 
             MethodImplKind, 
             (DeclContext /*P*/ )null);
}
public final Decl /*P*/ ActOnProperty(Scope /*P*/ S, SourceLocation AtLoc, 
             SourceLocation LParenLoc, 
             final FieldDeclarator /*&*/ FD, 
             final ObjCDeclSpec /*&*/ ODS, 
             Selector GetterSel, 
             Selector SetterSel, 
             /*tok.ObjCKeywordKind*/char MethodImplKind, 
             DeclContext /*P*/ lexicalDC/*= null*/) {
  uint$ref Attributes = create_uint$ref(ODS.getPropertyAttributes());
  FD.D.setObjCWeakProperty((Attributes.$deref() & ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_weak) != 0);
  TypeSourceInfo /*P*/ TSI = $this().GetTypeForDeclarator(FD.D, S);
  QualType T = TSI.getType();
  if (!(getOwnershipRule(Attributes.$deref()) != 0)) {
    Attributes.$set$orassign(deducePropertyOwnershipFromType(/*Deref*/$this(), new QualType(T)));
  }
  boolean isReadWrite = (((Attributes.$deref() & ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_readwrite) != 0)
    // default is readwrite!
     || !((Attributes.$deref() & ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_readonly) != 0));
  
  // Proceed with constructing the ObjCPropertyDecls.
  ObjCContainerDecl /*P*/ ClassDecl = cast_ObjCContainerDecl($this().CurContext);
  ObjCPropertyDecl /*P*/ Res = null;
  {
    ObjCCategoryDecl /*P*/ CDecl = dyn_cast_ObjCCategoryDecl(ClassDecl);
    if ((CDecl != null)) {
      if (CDecl.IsClassExtension()) {
        Res = $this().HandlePropertyInClassExtension(S, new SourceLocation(AtLoc), new SourceLocation(LParenLoc), 
            FD, new Selector(GetterSel), new Selector(SetterSel), 
            isReadWrite, 
            Attributes, 
            ODS.getPropertyAttributes(), 
            new QualType(T), TSI, MethodImplKind);
        if (!(Res != null)) {
          return null;
        }
      }
    }
  }
  if (!(Res != null)) {
    Res = $this().CreatePropertyDecl(S, ClassDecl, new SourceLocation(AtLoc), new SourceLocation(LParenLoc), FD, 
        new Selector(GetterSel), new Selector(SetterSel), isReadWrite, 
        Attributes.$deref(), ODS.getPropertyAttributes(), 
        new QualType(T), TSI, MethodImplKind);
    if ((lexicalDC != null)) {
      Res.setLexicalDeclContext(lexicalDC);
    }
  }
  
  // Validate the attributes on the @property.
  $this().CheckObjCPropertyAttributes(Res, new SourceLocation(AtLoc), Attributes, 
      (isa_ObjCInterfaceDecl(ClassDecl)
         || isa_ObjCProtocolDecl(ClassDecl)));
  
  // Check consistency if the type has explicit ownership qualification.
  if ((Res.getType().getObjCLifetime().getValue() != 0)) {
    checkPropertyDeclWithOwnership(/*Deref*/$this(), Res);
  }
  
  SmallPtrSet<ObjCProtocolDecl /*P*/ > KnownProtos/*J*/= new SmallPtrSet<ObjCProtocolDecl /*P*/ >(DenseMapInfo$LikePtr.$Info(), 16);
  {
    ObjCInterfaceDecl /*P*/ IFace = dyn_cast_ObjCInterfaceDecl(ClassDecl);
    if ((IFace != null)) {
      // For a class, compare the property against a property in our superclass.
      boolean FoundInSuper = false;
      ObjCInterfaceDecl /*P*/ CurrentInterfaceDecl = IFace;
      {
        ObjCInterfaceDecl /*P*/ Super;
        while (((/*P*/ Super = CurrentInterfaceDecl.getSuperClass()) != null)) {
          DeclContextLookupResult R = Super.lookup(Res.getDeclName());
          for (/*uint*/int I = 0, N = R.size(); I != N; ++I) {
            {
              ObjCPropertyDecl /*P*/ SuperProp = dyn_cast_ObjCPropertyDecl(R.$at(I));
              if ((SuperProp != null)) {
                $this().DiagnosePropertyMismatch(Res, SuperProp, Super.getIdentifier(), false);
                FoundInSuper = true;
                break;
              }
            }
          }
          if (FoundInSuper) {
            break;
          } else {
            CurrentInterfaceDecl = Super;
          }
        }
      }
      if (FoundInSuper) {
        // Also compare the property against a property in our protocols.
        for (ObjCProtocolDecl /*P*/ P : CurrentInterfaceDecl.protocols()) {
          CheckPropertyAgainstProtocol(/*Deref*/$this(), Res, P, KnownProtos);
        }
      } else {
        // Slower path: look in all protocols we referenced.
        for (ObjCProtocolDecl /*P*/ P : IFace.all_referenced_protocols()) {
          CheckPropertyAgainstProtocol(/*Deref*/$this(), Res, P, KnownProtos);
        }
      }
    } else {
      ObjCCategoryDecl /*P*/ Cat = dyn_cast_ObjCCategoryDecl(ClassDecl);
      if ((Cat != null)) {
        // We don't check if class extension. Because properties in class extension
        // are meant to override some of the attributes and checking has already done
        // when property in class extension is constructed.
        if (!Cat.IsClassExtension()) {
          for (ObjCProtocolDecl /*P*/ P : Cat.protocols())  {
            CheckPropertyAgainstProtocol(/*Deref*/$this(), Res, P, KnownProtos);
          }
        }
      } else {
        ObjCProtocolDecl /*P*/ Proto = cast_ObjCProtocolDecl(ClassDecl);
        for (ObjCProtocolDecl /*P*/ P : Proto.protocols())  {
          CheckPropertyAgainstProtocol(/*Deref*/$this(), Res, P, KnownProtos);
        }
      }
    }
  }
  
  $this().ActOnDocumentableDecl(Res);
  return Res;
}


/// ActOnPropertyImplDecl - This routine performs semantic checks and
/// builds the AST node for a property implementation declaration; declared
/// as \@synthesize or \@dynamic.
///
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnPropertyImplDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaObjCProperty.cpp", line = 895,
 FQN="clang::Sema::ActOnPropertyImplDecl", NM="_ZN5clang4Sema21ActOnPropertyImplDeclEPNS_5ScopeENS_14SourceLocationES3_bPNS_14IdentifierInfoES5_S3_NS_21ObjCPropertyQueryKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaObjCProperty.cpp -nm=_ZN5clang4Sema21ActOnPropertyImplDeclEPNS_5ScopeENS_14SourceLocationES3_bPNS_14IdentifierInfoES5_S3_NS_21ObjCPropertyQueryKindE")
//</editor-fold>
public final Decl /*P*/ ActOnPropertyImplDecl(Scope /*P*/ S, 
                     SourceLocation AtLoc, 
                     SourceLocation PropertyLoc, 
                     boolean Synthesize, 
                     IdentifierInfo /*P*/ PropertyId, 
                     IdentifierInfo /*P*/ PropertyIvar, 
                     SourceLocation PropertyIvarLoc, 
                     /*ObjCPropertyQueryKind*/byte/*uint8_t*/ QueryKind) {
  ObjCContainerDecl /*P*/ ClassImpDecl = dyn_cast_ObjCContainerDecl($this().CurContext);
  // Make sure we have a context for the property implementation declaration.
  if (!(ClassImpDecl != null)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track($this().Diag(new SourceLocation(AtLoc), diag.error_missing_property_context)));
      return null;
    } finally {
      $c$.$destroy();
    }
  }
  if (PropertyIvarLoc.isInvalid()) {
    PropertyIvarLoc.$assign(PropertyLoc);
  }
  SourceLocation PropertyDiagLoc = new SourceLocation(PropertyLoc);
  if (PropertyDiagLoc.isInvalid()) {
    PropertyDiagLoc.$assignMove(ClassImpDecl.getLocStart());
  }
  ObjCPropertyDecl /*P*/ property = null;
  ObjCInterfaceDecl /*P*/ IDecl = null;
  // Find the class or category class where this property must have
  // a declaration.
  ObjCImplementationDecl /*P*/ IC = null;
  ObjCCategoryImplDecl /*P*/ CatImplClass = null;
  if (((IC = dyn_cast_ObjCImplementationDecl(ClassImpDecl)) != null)) {
    IDecl = IC.getClassInterface();
    // We always synthesize an interface for an implementation
    // without an interface decl. So, IDecl is always non-zero.
    assert ((IDecl != null)) : "ActOnPropertyImplDecl - @implementation without @interface";
    
    // Look for this property declaration in the @implementation's @interface
    property = IDecl.FindPropertyDeclaration(PropertyId, QueryKind);
    if (!(property != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(PropertyLoc), diag.error_bad_property_decl)), IDecl.getDeclName()));
        return null;
      } finally {
        $c$.$destroy();
      }
    }
    if (property.isClassProperty() && Synthesize) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(PropertyLoc), diag.error_synthesize_on_class_property)), PropertyId));
        return null;
      } finally {
        $c$.$destroy();
      }
    }
    /*uint*/int PIkind = property.getPropertyAttributesAsWritten();
    if ((PIkind & (ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_atomic
       | ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_nonatomic)) == 0) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        if (AtLoc.isValid()) {
          $c$.clean($c$.track($this().Diag(new SourceLocation(AtLoc), diag.warn_implicit_atomic_property)));
        } else {
          $c$.clean($c$.track($this().Diag(IC.getLocation(), diag.warn_auto_implicit_atomic_property)));
        }
        $c$.clean($c$.track($this().Diag(property.getLocation(), diag.note_property_declare)));
      } finally {
        $c$.$destroy();
      }
    }
    {
      
      /*const*/ ObjCCategoryDecl /*P*/ CD = dyn_cast_ObjCCategoryDecl(property.getDeclContext());
      if ((CD != null)) {
        if (!CD.IsClassExtension()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(PropertyLoc), diag.error_category_property)), CD.getDeclName()));
            $c$.clean($c$.track($this().Diag(property.getLocation(), diag.note_property_declare)));
            return null;
          } finally {
            $c$.$destroy();
          }
        }
      }
    }
    if (Synthesize
       && ((PIkind & ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_readonly) != 0)
       && property.hasAttr(IBOutletAttr.class)
       && !AtLoc.isValid()) {
      boolean ReadWriteProperty = false;
      // Search into the class extensions and see if 'readonly property is
      // redeclared 'readwrite', then no warning is to be issued.
      for (ObjCCategoryDecl /*P*/ Ext : IDecl.known_extensions()) {
        DeclContextLookupResult R = Ext.lookup(property.getDeclName());
        if (!R.empty()) {
          {
            ObjCPropertyDecl /*P*/ ExtProp = dyn_cast_ObjCPropertyDecl(R.$at(0));
            if ((ExtProp != null)) {
              PIkind = ExtProp.getPropertyAttributesAsWritten();
              if (((PIkind & ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_readwrite) != 0)) {
                ReadWriteProperty = true;
                break;
              }
            }
          }
        }
      }
      if (!ReadWriteProperty) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(property.getLocation(), diag.warn_auto_readonly_iboutlet_property)), 
              property));
          SourceLocation readonlyLoc/*J*/= new SourceLocation();
          if (LocPropertyAttribute($this().Context, $("readonly"), 
              property.getLParenLoc(), readonlyLoc)) {
            SourceLocation endLoc = readonlyLoc.getLocWithOffset(strlen(/*KEEP_STR*/"readonly") - 1);
            SourceRange ReadonlySourceRange/*J*/= new SourceRange(/*NO_COPY*/readonlyLoc, /*NO_COPY*/endLoc);
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(property.getLocation(), 
                    diag.note_auto_readonly_iboutlet_fixup_suggest)), 
                FixItHint.CreateReplacement(/*NO_COPY*/ReadonlySourceRange, new StringRef(/*KEEP_STR*/"readwrite"))));
          }
        } finally {
          $c$.$destroy();
        }
      }
    }
    if (Synthesize && isa_ObjCProtocolDecl(property.getDeclContext())) {
      DiagnosePropertyMismatchDeclInProtocols(/*Deref*/$this(), new SourceLocation(AtLoc), IDecl, property);
    }
  } else if (((CatImplClass = dyn_cast_ObjCCategoryImplDecl(ClassImpDecl)) != null)) {
    if (Synthesize) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track($this().Diag(new SourceLocation(AtLoc), diag.error_synthesize_category_decl)));
        return null;
      } finally {
        $c$.$destroy();
      }
    }
    IDecl = CatImplClass.getClassInterface();
    if (!(IDecl != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track($this().Diag(new SourceLocation(AtLoc), diag.error_missing_property_interface)));
        return null;
      } finally {
        $c$.$destroy();
      }
    }
    ObjCCategoryDecl /*P*/ Category = IDecl.FindCategoryDeclaration(CatImplClass.getIdentifier());
    
    // If category for this implementation not found, it is an error which
    // has already been reported eralier.
    if (!(Category != null)) {
      return null;
    }
    // Look for this property declaration in @implementation's category
    property = Category.FindPropertyDeclaration(PropertyId, QueryKind);
    if (!(property != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(PropertyLoc), diag.error_bad_category_property_decl)), 
            Category.getDeclName()));
        return null;
      } finally {
        $c$.$destroy();
      }
    }
  } else {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track($this().Diag(new SourceLocation(AtLoc), diag.error_bad_property_context)));
      return null;
    } finally {
      $c$.$destroy();
    }
  }
  ObjCIvarDecl /*P*/ Ivar = null;
  boolean CompleteTypeErr = false;
  boolean compat = true;
  // Check that we have a valid, previously declared ivar for @synthesize
  if (Synthesize) {
    // @synthesize
    if (!(PropertyIvar != null)) {
      PropertyIvar = PropertyId;
    }
    // Check that this is a previously declared 'ivar' in 'IDecl' interface
    type$ref<ObjCInterfaceDecl /*P*/ > ClassDeclared = create_type$ref();
    Ivar = IDecl.lookupInstanceVariable(PropertyIvar, ClassDeclared);
    QualType PropType = property.getType();
    QualType PropertyIvarType = PropType.getNonReferenceType();
    if ($this().RequireCompleteType$T(new SourceLocation(PropertyDiagLoc), new QualType(PropertyIvarType), 
        diag.err_incomplete_synthesized_property, 
        property.getDeclName())) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track($this().Diag(property.getLocation(), diag.note_property_declare)));
        CompleteTypeErr = true;
      } finally {
        $c$.$destroy();
      }
    }
    if ($this().getLangOpts().ObjCAutoRefCount
       && ((property.getPropertyAttributesAsWritten()
       & ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_readonly) != 0)
       && PropertyIvarType.$arrow().isObjCRetainableType()) {
      setImpliedPropertyAttributeForReadOnlyProperty(property, Ivar);
    }
    
    /*ObjCPropertyDecl::PropertyAttributeKind*//*uint*/int kind = property.getPropertyAttributes();
    
    boolean isARCWeak = false;
    if (((kind & ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_weak) != 0)) {
      // Add GC __weak to the ivar type if the property is weak.
      if ($this().getLangOpts().getGC() != LangOptions.GCMode.NonGC) {
        assert (!$this().getLangOpts().ObjCAutoRefCount);
        if (PropertyIvarType.isObjCGCStrong()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track($this().Diag(new SourceLocation(PropertyDiagLoc), diag.err_gc_weak_property_strong_type)));
            $c$.clean($c$.track($this().Diag(property.getLocation(), diag.note_property_declare)));
          } finally {
            $c$.$destroy();
          }
        } else {
          PropertyIvarType.$assignMove(
              $this().Context.getObjCGCQualType(new QualType(PropertyIvarType), Qualifiers.GC.Weak)
          );
        }
        // Otherwise, check whether ARC __weak is enabled and works with
        // the property type.
      } else {
        if (!$this().getLangOpts().ObjCWeak) {
          // Only complain here when synthesizing an ivar.
          if (!(Ivar != null)) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($c$.track($this().Diag(new SourceLocation(PropertyDiagLoc), 
                  $this().getLangOpts().ObjCWeakRuntime ? diag.err_synthesizing_arc_weak_property_disabled : diag.err_synthesizing_arc_weak_property_no_runtime)));
              $c$.clean($c$.track($this().Diag(property.getLocation(), diag.note_property_declare)));
            } finally {
              $c$.$destroy();
            }
          }
          CompleteTypeErr = true; // suppress later diagnostics about the ivar
        } else {
          isARCWeak = true;
          {
            /*const*/ ObjCObjectPointerType /*P*/ ObjT = PropertyIvarType.$arrow().getAs(ObjCObjectPointerType.class);
            if ((ObjT != null)) {
              /*const*/ ObjCInterfaceDecl /*P*/ ObjI = ObjT.getInterfaceDecl();
              if ((ObjI != null) && ObjI.isArcWeakrefUnavailable()) {
                JavaCleaner $c$ = $createJavaCleaner();
                try {
                  $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(property.getLocation(), 
                          diag.err_arc_weak_unavailable_property)), 
                      PropertyIvarType));
                  $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(ClassImpDecl.getLocation(), diag.note_implemented_by_class)), 
                      ClassImpDecl.getName()));
                } finally {
                  $c$.$destroy();
                }
              }
            }
          }
        }
      }
    }
    if (AtLoc.isInvalid()) {
      // Check when default synthesizing a property that there is 
      // an ivar matching property name and issue warning; since this
      // is the most common case of not using an ivar used for backing
      // property in non-default synthesis case.
      type$ref<ObjCInterfaceDecl /*P*/ > ClassDeclared$1 = create_type$null$ref(null);
      ObjCIvarDecl /*P*/ originalIvar = IDecl.lookupInstanceVariable(property.getIdentifier(), 
          ClassDeclared$1);
      if ((originalIvar != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(PropertyDiagLoc), 
                              diag.warn_autosynthesis_property_ivar_match)), 
                          PropertyId), (Ivar == (ObjCIvarDecl /*P*/ )null)), PropertyIvar), 
              originalIvar.getIdentifier()));
          $c$.clean($c$.track($this().Diag(property.getLocation(), diag.note_property_declare)));
          $c$.clean($c$.track($this().Diag(originalIvar.getLocation(), diag.note_ivar_decl)));
        } finally {
          $c$.$destroy();
        }
      }
    }
    if (!(Ivar != null)) {
      // In ARC, give the ivar a lifetime qualifier based on the
      // property attributes.
      if (($this().getLangOpts().ObjCAutoRefCount || isARCWeak)
         && !(PropertyIvarType.getObjCLifetime().getValue() != 0)
         && PropertyIvarType.$arrow().isObjCRetainableType()) {
        
        // It's an error if we have to do this and the user didn't
        // explicitly write an ownership attribute on the property.
        if (!hasWrittenStorageAttribute(property, QueryKind)
           && !((kind & ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_strong) != 0)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track($this().Diag(new SourceLocation(PropertyDiagLoc), 
                diag.err_arc_objc_property_default_assign_on_object)));
            $c$.clean($c$.track($this().Diag(property.getLocation(), diag.note_property_declare)));
          } finally {
            $c$.$destroy();
          }
        } else {
          Qualifiers.ObjCLifetime lifetime = getImpliedARCOwnership(kind, new QualType(PropertyIvarType));
          assert ((lifetime.getValue() != 0)) : "no lifetime for property?";
          
          Qualifiers qs/*J*/= new Qualifiers();
          qs.addObjCLifetime(lifetime);
          PropertyIvarType.$assignMove($this().Context.getQualifiedType(new QualType(PropertyIvarType), new Qualifiers(qs)));
        }
      }
      
      Ivar = ObjCIvarDecl.Create($this().Context, ClassImpDecl, 
          new SourceLocation(PropertyIvarLoc), new SourceLocation(PropertyIvarLoc), PropertyIvar, 
          new QualType(PropertyIvarType), /*Dinfo=*/ (TypeSourceInfo /*P*/ )null, 
          ObjCIvarDecl.AccessControl.Private, 
          (Expr /*P*/ )(Expr /*P*/ )null, true);
      if ($this().RequireNonAbstractType$T(new SourceLocation(PropertyIvarLoc), 
          new QualType(PropertyIvarType), 
          diag.err_abstract_type_in_decl, 
          AbstractDiagSelID.AbstractSynthesizedIvarType)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag(property.getLocation(), diag.note_property_declare)));
          Ivar.setInvalidDecl();
        } finally {
          $c$.$destroy();
        }
      } else if (CompleteTypeErr) {
        Ivar.setInvalidDecl();
      }
      ClassImpDecl.addDecl(Ivar);
      IDecl.makeDeclVisibleInContext(Ivar);
      if ($this().getLangOpts().ObjCRuntime.isFragile()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(PropertyDiagLoc), diag.error_missing_property_ivar_decl)), 
              PropertyId));
        } finally {
          $c$.$destroy();
        }
      }
      // Note! I deliberately want it to fall thru so, we have a
      // a property implementation and to avoid future warnings.
    } else if ($this().getLangOpts().ObjCRuntime.isNonFragile()
       && !declaresSameEntity(ClassDeclared.$deref(), IDecl)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(PropertyDiagLoc), diag.error_ivar_in_superclass_use)), 
                    property.getDeclName()), Ivar.getDeclName()), 
            ClassDeclared.$deref().getDeclName()));
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Ivar.getLocation(), diag.note_previous_access_declaration)), 
                Ivar), Ivar.getName()));
      } finally {
        $c$.$destroy();
      }
      // Note! I deliberately want it to fall thru so more errors are caught.
    }
    property.setPropertyIvarDecl(Ivar);
    
    QualType IvarType = $this().Context.getCanonicalType(Ivar.getType()).$QualType();
    
    // Check that type of property and its ivar are type compatible.
    if (!$this().Context.hasSameType(new QualType(PropertyIvarType), new QualType(IvarType))) {
      if (isa_ObjCObjectPointerType(PropertyIvarType)
         && isa_ObjCObjectPointerType(IvarType)) {
        compat
           = $this().Context.canAssignObjCInterfaces(PropertyIvarType.$arrow().getAs(ObjCObjectPointerType.class), 
            IvarType.$arrow().getAs(ObjCObjectPointerType.class));
      } else {
        compat = ($this().CheckAssignmentConstraints(new SourceLocation(PropertyIvarLoc), new QualType(PropertyIvarType), 
            new QualType(IvarType))
           == AssignConvertType.Compatible);
      }
      if (!compat) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(PropertyDiagLoc), diag.error_property_ivar_type)), 
                          property.getDeclName()), PropType), 
                  Ivar.getDeclName()), IvarType));
          $c$.clean($c$.track($this().Diag(Ivar.getLocation(), diag.note_ivar_decl)));
        } finally {
          $c$.$destroy();
        }
        // Note! I deliberately want it to fall thru so, we have a
        // a property implementation and to avoid future warnings.
      } else {
        // FIXME! Rules for properties are somewhat different that those
        // for assignments. Use a new routine to consolidate all cases;
        // specifically for property redeclarations as well as for ivars.
        QualType lhsType = $this().Context.getCanonicalType(new QualType(PropertyIvarType)).getUnqualifiedType().$QualType();
        QualType rhsType = $this().Context.getCanonicalType(new QualType(IvarType)).getUnqualifiedType().$QualType();
        if ($noteq_QualType$C(lhsType, rhsType)
           && lhsType.$arrow().isArithmeticType()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(PropertyDiagLoc), diag.error_property_ivar_type)), 
                            property.getDeclName()), PropType), 
                    Ivar.getDeclName()), IvarType));
            $c$.clean($c$.track($this().Diag(Ivar.getLocation(), diag.note_ivar_decl)));
          } finally {
            $c$.$destroy();
          }
          // Fall thru - see previous comment
        }
      }
      // __weak is explicit. So it works on Canonical type.
      if ((PropType.isObjCGCWeak() && !IvarType.isObjCGCWeak()
         && $this().getLangOpts().getGC() != LangOptions.GCMode.NonGC)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(PropertyDiagLoc), diag.error_weak_property)), 
                  property.getDeclName()), Ivar.getDeclName()));
          $c$.clean($c$.track($this().Diag(Ivar.getLocation(), diag.note_ivar_decl)));
        } finally {
          $c$.$destroy();
        }
        // Fall thru - see previous comment
      }
      // Fall thru - see previous comment
      if ((property.getType().$arrow().isObjCObjectPointerType()
         || PropType.isObjCGCStrong()) && IvarType.isObjCGCWeak()
         && $this().getLangOpts().getGC() != LangOptions.GCMode.NonGC) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(PropertyDiagLoc), diag.error_strong_property)), 
                  property.getDeclName()), Ivar.getDeclName()));
        } finally {
          $c$.$destroy();
        }
        // Fall thru - see previous comment
      }
    }
    if ($this().getLangOpts().ObjCAutoRefCount || isARCWeak
       || (Ivar.getType().getObjCLifetime().getValue() != 0)) {
      checkARCPropertyImpl(/*Deref*/$this(), new SourceLocation(PropertyLoc), property, Ivar);
    }
  } else if ((PropertyIvar != null)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // @dynamic
      $c$.clean($c$.track($this().Diag(new SourceLocation(PropertyDiagLoc), diag.error_dynamic_property_ivar_decl)));
    } finally {
      $c$.$destroy();
    }
  }
  assert ((property != null)) : "ActOnPropertyImplDecl - property declaration missing";
  ObjCPropertyImplDecl /*P*/ PIDecl = ObjCPropertyImplDecl.Create($this().Context, $this().CurContext, new SourceLocation(AtLoc), new SourceLocation(PropertyLoc), 
      property, 
      (Synthesize ? ObjCPropertyImplDecl.Kind.Synthesize : ObjCPropertyImplDecl.Kind.Dynamic), 
      Ivar, new SourceLocation(PropertyIvarLoc));
  if (CompleteTypeErr || !compat) {
    PIDecl.setInvalidDecl();
  }
  {
    
    ObjCMethodDecl /*P*/ getterMethod = property.getGetterMethodDecl();
    if ((getterMethod != null)) {
      getterMethod.createImplicitParams($this().Context, IDecl);
      if ($this().getLangOpts().CPlusPlus && Synthesize && !CompleteTypeErr
         && Ivar.getType().$arrow().isRecordType()) {
        SynthesizedFunctionScope Scope = null;
        try {
          // For Objective-C++, need to synthesize the AST for the IVAR object to be
          // returned by the getter as it must conform to C++'s copy-return rules.
          // FIXME. Eventually we want to do this for Objective-C as well.
          Scope/*J*/= new SynthesizedFunctionScope(/*Deref*/$this(), getterMethod);
          ImplicitParamDecl /*P*/ SelfDecl = getterMethod.getSelfDecl();
          DeclRefExpr /*P*/ SelfExpr = /*FIXME:NEW_EXPR*//*new (Context)*/ Stmt.$new_uint_ASTContext$C$P_uint($this().Context, (type$ptr<?> Mem)->
                  new DeclRefExpr(SelfDecl, false, SelfDecl.getType(), ExprValueKind.VK_LValue, new SourceLocation(PropertyDiagLoc))
          );
          $this().MarkDeclRefReferenced(SelfExpr);
          Expr /*P*/ LoadSelfExpr = ImplicitCastExpr.Create($this().Context, SelfDecl.getType(), 
              CastKind.CK_LValueToRValue, SelfExpr, (/*const*/SmallVector<CXXBaseSpecifier /*P*/> /*P*/)null, 
              ExprValueKind.VK_RValue);
          final ObjCIvarDecl /*P*/ $Ivar = Ivar;
          Expr /*P*/ IvarRefExpr = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->new ObjCIvarRefExpr($Ivar, 
              $Ivar.getUsageType(SelfDecl.getType()), 
              new SourceLocation(PropertyDiagLoc), 
              $Ivar.getLocation(), 
              LoadSelfExpr, true, true));
          ActionResultTTrue<Expr /*P*/ > Res = $this().PerformCopyInitialization(InitializedEntity.InitializeResult(new SourceLocation(PropertyDiagLoc), 
                  getterMethod.getReturnType(), 
                  /*NRVO=*/ false), 
              new SourceLocation(PropertyDiagLoc), new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, IvarRefExpr));
          if (!Res.isInvalid()) {
            Expr /*P*/ ResExpr = Res.getAs(Expr.class);
            if ((ResExpr != null)) {
              ResExpr = $this().MaybeCreateExprWithCleanups(ResExpr);
            }
            PIDecl.setGetterCXXConstructor(ResExpr);
          }
        } finally {
          if (Scope != null) { Scope.$destroy(); }
        }
      }
      if (property.hasAttr(NSReturnsNotRetainedAttr.class)
         && !getterMethod.hasAttr(NSReturnsNotRetainedAttr.class)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag(getterMethod.getLocation(), 
              diag.warn_property_getter_owning_mismatch)));
          $c$.clean($c$.track($this().Diag(property.getLocation(), diag.note_property_declare)));
        } finally {
          $c$.$destroy();
        }
      }
      if ($this().getLangOpts().ObjCAutoRefCount && Synthesize) {
        switch (getterMethod.getMethodFamily()) {
         case OMF_retain:
         case OMF_retainCount:
         case OMF_release:
         case OMF_autorelease:
          {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(getterMethod.getLocation(), diag.err_arc_illegal_method_def)), 
                      1), getterMethod.getSelector()));
              break;
            } finally {
              $c$.$destroy();
            }
          }
         default:
          break;
        }
      }
    }
  }
  {
    ObjCMethodDecl /*P*/ setterMethod = property.getSetterMethodDecl();
    if ((setterMethod != null)) {
      setterMethod.createImplicitParams($this().Context, IDecl);
      if ($this().getLangOpts().CPlusPlus && Synthesize && !CompleteTypeErr
         && Ivar.getType().$arrow().isRecordType()) {
        SynthesizedFunctionScope Scope = null;
        try {
          // FIXME. Eventually we want to do this for Objective-C as well.
          Scope/*J*/= new SynthesizedFunctionScope(/*Deref*/$this(), setterMethod);
          ImplicitParamDecl /*P*/ SelfDecl = setterMethod.getSelfDecl();
          DeclRefExpr /*P*/ SelfExpr = /*FIXME:NEW_EXPR*//*new (Context)*/ Stmt.$new_uint_ASTContext$C$P_uint($this().Context, (type$ptr<?> Mem)->
                  new DeclRefExpr(SelfDecl, false, SelfDecl.getType(), ExprValueKind.VK_LValue, new SourceLocation(PropertyDiagLoc))
          );
          $this().MarkDeclRefReferenced(SelfExpr);
          Expr /*P*/ LoadSelfExpr = ImplicitCastExpr.Create($this().Context, SelfDecl.getType(), 
              CastKind.CK_LValueToRValue, SelfExpr, (/*const*/SmallVector<CXXBaseSpecifier /*P*/> /*P*/)null, 
              ExprValueKind.VK_RValue);
          final ObjCIvarDecl /*P*/ $Ivar = Ivar;
          Expr /*P*/ lhs = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->new ObjCIvarRefExpr($Ivar, 
              $Ivar.getUsageType(SelfDecl.getType()), 
              new SourceLocation(PropertyDiagLoc), 
              $Ivar.getLocation(), 
              LoadSelfExpr, true, true));
          type$ptr<ParmVarDecl /*P*/ /*const*/ /*P*/> P = $tryClone(setterMethod.param_begin());
          ParmVarDecl /*P*/ Param = (P.$star());
          QualType T = Param.getType().getNonReferenceType();
          DeclRefExpr /*P*/ rhs = /*FIXME:NEW_EXPR*//*new (Context)*/ Stmt.$new_uint_ASTContext$C$P_uint($this().Context, (type$ptr<?> Mem)->
                  new DeclRefExpr(Param, false, new QualType(T), ExprValueKind.VK_LValue, new SourceLocation(PropertyDiagLoc))
          );
          $this().MarkDeclRefReferenced(rhs);
          ActionResultTTrue<Expr /*P*/ > Res = $this().BuildBinOp(S, new SourceLocation(PropertyDiagLoc), 
              BinaryOperatorKind.BO_Assign, lhs, rhs);
          if (((property.getPropertyAttributes()
             & ObjCPropertyDecl.PropertyAttributeKind.OBJC_PR_atomic) != 0)) {
            Expr /*P*/ callExpr = Res.getAs(Expr.class);
            {
              /*const*/ CXXOperatorCallExpr /*P*/ CXXCE = dyn_cast_or_null_CXXOperatorCallExpr(callExpr);
              if ((CXXCE != null)) {
                {
                  /*const*/ FunctionDecl /*P*/ FuncDecl = CXXCE.getDirectCallee$Const();
                  if ((FuncDecl != null)) {
                    if (!FuncDecl.isTrivial()) {
                      if (property.getType().$arrow().isReferenceType()) {
                        JavaCleaner $c$ = $createJavaCleaner();
                        try {
                          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(PropertyDiagLoc), 
                                  diag.err_atomic_property_nontrivial_assign_op)), 
                              property.getType()));
                          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(FuncDecl.getLocStart(), 
                                  diag.note_callee_decl)), FuncDecl));
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
          PIDecl.setSetterCXXAssignment(Res.getAs(Expr.class));
        } finally {
          if (Scope != null) { Scope.$destroy(); }
        }
      }
    }
  }
  if ((IC != null)) {
    if (Synthesize) {
      {
        ObjCPropertyImplDecl /*P*/ PPIDecl = IC.FindPropertyImplIvarDecl(PropertyIvar);
        if ((PPIDecl != null)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(PropertyLoc), diag.error_duplicate_ivar_use)), 
                        PropertyId), PPIDecl.getPropertyDecl().getIdentifier()), 
                PropertyIvar));
            $c$.clean($c$.track($this().Diag(PPIDecl.getLocation(), diag.note_previous_use)));
          } finally {
            $c$.$destroy();
          }
        }
      }
    }
    {
      
      ObjCPropertyImplDecl /*P*/ PPIDecl = IC.FindPropertyImplDecl(PropertyId, QueryKind);
      if ((PPIDecl != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(PropertyLoc), diag.error_property_implemented)), PropertyId));
          $c$.clean($c$.track($this().Diag(PPIDecl.getLocation(), diag.note_previous_declaration)));
          return null;
        } finally {
          $c$.$destroy();
        }
      }
    }
    IC.addPropertyImplementation(PIDecl);
    if ($this().getLangOpts().ObjCDefaultSynthProperties
       && $this().getLangOpts().ObjCRuntime.isNonFragile()
       && !(IDecl.isObjCRequiresPropertyDefs() != null)) {
      // Diagnose if an ivar was lazily synthesdized due to a previous
      // use and if 1) property is @dynamic or 2) property is synthesized
      // but it requires an ivar of different name.
      type$ref<ObjCInterfaceDecl /*P*/ > ClassDeclared = create_type$null$ref(null);
      ObjCIvarDecl /*P*/ Ivar$1 = null;
      if (!Synthesize) {
        Ivar$1 = IDecl.lookupInstanceVariable(PropertyId, ClassDeclared);
      } else {
        if ((PropertyIvar != null) && PropertyIvar != PropertyId) {
          Ivar$1 = IDecl.lookupInstanceVariable(PropertyId, ClassDeclared);
        }
      }
      // Issue diagnostics only if Ivar belongs to current class.
      if ((Ivar$1 != null) && Ivar$1.getSynthesize()
         && declaresSameEntity(IC.getClassInterface(), ClassDeclared.$deref())) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Ivar$1.getLocation(), diag.err_undeclared_var_use)), 
              PropertyId));
          Ivar$1.setInvalidDecl();
        } finally {
          $c$.$destroy();
        }
      }
    }
  } else {
    if (Synthesize) {
      {
        ObjCPropertyImplDecl /*P*/ PPIDecl = CatImplClass.FindPropertyImplIvarDecl(PropertyIvar);
        if ((PPIDecl != null)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(PropertyDiagLoc), diag.error_duplicate_ivar_use)), 
                        PropertyId), PPIDecl.getPropertyDecl().getIdentifier()), 
                PropertyIvar));
            $c$.clean($c$.track($this().Diag(PPIDecl.getLocation(), diag.note_previous_use)));
          } finally {
            $c$.$destroy();
          }
        }
      }
    }
    {
      
      ObjCPropertyImplDecl /*P*/ PPIDecl = CatImplClass.FindPropertyImplDecl(PropertyId, QueryKind);
      if ((PPIDecl != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(PropertyDiagLoc), diag.error_property_implemented)), PropertyId));
          $c$.clean($c$.track($this().Diag(PPIDecl.getLocation(), diag.note_previous_declaration)));
          return null;
        } finally {
          $c$.$destroy();
        }
      }
    }
    CatImplClass.addPropertyImplementation(PIDecl);
  }
  
  return PIDecl;
}

} // END OF class Sema_SemaObjCProperty
