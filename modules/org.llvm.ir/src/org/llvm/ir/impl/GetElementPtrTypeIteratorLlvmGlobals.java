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
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import static org.llvm.ir.java.IrRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type GetElementPtrTypeIteratorLlvmGlobals">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.llvm.ir.impl.GetElementPtrTypeIteratorLlvmGlobals",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/ArgumentPromotion.cpp -nm=Tpl__ZN4llvm12gep_type_endEPNS_4TypeEjNS_8ArrayRefIT_EE;Tpl__ZN4llvm14gep_type_beginEPNS_4TypeEjNS_8ArrayRefIT_EE;_ZN4llvm12gep_type_endEPKNS_4UserE;_ZN4llvm12gep_type_endERKNS_4UserE;_ZN4llvm14gep_type_beginEPKNS_4UserE;_ZN4llvm14gep_type_beginERKNS_4UserE; -static-type=GetElementPtrTypeIteratorLlvmGlobals -package=org.llvm.ir.impl")
//</editor-fold>
public final class GetElementPtrTypeIteratorLlvmGlobals {

//<editor-fold defaultstate="collapsed" desc="llvm::gep_type_begin">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/GetElementPtrTypeIterator.h", line = 97,
 FQN="llvm::gep_type_begin", NM="_ZN4llvm14gep_type_beginEPKNS_4UserE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/ArgumentPromotion.cpp -nm=_ZN4llvm14gep_type_beginEPKNS_4UserE")
//</editor-fold>
public static /*inline*/ generic_gep_type_iterator gep_type_begin_User$C$P(/*const*/ User /*P*/ GEP) {
  /*const*/ GEPOperator /*P*/ GEPOp = cast_GEPOperator(GEP);
  return generic_gep_type_iterator.begin(GEPOp.getSourceElementType(), 
      cast_PointerType(GEPOp.getPointerOperandType().getScalarType()).
          getAddressSpace(), 
      GEP.op_begin$Const().$add(1));
}

//<editor-fold defaultstate="collapsed" desc="llvm::gep_type_end">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/GetElementPtrTypeIterator.h", line = 105,
 FQN="llvm::gep_type_end", NM="_ZN4llvm12gep_type_endEPKNS_4UserE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/ArgumentPromotion.cpp -nm=_ZN4llvm12gep_type_endEPKNS_4UserE")
//</editor-fold>
public static /*inline*/ generic_gep_type_iterator gep_type_end_User$C$P(/*const*/ User /*P*/ GEP) {
  return generic_gep_type_iterator.end(GEP.op_end$Const());
}

//<editor-fold defaultstate="collapsed" desc="llvm::gep_type_begin">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/GetElementPtrTypeIterator.h", line = 108,
 FQN="llvm::gep_type_begin", NM="_ZN4llvm14gep_type_beginERKNS_4UserE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/ArgumentPromotion.cpp -nm=_ZN4llvm14gep_type_beginERKNS_4UserE")
//</editor-fold>
public static /*inline*/ generic_gep_type_iterator gep_type_begin_User$C(final /*const*/ User /*&*/ GEP) {
  final /*const*/ GEPOperator /*&*/ GEPOp = cast_GEPOperator(GEP);
  return generic_gep_type_iterator.begin(GEPOp.getSourceElementType(), 
      cast_PointerType(GEPOp.getPointerOperandType().getScalarType()).
          getAddressSpace(), 
      GEP.op_begin$Const().$add(1));
}

//<editor-fold defaultstate="collapsed" desc="llvm::gep_type_end">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/GetElementPtrTypeIterator.h", line = 116,
 FQN="llvm::gep_type_end", NM="_ZN4llvm12gep_type_endERKNS_4UserE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/ArgumentPromotion.cpp -nm=_ZN4llvm12gep_type_endERKNS_4UserE")
//</editor-fold>
public static /*inline*/ generic_gep_type_iterator gep_type_end_User$C(final /*const*/ User /*&*/ GEP) {
  return generic_gep_type_iterator.end(GEP.op_end$Const());
}

/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::gep_type_begin">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/GetElementPtrTypeIterator.h", line = 121,
 FQN="llvm::gep_type_begin", NM="Tpl__ZN4llvm14gep_type_beginEPNS_4TypeEjNS_8ArrayRefIT_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/ArgumentPromotion.cpp -nm=Tpl__ZN4llvm14gep_type_beginEPNS_4TypeEjNS_8ArrayRefIT_EE")
//</editor-fold>
public static /*inline*/ </*typename*/ T> generic_gep_type_iterator</*const*/ T /*P*/ > gep_type_begin$T(Type /*P*/ Op0, /*uint*/int AS, ArrayRef<T> A) {
  return generic_gep_type_iterator.</*const*/ T /*P*/ >begin(Op0, AS, A.begin());
}

/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::gep_type_end">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/GetElementPtrTypeIterator.h", line = 127,
 FQN="llvm::gep_type_end", NM="Tpl__ZN4llvm12gep_type_endEPNS_4TypeEjNS_8ArrayRefIT_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/ArgumentPromotion.cpp -nm=Tpl__ZN4llvm12gep_type_endEPNS_4TypeEjNS_8ArrayRefIT_EE")
//</editor-fold>
public static /*inline*/ </*typename*/ T> generic_gep_type_iterator</*const*/ T /*P*/ > gep_type_end$T(Type /*P*/ $Prm0/*Op0*/, /*uint*/int $Prm1/*AS*/, ArrayRef<T> A) {
  return generic_gep_type_iterator.</*const*/ T /*P*/ >end(A.end());
}

} // END OF class GetElementPtrTypeIteratorLlvmGlobals
