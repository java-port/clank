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
import org.clang.ast.*;
import org.clang.basic.*;
import org.llvm.ir.*;
import org.clang.codegen.impl.*;
import org.clang.codegen.CodeGen.impl.*;
import org.llvm.ir.ArrayType;
import org.llvm.ir.FunctionType;
import org.llvm.ir.PointerType;
import org.llvm.ir.Type;
import static org.llvm.ir.java.IrRTTI.cast_StructType;


/// ObjCNonFragileABITypesHelper - will have all types needed by objective-c's
/// modern abi
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCNonFragileABITypesHelper">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 605,
 FQN="(anonymous namespace)::ObjCNonFragileABITypesHelper", NM="_ZN12_GLOBAL__N_128ObjCNonFragileABITypesHelperE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_128ObjCNonFragileABITypesHelperE")
//</editor-fold>
public class ObjCNonFragileABITypesHelper extends /*public*/ ObjCCommonTypesHelper {
/*public:*/
  // MethodListnfABITy - LLVM for struct _method_list_t
  public StructType /*P*/ MethodListnfABITy;
  
  // MethodListnfABIPtrTy - LLVM for struct _method_list_t*
  public Type /*P*/ MethodListnfABIPtrTy;
  
  // ProtocolnfABITy = LLVM for struct _protocol_t
  public StructType /*P*/ ProtocolnfABITy;
  
  // ProtocolnfABIPtrTy = LLVM for struct _protocol_t*
  public Type /*P*/ ProtocolnfABIPtrTy;
  
  // ProtocolListnfABITy - LLVM for struct _objc_protocol_list
  public StructType /*P*/ ProtocolListnfABITy;
  
  // ProtocolListnfABIPtrTy - LLVM for struct _objc_protocol_list*
  public Type /*P*/ ProtocolListnfABIPtrTy;
  
  // ClassnfABITy - LLVM for struct _class_t
  public StructType /*P*/ ClassnfABITy;
  
  // ClassnfABIPtrTy - LLVM for struct _class_t*
  public Type /*P*/ ClassnfABIPtrTy;
  
  // IvarnfABITy - LLVM for struct _ivar_t
  public StructType /*P*/ IvarnfABITy;
  
  // IvarListnfABITy - LLVM for struct _ivar_list_t
  public StructType /*P*/ IvarListnfABITy;
  
  // IvarListnfABIPtrTy = LLVM for struct _ivar_list_t*
  public Type /*P*/ IvarListnfABIPtrTy;
  
  // ClassRonfABITy - LLVM for struct _class_ro_t
  public StructType /*P*/ ClassRonfABITy;
  
  // ImpnfABITy - LLVM for id (*)(id, SEL, ...)
  public Type /*P*/ ImpnfABITy;
  
  // CategorynfABITy - LLVM for struct _category_t
  public StructType /*P*/ CategorynfABITy;
  
  // New types for nonfragile abi messaging.
  
  // MessageRefTy - LLVM for:
  // struct _message_ref_t {
  //   IMP messenger;
  //   SEL name;
  // };
  public StructType /*P*/ MessageRefTy;
  // MessageRefCTy - clang type for struct _message_ref_t
  public QualType MessageRefCTy;
  
  // MessageRefPtrTy - LLVM for struct _message_ref_t*
  public Type /*P*/ MessageRefPtrTy;
  // MessageRefCPtrTy - clang type for struct _message_ref_t*
  public QualType MessageRefCPtrTy;
  
  // SuperMessageRefTy - LLVM for:
  // struct _super_message_ref_t {
  //   SUPER_IMP messenger;
  //   SEL name;
  // };
  public StructType /*P*/ SuperMessageRefTy;
  
  // SuperMessageRefPtrTy - LLVM for struct _super_message_ref_t*
  public Type /*P*/ SuperMessageRefPtrTy;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCNonFragileABITypesHelper::getMessageSendFixupFn">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 675,
   FQN="(anonymous namespace)::ObjCNonFragileABITypesHelper::getMessageSendFixupFn", NM="_ZN12_GLOBAL__N_128ObjCNonFragileABITypesHelper21getMessageSendFixupFnEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_128ObjCNonFragileABITypesHelper21getMessageSendFixupFnEv")
  //</editor-fold>
  public Constant /*P*/ getMessageSendFixupFn() {
    // id objc_msgSend_fixup(id, struct message_ref_t*, ...)
    Type /*P*/ params[/*2*/] = new Type /*P*/  [/*2*/] {ObjectPtrTy, MessageRefPtrTy};
    return CGM.CreateRuntimeFunction(FunctionType.get(ObjectPtrTy, 
            new ArrayRef<Type /*P*/ >(params, true), true), 
        new StringRef(/*KEEP_STR*/"objc_msgSend_fixup"));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCNonFragileABITypesHelper::getMessageSendFpretFixupFn">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 683,
   FQN="(anonymous namespace)::ObjCNonFragileABITypesHelper::getMessageSendFpretFixupFn", NM="_ZN12_GLOBAL__N_128ObjCNonFragileABITypesHelper26getMessageSendFpretFixupFnEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_128ObjCNonFragileABITypesHelper26getMessageSendFpretFixupFnEv")
  //</editor-fold>
  public Constant /*P*/ getMessageSendFpretFixupFn() {
    // id objc_msgSend_fpret_fixup(id, struct message_ref_t*, ...)
    Type /*P*/ params[/*2*/] = new Type /*P*/  [/*2*/] {ObjectPtrTy, MessageRefPtrTy};
    return CGM.CreateRuntimeFunction(FunctionType.get(ObjectPtrTy, 
            new ArrayRef<Type /*P*/ >(params, true), true), 
        new StringRef(/*KEEP_STR*/"objc_msgSend_fpret_fixup"));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCNonFragileABITypesHelper::getMessageSendStretFixupFn">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 691,
   FQN="(anonymous namespace)::ObjCNonFragileABITypesHelper::getMessageSendStretFixupFn", NM="_ZN12_GLOBAL__N_128ObjCNonFragileABITypesHelper26getMessageSendStretFixupFnEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_128ObjCNonFragileABITypesHelper26getMessageSendStretFixupFnEv")
  //</editor-fold>
  public Constant /*P*/ getMessageSendStretFixupFn() {
    // id objc_msgSend_stret_fixup(id, struct message_ref_t*, ...)
    Type /*P*/ params[/*2*/] = new Type /*P*/  [/*2*/] {ObjectPtrTy, MessageRefPtrTy};
    return CGM.CreateRuntimeFunction(FunctionType.get(ObjectPtrTy, 
            new ArrayRef<Type /*P*/ >(params, true), true), 
        new StringRef(/*KEEP_STR*/"objc_msgSend_stret_fixup"));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCNonFragileABITypesHelper::getMessageSendSuper2FixupFn">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 699,
   FQN="(anonymous namespace)::ObjCNonFragileABITypesHelper::getMessageSendSuper2FixupFn", NM="_ZN12_GLOBAL__N_128ObjCNonFragileABITypesHelper27getMessageSendSuper2FixupFnEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_128ObjCNonFragileABITypesHelper27getMessageSendSuper2FixupFnEv")
  //</editor-fold>
  public Constant /*P*/ getMessageSendSuper2FixupFn() {
    // id objc_msgSendSuper2_fixup (struct objc_super *,
    //                              struct _super_message_ref_t*, ...)
    Type /*P*/ params[/*2*/] = new Type /*P*/  [/*2*/] {SuperPtrTy, SuperMessageRefPtrTy};
    return CGM.CreateRuntimeFunction(FunctionType.get(ObjectPtrTy, 
            new ArrayRef<Type /*P*/ >(params, true), true), 
        new StringRef(/*KEEP_STR*/"objc_msgSendSuper2_fixup"));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCNonFragileABITypesHelper::getMessageSendSuper2StretFixupFn">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 708,
   FQN="(anonymous namespace)::ObjCNonFragileABITypesHelper::getMessageSendSuper2StretFixupFn", NM="_ZN12_GLOBAL__N_128ObjCNonFragileABITypesHelper32getMessageSendSuper2StretFixupFnEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_128ObjCNonFragileABITypesHelper32getMessageSendSuper2StretFixupFnEv")
  //</editor-fold>
  public Constant /*P*/ getMessageSendSuper2StretFixupFn() {
    // id objc_msgSendSuper2_stret_fixup(struct objc_super *,
    //                                   struct _super_message_ref_t*, ...)
    Type /*P*/ params[/*2*/] = new Type /*P*/  [/*2*/] {SuperPtrTy, SuperMessageRefPtrTy};
    return CGM.CreateRuntimeFunction(FunctionType.get(ObjectPtrTy, 
            new ArrayRef<Type /*P*/ >(params, true), true), 
        new StringRef(/*KEEP_STR*/"objc_msgSendSuper2_stret_fixup"));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCNonFragileABITypesHelper::getObjCEndCatchFn">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 717,
   FQN="(anonymous namespace)::ObjCNonFragileABITypesHelper::getObjCEndCatchFn", NM="_ZN12_GLOBAL__N_128ObjCNonFragileABITypesHelper17getObjCEndCatchFnEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_128ObjCNonFragileABITypesHelper17getObjCEndCatchFnEv")
  //</editor-fold>
  public Constant /*P*/ getObjCEndCatchFn() {
    return CGM.CreateRuntimeFunction(FunctionType.get(CGM.VoidTy, false), 
        new StringRef(/*KEEP_STR*/"objc_end_catch"));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCNonFragileABITypesHelper::getObjCBeginCatchFn">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 723,
   FQN="(anonymous namespace)::ObjCNonFragileABITypesHelper::getObjCBeginCatchFn", NM="_ZN12_GLOBAL__N_128ObjCNonFragileABITypesHelper19getObjCBeginCatchFnEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_128ObjCNonFragileABITypesHelper19getObjCBeginCatchFnEv")
  //</editor-fold>
  public Constant /*P*/ getObjCBeginCatchFn() {
    Type /*P*/ params[/*1*/] = new Type /*P*/  [/*1*/] {Int8PtrTy};
    return CGM.CreateRuntimeFunction(FunctionType.get(Int8PtrTy, 
            new ArrayRef<Type /*P*/ >(params, true), false), 
        new StringRef(/*KEEP_STR*/"objc_begin_catch"));
  }

  
  public StructType /*P*/ EHTypeTy;
  public Type /*P*/ EHTypePtrTy;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCNonFragileABITypesHelper::ObjCNonFragileABITypesHelper">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 5485,
   FQN="(anonymous namespace)::ObjCNonFragileABITypesHelper::ObjCNonFragileABITypesHelper", NM="_ZN12_GLOBAL__N_128ObjCNonFragileABITypesHelperC1ERN5clang7CodeGen13CodeGenModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_128ObjCNonFragileABITypesHelperC1ERN5clang7CodeGen13CodeGenModuleE")
  //</editor-fold>
  public ObjCNonFragileABITypesHelper(final CodeGenModule /*&*/ cgm) {
    // : ObjCCommonTypesHelper(cgm), MessageRefCTy(), MessageRefCPtrTy() 
    //START JInit
    super(cgm);
    this.MessageRefCTy = new QualType();
    this.MessageRefCPtrTy = new QualType();
    //END JInit
    // struct _method_list_t {
    //   uint32_t entsize;  // sizeof(struct _objc_method)
    //   uint32_t method_count;
    //   struct _objc_method method_list[method_count];
    // }
    MethodListnfABITy
       = StructType.create(new StringRef(/*KEEP_STR*/"struct.__method_list_t"), IntTy, IntTy, 
        ArrayType.get(MethodTy, $int2ulong(0)), null);
    // struct method_list_t *
    MethodListnfABIPtrTy = PointerType.getUnqual(MethodListnfABITy);
    
    // struct _protocol_t {
    //   id isa;  // NULL
    //   const char * const protocol_name;
    //   const struct _protocol_list_t * protocol_list; // super protocols
    //   const struct method_list_t * const instance_methods;
    //   const struct method_list_t * const class_methods;
    //   const struct method_list_t *optionalInstanceMethods;
    //   const struct method_list_t *optionalClassMethods;
    //   const struct _prop_list_t * properties;
    //   const uint32_t size;  // sizeof(struct _protocol_t)
    //   const uint32_t flags;  // = 0
    //   const char ** extendedMethodTypes;
    //   const char *demangledName;
    //   const struct _prop_list_t * class_properties;
    // }
    
    // Holder for struct _protocol_list_t *
    ProtocolListnfABITy
       = StructType.create(VMContext, new StringRef(/*KEEP_STR*/"struct._objc_protocol_list"));
    
    ProtocolnfABITy
       = StructType.create(new StringRef(/*KEEP_STR*/"struct._protocol_t"), ObjectPtrTy, Int8PtrTy, 
        PointerType.getUnqual(ProtocolListnfABITy), 
        MethodListnfABIPtrTy, MethodListnfABIPtrTy, 
        MethodListnfABIPtrTy, MethodListnfABIPtrTy, 
        PropertyListPtrTy, IntTy, IntTy, Int8PtrPtrTy, 
        Int8PtrTy, PropertyListPtrTy, 
        null);
    
    // struct _protocol_t*
    ProtocolnfABIPtrTy = PointerType.getUnqual(ProtocolnfABITy);
    
    // struct _protocol_list_t {
    //   long protocol_count;   // Note, this is 32/64 bit
    //   struct _protocol_t *[protocol_count];
    // }
    ProtocolListnfABITy.setBody(LongTy, 
        ArrayType.get(ProtocolnfABIPtrTy, $int2ulong(0)), 
        null);
    
    // struct _objc_protocol_list*
    ProtocolListnfABIPtrTy = PointerType.getUnqual(ProtocolListnfABITy);
    
    // struct _ivar_t {
    //   unsigned [long] int *offset;  // pointer to ivar offset location
    //   char *name;
    //   char *type;
    //   uint32_t alignment;
    //   uint32_t size;
    // }
    IvarnfABITy = StructType.create(new StringRef(/*KEEP_STR*/"struct._ivar_t"), PointerType.getUnqual(IvarOffsetVarTy), 
        Int8PtrTy, Int8PtrTy, IntTy, IntTy, null);
    
    // struct _ivar_list_t {
    //   uint32 entsize;  // sizeof(struct _ivar_t)
    //   uint32 count;
    //   struct _iver_t list[count];
    // }
    IvarListnfABITy
       = StructType.create(new StringRef(/*KEEP_STR*/"struct._ivar_list_t"), IntTy, IntTy, 
        ArrayType.get(IvarnfABITy, $int2ulong(0)), null);
    
    IvarListnfABIPtrTy = PointerType.getUnqual(IvarListnfABITy);
    
    // struct _class_ro_t {
    //   uint32_t const flags;
    //   uint32_t const instanceStart;
    //   uint32_t const instanceSize;
    //   uint32_t const reserved;  // only when building for 64bit targets
    //   const uint8_t * const ivarLayout;
    //   const char *const name;
    //   const struct _method_list_t * const baseMethods;
    //   const struct _objc_protocol_list *const baseProtocols;
    //   const struct _ivar_list_t *const ivars;
    //   const uint8_t * const weakIvarLayout;
    //   const struct _prop_list_t * const properties;
    // }
    
    // FIXME. Add 'reserved' field in 64bit abi mode!
    ClassRonfABITy = StructType.create(new StringRef(/*KEEP_STR*/"struct._class_ro_t"), 
        IntTy, IntTy, IntTy, Int8PtrTy, 
        Int8PtrTy, MethodListnfABIPtrTy, 
        ProtocolListnfABIPtrTy, 
        IvarListnfABIPtrTy, 
        Int8PtrTy, PropertyListPtrTy, 
        null);
    
    // ImpnfABITy - LLVM for id (*)(id, SEL, ...)
    Type /*P*/ params[/*2*/] = new Type /*P*/  [/*2*/] {ObjectPtrTy, SelectorPtrTy};
    ImpnfABITy = FunctionType.get(ObjectPtrTy, new ArrayRef<Type /*P*/ >(params, true), false).
        getPointerTo();
    
    // struct _class_t {
    //   struct _class_t *isa;
    //   struct _class_t * const superclass;
    //   void *cache;
    //   IMP *vtable;
    //   struct class_ro_t *ro;
    // }
    ClassnfABITy = StructType.create(VMContext, new StringRef(/*KEEP_STR*/"struct._class_t"));
    ClassnfABITy.setBody(PointerType.getUnqual(ClassnfABITy), 
        PointerType.getUnqual(ClassnfABITy), 
        CachePtrTy, 
        PointerType.getUnqual(ImpnfABITy), 
        PointerType.getUnqual(ClassRonfABITy), 
        null);
    
    // LLVM for struct _class_t *
    ClassnfABIPtrTy = PointerType.getUnqual(ClassnfABITy);
    
    // struct _category_t {
    //   const char * const name;
    //   struct _class_t *const cls;
    //   const struct _method_list_t * const instance_methods;
    //   const struct _method_list_t * const class_methods;
    //   const struct _protocol_list_t * const protocols;
    //   const struct _prop_list_t * const properties;
    //   const struct _prop_list_t * const class_properties;
    //   const uint32_t size;
    // }
    CategorynfABITy = StructType.create(new StringRef(/*KEEP_STR*/"struct._category_t"), 
        Int8PtrTy, ClassnfABIPtrTy, 
        MethodListnfABIPtrTy, 
        MethodListnfABIPtrTy, 
        ProtocolListnfABIPtrTy, 
        PropertyListPtrTy, 
        PropertyListPtrTy, 
        IntTy, 
        null);
    
    // New types for nonfragile abi messaging.
    final CodeGenTypes /*&*/ Types = CGM.getTypes();
    final ASTContext /*&*/ Ctx = CGM.getContext();
    
    // MessageRefTy - LLVM for:
    // struct _message_ref_t {
    //   IMP messenger;
    //   SEL name;
    // };
    
    // First the clang type for struct _message_ref_t
    RecordDecl /*P*/ RD = RecordDecl.Create(Ctx, TagTypeKind.TTK_Struct, 
        Ctx.getTranslationUnitDecl(), 
        new SourceLocation(), new SourceLocation(), 
        /*AddrOf*/Ctx.Idents.get(new StringRef(/*KEEP_STR*/"_message_ref_t")));
    RD.addDecl(FieldDecl.Create(Ctx, RD, new SourceLocation(), new SourceLocation(), 
            (IdentifierInfo /*P*/ )null, Ctx.VoidPtrTy.$QualType(), (TypeSourceInfo /*P*/ )null, (Expr /*P*/ )null, false, 
            InClassInitStyle.ICIS_NoInit));
    RD.addDecl(FieldDecl.Create(Ctx, RD, new SourceLocation(), new SourceLocation(), 
            (IdentifierInfo /*P*/ )null, Ctx.getObjCSelType(), (TypeSourceInfo /*P*/ )null, (Expr /*P*/ )null, 
            false, InClassInitStyle.ICIS_NoInit));
    RD.completeDefinition();
    
    MessageRefCTy.$assignMove(Ctx.getTagDeclType(RD));
    MessageRefCPtrTy.$assignMove(Ctx.getPointerType(/*NO_COPY*/MessageRefCTy));
    MessageRefTy = cast_StructType(Types.ConvertType(new QualType(MessageRefCTy)));
    
    // MessageRefPtrTy - LLVM for struct _message_ref_t*
    MessageRefPtrTy = PointerType.getUnqual(MessageRefTy);
    
    // SuperMessageRefTy - LLVM for:
    // struct _super_message_ref_t {
    //   SUPER_IMP messenger;
    //   SEL name;
    // };
    SuperMessageRefTy
       = StructType.create(new StringRef(/*KEEP_STR*/"struct._super_message_ref_t"), 
        ImpnfABITy, SelectorPtrTy, null);
    
    // SuperMessageRefPtrTy - LLVM for struct _super_message_ref_t*
    SuperMessageRefPtrTy = PointerType.getUnqual(SuperMessageRefTy);
    
    // struct objc_typeinfo {
    //   const void** vtable; // objc_ehtype_vtable + 2
    //   const char*  name;    // c++ typeinfo string
    //   Class        cls;
    // };
    EHTypeTy
       = StructType.create(new StringRef(/*KEEP_STR*/"struct._objc_typeinfo"), 
        PointerType.getUnqual(Int8PtrTy), 
        Int8PtrTy, ClassnfABIPtrTy, null);
    EHTypePtrTy = PointerType.getUnqual(EHTypeTy);
  }

  
  @Override public String toString() {
    return "" + "MethodListnfABITy=" + MethodListnfABITy // NOI18N
              + ", MethodListnfABIPtrTy=" + MethodListnfABIPtrTy // NOI18N
              + ", ProtocolnfABITy=" + ProtocolnfABITy // NOI18N
              + ", ProtocolnfABIPtrTy=" + ProtocolnfABIPtrTy // NOI18N
              + ", ProtocolListnfABITy=" + ProtocolListnfABITy // NOI18N
              + ", ProtocolListnfABIPtrTy=" + ProtocolListnfABIPtrTy // NOI18N
              + ", ClassnfABITy=" + ClassnfABITy // NOI18N
              + ", ClassnfABIPtrTy=" + ClassnfABIPtrTy // NOI18N
              + ", IvarnfABITy=" + IvarnfABITy // NOI18N
              + ", IvarListnfABITy=" + IvarListnfABITy // NOI18N
              + ", IvarListnfABIPtrTy=" + IvarListnfABIPtrTy // NOI18N
              + ", ClassRonfABITy=" + ClassRonfABITy // NOI18N
              + ", ImpnfABITy=" + ImpnfABITy // NOI18N
              + ", CategorynfABITy=" + CategorynfABITy // NOI18N
              + ", MessageRefTy=" + MessageRefTy // NOI18N
              + ", MessageRefCTy=" + MessageRefCTy // NOI18N
              + ", MessageRefPtrTy=" + MessageRefPtrTy // NOI18N
              + ", MessageRefCPtrTy=" + MessageRefCPtrTy // NOI18N
              + ", SuperMessageRefTy=" + SuperMessageRefTy // NOI18N
              + ", SuperMessageRefPtrTy=" + SuperMessageRefPtrTy // NOI18N
              + ", EHTypeTy=" + EHTypeTy // NOI18N
              + ", EHTypePtrTy=" + EHTypePtrTy // NOI18N
              + super.toString(); // NOI18N
  }
}
