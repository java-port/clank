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

package org.llvm.support.sys;

import org.clank.support.Converted;
import org.clank.support.Native;
import static org.llvm.support.sys.sys.*;

/// \brief Represents a closed range of Unicode code points [Lower, Upper].
//<editor-fold defaultstate="collapsed" desc="llvm::sys::UnicodeCharRange">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/Support/UnicodeCharRanges.h", line = 27,
 FQN = "llvm::sys::UnicodeCharRange", NM = "_ZN4llvm3sys16UnicodeCharRangeE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN4llvm3sys16UnicodeCharRangeE")
//</editor-fold>
public final class/*struct*/ UnicodeCharRange implements Native.OpCapable {
  public final int/*uint32_t*/ Lower;
  public final int/*uint32_t*/ Upper;
  //<editor-fold defaultstate="collapsed" desc="llvm::sys::UnicodeCharRange::UnicodeCharRange">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/UnicodeCharRanges.h", line = 27,
   FQN = "llvm::sys::UnicodeCharRange::UnicodeCharRange", NM = "_ZN4llvm3sys16UnicodeCharRangeC1ERKS1_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN4llvm3sys16UnicodeCharRangeC1ERKS1_")
  //</editor-fold>
  public /*inline*/ UnicodeCharRange(/*const*/ UnicodeCharRange /*&*/ $Prm0)/* throw()*/ {
    /* : Lower(.Lower), Upper(.Upper)*/ 
    //START JInit
    this.Lower = $Prm0.Lower;
    this.Upper = $Prm0.Upper;
    //END JInit
  }
  
  public UnicodeCharRange(int/*uint32_t*/ Lower, int/*uint32_t*/ Upper) {
    this.Lower = Lower;
    this.Upper = Upper;
  }

  @Override
  public Boolean $op(Op k, Object obj) {
    // support this < obj
    if (k == Op.LESS) {
      if (obj instanceof Number) {
        return $less_UnicodeCharRange_uint32_t(this, ((Number) obj).intValue());
      }
    } else if (k == Op.GREATER) {
      if (obj instanceof Number) {
        return $less_uint32_t_UnicodeCharRange(((Number) obj).intValue(), this);
      }
    }
    throw new UnsupportedOperationException(k + " against " + obj.getClass());
  }

  @Override
  public String toString() {
    return "UnicodeCharRange{" + "Lower=" + Lower + ", Upper=" + Upper + '}';
  }
}
