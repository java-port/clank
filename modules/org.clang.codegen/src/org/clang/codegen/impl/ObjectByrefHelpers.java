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
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.llvm.ir.*;
import org.clang.codegen.impl.*;
import org.clang.codegen.CodeGen.impl.*;


/// Emits the copy/dispose helper functions for a __block object of id type.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjectByrefHelpers">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp", line = 1640,
 FQN="(anonymous namespace)::ObjectByrefHelpers", NM="_ZN12_GLOBAL__N_118ObjectByrefHelpersE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZN12_GLOBAL__N_118ObjectByrefHelpersE")
//</editor-fold>
public final class ObjectByrefHelpers extends /*public*/ BlockByrefHelpers implements Destructors.ClassWithDestructor {
  private BlockFieldFlags Flags;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjectByrefHelpers::ObjectByrefHelpers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp", line = 1644,
   FQN="(anonymous namespace)::ObjectByrefHelpers::ObjectByrefHelpers", NM="_ZN12_GLOBAL__N_118ObjectByrefHelpersC1EN5clang9CharUnitsENS1_7CodeGen15BlockFieldFlagsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZN12_GLOBAL__N_118ObjectByrefHelpersC1EN5clang9CharUnitsENS1_7CodeGen15BlockFieldFlagsE")
  //</editor-fold>
  public ObjectByrefHelpers(CharUnits alignment, BlockFieldFlags flags) {
    // : BlockByrefHelpers(alignment), Flags(flags) 
    //START JInit
    super(new CharUnits(alignment));
    this.Flags = new BlockFieldFlags(flags);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjectByrefHelpers::emitCopy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp", line = 1647,
   FQN="(anonymous namespace)::ObjectByrefHelpers::emitCopy", NM="_ZN12_GLOBAL__N_118ObjectByrefHelpers8emitCopyERN5clang7CodeGen15CodeGenFunctionENS2_7AddressES5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZN12_GLOBAL__N_118ObjectByrefHelpers8emitCopyERN5clang7CodeGen15CodeGenFunctionENS2_7AddressES5_")
  //</editor-fold>
  @Override public void emitCopy(final CodeGenFunction /*&*/ CGF, Address destField, 
          Address srcField)/* override*/ {
    destField.$assignMove(CGF.Builder.CreateBitCast(new Address(destField), CGF.Unnamed_field9.VoidPtrTy));
    
    srcField.$assignMove(CGF.Builder.CreateBitCast(new Address(srcField), CGF.Unnamed_field10.VoidPtrPtrTy));
    Value /*P*/ srcValue = CGF.Builder.CreateLoad(new Address(srcField));
    
    /*uint*/int flags = (BlockFieldFlags.$bitor_BlockFieldFlags(/*NO_COPY*/Flags, new BlockFieldFlags(BlockFieldFlag_t.BLOCK_BYREF_CALLER))).getBitMask();
    
    Value /*P*/ flagsVal = ConstantInt.get(CGF.Int32Ty, $uint2ulong(flags));
    Value /*P*/ fn = CGF.CGM.getBlockObjectAssign();
    
    Value /*P*/ args[/*3*/] = new Value /*P*/  [/*3*/] {destField.getPointer(), srcValue, flagsVal};
    CGF.EmitNounwindRuntimeCall(fn, new ArrayRef<Value /*P*/ >(args, true));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjectByrefHelpers::emitDispose">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp", line = 1663,
   FQN="(anonymous namespace)::ObjectByrefHelpers::emitDispose", NM="_ZN12_GLOBAL__N_118ObjectByrefHelpers11emitDisposeERN5clang7CodeGen15CodeGenFunctionENS2_7AddressE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZN12_GLOBAL__N_118ObjectByrefHelpers11emitDisposeERN5clang7CodeGen15CodeGenFunctionENS2_7AddressE")
  //</editor-fold>
  @Override public void emitDispose(final CodeGenFunction /*&*/ CGF, Address field)/* override*/ {
    field.$assignMove(CGF.Builder.CreateBitCast(new Address(field), CGF.Unnamed_field9.Int8PtrTy.getPointerTo(0)));
    Value /*P*/ value = CGF.Builder.CreateLoad(new Address(field));
    
    CGF.BuildBlockRelease(value, BlockFieldFlags.$bitor_BlockFieldFlags(/*NO_COPY*/Flags, new BlockFieldFlags(BlockFieldFlag_t.BLOCK_BYREF_CALLER)));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjectByrefHelpers::profileImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp", line = 1670,
   FQN="(anonymous namespace)::ObjectByrefHelpers::profileImpl", NM="_ZNK12_GLOBAL__N_118ObjectByrefHelpers11profileImplERN4llvm16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZNK12_GLOBAL__N_118ObjectByrefHelpers11profileImplERN4llvm16FoldingSetNodeIDE")
  //</editor-fold>
  @Override public void profileImpl(final FoldingSetNodeID /*&*/ id) /*const*//* override*/ {
    id.AddInteger_uint(Flags.getBitMask());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjectByrefHelpers::ObjectByrefHelpers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp", line = 1640,
   FQN="(anonymous namespace)::ObjectByrefHelpers::ObjectByrefHelpers", NM="_ZN12_GLOBAL__N_118ObjectByrefHelpersC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZN12_GLOBAL__N_118ObjectByrefHelpersC1EOS0_")
  //</editor-fold>
  public /*inline*/ ObjectByrefHelpers(JD$Move _dparam, final ObjectByrefHelpers /*&&*/$Prm0) {
    // : BlockByrefHelpers(static_cast<ObjectByrefHelpers &&>()), Flags(static_cast<ObjectByrefHelpers &&>().Flags) 
    //START JInit
    super($Prm0);
    this.Flags = new BlockFieldFlags(JD$Move.INSTANCE, $Prm0.Flags);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjectByrefHelpers::~ObjectByrefHelpers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp", line = 1640,
   FQN="(anonymous namespace)::ObjectByrefHelpers::~ObjectByrefHelpers", NM="_ZN12_GLOBAL__N_118ObjectByrefHelpersD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZN12_GLOBAL__N_118ObjectByrefHelpersD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public static ObjectByrefHelpers $factory(ObjectByrefHelpers p) { return new ObjectByrefHelpers(JD$Move.INSTANCE, p); }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Flags=" + Flags // NOI18N
              + super.toString(); // NOI18N
  }
}
