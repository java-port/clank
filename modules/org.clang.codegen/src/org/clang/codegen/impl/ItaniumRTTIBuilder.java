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

import org.clank.support.*;
import org.clank.support.aliases.*;
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
import static org.clang.ast.java.AstDeclarationsRTTI.cast_CXXRecordDecl;
import static org.clang.ast.java.AstTypesRTTI.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumRTTIBuilder">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 2379,
 FQN="(anonymous namespace)::ItaniumRTTIBuilder", NM="_ZN12_GLOBAL__N_118ItaniumRTTIBuilderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZN12_GLOBAL__N_118ItaniumRTTIBuilderE")
//</editor-fold>
public class ItaniumRTTIBuilder implements Destructors.ClassWithDestructor {
  private final CodeGenModule /*&*/ CGM; // Per-module state.
  private final LLVMContext /*&*/ VMContext;
  private final /*const*/ ItaniumCXXABI /*&*/ CXXABI; // Per-module state.
  
  /// Fields - The fields of the RTTI descriptor currently being built.
  private SmallVector<Constant /*P*/ > Fields;
  
  /// GetAddrOfTypeName - Returns the mangled type name of the given type.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumRTTIBuilder::GetAddrOfTypeName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 2467,
   FQN="(anonymous namespace)::ItaniumRTTIBuilder::GetAddrOfTypeName", NM="_ZN12_GLOBAL__N_118ItaniumRTTIBuilder17GetAddrOfTypeNameEN5clang8QualTypeEN4llvm11GlobalValue12LinkageTypesE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZN12_GLOBAL__N_118ItaniumRTTIBuilder17GetAddrOfTypeNameEN5clang8QualTypeEN4llvm11GlobalValue12LinkageTypesE")
  //</editor-fold>
  private GlobalVariable /*P*/ GetAddrOfTypeName(QualType Ty, GlobalVariable.LinkageTypes Linkage) {
    raw_svector_ostream Out = null;
    try {
      SmallString/*<256>*/ Name/*J*/= new SmallString/*<256>*/(256);
      Out/*J*/= new raw_svector_ostream(Name);
      CGM.getCXXABI().getMangleContext().mangleCXXRTTIName(new QualType(Ty), Out);
      
      // We know that the mangled name of the type starts at index 4 of the
      // mangled name of the typename, so we can just index into it in order to
      // get the mangled name of the type.
      Constant /*P*/ Init = ConstantDataArray.getString(VMContext, 
          Name.substr(4));
      
      GlobalVariable /*P*/ GV = CGM.CreateOrReplaceCXXRuntimeVariable(Name.$StringRef(), Init.getType(), Linkage);
      
      GV.setInitializer(Init);
      
      return GV;
    } finally {
      if (Out != null) { Out.$destroy(); }
    }
  }

  
  /// GetAddrOfExternalRTTIDescriptor - Returns the constant for the RTTI
  /// descriptor of the given type.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumRTTIBuilder::GetAddrOfExternalRTTIDescriptor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 2487,
   FQN="(anonymous namespace)::ItaniumRTTIBuilder::GetAddrOfExternalRTTIDescriptor", NM="_ZN12_GLOBAL__N_118ItaniumRTTIBuilder31GetAddrOfExternalRTTIDescriptorEN5clang8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZN12_GLOBAL__N_118ItaniumRTTIBuilder31GetAddrOfExternalRTTIDescriptorEN5clang8QualTypeE")
  //</editor-fold>
  private Constant /*P*/ GetAddrOfExternalRTTIDescriptor(QualType Ty) {
    raw_svector_ostream Out = null;
    try {
      // Mangle the RTTI name.
      SmallString/*<256>*/ Name/*J*/= new SmallString/*<256>*/(256);
      Out/*J*/= new raw_svector_ostream(Name);
      CGM.getCXXABI().getMangleContext().mangleCXXRTTI(new QualType(Ty), Out);
      
      // Look for an existing global.
      GlobalVariable /*P*/ GV = CGM.getModule().getNamedGlobal(Name.$StringRef());
      if (!(GV != null)) {
        // Create a new global variable.
        GV = /*NEW_EXPR [GlobalVariable::new]*/GlobalVariable.$new_GlobalVariable((type$ptr<?> New$Mem)->{
            return new GlobalVariable(CGM.getModule(), CGM.Unnamed_field9.Int8PtrTy, 
            /*Constant=*/ true, 
            GlobalValue.LinkageTypes.ExternalLinkage, (Constant /*P*/ )null, 
            new Twine(Name));
         });
        {
          /*const*/ RecordType /*P*/ RecordTy = dyn_cast_RecordType(Ty);
          if ((RecordTy != null)) {
            /*const*/ CXXRecordDecl /*P*/ RD = cast_CXXRecordDecl(RecordTy.getDecl());
            if (RD.hasAttr(DLLImportAttr.class)) {
              GV.setDLLStorageClass(GlobalVariable.DLLStorageClassTypes.DLLImportStorageClass);
            }
          }
        }
      }
      
      return ConstantExpr.getBitCast(GV, CGM.Unnamed_field9.Int8PtrTy);
    } finally {
      if (Out != null) { Out.$destroy(); }
    }
  }

  
  /// BuildVTablePointer - Build the vtable pointer for the given type.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumRTTIBuilder::BuildVTablePointer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 2719,
   FQN="(anonymous namespace)::ItaniumRTTIBuilder::BuildVTablePointer", NM="_ZN12_GLOBAL__N_118ItaniumRTTIBuilder18BuildVTablePointerEPKN5clang4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZN12_GLOBAL__N_118ItaniumRTTIBuilder18BuildVTablePointerEPKN5clang4TypeE")
  //</editor-fold>
  private void BuildVTablePointer(/*const*/ org.clang.ast.Type /*P*/ Ty) {
    // abi::__class_type_info.
    final/*static*/ /*const*/char$ptr/*char P*//*const*/ ClassTypeInfo = BuildVTablePointer$$.ClassTypeInfo;
    // abi::__si_class_type_info.
    final/*static*/ /*const*/char$ptr/*char P*//*const*/ SIClassTypeInfo = BuildVTablePointer$$.SIClassTypeInfo;
    // abi::__vmi_class_type_info.
    final/*static*/ /*const*/char$ptr/*char P*//*const*/ VMIClassTypeInfo = BuildVTablePointer$$.VMIClassTypeInfo;
    
    /*const*/char$ptr/*char P*/ VTableName = null;
    switch (Ty.getTypeClass()) {
     case DependentSizedArray:
     case DependentSizedExtVector:
     case UnresolvedUsing:
     case Paren:
     case Typedef:
     case Adjusted:
     case Decayed:
     case TypeOfExpr:
     case TypeOf:
     case Decltype:
     case UnaryTransform:
     case Elaborated:
     case Attributed:
     case TemplateTypeParm:
     case SubstTemplateTypeParm:
     case SubstTemplateTypeParmPack:
     case TemplateSpecialization:
     case InjectedClassName:
     case DependentName:
     case DependentTemplateSpecialization:
     case PackExpansion:
      throw new llvm_unreachable("Non-canonical and dependent types shouldn't get here");
     case LValueReference:
     case RValueReference:
      throw new llvm_unreachable("References shouldn't get here");
     case Auto:
      throw new llvm_unreachable("Undeduced auto type shouldn't get here");
     case Pipe:
      throw new llvm_unreachable("Pipe types shouldn't get here");
     case Builtin:
     case Vector:
     case ExtVector:
     case Complex:
     case Atomic:
     case BlockPointer:
      // abi::__fundamental_type_info.
      VTableName = $("_ZTVN10__cxxabiv123__fundamental_type_infoE");
      break;
     case ConstantArray:
     case IncompleteArray:
     case VariableArray:
      // abi::__array_type_info.
      VTableName = $("_ZTVN10__cxxabiv117__array_type_infoE");
      break;
     case FunctionNoProto:
     case FunctionProto:
      // abi::__function_type_info.
      VTableName = $("_ZTVN10__cxxabiv120__function_type_infoE");
      break;
     case Enum:
      // abi::__enum_type_info.
      VTableName = $("_ZTVN10__cxxabiv116__enum_type_infoE");
      break;
     case Record:
      {
        /*const*/ CXXRecordDecl /*P*/ RD = cast_CXXRecordDecl(cast_RecordType(Ty).getDecl());
        if (!RD.hasDefinition() || !(RD.getNumBases() != 0)) {
          VTableName = $tryClone(ClassTypeInfo);
        } else if (ItaniumCXXABIStatics.CanUseSingleInheritance(RD)) {
          VTableName = $tryClone(SIClassTypeInfo);
        } else {
          VTableName = $tryClone(VMIClassTypeInfo);
        }
        
        break;
      }
     case ObjCObject:
      // Ignore protocol qualifiers.
      Ty = cast_ObjCObjectType(Ty).getBaseType().getTypePtr();
      
      // Handle id and Class.
      if (isa_BuiltinType(Ty)) {
        VTableName = $tryClone(ClassTypeInfo);
        break;
      }
      assert (isa_ObjCInterfaceType(Ty));
     case ObjCInterface:
      // Fall through.
      if ((cast_ObjCInterfaceType(Ty).getDecl().getSuperClass() != null)) {
        VTableName = $tryClone(SIClassTypeInfo);
      } else {
        VTableName = $tryClone(ClassTypeInfo);
      }
      break;
     case ObjCObjectPointer:
     case Pointer:
      // abi::__pointer_type_info.
      VTableName = $("_ZTVN10__cxxabiv119__pointer_type_infoE");
      break;
     case MemberPointer:
      // abi::__pointer_to_member_type_info.
      VTableName = $("_ZTVN10__cxxabiv129__pointer_to_member_type_infoE");
      break;
    }
    
    Constant /*P*/ VTable = CGM.getModule().getOrInsertGlobal(new StringRef(VTableName), CGM.Unnamed_field9.Int8PtrTy);
    
    org.llvm.ir.Type /*P*/ PtrDiffTy = CGM.getTypes().ConvertType(CGM.getContext().getPointerDiffType());
    
    // The vtable address point is 2.
    Constant /*P*/ Two = ConstantInt.get(PtrDiffTy, $int2ulong(2));
    VTable
       = ConstantExpr.getInBoundsGetElementPtr(CGM.Unnamed_field9.Int8PtrTy, VTable, Two);
    VTable = ConstantExpr.getBitCast(VTable, CGM.Unnamed_field9.Int8PtrTy);
    
    Fields.push_back(VTable);
  }
  private static final class BuildVTablePointer$$ {
    static final/*static*/ /*const*/char$ptr/*char P*//*const*/ ClassTypeInfo = $("_ZTVN10__cxxabiv117__class_type_infoE");
    static final/*static*/ /*const*/char$ptr/*char P*//*const*/ SIClassTypeInfo = $("_ZTVN10__cxxabiv120__si_class_type_infoE");
    static final/*static*/ /*const*/char$ptr/*char P*//*const*/ VMIClassTypeInfo = $("_ZTVN10__cxxabiv121__vmi_class_type_infoE");
  }

  
  /// BuildSIClassTypeInfo - Build an abi::__si_class_type_info, used for single
  /// inheritance, according to the Itanium C++ ABI, 2.9.5p6b.
  
  /// BuildSIClassTypeInfo - Build an abi::__si_class_type_info, used for single
  /// inheritance, according to the Itanium C++ ABI, 2.95p6b.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumRTTIBuilder::BuildSIClassTypeInfo">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 3126,
   FQN="(anonymous namespace)::ItaniumRTTIBuilder::BuildSIClassTypeInfo", NM="_ZN12_GLOBAL__N_118ItaniumRTTIBuilder20BuildSIClassTypeInfoEPKN5clang13CXXRecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZN12_GLOBAL__N_118ItaniumRTTIBuilder20BuildSIClassTypeInfoEPKN5clang13CXXRecordDeclE")
  //</editor-fold>
  private void BuildSIClassTypeInfo(/*const*/ CXXRecordDecl /*P*/ RD) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // Itanium C++ ABI 2.9.5p6b:
      // It adds to abi::__class_type_info a single member pointing to the
      // type_info structure for the base type,
      Constant /*P*/ BaseTypeInfo = $c$.clean($c$.track(new ItaniumRTTIBuilder(CXXABI)).BuildTypeInfo(RD.bases_begin$Const().$arrow().getType()));
      Fields.push_back(BaseTypeInfo);
    } finally {
      $c$.$destroy();
    }
  }

  
  /// BuildVMIClassTypeInfo - Build an abi::__vmi_class_type_info, used for
  /// classes with bases that do not satisfy the abi::__si_class_type_info
  /// constraints, according ti the Itanium C++ ABI, 2.9.5p5c.
  
  /// BuildVMIClassTypeInfo - Build an abi::__vmi_class_type_info, used for
  /// classes with bases that do not satisfy the abi::__si_class_type_info
  /// constraints, according ti the Itanium C++ ABI, 2.9.5p5c.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumRTTIBuilder::BuildVMIClassTypeInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 3198,
   FQN="(anonymous namespace)::ItaniumRTTIBuilder::BuildVMIClassTypeInfo", NM="_ZN12_GLOBAL__N_118ItaniumRTTIBuilder21BuildVMIClassTypeInfoEPKN5clang13CXXRecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZN12_GLOBAL__N_118ItaniumRTTIBuilder21BuildVMIClassTypeInfoEPKN5clang13CXXRecordDeclE")
  //</editor-fold>
  private void BuildVMIClassTypeInfo(/*const*/ CXXRecordDecl /*P*/ RD) {
    org.llvm.ir.Type /*P*/ UnsignedIntLTy = CGM.getTypes().ConvertType(CGM.getContext().UnsignedIntTy.$QualType());
    
    // Itanium C++ ABI 2.9.5p6c:
    //   __flags is a word with flags describing details about the class
    //   structure, which may be referenced by using the __flags_masks
    //   enumeration. These flags refer to both direct and indirect bases.
    /*uint*/int Flags = ItaniumCXXABIStatics.ComputeVMIClassTypeInfoFlags(RD);
    Fields.push_back(ConstantInt.get(UnsignedIntLTy, $uint2ulong(Flags)));
    
    // Itanium C++ ABI 2.9.5p6c:
    //   __base_count is a word with the number of direct proper base class
    //   descriptions that follow.
    Fields.push_back(ConstantInt.get(UnsignedIntLTy, $uint2ulong(RD.getNumBases())));
    if (!(RD.getNumBases() != 0)) {
      return;
    }
    
    org.llvm.ir.Type /*P*/ LongLTy = CGM.getTypes().ConvertType(CGM.getContext().LongTy.$QualType());
    
    // Now add the base class descriptions.
    
    // Itanium C++ ABI 2.9.5p6c:
    //   __base_info[] is an array of base class descriptions -- one for every
    //   direct proper base. Each description is of the type:
    //
    //   struct abi::__base_class_type_info {
    //   public:
    //     const __class_type_info *__base_type;
    //     long __offset_flags;
    //
    //     enum __offset_flags_masks {
    //       __virtual_mask = 0x1,
    //       __public_mask = 0x2,
    //       __offset_shift = 8
    //     };
    //   };
    for (final /*const*/ CXXBaseSpecifier /*&*/ Base : RD.bases$Const()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // The __base_type member points to the RTTI for the base type.
        Fields.push_back($c$.track(new ItaniumRTTIBuilder(CXXABI)).BuildTypeInfo(Base.getType())); $c$.clean();
        
        /*const*/ CXXRecordDecl /*P*/ BaseDecl = cast_CXXRecordDecl(Base.getType().$arrow().getAs$RecordType().getDecl());
        
        long/*int64_t*/ OffsetFlags = 0;
        
        // All but the lower 8 bits of __offset_flags are a signed offset.
        // For a non-virtual base, this is the offset in the object of the base
        // subobject. For a virtual base, this is the offset in the virtual table of
        // the virtual base offset for the virtual base referenced (negative).
        CharUnits Offset/*J*/= new CharUnits();
        if (Base.isVirtual()) {
          Offset.$assignMove(
              CGM.getItaniumVTableContext().getVirtualBaseOffsetOffset(RD, BaseDecl)
          );
        } else {
          final /*const*/ ASTRecordLayout /*&*/ Layout = CGM.getContext().getASTRecordLayout(RD);
          Offset.$assignMove(Layout.getBaseClassOffset(BaseDecl));
        }
        ;
        
        OffsetFlags = ((long/*uint64_t*/)(Offset.getQuantity())) << 8;
        
        // The low-order byte of __offset_flags contains flags, as given by the
        // masks from the enumeration __offset_flags_masks.
        if (Base.isVirtual()) {
          OffsetFlags |= $uint2llong(BCTI_Virtual);
        }
        if (Base.getAccessSpecifier() == AccessSpecifier.AS_public) {
          OffsetFlags |= $uint2llong(BCTI_Public);
        }
        
        Fields.push_back(ConstantInt.get(LongLTy, OffsetFlags));
      } finally {
        $c$.$destroy();
      }
    }
  }

  
  /// BuildPointerTypeInfo - Build an abi::__pointer_type_info struct, used
  /// for pointer types.
  
  /// BuildPointerTypeInfo - Build an abi::__pointer_type_info struct,
  /// used for pointer types.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumRTTIBuilder::BuildPointerTypeInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 3274,
   FQN="(anonymous namespace)::ItaniumRTTIBuilder::BuildPointerTypeInfo", NM="_ZN12_GLOBAL__N_118ItaniumRTTIBuilder20BuildPointerTypeInfoEN5clang8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZN12_GLOBAL__N_118ItaniumRTTIBuilder20BuildPointerTypeInfoEN5clang8QualTypeE")
  //</editor-fold>
  private void BuildPointerTypeInfo(QualType PointeeTy) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      Qualifiers Quals/*J*/= new Qualifiers();
      QualType UnqualifiedPointeeTy = CGM.getContext().getUnqualifiedArrayType(new QualType(PointeeTy), Quals);
      
      // Itanium C++ ABI 2.9.5p7:
      //   __flags is a flag word describing the cv-qualification and other
      //   attributes of the type pointed to
      /*uint*/int Flags = ItaniumCXXABIStatics.ComputeQualifierFlags(new Qualifiers(Quals));
      
      // Itanium C++ ABI 2.9.5p7:
      //   When the abi::__pbase_type_info is for a direct or indirect pointer to an
      //   incomplete class type, the incomplete target type flag is set.
      if (ItaniumCXXABIStatics.ContainsIncompleteClassType(new QualType(UnqualifiedPointeeTy))) {
        Flags |= PTI_Incomplete;
      }
      
      org.llvm.ir.Type /*P*/ UnsignedIntLTy = CGM.getTypes().ConvertType(CGM.getContext().UnsignedIntTy.$QualType());
      Fields.push_back(ConstantInt.get(UnsignedIntLTy, $uint2ulong(Flags)));
      
      // Itanium C++ ABI 2.9.5p7:
      //  __pointee is a pointer to the std::type_info derivation for the
      //  unqualified type being pointed to.
      Constant /*P*/ PointeeTypeInfo = $c$.clean($c$.track(new ItaniumRTTIBuilder(CXXABI)).BuildTypeInfo(new QualType(UnqualifiedPointeeTy)));
      Fields.push_back(PointeeTypeInfo);
    } finally {
      $c$.$destroy();
    }
  }

  
  /// BuildObjCObjectTypeInfo - Build the appropriate kind of
  /// type_info for an object type.
  
  /// BuildObjCObjectTypeInfo - Build the appropriate kind of type_info
  /// for the given Objective-C object type.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumRTTIBuilder::BuildObjCObjectTypeInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 3101,
   FQN="(anonymous namespace)::ItaniumRTTIBuilder::BuildObjCObjectTypeInfo", NM="_ZN12_GLOBAL__N_118ItaniumRTTIBuilder23BuildObjCObjectTypeInfoEPKN5clang14ObjCObjectTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZN12_GLOBAL__N_118ItaniumRTTIBuilder23BuildObjCObjectTypeInfoEPKN5clang14ObjCObjectTypeE")
  //</editor-fold>
  private void BuildObjCObjectTypeInfo(/*const*/ ObjCObjectType /*P*/ OT) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // Drop qualifiers.
      /*const*/ org.clang.ast.Type /*P*/ T = OT.getBaseType().getTypePtr();
      assert (isa_BuiltinType(T) || isa_ObjCInterfaceType(T));
      
      // The builtin types are abi::__class_type_infos and don't require
      // extra fields.
      if (isa_BuiltinType(T)) {
        return;
      }
      
      ObjCInterfaceDecl /*P*/ Class = cast_ObjCInterfaceType(T).getDecl();
      ObjCInterfaceDecl /*P*/ Super = Class.getSuperClass();
      
      // Root classes are also __class_type_info.
      if (!(Super != null)) {
        return;
      }
      
      QualType SuperTy = CGM.getContext().getObjCInterfaceType(Super);
      
      // Everything else is single inheritance.
      Constant /*P*/ BaseTypeInfo = $c$.clean($c$.track(new ItaniumRTTIBuilder(CXXABI)).BuildTypeInfo(new QualType(SuperTy)));
      Fields.push_back(BaseTypeInfo);
    } finally {
      $c$.$destroy();
    }
  }

  
  /// BuildPointerToMemberTypeInfo - Build an abi::__pointer_to_member_type_info
  /// struct, used for member pointer types.
  
  /// BuildPointerToMemberTypeInfo - Build an abi::__pointer_to_member_type_info
  /// struct, used for member pointer types.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumRTTIBuilder::BuildPointerToMemberTypeInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 3304,
   FQN="(anonymous namespace)::ItaniumRTTIBuilder::BuildPointerToMemberTypeInfo", NM="_ZN12_GLOBAL__N_118ItaniumRTTIBuilder28BuildPointerToMemberTypeInfoEPKN5clang17MemberPointerTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZN12_GLOBAL__N_118ItaniumRTTIBuilder28BuildPointerToMemberTypeInfoEPKN5clang17MemberPointerTypeE")
  //</editor-fold>
  private void BuildPointerToMemberTypeInfo(/*const*/ MemberPointerType /*P*/ Ty) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      QualType PointeeTy = Ty.getPointeeType();
      
      Qualifiers Quals/*J*/= new Qualifiers();
      QualType UnqualifiedPointeeTy = CGM.getContext().getUnqualifiedArrayType(new QualType(PointeeTy), Quals);
      
      // Itanium C++ ABI 2.9.5p7:
      //   __flags is a flag word describing the cv-qualification and other
      //   attributes of the type pointed to.
      /*uint*/int Flags = ItaniumCXXABIStatics.ComputeQualifierFlags(new Qualifiers(Quals));
      
      /*const*/ RecordType /*P*/ ClassType = cast_RecordType(Ty.__getClass());
      
      // Itanium C++ ABI 2.9.5p7:
      //   When the abi::__pbase_type_info is for a direct or indirect pointer to an
      //   incomplete class type, the incomplete target type flag is set.
      if (ItaniumCXXABIStatics.ContainsIncompleteClassType(new QualType(UnqualifiedPointeeTy))) {
        Flags |= PTI_Incomplete;
      }
      if (ItaniumCXXABIStatics.IsIncompleteClassType(ClassType)) {
        Flags |= PTI_ContainingClassIncomplete;
      }
      
      org.llvm.ir.Type /*P*/ UnsignedIntLTy = CGM.getTypes().ConvertType(CGM.getContext().UnsignedIntTy.$QualType());
      Fields.push_back(ConstantInt.get(UnsignedIntLTy, $uint2ulong(Flags)));
      
      // Itanium C++ ABI 2.9.5p7:
      //   __pointee is a pointer to the std::type_info derivation for the
      //   unqualified type being pointed to.
      Constant /*P*/ PointeeTypeInfo = $c$.clean($c$.track(new ItaniumRTTIBuilder(CXXABI)).BuildTypeInfo(new QualType(UnqualifiedPointeeTy)));
      Fields.push_back(PointeeTypeInfo);
      
      // Itanium C++ ABI 2.9.5p9:
      //   __context is a pointer to an abi::__class_type_info corresponding to the
      //   class type containing the member pointed to
      //   (e.g., the "A" in "int A::*").
      Fields.push_back($c$.track(new ItaniumRTTIBuilder(CXXABI)).BuildTypeInfo(new QualType(ClassType, 0))); $c$.clean();
    } finally {
      $c$.$destroy();
    }
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumRTTIBuilder::ItaniumRTTIBuilder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 2420,
   FQN="(anonymous namespace)::ItaniumRTTIBuilder::ItaniumRTTIBuilder", NM="_ZN12_GLOBAL__N_118ItaniumRTTIBuilderC1ERKNS_13ItaniumCXXABIE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZN12_GLOBAL__N_118ItaniumRTTIBuilderC1ERKNS_13ItaniumCXXABIE")
  //</editor-fold>
  public ItaniumRTTIBuilder(final /*const*/ ItaniumCXXABI /*&*/ ABI) {
    // : CGM(ABI.CGM), VMContext(CGM.getModule().getContext()), CXXABI(ABI), Fields() 
    //START JInit
    this./*&*/CGM=/*&*/ABI.CGM;
    this./*&*/VMContext=/*&*/CGM.getModule().getContext();
    this./*&*/CXXABI=/*&*/ABI;
    this.Fields = new SmallVector<Constant /*P*/ >(16, (Constant /*P*/ )null);
    //END JInit
  }

  
  // Pointer type info flags.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumRTTIBuilder::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 2424,
   FQN="(anonymous namespace)::ItaniumRTTIBuilder::(anonymous)", NM="_ZN12_GLOBAL__N_118ItaniumRTTIBuilderE_Unnamed_enum",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZN12_GLOBAL__N_118ItaniumRTTIBuilderE_Unnamed_enum")
  //</editor-fold>
  /*enum ANONYMOUS_INT_CONSTANTS {*/
    /// PTI_Const - Type has const qualifier.
    public static final /*uint*/int PTI_Const = 0x1;
    
    /// PTI_Volatile - Type has volatile qualifier.
    public static final /*uint*/int PTI_Volatile = 0x2;
    
    /// PTI_Restrict - Type has restrict qualifier.
    public static final /*uint*/int PTI_Restrict = 0x4;
    
    /// PTI_Incomplete - Type is incomplete.
    public static final /*uint*/int PTI_Incomplete = 0x8;
    
    /// PTI_ContainingClassIncomplete - Containing class is incomplete.
    /// (in pointer to member).
    public static final /*uint*/int PTI_ContainingClassIncomplete = 0x10;
  /*}*/;
  
  // VMI type info flags.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumRTTIBuilder::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 2443,
   FQN="(anonymous namespace)::ItaniumRTTIBuilder::(anonymous)", NM="_ZN12_GLOBAL__N_118ItaniumRTTIBuilderE_Unnamed_enum1",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZN12_GLOBAL__N_118ItaniumRTTIBuilderE_Unnamed_enum1")
  //</editor-fold>
  /*enum ANONYMOUS_INT_CONSTANTS {*/
    /// VMI_NonDiamondRepeat - Class has non-diamond repeated inheritance.
    public static final /*uint*/int VMI_NonDiamondRepeat = 0x1;
    
    /// VMI_DiamondShaped - Class is diamond shaped.
    public static final /*uint*/int VMI_DiamondShaped = 0x2;
  /*}*/;
  
  // Base class type info flags.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumRTTIBuilder::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 2452,
   FQN="(anonymous namespace)::ItaniumRTTIBuilder::(anonymous)", NM="_ZN12_GLOBAL__N_118ItaniumRTTIBuilderE_Unnamed_enum2",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZN12_GLOBAL__N_118ItaniumRTTIBuilderE_Unnamed_enum2")
  //</editor-fold>
  /*enum ANONYMOUS_INT_CONSTANTS {*/
    /// BCTI_Virtual - Base class is virtual.
    public static final /*uint*/int BCTI_Virtual = 0x1;
    
    /// BCTI_Public - Base class is public.
    public static final /*uint*/int BCTI_Public = 0x2;
  /*}*/;
  
  /// BuildTypeInfo - Build the RTTI type info struct for the given type.
  ///
  /// \param Force - true to force the creation of this RTTI value
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumRTTIBuilder::BuildTypeInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 2895,
   FQN="(anonymous namespace)::ItaniumRTTIBuilder::BuildTypeInfo", NM="_ZN12_GLOBAL__N_118ItaniumRTTIBuilder13BuildTypeInfoEN5clang8QualTypeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZN12_GLOBAL__N_118ItaniumRTTIBuilder13BuildTypeInfoEN5clang8QualTypeEb")
  //</editor-fold>
  public Constant /*P*/ BuildTypeInfo(QualType Ty) {
    return BuildTypeInfo(Ty, false);
  }
  public Constant /*P*/ BuildTypeInfo(QualType Ty, boolean Force/*= false*/) {
    raw_svector_ostream Out = null;
    try {
      // We want to operate on the canonical type.
      Ty.$assignMove(Ty.getCanonicalType());
      
      // Check if we've already emitted an RTTI descriptor for this type.
      SmallString/*<256>*/ Name/*J*/= new SmallString/*<256>*/(256);
      Out/*J*/= new raw_svector_ostream(Name);
      CGM.getCXXABI().getMangleContext().mangleCXXRTTI(new QualType(Ty), Out);
      
      GlobalVariable /*P*/ OldGV = CGM.getModule().getNamedGlobal(Name.$StringRef());
      if ((OldGV != null) && !OldGV.isDeclaration()) {
        assert (!OldGV.hasAvailableExternallyLinkage()) : "available_externally typeinfos not yet implemented";
        
        return ConstantExpr.getBitCast(OldGV, CGM.Unnamed_field9.Int8PtrTy);
      }
      
      // Check if there is already an external RTTI descriptor for this type.
      boolean IsStdLib = ItaniumCXXABIStatics.IsStandardLibraryRTTIDescriptor(new QualType(Ty));
      if (!Force && (IsStdLib || ItaniumCXXABIStatics.ShouldUseExternalRTTIDescriptor(CGM, new QualType(Ty)))) {
        return GetAddrOfExternalRTTIDescriptor(new QualType(Ty));
      }
      
      // Emit the standard library with external linkage.
      GlobalVariable.LinkageTypes Linkage;
      if (IsStdLib) {
        Linkage = GlobalValue.LinkageTypes.ExternalLinkage;
      } else {
        Linkage = ItaniumCXXABIStatics.getTypeInfoLinkage(CGM, new QualType(Ty));
      }
      
      // Add the vtable pointer.
      BuildVTablePointer(cast_Type(Ty));
      
      // And the name.
      GlobalVariable /*P*/ TypeName = GetAddrOfTypeName(new QualType(Ty), Linkage);
      Constant /*P*/ TypeNameField;
      
      // If we're supposed to demote the visibility, be sure to set a flag
      // to use a string comparison for type_info comparisons.
      ItaniumCXXABI.RTTIUniquenessKind RTTIUniqueness = CXXABI.classifyRTTIUniqueness(new QualType(Ty), Linkage);
      if (RTTIUniqueness != ItaniumCXXABI.RTTIUniquenessKind.RUK_Unique) {
        // The flag is the sign bit, which on ARM64 is defined to be clear
        // for global pointers.  This is very ARM64-specific.
        TypeNameField = ConstantExpr.getPtrToInt(TypeName, CGM.Int64Ty);
        Constant /*P*/ flag = ConstantInt.get(CGM.Int64Ty, ((long/*uint64_t*/)$int2ulong(1)) << 63);
        TypeNameField = ConstantExpr.getAdd(TypeNameField, flag);
        TypeNameField
           = ConstantExpr.getIntToPtr(TypeNameField, CGM.Unnamed_field9.Int8PtrTy);
      } else {
        TypeNameField = ConstantExpr.getBitCast(TypeName, CGM.Unnamed_field9.Int8PtrTy);
      }
      Fields.push_back(TypeNameField);
      switch (Ty.$arrow().getTypeClass()) {
       case DependentSizedArray:
       case DependentSizedExtVector:
       case UnresolvedUsing:
       case Paren:
       case Typedef:
       case Adjusted:
       case Decayed:
       case TypeOfExpr:
       case TypeOf:
       case Decltype:
       case UnaryTransform:
       case Elaborated:
       case Attributed:
       case TemplateTypeParm:
       case SubstTemplateTypeParm:
       case SubstTemplateTypeParmPack:
       case TemplateSpecialization:
       case InjectedClassName:
       case DependentName:
       case DependentTemplateSpecialization:
       case PackExpansion:
        throw new llvm_unreachable("Non-canonical and dependent types shouldn't get here");
       case Builtin:
       case Vector:
       case ExtVector:
       case Complex:
       case BlockPointer:
        // Itanium C++ ABI 2.9.5p4:
        // abi::__fundamental_type_info adds no data members to std::type_info.
        break;
       case LValueReference:
       case RValueReference:
        throw new llvm_unreachable("References shouldn't get here");
       case Auto:
        throw new llvm_unreachable("Undeduced auto type shouldn't get here");
       case Pipe:
        throw new llvm_unreachable("Pipe type shouldn't get here");
       case ConstantArray:
       case IncompleteArray:
       case VariableArray:
        // Itanium C++ ABI 2.9.5p5:
        // abi::__array_type_info adds no data members to std::type_info.
        break;
       case FunctionNoProto:
       case FunctionProto:
        // Itanium C++ ABI 2.9.5p5:
        // abi::__function_type_info adds no data members to std::type_info.
        break;
       case Enum:
        // Itanium C++ ABI 2.9.5p5:
        // abi::__enum_type_info adds no data members to std::type_info.
        break;
       case Record:
        {
          /*const*/ CXXRecordDecl /*P*/ RD = cast_CXXRecordDecl(cast_RecordType(Ty).getDecl());
          if (!RD.hasDefinition() || !(RD.getNumBases() != 0)) {
            // We don't need to emit any fields.
            break;
          }
          if (ItaniumCXXABIStatics.CanUseSingleInheritance(RD)) {
            BuildSIClassTypeInfo(RD);
          } else {
            BuildVMIClassTypeInfo(RD);
          }
          
          break;
        }
       case ObjCObject:
       case ObjCInterface:
        BuildObjCObjectTypeInfo(cast_ObjCObjectType(Ty));
        break;
       case ObjCObjectPointer:
        BuildPointerTypeInfo(cast_ObjCObjectPointerType(Ty).getPointeeType());
        break;
       case Pointer:
        BuildPointerTypeInfo(cast_PointerType(Ty).getPointeeType());
        break;
       case MemberPointer:
        BuildPointerToMemberTypeInfo(cast_MemberPointerType(Ty));
        break;
       case Atomic:
        // No fields, at least for the moment.
        break;
      }
      
      Constant /*P*/ Init = ConstantStruct.getAnon(new ArrayRef<Constant /*P*/ >(Fields, true));
      
      final org.llvm.ir.Module /*&*/ M = CGM.getModule();
      GlobalVariable /*P*/ GV = /*NEW_EXPR [GlobalVariable::new]*/GlobalVariable.$new_GlobalVariable((type$ptr<?> New$Mem)->{
          return new GlobalVariable(M, Init.getType(), 
          /*Constant=*/ true, Linkage, Init, new Twine(Name));
       });
      
      // If there's already an old global variable, replace it with the new one.
      if ((OldGV != null)) {
        GV.takeName(OldGV);
        Constant /*P*/ NewPtr = ConstantExpr.getBitCast(GV, OldGV.getType());
        OldGV.replaceAllUsesWith(NewPtr);
        OldGV.eraseFromParent();
      }
      if (CGM.supportsCOMDAT() && GV.isWeakForLinker()) {
        GV.setComdat(M.getOrInsertComdat(GV.getName()));
      }
      
      // The Itanium ABI specifies that type_info objects must be globally
      // unique, with one exception: if the type is an incomplete class
      // type or a (possibly indirect) pointer to one.  That exception
      // affects the general case of comparing type_info objects produced
      // by the typeid operator, which is why the comparison operators on
      // std::type_info generally use the type_info name pointers instead
      // of the object addresses.  However, the language's built-in uses
      // of RTTI generally require class types to be complete, even when
      // manipulating pointers to those class types.  This allows the
      // implementation of dynamic_cast to rely on address equality tests,
      // which is much faster.
      
      // All of this is to say that it's important that both the type_info
      // object and the type_info name be uniqued when weakly emitted.
      
      // Give the type_info object and name the formal visibility of the
      // type itself.
      GlobalValue.VisibilityTypes llvmVisibility;
      if (GlobalValue.isLocalLinkage(Linkage)) {
        // If the linkage is local, only default visibility makes sense.
        llvmVisibility = GlobalValue.VisibilityTypes.DefaultVisibility;
      } else if (RTTIUniqueness == ItaniumCXXABI.RTTIUniquenessKind.RUK_NonUniqueHidden) {
        llvmVisibility = GlobalValue.VisibilityTypes.HiddenVisibility;
      } else {
        llvmVisibility = CodeGenModule.GetLLVMVisibility(Ty.$arrow().getVisibility());
      }
      TypeName.setVisibility(llvmVisibility);
      GV.setVisibility(llvmVisibility);
      
      return ConstantExpr.getBitCast(GV, CGM.Unnamed_field9.Int8PtrTy);
    } finally {
      if (Out != null) { Out.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumRTTIBuilder::~ItaniumRTTIBuilder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 2379,
   FQN="(anonymous namespace)::ItaniumRTTIBuilder::~ItaniumRTTIBuilder", NM="_ZN12_GLOBAL__N_118ItaniumRTTIBuilderD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZN12_GLOBAL__N_118ItaniumRTTIBuilderD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    Fields.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "CGM=" + CGM // NOI18N
              + ", VMContext=" + "[LLVMContext]" // NOI18N
              + ", CXXABI=" + CXXABI // NOI18N
              + ", Fields=" + Fields; // NOI18N
  }
}
