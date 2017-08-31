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

package org.clang.lex;

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import static org.clang.lex.impl.LiteralSupportStatics.*;


//<editor-fold defaultstate="collapsed" desc="static type LexClangGlobals">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Lex/LiteralSupport.cpp -nm=_Z5clang_HeaderMapTypes_h_Unnamed_enum;_ZN5clang10expandUCNsERN4llvm15SmallVectorImplIcEENS0_9StringRefE; -static-type=LexClangGlobals -package=org.clang.lex")
//</editor-fold>
public final class LexClangGlobals {

//<editor-fold defaultstate="collapsed" desc="clang::(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/HeaderMapTypes.h", line = 17,
 FQN="clang::(anonymous)", NM="_Z5clang_HeaderMapTypes_h_Unnamed_enum",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/HeaderMap.cpp -nm=_Z5clang_HeaderMapTypes_h_Unnamed_enum")
//</editor-fold>
/*enum ANONYMOUS_INT_CONSTANTS {*/
  public static final /*uint*/int HMAP_HeaderMagicNumber = ($$h << 24) | ($$m << 16) | ($$a << 8) | $$p;
  public static final /*uint*/int HMAP_HeaderVersion = 1;
  public static final /*uint*/int HMAP_EmptyBucketKey = 0;
/*}*/

/// Copy characters from Input to Buf, expanding any UCNs.
//<editor-fold defaultstate="collapsed" desc="clang::expandUCNs">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/LiteralSupport.cpp", line = 227,
 FQN = "clang::expandUCNs", NM = "_ZN5clang10expandUCNsERN4llvm15SmallVectorImplIcEENS0_9StringRefE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/LiteralSupport.cpp -nm=_ZN5clang10expandUCNsERN4llvm15SmallVectorImplIcEENS0_9StringRefE")
//</editor-fold>
public static void expandUCNs(SmallString/*&*/ Buf, StringRef Input) {
  for (char$ptr I = $tryClone(Input.begin()), /*P*/ E = $tryClone(Input.end()); I.$noteq(E); I.$preInc()) {
    if (I.$star() != $$BACK_SLASH) {
      Buf.push_back(I.$star());
      continue;
    }
    
    I.$preInc();
    assert (I.$star() == $$u || I.$star() == $$U);
    
    /*uint*/int NumHexDigits;
    if (I.$star() == $$u) {
      NumHexDigits = 4;
    } else {
      NumHexDigits = 8;
    }
    assert (I.$add(NumHexDigits).$lesseq(E));
    
    /*uint32_t*/int CodePoint = 0;
    for (I.$preInc(); NumHexDigits != 0; I.$preInc() , --NumHexDigits) {
      /*uint*/int Value = llvm.hexDigitValue(I.$star());
      assert (Value != -1/*U*/);
      
      CodePoint <<= 4;
      CodePoint += Value;
    }
    
    appendCodePoint(CodePoint, Buf);
    I.$preDec();
  }
}

} // END OF class LexClangGlobals
