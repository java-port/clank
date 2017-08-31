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
package org.llvm.mc.impl;

import org.clank.support.*;
import static org.clank.support.Unsigned.*;
import org.llvm.mc.*;


//<editor-fold defaultstate="collapsed" desc="static type MCFragmentLlvmGlobals">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.llvm.mc.impl.MCFragmentLlvmGlobals",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp -nm=_ZN4llvm20computeBundlePaddingERKNS_11MCAssemblerEPKNS_10MCFragmentEyy; -static-type=MCFragmentLlvmGlobals -package=org.llvm.mc.impl")
//</editor-fold>
public final class MCFragmentLlvmGlobals {


/// \brief Compute the amount of padding required before the fragment \p F to
/// obey bundling restrictions, where \p FOffset is the fragment's offset in
/// its section and \p FSize is the fragment's size.
//<editor-fold defaultstate="collapsed" desc="llvm::computeBundlePadding">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp", line = 191,
 old_source = "${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp", old_line = 192,
 FQN="llvm::computeBundlePadding", NM="_ZN4llvm20computeBundlePaddingERKNS_11MCAssemblerEPKNS_10MCFragmentEyy",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCFragment.cpp -nm=_ZN4llvm20computeBundlePaddingERKNS_11MCAssemblerEPKNS_10MCFragmentEyy")
//</editor-fold>
public static long/*uint64_t*/ computeBundlePadding(final /*const*/ MCAssembler /*&*/ Assembler, 
                    /*const*/ MCFragment /*P*/ F, 
                    long/*uint64_t*/ FOffset, long/*uint64_t*/ FSize) {
  long/*uint64_t*/ BundleSize = $uint2ulong(Assembler.getBundleAlignSize());
  assert ($greater_ulong_ullong(BundleSize, $int2ullong(0))) : "computeBundlePadding should only be called if bundling is enabled";
  long/*uint64_t*/ BundleMask = BundleSize - $int2ullong(1);
  long/*uint64_t*/ OffsetInBundle = FOffset & BundleMask;
  long/*uint64_t*/ EndOfFragment = OffsetInBundle + FSize;
  
  // There are two kinds of bundling restrictions:
  //
  // 1) For alignToBundleEnd(), add padding to ensure that the fragment will
  //    *end* on a bundle boundary.
  // 2) Otherwise, check if the fragment would cross a bundle boundary. If it
  //    would, add padding until the end of the bundle so that the fragment
  //    will start in a new one.
  if (F.alignToBundleEnd()) {
    // Three possibilities here:
    //
    // A) The fragment just happens to end at a bundle boundary, so we're good.
    // B) The fragment ends before the current bundle boundary: pad it just
    //    enough to reach the boundary.
    // C) The fragment ends after the current bundle boundary: pad it until it
    //    reaches the end of the next bundle boundary.
    //
    // Note: this code could be made shorter with some modulo trickery, but it's
    // intentionally kept in its more explicit form for simplicity.
    if (EndOfFragment == BundleSize) {
      return $int2ulong(0);
    } else if ($less_ulong(EndOfFragment, BundleSize)) {
      return BundleSize - EndOfFragment;
    } else { // EndOfFragment > BundleSize
      return $int2ullong(2) * BundleSize - EndOfFragment;
    }
  } else if ($greater_ulong_ullong(OffsetInBundle, $int2ullong(0)) && $greater_ulong(EndOfFragment, BundleSize)) {
    return BundleSize - OffsetInBundle;
  } else {
    return $int2ulong(0);
  }
}

} // END OF class MCFragmentLlvmGlobals
