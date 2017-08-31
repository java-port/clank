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
import static org.clank.support.NativePointer.*;
import org.llvm.adt.StringRef;
import static org.llvm.support.llvm.*;

/**
 *
 * @author Vladimir Voskresensky
 */
public final class locale {

//<editor-fold defaultstate="collapsed" desc="llvm::sys::locale::columnWidth">
@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/lib/Support/Locale.cpp", line = 9,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Locale.cpp", old_line = 8,
 FQN = "llvm::sys::locale::columnWidth", NM = "_ZN4llvm3sys6locale11columnWidthENS_9StringRefE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Locale.cpp -nm=_ZN4llvm3sys6locale11columnWidthENS_9StringRefE")
//</editor-fold>
public static int columnWidth(StringRef Text) {
//#if LLVM_ON_WIN32
if (LLVM_ON_WIN32) {
  return (int) Text.size();
//#else  
} else {
  return unicode.columnWidthUTF8(Text);
}
//#endif
}


//<editor-fold defaultstate="collapsed" desc="llvm::sys::locale::isPrint">
@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/lib/Support/Locale.cpp", line = 17,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Locale.cpp", old_line = 16,
 FQN = "llvm::sys::locale::isPrint", NM = "_ZN4llvm3sys6locale7isPrintEi",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Locale.cpp -nm=_ZN4llvm3sys6locale7isPrintEi")
//</editor-fold>
public static boolean isPrint(int UCS) {
//#if LLVM_ON_WIN32  
if (LLVM_ON_WIN32) {
  // Restrict characters that we'll try to print to the the lower part of ASCII
  // except for the control characters (0x20 - 0x7E). In general one can not
  // reliably output code points U+0080 and higher using narrow character C/C++
  // output functions in Windows, because the meaning of the upper 128 codes is
  // determined by the active code page in the console.
  return ' ' <= UCS && UCS <= $('~');
//#else    
} else {
  return unicode.isPrintable(UCS);
}
//#endif    
}
  
}
