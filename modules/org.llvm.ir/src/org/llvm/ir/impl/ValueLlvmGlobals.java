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

import org.clank.java.std;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.Casts.*;
import org.llvm.llvmc.*;
import static org.llvm.support.llvm.*;
import org.llvm.support.*;
import org.llvm.ir.*;
import org.llvm.pass.*;


//<editor-fold defaultstate="collapsed" desc="static type ValueLlvmGlobals">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.llvm.ir.impl.ValueLlvmGlobals",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Value.cpp -nm=Tpl__ZN4llvm6unwrapEP15LLVMOpaqueValue;Tpl__ZN4llvm6unwrapEPP15LLVMOpaqueValuej;_ZN4llvm4wrapEPKNS_5ValueE;_ZN4llvm4wrapEPPKNS_5ValueE;_ZN4llvm6unwrapEP15LLVMOpaqueValue;_ZN4llvm6unwrapEPP15LLVMOpaqueValue;_ZN4llvmlsERNS_11raw_ostreamERKNS_5ValueE; -static-type=ValueLlvmGlobals -package=org.llvm.ir.impl")
//</editor-fold>
public final class ValueLlvmGlobals {

//<editor-fold defaultstate="collapsed" desc="llvm::operator<<">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Value.h", line = 608,
 FQN="llvm::operator<<", NM="_ZN4llvmlsERNS_11raw_ostreamERKNS_5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Value.cpp -nm=_ZN4llvmlsERNS_11raw_ostreamERKNS_5ValueE")
//</editor-fold>
public static /*inline*/ raw_ostream /*&*/ $out_raw_ostream_Value$C(final raw_ostream /*&*/ OS, final /*const*/ Value /*&*/ V) {
  V.print(OS);
  return OS;
}


// Create wrappers for C Binding types (see CBindingWrapping.h).
//<editor-fold defaultstate="collapsed" desc="llvm::unwrap">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Value.h", line = 799,
 FQN="llvm::unwrap", NM="_ZN4llvm6unwrapEP15LLVMOpaqueValue",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Value.cpp -nm=_ZN4llvm6unwrapEP15LLVMOpaqueValue")
//</editor-fold>
public static /*inline*/ Value /*P*/ unwrap_LLVMOpaqueValue$P( LLVMOpaqueValue /*P*/ P) {
  return reinterpret_cast(Value /*P*/ .class, P);
}

//<editor-fold defaultstate="collapsed" desc="llvm::wrap">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Value.h", line = 799,
 FQN="llvm::wrap", NM="_ZN4llvm4wrapEPKNS_5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Value.cpp -nm=_ZN4llvm4wrapEPKNS_5ValueE")
//</editor-fold>
public static /*inline*/  LLVMOpaqueValue /*P*/ wrap_Value$C$P(/*const*/ Value /*P*/ P) {
  return reinterpret_cast( LLVMOpaqueValue /*P*/ .class, ((/*const_cast*/Value /*P*/ )(P)));
}

/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::unwrap">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Value.h", line = 799,
 FQN="llvm::unwrap", NM="Tpl__ZN4llvm6unwrapEP15LLVMOpaqueValue",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Value.cpp -nm=Tpl__ZN4llvm6unwrapEP15LLVMOpaqueValue")
//</editor-fold>
public static /*inline*/ </*typename*/ T> T /*P*/ unwrap_LLVMOpaqueValue$P(Class<T> cls,  LLVMOpaqueValue /*P*/ P) {
  return cast(cls, IrLlvmGlobals.unwrap_LLVMOpaqueValue$P(P));
}


// Specialized opaque value conversions.
//<editor-fold defaultstate="collapsed" desc="llvm::unwrap">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Value.h", line = 802,
 FQN="llvm::unwrap", NM="_ZN4llvm6unwrapEPP15LLVMOpaqueValue",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Value.cpp -nm=_ZN4llvm6unwrapEPP15LLVMOpaqueValue")
//</editor-fold>
public static /*inline*/ type$ptr<Value /*P*/ /*P*/> unwrap_type$ptr$LLVMOpaqueValue$P$P(type$ptr<LLVMOpaqueValue /*P*/ /*P*/> Vals) {
  return ((type$ptr<Value /*P*/ /*P*/>)reinterpret_cast(type$ptr.class, Vals));
}

/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::unwrap">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Value.h", line = 807,
 FQN="llvm::unwrap", NM="Tpl__ZN4llvm6unwrapEPP15LLVMOpaqueValuej",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Value.cpp -nm=Tpl__ZN4llvm6unwrapEPP15LLVMOpaqueValuej")
//</editor-fold>
public static /*inline*/ </*typename*/ T> type$ptr<T /*P*/ /*P*/> unwrap$T(Class<T> cls, type$ptr<LLVMOpaqueValue /*P*/ /*P*/> Vals, /*uint*/int Length) {
  ///*J:(void)*/Length;
  std.vector<T> res = new std.vector(Length, null);
  for(int i = 0; i < Length; i++) {
    res.push_back(reinterpret_cast(cls, Vals.$at(i)));
  }
  return res.data();
}

//<editor-fold defaultstate="collapsed" desc="llvm::wrap">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Value.h", line = 816,
 FQN="llvm::wrap", NM="_ZN4llvm4wrapEPPKNS_5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Value.cpp -nm=_ZN4llvm4wrapEPPKNS_5ValueE")
//</editor-fold>
public static /*inline*/ type$ptr<LLVMOpaqueValue /*P*/ /*P*/> wrap_type$ptr$Value$C$P$P(type$ptr</*const*/ Value /*P*/ /*P*/> Vals) {
  return ((type$ptr<LLVMOpaqueValue /*P*/ /*P*/>)reinterpret_cast(type$ptr.class, ((/*const_cast*/type$ptr<Value /*P*/ /*P*/>)(Vals))));
}

} // END OF class ValueLlvmGlobals
