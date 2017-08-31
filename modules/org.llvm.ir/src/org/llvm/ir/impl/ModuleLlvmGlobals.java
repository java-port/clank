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
package org.llvm.ir.impl;

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.Casts.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.llvmc.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.ir.*;
import static org.llvm.ir.java.IrRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type ModuleLlvmGlobals">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.llvm.ir.impl.ModuleLlvmGlobals",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Module.cpp -nm=_ZN4llvm26collectUsedGlobalVariablesERKNS_6ModuleERNS_15SmallPtrSetImplIPNS_11GlobalValueEEEb;_ZN4llvm4wrapEPKNS_6ModuleE;_ZN4llvm6unwrapEP16LLVMOpaqueModule;_ZN4llvm6unwrapEP24LLVMOpaqueModuleProvider;_ZN4llvmlsERNS_11raw_ostreamERKNS_6ModuleE; -static-type=ModuleLlvmGlobals -package=org.llvm.ir.impl")
//</editor-fold>
public final class ModuleLlvmGlobals {


/// \brief Given "llvm.used" or "llvm.compiler.used" as a global name, collect
/// the initializer elements of that global in Set and return the global itself.
//<editor-fold defaultstate="collapsed" desc="llvm::collectUsedGlobalVariables">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/IR/Module.cpp", line = 522,
 FQN="llvm::collectUsedGlobalVariables", NM="_ZN4llvm26collectUsedGlobalVariablesERKNS_6ModuleERNS_15SmallPtrSetImplIPNS_11GlobalValueEEEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Module.cpp -nm=_ZN4llvm26collectUsedGlobalVariablesERKNS_6ModuleERNS_15SmallPtrSetImplIPNS_11GlobalValueEEEb")
//</editor-fold>
public static GlobalVariable /*P*/ collectUsedGlobalVariables(final /*const*/ Module /*&*/ M, final SmallPtrSetImpl<GlobalValue /*P*/ > /*&*/ Set, boolean CompilerUsed) {
  /*const*/char$ptr/*char P*/ Name = $tryClone(CompilerUsed ? $("llvm.compiler.used") : $("llvm.used"));
  GlobalVariable /*P*/ GV = M.getGlobalVariable$Const(new StringRef(Name));
  if (!(GV != null) || !GV.hasInitializer()) {
    return GV;
  }
  
  /*const*/ ConstantArray /*P*/ Init = cast_ConstantArray(GV.getInitializer());
  for (Use use/*Op*/ : Init.operands$Const()) {
    Value /*P*/ Op = use.$Value$P();
    GlobalValue /*P*/ G = cast_GlobalValue(Op.stripPointerCastsNoFollowAliases());
    Set.insert(G);
  }
  return GV;
}


/// An raw_ostream inserter for modules.
//<editor-fold defaultstate="collapsed" desc="llvm::operator<<">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 833,
 FQN="llvm::operator<<", NM="_ZN4llvmlsERNS_11raw_ostreamERKNS_6ModuleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Module.cpp -nm=_ZN4llvmlsERNS_11raw_ostreamERKNS_6ModuleE")
//</editor-fold>
public static /*inline*/ raw_ostream /*&*/ $out_raw_ostream_Module$C(final raw_ostream /*&*/ O, final /*const*/ Module /*&*/ M) {
  M.print(O, (AssemblyAnnotationWriter /*P*/ )null);
  return O;
}


// Create wrappers for C Binding types (see CBindingWrapping.h).
//<editor-fold defaultstate="collapsed" desc="llvm::unwrap">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 839,
 FQN="llvm::unwrap", NM="_ZN4llvm6unwrapEP16LLVMOpaqueModule",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Module.cpp -nm=_ZN4llvm6unwrapEP16LLVMOpaqueModule")
//</editor-fold>
public static /*inline*/ Module /*P*/ unwrap( LLVMOpaqueModule /*P*/ P) {
  return reinterpret_cast(Module /*P*/ .class, P);
}

//<editor-fold defaultstate="collapsed" desc="llvm::wrap">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 839,
 FQN="llvm::wrap", NM="_ZN4llvm4wrapEPKNS_6ModuleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Module.cpp -nm=_ZN4llvm4wrapEPKNS_6ModuleE")
//</editor-fold>
public static /*inline*/  LLVMOpaqueModule /*P*/ wrap(/*const*/ Module /*P*/ P) {
  return reinterpret_cast( LLVMOpaqueModule /*P*/ .class, ((/*const_cast*/Module /*P*/ )(P)));
}


/* LLVMModuleProviderRef exists for historical reasons, but now just holds a
* Module.
*/
//<editor-fold defaultstate="collapsed" desc="llvm::unwrap">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 844,
 FQN="llvm::unwrap", NM="_ZN4llvm6unwrapEP24LLVMOpaqueModuleProvider",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Module.cpp -nm=_ZN4llvm6unwrapEP24LLVMOpaqueModuleProvider")
//</editor-fold>
public static /*inline*/ Module /*P*/ unwrap( LLVMOpaqueModuleProvider /*P*/ MP) {
  return reinterpret_cast(Module /*P*/ .class, MP);
}

} // END OF class ModuleLlvmGlobals
