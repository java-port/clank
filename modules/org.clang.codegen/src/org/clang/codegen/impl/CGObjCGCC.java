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
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import org.clang.codegen.impl.*;
import org.clang.codegen.CodeGen.impl.*;


/// Class representing the legacy GCC Objective-C ABI.  This is the default when
/// -fobjc-nonfragile-abi is not specified.
///
/// The GCC ABI target actually generates code that is approximately compatible
/// with the new GNUstep runtime ABI, but refrains from using any features that
/// would not work with the GCC runtime.  For example, clang always generates
/// the extended form of the class structure, and the extra fields are simply
/// ignored by GCC libobjc.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCGCC">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp", line = 608,
 FQN="(anonymous namespace)::CGObjCGCC", NM="_ZN12_GLOBAL__N_19CGObjCGCCE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp -nm=_ZN12_GLOBAL__N_19CGObjCGCCE")
//</editor-fold>
public class CGObjCGCC extends /*public*/ CGObjCGNU implements Destructors.ClassWithDestructor {
  /// The GCC ABI message lookup function.  Returns an IMP pointing to the
  /// method implementation for this message.
  private LazyRuntimeFunction MsgLookupFn;
  /// The GCC ABI superclass message lookup function.  Takes a pointer to a
  /// structure describing the receiver and the class, and a selector as
  /// arguments.  Returns the IMP for the corresponding method.
  private LazyRuntimeFunction MsgLookupSuperFn;
/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCGCC::LookupIMP">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp", line = 618,
   FQN="(anonymous namespace)::CGObjCGCC::LookupIMP", NM="_ZN12_GLOBAL__N_19CGObjCGCC9LookupIMPERN5clang7CodeGen15CodeGenFunctionERPN4llvm5ValueES7_PNS5_6MDNodeERNS2_13CGObjCRuntime15MessageSendInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp -nm=_ZN12_GLOBAL__N_19CGObjCGCC9LookupIMPERN5clang7CodeGen15CodeGenFunctionERPN4llvm5ValueES7_PNS5_6MDNodeERNS2_13CGObjCRuntime15MessageSendInfoE")
  //</editor-fold>
  @Override protected Value /*P*/ LookupIMP(final CodeGenFunction /*&*/ CGF, final type$ref<Value /*P*/ /*&*/> Receiver, 
           Value /*P*/ cmd, MDNode /*P*/ node, 
           final CGObjCRuntime.MessageSendInfo /*&*/ MSI)/* override*/ {
    final CGBuilderTy /*&*/ Builder = CGF.Builder;
    Value /*P*/ args[/*2*/] = new Value /*P*/  [/*2*/] {
      EnforceType(Builder, Receiver.$deref(), IdTy), 
      EnforceType(Builder, cmd, SelectorTy)};
    CallSite imp = CGF.EmitRuntimeCallOrInvoke(MsgLookupFn.$Constant$P(), new ArrayRef<Value /*P*/ >(args, true));
    imp.$arrow().setMetadata(msgSendMDKind, node);
    return imp.getInstruction();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCGCC::LookupIMPSuper">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp", line = 630,
   FQN="(anonymous namespace)::CGObjCGCC::LookupIMPSuper", NM="_ZN12_GLOBAL__N_19CGObjCGCC14LookupIMPSuperERN5clang7CodeGen15CodeGenFunctionENS2_7AddressEPN4llvm5ValueERNS2_13CGObjCRuntime15MessageSendInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp -nm=_ZN12_GLOBAL__N_19CGObjCGCC14LookupIMPSuperERN5clang7CodeGen15CodeGenFunctionENS2_7AddressEPN4llvm5ValueERNS2_13CGObjCRuntime15MessageSendInfoE")
  //</editor-fold>
  @Override protected Value /*P*/ LookupIMPSuper(final CodeGenFunction /*&*/ CGF, Address ObjCSuper, 
                Value /*P*/ cmd, final CGObjCRuntime.MessageSendInfo /*&*/ MSI)/* override*/ {
    final CGBuilderTy /*&*/ Builder = CGF.Builder;
    Value /*P*/ lookupArgs[/*2*/] = new Value /*P*/  [/*2*/] {
      EnforceType(Builder, new Address(ObjCSuper), 
          PtrToObjCSuperTy).getPointer(), 
      cmd};
    return CGF.EmitNounwindRuntimeCall(MsgLookupSuperFn.$Constant$P(), new ArrayRef<Value /*P*/ >(lookupArgs, true));
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCGCC::CGObjCGCC">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp", line = 639,
   FQN="(anonymous namespace)::CGObjCGCC::CGObjCGCC", NM="_ZN12_GLOBAL__N_19CGObjCGCCC1ERN5clang7CodeGen13CodeGenModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp -nm=_ZN12_GLOBAL__N_19CGObjCGCCC1ERN5clang7CodeGen13CodeGenModuleE")
  //</editor-fold>
  public CGObjCGCC(final CodeGenModule /*&*/ Mod) {
    // : CGObjCGNU(Mod, 8, 2), MsgLookupFn(), MsgLookupSuperFn() 
    //START JInit
    super(Mod, 8, 2);
    this.MsgLookupFn = new LazyRuntimeFunction();
    this.MsgLookupSuperFn = new LazyRuntimeFunction();
    //END JInit
    // IMP objc_msg_lookup(id, SEL);
    MsgLookupFn.init(/*AddrOf*/CGM, $("objc_msg_lookup"), IMPTy, IdTy, SelectorTy, 
        null);
    // IMP objc_msg_lookup_super(struct objc_super*, SEL);
    MsgLookupSuperFn.init(/*AddrOf*/CGM, $("objc_msg_lookup_super"), IMPTy, 
        PtrToObjCSuperTy, SelectorTy, null);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CGObjCGCC::~CGObjCGCC">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp", line = 608,
   FQN="(anonymous namespace)::CGObjCGCC::~CGObjCGCC", NM="_ZN12_GLOBAL__N_19CGObjCGCCD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGObjCGNU.cpp -nm=_ZN12_GLOBAL__N_19CGObjCGCCD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + "MsgLookupFn=" + MsgLookupFn // NOI18N
              + ", MsgLookupSuperFn=" + MsgLookupSuperFn // NOI18N
              + super.toString(); // NOI18N
  }
}
