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
import org.clang.ast.*;
import org.llvm.ir.*;
import org.clang.codegen.impl.*;
import org.clang.codegen.CodeGen.impl.*;
import static org.llvm.ir.java.IrRTTI.*;


/// Emits the copy/dispose helpers for an ARC __block __strong variable
/// that's not of block-pointer type.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARCStrongByrefHelpers">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp", line = 1697,
 FQN="(anonymous namespace)::ARCStrongByrefHelpers", NM="_ZN12_GLOBAL__N_121ARCStrongByrefHelpersE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZN12_GLOBAL__N_121ARCStrongByrefHelpersE")
//</editor-fold>
public final class ARCStrongByrefHelpers extends /*public*/ BlockByrefHelpers implements Destructors.ClassWithDestructor {  
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARCStrongByrefHelpers::ARCStrongByrefHelpers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp", line = 1699,
   FQN="(anonymous namespace)::ARCStrongByrefHelpers::ARCStrongByrefHelpers", NM="_ZN12_GLOBAL__N_121ARCStrongByrefHelpersC1EN5clang9CharUnitsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZN12_GLOBAL__N_121ARCStrongByrefHelpersC1EN5clang9CharUnitsE")
  //</editor-fold>
  public ARCStrongByrefHelpers(CharUnits alignment) {
    // : BlockByrefHelpers(alignment) 
    //START JInit
    super(new CharUnits(alignment));
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARCStrongByrefHelpers::emitCopy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp", line = 1701,
   FQN="(anonymous namespace)::ARCStrongByrefHelpers::emitCopy", NM="_ZN12_GLOBAL__N_121ARCStrongByrefHelpers8emitCopyERN5clang7CodeGen15CodeGenFunctionENS2_7AddressES5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZN12_GLOBAL__N_121ARCStrongByrefHelpers8emitCopyERN5clang7CodeGen15CodeGenFunctionENS2_7AddressES5_")
  //</editor-fold>
  @Override public void emitCopy(final CodeGenFunction /*&*/ CGF, Address destField, 
          Address srcField)/* override*/ {
    // Do a "move" by copying the value and then zeroing out the old
    // variable.
    Value /*P*/ value = CGF.Builder.CreateLoad(new Address(srcField));
    
    Value /*P*/ __null = ConstantPointerNull.get(cast_PointerType(value.getType()));
    if ($2bits_uint2uint(CGF.CGM.getCodeGenOpts().OptimizationLevel) == 0) {
      CGF.Builder.CreateStore(__null, new Address(destField));
      CGF.EmitARCStoreStrongCall(new Address(destField), value, /*ignored*/ true);
      CGF.EmitARCStoreStrongCall(new Address(srcField), __null, /*ignored*/ true);
      return;
    }
    CGF.Builder.CreateStore(value, new Address(destField));
    CGF.Builder.CreateStore(__null, new Address(srcField));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARCStrongByrefHelpers::emitDispose">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp", line = 1721,
   FQN="(anonymous namespace)::ARCStrongByrefHelpers::emitDispose", NM="_ZN12_GLOBAL__N_121ARCStrongByrefHelpers11emitDisposeERN5clang7CodeGen15CodeGenFunctionENS2_7AddressE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZN12_GLOBAL__N_121ARCStrongByrefHelpers11emitDisposeERN5clang7CodeGen15CodeGenFunctionENS2_7AddressE")
  //</editor-fold>
  @Override public void emitDispose(final CodeGenFunction /*&*/ CGF, Address field)/* override*/ {
    CGF.EmitARCDestroyStrong(new Address(field), ARCPreciseLifetime_t.ARCImpreciseLifetime);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARCStrongByrefHelpers::profileImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp", line = 1725,
   FQN="(anonymous namespace)::ARCStrongByrefHelpers::profileImpl", NM="_ZNK12_GLOBAL__N_121ARCStrongByrefHelpers11profileImplERN4llvm16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZNK12_GLOBAL__N_121ARCStrongByrefHelpers11profileImplERN4llvm16FoldingSetNodeIDE")
  //</editor-fold>
  @Override public void profileImpl(final FoldingSetNodeID /*&*/ id) /*const*//* override*/ {
    // 1 is distinguishable from all pointers and byref flags
    id.AddInteger_int(1);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARCStrongByrefHelpers::ARCStrongByrefHelpers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp", line = 1697,
   FQN="(anonymous namespace)::ARCStrongByrefHelpers::ARCStrongByrefHelpers", NM="_ZN12_GLOBAL__N_121ARCStrongByrefHelpersC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZN12_GLOBAL__N_121ARCStrongByrefHelpersC1EOS0_")
  //</editor-fold>
  public /*inline*/ ARCStrongByrefHelpers(JD$Move _dparam, final ARCStrongByrefHelpers /*&&*/$Prm0) {
    // : BlockByrefHelpers(static_cast<ARCStrongByrefHelpers &&>()) 
    //START JInit
    super($Prm0);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARCStrongByrefHelpers::~ARCStrongByrefHelpers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp", line = 1697,
   FQN="(anonymous namespace)::ARCStrongByrefHelpers::~ARCStrongByrefHelpers", NM="_ZN12_GLOBAL__N_121ARCStrongByrefHelpersD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGBlocks.cpp -nm=_ZN12_GLOBAL__N_121ARCStrongByrefHelpersD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public static ARCStrongByrefHelpers $factory(ARCStrongByrefHelpers p) { return new ARCStrongByrefHelpers(JD$Move.INSTANCE, p); }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
