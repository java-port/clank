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


//<editor-fold defaultstate="collapsed" desc="static type IrLlvmStatics">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.llvm.ir.impl.IrLlvmStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -body-delegate -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp ${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.cpp -nm=Tpl__ZN4llvmL10getUniquedERNS_8DenseSetIPT_T0_EERKNS3_5KeyTyE;_ZN4llvm25ConstantFoldGetElementPtrEPNS_4TypeEPNS_8ConstantEbNS_8ArrayRefIPNS_5ValueEEE;_ZN4llvm25ConstantFoldGetElementPtrEPNS_4TypeEPNS_8ConstantEbNS_8ArrayRefIS3_EE;_ZN4llvm27ConstantFoldCastInstructionEjPNS_8ConstantEPNS_4TypeE;_ZN4llvm29ConstantFoldBinaryInstructionEjPNS_8ConstantES1_;_ZN4llvm29ConstantFoldSelectInstructionEPNS_8ConstantES1_S1_;_ZN4llvm30ConstantFoldCompareInstructionEtPNS_8ConstantES1_;_ZN4llvm34ConstantFoldInsertValueInstructionEPNS_8ConstantES1_NS_8ArrayRefIjEE;_ZN4llvm35ConstantFoldExtractValueInstructionEPNS_8ConstantENS_8ArrayRefIjEE;_ZN4llvm36ConstantFoldInsertElementInstructionEPNS_8ConstantES1_S1_;_ZN4llvm36ConstantFoldShuffleVectorInstructionEPNS_8ConstantES1_S1_;_ZN4llvm37ConstantFoldExtractElementInstructionEPNS_8ConstantES1_;_ZN4llvmL17get_hashable_dataERKNS_9MDOperandE; -static-type=IrLlvmStatics -package=org.llvm.ir.impl")
//</editor-fold>
public final class IrLlvmStatics {

/*template <class T, class InfoT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::getUniqued">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/IR/MetadataImpl.h", line = 23,
 FQN="llvm::getUniqued", NM="Tpl__ZN4llvmL10getUniquedERNS_8DenseSetIPT_T0_EERKNS3_5KeyTyE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/DebugInfoMetadata.cpp -nm=Tpl__ZN4llvmL10getUniquedERNS_8DenseSetIPT_T0_EERKNS3_5KeyTyE")
//</editor-fold>
public static </*class*/ T, /*class*/ KeyTy> T /*P*/ getUniqued(final DenseSet<T /*P , InfoT*/> /*&*/ Store, 
          final /*const*/  KeyTy /*&*/ Key) {
  return /*delegate*/org.llvm.ir.impl.MetadataImplLlvmStatics.
    getUniqued(Store, 
          Key);
}

/// \brief Make MDOperand transparent for hashing.
///
/// This overload of an implementation detail of the hashing library makes
/// MDOperand hash to the same value as a \a Metadata pointer.
///
/// Note that overloading \a hash_value() as follows:
///
/// \code
///     size_t hash_value(const MDOperand &X) { return hash_value(X.get()); }
/// \endcode
///
/// does not cause MDOperand to be transparent.  In particular, a bare pointer
/// doesn't get hashed before it's combined, whereas \a MDOperand would.
//<editor-fold defaultstate="collapsed" desc="llvm::get_hashable_data">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.cpp", line = 179,
 FQN="llvm::get_hashable_data", NM="_ZN4llvmL17get_hashable_dataERKNS_9MDOperandE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/LLVMContextImpl.cpp -nm=_ZN4llvmL17get_hashable_dataERKNS_9MDOperandE")
//</editor-fold>
public static /*const*/ Metadata /*P*/ get_hashable_data(final /*const*/ MDOperand /*&*/ X) {
  return /*delegate*/org.llvm.ir.impl.LLVMContextImplLlvmStatics.
    get_hashable_data(X);
}

} // END OF class IrLlvmStatics
