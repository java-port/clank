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
import static org.clang.ast.java.AstStatementsRTTI.*;
import static org.llvm.ir.java.IrRTTI.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCMac">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 1072,
 FQN="(anonymous namespace)::CGObjCMac", NM="_ZN12_GLOBAL__N_19CGObjCMacE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_19CGObjCMacE")
//</editor-fold>
public class CGObjCMac extends /*public*/ CGObjCCommonMac implements Destructors.ClassWithDestructor {
/*private:*/
  private ObjCTypesHelper ObjCTypes;
  
  /// EmitModuleInfo - Another marker encoding module level
  /// information.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCMac::EmitModuleInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 4590,
   FQN="(anonymous namespace)::CGObjCMac::EmitModuleInfo", NM="_ZN12_GLOBAL__N_19CGObjCMac14EmitModuleInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_19CGObjCMac14EmitModuleInfoEv")
  //</editor-fold>
  private void EmitModuleInfo() {
    long/*uint64_t*/ Size = CGM.getDataLayout().getTypeAllocSize(ObjCTypes.ModuleTy);
    
    Constant /*P*/ Values[/*4*/] = new Constant /*P*/  [/*4*/] {
      ConstantInt.get(ObjCTypes.LongTy, $int2ulong(CGObjCMacStatics.ModuleVersion)), 
      ConstantInt.get(ObjCTypes.LongTy, Size), 
      // This used to be the filename, now it is unused. <rdr://4327263>
      GetClassName(new StringRef(/*KEEP_STR*/$EMPTY)), 
      EmitModuleSymbols()
    };
    CreateMetadataVar(new Twine(/*KEEP_STR*/"OBJC_MODULES"), 
        ConstantStruct.get(ObjCTypes.ModuleTy, new ArrayRef<Constant /*P*/ >(Values, true)), 
        new StringRef(/*KEEP_STR*/"__OBJC,__module_info,regular,no_dead_strip"), 
        CGM.getPointerAlign(), true);
  }

  
  /// EmitModuleSymols - Emit module symbols, the list of defined
  /// classes and categories. The result has type SymtabPtrTy.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCMac::EmitModuleSymbols">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 4606,
   FQN="(anonymous namespace)::CGObjCMac::EmitModuleSymbols", NM="_ZN12_GLOBAL__N_19CGObjCMac17EmitModuleSymbolsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_19CGObjCMac17EmitModuleSymbolsEv")
  //</editor-fold>
  private Constant /*P*/ EmitModuleSymbols() {
    /*uint*/int NumClasses = DefinedClasses.size();
    /*uint*/int NumCategories = DefinedCategories.size();
    
    // Return null if no symbols were defined.
    if (!(NumClasses != 0) && !(NumCategories != 0)) {
      return Constant.getNullValue(ObjCTypes.SymtabPtrTy);
    }
    
    Constant /*P*/ Values[/*5*/] = new Constant /*P*/  [5];
    Values[0] = ConstantInt.get(ObjCTypes.LongTy, $int2ulong(0));
    Values[1] = Constant.getNullValue(ObjCTypes.SelectorPtrTy);
    Values[2] = ConstantInt.get(ObjCTypes.ShortTy, $uint2ulong(NumClasses));
    Values[3] = ConstantInt.get(ObjCTypes.ShortTy, $uint2ulong(NumCategories));
    
    // The runtime expects exactly the list of defined classes followed
    // by the list of defined categories, in a single array.
    SmallVector<Constant /*P*/ > Symbols/*J*/= new SmallVector<Constant /*P*/ >(JD$UInt_T$C$R.INSTANCE, 8, NumClasses + NumCategories, (Constant /*P*/ )null);
    for (/*uint*/int i = 0; $less_uint(i, NumClasses); i++) {
      /*const*/ ObjCInterfaceDecl /*P*/ ID = ImplementedClasses.$at(i);
      assert Native.$bool(ID);
      {
        ObjCImplementationDecl /*P*/ IMP = ID.getImplementation();
        if ((IMP != null)) {
          // We are implementing a weak imported interface. Give it external linkage
          if (ID.isWeakImported() && !IMP.isWeakImported()) {
            DefinedClasses.$at(i).setLinkage(GlobalVariable.LinkageTypes.ExternalLinkage);
          }
        }
      }
      
      Symbols.$set(i, ConstantExpr.getBitCast(DefinedClasses.$at(i), 
          ObjCTypes.Int8PtrTy));
    }
    for (/*uint*/int i = 0; $less_uint(i, NumCategories); i++)  {
      Symbols.$set(NumClasses + i, 
        ConstantExpr.getBitCast(DefinedCategories.$at(i), 
          ObjCTypes.Int8PtrTy));
    }
    
    Values[4]
       = ConstantArray.get(org.llvm.ir.ArrayType.get(ObjCTypes.Int8PtrTy, 
            $uint2ulong(Symbols.size())), 
        new ArrayRef<Constant /*P*/ >(Symbols, true));
    
    Constant /*P*/ Init = ConstantStruct.getAnon(new ArrayRef<Constant /*P*/ >(Values, true));
    
    GlobalVariable /*P*/ GV = CreateMetadataVar(new Twine(/*KEEP_STR*/"OBJC_SYMBOLS"), Init, new StringRef(/*KEEP_STR*/"__OBJC,__symbols,regular,no_dead_strip"), 
        CGM.getPointerAlign(), true);
    return ConstantExpr.getBitCast(GV, ObjCTypes.SymtabPtrTy);
  }

  
  /// FinishModule - Write out global data structures at the end of
  /// processing a translation unit.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCMac::FinishModule">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 5155,
   FQN="(anonymous namespace)::CGObjCMac::FinishModule", NM="_ZN12_GLOBAL__N_19CGObjCMac12FinishModuleEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_19CGObjCMac12FinishModuleEv")
  //</editor-fold>
  private void FinishModule() {
    EmitModuleInfo();
    
    // Emit the dummy bodies for any protocols which were referenced but
    // never defined.
    for (DenseMapIterator<IdentifierInfo /*P*/ , GlobalVariable /*P*/ > I = Protocols.begin(), e = Protocols.end(); I.$noteq(/*NO_ITER_COPY*/e); I.$preInc()) {
      if (I.$arrow().second.hasInitializer()) {
        continue;
      }
      
      Constant /*P*/ Values[/*5*/] = new Constant /*P*/  [5];
      Values[0] = Constant.getNullValue(ObjCTypes.ProtocolExtensionPtrTy);
      Values[1] = GetClassName(I.$arrow().first.getName());
      Values[2] = Constant.getNullValue(ObjCTypes.ProtocolListPtrTy);
      Values[3] = Values[4]
         = Constant.getNullValue(ObjCTypes.MethodDescriptionListPtrTy);
      I.$arrow().second.setInitializer(ConstantStruct.get(ObjCTypes.ProtocolTy, 
              new ArrayRef<Constant /*P*/ >(Values, true)));
      CGM.addCompilerUsedGlobal(I.$arrow().second);
    }
    
    // Add assembler directives to add lazy undefined symbol references
    // for classes which are referenced but not defined. This is
    // important for correct linker interaction.
    //
    // FIXME: It would be nice if we had an LLVM construct for this.
    if (!LazySymbols.empty() || !DefinedSymbols.empty()) {
      raw_svector_ostream OS = null;
      try {
        SmallString/*<256>*/ Asm/*J*/= new SmallString/*<256>*/(256);
        Asm.$addassign(new StringRef(CGM.getModule().getModuleInlineAsm()));
        if (!Asm.empty() && Asm.back() != $$LF) {
          Asm.$addassign($$LF);
        }
        
        OS/*J*/= new raw_svector_ostream(Asm);
        for (std.vector.iterator</*const*/ IdentifierInfo /*P*/ > I = DefinedSymbols.begin(), 
            e = DefinedSymbols.end(); $noteq___normal_iterator$C(I, e); I.$preInc())  {
          OS.$out(/*KEEP_STR*/"\t.objc_class_name_").$out((I.$star()).getName()).$out(/*KEEP_STR*/"=0\n").$out(
              /*KEEP_STR*/"\t.globl .objc_class_name_"
          ).$out((I.$star()).getName()).$out(/*KEEP_STR*/$LF);
        }
        for (std.vector.iterator</*const*/ IdentifierInfo /*P*/ > I = LazySymbols.begin(), 
            e = LazySymbols.end(); $noteq___normal_iterator$C(I, e); I.$preInc()) {
          OS.$out(/*KEEP_STR*/"\t.lazy_reference .objc_class_name_").$out((I.$star()).getName()).$out(/*KEEP_STR*/$LF);
        }
        
        for (/*size_t*/int i = 0, e = DefinedCategoryNames.size(); $less_uint(i, e); ++i) {
          OS.$out(/*KEEP_STR*/"\t.objc_category_name_").$out(DefinedCategoryNames.$at(i)).$out(/*KEEP_STR*/"=0\n").$out(
              /*KEEP_STR*/"\t.globl .objc_category_name_"
          ).$out(DefinedCategoryNames.$at(i)).$out(/*KEEP_STR*/$LF);
        }
        
        CGM.getModule().setModuleInlineAsm(OS.str());
      } finally {
        if (OS != null) { OS.$destroy(); }
      }
    }
  }

  
  /// EmitClassExtension - Generate the class extension structure used
  /// to store the weak ivar layout and properties. The return value
  /// has type ClassExtensionPtrTy.
  
  /*
  Emit a "class extension", which in this specific context means extra
  data that doesn't fit in the normal fragile-ABI class structure, and
  has nothing to do with the language concept of a class extension.
  
  struct objc_class_ext {
  uint32_t size;
  const char *weak_ivar_layout;
  struct _objc_property_list *properties;
  };
  */
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCMac::EmitClassExtension">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 3471,
   FQN="(anonymous namespace)::CGObjCMac::EmitClassExtension", NM="_ZN12_GLOBAL__N_19CGObjCMac18EmitClassExtensionEPKN5clang22ObjCImplementationDeclENS1_9CharUnitsEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_19CGObjCMac18EmitClassExtensionEPKN5clang22ObjCImplementationDeclENS1_9CharUnitsEbb")
  //</editor-fold>
  private Constant /*P*/ EmitClassExtension(/*const*/ ObjCImplementationDecl /*P*/ ID, 
                    CharUnits InstanceSize, boolean hasMRCWeakIvars, 
                    boolean isClassProperty) {
    long/*uint64_t*/ Size = CGM.getDataLayout().getTypeAllocSize(ObjCTypes.ClassExtensionTy);
    
    Constant /*P*/ Values[/*3*/] = new Constant /*P*/  [3];
    Values[0] = ConstantInt.get(ObjCTypes.IntTy, Size);
    if (isClassProperty) {
      org.llvm.ir.Type /*P*/ PtrTy = CGM.Unnamed_field9.Int8PtrTy;
      Values[1] = Constant.getNullValue(PtrTy);
    } else {
      Values[1] = BuildWeakIvarLayout(ID, CharUnits.Zero(), new CharUnits(InstanceSize), 
          hasMRCWeakIvars);
    }
    if (isClassProperty) {
      Values[2] = EmitPropertyList($add_char$ptr$C_StringRef$C(/*KEEP_STR*/"\001l_OBJC_$_CLASS_PROP_LIST_", ID.getName()), 
          ID, ID.getClassInterface$Const(), ObjCTypes, true);
    } else {
      Values[2] = EmitPropertyList($add_char$ptr$C_StringRef$C(/*KEEP_STR*/"\001l_OBJC_$_PROP_LIST_", ID.getName()), 
          ID, ID.getClassInterface$Const(), ObjCTypes, false);
    }
    
    // Return null if no extension bits are used.
    if ((!(Values[1] != null) || Values[1].isNullValue()) && Values[2].isNullValue()) {
      return Constant.getNullValue(ObjCTypes.ClassExtensionPtrTy);
    }
    
    Constant /*P*/ Init = ConstantStruct.get(ObjCTypes.ClassExtensionTy, new ArrayRef<Constant /*P*/ >(Values, true));
    return CreateMetadataVar($add_char$ptr$C_StringRef$C(/*KEEP_STR*/"OBJC_CLASSEXT_", ID.getName()), Init, 
        new StringRef(/*KEEP_STR*/"__OBJC,__class_ext,regular,no_dead_strip"), 
        CGM.getPointerAlign(), true);
  }

  
  /// EmitClassRef - Return a Value*, of type ObjCTypes.ClassPtrTy,
  /// for the given class.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCMac::EmitClassRef">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 4671,
   FQN="(anonymous namespace)::CGObjCMac::EmitClassRef", NM="_ZN12_GLOBAL__N_19CGObjCMac12EmitClassRefERN5clang7CodeGen15CodeGenFunctionEPKNS1_17ObjCInterfaceDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_19CGObjCMac12EmitClassRefERN5clang7CodeGen15CodeGenFunctionEPKNS1_17ObjCInterfaceDeclE")
  //</editor-fold>
  private Value /*P*/ EmitClassRef(final CodeGenFunction /*&*/ CGF, 
              /*const*/ ObjCInterfaceDecl /*P*/ ID) {
    // If the class has the objc_runtime_visible attribute, we need to
    // use the Objective-C runtime to get the class.
    if (ID.hasAttr(ObjCRuntimeVisibleAttr.class)) {
      return EmitClassRefViaRuntime(CGF, ID, ObjCTypes);
    }
    
    return EmitClassRefFromId(CGF, ID.getIdentifier());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCMac::EmitClassRefFromId">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 4652,
   FQN="(anonymous namespace)::CGObjCMac::EmitClassRefFromId", NM="_ZN12_GLOBAL__N_19CGObjCMac18EmitClassRefFromIdERN5clang7CodeGen15CodeGenFunctionEPNS1_14IdentifierInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_19CGObjCMac18EmitClassRefFromIdERN5clang7CodeGen15CodeGenFunctionEPNS1_14IdentifierInfoE")
  //</editor-fold>
  private Value /*P*/ EmitClassRefFromId(final CodeGenFunction /*&*/ CGF, 
                    IdentifierInfo /*P*/ II) {
    LazySymbols.insert(II);
    
    final type$ref<GlobalVariable /*P*/ /*&*/> Entry = ClassReferences.ref$at(II);
    if (!(Entry.$deref() != null)) {
      Constant /*P*/ Casted = ConstantExpr.getBitCast(GetClassName(II.getName()), 
          ObjCTypes.ClassPtrTy);
      Entry.$set(CreateMetadataVar(new Twine(/*KEEP_STR*/"OBJC_CLASS_REFERENCES_"), Casted, 
          new StringRef(/*KEEP_STR*/"__OBJC,__cls_refs,literal_pointers,no_dead_strip"), 
          CGM.getPointerAlign(), true));
    }
    
    return CGF.Builder.CreateAlignedLoad(Entry.$deref(), CGF.getPointerAlign());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCMac::EmitNSAutoreleasePoolClassRef">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 4681,
   FQN="(anonymous namespace)::CGObjCMac::EmitNSAutoreleasePoolClassRef", NM="_ZN12_GLOBAL__N_19CGObjCMac29EmitNSAutoreleasePoolClassRefERN5clang7CodeGen15CodeGenFunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_19CGObjCMac29EmitNSAutoreleasePoolClassRefERN5clang7CodeGen15CodeGenFunctionE")
  //</editor-fold>
  @Override public/*private*/ Value /*P*/ EmitNSAutoreleasePoolClassRef(final CodeGenFunction /*&*/ CGF)/* override*/ {
    IdentifierInfo /*P*/ II = $AddrOf(CGM.getContext().Idents.get(new StringRef(/*KEEP_STR*/"NSAutoreleasePool")));
    return EmitClassRefFromId(CGF, II);
  }

  
  /// EmitSuperClassRef - Emits reference to class's main metadata class.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCMac::EmitSuperClassRef">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 3446,
   FQN="(anonymous namespace)::CGObjCMac::EmitSuperClassRef", NM="_ZN12_GLOBAL__N_19CGObjCMac17EmitSuperClassRefEPKN5clang17ObjCInterfaceDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_19CGObjCMac17EmitSuperClassRefEPKN5clang17ObjCInterfaceDeclE")
  //</editor-fold>
  private Value /*P*/ EmitSuperClassRef(/*const*/ ObjCInterfaceDecl /*P*/ ID) {
    std.string Name = $add_T$C$P_string(/*KEEP_STR*/"OBJC_CLASS_", ID.getNameAsString());
    GlobalVariable /*P*/ GV = CGM.getModule().getGlobalVariable(new StringRef(Name), true);
    if (!(GV != null)) {
      GV = /*NEW_EXPR [GlobalVariable::new]*/GlobalVariable.$new_GlobalVariable((type$ptr<?> New$Mem)->{
          return new GlobalVariable(CGM.getModule(), ObjCTypes.ClassTy, false, 
          GlobalValue.LinkageTypes.PrivateLinkage, (Constant /*P*/ )null, 
          new Twine(Name));
       });
    }
    assert (GV.getType().getElementType() == ObjCTypes.ClassTy) : "Forward class metadata reference has incorrect type.";
    return GV;
  }

  
  /// EmitIvarList - Emit the ivar list for the given
  /// implementation. If ForClass is true the list of class ivars
  /// (i.e. metaclass ivars) is emitted, otherwise the list of
  /// interface ivars will be emitted. The return value has type
  /// IvarListPtrTy.
  
  /*
  struct objc_ivar {
  char *ivar_name;
  char *ivar_type;
  int ivar_offset;
  };
  
  struct objc_ivar_list {
  int ivar_count;
  struct objc_ivar list[count];
  };
  */
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCMac::EmitIvarList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 3516,
   FQN="(anonymous namespace)::CGObjCMac::EmitIvarList", NM="_ZN12_GLOBAL__N_19CGObjCMac12EmitIvarListEPKN5clang22ObjCImplementationDeclEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_19CGObjCMac12EmitIvarListEPKN5clang22ObjCImplementationDeclEb")
  //</editor-fold>
  private Constant /*P*/ EmitIvarList(/*const*/ ObjCImplementationDecl /*P*/ ID, 
              boolean ForClass) {
    std.vector<Constant /*P*/ > Ivars = null;
    try {
      Ivars/*J*/= new std.vector<Constant /*P*/ >((Constant /*P*/ )null);
      
      // When emitting the root class GCC emits ivar entries for the
      // actual class structure. It is not clear if we need to follow this
      // behavior; for now lets try and get away with not doing it. If so,
      // the cleanest solution would be to make up an ObjCInterfaceDecl
      // for the class.
      if (ForClass) {
        return Constant.getNullValue(ObjCTypes.IvarListPtrTy);
      }
      
      /*const*/ ObjCInterfaceDecl /*P*/ OID = ID.getClassInterface$Const();
      
      for (/*const*/ ObjCIvarDecl /*P*/ IVD = OID.all_declared_ivar_begin$Const();
           (IVD != null); IVD = IVD.getNextIvar$Const()) {
        // Ignore unnamed bit-fields.
        if (!IVD.getDeclName().$bool()) {
          continue;
        }
        Constant /*P*/ Ivar[/*3*/] = new Constant /*P*/  [/*3*/] {
          GetMethodVarName(IVD.getIdentifier()), 
          GetMethodVarType(IVD), 
          ConstantInt.get(ObjCTypes.IntTy, 
              ComputeIvarBaseOffset_1(CGM, OID, IVD))
        };
        Ivars.push_back_T$RR(ConstantStruct.get(ObjCTypes.IvarTy, new ArrayRef<Constant /*P*/ >(Ivar, true)));
      }
      
      // Return null for empty list.
      if (Ivars.empty()) {
        return Constant.getNullValue(ObjCTypes.IvarListPtrTy);
      }
      
      Constant /*P*/ Values[/*2*/] = new Constant /*P*/  [2];
      Values[0] = ConstantInt.get(ObjCTypes.IntTy, $uint2ulong(Ivars.size()));
      org.llvm.ir.ArrayType /*P*/ AT = org.llvm.ir.ArrayType.get(ObjCTypes.IvarTy, 
          $uint2ulong(Ivars.size()));
      Values[1] = ConstantArray.get(AT, new ArrayRef<Constant /*P*/ >(Ivars, true));
      Constant /*P*/ Init = ConstantStruct.getAnon(new ArrayRef<Constant /*P*/ >(Values, true));
      
      GlobalVariable /*P*/ GV;
      if (ForClass) {
        GV
           = CreateMetadataVar($add_char$ptr$C_StringRef$C(/*KEEP_STR*/"OBJC_CLASS_VARIABLES_", ID.getName()), Init, 
            new StringRef(/*KEEP_STR*/"__OBJC,__class_vars,regular,no_dead_strip"), 
            CGM.getPointerAlign(), true);
      } else {
        GV = CreateMetadataVar($add_char$ptr$C_StringRef$C(/*KEEP_STR*/"OBJC_INSTANCE_VARIABLES_", ID.getName()), Init, 
            new StringRef(/*KEEP_STR*/"__OBJC,__instance_vars,regular,no_dead_strip"), 
            CGM.getPointerAlign(), true);
      }
      return ConstantExpr.getBitCast(GV, ObjCTypes.IvarListPtrTy);
    } finally {
      if (Ivars != null) { Ivars.$destroy(); }
    }
  }

  
  /// EmitMetaClass - Emit a forward reference to the class structure
  /// for the metaclass of the given interface. The return value has
  /// type ClassPtrTy.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCMac::EmitMetaClassRef">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 3424,
   FQN="(anonymous namespace)::CGObjCMac::EmitMetaClassRef", NM="_ZN12_GLOBAL__N_19CGObjCMac16EmitMetaClassRefEPKN5clang17ObjCInterfaceDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_19CGObjCMac16EmitMetaClassRefEPKN5clang17ObjCInterfaceDeclE")
  //</editor-fold>
  private Constant /*P*/ EmitMetaClassRef(/*const*/ ObjCInterfaceDecl /*P*/ ID) {
    std.string Name = $add_T$C$P_string(/*KEEP_STR*/"OBJC_METACLASS_", ID.getNameAsString());
    
    // FIXME: Should we look these up somewhere other than the module. Its a bit
    // silly since we only generate these while processing an implementation, so
    // exactly one pointer would work if know when we entered/exitted an
    // implementation block.
    
    // Check for an existing forward reference.
    // Previously, metaclass with internal linkage may have been defined.
    // pass 'true' as 2nd argument so it is returned.
    GlobalVariable /*P*/ GV = CGM.getModule().getGlobalVariable(new StringRef(Name), true);
    if (!(GV != null)) {
      GV = /*NEW_EXPR [GlobalVariable::new]*/GlobalVariable.$new_GlobalVariable((type$ptr<?> New$Mem)->{
          return new GlobalVariable(CGM.getModule(), ObjCTypes.ClassTy, false, 
          GlobalValue.LinkageTypes.PrivateLinkage, (Constant /*P*/ )null, 
          new Twine(Name));
       });
    }
    assert (GV.getType().getElementType() == ObjCTypes.ClassTy) : "Forward metaclass reference has incorrect type.";
    return GV;
  }

  
  /// EmitMetaClass - Emit a class structure for the metaclass of the
  /// given implementation. The return value has type ClassPtrTy.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCMac::EmitMetaClass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 3356,
   FQN="(anonymous namespace)::CGObjCMac::EmitMetaClass", NM="_ZN12_GLOBAL__N_19CGObjCMac13EmitMetaClassEPKN5clang22ObjCImplementationDeclEPN4llvm8ConstantENS5_8ArrayRefIS7_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_19CGObjCMac13EmitMetaClassEPKN5clang22ObjCImplementationDeclEPN4llvm8ConstantENS5_8ArrayRefIS7_EE")
  //</editor-fold>
  private Constant /*P*/ EmitMetaClass(/*const*/ ObjCImplementationDecl /*P*/ ID, 
               Constant /*P*/ Protocols, 
               ArrayRef<Constant /*P*/ > Methods) {
    /*uint*/int Flags = FragileClassFlags.FragileABI_Class_Meta;
    /*uint*/int Size = $ulong2uint(CGM.getDataLayout().getTypeAllocSize(ObjCTypes.ClassTy));
    if (ID.getClassInterface$Const().getVisibility() == Visibility.HiddenVisibility) {
      Flags |= FragileClassFlags.FragileABI_Class_Hidden;
    }
    
    Constant /*P*/ Values[/*12*/] = new Constant /*P*/  [12];
    // The isa for the metaclass is the root of the hierarchy.
    /*const*/ ObjCInterfaceDecl /*P*/ Root = ID.getClassInterface$Const();
    {
      /*const*/ ObjCInterfaceDecl /*P*/ Super;
      while (((/*P*/ Super = Root.getSuperClass()) != null)) {
        Root = Super;
      }
    }
    Values[0]
       = ConstantExpr.getBitCast(GetClassName(Root.getObjCRuntimeNameAsString()), 
        ObjCTypes.ClassPtrTy);
    {
      // The super class for the metaclass is emitted as the name of the
      // super class. The runtime fixes this up to point to the
      // *metaclass* for the super class.
      ObjCInterfaceDecl /*P*/ Super$1 = ID.getClassInterface$Const().getSuperClass();
      if ((Super$1 != null)) {
        Values[1]
           = ConstantExpr.getBitCast(GetClassName(Super$1.getObjCRuntimeNameAsString()), 
            ObjCTypes.ClassPtrTy);
      } else {
        Values[1] = Constant.getNullValue(ObjCTypes.ClassPtrTy);
      }
    }
    Values[2] = GetClassName(ID.getObjCRuntimeNameAsString());
    // Version is always 0.
    Values[3] = ConstantInt.get(ObjCTypes.LongTy, $int2ulong(0));
    Values[4] = ConstantInt.get(ObjCTypes.LongTy, $uint2ulong(Flags));
    Values[5] = ConstantInt.get(ObjCTypes.LongTy, $uint2ulong(Size));
    Values[6] = EmitIvarList(ID, true);
    Values[7]
       = EmitMethodList(new Twine($add_T$C$P_string(/*KEEP_STR*/"OBJC_CLASS_METHODS_", ID.getNameAsString())), 
        new StringRef(/*KEEP_STR*/"__OBJC,__cls_meth,regular,no_dead_strip"), new ArrayRef<Constant /*P*/ >(Methods));
    // cache is always NULL.
    Values[8] = Constant.getNullValue(ObjCTypes.CachePtrTy);
    Values[9] = Protocols;
    // ivar_layout for metaclass is always NULL.
    Values[10] = Constant.getNullValue(ObjCTypes.Int8PtrTy);
    // The class extension is used to store class properties for metaclasses.
    Values[11] = EmitClassExtension(ID, CharUnits.Zero(), false/*hasMRCWeak*/, 
        true/*isClassProperty*/);
    Constant /*P*/ Init = ConstantStruct.get(ObjCTypes.ClassTy, 
        new ArrayRef<Constant /*P*/ >(Values, true));
    
    std.string Name/*J*/= new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"OBJC_METACLASS_");
    $addassign_string_StringRef(Name, ID.getName());
    
    // Check for a forward reference.
    GlobalVariable /*P*/ GV = CGM.getModule().getGlobalVariable(new StringRef(Name), true);
    if ((GV != null)) {
      assert (GV.getType().getElementType() == ObjCTypes.ClassTy) : "Forward metaclass reference has incorrect type.";
      GV.setInitializer(Init);
    } else {
      GV = /*NEW_EXPR [GlobalVariable::new]*/GlobalVariable.$new_GlobalVariable((type$ptr<?> New$Mem)->{
          return new GlobalVariable(CGM.getModule(), ObjCTypes.ClassTy, false, 
          GlobalValue.LinkageTypes.PrivateLinkage, 
          Init, new Twine(Name));
       });
    }
    GV.setSection(new StringRef(/*KEEP_STR*/"__OBJC,__meta_class,regular,no_dead_strip"));
    GV.setAlignment(4);
    CGM.addCompilerUsedGlobal(GV);
    
    return GV;
  }

  
  
  /*
  struct objc_method {
  SEL method_name;
  char *method_types;
  void *method;
  };
  
  struct objc_method_list {
  struct objc_method_list *obsolete;
  int count;
  struct objc_method methods_list[count];
  };
  */
  
  /// GetMethodConstant - Return a struct objc_method constant for the
  /// given method if it has been defined. The result is null if the
  /// method has not been defined. The return value has type MethodPtrTy.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCMac::GetMethodConstant">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 3585,
   FQN="(anonymous namespace)::CGObjCMac::GetMethodConstant", NM="_ZN12_GLOBAL__N_19CGObjCMac17GetMethodConstantEPKN5clang14ObjCMethodDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_19CGObjCMac17GetMethodConstantEPKN5clang14ObjCMethodDeclE")
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

  
  
  /*
  struct objc_method_description_list {
  int count;
  struct objc_method_description list[];
  };
  */
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCMac::GetMethodDescriptionConstant">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 3040,
   FQN="(anonymous namespace)::CGObjCMac::GetMethodDescriptionConstant", NM="_ZN12_GLOBAL__N_19CGObjCMac28GetMethodDescriptionConstantEPKN5clang14ObjCMethodDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_19CGObjCMac28GetMethodDescriptionConstantEPKN5clang14ObjCMethodDeclE")
  //</editor-fold>
  private Constant /*P*/ GetMethodDescriptionConstant(/*const*/ ObjCMethodDecl /*P*/ MD) {
    Constant /*P*/ Desc[/*2*/] = new Constant /*P*/  [/*2*/] {
      ConstantExpr.getBitCast(GetMethodVarName(MD.getSelector()), 
          ObjCTypes.SelectorPtrTy), 
      GetMethodVarType(MD)
    };
    if (!(Desc[1] != null)) {
      return null;
    }
    
    return ConstantStruct.get(ObjCTypes.MethodDescriptionTy, 
        new ArrayRef<Constant /*P*/ >(Desc, true));
  }

  
  /// EmitMethodList - Emit the method list for the given
  /// implementation. The return value has type MethodListPtrTy.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCMac::EmitMethodList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 3599,
   FQN="(anonymous namespace)::CGObjCMac::EmitMethodList", NM="_ZN12_GLOBAL__N_19CGObjCMac14EmitMethodListEN4llvm5TwineENS1_9StringRefENS1_8ArrayRefIPNS1_8ConstantEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_19CGObjCMac14EmitMethodListEN4llvm5TwineENS1_9StringRefENS1_8ArrayRefIPNS1_8ConstantEEE")
  //</editor-fold>
  private Constant /*P*/ EmitMethodList(Twine Name, StringRef Section, 
                ArrayRef<Constant /*P*/ > Methods) {
    // Return null for empty list.
    if (Methods.empty()) {
      return Constant.getNullValue(ObjCTypes.MethodListPtrTy);
    }
    
    Constant /*P*/ Values[/*3*/] = new Constant /*P*/  [3];
    Values[0] = Constant.getNullValue(ObjCTypes.Int8PtrTy);
    Values[1] = ConstantInt.get(ObjCTypes.IntTy, $uint2ulong(Methods.size()));
    org.llvm.ir.ArrayType /*P*/ AT = org.llvm.ir.ArrayType.get(ObjCTypes.MethodTy, 
        $uint2ulong(Methods.size()));
    Values[2] = ConstantArray.get(AT, new ArrayRef<Constant /*P*/ >(Methods));
    Constant /*P*/ Init = ConstantStruct.getAnon(new ArrayRef<Constant /*P*/ >(Values, true));
    
    GlobalVariable /*P*/ GV = CreateMetadataVar(new Twine(Name), Init, new StringRef(Section), CGM.getPointerAlign(), true);
    return ConstantExpr.getBitCast(GV, ObjCTypes.MethodListPtrTy);
  }

  
  /// EmitMethodDescList - Emit a method description list for a list of
  /// method declarations.
  ///  - TypeName: The name for the type containing the methods.
  ///  - IsProtocol: True iff these methods are for a protocol.
  ///  - ClassMethds: True iff these are class methods.
  ///  - Required: When true, only "required" methods are
  ///    listed. Similarly, when false only "optional" methods are
  ///    listed. For classes this should always be true.
  ///  - begin, end: The method list to output.
  ///
  /// The return value has type MethodDescriptionListPtrTy.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCMac::EmitMethodDescList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 3054,
   FQN="(anonymous namespace)::CGObjCMac::EmitMethodDescList", NM="_ZN12_GLOBAL__N_19CGObjCMac18EmitMethodDescListEN4llvm5TwineENS1_9StringRefENS1_8ArrayRefIPNS1_8ConstantEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_19CGObjCMac18EmitMethodDescListEN4llvm5TwineENS1_9StringRefENS1_8ArrayRefIPNS1_8ConstantEEE")
  //</editor-fold>
  private Constant /*P*/ EmitMethodDescList(Twine Name, StringRef Section, 
                    ArrayRef<Constant /*P*/ > Methods) {
    // Return null for empty list.
    if (Methods.empty()) {
      return Constant.getNullValue(ObjCTypes.MethodDescriptionListPtrTy);
    }
    
    Constant /*P*/ Values[/*2*/] = new Constant /*P*/  [2];
    Values[0] = ConstantInt.get(ObjCTypes.IntTy, $uint2ulong(Methods.size()));
    org.llvm.ir.ArrayType /*P*/ AT = org.llvm.ir.ArrayType.get(ObjCTypes.MethodDescriptionTy, 
        $uint2ulong(Methods.size()));
    Values[1] = ConstantArray.get(AT, new ArrayRef<Constant /*P*/ >(Methods));
    Constant /*P*/ Init = ConstantStruct.getAnon(new ArrayRef<Constant /*P*/ >(Values, true));
    
    GlobalVariable /*P*/ GV = CreateMetadataVar(new Twine(Name), Init, new StringRef(Section), CGM.getPointerAlign(), true);
    return ConstantExpr.getBitCast(GV, 
        ObjCTypes.MethodDescriptionListPtrTy);
  }

  
  /// GetOrEmitProtocol - Get the protocol object for the given
  /// declaration, emitting it if necessary. The return value has type
  /// ProtocolPtrTy.
  
  /*
  // Objective-C 1.0 extensions
  struct _objc_protocol {
  struct _objc_protocol_extension *isa;
  char *protocol_name;
  struct _objc_protocol_list *protocol_list;
  struct _objc__method_prototype_list *instance_methods;
  struct _objc__method_prototype_list *class_methods
  };
  
  See EmitProtocolExtension().
  */
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCMac::GetOrEmitProtocol">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 2717,
   FQN="(anonymous namespace)::CGObjCMac::GetOrEmitProtocol", NM="_ZN12_GLOBAL__N_19CGObjCMac17GetOrEmitProtocolEPKN5clang16ObjCProtocolDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_19CGObjCMac17GetOrEmitProtocolEPKN5clang16ObjCProtocolDeclE")
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
      
      // FIXME: I don't understand why gcc generates this, or where it is
      // resolved. Investigate. Its also wasteful to look this up over and over.
      LazySymbols.insert($AddrOf(CGM.getContext().Idents.get(new StringRef(/*KEEP_STR*/"Protocol"))));
      
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
      
      Constant /*P*/ Values[/*5*/] = new Constant /*P*/  [/*5*/] {
        EmitProtocolExtension(PD, new ArrayRef<Constant /*P*/ >(OptInstanceMethods, true), new ArrayRef<Constant /*P*/ >(OptClassMethods, true), 
            new ArrayRef<Constant /*P*/ >(MethodTypesExt, true)), 
        GetClassName(PD.getObjCRuntimeNameAsString()), 
        EmitProtocolList($add_char$ptr$C_StringRef$C(/*KEEP_STR*/"OBJC_PROTOCOL_REFS_", PD.getName()), 
            PD.protocol_begin(), PD.protocol_end()), 
        EmitMethodDescList($add_char$ptr$C_StringRef$C(/*KEEP_STR*/"OBJC_PROTOCOL_INSTANCE_METHODS_", PD.getName()), 
            new StringRef(/*KEEP_STR*/"__OBJC,__cat_inst_meth,regular,no_dead_strip"), 
            new ArrayRef<Constant /*P*/ >(InstanceMethods, true)), 
        EmitMethodDescList($add_char$ptr$C_StringRef$C(/*KEEP_STR*/"OBJC_PROTOCOL_CLASS_METHODS_", PD.getName()), 
            new StringRef(/*KEEP_STR*/"__OBJC,__cat_cls_meth,regular,no_dead_strip"), 
            new ArrayRef<Constant /*P*/ >(ClassMethods, true))
      };
      Constant /*P*/ Init = ConstantStruct.get(ObjCTypes.ProtocolTy, 
          new ArrayRef<Constant /*P*/ >(Values, true));
      if ((Entry != null)) {
        // Already created, update the initializer.
        assert (Entry.hasPrivateLinkage());
        Entry.setInitializer(Init);
      } else {
        /*const*/ ObjCProtocolDecl /*P*/ PD_final = PD;
        Entry = /*NEW_EXPR [GlobalVariable::new]*/GlobalVariable.$new_GlobalVariable((type$ptr<?> New$Mem)->{
            return new GlobalVariable(CGM.getModule(), ObjCTypes.ProtocolTy, 
            false, GlobalValue.LinkageTypes.PrivateLinkage, 
            Init, $add_char$ptr$C_StringRef$C(/*KEEP_STR*/"OBJC_PROTOCOL_", PD_final.getName()));
         });
        Entry.setSection(new StringRef(/*KEEP_STR*/"__OBJC,__protocol,regular,no_dead_strip"));
        // FIXME: Is this necessary? Why only for protocol?
        Entry.setAlignment(4);
        
        Protocols.$set(PD.getIdentifier(), Entry);
      }
      CGM.addCompilerUsedGlobal(Entry);
      
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
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCMac::GetOrEmitProtocolRef">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 2801,
   FQN="(anonymous namespace)::CGObjCMac::GetOrEmitProtocolRef", NM="_ZN12_GLOBAL__N_19CGObjCMac20GetOrEmitProtocolRefEPKN5clang16ObjCProtocolDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_19CGObjCMac20GetOrEmitProtocolRefEPKN5clang16ObjCProtocolDeclE")
  //</editor-fold>
  @Override public/*private*/ Constant /*P*/ GetOrEmitProtocolRef(/*const*/ ObjCProtocolDecl /*P*/ PD)/* override*/ {
    final type$ref<GlobalVariable /*P*/ /*&*/> Entry = Protocols.ref$at(PD.getIdentifier());
    if (!(Entry.$deref() != null)) {
      // We use the initializer as a marker of whether this is a forward
      // reference or not. At module finalization we add the empty
      // contents for protocols which were referenced but never defined.
      Entry.$set(/*NEW_EXPR [GlobalVariable::new]*/GlobalVariable.$new_GlobalVariable((type$ptr<?> New$Mem)->{
          return new GlobalVariable(CGM.getModule(), ObjCTypes.ProtocolTy, 
          false, GlobalValue.LinkageTypes.PrivateLinkage, 
                  (Constant /*P*/ )null, $add_char$ptr$C_StringRef$C(/*KEEP_STR*/"OBJC_PROTOCOL_", PD.getName()));
       }));
      Entry.$deref().setSection(new StringRef(/*KEEP_STR*/"__OBJC,__protocol,regular,no_dead_strip"));
      // FIXME: Is this necessary? Why only for protocol?
      Entry.$deref().setAlignment(4);
    }
    
    return Entry.$deref();
  }

  
  /// EmitProtocolExtension - Generate the protocol extension
  /// structure used to store optional instance and class methods, and
  /// protocol properties. The return value has type
  /// ProtocolExtensionPtrTy.
  
  /*
  struct _objc_protocol_extension {
  uint32_t size;
  struct objc_method_description_list *optional_instance_methods;
  struct objc_method_description_list *optional_class_methods;
  struct objc_property_list *instance_properties;
  const char ** extendedMethodTypes;
  struct objc_property_list *class_properties;
  };
  */
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCMac::EmitProtocolExtension">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 2829,
   FQN="(anonymous namespace)::CGObjCMac::EmitProtocolExtension", NM="_ZN12_GLOBAL__N_19CGObjCMac21EmitProtocolExtensionEPKN5clang16ObjCProtocolDeclEN4llvm8ArrayRefIPNS5_8ConstantEEES9_S9_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_19CGObjCMac21EmitProtocolExtensionEPKN5clang16ObjCProtocolDeclEN4llvm8ArrayRefIPNS5_8ConstantEEES9_S9_")
  //</editor-fold>
  private Constant /*P*/ EmitProtocolExtension(/*const*/ ObjCProtocolDecl /*P*/ PD, 
                       ArrayRef<Constant /*P*/ > OptInstanceMethods, 
                       ArrayRef<Constant /*P*/ > OptClassMethods, 
                       ArrayRef<Constant /*P*/ > MethodTypesExt) {
    long/*uint64_t*/ Size = CGM.getDataLayout().getTypeAllocSize(ObjCTypes.ProtocolExtensionTy);
    Constant /*P*/ Values[/*6*/] = new Constant /*P*/  [/*6*/] {
      ConstantInt.get(ObjCTypes.IntTy, Size), 
      EmitMethodDescList($add_char$ptr$C_StringRef$C(/*KEEP_STR*/"OBJC_PROTOCOL_INSTANCE_METHODS_OPT_", PD.getName()), 
          new StringRef(/*KEEP_STR*/"__OBJC,__cat_inst_meth,regular,no_dead_strip"), 
          new ArrayRef<Constant /*P*/ >(OptInstanceMethods)), 
      EmitMethodDescList($add_char$ptr$C_StringRef$C(/*KEEP_STR*/"OBJC_PROTOCOL_CLASS_METHODS_OPT_", PD.getName()), 
          new StringRef(/*KEEP_STR*/"__OBJC,__cat_cls_meth,regular,no_dead_strip"), 
          new ArrayRef<Constant /*P*/ >(OptClassMethods)), 
      EmitPropertyList($add_char$ptr$C_StringRef$C(/*KEEP_STR*/"OBJC_$_PROP_PROTO_LIST_", PD.getName()), (/*const*/ Decl /*P*/ )null, PD, 
          ObjCTypes, false), 
      EmitProtocolMethodTypes($add_char$ptr$C_StringRef$C(/*KEEP_STR*/"OBJC_PROTOCOL_METHOD_TYPES_", PD.getName()), 
          new ArrayRef<Constant /*P*/ >(MethodTypesExt), ObjCTypes), 
      EmitPropertyList($add_char$ptr$C_StringRef$C(/*KEEP_STR*/"OBJC_$_CLASS_PROP_PROTO_LIST_", PD.getName()), (/*const*/ Decl /*P*/ )null, 
          PD, ObjCTypes, true)
    };
    
    // Return null if no extension bits are used.
    if (Values[1].isNullValue() && Values[2].isNullValue()
       && Values[3].isNullValue() && Values[4].isNullValue()
       && Values[5].isNullValue()) {
      return Constant.getNullValue(ObjCTypes.ProtocolExtensionPtrTy);
    }
    
    Constant /*P*/ Init = ConstantStruct.get(ObjCTypes.ProtocolExtensionTy, new ArrayRef<Constant /*P*/ >(Values, true));
    
    // No special section, but goes in llvm.used
    return CreateMetadataVar($add_char$ptr$C_StringRef$C(/*KEEP_STR*/"\001l_OBJC_PROTOCOLEXT_", PD.getName()), Init, 
        new StringRef(), CGM.getPointerAlign(), true);
  }

  
  /// EmitProtocolList - Generate the list of referenced
  /// protocols. The return value has type ProtocolListPtrTy.
  
  /*
  struct objc_protocol_list {
  struct objc_protocol_list *next;
  long count;
  Protocol *list[];
  };
  */
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCMac::EmitProtocolList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 2872,
   FQN="(anonymous namespace)::CGObjCMac::EmitProtocolList", NM="_ZN12_GLOBAL__N_19CGObjCMac16EmitProtocolListEN4llvm5TwineEPKPN5clang16ObjCProtocolDeclES7_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_19CGObjCMac16EmitProtocolListEN4llvm5TwineEPKPN5clang16ObjCProtocolDeclES7_")
  //</editor-fold>
  private Constant /*P*/ EmitProtocolList(Twine Name, 
                  type$ptr<ObjCProtocolDecl /*P*/ /*const*/ /*P*/> begin, 
                  type$ptr<ObjCProtocolDecl /*P*/ /*const*/ /*P*/> end) {
    SmallVector<Constant /*P*/ > ProtocolRefs/*J*/= new SmallVector<Constant /*P*/ >(16, (Constant /*P*/ )null);
    
    for (; $noteq_ptr(begin, end); begin.$preInc())  {
      ProtocolRefs.push_back(GetProtocolRef(begin.$star()));
    }
    
    // Just return null for empty protocol lists
    if (ProtocolRefs.empty()) {
      return Constant.getNullValue(ObjCTypes.ProtocolListPtrTy);
    }
    
    // This list is null terminated.
    ProtocolRefs.push_back(Constant.getNullValue(ObjCTypes.ProtocolPtrTy));
    
    Constant /*P*/ Values[/*3*/] = new Constant /*P*/  [3];
    // This field is only used by the runtime.
    Values[0] = Constant.getNullValue(ObjCTypes.ProtocolListPtrTy);
    Values[1] = ConstantInt.get(ObjCTypes.LongTy, 
        $uint2ulong(ProtocolRefs.size() - 1));
    Values[2]
       = ConstantArray.get(org.llvm.ir.ArrayType.get(ObjCTypes.ProtocolPtrTy, 
            $uint2ulong(ProtocolRefs.size())), 
        new ArrayRef<Constant /*P*/ >(ProtocolRefs, true));
    
    Constant /*P*/ Init = ConstantStruct.getAnon(new ArrayRef<Constant /*P*/ >(Values, true));
    GlobalVariable /*P*/ GV = CreateMetadataVar(new Twine(Name), Init, new StringRef(/*KEEP_STR*/"__OBJC,__cat_cls_meth,regular,no_dead_strip"), 
        CGM.getPointerAlign(), false);
    return ConstantExpr.getBitCast(GV, ObjCTypes.ProtocolListPtrTy);
  }

  
  /// EmitSelector - Return a Value*, of type ObjCTypes.SelectorPtrTy,
  /// for the given selector.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCMac::EmitSelector">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 4686,
   FQN="(anonymous namespace)::CGObjCMac::EmitSelector", NM="_ZN12_GLOBAL__N_19CGObjCMac12EmitSelectorERN5clang7CodeGen15CodeGenFunctionENS1_8SelectorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_19CGObjCMac12EmitSelectorERN5clang7CodeGen15CodeGenFunctionENS1_8SelectorE")
  //</editor-fold>
  private Value /*P*/ EmitSelector(final CodeGenFunction /*&*/ CGF, Selector Sel) {
    return CGF.Builder.CreateLoad(EmitSelectorAddr(CGF, new Selector(Sel)));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCMac::EmitSelectorAddr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 4690,
   FQN="(anonymous namespace)::CGObjCMac::EmitSelectorAddr", NM="_ZN12_GLOBAL__N_19CGObjCMac16EmitSelectorAddrERN5clang7CodeGen15CodeGenFunctionENS1_8SelectorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_19CGObjCMac16EmitSelectorAddrERN5clang7CodeGen15CodeGenFunctionENS1_8SelectorE")
  //</editor-fold>
  private Address EmitSelectorAddr(final CodeGenFunction /*&*/ CGF, Selector Sel) {
    CharUnits Align = CGF.getPointerAlign();
    
    final type$ref<GlobalVariable /*P*/ /*&*/> Entry = SelectorReferences.ref$at(Sel);
    if (!(Entry.$deref() != null)) {
      Constant /*P*/ Casted = ConstantExpr.getBitCast(GetMethodVarName(new Selector(Sel)), 
          ObjCTypes.SelectorPtrTy);
      Entry.$set(CreateMetadataVar(new Twine(/*KEEP_STR*/"OBJC_SELECTOR_REFERENCES_"), Casted, 
          new StringRef(/*KEEP_STR*/"__OBJC,__message_refs,literal_pointers,no_dead_strip"), new CharUnits(Align), true));
      Entry.$deref().setExternallyInitialized(true);
    }
    
    return new Address(Entry.$deref(), new CharUnits(Align));
  }

/*public:*/
  
  /* *** CGObjCMac Public Interface *** */
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCMac::CGObjCMac">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 1703,
   FQN="(anonymous namespace)::CGObjCMac::CGObjCMac", NM="_ZN12_GLOBAL__N_19CGObjCMacC1ERN5clang7CodeGen13CodeGenModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_19CGObjCMacC1ERN5clang7CodeGen13CodeGenModuleE")
  //</editor-fold>
  public CGObjCMac(final CodeGenModule /*&*/ cgm) {
    // : CGObjCCommonMac(cgm), ObjCTypes(cgm) 
    //START JInit
    super(cgm);
    this.ObjCTypes = new ObjCTypesHelper(cgm);
    //END JInit
    ObjCABI = 1;
    EmitImageInfo();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCMac::ModuleInitFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 3653,
   FQN="(anonymous namespace)::CGObjCMac::ModuleInitFunction", NM="_ZN12_GLOBAL__N_19CGObjCMac18ModuleInitFunctionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_19CGObjCMac18ModuleInitFunctionEv")
  //</editor-fold>
  @Override public Function /*P*/ ModuleInitFunction()/* override*/ {
    // Abuse this interface function as a place to finalize.
    FinishModule();
    return null;
  }

  
  
  /// Generate code for a message send expression.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCMac::GenerateMessageSend">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 1842,
   FQN="(anonymous namespace)::CGObjCMac::GenerateMessageSend", NM="_ZN12_GLOBAL__N_19CGObjCMac19GenerateMessageSendERN5clang7CodeGen15CodeGenFunctionENS2_15ReturnValueSlotENS1_8QualTypeENS1_8SelectorEPN4llvm5ValueERKNS2_11CallArgListEPKNS1_17ObjCInterfaceDeclEPKNS1_14ObjCMethodDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_19CGObjCMac19GenerateMessageSendERN5clang7CodeGen15CodeGenFunctionENS2_15ReturnValueSlotENS1_8QualTypeENS1_8SelectorEPN4llvm5ValueERKNS2_11CallArgListEPKNS1_17ObjCInterfaceDeclEPKNS1_14ObjCMethodDeclE")
  //</editor-fold>
  @Override public RValue GenerateMessageSend(final CodeGenFunction /*&*/ CGF, 
                     ReturnValueSlot Return, 
                     QualType ResultType, 
                     Selector Sel, 
                     Value /*P*/ Receiver, 
                     final /*const*/ CallArgList /*&*/ CallArgs, 
                     /*const*/ ObjCInterfaceDecl /*P*/ Class, 
                     /*const*/ ObjCMethodDecl /*P*/ Method)/* override*/ {
    return EmitMessageSend(CGF, new ReturnValueSlot(Return), new QualType(ResultType), 
        EmitSelector(CGF, new Selector(Sel)), 
        Receiver, CGF.getContext().getObjCIdType(), 
        false, CallArgs, Method, Class, ObjCTypes);
  }

  
  
  /// Generates a message send where the super is the receiver.  This is
  /// a message send to self with special delivery semantics indicating
  /// which class's method should be called.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCMac::GenerateMessageSendSuper">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 1778,
   FQN="(anonymous namespace)::CGObjCMac::GenerateMessageSendSuper", NM="_ZN12_GLOBAL__N_19CGObjCMac24GenerateMessageSendSuperERN5clang7CodeGen15CodeGenFunctionENS2_15ReturnValueSlotENS1_8QualTypeENS1_8SelectorEPKNS1_17ObjCInterfaceDeclEbPN4llvm5ValueEbRKNS2_11CallArgListEPKNS1_14ObjCMethodDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_19CGObjCMac24GenerateMessageSendSuperERN5clang7CodeGen15CodeGenFunctionENS2_15ReturnValueSlotENS1_8QualTypeENS1_8SelectorEPKNS1_17ObjCInterfaceDeclEbPN4llvm5ValueEbRKNS2_11CallArgListEPKNS1_14ObjCMethodDeclE")
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
      if (isCategoryImpl) {
        // Message sent to 'super' in a class method defined in a category
        // implementation requires an odd treatment.
        // If we are in a class method, we must retrieve the
        // _metaclass_ for the current class, pointed at by
        // the class's "isa" pointer.  The following assumes that
        // isa" is the first ivar in a class (which it must be).
        Target = EmitClassRef(CGF, Class.getSuperClass());
        Target = CGF.Builder.CreateStructGEP(ObjCTypes.ClassTy, Target, 0);
        Target = CGF.Builder.CreateAlignedLoad(Target, CGF.getPointerAlign());
      } else {
        Constant /*P*/ MetaClassPtr = EmitMetaClassRef(Class);
        Value /*P*/ SuperPtr = CGF.Builder.CreateStructGEP(ObjCTypes.ClassTy, MetaClassPtr, 1);
        Value /*P*/ Super = CGF.Builder.CreateAlignedLoad(SuperPtr, CGF.getPointerAlign());
        Target = Super;
      }
    } else if (isCategoryImpl) {
      Target = EmitClassRef(CGF, Class.getSuperClass());
    } else {
      Value /*P*/ ClassPtr = EmitSuperClassRef(Class);
      ClassPtr = CGF.Builder.CreateStructGEP(ObjCTypes.ClassTy, ClassPtr, 1);
      Target = CGF.Builder.CreateAlignedLoad(ClassPtr, CGF.getPointerAlign());
    }
    // FIXME: We shouldn't need to do this cast, rectify the ASTContext and
    // ObjCTypes types.
    org.llvm.ir.Type /*P*/ ClassTy = CGM.getTypes().ConvertType(CGF.getContext().getObjCClassType());
    Target = CGF.Builder.CreateBitCast(Target, ClassTy);
    CGF.Builder.CreateStore(Target, 
        CGF.Builder.CreateStructGEP(new Address(ObjCSuper), 1, CGF.getPointerSize()));
    return EmitMessageSend(CGF, new ReturnValueSlot(Return), new QualType(ResultType), 
        EmitSelector(CGF, new Selector(Sel)), 
        ObjCSuper.getPointer(), new QualType(ObjCTypes.SuperPtrCTy), 
        true, CallArgs, Method, Class, ObjCTypes);
  }

  
  
  /// GetClass - Return a reference to the class for the given interface
  /// decl.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCMac::GetClass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 1711,
   FQN="(anonymous namespace)::CGObjCMac::GetClass", NM="_ZN12_GLOBAL__N_19CGObjCMac8GetClassERN5clang7CodeGen15CodeGenFunctionEPKNS1_17ObjCInterfaceDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_19CGObjCMac8GetClassERN5clang7CodeGen15CodeGenFunctionEPKNS1_17ObjCInterfaceDeclE")
  //</editor-fold>
  @Override public Value /*P*/ GetClass(final CodeGenFunction /*&*/ CGF, 
          /*const*/ ObjCInterfaceDecl /*P*/ ID)/* override*/ {
    return EmitClassRef(CGF, ID);
  }

  
  
  /// GetSelector - Return the pointer to the unique'd string for this selector.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCMac::GetSelector">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 1717,
   FQN="(anonymous namespace)::CGObjCMac::GetSelector", NM="_ZN12_GLOBAL__N_19CGObjCMac11GetSelectorERN5clang7CodeGen15CodeGenFunctionENS1_8SelectorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_19CGObjCMac11GetSelectorERN5clang7CodeGen15CodeGenFunctionENS1_8SelectorE")
  //</editor-fold>
  @Override public Value /*P*/ GetSelector(final CodeGenFunction /*&*/ CGF, Selector Sel)/* override*/ {
    return EmitSelector(CGF, new Selector(Sel));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCMac::GetAddrOfSelector">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 1720,
   FQN="(anonymous namespace)::CGObjCMac::GetAddrOfSelector", NM="_ZN12_GLOBAL__N_19CGObjCMac17GetAddrOfSelectorERN5clang7CodeGen15CodeGenFunctionENS1_8SelectorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_19CGObjCMac17GetAddrOfSelectorERN5clang7CodeGen15CodeGenFunctionENS1_8SelectorE")
  //</editor-fold>
  @Override public Address GetAddrOfSelector(final CodeGenFunction /*&*/ CGF, Selector Sel)/* override*/ {
    return EmitSelectorAddr(CGF, new Selector(Sel));
  }

  
  /// The NeXT/Apple runtimes do not support typed selectors; just emit an
  /// untyped one.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCMac::GetSelector">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 1723,
   FQN="(anonymous namespace)::CGObjCMac::GetSelector", NM="_ZN12_GLOBAL__N_19CGObjCMac11GetSelectorERN5clang7CodeGen15CodeGenFunctionEPKNS1_14ObjCMethodDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_19CGObjCMac11GetSelectorERN5clang7CodeGen15CodeGenFunctionEPKNS1_14ObjCMethodDeclE")
  //</editor-fold>
  @Override public Value /*P*/ GetSelector(final CodeGenFunction /*&*/ CGF, 
             /*const*/ ObjCMethodDecl /*P*/ Method)/* override*/ {
    return EmitSelector(CGF, Method.getSelector());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCMac::GetEHType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 1728,
   FQN="(anonymous namespace)::CGObjCMac::GetEHType", NM="_ZN12_GLOBAL__N_19CGObjCMac9GetEHTypeEN5clang8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_19CGObjCMac9GetEHTypeEN5clang8QualTypeE")
  //</editor-fold>
  @Override public Constant /*P*/ GetEHType(QualType T)/* override*/ {
    if (T.$arrow().isObjCIdType()
       || T.$arrow().isObjCQualifiedIdType()) {
      return CGM.GetAddrOfRTTIDescriptor(CGM.getContext().getObjCIdRedefinitionType(), /*ForEH=*/ true);
    }
    if (T.$arrow().isObjCClassType()
       || T.$arrow().isObjCQualifiedClassType()) {
      return CGM.GetAddrOfRTTIDescriptor(CGM.getContext().getObjCClassRedefinitionType(), /*ForEH=*/ true);
    }
    if (T.$arrow().isObjCObjectPointerType()) {
      return CGM.GetAddrOfRTTIDescriptor(new QualType(T), /*ForEH=*/ true);
    }
    throw new llvm_unreachable("asking for catch type for ObjC type in fragile runtime");
  }

  
  
  /*
  struct _objc_category {
  char *category_name;
  char *class_name;
  struct _objc_method_list *instance_methods;
  struct _objc_method_list *class_methods;
  struct _objc_protocol_list *protocols;
  uint32_t size; // <rdar://4585769>
  struct _objc_property_list *instance_properties;
  struct _objc_property_list *class_properties;
  };
  */
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCMac::GenerateCategory">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 3086,
   FQN="(anonymous namespace)::CGObjCMac::GenerateCategory", NM="_ZN12_GLOBAL__N_19CGObjCMac16GenerateCategoryEPKN5clang20ObjCCategoryImplDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_19CGObjCMac16GenerateCategoryEPKN5clang20ObjCCategoryImplDeclE")
  //</editor-fold>
  @Override public void GenerateCategory(/*const*/ ObjCCategoryImplDecl /*P*/ OCD)/* override*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      /*uint*/int Size = $ulong2uint(CGM.getDataLayout().getTypeAllocSize(ObjCTypes.CategoryTy));
      
      // FIXME: This is poor design, the OCD should have a pointer to the category
      // decl. Additionally, note that Category can be null for the @implementation
      // w/o an @interface case. Sema should just create one for us as it does for
      // @implementation so everyone else can live life under a clear blue sky.
      /*const*/ ObjCInterfaceDecl /*P*/ Interface = OCD.getClassInterface$Const();
      /*const*/ ObjCCategoryDecl /*P*/ Category = Interface.FindCategoryDeclaration(OCD.getIdentifier());
      
      SmallString/*<256>*/ ExtName/*J*/= new SmallString/*<256>*/(256);
      $c$.clean($c$.track(new raw_svector_ostream(ExtName)).$out(Interface.getName()).$out_char($$UNDERSCORE).$out(
          OCD.getName()
      ));
      
      SmallVector<Constant /*P*/ > InstanceMethods/*J*/= new SmallVector<Constant /*P*/ >(16, (Constant /*P*/ )null);
      SmallVector<Constant /*P*/ > ClassMethods/*J*/= new SmallVector<Constant /*P*/ >(16, (Constant /*P*/ )null);
      for (/*const*/ ObjCMethodDecl /*P*/ I : OCD.instance_methods())  {
        // Instance methods should always be defined.
        InstanceMethods.push_back(GetMethodConstant(I));
      }
      
      for (/*const*/ ObjCMethodDecl /*P*/ I : OCD.class_methods())  {
        // Class methods should always be defined.
        ClassMethods.push_back(GetMethodConstant(I));
      }
      
      Constant /*P*/ Values[/*8*/] = new Constant /*P*/  [8];
      Values[0] = GetClassName(OCD.getName());
      Values[1] = GetClassName(Interface.getObjCRuntimeNameAsString());
      LazySymbols.insert(Interface.getIdentifier());
      Values[2] = EmitMethodList($add_char$ptr$C_StringRef$C(/*KEEP_STR*/"OBJC_CATEGORY_INSTANCE_METHODS_", ExtName.str()), 
          new StringRef(/*KEEP_STR*/"__OBJC,__cat_inst_meth,regular,no_dead_strip"), 
          new ArrayRef<Constant /*P*/ >(InstanceMethods, true));
      Values[3] = EmitMethodList($add_char$ptr$C_StringRef$C(/*KEEP_STR*/"OBJC_CATEGORY_CLASS_METHODS_", ExtName.str()), 
          new StringRef(/*KEEP_STR*/"__OBJC,__cat_cls_meth,regular,no_dead_strip"), 
          new ArrayRef<Constant /*P*/ >(ClassMethods, true));
      if ((Category != null)) {
        Values[4]
           = EmitProtocolList($add_char$ptr$C_StringRef$C(/*KEEP_STR*/"OBJC_CATEGORY_PROTOCOLS_", ExtName.str()), 
            Category.protocol_begin(), Category.protocol_end());
      } else {
        Values[4] = Constant.getNullValue(ObjCTypes.ProtocolListPtrTy);
      }
      Values[5] = ConstantInt.get(ObjCTypes.IntTy, $uint2ulong(Size));
      
      // If there is no category @interface then there can be no properties.
      if ((Category != null)) {
        Values[6] = EmitPropertyList($add_char$ptr$C_StringRef$C(/*KEEP_STR*/"\001l_OBJC_$_PROP_LIST_", ExtName.str()), 
            OCD, Category, ObjCTypes, false);
        Values[7] = EmitPropertyList($add_char$ptr$C_StringRef$C(/*KEEP_STR*/"\001l_OBJC_$_CLASS_PROP_LIST_", ExtName.str()), 
            OCD, Category, ObjCTypes, true);
      } else {
        Values[6] = Constant.getNullValue(ObjCTypes.PropertyListPtrTy);
        Values[7] = Constant.getNullValue(ObjCTypes.PropertyListPtrTy);
      }
      
      Constant /*P*/ Init = ConstantStruct.get(ObjCTypes.CategoryTy, 
          new ArrayRef<Constant /*P*/ >(Values, true));
      
      GlobalVariable /*P*/ GV = CreateMetadataVar($add_char$ptr$C_StringRef$C(/*KEEP_STR*/"OBJC_CATEGORY_", ExtName.str()), Init, 
          new StringRef(/*KEEP_STR*/"__OBJC,__category,regular,no_dead_strip"), 
          CGM.getPointerAlign(), true);
      DefinedCategories.push_back(GV);
      DefinedCategoryNames.insert(ExtName.str().$string());
      // method definition entries must be clear for next implementation.
      MethodDefinitions.clear();
    } finally {
      $c$.$destroy();
    }
  }

  
  
  /*
  struct _objc_class {
  Class isa;
  Class super_class;
  const char *name;
  long version;
  long info;
  long instance_size;
  struct _objc_ivar_list *ivars;
  struct _objc_method_list *methods;
  struct _objc_cache *cache;
  struct _objc_protocol_list *protocols;
  // Objective-C 1.0 extensions (<rdr://4585769>)
  const char *ivar_layout;
  struct _objc_class_ext *ext;
  };
  
  See EmitClassExtension();
  */
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCMac::GenerateClass">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 3256,
   FQN="(anonymous namespace)::CGObjCMac::GenerateClass", NM="_ZN12_GLOBAL__N_19CGObjCMac13GenerateClassEPKN5clang22ObjCImplementationDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_19CGObjCMac13GenerateClassEPKN5clang22ObjCImplementationDeclE")
  //</editor-fold>
  @Override public void GenerateClass(/*const*/ ObjCImplementationDecl /*P*/ ID)/* override*/ {
    DefinedSymbols.insert(ID.getIdentifier());
    
    std.string ClassName = ID.getNameAsString();
    // FIXME: Gross
    ObjCInterfaceDecl /*P*/ Interface = ((/*const_cast*/ObjCInterfaceDecl /*P*/ )(ID.getClassInterface$Const()));
    Constant /*P*/ Protocols = EmitProtocolList($add_char$ptr$C_StringRef$C(/*KEEP_STR*/"OBJC_CLASS_PROTOCOLS_", ID.getName()), 
        Interface.all_referenced_protocol_begin(), 
        Interface.all_referenced_protocol_end());
    /*uint*/int Flags = FragileClassFlags.FragileABI_Class_Factory;
    if (ID.hasNonZeroConstructors() || ID.hasDestructors()) {
      Flags |= FragileClassFlags.FragileABI_Class_HasCXXStructors;
    }
    
    boolean hasMRCWeak = false;
    if (CGM.getLangOpts().ObjCAutoRefCount) {
      Flags |= FragileClassFlags.FragileABI_Class_CompiledByARC;
    } else if ((hasMRCWeak = CGObjCMacStatics.hasMRCWeakIvars(CGM, ID))) {
      Flags |= FragileClassFlags.FragileABI_Class_HasMRCWeakIvars;
    }
    
    CharUnits Size = CGM.getContext().getASTObjCImplementationLayout(ID).getSize();
    
    // FIXME: Set CXX-structors flag.
    if (ID.getClassInterface$Const().getVisibility() == Visibility.HiddenVisibility) {
      Flags |= FragileClassFlags.FragileABI_Class_Hidden;
    }
    
    SmallVector<Constant /*P*/ > InstanceMethods/*J*/= new SmallVector<Constant /*P*/ >(16, (Constant /*P*/ )null);
    SmallVector<Constant /*P*/ > ClassMethods/*J*/= new SmallVector<Constant /*P*/ >(16, (Constant /*P*/ )null);
    for (/*const*/ ObjCMethodDecl /*P*/ I : ID.instance_methods())  {
      // Instance methods should always be defined.
      InstanceMethods.push_back(GetMethodConstant(I));
    }
    
    for (/*const*/ ObjCMethodDecl /*P*/ I : ID.class_methods())  {
      // Class methods should always be defined.
      ClassMethods.push_back(GetMethodConstant(I));
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
                InstanceMethods.push_back(C);
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
                InstanceMethods.push_back(C);
              }
            }
          }
        }
      }
    }
    
    Constant /*P*/ Values[/*12*/] = new Constant /*P*/  [12];
    Values[0] = EmitMetaClass(ID, Protocols, new ArrayRef<Constant /*P*/ >(ClassMethods, true));
    {
      ObjCInterfaceDecl /*P*/ Super = Interface.getSuperClass();
      if ((Super != null)) {
        // Record a reference to the super class.
        LazySymbols.insert(Super.getIdentifier());
        
        Values[1]
           = ConstantExpr.getBitCast(GetClassName(Super.getObjCRuntimeNameAsString()), 
            ObjCTypes.ClassPtrTy);
      } else {
        Values[1] = Constant.getNullValue(ObjCTypes.ClassPtrTy);
      }
    }
    Values[2] = GetClassName(ID.getObjCRuntimeNameAsString());
    // Version is always 0.
    Values[3] = ConstantInt.get(ObjCTypes.LongTy, $int2ulong(0));
    Values[4] = ConstantInt.get(ObjCTypes.LongTy, $uint2ulong(Flags));
    Values[5] = ConstantInt.get(ObjCTypes.LongTy, Size.getQuantity());
    Values[6] = EmitIvarList(ID, false);
    Values[7] = EmitMethodList($add_char$ptr$C_StringRef$C(/*KEEP_STR*/"OBJC_INSTANCE_METHODS_", ID.getName()), 
        new StringRef(/*KEEP_STR*/"__OBJC,__inst_meth,regular,no_dead_strip"), 
        new ArrayRef<Constant /*P*/ >(InstanceMethods, true));
    // cache is always NULL.
    Values[8] = Constant.getNullValue(ObjCTypes.CachePtrTy);
    Values[9] = Protocols;
    Values[10] = BuildStrongIvarLayout(ID, CharUnits.Zero(), new CharUnits(Size));
    Values[11] = EmitClassExtension(ID, new CharUnits(Size), hasMRCWeak, 
        false/*isClassProperty*/);
    Constant /*P*/ Init = ConstantStruct.get(ObjCTypes.ClassTy, 
        new ArrayRef<Constant /*P*/ >(Values, true));
    std.string Name/*J*/= new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"OBJC_CLASS_");
    Name.$addassign(ClassName);
    /*const*/char$ptr/*char P*/ Section = $("__OBJC,__class,regular,no_dead_strip");
    // Check for a forward reference.
    GlobalVariable /*P*/ GV = CGM.getModule().getGlobalVariable(new StringRef(Name), true);
    if ((GV != null)) {
      assert (GV.getType().getElementType() == ObjCTypes.ClassTy) : "Forward metaclass reference has incorrect type.";
      GV.setInitializer(Init);
      GV.setSection(new StringRef(Section));
      GV.setAlignment($long2uint(CGM.getPointerAlign().getQuantity()));
      CGM.addCompilerUsedGlobal(GV);
    } else {
      GV = CreateMetadataVar(new Twine(Name), Init, new StringRef(Section), CGM.getPointerAlign(), true);
    }
    DefinedClasses.push_back(GV);
    ImplementedClasses.push_back(Interface);
    // method definition entries must be clear for next implementation.
    MethodDefinitions.clear();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCMac::RegisterAlias">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 1221,
   FQN="(anonymous namespace)::CGObjCMac::RegisterAlias", NM="_ZN12_GLOBAL__N_19CGObjCMac13RegisterAliasEPKN5clang23ObjCCompatibleAliasDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_19CGObjCMac13RegisterAliasEPKN5clang23ObjCCompatibleAliasDeclE")
  //</editor-fold>
  @Override public void RegisterAlias(/*const*/ ObjCCompatibleAliasDecl /*P*/ OAD)/* override*/ {
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCMac::GenerateProtocolRef">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 2657,
   FQN="(anonymous namespace)::CGObjCMac::GenerateProtocolRef", NM="_ZN12_GLOBAL__N_19CGObjCMac19GenerateProtocolRefERN5clang7CodeGen15CodeGenFunctionEPKNS1_16ObjCProtocolDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_19CGObjCMac19GenerateProtocolRefERN5clang7CodeGen15CodeGenFunctionEPKNS1_16ObjCProtocolDeclE")
  //</editor-fold>
  @Override public Value /*P*/ GenerateProtocolRef(final CodeGenFunction /*&*/ CGF, 
                     /*const*/ ObjCProtocolDecl /*P*/ PD)/* override*/ {
    // FIXME: I don't understand why gcc generates this, or where it is
    // resolved. Investigate. Its also wasteful to look this up over and over.
    LazySymbols.insert($AddrOf(CGM.getContext().Idents.get(new StringRef(/*KEEP_STR*/"Protocol"))));
    
    return ConstantExpr.getBitCast(GetProtocolRef(PD), 
        ObjCTypes.getExternalProtocolPtrTy());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCMac::GetPropertyGetFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 3659,
   FQN="(anonymous namespace)::CGObjCMac::GetPropertyGetFunction", NM="_ZN12_GLOBAL__N_19CGObjCMac22GetPropertyGetFunctionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_19CGObjCMac22GetPropertyGetFunctionEv")
  //</editor-fold>
  @Override public Constant /*P*/ GetPropertyGetFunction()/* override*/ {
    return ObjCTypes.getGetPropertyFn();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCMac::GetPropertySetFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 3663,
   FQN="(anonymous namespace)::CGObjCMac::GetPropertySetFunction", NM="_ZN12_GLOBAL__N_19CGObjCMac22GetPropertySetFunctionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_19CGObjCMac22GetPropertySetFunctionEv")
  //</editor-fold>
  @Override public Constant /*P*/ GetPropertySetFunction()/* override*/ {
    return ObjCTypes.getSetPropertyFn();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCMac::GetOptimizedPropertySetFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 3667,
   FQN="(anonymous namespace)::CGObjCMac::GetOptimizedPropertySetFunction", NM="_ZN12_GLOBAL__N_19CGObjCMac31GetOptimizedPropertySetFunctionEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_19CGObjCMac31GetOptimizedPropertySetFunctionEbb")
  //</editor-fold>
  @Override public Constant /*P*/ GetOptimizedPropertySetFunction(boolean atomic, 
                                 boolean copy)/* override*/ {
    return ObjCTypes.getOptimizedSetPropertyFn(atomic, copy);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCMac::GetGetStructFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 3672,
   FQN="(anonymous namespace)::CGObjCMac::GetGetStructFunction", NM="_ZN12_GLOBAL__N_19CGObjCMac20GetGetStructFunctionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_19CGObjCMac20GetGetStructFunctionEv")
  //</editor-fold>
  @Override public Constant /*P*/ GetGetStructFunction()/* override*/ {
    return ObjCTypes.getCopyStructFn();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCMac::GetSetStructFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 3676,
   FQN="(anonymous namespace)::CGObjCMac::GetSetStructFunction", NM="_ZN12_GLOBAL__N_19CGObjCMac20GetSetStructFunctionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_19CGObjCMac20GetSetStructFunctionEv")
  //</editor-fold>
  @Override public Constant /*P*/ GetSetStructFunction()/* override*/ {
    return ObjCTypes.getCopyStructFn();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCMac::GetCppAtomicObjectGetFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 3680,
   FQN="(anonymous namespace)::CGObjCMac::GetCppAtomicObjectGetFunction", NM="_ZN12_GLOBAL__N_19CGObjCMac29GetCppAtomicObjectGetFunctionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_19CGObjCMac29GetCppAtomicObjectGetFunctionEv")
  //</editor-fold>
  @Override public Constant /*P*/ GetCppAtomicObjectGetFunction()/* override*/ {
    return ObjCTypes.getCppAtomicObjectFunction();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCMac::GetCppAtomicObjectSetFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 3684,
   FQN="(anonymous namespace)::CGObjCMac::GetCppAtomicObjectSetFunction", NM="_ZN12_GLOBAL__N_19CGObjCMac29GetCppAtomicObjectSetFunctionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_19CGObjCMac29GetCppAtomicObjectSetFunctionEv")
  //</editor-fold>
  @Override public Constant /*P*/ GetCppAtomicObjectSetFunction()/* override*/ {
    return ObjCTypes.getCppAtomicObjectFunction();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCMac::EnumerationMutationFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 3688,
   FQN="(anonymous namespace)::CGObjCMac::EnumerationMutationFunction", NM="_ZN12_GLOBAL__N_19CGObjCMac27EnumerationMutationFunctionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_19CGObjCMac27EnumerationMutationFunctionEv")
  //</editor-fold>
  @Override public Constant /*P*/ EnumerationMutationFunction()/* override*/ {
    return ObjCTypes.getEnumerationMutationFn();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCMac::EmitTryStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 3692,
   FQN="(anonymous namespace)::CGObjCMac::EmitTryStmt", NM="_ZN12_GLOBAL__N_19CGObjCMac11EmitTryStmtERN5clang7CodeGen15CodeGenFunctionERKNS1_13ObjCAtTryStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_19CGObjCMac11EmitTryStmtERN5clang7CodeGen15CodeGenFunctionERKNS1_13ObjCAtTryStmtE")
  //</editor-fold>
  @Override public void EmitTryStmt(final CodeGenFunction /*&*/ CGF, final /*const*/ ObjCAtTryStmt /*&*/ S)/* override*/ {
    EmitTryOrSynchronizedStmt(CGF, S);
    /*JAVA:return*/return;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCMac::EmitSynchronizedStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 3696,
   FQN="(anonymous namespace)::CGObjCMac::EmitSynchronizedStmt", NM="_ZN12_GLOBAL__N_19CGObjCMac20EmitSynchronizedStmtERN5clang7CodeGen15CodeGenFunctionERKNS1_22ObjCAtSynchronizedStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_19CGObjCMac20EmitSynchronizedStmtERN5clang7CodeGen15CodeGenFunctionERKNS1_22ObjCAtSynchronizedStmtE")
  //</editor-fold>
  @Override public void EmitSynchronizedStmt(final CodeGenFunction /*&*/ CGF, 
                      final /*const*/ ObjCAtSynchronizedStmt /*&*/ S)/* override*/ {
    EmitTryOrSynchronizedStmt(CGF, S);
    /*JAVA:return*/return;
  }

  
  /*
  
  Objective-C setjmp-longjmp (sjlj) Exception Handling
  --
  
  A catch buffer is a setjmp buffer plus:
  - a pointer to the exception that was caught
  - a pointer to the previous exception data buffer
  - two pointers of reserved storage
  Therefore catch buffers form a stack, with a pointer to the top
  of the stack kept in thread-local storage.
  
  objc_exception_try_enter pushes a catch buffer onto the EH stack.
  objc_exception_try_exit pops the given catch buffer, which is
  required to be the top of the EH stack.
  objc_exception_throw pops the top of the EH stack, writes the
  thrown exception into the appropriate field, and longjmps
  to the setjmp buffer.  It crashes the process (with a printf
  and an abort()) if there are no catch buffers on the stack.
  objc_exception_extract just reads the exception pointer out of the
  catch buffer.
  
  There's no reason an implementation couldn't use a light-weight
  setjmp here --- something like __builtin_setjmp, but API-compatible
  with the heavyweight setjmp.  This will be more important if we ever
  want to implement correct ObjC/C++ exception interactions for the
  fragile ABI.
  
  Note that for this use of setjmp/longjmp to be correct, we may need
  to mark some local variables volatile: if a non-volatile local
  variable is modified between the setjmp and the longjmp, it has
  indeterminate value.  For the purposes of LLVM IR, it may be
  sufficient to make loads and stores within the @try (to variables
  declared outside the @try) volatile.  This is necessary for
  optimized correctness, but is not currently being done; this is
  being tracked as rdar://problem/8160285
  
  The basic framework for a @try-catch-finally is as follows:
  {
  objc_exception_data d;
  id _rethrow = null;
  bool _call_try_exit = true;
  
  objc_exception_try_enter(&d);
  if (!setjmp(d.jmp_buf)) {
  ... try body ...
  } else {
  // exception path
  id _caught = objc_exception_extract(&d);
  
  // enter new try scope for handlers
  if (!setjmp(d.jmp_buf)) {
  ... match exception and execute catch blocks ...
  
  // fell off end, rethrow.
  _rethrow = _caught;
  ... jump-through-finally to finally_rethrow ...
  } else {
  // exception in catch block
  _rethrow = objc_exception_extract(&d);
  _call_try_exit = false;
  ... jump-through-finally to finally_rethrow ...
  }
  }
  ... jump-through-finally to finally_end ...
  
  finally:
  if (_call_try_exit)
  objc_exception_try_exit(&d);
  
  ... finally block ....
  ... dispatch to finally destination ...
  
  finally_rethrow:
  objc_exception_throw(_rethrow);
  
  finally_end:
  }
  
  This framework differs slightly from the one gcc uses, in that gcc
  uses _rethrow to determine if objc_exception_try_exit should be called
  and if the object should be rethrown. This breaks in the face of
  throwing nil and introduces unnecessary branches.
  
  We specialize this framework for a few particular circumstances:
  
  - If there are no catch blocks, then we avoid emitting the second
  exception handling context.
  
  - If there is a catch-all catch block (i.e. @catch(...) or @catch(id
  e)) we avoid emitting the code to rethrow an uncaught exception.
  
  - FIXME: If there is no @finally block we can do a few more
  simplifications.
  
  Rethrows and Jumps-Through-Finally
  --
  
  '@throw;' is supported by pushing the currently-caught exception
  onto ObjCEHStack while the @catch blocks are emitted.
  
  Branches through the @finally block are handled with an ordinary
  normal cleanup.  We do not register an EH cleanup; fragile-ABI ObjC
  exceptions are not compatible with C++ exceptions, and this is
  hardly the only place where this will go wrong.
  
  @synchronized(expr) { stmt; } is emitted as if it were:
  id synch_value = expr;
  objc_sync_enter(synch_value);
  @try { stmt; } @finally { objc_sync_exit(synch_value); }
  */
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCMac::EmitTryOrSynchronizedStmt">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 4026,
   FQN="(anonymous namespace)::CGObjCMac::EmitTryOrSynchronizedStmt", NM="_ZN12_GLOBAL__N_19CGObjCMac25EmitTryOrSynchronizedStmtERN5clang7CodeGen15CodeGenFunctionERKNS1_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_19CGObjCMac25EmitTryOrSynchronizedStmtERN5clang7CodeGen15CodeGenFunctionERKNS1_4StmtE")
  //</editor-fold>
  public void EmitTryOrSynchronizedStmt(final CodeGenFunction /*&*/ CGF, 
                           final /*const*/ Stmt /*&*/ S) {
    FragileHazards Hazards = null;
    try {
      boolean isTry = isa_ObjCAtTryStmt(S);
      
      // A destination for the fall-through edges of the catch handlers to
      // jump to.
      CodeGenFunction.JumpDest FinallyEnd = CGF.getJumpDestInCurrentScope(new StringRef(/*KEEP_STR*/"finally.end"));
      
      // A destination for the rethrow edge of the catch handlers to jump
      // to.
      CodeGenFunction.JumpDest FinallyRethrow = CGF.getJumpDestInCurrentScope(new StringRef(/*KEEP_STR*/"finally.rethrow"));
      
      // For @synchronized, call objc_sync_enter(sync.expr). The
      // evaluation of the expression must occur before we enter the
      // @synchronized.  We can't avoid a temp here because we need the
      // value to be preserved.  If the backend ever does liveness
      // correctly after setjmp, this will be unnecessary.
      Address SyncArgSlot = Address.invalid();
      if (!isTry) {
        Value /*P*/ SyncArg = CGF.EmitScalarExpr(cast_ObjCAtSynchronizedStmt(S).getSynchExpr$Const());
        SyncArg = CGF.Builder.CreateBitCast(SyncArg, ObjCTypes.ObjectPtrTy);
        CGF.EmitNounwindRuntimeCall(ObjCTypes.getSyncEnterFn(), new ArrayRef<Value /*P*/ >(SyncArg, true));
        
        SyncArgSlot.$assignMove(CGF.CreateTempAlloca(SyncArg.getType(), 
                CGF.getPointerAlign(), new Twine(/*KEEP_STR*/"sync.arg")));
        CGF.Builder.CreateStore(SyncArg, new Address(SyncArgSlot));
      }
      
      // Allocate memory for the setjmp buffer.  This needs to be kept
      // live throughout the try and catch blocks.
      Address ExceptionData = CGF.CreateTempAlloca(ObjCTypes.ExceptionDataTy, 
          CGF.getPointerAlign(), 
          new Twine(/*KEEP_STR*/"exceptiondata.ptr"));
      
      // Create the fragile hazards.  Note that this will not capture any
      // of the allocas required for exception processing, but will
      // capture the current basic block (which extends all the way to the
      // setjmp call) as "before the @try".
      Hazards/*J*/= new FragileHazards(CGF);
      
      // Create a flag indicating whether the cleanup needs to call
      // objc_exception_try_exit.  This is true except when
      //   - no catches match and we're branching through the cleanup
      //     just to rethrow the exception, or
      //   - a catch matched and we're falling out of the catch handler.
      // The setjmp-safety rule here is that we should always store to this
      // variable in a place that dominates the branch through the cleanup
      // without passing through any setjmps.
      Address CallTryExitVar = CGF.CreateTempAlloca(CGF.Builder.getInt1Ty(), 
          CharUnits.One(), 
          new Twine(/*KEEP_STR*/"_call_try_exit"));
      
      // A slot containing the exception to rethrow.  Only needed when we
      // have both a @catch and a @finally.
      Address PropagatingExnVar = Address.invalid();
      
      // Push a normal cleanup to leave the try scope.
      CGF.EHStack.<PerformFragileFinally>pushCleanup$T(CleanupKind.NormalAndEHCleanup, () -> new PerformFragileFinally($AddrOf(S), 
          new Address(SyncArgSlot), 
          new Address(CallTryExitVar), 
          new Address(ExceptionData), 
          $AddrOf(ObjCTypes)));
      
      // Enter a try block:
      //  - Call objc_exception_try_enter to push ExceptionData on top of
      //    the EH stack.
      CGF.EmitNounwindRuntimeCall(ObjCTypes.getExceptionTryEnterFn(), 
          new ArrayRef<Value /*P*/ >(ExceptionData.getPointer(), true));
      
      //  - Call setjmp on the exception data buffer.
      Constant /*P*/ Zero = ConstantInt.get(CGF.Builder.getInt32Ty(), $int2ulong(0));
      Value /*P*/ GEPIndexes[/*3*/] = new Value /*P*/  [/*3*/] {Zero, Zero, Zero};
      Value /*P*/ SetJmpBuffer = CGF.Builder.CreateGEP(ObjCTypes.ExceptionDataTy, ExceptionData.getPointer(), new ArrayRef<Value /*P*/ >(GEPIndexes, true), 
          new Twine(/*KEEP_STR*/"setjmp_buffer"));
      CallInst /*P*/ SetJmpResult = CGF.EmitNounwindRuntimeCall(ObjCTypes.getSetJmpFn(), new ArrayRef<Value /*P*/ >(SetJmpBuffer, true), new Twine(/*KEEP_STR*/"setjmp_result"));
      SetJmpResult.setCanReturnTwice();
      
      // If setjmp returned 0, enter the protected block; otherwise,
      // branch to the handler.
      BasicBlock /*P*/ TryBlock = CGF.createBasicBlock(new Twine(/*KEEP_STR*/$try));
      BasicBlock /*P*/ TryHandler = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"try.handler"));
      Value /*P*/ DidCatch = CGF.Builder.CreateIsNotNull(SetJmpResult, new Twine(/*KEEP_STR*/"did_catch_exception"));
      CGF.Builder.CreateCondBr(DidCatch, TryHandler, TryBlock);
      
      // Emit the protected block.
      CGF.EmitBlock(TryBlock);
      CGF.Builder.CreateStore(CGF.Builder.getTrue(), new Address(CallTryExitVar));
      CGF.EmitStmt(isTry ? cast_ObjCAtTryStmt(S).getTryBody$Const() : cast_ObjCAtSynchronizedStmt(S).getSynchBody$Const());
      
      CGBuilderTy.InsertPoint TryFallthroughIP = CGF.Builder.saveAndClearIP();
      
      // Emit the exception handler block.
      CGF.EmitBlock(TryHandler);
      
      // Don't optimize loads of the in-scope locals across this point.
      Hazards.emitWriteHazard();
      
      // For a @synchronized (or a @try with no catches), just branch
      // through the cleanup to the rethrow block.
      if (!isTry || !(cast_ObjCAtTryStmt(S).getNumCatchStmts() != 0)) {
        // Tell the cleanup not to re-pop the exit.
        CGF.Builder.CreateStore(CGF.Builder.getFalse(), new Address(CallTryExitVar));
        CGF.EmitBranchThroughCleanup(new CodeGenFunction.JumpDest(FinallyRethrow));
        // Otherwise, we have to match against the caught exceptions.
      } else {
        // Retrieve the exception object.  We may emit multiple blocks but
        // nothing can cross this so the value is already in SSA form.
        CallInst /*P*/ Caught = CGF.EmitNounwindRuntimeCall(ObjCTypes.getExceptionExtractFn(), 
            new ArrayRef<Value /*P*/ >(ExceptionData.getPointer(), true), new Twine(/*KEEP_STR*/"caught"));
        
        // Push the exception to rethrow onto the EH value stack for the
        // benefit of any @throws in the handlers.
        CGF.ObjCEHValueStack.push_back(Caught);
        
        /*const*/ ObjCAtTryStmt /*P*/ AtTryStmt = cast_ObjCAtTryStmt($AddrOf(S));
        
        boolean HasFinally = (AtTryStmt.getFinallyStmt$Const() != null);
        
        BasicBlock /*P*/ CatchBlock = null;
        BasicBlock /*P*/ CatchHandler = null;
        if (HasFinally) {
          // Save the currently-propagating exception before
          // objc_exception_try_enter clears the exception slot.
          PropagatingExnVar.$assignMove(CGF.CreateTempAlloca(Caught.getType(), 
                  CGF.getPointerAlign(), 
                  new Twine(/*KEEP_STR*/"propagating_exception")));
          CGF.Builder.CreateStore(Caught, new Address(PropagatingExnVar));
          
          // Enter a new exception try block (in case a @catch block
          // throws an exception).
          CGF.EmitNounwindRuntimeCall(ObjCTypes.getExceptionTryEnterFn(), 
              new ArrayRef<Value /*P*/ >(ExceptionData.getPointer(), true));
          
          CallInst /*P*/ SetJmpResult$1 = CGF.EmitNounwindRuntimeCall(ObjCTypes.getSetJmpFn(), 
              new ArrayRef<Value /*P*/ >(SetJmpBuffer, true), new Twine(/*KEEP_STR*/"setjmp.result"));
          SetJmpResult$1.setCanReturnTwice();
          
          Value /*P*/ Threw = CGF.Builder.CreateIsNotNull(SetJmpResult$1, new Twine(/*KEEP_STR*/"did_catch_exception"));
          
          CatchBlock = CGF.createBasicBlock(new Twine(/*KEEP_STR*/$catch));
          CatchHandler = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"catch_for_catch"));
          CGF.Builder.CreateCondBr(Threw, CatchHandler, CatchBlock);
          
          CGF.EmitBlock(CatchBlock);
        }
        
        CGF.Builder.CreateStore(CGF.Builder.getInt1(HasFinally), new Address(CallTryExitVar));
        
        // Handle catch list. As a special case we check if everything is
        // matched and avoid generating code for falling off the end if
        // so.
        boolean AllMatched = false;
        for (/*uint*/int I = 0, N = AtTryStmt.getNumCatchStmts(); I != N; ++I) {
          CodeGenFunction.RunCleanupsScope CatchVarCleanups = null;
          try {
            /*const*/ ObjCAtCatchStmt /*P*/ CatchStmt = AtTryStmt.getCatchStmt$Const(I);
            
            /*const*/ VarDecl /*P*/ CatchParam = CatchStmt.getCatchParamDecl$Const();
            /*const*/ ObjCObjectPointerType /*P*/ OPT = null;
            
            // catch(...) always matches.
            if (!(CatchParam != null)) {
              AllMatched = true;
            } else {
              OPT = CatchParam.getType().$arrow().getAs(ObjCObjectPointerType.class);
              
              // catch(id e) always matches under this ABI, since only
              // ObjC exceptions end up here in the first place.
              // FIXME: For the time being we also match id<X>; this should
              // be rejected by Sema instead.
              if ((OPT != null) && (OPT.isObjCIdType() || OPT.isObjCQualifiedIdType())) {
                AllMatched = true;
              }
            }
            
            // If this is a catch-all, we don't need to test anything.
            if (AllMatched) {
              CodeGenFunction.RunCleanupsScope CatchVarCleanups$1 = null;
              try {
                CatchVarCleanups$1/*J*/= new CodeGenFunction.RunCleanupsScope(CGF);
                if ((CatchParam != null)) {
                  CGF.EmitAutoVarDecl($Deref(CatchParam));
                  assert (CGF.HaveInsertPoint()) : "DeclStmt destroyed insert point?";
                  
                  // These types work out because ConvertType(id) == i8*.
                  EmitInitOfCatchParam(CGF, Caught, CatchParam);
                }
                
                CGF.EmitStmt(CatchStmt.getCatchBody$Const());
                
                // The scope of the catch variable ends right here.
                CatchVarCleanups$1.ForceCleanup();
                
                CGF.EmitBranchThroughCleanup(new CodeGenFunction.JumpDest(FinallyEnd));
                break;
              } finally {
                if (CatchVarCleanups$1 != null) { CatchVarCleanups$1.$destroy(); }
              }
            }
            assert ((OPT != null)) : "Unexpected non-object pointer type in @catch";
            /*const*/ ObjCObjectType /*P*/ ObjTy = OPT.getObjectType();
            
            // FIXME: @catch (Class c) ?
            ObjCInterfaceDecl /*P*/ IDecl = ObjTy.getInterface();
            assert ((IDecl != null)) : "Catch parameter must have Objective-C type!";
            
            // Check if the @catch block matches the exception object.
            Value /*P*/ Class = EmitClassRef(CGF, IDecl);
            
            Value /*P*/ matchArgs[/*2*/] = new Value /*P*/  [/*2*/] {Class, Caught};
            CallInst /*P*/ Match = CGF.EmitNounwindRuntimeCall(ObjCTypes.getExceptionMatchFn(), 
                new ArrayRef<Value /*P*/ >(matchArgs, true), new Twine(/*KEEP_STR*/"match"));
            
            BasicBlock /*P*/ MatchedBlock = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"match"));
            BasicBlock /*P*/ NextCatchBlock = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"catch.next"));
            
            CGF.Builder.CreateCondBr(CGF.Builder.CreateIsNotNull(Match, new Twine(/*KEEP_STR*/"matched")), 
                MatchedBlock, NextCatchBlock);
            
            // Emit the @catch block.
            CGF.EmitBlock(MatchedBlock);
            
            // Collect any cleanups for the catch variable.  The scope lasts until
            // the end of the catch body.
            CatchVarCleanups/*J*/= new CodeGenFunction.RunCleanupsScope(CGF);
            
            CGF.EmitAutoVarDecl($Deref(CatchParam));
            assert (CGF.HaveInsertPoint()) : "DeclStmt destroyed insert point?";
            
            // Initialize the catch variable.
            Value /*P*/ Tmp = CGF.Builder.CreateBitCast(Caught, 
                CGF.ConvertType(CatchParam.getType()));
            EmitInitOfCatchParam(CGF, Tmp, CatchParam);
            
            CGF.EmitStmt(CatchStmt.getCatchBody$Const());
            
            // We're done with the catch variable.
            CatchVarCleanups.ForceCleanup();
            
            CGF.EmitBranchThroughCleanup(new CodeGenFunction.JumpDest(FinallyEnd));
            
            CGF.EmitBlock(NextCatchBlock);
          } finally {
            if (CatchVarCleanups != null) { CatchVarCleanups.$destroy(); }
          }
        }
        
        CGF.ObjCEHValueStack.pop_back();
        
        // If nothing wanted anything to do with the caught exception,
        // kill the extract call.
        if (Caught.use_empty()) {
          Caught.eraseFromParent();
        }
        if (!AllMatched) {
          CGF.EmitBranchThroughCleanup(new CodeGenFunction.JumpDest(FinallyRethrow));
        }
        if (HasFinally) {
          // Emit the exception handler for the @catch blocks.
          CGF.EmitBlock(CatchHandler);
          
          // In theory we might now need a write hazard, but actually it's
          // unnecessary because there's no local-accessing code between
          // the try's write hazard and here.
          //Hazards.emitWriteHazard();
          
          // Extract the new exception and save it to the
          // propagating-exception slot.
          assert (PropagatingExnVar.isValid());
          CallInst /*P*/ NewCaught = CGF.EmitNounwindRuntimeCall(ObjCTypes.getExceptionExtractFn(), 
              new ArrayRef<Value /*P*/ >(ExceptionData.getPointer(), true), new Twine(/*KEEP_STR*/"caught"));
          CGF.Builder.CreateStore(NewCaught, new Address(PropagatingExnVar));
          
          // Don't pop the catch handler; the throw already did.
          CGF.Builder.CreateStore(CGF.Builder.getFalse(), new Address(CallTryExitVar));
          CGF.EmitBranchThroughCleanup(new CodeGenFunction.JumpDest(FinallyRethrow));
        }
      }
      
      // Insert read hazards as required in the new blocks.
      Hazards.emitHazardsInNewBlocks();
      
      // Pop the cleanup.
      CGF.Builder.restoreIP(new IRBuilderBase.InsertPoint(TryFallthroughIP));
      if (CGF.HaveInsertPoint()) {
        CGF.Builder.CreateStore(CGF.Builder.getTrue(), new Address(CallTryExitVar));
      }
      CGF.PopCleanupBlock();
      CGF.EmitBlock(FinallyEnd.getBlock(), true);
      
      // Emit the rethrow block.
      CGBuilderTy.InsertPoint SavedIP = CGF.Builder.saveAndClearIP();
      CGF.EmitBlock(FinallyRethrow.getBlock(), true);
      if (CGF.HaveInsertPoint()) {
        // If we have a propagating-exception variable, check it.
        Value /*P*/ PropagatingExn;
        if (PropagatingExnVar.isValid()) {
          PropagatingExn = CGF.Builder.CreateLoad(new Address(PropagatingExnVar));
          // Otherwise, just look in the buffer for the exception to throw.
        } else {
          CallInst /*P*/ Caught = CGF.EmitNounwindRuntimeCall(ObjCTypes.getExceptionExtractFn(), 
              new ArrayRef<Value /*P*/ >(ExceptionData.getPointer(), true));
          PropagatingExn = Caught;
        }
        
        CGF.EmitNounwindRuntimeCall(ObjCTypes.getExceptionThrowFn(), 
            new ArrayRef<Value /*P*/ >(PropagatingExn, true));
        CGF.Builder.CreateUnreachable();
      }
      
      CGF.Builder.restoreIP(new IRBuilderBase.InsertPoint(SavedIP));
    } finally {
      if (Hazards != null) { Hazards.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCMac::EmitThrowStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 4345,
   FQN="(anonymous namespace)::CGObjCMac::EmitThrowStmt", NM="_ZN12_GLOBAL__N_19CGObjCMac13EmitThrowStmtERN5clang7CodeGen15CodeGenFunctionERKNS1_15ObjCAtThrowStmtEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_19CGObjCMac13EmitThrowStmtERN5clang7CodeGen15CodeGenFunctionERKNS1_15ObjCAtThrowStmtEb")
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
    Value /*P*/ ExceptionAsObject;
    {
      
      /*const*/ Expr /*P*/ ThrowExpr = S.getThrowExpr$Const();
      if ((ThrowExpr != null)) {
        Value /*P*/ Exception = CGF.EmitObjCThrowOperand(ThrowExpr);
        ExceptionAsObject
           = CGF.Builder.CreateBitCast(Exception, ObjCTypes.ObjectPtrTy);
      } else {
        assert ((!CGF.ObjCEHValueStack.empty() && (CGF.ObjCEHValueStack.back() != null))) : "Unexpected rethrow outside @catch block.";
        ExceptionAsObject = CGF.ObjCEHValueStack.back();
      }
    }
    
    CGF.EmitRuntimeCall(ObjCTypes.getExceptionThrowFn(), new ArrayRef<Value /*P*/ >(ExceptionAsObject, true)).
        setDoesNotReturn();
    CGF.Builder.CreateUnreachable();
    
    // Clear the insertion point to indicate we are in unreachable code.
    if (ClearInsertionPoint) {
      CGF.Builder.ClearInsertionPoint();
    }
  }

  
  /// EmitObjCWeakRead - Code gen for loading value of a __weak
  /// object: objc_read_weak (id *src)
  ///
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCMac::EmitObjCWeakRead">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 4372,
   FQN="(anonymous namespace)::CGObjCMac::EmitObjCWeakRead", NM="_ZN12_GLOBAL__N_19CGObjCMac16EmitObjCWeakReadERN5clang7CodeGen15CodeGenFunctionENS2_7AddressE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_19CGObjCMac16EmitObjCWeakReadERN5clang7CodeGen15CodeGenFunctionENS2_7AddressE")
  //</editor-fold>
  @Override public Value /*P*/ EmitObjCWeakRead(final CodeGenFunction /*&*/ CGF, 
                  Address AddrWeakObj)/* override*/ {
    org.llvm.ir.Type /*P*/ DestTy = AddrWeakObj.getElementType();
    AddrWeakObj.$assignMove(CGF.Builder.CreateBitCast(new Address(AddrWeakObj), 
            ObjCTypes.PtrObjectPtrTy));
    Value /*P*/ read_weak = CGF.EmitNounwindRuntimeCall(ObjCTypes.getGcReadWeakFn(), 
        new ArrayRef<Value /*P*/ >(AddrWeakObj.getPointer(), true), new Twine(/*KEEP_STR*/"weakread"));
    read_weak = CGF.Builder.CreateBitCast(read_weak, DestTy);
    return read_weak;
  }

  
  /// EmitObjCWeakAssign - Code gen for assigning to a __weak object.
  /// objc_assign_weak (id src, id *dst)
  ///
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCMac::EmitObjCWeakAssign">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 4387,
   FQN="(anonymous namespace)::CGObjCMac::EmitObjCWeakAssign", NM="_ZN12_GLOBAL__N_19CGObjCMac18EmitObjCWeakAssignERN5clang7CodeGen15CodeGenFunctionEPN4llvm5ValueENS2_7AddressE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_19CGObjCMac18EmitObjCWeakAssignERN5clang7CodeGen15CodeGenFunctionEPN4llvm5ValueENS2_7AddressE")
  //</editor-fold>
  @Override public void EmitObjCWeakAssign(final CodeGenFunction /*&*/ CGF, 
                    Value /*P*/ src, Address dst)/* override*/ {
    org.llvm.ir.Type /*P*/ SrcTy = src.getType();
    if (!isa_PointerType(SrcTy)) {
      /*uint*/int Size = $ulong2uint(CGM.getDataLayout().getTypeAllocSize(SrcTy));
      assert ($lesseq_uint(Size, 8)) : "does not support size > 8";
      src = (Size == 4) ? CGF.Builder.CreateBitCast(src, ObjCTypes.IntTy) : CGF.Builder.CreateBitCast(src, ObjCTypes.LongLongTy);
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
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCMac::EmitObjCGlobalAssign">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 4407,
   FQN="(anonymous namespace)::CGObjCMac::EmitObjCGlobalAssign", NM="_ZN12_GLOBAL__N_19CGObjCMac20EmitObjCGlobalAssignERN5clang7CodeGen15CodeGenFunctionEPN4llvm5ValueENS2_7AddressEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_19CGObjCMac20EmitObjCGlobalAssignERN5clang7CodeGen15CodeGenFunctionEPN4llvm5ValueENS2_7AddressEb")
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
      src = (Size == 4) ? CGF.Builder.CreateBitCast(src, ObjCTypes.IntTy) : CGF.Builder.CreateBitCast(src, ObjCTypes.LongLongTy);
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
  /// objc_assign_ivar (id src, id *dst, ptrdiff_t ivaroffset)
  ///
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCMac::EmitObjCIvarAssign">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 4432,
   FQN="(anonymous namespace)::CGObjCMac::EmitObjCIvarAssign", NM="_ZN12_GLOBAL__N_19CGObjCMac18EmitObjCIvarAssignERN5clang7CodeGen15CodeGenFunctionEPN4llvm5ValueENS2_7AddressES7_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_19CGObjCMac18EmitObjCIvarAssignERN5clang7CodeGen15CodeGenFunctionEPN4llvm5ValueENS2_7AddressES7_")
  //</editor-fold>
  @Override public void EmitObjCIvarAssign(final CodeGenFunction /*&*/ CGF, 
                    Value /*P*/ src, Address dst, 
                    Value /*P*/ ivarOffset)/* override*/ {
    assert ((ivarOffset != null)) : "EmitObjCIvarAssign - ivarOffset is NULL";
    org.llvm.ir.Type /*P*/ SrcTy = src.getType();
    if (!isa_PointerType(SrcTy)) {
      /*uint*/int Size = $ulong2uint(CGM.getDataLayout().getTypeAllocSize(SrcTy));
      assert ($lesseq_uint(Size, 8)) : "does not support size > 8";
      src = (Size == 4) ? CGF.Builder.CreateBitCast(src, ObjCTypes.IntTy) : CGF.Builder.CreateBitCast(src, ObjCTypes.LongLongTy);
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
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCMac::EmitObjCStrongCastAssign">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 4453,
   FQN="(anonymous namespace)::CGObjCMac::EmitObjCStrongCastAssign", NM="_ZN12_GLOBAL__N_19CGObjCMac24EmitObjCStrongCastAssignERN5clang7CodeGen15CodeGenFunctionEPN4llvm5ValueENS2_7AddressE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_19CGObjCMac24EmitObjCStrongCastAssignERN5clang7CodeGen15CodeGenFunctionEPN4llvm5ValueENS2_7AddressE")
  //</editor-fold>
  @Override public void EmitObjCStrongCastAssign(final CodeGenFunction /*&*/ CGF, 
                          Value /*P*/ src, Address dst)/* override*/ {
    org.llvm.ir.Type /*P*/ SrcTy = src.getType();
    if (!isa_PointerType(SrcTy)) {
      /*uint*/int Size = $ulong2uint(CGM.getDataLayout().getTypeAllocSize(SrcTy));
      assert ($lesseq_uint(Size, 8)) : "does not support size > 8";
      src = (Size == 4) ? CGF.Builder.CreateBitCast(src, ObjCTypes.IntTy) : CGF.Builder.CreateBitCast(src, ObjCTypes.LongLongTy);
      src = CGF.Builder.CreateIntToPtr(src, ObjCTypes.Int8PtrTy);
    }
    src = CGF.Builder.CreateBitCast(src, ObjCTypes.ObjectPtrTy);
    dst.$assignMove(CGF.Builder.CreateBitCast(new Address(dst), ObjCTypes.PtrObjectPtrTy));
    Value /*P*/ args[/*2*/] = new Value /*P*/  [/*2*/] {src, dst.getPointer()};
    CGF.EmitNounwindRuntimeCall(ObjCTypes.getGcAssignStrongCastFn(), 
        new ArrayRef<Value /*P*/ >(args, true), new Twine(/*KEEP_STR*/"strongassign"));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCMac::EmitGCMemmoveCollectable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 4470,
   FQN="(anonymous namespace)::CGObjCMac::EmitGCMemmoveCollectable", NM="_ZN12_GLOBAL__N_19CGObjCMac24EmitGCMemmoveCollectableERN5clang7CodeGen15CodeGenFunctionENS2_7AddressES5_PN4llvm5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_19CGObjCMac24EmitGCMemmoveCollectableERN5clang7CodeGen15CodeGenFunctionENS2_7AddressES5_PN4llvm5ValueE")
  //</editor-fold>
  @Override public void EmitGCMemmoveCollectable(final CodeGenFunction /*&*/ CGF, 
                          Address DestPtr, 
                          Address SrcPtr, 
                          Value /*P*/ size)/* override*/ {
    SrcPtr.$assignMove(CGF.Builder.CreateBitCast(new Address(SrcPtr), ObjCTypes.Int8PtrTy));
    DestPtr.$assignMove(CGF.Builder.CreateBitCast(new Address(DestPtr), ObjCTypes.Int8PtrTy));
    Value /*P*/ args[/*3*/] = new Value /*P*/  [/*3*/] {DestPtr.getPointer(), SrcPtr.getPointer(), size};
    CGF.EmitNounwindRuntimeCall(ObjCTypes.GcMemmoveCollectableFn(), new ArrayRef<Value /*P*/ >(args, true));
  }

  
  
  /// EmitObjCValueForIvar - Code Gen for ivar reference.
  ///
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCMac::EmitObjCValueForIvar">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 4482,
   FQN="(anonymous namespace)::CGObjCMac::EmitObjCValueForIvar", NM="_ZN12_GLOBAL__N_19CGObjCMac20EmitObjCValueForIvarERN5clang7CodeGen15CodeGenFunctionENS1_8QualTypeEPN4llvm5ValueEPKNS1_12ObjCIvarDeclEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_19CGObjCMac20EmitObjCValueForIvarERN5clang7CodeGen15CodeGenFunctionENS1_8QualTypeEPN4llvm5ValueEPKNS1_12ObjCIvarDeclEj")
  //</editor-fold>
  @Override public LValue EmitObjCValueForIvar(final CodeGenFunction /*&*/ CGF, 
                      QualType ObjectTy, 
                      Value /*P*/ BaseValue, 
                      /*const*/ ObjCIvarDecl /*P*/ Ivar, 
                      /*uint*/int CVRQualifiers)/* override*/ {
    /*const*/ ObjCInterfaceDecl /*P*/ ID = ObjectTy.$arrow().getAs(ObjCObjectType.class).getInterface();
    return EmitValueForIvarAtOffset(CGF, ID, BaseValue, Ivar, CVRQualifiers, 
        EmitIvarOffset(CGF, ID, Ivar));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCMac::EmitIvarOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 4493,
   FQN="(anonymous namespace)::CGObjCMac::EmitIvarOffset", NM="_ZN12_GLOBAL__N_19CGObjCMac14EmitIvarOffsetERN5clang7CodeGen15CodeGenFunctionEPKNS1_17ObjCInterfaceDeclEPKNS1_12ObjCIvarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_19CGObjCMac14EmitIvarOffsetERN5clang7CodeGen15CodeGenFunctionEPKNS1_17ObjCInterfaceDeclEPKNS1_12ObjCIvarDeclE")
  //</editor-fold>
  @Override public Value /*P*/ EmitIvarOffset(final CodeGenFunction /*&*/ CGF, 
                /*const*/ ObjCInterfaceDecl /*P*/ Interface, 
                /*const*/ ObjCIvarDecl /*P*/ Ivar)/* override*/ {
    long/*uint64_t*/ Offset = ComputeIvarBaseOffset_1(CGM, Interface, Ivar);
    return ConstantInt.get(CGM.getTypes().ConvertType(CGM.getContext().LongTy.$QualType()), 
        Offset);
  }

  
  /// GetClassGlobal - Return the global variable for the Objective-C
  /// class of the given name.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCMac::GetClassGlobal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 1268,
   FQN="(anonymous namespace)::CGObjCMac::GetClassGlobal", NM="_ZN12_GLOBAL__N_19CGObjCMac14GetClassGlobalEN4llvm9StringRefEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_19CGObjCMac14GetClassGlobalEN4llvm9StringRefEb")
  //</editor-fold>
  @Override public GlobalVariable /*P*/ GetClassGlobal(StringRef Name)/* override*/ {
    return GetClassGlobal(Name, 
                false);
  }
  @Override public GlobalVariable /*P*/ GetClassGlobal(StringRef Name, 
                boolean Weak/*= false*/)/* override*/ {
    throw new llvm_unreachable("CGObjCMac::GetClassGlobal");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCMac::~CGObjCMac">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 1072,
   FQN="(anonymous namespace)::CGObjCMac::~CGObjCMac", NM="_ZN12_GLOBAL__N_19CGObjCMacD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_19CGObjCMacD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + "ObjCTypes=" + ObjCTypes // NOI18N
              + super.toString(); // NOI18N
  }
}
