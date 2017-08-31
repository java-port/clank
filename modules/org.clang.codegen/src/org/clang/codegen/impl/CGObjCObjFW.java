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
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import org.clang.codegen.CodeGen.impl.*;
import static org.clank.support.Native.$AddrOf;


/// Support for the ObjFW runtime.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCObjFW">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp", line = 825,
 FQN="(anonymous namespace)::CGObjCObjFW", NM="_ZN12_GLOBAL__N_111CGObjCObjFWE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp -nm=_ZN12_GLOBAL__N_111CGObjCObjFWE")
//</editor-fold>
public class CGObjCObjFW extends /*public*/ CGObjCGNU implements Destructors.ClassWithDestructor {
/*protected:*/
  /// The GCC ABI message lookup function.  Returns an IMP pointing to the
  /// method implementation for this message.
  protected LazyRuntimeFunction MsgLookupFn;
  /// stret lookup function.  While this does not seem to make sense at the
  /// first look, this is required to call the correct forwarding function.
  protected LazyRuntimeFunction MsgLookupFnSRet;
  /// The GCC ABI superclass message lookup function.  Takes a pointer to a
  /// structure describing the receiver and the class, and a selector as
  /// arguments.  Returns the IMP for the corresponding method.
  protected LazyRuntimeFunction MsgLookupSuperFn;
  protected LazyRuntimeFunction MsgLookupSuperFnSRet;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCObjFW::LookupIMP">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp", line = 838,
   FQN="(anonymous namespace)::CGObjCObjFW::LookupIMP", NM="_ZN12_GLOBAL__N_111CGObjCObjFW9LookupIMPERN5clang7CodeGen15CodeGenFunctionERPN4llvm5ValueES7_PNS5_6MDNodeERNS2_13CGObjCRuntime15MessageSendInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp -nm=_ZN12_GLOBAL__N_111CGObjCObjFW9LookupIMPERN5clang7CodeGen15CodeGenFunctionERPN4llvm5ValueES7_PNS5_6MDNodeERNS2_13CGObjCRuntime15MessageSendInfoE")
  //</editor-fold>
  @Override protected Value /*P*/ LookupIMP(final CodeGenFunction /*&*/ CGF, final type$ref<Value /*P*/ /*&*/> Receiver, 
           Value /*P*/ cmd, MDNode /*P*/ node, 
           final CGObjCRuntime.MessageSendInfo /*&*/ MSI)/* override*/ {
    final CGBuilderTy /*&*/ Builder = CGF.Builder;
    Value /*P*/ args[/*2*/] = new Value /*P*/  [/*2*/] {
      EnforceType(Builder, Receiver.$deref(), IdTy), 
      EnforceType(Builder, cmd, SelectorTy)};
    
    CallSite imp/*J*/= new CallSite();
    if (CGM.ReturnTypeUsesSRet(MSI.CallInfo)) {
      imp.$assignMove(CGF.EmitRuntimeCallOrInvoke(MsgLookupFnSRet.$Constant$P(), new ArrayRef<Value /*P*/ >(args, true)));
    } else {
      imp.$assignMove(CGF.EmitRuntimeCallOrInvoke(MsgLookupFn.$Constant$P(), new ArrayRef<Value /*P*/ >(args, true)));
    }
    
    imp.$arrow().setMetadata(msgSendMDKind, node);
    return imp.getInstruction();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCObjFW::LookupIMPSuper">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp", line = 856,
   FQN="(anonymous namespace)::CGObjCObjFW::LookupIMPSuper", NM="_ZN12_GLOBAL__N_111CGObjCObjFW14LookupIMPSuperERN5clang7CodeGen15CodeGenFunctionENS2_7AddressEPN4llvm5ValueERNS2_13CGObjCRuntime15MessageSendInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp -nm=_ZN12_GLOBAL__N_111CGObjCObjFW14LookupIMPSuperERN5clang7CodeGen15CodeGenFunctionENS2_7AddressEPN4llvm5ValueERNS2_13CGObjCRuntime15MessageSendInfoE")
  //</editor-fold>
  @Override protected Value /*P*/ LookupIMPSuper(final CodeGenFunction /*&*/ CGF, Address ObjCSuper, 
                Value /*P*/ cmd, final CGObjCRuntime.MessageSendInfo /*&*/ MSI)/* override*/ {
    final CGBuilderTy /*&*/ Builder = CGF.Builder;
    Value /*P*/ lookupArgs[/*2*/] = new Value /*P*/  [/*2*/] {
      EnforceType(Builder, ObjCSuper.getPointer(), PtrToObjCSuperTy), cmd
    };
    if (CGM.ReturnTypeUsesSRet(MSI.CallInfo)) {
      return CGF.EmitNounwindRuntimeCall(MsgLookupSuperFnSRet.$Constant$P(), new ArrayRef<Value /*P*/ >(lookupArgs, true));
    } else {
      return CGF.EmitNounwindRuntimeCall(MsgLookupSuperFn.$Constant$P(), new ArrayRef<Value /*P*/ >(lookupArgs, true));
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCObjFW::GetClassNamed">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp", line = 869,
   FQN="(anonymous namespace)::CGObjCObjFW::GetClassNamed", NM="_ZN12_GLOBAL__N_111CGObjCObjFW13GetClassNamedERN5clang7CodeGen15CodeGenFunctionERKSsb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp -nm=_ZN12_GLOBAL__N_111CGObjCObjFW13GetClassNamedERN5clang7CodeGen15CodeGenFunctionERKSsb")
  //</editor-fold>
  @Override protected Value /*P*/ GetClassNamed(final CodeGenFunction /*&*/ CGF, final /*const*/std.string/*&*/ Name, 
               boolean isWeak)/* override*/ {
    if (isWeak) {
      return super.GetClassNamed(CGF, Name, isWeak);
    }
    
    EmitClassRef(Name);
    std.string SymbolName = $add_T$C$P_string$C(/*KEEP_STR*/"_OBJC_CLASS_", Name);
    GlobalVariable /*P*/ ClassSymbol = TheModule.getGlobalVariable(new StringRef(SymbolName));
    if (!(ClassSymbol != null)) {
      ClassSymbol = /*NEW_EXPR [GlobalVariable::new]*/GlobalVariable.$new_GlobalVariable((type$ptr<?> New$Mem)->{
          return new GlobalVariable(TheModule, LongTy, false, 
          GlobalValue.LinkageTypes.ExternalLinkage, 
          (Constant /*P*/ )null, new Twine(SymbolName));
       });
    }
    return ClassSymbol;
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCObjFW::CGObjCObjFW">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp", line = 885,
   FQN="(anonymous namespace)::CGObjCObjFW::CGObjCObjFW", NM="_ZN12_GLOBAL__N_111CGObjCObjFWC1ERN5clang7CodeGen13CodeGenModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp -nm=_ZN12_GLOBAL__N_111CGObjCObjFWC1ERN5clang7CodeGen13CodeGenModuleE")
  //</editor-fold>
  public CGObjCObjFW(final CodeGenModule /*&*/ Mod) {
    // : CGObjCGNU(Mod, 9, 3), MsgLookupFn(), MsgLookupFnSRet(), MsgLookupSuperFn(), MsgLookupSuperFnSRet() 
    //START JInit
    super(Mod, 9, 3);
    this.MsgLookupFn = new LazyRuntimeFunction();
    this.MsgLookupFnSRet = new LazyRuntimeFunction();
    this.MsgLookupSuperFn = new LazyRuntimeFunction();
    this.MsgLookupSuperFnSRet = new LazyRuntimeFunction();
    //END JInit
    // IMP objc_msg_lookup(id, SEL);
    MsgLookupFn.init($AddrOf(CGM), $("objc_msg_lookup"), IMPTy, IdTy, SelectorTy, null);
    MsgLookupFnSRet.init($AddrOf(CGM), $("objc_msg_lookup_stret"), IMPTy, IdTy, 
        SelectorTy, null);
    // IMP objc_msg_lookup_super(struct objc_super*, SEL);
    MsgLookupSuperFn.init($AddrOf(CGM), $("objc_msg_lookup_super"), IMPTy, 
        PtrToObjCSuperTy, SelectorTy, null);
    MsgLookupSuperFnSRet.init($AddrOf(CGM), $("objc_msg_lookup_super_stret"), IMPTy, 
        PtrToObjCSuperTy, SelectorTy, null);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCObjFW::~CGObjCObjFW">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp", line = 825,
   FQN="(anonymous namespace)::CGObjCObjFW::~CGObjCObjFW", NM="_ZN12_GLOBAL__N_111CGObjCObjFWD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp -nm=_ZN12_GLOBAL__N_111CGObjCObjFWD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + "MsgLookupFn=" + MsgLookupFn // NOI18N
              + ", MsgLookupFnSRet=" + MsgLookupFnSRet // NOI18N
              + ", MsgLookupSuperFn=" + MsgLookupSuperFn // NOI18N
              + ", MsgLookupSuperFnSRet=" + MsgLookupSuperFnSRet // NOI18N
              + super.toString(); // NOI18N
  }
}
