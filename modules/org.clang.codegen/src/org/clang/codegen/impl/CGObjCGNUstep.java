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
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.llvm.ir.*;
import org.clang.codegen.CodeGen.impl.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clank.support.Native.$AddrOf;


/// Class used when targeting the new GNUstep runtime ABI.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCGNUstep">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp", line = 650,
 FQN="(anonymous namespace)::CGObjCGNUstep", NM="_ZN12_GLOBAL__N_113CGObjCGNUstepE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp -nm=_ZN12_GLOBAL__N_113CGObjCGNUstepE")
//</editor-fold>
public class CGObjCGNUstep extends /*public*/ CGObjCGNU implements Destructors.ClassWithDestructor {
  /// The slot lookup function.  Returns a pointer to a cacheable structure
  /// that contains (among other things) the IMP.
  private LazyRuntimeFunction SlotLookupFn;
  /// The GNUstep ABI superclass message lookup function.  Takes a pointer to
  /// a structure describing the receiver and the class, and a selector as
  /// arguments.  Returns the slot for the corresponding method.  Superclass
  /// message lookup rarely changes, so this is a good caching opportunity.
  private LazyRuntimeFunction SlotLookupSuperFn;
  /// Specialised function for setting atomic retain properties
  private LazyRuntimeFunction SetPropertyAtomic;
  /// Specialised function for setting atomic copy properties
  private LazyRuntimeFunction SetPropertyAtomicCopy;
  /// Specialised function for setting nonatomic retain properties
  private LazyRuntimeFunction SetPropertyNonAtomic;
  /// Specialised function for setting nonatomic copy properties
  private LazyRuntimeFunction SetPropertyNonAtomicCopy;
  /// Function to perform atomic copies of C++ objects with nontrivial copy
  /// constructors from Objective-C ivars.
  private LazyRuntimeFunction CxxAtomicObjectGetFn;
  /// Function to perform atomic copies of C++ objects with nontrivial copy
  /// constructors to Objective-C ivars.
  private LazyRuntimeFunction CxxAtomicObjectSetFn;
  /// Type of an slot structure pointer.  This is returned by the various
  /// lookup functions.
  private org.llvm.ir.Type /*P*/ SlotTy;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCGNUstep::GetEHType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp", line = 1181,
   FQN="(anonymous namespace)::CGObjCGNUstep::GetEHType", NM="_ZN12_GLOBAL__N_113CGObjCGNUstep9GetEHTypeEN5clang8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp -nm=_ZN12_GLOBAL__N_113CGObjCGNUstep9GetEHTypeEN5clang8QualTypeE")
  //</editor-fold>
  @Override public Constant /*P*/ GetEHType(QualType T)/* override*/ {
    std.vector<Constant /*P*/ > fields = null;
    try {
      if (!CGM.getLangOpts().CPlusPlus) {
        return super.GetEHType(new QualType(T));
      }
      
      // For Objective-C++, we want to provide the ability to catch both C++ and
      // Objective-C objects in the same function.
      
      // There's a particular fixed type info for 'id'.
      if (T.$arrow().isObjCIdType()
         || T.$arrow().isObjCQualifiedIdType()) {
        Constant /*P*/ IDEHType = CGM.getModule().getGlobalVariable(new StringRef(/*KEEP_STR*/"__objc_id_type_info"));
        if (!(IDEHType != null)) {
          IDEHType
             = /*NEW_EXPR [GlobalVariable::new]*/GlobalVariable.$new_GlobalVariable((type$ptr<?> New$Mem)->{
              return new GlobalVariable(CGM.getModule(), PtrToInt8Ty, 
              false, 
              GlobalValue.LinkageTypes.ExternalLinkage, 
              (Constant /*P*/ )null, new Twine(/*KEEP_STR*/"__objc_id_type_info"));
           });
        }
        return ConstantExpr.getBitCast(IDEHType, PtrToInt8Ty);
      }
      
      /*const*/ ObjCObjectPointerType /*P*/ PT = T.$arrow().getAs(ObjCObjectPointerType.class);
      assert ((PT != null)) : "Invalid @catch type.";
      /*const*/ ObjCInterfaceType /*P*/ IT = PT.getInterfaceType();
      assert ((IT != null)) : "Invalid @catch type.";
      std.string className = IT.getDecl().getIdentifier().getName().$string();
      
      std.string typeinfoName = $add_T$C$P_string$C(/*KEEP_STR*/"__objc_eh_typeinfo_", className);
      
      // Return the existing typeinfo if it exists
      Constant /*P*/ typeinfo = TheModule.getGlobalVariable(new StringRef(typeinfoName));
      if ((typeinfo != null)) {
        return ConstantExpr.getBitCast(typeinfo, PtrToInt8Ty);
      }
      
      // Otherwise create it.
      
      // vtable for gnustep::libobjc::__objc_class_type_info
      // It's quite ugly hard-coding this.  Ideally we'd generate it using the host
      // platform's name mangling.
      /*const*/char$ptr/*char P*/ vtableName = $("_ZTVN7gnustep7libobjc22__objc_class_type_infoE");
      GlobalVariable /*P*/ Vtable = TheModule.getGlobalVariable(new StringRef(vtableName));
      if (!(Vtable != null)) {
        Vtable = /*NEW_EXPR [GlobalVariable::new]*/GlobalVariable.$new_GlobalVariable((type$ptr<?> New$Mem)->{
            return new GlobalVariable(TheModule, PtrToInt8Ty, true, 
            GlobalValue.LinkageTypes.ExternalLinkage, 
            (Constant /*P*/ )null, new Twine(vtableName));
         });
      }
      Constant /*P*/ Two = ConstantInt.get(IntTy, $int2ulong(2));
      Constant /*P*/ BVtable = ConstantExpr.getBitCast(ConstantExpr.getGetElementPtr(Vtable.getValueType(), Vtable, Two), 
          PtrToInt8Ty);
      
      Constant /*P*/ typeName = ExportUniqueString(className, new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"__objc_eh_typename_"));
      
      fields/*J*/= new std.vector<Constant /*P*/ >((Constant /*P*/ )null);
      fields.push_back_T$C$R(BVtable);
      fields.push_back_T$C$R(typeName);
      Constant /*P*/ TI = MakeGlobal_StructType$P_ArrayRef$Constant$P_CharUnits_StringRef_LinkageTypes(StructType.get(PtrToInt8Ty, PtrToInt8Ty, null), 
          new ArrayRef<Constant /*P*/ >(fields, true), CGM.getPointerAlign(), 
          new StringRef($add_T$C$P_string$C(/*KEEP_STR*/"__objc_eh_typeinfo_", className)), 
          GlobalValue.LinkageTypes.LinkOnceODRLinkage);
      return ConstantExpr.getBitCast(TI, PtrToInt8Ty);
    } finally {
      if (fields != null) { fields.$destroy(); }
    }
  }

/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCGNUstep::LookupIMP">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp", line = 681,
   FQN="(anonymous namespace)::CGObjCGNUstep::LookupIMP", NM="_ZN12_GLOBAL__N_113CGObjCGNUstep9LookupIMPERN5clang7CodeGen15CodeGenFunctionERPN4llvm5ValueES7_PNS5_6MDNodeERNS2_13CGObjCRuntime15MessageSendInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp -nm=_ZN12_GLOBAL__N_113CGObjCGNUstep9LookupIMPERN5clang7CodeGen15CodeGenFunctionERPN4llvm5ValueES7_PNS5_6MDNodeERNS2_13CGObjCRuntime15MessageSendInfoE")
  //</editor-fold>
  @Override protected Value /*P*/ LookupIMP(final CodeGenFunction /*&*/ CGF, final type$ref<Value /*P*/ /*&*/> Receiver, 
           Value /*P*/ cmd, MDNode /*P*/ node, 
           final CGObjCRuntime.MessageSendInfo /*&*/ MSI)/* override*/ {
    final CGBuilderTy /*&*/ Builder = CGF.Builder;
    Function /*P*/ LookupFn = SlotLookupFn.$Function$P();
    
    // Store the receiver on the stack so that we can reload it later
    Address ReceiverPtr = CGF.CreateTempAlloca(Receiver.$deref().getType(), CGF.getPointerAlign());
    Builder.CreateStore(Receiver.$deref(), new Address(ReceiverPtr));
    
    Value /*P*/ self;
    if (isa_ObjCMethodDecl(CGF.CurCodeDecl)) {
      self = CGF.LoadObjCSelf();
    } else {
      self = ConstantPointerNull.get(IdTy);
    }
    
    // The lookup function is guaranteed not to capture the receiver pointer.
    LookupFn.setDoesNotCapture(1);
    
    Value /*P*/ args[/*3*/] = new Value /*P*/  [/*3*/] {
      EnforceType(Builder, ReceiverPtr.getPointer(), PtrToIdTy), 
      EnforceType(Builder, cmd, SelectorTy), 
      EnforceType(Builder, self, IdTy)};
    CallSite slot = CGF.EmitRuntimeCallOrInvoke(LookupFn, new ArrayRef<Value /*P*/ >(args, true));
    slot.setOnlyReadsMemory();
    slot.$arrow().setMetadata(msgSendMDKind, node);
    
    // Load the imp from the slot
    Value /*P*/ imp = Builder.CreateAlignedLoad(Builder.CreateStructGEP((org.llvm.ir.Type /*P*/ )null, slot.getInstruction(), 4), 
        CGF.getPointerAlign());
    
    // The lookup function may have changed the receiver, so make sure we use
    // the new one.
    Receiver.$set(Builder.CreateLoad(new Address(ReceiverPtr), true));
    return imp;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCGNUstep::LookupIMPSuper">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp", line = 722,
   FQN="(anonymous namespace)::CGObjCGNUstep::LookupIMPSuper", NM="_ZN12_GLOBAL__N_113CGObjCGNUstep14LookupIMPSuperERN5clang7CodeGen15CodeGenFunctionENS2_7AddressEPN4llvm5ValueERNS2_13CGObjCRuntime15MessageSendInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp -nm=_ZN12_GLOBAL__N_113CGObjCGNUstep14LookupIMPSuperERN5clang7CodeGen15CodeGenFunctionENS2_7AddressEPN4llvm5ValueERNS2_13CGObjCRuntime15MessageSendInfoE")
  //</editor-fold>
  @Override protected Value /*P*/ LookupIMPSuper(final CodeGenFunction /*&*/ CGF, Address ObjCSuper, 
                Value /*P*/ cmd, 
                final CGObjCRuntime.MessageSendInfo /*&*/ MSI)/* override*/ {
    final CGBuilderTy /*&*/ Builder = CGF.Builder;
    Value /*P*/ lookupArgs[/*2*/] = new Value /*P*/  [/*2*/] {ObjCSuper.getPointer(), cmd};
    
    CallInst /*P*/ slot = CGF.EmitNounwindRuntimeCall(SlotLookupSuperFn.$Constant$P(), new ArrayRef<Value /*P*/ >(lookupArgs, true));
    slot.setOnlyReadsMemory();
    
    return Builder.CreateAlignedLoad(Builder.CreateStructGEP((org.llvm.ir.Type /*P*/ )null, slot, 4), 
        CGF.getPointerAlign());
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCGNUstep::CGObjCGNUstep">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp", line = 737,
   FQN="(anonymous namespace)::CGObjCGNUstep::CGObjCGNUstep", NM="_ZN12_GLOBAL__N_113CGObjCGNUstepC1ERN5clang7CodeGen13CodeGenModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp -nm=_ZN12_GLOBAL__N_113CGObjCGNUstepC1ERN5clang7CodeGen13CodeGenModuleE")
  //</editor-fold>
  public CGObjCGNUstep(final CodeGenModule /*&*/ Mod) {
    // : CGObjCGNU(Mod, 9, 3), SlotLookupFn(), SlotLookupSuperFn(), SetPropertyAtomic(), SetPropertyAtomicCopy(), SetPropertyNonAtomic(), SetPropertyNonAtomicCopy(), CxxAtomicObjectGetFn(), CxxAtomicObjectSetFn() 
    //START JInit
    super(Mod, 9, 3);
    this.SlotLookupFn = new LazyRuntimeFunction();
    this.SlotLookupSuperFn = new LazyRuntimeFunction();
    this.SetPropertyAtomic = new LazyRuntimeFunction();
    this.SetPropertyAtomicCopy = new LazyRuntimeFunction();
    this.SetPropertyNonAtomic = new LazyRuntimeFunction();
    this.SetPropertyNonAtomicCopy = new LazyRuntimeFunction();
    this.CxxAtomicObjectGetFn = new LazyRuntimeFunction();
    this.CxxAtomicObjectSetFn = new LazyRuntimeFunction();
    //END JInit
    final /*const*/ ObjCRuntime /*&*/ R = CGM.getLangOpts().ObjCRuntime;
    
    StructType /*P*/ SlotStructTy = StructType.get(PtrTy, 
        PtrTy, PtrTy, IntTy, IMPTy, null);
    SlotTy = org.llvm.ir.PointerType.getUnqual(SlotStructTy);
    // Slot_t objc_msg_lookup_sender(id *receiver, SEL selector, id sender);
    SlotLookupFn.init($AddrOf(CGM), $("objc_msg_lookup_sender"), SlotTy, PtrToIdTy, 
        SelectorTy, IdTy, null);
    // Slot_t objc_msg_lookup_super(struct objc_super*, SEL);
    SlotLookupSuperFn.init($AddrOf(CGM), $("objc_slot_lookup_super"), SlotTy, 
        PtrToObjCSuperTy, SelectorTy, null);
    // If we're in ObjC++ mode, then we want to make 
    if (CGM.getLangOpts().CPlusPlus) {
      org.llvm.ir.Type /*P*/ VoidTy = org.llvm.ir.Type.getVoidTy(VMContext);
      // void *__cxa_begin_catch(void *e)
      EnterCatchFn.init($AddrOf(CGM), $("__cxa_begin_catch"), PtrTy, PtrTy, null);
      // void __cxa_end_catch(void)
      ExitCatchFn.init($AddrOf(CGM), $("__cxa_end_catch"), VoidTy, null);
      // void _Unwind_Resume_or_Rethrow(void*)
      ExceptionReThrowFn.init($AddrOf(CGM), $("_Unwind_Resume_or_Rethrow"), VoidTy, 
          PtrTy, null);
    } else if (VersionTuple.$greatereq_VersionTuple$C(R.getVersion(), new VersionTuple(1, 7))) {
      org.llvm.ir.Type /*P*/ VoidTy = org.llvm.ir.Type.getVoidTy(VMContext);
      // id objc_begin_catch(void *e)
      EnterCatchFn.init($AddrOf(CGM), $("objc_begin_catch"), IdTy, PtrTy, null);
      // void objc_end_catch(void)
      ExitCatchFn.init($AddrOf(CGM), $("objc_end_catch"), VoidTy, null);
      // void _Unwind_Resume_or_Rethrow(void*)
      ExceptionReThrowFn.init($AddrOf(CGM), $("objc_exception_rethrow"), VoidTy, 
          PtrTy, null);
    }
    org.llvm.ir.Type /*P*/ VoidTy = org.llvm.ir.Type.getVoidTy(VMContext);
    SetPropertyAtomic.init($AddrOf(CGM), $("objc_setProperty_atomic"), VoidTy, IdTy, 
        SelectorTy, IdTy, PtrDiffTy, null);
    SetPropertyAtomicCopy.init($AddrOf(CGM), $("objc_setProperty_atomic_copy"), VoidTy, 
        IdTy, SelectorTy, IdTy, PtrDiffTy, null);
    SetPropertyNonAtomic.init($AddrOf(CGM), $("objc_setProperty_nonatomic"), VoidTy, 
        IdTy, SelectorTy, IdTy, PtrDiffTy, null);
    SetPropertyNonAtomicCopy.init($AddrOf(CGM), $("objc_setProperty_nonatomic_copy"), 
        VoidTy, IdTy, SelectorTy, IdTy, PtrDiffTy, null);
    // void objc_setCppObjectAtomic(void *dest, const void *src, void
    // *helper);
    CxxAtomicObjectSetFn.init($AddrOf(CGM), $("objc_setCppObjectAtomic"), VoidTy, PtrTy, 
        PtrTy, PtrTy, null);
    // void objc_getCppObjectAtomic(void *dest, const void *src, void
    // *helper);
    CxxAtomicObjectGetFn.init($AddrOf(CGM), $("objc_getCppObjectAtomic"), VoidTy, PtrTy, 
        PtrTy, PtrTy, null);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCGNUstep::GetCppAtomicObjectGetFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp", line = 788,
   FQN="(anonymous namespace)::CGObjCGNUstep::GetCppAtomicObjectGetFunction", NM="_ZN12_GLOBAL__N_113CGObjCGNUstep29GetCppAtomicObjectGetFunctionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp -nm=_ZN12_GLOBAL__N_113CGObjCGNUstep29GetCppAtomicObjectGetFunctionEv")
  //</editor-fold>
  @Override public Constant /*P*/ GetCppAtomicObjectGetFunction()/* override*/ {
    // The optimised functions were added in version 1.7 of the GNUstep
    // runtime.
    assert (VersionTuple.$greatereq_VersionTuple$C(CGM.getLangOpts().ObjCRuntime.getVersion(), new VersionTuple(1, 7)));
    return CxxAtomicObjectGetFn.$Constant$P();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCGNUstep::GetCppAtomicObjectSetFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp", line = 796,
   FQN="(anonymous namespace)::CGObjCGNUstep::GetCppAtomicObjectSetFunction", NM="_ZN12_GLOBAL__N_113CGObjCGNUstep29GetCppAtomicObjectSetFunctionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp -nm=_ZN12_GLOBAL__N_113CGObjCGNUstep29GetCppAtomicObjectSetFunctionEv")
  //</editor-fold>
  @Override public Constant /*P*/ GetCppAtomicObjectSetFunction()/* override*/ {
    // The optimised functions were added in version 1.7 of the GNUstep
    // runtime.
    assert (VersionTuple.$greatereq_VersionTuple$C(CGM.getLangOpts().ObjCRuntime.getVersion(), new VersionTuple(1, 7)));
    return CxxAtomicObjectSetFn.$Constant$P();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCGNUstep::GetOptimizedPropertySetFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp", line = 804,
   FQN="(anonymous namespace)::CGObjCGNUstep::GetOptimizedPropertySetFunction", NM="_ZN12_GLOBAL__N_113CGObjCGNUstep31GetOptimizedPropertySetFunctionEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp -nm=_ZN12_GLOBAL__N_113CGObjCGNUstep31GetOptimizedPropertySetFunctionEbb")
  //</editor-fold>
  @Override public Constant /*P*/ GetOptimizedPropertySetFunction(boolean atomic, 
                                 boolean copy)/* override*/ {
    // The optimised property functions omit the GC check, and so are not
    // safe to use in GC mode.  The standard functions are fast in GC mode,
    // so there is less advantage in using them.
    assert (CGM.getLangOpts().getGC() == LangOptions.GCMode.NonGC);
    // The optimised functions were added in version 1.7 of the GNUstep
    // runtime.
    assert (VersionTuple.$greatereq_VersionTuple$C(CGM.getLangOpts().ObjCRuntime.getVersion(), new VersionTuple(1, 7)));
    if (atomic) {
      if (copy) {
        return SetPropertyAtomicCopy.$Constant$P();
      }
      return SetPropertyAtomic.$Constant$P();
    }
    
    return (copy ? SetPropertyNonAtomicCopy : SetPropertyNonAtomic).$Constant$P();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCGNUstep::~CGObjCGNUstep">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp", line = 650,
   FQN="(anonymous namespace)::CGObjCGNUstep::~CGObjCGNUstep", NM="_ZN12_GLOBAL__N_113CGObjCGNUstepD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp -nm=_ZN12_GLOBAL__N_113CGObjCGNUstepD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + "SlotLookupFn=" + SlotLookupFn // NOI18N
              + ", SlotLookupSuperFn=" + SlotLookupSuperFn // NOI18N
              + ", SetPropertyAtomic=" + SetPropertyAtomic // NOI18N
              + ", SetPropertyAtomicCopy=" + SetPropertyAtomicCopy // NOI18N
              + ", SetPropertyNonAtomic=" + SetPropertyNonAtomic // NOI18N
              + ", SetPropertyNonAtomicCopy=" + SetPropertyNonAtomicCopy // NOI18N
              + ", CxxAtomicObjectGetFn=" + CxxAtomicObjectGetFn // NOI18N
              + ", CxxAtomicObjectSetFn=" + CxxAtomicObjectSetFn // NOI18N
              + ", SlotTy=" + SlotTy // NOI18N
              + super.toString(); // NOI18N
  }
}
