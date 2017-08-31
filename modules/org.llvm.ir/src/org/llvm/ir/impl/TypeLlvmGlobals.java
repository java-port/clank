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
import org.llvm.llvmc.*;
import static org.llvm.support.llvm.*;
import org.llvm.support.*;
import org.llvm.ir.*;
import org.llvm.pass.*;


//<editor-fold defaultstate="collapsed" desc="static type TypeLlvmGlobals">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.llvm.ir.impl.TypeLlvmGlobals",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=Tpl__ZN4llvm6unwrapEP14LLVMOpaqueType;_ZN4llvm4wrapEPKNS_4TypeE;_ZN4llvm4wrapEPPNS_4TypeE;_ZN4llvm6unwrapEP14LLVMOpaqueType;_ZN4llvm6unwrapEPP14LLVMOpaqueType;_ZN4llvmlsERNS_11raw_ostreamERNS_4TypeE; -static-type=TypeLlvmGlobals -package=org.llvm.ir.impl")
//</editor-fold>
public final class TypeLlvmGlobals {


// Printing of types.
//<editor-fold defaultstate="collapsed" desc="llvm::operator<<">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Type.h", line = 415,
 FQN="llvm::operator<<", NM="_ZN4llvmlsERNS_11raw_ostreamERNS_4TypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZN4llvmlsERNS_11raw_ostreamERNS_4TypeE")
//</editor-fold>
public static /*inline*/ raw_ostream /*&*/ $out_raw_ostream_Type(final raw_ostream /*&*/ OS, final Type /*&*/ T) {
  T.print(OS);
  return OS;
}


// Create wrappers for C Binding types (see CBindingWrapping.h).
//<editor-fold defaultstate="collapsed" desc="llvm::unwrap">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Type.h", line = 458,
 FQN="llvm::unwrap", NM="_ZN4llvm6unwrapEP14LLVMOpaqueType",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZN4llvm6unwrapEP14LLVMOpaqueType")
//</editor-fold>
public static /*inline*/ Type /*P*/ unwrap_LLVMOpaqueType$P( LLVMOpaqueType /*P*/ P) {
  return reinterpret_cast(Type /*P*/ .class, P);
}

//<editor-fold defaultstate="collapsed" desc="llvm::wrap">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Type.h", line = 458,
 FQN="llvm::wrap", NM="_ZN4llvm4wrapEPKNS_4TypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZN4llvm4wrapEPKNS_4TypeE")
//</editor-fold>
public static /*inline*/  LLVMOpaqueType /*P*/ wrap_Type$C$P(/*const*/ Type /*P*/ P) {
  return reinterpret_cast( LLVMOpaqueType /*P*/ .class, ((/*const_cast*/Type /*P*/ )(P)));
}

/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::unwrap">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Type.h", line = 458,
 FQN="llvm::unwrap", NM="Tpl__ZN4llvm6unwrapEP14LLVMOpaqueType",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=Tpl__ZN4llvm6unwrapEP14LLVMOpaqueType")
//</editor-fold>
public static /*inline*/ </*typename*/ T> T /*P*/ unwrap_LLVMOpaqueType$P(Class<T> cls, LLVMOpaqueType /*P*/ P) {
  return cast(cls, IrLlvmGlobals.unwrap_LLVMOpaqueType$P(P));
}


/* Specialized opaque type conversions.
*/
//<editor-fold defaultstate="collapsed" desc="llvm::unwrap">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Type.h", line = 462,
 FQN="llvm::unwrap", NM="_ZN4llvm6unwrapEPP14LLVMOpaqueType",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZN4llvm6unwrapEPP14LLVMOpaqueType")
//</editor-fold>
public static /*inline*/ type$ptr<Type /*P*/ /*P*/> unwrap_type$ptr$LLVMOpaqueType$P$P(type$ptr<LLVMOpaqueType /*P*/ /*P*/> Tys) {
  return ((type$ptr<Type /*P*/ /*P*/>)reinterpret_cast(type$ptr.class, Tys));
}

//<editor-fold defaultstate="collapsed" desc="llvm::wrap">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Type.h", line = 466,
 FQN="llvm::wrap", NM="_ZN4llvm4wrapEPPNS_4TypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZN4llvm4wrapEPPNS_4TypeE")
//</editor-fold>
public static /*inline*/ type$ptr<LLVMOpaqueType /*P*/ /*P*/> wrap_type$ptr$Type$P$P(type$ptr<Type /*P*/ /*P*/> Tys) {
  return ((type$ptr<LLVMOpaqueType /*P*/ /*P*/>)reinterpret_cast(type$ptr.class, ((/*const_cast*/type$ptr<Type /*P*/ /*P*/>)(Tys))));
}

} // END OF class TypeLlvmGlobals
