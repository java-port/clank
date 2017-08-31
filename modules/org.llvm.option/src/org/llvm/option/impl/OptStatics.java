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

package org.llvm.option.impl;

import static org.clank.support.Native.$Deref;
import static org.clank.support.Native.$AddrOf;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.java.std.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.option.*;
import static org.llvm.option.impl.OptStatics.*;


//<editor-fold defaultstate="collapsed" desc="static type OptStatics">
@Converted(kind = Converted.Kind.AUTO, cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType -java-types-map=${SPUTNIK}/contrib/JConvert/llvmToClankType -print ${LLVM_SRC}/llvm/lib/Option/OptTable.cpp -nm=_ZN4llvm3optL26StrCmpOptionNameIgnoreCaseEPKcS2_;_ZN4llvm3optL16StrCmpOptionNameEPKcS2_;_ZN4llvm3optltERKNS0_8OptTable4InfoES4_;_ZN4llvm3optltERKNS0_8OptTable4InfoEPKc; -static-type=OptStatics")
//</editor-fold>
public final class OptStatics {


// Ordering on Info. The ordering is *almost* case-insensitive lexicographic,
// with an exceptions. '\0' comes at the end of the alphabet instead of the
// beginning (thus options precede any other options which prefix them).
//<editor-fold defaultstate="collapsed" desc="llvm::opt::StrCmpOptionNameIgnoreCase">
@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/lib/Option/OptTable.cpp", line = 29,
 FQN = "llvm::opt::StrCmpOptionNameIgnoreCase", NM = "_ZN4llvm3optL26StrCmpOptionNameIgnoreCaseEPKcS2_",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/OptTable.cpp -nm=_ZN4llvm3optL26StrCmpOptionNameIgnoreCaseEPKcS2_")
//</editor-fold>
public static int StrCmpOptionNameIgnoreCase(/*const*/char$ptr/*char P*/ A, /*const*/char$ptr/*char P*/ B) {
  /*const*/char$ptr/*char P*/ X = $tryClone(A), /*P*/ Y = $tryClone(B);
  /*char*/byte a = (byte) tolower(A.$star()), b = (byte) tolower(B.$star());
  while (a == b) {
    if (a == '\0') {
      return 0;
    }
    
    a = (byte) tolower(X.$preInc().$star());
    b = (byte) tolower(Y.$preInc().$star());
  }
  if (a == '\0') {
    // A is a prefix of B.
    return 1;
  }
  if (b == '\0') {
    // B is a prefix of A.
    return -1;
  }
  
  // Otherwise lexicographic.
  return (a < b) ? -1 : 1;
}

//<editor-fold defaultstate="collapsed" desc="llvm::opt::StrCmpOptionName">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Option/OptTable.cpp", line = 50,
 FQN = "llvm::opt::StrCmpOptionName", NM = "_ZN4llvm3optL16StrCmpOptionNameEPKcS2_",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/OptTable.cpp -nm=_ZN4llvm3optL16StrCmpOptionNameEPKcS2_")
//</editor-fold>
public static int StrCmpOptionName(/*const*/char$ptr/*char P*/ A, /*const*/char$ptr/*char P*/ B) {
  {
    int N = StrCmpOptionNameIgnoreCase(A, B);
    if ((N != 0)) {
      return N;
    }
  }
  return strcmp(A, B);
}

//<editor-fold defaultstate="collapsed" desc="llvm::opt::operator<">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Option/OptTable.cpp", line = 56,
 FQN = "llvm::opt::operator<", NM = "_ZN4llvm3optltERKNS0_8OptTable4InfoES4_",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/OptTable.cpp -nm=_ZN4llvm3optltERKNS0_8OptTable4InfoES4_")
//</editor-fold>
public static /*inline*/ boolean $less_Info(/*const*/OptTable.Info /*&*/ A, /*const*/OptTable.Info /*&*/ B) {
  if ($AddrOf(A) == $AddrOf(B)) {
    return false;
  }
  {
    
    int N = StrCmpOptionName(A.Name, B.Name);
    if ((N != 0)) {
      return N < 0;
    }
  }
  
  for (/*const*/type$ptr<char$ptr>/*char P const P*/ APre = $tryClone(A.Prefixes), /*P*/ /*const*/ /*P*/ BPre = $tryClone(B.Prefixes); APre.$star() != null && BPre.$star() != null; APre.$preInc() , BPre.$preInc()) {
    {
      int N = StrCmpOptionName(APre.$star(), BPre.$star());
      if ((N != 0)) {
        return N < 0;
      }
    }
  }
  
  // Names are the same, check that classes are in order; exactly one
  // should be joined, and it should succeed the other.
  assert ((((($uchar2int(A.Kind) == Option.OptionClass.JoinedClass) ? 1 : 0) ^ (($uchar2int(B.Kind) == Option.OptionClass.JoinedClass) ? 1 : 0)) != 0)) : "Unexpected classes for options with same name.";
  return B.Kind == Option.OptionClass.JoinedClass;
}


// Support lower_bound between info and an option name.
//<editor-fold defaultstate="collapsed" desc="llvm::opt::operator<">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/lib/Option/OptTable.cpp", line = 79,
 FQN = "llvm::opt::operator<", NM = "_ZN4llvm3optltERKNS0_8OptTable4InfoEPKc",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.option/llvmToClangType ${LLVM_SRC}/llvm/lib/Option/OptTable.cpp -nm=_ZN4llvm3optltERKNS0_8OptTable4InfoEPKc")
//</editor-fold>
public static /*inline*/ boolean $less_Info_char$ptr$C(/*const*/OptTable.Info /*&*/ I, /*const*/char$ptr/*char P*/ Name) {
  return StrCmpOptionNameIgnoreCase(I.Name, Name) < 0;
}

} // END OF class OptStatics
