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
package org.llvm.analysis.bfi_detail;

import org.clank.java.*;
import org.clank.support.*;
import org.llvm.support.*;


//<editor-fold defaultstate="collapsed" desc="static type Bfi_detailGlobals">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 NM="org.llvm.analysis.bfi_detail.Bfi_detailGlobals",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp -nm=Tpl__ZN4llvm10bfi_detail12getBlockNameB5cxx11EPKT_;_ZN4llvm10bfi_detail12getBlockNameINS_10BasicBlockEEENSt7__cxx1112basic_stringIcSt11char_traitsIcESaIcEEEPKT_;_ZN4llvm10bfi_detaillsERNS_11raw_ostreamENS0_9BlockMassE;_ZN4llvm10bfi_detailmiENS0_9BlockMassES1_;_ZN4llvm10bfi_detailmlENS0_9BlockMassENS_17BranchProbabilityE;_ZN4llvm10bfi_detailmlENS_17BranchProbabilityENS0_9BlockMassE;_ZN4llvm10bfi_detailplENS0_9BlockMassES1_; -static-type=Bfi_detailGlobals -package=org.llvm.analysis.bfi_detail")
//</editor-fold>
public final class Bfi_detailGlobals {

//<editor-fold defaultstate="collapsed" desc="llvm::bfi_detail::operator+">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 129,
 FQN="llvm::bfi_detail::operator+", NM="_ZN4llvm10bfi_detailplENS0_9BlockMassES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp -nm=_ZN4llvm10bfi_detailplENS0_9BlockMassES1_")
//</editor-fold>
public static /*inline*/ BlockMass $add_BlockMass(BlockMass L, BlockMass R) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::bfi_detail::operator-">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 132,
 FQN="llvm::bfi_detail::operator-", NM="_ZN4llvm10bfi_detailmiENS0_9BlockMassES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp -nm=_ZN4llvm10bfi_detailmiENS0_9BlockMassES1_")
//</editor-fold>
public static /*inline*/ BlockMass $sub_BlockMass(BlockMass L, BlockMass R) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::bfi_detail::operator*">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 135,
 FQN="llvm::bfi_detail::operator*", NM="_ZN4llvm10bfi_detailmlENS0_9BlockMassENS_17BranchProbabilityE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp -nm=_ZN4llvm10bfi_detailmlENS0_9BlockMassENS_17BranchProbabilityE")
//</editor-fold>
public static /*inline*/ BlockMass $star_BlockMass_BranchProbability(BlockMass L, BranchProbability R) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::bfi_detail::operator*">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 138,
 FQN="llvm::bfi_detail::operator*", NM="_ZN4llvm10bfi_detailmlENS_17BranchProbabilityENS0_9BlockMassE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp -nm=_ZN4llvm10bfi_detailmlENS_17BranchProbabilityENS0_9BlockMassE")
//</editor-fold>
public static /*inline*/ BlockMass $star_BranchProbability_BlockMass(BranchProbability L, BlockMass R) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::bfi_detail::operator<<">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 142,
 FQN="llvm::bfi_detail::operator<<", NM="_ZN4llvm10bfi_detaillsERNS_11raw_ostreamENS0_9BlockMassE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp -nm=_ZN4llvm10bfi_detaillsERNS_11raw_ostreamENS0_9BlockMassE")
//</editor-fold>
public static /*inline*/ raw_ostream /*&*/ $out_raw_ostream_BlockMass(final raw_ostream /*&*/ OS, BlockMass X) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Get the name of a MachineBasicBlock.
///
/// Get the name of a MachineBasicBlock.  It's templated so that including from
/// CodeGen is unnecessary (that would be a layering issue).
///
/// This is used mainly for debug output.  The name is similar to
/// MachineBasicBlock::getFullName(), but skips the name of the function.
/*template <class BlockT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::bfi_detail::getBlockName">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 527,
 FQN="llvm::bfi_detail::getBlockName", NM="Tpl__ZN4llvm10bfi_detail12getBlockNameEPKT_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfoImpl.cpp -nm=Tpl__ZN4llvm10bfi_detail12getBlockNameEPKT_")
//</editor-fold>
public static </*class*/ BlockT> std.string getBlockName(/*const*/ BlockT /*P*/ BB) {
  throw new UnsupportedOperationException("EmptyBody");
}

} // END OF class Bfi_detailGlobals
