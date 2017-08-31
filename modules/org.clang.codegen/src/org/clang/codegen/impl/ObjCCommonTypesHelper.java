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
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.llvm.ir.*;
import org.clang.codegen.CodeGen.impl.*;
import org.llvm.ir.ArrayType;
import org.llvm.ir.FunctionType;
import org.llvm.ir.PointerType;
import org.llvm.ir.Type;
import static org.llvm.ir.java.IrRTTI.*;


// FIXME: We should find a nicer way to make the labels for metadata, string
// concatenation is lame.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCCommonTypesHelper">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 49,
 FQN="(anonymous namespace)::ObjCCommonTypesHelper", NM="_ZN12_GLOBAL__N_121ObjCCommonTypesHelperE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_121ObjCCommonTypesHelperE")
//</editor-fold>
public class ObjCCommonTypesHelper {
/*protected:*/
  protected final LLVMContext /*&*/ VMContext;
/*private:*/
  // The types of these functions don't really matter because we
  // should always bitcast before calling them.
  
  /// id objc_msgSend (id, SEL, ...)
  /// 
  /// The default messenger, used for sends whose ABI is unchanged from
  /// the all-integer/pointer case.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCCommonTypesHelper::getMessageSendFn">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 61,
   FQN="(anonymous namespace)::ObjCCommonTypesHelper::getMessageSendFn", NM="_ZNK12_GLOBAL__N_121ObjCCommonTypesHelper16getMessageSendFnEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZNK12_GLOBAL__N_121ObjCCommonTypesHelper16getMessageSendFnEv")
  //</editor-fold>
  private Constant /*P*/ getMessageSendFn() /*const*/ {
    // Add the non-lazy-bind attribute, since objc_msgSend is likely to
    // be called a lot.
    Type /*P*/ params[/*2*/] = new Type /*P*/  [/*2*/] {ObjectPtrTy, SelectorPtrTy};
    return CGM.CreateRuntimeFunction(FunctionType.get(ObjectPtrTy, 
            new ArrayRef<Type /*P*/ >(params, true), true), 
        new StringRef(/*KEEP_STR*/"objc_msgSend"), 
        AttributeSet.get_LLVMContext_uint_ArrayRef$AttrKind(CGM.getLLVMContext(), 
            AttributeSet.AttrIndex.FunctionIndex.getValue(), 
            new ArrayRef<Attribute.AttrKind>(Attribute.AttrKind.NonLazyBind)));
  }

  
  /// void objc_msgSend_stret (id, SEL, ...)
  ///
  /// The messenger used when the return value is an aggregate returned
  /// by indirect reference in the first argument, and therefore the
  /// self and selector parameters are shifted over by one.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCCommonTypesHelper::getMessageSendStretFn">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 79,
   FQN="(anonymous namespace)::ObjCCommonTypesHelper::getMessageSendStretFn", NM="_ZNK12_GLOBAL__N_121ObjCCommonTypesHelper21getMessageSendStretFnEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZNK12_GLOBAL__N_121ObjCCommonTypesHelper21getMessageSendStretFnEv")
  //</editor-fold>
  private Constant /*P*/ getMessageSendStretFn() /*const*/ {
    Type /*P*/ params[/*2*/] = new Type /*P*/  [/*2*/] {ObjectPtrTy, SelectorPtrTy};
    return CGM.CreateRuntimeFunction(FunctionType.get(CGM.VoidTy, 
            new ArrayRef<Type /*P*/ >(params, true), true), 
        new StringRef(/*KEEP_STR*/"objc_msgSend_stret"));
  }

  
  /// [double | long double] objc_msgSend_fpret(id self, SEL op, ...)
  ///
  /// The messenger used when the return value is returned on the x87
  /// floating-point stack; without a special entrypoint, the nil case
  /// would be unbalanced.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCCommonTypesHelper::getMessageSendFpretFn">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 92,
   FQN="(anonymous namespace)::ObjCCommonTypesHelper::getMessageSendFpretFn", NM="_ZNK12_GLOBAL__N_121ObjCCommonTypesHelper21getMessageSendFpretFnEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZNK12_GLOBAL__N_121ObjCCommonTypesHelper21getMessageSendFpretFnEv")
  //</editor-fold>
  private Constant /*P*/ getMessageSendFpretFn() /*const*/ {
    Type /*P*/ params[/*2*/] = new Type /*P*/  [/*2*/] {ObjectPtrTy, SelectorPtrTy};
    return CGM.CreateRuntimeFunction(FunctionType.get(CGM.DoubleTy, 
            new ArrayRef<Type /*P*/ >(params, true), true), 
        new StringRef(/*KEEP_STR*/"objc_msgSend_fpret"));
  }

  
  /// _Complex long double objc_msgSend_fp2ret(id self, SEL op, ...)
  ///
  /// The messenger used when the return value is returned in two values on the
  /// x87 floating point stack; without a special entrypoint, the nil case
  /// would be unbalanced. Only used on 64-bit X86.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCCommonTypesHelper::getMessageSendFp2retFn">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 105,
   FQN="(anonymous namespace)::ObjCCommonTypesHelper::getMessageSendFp2retFn", NM="_ZNK12_GLOBAL__N_121ObjCCommonTypesHelper22getMessageSendFp2retFnEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZNK12_GLOBAL__N_121ObjCCommonTypesHelper22getMessageSendFp2retFnEv")
  //</editor-fold>
  private Constant /*P*/ getMessageSendFp2retFn() /*const*/ {
    Type /*P*/ params[/*2*/] = new Type /*P*/  [/*2*/] {ObjectPtrTy, SelectorPtrTy};
    Type /*P*/ longDoubleType = Type.getX86_FP80Ty(VMContext);
    Type /*P*/ resultType = StructType.get(longDoubleType, longDoubleType, null);
    
    return CGM.CreateRuntimeFunction(FunctionType.get(resultType, 
            new ArrayRef<Type /*P*/ >(params, true), true), 
        new StringRef(/*KEEP_STR*/"objc_msgSend_fp2ret"));
  }

  
  /// id objc_msgSendSuper(struct objc_super *super, SEL op, ...)
  ///
  /// The messenger used for super calls, which have different dispatch
  /// semantics.  The class passed is the superclass of the current
  /// class.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCCommonTypesHelper::getMessageSendSuperFn">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 121,
   FQN="(anonymous namespace)::ObjCCommonTypesHelper::getMessageSendSuperFn", NM="_ZNK12_GLOBAL__N_121ObjCCommonTypesHelper21getMessageSendSuperFnEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZNK12_GLOBAL__N_121ObjCCommonTypesHelper21getMessageSendSuperFnEv")
  //</editor-fold>
  private Constant /*P*/ getMessageSendSuperFn() /*const*/ {
    Type /*P*/ params[/*2*/] = new Type /*P*/  [/*2*/] {SuperPtrTy, SelectorPtrTy};
    return CGM.CreateRuntimeFunction(FunctionType.get(ObjectPtrTy, 
            new ArrayRef<Type /*P*/ >(params, true), true), 
        new StringRef(/*KEEP_STR*/"objc_msgSendSuper"));
  }

  
  /// id objc_msgSendSuper2(struct objc_super *super, SEL op, ...)
  ///
  /// A slightly different messenger used for super calls.  The class
  /// passed is the current class.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCCommonTypesHelper::getMessageSendSuperFn2">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 132,
   FQN="(anonymous namespace)::ObjCCommonTypesHelper::getMessageSendSuperFn2", NM="_ZNK12_GLOBAL__N_121ObjCCommonTypesHelper22getMessageSendSuperFn2Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZNK12_GLOBAL__N_121ObjCCommonTypesHelper22getMessageSendSuperFn2Ev")
  //</editor-fold>
  private Constant /*P*/ getMessageSendSuperFn2() /*const*/ {
    Type /*P*/ params[/*2*/] = new Type /*P*/  [/*2*/] {SuperPtrTy, SelectorPtrTy};
    return CGM.CreateRuntimeFunction(FunctionType.get(ObjectPtrTy, 
            new ArrayRef<Type /*P*/ >(params, true), true), 
        new StringRef(/*KEEP_STR*/"objc_msgSendSuper2"));
  }

  
  /// void objc_msgSendSuper_stret(void *stretAddr, struct objc_super *super,
  ///                              SEL op, ...)
  ///
  /// The messenger used for super calls which return an aggregate indirectly.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCCommonTypesHelper::getMessageSendSuperStretFn">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 143,
   FQN="(anonymous namespace)::ObjCCommonTypesHelper::getMessageSendSuperStretFn", NM="_ZNK12_GLOBAL__N_121ObjCCommonTypesHelper26getMessageSendSuperStretFnEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZNK12_GLOBAL__N_121ObjCCommonTypesHelper26getMessageSendSuperStretFnEv")
  //</editor-fold>
  private Constant /*P*/ getMessageSendSuperStretFn() /*const*/ {
    Type /*P*/ params[/*3*/] = new Type /*P*/  [/*3*/] {Int8PtrTy, SuperPtrTy, SelectorPtrTy};
    return CGM.CreateRuntimeFunction(FunctionType.get(CGM.VoidTy, new ArrayRef<Type /*P*/ >(params, true), true), 
        new StringRef(/*KEEP_STR*/"objc_msgSendSuper_stret"));
  }

  
  /// void objc_msgSendSuper2_stret(void * stretAddr, struct objc_super *super,
  ///                               SEL op, ...)
  ///
  /// objc_msgSendSuper_stret with the super2 semantics.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCCommonTypesHelper::getMessageSendSuperStretFn2">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 154,
   FQN="(anonymous namespace)::ObjCCommonTypesHelper::getMessageSendSuperStretFn2", NM="_ZNK12_GLOBAL__N_121ObjCCommonTypesHelper27getMessageSendSuperStretFn2Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZNK12_GLOBAL__N_121ObjCCommonTypesHelper27getMessageSendSuperStretFn2Ev")
  //</editor-fold>
  private Constant /*P*/ getMessageSendSuperStretFn2() /*const*/ {
    Type /*P*/ params[/*3*/] = new Type /*P*/  [/*3*/] {Int8PtrTy, SuperPtrTy, SelectorPtrTy};
    return CGM.CreateRuntimeFunction(FunctionType.get(CGM.VoidTy, new ArrayRef<Type /*P*/ >(params, true), true), 
        new StringRef(/*KEEP_STR*/"objc_msgSendSuper2_stret"));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCCommonTypesHelper::getMessageSendSuperFpretFn">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 161,
   FQN="(anonymous namespace)::ObjCCommonTypesHelper::getMessageSendSuperFpretFn", NM="_ZNK12_GLOBAL__N_121ObjCCommonTypesHelper26getMessageSendSuperFpretFnEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZNK12_GLOBAL__N_121ObjCCommonTypesHelper26getMessageSendSuperFpretFnEv")
  //</editor-fold>
  private Constant /*P*/ getMessageSendSuperFpretFn() /*const*/ {
    // There is no objc_msgSendSuper_fpret? How can that work?
    return getMessageSendSuperFn();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCCommonTypesHelper::getMessageSendSuperFpretFn2">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 166,
   FQN="(anonymous namespace)::ObjCCommonTypesHelper::getMessageSendSuperFpretFn2", NM="_ZNK12_GLOBAL__N_121ObjCCommonTypesHelper27getMessageSendSuperFpretFn2Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZNK12_GLOBAL__N_121ObjCCommonTypesHelper27getMessageSendSuperFpretFn2Ev")
  //</editor-fold>
  private Constant /*P*/ getMessageSendSuperFpretFn2() /*const*/ {
    // There is no objc_msgSendSuper_fpret? How can that work?
    return getMessageSendSuperFn2();
  }

/*protected:*/
  protected final CodeGenModule /*&*/ CGM;
/*public:*/
  public Type /*P*/ ShortTy;
  public Type /*P*/ IntTy;
  public Type /*P*/ LongTy;
  public Type /*P*/ LongLongTy;
  public Type /*P*/ Int8PtrTy;
  public Type /*P*/ Int8PtrPtrTy;
  public Type /*P*/ IvarOffsetVarTy;
  
  /// ObjectPtrTy - LLVM type for object handles (typeof(id))
  public Type /*P*/ ObjectPtrTy;
  
  /// PtrObjectPtrTy - LLVM type for id *
  public Type /*P*/ PtrObjectPtrTy;
  
  /// SelectorPtrTy - LLVM type for selector handles (typeof(SEL))
  public Type /*P*/ SelectorPtrTy;
/*private:*/
  /// ProtocolPtrTy - LLVM type for external protocol handles
  /// (typeof(Protocol))
  private Type /*P*/ ExternalProtocolPtrTy;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCCommonTypesHelper::getExternalProtocolPtrTy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 194,
   FQN="(anonymous namespace)::ObjCCommonTypesHelper::getExternalProtocolPtrTy", NM="_ZN12_GLOBAL__N_121ObjCCommonTypesHelper24getExternalProtocolPtrTyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_121ObjCCommonTypesHelper24getExternalProtocolPtrTyEv")
  //</editor-fold>
  public Type /*P*/ getExternalProtocolPtrTy() {
    if (!(ExternalProtocolPtrTy != null)) {
      // FIXME: It would be nice to unify this with the opaque type, so that the
      // IR comes out a bit cleaner.
      final CodeGenTypes /*&*/ Types = CGM.getTypes();
      final ASTContext /*&*/ Ctx = CGM.getContext();
      Type /*P*/ T = Types.ConvertType(Ctx.getObjCProtoType());
      ExternalProtocolPtrTy = PointerType.getUnqual(T);
    }
    
    return ExternalProtocolPtrTy;
  }

  
  // SuperCTy - clang type for struct objc_super.
  public QualType SuperCTy;
  // SuperPtrCTy - clang type for struct objc_super *.
  public QualType SuperPtrCTy;
  
  /// SuperTy - LLVM type for struct objc_super.
  public StructType /*P*/ SuperTy;
  /// SuperPtrTy - LLVM type for struct objc_super *.
  public Type /*P*/ SuperPtrTy;
  
  /// PropertyTy - LLVM type for struct objc_property (struct _prop_t
  /// in GCC parlance).
  public StructType /*P*/ PropertyTy;
  
  /// PropertyListTy - LLVM type for struct objc_property_list
  /// (_prop_list_t in GCC parlance).
  public StructType /*P*/ PropertyListTy;
  /// PropertyListPtrTy - LLVM type for struct objc_property_list*.
  public Type /*P*/ PropertyListPtrTy;
  
  // MethodTy - LLVM type for struct objc_method.
  public StructType /*P*/ MethodTy;
  
  /// CacheTy - LLVM type for struct objc_cache.
  public Type /*P*/ CacheTy;
  /// CachePtrTy - LLVM type for struct objc_cache *.
  public Type /*P*/ CachePtrTy;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCCommonTypesHelper::getGetPropertyFn">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 235,
   FQN="(anonymous namespace)::ObjCCommonTypesHelper::getGetPropertyFn", NM="_ZN12_GLOBAL__N_121ObjCCommonTypesHelper16getGetPropertyFnEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_121ObjCCommonTypesHelper16getGetPropertyFnEv")
  //</editor-fold>
  public Constant /*P*/ getGetPropertyFn() {
    final CodeGenTypes /*&*/ Types = CGM.getTypes();
    final ASTContext /*&*/ Ctx = CGM.getContext();
    // id objc_getProperty (id, SEL, ptrdiff_t, bool)
    CanQual<org.clang.ast.Type> IdType = Ctx.getCanonicalParamType(Ctx.getObjCIdType());
    CanQual<org.clang.ast.Type> SelType = Ctx.getCanonicalParamType(Ctx.getObjCSelType());
    CanQual<org.clang.ast.Type> Params[/*4*/] = new CanQual[/*4*/] {
      IdType, SelType, 
      Ctx.getPointerDiffType().$arrow().getCanonicalTypeUnqualified(), Ctx.BoolTy};
    FunctionType /*P*/ FTy = Types.GetFunctionType(Types.arrangeBuiltinFunctionDeclaration(new CanQual<org.clang.ast.Type>(IdType), new ArrayRef<CanQual<org.clang.ast.Type>>(Params, false)));
    return CGM.CreateRuntimeFunction(FTy, new StringRef(/*KEEP_STR*/"objc_getProperty"));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCCommonTypesHelper::getSetPropertyFn">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 250,
   FQN="(anonymous namespace)::ObjCCommonTypesHelper::getSetPropertyFn", NM="_ZN12_GLOBAL__N_121ObjCCommonTypesHelper16getSetPropertyFnEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_121ObjCCommonTypesHelper16getSetPropertyFnEv")
  //</editor-fold>
  public Constant /*P*/ getSetPropertyFn() {
    final CodeGenTypes /*&*/ Types = CGM.getTypes();
    final ASTContext /*&*/ Ctx = CGM.getContext();
    // void objc_setProperty (id, SEL, ptrdiff_t, id, bool, bool)
    CanQual<org.clang.ast.Type> IdType = Ctx.getCanonicalParamType(Ctx.getObjCIdType());
    CanQual<org.clang.ast.Type> SelType = Ctx.getCanonicalParamType(Ctx.getObjCSelType());
    CanQual<org.clang.ast.Type> Params[/*6*/] = new CanQual [/*6*/] {
      IdType, 
      SelType, 
      Ctx.getPointerDiffType().$arrow().getCanonicalTypeUnqualified(), 
      IdType, 
      Ctx.BoolTy, 
      Ctx.BoolTy};
    FunctionType /*P*/ FTy = Types.GetFunctionType(Types.arrangeBuiltinFunctionDeclaration(new CanQual<org.clang.ast.Type>(Ctx.VoidTy), new ArrayRef<CanQual<org.clang.ast.Type>>(Params, false)));
    return CGM.CreateRuntimeFunction(FTy, new StringRef(/*KEEP_STR*/"objc_setProperty"));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCCommonTypesHelper::getOptimizedSetPropertyFn">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 269,
   FQN="(anonymous namespace)::ObjCCommonTypesHelper::getOptimizedSetPropertyFn", NM="_ZN12_GLOBAL__N_121ObjCCommonTypesHelper25getOptimizedSetPropertyFnEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_121ObjCCommonTypesHelper25getOptimizedSetPropertyFnEbb")
  //</editor-fold>
  public Constant /*P*/ getOptimizedSetPropertyFn(boolean atomic, boolean copy) {
    final CodeGenTypes /*&*/ Types = CGM.getTypes();
    final ASTContext /*&*/ Ctx = CGM.getContext();
    // void objc_setProperty_atomic(id self, SEL _cmd, 
    //                              id newValue, ptrdiff_t offset);
    // void objc_setProperty_nonatomic(id self, SEL _cmd, 
    //                                 id newValue, ptrdiff_t offset);
    // void objc_setProperty_atomic_copy(id self, SEL _cmd, 
    //                                   id newValue, ptrdiff_t offset);
    // void objc_setProperty_nonatomic_copy(id self, SEL _cmd, 
    //                                      id newValue, ptrdiff_t offset);
    SmallVector<CanQual<org.clang.ast.Type>> Params/*J*/= new SmallVector<CanQual<org.clang.ast.Type>>(4, new CanQual<org.clang.ast.Type>());
    CanQual<org.clang.ast.Type> IdType = Ctx.getCanonicalParamType(Ctx.getObjCIdType());
    CanQual<org.clang.ast.Type> SelType = Ctx.getCanonicalParamType(Ctx.getObjCSelType());
    Params.push_back(IdType);
    Params.push_back(SelType);
    Params.push_back(IdType);
    Params.push_back(Ctx.getPointerDiffType().$arrow().getCanonicalTypeUnqualified());
    FunctionType /*P*/ FTy = Types.GetFunctionType(Types.arrangeBuiltinFunctionDeclaration(new CanQual<org.clang.ast.Type>(Ctx.VoidTy), new ArrayRef<CanQual<org.clang.ast.Type>>(Params, false)));
    /*const*/char$ptr/*char P*/ name = create_char$ptr();
    if (atomic && copy) {
      name = $tryClone($("objc_setProperty_atomic_copy"));
    } else if (atomic && !copy) {
      name = $tryClone($("objc_setProperty_atomic"));
    } else if (!atomic && copy) {
      name = $tryClone($("objc_setProperty_nonatomic_copy"));
    } else {
      name = $tryClone($("objc_setProperty_nonatomic"));
    }
    
    return CGM.CreateRuntimeFunction(FTy, new StringRef(name));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCCommonTypesHelper::getCopyStructFn">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 304,
   FQN="(anonymous namespace)::ObjCCommonTypesHelper::getCopyStructFn", NM="_ZN12_GLOBAL__N_121ObjCCommonTypesHelper15getCopyStructFnEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_121ObjCCommonTypesHelper15getCopyStructFnEv")
  //</editor-fold>
  public Constant /*P*/ getCopyStructFn() {
    final CodeGenTypes /*&*/ Types = CGM.getTypes();
    final ASTContext /*&*/ Ctx = CGM.getContext();
    // void objc_copyStruct (void *, const void *, size_t, bool, bool)
    SmallVector<CanQual<org.clang.ast.Type>> Params/*J*/= new SmallVector<CanQual<org.clang.ast.Type>>(5, new CanQual<org.clang.ast.Type>());
    Params.push_back(Ctx.VoidPtrTy);
    Params.push_back(Ctx.VoidPtrTy);
    Params.push_back(Ctx.LongTy);
    Params.push_back(Ctx.BoolTy);
    Params.push_back(Ctx.BoolTy);
    FunctionType /*P*/ FTy = Types.GetFunctionType(Types.arrangeBuiltinFunctionDeclaration(new CanQual<org.clang.ast.Type>(Ctx.VoidTy), new ArrayRef<CanQual<org.clang.ast.Type>>(Params, false)));
    return CGM.CreateRuntimeFunction(FTy, new StringRef(/*KEEP_STR*/"objc_copyStruct"));
  }

  
  /// This routine declares and returns address of:
  /// void objc_copyCppObjectAtomic(
  ///         void *dest, const void *src, 
  ///         void (*copyHelper) (void *dest, const void *source));
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCCommonTypesHelper::getCppAtomicObjectFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 324,
   FQN="(anonymous namespace)::ObjCCommonTypesHelper::getCppAtomicObjectFunction", NM="_ZN12_GLOBAL__N_121ObjCCommonTypesHelper26getCppAtomicObjectFunctionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_121ObjCCommonTypesHelper26getCppAtomicObjectFunctionEv")
  //</editor-fold>
  public Constant /*P*/ getCppAtomicObjectFunction() {
    final CodeGenTypes /*&*/ Types = CGM.getTypes();
    final ASTContext /*&*/ Ctx = CGM.getContext();
    /// void objc_copyCppObjectAtomic(void *dest, const void *src, void *helper);
    SmallVector<CanQual<org.clang.ast.Type>> Params/*J*/= new SmallVector<CanQual<org.clang.ast.Type>>(3, new CanQual<org.clang.ast.Type>());
    Params.push_back(Ctx.VoidPtrTy);
    Params.push_back(Ctx.VoidPtrTy);
    Params.push_back(Ctx.VoidPtrTy);
    FunctionType /*P*/ FTy = Types.GetFunctionType(Types.arrangeBuiltinFunctionDeclaration(new CanQual<org.clang.ast.Type>(Ctx.VoidTy), new ArrayRef<CanQual<org.clang.ast.Type>>(Params, false)));
    return CGM.CreateRuntimeFunction(FTy, new StringRef(/*KEEP_STR*/"objc_copyCppObjectAtomic"));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCCommonTypesHelper::getEnumerationMutationFn">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 338,
   FQN="(anonymous namespace)::ObjCCommonTypesHelper::getEnumerationMutationFn", NM="_ZN12_GLOBAL__N_121ObjCCommonTypesHelper24getEnumerationMutationFnEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_121ObjCCommonTypesHelper24getEnumerationMutationFnEv")
  //</editor-fold>
  public Constant /*P*/ getEnumerationMutationFn() {
    final CodeGenTypes /*&*/ Types = CGM.getTypes();
    final ASTContext /*&*/ Ctx = CGM.getContext();
    // void objc_enumerationMutation (id)
    SmallVector<CanQual<org.clang.ast.Type>> Params/*J*/= new SmallVector<CanQual<org.clang.ast.Type>>(1, new CanQual<org.clang.ast.Type>());
    Params.push_back(Ctx.getCanonicalParamType(Ctx.getObjCIdType()));
    FunctionType /*P*/ FTy = Types.GetFunctionType(Types.arrangeBuiltinFunctionDeclaration(new CanQual<org.clang.ast.Type>(Ctx.VoidTy), new ArrayRef<CanQual<org.clang.ast.Type>>(Params, false)));
    return CGM.CreateRuntimeFunction(FTy, new StringRef(/*KEEP_STR*/"objc_enumerationMutation"));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCCommonTypesHelper::getLookUpClassFn">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 350,
   FQN="(anonymous namespace)::ObjCCommonTypesHelper::getLookUpClassFn", NM="_ZN12_GLOBAL__N_121ObjCCommonTypesHelper16getLookUpClassFnEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_121ObjCCommonTypesHelper16getLookUpClassFnEv")
  //</editor-fold>
  public Constant /*P*/ getLookUpClassFn() {
    final CodeGenTypes /*&*/ Types = CGM.getTypes();
    final ASTContext /*&*/ Ctx = CGM.getContext();
    // Class objc_lookUpClass (const char *)
    SmallVector<CanQual<org.clang.ast.Type>> Params/*J*/= new SmallVector<CanQual<org.clang.ast.Type>>(1, new CanQual<org.clang.ast.Type>());
    Params.push_back(Ctx.getCanonicalType(Ctx.getPointerType(Ctx.CharTy.withConst())));
    FunctionType /*P*/ FTy = Types.GetFunctionType(Types.arrangeBuiltinFunctionDeclaration(Ctx.getCanonicalType(Ctx.getObjCClassType()), 
            new ArrayRef<CanQual<org.clang.ast.Type>>(Params, false)));
    return CGM.CreateRuntimeFunction(FTy, new StringRef(/*KEEP_STR*/"objc_lookUpClass"));
  }

  
  /// GcReadWeakFn -- LLVM objc_read_weak (id *src) function.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCCommonTypesHelper::getGcReadWeakFn">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 365,
   FQN="(anonymous namespace)::ObjCCommonTypesHelper::getGcReadWeakFn", NM="_ZN12_GLOBAL__N_121ObjCCommonTypesHelper15getGcReadWeakFnEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_121ObjCCommonTypesHelper15getGcReadWeakFnEv")
  //</editor-fold>
  public Constant /*P*/ getGcReadWeakFn() {
    // id objc_read_weak (id *)
    Type /*P*/ args[/*1*/] = new Type /*P*/  [/*1*/] {ObjectPtrTy.getPointerTo()};
    FunctionType /*P*/ FTy = FunctionType.get(ObjectPtrTy, new ArrayRef<Type /*P*/ >(args, true), false);
    return CGM.CreateRuntimeFunction(FTy, new StringRef(/*KEEP_STR*/"objc_read_weak"));
  }

  
  /// GcAssignWeakFn -- LLVM objc_assign_weak function.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCCommonTypesHelper::getGcAssignWeakFn">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 374,
   FQN="(anonymous namespace)::ObjCCommonTypesHelper::getGcAssignWeakFn", NM="_ZN12_GLOBAL__N_121ObjCCommonTypesHelper17getGcAssignWeakFnEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_121ObjCCommonTypesHelper17getGcAssignWeakFnEv")
  //</editor-fold>
  public Constant /*P*/ getGcAssignWeakFn() {
    // id objc_assign_weak (id, id *)
    Type /*P*/ args[/*2*/] = new Type /*P*/  [/*2*/] {ObjectPtrTy, ObjectPtrTy.getPointerTo()};
    FunctionType /*P*/ FTy = FunctionType.get(ObjectPtrTy, new ArrayRef<Type /*P*/ >(args, true), false);
    return CGM.CreateRuntimeFunction(FTy, new StringRef(/*KEEP_STR*/"objc_assign_weak"));
  }

  
  /// GcAssignGlobalFn -- LLVM objc_assign_global function.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCCommonTypesHelper::getGcAssignGlobalFn">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 383,
   FQN="(anonymous namespace)::ObjCCommonTypesHelper::getGcAssignGlobalFn", NM="_ZN12_GLOBAL__N_121ObjCCommonTypesHelper19getGcAssignGlobalFnEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_121ObjCCommonTypesHelper19getGcAssignGlobalFnEv")
  //</editor-fold>
  public Constant /*P*/ getGcAssignGlobalFn() {
    // id objc_assign_global(id, id *)
    Type /*P*/ args[/*2*/] = new Type /*P*/  [/*2*/] {ObjectPtrTy, ObjectPtrTy.getPointerTo()};
    FunctionType /*P*/ FTy = FunctionType.get(ObjectPtrTy, new ArrayRef<Type /*P*/ >(args, true), false);
    return CGM.CreateRuntimeFunction(FTy, new StringRef(/*KEEP_STR*/"objc_assign_global"));
  }

  
  /// GcAssignThreadLocalFn -- LLVM objc_assign_threadlocal function.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCCommonTypesHelper::getGcAssignThreadLocalFn">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 392,
   FQN="(anonymous namespace)::ObjCCommonTypesHelper::getGcAssignThreadLocalFn", NM="_ZN12_GLOBAL__N_121ObjCCommonTypesHelper24getGcAssignThreadLocalFnEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_121ObjCCommonTypesHelper24getGcAssignThreadLocalFnEv")
  //</editor-fold>
  public Constant /*P*/ getGcAssignThreadLocalFn() {
    // id objc_assign_threadlocal(id src, id * dest)
    Type /*P*/ args[/*2*/] = new Type /*P*/  [/*2*/] {ObjectPtrTy, ObjectPtrTy.getPointerTo()};
    FunctionType /*P*/ FTy = FunctionType.get(ObjectPtrTy, new ArrayRef<Type /*P*/ >(args, true), false);
    return CGM.CreateRuntimeFunction(FTy, new StringRef(/*KEEP_STR*/"objc_assign_threadlocal"));
  }

  
  /// GcAssignIvarFn -- LLVM objc_assign_ivar function.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCCommonTypesHelper::getGcAssignIvarFn">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 401,
   FQN="(anonymous namespace)::ObjCCommonTypesHelper::getGcAssignIvarFn", NM="_ZN12_GLOBAL__N_121ObjCCommonTypesHelper17getGcAssignIvarFnEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_121ObjCCommonTypesHelper17getGcAssignIvarFnEv")
  //</editor-fold>
  public Constant /*P*/ getGcAssignIvarFn() {
    // id objc_assign_ivar(id, id *, ptrdiff_t)
    Type /*P*/ args[/*3*/] = new Type /*P*/  [/*3*/] {
      ObjectPtrTy, ObjectPtrTy.getPointerTo(), 
      CGM.Unnamed_field8.PtrDiffTy};
    FunctionType /*P*/ FTy = FunctionType.get(ObjectPtrTy, new ArrayRef<Type /*P*/ >(args, true), false);
    return CGM.CreateRuntimeFunction(FTy, new StringRef(/*KEEP_STR*/"objc_assign_ivar"));
  }

  
  /// GcMemmoveCollectableFn -- LLVM objc_memmove_collectable function.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCCommonTypesHelper::GcMemmoveCollectableFn">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 411,
   FQN="(anonymous namespace)::ObjCCommonTypesHelper::GcMemmoveCollectableFn", NM="_ZN12_GLOBAL__N_121ObjCCommonTypesHelper22GcMemmoveCollectableFnEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_121ObjCCommonTypesHelper22GcMemmoveCollectableFnEv")
  //</editor-fold>
  public Constant /*P*/ GcMemmoveCollectableFn() {
    // void *objc_memmove_collectable(void *dst, const void *src, size_t size)
    Type /*P*/ args[/*3*/] = new Type /*P*/  [/*3*/] {Int8PtrTy, Int8PtrTy, LongTy};
    FunctionType /*P*/ FTy = FunctionType.get(Int8PtrTy, new ArrayRef<Type /*P*/ >(args, true), false);
    return CGM.CreateRuntimeFunction(FTy, new StringRef(/*KEEP_STR*/"objc_memmove_collectable"));
  }

  
  /// GcAssignStrongCastFn -- LLVM objc_assign_strongCast function.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCCommonTypesHelper::getGcAssignStrongCastFn">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 419,
   FQN="(anonymous namespace)::ObjCCommonTypesHelper::getGcAssignStrongCastFn", NM="_ZN12_GLOBAL__N_121ObjCCommonTypesHelper23getGcAssignStrongCastFnEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_121ObjCCommonTypesHelper23getGcAssignStrongCastFnEv")
  //</editor-fold>
  public Constant /*P*/ getGcAssignStrongCastFn() {
    // id objc_assign_strongCast(id, id *)
    Type /*P*/ args[/*2*/] = new Type /*P*/  [/*2*/] {ObjectPtrTy, ObjectPtrTy.getPointerTo()};
    FunctionType /*P*/ FTy = FunctionType.get(ObjectPtrTy, new ArrayRef<Type /*P*/ >(args, true), false);
    return CGM.CreateRuntimeFunction(FTy, new StringRef(/*KEEP_STR*/"objc_assign_strongCast"));
  }

  
  /// ExceptionThrowFn - LLVM objc_exception_throw function.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCCommonTypesHelper::getExceptionThrowFn">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 428,
   FQN="(anonymous namespace)::ObjCCommonTypesHelper::getExceptionThrowFn", NM="_ZN12_GLOBAL__N_121ObjCCommonTypesHelper19getExceptionThrowFnEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_121ObjCCommonTypesHelper19getExceptionThrowFnEv")
  //</editor-fold>
  public Constant /*P*/ getExceptionThrowFn() {
    // void objc_exception_throw(id)
    Type /*P*/ args[/*1*/] = new Type /*P*/  [/*1*/] {ObjectPtrTy};
    FunctionType /*P*/ FTy = FunctionType.get(CGM.VoidTy, new ArrayRef<Type /*P*/ >(args, true), false);
    return CGM.CreateRuntimeFunction(FTy, new StringRef(/*KEEP_STR*/"objc_exception_throw"));
  }

  
  /// ExceptionRethrowFn - LLVM objc_exception_rethrow function.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCCommonTypesHelper::getExceptionRethrowFn">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 437,
   FQN="(anonymous namespace)::ObjCCommonTypesHelper::getExceptionRethrowFn", NM="_ZN12_GLOBAL__N_121ObjCCommonTypesHelper21getExceptionRethrowFnEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_121ObjCCommonTypesHelper21getExceptionRethrowFnEv")
  //</editor-fold>
  public Constant /*P*/ getExceptionRethrowFn() {
    // void objc_exception_rethrow(void)
    FunctionType /*P*/ FTy = FunctionType.get(CGM.VoidTy, false);
    return CGM.CreateRuntimeFunction(FTy, new StringRef(/*KEEP_STR*/"objc_exception_rethrow"));
  }

  
  /// SyncEnterFn - LLVM object_sync_enter function.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCCommonTypesHelper::getSyncEnterFn">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 444,
   FQN="(anonymous namespace)::ObjCCommonTypesHelper::getSyncEnterFn", NM="_ZN12_GLOBAL__N_121ObjCCommonTypesHelper14getSyncEnterFnEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_121ObjCCommonTypesHelper14getSyncEnterFnEv")
  //</editor-fold>
  public Constant /*P*/ getSyncEnterFn() {
    // int objc_sync_enter (id)
    Type /*P*/ args[/*1*/] = new Type /*P*/  [/*1*/] {ObjectPtrTy};
    FunctionType /*P*/ FTy = FunctionType.get(CGM.IntTy, new ArrayRef<Type /*P*/ >(args, true), false);
    return CGM.CreateRuntimeFunction(FTy, new StringRef(/*KEEP_STR*/"objc_sync_enter"));
  }

  
  /// SyncExitFn - LLVM object_sync_exit function.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCCommonTypesHelper::getSyncExitFn">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 453,
   FQN="(anonymous namespace)::ObjCCommonTypesHelper::getSyncExitFn", NM="_ZN12_GLOBAL__N_121ObjCCommonTypesHelper13getSyncExitFnEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_121ObjCCommonTypesHelper13getSyncExitFnEv")
  //</editor-fold>
  public Constant /*P*/ getSyncExitFn() {
    // int objc_sync_exit (id)
    Type /*P*/ args[/*1*/] = new Type /*P*/  [/*1*/] {ObjectPtrTy};
    FunctionType /*P*/ FTy = FunctionType.get(CGM.IntTy, new ArrayRef<Type /*P*/ >(args, true), false);
    return CGM.CreateRuntimeFunction(FTy, new StringRef(/*KEEP_STR*/"objc_sync_exit"));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCCommonTypesHelper::getSendFn">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 461,
   FQN="(anonymous namespace)::ObjCCommonTypesHelper::getSendFn", NM="_ZNK12_GLOBAL__N_121ObjCCommonTypesHelper9getSendFnEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZNK12_GLOBAL__N_121ObjCCommonTypesHelper9getSendFnEb")
  //</editor-fold>
  public Constant /*P*/ getSendFn(boolean IsSuper) /*const*/ {
    return IsSuper ? getMessageSendSuperFn() : getMessageSendFn();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCCommonTypesHelper::getSendFn2">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 465,
   FQN="(anonymous namespace)::ObjCCommonTypesHelper::getSendFn2", NM="_ZNK12_GLOBAL__N_121ObjCCommonTypesHelper10getSendFn2Eb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZNK12_GLOBAL__N_121ObjCCommonTypesHelper10getSendFn2Eb")
  //</editor-fold>
  public Constant /*P*/ getSendFn2(boolean IsSuper) /*const*/ {
    return IsSuper ? getMessageSendSuperFn2() : getMessageSendFn();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCCommonTypesHelper::getSendStretFn">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 469,
   FQN="(anonymous namespace)::ObjCCommonTypesHelper::getSendStretFn", NM="_ZNK12_GLOBAL__N_121ObjCCommonTypesHelper14getSendStretFnEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZNK12_GLOBAL__N_121ObjCCommonTypesHelper14getSendStretFnEb")
  //</editor-fold>
  public Constant /*P*/ getSendStretFn(boolean IsSuper) /*const*/ {
    return IsSuper ? getMessageSendSuperStretFn() : getMessageSendStretFn();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCCommonTypesHelper::getSendStretFn2">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 473,
   FQN="(anonymous namespace)::ObjCCommonTypesHelper::getSendStretFn2", NM="_ZNK12_GLOBAL__N_121ObjCCommonTypesHelper15getSendStretFn2Eb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZNK12_GLOBAL__N_121ObjCCommonTypesHelper15getSendStretFn2Eb")
  //</editor-fold>
  public Constant /*P*/ getSendStretFn2(boolean IsSuper) /*const*/ {
    return IsSuper ? getMessageSendSuperStretFn2() : getMessageSendStretFn();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCCommonTypesHelper::getSendFpretFn">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 477,
   FQN="(anonymous namespace)::ObjCCommonTypesHelper::getSendFpretFn", NM="_ZNK12_GLOBAL__N_121ObjCCommonTypesHelper14getSendFpretFnEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZNK12_GLOBAL__N_121ObjCCommonTypesHelper14getSendFpretFnEb")
  //</editor-fold>
  public Constant /*P*/ getSendFpretFn(boolean IsSuper) /*const*/ {
    return IsSuper ? getMessageSendSuperFpretFn() : getMessageSendFpretFn();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCCommonTypesHelper::getSendFpretFn2">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 481,
   FQN="(anonymous namespace)::ObjCCommonTypesHelper::getSendFpretFn2", NM="_ZNK12_GLOBAL__N_121ObjCCommonTypesHelper15getSendFpretFn2Eb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZNK12_GLOBAL__N_121ObjCCommonTypesHelper15getSendFpretFn2Eb")
  //</editor-fold>
  public Constant /*P*/ getSendFpretFn2(boolean IsSuper) /*const*/ {
    return IsSuper ? getMessageSendSuperFpretFn2() : getMessageSendFpretFn();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCCommonTypesHelper::getSendFp2retFn">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 485,
   FQN="(anonymous namespace)::ObjCCommonTypesHelper::getSendFp2retFn", NM="_ZNK12_GLOBAL__N_121ObjCCommonTypesHelper15getSendFp2retFnEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZNK12_GLOBAL__N_121ObjCCommonTypesHelper15getSendFp2retFnEb")
  //</editor-fold>
  public Constant /*P*/ getSendFp2retFn(boolean IsSuper) /*const*/ {
    return IsSuper ? getMessageSendSuperFn() : getMessageSendFp2retFn();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCCommonTypesHelper::getSendFp2RetFn2">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 489,
   FQN="(anonymous namespace)::ObjCCommonTypesHelper::getSendFp2RetFn2", NM="_ZNK12_GLOBAL__N_121ObjCCommonTypesHelper16getSendFp2RetFn2Eb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZNK12_GLOBAL__N_121ObjCCommonTypesHelper16getSendFp2RetFn2Eb")
  //</editor-fold>
  public Constant /*P*/ getSendFp2RetFn2(boolean IsSuper) /*const*/ {
    return IsSuper ? getMessageSendSuperFn2() : getMessageSendFp2retFn();
  }

  
  
  /* *** */
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCCommonTypesHelper::ObjCCommonTypesHelper">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp", line = 5214,
   FQN="(anonymous namespace)::ObjCCommonTypesHelper::ObjCCommonTypesHelper", NM="_ZN12_GLOBAL__N_121ObjCCommonTypesHelperC1ERN5clang7CodeGen13CodeGenModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCMac.cpp -nm=_ZN12_GLOBAL__N_121ObjCCommonTypesHelperC1ERN5clang7CodeGen13CodeGenModuleE")
  //</editor-fold>
  public ObjCCommonTypesHelper(final CodeGenModule /*&*/ cgm) {
    // : VMContext(cgm.getLLVMContext()), CGM(cgm), ExternalProtocolPtrTy(null), SuperCTy(), SuperPtrCTy() 
    //START JInit
    this./*&*/VMContext=/*&*/cgm.getLLVMContext();
    this./*&*/CGM=/*&*/cgm;
    this.ExternalProtocolPtrTy = null;
    this.SuperCTy = new QualType();
    this.SuperPtrCTy = new QualType();
    //END JInit
    final CodeGenTypes /*&*/ Types = CGM.getTypes();
    final ASTContext /*&*/ Ctx = CGM.getContext();
    
    ShortTy = Types.ConvertType(Ctx.ShortTy.$QualType());
    IntTy = Types.ConvertType(Ctx.IntTy.$QualType());
    LongTy = Types.ConvertType(Ctx.LongTy.$QualType());
    LongLongTy = Types.ConvertType(Ctx.LongLongTy.$QualType());
    Int8PtrTy = CGM.Unnamed_field9.Int8PtrTy;
    Int8PtrPtrTy = CGM.Unnamed_field10.Int8PtrPtrTy;
    
    // arm64 targets use "int" ivar offset variables. All others,
    // including OS X x86_64 and Windows x86_64, use "long" ivar offsets.
    if (CGM.getTarget().getTriple().getArch() == Triple.ArchType.aarch64) {
      IvarOffsetVarTy = IntTy;
    } else {
      IvarOffsetVarTy = LongTy;
    }
    
    ObjectPtrTy = Types.ConvertType(Ctx.getObjCIdType());
    PtrObjectPtrTy = PointerType.getUnqual(ObjectPtrTy);
    SelectorPtrTy = Types.ConvertType(Ctx.getObjCSelType());
    
    // I'm not sure I like this. The implicit coordination is a bit
    // gross. We should solve this in a reasonable fashion because this
    // is a pretty common task (match some runtime data structure with
    // an LLVM data structure).
    
    // FIXME: This is leaked.
    // FIXME: Merge with rewriter code?
    
    // struct _objc_super {
    //   id self;
    //   Class cls;
    // }
    RecordDecl /*P*/ RD = RecordDecl.Create(Ctx, TagTypeKind.TTK_Struct, 
        Ctx.getTranslationUnitDecl(), 
        new SourceLocation(), new SourceLocation(), 
        /*AddrOf*/Ctx.Idents.get(new StringRef(/*KEEP_STR*/"_objc_super")));
    RD.addDecl(FieldDecl.Create(Ctx, RD, new SourceLocation(), new SourceLocation(), 
            (IdentifierInfo /*P*/ )null, Ctx.getObjCIdType(), (TypeSourceInfo /*P*/ )null, (Expr /*P*/ )null, 
            false, InClassInitStyle.ICIS_NoInit));
    RD.addDecl(FieldDecl.Create(Ctx, RD, new SourceLocation(), new SourceLocation(), 
            (IdentifierInfo /*P*/ )null, Ctx.getObjCClassType(), (TypeSourceInfo /*P*/ )null, 
            (Expr /*P*/ )null, false, InClassInitStyle.ICIS_NoInit));
    RD.completeDefinition();
    
    SuperCTy.$assignMove(Ctx.getTagDeclType(RD));
    SuperPtrCTy.$assignMove(Ctx.getPointerType(/*NO_COPY*/SuperCTy));
    
    SuperTy = cast_StructType(Types.ConvertType(new QualType(SuperCTy)));
    SuperPtrTy = PointerType.getUnqual(SuperTy);
    
    // struct _prop_t {
    //   char *name;
    //   char *attributes;
    // }
    PropertyTy = StructType.create(new StringRef(/*KEEP_STR*/"struct._prop_t"), 
        Int8PtrTy, Int8PtrTy, null);
    
    // struct _prop_list_t {
    //   uint32_t entsize;      // sizeof(struct _prop_t)
    //   uint32_t count_of_properties;
    //   struct _prop_t prop_list[count_of_properties];
    // }
    PropertyListTy
       = StructType.create(new StringRef(/*KEEP_STR*/"struct._prop_list_t"), IntTy, IntTy, 
        ArrayType.get(PropertyTy, $int2ulong(0)), null);
    // struct _prop_list_t *
    PropertyListPtrTy = PointerType.getUnqual(PropertyListTy);
    
    // struct _objc_method {
    //   SEL _cmd;
    //   char *method_type;
    //   char *_imp;
    // }
    MethodTy = StructType.create(new StringRef(/*KEEP_STR*/"struct._objc_method"), 
        SelectorPtrTy, Int8PtrTy, Int8PtrTy, 
        null);
    
    // struct _objc_cache *
    CacheTy = StructType.create(VMContext, new StringRef(/*KEEP_STR*/"struct._objc_cache"));
    CachePtrTy = PointerType.getUnqual(CacheTy);
  }

  
  @Override public String toString() {
    return "" + "VMContext=" + "[LLVMContext]" // NOI18N
              + ", CGM=" + CGM // NOI18N
              + ", ShortTy=" + ShortTy // NOI18N
              + ", IntTy=" + IntTy // NOI18N
              + ", LongTy=" + LongTy // NOI18N
              + ", LongLongTy=" + LongLongTy // NOI18N
              + ", Int8PtrTy=" + Int8PtrTy // NOI18N
              + ", Int8PtrPtrTy=" + Int8PtrPtrTy // NOI18N
              + ", IvarOffsetVarTy=" + IvarOffsetVarTy // NOI18N
              + ", ObjectPtrTy=" + ObjectPtrTy // NOI18N
              + ", PtrObjectPtrTy=" + PtrObjectPtrTy // NOI18N
              + ", SelectorPtrTy=" + SelectorPtrTy // NOI18N
              + ", ExternalProtocolPtrTy=" + ExternalProtocolPtrTy // NOI18N
              + ", SuperCTy=" + SuperCTy // NOI18N
              + ", SuperPtrCTy=" + SuperPtrCTy // NOI18N
              + ", SuperTy=" + SuperTy // NOI18N
              + ", SuperPtrTy=" + SuperPtrTy // NOI18N
              + ", PropertyTy=" + PropertyTy // NOI18N
              + ", PropertyListTy=" + PropertyListTy // NOI18N
              + ", PropertyListPtrTy=" + PropertyListPtrTy // NOI18N
              + ", MethodTy=" + MethodTy // NOI18N
              + ", CacheTy=" + CacheTy // NOI18N
              + ", CachePtrTy=" + CachePtrTy; // NOI18N
  }
}
