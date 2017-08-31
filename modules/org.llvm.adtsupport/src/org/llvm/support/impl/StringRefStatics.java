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

package org.llvm.support.impl;

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;


//<editor-fold defaultstate="collapsed" desc="static type StringRefStatics">
@Converted(kind = Converted.Kind.AUTO, cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -java-types-map=${SPUTNIK}/contrib/JConvert/llvmToClankType -print ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -nm=_ZL13ascii_toupperc;_ZL13ascii_isdigitc;_ZL13ascii_tolowerc;_ZL17GetAutoSenseRadixRN4llvm9StringRefE;_ZL17ascii_strncasecmpPKcS0_j; -static-type=StringRefStatics")
//</editor-fold>
public final class StringRefStatics {

//<editor-fold defaultstate="collapsed" desc="ascii_tolower">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/StringRef.cpp", line = 23,
 FQN = "ascii_tolower", NM = "_ZL13ascii_tolowerc",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -nm=_ZL13ascii_tolowerc")
//</editor-fold>
public static /*char*/byte ascii_tolower(/*char*/byte x) {
  if (x >= $$A && x <= $$Z) {
    return (byte)(x - $$A + $$a);
  }
  return x;
}

//<editor-fold defaultstate="collapsed" desc="ascii_toupper">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/StringRef.cpp", line = 29,
 FQN = "ascii_toupper", NM = "_ZL13ascii_toupperc",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -nm=_ZL13ascii_toupperc")
//</editor-fold>
public static /*char*/byte ascii_toupper(/*char*/byte x) {
  if (x >= $$a && x <= $$z) {
    return (byte)(x - $$a + $$A);
  }
  return x;
}

//<editor-fold defaultstate="collapsed" desc="ascii_isdigit">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/StringRef.cpp", line = 35,
 FQN = "ascii_isdigit", NM = "_ZL13ascii_isdigitc",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -nm=_ZL13ascii_isdigitc")
//</editor-fold>
public static boolean ascii_isdigit(/*char*/byte x) {
  return x >= $$0 && x <= $$9;
}


// strncasecmp() is not available on non-POSIX systems, so define an
// alternative function here.
//<editor-fold defaultstate="collapsed" desc="ascii_strncasecmp">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/StringRef.cpp", line = 41,
 FQN = "ascii_strncasecmp", NM = "_ZL17ascii_strncasecmpPKcS0_j",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -nm=_ZL17ascii_strncasecmpPKcS0_j")
//</editor-fold>
public static int ascii_strncasecmp(/*const*/char$ptr/*char P*/ LHS, /*const*/char$ptr/*char P*/ RHS, /*size_t*/int Length) {
  return ascii_strncasecmp(LHS, 0, RHS, 0, Length);
}
public static int ascii_strncasecmp(/*const*/char$ptr/*char P*/ LHS, /*uint*/int LhsIdx, /*const*/char$ptr/*char P*/ RHS, /*uint*/int RhsIdx, /*size_t*/int Length) {
  for (/*size_t*/int I = 0; I < Length; ++I, ++LhsIdx, ++RhsIdx) {
    /*uchar*/byte LHC = ascii_tolower(LHS.$at(LhsIdx));
    /*uchar*/byte RHC = ascii_tolower(RHS.$at(RhsIdx));
    if (LHC != RHC) {
      return $less_uchar(LHC, RHC) ? -1 : 1;
    }
  }
  return 0;
}

public static int ascii_strncasecmp(/*const*/char$ptr/*char P*/ LHS, /*const*/String/*char P*/ RHS, /*size_t*/int Length) {
  return ascii_strncasecmp(LHS, 0, RHS, 0, Length);
}
public static int ascii_strncasecmp(/*const*/char$ptr/*char P*/ LHS, /*uint*/int LhsIdx, /*const*/String/*char P*/ RHS, /*uint*/int RhsIdx, /*size_t*/int Length) {
  for (/*size_t*/int I = 0; I < Length; ++I, ++LhsIdx, ++RhsIdx) {
    /*uchar*/byte LHC = ascii_tolower(LHS.$at(LhsIdx));
    /*uchar*/byte RHC = ascii_tolower($(RHS.charAt(RhsIdx)));
    if (LHC != RHC) {
      return $less_uchar(LHC, RHC) ? -1 : 1;
    }
  }
  return 0;
}

//<editor-fold defaultstate="collapsed" desc="GetAutoSenseRadix">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Support/StringRef.cpp", line = 353,
 old_source = "${LLVM_SRC}/llvm/lib/Support/StringRef.cpp", old_line = 314,
 FQN = "GetAutoSenseRadix", NM = "_ZL17GetAutoSenseRadixRN4llvm9StringRefE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/StringRef.cpp -nm=_ZL17GetAutoSenseRadixRN4llvm9StringRefE")
//</editor-fold>
public static /*uint*/int GetAutoSenseRadix(StringRef /*&*/ Str) {
  if (Str.startswith("0x")) {
    Str.$assign$substr(2);
    return 16;
  }
  if (Str.startswith("0b")) {
    Str.$assign$substr(2);
    return 2;
  }
  if (Str.startswith("0o")) {
    Str.$assign$substr(2);
    return 8;
  }
  if (Str.startswith("0")) {
    return 8;
  }
  
  return 10;
}

public static void swap(StringRef str1, StringRef str2) {
  StringRef str3 = new StringRef(str2);
  str2.$assign(str1);
  str1.$assign(str3);
}

} // END OF class StringRefStatics
