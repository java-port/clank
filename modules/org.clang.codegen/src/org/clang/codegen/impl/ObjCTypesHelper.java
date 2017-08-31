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
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import org.clang.codegen.impl.*;
import org.clang.codegen.CodeGen.impl.*;
import org.llvm.ir.ArrayType;
import org.llvm.ir.FunctionType;
import org.llvm.ir.PointerType;
import org.llvm.ir.Type;


/// ObjCTypesHelper - Helper class that encapsulates lazy
/// construction of varies types used during ObjC generation.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCTypesHelper">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 498,
 FQN="(anonymous namespace)::ObjCTypesHelper", NM="_ZN12_GLOBAL__N_115ObjCTypesHelperE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_115ObjCTypesHelperE")
//</editor-fold>
public class ObjCTypesHelper extends /*public*/ ObjCCommonTypesHelper {
/*public:*/
  /// SymtabTy - LLVM type for struct objc_symtab.
  public StructType /*P*/ SymtabTy;
  /// SymtabPtrTy - LLVM type for struct objc_symtab *.
  public Type /*P*/ SymtabPtrTy;
  /// ModuleTy - LLVM type for struct objc_module.
  public StructType /*P*/ ModuleTy;
  
  /// ProtocolTy - LLVM type for struct objc_protocol.
  public StructType /*P*/ ProtocolTy;
  /// ProtocolPtrTy - LLVM type for struct objc_protocol *.
  public Type /*P*/ ProtocolPtrTy;
  /// ProtocolExtensionTy - LLVM type for struct
  /// objc_protocol_extension.
  public StructType /*P*/ ProtocolExtensionTy;
  /// ProtocolExtensionTy - LLVM type for struct
  /// objc_protocol_extension *.
  public Type /*P*/ ProtocolExtensionPtrTy;
  /// MethodDescriptionTy - LLVM type for struct
  /// objc_method_description.
  public StructType /*P*/ MethodDescriptionTy;
  /// MethodDescriptionListTy - LLVM type for struct
  /// objc_method_description_list.
  public StructType /*P*/ MethodDescriptionListTy;
  /// MethodDescriptionListPtrTy - LLVM type for struct
  /// objc_method_description_list *.
  public Type /*P*/ MethodDescriptionListPtrTy;
  /// ProtocolListTy - LLVM type for struct objc_property_list.
  public StructType /*P*/ ProtocolListTy;
  /// ProtocolListPtrTy - LLVM type for struct objc_property_list*.
  public Type /*P*/ ProtocolListPtrTy;
  /// CategoryTy - LLVM type for struct objc_category.
  public StructType /*P*/ CategoryTy;
  /// ClassTy - LLVM type for struct objc_class.
  public StructType /*P*/ ClassTy;
  /// ClassPtrTy - LLVM type for struct objc_class *.
  public Type /*P*/ ClassPtrTy;
  /// ClassExtensionTy - LLVM type for struct objc_class_ext.
  public StructType /*P*/ ClassExtensionTy;
  /// ClassExtensionPtrTy - LLVM type for struct objc_class_ext *.
  public Type /*P*/ ClassExtensionPtrTy;
  // IvarTy - LLVM type for struct objc_ivar.
  public StructType /*P*/ IvarTy;
  /// IvarListTy - LLVM type for struct objc_ivar_list.
  public Type /*P*/ IvarListTy;
  /// IvarListPtrTy - LLVM type for struct objc_ivar_list *.
  public Type /*P*/ IvarListPtrTy;
  /// MethodListTy - LLVM type for struct objc_method_list.
  public Type /*P*/ MethodListTy;
  /// MethodListPtrTy - LLVM type for struct objc_method_list *.
  public Type /*P*/ MethodListPtrTy;
  
  /// ExceptionDataTy - LLVM type for struct _objc_exception_data.
  public Type /*P*/ ExceptionDataTy;
  
  /// ExceptionTryEnterFn - LLVM objc_exception_try_enter function.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCTypesHelper::getExceptionTryEnterFn">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 555,
   FQN="(anonymous namespace)::ObjCTypesHelper::getExceptionTryEnterFn", NM="_ZN12_GLOBAL__N_115ObjCTypesHelper22getExceptionTryEnterFnEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_115ObjCTypesHelper22getExceptionTryEnterFnEv")
  //</editor-fold>
  public Constant /*P*/ getExceptionTryEnterFn() {
    Type /*P*/ params[/*1*/] = new Type /*P*/  [/*1*/] {ExceptionDataTy.getPointerTo()};
    return CGM.CreateRuntimeFunction(FunctionType.get(CGM.VoidTy, new ArrayRef<Type /*P*/ >(params, true), false), 
        new StringRef(/*KEEP_STR*/"objc_exception_try_enter"));
  }

  
  /// ExceptionTryExitFn - LLVM objc_exception_try_exit function.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCTypesHelper::getExceptionTryExitFn">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 563,
   FQN="(anonymous namespace)::ObjCTypesHelper::getExceptionTryExitFn", NM="_ZN12_GLOBAL__N_115ObjCTypesHelper21getExceptionTryExitFnEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_115ObjCTypesHelper21getExceptionTryExitFnEv")
  //</editor-fold>
  public Constant /*P*/ getExceptionTryExitFn() {
    Type /*P*/ params[/*1*/] = new Type /*P*/  [/*1*/] {ExceptionDataTy.getPointerTo()};
    return CGM.CreateRuntimeFunction(FunctionType.get(CGM.VoidTy, new ArrayRef<Type /*P*/ >(params, true), false), 
        new StringRef(/*KEEP_STR*/"objc_exception_try_exit"));
  }

  
  /// ExceptionExtractFn - LLVM objc_exception_extract function.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCTypesHelper::getExceptionExtractFn">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 571,
   FQN="(anonymous namespace)::ObjCTypesHelper::getExceptionExtractFn", NM="_ZN12_GLOBAL__N_115ObjCTypesHelper21getExceptionExtractFnEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_115ObjCTypesHelper21getExceptionExtractFnEv")
  //</editor-fold>
  public Constant /*P*/ getExceptionExtractFn() {
    Type /*P*/ params[/*1*/] = new Type /*P*/  [/*1*/] {ExceptionDataTy.getPointerTo()};
    return CGM.CreateRuntimeFunction(FunctionType.get(ObjectPtrTy, 
            new ArrayRef<Type /*P*/ >(params, true), false), 
        new StringRef(/*KEEP_STR*/"objc_exception_extract"));
  }

  
  /// ExceptionMatchFn - LLVM objc_exception_match function.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCTypesHelper::getExceptionMatchFn">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 579,
   FQN="(anonymous namespace)::ObjCTypesHelper::getExceptionMatchFn", NM="_ZN12_GLOBAL__N_115ObjCTypesHelper19getExceptionMatchFnEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_115ObjCTypesHelper19getExceptionMatchFnEv")
  //</editor-fold>
  public Constant /*P*/ getExceptionMatchFn() {
    Type /*P*/ params[/*2*/] = new Type /*P*/  [/*2*/] {ClassPtrTy, ObjectPtrTy};
    return CGM.CreateRuntimeFunction(FunctionType.get(CGM.Int32Ty, new ArrayRef<Type /*P*/ >(params, true), false), 
        new StringRef(/*KEEP_STR*/"objc_exception_match"));
  }

  
  /// SetJmpFn - LLVM _setjmp function.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCTypesHelper::getSetJmpFn">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 587,
   FQN="(anonymous namespace)::ObjCTypesHelper::getSetJmpFn", NM="_ZN12_GLOBAL__N_115ObjCTypesHelper11getSetJmpFnEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_115ObjCTypesHelper11getSetJmpFnEv")
  //</editor-fold>
  public Constant /*P*/ getSetJmpFn() {
    // This is specifically the prototype for x86.
    Type /*P*/ params[/*1*/] = new Type /*P*/  [/*1*/] {CGM.Int32Ty.getPointerTo()};
    return CGM.CreateRuntimeFunction(FunctionType.get(CGM.Int32Ty, 
            new ArrayRef<Type /*P*/ >(params, true), false), 
        new StringRef(/*KEEP_STR*/"_setjmp"), 
        AttributeSet.get_LLVMContext_uint_ArrayRef$AttrKind(CGM.getLLVMContext(), 
            AttributeSet.AttrIndex.FunctionIndex.getValue(), 
            new ArrayRef<Attribute.AttrKind>(Attribute.AttrKind.NonLazyBind)));
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCTypesHelper::ObjCTypesHelper">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 5300,
   FQN="(anonymous namespace)::ObjCTypesHelper::ObjCTypesHelper", NM="_ZN12_GLOBAL__N_115ObjCTypesHelperC1ERN5clang7CodeGen13CodeGenModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_115ObjCTypesHelperC1ERN5clang7CodeGen13CodeGenModuleE")
  //</editor-fold>
  public ObjCTypesHelper(final CodeGenModule /*&*/ cgm) {
    // : ObjCCommonTypesHelper(cgm) 
    //START JInit
    super(cgm);
    //END JInit
    // struct _objc_method_description {
    //   SEL name;
    //   char *types;
    // }
    MethodDescriptionTy
       = StructType.create(new StringRef(/*KEEP_STR*/"struct._objc_method_description"), 
        SelectorPtrTy, Int8PtrTy, null);
    
    // struct _objc_method_description_list {
    //   int count;
    //   struct _objc_method_description[1];
    // }
    MethodDescriptionListTy = StructType.create(new StringRef(/*KEEP_STR*/"struct._objc_method_description_list"), IntTy, 
        ArrayType.get(MethodDescriptionTy, $int2ulong(0)), null);
    
    // struct _objc_method_description_list *
    MethodDescriptionListPtrTy
       = PointerType.getUnqual(MethodDescriptionListTy);
    
    // Protocol description structures
    
    // struct _objc_protocol_extension {
    //   uint32_t size;  // sizeof(struct _objc_protocol_extension)
    //   struct _objc_method_description_list *optional_instance_methods;
    //   struct _objc_method_description_list *optional_class_methods;
    //   struct _objc_property_list *instance_properties;
    //   const char ** extendedMethodTypes;
    //   struct _objc_property_list *class_properties;
    // }
    ProtocolExtensionTy
       = StructType.create(new StringRef(/*KEEP_STR*/"struct._objc_protocol_extension"), 
        IntTy, MethodDescriptionListPtrTy, 
        MethodDescriptionListPtrTy, PropertyListPtrTy, 
        Int8PtrPtrTy, PropertyListPtrTy, null);
    
    // struct _objc_protocol_extension *
    ProtocolExtensionPtrTy = PointerType.getUnqual(ProtocolExtensionTy);
    
    // Handle recursive construction of Protocol and ProtocolList types
    ProtocolTy
       = StructType.create(VMContext, new StringRef(/*KEEP_STR*/"struct._objc_protocol"));
    
    ProtocolListTy
       = StructType.create(VMContext, new StringRef(/*KEEP_STR*/"struct._objc_protocol_list"));
    ProtocolListTy.setBody(PointerType.getUnqual(ProtocolListTy), 
        LongTy, 
        ArrayType.get(ProtocolTy, $int2ulong(0)), 
        null);
    
    // struct _objc_protocol {
    //   struct _objc_protocol_extension *isa;
    //   char *protocol_name;
    //   struct _objc_protocol **_objc_protocol_list;
    //   struct _objc_method_description_list *instance_methods;
    //   struct _objc_method_description_list *class_methods;
    // }
    ProtocolTy.setBody(ProtocolExtensionPtrTy, Int8PtrTy, 
        PointerType.getUnqual(ProtocolListTy), 
        MethodDescriptionListPtrTy, 
        MethodDescriptionListPtrTy, 
        null);
    
    // struct _objc_protocol_list *
    ProtocolListPtrTy = PointerType.getUnqual(ProtocolListTy);
    
    ProtocolPtrTy = PointerType.getUnqual(ProtocolTy);
    
    // Class description structures
    
    // struct _objc_ivar {
    //   char *ivar_name;
    //   char *ivar_type;
    //   int  ivar_offset;
    // }
    IvarTy = StructType.create(new StringRef(/*KEEP_STR*/"struct._objc_ivar"), 
        Int8PtrTy, Int8PtrTy, IntTy, null);
    
    // struct _objc_ivar_list *
    IvarListTy
       = StructType.create(VMContext, new StringRef(/*KEEP_STR*/"struct._objc_ivar_list"));
    IvarListPtrTy = PointerType.getUnqual(IvarListTy);
    
    // struct _objc_method_list *
    MethodListTy
       = StructType.create(VMContext, new StringRef(/*KEEP_STR*/"struct._objc_method_list"));
    MethodListPtrTy = PointerType.getUnqual(MethodListTy);
    
    // struct _objc_class_extension *
    ClassExtensionTy
       = StructType.create(new StringRef(/*KEEP_STR*/"struct._objc_class_extension"), 
        IntTy, Int8PtrTy, PropertyListPtrTy, null);
    ClassExtensionPtrTy = PointerType.getUnqual(ClassExtensionTy);
    
    ClassTy = StructType.create(VMContext, new StringRef(/*KEEP_STR*/"struct._objc_class"));
    
    // struct _objc_class {
    //   Class isa;
    //   Class super_class;
    //   char *name;
    //   long version;
    //   long info;
    //   long instance_size;
    //   struct _objc_ivar_list *ivars;
    //   struct _objc_method_list *methods;
    //   struct _objc_cache *cache;
    //   struct _objc_protocol_list *protocols;
    //   char *ivar_layout;
    //   struct _objc_class_ext *ext;
    // };
    ClassTy.setBody(PointerType.getUnqual(ClassTy), 
        PointerType.getUnqual(ClassTy), 
        Int8PtrTy, 
        LongTy, 
        LongTy, 
        LongTy, 
        IvarListPtrTy, 
        MethodListPtrTy, 
        CachePtrTy, 
        ProtocolListPtrTy, 
        Int8PtrTy, 
        ClassExtensionPtrTy, 
        null);
    
    ClassPtrTy = PointerType.getUnqual(ClassTy);
    
    // struct _objc_category {
    //   char *category_name;
    //   char *class_name;
    //   struct _objc_method_list *instance_method;
    //   struct _objc_method_list *class_method;
    //   struct _objc_protocol_list *protocols;
    //   uint32_t size;  // sizeof(struct _objc_category)
    //   struct _objc_property_list *instance_properties;// category's @property
    //   struct _objc_property_list *class_properties;
    // }
    CategoryTy
       = StructType.create(new StringRef(/*KEEP_STR*/"struct._objc_category"), 
        Int8PtrTy, Int8PtrTy, MethodListPtrTy, 
        MethodListPtrTy, ProtocolListPtrTy, 
        IntTy, PropertyListPtrTy, PropertyListPtrTy, 
        null);
    
    // Global metadata structures
    
    // struct _objc_symtab {
    //   long sel_ref_cnt;
    //   SEL *refs;
    //   short cls_def_cnt;
    //   short cat_def_cnt;
    //   char *defs[cls_def_cnt + cat_def_cnt];
    // }
    SymtabTy
       = StructType.create(new StringRef(/*KEEP_STR*/"struct._objc_symtab"), 
        LongTy, SelectorPtrTy, ShortTy, ShortTy, 
        ArrayType.get(Int8PtrTy, $int2ulong(0)), null);
    SymtabPtrTy = PointerType.getUnqual(SymtabTy);
    
    // struct _objc_module {
    //   long version;
    //   long size;   // sizeof(struct _objc_module)
    //   char *name;
    //   struct _objc_symtab* symtab;
    //  }
    ModuleTy
       = StructType.create(new StringRef(/*KEEP_STR*/"struct._objc_module"), 
        LongTy, LongTy, Int8PtrTy, SymtabPtrTy, null);
    
    // FIXME: This is the size of the setjmp buffer and should be target
    // specific. 18 is what's used on 32-bit X86.
    long/*uint64_t*/ SetJmpBufferSize = $int2ulong(18);
    
    // Exceptions
    Type /*P*/ StackPtrTy = ArrayType.get(CGM.Unnamed_field9.Int8PtrTy, $int2ulong(4));
    
    ExceptionDataTy
       = StructType.create(new StringRef(/*KEEP_STR*/"struct._objc_exception_data"), 
        ArrayType.get(CGM.Int32Ty, SetJmpBufferSize), 
        StackPtrTy, null);
  }

  
  @Override public String toString() {
    return "" + "SymtabTy=" + SymtabTy // NOI18N
              + ", SymtabPtrTy=" + SymtabPtrTy // NOI18N
              + ", ModuleTy=" + ModuleTy // NOI18N
              + ", ProtocolTy=" + ProtocolTy // NOI18N
              + ", ProtocolPtrTy=" + ProtocolPtrTy // NOI18N
              + ", ProtocolExtensionTy=" + ProtocolExtensionTy // NOI18N
              + ", ProtocolExtensionPtrTy=" + ProtocolExtensionPtrTy // NOI18N
              + ", MethodDescriptionTy=" + MethodDescriptionTy // NOI18N
              + ", MethodDescriptionListTy=" + MethodDescriptionListTy // NOI18N
              + ", MethodDescriptionListPtrTy=" + MethodDescriptionListPtrTy // NOI18N
              + ", ProtocolListTy=" + ProtocolListTy // NOI18N
              + ", ProtocolListPtrTy=" + ProtocolListPtrTy // NOI18N
              + ", CategoryTy=" + CategoryTy // NOI18N
              + ", ClassTy=" + ClassTy // NOI18N
              + ", ClassPtrTy=" + ClassPtrTy // NOI18N
              + ", ClassExtensionTy=" + ClassExtensionTy // NOI18N
              + ", ClassExtensionPtrTy=" + ClassExtensionPtrTy // NOI18N
              + ", IvarTy=" + IvarTy // NOI18N
              + ", IvarListTy=" + IvarListTy // NOI18N
              + ", IvarListPtrTy=" + IvarListPtrTy // NOI18N
              + ", MethodListTy=" + MethodListTy // NOI18N
              + ", MethodListPtrTy=" + MethodListPtrTy // NOI18N
              + ", ExceptionDataTy=" + ExceptionDataTy // NOI18N
              + super.toString(); // NOI18N
  }
}
