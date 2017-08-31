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

package org.llvm.support;

import org.clank.support.*;
import org.clank.support.aliases.*;
import org.llvm.support.*;

/*template <typename T1, typename T2, typename T3, typename T4, typename T5> TEMPLATE*/

/// format_object5 - This is a templated helper class used by the format
/// function that captures the object to be formated and the format string. When
/// actually printed, this synthesizes the string into a temporary buffer
/// provided and returns whether or not it is big enough.
//<editor-fold defaultstate="collapsed" desc="llvm::format_object5">
@Converted(kind = Converted.Kind.DELETED, source = "${LLVM_SRC}/llvm/include/llvm/Support/Format.h", line = 142,
 FQN = "llvm::format_object5", NM = "_ZN4llvm14format_object5E",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MD5.cpp -filter=llvm::format_object5")
//</editor-fold>
public class format_object5</*typename*/ T1, /*typename*/ T2, /*typename*/ T3, /*typename*/ T4, /*typename*/ T5>  extends /*public*/ format_object_base implements Destructors.ClassWithDestructor {
  private T1 Val1;
  private T2 Val2;
  private T3 Val3;
  private T4 Val4;
  private T5 Val5;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::format_object5::format_object5<T1, T2, T3, T4, T5>">
  @Converted(kind = Converted.Kind.DELETED, source = "${LLVM_SRC}/llvm/include/llvm/Support/Format.h", line = 150,
   FQN = "llvm::format_object5::format_object5<T1, T2, T3, T4, T5>", NM = "_ZN4llvm14format_object5C1EPKcRKT_RKT0_RKT1_RKT2_RKT3_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MD5.cpp -filter=llvm::format_object5::format_object5<T1, T2, T3, T4, T5>")
  //</editor-fold>
  public format_object5(/*const*/char$ptr/*char P*/ fmt, /*const*/T1 /*&*/ val1, /*const*/T2 /*&*/ val2, /*const*/T3 /*&*/ val3, /*const*/T4 /*&*/ val4, /*const*/T5 /*&*/ val5) {
    /* : format_object_base(fmt), Val1(val1), Val2(val2), Val3(val3), Val4(val4), Val5(val5)*/ 
    super(fmt);
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::format_object5::snprint">
  @Converted(kind = Converted.Kind.DELETED, source = "${LLVM_SRC}/llvm/include/llvm/Support/Format.h", line = 156,
   FQN = "llvm::format_object5::snprint", NM = "_ZNK4llvm14format_object57snprintEPcj",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/MD5.cpp -filter=llvm::format_object5::snprint")
  //</editor-fold>
  @Override public /*virtual*/ int snprint(char$ptr/*char P*/ Buffer, /*uint*/int BufferSize) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

}
