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

package org.llvm.mc;

import org.clank.support.*;


/// Linker Optimization Hint Type.
//<editor-fold defaultstate="collapsed" desc="llvm::MCLOHType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/MC/MCLinkerOptimizationHint.h", line = 33,
 FQN="llvm::MCLOHType", NM="_ZN4llvm9MCLOHTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCLinkerOptimizationHint.cpp -nm=_ZN4llvm9MCLOHTypeE")
//</editor-fold>
public final class/*enum*/ MCLOHType {
  public static final /*uint*/int MCLOH_AdrpAdrp = 0x1/*U*/; ///< Adrp xY, _v1@PAGE -> Adrp xY, _v2@PAGE.
  public static final /*uint*/int MCLOH_AdrpLdr = 0x2/*U*/; ///< Adrp _v@PAGE -> Ldr _v@PAGEOFF.
  public static final /*uint*/int MCLOH_AdrpAddLdr = 0x3/*U*/; ///< Adrp _v@PAGE -> Add _v@PAGEOFF -> Ldr.
  public static final /*uint*/int MCLOH_AdrpLdrGotLdr = 0x4/*U*/; ///< Adrp _v@GOTPAGE -> Ldr _v@GOTPAGEOFF -> Ldr.
  public static final /*uint*/int MCLOH_AdrpAddStr = 0x5/*U*/; ///< Adrp _v@PAGE -> Add _v@PAGEOFF -> Str.
  public static final /*uint*/int MCLOH_AdrpLdrGotStr = 0x6/*U*/; ///< Adrp _v@GOTPAGE -> Ldr _v@GOTPAGEOFF -> Str.
  public static final /*uint*/int MCLOH_AdrpAdd = 0x7/*U*/; ///< Adrp _v@PAGE -> Add _v@PAGEOFF.
  public static final /*uint*/int MCLOH_AdrpLdrGot = 0x8/*U*/; ///< Adrp _v@GOTPAGE -> Ldr _v@GOTPAGEOFF.
}
