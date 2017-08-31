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
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
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
import org.llvm.ir.*;
import org.clang.codegen.CodeGen.impl.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.llvm.ir.java.IrRTTI.*;
import org.clang.basic.llvm.DenseMapInfoSelector;
import static org.clang.codegen.impl.CGObjCMacStatics.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCNonFragileABIMac">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 1274,
 FQN="(anonymous namespace)::CGObjCNonFragileABIMac", NM="_ZN12_GLOBAL__N_122CGObjCNonFragileABIMacE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_122CGObjCNonFragileABIMacE")
//</editor-fold>
public class CGObjCNonFragileABIMac extends /*public*/ CGObjCCommonMac implements Destructors.ClassWithDestructor {
/*private:*/
  private ObjCNonFragileABITypesHelper ObjCTypes;
  private GlobalVariable /*P*/ ObjCEmptyCacheVar;
  private GlobalVariable /*P*/ ObjCEmptyVtableVar;
  
  /// SuperClassReferences - uniqued super class references.
  private DenseMap<IdentifierInfo /*P*/ , GlobalVariable /*P*/ > SuperClassReferences;
  
  /// MetaClassReferences - uniqued meta class references.
  private DenseMap<IdentifierInfo /*P*/ , GlobalVariable /*P*/ > MetaClassReferences;
  
  /// EHTypeReferences - uniqued class ehtype references.
  private DenseMap<IdentifierInfo /*P*/ , GlobalVariable /*P*/ > EHTypeReferences;
  
  /// VTableDispatchMethods - List of methods for which we generate
  /// vtable-based message dispatch.
  private DenseSet<Selector> VTableDispatchMethods;
  
  /// DefinedMetaClasses - List of defined meta-classes.
  private std.vector<GlobalValue /*P*/ > DefinedMetaClasses;
  
  /// isVTableDispatchedSelector - Returns true if SEL is a
  /// vtable-based selector.
  
  /// isVTableDispatchedSelector - Returns true if SEL is not in the list of
  /// VTableDispatchMethods; false otherwise. What this means is that
  /// except for the 19 selectors in the list, we generate 32bit-style
  /// message dispatch call for all the rest.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCNonFragileABIMac::isVTableDispatchedSelector">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 5755,
   FQN="(anonymous namespace)::CGObjCNonFragileABIMac::isVTableDispatchedSelector", NM="_ZN12_GLOBAL__N_122CGObjCNonFragileABIMac26isVTableDispatchedSelectorEN5clang8SelectorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_122CGObjCNonFragileABIMac26isVTableDispatchedSelectorEN5clang8SelectorE")
  //</editor-fold>
  private boolean isVTableDispatchedSelector(Selector Sel) {
    // At various points we've experimented with using vtable-based
    // dispatch for all methods.
    switch (CGM.getCodeGenOpts().getObjCDispatchMethod()) {
     case Legacy:
      return false;
     case NonLegacy:
      return true;
     case Mixed:
      break;
    }
    
    // If so, see whether this selector is in the white-list of things which must
    // use the new dispatch convention. We lazily build a dense set for this.
    if (VTableDispatchMethods.empty()) {
      VTableDispatchMethods.insert(GetNullarySelector($("alloc")));
      VTableDispatchMethods.insert(GetNullarySelector($class));
      VTableDispatchMethods.insert(GetNullarySelector($("self")));
      VTableDispatchMethods.insert(GetNullarySelector($("isFlipped")));
      VTableDispatchMethods.insert(GetNullarySelector($("length")));
      VTableDispatchMethods.insert(GetNullarySelector($("count")));
      
      // These are vtable-based if GC is disabled.
      // Optimistically use vtable dispatch for hybrid compiles.
      if (CGM.getLangOpts().getGC() != LangOptions.GCMode.GCOnly) {
        VTableDispatchMethods.insert(GetNullarySelector($("retain")));
        VTableDispatchMethods.insert(GetNullarySelector($("release")));
        VTableDispatchMethods.insert(GetNullarySelector($("autorelease")));
      }
      
      VTableDispatchMethods.insert(GetUnarySelector($("allocWithZone")));
      VTableDispatchMethods.insert(GetUnarySelector($("isKindOfClass")));
      VTableDispatchMethods.insert(GetUnarySelector($("respondsToSelector")));
      VTableDispatchMethods.insert(GetUnarySelector($("objectForKey")));
      VTableDispatchMethods.insert(GetUnarySelector($("objectAtIndex")));
      VTableDispatchMethods.insert(GetUnarySelector($("isEqualToString")));
      VTableDispatchMethods.insert(GetUnarySelector($("isEqual")));
      
      // These are vtable-based if GC is enabled.
      // Optimistically use vtable dispatch for hybrid compiles.
      if (CGM.getLangOpts().getGC() != LangOptions.GCMode.NonGC) {
        VTableDispatchMethods.insert(GetNullarySelector($hash));
        VTableDispatchMethods.insert(GetUnarySelector($("addObject")));
        
        // "countByEnumeratingWithState:objects:count"
        IdentifierInfo /*P*/ KeyIdents[/*3*/] = new IdentifierInfo /*P*/  [/*3*/] {
          $AddrOf(CGM.getContext().Idents.get(new StringRef(/*KEEP_STR*/"countByEnumeratingWithState"))), 
          $AddrOf(CGM.getContext().Idents.get(new StringRef(/*KEEP_STR*/"objects"))), 
          $AddrOf(CGM.getContext().Idents.get(new StringRef(/*KEEP_STR*/"count")))
        };
        VTableDispatchMethods.insert(CGM.getContext().Selectors.getSelector(3, create_type$ptr(KeyIdents)));
      }
    }
    
    return (VTableDispatchMethods.count(Sel) != 0);
  }

  
  /// FinishNonFragileABIModule - Write out global data structures at the end of
  /// processing a translation unit.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCNonFragileABIMac::FinishNonFragileABIModule">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 5718,
   FQN="(anonymous namespace)::CGObjCNonFragileABIMac::FinishNonFragileABIModule", NM="_ZN12_GLOBAL__N_122CGObjCNonFragileABIMac25FinishNonFragileABIModuleEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_122CGObjCNonFragileABIMac25FinishNonFragileABIModuleEv")
  //</editor-fold>
  private void FinishNonFragileABIModule() {
    // nonfragile abi has no module definition.
    
    // Build list of all implemented class addresses in array
    // L_OBJC_LABEL_CLASS_$.
    for (/*uint*/int i = 0, NumClasses = ImplementedClasses.size(); $less_uint(i, NumClasses); i++) {
      /*const*/ ObjCInterfaceDecl /*P*/ ID = ImplementedClasses.$at(i);
      assert Native.$bool(ID);
      {
        ObjCImplementationDecl /*P*/ IMP = ID.getImplementation();
        if ((IMP != null)) {
          // We are implementing a weak imported interface. Give it external linkage
          if (ID.isWeakImported() && !IMP.isWeakImported()) {
            DefinedClasses.$at(i).setLinkage(GlobalVariable.LinkageTypes.ExternalLinkage);
            DefinedMetaClasses.$at(i).setLinkage(GlobalVariable.LinkageTypes.ExternalLinkage);
          }
        }
      }
    }
    
    AddModuleClassList(new ArrayRef<GlobalValue /*P*/ >(DefinedClasses, true), new StringRef(/*KEEP_STR*/"OBJC_LABEL_CLASS_$"), 
        new StringRef(/*KEEP_STR*/"__DATA, __objc_classlist, regular, no_dead_strip"));
    
    AddModuleClassList(new ArrayRef<GlobalValue /*P*/ >(DefinedNonLazyClasses, true), new StringRef(/*KEEP_STR*/"OBJC_LABEL_NONLAZY_CLASS_$"), 
        new StringRef(/*KEEP_STR*/"__DATA, __objc_nlclslist, regular, no_dead_strip"));
    
    // Build list of all implemented category addresses in array
    // L_OBJC_LABEL_CATEGORY_$.
    AddModuleClassList(new ArrayRef<GlobalValue /*P*/ >(DefinedCategories, true), new StringRef(/*KEEP_STR*/"OBJC_LABEL_CATEGORY_$"), 
        new StringRef(/*KEEP_STR*/"__DATA, __objc_catlist, regular, no_dead_strip"));
    AddModuleClassList(new ArrayRef<GlobalValue /*P*/ >(DefinedNonLazyCategories, true), new StringRef(/*KEEP_STR*/"OBJC_LABEL_NONLAZY_CATEGORY_$"), 
        new StringRef(/*KEEP_STR*/"__DATA, __objc_nlcatlist, regular, no_dead_strip"));
    
    EmitImageInfo();
  }

  
  /// AddModuleClassList - Add the given list of class pointers to the
  /// module with the provided symbol and section names.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCNonFragileABIMac::AddModuleClassList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 5691,
   FQN="(anonymous namespace)::CGObjCNonFragileABIMac::AddModuleClassList", NM="_ZN12_GLOBAL__N_122CGObjCNonFragileABIMac18AddModuleClassListEN4llvm8ArrayRefIPNS1_11GlobalValueEEENS1_9StringRefES6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_122CGObjCNonFragileABIMac18AddModuleClassListEN4llvm8ArrayRefIPNS1_11GlobalValueEEENS1_9StringRefES6_")
  //</editor-fold>
  private void AddModuleClassList(ArrayRef<GlobalValue /*P*/ > Container, StringRef SymbolName, 
                    StringRef SectionName) {
    /*uint*/int NumClasses = Container.size();
    if (!(NumClasses != 0)) {
      return;
    }
    
    SmallVector<Constant /*P*/ > Symbols/*J*/= new SmallVector<Constant /*P*/ >(JD$UInt_T$C$R.INSTANCE, 8, NumClasses, (Constant /*P*/ )null);
    for (/*uint*/int i = 0; $less_uint(i, NumClasses); i++)  {
      Symbols.$set(i, ConstantExpr.getBitCast(Container.$at(i), 
          ObjCTypes.Int8PtrTy));
    }
    Constant /*P*/ Init = ConstantArray.get(org.llvm.ir.ArrayType.get(ObjCTypes.Int8PtrTy, 
            $uint2ulong(Symbols.size())), 
        new ArrayRef<Constant /*P*/ >(Symbols, true));
    
    GlobalVariable /*P*/ GV = /*NEW_EXPR [GlobalVariable::new]*/GlobalVariable.$new_GlobalVariable((type$ptr<?> New$Mem)->{
        return new GlobalVariable(CGM.getModule(), Init.getType(), false, 
        GlobalValue.LinkageTypes.PrivateLinkage, 
        Init, 
        new Twine(SymbolName));
     });
    GV.setAlignment(CGM.getDataLayout().getABITypeAlignment(Init.getType()));
    GV.setSection(new StringRef(SectionName));
    CGM.addCompilerUsedGlobal(GV);
  }

  
  
  /// BuildClassRoTInitializer - generate meta-data for:
  /// struct _class_ro_t {
  ///   uint32_t const flags;
  ///   uint32_t const instanceStart;
  ///   uint32_t const instanceSize;
  ///   uint32_t const reserved;  // only when building for 64bit targets
  ///   const uint8_t * const ivarLayout;
  ///   const char *const name;
  ///   const struct _method_list_t * const baseMethods;
  ///   const struct _protocol_list_t *const baseProtocols;
  ///   const struct _ivar_list_t *const ivars;
  ///   const uint8_t * const weakIvarLayout;
  ///   const struct _prop_list_t * const properties;
  /// }
  ///
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCNonFragileABIMac::BuildClassRoTInitializer">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 5828,
   FQN="(anonymous namespace)::CGObjCNonFragileABIMac::BuildClassRoTInitializer", NM="_ZN12_GLOBAL__N_122CGObjCNonFragileABIMac24BuildClassRoTInitializerEjjjPKN5clang22ObjCImplementationDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_122CGObjCNonFragileABIMac24BuildClassRoTInitializerEjjjPKN5clang22ObjCImplementationDeclE")
  //</editor-fold>
  private GlobalVariable /*P*/ BuildClassRoTInitializer(/*uint*/int flags, 
                          /*uint*/int InstanceStart, 
                          /*uint*/int InstanceSize, 
                          /*const*/ ObjCImplementationDecl /*P*/ ID) {
    std.vector<Constant /*P*/ > Methods = null;
    try {
      std.string ClassName = ID.getObjCRuntimeNameAsString().$string();
      Constant /*P*/ Values[/*10*/] = new Constant /*P*/  [10]; // 11 for 64bit targets!
      
      CharUnits beginInstance = CharUnits.fromQuantity($uint2long(InstanceStart));
      CharUnits endInstance = CharUnits.fromQuantity($uint2long(InstanceSize));
      
      boolean hasMRCWeak = false;
      if (CGM.getLangOpts().ObjCAutoRefCount) {
        flags |= NonFragileClassFlags.NonFragileABI_Class_CompiledByARC;
      } else if ((hasMRCWeak = CGObjCMacStatics.hasMRCWeakIvars(CGM, ID))) {
        flags |= NonFragileClassFlags.NonFragileABI_Class_HasMRCWeakIvars;
      }
      
      Values[0] = ConstantInt.get(ObjCTypes.IntTy, $uint2ulong(flags));
      Values[1] = ConstantInt.get(ObjCTypes.IntTy, $uint2ulong(InstanceStart));
      Values[2] = ConstantInt.get(ObjCTypes.IntTy, $uint2ulong(InstanceSize));
      // FIXME. For 64bit targets add 0 here.
      Values[3] = ((flags & NonFragileClassFlags.NonFragileABI_Class_Meta) != 0) ? GetIvarLayoutName((IdentifierInfo /*P*/ )null, ObjCTypes) : BuildStrongIvarLayout(ID, new CharUnits(beginInstance), new CharUnits(endInstance));
      Values[4] = GetClassName(ID.getObjCRuntimeNameAsString());
      // const struct _method_list_t * const baseMethods;
      Methods/*J*/= new std.vector<Constant /*P*/ >((Constant /*P*/ )null);
      std.string MethodListName/*J*/= new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"\001l_OBJC_$_");
      if (((flags & NonFragileClassFlags.NonFragileABI_Class_Meta) != 0)) {
        MethodListName.$addassign_T$C$P(/*KEEP_STR*/"CLASS_METHODS_");
        $addassign_string_StringRef(MethodListName, ID.getObjCRuntimeNameAsString());
        for (/*const*/ ObjCMethodDecl /*P*/ I : ID.class_methods())  {
          // Class methods should always be defined.
          Methods.push_back_T$RR(GetMethodConstant(I));
        }
      } else {
        MethodListName.$addassign_T$C$P(/*KEEP_STR*/"INSTANCE_METHODS_");
        $addassign_string_StringRef(MethodListName, ID.getObjCRuntimeNameAsString());
        for (/*const*/ ObjCMethodDecl /*P*/ I : ID.instance_methods())  {
          // Instance methods should always be defined.
          Methods.push_back_T$RR(GetMethodConstant(I));
        }
        
        for (/*const*/ ObjCPropertyImplDecl /*P*/ PID : ID.property_impls()) {
          if (PID.getPropertyImplementation() == ObjCPropertyImplDecl.Kind.Synthesize) {
            ObjCPropertyDecl /*P*/ PD = PID.getPropertyDecl();
            {
              
              ObjCMethodDecl /*P*/ MD = PD.getGetterMethodDecl();
              if ((MD != null)) {
                {
                  Constant /*P*/ C = GetMethodConstant(MD);
                  if ((C != null)) {
                    Methods.push_back_T$C$R(C);
                  }
                }
              }
            }
            {
              ObjCMethodDecl /*P*/ MD = PD.getSetterMethodDecl();
              if ((MD != null)) {
                {
                  Constant /*P*/ C = GetMethodConstant(MD);
                  if ((C != null)) {
                    Methods.push_back_T$C$R(C);
                  }
                }
              }
            }
          }
        }
      }
      Values[5] = EmitMethodList(new Twine(MethodListName), 
          new StringRef(/*KEEP_STR*/"__DATA, __objc_const"), new ArrayRef<Constant /*P*/ >(Methods, true));
      
      /*const*/ ObjCInterfaceDecl /*P*/ OID = ID.getClassInterface$Const();
      assert ((OID != null)) : "CGObjCNonFragileABIMac::BuildClassRoTInitializer";
      Values[6] = EmitProtocolList($add_char$ptr$C_StringRef$C(/*KEEP_STR*/"\001l_OBJC_CLASS_PROTOCOLS_$_", 
              OID.getObjCRuntimeNameAsString()), 
          OID.all_referenced_protocol_begin(), 
          OID.all_referenced_protocol_end());
      if (((flags & NonFragileClassFlags.NonFragileABI_Class_Meta) != 0)) {
        Values[7] = Constant.getNullValue(ObjCTypes.IvarListnfABIPtrTy);
        Values[8] = GetIvarLayoutName((IdentifierInfo /*P*/ )null, ObjCTypes);
        Values[9] = EmitPropertyList($add_char$ptr$C_StringRef$C(/*KEEP_STR*/"\001l_OBJC_$_CLASS_PROP_LIST_", ID.getObjCRuntimeNameAsString()), 
            ID, ID.getClassInterface$Const(), ObjCTypes, true);
      } else {
        Values[7] = EmitIvarList(ID);
        Values[8] = BuildWeakIvarLayout(ID, new CharUnits(beginInstance), new CharUnits(endInstance), 
            hasMRCWeak);
        Values[9] = EmitPropertyList($add_char$ptr$C_StringRef$C(/*KEEP_STR*/"\001l_OBJC_$_PROP_LIST_", ID.getObjCRuntimeNameAsString()), 
            ID, ID.getClassInterface$Const(), ObjCTypes, false);
      }
      Constant /*P*/ Init = ConstantStruct.get(ObjCTypes.ClassRonfABITy, 
          new ArrayRef<Constant /*P*/ >(Values, true));
      /*uint*/int flags_final = flags;
      GlobalVariable /*P*/ CLASS_RO_GV = /*NEW_EXPR [GlobalVariable::new]*/GlobalVariable.$new_GlobalVariable((type$ptr<?> New$Mem)->{
          return new GlobalVariable(CGM.getModule(), ObjCTypes.ClassRonfABITy, false, 
          GlobalValue.LinkageTypes.PrivateLinkage, 
          Init, 
          new Twine(((flags_final & NonFragileClassFlags.NonFragileABI_Class_Meta) != 0) ? $add_string_string$C(new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"\001l_OBJC_METACLASS_RO_$_"), ClassName) : $add_string_string$C(new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"\001l_OBJC_CLASS_RO_$_"), ClassName)));
       });
      CLASS_RO_GV.setAlignment(CGM.getDataLayout().getABITypeAlignment(ObjCTypes.ClassRonfABITy));
      CLASS_RO_GV.setSection(new StringRef(/*KEEP_STR*/"__DATA, __objc_const"));
      return CLASS_RO_GV;
    } finally {
      if (Methods != null) { Methods.$destroy(); }
    }
  }

  
  /// BuildClassMetaData - This routine defines that to-level meta-data
  /// for the given ClassName for:
  /// struct _class_t {
  ///   struct _class_t *isa;
  ///   struct _class_t * const superclass;
  ///   void *cache;
  ///   IMP *vtable;
  ///   struct class_ro_t *ro;
  /// }
  ///
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCNonFragileABIMac::BuildClassMetaData">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 5932,
   FQN="(anonymous namespace)::CGObjCNonFragileABIMac::BuildClassMetaData", NM="_ZN12_GLOBAL__N_122CGObjCNonFragileABIMac18BuildClassMetaDataERKSsPN4llvm8ConstantES5_S5_bb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_122CGObjCNonFragileABIMac18BuildClassMetaDataERKSsPN4llvm8ConstantES5_S5_bb")
  //</editor-fold>
  private GlobalVariable /*P*/ BuildClassMetaData(final /*const*/std.string/*&*/ ClassName, Constant /*P*/ IsAGV, Constant /*P*/ SuperClassGV, 
                    Constant /*P*/ ClassRoGV, boolean HiddenVisibility, boolean Weak) {
    Constant /*P*/ Values[/*5*/] = new Constant /*P*/  [/*5*/] {
      IsAGV, 
      SuperClassGV, 
      ObjCEmptyCacheVar,  // &ObjCEmptyCacheVar
      ObjCEmptyVtableVar,  // &ObjCEmptyVtableVar
      ClassRoGV // &CLASS_RO_GV
    };
    if (!(Values[1] != null)) {
      Values[1] = Constant.getNullValue(ObjCTypes.ClassnfABIPtrTy);
    }
    if (!(Values[3] != null)) {
      Values[3] = Constant.getNullValue(org.llvm.ir.PointerType.getUnqual(ObjCTypes.ImpnfABITy));
    }
    Constant /*P*/ Init = ConstantStruct.get(ObjCTypes.ClassnfABITy, 
        new ArrayRef<Constant /*P*/ >(Values, true));
    GlobalVariable /*P*/ GV = GetClassGlobal(new StringRef(ClassName), Weak);
    GV.setInitializer(Init);
    GV.setSection(new StringRef(/*KEEP_STR*/"__DATA, __objc_data"));
    GV.setAlignment(CGM.getDataLayout().getABITypeAlignment(ObjCTypes.ClassnfABITy));
    if (!CGM.getTriple().isOSBinFormatCOFF()) {
      if (HiddenVisibility) {
        GV.setVisibility(GlobalValue.VisibilityTypes.HiddenVisibility);
      }
    }
    return GV;
  }

  
  
  /// GetMethodConstant - Return a struct objc_method constant for the
  /// given method if it has been defined. The result is null if the
  /// method has not been defined. The return value has type MethodPtrTy.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCNonFragileABIMac::GetMethodConstant">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 6309,
   FQN="(anonymous namespace)::CGObjCNonFragileABIMac::GetMethodConstant", NM="_ZN12_GLOBAL__N_122CGObjCNonFragileABIMac17GetMethodConstantEPKN5clang14ObjCMethodDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_122CGObjCNonFragileABIMac17GetMethodConstantEPKN5clang14ObjCMethodDeclE")
  //</editor-fold>
  private Constant /*P*/ GetMethodConstant(/*const*/ ObjCMethodDecl /*P*/ MD) {
    Function /*P*/ Fn = GetMethodDefinition(MD);
    if (!(Fn != null)) {
      return null;
    }
    
    Constant /*P*/ Method[/*3*/] = new Constant /*P*/  [/*3*/] {
      ConstantExpr.getBitCast(GetMethodVarName(MD.getSelector()), 
          ObjCTypes.SelectorPtrTy), 
      GetMethodVarType(MD), 
      ConstantExpr.getBitCast(Fn, ObjCTypes.Int8PtrTy)
    };
    return ConstantStruct.get(ObjCTypes.MethodTy, new ArrayRef<Constant /*P*/ >(Method, true));
  }

  
  
  /// GetMethodDescriptionConstant - This routine build following meta-data:
  /// struct _objc_method {
  ///   SEL _cmd;
  ///   char *method_type;
  ///   char *_imp;
  /// }
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCNonFragileABIMac::GetMethodDescriptionConstant">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 6710,
   FQN="(anonymous namespace)::CGObjCNonFragileABIMac::GetMethodDescriptionConstant", NM="_ZN12_GLOBAL__N_122CGObjCNonFragileABIMac28GetMethodDescriptionConstantEPKN5clang14ObjCMethodDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_122CGObjCNonFragileABIMac28GetMethodDescriptionConstantEPKN5clang14ObjCMethodDeclE")
  //</editor-fold>
  private Constant /*P*/ GetMethodDescriptionConstant(/*const*/ ObjCMethodDecl /*P*/ MD) {
    Constant /*P*/ Desc[/*3*/] = new Constant /*P*/  [3];
    Desc[0]
       = ConstantExpr.getBitCast(GetMethodVarName(MD.getSelector()), 
        ObjCTypes.SelectorPtrTy);
    Desc[1] = GetMethodVarType(MD);
    if (!(Desc[1] != null)) {
      return null;
    }
    
    // Protocol methods have no implementation. So, this entry is always NULL.
    Desc[2] = Constant.getNullValue(ObjCTypes.Int8PtrTy);
    return ConstantStruct.get(ObjCTypes.MethodTy, new ArrayRef<Constant /*P*/ >(Desc, true));
  }

  
  /// EmitMethodList - Emit the method list for the given
  /// implementation. The return value has type MethodListnfABITy.
  
  /// EmitMethodList - Build meta-data for method declarations
  /// struct _method_list_t {
  ///   uint32_t entsize;  // sizeof(struct _objc_method)
  ///   uint32_t method_count;
  ///   struct _objc_method method_list[method_count];
  /// }
  ///
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCNonFragileABIMac::EmitMethodList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 6331,
   FQN="(anonymous namespace)::CGObjCNonFragileABIMac::EmitMethodList", NM="_ZN12_GLOBAL__N_122CGObjCNonFragileABIMac14EmitMethodListEN4llvm5TwineENS1_9StringRefENS1_8ArrayRefIPNS1_8ConstantEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_122CGObjCNonFragileABIMac14EmitMethodListEN4llvm5TwineENS1_9StringRefENS1_8ArrayRefIPNS1_8ConstantEEE")
  //</editor-fold>
  private Constant /*P*/ EmitMethodList(Twine Name, StringRef Section, 
                ArrayRef<Constant /*P*/ > Methods) {
    // Return null for empty list.
    if (Methods.empty()) {
      return Constant.getNullValue(ObjCTypes.MethodListnfABIPtrTy);
    }
    
    Constant /*P*/ Values[/*3*/] = new Constant /*P*/  [3];
    // sizeof(struct _objc_method)
    /*uint*/int Size = $ulong2uint(CGM.getDataLayout().getTypeAllocSize(ObjCTypes.MethodTy));
    Values[0] = ConstantInt.get(ObjCTypes.IntTy, $uint2ulong(Size));
    // method_count
    Values[1] = ConstantInt.get(ObjCTypes.IntTy, $uint2ulong(Methods.size()));
    org.llvm.ir.ArrayType /*P*/ AT = org.llvm.ir.ArrayType.get(ObjCTypes.MethodTy, 
        $uint2ulong(Methods.size()));
    Values[2] = ConstantArray.get(AT, new ArrayRef<Constant /*P*/ >(Methods));
    Constant /*P*/ Init = ConstantStruct.getAnon(new ArrayRef<Constant /*P*/ >(Values, true));
    
    GlobalVariable /*P*/ GV = /*NEW_EXPR [GlobalVariable::new]*/GlobalVariable.$new_GlobalVariable((type$ptr<?> New$Mem)->{
        return new GlobalVariable(CGM.getModule(), Init.getType(), false, 
        GlobalValue.LinkageTypes.PrivateLinkage, Init, Name);
     });
    GV.setAlignment(CGM.getDataLayout().getABITypeAlignment(Init.getType()));
    GV.setSection(new StringRef(Section));
    CGM.addCompilerUsedGlobal(GV);
    return ConstantExpr.getBitCast(GV, ObjCTypes.MethodListnfABIPtrTy);
  }

  /// EmitIvarList - Emit the ivar list for the given
  /// implementation. If ForClass is true the list of class ivars
  /// (i.e. metaclass ivars) is emitted, otherwise the list of
  /// interface ivars will be emitted. The return value has type
  /// IvarListnfABIPtrTy.
  
  /// EmitIvarList - Emit the ivar list for the given
  /// implementation. The return value has type
  /// IvarListnfABIPtrTy.
  ///  struct _ivar_t {
  ///   unsigned [long] int *offset;  // pointer to ivar offset location
  ///   char *name;
  ///   char *type;
  ///   uint32_t alignment;
  ///   uint32_t size;
  /// }
  /// struct _ivar_list_t {
  ///   uint32 entsize;  // sizeof(struct _ivar_t)
  ///   uint32 count;
  ///   struct _iver_t list[count];
  /// }
  ///
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCNonFragileABIMac::EmitIvarList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 6430,
   FQN="(anonymous namespace)::CGObjCNonFragileABIMac::EmitIvarList", NM="_ZN12_GLOBAL__N_122CGObjCNonFragileABIMac12EmitIvarListEPKN5clang22ObjCImplementationDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_122CGObjCNonFragileABIMac12EmitIvarListEPKN5clang22ObjCImplementationDeclE")
  //</editor-fold>
  private Constant /*P*/ EmitIvarList(/*const*/ ObjCImplementationDecl /*P*/ ID) {
    std.vector<Constant /*P*/ > Ivars = null;
    try {
      
      Ivars/*J*/= new std.vector<Constant /*P*/ >((Constant /*P*/ )null);
      
      /*const*/ ObjCInterfaceDecl /*P*/ OID = ID.getClassInterface$Const();
      assert ((OID != null)) : "CGObjCNonFragileABIMac::EmitIvarList - null interface";
      
      // FIXME. Consolidate this with similar code in GenerateClass.
      for (/*const*/ ObjCIvarDecl /*P*/ IVD = OID.all_declared_ivar_begin$Const();
           (IVD != null); IVD = IVD.getNextIvar$Const()) {
        // Ignore unnamed bit-fields.
        if (!IVD.getDeclName().$bool()) {
          continue;
        }
        Constant /*P*/ Ivar[/*5*/] = new Constant /*P*/  [5];
        Ivar[0] = EmitIvarOffsetVar(ID.getClassInterface$Const(), IVD, 
            ComputeIvarBaseOffset(CGM, ID, IVD));
        Ivar[1] = GetMethodVarName(IVD.getIdentifier());
        Ivar[2] = GetMethodVarType(IVD);
        org.llvm.ir.Type /*P*/ FieldTy = CGM.getTypes().ConvertTypeForMem(IVD.getType());
        /*uint*/int Size = $ulong2uint(CGM.getDataLayout().getTypeAllocSize(FieldTy));
        /*uint*/int Align = CGM.getContext().getPreferredTypeAlign(IVD.getType().getTypePtr()) >>> 3;
        Align = llvm.Log2_32(Align);
        Ivar[3] = ConstantInt.get(ObjCTypes.IntTy, $uint2ulong(Align));
        // NOTE. Size of a bitfield does not match gcc's, because of the
        // way bitfields are treated special in each. But I am told that
        // 'size' for bitfield ivars is ignored by the runtime so it does
        // not matter.  If it matters, there is enough info to get the
        // bitfield right!
        Ivar[4] = ConstantInt.get(ObjCTypes.IntTy, $uint2ulong(Size));
        Ivars.push_back_T$RR(ConstantStruct.get(ObjCTypes.IvarnfABITy, new ArrayRef<Constant /*P*/ >(Ivar, true)));
      }
      // Return null for empty list.
      if (Ivars.empty()) {
        return Constant.getNullValue(ObjCTypes.IvarListnfABIPtrTy);
      }
      
      Constant /*P*/ Values[/*3*/] = new Constant /*P*/  [3];
      /*uint*/int Size = $ulong2uint(CGM.getDataLayout().getTypeAllocSize(ObjCTypes.IvarnfABITy));
      Values[0] = ConstantInt.get(ObjCTypes.IntTy, $uint2ulong(Size));
      Values[1] = ConstantInt.get(ObjCTypes.IntTy, $uint2ulong(Ivars.size()));
      org.llvm.ir.ArrayType /*P*/ AT = org.llvm.ir.ArrayType.get(ObjCTypes.IvarnfABITy, 
          $uint2ulong(Ivars.size()));
      Values[2] = ConstantArray.get(AT, new ArrayRef<Constant /*P*/ >(Ivars, true));
      Constant /*P*/ Init = ConstantStruct.getAnon(new ArrayRef<Constant /*P*/ >(Values, true));
      /*const*/char$ptr/*char P*/ Prefix = $("\001l_OBJC_$_INSTANCE_VARIABLES_");
      GlobalVariable /*P*/ GV = /*NEW_EXPR [GlobalVariable::new]*/GlobalVariable.$new_GlobalVariable((type$ptr<?> New$Mem)->{
          return new GlobalVariable(CGM.getModule(), Init.getType(), false, 
          GlobalValue.LinkageTypes.PrivateLinkage, 
          Init, 
          $add_char$ptr$C_StringRef$C(Prefix, OID.getObjCRuntimeNameAsString()));
       });
      GV.setAlignment(CGM.getDataLayout().getABITypeAlignment(Init.getType()));
      GV.setSection(new StringRef(/*KEEP_STR*/"__DATA, __objc_const"));
      
      CGM.addCompilerUsedGlobal(GV);
      return ConstantExpr.getBitCast(GV, ObjCTypes.IvarListnfABIPtrTy);
    } finally {
      if (Ivars != null) { Ivars.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCNonFragileABIMac::EmitIvarOffsetVar">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 6388,
   FQN="(anonymous namespace)::CGObjCNonFragileABIMac::EmitIvarOffsetVar", NM="_ZN12_GLOBAL__N_122CGObjCNonFragileABIMac17EmitIvarOffsetVarEPKN5clang17ObjCInterfaceDeclEPKNS1_12ObjCIvarDeclEm",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_122CGObjCNonFragileABIMac17EmitIvarOffsetVarEPKN5clang17ObjCInterfaceDeclEPKNS1_12ObjCIvarDeclEm")
  //</editor-fold>
  private Constant /*P*/ EmitIvarOffsetVar(/*const*/ ObjCInterfaceDecl /*P*/ ID, 
                   /*const*/ ObjCIvarDecl /*P*/ Ivar, 
                   /*ulong*/long Offset) {
    GlobalVariable /*P*/ IvarOffsetGV = ObjCIvarOffsetVariable(ID, Ivar);
    IvarOffsetGV.setInitializer(ConstantInt.get(ObjCTypes.IvarOffsetVarTy, Offset));
    IvarOffsetGV.setAlignment(CGM.getDataLayout().getABITypeAlignment(ObjCTypes.IvarOffsetVarTy));
    if (!CGM.getTriple().isOSBinFormatCOFF()) {
      // FIXME: This matches gcc, but shouldn't the visibility be set on the use
      // as well (i.e., in ObjCIvarOffsetVariable).
      if (Ivar.getAccessControl() == ObjCIvarDecl.AccessControl.Private
         || Ivar.getAccessControl() == ObjCIvarDecl.AccessControl.Package
         || ID.getVisibility() == Visibility.HiddenVisibility) {
        IvarOffsetGV.setVisibility(GlobalValue.VisibilityTypes.HiddenVisibility);
      } else {
        IvarOffsetGV.setVisibility(GlobalValue.VisibilityTypes.DefaultVisibility);
      }
    }
    
    IvarOffsetGV.setSection(new StringRef(/*KEEP_STR*/"__DATA, __objc_ivar"));
    return IvarOffsetGV;
  }

  
  /// GetOrEmitProtocol - Get the protocol object for the given
  /// declaration, emitting it if necessary. The return value has type
  /// ProtocolPtrTy.
  
  /// GetOrEmitProtocol - Generate the protocol meta-data:
  /// @code
  /// struct _protocol_t {
  ///   id isa;  // NULL
  ///   const char * const protocol_name;
  ///   const struct _protocol_list_t * protocol_list; // super protocols
  ///   const struct method_list_t * const instance_methods;
  ///   const struct method_list_t * const class_methods;
  ///   const struct method_list_t *optionalInstanceMethods;
  ///   const struct method_list_t *optionalClassMethods;
  ///   const struct _prop_list_t * properties;
  ///   const uint32_t size;  // sizeof(struct _protocol_t)
  ///   const uint32_t flags;  // = 0
  ///   const char ** extendedMethodTypes;
  ///   const char *demangledName;
  ///   const struct _prop_list_t * class_properties;
  /// }
  /// @endcode
  ///
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCNonFragileABIMac::GetOrEmitProtocol">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 6528,
   FQN="(anonymous namespace)::CGObjCNonFragileABIMac::GetOrEmitProtocol", NM="_ZN12_GLOBAL__N_122CGObjCNonFragileABIMac17GetOrEmitProtocolEPKN5clang16ObjCProtocolDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_122CGObjCNonFragileABIMac17GetOrEmitProtocolEPKN5clang16ObjCProtocolDeclE")
  //</editor-fold>
  @Override public/*private*/ Constant /*P*/ GetOrEmitProtocol(/*const*/ ObjCProtocolDecl /*P*/ PD)/* override*/ {
    std.vector<Constant /*P*/ > InstanceMethods = null;
    std.vector<Constant /*P*/ > ClassMethods = null;
    std.vector<Constant /*P*/ > OptInstanceMethods = null;
    std.vector<Constant /*P*/ > OptClassMethods = null;
    std.vector<Constant /*P*/ > MethodTypesExt = null;
    std.vector<Constant /*P*/ > OptMethodTypesExt = null;
    try {
      GlobalVariable /*P*/ Entry = Protocols.$at_T1$RR(PD.getIdentifier());
      
      // Early exit if a defining object has already been generated.
      if ((Entry != null) && Entry.hasInitializer()) {
        return Entry;
      }
      {
        
        // Use the protocol definition, if there is one.
        /*const*/ ObjCProtocolDecl /*P*/ Def = PD.getDefinition$Const();
        if ((Def != null)) {
          PD = Def;
        }
      }
      
      // Construct method lists.
      InstanceMethods/*J*/= new std.vector<Constant /*P*/ >((Constant /*P*/ )null);
      ClassMethods/*J*/= new std.vector<Constant /*P*/ >((Constant /*P*/ )null);
      OptInstanceMethods/*J*/= new std.vector<Constant /*P*/ >((Constant /*P*/ )null);
      OptClassMethods/*J*/= new std.vector<Constant /*P*/ >((Constant /*P*/ )null);
      MethodTypesExt/*J*/= new std.vector<Constant /*P*/ >((Constant /*P*/ )null);
      OptMethodTypesExt/*J*/= new std.vector<Constant /*P*/ >((Constant /*P*/ )null);
      for (/*const*/ ObjCMethodDecl /*P*/ MD : PD.instance_methods()) {
        Constant /*P*/ C = GetMethodDescriptionConstant(MD);
        if (!(C != null)) {
          return GetOrEmitProtocolRef(PD);
        }
        if (MD.getImplementationControl() == ObjCMethodDecl.ImplementationControl.Optional) {
          OptInstanceMethods.push_back_T$C$R(C);
          OptMethodTypesExt.push_back_T$RR(GetMethodVarType(MD, true));
        } else {
          InstanceMethods.push_back_T$C$R(C);
          MethodTypesExt.push_back_T$RR(GetMethodVarType(MD, true));
        }
      }
      
      for (/*const*/ ObjCMethodDecl /*P*/ MD : PD.class_methods()) {
        Constant /*P*/ C = GetMethodDescriptionConstant(MD);
        if (!(C != null)) {
          return GetOrEmitProtocolRef(PD);
        }
        if (MD.getImplementationControl() == ObjCMethodDecl.ImplementationControl.Optional) {
          OptClassMethods.push_back_T$C$R(C);
          OptMethodTypesExt.push_back_T$RR(GetMethodVarType(MD, true));
        } else {
          ClassMethods.push_back_T$C$R(C);
          MethodTypesExt.push_back_T$RR(GetMethodVarType(MD, true));
        }
      }
      
      MethodTypesExt.insert$T(new std.vector.iterator</*const*/ Constant /*P*/ >(MethodTypesExt.end()), 
          OptMethodTypesExt.begin(), OptMethodTypesExt.end());
      
      Constant /*P*/ Values[/*13*/] = new Constant /*P*/  [13];
      // isa is NULL
      Values[0] = Constant.getNullValue(ObjCTypes.ObjectPtrTy);
      Values[1] = GetClassName(PD.getObjCRuntimeNameAsString());
      Values[2] = EmitProtocolList($add_char$ptr$C_StringRef$C(/*KEEP_STR*/"\001l_OBJC_$_PROTOCOL_REFS_", PD.getObjCRuntimeNameAsString()), 
          PD.protocol_begin(), 
          PD.protocol_end());
      
      Values[3] = EmitMethodList($add_char$ptr$C_StringRef$C(/*KEEP_STR*/"\001l_OBJC_$_PROTOCOL_INSTANCE_METHODS_", 
              PD.getObjCRuntimeNameAsString()), 
          new StringRef(/*KEEP_STR*/"__DATA, __objc_const"), 
          new ArrayRef<Constant /*P*/ >(InstanceMethods, true));
      Values[4] = EmitMethodList($add_char$ptr$C_StringRef$C(/*KEEP_STR*/"\001l_OBJC_$_PROTOCOL_CLASS_METHODS_", 
              PD.getObjCRuntimeNameAsString()), 
          new StringRef(/*KEEP_STR*/"__DATA, __objc_const"), 
          new ArrayRef<Constant /*P*/ >(ClassMethods, true));
      Values[5] = EmitMethodList($add_char$ptr$C_StringRef$C(/*KEEP_STR*/"\001l_OBJC_$_PROTOCOL_INSTANCE_METHODS_OPT_", 
              PD.getObjCRuntimeNameAsString()), 
          new StringRef(/*KEEP_STR*/"__DATA, __objc_const"), 
          new ArrayRef<Constant /*P*/ >(OptInstanceMethods, true));
      Values[6] = EmitMethodList($add_char$ptr$C_StringRef$C(/*KEEP_STR*/"\001l_OBJC_$_PROTOCOL_CLASS_METHODS_OPT_", 
              PD.getObjCRuntimeNameAsString()), 
          new StringRef(/*KEEP_STR*/"__DATA, __objc_const"), 
          new ArrayRef<Constant /*P*/ >(OptClassMethods, true));
      Values[7] = EmitPropertyList($add_char$ptr$C_StringRef$C(/*KEEP_STR*/"\001l_OBJC_$_PROP_LIST_", PD.getObjCRuntimeNameAsString()), 
          (/*const*/ Decl /*P*/ )null, PD, ObjCTypes, false);
      /*uint32_t*/int Size = $ulong2uint(CGM.getDataLayout().getTypeAllocSize(ObjCTypes.ProtocolnfABITy));
      Values[8] = ConstantInt.get(ObjCTypes.IntTy, $uint2ulong(Size));
      Values[9] = Constant.getNullValue(ObjCTypes.IntTy);
      Values[10] = EmitProtocolMethodTypes($add_char$ptr$C_StringRef$C(/*KEEP_STR*/"\001l_OBJC_$_PROTOCOL_METHOD_TYPES_", 
              PD.getObjCRuntimeNameAsString()), 
          new ArrayRef<Constant /*P*/ >(MethodTypesExt, true), ObjCTypes);
      // const char *demangledName;
      Values[11] = Constant.getNullValue(ObjCTypes.Int8PtrTy);
      
      Values[12] = EmitPropertyList($add_char$ptr$C_StringRef$C(/*KEEP_STR*/"\001l_OBJC_$_CLASS_PROP_LIST_", PD.getObjCRuntimeNameAsString()), 
          (/*const*/ Decl /*P*/ )null, PD, ObjCTypes, true);
      
      Constant /*P*/ Init = ConstantStruct.get(ObjCTypes.ProtocolnfABITy, 
          new ArrayRef<Constant /*P*/ >(Values, true));
      if ((Entry != null)) {
        // Already created, fix the linkage and update the initializer.
        Entry.setLinkage(GlobalValue.LinkageTypes.WeakAnyLinkage);
        Entry.setInitializer(Init);
      } else {
        /*const*/ ObjCProtocolDecl /*P*/ PD_final = PD;
        Entry
           = /*NEW_EXPR [GlobalVariable::new]*/GlobalVariable.$new_GlobalVariable((type$ptr<?> New$Mem)->{
            return new GlobalVariable(CGM.getModule(), ObjCTypes.ProtocolnfABITy, 
            false, GlobalValue.LinkageTypes.WeakAnyLinkage, Init, 
            $add_char$ptr$C_StringRef$C(/*KEEP_STR*/"\001l_OBJC_PROTOCOL_$_", PD_final.getObjCRuntimeNameAsString()));
         });
        Entry.setAlignment(CGM.getDataLayout().getABITypeAlignment(ObjCTypes.ProtocolnfABITy));
        
        Protocols.$set(PD.getIdentifier(), Entry);
      }
      Entry.setVisibility(GlobalValue.VisibilityTypes.HiddenVisibility);
      CGM.addCompilerUsedGlobal(Entry);
      
      // Use this protocol meta-data to build protocol list table in section
      // __DATA, __objc_protolist
      GlobalVariable /*P*/ Entry_final = Entry;
      /*const*/ ObjCProtocolDecl /*P*/ PD_final = PD;
      GlobalVariable /*P*/ PTGV = /*NEW_EXPR [GlobalVariable::new]*/GlobalVariable.$new_GlobalVariable((type$ptr<?> New$Mem)->{
          return new GlobalVariable(CGM.getModule(), ObjCTypes.ProtocolnfABIPtrTy, 
          false, GlobalValue.LinkageTypes.WeakAnyLinkage, Entry_final, 
          $add_char$ptr$C_StringRef$C(/*KEEP_STR*/"\001l_OBJC_LABEL_PROTOCOL_$_", PD_final.getObjCRuntimeNameAsString()));
       });
      PTGV.setAlignment(CGM.getDataLayout().getABITypeAlignment(ObjCTypes.ProtocolnfABIPtrTy));
      PTGV.setSection(new StringRef(/*KEEP_STR*/"__DATA, __objc_protolist, coalesced, no_dead_strip"));
      PTGV.setVisibility(GlobalValue.VisibilityTypes.HiddenVisibility);
      CGM.addCompilerUsedGlobal(PTGV);
      return Entry;
    } finally {
      if (OptMethodTypesExt != null) { OptMethodTypesExt.$destroy(); }
      if (MethodTypesExt != null) { MethodTypesExt.$destroy(); }
      if (OptClassMethods != null) { OptClassMethods.$destroy(); }
      if (OptInstanceMethods != null) { OptInstanceMethods.$destroy(); }
      if (ClassMethods != null) { ClassMethods.$destroy(); }
      if (InstanceMethods != null) { InstanceMethods.$destroy(); }
    }
  }

  
  /// GetOrEmitProtocolRef - Get a forward reference to the protocol
  /// object for the given declaration, emitting it if needed. These
  /// forward references will be filled in with empty bodies if no
  /// definition is seen. The return value has type ProtocolPtrTy.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCNonFragileABIMac::GetOrEmitProtocolRef">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 6491,
   FQN="(anonymous namespace)::CGObjCNonFragileABIMac::GetOrEmitProtocolRef", NM="_ZN12_GLOBAL__N_122CGObjCNonFragileABIMac20GetOrEmitProtocolRefEPKN5clang16ObjCProtocolDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_122CGObjCNonFragileABIMac20GetOrEmitProtocolRefEPKN5clang16ObjCProtocolDeclE")
  //</editor-fold>
  @Override public/*private*/ Constant /*P*/ GetOrEmitProtocolRef(/*const*/ ObjCProtocolDecl /*P*/ PD)/* override*/ {
    final type$ref<GlobalVariable /*P*/ /*&*/> Entry = Protocols.ref$at(PD.getIdentifier());
    if (!(Entry.$deref() != null)) {
      // We use the initializer as a marker of whether this is a forward
      // reference or not. At module finalization we add the empty
      // contents for protocols which were referenced but never defined.
      Entry.$set(/*NEW_EXPR [GlobalVariable::new]*/GlobalVariable.$new_GlobalVariable((type$ptr<?> New$Mem)->{
          return new GlobalVariable(CGM.getModule(), ObjCTypes.ProtocolnfABITy, 
          false, GlobalValue.LinkageTypes.ExternalLinkage, 
          (Constant /*P*/ )null, 
                  $add_char$ptr$C_StringRef$C(/*KEEP_STR*/"\001l_OBJC_PROTOCOL_$_", PD.getObjCRuntimeNameAsString()));
       }));
    }
    
    return Entry.$deref();
  }

  
  /// EmitProtocolList - Generate the list of referenced
  /// protocols. The return value has type ProtocolListPtrTy.
  
  /// EmitProtocolList - Generate protocol list meta-data:
  /// @code
  /// struct _protocol_list_t {
  ///   long protocol_count;   // Note, this is 32/64 bit
  ///   struct _protocol_t[protocol_count];
  /// }
  /// @endcode
  ///
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCNonFragileABIMac::EmitProtocolList">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 6658,
   FQN="(anonymous namespace)::CGObjCNonFragileABIMac::EmitProtocolList", NM="_ZN12_GLOBAL__N_122CGObjCNonFragileABIMac16EmitProtocolListEN4llvm5TwineEPKPN5clang16ObjCProtocolDeclES7_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_122CGObjCNonFragileABIMac16EmitProtocolListEN4llvm5TwineEPKPN5clang16ObjCProtocolDeclES7_")
  //</editor-fold>
  private Constant /*P*/ EmitProtocolList(Twine Name, 
                  type$ptr<ObjCProtocolDecl /*P*/ /*const*/ /*P*/> begin, 
                  type$ptr<ObjCProtocolDecl /*P*/ /*const*/ /*P*/> end) {
    // JAVA
    begin = $Clone(begin);
    SmallVector<Constant /*P*/ > ProtocolRefs/*J*/= new SmallVector<Constant /*P*/ >(16, (Constant /*P*/ )null);
    
    // Just return null for empty protocol lists
    if ($eq_ptr(begin, end)) {
      return Constant.getNullValue(ObjCTypes.ProtocolListnfABIPtrTy);
    }
    
    // FIXME: We shouldn't need to do this lookup here, should we?
    SmallString/*<256>*/ TmpName/*J*/= new SmallString/*<256>*/(256);
    Name.toVector(TmpName);
    GlobalVariable /*P*/ GV = CGM.getModule().getGlobalVariable(TmpName.str(), true);
    if ((GV != null)) {
      return ConstantExpr.getBitCast(GV, ObjCTypes.ProtocolListnfABIPtrTy);
    }
    
    for (; $noteq_ptr(begin, end); begin.$preInc())  {
      ProtocolRefs.push_back(GetProtocolRef(begin.$star())); // Implemented???
    }
    
    // This list is null terminated.
    ProtocolRefs.push_back(Constant.getNullValue(ObjCTypes.ProtocolnfABIPtrTy));
    
    Constant /*P*/ Values[/*2*/] = new Constant /*P*/  [2];
    Values[0]
       = ConstantInt.get(ObjCTypes.LongTy, $uint2ulong(ProtocolRefs.size() - 1));
    Values[1]
       = ConstantArray.get(org.llvm.ir.ArrayType.get(ObjCTypes.ProtocolnfABIPtrTy, 
            $uint2ulong(ProtocolRefs.size())), 
        new ArrayRef<Constant /*P*/ >(ProtocolRefs, true));
    
    Constant /*P*/ Init = ConstantStruct.getAnon(new ArrayRef<Constant /*P*/ >(Values, true));
    GV = /*NEW_EXPR [GlobalVariable::new]*/GlobalVariable.$new_GlobalVariable((type$ptr<?> New$Mem)->{
        return new GlobalVariable(CGM.getModule(), Init.getType(), false, 
        GlobalValue.LinkageTypes.PrivateLinkage, 
        Init, Name);
     });
    GV.setSection(new StringRef(/*KEEP_STR*/"__DATA, __objc_const"));
    GV.setAlignment(CGM.getDataLayout().getABITypeAlignment(Init.getType()));
    CGM.addCompilerUsedGlobal(GV);
    return ConstantExpr.getBitCast(GV, 
        ObjCTypes.ProtocolListnfABIPtrTy);
  }

  
  
  /// Emit a "vtable" message send.  We emit a weak hidden-visibility
  /// struct, initially containing the selector pointer and a pointer to
  /// a "fixup" variant of the appropriate objc_msgSend.  To call, we
  /// load and call the function pointer, passing the address of the
  /// struct as the second parameter.  The runtime determines whether
  /// the selector is currently emitted using vtable dispatch; if so, it
  /// substitutes a stub function which simply tail-calls through the
  /// appropriate vtable slot, and if not, it substitues a stub function
  /// which tail-calls objc_msgSend.  Both stubs adjust the selector
  /// argument to correctly point to the selector.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCNonFragileABIMac::EmitVTableMessageSend">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 6787,
   FQN="(anonymous namespace)::CGObjCNonFragileABIMac::EmitVTableMessageSend", NM="_ZN12_GLOBAL__N_122CGObjCNonFragileABIMac21EmitVTableMessageSendERN5clang7CodeGen15CodeGenFunctionENS2_15ReturnValueSlotENS1_8QualTypeENS1_8SelectorEPN4llvm5ValueES6_bRKNS2_11CallArgListEPKNS1_14ObjCMethodDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_122CGObjCNonFragileABIMac21EmitVTableMessageSendERN5clang7CodeGen15CodeGenFunctionENS2_15ReturnValueSlotENS1_8QualTypeENS1_8SelectorEPN4llvm5ValueES6_bRKNS2_11CallArgListEPKNS1_14ObjCMethodDeclE")
  //</editor-fold>
  private RValue EmitVTableMessageSend(final CodeGenFunction /*&*/ CGF, 
                       ReturnValueSlot returnSlot, 
                       QualType resultType, 
                       Selector selector, 
                       Value /*P*/ arg0, 
                       QualType arg0Type, 
                       boolean isSuper, 
                       final /*const*/ CallArgList /*&*/ formalArgs, 
                       /*const*/ ObjCMethodDecl /*P*/ method) {
    CallArgList args = null;
    try {
      // Compute the actual arguments.
      args/*J*/= new CallArgList();
      
      // First argument: the receiver / super-call structure.
      if (!isSuper) {
        arg0 = CGF.Builder.CreateBitCast(arg0, ObjCTypes.ObjectPtrTy);
      }
      args.add(RValue.get(arg0), new QualType(arg0Type));
      
      // Second argument: a pointer to the message ref structure.  Leave
      // the actual argument value blank for now.
      args.add(RValue.get((Value /*P*/ )null), new QualType(ObjCTypes.MessageRefCPtrTy));
      
      args.insert(args.end(), formalArgs.begin$Const(), formalArgs.end$Const());
      
      CGObjCRuntime.MessageSendInfo MSI = getMessageSendInfo(method, new QualType(resultType), args);
      
      NullReturnState nullReturn/*J*/= new NullReturnState();
      
      // Find the function to call and the mangled name for the message
      // ref structure.  Using a different mangled name wouldn't actually
      // be a problem; it would just be a waste.
      //
      // The runtime currently never uses vtable dispatch for anything
      // except normal, non-super message-sends.
      // FIXME: don't use this for that.
      Constant /*P*/ fn = null;
      std.string messageRefName/*J*/= new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"\001l_");
      if (CGM.ReturnSlotInterferesWithArgs(MSI.CallInfo)) {
        if (isSuper) {
          fn = ObjCTypes.getMessageSendSuper2StretFixupFn();
          messageRefName.$addassign_T$C$P(/*KEEP_STR*/"objc_msgSendSuper2_stret_fixup");
        } else {
          nullReturn.init(CGF, arg0);
          fn = ObjCTypes.getMessageSendStretFixupFn();
          messageRefName.$addassign_T$C$P(/*KEEP_STR*/"objc_msgSend_stret_fixup");
        }
      } else if (!isSuper && CGM.ReturnTypeUsesFPRet(new QualType(resultType))) {
        fn = ObjCTypes.getMessageSendFpretFixupFn();
        messageRefName.$addassign_T$C$P(/*KEEP_STR*/"objc_msgSend_fpret_fixup");
      } else {
        if (isSuper) {
          fn = ObjCTypes.getMessageSendSuper2FixupFn();
          messageRefName.$addassign_T$C$P(/*KEEP_STR*/"objc_msgSendSuper2_fixup");
        } else {
          fn = ObjCTypes.getMessageSendFixupFn();
          messageRefName.$addassign_T$C$P(/*KEEP_STR*/"objc_msgSend_fixup");
        }
      }
      assert ((fn != null)) : "CGObjCNonFragileABIMac::EmitMessageSend";
      messageRefName.$addassign_T($$UNDERSCORE);
      
      // Append the selector name, except use underscores anywhere we
      // would have used colons.
      appendSelectorForMessageRefTable(messageRefName, new Selector(selector));
      
      GlobalVariable /*P*/ messageRef = CGM.getModule().getGlobalVariable(new StringRef(messageRefName));
      if (!(messageRef != null)) {
        // Build the message ref structure.
        Constant /*P*/ values[/*2*/] = new Constant /*P*/  [/*2*/] {fn, GetMethodVarName(new Selector(selector))};
        Constant /*P*/ init = ConstantStruct.getAnon(new ArrayRef<Constant /*P*/ >(values, true));
        messageRef = /*NEW_EXPR [GlobalVariable::new]*/GlobalVariable.$new_GlobalVariable((type$ptr<?> New$Mem)->{
            return new GlobalVariable(CGM.getModule(), 
            init.getType(), 
            /*constant*/ false, 
            GlobalValue.LinkageTypes.WeakAnyLinkage, 
            init, 
            new Twine(messageRefName));
         });
        messageRef.setVisibility(GlobalValue.VisibilityTypes.HiddenVisibility);
        messageRef.setAlignment(16);
        messageRef.setSection(new StringRef(/*KEEP_STR*/"__DATA, __objc_msgrefs, coalesced"));
      }
      
      boolean requiresnullCheck = false;
      if (CGM.getLangOpts().ObjCAutoRefCount && (method != null)) {
        for (/*const*/ ParmVarDecl /*P*/ ParamDecl : method.parameters()) {
          if (ParamDecl.hasAttr(NSConsumedAttr.class)) {
            if (!(nullReturn.NullBB != null)) {
              nullReturn.init(CGF, arg0);
            }
            requiresnullCheck = true;
            break;
          }
        }
      }
      
      Address mref = new Address(CGF.Builder.CreateBitCast(messageRef, ObjCTypes.MessageRefPtrTy), 
          CGF.getPointerAlign());
      
      // Update the message ref argument.
      args.$at(1).RV.$assignMove(RValue.get(mref.getPointer()));
      
      // Load the function to call from the message ref table.
      Address calleeAddr = CGF.Builder.CreateStructGEP(new Address(mref), 0, CharUnits.Zero());
      Value /*P*/ callee = CGF.Builder.CreateLoad(new Address(calleeAddr), $("msgSend_fn"));
      
      callee = CGF.Builder.CreateBitCast(callee, MSI.MessengerType);
      
      RValue result = CGF.EmitCall(MSI.CallInfo, callee, new ReturnValueSlot(returnSlot), args);
      return nullReturn.complete(CGF, new RValue(result), new QualType(resultType), formalArgs, 
          requiresnullCheck ? method : (/*const*/ ObjCMethodDecl /*P*/ )null);
    } finally {
      if (args != null) { args.$destroy(); }
    }
  }

  
  /// GetClassGlobal - Return the global variable for the Objective-C
  /// class of the given name.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCNonFragileABIMac::GetClassGlobal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 6919,
   FQN="(anonymous namespace)::CGObjCNonFragileABIMac::GetClassGlobal", NM="_ZN12_GLOBAL__N_122CGObjCNonFragileABIMac14GetClassGlobalEN4llvm9StringRefEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_122CGObjCNonFragileABIMac14GetClassGlobalEN4llvm9StringRefEb")
  //</editor-fold>
  @Override public/*private*/ GlobalVariable /*P*/ GetClassGlobal(StringRef Name)/* override*/ {
    return GetClassGlobal(Name, false);
  }
  @Override public/*private*/ GlobalVariable /*P*/ GetClassGlobal(StringRef Name, boolean Weak/*= false*/)/* override*/ {
    GlobalValue.LinkageTypes L = Weak ? GlobalValue.LinkageTypes.ExternalWeakLinkage : GlobalValue.LinkageTypes.ExternalLinkage;
    
    GlobalVariable /*P*/ GV = CGM.getModule().getGlobalVariable(new StringRef(Name));
    if (!(GV != null)) {
      GV = /*NEW_EXPR [GlobalVariable::new]*/GlobalVariable.$new_GlobalVariable((type$ptr<?> New$Mem)->{
          return new GlobalVariable(CGM.getModule(), ObjCTypes.ClassnfABITy, 
          false, L, (Constant /*P*/ )null, new Twine(Name));
       });
    }
    assert (GV.getLinkage() == L);
    return GV;
  }

  
  /// EmitClassRef - Return a Value*, of type ObjCTypes.ClassPtrTy,
  /// for the given class reference.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCNonFragileABIMac::EmitClassRef">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 6956,
   FQN="(anonymous namespace)::CGObjCNonFragileABIMac::EmitClassRef", NM="_ZN12_GLOBAL__N_122CGObjCNonFragileABIMac12EmitClassRefERN5clang7CodeGen15CodeGenFunctionEPKNS1_17ObjCInterfaceDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_122CGObjCNonFragileABIMac12EmitClassRefERN5clang7CodeGen15CodeGenFunctionEPKNS1_17ObjCInterfaceDeclE")
  //</editor-fold>
  private Value /*P*/ EmitClassRef(final CodeGenFunction /*&*/ CGF, 
              /*const*/ ObjCInterfaceDecl /*P*/ ID) {
    // If the class has the objc_runtime_visible attribute, we need to
    // use the Objective-C runtime to get the class.
    if (ID.hasAttr(ObjCRuntimeVisibleAttr.class)) {
      return EmitClassRefViaRuntime(CGF, ID, ObjCTypes);
    }
    
    return EmitClassRefFromId(CGF, ID.getIdentifier(), ID.isWeakImported(), ID);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCNonFragileABIMac::EmitClassRefFromId">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 6935,
   FQN="(anonymous namespace)::CGObjCNonFragileABIMac::EmitClassRefFromId", NM="_ZN12_GLOBAL__N_122CGObjCNonFragileABIMac18EmitClassRefFromIdERN5clang7CodeGen15CodeGenFunctionEPNS1_14IdentifierInfoEbPKNS1_17ObjCInterfaceDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_122CGObjCNonFragileABIMac18EmitClassRefFromIdERN5clang7CodeGen15CodeGenFunctionEPNS1_14IdentifierInfoEbPKNS1_17ObjCInterfaceDeclE")
  //</editor-fold>
  private Value /*P*/ EmitClassRefFromId(final CodeGenFunction /*&*/ CGF, 
                    IdentifierInfo /*P*/ II, 
                    boolean Weak, 
                    /*const*/ ObjCInterfaceDecl /*P*/ ID) {
    CharUnits Align = CGF.getPointerAlign();
    final type$ref<GlobalVariable /*P*/ /*&*/> Entry = ClassReferences.ref$at(II);
    if (!(Entry.$deref() != null)) {
      StringRef Name = (ID != null) ? ID.getObjCRuntimeNameAsString() : II.getName();
      std.string ClassName = ($add_Twine$C(new Twine(getClassSymbolPrefix()), new Twine(Name))).str();
      GlobalVariable /*P*/ ClassGV = GetClassGlobal(new StringRef(ClassName), Weak);
      Entry.$set(/*NEW_EXPR [GlobalVariable::new]*/GlobalVariable.$new_GlobalVariable((type$ptr<?> New$Mem)->{
          return new GlobalVariable(CGM.getModule(), ObjCTypes.ClassnfABIPtrTy, 
          false, GlobalValue.LinkageTypes.PrivateLinkage, 
                  ClassGV, new Twine(/*KEEP_STR*/"OBJC_CLASSLIST_REFERENCES_$_"));
       }));
      Entry.$deref().setAlignment($long2uint(Align.getQuantity()));
      Entry.$deref().setSection(new StringRef(/*KEEP_STR*/"__DATA, __objc_classrefs, regular, no_dead_strip"));
      CGM.addCompilerUsedGlobal(Entry.$deref());
    }
    return CGF.Builder.CreateAlignedLoad(Entry.$deref(), new CharUnits(Align));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCNonFragileABIMac::EmitNSAutoreleasePoolClassRef">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 6966,
   FQN="(anonymous namespace)::CGObjCNonFragileABIMac::EmitNSAutoreleasePoolClassRef", NM="_ZN12_GLOBAL__N_122CGObjCNonFragileABIMac29EmitNSAutoreleasePoolClassRefERN5clang7CodeGen15CodeGenFunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_122CGObjCNonFragileABIMac29EmitNSAutoreleasePoolClassRefERN5clang7CodeGen15CodeGenFunctionE")
  //</editor-fold>
  @Override public/*private*/ Value /*P*/ EmitNSAutoreleasePoolClassRef(final CodeGenFunction /*&*/ CGF)/* override*/ {
    IdentifierInfo /*P*/ II = $AddrOf(CGM.getContext().Idents.get(new StringRef(/*KEEP_STR*/"NSAutoreleasePool")));
    return EmitClassRefFromId(CGF, II, false, (/*const*/ ObjCInterfaceDecl /*P*/ )null);
  }

  
  /// EmitSuperClassRef - Return a Value*, of type ObjCTypes.ClassPtrTy,
  /// for the given super class reference.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCNonFragileABIMac::EmitSuperClassRef">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 6972,
   FQN="(anonymous namespace)::CGObjCNonFragileABIMac::EmitSuperClassRef", NM="_ZN12_GLOBAL__N_122CGObjCNonFragileABIMac17EmitSuperClassRefERN5clang7CodeGen15CodeGenFunctionEPKNS1_17ObjCInterfaceDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_122CGObjCNonFragileABIMac17EmitSuperClassRefERN5clang7CodeGen15CodeGenFunctionEPKNS1_17ObjCInterfaceDeclE")
  //</editor-fold>
  private Value /*P*/ EmitSuperClassRef(final CodeGenFunction /*&*/ CGF, 
                   /*const*/ ObjCInterfaceDecl /*P*/ ID) {
    CharUnits Align = CGF.getPointerAlign();
    final type$ref<GlobalVariable /*P*/ /*&*/> Entry = SuperClassReferences.ref$at(ID.getIdentifier());
    if (!(Entry.$deref() != null)) {
      SmallString/*<64>*/ ClassName/*J*/= new SmallString/*<64>*/(64, getClassSymbolPrefix());
      ClassName.$addassign(ID.getObjCRuntimeNameAsString());
      GlobalVariable /*P*/ ClassGV = GetClassGlobal(ClassName.str(), 
          ID.isWeakImported());
      Entry.$set(/*NEW_EXPR [GlobalVariable::new]*/GlobalVariable.$new_GlobalVariable((type$ptr<?> New$Mem)->{
          return new GlobalVariable(CGM.getModule(), ObjCTypes.ClassnfABIPtrTy, 
          false, GlobalValue.LinkageTypes.PrivateLinkage, 
                  ClassGV, new Twine(/*KEEP_STR*/"OBJC_CLASSLIST_SUP_REFS_$_"));
       }));
      Entry.$deref().setAlignment($long2uint(Align.getQuantity()));
      Entry.$deref().setSection(new StringRef(/*KEEP_STR*/"__DATA, __objc_superrefs, regular, no_dead_strip"));
      CGM.addCompilerUsedGlobal(Entry.$deref());
    }
    return CGF.Builder.CreateAlignedLoad(Entry.$deref(), new CharUnits(Align));
  }

  
  /// EmitMetaClassRef - Return a Value * of the address of _class_t
  /// meta-data
  
  /// EmitMetaClassRef - Return a Value * of the address of _class_t
  /// meta-data
  ///
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCNonFragileABIMac::EmitMetaClassRef">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 6996,
   FQN="(anonymous namespace)::CGObjCNonFragileABIMac::EmitMetaClassRef", NM="_ZN12_GLOBAL__N_122CGObjCNonFragileABIMac16EmitMetaClassRefERN5clang7CodeGen15CodeGenFunctionEPKNS1_17ObjCInterfaceDeclEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_122CGObjCNonFragileABIMac16EmitMetaClassRefERN5clang7CodeGen15CodeGenFunctionEPKNS1_17ObjCInterfaceDeclEb")
  //</editor-fold>
  private Value /*P*/ EmitMetaClassRef(final CodeGenFunction /*&*/ CGF, 
                  /*const*/ ObjCInterfaceDecl /*P*/ ID, 
                  boolean Weak) {
    CharUnits Align = CGF.getPointerAlign();
    final type$ref<GlobalVariable /*P*/ /*&*/> Entry = MetaClassReferences.ref$at(ID.getIdentifier());
    if (!(Entry.$deref() != null)) {
      SmallString/*<64>*/ MetaClassName/*J*/= new SmallString/*<64>*/(64, getMetaclassSymbolPrefix());
      MetaClassName.$addassign(ID.getObjCRuntimeNameAsString());
      GlobalVariable /*P*/ MetaClassGV = GetClassGlobal(MetaClassName.str(), Weak);
      
      Entry.$set(/*NEW_EXPR [GlobalVariable::new]*/GlobalVariable.$new_GlobalVariable((type$ptr<?> New$Mem)->{
          return new GlobalVariable(CGM.getModule(), ObjCTypes.ClassnfABIPtrTy, 
          false, GlobalValue.LinkageTypes.PrivateLinkage, 
                  MetaClassGV, new Twine(/*KEEP_STR*/"OBJC_CLASSLIST_SUP_REFS_$_"));
       }));
      Entry.$deref().setAlignment($long2uint(Align.getQuantity()));
      
      Entry.$deref().setSection(new StringRef(/*KEEP_STR*/"__DATA, __objc_superrefs, regular, no_dead_strip"));
      CGM.addCompilerUsedGlobal(Entry.$deref());
    }
    
    return CGF.Builder.CreateAlignedLoad(Entry.$deref(), new CharUnits(Align));
  }

  
  /// ObjCIvarOffsetVariable - Returns the ivar offset variable for
  /// the given ivar.
  ///
  
  /// ObjCIvarOffsetVariable - Returns the ivar offset variable for
  /// the given ivar.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCNonFragileABIMac::ObjCIvarOffsetVariable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 6360,
   FQN="(anonymous namespace)::CGObjCNonFragileABIMac::ObjCIvarOffsetVariable", NM="_ZN12_GLOBAL__N_122CGObjCNonFragileABIMac22ObjCIvarOffsetVariableEPKN5clang17ObjCInterfaceDeclEPKNS1_12ObjCIvarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_122CGObjCNonFragileABIMac22ObjCIvarOffsetVariableEPKN5clang17ObjCInterfaceDeclEPKNS1_12ObjCIvarDeclE")
  //</editor-fold>
  private GlobalVariable /*P*/ ObjCIvarOffsetVariable(/*const*/ ObjCInterfaceDecl /*P*/ ID, 
                        /*const*/ ObjCIvarDecl /*P*/ Ivar) {
    /*const*/ ObjCInterfaceDecl /*P*/ Container = Ivar.getContainingInterface();
    SmallString/*<64>*/ Name/*J*/= new SmallString/*<64>*/(64, new StringRef(/*KEEP_STR*/"OBJC_IVAR_$_"));
    Name.$addassign(Container.getObjCRuntimeNameAsString());
    Name.$addassign(/*STRINGREF_STR*/".");
    Name.$addassign(Ivar.getName());
    GlobalVariable /*P*/ IvarOffsetGV = CGM.getModule().getGlobalVariable(Name.$StringRef());
    if (!(IvarOffsetGV != null)) {
      IvarOffsetGV
         = /*NEW_EXPR [GlobalVariable::new]*/GlobalVariable.$new_GlobalVariable((type$ptr<?> New$Mem)->{
          return new GlobalVariable(CGM.getModule(), ObjCTypes.IvarOffsetVarTy, 
          false, GlobalValue.LinkageTypes.ExternalLinkage, 
          (Constant /*P*/ )null, new Twine(Name.str()));
       });
      if (CGM.getTriple().isOSBinFormatCOFF()) {
        boolean IsPrivateOrPackage = Ivar.getAccessControl() == ObjCIvarDecl.AccessControl.Private
           || Ivar.getAccessControl() == ObjCIvarDecl.AccessControl.Package;
        if (ID.hasAttr(DLLExportAttr.class) && !IsPrivateOrPackage) {
          IvarOffsetGV.setDLLStorageClass(GlobalValue.DLLStorageClassTypes.DLLExportStorageClass);
        } else if (ID.hasAttr(DLLImportAttr.class)) {
          IvarOffsetGV.setDLLStorageClass(GlobalValue.DLLStorageClassTypes.DLLImportStorageClass);
        }
      }
    }
    return IvarOffsetGV;
  }

  
  /// EmitSelector - Return a Value*, of type ObjCTypes.SelectorPtrTy,
  /// for the given selector.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCNonFragileABIMac::EmitSelector">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 7086,
   FQN="(anonymous namespace)::CGObjCNonFragileABIMac::EmitSelector", NM="_ZN12_GLOBAL__N_122CGObjCNonFragileABIMac12EmitSelectorERN5clang7CodeGen15CodeGenFunctionENS1_8SelectorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_122CGObjCNonFragileABIMac12EmitSelectorERN5clang7CodeGen15CodeGenFunctionENS1_8SelectorE")
  //</editor-fold>
  private Value /*P*/ EmitSelector(final CodeGenFunction /*&*/ CGF, 
              Selector Sel) {
    Address Addr = EmitSelectorAddr(CGF, new Selector(Sel));
    
    LoadInst /*P*/ LI = CGF.Builder.CreateLoad(new Address(Addr));
    LI.setMetadata(CGM.getModule().getMDKindID(new StringRef(/*KEEP_STR*/"invariant.load")), 
        MDNode.get(VMContext, new ArrayRef<Metadata /*P*/ >(None, true)));
    return LI;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCNonFragileABIMac::EmitSelectorAddr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 7096,
   FQN="(anonymous namespace)::CGObjCNonFragileABIMac::EmitSelectorAddr", NM="_ZN12_GLOBAL__N_122CGObjCNonFragileABIMac16EmitSelectorAddrERN5clang7CodeGen15CodeGenFunctionENS1_8SelectorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_122CGObjCNonFragileABIMac16EmitSelectorAddrERN5clang7CodeGen15CodeGenFunctionENS1_8SelectorE")
  //</editor-fold>
  private Address EmitSelectorAddr(final CodeGenFunction /*&*/ CGF, 
                  Selector Sel) {
    final type$ref<GlobalVariable /*P*/ /*&*/> Entry = SelectorReferences.ref$at(Sel);
    
    CharUnits Align = CGF.getPointerAlign();
    if (!(Entry.$deref() != null)) {
      Constant /*P*/ Casted = ConstantExpr.getBitCast(GetMethodVarName(new Selector(Sel)), 
          ObjCTypes.SelectorPtrTy);
      Entry.$set(/*NEW_EXPR [GlobalVariable::new]*/GlobalVariable.$new_GlobalVariable((type$ptr<?> New$Mem)->{
          return new GlobalVariable(CGM.getModule(), ObjCTypes.SelectorPtrTy, 
          false, GlobalValue.LinkageTypes.PrivateLinkage, 
                  Casted, new Twine(/*KEEP_STR*/"OBJC_SELECTOR_REFERENCES_"));
       }));
      Entry.$deref().setExternallyInitialized(true);
      Entry.$deref().setSection(new StringRef(/*KEEP_STR*/"__DATA, __objc_selrefs, literal_pointers, no_dead_strip"));
      Entry.$deref().setAlignment($long2uint(Align.getQuantity()));
      CGM.addCompilerUsedGlobal(Entry.$deref());
    }
    
    return new Address(Entry.$deref(), new CharUnits(Align));
  }

  
  /// GetInterfaceEHType - Get the cached ehtype for the given Objective-C
  /// interface. The return value has type EHTypePtrTy.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCNonFragileABIMac::GetInterfaceEHType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 7291,
   FQN="(anonymous namespace)::CGObjCNonFragileABIMac::GetInterfaceEHType", NM="_ZN12_GLOBAL__N_122CGObjCNonFragileABIMac18GetInterfaceEHTypeEPKN5clang17ObjCInterfaceDeclEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_122CGObjCNonFragileABIMac18GetInterfaceEHTypeEPKN5clang17ObjCInterfaceDeclEb")
  //</editor-fold>
  private Constant /*P*/ GetInterfaceEHType(/*const*/ ObjCInterfaceDecl /*P*/ ID, 
                    boolean ForDefinition) {
    final type$ref<GlobalVariable /*P*/ /*&*/> Entry = EHTypeReferences.ref$at(ID.getIdentifier());
    StringRef ClassName = ID.getObjCRuntimeNameAsString();
    
    // If we don't need a definition, return the entry if found or check
    // if we use an external reference.
    if (!ForDefinition) {
      if ((Entry.$deref() != null)) {
        return Entry.$deref();
      }
      
      // If this type (or a super class) has the __objc_exception__
      // attribute, emit an external reference.
      if (CGObjCMacStatics.hasObjCExceptionAttribute(CGM.getContext(), ID)) {
        std.string EHTypeName = ($add_char$ptr$C_StringRef$C(/*KEEP_STR*/"OBJC_EHTYPE_$_", ClassName)).str();
        Entry.$set(/*NEW_EXPR [GlobalVariable::new]*/GlobalVariable.$new_GlobalVariable((type$ptr<?> New$Mem)->{
            return new GlobalVariable(CGM.getModule(), ObjCTypes.EHTypeTy, 
            false, GlobalValue.LinkageTypes.ExternalLinkage, 
                    (Constant /*P*/ )null, new Twine(EHTypeName));
         }));
        if (CGM.getTriple().isOSBinFormatCOFF()) {
          if (ID.hasAttr(DLLExportAttr.class)) {
            Entry.$deref().setDLLStorageClass(GlobalValue.DLLStorageClassTypes.DLLExportStorageClass);
          } else if (ID.hasAttr(DLLImportAttr.class)) {
            Entry.$deref().setDLLStorageClass(GlobalValue.DLLStorageClassTypes.DLLImportStorageClass);
          }
        }
        return Entry.$deref();
      }
    }
    
    // Otherwise we need to either make a new entry or fill in the initializer.
    assert ((!(Entry.$deref() != null) || !Entry.$deref().hasInitializer())) : "Duplicate EHType definition";
    
    std.string VTableName = new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"objc_ehtype_vtable");
    GlobalVariable /*P*/ VTableGV = CGM.getModule().getGlobalVariable(new StringRef(VTableName));
    if (!(VTableGV != null)) {
      VTableGV
         = /*NEW_EXPR [GlobalVariable::new]*/GlobalVariable.$new_GlobalVariable((type$ptr<?> New$Mem)->{
          return new GlobalVariable(CGM.getModule(), ObjCTypes.Int8PtrTy, false, 
          GlobalValue.LinkageTypes.ExternalLinkage, (Constant /*P*/ )null, 
          new Twine(VTableName));
       });
      if (CGM.getTriple().isOSBinFormatCOFF()) {
        VTableGV.setDLLStorageClass(CGObjCMacStatics.getStorage(CGM, new StringRef(VTableName)));
      }
    }
    
    Value /*P*/ VTableIdx = ConstantInt.get(CGM.Int32Ty, $int2ulong(2));
    Constant /*P*/ Values[/*3*/] = new Constant /*P*/  [/*3*/] {
      ConstantExpr.getGetElementPtr_Type$P_Constant$P_ArrayRef$Value$P_bool_Type$P(VTableGV.getValueType(), VTableGV, 
          new ArrayRef<Value /*P*/ >(VTableIdx, true)), 
      GetClassName(ID.getObjCRuntimeNameAsString()), 
      GetClassGlobal(new StringRef(($add_Twine$C(new Twine(getClassSymbolPrefix()), new Twine(ClassName))).str()))
    };
    Constant /*P*/ Init = ConstantStruct.get(ObjCTypes.EHTypeTy, new ArrayRef<Constant /*P*/ >(Values, true));
    
    GlobalValue.LinkageTypes L = ForDefinition ? GlobalValue.LinkageTypes.ExternalLinkage : GlobalValue.LinkageTypes.WeakAnyLinkage;
    if ((Entry.$deref() != null)) {
      Entry.$deref().setInitializer(Init);
    } else {
      Entry.$set(/*NEW_EXPR [GlobalVariable::new]*/GlobalVariable.$new_GlobalVariable((type$ptr<?> New$Mem)->{
          return new GlobalVariable(CGM.getModule(), ObjCTypes.EHTypeTy, false, L, 
                  Init, new Twine(($add_char$ptr$C_StringRef$C(/*KEEP_STR*/"OBJC_EHTYPE_$_", ClassName)).str()));
       }));
      if (CGM.getTriple().isOSBinFormatCOFF()) {
        if (CGObjCMacStatics.hasObjCExceptionAttribute(CGM.getContext(), ID)) {
          if (ID.hasAttr(DLLExportAttr.class)) {
            Entry.$deref().setDLLStorageClass(GlobalValue.DLLStorageClassTypes.DLLExportStorageClass);
          }
        }
      }
    }
    assert (Entry.$deref().getLinkage() == L);
    if (!CGM.getTriple().isOSBinFormatCOFF()) {
      if (ID.getVisibility() == Visibility.HiddenVisibility) {
        Entry.$deref().setVisibility(GlobalValue.VisibilityTypes.HiddenVisibility);
      }
    }
    
    final /*const*/ DataLayout /*&*/ DL = CGM.getDataLayout();
    Entry.$deref().setAlignment(DL.getABITypeAlignment(ObjCTypes.EHTypeTy));
    if (ForDefinition) {
      Entry.$deref().setSection(new StringRef(/*KEEP_STR*/"__DATA,__objc_const"));
    }
    
    return Entry.$deref();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCNonFragileABIMac::getMetaclassSymbolPrefix">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 1409,
   FQN="(anonymous namespace)::CGObjCNonFragileABIMac::getMetaclassSymbolPrefix", NM="_ZNK12_GLOBAL__N_122CGObjCNonFragileABIMac24getMetaclassSymbolPrefixEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZNK12_GLOBAL__N_122CGObjCNonFragileABIMac24getMetaclassSymbolPrefixEv")
  //</editor-fold>
  private StringRef getMetaclassSymbolPrefix() /*const*/ {
    return new StringRef(/*KEEP_STR*/"OBJC_METACLASS_$_");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCNonFragileABIMac::getClassSymbolPrefix">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 1411,
   FQN="(anonymous namespace)::CGObjCNonFragileABIMac::getClassSymbolPrefix", NM="_ZNK12_GLOBAL__N_122CGObjCNonFragileABIMac20getClassSymbolPrefixEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZNK12_GLOBAL__N_122CGObjCNonFragileABIMac20getClassSymbolPrefixEv")
  //</editor-fold>
  private StringRef getClassSymbolPrefix() /*const*/ {
    return new StringRef(/*KEEP_STR*/"OBJC_CLASS_$_");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCNonFragileABIMac::GetClassSizeInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 5965,
   FQN="(anonymous namespace)::CGObjCNonFragileABIMac::GetClassSizeInfo", NM="_ZN12_GLOBAL__N_122CGObjCNonFragileABIMac16GetClassSizeInfoEPKN5clang22ObjCImplementationDeclERjS5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_122CGObjCNonFragileABIMac16GetClassSizeInfoEPKN5clang22ObjCImplementationDeclERjS5_")
  //</editor-fold>
  private void GetClassSizeInfo(/*const*/ ObjCImplementationDecl /*P*/ OID, 
                  final /*uint32_t &*/uint$ref InstanceStart, 
                  final /*uint32_t &*/uint$ref InstanceSize) {
    final /*const*/ ASTRecordLayout /*&*/ RL = CGM.getContext().getASTObjCImplementationLayout(OID);
    
    // InstanceSize is really instance end.
    InstanceSize.$set($long2uint(RL.getDataSize().getQuantity()));
    
    // If there are no fields, the start is the same as the end.
    if (!(RL.getFieldCount() != 0)) {
      InstanceStart.$set(InstanceSize.$deref());
    } else {
      InstanceStart.$set($ullong2uint($div_ulong(RL.getFieldOffset(0), CGM.getContext().getCharWidth())));
    }
  }

  
  // Shamelessly stolen from Analysis/CFRefCount.cpp
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCNonFragileABIMac::GetNullarySelector">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 1418,
   FQN="(anonymous namespace)::CGObjCNonFragileABIMac::GetNullarySelector", NM="_ZNK12_GLOBAL__N_122CGObjCNonFragileABIMac18GetNullarySelectorEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZNK12_GLOBAL__N_122CGObjCNonFragileABIMac18GetNullarySelectorEPKc")
  //</editor-fold>
  private Selector GetNullarySelector(/*const*/char$ptr/*char P*/ name) /*const*/ {
    type$ptr<IdentifierInfo /*P*/ > II = create_type$ptr($AddrOf(CGM.getContext().Idents.get(new StringRef(name))));
    return CGM.getContext().Selectors.getSelector(0, $AddrOf(II));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCNonFragileABIMac::GetUnarySelector">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 1423,
   FQN="(anonymous namespace)::CGObjCNonFragileABIMac::GetUnarySelector", NM="_ZNK12_GLOBAL__N_122CGObjCNonFragileABIMac16GetUnarySelectorEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZNK12_GLOBAL__N_122CGObjCNonFragileABIMac16GetUnarySelectorEPKc")
  //</editor-fold>
  private Selector GetUnarySelector(/*const*/char$ptr/*char P*/ name) /*const*/ {
    type$ptr<IdentifierInfo /*P*/ > II = create_type$ptr($AddrOf(CGM.getContext().Idents.get(new StringRef(name))));
    return CGM.getContext().Selectors.getSelector(1, $AddrOf(II));
  }

  
  /// ImplementationIsNonLazy - Check whether the given category or
  /// class implementation is "non-lazy".
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCNonFragileABIMac::ImplementationIsNonLazy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 5960,
   FQN="(anonymous namespace)::CGObjCNonFragileABIMac::ImplementationIsNonLazy", NM="_ZNK12_GLOBAL__N_122CGObjCNonFragileABIMac23ImplementationIsNonLazyEPKN5clang12ObjCImplDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZNK12_GLOBAL__N_122CGObjCNonFragileABIMac23ImplementationIsNonLazyEPKN5clang12ObjCImplDeclE")
  //</editor-fold>
  private boolean ImplementationIsNonLazy(/*const*/ ObjCImplDecl /*P*/ OD) /*const*/ {
    return OD.getClassMethod(GetNullarySelector($("load"))) != null;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCNonFragileABIMac::IsIvarOffsetKnownIdempotent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 1432,
   FQN="(anonymous namespace)::CGObjCNonFragileABIMac::IsIvarOffsetKnownIdempotent", NM="_ZN12_GLOBAL__N_122CGObjCNonFragileABIMac27IsIvarOffsetKnownIdempotentERKN5clang7CodeGen15CodeGenFunctionEPKNS1_12ObjCIvarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_122CGObjCNonFragileABIMac27IsIvarOffsetKnownIdempotentERKN5clang7CodeGen15CodeGenFunctionEPKNS1_12ObjCIvarDeclE")
  //</editor-fold>
  private boolean IsIvarOffsetKnownIdempotent(final /*const*/ CodeGenFunction /*&*/ CGF, 
                             /*const*/ ObjCIvarDecl /*P*/ IV) {
    {
      // Annotate the load as an invariant load iff inside an instance method
      // and ivar belongs to instance method's class and one of its super class.
      // This check is needed because the ivar offset is a lazily
      // initialised value that may depend on objc_msgSend to perform a fixup on
      // the first message dispatch.
      //
      // An additional opportunity to mark the load as invariant arises when the
      // base of the ivar access is a parameter to an Objective C method.
      // However, because the parameters are not available in the current
      // interface, we cannot perform this check.
      /*const*/ ObjCMethodDecl /*P*/ MD = dyn_cast_or_null_ObjCMethodDecl(CGF.CurFuncDecl);
      if ((MD != null)) {
        if (MD.isInstanceMethod()) {
          {
            /*const*/ ObjCInterfaceDecl /*P*/ ID = MD.getClassInterface$Const();
            if ((ID != null)) {
              return IV.getContainingInterface().isSuperClassOf(ID);
            }
          }
        }
      }
    }
    return false;
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCNonFragileABIMac::CGObjCNonFragileABIMac">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 5206,
   FQN="(anonymous namespace)::CGObjCNonFragileABIMac::CGObjCNonFragileABIMac", NM="_ZN12_GLOBAL__N_122CGObjCNonFragileABIMacC1ERN5clang7CodeGen13CodeGenModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_122CGObjCNonFragileABIMacC1ERN5clang7CodeGen13CodeGenModuleE")
  //</editor-fold>
  public CGObjCNonFragileABIMac(final CodeGenModule /*&*/ cgm) {
    // : CGObjCCommonMac(cgm), ObjCTypes(cgm), ObjCEmptyCacheVar(null), ObjCEmptyVtableVar(null), SuperClassReferences(), MetaClassReferences(), EHTypeReferences(), VTableDispatchMethods(), DefinedMetaClasses() 
    //START JInit
    super(cgm);
    this.ObjCTypes = new ObjCNonFragileABITypesHelper(cgm);
    this.ObjCEmptyCacheVar = null;
    this.ObjCEmptyVtableVar = null;
    this.SuperClassReferences = new DenseMap<IdentifierInfo /*P*/ , GlobalVariable /*P*/ >(DenseMapInfo$LikePtr.$Info(), (GlobalVariable /*P*/ )null);
    this.MetaClassReferences = new DenseMap<IdentifierInfo /*P*/ , GlobalVariable /*P*/ >(DenseMapInfo$LikePtr.$Info(), (GlobalVariable /*P*/ )null);
    this.EHTypeReferences = new DenseMap<IdentifierInfo /*P*/ , GlobalVariable /*P*/ >(DenseMapInfo$LikePtr.$Info(), (GlobalVariable /*P*/ )null);
    this.VTableDispatchMethods = new DenseSet<Selector>(DenseMapInfoSelector.$Info());
    this.DefinedMetaClasses = new std.vector<GlobalValue /*P*/ >((GlobalValue /*P*/ )null);
    //END JInit
    ObjCABI = 2;
  }

  // FIXME. All stubs for now!
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCNonFragileABIMac::ModuleInitFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 5685,
   FQN="(anonymous namespace)::CGObjCNonFragileABIMac::ModuleInitFunction", NM="_ZN12_GLOBAL__N_122CGObjCNonFragileABIMac18ModuleInitFunctionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_122CGObjCNonFragileABIMac18ModuleInitFunctionEv")
  //</editor-fold>
  @Override public Function /*P*/ ModuleInitFunction()/* override*/ {
    FinishNonFragileABIModule();
    
    return null;
  }

  
  
  /// Generate code for a message send expression in the nonfragile abi.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCNonFragileABIMac::GenerateMessageSend">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 6900,
   FQN="(anonymous namespace)::CGObjCNonFragileABIMac::GenerateMessageSend", NM="_ZN12_GLOBAL__N_122CGObjCNonFragileABIMac19GenerateMessageSendERN5clang7CodeGen15CodeGenFunctionENS2_15ReturnValueSlotENS1_8QualTypeENS1_8SelectorEPN4llvm5ValueERKNS2_11CallArgListEPKNS1_17ObjCInterfaceDeclEPKNS1_14ObjCMethodDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_122CGObjCNonFragileABIMac19GenerateMessageSendERN5clang7CodeGen15CodeGenFunctionENS2_15ReturnValueSlotENS1_8QualTypeENS1_8SelectorEPN4llvm5ValueERKNS2_11CallArgListEPKNS1_17ObjCInterfaceDeclEPKNS1_14ObjCMethodDeclE")
  //</editor-fold>
  @Override public RValue GenerateMessageSend(final CodeGenFunction /*&*/ CGF, 
                     ReturnValueSlot Return, 
                     QualType ResultType, 
                     Selector Sel, 
                     Value /*P*/ Receiver, 
                     final /*const*/ CallArgList /*&*/ CallArgs, 
                     /*const*/ ObjCInterfaceDecl /*P*/ Class, 
                     /*const*/ ObjCMethodDecl /*P*/ Method)/* override*/ {
    return isVTableDispatchedSelector(new Selector(Sel)) ? EmitVTableMessageSend(CGF, new ReturnValueSlot(Return), new QualType(ResultType), new Selector(Sel), 
        Receiver, CGF.getContext().getObjCIdType(), 
        false, CallArgs, Method) : EmitMessageSend(CGF, new ReturnValueSlot(Return), new QualType(ResultType), 
        EmitSelector(CGF, new Selector(Sel)), 
        Receiver, CGF.getContext().getObjCIdType(), 
        false, CallArgs, Method, Class, ObjCTypes);
  }

  
  
  /// Generates a message send where the super is the receiver.  This is
  /// a message send to self with special delivery semantics indicating
  /// which class's method should be called.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCNonFragileABIMac::GenerateMessageSendSuper">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 7037,
   FQN="(anonymous namespace)::CGObjCNonFragileABIMac::GenerateMessageSendSuper", NM="_ZN12_GLOBAL__N_122CGObjCNonFragileABIMac24GenerateMessageSendSuperERN5clang7CodeGen15CodeGenFunctionENS2_15ReturnValueSlotENS1_8QualTypeENS1_8SelectorEPKNS1_17ObjCInterfaceDeclEbPN4llvm5ValueEbRKNS2_11CallArgListEPKNS1_14ObjCMethodDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_122CGObjCNonFragileABIMac24GenerateMessageSendSuperERN5clang7CodeGen15CodeGenFunctionENS2_15ReturnValueSlotENS1_8QualTypeENS1_8SelectorEPKNS1_17ObjCInterfaceDeclEbPN4llvm5ValueEbRKNS2_11CallArgListEPKNS1_14ObjCMethodDeclE")
  //</editor-fold>
  @Override public RValue GenerateMessageSendSuper(final CodeGenFunction /*&*/ CGF, 
                          ReturnValueSlot Return, 
                          QualType ResultType, 
                          Selector Sel, 
                          /*const*/ ObjCInterfaceDecl /*P*/ Class, 
                          boolean isCategoryImpl, 
                          Value /*P*/ Receiver, 
                          boolean IsClassMessage, 
                          final /*const*/ CallArgList /*&*/ CallArgs, 
                          /*const*/ ObjCMethodDecl /*P*/ Method)/* override*/ {
    // ...
    // Create and init a super structure; this is a (receiver, class)
    // pair we will pass to objc_msgSendSuper.
    Address ObjCSuper = CGF.CreateTempAlloca(ObjCTypes.SuperTy, CGF.getPointerAlign(), 
        new Twine(/*KEEP_STR*/"objc_super"));
    
    Value /*P*/ ReceiverAsObject = CGF.Builder.CreateBitCast(Receiver, ObjCTypes.ObjectPtrTy);
    CGF.Builder.CreateStore(ReceiverAsObject, 
        CGF.Builder.CreateStructGEP(new Address(ObjCSuper), 0, CharUnits.Zero()));
    
    // If this is a class message the metaclass is passed as the target.
    Value /*P*/ Target;
    if (IsClassMessage) {
      Target = EmitMetaClassRef(CGF, Class, Class.isWeakImported());
    } else {
      Target = EmitSuperClassRef(CGF, Class);
    }
    
    // FIXME: We shouldn't need to do this cast, rectify the ASTContext and
    // ObjCTypes types.
    org.llvm.ir.Type /*P*/ ClassTy = CGM.getTypes().ConvertType(CGF.getContext().getObjCClassType());
    Target = CGF.Builder.CreateBitCast(Target, ClassTy);
    CGF.Builder.CreateStore(Target, CGF.Builder.CreateStructGEP(new Address(ObjCSuper), 1, CGF.getPointerSize()));
    
    return (isVTableDispatchedSelector(new Selector(Sel))) ? EmitVTableMessageSend(CGF, new ReturnValueSlot(Return), new QualType(ResultType), new Selector(Sel), 
        ObjCSuper.getPointer(), new QualType(ObjCTypes.SuperPtrCTy), 
        true, CallArgs, Method) : EmitMessageSend(CGF, new ReturnValueSlot(Return), new QualType(ResultType), 
        EmitSelector(CGF, new Selector(Sel)), 
        ObjCSuper.getPointer(), new QualType(ObjCTypes.SuperPtrCTy), 
        true, CallArgs, Method, Class, ObjCTypes);
  }

  
  
  /// GetClass - Return a reference to the class for the given interface
  /// decl.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCNonFragileABIMac::GetClass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 7021,
   FQN="(anonymous namespace)::CGObjCNonFragileABIMac::GetClass", NM="_ZN12_GLOBAL__N_122CGObjCNonFragileABIMac8GetClassERN5clang7CodeGen15CodeGenFunctionEPKNS1_17ObjCInterfaceDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_122CGObjCNonFragileABIMac8GetClassERN5clang7CodeGen15CodeGenFunctionEPKNS1_17ObjCInterfaceDeclE")
  //</editor-fold>
  @Override public Value /*P*/ GetClass(final CodeGenFunction /*&*/ CGF, 
          /*const*/ ObjCInterfaceDecl /*P*/ ID)/* override*/ {
    if (ID.isWeakImported()) {
      SmallString/*<64>*/ ClassName/*J*/= new SmallString/*<64>*/(64, getClassSymbolPrefix());
      ClassName.$addassign(ID.getObjCRuntimeNameAsString());
      GlobalVariable /*P*/ ClassGV = GetClassGlobal(ClassName.str(), true);
      ///*J:(void)*/ClassGV;
      assert (ClassGV.hasExternalWeakLinkage());
    }
    
    return EmitClassRef(CGF, ID);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCNonFragileABIMac::GetSelector">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 1476,
   FQN="(anonymous namespace)::CGObjCNonFragileABIMac::GetSelector", NM="_ZN12_GLOBAL__N_122CGObjCNonFragileABIMac11GetSelectorERN5clang7CodeGen15CodeGenFunctionENS1_8SelectorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_122CGObjCNonFragileABIMac11GetSelectorERN5clang7CodeGen15CodeGenFunctionENS1_8SelectorE")
  //</editor-fold>
  @Override public Value /*P*/ GetSelector(final CodeGenFunction /*&*/ CGF, Selector Sel)/* override*/ {
    return EmitSelector(CGF, new Selector(Sel));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCNonFragileABIMac::GetAddrOfSelector">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 1478,
   FQN="(anonymous namespace)::CGObjCNonFragileABIMac::GetAddrOfSelector", NM="_ZN12_GLOBAL__N_122CGObjCNonFragileABIMac17GetAddrOfSelectorERN5clang7CodeGen15CodeGenFunctionENS1_8SelectorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_122CGObjCNonFragileABIMac17GetAddrOfSelectorERN5clang7CodeGen15CodeGenFunctionENS1_8SelectorE")
  //</editor-fold>
  @Override public Address GetAddrOfSelector(final CodeGenFunction /*&*/ CGF, Selector Sel)/* override*/ {
    return EmitSelectorAddr(CGF, new Selector(Sel));
  }

  
  /// The NeXT/Apple runtimes do not support typed selectors; just emit an
  /// untyped one.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCNonFragileABIMac::GetSelector">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 1483,
   FQN="(anonymous namespace)::CGObjCNonFragileABIMac::GetSelector", NM="_ZN12_GLOBAL__N_122CGObjCNonFragileABIMac11GetSelectorERN5clang7CodeGen15CodeGenFunctionEPKNS1_14ObjCMethodDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_122CGObjCNonFragileABIMac11GetSelectorERN5clang7CodeGen15CodeGenFunctionEPKNS1_14ObjCMethodDeclE")
  //</editor-fold>
  @Override public Value /*P*/ GetSelector(final CodeGenFunction /*&*/ CGF, 
             /*const*/ ObjCMethodDecl /*P*/ Method)/* override*/ {
    return EmitSelector(CGF, Method.getSelector());
  }

  
  
  /// GenerateCategory - Build metadata for a category implementation.
  /// struct _category_t {
  ///   const char * const name;
  ///   struct _class_t *const cls;
  ///   const struct _method_list_t * const instance_methods;
  ///   const struct _method_list_t * const class_methods;
  ///   const struct _protocol_list_t * const protocols;
  ///   const struct _prop_list_t * const properties;
  ///   const struct _prop_list_t * const class_properties;
  ///   const uint32_t size;
  /// }
  ///
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCNonFragileABIMac::GenerateCategory">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 6211,
   FQN="(anonymous namespace)::CGObjCNonFragileABIMac::GenerateCategory", NM="_ZN12_GLOBAL__N_122CGObjCNonFragileABIMac16GenerateCategoryEPKN5clang20ObjCCategoryImplDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_122CGObjCNonFragileABIMac16GenerateCategoryEPKN5clang20ObjCCategoryImplDeclE")
  //</editor-fold>
  @Override public void GenerateCategory(/*const*/ ObjCCategoryImplDecl /*P*/ OCD)/* override*/ {
    std.vector<Constant /*P*/ > Methods = null;
    try {
      /*const*/ ObjCInterfaceDecl /*P*/ Interface = OCD.getClassInterface$Const();
      /*const*/char$ptr/*char P*/ Prefix = $("\001l_OBJC_$_CATEGORY_");
      
      SmallString/*<64>*/ ExtCatName/*J*/= new SmallString/*<64>*/(64, new StringRef(Prefix));
      ExtCatName.$addassign(Interface.getObjCRuntimeNameAsString());
      ExtCatName.$addassign(/*STRINGREF_STR*/"_$_");
      ExtCatName.$addassign(new StringRef(OCD.getNameAsString()));
      
      SmallString/*<64>*/ ExtClassName/*J*/= new SmallString/*<64>*/(64, getClassSymbolPrefix());
      ExtClassName.$addassign(Interface.getObjCRuntimeNameAsString());
      
      Constant /*P*/ Values[/*8*/] = new Constant /*P*/  [8];
      Values[0] = GetClassName(OCD.getIdentifier().getName());
      // meta-class entry symbol
      GlobalVariable /*P*/ ClassGV = GetClassGlobal(ExtClassName.str(), Interface.isWeakImported());
      
      Values[1] = ClassGV;
      Methods/*J*/= new std.vector<Constant /*P*/ >((Constant /*P*/ )null);
      SmallString/*<64>*/ MethodListName/*J*/= new SmallString/*<64>*/(64, new StringRef(Prefix));
      
      MethodListName.$addassign(/*STRINGREF_STR*/"INSTANCE_METHODS_");
      MethodListName.$addassign(Interface.getObjCRuntimeNameAsString());
      MethodListName.$addassign(/*STRINGREF_STR*/"_$_");
      MethodListName.$addassign(OCD.getName());
      
      for (/*const*/ ObjCMethodDecl /*P*/ I : OCD.instance_methods())  {
        // Instance methods should always be defined.
        Methods.push_back_T$RR(GetMethodConstant(I));
      }
      
      Values[2] = EmitMethodList(new Twine(MethodListName.str()), 
          new StringRef(/*KEEP_STR*/"__DATA, __objc_const"), 
          new ArrayRef<Constant /*P*/ >(Methods, true));
      
      MethodListName.$assign(/*STRINGREF_STR*/Prefix);
      MethodListName.$addassign(/*STRINGREF_STR*/"CLASS_METHODS_");
      MethodListName.$addassign(Interface.getObjCRuntimeNameAsString());
      MethodListName.$addassign(/*STRINGREF_STR*/"_$_");
      MethodListName.$addassign(new StringRef(OCD.getNameAsString()));
      
      Methods.clear();
      for (/*const*/ ObjCMethodDecl /*P*/ I : OCD.class_methods())  {
        // Class methods should always be defined.
        Methods.push_back_T$RR(GetMethodConstant(I));
      }
      
      Values[3] = EmitMethodList(new Twine(MethodListName.str()), 
          new StringRef(/*KEEP_STR*/"__DATA, __objc_const"), 
          new ArrayRef<Constant /*P*/ >(Methods, true));
      /*const*/ ObjCCategoryDecl /*P*/ Category = Interface.FindCategoryDeclaration(OCD.getIdentifier());
      if ((Category != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          SmallString/*<256>*/ ExtName/*J*/= new SmallString/*<256>*/(256);
          $c$.clean($c$.track(new raw_svector_ostream(ExtName)).$out(Interface.getObjCRuntimeNameAsString()).$out(/*KEEP_STR*/"_$_").$out(
              OCD.getName()
          ));
          Values[4] = EmitProtocolList($add_Twine$C($add_Twine$C($add_char$ptr$C_StringRef$C(/*KEEP_STR*/"\001l_OBJC_CATEGORY_PROTOCOLS_$_", 
                          Interface.getObjCRuntimeNameAsString()), new Twine(/*KEEP_STR*/"_$_")), 
                  new Twine(Category.getName())), 
              Category.protocol_begin(), 
              Category.protocol_end());
          Values[5] = EmitPropertyList($add_char$ptr$C_StringRef$C(/*KEEP_STR*/"\001l_OBJC_$_PROP_LIST_", ExtName.str()), 
              OCD, Category, ObjCTypes, false);
          Values[6] = EmitPropertyList($add_char$ptr$C_StringRef$C(/*KEEP_STR*/"\001l_OBJC_$_CLASS_PROP_LIST_", ExtName.str()), 
              OCD, Category, ObjCTypes, true);
        } finally {
          $c$.$destroy();
        }
      } else {
        Values[4] = Constant.getNullValue(ObjCTypes.ProtocolListnfABIPtrTy);
        Values[5] = Constant.getNullValue(ObjCTypes.PropertyListPtrTy);
        Values[6] = Constant.getNullValue(ObjCTypes.PropertyListPtrTy);
      }
      
      /*uint*/int Size = $ulong2uint(CGM.getDataLayout().getTypeAllocSize(ObjCTypes.CategorynfABITy));
      Values[7] = ConstantInt.get(ObjCTypes.IntTy, $uint2ulong(Size));
      
      Constant /*P*/ Init = ConstantStruct.get(ObjCTypes.CategorynfABITy, 
          new ArrayRef<Constant /*P*/ >(Values, true));
      GlobalVariable /*P*/ GCATV = /*NEW_EXPR [GlobalVariable::new]*/GlobalVariable.$new_GlobalVariable((type$ptr<?> New$Mem)->{
          return new GlobalVariable(CGM.getModule(), ObjCTypes.CategorynfABITy, 
          false, 
          GlobalValue.LinkageTypes.PrivateLinkage, 
          Init, 
          new Twine(ExtCatName.str()));
       });
      GCATV.setAlignment(CGM.getDataLayout().getABITypeAlignment(ObjCTypes.CategorynfABITy));
      GCATV.setSection(new StringRef(/*KEEP_STR*/"__DATA, __objc_const"));
      CGM.addCompilerUsedGlobal(GCATV);
      DefinedCategories.push_back(GCATV);
      
      // Determine if this category is also "non-lazy".
      if (ImplementationIsNonLazy(OCD)) {
        DefinedNonLazyCategories.push_back(GCATV);
      }
      // method definition entries must be clear for next implementation.
      MethodDefinitions.clear();
    } finally {
      if (Methods != null) { Methods.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCNonFragileABIMac::GenerateClass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 6001,
   FQN="(anonymous namespace)::CGObjCNonFragileABIMac::GenerateClass", NM="_ZN12_GLOBAL__N_122CGObjCNonFragileABIMac13GenerateClassEPKN5clang22ObjCImplementationDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_122CGObjCNonFragileABIMac13GenerateClassEPKN5clang22ObjCImplementationDeclE")
  //</editor-fold>
  @Override public void GenerateClass(/*const*/ ObjCImplementationDecl /*P*/ ID)/* override*/ {
    if (!(ObjCEmptyCacheVar != null)) {
      ObjCEmptyCacheVar
         = /*NEW_EXPR [GlobalVariable::new]*/GlobalVariable.$new_GlobalVariable((type$ptr<?> New$Mem)->{
          return new GlobalVariable(CGM.getModule(), ObjCTypes.CacheTy, false, 
          GlobalValue.LinkageTypes.ExternalLinkage, (Constant /*P*/ )null, 
          new Twine(/*KEEP_STR*/"_objc_empty_cache"));
       });
      if (CGM.getTriple().isOSBinFormatCOFF()) {
        ObjCEmptyCacheVar.setDLLStorageClass(CGObjCMacStatics.getStorage(CGM, new StringRef(/*KEEP_STR*/"_objc_empty_cache")));
      }
      
      // Only OS X with deployment version <10.9 use the empty vtable symbol
      final /*const*/ Triple /*&*/ $Triple = CGM.getTarget().getTriple();
      if ($Triple.isMacOSX() && $Triple.isMacOSXVersionLT(10, 9)) {
        ObjCEmptyVtableVar
           = /*NEW_EXPR [GlobalVariable::new]*/GlobalVariable.$new_GlobalVariable((type$ptr<?> New$Mem)->{
            return new GlobalVariable(CGM.getModule(), ObjCTypes.ImpnfABITy, false, 
            GlobalValue.LinkageTypes.ExternalLinkage, (Constant /*P*/ )null, 
            new Twine(/*KEEP_STR*/"_objc_empty_vtable"));
         });
      }
    }
    
    // FIXME: Is this correct (that meta class size is never computed)?
    uint$ref InstanceStart = create_uint$ref($ulong2uint(CGM.getDataLayout().getTypeAllocSize(ObjCTypes.ClassnfABITy)));
    uint$ref InstanceSize = create_uint$ref(InstanceStart.$deref());
    /*uint32_t*/int flags = NonFragileClassFlags.NonFragileABI_Class_Meta;
    
    GlobalVariable /*P*/ SuperClassGV;
    GlobalVariable /*P*/ IsAGV;
    
    StringRef ClassName = ID.getObjCRuntimeNameAsString();
    /*const*/ ObjCInterfaceDecl /*P*/ CI = ID.getClassInterface$Const();
    assert ((CI != null)) : "CGObjCNonFragileABIMac::GenerateClass - class is 0";
    
    // Build the flags for the metaclass.
    boolean classIsHidden = (CGM.getTriple().isOSBinFormatCOFF()) ? !CI.hasAttr(DLLExportAttr.class) : CI.getVisibility() == Visibility.HiddenVisibility;
    if (classIsHidden) {
      flags |= NonFragileClassFlags.NonFragileABI_Class_Hidden;
    }
    
    // FIXME: why is this flag set on the metaclass?
    // ObjC metaclasses have no fields and don't really get constructed.
    if (ID.hasNonZeroConstructors() || ID.hasDestructors()) {
      flags |= NonFragileClassFlags.NonFragileABI_Class_HasCXXStructors;
      if (!ID.hasNonZeroConstructors()) {
        flags |= NonFragileClassFlags.NonFragileABI_Class_HasCXXDestructorOnly;
      }
    }
    if (!(CI.getSuperClass() != null)) {
      // class is root
      flags |= NonFragileClassFlags.NonFragileABI_Class_Root;
      
      SuperClassGV = GetClassGlobal(new StringRef(($add_Twine$C(new Twine(getClassSymbolPrefix()), new Twine(ClassName))).str()), 
          CI.isWeakImported());
      if (CGM.getTriple().isOSBinFormatCOFF()) {
        if (CI.hasAttr(DLLImportAttr.class)) {
          SuperClassGV.setDLLStorageClass(GlobalValue.DLLStorageClassTypes.DLLImportStorageClass);
        }
      }
      
      IsAGV = GetClassGlobal(new StringRef(($add_Twine$C(new Twine(getMetaclassSymbolPrefix()), new Twine(ClassName))).str()), 
          CI.isWeakImported());
      if (CGM.getTriple().isOSBinFormatCOFF()) {
        if (CI.hasAttr(DLLImportAttr.class)) {
          IsAGV.setDLLStorageClass(GlobalValue.DLLStorageClassTypes.DLLImportStorageClass);
        }
      }
    } else {
      // Has a root. Current class is not a root.
      /*const*/ ObjCInterfaceDecl /*P*/ Root = ID.getClassInterface$Const();
      {
        /*const*/ ObjCInterfaceDecl /*P*/ Super;
        while (((/*P*/ Super = Root.getSuperClass()) != null)) {
          Root = Super;
        }
      }
      
      /*const*/ ObjCInterfaceDecl /*P*/ Super$1 = CI.getSuperClass();
      StringRef RootClassName = Root.getObjCRuntimeNameAsString();
      StringRef SuperClassName = Super$1.getObjCRuntimeNameAsString();
      
      IsAGV = GetClassGlobal(new StringRef(($add_Twine$C(new Twine(getMetaclassSymbolPrefix()), new Twine(RootClassName))).str()), 
          Root.isWeakImported());
      if (CGM.getTriple().isOSBinFormatCOFF()) {
        if (Root.hasAttr(DLLImportAttr.class)) {
          IsAGV.setDLLStorageClass(GlobalValue.DLLStorageClassTypes.DLLImportStorageClass);
        }
      }
      
      // work on super class metadata symbol.
      SuperClassGV
         = GetClassGlobal(new StringRef(($add_Twine$C(new Twine(getMetaclassSymbolPrefix()), new Twine(SuperClassName))).str()), 
          Super$1.isWeakImported());
      if (CGM.getTriple().isOSBinFormatCOFF()) {
        if (Super$1.hasAttr(DLLImportAttr.class)) {
          SuperClassGV.setDLLStorageClass(GlobalValue.DLLStorageClassTypes.DLLImportStorageClass);
        }
      }
    }
    
    GlobalVariable /*P*/ CLASS_RO_GV = BuildClassRoTInitializer(flags, InstanceStart.$deref(), InstanceSize.$deref(), ID);
    
    GlobalVariable /*P*/ MetaTClass = BuildClassMetaData(($add_Twine$C(new Twine(getMetaclassSymbolPrefix()), new Twine(ClassName))).str(), IsAGV, 
        SuperClassGV, CLASS_RO_GV, classIsHidden, 
        CI.isWeakImported());
    if (CGM.getTriple().isOSBinFormatCOFF()) {
      if (CI.hasAttr(DLLExportAttr.class)) {
        MetaTClass.setDLLStorageClass(GlobalValue.DLLStorageClassTypes.DLLExportStorageClass);
      }
    }
    DefinedMetaClasses.push_back_T$RR(MetaTClass);
    
    // Metadata for the class
    flags = 0;
    if (classIsHidden) {
      flags |= NonFragileClassFlags.NonFragileABI_Class_Hidden;
    }
    if (ID.hasNonZeroConstructors() || ID.hasDestructors()) {
      flags |= NonFragileClassFlags.NonFragileABI_Class_HasCXXStructors;
      
      // Set a flag to enable a runtime optimization when a class has
      // fields that require destruction but which don't require
      // anything except zero-initialization during construction.  This
      // is most notably true of __strong and __weak types, but you can
      // also imagine there being C++ types with non-trivial default
      // constructors that merely set all fields to null.
      if (!ID.hasNonZeroConstructors()) {
        flags |= NonFragileClassFlags.NonFragileABI_Class_HasCXXDestructorOnly;
      }
    }
    if (CGObjCMacStatics.hasObjCExceptionAttribute(CGM.getContext(), CI)) {
      flags |= NonFragileClassFlags.NonFragileABI_Class_Exception;
    }
    if (!(CI.getSuperClass() != null)) {
      flags |= NonFragileClassFlags.NonFragileABI_Class_Root;
      SuperClassGV = null;
    } else {
      // Has a root. Current class is not a root.
      /*const*/ ObjCInterfaceDecl /*P*/ Super = CI.getSuperClass();
      StringRef SuperClassName = Super.getObjCRuntimeNameAsString();
      
      SuperClassGV
         = GetClassGlobal(new StringRef(($add_Twine$C(new Twine(getClassSymbolPrefix()), new Twine(SuperClassName))).str()), 
          Super.isWeakImported());
      if (CGM.getTriple().isOSBinFormatCOFF()) {
        if (Super.hasAttr(DLLImportAttr.class)) {
          SuperClassGV.setDLLStorageClass(GlobalValue.DLLStorageClassTypes.DLLImportStorageClass);
        }
      }
    }
    
    GetClassSizeInfo(ID, InstanceStart, InstanceSize);
    CLASS_RO_GV
       = BuildClassRoTInitializer(flags, InstanceStart.$deref(), InstanceSize.$deref(), ID);
    
    GlobalVariable /*P*/ ClassMD = BuildClassMetaData(($add_Twine$C(new Twine(getClassSymbolPrefix()), new Twine(ClassName))).str(), MetaTClass, 
        SuperClassGV, CLASS_RO_GV, classIsHidden, 
        CI.isWeakImported());
    if (CGM.getTriple().isOSBinFormatCOFF()) {
      if (CI.hasAttr(DLLExportAttr.class)) {
        ClassMD.setDLLStorageClass(GlobalValue.DLLStorageClassTypes.DLLExportStorageClass);
      }
    }
    DefinedClasses.push_back(ClassMD);
    ImplementedClasses.push_back(CI);
    
    // Determine if this class is also "non-lazy".
    if (ImplementationIsNonLazy(ID)) {
      DefinedNonLazyClasses.push_back(ClassMD);
    }
    
    // Force the definition of the EHType if necessary.
    if (((flags & NonFragileClassFlags.NonFragileABI_Class_Exception) != 0)) {
      GetInterfaceEHType(CI, true);
    }
    // Make sure method definition entries are all clear for next implementation.
    MethodDefinitions.clear();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCNonFragileABIMac::RegisterAlias">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 1491,
   FQN="(anonymous namespace)::CGObjCNonFragileABIMac::RegisterAlias", NM="_ZN12_GLOBAL__N_122CGObjCNonFragileABIMac13RegisterAliasEPKN5clang23ObjCCompatibleAliasDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_122CGObjCNonFragileABIMac13RegisterAliasEPKN5clang23ObjCCompatibleAliasDeclE")
  //</editor-fold>
  @Override public void RegisterAlias(/*const*/ ObjCCompatibleAliasDecl /*P*/ OAD)/* override*/ {
  }

  
  
  /// GenerateProtocolRef - This routine is called to generate code for
  /// a protocol reference expression; as in:
  /// @code
  ///   @protocol(Proto1);
  /// @endcode
  /// It generates a weak reference to l_OBJC_PROTOCOL_REFERENCE_$_Proto1
  /// which will hold address of the protocol meta-data.
  ///
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCNonFragileABIMac::GenerateProtocolRef">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 6168,
   FQN="(anonymous namespace)::CGObjCNonFragileABIMac::GenerateProtocolRef", NM="_ZN12_GLOBAL__N_122CGObjCNonFragileABIMac19GenerateProtocolRefERN5clang7CodeGen15CodeGenFunctionEPKNS1_16ObjCProtocolDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_122CGObjCNonFragileABIMac19GenerateProtocolRefERN5clang7CodeGen15CodeGenFunctionEPKNS1_16ObjCProtocolDeclE")
  //</editor-fold>
  @Override public Value /*P*/ GenerateProtocolRef(final CodeGenFunction /*&*/ CGF, 
                     /*const*/ ObjCProtocolDecl /*P*/ PD)/* override*/ {
    
    // This routine is called for @protocol only. So, we must build definition
    // of protocol's meta-data (not a reference to it!)
    //
    Constant /*P*/ Init = ConstantExpr.getBitCast(GetOrEmitProtocol(PD), 
        ObjCTypes.getExternalProtocolPtrTy());
    
    std.string ProtocolName/*J*/= new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"\001l_OBJC_PROTOCOL_REFERENCE_$_");
    $addassign_string_StringRef(ProtocolName, PD.getObjCRuntimeNameAsString());
    
    CharUnits Align = CGF.getPointerAlign();
    
    GlobalVariable /*P*/ PTGV = CGM.getModule().getGlobalVariable(new StringRef(ProtocolName));
    if ((PTGV != null)) {
      return CGF.Builder.CreateAlignedLoad(PTGV, new CharUnits(Align));
    }
    PTGV = /*NEW_EXPR [GlobalVariable::new]*/GlobalVariable.$new_GlobalVariable((type$ptr<?> New$Mem)->{
        return new GlobalVariable(CGM.getModule(), 
        Init.getType(), false, 
        GlobalValue.LinkageTypes.WeakAnyLinkage, 
        Init, 
        new Twine(ProtocolName));
     });
    PTGV.setSection(new StringRef(/*KEEP_STR*/"__DATA, __objc_protorefs, coalesced, no_dead_strip"));
    PTGV.setVisibility(GlobalValue.VisibilityTypes.HiddenVisibility);
    PTGV.setAlignment($long2uint(Align.getQuantity()));
    CGM.addCompilerUsedGlobal(PTGV);
    return CGF.Builder.CreateAlignedLoad(PTGV, new CharUnits(Align));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCNonFragileABIMac::GetEHType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 7238,
   FQN="(anonymous namespace)::CGObjCNonFragileABIMac::GetEHType", NM="_ZN12_GLOBAL__N_122CGObjCNonFragileABIMac9GetEHTypeEN5clang8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_122CGObjCNonFragileABIMac9GetEHTypeEN5clang8QualTypeE")
  //</editor-fold>
  @Override public Constant /*P*/ GetEHType(QualType T)/* override*/ {
    // There's a particular fixed type info for 'id'.
    if (T.$arrow().isObjCIdType() || T.$arrow().isObjCQualifiedIdType()) {
      GlobalVariable /*P*/ IDEHType = CGM.getModule().getGlobalVariable(new StringRef(/*KEEP_STR*/"OBJC_EHTYPE_id"));
      if (!(IDEHType != null)) {
        IDEHType
           = /*NEW_EXPR [GlobalVariable::new]*/GlobalVariable.$new_GlobalVariable((type$ptr<?> New$Mem)->{
            return new GlobalVariable(CGM.getModule(), ObjCTypes.EHTypeTy, false, 
            GlobalValue.LinkageTypes.ExternalLinkage, (Constant /*P*/ )null, 
            new Twine(/*KEEP_STR*/"OBJC_EHTYPE_id"));
         });
        if (CGM.getTriple().isOSBinFormatCOFF()) {
          IDEHType.setDLLStorageClass(CGObjCMacStatics.getStorage(CGM, new StringRef(/*KEEP_STR*/"OBJC_EHTYPE_id")));
        }
      }
      return IDEHType;
    }
    
    // All other types should be Objective-C interface pointer types.
    /*const*/ ObjCObjectPointerType /*P*/ PT = T.$arrow().getAs(ObjCObjectPointerType.class);
    assert ((PT != null)) : "Invalid @catch type.";
    
    /*const*/ ObjCInterfaceType /*P*/ IT = PT.getInterfaceType();
    assert ((IT != null)) : "Invalid @catch type.";
    
    return GetInterfaceEHType(IT.getDecl(), false);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCNonFragileABIMac::GetPropertyGetFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 1498,
   FQN="(anonymous namespace)::CGObjCNonFragileABIMac::GetPropertyGetFunction", NM="_ZN12_GLOBAL__N_122CGObjCNonFragileABIMac22GetPropertyGetFunctionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_122CGObjCNonFragileABIMac22GetPropertyGetFunctionEv")
  //</editor-fold>
  @Override public Constant /*P*/ GetPropertyGetFunction()/* override*/ {
    return ObjCTypes.getGetPropertyFn();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCNonFragileABIMac::GetPropertySetFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 1501,
   FQN="(anonymous namespace)::CGObjCNonFragileABIMac::GetPropertySetFunction", NM="_ZN12_GLOBAL__N_122CGObjCNonFragileABIMac22GetPropertySetFunctionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_122CGObjCNonFragileABIMac22GetPropertySetFunctionEv")
  //</editor-fold>
  @Override public Constant /*P*/ GetPropertySetFunction()/* override*/ {
    return ObjCTypes.getSetPropertyFn();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCNonFragileABIMac::GetOptimizedPropertySetFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 1505,
   FQN="(anonymous namespace)::CGObjCNonFragileABIMac::GetOptimizedPropertySetFunction", NM="_ZN12_GLOBAL__N_122CGObjCNonFragileABIMac31GetOptimizedPropertySetFunctionEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_122CGObjCNonFragileABIMac31GetOptimizedPropertySetFunctionEbb")
  //</editor-fold>
  @Override public Constant /*P*/ GetOptimizedPropertySetFunction(boolean atomic, 
                                 boolean copy)/* override*/ {
    return ObjCTypes.getOptimizedSetPropertyFn(atomic, copy);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCNonFragileABIMac::GetSetStructFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 1510,
   FQN="(anonymous namespace)::CGObjCNonFragileABIMac::GetSetStructFunction", NM="_ZN12_GLOBAL__N_122CGObjCNonFragileABIMac20GetSetStructFunctionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_122CGObjCNonFragileABIMac20GetSetStructFunctionEv")
  //</editor-fold>
  @Override public Constant /*P*/ GetSetStructFunction()/* override*/ {
    return ObjCTypes.getCopyStructFn();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCNonFragileABIMac::GetGetStructFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 1514,
   FQN="(anonymous namespace)::CGObjCNonFragileABIMac::GetGetStructFunction", NM="_ZN12_GLOBAL__N_122CGObjCNonFragileABIMac20GetGetStructFunctionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_122CGObjCNonFragileABIMac20GetGetStructFunctionEv")
  //</editor-fold>
  @Override public Constant /*P*/ GetGetStructFunction()/* override*/ {
    return ObjCTypes.getCopyStructFn();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCNonFragileABIMac::GetCppAtomicObjectSetFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 1518,
   FQN="(anonymous namespace)::CGObjCNonFragileABIMac::GetCppAtomicObjectSetFunction", NM="_ZN12_GLOBAL__N_122CGObjCNonFragileABIMac29GetCppAtomicObjectSetFunctionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_122CGObjCNonFragileABIMac29GetCppAtomicObjectSetFunctionEv")
  //</editor-fold>
  @Override public Constant /*P*/ GetCppAtomicObjectSetFunction()/* override*/ {
    return ObjCTypes.getCppAtomicObjectFunction();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCNonFragileABIMac::GetCppAtomicObjectGetFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 1522,
   FQN="(anonymous namespace)::CGObjCNonFragileABIMac::GetCppAtomicObjectGetFunction", NM="_ZN12_GLOBAL__N_122CGObjCNonFragileABIMac29GetCppAtomicObjectGetFunctionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_122CGObjCNonFragileABIMac29GetCppAtomicObjectGetFunctionEv")
  //</editor-fold>
  @Override public Constant /*P*/ GetCppAtomicObjectGetFunction()/* override*/ {
    return ObjCTypes.getCppAtomicObjectFunction();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCNonFragileABIMac::EnumerationMutationFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 1526,
   FQN="(anonymous namespace)::CGObjCNonFragileABIMac::EnumerationMutationFunction", NM="_ZN12_GLOBAL__N_122CGObjCNonFragileABIMac27EnumerationMutationFunctionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_122CGObjCNonFragileABIMac27EnumerationMutationFunctionEv")
  //</editor-fold>
  @Override public Constant /*P*/ EnumerationMutationFunction()/* override*/ {
    return ObjCTypes.getEnumerationMutationFn();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCNonFragileABIMac::EmitTryStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 7264,
   FQN="(anonymous namespace)::CGObjCNonFragileABIMac::EmitTryStmt", NM="_ZN12_GLOBAL__N_122CGObjCNonFragileABIMac11EmitTryStmtERN5clang7CodeGen15CodeGenFunctionERKNS1_13ObjCAtTryStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_122CGObjCNonFragileABIMac11EmitTryStmtERN5clang7CodeGen15CodeGenFunctionERKNS1_13ObjCAtTryStmtE")
  //</editor-fold>
  @Override public void EmitTryStmt(final CodeGenFunction /*&*/ CGF, 
             final /*const*/ ObjCAtTryStmt /*&*/ S)/* override*/ {
    EmitTryCatchStmt(CGF, S, 
        cast_Function(ObjCTypes.getObjCBeginCatchFn()), 
        cast_Function(ObjCTypes.getObjCEndCatchFn()), 
        cast_Function(ObjCTypes.getExceptionRethrowFn()));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCNonFragileABIMac::EmitSynchronizedStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 7230,
   FQN="(anonymous namespace)::CGObjCNonFragileABIMac::EmitSynchronizedStmt", NM="_ZN12_GLOBAL__N_122CGObjCNonFragileABIMac20EmitSynchronizedStmtERN5clang7CodeGen15CodeGenFunctionERKNS1_22ObjCAtSynchronizedStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_122CGObjCNonFragileABIMac20EmitSynchronizedStmtERN5clang7CodeGen15CodeGenFunctionERKNS1_22ObjCAtSynchronizedStmtE")
  //</editor-fold>
  @Override public void EmitSynchronizedStmt(final CodeGenFunction /*&*/ CGF, 
                      final /*const*/ ObjCAtSynchronizedStmt /*&*/ S)/* override*/ {
    EmitAtSynchronizedStmt(CGF, S, 
        cast_Function(ObjCTypes.getSyncEnterFn()), 
        cast_Function(ObjCTypes.getSyncExitFn()));
  }

  
  /// EmitThrowStmt - Generate code for a throw statement.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCNonFragileABIMac::EmitThrowStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 7273,
   FQN="(anonymous namespace)::CGObjCNonFragileABIMac::EmitThrowStmt", NM="_ZN12_GLOBAL__N_122CGObjCNonFragileABIMac13EmitThrowStmtERN5clang7CodeGen15CodeGenFunctionERKNS1_15ObjCAtThrowStmtEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_122CGObjCNonFragileABIMac13EmitThrowStmtERN5clang7CodeGen15CodeGenFunctionERKNS1_15ObjCAtThrowStmtEb")
  //</editor-fold>
  @Override public void EmitThrowStmt(final CodeGenFunction /*&*/ CGF, 
               final /*const*/ ObjCAtThrowStmt /*&*/ S)/* override*/ {
    EmitThrowStmt(CGF, 
               S, 
               true);
  }
  @Override public void EmitThrowStmt(final CodeGenFunction /*&*/ CGF, 
               final /*const*/ ObjCAtThrowStmt /*&*/ S, 
               boolean ClearInsertionPoint/*= true*/)/* override*/ {
    {
      /*const*/ Expr /*P*/ ThrowExpr = S.getThrowExpr$Const();
      if ((ThrowExpr != null)) {
        Value /*P*/ Exception = CGF.EmitObjCThrowOperand(ThrowExpr);
        Exception = CGF.Builder.CreateBitCast(Exception, ObjCTypes.ObjectPtrTy);
        CGF.EmitRuntimeCallOrInvoke(ObjCTypes.getExceptionThrowFn(), new ArrayRef<Value /*P*/ >(Exception, true)).
            setDoesNotReturn();
      } else {
        CGF.EmitRuntimeCallOrInvoke(ObjCTypes.getExceptionRethrowFn()).
            setDoesNotReturn();
      }
    }
    
    CGF.Builder.CreateUnreachable();
    if (ClearInsertionPoint) {
      CGF.Builder.ClearInsertionPoint();
    }
  }

  
  /// EmitObjCWeakRead - Code gen for loading value of a __weak
  /// object: objc_read_weak (id *src)
  ///
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCNonFragileABIMac::EmitObjCWeakRead">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 7173,
   FQN="(anonymous namespace)::CGObjCNonFragileABIMac::EmitObjCWeakRead", NM="_ZN12_GLOBAL__N_122CGObjCNonFragileABIMac16EmitObjCWeakReadERN5clang7CodeGen15CodeGenFunctionENS2_7AddressE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_122CGObjCNonFragileABIMac16EmitObjCWeakReadERN5clang7CodeGen15CodeGenFunctionENS2_7AddressE")
  //</editor-fold>
  @Override public Value /*P*/ EmitObjCWeakRead(final CodeGenFunction /*&*/ CGF, 
                  Address AddrWeakObj)/* override*/ {
    org.llvm.ir.Type /*P*/ DestTy = AddrWeakObj.getElementType();
    AddrWeakObj.$assignMove(CGF.Builder.CreateBitCast(new Address(AddrWeakObj), ObjCTypes.PtrObjectPtrTy));
    Value /*P*/ read_weak = CGF.EmitNounwindRuntimeCall(ObjCTypes.getGcReadWeakFn(), 
        new ArrayRef<Value /*P*/ >(AddrWeakObj.getPointer(), true), new Twine(/*KEEP_STR*/"weakread"));
    read_weak = CGF.Builder.CreateBitCast(read_weak, DestTy);
    return read_weak;
  }

  
  /// EmitObjCWeakAssign - Code gen for assigning to a __weak object.
  /// objc_assign_weak (id src, id *dst)
  ///
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCNonFragileABIMac::EmitObjCWeakAssign">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 7188,
   FQN="(anonymous namespace)::CGObjCNonFragileABIMac::EmitObjCWeakAssign", NM="_ZN12_GLOBAL__N_122CGObjCNonFragileABIMac18EmitObjCWeakAssignERN5clang7CodeGen15CodeGenFunctionEPN4llvm5ValueENS2_7AddressE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_122CGObjCNonFragileABIMac18EmitObjCWeakAssignERN5clang7CodeGen15CodeGenFunctionEPN4llvm5ValueENS2_7AddressE")
  //</editor-fold>
  @Override public void EmitObjCWeakAssign(final CodeGenFunction /*&*/ CGF, 
                    Value /*P*/ src, Address dst)/* override*/ {
    org.llvm.ir.Type /*P*/ SrcTy = src.getType();
    if (!isa_PointerType(SrcTy)) {
      /*uint*/int Size = $ulong2uint(CGM.getDataLayout().getTypeAllocSize(SrcTy));
      assert ($lesseq_uint(Size, 8)) : "does not support size > 8";
      src = (Size == 4 ? CGF.Builder.CreateBitCast(src, ObjCTypes.IntTy) : CGF.Builder.CreateBitCast(src, ObjCTypes.LongTy));
      src = CGF.Builder.CreateIntToPtr(src, ObjCTypes.Int8PtrTy);
    }
    src = CGF.Builder.CreateBitCast(src, ObjCTypes.ObjectPtrTy);
    dst.$assignMove(CGF.Builder.CreateBitCast(new Address(dst), ObjCTypes.PtrObjectPtrTy));
    Value /*P*/ args[/*2*/] = new Value /*P*/  [/*2*/] {src, dst.getPointer()};
    CGF.EmitNounwindRuntimeCall(ObjCTypes.getGcAssignWeakFn(), 
        new ArrayRef<Value /*P*/ >(args, true), new Twine(/*KEEP_STR*/"weakassign"));
  }

  
  /// EmitObjCGlobalAssign - Code gen for assigning to a __strong object.
  /// objc_assign_global (id src, id *dst)
  ///
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCNonFragileABIMac::EmitObjCGlobalAssign">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 7208,
   FQN="(anonymous namespace)::CGObjCNonFragileABIMac::EmitObjCGlobalAssign", NM="_ZN12_GLOBAL__N_122CGObjCNonFragileABIMac20EmitObjCGlobalAssignERN5clang7CodeGen15CodeGenFunctionEPN4llvm5ValueENS2_7AddressEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_122CGObjCNonFragileABIMac20EmitObjCGlobalAssignERN5clang7CodeGen15CodeGenFunctionEPN4llvm5ValueENS2_7AddressEb")
  //</editor-fold>
  @Override public void EmitObjCGlobalAssign(final CodeGenFunction /*&*/ CGF, 
                      Value /*P*/ src, Address dst)/* override*/ {
    EmitObjCGlobalAssign(CGF, 
                      src, dst, 
                      false);
  }
  @Override public void EmitObjCGlobalAssign(final CodeGenFunction /*&*/ CGF, 
                      Value /*P*/ src, Address dst, 
                      boolean threadlocal/*= false*/)/* override*/ {
    org.llvm.ir.Type /*P*/ SrcTy = src.getType();
    if (!isa_PointerType(SrcTy)) {
      /*uint*/int Size = $ulong2uint(CGM.getDataLayout().getTypeAllocSize(SrcTy));
      assert ($lesseq_uint(Size, 8)) : "does not support size > 8";
      src = (Size == 4 ? CGF.Builder.CreateBitCast(src, ObjCTypes.IntTy) : CGF.Builder.CreateBitCast(src, ObjCTypes.LongTy));
      src = CGF.Builder.CreateIntToPtr(src, ObjCTypes.Int8PtrTy);
    }
    src = CGF.Builder.CreateBitCast(src, ObjCTypes.ObjectPtrTy);
    dst.$assignMove(CGF.Builder.CreateBitCast(new Address(dst), ObjCTypes.PtrObjectPtrTy));
    Value /*P*/ args[/*2*/] = new Value /*P*/  [/*2*/] {src, dst.getPointer()};
    if (!threadlocal) {
      CGF.EmitNounwindRuntimeCall(ObjCTypes.getGcAssignGlobalFn(), 
          new ArrayRef<Value /*P*/ >(args, true), new Twine(/*KEEP_STR*/"globalassign"));
    } else {
      CGF.EmitNounwindRuntimeCall(ObjCTypes.getGcAssignThreadLocalFn(), 
          new ArrayRef<Value /*P*/ >(args, true), new Twine(/*KEEP_STR*/"threadlocalassign"));
    }
  }

  
  /// EmitObjCIvarAssign - Code gen for assigning to a __strong object.
  /// objc_assign_ivar (id src, id *dst, ptrdiff_t)
  ///
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCNonFragileABIMac::EmitObjCIvarAssign">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 7120,
   FQN="(anonymous namespace)::CGObjCNonFragileABIMac::EmitObjCIvarAssign", NM="_ZN12_GLOBAL__N_122CGObjCNonFragileABIMac18EmitObjCIvarAssignERN5clang7CodeGen15CodeGenFunctionEPN4llvm5ValueENS2_7AddressES7_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_122CGObjCNonFragileABIMac18EmitObjCIvarAssignERN5clang7CodeGen15CodeGenFunctionEPN4llvm5ValueENS2_7AddressES7_")
  //</editor-fold>
  @Override public void EmitObjCIvarAssign(final CodeGenFunction /*&*/ CGF, 
                    Value /*P*/ src, 
                    Address dst, 
                    Value /*P*/ ivarOffset)/* override*/ {
    org.llvm.ir.Type /*P*/ SrcTy = src.getType();
    if (!isa_PointerType(SrcTy)) {
      /*uint*/int Size = $ulong2uint(CGM.getDataLayout().getTypeAllocSize(SrcTy));
      assert ($lesseq_uint(Size, 8)) : "does not support size > 8";
      src = (Size == 4 ? CGF.Builder.CreateBitCast(src, ObjCTypes.IntTy) : CGF.Builder.CreateBitCast(src, ObjCTypes.LongTy));
      src = CGF.Builder.CreateIntToPtr(src, ObjCTypes.Int8PtrTy);
    }
    src = CGF.Builder.CreateBitCast(src, ObjCTypes.ObjectPtrTy);
    dst.$assignMove(CGF.Builder.CreateBitCast(new Address(dst), ObjCTypes.PtrObjectPtrTy));
    Value /*P*/ args[/*3*/] = new Value /*P*/  [/*3*/] {src, dst.getPointer(), ivarOffset};
    CGF.EmitNounwindRuntimeCall(ObjCTypes.getGcAssignIvarFn(), new ArrayRef<Value /*P*/ >(args, true));
  }

  
  /// EmitObjCStrongCastAssign - Code gen for assigning to a __strong cast object.
  /// objc_assign_strongCast (id src, id *dst)
  ///
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCNonFragileABIMac::EmitObjCStrongCastAssign">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 7141,
   FQN="(anonymous namespace)::CGObjCNonFragileABIMac::EmitObjCStrongCastAssign", NM="_ZN12_GLOBAL__N_122CGObjCNonFragileABIMac24EmitObjCStrongCastAssignERN5clang7CodeGen15CodeGenFunctionEPN4llvm5ValueENS2_7AddressE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_122CGObjCNonFragileABIMac24EmitObjCStrongCastAssignERN5clang7CodeGen15CodeGenFunctionEPN4llvm5ValueENS2_7AddressE")
  //</editor-fold>
  @Override public void EmitObjCStrongCastAssign(final CodeGenFunction /*&*/ CGF, 
                          Value /*P*/ src, Address dst)/* override*/ {
    org.llvm.ir.Type /*P*/ SrcTy = src.getType();
    if (!isa_PointerType(SrcTy)) {
      /*uint*/int Size = $ulong2uint(CGM.getDataLayout().getTypeAllocSize(SrcTy));
      assert ($lesseq_uint(Size, 8)) : "does not support size > 8";
      src = (Size == 4 ? CGF.Builder.CreateBitCast(src, ObjCTypes.IntTy) : CGF.Builder.CreateBitCast(src, ObjCTypes.LongTy));
      src = CGF.Builder.CreateIntToPtr(src, ObjCTypes.Int8PtrTy);
    }
    src = CGF.Builder.CreateBitCast(src, ObjCTypes.ObjectPtrTy);
    dst.$assignMove(CGF.Builder.CreateBitCast(new Address(dst), ObjCTypes.PtrObjectPtrTy));
    Value /*P*/ args[/*2*/] = new Value /*P*/  [/*2*/] {src, dst.getPointer()};
    CGF.EmitNounwindRuntimeCall(ObjCTypes.getGcAssignStrongCastFn(), 
        new ArrayRef<Value /*P*/ >(args, true), new Twine(/*KEEP_STR*/"weakassign"));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCNonFragileABIMac::EmitGCMemmoveCollectable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 7159,
   FQN="(anonymous namespace)::CGObjCNonFragileABIMac::EmitGCMemmoveCollectable", NM="_ZN12_GLOBAL__N_122CGObjCNonFragileABIMac24EmitGCMemmoveCollectableERN5clang7CodeGen15CodeGenFunctionENS2_7AddressES5_PN4llvm5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_122CGObjCNonFragileABIMac24EmitGCMemmoveCollectableERN5clang7CodeGen15CodeGenFunctionENS2_7AddressES5_PN4llvm5ValueE")
  //</editor-fold>
  @Override public void EmitGCMemmoveCollectable(final CodeGenFunction /*&*/ CGF, 
                          Address DestPtr, 
                          Address SrcPtr, 
                          Value /*P*/ Size)/* override*/ {
    SrcPtr.$assignMove(CGF.Builder.CreateBitCast(new Address(SrcPtr), ObjCTypes.Int8PtrTy));
    DestPtr.$assignMove(CGF.Builder.CreateBitCast(new Address(DestPtr), ObjCTypes.Int8PtrTy));
    Value /*P*/ args[/*3*/] = new Value /*P*/  [/*3*/] {DestPtr.getPointer(), SrcPtr.getPointer(), Size};
    CGF.EmitNounwindRuntimeCall(ObjCTypes.GcMemmoveCollectableFn(), new ArrayRef<Value /*P*/ >(args, true));
  }

  
  /// EmitObjCValueForIvar - Code Gen for nonfragile ivar reference.
  /// This code gen. amounts to generating code for:
  /// @code
  /// (type *)((char *)base + _OBJC_IVAR_$_.ivar;
  /// @encode
  ///
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCNonFragileABIMac::EmitObjCValueForIvar">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 6731,
   FQN="(anonymous namespace)::CGObjCNonFragileABIMac::EmitObjCValueForIvar", NM="_ZN12_GLOBAL__N_122CGObjCNonFragileABIMac20EmitObjCValueForIvarERN5clang7CodeGen15CodeGenFunctionENS1_8QualTypeEPN4llvm5ValueEPKNS1_12ObjCIvarDeclEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_122CGObjCNonFragileABIMac20EmitObjCValueForIvarERN5clang7CodeGen15CodeGenFunctionENS1_8QualTypeEPN4llvm5ValueEPKNS1_12ObjCIvarDeclEj")
  //</editor-fold>
  @Override public LValue EmitObjCValueForIvar(final CodeGenFunction /*&*/ CGF, 
                      QualType ObjectTy, 
                      Value /*P*/ BaseValue, 
                      /*const*/ ObjCIvarDecl /*P*/ Ivar, 
                      /*uint*/int CVRQualifiers)/* override*/ {
    ObjCInterfaceDecl /*P*/ ID = ObjectTy.$arrow().getAs(ObjCObjectType.class).getInterface();
    Value /*P*/ Offset = EmitIvarOffset(CGF, ID, Ivar);
    return EmitValueForIvarAtOffset(CGF, ID, BaseValue, Ivar, CVRQualifiers, 
        Offset);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCNonFragileABIMac::EmitIvarOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 6743,
   FQN="(anonymous namespace)::CGObjCNonFragileABIMac::EmitIvarOffset", NM="_ZN12_GLOBAL__N_122CGObjCNonFragileABIMac14EmitIvarOffsetERN5clang7CodeGen15CodeGenFunctionEPKNS1_17ObjCInterfaceDeclEPKNS1_12ObjCIvarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_122CGObjCNonFragileABIMac14EmitIvarOffsetERN5clang7CodeGen15CodeGenFunctionEPKNS1_17ObjCInterfaceDeclEPKNS1_12ObjCIvarDeclE")
  //</editor-fold>
  @Override public Value /*P*/ EmitIvarOffset(final CodeGenFunction /*&*/ CGF, 
                /*const*/ ObjCInterfaceDecl /*P*/ Interface, 
                /*const*/ ObjCIvarDecl /*P*/ Ivar)/* override*/ {
    Value /*P*/ IvarOffsetValue = ObjCIvarOffsetVariable(Interface, Ivar);
    IvarOffsetValue = CGF.Builder.CreateAlignedLoad(IvarOffsetValue, 
        CGF.getSizeAlign(), $("ivar"));
    if (IsIvarOffsetKnownIdempotent(CGF, Ivar)) {
      cast_LoadInst(IvarOffsetValue).
          setMetadata(CGM.getModule().getMDKindID(new StringRef(/*KEEP_STR*/"invariant.load")), 
          MDNode.get(VMContext, new ArrayRef<Metadata /*P*/ >(None, true)));
    }
    
    // This could be 32bit int or 64bit integer depending on the architecture.
    // Cast it to 64bit integer value, if it is a 32bit integer ivar offset value
    //  as this is what caller always expectes.
    if (ObjCTypes.IvarOffsetVarTy == ObjCTypes.IntTy) {
      IvarOffsetValue = CGF.Builder.CreateIntCast(IvarOffsetValue, ObjCTypes.LongTy, true, new Twine(/*KEEP_STR*/"ivar.conv"));
    }
    return IvarOffsetValue;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCNonFragileABIMac::~CGObjCNonFragileABIMac">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 1274,
   FQN="(anonymous namespace)::CGObjCNonFragileABIMac::~CGObjCNonFragileABIMac", NM="_ZN12_GLOBAL__N_122CGObjCNonFragileABIMacD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_122CGObjCNonFragileABIMacD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    DefinedMetaClasses.$destroy();
    VTableDispatchMethods.$destroy();
    EHTypeReferences.$destroy();
    MetaClassReferences.$destroy();
    SuperClassReferences.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "ObjCTypes=" + ObjCTypes // NOI18N
              + ", ObjCEmptyCacheVar=" + ObjCEmptyCacheVar // NOI18N
              + ", ObjCEmptyVtableVar=" + ObjCEmptyVtableVar // NOI18N
              + ", SuperClassReferences=" + SuperClassReferences // NOI18N
              + ", MetaClassReferences=" + MetaClassReferences // NOI18N
              + ", EHTypeReferences=" + EHTypeReferences // NOI18N
              + ", VTableDispatchMethods=" + VTableDispatchMethods // NOI18N
              + ", DefinedMetaClasses=" + DefinedMetaClasses // NOI18N
              + super.toString(); // NOI18N
  }
}
