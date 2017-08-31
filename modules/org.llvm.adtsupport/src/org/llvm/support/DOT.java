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

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.NativePointer.*;
import org.llvm.adt.*;


//<editor-fold defaultstate="collapsed" desc="static type DOT">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/GraphWriter.cpp -nm=_ZN4llvm3DOT12EscapeStringERKSs;_ZN4llvm3DOT14getColorStringEj; -static-type=DOT")
//</editor-fold>
public final class DOT {

// Private functions...
//<editor-fold defaultstate="collapsed" desc="llvm::DOT::EscapeString">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/GraphWriter.cpp", line = 24,
 old_source = "${LLVM_SRC}/llvm/lib/Support/GraphWriter.cpp", old_line = 25,
 FQN = "llvm::DOT::EscapeString", NM = "_ZN4llvm3DOT12EscapeStringERKSs",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/GraphWriter.cpp -nm=_ZN4llvm3DOT12EscapeStringERKSs")
//</editor-fold>
public static std.string EscapeString(/*const*/std.string/*&*/ Label) {
  std.string Str = null;
  try {
    Str/*J*/= new std.string(Label);
    for (/*uint*/int i = 0; i != Str.length(); ++i)  {
      switch (Str.$at(i)) {
       case '\n':
        Str.insert(Str.begin().$add(i), '\\'); // Escape character...
        ++i;
        Str.$set(i, $('n'));
        break;
       case '\t':
        Str.insert(Str.begin().$add(i), ' '); // Convert to two spaces
        ++i;
        Str.$set(i, $(' '));
        break;
       case '\\':
        if (i + 1 != Str.length()) {
          switch (Str.$at(i + 1)) {
           case 'l':
            continue; // don't disturb \l
           case '|':
           case '{':
           case '}':
            Str.erase(Str.begin().$add(i));
            continue;
           default:
            break;
          }
        }
       case '{':
       case '}':
       case '<':
       case '>':
       case '|':
       case '"':
        Str.insert(Str.begin().$add(i), '\\'); // Escape character...
        ++i; // don't infinite loop
        break;
      }
    }
    return new std.string(JD$Move.INSTANCE, Str);
  } finally {
    if (Str != null) { Str.$destroy(); }
  }
}


/// \brief Get a color string for this node number. Simply round-robin selects
/// from a reasonable number of colors.

/// \brief Get a color string for this node number. Simply round-robin selects
/// from a reasonable number of colors.
//<editor-fold defaultstate="collapsed" desc="llvm::DOT::getColorString">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/lib/Support/GraphWriter.cpp", line = 58,
 old_source = "${LLVM_SRC}/llvm/lib/Support/GraphWriter.cpp", old_line = 59,
 FQN = "llvm::DOT::getColorString", NM = "_ZN4llvm3DOT14getColorStringEj",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/GraphWriter.cpp -nm=_ZN4llvm3DOT14getColorStringEj")
//</editor-fold>
public static StringRef getColorString(/*uint*/int ColorNumber) {
  throw new UnsupportedOperationException("EmptyBody");
}

} // END OF class DOT
